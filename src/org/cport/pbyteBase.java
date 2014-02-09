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

import java.nio.ByteBuffer;

/**
 *
 * @author Alexander Heusel
 * @param <T>
 */
public abstract class pbyteBase<T> extends pvoid
{
    protected byte[] array;
    
    protected pbyteBase(int offset, byte[] array)
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
    final public byte[] array()
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
    final public byte deref(int idx)
    {
        return array[offset + idx];
    }

    /**
     * Mimics the following construct in C-Code:
     * int16 r = *src;
     * 
     * @return value at offset
     */
    final public byte deref()
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
    final public void derefAsgn(int idx, byte value)
    {
        array[offset + idx] = value;
    }
    
    /**
     * Mimics the following construct in C-Code:
     * *src = value;
     * 
     * @param value Value to asign
     */
    public void derefAsgn(byte value)
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
    public abstract pbyteBase<T> derefAddr(int idx);
    
    /**
     * Subtracts two pointers and returns their distance.
     * If the pointers refer to different array an exception is thrown.
     * 
     * @param other The other pointer.
     * @return Distance between two pointers.
     */
    public final int sub(pbyteBase<T> other)
    {
        if(!this.array.equals(other.array))
        {
            throw new java.lang.IllegalArgumentException("Pointers refer to different arrays.");
        }
        return this.offset - other.offset;
    }
    
    /**
     * Returns a corresponding ByteBuffer
     */
    public final ByteBuffer getByteBuffer()
    {
        return ByteBuffer.wrap(array, offset, array.length - offset);
    }

    /**
     * Reallocs the array the pointer points to
     * 
     * @param nbytes The new size of the memory in bytes
     * @return A new pointer to the realloced memory
     */
    public abstract pbyteBase<T> realloc(int nbytes);
        
    protected final byte[] reallocArray(int nbytes)
    {        
        byte[] newArray = new byte[nbytes];
        if(nbytes > array.length)
        {
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        else
        {
            System.arraycopy(array, 0, newArray, 0, nbytes);
        }
        return newArray;
    }

    
}
