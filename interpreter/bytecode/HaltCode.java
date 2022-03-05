package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {

    // Halt ByteCode has no args
    @Override
    public void init(ArrayList<String> args) {
    }

    // Halt ByteCode stops the VirtualMachine
    @Override
    public void execute(VirtualMachine vm) {
        vm.haltProgram();
    }

    @Override
    public String toString() {
        return "HALT";
    }
}
