package co.edu.sena.HPlus2242753.model.beans;

public class Product {

	private int productId;
	private String productName;
	private String productImgPath;

	public Product() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImgPath() {
		return productImgPath;
	}

	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}

}