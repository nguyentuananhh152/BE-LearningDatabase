package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.entityDTO.AdminDTO;
import com.example.learningdatabase.entityDTO.StudentDTO;
import com.example.learningdatabase.repository.AccountRepository;
import com.example.learningdatabase.repository.StudentRepository;
import com.example.learningdatabase.repository.UserRepository;
import com.example.learningdatabase.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserServiceImplement userServiceImplement;

    @Autowired
    private StudentServiceImplement studentServiceImplement;

    @Autowired
    private AdminServiceImplement adminServiceImplement;

    public AccountServiceImplement() {}




    @Override
    public Account saveAccount(Account account) {
//        try {
//            if (!accountRepository.existsById(account.getId())) {
//                accountRepository.save(account);
//                return account;
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            return null;
//        }
        try {
            return accountRepository.save(account);
        } catch (Exception e) {
            System.out.println("Error when save Account!!");
            System.out.println(e.getMessage());
            return new Account();
        }
    }

    @Override
    public void updateEmailAccountByID(int id, String email) {
        try {
            if (accountRepository.existsById(id)) {
                Account acc = accountRepository.findById(id).get();
                acc.setEmail(email);
                accountRepository.save(acc);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void changePassword(int id, String oldPass, String newPass) {
        try {
            if (accountRepository.existsById(id)) {
                if (oldPass == accountRepository.findById(id).get().getPassWord()) {
                    Account acc = accountRepository.findById(id).get();
                    acc.setPassword(newPass);
                    accountRepository.save(acc);
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void deleteAccountByID(int id) {
        try {
            if (accountRepository.existsById(id)) {
                accountRepository.deleteById(id);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void deleteAll() {
        try {
            accountRepository.deleteAll();
        } catch(Exception e) {

        }
    }

    @Override
    public boolean exist(int id) {
        if (accountRepository.existsById(id)) {
            return true;
        }
        else return false;
    }

    @Override
    public Account getAccountByID(int id) {
        try {
            if (accountRepository.existsById(id)) {
                Account acc = accountRepository.findById(id).get();
                acc.setPassword("");
                return acc;
            } else {
                return new Account();
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Account> getAllListAccount() {
        try {
            ArrayList<Account> arr = new ArrayList<>();
            accountRepository.findAll().forEach(account -> {
                account.setPassword("");
                arr.add(account);
            });
            return arr;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateIsLoginByID(int id, Boolean b) {
        try {
            if (accountRepository.existsById(id)) {
                accountRepository.findById(id).get().setIsLogin(b);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public StudentDTO loginStudent(String username, String password) {
//        try {
//            int id = accountRepository.getIDAccountByUsername(username, password);
//            if (accountRepository.existsById(id)) {
//                int userID = accountRepository.findById(id).get().getUserid();
//                boolean isAdmin = userServiceImplement.getUserByID(userID).getIsAdmin();
//                if (isAdmin) {
//                    return null;
//                } else {
//                    int studentID = userServiceImplement.getUserByID(userID).getNumberStudentID();
//                    return studentServiceImplement.getStudentByID(studentID);
//                }
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
            return null;
//        }
    }
    @Override
    public AdminDTO loginAdmin(String username, String password) {
//        try {
//            int id = accountRepository.getIDAccountByUsername(username, password);
//            if (accountRepository.existsById(id)) {
//                Account acc = accountRepository.findById(id).get()
//                int userID = acc.getUserid();
//                User user = uerServiceImplement.getUserByID(userID);
//                boolean isAdmin = uer.getIsAdmin();
//                if (!isAdmin) {
//                    return null;
//                } else {
//                    int adminID = user.getNumberAdminID();
//                    Admin admin = adminServiceImplement.getAdminByID(adminID)
//                    return new AdminDTO(acc, user, admin);
//                }
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
            return null;
//        }
    }

    @Override
    public void logOut(int idAccount) {
        try {
            accountRepository.findById(idAccount).get().setIsLogin(false);
        } catch(Exception e) {
        }
    }

    @Override
    public boolean register(String username, String password, String email) {
//        try {
//            int id = accountRepository.existAccountByUsername(username);
//            if (userServiceImplement.exist(id)) {
//                return false;
//            } else {
//                Account acc = new Account();
//                acc.setUserName(username);
//                acc.setPassword(password);
//                acc.setEmail(email);
//                User user = userServiceImplement.saveUser(new User());
//                acc.setUserID(user.getId());
//                acc.setIsLogin(false);
//                accountRepository.save(acc);
//                return true;
//            }
//        } catch (Exception e) {
            return false;
//        }
    }

}
