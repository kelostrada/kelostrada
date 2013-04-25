package LamaczHasel;

/**
 * @author bartosz.kalinowski
 */

public class LockedRepository {
    Object encryptedContent;
    Password password;
    boolean locked = true;
    
    public LockedRepository(Object content, Password password) {
        this.encryptedContent = content;
        this.password = password;
    }

    public boolean isLocked() {
        return locked;
    }
    
    public boolean tryUnlock(Password password) throws ContentLockedException {
        if (this.password.equals(password)) {
            locked = false;
            password.setFound(true);
        } else {
            throw new ContentLockedException();
        }
        
        return !locked;
    }
    
    public Object getContent() throws ContentLockedException {
        if (!locked) {
            return encryptedContent;
        }
        else {
            throw new ContentLockedException();
        }
    }
    
    private class ContentLockedException extends Exception {
        public ContentLockedException() {
            super("Content is locked by password.");
        }
    }
}
