package dk.sdu.se_f22.sortingmodule.range.rangepublic;

import dk.sdu.se_f22.sortingmodule.range.exceptions.IdNotFoundException;
import dk.sdu.se_f22.sortingmodule.range.exceptions.InvalidFilterException;
import dk.sdu.se_f22.sortingmodule.range.exceptions.InvalidFilterTypeException;
import dk.sdu.se_f22.sortingmodule.range.exceptions.UnknownFilterTypeException;
import dk.sdu.se_f22.sortingmodule.range.validators.Validator;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

public class RangeFilterCRUD implements RangeFilterCRUDInterface {
    Database database = new Database();
    @Override
    public RangeFilter create(String name, String description, String productAttribute, double dbMinToSave, double dbMaxToSave) throws InvalidFilterException, InvalidFilterTypeException{
        Validator.NoNegativeValue(dbMinToSave);
        Validator.NoNegativeValue(dbMaxToSave);

        Validator.NoSpecialCharacters(description);
        Validator.NoSpecialCharacters(name);
        Validator.NoSpecialCharacters(productAttribute);

        Validator.MaxLessThanMin(dbMinToSave,dbMaxToSave);

        try {
            return database.create(new DoubleFilter(name, description, productAttribute, dbMinToSave, dbMaxToSave));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RangeFilter create(String name, String description, String productAttribute, long dbMinToSave, long dbMaxToSave) throws InvalidFilterException, InvalidFilterTypeException{
        Validator.NoNegativeValue(dbMinToSave);
        Validator.NoNegativeValue(dbMaxToSave);

        Validator.NoSpecialCharacters(description);
        Validator.NoSpecialCharacters(name);
        Validator.NoSpecialCharacters(productAttribute);

        Validator.MaxLessThanMin(dbMinToSave,dbMaxToSave);

        try {
            return database.create(new LongFilter(name, description, productAttribute, dbMinToSave, dbMaxToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RangeFilter create(String name, String description, String productAttribute, Instant dbMinToSave, Instant dbMaxToSave) throws InvalidFilterException, InvalidFilterTypeException {

        Validator.NoSpecialCharacters(description);
        Validator.NoSpecialCharacters(name);
        Validator.NoSpecialCharacters(productAttribute);

        Validator.MaxLessThanMin(dbMinToSave,dbMaxToSave);

        try {
            return database.create(new TimeFilter(name, description, productAttribute, dbMinToSave, dbMaxToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RangeFilter read(int id) throws IdNotFoundException, UnknownFilterTypeException {
        RangeFilter result = database.read(id);
        if (result == null) {
            throw new IdNotFoundException("Invalid id");
        }
        return result;
    }

    @Override
    public RangeFilter delete(int id) throws IdNotFoundException {
        RangeFilter result = database.delete(id);
        if (result==null) {
            throw new IdNotFoundException("Invalid id");
        }
        return result;
    }

    @Override
    public RangeFilter update(RangeFilter filter, String newName) throws InvalidFilterException {
        return null;
    }

    @Override
    public RangeFilter update(RangeFilter filter, String newName, String newDescription) throws InvalidFilterException {
        return null;
    }

    @Override
    public RangeFilter update(RangeFilter filter, double dbMinToSave, double dbMaxToSave) throws InvalidFilterException {
        return null;
    }

    @Override
    public RangeFilter update(RangeFilter filter, long dbMinToSave, long dbMaxToSave) throws InvalidFilterException {
        return null;
    }

    @Override
    public RangeFilter update(RangeFilter filter, Instant dbMinToSave, Instant dbMaxToSave) throws InvalidFilterException {
        return null;
    }

    @Override
    public List<RangeFilter> readAll() {
        return database.readAllFilters();
    }
}
