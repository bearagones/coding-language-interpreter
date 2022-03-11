package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
    String label;
    int address;

    // Goto ByteCode has 1 arg -> label to jump to
    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }

    // Goto ByteCode jumps to the specified label
    @Override
    public void execute(VirtualMachine vm) {
        vm.jumpTo(address);
    }

    @Override
    public String toString() {
        return "GOTO " + this.label;
    }

    public void setLabel(int label) {
        this.address = label;
    }

    public String getLabel() {
        return label;
    }
}
