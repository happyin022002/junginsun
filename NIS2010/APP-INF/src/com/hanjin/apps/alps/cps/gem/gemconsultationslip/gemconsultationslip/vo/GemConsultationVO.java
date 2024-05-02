/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GemConsultationVO.java
*@FileTitle : GemConsultationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GemConsultationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemConsultationVO> models = new ArrayList<GemConsultationVO>();
	
	/* Column Info */
	private String expnDivCd = null;
	/* Column Info */
	private String invUsdTtlAmt = null;
	/* Column Info */
	private String subsCsrNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String invLoclAmt = null;
	/* Column Info */
	private String inpDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String gwAprorId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subsCsrSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invLoclTtlAmt = null;
	/* Column Info */
	private String invUsdAmt = null;
	/* Column Info */
	private String payVndrNm = null;
	/* Column Info */
	private String genExpnNm = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String invSlpDesc = null;
	/* Column Info */
	private String gwCsrRqstrId = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String gwAproUrlCtnt = null;
	/* Column Info */
	private String subsOfcCd = null;
	/* Column Info */
	private String gwCsrRqstId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproRsltCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GemConsultationVO() {}

	public GemConsultationVO(String ibflag, String pagerows, String subsCsrNo, String subsOfcCd, String inpDt, String invDt, String aproDt, String aproRsltCd, String gwAproUrlCtnt, String gwCsrRqstId, String gwCsrRqstrId, String gwAprorId, String payVndrNm, String invCurrCd, String invLoclTtlAmt, String invUsdTtlAmt, String expnDivCd, String subsCsrSeq, String genExpnCd, String genExpnNm, String invLoclAmt, String invUsdAmt, String invSlpDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.expnDivCd = expnDivCd;
		this.invUsdTtlAmt = invUsdTtlAmt;
		this.subsCsrNo = subsCsrNo;
		this.creDt = creDt;
		this.invLoclAmt = invLoclAmt;
		this.inpDt = inpDt;
		this.pagerows = pagerows;
		this.gwAprorId = gwAprorId;
		this.ibflag = ibflag;
		this.subsCsrSeq = subsCsrSeq;
		this.updUsrId = updUsrId;
		this.invDt = invDt;
		this.updDt = updDt;
		this.invLoclTtlAmt = invLoclTtlAmt;
		this.invUsdAmt = invUsdAmt;
		this.payVndrNm = payVndrNm;
		this.genExpnNm = genExpnNm;
		this.genExpnCd = genExpnCd;
		this.invCurrCd = invCurrCd;
		this.invSlpDesc = invSlpDesc;
		this.gwCsrRqstrId = gwCsrRqstrId;
		this.aproDt = aproDt;
		this.gwAproUrlCtnt = gwAproUrlCtnt;
		this.subsOfcCd = subsOfcCd;
		this.gwCsrRqstId = gwCsrRqstId;
		this.creUsrId = creUsrId;
		this.aproRsltCd = aproRsltCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("expn_div_cd", getExpnDivCd());
		this.hashColumns.put("inv_usd_ttl_amt", getInvUsdTtlAmt());
		this.hashColumns.put("subs_csr_no", getSubsCsrNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inv_locl_amt", getInvLoclAmt());
		this.hashColumns.put("inp_dt", getInpDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gw_apror_id", getGwAprorId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("subs_csr_seq", getSubsCsrSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_locl_ttl_amt", getInvLoclTtlAmt());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("pay_vndr_nm", getPayVndrNm());
		this.hashColumns.put("gen_expn_nm", getGenExpnNm());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("inv_slp_desc", getInvSlpDesc());
		this.hashColumns.put("gw_csr_rqstr_id", getGwCsrRqstrId());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("gw_apro_url_ctnt", getGwAproUrlCtnt());
		this.hashColumns.put("subs_ofc_cd", getSubsOfcCd());
		this.hashColumns.put("gw_csr_rqst_id", getGwCsrRqstId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_rslt_cd", getAproRsltCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("expn_div_cd", "expnDivCd");
		this.hashFields.put("inv_usd_ttl_amt", "invUsdTtlAmt");
		this.hashFields.put("subs_csr_no", "subsCsrNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_locl_amt", "invLoclAmt");
		this.hashFields.put("inp_dt", "inpDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gw_apror_id", "gwAprorId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("subs_csr_seq", "subsCsrSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_locl_ttl_amt", "invLoclTtlAmt");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("pay_vndr_nm", "payVndrNm");
		this.hashFields.put("gen_expn_nm", "genExpnNm");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_slp_desc", "invSlpDesc");
		this.hashFields.put("gw_csr_rqstr_id", "gwCsrRqstrId");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("gw_apro_url_ctnt", "gwAproUrlCtnt");
		this.hashFields.put("subs_ofc_cd", "subsOfcCd");
		this.hashFields.put("gw_csr_rqst_id", "gwCsrRqstId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_rslt_cd", "aproRsltCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return expnDivCd
	 */
	public String getExpnDivCd() {
		return this.expnDivCd;
	}
	
	/**
	 * Column Info
	 * @return invUsdTtlAmt
	 */
	public String getInvUsdTtlAmt() {
		return this.invUsdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return subsCsrNo
	 */
	public String getSubsCsrNo() {
		return this.subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return invLoclAmt
	 */
	public String getInvLoclAmt() {
		return this.invLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return inpDt
	 */
	public String getInpDt() {
		return this.inpDt;
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
	 * @return gwAprorId
	 */
	public String getGwAprorId() {
		return this.gwAprorId;
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
	 * @return subsCsrSeq
	 */
	public String getSubsCsrSeq() {
		return this.subsCsrSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return invLoclTtlAmt
	 */
	public String getInvLoclTtlAmt() {
		return this.invLoclTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return payVndrNm
	 */
	public String getPayVndrNm() {
		return this.payVndrNm;
	}
	
	/**
	 * Column Info
	 * @return genExpnNm
	 */
	public String getGenExpnNm() {
		return this.genExpnNm;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
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
	 * @return invSlpDesc
	 */
	public String getInvSlpDesc() {
		return this.invSlpDesc;
	}
	
	/**
	 * Column Info
	 * @return gwCsrRqstrId
	 */
	public String getGwCsrRqstrId() {
		return this.gwCsrRqstrId;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return gwAproUrlCtnt
	 */
	public String getGwAproUrlCtnt() {
		return this.gwAproUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @return subsOfcCd
	 */
	public String getSubsOfcCd() {
		return this.subsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return gwCsrRqstId
	 */
	public String getGwCsrRqstId() {
		return this.gwCsrRqstId;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproRsltCd
	 */
	public String getAproRsltCd() {
		return this.aproRsltCd;
	}
	

	/**
	 * Column Info
	 * @param expnDivCd
	 */
	public void setExpnDivCd(String expnDivCd) {
		this.expnDivCd = expnDivCd;
	}
	
	/**
	 * Column Info
	 * @param invUsdTtlAmt
	 */
	public void setInvUsdTtlAmt(String invUsdTtlAmt) {
		this.invUsdTtlAmt = invUsdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param subsCsrNo
	 */
	public void setSubsCsrNo(String subsCsrNo) {
		this.subsCsrNo = subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param invLoclAmt
	 */
	public void setInvLoclAmt(String invLoclAmt) {
		this.invLoclAmt = invLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param inpDt
	 */
	public void setInpDt(String inpDt) {
		this.inpDt = inpDt;
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
	 * @param gwAprorId
	 */
	public void setGwAprorId(String gwAprorId) {
		this.gwAprorId = gwAprorId;
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
	 * @param subsCsrSeq
	 */
	public void setSubsCsrSeq(String subsCsrSeq) {
		this.subsCsrSeq = subsCsrSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param invLoclTtlAmt
	 */
	public void setInvLoclTtlAmt(String invLoclTtlAmt) {
		this.invLoclTtlAmt = invLoclTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param payVndrNm
	 */
	public void setPayVndrNm(String payVndrNm) {
		this.payVndrNm = payVndrNm;
	}
	
	/**
	 * Column Info
	 * @param genExpnNm
	 */
	public void setGenExpnNm(String genExpnNm) {
		this.genExpnNm = genExpnNm;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
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
	 * @param invSlpDesc
	 */
	public void setInvSlpDesc(String invSlpDesc) {
		this.invSlpDesc = invSlpDesc;
	}
	
	/**
	 * Column Info
	 * @param gwCsrRqstrId
	 */
	public void setGwCsrRqstrId(String gwCsrRqstrId) {
		this.gwCsrRqstrId = gwCsrRqstrId;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param gwAproUrlCtnt
	 */
	public void setGwAproUrlCtnt(String gwAproUrlCtnt) {
		this.gwAproUrlCtnt = gwAproUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @param subsOfcCd
	 */
	public void setSubsOfcCd(String subsOfcCd) {
		this.subsOfcCd = subsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param gwCsrRqstId
	 */
	public void setGwCsrRqstId(String gwCsrRqstId) {
		this.gwCsrRqstId = gwCsrRqstId;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproRsltCd
	 */
	public void setAproRsltCd(String aproRsltCd) {
		this.aproRsltCd = aproRsltCd;
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
		setExpnDivCd(JSPUtil.getParameter(request, prefix + "expn_div_cd", ""));
		setInvUsdTtlAmt(JSPUtil.getParameter(request, prefix + "inv_usd_ttl_amt", ""));
		setSubsCsrNo(JSPUtil.getParameter(request, prefix + "subs_csr_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInvLoclAmt(JSPUtil.getParameter(request, prefix + "inv_locl_amt", ""));
		setInpDt(JSPUtil.getParameter(request, prefix + "inp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGwAprorId(JSPUtil.getParameter(request, prefix + "gw_apror_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubsCsrSeq(JSPUtil.getParameter(request, prefix + "subs_csr_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInvLoclTtlAmt(JSPUtil.getParameter(request, prefix + "inv_locl_ttl_amt", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setPayVndrNm(JSPUtil.getParameter(request, prefix + "pay_vndr_nm", ""));
		setGenExpnNm(JSPUtil.getParameter(request, prefix + "gen_expn_nm", ""));
		setGenExpnCd(JSPUtil.getParameter(request, prefix + "gen_expn_cd", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setInvSlpDesc(JSPUtil.getParameter(request, prefix + "inv_slp_desc", ""));
		setGwCsrRqstrId(JSPUtil.getParameter(request, prefix + "gw_csr_rqstr_id", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setGwAproUrlCtnt(JSPUtil.getParameter(request, prefix + "gw_apro_url_ctnt", ""));
		setSubsOfcCd(JSPUtil.getParameter(request, prefix + "subs_ofc_cd", ""));
		setGwCsrRqstId(JSPUtil.getParameter(request, prefix + "gw_csr_rqst_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAproRsltCd(JSPUtil.getParameter(request, prefix + "apro_rslt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemConsultationVO[]
	 */
	public GemConsultationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemConsultationVO[]
	 */
	public GemConsultationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemConsultationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] expnDivCd = (JSPUtil.getParameter(request, prefix	+ "expn_div_cd", length));
			String[] invUsdTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_ttl_amt", length));
			String[] subsCsrNo = (JSPUtil.getParameter(request, prefix	+ "subs_csr_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] invLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_locl_amt", length));
			String[] inpDt = (JSPUtil.getParameter(request, prefix	+ "inp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] gwAprorId = (JSPUtil.getParameter(request, prefix	+ "gw_apror_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subsCsrSeq = (JSPUtil.getParameter(request, prefix	+ "subs_csr_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invLoclTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_locl_ttl_amt", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] payVndrNm = (JSPUtil.getParameter(request, prefix	+ "pay_vndr_nm", length));
			String[] genExpnNm = (JSPUtil.getParameter(request, prefix	+ "gen_expn_nm", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] invSlpDesc = (JSPUtil.getParameter(request, prefix	+ "inv_slp_desc", length));
			String[] gwCsrRqstrId = (JSPUtil.getParameter(request, prefix	+ "gw_csr_rqstr_id", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] gwAproUrlCtnt = (JSPUtil.getParameter(request, prefix	+ "gw_apro_url_ctnt", length));
			String[] subsOfcCd = (JSPUtil.getParameter(request, prefix	+ "subs_ofc_cd", length));
			String[] gwCsrRqstId = (JSPUtil.getParameter(request, prefix	+ "gw_csr_rqst_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproRsltCd = (JSPUtil.getParameter(request, prefix	+ "apro_rslt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemConsultationVO();
				if (expnDivCd[i] != null)
					model.setExpnDivCd(expnDivCd[i]);
				if (invUsdTtlAmt[i] != null)
					model.setInvUsdTtlAmt(invUsdTtlAmt[i]);
				if (subsCsrNo[i] != null)
					model.setSubsCsrNo(subsCsrNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (invLoclAmt[i] != null)
					model.setInvLoclAmt(invLoclAmt[i]);
				if (inpDt[i] != null)
					model.setInpDt(inpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (gwAprorId[i] != null)
					model.setGwAprorId(gwAprorId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subsCsrSeq[i] != null)
					model.setSubsCsrSeq(subsCsrSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invLoclTtlAmt[i] != null)
					model.setInvLoclTtlAmt(invLoclTtlAmt[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (payVndrNm[i] != null)
					model.setPayVndrNm(payVndrNm[i]);
				if (genExpnNm[i] != null)
					model.setGenExpnNm(genExpnNm[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (invSlpDesc[i] != null)
					model.setInvSlpDesc(invSlpDesc[i]);
				if (gwCsrRqstrId[i] != null)
					model.setGwCsrRqstrId(gwCsrRqstrId[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (gwAproUrlCtnt[i] != null)
					model.setGwAproUrlCtnt(gwAproUrlCtnt[i]);
				if (subsOfcCd[i] != null)
					model.setSubsOfcCd(subsOfcCd[i]);
				if (gwCsrRqstId[i] != null)
					model.setGwCsrRqstId(gwCsrRqstId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproRsltCd[i] != null)
					model.setAproRsltCd(aproRsltCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemConsultationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemConsultationVO[]
	 */
	public GemConsultationVO[] getGemConsultationVOs(){
		GemConsultationVO[] vos = (GemConsultationVO[])models.toArray(new GemConsultationVO[models.size()]);
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
		this.expnDivCd = this.expnDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdTtlAmt = this.invUsdTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrNo = this.subsCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclAmt = this.invLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDt = this.inpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAprorId = this.gwAprorId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrSeq = this.subsCsrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclTtlAmt = this.invLoclTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payVndrNm = this.payVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnNm = this.genExpnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSlpDesc = this.invSlpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwCsrRqstrId = this.gwCsrRqstrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAproUrlCtnt = this.gwAproUrlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsOfcCd = this.subsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwCsrRqstId = this.gwCsrRqstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRsltCd = this.aproRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
