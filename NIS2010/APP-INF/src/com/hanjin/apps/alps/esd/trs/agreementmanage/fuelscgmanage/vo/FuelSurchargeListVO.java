/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FuelSurchargeListVO.java
*@FileTitle : FuelSurchargeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.05.14 DONG- IL, SHIN 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.vo;

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
 * @author DONG- IL, SHIN
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FuelSurchargeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FuelSurchargeListVO> models = new ArrayList<FuelSurchargeListVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String railSvcTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String agmtRoutAllFlg = null;
	/* Column Info */
	private String toNodYd = null;
	/* Column Info */
	private String toWgt = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String trspAgmtRtTpSerNo = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String trspRndRt = null;
	/* Column Info */
	private String trspAgmtRtTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String rateTotCnt = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String trspAgmtScgNodSeq = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String agmtScgRtDivCd = null;
	/* Column Info */
	private String trspScgCd = null;
	/* Column Info */
	private String trspCostModCd = null;
	/* Column Info */
	private String fmNodYd = null;
	/* Column Info */
	private String trspOneWyRt = null;
	/* Column Info */
	private String trspAgmtScgRtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String cmdtGrpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String dorNodYd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String agmtTrspTpCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String viaNodYd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FuelSurchargeListVO() {}

	public FuelSurchargeListVO(String ibflag, String pagerows, String trspAgmtRtTpCd, String agmtNo, String vndrSeq, String vndrNm, String trspCostModCd, String agmtTrspTpCd, String eqKndCd, String cgoTpCd, String custCd, String cmdtGrpCd, String railSvcTpCd, String agmtRoutAllFlg, String effFmDt, String effToDt, String agmtScgRtDivCd, String trspOneWyRt, String trspRndRt, String updUsrId, String updUsrNm, String updOfcCd, String rateTotCnt, String trspAgmtOfcCtyCd, String trspAgmtSeq, String trspAgmtRtTpSerNo, String trspAgmtScgNodSeq, String trspAgmtScgRtSeq, String fmNodCd, String fmNodYd, String viaNodCd, String viaNodYd, String dorNodCd, String dorNodYd, String toNodCd, String toNodYd, String toWgt, String wgtMeasUtCd, String trspScgCd, String currCd, String ctrtOfcCd) {
		this.toNodCd = toNodCd;
		this.railSvcTpCd = railSvcTpCd;
		this.currCd = currCd;
		this.agmtRoutAllFlg = agmtRoutAllFlg;
		this.toNodYd = toNodYd;
		this.toWgt = toWgt;
		this.cgoTpCd = cgoTpCd;
		this.trspAgmtRtTpSerNo = trspAgmtRtTpSerNo;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.trspRndRt = trspRndRt;
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.ctrtOfcCd = ctrtOfcCd;
		this.rateTotCnt = rateTotCnt;
		this.dorNodCd = dorNodCd;
		this.trspAgmtScgNodSeq = trspAgmtScgNodSeq;
		this.effFmDt = effFmDt;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.agmtScgRtDivCd = agmtScgRtDivCd;
		this.trspScgCd = trspScgCd;
		this.trspCostModCd = trspCostModCd;
		this.fmNodYd = fmNodYd;
		this.trspOneWyRt = trspOneWyRt;
		this.trspAgmtScgRtSeq = trspAgmtScgRtSeq;
		this.agmtNo = agmtNo;
		this.cmdtGrpCd = cmdtGrpCd;
		this.eqKndCd = eqKndCd;
		this.dorNodYd = dorNodYd;
		this.fmNodCd = fmNodCd;
		this.trspAgmtSeq = trspAgmtSeq;
		this.custCd = custCd;
		this.vndrSeq = vndrSeq;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.viaNodCd = viaNodCd;
		this.agmtTrspTpCd = agmtTrspTpCd;
		this.effToDt = effToDt;
		this.updUsrNm = updUsrNm;
		this.viaNodYd = viaNodYd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("rail_svc_tp_cd", getRailSvcTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("agmt_rout_all_flg", getAgmtRoutAllFlg());
		this.hashColumns.put("to_nod_yd", getToNodYd());
		this.hashColumns.put("to_wgt", getToWgt());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("trsp_agmt_rt_tp_ser_no", getTrspAgmtRtTpSerNo());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("trsp_rnd_rt", getTrspRndRt());
		this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("rate_tot_cnt", getRateTotCnt());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("trsp_agmt_scg_nod_seq", getTrspAgmtScgNodSeq());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("agmt_scg_rt_div_cd", getAgmtScgRtDivCd());
		this.hashColumns.put("trsp_scg_cd", getTrspScgCd());
		this.hashColumns.put("trsp_cost_mod_cd", getTrspCostModCd());
		this.hashColumns.put("fm_nod_yd", getFmNodYd());
		this.hashColumns.put("trsp_one_wy_rt", getTrspOneWyRt());
		this.hashColumns.put("trsp_agmt_scg_rt_seq", getTrspAgmtScgRtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cmdt_grp_cd", getCmdtGrpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("dor_nod_yd", getDorNodYd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("agmt_trsp_tp_cd", getAgmtTrspTpCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("via_nod_yd", getViaNodYd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("rail_svc_tp_cd", "railSvcTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agmt_rout_all_flg", "agmtRoutAllFlg");
		this.hashFields.put("to_nod_yd", "toNodYd");
		this.hashFields.put("to_wgt", "toWgt");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("trsp_agmt_rt_tp_ser_no", "trspAgmtRtTpSerNo");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("trsp_rnd_rt", "trspRndRt");
		this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("rate_tot_cnt", "rateTotCnt");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("trsp_agmt_scg_nod_seq", "trspAgmtScgNodSeq");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("agmt_scg_rt_div_cd", "agmtScgRtDivCd");
		this.hashFields.put("trsp_scg_cd", "trspScgCd");
		this.hashFields.put("trsp_cost_mod_cd", "trspCostModCd");
		this.hashFields.put("fm_nod_yd", "fmNodYd");
		this.hashFields.put("trsp_one_wy_rt", "trspOneWyRt");
		this.hashFields.put("trsp_agmt_scg_rt_seq", "trspAgmtScgRtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cmdt_grp_cd", "cmdtGrpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("dor_nod_yd", "dorNodYd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("agmt_trsp_tp_cd", "agmtTrspTpCd");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("via_nod_yd", "viaNodYd");
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
	 * @return railSvcTpCd
	 */
	public String getRailSvcTpCd() {
		return this.railSvcTpCd;
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
	 * @return agmtRoutAllFlg
	 */
	public String getAgmtRoutAllFlg() {
		return this.agmtRoutAllFlg;
	}
	
	/**
	 * Column Info
	 * @return toNodYd
	 */
	public String getToNodYd() {
		return this.toNodYd;
	}
	
	/**
	 * Column Info
	 * @return toWgt
	 */
	public String getToWgt() {
		return this.toWgt;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRtTpSerNo
	 */
	public String getTrspAgmtRtTpSerNo() {
		return this.trspAgmtRtTpSerNo;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trspRndRt
	 */
	public String getTrspRndRt() {
		return this.trspRndRt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRtTpCd
	 */
	public String getTrspAgmtRtTpCd() {
		return this.trspAgmtRtTpCd;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rateTotCnt
	 */
	public String getRateTotCnt() {
		return this.rateTotCnt;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtScgNodSeq
	 */
	public String getTrspAgmtScgNodSeq() {
		return this.trspAgmtScgNodSeq;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtScgRtDivCd
	 */
	public String getAgmtScgRtDivCd() {
		return this.agmtScgRtDivCd;
	}
	
	/**
	 * Column Info
	 * @return trspScgCd
	 */
	public String getTrspScgCd() {
		return this.trspScgCd;
	}
	
	/**
	 * Column Info
	 * @return trspCostModCd
	 */
	public String getTrspCostModCd() {
		return this.trspCostModCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodYd
	 */
	public String getFmNodYd() {
		return this.fmNodYd;
	}
	
	/**
	 * Column Info
	 * @return trspOneWyRt
	 */
	public String getTrspOneWyRt() {
		return this.trspOneWyRt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtScgRtSeq
	 */
	public String getTrspAgmtScgRtSeq() {
		return this.trspAgmtScgRtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtGrpCd
	 */
	public String getCmdtGrpCd() {
		return this.cmdtGrpCd;
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
	 * @return dorNodYd
	 */
	public String getDorNodYd() {
		return this.dorNodYd;
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
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return wgtMeasUtCd
	 */
	public String getWgtMeasUtCd() {
		return this.wgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return agmtTrspTpCd
	 */
	public String getAgmtTrspTpCd() {
		return this.agmtTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return viaNodYd
	 */
	public String getViaNodYd() {
		return this.viaNodYd;
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
	 * @param railSvcTpCd
	 */
	public void setRailSvcTpCd(String railSvcTpCd) {
		this.railSvcTpCd = railSvcTpCd;
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
	 * @param agmtRoutAllFlg
	 */
	public void setAgmtRoutAllFlg(String agmtRoutAllFlg) {
		this.agmtRoutAllFlg = agmtRoutAllFlg;
	}
	
	/**
	 * Column Info
	 * @param toNodYd
	 */
	public void setToNodYd(String toNodYd) {
		this.toNodYd = toNodYd;
	}
	
	/**
	 * Column Info
	 * @param toWgt
	 */
	public void setToWgt(String toWgt) {
		this.toWgt = toWgt;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRtTpSerNo
	 */
	public void setTrspAgmtRtTpSerNo(String trspAgmtRtTpSerNo) {
		this.trspAgmtRtTpSerNo = trspAgmtRtTpSerNo;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trspRndRt
	 */
	public void setTrspRndRt(String trspRndRt) {
		this.trspRndRt = trspRndRt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRtTpCd
	 */
	public void setTrspAgmtRtTpCd(String trspAgmtRtTpCd) {
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rateTotCnt
	 */
	public void setRateTotCnt(String rateTotCnt) {
		this.rateTotCnt = rateTotCnt;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtScgNodSeq
	 */
	public void setTrspAgmtScgNodSeq(String trspAgmtScgNodSeq) {
		this.trspAgmtScgNodSeq = trspAgmtScgNodSeq;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtScgRtDivCd
	 */
	public void setAgmtScgRtDivCd(String agmtScgRtDivCd) {
		this.agmtScgRtDivCd = agmtScgRtDivCd;
	}
	
	/**
	 * Column Info
	 * @param trspScgCd
	 */
	public void setTrspScgCd(String trspScgCd) {
		this.trspScgCd = trspScgCd;
	}
	
	/**
	 * Column Info
	 * @param trspCostModCd
	 */
	public void setTrspCostModCd(String trspCostModCd) {
		this.trspCostModCd = trspCostModCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodYd
	 */
	public void setFmNodYd(String fmNodYd) {
		this.fmNodYd = fmNodYd;
	}
	
	/**
	 * Column Info
	 * @param trspOneWyRt
	 */
	public void setTrspOneWyRt(String trspOneWyRt) {
		this.trspOneWyRt = trspOneWyRt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtScgRtSeq
	 */
	public void setTrspAgmtScgRtSeq(String trspAgmtScgRtSeq) {
		this.trspAgmtScgRtSeq = trspAgmtScgRtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtGrpCd
	 */
	public void setCmdtGrpCd(String cmdtGrpCd) {
		this.cmdtGrpCd = cmdtGrpCd;
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
	 * @param dorNodYd
	 */
	public void setDorNodYd(String dorNodYd) {
		this.dorNodYd = dorNodYd;
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
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param wgtMeasUtCd
	 */
	public void setWgtMeasUtCd(String wgtMeasUtCd) {
		this.wgtMeasUtCd = wgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param agmtTrspTpCd
	 */
	public void setAgmtTrspTpCd(String agmtTrspTpCd) {
		this.agmtTrspTpCd = agmtTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param viaNodYd
	 */
	public void setViaNodYd(String viaNodYd) {
		this.viaNodYd = viaNodYd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setRailSvcTpCd(JSPUtil.getParameter(request, prefix + "rail_svc_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setAgmtRoutAllFlg(JSPUtil.getParameter(request, prefix + "agmt_rout_all_flg", ""));
		setToNodYd(JSPUtil.getParameter(request, prefix + "to_nod_yd", ""));
		setToWgt(JSPUtil.getParameter(request, prefix + "to_wgt", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setTrspAgmtRtTpSerNo(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_ser_no", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));
		setTrspRndRt(JSPUtil.getParameter(request, prefix + "trsp_rnd_rt", ""));
		setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setRateTotCnt(JSPUtil.getParameter(request, prefix + "rate_tot_cnt", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setTrspAgmtScgNodSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_scg_nod_seq", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setAgmtScgRtDivCd(JSPUtil.getParameter(request, prefix + "agmt_scg_rt_div_cd", ""));
		setTrspScgCd(JSPUtil.getParameter(request, prefix + "trsp_scg_cd", ""));
		setTrspCostModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_mod_cd", ""));
		setFmNodYd(JSPUtil.getParameter(request, prefix + "fm_nod_yd", ""));
		setTrspOneWyRt(JSPUtil.getParameter(request, prefix + "trsp_one_wy_rt", ""));
		setTrspAgmtScgRtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_scg_rt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCmdtGrpCd(JSPUtil.getParameter(request, prefix + "cmdt_grp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setDorNodYd(JSPUtil.getParameter(request, prefix + "dor_nod_yd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setAgmtTrspTpCd(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setViaNodYd(JSPUtil.getParameter(request, prefix + "via_nod_yd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FuelSurchargeListVO[]
	 */
	public FuelSurchargeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FuelSurchargeListVO[]
	 */
	public FuelSurchargeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FuelSurchargeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] railSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_svc_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] agmtRoutAllFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_rout_all_flg", length));
			String[] toNodYd = (JSPUtil.getParameter(request, prefix	+ "to_nod_yd", length));
			String[] toWgt = (JSPUtil.getParameter(request, prefix	+ "to_wgt", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] trspAgmtRtTpSerNo = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_ser_no", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_ofc_cty_cd", length));
			String[] trspRndRt = (JSPUtil.getParameter(request, prefix	+ "trsp_rnd_rt", length));
			String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] rateTotCnt = (JSPUtil.getParameter(request, prefix	+ "rate_tot_cnt", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] trspAgmtScgNodSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_scg_nod_seq", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] agmtScgRtDivCd = (JSPUtil.getParameter(request, prefix	+ "agmt_scg_rt_div_cd", length));
			String[] trspScgCd = (JSPUtil.getParameter(request, prefix	+ "trsp_scg_cd", length));
			String[] trspCostModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_mod_cd", length));
			String[] fmNodYd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yd", length));
			String[] trspOneWyRt = (JSPUtil.getParameter(request, prefix	+ "trsp_one_wy_rt", length));
			String[] trspAgmtScgRtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_scg_rt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] cmdtGrpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_grp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] dorNodYd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_yd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_seq", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_meas_ut_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] agmtTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_trsp_tp_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] viaNodYd = (JSPUtil.getParameter(request, prefix	+ "via_nod_yd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FuelSurchargeListVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (railSvcTpCd[i] != null)
					model.setRailSvcTpCd(railSvcTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (agmtRoutAllFlg[i] != null)
					model.setAgmtRoutAllFlg(agmtRoutAllFlg[i]);
				if (toNodYd[i] != null)
					model.setToNodYd(toNodYd[i]);
				if (toWgt[i] != null)
					model.setToWgt(toWgt[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (trspAgmtRtTpSerNo[i] != null)
					model.setTrspAgmtRtTpSerNo(trspAgmtRtTpSerNo[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (trspRndRt[i] != null)
					model.setTrspRndRt(trspRndRt[i]);
				if (trspAgmtRtTpCd[i] != null)
					model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (rateTotCnt[i] != null)
					model.setRateTotCnt(rateTotCnt[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (trspAgmtScgNodSeq[i] != null)
					model.setTrspAgmtScgNodSeq(trspAgmtScgNodSeq[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (agmtScgRtDivCd[i] != null)
					model.setAgmtScgRtDivCd(agmtScgRtDivCd[i]);
				if (trspScgCd[i] != null)
					model.setTrspScgCd(trspScgCd[i]);
				if (trspCostModCd[i] != null)
					model.setTrspCostModCd(trspCostModCd[i]);
				if (fmNodYd[i] != null)
					model.setFmNodYd(fmNodYd[i]);
				if (trspOneWyRt[i] != null)
					model.setTrspOneWyRt(trspOneWyRt[i]);
				if (trspAgmtScgRtSeq[i] != null)
					model.setTrspAgmtScgRtSeq(trspAgmtScgRtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (cmdtGrpCd[i] != null)
					model.setCmdtGrpCd(cmdtGrpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (dorNodYd[i] != null)
					model.setDorNodYd(dorNodYd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (agmtTrspTpCd[i] != null)
					model.setAgmtTrspTpCd(agmtTrspTpCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (viaNodYd[i] != null)
					model.setViaNodYd(viaNodYd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFuelSurchargeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FuelSurchargeListVO[]
	 */
	public FuelSurchargeListVO[] getFuelSurchargeListVOs(){
		FuelSurchargeListVO[] vos = (FuelSurchargeListVO[])models.toArray(new FuelSurchargeListVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railSvcTpCd = this.railSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRoutAllFlg = this.agmtRoutAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYd = this.toNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWgt = this.toWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpSerNo = this.trspAgmtRtTpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRndRt = this.trspRndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpCd = this.trspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTotCnt = this.rateTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtScgNodSeq = this.trspAgmtScgNodSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtScgRtDivCd = this.agmtScgRtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspScgCd = this.trspScgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostModCd = this.trspCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYd = this.fmNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspOneWyRt = this.trspOneWyRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtScgRtSeq = this.trspAgmtScgRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtGrpCd = this.cmdtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodYd = this.dorNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTrspTpCd = this.agmtTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodYd = this.viaNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
