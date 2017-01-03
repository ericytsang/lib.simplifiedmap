package com.github.ericytsang.lib.simplifiedmap

import java.util.concurrent.locks.ReentrantReadWriteLock

interface ReadWriteLockedSimplifiedMap<K,V>:SimplifiedMap<K,V>
{
    val readWriteLock:ReentrantReadWriteLock
}
