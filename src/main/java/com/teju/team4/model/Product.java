package com.teju.team4.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "thumbnail", length = 255)
    private String thumbnail;

    @Column(name = "cat_id", nullable = false) 
    private Long cat_id;

    public Long getCat_id() {
		return cat_id;
	}

	public void setCat_id(Long cat_id) {
		this.cat_id = cat_id;
	}
	@Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

    @Column(name = "qty")
    private Integer quantity;

    public Product() {
        // Default constructor
    }

    // Getters and setters for all attributes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

   

   

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getQuantity() {
        return quantity;
    }

  

	public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public Product(Long id, String name, String thumbnail, Long cat_id, BigDecimal price, String details,
			Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
		this.cat_id = cat_id;
		this.price = price;
		this.details = details;
		this.quantity = quantity;
	}
}
