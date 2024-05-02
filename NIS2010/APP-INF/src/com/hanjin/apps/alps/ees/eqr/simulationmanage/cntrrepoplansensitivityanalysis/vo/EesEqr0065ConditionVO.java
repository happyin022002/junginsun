/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0065ConditionVO.java
*@FileTitle : EesEqr0065ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.18 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0065ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0065ConditionVO> models = new ArrayList<EesEqr0065ConditionVO>();
	
	/* Column Info */
	private String objecttext = null;
	/* Column Info */
	private String fmendyear = null;
	/* Column Info */
	private String limitobj = null;
	/* Column Info */
	private String runId = null;
	/* Column Info */
	private String tostartweek = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Column Info */
	private String atendyear = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmecccd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String atendweek = null;
	/* Column Info */
	private String repormk = null;
	/* Column Info */
	private String fmstartweek = null;
	/* Column Info */
	private String fmendweek = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String tostartyear = null;
	/* Column Info */
	private String sens = null;
	/* Column Info */
	private String senstext = null;
	/* Column Info */
	private String atstartweek = null;
	/* Column Info */
	private String atecccd = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String toendyear = null;
	/* Column Info */
	private String fmstartyear = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String atstartyear = null;
	/* Column Info */
	private String attype = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String toendweek = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String fmtoat = null;
	/* Column Info */
	private String costobj = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String scnrid = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0065ConditionVO() {}

	public EesEqr0065ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String repormk, String fmtoat, String fmtype, String fmecccd, String totype, String toecccd, String attype, String atecccd, String fmstartyear, String fmstartweek, String fmendyear, String fmendweek, String tostartyear, String tostartweek, String toendyear, String toendweek, String atstartyear, String atstartweek, String atendyear, String atendweek, String cntrtpszcd, String sens, String costobj, String limitobj, String senstext, String objecttext, String scnrid, String userId, String runId) {
		this.objecttext = objecttext;
		this.fmendyear = fmendyear;
		this.limitobj = limitobj;
		this.runId = runId;
		this.tostartweek = tostartweek;
		this.cntrtpszcd = cntrtpszcd;
		this.atendyear = atendyear;
		this.pagerows = pagerows;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.atendweek = atendweek;
		this.repormk = repormk;
		this.fmstartweek = fmstartweek;
		this.fmendweek = fmendweek;
		this.userId = userId;
		this.tostartyear = tostartyear;
		this.sens = sens;
		this.senstext = senstext;
		this.atstartweek = atstartweek;
		this.atecccd = atecccd;
		this.toecccd = toecccd;
		this.toendyear = toendyear;
		this.fmstartyear = fmstartyear;
		this.fmtype = fmtype;
		this.atstartyear = atstartyear;
		this.attype = attype;
		this.yyyyww = yyyyww;
		this.toendweek = toendweek;
		this.totype = totype;
		this.fmtoat = fmtoat;
		this.costobj = costobj;
		this.seq = seq;
		this.scnrid = scnrid;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("objecttext", getObjecttext());
		this.hashColumns.put("fmendyear", getFmendyear());
		this.hashColumns.put("limitobj", getLimitobj());
		this.hashColumns.put("run_id", getRunId());
		this.hashColumns.put("tostartweek", getTostartweek());
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());
		this.hashColumns.put("atendyear", getAtendyear());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fmecccd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("atendweek", getAtendweek());
		this.hashColumns.put("repormk", getRepormk());
		this.hashColumns.put("fmstartweek", getFmstartweek());
		this.hashColumns.put("fmendweek", getFmendweek());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("tostartyear", getTostartyear());
		this.hashColumns.put("sens", getSens());
		this.hashColumns.put("senstext", getSenstext());
		this.hashColumns.put("atstartweek", getAtstartweek());
		this.hashColumns.put("atecccd", getAtecccd());
		this.hashColumns.put("toecccd", getToecccd());
		this.hashColumns.put("toendyear", getToendyear());
		this.hashColumns.put("fmstartyear", getFmstartyear());
		this.hashColumns.put("fmtype", getFmtype());
		this.hashColumns.put("atstartyear", getAtstartyear());
		this.hashColumns.put("attype", getAttype());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("toendweek", getToendweek());
		this.hashColumns.put("totype", getTotype());
		this.hashColumns.put("fmtoat", getFmtoat());
		this.hashColumns.put("costobj", getCostobj());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("scnrid", getScnrid());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("objecttext", "objecttext");
		this.hashFields.put("fmendyear", "fmendyear");
		this.hashFields.put("limitobj", "limitobj");
		this.hashFields.put("run_id", "runId");
		this.hashFields.put("tostartweek", "tostartweek");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("atendyear", "atendyear");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("atendweek", "atendweek");
		this.hashFields.put("repormk", "repormk");
		this.hashFields.put("fmstartweek", "fmstartweek");
		this.hashFields.put("fmendweek", "fmendweek");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("tostartyear", "tostartyear");
		this.hashFields.put("sens", "sens");
		this.hashFields.put("senstext", "senstext");
		this.hashFields.put("atstartweek", "atstartweek");
		this.hashFields.put("atecccd", "atecccd");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("toendyear", "toendyear");
		this.hashFields.put("fmstartyear", "fmstartyear");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("atstartyear", "atstartyear");
		this.hashFields.put("attype", "attype");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("toendweek", "toendweek");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("costobj", "costobj");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("scnrid", "scnrid");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return objecttext
	 */
	public String getObjecttext() {
		return this.objecttext;
	}
	
	/**
	 * Column Info
	 * @return fmendyear
	 */
	public String getFmendyear() {
		return this.fmendyear;
	}
	
	/**
	 * Column Info
	 * @return limitobj
	 */
	public String getLimitobj() {
		return this.limitobj;
	}
	
	/**
	 * Column Info
	 * @return runId
	 */
	public String getRunId() {
		return this.runId;
	}
	
	/**
	 * Column Info
	 * @return tostartweek
	 */
	public String getTostartweek() {
		return this.tostartweek;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @return atendyear
	 */
	public String getAtendyear() {
		return this.atendyear;
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
	 * @return fmecccd
	 */
	public String getFmecccd() {
		return this.fmecccd;
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
	 * @return atendweek
	 */
	public String getAtendweek() {
		return this.atendweek;
	}
	
	/**
	 * Column Info
	 * @return repormk
	 */
	public String getRepormk() {
		return this.repormk;
	}
	
	/**
	 * Column Info
	 * @return fmstartweek
	 */
	public String getFmstartweek() {
		return this.fmstartweek;
	}
	
	/**
	 * Column Info
	 * @return fmendweek
	 */
	public String getFmendweek() {
		return this.fmendweek;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return tostartyear
	 */
	public String getTostartyear() {
		return this.tostartyear;
	}
	
	/**
	 * Column Info
	 * @return sens
	 */
	public String getSens() {
		return this.sens;
	}
	
	/**
	 * Column Info
	 * @return senstext
	 */
	public String getSenstext() {
		return this.senstext;
	}
	
	/**
	 * Column Info
	 * @return atstartweek
	 */
	public String getAtstartweek() {
		return this.atstartweek;
	}
	
	/**
	 * Column Info
	 * @return atecccd
	 */
	public String getAtecccd() {
		return this.atecccd;
	}
	
	/**
	 * Column Info
	 * @return toecccd
	 */
	public String getToecccd() {
		return this.toecccd;
	}
	
	/**
	 * Column Info
	 * @return toendyear
	 */
	public String getToendyear() {
		return this.toendyear;
	}
	
	/**
	 * Column Info
	 * @return fmstartyear
	 */
	public String getFmstartyear() {
		return this.fmstartyear;
	}
	
	/**
	 * Column Info
	 * @return fmtype
	 */
	public String getFmtype() {
		return this.fmtype;
	}
	
	/**
	 * Column Info
	 * @return atstartyear
	 */
	public String getAtstartyear() {
		return this.atstartyear;
	}
	
	/**
	 * Column Info
	 * @return attype
	 */
	public String getAttype() {
		return this.attype;
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
	 * @return toendweek
	 */
	public String getToendweek() {
		return this.toendweek;
	}
	
	/**
	 * Column Info
	 * @return totype
	 */
	public String getTotype() {
		return this.totype;
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
	 * @return costobj
	 */
	public String getCostobj() {
		return this.costobj;
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
	 * @return scnrid
	 */
	public String getScnrid() {
		return this.scnrid;
	}
	

	/**
	 * Column Info
	 * @param objecttext
	 */
	public void setObjecttext(String objecttext) {
		this.objecttext = objecttext;
	}
	
	/**
	 * Column Info
	 * @param fmendyear
	 */
	public void setFmendyear(String fmendyear) {
		this.fmendyear = fmendyear;
	}
	
	/**
	 * Column Info
	 * @param limitobj
	 */
	public void setLimitobj(String limitobj) {
		this.limitobj = limitobj;
	}
	
	/**
	 * Column Info
	 * @param runId
	 */
	public void setRunId(String runId) {
		this.runId = runId;
	}
	
	/**
	 * Column Info
	 * @param tostartweek
	 */
	public void setTostartweek(String tostartweek) {
		this.tostartweek = tostartweek;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @param atendyear
	 */
	public void setAtendyear(String atendyear) {
		this.atendyear = atendyear;
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
	 * @param fmecccd
	 */
	public void setFmecccd(String fmecccd) {
		this.fmecccd = fmecccd;
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
	 * @param atendweek
	 */
	public void setAtendweek(String atendweek) {
		this.atendweek = atendweek;
	}
	
	/**
	 * Column Info
	 * @param repormk
	 */
	public void setRepormk(String repormk) {
		this.repormk = repormk;
	}
	
	/**
	 * Column Info
	 * @param fmstartweek
	 */
	public void setFmstartweek(String fmstartweek) {
		this.fmstartweek = fmstartweek;
	}
	
	/**
	 * Column Info
	 * @param fmendweek
	 */
	public void setFmendweek(String fmendweek) {
		this.fmendweek = fmendweek;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param tostartyear
	 */
	public void setTostartyear(String tostartyear) {
		this.tostartyear = tostartyear;
	}
	
	/**
	 * Column Info
	 * @param sens
	 */
	public void setSens(String sens) {
		this.sens = sens;
	}
	
	/**
	 * Column Info
	 * @param senstext
	 */
	public void setSenstext(String senstext) {
		this.senstext = senstext;
	}
	
	/**
	 * Column Info
	 * @param atstartweek
	 */
	public void setAtstartweek(String atstartweek) {
		this.atstartweek = atstartweek;
	}
	
	/**
	 * Column Info
	 * @param atecccd
	 */
	public void setAtecccd(String atecccd) {
		this.atecccd = atecccd;
	}
	
	/**
	 * Column Info
	 * @param toecccd
	 */
	public void setToecccd(String toecccd) {
		this.toecccd = toecccd;
	}
	
	/**
	 * Column Info
	 * @param toendyear
	 */
	public void setToendyear(String toendyear) {
		this.toendyear = toendyear;
	}
	
	/**
	 * Column Info
	 * @param fmstartyear
	 */
	public void setFmstartyear(String fmstartyear) {
		this.fmstartyear = fmstartyear;
	}
	
	/**
	 * Column Info
	 * @param fmtype
	 */
	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
	}
	
	/**
	 * Column Info
	 * @param atstartyear
	 */
	public void setAtstartyear(String atstartyear) {
		this.atstartyear = atstartyear;
	}
	
	/**
	 * Column Info
	 * @param attype
	 */
	public void setAttype(String attype) {
		this.attype = attype;
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
	 * @param toendweek
	 */
	public void setToendweek(String toendweek) {
		this.toendweek = toendweek;
	}
	
	/**
	 * Column Info
	 * @param totype
	 */
	public void setTotype(String totype) {
		this.totype = totype;
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
	 * @param costobj
	 */
	public void setCostobj(String costobj) {
		this.costobj = costobj;
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
	 * @param scnrid
	 */
	public void setScnrid(String scnrid) {
		this.scnrid = scnrid;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setObjecttext(JSPUtil.getParameter(request, "objecttext", ""));
		setFmendyear(JSPUtil.getParameter(request, "fmendyear", ""));
		setLimitobj(JSPUtil.getParameter(request, "limitobj", ""));
		setRunId(JSPUtil.getParameter(request, "run_id", ""));
		setTostartweek(JSPUtil.getParameter(request, "tostartweek", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrtpszcd", ""));
		setAtendyear(JSPUtil.getParameter(request, "atendyear", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmecccd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAtendweek(JSPUtil.getParameter(request, "atendweek", ""));
		setRepormk(JSPUtil.getParameter(request, "repormk", ""));
		setFmstartweek(JSPUtil.getParameter(request, "fmstartweek", ""));
		setFmendweek(JSPUtil.getParameter(request, "fmendweek", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setTostartyear(JSPUtil.getParameter(request, "tostartyear", ""));
		setSens(JSPUtil.getParameter(request, "sens", ""));
		setSenstext(JSPUtil.getParameter(request, "senstext", ""));
		setAtstartweek(JSPUtil.getParameter(request, "atstartweek", ""));
		setAtecccd(JSPUtil.getParameter(request, "atecccd", ""));
		setToecccd(JSPUtil.getParameter(request, "toecccd", ""));
		setToendyear(JSPUtil.getParameter(request, "toendyear", ""));
		setFmstartyear(JSPUtil.getParameter(request, "fmstartyear", ""));
		setFmtype(JSPUtil.getParameter(request, "fmtype", ""));
		setAtstartyear(JSPUtil.getParameter(request, "atstartyear", ""));
		setAttype(JSPUtil.getParameter(request, "attype", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setToendweek(JSPUtil.getParameter(request, "toendweek", ""));
		setTotype(JSPUtil.getParameter(request, "totype", ""));
		setFmtoat(JSPUtil.getParameter(request, "fmtoat", ""));
		setCostobj(JSPUtil.getParameter(request, "costobj", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setScnrid(JSPUtil.getParameter(request, "scnrid", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0065ConditionVO[]
	 */
	public EesEqr0065ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0065ConditionVO[]
	 */
	public EesEqr0065ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0065ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] objecttext = (JSPUtil.getParameter(request, prefix	+ "objecttext", length));
			String[] fmendyear = (JSPUtil.getParameter(request, prefix	+ "fmendyear", length));
			String[] limitobj = (JSPUtil.getParameter(request, prefix	+ "limitobj", length));
			String[] runId = (JSPUtil.getParameter(request, prefix	+ "run_id", length));
			String[] tostartweek = (JSPUtil.getParameter(request, prefix	+ "tostartweek", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] atendyear = (JSPUtil.getParameter(request, prefix	+ "atendyear", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] atendweek = (JSPUtil.getParameter(request, prefix	+ "atendweek", length));
			String[] repormk = (JSPUtil.getParameter(request, prefix	+ "repormk", length));
			String[] fmstartweek = (JSPUtil.getParameter(request, prefix	+ "fmstartweek", length));
			String[] fmendweek = (JSPUtil.getParameter(request, prefix	+ "fmendweek", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] tostartyear = (JSPUtil.getParameter(request, prefix	+ "tostartyear", length));
			String[] sens = (JSPUtil.getParameter(request, prefix	+ "sens", length));
			String[] senstext = (JSPUtil.getParameter(request, prefix	+ "senstext", length));
			String[] atstartweek = (JSPUtil.getParameter(request, prefix	+ "atstartweek", length));
			String[] atecccd = (JSPUtil.getParameter(request, prefix	+ "atecccd", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] toendyear = (JSPUtil.getParameter(request, prefix	+ "toendyear", length));
			String[] fmstartyear = (JSPUtil.getParameter(request, prefix	+ "fmstartyear", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] atstartyear = (JSPUtil.getParameter(request, prefix	+ "atstartyear", length));
			String[] attype = (JSPUtil.getParameter(request, prefix	+ "attype", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] toendweek = (JSPUtil.getParameter(request, prefix	+ "toendweek", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] costobj = (JSPUtil.getParameter(request, prefix	+ "costobj", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] scnrid = (JSPUtil.getParameter(request, prefix	+ "scnrid", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0065ConditionVO();
				if (objecttext[i] != null)
					model.setObjecttext(objecttext[i]);
				if (fmendyear[i] != null)
					model.setFmendyear(fmendyear[i]);
				if (limitobj[i] != null)
					model.setLimitobj(limitobj[i]);
				if (runId[i] != null)
					model.setRunId(runId[i]);
				if (tostartweek[i] != null)
					model.setTostartweek(tostartweek[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (atendyear[i] != null)
					model.setAtendyear(atendyear[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (atendweek[i] != null)
					model.setAtendweek(atendweek[i]);
				if (repormk[i] != null)
					model.setRepormk(repormk[i]);
				if (fmstartweek[i] != null)
					model.setFmstartweek(fmstartweek[i]);
				if (fmendweek[i] != null)
					model.setFmendweek(fmendweek[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (tostartyear[i] != null)
					model.setTostartyear(tostartyear[i]);
				if (sens[i] != null)
					model.setSens(sens[i]);
				if (senstext[i] != null)
					model.setSenstext(senstext[i]);
				if (atstartweek[i] != null)
					model.setAtstartweek(atstartweek[i]);
				if (atecccd[i] != null)
					model.setAtecccd(atecccd[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (toendyear[i] != null)
					model.setToendyear(toendyear[i]);
				if (fmstartyear[i] != null)
					model.setFmstartyear(fmstartyear[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (atstartyear[i] != null)
					model.setAtstartyear(atstartyear[i]);
				if (attype[i] != null)
					model.setAttype(attype[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (toendweek[i] != null)
					model.setToendweek(toendweek[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (costobj[i] != null)
					model.setCostobj(costobj[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (scnrid[i] != null)
					model.setScnrid(scnrid[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0065ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0065ConditionVO[]
	 */
	public EesEqr0065ConditionVO[] getEesEqr0065ConditionVOs(){
		EesEqr0065ConditionVO[] vos = (EesEqr0065ConditionVO[])models.toArray(new EesEqr0065ConditionVO[models.size()]);
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
		this.objecttext = this.objecttext .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmendyear = this.fmendyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.limitobj = this.limitobj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runId = this.runId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tostartweek = this.tostartweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atendyear = this.atendyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atendweek = this.atendweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repormk = this.repormk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmstartweek = this.fmstartweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmendweek = this.fmendweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tostartyear = this.tostartyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sens = this.sens .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senstext = this.senstext .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atstartweek = this.atstartweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd = this.atecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toendyear = this.toendyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmstartyear = this.fmstartyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atstartyear = this.atstartyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype = this.attype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toendweek = this.toendweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costobj = this.costobj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrid = this.scnrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
