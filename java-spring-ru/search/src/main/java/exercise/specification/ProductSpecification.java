package exercise.specification;

import exercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN

@Component
public class ProductSpecification {

    @Autowired
    private ProductRepository db;


    public Specification<Product> build(ProductParamsDTO params) {

        var tst = db.findAll(inCategory(params.getCategoryId()));
        tst = db.findAll(ratingHigher(params.getRatingGt()));
        tst = db.findAll(lowerPrice(params.getPriceLt()).and(greaterPrice(params.getPriceGt())));
        tst = db.findAll(isContain(params.getTitleCont()));
        tst = db.findAll(inCategory(params.getCategoryId())
                .and(ratingHigher(params.getRatingGt()))
                //.and(isContain(params.getTitleCont()))
                .and(greaterPrice(params.getPriceGt()))
                .and(lowerPrice(params.getPriceLt())));
        return inCategory(params.getCategoryId())
                .and(ratingHigher(params.getRatingGt()))
                .and(isContain(params.getTitleCont()))
                .and(greaterPrice(params.getPriceGt()))
                .and(lowerPrice(params.getPriceLt()));

    }

    private Specification<Product> inCategory(Long categoryId) {
        return (root, query, cb) -> categoryId == null ? cb.conjunction()
                : cb.equal(root.get("category").get("id"), categoryId);
    }

    private Specification<Product> ratingHigher(Double ratingGr) {
        return (root, query, cb) -> ratingGr == null ? cb.conjunction()
                : cb.greaterThanOrEqualTo(root.get("rating"), ratingGr);
    }

    private Specification<Product> isContain(String titlePart) {
        return (root, query, cb) -> titlePart == null ? cb.conjunction()
                : cb.like(root.get("title"), "%" + titlePart + "%");
    }

    private Specification<Product> greaterPrice(Integer priceGt) {
        return (root, query, cb) -> priceGt == null ? cb.conjunction()
                : cb.greaterThan(root.get("price"), priceGt);
    }

    private Specification<Product> lowerPrice(Integer priceLt) {
        return (root, query, cb) -> priceLt == null ? cb.conjunction()
                : cb.lessThan(root.get("price"), priceLt);
    }

}
// END
