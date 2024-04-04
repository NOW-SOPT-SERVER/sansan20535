import org.sopt.entity.Customer;

import java.util.Scanner;
import java.util.StringTokenizer;

public class InputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer infoCustomer = new StringTokenizer(scanner.nextLine(), "-");
        Customer customer = new Customer(0L, infoCustomer.nextToken(), infoCustomer.nextToken(), Long.parseLong(infoCustomer.nextToken()));

        // input 입력 양식 테스트
        System.out.println("customer.getId() = " + customer.getId());
        System.out.println("customer.getName() = " + customer.getName());
        System.out.println("customer.getAccount() = " + customer.getAccount());
        System.out.println("customer.getAsset() = " + customer.getAsset());
    }
}
