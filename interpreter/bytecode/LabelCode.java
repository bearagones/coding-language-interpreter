package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    String label;

    // Label ByteCode has 1 arg -> a label to denote a location in the program
    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }

    // Label ByteCode has no functionality
    @Override
    public void execute(VirtualMachine vm) {
    }

    @Override
    public String toString() {
        return "LABEL " + this.label;
    }
}
