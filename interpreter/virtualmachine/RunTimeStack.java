package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Stack;

class RunTimeStack {

    private final ArrayList<Integer> runTimeStack;
    private final Stack<Integer>     framePointer;

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
        String base = "[";
        int value;
        for (int i = 0; i < framePointer.size(); i++) {
            if (i > 0) {
                base += "] [";
            }
            if (i != framePointer.size() - 1) {
                value = framePointer.get(i + 1);
            } else {
                value = framePointer.size();
            }
            for (int j = framePointer.get(i); j < value; j++) {
                if (j == value - 1) {
                    base += runTimeStack.get(j);
                } else {
                    base += runTimeStack.get(j) + ",";
                }
            }
        }
        System.out.println(base + "]");
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
        int temp = runTimeStack.get(lastIndex());
        runTimeStack.remove(lastIndex());
        runTimeStack.set(framePointer.peek() + offset, temp);
        return temp;
    }

    public int load(int offset) {
        int currentFrame = framePointer.peek();
        int value = runTimeStack.get(currentFrame + offset);
        runTimeStack.add(value);
        return value;
    }

    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame() {
        int currentFrameIndex = framePointer.peek();
        for (int i = lastIndex(); i >= currentFrameIndex; i--) {
            runTimeStack.remove(i);
        }
        framePointer.pop();
    }

    public int stackSize() {
        return this.runTimeStack.size();
    }

    public int frameSize() {
        return stackSize() - framePointer.peek();
    }

    public ArrayList<Integer> frameElements() {
        int frameIndex = framePointer.peek();
        ArrayList<Integer> frameElements = new ArrayList<>();
        for (int i = frameIndex; i < stackSize(); i++) {
            frameElements.add(runTimeStack.get(i));
        }
        return frameElements;
    }
}
