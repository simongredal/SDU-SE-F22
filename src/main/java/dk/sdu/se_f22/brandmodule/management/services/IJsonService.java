package dk.sdu.se_f22.brandmodule.management.services;

import dk.sdu.se_f22.sharedlibrary.models.Brand;

import java.util.List;

public interface IJsonService {
    public List<Brand> deserializeBrand();
}