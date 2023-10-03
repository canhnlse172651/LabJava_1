package BussinessLayer.Entity;

public class ItemReceipt {
	@Override
	public String toString() {
		return "[receiptId=" + receiptId + ", itemId=" + itemId + ", name=" + name + ", quanity=" + quanity
				+ "]";
	}

	String receiptId;
	String itemId;
	String name;
	int quanity;

	public ItemReceipt(String receiptId, String itemId, String name, int quanity) {
		super();
		this.receiptId = receiptId;
		this.itemId = itemId;
		this.quanity = quanity;
		this.name = name;
	}
 
	
	public ItemReceipt() {
		
	}
	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public String getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public String toRawData() {
		return receiptId + "," + itemId + "," + name + "," + quanity;
	}

}
