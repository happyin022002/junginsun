/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaBlChargeVO.java
*@FileTitle : ChinaBlChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaBlChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaBlChargeVO> models = new ArrayList<ChinaBlChargeVO>();
	
	/* Column Info */
	private String prflag = null;
	/* Column Info */
	private String amount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fccode = null;
	/* Column Info */
	private String qty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChinaBlChargeVO() {}

	public ChinaBlChargeVO(String ibflag, String pagerows, String fccode, String qty, String currCd, String rate, String amount, String prflag) {
		this.prflag = prflag;
		this.amount = amount;
		this.ibflag = ibflag;
		this.rate = rate;
		this.currCd = currCd;
		this.fccode = fccode;
		this.qty = qty;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prflag", getPrflag());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fccode", getFccode());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prflag", "prflag");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fccode", "fccode");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prflag
	 */
	public String getPrflag() {
		return this.prflag;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return fccode
	 */
	public String getFccode() {
		return this.fccode;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Column Info
	 * @param prflag
	 */
	public void setPrflag(String prflag) {
		this.prflag = prflag;
	}
	
	/**
	 * Column Info
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param fccode
	 */
	public void setFccode(String fccode) {
		this.fccode = fccode;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPrflag(JSPUtil.getParameter(request, prefix + "prflag", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFccode(JSPUtil.getParameter(request, prefix + "fccode", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaBlChargeVO[]
	 */
	public ChinaBlChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaBlChargeVO[]
	 */
	public ChinaBlChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaBlChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prflag = (JSPUtil.getParameter(request, prefix	+ "prflag", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fccode = (JSPUtil.getParameter(request, prefix	+ "fccode", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaBlChargeVO();
				if (prflag[i] != null)
					model.setPrflag(prflag[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fccode[i] != null)
					model.setFccode(fccode[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaBlChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaBlChargeVO[]
	 */
	public ChinaBlChargeVO[] getChinaBlChargeVOs(){
		ChinaBlChargeVO[] vos = (ChinaBlChargeVO[])models.toArray(new ChinaBlChargeVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.prflag = this.prflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fccode = this.fccode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
