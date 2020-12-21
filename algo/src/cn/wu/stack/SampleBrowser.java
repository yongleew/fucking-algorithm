package cn.wu.stack;

public class SampleBrowser {

    //private LinkedList<String> backStack = new LinkedList<>();

    //private LinkedList<String> forwardStack = new LinkedList<>();

    LinkedListStack backStack = new LinkedListStack();
    LinkedListStack forwardStack = new LinkedListStack();
    String currPage;

    public void open(String addr) {
        if (currPage != null) {
            backStack.push(currPage);
            forwardStack.clear();
        }
        currPage = addr;
        System.out.println(addr);

    }

    public boolean canBack() {
        return backStack.size() > 0;
    }

    public boolean canForward() {
        return forwardStack.size() > 0;
    }


    public void back() {
        if (canBack()) {
            forwardStack.push(currPage);
            currPage = (String) backStack.pop();
            System.out.println(currPage);
        } else {
            System.out.println("cannot back");
        }
    }

    public void forward() {
        if (canForward()) {
            backStack.push(currPage);
            currPage = (String) forwardStack.pop();
            System.out.println(currPage);
        } else {
            System.out.println("cannot forward");

        }
    }
}
