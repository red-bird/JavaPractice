package Practice3;

class Human
{
    private Hand hand;
    private Leg leg;
    private Head head;
    Human(double HandL, double LegL, double HeadL)
    {
       this.hand = new Hand(HandL);
       this.leg = new Leg(LegL);
       this.head = new Head(HeadL);
    }

    public Hand getHand() {
        return hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public Head getHead() {
        return head;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    private interface ICuttable
    {
        void cut();
    }
    private abstract class Limb
    {
        Limb(double length)
        {
            setLength(length);
        }

        double length;

        public void setLength(double length) {
            this.length = length;
        }

        public double getLength() {
            return length;
        }

    }

    class Hand extends Limb implements ICuttable
    {
        Hand(double length)
        {
            super(length);
        }

        @Override
        public void cut() {
            this.length = 0;
        }
    }

    class Leg extends Limb implements ICuttable
    {
        Leg(double length)
        {
            super(length);
        }

        @Override
        public void cut() {
            this.length = 0;
        }
    }

    class Head extends Limb
    {
        private String msg;
        Head(double length)
        {
            super(length);
            msg = "Hello";
        }

        Head(double length, String msg)
        {
            this(length);
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    }
}
public class HumanTest {
    public static void main(String[] args) {
        Human jo = new Human(10 ,20, 2);
        System.out.println(jo.getHand().length);
        jo.getHand().cut();
        System.out.println(jo.getHand().length);
        System.out.println(jo.getHead().getMsg());
    }
}
