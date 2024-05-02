/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AGNCommSimulationVO.java
*@FileTitle : AGNCommSimulationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2013.01.16 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AGNCommSimulationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGNCommSimulationVO> models = new ArrayList<AGNCommSimulationVO>();
	
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String creTm = null;
	/* Column Info */
	private String acStsCd = null;
	/* Column Info */
	private String crntRevAmt = null;
	/* Column Info */
	private String ddctTrspAmt = null;
	/* Column Info */
	private String commVvd = null;
	/* Column Info */
	private String ddctChgAmt = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ppdAmt = null;
	/* Column Info */
	private String tsAmt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String postRevAmt = null;
	/* Column Info */
	private String acOccrInfoCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String acRlaneCd = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String revDivCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chfAmt = null;
	/* Column Info */
	private String xchRtAplyLvl = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crossAmt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String simRmk = null;
	/* Column Info */
	private String ddctSpclCmpnAmt = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String payIfAmt = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String payXchRt = null;
	/* Column Info */
	private String brogAmt = null;
	/* Column Info */
	private String generalAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String acSeq = null;
	/* Column Info */
	private String acProcDesc = null;
	/* Column Info */
	private String vvdDiv = null;
	/* Column Info */
	private String revVvdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AGNCommSimulationVO() {}

	public AGNCommSimulationVO(String ibflag, String pagerows, String agnCd, String dateDiv, String dateFm, String dateTo, String vvdDiv, String vvdCd, String bkgNo, String blNo, String ioBndCd, String revVvdCd, String commVvd, String bkgStsCd, String acRlaneCd, String sailArrDt, String acOccrInfoCd, String acSeq, String cntrQty, String revDivCd, String crntRevAmt, String ddctChgAmt, String ddctTrspAmt, String ddctSpclCmpnAmt, String postRevAmt, String ppdAmt, String generalAmt, String brogAmt, String chfAmt, String tsAmt, String crossAmt, String usdAmt, String payXchRt, String currCd, String payIfAmt, String acStsCd, String creDt, String creTm, String bdrFlg, String acProcDesc, String usrId, String simNo, String simRmk, String trdCd, String subTrdCd, String polCd, String porCd, String podCd, String delCd, String xchRtAplyLvl) {
		this.trdCd = trdCd;
		this.simNo = simNo;
		this.sailArrDt = sailArrDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.creTm = creTm;
		this.acStsCd = acStsCd;
		this.crntRevAmt = crntRevAmt;
		this.ddctTrspAmt = ddctTrspAmt;
		this.commVvd = commVvd;
		this.ddctChgAmt = ddctChgAmt;
		this.dateTo = dateTo;
		this.delCd = delCd;
		this.ppdAmt = ppdAmt;
		this.tsAmt = tsAmt;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.postRevAmt = postRevAmt;
		this.acOccrInfoCd = acOccrInfoCd;
		this.subTrdCd = subTrdCd;
		this.acRlaneCd = acRlaneCd;
		this.dateFm = dateFm;
		this.porCd = porCd;
		this.revDivCd = revDivCd;
		this.currCd = currCd;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.creDt = creDt;
		this.chfAmt = chfAmt;
		this.xchRtAplyLvl = xchRtAplyLvl;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.crossAmt = crossAmt;
		this.usrId = usrId;
		this.simRmk = simRmk;
		this.ddctSpclCmpnAmt = ddctSpclCmpnAmt;
		this.dateDiv = dateDiv;
		this.payIfAmt = payIfAmt;
		this.cntrQty = cntrQty;
		this.payXchRt = payXchRt;
		this.brogAmt = brogAmt;
		this.generalAmt = generalAmt;
		this.ioBndCd = ioBndCd;
		this.usdAmt = usdAmt;
		this.acSeq = acSeq;
		this.acProcDesc = acProcDesc;
		this.vvdDiv = vvdDiv;
		this.revVvdCd = revVvdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cre_tm", getCreTm());
		this.hashColumns.put("ac_sts_cd", getAcStsCd());
		this.hashColumns.put("crnt_rev_amt", getCrntRevAmt());
		this.hashColumns.put("ddct_trsp_amt", getDdctTrspAmt());
		this.hashColumns.put("comm_vvd", getCommVvd());
		this.hashColumns.put("ddct_chg_amt", getDdctChgAmt());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ppd_amt", getPpdAmt());
		this.hashColumns.put("ts_amt", getTsAmt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("post_rev_amt", getPostRevAmt());
		this.hashColumns.put("ac_occr_info_cd", getAcOccrInfoCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("ac_rlane_cd", getAcRlaneCd());
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rev_div_cd", getRevDivCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chf_amt", getChfAmt());
		this.hashColumns.put("xch_rt_aply_lvl", getXchRtAplyLvl());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cross_amt", getCrossAmt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sim_rmk", getSimRmk());
		this.hashColumns.put("ddct_spcl_cmpn_amt", getDdctSpclCmpnAmt());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("pay_if_amt", getPayIfAmt());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("pay_xch_rt", getPayXchRt());
		this.hashColumns.put("brog_amt", getBrogAmt());
		this.hashColumns.put("general_amt", getGeneralAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("ac_seq", getAcSeq());
		this.hashColumns.put("ac_proc_desc", getAcProcDesc());
		this.hashColumns.put("vvd_div", getVvdDiv());
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cre_tm", "creTm");
		this.hashFields.put("ac_sts_cd", "acStsCd");
		this.hashFields.put("crnt_rev_amt", "crntRevAmt");
		this.hashFields.put("ddct_trsp_amt", "ddctTrspAmt");
		this.hashFields.put("comm_vvd", "commVvd");
		this.hashFields.put("ddct_chg_amt", "ddctChgAmt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ppd_amt", "ppdAmt");
		this.hashFields.put("ts_amt", "tsAmt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("post_rev_amt", "postRevAmt");
		this.hashFields.put("ac_occr_info_cd", "acOccrInfoCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("ac_rlane_cd", "acRlaneCd");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rev_div_cd", "revDivCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chf_amt", "chfAmt");
		this.hashFields.put("xch_rt_aply_lvl", "xchRtAplyLvl");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cross_amt", "crossAmt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sim_rmk", "simRmk");
		this.hashFields.put("ddct_spcl_cmpn_amt", "ddctSpclCmpnAmt");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("pay_if_amt", "payIfAmt");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("brog_amt", "brogAmt");
		this.hashFields.put("general_amt", "generalAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("ac_proc_desc", "acProcDesc");
		this.hashFields.put("vvd_div", "vvdDiv");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		return this.hashFields;
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
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return creTm
	 */
	public String getCreTm() {
		return this.creTm;
	}
	
	/**
	 * Column Info
	 * @return acStsCd
	 */
	public String getAcStsCd() {
		return this.acStsCd;
	}
	
	/**
	 * Column Info
	 * @return crntRevAmt
	 */
	public String getCrntRevAmt() {
		return this.crntRevAmt;
	}
	
	/**
	 * Column Info
	 * @return ddctTrspAmt
	 */
	public String getDdctTrspAmt() {
		return this.ddctTrspAmt;
	}
	
	/**
	 * Column Info
	 * @return commVvd
	 */
	public String getCommVvd() {
		return this.commVvd;
	}
	
	/**
	 * Column Info
	 * @return ddctChgAmt
	 */
	public String getDdctChgAmt() {
		return this.ddctChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
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
	 * @return ppdAmt
	 */
	public String getPpdAmt() {
		return this.ppdAmt;
	}
	
	/**
	 * Column Info
	 * @return tsAmt
	 */
	public String getTsAmt() {
		return this.tsAmt;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return postRevAmt
	 */
	public String getPostRevAmt() {
		return this.postRevAmt;
	}
	
	/**
	 * Column Info
	 * @return acOccrInfoCd
	 */
	public String getAcOccrInfoCd() {
		return this.acOccrInfoCd;
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
	 * @return acRlaneCd
	 */
	public String getAcRlaneCd() {
		return this.acRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
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
	 * @return revDivCd
	 */
	public String getRevDivCd() {
		return this.revDivCd;
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
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
	 * @return chfAmt
	 */
	public String getChfAmt() {
		return this.chfAmt;
	}
	
	/**
	 * Column Info
	 * @return xchRtAplyLvl
	 */
	public String getXchRtAplyLvl() {
		return this.xchRtAplyLvl;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return crossAmt
	 */
	public String getCrossAmt() {
		return this.crossAmt;
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
	 * @return simRmk
	 */
	public String getSimRmk() {
		return this.simRmk;
	}
	
	/**
	 * Column Info
	 * @return ddctSpclCmpnAmt
	 */
	public String getDdctSpclCmpnAmt() {
		return this.ddctSpclCmpnAmt;
	}
	
	/**
	 * Column Info
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
	}
	
	/**
	 * Column Info
	 * @return payIfAmt
	 */
	public String getPayIfAmt() {
		return this.payIfAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return payXchRt
	 */
	public String getPayXchRt() {
		return this.payXchRt;
	}
	
	/**
	 * Column Info
	 * @return brogAmt
	 */
	public String getBrogAmt() {
		return this.brogAmt;
	}
	
	/**
	 * Column Info
	 * @return generalAmt
	 */
	public String getGeneralAmt() {
		return this.generalAmt;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return acSeq
	 */
	public String getAcSeq() {
		return this.acSeq;
	}
	
	/**
	 * Column Info
	 * @return acProcDesc
	 */
	public String getAcProcDesc() {
		return this.acProcDesc;
	}
	
	/**
	 * Column Info
	 * @return vvdDiv
	 */
	public String getVvdDiv() {
		return this.vvdDiv;
	}
	
	/**
	 * Column Info
	 * @return revVvdCd
	 */
	public String getRevVvdCd() {
		return this.revVvdCd;
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
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param creTm
	 */
	public void setCreTm(String creTm) {
		this.creTm = creTm;
	}
	
	/**
	 * Column Info
	 * @param acStsCd
	 */
	public void setAcStsCd(String acStsCd) {
		this.acStsCd = acStsCd;
	}
	
	/**
	 * Column Info
	 * @param crntRevAmt
	 */
	public void setCrntRevAmt(String crntRevAmt) {
		this.crntRevAmt = crntRevAmt;
	}
	
	/**
	 * Column Info
	 * @param ddctTrspAmt
	 */
	public void setDdctTrspAmt(String ddctTrspAmt) {
		this.ddctTrspAmt = ddctTrspAmt;
	}
	
	/**
	 * Column Info
	 * @param commVvd
	 */
	public void setCommVvd(String commVvd) {
		this.commVvd = commVvd;
	}
	
	/**
	 * Column Info
	 * @param ddctChgAmt
	 */
	public void setDdctChgAmt(String ddctChgAmt) {
		this.ddctChgAmt = ddctChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
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
	 * @param ppdAmt
	 */
	public void setPpdAmt(String ppdAmt) {
		this.ppdAmt = ppdAmt;
	}
	
	/**
	 * Column Info
	 * @param tsAmt
	 */
	public void setTsAmt(String tsAmt) {
		this.tsAmt = tsAmt;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param postRevAmt
	 */
	public void setPostRevAmt(String postRevAmt) {
		this.postRevAmt = postRevAmt;
	}
	
	/**
	 * Column Info
	 * @param acOccrInfoCd
	 */
	public void setAcOccrInfoCd(String acOccrInfoCd) {
		this.acOccrInfoCd = acOccrInfoCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param acRlaneCd
	 */
	public void setAcRlaneCd(String acRlaneCd) {
		this.acRlaneCd = acRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
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
	 * @param revDivCd
	 */
	public void setRevDivCd(String revDivCd) {
		this.revDivCd = revDivCd;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
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
	 * @param chfAmt
	 */
	public void setChfAmt(String chfAmt) {
		this.chfAmt = chfAmt;
	}
	
	/**
	 * Column Info
	 * @param xchRtAplyLvl
	 */
	public void setXchRtAplyLvl(String xchRtAplyLvl) {
		this.xchRtAplyLvl = xchRtAplyLvl;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param crossAmt
	 */
	public void setCrossAmt(String crossAmt) {
		this.crossAmt = crossAmt;
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
	 * @param simRmk
	 */
	public void setSimRmk(String simRmk) {
		this.simRmk = simRmk;
	}
	
	/**
	 * Column Info
	 * @param ddctSpclCmpnAmt
	 */
	public void setDdctSpclCmpnAmt(String ddctSpclCmpnAmt) {
		this.ddctSpclCmpnAmt = ddctSpclCmpnAmt;
	}
	
	/**
	 * Column Info
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
	}
	
	/**
	 * Column Info
	 * @param payIfAmt
	 */
	public void setPayIfAmt(String payIfAmt) {
		this.payIfAmt = payIfAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param payXchRt
	 */
	public void setPayXchRt(String payXchRt) {
		this.payXchRt = payXchRt;
	}
	
	/**
	 * Column Info
	 * @param brogAmt
	 */
	public void setBrogAmt(String brogAmt) {
		this.brogAmt = brogAmt;
	}
	
	/**
	 * Column Info
	 * @param generalAmt
	 */
	public void setGeneralAmt(String generalAmt) {
		this.generalAmt = generalAmt;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param acSeq
	 */
	public void setAcSeq(String acSeq) {
		this.acSeq = acSeq;
	}
	
	/**
	 * Column Info
	 * @param acProcDesc
	 */
	public void setAcProcDesc(String acProcDesc) {
		this.acProcDesc = acProcDesc;
	}
	
	/**
	 * Column Info
	 * @param vvdDiv
	 */
	public void setVvdDiv(String vvdDiv) {
		this.vvdDiv = vvdDiv;
	}
	
	/**
	 * Column Info
	 * @param revVvdCd
	 */
	public void setRevVvdCd(String revVvdCd) {
		this.revVvdCd = revVvdCd;
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
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCreTm(JSPUtil.getParameter(request, prefix + "cre_tm", ""));
		setAcStsCd(JSPUtil.getParameter(request, prefix + "ac_sts_cd", ""));
		setCrntRevAmt(JSPUtil.getParameter(request, prefix + "crnt_rev_amt", ""));
		setDdctTrspAmt(JSPUtil.getParameter(request, prefix + "ddct_trsp_amt", ""));
		setCommVvd(JSPUtil.getParameter(request, prefix + "comm_vvd", ""));
		setDdctChgAmt(JSPUtil.getParameter(request, prefix + "ddct_chg_amt", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPpdAmt(JSPUtil.getParameter(request, prefix + "ppd_amt", ""));
		setTsAmt(JSPUtil.getParameter(request, prefix + "ts_amt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPostRevAmt(JSPUtil.getParameter(request, prefix + "post_rev_amt", ""));
		setAcOccrInfoCd(JSPUtil.getParameter(request, prefix + "ac_occr_info_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setAcRlaneCd(JSPUtil.getParameter(request, prefix + "ac_rlane_cd", ""));
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRevDivCd(JSPUtil.getParameter(request, prefix + "rev_div_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChfAmt(JSPUtil.getParameter(request, prefix + "chf_amt", ""));
		setXchRtAplyLvl(JSPUtil.getParameter(request, prefix + "xch_rt_aply_lvl", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrossAmt(JSPUtil.getParameter(request, prefix + "cross_amt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSimRmk(JSPUtil.getParameter(request, prefix + "sim_rmk", ""));
		setDdctSpclCmpnAmt(JSPUtil.getParameter(request, prefix + "ddct_spcl_cmpn_amt", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setPayIfAmt(JSPUtil.getParameter(request, prefix + "pay_if_amt", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setPayXchRt(JSPUtil.getParameter(request, prefix + "pay_xch_rt", ""));
		setBrogAmt(JSPUtil.getParameter(request, prefix + "brog_amt", ""));
		setGeneralAmt(JSPUtil.getParameter(request, prefix + "general_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setAcSeq(JSPUtil.getParameter(request, prefix + "ac_seq", ""));
		setAcProcDesc(JSPUtil.getParameter(request, prefix + "ac_proc_desc", ""));
		setVvdDiv(JSPUtil.getParameter(request, prefix + "vvd_div", ""));
		setRevVvdCd(JSPUtil.getParameter(request, prefix + "rev_vvd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommSimulationVO[]
	 */
	public AGNCommSimulationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGNCommSimulationVO[]
	 */
	public AGNCommSimulationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommSimulationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] creTm = (JSPUtil.getParameter(request, prefix	+ "cre_tm", length));
			String[] acStsCd = (JSPUtil.getParameter(request, prefix	+ "ac_sts_cd", length));
			String[] crntRevAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_rev_amt", length));
			String[] ddctTrspAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_trsp_amt", length));
			String[] commVvd = (JSPUtil.getParameter(request, prefix	+ "comm_vvd", length));
			String[] ddctChgAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_chg_amt", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ppdAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_amt", length));
			String[] tsAmt = (JSPUtil.getParameter(request, prefix	+ "ts_amt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] postRevAmt = (JSPUtil.getParameter(request, prefix	+ "post_rev_amt", length));
			String[] acOccrInfoCd = (JSPUtil.getParameter(request, prefix	+ "ac_occr_info_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] acRlaneCd = (JSPUtil.getParameter(request, prefix	+ "ac_rlane_cd", length));
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] revDivCd = (JSPUtil.getParameter(request, prefix	+ "rev_div_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chfAmt = (JSPUtil.getParameter(request, prefix	+ "chf_amt", length));
			String[] xchRtAplyLvl = (JSPUtil.getParameter(request, prefix	+ "xch_rt_aply_lvl", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crossAmt = (JSPUtil.getParameter(request, prefix	+ "cross_amt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] simRmk = (JSPUtil.getParameter(request, prefix	+ "sim_rmk", length));
			String[] ddctSpclCmpnAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_spcl_cmpn_amt", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] payIfAmt = (JSPUtil.getParameter(request, prefix	+ "pay_if_amt", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] payXchRt = (JSPUtil.getParameter(request, prefix	+ "pay_xch_rt", length));
			String[] brogAmt = (JSPUtil.getParameter(request, prefix	+ "brog_amt", length));
			String[] generalAmt = (JSPUtil.getParameter(request, prefix	+ "general_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] acSeq = (JSPUtil.getParameter(request, prefix	+ "ac_seq", length));
			String[] acProcDesc = (JSPUtil.getParameter(request, prefix	+ "ac_proc_desc", length));
			String[] vvdDiv = (JSPUtil.getParameter(request, prefix	+ "vvd_div", length));
			String[] revVvdCd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGNCommSimulationVO();
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (creTm[i] != null)
					model.setCreTm(creTm[i]);
				if (acStsCd[i] != null)
					model.setAcStsCd(acStsCd[i]);
				if (crntRevAmt[i] != null)
					model.setCrntRevAmt(crntRevAmt[i]);
				if (ddctTrspAmt[i] != null)
					model.setDdctTrspAmt(ddctTrspAmt[i]);
				if (commVvd[i] != null)
					model.setCommVvd(commVvd[i]);
				if (ddctChgAmt[i] != null)
					model.setDdctChgAmt(ddctChgAmt[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ppdAmt[i] != null)
					model.setPpdAmt(ppdAmt[i]);
				if (tsAmt[i] != null)
					model.setTsAmt(tsAmt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (postRevAmt[i] != null)
					model.setPostRevAmt(postRevAmt[i]);
				if (acOccrInfoCd[i] != null)
					model.setAcOccrInfoCd(acOccrInfoCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (acRlaneCd[i] != null)
					model.setAcRlaneCd(acRlaneCd[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (revDivCd[i] != null)
					model.setRevDivCd(revDivCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chfAmt[i] != null)
					model.setChfAmt(chfAmt[i]);
				if (xchRtAplyLvl[i] != null)
					model.setXchRtAplyLvl(xchRtAplyLvl[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crossAmt[i] != null)
					model.setCrossAmt(crossAmt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (simRmk[i] != null)
					model.setSimRmk(simRmk[i]);
				if (ddctSpclCmpnAmt[i] != null)
					model.setDdctSpclCmpnAmt(ddctSpclCmpnAmt[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (payIfAmt[i] != null)
					model.setPayIfAmt(payIfAmt[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (payXchRt[i] != null)
					model.setPayXchRt(payXchRt[i]);
				if (brogAmt[i] != null)
					model.setBrogAmt(brogAmt[i]);
				if (generalAmt[i] != null)
					model.setGeneralAmt(generalAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (acSeq[i] != null)
					model.setAcSeq(acSeq[i]);
				if (acProcDesc[i] != null)
					model.setAcProcDesc(acProcDesc[i]);
				if (vvdDiv[i] != null)
					model.setVvdDiv(vvdDiv[i]);
				if (revVvdCd[i] != null)
					model.setRevVvdCd(revVvdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommSimulationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommSimulationVO[]
	 */
	public AGNCommSimulationVO[] getAGNCommSimulationVOs(){
		AGNCommSimulationVO[] vos = (AGNCommSimulationVO[])models.toArray(new AGNCommSimulationVO[models.size()]);
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
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTm = this.creTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acStsCd = this.acStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntRevAmt = this.crntRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctTrspAmt = this.ddctTrspAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commVvd = this.commVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctChgAmt = this.ddctChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdAmt = this.ppdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsAmt = this.tsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postRevAmt = this.postRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acOccrInfoCd = this.acOccrInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acRlaneCd = this.acRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDivCd = this.revDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chfAmt = this.chfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtAplyLvl = this.xchRtAplyLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crossAmt = this.crossAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRmk = this.simRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctSpclCmpnAmt = this.ddctSpclCmpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payIfAmt = this.payIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt = this.payXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogAmt = this.brogAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.generalAmt = this.generalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq = this.acSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acProcDesc = this.acProcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDiv = this.vvdDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd = this.revVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
