package com.huixingtao.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ShoppingCart implements Serializable{
	HashMap<String, GoodsItem> items = null;

	public ShoppingCart() {
		items = new HashMap<>();
	}

	public void add(GoodsItem goodsItem) {
		String pname = goodsItem.getProduct().getPname();
		if (items.containsKey(pname)) {
			GoodsItem addPro = items.get(pname);
			addPro.setQuantity(addPro.getQuantity() + goodsItem.getQuantity());
		} else {
			items.put(pname, goodsItem);
		}
	}

	public void remove(String pname) {
		if (items.containsKey(pname)) {
//			GoodsItem goodsItem = items.get(pname);
//			goodsItem.setQuantity(goodsItem.getQuantity() - 1);
//			if (goodsItem.getQuantity() <= 0) {
				items.remove(pname);
//			}
		}
	}

	public Collection<GoodsItem> getItems() {
		return items.values();
	}

	public double getTotal() {
		double amount = 0.0;
		for (Iterator<GoodsItem> i = getItems().iterator(); i.hasNext();) {
			GoodsItem next = i.next();
			Product product = next.getProduct();
			amount += next.getQuantity() * product.getPrice();

		}
		return roundOff(amount);

	}

	private double roundOff(double amount) {
		return Math.round(amount * 100) / 100;
	}

	public void clean() {
		items.clear();
	}
}
