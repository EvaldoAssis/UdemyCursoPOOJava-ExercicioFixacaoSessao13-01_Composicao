package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.ENUMS.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momentOrder;
	private OrderStatus statusOrder;
	private Client client;

	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {
	}

	public Order(Date momentOrder, OrderStatus statusOrder, Client client) {
		this.momentOrder = momentOrder;
		this.statusOrder = statusOrder;
		this.client = client;
	}

	public Date getMomentOrder() {
		return momentOrder;
	}

	public void setMomentOrder(Date momentOrder) {
		this.momentOrder = momentOrder;
	}

	public OrderStatus getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(OrderStatus statusOrder) {
		this.statusOrder = statusOrder;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double sum = 0;
		for (OrderItem oi : items) {
			sum = sum + oi.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(momentOrder) + "\n");
		sb.append("Order status: ");
		sb.append(statusOrder + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order  items: \n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price $: ");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}
