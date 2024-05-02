/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0037ConditionVO.java
*@FileTitle : EesEqr0037ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.10.09		1.0 최초 생성
*
*@LastModifyDate : 2009.10.09
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.10.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0037ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0037ConditionVO> models = new ArrayList<EesEqr0037ConditionVO>();
	
	/* Column Info */
	private String weeklygubun = null;
	/* Column Info */
	private String attypeby = null;
	/* Column Info */
	private String fmtypeby = null;
	/* Column Info */
	private String dataselect2 = null;
	/* Column Info */
	private String dataselect1 = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tofmplnyr = null;
	/* Column Info */
	private String fmecccd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tofmplnwk = null;
	/* Column Info */
	private String totoplnwk = null;
	/* Column Info */
	private String comp = null;
	/* Column Info */
	private String atfmplnyr = null;
	/* Column Info */
	private String weekmonth = null;
	/* Column Info */
	private String atecccd = null;
	/* Column Info */
	private String fmtoplnwk = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String totoplnyr = null;
	/* Column Info */
	private String orgdst = null;
	/* Column Info */
	private String tpszall = null;
	/* Column Info */
	private String fmtoplnyr = null;
	/* Column Info */
	private String attype = null;
	/* Column Info */
	private String attoplnwk = null;
	/* Column Info */
	private String atfmplnwk = null;
	/* Column Info */
	private String fmfmplnyr = null;
	/* Column Info */
	private String attoplnyr = null;
	/* Column Info */
	private String fmtoat = null;
	/* Column Info */
	private String fmfmplnwk = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String totypeby = null;
	/* Column Info */
	private String inclunmatch = null;
	/* Column Info */
	private String inclmatch = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0037ConditionVO() {}

	public EesEqr0037ConditionVO(String ibflag, String pagerows, String cntrtpszcd, String tpszall, String dataselect1, String dataselect2, String fmtoat, String comp, String weekmonth, String orgdst, String inclunmatch, String inclmatch, String fmtype, String fmecccd, String fmtypeby, String fmfmplnyr, String fmfmplnwk, String fmtoplnyr, String fmtoplnwk, String totype, String toecccd, String totypeby, String tofmplnyr, String tofmplnwk, String totoplnyr, String totoplnwk, String attype, String atecccd, String attypeby, String atfmplnyr, String atfmplnwk, String attoplnyr, String attoplnwk, String weeklygubun) {
		this.weeklygubun = weeklygubun;
		this.attypeby = attypeby;
		this.fmtypeby = fmtypeby;
		this.dataselect2 = dataselect2;
		this.dataselect1 = dataselect1;
		this.cntrtpszcd = cntrtpszcd;
		this.pagerows = pagerows;
		this.tofmplnyr = tofmplnyr;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.tofmplnwk = tofmplnwk;
		this.totoplnwk = totoplnwk;
		this.comp = comp;
		this.atfmplnyr = atfmplnyr;
		this.weekmonth = weekmonth;
		this.atecccd = atecccd;
		this.fmtoplnwk = fmtoplnwk;
		this.toecccd = toecccd;
		this.fmtype = fmtype;
		this.totoplnyr = totoplnyr;
		this.orgdst = orgdst;
		this.tpszall = tpszall;
		this.fmtoplnyr = fmtoplnyr;
		this.attype = attype;
		this.attoplnwk = attoplnwk;
		this.atfmplnwk = atfmplnwk;
		this.fmfmplnyr = fmfmplnyr;
		this.attoplnyr = attoplnyr;
		this.fmtoat = fmtoat;
		this.fmfmplnwk = fmfmplnwk;
		this.totype = totype;
		this.totypeby = totypeby;
		this.inclunmatch = inclunmatch;
		this.inclmatch = inclmatch;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("weeklygubun", getWeeklygubun());
		this.hashColumns.put("attypeby", getAttypeby());
		this.hashColumns.put("fmtypeby", getFmtypeby());
		this.hashColumns.put("dataselect2", getDataselect2());
		this.hashColumns.put("dataselect1", getDataselect1());
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tofmplnyr", getTofmplnyr());
		this.hashColumns.put("fmecccd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tofmplnwk", getTofmplnwk());
		this.hashColumns.put("totoplnwk", getTotoplnwk());
		this.hashColumns.put("comp", getComp());
		this.hashColumns.put("atfmplnyr", getAtfmplnyr());
		this.hashColumns.put("weekmonth", getWeekmonth());
		this.hashColumns.put("atecccd", getAtecccd());
		this.hashColumns.put("fmtoplnwk", getFmtoplnwk());
		this.hashColumns.put("toecccd", getToecccd());
		this.hashColumns.put("fmtype", getFmtype());
		this.hashColumns.put("totoplnyr", getTotoplnyr());
		this.hashColumns.put("orgdst", getOrgdst());
		this.hashColumns.put("tpszall", getTpszall());
		this.hashColumns.put("fmtoplnyr", getFmtoplnyr());
		this.hashColumns.put("attype", getAttype());
		this.hashColumns.put("attoplnwk", getAttoplnwk());
		this.hashColumns.put("atfmplnwk", getAtfmplnwk());
		this.hashColumns.put("fmfmplnyr", getFmfmplnyr());
		this.hashColumns.put("attoplnyr", getAttoplnyr());
		this.hashColumns.put("fmtoat", getFmtoat());
		this.hashColumns.put("fmfmplnwk", getFmfmplnwk());
		this.hashColumns.put("totype", getTotype());
		this.hashColumns.put("totypeby", getTotypeby());
		this.hashColumns.put("inclunmatch", getInclunmatch());
		this.hashColumns.put("inclmatch", getInclmatch());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("weeklygubun", "weeklygubun");
		this.hashFields.put("attypeby", "attypeby");
		this.hashFields.put("fmtypeby", "fmtypeby");
		this.hashFields.put("dataselect2", "dataselect2");
		this.hashFields.put("dataselect1", "dataselect1");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tofmplnyr", "tofmplnyr");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tofmplnwk", "tofmplnwk");
		this.hashFields.put("totoplnwk", "totoplnwk");
		this.hashFields.put("comp", "comp");
		this.hashFields.put("atfmplnyr", "atfmplnyr");
		this.hashFields.put("weekmonth", "weekmonth");
		this.hashFields.put("atecccd", "atecccd");
		this.hashFields.put("fmtoplnwk", "fmtoplnwk");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("totoplnyr", "totoplnyr");
		this.hashFields.put("orgdst", "orgdst");
		this.hashFields.put("tpszall", "tpszall");
		this.hashFields.put("fmtoplnyr", "fmtoplnyr");
		this.hashFields.put("attype", "attype");
		this.hashFields.put("attoplnwk", "attoplnwk");
		this.hashFields.put("atfmplnwk", "atfmplnwk");
		this.hashFields.put("fmfmplnyr", "fmfmplnyr");
		this.hashFields.put("attoplnyr", "attoplnyr");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("fmfmplnwk", "fmfmplnwk");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("totypeby", "totypeby");
		this.hashFields.put("inclunmatch", "inclunmatch");
		this.hashFields.put("inclmatch", "inclmatch");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return weeklygubun
	 */
	public String getWeeklygubun() {
		return this.weeklygubun;
	}
	
	/**
	 * Column Info
	 * @return attypeby
	 */
	public String getAttypeby() {
		return this.attypeby;
	}
	
	/**
	 * Column Info
	 * @return fmtypeby
	 */
	public String getFmtypeby() {
		return this.fmtypeby;
	}
	
	/**
	 * Column Info
	 * @return dataselect2
	 */
	public String getDataselect2() {
		return this.dataselect2;
	}
	
	/**
	 * Column Info
	 * @return dataselect1
	 */
	public String getDataselect1() {
		return this.dataselect1;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
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
	 * @return tofmplnyr
	 */
	public String getTofmplnyr() {
		return this.tofmplnyr;
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
	 * @return tofmplnwk
	 */
	public String getTofmplnwk() {
		return this.tofmplnwk;
	}
	
	/**
	 * Column Info
	 * @return totoplnwk
	 */
	public String getTotoplnwk() {
		return this.totoplnwk;
	}
	
	/**
	 * Column Info
	 * @return comp
	 */
	public String getComp() {
		return this.comp;
	}
	
	/**
	 * Column Info
	 * @return atfmplnyr
	 */
	public String getAtfmplnyr() {
		return this.atfmplnyr;
	}
	
	/**
	 * Column Info
	 * @return weekmonth
	 */
	public String getWeekmonth() {
		return this.weekmonth;
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
	 * @return fmtoplnwk
	 */
	public String getFmtoplnwk() {
		return this.fmtoplnwk;
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
	 * @return fmtype
	 */
	public String getFmtype() {
		return this.fmtype;
	}
	
	/**
	 * Column Info
	 * @return totoplnyr
	 */
	public String getTotoplnyr() {
		return this.totoplnyr;
	}
	
	/**
	 * Column Info
	 * @return orgdst
	 */
	public String getOrgdst() {
		return this.orgdst;
	}
	
	/**
	 * Column Info
	 * @return tpszall
	 */
	public String getTpszall() {
		return this.tpszall;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnyr
	 */
	public String getFmtoplnyr() {
		return this.fmtoplnyr;
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
	 * @return attoplnwk
	 */
	public String getAttoplnwk() {
		return this.attoplnwk;
	}
	
	/**
	 * Column Info
	 * @return atfmplnwk
	 */
	public String getAtfmplnwk() {
		return this.atfmplnwk;
	}
	
	/**
	 * Column Info
	 * @return fmfmplnyr
	 */
	public String getFmfmplnyr() {
		return this.fmfmplnyr;
	}
	
	/**
	 * Column Info
	 * @return attoplnyr
	 */
	public String getAttoplnyr() {
		return this.attoplnyr;
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
	 * @return fmfmplnwk
	 */
	public String getFmfmplnwk() {
		return this.fmfmplnwk;
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
	 * @return totypeby
	 */
	public String getTotypeby() {
		return this.totypeby;
	}
	
	/**
	 * Column Info
	 * @return inclunmatch
	 */
	public String getInclunmatch() {
		return this.inclunmatch;
	}
	
	/**
	 * Column Info
	 * @return inclmatch
	 */
	public String getInclmatch() {
		return this.inclmatch;
	}
	

	/**
	 * Column Info
	 * @param weeklygubun
	 */
	public void setWeeklygubun(String weeklygubun) {
		this.weeklygubun = weeklygubun;
	}
	
	/**
	 * Column Info
	 * @param attypeby
	 */
	public void setAttypeby(String attypeby) {
		this.attypeby = attypeby;
	}
	
	/**
	 * Column Info
	 * @param fmtypeby
	 */
	public void setFmtypeby(String fmtypeby) {
		this.fmtypeby = fmtypeby;
	}
	
	/**
	 * Column Info
	 * @param dataselect2
	 */
	public void setDataselect2(String dataselect2) {
		this.dataselect2 = dataselect2;
	}
	
	/**
	 * Column Info
	 * @param dataselect1
	 */
	public void setDataselect1(String dataselect1) {
		this.dataselect1 = dataselect1;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
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
	 * @param tofmplnyr
	 */
	public void setTofmplnyr(String tofmplnyr) {
		this.tofmplnyr = tofmplnyr;
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
	 * @param tofmplnwk
	 */
	public void setTofmplnwk(String tofmplnwk) {
		this.tofmplnwk = tofmplnwk;
	}
	
	/**
	 * Column Info
	 * @param totoplnwk
	 */
	public void setTotoplnwk(String totoplnwk) {
		this.totoplnwk = totoplnwk;
	}
	
	/**
	 * Column Info
	 * @param comp
	 */
	public void setComp(String comp) {
		this.comp = comp;
	}
	
	/**
	 * Column Info
	 * @param atfmplnyr
	 */
	public void setAtfmplnyr(String atfmplnyr) {
		this.atfmplnyr = atfmplnyr;
	}
	
	/**
	 * Column Info
	 * @param weekmonth
	 */
	public void setWeekmonth(String weekmonth) {
		this.weekmonth = weekmonth;
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
	 * @param fmtoplnwk
	 */
	public void setFmtoplnwk(String fmtoplnwk) {
		this.fmtoplnwk = fmtoplnwk;
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
	 * @param fmtype
	 */
	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
	}
	
	/**
	 * Column Info
	 * @param totoplnyr
	 */
	public void setTotoplnyr(String totoplnyr) {
		this.totoplnyr = totoplnyr;
	}
	
	/**
	 * Column Info
	 * @param orgdst
	 */
	public void setOrgdst(String orgdst) {
		this.orgdst = orgdst;
	}
	
	/**
	 * Column Info
	 * @param tpszall
	 */
	public void setTpszall(String tpszall) {
		this.tpszall = tpszall;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnyr
	 */
	public void setFmtoplnyr(String fmtoplnyr) {
		this.fmtoplnyr = fmtoplnyr;
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
	 * @param attoplnwk
	 */
	public void setAttoplnwk(String attoplnwk) {
		this.attoplnwk = attoplnwk;
	}
	
	/**
	 * Column Info
	 * @param atfmplnwk
	 */
	public void setAtfmplnwk(String atfmplnwk) {
		this.atfmplnwk = atfmplnwk;
	}
	
	/**
	 * Column Info
	 * @param fmfmplnyr
	 */
	public void setFmfmplnyr(String fmfmplnyr) {
		this.fmfmplnyr = fmfmplnyr;
	}
	
	/**
	 * Column Info
	 * @param attoplnyr
	 */
	public void setAttoplnyr(String attoplnyr) {
		this.attoplnyr = attoplnyr;
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
	 * @param fmfmplnwk
	 */
	public void setFmfmplnwk(String fmfmplnwk) {
		this.fmfmplnwk = fmfmplnwk;
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
	 * @param totypeby
	 */
	public void setTotypeby(String totypeby) {
		this.totypeby = totypeby;
	}
	
	/**
	 * Column Info
	 * @param inclunmatch
	 */
	public void setInclunmatch(String inclunmatch) {
		this.inclunmatch = inclunmatch;
	}
	
	/**
	 * Column Info
	 * @param inclmatch
	 */
	public void setInclmatch(String inclmatch) {
		this.inclmatch = inclmatch;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWeeklygubun(JSPUtil.getParameter(request, "weeklygubun", ""));
		setAttypeby(JSPUtil.getParameter(request, "atTypeBy", ""));
		setFmtypeby(JSPUtil.getParameter(request, "fmTypeBy", ""));
		setDataselect2(JSPUtil.getParameter(request, "dataSelect2", ""));
		setDataselect1(JSPUtil.getParameter(request, "dataSelect1", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTofmplnyr(JSPUtil.getParameter(request, "toFmPlnYr", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmEccCd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTofmplnwk(JSPUtil.getParameter(request, "toFmPlnWk", ""));
		setTotoplnwk(JSPUtil.getParameter(request, "toToPlnWk", ""));
		setComp(JSPUtil.getParameter(request, "comp", ""));
		setAtfmplnyr(JSPUtil.getParameter(request, "atFmPlnYr", ""));
		setWeekmonth(JSPUtil.getParameter(request, "weekMonth", ""));
		setAtecccd(JSPUtil.getParameter(request, "atEccCd", ""));
		setFmtoplnwk(JSPUtil.getParameter(request, "fmToPlnWk", ""));
		setToecccd(JSPUtil.getParameter(request, "toEccCd", ""));
		setFmtype(JSPUtil.getParameter(request, "fmType", ""));
		setTotoplnyr(JSPUtil.getParameter(request, "toToPlnYr", ""));
		setOrgdst(JSPUtil.getParameter(request, "orgDst", ""));
		setTpszall(JSPUtil.getParameter(request, "tpszall", ""));
		setFmtoplnyr(JSPUtil.getParameter(request, "fmToPlnYr", ""));
		setAttype(JSPUtil.getParameter(request, "atType", ""));
		setAttoplnwk(JSPUtil.getParameter(request, "atToPlnWk", ""));
		setAtfmplnwk(JSPUtil.getParameter(request, "atFmPlnWk", ""));
		setFmfmplnyr(JSPUtil.getParameter(request, "fmFmPlnYr", ""));
		setAttoplnyr(JSPUtil.getParameter(request, "atToPlnYr", ""));
		setFmtoat(JSPUtil.getParameter(request, "fmToAt", ""));
		setFmfmplnwk(JSPUtil.getParameter(request, "fmFmPlnWk", ""));
		setTotype(JSPUtil.getParameter(request, "toType", ""));
		setTotypeby(JSPUtil.getParameter(request, "toTypeBy", ""));
		setInclunmatch(JSPUtil.getParameter(request, "inclUnmatch", ""));
		setInclmatch(JSPUtil.getParameter(request, "inclMatch", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0037ConditionVO[]
	 */
	public EesEqr0037ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0037ConditionVO[]
	 */
	public EesEqr0037ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0037ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] weeklygubun = (JSPUtil.getParameter(request, prefix	+ "weeklygubun", length));
			String[] attypeby = (JSPUtil.getParameter(request, prefix	+ "attypeby", length));
			String[] fmtypeby = (JSPUtil.getParameter(request, prefix	+ "fmtypeby", length));
			String[] dataselect2 = (JSPUtil.getParameter(request, prefix	+ "dataselect2", length));
			String[] dataselect1 = (JSPUtil.getParameter(request, prefix	+ "dataselect1", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tofmplnyr = (JSPUtil.getParameter(request, prefix	+ "tofmplnyr", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tofmplnwk = (JSPUtil.getParameter(request, prefix	+ "tofmplnwk", length));
			String[] totoplnwk = (JSPUtil.getParameter(request, prefix	+ "totoplnwk", length));
			String[] comp = (JSPUtil.getParameter(request, prefix	+ "comp", length));
			String[] atfmplnyr = (JSPUtil.getParameter(request, prefix	+ "atfmplnyr", length));
			String[] weekmonth = (JSPUtil.getParameter(request, prefix	+ "weekmonth", length));
			String[] atecccd = (JSPUtil.getParameter(request, prefix	+ "atecccd", length));
			String[] fmtoplnwk = (JSPUtil.getParameter(request, prefix	+ "fmtoplnwk", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] totoplnyr = (JSPUtil.getParameter(request, prefix	+ "totoplnyr", length));
			String[] orgdst = (JSPUtil.getParameter(request, prefix	+ "orgdst", length));
			String[] tpszall = (JSPUtil.getParameter(request, prefix	+ "tpszall", length));
			String[] fmtoplnyr = (JSPUtil.getParameter(request, prefix	+ "fmtoplnyr", length));
			String[] attype = (JSPUtil.getParameter(request, prefix	+ "attype", length));
			String[] attoplnwk = (JSPUtil.getParameter(request, prefix	+ "attoplnwk", length));
			String[] atfmplnwk = (JSPUtil.getParameter(request, prefix	+ "atfmplnwk", length));
			String[] fmfmplnyr = (JSPUtil.getParameter(request, prefix	+ "fmfmplnyr", length));
			String[] attoplnyr = (JSPUtil.getParameter(request, prefix	+ "attoplnyr", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] fmfmplnwk = (JSPUtil.getParameter(request, prefix	+ "fmfmplnwk", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] totypeby = (JSPUtil.getParameter(request, prefix	+ "totypeby", length));
			String[] inclunmatch = (JSPUtil.getParameter(request, prefix	+ "inclunmatch", length));
			String[] inclmatch = (JSPUtil.getParameter(request, prefix	+ "inclmatch", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0037ConditionVO();
				if (weeklygubun[i] != null)
					model.setWeeklygubun(weeklygubun[i]);
				if (attypeby[i] != null)
					model.setAttypeby(attypeby[i]);
				if (fmtypeby[i] != null)
					model.setFmtypeby(fmtypeby[i]);
				if (dataselect2[i] != null)
					model.setDataselect2(dataselect2[i]);
				if (dataselect1[i] != null)
					model.setDataselect1(dataselect1[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tofmplnyr[i] != null)
					model.setTofmplnyr(tofmplnyr[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tofmplnwk[i] != null)
					model.setTofmplnwk(tofmplnwk[i]);
				if (totoplnwk[i] != null)
					model.setTotoplnwk(totoplnwk[i]);
				if (comp[i] != null)
					model.setComp(comp[i]);
				if (atfmplnyr[i] != null)
					model.setAtfmplnyr(atfmplnyr[i]);
				if (weekmonth[i] != null)
					model.setWeekmonth(weekmonth[i]);
				if (atecccd[i] != null)
					model.setAtecccd(atecccd[i]);
				if (fmtoplnwk[i] != null)
					model.setFmtoplnwk(fmtoplnwk[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (totoplnyr[i] != null)
					model.setTotoplnyr(totoplnyr[i]);
				if (orgdst[i] != null)
					model.setOrgdst(orgdst[i]);
				if (tpszall[i] != null)
					model.setTpszall(tpszall[i]);
				if (fmtoplnyr[i] != null)
					model.setFmtoplnyr(fmtoplnyr[i]);
				if (attype[i] != null)
					model.setAttype(attype[i]);
				if (attoplnwk[i] != null)
					model.setAttoplnwk(attoplnwk[i]);
				if (atfmplnwk[i] != null)
					model.setAtfmplnwk(atfmplnwk[i]);
				if (fmfmplnyr[i] != null)
					model.setFmfmplnyr(fmfmplnyr[i]);
				if (attoplnyr[i] != null)
					model.setAttoplnyr(attoplnyr[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (fmfmplnwk[i] != null)
					model.setFmfmplnwk(fmfmplnwk[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (totypeby[i] != null)
					model.setTotypeby(totypeby[i]);
				if (inclunmatch[i] != null)
					model.setInclunmatch(inclunmatch[i]);
				if (inclmatch[i] != null)
					model.setInclmatch(inclmatch[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0037ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0037ConditionVO[]
	 */
	public EesEqr0037ConditionVO[] getEesEqr0037ConditionVOs(){
		EesEqr0037ConditionVO[] vos = (EesEqr0037ConditionVO[])models.toArray(new EesEqr0037ConditionVO[models.size()]);
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
		this.weeklygubun = this.weeklygubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attypeby = this.attypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby = this.fmtypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataselect2 = this.dataselect2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataselect1 = this.dataselect1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tofmplnyr = this.tofmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tofmplnwk = this.tofmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnwk = this.totoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comp = this.comp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnyr = this.atfmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekmonth = this.weekmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd = this.atecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnwk = this.fmtoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnyr = this.totoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgdst = this.orgdst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszall = this.tpszall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnyr = this.fmtoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype = this.attype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnwk = this.attoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnwk = this.atfmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmfmplnyr = this.fmfmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnyr = this.attoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmfmplnwk = this.fmfmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby = this.totypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclunmatch = this.inclunmatch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclmatch = this.inclmatch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
