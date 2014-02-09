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
public final class pbyte extends pbyteBase<pbyte>
{
    public static final pbyte NULL = new pbyte(0, null);    
    
    private pbyte(int offset, byte[] array)
    {
        super(offset, array);
    }
    
    public static pbyte alloc(int size)
    {
        return new pbyte(0, new byte[size]);
    }
    
    public static pbyte wrap(int offset, byte[] array)
    {
        return new pbyte(offset, array);
    }
    
    public static pbyte wrap(byte[] array)
    {
        return pbyte.wrap(0, array);
    }

    public static pbyte wrap(byte v)
    {
        return pbyte.wrap(0, new byte[]{v});
    }    
    
    @Override
    final public pbyte derefAddr(int idx)
    {
        return new pbyte(offset + idx, array);
    }

    @Override
    final public pbyte realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pbyte.wrap(reallocArray(nbytes));
    }
    
    
}
