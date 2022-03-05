package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    int numArgs;

    // Args ByteCode has 1 arg -> number of arguments in the activation frame
    @Override
    public void init(ArrayList<String> args) {
        this.numArgs = Integer.parseInt(args.get(0));
    }

    // Args ByteCode pushes starting index of new frame to the framePointer stack
    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(this.numArgs);
    }

    @Override
    public String toString() {
        return "ARGS " + this.numArgs;
    }
}
