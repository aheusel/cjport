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
public final class pfloat extends pfloatBase<pfloat>
{
    public static final pfloat NULL = new pfloat(0, null);
    
    private pfloat(int offset, float[] array)
    {
        super(offset, array);
    }
        
    public static pfloat alloc(int size)
    {
        return new pfloat(0, new float[size]);
    }
    
    public static pfloat wrap(int offset, float[] array)
    {
        return new pfloat(offset, array);
    }
    
    public static pfloat wrap(float[] array)
    {
        return pfloat.wrap(0, array);
    }

    public static pfloat wrap(float v)
    {
        return pfloat.wrap(0, new float[]{v});
    }    
    
    @Override
    final public pfloat derefAddr(int idx)
    {
        return new pfloat(offset + idx, array);
    }

    @Override
    final public pfloat realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pfloat.wrap(reallocArray(nbytes));
    }
    
    
}
