/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cport;

/**
 *
 * @author Alexander Heusel
 */
public class uint16
{
    
    
    public static int sizeof()
    {
        return 2; // 16 bit = two bytes
    }

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
