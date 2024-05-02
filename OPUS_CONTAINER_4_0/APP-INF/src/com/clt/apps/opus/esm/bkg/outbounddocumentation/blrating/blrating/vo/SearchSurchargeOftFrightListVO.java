/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSurchargeOftFrightListVO.java
*@FileTitle : SearchSurchargeOftFrightListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.12.03 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSurchargeOftFrightListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSurchargeOftFrightListVO> models = new ArrayList<SearchSurchargeOftFrightListVO>();
	
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String maxOftCmbSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String maxOfrtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oftCmbSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String ofrtSeq = null;
	/* Column Info */
	private String sumAmount = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSurchargeOftFrightListVO() {}

	public SearchSurchargeOftFrightListVO(String ibflag, String pagerows, String bkgNo, String oftCmbSeq, String ofrtSeq, String chgCd, String chgUtAmt, String currCd, String chgAmt, String ratAsQty, String maxOftCmbSeq, String maxOfrtSeq, String sumAmount) {
		this.chgUtAmt = chgUtAmt;
		this.currCd = currCd;
		this.maxOftCmbSeq = maxOftCmbSeq;
		this.chgCd = chgCd;
		this.maxOfrtSeq = maxOfrtSeq;
		this.pagerows = pagerows;
		this.oftCmbSeq = oftCmbSeq;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.chgAmt = chgAmt;
		this.ratAsQty = ratAsQty;
		this.ofrtSeq = ofrtSeq;
		this.sumAmount = sumAmount;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("max_oft_cmb_seq", getMaxOftCmbSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("max_ofrt_seq", getMaxOfrtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("oft_cmb_seq", getOftCmbSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("ofrt_seq", getOfrtSeq());
		this.hashColumns.put("sum_amount", getSumAmount());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("max_oft_cmb_seq", "maxOftCmbSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("max_ofrt_seq", "maxOfrtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("oft_cmb_seq", "oftCmbSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("ofrt_seq", "ofrtSeq");
		this.hashFields.put("sum_amount", "sumAmount");
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
	 * @return maxOftCmbSeq
	 */
	public String getMaxOftCmbSeq() {
		return this.maxOftCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return maxOfrtSeq
	 */
	public String getMaxOfrtSeq() {
		return this.maxOfrtSeq;
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
	 * @return oftCmbSeq
	 */
	public String getOftCmbSeq() {
		return this.oftCmbSeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return ofrtSeq
	 */
	public String getOfrtSeq() {
		return this.ofrtSeq;
	}
	
	/**
	 * Column Info
	 * @return sumAmount
	 */
	public String getSumAmount() {
		return this.sumAmount;
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
	 * @param maxOftCmbSeq
	 */
	public void setMaxOftCmbSeq(String maxOftCmbSeq) {
		this.maxOftCmbSeq = maxOftCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param maxOfrtSeq
	 */
	public void setMaxOfrtSeq(String maxOfrtSeq) {
		this.maxOfrtSeq = maxOfrtSeq;
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
	 * @param oftCmbSeq
	 */
	public void setOftCmbSeq(String oftCmbSeq) {
		this.oftCmbSeq = oftCmbSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param ofrtSeq
	 */
	public void setOfrtSeq(String ofrtSeq) {
		this.ofrtSeq = ofrtSeq;
	}
	
	/**
	 * Column Info
	 * @param sumAmount
	 */
	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChgUtAmt(JSPUtil.getParameter(request, "chg_ut_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMaxOftCmbSeq(JSPUtil.getParameter(request, "max_oft_cmb_seq", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setMaxOfrtSeq(JSPUtil.getParameter(request, "max_ofrt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOftCmbSeq(JSPUtil.getParameter(request, "oft_cmb_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setRatAsQty(JSPUtil.getParameter(request, "rat_as_qty", ""));
		setOfrtSeq(JSPUtil.getParameter(request, "ofrt_seq", ""));
		setSumAmount(JSPUtil.getParameter(request, "sum_amount", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSurchargeOftFrightListVO[]
	 */
	public SearchSurchargeOftFrightListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSurchargeOftFrightListVO[]
	 */
	public SearchSurchargeOftFrightListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSurchargeOftFrightListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] maxOftCmbSeq = (JSPUtil.getParameter(request, prefix	+ "max_oft_cmb_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] maxOfrtSeq = (JSPUtil.getParameter(request, prefix	+ "max_ofrt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oftCmbSeq = (JSPUtil.getParameter(request, prefix	+ "oft_cmb_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] ofrtSeq = (JSPUtil.getParameter(request, prefix	+ "ofrt_seq", length));
			String[] sumAmount = (JSPUtil.getParameter(request, prefix	+ "sum_amount", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSurchargeOftFrightListVO();
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (maxOftCmbSeq[i] != null)
					model.setMaxOftCmbSeq(maxOftCmbSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (maxOfrtSeq[i] != null)
					model.setMaxOfrtSeq(maxOfrtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oftCmbSeq[i] != null)
					model.setOftCmbSeq(oftCmbSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (ofrtSeq[i] != null)
					model.setOfrtSeq(ofrtSeq[i]);
				if (sumAmount[i] != null)
					model.setSumAmount(sumAmount[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSurchargeOftFrightListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSurchargeOftFrightListVO[]
	 */
	public SearchSurchargeOftFrightListVO[] getSearchSurchargeOftFrightListVOs(){
		SearchSurchargeOftFrightListVO[] vos = (SearchSurchargeOftFrightListVO[])models.toArray(new SearchSurchargeOftFrightListVO[models.size()]);
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
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxOftCmbSeq = this.maxOftCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxOfrtSeq = this.maxOfrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftCmbSeq = this.oftCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofrtSeq = this.ofrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumAmount = this.sumAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
