/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cport;

import java.nio.ShortBuffer;

/**
 *
 * @author Alexander Heusel
 * 
 * @param <T>
 */
public abstract class pshortBase<T> extends pvoid
{
    protected short[] array;
    
    protected pshortBase(int offset, short[] array)
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
    final public short[] array()
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
    final public short deref(int idx)
    {
        return array[offset + idx];
    }

    /**
     * Mimics the following construct in C-Code:
     * int16 r = *src;
     * 
     * @return value at offset
     */
    final public short deref()
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
    final public void derefAsgn(int idx, short value)
    {
        array[offset + idx] = value;
    }
    
    /**
     * Mimics the following construct in C-Code:
     * *src = value;
     * 
     * @param value Value to asign
     */
    public void derefAsgn(short value)
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
    public abstract pshortBase<T> derefAddr(int idx);
    
    /**
     * Subtracts two pointers and returns their distance.
     * If the pointers refer to different array an exception is thrown.
     * 
     * @param other The other pointer.
     * @return Distance between two pointers.
     */
    public final int sub(pshortBase<T> other)
    {
        if(!this.array.equals(other.array))
        {
            throw new java.lang.IllegalArgumentException("Pointers refer to different arrays.");
        }
        return this.offset - other.offset;
    }

    /**
     * Returns a corresponding ShortBuffer
     */
    public final ShortBuffer getShortBuffer()
    {
        return ShortBuffer.wrap(array, offset, array.length - offset);
    }
    
    /**
     * Reallocs the array the pointer points to
     * 
     * @param nbytes The new size of the memory in bytes
     * @return A new pointer to the realloced memory
     */
    public abstract pshortBase<T> realloc(int nbytes);
    
    protected final short[] reallocArray(int nbytes)
    {
        final int elemSize = Short.SIZE / 8;
        if((nbytes % elemSize) != 0)
        {
            throw new java.lang.IllegalArgumentException("Mismatch of element size and number of bytes.");
        }
        
        final int nelem = nbytes / elemSize;
        final short[] newArray = new short[nelem];
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
