package com.github.ericytsang.lib.simplifiedmap

import java.util.AbstractMap

interface SimplifiedMap<K,V:Any>:Map<K,V>
{
    operator fun set(key:K,value:V?):V?

    override val size:Int get() = keys.size

    fun put(key:K,value:V):V? = set(key,value)

    fun putAll(from:Map<out K,V>) = from.entries.forEach {put(it.key,it.value)}

    fun remove(key:K):V? = set(key,null)

    override fun containsKey(key:K):Boolean = key in keys

    override fun containsValue(value:V):Boolean = value in values

    override fun isEmpty():Boolean = size == 0

    fun clear() = keys.forEach {set(it,null)}

    override val values:Collection<V> get() = keys.map {get(it)!!}

    override val entries:Set<Map.Entry<K,V>> get() = keys.map {AbstractMap.SimpleEntry(it,get(it)!!)}.toSet()
}
