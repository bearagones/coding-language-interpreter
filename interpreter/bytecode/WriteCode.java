package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {

    // Write ByteCode has 0 args
    @Override
    public void init(ArrayList<String> args) {
    }

    // Write ByteCode prints only the top of the runtime stack
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
