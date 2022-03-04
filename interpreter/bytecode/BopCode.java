package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.HashMap;

public class BopCode extends ByteCode {
    String value;
    int firstOperand;
    int secondOperand;

    @Override
    public void init(ArrayList<String> args) {
        this.value = args.get(0);
    }

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

        vm.push(bopMap.get(this.value));
    }

    @Override
    public String toString() {
        return "BOP " + value;
    }
}
