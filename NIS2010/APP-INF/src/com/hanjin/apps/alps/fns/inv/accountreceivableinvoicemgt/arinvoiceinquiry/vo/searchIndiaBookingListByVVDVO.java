/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : searchIndiaBookingListByVVDVO.java
*@FileTitle : searchIndiaBookingListByVVDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.10
*@LastModifier : Hyunhwa Kim
*@LastVersion : 1.0
* 2010.09.10 Hyunhwa Kim 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Hyunhwa Kim
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchIndiaBookingListByVVDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchIndiaBookingListByVVDVO> models = new ArrayList<searchIndiaBookingListByVVDVO>();
	
	/* Column Info */
	private String pInrTot = null;
	/* Column Info */
	private String cInrAmt = null;
	/* Column Info */
	private String pUsdAmt = null;
	/* Column Info */
	private String cUsdAmt = null;
	/* Column Info */
	private String cEqvAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cInrTot = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sInrTot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnt20 = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String pEqvAmt = null;
	/* Column Info */
	private String pInrAmt = null;
	/* Column Info */
	private String cnt40 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchIndiaBookingListByVVDVO() {}

	public searchIndiaBookingListByVVDVO(String ibflag, String pagerows, String blNo, String cnt20, String cnt40, String pUsdAmt, String pEqvAmt, String pInrAmt, String pInrTot, String cUsdAmt, String cEqvAmt, String cInrAmt, String cInrTot, String sInrTot, String exRate) {
		this.pInrTot = pInrTot;
		this.cInrAmt = cInrAmt;
		this.pUsdAmt = pUsdAmt;
		this.cUsdAmt = cUsdAmt;
		this.cEqvAmt = cEqvAmt;
		this.blNo = blNo;
		this.cInrTot = cInrTot;
		this.pagerows = pagerows;
		this.sInrTot = sInrTot;
		this.ibflag = ibflag;
		this.cnt20 = cnt20;
		this.exRate = exRate;
		this.pEqvAmt = pEqvAmt;
		this.pInrAmt = pInrAmt;
		this.cnt40 = cnt40;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_inr_tot", getPInrTot());
		this.hashColumns.put("c_inr_amt", getCInrAmt());
		this.hashColumns.put("p_usd_amt", getPUsdAmt());
		this.hashColumns.put("c_usd_amt", getCUsdAmt());
		this.hashColumns.put("c_eqv_amt", getCEqvAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("c_inr_tot", getCInrTot());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_inr_tot", getSInrTot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt20", getCnt20());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("p_eqv_amt", getPEqvAmt());
		this.hashColumns.put("p_inr_amt", getPInrAmt());
		this.hashColumns.put("cnt40", getCnt40());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_inr_tot", "pInrTot");
		this.hashFields.put("c_inr_amt", "cInrAmt");
		this.hashFields.put("p_usd_amt", "pUsdAmt");
		this.hashFields.put("c_usd_amt", "cUsdAmt");
		this.hashFields.put("c_eqv_amt", "cEqvAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("c_inr_tot", "cInrTot");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_inr_tot", "sInrTot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt20", "cnt20");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("p_eqv_amt", "pEqvAmt");
		this.hashFields.put("p_inr_amt", "pInrAmt");
		this.hashFields.put("cnt40", "cnt40");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pInrTot
	 */
	public String getPInrTot() {
		return this.pInrTot;
	}
	
	/**
	 * Column Info
	 * @return cInrAmt
	 */
	public String getCInrAmt() {
		return this.cInrAmt;
	}
	
	/**
	 * Column Info
	 * @return pUsdAmt
	 */
	public String getPUsdAmt() {
		return this.pUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return cUsdAmt
	 */
	public String getCUsdAmt() {
		return this.cUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return cEqvAmt
	 */
	public String getCEqvAmt() {
		return this.cEqvAmt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cInrTot
	 */
	public String getCInrTot() {
		return this.cInrTot;
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
	 * @return sInrTot
	 */
	public String getSInrTot() {
		return this.sInrTot;
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
	 * @return cnt20
	 */
	public String getCnt20() {
		return this.cnt20;
	}
	
	/**
	 * Column Info
	 * @return exRate
	 */
	public String getExRate() {
		return this.exRate;
	}
	
	/**
	 * Column Info
	 * @return pEqvAmt
	 */
	public String getPEqvAmt() {
		return this.pEqvAmt;
	}
	
	/**
	 * Column Info
	 * @return pInrAmt
	 */
	public String getPInrAmt() {
		return this.pInrAmt;
	}
	
	/**
	 * Column Info
	 * @return cnt40
	 */
	public String getCnt40() {
		return this.cnt40;
	}
	

	/**
	 * Column Info
	 * @param pInrTot
	 */
	public void setPInrTot(String pInrTot) {
		this.pInrTot = pInrTot;
	}
	
	/**
	 * Column Info
	 * @param cInrAmt
	 */
	public void setCInrAmt(String cInrAmt) {
		this.cInrAmt = cInrAmt;
	}
	
	/**
	 * Column Info
	 * @param pUsdAmt
	 */
	public void setPUsdAmt(String pUsdAmt) {
		this.pUsdAmt = pUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param cUsdAmt
	 */
	public void setCUsdAmt(String cUsdAmt) {
		this.cUsdAmt = cUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param cEqvAmt
	 */
	public void setCEqvAmt(String cEqvAmt) {
		this.cEqvAmt = cEqvAmt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cInrTot
	 */
	public void setCInrTot(String cInrTot) {
		this.cInrTot = cInrTot;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param sInrTot
	 */
	public void setSInrTot(String sInrTot) {
		this.sInrTot = sInrTot;
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
	 * @param cnt20
	 */
	public void setCnt20(String cnt20) {
		this.cnt20 = cnt20;
	}
	
	/**
	 * Column Info
	 * @param exRate
	 */
	public void setExRate(String exRate) {
		this.exRate = exRate;
	}
	
	/**
	 * Column Info
	 * @param pEqvAmt
	 */
	public void setPEqvAmt(String pEqvAmt) {
		this.pEqvAmt = pEqvAmt;
	}
	
	/**
	 * Column Info
	 * @param pInrAmt
	 */
	public void setPInrAmt(String pInrAmt) {
		this.pInrAmt = pInrAmt;
	}
	
	/**
	 * Column Info
	 * @param cnt40
	 */
	public void setCnt40(String cnt40) {
		this.cnt40 = cnt40;
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
		setPInrTot(JSPUtil.getParameter(request, prefix + "p_inr_tot", ""));
		setCInrAmt(JSPUtil.getParameter(request, prefix + "c_inr_amt", ""));
		setPUsdAmt(JSPUtil.getParameter(request, prefix + "p_usd_amt", ""));
		setCUsdAmt(JSPUtil.getParameter(request, prefix + "c_usd_amt", ""));
		setCEqvAmt(JSPUtil.getParameter(request, prefix + "c_eqv_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCInrTot(JSPUtil.getParameter(request, prefix + "c_inr_tot", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSInrTot(JSPUtil.getParameter(request, prefix + "s_inr_tot", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnt20(JSPUtil.getParameter(request, prefix + "cnt20", ""));
		setExRate(JSPUtil.getParameter(request, prefix + "ex_rate", ""));
		setPEqvAmt(JSPUtil.getParameter(request, prefix + "p_eqv_amt", ""));
		setPInrAmt(JSPUtil.getParameter(request, prefix + "p_inr_amt", ""));
		setCnt40(JSPUtil.getParameter(request, prefix + "cnt40", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchIndiaBookingListByVVDVO[]
	 */
	public searchIndiaBookingListByVVDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchIndiaBookingListByVVDVO[]
	 */
	public searchIndiaBookingListByVVDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchIndiaBookingListByVVDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pInrTot = (JSPUtil.getParameter(request, prefix	+ "p_inr_tot", length));
			String[] cInrAmt = (JSPUtil.getParameter(request, prefix	+ "c_inr_amt", length));
			String[] pUsdAmt = (JSPUtil.getParameter(request, prefix	+ "p_usd_amt", length));
			String[] cUsdAmt = (JSPUtil.getParameter(request, prefix	+ "c_usd_amt", length));
			String[] cEqvAmt = (JSPUtil.getParameter(request, prefix	+ "c_eqv_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cInrTot = (JSPUtil.getParameter(request, prefix	+ "c_inr_tot", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sInrTot = (JSPUtil.getParameter(request, prefix	+ "s_inr_tot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnt20 = (JSPUtil.getParameter(request, prefix	+ "cnt20", length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate", length));
			String[] pEqvAmt = (JSPUtil.getParameter(request, prefix	+ "p_eqv_amt", length));
			String[] pInrAmt = (JSPUtil.getParameter(request, prefix	+ "p_inr_amt", length));
			String[] cnt40 = (JSPUtil.getParameter(request, prefix	+ "cnt40", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchIndiaBookingListByVVDVO();
				if (pInrTot[i] != null)
					model.setPInrTot(pInrTot[i]);
				if (cInrAmt[i] != null)
					model.setCInrAmt(cInrAmt[i]);
				if (pUsdAmt[i] != null)
					model.setPUsdAmt(pUsdAmt[i]);
				if (cUsdAmt[i] != null)
					model.setCUsdAmt(cUsdAmt[i]);
				if (cEqvAmt[i] != null)
					model.setCEqvAmt(cEqvAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cInrTot[i] != null)
					model.setCInrTot(cInrTot[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sInrTot[i] != null)
					model.setSInrTot(sInrTot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnt20[i] != null)
					model.setCnt20(cnt20[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (pEqvAmt[i] != null)
					model.setPEqvAmt(pEqvAmt[i]);
				if (pInrAmt[i] != null)
					model.setPInrAmt(pInrAmt[i]);
				if (cnt40[i] != null)
					model.setCnt40(cnt40[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchIndiaBookingListByVVDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchIndiaBookingListByVVDVO[]
	 */
	public searchIndiaBookingListByVVDVO[] getsearchIndiaBookingListByVVDVOs(){
		searchIndiaBookingListByVVDVO[] vos = (searchIndiaBookingListByVVDVO[])models.toArray(new searchIndiaBookingListByVVDVO[models.size()]);
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
		this.pInrTot = this.pInrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cInrAmt = this.cInrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pUsdAmt = this.pUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cUsdAmt = this.cUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cEqvAmt = this.cEqvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cInrTot = this.cInrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInrTot = this.sInrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt20 = this.cnt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqvAmt = this.pEqvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pInrAmt = this.pInrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt40 = this.cnt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
