package wizut.tpsi.ogloszenia.services;

import org.springframework.stereotype.Service;
import wizut.tpsi.ogloszenia.jpa.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("JpaQlInspection")    //nie wiem co to ale pewnie ignoruje niewidoczny error
@Service
public class OffersService {

    @PersistenceContext
    private EntityManager em;

    public CarManufacturer getCarManufacturer(int id){
        return em.find(CarManufacturer.class, id);
    }

    public List<CarManufacturer> getCarManufacturers(){
        String jpql = "select cm from CarManufacturer cm order by cm.name";
        TypedQuery<CarManufacturer> query = em.createQuery(jpql, CarManufacturer.class);
        List<CarManufacturer> result = query.getResultList();
        //lub
        //return em.createQuery("select cm from CarManufacturer cm order by cm.name", CarManufacturer.class).getResultList();
        return result;
    }

    public CarModel getModel(int id){
        return em.find(CarModel.class, id);
    }

    public List<CarModel> getCarModels(){
        String jpql = "select cm from CarModel cm order by cm.name";
        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        List<CarModel> result = query.getResultList();
        return result;
    }

    public List<CarModel> getCarModels(int manufacturerId){
        String jpql = "select cm from CarModel cm where cm.manufacturer.id = :id order by cm.name";
        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        query.setParameter("id", manufacturerId);
        return query.getResultList();
    }

    public List<BodyStyle> getBodyStyles(){
        String jpql = "select bs from BodyStyle bs order by bs.name";
        TypedQuery<BodyStyle> query = em.createQuery(jpql, BodyStyle.class);
        List<BodyStyle> result = query.getResultList();
        return result;
    }

    public List<FuelType> getFuelTypes(){
        String jpql = "select ft from FuelType ft order by ft.name";
        TypedQuery<FuelType> query = em.createQuery(jpql, FuelType.class);
        List<FuelType> result = query.getResultList();
        return result;
    }

    public Offer getOffer(int id){
        return em.find(Offer.class, id);
    }

    public List<Offer> getOffers(){
        String jpql = "select o from Offer o order by o.title";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        List<Offer> result = query.getResultList();
        return result;
    }

    public List<Offer> getOffersByModel(int modelId){
        String jpql = "select o from Offer o where o.carModel.id = :id order by o.title";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", modelId);
        return query.getResultList();
    }

    public List<Offer> getOffersByManufacturer(int manuacturerId){
        String jpql = "select o from Offer o where o.carModel.manufacturer.id = :id order by o.title";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", manuacturerId);
        return query.getResultList();
    }


}
