/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriScgPrfVO.java
 *@FileTitle : PriScgPrfVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.25
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.11.25 jaewonLee 
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
public class PriScgPrfVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriScgPrfVO>  models =	new	ArrayList<PriScgPrfVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String tsPortCnt = null;
	/*	Column Info	*/
	private String socUseFlg = null;
	/*	Column Info	*/
	private String socCnt = null;
	/*	Column Info	*/
	private String tmlCnt = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String subTrdCnt = null;
	/*	Column Info	*/
	private String chgCd = null;
	/*	Column Info	*/
	private String dirCallCnt = null;
	/*	Column Info	*/
	private String cmdtCnt = null;
	/*	Column Info	*/
	private String rcvDeTermUseFlg = null;
	/*	Column Info	*/
	private String tmlUseFlg = null;
	/*	Column Info	*/
	private String porDefCnt = null;
	/*	Column Info	*/
	private String polUseFlg = null;
	/*	Column Info	*/
	private String vslSlanCnt = null;
	/*	Column Info	*/
	private String rcvDeTermCnt = null;
	/*	Column Info	*/
	private String hngrBarUseFlg = null;
	/*	Column Info	*/
	private String hngrBarCnt = null;
	/*	Column Info	*/
	private String updUsrId = null;
	/*	Column Info	*/
	private String delDefCnt = null;
	/*	Column Info	*/
	private String fltPctTpCd = null;
	/*	Column Info	*/
	private String cmdtUseFlg = null;
	/*	Column Info	*/
	private String creUsrId = null;
	/*	Column Info	*/
	private String dirCallUseFlg = null;
	/*	Column Info	*/
	private String podDefCnt = null;
	/*	Column Info	*/
	private String pctBseCd = null;
	/*	Column Info	*/
	private String podUseFlg = null;
	/*	Column Info	*/
	private String porUseFlg = null;
	/*	Column Info	*/
	private String cgoWgtCnt = null;
	/*	Column Info	*/
	private String ioGaUseFlg = null;
	/*	Column Info	*/
	private String imdgClssUseFlg = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String cnlTzFlg = null;
	/*	Column Info	*/
	private String igGaCnt = null;
	/*	Column Info	*/
	private String usaSvcModUseFlg = null;
	/*	Column Info	*/
	private String griCmdtUseFlg = null;
	/*	Column Info	*/
	private String scgImdgClssCnt = null;
	/*	Column Info	*/
	private String slanUseFlg = null;
	/*	Column Info	*/
	private String polDefCnt = null;
	/*	Column Info	*/
	private String cgoWgtUseFlg = null;
	/*	Column Info	*/
	private String tsPortUseFlg = null;
	/*	Column Info	*/
	private String usaSvcModCnt = null;
	/*	Column Info	*/
	private String updDt = null;
	/*	Column Info	*/
	private String delUseFlg = null;
	/*	Column Info	*/
	private String griCmdtCnt = null;
	/*	Column Info	*/
	private String trnsModCnt = null;
	/*	Column Info	*/
	private String trnsModUseFlg = null;
	/*	Column Info	*/
	private String cnlTzCnt = null;
	/*	Column Info	*/
	private String subTrdUseFlg = null;
	/*	Column Info	*/
	private String esvcCnt = null;
	/*	Column Info	*/
	private String esvcUseFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriScgPrfVO(){}

	public PriScgPrfVO(String ibflag,String pagerows,String tsPortCnt,String socUseFlg,String socCnt,String tmlCnt,String svcScpCd,String subTrdCnt,String chgCd,String dirCallCnt,String cmdtCnt,String rcvDeTermUseFlg,String tmlUseFlg,String porDefCnt,String polUseFlg,String vslSlanCnt,String rcvDeTermCnt,String hngrBarUseFlg,String hngrBarCnt,String updUsrId,String delDefCnt,String fltPctTpCd,String cmdtUseFlg,String creUsrId,String dirCallUseFlg,String podDefCnt,String pctBseCd,String podUseFlg,String porUseFlg,String cgoWgtCnt,String ioGaUseFlg,String imdgClssUseFlg,String creDt,String cnlTzFlg,String igGaCnt,String usaSvcModUseFlg,String griCmdtUseFlg,String scgImdgClssCnt,String slanUseFlg,String polDefCnt,String cgoWgtUseFlg,String tsPortUseFlg,String usaSvcModCnt,String updDt,String delUseFlg,String griCmdtCnt,String trnsModCnt,String trnsModUseFlg,String cnlTzCnt,String subTrdUseFlg,String esvcCnt,String esvcUseFlg)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.tsPortCnt = tsPortCnt;
		this.socUseFlg = socUseFlg;
		this.socCnt = socCnt;
		this.tmlCnt = tmlCnt;
		this.svcScpCd = svcScpCd;
		this.subTrdCnt = subTrdCnt;
		this.chgCd = chgCd;
		this.dirCallCnt = dirCallCnt;
		this.cmdtCnt = cmdtCnt;
		this.rcvDeTermUseFlg = rcvDeTermUseFlg;
		this.tmlUseFlg = tmlUseFlg;
		this.porDefCnt = porDefCnt;
		this.polUseFlg = polUseFlg;
		this.vslSlanCnt = vslSlanCnt;
		this.rcvDeTermCnt = rcvDeTermCnt;
		this.hngrBarUseFlg = hngrBarUseFlg;
		this.hngrBarCnt = hngrBarCnt;
		this.updUsrId = updUsrId;
		this.delDefCnt = delDefCnt;
		this.fltPctTpCd = fltPctTpCd;
		this.cmdtUseFlg = cmdtUseFlg;
		this.creUsrId = creUsrId;
		this.dirCallUseFlg = dirCallUseFlg;
		this.podDefCnt = podDefCnt;
		this.pctBseCd = pctBseCd;
		this.podUseFlg = podUseFlg;
		this.porUseFlg = porUseFlg;
		this.cgoWgtCnt = cgoWgtCnt;
		this.ioGaUseFlg = ioGaUseFlg;
		this.imdgClssUseFlg = imdgClssUseFlg;
		this.creDt = creDt;
		this.cnlTzFlg = cnlTzFlg;
		this.igGaCnt = igGaCnt;
		this.usaSvcModUseFlg = usaSvcModUseFlg;
		this.griCmdtUseFlg = griCmdtUseFlg;
		this.scgImdgClssCnt = scgImdgClssCnt;
		this.slanUseFlg = slanUseFlg;
		this.polDefCnt = polDefCnt;
		this.cgoWgtUseFlg = cgoWgtUseFlg;
		this.tsPortUseFlg = tsPortUseFlg;
		this.usaSvcModCnt = usaSvcModCnt;
		this.updDt = updDt;
		this.delUseFlg = delUseFlg;
		this.griCmdtCnt = griCmdtCnt;
		this.trnsModCnt = trnsModCnt;
		this.trnsModUseFlg = trnsModUseFlg;
		this.cnlTzCnt = cnlTzCnt;
		this.subTrdUseFlg = subTrdUseFlg;
		this.esvcCnt = esvcCnt;
		this.esvcUseFlg = esvcUseFlg;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_port_cnt", getTsPortCnt());
		this.hashColumns.put("soc_use_flg", getSocUseFlg());
		this.hashColumns.put("soc_cnt", getSocCnt());
		this.hashColumns.put("tml_cnt", getTmlCnt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("sub_trd_cnt", getSubTrdCnt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("dir_call_cnt", getDirCallCnt());
		this.hashColumns.put("cmdt_cnt", getCmdtCnt());
		this.hashColumns.put("rcv_de_term_use_flg", getRcvDeTermUseFlg());
		this.hashColumns.put("tml_use_flg", getTmlUseFlg());
		this.hashColumns.put("por_def_cnt", getPorDefCnt());
		this.hashColumns.put("pol_use_flg", getPolUseFlg());
		this.hashColumns.put("vsl_slan_cnt", getVslSlanCnt());
		this.hashColumns.put("rcv_de_term_cnt", getRcvDeTermCnt());
		this.hashColumns.put("hngr_bar_use_flg", getHngrBarUseFlg());
		this.hashColumns.put("hngr_bar_cnt", getHngrBarCnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("del_def_cnt", getDelDefCnt());
		this.hashColumns.put("flt_pct_tp_cd", getFltPctTpCd());
		this.hashColumns.put("cmdt_use_flg", getCmdtUseFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dir_call_use_flg", getDirCallUseFlg());
		this.hashColumns.put("pod_def_cnt", getPodDefCnt());
		this.hashColumns.put("pct_bse_cd", getPctBseCd());
		this.hashColumns.put("pod_use_flg", getPodUseFlg());
		this.hashColumns.put("por_use_flg", getPorUseFlg());
		this.hashColumns.put("cgo_wgt_cnt", getCgoWgtCnt());
		this.hashColumns.put("io_ga_use_flg", getIoGaUseFlg());
		this.hashColumns.put("imdg_clss_use_flg", getImdgClssUseFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cnl_tz_flg", getCnlTzFlg());
		this.hashColumns.put("ig_ga_cnt", getIgGaCnt());
		this.hashColumns.put("usa_svc_mod_use_flg", getUsaSvcModUseFlg());
		this.hashColumns.put("gri_cmdt_use_flg", getGriCmdtUseFlg());
		this.hashColumns.put("scg_imdg_clss_cnt", getScgImdgClssCnt());
		this.hashColumns.put("slan_use_flg", getSlanUseFlg());
		this.hashColumns.put("pol_def_cnt", getPolDefCnt());
		this.hashColumns.put("cgo_wgt_use_flg", getCgoWgtUseFlg());
		this.hashColumns.put("ts_port_use_flg", getTsPortUseFlg());
		this.hashColumns.put("usa_svc_mod_cnt", getUsaSvcModCnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("del_use_flg", getDelUseFlg());
		this.hashColumns.put("gri_cmdt_cnt", getGriCmdtCnt());
		this.hashColumns.put("trns_mod_cnt", getTrnsModCnt());
		this.hashColumns.put("trns_mod_use_flg", getTrnsModUseFlg());
		this.hashColumns.put("cnl_tz_cnt", getCnlTzCnt());
		this.hashColumns.put("sub_trd_use_flg", getSubTrdUseFlg());
		this.hashColumns.put("esvc_cnt", getEsvcCnt());
		this.hashColumns.put("esvc_use_flg", getEsvcUseFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_port_cnt", "tsPortCnt");
		this.hashFields.put("soc_use_flg", "socUseFlg");
		this.hashFields.put("soc_cnt", "socCnt");
		this.hashFields.put("tml_cnt", "tmlCnt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("sub_trd_cnt", "subTrdCnt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("dir_call_cnt", "dirCallCnt");
		this.hashFields.put("cmdt_cnt", "cmdtCnt");
		this.hashFields.put("rcv_de_term_use_flg", "rcvDeTermUseFlg");
		this.hashFields.put("tml_use_flg", "tmlUseFlg");
		this.hashFields.put("por_def_cnt", "porDefCnt");
		this.hashFields.put("pol_use_flg", "polUseFlg");
		this.hashFields.put("vsl_slan_cnt", "vslSlanCnt");
		this.hashFields.put("rcv_de_term_cnt", "rcvDeTermCnt");
		this.hashFields.put("hngr_bar_use_flg", "hngrBarUseFlg");
		this.hashFields.put("hngr_bar_cnt", "hngrBarCnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("del_def_cnt", "delDefCnt");
		this.hashFields.put("flt_pct_tp_cd", "fltPctTpCd");
		this.hashFields.put("cmdt_use_flg", "cmdtUseFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dir_call_use_flg", "dirCallUseFlg");
		this.hashFields.put("pod_def_cnt", "podDefCnt");
		this.hashFields.put("pct_bse_cd", "pctBseCd");
		this.hashFields.put("pod_use_flg", "podUseFlg");
		this.hashFields.put("por_use_flg", "porUseFlg");
		this.hashFields.put("cgo_wgt_cnt", "cgoWgtCnt");
		this.hashFields.put("io_ga_use_flg", "ioGaUseFlg");
		this.hashFields.put("imdg_clss_use_flg", "imdgClssUseFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cnl_tz_flg", "cnlTzFlg");
		this.hashFields.put("ig_ga_cnt", "igGaCnt");
		this.hashFields.put("usa_svc_mod_use_flg", "usaSvcModUseFlg");
		this.hashFields.put("gri_cmdt_use_flg", "griCmdtUseFlg");
		this.hashFields.put("scg_imdg_clss_cnt", "scgImdgClssCnt");
		this.hashFields.put("slan_use_flg", "slanUseFlg");
		this.hashFields.put("pol_def_cnt", "polDefCnt");
		this.hashFields.put("cgo_wgt_use_flg", "cgoWgtUseFlg");
		this.hashFields.put("ts_port_use_flg", "tsPortUseFlg");
		this.hashFields.put("usa_svc_mod_cnt", "usaSvcModCnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("del_use_flg", "delUseFlg");
		this.hashFields.put("gri_cmdt_cnt", "griCmdtCnt");
		this.hashFields.put("trns_mod_cnt", "trnsModCnt");
		this.hashFields.put("trns_mod_use_flg", "trnsModUseFlg");
		this.hashFields.put("cnl_tz_cnt", "cnlTzCnt");
		this.hashFields.put("sub_trd_use_flg", "subTrdUseFlg");
		this.hashFields.put("esvc_cnt", "esvcCnt");
		this.hashFields.put("esvc_use_flg", "esvcUseFlg");
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
	 * @return tsPortCnt
	 */
	public	String getTsPortCnt() {
		return	this.tsPortCnt;
	}

	/**
	 * Column Info
	 * @return socUseFlg
	 */
	public	String getSocUseFlg() {
		return	this.socUseFlg;
	}

	/**
	 * Column Info
	 * @return socCnt
	 */
	public	String getSocCnt() {
		return	this.socCnt;
	}

	/**
	 * Column Info
	 * @return tmlCnt
	 */
	public	String getTmlCnt() {
		return	this.tmlCnt;
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
	 * @return subTrdCnt
	 */
	public	String getSubTrdCnt() {
		return	this.subTrdCnt;
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
	 * @return dirCallCnt
	 */
	public	String getDirCallCnt() {
		return	this.dirCallCnt;
	}

	/**
	 * Column Info
	 * @return cmdtCnt
	 */
	public	String getCmdtCnt() {
		return	this.cmdtCnt;
	}

	/**
	 * Column Info
	 * @return rcvDeTermUseFlg
	 */
	public	String getRcvDeTermUseFlg() {
		return	this.rcvDeTermUseFlg;
	}

	/**
	 * Column Info
	 * @return tmlUseFlg
	 */
	public	String getTmlUseFlg() {
		return	this.tmlUseFlg;
	}

	/**
	 * Column Info
	 * @return porDefCnt
	 */
	public	String getPorDefCnt() {
		return	this.porDefCnt;
	}

	/**
	 * Column Info
	 * @return polUseFlg
	 */
	public	String getPolUseFlg() {
		return	this.polUseFlg;
	}

	/**
	 * Column Info
	 * @return vslSlanCnt
	 */
	public	String getVslSlanCnt() {
		return	this.vslSlanCnt;
	}

	/**
	 * Column Info
	 * @return rcvDeTermCnt
	 */
	public	String getRcvDeTermCnt() {
		return	this.rcvDeTermCnt;
	}

	/**
	 * Column Info
	 * @return hngrBarUseFlg
	 */
	public	String getHngrBarUseFlg() {
		return	this.hngrBarUseFlg;
	}

	/**
	 * Column Info
	 * @return hngrBarCnt
	 */
	public	String getHngrBarCnt() {
		return	this.hngrBarCnt;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public	String getUpdUsrId() {
		return	this.updUsrId;
	}

	/**
	 * Column Info
	 * @return delDefCnt
	 */
	public	String getDelDefCnt() {
		return	this.delDefCnt;
	}

	/**
	 * Column Info
	 * @return fltPctTpCd
	 */
	public	String getFltPctTpCd() {
		return	this.fltPctTpCd;
	}

	/**
	 * Column Info
	 * @return cmdtUseFlg
	 */
	public	String getCmdtUseFlg() {
		return	this.cmdtUseFlg;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public	String getCreUsrId() {
		return	this.creUsrId;
	}

	/**
	 * Column Info
	 * @return dirCallUseFlg
	 */
	public	String getDirCallUseFlg() {
		return	this.dirCallUseFlg;
	}

	/**
	 * Column Info
	 * @return podDefCnt
	 */
	public	String getPodDefCnt() {
		return	this.podDefCnt;
	}

	/**
	 * Column Info
	 * @return pctBseCd
	 */
	public	String getPctBseCd() {
		return	this.pctBseCd;
	}

	/**
	 * Column Info
	 * @return podUseFlg
	 */
	public	String getPodUseFlg() {
		return	this.podUseFlg;
	}

	/**
	 * Column Info
	 * @return porUseFlg
	 */
	public	String getPorUseFlg() {
		return	this.porUseFlg;
	}

	/**
	 * Column Info
	 * @return cgoWgtCnt
	 */
	public	String getCgoWgtCnt() {
		return	this.cgoWgtCnt;
	}

	/**
	 * Column Info
	 * @return ioGaUseFlg
	 */
	public	String getIoGaUseFlg() {
		return	this.ioGaUseFlg;
	}

	/**
	 * Column Info
	 * @return imdgClssUseFlg
	 */
	public	String getImdgClssUseFlg() {
		return	this.imdgClssUseFlg;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public	String getCreDt() {
		return	this.creDt;
	}

	/**
	 * Column Info
	 * @return cnlTzFlg
	 */
	public	String getCnlTzFlg() {
		return	this.cnlTzFlg;
	}

	/**
	 * Column Info
	 * @return igGaCnt
	 */
	public	String getIgGaCnt() {
		return	this.igGaCnt;
	}

	/**
	 * Column Info
	 * @return usaSvcModUseFlg
	 */
	public	String getUsaSvcModUseFlg() {
		return	this.usaSvcModUseFlg;
	}

	/**
	 * Column Info
	 * @return griCmdtUseFlg
	 */
	public	String getGriCmdtUseFlg() {
		return	this.griCmdtUseFlg;
	}

	/**
	 * Column Info
	 * @return scgImdgClssCnt
	 */
	public	String getScgImdgClssCnt() {
		return	this.scgImdgClssCnt;
	}

	/**
	 * Column Info
	 * @return slanUseFlg
	 */
	public	String getSlanUseFlg() {
		return	this.slanUseFlg;
	}

	/**
	 * Column Info
	 * @return polDefCnt
	 */
	public	String getPolDefCnt() {
		return	this.polDefCnt;
	}

	/**
	 * Column Info
	 * @return cgoWgtUseFlg
	 */
	public	String getCgoWgtUseFlg() {
		return	this.cgoWgtUseFlg;
	}

	/**
	 * Column Info
	 * @return tsPortUseFlg
	 */
	public	String getTsPortUseFlg() {
		return	this.tsPortUseFlg;
	}

	/**
	 * Column Info
	 * @return usaSvcModCnt
	 */
	public	String getUsaSvcModCnt() {
		return	this.usaSvcModCnt;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public	String getUpdDt() {
		return	this.updDt;
	}

	/**
	 * Column Info
	 * @return delUseFlg
	 */
	public	String getDelUseFlg() {
		return	this.delUseFlg;
	}

	/**
	 * Column Info
	 * @return griCmdtCnt
	 */
	public	String getGriCmdtCnt() {
		return	this.griCmdtCnt;
	}

	/**
	 * Column Info
	 * @return trnsModCnt
	 */
	public	String getTrnsModCnt() {
		return	this.trnsModCnt;
	}

	/**
	 * Column Info
	 * @return trnsModUseFlg
	 */
	public	String getTrnsModUseFlg() {
		return	this.trnsModUseFlg;
	}

	/**
	 * Column Info
	 * @return cnlTzCnt
	 */
	public	String getCnlTzCnt() {
		return	this.cnlTzCnt;
	}

	/**
	 * Column Info
	 * @return subTrdUseFlg
	 */
	public	String getSubTrdUseFlg() {
		return	this.subTrdUseFlg;
	}

	/**
	 * Column Info
	 * @return esvcCnt
	 */
	public	String getEsvcCnt() {
		return	this.esvcCnt;
	}

	/**
	 * Column Info
	 * @return esvcUseFlg
	 */
	public	String getEsvcUseFlg() {
		return	this.esvcUseFlg;
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
	 * @param  tsPortCnt
 	 */
	public void	setTsPortCnt(String tsPortCnt ) {
		this.tsPortCnt =	tsPortCnt;
	}
 	/**
	 * Column Info
	 * @param  socUseFlg
 	 */
	public void	setSocUseFlg(String socUseFlg ) {
		this.socUseFlg =	socUseFlg;
	}
 	/**
	 * Column Info
	 * @param  socCnt
 	 */
	public void	setSocCnt(String socCnt ) {
		this.socCnt =	socCnt;
	}
 	/**
	 * Column Info
	 * @param  tmlCnt
 	 */
	public void	setTmlCnt(String tmlCnt ) {
		this.tmlCnt =	tmlCnt;
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
	 * @param  subTrdCnt
 	 */
	public void	setSubTrdCnt(String subTrdCnt ) {
		this.subTrdCnt =	subTrdCnt;
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
	 * @param  dirCallCnt
 	 */
	public void	setDirCallCnt(String dirCallCnt ) {
		this.dirCallCnt =	dirCallCnt;
	}
 	/**
	 * Column Info
	 * @param  cmdtCnt
 	 */
	public void	setCmdtCnt(String cmdtCnt ) {
		this.cmdtCnt =	cmdtCnt;
	}
 	/**
	 * Column Info
	 * @param  rcvDeTermUseFlg
 	 */
	public void	setRcvDeTermUseFlg(String rcvDeTermUseFlg ) {
		this.rcvDeTermUseFlg =	rcvDeTermUseFlg;
	}
 	/**
	 * Column Info
	 * @param  tmlUseFlg
 	 */
	public void	setTmlUseFlg(String tmlUseFlg ) {
		this.tmlUseFlg =	tmlUseFlg;
	}
 	/**
	 * Column Info
	 * @param  porDefCnt
 	 */
	public void	setPorDefCnt(String porDefCnt ) {
		this.porDefCnt =	porDefCnt;
	}
 	/**
	 * Column Info
	 * @param  polUseFlg
 	 */
	public void	setPolUseFlg(String polUseFlg ) {
		this.polUseFlg =	polUseFlg;
	}
 	/**
	 * Column Info
	 * @param  vslSlanCnt
 	 */
	public void	setVslSlanCnt(String vslSlanCnt ) {
		this.vslSlanCnt =	vslSlanCnt;
	}
 	/**
	 * Column Info
	 * @param  rcvDeTermCnt
 	 */
	public void	setRcvDeTermCnt(String rcvDeTermCnt ) {
		this.rcvDeTermCnt =	rcvDeTermCnt;
	}
 	/**
	 * Column Info
	 * @param  hngrBarUseFlg
 	 */
	public void	setHngrBarUseFlg(String hngrBarUseFlg ) {
		this.hngrBarUseFlg =	hngrBarUseFlg;
	}
 	/**
	 * Column Info
	 * @param  hngrBarCnt
 	 */
	public void	setHngrBarCnt(String hngrBarCnt ) {
		this.hngrBarCnt =	hngrBarCnt;
	}
 	/**
	 * Column Info
	 * @param  updUsrId
 	 */
	public void	setUpdUsrId(String updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 	/**
	 * Column Info
	 * @param  delDefCnt
 	 */
	public void	setDelDefCnt(String delDefCnt ) {
		this.delDefCnt =	delDefCnt;
	}
 	/**
	 * Column Info
	 * @param  fltPctTpCd
 	 */
	public void	setFltPctTpCd(String fltPctTpCd ) {
		this.fltPctTpCd =	fltPctTpCd;
	}
 	/**
	 * Column Info
	 * @param  cmdtUseFlg
 	 */
	public void	setCmdtUseFlg(String cmdtUseFlg ) {
		this.cmdtUseFlg =	cmdtUseFlg;
	}
 	/**
	 * Column Info
	 * @param  creUsrId
 	 */
	public void	setCreUsrId(String creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 	/**
	 * Column Info
	 * @param  dirCallUseFlg
 	 */
	public void	setDirCallUseFlg(String dirCallUseFlg ) {
		this.dirCallUseFlg =	dirCallUseFlg;
	}
 	/**
	 * Column Info
	 * @param  podDefCnt
 	 */
	public void	setPodDefCnt(String podDefCnt ) {
		this.podDefCnt =	podDefCnt;
	}
 	/**
	 * Column Info
	 * @param  pctBseCd
 	 */
	public void	setPctBseCd(String pctBseCd ) {
		this.pctBseCd =	pctBseCd;
	}
 	/**
	 * Column Info
	 * @param  podUseFlg
 	 */
	public void	setPodUseFlg(String podUseFlg ) {
		this.podUseFlg =	podUseFlg;
	}
 	/**
	 * Column Info
	 * @param  porUseFlg
 	 */
	public void	setPorUseFlg(String porUseFlg ) {
		this.porUseFlg =	porUseFlg;
	}
 	/**
	 * Column Info
	 * @param  cgoWgtCnt
 	 */
	public void	setCgoWgtCnt(String cgoWgtCnt ) {
		this.cgoWgtCnt =	cgoWgtCnt;
	}
 	/**
	 * Column Info
	 * @param  ioGaUseFlg
 	 */
	public void	setIoGaUseFlg(String ioGaUseFlg ) {
		this.ioGaUseFlg =	ioGaUseFlg;
	}
 	/**
	 * Column Info
	 * @param  imdgClssUseFlg
 	 */
	public void	setImdgClssUseFlg(String imdgClssUseFlg ) {
		this.imdgClssUseFlg =	imdgClssUseFlg;
	}
 	/**
	 * Column Info
	 * @param  creDt
 	 */
	public void	setCreDt(String creDt ) {
		this.creDt =	creDt;
	}
 	/**
	 * Column Info
	 * @param  cnlTzFlg
 	 */
	public void	setCnlTzFlg(String cnlTzFlg ) {
		this.cnlTzFlg =	cnlTzFlg;
	}
 	/**
	 * Column Info
	 * @param  igGaCnt
 	 */
	public void	setIgGaCnt(String igGaCnt ) {
		this.igGaCnt =	igGaCnt;
	}
 	/**
	 * Column Info
	 * @param  usaSvcModUseFlg
 	 */
	public void	setUsaSvcModUseFlg(String usaSvcModUseFlg ) {
		this.usaSvcModUseFlg =	usaSvcModUseFlg;
	}
 	/**
	 * Column Info
	 * @param  griCmdtUseFlg
 	 */
	public void	setGriCmdtUseFlg(String griCmdtUseFlg ) {
		this.griCmdtUseFlg =	griCmdtUseFlg;
	}
 	/**
	 * Column Info
	 * @param  scgImdgClssCnt
 	 */
	public void	setScgImdgClssCnt(String scgImdgClssCnt ) {
		this.scgImdgClssCnt =	scgImdgClssCnt;
	}
 	/**
	 * Column Info
	 * @param  slanUseFlg
 	 */
	public void	setSlanUseFlg(String slanUseFlg ) {
		this.slanUseFlg =	slanUseFlg;
	}
 	/**
	 * Column Info
	 * @param  polDefCnt
 	 */
	public void	setPolDefCnt(String polDefCnt ) {
		this.polDefCnt =	polDefCnt;
	}
 	/**
	 * Column Info
	 * @param  cgoWgtUseFlg
 	 */
	public void	setCgoWgtUseFlg(String cgoWgtUseFlg ) {
		this.cgoWgtUseFlg =	cgoWgtUseFlg;
	}
 	/**
	 * Column Info
	 * @param  tsPortUseFlg
 	 */
	public void	setTsPortUseFlg(String tsPortUseFlg ) {
		this.tsPortUseFlg =	tsPortUseFlg;
	}
 	/**
	 * Column Info
	 * @param  usaSvcModCnt
 	 */
	public void	setUsaSvcModCnt(String usaSvcModCnt ) {
		this.usaSvcModCnt =	usaSvcModCnt;
	}
 	/**
	 * Column Info
	 * @param  updDt
 	 */
	public void	setUpdDt(String updDt ) {
		this.updDt =	updDt;
	}
 	/**
	 * Column Info
	 * @param  delUseFlg
 	 */
	public void	setDelUseFlg(String delUseFlg ) {
		this.delUseFlg =	delUseFlg;
	}
 	/**
	 * Column Info
	 * @param  griCmdtCnt
 	 */
	public void	setGriCmdtCnt(String griCmdtCnt ) {
		this.griCmdtCnt =	griCmdtCnt;
	}
 	/**
	 * Column Info
	 * @param  trnsModCnt
 	 */
	public void	setTrnsModCnt(String trnsModCnt ) {
		this.trnsModCnt =	trnsModCnt;
	}
 	/**
	 * Column Info
	 * @param  trnsModUseFlg
 	 */
	public void	setTrnsModUseFlg(String trnsModUseFlg ) {
		this.trnsModUseFlg =	trnsModUseFlg;
	}
 	/**
	 * Column Info
	 * @param  cnlTzCnt
 	 */
	public void	setCnlTzCnt(String cnlTzCnt ) {
		this.cnlTzCnt =	cnlTzCnt;
	}
 	/**
	 * Column Info
	 * @param  subTrdUseFlg
 	 */
	public void	setSubTrdUseFlg(String subTrdUseFlg ) {
		this.subTrdUseFlg =	subTrdUseFlg;
	}
 	/**
	 * Column Info
	 * @param  esvcCnt
 	 */
	public void	setEsvcCnt(String esvcCnt ) {
		this.esvcCnt =	esvcCnt;
	}
 	/**
	 * Column Info
	 * @param  esvcUseFlg
 	 */
	public void	setEsvcUseFlg(String esvcUseFlg ) {
		this.esvcUseFlg =	esvcUseFlg;
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
		setTsPortCnt(JSPUtil.getParameter(request,	prefix + "ts_port_cnt", ""));
		setSocUseFlg(JSPUtil.getParameter(request,	prefix + "soc_use_flg", ""));
		setSocCnt(JSPUtil.getParameter(request,	prefix + "soc_cnt", ""));
		setTmlCnt(JSPUtil.getParameter(request,	prefix + "tml_cnt", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setSubTrdCnt(JSPUtil.getParameter(request,	prefix + "sub_trd_cnt", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setDirCallCnt(JSPUtil.getParameter(request,	prefix + "dir_call_cnt", ""));
		setCmdtCnt(JSPUtil.getParameter(request,	prefix + "cmdt_cnt", ""));
		setRcvDeTermUseFlg(JSPUtil.getParameter(request,	prefix + "rcv_de_term_use_flg", ""));
		setTmlUseFlg(JSPUtil.getParameter(request,	prefix + "tml_use_flg", ""));
		setPorDefCnt(JSPUtil.getParameter(request,	prefix + "por_def_cnt", ""));
		setPolUseFlg(JSPUtil.getParameter(request,	prefix + "pol_use_flg", ""));
		setVslSlanCnt(JSPUtil.getParameter(request,	prefix + "vsl_slan_cnt", ""));
		setRcvDeTermCnt(JSPUtil.getParameter(request,	prefix + "rcv_de_term_cnt", ""));
		setHngrBarUseFlg(JSPUtil.getParameter(request,	prefix + "hngr_bar_use_flg", ""));
		setHngrBarCnt(JSPUtil.getParameter(request,	prefix + "hngr_bar_cnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setDelDefCnt(JSPUtil.getParameter(request,	prefix + "del_def_cnt", ""));
		setFltPctTpCd(JSPUtil.getParameter(request,	prefix + "flt_pct_tp_cd", ""));
		setCmdtUseFlg(JSPUtil.getParameter(request,	prefix + "cmdt_use_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setDirCallUseFlg(JSPUtil.getParameter(request,	prefix + "dir_call_use_flg", ""));
		setPodDefCnt(JSPUtil.getParameter(request,	prefix + "pod_def_cnt", ""));
		setPctBseCd(JSPUtil.getParameter(request,	prefix + "pct_bse_cd", ""));
		setPodUseFlg(JSPUtil.getParameter(request,	prefix + "pod_use_flg", ""));
		setPorUseFlg(JSPUtil.getParameter(request,	prefix + "por_use_flg", ""));
		setCgoWgtCnt(JSPUtil.getParameter(request,	prefix + "cgo_wgt_cnt", ""));
		setIoGaUseFlg(JSPUtil.getParameter(request,	prefix + "io_ga_use_flg", ""));
		setImdgClssUseFlg(JSPUtil.getParameter(request,	prefix + "imdg_clss_use_flg", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setCnlTzFlg(JSPUtil.getParameter(request,	prefix + "cnl_tz_flg", ""));
		setIgGaCnt(JSPUtil.getParameter(request,	prefix + "ig_ga_cnt", ""));
		setUsaSvcModUseFlg(JSPUtil.getParameter(request,	prefix + "usa_svc_mod_use_flg", ""));
		setGriCmdtUseFlg(JSPUtil.getParameter(request,	prefix + "gri_cmdt_use_flg", ""));
		setScgImdgClssCnt(JSPUtil.getParameter(request,	prefix + "scg_imdg_clss_cnt", ""));
		setSlanUseFlg(JSPUtil.getParameter(request,	prefix + "slan_use_flg", ""));
		setPolDefCnt(JSPUtil.getParameter(request,	prefix + "pol_def_cnt", ""));
		setCgoWgtUseFlg(JSPUtil.getParameter(request,	prefix + "cgo_wgt_use_flg", ""));
		setTsPortUseFlg(JSPUtil.getParameter(request,	prefix + "ts_port_use_flg", ""));
		setUsaSvcModCnt(JSPUtil.getParameter(request,	prefix + "usa_svc_mod_cnt", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setDelUseFlg(JSPUtil.getParameter(request,	prefix + "del_use_flg", ""));
		setGriCmdtCnt(JSPUtil.getParameter(request,	prefix + "gri_cmdt_cnt", ""));
		setTrnsModCnt(JSPUtil.getParameter(request,	prefix + "trns_mod_cnt", ""));
		setTrnsModUseFlg(JSPUtil.getParameter(request,	prefix + "trns_mod_use_flg", ""));
		setCnlTzCnt(JSPUtil.getParameter(request,	prefix + "cnl_tz_cnt", ""));
		setSubTrdUseFlg(JSPUtil.getParameter(request,	prefix + "sub_trd_use_flg", ""));
		setEsvcCnt(JSPUtil.getParameter(request,	prefix + "esvc_cnt", ""));
		setEsvcUseFlg(JSPUtil.getParameter(request,	prefix + "esvc_use_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScgPrfVO[]
	 */
	public PriScgPrfVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriScgPrfVO[]
	 */
	public PriScgPrfVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriScgPrfVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] tsPortCnt =	(JSPUtil.getParameter(request, prefix +	"ts_port_cnt",	length));
			String[] socUseFlg =	(JSPUtil.getParameter(request, prefix +	"soc_use_flg",	length));
			String[] socCnt =	(JSPUtil.getParameter(request, prefix +	"soc_cnt",	length));
			String[] tmlCnt =	(JSPUtil.getParameter(request, prefix +	"tml_cnt",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] subTrdCnt =	(JSPUtil.getParameter(request, prefix +	"sub_trd_cnt",	length));
			String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd",	length));
			String[] dirCallCnt =	(JSPUtil.getParameter(request, prefix +	"dir_call_cnt",	length));
			String[] cmdtCnt =	(JSPUtil.getParameter(request, prefix +	"cmdt_cnt",	length));
			String[] rcvDeTermUseFlg =	(JSPUtil.getParameter(request, prefix +	"rcv_de_term_use_flg",	length));
			String[] tmlUseFlg =	(JSPUtil.getParameter(request, prefix +	"tml_use_flg",	length));
			String[] porDefCnt =	(JSPUtil.getParameter(request, prefix +	"por_def_cnt",	length));
			String[] polUseFlg =	(JSPUtil.getParameter(request, prefix +	"pol_use_flg",	length));
			String[] vslSlanCnt =	(JSPUtil.getParameter(request, prefix +	"vsl_slan_cnt",	length));
			String[] rcvDeTermCnt =	(JSPUtil.getParameter(request, prefix +	"rcv_de_term_cnt",	length));
			String[] hngrBarUseFlg =	(JSPUtil.getParameter(request, prefix +	"hngr_bar_use_flg",	length));
			String[] hngrBarCnt =	(JSPUtil.getParameter(request, prefix +	"hngr_bar_cnt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] delDefCnt =	(JSPUtil.getParameter(request, prefix +	"del_def_cnt",	length));
			String[] fltPctTpCd =	(JSPUtil.getParameter(request, prefix +	"flt_pct_tp_cd",	length));
			String[] cmdtUseFlg =	(JSPUtil.getParameter(request, prefix +	"cmdt_use_flg",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] dirCallUseFlg =	(JSPUtil.getParameter(request, prefix +	"dir_call_use_flg",	length));
			String[] podDefCnt =	(JSPUtil.getParameter(request, prefix +	"pod_def_cnt",	length));
			String[] pctBseCd =	(JSPUtil.getParameter(request, prefix +	"pct_bse_cd",	length));
			String[] podUseFlg =	(JSPUtil.getParameter(request, prefix +	"pod_use_flg",	length));
			String[] porUseFlg =	(JSPUtil.getParameter(request, prefix +	"por_use_flg",	length));
			String[] cgoWgtCnt =	(JSPUtil.getParameter(request, prefix +	"cgo_wgt_cnt",	length));
			String[] ioGaUseFlg =	(JSPUtil.getParameter(request, prefix +	"io_ga_use_flg",	length));
			String[] imdgClssUseFlg =	(JSPUtil.getParameter(request, prefix +	"imdg_clss_use_flg",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] cnlTzFlg =	(JSPUtil.getParameter(request, prefix +	"cnl_tz_flg",	length));
			String[] igGaCnt =	(JSPUtil.getParameter(request, prefix +	"ig_ga_cnt",	length));
			String[] usaSvcModUseFlg =	(JSPUtil.getParameter(request, prefix +	"usa_svc_mod_use_flg",	length));
			String[] griCmdtUseFlg =	(JSPUtil.getParameter(request, prefix +	"gri_cmdt_use_flg",	length));
			String[] scgImdgClssCnt =	(JSPUtil.getParameter(request, prefix +	"scg_imdg_clss_cnt",	length));
			String[] slanUseFlg =	(JSPUtil.getParameter(request, prefix +	"slan_use_flg",	length));
			String[] polDefCnt =	(JSPUtil.getParameter(request, prefix +	"pol_def_cnt",	length));
			String[] cgoWgtUseFlg =	(JSPUtil.getParameter(request, prefix +	"cgo_wgt_use_flg",	length));
			String[] tsPortUseFlg =	(JSPUtil.getParameter(request, prefix +	"ts_port_use_flg",	length));
			String[] usaSvcModCnt =	(JSPUtil.getParameter(request, prefix +	"usa_svc_mod_cnt",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			String[] delUseFlg =	(JSPUtil.getParameter(request, prefix +	"del_use_flg",	length));
			String[] griCmdtCnt =	(JSPUtil.getParameter(request, prefix +	"gri_cmdt_cnt",	length));
			String[] trnsModCnt =	(JSPUtil.getParameter(request, prefix +	"trns_mod_cnt",	length));
			String[] trnsModUseFlg =	(JSPUtil.getParameter(request, prefix +	"trns_mod_use_flg",	length));
			String[] cnlTzCnt =	(JSPUtil.getParameter(request, prefix +	"cnl_tz_cnt",	length));
			String[] subTrdUseFlg =	(JSPUtil.getParameter(request, prefix +	"sub_trd_use_flg",	length));
			String[] esvcCnt =	(JSPUtil.getParameter(request, prefix +	"esvc_cnt",	length));
			String[] esvcUseFlg =	(JSPUtil.getParameter(request, prefix +	"esvc_use_flg",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriScgPrfVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( tsPortCnt[i] !=	null)
					model.setTsPortCnt( tsPortCnt[i]);
				if ( socUseFlg[i] !=	null)
					model.setSocUseFlg( socUseFlg[i]);
				if ( socCnt[i] !=	null)
					model.setSocCnt( socCnt[i]);
				if ( tmlCnt[i] !=	null)
					model.setTmlCnt( tmlCnt[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( subTrdCnt[i] !=	null)
					model.setSubTrdCnt( subTrdCnt[i]);
				if ( chgCd[i] !=	null)
					model.setChgCd( chgCd[i]);
				if ( dirCallCnt[i] !=	null)
					model.setDirCallCnt( dirCallCnt[i]);
				if ( cmdtCnt[i] !=	null)
					model.setCmdtCnt( cmdtCnt[i]);
				if ( rcvDeTermUseFlg[i] !=	null)
					model.setRcvDeTermUseFlg( rcvDeTermUseFlg[i]);
				if ( tmlUseFlg[i] !=	null)
					model.setTmlUseFlg( tmlUseFlg[i]);
				if ( porDefCnt[i] !=	null)
					model.setPorDefCnt( porDefCnt[i]);
				if ( polUseFlg[i] !=	null)
					model.setPolUseFlg( polUseFlg[i]);
				if ( vslSlanCnt[i] !=	null)
					model.setVslSlanCnt( vslSlanCnt[i]);
				if ( rcvDeTermCnt[i] !=	null)
					model.setRcvDeTermCnt( rcvDeTermCnt[i]);
				if ( hngrBarUseFlg[i] !=	null)
					model.setHngrBarUseFlg( hngrBarUseFlg[i]);
				if ( hngrBarCnt[i] !=	null)
					model.setHngrBarCnt( hngrBarCnt[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( delDefCnt[i] !=	null)
					model.setDelDefCnt( delDefCnt[i]);
				if ( fltPctTpCd[i] !=	null)
					model.setFltPctTpCd( fltPctTpCd[i]);
				if ( cmdtUseFlg[i] !=	null)
					model.setCmdtUseFlg( cmdtUseFlg[i]);
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( dirCallUseFlg[i] !=	null)
					model.setDirCallUseFlg( dirCallUseFlg[i]);
				if ( podDefCnt[i] !=	null)
					model.setPodDefCnt( podDefCnt[i]);
				if ( pctBseCd[i] !=	null)
					model.setPctBseCd( pctBseCd[i]);
				if ( podUseFlg[i] !=	null)
					model.setPodUseFlg( podUseFlg[i]);
				if ( porUseFlg[i] !=	null)
					model.setPorUseFlg( porUseFlg[i]);
				if ( cgoWgtCnt[i] !=	null)
					model.setCgoWgtCnt( cgoWgtCnt[i]);
				if ( ioGaUseFlg[i] !=	null)
					model.setIoGaUseFlg( ioGaUseFlg[i]);
				if ( imdgClssUseFlg[i] !=	null)
					model.setImdgClssUseFlg( imdgClssUseFlg[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( cnlTzFlg[i] !=	null)
					model.setCnlTzFlg( cnlTzFlg[i]);
				if ( igGaCnt[i] !=	null)
					model.setIgGaCnt( igGaCnt[i]);
				if ( usaSvcModUseFlg[i] !=	null)
					model.setUsaSvcModUseFlg( usaSvcModUseFlg[i]);
				if ( griCmdtUseFlg[i] !=	null)
					model.setGriCmdtUseFlg( griCmdtUseFlg[i]);
				if ( scgImdgClssCnt[i] !=	null)
					model.setScgImdgClssCnt( scgImdgClssCnt[i]);
				if ( slanUseFlg[i] !=	null)
					model.setSlanUseFlg( slanUseFlg[i]);
				if ( polDefCnt[i] !=	null)
					model.setPolDefCnt( polDefCnt[i]);
				if ( cgoWgtUseFlg[i] !=	null)
					model.setCgoWgtUseFlg( cgoWgtUseFlg[i]);
				if ( tsPortUseFlg[i] !=	null)
					model.setTsPortUseFlg( tsPortUseFlg[i]);
				if ( usaSvcModCnt[i] !=	null)
					model.setUsaSvcModCnt( usaSvcModCnt[i]);
				if ( updDt[i] !=	null)
					model.setUpdDt( updDt[i]);
				if ( delUseFlg[i] !=	null)
					model.setDelUseFlg( delUseFlg[i]);
				if ( griCmdtCnt[i] !=	null)
					model.setGriCmdtCnt( griCmdtCnt[i]);
				if ( trnsModCnt[i] !=	null)
					model.setTrnsModCnt( trnsModCnt[i]);
				if ( trnsModUseFlg[i] !=	null)
					model.setTrnsModUseFlg( trnsModUseFlg[i]);
				if ( cnlTzCnt[i] !=	null)
					model.setCnlTzCnt( cnlTzCnt[i]);
				if ( subTrdUseFlg[i] !=	null)
					model.setSubTrdUseFlg( subTrdUseFlg[i]);
				if ( esvcCnt[i] !=	null)
					model.setEsvcCnt( esvcCnt[i]);
				if ( esvcUseFlg[i] !=	null)
					model.setEsvcUseFlg( esvcUseFlg[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriScgPrfVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriScgPrfVO[]
	 */
	public PriScgPrfVO[]	 getPriScgPrfVOs(){
		PriScgPrfVO[] vos = (PriScgPrfVO[])models.toArray(new	PriScgPrfVO[models.size()]);
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
		this.tsPortCnt =	this.tsPortCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socUseFlg =	this.socUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socCnt =	this.socCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCnt =	this.tmlCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCnt =	this.subTrdCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallCnt =	this.dirCallCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCnt =	this.cmdtCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermUseFlg =	this.rcvDeTermUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlUseFlg =	this.tmlUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCnt =	this.porDefCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polUseFlg =	this.polUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCnt =	this.vslSlanCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCnt =	this.rcvDeTermCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarUseFlg =	this.hngrBarUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarCnt =	this.hngrBarCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCnt =	this.delDefCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltPctTpCd =	this.fltPctTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtUseFlg =	this.cmdtUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallUseFlg =	this.dirCallUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCnt =	this.podDefCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctBseCd =	this.pctBseCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podUseFlg =	this.podUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porUseFlg =	this.porUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtCnt =	this.cgoWgtCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioGaUseFlg =	this.ioGaUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssUseFlg =	this.imdgClssUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzFlg =	this.cnlTzFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.igGaCnt =	this.igGaCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModUseFlg =	this.usaSvcModUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griCmdtUseFlg =	this.griCmdtUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgImdgClssCnt =	this.scgImdgClssCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanUseFlg =	this.slanUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCnt =	this.polDefCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtUseFlg =	this.cgoWgtUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortUseFlg =	this.tsPortUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModCnt =	this.usaSvcModCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delUseFlg =	this.delUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griCmdtCnt =	this.griCmdtCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsModCnt =	this.trnsModCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsModUseFlg =	this.trnsModUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzCnt =	this.cnlTzCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdUseFlg =	this.subTrdUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcCnt =	this.esvcCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcUseFlg =	this.esvcUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}