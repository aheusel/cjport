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
public class uint16
{
    
    public static int maxVal()
    {
        return 0xffff;
    }
    
    public static short add(short a, short b)
    {
        return (short)(promote(a) + promote(b));
    }

    public static short sumOp(short... l)
    {
        int res = promote(l[0]);
        for(int i = 1; i < l.length; i++)
        {
            res += promote(l[i]);
        }
        return (short)res;
    }
 
    public static short sub(short a, short b)
    {
        return (short)(promote(a) - promote(b));
    }

    public static short mul(short a, short b)
    {
        return (short)(promote(a) * promote(b));
    }

    public static short piOp(short... l)
    {
        int res = promote(l[0]);
        for(int i = 1; i < l.length; i++)
        {
            res *= promote(l[i]);
        }
        return (short)res;
    }    
    
    public static short div(short a, short b)
    {
        return (short)(promote(a) / promote(b));
    }

    public static int mod(short a, short b)
    {
        return promote(a) % promote(b);
    }
    
    public static int mod(short a, int b)
    {
        return promote(a) % b;
    }
    
    public static int promote(short v)
    {
        return Unsigned.ushort(v);
    }
        
    /**
     * Compares its two arguments for order. Returns a negative integer as the first argument is less than the second.
     * Compares its two arguments for order. Returns zero as the first argument is equal to the second.
     * Compares its two arguments for order. Returns a positive integer as the first argument is greater than the second.
     */
    public static int cmp(short a, short b)
    {
        final int ia = promote(a);
        final int ib = promote(b);
        return (ia < ib) ? -1 : ((ia > ib) ? 1 : 0);
    }    

    public static boolean lt(short a, short b)
    {
        return promote(a) < promote(b);
    }
    
    public static boolean lt(short a, int b)
    {
        return promote(a) < b;
    }
    
    public static boolean gt(short a, short b)
    {
        return promote(a) > promote(b);
    }
    
    public static boolean gt(short a, int b)
    {
        return promote(a) > b;
    }
    
    public static boolean eq(short a, short b)
    {
        return a == b;
    }
    
    public static boolean eq(short a, int b)
    {
        return promote(a) == b;
    }
    
    
}
