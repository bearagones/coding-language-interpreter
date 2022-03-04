package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    String value;

    // Dump ByteCode has 1 arg -> "ON" or "OFF"
    @Override
    public void init(ArrayList<String> args) {
        value = args.get(0);
    }

    // Dump ByteCode requests to turn dumping ON or OFF
    @Override
    public void execute(VirtualMachine vm) {
        switch (value) {
            case "ON" -> vm.dumpOn();
            case "OFF" -> vm.dumpOff();
        }
    }
}
