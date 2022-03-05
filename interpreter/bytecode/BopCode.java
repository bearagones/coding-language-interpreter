package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.HashMap;

public class BopCode extends ByteCode {
    String operation;
    int firstOperand;
    int secondOperand;

    // Bop ByteCode has 1 arg -> an operation in the form of a string
    @Override
    public void init(ArrayList<String> args) {
        this.operation = args.get(0);
    }

    // Bop ByteCode pops two values from the stack and performs an operation on them
    @Override
    public void execute(VirtualMachine vm) {
        this.firstOperand = vm.pop();
        this.secondOperand = vm.pop();

        HashMap<String, Integer> bopMap = new HashMap<>();
        bopMap.put("+", this.firstOperand + this.secondOperand);
        bopMap.put("-", this.firstOperand - this.secondOperand);
        bopMap.put("/", this.firstOperand / this.secondOperand);
        bopMap.put("*", this.firstOperand * this.secondOperand);
        bopMap.put("==", (this.firstOperand == this.secondOperand) ? 1:0);
        bopMap.put("!=", (this.firstOperand != this.secondOperand) ? 1:0);
        bopMap.put("<=", (this.firstOperand <= this.secondOperand) ? 1:0);
        bopMap.put(">", (this.firstOperand < this.secondOperand) ? 1:0);
        bopMap.put(">=", (this.firstOperand >= this.secondOperand) ? 1:0);
        bopMap.put("<", (this.firstOperand < this.secondOperand) ? 1:0);
        bopMap.put("|", this.firstOperand | this.secondOperand);
        bopMap.put("&", this.firstOperand & this.secondOperand);

        vm.push(bopMap.get(this.operation));
    }

    @Override
    public String toString() {
        return "BOP " + operation;
    }
}
