/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EmptyCODVVDPortVO.java
*@FileTitle : EmptyCODVVDPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EmptyCODVVDPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmptyCODVVDPortVO> models = new ArrayList<EmptyCODVVDPortVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String remarkflag = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String keyid = null;
	/* Column Info */
	private String d2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String updusrid = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String ofccd = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String creusrid = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String weekdivision = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String clptindseq = null;
	/* Column Info */
	private String firstetb = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String etbweek = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String etbweekdivision = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String yardcode = null;
	/* Column Info */
	private String ldflag = null;
	/* Column Info */
	private String r9 = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String o5 = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EmptyCODVVDPortVO() {}

	public EmptyCODVVDPortVO(String ibflag, String pagerows, String etb, String div, String d5, String remarkflag, String d4, String d7, String lane, String keyid, String d2, String a2, String a4, String f2, String f5, String pod, String weekdivision, String s4, String f4, String o2, String s2, String etbweek, String o4, String etbweekdivision, String vvd, String yardcode, String ldflag, String r2, String week, String r5, String r9, String status, String ofccd, String updusrid, String creusrid, String firstetb, String clptindseq, String o5) {
		this.etb = etb;
		this.div = div;
		this.d5 = d5;
		this.d4 = d4;
		this.remarkflag = remarkflag;
		this.d7 = d7;
		this.lane = lane;
		this.pagerows = pagerows;
		this.keyid = keyid;
		this.d2 = d2;
		this.ibflag = ibflag;
		this.updusrid = updusrid;
		this.a2 = a2;
		this.ofccd = ofccd;
		this.a4 = a4;
		this.creusrid = creusrid;
		this.f2 = f2;
		this.f5 = f5;
		this.pod = pod;
		this.weekdivision = weekdivision;
		this.s4 = s4;
		this.f4 = f4;
		this.clptindseq = clptindseq;
		this.firstetb = firstetb;
		this.o2 = o2;
		this.s2 = s2;
		this.etbweek = etbweek;
		this.o4 = o4;
		this.status = status;
		this.etbweekdivision = etbweekdivision;
		this.vvd = vvd;
		this.yardcode = yardcode;
		this.ldflag = ldflag;
		this.r9 = r9;
		this.r2 = r2;
		this.r5 = r5;
		this.week = week;
		this.o5 = o5;
	}
	
	/**
	 * Hashtable<"column_name", "value"> 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("remarkflag", getRemarkflag());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("keyid", getKeyid());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("updusrid", getUpdusrid());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("ofccd", getOfccd());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("creusrid", getCreusrid());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("weekdivision", getWeekdivision());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("clptindseq", getClptindseq());
		this.hashColumns.put("firstetb", getFirstetb());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("etbweek", getEtbweek());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("etbweekdivision", getEtbweekdivision());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("yardcode", getYardcode());
		this.hashColumns.put("ldflag", getLdflag());
		this.hashColumns.put("r9", getR9());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("o5", getO5());
		return this.hashColumns;
	}
	
	/**
	 * Hashtable<"column_name", "variable"> 
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("div", "div");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("remarkflag", "remarkflag");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("keyid", "keyid");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("updusrid", "updusrid");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("ofccd", "ofccd");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("creusrid", "creusrid");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("weekdivision", "weekdivision");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("clptindseq", "clptindseq");
		this.hashFields.put("firstetb", "firstetb");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("etbweek", "etbweek");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("status", "status");
		this.hashFields.put("etbweekdivision", "etbweekdivision");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("yardcode", "yardcode");
		this.hashFields.put("ldflag", "ldflag");
		this.hashFields.put("r9", "r9");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("week", "week");
		this.hashFields.put("o5", "o5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return remarkflag
	 */
	public String getRemarkflag() {
		return this.remarkflag;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
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
	 * Column Info
	 * @return keyid
	 */
	public String getKeyid() {
		return this.keyid;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return updusrid
	 */
	public String getUpdusrid() {
		return this.updusrid;
	}
	
	/**
	 * Column Info
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
	}
	
	/**
	 * Column Info
	 * @return ofccd
	 */
	public String getOfccd() {
		return this.ofccd;
	}
	
	/**
	 * Column Info
	 * @return a4
	 */
	public String getA4() {
		return this.a4;
	}
	
	/**
	 * Column Info
	 * @return creusrid
	 */
	public String getCreusrid() {
		return this.creusrid;
	}
	
	/**
	 * Column Info
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return weekdivision
	 */
	public String getWeekdivision() {
		return this.weekdivision;
	}
	
	/**
	 * Column Info
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
	}
	
	/**
	 * Column Info
	 * @return clptindseq
	 */
	public String getClptindseq() {
		return this.clptindseq;
	}
	
	/**
	 * Column Info
	 * @return firstetb
	 */
	public String getFirstetb() {
		return this.firstetb;
	}
	
	/**
	 * Column Info
	 * @return o2
	 */
	public String getO2() {
		return this.o2;
	}
	
	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
	}
	
	/**
	 * Column Info
	 * @return etbweek
	 */
	public String getEtbweek() {
		return this.etbweek;
	}
	
	/**
	 * Column Info
	 * @return o4
	 */
	public String getO4() {
		return this.o4;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return etbweekdivision
	 */
	public String getEtbweekdivision() {
		return this.etbweekdivision;
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
	 * @return yardcode
	 */
	public String getYardcode() {
		return this.yardcode;
	}
	
	/**
	 * Column Info
	 * @return ldflag
	 */
	public String getLdflag() {
		return this.ldflag;
	}
	
	/**
	 * Column Info
	 * @return r9
	 */
	public String getR9() {
		return this.r9;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
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
	 * @return o5
	 */
	public String getO5() {
		return this.o5;
	}
	

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param remarkflag
	 */
	public void setRemarkflag(String remarkflag) {
		this.remarkflag = remarkflag;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
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
	 * Column Info
	 * @param keyid
	 */
	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param updusrid
	 */
	public void setUpdusrid(String updusrid) {
		this.updusrid = updusrid;
	}
	
	/**
	 * Column Info
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	
	/**
	 * Column Info
	 * @param ofccd
	 */
	public void setOfccd(String ofccd) {
		this.ofccd = ofccd;
	}
	
	/**
	 * Column Info
	 * @param a4
	 */
	public void setA4(String a4) {
		this.a4 = a4;
	}
	
	/**
	 * Column Info
	 * @param creusrid
	 */
	public void setCreusrid(String creusrid) {
		this.creusrid = creusrid;
	}
	
	/**
	 * Column Info
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param weekdivision
	 */
	public void setWeekdivision(String weekdivision) {
		this.weekdivision = weekdivision;
	}
	
	/**
	 * Column Info
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
	}
	
	/**
	 * Column Info
	 * @param clptindseq
	 */
	public void setClptindseq(String clptindseq) {
		this.clptindseq = clptindseq;
	}
	
	/**
	 * Column Info
	 * @param firstetb
	 */
	public void setFirstetb(String firstetb) {
		this.firstetb = firstetb;
	}
	
	/**
	 * Column Info
	 * @param o2
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	
	/**
	 * Column Info
	 * @param etbweek
	 */
	public void setEtbweek(String etbweek) {
		this.etbweek = etbweek;
	}
	
	/**
	 * Column Info
	 * @param o4
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param etbweekdivision
	 */
	public void setEtbweekdivision(String etbweekdivision) {
		this.etbweekdivision = etbweekdivision;
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
	 * @param yardcode
	 */
	public void setYardcode(String yardcode) {
		this.yardcode = yardcode;
	}
	
	/**
	 * Column Info
	 * @param ldflag
	 */
	public void setLdflag(String ldflag) {
		this.ldflag = ldflag;
	}
	
	/**
	 * Column Info
	 * @param r9
	 */
	public void setR9(String r9) {
		this.r9 = r9;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setO5(String o5) {
		this.o5 = o5;
	}
	
/**
	 * Request VO .
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request VO 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setDiv(JSPUtil.getParameter(request, prefix + "div", ""));
		setD5(JSPUtil.getParameter(request, prefix + "d5", ""));
		setD4(JSPUtil.getParameter(request, prefix + "d4", ""));
		setRemarkflag(JSPUtil.getParameter(request, prefix + "remarkflag", ""));
		setD7(JSPUtil.getParameter(request, prefix + "d7", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setKeyid(JSPUtil.getParameter(request, prefix + "keyid", ""));
		setD2(JSPUtil.getParameter(request, prefix + "d2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUpdusrid(JSPUtil.getParameter(request, prefix + "updusrid", ""));
		setA2(JSPUtil.getParameter(request, prefix + "a2", ""));
		setOfccd(JSPUtil.getParameter(request, prefix + "ofccd", ""));
		setA4(JSPUtil.getParameter(request, prefix + "a4", ""));
		setCreusrid(JSPUtil.getParameter(request, prefix + "creusrid", ""));
		setF2(JSPUtil.getParameter(request, prefix + "f2", ""));
		setF5(JSPUtil.getParameter(request, prefix + "f5", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setWeekdivision(JSPUtil.getParameter(request, prefix + "weekdivision", ""));
		setS4(JSPUtil.getParameter(request, prefix + "s4", ""));
		setF4(JSPUtil.getParameter(request, prefix + "f4", ""));
		setClptindseq(JSPUtil.getParameter(request, prefix + "clptindseq", ""));
		setFirstetb(JSPUtil.getParameter(request, prefix + "firstetb", ""));
		setO2(JSPUtil.getParameter(request, prefix + "o2", ""));
		setS2(JSPUtil.getParameter(request, prefix + "s2", ""));
		setEtbweek(JSPUtil.getParameter(request, prefix + "etbweek", ""));
		setO4(JSPUtil.getParameter(request, prefix + "o4", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setEtbweekdivision(JSPUtil.getParameter(request, prefix + "etbweekdivision", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setYardcode(JSPUtil.getParameter(request, prefix + "yardcode", ""));
		setLdflag(JSPUtil.getParameter(request, prefix + "ldflag", ""));
		setR9(JSPUtil.getParameter(request, prefix + "r9", ""));
		setR2(JSPUtil.getParameter(request, prefix + "r2", ""));
		setR5(JSPUtil.getParameter(request, prefix + "r5", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
		setO5(JSPUtil.getParameter(request, prefix + "o5", ""));
	}

	/**
	 * Request  VO 
	 * @param request
	 * @return EmptyCODVVDPortVO[]
	 */
	public EmptyCODVVDPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request DATA
	 * @param request
	 * @param prefix
	 * @return EmptyCODVVDPortVO[]
	 */
	public EmptyCODVVDPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptyCODVVDPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] remarkflag = (JSPUtil.getParameter(request, prefix	+ "remarkflag", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] keyid = (JSPUtil.getParameter(request, prefix	+ "keyid", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] updusrid = (JSPUtil.getParameter(request, prefix	+ "updusrid", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] ofccd = (JSPUtil.getParameter(request, prefix	+ "ofccd", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] creusrid = (JSPUtil.getParameter(request, prefix	+ "creusrid", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] weekdivision = (JSPUtil.getParameter(request, prefix	+ "weekdivision", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] clptindseq = (JSPUtil.getParameter(request, prefix	+ "clptindseq", length));
			String[] firstetb = (JSPUtil.getParameter(request, prefix	+ "firstetb", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] etbweek = (JSPUtil.getParameter(request, prefix	+ "etbweek", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] etbweekdivision = (JSPUtil.getParameter(request, prefix	+ "etbweekdivision", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] yardcode = (JSPUtil.getParameter(request, prefix	+ "yardcode", length));
			String[] ldflag = (JSPUtil.getParameter(request, prefix	+ "ldflag", length));
			String[] r9 = (JSPUtil.getParameter(request, prefix	+ "r9", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] o5 = (JSPUtil.getParameter(request, prefix	+ "o5", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmptyCODVVDPortVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (remarkflag[i] != null)
					model.setRemarkflag(remarkflag[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (keyid[i] != null)
					model.setKeyid(keyid[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updusrid[i] != null)
					model.setUpdusrid(updusrid[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (ofccd[i] != null)
					model.setOfccd(ofccd[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (creusrid[i] != null)
					model.setCreusrid(creusrid[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (weekdivision[i] != null)
					model.setWeekdivision(weekdivision[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (clptindseq[i] != null)
					model.setClptindseq(clptindseq[i]);
				if (firstetb[i] != null)
					model.setFirstetb(firstetb[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (etbweek[i] != null)
					model.setEtbweek(etbweek[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (etbweekdivision[i] != null)
					model.setEtbweekdivision(etbweekdivision[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (yardcode[i] != null)
					model.setYardcode(yardcode[i]);
				if (ldflag[i] != null)
					model.setLdflag(ldflag[i]);
				if (r9[i] != null)
					model.setR9(r9[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (o5[i] != null)
					model.setO5(o5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmptyCODVVDPortVOs();
	}

	/**
	 * VO 
	 * @return EmptyCODVVDPortVO[]
	 */
	public EmptyCODVVDPortVO[] getEmptyCODVVDPortVOs(){
		EmptyCODVVDPortVO[] vos = (EmptyCODVVDPortVO[])models.toArray(new EmptyCODVVDPortVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 
	*/
	public void unDataFormat(){
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarkflag = this.remarkflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyid = this.keyid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updusrid = this.updusrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofccd = this.ofccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creusrid = this.creusrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekdivision = this.weekdivision .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptindseq = this.clptindseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstetb = this.firstetb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbweek = this.etbweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbweekdivision = this.etbweekdivision .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardcode = this.yardcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldflag = this.ldflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9 = this.r9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5 = this.o5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
