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
public abstract class pvoid
{
    protected int offset;
    
    protected pvoid(int offset)
    {
        this.offset = offset;
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

    /**
     * Reallocs the array the pointer points to
     * 
     * @param nbytes The new size of the memory in bytes
     * @return A new pointer to the realloced memory
     */    
    public abstract pvoid realloc(int nbytes);    

    /**
     * 
     */
    public abstract Object array();
    
}
