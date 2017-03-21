/**
 * Created by shubhankar on 10/24/16.
 */
public class CS401BSTArray<E extends Comparable<E>> {
    protected TreeNode<E>[] tree;
    protected int root, size, indx;

    public CS401BSTArray() {
        /**
         * Do not initialize tree as: tree=(TreeNode<E> []) new Object[50];
         * While this will compile, it will throw a ClassCastException
         * when run.  Instead, use the initialization below.  Even the one
         * shown below is not the best, since Java does not allow a clean
         * way to allocate memory to hold an array of generic class objects.
         * For more information, see
         * https://courses.cs.washington.edu/courses/cse332/10su/notes/
         * genericArrays.html
         * (Mind the line break in the above URL.  When you go to the above
         * URL, see Workaround #2.) */
        tree = (TreeNode<E>[]) new TreeNode[50];
        root = 0;
        size = 0;
        indx = 0;
    }

    protected static class TreeNode<E> {
        E element;
        int parent, left, right;

        public TreeNode(E element, int parent, int left, int right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public TreeNode(E element, int parent) {
            this.element = element;
            this.parent = parent;
            this.left = -1;
            this.right = -1;
        }

    }

    public int size() {
        return size;
    }

    public void inorder() {
        inorder_p(root);
    }

    public void inorder_p(int e) {
        if (e != -1) {
            inorder_p(tree[e].left);
            System.out.print(tree[e].element + " ");
            inorder_p(tree[e].right);
        }
    }

    public boolean contains(E e) {
        int temp = root;
        int comp;
        while (true) {
            comp = e.compareTo(tree[temp].element);

            if (comp > 0) {
                temp = tree[temp].right;
                if (tree[temp] == null) {
                    return false;
                }
            }
            else if (comp < 0) {
                temp = tree[temp].left;
                if (tree[temp] == null) {
                    return false;
                }
            }
            else return comp == 0;
        }
    }

    public boolean remove(E e) {
        int temp = root;
        int comp;
        while (true) {
            comp = e.compareTo(tree[temp].element);

            if (comp > 0) {
                temp = tree[temp].right;
                if (tree[temp].right == -1) {
                    return false;
                }
            }
            else if (comp < 0) {
                temp = tree[temp].left;
                if (tree[temp].left == -1) {
                    return false;
                }
            }
            else if (comp == 0) {
                size--;
                TreeNode<E> node = tree[temp];
                if (tree[temp].right != -1 && tree[temp].left != -1) {
                    temp = tree[temp].right;
                    if (tree[temp].left != -1) temp = tree[temp].left;
                    node.element = tree[temp].element;
                    node = tree[temp];
                }

                if (tree[temp].left != -1) {
                    tree[node.left] = tree[node.parent];
                    tree[node.parent].left = node.left;
                }
                else if (tree[temp].right != -1) {
                    tree[node.left] = tree[node.parent];
                    tree[node.parent].right = node.right;
                }
                else {
                    if (temp == tree[node.parent].left) tree[node.parent].left = -1;
                    else tree[node.parent].right = -1;
                }
            }
        }
    }

    public boolean add(E element) {
        if (tree[root] == null) {
            {
                if (element == null) throw new NullPointerException();
                tree[root] = new TreeNode<E>(element, -1);
                size++;
                return true;
            } // empty tree
        } else {
            int temp = root;

            int comp;

            while (true) {
                comp = element.compareTo(tree[temp].element);

                if (comp == 0) {
                    return false;
                }
                if (comp < 0) {
                    if (tree[temp].left != -1) {
                        temp = tree[temp].left;
                    }
                    else {
                        indx++;
                        tree[temp].left = indx;
                        tree[indx] = new TreeNode<E>(element, temp);
                        size++;
                        return true;
                    }
                }
                else if (tree[temp].right != -1) {
                    temp = tree[temp].right;
                }
                else {
                    indx++;
                    tree[temp].right = indx;
                    tree[indx] = new TreeNode<E>(element, temp);
                    size++;
                    return true;
                }
            }
        }
    }
}