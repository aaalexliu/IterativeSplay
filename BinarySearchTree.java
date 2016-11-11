import java.lang.Integer;

public class BinarySearchTree implements IntSet301 {

	private Node root;
	private int size;
	public int add;
	public int addCount;
	public int addNode;
	public int addNodeCount;
	public int successor;
	public int successorCount;
	public int remove;
	public int splay;
	public int splayCount;
	public int contains;
	public int containsCount;
	public int delete;
	public int deleteCount;

	public BinarySearchTree(){
		root = new Node();
		root.setParent(null);
		size = 0;

	}


	@Override
	public void add(int n){
		add++;
		// if(contains(n)){
		// 	return;
		// }
		// else{
			Node curr = root.getRight();
			Node parent = root;

			while(curr != null){
				addCount++;

				if(n == curr.getStart() - 1){

					successor++;
					//System.out.println("ONE LESS, CHECKING IF TO EDIT CURRENT NODE");
					Node predecessor = predecessor(curr);
					if(predecessor != null){
						if(predecessor.getEnd() + 1 == n){
							//System.out.println("MERGING");
							curr.setStart(predecessor.getStart());
							delete(predecessor);	
						}
						else{
							//System.out.println("NOT MERGING");
							curr.setStart(n);
						}
					}
					else{
						//System.out.println("PREDECESSOR NOT FOUND, EDITING CURRENT NODE");
						curr.setStart(n);
					}
					size++;
					splay(curr);
					return;
				}
				else if(n == curr.getEnd() + 1){
					successor++;
					//System.out.println("ONE MORE, CHECKING IF TO EDIT CURRENT NODE");
					Node successor = successor(curr);
					if(successor != null){
						//System.out.println("FOUND SUCCESSOR: ");
						//System.out.println(successor);
						if(successor.getStart() - 1 == n){
							//System.out.println("MERGING");
							curr.setEnd(successor.getEnd());
							delete(successor);
						}
						else{
							//System.out.println("NOT MERGING");
							curr.setEnd(n);
						}
					}
					else{
						//System.out.println("SUCCESSOR NOT FOUND, EDITING CURRENT NODE");
						curr.setEnd(n);
					}
					size++;
					splay(curr);
					return;
				}
				else if(n < curr.getStart() - 1){
					//System.out.println("LESS THAN CURRENT NODE, GOING LEFT");
					parent = curr;
					curr = curr.getLeft();
				}
				else if(n > curr.getEnd() + 1){
					parent = curr;
					curr = curr.getRight();
				}
				else if(n >= curr.getStart() && n<=curr.getEnd()){
					return;
				}
			}
			if(parent == root){
				Node temp = new Node(n,n);
				root.setRight(temp);
				temp.setParent(root);
				//System.out.println("Is parent root: " + temp.getParent().isRoot());

			}
			else{
				//System.out.println("NOT ROOT, ADDING TO:");
				//System.out.println(parent);
				Node temp = new Node(n,n);

				if(n < parent.getStart() - 1){
					//System.out.println("SETTING AS LEFT CHILD");
					temp.setParent(parent);
					parent.setLeft(temp);
				}
				else if(n > parent.getEnd() + 1){
					//System.out.println("SETTING AS RIGHT CHILD");
					temp.setParent(parent);
					parent.setRight(temp);

				}
				splay(temp);

			}
			size++;
		// }
	}

	public void remove(int n){
		if(!contains(n)){
			return;
		}
		else{
			Node curr = root.getRight();
			if(n == curr.getEnd()){
				if(n == curr.getStart()){
					delete(curr);
				}
				else{
					curr.setEnd(n-1);
				}
			}
			else if(n == curr.getStart()){
				if(n == curr.getEnd()){
					delete(curr);
				}
				else{
					curr.setStart(n+1);
				}
			}
			else{
				Node temp = new Node(n+1, curr.getEnd());
				curr.setEnd(n-1);
				add(temp);
			}
			size--;
		}
	}

	private void add(Node a){
		Node curr = root.getRight();
		Node parent = root;
		addNode++;

		while(curr != null){
			addNodeCount++;
			parent = curr;
			if(curr.getEnd() < a.getStart()){
				curr = curr.getRight();
			}
			else if(curr.getStart() > a.getEnd()){
				curr = curr.getLeft();
			}
		}
		if(parent == root){
			root.setRight(a);
			a.setParent(root);
		}
		else{

			if(parent.getEnd() < a.getStart()){
				parent.setRight(a);
				a.setParent(parent);
			}
			else if(parent.getStart() > a.getEnd()){
				parent.setLeft(a);
				a.setParent(parent);
			}
		}
	}

