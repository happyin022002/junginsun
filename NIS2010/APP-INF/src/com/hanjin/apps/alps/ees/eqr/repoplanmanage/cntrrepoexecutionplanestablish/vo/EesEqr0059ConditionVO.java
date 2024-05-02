/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0059ConditionVO.java
*@FileTitle : EesEqr0059ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.17 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0059ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0059ConditionVO> models = new ArrayList<EesEqr0059ConditionVO>();
	

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag	= null;
	/* Page Number */
	private String pagerows	= null;
	
	//-------- USER LEVEL, ACTION, LOCATION INFORMATION ---------
	private String userLevel			= null;			// USER LEVEL 1, 2, 3, 4, 5
	private String userSearchLocation	= null;	// ALL(모든지역), RCC, LCC
	private String userModifyDiv		= null;		// ALL(모든지역), RCC, LCC
	private String userSearchDiv		= null;		// "", RCC, LCC
	private String userModifyLocation	= null;	// "", RCC, LCC
	private String userFullAccess       = null; //전주차 접근가능한 유저인지 확인 (TRUE - 전주차 접근가능, FALSE - 전주차 접근불가)
	
	// FROM, TO, AT LOCATION
	private String fmtoat			= "";				// FROM TO, AT : 1,2
	private String fromstatus		= "";
	private String tostatus			= "";
	private String atstatus			= "";
	private String fromlocation		= "";
	private String tolocation		= "";
	private String atlocation		= "";
	
	// PERIOD - FROM WEEK, TO WEEK
	private String fmplnyr = "";
	private String toplnwk = "";
	private String toplnyr = "";
	private String fmplnwk = "";
	

	private String yyyyww = "";
	private String seq = "";
	private String plnYrwk = "";
	private String repoPlnId = "";
	
	private String tpsz = "";
	private String tpsztype = "";

	private String reason = "";
	private String sosend = "";
	private String mty = "";
	private String itemname = "";
	private String lane = "";
	private String vvd = "";;
	
	private String colname = "";
	private String searchVvd = "";
	private String searchLane = "";
	private String searchFromecc = "";
	private String searchBkgno = "";
	
	private String mtyflag = "";
	private String eqRepoPurpCd = "";
	private String linktabnum = "";
	private String row = "";
	private String dataselect = "";
	
	private String fromEcc	= "";
	private String toEcc	= "";
	private String userEcc	= "";
	
	private String repoPlnWeek		= "";
	private String repoPlnNextWeek	= "";
	
	
	private String scnrId = "";
	private String soFlag = "";
	
	private String prevWeek		= "";
	private String currentWeek	= "";
	
	private String tpszInitial	= "";

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0059ConditionVO() {}

	public EesEqr0059ConditionVO(String ibflag, String pagerows, String userLevel, String userSearchDiv, String userModifyDiv, String userSearchLocation, String userModifyLocation, String yyyyww, String seq, String repoPlnId, String fmtoat, String fromstatus, String fromlocation, String tostatus, String tolocation, String atsatus, String atlocation, String fmplnyr, String fmplnwk, String toplnyr, String toplnwk, String reason, String sosend, String mty, String itemname, String tpsz, String tpsztype, String lane, String vvd, String plnYrwk, String mtyflag, String dataselect, String linktabnum, String searchLane, String searchVvd, String searchFromecc, String colname, String searchBkgno, String eqRepoPurpCd, String row, String atstatus , String scnrId , String soFlag, String prevWeek, String currentWeek) {
		this.reason = reason;
		this.fromlocation = fromlocation;
		this.toplnwk = toplnwk;
		this.plnYrwk = plnYrwk;
		this.userSearchDiv = userSearchDiv;
		this.colname = colname;
		this.searchVvd = searchVvd;
		this.lane = lane;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sosend = sosend;
		this.itemname = itemname;
		this.userSearchLocation = userSearchLocation;
		this.searchLane = searchLane;
		this.userModifyDiv = userModifyDiv;
		this.toplnyr = toplnyr;
		this.userLevel = userLevel;
		this.mtyflag = mtyflag;
		this.tpsztype = tpsztype;
		this.userModifyLocation = userModifyLocation;
		this.tolocation = tolocation;
		this.eqRepoPurpCd = eqRepoPurpCd;
		this.fromstatus = fromstatus;
		this.tostatus = tostatus;
		this.mty = mty;
		this.linktabnum = linktabnum;
		this.searchFromecc = searchFromecc;
		this.repoPlnId = repoPlnId;
		this.row = row;
		this.vvd = vvd;
		this.yyyyww = yyyyww;
		this.tpsz = tpsz;
		this.fmplnyr = fmplnyr;
		this.fmtoat = fmtoat;
		this.seq = seq;
		this.dataselect = dataselect;
		this.searchBkgno = searchBkgno;
		this.atlocation = atlocation;
		this.fmplnwk = fmplnwk;
		this.atstatus = atstatus;
		this.scnrId = scnrId;
		this.soFlag = soFlag;
		this.prevWeek = prevWeek;
		this.currentWeek = currentWeek;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("reason", getReason());
		this.hashColumns.put("fromlocation", getFromlocation());
		this.hashColumns.put("toplnwk", getToplnwk());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("user_search_div", getUserSearchDiv());
		this.hashColumns.put("colname", getColname());
		this.hashColumns.put("search_vvd", getSearchVvd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sosend", getSosend());
		this.hashColumns.put("itemname", getItemname());
		this.hashColumns.put("user_search_location", getUserSearchLocation());
		this.hashColumns.put("search_lane", getSearchLane());
		this.hashColumns.put("user_modify_div", getUserModifyDiv());
		this.hashColumns.put("toplnyr", getToplnyr());
		this.hashColumns.put("user_level", getUserLevel());
		this.hashColumns.put("mtyflag", getMtyflag());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("user_modify_location", getUserModifyLocation());
		this.hashColumns.put("tolocation", getTolocation());
		this.hashColumns.put("eq_repo_purp_cd", getEqRepoPurpCd());
		this.hashColumns.put("fromstatus", getFromstatus());
		this.hashColumns.put("tostatus", getTostatus());
		this.hashColumns.put("mty", getMty());
		this.hashColumns.put("linktabnum", getLinktabnum());
		this.hashColumns.put("search_fromecc", getSearchFromecc());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("fmplnyr", getFmplnyr());
		this.hashColumns.put("fmtoat", getFmtoat());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("dataselect", getDataselect());
		this.hashColumns.put("search_bkgno", getSearchBkgno());
		this.hashColumns.put("atlocation", getAtlocation());
		this.hashColumns.put("fmplnwk", getFmplnwk());
		this.hashColumns.put("atstatus", getAtstatus());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("soFlag", getSoFlag());
		this.hashColumns.put("prevWeek", getPrevWeek());
		this.hashColumns.put("currentWeek", getCurrentWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("reason", "reason");
		this.hashFields.put("fromlocation", "fromlocation");
		this.hashFields.put("toplnwk", "toplnwk");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("user_search_div", "userSearchDiv");
		this.hashFields.put("colname", "colname");
		this.hashFields.put("search_vvd", "searchVvd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sosend", "sosend");
		this.hashFields.put("itemname", "itemname");
		this.hashFields.put("user_search_location", "userSearchLocation");
		this.hashFields.put("search_lane", "searchLane");
		this.hashFields.put("user_modify_div", "userModifyDiv");
		this.hashFields.put("toplnyr", "toplnyr");
		this.hashFields.put("user_level", "userLevel");
		this.hashFields.put("mtyflag", "mtyflag");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("user_modify_location", "userModifyLocation");
		this.hashFields.put("tolocation", "tolocation");
		this.hashFields.put("eq_repo_purp_cd", "eqRepoPurpCd");
		this.hashFields.put("fromstatus", "fromstatus");
		this.hashFields.put("tostatus", "tostatus");
		this.hashFields.put("mty", "mty");
		this.hashFields.put("linktabnum", "linktabnum");
		this.hashFields.put("search_fromecc", "searchFromecc");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("row", "row");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("fmplnyr", "fmplnyr");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("dataselect", "dataselect");
		this.hashFields.put("search_bkgno", "searchBkgno");
		this.hashFields.put("atlocation", "atlocation");
		this.hashFields.put("fmplnwk", "fmplnwk");
		this.hashFields.put("atsatus", "atsatus");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("soFlag", "soFlag");
		this.hashFields.put("prevWeek", "prevWeek");
		this.hashFields.put("currentWeek", "currentWeek");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return reason
	 */
	public String getReason() {
		return this.reason;
	}
	
	/**
	 * Column Info
	 * @return fromlocation
	 */
	public String getFromlocation() {
		return this.fromlocation;
	}
	
	/**
	 * Column Info
	 * @return toplnwk
	 */
	public String getToplnwk() {
		return this.toplnwk;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return userSearchDiv
	 */
	public String getUserSearchDiv() {
		return this.userSearchDiv;
	}
	
	/**
	 * Column Info
	 * @return colname
	 */
	public String getColname() {
		return this.colname;
	}
	
	/**
	 * Column Info
	 * @return searchVvd
	 */
	public String getSearchVvd() {
		return this.searchVvd;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return sosend
	 */
	public String getSosend() {
		return this.sosend;
	}
	
	/**
	 * Column Info
	 * @return itemname
	 */
	public String getItemname() {
		return this.itemname;
	}
	
	/**
	 * Column Info
	 * @return userSearchLocation
	 */
	public String getUserSearchLocation() {
		return this.userSearchLocation;
	}
	
	/**
	 * Column Info
	 * @return searchLane
	 */
	public String getSearchLane() {
		return this.searchLane;
	}
	
	/**
	 * Column Info
	 * @return userModifyDiv
	 */
	public String getUserModifyDiv() {
		return this.userModifyDiv;
	}
	
	/**
	 * Column Info
	 * @return toplnyr
	 */
	public String getToplnyr() {
		return this.toplnyr;
	}
	
	/**
	 * Column Info
	 * @return userLevel
	 */
	public String getUserLevel() {
		return this.userLevel;
	}
	
	/**
	 * Column Info
	 * @return mtyflag
	 */
	public String getMtyflag() {
		return this.mtyflag;
	}
	
	/**
	 * Column Info
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	
	/**
	 * Column Info
	 * @return userModifyLocation
	 */
	public String getUserModifyLocation() {
		return this.userModifyLocation;
	}
	
	/**
	 * Column Info
	 * @return tolocation
	 */
	public String getTolocation() {
		return this.tolocation;
	}
	
	/**
	 * Column Info
	 * @return eqRepoPurpCd
	 */
	public String getEqRepoPurpCd() {
		return this.eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @return fromstatus
	 */
	public String getFromstatus() {
		return this.fromstatus;
	}
	
	/**
	 * Column Info
	 * @return tostatus
	 */
	public String getTostatus() {
		return this.tostatus;
	}
	
	/**
	 * Column Info
	 * @return mty
	 */
	public String getMty() {
		return this.mty;
	}
	
	/**
	 * Column Info
	 * @return linktabnum
	 */
	public String getLinktabnum() {
		return this.linktabnum;
	}
	
	/**
	 * Column Info
	 * @return searchFromecc
	 */
	public String getSearchFromecc() {
		return this.searchFromecc;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return fmplnyr
	 */
	public String getFmplnyr() {
		return this.fmplnyr;
	}
	
	/**
	 * Column Info
	 * @return fmtoat
	 */
	public String getFmtoat() {
		return this.fmtoat;
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
	 * @return dataselect
	 */
	public String getDataselect() {
		return this.dataselect;
	}
	
	/**
	 * Column Info
	 * @return searchBkgno
	 */
	public String getSearchBkgno() {
		return this.searchBkgno;
	}
	
	/**
	 * Column Info
	 * @return atlocation
	 */
	public String getAtlocation() {
		return this.atlocation;
	}
	
	/**
	 * Column Info
	 * @return fmplnwk
	 */
	public String getFmplnwk() {
		return this.fmplnwk;
	}
	
	/**
	 * Column Info
	 * @return atsttus
	 */
	public String getAtstatus() {
		return this.atstatus;
	}
	
	public String getFromEcc() {
		return fromEcc;
	}
	
	public String getToEcc() {
		return toEcc;
	}

	public String getUserEcc() {
		return userEcc;
	}
	

	public String getRepoPlnWeek() {
		return repoPlnWeek;
	}

	public void setRepoPlnWeek(String repoPlnWeek) {
		this.repoPlnWeek = repoPlnWeek;
	}

	public String getRepoPlnNextWeek() {
		return repoPlnNextWeek;
	}

	public void setRepoPlnNextWeek(String repoPlnNextWeek) {
		this.repoPlnNextWeek = repoPlnNextWeek;
	}

	public void setFromEcc(String fromEcc) {
		this.fromEcc = fromEcc;
	}

	public void setToEcc(String toEcc) {
		this.toEcc = toEcc;
	}

	public void setUserEcc(String userEcc) {
		this.userEcc = userEcc;
	}
	

	/**
	 * Column Info
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * Column Info
	 * @param fromlocation
	 */
	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}
	
	/**
	 * Column Info
	 * @param toplnwk
	 */
	public void setToplnwk(String toplnwk) {
		this.toplnwk = toplnwk;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param userSearchDiv
	 */
	public void setUserSearchDiv(String userSearchDiv) {
		this.userSearchDiv = userSearchDiv;
	}
	
	/**
	 * Column Info
	 * @param colname
	 */
	public void setColname(String colname) {
		this.colname = colname;
	}
	
	/**
	 * Column Info
	 * @param searchVvd
	 */
	public void setSearchVvd(String searchVvd) {
		this.searchVvd = searchVvd;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param sosend
	 */
	public void setSosend(String sosend) {
		this.sosend = sosend;
	}
	
	/**
	 * Column Info
	 * @param itemname
	 */
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	/**
	 * Column Info
	 * @param userSearchLocation
	 */
	public void setUserSearchLocation(String userSearchLocation) {
		this.userSearchLocation = userSearchLocation;
	}
	
	/**
	 * Column Info
	 * @param searchLane
	 */
	public void setSearchLane(String searchLane) {
		this.searchLane = searchLane;
	}
	
	/**
	 * Column Info
	 * @param userModifyDiv
	 */
	public void setUserModifyDiv(String userModifyDiv) {
		this.userModifyDiv = userModifyDiv;
	}
	
	/**
	 * Column Info
	 * @param toplnyr
	 */
	public void setToplnyr(String toplnyr) {
		this.toplnyr = toplnyr;
	}
	
	/**
	 * Column Info
	 * @param userLevel
	 */
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
	/**
	 * Column Info
	 * @param mtyflag
	 */
	public void setMtyflag(String mtyflag) {
		this.mtyflag = mtyflag;
	}
	
	/**
	 * Column Info
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Column Info
	 * @param userModifyLocation
	 */
	public void setUserModifyLocation(String userModifyLocation) {
		this.userModifyLocation = userModifyLocation;
	}
	
	/**
	 * Column Info
	 * @param tolocation
	 */
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}
	
	/**
	 * Column Info
	 * @param eqRepoPurpCd
	 */
	public void setEqRepoPurpCd(String eqRepoPurpCd) {
		this.eqRepoPurpCd = eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @param fromstatus
	 */
	public void setFromstatus(String fromstatus) {
		this.fromstatus = fromstatus;
	}
	
	/**
	 * Column Info
	 * @param tostatus
	 */
	public void setTostatus(String tostatus) {
		this.tostatus = tostatus;
	}
	
	/**
	 * Column Info
	 * @param mty
	 */
	public void setMty(String mty) {
		this.mty = mty;
	}
	
	/**
	 * Column Info
	 * @param linktabnum
	 */
	public void setLinktabnum(String linktabnum) {
		this.linktabnum = linktabnum;
	}
	
	/**
	 * Column Info
	 * @param searchFromecc
	 */
	public void setSearchFromecc(String searchFromecc) {
		this.searchFromecc = searchFromecc;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		//this.repoPlnId = repoPlnId;
		this.repoPlnId = Constants.REPO_WORD + this.yyyyww + Constants.SCNR_WEEK + this.seq;;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param fmplnyr
	 */
	public void setFmplnyr(String fmplnyr) {
		this.fmplnyr = fmplnyr;
	}
	
	/**
	 * Column Info
	 * @param fmtoat
	 */
	public void setFmtoat(String fmtoat) {
		this.fmtoat = fmtoat;
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
	 * @param dataselect
	 */
	public void setDataselect(String dataselect) {
		this.dataselect = dataselect;
	}
	
	/**
	 * Column Info
	 * @param searchBkgno
	 */
	public void setSearchBkgno(String searchBkgno) {
		this.searchBkgno = searchBkgno;
	}
	
	/**
	 * Column Info
	 * @param atlocation
	 */
	public void setAtlocation(String atlocation) {
		this.atlocation = atlocation;
	}
	
	/**
	 * Column Info
	 * @param fmplnwk
	 */
	public void setFmplnwk(String fmplnwk) {
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * Column Info
	 * @param atstatus
	 */
	public void setAtstatus(String atstatus) {
		this.atstatus = atstatus;
	}
	
	
	public String getScnrId() {
		return scnrId;
	}

	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}

	public String getSoFlag() {
		return soFlag;
	}

	public void setSoFlag(String soFlag) {
		this.soFlag = soFlag;
	}

	public String getPrevWeek() {
		return prevWeek;
	}

	public void setPrevWeek(String prevWeek) {
		this.prevWeek = prevWeek;
	}

	public String getCurrentWeek() {
		return currentWeek;
	}

	public String getUserFullAccess() {
		return userFullAccess;
	}

	public void setUserFullAccess(String userFullAccess) {
		this.userFullAccess = userFullAccess;
	}

	public void setCurrentWeek(String currentWeek) {
		this.currentWeek = currentWeek;
	}
	
	public String getTpszInitial() {
		return tpszInitial;
	}

	public void setTpszInitial(String tpszInitial) {
		this.tpszInitial = tpszInitial;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		
		setFmtoat(JSPUtil.getParameter(request, "fmToAt", ""));
		setFromstatus(JSPUtil.getParameter(request, "fromStatus", ""));
		setTostatus(JSPUtil.getParameter(request, "toStatus", ""));
		setAtstatus(JSPUtil.getParameter(request, "atStatus", ""));
		setFromlocation(JSPUtil.getParameter(request, "fromLocation", ""));
		setTolocation(JSPUtil.getParameter(request, "toLocation", ""));
		setAtlocation(JSPUtil.getParameter(request, "atLocation", ""));

		setFmplnyr(JSPUtil.getParameter(request, "fmPlnYr", ""));
		setFmplnwk(JSPUtil.getParameter(request, "fmPlnWk", ""));
		setToplnyr(JSPUtil.getParameter(request, "toPlnYr", ""));
		setToplnwk(JSPUtil.getParameter(request, "toPlnWk", ""));

		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", "")); //  yyyyww , seq 셋팅 이후 설정한다.
		

		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setTpsztype(JSPUtil.getParameter(request, "tpsztype", ""));
		
		setReason(JSPUtil.getParameter(request, "reason", ""));
		setSosend(JSPUtil.getParameter(request, "sosend", ""));
		setMty(JSPUtil.getParameter(request, "mty", ""));
		setItemname(JSPUtil.getParameter(request, "itemname", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));

		setUserLevel(JSPUtil.getParameter(request, "user_level", ""));
		setUserSearchDiv(JSPUtil.getParameter(request, "user_search_div", ""));
		setUserSearchLocation(JSPUtil.getParameter(request, "user_search_location", ""));
		setUserModifyLocation(JSPUtil.getParameter(request, "user_modify_location", ""));
		setUserModifyDiv(JSPUtil.getParameter(request, "user_modify_div", ""));
		
		setSearchLane(JSPUtil.getParameter(request, "search_lane", ""));
		setSearchFromecc(JSPUtil.getParameter(request, "search_fromecc", ""));
		setSearchVvd(JSPUtil.getParameter(request, "search_vvd", ""));
		setSearchBkgno(JSPUtil.getParameter(request, "search_bkgno", ""));
		
		setMtyflag(JSPUtil.getParameter(request, "mtyflag", ""));
		setEqRepoPurpCd(JSPUtil.getParameter(request, "eq_repo_purp_cd", ""));
		setLinktabnum(JSPUtil.getParameter(request, "linktabnum", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setColname(JSPUtil.getParameter(request, "colname", ""));
		setDataselect(JSPUtil.getParameter(request, "dataselect", ""));
		
		setSoFlag(JSPUtil.getParameter(request, "soFlag", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		
		setPrevWeek(JSPUtil.getParameter(request, "prevWeek", ""));
		setCurrentWeek(JSPUtil.getParameter(request, "currentWeek", ""));
		setRepoPlnWeek(JSPUtil.getParameter(request, "repoPlnWeek", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0059ConditionVO[]
	 */
	public EesEqr0059ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0059ConditionVO[]
	 */
	public EesEqr0059ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0059ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] reason = (JSPUtil.getParameter(request, prefix	+ "reason", length));
			String[] fromlocation = (JSPUtil.getParameter(request, prefix	+ "fromlocation", length));
			String[] toplnwk = (JSPUtil.getParameter(request, prefix	+ "toplnwk", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] userSearchDiv = (JSPUtil.getParameter(request, prefix	+ "user_search_div", length));
			String[] colname = (JSPUtil.getParameter(request, prefix	+ "colname", length));
			String[] searchVvd = (JSPUtil.getParameter(request, prefix	+ "search_vvd", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sosend = (JSPUtil.getParameter(request, prefix	+ "sosend", length));
			String[] itemname = (JSPUtil.getParameter(request, prefix	+ "itemname", length));
			String[] userSearchLocation = (JSPUtil.getParameter(request, prefix	+ "user_search_location", length));
			String[] searchLane = (JSPUtil.getParameter(request, prefix	+ "search_lane", length));
			String[] userModifyDiv = (JSPUtil.getParameter(request, prefix	+ "user_modify_div", length));
			String[] toplnyr = (JSPUtil.getParameter(request, prefix	+ "toplnyr", length));
			String[] userLevel = (JSPUtil.getParameter(request, prefix	+ "user_level", length));
			String[] mtyflag = (JSPUtil.getParameter(request, prefix	+ "mtyflag", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] userModifyLocation = (JSPUtil.getParameter(request, prefix	+ "user_modify_location", length));
			String[] tolocation = (JSPUtil.getParameter(request, prefix	+ "tolocation", length));
			String[] eqRepoPurpCd = (JSPUtil.getParameter(request, prefix	+ "eq_repo_purp_cd", length));
			String[] fromstatus = (JSPUtil.getParameter(request, prefix	+ "fromstatus", length));
			String[] tostatus = (JSPUtil.getParameter(request, prefix	+ "tostatus", length));
			String[] mty = (JSPUtil.getParameter(request, prefix	+ "mty", length));
			String[] linktabnum = (JSPUtil.getParameter(request, prefix	+ "linktabnum", length));
			String[] searchFromecc = (JSPUtil.getParameter(request, prefix	+ "search_fromecc", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] fmplnyr = (JSPUtil.getParameter(request, prefix	+ "fmplnyr", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] dataselect = (JSPUtil.getParameter(request, prefix	+ "dataselect", length));
			String[] searchBkgno = (JSPUtil.getParameter(request, prefix	+ "search_bkgno", length));
			String[] atlocation = (JSPUtil.getParameter(request, prefix	+ "atlocation", length));
			String[] fmplnwk = (JSPUtil.getParameter(request, prefix	+ "fmplnwk", length));
			String[] atstatus = (JSPUtil.getParameter(request, prefix	+ "atstatus", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0059ConditionVO();
				if (reason[i] != null)
					model.setReason(reason[i]);
				if (fromlocation[i] != null)
					model.setFromlocation(fromlocation[i]);
				if (toplnwk[i] != null)
					model.setToplnwk(toplnwk[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (userSearchDiv[i] != null)
					model.setUserSearchDiv(userSearchDiv[i]);
				if (colname[i] != null)
					model.setColname(colname[i]);
				if (searchVvd[i] != null)
					model.setSearchVvd(searchVvd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sosend[i] != null)
					model.setSosend(sosend[i]);
				if (itemname[i] != null)
					model.setItemname(itemname[i]);
				if (userSearchLocation[i] != null)
					model.setUserSearchLocation(userSearchLocation[i]);
				if (searchLane[i] != null)
					model.setSearchLane(searchLane[i]);
				if (userModifyDiv[i] != null)
					model.setUserModifyDiv(userModifyDiv[i]);
				if (toplnyr[i] != null)
					model.setToplnyr(toplnyr[i]);
				if (userLevel[i] != null)
					model.setUserLevel(userLevel[i]);
				if (mtyflag[i] != null)
					model.setMtyflag(mtyflag[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (userModifyLocation[i] != null)
					model.setUserModifyLocation(userModifyLocation[i]);
				if (tolocation[i] != null)
					model.setTolocation(tolocation[i]);
				if (eqRepoPurpCd[i] != null)
					model.setEqRepoPurpCd(eqRepoPurpCd[i]);
				if (fromstatus[i] != null)
					model.setFromstatus(fromstatus[i]);
				if (tostatus[i] != null)
					model.setTostatus(tostatus[i]);
				if (mty[i] != null)
					model.setMty(mty[i]);
				if (linktabnum[i] != null)
					model.setLinktabnum(linktabnum[i]);
				if (searchFromecc[i] != null)
					model.setSearchFromecc(searchFromecc[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (fmplnyr[i] != null)
					model.setFmplnyr(fmplnyr[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (dataselect[i] != null)
					model.setDataselect(dataselect[i]);
				if (searchBkgno[i] != null)
					model.setSearchBkgno(searchBkgno[i]);
				if (atlocation[i] != null)
					model.setAtlocation(atlocation[i]);
				if (fmplnwk[i] != null)
					model.setFmplnwk(fmplnwk[i]);
				if (atstatus[i] != null)
					model.setAtstatus(atstatus[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0059ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0059ConditionVO[]
	 */
	public EesEqr0059ConditionVO[] getEesEqr0059ConditionVOs(){
		EesEqr0059ConditionVO[] vos = (EesEqr0059ConditionVO[])models.toArray(new EesEqr0059ConditionVO[models.size()]);
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
		this.reason = this.reason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromlocation = this.fromlocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk = this.toplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userSearchDiv = this.userSearchDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colname = this.colname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchVvd = this.searchVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sosend = this.sosend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemname = this.itemname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userSearchLocation = this.userSearchLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchLane = this.searchLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userModifyDiv = this.userModifyDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr = this.toplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userLevel = this.userLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyflag = this.mtyflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userModifyLocation = this.userModifyLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tolocation = this.tolocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoPurpCd = this.eqRepoPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromstatus = this.fromstatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tostatus = this.tostatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty = this.mty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.linktabnum = this.linktabnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFromecc = this.searchFromecc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr = this.fmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataselect = this.dataselect .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchBkgno = this.searchBkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atlocation = this.atlocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk = this.fmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atstatus = this.atstatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
