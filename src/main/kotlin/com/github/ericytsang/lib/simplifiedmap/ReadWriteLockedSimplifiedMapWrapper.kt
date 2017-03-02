package com.github.ericytsang.lib.simplifiedmap

import java.util.concurrent.locks.ReentrantReadWriteLock

class ReadWriteLockedSimplifiedMapWrapper<K,V:Any>(val underlying:SimplifiedMap<K,V>):ReadWriteLockedSimplifiedMap<K,V>
{
    override val readWriteLock = ReentrantReadWriteLock()

    override val keys:Set<K> get() = underlying.keys

    override fun set(key:K,value:V?):V?
    {
        check(readWriteLock.isWriteLockedByCurrentThread)
        return underlying.set(key,value)
    }

    override fun get(key:K):V? = underlying[key]

    override fun clear()
    {
        check(readWriteLock.isWriteLockedByCurrentThread)
        super.clear()
    }

    override fun put(key:K,value:V):V?
    {
        check(readWriteLock.isWriteLockedByCurrentThread)
        return super.put(key,value)
    }

    override fun putAll(from:Map<out K,V>)
    {
        check(readWriteLock.isWriteLockedByCurrentThread)
        super.putAll(from)
    }

    override fun remove(key:K):V?
    {
        check(readWriteLock.isWriteLockedByCurrentThread)
        return super.remove(key)
    }

    override fun equals(other:Any?):Boolean = if (other is Map<*,*>)
    {
        other.entries == entries
    }
    else
    {
        false
    }

    override fun hashCode():Int = underlying.hashCode()

    override fun toString():String = underlying.toString()
}
