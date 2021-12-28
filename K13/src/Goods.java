public class Goods {
	private String goodsCode;
	private String goodsName;
	private int price;
	public Goods(String goodsCode, String goodsName, int price) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.price = price;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public int getPrice() {
		return price;
	}
	public int hashCode()
	{
		return goodsCode.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		 boolean ret = false;
		if(obj instanceof Goods)
		{
			Goods goods=(Goods)obj;
			if(goodsCode.equals(goods.goodsCode))
			{
				ret =true;
			}
		}
		return ret;
	}
}

