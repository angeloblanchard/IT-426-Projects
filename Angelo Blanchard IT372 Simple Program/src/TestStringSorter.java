import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.io.*;

public class TestStringSorter extends TestCase {

	private ArrayList make123() {
		ArrayList l = new ArrayList();
		l.add("one");
		l.add("two");
		l.add("three");

		return l;
	}

	public ArrayList setupArrayList()
	{
		ArrayList l3 = new ArrayList<>();
		l3.add("four");
		l3.add("five");
		l3.add("six");

		return l3;
	}

	public void testFindIdxBiggest() {
		StringSorter ss=new StringSorter();
		ArrayList l = make123();

		int i=StringSorter.findIdxBiggest(l,0,l.size()-1);
		assertEquals(i,1);
	}

	public void testSwap() {
		ArrayList l1= make123();

		ArrayList l2=new ArrayList();
		l2.add("one");
		l2.add("three");
		l2.add("two");

		StringSorter.swap(l1,1,2);
		assertEquals(l1,l2);
	}

	public void testReadFromStream() throws IOException{
		Reader in=new FileReader("in.txt");
		StringSorter ss=new StringSorter();
		ArrayList l= make123();

		ss.readFromStream(in);
		assertEquals(l,ss.lines);
	}

	public void testSort1() {
		StringSorter ss= new StringSorter();
		ss.lines=make123();

		ArrayList l2=new ArrayList();
		l2.add("one");
		l2.add("three");
		l2.add("two");

		ss.sort();

		assertEquals(l2,ss.lines);
	}

	public void testWriteToStream() throws IOException{
		// write out a known value
		StringSorter ss1=new StringSorter();
		ss1.lines=make123();
		Writer out=new FileWriter("test.out");
		ss1.writeToStream(out);
		out.close();

		// then read it and compare
		Reader in=new FileReader("in.txt");
		StringSorter ss2=new StringSorter();
		ss2.readFromStream(in);
		assertEquals(ss1.lines,ss2.lines);
	}

		public void testSort2() throws IOException{
		// write out a known value
		StringSorter ss1=new StringSorter();
		ss1.sort("in.txt","test2.out");

		ArrayList l=new ArrayList();
		l.add("one");
		l.add("three");
		l.add("two");

		// then read it and compare
		Reader in=new FileReader("test2.out");
		StringSorter ss2=new StringSorter();
		ss2.readFromStream(in);
		assertEquals(l,ss2.lines);
	}

	// Added tests to follow

	@Test
	public void testReadFromStreamVersion2() throws IOException
	{
		FileReader input = new FileReader("in2.txt");
		StringSorter ss2 = new StringSorter();
		ss2.readFromStream(input);
		ArrayList<String> l3 = setupArrayList();

		assertEquals(l3, ss2.lines);
	}

	@Test
	public void testWriteToStreamVersion2() throws IOException
	{
		ArrayList<String> l3 = setupArrayList();
		StringSorter ss2 = new StringSorter();
		ss2.lines = l3;
		Writer output = new FileWriter("test3.out");
		ss2.writeToStream(output);
		output.close();

	}

	@Test
	public void testFindIdxBiggestVersion2()
	{
		ArrayList<String> l3 = setupArrayList();
		StringSorter ss2 = new StringSorter();
		int i = StringSorter.findIdxBiggest(l3, 0, l3.size()-1);
		assertEquals(i, 2);
	}
	@Test
	public void testSwapVersion2()
	{
		ArrayList l1= new ArrayList();
		l1.add("four");
		l1.add("six");
		l1.add("five");
		ArrayList l3 = setupArrayList();

		StringSorter.swap(l1,1,2);
		assertEquals(l1,l3);
	}

	@Test
	public void testSort1Version2()
	{
		StringSorter ss2 = new StringSorter();
		ss2.lines = setupArrayList();

		ArrayList l2 = new ArrayList();
		l2.add("five");
		l2.add("four");
		l2.add("six");

		ss2.sort();

		assertEquals(l2, ss2.lines);
	}

	@Test
	public void testSort2Version2() throws IOException
	{
		StringSorter ss2 = new StringSorter();
		ss2.sort("in2.txt", "test3.out");

		ArrayList l2 = new ArrayList();
		l2.add("five");
		l2.add("four");
		l2.add("six");

		Reader input = new FileReader("test3.out");
		StringSorter ss3 = new StringSorter();
		ss3.readFromStream(input);
		assertEquals(l2, ss3.lines);
	}

}
