import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

class Solution {
	// �̰� TreeSet���� �ؾ��� ��
	//TreeMap<Integer, Integer> NoneA = new TreeMap<>();
	ArrayList<ArrayList<TreeMap<Integer,Integer>>> NoneB = new ArrayList<>();
	String str;
	int sum=0;
    public int solution(String name) {
    	str = name;
    	ArrayList<TreeMap<Integer,Integer>> a = new ArrayList<>();
    	for (int i=0; i<name.length();i++) {
    		if (name.charAt(i)!='A') {
    			TreeMap<Integer, Integer> tree = new TreeMap<>();
    			tree.put(i, 0);
    			a.add(tree);
    		}
    	}
    	NoneB.add(a);
    	System.out.println(NoneB);
    	this.horizonMove(0, -1, 0, 0, sum); // index = 0���� ���ϰ� ���� ��
    	//this.horizonMove(0, -1, 1, 0); // �������� ���� ��
        int answer = 0;
        return answer;
    }
    public void horizontal(String name) {
    	
    }
    // Case 1���� ������ ����
    public int horizonMove(int curindex , int index, int direct, int length, int sum ) { // curindex : �� ��ġ index : A�� �ƴ� �͵鿡 ���� ������
    	int len =0;
    	NoneB.add(NoneB.get(sum));
    	System.out.println("����ġ "+curindex+"���̴� "+length+"�ε�����  "+index+"�� ��� ���ù޾Ҵ���"+sum);
    	if (sum==NoneB.get(sum+1).size()) {
    		System.out.println("���� Length"+length+"///"+curindex);
    		return length; // index�� �� ä�������� �ƴϿ��� ��
    	}
    	if (direct==0) { // 0 : ���������� ��
    		int amount=0;
    		while(true) {
    			index+=1;
    			if (index>=NoneB.get(sum+1).size()) {
    				index-=NoneB.get(sum+1).size();
    				amount = (str.length()-curindex);
    				curindex=0;
    				len = amount+NoneB.get(sum+1).get(index).firstKey();
    			}
    			else {
    				System.out.println("�� ���� �ֳ�");
    				len = amount + ( NoneB.get(sum+1).get(index).firstKey() - curindex ); // �ʹ� ��ƴ� : ����� ���� ��
    			}
    			if (NoneB.get(sum+1).get(index).get(NoneB.get(sum+1).get(index).firstKey())==0) { // ã����
    				break;
    			}
    		}
    		length+= len;
    		curindex = NoneB.get(sum+1).get(index).firstKey();
    		System.out.println(NoneB+"%%");
    		NoneB.get(sum+1).get(index).replace(NoneB.get(sum+1).get(index).firstKey(), NoneB.get(sum+1).get(index).getOrDefault(NoneB.get(sum+1).get(index).firstKey(), 0)+1);
    		System.out.println(NoneB+"%%");
    		
    		System.out.println(NoneB);
    		System.out.println(NoneB.get(sum+1)+" || "+curindex+" || "+index+"||"+sum);
    		this.horizonMove(curindex, index, 0, length, sum+1);
    		//System.out.println(arr+" || "+curindex+" || "+index);
    		System.out.println(NoneB);
    		System.out.println("�ƴ� ��� �̷��� ������"+NoneB.get(sum+1)+" || "+curindex+" || "+index+" || "+sum);
    		this.horizonMove(curindex, index, 1, length, sum+1);
    		
    	}
    	
    	if (direct==1) { // 1 : �������� ��
    		while(true) { /// whiletrue�� ��� ���� �Ͱ���
    			index-=1;
    			if (index<0) {
    				index = NoneB.get(sum+1).size()+index;
    				len = length+(str.length()-NoneB.get(sum+1).get(index).firstKey()); /////////// �̰͵� �ٽ��ؾ���
    			}
    			else {
    				len = curindex - NoneB.get(sum+1).get(index).firstKey();
    			}
    			if (NoneB.get(sum+1).get(index).get(NoneB.get(sum+1).get(index).firstKey())==0) { // ã����
    				break;
    			}
    		}
    		length+= len; // NoneA�� ������ �Ȱ������� �ñ���
    		curindex = NoneB.get(sum+1).get(index).firstKey();
    		NoneB.get(sum+1).get(index).replace(NoneB.get(sum+1).get(index).firstKey(), NoneB.get(sum+1).get(index).getOrDefault(NoneB.get(sum+1).get(index).firstKey(), 0)+1);
    		sum++;
    		ArrayList<TreeMap<Integer,Integer>> arr = new ArrayList<>(NoneB.get(sum+1));
    		//System.out.println("����ġ "+curindex+"���̴� "+length+"�ε�����  "+index+"�� ��� ���ù޾Ҵ���"+sum);
    		this.horizonMove(curindex, index, 0, length, sum);
    	}
    	return 0;
    	
    }
}
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str1 = "ABABAAAAAAABA";
		String str2 = "JAARA";
		s.solution(str1);
		
	}

}
