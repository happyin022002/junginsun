/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsComScgMgmtTpSzVO.java
*@FileTitle : TrsComScgMgmtTpSzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo;

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

public class TrsComScgMgmtTpSzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsComScgMgmtTpSzVO> models = new ArrayList<TrsComScgMgmtTpSzVO>();
	
	/* Column Info */
	private String trspCostModDesc = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String woAplyFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String oneWyRt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String trspCostModNm = null;
	/* Column Info */
	private String rndRt = null;
	/* Column Info */
	private String comScgKndNm = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String bndNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cgoTpNm = null;
	/* Column Info */
	private String comScgSeq = null;
	/* Column Info */
	private String trspCostModCd = null;
	/* Column Info */
	private String rtTpCd = null;
	/* Column Info */
	private String agmtTrspTpDesc = null;
	/* Column Info */
	private String eqSzDesc = null;
	/* Column Info */
	private String bndCd = null;
	/* Column Info */
	private String comScgKndCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String agmtTrspTpNm = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String currDesc = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String eqTpDesc = null;
	/* Column Info */
	private String eqTpNm = null;
	/* Column Info */
	private String currNm = null;
	/* Column Info */
	private String agmtTrspTpCd = null;
	/* Column Info */
	private String eqTpCd = null;
	/* Column Info */
	private String eqSzNm = null;
	/* Column Info */
	private String eqSzCd = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String rtTpNm = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info : UI GRID row number */
	private String seq = null;
	/* Column Info : UI Date Search Condition */
	private String dtCond = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrsComScgMgmtTpSzVO() {}

	public TrsComScgMgmtTpSzVO(String ibflag, String pagerows, String comScgKndCd, String comScgKndNm, String comScgSeq, String trspCostModCd, String trspCostModNm, String trspCostModDesc, String agmtTrspTpCd, String agmtTrspTpNm, String agmtTrspTpDesc, String rccCd, String lccCd, String sccCd, String eqKndCd, String eqKndNm, String eqTpszCd, String eqTpCd, String eqTpNm, String eqTpDesc, String eqSzCd, String eqSzNm, String eqSzDesc, String cgoTpCd, String cgoTpNm, String bndCd, String bndNm, String rtTpCd, String rtTpNm, String currCd, String currNm, String currDesc, String oneWyRt, String rndRt, String effFmDt, String effToDt, 
			String woAplyFlg, String creUsrId, String creUsrNm, String creDt, String updUsrId, String updUsrNm, String updDt, String effDt, String usrOfcCd, String seq, String dtCond) {
		this.trspCostModDesc = trspCostModDesc;
		this.currCd = currCd;
		this.woAplyFlg = woAplyFlg;
		this.creDt = creDt;
		this.cgoTpCd = cgoTpCd;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.oneWyRt = oneWyRt;
		this.ibflag = ibflag;
		this.eqKndNm = eqKndNm;
		this.trspCostModNm = trspCostModNm;
		this.rndRt = rndRt;
		this.comScgKndNm = comScgKndNm;
		this.effFmDt = effFmDt;
		this.bndNm = bndNm;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.cgoTpNm = cgoTpNm;
		this.comScgSeq = comScgSeq;
		this.trspCostModCd = trspCostModCd;
		this.rtTpCd = rtTpCd;
		this.agmtTrspTpDesc = agmtTrspTpDesc;
		this.eqSzDesc = eqSzDesc;
		this.bndCd = bndCd;
		this.comScgKndCd = comScgKndCd;
		this.rccCd = rccCd;
		this.agmtTrspTpNm = agmtTrspTpNm;
		this.creUsrNm = creUsrNm;
		this.eqKndCd = eqKndCd;
		this.eqTpszCd = eqTpszCd;
		this.currDesc = currDesc;
		this.lccCd = lccCd;
		this.creUsrId = creUsrId;
		this.sccCd = sccCd;
		this.eqTpDesc = eqTpDesc;
		this.eqTpNm = eqTpNm;
		this.currNm = currNm;
		this.agmtTrspTpCd = agmtTrspTpCd;
		this.eqTpCd = eqTpCd;
		this.eqSzNm = eqSzNm;
		this.eqSzCd = eqSzCd;
		this.updUsrNm = updUsrNm;
		this.effToDt = effToDt;
		this.rtTpNm = rtTpNm;
		this.usrOfcCd = usrOfcCd;
		this.seq = seq;
		this.dtCond = dtCond;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_cost_mod_desc", getTrspCostModDesc());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("wo_aply_flg", getWoAplyFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("one_wy_rt", getOneWyRt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("trsp_cost_mod_nm", getTrspCostModNm());
		this.hashColumns.put("rnd_rt", getRndRt());
		this.hashColumns.put("com_scg_knd_nm", getComScgKndNm());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("bnd_nm", getBndNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cgo_tp_nm", getCgoTpNm());
		this.hashColumns.put("com_scg_seq", getComScgSeq());
		this.hashColumns.put("trsp_cost_mod_cd", getTrspCostModCd());
		this.hashColumns.put("rt_tp_cd", getRtTpCd());
		this.hashColumns.put("agmt_trsp_tp_desc", getAgmtTrspTpDesc());
		this.hashColumns.put("eq_sz_desc", getEqSzDesc());
		this.hashColumns.put("bnd_cd", getBndCd());
		this.hashColumns.put("com_scg_knd_cd", getComScgKndCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("agmt_trsp_tp_nm", getAgmtTrspTpNm());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("curr_desc", getCurrDesc());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("eq_tp_desc", getEqTpDesc());
		this.hashColumns.put("eq_tp_nm", getEqTpNm());
		this.hashColumns.put("curr_nm", getCurrNm());
		this.hashColumns.put("agmt_trsp_tp_cd", getAgmtTrspTpCd());
		this.hashColumns.put("eq_tp_cd", getEqTpCd());
		this.hashColumns.put("eq_sz_nm", getEqSzNm());
		this.hashColumns.put("eq_sz_cd", getEqSzCd());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("rt_tp_nm", getRtTpNm());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("dt_cond", getDtCond());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_cost_mod_desc", "trspCostModDesc");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("wo_aply_flg", "woAplyFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("one_wy_rt", "oneWyRt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("trsp_cost_mod_nm", "trspCostModNm");
		this.hashFields.put("rnd_rt", "rndRt");
		this.hashFields.put("com_scg_knd_nm", "comScgKndNm");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("bnd_nm", "bndNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cgo_tp_nm", "cgoTpNm");
		this.hashFields.put("com_scg_seq", "comScgSeq");
		this.hashFields.put("trsp_cost_mod_cd", "trspCostModCd");
		this.hashFields.put("rt_tp_cd", "rtTpCd");
		this.hashFields.put("agmt_trsp_tp_desc", "agmtTrspTpDesc");
		this.hashFields.put("eq_sz_desc", "eqSzDesc");
		this.hashFields.put("bnd_cd", "bndCd");
		this.hashFields.put("com_scg_knd_cd", "comScgKndCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("agmt_trsp_tp_nm", "agmtTrspTpNm");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("curr_desc", "currDesc");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("eq_tp_desc", "eqTpDesc");
		this.hashFields.put("eq_tp_nm", "eqTpNm");
		this.hashFields.put("curr_nm", "currNm");
		this.hashFields.put("agmt_trsp_tp_cd", "agmtTrspTpCd");
		this.hashFields.put("eq_tp_cd", "eqTpCd");
		this.hashFields.put("eq_sz_nm", "eqSzNm");
		this.hashFields.put("eq_sz_cd", "eqSzCd");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("rt_tp_nm", "rtTpNm");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("dt_cond", "dtCond");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trspCostModDesc
	 */
	public String getTrspCostModDesc() {
		return this.trspCostModDesc;
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
	 * @return woAplyFlg
	 */
	public String getWoAplyFlg() {
		return this.woAplyFlg;
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
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return oneWyRt
	 */
	public String getOneWyRt() {
		return this.oneWyRt;
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
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
	}
	
	/**
	 * Column Info
	 * @return trspCostModNm
	 */
	public String getTrspCostModNm() {
		return this.trspCostModNm;
	}
	
	/**
	 * Column Info
	 * @return rndRt
	 */
	public String getRndRt() {
		return this.rndRt;
	}
	
	/**
	 * Column Info
	 * @return comScgKndNm
	 */
	public String getComScgKndNm() {
		return this.comScgKndNm;
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
	 * @return bndNm
	 */
	public String getBndNm() {
		return this.bndNm;
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
	 * @return cgoTpNm
	 */
	public String getCgoTpNm() {
		return this.cgoTpNm;
	}
	
	/**
	 * Column Info
	 * @return comScgSeq
	 */
	public String getComScgSeq() {
		return this.comScgSeq;
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
	 * @return rtTpCd
	 */
	public String getRtTpCd() {
		return this.rtTpCd;
	}
	
	/**
	 * Column Info
	 * @return agmtTrspTpDesc
	 */
	public String getAgmtTrspTpDesc() {
		return this.agmtTrspTpDesc;
	}
	
	/**
	 * Column Info
	 * @return eqSzDesc
	 */
	public String getEqSzDesc() {
		return this.eqSzDesc;
	}
	
	/**
	 * Column Info
	 * @return bndCd
	 */
	public String getBndCd() {
		return this.bndCd;
	}
	
	/**
	 * Column Info
	 * @return comScgKndCd
	 */
	public String getComScgKndCd() {
		return this.comScgKndCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return agmtTrspTpNm
	 */
	public String getAgmtTrspTpNm() {
		return this.agmtTrspTpNm;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return currDesc
	 */
	public String getCurrDesc() {
		return this.currDesc;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpDesc
	 */
	public String getEqTpDesc() {
		return this.eqTpDesc;
	}
	
	/**
	 * Column Info
	 * @return eqTpNm
	 */
	public String getEqTpNm() {
		return this.eqTpNm;
	}
	
	/**
	 * Column Info
	 * @return currNm
	 */
	public String getCurrNm() {
		return this.currNm;
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
	 * @return eqTpCd
	 */
	public String getEqTpCd() {
		return this.eqTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqSzNm
	 */
	public String getEqSzNm() {
		return this.eqSzNm;
	}
	
	/**
	 * Column Info
	 * @return eqSzCd
	 */
	public String getEqSzCd() {
		return this.eqSzCd;
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
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}
	
	/**
	 * Column Info
	 * @return rtTpNm
	 */
	public String getRtTpNm() {
		return this.rtTpNm;
	}
	
	/**
	 * Column Info
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * Column Info
	 * @return dtCond
	 */
	public String getDtCond() {
		return dtCond;
	}

	/**
	 * Column Info
	 * @param trspCostModDesc
	 */
	public void setTrspCostModDesc(String trspCostModDesc) {
		this.trspCostModDesc = trspCostModDesc;
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
	 * @param woAplyFlg
	 */
	public void setWoAplyFlg(String woAplyFlg) {
		this.woAplyFlg = woAplyFlg;
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
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param oneWyRt
	 */
	public void setOneWyRt(String oneWyRt) {
		this.oneWyRt = oneWyRt;
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
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
	}
	
	/**
	 * Column Info
	 * @param trspCostModNm
	 */
	public void setTrspCostModNm(String trspCostModNm) {
		this.trspCostModNm = trspCostModNm;
	}
	
	/**
	 * Column Info
	 * @param rndRt
	 */
	public void setRndRt(String rndRt) {
		this.rndRt = rndRt;
	}
	
	/**
	 * Column Info
	 * @param comScgKndNm
	 */
	public void setComScgKndNm(String comScgKndNm) {
		this.comScgKndNm = comScgKndNm;
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
	 * @param bndNm
	 */
	public void setBndNm(String bndNm) {
		this.bndNm = bndNm;
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
	 * @param cgoTpNm
	 */
	public void setCgoTpNm(String cgoTpNm) {
		this.cgoTpNm = cgoTpNm;
	}
	
	/**
	 * Column Info
	 * @param comScgSeq
	 */
	public void setComScgSeq(String comScgSeq) {
		this.comScgSeq = comScgSeq;
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
	 * @param rtTpCd
	 */
	public void setRtTpCd(String rtTpCd) {
		this.rtTpCd = rtTpCd;
	}
	
	/**
	 * Column Info
	 * @param agmtTrspTpDesc
	 */
	public void setAgmtTrspTpDesc(String agmtTrspTpDesc) {
		this.agmtTrspTpDesc = agmtTrspTpDesc;
	}
	
	/**
	 * Column Info
	 * @param eqSzDesc
	 */
	public void setEqSzDesc(String eqSzDesc) {
		this.eqSzDesc = eqSzDesc;
	}
	
	/**
	 * Column Info
	 * @param bndCd
	 */
	public void setBndCd(String bndCd) {
		this.bndCd = bndCd;
	}
	
	/**
	 * Column Info
	 * @param comScgKndCd
	 */
	public void setComScgKndCd(String comScgKndCd) {
		this.comScgKndCd = comScgKndCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param agmtTrspTpNm
	 */
	public void setAgmtTrspTpNm(String agmtTrspTpNm) {
		this.agmtTrspTpNm = agmtTrspTpNm;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param currDesc
	 */
	public void setCurrDesc(String currDesc) {
		this.currDesc = currDesc;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpDesc
	 */
	public void setEqTpDesc(String eqTpDesc) {
		this.eqTpDesc = eqTpDesc;
	}
	
	/**
	 * Column Info
	 * @param eqTpNm
	 */
	public void setEqTpNm(String eqTpNm) {
		this.eqTpNm = eqTpNm;
	}
	
	/**
	 * Column Info
	 * @param currNm
	 */
	public void setCurrNm(String currNm) {
		this.currNm = currNm;
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
	 * @param eqTpCd
	 */
	public void setEqTpCd(String eqTpCd) {
		this.eqTpCd = eqTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqSzNm
	 */
	public void setEqSzNm(String eqSzNm) {
		this.eqSzNm = eqSzNm;
	}
	
	/**
	 * Column Info
	 * @param eqSzCd
	 */
	public void setEqSzCd(String eqSzCd) {
		this.eqSzCd = eqSzCd;
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
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param rtTpNm
	 */
	public void setRtTpNm(String rtTpNm) {
		this.rtTpNm = rtTpNm;
	}
	
	/**
	 * Column Info
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
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
	 * @param dtCond
	 */
	public void setDtCond(String dtCond) {
		this.dtCond = dtCond;
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
		setTrspCostModDesc(JSPUtil.getParameter(request, prefix + "trsp_cost_mod_desc", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setWoAplyFlg(JSPUtil.getParameter(request, prefix + "wo_aply_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setOneWyRt(JSPUtil.getParameter(request, prefix + "one_wy_rt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqKndNm(JSPUtil.getParameter(request, prefix + "eq_knd_nm", ""));
		setTrspCostModNm(JSPUtil.getParameter(request, prefix + "trsp_cost_mod_nm", ""));
		setRndRt(JSPUtil.getParameter(request, prefix + "rnd_rt", ""));
		setComScgKndNm(JSPUtil.getParameter(request, prefix + "com_scg_knd_nm", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setBndNm(JSPUtil.getParameter(request, prefix + "bnd_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCgoTpNm(JSPUtil.getParameter(request, prefix + "cgo_tp_nm", ""));
		setComScgSeq(JSPUtil.getParameter(request, prefix + "com_scg_seq", ""));
		setTrspCostModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_mod_cd", ""));
		setRtTpCd(JSPUtil.getParameter(request, prefix + "rt_tp_cd", ""));
		setAgmtTrspTpDesc(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_desc", ""));
		setEqSzDesc(JSPUtil.getParameter(request, prefix + "eq_sz_desc", ""));
		setBndCd(JSPUtil.getParameter(request, prefix + "bnd_cd", ""));
		setComScgKndCd(JSPUtil.getParameter(request, prefix + "com_scg_knd_cd", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setAgmtTrspTpNm(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_nm", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setCurrDesc(JSPUtil.getParameter(request, prefix + "curr_desc", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setEqTpDesc(JSPUtil.getParameter(request, prefix + "eq_tp_desc", ""));
		setEqTpNm(JSPUtil.getParameter(request, prefix + "eq_tp_nm", ""));
		setCurrNm(JSPUtil.getParameter(request, prefix + "curr_nm", ""));
		setAgmtTrspTpCd(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_cd", ""));
		setEqTpCd(JSPUtil.getParameter(request, prefix + "eq_tp_cd", ""));
		setEqSzNm(JSPUtil.getParameter(request, prefix + "eq_sz_nm", ""));
		setEqSzCd(JSPUtil.getParameter(request, prefix + "eq_sz_cd", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setRtTpNm(JSPUtil.getParameter(request, prefix + "rt_tp_nm", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setDtCond(JSPUtil.getParameter(request, prefix + "dt_cond", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsComScgMgmtTpSzVO[]
	 */
	public TrsComScgMgmtTpSzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsComScgMgmtTpSzVO[]
	 */
	public TrsComScgMgmtTpSzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsComScgMgmtTpSzVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trspCostModDesc = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_mod_desc", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] woAplyFlg = (JSPUtil.getParameter(request, prefix	+ "wo_aply_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] oneWyRt = (JSPUtil.getParameter(request, prefix	+ "one_wy_rt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] trspCostModNm = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_mod_nm", length));
			String[] rndRt = (JSPUtil.getParameter(request, prefix	+ "rnd_rt", length));
			String[] comScgKndNm = (JSPUtil.getParameter(request, prefix	+ "com_scg_knd_nm", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] bndNm = (JSPUtil.getParameter(request, prefix	+ "bnd_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cgoTpNm = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_nm", length));
			String[] comScgSeq = (JSPUtil.getParameter(request, prefix	+ "com_scg_seq", length));
			String[] trspCostModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_mod_cd", length));
			String[] rtTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_tp_cd", length));
			String[] agmtTrspTpDesc = (JSPUtil.getParameter(request, prefix	+ "agmt_trsp_tp_desc", length));
			String[] eqSzDesc = (JSPUtil.getParameter(request, prefix	+ "eq_sz_desc", length));
			String[] bndCd = (JSPUtil.getParameter(request, prefix	+ "bnd_cd", length));
			String[] comScgKndCd = (JSPUtil.getParameter(request, prefix	+ "com_scg_knd_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] agmtTrspTpNm = (JSPUtil.getParameter(request, prefix	+ "agmt_trsp_tp_nm", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] currDesc = (JSPUtil.getParameter(request, prefix	+ "curr_desc", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] eqTpDesc = (JSPUtil.getParameter(request, prefix	+ "eq_tp_desc", length));
			String[] eqTpNm = (JSPUtil.getParameter(request, prefix	+ "eq_tp_nm", length));
			String[] currNm = (JSPUtil.getParameter(request, prefix	+ "curr_nm", length));
			String[] agmtTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_trsp_tp_cd", length));
			String[] eqTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_tp_cd", length));
			String[] eqSzNm = (JSPUtil.getParameter(request, prefix	+ "eq_sz_nm", length));
			String[] eqSzCd = (JSPUtil.getParameter(request, prefix	+ "eq_sz_cd", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] rtTpNm = (JSPUtil.getParameter(request, prefix	+ "rt_tp_nm", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] dtCond = (JSPUtil.getParameter(request, prefix	+ "dt_cond", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsComScgMgmtTpSzVO();
				if (trspCostModDesc[i] != null)
					model.setTrspCostModDesc(trspCostModDesc[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (woAplyFlg[i] != null)
					model.setWoAplyFlg(woAplyFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (oneWyRt[i] != null)
					model.setOneWyRt(oneWyRt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (trspCostModNm[i] != null)
					model.setTrspCostModNm(trspCostModNm[i]);
				if (rndRt[i] != null)
					model.setRndRt(rndRt[i]);
				if (comScgKndNm[i] != null)
					model.setComScgKndNm(comScgKndNm[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (bndNm[i] != null)
					model.setBndNm(bndNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cgoTpNm[i] != null)
					model.setCgoTpNm(cgoTpNm[i]);
				if (comScgSeq[i] != null)
					model.setComScgSeq(comScgSeq[i]);
				if (trspCostModCd[i] != null)
					model.setTrspCostModCd(trspCostModCd[i]);
				if (rtTpCd[i] != null)
					model.setRtTpCd(rtTpCd[i]);
				if (agmtTrspTpDesc[i] != null)
					model.setAgmtTrspTpDesc(agmtTrspTpDesc[i]);
				if (eqSzDesc[i] != null)
					model.setEqSzDesc(eqSzDesc[i]);
				if (bndCd[i] != null)
					model.setBndCd(bndCd[i]);
				if (comScgKndCd[i] != null)
					model.setComScgKndCd(comScgKndCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (agmtTrspTpNm[i] != null)
					model.setAgmtTrspTpNm(agmtTrspTpNm[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (currDesc[i] != null)
					model.setCurrDesc(currDesc[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (eqTpDesc[i] != null)
					model.setEqTpDesc(eqTpDesc[i]);
				if (eqTpNm[i] != null)
					model.setEqTpNm(eqTpNm[i]);
				if (currNm[i] != null)
					model.setCurrNm(currNm[i]);
				if (agmtTrspTpCd[i] != null)
					model.setAgmtTrspTpCd(agmtTrspTpCd[i]);
				if (eqTpCd[i] != null)
					model.setEqTpCd(eqTpCd[i]);
				if (eqSzNm[i] != null)
					model.setEqSzNm(eqSzNm[i]);
				if (eqSzCd[i] != null)
					model.setEqSzCd(eqSzCd[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (rtTpNm[i] != null)
					model.setRtTpNm(rtTpNm[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (dtCond[i] != null)
					model.setDtCond(dtCond[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsComScgMgmtTpSzVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsComScgMgmtTpSzVO[]
	 */
	public TrsComScgMgmtTpSzVO[] getTrsComScgMgmtTpSzVOs(){
		TrsComScgMgmtTpSzVO[] vos = (TrsComScgMgmtTpSzVO[])models.toArray(new TrsComScgMgmtTpSzVO[models.size()]);
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
		this.trspCostModDesc = this.trspCostModDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAplyFlg = this.woAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oneWyRt = this.oneWyRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostModNm = this.trspCostModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rndRt = this.rndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comScgKndNm = this.comScgKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndNm = this.bndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpNm = this.cgoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comScgSeq = this.comScgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostModCd = this.trspCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTpCd = this.rtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTrspTpDesc = this.agmtTrspTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSzDesc = this.eqSzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndCd = this.bndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comScgKndCd = this.comScgKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTrspTpNm = this.agmtTrspTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currDesc = this.currDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpDesc = this.eqTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpNm = this.eqTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currNm = this.currNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTrspTpCd = this.agmtTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpCd = this.eqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSzNm = this.eqSzNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSzCd = this.eqSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTpNm = this.rtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtCond = this.dtCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
