/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisGensetVO.java
*@FileTitle : ChassisGensetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.01
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2009.08.01 SHIN DONG IL 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author SHIN DONG IL
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

/**
 * @author 2007621
 *
 */
public class ChassisGensetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChassisGensetVO> models = new ArrayList<ChassisGensetVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String orgGateOutDate = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String toYardValue = null;
	/* Column Info */
	private String refBkgNoSplit = null;
	/* Column Info */
	private String woIssue = null;
	/* Column Info */
	private String isimport = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String fmYardValue = null;
	/* Column Info */
	private String fmLocValue = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String refBlNo = null;
	/* Column Info */
	private String orgGateOutTime = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trspSoCmbTpCd = null;
	/* Column Info */
	private String destGateInDate = null;
	/* Column Info */
	private String destGateInTime = null;
	/* Column Info */
	private String refBkgNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String trspSoCmbSeq2 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String toLocValue = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String chssMgstTrspTpCd = null;
	/* Column Info */
	private String trspSoCmbSeq = null;
	/* Column Info */
	private String sheetRow = null;
	/* Column Info */
	private String viaLocValue = null;
	/* Column Info */
	private String viaYardValue = null;
	/* Column Info */
	private String drLocValue = null;
	/* Column Info */
	private String drYardValue = null;	
	/* Column Info */
	private String ttlDist = null;
	/* Column Info */
	private String lnkDistDivCd	 = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChassisGensetVO() {}

	public ChassisGensetVO(String ibflag, String pagerows, String trspSoCmbSeq, String trspSoCmbSeq2, String trspSoCmbTpCd, String eqNo, String eqTpszCd, String fmNodCd, String fmLocValue, String fmYardValue, String toNodCd, String toLocValue, String toYardValue, String trspCrrModCd, String vndrSeq, String vndrAbbrNm, String lstmCd, String interRmk, String cntrNo, String cntrTpszCd, String refBkgNo, String refBkgNoSplit, String refBlNo, String orgGateOutDate, String orgGateOutTime, String destGateInDate, String destGateInTime, String spclInstrRmk, String trspSoOfcCtyCd, String trspSoSeq, String trspSoTpCd, String trspSoStsCd, String eqKndCd, String chssMgstTrspTpCd, String creOfcCd, String creDt, String creUsrId, String updDt, String updUsrId, String isimport, String woIssue, String sheetRow, String viaLocValue, String viaYardValue, String drLocValue, String drYardValue, String ttlDist, String lnkDistDivCd) {
		this.toNodCd = toNodCd;
		this.trspSoSeq = trspSoSeq;
		this.orgGateOutDate = orgGateOutDate;
		this.creDt = creDt;
		this.toYardValue = toYardValue;
		this.refBkgNoSplit = refBkgNoSplit;
		this.woIssue = woIssue;
		this.isimport = isimport;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.interRmk = interRmk;
		this.creOfcCd = creOfcCd;
		this.cntrTpszCd = cntrTpszCd;
		this.trspSoStsCd = trspSoStsCd;
		this.fmYardValue = fmYardValue;
		this.fmLocValue = fmLocValue;
		this.trspSoTpCd = trspSoTpCd;
		this.spclInstrRmk = spclInstrRmk;
		this.lstmCd = lstmCd;
		this.trspCrrModCd = trspCrrModCd;
		this.refBlNo = refBlNo;
		this.orgGateOutTime = orgGateOutTime;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.trspSoCmbTpCd = trspSoCmbTpCd;
		this.destGateInDate = destGateInDate;
		this.destGateInTime = destGateInTime;
		this.refBkgNo = refBkgNo;
		this.eqTpszCd = eqTpszCd;
		this.fmNodCd = fmNodCd;
		this.trspSoCmbSeq2 = trspSoCmbSeq2;
		this.creUsrId = creUsrId;
		this.toLocValue = toLocValue;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.eqKndCd = eqKndCd;
		this.vndrAbbrNm = vndrAbbrNm;
		this.chssMgstTrspTpCd = chssMgstTrspTpCd;
		this.trspSoCmbSeq = trspSoCmbSeq;
		this.sheetRow = sheetRow;
		this.viaLocValue = viaLocValue; 
		this.viaYardValue = viaYardValue; 
		this.drLocValue = drLocValue;
		this.drYardValue = drYardValue;
		this.ttlDist = ttlDist;	
		this.lnkDistDivCd = lnkDistDivCd;	
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("org_gate_out_date", getOrgGateOutDate());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("to_yard_value", getToYardValue());
		this.hashColumns.put("ref_bkg_no_split", getRefBkgNoSplit());
		this.hashColumns.put("wo_issue", getWoIssue());
		this.hashColumns.put("isimport", getIsimport());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("fm_yard_value", getFmYardValue());
		this.hashColumns.put("fm_loc_value", getFmLocValue());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("ref_bl_no", getRefBlNo());
		this.hashColumns.put("org_gate_out_time", getOrgGateOutTime());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trsp_so_cmb_tp_cd", getTrspSoCmbTpCd());
		this.hashColumns.put("dest_gate_in_date", getDestGateInDate());
		this.hashColumns.put("dest_gate_in_time", getDestGateInTime());
		this.hashColumns.put("ref_bkg_no", getRefBkgNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("trsp_so_cmb_seq2", getTrspSoCmbSeq2());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("to_loc_value", getToLocValue());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("chss_mgst_trsp_tp_cd", getChssMgstTrspTpCd());
		this.hashColumns.put("trsp_so_cmb_seq", getTrspSoCmbSeq());
		this.hashColumns.put("sheet_row", getSheetRow());
		this.hashColumns.put("via_loc_value", getViaLocValue());
		this.hashColumns.put("via_yard_value", getViaYardValue());
		this.hashColumns.put("dr_loc_value", getDrLocValue());
		this.hashColumns.put("dr_yard_value", getDrYardValue());
		this.hashColumns.put("ttl_dist", getTtlDist());
		this.hashColumns.put("lnk_dist_div_cd", getLnkDistDivCd());
		
		return this.hashColumns;
	}


	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("org_gate_out_date", "orgGateOutDate");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("to_yard_value", "toYardValue");
		this.hashFields.put("ref_bkg_no_split", "refBkgNoSplit");
		this.hashFields.put("wo_issue", "woIssue");
		this.hashFields.put("isimport", "isimport");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("fm_yard_value", "fmYardValue");
		this.hashFields.put("fm_loc_value", "fmLocValue");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("ref_bl_no", "refBlNo");
		this.hashFields.put("org_gate_out_time", "orgGateOutTime");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trsp_so_cmb_tp_cd", "trspSoCmbTpCd");
		this.hashFields.put("dest_gate_in_date", "destGateInDate");
		this.hashFields.put("dest_gate_in_time", "destGateInTime");
		this.hashFields.put("ref_bkg_no", "refBkgNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("trsp_so_cmb_seq2", "trspSoCmbSeq2");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("to_loc_value", "toLocValue");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("chss_mgst_trsp_tp_cd", "chssMgstTrspTpCd");
		this.hashFields.put("trsp_so_cmb_seq", "trspSoCmbSeq");
		this.hashFields.put("sheet_row", "sheetRow");
		this.hashFields.put("via_loc_value", "viaLocValue");
		this.hashFields.put("via_yard_value", "viaYardValue");
		this.hashFields.put("dr_loc_value", "drLocValue");
		this.hashFields.put("dr_yard_value", "drYardValue");
		this.hashFields.put("ttl_dist", "ttlDist");
		this.hashFields.put("lnk_dist_div_cd", "lnkDistDivCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return orgGateOutDate
	 */
	public String getOrgGateOutDate() {
		return this.orgGateOutDate;
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
	 * @return toYardValue
	 */
	public String getToYardValue() {
		return this.toYardValue;
	}
	
	/**
	 * Column Info
	 * @return refBkgNoSplit
	 */
	public String getRefBkgNoSplit() {
		return this.refBkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return woIssue
	 */
	public String getWoIssue() {
		return this.woIssue;
	}
	
	/**
	 * Column Info
	 * @return isimport
	 */
	public String getIsimport() {
		return this.isimport;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @return fmYardValue
	 */
	public String getFmYardValue() {
		return this.fmYardValue;
	}
	
	/**
	 * Column Info
	 * @return fmLocValue
	 */
	public String getFmLocValue() {
		return this.fmLocValue;
	}
	
	/**
	 * Column Info
	 * @return trspSoTpCd
	 */
	public String getTrspSoTpCd() {
		return this.trspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return refBlNo
	 */
	public String getRefBlNo() {
		return this.refBlNo;
	}
	
	/**
	 * Column Info
	 * @return orgGateOutTime
	 */
	public String getOrgGateOutTime() {
		return this.orgGateOutTime;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return trspSoCmbTpCd
	 */
	public String getTrspSoCmbTpCd() {
		return this.trspSoCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @return destGateInDate
	 */
	public String getDestGateInDate() {
		return this.destGateInDate;
	}
	
	/**
	 * Column Info
	 * @return destGateInTime
	 */
	public String getDestGateInTime() {
		return this.destGateInTime;
	}
	
	/**
	 * Column Info
	 * @return refBkgNo
	 */
	public String getRefBkgNo() {
		return this.refBkgNo;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoCmbSeq2
	 */
	public String getTrspSoCmbSeq2() {
		return this.trspSoCmbSeq2;
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
	 * @return toLocValue
	 */
	public String getToLocValue() {
		return this.toLocValue;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return chssMgstTrspTpCd
	 */
	public String getChssMgstTrspTpCd() {
		return this.chssMgstTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoCmbSeq
	 */
	public String getTrspSoCmbSeq() {
		return this.trspSoCmbSeq;
	}
	
		
	/**
	 * Column Info
	 * @return lnkDistDivCd
	 */	
	public String getLnkDistDivCd() {
		return lnkDistDivCd;
	}
	
	/**
	 * Column Info
	 * @return ttlDist
	 */	
	public String getTtlDist() {
		return ttlDist;
	}
	
	/**
	 * Column Info
	 * @return trspSoCmbSeq
	 */
	public void setTtlDist(String ttlDist) {
		this.ttlDist = ttlDist;
	}

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	/**
	 * Column Info
	 * @return trspSoCmbSeq
	 */
	public void setLnkDistDivCd(String lnkDistDivCd) {
		this.lnkDistDivCd = lnkDistDivCd;
	}

	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param orgGateOutDate
	 */
	public void setOrgGateOutDate(String orgGateOutDate) {
		this.orgGateOutDate = orgGateOutDate;
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
	 * @param toYardValue
	 */
	public void setToYardValue(String toYardValue) {
		this.toYardValue = toYardValue;
	}
	
	/**
	 * Column Info
	 * @param refBkgNoSplit
	 */
	public void setRefBkgNoSplit(String refBkgNoSplit) {
		this.refBkgNoSplit = refBkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param woIssue
	 */
	public void setWoIssue(String woIssue) {
		this.woIssue = woIssue;
	}
	
	/**
	 * Column Info
	 * @param isimport
	 */
	public void setIsimport(String isimport) {
		this.isimport = isimport;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @param fmYardValue
	 */
	public void setFmYardValue(String fmYardValue) {
		this.fmYardValue = fmYardValue;
	}
	
	/**
	 * Column Info
	 * @param fmLocValue
	 */
	public void setFmLocValue(String fmLocValue) {
		this.fmLocValue = fmLocValue;
	}
	
	/**
	 * Column Info
	 * @param trspSoTpCd
	 */
	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param refBlNo
	 */
	public void setRefBlNo(String refBlNo) {
		this.refBlNo = refBlNo;
	}
	
	/**
	 * Column Info
	 * @param orgGateOutTime
	 */
	public void setOrgGateOutTime(String orgGateOutTime) {
		this.orgGateOutTime = orgGateOutTime;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param trspSoCmbTpCd
	 */
	public void setTrspSoCmbTpCd(String trspSoCmbTpCd) {
		this.trspSoCmbTpCd = trspSoCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @param destGateInDate
	 */
	public void setDestGateInDate(String destGateInDate) {
		this.destGateInDate = destGateInDate;
	}
	
	/**
	 * Column Info
	 * @param destGateInTime
	 */
	public void setDestGateInTime(String destGateInTime) {
		this.destGateInTime = destGateInTime;
	}
	
	/**
	 * Column Info
	 * @param refBkgNo
	 */
	public void setRefBkgNo(String refBkgNo) {
		this.refBkgNo = refBkgNo;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoCmbSeq2
	 */
	public void setTrspSoCmbSeq2(String trspSoCmbSeq2) {
		this.trspSoCmbSeq2 = trspSoCmbSeq2;
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
	 * @param toLocValue
	 */
	public void setToLocValue(String toLocValue) {
		this.toLocValue = toLocValue;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param chssMgstTrspTpCd
	 */
	public void setChssMgstTrspTpCd(String chssMgstTrspTpCd) {
		this.chssMgstTrspTpCd = chssMgstTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoCmbSeq
	 */
	public void setTrspSoCmbSeq(String trspSoCmbSeq) {
		this.trspSoCmbSeq = trspSoCmbSeq;
	}

	public String getSheetRow() {
		return sheetRow;
	}

	public void setSheetRow(String sheetRow) {
		this.sheetRow = sheetRow;
	}

	public String getViaLocValue() {
		return viaLocValue;
	}

	public void setViaLocValue(String viaLocValue) {
		this.viaLocValue = viaLocValue;
	}

	public String getViaYardValue() {
		return viaYardValue;
	}

	public void setViaYardValue(String viaYardValue) {
		this.viaYardValue = viaYardValue;
	}

	public String getDrLocValue() {
		return drLocValue;
	}

	public void setDrLocValue(String drLocValue) {
		this.drLocValue = drLocValue;
	}

	public String getDrYardValue() {
		return drYardValue;
	}

	public void setDrYardValue(String drYardValue) {
		this.drYardValue = drYardValue;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setOrgGateOutDate(JSPUtil.getParameter(request, "org_gate_out_date", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setToYardValue(JSPUtil.getParameter(request, "to_yard_value", ""));
		setRefBkgNoSplit(JSPUtil.getParameter(request, "ref_bkg_no_split", ""));
		setWoIssue(JSPUtil.getParameter(request, "wo_issue", ""));
		setIsimport(JSPUtil.getParameter(request, "isimport", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, "trsp_so_sts_cd", ""));
		setFmYardValue(JSPUtil.getParameter(request, "fm_yard_value", ""));
		setFmLocValue(JSPUtil.getParameter(request, "fm_loc_value", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, "trsp_so_tp_cd", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, "spcl_instr_rmk", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, "trsp_crr_mod_cd", ""));
		setRefBlNo(JSPUtil.getParameter(request, "ref_bl_no", ""));
		setOrgGateOutTime(JSPUtil.getParameter(request, "org_gate_out_time", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTrspSoCmbTpCd(JSPUtil.getParameter(request, "trsp_so_cmb_tp_cd", ""));
		setDestGateInDate(JSPUtil.getParameter(request, "dest_gate_in_date", ""));
		setDestGateInTime(JSPUtil.getParameter(request, "dest_gate_in_time", ""));
		setRefBkgNo(JSPUtil.getParameter(request, "ref_bkg_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setTrspSoCmbSeq2(JSPUtil.getParameter(request, "trsp_so_cmb_seq2", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setToLocValue(JSPUtil.getParameter(request, "to_loc_value", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setChssMgstTrspTpCd(JSPUtil.getParameter(request, "chss_mgst_trsp_tp_cd", ""));
		setTrspSoCmbSeq(JSPUtil.getParameter(request, "trsp_so_cmb_seq", ""));
		setSheetRow(JSPUtil.getParameter(request, "sheet_row", ""));
		setViaLocValue(JSPUtil.getParameter(request, "via_loc_value", ""));
		setViaYardValue(JSPUtil.getParameter(request, "via_yard_value", ""));
		setDrLocValue(JSPUtil.getParameter(request, "dr_loc_value", ""));
		setDrYardValue(JSPUtil.getParameter(request, "dr_yard_value", ""));
		setTtlDist(JSPUtil.getParameter(request, "ttl_dist", ""));
		setLnkDistDivCd(JSPUtil.getParameter(request, "lnk_dist_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChassisGensetVO[]
	 */
	public ChassisGensetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChassisGensetVO[]
	 */
	public ChassisGensetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChassisGensetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] orgGateOutDate = (JSPUtil.getParameter(request, prefix	+ "org_gate_out_date", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] toYardValue = (JSPUtil.getParameter(request, prefix	+ "to_yard_value", length));
			String[] refBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "ref_bkg_no_split", length));
			String[] woIssue = (JSPUtil.getParameter(request, prefix	+ "wo_issue", length));
			String[] isimport = (JSPUtil.getParameter(request, prefix	+ "isimport", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			String[] fmYardValue = (JSPUtil.getParameter(request, prefix	+ "fm_yard_value", length));
			String[] fmLocValue = (JSPUtil.getParameter(request, prefix	+ "fm_loc_value", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] refBlNo = (JSPUtil.getParameter(request, prefix	+ "ref_bl_no", length));
			String[] orgGateOutTime = (JSPUtil.getParameter(request, prefix	+ "org_gate_out_time", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trspSoCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_tp_cd", length));
			String[] destGateInDate = (JSPUtil.getParameter(request, prefix	+ "dest_gate_in_date", length));
			String[] destGateInTime = (JSPUtil.getParameter(request, prefix	+ "dest_gate_in_time", length));
			String[] refBkgNo = (JSPUtil.getParameter(request, prefix	+ "ref_bkg_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] trspSoCmbSeq2 = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_seq2", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] toLocValue = (JSPUtil.getParameter(request, prefix	+ "to_loc_value", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] chssMgstTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_trsp_tp_cd", length));
			String[] trspSoCmbSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_seq", length));
			
			String[] sheetRow = (JSPUtil.getParameter(request, prefix	+ "sheet_row", length));
			String[] viaLocValue = (JSPUtil.getParameter(request, prefix	+ "via_loc_value", length));
			String[] viaYardValue = (JSPUtil.getParameter(request, prefix	+ "via_yard_value", length));
			String[] drLocValue = (JSPUtil.getParameter(request, prefix	+ "dr_loc_value", length));
			String[] drYardValue = (JSPUtil.getParameter(request, prefix	+ "dr_yard_value", length));
			
			String[] ttlDist = (JSPUtil.getParameter(request, prefix	+ "ttl_dist", length));
			String[] lnkDistDivCd = (JSPUtil.getParameter(request, prefix	+ "lnk_dist_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChassisGensetVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (orgGateOutDate[i] != null)
					model.setOrgGateOutDate(orgGateOutDate[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (toYardValue[i] != null)
					model.setToYardValue(toYardValue[i]);
				if (refBkgNoSplit[i] != null)
					model.setRefBkgNoSplit(refBkgNoSplit[i]);
				if (woIssue[i] != null)
					model.setWoIssue(woIssue[i]);
				if (isimport[i] != null)
					model.setIsimport(isimport[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (fmYardValue[i] != null)
					model.setFmYardValue(fmYardValue[i]);
				if (fmLocValue[i] != null)
					model.setFmLocValue(fmLocValue[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (refBlNo[i] != null)
					model.setRefBlNo(refBlNo[i]);
				if (orgGateOutTime[i] != null)
					model.setOrgGateOutTime(orgGateOutTime[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trspSoCmbTpCd[i] != null)
					model.setTrspSoCmbTpCd(trspSoCmbTpCd[i]);
				if (destGateInDate[i] != null)
					model.setDestGateInDate(destGateInDate[i]);
				if (destGateInTime[i] != null)
					model.setDestGateInTime(destGateInTime[i]);
				if (refBkgNo[i] != null)
					model.setRefBkgNo(refBkgNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (trspSoCmbSeq2[i] != null)
					model.setTrspSoCmbSeq2(trspSoCmbSeq2[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (toLocValue[i] != null)
					model.setToLocValue(toLocValue[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (chssMgstTrspTpCd[i] != null)
					model.setChssMgstTrspTpCd(chssMgstTrspTpCd[i]);
				if (trspSoCmbSeq[i] != null)
					model.setTrspSoCmbSeq(trspSoCmbSeq[i]);
				if (sheetRow[i] != null)
					model.setSheetRow(sheetRow[i]);
				if (viaLocValue[i] != null)
					model.setViaLocValue(viaLocValue[i]);
				if (viaYardValue[i] != null)
					model.setViaYardValue(viaYardValue[i]);
				if (drLocValue[i] != null)
					model.setDrLocValue(drLocValue[i]);
				if (drYardValue[i] != null)
					model.setDrYardValue(drYardValue[i]);
				if (ttlDist[i] != null)
					model.setTtlDist(ttlDist[i]);
				if (lnkDistDivCd[i] != null)
					model.setLnkDistDivCd(lnkDistDivCd[i]);	
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChassisGensetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChassisGensetVO[]
	 */
	public ChassisGensetVO[] getChassisGensetVOs(){
		ChassisGensetVO[] vos = (ChassisGensetVO[])models.toArray(new ChassisGensetVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateOutDate = this.orgGateOutDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYardValue = this.toYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refBkgNoSplit = this.refBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssue = this.woIssue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isimport = this.isimport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYardValue = this.fmYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocValue = this.fmLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refBlNo = this.refBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateOutTime = this.orgGateOutTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpCd = this.trspSoCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destGateInDate = this.destGateInDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destGateInTime = this.destGateInTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refBkgNo = this.refBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSeq2 = this.trspSoCmbSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocValue = this.toLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstTrspTpCd = this.chssMgstTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSeq = this.trspSoCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRow = this.sheetRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaLocValue = this.viaLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaYardValue = this.viaYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drLocValue = this.drLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drYardValue = this.drYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDist = this.ttlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDistDivCd = this.lnkDistDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
