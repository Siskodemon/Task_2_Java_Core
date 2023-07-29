package task_2;

import javax.security.auth.kerberos.EncryptionKey;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class second_point {

    public static void Init_String() {
        char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',' '};
        Scanner input = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = input.nextLine();
        System.out.println("Введённый текст - "+ text);
        System.out.println("Введите шаг сдвига (число, на которое сдвигаем алфавит): ");
        int step = input.nextInt();
        char[] encryp_alphabet = new char[alphabet.length];
        encryp_alphabet = Encrypting_alphabet(alphabet,step);
        System.out.println("Шифруем или расшифровываем?(1/2): ");
        int chois = input.nextInt();
        boolean encrypt;
        if (chois == 1)
            encrypt=true;
        else encrypt=false;
        System.out.println("Полученный текст - " + Encrypting_text(alphabet,encryp_alphabet,text,encrypt,step));
        }

        public static char[] Encrypting_alphabet(char[] alphabet, int step){
            char[] buff_array_alphabet = new char[step];
            char[] buff_alphabet = new char[alphabet.length];
            int index = 0;
            for (int i = 0; i < step; i++) {
                buff_array_alphabet[index] = alphabet[i];
                index++;
            }
            System.out.println("Буквы алфавита,перемещаемые в конец зашифрованного алфавита: " + Arrays.toString(buff_array_alphabet));
            index = 0;
            for (int i = 0; i < alphabet.length; i++) {
                if (i + step <= alphabet.length-1) buff_alphabet[i] = alphabet[i + step];
                else {
                    buff_alphabet[i] = buff_array_alphabet[index];
                    index++;
                }
            }
            return buff_alphabet;
        }

        public static String Encrypting_text(char[] alphabet1,char[] alphabet2,String text,boolean encrypt,int step) {
            System.out.println("Изначальный алфавит - " + Arrays.toString(alphabet1));
            System.out.println("Зашифрованный алфавит - " + Arrays.toString(alphabet2));
            char[] chars = text.toCharArray();
            boolean error = false;
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < alphabet1.length; j++) {
                    if (encrypt == true) {
                        if (chars[i] == alphabet1[j]) {
                            chars[i] = alphabet2[j];
                            break;
                        } else if (j == alphabet1.length) {
                            System.out.printf("Символ строки под индексом '%s' не входит в рамки шифрованного алфавита!!!", chars[i]);
                            error = true;
                            break;
                        }
                    }else {
                        if (chars[i] == alphabet2[j]) {
                            chars[i] = alphabet1[j];
                            break;
                        } else if (j == alphabet2.length) {
                            System.out.printf("Символ строки под индексом '%s' не входит в рамки шифрованного алфавита!!!", chars[i]);
                            error = true;
                            break;
                        }
                    }
                }
                if (error == true) break;
            }
            return String.valueOf(chars);
        }
}
