/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BKGForTaxByVesselVO.java
*@FileTitle : BKGForTaxByVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.11 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * FNS_INV_0083, FNS_INV_0085 에서 사용.
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BKGForTaxByVesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BKGForTaxByVesselVO> models = new ArrayList<BKGForTaxByVesselVO>();
	
	/* Column Info */
	private String cOthCurr = null;
	/* Column Info */
	private String pUsdAmt = null;
	/* Column Info */
	private String cUsdAmt = null;
	/* Column Info */
	private String cEqvAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cThbAmt = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String pOthAmt = null;
	/* Column Info */
	private String pEqvAmt = null;
	/* Column Info */
	private String pOthCurr = null;
	/* Column Info */
	private String pThbAmt = null;
	/* Column Info */
	private String cOthAmt = null;
	/* Column Info */
	private String cnt20 = null;
	/* Column Info */
	private String cnt40 = null;	
	/* Column Info */
	private String pInrAmt = null;
	/* Column Info */
	private String pInrTot = null;
	/* Column Info */
	private String cInrAmt = null;
	/* Column Info */
	private String cInrTot = null;
	/* (India) Freight and Charge List  VVD */
	private String vvd = null;
	/* INR SUM */
	private String sInrTot = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BKGForTaxByVesselVO() {}

	public BKGForTaxByVesselVO(String ibflag, String pagerows, String blNo, String pUsdAmt, String pEqvAmt, String pThbAmt, String pOthCurr, String pOthAmt, String cUsdAmt, String cEqvAmt, String cThbAmt, String cOthCurr, String cOthAmt, String cnt20, String cnt40, String pInrAmt, String pInrTot, String cInrAmt, String cInrTot, String sInrTot, String exRate) {
		this.cOthCurr = cOthCurr;
		this.pUsdAmt = pUsdAmt;
		this.cUsdAmt = cUsdAmt;
		this.cEqvAmt = cEqvAmt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cThbAmt = cThbAmt;
		this.exRate = exRate;
		this.pOthAmt = pOthAmt;
		this.pEqvAmt = pEqvAmt;
		this.pOthCurr = pOthCurr;
		this.pThbAmt = pThbAmt;
		this.cOthAmt = cOthAmt;
		this.cnt20 = cnt20;
		this.cnt40 = cnt40;
		this.pInrAmt = pInrAmt;
		this.pInrTot = pInrTot;
		this.cInrAmt = cInrAmt;
		this.cInrTot = cInrTot;
		this.vvd = vvd;
		this.sInrTot = sInrTot;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("c_oth_curr", getCOthCurr());
		this.hashColumns.put("p_usd_amt", getPUsdAmt());
		this.hashColumns.put("c_usd_amt", getCUsdAmt());
		this.hashColumns.put("c_eqv_amt", getCEqvAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_thb_amt", getCThbAmt());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("p_oth_amt", getPOthAmt());
		this.hashColumns.put("p_eqv_amt", getPEqvAmt());
		this.hashColumns.put("p_oth_curr", getPOthCurr());
		this.hashColumns.put("p_thb_amt", getPThbAmt());
		this.hashColumns.put("c_oth_amt", getCOthAmt());
		this.hashColumns.put("cnt20", getCnt20());
		this.hashColumns.put("cnt40", getCnt40());
		this.hashColumns.put("p_inr_amt", getPInrAmt());
		this.hashColumns.put("p_inr_tot", getPInrTot());
		this.hashColumns.put("c_inr_amt", getCInrAmt());
		this.hashColumns.put("c_inr_tot", getCInrTot());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("s_inr_tot", getSInrTot());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("c_oth_curr", "cOthCurr");
		this.hashFields.put("p_usd_amt", "pUsdAmt");
		this.hashFields.put("c_usd_amt", "cUsdAmt");
		this.hashFields.put("c_eqv_amt", "cEqvAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_thb_amt", "cThbAmt");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("p_oth_amt", "pOthAmt");
		this.hashFields.put("p_eqv_amt", "pEqvAmt");
		this.hashFields.put("p_oth_curr", "pOthCurr");
		this.hashFields.put("p_thb_amt", "pThbAmt");
		this.hashFields.put("c_oth_amt", "cOthAmt");
		this.hashFields.put("cnt20", "cnt20");
		this.hashFields.put("cnt40", "cnt40");
		this.hashFields.put("p_inr_amt", "pInrAmt");
		this.hashFields.put("p_inr_tot", "pInrTot");
		this.hashFields.put("c_inr_amt", "cInrAmt");
		this.hashFields.put("c_inr_tot", "cInrTot");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("s_inr_tot", "sInrTot");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cOthCurr
	 */
	public String getCOthCurr() {
		return this.cOthCurr;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return cThbAmt
	 */
	public String getCThbAmt() {
		return this.cThbAmt;
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
	 * @return pOthAmt
	 */
	public String getPOthAmt() {
		return this.pOthAmt;
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
	 * @return pOthCurr
	 */
	public String getPOthCurr() {
		return this.pOthCurr;
	}
	
	/**
	 * Column Info
	 * @return pThbAmt
	 */
	public String getPThbAmt() {
		return this.pThbAmt;
	}
	
	/**
	 * Column Info
	 * @return cOthAmt
	 */
	public String getCOthAmt() {
		return this.cOthAmt;
	}
	

	/**
	 * Column Info
	 * @param cOthCurr
	 */
	public void setCOthCurr(String cOthCurr) {
		this.cOthCurr = cOthCurr;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param cThbAmt
	 */
	public void setCThbAmt(String cThbAmt) {
		this.cThbAmt = cThbAmt;
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
	 * @param pOthAmt
	 */
	public void setPOthAmt(String pOthAmt) {
		this.pOthAmt = pOthAmt;
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
	 * @param pOthCurr
	 */
	public void setPOthCurr(String pOthCurr) {
		this.pOthCurr = pOthCurr;
	}
	
	/**
	 * Column Info
	 * @param pThbAmt
	 */
	public void setPThbAmt(String pThbAmt) {
		this.pThbAmt = pThbAmt;
	}
	
	/**
	 * Column Info
	 * @param cOthAmt
	 */
	public void setCOthAmt(String cOthAmt) {
		this.cOthAmt = cOthAmt;
	}
	
	public String getCnt20() {
		return cnt20;
	}

	public void setCnt20(String cnt20) {
		this.cnt20 = cnt20;
	}

	public String getCnt40() {
		return cnt40;
	}

	public void setCnt40(String cnt40) {
		this.cnt40 = cnt40;
	}
    
	public String getPInrAmt() {
		return pInrAmt;
	}

	public void setPInrAmt(String inrAmt) {
		pInrAmt = inrAmt;
	}

	public String getPInrTot() {
		return pInrTot;
	}

	public void setPInrTot(String inrTot) {
		pInrTot = inrTot;
	}

	public String getCInrAmt() {
		return cInrAmt;
	}

	public void setCInrAmt(String inrAmt) {
		cInrAmt = inrAmt;
	}

	public String getCInrTot() {
		return cInrTot;
	}

	public void setCInrTot(String inrTot) {
		sInrTot = inrTot;
	}
	public String getSInrTot() {
		return sInrTot;
	}

	public void setSInrTot(String inrTot) {
		sInrTot = inrTot;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */	
	public String getVvd() {
		return this.vvd;
	}
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCOthCurr(JSPUtil.getParameter(request, "c_oth_curr", ""));
		setPUsdAmt(JSPUtil.getParameter(request, "p_usd_amt", ""));
		setCUsdAmt(JSPUtil.getParameter(request, "c_usd_amt", ""));
		setCEqvAmt(JSPUtil.getParameter(request, "c_eqv_amt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCThbAmt(JSPUtil.getParameter(request, "c_thb_amt", ""));
		setExRate(JSPUtil.getParameter(request, "ex_rate", ""));
		setPOthAmt(JSPUtil.getParameter(request, "p_oth_amt", ""));
		setPEqvAmt(JSPUtil.getParameter(request, "p_eqv_amt", ""));
		setPOthCurr(JSPUtil.getParameter(request, "p_oth_curr", ""));
		setPThbAmt(JSPUtil.getParameter(request, "p_thb_amt", ""));
		setCOthAmt(JSPUtil.getParameter(request, "c_oth_amt", ""));
		setCnt20(JSPUtil.getParameter(request, "cnt20", ""));
		setCnt40(JSPUtil.getParameter(request, "cnt40", ""));
		setPInrAmt(JSPUtil.getParameter(request, "p_inr_amt", ""));
		setPInrTot(JSPUtil.getParameter(request, "p_inr_tot", ""));
		setCInrAmt(JSPUtil.getParameter(request, "c_inr_amt", ""));
		setCInrTot(JSPUtil.getParameter(request, "c_inr_tot", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSInrTot(JSPUtil.getParameter(request, "s_inr_tot", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BKGForTaxByVesselVO[]
	 */
	public BKGForTaxByVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BKGForTaxByVesselVO[]
	 */
	public BKGForTaxByVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BKGForTaxByVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cOthCurr = (JSPUtil.getParameter(request, prefix	+ "c_oth_curr".trim(), length));
			String[] pUsdAmt = (JSPUtil.getParameter(request, prefix	+ "p_usd_amt".trim(), length));
			String[] cUsdAmt = (JSPUtil.getParameter(request, prefix	+ "c_usd_amt".trim(), length));
			String[] cEqvAmt = (JSPUtil.getParameter(request, prefix	+ "c_eqv_amt".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cThbAmt = (JSPUtil.getParameter(request, prefix	+ "c_thb_amt".trim(), length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate".trim(), length));
			String[] pOthAmt = (JSPUtil.getParameter(request, prefix	+ "p_oth_amt".trim(), length));
			String[] pEqvAmt = (JSPUtil.getParameter(request, prefix	+ "p_eqv_amt".trim(), length));
			String[] pOthCurr = (JSPUtil.getParameter(request, prefix	+ "p_oth_curr".trim(), length));
			String[] pThbAmt = (JSPUtil.getParameter(request, prefix	+ "p_thb_amt".trim(), length));
			String[] cOthAmt = (JSPUtil.getParameter(request, prefix	+ "c_oth_amt".trim(), length));
			String[] cnt20 = (JSPUtil.getParameter(request, prefix	+ "cnt20".trim(), length));
			String[] cnt40 = (JSPUtil.getParameter(request, prefix	+ "cnt40".trim(), length));
			String[] pInrAmt = (JSPUtil.getParameter(request, prefix	+ "p_inr_amt".trim(), length));
			String[] pInrTot = (JSPUtil.getParameter(request, prefix	+ "p_inr_tot".trim(), length));
			String[] cInrAmt = (JSPUtil.getParameter(request, prefix	+ "c_inr_amt".trim(), length));
			String[] cInrTot = (JSPUtil.getParameter(request, prefix	+ "c_inr_tot".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] sInrTot = (JSPUtil.getParameter(request, prefix	+ "s_inr_tot".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BKGForTaxByVesselVO();
				if (cOthCurr[i] != null)
					model.setCOthCurr(cOthCurr[i]);
				if (pUsdAmt[i] != null)
					model.setPUsdAmt(pUsdAmt[i]);
				if (cUsdAmt[i] != null)
					model.setCUsdAmt(cUsdAmt[i]);
				if (cEqvAmt[i] != null)
					model.setCEqvAmt(cEqvAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cThbAmt[i] != null)
					model.setCThbAmt(cThbAmt[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (pOthAmt[i] != null)
					model.setPOthAmt(pOthAmt[i]);
				if (pEqvAmt[i] != null)
					model.setPEqvAmt(pEqvAmt[i]);
				if (pOthCurr[i] != null)
					model.setPOthCurr(pOthCurr[i]);
				if (pThbAmt[i] != null)
					model.setPThbAmt(pThbAmt[i]);
				if (cOthAmt[i] != null)
					model.setCOthAmt(cOthAmt[i]);				
				if (cnt20[i] != null)
					model.setCnt20(cnt20[i]);
				if (cnt40[i] != null)
					model.setCnt40(cnt40[i]);
				if (pInrAmt[i] != null)
					model.setPInrAmt(pInrAmt[i]);
				if (pInrTot[i] != null)
					model.setPInrTot(pInrTot[i]);
				if (cInrAmt[i] != null)
					model.setCInrAmt(cInrAmt[i]);
				if (cInrTot[i] != null)
					model.setCInrTot(cInrTot[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sInrTot[i] != null)
					model.setSInrTot(sInrTot[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBKGForTaxByVesselVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BKGForTaxByVesselVO[]
	 */
	public BKGForTaxByVesselVO[] getBKGForTaxByVesselVOs(){
		BKGForTaxByVesselVO[] vos = (BKGForTaxByVesselVO[])models.toArray(new BKGForTaxByVesselVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	
	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cOthCurr = this.cOthCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pUsdAmt = this.pUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cUsdAmt = this.cUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cEqvAmt = this.cEqvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cThbAmt = this.cThbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOthAmt = this.pOthAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqvAmt = this.pEqvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOthCurr = this.pOthCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pThbAmt = this.pThbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cOthAmt = this.cOthAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt20 = this.cnt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt40 = this.cnt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pInrAmt = this.pInrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pInrTot = this.pInrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cInrAmt = this.cInrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cInrTot = this.cInrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInrTot = this.sInrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
