/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableInvoiceInquiryVO.java
*@FileTitle : ReceivableInvoiceInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.21 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReceivableInvoiceInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ReceivableInvoiceInquiryVO> models = new ArrayList<ReceivableInvoiceInquiryVO>();

	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String erpLclAmt = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String srcIfSeq = null;
	/* Column Info */
	private String erpUsdAmt = null;
	/* Column Info */
	private String invIsuDt = null;
	/* Column Info */
	private String invCreDt = null;
	/* Column Info */
	private String blInvIfFlg = null;
	/* Column Info */
	private String invCreUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String otsStlFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String ofcCurrCd = null;
	/* Column Info */
	private String ifErrRsn = null;
	/* Column Info */
	private String erpIfSts = null;
	/* Column Info */
	private String erpIfRsn = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String invCreOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ReceivableInvoiceInquiryVO() {}

	public ReceivableInvoiceInquiryVO(String ibflag, String invCreOfcCd, String cfmFlg, String pagerows, String invIsuDt, String glEffDt, String creUsrId, String srcIfSeq, String ifErrRsn, String erpIfSts, String erpIfRsn, String costYrmon, String invNo, String vndrSeq, String vndrAbbrNm, String invCreDt, String currCd, String invAmt, String ofcCurrCd, String erpLclAmt, String erpUsdAmt, String otsStlFlg, String blInvIfFlg, String srcIfDt, String invCreUsrId) {
		this.currCd = currCd;
		this.erpLclAmt = erpLclAmt;
		this.srcIfDt = srcIfDt;
		this.srcIfSeq = srcIfSeq;
		this.erpUsdAmt = erpUsdAmt;
		this.invIsuDt = invIsuDt;
		this.invCreDt = invCreDt;
		this.blInvIfFlg = blInvIfFlg;
		this.invCreUsrId = invCreUsrId;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.otsStlFlg = otsStlFlg;
		this.vndrSeq = vndrSeq;
		this.invAmt = invAmt;
		this.vndrAbbrNm = vndrAbbrNm;
		this.ofcCurrCd = ofcCurrCd;
		this.ifErrRsn = ifErrRsn;
		this.erpIfSts = erpIfSts;
		this.erpIfRsn = erpIfRsn;
		this.creUsrId = creUsrId;
		this.glEffDt = glEffDt;
		this.cfmFlg = cfmFlg;
		this.invCreOfcCd = invCreOfcCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("erp_lcl_amt", getErpLclAmt());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("src_if_seq", getSrcIfSeq());
		this.hashColumns.put("erp_usd_amt", getErpUsdAmt());
		this.hashColumns.put("inv_isu_dt", getInvIsuDt());
		this.hashColumns.put("inv_cre_dt", getInvCreDt());
		this.hashColumns.put("bl_inv_if_flg", getBlInvIfFlg());
		this.hashColumns.put("inv_cre_usr_id", getInvCreUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("ots_stl_flg", getOtsStlFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("ofc_curr_cd", getOfcCurrCd());
		this.hashColumns.put("if_err_rsn", getIfErrRsn());
		this.hashColumns.put("erp_if_sts", getErpIfSts());
		this.hashColumns.put("erp_if_rsn", getErpIfRsn());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("inv_cre_ofc_cd", getInvCreOfcCd());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("erp_lcl_amt", "erpLclAmt");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("src_if_seq", "srcIfSeq");
		this.hashFields.put("erp_usd_amt", "erpUsdAmt");
		this.hashFields.put("inv_isu_dt", "invIsuDt");
		this.hashFields.put("inv_cre_dt", "invCreDt");
		this.hashFields.put("bl_inv_if_flg", "blInvIfFlg");
		this.hashFields.put("inv_cre_usr_id", "invCreUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("ots_stl_flg", "otsStlFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("ofc_curr_cd", "ofcCurrCd");
		this.hashFields.put("if_err_rsn", "ifErrRsn");
		this.hashFields.put("erp_if_sts", "erpIfSts");
		this.hashFields.put("erp_if_rsn", "erpIfRsn");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("inv_cre_ofc_cd", "invCreOfcCd");

		return this.hashFields;
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
	 * @return erpLclAmt
	 */
	public String getErpLclAmt() {
		return this.erpLclAmt;
	}

	/**
	 * Column Info
	 * @return srcIfDt
	 */
	public String getSrcIfDt() {
		return this.srcIfDt;
	}

	/**
	 * Column Info
	 * @return erpUsdAmt
	 */
	public String getErpUsdAmt() {
		return this.erpUsdAmt;
	}

	/**
	 * Column Info
	 * @return invCreDt
	 */
	public String getInvCreDt() {
		return this.invCreDt;
	}

	/**
	 * Column Info
	 * @return blInvIfFlg
	 */
	public String getBlInvIfFlg() {
		return this.blInvIfFlg;
	}

	/**
	 * Column Info
	 * @return invCreUsrId
	 */
	public String getInvCreUsrId() {
		return this.invCreUsrId;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}

	/**
	 * Column Info
	 * @return otsStlFlg
	 */
	public String getOtsStlFlg() {
		return this.otsStlFlg;
	}

	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @return ofcCurrCd
	 */
	public String getOfcCurrCd() {
		return this.ofcCurrCd;
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
	 * @param erpLclAmt
	 */
	public void setErpLclAmt(String erpLclAmt) {
		this.erpLclAmt = erpLclAmt;
	}

	/**
	 * Column Info
	 * @param srcIfDt
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}

	/**
	 * Column Info
	 * @param erpUsdAmt
	 */
	public void setErpUsdAmt(String erpUsdAmt) {
		this.erpUsdAmt = erpUsdAmt;
	}

	/**
	 * Column Info
	 * @param invCreDt
	 */
	public void setInvCreDt(String invCreDt) {
		this.invCreDt = invCreDt;
	}

	/**
	 * Column Info
	 * @param blInvIfFlg
	 */
	public void setBlInvIfFlg(String blInvIfFlg) {
		this.blInvIfFlg = blInvIfFlg;
	}

	/**
	 * Column Info
	 * @param invCreUsrId
	 */
	public void setInvCreUsrId(String invCreUsrId) {
		this.invCreUsrId = invCreUsrId;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}

	/**
	 * Column Info
	 * @param otsStlFlg
	 */
	public void setOtsStlFlg(String otsStlFlg) {
		this.otsStlFlg = otsStlFlg;
	}

	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @param ofcCurrCd
	 */
	public void setOfcCurrCd(String ofcCurrCd) {
		this.ofcCurrCd = ofcCurrCd;
	}

	/**
	 * @return the ifErrRsn
	 */
	public String getIfErrRsn() {
		return ifErrRsn;
	}

	/**
	 * @param ifErrRsn the ifErrRsn to set
	 */
	public void setIfErrRsn(String ifErrRsn) {
		this.ifErrRsn = ifErrRsn;
	}

	/**
	 * @return the erpIfSts
	 */
	public String getErpIfSts() {
		return erpIfSts;
	}

	/**
	 * @param erpIfSts the erpIfSts to set
	 */
	public void setErpIfSts(String erpIfSts) {
		this.erpIfSts = erpIfSts;
	}

	/**
	 * @return the erpIfRsn
	 */
	public String getErpIfRsn() {
		return erpIfRsn;
	}

	/**
	 * @param erpIfRsn the erpIfRsn to set
	 */
	public void setErpIfRsn(String erpIfRsn) {
		this.erpIfRsn = erpIfRsn;
	}

	/**
	 * @return the srcIfSeq
	 */
	public String getSrcIfSeq() {
		return srcIfSeq;
	}

	/**
	 * @param srcIfSeq the srcIfSeq to set
	 */
	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the glEffDt
	 */
	public String getGlEffDt() {
		return glEffDt;
	}

	/**
	 * @param glEffDt the glEffDt to set
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}

	/**
	 * @return the invIsuDt
	 */
	public String getInvIsuDt() {
		return invIsuDt;
	}

	/**
	 * @param invIsuDt the invIsuDt to set
	 */
	public void setInvIsuDt(String invIsuDt) {
		this.invIsuDt = invIsuDt;
	}

	/**
	 * @return the cfmFlg
	 */
	public String getCfmFlg() {
		return cfmFlg;
	}

	/**
	 * @param cfmFlg the cfmFlg to set
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}

	/**
	 * @return the invCreOfcCd
	 */
	public String getInvCreOfcCd() {
		return invCreOfcCd;
	}

	/**
	 * @param invCreOfcCd the invCreOfcCd to set
	 */
	public void setInvCreOfcCd(String invCreOfcCd) {
		this.invCreOfcCd = invCreOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setErpLclAmt(JSPUtil.getParameter(request, "erp_lcl_amt", ""));
		setSrcIfDt(JSPUtil.getParameter(request, "src_if_dt", ""));
		setSrcIfSeq(JSPUtil.getParameter(request, "src_if_seq", ""));
		setErpUsdAmt(JSPUtil.getParameter(request, "erp_usd_amt", ""));
		setInvIsuDt(JSPUtil.getParameter(request, "inv_isu_dt", ""));
		setInvCreDt(JSPUtil.getParameter(request, "inv_cre_dt", ""));
		setBlInvIfFlg(JSPUtil.getParameter(request, "bl_inv_if_flg", ""));
		setInvCreUsrId(JSPUtil.getParameter(request, "inv_cre_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setOtsStlFlg(JSPUtil.getParameter(request, "ots_stl_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setOfcCurrCd(JSPUtil.getParameter(request, "ofc_curr_cd", ""));
		setIfErrRsn(JSPUtil.getParameter(request, "if_err_rsn", ""));
		setErpIfSts(JSPUtil.getParameter(request, "erp_if_sts", ""));
		setErpIfRsn(JSPUtil.getParameter(request, "erp_if_rsn", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setInvCreOfcCd(JSPUtil.getParameter(request, "inv_cre_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceivableInvoiceInquiryVO[]
	 */
	public ReceivableInvoiceInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReceivableInvoiceInquiryVO[]
	 */
	public ReceivableInvoiceInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceivableInvoiceInquiryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] erpLclAmt = (JSPUtil.getParameter(request, prefix	+ "erp_lcl_amt", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] srcIfSeq = (JSPUtil.getParameter(request, prefix	+ "src_if_seq", length));
			String[] erpUsdAmt = (JSPUtil.getParameter(request, prefix	+ "erp_usd_amt", length));
			String[] invIsuDt = (JSPUtil.getParameter(request, prefix	+ "inv_isu_dt", length));
			String[] invCreDt = (JSPUtil.getParameter(request, prefix	+ "inv_cre_dt", length));
			String[] blInvIfFlg = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_flg", length));
			String[] invCreUsrId = (JSPUtil.getParameter(request, prefix	+ "inv_cre_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] otsStlFlg = (JSPUtil.getParameter(request, prefix	+ "ots_stl_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] ofcCurrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_curr_cd", length));
			String[] ifErrRsn = (JSPUtil.getParameter(request, prefix	+ "if_err_rsn", length));
			String[] erpIfSts = (JSPUtil.getParameter(request, prefix	+ "erp_if_sts", length));
			String[] erpIfRsn = (JSPUtil.getParameter(request, prefix	+ "erp_if_rsn", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] invCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_cre_ofc_cd", length));

			for (int i = 0; i < length; i++) {
				model = new ReceivableInvoiceInquiryVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (erpLclAmt[i] != null)
					model.setErpLclAmt(erpLclAmt[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (srcIfSeq[i] != null)
					model.setSrcIfSeq(srcIfSeq[i]);
				if (erpUsdAmt[i] != null)
					model.setErpUsdAmt(erpUsdAmt[i]);
				if (invIsuDt[i] != null)
					model.setInvIsuDt(invIsuDt[i]);
				if (invCreDt[i] != null)
					model.setInvCreDt(invCreDt[i]);
				if (blInvIfFlg[i] != null)
					model.setBlInvIfFlg(blInvIfFlg[i]);
				if (invCreUsrId[i] != null)
					model.setInvCreUsrId(invCreUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (otsStlFlg[i] != null)
					model.setOtsStlFlg(otsStlFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (ofcCurrCd[i] != null)
					model.setOfcCurrCd(ofcCurrCd[i]);
				if (ifErrRsn[i] != null)
					model.setIfErrRsn(ifErrRsn[i]);
				if (erpIfSts[i] != null)
					model.setErpIfSts(erpIfSts[i]);
				if (erpIfRsn[i] != null)
					model.setErpIfRsn(erpIfRsn[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (invCreOfcCd[i] != null)
					model.setInvCreOfcCd(invCreOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceivableInvoiceInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceivableInvoiceInquiryVO[]
	 */
	public ReceivableInvoiceInquiryVO[] getReceivableInvoiceInquiryVOs(){
		ReceivableInvoiceInquiryVO[] vos = (ReceivableInvoiceInquiryVO[])models.toArray(new ReceivableInvoiceInquiryVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpLclAmt = this.erpLclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfSeq = this.srcIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpUsdAmt = this.erpUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIsuDt = this.invIsuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreDt = this.invCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvIfFlg = this.blInvIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreUsrId = this.invCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStlFlg = this.otsStlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCurrCd = this.ofcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrRsn = this.ifErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfSts = this.erpIfSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfRsn = this.erpIfRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreOfcCd = this.invCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
