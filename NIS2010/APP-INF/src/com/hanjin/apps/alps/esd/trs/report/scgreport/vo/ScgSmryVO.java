/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgSmryVO.java
*@FileTitle : ScgSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.scgreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgSmryVO> models = new ArrayList<ScgSmryVO>();
	
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String other = null;
	/* Column Info */
	private String boxCount = null;
	/* Column Info */
	private String dropPull = null;
	/* Column Info */
	private String inspection = null;
	/* Column Info */
	private String prePull = null;
	/* Column Info */
	private String bargeLow = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String ensf = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ferryCost = null;
	/* Column Info */
	private String chassis = null;
	/* Column Info */
	private String hazmat = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scaleStop = null;
	/* Column Info */
	private String dryRun = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String tDoc = null;
	/* Column Info */
	private String overSize = null;
	/* Column Info */
	private String fine = null;
	/* Column Info */
	private String multiple = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String addLabor = null;
	/* Column Info */
	private String waitingCharge = null;
	/* Column Info */
	private String fumigation = null;
	/* Column Info */
	private String redirection = null;
	/* Column Info */
	private String overWeight = null;
	/* Column Info */
	private String streetTurn = null;
	/* Column Info */
	private String swingFlip = null;
	/* Column Info */
	private String genSet = null;
	/* Column Info */
	private String toll = null;
	/* Column Info */
	private String sunday = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String lifting = null;
	/* Column Info */
	private String storage = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgSmryVO() {}

	public ScgSmryVO(String ibflag, String pagerows, String woOfcCd, String invOfcCd, String month, String boxCount, String curr, String totAmt, String addLabor, String bargeLow, String chassis, String dropPull, String dryRun, String ferryCost, String fine, String fumigation, String genSet, String hazmat, String inspection, String lifting, String multiple, String overSize, String overWeight, String prePull, String redirection, String scaleStop, String storage, String streetTurn, String sunday, String swingFlip, String tDoc, String toll, String waitingCharge, String other, String ensf) {
		this.totAmt = totAmt;
		this.other = other;
		this.boxCount = boxCount;
		this.dropPull = dropPull;
		this.inspection = inspection;
		this.prePull = prePull;
		this.bargeLow = bargeLow;
		this.woOfcCd = woOfcCd;
		this.ensf = ensf;
		this.pagerows = pagerows;
		this.ferryCost = ferryCost;
		this.chassis = chassis;
		this.hazmat = hazmat;
		this.ibflag = ibflag;
		this.scaleStop = scaleStop;
		this.dryRun = dryRun;
		this.curr = curr;
		this.tDoc = tDoc;
		this.overSize = overSize;
		this.fine = fine;
		this.multiple = multiple;
		this.invOfcCd = invOfcCd;
		this.addLabor = addLabor;
		this.waitingCharge = waitingCharge;
		this.fumigation = fumigation;
		this.redirection = redirection;
		this.overWeight = overWeight;
		this.streetTurn = streetTurn;
		this.swingFlip = swingFlip;
		this.genSet = genSet;
		this.toll = toll;
		this.sunday = sunday;
		this.month = month;
		this.lifting = lifting;
		this.storage = storage;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("other", getOther());
		this.hashColumns.put("box_count", getBoxCount());
		this.hashColumns.put("drop_pull", getDropPull());
		this.hashColumns.put("inspection", getInspection());
		this.hashColumns.put("pre_pull", getPrePull());
		this.hashColumns.put("barge_low", getBargeLow());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("ensf", getEnsf());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ferry_cost", getFerryCost());
		this.hashColumns.put("chassis", getChassis());
		this.hashColumns.put("hazmat", getHazmat());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scale_stop", getScaleStop());
		this.hashColumns.put("dry_run", getDryRun());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("t_doc", getTDoc());
		this.hashColumns.put("over_size", getOverSize());
		this.hashColumns.put("fine", getFine());
		this.hashColumns.put("multiple", getMultiple());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("add_labor", getAddLabor());
		this.hashColumns.put("waiting_charge", getWaitingCharge());
		this.hashColumns.put("fumigation", getFumigation());
		this.hashColumns.put("redirection", getRedirection());
		this.hashColumns.put("over_weight", getOverWeight());
		this.hashColumns.put("street_turn", getStreetTurn());
		this.hashColumns.put("swing_flip", getSwingFlip());
		this.hashColumns.put("gen_set", getGenSet());
		this.hashColumns.put("toll", getToll());
		this.hashColumns.put("sunday", getSunday());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("lifting", getLifting());
		this.hashColumns.put("storage", getStorage());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("other", "other");
		this.hashFields.put("box_count", "boxCount");
		this.hashFields.put("drop_pull", "dropPull");
		this.hashFields.put("inspection", "inspection");
		this.hashFields.put("pre_pull", "prePull");
		this.hashFields.put("barge_low", "bargeLow");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("ensf", "ensf");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ferry_cost", "ferryCost");
		this.hashFields.put("chassis", "chassis");
		this.hashFields.put("hazmat", "hazmat");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scale_stop", "scaleStop");
		this.hashFields.put("dry_run", "dryRun");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("t_doc", "tDoc");
		this.hashFields.put("over_size", "overSize");
		this.hashFields.put("fine", "fine");
		this.hashFields.put("multiple", "multiple");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("add_labor", "addLabor");
		this.hashFields.put("waiting_charge", "waitingCharge");
		this.hashFields.put("fumigation", "fumigation");
		this.hashFields.put("redirection", "redirection");
		this.hashFields.put("over_weight", "overWeight");
		this.hashFields.put("street_turn", "streetTurn");
		this.hashFields.put("swing_flip", "swingFlip");
		this.hashFields.put("gen_set", "genSet");
		this.hashFields.put("toll", "toll");
		this.hashFields.put("sunday", "sunday");
		this.hashFields.put("month", "month");
		this.hashFields.put("lifting", "lifting");
		this.hashFields.put("storage", "storage");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}
	
	/**
	 * Column Info
	 * @return other
	 */
	public String getOther() {
		return this.other;
	}
	
	/**
	 * Column Info
	 * @return boxCount
	 */
	public String getBoxCount() {
		return this.boxCount;
	}
	
	/**
	 * Column Info
	 * @return dropPull
	 */
	public String getDropPull() {
		return this.dropPull;
	}
	
	/**
	 * Column Info
	 * @return inspection
	 */
	public String getInspection() {
		return this.inspection;
	}
	
	/**
	 * Column Info
	 * @return prePull
	 */
	public String getPrePull() {
		return this.prePull;
	}
	
	/**
	 * Column Info
	 * @return bargeLow
	 */
	public String getBargeLow() {
		return this.bargeLow;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ensf
	 */
	public String getEnsf() {
		return this.ensf;
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
	 * @return ferryCost
	 */
	public String getFerryCost() {
		return this.ferryCost;
	}
	
	/**
	 * Column Info
	 * @return chassis
	 */
	public String getChassis() {
		return this.chassis;
	}
	
	/**
	 * Column Info
	 * @return hazmat
	 */
	public String getHazmat() {
		return this.hazmat;
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
	 * @return scaleStop
	 */
	public String getScaleStop() {
		return this.scaleStop;
	}
	
	/**
	 * Column Info
	 * @return dryRun
	 */
	public String getDryRun() {
		return this.dryRun;
	}
	
	/**
	 * Column Info
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return tDoc
	 */
	public String getTDoc() {
		return this.tDoc;
	}
	
	/**
	 * Column Info
	 * @return overSize
	 */
	public String getOverSize() {
		return this.overSize;
	}
	
	/**
	 * Column Info
	 * @return fine
	 */
	public String getFine() {
		return this.fine;
	}
	
	/**
	 * Column Info
	 * @return multiple
	 */
	public String getMultiple() {
		return this.multiple;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return addLabor
	 */
	public String getAddLabor() {
		return this.addLabor;
	}
	
	/**
	 * Column Info
	 * @return waitingCharge
	 */
	public String getWaitingCharge() {
		return this.waitingCharge;
	}
	
	/**
	 * Column Info
	 * @return fumigation
	 */
	public String getFumigation() {
		return this.fumigation;
	}
	
	/**
	 * Column Info
	 * @return redirection
	 */
	public String getRedirection() {
		return this.redirection;
	}
	
	/**
	 * Column Info
	 * @return overWeight
	 */
	public String getOverWeight() {
		return this.overWeight;
	}
	
	/**
	 * Column Info
	 * @return streetTurn
	 */
	public String getStreetTurn() {
		return this.streetTurn;
	}
	
	/**
	 * Column Info
	 * @return swingFlip
	 */
	public String getSwingFlip() {
		return this.swingFlip;
	}
	
	/**
	 * Column Info
	 * @return genSet
	 */
	public String getGenSet() {
		return this.genSet;
	}
	
	/**
	 * Column Info
	 * @return toll
	 */
	public String getToll() {
		return this.toll;
	}
	
	/**
	 * Column Info
	 * @return sunday
	 */
	public String getSunday() {
		return this.sunday;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}
	
	/**
	 * Column Info
	 * @return lifting
	 */
	public String getLifting() {
		return this.lifting;
	}
	
	/**
	 * Column Info
	 * @return storage
	 */
	public String getStorage() {
		return this.storage;
	}
	

	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * Column Info
	 * @param other
	 */
	public void setOther(String other) {
		this.other = other;
	}
	
	/**
	 * Column Info
	 * @param boxCount
	 */
	public void setBoxCount(String boxCount) {
		this.boxCount = boxCount;
	}
	
	/**
	 * Column Info
	 * @param dropPull
	 */
	public void setDropPull(String dropPull) {
		this.dropPull = dropPull;
	}
	
	/**
	 * Column Info
	 * @param inspection
	 */
	public void setInspection(String inspection) {
		this.inspection = inspection;
	}
	
	/**
	 * Column Info
	 * @param prePull
	 */
	public void setPrePull(String prePull) {
		this.prePull = prePull;
	}
	
	/**
	 * Column Info
	 * @param bargeLow
	 */
	public void setBargeLow(String bargeLow) {
		this.bargeLow = bargeLow;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ensf
	 */
	public void setEnsf(String ensf) {
		this.ensf = ensf;
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
	 * @param ferryCost
	 */
	public void setFerryCost(String ferryCost) {
		this.ferryCost = ferryCost;
	}
	
	/**
	 * Column Info
	 * @param chassis
	 */
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	
	/**
	 * Column Info
	 * @param hazmat
	 */
	public void setHazmat(String hazmat) {
		this.hazmat = hazmat;
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
	 * @param scaleStop
	 */
	public void setScaleStop(String scaleStop) {
		this.scaleStop = scaleStop;
	}
	
	/**
	 * Column Info
	 * @param dryRun
	 */
	public void setDryRun(String dryRun) {
		this.dryRun = dryRun;
	}
	
	/**
	 * Column Info
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param tDoc
	 */
	public void setTDoc(String tDoc) {
		this.tDoc = tDoc;
	}
	
	/**
	 * Column Info
	 * @param overSize
	 */
	public void setOverSize(String overSize) {
		this.overSize = overSize;
	}
	
	/**
	 * Column Info
	 * @param fine
	 */
	public void setFine(String fine) {
		this.fine = fine;
	}
	
	/**
	 * Column Info
	 * @param multiple
	 */
	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param addLabor
	 */
	public void setAddLabor(String addLabor) {
		this.addLabor = addLabor;
	}
	
	/**
	 * Column Info
	 * @param waitingCharge
	 */
	public void setWaitingCharge(String waitingCharge) {
		this.waitingCharge = waitingCharge;
	}
	
	/**
	 * Column Info
	 * @param fumigation
	 */
	public void setFumigation(String fumigation) {
		this.fumigation = fumigation;
	}
	
	/**
	 * Column Info
	 * @param redirection
	 */
	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}
	
	/**
	 * Column Info
	 * @param overWeight
	 */
	public void setOverWeight(String overWeight) {
		this.overWeight = overWeight;
	}
	
	/**
	 * Column Info
	 * @param streetTurn
	 */
	public void setStreetTurn(String streetTurn) {
		this.streetTurn = streetTurn;
	}
	
	/**
	 * Column Info
	 * @param swingFlip
	 */
	public void setSwingFlip(String swingFlip) {
		this.swingFlip = swingFlip;
	}
	
	/**
	 * Column Info
	 * @param genSet
	 */
	public void setGenSet(String genSet) {
		this.genSet = genSet;
	}
	
	/**
	 * Column Info
	 * @param toll
	 */
	public void setToll(String toll) {
		this.toll = toll;
	}
	
	/**
	 * Column Info
	 * @param sunday
	 */
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Column Info
	 * @param lifting
	 */
	public void setLifting(String lifting) {
		this.lifting = lifting;
	}
	
	/**
	 * Column Info
	 * @param storage
	 */
	public void setStorage(String storage) {
		this.storage = storage;
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
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setOther(JSPUtil.getParameter(request, prefix + "other", ""));
		setBoxCount(JSPUtil.getParameter(request, prefix + "box_count", ""));
		setDropPull(JSPUtil.getParameter(request, prefix + "drop_pull", ""));
		setInspection(JSPUtil.getParameter(request, prefix + "inspection", ""));
		setPrePull(JSPUtil.getParameter(request, prefix + "pre_pull", ""));
		setBargeLow(JSPUtil.getParameter(request, prefix + "barge_low", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setEnsf(JSPUtil.getParameter(request, prefix + "ensf", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFerryCost(JSPUtil.getParameter(request, prefix + "ferry_cost", ""));
		setChassis(JSPUtil.getParameter(request, prefix + "chassis", ""));
		setHazmat(JSPUtil.getParameter(request, prefix + "hazmat", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScaleStop(JSPUtil.getParameter(request, prefix + "scale_stop", ""));
		setDryRun(JSPUtil.getParameter(request, prefix + "dry_run", ""));
		setCurr(JSPUtil.getParameter(request, prefix + "curr", ""));
		setTDoc(JSPUtil.getParameter(request, prefix + "t_doc", ""));
		setOverSize(JSPUtil.getParameter(request, prefix + "over_size", ""));
		setFine(JSPUtil.getParameter(request, prefix + "fine", ""));
		setMultiple(JSPUtil.getParameter(request, prefix + "multiple", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setAddLabor(JSPUtil.getParameter(request, prefix + "add_labor", ""));
		setWaitingCharge(JSPUtil.getParameter(request, prefix + "waiting_charge", ""));
		setFumigation(JSPUtil.getParameter(request, prefix + "fumigation", ""));
		setRedirection(JSPUtil.getParameter(request, prefix + "redirection", ""));
		setOverWeight(JSPUtil.getParameter(request, prefix + "over_weight", ""));
		setStreetTurn(JSPUtil.getParameter(request, prefix + "street_turn", ""));
		setSwingFlip(JSPUtil.getParameter(request, prefix + "swing_flip", ""));
		setGenSet(JSPUtil.getParameter(request, prefix + "gen_set", ""));
		setToll(JSPUtil.getParameter(request, prefix + "toll", ""));
		setSunday(JSPUtil.getParameter(request, prefix + "sunday", ""));
		setMonth(JSPUtil.getParameter(request, prefix + "month", ""));
		setLifting(JSPUtil.getParameter(request, prefix + "lifting", ""));
		setStorage(JSPUtil.getParameter(request, prefix + "storage", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgSmryVO[]
	 */
	public ScgSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgSmryVO[]
	 */
	public ScgSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] other = (JSPUtil.getParameter(request, prefix	+ "other", length));
			String[] boxCount = (JSPUtil.getParameter(request, prefix	+ "box_count", length));
			String[] dropPull = (JSPUtil.getParameter(request, prefix	+ "drop_pull", length));
			String[] inspection = (JSPUtil.getParameter(request, prefix	+ "inspection", length));
			String[] prePull = (JSPUtil.getParameter(request, prefix	+ "pre_pull", length));
			String[] bargeLow = (JSPUtil.getParameter(request, prefix	+ "barge_low", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] ensf = (JSPUtil.getParameter(request, prefix	+ "ensf", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ferryCost = (JSPUtil.getParameter(request, prefix	+ "ferry_cost", length));
			String[] chassis = (JSPUtil.getParameter(request, prefix	+ "chassis", length));
			String[] hazmat = (JSPUtil.getParameter(request, prefix	+ "hazmat", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scaleStop = (JSPUtil.getParameter(request, prefix	+ "scale_stop", length));
			String[] dryRun = (JSPUtil.getParameter(request, prefix	+ "dry_run", length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr", length));
			String[] tDoc = (JSPUtil.getParameter(request, prefix	+ "t_doc", length));
			String[] overSize = (JSPUtil.getParameter(request, prefix	+ "over_size", length));
			String[] fine = (JSPUtil.getParameter(request, prefix	+ "fine", length));
			String[] multiple = (JSPUtil.getParameter(request, prefix	+ "multiple", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] addLabor = (JSPUtil.getParameter(request, prefix	+ "add_labor", length));
			String[] waitingCharge = (JSPUtil.getParameter(request, prefix	+ "waiting_charge", length));
			String[] fumigation = (JSPUtil.getParameter(request, prefix	+ "fumigation", length));
			String[] redirection = (JSPUtil.getParameter(request, prefix	+ "redirection", length));
			String[] overWeight = (JSPUtil.getParameter(request, prefix	+ "over_weight", length));
			String[] streetTurn = (JSPUtil.getParameter(request, prefix	+ "street_turn", length));
			String[] swingFlip = (JSPUtil.getParameter(request, prefix	+ "swing_flip", length));
			String[] genSet = (JSPUtil.getParameter(request, prefix	+ "gen_set", length));
			String[] toll = (JSPUtil.getParameter(request, prefix	+ "toll", length));
			String[] sunday = (JSPUtil.getParameter(request, prefix	+ "sunday", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] lifting = (JSPUtil.getParameter(request, prefix	+ "lifting", length));
			String[] storage = (JSPUtil.getParameter(request, prefix	+ "storage", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgSmryVO();
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (other[i] != null)
					model.setOther(other[i]);
				if (boxCount[i] != null)
					model.setBoxCount(boxCount[i]);
				if (dropPull[i] != null)
					model.setDropPull(dropPull[i]);
				if (inspection[i] != null)
					model.setInspection(inspection[i]);
				if (prePull[i] != null)
					model.setPrePull(prePull[i]);
				if (bargeLow[i] != null)
					model.setBargeLow(bargeLow[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (ensf[i] != null)
					model.setEnsf(ensf[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ferryCost[i] != null)
					model.setFerryCost(ferryCost[i]);
				if (chassis[i] != null)
					model.setChassis(chassis[i]);
				if (hazmat[i] != null)
					model.setHazmat(hazmat[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scaleStop[i] != null)
					model.setScaleStop(scaleStop[i]);
				if (dryRun[i] != null)
					model.setDryRun(dryRun[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (tDoc[i] != null)
					model.setTDoc(tDoc[i]);
				if (overSize[i] != null)
					model.setOverSize(overSize[i]);
				if (fine[i] != null)
					model.setFine(fine[i]);
				if (multiple[i] != null)
					model.setMultiple(multiple[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (addLabor[i] != null)
					model.setAddLabor(addLabor[i]);
				if (waitingCharge[i] != null)
					model.setWaitingCharge(waitingCharge[i]);
				if (fumigation[i] != null)
					model.setFumigation(fumigation[i]);
				if (redirection[i] != null)
					model.setRedirection(redirection[i]);
				if (overWeight[i] != null)
					model.setOverWeight(overWeight[i]);
				if (streetTurn[i] != null)
					model.setStreetTurn(streetTurn[i]);
				if (swingFlip[i] != null)
					model.setSwingFlip(swingFlip[i]);
				if (genSet[i] != null)
					model.setGenSet(genSet[i]);
				if (toll[i] != null)
					model.setToll(toll[i]);
				if (sunday[i] != null)
					model.setSunday(sunday[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (lifting[i] != null)
					model.setLifting(lifting[i]);
				if (storage[i] != null)
					model.setStorage(storage[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgSmryVO[]
	 */
	public ScgSmryVO[] getScgSmryVOs(){
		ScgSmryVO[] vos = (ScgSmryVO[])models.toArray(new ScgSmryVO[models.size()]);
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
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.other = this.other .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boxCount = this.boxCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dropPull = this.dropPull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inspection = this.inspection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePull = this.prePull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bargeLow = this.bargeLow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensf = this.ensf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ferryCost = this.ferryCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chassis = this.chassis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazmat = this.hazmat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scaleStop = this.scaleStop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dryRun = this.dryRun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tDoc = this.tDoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSize = this.overSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fine = this.fine .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiple = this.multiple .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addLabor = this.addLabor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitingCharge = this.waitingCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fumigation = this.fumigation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.redirection = this.redirection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWeight = this.overWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.streetTurn = this.streetTurn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swingFlip = this.swingFlip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSet = this.genSet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toll = this.toll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sunday = this.sunday .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lifting = this.lifting .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.storage = this.storage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
