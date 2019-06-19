package Bonus_homework;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import java.util.Arrays;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
public class ls {
	String input;
	boolean lsiOption;
	boolean lsfOption;
	boolean iscOption;
	boolean isaOption;
	boolean ishOption;
	boolean issizeOption;
	
	void run(String[] args) {
		Options options = createOptions();

		if (parseOptions(options, args)) {
			if (ishOption) {
				printHelp(options);
				return;
			}
			File dirFile = new File(input);
			File[] fileList = dirFile.listFiles();
			
			ArrayList<String> fileNames = new ArrayList<String>();
			ArrayList<String> filePaths = new ArrayList<String>();
			
			for(File allList: fileList) {
				  if(allList.isFile()) {
				    String tempPath = allList.getParent();
				    filePaths.add(tempPath);
				    
				    String tempFileName = allList.getName();
				    fileNames.add(tempFileName);
				  }
				}
			
			if (issizeOption) {
				System.out.println("file size\n");
				
				ArrayList<String> size = new ArrayList<String>();
				
				for (File sizeF : fileList) {
					long path_Size = sizeF .length();
					String CopySize = new String(Long.toString(path_Size));
					size.add(CopySize);
				}
				
				Collections.sort(size);
				for (int i ;i<size.size(); i++) {
					for (File sizeC : fileList) {
						long list = sizeC.length();
						if(Long.parseLong(size.get(i)) == list) {
							System.out.println(sizeC.getName());
						}
					}
				}
				
				System.out.println(" ");
			}
			if(lsfOption){
			for (String fileinfor : fileNames) {
				System.out.println(fileinfor);
			}
			}
			
			if (isaOption){
			
			System.out.println("all list\n");

			Collections.sort(fileNames);

	        for (String toCheck : fileNames) {
	        	System.out.println(toCheck);
	        }
			}
			if (iscOption){
				File file;
			
		
			}
			
	        
			
				
		}
		
		private Options createOptions() {
			Options options = new Options();

			options.addOption(Option.builder("i").longOpt("input")
					.desc("input path.")
					.hasArg()
					.argName("Input path")
					.required()
					.build());
			
			options.addOption(Option.builder("f").longOpt("information")
					.desc("filse information ")
					.argName("absolute path name")
					.build());
			
			options.addOption(Option.builder("c")
					.desc("add file character")
					.build());
			
			options.addOption(Option.builder("a")
					.desc("print all.")
					.required()
					.build());
			options.addOption(Option.builder("s")
					.desc("file_size")
					.required()
					.build());

			// using OptionBuilder
			options.addOption(Option.builder("h").longOpt("help")
			        .desc("Help")
			        .build());
			
			return options;
		}
		private boolean parseOptions(Options options, String[] args) {
			CommandLineParser parser = new DefaultParser();

			try {

				CommandLine cmd = parser.parse(options, args);

				input = cmd.getOptionValue("i");
				lsfOption = cmd.hasOption("f");
				issizeOption = cmd.hasOption("s");
				iscOption = cmd.hasOption("c");
				isaOption = cmd.hasOption("s");
				ishOption = cmd.hasOption("H");

			} catch (Exception e) {
				printHelp(options);
				return false;
			}

			return true;
		}
		public static void printHelp(Options options) {
			// generate help statement 
			HelpFormatter formatter = new HelpFormatter();
			String header = "lsCli";
			String footer = "";
			formatter.printHelp("CLI", header, options, footer, true);
		
			
		
		}
	}
