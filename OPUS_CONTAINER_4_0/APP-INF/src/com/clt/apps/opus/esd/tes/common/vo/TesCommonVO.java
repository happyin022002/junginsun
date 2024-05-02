/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesCommonVO.java
*@FileTitle : TesCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.common.vo;

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

public class TesCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesCommonVO> models = new ArrayList<TesCommonVO>();
	
	/* Column Info */
	private String otALgsCostCd = null;
	/* Column Info */
	private String agmtFtrInvTpCd = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String realFileName = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String rowCnt = null;
	/* Column Info */
	private String invRgstSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String carrCd = null;
	/* Column Info */
	private String st = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String currDate = null;
	/* Column Info */
	private String savedPath = null;
	/* Column Info */
	private String paramLgsCostCd = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String osALgsCostCd = null;
	/* Column Info */
	private String actTp = null;
	/* Column Info */
	private String ydOshpCd = null;
	/* Column Info */
	private String comListYn = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String noYdCd = null;
	/* Column Info */
	private String noOfcCd = null;
	/* Column Info */
	private String isExistingOfcCd = null;
	/* Column Info */
	private String ydChrInvTpCd = null;
	/* Column Info */
	private String calcCostGrpCd = null;
	/* Column Info */
	private String atbDt = null;
	/* Column Info */
	private String mode = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String ydFctyTpCfsFlg = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String functionname = null;
	/* Column Info */
	private String def = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String mtALgsCostCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String costCdInvTpCd = null;
	/* Column Info */
	private String jbTpCd = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String maxWrkDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String n3ptyBilCsCd = null;
	/* Column Info */
	private String isValidYdCd = null;
	/* Column Info */
	private String ex = null;
	/* Column Info */
	private String paramVal = null;
	/* Column Info */
	private String idx = null;
	/* Column Info */
	private String vndrSeqExisting = null;
	/* Column Info */
	private String stALgsCostCd = null;
	/* Column Info */
	private String ydFctyTpRailRmpFlg = null;
	/* Column Info */
	private String csrStatus = null;
	/* Column Info */
	private String tmpMgstNo = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String savedFileName = null;
	/* Column Info */
	private String currList = null;
	/* Column Info */
	private String onALgsCostCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String coid = null;
	/* Column Info */
	private String pgmUrl = null;
	/* Column Info */
	private String minWrkDt = null;
	/* Column Info */
	private String exePerfLogSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String yn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesCommonVO() {}

	public TesCommonVO(String ibflag, String pagerows, String otALgsCostCd, String agmtFtrInvTpCd, String fCmd, String realFileName, String rowCnt, String invRgstSeq, String cntrTpszCd, String carrCd, String st, String fmPrdDt, String currDate, String savedPath, String paramLgsCostCd, String toDate, String vvd, String fromDate, String osALgsCostCd, String actTp, String comListYn, String ydOshpCd, String deltFlg, String vndrLglEngNm, String noYdCd, String noOfcCd, String isExistingOfcCd, String ydChrInvTpCd, String calcCostGrpCd, String atbDt, String mode, String issDt, String ydFctyTpCfsFlg, String eqNo, String functionname, String def, String usrId, String mtALgsCostCd, String creOfcCd, String costCdInvTpCd, String jbTpCd, String maxWrkDt, String invOfcCd, String invRgstNo, String n3ptyBilCsCd, String isValidYdCd, String ex, String paramVal, String idx, String stALgsCostCd, String vndrSeqExisting, String ydFctyTpRailRmpFlg, String csrStatus, String toPrdDt, String tmpMgstNo, String savedFileName, String currList, String onALgsCostCd, String coid, String ofcCd, String pgmUrl, String minWrkDt, String exePerfLogSeq, String cntrNo, String yn, String callYdIndSeq) {
		this.otALgsCostCd = otALgsCostCd;
		this.agmtFtrInvTpCd = agmtFtrInvTpCd;
		this.fCmd = fCmd;
		this.realFileName = realFileName;
		this.pagerows = pagerows;
		this.rowCnt = rowCnt;
		this.invRgstSeq = invRgstSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.carrCd = carrCd;
		this.st = st;
		this.fmPrdDt = fmPrdDt;
		this.currDate = currDate;
		this.savedPath = savedPath;
		this.paramLgsCostCd = paramLgsCostCd;
		this.toDate = toDate;
		this.vvd = vvd;
		this.fromDate = fromDate;
		this.osALgsCostCd = osALgsCostCd;
		this.actTp = actTp;
		this.ydOshpCd = ydOshpCd;
		this.comListYn = comListYn;
		this.deltFlg = deltFlg;
		this.vndrLglEngNm = vndrLglEngNm;
		this.noYdCd = noYdCd;
		this.noOfcCd = noOfcCd;
		this.isExistingOfcCd = isExistingOfcCd;
		this.ydChrInvTpCd = ydChrInvTpCd;
		this.calcCostGrpCd = calcCostGrpCd;
		this.atbDt = atbDt;
		this.mode = mode;
		this.issDt = issDt;
		this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.functionname = functionname;
		this.def = def;
		this.usrId = usrId;
		this.mtALgsCostCd = mtALgsCostCd;
		this.creOfcCd = creOfcCd;
		this.costCdInvTpCd = costCdInvTpCd;
		this.jbTpCd = jbTpCd;
		this.callYdIndSeq = callYdIndSeq;
		this.maxWrkDt = maxWrkDt;
		this.invOfcCd = invOfcCd;
		this.invRgstNo = invRgstNo;
		this.n3ptyBilCsCd = n3ptyBilCsCd;
		this.isValidYdCd = isValidYdCd;
		this.ex = ex;
		this.paramVal = paramVal;
		this.idx = idx;
		this.vndrSeqExisting = vndrSeqExisting;
		this.stALgsCostCd = stALgsCostCd;
		this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
		this.csrStatus = csrStatus;
		this.tmpMgstNo = tmpMgstNo;
		this.toPrdDt = toPrdDt;
		this.savedFileName = savedFileName;
		this.currList = currList;
		this.onALgsCostCd = onALgsCostCd;
		this.ofcCd = ofcCd;
		this.coid = coid;
		this.pgmUrl = pgmUrl;
		this.minWrkDt = minWrkDt;
		this.exePerfLogSeq = exePerfLogSeq;
		this.cntrNo = cntrNo;
		this.yn = yn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ot_a_lgs_cost_cd", getOtALgsCostCd());
		this.hashColumns.put("agmt_ftr_inv_tp_cd", getAgmtFtrInvTpCd());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("real_file_name", getRealFileName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("row_cnt", getRowCnt());
		this.hashColumns.put("inv_rgst_seq", getInvRgstSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("carr_cd", getCarrCd());
		this.hashColumns.put("st", getSt());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("curr_date", getCurrDate());
		this.hashColumns.put("saved_path", getSavedPath());
		this.hashColumns.put("param_lgs_cost_cd", getParamLgsCostCd());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("os_a_lgs_cost_cd", getOsALgsCostCd());
		this.hashColumns.put("act_tp", getActTp());
		this.hashColumns.put("yd_oshp_cd", getYdOshpCd());
		this.hashColumns.put("com_list_yn", getComListYn());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("no_yd_cd", getNoYdCd());
		this.hashColumns.put("no_ofc_cd", getNoOfcCd());
		this.hashColumns.put("is_existing_ofc_cd", getIsExistingOfcCd());
		this.hashColumns.put("yd_chr_inv_tp_cd", getYdChrInvTpCd());
		this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());
		this.hashColumns.put("atb_dt", getAtbDt());
		this.hashColumns.put("mode_", getMode());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("yd_fcty_tp_cfs_flg", getYdFctyTpCfsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("functionname", getFunctionname());
		this.hashColumns.put("def", getDef());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("mt_a_lgs_cost_cd", getMtALgsCostCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cost_cd_inv_tp_cd", getCostCdInvTpCd());
		this.hashColumns.put("jb_tp_cd", getJbTpCd());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("max_wrk_dt", getMaxWrkDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("n3pty_bil_cs_cd", getN3ptyBilCsCd());
		this.hashColumns.put("is_valid_yd_cd", getIsValidYdCd());
		this.hashColumns.put("ex", getEx());
		this.hashColumns.put("param_val", getParamVal());
		this.hashColumns.put("idx", getIdx());
		this.hashColumns.put("vndr_seq_existing", getVndrSeqExisting());
		this.hashColumns.put("st_a_lgs_cost_cd", getStALgsCostCd());
		this.hashColumns.put("yd_fcty_tp_rail_rmp_flg", getYdFctyTpRailRmpFlg());
		this.hashColumns.put("csr_status", getCsrStatus());
		this.hashColumns.put("tmp_mgst_no", getTmpMgstNo());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("saved_file_name", getSavedFileName());
		this.hashColumns.put("curr_list", getCurrList());
		this.hashColumns.put("on_a_lgs_cost_cd", getOnALgsCostCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("coid", getCoid());
		this.hashColumns.put("pgm_url", getPgmUrl());
		this.hashColumns.put("min_wrk_dt", getMinWrkDt());
		this.hashColumns.put("exe_perf_log_seq", getExePerfLogSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("yn", getYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ot_a_lgs_cost_cd", "otALgsCostCd");
		this.hashFields.put("agmt_ftr_inv_tp_cd", "agmtFtrInvTpCd");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("real_file_name", "realFileName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("row_cnt", "rowCnt");
		this.hashFields.put("inv_rgst_seq", "invRgstSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("carr_cd", "carrCd");
		this.hashFields.put("st", "st");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("curr_date", "currDate");
		this.hashFields.put("saved_path", "savedPath");
		this.hashFields.put("param_lgs_cost_cd", "paramLgsCostCd");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("os_a_lgs_cost_cd", "osALgsCostCd");
		this.hashFields.put("act_tp", "actTp");
		this.hashFields.put("yd_oshp_cd", "ydOshpCd");
		this.hashFields.put("com_list_yn", "comListYn");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("no_yd_cd", "noYdCd");
		this.hashFields.put("no_ofc_cd", "noOfcCd");
		this.hashFields.put("is_existing_ofc_cd", "isExistingOfcCd");
		this.hashFields.put("yd_chr_inv_tp_cd", "ydChrInvTpCd");
		this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("mode_", "mode");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("yd_fcty_tp_cfs_flg", "ydFctyTpCfsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("functionname", "functionname");
		this.hashFields.put("def", "def");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("mt_a_lgs_cost_cd", "mtALgsCostCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cost_cd_inv_tp_cd", "costCdInvTpCd");
		this.hashFields.put("jb_tp_cd", "jbTpCd");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("max_wrk_dt", "maxWrkDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("n3pty_bil_cs_cd", "n3ptyBilCsCd");
		this.hashFields.put("is_valid_yd_cd", "isValidYdCd");
		this.hashFields.put("ex", "ex");
		this.hashFields.put("param_val", "paramVal");
		this.hashFields.put("idx", "idx");
		this.hashFields.put("vndr_seq_existing", "vndrSeqExisting");
		this.hashFields.put("st_a_lgs_cost_cd", "stALgsCostCd");
		this.hashFields.put("yd_fcty_tp_rail_rmp_flg", "ydFctyTpRailRmpFlg");
		this.hashFields.put("csr_status", "csrStatus");
		this.hashFields.put("tmp_mgst_no", "tmpMgstNo");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("saved_file_name", "savedFileName");
		this.hashFields.put("curr_list", "currList");
		this.hashFields.put("on_a_lgs_cost_cd", "onALgsCostCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("coid", "coid");
		this.hashFields.put("pgm_url", "pgmUrl");
		this.hashFields.put("min_wrk_dt", "minWrkDt");
		this.hashFields.put("exe_perf_log_seq", "exePerfLogSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("yn", "yn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return otALgsCostCd
	 */
	public String getOtALgsCostCd() {
		return this.otALgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return agmtFtrInvTpCd
	 */
	public String getAgmtFtrInvTpCd() {
		return this.agmtFtrInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return realFileName
	 */
	public String getRealFileName() {
		return this.realFileName;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return rowCnt
	 */
	public String getRowCnt() {
		return this.rowCnt;
	}
	
	/**
	 * Column Info
	 * @return invRgstSeq
	 */
	public String getInvRgstSeq() {
		return this.invRgstSeq;
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
	 * @return carrCd
	 */
	public String getCarrCd() {
		return this.carrCd;
	}
	
	/**
	 * Column Info
	 * @return st
	 */
	public String getSt() {
		return this.st;
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
	 * @return currDate
	 */
	public String getCurrDate() {
		return this.currDate;
	}
	
	/**
	 * Column Info
	 * @return savedPath
	 */
	public String getSavedPath() {
		return this.savedPath;
	}
	
	/**
	 * Column Info
	 * @return paramLgsCostCd
	 */
	public String getParamLgsCostCd() {
		return this.paramLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return osALgsCostCd
	 */
	public String getOsALgsCostCd() {
		return this.osALgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return actTp
	 */
	public String getActTp() {
		return this.actTp;
	}
	
	/**
	 * Column Info
	 * @return ydOshpCd
	 */
	public String getYdOshpCd() {
		return this.ydOshpCd;
	}
	
	/**
	 * Column Info
	 * @return comListYn
	 */
	public String getComListYn() {
		return this.comListYn;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return noYdCd
	 */
	public String getNoYdCd() {
		return this.noYdCd;
	}
	
	/**
	 * Column Info
	 * @return noOfcCd
	 */
	public String getNoOfcCd() {
		return this.noOfcCd;
	}
	
	/**
	 * Column Info
	 * @return isExistingOfcCd
	 */
	public String getIsExistingOfcCd() {
		return this.isExistingOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ydChrInvTpCd
	 */
	public String getYdChrInvTpCd() {
		return this.ydChrInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return calcCostGrpCd
	 */
	public String getCalcCostGrpCd() {
		return this.calcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
	}
	
	/**
	 * Column Info
	 * @return mode
	 */
	public String getMode() {
		return this.mode;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpCfsFlg
	 */
	public String getYdFctyTpCfsFlg() {
		return this.ydFctyTpCfsFlg;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return functionname
	 */
	public String getFunctionname() {
		return this.functionname;
	}
	
	/**
	 * Column Info
	 * @return def
	 */
	public String getDef() {
		return this.def;
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
	 * @return mtALgsCostCd
	 */
	public String getMtALgsCostCd() {
		return this.mtALgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return costCdInvTpCd
	 */
	public String getCostCdInvTpCd() {
		return this.costCdInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return jbTpCd
	 */
	public String getJbTpCd() {
		return this.jbTpCd;
	}
	
	/**
	 * Column Info
	 * @return callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @return maxWrkDt
	 */
	public String getMaxWrkDt() {
		return this.maxWrkDt;
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
	 * @return invRgstNo
	 */
	public String getInvRgstNo() {
		return this.invRgstNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilCsCd
	 */
	public String getN3ptyBilCsCd() {
		return this.n3ptyBilCsCd;
	}
	
	/**
	 * Column Info
	 * @return isValidYdCd
	 */
	public String getIsValidYdCd() {
		return this.isValidYdCd;
	}
	
	/**
	 * Column Info
	 * @return ex
	 */
	public String getEx() {
		return this.ex;
	}
	
	/**
	 * Column Info
	 * @return paramVal
	 */
	public String getParamVal() {
		return this.paramVal;
	}
	
	/**
	 * Column Info
	 * @return idx
	 */
	public String getIdx() {
		return this.idx;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqExisting
	 */
	public String getVndrSeqExisting() {
		return this.vndrSeqExisting;
	}
	
	/**
	 * Column Info
	 * @return stALgsCostCd
	 */
	public String getStALgsCostCd() {
		return this.stALgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpRailRmpFlg
	 */
	public String getYdFctyTpRailRmpFlg() {
		return this.ydFctyTpRailRmpFlg;
	}
	
	/**
	 * Column Info
	 * @return csrStatus
	 */
	public String getCsrStatus() {
		return this.csrStatus;
	}
	
	/**
	 * Column Info
	 * @return tmpMgstNo
	 */
	public String getTmpMgstNo() {
		return this.tmpMgstNo;
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
	 * @return savedFileName
	 */
	public String getSavedFileName() {
		return this.savedFileName;
	}
	
	/**
	 * Column Info
	 * @return currList
	 */
	public String getCurrList() {
		return this.currList;
	}
	
	/**
	 * Column Info
	 * @return onALgsCostCd
	 */
	public String getOnALgsCostCd() {
		return this.onALgsCostCd;
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
	 * @return coid
	 */
	public String getCoid() {
		return this.coid;
	}
	
	/**
	 * Column Info
	 * @return pgmUrl
	 */
	public String getPgmUrl() {
		return this.pgmUrl;
	}
	
	/**
	 * Column Info
	 * @return minWrkDt
	 */
	public String getMinWrkDt() {
		return this.minWrkDt;
	}
	
	/**
	 * Column Info
	 * @return exePerfLogSeq
	 */
	public String getExePerfLogSeq() {
		return this.exePerfLogSeq;
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
	 * @return yn
	 */
	public String getYn() {
		return this.yn;
	}
	

	/**
	 * Column Info
	 * @param otALgsCostCd
	 */
	public void setOtALgsCostCd(String otALgsCostCd) {
		this.otALgsCostCd = otALgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param agmtFtrInvTpCd
	 */
	public void setAgmtFtrInvTpCd(String agmtFtrInvTpCd) {
		this.agmtFtrInvTpCd = agmtFtrInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param realFileName
	 */
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param rowCnt
	 */
	public void setRowCnt(String rowCnt) {
		this.rowCnt = rowCnt;
	}
	
	/**
	 * Column Info
	 * @param invRgstSeq
	 */
	public void setInvRgstSeq(String invRgstSeq) {
		this.invRgstSeq = invRgstSeq;
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
	 * @param carrCd
	 */
	public void setCarrCd(String carrCd) {
		this.carrCd = carrCd;
	}
	
	/**
	 * Column Info
	 * @param st
	 */
	public void setSt(String st) {
		this.st = st;
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
	 * @param currDate
	 */
	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}
	
	/**
	 * Column Info
	 * @param savedPath
	 */
	public void setSavedPath(String savedPath) {
		this.savedPath = savedPath;
	}
	
	/**
	 * Column Info
	 * @param paramLgsCostCd
	 */
	public void setParamLgsCostCd(String paramLgsCostCd) {
		this.paramLgsCostCd = paramLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param osALgsCostCd
	 */
	public void setOsALgsCostCd(String osALgsCostCd) {
		this.osALgsCostCd = osALgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param actTp
	 */
	public void setActTp(String actTp) {
		this.actTp = actTp;
	}
	
	/**
	 * Column Info
	 * @param ydOshpCd
	 */
	public void setYdOshpCd(String ydOshpCd) {
		this.ydOshpCd = ydOshpCd;
	}
	
	/**
	 * Column Info
	 * @param comListYn
	 */
	public void setComListYn(String comListYn) {
		this.comListYn = comListYn;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param noYdCd
	 */
	public void setNoYdCd(String noYdCd) {
		this.noYdCd = noYdCd;
	}
	
	/**
	 * Column Info
	 * @param noOfcCd
	 */
	public void setNoOfcCd(String noOfcCd) {
		this.noOfcCd = noOfcCd;
	}
	
	/**
	 * Column Info
	 * @param isExistingOfcCd
	 */
	public void setIsExistingOfcCd(String isExistingOfcCd) {
		this.isExistingOfcCd = isExistingOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ydChrInvTpCd
	 */
	public void setYdChrInvTpCd(String ydChrInvTpCd) {
		this.ydChrInvTpCd = ydChrInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param calcCostGrpCd
	 */
	public void setCalcCostGrpCd(String calcCostGrpCd) {
		this.calcCostGrpCd = calcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
	}
	
	/**
	 * Column Info
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpCfsFlg
	 */
	public void setYdFctyTpCfsFlg(String ydFctyTpCfsFlg) {
		this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param functionname
	 */
	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}
	
	/**
	 * Column Info
	 * @param def
	 */
	public void setDef(String def) {
		this.def = def;
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
	 * @param mtALgsCostCd
	 */
	public void setMtALgsCostCd(String mtALgsCostCd) {
		this.mtALgsCostCd = mtALgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param costCdInvTpCd
	 */
	public void setCostCdInvTpCd(String costCdInvTpCd) {
		this.costCdInvTpCd = costCdInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param jbTpCd
	 */
	public void setJbTpCd(String jbTpCd) {
		this.jbTpCd = jbTpCd;
	}
	
	/**
	 * Column Info
	 * @param callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @param maxWrkDt
	 */
	public void setMaxWrkDt(String maxWrkDt) {
		this.maxWrkDt = maxWrkDt;
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
	 * @param invRgstNo
	 */
	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilCsCd
	 */
	public void setN3ptyBilCsCd(String n3ptyBilCsCd) {
		this.n3ptyBilCsCd = n3ptyBilCsCd;
	}
	
	/**
	 * Column Info
	 * @param isValidYdCd
	 */
	public void setIsValidYdCd(String isValidYdCd) {
		this.isValidYdCd = isValidYdCd;
	}
	
	/**
	 * Column Info
	 * @param ex
	 */
	public void setEx(String ex) {
		this.ex = ex;
	}
	
	/**
	 * Column Info
	 * @param paramVal
	 */
	public void setParamVal(String paramVal) {
		this.paramVal = paramVal;
	}
	
	/**
	 * Column Info
	 * @param idx
	 */
	public void setIdx(String idx) {
		this.idx = idx;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqExisting
	 */
	public void setVndrSeqExisting(String vndrSeqExisting) {
		this.vndrSeqExisting = vndrSeqExisting;
	}
	
	/**
	 * Column Info
	 * @param stALgsCostCd
	 */
	public void setStALgsCostCd(String stALgsCostCd) {
		this.stALgsCostCd = stALgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpRailRmpFlg
	 */
	public void setYdFctyTpRailRmpFlg(String ydFctyTpRailRmpFlg) {
		this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
	}
	
	/**
	 * Column Info
	 * @param csrStatus
	 */
	public void setCsrStatus(String csrStatus) {
		this.csrStatus = csrStatus;
	}
	
	/**
	 * Column Info
	 * @param tmpMgstNo
	 */
	public void setTmpMgstNo(String tmpMgstNo) {
		this.tmpMgstNo = tmpMgstNo;
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
	 * @param savedFileName
	 */
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	
	/**
	 * Column Info
	 * @param currList
	 */
	public void setCurrList(String currList) {
		this.currList = currList;
	}
	
	/**
	 * Column Info
	 * @param onALgsCostCd
	 */
	public void setOnALgsCostCd(String onALgsCostCd) {
		this.onALgsCostCd = onALgsCostCd;
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
	 * @param coid
	 */
	public void setCoid(String coid) {
		this.coid = coid;
	}
	
	/**
	 * Column Info
	 * @param pgmUrl
	 */
	public void setPgmUrl(String pgmUrl) {
		this.pgmUrl = pgmUrl;
	}
	
	/**
	 * Column Info
	 * @param minWrkDt
	 */
	public void setMinWrkDt(String minWrkDt) {
		this.minWrkDt = minWrkDt;
	}
	
	/**
	 * Column Info
	 * @param exePerfLogSeq
	 */
	public void setExePerfLogSeq(String exePerfLogSeq) {
		this.exePerfLogSeq = exePerfLogSeq;
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
	 * @param yn
	 */
	public void setYn(String yn) {
		this.yn = yn;
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
		setOtALgsCostCd(JSPUtil.getParameter(request, prefix + "ot_a_lgs_cost_cd", ""));
		setAgmtFtrInvTpCd(JSPUtil.getParameter(request, prefix + "agmt_ftr_inv_tp_cd", ""));
		setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
		setRealFileName(JSPUtil.getParameter(request, prefix + "real_file_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRowCnt(JSPUtil.getParameter(request, prefix + "row_cnt", ""));
		setInvRgstSeq(JSPUtil.getParameter(request, prefix + "inv_rgst_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCarrCd(JSPUtil.getParameter(request, prefix + "carr_cd", ""));
		setSt(JSPUtil.getParameter(request, prefix + "st", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setCurrDate(JSPUtil.getParameter(request, prefix + "curr_date", ""));
		setSavedPath(JSPUtil.getParameter(request, prefix + "saved_path", ""));
		setParamLgsCostCd(JSPUtil.getParameter(request, prefix + "param_lgs_cost_cd", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setOsALgsCostCd(JSPUtil.getParameter(request, prefix + "os_a_lgs_cost_cd", ""));
		setActTp(JSPUtil.getParameter(request, prefix + "act_tp", ""));
		setYdOshpCd(JSPUtil.getParameter(request, prefix + "yd_oshp_cd", ""));
		setComListYn(JSPUtil.getParameter(request, prefix + "com_list_yn", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setNoYdCd(JSPUtil.getParameter(request, prefix + "no_yd_cd", ""));
		setNoOfcCd(JSPUtil.getParameter(request, prefix + "no_ofc_cd", ""));
		setIsExistingOfcCd(JSPUtil.getParameter(request, prefix + "is_existing_ofc_cd", ""));
		setYdChrInvTpCd(JSPUtil.getParameter(request, prefix + "yd_chr_inv_tp_cd", ""));
		setCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "calc_cost_grp_cd", ""));
		setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));
		setMode(JSPUtil.getParameter(request, prefix + "mode_", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setYdFctyTpCfsFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setFunctionname(JSPUtil.getParameter(request, prefix + "functionname", ""));
		setDef(JSPUtil.getParameter(request, prefix + "def", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setMtALgsCostCd(JSPUtil.getParameter(request, prefix + "mt_a_lgs_cost_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCostCdInvTpCd(JSPUtil.getParameter(request, prefix + "cost_cd_inv_tp_cd", ""));
		setJbTpCd(JSPUtil.getParameter(request, prefix + "jb_tp_cd", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
		setMaxWrkDt(JSPUtil.getParameter(request, prefix + "max_wrk_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
		setN3ptyBilCsCd(JSPUtil.getParameter(request, prefix + "n3pty_bil_cs_cd", ""));
		setIsValidYdCd(JSPUtil.getParameter(request, prefix + "is_valid_yd_cd", ""));
		setEx(JSPUtil.getParameter(request, prefix + "ex", ""));
		setParamVal(JSPUtil.getParameter(request, prefix + "param_val", ""));
		setIdx(JSPUtil.getParameter(request, prefix + "idx", ""));
		setVndrSeqExisting(JSPUtil.getParameter(request, prefix + "vndr_seq_existing", ""));
		setStALgsCostCd(JSPUtil.getParameter(request, prefix + "st_a_lgs_cost_cd", ""));
		setYdFctyTpRailRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_flg", ""));
		setCsrStatus(JSPUtil.getParameter(request, prefix + "csr_status", ""));
		setTmpMgstNo(JSPUtil.getParameter(request, prefix + "tmp_mgst_no", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setSavedFileName(JSPUtil.getParameter(request, prefix + "saved_file_name", ""));
		setCurrList(JSPUtil.getParameter(request, prefix + "curr_list", ""));
		setOnALgsCostCd(JSPUtil.getParameter(request, prefix + "on_a_lgs_cost_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCoid(JSPUtil.getParameter(request, prefix + "coid", ""));
		setPgmUrl(JSPUtil.getParameter(request, prefix + "pgm_url", ""));
		setMinWrkDt(JSPUtil.getParameter(request, prefix + "min_wrk_dt", ""));
		setExePerfLogSeq(JSPUtil.getParameter(request, prefix + "exe_perf_log_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setYn(JSPUtil.getParameter(request, prefix + "yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesCommonVO[]
	 */
	public TesCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesCommonVO[]
	 */
	public TesCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otALgsCostCd = (JSPUtil.getParameter(request, prefix	+ "ot_a_lgs_cost_cd", length));
			String[] agmtFtrInvTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ftr_inv_tp_cd", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] realFileName = (JSPUtil.getParameter(request, prefix	+ "real_file_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rowCnt = (JSPUtil.getParameter(request, prefix	+ "row_cnt", length));
			String[] invRgstSeq = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] carrCd = (JSPUtil.getParameter(request, prefix	+ "carr_cd", length));
			String[] st = (JSPUtil.getParameter(request, prefix	+ "st", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] currDate = (JSPUtil.getParameter(request, prefix	+ "curr_date", length));
			String[] savedPath = (JSPUtil.getParameter(request, prefix	+ "saved_path", length));
			String[] paramLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "param_lgs_cost_cd", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] osALgsCostCd = (JSPUtil.getParameter(request, prefix	+ "os_a_lgs_cost_cd", length));
			String[] actTp = (JSPUtil.getParameter(request, prefix	+ "act_tp", length));
			String[] ydOshpCd = (JSPUtil.getParameter(request, prefix	+ "yd_oshp_cd", length));
			String[] comListYn = (JSPUtil.getParameter(request, prefix	+ "com_list_yn", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] noYdCd = (JSPUtil.getParameter(request, prefix	+ "no_yd_cd", length));
			String[] noOfcCd = (JSPUtil.getParameter(request, prefix	+ "no_ofc_cd", length));
			String[] isExistingOfcCd = (JSPUtil.getParameter(request, prefix	+ "is_existing_ofc_cd", length));
			String[] ydChrInvTpCd = (JSPUtil.getParameter(request, prefix	+ "yd_chr_inv_tp_cd", length));
			String[] calcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "calc_cost_grp_cd", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));
			String[] mode = (JSPUtil.getParameter(request, prefix	+ "mode_", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ydFctyTpCfsFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_cfs_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] functionname = (JSPUtil.getParameter(request, prefix	+ "functionname", length));
			String[] def = (JSPUtil.getParameter(request, prefix	+ "def", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] mtALgsCostCd = (JSPUtil.getParameter(request, prefix	+ "mt_a_lgs_cost_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] costCdInvTpCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd_inv_tp_cd", length));
			String[] jbTpCd = (JSPUtil.getParameter(request, prefix	+ "jb_tp_cd", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] maxWrkDt = (JSPUtil.getParameter(request, prefix	+ "max_wrk_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] n3ptyBilCsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_cs_cd", length));
			String[] isValidYdCd = (JSPUtil.getParameter(request, prefix	+ "is_valid_yd_cd", length));
			String[] ex = (JSPUtil.getParameter(request, prefix	+ "ex", length));
			String[] paramVal = (JSPUtil.getParameter(request, prefix	+ "param_val", length));
			String[] idx = (JSPUtil.getParameter(request, prefix	+ "idx", length));
			String[] vndrSeqExisting = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_existing", length));
			String[] stALgsCostCd = (JSPUtil.getParameter(request, prefix	+ "st_a_lgs_cost_cd", length));
			String[] ydFctyTpRailRmpFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_rail_rmp_flg", length));
			String[] csrStatus = (JSPUtil.getParameter(request, prefix	+ "csr_status", length));
			String[] tmpMgstNo = (JSPUtil.getParameter(request, prefix	+ "tmp_mgst_no", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] savedFileName = (JSPUtil.getParameter(request, prefix	+ "saved_file_name", length));
			String[] currList = (JSPUtil.getParameter(request, prefix	+ "curr_list", length));
			String[] onALgsCostCd = (JSPUtil.getParameter(request, prefix	+ "on_a_lgs_cost_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] coid = (JSPUtil.getParameter(request, prefix	+ "coid", length));
			String[] pgmUrl = (JSPUtil.getParameter(request, prefix	+ "pgm_url", length));
			String[] minWrkDt = (JSPUtil.getParameter(request, prefix	+ "min_wrk_dt", length));
			String[] exePerfLogSeq = (JSPUtil.getParameter(request, prefix	+ "exe_perf_log_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] yn = (JSPUtil.getParameter(request, prefix	+ "yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesCommonVO();
				if (otALgsCostCd[i] != null)
					model.setOtALgsCostCd(otALgsCostCd[i]);
				if (agmtFtrInvTpCd[i] != null)
					model.setAgmtFtrInvTpCd(agmtFtrInvTpCd[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (realFileName[i] != null)
					model.setRealFileName(realFileName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rowCnt[i] != null)
					model.setRowCnt(rowCnt[i]);
				if (invRgstSeq[i] != null)
					model.setInvRgstSeq(invRgstSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (carrCd[i] != null)
					model.setCarrCd(carrCd[i]);
				if (st[i] != null)
					model.setSt(st[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (currDate[i] != null)
					model.setCurrDate(currDate[i]);
				if (savedPath[i] != null)
					model.setSavedPath(savedPath[i]);
				if (paramLgsCostCd[i] != null)
					model.setParamLgsCostCd(paramLgsCostCd[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (osALgsCostCd[i] != null)
					model.setOsALgsCostCd(osALgsCostCd[i]);
				if (actTp[i] != null)
					model.setActTp(actTp[i]);
				if (ydOshpCd[i] != null)
					model.setYdOshpCd(ydOshpCd[i]);
				if (comListYn[i] != null)
					model.setComListYn(comListYn[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (noYdCd[i] != null)
					model.setNoYdCd(noYdCd[i]);
				if (noOfcCd[i] != null)
					model.setNoOfcCd(noOfcCd[i]);
				if (isExistingOfcCd[i] != null)
					model.setIsExistingOfcCd(isExistingOfcCd[i]);
				if (ydChrInvTpCd[i] != null)
					model.setYdChrInvTpCd(ydChrInvTpCd[i]);
				if (calcCostGrpCd[i] != null)
					model.setCalcCostGrpCd(calcCostGrpCd[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				if (mode[i] != null)
					model.setMode(mode[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ydFctyTpCfsFlg[i] != null)
					model.setYdFctyTpCfsFlg(ydFctyTpCfsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (functionname[i] != null)
					model.setFunctionname(functionname[i]);
				if (def[i] != null)
					model.setDef(def[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (mtALgsCostCd[i] != null)
					model.setMtALgsCostCd(mtALgsCostCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (costCdInvTpCd[i] != null)
					model.setCostCdInvTpCd(costCdInvTpCd[i]);
				if (jbTpCd[i] != null)
					model.setJbTpCd(jbTpCd[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (maxWrkDt[i] != null)
					model.setMaxWrkDt(maxWrkDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (n3ptyBilCsCd[i] != null)
					model.setN3ptyBilCsCd(n3ptyBilCsCd[i]);
				if (isValidYdCd[i] != null)
					model.setIsValidYdCd(isValidYdCd[i]);
				if (ex[i] != null)
					model.setEx(ex[i]);
				if (paramVal[i] != null)
					model.setParamVal(paramVal[i]);
				if (idx[i] != null)
					model.setIdx(idx[i]);
				if (vndrSeqExisting[i] != null)
					model.setVndrSeqExisting(vndrSeqExisting[i]);
				if (stALgsCostCd[i] != null)
					model.setStALgsCostCd(stALgsCostCd[i]);
				if (ydFctyTpRailRmpFlg[i] != null)
					model.setYdFctyTpRailRmpFlg(ydFctyTpRailRmpFlg[i]);
				if (csrStatus[i] != null)
					model.setCsrStatus(csrStatus[i]);
				if (tmpMgstNo[i] != null)
					model.setTmpMgstNo(tmpMgstNo[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (savedFileName[i] != null)
					model.setSavedFileName(savedFileName[i]);
				if (currList[i] != null)
					model.setCurrList(currList[i]);
				if (onALgsCostCd[i] != null)
					model.setOnALgsCostCd(onALgsCostCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (coid[i] != null)
					model.setCoid(coid[i]);
				if (pgmUrl[i] != null)
					model.setPgmUrl(pgmUrl[i]);
				if (minWrkDt[i] != null)
					model.setMinWrkDt(minWrkDt[i]);
				if (exePerfLogSeq[i] != null)
					model.setExePerfLogSeq(exePerfLogSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (yn[i] != null)
					model.setYn(yn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesCommonVO[]
	 */
	public TesCommonVO[] getTesCommonVOs(){
		TesCommonVO[] vos = (TesCommonVO[])models.toArray(new TesCommonVO[models.size()]);
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
		this.otALgsCostCd = this.otALgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFtrInvTpCd = this.agmtFtrInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realFileName = this.realFileName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCnt = this.rowCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstSeq = this.invRgstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrCd = this.carrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st = this.st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currDate = this.currDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savedPath = this.savedPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramLgsCostCd = this.paramLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.osALgsCostCd = this.osALgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTp = this.actTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydOshpCd = this.ydOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comListYn = this.comListYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noYdCd = this.noYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfcCd = this.noOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isExistingOfcCd = this.isExistingOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChrInvTpCd = this.ydChrInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCostGrpCd = this.calcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mode = this.mode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpCfsFlg = this.ydFctyTpCfsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionname = this.functionname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.def = this.def .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtALgsCostCd = this.mtALgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdInvTpCd = this.costCdInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbTpCd = this.jbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxWrkDt = this.maxWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilCsCd = this.n3ptyBilCsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidYdCd = this.isValidYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ex = this.ex .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramVal = this.paramVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idx = this.idx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqExisting = this.vndrSeqExisting .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stALgsCostCd = this.stALgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpRailRmpFlg = this.ydFctyTpRailRmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrStatus = this.csrStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMgstNo = this.tmpMgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savedFileName = this.savedFileName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currList = this.currList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onALgsCostCd = this.onALgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coid = this.coid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmUrl = this.pgmUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minWrkDt = this.minWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exePerfLogSeq = this.exePerfLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yn = this.yn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
