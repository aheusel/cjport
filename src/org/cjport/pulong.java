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

import java.math.BigInteger;

/**
 *
 * @author Alexander Heusel
 */
public final class pulong extends plongBase<pulong>
{    
    public static final pulong NULL = new pulong(0, null);
    
    private pulong(int offset, long[] array)
    {
        super(offset, array);
    }
    
    public static pulong alloc(int size)
    {
        return new pulong(0, new long[size]);
    }
    
    public static pulong wrap(int offset, long[] array)
    {
        return new pulong(offset, array);
    }
    
    public static pulong wrap(long[] array)
    {
        return pulong.wrap(0, array);
    }

    public static pulong wrap(long v)
    {
        return pulong.wrap(0, new long[]{v});
    }
        
    final public BigInteger derefPromote()
    {
        return uint64.promote(array[offset]);
    }
    
    final public BigInteger derefPromote(int i)
    {
        return uint64.promote(array[offset + i]);
    }

    @Override
    final public pulong derefAddr(int idx)
    {
        return new pulong(offset + idx, array);
    }

    @Override
    final public pulong realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pulong.wrap(reallocArray(nbytes));
    }
    
    
}
