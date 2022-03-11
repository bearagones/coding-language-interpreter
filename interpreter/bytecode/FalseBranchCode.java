package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    String label;

    // FalseBranch ByteCode has 1 arg -> label to jump to
    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }

    // FalseBranch ByteCode executes conditional branching
    @Override
    public void execute(VirtualMachine vm) {
        if (vm.pop() == 0) {
            vm.jumpTo(Integer.parseInt(label));
        }
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + this.label;
    }

    public void setLabel(int index) {
        this.label = Integer.toString(index);
    }

    public String getLabel() {
        return label;
    }
}
