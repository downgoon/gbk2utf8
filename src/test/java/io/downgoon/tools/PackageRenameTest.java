package io.downgoon.tools;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PackageRenameTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	PackageRename.Replacement replacement;

	@Before
	public void setUp() throws Exception {
		replacement = new PackageRename.Replacement("com.example", "io.downgoon");
	}

	@Test
	public void testReplacement() {
		String path = "src/main/java/com/example/tools/Hello.java"; // case-1
		String importCode = "import com.example.tools.Hello"; // case-2
		String newCode = "com.example.tools.Hello hello = new com.example.tools.Hello(); "; // case-3

		String pathChanged = replacement.replacePathName(path);
		Assert.assertEquals("src/main/java/io/downgoon/tools/Hello.java", pathChanged);

		String importCodeChanged = replacement.replaceCodePack(importCode);
		Assert.assertEquals("import io.downgoon.tools.Hello", importCodeChanged);

		String inewCodeChanged = replacement.replaceCodePack(newCode);
		Assert.assertEquals("io.downgoon.tools.Hello hello = new io.downgoon.tools.Hello(); ", inewCodeChanged);

	}

	// @Test // TODO rare occurrence
	public void testReplacementCase4() {
		String newLineCode = "com.example.tools.Hello hello = new com." + "\r\n" + "example.tools.Hello(); ";
		String newLineCodeChanged = replacement.replaceCodePack(newLineCode);
		String newLineCodeExpected = "io.downgoon.tools.Hello hello = new io." + "\r\n" + "downgoon.tools.Hello(); ";
		Assert.assertEquals(newLineCodeExpected, newLineCodeChanged);
	}
}
