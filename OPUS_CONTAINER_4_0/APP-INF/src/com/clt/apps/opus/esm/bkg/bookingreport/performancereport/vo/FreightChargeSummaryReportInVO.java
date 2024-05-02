/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FreightChargeSummaryReportInVO.java
*@FileTitle : FreightChargeSummaryReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.27 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FreightChargeSummaryReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FreightChargeSummaryReportInVO> models = new ArrayList<FreightChargeSummaryReportInVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String chgNm = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String sortingPriority = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String chgRevTpCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String frtChgTpCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String per = null;
	/* Column Info */
	private String perGroup = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String bratePrepaid = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FreightChargeSummaryReportInVO() {}

	public FreightChargeSummaryReportInVO(String ibflag, String pagerows, String frtChgTpCd, String perGroup, String per, String chgCd, String bratePrepaid, String chgNm, String sortingPriority, String bkgNo, String blNo, String slanCd, String porCd, String delCd, String vvdCd, String polCd, String podCd, String bkgOfcCd, String obSlsOfcCd, String custTpCd, String custCntCd, String custSeq, String dcgoFlg, String rdCgoFlg, String awkCgoFlg, String bbCgoFlg, String rcFlg, String ratUtCd, String repCmdtCd, String cmdtCd, String cntrTpszCd, String chgRevTpCd, String preRlyPortCd, String pstRlyPortCd) {
		this.porCd = porCd;
		this.chgNm = chgNm;
		this.rdCgoFlg = rdCgoFlg;
		this.sortingPriority = sortingPriority;
		this.blNo = blNo;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.cmdtCd = cmdtCd;
		this.bbCgoFlg = bbCgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.chgRevTpCd = chgRevTpCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.custTpCd = custTpCd;
		this.custCntCd = custCntCd;
		this.bkgOfcCd = bkgOfcCd;
		this.preRlyPortCd = preRlyPortCd;
		this.frtChgTpCd = frtChgTpCd;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.ratUtCd = ratUtCd;
		this.custSeq = custSeq;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.per = per;
		this.perGroup = perGroup;
		this.rcFlg = rcFlg;
		this.pstRlyPortCd = pstRlyPortCd;
		this.repCmdtCd = repCmdtCd;
		this.bratePrepaid = bratePrepaid;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("sorting_priority", getSortingPriority());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("chg_rev_tp_cd", getChgRevTpCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("frt_chg_tp_cd", getFrtChgTpCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("per", getPer());
		this.hashColumns.put("per_group", getPerGroup());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("brate_prepaid", getBratePrepaid());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("sorting_priority", "sortingPriority");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("chg_rev_tp_cd", "chgRevTpCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("frt_chg_tp_cd", "frtChgTpCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("per", "per");
		this.hashFields.put("per_group", "perGroup");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("brate_prepaid", "bratePrepaid");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return chgNm
	 */
	public String getChgNm() {
		return this.chgNm;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return sortingPriority
	 */
	public String getSortingPriority() {
		return this.sortingPriority;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return chgRevTpCd
	 */
	public String getChgRevTpCd() {
		return this.chgRevTpCd;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return frtChgTpCd
	 */
	public String getFrtChgTpCd() {
		return this.frtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return per
	 */
	public String getPer() {
		return this.per;
	}
	
	/**
	 * Column Info
	 * @return perGroup
	 */
	public String getPerGroup() {
		return this.perGroup;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bratePrepaid
	 */
	public String getBratePrepaid() {
		return this.bratePrepaid;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param chgNm
	 */
	public void setChgNm(String chgNm) {
		this.chgNm = chgNm;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param sortingPriority
	 */
	public void setSortingPriority(String sortingPriority) {
		this.sortingPriority = sortingPriority;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param chgRevTpCd
	 */
	public void setChgRevTpCd(String chgRevTpCd) {
		this.chgRevTpCd = chgRevTpCd;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param frtChgTpCd
	 */
	public void setFrtChgTpCd(String frtChgTpCd) {
		this.frtChgTpCd = frtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param per
	 */
	public void setPer(String per) {
		this.per = per;
	}
	
	/**
	 * Column Info
	 * @param perGroup
	 */
	public void setPerGroup(String perGroup) {
		this.perGroup = perGroup;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bratePrepaid
	 */
	public void setBratePrepaid(String bratePrepaid) {
		this.bratePrepaid = bratePrepaid;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setChgNm(JSPUtil.getParameter(request, "chg_nm", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setSortingPriority(JSPUtil.getParameter(request, "sorting_priority", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setChgRevTpCd(JSPUtil.getParameter(request, "chg_rev_tp_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setFrtChgTpCd(JSPUtil.getParameter(request, "frt_chg_tp_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setPer(JSPUtil.getParameter(request, "per", ""));
		setPerGroup(JSPUtil.getParameter(request, "per_group", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setBratePrepaid(JSPUtil.getParameter(request, "brate_prepaid", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FreightChargeSummaryReportInVO[]
	 */
	public FreightChargeSummaryReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FreightChargeSummaryReportInVO[]
	 */
	public FreightChargeSummaryReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FreightChargeSummaryReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] sortingPriority = (JSPUtil.getParameter(request, prefix	+ "sorting_priority", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] chgRevTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_rev_tp_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] frtChgTpCd = (JSPUtil.getParameter(request, prefix	+ "frt_chg_tp_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] per = (JSPUtil.getParameter(request, prefix	+ "per", length));
			String[] perGroup = (JSPUtil.getParameter(request, prefix	+ "per_group", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] bratePrepaid = (JSPUtil.getParameter(request, prefix	+ "brate_prepaid", length));
			
			for (int i = 0; i < length; i++) {
				model = new FreightChargeSummaryReportInVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (sortingPriority[i] != null)
					model.setSortingPriority(sortingPriority[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (chgRevTpCd[i] != null)
					model.setChgRevTpCd(chgRevTpCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (frtChgTpCd[i] != null)
					model.setFrtChgTpCd(frtChgTpCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (per[i] != null)
					model.setPer(per[i]);
				if (perGroup[i] != null)
					model.setPerGroup(perGroup[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (bratePrepaid[i] != null)
					model.setBratePrepaid(bratePrepaid[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFreightChargeSummaryReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FreightChargeSummaryReportInVO[]
	 */
	public FreightChargeSummaryReportInVO[] getFreightChargeSummaryReportInVOs(){
		FreightChargeSummaryReportInVO[] vos = (FreightChargeSummaryReportInVO[])models.toArray(new FreightChargeSummaryReportInVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortingPriority = this.sortingPriority .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRevTpCd = this.chgRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChgTpCd = this.frtChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.per = this.per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perGroup = this.perGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bratePrepaid = this.bratePrepaid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
