/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriSpScpTrspAddChgGriArbOKCLListVO.java
*@FileTitle : PriSpScpTrspAddChgGriArbOKCLListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.26 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSpScpTrspAddChgGriArbOKCLListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpScpTrspAddChgGriArbOKCLListVO> models = new ArrayList<PriSpScpTrspAddChgGriArbOKCLListVO>();
	
	/* Column Info */
	private String griRtAmt = null;
	/* Column Info */
	private String addChgSeq = null;
	/* Column Info */
	private String pointO = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String griApplAmt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String transmodeO = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* Column Info */
	private String griRtRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String viaO = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String griApplDivCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fltPctTpCd = null;
	/* Column Info */
	private String addChgTpCd = null;
	/* Column Info */
	private String griApplTpCd = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String termO = null;
	/* Column Info */
	private String bsePortDefCd = null;
	/* Column Info */
	private String griGrpSeq = null;
	/* Column Info */
	private String viaPortDefCd = null;
	/* Column Info */
	private String baseportO = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String griApplFlg = null;
	/* Column Info */
	private String n1stCmncDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriSpScpTrspAddChgGriArbOKCLListVO() {}

	public PriSpScpTrspAddChgGriArbOKCLListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String orgDestTpCd, String griGrpSeq, String fltPctTpCd, String griApplDivCd, String routPntLocDefCd, String prcTrspModCd, String rcvDeTermCd, String bsePortDefCd, String viaPortDefCd, String pointO, String transmodeO, String termO, String baseportO, String viaO, String addChgTpCd, String griApplFlg, String addChgSeq, String n1stCmncDt, String ratUtCd, String prcCgoTpCd, String currCd, String griRtAmt, String griRtRto, String updUsrId, String griApplTpCd, String griApplAmt, String propFrtRtAmt, String prcProgStsCd, String srcInfoCd) {
		this.griRtAmt = griRtAmt;
		this.addChgSeq = addChgSeq;
		this.pointO = pointO;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.griApplAmt = griApplAmt;
		this.amdtSeq = amdtSeq;
		this.transmodeO = transmodeO;
		this.svcScpCd = svcScpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.pagerows = pagerows;
		this.prcProgStsCd = prcProgStsCd;
		this.griRtRto = griRtRto;
		this.ibflag = ibflag;
		this.viaO = viaO;
		this.rcvDeTermCd = rcvDeTermCd;
		this.griApplDivCd = griApplDivCd;
		this.updUsrId = updUsrId;
		this.fltPctTpCd = fltPctTpCd;
		this.addChgTpCd = addChgTpCd;
		this.griApplTpCd = griApplTpCd;
		this.srcInfoCd = srcInfoCd;
		this.orgDestTpCd = orgDestTpCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.ratUtCd = ratUtCd;
		this.termO = termO;
		this.bsePortDefCd = bsePortDefCd;
		this.griGrpSeq = griGrpSeq;
		this.viaPortDefCd = viaPortDefCd;
		this.baseportO = baseportO;
		this.propNo = propNo;
		this.prcTrspModCd = prcTrspModCd;
		this.griApplFlg = griApplFlg;
		this.n1stCmncDt = n1stCmncDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gri_rt_amt", getGriRtAmt());
		this.hashColumns.put("add_chg_seq", getAddChgSeq());
		this.hashColumns.put("point_o", getPointO());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("gri_appl_amt", getGriApplAmt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("transmode_o", getTransmodeO());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("gri_rt_rto", getGriRtRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("via_o", getViaO());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("gri_appl_div_cd", getGriApplDivCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("flt_pct_tp_cd", getFltPctTpCd());
		this.hashColumns.put("add_chg_tp_cd", getAddChgTpCd());
		this.hashColumns.put("gri_appl_tp_cd", getGriApplTpCd());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("term_o", getTermO());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("gri_grp_seq", getGriGrpSeq());
		this.hashColumns.put("via_port_def_cd", getViaPortDefCd());
		this.hashColumns.put("baseport_o", getBaseportO());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("gri_appl_flg", getGriApplFlg());
		this.hashColumns.put("n1st_cmnc_dt", getN1stCmncDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gri_rt_amt", "griRtAmt");
		this.hashFields.put("add_chg_seq", "addChgSeq");
		this.hashFields.put("point_o", "pointO");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("gri_appl_amt", "griApplAmt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("transmode_o", "transmodeO");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("gri_rt_rto", "griRtRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("via_o", "viaO");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("gri_appl_div_cd", "griApplDivCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("flt_pct_tp_cd", "fltPctTpCd");
		this.hashFields.put("add_chg_tp_cd", "addChgTpCd");
		this.hashFields.put("gri_appl_tp_cd", "griApplTpCd");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("term_o", "termO");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("gri_grp_seq", "griGrpSeq");
		this.hashFields.put("via_port_def_cd", "viaPortDefCd");
		this.hashFields.put("baseport_o", "baseportO");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("gri_appl_flg", "griApplFlg");
		this.hashFields.put("n1st_cmnc_dt", "n1stCmncDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return griRtAmt
	 */
	public String getGriRtAmt() {
		return this.griRtAmt;
	}
	
	/**
	 * Column Info
	 * @return addChgSeq
	 */
	public String getAddChgSeq() {
		return this.addChgSeq;
	}
	
	/**
	 * Column Info
	 * @return pointO
	 */
	public String getPointO() {
		return this.pointO;
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
	 * @return griApplAmt
	 */
	public String getGriApplAmt() {
		return this.griApplAmt;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return transmodeO
	 */
	public String getTransmodeO() {
		return this.transmodeO;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
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
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @return griRtRto
	 */
	public String getGriRtRto() {
		return this.griRtRto;
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
	 * @return viaO
	 */
	public String getViaO() {
		return this.viaO;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return griApplDivCd
	 */
	public String getGriApplDivCd() {
		return this.griApplDivCd;
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
	 * @return fltPctTpCd
	 */
	public String getFltPctTpCd() {
		return this.fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @return addChgTpCd
	 */
	public String getAddChgTpCd() {
		return this.addChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return griApplTpCd
	 */
	public String getGriApplTpCd() {
		return this.griApplTpCd;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
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
	 * @return termO
	 */
	public String getTermO() {
		return this.termO;
	}
	
	/**
	 * Column Info
	 * @return bsePortDefCd
	 */
	public String getBsePortDefCd() {
		return this.bsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return griGrpSeq
	 */
	public String getGriGrpSeq() {
		return this.griGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return viaPortDefCd
	 */
	public String getViaPortDefCd() {
		return this.viaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return baseportO
	 */
	public String getBaseportO() {
		return this.baseportO;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return griApplFlg
	 */
	public String getGriApplFlg() {
		return this.griApplFlg;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncDt
	 */
	public String getN1stCmncDt() {
		return this.n1stCmncDt;
	}
	

	/**
	 * Column Info
	 * @param griRtAmt
	 */
	public void setGriRtAmt(String griRtAmt) {
		this.griRtAmt = griRtAmt;
	}
	
	/**
	 * Column Info
	 * @param addChgSeq
	 */
	public void setAddChgSeq(String addChgSeq) {
		this.addChgSeq = addChgSeq;
	}
	
	/**
	 * Column Info
	 * @param pointO
	 */
	public void setPointO(String pointO) {
		this.pointO = pointO;
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
	 * @param griApplAmt
	 */
	public void setGriApplAmt(String griApplAmt) {
		this.griApplAmt = griApplAmt;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param transmodeO
	 */
	public void setTransmodeO(String transmodeO) {
		this.transmodeO = transmodeO;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
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
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @param griRtRto
	 */
	public void setGriRtRto(String griRtRto) {
		this.griRtRto = griRtRto;
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
	 * @param viaO
	 */
	public void setViaO(String viaO) {
		this.viaO = viaO;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param griApplDivCd
	 */
	public void setGriApplDivCd(String griApplDivCd) {
		this.griApplDivCd = griApplDivCd;
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
	 * @param fltPctTpCd
	 */
	public void setFltPctTpCd(String fltPctTpCd) {
		this.fltPctTpCd = fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @param addChgTpCd
	 */
	public void setAddChgTpCd(String addChgTpCd) {
		this.addChgTpCd = addChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param griApplTpCd
	 */
	public void setGriApplTpCd(String griApplTpCd) {
		this.griApplTpCd = griApplTpCd;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
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
	 * @param termO
	 */
	public void setTermO(String termO) {
		this.termO = termO;
	}
	
	/**
	 * Column Info
	 * @param bsePortDefCd
	 */
	public void setBsePortDefCd(String bsePortDefCd) {
		this.bsePortDefCd = bsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param griGrpSeq
	 */
	public void setGriGrpSeq(String griGrpSeq) {
		this.griGrpSeq = griGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param viaPortDefCd
	 */
	public void setViaPortDefCd(String viaPortDefCd) {
		this.viaPortDefCd = viaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param baseportO
	 */
	public void setBaseportO(String baseportO) {
		this.baseportO = baseportO;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param griApplFlg
	 */
	public void setGriApplFlg(String griApplFlg) {
		this.griApplFlg = griApplFlg;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncDt
	 */
	public void setN1stCmncDt(String n1stCmncDt) {
		this.n1stCmncDt = n1stCmncDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGriRtAmt(JSPUtil.getParameter(request, "gri_rt_amt", ""));
		setAddChgSeq(JSPUtil.getParameter(request, "add_chg_seq", ""));
		setPointO(JSPUtil.getParameter(request, "point_o", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setGriApplAmt(JSPUtil.getParameter(request, "gri_appl_amt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setTransmodeO(JSPUtil.getParameter(request, "transmode_o", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, "rout_pnt_loc_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, "prc_prog_sts_cd", ""));
		setGriRtRto(JSPUtil.getParameter(request, "gri_rt_rto", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setViaO(JSPUtil.getParameter(request, "via_o", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
		setGriApplDivCd(JSPUtil.getParameter(request, "gri_appl_div_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setFltPctTpCd(JSPUtil.getParameter(request, "flt_pct_tp_cd", ""));
		setAddChgTpCd(JSPUtil.getParameter(request, "add_chg_tp_cd", ""));
		setGriApplTpCd(JSPUtil.getParameter(request, "gri_appl_tp_cd", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, "src_info_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, "prop_frt_rt_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setTermO(JSPUtil.getParameter(request, "term_o", ""));
		setBsePortDefCd(JSPUtil.getParameter(request, "bse_port_def_cd", ""));
		setGriGrpSeq(JSPUtil.getParameter(request, "gri_grp_seq", ""));
		setViaPortDefCd(JSPUtil.getParameter(request, "via_port_def_cd", ""));
		setBaseportO(JSPUtil.getParameter(request, "baseport_o", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, "prc_trsp_mod_cd", ""));
		setGriApplFlg(JSPUtil.getParameter(request, "gri_appl_flg", ""));
		setN1stCmncDt(JSPUtil.getParameter(request, "n1st_cmnc_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSpScpTrspAddChgGriArbOKCLListVO[]
	 */
	public PriSpScpTrspAddChgGriArbOKCLListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSpScpTrspAddChgGriArbOKCLListVO[]
	 */
	public PriSpScpTrspAddChgGriArbOKCLListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpScpTrspAddChgGriArbOKCLListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] griRtAmt = (JSPUtil.getParameter(request, prefix	+ "gri_rt_amt", length));
			String[] addChgSeq = (JSPUtil.getParameter(request, prefix	+ "add_chg_seq", length));
			String[] pointO = (JSPUtil.getParameter(request, prefix	+ "point_o", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] griApplAmt = (JSPUtil.getParameter(request, prefix	+ "gri_appl_amt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] transmodeO = (JSPUtil.getParameter(request, prefix	+ "transmode_o", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] griRtRto = (JSPUtil.getParameter(request, prefix	+ "gri_rt_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] viaO = (JSPUtil.getParameter(request, prefix	+ "via_o", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] griApplDivCd = (JSPUtil.getParameter(request, prefix	+ "gri_appl_div_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "flt_pct_tp_cd", length));
			String[] addChgTpCd = (JSPUtil.getParameter(request, prefix	+ "add_chg_tp_cd", length));
			String[] griApplTpCd = (JSPUtil.getParameter(request, prefix	+ "gri_appl_tp_cd", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] termO = (JSPUtil.getParameter(request, prefix	+ "term_o", length));
			String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_def_cd", length));
			String[] griGrpSeq = (JSPUtil.getParameter(request, prefix	+ "gri_grp_seq", length));
			String[] viaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "via_port_def_cd", length));
			String[] baseportO = (JSPUtil.getParameter(request, prefix	+ "baseport_o", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] griApplFlg = (JSPUtil.getParameter(request, prefix	+ "gri_appl_flg", length));
			String[] n1stCmncDt = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpScpTrspAddChgGriArbOKCLListVO();
				if (griRtAmt[i] != null)
					model.setGriRtAmt(griRtAmt[i]);
				if (addChgSeq[i] != null)
					model.setAddChgSeq(addChgSeq[i]);
				if (pointO[i] != null)
					model.setPointO(pointO[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (griApplAmt[i] != null)
					model.setGriApplAmt(griApplAmt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (transmodeO[i] != null)
					model.setTransmodeO(transmodeO[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (griRtRto[i] != null)
					model.setGriRtRto(griRtRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (viaO[i] != null)
					model.setViaO(viaO[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (griApplDivCd[i] != null)
					model.setGriApplDivCd(griApplDivCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fltPctTpCd[i] != null)
					model.setFltPctTpCd(fltPctTpCd[i]);
				if (addChgTpCd[i] != null)
					model.setAddChgTpCd(addChgTpCd[i]);
				if (griApplTpCd[i] != null)
					model.setGriApplTpCd(griApplTpCd[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (termO[i] != null)
					model.setTermO(termO[i]);
				if (bsePortDefCd[i] != null)
					model.setBsePortDefCd(bsePortDefCd[i]);
				if (griGrpSeq[i] != null)
					model.setGriGrpSeq(griGrpSeq[i]);
				if (viaPortDefCd[i] != null)
					model.setViaPortDefCd(viaPortDefCd[i]);
				if (baseportO[i] != null)
					model.setBaseportO(baseportO[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (griApplFlg[i] != null)
					model.setGriApplFlg(griApplFlg[i]);
				if (n1stCmncDt[i] != null)
					model.setN1stCmncDt(n1stCmncDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpScpTrspAddChgGriArbOKCLListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpScpTrspAddChgGriArbOKCLListVO[]
	 */
	public PriSpScpTrspAddChgGriArbOKCLListVO[] getPriSpScpTrspAddChgGriArbOKCLListVOs(){
		PriSpScpTrspAddChgGriArbOKCLListVO[] vos = (PriSpScpTrspAddChgGriArbOKCLListVO[])models.toArray(new PriSpScpTrspAddChgGriArbOKCLListVO[models.size()]);
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
		this.griRtAmt = this.griRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgSeq = this.addChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pointO = this.pointO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplAmt = this.griApplAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transmodeO = this.transmodeO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griRtRto = this.griRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaO = this.viaO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplDivCd = this.griApplDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltPctTpCd = this.fltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgTpCd = this.addChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplTpCd = this.griApplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termO = this.termO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd = this.bsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griGrpSeq = this.griGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaPortDefCd = this.viaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.baseportO = this.baseportO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplFlg = this.griApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncDt = this.n1stCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
