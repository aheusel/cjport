/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cport;

/**
 *
 * @author Alexander Heusel
 */
public final class pdouble extends pdoubleBase<pdouble>
{
    public static final pdouble NULL = new pdouble(0, null);
    
    private pdouble(int offset, double[] array)
    {
        super(offset, array);
    }
        
    public static pdouble alloc(int size)
    {
        return new pdouble(0, new double[size]);
    }
    
    public static pdouble wrap(int offset, double[] array)
    {
        return new pdouble(offset, array);
    }
    
    public static pdouble wrap(double[] array)
    {
        return pdouble.wrap(0, array);
    }

    public static pdouble wrap(double v)
    {
        return pdouble.wrap(0, new double[]{v});
    }    
    
    @Override
    final public pdouble derefAddr(int idx)
    {
        return new pdouble(offset + idx, array);
    }

    @Override
    final public pdouble realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pdouble.wrap(reallocArray(nbytes));
    }

}
