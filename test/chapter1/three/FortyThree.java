/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     31/01/2025
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.Queue;

import java.io.File;

/**
 * 1.3.43
 * Listing files. A folder is a list of files and folders. Write a program that takes the name of a
 * folder as a command-line argument and prints out all the files contained in that folder, with
 * the contents of each folder recursively listed (indented) under that folder’s name. Hint: Use a
 * queue, and see java.io.File.
 */
public class FortyThree {

    public static void listFiles(String folderPath) {
        File root = new File(folderPath);
        if (!root.exists() || !root.isDirectory()) {
            System.out.println("Invalid folder path");
            return;
        }

        Queue<FileIndentPair> queue = new Queue<>();
        queue.enqueue(new FileIndentPair(root, 0));

        while (!queue.isEmpty()) {
            FileIndentPair current = queue.dequeue();
            File currentFile = current.file;
            int indent = current.indent;

            // Print with indentation
            for (int i = 0; i < indent; i++) {
                System.out.print("  ");
            }
            System.out.println(currentFile.getName());

            // If directory, add its contents to queue
            if (currentFile.isDirectory()) {
                File[] children = currentFile.listFiles();
                if (children != null) {
                    for (File child : children) {
                        queue.enqueue(new FileIndentPair(child, indent + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FortyThree <folder>");
            return;
        }
        listFiles(args[0]);
    }

    // Helper class to store file and its indentation level
    static class FileIndentPair {
        File file;
        int indent;

        FileIndentPair(File file, int indent) {
            this.file = file;
            this.indent = indent;
        }
    }
}