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
public final class pubyte extends pbyteBase<pubyte>
{
    public static final pubyte NULL = new pubyte(0, null);    
    
    private pubyte(int offset, byte[] array)
    {
        super(offset, array);
    }
    
    public static pubyte alloc(int size)
    {
        return new pubyte(0, new byte[size]);
    }
    
    public static pubyte wrap(int offset, byte[] array)
    {
        return new pubyte(offset, array);
    }
    
    public static pubyte wrap(byte[] array)
    {
        return pubyte.wrap(0, array);
    }
    
    public static pubyte wrap(byte v)
    {
        return pubyte.wrap(0, new byte[]{v});
    }
    
    final public short derefPromote()
    {
        return uint8.promote(array[offset]);
    }
    
    final public short derefPromote(int i)
    {
        return uint8.promote(array[offset + i]);
    }

    @Override
    final public pubyte derefAddr(int idx)
    {
        return new pubyte(offset + idx, array);
    }
    
    @Override
    final public pubyte realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pubyte.wrap(reallocArray(nbytes));
    }
    
    
}
