package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.ENUMS.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data ");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		//Convertendo o que foi escrito em string para o formato de data 
		Date dateNasc = sdf.parse(sc.next());
		
		Client client = new Client(nameClient, emailClient, dateNasc);
	
		System.out.println();
		
		System.out.println("Enter order data ");
		System.out.print("Status: ");
		//Convertendo o que foi digitado em string para OrderStatus (tipo enumerado)
		OrderStatus statusOrder = OrderStatus.valueOf(sc.next());
		
		//Instanciando pedido
		Order order = new Order(new Date(), statusOrder, client);
		
		System.out.print("How many items to this order? ");
		
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			System.out.println();
			System.out.println("Enter #" +i+ " item data");
			System.out.print("Name product: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Price product: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity product: ");
			int qntProduct = sc.nextInt();
			
			//Instanciando o produto
			Product product = new Product(nameProduct, priceProduct);
			
			//Instanciando o item do pedido associado ao produto instanciado anteriormente
			OrderItem item = new OrderItem(qntProduct, priceProduct, product);
			
			//Adicionando o item instanciado acima dentro da lista de items da classe Order
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order.toString());
		
	}
  
}
