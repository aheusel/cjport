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
public class uint64
{

    public static float floatValue(long v)
    {
        return promote(v).floatValue();
    }
    
    public static double doubleValue(long v)
    {
        return promote(v).doubleValue();
    }
    
    public static BigInteger maxVal()
    {
        return promote(0xffffffffffffffffl);
    }
    
    public static long add(long a, long b)
    {
        BigInteger bigA = promote(a);
        BigInteger bigB = promote(b);        
        return (bigA.add(bigB)).longValue();
    }

    public static long sumOp(long... l)
    {
        BigInteger res = promote(l[0]);
        for(int i = 1; i < l.length; i++)
        {
            res = res.add(promote(l[i]));
        }
        return res.longValue();
    }
    
    public static long sub(long a, long b)
    {
        BigInteger bigA = promote(a);
        BigInteger bigB = promote(b);        
        return (bigA.subtract(bigB)).longValue();
    }

    public static long mul(long a, long b)
    {
        BigInteger bigA = promote(a);
        BigInteger bigB = promote(b);        
        return (bigA.multiply(bigB)).longValue();
    }

    public static long piOp(long... l)
    {
        BigInteger res = promote(l[0]);
        for(int i = 1; i < l.length; i++)
        {
            res = res.multiply(promote(l[i]));
        }
        return res.longValue();
    }    
    
    public static long div(long a, long b)
    {
        BigInteger bigA = promote(a);
        BigInteger bigB = promote(b);        
        return (bigA.divide(bigB)).longValue();
    }

    public static long mod(long a, long b)
    {
        BigInteger bigA = promote(a);
        BigInteger bigB = promote(b);        
        return (bigA.mod(bigB)).longValue();
    }
    
    public static long mod(long a, BigInteger b)
    {
        BigInteger bigA = promote(a);
        return (bigA.mod(b)).longValue();
    }
    
    public static BigInteger promote(long value)
    {
        return Unsigned.ulong(value); 
    }
    
    /**
     * Compares its two arguments for order. Returns a negative integer as the first argument is less than the second.
     * Compares its two arguments for order. Returns zero as the first argument is equal to the second.
     * Compares its two arguments for order. Returns a positive integer as the first argument is greater than the second.
     */
    public static int cmp(byte a, byte b)
    {
        final BigInteger bigA = promote(a);
        final BigInteger bigB = promote(b);
        return bigA.compareTo(bigB);
    }    

    public static boolean lt(long a, long b)
    {
        return promote(a).compareTo(promote(b)) < 0;
    }
    
    public static boolean lt(long a, BigInteger b)
    {
        return promote(a).compareTo(b) < 0;
    }
    
    public static boolean gt(long a, long b)
    {
        return promote(a).compareTo(promote(b)) > 0;
    }
    
    public static boolean gt(long a, BigInteger b)
    {
        return promote(a).compareTo(b) > 0;
    }
    
    public static boolean eq(long a, long b)
    {
        return a == b;
    }
    
    public static boolean eq(long a, BigInteger b)
    {
        return promote(a).equals(b);
    }
    
    
}
