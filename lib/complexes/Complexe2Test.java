package complexes;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Complexe2Test extends TestCase
{

public final void testComplexe()
{
Assert.assertEquals(0, new Complexe().getX(), 0);
Assert.assertEquals(0, new Complexe().getY(), 0);
}


public final void testComplexeDouble()
{
fail("Not yet implemented"); // TODO
}

public final void testComplexeDoubleDouble()
{
fail("Not yet implemented"); // TODO
}

public final void testGetX()
{
fail("Not yet implemented"); // TODO
}

public final void testGetY()
{
fail("Not yet implemented"); // TODO
}

public final void testSomme()
{
fail("Not yet implemented"); // TODO
}

public final void testProduit()
{
fail("Not yet implemented"); // TODO
}

public final void testConjugue()
{
fail("Not yet implemented"); // TODO
}

public final void testModule()
{
fail("Not yet implemented"); // TODO
}

public final void testModule2()
{
fail("Not yet implemented"); // TODO
}

public final void testEqualsObject()
{
fail("Not yet implemented"); // TODO
}

public final void testToString()
{
Assert.assertEquals("3.0+2.0*i", new Complexe(3,2).toString());
}

}