	//check this method
	private void delete(Node curr)
    {


	if (curr.getLeft() == null && curr.getRight() == null)
	    {
		Node parent = curr.getParent();
		if (curr.isLeftChild())
		    {
			parent.setLeft(null);
		    }
		else if (curr.isRightChild())
		    {
			parent.setRight(null);
		    }
	    }
	else if (curr.getLeft() == null)
	    {
		// node to delete only has right child
		Node parent = curr.getParent();

		if (curr.isLeftChild())
		    {
			parent.setLeft(curr.getRight());
			curr.getRight().setParent(parent);
		    }
		else if (curr.isRightChild())
		    {
			parent.setRight(curr.getRight());
			curr.getRight().setParent(parent);
		    }
	    }
	else if (curr.getRight() == null)
	    {
		// node to delete only has left child
		Node parent = curr.getParent();

		if (curr.isLeftChild())
		    {
			parent.setLeft(curr.getLeft());
			curr.getLeft().setParent(parent);
		    }
		else if (curr.isRightChild())
		    {
			parent.setRight(curr.getLeft());
			curr.getLeft().setParent(parent);
		    }
	    }
	else
	      {
	      	delete++;
		  // node to delete has two children

		  // find inorder successor (leftmopst in right subtree)
		  Node replacement = curr.getRight();
		  while (replacement.getLeft() != null)
		      {
		      deleteCount++;
			  replacement = replacement.getLeft();
		      }

		  Node replacementChild = replacement.getRight();
		  Node replacementParent = replacement.getParent();

		  // stitch up
		  if (curr.isLeftChild())
		      {
			  curr.getParent().setLeft(replacement);
		      }
		  else if (curr.isRightChild())
		      {
			  curr.getParent().setRight(replacement);
		      }
		  if(replacement.getParent() != curr){
		  	replacement.getParent().setLeft(replacementChild);
			  if (replacementChild != null)
			       {
				   replacementChild.setParent(replacement.getParent());
			      }
			   replacement.setRight(curr.getRight());
	  			curr.getRight().setParent(replacement);
			}
		  

		  replacement.setLeft(curr.getLeft());
		  curr.getLeft().setParent(replacement);

		  replacement.setParent(curr.getParent());
	      }
    }

	public int size(){
		return size;
	}

	public int nextExcluded(int n){
		Node curr = root.getRight();
		Node parent = root;
		int answer;


		while(curr != null){
			if(n >= curr.getStart() && n <= curr.getEnd()){
				return curr.getEnd() + 1;
			}
			if(n > curr.getEnd()){
				parent = curr;
				curr = curr.getRight();
			}
			else if(n < curr.getStart()){
				parent = curr;
				curr = curr.getLeft();	
			}
		}
		return n;
	}

	public boolean contains(int n){
		Node curr = root.getRight();
		Node parent = root;
		contains++;

		while(curr != null && curr.hasData()){
			containsCount++;
			if(n >= curr.getStart() && curr.getEnd() >= n){
				splay(curr);
				return true;
			}
			else if(n < curr.getStart()){
				parent = curr;
				curr = curr.getLeft();
			}
			else if(n > curr.getEnd()){
				parent = curr;
				curr = curr.getRight();
			}
		}
		if(parent != root){
			splay(parent);
		}

		return false;

	}
	public Node successor(Node curr){
		if(curr.getRight() != null){
			curr = curr.getRight();
			while(curr.getLeft() != null){
				curr = curr.getLeft();
				successorCount++;
			}
			return curr;
		}
		else{
			Node next = curr.getParent();
			while(next != root && next.getRight() == curr){
				successorCount++;
				if(next == root){
					return null;
				}
				curr = next;
				next = next.getParent();
			}
			if(next == root){
				return null;
			}
			else{
				return next;
			}
		}
    }

    public Node predecessor(Node curr){
    	//System.out.println("FINDING PREDECESSOR");
    	if(curr.getLeft() != null){
    		curr = curr.getLeft();
    		while(curr.getRight() != null){
    			curr = curr.getRight();
    			successorCount++;
    		}
    		return curr;
    	}
    	else{

	    	Node previous = curr.getParent();
	    	while(previous != root && previous.getLeft() == curr){
	    		curr = previous;
	    		previous = previous.getParent();
	    		successorCount++;
	    	}
    		if(previous == root){
	    			//System.out.println("PREDECSSOR FOUND ROOT, RETURNING NULL");
	    			return null;
    		}
    		else{
	    		return previous;
	    	}
    	}
    }


