/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltRtListVerticalExcelForIHCVO.java
*@FileTitle : RsltRtListVerticalExcelForIHCVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.30
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.07.30 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo;

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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtListVerticalExcelForIHCVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtListVerticalExcelForIHCVO> models = new ArrayList<RsltRtListVerticalExcelForIHCVO>();
	
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String ficQttnRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgPrcTrspModNm = null;
	/* Column Info */
	private String qttnBofAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ficGlineUpdDt = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String qttnRtAmt = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String ficGlineRtAmt = null;
	/* Column Info */
	private String ficRoutCmbTpCd = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String destPrcTrspModNm = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String orgRcvDeTermNm = null;
	/* Column Info */
	private String destRcvDeTermNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtListVerticalExcelForIHCVO() {}

	public RsltRtListVerticalExcelForIHCVO(String ibflag, String pagerows, String cmdtDpSeq, String routDpSeq, String prcCmdtDefCd, String prcCmdtDefNm, String orgRoutPntLocDefCd, String orgRoutPntLocDefNm, String orgRcvDeTermNm, String orgPrcTrspModNm, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String destRoutPntLocDefNm, String destRcvDeTermNm, String destPrcTrspModNm, String ratUtCd, String prcCgoTpCd, String currCd, String qttnRtAmt, String ficGlineRtAmt, String ficQttnRtAmt, String ficRtUseStsCd, String ficGlineUpdDt, String qttnBofAmt, String bsePortLocCd, String ficRoutCmbTpCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.ficQttnRtAmt = ficQttnRtAmt;
		this.pagerows = pagerows;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.qttnBofAmt = qttnBofAmt;
		this.ibflag = ibflag;
		this.ficGlineUpdDt = ficGlineUpdDt;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.qttnRtAmt = qttnRtAmt;
		this.bsePortLocCd = bsePortLocCd;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.ficGlineRtAmt = ficGlineRtAmt;
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.ratUtCd = ratUtCd;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.routDpSeq = routDpSeq;
		this.cmdtDpSeq = cmdtDpSeq;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.destRcvDeTermNm = destRcvDeTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("fic_qttn_rt_amt", getFicQttnRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("qttn_bof_amt", getQttnBofAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fic_gline_upd_dt", getFicGlineUpdDt());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("qttn_rt_amt", getQttnRtAmt());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("fic_gline_rt_amt", getFicGlineRtAmt());
		this.hashColumns.put("fic_rout_cmb_tp_cd", getFicRoutCmbTpCd());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("fic_qttn_rt_amt", "ficQttnRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("qttn_bof_amt", "qttnBofAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fic_gline_upd_dt", "ficGlineUpdDt");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("qttn_rt_amt", "qttnRtAmt");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("fic_gline_rt_amt", "ficGlineRtAmt");
		this.hashFields.put("fic_rout_cmb_tp_cd", "ficRoutCmbTpCd");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
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
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ficQttnRtAmt
	 */
	public String getFicQttnRtAmt() {
		return this.ficQttnRtAmt;
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
	 * @return orgPrcTrspModNm
	 */
	public String getOrgPrcTrspModNm() {
		return this.orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return qttnBofAmt
	 */
	public String getQttnBofAmt() {
		return this.qttnBofAmt;
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
	 * @return ficGlineUpdDt
	 */
	public String getFicGlineUpdDt() {
		return this.ficGlineUpdDt;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @return qttnRtAmt
	 */
	public String getQttnRtAmt() {
		return this.qttnRtAmt;
	}
	
	/**
	 * Column Info
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return ficGlineRtAmt
	 */
	public String getFicGlineRtAmt() {
		return this.ficGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ficRoutCmbTpCd
	 */
	public String getFicRoutCmbTpCd() {
		return this.ficRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCd
	 */
	public String getFicRtUseStsCd() {
		return this.ficRtUseStsCd;
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
	 * @return orgRoutPntLocDefNm
	 */
	public String getOrgRoutPntLocDefNm() {
		return this.orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return routDpSeq
	 */
	public String getRoutDpSeq() {
		return this.routDpSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return destPrcTrspModNm
	 */
	public String getDestPrcTrspModNm() {
		return this.destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefNm
	 */
	public String getDestRoutPntLocDefNm() {
		return this.destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return orgRcvDeTermNm
	 */
	public String getOrgRcvDeTermNm() {
		return this.orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return destRcvDeTermNm
	 */
	public String getDestRcvDeTermNm() {
		return this.destRcvDeTermNm;
	}
	

	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ficQttnRtAmt
	 */
	public void setFicQttnRtAmt(String ficQttnRtAmt) {
		this.ficQttnRtAmt = ficQttnRtAmt;
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
	 * @param orgPrcTrspModNm
	 */
	public void setOrgPrcTrspModNm(String orgPrcTrspModNm) {
		this.orgPrcTrspModNm = orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param qttnBofAmt
	 */
	public void setQttnBofAmt(String qttnBofAmt) {
		this.qttnBofAmt = qttnBofAmt;
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
	 * @param ficGlineUpdDt
	 */
	public void setFicGlineUpdDt(String ficGlineUpdDt) {
		this.ficGlineUpdDt = ficGlineUpdDt;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @param qttnRtAmt
	 */
	public void setQttnRtAmt(String qttnRtAmt) {
		this.qttnRtAmt = qttnRtAmt;
	}
	
	/**
	 * Column Info
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param ficGlineRtAmt
	 */
	public void setFicGlineRtAmt(String ficGlineRtAmt) {
		this.ficGlineRtAmt = ficGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ficRoutCmbTpCd
	 */
	public void setFicRoutCmbTpCd(String ficRoutCmbTpCd) {
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCd
	 */
	public void setFicRtUseStsCd(String ficRtUseStsCd) {
		this.ficRtUseStsCd = ficRtUseStsCd;
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
	 * @param orgRoutPntLocDefNm
	 */
	public void setOrgRoutPntLocDefNm(String orgRoutPntLocDefNm) {
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param routDpSeq
	 */
	public void setRoutDpSeq(String routDpSeq) {
		this.routDpSeq = routDpSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param destPrcTrspModNm
	 */
	public void setDestPrcTrspModNm(String destPrcTrspModNm) {
		this.destPrcTrspModNm = destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefNm
	 */
	public void setDestRoutPntLocDefNm(String destRoutPntLocDefNm) {
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param orgRcvDeTermNm
	 */
	public void setOrgRcvDeTermNm(String orgRcvDeTermNm) {
		this.orgRcvDeTermNm = orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param destRcvDeTermNm
	 */
	public void setDestRcvDeTermNm(String destRcvDeTermNm) {
		this.destRcvDeTermNm = destRcvDeTermNm;
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
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setFicQttnRtAmt(JSPUtil.getParameter(request, prefix + "fic_qttn_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request, prefix + "org_prc_trsp_mod_nm", ""));
		setQttnBofAmt(JSPUtil.getParameter(request, prefix + "qttn_bof_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFicGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_gline_upd_dt", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setQttnRtAmt(JSPUtil.getParameter(request, prefix + "qttn_rt_amt", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setFicGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt", ""));
		setFicRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_rout_cmb_tp_cd", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_nm", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, prefix + "rout_dp_seq", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, prefix + "cmdt_dp_seq", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request, prefix + "dest_prc_trsp_mod_nm", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_nm", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request, prefix + "org_rcv_de_term_nm", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request, prefix + "dest_rcv_de_term_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtListVerticalExcelForIHCVO[]
	 */
	public RsltRtListVerticalExcelForIHCVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtListVerticalExcelForIHCVO[]
	 */
	public RsltRtListVerticalExcelForIHCVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtListVerticalExcelForIHCVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] ficQttnRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_qttn_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "org_prc_trsp_mod_nm", length));
			String[] qttnBofAmt = (JSPUtil.getParameter(request, prefix	+ "qttn_bof_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ficGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_upd_dt", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] qttnRtAmt = (JSPUtil.getParameter(request, prefix	+ "qttn_rt_amt", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] ficGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt", length));
			String[] ficRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_rout_cmb_tp_cd", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] destPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "dest_prc_trsp_mod_nm", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] orgRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "org_rcv_de_term_nm", length));
			String[] destRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dest_rcv_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtListVerticalExcelForIHCVO();
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (ficQttnRtAmt[i] != null)
					model.setFicQttnRtAmt(ficQttnRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgPrcTrspModNm[i] != null)
					model.setOrgPrcTrspModNm(orgPrcTrspModNm[i]);
				if (qttnBofAmt[i] != null)
					model.setQttnBofAmt(qttnBofAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ficGlineUpdDt[i] != null)
					model.setFicGlineUpdDt(ficGlineUpdDt[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (qttnRtAmt[i] != null)
					model.setQttnRtAmt(qttnRtAmt[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (ficGlineRtAmt[i] != null)
					model.setFicGlineRtAmt(ficGlineRtAmt[i]);
				if (ficRoutCmbTpCd[i] != null)
					model.setFicRoutCmbTpCd(ficRoutCmbTpCd[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (destPrcTrspModNm[i] != null)
					model.setDestPrcTrspModNm(destPrcTrspModNm[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (orgRcvDeTermNm[i] != null)
					model.setOrgRcvDeTermNm(orgRcvDeTermNm[i]);
				if (destRcvDeTermNm[i] != null)
					model.setDestRcvDeTermNm(destRcvDeTermNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtListVerticalExcelForIHCVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtListVerticalExcelForIHCVO[]
	 */
	public RsltRtListVerticalExcelForIHCVO[] getRsltRtListVerticalExcelForIHCVOs(){
		RsltRtListVerticalExcelForIHCVO[] vos = (RsltRtListVerticalExcelForIHCVO[])models.toArray(new RsltRtListVerticalExcelForIHCVO[models.size()]);
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
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficQttnRtAmt = this.ficQttnRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm = this.orgPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnBofAmt = this.qttnBofAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineUpdDt = this.ficGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnRtAmt = this.qttnRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmt = this.ficGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRoutCmbTpCd = this.ficRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm = this.destPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm = this.orgRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm = this.destRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
