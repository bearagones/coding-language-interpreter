package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    int userInput;

    // Read ByteCode has 0 args
    @Override
    public void init(ArrayList<String> args) {
    }

    // Read ByteCode reads input from the user (only integers)
    @Override
    public void execute(VirtualMachine vm) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        this.userInput = scanner.nextInt();
        vm.push(this.userInput);
    }

    @Override
    public String toString() {
        return "READ";
    }
}
