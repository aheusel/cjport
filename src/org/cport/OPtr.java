/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cport;

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
