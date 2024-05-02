/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OTRCommAuditVO.java
*@FileTitle : OTRCommAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2013.07.15 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OTRCommAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OTRCommAuditVO> models = new ArrayList<OTRCommAuditVO>();
	
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String audNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String payIfAmt = null;
	/* Column Info */
	private String acStsCd = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String otrCommRmk = null;
	/* Column Info */
	private String payXchRt = null;
	/* Column Info */
	private String commStndCostCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String commYrmon = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String otrCommNo = null;
	/* Column Info */
	private String acSeq = null;
	/* Column Info */
	private String acProcDesc = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String acOccrInfoCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String aplyDt = null;
	/* Column Info */
	private String apCtrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OTRCommAuditVO() {}

	public OTRCommAuditVO(String ibflag, String pagerows, String vndrCntCd, String audNo, String csrNo, String usrId, String bkgNo, String currCd, String vndrLglEngNm, String agnCd, String payIfAmt, String acStsCd, String acTpCd, String otrCommRmk, String payXchRt, String commStndCostCd, String commYrmon, String ioBndCd, String aproDt, String arOfcCd, String vvd, String otrCommNo, String acSeq, String acProcDesc, String acOccrInfoCd, String vndrSeq, String ifAmt, String aplyDt, String apCtrCd) {
		this.vndrCntCd = vndrCntCd;
		this.currCd = currCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.audNo = audNo;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.payIfAmt = payIfAmt;
		this.acStsCd = acStsCd;
		this.acTpCd = acTpCd;
		this.otrCommRmk = otrCommRmk;
		this.payXchRt = payXchRt;
		this.commStndCostCd = commStndCostCd;
		this.csrNo = csrNo;
		this.commYrmon = commYrmon;
		this.ioBndCd = ioBndCd;
		this.aproDt = aproDt;
		this.arOfcCd = arOfcCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.otrCommNo = otrCommNo;
		this.acSeq = acSeq;
		this.acProcDesc = acProcDesc;
		this.vndrSeq = vndrSeq;
		this.acOccrInfoCd = acOccrInfoCd;
		this.ifAmt = ifAmt;
		this.aplyDt = aplyDt;
		this.apCtrCd = apCtrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("aud_no", getAudNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pay_if_amt", getPayIfAmt());
		this.hashColumns.put("ac_sts_cd", getAcStsCd());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("otr_comm_rmk", getOtrCommRmk());
		this.hashColumns.put("pay_xch_rt", getPayXchRt());
		this.hashColumns.put("comm_stnd_cost_cd", getCommStndCostCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("comm_yrmon", getCommYrmon());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("otr_comm_no", getOtrCommNo());
		this.hashColumns.put("ac_seq", getAcSeq());
		this.hashColumns.put("ac_proc_desc", getAcProcDesc());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ac_occr_info_cd", getAcOccrInfoCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("aply_dt", getAplyDt());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("aud_no", "audNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pay_if_amt", "payIfAmt");
		this.hashFields.put("ac_sts_cd", "acStsCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("otr_comm_rmk", "otrCommRmk");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("comm_stnd_cost_cd", "commStndCostCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("comm_yrmon", "commYrmon");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("otr_comm_no", "otrCommNo");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("ac_proc_desc", "acProcDesc");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ac_occr_info_cd", "acOccrInfoCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("aply_dt", "aplyDt");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return audNo
	 */
	public String getAudNo() {
		return this.audNo;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return payIfAmt
	 */
	public String getPayIfAmt() {
		return this.payIfAmt;
	}
	
	/**
	 * Column Info
	 * @return acStsCd
	 */
	public String getAcStsCd() {
		return this.acStsCd;
	}
	
	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}
	
	/**
	 * Column Info
	 * @return otrCommRmk
	 */
	public String getOtrCommRmk() {
		return this.otrCommRmk;
	}
	
	/**
	 * Column Info
	 * @return payXchRt
	 */
	public String getPayXchRt() {
		return this.payXchRt;
	}
	
	/**
	 * Column Info
	 * @return commStndCostCd
	 */
	public String getCommStndCostCd() {
		return this.commStndCostCd;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return commYrmon
	 */
	public String getCommYrmon() {
		return this.commYrmon;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return otrCommNo
	 */
	public String getOtrCommNo() {
		return this.otrCommNo;
	}
	
	/**
	 * Column Info
	 * @return acSeq
	 */
	public String getAcSeq() {
		return this.acSeq;
	}
	
	/**
	 * Column Info
	 * @return acProcDesc
	 */
	public String getAcProcDesc() {
		return this.acProcDesc;
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
	 * @return acOccrInfoCd
	 */
	public String getAcOccrInfoCd() {
		return this.acOccrInfoCd;
	}
	
	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}
	
	/**
	 * Column Info
	 * @return aplyDt
	 */
	public String getAplyDt() {
		return this.aplyDt;
	}
	
	/**
	 * Column Info
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
	}
	

	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param audNo
	 */
	public void setAudNo(String audNo) {
		this.audNo = audNo;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param payIfAmt
	 */
	public void setPayIfAmt(String payIfAmt) {
		this.payIfAmt = payIfAmt;
	}
	
	/**
	 * Column Info
	 * @param acStsCd
	 */
	public void setAcStsCd(String acStsCd) {
		this.acStsCd = acStsCd;
	}
	
	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
	}
	
	/**
	 * Column Info
	 * @param otrCommRmk
	 */
	public void setOtrCommRmk(String otrCommRmk) {
		this.otrCommRmk = otrCommRmk;
	}
	
	/**
	 * Column Info
	 * @param payXchRt
	 */
	public void setPayXchRt(String payXchRt) {
		this.payXchRt = payXchRt;
	}
	
	/**
	 * Column Info
	 * @param commStndCostCd
	 */
	public void setCommStndCostCd(String commStndCostCd) {
		this.commStndCostCd = commStndCostCd;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param commYrmon
	 */
	public void setCommYrmon(String commYrmon) {
		this.commYrmon = commYrmon;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param otrCommNo
	 */
	public void setOtrCommNo(String otrCommNo) {
		this.otrCommNo = otrCommNo;
	}
	
	/**
	 * Column Info
	 * @param acSeq
	 */
	public void setAcSeq(String acSeq) {
		this.acSeq = acSeq;
	}
	
	/**
	 * Column Info
	 * @param acProcDesc
	 */
	public void setAcProcDesc(String acProcDesc) {
		this.acProcDesc = acProcDesc;
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
	 * @param acOccrInfoCd
	 */
	public void setAcOccrInfoCd(String acOccrInfoCd) {
		this.acOccrInfoCd = acOccrInfoCd;
	}
	
	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param aplyDt
	 */
	public void setAplyDt(String aplyDt) {
		this.aplyDt = aplyDt;
	}
	
	/**
	 * Column Info
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
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
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setAudNo(JSPUtil.getParameter(request, prefix + "aud_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPayIfAmt(JSPUtil.getParameter(request, prefix + "pay_if_amt", ""));
		setAcStsCd(JSPUtil.getParameter(request, prefix + "ac_sts_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
		setOtrCommRmk(JSPUtil.getParameter(request, prefix + "otr_comm_rmk", ""));
		setPayXchRt(JSPUtil.getParameter(request, prefix + "pay_xch_rt", ""));
		setCommStndCostCd(JSPUtil.getParameter(request, prefix + "comm_stnd_cost_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setCommYrmon(JSPUtil.getParameter(request, prefix + "comm_yrmon", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOtrCommNo(JSPUtil.getParameter(request, prefix + "otr_comm_no", ""));
		setAcSeq(JSPUtil.getParameter(request, prefix + "ac_seq", ""));
		setAcProcDesc(JSPUtil.getParameter(request, prefix + "ac_proc_desc", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setAcOccrInfoCd(JSPUtil.getParameter(request, prefix + "ac_occr_info_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setAplyDt(JSPUtil.getParameter(request, prefix + "aply_dt", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OTRCommAuditVO[]
	 */
	public OTRCommAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OTRCommAuditVO[]
	 */
	public OTRCommAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OTRCommAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] audNo = (JSPUtil.getParameter(request, prefix	+ "aud_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] payIfAmt = (JSPUtil.getParameter(request, prefix	+ "pay_if_amt", length));
			String[] acStsCd = (JSPUtil.getParameter(request, prefix	+ "ac_sts_cd", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] otrCommRmk = (JSPUtil.getParameter(request, prefix	+ "otr_comm_rmk", length));
			String[] payXchRt = (JSPUtil.getParameter(request, prefix	+ "pay_xch_rt", length));
			String[] commStndCostCd = (JSPUtil.getParameter(request, prefix	+ "comm_stnd_cost_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] commYrmon = (JSPUtil.getParameter(request, prefix	+ "comm_yrmon", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] otrCommNo = (JSPUtil.getParameter(request, prefix	+ "otr_comm_no", length));
			String[] acSeq = (JSPUtil.getParameter(request, prefix	+ "ac_seq", length));
			String[] acProcDesc = (JSPUtil.getParameter(request, prefix	+ "ac_proc_desc", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] acOccrInfoCd = (JSPUtil.getParameter(request, prefix	+ "ac_occr_info_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] aplyDt = (JSPUtil.getParameter(request, prefix	+ "aply_dt", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OTRCommAuditVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (audNo[i] != null)
					model.setAudNo(audNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (payIfAmt[i] != null)
					model.setPayIfAmt(payIfAmt[i]);
				if (acStsCd[i] != null)
					model.setAcStsCd(acStsCd[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (otrCommRmk[i] != null)
					model.setOtrCommRmk(otrCommRmk[i]);
				if (payXchRt[i] != null)
					model.setPayXchRt(payXchRt[i]);
				if (commStndCostCd[i] != null)
					model.setCommStndCostCd(commStndCostCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (commYrmon[i] != null)
					model.setCommYrmon(commYrmon[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (otrCommNo[i] != null)
					model.setOtrCommNo(otrCommNo[i]);
				if (acSeq[i] != null)
					model.setAcSeq(acSeq[i]);
				if (acProcDesc[i] != null)
					model.setAcProcDesc(acProcDesc[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (acOccrInfoCd[i] != null)
					model.setAcOccrInfoCd(acOccrInfoCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (aplyDt[i] != null)
					model.setAplyDt(aplyDt[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOTRCommAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OTRCommAuditVO[]
	 */
	public OTRCommAuditVO[] getOTRCommAuditVOs(){
		OTRCommAuditVO[] vos = (OTRCommAuditVO[])models.toArray(new OTRCommAuditVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audNo = this.audNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payIfAmt = this.payIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acStsCd = this.acStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCommRmk = this.otrCommRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt = this.payXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commStndCostCd = this.commStndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commYrmon = this.commYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCommNo = this.otrCommNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq = this.acSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acProcDesc = this.acProcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acOccrInfoCd = this.acOccrInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyDt = this.aplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
