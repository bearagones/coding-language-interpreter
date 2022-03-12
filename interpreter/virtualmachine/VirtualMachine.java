package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dumpStatus;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<>();
        isRunning = true;
        dumpStatus = true;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if (dumpStatus) {
                dump(code);
            }
            programCounter++;
        }
    }

    public void haltProgram() {
        isRunning = false;
    }

    public void dump(ByteCode code) {
        if (dumpStatus && !(code instanceof DumpCode) && !(code instanceof HaltCode)) {
            System.out.println(code);
        }
        runTimeStack.dump();
    }

    public void dumpOn() {
        dumpStatus = true;
    }

    public void dumpOff() {
        dumpStatus = false;
    }

    public int peek() {
        return this.runTimeStack.peek();
    }

    public void push(int valueToPush) {
        this.runTimeStack.push(valueToPush);
    }

    public int pop() {
        return this.runTimeStack.pop();
    }

    public int store(int offset) {
        return this.runTimeStack.store(offset);
    }

    public int load(int offset) {
        return this.runTimeStack.load(offset);
    }

    public void newFrameAt(int offset) {
        this.runTimeStack.newFrameAt(offset);
    }

    public void popFrame() {
        this.runTimeStack.popFrame();
    }

    public int popReturnAddress() {
        return this.returnAddress.pop();
    }

    public void setProgramCounter(int index) {
        programCounter = index;
    }

    public int frameSize() {
        return this.runTimeStack.frameSize();
    }

    public void save() {
        returnAddress.push(programCounter);
    }

    public void jumpTo(int index) {
        programCounter = index;
    }

    public ArrayList<Integer> frameElements() {
        return this.runTimeStack.frameElements();
    }

}
