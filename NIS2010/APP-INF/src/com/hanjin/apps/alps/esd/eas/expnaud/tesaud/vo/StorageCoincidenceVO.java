/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StorageCoincidenceVO.java
*@FileTitle : StorageCoincidenceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo;

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

public class StorageCoincidenceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StorageCoincidenceVO> models = new ArrayList<StorageCoincidenceVO>();
	
	/* Column Info */
	private String vrfyRsltIndCd = null;
	/* Column Info */
	private String invGateInDt = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String tmlInvTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tmlSoCntrListSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String dcgoClssCd = null;
	/* Column Info */
	private String invDateType = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String dscrIndCd = null;
	/* Column Info */
	private String mvmtGateOutDt = null;
	/* Column Info */
	private String preYdCd = null;
	/* Column Info */
	private String loclTsIndCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hndlRsltRmk = null;
	/* Column Info */
	private String tmlRvisIndFlg = null;
	/* Column Info */
	private String railBilDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String tmlSoSeq = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String mvmtStayDys = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String mvmtGateInDt = null;
	/* Column Info */
	private String invStayDys = null;
	/* Column Info */
	private String modiFlg = null;
	/* Column Info */
	private String gateOutTdDys = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String dscrRsn = null;
	/* Column Info */
	private String rcvdeTermIndCd = null;
	/* Column Info */
	private String atbDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gateInTdDys = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String wrkDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String samLoclTsIndCd = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String clmDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String invGateOutDt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String stayDiffDys = null;
	/* Column Info */
	private String cntrStyCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String tmlInvStsCd = null;
	/* Column Info */
	private String cntrRmk = null;
	/* Column Info */
	private String tmlSoOfcCtyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StorageCoincidenceVO() {}

	public StorageCoincidenceVO(String ibflag, String pagerows, String vrfyRsltIndCd, String invGateInDt, String rowCount, String tmlInvTpCd, String tmlSoCntrListSeq, String cntrTpszCd, String fmPrdDt, String updUsrId, String rhq, String awkCgoFlg, String dcgoClssCd, String invDateType, String dscrIndCd, String mvmtGateOutDt, String preYdCd, String creUsrId, String loclTsIndCd, String hndlRsltRmk, String tmlRvisIndFlg, String pageNo, String vndrSeq, String railBilDt, String tmlSoSeq, String rcFlg, String rowNum, String mvmtStayDys, String laneCd, String mvmtGateInDt, String invStayDys, String modiFlg, String gateOutTdDys, String creDt, String vndrLglEngNm, String dscrRsn, String rcvdeTermIndCd, String atbDt, String gateInTdDys, String bbCgoFlg, String wrkDt, String invOfcCd, String updDt, String iocCd, String costOfcCd, String samLoclTsIndCd, String toPrdDt, String clmDt, String ioBndCd, String invNo, String invGateOutDt, String stayDiffDys, String ydCd, String cntrStyCd, String tmlInvStsCd, String cntrNo, String cntrRmk, String tmlSoOfcCtyCd, String creUsrNm) {
		this.vrfyRsltIndCd = vrfyRsltIndCd;
		this.invGateInDt = invGateInDt;
		this.rowCount = rowCount;
		this.tmlInvTpCd = tmlInvTpCd;
		this.pagerows = pagerows;
		this.tmlSoCntrListSeq = tmlSoCntrListSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.fmPrdDt = fmPrdDt;
		this.updUsrId = updUsrId;
		this.rhq = rhq;
		this.awkCgoFlg = awkCgoFlg;
		this.dcgoClssCd = dcgoClssCd;
		this.invDateType = invDateType;
		this.creUsrNm = creUsrNm;
		this.dscrIndCd = dscrIndCd;
		this.mvmtGateOutDt = mvmtGateOutDt;
		this.preYdCd = preYdCd;
		this.loclTsIndCd = loclTsIndCd;
		this.creUsrId = creUsrId;
		this.hndlRsltRmk = hndlRsltRmk;
		this.tmlRvisIndFlg = tmlRvisIndFlg;
		this.railBilDt = railBilDt;
		this.vndrSeq = vndrSeq;
		this.pageNo = pageNo;
		this.tmlSoSeq = tmlSoSeq;
		this.rcFlg = rcFlg;
		this.rowNum = rowNum;
		this.mvmtStayDys = mvmtStayDys;
		this.laneCd = laneCd;
		this.mvmtGateInDt = mvmtGateInDt;
		this.invStayDys = invStayDys;
		this.modiFlg = modiFlg;
		this.gateOutTdDys = gateOutTdDys;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.dscrRsn = dscrRsn;
		this.rcvdeTermIndCd = rcvdeTermIndCd;
		this.atbDt = atbDt;
		this.ibflag = ibflag;
		this.gateInTdDys = gateInTdDys;
		this.bbCgoFlg = bbCgoFlg;
		this.wrkDt = wrkDt;
		this.invOfcCd = invOfcCd;
		this.updDt = updDt;
		this.iocCd = iocCd;
		this.costOfcCd = costOfcCd;
		this.samLoclTsIndCd = samLoclTsIndCd;
		this.toPrdDt = toPrdDt;
		this.clmDt = clmDt;
		this.ioBndCd = ioBndCd;
		this.invGateOutDt = invGateOutDt;
		this.invNo = invNo;
		this.stayDiffDys = stayDiffDys;
		this.cntrStyCd = cntrStyCd;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.tmlInvStsCd = tmlInvStsCd;
		this.cntrRmk = cntrRmk;
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vrfy_rslt_ind_cd", getVrfyRsltIndCd());
		this.hashColumns.put("inv_gate_in_dt", getInvGateInDt());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tml_so_cntr_list_seq", getTmlSoCntrListSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("dcgo_clss_cd", getDcgoClssCd());
		this.hashColumns.put("inv_date_type", getInvDateType());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("dscr_ind_cd", getDscrIndCd());
		this.hashColumns.put("mvmt_gate_out_dt", getMvmtGateOutDt());
		this.hashColumns.put("pre_yd_cd", getPreYdCd());
		this.hashColumns.put("locl_ts_ind_cd", getLoclTsIndCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("hndl_rslt_rmk", getHndlRsltRmk());
		this.hashColumns.put("tml_rvis_ind_flg", getTmlRvisIndFlg());
		this.hashColumns.put("rail_bil_dt", getRailBilDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("mvmt_stay_dys", getMvmtStayDys());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("mvmt_gate_in_dt", getMvmtGateInDt());
		this.hashColumns.put("inv_stay_dys", getInvStayDys());
		this.hashColumns.put("modi_flg", getModiFlg());
		this.hashColumns.put("gate_out_td_dys", getGateOutTdDys());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("dscr_rsn", getDscrRsn());
		this.hashColumns.put("rcvde_term_ind_cd", getRcvdeTermIndCd());
		this.hashColumns.put("atb_dt", getAtbDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gate_in_td_dys", getGateInTdDys());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("wrk_dt", getWrkDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("sam_locl_ts_ind_cd", getSamLoclTsIndCd());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("clm_dt", getClmDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("inv_gate_out_dt", getInvGateOutDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("stay_diff_dys", getStayDiffDys());
		this.hashColumns.put("cntr_sty_cd", getCntrStyCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("tml_inv_sts_cd", getTmlInvStsCd());
		this.hashColumns.put("cntr_rmk", getCntrRmk());
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vrfy_rslt_ind_cd", "vrfyRsltIndCd");
		this.hashFields.put("inv_gate_in_dt", "invGateInDt");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tml_so_cntr_list_seq", "tmlSoCntrListSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("dcgo_clss_cd", "dcgoClssCd");
		this.hashFields.put("inv_date_type", "invDateType");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("dscr_ind_cd", "dscrIndCd");
		this.hashFields.put("mvmt_gate_out_dt", "mvmtGateOutDt");
		this.hashFields.put("pre_yd_cd", "preYdCd");
		this.hashFields.put("locl_ts_ind_cd", "loclTsIndCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("hndl_rslt_rmk", "hndlRsltRmk");
		this.hashFields.put("tml_rvis_ind_flg", "tmlRvisIndFlg");
		this.hashFields.put("rail_bil_dt", "railBilDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("mvmt_stay_dys", "mvmtStayDys");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("mvmt_gate_in_dt", "mvmtGateInDt");
		this.hashFields.put("inv_stay_dys", "invStayDys");
		this.hashFields.put("modi_flg", "modiFlg");
		this.hashFields.put("gate_out_td_dys", "gateOutTdDys");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("dscr_rsn", "dscrRsn");
		this.hashFields.put("rcvde_term_ind_cd", "rcvdeTermIndCd");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gate_in_td_dys", "gateInTdDys");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("wrk_dt", "wrkDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("sam_locl_ts_ind_cd", "samLoclTsIndCd");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("clm_dt", "clmDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("inv_gate_out_dt", "invGateOutDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("stay_diff_dys", "stayDiffDys");
		this.hashFields.put("cntr_sty_cd", "cntrStyCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("tml_inv_sts_cd", "tmlInvStsCd");
		this.hashFields.put("cntr_rmk", "cntrRmk");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vrfyRsltIndCd
	 */
	public String getVrfyRsltIndCd() {
		return this.vrfyRsltIndCd;
	}
	
	/**
	 * Column Info
	 * @return invGateInDt
	 */
	public String getInvGateInDt() {
		return this.invGateInDt;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return tmlInvTpCd
	 */
	public String getTmlInvTpCd() {
		return this.tmlInvTpCd;
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
	 * @return tmlSoCntrListSeq
	 */
	public String getTmlSoCntrListSeq() {
		return this.tmlSoCntrListSeq;
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
	 * @return fmPrdDt
	 */
	public String getFmPrdDt() {
		return this.fmPrdDt;
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
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
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
	 * @return dcgoClssCd
	 */
	public String getDcgoClssCd() {
		return this.dcgoClssCd;
	}
	
	/**
	 * Column Info
	 * @return invDateType
	 */
	public String getInvDateType() {
		return this.invDateType;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return dscrIndCd
	 */
	public String getDscrIndCd() {
		return this.dscrIndCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtGateOutDt
	 */
	public String getMvmtGateOutDt() {
		return this.mvmtGateOutDt;
	}
	
	/**
	 * Column Info
	 * @return preYdCd
	 */
	public String getPreYdCd() {
		return this.preYdCd;
	}
	
	/**
	 * Column Info
	 * @return loclTsIndCd
	 */
	public String getLoclTsIndCd() {
		return this.loclTsIndCd;
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
	 * @return hndlRsltRmk
	 */
	public String getHndlRsltRmk() {
		return this.hndlRsltRmk;
	}
	
	/**
	 * Column Info
	 * @return tmlRvisIndFlg
	 */
	public String getTmlRvisIndFlg() {
		return this.tmlRvisIndFlg;
	}
	
	/**
	 * Column Info
	 * @return railBilDt
	 */
	public String getRailBilDt() {
		return this.railBilDt;
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
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return tmlSoSeq
	 */
	public String getTmlSoSeq() {
		return this.tmlSoSeq;
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
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return mvmtStayDys
	 */
	public String getMvmtStayDys() {
		return this.mvmtStayDys;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtGateInDt
	 */
	public String getMvmtGateInDt() {
		return this.mvmtGateInDt;
	}
	
	/**
	 * Column Info
	 * @return invStayDys
	 */
	public String getInvStayDys() {
		return this.invStayDys;
	}
	
	/**
	 * Column Info
	 * @return modiFlg
	 */
	public String getModiFlg() {
		return this.modiFlg;
	}
	
	/**
	 * Column Info
	 * @return gateOutTdDys
	 */
	public String getGateOutTdDys() {
		return this.gateOutTdDys;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return dscrRsn
	 */
	public String getDscrRsn() {
		return this.dscrRsn;
	}
	
	/**
	 * Column Info
	 * @return rcvdeTermIndCd
	 */
	public String getRcvdeTermIndCd() {
		return this.rcvdeTermIndCd;
	}
	
	/**
	 * Column Info
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
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
	 * @return gateInTdDys
	 */
	public String getGateInTdDys() {
		return this.gateInTdDys;
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
	 * @return wrkDt
	 */
	public String getWrkDt() {
		return this.wrkDt;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return samLoclTsIndCd
	 */
	public String getSamLoclTsIndCd() {
		return this.samLoclTsIndCd;
	}
	
	/**
	 * Column Info
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
	}
	
	/**
	 * Column Info
	 * @return clmDt
	 */
	public String getClmDt() {
		return this.clmDt;
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
	 * @return invGateOutDt
	 */
	public String getInvGateOutDt() {
		return this.invGateOutDt;
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
	 * @return stayDiffDys
	 */
	public String getStayDiffDys() {
		return this.stayDiffDys;
	}
	
	/**
	 * Column Info
	 * @return cntrStyCd
	 */
	public String getCntrStyCd() {
		return this.cntrStyCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return tmlInvStsCd
	 */
	public String getTmlInvStsCd() {
		return this.tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrRmk
	 */
	public String getCntrRmk() {
		return this.cntrRmk;
	}
	
	/**
	 * Column Info
	 * @return tmlSoOfcCtyCd
	 */
	public String getTmlSoOfcCtyCd() {
		return this.tmlSoOfcCtyCd;
	}
	

	/**
	 * Column Info
	 * @param vrfyRsltIndCd
	 */
	public void setVrfyRsltIndCd(String vrfyRsltIndCd) {
		this.vrfyRsltIndCd = vrfyRsltIndCd;
	}
	
	/**
	 * Column Info
	 * @param invGateInDt
	 */
	public void setInvGateInDt(String invGateInDt) {
		this.invGateInDt = invGateInDt;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param tmlInvTpCd
	 */
	public void setTmlInvTpCd(String tmlInvTpCd) {
		this.tmlInvTpCd = tmlInvTpCd;
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
	 * @param tmlSoCntrListSeq
	 */
	public void setTmlSoCntrListSeq(String tmlSoCntrListSeq) {
		this.tmlSoCntrListSeq = tmlSoCntrListSeq;
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
	 * @param fmPrdDt
	 */
	public void setFmPrdDt(String fmPrdDt) {
		this.fmPrdDt = fmPrdDt;
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
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
	 * @param dcgoClssCd
	 */
	public void setDcgoClssCd(String dcgoClssCd) {
		this.dcgoClssCd = dcgoClssCd;
	}
	
	/**
	 * Column Info
	 * @param invDateType
	 */
	public void setInvDateType(String invDateType) {
		this.invDateType = invDateType;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param dscrIndCd
	 */
	public void setDscrIndCd(String dscrIndCd) {
		this.dscrIndCd = dscrIndCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtGateOutDt
	 */
	public void setMvmtGateOutDt(String mvmtGateOutDt) {
		this.mvmtGateOutDt = mvmtGateOutDt;
	}
	
	/**
	 * Column Info
	 * @param preYdCd
	 */
	public void setPreYdCd(String preYdCd) {
		this.preYdCd = preYdCd;
	}
	
	/**
	 * Column Info
	 * @param loclTsIndCd
	 */
	public void setLoclTsIndCd(String loclTsIndCd) {
		this.loclTsIndCd = loclTsIndCd;
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
	 * @param hndlRsltRmk
	 */
	public void setHndlRsltRmk(String hndlRsltRmk) {
		this.hndlRsltRmk = hndlRsltRmk;
	}
	
	/**
	 * Column Info
	 * @param tmlRvisIndFlg
	 */
	public void setTmlRvisIndFlg(String tmlRvisIndFlg) {
		this.tmlRvisIndFlg = tmlRvisIndFlg;
	}
	
	/**
	 * Column Info
	 * @param railBilDt
	 */
	public void setRailBilDt(String railBilDt) {
		this.railBilDt = railBilDt;
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
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param tmlSoSeq
	 */
	public void setTmlSoSeq(String tmlSoSeq) {
		this.tmlSoSeq = tmlSoSeq;
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
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param mvmtStayDys
	 */
	public void setMvmtStayDys(String mvmtStayDys) {
		this.mvmtStayDys = mvmtStayDys;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtGateInDt
	 */
	public void setMvmtGateInDt(String mvmtGateInDt) {
		this.mvmtGateInDt = mvmtGateInDt;
	}
	
	/**
	 * Column Info
	 * @param invStayDys
	 */
	public void setInvStayDys(String invStayDys) {
		this.invStayDys = invStayDys;
	}
	
	/**
	 * Column Info
	 * @param modiFlg
	 */
	public void setModiFlg(String modiFlg) {
		this.modiFlg = modiFlg;
	}
	
	/**
	 * Column Info
	 * @param gateOutTdDys
	 */
	public void setGateOutTdDys(String gateOutTdDys) {
		this.gateOutTdDys = gateOutTdDys;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param dscrRsn
	 */
	public void setDscrRsn(String dscrRsn) {
		this.dscrRsn = dscrRsn;
	}
	
	/**
	 * Column Info
	 * @param rcvdeTermIndCd
	 */
	public void setRcvdeTermIndCd(String rcvdeTermIndCd) {
		this.rcvdeTermIndCd = rcvdeTermIndCd;
	}
	
	/**
	 * Column Info
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
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
	 * @param gateInTdDys
	 */
	public void setGateInTdDys(String gateInTdDys) {
		this.gateInTdDys = gateInTdDys;
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
	 * @param wrkDt
	 */
	public void setWrkDt(String wrkDt) {
		this.wrkDt = wrkDt;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param samLoclTsIndCd
	 */
	public void setSamLoclTsIndCd(String samLoclTsIndCd) {
		this.samLoclTsIndCd = samLoclTsIndCd;
	}
	
	/**
	 * Column Info
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
	}
	
	/**
	 * Column Info
	 * @param clmDt
	 */
	public void setClmDt(String clmDt) {
		this.clmDt = clmDt;
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
	 * @param invGateOutDt
	 */
	public void setInvGateOutDt(String invGateOutDt) {
		this.invGateOutDt = invGateOutDt;
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
	 * @param stayDiffDys
	 */
	public void setStayDiffDys(String stayDiffDys) {
		this.stayDiffDys = stayDiffDys;
	}
	
	/**
	 * Column Info
	 * @param cntrStyCd
	 */
	public void setCntrStyCd(String cntrStyCd) {
		this.cntrStyCd = cntrStyCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param tmlInvStsCd
	 */
	public void setTmlInvStsCd(String tmlInvStsCd) {
		this.tmlInvStsCd = tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrRmk
	 */
	public void setCntrRmk(String cntrRmk) {
		this.cntrRmk = cntrRmk;
	}
	
	/**
	 * Column Info
	 * @param tmlSoOfcCtyCd
	 */
	public void setTmlSoOfcCtyCd(String tmlSoOfcCtyCd) {
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
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
		setVrfyRsltIndCd(JSPUtil.getParameter(request, prefix + "vrfy_rslt_ind_cd", ""));
		setInvGateInDt(JSPUtil.getParameter(request, prefix + "inv_gate_in_dt", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setTmlInvTpCd(JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTmlSoCntrListSeq(JSPUtil.getParameter(request, prefix + "tml_so_cntr_list_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setDcgoClssCd(JSPUtil.getParameter(request, prefix + "dcgo_clss_cd", ""));
		setInvDateType(JSPUtil.getParameter(request, prefix + "inv_date_type", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setDscrIndCd(JSPUtil.getParameter(request, prefix + "dscr_ind_cd", ""));
		setMvmtGateOutDt(JSPUtil.getParameter(request, prefix + "mvmt_gate_out_dt", ""));
		setPreYdCd(JSPUtil.getParameter(request, prefix + "pre_yd_cd", ""));
		setLoclTsIndCd(JSPUtil.getParameter(request, prefix + "locl_ts_ind_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setHndlRsltRmk(JSPUtil.getParameter(request, prefix + "hndl_rslt_rmk", ""));
		setTmlRvisIndFlg(JSPUtil.getParameter(request, prefix + "tml_rvis_ind_flg", ""));
		setRailBilDt(JSPUtil.getParameter(request, prefix + "rail_bil_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setTmlSoSeq(JSPUtil.getParameter(request, prefix + "tml_so_seq", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setMvmtStayDys(JSPUtil.getParameter(request, prefix + "mvmt_stay_dys", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setMvmtGateInDt(JSPUtil.getParameter(request, prefix + "mvmt_gate_in_dt", ""));
		setInvStayDys(JSPUtil.getParameter(request, prefix + "inv_stay_dys", ""));
		setModiFlg(JSPUtil.getParameter(request, prefix + "modi_flg", ""));
		setGateOutTdDys(JSPUtil.getParameter(request, prefix + "gate_out_td_dys", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setDscrRsn(JSPUtil.getParameter(request, prefix + "dscr_rsn", ""));
		setRcvdeTermIndCd(JSPUtil.getParameter(request, prefix + "rcvde_term_ind_cd", ""));
		setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGateInTdDys(JSPUtil.getParameter(request, prefix + "gate_in_td_dys", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setWrkDt(JSPUtil.getParameter(request, prefix + "wrk_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setSamLoclTsIndCd(JSPUtil.getParameter(request, prefix + "sam_locl_ts_ind_cd", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setClmDt(JSPUtil.getParameter(request, prefix + "clm_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setInvGateOutDt(JSPUtil.getParameter(request, prefix + "inv_gate_out_dt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setStayDiffDys(JSPUtil.getParameter(request, prefix + "stay_diff_dys", ""));
		setCntrStyCd(JSPUtil.getParameter(request, prefix + "cntr_sty_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTmlInvStsCd(JSPUtil.getParameter(request, prefix + "tml_inv_sts_cd", ""));
		setCntrRmk(JSPUtil.getParameter(request, prefix + "cntr_rmk", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_so_ofc_cty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StorageCoincidenceVO[]
	 */
	public StorageCoincidenceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StorageCoincidenceVO[]
	 */
	public StorageCoincidenceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StorageCoincidenceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vrfyRsltIndCd = (JSPUtil.getParameter(request, prefix	+ "vrfy_rslt_ind_cd", length));
			String[] invGateInDt = (JSPUtil.getParameter(request, prefix	+ "inv_gate_in_dt", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] tmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tmlSoCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_cntr_list_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] dcgoClssCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_clss_cd", length));
			String[] invDateType = (JSPUtil.getParameter(request, prefix	+ "inv_date_type", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] dscrIndCd = (JSPUtil.getParameter(request, prefix	+ "dscr_ind_cd", length));
			String[] mvmtGateOutDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_gate_out_dt", length));
			String[] preYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_yd_cd", length));
			String[] loclTsIndCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_ind_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hndlRsltRmk = (JSPUtil.getParameter(request, prefix	+ "hndl_rslt_rmk", length));
			String[] tmlRvisIndFlg = (JSPUtil.getParameter(request, prefix	+ "tml_rvis_ind_flg", length));
			String[] railBilDt = (JSPUtil.getParameter(request, prefix	+ "rail_bil_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] tmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_seq", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] mvmtStayDys = (JSPUtil.getParameter(request, prefix	+ "mvmt_stay_dys", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] mvmtGateInDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_gate_in_dt", length));
			String[] invStayDys = (JSPUtil.getParameter(request, prefix	+ "inv_stay_dys", length));
			String[] modiFlg = (JSPUtil.getParameter(request, prefix	+ "modi_flg", length));
			String[] gateOutTdDys = (JSPUtil.getParameter(request, prefix	+ "gate_out_td_dys", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] dscrRsn = (JSPUtil.getParameter(request, prefix	+ "dscr_rsn", length));
			String[] rcvdeTermIndCd = (JSPUtil.getParameter(request, prefix	+ "rcvde_term_ind_cd", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gateInTdDys = (JSPUtil.getParameter(request, prefix	+ "gate_in_td_dys", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] wrkDt = (JSPUtil.getParameter(request, prefix	+ "wrk_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] samLoclTsIndCd = (JSPUtil.getParameter(request, prefix	+ "sam_locl_ts_ind_cd", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] clmDt = (JSPUtil.getParameter(request, prefix	+ "clm_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] invGateOutDt = (JSPUtil.getParameter(request, prefix	+ "inv_gate_out_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] stayDiffDys = (JSPUtil.getParameter(request, prefix	+ "stay_diff_dys", length));
			String[] cntrStyCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sty_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] tmlInvStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_sts_cd", length));
			String[] cntrRmk = (JSPUtil.getParameter(request, prefix	+ "cntr_rmk", length));
			String[] tmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_so_ofc_cty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new StorageCoincidenceVO();
				if (vrfyRsltIndCd[i] != null)
					model.setVrfyRsltIndCd(vrfyRsltIndCd[i]);
				if (invGateInDt[i] != null)
					model.setInvGateInDt(invGateInDt[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (tmlInvTpCd[i] != null)
					model.setTmlInvTpCd(tmlInvTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmlSoCntrListSeq[i] != null)
					model.setTmlSoCntrListSeq(tmlSoCntrListSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (dcgoClssCd[i] != null)
					model.setDcgoClssCd(dcgoClssCd[i]);
				if (invDateType[i] != null)
					model.setInvDateType(invDateType[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (dscrIndCd[i] != null)
					model.setDscrIndCd(dscrIndCd[i]);
				if (mvmtGateOutDt[i] != null)
					model.setMvmtGateOutDt(mvmtGateOutDt[i]);
				if (preYdCd[i] != null)
					model.setPreYdCd(preYdCd[i]);
				if (loclTsIndCd[i] != null)
					model.setLoclTsIndCd(loclTsIndCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hndlRsltRmk[i] != null)
					model.setHndlRsltRmk(hndlRsltRmk[i]);
				if (tmlRvisIndFlg[i] != null)
					model.setTmlRvisIndFlg(tmlRvisIndFlg[i]);
				if (railBilDt[i] != null)
					model.setRailBilDt(railBilDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (tmlSoSeq[i] != null)
					model.setTmlSoSeq(tmlSoSeq[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (mvmtStayDys[i] != null)
					model.setMvmtStayDys(mvmtStayDys[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (mvmtGateInDt[i] != null)
					model.setMvmtGateInDt(mvmtGateInDt[i]);
				if (invStayDys[i] != null)
					model.setInvStayDys(invStayDys[i]);
				if (modiFlg[i] != null)
					model.setModiFlg(modiFlg[i]);
				if (gateOutTdDys[i] != null)
					model.setGateOutTdDys(gateOutTdDys[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (dscrRsn[i] != null)
					model.setDscrRsn(dscrRsn[i]);
				if (rcvdeTermIndCd[i] != null)
					model.setRcvdeTermIndCd(rcvdeTermIndCd[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gateInTdDys[i] != null)
					model.setGateInTdDys(gateInTdDys[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (wrkDt[i] != null)
					model.setWrkDt(wrkDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (samLoclTsIndCd[i] != null)
					model.setSamLoclTsIndCd(samLoclTsIndCd[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (clmDt[i] != null)
					model.setClmDt(clmDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (invGateOutDt[i] != null)
					model.setInvGateOutDt(invGateOutDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (stayDiffDys[i] != null)
					model.setStayDiffDys(stayDiffDys[i]);
				if (cntrStyCd[i] != null)
					model.setCntrStyCd(cntrStyCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tmlInvStsCd[i] != null)
					model.setTmlInvStsCd(tmlInvStsCd[i]);
				if (cntrRmk[i] != null)
					model.setCntrRmk(cntrRmk[i]);
				if (tmlSoOfcCtyCd[i] != null)
					model.setTmlSoOfcCtyCd(tmlSoOfcCtyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStorageCoincidenceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StorageCoincidenceVO[]
	 */
	public StorageCoincidenceVO[] getStorageCoincidenceVOs(){
		StorageCoincidenceVO[] vos = (StorageCoincidenceVO[])models.toArray(new StorageCoincidenceVO[models.size()]);
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
		this.vrfyRsltIndCd = this.vrfyRsltIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invGateInDt = this.invGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvTpCd = this.tmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoCntrListSeq = this.tmlSoCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoClssCd = this.dcgoClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDateType = this.invDateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrIndCd = this.dscrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtGateOutDt = this.mvmtGateOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preYdCd = this.preYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsIndCd = this.loclTsIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlRsltRmk = this.hndlRsltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlRvisIndFlg = this.tmlRvisIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railBilDt = this.railBilDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq = this.tmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStayDys = this.mvmtStayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtGateInDt = this.mvmtGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStayDys = this.invStayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiFlg = this.modiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateOutTdDys = this.gateOutTdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrRsn = this.dscrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvdeTermIndCd = this.rcvdeTermIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateInTdDys = this.gateInTdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkDt = this.wrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samLoclTsIndCd = this.samLoclTsIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmDt = this.clmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invGateOutDt = this.invGateOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDiffDys = this.stayDiffDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStyCd = this.cntrStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvStsCd = this.tmlInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRmk = this.cntrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd = this.tmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
