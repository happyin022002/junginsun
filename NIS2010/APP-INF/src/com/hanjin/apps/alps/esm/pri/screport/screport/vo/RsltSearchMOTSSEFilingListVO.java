/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RsltSearchMOTSSEFilingListVO.java
*@FileTitle : RsltSearchMOTSSEFilingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

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

public class RsltSearchMOTSSEFilingListVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchMOTSSEFilingListVO> models = new ArrayList<RsltSearchMOTSSEFilingListVO>();
	
	/* Column Info */
	private String bkgSrcTpCd = null;
	/* Column Info */
	private String dnfcAmt = null;
	/* Column Info */
	private String motFilePstRlyPortCd = null;
	/* Column Info */
	private String stfAmt = null;
	/* Column Info */
	private String oensAmt = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String lbpAmt = null;
	/* Column Info */
	private String cntrSz = null;
	/* Column Info */
	private String docpAmt = null;
	/* Column Info */
	private String motFilePreRlyPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String fOrgCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cmdtTp = null;
	/* Column Info */
	private String eicAmt = null;
	/* Column Info */
	private String blnk1 = null;
	/* Column Info */
	private String tgohAmt = null;
	/* Column Info */
	private String fCmdtTpCd = null;
	/* Column Info */
	private String oeicAmt = null;
	/* Column Info */
	private String fCntrTpCd = null;
	/* Column Info */
	private String carrier = null;
	/* Column Info */
	private String blrAmt = null;
	/* Column Info */
	private String motTrfDestCd = null;
	/* Column Info */
	private String dthcAmt = null;
	/* Column Info */
	private String ddtsAmt = null;
	/* Column Info */
	private String motTrfCntrTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String motTrfRtAmt = null;
	/* Column Info */
	private String motFileLaneCd = null;
	/* Column Info */
	private String toFileDt = null;
	/* Column Info */
	private String dactAmt = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String ocmsAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String tdisAmt = null;
	/* Column Info */
	private String bucAmt = null;
	/* Column Info */
	private String pscAmt = null;
	/* Column Info */
	private String odcsAmt = null;
	/* Column Info */
	private String ddcsAmt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String twscAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cafAmt = null;
	/* Column Info */
	private String batExeDt = null;
	/* Column Info */
	private String dddcAmt = null;
	/* Column Info */
	private String bccAmt = null;
	/* Column Info */
	private String oobsAmt = null;
	/* Column Info */
	private String odhfAmt = null;
	/* Column Info */
	private String execDt = null;
	/* Column Info */
	private String othcAmt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fLaneCd = null;
	/* Column Info */
	private String motFileDeTermCd = null;
	/* Column Info */
	private String obsAmt = null;
	/* Column Info */
	private String fDestCd = null;
	/* Column Info */
	private String testExecDt = null;
	/* Column Info */
	private String motTrfOrgCd = null;
	/* Column Info */
	private String pccAmt = null;
	/* Column Info */
	private String bkgDirCallFlg = null;
	/* Column Info */
	private String odAmt = null;
	/* Column Info */
	private String inqTpCd = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String bafAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fCntrSzCd = null;
	/* Column Info */
	private String motTrfCmdtTpCd = null;
	/* Column Info */
	private String lsiAmt = null;
	/* Column Info */
	private String motTrfCntrSzCd = null;
	/* Column Info */
	private String ctcAmt = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String mqc1 = null;
	/* Column Info */
	private String motTrfChgAmt = null;
	/* Column Info */
	private String mqc2 = null;
	/* Column Info */
	private String apsAmt = null;
	/* Column Info */
	private String ctrtHldNm = null;
	/* Column Info */
	private String motTrfChgCd = null;
	/* Column Info */
	private String scgSeq = null;
	/* Column Info */
	private String oslfAmt = null;
	/* Column Info */
	private String frFileDt = null;
	/* Column Info */
	private String oftRt = null;
	/* Column Info */
	private String motFileIbPortCd = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String dddfAmt = null;
	/* Column Info */
	private String pcsAmt = null;
	/* Column Info */
	private String motFileTsPortCd = null;
	/* Column Info */
	private String motTrfSeq = null;
	/* Column Info */
	private String cntrTp = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String motTrfRmk = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String csrAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltSearchMOTSSEFilingListVO() {}

	public RsltSearchMOTSSEFilingListVO(String ibflag, String pagerows, String seq, String batExeDt, String carrier, String ctrtNo, String ctrtHldNm, String bkgNo, String bkgSrcTpCd, String shprNm, String lane, String porCd, String delCd, String cntrTp, String cmdtTp, String actCustNm, String cntrSz, String mqc1, String mqc2, String oftRt, String blnk1, String bafAmt, String cafAmt, String othcAmt, String dthcAmt, String apsAmt, String csrAmt, String pscAmt, String pccAmt, String pcsAmt, String stfAmt, String dactAmt, String dddcAmt, String dddfAmt, String dnfcAmt, String oensAmt, String odAmt, String tdisAmt, String tgohAmt, String twscAmt, String effDt, String expDt, String remark, String execDt, String testExecDt, String inqTpCd, String creUsrId, String updUsrId, String frFileDt, String toFileDt, String cfmDt, String cfmFlg, String fileDt, String motFileLaneCd, String motTrfChgAmt, String motTrfChgCd, String motTrfCmdtTpCd, String motTrfCntrSzCd, String motTrfCntrTpCd, String motTrfDestCd, String motTrfOrgCd, String motTrfRmk, String motTrfRtAmt, String motTrfSeq, String rtSeq, String scgSeq, String svcScpCd, String bkgDirCallFlg, String motFileTsPortCd, String motFilePreRlyPortCd, String motFilePstRlyPortCd, String fLaneCd, String fCntrTpCd, String fCntrSzCd, String fCmdtTpCd, String fOrgCd, String fDestCd, String oeicAmt, String oslfAmt, String motFileIbPortCd, String motFileDeTermCd, String bucAmt, String eicAmt, String oobsAmt, String odhfAmt, String odcsAmt, String ddcsAmt, String ddtsAmt, String ocmsAmt, String docpAmt, String obsAmt, String bccAmt, String blrAmt, String lbpAmt, String ctcAmt, String lsiAmt) {
		this.bkgSrcTpCd = bkgSrcTpCd;
		this.dnfcAmt = dnfcAmt;
		this.motFilePstRlyPortCd = motFilePstRlyPortCd;
		this.stfAmt = stfAmt;
		this.oensAmt = oensAmt;
		this.remark = remark;
		this.svcScpCd = svcScpCd;
		this.lbpAmt = lbpAmt;
		this.cntrSz = cntrSz;
		this.docpAmt = docpAmt;
		this.motFilePreRlyPortCd = motFilePreRlyPortCd;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.fOrgCd = fOrgCd;
		this.effDt = effDt;
		this.cmdtTp = cmdtTp;
		this.eicAmt = eicAmt;
		this.blnk1 = blnk1;
		this.tgohAmt = tgohAmt;
		this.fCmdtTpCd = fCmdtTpCd;
		this.oeicAmt = oeicAmt;
		this.fCntrTpCd = fCntrTpCd;
		this.carrier = carrier;
		this.blrAmt = blrAmt;
		this.motTrfDestCd = motTrfDestCd;
		this.dthcAmt = dthcAmt;
		this.ddtsAmt = ddtsAmt;
		this.motTrfCntrTpCd = motTrfCntrTpCd;
		this.updUsrId = updUsrId;
		this.motTrfRtAmt = motTrfRtAmt;
		this.motFileLaneCd = motFileLaneCd;
		this.toFileDt = toFileDt;
		this.dactAmt = dactAmt;
		this.fileDt = fileDt;
		this.cfmDt = cfmDt;
		this.ocmsAmt = ocmsAmt;
		this.delCd = delCd;
		this.tdisAmt = tdisAmt;
		this.bucAmt = bucAmt;
		this.pscAmt = pscAmt;
		this.odcsAmt = odcsAmt;
		this.ddcsAmt = ddcsAmt;
		this.rtSeq = rtSeq;
		this.bkgNo = bkgNo;
		this.twscAmt = twscAmt;
		this.creUsrId = creUsrId;
		this.cafAmt = cafAmt;
		this.batExeDt = batExeDt;
		this.dddcAmt = dddcAmt;
		this.bccAmt = bccAmt;
		this.oobsAmt = oobsAmt;
		this.odhfAmt = odhfAmt;
		this.execDt = execDt;
		this.othcAmt = othcAmt;
		this.porCd = porCd;
		this.fLaneCd = fLaneCd;
		this.motFileDeTermCd = motFileDeTermCd;
		this.obsAmt = obsAmt;
		this.fDestCd = fDestCd;
		this.testExecDt = testExecDt;
		this.motTrfOrgCd = motTrfOrgCd;
		this.pccAmt = pccAmt;
		this.bkgDirCallFlg = bkgDirCallFlg;
		this.odAmt = odAmt;
		this.inqTpCd = inqTpCd;
		this.lane = lane;
		this.bafAmt = bafAmt;
		this.ibflag = ibflag;
		this.fCntrSzCd = fCntrSzCd;
		this.motTrfCmdtTpCd = motTrfCmdtTpCd;
		this.lsiAmt = lsiAmt;
		this.motTrfCntrSzCd = motTrfCntrSzCd;
		this.ctcAmt = ctcAmt;
		this.shprNm = shprNm;
		this.expDt = expDt;
		this.mqc1 = mqc1;
		this.motTrfChgAmt = motTrfChgAmt;
		this.mqc2 = mqc2;
		this.apsAmt = apsAmt;
		this.ctrtHldNm = ctrtHldNm;
		this.motTrfChgCd = motTrfChgCd;
		this.scgSeq = scgSeq;
		this.oslfAmt = oslfAmt;
		this.frFileDt = frFileDt;
		this.oftRt = oftRt;
		this.motFileIbPortCd = motFileIbPortCd;
		this.cfmFlg = cfmFlg;
		this.dddfAmt = dddfAmt;
		this.pcsAmt = pcsAmt;
		this.motFileTsPortCd = motFileTsPortCd;
		this.motTrfSeq = motTrfSeq;
		this.cntrTp = cntrTp;
		this.actCustNm = actCustNm;
		this.motTrfRmk = motTrfRmk;
		this.seq = seq;
		this.csrAmt = csrAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_src_tp_cd", getBkgSrcTpCd());
		this.hashColumns.put("dnfc_amt", getDnfcAmt());
		this.hashColumns.put("mot_file_pst_rly_port_cd", getMotFilePstRlyPortCd());
		this.hashColumns.put("stf_amt", getStfAmt());
		this.hashColumns.put("oens_amt", getOensAmt());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("lbp_amt", getLbpAmt());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("docp_amt", getDocpAmt());
		this.hashColumns.put("mot_file_pre_rly_port_cd", getMotFilePreRlyPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("f_org_cd", getFOrgCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cmdt_tp", getCmdtTp());
		this.hashColumns.put("eic_amt", getEicAmt());
		this.hashColumns.put("blnk1", getBlnk1());
		this.hashColumns.put("tgoh_amt", getTgohAmt());
		this.hashColumns.put("f_cmdt_tp_cd", getFCmdtTpCd());
		this.hashColumns.put("oeic_amt", getOeicAmt());
		this.hashColumns.put("f_cntr_tp_cd", getFCntrTpCd());
		this.hashColumns.put("carrier", getCarrier());
		this.hashColumns.put("blr_amt", getBlrAmt());
		this.hashColumns.put("mot_trf_dest_cd", getMotTrfDestCd());
		this.hashColumns.put("dthc_amt", getDthcAmt());
		this.hashColumns.put("ddts_amt", getDdtsAmt());
		this.hashColumns.put("mot_trf_cntr_tp_cd", getMotTrfCntrTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mot_trf_rt_amt", getMotTrfRtAmt());
		this.hashColumns.put("mot_file_lane_cd", getMotFileLaneCd());
		this.hashColumns.put("to_file_dt", getToFileDt());
		this.hashColumns.put("dact_amt", getDactAmt());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("ocms_amt", getOcmsAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("tdis_amt", getTdisAmt());
		this.hashColumns.put("buc_amt", getBucAmt());
		this.hashColumns.put("psc_amt", getPscAmt());
		this.hashColumns.put("odcs_amt", getOdcsAmt());
		this.hashColumns.put("ddcs_amt", getDdcsAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("twsc_amt", getTwscAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("caf_amt", getCafAmt());
		this.hashColumns.put("bat_exe_dt", getBatExeDt());
		this.hashColumns.put("dddc_amt", getDddcAmt());
		this.hashColumns.put("bcc_amt", getBccAmt());
		this.hashColumns.put("oobs_amt", getOobsAmt());
		this.hashColumns.put("odhf_amt", getOdhfAmt());
		this.hashColumns.put("exec_dt", getExecDt());
		this.hashColumns.put("othc_amt", getOthcAmt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("f_lane_cd", getFLaneCd());
		this.hashColumns.put("mot_file_de_term_cd", getMotFileDeTermCd());
		this.hashColumns.put("obs_amt", getObsAmt());
		this.hashColumns.put("f_dest_cd", getFDestCd());
		this.hashColumns.put("test_exec_dt", getTestExecDt());
		this.hashColumns.put("mot_trf_org_cd", getMotTrfOrgCd());
		this.hashColumns.put("pcc_amt", getPccAmt());
		this.hashColumns.put("bkg_dir_call_flg", getBkgDirCallFlg());
		this.hashColumns.put("od_amt", getOdAmt());
		this.hashColumns.put("inq_tp_cd", getInqTpCd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("baf_amt", getBafAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_cntr_sz_cd", getFCntrSzCd());
		this.hashColumns.put("mot_trf_cmdt_tp_cd", getMotTrfCmdtTpCd());
		this.hashColumns.put("lsi_amt", getLsiAmt());
		this.hashColumns.put("mot_trf_cntr_sz_cd", getMotTrfCntrSzCd());
		this.hashColumns.put("ctc_amt", getCtcAmt());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("mqc1", getMqc1());
		this.hashColumns.put("mot_trf_chg_amt", getMotTrfChgAmt());
		this.hashColumns.put("mqc2", getMqc2());
		this.hashColumns.put("aps_amt", getApsAmt());
		this.hashColumns.put("ctrt_hld_nm", getCtrtHldNm());
		this.hashColumns.put("mot_trf_chg_cd", getMotTrfChgCd());
		this.hashColumns.put("scg_seq", getScgSeq());
		this.hashColumns.put("oslf_amt", getOslfAmt());
		this.hashColumns.put("fr_file_dt", getFrFileDt());
		this.hashColumns.put("oft_rt", getOftRt());
		this.hashColumns.put("mot_file_ib_port_cd", getMotFileIbPortCd());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("dddf_amt", getDddfAmt());
		this.hashColumns.put("pcs_amt", getPcsAmt());
		this.hashColumns.put("mot_file_ts_port_cd", getMotFileTsPortCd());
		this.hashColumns.put("mot_trf_seq", getMotTrfSeq());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("mot_trf_rmk", getMotTrfRmk());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("csr_amt", getCsrAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_src_tp_cd", "bkgSrcTpCd");
		this.hashFields.put("dnfc_amt", "dnfcAmt");
		this.hashFields.put("mot_file_pst_rly_port_cd", "motFilePstRlyPortCd");
		this.hashFields.put("stf_amt", "stfAmt");
		this.hashFields.put("oens_amt", "oensAmt");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("lbp_amt", "lbpAmt");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("docp_amt", "docpAmt");
		this.hashFields.put("mot_file_pre_rly_port_cd", "motFilePreRlyPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("f_org_cd", "fOrgCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cmdt_tp", "cmdtTp");
		this.hashFields.put("eic_amt", "eicAmt");
		this.hashFields.put("blnk1", "blnk1");
		this.hashFields.put("tgoh_amt", "tgohAmt");
		this.hashFields.put("f_cmdt_tp_cd", "fCmdtTpCd");
		this.hashFields.put("oeic_amt", "oeicAmt");
		this.hashFields.put("f_cntr_tp_cd", "fCntrTpCd");
		this.hashFields.put("carrier", "carrier");
		this.hashFields.put("blr_amt", "blrAmt");
		this.hashFields.put("mot_trf_dest_cd", "motTrfDestCd");
		this.hashFields.put("dthc_amt", "dthcAmt");
		this.hashFields.put("ddts_amt", "ddtsAmt");
		this.hashFields.put("mot_trf_cntr_tp_cd", "motTrfCntrTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mot_trf_rt_amt", "motTrfRtAmt");
		this.hashFields.put("mot_file_lane_cd", "motFileLaneCd");
		this.hashFields.put("to_file_dt", "toFileDt");
		this.hashFields.put("dact_amt", "dactAmt");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("ocms_amt", "ocmsAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("tdis_amt", "tdisAmt");
		this.hashFields.put("buc_amt", "bucAmt");
		this.hashFields.put("psc_amt", "pscAmt");
		this.hashFields.put("odcs_amt", "odcsAmt");
		this.hashFields.put("ddcs_amt", "ddcsAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("twsc_amt", "twscAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("caf_amt", "cafAmt");
		this.hashFields.put("bat_exe_dt", "batExeDt");
		this.hashFields.put("dddc_amt", "dddcAmt");
		this.hashFields.put("bcc_amt", "bccAmt");
		this.hashFields.put("oobs_amt", "oobsAmt");
		this.hashFields.put("odhf_amt", "odhfAmt");
		this.hashFields.put("exec_dt", "execDt");
		this.hashFields.put("othc_amt", "othcAmt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("f_lane_cd", "fLaneCd");
		this.hashFields.put("mot_file_de_term_cd", "motFileDeTermCd");
		this.hashFields.put("obs_amt", "obsAmt");
		this.hashFields.put("f_dest_cd", "fDestCd");
		this.hashFields.put("test_exec_dt", "testExecDt");
		this.hashFields.put("mot_trf_org_cd", "motTrfOrgCd");
		this.hashFields.put("pcc_amt", "pccAmt");
		this.hashFields.put("bkg_dir_call_flg", "bkgDirCallFlg");
		this.hashFields.put("od_amt", "odAmt");
		this.hashFields.put("inq_tp_cd", "inqTpCd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("baf_amt", "bafAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_cntr_sz_cd", "fCntrSzCd");
		this.hashFields.put("mot_trf_cmdt_tp_cd", "motTrfCmdtTpCd");
		this.hashFields.put("lsi_amt", "lsiAmt");
		this.hashFields.put("mot_trf_cntr_sz_cd", "motTrfCntrSzCd");
		this.hashFields.put("ctc_amt", "ctcAmt");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("mqc1", "mqc1");
		this.hashFields.put("mot_trf_chg_amt", "motTrfChgAmt");
		this.hashFields.put("mqc2", "mqc2");
		this.hashFields.put("aps_amt", "apsAmt");
		this.hashFields.put("ctrt_hld_nm", "ctrtHldNm");
		this.hashFields.put("mot_trf_chg_cd", "motTrfChgCd");
		this.hashFields.put("scg_seq", "scgSeq");
		this.hashFields.put("oslf_amt", "oslfAmt");
		this.hashFields.put("fr_file_dt", "frFileDt");
		this.hashFields.put("oft_rt", "oftRt");
		this.hashFields.put("mot_file_ib_port_cd", "motFileIbPortCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("dddf_amt", "dddfAmt");
		this.hashFields.put("pcs_amt", "pcsAmt");
		this.hashFields.put("mot_file_ts_port_cd", "motFileTsPortCd");
		this.hashFields.put("mot_trf_seq", "motTrfSeq");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("mot_trf_rmk", "motTrfRmk");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("csr_amt", "csrAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgSrcTpCd
	 */
	public String getBkgSrcTpCd() {
		return this.bkgSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @return dnfcAmt
	 */
	public String getDnfcAmt() {
		return this.dnfcAmt;
	}
	
	/**
	 * Column Info
	 * @return motFilePstRlyPortCd
	 */
	public String getMotFilePstRlyPortCd() {
		return this.motFilePstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return stfAmt
	 */
	public String getStfAmt() {
		return this.stfAmt;
	}
	
	/**
	 * Column Info
	 * @return oensAmt
	 */
	public String getOensAmt() {
		return this.oensAmt;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
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
	 * @return lbpAmt
	 */
	public String getLbpAmt() {
		return this.lbpAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrSz
	 */
	public String getCntrSz() {
		return this.cntrSz;
	}
	
	/**
	 * Column Info
	 * @return docpAmt
	 */
	public String getDocpAmt() {
		return this.docpAmt;
	}
	
	/**
	 * Column Info
	 * @return motFilePreRlyPortCd
	 */
	public String getMotFilePreRlyPortCd() {
		return this.motFilePreRlyPortCd;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return fOrgCd
	 */
	public String getFOrgCd() {
		return this.fOrgCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return cmdtTp
	 */
	public String getCmdtTp() {
		return this.cmdtTp;
	}
	
	/**
	 * Column Info
	 * @return eicAmt
	 */
	public String getEicAmt() {
		return this.eicAmt;
	}
	
	/**
	 * Column Info
	 * @return blnk1
	 */
	public String getBlnk1() {
		return this.blnk1;
	}
	
	/**
	 * Column Info
	 * @return tgohAmt
	 */
	public String getTgohAmt() {
		return this.tgohAmt;
	}
	
	/**
	 * Column Info
	 * @return fCmdtTpCd
	 */
	public String getFCmdtTpCd() {
		return this.fCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @return oeicAmt
	 */
	public String getOeicAmt() {
		return this.oeicAmt;
	}
	
	/**
	 * Column Info
	 * @return fCntrTpCd
	 */
	public String getFCntrTpCd() {
		return this.fCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return carrier
	 */
	public String getCarrier() {
		return this.carrier;
	}
	
	/**
	 * Column Info
	 * @return blrAmt
	 */
	public String getBlrAmt() {
		return this.blrAmt;
	}
	
	/**
	 * Column Info
	 * @return motTrfDestCd
	 */
	public String getMotTrfDestCd() {
		return this.motTrfDestCd;
	}
	
	/**
	 * Column Info
	 * @return dthcAmt
	 */
	public String getDthcAmt() {
		return this.dthcAmt;
	}
	
	/**
	 * Column Info
	 * @return ddtsAmt
	 */
	public String getDdtsAmt() {
		return this.ddtsAmt;
	}
	
	/**
	 * Column Info
	 * @return motTrfCntrTpCd
	 */
	public String getMotTrfCntrTpCd() {
		return this.motTrfCntrTpCd;
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
	 * @return motTrfRtAmt
	 */
	public String getMotTrfRtAmt() {
		return this.motTrfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return motFileLaneCd
	 */
	public String getMotFileLaneCd() {
		return this.motFileLaneCd;
	}
	
	/**
	 * Column Info
	 * @return toFileDt
	 */
	public String getToFileDt() {
		return this.toFileDt;
	}
	
	/**
	 * Column Info
	 * @return dactAmt
	 */
	public String getDactAmt() {
		return this.dactAmt;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return ocmsAmt
	 */
	public String getOcmsAmt() {
		return this.ocmsAmt;
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
	 * @return tdisAmt
	 */
	public String getTdisAmt() {
		return this.tdisAmt;
	}
	
	/**
	 * Column Info
	 * @return bucAmt
	 */
	public String getBucAmt() {
		return this.bucAmt;
	}
	
	/**
	 * Column Info
	 * @return pscAmt
	 */
	public String getPscAmt() {
		return this.pscAmt;
	}
	
	/**
	 * Column Info
	 * @return odcsAmt
	 */
	public String getOdcsAmt() {
		return this.odcsAmt;
	}
	/**
	 * Column Info
	 * @return ddcsAmt
	 */
	public String getDdcsAmt() {
		return this.ddcsAmt;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
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
	 * @return twscAmt
	 */
	public String getTwscAmt() {
		return this.twscAmt;
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
	 * @return cafAmt
	 */
	public String getCafAmt() {
		return this.cafAmt;
	}
	
	/**
	 * Column Info
	 * @return batExeDt
	 */
	public String getBatExeDt() {
		return this.batExeDt;
	}
	
	/**
	 * Column Info
	 * @return dddcAmt
	 */
	public String getDddcAmt() {
		return this.dddcAmt;
	}
	
	/**
	 * Column Info
	 * @return bccAmt
	 */
	public String getBccAmt() {
		return this.bccAmt;
	}
	
	/**
	 * Column Info
	 * @return oobsAmt
	 */
	public String getOobsAmt() {
		return this.oobsAmt;
	}
	
	/**
	 * Column Info
	 * @return odhfAmt
	 */
	public String getOdhfAmt() {
		return this.odhfAmt;
	}
	
	/**
	 * Column Info
	 * @return execDt
	 */
	public String getExecDt() {
		return this.execDt;
	}
	
	/**
	 * Column Info
	 * @return othcAmt
	 */
	public String getOthcAmt() {
		return this.othcAmt;
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
	 * @return fLaneCd
	 */
	public String getFLaneCd() {
		return this.fLaneCd;
	}
	
	/**
	 * Column Info
	 * @return motFileDeTermCd
	 */
	public String getMotFileDeTermCd() {
		return this.motFileDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return obsAmt
	 */
	public String getObsAmt() {
		return this.obsAmt;
	}
	
	/**
	 * Column Info
	 * @return fDestCd
	 */
	public String getFDestCd() {
		return this.fDestCd;
	}
	
	/**
	 * Column Info
	 * @return testExecDt
	 */
	public String getTestExecDt() {
		return this.testExecDt;
	}
	
	/**
	 * Column Info
	 * @return motTrfOrgCd
	 */
	public String getMotTrfOrgCd() {
		return this.motTrfOrgCd;
	}
	
	/**
	 * Column Info
	 * @return pccAmt
	 */
	public String getPccAmt() {
		return this.pccAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgDirCallFlg
	 */
	public String getBkgDirCallFlg() {
		return this.bkgDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return odAmt
	 */
	public String getOdAmt() {
		return this.odAmt;
	}
	
	/**
	 * Column Info
	 * @return inqTpCd
	 */
	public String getInqTpCd() {
		return this.inqTpCd;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return bafAmt
	 */
	public String getBafAmt() {
		return this.bafAmt;
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
	 * @return fCntrSzCd
	 */
	public String getFCntrSzCd() {
		return this.fCntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return motTrfCmdtTpCd
	 */
	public String getMotTrfCmdtTpCd() {
		return this.motTrfCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @return lsiAmt
	 */
	public String getLsiAmt() {
		return this.lsiAmt;
	}
	
	/**
	 * Column Info
	 * @return motTrfCntrSzCd
	 */
	public String getMotTrfCntrSzCd() {
		return this.motTrfCntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return ctcAmt
	 */
	public String getCtcAmt() {
		return this.ctcAmt;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return mqc1
	 */
	public String getMqc1() {
		return this.mqc1;
	}
	
	/**
	 * Column Info
	 * @return motTrfChgAmt
	 */
	public String getMotTrfChgAmt() {
		return this.motTrfChgAmt;
	}
	
	/**
	 * Column Info
	 * @return mqc2
	 */
	public String getMqc2() {
		return this.mqc2;
	}
	
	/**
	 * Column Info
	 * @return apsAmt
	 */
	public String getApsAmt() {
		return this.apsAmt;
	}
	
	/**
	 * Column Info
	 * @return ctrtHldNm
	 */
	public String getCtrtHldNm() {
		return this.ctrtHldNm;
	}
	
	/**
	 * Column Info
	 * @return motTrfChgCd
	 */
	public String getMotTrfChgCd() {
		return this.motTrfChgCd;
	}
	
	/**
	 * Column Info
	 * @return scgSeq
	 */
	public String getScgSeq() {
		return this.scgSeq;
	}
	
	/**
	 * Column Info
	 * @return oslfAmt
	 */
	public String getOslfAmt() {
		return this.oslfAmt;
	}
	
	/**
	 * Column Info
	 * @return frFileDt
	 */
	public String getFrFileDt() {
		return this.frFileDt;
	}
	
	/**
	 * Column Info
	 * @return oftRt
	 */
	public String getOftRt() {
		return this.oftRt;
	}
	
	/**
	 * Column Info
	 * @return motFileIbPortCd
	 */
	public String getMotFileIbPortCd() {
		return this.motFileIbPortCd;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return dddfAmt
	 */
	public String getDddfAmt() {
		return this.dddfAmt;
	}
	
	/**
	 * Column Info
	 * @return pcsAmt
	 */
	public String getPcsAmt() {
		return this.pcsAmt;
	}
	
	/**
	 * Column Info
	 * @return motFileTsPortCd
	 */
	public String getMotFileTsPortCd() {
		return this.motFileTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return motTrfSeq
	 */
	public String getMotTrfSeq() {
		return this.motTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrTp
	 */
	public String getCntrTp() {
		return this.cntrTp;
	}
	
	/**
	 * Column Info
	 * @return actCustNm
	 */
	public String getActCustNm() {
		return this.actCustNm;
	}
	
	/**
	 * Column Info
	 * @return motTrfRmk
	 */
	public String getMotTrfRmk() {
		return this.motTrfRmk;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	

	/**
	 * Column Info
	 * @param bkgSrcTpCd
	 */
	public void setBkgSrcTpCd(String bkgSrcTpCd) {
		this.bkgSrcTpCd = bkgSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @param dnfcAmt
	 */
	public void setDnfcAmt(String dnfcAmt) {
		this.dnfcAmt = dnfcAmt;
	}
	
	/**
	 * Column Info
	 * @param motFilePstRlyPortCd
	 */
	public void setMotFilePstRlyPortCd(String motFilePstRlyPortCd) {
		this.motFilePstRlyPortCd = motFilePstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param stfAmt
	 */
	public void setStfAmt(String stfAmt) {
		this.stfAmt = stfAmt;
	}
	
	/**
	 * Column Info
	 * @param oensAmt
	 */
	public void setOensAmt(String oensAmt) {
		this.oensAmt = oensAmt;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @param lbpAmt
	 */
	public void setLbpAmt(String lbpAmt) {
		this.lbpAmt = lbpAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrSz
	 */
	public void setCntrSz(String cntrSz) {
		this.cntrSz = cntrSz;
	}
	
	/**
	 * Column Info
	 * @param docpAmt
	 */
	public void setDocpAmt(String docpAmt) {
		this.docpAmt = docpAmt;
	}
	
	/**
	 * Column Info
	 * @param motFilePreRlyPortCd
	 */
	public void setMotFilePreRlyPortCd(String motFilePreRlyPortCd) {
		this.motFilePreRlyPortCd = motFilePreRlyPortCd;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param fOrgCd
	 */
	public void setFOrgCd(String fOrgCd) {
		this.fOrgCd = fOrgCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param cmdtTp
	 */
	public void setCmdtTp(String cmdtTp) {
		this.cmdtTp = cmdtTp;
	}
	
	/**
	 * Column Info
	 * @param eicAmt
	 */
	public void setEicAmt(String eicAmt) {
		this.eicAmt = eicAmt;
	}
	
	/**
	 * Column Info
	 * @param blnk1
	 */
	public void setBlnk1(String blnk1) {
		this.blnk1 = blnk1;
	}
	
	/**
	 * Column Info
	 * @param tgohAmt
	 */
	public void setTgohAmt(String tgohAmt) {
		this.tgohAmt = tgohAmt;
	}
	
	/**
	 * Column Info
	 * @param fCmdtTpCd
	 */
	public void setFCmdtTpCd(String fCmdtTpCd) {
		this.fCmdtTpCd = fCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param oeicAmt
	 */
	public void setOeicAmt(String oeicAmt) {
		this.oeicAmt = oeicAmt;
	}
	
	/**
	 * Column Info
	 * @param fCntrTpCd
	 */
	public void setFCntrTpCd(String fCntrTpCd) {
		this.fCntrTpCd = fCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param carrier
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	/**
	 * Column Info
	 * @param blrAmt
	 */
	public void setBlrAmt(String blrAmt) {
		this.blrAmt = blrAmt;
	}
	
	/**
	 * Column Info
	 * @param motTrfDestCd
	 */
	public void setMotTrfDestCd(String motTrfDestCd) {
		this.motTrfDestCd = motTrfDestCd;
	}
	
	/**
	 * Column Info
	 * @param dthcAmt
	 */
	public void setDthcAmt(String dthcAmt) {
		this.dthcAmt = dthcAmt;
	}
	
	/**
	 * Column Info
	 * @param ddtsAmt
	 */
	public void setDdtsAmt(String ddtsAmt) {
		this.ddtsAmt = ddtsAmt;
	}
	
	/**
	 * Column Info
	 * @param motTrfCntrTpCd
	 */
	public void setMotTrfCntrTpCd(String motTrfCntrTpCd) {
		this.motTrfCntrTpCd = motTrfCntrTpCd;
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
	 * @param motTrfRtAmt
	 */
	public void setMotTrfRtAmt(String motTrfRtAmt) {
		this.motTrfRtAmt = motTrfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param motFileLaneCd
	 */
	public void setMotFileLaneCd(String motFileLaneCd) {
		this.motFileLaneCd = motFileLaneCd;
	}
	
	/**
	 * Column Info
	 * @param toFileDt
	 */
	public void setToFileDt(String toFileDt) {
		this.toFileDt = toFileDt;
	}
	
	/**
	 * Column Info
	 * @param dactAmt
	 */
	public void setDactAmt(String dactAmt) {
		this.dactAmt = dactAmt;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param ocmsAmt
	 */
	public void setOcmsAmt(String ocmsAmt) {
		this.ocmsAmt = ocmsAmt;
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
	 * @param tdisAmt
	 */
	public void setTdisAmt(String tdisAmt) {
		this.tdisAmt = tdisAmt;
	}
	
	/**
	 * Column Info
	 * @param bucAmt
	 */
	public void setBucAmt(String bucAmt) {
		this.bucAmt = bucAmt;
	}
	
	/**
	 * Column Info
	 * @param pscAmt
	 */
	public void setPscAmt(String pscAmt) {
		this.pscAmt = pscAmt;
	}
	
	/**
	 * Column Info
	 * @param odcsAmt
	 */
	public void setOdcsAmt(String odcsAmt) {
		this.odcsAmt = odcsAmt;
	}
	
	/**
	 * Column Info
	 * @param ddcsAmt
	 */
	public void setDdcsAmt(String ddcsAmt) {
		this.ddcsAmt = ddcsAmt;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
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
	 * @param twscAmt
	 */
	public void setTwscAmt(String twscAmt) {
		this.twscAmt = twscAmt;
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
	 * @param cafAmt
	 */
	public void setCafAmt(String cafAmt) {
		this.cafAmt = cafAmt;
	}
	
	/**
	 * Column Info
	 * @param batExeDt
	 */
	public void setBatExeDt(String batExeDt) {
		this.batExeDt = batExeDt;
	}
	
	/**
	 * Column Info
	 * @param dddcAmt
	 */
	public void setDddcAmt(String dddcAmt) {
		this.dddcAmt = dddcAmt;
	}
	
	/**
	 * Column Info
	 * @param bccAmt
	 */
	public void setBccAmt(String bccAmt) {
		this.bccAmt = bccAmt;
	}
	
	/**
	 * Column Info
	 * @param oobsAmt
	 */
	public void setOobsAmt(String oobsAmt) {
		this.oobsAmt = oobsAmt;
	}
	
	/**
	 * Column Info
	 * @param odhfAmt
	 */
	public void setOdhfAmt(String odhfAmt) {
		this.odhfAmt = odhfAmt;
	}
	
	/**
	 * Column Info
	 * @param execDt
	 */
	public void setExecDt(String execDt) {
		this.execDt = execDt;
	}
	
	/**
	 * Column Info
	 * @param othcAmt
	 */
	public void setOthcAmt(String othcAmt) {
		this.othcAmt = othcAmt;
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
	 * @param fLaneCd
	 */
	public void setFLaneCd(String fLaneCd) {
		this.fLaneCd = fLaneCd;
	}
	
	/**
	 * Column Info
	 * @param motFileDeTermCd
	 */
	public void setMotFileDeTermCd(String motFileDeTermCd) {
		this.motFileDeTermCd = motFileDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param obsAmt
	 */
	public void setObsAmt(String obsAmt) {
		this.obsAmt = obsAmt;
	}
	
	/**
	 * Column Info
	 * @param fDestCd
	 */
	public void setFDestCd(String fDestCd) {
		this.fDestCd = fDestCd;
	}
	
	/**
	 * Column Info
	 * @param testExecDt
	 */
	public void setTestExecDt(String testExecDt) {
		this.testExecDt = testExecDt;
	}
	
	/**
	 * Column Info
	 * @param motTrfOrgCd
	 */
	public void setMotTrfOrgCd(String motTrfOrgCd) {
		this.motTrfOrgCd = motTrfOrgCd;
	}
	
	/**
	 * Column Info
	 * @param pccAmt
	 */
	public void setPccAmt(String pccAmt) {
		this.pccAmt = pccAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgDirCallFlg
	 */
	public void setBkgDirCallFlg(String bkgDirCallFlg) {
		this.bkgDirCallFlg = bkgDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param odAmt
	 */
	public void setOdAmt(String odAmt) {
		this.odAmt = odAmt;
	}
	
	/**
	 * Column Info
	 * @param inqTpCd
	 */
	public void setInqTpCd(String inqTpCd) {
		this.inqTpCd = inqTpCd;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param bafAmt
	 */
	public void setBafAmt(String bafAmt) {
		this.bafAmt = bafAmt;
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
	 * @param fCntrSzCd
	 */
	public void setFCntrSzCd(String fCntrSzCd) {
		this.fCntrSzCd = fCntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param motTrfCmdtTpCd
	 */
	public void setMotTrfCmdtTpCd(String motTrfCmdtTpCd) {
		this.motTrfCmdtTpCd = motTrfCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param lsiAmt
	 */
	public void setLsiAmt(String lsiAmt) {
		this.lsiAmt = lsiAmt;
	}
	
	/**
	 * Column Info
	 * @param motTrfCntrSzCd
	 */
	public void setMotTrfCntrSzCd(String motTrfCntrSzCd) {
		this.motTrfCntrSzCd = motTrfCntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param ctcAmt
	 */
	public void setCtcAmt(String ctcAmt) {
		this.ctcAmt = ctcAmt;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param mqc1
	 */
	public void setMqc1(String mqc1) {
		this.mqc1 = mqc1;
	}
	
	/**
	 * Column Info
	 * @param motTrfChgAmt
	 */
	public void setMotTrfChgAmt(String motTrfChgAmt) {
		this.motTrfChgAmt = motTrfChgAmt;
	}
	
	/**
	 * Column Info
	 * @param mqc2
	 */
	public void setMqc2(String mqc2) {
		this.mqc2 = mqc2;
	}
	
	/**
	 * Column Info
	 * @param apsAmt
	 */
	public void setApsAmt(String apsAmt) {
		this.apsAmt = apsAmt;
	}
	
	/**
	 * Column Info
	 * @param ctrtHldNm
	 */
	public void setCtrtHldNm(String ctrtHldNm) {
		this.ctrtHldNm = ctrtHldNm;
	}
	
	/**
	 * Column Info
	 * @param motTrfChgCd
	 */
	public void setMotTrfChgCd(String motTrfChgCd) {
		this.motTrfChgCd = motTrfChgCd;
	}
	
	/**
	 * Column Info
	 * @param scgSeq
	 */
	public void setScgSeq(String scgSeq) {
		this.scgSeq = scgSeq;
	}
	
	/**
	 * Column Info
	 * @param oslfAmt
	 */
	public void setOslfAmt(String oslfAmt) {
		this.oslfAmt = oslfAmt;
	}
	
	/**
	 * Column Info
	 * @param frFileDt
	 */
	public void setFrFileDt(String frFileDt) {
		this.frFileDt = frFileDt;
	}
	
	/**
	 * Column Info
	 * @param oftRt
	 */
	public void setOftRt(String oftRt) {
		this.oftRt = oftRt;
	}
	
	/**
	 * Column Info
	 * @param motFileIbPortCd
	 */
	public void setMotFileIbPortCd(String motFileIbPortCd) {
		this.motFileIbPortCd = motFileIbPortCd;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param dddfAmt
	 */
	public void setDddfAmt(String dddfAmt) {
		this.dddfAmt = dddfAmt;
	}
	
	/**
	 * Column Info
	 * @param pcsAmt
	 */
	public void setPcsAmt(String pcsAmt) {
		this.pcsAmt = pcsAmt;
	}
	
	/**
	 * Column Info
	 * @param motFileTsPortCd
	 */
	public void setMotFileTsPortCd(String motFileTsPortCd) {
		this.motFileTsPortCd = motFileTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param motTrfSeq
	 */
	public void setMotTrfSeq(String motTrfSeq) {
		this.motTrfSeq = motTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrTp
	 */
	public void setCntrTp(String cntrTp) {
		this.cntrTp = cntrTp;
	}
	
	/**
	 * Column Info
	 * @param actCustNm
	 */
	public void setActCustNm(String actCustNm) {
		this.actCustNm = actCustNm;
	}
	
	/**
	 * Column Info
	 * @param motTrfRmk
	 */
	public void setMotTrfRmk(String motTrfRmk) {
		this.motTrfRmk = motTrfRmk;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
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
		setBkgSrcTpCd(JSPUtil.getParameter(request, prefix + "bkg_src_tp_cd", ""));
		setDnfcAmt(JSPUtil.getParameter(request, prefix + "dnfc_amt", ""));
		setMotFilePstRlyPortCd(JSPUtil.getParameter(request, prefix + "mot_file_pst_rly_port_cd", ""));
		setStfAmt(JSPUtil.getParameter(request, prefix + "stf_amt", ""));
		setOensAmt(JSPUtil.getParameter(request, prefix + "oens_amt", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setLbpAmt(JSPUtil.getParameter(request, prefix + "lbp_amt", ""));
		setCntrSz(JSPUtil.getParameter(request, prefix + "cntr_sz", ""));
		setDocpAmt(JSPUtil.getParameter(request, prefix + "docp_amt", ""));
		setMotFilePreRlyPortCd(JSPUtil.getParameter(request, prefix + "mot_file_pre_rly_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setFOrgCd(JSPUtil.getParameter(request, prefix + "f_org_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCmdtTp(JSPUtil.getParameter(request, prefix + "cmdt_tp", ""));
		setEicAmt(JSPUtil.getParameter(request, prefix + "eic_amt", ""));
		setBlnk1(JSPUtil.getParameter(request, prefix + "blnk1", ""));
		setTgohAmt(JSPUtil.getParameter(request, prefix + "tgoh_amt", ""));
		setFCmdtTpCd(JSPUtil.getParameter(request, prefix + "f_cmdt_tp_cd", ""));
		setOeicAmt(JSPUtil.getParameter(request, prefix + "oeic_amt", ""));
		setFCntrTpCd(JSPUtil.getParameter(request, prefix + "f_cntr_tp_cd", ""));
		setCarrier(JSPUtil.getParameter(request, prefix + "carrier", ""));
		setBlrAmt(JSPUtil.getParameter(request, prefix + "blr_amt", ""));
		setMotTrfDestCd(JSPUtil.getParameter(request, prefix + "mot_trf_dest_cd", ""));
		setDthcAmt(JSPUtil.getParameter(request, prefix + "dthc_amt", ""));
		setDdtsAmt(JSPUtil.getParameter(request, prefix + "ddts_amt", ""));
		setMotTrfCntrTpCd(JSPUtil.getParameter(request, prefix + "mot_trf_cntr_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMotTrfRtAmt(JSPUtil.getParameter(request, prefix + "mot_trf_rt_amt", ""));
		setMotFileLaneCd(JSPUtil.getParameter(request, prefix + "mot_file_lane_cd", ""));
		setToFileDt(JSPUtil.getParameter(request, prefix + "to_file_dt", ""));
		setDactAmt(JSPUtil.getParameter(request, prefix + "dact_amt", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setOcmsAmt(JSPUtil.getParameter(request, prefix + "ocms_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTdisAmt(JSPUtil.getParameter(request, prefix + "tdis_amt", ""));
		setBucAmt(JSPUtil.getParameter(request, prefix + "buc_amt", ""));
		setPscAmt(JSPUtil.getParameter(request, prefix + "psc_amt", ""));
		setOdcsAmt(JSPUtil.getParameter(request, prefix + "odcs_amt", ""));
		setDdcsAmt(JSPUtil.getParameter(request, prefix + "ddcs_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTwscAmt(JSPUtil.getParameter(request, prefix + "twsc_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCafAmt(JSPUtil.getParameter(request, prefix + "caf_amt", ""));
		setBatExeDt(JSPUtil.getParameter(request, prefix + "bat_exe_dt", ""));
		setDddcAmt(JSPUtil.getParameter(request, prefix + "dddc_amt", ""));
		setBccAmt(JSPUtil.getParameter(request, prefix + "bcc_amt", ""));
		setOobsAmt(JSPUtil.getParameter(request, prefix + "oobs_amt", ""));
		setOdhfAmt(JSPUtil.getParameter(request, prefix + "odhf_amt", ""));
		setExecDt(JSPUtil.getParameter(request, prefix + "exec_dt", ""));
		setOthcAmt(JSPUtil.getParameter(request, prefix + "othc_amt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setFLaneCd(JSPUtil.getParameter(request, prefix + "f_lane_cd", ""));
		setMotFileDeTermCd(JSPUtil.getParameter(request, prefix + "mot_file_de_term_cd", ""));
		setObsAmt(JSPUtil.getParameter(request, prefix + "obs_amt", ""));
		setFDestCd(JSPUtil.getParameter(request, prefix + "f_dest_cd", ""));
		setTestExecDt(JSPUtil.getParameter(request, prefix + "test_exec_dt", ""));
		setMotTrfOrgCd(JSPUtil.getParameter(request, prefix + "mot_trf_org_cd", ""));
		setPccAmt(JSPUtil.getParameter(request, prefix + "pcc_amt", ""));
		setBkgDirCallFlg(JSPUtil.getParameter(request, prefix + "bkg_dir_call_flg", ""));
		setOdAmt(JSPUtil.getParameter(request, prefix + "od_amt", ""));
		setInqTpCd(JSPUtil.getParameter(request, prefix + "inq_tp_cd", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setBafAmt(JSPUtil.getParameter(request, prefix + "baf_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFCntrSzCd(JSPUtil.getParameter(request, prefix + "f_cntr_sz_cd", ""));
		setMotTrfCmdtTpCd(JSPUtil.getParameter(request, prefix + "mot_trf_cmdt_tp_cd", ""));
		setLsiAmt(JSPUtil.getParameter(request, prefix + "lsi_amt", ""));
		setMotTrfCntrSzCd(JSPUtil.getParameter(request, prefix + "mot_trf_cntr_sz_cd", ""));
		setCtcAmt(JSPUtil.getParameter(request, prefix + "ctc_amt", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setMqc1(JSPUtil.getParameter(request, prefix + "mqc1", ""));
		setMotTrfChgAmt(JSPUtil.getParameter(request, prefix + "mot_trf_chg_amt", ""));
		setMqc2(JSPUtil.getParameter(request, prefix + "mqc2", ""));
		setApsAmt(JSPUtil.getParameter(request, prefix + "aps_amt", ""));
		setCtrtHldNm(JSPUtil.getParameter(request, prefix + "ctrt_hld_nm", ""));
		setMotTrfChgCd(JSPUtil.getParameter(request, prefix + "mot_trf_chg_cd", ""));
		setScgSeq(JSPUtil.getParameter(request, prefix + "scg_seq", ""));
		setOslfAmt(JSPUtil.getParameter(request, prefix + "oslf_amt", ""));
		setFrFileDt(JSPUtil.getParameter(request, prefix + "fr_file_dt", ""));
		setOftRt(JSPUtil.getParameter(request, prefix + "oft_rt", ""));
		setMotFileIbPortCd(JSPUtil.getParameter(request, prefix + "mot_file_ib_port_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setDddfAmt(JSPUtil.getParameter(request, prefix + "dddf_amt", ""));
		setPcsAmt(JSPUtil.getParameter(request, prefix + "pcs_amt", ""));
		setMotFileTsPortCd(JSPUtil.getParameter(request, prefix + "mot_file_ts_port_cd", ""));
		setMotTrfSeq(JSPUtil.getParameter(request, prefix + "mot_trf_seq", ""));
		setCntrTp(JSPUtil.getParameter(request, prefix + "cntr_tp", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setMotTrfRmk(JSPUtil.getParameter(request, prefix + "mot_trf_rmk", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchMOTSSEFilingListVO[]
	 */
	public RsltSearchMOTSSEFilingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchMOTSSEFilingListVO[]
	 */
	public RsltSearchMOTSSEFilingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchMOTSSEFilingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_src_tp_cd", length));
			String[] dnfcAmt = (JSPUtil.getParameter(request, prefix	+ "dnfc_amt", length));
			String[] motFilePstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "mot_file_pst_rly_port_cd", length));
			String[] stfAmt = (JSPUtil.getParameter(request, prefix	+ "stf_amt", length));
			String[] oensAmt = (JSPUtil.getParameter(request, prefix	+ "oens_amt", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] lbpAmt = (JSPUtil.getParameter(request, prefix	+ "lbp_amt", length));
			String[] cntrSz = (JSPUtil.getParameter(request, prefix	+ "cntr_sz", length));
			String[] docpAmt = (JSPUtil.getParameter(request, prefix	+ "docp_amt", length));
			String[] motFilePreRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "mot_file_pre_rly_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] fOrgCd = (JSPUtil.getParameter(request, prefix	+ "f_org_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] cmdtTp = (JSPUtil.getParameter(request, prefix	+ "cmdt_tp", length));
			String[] eicAmt = (JSPUtil.getParameter(request, prefix	+ "eic_amt", length));
			String[] blnk1 = (JSPUtil.getParameter(request, prefix	+ "blnk1", length));
			String[] tgohAmt = (JSPUtil.getParameter(request, prefix	+ "tgoh_amt", length));
			String[] fCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "f_cmdt_tp_cd", length));
			String[] oeicAmt = (JSPUtil.getParameter(request, prefix	+ "oeic_amt", length));
			String[] fCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tp_cd", length));
			String[] carrier = (JSPUtil.getParameter(request, prefix	+ "carrier", length));
			String[] blrAmt = (JSPUtil.getParameter(request, prefix	+ "blr_amt", length));
			String[] motTrfDestCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_dest_cd", length));
			String[] dthcAmt = (JSPUtil.getParameter(request, prefix	+ "dthc_amt", length));
			String[] ddtsAmt = (JSPUtil.getParameter(request, prefix	+ "ddts_amt", length));
			String[] motTrfCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_cntr_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] motTrfRtAmt = (JSPUtil.getParameter(request, prefix	+ "mot_trf_rt_amt", length));
			String[] motFileLaneCd = (JSPUtil.getParameter(request, prefix	+ "mot_file_lane_cd", length));
			String[] toFileDt = (JSPUtil.getParameter(request, prefix	+ "to_file_dt", length));
			String[] dactAmt = (JSPUtil.getParameter(request, prefix	+ "dact_amt", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] ocmsAmt = (JSPUtil.getParameter(request, prefix	+ "ocms_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] tdisAmt = (JSPUtil.getParameter(request, prefix	+ "tdis_amt", length));
			String[] bucAmt = (JSPUtil.getParameter(request, prefix	+ "buc_amt", length));
			String[] pscAmt = (JSPUtil.getParameter(request, prefix	+ "psc_amt", length));
			String[] odcsAmt = (JSPUtil.getParameter(request, prefix	+ "odcs_amt", length));
			String[] ddcsAmt = (JSPUtil.getParameter(request, prefix	+ "ddcs_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] twscAmt = (JSPUtil.getParameter(request, prefix	+ "twsc_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cafAmt = (JSPUtil.getParameter(request, prefix	+ "caf_amt", length));
			String[] batExeDt = (JSPUtil.getParameter(request, prefix	+ "bat_exe_dt", length));
			String[] dddcAmt = (JSPUtil.getParameter(request, prefix	+ "dddc_amt", length));
			String[] bccAmt = (JSPUtil.getParameter(request, prefix	+ "bcc_amt", length));
			String[] oobsAmt = (JSPUtil.getParameter(request, prefix	+ "oobs_amt", length));
			String[] odhfAmt = (JSPUtil.getParameter(request, prefix	+ "odhf_amt", length));
			String[] execDt = (JSPUtil.getParameter(request, prefix	+ "exec_dt", length));
			String[] othcAmt = (JSPUtil.getParameter(request, prefix	+ "othc_amt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fLaneCd = (JSPUtil.getParameter(request, prefix	+ "f_lane_cd", length));
			String[] motFileDeTermCd = (JSPUtil.getParameter(request, prefix	+ "mot_file_de_term_cd", length));
			String[] obsAmt = (JSPUtil.getParameter(request, prefix	+ "obs_amt", length));
			String[] fDestCd = (JSPUtil.getParameter(request, prefix	+ "f_dest_cd", length));
			String[] testExecDt = (JSPUtil.getParameter(request, prefix	+ "test_exec_dt", length));
			String[] motTrfOrgCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_org_cd", length));
			String[] pccAmt = (JSPUtil.getParameter(request, prefix	+ "pcc_amt", length));
			String[] bkgDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_dir_call_flg", length));
			String[] odAmt = (JSPUtil.getParameter(request, prefix	+ "od_amt", length));
			String[] inqTpCd = (JSPUtil.getParameter(request, prefix	+ "inq_tp_cd", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] bafAmt = (JSPUtil.getParameter(request, prefix	+ "baf_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCntrSzCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_sz_cd", length));
			String[] motTrfCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_cmdt_tp_cd", length));
			String[] lsiAmt = (JSPUtil.getParameter(request, prefix	+ "lsi_amt", length));
			String[] motTrfCntrSzCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_cntr_sz_cd", length));
			String[] ctcAmt = (JSPUtil.getParameter(request, prefix	+ "ctc_amt", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] mqc1 = (JSPUtil.getParameter(request, prefix	+ "mqc1", length));
			String[] motTrfChgAmt = (JSPUtil.getParameter(request, prefix	+ "mot_trf_chg_amt", length));
			String[] mqc2 = (JSPUtil.getParameter(request, prefix	+ "mqc2", length));
			String[] apsAmt = (JSPUtil.getParameter(request, prefix	+ "aps_amt", length));
			String[] ctrtHldNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_hld_nm", length));
			String[] motTrfChgCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_chg_cd", length));
			String[] scgSeq = (JSPUtil.getParameter(request, prefix	+ "scg_seq", length));
			String[] oslfAmt = (JSPUtil.getParameter(request, prefix	+ "oslf_amt", length));
			String[] frFileDt = (JSPUtil.getParameter(request, prefix	+ "fr_file_dt", length));
			String[] oftRt = (JSPUtil.getParameter(request, prefix	+ "oft_rt", length));
			String[] motFileIbPortCd = (JSPUtil.getParameter(request, prefix	+ "mot_file_ib_port_cd", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] dddfAmt = (JSPUtil.getParameter(request, prefix	+ "dddf_amt", length));
			String[] pcsAmt = (JSPUtil.getParameter(request, prefix	+ "pcs_amt", length));
			String[] motFileTsPortCd = (JSPUtil.getParameter(request, prefix	+ "mot_file_ts_port_cd", length));
			String[] motTrfSeq = (JSPUtil.getParameter(request, prefix	+ "mot_trf_seq", length));
			String[] cntrTp = (JSPUtil.getParameter(request, prefix	+ "cntr_tp", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] motTrfRmk = (JSPUtil.getParameter(request, prefix	+ "mot_trf_rmk", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchMOTSSEFilingListVO();
				if (bkgSrcTpCd[i] != null)
					model.setBkgSrcTpCd(bkgSrcTpCd[i]);
				if (dnfcAmt[i] != null)
					model.setDnfcAmt(dnfcAmt[i]);
				if (motFilePstRlyPortCd[i] != null)
					model.setMotFilePstRlyPortCd(motFilePstRlyPortCd[i]);
				if (stfAmt[i] != null)
					model.setStfAmt(stfAmt[i]);
				if (oensAmt[i] != null)
					model.setOensAmt(oensAmt[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (lbpAmt[i] != null)
					model.setLbpAmt(lbpAmt[i]);
				if (cntrSz[i] != null)
					model.setCntrSz(cntrSz[i]);
				if (docpAmt[i] != null)
					model.setDocpAmt(docpAmt[i]);
				if (motFilePreRlyPortCd[i] != null)
					model.setMotFilePreRlyPortCd(motFilePreRlyPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (fOrgCd[i] != null)
					model.setFOrgCd(fOrgCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cmdtTp[i] != null)
					model.setCmdtTp(cmdtTp[i]);
				if (eicAmt[i] != null)
					model.setEicAmt(eicAmt[i]);
				if (blnk1[i] != null)
					model.setBlnk1(blnk1[i]);
				if (tgohAmt[i] != null)
					model.setTgohAmt(tgohAmt[i]);
				if (fCmdtTpCd[i] != null)
					model.setFCmdtTpCd(fCmdtTpCd[i]);
				if (oeicAmt[i] != null)
					model.setOeicAmt(oeicAmt[i]);
				if (fCntrTpCd[i] != null)
					model.setFCntrTpCd(fCntrTpCd[i]);
				if (carrier[i] != null)
					model.setCarrier(carrier[i]);
				if (blrAmt[i] != null)
					model.setBlrAmt(blrAmt[i]);
				if (motTrfDestCd[i] != null)
					model.setMotTrfDestCd(motTrfDestCd[i]);
				if (dthcAmt[i] != null)
					model.setDthcAmt(dthcAmt[i]);
				if (ddtsAmt[i] != null)
					model.setDdtsAmt(ddtsAmt[i]);
				if (motTrfCntrTpCd[i] != null)
					model.setMotTrfCntrTpCd(motTrfCntrTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (motTrfRtAmt[i] != null)
					model.setMotTrfRtAmt(motTrfRtAmt[i]);
				if (motFileLaneCd[i] != null)
					model.setMotFileLaneCd(motFileLaneCd[i]);
				if (toFileDt[i] != null)
					model.setToFileDt(toFileDt[i]);
				if (dactAmt[i] != null)
					model.setDactAmt(dactAmt[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (ocmsAmt[i] != null)
					model.setOcmsAmt(ocmsAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (tdisAmt[i] != null)
					model.setTdisAmt(tdisAmt[i]);
				if (bucAmt[i] != null)
					model.setBucAmt(bucAmt[i]);
				if (pscAmt[i] != null)
					model.setPscAmt(pscAmt[i]);
				if (odcsAmt[i] != null)
					model.setOdcsAmt(odcsAmt[i]);
				if (ddcsAmt[i] != null)
					model.setDdcsAmt(ddcsAmt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (twscAmt[i] != null)
					model.setTwscAmt(twscAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cafAmt[i] != null)
					model.setCafAmt(cafAmt[i]);
				if (batExeDt[i] != null)
					model.setBatExeDt(batExeDt[i]);
				if (dddcAmt[i] != null)
					model.setDddcAmt(dddcAmt[i]);
				if (bccAmt[i] != null)
					model.setBccAmt(bccAmt[i]);
				if (oobsAmt[i] != null)
					model.setOobsAmt(oobsAmt[i]);
				if (odhfAmt[i] != null)
					model.setOdhfAmt(odhfAmt[i]);
				if (execDt[i] != null)
					model.setExecDt(execDt[i]);
				if (othcAmt[i] != null)
					model.setOthcAmt(othcAmt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fLaneCd[i] != null)
					model.setFLaneCd(fLaneCd[i]);
				if (motFileDeTermCd[i] != null)
					model.setMotFileDeTermCd(motFileDeTermCd[i]);
				if (obsAmt[i] != null)
					model.setObsAmt(obsAmt[i]);
				if (fDestCd[i] != null)
					model.setFDestCd(fDestCd[i]);
				if (testExecDt[i] != null)
					model.setTestExecDt(testExecDt[i]);
				if (motTrfOrgCd[i] != null)
					model.setMotTrfOrgCd(motTrfOrgCd[i]);
				if (pccAmt[i] != null)
					model.setPccAmt(pccAmt[i]);
				if (bkgDirCallFlg[i] != null)
					model.setBkgDirCallFlg(bkgDirCallFlg[i]);
				if (odAmt[i] != null)
					model.setOdAmt(odAmt[i]);
				if (inqTpCd[i] != null)
					model.setInqTpCd(inqTpCd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (bafAmt[i] != null)
					model.setBafAmt(bafAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCntrSzCd[i] != null)
					model.setFCntrSzCd(fCntrSzCd[i]);
				if (motTrfCmdtTpCd[i] != null)
					model.setMotTrfCmdtTpCd(motTrfCmdtTpCd[i]);
				if (lsiAmt[i] != null)
					model.setLsiAmt(lsiAmt[i]);
				if (motTrfCntrSzCd[i] != null)
					model.setMotTrfCntrSzCd(motTrfCntrSzCd[i]);
				if (ctcAmt[i] != null)
					model.setCtcAmt(ctcAmt[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (mqc1[i] != null)
					model.setMqc1(mqc1[i]);
				if (motTrfChgAmt[i] != null)
					model.setMotTrfChgAmt(motTrfChgAmt[i]);
				if (mqc2[i] != null)
					model.setMqc2(mqc2[i]);
				if (apsAmt[i] != null)
					model.setApsAmt(apsAmt[i]);
				if (ctrtHldNm[i] != null)
					model.setCtrtHldNm(ctrtHldNm[i]);
				if (motTrfChgCd[i] != null)
					model.setMotTrfChgCd(motTrfChgCd[i]);
				if (scgSeq[i] != null)
					model.setScgSeq(scgSeq[i]);
				if (oslfAmt[i] != null)
					model.setOslfAmt(oslfAmt[i]);
				if (frFileDt[i] != null)
					model.setFrFileDt(frFileDt[i]);
				if (oftRt[i] != null)
					model.setOftRt(oftRt[i]);
				if (motFileIbPortCd[i] != null)
					model.setMotFileIbPortCd(motFileIbPortCd[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (dddfAmt[i] != null)
					model.setDddfAmt(dddfAmt[i]);
				if (pcsAmt[i] != null)
					model.setPcsAmt(pcsAmt[i]);
				if (motFileTsPortCd[i] != null)
					model.setMotFileTsPortCd(motFileTsPortCd[i]);
				if (motTrfSeq[i] != null)
					model.setMotTrfSeq(motTrfSeq[i]);
				if (cntrTp[i] != null)
					model.setCntrTp(cntrTp[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (motTrfRmk[i] != null)
					model.setMotTrfRmk(motTrfRmk[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchMOTSSEFilingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchMOTSSEFilingListVO[]
	 */
	public RsltSearchMOTSSEFilingListVO[] getRsltSearchMOTSSEFilingListVOs(){
		RsltSearchMOTSSEFilingListVO[] vos = (RsltSearchMOTSSEFilingListVO[])models.toArray(new RsltSearchMOTSSEFilingListVO[models.size()]);
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
		this.bkgSrcTpCd = this.bkgSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnfcAmt = this.dnfcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motFilePstRlyPortCd = this.motFilePstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stfAmt = this.stfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oensAmt = this.oensAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbpAmt = this.lbpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz = this.cntrSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docpAmt = this.docpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motFilePreRlyPortCd = this.motFilePreRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOrgCd = this.fOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTp = this.cmdtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eicAmt = this.eicAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnk1 = this.blnk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgohAmt = this.tgohAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmdtTpCd = this.fCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oeicAmt = this.oeicAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpCd = this.fCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrier = this.carrier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrAmt = this.blrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfDestCd = this.motTrfDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dthcAmt = this.dthcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddtsAmt = this.ddtsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfCntrTpCd = this.motTrfCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfRtAmt = this.motTrfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motFileLaneCd = this.motFileLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toFileDt = this.toFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dactAmt = this.dactAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocmsAmt = this.ocmsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tdisAmt = this.tdisAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucAmt = this.bucAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscAmt = this.pscAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odcsAmt = this.odcsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddcsAmt = this.ddcsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twscAmt = this.twscAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cafAmt = this.cafAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batExeDt = this.batExeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dddcAmt = this.dddcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bccAmt = this.bccAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oobsAmt = this.oobsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odhfAmt = this.odhfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.execDt = this.execDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othcAmt = this.othcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLaneCd = this.fLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motFileDeTermCd = this.motFileDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obsAmt = this.obsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDestCd = this.fDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.testExecDt = this.testExecDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfOrgCd = this.motTrfOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pccAmt = this.pccAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDirCallFlg = this.bkgDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odAmt = this.odAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqTpCd = this.inqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bafAmt = this.bafAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrSzCd = this.fCntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfCmdtTpCd = this.motTrfCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiAmt = this.lsiAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfCntrSzCd = this.motTrfCntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctcAmt = this.ctcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqc1 = this.mqc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfChgAmt = this.motTrfChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqc2 = this.mqc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apsAmt = this.apsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtHldNm = this.ctrtHldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfChgCd = this.motTrfChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgSeq = this.scgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oslfAmt = this.oslfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frFileDt = this.frFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftRt = this.oftRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motFileIbPortCd = this.motFileIbPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dddfAmt = this.dddfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcsAmt = this.pcsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motFileTsPortCd = this.motFileTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfSeq = this.motTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp = this.cntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfRmk = this.motTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
