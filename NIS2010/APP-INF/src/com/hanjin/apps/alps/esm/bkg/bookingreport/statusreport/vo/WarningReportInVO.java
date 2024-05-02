/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WarningReportInVO.java
*@FileTitle : WarningReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WarningReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WarningReportInVO> models = new ArrayList<WarningReportInVO>();
	
	/*	Column Info	*/
	private  String	 rowsPerPage   =  null;
	/*	Column Info	*/
	private  String	 currPage   =  null;
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String warnCustS = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String polLocal = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String warnCustC = null;
	/* Column Info */
	private String bOfcCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String warnCustB = null;
	/* Column Info */
	private String cOfcCdSub = null;
	/* Column Info */
	private String polTs = null;
	/* Column Info */
	private String bOfcCdSub = null;
	/* Column Info */
	private String lOfcCdSub = null;
	/* Column Info */
	private String boardFromDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String boardToDt = null;
	/* Column Info */
	private String lOfcCd = null;
	/* Column Info */
	private String etaToDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String trunkFlag = null;
	/* Column Info */
	private String podTs = null;
	/* Column Info */
	private String warnCargoM = null;
	/* Column Info */
	private String cOfcCd = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String podLocal = null;
	/* Column Info */
	private String warnCargoP = null;
	/* Column Info */
	private String etaFromDt = null;
	/* Column Info */
	private String warnCustY = null;
	/* Column Info */
	private String warnCustI = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public WarningReportInVO() {}

	public WarningReportInVO(String rowsPerPage, String currPage, String ibflag, String pagerows, String vvdCd, String trunkFlag, String laneCd, String dirCd, String polCd, String polLocal, String polTs, String podCd, String podLocal, String podTs, String porCd, String delCd, String boardFromDt, String boardToDt, String bkgFromDt, String bkgToDt, String etaFromDt, String etaToDt, String bOfcCd, String bOfcCdSub, String lOfcCd, String lOfcCdSub, String cOfcCd, String cOfcCdSub, String warnCustB, String warnCustY, String warnCustC, String warnCustS, String warnCargoP, String warnCargoM, String warnCustI) {
		this.rowsPerPage = rowsPerPage;
		this.currPage = currPage;
		this.porCd = porCd;
		this.laneCd = laneCd;
		this.warnCustS = warnCustS;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.polLocal = polLocal;
		this.bkgToDt = bkgToDt;
		this.warnCustC = warnCustC;
		this.bOfcCd = bOfcCd;
		this.dirCd = dirCd;
		this.warnCustB = warnCustB;
		this.cOfcCdSub = cOfcCdSub;
		this.polTs = polTs;
		this.bOfcCdSub = bOfcCdSub;
		this.lOfcCdSub = lOfcCdSub;
		this.boardFromDt = boardFromDt;
		this.delCd = delCd;
		this.boardToDt = boardToDt;
		this.lOfcCd = lOfcCd;
		this.etaToDt = etaToDt;
		this.podCd = podCd;
		this.trunkFlag = trunkFlag;
		this.podTs = podTs;
		this.warnCargoM = warnCargoM;
		this.cOfcCd = cOfcCd;
		this.bkgFromDt = bkgFromDt;
		this.podLocal = podLocal;
		this.warnCargoP = warnCargoP;
		this.etaFromDt = etaFromDt;
		this.warnCustY = warnCustY;
		this.warnCustI = warnCustI;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("warn_cust_s", getWarnCustS());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pol_local", getPolLocal());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("warn_cust_c", getWarnCustC());
		this.hashColumns.put("b_ofc_cd", getBOfcCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("warn_cust_b", getWarnCustB());
		this.hashColumns.put("c_ofc_cd_sub", getCOfcCdSub());
		this.hashColumns.put("pol_ts", getPolTs());
		this.hashColumns.put("b_ofc_cd_sub", getBOfcCdSub());
		this.hashColumns.put("l_ofc_cd_sub", getLOfcCdSub());
		this.hashColumns.put("board_from_dt", getBoardFromDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("board_to_dt", getBoardToDt());
		this.hashColumns.put("l_ofc_cd", getLOfcCd());
		this.hashColumns.put("eta_to_dt", getEtaToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trunk_flag", getTrunkFlag());
		this.hashColumns.put("pod_ts", getPodTs());
		this.hashColumns.put("warn_cargo_m", getWarnCargoM());
		this.hashColumns.put("c_ofc_cd", getCOfcCd());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("pod_local", getPodLocal());
		this.hashColumns.put("warn_cargo_p", getWarnCargoP());
		this.hashColumns.put("eta_from_dt", getEtaFromDt());
		this.hashColumns.put("warn_cust_y", getWarnCustY());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("warn_cust_i", getWarnCustI());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("warn_cust_s", "warnCustS");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol_local", "polLocal");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("warn_cust_c", "warnCustC");
		this.hashFields.put("b_ofc_cd", "bOfcCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("warn_cust_b", "warnCustB");
		this.hashFields.put("c_ofc_cd_sub", "cOfcCdSub");
		this.hashFields.put("pol_ts", "polTs");
		this.hashFields.put("b_ofc_cd_sub", "bOfcCdSub");
		this.hashFields.put("l_ofc_cd_sub", "lOfcCdSub");
		this.hashFields.put("board_from_dt", "boardFromDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("board_to_dt", "boardToDt");
		this.hashFields.put("l_ofc_cd", "lOfcCd");
		this.hashFields.put("eta_to_dt", "etaToDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trunk_flag", "trunkFlag");
		this.hashFields.put("pod_ts", "podTs");
		this.hashFields.put("warn_cargo_m", "warnCargoM");
		this.hashFields.put("c_ofc_cd", "cOfcCd");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("pod_local", "podLocal");
		this.hashFields.put("warn_cargo_p", "warnCargoP");
		this.hashFields.put("eta_from_dt", "etaFromDt");
		this.hashFields.put("warn_cust_y", "warnCustY");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("warn_cust_i", "warnCustI");
		return this.hashFields;
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
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return warnCustS
	 */
	public String getWarnCustS() {
		return this.warnCustS;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return polLocal
	 */
	public String getPolLocal() {
		return this.polLocal;
	}
	
	/**
	 * Column Info
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	
	/**
	 * Column Info
	 * @return warnCustC
	 */
	public String getWarnCustC() {
		return this.warnCustC;
	}
	
	/**
	 * Column Info
	 * @return bOfcCd
	 */
	public String getBOfcCd() {
		return this.bOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return warnCustB
	 */
	public String getWarnCustB() {
		return this.warnCustB;
	}
	
	/**
	 * Column Info
	 * @return cOfcCdSub
	 */
	public String getCOfcCdSub() {
		return this.cOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @return polTs
	 */
	public String getPolTs() {
		return this.polTs;
	}
	
	/**
	 * Column Info
	 * @return bOfcCdSub
	 */
	public String getBOfcCdSub() {
		return this.bOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @return lOfcCdSub
	 */
	public String getLOfcCdSub() {
		return this.lOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @return boardFromDt
	 */
	public String getBoardFromDt() {
		return this.boardFromDt;
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
	 * @return boardToDt
	 */
	public String getBoardToDt() {
		return this.boardToDt;
	}
	
	/**
	 * Column Info
	 * @return lOfcCd
	 */
	public String getLOfcCd() {
		return this.lOfcCd;
	}
	
	/**
	 * Column Info
	 * @return etaToDt
	 */
	public String getEtaToDt() {
		return this.etaToDt;
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
	 * @return trunkFlag
	 */
	public String getTrunkFlag() {
		return this.trunkFlag;
	}
	
	/**
	 * Column Info
	 * @return podTs
	 */
	public String getPodTs() {
		return this.podTs;
	}
	
	/**
	 * Column Info
	 * @return warnCargoM
	 */
	public String getWarnCargoM() {
		return this.warnCargoM;
	}
	
	/**
	 * Column Info
	 * @return cOfcCd
	 */
	public String getCOfcCd() {
		return this.cOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgFromDt
	 */
	public String getBkgFromDt() {
		return this.bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @return podLocal
	 */
	public String getPodLocal() {
		return this.podLocal;
	}
	
	/**
	 * Column Info
	 * @return warnCargoP
	 */
	public String getWarnCargoP() {
		return this.warnCargoP;
	}
	
	/**
	 * Column Info
	 * @return etaFromDt
	 */
	public String getEtaFromDt() {
		return this.etaFromDt;
	}
	
	/**
	 * Column Info
	 * @return warnCustY
	 */
	public String getWarnCustY() {
		return this.warnCustY;
	}
	

	public String getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public String getCurrPage() {
		return currPage;
	}

	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}


	public void setBOfcCd(String bOfcCd) {
		this.bOfcCd = bOfcCd;
	}

	public String getcOfcCdSub() {
		return cOfcCdSub;
	}

	public void setcOfcCdSub(String cOfcCdSub) {
		this.cOfcCdSub = cOfcCdSub;
	}

	public String getbOfcCdSub() {
		return bOfcCdSub;
	}

	public void setbOfcCdSub(String bOfcCdSub) {
		this.bOfcCdSub = bOfcCdSub;
	}

	public String getlOfcCdSub() {
		return lOfcCdSub;
	}

	public void setlOfcCdSub(String lOfcCdSub) {
		this.lOfcCdSub = lOfcCdSub;
	}

	public String getlOfcCd() {
		return lOfcCd;
	}

	public void setlOfcCd(String lOfcCd) {
		this.lOfcCd = lOfcCd;
	}

	public String getcOfcCd() {
		return cOfcCd;
	}

	public void setcOfcCd(String cOfcCd) {
		this.cOfcCd = cOfcCd;
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
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param warnCustS
	 */
	public void setWarnCustS(String warnCustS) {
		this.warnCustS = warnCustS;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param polLocal
	 */
	public void setPolLocal(String polLocal) {
		this.polLocal = polLocal;
	}
	
	/**
	 * Column Info
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	
	/**
	 * Column Info
	 * @param warnCustC
	 */
	public void setWarnCustC(String warnCustC) {
		this.warnCustC = warnCustC;
	}
	
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param warnCustB
	 */
	public void setWarnCustB(String warnCustB) {
		this.warnCustB = warnCustB;
	}
	
	/**
	 * Column Info
	 * @param cOfcCdSub
	 */
	public void setCOfcCdSub(String cOfcCdSub) {
		this.cOfcCdSub = cOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @param polTs
	 */
	public void setPolTs(String polTs) {
		this.polTs = polTs;
	}
	
	/**
	 * Column Info
	 * @param bOfcCdSub
	 */
	public void setBOfcCdSub(String bOfcCdSub) {
		this.bOfcCdSub = bOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @param lOfcCdSub
	 */
	public void setLOfcCdSub(String lOfcCdSub) {
		this.lOfcCdSub = lOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @param boardFromDt
	 */
	public void setBoardFromDt(String boardFromDt) {
		this.boardFromDt = boardFromDt;
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
	 * @param boardToDt
	 */
	public void setBoardToDt(String boardToDt) {
		this.boardToDt = boardToDt;
	}
	
	/**
	 * Column Info
	 * @param lOfcCd
	 */
	public void setLOfcCd(String lOfcCd) {
		this.lOfcCd = lOfcCd;
	}
	
	/**
	 * Column Info
	 * @param etaToDt
	 */
	public void setEtaToDt(String etaToDt) {
		this.etaToDt = etaToDt;
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
	 * @param trunkFlag
	 */
	public void setTrunkFlag(String trunkFlag) {
		this.trunkFlag = trunkFlag;
	}
	
	/**
	 * Column Info
	 * @param podTs
	 */
	public void setPodTs(String podTs) {
		this.podTs = podTs;
	}
	
	/**
	 * Column Info
	 * @param warnCargoM
	 */
	public void setWarnCargoM(String warnCargoM) {
		this.warnCargoM = warnCargoM;
	}
	
	/**
	 * Column Info
	 * @param cOfcCd
	 */
	public void setCOfcCd(String cOfcCd) {
		this.cOfcCd = cOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgFromDt
	 */
	public void setBkgFromDt(String bkgFromDt) {
		this.bkgFromDt = bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @param podLocal
	 */
	public void setPodLocal(String podLocal) {
		this.podLocal = podLocal;
	}
	
	/**
	 * Column Info
	 * @param warnCargoP
	 */
	public void setWarnCargoP(String warnCargoP) {
		this.warnCargoP = warnCargoP;
	}
	
	/**
	 * Column Info
	 * @param etaFromDt
	 */
	public void setEtaFromDt(String etaFromDt) {
		this.etaFromDt = etaFromDt;
	}
	
	/**
	 * Column Info
	 * @param warnCustY
	 */
	public void setWarnCustY(String warnCustY) {
		this.warnCustY = warnCustY;
	}
	
public String getWarnCustI() {
		return warnCustI;
	}

	public void setWarnCustI(String warnCustI) {
		this.warnCustI = warnCustI;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setWarnCustS(JSPUtil.getParameter(request, prefix + "warn_cust_s", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPolLocal(JSPUtil.getParameter(request, prefix + "pol_local", ""));
		setBkgToDt(JSPUtil.getParameter(request, prefix + "bkg_to_dt", ""));
		setWarnCustC(JSPUtil.getParameter(request, prefix + "warn_cust_c", ""));
		setBOfcCd(JSPUtil.getParameter(request, prefix + "b_ofc_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setWarnCustB(JSPUtil.getParameter(request, prefix + "warn_cust_b", ""));
		setCOfcCdSub(JSPUtil.getParameter(request, prefix + "c_ofc_cd_sub", ""));
		setPolTs(JSPUtil.getParameter(request, prefix + "pol_ts", ""));
		setBOfcCdSub(JSPUtil.getParameter(request, prefix + "b_ofc_cd_sub", ""));
		setLOfcCdSub(JSPUtil.getParameter(request, prefix + "l_ofc_cd_sub", ""));
		setBoardFromDt(JSPUtil.getParameter(request, prefix + "board_from_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBoardToDt(JSPUtil.getParameter(request, prefix + "board_to_dt", ""));
		setLOfcCd(JSPUtil.getParameter(request, prefix + "l_ofc_cd", ""));
		setEtaToDt(JSPUtil.getParameter(request, prefix + "eta_to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTrunkFlag(JSPUtil.getParameter(request, prefix + "trunk_flag", ""));
		setPodTs(JSPUtil.getParameter(request, prefix + "pod_ts", ""));
		setWarnCargoM(JSPUtil.getParameter(request, prefix + "warn_cargo_m", ""));
		setCOfcCd(JSPUtil.getParameter(request, prefix + "c_ofc_cd", ""));
		setBkgFromDt(JSPUtil.getParameter(request, prefix + "bkg_from_dt", ""));
		setPodLocal(JSPUtil.getParameter(request, prefix + "pod_local", ""));
		setWarnCargoP(JSPUtil.getParameter(request, prefix + "warn_cargo_p", ""));
		setEtaFromDt(JSPUtil.getParameter(request, prefix + "eta_from_dt", ""));
		setWarnCustY(JSPUtil.getParameter(request, prefix + "warn_cust_y", ""));
		
		setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setWarnCustI(JSPUtil.getParameter(request, prefix + "warn_cust_i", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WarningReportInVO[]
	 */
	public WarningReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WarningReportInVO[]
	 */
	public WarningReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WarningReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] warnCustS = (JSPUtil.getParameter(request, prefix	+ "warn_cust_s", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] polLocal = (JSPUtil.getParameter(request, prefix	+ "pol_local", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] warnCustC = (JSPUtil.getParameter(request, prefix	+ "warn_cust_c", length));
			String[] bOfcCd = (JSPUtil.getParameter(request, prefix	+ "b_ofc_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] warnCustB = (JSPUtil.getParameter(request, prefix	+ "warn_cust_b", length));
			String[] cOfcCdSub = (JSPUtil.getParameter(request, prefix	+ "c_ofc_cd_sub", length));
			String[] polTs = (JSPUtil.getParameter(request, prefix	+ "pol_ts", length));
			String[] bOfcCdSub = (JSPUtil.getParameter(request, prefix	+ "b_ofc_cd_sub", length));
			String[] lOfcCdSub = (JSPUtil.getParameter(request, prefix	+ "l_ofc_cd_sub", length));
			String[] boardFromDt = (JSPUtil.getParameter(request, prefix	+ "board_from_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] boardToDt = (JSPUtil.getParameter(request, prefix	+ "board_to_dt", length));
			String[] lOfcCd = (JSPUtil.getParameter(request, prefix	+ "l_ofc_cd", length));
			String[] etaToDt = (JSPUtil.getParameter(request, prefix	+ "eta_to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] trunkFlag = (JSPUtil.getParameter(request, prefix	+ "trunk_flag", length));
			String[] podTs = (JSPUtil.getParameter(request, prefix	+ "pod_ts", length));
			String[] warnCargoM = (JSPUtil.getParameter(request, prefix	+ "warn_cargo_m", length));
			String[] cOfcCd = (JSPUtil.getParameter(request, prefix	+ "c_ofc_cd", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] podLocal = (JSPUtil.getParameter(request, prefix	+ "pod_local", length));
			String[] warnCargoP = (JSPUtil.getParameter(request, prefix	+ "warn_cargo_p", length));
			String[] etaFromDt = (JSPUtil.getParameter(request, prefix	+ "eta_from_dt", length));
			String[] warnCustY = (JSPUtil.getParameter(request, prefix	+ "warn_cust_y", length));

			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] warnCustI = (JSPUtil.getParameter(request, prefix	+ "warn_cust_i", length));
			
			for (int i = 0; i < length; i++) {
				model = new WarningReportInVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (warnCustS[i] != null)
					model.setWarnCustS(warnCustS[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (polLocal[i] != null)
					model.setPolLocal(polLocal[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (warnCustC[i] != null)
					model.setWarnCustC(warnCustC[i]);
				if (bOfcCd[i] != null)
					model.setBOfcCd(bOfcCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (warnCustB[i] != null)
					model.setWarnCustB(warnCustB[i]);
				if (cOfcCdSub[i] != null)
					model.setCOfcCdSub(cOfcCdSub[i]);
				if (polTs[i] != null)
					model.setPolTs(polTs[i]);
				if (bOfcCdSub[i] != null)
					model.setBOfcCdSub(bOfcCdSub[i]);
				if (lOfcCdSub[i] != null)
					model.setLOfcCdSub(lOfcCdSub[i]);
				if (boardFromDt[i] != null)
					model.setBoardFromDt(boardFromDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (boardToDt[i] != null)
					model.setBoardToDt(boardToDt[i]);
				if (lOfcCd[i] != null)
					model.setLOfcCd(lOfcCd[i]);
				if (etaToDt[i] != null)
					model.setEtaToDt(etaToDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (trunkFlag[i] != null)
					model.setTrunkFlag(trunkFlag[i]);
				if (podTs[i] != null)
					model.setPodTs(podTs[i]);
				if (warnCargoM[i] != null)
					model.setWarnCargoM(warnCargoM[i]);
				if (cOfcCd[i] != null)
					model.setCOfcCd(cOfcCd[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (podLocal[i] != null)
					model.setPodLocal(podLocal[i]);
				if (warnCargoP[i] != null)
					model.setWarnCargoP(warnCargoP[i]);
				if (etaFromDt[i] != null)
					model.setEtaFromDt(etaFromDt[i]);
				if (warnCustY[i] != null)
					model.setWarnCustY(warnCustY[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (warnCustI[i] != null)
					model.setWarnCustI(warnCustI[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWarningReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WarningReportInVO[]
	 */
	public WarningReportInVO[] getWarningReportInVOs(){
		WarningReportInVO[] vos = (WarningReportInVO[])models.toArray(new WarningReportInVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warnCustS = this.warnCustS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocal = this.polLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warnCustC = this.warnCustC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfcCd = this.bOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warnCustB = this.warnCustB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cOfcCdSub = this.cOfcCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTs = this.polTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfcCdSub = this.bOfcCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOfcCdSub = this.lOfcCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boardFromDt = this.boardFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boardToDt = this.boardToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOfcCd = this.lOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaToDt = this.etaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkFlag = this.trunkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTs = this.podTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warnCargoM = this.warnCargoM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cOfcCd = this.cOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocal = this.podLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warnCargoP = this.warnCargoP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaFromDt = this.etaFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warnCustY = this.warnCustY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warnCustI = this.warnCustI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
