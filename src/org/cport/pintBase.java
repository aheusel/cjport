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

import java.nio.IntBuffer;

/**
 *
 * @author aheusel
 * @param <T>
 */
public abstract class pintBase<T> extends pvoid
{
    protected int[] array;
    
    protected pintBase(int offset, int[] array)
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
    final public int[] array()
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
    final public int deref(int idx)
    {
        return array[offset + idx];
    }

    /**
     * Mimics the following construct in C-Code:
     * int16 r = *src;
     * 
     * @return value at offset
     */
    final public int deref()
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
    final public void derefAsgn(int idx, int value)
    {
        array[offset + idx] = value;
    }
    
    /**
     * Mimics the following construct in C-Code:
     * *src = value;
     * 
     * @param value Value to asign
     */
    public void derefAsgn(int value)
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
    public abstract pintBase<T> derefAddr(int idx);
    
    /**
     * Subtracts two pointers and returns their distance.
     * If the pointers refer to different array an exception is thrown.
     * 
     * @param other The other pointer.
     * @return Distance between two pointers.
     */
    public final int sub(pintBase<T> other)
    {
        if(!this.array.equals(other.array))
        {
            throw new java.lang.IllegalArgumentException("Pointers refer to different arrays.");
        }
        return this.offset - other.offset;
    }

    /**
     * Returns a corresponding IntBuffer
     */
    public final IntBuffer getIntBuffer()
    {
        return IntBuffer.wrap(array, offset, array.length - offset);
    }

    /**
     * Reallocs the array the pointer points to
     * 
     * @param nbytes The new size of the memory in bytes
     * @return A new pointer to the realloced memory
     */
    public abstract pintBase<T> realloc(int nbytes);
        
    protected final int[] reallocArray(int nbytes)
    {
        final int elemSize = Integer.SIZE / 8;
        if((nbytes % elemSize) != 0)
        {
            throw new java.lang.IllegalArgumentException("Mismatch of element size and number of bytes.");
        }
        
        final int nelem = nbytes / elemSize;
        final int[] newArray = new int[nelem];
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
