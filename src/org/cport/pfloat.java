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
