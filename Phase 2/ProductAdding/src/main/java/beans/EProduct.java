package beans;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity  
@Table(name= "eproduct") 
public class EProduct 
{
	 @Id @GeneratedValue   
     @Column(name = "ID")
     private long ID;
     
     @Column(name = "name")
     private String name;
     
     @Column(name = "price")
     private long price;
     
    
     @Column(name = "date_added")
     @CreationTimestamp
     private LocalDateTime dateAdded;

         
     public long getID() {return this.ID; }
     public String getName() { return this.name;}
     public long getPrice() { return this.price;}
     public LocalDateTime getDateAdded() { return this.dateAdded;}
     
     public void setID(long id) { this.ID = id;}
     public void setName(String name) { this.name = name;}
     public void setPrice(long price) { this.price = price;}
     public void setDateAdded(LocalDateTime date) { this.dateAdded = date;}   
}
