package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
    String value;

    // Goto ByteCode has 1 arg -> label to jump to
    @Override
    public void init(ArrayList<String> args) {
        value = args.get(0);
    }

    // Goto ByteCode jumps to the specified label
    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter();
    }

    // Prints out "GOTO " + some label
    @Override
    public String toString() {
        return "GOTO " + value;
    }
}
