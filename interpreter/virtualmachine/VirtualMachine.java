package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LitCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        ByteCode bc = new LitCode();
        System.out.println(bc);;
    }
}
