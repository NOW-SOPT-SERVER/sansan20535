import org.sopt.entity.Customer;
import org.sopt.repository.BankRepository;
import org.sopt.repository.BankRepositoryImpl;
import org.sopt.service.BankService;
import org.sopt.service.BankServiceImpl;

public class ClassesTest {
    public static void main(String[] args) {
        BankRepository bank = new BankRepositoryImpl();
        BankService bankService = new BankServiceImpl();

        // repository 테스트
        bank.save(new Customer(1L, "의진", "1111", 5000L));
        bank.save(new Customer(2L, "미진", "2222", 10000L));
        Customer want = bank.findByAccount("2222");

        System.out.println("want.getId() = " + want.getId());
        System.out.println("want.getName() = " + want.getName());
        System.out.println("want.getAccount() = " + want.getAccount());
        System.out.println("want.getAsset() = " + want.getAsset());
        System.out.println("-------------------------------------------");

        // service 테스트
        Customer want2 = bank.findByAccount("1111");
        bankService.deposit(want, 3000L);
        System.out.println("want.getAsset() = " + want.getAsset());
        bankService.withdraw(want, 2000L);
        System.out.println("want.getAsset() = " + want.getAsset());
        bankService.accountTransfer(want, want2, 2000L);
        System.out.println("want.getAsset() = " + want.getAsset());
        System.out.println("want2.getAsset() = " + want2.getAsset());
    }
}
