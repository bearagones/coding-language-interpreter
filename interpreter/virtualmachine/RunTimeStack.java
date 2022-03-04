package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    private int lastIndex() {
        return this.runTimeStack.size() - 1;
    }

    public void dump() {
        
    }

    public int peek() {
        return this.runTimeStack.get(lastIndex());
    }

    public int push(int valueToPush) {
        this.runTimeStack.add(valueToPush);
        return this.peek();
    }

    public int pop() {
        return this.runTimeStack.remove(lastIndex());
    }

    public int store(int offset) {
        return offset + runTimeStack.get(lastIndex());
    }

    public int load(int offset) {
        return framePointer.push(runTimeStack.get(offset));
    }

    public void newFrameAt(int offset) {
        framePointer.add(offset);
    }

    public void popFrame() {
        framePointer.pop();
    }
    
}
