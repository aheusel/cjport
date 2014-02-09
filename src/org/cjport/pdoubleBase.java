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

import java.nio.DoubleBuffer;

/**
 *
 * @author aheusel
 */
public abstract class pdoubleBase<T> extends pvoid
{
    protected final double[] array;
    
    protected pdoubleBase(int offset, double[] array)
    {
        super(offset);
        this.array = array;
    }
        
    /**
     * Returns true if this is a null-pointer
     * 
     * @return true if the pointer is a null-pointer
     */
    final public boolean isNull()
    {
        return array == null;
    }
    
    /**
     * Returns the internal array
     * 
     * @return Internal array
     */
    final public double[] array()
    {
        return array;
    }
        
    /**
     * Mimics the following construct in C-Code:
     * int16 r = src[idx];
     * 
     * @param idx Index of value to get
     * @return Value at index idx
     */
    final public double deref(int idx)
    {
        return array[offset + idx];
    }

    /**
     * Mimics the following construct in C-Code:
     * int16 r = *src;
     * 
     * @return value at offset
     */
    final public double deref()
    {
        return array[offset];
    }
    
    
    /**
     * Mimics the following construct in C-Code:
     * src[idx] = value;
     * 
     * @param idx Index to assign value to
     * @param value Value to assign
     */
    final public void derefAsgn(int idx, double value)
    {
        array[offset + idx] = value;
    }
    
    /**
     * Mimics the following construct in C-Code:
     * *src = value;
     * 
     * @param value Value to asign
     */
    public void derefAsgn(double value)
    {
        array[offset] = value;
    }
    
    
    /**
     * Mimics the following construct in C-Code:
     * int16* p = &src[idx];
     * 
     * @param idx index of the element
     * @return pointer to that element
     */
    public abstract pdoubleBase<T> derefAddr(int idx);
    
    /**
     * Subtracts two pointers and returns their distance.
     * If the pointers refer to different array an exception is thrown.
     * 
     * @param other The other pointer.
     * @return Distance between two pointers.
     */
    public final int sub(pdoubleBase<T> other)
    {
        if(!this.array.equals(other.array))
        {
            throw new java.lang.IllegalArgumentException("Pointers refer to different arrays.");
        }
        return this.offset - other.offset;
    }

    /**
     * Returns a corresponding DoubleBuffer
     */
    public final DoubleBuffer getDoubleBuffer()
    {
        return DoubleBuffer.wrap(array, offset, array.length - offset);
    }

    /**
     * Reallocs the array the pointer points to
     * 
     * @param nbytes The new size of the memory in bytes
     * @return A new pointer to the realloced memory
     */
    public abstract pdoubleBase<T> realloc(int nbytes);

    protected final double[] reallocArray(int nbytes)
    {
        final int elemSize = Double.SIZE / 8;
        if((nbytes % elemSize) != 0)
        {
            throw new java.lang.IllegalArgumentException("Mismatch of element size and number of bytes.");
        }
        
        final int nelem = nbytes / elemSize;
        final double[] newArray = new double[nelem];
        if(nelem > array.length)
        {
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        else
        {
            System.arraycopy(array, 0, newArray, 0, nelem);
        }
        return newArray;
    }
    
    
    
}
