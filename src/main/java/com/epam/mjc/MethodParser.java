package com.epam.mjc;

import java.util.*;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] nameAndArgumentPart = signatureString.split("[()]");

        String[] namePart = nameAndArgumentPart[0].split(" ");
        String functionName = namePart[namePart.length - 1];

        List<MethodSignature.Argument> argumentList = new ArrayList<>();

        if(nameAndArgumentPart.length == 2) {
            String[] argumentPart = nameAndArgumentPart[1].split("\\s|,\\s*");
            for(int i = 0; i < argumentPart.length; i += 2) {
                argumentList.add(new MethodSignature.Argument(argumentPart[i], argumentPart[i + 1]));
            }
        }

        MethodSignature methodSignature = new MethodSignature(functionName, argumentList);

        methodSignature.setReturnType(namePart[namePart.length - 2]);
        if (namePart.length == 3) {
            methodSignature.setAccessModifier(namePart[namePart.length - 3]);
        }

        return methodSignature;
    }
}
