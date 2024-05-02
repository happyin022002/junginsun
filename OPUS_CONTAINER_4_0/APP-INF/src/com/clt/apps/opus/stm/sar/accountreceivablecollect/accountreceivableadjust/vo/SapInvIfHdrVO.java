/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SapInvIfHdrVO.java
*@FileTitle : SapInvIfHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14  
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

public class SapInvIfHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SapInvIfHdrVO> models = new ArrayList<SapInvIfHdrVO>();
	
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String apPayMzdLuCd = null;
	/* Column Info */
	private String interCoCd = null;
	/* Column Info */
	private String invRcvDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String invDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String attrCtnt4 = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String attrCtnt7 = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String attrCateNm = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String payGrpLuCd = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String invPayCurrCd = null;
	/* Column Info */
	private String invXchDt = null;
	/* Column Info */
	private String ifSrcNm = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String invTpLuCd = null;
	/* Column Info */
	private String invTermDt = null;
	/* Column Info */
	private String invIfStsCd = null;
	/* Column Info */
	private String invXchRtTpCd = null;
	/* Column Info */
	private String invTermNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SapInvIfHdrVO() {}

	public SapInvIfHdrVO(String ibflag, String pagerows, String glDt, String apPayMzdLuCd, String interCoCd, String invRcvDt, String invDesc, String vndrNo, String attrCtnt2, String ctrCd, String attrCtnt4, String cntCd, String attrCtnt7, String invAmt, String attrCateNm, String invXchRt, String invDt, String payGrpLuCd, String coCd, String invPayCurrCd, String invXchDt, String ifSrcNm, String invCurrCd, String invNo, String ofcCd, String invTermDt, String invTpLuCd, String invXchRtTpCd, String invIfStsCd, String invTermNm, String vvdCd) {
		this.glDt = glDt;
		this.apPayMzdLuCd = apPayMzdLuCd;
		this.interCoCd = interCoCd;
		this.invRcvDt = invRcvDt;
		this.pagerows = pagerows;
		this.attrCtnt2 = attrCtnt2;
		this.vndrNo = vndrNo;
		this.invDesc = invDesc;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.vvdCd = vvdCd;
		this.attrCtnt4 = attrCtnt4;
		this.cntCd = cntCd;
		this.attrCtnt7 = attrCtnt7;
		this.invAmt = invAmt;
		this.attrCateNm = attrCateNm;
		this.invXchRt = invXchRt;
		this.invDt = invDt;
		this.payGrpLuCd = payGrpLuCd;
		this.coCd = coCd;
		this.invPayCurrCd = invPayCurrCd;
		this.invXchDt = invXchDt;
		this.ifSrcNm = ifSrcNm;
		this.invCurrCd = invCurrCd;
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.invTpLuCd = invTpLuCd;
		this.invTermDt = invTermDt;
		this.invIfStsCd = invIfStsCd;
		this.invXchRtTpCd = invXchRtTpCd;
		this.invTermNm = invTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("ap_pay_mzd_lu_cd", getApPayMzdLuCd());
		this.hashColumns.put("inter_co_cd", getInterCoCd());
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("pay_grp_lu_cd", getPayGrpLuCd());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("inv_pay_curr_cd", getInvPayCurrCd());
		this.hashColumns.put("inv_xch_dt", getInvXchDt());
		this.hashColumns.put("if_src_nm", getIfSrcNm());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());
		this.hashColumns.put("inv_term_dt", getInvTermDt());
		this.hashColumns.put("inv_if_sts_cd", getInvIfStsCd());
		this.hashColumns.put("inv_xch_rt_tp_cd", getInvXchRtTpCd());
		this.hashColumns.put("inv_term_nm", getInvTermNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("ap_pay_mzd_lu_cd", "apPayMzdLuCd");
		this.hashFields.put("inter_co_cd", "interCoCd");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("pay_grp_lu_cd", "payGrpLuCd");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("inv_pay_curr_cd", "invPayCurrCd");
		this.hashFields.put("inv_xch_dt", "invXchDt");
		this.hashFields.put("if_src_nm", "ifSrcNm");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("inv_if_sts_cd", "invIfStsCd");
		this.hashFields.put("inv_xch_rt_tp_cd", "invXchRtTpCd");
		this.hashFields.put("inv_term_nm", "invTermNm");
		return this.hashFields;
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
	 * @return apPayMzdLuCd
	 */
	public String getApPayMzdLuCd() {
		return this.apPayMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @return interCoCd
	 */
	public String getInterCoCd() {
		return this.interCoCd;
	}
	
	/**
	 * Column Info
	 * @return invRcvDt
	 */
	public String getInvRcvDt() {
		return this.invRcvDt;
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
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt4
	 */
	public String getAttrCtnt4() {
		return this.attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt7
	 */
	public String getAttrCtnt7() {
		return this.attrCtnt7;
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
	 * @return attrCateNm
	 */
	public String getAttrCateNm() {
		return this.attrCateNm;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return payGrpLuCd
	 */
	public String getPayGrpLuCd() {
		return this.payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return invPayCurrCd
	 */
	public String getInvPayCurrCd() {
		return this.invPayCurrCd;
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
	 * @return ifSrcNm
	 */
	public String getIfSrcNm() {
		return this.ifSrcNm;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return invTpLuCd
	 */
	public String getInvTpLuCd() {
		return this.invTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return invTermDt
	 */
	public String getInvTermDt() {
		return this.invTermDt;
	}
	
	/**
	 * Column Info
	 * @return invIfStsCd
	 */
	public String getInvIfStsCd() {
		return this.invIfStsCd;
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
	 * @return invTermNm
	 */
	public String getInvTermNm() {
		return this.invTermNm;
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
	 * @param apPayMzdLuCd
	 */
	public void setApPayMzdLuCd(String apPayMzdLuCd) {
		this.apPayMzdLuCd = apPayMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @param interCoCd
	 */
	public void setInterCoCd(String interCoCd) {
		this.interCoCd = interCoCd;
	}
	
	/**
	 * Column Info
	 * @param invRcvDt
	 */
	public void setInvRcvDt(String invRcvDt) {
		this.invRcvDt = invRcvDt;
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
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt4
	 */
	public void setAttrCtnt4(String attrCtnt4) {
		this.attrCtnt4 = attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt7
	 */
	public void setAttrCtnt7(String attrCtnt7) {
		this.attrCtnt7 = attrCtnt7;
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
	 * @param attrCateNm
	 */
	public void setAttrCateNm(String attrCateNm) {
		this.attrCateNm = attrCateNm;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param payGrpLuCd
	 */
	public void setPayGrpLuCd(String payGrpLuCd) {
		this.payGrpLuCd = payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param invPayCurrCd
	 */
	public void setInvPayCurrCd(String invPayCurrCd) {
		this.invPayCurrCd = invPayCurrCd;
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
	 * @param ifSrcNm
	 */
	public void setIfSrcNm(String ifSrcNm) {
		this.ifSrcNm = ifSrcNm;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param invTpLuCd
	 */
	public void setInvTpLuCd(String invTpLuCd) {
		this.invTpLuCd = invTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param invTermDt
	 */
	public void setInvTermDt(String invTermDt) {
		this.invTermDt = invTermDt;
	}
	
	/**
	 * Column Info
	 * @param invIfStsCd
	 */
	public void setInvIfStsCd(String invIfStsCd) {
		this.invIfStsCd = invIfStsCd;
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
	 * @param invTermNm
	 */
	public void setInvTermNm(String invTermNm) {
		this.invTermNm = invTermNm;
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
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setApPayMzdLuCd(JSPUtil.getParameter(request, prefix + "ap_pay_mzd_lu_cd", ""));
		setInterCoCd(JSPUtil.getParameter(request, prefix + "inter_co_cd", ""));
		setInvRcvDt(JSPUtil.getParameter(request, prefix + "inv_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, prefix + "ctr_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setAttrCateNm(JSPUtil.getParameter(request, prefix + "attr_cate_nm", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setPayGrpLuCd(JSPUtil.getParameter(request, prefix + "pay_grp_lu_cd", ""));
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setInvPayCurrCd(JSPUtil.getParameter(request, prefix + "inv_pay_curr_cd", ""));
		setInvXchDt(JSPUtil.getParameter(request, prefix + "inv_xch_dt", ""));
		setIfSrcNm(JSPUtil.getParameter(request, prefix + "if_src_nm", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setInvTpLuCd(JSPUtil.getParameter(request, prefix + "inv_tp_lu_cd", ""));
		setInvTermDt(JSPUtil.getParameter(request, prefix + "inv_term_dt", ""));
		setInvIfStsCd(JSPUtil.getParameter(request, prefix + "inv_if_sts_cd", ""));
		setInvXchRtTpCd(JSPUtil.getParameter(request, prefix + "inv_xch_rt_tp_cd", ""));
		setInvTermNm(JSPUtil.getParameter(request, prefix + "inv_term_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SapInvIfHdrVO[]
	 */
	public SapInvIfHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SapInvIfHdrVO[]
	 */
	public SapInvIfHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SapInvIfHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] apPayMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "ap_pay_mzd_lu_cd", length));
			String[] interCoCd = (JSPUtil.getParameter(request, prefix	+ "inter_co_cd", length));
			String[] invRcvDt = (JSPUtil.getParameter(request, prefix	+ "inv_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt4", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] attrCateNm = (JSPUtil.getParameter(request, prefix	+ "attr_cate_nm", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] payGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_grp_lu_cd", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] invPayCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_curr_cd", length));
			String[] invXchDt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_dt", length));
			String[] ifSrcNm = (JSPUtil.getParameter(request, prefix	+ "if_src_nm", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] invTpLuCd = (JSPUtil.getParameter(request, prefix	+ "inv_tp_lu_cd", length));
			String[] invTermDt = (JSPUtil.getParameter(request, prefix	+ "inv_term_dt", length));
			String[] invIfStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_if_sts_cd", length));
			String[] invXchRtTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt_tp_cd", length));
			String[] invTermNm = (JSPUtil.getParameter(request, prefix	+ "inv_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SapInvIfHdrVO();
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (apPayMzdLuCd[i] != null)
					model.setApPayMzdLuCd(apPayMzdLuCd[i]);
				if (interCoCd[i] != null)
					model.setInterCoCd(interCoCd[i]);
				if (invRcvDt[i] != null)
					model.setInvRcvDt(invRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (attrCtnt4[i] != null)
					model.setAttrCtnt4(attrCtnt4[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (attrCateNm[i] != null)
					model.setAttrCateNm(attrCateNm[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (payGrpLuCd[i] != null)
					model.setPayGrpLuCd(payGrpLuCd[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (invPayCurrCd[i] != null)
					model.setInvPayCurrCd(invPayCurrCd[i]);
				if (invXchDt[i] != null)
					model.setInvXchDt(invXchDt[i]);
				if (ifSrcNm[i] != null)
					model.setIfSrcNm(ifSrcNm[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (invTpLuCd[i] != null)
					model.setInvTpLuCd(invTpLuCd[i]);
				if (invTermDt[i] != null)
					model.setInvTermDt(invTermDt[i]);
				if (invIfStsCd[i] != null)
					model.setInvIfStsCd(invIfStsCd[i]);
				if (invXchRtTpCd[i] != null)
					model.setInvXchRtTpCd(invXchRtTpCd[i]);
				if (invTermNm[i] != null)
					model.setInvTermNm(invTermNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSapInvIfHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SapInvIfHdrVO[]
	 */
	public SapInvIfHdrVO[] getSapInvIfHdrVOs(){
		SapInvIfHdrVO[] vos = (SapInvIfHdrVO[])models.toArray(new SapInvIfHdrVO[models.size()]);
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
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayMzdLuCd = this.apPayMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interCoCd = this.interCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt = this.invRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 = this.attrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm = this.attrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGrpLuCd = this.payGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayCurrCd = this.invPayCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchDt = this.invXchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSrcNm = this.ifSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd = this.invTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt = this.invTermDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfStsCd = this.invIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtTpCd = this.invXchRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermNm = this.invTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
