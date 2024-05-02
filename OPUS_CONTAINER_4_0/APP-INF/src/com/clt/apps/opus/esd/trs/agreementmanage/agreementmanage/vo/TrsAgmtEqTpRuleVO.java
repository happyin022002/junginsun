/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrsAgmtEqTpRuleVO.java
*@FileTitle : TrsAgmtEqTpRuleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.25 이준근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이준근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsAgmtEqTpRuleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsAgmtEqTpRuleVO> models = new ArrayList<TrsAgmtEqTpRuleVO>();
	
	/* Column Info */
	private String railSvcTpCd = null;
	/* Column Info */
	private String chssNoCondCd = null;
	/* Column Info */
	private String toLocCondCd = null;
	/* Column Info */
	private String fmLocCondCd = null;
	/* Column Info */
	private String trspAgmtTpCd = null;
	/* Column Info */
	private String trspAgmtRuleTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trspAgmtCgoTpCd = null;
	/* Column Info */
	private String trspAgmtStepKnt = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspAgmtEqSzCd = null;
	/* Column Info */
	private String toDistCondCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvCondCd = null;
	/* Column Info */
	private String deCondCd = null;
	/* Column Info */
	private String scgCondCd = null;
	/* Column Info */
	private String trspAgmtRuleSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ovwtStndCondCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trspAgmtEqTpCd = null;
	/* Column Info */
	private String fxPerDistCondCd = null;
	/* Column Info */
	private String trspAgmtCostModCd = null;
	/* Column Info */
	private String viaLocCondCd = null;
	/* Column Info */
	private String currCondCd = null;
	/* Column Info */
	private String rtCondCd = null;
	/* Column Info */
	private String trspAgmtEqKndCd = null;
	/* Column Info */
	private String rndTrpRtCondCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String distUtCondCd = null;
	/* Column Info */
	private String ovwtUtCondCd = null;
	/* Column Info */
	private String dorLocCondCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrsAgmtEqTpRuleVO() {}

	public TrsAgmtEqTpRuleVO(String ibflag, String pagerows, String trspAgmtRuleSeq, String trspAgmtRuleTpCd, String trspAgmtStepKnt, String trspAgmtCostModCd, String trspAgmtCgoTpCd, String trspAgmtEqKndCd, String trspAgmtEqTpCd, String trspAgmtEqSzCd, String trspAgmtTpCd, String trspModCd, String scgCondCd, String fmLocCondCd, String viaLocCondCd, String toLocCondCd, String dorLocCondCd, String rcvCondCd, String deCondCd, String railSvcTpCd, String rtCondCd, String currCondCd, String rndTrpRtCondCd, String chssNoCondCd, String toDistCondCd, String fxPerDistCondCd, String distUtCondCd, String ovwtUtCondCd, String ovwtStndCondCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.railSvcTpCd = railSvcTpCd;
		this.chssNoCondCd = chssNoCondCd;
		this.toLocCondCd = toLocCondCd;
		this.fmLocCondCd = fmLocCondCd;
		this.trspAgmtTpCd = trspAgmtTpCd;
		this.trspAgmtRuleTpCd = trspAgmtRuleTpCd;
		this.creDt = creDt;
		this.trspAgmtCgoTpCd = trspAgmtCgoTpCd;
		this.trspAgmtStepKnt = trspAgmtStepKnt;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.trspAgmtEqSzCd = trspAgmtEqSzCd;
		this.toDistCondCd = toDistCondCd;
		this.ibflag = ibflag;
		this.rcvCondCd = rcvCondCd;
		this.deCondCd = deCondCd;
		this.scgCondCd = scgCondCd;
		this.trspAgmtRuleSeq = trspAgmtRuleSeq;
		this.updUsrId = updUsrId;
		this.ovwtStndCondCd = ovwtStndCondCd;
		this.updDt = updDt;
		this.trspAgmtEqTpCd = trspAgmtEqTpCd;
		this.fxPerDistCondCd = fxPerDistCondCd;
		this.trspAgmtCostModCd = trspAgmtCostModCd;
		this.viaLocCondCd = viaLocCondCd;
		this.currCondCd = currCondCd;
		this.rtCondCd = rtCondCd;
		this.trspAgmtEqKndCd = trspAgmtEqKndCd;
		this.rndTrpRtCondCd = rndTrpRtCondCd;
		this.creUsrId = creUsrId;
		this.distUtCondCd = distUtCondCd;
		this.ovwtUtCondCd = ovwtUtCondCd;
		this.dorLocCondCd = dorLocCondCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rail_svc_tp_cd", getRailSvcTpCd());
		this.hashColumns.put("chss_no_cond_cd", getChssNoCondCd());
		this.hashColumns.put("to_loc_cond_cd", getToLocCondCd());
		this.hashColumns.put("fm_loc_cond_cd", getFmLocCondCd());
		this.hashColumns.put("trsp_agmt_tp_cd", getTrspAgmtTpCd());
		this.hashColumns.put("trsp_agmt_rule_tp_cd", getTrspAgmtRuleTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trsp_agmt_cgo_tp_cd", getTrspAgmtCgoTpCd());
		this.hashColumns.put("trsp_agmt_step_knt", getTrspAgmtStepKnt());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_agmt_eq_sz_cd", getTrspAgmtEqSzCd());
		this.hashColumns.put("to_dist_cond_cd", getToDistCondCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_cond_cd", getRcvCondCd());
		this.hashColumns.put("de_cond_cd", getDeCondCd());
		this.hashColumns.put("scg_cond_cd", getScgCondCd());
		this.hashColumns.put("trsp_agmt_rule_seq", getTrspAgmtRuleSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ovwt_stnd_cond_cd", getOvwtStndCondCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trsp_agmt_eq_tp_cd", getTrspAgmtEqTpCd());
		this.hashColumns.put("fx_per_dist_cond_cd", getFxPerDistCondCd());
		this.hashColumns.put("trsp_agmt_cost_mod_cd", getTrspAgmtCostModCd());
		this.hashColumns.put("via_loc_cond_cd", getViaLocCondCd());
		this.hashColumns.put("curr_cond_cd", getCurrCondCd());
		this.hashColumns.put("rt_cond_cd", getRtCondCd());
		this.hashColumns.put("trsp_agmt_eq_knd_cd", getTrspAgmtEqKndCd());
		this.hashColumns.put("rnd_trp_rt_cond_cd", getRndTrpRtCondCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dist_ut_cond_cd", getDistUtCondCd());
		this.hashColumns.put("ovwt_ut_cond_cd", getOvwtUtCondCd());
		this.hashColumns.put("dor_loc_cond_cd", getDorLocCondCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rail_svc_tp_cd", "railSvcTpCd");
		this.hashFields.put("chss_no_cond_cd", "chssNoCondCd");
		this.hashFields.put("to_loc_cond_cd", "toLocCondCd");
		this.hashFields.put("fm_loc_cond_cd", "fmLocCondCd");
		this.hashFields.put("trsp_agmt_tp_cd", "trspAgmtTpCd");
		this.hashFields.put("trsp_agmt_rule_tp_cd", "trspAgmtRuleTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trsp_agmt_cgo_tp_cd", "trspAgmtCgoTpCd");
		this.hashFields.put("trsp_agmt_step_knt", "trspAgmtStepKnt");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_agmt_eq_sz_cd", "trspAgmtEqSzCd");
		this.hashFields.put("to_dist_cond_cd", "toDistCondCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_cond_cd", "rcvCondCd");
		this.hashFields.put("de_cond_cd", "deCondCd");
		this.hashFields.put("scg_cond_cd", "scgCondCd");
		this.hashFields.put("trsp_agmt_rule_seq", "trspAgmtRuleSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ovwt_stnd_cond_cd", "ovwtStndCondCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trsp_agmt_eq_tp_cd", "trspAgmtEqTpCd");
		this.hashFields.put("fx_per_dist_cond_cd", "fxPerDistCondCd");
		this.hashFields.put("trsp_agmt_cost_mod_cd", "trspAgmtCostModCd");
		this.hashFields.put("via_loc_cond_cd", "viaLocCondCd");
		this.hashFields.put("curr_cond_cd", "currCondCd");
		this.hashFields.put("rt_cond_cd", "rtCondCd");
		this.hashFields.put("trsp_agmt_eq_knd_cd", "trspAgmtEqKndCd");
		this.hashFields.put("rnd_trp_rt_cond_cd", "rndTrpRtCondCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dist_ut_cond_cd", "distUtCondCd");
		this.hashFields.put("ovwt_ut_cond_cd", "ovwtUtCondCd");
		this.hashFields.put("dor_loc_cond_cd", "dorLocCondCd");
		return this.hashFields;
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
	 * @return chssNoCondCd
	 */
	public String getChssNoCondCd() {
		return this.chssNoCondCd;
	}
	
	/**
	 * Column Info
	 * @return toLocCondCd
	 */
	public String getToLocCondCd() {
		return this.toLocCondCd;
	}
	
	/**
	 * Column Info
	 * @return fmLocCondCd
	 */
	public String getFmLocCondCd() {
		return this.fmLocCondCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtTpCd
	 */
	public String getTrspAgmtTpCd() {
		return this.trspAgmtTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRuleTpCd
	 */
	public String getTrspAgmtRuleTpCd() {
		return this.trspAgmtRuleTpCd;
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
	 * @return trspAgmtCgoTpCd
	 */
	public String getTrspAgmtCgoTpCd() {
		return this.trspAgmtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtStepKnt
	 */
	public String getTrspAgmtStepKnt() {
		return this.trspAgmtStepKnt;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return trspAgmtEqSzCd
	 */
	public String getTrspAgmtEqSzCd() {
		return this.trspAgmtEqSzCd;
	}
	
	/**
	 * Column Info
	 * @return toDistCondCd
	 */
	public String getToDistCondCd() {
		return this.toDistCondCd;
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
	 * @return rcvCondCd
	 */
	public String getRcvCondCd() {
		return this.rcvCondCd;
	}
	
	/**
	 * Column Info
	 * @return deCondCd
	 */
	public String getDeCondCd() {
		return this.deCondCd;
	}
	
	/**
	 * Column Info
	 * @return scgCondCd
	 */
	public String getScgCondCd() {
		return this.scgCondCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRuleSeq
	 */
	public String getTrspAgmtRuleSeq() {
		return this.trspAgmtRuleSeq;
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
	 * @return ovwtStndCondCd
	 */
	public String getOvwtStndCondCd() {
		return this.ovwtStndCondCd;
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
	 * @return trspAgmtEqTpCd
	 */
	public String getTrspAgmtEqTpCd() {
		return this.trspAgmtEqTpCd;
	}
	
	/**
	 * Column Info
	 * @return fxPerDistCondCd
	 */
	public String getFxPerDistCondCd() {
		return this.fxPerDistCondCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtCostModCd
	 */
	public String getTrspAgmtCostModCd() {
		return this.trspAgmtCostModCd;
	}
	
	/**
	 * Column Info
	 * @return viaLocCondCd
	 */
	public String getViaLocCondCd() {
		return this.viaLocCondCd;
	}
	
	/**
	 * Column Info
	 * @return currCondCd
	 */
	public String getCurrCondCd() {
		return this.currCondCd;
	}
	
	/**
	 * Column Info
	 * @return rtCondCd
	 */
	public String getRtCondCd() {
		return this.rtCondCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtEqKndCd
	 */
	public String getTrspAgmtEqKndCd() {
		return this.trspAgmtEqKndCd;
	}
	
	/**
	 * Column Info
	 * @return rndTrpRtCondCd
	 */
	public String getRndTrpRtCondCd() {
		return this.rndTrpRtCondCd;
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
	 * @return distUtCondCd
	 */
	public String getDistUtCondCd() {
		return this.distUtCondCd;
	}
	
	/**
	 * Column Info
	 * @return ovwtUtCondCd
	 */
	public String getOvwtUtCondCd() {
		return this.ovwtUtCondCd;
	}
	
	/**
	 * Column Info
	 * @return dorLocCondCd
	 */
	public String getDorLocCondCd() {
		return this.dorLocCondCd;
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
	 * @param chssNoCondCd
	 */
	public void setChssNoCondCd(String chssNoCondCd) {
		this.chssNoCondCd = chssNoCondCd;
	}
	
	/**
	 * Column Info
	 * @param toLocCondCd
	 */
	public void setToLocCondCd(String toLocCondCd) {
		this.toLocCondCd = toLocCondCd;
	}
	
	/**
	 * Column Info
	 * @param fmLocCondCd
	 */
	public void setFmLocCondCd(String fmLocCondCd) {
		this.fmLocCondCd = fmLocCondCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtTpCd
	 */
	public void setTrspAgmtTpCd(String trspAgmtTpCd) {
		this.trspAgmtTpCd = trspAgmtTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRuleTpCd
	 */
	public void setTrspAgmtRuleTpCd(String trspAgmtRuleTpCd) {
		this.trspAgmtRuleTpCd = trspAgmtRuleTpCd;
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
	 * @param trspAgmtCgoTpCd
	 */
	public void setTrspAgmtCgoTpCd(String trspAgmtCgoTpCd) {
		this.trspAgmtCgoTpCd = trspAgmtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtStepKnt
	 */
	public void setTrspAgmtStepKnt(String trspAgmtStepKnt) {
		this.trspAgmtStepKnt = trspAgmtStepKnt;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param trspAgmtEqSzCd
	 */
	public void setTrspAgmtEqSzCd(String trspAgmtEqSzCd) {
		this.trspAgmtEqSzCd = trspAgmtEqSzCd;
	}
	
	/**
	 * Column Info
	 * @param toDistCondCd
	 */
	public void setToDistCondCd(String toDistCondCd) {
		this.toDistCondCd = toDistCondCd;
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
	 * @param rcvCondCd
	 */
	public void setRcvCondCd(String rcvCondCd) {
		this.rcvCondCd = rcvCondCd;
	}
	
	/**
	 * Column Info
	 * @param deCondCd
	 */
	public void setDeCondCd(String deCondCd) {
		this.deCondCd = deCondCd;
	}
	
	/**
	 * Column Info
	 * @param scgCondCd
	 */
	public void setScgCondCd(String scgCondCd) {
		this.scgCondCd = scgCondCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRuleSeq
	 */
	public void setTrspAgmtRuleSeq(String trspAgmtRuleSeq) {
		this.trspAgmtRuleSeq = trspAgmtRuleSeq;
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
	 * @param ovwtStndCondCd
	 */
	public void setOvwtStndCondCd(String ovwtStndCondCd) {
		this.ovwtStndCondCd = ovwtStndCondCd;
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
	 * @param trspAgmtEqTpCd
	 */
	public void setTrspAgmtEqTpCd(String trspAgmtEqTpCd) {
		this.trspAgmtEqTpCd = trspAgmtEqTpCd;
	}
	
	/**
	 * Column Info
	 * @param fxPerDistCondCd
	 */
	public void setFxPerDistCondCd(String fxPerDistCondCd) {
		this.fxPerDistCondCd = fxPerDistCondCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtCostModCd
	 */
	public void setTrspAgmtCostModCd(String trspAgmtCostModCd) {
		this.trspAgmtCostModCd = trspAgmtCostModCd;
	}
	
	/**
	 * Column Info
	 * @param viaLocCondCd
	 */
	public void setViaLocCondCd(String viaLocCondCd) {
		this.viaLocCondCd = viaLocCondCd;
	}
	
	/**
	 * Column Info
	 * @param currCondCd
	 */
	public void setCurrCondCd(String currCondCd) {
		this.currCondCd = currCondCd;
	}
	
	/**
	 * Column Info
	 * @param rtCondCd
	 */
	public void setRtCondCd(String rtCondCd) {
		this.rtCondCd = rtCondCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtEqKndCd
	 */
	public void setTrspAgmtEqKndCd(String trspAgmtEqKndCd) {
		this.trspAgmtEqKndCd = trspAgmtEqKndCd;
	}
	
	/**
	 * Column Info
	 * @param rndTrpRtCondCd
	 */
	public void setRndTrpRtCondCd(String rndTrpRtCondCd) {
		this.rndTrpRtCondCd = rndTrpRtCondCd;
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
	 * @param distUtCondCd
	 */
	public void setDistUtCondCd(String distUtCondCd) {
		this.distUtCondCd = distUtCondCd;
	}
	
	/**
	 * Column Info
	 * @param ovwtUtCondCd
	 */
	public void setOvwtUtCondCd(String ovwtUtCondCd) {
		this.ovwtUtCondCd = ovwtUtCondCd;
	}
	
	/**
	 * Column Info
	 * @param dorLocCondCd
	 */
	public void setDorLocCondCd(String dorLocCondCd) {
		this.dorLocCondCd = dorLocCondCd;
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
		setRailSvcTpCd(JSPUtil.getParameter(request, prefix + "rail_svc_tp_cd", ""));
		setChssNoCondCd(JSPUtil.getParameter(request, prefix + "chss_no_cond_cd", ""));
		setToLocCondCd(JSPUtil.getParameter(request, prefix + "to_loc_cond_cd", ""));
		setFmLocCondCd(JSPUtil.getParameter(request, prefix + "fm_loc_cond_cd", ""));
		setTrspAgmtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_tp_cd", ""));
		setTrspAgmtRuleTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rule_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrspAgmtCgoTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_cgo_tp_cd", ""));
		setTrspAgmtStepKnt(JSPUtil.getParameter(request, prefix + "trsp_agmt_step_knt", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrspAgmtEqSzCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_sz_cd", ""));
		setToDistCondCd(JSPUtil.getParameter(request, prefix + "to_dist_cond_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRcvCondCd(JSPUtil.getParameter(request, prefix + "rcv_cond_cd", ""));
		setDeCondCd(JSPUtil.getParameter(request, prefix + "de_cond_cd", ""));
		setScgCondCd(JSPUtil.getParameter(request, prefix + "scg_cond_cd", ""));
		setTrspAgmtRuleSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_rule_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOvwtStndCondCd(JSPUtil.getParameter(request, prefix + "ovwt_stnd_cond_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTrspAgmtEqTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_tp_cd", ""));
		setFxPerDistCondCd(JSPUtil.getParameter(request, prefix + "fx_per_dist_cond_cd", ""));
		setTrspAgmtCostModCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_cost_mod_cd", ""));
		setViaLocCondCd(JSPUtil.getParameter(request, prefix + "via_loc_cond_cd", ""));
		setCurrCondCd(JSPUtil.getParameter(request, prefix + "curr_cond_cd", ""));
		setRtCondCd(JSPUtil.getParameter(request, prefix + "rt_cond_cd", ""));
		setTrspAgmtEqKndCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_knd_cd", ""));
		setRndTrpRtCondCd(JSPUtil.getParameter(request, prefix + "rnd_trp_rt_cond_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDistUtCondCd(JSPUtil.getParameter(request, prefix + "dist_ut_cond_cd", ""));
		setOvwtUtCondCd(JSPUtil.getParameter(request, prefix + "ovwt_ut_cond_cd", ""));
		setDorLocCondCd(JSPUtil.getParameter(request, prefix + "dor_loc_cond_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsAgmtEqTpRuleVO[]
	 */
	public TrsAgmtEqTpRuleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsAgmtEqTpRuleVO[]
	 */
	public TrsAgmtEqTpRuleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsAgmtEqTpRuleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] railSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_svc_tp_cd", length));
			String[] chssNoCondCd = (JSPUtil.getParameter(request, prefix	+ "chss_no_cond_cd", length));
			String[] toLocCondCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cond_cd", length));
			String[] fmLocCondCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cond_cd", length));
			String[] trspAgmtTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_tp_cd", length));
			String[] trspAgmtRuleTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rule_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trspAgmtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_cgo_tp_cd", length));
			String[] trspAgmtStepKnt = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_step_knt", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspAgmtEqSzCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_eq_sz_cd", length));
			String[] toDistCondCd = (JSPUtil.getParameter(request, prefix	+ "to_dist_cond_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvCondCd = (JSPUtil.getParameter(request, prefix	+ "rcv_cond_cd", length));
			String[] deCondCd = (JSPUtil.getParameter(request, prefix	+ "de_cond_cd", length));
			String[] scgCondCd = (JSPUtil.getParameter(request, prefix	+ "scg_cond_cd", length));
			String[] trspAgmtRuleSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rule_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ovwtStndCondCd = (JSPUtil.getParameter(request, prefix	+ "ovwt_stnd_cond_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trspAgmtEqTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_eq_tp_cd", length));
			String[] fxPerDistCondCd = (JSPUtil.getParameter(request, prefix	+ "fx_per_dist_cond_cd", length));
			String[] trspAgmtCostModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_cost_mod_cd", length));
			String[] viaLocCondCd = (JSPUtil.getParameter(request, prefix	+ "via_loc_cond_cd", length));
			String[] currCondCd = (JSPUtil.getParameter(request, prefix	+ "curr_cond_cd", length));
			String[] rtCondCd = (JSPUtil.getParameter(request, prefix	+ "rt_cond_cd", length));
			String[] trspAgmtEqKndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_eq_knd_cd", length));
			String[] rndTrpRtCondCd = (JSPUtil.getParameter(request, prefix	+ "rnd_trp_rt_cond_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] distUtCondCd = (JSPUtil.getParameter(request, prefix	+ "dist_ut_cond_cd", length));
			String[] ovwtUtCondCd = (JSPUtil.getParameter(request, prefix	+ "ovwt_ut_cond_cd", length));
			String[] dorLocCondCd = (JSPUtil.getParameter(request, prefix	+ "dor_loc_cond_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsAgmtEqTpRuleVO();
				if (railSvcTpCd[i] != null)
					model.setRailSvcTpCd(railSvcTpCd[i]);
				if (chssNoCondCd[i] != null)
					model.setChssNoCondCd(chssNoCondCd[i]);
				if (toLocCondCd[i] != null)
					model.setToLocCondCd(toLocCondCd[i]);
				if (fmLocCondCd[i] != null)
					model.setFmLocCondCd(fmLocCondCd[i]);
				if (trspAgmtTpCd[i] != null)
					model.setTrspAgmtTpCd(trspAgmtTpCd[i]);
				if (trspAgmtRuleTpCd[i] != null)
					model.setTrspAgmtRuleTpCd(trspAgmtRuleTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trspAgmtCgoTpCd[i] != null)
					model.setTrspAgmtCgoTpCd(trspAgmtCgoTpCd[i]);
				if (trspAgmtStepKnt[i] != null)
					model.setTrspAgmtStepKnt(trspAgmtStepKnt[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspAgmtEqSzCd[i] != null)
					model.setTrspAgmtEqSzCd(trspAgmtEqSzCd[i]);
				if (toDistCondCd[i] != null)
					model.setToDistCondCd(toDistCondCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvCondCd[i] != null)
					model.setRcvCondCd(rcvCondCd[i]);
				if (deCondCd[i] != null)
					model.setDeCondCd(deCondCd[i]);
				if (scgCondCd[i] != null)
					model.setScgCondCd(scgCondCd[i]);
				if (trspAgmtRuleSeq[i] != null)
					model.setTrspAgmtRuleSeq(trspAgmtRuleSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ovwtStndCondCd[i] != null)
					model.setOvwtStndCondCd(ovwtStndCondCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trspAgmtEqTpCd[i] != null)
					model.setTrspAgmtEqTpCd(trspAgmtEqTpCd[i]);
				if (fxPerDistCondCd[i] != null)
					model.setFxPerDistCondCd(fxPerDistCondCd[i]);
				if (trspAgmtCostModCd[i] != null)
					model.setTrspAgmtCostModCd(trspAgmtCostModCd[i]);
				if (viaLocCondCd[i] != null)
					model.setViaLocCondCd(viaLocCondCd[i]);
				if (currCondCd[i] != null)
					model.setCurrCondCd(currCondCd[i]);
				if (rtCondCd[i] != null)
					model.setRtCondCd(rtCondCd[i]);
				if (trspAgmtEqKndCd[i] != null)
					model.setTrspAgmtEqKndCd(trspAgmtEqKndCd[i]);
				if (rndTrpRtCondCd[i] != null)
					model.setRndTrpRtCondCd(rndTrpRtCondCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (distUtCondCd[i] != null)
					model.setDistUtCondCd(distUtCondCd[i]);
				if (ovwtUtCondCd[i] != null)
					model.setOvwtUtCondCd(ovwtUtCondCd[i]);
				if (dorLocCondCd[i] != null)
					model.setDorLocCondCd(dorLocCondCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsAgmtEqTpRuleVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsAgmtEqTpRuleVO[]
	 */
	public TrsAgmtEqTpRuleVO[] getTrsAgmtEqTpRuleVOs(){
		TrsAgmtEqTpRuleVO[] vos = (TrsAgmtEqTpRuleVO[])models.toArray(new TrsAgmtEqTpRuleVO[models.size()]);
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
		this.railSvcTpCd = this.railSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNoCondCd = this.chssNoCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCondCd = this.toLocCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCondCd = this.fmLocCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtTpCd = this.trspAgmtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRuleTpCd = this.trspAgmtRuleTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtCgoTpCd = this.trspAgmtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtStepKnt = this.trspAgmtStepKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqSzCd = this.trspAgmtEqSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDistCondCd = this.toDistCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvCondCd = this.rcvCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deCondCd = this.deCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCondCd = this.scgCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRuleSeq = this.trspAgmtRuleSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwtStndCondCd = this.ovwtStndCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqTpCd = this.trspAgmtEqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxPerDistCondCd = this.fxPerDistCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtCostModCd = this.trspAgmtCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaLocCondCd = this.viaLocCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCondCd = this.currCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCondCd = this.rtCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqKndCd = this.trspAgmtEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rndTrpRtCondCd = this.rndTrpRtCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distUtCondCd = this.distUtCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwtUtCondCd = this.ovwtUtCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocCondCd = this.dorLocCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
