class MinStack {
    Stack<Long> st;
    int minValue;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        if (st.isEmpty()){
            minValue = value;
        }
        if (value <= minValue){
            int c = value;
            int p = minValue;
            st.push(2l*c-p);
            minValue = value;
        }else{
            st.push((long)value);
        }
    }
    
    public void pop() {
        if (st.isEmpty()) return;
        if(st.peek()<minValue){
            long decodedVal = st.peek();
            int c = minValue;
            int prevMin = (int)(2l*c-decodedVal);
            minValue = prevMin;
        }
        st.pop();
    }
    
    public int top() {
        if(st.peek()<minValue){
            return minValue;
        }
        long x = st.peek();
        return (int)x;
    }
    
    public int getMin() {
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */