/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cjport.unix;

import org.cjport.pvoid;

/**
 *
 * @author Alexander Heusel
 */
public class string
{
    
    /**
     * The memcpy() function copies n bytes from memory area src to memory area 
     * dst.  If dst and src overlap, behavior is undefined.  Applications in
     * which dst and src might overlap should use memmove(3) instead.
     * 
     * @param dst Destination
     * @param src Source
     * @param n Number of bytes to copy
     * @return The memcpy() function returns the original value of dst.
     */
    public static pvoid memcpy(pvoid dst, pvoid src, int n)
    {
        System.arraycopy(src.array(), src.offset(), dst.array(), dst.offset(), n);
        return dst;
    }
    
    
}
