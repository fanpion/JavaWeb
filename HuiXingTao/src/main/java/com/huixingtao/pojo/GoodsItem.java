package com.huixingtao.pojo;

import java.io.Serializable;

public class GoodsItem implements Serializable {
	private Product product;
	private int quantity;

	public GoodsItem(Product product) {
		this(product, 1);
	}

	public GoodsItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
