package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    String value;

    // FalseBranch ByteCode has 1 arg -> label to jump to
    @Override
    public void init(ArrayList<String> args) {
        value = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + value;
    }
}
