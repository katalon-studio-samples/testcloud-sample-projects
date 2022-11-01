package test

import com.kms.katalon.core.annotation.Keyword


public class Utility {
	@Keyword
	def executeCommand(String[] commands) {
		Process proc = Runtime.getRuntime().exec(commands);

		BufferedReader stdInput = new BufferedReader(new
				InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new
				InputStreamReader(proc.getErrorStream()));

		// Read the output from the command
		String s = '';
		String full = '';
		while ((s = stdInput.readLine()) != null) {
			full = full + s + System.lineSeparator()
		}
		// Read any errors from the attempted command
		while ((s = stdError.readLine()) != null) {
			full = full + s + System.lineSeparator()
		}
		System.out.println(full);
		return full
	}

	@Keyword
	def readFile(String filePath) {
		File myObj = new File(filePath);
		Scanner myReader = new Scanner(myObj);
		String datafull = ""
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			datafull += data
		}
		System.out.println(datafull);
		myReader.close();
	}

	@Keyword
	def listFiles(String path) {
		File dir = new File(path);
		List<String> fnames = []

		if (dir.isDirectory())
		{
			File[] files= dir.listFiles();

			for (File f: files) {
				if (f.isFile())
				{
					fnames.add(f.getName())

				}
			}

			println(fnames);
		} else {
			println 'NOT DIRECTORY'
		}
	}
}
