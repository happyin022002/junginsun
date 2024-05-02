/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCommonConditionVO.java
*@FileTitle : EesCommonConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.30 정은호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.common.eqrcommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesCommonConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesCommonConditionVO> models = new ArrayList<EesCommonConditionVO>();
	
	/* Column Info */
	private String podPod = null;
	/* Column Info */
	private String weekperiodSearchword = null;
	/* Column Info */
	private String podColname = null;
	/* Column Info */
	private String locyardinitialEcc = null;
	/* Column Info */
	private String podPol = null;
	/* Column Info */
	private String toYyyy = null;
	/* Column Info */
	private String vvdinlandRow = null;
	/* Column Info */
	private String vvdexistDivision = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podRow = null;
	/* Column Info */
	private String vvdexistRow = null;
	/* Column Info */
	private String locyardinitialRow = null;
	/* Column Info */
	private String vvdinlandEtaweek = null;
	/* Column Info */
	private String searchetaSearchword = null;
	/* Column Info */
	private String vvdexistScnrid = null;
	/* Column Info */
	private String loccodeRow = null;
	/* Column Info */
	private String podFixed = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String checkweek = null;
	/* Column Info */
	private String podLane = null;
	/* Column Info */
	private String frWeek = null;
	/* Column Info */
	private String weeklyRow = null;
	/* Column Info */
	private String searchetaRow = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String atYrwk = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vendorColname = null;
	/* Column Info */
	private String etdDtColname = null;
	/* Column Info */
	private String locyardinitialColname = null;
	/* Column Info */
	private String locyardexistEcc = null;
	/* Column Info */
	private String vvdexistPlnyrwk = null;
	/* Column Info */
	private String searchetaFryard = null;
	/* Column Info */
	private String locyardexistLocyard = null;
	/* Column Info */
	private String loccodeColname = null;
	/* Column Info */
	private String gapmonth = null;
	/* Column Info */
	private String podRepoPlnId = null;
	/* Column Info */
	private String mlocCd = null;
	/* Column Info */
	private String weeklySearchword = null;
	/* Column Info */
	private String locyardEcc = null;
	/* Column Info */
	private String vvdexistEcccd = null;
	/* Column Info */
	private String vvdRow = null;
	/* Column Info */
	private String toWk = null;
	/* Column Info */
	private String vvdinlandFmecc = null;
	/* Column Info */
	private String vvdexistRepoplnid = null;
	/* Column Info */
	private String podVvd = null;
	/* Column Info */
	private String locyardRow = null;
	/* Column Info */
	private String vvdinlandToecc = null;
	/* Column Info */
	private String searchetaColname = null;
	/* Column Info */
	private String vendorSearchword = null;
	/* Column Info */
	private String locyardexistColname = null;
	/* Column Info */
	private String locyardexistcompanyColname = null;
	/* Column Info */
	private String vvdPlnyrwk = null;
	/* Column Info */
	private String locyardVndrSeq = null;
	/* Column Info */
	private String podWk = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String toYrwk = null;
	/* Column Info */
	private String editmonth = null;
	/* Column Info */
	private String locyardColname1 = null;
	/* Column Info */
	private String fmyr = null;
	/* Column Info */
	private String weekperiodColname2 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String col = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String weekperiodColname1 = null;
	/* Column Info */
	private String locyardColname = null;
	/* Column Info */
	private String vvdexistColname = null;
	/* Column Info */
	private String weekperiodRow = null;
	/* Column Info */
	private String vvdColname = null;
	/* Column Info */
	private String locyardSearchword = null;
	/* Column Info */
	private String weeklySavename = null;
	/* Column Info */
	private String locyardexistRow = null;
	/* Column Info */
	private String searchetaToyard = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String locyardexistcompanyEcc = null;
	/* Column Info */
	private String tmp = null;
	/* Column Info */
	private String locyardinitialVsl = null;
	/* Column Info */
	private String vslPortCd = null;
	/* Column Info */
	private String locyardexistcompanyLocyard = null;
	/* Column Info */
	private String vvdSearchword = null;
	/* Column Info */
	private String country = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String plnyrwk = null;
	/* Column Info */
	private String searchetaItem = null;
	/* Column Info */
	private String fmwk = null;
	/* Column Info */
	private String locyardDivCd = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String locyardinitialItem = null;
	/* Column Info */
	private String vvdinlandColname = null;
	/* Column Info */
	private String vendorRow = null;
	/* Column Info */
	private String ecccd = null;
	/* Column Info */
	private String localdate = null;
	/* Column Info */
	private String weekperiodDivision = null;
	/* Column Info */
	private String fmYrwk = null;
	/* Column Info */
	private String etbDtColname = null;
	/* Column Info */
	private String fmWk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locyardexistcompanyRow = null;
	/* Column Info */
	private String toWeek = null;
	/* Column Info */
	private String etaDtColname = null;
	/* Column Info */
	private String podEtd = null;
	/* Column Info */
	private String vvdRepoplanid = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String vvdexistColname1 = null;
	/* Column Info */
	private String vvdexistSearchword = null;
	/* Column Info */
	private String mtype = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String frYyyy = null;
	/* Column Info */
	private String seqSearchword = null;
	/* Column Info */
	private String seqRow = null;
	/* Column Info */
	private String podEta = null;
	/* Column Info */
	private String fmYr = null;
	/* Column Info  EES_VESSEL_SKD_CHECK 에서 반환하는 YdCd Column name  */
	private String YdCdColname = null;
	/*	Column Info	*/
	private  String	 fmContiCd   =  null;
	/*	Column Info	*/
	private  String	 toContiCd   =  null;
	/*	Column Info	*/
	private  String	 exectype   =  null;
	
	/* Column Info */
	private String locfmyardSearchword = null;
	/* Column Info */
	private String loctoyardSearchword = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesCommonConditionVO() {}

	public EesCommonConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String localdate, String tmp, String ecccd, String row, String col, String loccodeRow, String loccodeColname, String locCd, String type, String temp, String mlocCd, String mtype, String locyardRow, String locyardColname, String locyardColname1, String locyardSearchword, String locyardEcc, String locyardDivCd, String locyardVndrSeq, String locyardexistRow, String locyardexistColname, String locyardexistLocyard, String locyardexistEcc, String locyardexistcompanyRow, String locyardexistcompanyColname, String locyardexistcompanyLocyard, String locyardexistcompanyEcc, String locyardinitialRow, String locyardinitialColname, String locyardinitialEcc, String locyardinitialVsl, String locyardinitialItem, String vendorRow, String vendorColname, String vendorSearchword, String seqRow, String seqSearchword, String vvdRow, String vvdColname, String vvdSearchword, String vvdRepoplanid, String vvdPlnyrwk, String vvdinlandRow, String vvdinlandColname, String vvdinlandFmecc, String vvdinlandToecc, String vvdinlandEtaweek, String vvdexistRow, String vvdexistColname, String vvdexistColname1, String vvdexistSearchword, String vvdexistDivision, String vvdexistRepoplnid, String vvdexistEcccd, String vvdexistPlnyrwk, String vvdexistScnrid, String country, String scnrId, String plnyrwk, String frYyyy, String frWeek, String toYyyy, String toWeek, String gapmonth, String checkweek, String gubun, String fmyr, String fmwk, String editmonth, String fmYrwk, String toYrwk, String atYrwk, String weeklySearchword, String weeklyRow, String weeklySavename, String weekperiodRow, String weekperiodColname1, String weekperiodColname2, String weekperiodSearchword, String weekperiodDivision, String searchetaRow, String searchetaColname, String searchetaSearchword, String searchetaFryard, String searchetaToyard, String searchetaItem, String podRepoPlnId, String podRow, String podColname, String podWk, String podFixed, String podLane, String podVvd, String podPol, String podEtd, String podPod, String podEta, String vslCd, String skdVoyNo, String skdDirCd, String vslPortCd, String fmWk, String toWk, String slanCd, String etaDtColname, String etbDtColname, String etdDtColname, String vvd, String locfmyardSearchword, String loctoyardSearchword,String fmContiCd,String toContiCd,String exectype) {
		this.podPod = podPod;
		this.weekperiodSearchword = weekperiodSearchword;
		this.podColname = podColname;
		this.locyardinitialEcc = locyardinitialEcc;
		this.podPol = podPol;
		this.toYyyy = toYyyy;
		this.vvdinlandRow = vvdinlandRow;
		this.vvdexistDivision = vvdexistDivision;
		this.pagerows = pagerows;
		this.podRow = podRow;
		this.vvdexistRow = vvdexistRow;
		this.locyardinitialRow = locyardinitialRow;
		this.vvdinlandEtaweek = vvdinlandEtaweek;
		this.searchetaSearchword = searchetaSearchword;
		this.vvdexistScnrid = vvdexistScnrid;
		this.loccodeRow = loccodeRow;
		this.podFixed = podFixed;
		this.skdVoyNo = skdVoyNo;
		this.checkweek = checkweek;
		this.podLane = podLane;
		this.frWeek = frWeek;
		this.weeklyRow = weeklyRow;
		this.searchetaRow = searchetaRow;
		this.temp = temp;
		this.atYrwk = atYrwk;
		this.locCd = locCd;
		this.vendorColname = vendorColname;
		this.etdDtColname = etdDtColname;
		this.locyardinitialColname = locyardinitialColname;
		this.locyardexistEcc = locyardexistEcc;
		this.vvdexistPlnyrwk = vvdexistPlnyrwk;
		this.searchetaFryard = searchetaFryard;
		this.locyardexistLocyard = locyardexistLocyard;
		this.loccodeColname = loccodeColname;
		this.gapmonth = gapmonth;
		this.podRepoPlnId = podRepoPlnId;
		this.mlocCd = mlocCd;
		this.weeklySearchword = weeklySearchword;
		this.locyardEcc = locyardEcc;
		this.vvdexistEcccd = vvdexistEcccd;
		this.vvdRow = vvdRow;
		this.toWk = toWk;
		this.vvdinlandFmecc = vvdinlandFmecc;
		this.vvdexistRepoplnid = vvdexistRepoplnid;
		this.podVvd = podVvd;
		this.locyardRow = locyardRow;
		this.vvdinlandToecc = vvdinlandToecc;
		this.searchetaColname = searchetaColname;
		this.vendorSearchword = vendorSearchword;
		this.locyardexistColname = locyardexistColname;
		this.locyardexistcompanyColname = locyardexistcompanyColname;
		this.vvdPlnyrwk = vvdPlnyrwk;
		this.locyardVndrSeq = locyardVndrSeq;
		this.podWk = podWk;
		this.yyyyww = yyyyww;
		this.slanCd = slanCd;
		this.toYrwk = toYrwk;
		this.editmonth = editmonth;
		this.locyardColname1 = locyardColname1;
		this.fmyr = fmyr;
		this.weekperiodColname2 = weekperiodColname2;
		this.vslCd = vslCd;
		this.col = col;
		this.gubun = gubun;
		this.weekperiodColname1 = weekperiodColname1;
		this.locyardColname = locyardColname;
		this.vvdexistColname = vvdexistColname;
		this.weekperiodRow = weekperiodRow;
		this.vvdColname = vvdColname;
		this.locyardSearchword = locyardSearchword;
		this.weeklySavename = weeklySavename;
		this.locyardexistRow = locyardexistRow;
		this.searchetaToyard = searchetaToyard;
		this.type = type;
		this.locyardexistcompanyEcc = locyardexistcompanyEcc;
		this.tmp = tmp;
		this.locyardinitialVsl = locyardinitialVsl;
		this.vslPortCd = vslPortCd;
		this.locyardexistcompanyLocyard = locyardexistcompanyLocyard;
		this.vvdSearchword = vvdSearchword;
		this.country = country;
		this.vvd = vvd;
		this.plnyrwk = plnyrwk;
		this.searchetaItem = searchetaItem;
		this.fmwk = fmwk;
		this.locyardDivCd = locyardDivCd;
		this.scnrId = scnrId;
		this.locyardinitialItem = locyardinitialItem;
		this.vvdinlandColname = vvdinlandColname;
		this.vendorRow = vendorRow;
		this.ecccd = ecccd;
		this.localdate = localdate;
		this.weekperiodDivision = weekperiodDivision;
		this.fmYrwk = fmYrwk;
		this.etbDtColname = etbDtColname;
		this.fmWk = fmWk;
		this.ibflag = ibflag;
		this.locyardexistcompanyRow = locyardexistcompanyRow;
		this.toWeek = toWeek;
		this.etaDtColname = etaDtColname;
		this.podEtd = podEtd;
		this.vvdRepoplanid = vvdRepoplanid;
		this.row = row;
		this.vvdexistColname1 = vvdexistColname1;
		this.vvdexistSearchword = vvdexistSearchword;
		this.mtype = mtype;
		this.skdDirCd = skdDirCd;
		this.seq = seq;
		this.frYyyy = frYyyy;
		this.seqSearchword = seqSearchword;
		this.seqRow = seqRow;
		this.podEta = podEta;
		this.locfmyardSearchword = locfmyardSearchword;
		this.loctoyardSearchword = loctoyardSearchword;
		this.fmContiCd  = fmContiCd ;
		this.toContiCd  = toContiCd ;
		this.exectype  = exectype ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_pod", getPodPod());
		this.hashColumns.put("weekperiod_searchword", getWeekperiodSearchword());
		this.hashColumns.put("pod_colname", getPodColname());
		this.hashColumns.put("locyardinitial_ecc", getLocyardinitialEcc());
		this.hashColumns.put("pod_pol", getPodPol());
		this.hashColumns.put("to_yyyy", getToYyyy());
		this.hashColumns.put("vvdinland_row", getVvdinlandRow());
		this.hashColumns.put("vvdexist_division", getVvdexistDivision());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_row", getPodRow());
		this.hashColumns.put("vvdexist_row", getVvdexistRow());
		this.hashColumns.put("locyardinitial_row", getLocyardinitialRow());
		this.hashColumns.put("vvdinland_etaweek", getVvdinlandEtaweek());
		this.hashColumns.put("searcheta_searchword", getSearchetaSearchword());
		this.hashColumns.put("vvdexist_scnrid", getVvdexistScnrid());
		this.hashColumns.put("loccode_row", getLoccodeRow());
		this.hashColumns.put("pod_fixed", getPodFixed());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("checkweek", getCheckweek());
		this.hashColumns.put("pod_lane", getPodLane());
		this.hashColumns.put("fr_week", getFrWeek());
		this.hashColumns.put("weekly_row", getWeeklyRow());
		this.hashColumns.put("searcheta_row", getSearchetaRow());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("at_yrwk", getAtYrwk());
		this.hashColumns.put("locCd", getLocCd());
		this.hashColumns.put("vendor_colname", getVendorColname());
		this.hashColumns.put("etd_dt_colname", getEtdDtColname());
		this.hashColumns.put("locyardinitial_colname", getLocyardinitialColname());
		this.hashColumns.put("locyardexist_ecc", getLocyardexistEcc());
		this.hashColumns.put("vvdexist_plnyrwk", getVvdexistPlnyrwk());
		this.hashColumns.put("searcheta_fryard", getSearchetaFryard());
		this.hashColumns.put("locyardexist_locyard", getLocyardexistLocyard());
		this.hashColumns.put("loccode_colname", getLoccodeColname());
		this.hashColumns.put("gapmonth", getGapmonth());
		this.hashColumns.put("pod_repo_pln_id", getPodRepoPlnId());
		this.hashColumns.put("mlocCd", getMlocCd());
		this.hashColumns.put("weekly_searchword", getWeeklySearchword());
		this.hashColumns.put("locyard_ecc", getLocyardEcc());
		this.hashColumns.put("vvdexist_ecccd", getVvdexistEcccd());
		this.hashColumns.put("vvd_row", getVvdRow());
		this.hashColumns.put("to_wk", getToWk());
		this.hashColumns.put("vvdinland_fmecc", getVvdinlandFmecc());
		this.hashColumns.put("vvdexist_repoplnid", getVvdexistRepoplnid());
		this.hashColumns.put("pod_vvd", getPodVvd());
		this.hashColumns.put("locyard_row", getLocyardRow());
		this.hashColumns.put("vvdinland_toecc", getVvdinlandToecc());
		this.hashColumns.put("searcheta_colname", getSearchetaColname());
		this.hashColumns.put("vendor_searchword", getVendorSearchword());
		this.hashColumns.put("locyardexist_colname", getLocyardexistColname());
		this.hashColumns.put("locyardexistcompany_colname", getLocyardexistcompanyColname());
		this.hashColumns.put("vvd_plnyrwk", getVvdPlnyrwk());
		this.hashColumns.put("locyard_vndr_seq", getLocyardVndrSeq());
		this.hashColumns.put("pod_wk", getPodWk());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("to_yrwk", getToYrwk());
		this.hashColumns.put("editmonth", getEditmonth());
		this.hashColumns.put("locyard_colname1", getLocyardColname1());
		this.hashColumns.put("fmyr", getFmyr());
		this.hashColumns.put("weekperiod_colname2", getWeekperiodColname2());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("col", getCol());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("weekperiod_colname1", getWeekperiodColname1());
		this.hashColumns.put("locyard_colname", getLocyardColname());
		this.hashColumns.put("vvdexist_colname", getVvdexistColname());
		this.hashColumns.put("weekperiod_row", getWeekperiodRow());
		this.hashColumns.put("vvd_colname", getVvdColname());
		this.hashColumns.put("locyard_searchword", getLocyardSearchword());
		this.hashColumns.put("weekly_savename", getWeeklySavename());
		this.hashColumns.put("locyardexist_row", getLocyardexistRow());
		this.hashColumns.put("searcheta_toyard", getSearchetaToyard());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("locyardexistcompany_ecc", getLocyardexistcompanyEcc());
		this.hashColumns.put("tmp", getTmp());
		this.hashColumns.put("locyardinitial_vsl", getLocyardinitialVsl());
		this.hashColumns.put("vsl_port_cd", getVslPortCd());
		this.hashColumns.put("locyardexistcompany_locyard", getLocyardexistcompanyLocyard());
		this.hashColumns.put("vvd_searchword", getVvdSearchword());
		this.hashColumns.put("country", getCountry());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("plnyrwk", getPlnyrwk());
		this.hashColumns.put("searcheta_item", getSearchetaItem());
		this.hashColumns.put("fmwk", getFmwk());
		this.hashColumns.put("locyard_div_cd", getLocyardDivCd());
		this.hashColumns.put("scnrId", getScnrId());
		this.hashColumns.put("locyardinitial_item", getLocyardinitialItem());
		this.hashColumns.put("vvdinland_colname", getVvdinlandColname());
		this.hashColumns.put("vendor_row", getVendorRow());
		this.hashColumns.put("ecccd", getEcccd());
		this.hashColumns.put("localdate", getLocaldate());
		this.hashColumns.put("weekperiod_division", getWeekperiodDivision());
		this.hashColumns.put("fm_yrwk", getFmYrwk());
		this.hashColumns.put("etb_dt_colname", getEtbDtColname());
		this.hashColumns.put("fm_wk", getFmWk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("locyardexistcompany_row", getLocyardexistcompanyRow());
		this.hashColumns.put("to_week", getToWeek());
		this.hashColumns.put("eta_dt_colname", getEtaDtColname());
		this.hashColumns.put("pod_etd", getPodEtd());
		this.hashColumns.put("vvd_repoplanid", getVvdRepoplanid());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("vvdexist_colname1", getVvdexistColname1());
		this.hashColumns.put("vvdexist_searchword", getVvdexistSearchword());
		this.hashColumns.put("mtype", getMtype());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fr_yyyy", getFrYyyy());
		this.hashColumns.put("seq_searchword", getSeqSearchword());
		this.hashColumns.put("seq_row", getSeqRow());
		this.hashColumns.put("pod_eta", getPodEta());
		this.hashColumns.put("fm_yr", getFmYr());
		this.hashColumns.put("locfmyard_searchword", getLocFmyardSearchword());
		this.hashColumns.put("loctoyard_searchword", getLocToyardSearchword());
		this.hashColumns.put("fm_conti_cd", getFmContiCd());
		this.hashColumns.put("to_conti_cd", getToContiCd());
		this.hashColumns.put("exectype", getExectype());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_pod", "podPod");
		this.hashFields.put("weekperiod_searchword", "weekperiodSearchword");
		this.hashFields.put("pod_colname", "podColname");
		this.hashFields.put("locyardinitial_ecc", "locyardinitialEcc");
		this.hashFields.put("pod_pol", "podPol");
		this.hashFields.put("to_yyyy", "toYyyy");
		this.hashFields.put("vvdinland_row", "vvdinlandRow");
		this.hashFields.put("vvdexist_division", "vvdexistDivision");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_row", "podRow");
		this.hashFields.put("vvdexist_row", "vvdexistRow");
		this.hashFields.put("locyardinitial_row", "locyardinitialRow");
		this.hashFields.put("vvdinland_etaweek", "vvdinlandEtaweek");
		this.hashFields.put("searcheta_searchword", "searchetaSearchword");
		this.hashFields.put("vvdexist_scnrid", "vvdexistScnrid");
		this.hashFields.put("loccode_row", "loccodeRow");
		this.hashFields.put("pod_fixed", "podFixed");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("checkweek", "checkweek");
		this.hashFields.put("pod_lane", "podLane");
		this.hashFields.put("fr_week", "frWeek");
		this.hashFields.put("weekly_row", "weeklyRow");
		this.hashFields.put("searcheta_row", "searchetaRow");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("at_yrwk", "atYrwk");
		this.hashFields.put("locCd", "locCd");
		this.hashFields.put("vendor_colname", "vendorColname");
		this.hashFields.put("etd_dt_colname", "etdDtColname");
		this.hashFields.put("locyardinitial_colname", "locyardinitialColname");
		this.hashFields.put("locyardexist_ecc", "locyardexistEcc");
		this.hashFields.put("vvdexist_plnyrwk", "vvdexistPlnyrwk");
		this.hashFields.put("searcheta_fryard", "searchetaFryard");
		this.hashFields.put("locyardexist_locyard", "locyardexistLocyard");
		this.hashFields.put("loccode_colname", "loccodeColname");
		this.hashFields.put("gapmonth", "gapmonth");
		this.hashFields.put("pod_repo_pln_id", "podRepoPlnId");
		this.hashFields.put("mlocCd", "mlocCd");
		this.hashFields.put("weekly_searchword", "weeklySearchword");
		this.hashFields.put("locyard_ecc", "locyardEcc");
		this.hashFields.put("vvdexist_ecccd", "vvdexistEcccd");
		this.hashFields.put("vvd_row", "vvdRow");
		this.hashFields.put("to_wk", "toWk");
		this.hashFields.put("vvdinland_fmecc", "vvdinlandFmecc");
		this.hashFields.put("vvdexist_repoplnid", "vvdexistRepoplnid");
		this.hashFields.put("pod_vvd", "podVvd");
		this.hashFields.put("locyard_row", "locyardRow");
		this.hashFields.put("vvdinland_toecc", "vvdinlandToecc");
		this.hashFields.put("searcheta_colname", "searchetaColname");
		this.hashFields.put("vendor_searchword", "vendorSearchword");
		this.hashFields.put("locyardexist_colname", "locyardexistColname");
		this.hashFields.put("locyardexistcompany_colname", "locyardexistcompanyColname");
		this.hashFields.put("vvd_plnyrwk", "vvdPlnyrwk");
		this.hashFields.put("locyard_vndr_seq", "locyardVndrSeq");
		this.hashFields.put("pod_wk", "podWk");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("to_yrwk", "toYrwk");
		this.hashFields.put("editmonth", "editmonth");
		this.hashFields.put("locyard_colname1", "locyardColname1");
		this.hashFields.put("fmyr", "fmyr");
		this.hashFields.put("weekperiod_colname2", "weekperiodColname2");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("col", "col");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("weekperiod_colname1", "weekperiodColname1");
		this.hashFields.put("locyard_colname", "locyardColname");
		this.hashFields.put("vvdexist_colname", "vvdexistColname");
		this.hashFields.put("weekperiod_row", "weekperiodRow");
		this.hashFields.put("vvd_colname", "vvdColname");
		this.hashFields.put("locyard_searchword", "locyardSearchword");
		this.hashFields.put("weekly_savename", "weeklySavename");
		this.hashFields.put("locyardexist_row", "locyardexistRow");
		this.hashFields.put("searcheta_toyard", "searchetaToyard");
		this.hashFields.put("type", "type");
		this.hashFields.put("locyardexistcompany_ecc", "locyardexistcompanyEcc");
		this.hashFields.put("tmp", "tmp");
		this.hashFields.put("locyardinitial_vsl", "locyardinitialVsl");
		this.hashFields.put("vsl_port_cd", "vslPortCd");
		this.hashFields.put("locyardexistcompany_locyard", "locyardexistcompanyLocyard");
		this.hashFields.put("vvd_searchword", "vvdSearchword");
		this.hashFields.put("country", "country");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("plnyrwk", "plnyrwk");
		this.hashFields.put("searcheta_item", "searchetaItem");
		this.hashFields.put("fmwk", "fmwk");
		this.hashFields.put("locyard_div_cd", "locyardDivCd");
		this.hashFields.put("scnrId", "scnrId");
		this.hashFields.put("locyardinitial_item", "locyardinitialItem");
		this.hashFields.put("vvdinland_colname", "vvdinlandColname");
		this.hashFields.put("vendor_row", "vendorRow");
		this.hashFields.put("ecccd", "ecccd");
		this.hashFields.put("localdate", "localdate");
		this.hashFields.put("weekperiod_division", "weekperiodDivision");
		this.hashFields.put("fm_yrwk", "fmYrwk");
		this.hashFields.put("etb_dt_colname", "etbDtColname");
		this.hashFields.put("fm_wk", "fmWk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("locyardexistcompany_row", "locyardexistcompanyRow");
		this.hashFields.put("to_week", "toWeek");
		this.hashFields.put("eta_dt_colname", "etaDtColname");
		this.hashFields.put("pod_etd", "podEtd");
		this.hashFields.put("vvd_repoplanid", "vvdRepoplanid");
		this.hashFields.put("row", "row");
		this.hashFields.put("vvdexist_colname1", "vvdexistColname1");
		this.hashFields.put("vvdexist_searchword", "vvdexistSearchword");
		this.hashFields.put("mtype", "mtype");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("fr_yyyy", "frYyyy");
		this.hashFields.put("seq_searchword", "seqSearchword");
		this.hashFields.put("seq_row", "seqRow");
		this.hashFields.put("pod_eta", "podEta");
		this.hashFields.put("fm_yr", "fmYr");
		this.hashFields.put("locfmyard_searchword", "locfmyardSearchword");
		this.hashFields.put("loctoyard_searchword", "loctoyardSearchword");
		this.hashFields.put("fm_conti_cd", "fmContiCd");
		this.hashFields.put("to_conti_cd", "toContiCd");
		this.hashFields.put("exectype", "exectype");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podPod
	 */
	public String getPodPod() {
		return this.podPod;
	}
	
	/**
	 * Column Info
	 * @return weekperiodSearchword
	 */
	public String getWeekperiodSearchword() {
		return this.weekperiodSearchword;
	}
	
	/**
	 * Column Info
	 * @return podColname
	 */
	public String getPodColname() {
		return this.podColname;
	}
	
	/**
	 * Column Info
	 * @return locyardinitialEcc
	 */
	public String getLocyardinitialEcc() {
		return this.locyardinitialEcc;
	}
	
	/**
	 * Column Info
	 * @return podPol
	 */
	public String getPodPol() {
		return this.podPol;
	}
	
	/**
	 * Column Info
	 * @return toYyyy
	 */
	public String getToYyyy() {
		return this.toYyyy;
	}
	
	/**
	 * Column Info
	 * @return vvdinlandRow
	 */
	public String getVvdinlandRow() {
		return this.vvdinlandRow;
	}
	
	/**
	 * Column Info
	 * @return vvdexistDivision
	 */
	public String getVvdexistDivision() {
		return this.vvdexistDivision;
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
	 * @return podRow
	 */
	public String getPodRow() {
		return this.podRow;
	}
	
	/**
	 * Column Info
	 * @return vvdexistRow
	 */
	public String getVvdexistRow() {
		return this.vvdexistRow;
	}
	
	/**
	 * Column Info
	 * @return locyardinitialRow
	 */
	public String getLocyardinitialRow() {
		return this.locyardinitialRow;
	}
	
	/**
	 * Column Info
	 * @return vvdinlandEtaweek
	 */
	public String getVvdinlandEtaweek() {
		return this.vvdinlandEtaweek;
	}
	
	/**
	 * Column Info
	 * @return searchetaSearchword
	 */
	public String getSearchetaSearchword() {
		return this.searchetaSearchword;
	}
	
	/**
	 * Column Info
	 * @return vvdexistScnrid
	 */
	public String getVvdexistScnrid() {
		return this.vvdexistScnrid;
	}
	
	/**
	 * Column Info
	 * @return loccodeRow
	 */
	public String getLoccodeRow() {
		return this.loccodeRow;
	}
	
	/**
	 * Column Info
	 * @return podFixed
	 */
	public String getPodFixed() {
		return this.podFixed;
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
	 * @return checkweek
	 */
	public String getCheckweek() {
		return this.checkweek;
	}
	
	/**
	 * Column Info
	 * @return podLane
	 */
	public String getPodLane() {
		return this.podLane;
	}
	
	/**
	 * Column Info
	 * @return frWeek
	 */
	public String getFrWeek() {
		return this.frWeek;
	}
	
	/**
	 * Column Info
	 * @return weeklyRow
	 */
	public String getWeeklyRow() {
		return this.weeklyRow;
	}
	
	/**
	 * Column Info
	 * @return searchetaRow
	 */
	public String getSearchetaRow() {
		return this.searchetaRow;
	}
	
	/**
	 * Column Info
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
	}
	
	/**
	 * Column Info
	 * @return atYrwk
	 */
	public String getAtYrwk() {
		return this.atYrwk;
	}
	
	/**
	 * Column Info
	 * @return loccd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return vendorColname
	 */
	public String getVendorColname() {
		return this.vendorColname;
	}
	
	/**
	 * Column Info
	 * @return etdDtColname
	 */
	public String getEtdDtColname() {
		return this.etdDtColname;
	}
	
	/**
	 * Column Info
	 * @return locyardinitialColname
	 */
	public String getLocyardinitialColname() {
		return this.locyardinitialColname;
	}
	
	/**
	 * Column Info
	 * @return locyardexistEcc
	 */
	public String getLocyardexistEcc() {
		return this.locyardexistEcc;
	}
	
	/**
	 * Column Info
	 * @return vvdexistPlnyrwk
	 */
	public String getVvdexistPlnyrwk() {
		return this.vvdexistPlnyrwk;
	}
	
	/**
	 * Column Info
	 * @return searchetaFryard
	 */
	public String getSearchetaFryard() {
		return this.searchetaFryard;
	}
	
	/**
	 * Column Info
	 * @return locyardexistLocyard
	 */
	public String getLocyardexistLocyard() {
		return this.locyardexistLocyard;
	}
	
	/**
	 * Column Info
	 * @return loccodeColname
	 */
	public String getLoccodeColname() {
		return this.loccodeColname;
	}
	
	/**
	 * Column Info
	 * @return gapmonth
	 */
	public String getGapmonth() {
		return this.gapmonth;
	}
	
	/**
	 * Column Info
	 * @return podRepoPlnId
	 */
	public String getPodRepoPlnId() {
		return this.podRepoPlnId;
	}
	
	/**
	 * Column Info
	 * @return mlocCd
	 */
	public String getMlocCd() {
		return this.mlocCd;
	}
	
	/**
	 * Column Info
	 * @return weeklySearchword
	 */
	public String getWeeklySearchword() {
		return this.weeklySearchword;
	}
	
	/**
	 * Column Info
	 * @return locyardEcc
	 */
	public String getLocyardEcc() {
		return this.locyardEcc;
	}
	
	/**
	 * Column Info
	 * @return vvdexistEcccd
	 */
	public String getVvdexistEcccd() {
		return this.vvdexistEcccd;
	}
	
	/**
	 * Column Info
	 * @return vvdRow
	 */
	public String getVvdRow() {
		return this.vvdRow;
	}
	
	/**
	 * Column Info
	 * @return toWk
	 */
	public String getToWk() {
		return this.toWk;
	}
	
	/**
	 * Column Info
	 * @return vvdinlandFmecc
	 */
	public String getVvdinlandFmecc() {
		return this.vvdinlandFmecc;
	}
	
	/**
	 * Column Info
	 * @return vvdexistRepoplnid
	 */
	public String getVvdexistRepoplnid() {
		return this.vvdexistRepoplnid;
	}
	
	/**
	 * Column Info
	 * @return podVvd
	 */
	public String getPodVvd() {
		return this.podVvd;
	}
	
	/**
	 * Column Info
	 * @return locyardRow
	 */
	public String getLocyardRow() {
		return this.locyardRow;
	}
	
	/**
	 * Column Info
	 * @return vvdinlandToecc
	 */
	public String getVvdinlandToecc() {
		return this.vvdinlandToecc;
	}
	
	/**
	 * Column Info
	 * @return searchetaColname
	 */
	public String getSearchetaColname() {
		return this.searchetaColname;
	}
	
	/**
	 * Column Info
	 * @return vendorSearchword
	 */
	public String getVendorSearchword() {
		return this.vendorSearchword;
	}
	
	/**
	 * Column Info
	 * @return locyardexistColname
	 */
	public String getLocyardexistColname() {
		return this.locyardexistColname;
	}
	
	/**
	 * Column Info
	 * @return locyardexistcompanyColname
	 */
	public String getLocyardexistcompanyColname() {
		return this.locyardexistcompanyColname;
	}
	
	/**
	 * Column Info
	 * @return vvdPlnyrwk
	 */
	public String getVvdPlnyrwk() {
		return this.vvdPlnyrwk;
	}
	
	/**
	 * Column Info
	 * @return locyardVndrSeq
	 */
	public String getLocyardVndrSeq() {
		return this.locyardVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return podWk
	 */
	public String getPodWk() {
		return this.podWk;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return toYrwk
	 */
	public String getToYrwk() {
		return this.toYrwk;
	}
	
	/**
	 * Column Info
	 * @return editmonth
	 */
	public String getEditmonth() {
		return this.editmonth;
	}
	
	/**
	 * Column Info
	 * @return locyardColname1
	 */
	public String getLocyardColname1() {
		return this.locyardColname1;
	}
	
	/**
	 * Column Info
	 * @return fmyr
	 */
	public String getFmyr() {
		return this.fmyr;
	}
	
	/**
	 * Column Info
	 * @return weekperiodColname2
	 */
	public String getWeekperiodColname2() {
		return this.weekperiodColname2;
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
	 * @return col
	 */
	public String getCol() {
		return this.col;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return weekperiodColname1
	 */
	public String getWeekperiodColname1() {
		return this.weekperiodColname1;
	}
	
	/**
	 * Column Info
	 * @return locyardColname
	 */
	public String getLocyardColname() {
		return this.locyardColname;
	}
	
	/**
	 * Column Info
	 * @return vvdexistColname
	 */
	public String getVvdexistColname() {
		return this.vvdexistColname;
	}
	
	/**
	 * Column Info
	 * @return weekperiodRow
	 */
	public String getWeekperiodRow() {
		return this.weekperiodRow;
	}
	
	/**
	 * Column Info
	 * @return vvdColname
	 */
	public String getVvdColname() {
		return this.vvdColname;
	}
	
	/**
	 * Column Info
	 * @return locyardSearchword
	 */
	public String getLocyardSearchword() {
		return this.locyardSearchword;
	}
	
	/**
	 * Column Info
	 * @return locfmyardSearchword
	 */
	public String getLocFmyardSearchword() {
		return this.locfmyardSearchword;
	}
	
	/**
	 * Column Info
	 * @return loctoyardSearchword
	 */
	public String getLocToyardSearchword() {
		return this.loctoyardSearchword;
	}
	
	/**
	 * Column Info
	 * @return weeklySavename
	 */
	public String getWeeklySavename() {
		return this.weeklySavename;
	}
	
	/**
	 * Column Info
	 * @return locyardexistRow
	 */
	public String getLocyardexistRow() {
		return this.locyardexistRow;
	}
	
	/**
	 * Column Info
	 * @return searchetaToyard
	 */
	public String getSearchetaToyard() {
		return this.searchetaToyard;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return locyardexistcompanyEcc
	 */
	public String getLocyardexistcompanyEcc() {
		return this.locyardexistcompanyEcc;
	}
	
	/**
	 * Column Info
	 * @return tmp
	 */
	public String getTmp() {
		return this.tmp;
	}
	
	/**
	 * Column Info
	 * @return locyardinitialVsl
	 */
	public String getLocyardinitialVsl() {
		return this.locyardinitialVsl;
	}
	
	/**
	 * Column Info
	 * @return vslPortCd
	 */
	public String getVslPortCd() {
		return this.vslPortCd;
	}
	
	/**
	 * Column Info
	 * @return locyardexistcompanyLocyard
	 */
	public String getLocyardexistcompanyLocyard() {
		return this.locyardexistcompanyLocyard;
	}
	
	/**
	 * Column Info
	 * @return vvdSearchword
	 */
	public String getVvdSearchword() {
		return this.vvdSearchword;
	}
	
	/**
	 * Column Info
	 * @return country
	 */
	public String getCountry() {
		return this.country;
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
	 * @return plnyrwk
	 */
	public String getPlnyrwk() {
		return this.plnyrwk;
	}
	
	/**
	 * Column Info
	 * @return searchetaItem
	 */
	public String getSearchetaItem() {
		return this.searchetaItem;
	}
	
	/**
	 * Column Info
	 * @return fmwk
	 */
	public String getFmwk() {
		return this.fmwk;
	}
	
	/**
	 * Column Info
	 * @return locyardDivCd
	 */
	public String getLocyardDivCd() {
		return this.locyardDivCd;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return locyardinitialItem
	 */
	public String getLocyardinitialItem() {
		return this.locyardinitialItem;
	}
	
	/**
	 * Column Info
	 * @return vvdinlandColname
	 */
	public String getVvdinlandColname() {
		return this.vvdinlandColname;
	}
	
	/**
	 * Column Info
	 * @return vendorRow
	 */
	public String getVendorRow() {
		return this.vendorRow;
	}
	
	/**
	 * Column Info
	 * @return ecccd
	 */
	public String getEcccd() {
		return this.ecccd;
	}
	
	/**
	 * Column Info
	 * @return localdate
	 */
	public String getLocaldate() {
		return this.localdate;
	}
	
	/**
	 * Column Info
	 * @return weekperiodDivision
	 */
	public String getWeekperiodDivision() {
		return this.weekperiodDivision;
	}
	
	/**
	 * Column Info
	 * @return fmYrwk
	 */
	public String getFmYrwk() {
		return this.fmYrwk;
	}
	
	/**
	 * Column Info
	 * @return etbDtColname
	 */
	public String getEtbDtColname() {
		return this.etbDtColname;
	}
	
	/**
	 * Column Info
	 * @return fmWk
	 */
	public String getFmWk() {
		return this.fmWk;
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
	 * @return locyardexistcompanyRow
	 */
	public String getLocyardexistcompanyRow() {
		return this.locyardexistcompanyRow;
	}
	
	/**
	 * Column Info
	 * @return toWeek
	 */
	public String getToWeek() {
		return this.toWeek;
	}
	
	/**
	 * Column Info
	 * @return etaDtColname
	 */
	public String getEtaDtColname() {
		return this.etaDtColname;
	}
	
	/**
	 * Column Info
	 * @return podEtd
	 */
	public String getPodEtd() {
		return this.podEtd;
	}
	
	/**
	 * Column Info
	 * @return vvdRepoplanid
	 */
	public String getVvdRepoplanid() {
		return this.vvdRepoplanid;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
	}
	
	/**
	 * Column Info
	 * @return vvdexistColname1
	 */
	public String getVvdexistColname1() {
		return this.vvdexistColname1;
	}
	
	/**
	 * Column Info
	 * @return vvdexistSearchword
	 */
	public String getVvdexistSearchword() {
		return this.vvdexistSearchword;
	}
	
	/**
	 * Column Info
	 * @return mtype
	 */
	public String getMtype() {
		return this.mtype;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return frYyyy
	 */
	public String getFrYyyy() {
		return this.frYyyy;
	}
	
	/**
	 * Column Info
	 * @return seqSearchword
	 */
	public String getSeqSearchword() {
		return this.seqSearchword;
	}
	
	/**
	 * Column Info
	 * @return seqRow
	 */
	public String getSeqRow() {
		return this.seqRow;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	

	/**
	 * Column Info
	 * @param podPod
	 */
	public void setPodPod(String podPod) {
		this.podPod = podPod;
	}
	
	/**
	 * Column Info
	 * @param weekperiodSearchword
	 */
	public void setWeekperiodSearchword(String weekperiodSearchword) {
		this.weekperiodSearchword = weekperiodSearchword;
	}
	
	/**
	 * Column Info
	 * @param podColname
	 */
	public void setPodColname(String podColname) {
		this.podColname = podColname;
	}
	
	/**
	 * Column Info
	 * @param locyardinitialEcc
	 */
	public void setLocyardinitialEcc(String locyardinitialEcc) {
		this.locyardinitialEcc = locyardinitialEcc;
	}
	
	/**
	 * Column Info
	 * @param podPol
	 */
	public void setPodPol(String podPol) {
		this.podPol = podPol;
	}
	
	/**
	 * Column Info
	 * @param toYyyy
	 */
	public void setToYyyy(String toYyyy) {
		this.toYyyy = toYyyy;
	}
	
	/**
	 * Column Info
	 * @param vvdinlandRow
	 */
	public void setVvdinlandRow(String vvdinlandRow) {
		this.vvdinlandRow = vvdinlandRow;
	}
	
	/**
	 * Column Info
	 * @param vvdexistDivision
	 */
	public void setVvdexistDivision(String vvdexistDivision) {
		this.vvdexistDivision = vvdexistDivision;
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
	 * @param podRow
	 */
	public void setPodRow(String podRow) {
		this.podRow = podRow;
	}
	
	/**
	 * Column Info
	 * @param vvdexistRow
	 */
	public void setVvdexistRow(String vvdexistRow) {
		this.vvdexistRow = vvdexistRow;
	}
	
	/**
	 * Column Info
	 * @param locyardinitialRow
	 */
	public void setLocyardinitialRow(String locyardinitialRow) {
		this.locyardinitialRow = locyardinitialRow;
	}
	
	/**
	 * Column Info
	 * @param vvdinlandEtaweek
	 */
	public void setVvdinlandEtaweek(String vvdinlandEtaweek) {
		this.vvdinlandEtaweek = vvdinlandEtaweek;
	}
	
	/**
	 * Column Info
	 * @param searchetaSearchword
	 */
	public void setSearchetaSearchword(String searchetaSearchword) {
		this.searchetaSearchword = searchetaSearchword;
	}
	
	/**
	 * Column Info
	 * @param vvdexistScnrid
	 */
	public void setVvdexistScnrid(String vvdexistScnrid) {
		this.vvdexistScnrid = vvdexistScnrid;
	}
	
	/**
	 * Column Info
	 * @param loccodeRow
	 */
	public void setLoccodeRow(String loccodeRow) {
		this.loccodeRow = loccodeRow;
	}
	
	/**
	 * Column Info
	 * @param podFixed
	 */
	public void setPodFixed(String podFixed) {
		this.podFixed = podFixed;
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
	 * @param checkweek
	 */
	public void setCheckweek(String checkweek) {
		this.checkweek = checkweek;
	}
	
	/**
	 * Column Info
	 * @param podLane
	 */
	public void setPodLane(String podLane) {
		this.podLane = podLane;
	}
	
	/**
	 * Column Info
	 * @param frWeek
	 */
	public void setFrWeek(String frWeek) {
		this.frWeek = frWeek;
	}
	
	/**
	 * Column Info
	 * @param weeklyRow
	 */
	public void setWeeklyRow(String weeklyRow) {
		this.weeklyRow = weeklyRow;
	}
	
	/**
	 * Column Info
	 * @param searchetaRow
	 */
	public void setSearchetaRow(String searchetaRow) {
		this.searchetaRow = searchetaRow;
	}
	
	/**
	 * Column Info
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	/**
	 * Column Info
	 * @param atYrwk
	 */
	public void setAtYrwk(String atYrwk) {
		this.atYrwk = atYrwk;
	}
	
	/**
	 * Column Info
	 * @param loccd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param vendorColname
	 */
	public void setVendorColname(String vendorColname) {
		this.vendorColname = vendorColname;
	}
	
	/**
	 * Column Info
	 * @param etdDtColname
	 */
	public void setEtdDtColname(String etdDtColname) {
		this.etdDtColname = etdDtColname;
	}
	
	/**
	 * Column Info
	 * @param locyardinitialColname
	 */
	public void setLocyardinitialColname(String locyardinitialColname) {
		this.locyardinitialColname = locyardinitialColname;
	}
	
	/**
	 * Column Info
	 * @param locyardexistEcc
	 */
	public void setLocyardexistEcc(String locyardexistEcc) {
		this.locyardexistEcc = locyardexistEcc;
	}
	
	/**
	 * Column Info
	 * @param vvdexistPlnyrwk
	 */
	public void setVvdexistPlnyrwk(String vvdexistPlnyrwk) {
		this.vvdexistPlnyrwk = vvdexistPlnyrwk;
	}
	
	/**
	 * Column Info
	 * @param searchetaFryard
	 */
	public void setSearchetaFryard(String searchetaFryard) {
		this.searchetaFryard = searchetaFryard;
	}
	
	/**
	 * Column Info
	 * @param locyardexistLocyard
	 */
	public void setLocyardexistLocyard(String locyardexistLocyard) {
		this.locyardexistLocyard = locyardexistLocyard;
	}
	
	/**
	 * Column Info
	 * @param loccodeColname
	 */
	public void setLoccodeColname(String loccodeColname) {
		this.loccodeColname = loccodeColname;
	}
	
	/**
	 * Column Info
	 * @param gapmonth
	 */
	public void setGapmonth(String gapmonth) {
		this.gapmonth = gapmonth;
	}
	
	/**
	 * Column Info
	 * @param podRepoPlnId
	 */
	public void setPodRepoPlnId(String podRepoPlnId) {
		this.podRepoPlnId = podRepoPlnId;
	}
	
	/**
	 * Column Info
	 * @param mlocCd
	 */
	public void setMlocCd(String mlocCd) {
		this.mlocCd = mlocCd;
	}
	
	/**
	 * Column Info
	 * @param weeklySearchword
	 */
	public void setWeeklySearchword(String weeklySearchword) {
		this.weeklySearchword = weeklySearchword;
	}
	
	/**
	 * Column Info
	 * @param locyardEcc
	 */
	public void setLocyardEcc(String locyardEcc) {
		this.locyardEcc = locyardEcc;
	}
	
	/**
	 * Column Info
	 * @param vvdexistEcccd
	 */
	public void setVvdexistEcccd(String vvdexistEcccd) {
		this.vvdexistEcccd = vvdexistEcccd;
	}
	
	/**
	 * Column Info
	 * @param vvdRow
	 */
	public void setVvdRow(String vvdRow) {
		this.vvdRow = vvdRow;
	}
	
	/**
	 * Column Info
	 * @param toWk
	 */
	public void setToWk(String toWk) {
		this.toWk = toWk;
	}
	
	/**
	 * Column Info
	 * @param vvdinlandFmecc
	 */
	public void setVvdinlandFmecc(String vvdinlandFmecc) {
		this.vvdinlandFmecc = vvdinlandFmecc;
	}
	
	/**
	 * Column Info
	 * @param vvdexistRepoplnid
	 */
	public void setVvdexistRepoplnid(String vvdexistRepoplnid) {
		this.vvdexistRepoplnid = vvdexistRepoplnid;
	}
	
	/**
	 * Column Info
	 * @param podVvd
	 */
	public void setPodVvd(String podVvd) {
		this.podVvd = podVvd;
	}
	
	/**
	 * Column Info
	 * @param locyardRow
	 */
	public void setLocyardRow(String locyardRow) {
		this.locyardRow = locyardRow;
	}
	
	/**
	 * Column Info
	 * @param vvdinlandToecc
	 */
	public void setVvdinlandToecc(String vvdinlandToecc) {
		this.vvdinlandToecc = vvdinlandToecc;
	}
	
	/**
	 * Column Info
	 * @param searchetaColname
	 */
	public void setSearchetaColname(String searchetaColname) {
		this.searchetaColname = searchetaColname;
	}
	
	/**
	 * Column Info
	 * @param vendorSearchword
	 */
	public void setVendorSearchword(String vendorSearchword) {
		this.vendorSearchword = vendorSearchword;
	}
	
	/**
	 * Column Info
	 * @param locyardexistColname
	 */
	public void setLocyardexistColname(String locyardexistColname) {
		this.locyardexistColname = locyardexistColname;
	}
	
	/**
	 * Column Info
	 * @param locyardexistcompanyColname
	 */
	public void setLocyardexistcompanyColname(String locyardexistcompanyColname) {
		this.locyardexistcompanyColname = locyardexistcompanyColname;
	}
	
	/**
	 * Column Info
	 * @param vvdPlnyrwk
	 */
	public void setVvdPlnyrwk(String vvdPlnyrwk) {
		this.vvdPlnyrwk = vvdPlnyrwk;
	}
	
	/**
	 * Column Info
	 * @param locyardVndrSeq
	 */
	public void setLocyardVndrSeq(String locyardVndrSeq) {
		this.locyardVndrSeq = locyardVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param podWk
	 */
	public void setPodWk(String podWk) {
		this.podWk = podWk;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param toYrwk
	 */
	public void setToYrwk(String toYrwk) {
		this.toYrwk = toYrwk;
	}
	
	/**
	 * Column Info
	 * @param editmonth
	 */
	public void setEditmonth(String editmonth) {
		this.editmonth = editmonth;
	}
	
	/**
	 * Column Info
	 * @param locyardColname1
	 */
	public void setLocyardColname1(String locyardColname1) {
		this.locyardColname1 = locyardColname1;
	}
	
	/**
	 * Column Info
	 * @param fmyr
	 */
	public void setFmyr(String fmyr) {
		this.fmyr = fmyr;
	}
	
	/**
	 * Column Info
	 * @param weekperiodColname2
	 */
	public void setWeekperiodColname2(String weekperiodColname2) {
		this.weekperiodColname2 = weekperiodColname2;
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
	 * @param col
	 */
	public void setCol(String col) {
		this.col = col;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param weekperiodColname1
	 */
	public void setWeekperiodColname1(String weekperiodColname1) {
		this.weekperiodColname1 = weekperiodColname1;
	}
	
	/**
	 * Column Info
	 * @param locyardColname
	 */
	public void setLocyardColname(String locyardColname) {
		this.locyardColname = locyardColname;
	}
	
	/**
	 * Column Info
	 * @param vvdexistColname
	 */
	public void setVvdexistColname(String vvdexistColname) {
		this.vvdexistColname = vvdexistColname;
	}
	
	/**
	 * Column Info
	 * @param weekperiodRow
	 */
	public void setWeekperiodRow(String weekperiodRow) {
		this.weekperiodRow = weekperiodRow;
	}
	
	/**
	 * Column Info
	 * @param vvdColname
	 */
	public void setVvdColname(String vvdColname) {
		this.vvdColname = vvdColname;
	}
	
	/**
	 * Column Info
	 * @param locyardSearchword
	 */
	public void setLocyardSearchword(String locyardSearchword) {
		this.locyardSearchword = locyardSearchword;
	}
	
	/**
	 * Column Info
	 * @param locfmyardSearchword
	 */
	public void setLocFmyardSearchword(String locfmyardSearchword) {
		this.locfmyardSearchword = locfmyardSearchword;
	}
	
	/**
	 * Column Info
	 * @param loctoyardSearchword
	 */
	public void setLocToyardSearchword(String loctoyardSearchword) {
		this.loctoyardSearchword = loctoyardSearchword;
	}
	
	/**
	 * Column Info
	 * @param weeklySavename
	 */
	public void setWeeklySavename(String weeklySavename) {
		this.weeklySavename = weeklySavename;
	}
	
	/**
	 * Column Info
	 * @param locyardexistRow
	 */
	public void setLocyardexistRow(String locyardexistRow) {
		this.locyardexistRow = locyardexistRow;
	}
	
	/**
	 * Column Info
	 * @param searchetaToyard
	 */
	public void setSearchetaToyard(String searchetaToyard) {
		this.searchetaToyard = searchetaToyard;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param locyardexistcompanyEcc
	 */
	public void setLocyardexistcompanyEcc(String locyardexistcompanyEcc) {
		this.locyardexistcompanyEcc = locyardexistcompanyEcc;
	}
	
	/**
	 * Column Info
	 * @param tmp
	 */
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	
	/**
	 * Column Info
	 * @param locyardinitialVsl
	 */
	public void setLocyardinitialVsl(String locyardinitialVsl) {
		this.locyardinitialVsl = locyardinitialVsl;
	}
	
	/**
	 * Column Info
	 * @param vslPortCd
	 */
	public void setVslPortCd(String vslPortCd) {
		this.vslPortCd = vslPortCd;
	}
	
	/**
	 * Column Info
	 * @param locyardexistcompanyLocyard
	 */
	public void setLocyardexistcompanyLocyard(String locyardexistcompanyLocyard) {
		this.locyardexistcompanyLocyard = locyardexistcompanyLocyard;
	}
	
	/**
	 * Column Info
	 * @param vvdSearchword
	 */
	public void setVvdSearchword(String vvdSearchword) {
		this.vvdSearchword = vvdSearchword;
	}
	
	/**
	 * Column Info
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * @param plnyrwk
	 */
	public void setPlnyrwk(String plnyrwk) {
		this.plnyrwk = plnyrwk;
	}
	
	/**
	 * Column Info
	 * @param searchetaItem
	 */
	public void setSearchetaItem(String searchetaItem) {
		this.searchetaItem = searchetaItem;
	}
	
	/**
	 * Column Info
	 * @param fmwk
	 */
	public void setFmwk(String fmwk) {
		this.fmwk = fmwk;
	}
	
	/**
	 * Column Info
	 * @param locyardDivCd
	 */
	public void setLocyardDivCd(String locyardDivCd) {
		this.locyardDivCd = locyardDivCd;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param locyardinitialItem
	 */
	public void setLocyardinitialItem(String locyardinitialItem) {
		this.locyardinitialItem = locyardinitialItem;
	}
	
	/**
	 * Column Info
	 * @param vvdinlandColname
	 */
	public void setVvdinlandColname(String vvdinlandColname) {
		this.vvdinlandColname = vvdinlandColname;
	}
	
	/**
	 * Column Info
	 * @param vendorRow
	 */
	public void setVendorRow(String vendorRow) {
		this.vendorRow = vendorRow;
	}
	
	/**
	 * Column Info
	 * @param ecccd
	 */
	public void setEcccd(String ecccd) {
		this.ecccd = ecccd;
	}
	
	/**
	 * Column Info
	 * @param localdate
	 */
	public void setLocaldate(String localdate) {
		this.localdate = localdate;
	}
	
	/**
	 * Column Info
	 * @param weekperiodDivision
	 */
	public void setWeekperiodDivision(String weekperiodDivision) {
		this.weekperiodDivision = weekperiodDivision;
	}
	
	/**
	 * Column Info
	 * @param fmYrwk
	 */
	public void setFmYrwk(String fmYrwk) {
		this.fmYrwk = fmYrwk;
	}
	
	/**
	 * Column Info
	 * @param etbDtColname
	 */
	public void setEtbDtColname(String etbDtColname) {
		this.etbDtColname = etbDtColname;
	}
	
	/**
	 * Column Info
	 * @param fmWk
	 */
	public void setFmWk(String fmWk) {
		this.fmWk = fmWk;
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
	 * @param locyardexistcompanyRow
	 */
	public void setLocyardexistcompanyRow(String locyardexistcompanyRow) {
		this.locyardexistcompanyRow = locyardexistcompanyRow;
	}
	
	/**
	 * Column Info
	 * @param toWeek
	 */
	public void setToWeek(String toWeek) {
		this.toWeek = toWeek;
	}
	
	/**
	 * Column Info
	 * @param etaDtColname
	 */
	public void setEtaDtColname(String etaDtColname) {
		this.etaDtColname = etaDtColname;
	}
	
	/**
	 * Column Info
	 * @param podEtd
	 */
	public void setPodEtd(String podEtd) {
		this.podEtd = podEtd;
	}
	
	/**
	 * Column Info
	 * @param vvdRepoplanid
	 */
	public void setVvdRepoplanid(String vvdRepoplanid) {
		this.vvdRepoplanid = vvdRepoplanid;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}
	
	/**
	 * Column Info
	 * @param vvdexistColname1
	 */
	public void setVvdexistColname1(String vvdexistColname1) {
		this.vvdexistColname1 = vvdexistColname1;
	}
	
	/**
	 * Column Info
	 * @param vvdexistSearchword
	 */
	public void setVvdexistSearchword(String vvdexistSearchword) {
		this.vvdexistSearchword = vvdexistSearchword;
	}
	
	/**
	 * Column Info
	 * @param mtype
	 */
	public void setMtype(String mtype) {
		this.mtype = mtype;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param frYyyy
	 */
	public void setFrYyyy(String frYyyy) {
		this.frYyyy = frYyyy;
	}
	
	/**
	 * Column Info
	 * @param seqSearchword
	 */
	public void setSeqSearchword(String seqSearchword) {
		this.seqSearchword = seqSearchword;
	}
	
	/**
	 * Column Info
	 * @param seqRow
	 */
	public void setSeqRow(String seqRow) {
		this.seqRow = seqRow;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
	}
	
	public String getFmYr() {
		return fmYr;
	}

	public void setFmYr(String fmYr) {
		this.fmYr = fmYr;
	}
	
	public String getYdCdColname() {
		return YdCdColname;
	}

	public void setYdCdColname(String ydCdColname) {
		YdCdColname = ydCdColname;
	}
	
	/**
	* Column Info
	* @param  fmContiCd
	*/
	public void	setFmContiCd( String	fmContiCd ) {
		this.fmContiCd =	fmContiCd;
	}
 
	/**
	 * Column Info
	 * @return	fmContiCd
	 */
	 public	 String	getFmContiCd() {
		 return	this.fmContiCd;
	 } 
	 
	 /**
	* Column Info
	* @param  toContiCd
	*/
	public void	setToContiCd( String	toContiCd ) {
		this.toContiCd =	toContiCd;
	}
 
	/**
	 * Column Info
	 * @return	fmContiCd
	 */
	 public	 String	getToContiCd() {
		 return	this.toContiCd;
	 } 
	 
	 /**
	* Column Info
	* @param  exectype
	*/
	public void	setExectype( String	exectype ) {
		this.exectype =	exectype;
	}
 
	/**
	 * Column Info
	 * @return	exectype
	 */
	 public	 String	getExectype() {
		 return	this.exectype;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodPod(JSPUtil.getParameter(request, "pod_pod", ""));
		setWeekperiodSearchword(JSPUtil.getParameter(request, "weekperiod_searchword", ""));
		setPodColname(JSPUtil.getParameter(request, "pod_colname", ""));
		setLocyardinitialEcc(JSPUtil.getParameter(request, "locyardinitial_ecc", ""));
		setPodPol(JSPUtil.getParameter(request, "pod_pol", ""));
		setToYyyy(JSPUtil.getParameter(request, "to_yyyy", ""));
		setVvdinlandRow(JSPUtil.getParameter(request, "vvdinland_row", ""));
		setVvdexistDivision(JSPUtil.getParameter(request, "vvdexist_division", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodRow(JSPUtil.getParameter(request, "pod_row", ""));
		setVvdexistRow(JSPUtil.getParameter(request, "vvdexist_row", ""));
		setLocyardinitialRow(JSPUtil.getParameter(request, "locyardinitial_row", ""));
		setVvdinlandEtaweek(JSPUtil.getParameter(request, "vvdinland_etaweek", ""));
		setSearchetaSearchword(JSPUtil.getParameter(request, "searcheta_searchword", ""));
		setVvdexistScnrid(JSPUtil.getParameter(request, "vvdexist_scnrid", ""));
		setLoccodeRow(JSPUtil.getParameter(request, "loccode_row", ""));
		setPodFixed(JSPUtil.getParameter(request, "pod_fixed", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCheckweek(JSPUtil.getParameter(request, "checkweek", ""));
		setPodLane(JSPUtil.getParameter(request, "pod_lane", ""));
		setFrWeek(JSPUtil.getParameter(request, "fr_week", ""));
		setWeeklyRow(JSPUtil.getParameter(request, "weekly_row", ""));
		setSearchetaRow(JSPUtil.getParameter(request, "searcheta_row", ""));
		setTemp(JSPUtil.getParameter(request, "temp", ""));
		setAtYrwk(JSPUtil.getParameter(request, "at_yrwk", ""));
		setLocCd(JSPUtil.getParameter(request, "locCd", ""));
		setVendorColname(JSPUtil.getParameter(request, "vendor_colname", ""));
		setEtdDtColname(JSPUtil.getParameter(request, "etd_dt_colname", ""));
		setLocyardinitialColname(JSPUtil.getParameter(request, "locyardinitial_colname", ""));
		setLocyardexistEcc(JSPUtil.getParameter(request, "locyardexist_ecc", ""));
		setVvdexistPlnyrwk(JSPUtil.getParameter(request, "vvdexist_plnyrwk", ""));
		setSearchetaFryard(JSPUtil.getParameter(request, "searcheta_fryard", ""));
		setLocyardexistLocyard(JSPUtil.getParameter(request, "locyardexist_locyard", ""));
		setLoccodeColname(JSPUtil.getParameter(request, "loccode_colname", ""));
		setGapmonth(JSPUtil.getParameter(request, "gapmonth", ""));
		setPodRepoPlnId(JSPUtil.getParameter(request, "pod_repo_pln_id", ""));
		setMlocCd(JSPUtil.getParameter(request, "mlocCd", ""));
		setWeeklySearchword(JSPUtil.getParameter(request, "weekly_searchword", ""));
		setLocyardEcc(JSPUtil.getParameter(request, "locyard_ecc", ""));
		setVvdexistEcccd(JSPUtil.getParameter(request, "vvdexist_ecccd", ""));
		setVvdRow(JSPUtil.getParameter(request, "vvd_row", ""));
		setToWk(JSPUtil.getParameter(request, "to_wk", ""));
		setVvdinlandFmecc(JSPUtil.getParameter(request, "vvdinland_fmecc", ""));
		setVvdexistRepoplnid(JSPUtil.getParameter(request, "vvdexist_repoplnid", ""));
		setPodVvd(JSPUtil.getParameter(request, "pod_vvd", ""));
		setLocyardRow(JSPUtil.getParameter(request, "locyard_row", ""));
		setVvdinlandToecc(JSPUtil.getParameter(request, "vvdinland_toecc", ""));
		setSearchetaColname(JSPUtil.getParameter(request, "searcheta_colname", ""));
		setVendorSearchword(JSPUtil.getParameter(request, "vendor_searchword", ""));
		setLocyardexistColname(JSPUtil.getParameter(request, "locyardexist_colname", ""));
		setLocyardexistcompanyColname(JSPUtil.getParameter(request, "locyardexistcompany_colname", ""));
		setVvdPlnyrwk(JSPUtil.getParameter(request, "vvd_plnyrwk", ""));
		setLocyardVndrSeq(JSPUtil.getParameter(request, "locyard_vndr_seq", ""));
		setPodWk(JSPUtil.getParameter(request, "pod_wk", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setToYrwk(JSPUtil.getParameter(request, "to_yrwk", ""));
		setEditmonth(JSPUtil.getParameter(request, "editmonth", ""));
		setLocyardColname1(JSPUtil.getParameter(request, "locyard_colname1", ""));
		setFmyr(JSPUtil.getParameter(request, "fmyr", ""));
		setWeekperiodColname2(JSPUtil.getParameter(request, "weekperiod_colname2", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCol(JSPUtil.getParameter(request, "col", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setWeekperiodColname1(JSPUtil.getParameter(request, "weekperiod_colname1", ""));
		setLocyardColname(JSPUtil.getParameter(request, "locyard_colname", ""));
		setVvdexistColname(JSPUtil.getParameter(request, "vvdexist_colname", ""));
		setWeekperiodRow(JSPUtil.getParameter(request, "weekperiod_row", ""));
		setVvdColname(JSPUtil.getParameter(request, "vvd_colname", ""));
		setLocyardSearchword(JSPUtil.getParameter(request, "locyard_searchword", ""));
		setWeeklySavename(JSPUtil.getParameter(request, "weekly_savename", ""));
		setLocyardexistRow(JSPUtil.getParameter(request, "locyardexist_row", ""));
		setSearchetaToyard(JSPUtil.getParameter(request, "searcheta_toyard", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setLocyardexistcompanyEcc(JSPUtil.getParameter(request, "locyardexistcompany_ecc", ""));
		setTmp(JSPUtil.getParameter(request, "tmp", ""));
		setLocyardinitialVsl(JSPUtil.getParameter(request, "locyardinitial_vsl", ""));
		setVslPortCd(JSPUtil.getParameter(request, "vsl_port_cd", ""));
		setLocyardexistcompanyLocyard(JSPUtil.getParameter(request, "locyardexistcompany_locyard", ""));
		setVvdSearchword(JSPUtil.getParameter(request, "vvd_searchword", ""));
		setCountry(JSPUtil.getParameter(request, "country", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPlnyrwk(JSPUtil.getParameter(request, "plnyrwk", ""));
		setSearchetaItem(JSPUtil.getParameter(request, "searcheta_item", ""));
		setFmwk(JSPUtil.getParameter(request, "fmwk", ""));
		setLocyardDivCd(JSPUtil.getParameter(request, "locyard_div_cd", ""));
		setScnrId(JSPUtil.getParameter(request, "scnrId", ""));
		setLocyardinitialItem(JSPUtil.getParameter(request, "locyardinitial_item", ""));
		setVvdinlandColname(JSPUtil.getParameter(request, "vvdinland_colname", ""));
		setVendorRow(JSPUtil.getParameter(request, "vendor_row", ""));
		setEcccd(JSPUtil.getParameter(request, "ecccd", ""));
		setLocaldate(JSPUtil.getParameter(request, "localdate", ""));
		setWeekperiodDivision(JSPUtil.getParameter(request, "weekperiod_division", ""));
		setFmYrwk(JSPUtil.getParameter(request, "fm_yrwk", ""));
		setEtbDtColname(JSPUtil.getParameter(request, "etb_dt_colname", ""));
		setFmWk(JSPUtil.getParameter(request, "fm_wk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocyardexistcompanyRow(JSPUtil.getParameter(request, "locyardexistcompany_row", ""));
		setToWeek(JSPUtil.getParameter(request, "to_week", ""));
		setEtaDtColname(JSPUtil.getParameter(request, "eta_dt_colname", ""));
		setPodEtd(JSPUtil.getParameter(request, "pod_etd", ""));
		setVvdRepoplanid(JSPUtil.getParameter(request, "vvd_repoplanid", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setVvdexistColname1(JSPUtil.getParameter(request, "vvdexist_colname1", ""));
		setVvdexistSearchword(JSPUtil.getParameter(request, "vvdexist_searchword", ""));
		setMtype(JSPUtil.getParameter(request, "mtype", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFrYyyy(JSPUtil.getParameter(request, "fr_yyyy", ""));
		setSeqSearchword(JSPUtil.getParameter(request, "seq_searchword", ""));
		setSeqRow(JSPUtil.getParameter(request, "seq_row", ""));
		setPodEta(JSPUtil.getParameter(request, "pod_eta", ""));
		setFmYr(JSPUtil.getParameter(request, "fm_yr", ""));
		setYdCdColname(JSPUtil.getParameter(request, "yd_cd_colname", ""));
		setLocFmyardSearchword(JSPUtil.getParameter(request, "locfmyard_searchword", ""));
		setLocToyardSearchword(JSPUtil.getParameter(request, "loctoyard_searchword", ""));
		setFmContiCd(JSPUtil.getParameter(request,	"fm_conti_cd", ""));
		setToContiCd(JSPUtil.getParameter(request,	"to_conti_cd", ""));
		setExectype(JSPUtil.getParameter(request,	"exectype", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesCommonConditionVO[]
	 */
	public EesCommonConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesCommonConditionVO[]
	 */
	public EesCommonConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesCommonConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podPod = (JSPUtil.getParameter(request, prefix	+ "pod_pod", length));
			String[] weekperiodSearchword = (JSPUtil.getParameter(request, prefix	+ "weekperiod_searchword", length));
			String[] podColname = (JSPUtil.getParameter(request, prefix	+ "pod_colname", length));
			String[] locyardinitialEcc = (JSPUtil.getParameter(request, prefix	+ "locyardinitial_ecc", length));
			String[] podPol = (JSPUtil.getParameter(request, prefix	+ "pod_pol", length));
			String[] toYyyy = (JSPUtil.getParameter(request, prefix	+ "to_yyyy", length));
			String[] vvdinlandRow = (JSPUtil.getParameter(request, prefix	+ "vvdinland_row", length));
			String[] vvdexistDivision = (JSPUtil.getParameter(request, prefix	+ "vvdexist_division", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podRow = (JSPUtil.getParameter(request, prefix	+ "pod_row", length));
			String[] vvdexistRow = (JSPUtil.getParameter(request, prefix	+ "vvdexist_row", length));
			String[] locyardinitialRow = (JSPUtil.getParameter(request, prefix	+ "locyardinitial_row", length));
			String[] vvdinlandEtaweek = (JSPUtil.getParameter(request, prefix	+ "vvdinland_etaweek", length));
			String[] searchetaSearchword = (JSPUtil.getParameter(request, prefix	+ "searcheta_searchword", length));
			String[] vvdexistScnrid = (JSPUtil.getParameter(request, prefix	+ "vvdexist_scnrid", length));
			String[] loccodeRow = (JSPUtil.getParameter(request, prefix	+ "loccode_row", length));
			String[] podFixed = (JSPUtil.getParameter(request, prefix	+ "pod_fixed", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] checkweek = (JSPUtil.getParameter(request, prefix	+ "checkweek", length));
			String[] podLane = (JSPUtil.getParameter(request, prefix	+ "pod_lane", length));
			String[] frWeek = (JSPUtil.getParameter(request, prefix	+ "fr_week", length));
			String[] weeklyRow = (JSPUtil.getParameter(request, prefix	+ "weekly_row", length));
			String[] searchetaRow = (JSPUtil.getParameter(request, prefix	+ "searcheta_row", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] atYrwk = (JSPUtil.getParameter(request, prefix	+ "at_yrwk", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "locCd", length));
			String[] vendorColname = (JSPUtil.getParameter(request, prefix	+ "vendor_colname", length));
			String[] etdDtColname = (JSPUtil.getParameter(request, prefix	+ "etd_dt_colname", length));
			String[] locyardinitialColname = (JSPUtil.getParameter(request, prefix	+ "locyardinitial_colname", length));
			String[] locyardexistEcc = (JSPUtil.getParameter(request, prefix	+ "locyardexist_ecc", length));
			String[] vvdexistPlnyrwk = (JSPUtil.getParameter(request, prefix	+ "vvdexist_plnyrwk", length));
			String[] searchetaFryard = (JSPUtil.getParameter(request, prefix	+ "searcheta_fryard", length));
			String[] locyardexistLocyard = (JSPUtil.getParameter(request, prefix	+ "locyardexist_locyard", length));
			String[] loccodeColname = (JSPUtil.getParameter(request, prefix	+ "loccode_colname", length));
			String[] gapmonth = (JSPUtil.getParameter(request, prefix	+ "gapmonth", length));
			String[] podRepoPlnId = (JSPUtil.getParameter(request, prefix	+ "pod_repo_pln_id", length));
			String[] mlocCd = (JSPUtil.getParameter(request, prefix	+ "mlocCd", length));
			String[] weeklySearchword = (JSPUtil.getParameter(request, prefix	+ "weekly_searchword", length));
			String[] locyardEcc = (JSPUtil.getParameter(request, prefix	+ "locyard_ecc", length));
			String[] vvdexistEcccd = (JSPUtil.getParameter(request, prefix	+ "vvdexist_ecccd", length));
			String[] vvdRow = (JSPUtil.getParameter(request, prefix	+ "vvd_row", length));
			String[] toWk = (JSPUtil.getParameter(request, prefix	+ "to_wk", length));
			String[] vvdinlandFmecc = (JSPUtil.getParameter(request, prefix	+ "vvdinland_fmecc", length));
			String[] vvdexistRepoplnid = (JSPUtil.getParameter(request, prefix	+ "vvdexist_repoplnid", length));
			String[] podVvd = (JSPUtil.getParameter(request, prefix	+ "pod_vvd", length));
			String[] locyardRow = (JSPUtil.getParameter(request, prefix	+ "locyard_row", length));
			String[] vvdinlandToecc = (JSPUtil.getParameter(request, prefix	+ "vvdinland_toecc", length));
			String[] searchetaColname = (JSPUtil.getParameter(request, prefix	+ "searcheta_colname", length));
			String[] vendorSearchword = (JSPUtil.getParameter(request, prefix	+ "vendor_searchword", length));
			String[] locyardexistColname = (JSPUtil.getParameter(request, prefix	+ "locyardexist_colname", length));
			String[] locyardexistcompanyColname = (JSPUtil.getParameter(request, prefix	+ "locyardexistcompany_colname", length));
			String[] vvdPlnyrwk = (JSPUtil.getParameter(request, prefix	+ "vvd_plnyrwk", length));
			String[] locyardVndrSeq = (JSPUtil.getParameter(request, prefix	+ "locyard_vndr_seq", length));
			String[] podWk = (JSPUtil.getParameter(request, prefix	+ "pod_wk", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] toYrwk = (JSPUtil.getParameter(request, prefix	+ "to_yrwk", length));
			String[] editmonth = (JSPUtil.getParameter(request, prefix	+ "editmonth", length));
			String[] locyardColname1 = (JSPUtil.getParameter(request, prefix	+ "locyard_colname1", length));
			String[] fmyr = (JSPUtil.getParameter(request, prefix	+ "fmyr", length));
			String[] weekperiodColname2 = (JSPUtil.getParameter(request, prefix	+ "weekperiod_colname2", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] col = (JSPUtil.getParameter(request, prefix	+ "col", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] weekperiodColname1 = (JSPUtil.getParameter(request, prefix	+ "weekperiod_colname1", length));
			String[] locyardColname = (JSPUtil.getParameter(request, prefix	+ "locyard_colname", length));
			String[] vvdexistColname = (JSPUtil.getParameter(request, prefix	+ "vvdexist_colname", length));
			String[] weekperiodRow = (JSPUtil.getParameter(request, prefix	+ "weekperiod_row", length));
			String[] vvdColname = (JSPUtil.getParameter(request, prefix	+ "vvd_colname", length));
			String[] locyardSearchword = (JSPUtil.getParameter(request, prefix	+ "locyard_searchword", length));
			String[] weeklySavename = (JSPUtil.getParameter(request, prefix	+ "weekly_savename", length));
			String[] locyardexistRow = (JSPUtil.getParameter(request, prefix	+ "locyardexist_row", length));
			String[] searchetaToyard = (JSPUtil.getParameter(request, prefix	+ "searcheta_toyard", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] locyardexistcompanyEcc = (JSPUtil.getParameter(request, prefix	+ "locyardexistcompany_ecc", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp", length));
			String[] locyardinitialVsl = (JSPUtil.getParameter(request, prefix	+ "locyardinitial_vsl", length));
			String[] vslPortCd = (JSPUtil.getParameter(request, prefix	+ "vsl_port_cd", length));
			String[] locyardexistcompanyLocyard = (JSPUtil.getParameter(request, prefix	+ "locyardexistcompany_locyard", length));
			String[] vvdSearchword = (JSPUtil.getParameter(request, prefix	+ "vvd_searchword", length));
			String[] country = (JSPUtil.getParameter(request, prefix	+ "country", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] plnyrwk = (JSPUtil.getParameter(request, prefix	+ "plnyrwk", length));
			String[] searchetaItem = (JSPUtil.getParameter(request, prefix	+ "searcheta_item", length));
			String[] fmwk = (JSPUtil.getParameter(request, prefix	+ "fmwk", length));
			String[] locyardDivCd = (JSPUtil.getParameter(request, prefix	+ "locyard_div_cd", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnrId", length));
			String[] locyardinitialItem = (JSPUtil.getParameter(request, prefix	+ "locyardinitial_item", length));
			String[] vvdinlandColname = (JSPUtil.getParameter(request, prefix	+ "vvdinland_colname", length));
			String[] vendorRow = (JSPUtil.getParameter(request, prefix	+ "vendor_row", length));
			String[] ecccd = (JSPUtil.getParameter(request, prefix	+ "ecccd", length));
			String[] localdate = (JSPUtil.getParameter(request, prefix	+ "localdate", length));
			String[] weekperiodDivision = (JSPUtil.getParameter(request, prefix	+ "weekperiod_division", length));
			String[] fmYrwk = (JSPUtil.getParameter(request, prefix	+ "fm_yrwk", length));
			String[] etbDtColname = (JSPUtil.getParameter(request, prefix	+ "etb_dt_colname", length));
			String[] fmWk = (JSPUtil.getParameter(request, prefix	+ "fm_wk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locyardexistcompanyRow = (JSPUtil.getParameter(request, prefix	+ "locyardexistcompany_row", length));
			String[] toWeek = (JSPUtil.getParameter(request, prefix	+ "to_week", length));
			String[] etaDtColname = (JSPUtil.getParameter(request, prefix	+ "eta_dt_colname", length));
			String[] podEtd = (JSPUtil.getParameter(request, prefix	+ "pod_etd", length));
			String[] vvdRepoplanid = (JSPUtil.getParameter(request, prefix	+ "vvd_repoplanid", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] vvdexistColname1 = (JSPUtil.getParameter(request, prefix	+ "vvdexist_colname1", length));
			String[] vvdexistSearchword = (JSPUtil.getParameter(request, prefix	+ "vvdexist_searchword", length));
			String[] mtype = (JSPUtil.getParameter(request, prefix	+ "mtype", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] frYyyy = (JSPUtil.getParameter(request, prefix	+ "fr_yyyy", length));
			String[] seqSearchword = (JSPUtil.getParameter(request, prefix	+ "seq_searchword", length));
			String[] seqRow = (JSPUtil.getParameter(request, prefix	+ "seq_row", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			String[] fmYr = (JSPUtil.getParameter(request, prefix	+ "fm_yr", length));
			String[] locfmyardSearchword = (JSPUtil.getParameter(request, prefix	+ "locfmyard_searchword", length));
			String[] loctoyardSearchword = (JSPUtil.getParameter(request, prefix	+ "loctoyard_searchword", length));
			String[] fmContiCd =	(JSPUtil.getParameter(request, prefix +	"fm_conti_cd",	length));
			String[] toContiCd =	(JSPUtil.getParameter(request, prefix +	"to_conti_cd",	length));
			String[] exectype =	(JSPUtil.getParameter(request, prefix +	"exectype",	length));
			
			for (int i = 0; i < length; i++) {
				model = new EesCommonConditionVO();
				if (podPod[i] != null)
					model.setPodPod(podPod[i]);
				if (weekperiodSearchword[i] != null)
					model.setWeekperiodSearchword(weekperiodSearchword[i]);
				if (podColname[i] != null)
					model.setPodColname(podColname[i]);
				if (locyardinitialEcc[i] != null)
					model.setLocyardinitialEcc(locyardinitialEcc[i]);
				if (podPol[i] != null)
					model.setPodPol(podPol[i]);
				if (toYyyy[i] != null)
					model.setToYyyy(toYyyy[i]);
				if (vvdinlandRow[i] != null)
					model.setVvdinlandRow(vvdinlandRow[i]);
				if (vvdexistDivision[i] != null)
					model.setVvdexistDivision(vvdexistDivision[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podRow[i] != null)
					model.setPodRow(podRow[i]);
				if (vvdexistRow[i] != null)
					model.setVvdexistRow(vvdexistRow[i]);
				if (locyardinitialRow[i] != null)
					model.setLocyardinitialRow(locyardinitialRow[i]);
				if (vvdinlandEtaweek[i] != null)
					model.setVvdinlandEtaweek(vvdinlandEtaweek[i]);
				if (searchetaSearchword[i] != null)
					model.setSearchetaSearchword(searchetaSearchword[i]);
				if (vvdexistScnrid[i] != null)
					model.setVvdexistScnrid(vvdexistScnrid[i]);
				if (loccodeRow[i] != null)
					model.setLoccodeRow(loccodeRow[i]);
				if (podFixed[i] != null)
					model.setPodFixed(podFixed[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (checkweek[i] != null)
					model.setCheckweek(checkweek[i]);
				if (podLane[i] != null)
					model.setPodLane(podLane[i]);
				if (frWeek[i] != null)
					model.setFrWeek(frWeek[i]);
				if (weeklyRow[i] != null)
					model.setWeeklyRow(weeklyRow[i]);
				if (searchetaRow[i] != null)
					model.setSearchetaRow(searchetaRow[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (atYrwk[i] != null)
					model.setAtYrwk(atYrwk[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vendorColname[i] != null)
					model.setVendorColname(vendorColname[i]);
				if (etdDtColname[i] != null)
					model.setEtdDtColname(etdDtColname[i]);
				if (locyardinitialColname[i] != null)
					model.setLocyardinitialColname(locyardinitialColname[i]);
				if (locyardexistEcc[i] != null)
					model.setLocyardexistEcc(locyardexistEcc[i]);
				if (vvdexistPlnyrwk[i] != null)
					model.setVvdexistPlnyrwk(vvdexistPlnyrwk[i]);
				if (searchetaFryard[i] != null)
					model.setSearchetaFryard(searchetaFryard[i]);
				if (locyardexistLocyard[i] != null)
					model.setLocyardexistLocyard(locyardexistLocyard[i]);
				if (loccodeColname[i] != null)
					model.setLoccodeColname(loccodeColname[i]);
				if (gapmonth[i] != null)
					model.setGapmonth(gapmonth[i]);
				if (podRepoPlnId[i] != null)
					model.setPodRepoPlnId(podRepoPlnId[i]);
				if (mlocCd[i] != null)
					model.setMlocCd(mlocCd[i]);
				if (weeklySearchword[i] != null)
					model.setWeeklySearchword(weeklySearchword[i]);
				if (locyardEcc[i] != null)
					model.setLocyardEcc(locyardEcc[i]);
				if (vvdexistEcccd[i] != null)
					model.setVvdexistEcccd(vvdexistEcccd[i]);
				if (vvdRow[i] != null)
					model.setVvdRow(vvdRow[i]);
				if (toWk[i] != null)
					model.setToWk(toWk[i]);
				if (vvdinlandFmecc[i] != null)
					model.setVvdinlandFmecc(vvdinlandFmecc[i]);
				if (vvdexistRepoplnid[i] != null)
					model.setVvdexistRepoplnid(vvdexistRepoplnid[i]);
				if (podVvd[i] != null)
					model.setPodVvd(podVvd[i]);
				if (locyardRow[i] != null)
					model.setLocyardRow(locyardRow[i]);
				if (vvdinlandToecc[i] != null)
					model.setVvdinlandToecc(vvdinlandToecc[i]);
				if (searchetaColname[i] != null)
					model.setSearchetaColname(searchetaColname[i]);
				if (vendorSearchword[i] != null)
					model.setVendorSearchword(vendorSearchword[i]);
				if (locyardexistColname[i] != null)
					model.setLocyardexistColname(locyardexistColname[i]);
				if (locyardexistcompanyColname[i] != null)
					model.setLocyardexistcompanyColname(locyardexistcompanyColname[i]);
				if (vvdPlnyrwk[i] != null)
					model.setVvdPlnyrwk(vvdPlnyrwk[i]);
				if (locyardVndrSeq[i] != null)
					model.setLocyardVndrSeq(locyardVndrSeq[i]);
				if (podWk[i] != null)
					model.setPodWk(podWk[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (toYrwk[i] != null)
					model.setToYrwk(toYrwk[i]);
				if (editmonth[i] != null)
					model.setEditmonth(editmonth[i]);
				if (locyardColname1[i] != null)
					model.setLocyardColname1(locyardColname1[i]);
				if (fmyr[i] != null)
					model.setFmyr(fmyr[i]);
				if (weekperiodColname2[i] != null)
					model.setWeekperiodColname2(weekperiodColname2[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (col[i] != null)
					model.setCol(col[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (weekperiodColname1[i] != null)
					model.setWeekperiodColname1(weekperiodColname1[i]);
				if (locyardColname[i] != null)
					model.setLocyardColname(locyardColname[i]);
				if (vvdexistColname[i] != null)
					model.setVvdexistColname(vvdexistColname[i]);
				if (weekperiodRow[i] != null)
					model.setWeekperiodRow(weekperiodRow[i]);
				if (vvdColname[i] != null)
					model.setVvdColname(vvdColname[i]);
				if (locyardSearchword[i] != null)
					model.setLocyardSearchword(locyardSearchword[i]);
				if (weeklySavename[i] != null)
					model.setWeeklySavename(weeklySavename[i]);
				if (locyardexistRow[i] != null)
					model.setLocyardexistRow(locyardexistRow[i]);
				if (searchetaToyard[i] != null)
					model.setSearchetaToyard(searchetaToyard[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (locyardexistcompanyEcc[i] != null)
					model.setLocyardexistcompanyEcc(locyardexistcompanyEcc[i]);
				if (tmp1[i] != null)
					model.setTmp(tmp1[i]);
				if (locyardinitialVsl[i] != null)
					model.setLocyardinitialVsl(locyardinitialVsl[i]);
				if (vslPortCd[i] != null)
					model.setVslPortCd(vslPortCd[i]);
				if (locyardexistcompanyLocyard[i] != null)
					model.setLocyardexistcompanyLocyard(locyardexistcompanyLocyard[i]);
				if (vvdSearchword[i] != null)
					model.setVvdSearchword(vvdSearchword[i]);
				if (country[i] != null)
					model.setCountry(country[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (plnyrwk[i] != null)
					model.setPlnyrwk(plnyrwk[i]);
				if (searchetaItem[i] != null)
					model.setSearchetaItem(searchetaItem[i]);
				if (fmwk[i] != null)
					model.setFmwk(fmwk[i]);
				if (locyardDivCd[i] != null)
					model.setLocyardDivCd(locyardDivCd[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (locyardinitialItem[i] != null)
					model.setLocyardinitialItem(locyardinitialItem[i]);
				if (vvdinlandColname[i] != null)
					model.setVvdinlandColname(vvdinlandColname[i]);
				if (vendorRow[i] != null)
					model.setVendorRow(vendorRow[i]);
				if (ecccd[i] != null)
					model.setEcccd(ecccd[i]);
				if (localdate[i] != null)
					model.setLocaldate(localdate[i]);
				if (weekperiodDivision[i] != null)
					model.setWeekperiodDivision(weekperiodDivision[i]);
				if (fmYrwk[i] != null)
					model.setFmYrwk(fmYrwk[i]);
				if (etbDtColname[i] != null)
					model.setEtbDtColname(etbDtColname[i]);
				if (fmWk[i] != null)
					model.setFmWk(fmWk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locyardexistcompanyRow[i] != null)
					model.setLocyardexistcompanyRow(locyardexistcompanyRow[i]);
				if (toWeek[i] != null)
					model.setToWeek(toWeek[i]);
				if (etaDtColname[i] != null)
					model.setEtaDtColname(etaDtColname[i]);
				if (podEtd[i] != null)
					model.setPodEtd(podEtd[i]);
				if (vvdRepoplanid[i] != null)
					model.setVvdRepoplanid(vvdRepoplanid[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (vvdexistColname1[i] != null)
					model.setVvdexistColname1(vvdexistColname1[i]);
				if (vvdexistSearchword[i] != null)
					model.setVvdexistSearchword(vvdexistSearchword[i]);
				if (mtype[i] != null)
					model.setMtype(mtype[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (frYyyy[i] != null)
					model.setFrYyyy(frYyyy[i]);
				if (seqSearchword[i] != null)
					model.setSeqSearchword(seqSearchword[i]);
				if (seqRow[i] != null)
					model.setSeqRow(seqRow[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				if (fmYr[i] != null)
					model.setFmYr(fmYr[i]);
				if (locfmyardSearchword[i] != null)
					model.setLocFmyardSearchword(locfmyardSearchword[i]);
				if (loctoyardSearchword[i] != null)
					model.setLocToyardSearchword(loctoyardSearchword[i]);
				if ( fmContiCd[i] !=	null)
					model.setFmContiCd( fmContiCd[i]);
				if ( toContiCd[i] !=	null)
					model.setToContiCd( toContiCd[i]);
				if ( exectype[i] !=	null)
					model.setExectype( exectype[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesCommonConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesCommonConditionVO[]
	 */
	public EesCommonConditionVO[] getEesCommonConditionVOs(){
		EesCommonConditionVO[] vos = (EesCommonConditionVO[])models.toArray(new EesCommonConditionVO[models.size()]);
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
		this.podPod = this.podPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekperiodSearchword = this.weekperiodSearchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podColname = this.podColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardinitialEcc = this.locyardinitialEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPol = this.podPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYyyy = this.toYyyy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdinlandRow = this.vvdinlandRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistDivision = this.vvdexistDivision .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRow = this.podRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistRow = this.vvdexistRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardinitialRow = this.locyardinitialRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdinlandEtaweek = this.vvdinlandEtaweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchetaSearchword = this.searchetaSearchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistScnrid = this.vvdexistScnrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccodeRow = this.loccodeRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFixed = this.podFixed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkweek = this.checkweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLane = this.podLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frWeek = this.frWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weeklyRow = this.weeklyRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchetaRow = this.searchetaRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atYrwk = this.atYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorColname = this.vendorColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDtColname = this.etdDtColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardinitialColname = this.locyardinitialColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardexistEcc = this.locyardexistEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistPlnyrwk = this.vvdexistPlnyrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchetaFryard = this.searchetaFryard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardexistLocyard = this.locyardexistLocyard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccodeColname = this.loccodeColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gapmonth = this.gapmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRepoPlnId = this.podRepoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlocCd = this.mlocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weeklySearchword = this.weeklySearchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardEcc = this.locyardEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistEcccd = this.vvdexistEcccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRow = this.vvdRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWk = this.toWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdinlandFmecc = this.vvdinlandFmecc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistRepoplnid = this.vvdexistRepoplnid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVvd = this.podVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardRow = this.locyardRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdinlandToecc = this.vvdinlandToecc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchetaColname = this.searchetaColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorSearchword = this.vendorSearchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardexistColname = this.locyardexistColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardexistcompanyColname = this.locyardexistcompanyColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPlnyrwk = this.vvdPlnyrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardVndrSeq = this.locyardVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podWk = this.podWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYrwk = this.toYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.editmonth = this.editmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardColname1 = this.locyardColname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmyr = this.fmyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekperiodColname2 = this.weekperiodColname2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col = this.col .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekperiodColname1 = this.weekperiodColname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardColname = this.locyardColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistColname = this.vvdexistColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekperiodRow = this.weekperiodRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdColname = this.vvdColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardSearchword = this.locyardSearchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weeklySavename = this.weeklySavename .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardexistRow = this.locyardexistRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchetaToyard = this.searchetaToyard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardexistcompanyEcc = this.locyardexistcompanyEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp = this.tmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardinitialVsl = this.locyardinitialVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPortCd = this.vslPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardexistcompanyLocyard = this.locyardexistcompanyLocyard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSearchword = this.vvdSearchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.country = this.country .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnyrwk = this.plnyrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchetaItem = this.searchetaItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmwk = this.fmwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardDivCd = this.locyardDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardinitialItem = this.locyardinitialItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdinlandColname = this.vvdinlandColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorRow = this.vendorRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecccd = this.ecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localdate = this.localdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekperiodDivision = this.weekperiodDivision .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYrwk = this.fmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDtColname = this.etbDtColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWk = this.fmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locyardexistcompanyRow = this.locyardexistcompanyRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWeek = this.toWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDtColname = this.etaDtColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtd = this.podEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRepoplanid = this.vvdRepoplanid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistColname1 = this.vvdexistColname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdexistSearchword = this.vvdexistSearchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtype = this.mtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frYyyy = this.frYyyy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqSearchword = this.seqSearchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqRow = this.seqRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYr = this.fmYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.YdCdColname = this.YdCdColname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmContiCd =	this.fmContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toContiCd =	this.toContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exectype =	this.exectype.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
