package bank.dto;

public class ForgotPassword {
    private String email;
    private String newPwd;
    private String confirmPwd;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public ForgotPassword(String email, String newPwd, String confirmPwd) {
        this.email = email;
        this.newPwd = newPwd;
        this.confirmPwd = confirmPwd;
    }

    @Override
    public String toString() {
        return "ForgotPassword [email=" + email + ", newPwd=" + newPwd + ", confirmPwd=" + confirmPwd + "]";
    }
}

