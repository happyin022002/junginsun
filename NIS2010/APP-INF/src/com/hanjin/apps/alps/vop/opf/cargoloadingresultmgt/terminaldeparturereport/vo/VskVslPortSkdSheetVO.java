/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskVslPortSkdSheetVO.java
*@FileTitle : VskVslPortSkdSheetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.10.09 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VskVslPortSkdSheetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskVslPortSkdSheetVO> models = new ArrayList<VskVslPortSkdSheetVO>();
	
	/* Column Info */
	private String arrTugboat = null;
	/* Column Info */
	private String berth = null;
	/* Column Info */
	private String arrLowSulDo = null;
	/* Column Info */
	private String arrDraftAft = null;
	/* Column Info */
	private String firstPilotOn = null;
	/* Column Info */
	private String arrLowSulFo = null;
	/* Column Info */
	private String depDwt = null;
	/* Column Info */
	private String etaNextPort = null;
	/* Column Info */
	private String depBallast = null;
	/* Column Info */
	private String depRobFo = null;
	/* Column Info */
	private String depLowSulDoWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arrDwt = null;
	/* Column Info */
	private String lastPilotOff = null;
	/* Column Info */
	private String depTugboat = null;
	/* Column Info */
	private String depGm = null;
	/* Column Info */
	private String depSlpFw = null;
	/* Column Info */
	private String depSlpDo = null;
	/* Column Info */
	private String anchorageDep = null;
	/* Column Info */
	private String depLowSulDo = null;
	/* Column Info */
	private String arrRobFw = null;
	/* Column Info */
	private String depDispl = null;
	/* Column Info */
	private String depSlpFo = null;
	/* Column Info */
	private String arrDraftFwd = null;
	/* Column Info */
	private String depLowSulFoWgt = null;
	/* Column Info */
	private String anchorageArr = null;
	/* Column Info */
	private String arrGm = null;
	/* Column Info */
	private String arrRobFo = null;
	/* Column Info */
	private String unberth = null;
	/* Column Info */
	private String depRobFw = null;
	/* Column Info */
	private String arrBallast = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String depDraftFwd = null;
	/* Column Info */
	private String depLowSulFo = null;
	/* Column Info */
	private String etaNextDate = null;
	/* Column Info */
	private String depDraftAft = null;
	/* Column Info */
	private String arrDisplt = null;
	/* Column Info */
	private String depRobDo = null;
	/* Column Info */
	private String arrRobDo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VskVslPortSkdSheetVO() {}

	public VskVslPortSkdSheetVO(String ibflag, String pagerows, String clptIndSeq, String firstPilotOn, String anchorageArr, String berth, String etaNextPort, String etaNextDate, String unberth, String anchorageDep, String lastPilotOff, String arrDraftFwd, String arrDraftAft, String depDraftFwd, String depDraftAft, String arrBallast, String depBallast, String arrRobFo, String arrRobDo, String arrRobFw, String depRobFo, String depRobDo, String depRobFw, String arrLowSulFo, String arrLowSulDo, String depLowSulFo, String depLowSulDo, String depSlpFo, String depSlpDo, String depSlpFw, String depLowSulFoWgt, String depLowSulDoWgt, String arrDwt, String arrDisplt, String depDwt, String depDispl, String arrGm, String depGm, String arrTugboat, String depTugboat) {
		this.arrTugboat = arrTugboat;
		this.berth = berth;
		this.arrLowSulDo = arrLowSulDo;
		this.arrDraftAft = arrDraftAft;
		this.firstPilotOn = firstPilotOn;
		this.arrLowSulFo = arrLowSulFo;
		this.depDwt = depDwt;
		this.etaNextPort = etaNextPort;
		this.depBallast = depBallast;
		this.depRobFo = depRobFo;
		this.depLowSulDoWgt = depLowSulDoWgt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.arrDwt = arrDwt;
		this.lastPilotOff = lastPilotOff;
		this.depTugboat = depTugboat;
		this.depGm = depGm;
		this.depSlpFw = depSlpFw;
		this.depSlpDo = depSlpDo;
		this.anchorageDep = anchorageDep;
		this.depLowSulDo = depLowSulDo;
		this.arrRobFw = arrRobFw;
		this.depDispl = depDispl;
		this.depSlpFo = depSlpFo;
		this.arrDraftFwd = arrDraftFwd;
		this.depLowSulFoWgt = depLowSulFoWgt;
		this.anchorageArr = anchorageArr;
		this.arrGm = arrGm;
		this.arrRobFo = arrRobFo;
		this.unberth = unberth;
		this.depRobFw = depRobFw;
		this.arrBallast = arrBallast;
		this.clptIndSeq = clptIndSeq;
		this.depDraftFwd = depDraftFwd;
		this.depLowSulFo = depLowSulFo;
		this.etaNextDate = etaNextDate;
		this.depDraftAft = depDraftAft;
		this.arrDisplt = arrDisplt;
		this.depRobDo = depRobDo;
		this.arrRobDo = arrRobDo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("arr_tugboat", getArrTugboat());
		this.hashColumns.put("berth", getBerth());
		this.hashColumns.put("arr_low_sul_do", getArrLowSulDo());
		this.hashColumns.put("arr_draft_aft", getArrDraftAft());
		this.hashColumns.put("first_pilot_on", getFirstPilotOn());
		this.hashColumns.put("arr_low_sul_fo", getArrLowSulFo());
		this.hashColumns.put("dep_dwt", getDepDwt());
		this.hashColumns.put("eta_next_port", getEtaNextPort());
		this.hashColumns.put("dep_ballast", getDepBallast());
		this.hashColumns.put("dep_rob_fo", getDepRobFo());
		this.hashColumns.put("dep_low_sul_do_wgt", getDepLowSulDoWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("arr_dwt", getArrDwt());
		this.hashColumns.put("last_pilot_off", getLastPilotOff());
		this.hashColumns.put("dep_tugboat", getDepTugboat());
		this.hashColumns.put("dep_gm", getDepGm());
		this.hashColumns.put("dep_slp_fw", getDepSlpFw());
		this.hashColumns.put("dep_slp_do", getDepSlpDo());
		this.hashColumns.put("anchorage_dep", getAnchorageDep());
		this.hashColumns.put("dep_low_sul_do", getDepLowSulDo());
		this.hashColumns.put("arr_rob_fw", getArrRobFw());
		this.hashColumns.put("dep_displ", getDepDispl());
		this.hashColumns.put("dep_slp_fo", getDepSlpFo());
		this.hashColumns.put("arr_draft_fwd", getArrDraftFwd());
		this.hashColumns.put("dep_low_sul_fo_wgt", getDepLowSulFoWgt());
		this.hashColumns.put("anchorage_arr", getAnchorageArr());
		this.hashColumns.put("arr_gm", getArrGm());
		this.hashColumns.put("arr_rob_fo", getArrRobFo());
		this.hashColumns.put("unberth", getUnberth());
		this.hashColumns.put("dep_rob_fw", getDepRobFw());
		this.hashColumns.put("arr_ballast", getArrBallast());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("dep_draft_fwd", getDepDraftFwd());
		this.hashColumns.put("dep_low_sul_fo", getDepLowSulFo());
		this.hashColumns.put("eta_next_date", getEtaNextDate());
		this.hashColumns.put("dep_draft_aft", getDepDraftAft());
		this.hashColumns.put("arr_displt", getArrDisplt());
		this.hashColumns.put("dep_rob_do", getDepRobDo());
		this.hashColumns.put("arr_rob_do", getArrRobDo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("arr_tugboat", "arrTugboat");
		this.hashFields.put("berth", "berth");
		this.hashFields.put("arr_low_sul_do", "arrLowSulDo");
		this.hashFields.put("arr_draft_aft", "arrDraftAft");
		this.hashFields.put("first_pilot_on", "firstPilotOn");
		this.hashFields.put("arr_low_sul_fo", "arrLowSulFo");
		this.hashFields.put("dep_dwt", "depDwt");
		this.hashFields.put("eta_next_port", "etaNextPort");
		this.hashFields.put("dep_ballast", "depBallast");
		this.hashFields.put("dep_rob_fo", "depRobFo");
		this.hashFields.put("dep_low_sul_do_wgt", "depLowSulDoWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("arr_dwt", "arrDwt");
		this.hashFields.put("last_pilot_off", "lastPilotOff");
		this.hashFields.put("dep_tugboat", "depTugboat");
		this.hashFields.put("dep_gm", "depGm");
		this.hashFields.put("dep_slp_fw", "depSlpFw");
		this.hashFields.put("dep_slp_do", "depSlpDo");
		this.hashFields.put("anchorage_dep", "anchorageDep");
		this.hashFields.put("dep_low_sul_do", "depLowSulDo");
		this.hashFields.put("arr_rob_fw", "arrRobFw");
		this.hashFields.put("dep_displ", "depDispl");
		this.hashFields.put("dep_slp_fo", "depSlpFo");
		this.hashFields.put("arr_draft_fwd", "arrDraftFwd");
		this.hashFields.put("dep_low_sul_fo_wgt", "depLowSulFoWgt");
		this.hashFields.put("anchorage_arr", "anchorageArr");
		this.hashFields.put("arr_gm", "arrGm");
		this.hashFields.put("arr_rob_fo", "arrRobFo");
		this.hashFields.put("unberth", "unberth");
		this.hashFields.put("dep_rob_fw", "depRobFw");
		this.hashFields.put("arr_ballast", "arrBallast");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("dep_draft_fwd", "depDraftFwd");
		this.hashFields.put("dep_low_sul_fo", "depLowSulFo");
		this.hashFields.put("eta_next_date", "etaNextDate");
		this.hashFields.put("dep_draft_aft", "depDraftAft");
		this.hashFields.put("arr_displt", "arrDisplt");
		this.hashFields.put("dep_rob_do", "depRobDo");
		this.hashFields.put("arr_rob_do", "arrRobDo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return arrTugboat
	 */
	public String getArrTugboat() {
		return this.arrTugboat;
	}
	
	/**
	 * Column Info
	 * @return berth
	 */
	public String getBerth() {
		return this.berth;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulDo
	 */
	public String getArrLowSulDo() {
		return this.arrLowSulDo;
	}
	
	/**
	 * Column Info
	 * @return arrDraftAft
	 */
	public String getArrDraftAft() {
		return this.arrDraftAft;
	}
	
	/**
	 * Column Info
	 * @return firstPilotOn
	 */
	public String getFirstPilotOn() {
		return this.firstPilotOn;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulFo
	 */
	public String getArrLowSulFo() {
		return this.arrLowSulFo;
	}
	
	/**
	 * Column Info
	 * @return depDwt
	 */
	public String getDepDwt() {
		return this.depDwt;
	}
	
	/**
	 * Column Info
	 * @return etaNextPort
	 */
	public String getEtaNextPort() {
		return this.etaNextPort;
	}
	
	/**
	 * Column Info
	 * @return depBallast
	 */
	public String getDepBallast() {
		return this.depBallast;
	}
	
	/**
	 * Column Info
	 * @return depRobFo
	 */
	public String getDepRobFo() {
		return this.depRobFo;
	}
	
	/**
	 * Column Info
	 * @return depLowSulDoWgt
	 */
	public String getDepLowSulDoWgt() {
		return this.depLowSulDoWgt;
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
	 * @return arrDwt
	 */
	public String getArrDwt() {
		return this.arrDwt;
	}
	
	/**
	 * Column Info
	 * @return lastPilotOff
	 */
	public String getLastPilotOff() {
		return this.lastPilotOff;
	}
	
	/**
	 * Column Info
	 * @return depTugboat
	 */
	public String getDepTugboat() {
		return this.depTugboat;
	}
	
	/**
	 * Column Info
	 * @return depGm
	 */
	public String getDepGm() {
		return this.depGm;
	}
	
	/**
	 * Column Info
	 * @return depSlpFw
	 */
	public String getDepSlpFw() {
		return this.depSlpFw;
	}
	
	/**
	 * Column Info
	 * @return depSlpDo
	 */
	public String getDepSlpDo() {
		return this.depSlpDo;
	}
	
	/**
	 * Column Info
	 * @return anchorageDep
	 */
	public String getAnchorageDep() {
		return this.anchorageDep;
	}
	
	/**
	 * Column Info
	 * @return depLowSulDo
	 */
	public String getDepLowSulDo() {
		return this.depLowSulDo;
	}
	
	/**
	 * Column Info
	 * @return arrRobFw
	 */
	public String getArrRobFw() {
		return this.arrRobFw;
	}
	
	/**
	 * Column Info
	 * @return depDispl
	 */
	public String getDepDispl() {
		return this.depDispl;
	}
	
	/**
	 * Column Info
	 * @return depSlpFo
	 */
	public String getDepSlpFo() {
		return this.depSlpFo;
	}
	
	/**
	 * Column Info
	 * @return arrDraftFwd
	 */
	public String getArrDraftFwd() {
		return this.arrDraftFwd;
	}
	
	/**
	 * Column Info
	 * @return depLowSulFoWgt
	 */
	public String getDepLowSulFoWgt() {
		return this.depLowSulFoWgt;
	}
	
	/**
	 * Column Info
	 * @return anchorageArr
	 */
	public String getAnchorageArr() {
		return this.anchorageArr;
	}
	
	/**
	 * Column Info
	 * @return arrGm
	 */
	public String getArrGm() {
		return this.arrGm;
	}
	
	/**
	 * Column Info
	 * @return arrRobFo
	 */
	public String getArrRobFo() {
		return this.arrRobFo;
	}
	
	/**
	 * Column Info
	 * @return unberth
	 */
	public String getUnberth() {
		return this.unberth;
	}
	
	/**
	 * Column Info
	 * @return depRobFw
	 */
	public String getDepRobFw() {
		return this.depRobFw;
	}
	
	/**
	 * Column Info
	 * @return arrBallast
	 */
	public String getArrBallast() {
		return this.arrBallast;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return depDraftFwd
	 */
	public String getDepDraftFwd() {
		return this.depDraftFwd;
	}
	
	/**
	 * Column Info
	 * @return depLowSulFo
	 */
	public String getDepLowSulFo() {
		return this.depLowSulFo;
	}
	
	/**
	 * Column Info
	 * @return etaNextDate
	 */
	public String getEtaNextDate() {
		return this.etaNextDate;
	}
	
	/**
	 * Column Info
	 * @return depDraftAft
	 */
	public String getDepDraftAft() {
		return this.depDraftAft;
	}
	
	/**
	 * Column Info
	 * @return arrDisplt
	 */
	public String getArrDisplt() {
		return this.arrDisplt;
	}
	
	/**
	 * Column Info
	 * @return depRobDo
	 */
	public String getDepRobDo() {
		return this.depRobDo;
	}
	
	/**
	 * Column Info
	 * @return arrRobDo
	 */
	public String getArrRobDo() {
		return this.arrRobDo;
	}
	

	/**
	 * Column Info
	 * @param arrTugboat
	 */
	public void setArrTugboat(String arrTugboat) {
		this.arrTugboat = arrTugboat;
	}
	
	/**
	 * Column Info
	 * @param berth
	 */
	public void setBerth(String berth) {
		this.berth = berth;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulDo
	 */
	public void setArrLowSulDo(String arrLowSulDo) {
		this.arrLowSulDo = arrLowSulDo;
	}
	
	/**
	 * Column Info
	 * @param arrDraftAft
	 */
	public void setArrDraftAft(String arrDraftAft) {
		this.arrDraftAft = arrDraftAft;
	}
	
	/**
	 * Column Info
	 * @param firstPilotOn
	 */
	public void setFirstPilotOn(String firstPilotOn) {
		this.firstPilotOn = firstPilotOn;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulFo
	 */
	public void setArrLowSulFo(String arrLowSulFo) {
		this.arrLowSulFo = arrLowSulFo;
	}
	
	/**
	 * Column Info
	 * @param depDwt
	 */
	public void setDepDwt(String depDwt) {
		this.depDwt = depDwt;
	}
	
	/**
	 * Column Info
	 * @param etaNextPort
	 */
	public void setEtaNextPort(String etaNextPort) {
		this.etaNextPort = etaNextPort;
	}
	
	/**
	 * Column Info
	 * @param depBallast
	 */
	public void setDepBallast(String depBallast) {
		this.depBallast = depBallast;
	}
	
	/**
	 * Column Info
	 * @param depRobFo
	 */
	public void setDepRobFo(String depRobFo) {
		this.depRobFo = depRobFo;
	}
	
	/**
	 * Column Info
	 * @param depLowSulDoWgt
	 */
	public void setDepLowSulDoWgt(String depLowSulDoWgt) {
		this.depLowSulDoWgt = depLowSulDoWgt;
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
	 * @param arrDwt
	 */
	public void setArrDwt(String arrDwt) {
		this.arrDwt = arrDwt;
	}
	
	/**
	 * Column Info
	 * @param lastPilotOff
	 */
	public void setLastPilotOff(String lastPilotOff) {
		this.lastPilotOff = lastPilotOff;
	}
	
	/**
	 * Column Info
	 * @param depTugboat
	 */
	public void setDepTugboat(String depTugboat) {
		this.depTugboat = depTugboat;
	}
	
	/**
	 * Column Info
	 * @param depGm
	 */
	public void setDepGm(String depGm) {
		this.depGm = depGm;
	}
	
	/**
	 * Column Info
	 * @param depSlpFw
	 */
	public void setDepSlpFw(String depSlpFw) {
		this.depSlpFw = depSlpFw;
	}
	
	/**
	 * Column Info
	 * @param depSlpDo
	 */
	public void setDepSlpDo(String depSlpDo) {
		this.depSlpDo = depSlpDo;
	}
	
	/**
	 * Column Info
	 * @param anchorageDep
	 */
	public void setAnchorageDep(String anchorageDep) {
		this.anchorageDep = anchorageDep;
	}
	
	/**
	 * Column Info
	 * @param depLowSulDo
	 */
	public void setDepLowSulDo(String depLowSulDo) {
		this.depLowSulDo = depLowSulDo;
	}
	
	/**
	 * Column Info
	 * @param arrRobFw
	 */
	public void setArrRobFw(String arrRobFw) {
		this.arrRobFw = arrRobFw;
	}
	
	/**
	 * Column Info
	 * @param depDispl
	 */
	public void setDepDispl(String depDispl) {
		this.depDispl = depDispl;
	}
	
	/**
	 * Column Info
	 * @param depSlpFo
	 */
	public void setDepSlpFo(String depSlpFo) {
		this.depSlpFo = depSlpFo;
	}
	
	/**
	 * Column Info
	 * @param arrDraftFwd
	 */
	public void setArrDraftFwd(String arrDraftFwd) {
		this.arrDraftFwd = arrDraftFwd;
	}
	
	/**
	 * Column Info
	 * @param depLowSulFoWgt
	 */
	public void setDepLowSulFoWgt(String depLowSulFoWgt) {
		this.depLowSulFoWgt = depLowSulFoWgt;
	}
	
	/**
	 * Column Info
	 * @param anchorageArr
	 */
	public void setAnchorageArr(String anchorageArr) {
		this.anchorageArr = anchorageArr;
	}
	
	/**
	 * Column Info
	 * @param arrGm
	 */
	public void setArrGm(String arrGm) {
		this.arrGm = arrGm;
	}
	
	/**
	 * Column Info
	 * @param arrRobFo
	 */
	public void setArrRobFo(String arrRobFo) {
		this.arrRobFo = arrRobFo;
	}
	
	/**
	 * Column Info
	 * @param unberth
	 */
	public void setUnberth(String unberth) {
		this.unberth = unberth;
	}
	
	/**
	 * Column Info
	 * @param depRobFw
	 */
	public void setDepRobFw(String depRobFw) {
		this.depRobFw = depRobFw;
	}
	
	/**
	 * Column Info
	 * @param arrBallast
	 */
	public void setArrBallast(String arrBallast) {
		this.arrBallast = arrBallast;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param depDraftFwd
	 */
	public void setDepDraftFwd(String depDraftFwd) {
		this.depDraftFwd = depDraftFwd;
	}
	
	/**
	 * Column Info
	 * @param depLowSulFo
	 */
	public void setDepLowSulFo(String depLowSulFo) {
		this.depLowSulFo = depLowSulFo;
	}
	
	/**
	 * Column Info
	 * @param etaNextDate
	 */
	public void setEtaNextDate(String etaNextDate) {
		this.etaNextDate = etaNextDate;
	}
	
	/**
	 * Column Info
	 * @param depDraftAft
	 */
	public void setDepDraftAft(String depDraftAft) {
		this.depDraftAft = depDraftAft;
	}
	
	/**
	 * Column Info
	 * @param arrDisplt
	 */
	public void setArrDisplt(String arrDisplt) {
		this.arrDisplt = arrDisplt;
	}
	
	/**
	 * Column Info
	 * @param depRobDo
	 */
	public void setDepRobDo(String depRobDo) {
		this.depRobDo = depRobDo;
	}
	
	/**
	 * Column Info
	 * @param arrRobDo
	 */
	public void setArrRobDo(String arrRobDo) {
		this.arrRobDo = arrRobDo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setArrTugboat(JSPUtil.getParameter(request, "arr_tugboat", ""));
		setBerth(JSPUtil.getParameter(request, "berth", ""));
		setArrLowSulDo(JSPUtil.getParameter(request, "arr_low_sul_do", ""));
		setArrDraftAft(JSPUtil.getParameter(request, "arr_draft_aft", ""));
		setFirstPilotOn(JSPUtil.getParameter(request, "first_pilot_on", ""));
		setArrLowSulFo(JSPUtil.getParameter(request, "arr_low_sul_fo", ""));
		setDepDwt(JSPUtil.getParameter(request, "dep_dwt", ""));
		setEtaNextPort(JSPUtil.getParameter(request, "eta_next_port", ""));
		setDepBallast(JSPUtil.getParameter(request, "dep_ballast", ""));
		setDepRobFo(JSPUtil.getParameter(request, "dep_rob_fo", ""));
		setDepLowSulDoWgt(JSPUtil.getParameter(request, "dep_low_sul_do_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setArrDwt(JSPUtil.getParameter(request, "arr_dwt", ""));
		setLastPilotOff(JSPUtil.getParameter(request, "last_pilot_off", ""));
		setDepTugboat(JSPUtil.getParameter(request, "dep_tugboat", ""));
		setDepGm(JSPUtil.getParameter(request, "dep_gm", ""));
		setDepSlpFw(JSPUtil.getParameter(request, "dep_slp_fw", ""));
		setDepSlpDo(JSPUtil.getParameter(request, "dep_slp_do", ""));
		setAnchorageDep(JSPUtil.getParameter(request, "anchorage_dep", ""));
		setDepLowSulDo(JSPUtil.getParameter(request, "dep_low_sul_do", ""));
		setArrRobFw(JSPUtil.getParameter(request, "arr_rob_fw", ""));
		setDepDispl(JSPUtil.getParameter(request, "dep_displ", ""));
		setDepSlpFo(JSPUtil.getParameter(request, "dep_slp_fo", ""));
		setArrDraftFwd(JSPUtil.getParameter(request, "arr_draft_fwd", ""));
		setDepLowSulFoWgt(JSPUtil.getParameter(request, "dep_low_sul_fo_wgt", ""));
		setAnchorageArr(JSPUtil.getParameter(request, "anchorage_arr", ""));
		setArrGm(JSPUtil.getParameter(request, "arr_gm", ""));
		setArrRobFo(JSPUtil.getParameter(request, "arr_rob_fo", ""));
		setUnberth(JSPUtil.getParameter(request, "unberth", ""));
		setDepRobFw(JSPUtil.getParameter(request, "dep_rob_fw", ""));
		setArrBallast(JSPUtil.getParameter(request, "arr_ballast", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setDepDraftFwd(JSPUtil.getParameter(request, "dep_draft_fwd", ""));
		setDepLowSulFo(JSPUtil.getParameter(request, "dep_low_sul_fo", ""));
		setEtaNextDate(JSPUtil.getParameter(request, "eta_next_date", ""));
		setDepDraftAft(JSPUtil.getParameter(request, "dep_draft_aft", ""));
		setArrDisplt(JSPUtil.getParameter(request, "arr_displt", ""));
		setDepRobDo(JSPUtil.getParameter(request, "dep_rob_do", ""));
		setArrRobDo(JSPUtil.getParameter(request, "arr_rob_do", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskVslPortSkdSheetVO[]
	 */
	public VskVslPortSkdSheetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskVslPortSkdSheetVO[]
	 */
	public VskVslPortSkdSheetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskVslPortSkdSheetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] arrTugboat = (JSPUtil.getParameter(request, prefix	+ "arr_tugboat", length));
			String[] berth = (JSPUtil.getParameter(request, prefix	+ "berth", length));
			String[] arrLowSulDo = (JSPUtil.getParameter(request, prefix	+ "arr_low_sul_do", length));
			String[] arrDraftAft = (JSPUtil.getParameter(request, prefix	+ "arr_draft_aft", length));
			String[] firstPilotOn = (JSPUtil.getParameter(request, prefix	+ "first_pilot_on", length));
			String[] arrLowSulFo = (JSPUtil.getParameter(request, prefix	+ "arr_low_sul_fo", length));
			String[] depDwt = (JSPUtil.getParameter(request, prefix	+ "dep_dwt", length));
			String[] etaNextPort = (JSPUtil.getParameter(request, prefix	+ "eta_next_port", length));
			String[] depBallast = (JSPUtil.getParameter(request, prefix	+ "dep_ballast", length));
			String[] depRobFo = (JSPUtil.getParameter(request, prefix	+ "dep_rob_fo", length));
			String[] depLowSulDoWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sul_do_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arrDwt = (JSPUtil.getParameter(request, prefix	+ "arr_dwt", length));
			String[] lastPilotOff = (JSPUtil.getParameter(request, prefix	+ "last_pilot_off", length));
			String[] depTugboat = (JSPUtil.getParameter(request, prefix	+ "dep_tugboat", length));
			String[] depGm = (JSPUtil.getParameter(request, prefix	+ "dep_gm", length));
			String[] depSlpFw = (JSPUtil.getParameter(request, prefix	+ "dep_slp_fw", length));
			String[] depSlpDo = (JSPUtil.getParameter(request, prefix	+ "dep_slp_do", length));
			String[] anchorageDep = (JSPUtil.getParameter(request, prefix	+ "anchorage_dep", length));
			String[] depLowSulDo = (JSPUtil.getParameter(request, prefix	+ "dep_low_sul_do", length));
			String[] arrRobFw = (JSPUtil.getParameter(request, prefix	+ "arr_rob_fw", length));
			String[] depDispl = (JSPUtil.getParameter(request, prefix	+ "dep_displ", length));
			String[] depSlpFo = (JSPUtil.getParameter(request, prefix	+ "dep_slp_fo", length));
			String[] arrDraftFwd = (JSPUtil.getParameter(request, prefix	+ "arr_draft_fwd", length));
			String[] depLowSulFoWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sul_fo_wgt", length));
			String[] anchorageArr = (JSPUtil.getParameter(request, prefix	+ "anchorage_arr", length));
			String[] arrGm = (JSPUtil.getParameter(request, prefix	+ "arr_gm", length));
			String[] arrRobFo = (JSPUtil.getParameter(request, prefix	+ "arr_rob_fo", length));
			String[] unberth = (JSPUtil.getParameter(request, prefix	+ "unberth", length));
			String[] depRobFw = (JSPUtil.getParameter(request, prefix	+ "dep_rob_fw", length));
			String[] arrBallast = (JSPUtil.getParameter(request, prefix	+ "arr_ballast", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] depDraftFwd = (JSPUtil.getParameter(request, prefix	+ "dep_draft_fwd", length));
			String[] depLowSulFo = (JSPUtil.getParameter(request, prefix	+ "dep_low_sul_fo", length));
			String[] etaNextDate = (JSPUtil.getParameter(request, prefix	+ "eta_next_date", length));
			String[] depDraftAft = (JSPUtil.getParameter(request, prefix	+ "dep_draft_aft", length));
			String[] arrDisplt = (JSPUtil.getParameter(request, prefix	+ "arr_displt", length));
			String[] depRobDo = (JSPUtil.getParameter(request, prefix	+ "dep_rob_do", length));
			String[] arrRobDo = (JSPUtil.getParameter(request, prefix	+ "arr_rob_do", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskVslPortSkdSheetVO();
				if (arrTugboat[i] != null)
					model.setArrTugboat(arrTugboat[i]);
				if (berth[i] != null)
					model.setBerth(berth[i]);
				if (arrLowSulDo[i] != null)
					model.setArrLowSulDo(arrLowSulDo[i]);
				if (arrDraftAft[i] != null)
					model.setArrDraftAft(arrDraftAft[i]);
				if (firstPilotOn[i] != null)
					model.setFirstPilotOn(firstPilotOn[i]);
				if (arrLowSulFo[i] != null)
					model.setArrLowSulFo(arrLowSulFo[i]);
				if (depDwt[i] != null)
					model.setDepDwt(depDwt[i]);
				if (etaNextPort[i] != null)
					model.setEtaNextPort(etaNextPort[i]);
				if (depBallast[i] != null)
					model.setDepBallast(depBallast[i]);
				if (depRobFo[i] != null)
					model.setDepRobFo(depRobFo[i]);
				if (depLowSulDoWgt[i] != null)
					model.setDepLowSulDoWgt(depLowSulDoWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arrDwt[i] != null)
					model.setArrDwt(arrDwt[i]);
				if (lastPilotOff[i] != null)
					model.setLastPilotOff(lastPilotOff[i]);
				if (depTugboat[i] != null)
					model.setDepTugboat(depTugboat[i]);
				if (depGm[i] != null)
					model.setDepGm(depGm[i]);
				if (depSlpFw[i] != null)
					model.setDepSlpFw(depSlpFw[i]);
				if (depSlpDo[i] != null)
					model.setDepSlpDo(depSlpDo[i]);
				if (anchorageDep[i] != null)
					model.setAnchorageDep(anchorageDep[i]);
				if (depLowSulDo[i] != null)
					model.setDepLowSulDo(depLowSulDo[i]);
				if (arrRobFw[i] != null)
					model.setArrRobFw(arrRobFw[i]);
				if (depDispl[i] != null)
					model.setDepDispl(depDispl[i]);
				if (depSlpFo[i] != null)
					model.setDepSlpFo(depSlpFo[i]);
				if (arrDraftFwd[i] != null)
					model.setArrDraftFwd(arrDraftFwd[i]);
				if (depLowSulFoWgt[i] != null)
					model.setDepLowSulFoWgt(depLowSulFoWgt[i]);
				if (anchorageArr[i] != null)
					model.setAnchorageArr(anchorageArr[i]);
				if (arrGm[i] != null)
					model.setArrGm(arrGm[i]);
				if (arrRobFo[i] != null)
					model.setArrRobFo(arrRobFo[i]);
				if (unberth[i] != null)
					model.setUnberth(unberth[i]);
				if (depRobFw[i] != null)
					model.setDepRobFw(depRobFw[i]);
				if (arrBallast[i] != null)
					model.setArrBallast(arrBallast[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (depDraftFwd[i] != null)
					model.setDepDraftFwd(depDraftFwd[i]);
				if (depLowSulFo[i] != null)
					model.setDepLowSulFo(depLowSulFo[i]);
				if (etaNextDate[i] != null)
					model.setEtaNextDate(etaNextDate[i]);
				if (depDraftAft[i] != null)
					model.setDepDraftAft(depDraftAft[i]);
				if (arrDisplt[i] != null)
					model.setArrDisplt(arrDisplt[i]);
				if (depRobDo[i] != null)
					model.setDepRobDo(depRobDo[i]);
				if (arrRobDo[i] != null)
					model.setArrRobDo(arrRobDo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskVslPortSkdSheetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskVslPortSkdSheetVO[]
	 */
	public VskVslPortSkdSheetVO[] getVskVslPortSkdSheetVOs(){
		VskVslPortSkdSheetVO[] vos = (VskVslPortSkdSheetVO[])models.toArray(new VskVslPortSkdSheetVO[models.size()]);
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
		this.arrTugboat = this.arrTugboat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.berth = this.berth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulDo = this.arrLowSulDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDraftAft = this.arrDraftAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPilotOn = this.firstPilotOn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulFo = this.arrLowSulFo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDwt = this.depDwt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaNextPort = this.etaNextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depBallast = this.depBallast .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRobFo = this.depRobFo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulDoWgt = this.depLowSulDoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDwt = this.arrDwt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPilotOff = this.lastPilotOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depTugboat = this.depTugboat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depGm = this.depGm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depSlpFw = this.depSlpFw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depSlpDo = this.depSlpDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anchorageDep = this.anchorageDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulDo = this.depLowSulDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrRobFw = this.arrRobFw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDispl = this.depDispl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depSlpFo = this.depSlpFo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDraftFwd = this.arrDraftFwd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulFoWgt = this.depLowSulFoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anchorageArr = this.anchorageArr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGm = this.arrGm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrRobFo = this.arrRobFo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unberth = this.unberth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRobFw = this.depRobFw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBallast = this.arrBallast .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDraftFwd = this.depDraftFwd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulFo = this.depLowSulFo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaNextDate = this.etaNextDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDraftAft = this.depDraftAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDisplt = this.arrDisplt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRobDo = this.depRobDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrRobDo = this.arrRobDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
