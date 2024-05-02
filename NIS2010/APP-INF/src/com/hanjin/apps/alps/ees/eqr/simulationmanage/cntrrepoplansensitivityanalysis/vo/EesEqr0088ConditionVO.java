/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0088ConditionVO.java
*@FileTitle : EesEqr0088ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.22 채창호 
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

public class EesEqr0088ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0088ConditionVO> models = new ArrayList<EesEqr0088ConditionVO>();
	
	/* Column Info */
	private String repormk1 = null;
	/* Column Info */
	private String objecttext = null;
	/* Column Info */
	private String repormk2 = null;
	/* Column Info */
	private String fmendyear = null;
	/* Column Info */
	private String limitobj = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Column Info */
	private String tostartweek = null;
	/* Column Info */
	private String atendyear = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sheet1week = null;
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
	private String tostartyear = null;
	/* Column Info */
	private String yyyyww2 = null;
	/* Column Info */
	private String sens = null;
	/* Column Info */
	private String senstext = null;
	/* Column Info */
	private String yyyyww1 = null;
	/* Column Info */
	private String atstartweek = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String atecccd = null;
	/* Column Info */
	private String toendyear = null;
	/* Column Info */
	private String fmstartyear = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String atstartyear = null;
	/* Column Info */
	private String repoplanid2 = null;
	/* Column Info */
	private String sheet1costcd = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String attype = null;
	/* Column Info */
	private String toendweek = null;
	/* Column Info */
	private String objectcode = null;
	/* Column Info */
	private String fmtoat = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String costobj = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String seq1 = null;
	/* Column Info */
	private String seq2 = null;
	/* Column Info */
	private String senscode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0088ConditionVO() {}

	public EesEqr0088ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String repormk, String repoplanid2, String yyyyww1, String seq1, String repormk1, String yyyyww2, String seq2, String repormk2, String fmtoat, String fmtype, String fmecccd, String totype, String toecccd, String attype, String atecccd, String fmstartyear, String fmstartweek, String fmendyear, String fmendweek, String tostartyear, String tostartweek, String toendyear, String toendweek, String atstartyear, String atstartweek, String atendyear, String atendweek, String cntrtpszcd, String sens, String costobj, String limitobj, String senstext, String objecttext, String senscode, String objectcode, String sheet1week, String sheet1costcd) {
		this.repormk1 = repormk1;
		this.objecttext = objecttext;
		this.repormk2 = repormk2;
		this.fmendyear = fmendyear;
		this.limitobj = limitobj;
		this.cntrtpszcd = cntrtpszcd;
		this.tostartweek = tostartweek;
		this.atendyear = atendyear;
		this.pagerows = pagerows;
		this.sheet1week = sheet1week;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.atendweek = atendweek;
		this.repormk = repormk;
		this.fmstartweek = fmstartweek;
		this.fmendweek = fmendweek;
		this.tostartyear = tostartyear;
		this.yyyyww2 = yyyyww2;
		this.sens = sens;
		this.senstext = senstext;
		this.yyyyww1 = yyyyww1;
		this.atstartweek = atstartweek;
		this.toecccd = toecccd;
		this.atecccd = atecccd;
		this.toendyear = toendyear;
		this.fmstartyear = fmstartyear;
		this.fmtype = fmtype;
		this.atstartyear = atstartyear;
		this.repoplanid2 = repoplanid2;
		this.sheet1costcd = sheet1costcd;
		this.yyyyww = yyyyww;
		this.attype = attype;
		this.toendweek = toendweek;
		this.objectcode = objectcode;
		this.fmtoat = fmtoat;
		this.totype = totype;
		this.costobj = costobj;
		this.seq = seq;
		this.seq1 = seq1;
		this.seq2 = seq2;
		this.senscode = senscode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repormk1", getRepormk1());
		this.hashColumns.put("objecttext", getObjecttext());
		this.hashColumns.put("repormk2", getRepormk2());
		this.hashColumns.put("fmendyear", getFmendyear());
		this.hashColumns.put("limitobj", getLimitobj());
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());
		this.hashColumns.put("tostartweek", getTostartweek());
		this.hashColumns.put("atendyear", getAtendyear());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sheet1week", getSheet1week());
		this.hashColumns.put("fmecccd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("atendweek", getAtendweek());
		this.hashColumns.put("repormk", getRepormk());
		this.hashColumns.put("fmstartweek", getFmstartweek());
		this.hashColumns.put("fmendweek", getFmendweek());
		this.hashColumns.put("tostartyear", getTostartyear());
		this.hashColumns.put("yyyyww2", getYyyyww2());
		this.hashColumns.put("sens", getSens());
		this.hashColumns.put("senstext", getSenstext());
		this.hashColumns.put("yyyyww1", getYyyyww1());
		this.hashColumns.put("atstartweek", getAtstartweek());
		this.hashColumns.put("toecccd", getToecccd());
		this.hashColumns.put("atecccd", getAtecccd());
		this.hashColumns.put("toendyear", getToendyear());
		this.hashColumns.put("fmstartyear", getFmstartyear());
		this.hashColumns.put("fmtype", getFmtype());
		this.hashColumns.put("atstartyear", getAtstartyear());
		this.hashColumns.put("repoplanid2", getRepoplanid2());
		this.hashColumns.put("sheet1costcd", getSheet1costcd());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("attype", getAttype());
		this.hashColumns.put("toendweek", getToendweek());
		this.hashColumns.put("objectcode", getObjectcode());
		this.hashColumns.put("fmtoat", getFmtoat());
		this.hashColumns.put("totype", getTotype());
		this.hashColumns.put("costobj", getCostobj());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("seq1", getSeq1());
		this.hashColumns.put("seq2", getSeq2());
		this.hashColumns.put("senscode", getSenscode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("repormk1", "repormk1");
		this.hashFields.put("objecttext", "objecttext");
		this.hashFields.put("repormk2", "repormk2");
		this.hashFields.put("fmendyear", "fmendyear");
		this.hashFields.put("limitobj", "limitobj");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("tostartweek", "tostartweek");
		this.hashFields.put("atendyear", "atendyear");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sheet1week", "sheet1week");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("atendweek", "atendweek");
		this.hashFields.put("repormk", "repormk");
		this.hashFields.put("fmstartweek", "fmstartweek");
		this.hashFields.put("fmendweek", "fmendweek");
		this.hashFields.put("tostartyear", "tostartyear");
		this.hashFields.put("yyyyww2", "yyyyww2");
		this.hashFields.put("sens", "sens");
		this.hashFields.put("senstext", "senstext");
		this.hashFields.put("yyyyww1", "yyyyww1");
		this.hashFields.put("atstartweek", "atstartweek");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("atecccd", "atecccd");
		this.hashFields.put("toendyear", "toendyear");
		this.hashFields.put("fmstartyear", "fmstartyear");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("atstartyear", "atstartyear");
		this.hashFields.put("repoplanid2", "repoplanid2");
		this.hashFields.put("sheet1costcd", "sheet1costcd");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("attype", "attype");
		this.hashFields.put("toendweek", "toendweek");
		this.hashFields.put("objectcode", "objectcode");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("costobj", "costobj");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("seq1", "seq1");
		this.hashFields.put("seq2", "seq2");
		this.hashFields.put("senscode", "senscode");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repormk1
	 */
	public String getRepormk1() {
		return this.repormk1;
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
	 * @return repormk2
	 */
	public String getRepormk2() {
		return this.repormk2;
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
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
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
	 * @return sheet1week
	 */
	public String getSheet1week() {
		return this.sheet1week;
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
	 * @return tostartyear
	 */
	public String getTostartyear() {
		return this.tostartyear;
	}
	
	/**
	 * Column Info
	 * @return yyyyww2
	 */
	public String getYyyyww2() {
		return this.yyyyww2;
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
	 * @return yyyyww1
	 */
	public String getYyyyww1() {
		return this.yyyyww1;
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
	 * @return toecccd
	 */
	public String getToecccd() {
		return this.toecccd;
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
	 * @return repoplanid2
	 */
	public String getRepoplanid2() {
		return this.repoplanid2;
	}
	
	/**
	 * Column Info
	 * @return sheet1costcd
	 */
	public String getSheet1costcd() {
		return this.sheet1costcd;
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
	 * @return attype
	 */
	public String getAttype() {
		return this.attype;
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
	 * @return objectcode
	 */
	public String getObjectcode() {
		return this.objectcode;
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
	 * @return totype
	 */
	public String getTotype() {
		return this.totype;
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
	 * @return seq1
	 */
	public String getSeq1() {
		return this.seq1;
	}
	
	/**
	 * Column Info
	 * @return seq2
	 */
	public String getSeq2() {
		return this.seq2;
	}
	
	/**
	 * Column Info
	 * @return senscode
	 */
	public String getSenscode() {
		return this.senscode;
	}
	

	/**
	 * Column Info
	 * @param repormk1
	 */
	public void setRepormk1(String repormk1) {
		this.repormk1 = repormk1;
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
	 * @param repormk2
	 */
	public void setRepormk2(String repormk2) {
		this.repormk2 = repormk2;
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
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
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
	 * @param sheet1week
	 */
	public void setSheet1week(String sheet1week) {
		this.sheet1week = sheet1week;
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
	 * @param tostartyear
	 */
	public void setTostartyear(String tostartyear) {
		this.tostartyear = tostartyear;
	}
	
	/**
	 * Column Info
	 * @param yyyyww2
	 */
	public void setYyyyww2(String yyyyww2) {
		this.yyyyww2 = yyyyww2;
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
	 * @param yyyyww1
	 */
	public void setYyyyww1(String yyyyww1) {
		this.yyyyww1 = yyyyww1;
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
	 * @param toecccd
	 */
	public void setToecccd(String toecccd) {
		this.toecccd = toecccd;
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
	 * @param repoplanid2
	 */
	public void setRepoplanid2(String repoplanid2) {
		this.repoplanid2 = repoplanid2;
	}
	
	/**
	 * Column Info
	 * @param sheet1costcd
	 */
	public void setSheet1costcd(String sheet1costcd) {
		this.sheet1costcd = sheet1costcd;
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
	 * @param attype
	 */
	public void setAttype(String attype) {
		this.attype = attype;
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
	 * @param objectcode
	 */
	public void setObjectcode(String objectcode) {
		this.objectcode = objectcode;
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
	 * @param totype
	 */
	public void setTotype(String totype) {
		this.totype = totype;
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
	 * @param seq1
	 */
	public void setSeq1(String seq1) {
		this.seq1 = seq1;
	}
	
	/**
	 * Column Info
	 * @param seq2
	 */
	public void setSeq2(String seq2) {
		this.seq2 = seq2;
	}
	
	/**
	 * Column Info
	 * @param senscode
	 */
	public void setSenscode(String senscode) {
		this.senscode = senscode;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepormk1(JSPUtil.getParameter(request, "repormk1", ""));
		setObjecttext(JSPUtil.getParameter(request, "objecttext", ""));
		setRepormk2(JSPUtil.getParameter(request, "repormk2", ""));
		setFmendyear(JSPUtil.getParameter(request, "fmendyear", ""));
		setLimitobj(JSPUtil.getParameter(request, "limitobj", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrtpszcd", ""));
		setTostartweek(JSPUtil.getParameter(request, "tostartweek", ""));
		setAtendyear(JSPUtil.getParameter(request, "atendyear", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSheet1week(JSPUtil.getParameter(request, "sheet1week", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmecccd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAtendweek(JSPUtil.getParameter(request, "atendweek", ""));
		setRepormk(JSPUtil.getParameter(request, "repormk", ""));
		setFmstartweek(JSPUtil.getParameter(request, "fmstartweek", ""));
		setFmendweek(JSPUtil.getParameter(request, "fmendweek", ""));
		setTostartyear(JSPUtil.getParameter(request, "tostartyear", ""));
		setYyyyww2(JSPUtil.getParameter(request, "yyyyww2", ""));
		setSens(JSPUtil.getParameter(request, "sens", ""));
		setSenstext(JSPUtil.getParameter(request, "senstext", ""));
		setYyyyww1(JSPUtil.getParameter(request, "yyyyww1", ""));
		setAtstartweek(JSPUtil.getParameter(request, "atstartweek", ""));
		setToecccd(JSPUtil.getParameter(request, "toecccd", ""));
		setAtecccd(JSPUtil.getParameter(request, "atecccd", ""));
		setToendyear(JSPUtil.getParameter(request, "toendyear", ""));
		setFmstartyear(JSPUtil.getParameter(request, "fmstartyear", ""));
		setFmtype(JSPUtil.getParameter(request, "fmtype", ""));
		setAtstartyear(JSPUtil.getParameter(request, "atstartyear", ""));
		setRepoplanid2(JSPUtil.getParameter(request, "repoplanid2", ""));
		setSheet1costcd(JSPUtil.getParameter(request, "sheet1costcd", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setAttype(JSPUtil.getParameter(request, "attype", ""));
		setToendweek(JSPUtil.getParameter(request, "toendweek", ""));
		setObjectcode(JSPUtil.getParameter(request, "objectcode", ""));
		setFmtoat(JSPUtil.getParameter(request, "fmtoat", ""));
		setTotype(JSPUtil.getParameter(request, "totype", ""));
		setCostobj(JSPUtil.getParameter(request, "costobj", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setSeq1(JSPUtil.getParameter(request, "seq1", ""));
		setSeq2(JSPUtil.getParameter(request, "seq2", ""));
		setSenscode(JSPUtil.getParameter(request, "senscode", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0088ConditionVO[]
	 */
	public EesEqr0088ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0088ConditionVO[]
	 */
	public EesEqr0088ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0088ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repormk1 = (JSPUtil.getParameter(request, prefix	+ "repormk1", length));
			String[] objecttext = (JSPUtil.getParameter(request, prefix	+ "objecttext", length));
			String[] repormk2 = (JSPUtil.getParameter(request, prefix	+ "repormk2", length));
			String[] fmendyear = (JSPUtil.getParameter(request, prefix	+ "fmendyear", length));
			String[] limitobj = (JSPUtil.getParameter(request, prefix	+ "limitobj", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] tostartweek = (JSPUtil.getParameter(request, prefix	+ "tostartweek", length));
			String[] atendyear = (JSPUtil.getParameter(request, prefix	+ "atendyear", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sheet1week = (JSPUtil.getParameter(request, prefix	+ "sheet1week", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] atendweek = (JSPUtil.getParameter(request, prefix	+ "atendweek", length));
			String[] repormk = (JSPUtil.getParameter(request, prefix	+ "repormk", length));
			String[] fmstartweek = (JSPUtil.getParameter(request, prefix	+ "fmstartweek", length));
			String[] fmendweek = (JSPUtil.getParameter(request, prefix	+ "fmendweek", length));
			String[] tostartyear = (JSPUtil.getParameter(request, prefix	+ "tostartyear", length));
			String[] yyyyww2 = (JSPUtil.getParameter(request, prefix	+ "yyyyww2", length));
			String[] sens = (JSPUtil.getParameter(request, prefix	+ "sens", length));
			String[] senstext = (JSPUtil.getParameter(request, prefix	+ "senstext", length));
			String[] yyyyww1 = (JSPUtil.getParameter(request, prefix	+ "yyyyww1", length));
			String[] atstartweek = (JSPUtil.getParameter(request, prefix	+ "atstartweek", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] atecccd = (JSPUtil.getParameter(request, prefix	+ "atecccd", length));
			String[] toendyear = (JSPUtil.getParameter(request, prefix	+ "toendyear", length));
			String[] fmstartyear = (JSPUtil.getParameter(request, prefix	+ "fmstartyear", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] atstartyear = (JSPUtil.getParameter(request, prefix	+ "atstartyear", length));
			String[] repoplanid2 = (JSPUtil.getParameter(request, prefix	+ "repoplanid2", length));
			String[] sheet1costcd = (JSPUtil.getParameter(request, prefix	+ "sheet1costcd", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] attype = (JSPUtil.getParameter(request, prefix	+ "attype", length));
			String[] toendweek = (JSPUtil.getParameter(request, prefix	+ "toendweek", length));
			String[] objectcode = (JSPUtil.getParameter(request, prefix	+ "objectcode", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] costobj = (JSPUtil.getParameter(request, prefix	+ "costobj", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] seq1 = (JSPUtil.getParameter(request, prefix	+ "seq1", length));
			String[] seq2 = (JSPUtil.getParameter(request, prefix	+ "seq2", length));
			String[] senscode = (JSPUtil.getParameter(request, prefix	+ "senscode", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0088ConditionVO();
				if (repormk1[i] != null)
					model.setRepormk1(repormk1[i]);
				if (objecttext[i] != null)
					model.setObjecttext(objecttext[i]);
				if (repormk2[i] != null)
					model.setRepormk2(repormk2[i]);
				if (fmendyear[i] != null)
					model.setFmendyear(fmendyear[i]);
				if (limitobj[i] != null)
					model.setLimitobj(limitobj[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (tostartweek[i] != null)
					model.setTostartweek(tostartweek[i]);
				if (atendyear[i] != null)
					model.setAtendyear(atendyear[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sheet1week[i] != null)
					model.setSheet1week(sheet1week[i]);
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
				if (tostartyear[i] != null)
					model.setTostartyear(tostartyear[i]);
				if (yyyyww2[i] != null)
					model.setYyyyww2(yyyyww2[i]);
				if (sens[i] != null)
					model.setSens(sens[i]);
				if (senstext[i] != null)
					model.setSenstext(senstext[i]);
				if (yyyyww1[i] != null)
					model.setYyyyww1(yyyyww1[i]);
				if (atstartweek[i] != null)
					model.setAtstartweek(atstartweek[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (atecccd[i] != null)
					model.setAtecccd(atecccd[i]);
				if (toendyear[i] != null)
					model.setToendyear(toendyear[i]);
				if (fmstartyear[i] != null)
					model.setFmstartyear(fmstartyear[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (atstartyear[i] != null)
					model.setAtstartyear(atstartyear[i]);
				if (repoplanid2[i] != null)
					model.setRepoplanid2(repoplanid2[i]);
				if (sheet1costcd[i] != null)
					model.setSheet1costcd(sheet1costcd[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (attype[i] != null)
					model.setAttype(attype[i]);
				if (toendweek[i] != null)
					model.setToendweek(toendweek[i]);
				if (objectcode[i] != null)
					model.setObjectcode(objectcode[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (costobj[i] != null)
					model.setCostobj(costobj[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (seq1[i] != null)
					model.setSeq1(seq1[i]);
				if (seq2[i] != null)
					model.setSeq2(seq2[i]);
				if (senscode[i] != null)
					model.setSenscode(senscode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0088ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0088ConditionVO[]
	 */
	public EesEqr0088ConditionVO[] getEesEqr0088ConditionVOs(){
		EesEqr0088ConditionVO[] vos = (EesEqr0088ConditionVO[])models.toArray(new EesEqr0088ConditionVO[models.size()]);
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
		this.repormk1 = this.repormk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objecttext = this.objecttext .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repormk2 = this.repormk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmendyear = this.fmendyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.limitobj = this.limitobj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tostartweek = this.tostartweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atendyear = this.atendyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheet1week = this.sheet1week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atendweek = this.atendweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repormk = this.repormk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmstartweek = this.fmstartweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmendweek = this.fmendweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tostartyear = this.tostartyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww2 = this.yyyyww2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sens = this.sens .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senstext = this.senstext .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww1 = this.yyyyww1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atstartweek = this.atstartweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd = this.atecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toendyear = this.toendyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmstartyear = this.fmstartyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atstartyear = this.atstartyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoplanid2 = this.repoplanid2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheet1costcd = this.sheet1costcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype = this.attype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toendweek = this.toendweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objectcode = this.objectcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costobj = this.costobj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq1 = this.seq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq2 = this.seq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senscode = this.senscode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
