/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgAgnCommDeductionRatingVO.java
*@FileTitle : BkgAgnCommDeductionRatingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.09.23 이호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgAgnCommDeductionRatingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgAgnCommDeductionRatingVO> models = new ArrayList<BkgAgnCommDeductionRatingVO>();
	
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chgAmtRt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String inclOftFlg = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String custPayer = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String rateType = null;
	/* Column Info */
	private String officeCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgAgnCommDeductionRatingVO() {}

	public BkgAgnCommDeductionRatingVO(String ibflag, String pagerows, String chgCd, String currCd, String chgUtAmt, String ratAsQty, String ratUtCd, String chgAmt, String chgAmtRt, String inclOftFlg, String custPayer, String cgoCateCd, String rcvTermCd, String deTermCd, String rtSeq, String rateType,String officeCd ) {
		this.chgUtAmt = chgUtAmt;
		this.currCd = currCd;
		this.chgAmtRt = chgAmtRt;
		this.ratUtCd = ratUtCd;
		this.inclOftFlg = inclOftFlg;
		this.rtSeq = rtSeq;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.cgoCateCd = cgoCateCd;
		this.custPayer = custPayer;
		this.chgAmt = chgAmt;
		this.ratAsQty = ratAsQty;
		this.rcvTermCd = rcvTermCd;
		this.rateType = rateType;
		this.officeCd = officeCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chg_amt_rt", getChgAmtRt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("incl_oft_flg", getInclOftFlg());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("cust_payer", getCustPayer());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("rate_type", getRateType());
		this.hashColumns.put("office_cd", getOfficeCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chg_amt_rt", "chgAmtRt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("incl_oft_flg", "inclOftFlg");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("cust_payer", "custPayer");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("rate_type", "rateType");
		this.hashFields.put("office_cd", "officeCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
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
	 * @return chgAmtRt
	 */
	public String getChgAmtRt() {
		return this.chgAmtRt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return inclOftFlg
	 */
	public String getInclOftFlg() {
		return this.inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return custPayer
	 */
	public String getCustPayer() {
		return this.custPayer;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	public String getRateType() {
    	return rateType;
    }
	
	public String getOfficeCd() {
    	return officeCd;
    }

	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
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
	 * @param chgAmtRt
	 */
	public void setChgAmtRt(String chgAmtRt) {
		this.chgAmtRt = chgAmtRt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param inclOftFlg
	 */
	public void setInclOftFlg(String inclOftFlg) {
		this.inclOftFlg = inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param custPayer
	 */
	public void setCustPayer(String custPayer) {
		this.custPayer = custPayer;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	public void setRateType(String rateType) {
    	this.rateType = rateType;
    }

	public void setOfficeCd(String officeCd) {
    	this.officeCd = officeCd;
    }
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChgUtAmt(JSPUtil.getParameter(request, "chg_ut_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setChgAmtRt(JSPUtil.getParameter(request, "chg_amt_rt", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setInclOftFlg(JSPUtil.getParameter(request, "incl_oft_flg", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoCateCd(JSPUtil.getParameter(request, "cgo_cate_cd", ""));
		setCustPayer(JSPUtil.getParameter(request, "cust_payer", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setRatAsQty(JSPUtil.getParameter(request, "rat_as_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setRateType(JSPUtil.getParameter(request, "rate_type", ""));
		setOfficeCd(JSPUtil.getParameter(request, "office_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgAgnCommDeductionRatingVO[]
	 */
	public BkgAgnCommDeductionRatingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgAgnCommDeductionRatingVO[]
	 */
	public BkgAgnCommDeductionRatingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgAgnCommDeductionRatingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chgAmtRt = (JSPUtil.getParameter(request, prefix	+ "chg_amt_rt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] inclOftFlg = (JSPUtil.getParameter(request, prefix	+ "incl_oft_flg", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] custPayer = (JSPUtil.getParameter(request, prefix	+ "cust_payer", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] rateType = (JSPUtil.getParameter(request, prefix	+ "rate_type", length));
			String[] officeCd = (JSPUtil.getParameter(request, prefix	+ "office_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgAgnCommDeductionRatingVO();
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chgAmtRt[i] != null)
					model.setChgAmtRt(chgAmtRt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (inclOftFlg[i] != null)
					model.setInclOftFlg(inclOftFlg[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (custPayer[i] != null)
					model.setCustPayer(custPayer[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (rateType[i] != null)
					model.setRateType(rateType[i]);
				if (officeCd[i] != null)
					model.setOfficeCd(officeCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgAgnCommDeductionRatingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgAgnCommDeductionRatingVO[]
	 */
	public BkgAgnCommDeductionRatingVO[] getBkgAgnCommDeductionRatingVOs(){
		BkgAgnCommDeductionRatingVO[] vos = (BkgAgnCommDeductionRatingVO[])models.toArray(new BkgAgnCommDeductionRatingVO[models.size()]);
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
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmtRt = this.chgAmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclOftFlg = this.inclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custPayer = this.custPayer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateType = this.rateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officeCd = this.officeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
