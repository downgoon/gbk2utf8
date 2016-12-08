package io.downgoon.tools;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * package rename for java files and corresponding configurations
 */
public class PackageRename {

	public static void main(String[] args) throws Exception {

		if (args.length < 4) {
			System.out.println(
					"Usage: PackageRename <src-path> <dst-path> <original-package-prefix> <alternative-package-prefix>");
			
			System.out.println(
					"Example: PackageRename ~/original ~/alternative com.example. io.downgoon.");
			
			System.exit(1);
		}

		String srcPath = args[0];
		String dstPath = args[1];

		Replacement replacement = new Replacement(args[2], args[3]);

		Collection<File> srcFiles = FileUtils.listFiles(new File(srcPath),
				new String[] { "java", "jsp", "xml", "properties", "yml" }, true);

		int replaceLines = 0;
		int replaceFiles = 0;
		int copiedFiles = 0;
		for (File srcFile : srcFiles) {

			String srcRelativeName = srcFile.getAbsolutePath().substring(srcPath.length());
			String dstAbsoluteName = dstPath + replacement.replacePathName(srcRelativeName);

			String srcEncoding = encodingName(srcFile);
			List<String> srcLines = FileUtils.readLines(srcFile, srcEncoding);

			boolean srcFileReplaced = false;
			List<String> dstLines = new LinkedList<String>();
			for (String srcLine : srcLines) {
				String dstLine = replacement.replaceCodePack(srcLine);
				dstLines.add(dstLine);
				if (!dstLine.equals(srcLine)) {
					replaceLines++;
					srcFileReplaced = true;
				}
			}

			FileUtils.writeLines(new File(dstAbsoluteName), dstLines);

			if (srcFileReplaced) {
				replaceFiles++;
				System.out.println("replaced: " + srcRelativeName);
			} else {
				copiedFiles++;
				System.out.println("copied: " + srcRelativeName);
			}

		}
		System.out.println("Finish: " + replaceLines + " lines replacement, " + replaceFiles + " replace files and "
				+ copiedFiles + " copied files");
		System.out.println("if you want to overwrite original files, please execute the command as follows: ");
		System.out.println("cp -R " + dstPath + File.separatorChar + "* " + srcPath);
	}

	private static EncodingDetect detect = new EncodingDetect();

	private static String encodingName(File file) {
		int encodingNumber = detect.detectEncoding(file);
		return EncodingDetect.javaname[encodingNumber];
	}

	static class Replacement {

		private String originalPathFactor;
		private String alternativePathFactor;

		private String originalPackFactor;
		private String alternativePackFactor;

		/**
		 * @param String
		 *            originalPrefix e.g. com.example
		 * @param String
		 *            alternativePrefix e.g. io.downgoon
		 */
		public Replacement(String originalPrefix, String alternativePrefix) {
			originalPathFactor = originalPrefix.replace('.', File.separatorChar);
			alternativePathFactor = alternativePrefix.replace('.', File.separatorChar);

			originalPackFactor = originalPrefix.replaceAll("[.]", "\\\\.");
			alternativePackFactor = alternativePrefix;
		}

		public String replacePathName(String originalPath) {
			return originalPath.replaceAll(originalPathFactor, alternativePathFactor);
		}

		public String replaceCodePack(String originalPack) {
			return originalPack.replaceAll(originalPackFactor, alternativePackFactor);
		}

	}

}
