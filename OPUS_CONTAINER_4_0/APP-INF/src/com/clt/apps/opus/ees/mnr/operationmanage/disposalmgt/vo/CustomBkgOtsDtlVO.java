/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomBkgOtsDtlVO.java
*@FileTitle : CustomBkgOtsDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.04 함형석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomBkgOtsDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomBkgOtsDtlVO> models = new ArrayList<CustomBkgOtsDtlVO>();
	
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String cltFrtAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String invFrtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invTaxAmt = null;
	/* Column Info */
	private String balTaxAmt = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String cltTaxAmt = null;
	/* Column Info */
	private String balFrtAmt = null;
	/* Column Info */
	private String cltLstUpdDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomBkgOtsDtlVO() {}

	public CustomBkgOtsDtlVO(String ibflag, String pagerows, String ofcCd, String blCurrCd, String invFrtAmt, String invTaxAmt, String cltFrtAmt, String cltTaxAmt, String balFrtAmt, String balTaxAmt, String cltLstUpdDt, String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
		this.cltFrtAmt = cltFrtAmt;
		this.ofcCd = ofcCd;
		this.invFrtAmt = invFrtAmt;
		this.ibflag = ibflag;
		this.invTaxAmt = invTaxAmt;
		this.balTaxAmt = balTaxAmt;
		this.blCurrCd = blCurrCd;
		this.cltTaxAmt = cltTaxAmt;
		this.balFrtAmt = balFrtAmt;
		this.cltLstUpdDt = cltLstUpdDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("clt_frt_amt", getCltFrtAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("inv_frt_amt", getInvFrtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_tax_amt", getInvTaxAmt());
		this.hashColumns.put("bal_tax_amt", getBalTaxAmt());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("clt_tax_amt", getCltTaxAmt());
		this.hashColumns.put("bal_frt_amt", getBalFrtAmt());
		this.hashColumns.put("clt_lst_upd_dt", getCltLstUpdDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("clt_frt_amt", "cltFrtAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("inv_frt_amt", "invFrtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_tax_amt", "invTaxAmt");
		this.hashFields.put("bal_tax_amt", "balTaxAmt");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("clt_tax_amt", "cltTaxAmt");
		this.hashFields.put("bal_frt_amt", "balFrtAmt");
		this.hashFields.put("clt_lst_upd_dt", "cltLstUpdDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return cltFrtAmt
	 */
	public String getCltFrtAmt() {
		return this.cltFrtAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return invFrtAmt
	 */
	public String getInvFrtAmt() {
		return this.invFrtAmt;
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
	 * @return invTaxAmt
	 */
	public String getInvTaxAmt() {
		return this.invTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return balTaxAmt
	 */
	public String getBalTaxAmt() {
		return this.balTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return blCurrCd
	 */
	public String getBlCurrCd() {
		return this.blCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cltTaxAmt
	 */
	public String getCltTaxAmt() {
		return this.cltTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return balFrtAmt
	 */
	public String getBalFrtAmt() {
		return this.balFrtAmt;
	}
	
	/**
	 * Column Info
	 * @return cltLstUpdDt
	 */
	public String getCltLstUpdDt() {
		return this.cltLstUpdDt;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param cltFrtAmt
	 */
	public void setCltFrtAmt(String cltFrtAmt) {
		this.cltFrtAmt = cltFrtAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param invFrtAmt
	 */
	public void setInvFrtAmt(String invFrtAmt) {
		this.invFrtAmt = invFrtAmt;
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
	 * @param invTaxAmt
	 */
	public void setInvTaxAmt(String invTaxAmt) {
		this.invTaxAmt = invTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param balTaxAmt
	 */
	public void setBalTaxAmt(String balTaxAmt) {
		this.balTaxAmt = balTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param blCurrCd
	 */
	public void setBlCurrCd(String blCurrCd) {
		this.blCurrCd = blCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cltTaxAmt
	 */
	public void setCltTaxAmt(String cltTaxAmt) {
		this.cltTaxAmt = cltTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param balFrtAmt
	 */
	public void setBalFrtAmt(String balFrtAmt) {
		this.balFrtAmt = balFrtAmt;
	}
	
	/**
	 * Column Info
	 * @param cltLstUpdDt
	 */
	public void setCltLstUpdDt(String cltLstUpdDt) {
		this.cltLstUpdDt = cltLstUpdDt;
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
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setCltFrtAmt(JSPUtil.getParameter(request, "clt_frt_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setInvFrtAmt(JSPUtil.getParameter(request, "inv_frt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInvTaxAmt(JSPUtil.getParameter(request, "inv_tax_amt", ""));
		setBalTaxAmt(JSPUtil.getParameter(request, "bal_tax_amt", ""));
		setBlCurrCd(JSPUtil.getParameter(request, "bl_curr_cd", ""));
		setCltTaxAmt(JSPUtil.getParameter(request, "clt_tax_amt", ""));
		setBalFrtAmt(JSPUtil.getParameter(request, "bal_frt_amt", ""));
		setCltLstUpdDt(JSPUtil.getParameter(request, "clt_lst_upd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomBkgOtsDtlVO[]
	 */
	public CustomBkgOtsDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomBkgOtsDtlVO[]
	 */
	public CustomBkgOtsDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomBkgOtsDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] cltFrtAmt = (JSPUtil.getParameter(request, prefix	+ "clt_frt_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] invFrtAmt = (JSPUtil.getParameter(request, prefix	+ "inv_frt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invTaxAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_amt", length));
			String[] balTaxAmt = (JSPUtil.getParameter(request, prefix	+ "bal_tax_amt", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix	+ "bl_curr_cd", length));
			String[] cltTaxAmt = (JSPUtil.getParameter(request, prefix	+ "clt_tax_amt", length));
			String[] balFrtAmt = (JSPUtil.getParameter(request, prefix	+ "bal_frt_amt", length));
			String[] cltLstUpdDt = (JSPUtil.getParameter(request, prefix	+ "clt_lst_upd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomBkgOtsDtlVO();
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (cltFrtAmt[i] != null)
					model.setCltFrtAmt(cltFrtAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (invFrtAmt[i] != null)
					model.setInvFrtAmt(invFrtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invTaxAmt[i] != null)
					model.setInvTaxAmt(invTaxAmt[i]);
				if (balTaxAmt[i] != null)
					model.setBalTaxAmt(balTaxAmt[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (cltTaxAmt[i] != null)
					model.setCltTaxAmt(cltTaxAmt[i]);
				if (balFrtAmt[i] != null)
					model.setBalFrtAmt(balFrtAmt[i]);
				if (cltLstUpdDt[i] != null)
					model.setCltLstUpdDt(cltLstUpdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomBkgOtsDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomBkgOtsDtlVO[]
	 */
	public CustomBkgOtsDtlVO[] getCustomBkgOtsDtlVOs(){
		CustomBkgOtsDtlVO[] vos = (CustomBkgOtsDtlVO[])models.toArray(new CustomBkgOtsDtlVO[models.size()]);
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
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltFrtAmt = this.cltFrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFrtAmt = this.invFrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxAmt = this.invTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balTaxAmt = this.balTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltTaxAmt = this.cltTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balFrtAmt = this.balFrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltLstUpdDt = this.cltLstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
