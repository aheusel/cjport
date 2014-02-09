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
public final class pint extends pintBase<pint>
{
    
    public static final pint NULL = new pint(0, null);    
    
    private pint(int offset, int[] array)
    {
        super(offset, array);
    }
    
    public static pint alloc(int size)
    {
        return new pint(0, new int[size]);
    }
    
    public static pint wrap(int offset, int[] array)
    {
        return new pint(offset, array);
    }
    
    public static pint wrap(int[] array)
    {
        return pint.wrap(0, array);
    }
    
    public static pint wrap(int v)
    {
        return pint.wrap(0, new int[]{v});
    }
    
    @Override
    final public pint derefAddr(int idx)
    {
        return new pint(offset + idx, array);
    }

    @Override
    final public pint realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pint.wrap(reallocArray(nbytes));
    }
    
}
