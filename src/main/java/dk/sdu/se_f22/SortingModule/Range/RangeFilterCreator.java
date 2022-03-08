package dk.sdu.se_f22.SortingModule.Range;

import dk.sdu.se_f22.SortingModule.Range.Exceptions.InvalidFilterException;

class RangeFilterCreator {
    private CreateRangeFilterInterface dbRangeFilterCreator;
    private ReadRangeFilterInterface dbReader;

    public RangeFilterCreator() {
        this(new DBRangeFilterCreator());
    }

    public RangeFilterCreator(DBRangeFilterCreator dbRangeFilterCreator){
        this.dbRangeFilterCreator = dbRangeFilterCreator;
        try{
            dbRangeFilterCreator.createRangeFilter( "hello object", "uno", "price", 0, 2000);
            dbRangeFilterCreator.createRangeFilter("hello fella", "dos", "height", 0, 4000);
        }catch (InvalidFilterException e){
            System.out.println(e.getMessage());
        }

        dbReader = new DBRangeFilterReader();
    }

    private boolean validateFilter() {
        return true;
    }

    public InternalFilter createInternalFilter(RangeFilter filterCheck) {
        //check if the filter exists in the database
        //if it doesn't, or min, max is invalid
//        return null;
        //if it does and everything is valid:
        DBRangeFilter dbfilter = this.dbReader.getRangeFilter(filterCheck.getId());
        if (validateFilter()) {
            return new InternalFilter(filterCheck.getMin(), filterCheck.getMax(), dbfilter.getProductAttribute());
        } else {
            return null;
        }
    }
}