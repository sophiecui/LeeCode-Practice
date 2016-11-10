    public List<Integer> getRow(int rowIndex) {
        /*use recursive way to solve the problem*/
        List<Integer> result = new ArrayList<Integer>();
        return helper(rowIndex, result);
    }
    private List<Integer> helper(int row, List<Integer> result){
        if(row == 0){
            result.add(1);
            return result;
        }
        result = helper(row - 1, result);
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        for(int i = 0; i < result.size() - 1; i++){
            temp.add(result.get(i) + result.get(i+1));
        }
        temp.add(1);
        return temp;

    }
