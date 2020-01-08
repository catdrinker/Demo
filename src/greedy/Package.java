package greedy;

/**
 * 背包问题 -- 贪心法
 */
public class Package {

    public static final Widget[] widgets = new Widget[]{
            new Widget(35, 10),
            new Widget(30, 40),
            new Widget(60, 30),
            new Widget(50, 50),
            new Widget(40, 35),
            new Widget(10, 40),
            new Widget(25, 30)
    };

    public static int MAX_WEIGHT = 150;


    /**
     * 1. value 最大化选择
     * 2. weight 最小化选择
     * 3. value/weight 最大化选择
     *
     * @return
     */
    public int calculate() {
        int countValue = 0;
        int exitWeight = MAX_WEIGHT;
        while (exitWeight >= 0) {
            int maxVPWIndex = findMaxVPW();
            if (maxVPWIndex == -1) break;
            Widget w = widgets[maxVPWIndex];
            if (exitWeight - w.weight >= 0) {
                w.status = 1;
                exitWeight -= w.weight;
                countValue += w.value;
                System.out.println("find max vpw index is " + maxVPWIndex + " value " + w.value + " weight " + w.weight + " exitWeight " + exitWeight + " vpw " + w.v_p_w);
            } else {
                w.status = 2;
            }
        }
        return countValue;
    }

    public int calculateWeight() {
        int countValue = 0;
        int exitWeight = MAX_WEIGHT;
        while (exitWeight >= 0) {
            int minWeightIndex = findMinWeight();
            if (minWeightIndex == -1) break;
            Widget w = widgets[minWeightIndex];
            if (exitWeight - w.weight >= 0) {
                exitWeight -= w.weight;
                countValue += w.value;
                System.out.println("find min weight index is " + minWeightIndex + " value " + w.value + " weight " + w.weight + " exitWeight " + exitWeight + " vpw " + w.v_p_w);
            }
        }
        return countValue;
    }

    public int calculateValue() {
        int countValue = 0;
        int exitWeight = MAX_WEIGHT;
        while (exitWeight >= 0) {
            int maxValueIndex = findMaxValue();
            if (maxValueIndex == -1) break;
            Widget w = widgets[maxValueIndex];
            if (exitWeight - w.weight >= 0) {
                exitWeight -= w.weight;
                countValue += w.value;
                System.out.println("find min weight index is " + maxValueIndex + " value " + w.value + " weight " + w.weight + " exitWeight " + exitWeight + " vpw " + w.v_p_w);
            }
        }
        return countValue;
    }

    private int findMaxValue() {
        int maxValue = 0;
        int index = -1;
        for (int i = 0; i < widgets.length; i++) {
            if (widgets[i].status == 0 && widgets[i].value >= maxValue) {
                index = i;
                maxValue = widgets[i].value;
            }
        }
        if (index != -1) {
            widgets[index].status = 1;
        }
        return index;
    }

    private int findMinWeight() {
        int minWeight = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < widgets.length; i++) {
            if (widgets[i].status == 0 && widgets[i].weight <= minWeight) {
                index = i;
                minWeight = widgets[i].weight;
            }
        }
        if (index != -1) {
            widgets[index].status = 1;
        }
        return index;
    }

    private int findMaxVPW() {
        float maxVPW = 0.0f;
        int index = -1;

        for (int i = 0; i < widgets.length; i++) {
            if (widgets[i].status == 0 && widgets[i].v_p_w >= maxVPW) {
                index = i;
                maxVPW = widgets[i].v_p_w;
            }
        }
        /*if (index != -1) {
            widgets[index].status = 1;
        }*/
        return index;
    }


    public static void main(String[] args) {
        Package p = new Package();
        int maxValue = p.calculate();

        System.out.println("max value is " + maxValue);
    }


}

class Widget {
    int weight = 0;
    int value = 0;

    float v_p_w = 0.0f;

    int status = 0;

    public Widget(int weight, int value) {
        this.weight = weight;
        this.value = value;
        v_p_w = value / (weight * 1.0f);
    }

    @Override
    public String toString() {
        return "Widget{" +
                "weight=" + weight +
                ", value=" + value +
                ", v_p_w=" + v_p_w +
                ", status=" + status +
                '}';
    }
}