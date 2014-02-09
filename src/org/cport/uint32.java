/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cport;

/**
 *
 * @author Alexander Heusel
 */
public class uint32
{
 
    
    public static int sizeof()
    {
        return 4; // 32 bit = four bytes
    }
    
    public static long maxVal()
    {
        return 0xffffffffl;
    }
    
    public static int add(int a, int b)
    {
        return (int)(promote(a) + promote(b));
    }

    public static int sumOp(int... l)
    {
        long res = promote(l[0]);
        for(int i = 1; i < l.length; i++)
        {
            res += promote(l[i]);
        }
        return (int)res;
    }
    
    public static int sub(int a, int b)
    {
        return (int)(promote(a) - promote(b));
    }

    public static int mul(int a, int b)
    {
        return (int)(promote(a) * promote(b));
    }

    public static int piOp(int... l)
    {
        long res = promote(l[0]);
        for(int i = 1; i < l.length; i++)
        {
            res *= promote(l[i]);
        }
        return (int)res;
    }    
    
    public static int div(int a, int b)
    {
        return (int)(promote(a) / promote(b));
    }
    
    public static int mod(int a, int b)
    {
        return (int)(promote(a) % promote(b));
    }
    
    public static int mod(int a, long b)
    {
        return (int)(promote(a) % b);
    }
    
    public static long promote(int v)
    {
        return Unsigned.uint(v);
    }
        
    /**
     * Compares its two arguments for order. Returns a negative integer as the first argument is less than the second.
     * Compares its two arguments for order. Returns zero as the first argument is equal to the second.
     * Compares its two arguments for order. Returns a positive integer as the first argument is greater than the second.
     */
    public static int cmp(int a, int b)
    {
        final long ia = promote(a);
        final long ib = promote(b);
        return (ia < ib) ? -1 : ((ia > ib) ? 1 : 0);
    }  
    
    public static boolean lt(int a, int b)
    {
        return promote(a) < promote(b);
    }
    
    public static boolean lt(int a, long b)
    {
        return promote(a) < b;
    }
    
    public static boolean gt(int a, int b)
    {
        return promote(a) > promote(b);
    }
    
    public static boolean gt(int a, long b)
    {
        return promote(a) > b;
    }
    
    public static boolean eq(int a, int b)
    {
        return a == b;
    }
    
    public static boolean eq(int a, long b)
    {
        return promote(a) == b;
    }
    
    
}
