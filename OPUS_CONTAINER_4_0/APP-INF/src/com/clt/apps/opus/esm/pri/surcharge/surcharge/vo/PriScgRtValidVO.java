/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriScgRtValidVO.java
 *@FileTitle : PriScgRtValidVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.26
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.03.26 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.surcharge.surcharge.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class PriScgRtValidVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriScgRtValidVO>  models =	new	ArrayList<PriScgRtValidVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String seq = null;
	/*	Column Info	*/
	private String porDefCd = null;
	/*	Column Info	*/
	private String polDefCd = null;
	/*	Column Info	*/
	private String podDefCd = null;
	/*	Column Info	*/
	private String delDefCd = null;
	/*	Column Info	*/
	private String ratUtCd = null;
	/*	Column Info	*/
	private String prcCgoTpCd = null;
	/*	Column Info	*/
	private String scgImdgClssCd = null;
	/*	Column Info	*/
	private String currCd = null;
	/*	Column Info	*/
	private String scgAmt = null;
	/*	Column Info	*/
	private String payTermCd = null;
	/*	Column Info	*/
	private String cnlTzCd = null;
	/*	Column Info	*/
	private String minCgoWgt = null;
	/*	Column Info	*/
	private String maxCgoWgt = null;
	/*	Column Info	*/
	private String orgTrspModCd = null;
	/*	Column Info	*/
	private String destTrspModCd = null;
	/*	Column Info	*/
	private String prcRcvTermCd = null;
	/*	Column Info	*/
	private String prcDeTermCd = null;
	/*	Column Info	*/
	private String prcHngrBarTpCd = null;
	/*	Column Info	*/
	private String subTrdCd = null;
	/*	Column Info	*/
	private String dirCallFlg = null;
	/*	Column Info	*/
	private String tmlCd = null;
	/*	Column Info	*/
	private String cmdtCd = null;
	/*	Column Info	*/
	private String ioGaCd = null;
	/*	Column Info	*/
	private String tsPortCd = null;
	/*	Column Info	*/
	private String socFlg = null;
	/*	Column Info	*/
	private String scgGrpCmdtCd = null;
	/*	Column Info	*/
	private String usaSvcModCd = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String expDt = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String chgCd = null;
	/*	Column Info	*/
	private String scgSeq = null;
	/*	Column Info	*/
	private String porTpCd = null;
	/*	Column Info	*/
	private String polTpCd = null;
	/*	Column Info	*/
	private String podTpCd = null;
	/*	Column Info	*/
	private String delTpCd = null;
	/*	Column Info	*/
	private String porDefCdVld = null;
	/*	Column Info	*/
	private String polDefCdVld = null;
	/*	Column Info	*/
	private String podDefCdVld = null;
	/*	Column Info	*/
	private String delDefCdVld = null;
	/*	Column Info	*/
	private String tsPortCdVld = null;
	/*	Column Info	*/
	private String tmlCdVld = null;
	/*	Column Info	*/
	private String cmdtCdVld = null;
	/*	Column Info	*/
	private String porTpCdVld = null;
	/*	Column Info	*/
	private String polTpCdVld = null;
	/*	Column Info	*/
	private String podTpCdVld = null;
	/*	Column Info	*/
	private String delTpCdVld = null;
	/*	Column Info	*/
	private String dupIdx = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriScgRtValidVO(){}

	public PriScgRtValidVO(String ibflag,String pagerows,String seq,String porDefCd,String polDefCd,String podDefCd,String delDefCd,String ratUtCd,String prcCgoTpCd,String scgImdgClssCd,String currCd,String scgAmt,String payTermCd,String cnlTzCd,String minCgoWgt,String maxCgoWgt,String orgTrspModCd,String destTrspModCd,String prcRcvTermCd,String prcDeTermCd,String prcHngrBarTpCd,String subTrdCd,String dirCallFlg,String tmlCd,String cmdtCd,String ioGaCd,String tsPortCd,String socFlg,String scgGrpCmdtCd,String usaSvcModCd,String effDt,String expDt,String svcScpCd,String chgCd,String scgSeq,String porTpCd,String polTpCd,String podTpCd,String delTpCd,String porDefCdVld,String polDefCdVld,String podDefCdVld,String delDefCdVld,String tsPortCdVld,String tmlCdVld,String cmdtCdVld,String porTpCdVld,String polTpCdVld,String podTpCdVld,String delTpCdVld,String dupIdx)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.seq = seq;
		this.porDefCd = porDefCd;
		this.polDefCd = polDefCd;
		this.podDefCd = podDefCd;
		this.delDefCd = delDefCd;
		this.ratUtCd = ratUtCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.scgImdgClssCd = scgImdgClssCd;
		this.currCd = currCd;
		this.scgAmt = scgAmt;
		this.payTermCd = payTermCd;
		this.cnlTzCd = cnlTzCd;
		this.minCgoWgt = minCgoWgt;
		this.maxCgoWgt = maxCgoWgt;
		this.orgTrspModCd = orgTrspModCd;
		this.destTrspModCd = destTrspModCd;
		this.prcRcvTermCd = prcRcvTermCd;
		this.prcDeTermCd = prcDeTermCd;
		this.prcHngrBarTpCd = prcHngrBarTpCd;
		this.subTrdCd = subTrdCd;
		this.dirCallFlg = dirCallFlg;
		this.tmlCd = tmlCd;
		this.cmdtCd = cmdtCd;
		this.ioGaCd = ioGaCd;
		this.tsPortCd = tsPortCd;
		this.socFlg = socFlg;
		this.scgGrpCmdtCd = scgGrpCmdtCd;
		this.usaSvcModCd = usaSvcModCd;
		this.effDt = effDt;
		this.expDt = expDt;
		this.svcScpCd = svcScpCd;
		this.chgCd = chgCd;
		this.scgSeq = scgSeq;
		this.porTpCd = porTpCd;
		this.polTpCd = polTpCd;
		this.podTpCd = podTpCd;
		this.delTpCd = delTpCd;
		this.porDefCdVld = porDefCdVld;
		this.polDefCdVld = polDefCdVld;
		this.podDefCdVld = podDefCdVld;
		this.delDefCdVld = delDefCdVld;
		this.tsPortCdVld = tsPortCdVld;
		this.tmlCdVld = tmlCdVld;
		this.cmdtCdVld = cmdtCdVld;
		this.porTpCdVld = porTpCdVld;
		this.polTpCdVld = polTpCdVld;
		this.podTpCdVld = podTpCdVld;
		this.delTpCdVld = delTpCdVld;
		this.dupIdx = dupIdx;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("por_def_cd", getPorDefCd());
		this.hashColumns.put("pol_def_cd", getPolDefCd());
		this.hashColumns.put("pod_def_cd", getPodDefCd());
		this.hashColumns.put("del_def_cd", getDelDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("scg_imdg_clss_cd", getScgImdgClssCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("scg_amt", getScgAmt());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("cnl_tz_cd", getCnlTzCd());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		this.hashColumns.put("org_trsp_mod_cd", getOrgTrspModCd());
		this.hashColumns.put("dest_trsp_mod_cd", getDestTrspModCd());
		this.hashColumns.put("prc_rcv_term_cd", getPrcRcvTermCd());
		this.hashColumns.put("prc_de_term_cd", getPrcDeTermCd());
		this.hashColumns.put("prc_hngr_bar_tp_cd", getPrcHngrBarTpCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("io_ga_cd", getIoGaCd());
		this.hashColumns.put("ts_port_cd", getTsPortCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("scg_grp_cmdt_cd", getScgGrpCmdtCd());
		this.hashColumns.put("usa_svc_mod_cd", getUsaSvcModCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("scg_seq", getScgSeq());
		this.hashColumns.put("por_tp_cd", getPorTpCd());
		this.hashColumns.put("pol_tp_cd", getPolTpCd());
		this.hashColumns.put("pod_tp_cd", getPodTpCd());
		this.hashColumns.put("del_tp_cd", getDelTpCd());
		this.hashColumns.put("por_def_cd_vld", getPorDefCdVld());
		this.hashColumns.put("pol_def_cd_vld", getPolDefCdVld());
		this.hashColumns.put("pod_def_cd_vld", getPodDefCdVld());
		this.hashColumns.put("del_def_cd_vld", getDelDefCdVld());
		this.hashColumns.put("ts_port_cd_vld", getTsPortCdVld());
		this.hashColumns.put("tml_cd_vld", getTmlCdVld());
		this.hashColumns.put("cmdt_cd_vld", getCmdtCdVld());
		this.hashColumns.put("por_tp_cd_vld", getPorTpCdVld());
		this.hashColumns.put("pol_tp_cd_vld", getPolTpCdVld());
		this.hashColumns.put("pod_tp_cd_vld", getPodTpCdVld());
		this.hashColumns.put("del_tp_cd_vld", getDelTpCdVld());
		this.hashColumns.put("dup_idx", getDupIdx());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("por_def_cd", "porDefCd");
		this.hashFields.put("pol_def_cd", "polDefCd");
		this.hashFields.put("pod_def_cd", "podDefCd");
		this.hashFields.put("del_def_cd", "delDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("scg_imdg_clss_cd", "scgImdgClssCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("scg_amt", "scgAmt");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("cnl_tz_cd", "cnlTzCd");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		this.hashFields.put("org_trsp_mod_cd", "orgTrspModCd");
		this.hashFields.put("dest_trsp_mod_cd", "destTrspModCd");
		this.hashFields.put("prc_rcv_term_cd", "prcRcvTermCd");
		this.hashFields.put("prc_de_term_cd", "prcDeTermCd");
		this.hashFields.put("prc_hngr_bar_tp_cd", "prcHngrBarTpCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("io_ga_cd", "ioGaCd");
		this.hashFields.put("ts_port_cd", "tsPortCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("scg_grp_cmdt_cd", "scgGrpCmdtCd");
		this.hashFields.put("usa_svc_mod_cd", "usaSvcModCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("scg_seq", "scgSeq");
		this.hashFields.put("por_tp_cd", "porTpCd");
		this.hashFields.put("pol_tp_cd", "polTpCd");
		this.hashFields.put("pod_tp_cd", "podTpCd");
		this.hashFields.put("del_tp_cd", "delTpCd");
		this.hashFields.put("por_def_cd_vld", "porDefCdVld");
		this.hashFields.put("pol_def_cd_vld", "polDefCdVld");
		this.hashFields.put("pod_def_cd_vld", "podDefCdVld");
		this.hashFields.put("del_def_cd_vld", "delDefCdVld");
		this.hashFields.put("ts_port_cd_vld", "tsPortCdVld");
		this.hashFields.put("tml_cd_vld", "tmlCdVld");
		this.hashFields.put("cmdt_cd_vld", "cmdtCdVld");
		this.hashFields.put("por_tp_cd_vld", "porTpCdVld");
		this.hashFields.put("pol_tp_cd_vld", "polTpCdVld");
		this.hashFields.put("pod_tp_cd_vld", "podTpCdVld");
		this.hashFields.put("del_tp_cd_vld", "delTpCdVld");
		this.hashFields.put("dup_idx", "dupIdx");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public	String getSeq() {
		return	this.seq;
	}

	/**
	 * Column Info
	 * @return porDefCd
	 */
	public	String getPorDefCd() {
		return	this.porDefCd;
	}

	/**
	 * Column Info
	 * @return polDefCd
	 */
	public	String getPolDefCd() {
		return	this.polDefCd;
	}

	/**
	 * Column Info
	 * @return podDefCd
	 */
	public	String getPodDefCd() {
		return	this.podDefCd;
	}

	/**
	 * Column Info
	 * @return delDefCd
	 */
	public	String getDelDefCd() {
		return	this.delDefCd;
	}

	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public	String getRatUtCd() {
		return	this.ratUtCd;
	}

	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public	String getPrcCgoTpCd() {
		return	this.prcCgoTpCd;
	}

	/**
	 * Column Info
	 * @return scgImdgClssCd
	 */
	public	String getScgImdgClssCd() {
		return	this.scgImdgClssCd;
	}

	/**
	 * Column Info
	 * @return currCd
	 */
	public	String getCurrCd() {
		return	this.currCd;
	}

	/**
	 * Column Info
	 * @return scgAmt
	 */
	public	String getScgAmt() {
		return	this.scgAmt;
	}

	/**
	 * Column Info
	 * @return payTermCd
	 */
	public	String getPayTermCd() {
		return	this.payTermCd;
	}

	/**
	 * Column Info
	 * @return cnlTzCd
	 */
	public	String getCnlTzCd() {
		return	this.cnlTzCd;
	}

	/**
	 * Column Info
	 * @return minCgoWgt
	 */
	public	String getMinCgoWgt() {
		return	this.minCgoWgt;
	}

	/**
	 * Column Info
	 * @return maxCgoWgt
	 */
	public	String getMaxCgoWgt() {
		return	this.maxCgoWgt;
	}

	/**
	 * Column Info
	 * @return orgTrspModCd
	 */
	public	String getOrgTrspModCd() {
		return	this.orgTrspModCd;
	}

	/**
	 * Column Info
	 * @return destTrspModCd
	 */
	public	String getDestTrspModCd() {
		return	this.destTrspModCd;
	}

	/**
	 * Column Info
	 * @return prcRcvTermCd
	 */
	public	String getPrcRcvTermCd() {
		return	this.prcRcvTermCd;
	}

	/**
	 * Column Info
	 * @return prcDeTermCd
	 */
	public	String getPrcDeTermCd() {
		return	this.prcDeTermCd;
	}

	/**
	 * Column Info
	 * @return prcHngrBarTpCd
	 */
	public	String getPrcHngrBarTpCd() {
		return	this.prcHngrBarTpCd;
	}

	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public	String getSubTrdCd() {
		return	this.subTrdCd;
	}

	/**
	 * Column Info
	 * @return dirCallFlg
	 */
	public	String getDirCallFlg() {
		return	this.dirCallFlg;
	}

	/**
	 * Column Info
	 * @return tmlCd
	 */
	public	String getTmlCd() {
		return	this.tmlCd;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public	String getCmdtCd() {
		return	this.cmdtCd;
	}

	/**
	 * Column Info
	 * @return ioGaCd
	 */
	public	String getIoGaCd() {
		return	this.ioGaCd;
	}

	/**
	 * Column Info
	 * @return tsPortCd
	 */
	public	String getTsPortCd() {
		return	this.tsPortCd;
	}

	/**
	 * Column Info
	 * @return socFlg
	 */
	public	String getSocFlg() {
		return	this.socFlg;
	}

	/**
	 * Column Info
	 * @return scgGrpCmdtCd
	 */
	public	String getScgGrpCmdtCd() {
		return	this.scgGrpCmdtCd;
	}

	/**
	 * Column Info
	 * @return usaSvcModCd
	 */
	public	String getUsaSvcModCd() {
		return	this.usaSvcModCd;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public	String getEffDt() {
		return	this.effDt;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public	String getExpDt() {
		return	this.expDt;
	}

	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public	String getSvcScpCd() {
		return	this.svcScpCd;
	}

	/**
	 * Column Info
	 * @return chgCd
	 */
	public	String getChgCd() {
		return	this.chgCd;
	}

	/**
	 * Column Info
	 * @return scgSeq
	 */
	public	String getScgSeq() {
		return	this.scgSeq;
	}

	/**
	 * Column Info
	 * @return porTpCd
	 */
	public	String getPorTpCd() {
		return	this.porTpCd;
	}

	/**
	 * Column Info
	 * @return polTpCd
	 */
	public	String getPolTpCd() {
		return	this.polTpCd;
	}

	/**
	 * Column Info
	 * @return podTpCd
	 */
	public	String getPodTpCd() {
		return	this.podTpCd;
	}

	/**
	 * Column Info
	 * @return delTpCd
	 */
	public	String getDelTpCd() {
		return	this.delTpCd;
	}

	/**
	 * Column Info
	 * @return porDefCdVld
	 */
	public	String getPorDefCdVld() {
		return	this.porDefCdVld;
	}

	/**
	 * Column Info
	 * @return polDefCdVld
	 */
	public	String getPolDefCdVld() {
		return	this.polDefCdVld;
	}

	/**
	 * Column Info
	 * @return podDefCdVld
	 */
	public	String getPodDefCdVld() {
		return	this.podDefCdVld;
	}

	/**
	 * Column Info
	 * @return delDefCdVld
	 */
	public	String getDelDefCdVld() {
		return	this.delDefCdVld;
	}

	/**
	 * Column Info
	 * @return tsPortCdVld
	 */
	public	String getTsPortCdVld() {
		return	this.tsPortCdVld;
	}

	/**
	 * Column Info
	 * @return tmlCdVld
	 */
	public	String getTmlCdVld() {
		return	this.tmlCdVld;
	}

	/**
	 * Column Info
	 * @return cmdtCdVld
	 */
	public	String getCmdtCdVld() {
		return	this.cmdtCdVld;
	}

	/**
	 * Column Info
	 * @return porTpCdVld
	 */
	public	String getPorTpCdVld() {
		return	this.porTpCdVld;
	}

	/**
	 * Column Info
	 * @return polTpCdVld
	 */
	public	String getPolTpCdVld() {
		return	this.polTpCdVld;
	}

	/**
	 * Column Info
	 * @return podTpCdVld
	 */
	public	String getPodTpCdVld() {
		return	this.podTpCdVld;
	}

	/**
	 * Column Info
	 * @return delTpCdVld
	 */
	public	String getDelTpCdVld() {
		return	this.delTpCdVld;
	}

	/**
	 * Column Info
	 * @return dupIdx
	 */
	public	String getDupIdx() {
		return	this.dupIdx;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  seq
 	 */
	public void	setSeq(String seq ) {
		this.seq =	seq;
	}
 	/**
	 * Column Info
	 * @param  porDefCd
 	 */
	public void	setPorDefCd(String porDefCd ) {
		this.porDefCd =	porDefCd;
	}
 	/**
	 * Column Info
	 * @param  polDefCd
 	 */
	public void	setPolDefCd(String polDefCd ) {
		this.polDefCd =	polDefCd;
	}
 	/**
	 * Column Info
	 * @param  podDefCd
 	 */
	public void	setPodDefCd(String podDefCd ) {
		this.podDefCd =	podDefCd;
	}
 	/**
	 * Column Info
	 * @param  delDefCd
 	 */
	public void	setDelDefCd(String delDefCd ) {
		this.delDefCd =	delDefCd;
	}
 	/**
	 * Column Info
	 * @param  ratUtCd
 	 */
	public void	setRatUtCd(String ratUtCd ) {
		this.ratUtCd =	ratUtCd;
	}
 	/**
	 * Column Info
	 * @param  prcCgoTpCd
 	 */
	public void	setPrcCgoTpCd(String prcCgoTpCd ) {
		this.prcCgoTpCd =	prcCgoTpCd;
	}
 	/**
	 * Column Info
	 * @param  scgImdgClssCd
 	 */
	public void	setScgImdgClssCd(String scgImdgClssCd ) {
		this.scgImdgClssCd =	scgImdgClssCd;
	}
 	/**
	 * Column Info
	 * @param  currCd
 	 */
	public void	setCurrCd(String currCd ) {
		this.currCd =	currCd;
	}
 	/**
	 * Column Info
	 * @param  scgAmt
 	 */
	public void	setScgAmt(String scgAmt ) {
		this.scgAmt =	scgAmt;
	}
 	/**
	 * Column Info
	 * @param  payTermCd
 	 */
	public void	setPayTermCd(String payTermCd ) {
		this.payTermCd =	payTermCd;
	}
 	/**
	 * Column Info
	 * @param  cnlTzCd
 	 */
	public void	setCnlTzCd(String cnlTzCd ) {
		this.cnlTzCd =	cnlTzCd;
	}
 	/**
	 * Column Info
	 * @param  minCgoWgt
 	 */
	public void	setMinCgoWgt(String minCgoWgt ) {
		this.minCgoWgt =	minCgoWgt;
	}
 	/**
	 * Column Info
	 * @param  maxCgoWgt
 	 */
	public void	setMaxCgoWgt(String maxCgoWgt ) {
		this.maxCgoWgt =	maxCgoWgt;
	}
 	/**
	 * Column Info
	 * @param  orgTrspModCd
 	 */
	public void	setOrgTrspModCd(String orgTrspModCd ) {
		this.orgTrspModCd =	orgTrspModCd;
	}
 	/**
	 * Column Info
	 * @param  destTrspModCd
 	 */
	public void	setDestTrspModCd(String destTrspModCd ) {
		this.destTrspModCd =	destTrspModCd;
	}
 	/**
	 * Column Info
	 * @param  prcRcvTermCd
 	 */
	public void	setPrcRcvTermCd(String prcRcvTermCd ) {
		this.prcRcvTermCd =	prcRcvTermCd;
	}
 	/**
	 * Column Info
	 * @param  prcDeTermCd
 	 */
	public void	setPrcDeTermCd(String prcDeTermCd ) {
		this.prcDeTermCd =	prcDeTermCd;
	}
 	/**
	 * Column Info
	 * @param  prcHngrBarTpCd
 	 */
	public void	setPrcHngrBarTpCd(String prcHngrBarTpCd ) {
		this.prcHngrBarTpCd =	prcHngrBarTpCd;
	}
 	/**
	 * Column Info
	 * @param  subTrdCd
 	 */
	public void	setSubTrdCd(String subTrdCd ) {
		this.subTrdCd =	subTrdCd;
	}
 	/**
	 * Column Info
	 * @param  dirCallFlg
 	 */
	public void	setDirCallFlg(String dirCallFlg ) {
		this.dirCallFlg =	dirCallFlg;
	}
 	/**
	 * Column Info
	 * @param  tmlCd
 	 */
	public void	setTmlCd(String tmlCd ) {
		this.tmlCd =	tmlCd;
	}
 	/**
	 * Column Info
	 * @param  cmdtCd
 	 */
	public void	setCmdtCd(String cmdtCd ) {
		this.cmdtCd =	cmdtCd;
	}
 	/**
	 * Column Info
	 * @param  ioGaCd
 	 */
	public void	setIoGaCd(String ioGaCd ) {
		this.ioGaCd =	ioGaCd;
	}
 	/**
	 * Column Info
	 * @param  tsPortCd
 	 */
	public void	setTsPortCd(String tsPortCd ) {
		this.tsPortCd =	tsPortCd;
	}
 	/**
	 * Column Info
	 * @param  socFlg
 	 */
	public void	setSocFlg(String socFlg ) {
		this.socFlg =	socFlg;
	}
 	/**
	 * Column Info
	 * @param  scgGrpCmdtCd
 	 */
	public void	setScgGrpCmdtCd(String scgGrpCmdtCd ) {
		this.scgGrpCmdtCd =	scgGrpCmdtCd;
	}
 	/**
	 * Column Info
	 * @param  usaSvcModCd
 	 */
	public void	setUsaSvcModCd(String usaSvcModCd ) {
		this.usaSvcModCd =	usaSvcModCd;
	}
 	/**
	 * Column Info
	 * @param  effDt
 	 */
	public void	setEffDt(String effDt ) {
		this.effDt =	effDt;
	}
 	/**
	 * Column Info
	 * @param  expDt
 	 */
	public void	setExpDt(String expDt ) {
		this.expDt =	expDt;
	}
 	/**
	 * Column Info
	 * @param  svcScpCd
 	 */
	public void	setSvcScpCd(String svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 	/**
	 * Column Info
	 * @param  chgCd
 	 */
	public void	setChgCd(String chgCd ) {
		this.chgCd =	chgCd;
	}
 	/**
	 * Column Info
	 * @param  scgSeq
 	 */
	public void	setScgSeq(String scgSeq ) {
		this.scgSeq =	scgSeq;
	}
 	/**
	 * Column Info
	 * @param  porTpCd
 	 */
	public void	setPorTpCd(String porTpCd ) {
		this.porTpCd =	porTpCd;
	}
 	/**
	 * Column Info
	 * @param  polTpCd
 	 */
	public void	setPolTpCd(String polTpCd ) {
		this.polTpCd =	polTpCd;
	}
 	/**
	 * Column Info
	 * @param  podTpCd
 	 */
	public void	setPodTpCd(String podTpCd ) {
		this.podTpCd =	podTpCd;
	}
 	/**
	 * Column Info
	 * @param  delTpCd
 	 */
	public void	setDelTpCd(String delTpCd ) {
		this.delTpCd =	delTpCd;
	}
 	/**
	 * Column Info
	 * @param  porDefCdVld
 	 */
	public void	setPorDefCdVld(String porDefCdVld ) {
		this.porDefCdVld =	porDefCdVld;
	}
 	/**
	 * Column Info
	 * @param  polDefCdVld
 	 */
	public void	setPolDefCdVld(String polDefCdVld ) {
		this.polDefCdVld =	polDefCdVld;
	}
 	/**
	 * Column Info
	 * @param  podDefCdVld
 	 */
	public void	setPodDefCdVld(String podDefCdVld ) {
		this.podDefCdVld =	podDefCdVld;
	}
 	/**
	 * Column Info
	 * @param  delDefCdVld
 	 */
	public void	setDelDefCdVld(String delDefCdVld ) {
		this.delDefCdVld =	delDefCdVld;
	}
 	/**
	 * Column Info
	 * @param  tsPortCdVld
 	 */
	public void	setTsPortCdVld(String tsPortCdVld ) {
		this.tsPortCdVld =	tsPortCdVld;
	}
 	/**
	 * Column Info
	 * @param  tmlCdVld
 	 */
	public void	setTmlCdVld(String tmlCdVld ) {
		this.tmlCdVld =	tmlCdVld;
	}
 	/**
	 * Column Info
	 * @param  cmdtCdVld
 	 */
	public void	setCmdtCdVld(String cmdtCdVld ) {
		this.cmdtCdVld =	cmdtCdVld;
	}
 	/**
	 * Column Info
	 * @param  porTpCdVld
 	 */
	public void	setPorTpCdVld(String porTpCdVld ) {
		this.porTpCdVld =	porTpCdVld;
	}
 	/**
	 * Column Info
	 * @param  polTpCdVld
 	 */
	public void	setPolTpCdVld(String polTpCdVld ) {
		this.polTpCdVld =	polTpCdVld;
	}
 	/**
	 * Column Info
	 * @param  podTpCdVld
 	 */
	public void	setPodTpCdVld(String podTpCdVld ) {
		this.podTpCdVld =	podTpCdVld;
	}
 	/**
	 * Column Info
	 * @param  delTpCdVld
 	 */
	public void	setDelTpCdVld(String delTpCdVld ) {
		this.delTpCdVld =	delTpCdVld;
	}
 	/**
	 * Column Info
	 * @param  dupIdx
 	 */
	public void	setDupIdx(String dupIdx ) {
		this.dupIdx =	dupIdx;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setPorDefCd(JSPUtil.getParameter(request,	prefix + "por_def_cd", ""));
		setPolDefCd(JSPUtil.getParameter(request,	prefix + "pol_def_cd", ""));
		setPodDefCd(JSPUtil.getParameter(request,	prefix + "pod_def_cd", ""));
		setDelDefCd(JSPUtil.getParameter(request,	prefix + "del_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request,	prefix + "rat_ut_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "prc_cgo_tp_cd", ""));
		setScgImdgClssCd(JSPUtil.getParameter(request,	prefix + "scg_imdg_clss_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setScgAmt(JSPUtil.getParameter(request,	prefix + "scg_amt", ""));
		setPayTermCd(JSPUtil.getParameter(request,	prefix + "pay_term_cd", ""));
		setCnlTzCd(JSPUtil.getParameter(request,	prefix + "cnl_tz_cd", ""));
		setMinCgoWgt(JSPUtil.getParameter(request,	prefix + "min_cgo_wgt", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request,	prefix + "max_cgo_wgt", ""));
		setOrgTrspModCd(JSPUtil.getParameter(request,	prefix + "org_trsp_mod_cd", ""));
		setDestTrspModCd(JSPUtil.getParameter(request,	prefix + "dest_trsp_mod_cd", ""));
		setPrcRcvTermCd(JSPUtil.getParameter(request,	prefix + "prc_rcv_term_cd", ""));
		setPrcDeTermCd(JSPUtil.getParameter(request,	prefix + "prc_de_term_cd", ""));
		setPrcHngrBarTpCd(JSPUtil.getParameter(request,	prefix + "prc_hngr_bar_tp_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request,	prefix + "sub_trd_cd", ""));
		setDirCallFlg(JSPUtil.getParameter(request,	prefix + "dir_call_flg", ""));
		setTmlCd(JSPUtil.getParameter(request,	prefix + "tml_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request,	prefix + "cmdt_cd", ""));
		setIoGaCd(JSPUtil.getParameter(request,	prefix + "io_ga_cd", ""));
		setTsPortCd(JSPUtil.getParameter(request,	prefix + "ts_port_cd", ""));
		setSocFlg(JSPUtil.getParameter(request,	prefix + "soc_flg", ""));
		setScgGrpCmdtCd(JSPUtil.getParameter(request,	prefix + "scg_grp_cmdt_cd", ""));
		setUsaSvcModCd(JSPUtil.getParameter(request,	prefix + "usa_svc_mod_cd", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setScgSeq(JSPUtil.getParameter(request,	prefix + "scg_seq", ""));
		setPorTpCd(JSPUtil.getParameter(request,	prefix + "por_tp_cd", ""));
		setPolTpCd(JSPUtil.getParameter(request,	prefix + "pol_tp_cd", ""));
		setPodTpCd(JSPUtil.getParameter(request,	prefix + "pod_tp_cd", ""));
		setDelTpCd(JSPUtil.getParameter(request,	prefix + "del_tp_cd", ""));
		setPorDefCdVld(JSPUtil.getParameter(request,	prefix + "por_def_cd_vld", ""));
		setPolDefCdVld(JSPUtil.getParameter(request,	prefix + "pol_def_cd_vld", ""));
		setPodDefCdVld(JSPUtil.getParameter(request,	prefix + "pod_def_cd_vld", ""));
		setDelDefCdVld(JSPUtil.getParameter(request,	prefix + "del_def_cd_vld", ""));
		setTsPortCdVld(JSPUtil.getParameter(request,	prefix + "ts_port_cd_vld", ""));
		setTmlCdVld(JSPUtil.getParameter(request,	prefix + "tml_cd_vld", ""));
		setCmdtCdVld(JSPUtil.getParameter(request,	prefix + "cmdt_cd_vld", ""));
		setPorTpCdVld(JSPUtil.getParameter(request,	prefix + "por_tp_cd_vld", ""));
		setPolTpCdVld(JSPUtil.getParameter(request,	prefix + "pol_tp_cd_vld", ""));
		setPodTpCdVld(JSPUtil.getParameter(request,	prefix + "pod_tp_cd_vld", ""));
		setDelTpCdVld(JSPUtil.getParameter(request,	prefix + "del_tp_cd_vld", ""));
		setDupIdx(JSPUtil.getParameter(request,	prefix + "dup_idx", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScgRtValidVO[]
	 */
	public PriScgRtValidVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriScgRtValidVO[]
	 */
	public PriScgRtValidVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriScgRtValidVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq",	length));
			String[] porDefCd =	(JSPUtil.getParameter(request, prefix +	"por_def_cd",	length));
			String[] polDefCd =	(JSPUtil.getParameter(request, prefix +	"pol_def_cd",	length));
			String[] podDefCd =	(JSPUtil.getParameter(request, prefix +	"pod_def_cd",	length));
			String[] delDefCd =	(JSPUtil.getParameter(request, prefix +	"del_def_cd",	length));
			String[] ratUtCd =	(JSPUtil.getParameter(request, prefix +	"rat_ut_cd",	length));
			String[] prcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_cgo_tp_cd",	length));
			String[] scgImdgClssCd =	(JSPUtil.getParameter(request, prefix +	"scg_imdg_clss_cd",	length));
			String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd",	length));
			String[] scgAmt =	(JSPUtil.getParameter(request, prefix +	"scg_amt",	length));
			String[] payTermCd =	(JSPUtil.getParameter(request, prefix +	"pay_term_cd",	length));
			String[] cnlTzCd =	(JSPUtil.getParameter(request, prefix +	"cnl_tz_cd",	length));
			String[] minCgoWgt =	(JSPUtil.getParameter(request, prefix +	"min_cgo_wgt",	length));
			String[] maxCgoWgt =	(JSPUtil.getParameter(request, prefix +	"max_cgo_wgt",	length));
			String[] orgTrspModCd =	(JSPUtil.getParameter(request, prefix +	"org_trsp_mod_cd",	length));
			String[] destTrspModCd =	(JSPUtil.getParameter(request, prefix +	"dest_trsp_mod_cd",	length));
			String[] prcRcvTermCd =	(JSPUtil.getParameter(request, prefix +	"prc_rcv_term_cd",	length));
			String[] prcDeTermCd =	(JSPUtil.getParameter(request, prefix +	"prc_de_term_cd",	length));
			String[] prcHngrBarTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_hngr_bar_tp_cd",	length));
			String[] subTrdCd =	(JSPUtil.getParameter(request, prefix +	"sub_trd_cd",	length));
			String[] dirCallFlg =	(JSPUtil.getParameter(request, prefix +	"dir_call_flg",	length));
			String[] tmlCd =	(JSPUtil.getParameter(request, prefix +	"tml_cd",	length));
			String[] cmdtCd =	(JSPUtil.getParameter(request, prefix +	"cmdt_cd",	length));
			String[] ioGaCd =	(JSPUtil.getParameter(request, prefix +	"io_ga_cd",	length));
			String[] tsPortCd =	(JSPUtil.getParameter(request, prefix +	"ts_port_cd",	length));
			String[] socFlg =	(JSPUtil.getParameter(request, prefix +	"soc_flg",	length));
			String[] scgGrpCmdtCd =	(JSPUtil.getParameter(request, prefix +	"scg_grp_cmdt_cd",	length));
			String[] usaSvcModCd =	(JSPUtil.getParameter(request, prefix +	"usa_svc_mod_cd",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd",	length));
			String[] scgSeq =	(JSPUtil.getParameter(request, prefix +	"scg_seq",	length));
			String[] porTpCd =	(JSPUtil.getParameter(request, prefix +	"por_tp_cd",	length));
			String[] polTpCd =	(JSPUtil.getParameter(request, prefix +	"pol_tp_cd",	length));
			String[] podTpCd =	(JSPUtil.getParameter(request, prefix +	"pod_tp_cd",	length));
			String[] delTpCd =	(JSPUtil.getParameter(request, prefix +	"del_tp_cd",	length));
			String[] porDefCdVld =	(JSPUtil.getParameter(request, prefix +	"por_def_cd_vld",	length));
			String[] polDefCdVld =	(JSPUtil.getParameter(request, prefix +	"pol_def_cd_vld",	length));
			String[] podDefCdVld =	(JSPUtil.getParameter(request, prefix +	"pod_def_cd_vld",	length));
			String[] delDefCdVld =	(JSPUtil.getParameter(request, prefix +	"del_def_cd_vld",	length));
			String[] tsPortCdVld =	(JSPUtil.getParameter(request, prefix +	"ts_port_cd_vld",	length));
			String[] tmlCdVld =	(JSPUtil.getParameter(request, prefix +	"tml_cd_vld",	length));
			String[] cmdtCdVld =	(JSPUtil.getParameter(request, prefix +	"cmdt_cd_vld",	length));
			String[] porTpCdVld =	(JSPUtil.getParameter(request, prefix +	"por_tp_cd_vld",	length));
			String[] polTpCdVld =	(JSPUtil.getParameter(request, prefix +	"pol_tp_cd_vld",	length));
			String[] podTpCdVld =	(JSPUtil.getParameter(request, prefix +	"pod_tp_cd_vld",	length));
			String[] delTpCdVld =	(JSPUtil.getParameter(request, prefix +	"del_tp_cd_vld",	length));
			String[] dupIdx =	(JSPUtil.getParameter(request, prefix +	"dup_idx",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriScgRtValidVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( seq[i] !=	null)
					model.setSeq( seq[i]);
				if ( porDefCd[i] !=	null)
					model.setPorDefCd( porDefCd[i]);
				if ( polDefCd[i] !=	null)
					model.setPolDefCd( polDefCd[i]);
				if ( podDefCd[i] !=	null)
					model.setPodDefCd( podDefCd[i]);
				if ( delDefCd[i] !=	null)
					model.setDelDefCd( delDefCd[i]);
				if ( ratUtCd[i] !=	null)
					model.setRatUtCd( ratUtCd[i]);
				if ( prcCgoTpCd[i] !=	null)
					model.setPrcCgoTpCd( prcCgoTpCd[i]);
				if ( scgImdgClssCd[i] !=	null)
					model.setScgImdgClssCd( scgImdgClssCd[i]);
				if ( currCd[i] !=	null)
					model.setCurrCd( currCd[i]);
				if ( scgAmt[i] !=	null)
					model.setScgAmt( scgAmt[i]);
				if ( payTermCd[i] !=	null)
					model.setPayTermCd( payTermCd[i]);
				if ( cnlTzCd[i] !=	null)
					model.setCnlTzCd( cnlTzCd[i]);
				if ( minCgoWgt[i] !=	null)
					model.setMinCgoWgt( minCgoWgt[i]);
				if ( maxCgoWgt[i] !=	null)
					model.setMaxCgoWgt( maxCgoWgt[i]);
				if ( orgTrspModCd[i] !=	null)
					model.setOrgTrspModCd( orgTrspModCd[i]);
				if ( destTrspModCd[i] !=	null)
					model.setDestTrspModCd( destTrspModCd[i]);
				if ( prcRcvTermCd[i] !=	null)
					model.setPrcRcvTermCd( prcRcvTermCd[i]);
				if ( prcDeTermCd[i] !=	null)
					model.setPrcDeTermCd( prcDeTermCd[i]);
				if ( prcHngrBarTpCd[i] !=	null)
					model.setPrcHngrBarTpCd( prcHngrBarTpCd[i]);
				if ( subTrdCd[i] !=	null)
					model.setSubTrdCd( subTrdCd[i]);
				if ( dirCallFlg[i] !=	null)
					model.setDirCallFlg( dirCallFlg[i]);
				if ( tmlCd[i] !=	null)
					model.setTmlCd( tmlCd[i]);
				if ( cmdtCd[i] !=	null)
					model.setCmdtCd( cmdtCd[i]);
				if ( ioGaCd[i] !=	null)
					model.setIoGaCd( ioGaCd[i]);
				if ( tsPortCd[i] !=	null)
					model.setTsPortCd( tsPortCd[i]);
				if ( socFlg[i] !=	null)
					model.setSocFlg( socFlg[i]);
				if ( scgGrpCmdtCd[i] !=	null)
					model.setScgGrpCmdtCd( scgGrpCmdtCd[i]);
				if ( usaSvcModCd[i] !=	null)
					model.setUsaSvcModCd( usaSvcModCd[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( chgCd[i] !=	null)
					model.setChgCd( chgCd[i]);
				if ( scgSeq[i] !=	null)
					model.setScgSeq( scgSeq[i]);
				if ( porTpCd[i] !=	null)
					model.setPorTpCd( porTpCd[i]);
				if ( polTpCd[i] !=	null)
					model.setPolTpCd( polTpCd[i]);
				if ( podTpCd[i] !=	null)
					model.setPodTpCd( podTpCd[i]);
				if ( delTpCd[i] !=	null)
					model.setDelTpCd( delTpCd[i]);
				if ( porDefCdVld[i] !=	null)
					model.setPorDefCdVld( porDefCdVld[i]);
				if ( polDefCdVld[i] !=	null)
					model.setPolDefCdVld( polDefCdVld[i]);
				if ( podDefCdVld[i] !=	null)
					model.setPodDefCdVld( podDefCdVld[i]);
				if ( delDefCdVld[i] !=	null)
					model.setDelDefCdVld( delDefCdVld[i]);
				if ( tsPortCdVld[i] !=	null)
					model.setTsPortCdVld( tsPortCdVld[i]);
				if ( tmlCdVld[i] !=	null)
					model.setTmlCdVld( tmlCdVld[i]);
				if ( cmdtCdVld[i] !=	null)
					model.setCmdtCdVld( cmdtCdVld[i]);
				if ( porTpCdVld[i] !=	null)
					model.setPorTpCdVld( porTpCdVld[i]);
				if ( polTpCdVld[i] !=	null)
					model.setPolTpCdVld( polTpCdVld[i]);
				if ( podTpCdVld[i] !=	null)
					model.setPodTpCdVld( podTpCdVld[i]);
				if ( delTpCdVld[i] !=	null)
					model.setDelTpCdVld( delTpCdVld[i]);
				if ( dupIdx[i] !=	null)
					model.setDupIdx( dupIdx[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriScgRtValidVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriScgRtValidVO[]
	 */
	public PriScgRtValidVO[]	 getPriScgRtValidVOs(){
		PriScgRtValidVO[] vos = (PriScgRtValidVO[])models.toArray(new	PriScgRtValidVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCd =	this.porDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCd =	this.polDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCd =	this.podDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCd =	this.delDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd =	this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd =	this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgImdgClssCd =	this.scgImdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgAmt =	this.scgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd =	this.payTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzCd =	this.cnlTzCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt =	this.minCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt =	this.maxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspModCd =	this.orgTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrspModCd =	this.destTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRcvTermCd =	this.prcRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcDeTermCd =	this.prcDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcHngrBarTpCd =	this.prcHngrBarTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd =	this.subTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallFlg =	this.dirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd =	this.tmlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd =	this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioGaCd =	this.ioGaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortCd =	this.tsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg =	this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtCd =	this.scgGrpCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModCd =	this.usaSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgSeq =	this.scgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porTpCd =	this.porTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTpCd =	this.polTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTpCd =	this.podTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTpCd =	this.delTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCdVld =	this.porDefCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCdVld =	this.polDefCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCdVld =	this.podDefCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCdVld =	this.delDefCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortCdVld =	this.tsPortCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCdVld =	this.tmlCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCdVld =	this.cmdtCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porTpCdVld =	this.porTpCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTpCdVld =	this.polTpCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTpCdVld =	this.podTpCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTpCdVld =	this.delTpCdVld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupIdx =	this.dupIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}