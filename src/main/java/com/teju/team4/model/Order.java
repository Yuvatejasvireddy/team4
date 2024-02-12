package com.teju.team4.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Long id;

    // Array of product IDs
    @Column(name = "p_ids", nullable = false)
    private List<Long> productIds;

    // Array of quantities corresponding to product IDs
    @Column(name = "p_quantities", nullable = false)
    private List<Integer> productQuantities;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staff;

    @Override
	public String toString() {
		return "Order [id=" + id + ", productIds=" + productIds + ", productQuantities=" + productQuantities
				+ ", staff=" + staff + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", status="
				+ status + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public List<Integer> getProductQuantities() {
		return productQuantities;
	}

	public void setProductQuantities(List<Integer> productQuantities) {
		this.productQuantities = productQuantities;
	}

	

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "o_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "o_delivery")
    private LocalDate deliveryDate;

    @Column(name = "status", nullable = false, length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'placed'")
    private String status;

    // Constructors, getters, and setters
    public Order() {
        // Default constructor
    }

   

	// Constructor with all arguments
    public Order(List<Long> productIds, List<Integer> productQuantities,Staff staff, LocalDate orderDate, LocalDate deliveryDate, String status) {
        this.productIds = productIds;
        this.productQuantities = productQuantities;
        this.staff = staff;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

    // Getters and setters for all attributes
    // Omitted for brevity
}



