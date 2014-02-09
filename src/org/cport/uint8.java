/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cport;

/**
 * @todo CAST Facility!!!, e.g byte b = uint8.castFrom(2342, TYPE_UINT16);
 * @author Alexander Heusel
 */
public class uint8
{

    public static int sizeof()
    {
        return 1; // 8 bit = one byte
    }

    public static int maxVal()
    {
        return 0xff;
    }
    
    public static byte add(byte a, byte b)
    {
        return (byte)(promote(a) + promote(b));
    }

    public static byte sumOp(byte... l)
    {
        int res = promote(l[0]);
        for(int i = 1; i < l.length; i++)
        {
            res += promote(l[i]);
        }
        return (byte)res;
    }
        
    public static byte sub(byte a, byte b)
    {
        return (byte)(promote(a) - promote(b));
    }
    
    public static byte mul(byte a, byte b)
    {
        return (byte)(promote(a) * promote(b));
    }

    public static byte piOp(byte... l)
    {
        int res = promote(l[0]);
        for(int i = 1; i < l.length; i++)
        {
            res *= promote(l[i]);
        }
        return (byte)res;
    }
    
    public static byte div(byte a, byte b)
    {
        return (byte)(promote(a) / promote(b));
    }
    
    public static int mod(byte a, byte b)
    {
        return promote(a) % promote(b);
    }
    
    public static int mod(byte a, int b)
    {
        return promote(a) % b;
    }

    public static short promote(byte v)
    {
        return (short)((int)v & 0xff);
    }
    
    /**
     * Compares its two arguments for order. Returns a negative integer as the first argument is less than the second.
     * Compares its two arguments for order. Returns zero as the first argument is equal to the second.
     * Compares its two arguments for order. Returns a positive integer as the first argument is greater than the second.
     */
    public static int cmp(byte a, byte b)
    {
        final int ia = promote(a);
        final int ib = promote(b);
        return (ia < ib) ? -1 : ((ia > ib) ? 1 : 0);
    }
    
    public static boolean lt(byte a, byte b)
    {
        return promote(a) < promote(b);
    }
    
    public static boolean lt(byte a, int b)
    {
        return promote(a) < b;
    }
    
    public static boolean gt(byte a, byte b)
    {
        return promote(a) > promote(b);
    }
    
    public static boolean gt(byte a, int b)
    {
        return promote(a) > b;
    }
    
    public static boolean eq(byte a, byte b)
    {
        return a == b;
    }
    
    public static boolean eq(byte a, int b)
    {
        return promote(a) == b;
    }
    
}
