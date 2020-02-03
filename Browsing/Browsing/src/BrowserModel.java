import java.util.Stack;

/**
 * 
 * @author rileyp
 *
 */
public class BrowserModel {

	private BrowserView v;
	private Stack<Integer> fwd;
	private Stack<Integer> back;
	private int lineNum;

	public BrowserModel(BrowserView view) {
		v = view;
		v.update(0);

		fwd = new Stack<Integer>();
		back = new Stack<Integer>();
		lineNum = 0;
	}

	public boolean hasBack() {
		return !back.isEmpty();
	}

	public boolean hasForward() {
		return !fwd.isEmpty();
	}

	public void back() {
		if (hasBack()) {
			fwd.push(lineNum);
			lineNum = back.pop();
			v.update(lineNum);
		}
	}

	public void forward() {
		if(hasForward()){
			back.push(lineNum);
			lineNum = fwd.pop();
			v.update(lineNum);
		}
	}

	public void home() {
		followLink(0);
		back.clear();
	}

	public void followLink(int n) {
		fwd.clear();
		back.push(lineNum);
		v.update(n);
		lineNum = n;
	}
}
