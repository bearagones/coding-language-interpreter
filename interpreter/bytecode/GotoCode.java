package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
    String label;

    // Goto ByteCode has 1 arg -> label to jump to
    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }

    // Goto ByteCode jumps to the specified label
    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(Integer.parseInt(this.label));
    }

    @Override
    public String toString() {
        return "GOTO " + this.label;
    }
}
