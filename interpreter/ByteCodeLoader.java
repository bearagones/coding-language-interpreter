
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts. Can also use the split function in the String class.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        String line;
        String className;
        String byteCodeName;
        String[] items;
        Class classBlueprint;
        Program program = new Program();
        ByteCode bc;

        try {
            while (this.byteSource.ready()) {
                // tokenize read line
                line = this.byteSource.readLine();
                items = line.split("\\s+");
                // grab first token of line
                byteCodeName = items[0];
                // grab class name from token
                className = CodeTable.getClassName(byteCodeName);
                // load class blueprint from classname
                classBlueprint = Class.forName("interpreter.bytecode." + className);
                // get declared constructor (should be no-arg constructor)
                // create new instance of bytecode using constructor
                bc = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();
                // grab remaining arguments
                ArrayList<String> args = new ArrayList<>();
                for (int i = 1; i < items.length; i++) {
                    args.add(items[i]);
                }
                // pass args to bytecode init function
                bc.init(args);
                // add bytecode to program
                program.addCode(bc);
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.exit(255);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }

        program.resolveAddress();
        return program;
    }
}
