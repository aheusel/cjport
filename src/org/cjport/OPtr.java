/*
 * CJPort - An utility library to aid the port of C-code to java
 * Copyright (C) 2014  Alexander Heusel
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.cjport;

/**
 *
 * @author Alexander Heusel
 */
public class OPtr<T>
{
    private T[] array;
    private int offset;
    
    public OPtr(int offset, T[] array)
    {
        this.offset = offset;
        this.array = array;
    }
        
    public int offset()
    {
        return offset;
    }
    
    public void incr()
    {
        offset++;
    }
    
    public void incr(int incr)
    {
        offset += incr;
    }
    
    public void decr()
    {
        offset--;
    }
    
    public void decr(int decr)
    {
        offset -= decr;
    }
    
    public T[] array()
    {
        return array;
    }
    
    /**
     * Mimics the following construct in C-Code:
     * int8 r = src[idx];
     */
    public T deref(int idx)
    {
        return array[offset + idx];
    }
    
    /**
     * Mimics the following construct in C-Code:
     * src[idx] = value;
     */
    public void derefAsgn(int idx, T value)
    {
        array[offset + idx] = value;
    }
    
    /**
     * Mimics the following construct in C-Code:
     * int8* p = &src[idx];
     */
    public OPtr<T> derefAddr(int idx)
    {
        return new OPtr<>(offset + idx, array);
    }
    
}
