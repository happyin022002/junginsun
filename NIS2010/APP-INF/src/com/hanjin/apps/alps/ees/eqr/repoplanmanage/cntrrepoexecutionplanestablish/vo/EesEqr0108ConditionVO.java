/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0108ConditionVO.java
*@FileTitle : EesEqr0108ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.19 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0108ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0108ConditionVO> models = new ArrayList<EesEqr0108ConditionVO>();
	
	/* Column Info */
	private String weekTodate = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String toCost = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String weekMaxdate = null;
	/* Column Info */
	private String tab = null;
	/* Column Info */
	private String userSearchDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String unitCost = null;
	/* Column Info */
	private String userSearchLocation = null;
	/* Column Info */
	private String userModifyDiv = null;
	/* Column Info */
	private String userLevel = null;
	/* Column Info */
	private String weekFromdate = null;
	/* Column Info */
	private String fromCost = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String userModifyLocation = null;
	/* Column Info */
	private String toecc = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String pastplan = null;
	/* Column Info */
	private String fromecc = null;
	/* Column Info */
	private String trspmode = null;
	/* Column Info */
	private String repoPlanId = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String plnSeq = null;

	/* input Param */
	private List<String> tpszArr = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0108ConditionVO() {}

	public EesEqr0108ConditionVO(String ibflag, String pagerows, String userLevel, String userSearchDiv, String userModifyDiv, String userSearchLocation, String userModifyLocation, String repoPlanId, String tab, String week, String fromecc, String toecc, String etd, String eta, String weekFromdate, String weekTodate, String weekMaxdate, String trspmode, String vvd, String lane, String pastplan, String tpsztype, String unitCost, String fromCost, String toCost, String scnrId , String plnSeq) {
		this.weekTodate = weekTodate;
		this.eta = eta;
		this.toCost = toCost;
		this.etd = etd;
		this.weekMaxdate = weekMaxdate;
		this.tab = tab;
		this.userSearchDiv = userSearchDiv;
		this.pagerows = pagerows;
		this.lane = lane;
		this.ibflag = ibflag;
		this.unitCost = unitCost;
		this.userSearchLocation = userSearchLocation;
		this.userModifyDiv = userModifyDiv;
		this.userLevel = userLevel;
		this.weekFromdate = weekFromdate;
		this.fromCost = fromCost;
		this.tpsztype = tpsztype;
		this.userModifyLocation = userModifyLocation;
		this.toecc = toecc;
		this.scnrId = scnrId;
		this.vvd = vvd;
		this.pastplan = pastplan;
		this.fromecc = fromecc;
		this.trspmode = trspmode;
		this.repoPlanId = repoPlanId;
		this.week = week;
		this.plnSeq = plnSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("week_todate", getWeekTodate());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("to_cost", getToCost());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("week_maxdate", getWeekMaxdate());
		this.hashColumns.put("tab", getTab());
		this.hashColumns.put("user_search_div", getUserSearchDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("unit_cost", getUnitCost());
		this.hashColumns.put("user_search_location", getUserSearchLocation());
		this.hashColumns.put("user_modify_div", getUserModifyDiv());
		this.hashColumns.put("user_level", getUserLevel());
		this.hashColumns.put("week_fromdate", getWeekFromdate());
		this.hashColumns.put("from_cost", getFromCost());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("user_modify_location", getUserModifyLocation());
		this.hashColumns.put("toecc", getToecc());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pastplan", getPastplan());
		this.hashColumns.put("fromecc", getFromecc());
		this.hashColumns.put("trspmode", getTrspmode());
		this.hashColumns.put("repo_pln_id", getRepoPlanId());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("pln_seq", getPlnSeq());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("week_todate", "weekTodate");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("to_cost", "toCost");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("week_maxdate", "weekMaxdate");
		this.hashFields.put("tab", "tab");
		this.hashFields.put("user_search_div", "userSearchDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("unit_cost", "unitCost");
		this.hashFields.put("user_search_location", "userSearchLocation");
		this.hashFields.put("user_modify_div", "userModifyDiv");
		this.hashFields.put("user_level", "userLevel");
		this.hashFields.put("week_fromdate", "weekFromdate");
		this.hashFields.put("from_cost", "fromCost");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("user_modify_location", "userModifyLocation");
		this.hashFields.put("toecc", "toecc");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pastplan", "pastplan");
		this.hashFields.put("fromecc", "fromecc");
		this.hashFields.put("trspmode", "trspmode");
		this.hashFields.put("repo_pln_id", "repoPlanId");
		this.hashFields.put("week", "week");
		this.hashFields.put("pln_seq", "plnSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return weekTodate
	 */
	public String getWeekTodate() {
		return this.weekTodate;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return toCost
	 */
	public String getToCost() {
		return this.toCost;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return weekMaxdate
	 */
	public String getWeekMaxdate() {
		return this.weekMaxdate;
	}
	
	/**
	 * Column Info
	 * @return tab
	 */
	public String getTab() {
		return this.tab;
	}
	
	/**
	 * Column Info
	 * @return userSearchDiv
	 */
	public String getUserSearchDiv() {
		return this.userSearchDiv;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return unitCost
	 */
	public String getUnitCost() {
		return this.unitCost;
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
	 * @return userModifyDiv
	 */
	public String getUserModifyDiv() {
		return this.userModifyDiv;
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
	 * @return weekFromdate
	 */
	public String getWeekFromdate() {
		return this.weekFromdate;
	}
	
	/**
	 * Column Info
	 * @return fromCost
	 */
	public String getFromCost() {
		return this.fromCost;
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
	 * @return toecc
	 */
	public String getToecc() {
		return this.toecc;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return pastplan
	 */
	public String getPastplan() {
		return this.pastplan;
	}
	
	/**
	 * Column Info
	 * @return fromecc
	 */
	public String getFromecc() {
		return this.fromecc;
	}
	
	/**
	 * Column Info
	 * @return trspmode
	 */
	public String getTrspmode() {
		return this.trspmode;
	}
	
	/**
	 * Column Info
	 * @return repoPlanId
	 */
	public String getRepoPlanId() {
		return this.repoPlanId;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param weekTodate
	 */
	public void setWeekTodate(String weekTodate) {
		this.weekTodate = weekTodate;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param toCost
	 */
	public void setToCost(String toCost) {
		this.toCost = toCost;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param weekMaxdate
	 */
	public void setWeekMaxdate(String weekMaxdate) {
		this.weekMaxdate = weekMaxdate;
	}
	
	/**
	 * Column Info
	 * @param tab
	 */
	public void setTab(String tab) {
		this.tab = tab;
	}
	
	/**
	 * Column Info
	 * @param userSearchDiv
	 */
	public void setUserSearchDiv(String userSearchDiv) {
		this.userSearchDiv = userSearchDiv;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param unitCost
	 */
	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
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
	 * @param userModifyDiv
	 */
	public void setUserModifyDiv(String userModifyDiv) {
		this.userModifyDiv = userModifyDiv;
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
	 * @param weekFromdate
	 */
	public void setWeekFromdate(String weekFromdate) {
		this.weekFromdate = weekFromdate;
	}
	
	/**
	 * Column Info
	 * @param fromCost
	 */
	public void setFromCost(String fromCost) {
		this.fromCost = fromCost;
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
	 * @param toecc
	 */
	public void setToecc(String toecc) {
		this.toecc = toecc;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param pastplan
	 */
	public void setPastplan(String pastplan) {
		this.pastplan = pastplan;
	}
	
	/**
	 * Column Info
	 * @param fromecc
	 */
	public void setFromecc(String fromecc) {
		this.fromecc = fromecc;
	}
	
	/**
	 * Column Info
	 * @param trspmode
	 */
	public void setTrspmode(String trspmode) {
		this.trspmode = trspmode;
	}
	
	/**
	 * Column Info
	 * @param repoPlanId
	 */
	public void setRepoPlanId(String repoPlanId) {
		this.repoPlanId = repoPlanId;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}


	public List<String> getTpszArr() {
		return tpszArr;
	}

	public void setTpszArr(String tpsz) {
		
		this.tpszArr = Utils.replaceStrToList(tpsz);
	}
	
	public String getPlnSeq() {
		return plnSeq;
	}

	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWeekTodate(JSPUtil.getParameter(request, "week_todate", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setToCost(JSPUtil.getParameter(request, "to_cost", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setWeekMaxdate(JSPUtil.getParameter(request, "week_maxdate", ""));
		setTab(JSPUtil.getParameter(request, "tab", ""));
		setUserSearchDiv(JSPUtil.getParameter(request, "user_search_div", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUnitCost(JSPUtil.getParameter(request, "unit_cost", ""));
		setUserSearchLocation(JSPUtil.getParameter(request, "user_search_location", ""));
		setUserModifyDiv(JSPUtil.getParameter(request, "user_modify_div", ""));
		setUserLevel(JSPUtil.getParameter(request, "user_level", ""));
		setWeekFromdate(JSPUtil.getParameter(request, "week_fromdate", ""));
		setFromCost(JSPUtil.getParameter(request, "from_cost", ""));
		setTpsztype(JSPUtil.getParameter(request, "tpsz", ""));
		setUserModifyLocation(JSPUtil.getParameter(request, "user_modify_location", ""));
		setToecc(JSPUtil.getParameter(request, "toecc", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPastplan(JSPUtil.getParameter(request, "pastplan", ""));
		setFromecc(JSPUtil.getParameter(request, "fromecc", ""));
		setTrspmode(JSPUtil.getParameter(request, "trspmode", ""));
		setRepoPlanId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0108ConditionVO[]
	 */
	public EesEqr0108ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0108ConditionVO[]
	 */
	public EesEqr0108ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0108ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] weekTodate = (JSPUtil.getParameter(request, prefix	+ "week_todate", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] toCost = (JSPUtil.getParameter(request, prefix	+ "to_cost", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] weekMaxdate = (JSPUtil.getParameter(request, prefix	+ "week_maxdate", length));
			String[] tab = (JSPUtil.getParameter(request, prefix	+ "tab", length));
			String[] userSearchDiv = (JSPUtil.getParameter(request, prefix	+ "user_search_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] unitCost = (JSPUtil.getParameter(request, prefix	+ "unit_cost", length));
			String[] userSearchLocation = (JSPUtil.getParameter(request, prefix	+ "user_search_location", length));
			String[] userModifyDiv = (JSPUtil.getParameter(request, prefix	+ "user_modify_div", length));
			String[] userLevel = (JSPUtil.getParameter(request, prefix	+ "user_level", length));
			String[] weekFromdate = (JSPUtil.getParameter(request, prefix	+ "week_fromdate", length));
			String[] fromCost = (JSPUtil.getParameter(request, prefix	+ "from_cost", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] userModifyLocation = (JSPUtil.getParameter(request, prefix	+ "user_modify_location", length));
			String[] toecc = (JSPUtil.getParameter(request, prefix	+ "toecc", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] pastplan = (JSPUtil.getParameter(request, prefix	+ "pastplan", length));
			String[] fromecc = (JSPUtil.getParameter(request, prefix	+ "fromecc", length));
			String[] trspmode = (JSPUtil.getParameter(request, prefix	+ "trspmode", length));
			String[] repoPlanId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0108ConditionVO();
				if (weekTodate[i] != null)
					model.setWeekTodate(weekTodate[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (toCost[i] != null)
					model.setToCost(toCost[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (weekMaxdate[i] != null)
					model.setWeekMaxdate(weekMaxdate[i]);
				if (tab[i] != null)
					model.setTab(tab[i]);
				if (userSearchDiv[i] != null)
					model.setUserSearchDiv(userSearchDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (unitCost[i] != null)
					model.setUnitCost(unitCost[i]);
				if (userSearchLocation[i] != null)
					model.setUserSearchLocation(userSearchLocation[i]);
				if (userModifyDiv[i] != null)
					model.setUserModifyDiv(userModifyDiv[i]);
				if (userLevel[i] != null)
					model.setUserLevel(userLevel[i]);
				if (weekFromdate[i] != null)
					model.setWeekFromdate(weekFromdate[i]);
				if (fromCost[i] != null)
					model.setFromCost(fromCost[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (userModifyLocation[i] != null)
					model.setUserModifyLocation(userModifyLocation[i]);
				if (toecc[i] != null)
					model.setToecc(toecc[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (pastplan[i] != null)
					model.setPastplan(pastplan[i]);
				if (fromecc[i] != null)
					model.setFromecc(fromecc[i]);
				if (trspmode[i] != null)
					model.setTrspmode(trspmode[i]);
				if (repoPlanId[i] != null)
					model.setRepoPlanId(repoPlanId[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0108ConditionVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return EesEqr0108ConditionVO[]
	 */
	public EesEqr0108ConditionVO[] getEesEqr0108ConditionVOs(){
		EesEqr0108ConditionVO[] vos = (EesEqr0108ConditionVO[])models.toArray(new EesEqr0108ConditionVO[models.size()]);
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
		this.weekTodate = this.weekTodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCost = this.toCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekMaxdate = this.weekMaxdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tab = this.tab .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userSearchDiv = this.userSearchDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitCost = this.unitCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userSearchLocation = this.userSearchLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userModifyDiv = this.userModifyDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userLevel = this.userLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekFromdate = this.weekFromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromCost = this.fromCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userModifyLocation = this.userModifyLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecc = this.toecc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pastplan = this.pastplan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromecc = this.fromecc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspmode = this.trspmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlanId = this.repoPlanId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
