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
public final class pshort extends pshortBase<pshort>
{
    public static final pshort NULL = new pshort(0, null);    
    
    private pshort(int offset, short[] array)
    {
        super(offset, array);
    }
        
    public static pshort alloc(int size)
    {
        return new pshort(0, new short[size]);
    }
    
    public static pshort wrap(int offset, short[] array)
    {
        return new pshort(offset, array);
    }
    
    public static pshort wrap(short[] array)
    {
        return pshort.wrap(0, array);
    }

    public static pshort wrap(short v)
    {
        return pshort.wrap(0, new short[]{v});
    }
    
    @Override
    final public pshort derefAddr(int idx)
    {
        return new pshort(offset + idx, array);
    }

    @Override
    final public pshort realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pshort.wrap(reallocArray(nbytes));
    }

    
}
