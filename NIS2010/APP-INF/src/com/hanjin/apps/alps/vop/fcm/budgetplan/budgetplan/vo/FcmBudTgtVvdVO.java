/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmBudTgtVvdVO.java
*@FileTitle : FcmBudTgtVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.29
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.29 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmBudTgtVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmBudTgtVvdVO> models = new ArrayList<FcmBudTgtVvdVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String trndLineTpCd = null;
	/* Column Info */
	private String mnvrDys = null;
	/* Column Info */
	private String doilSeaCsmWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String endPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String foilPortCsmWgt = null;
	/* Column Info */
	private String foilMnvrCsmWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String budYrmon = null;
	/* Column Info */
	private String doilMnvrCsmWgt = null;
	/* Column Info */
	private String ttlCsmAmt = null;
	/* Column Info */
	private String budWk = null;
	/* Column Info */
	private String foilCsmCostAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String portDys = null;
	/* Column Info */
	private String budScnrNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String doilPortCsmWgt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Column Info */
	private String seaDys = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String foilUcAmt = null;
	/* Column Info */
	private String doilUcAmt = null;
	/* Column Info */
	private String foilSeaCsmWgt = null;
	/* Column Info */
	private String budTgtVvdSeq = null;
	/* Column Info */
	private String doilCsmCostAmt = null;
	/* Column Info */
	private String stPortCd = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmBudTgtVvdVO() {}

	public FcmBudTgtVvdVO(String ibflag, String pagerows, String updDt, String trndLineTpCd, String vslCd, String creDt, String budScnrNo, String pfSkdTpCd, String trdCd, String skdVoyNo, String rlaneCd, String endPortCd, String crrCd, String skdDirCd, String cntrVslClssCapa, String creUsrId, String budTgtVvdSeq, String budYrmon, String budWk, String stPortCd, String updUsrId, String subTrdCd, String portDys, String seaDys, String mnvrDys, String foilPortCsmWgt, String foilSeaCsmWgt, String foilMnvrCsmWgt, String foilUcAmt, String foilCsmCostAmt, String doilPortCsmWgt, String doilSeaCsmWgt, String doilMnvrCsmWgt, String doilUcAmt, String doilCsmCostAmt, String ttlCsmAmt) {
		this.vslCd = vslCd;
		this.trndLineTpCd = trndLineTpCd;
		this.mnvrDys = mnvrDys;
		this.doilSeaCsmWgt = doilSeaCsmWgt;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.pfSkdTpCd = pfSkdTpCd;
		this.rlaneCd = rlaneCd;
		this.crrCd = crrCd;
		this.endPortCd = endPortCd;
		this.pagerows = pagerows;
		this.foilPortCsmWgt = foilPortCsmWgt;
		this.foilMnvrCsmWgt = foilMnvrCsmWgt;
		this.ibflag = ibflag;
		this.budYrmon = budYrmon;
		this.doilMnvrCsmWgt = doilMnvrCsmWgt;
		this.ttlCsmAmt = ttlCsmAmt;
		this.budWk = budWk;
		this.foilCsmCostAmt = foilCsmCostAmt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.portDys = portDys;
		this.budScnrNo = budScnrNo;
		this.skdVoyNo = skdVoyNo;
		this.doilPortCsmWgt = doilPortCsmWgt;
		this.skdDirCd = skdDirCd;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.seaDys = seaDys;
		this.creUsrId = creUsrId;
		this.foilUcAmt = foilUcAmt;
		this.doilUcAmt = doilUcAmt;
		this.foilSeaCsmWgt = foilSeaCsmWgt;
		this.budTgtVvdSeq = budTgtVvdSeq;
		this.doilCsmCostAmt = doilCsmCostAmt;
		this.stPortCd = stPortCd;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trnd_line_tp_cd", getTrndLineTpCd());
		this.hashColumns.put("mnvr_dys", getMnvrDys());
		this.hashColumns.put("doil_sea_csm_wgt", getDoilSeaCsmWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("end_port_cd", getEndPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("foil_port_csm_wgt", getFoilPortCsmWgt());
		this.hashColumns.put("foil_mnvr_csm_wgt", getFoilMnvrCsmWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bud_yrmon", getBudYrmon());
		this.hashColumns.put("doil_mnvr_csm_wgt", getDoilMnvrCsmWgt());
		this.hashColumns.put("ttl_csm_amt", getTtlCsmAmt());
		this.hashColumns.put("bud_wk", getBudWk());
		this.hashColumns.put("foil_csm_cost_amt", getFoilCsmCostAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("port_dys", getPortDys());
		this.hashColumns.put("bud_scnr_no", getBudScnrNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("doil_port_csm_wgt", getDoilPortCsmWgt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("sea_dys", getSeaDys());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("foil_uc_amt", getFoilUcAmt());
		this.hashColumns.put("doil_uc_amt", getDoilUcAmt());
		this.hashColumns.put("foil_sea_csm_wgt", getFoilSeaCsmWgt());
		this.hashColumns.put("bud_tgt_vvd_seq", getBudTgtVvdSeq());
		this.hashColumns.put("doil_csm_cost_amt", getDoilCsmCostAmt());
		this.hashColumns.put("st_port_cd", getStPortCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trnd_line_tp_cd", "trndLineTpCd");
		this.hashFields.put("mnvr_dys", "mnvrDys");
		this.hashFields.put("doil_sea_csm_wgt", "doilSeaCsmWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("end_port_cd", "endPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("foil_port_csm_wgt", "foilPortCsmWgt");
		this.hashFields.put("foil_mnvr_csm_wgt", "foilMnvrCsmWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bud_yrmon", "budYrmon");
		this.hashFields.put("doil_mnvr_csm_wgt", "doilMnvrCsmWgt");
		this.hashFields.put("ttl_csm_amt", "ttlCsmAmt");
		this.hashFields.put("bud_wk", "budWk");
		this.hashFields.put("foil_csm_cost_amt", "foilCsmCostAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("port_dys", "portDys");
		this.hashFields.put("bud_scnr_no", "budScnrNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("doil_port_csm_wgt", "doilPortCsmWgt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("sea_dys", "seaDys");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("foil_uc_amt", "foilUcAmt");
		this.hashFields.put("doil_uc_amt", "doilUcAmt");
		this.hashFields.put("foil_sea_csm_wgt", "foilSeaCsmWgt");
		this.hashFields.put("bud_tgt_vvd_seq", "budTgtVvdSeq");
		this.hashFields.put("doil_csm_cost_amt", "doilCsmCostAmt");
		this.hashFields.put("st_port_cd", "stPortCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return trndLineTpCd
	 */
	public String getTrndLineTpCd() {
		return this.trndLineTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnvrDys
	 */
	public String getMnvrDys() {
		return this.mnvrDys;
	}
	
	/**
	 * Column Info
	 * @return doilSeaCsmWgt
	 */
	public String getDoilSeaCsmWgt() {
		return this.doilSeaCsmWgt;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return pfSkdTpCd
	 */
	public String getPfSkdTpCd() {
		return this.pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return endPortCd
	 */
	public String getEndPortCd() {
		return this.endPortCd;
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
	 * @return foilPortCsmWgt
	 */
	public String getFoilPortCsmWgt() {
		return this.foilPortCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return foilMnvrCsmWgt
	 */
	public String getFoilMnvrCsmWgt() {
		return this.foilMnvrCsmWgt;
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
	 * @return budYrmon
	 */
	public String getBudYrmon() {
		return this.budYrmon;
	}
	
	/**
	 * Column Info
	 * @return doilMnvrCsmWgt
	 */
	public String getDoilMnvrCsmWgt() {
		return this.doilMnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return ttlCsmAmt
	 */
	public String getTtlCsmAmt() {
		return this.ttlCsmAmt;
	}
	
	/**
	 * Column Info
	 * @return budWk
	 */
	public String getBudWk() {
		return this.budWk;
	}
	
	/**
	 * Column Info
	 * @return foilCsmCostAmt
	 */
	public String getFoilCsmCostAmt() {
		return this.foilCsmCostAmt;
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
	 * @return portDys
	 */
	public String getPortDys() {
		return this.portDys;
	}
	
	/**
	 * Column Info
	 * @return budScnrNo
	 */
	public String getBudScnrNo() {
		return this.budScnrNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return doilPortCsmWgt
	 */
	public String getDoilPortCsmWgt() {
		return this.doilPortCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return seaDys
	 */
	public String getSeaDys() {
		return this.seaDys;
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
	 * @return foilUcAmt
	 */
	public String getFoilUcAmt() {
		return this.foilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return doilUcAmt
	 */
	public String getDoilUcAmt() {
		return this.doilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return foilSeaCsmWgt
	 */
	public String getFoilSeaCsmWgt() {
		return this.foilSeaCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return budTgtVvdSeq
	 */
	public String getBudTgtVvdSeq() {
		return this.budTgtVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return doilCsmCostAmt
	 */
	public String getDoilCsmCostAmt() {
		return this.doilCsmCostAmt;
	}
	
	/**
	 * Column Info
	 * @return stPortCd
	 */
	public String getStPortCd() {
		return this.stPortCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param trndLineTpCd
	 */
	public void setTrndLineTpCd(String trndLineTpCd) {
		this.trndLineTpCd = trndLineTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnvrDys
	 */
	public void setMnvrDys(String mnvrDys) {
		this.mnvrDys = mnvrDys;
	}
	
	/**
	 * Column Info
	 * @param doilSeaCsmWgt
	 */
	public void setDoilSeaCsmWgt(String doilSeaCsmWgt) {
		this.doilSeaCsmWgt = doilSeaCsmWgt;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param pfSkdTpCd
	 */
	public void setPfSkdTpCd(String pfSkdTpCd) {
		this.pfSkdTpCd = pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param endPortCd
	 */
	public void setEndPortCd(String endPortCd) {
		this.endPortCd = endPortCd;
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
	 * @param foilPortCsmWgt
	 */
	public void setFoilPortCsmWgt(String foilPortCsmWgt) {
		this.foilPortCsmWgt = foilPortCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param foilMnvrCsmWgt
	 */
	public void setFoilMnvrCsmWgt(String foilMnvrCsmWgt) {
		this.foilMnvrCsmWgt = foilMnvrCsmWgt;
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
	 * @param budYrmon
	 */
	public void setBudYrmon(String budYrmon) {
		this.budYrmon = budYrmon;
	}
	
	/**
	 * Column Info
	 * @param doilMnvrCsmWgt
	 */
	public void setDoilMnvrCsmWgt(String doilMnvrCsmWgt) {
		this.doilMnvrCsmWgt = doilMnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param ttlCsmAmt
	 */
	public void setTtlCsmAmt(String ttlCsmAmt) {
		this.ttlCsmAmt = ttlCsmAmt;
	}
	
	/**
	 * Column Info
	 * @param budWk
	 */
	public void setBudWk(String budWk) {
		this.budWk = budWk;
	}
	
	/**
	 * Column Info
	 * @param foilCsmCostAmt
	 */
	public void setFoilCsmCostAmt(String foilCsmCostAmt) {
		this.foilCsmCostAmt = foilCsmCostAmt;
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
	 * @param portDys
	 */
	public void setPortDys(String portDys) {
		this.portDys = portDys;
	}
	
	/**
	 * Column Info
	 * @param budScnrNo
	 */
	public void setBudScnrNo(String budScnrNo) {
		this.budScnrNo = budScnrNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param doilPortCsmWgt
	 */
	public void setDoilPortCsmWgt(String doilPortCsmWgt) {
		this.doilPortCsmWgt = doilPortCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param seaDys
	 */
	public void setSeaDys(String seaDys) {
		this.seaDys = seaDys;
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
	 * @param foilUcAmt
	 */
	public void setFoilUcAmt(String foilUcAmt) {
		this.foilUcAmt = foilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param doilUcAmt
	 */
	public void setDoilUcAmt(String doilUcAmt) {
		this.doilUcAmt = doilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param foilSeaCsmWgt
	 */
	public void setFoilSeaCsmWgt(String foilSeaCsmWgt) {
		this.foilSeaCsmWgt = foilSeaCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param budTgtVvdSeq
	 */
	public void setBudTgtVvdSeq(String budTgtVvdSeq) {
		this.budTgtVvdSeq = budTgtVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param doilCsmCostAmt
	 */
	public void setDoilCsmCostAmt(String doilCsmCostAmt) {
		this.doilCsmCostAmt = doilCsmCostAmt;
	}
	
	/**
	 * Column Info
	 * @param stPortCd
	 */
	public void setStPortCd(String stPortCd) {
		this.stPortCd = stPortCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTrndLineTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_tp_cd", ""));
		setMnvrDys(JSPUtil.getParameter(request, prefix + "mnvr_dys", ""));
		setDoilSeaCsmWgt(JSPUtil.getParameter(request, prefix + "doil_sea_csm_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setEndPortCd(JSPUtil.getParameter(request, prefix + "end_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFoilPortCsmWgt(JSPUtil.getParameter(request, prefix + "foil_port_csm_wgt", ""));
		setFoilMnvrCsmWgt(JSPUtil.getParameter(request, prefix + "foil_mnvr_csm_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBudYrmon(JSPUtil.getParameter(request, prefix + "bud_yrmon", ""));
		setDoilMnvrCsmWgt(JSPUtil.getParameter(request, prefix + "doil_mnvr_csm_wgt", ""));
		setTtlCsmAmt(JSPUtil.getParameter(request, prefix + "ttl_csm_amt", ""));
		setBudWk(JSPUtil.getParameter(request, prefix + "bud_wk", ""));
		setFoilCsmCostAmt(JSPUtil.getParameter(request, prefix + "foil_csm_cost_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPortDys(JSPUtil.getParameter(request, prefix + "port_dys", ""));
		setBudScnrNo(JSPUtil.getParameter(request, prefix + "bud_scnr_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setDoilPortCsmWgt(JSPUtil.getParameter(request, prefix + "doil_port_csm_wgt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
		setSeaDys(JSPUtil.getParameter(request, prefix + "sea_dys", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFoilUcAmt(JSPUtil.getParameter(request, prefix + "foil_uc_amt", ""));
		setDoilUcAmt(JSPUtil.getParameter(request, prefix + "doil_uc_amt", ""));
		setFoilSeaCsmWgt(JSPUtil.getParameter(request, prefix + "foil_sea_csm_wgt", ""));
		setBudTgtVvdSeq(JSPUtil.getParameter(request, prefix + "bud_tgt_vvd_seq", ""));
		setDoilCsmCostAmt(JSPUtil.getParameter(request, prefix + "doil_csm_cost_amt", ""));
		setStPortCd(JSPUtil.getParameter(request, prefix + "st_port_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmBudTgtVvdVO[]
	 */
	public FcmBudTgtVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmBudTgtVvdVO[]
	 */
	public FcmBudTgtVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmBudTgtVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] trndLineTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_tp_cd", length));
			String[] mnvrDys = (JSPUtil.getParameter(request, prefix	+ "mnvr_dys", length));
			String[] doilSeaCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_sea_csm_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] endPortCd = (JSPUtil.getParameter(request, prefix	+ "end_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] foilPortCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_port_csm_wgt", length));
			String[] foilMnvrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_mnvr_csm_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] budYrmon = (JSPUtil.getParameter(request, prefix	+ "bud_yrmon", length));
			String[] doilMnvrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_mnvr_csm_wgt", length));
			String[] ttlCsmAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_csm_amt", length));
			String[] budWk = (JSPUtil.getParameter(request, prefix	+ "bud_wk", length));
			String[] foilCsmCostAmt = (JSPUtil.getParameter(request, prefix	+ "foil_csm_cost_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] portDys = (JSPUtil.getParameter(request, prefix	+ "port_dys", length));
			String[] budScnrNo = (JSPUtil.getParameter(request, prefix	+ "bud_scnr_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] doilPortCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_port_csm_wgt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa", length));
			String[] seaDys = (JSPUtil.getParameter(request, prefix	+ "sea_dys", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] foilUcAmt = (JSPUtil.getParameter(request, prefix	+ "foil_uc_amt", length));
			String[] doilUcAmt = (JSPUtil.getParameter(request, prefix	+ "doil_uc_amt", length));
			String[] foilSeaCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_sea_csm_wgt", length));
			String[] budTgtVvdSeq = (JSPUtil.getParameter(request, prefix	+ "bud_tgt_vvd_seq", length));
			String[] doilCsmCostAmt = (JSPUtil.getParameter(request, prefix	+ "doil_csm_cost_amt", length));
			String[] stPortCd = (JSPUtil.getParameter(request, prefix	+ "st_port_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmBudTgtVvdVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (trndLineTpCd[i] != null)
					model.setTrndLineTpCd(trndLineTpCd[i]);
				if (mnvrDys[i] != null)
					model.setMnvrDys(mnvrDys[i]);
				if (doilSeaCsmWgt[i] != null)
					model.setDoilSeaCsmWgt(doilSeaCsmWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (endPortCd[i] != null)
					model.setEndPortCd(endPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (foilPortCsmWgt[i] != null)
					model.setFoilPortCsmWgt(foilPortCsmWgt[i]);
				if (foilMnvrCsmWgt[i] != null)
					model.setFoilMnvrCsmWgt(foilMnvrCsmWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (budYrmon[i] != null)
					model.setBudYrmon(budYrmon[i]);
				if (doilMnvrCsmWgt[i] != null)
					model.setDoilMnvrCsmWgt(doilMnvrCsmWgt[i]);
				if (ttlCsmAmt[i] != null)
					model.setTtlCsmAmt(ttlCsmAmt[i]);
				if (budWk[i] != null)
					model.setBudWk(budWk[i]);
				if (foilCsmCostAmt[i] != null)
					model.setFoilCsmCostAmt(foilCsmCostAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (portDys[i] != null)
					model.setPortDys(portDys[i]);
				if (budScnrNo[i] != null)
					model.setBudScnrNo(budScnrNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (doilPortCsmWgt[i] != null)
					model.setDoilPortCsmWgt(doilPortCsmWgt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (seaDys[i] != null)
					model.setSeaDys(seaDys[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (foilUcAmt[i] != null)
					model.setFoilUcAmt(foilUcAmt[i]);
				if (doilUcAmt[i] != null)
					model.setDoilUcAmt(doilUcAmt[i]);
				if (foilSeaCsmWgt[i] != null)
					model.setFoilSeaCsmWgt(foilSeaCsmWgt[i]);
				if (budTgtVvdSeq[i] != null)
					model.setBudTgtVvdSeq(budTgtVvdSeq[i]);
				if (doilCsmCostAmt[i] != null)
					model.setDoilCsmCostAmt(doilCsmCostAmt[i]);
				if (stPortCd[i] != null)
					model.setStPortCd(stPortCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmBudTgtVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmBudTgtVvdVO[]
	 */
	public FcmBudTgtVvdVO[] getFcmBudTgtVvdVOs(){
		FcmBudTgtVvdVO[] vos = (FcmBudTgtVvdVO[])models.toArray(new FcmBudTgtVvdVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineTpCd = this.trndLineTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrDys = this.mnvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilSeaCsmWgt = this.doilSeaCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endPortCd = this.endPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilPortCsmWgt = this.foilPortCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilMnvrCsmWgt = this.foilMnvrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budYrmon = this.budYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilMnvrCsmWgt = this.doilMnvrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCsmAmt = this.ttlCsmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budWk = this.budWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCsmCostAmt = this.foilCsmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDys = this.portDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budScnrNo = this.budScnrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilPortCsmWgt = this.doilPortCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDys = this.seaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilUcAmt = this.foilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilUcAmt = this.doilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilSeaCsmWgt = this.foilSeaCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budTgtVvdSeq = this.budTgtVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCsmCostAmt = this.doilCsmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPortCd = this.stPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
