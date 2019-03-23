
public class BST {
	BSTNode root;
	int size;

	public BST() {
		root = null;
		size = 0;
	}

	public BST(BSTNode root, int size) {
		this.root = root;
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}

	public Iterator find(int v) {
		BSTNode temp = root;

		while (temp != null && temp.data != v) {
			if (v < temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null) // not found
			return null;
		return new TreeIterator(temp);
	}

	public Iterator insert(int v) {
		BSTNode parent = null;
		BSTNode temp = root;

		// This first part is almost the same as find,
		// but it has an extra pointer called parent.
		while (temp != null && temp.data != v) {
			if (v < temp.data) {
				parent = temp;
				temp = temp.left;

			} else {
				parent = temp;
				temp = temp.right;

			}
		}

		if (temp == null) {
			BSTNode n = new BSTNode(v, null, null, parent);
			if (parent == null) {
				root = n;
			} else if (v < parent.data) {
				parent.left = n;
			} else {
				parent.right = n;
			}
			size++;
			return new TreeIterator(n);
		} else {
			// we do nothing since
			// we don't want to add duplicated data.
			return null;
		}

	}

	public void remove(int v) {
		BSTNode parent = null;
		BSTNode temp = root;

		TreeIterator i = (TreeIterator) find(v);
		if (i == null) { // not found, we can not remove it
			return;
		}

		temp = i.currentNode;
		parent = temp.parent;

		// otherwise, we remove the value.
		size--;
		if (temp.left == null && temp.right == null) {// both subtrees are empty
			if (parent == null) {
				root = null;
			} else if (parent.left == temp) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (temp.left == null && temp.right != null) {// only right child
			if (parent == null) {
				root = temp.right;
				root.parent = null;
			} else if (parent.right == temp) {
				BSTNode n = temp.right;
				n.parent = parent;
				parent.right = n;
				// temp.right = null;
				// temp.parent = null;
			} else {// parent.left == temp
				BSTNode n = temp.right;
				n.parent = parent;
				parent.left = n;
			}
		} else if (temp.right == null && temp.left != null) {
			if (parent == null) {
				root = temp.left;
				root.parent = null;
			} else if (parent.right == temp) {
				BSTNode n = temp.left;
				n.parent = parent;
				parent.right = n;
			} else {
				BSTNode n = temp.left;
				n.parent = parent;
				parent.left = n;

			}

		} else {// temp has two subtrees
			BSTNode n = temp.right;
			TreeIterator itr = findMin(n);
			BSTNode minInSubtree = itr.currentNode;

			temp.data = minInSubtree.data;

			BSTNode parentOfMin = minInSubtree.parent;
			if (parentOfMin.left == minInSubtree) {
				parentOfMin.left = minInSubtree.right;

			} else { // parentOfMin.right == minInSubtree
				parentOfMin.right = minInSubtree.right;

			}

			if (minInSubtree.right != null) {
				minInSubtree.right.parent = parentOfMin;
			}

		}
	}

	public TreeIterator findMin(BSTNode n) {
		BSTNode temp = n;
		while (temp.left != null) {
			temp = temp.left;
		}
		TreeIterator itr = new TreeIterator(temp);
		return itr;
	}
	


	public boolean hasGreaterValueThan(int v)throws Exception{
		// write code for this method
		BSTNode temp = root;
		if (temp == null)  return false;
		while (temp.right!=null) {
			temp=temp.right;
		}
		TreeIterator itr = new TreeIterator(temp);
		if (itr.currentNode.data>v)  return true;
		return false;
		
	}

	public BST difference(BST t) throws Exception {
		// write code for this method
		if (this.isEmpty()) return new BST();
		if (t.isEmpty()) return this;
		
		BST ret = new BST();
		
		TreeIterator itr = new TreeIterator(root);
		TreeIterator itr2 = new TreeIterator(t.root);
		int count=0;
		
		itr= findMin (root);
		itr2 = t.findMin(t.root);		
		

		while (itr.currentNode!=null) {
			count=0;
			int temp1 = itr.currentNode.data;
			itr2= t.findMin (t.root);
			while (itr2.currentNode!=null) {
				if (temp1==itr2.currentNode.data) {
					count++;
				}
				if (itr2.hasNext()==false) break;
				itr2.next();
			}
			if (count==0) {
				ret.insert(temp1);
			}
			if (itr.hasNext()==false) break;
			itr.next();
		}
				
		return ret;
	}
	
	public static BST fixTree (BST x)throws Exception {
		
		
		TreeIterator itr = x.findMin(x.root);
		BSTNode b = new BSTNode(itr.currentNode.data);
		BST ret = new BST(b,1);
		
		while (itr.hasNext())
		{
			ret.insert(itr.next());
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		// Printing example.
		// You can print how the tree looks to help with debugging.

		BSTNode r = new BSTNode(7);
		BST t = new BST(r, 1);
		t.insert(3);
		t.insert(11);
		t.insert(2);
		t.insert(5);
		t.insert(8);
		
		BST test = fixTree(t);

		BTreePrinter.printNode(test.root);

	}

}
