/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceVO.java
*@FileTitle : GeneralInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.26 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo;

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
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GeneralInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GeneralInvoiceVO> models = new ArrayList<GeneralInvoiceVO>();
	
	/* Column Info */
	private String scp = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String totInvCnt = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String chkVvd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String fromInvNo = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chkCust = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String copyCnt = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String bnd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String arOfcCd2 = null;
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String dtOption = null;
	/* Column Info */
	private String chkUserid = null;
	/* Column Info */
	private String chkBlno = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String toInvNo = null;
	/* Column Info */
	private String chkAll = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String ifUserId = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String invDupFlg = null;
	/* Column Info */
	private String invMltBlIssFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GeneralInvoiceVO() {}

	public GeneralInvoiceVO(String ibflag, String pagerows, String arOfcCd2, String blNos, String chkVvd, String chkCust, String chkBlno, String chkUserid, String chkAll, String svrId, String ifUserId, String otsSmryCd, String invDupFlg, String invMltBlIssFlg, String bnd, String dtOption, String fromDt, String toDt, String vvd, String scp, String port, String custCntCd, String custSeq, String custNm, String custRgstNo, String crCurrCd, String crAmt, String phnNo, String faxNo, String cntcPsonNm, String fromInvNo, String toInvNo, String totInvCnt, String copyCnt) {
		this.scp = scp;
		this.port = port;
		this.totInvCnt = totInvCnt;
		this.fromDt = fromDt;
		this.chkVvd = chkVvd;
		this.custNm = custNm;
		this.fromInvNo = fromInvNo;
		this.custRgstNo = custRgstNo;
		this.pagerows = pagerows;
		this.chkCust = chkCust;
		this.ibflag = ibflag;
		this.copyCnt = copyCnt;
		this.blNos = blNos;
		this.crAmt = crAmt;
		this.cntcPsonNm = cntcPsonNm;
		this.custCntCd = custCntCd;
		this.phnNo = phnNo;
		this.bnd = bnd;
		this.custSeq = custSeq;
		this.arOfcCd2 = arOfcCd2;
		this.crCurrCd = crCurrCd;
		this.toDt = toDt;
		this.vvd = vvd;
		this.dtOption = dtOption;
		this.chkUserid = chkUserid;
		this.chkBlno = chkBlno;
		this.faxNo = faxNo;
		this.toInvNo = toInvNo;
		this.chkAll = chkAll;
		this.svrId = svrId;
		this.ifUserId = ifUserId;
		this.otsSmryCd = otsSmryCd;
		this.invDupFlg = invDupFlg;
		this.invMltBlIssFlg = invMltBlIssFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scp", getScp());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("tot_inv_cnt", getTotInvCnt());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("chk_vvd", getChkVvd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("from_inv_no", getFromInvNo());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chk_cust", getChkCust());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("copy_cnt", getCopyCnt());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("bnd", getBnd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ar_ofc_cd2", getArOfcCd2());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("dt_option", getDtOption());
		this.hashColumns.put("chk_userid", getChkUserid());
		this.hashColumns.put("chk_blno", getChkBlno());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("chk_all", getChkAll());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("if_user_id", getIfUserId());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("inv_dup_flg", getInvDupFlg());
		this.hashColumns.put("inv_mlt_bl_iss_flg", getInvMltBlIssFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scp", "scp");
		this.hashFields.put("port", "port");
		this.hashFields.put("tot_inv_cnt", "totInvCnt");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("chk_vvd", "chkVvd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("from_inv_no", "fromInvNo");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chk_cust", "chkCust");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("copy_cnt", "copyCnt");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ar_ofc_cd2", "arOfcCd2");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("dt_option", "dtOption");
		this.hashFields.put("chk_userid", "chkUserid");
		this.hashFields.put("chk_blno", "chkBlno");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("chk_all", "chkAll");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("if_user_id", "ifUserId");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("inv_dup_flg", "invDupFlg");
		this.hashFields.put("inv_mlt_bl_iss_flg", "invMltBlIssFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scp
	 */
	public String getScp() {
		return this.scp;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return totInvCnt
	 */
	public String getTotInvCnt() {
		return this.totInvCnt;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return chkVvd
	 */
	public String getChkVvd() {
		return this.chkVvd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return fromInvNo
	 */
	public String getFromInvNo() {
		return this.fromInvNo;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
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
	 * @return chkCust
	 */
	public String getChkCust() {
		return this.chkCust;
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
	 * @return copyCnt
	 */
	public String getCopyCnt() {
		return this.copyCnt;
	}
	
	/**
	 * Column Info
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
	}
	
	/**
	 * Column Info
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return bnd
	 */
	public String getBnd() {
		return this.bnd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd2
	 */
	public String getArOfcCd2() {
		return this.arOfcCd2;
	}
	
	/**
	 * Column Info
	 * @return crCurrCd
	 */
	public String getCrCurrCd() {
		return this.crCurrCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return dtOption
	 */
	public String getDtOption() {
		return this.dtOption;
	}
	
	/**
	 * Column Info
	 * @return chkUserid
	 */
	public String getChkUserid() {
		return this.chkUserid;
	}
	
	/**
	 * Column Info
	 * @return chkBlno
	 */
	public String getChkBlno() {
		return this.chkBlno;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return toInvNo
	 */
	public String getToInvNo() {
		return this.toInvNo;
	}
	
	/**
	 * Column Info
	 * @return chkAll
	 */
	public String getChkAll() {
		return this.chkAll;
	}
	

	/**
	 * Column Info
	 * @param scp
	 */
	public void setScp(String scp) {
		this.scp = scp;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param totInvCnt
	 */
	public void setTotInvCnt(String totInvCnt) {
		this.totInvCnt = totInvCnt;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param chkVvd
	 */
	public void setChkVvd(String chkVvd) {
		this.chkVvd = chkVvd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param fromInvNo
	 */
	public void setFromInvNo(String fromInvNo) {
		this.fromInvNo = fromInvNo;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
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
	 * @param chkCust
	 */
	public void setChkCust(String chkCust) {
		this.chkCust = chkCust;
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
	 * @param copyCnt
	 */
	public void setCopyCnt(String copyCnt) {
		this.copyCnt = copyCnt;
	}
	
	/**
	 * Column Info
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
	}
	
	/**
	 * Column Info
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param bnd
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd2
	 */
	public void setArOfcCd2(String arOfcCd2) {
		this.arOfcCd2 = arOfcCd2;
	}
	
	/**
	 * Column Info
	 * @param crCurrCd
	 */
	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param dtOption
	 */
	public void setDtOption(String dtOption) {
		this.dtOption = dtOption;
	}
	
	/**
	 * Column Info
	 * @param chkUserid
	 */
	public void setChkUserid(String chkUserid) {
		this.chkUserid = chkUserid;
	}
	
	/**
	 * Column Info
	 * @param chkBlno
	 */
	public void setChkBlno(String chkBlno) {
		this.chkBlno = chkBlno;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param toInvNo
	 */
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}
	
	/**
	 * Column Info
	 * @param chkAll
	 */
	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
	}
	
	/**
	 * @return the svrId
	 */
	public String getSvrId() {
		return svrId;
	}

	/**
	 * @param svrId the svrId to set
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}

	/**
	 * @return the ifUserId
	 */
	public String getIfUserId() {
		return ifUserId;
	}

	/**
	 * @param ifUserId the ifUserId to set
	 */
	public void setIfUserId(String ifUserId) {
		this.ifUserId = ifUserId;
	}
	
	/**
	 * @return the otsSmryCd
	 */
	public String getOtsSmryCd() {
		return otsSmryCd;
	}

	/**
	 * @param otsSmryCd the otsSmryCd to set
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}

	/**
	 * @return the invDupFlg
	 */
	public String getInvDupFlg() {
		return invDupFlg;
	}

	/**
	 * @param invDupFlg the invDupFlg to set
	 */
	public void setInvDupFlg(String invDupFlg) {
		this.invDupFlg = invDupFlg;
	}

	/**
	 * @return the invMltBlIssFlg
	 */
	public String getInvMltBlIssFlg() {
		return invMltBlIssFlg;
	}

	/**
	 * @param invMltBlIssFlg the invMltBlIssFlg to set
	 */
	public void setInvMltBlIssFlg(String invMltBlIssFlg) {
		this.invMltBlIssFlg = invMltBlIssFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScp(JSPUtil.getParameter(request, "scp", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setTotInvCnt(JSPUtil.getParameter(request, "tot_inv_cnt", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setChkVvd(JSPUtil.getParameter(request, "chk_vvd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setFromInvNo(JSPUtil.getParameter(request, "from_inv_no", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChkCust(JSPUtil.getParameter(request, "chk_cust", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCopyCnt(JSPUtil.getParameter(request, "copy_cnt", ""));
		setBlNos(JSPUtil.getParameter(request, "bl_nos", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setBnd(JSPUtil.getParameter(request, "bnd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setArOfcCd2(JSPUtil.getParameter(request, "ar_ofc_cd2", ""));
		setCrCurrCd(JSPUtil.getParameter(request, "cr_curr_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setDtOption(JSPUtil.getParameter(request, "dt_option", ""));
		setChkUserid(JSPUtil.getParameter(request, "chk_userid", ""));
		setChkBlno(JSPUtil.getParameter(request, "chk_blno", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
		setChkAll(JSPUtil.getParameter(request, "chk_all", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIfUserId(JSPUtil.getParameter(request, "if_user_id", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, "ots_smry_cd", ""));
		setInvDupFlg(JSPUtil.getParameter(request, "inv_dup_flg", ""));
		setInvMltBlIssFlg(JSPUtil.getParameter(request, "inv_mlt_bl_iss_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GeneralInvoiceVO[]
	 */
	public GeneralInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GeneralInvoiceVO[]
	 */
	public GeneralInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GeneralInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scp = (JSPUtil.getParameter(request, prefix	+ "scp".trim(), length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port".trim(), length));
			String[] totInvCnt = (JSPUtil.getParameter(request, prefix	+ "tot_inv_cnt".trim(), length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt".trim(), length));
			String[] chkVvd = (JSPUtil.getParameter(request, prefix	+ "chk_vvd".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] fromInvNo = (JSPUtil.getParameter(request, prefix	+ "from_inv_no".trim(), length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] chkCust = (JSPUtil.getParameter(request, prefix	+ "chk_cust".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] copyCnt = (JSPUtil.getParameter(request, prefix	+ "copy_cnt".trim(), length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos".trim(), length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt".trim(), length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no".trim(), length));
			String[] bnd = (JSPUtil.getParameter(request, prefix	+ "bnd".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] arOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd2".trim(), length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd".trim(), length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] dtOption = (JSPUtil.getParameter(request, prefix	+ "dt_option".trim(), length));
			String[] chkUserid = (JSPUtil.getParameter(request, prefix	+ "chk_userid".trim(), length));
			String[] chkBlno = (JSPUtil.getParameter(request, prefix	+ "chk_blno".trim(), length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no".trim(), length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no".trim(), length));
			String[] chkAll = (JSPUtil.getParameter(request, prefix	+ "chk_all".trim(), length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id".trim(), length));
			String[] ifUserId = (JSPUtil.getParameter(request, prefix	+ "if_user_id".trim(), length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd".trim(), length));
			String[] invDupFlg = (JSPUtil.getParameter(request, prefix	+ "inv_dup_flg".trim(), length));
			String[] invMltBlIssFlg = (JSPUtil.getParameter(request, prefix	+ "inv_mlt_bl_iss_flg".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new GeneralInvoiceVO();
				if (scp[i] != null)
					model.setScp(scp[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (totInvCnt[i] != null)
					model.setTotInvCnt(totInvCnt[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (chkVvd[i] != null)
					model.setChkVvd(chkVvd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (fromInvNo[i] != null)
					model.setFromInvNo(fromInvNo[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chkCust[i] != null)
					model.setChkCust(chkCust[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (copyCnt[i] != null)
					model.setCopyCnt(copyCnt[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (bnd[i] != null)
					model.setBnd(bnd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (arOfcCd2[i] != null)
					model.setArOfcCd2(arOfcCd2[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (dtOption[i] != null)
					model.setDtOption(dtOption[i]);
				if (chkUserid[i] != null)
					model.setChkUserid(chkUserid[i]);
				if (chkBlno[i] != null)
					model.setChkBlno(chkBlno[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (chkAll[i] != null)
					model.setChkAll(chkAll[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ifUserId[i] != null)
					model.setIfUserId(ifUserId[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (invDupFlg[i] != null)
					model.setInvDupFlg(invDupFlg[i]);
				if (invMltBlIssFlg[i] != null)
					model.setInvMltBlIssFlg(invMltBlIssFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGeneralInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GeneralInvoiceVO[]
	 */
	public GeneralInvoiceVO[] getGeneralInvoiceVOs(){
		GeneralInvoiceVO[] vos = (GeneralInvoiceVO[])models.toArray(new GeneralInvoiceVO[models.size()]);
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
		this.scp = this.scp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totInvCnt = this.totInvCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkVvd = this.chkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromInvNo = this.fromInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCust = this.chkCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyCnt = this.copyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd = this.bnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd2 = this.arOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtOption = this.dtOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkUserid = this.chkUserid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBlno = this.chkBlno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkAll = this.chkAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUserId = this.ifUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDupFlg = this.invDupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMltBlIssFlg = this.invMltBlIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
