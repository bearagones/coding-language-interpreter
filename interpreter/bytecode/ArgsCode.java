package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    int value;

    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(value);
    }

    @Override
    public String toString() {
        return "ARGS " + value;
    }
}