	public void rightRotation(Node curr){

		Node right = curr.getRight();
		Node parent = curr.getParent();
		Node grandparent = parent.getParent();

		//System.out.println("ROTATING RIGHT, NODE: " + curr + " PARENT: " + parent + " GRANDPARENT: " + grandparent);

		if(parent.isLeftChild()){
			grandparent.setLeft(curr);
		}
		else if(parent.isRightChild()){
			//System.out.println("SETTING AS RIGHT");
			grandparent.setRight(curr);
		}

		curr.setParent(parent.getParent());
		curr.setRight(parent);
		parent.setParent(curr);
		parent.setLeft(right);
		if(right != null){
			right.setParent(parent);
		}

	}

	public void leftRotation(Node curr){
		Node left = curr.getLeft();
		Node parent = curr.getParent();
		Node grandparent = parent.getParent();
		if(parent.isLeftChild()){
			grandparent.setLeft(curr);
		}
		else{
			grandparent.setRight(curr);
		}

		curr.setParent(parent.getParent());
		curr.setLeft(parent);
		parent.setParent(curr);
		parent.setRight(left);
		if(left != null){
			left.setParent(parent);
		}
	}

	private void splay(Node curr){
		//System.out.println("SPLAYING " + curr);
		splay++;

		while(curr != root.getRight()){
			splayCount++;

			Node parent = curr.getParent();

			if(parent == root.getRight()){
				//System.out.println("PARENT IS ROOT");
				if(curr.isLeftChild()){
					//System.out.println("ROOT RIGHT ROTATION");
					rightRotation(curr);
				}
				else{
					//System.out.println("ROOT LEFT ROTATION");
					leftRotation(curr);
				}
			}
			else{
				if(curr.isLeftChild()){
					if(parent.isLeftChild()){
						//System.out.println("LEFT LEFT CASE");
						rightRotation(parent);
						rightRotation(curr);
					}
					else if(parent.isRightChild()){
						//System.out.println("RIGHT LEFT CASE");
						rightRotation(curr);
						leftRotation(curr);
					}
				}

				else if(curr.isRightChild()){
					if(parent.isRightChild()){
						//System.out.println("RIGHT RIGHT CASE");
						leftRotation(parent);
						leftRotation(curr);
					}
					else if(parent.isLeftChild()){
						//System.out.println("LEFT RIGHT CASE");
						leftRotation(curr);
						rightRotation(curr);
					}
				}
			}	
		}
	}


	public class Node {
		private Node parent;
		private Node left;
		private Node right;
		private Integer start;
		private Integer end;

		public String toString(){
			if(this == root){
				return new String("ROOT");
			}
			return new String("NODE: " + start.intValue() + " " + end.intValue());
		}
		public Node(int s, int e){
			start = new Integer(s);
			end = new Integer(e);
		}

		public Node(){
			start = null;
			end = null;
		}

		public void setParent(Node p){
			parent = p;
		}

		public void setLeft(Node l){
			left = l;
		}

		public void setRight(Node r){
			right = r;
		}

		public Node getLeft(){
			return left;
		}

		public Node getRight(){
			return right;
		}

		public Node getParent(){
			return parent;
		}

		public int getStart(){
			return start.intValue();
		}

		public int getEnd(){
			return end.intValue();
		}

		public boolean hasData(){

			if(start == null || end == null) return false;
			else return true;
		}

		public void setStart(int s){
			start = new Integer(s);
		}

		public void setStart(Integer s){
			start = s;
		}

		public void setEnd(Integer e){
			end = e;
		}

		public void setEnd(int e){
			end = new Integer(e);
		}

		private boolean isLeftChild()
		{
		    return (parent != null && parent.left == this);
		}

		private boolean isRightChild()
		{
		    return (parent != null && parent.right == this);
		}

		public boolean isRoot(){
			return (this == root);
		}
	}

	public String toString()
    {
	StringBuilder s = new StringBuilder();
	buildOutput(root.getRight(), s, 0);
	return s.toString();
    }

    /**
     * Appends a printable representation of the subtree rooted at the
     * given node to the given string builder.
     *
     * @param curr a node in this tree
     * @param s a string builder
     * @param depth the depth of curr
     */
    private void buildOutput(Node curr, StringBuilder s, int depth)
    {
	if (curr != null)
	    {
		buildOutput(curr.left, s, depth + 1);
		s.append(depth + " [" + curr.getStart() + ", " + curr.getEnd() + "]" + "\n");
		buildOutput(curr.right, s, depth + 1);
	    }
    }
}