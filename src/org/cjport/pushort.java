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
public final class pushort extends pshortBase<pushort>
{
    public static final pushort NULL = new pushort(0, null);    
    
    private pushort(int offset, short[] array)
    {
        super(offset, array);
    }
    
    public static pushort alloc(int size)
    {
        return new pushort(0, new short[size]);
    }
    
    public static pushort wrap(int offset, short[] array)
    {
        return new pushort(offset, array);
    }
    
    public static pushort wrap(short[] array)
    {
        return pushort.wrap(0, array);
    }
    
    public static pushort wrap(short v)
    {
        return pushort.wrap(0, new short[]{v});
    }
    
    final public int derefPromote()
    {
        return uint16.promote(array[offset]);
    }
    
    final public int derefPromote(int i)
    {
        return uint16.promote(array[offset + i]);
    }

    @Override
    final public pushort derefAddr(int idx)
    {
        return new pushort(offset + idx, array);
    }

    @Override
    final public pushort realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pushort.wrap(reallocArray(nbytes));
    }
    
    
}
