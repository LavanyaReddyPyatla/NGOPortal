package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DonationItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;

	// @Enumerated(EnumType.STRING)
	// @OneToOne
	// @Enumerated(EnumType.STRING)
	// @Column(name="item_type")
	private DonationType item;

	private String itemDescription;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public DonationType getItem() {
		return item;
	}

	public void setItem(DonationType item) {
		this.item = item;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
}
