import java.util.*;
/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 *
 * @description implement CatDogQue supporting :
 * add(), pollAll(), pollDog(), pollCat(),isEmpty(), isDogEmpty(), isCatEmpty()
 */
public class CatDogQueue {
    Deque<PetWrap> dogQueue;
    Deque<PetWrap> catQueue;
    int count;

    public CatDogQueue() {
        dogQueue = new ArrayDeque<>();
        catQueue = new ArrayDeque<>();
        count = 0;
    }

    public void add(Pet p) {
        count++;
        if (p.getType().equals("dog")) {
            dogQueue.offer(new PetWrap(p,count));
        } else {
            catQueue.offer(new PetWrap(p,count));
        }
    }

    public Pet pollAll() {
        if(count == 0) {
            throw new RuntimeException("queue is empty");
        }
        while(count > 1) {
            count--;
            if (dogQueue.peekFirst() == null) {
                catQueue.poll();
            } else if (catQueue.peekFirst() == null) {
                dogQueue.poll();
            } else if (dogQueue.peekFirst().mark < catQueue.peekFirst().mark) {
                dogQueue.poll();
            } else {
                catQueue.pop();
            }
        }
        if(dogQueue.isEmpty()) {
            return catQueue.poll().pet;
        } else {
            return dogQueue.poll().pet;
        }
    }

    public Pet pollDog(){
        if (dogQueue.size() == 0) {
            throw new RuntimeException("your queue is empty");
        }
        count--;
        return dogQueue.poll().pet;
    }

    public Pet pollCat() {
        if (catQueue.size() == 0) {
            throw new RuntimeException("your queue is empty");
        }
        count--;
        return catQueue.poll().pet;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isDogEmpty(){
        if(dogQueue.peekFirst() == null) {
            return true;
        }
        return false;
    }

    public boolean isCatEmpty(){
        if(catQueue.peekFirst() == null) {
            return true;
        }
        return false;
    }

    public static class Pet{
        private String type;
        int number;

        public Pet(String t, int n) {
            this.type = t;
            this.number = n;
        }

        public String getType() {
            return this.type;
        }

        public int getNumber() {
            return this.number;
        }
    }

    public class Dog extends Pet{

        public Dog(String t, int n) {
            super("dog", n);
        }
    }

    public class Cat extends Pet{

        public Cat(String t, int n) {
            super("cat", n);
        }
    }

    public class PetWrap {
        private Pet pet;
        private int mark;

        public PetWrap(Pet p, int m) {
            this.pet = p;
            this.mark = m;
        }
    }

    public static void main(String[] args) {
        CatDogQueue q = new CatDogQueue();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            if(str.equals("pollAll")) {
                Pet p= q.pollAll();
                System.out.println(p.getType()+ " "+ p.getNumber());
            } else if(str.equals("isEmpty")) {
                System.out.println(q.isEmpty());
            } else if(str.equals("isDogEmpty")) {
                System.out.println(q.isDogEmpty());
            } else if (str.equals("isCatEmpty")) {
                System.out.println(q.isCatEmpty());
            } else if (str.equals("pollCat")) {
                Pet p = q.pollCat();
                System.out.println(p.getType()+ " " + p.getNumber());
            } else if(str.equals("pollDog")) {
                Pet p = q.pollDog();
                System.out.println(p.getType() + " " + p.getNumber());
            } else {
                String[] strArr = str.split(" ");
                Pet p = new Pet(strArr[1],Integer.parseInt(strArr[2]));
                q.add(p);
            }
        }

    }
}
