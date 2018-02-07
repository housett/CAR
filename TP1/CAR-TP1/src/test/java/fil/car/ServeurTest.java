package fil.car;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Serveur.
 */
public class ServeurTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ServeurTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ServeurTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testServeur()
    {
        assertTrue( true );
    }
}
