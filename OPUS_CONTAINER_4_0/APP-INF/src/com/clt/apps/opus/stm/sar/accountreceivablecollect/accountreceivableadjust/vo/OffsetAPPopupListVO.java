/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OffsetAPPopupListVO.java
*@FileTitle : OffsetAPPopupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
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

public class OffsetAPPopupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OffsetAPPopupListVO> models = new ArrayList<OffsetAPPopupListVO>();
	
	/* Column Info */
	private String orgInvAmt = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String invDtFm = null;
	/* Column Info */
	private String invXchDt = null;
	/* Column Info */
	private String offstTpCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String invDtTo = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String apXchRt = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String otsCd = null;
	/* Column Info */
	private String offstCurrCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invXchRtTpCd = null;
	/* Column Info */
	private String repOtsOfcCd = null;
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OffsetAPPopupListVO() {}

	public OffsetAPPopupListVO(String ibflag, String pagerows, String orgInvAmt, String glDt, String invDtFm, String invXchDt, String offstTpCd, String vndrLglEngNm, String invSeq, String invDtTo, String invCurrCd, String apXchRt, String invNo, String ofcCd, String vndrNo, String offstCurrCd, String invXchRtTpCd, String invAmt, String invDt, String otsCd, String repOtsOfcCd, String dpPrcsKnt) {
		this.orgInvAmt = orgInvAmt;
		this.glDt = glDt;
		this.invDtFm = invDtFm;
		this.invXchDt = invXchDt;
		this.offstTpCd = offstTpCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.invSeq = invSeq;
		this.invDtTo = invDtTo;
		this.invCurrCd = invCurrCd;
		this.pagerows = pagerows;
		this.apXchRt = apXchRt;
		this.dpPrcsKnt = dpPrcsKnt;
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.vndrNo = vndrNo;
		this.ibflag = ibflag;
		this.otsCd = otsCd;
		this.offstCurrCd = offstCurrCd;
		this.invAmt = invAmt;
		this.invXchRtTpCd = invXchRtTpCd;
		this.repOtsOfcCd = repOtsOfcCd;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_inv_amt", getOrgInvAmt());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("inv_dt_fm", getInvDtFm());
		this.hashColumns.put("inv_xch_dt", getInvXchDt());
		this.hashColumns.put("offst_tp_cd", getOffstTpCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("inv_dt_to", getInvDtTo());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ap_xch_rt", getApXchRt());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ots_cd", getOtsCd());
		this.hashColumns.put("offst_curr_cd", getOffstCurrCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_xch_rt_tp_cd", getInvXchRtTpCd());
		this.hashColumns.put("rep_ots_ofc_cd", getRepOtsOfcCd());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_inv_amt", "orgInvAmt");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("inv_dt_fm", "invDtFm");
		this.hashFields.put("inv_xch_dt", "invXchDt");
		this.hashFields.put("offst_tp_cd", "offstTpCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("inv_dt_to", "invDtTo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ap_xch_rt", "apXchRt");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ots_cd", "otsCd");
		this.hashFields.put("offst_curr_cd", "offstCurrCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_xch_rt_tp_cd", "invXchRtTpCd");
		this.hashFields.put("rep_ots_ofc_cd", "repOtsOfcCd");
		this.hashFields.put("inv_dt", "invDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgInvAmt
	 */
	public String getOrgInvAmt() {
		return this.orgInvAmt;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return invDtFm
	 */
	public String getInvDtFm() {
		return this.invDtFm;
	}
	
	/**
	 * Column Info
	 * @return invXchDt
	 */
	public String getInvXchDt() {
		return this.invXchDt;
	}
	
	/**
	 * Column Info
	 * @return offstTpCd
	 */
	public String getOffstTpCd() {
		return this.offstTpCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return invDtTo
	 */
	public String getInvDtTo() {
		return this.invDtTo;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return apXchRt
	 */
	public String getApXchRt() {
		return this.apXchRt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return otsCd
	 */
	public String getOtsCd() {
		return this.otsCd;
	}
	
	/**
	 * Column Info
	 * @return offstCurrCd
	 */
	public String getOffstCurrCd() {
		return this.offstCurrCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return invXchRtTpCd
	 */
	public String getInvXchRtTpCd() {
		return this.invXchRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return repOtsOfcCd
	 */
	public String getRepOtsOfcCd() {
		return this.repOtsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	

	/**
	 * Column Info
	 * @param orgInvAmt
	 */
	public void setOrgInvAmt(String orgInvAmt) {
		this.orgInvAmt = orgInvAmt;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param invDtFm
	 */
	public void setInvDtFm(String invDtFm) {
		this.invDtFm = invDtFm;
	}
	
	/**
	 * Column Info
	 * @param invXchDt
	 */
	public void setInvXchDt(String invXchDt) {
		this.invXchDt = invXchDt;
	}
	
	/**
	 * Column Info
	 * @param offstTpCd
	 */
	public void setOffstTpCd(String offstTpCd) {
		this.offstTpCd = offstTpCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param invDtTo
	 */
	public void setInvDtTo(String invDtTo) {
		this.invDtTo = invDtTo;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param apXchRt
	 */
	public void setApXchRt(String apXchRt) {
		this.apXchRt = apXchRt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param otsCd
	 */
	public void setOtsCd(String otsCd) {
		this.otsCd = otsCd;
	}
	
	/**
	 * Column Info
	 * @param offstCurrCd
	 */
	public void setOffstCurrCd(String offstCurrCd) {
		this.offstCurrCd = offstCurrCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param invXchRtTpCd
	 */
	public void setInvXchRtTpCd(String invXchRtTpCd) {
		this.invXchRtTpCd = invXchRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param repOtsOfcCd
	 */
	public void setRepOtsOfcCd(String repOtsOfcCd) {
		this.repOtsOfcCd = repOtsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
		setOrgInvAmt(JSPUtil.getParameter(request, prefix + "org_inv_amt", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setInvDtFm(JSPUtil.getParameter(request, prefix + "inv_dt_fm", ""));
		setInvXchDt(JSPUtil.getParameter(request, prefix + "inv_xch_dt", ""));
		setOffstTpCd(JSPUtil.getParameter(request, prefix + "offst_tp_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setInvDtTo(JSPUtil.getParameter(request, prefix + "inv_dt_to", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setApXchRt(JSPUtil.getParameter(request, prefix + "ap_xch_rt", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOtsCd(JSPUtil.getParameter(request, prefix + "ots_cd", ""));
		setOffstCurrCd(JSPUtil.getParameter(request, prefix + "offst_curr_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvXchRtTpCd(JSPUtil.getParameter(request, prefix + "inv_xch_rt_tp_cd", ""));
		setRepOtsOfcCd(JSPUtil.getParameter(request, prefix + "rep_ots_ofc_cd", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OffsetAPPopupListVO[]
	 */
	public OffsetAPPopupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OffsetAPPopupListVO[]
	 */
	public OffsetAPPopupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OffsetAPPopupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgInvAmt = (JSPUtil.getParameter(request, prefix	+ "org_inv_amt", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] invDtFm = (JSPUtil.getParameter(request, prefix	+ "inv_dt_fm", length));
			String[] invXchDt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_dt", length));
			String[] offstTpCd = (JSPUtil.getParameter(request, prefix	+ "offst_tp_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] invDtTo = (JSPUtil.getParameter(request, prefix	+ "inv_dt_to", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] apXchRt = (JSPUtil.getParameter(request, prefix	+ "ap_xch_rt", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] otsCd = (JSPUtil.getParameter(request, prefix	+ "ots_cd", length));
			String[] offstCurrCd = (JSPUtil.getParameter(request, prefix	+ "offst_curr_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invXchRtTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt_tp_cd", length));
			String[] repOtsOfcCd = (JSPUtil.getParameter(request, prefix	+ "rep_ots_ofc_cd", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new OffsetAPPopupListVO();
				if (orgInvAmt[i] != null)
					model.setOrgInvAmt(orgInvAmt[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (invDtFm[i] != null)
					model.setInvDtFm(invDtFm[i]);
				if (invXchDt[i] != null)
					model.setInvXchDt(invXchDt[i]);
				if (offstTpCd[i] != null)
					model.setOffstTpCd(offstTpCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (invDtTo[i] != null)
					model.setInvDtTo(invDtTo[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (apXchRt[i] != null)
					model.setApXchRt(apXchRt[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (otsCd[i] != null)
					model.setOtsCd(otsCd[i]);
				if (offstCurrCd[i] != null)
					model.setOffstCurrCd(offstCurrCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invXchRtTpCd[i] != null)
					model.setInvXchRtTpCd(invXchRtTpCd[i]);
				if (repOtsOfcCd[i] != null)
					model.setRepOtsOfcCd(repOtsOfcCd[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOffsetAPPopupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OffsetAPPopupListVO[]
	 */
	public OffsetAPPopupListVO[] getOffsetAPPopupListVOs(){
		OffsetAPPopupListVO[] vos = (OffsetAPPopupListVO[])models.toArray(new OffsetAPPopupListVO[models.size()]);
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
		this.orgInvAmt = this.orgInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtFm = this.invDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchDt = this.invXchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offstTpCd = this.offstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtTo = this.invDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apXchRt = this.apXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCd = this.otsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offstCurrCd = this.offstCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtTpCd = this.invXchRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repOtsOfcCd = this.repOtsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
