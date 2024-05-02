/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MtyWeeklySimulationVO.java
*@FileTitle : MtyWeeklySimulationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.09.17 나상보 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo;

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
 * @author 나상보
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ForecastReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ForecastReportVO> models = new ArrayList<ForecastReportVO>();
	
	/* Column Info */
	private String f2Q = null;
	/* Column Info */
	private String sort = null;
	/* Column Info */
	private String s4Q = null;
	/* Column Info */
	private String d4F = null;
	/* Column Info */
	private String oriOriLocCd = null;
	/* Column Info */
	private String s2Q = null;
	/* Column Info */
	private String f4Q = null;
	/* Column Info */
	private String r2Q = null;
	/* Column Info */
	private String d4Q = null;
	/* Column Info */
	private String d2F = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s2F = null;
	/* Column Info */
	private String d7Q = null;
	/* Column Info */
	private String r9F = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tree = null;
	/* Column Info */
	private String s4F = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String headWeek = null;
	/* Column Info */
	private String dtotal = null;
	/* Column Info */
	private String a2Q = null;
	/* Column Info */
	private String f5F = null;
	/* Column Info */
	private String r2F = null;
	/* Column Info */
	private String d7F = null;
	/* Column Info */
	private String locGrpCd = null;
	/* Column Info */
	private String d5F = null;
	/* Column Info */
	private String a2F = null;
	/* Column Info */
	private String o4F = null;
	/* Column Info */
	private String r9Q = null;
	/* Column Info */
	private String o2F = null;
	/* Column Info */
	private String a4Q = null;
	/* Column Info */
	private String a5Q = null;	
	/* Column Info */
	private String oriOriOriLocCd = null;
	/* Column Info */
	private String d5Q = null;
	/* Column Info */
	private String f5Q = null;
	/* Column Info */
	private String a4F = null;
	/* Column Info */
	private String a5F = null;	
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String o2Q = null;
	/* Column Info */
	private String o4Q = null;
	/* Column Info */
	private String d2Q = null;
	/* Column Info */
	private String oriLocCd = null;
	/* Column Info */
	private String r5F = null;
	/* Column Info */
	private String f2F = null;
	/* Column Info */
	private String r5Q = null;
	/* Column Info */
	private String f4F = null;
	/* Column Info */
	private String gtotal = null;
	/* Column Info */
	private String stotal = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ForecastReportVO() {}

	public ForecastReportVO(String ibflag, String pagerows, String locCd, String locGrpCd, String code, String name, String sort, String week, String gtotal, String dtotal, String stotal, String d2Q, String d4Q, String d5Q, String d7Q, String r2Q, String r5Q, String r9Q, String o2Q, String s2Q, String o4Q, String s4Q, String f2Q, String a2Q, String f4Q, String a4Q, String a5Q, String f5Q, String d2F, String d4F, String d5F, String d7F, String r2F, String r5F, String r9F, String o2F, String s2F, String o4F, String s4F, String f2F, String a2F, String f4F, String a4F, String a5F, String f5F, String tree, String oriLocCd, String oriOriLocCd, String oriOriOriLocCd, String headWeek) {
		this.f2Q = f2Q;
		this.sort = sort;
		this.s4Q = s4Q;
		this.d4F = d4F;
		this.oriOriLocCd = oriOriLocCd;
		this.s2Q = s2Q;
		this.f4Q = f4Q;
		this.r2Q = r2Q;
		this.d4Q = d4Q;
		this.d2F = d2F;
		this.pagerows = pagerows;
		this.s2F = s2F;
		this.d7Q = d7Q;
		this.r9F = r9F;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.tree = tree;
		this.s4F = s4F;
		this.name = name;
		this.headWeek = headWeek;
		this.dtotal = dtotal;
		this.a2Q = a2Q;
		this.f5F = f5F;
		this.r2F = r2F;
		this.d7F = d7F;
		this.locGrpCd = locGrpCd;
		this.d5F = d5F;
		this.a2F = a2F;
		this.o4F = o4F;
		this.r9Q = r9Q;
		this.o2F = o2F;
		this.a4Q = a4Q;
		this.a5Q = a5Q;
		this.oriOriOriLocCd = oriOriOriLocCd;
		this.d5Q = d5Q;
		this.f5Q = f5Q;
		this.a4F = a4F;
		this.a5F = a5F;
		this.code = code;
		this.o2Q = o2Q;
		this.o4Q = o4Q;
		this.d2Q = d2Q;
		this.oriLocCd = oriLocCd;
		this.r5F = r5F;
		this.f2F = f2F;
		this.r5Q = r5Q;
		this.f4F = f4F;
		this.gtotal = gtotal;
		this.stotal = stotal;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f2_q", getF2Q());
		this.hashColumns.put("sort", getSort());
		this.hashColumns.put("s4_q", getS4Q());
		this.hashColumns.put("d4_f", getD4F());
		this.hashColumns.put("ori_ori_loc_cd", getOriOriLocCd());
		this.hashColumns.put("s2_q", getS2Q());
		this.hashColumns.put("f4_q", getF4Q());
		this.hashColumns.put("r2_q", getR2Q());
		this.hashColumns.put("d4_q", getD4Q());
		this.hashColumns.put("d2_f", getD2F());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s2_f", getS2F());
		this.hashColumns.put("d7_q", getD7Q());
		this.hashColumns.put("r9_f", getR9F());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tree", getTree());
		this.hashColumns.put("s4_f", getS4F());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("head_week", getHeadWeek());
		this.hashColumns.put("dtotal", getDtotal());
		this.hashColumns.put("a2_q", getA2Q());
		this.hashColumns.put("f5_f", getF5F());
		this.hashColumns.put("r2_f", getR2F());
		this.hashColumns.put("d7_f", getD7F());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());
		this.hashColumns.put("d5_f", getD5F());
		this.hashColumns.put("a2_f", getA2F());
		this.hashColumns.put("o4_f", getO4F());
		this.hashColumns.put("r9_q", getR9Q());
		this.hashColumns.put("o2_f", getO2F());
		this.hashColumns.put("a4_q", getA4Q());
		this.hashColumns.put("a5_q", getA5Q());
		this.hashColumns.put("ori_ori_ori_loc_cd", getOriOriOriLocCd());
		this.hashColumns.put("d5_q", getD5Q());
		this.hashColumns.put("f5_q", getF5Q());
		this.hashColumns.put("a4_f", getA4F());
		this.hashColumns.put("a5_f", getA5F());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("o2_q", getO2Q());
		this.hashColumns.put("o4_q", getO4Q());
		this.hashColumns.put("d2_q", getD2Q());
		this.hashColumns.put("ori_loc_cd", getOriLocCd());
		this.hashColumns.put("r5_f", getR5F());
		this.hashColumns.put("f2_f", getF2F());
		this.hashColumns.put("r5_q", getR5Q());
		this.hashColumns.put("f4_f", getF4F());
		this.hashColumns.put("gtotal", getGtotal());
		this.hashColumns.put("stotal", getStotal());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f2_q", "f2Q");
		this.hashFields.put("sort", "sort");
		this.hashFields.put("s4_q", "s4Q");
		this.hashFields.put("d4_f", "d4F");
		this.hashFields.put("ori_ori_loc_cd", "oriOriLocCd");
		this.hashFields.put("s2_q", "s2Q");
		this.hashFields.put("f4_q", "f4Q");
		this.hashFields.put("r2_q", "r2Q");
		this.hashFields.put("d4_q", "d4Q");
		this.hashFields.put("d2_f", "d2F");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s2_f", "s2F");
		this.hashFields.put("d7_q", "d7Q");
		this.hashFields.put("r9_f", "r9F");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tree", "tree");
		this.hashFields.put("s4_f", "s4F");
		this.hashFields.put("name", "name");
		this.hashFields.put("head_week", "headWeek");
		this.hashFields.put("dtotal", "dtotal");
		this.hashFields.put("a2_q", "a2Q");
		this.hashFields.put("f5_f", "f5F");
		this.hashFields.put("r2_f", "r2F");
		this.hashFields.put("d7_f", "d7F");
		this.hashFields.put("loc_grp_cd", "locGrpCd");
		this.hashFields.put("d5_f", "d5F");
		this.hashFields.put("a2_f", "a2F");
		this.hashFields.put("o4_f", "o4F");
		this.hashFields.put("r9_q", "r9Q");
		this.hashFields.put("o2_f", "o2F");
		this.hashFields.put("a4_q", "a4Q");
		this.hashFields.put("a5_q", "a5Q");
		this.hashFields.put("ori_ori_ori_loc_cd", "oriOriOriLocCd");
		this.hashFields.put("d5_q", "d5Q");
		this.hashFields.put("f5_q", "f5Q");
		this.hashFields.put("a4_f", "a4F");
		this.hashFields.put("a5_f", "a5F");
		this.hashFields.put("code", "code");
		this.hashFields.put("o2_q", "o2Q");
		this.hashFields.put("o4_q", "o4Q");
		this.hashFields.put("d2_q", "d2Q");
		this.hashFields.put("ori_loc_cd", "oriLocCd");
		this.hashFields.put("r5_f", "r5F");
		this.hashFields.put("f2_f", "f2F");
		this.hashFields.put("r5_q", "r5Q");
		this.hashFields.put("f4_f", "f4F");
		this.hashFields.put("gtotal", "gtotal");
		this.hashFields.put("stotal", "stotal");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return f2Q
	 */
	public String getF2Q() {
		return this.f2Q;
	}
	
	/**
	 * Column Info
	 * @return sort
	 */
	public String getSort() {
		return this.sort;
	}
	
	/**
	 * Column Info
	 * @return s4Q
	 */
	public String getS4Q() {
		return this.s4Q;
	}
	
	/**
	 * Column Info
	 * @return d4F
	 */
	public String getD4F() {
		return this.d4F;
	}
	
	/**
	 * Column Info
	 * @return oriOriLocCd
	 */
	public String getOriOriLocCd() {
		return this.oriOriLocCd;
	}
	
	/**
	 * Column Info
	 * @return s2Q
	 */
	public String getS2Q() {
		return this.s2Q;
	}
	
	/**
	 * Column Info
	 * @return f4Q
	 */
	public String getF4Q() {
		return this.f4Q;
	}
	
	/**
	 * Column Info
	 * @return r2Q
	 */
	public String getR2Q() {
		return this.r2Q;
	}
	
	/**
	 * Column Info
	 * @return d4Q
	 */
	public String getD4Q() {
		return this.d4Q;
	}
	
	/**
	 * Column Info
	 * @return d2F
	 */
	public String getD2F() {
		return this.d2F;
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
	 * @return s2F
	 */
	public String getS2F() {
		return this.s2F;
	}
	
	/**
	 * Column Info
	 * @return d7Q
	 */
	public String getD7Q() {
		return this.d7Q;
	}
	
	/**
	 * Column Info
	 * @return r9F
	 */
	public String getR9F() {
		return this.r9F;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return tree
	 */
	public String getTree() {
		return this.tree;
	}
	
	/**
	 * Column Info
	 * @return s4F
	 */
	public String getS4F() {
		return this.s4F;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return headWeek
	 */
	public String getHeadWeek() {
		return this.headWeek;
	}
	
	/**
	 * Column Info
	 * @return dtotal
	 */
	public String getDtotal() {
		return this.dtotal;
	}
	
	/**
	 * Column Info
	 * @return a2Q
	 */
	public String getA2Q() {
		return this.a2Q;
	}
	
	/**
	 * Column Info
	 * @return f5F
	 */
	public String getF5F() {
		return this.f5F;
	}
	
	/**
	 * Column Info
	 * @return r2F
	 */
	public String getR2F() {
		return this.r2F;
	}
	
	/**
	 * Column Info
	 * @return d7F
	 */
	public String getD7F() {
		return this.d7F;
	}
	
	/**
	 * Column Info
	 * @return locGrpCd
	 */
	public String getLocGrpCd() {
		return this.locGrpCd;
	}
	
	/**
	 * Column Info
	 * @return d5F
	 */
	public String getD5F() {
		return this.d5F;
	}
	
	/**
	 * Column Info
	 * @return a2F
	 */
	public String getA2F() {
		return this.a2F;
	}
	
	/**
	 * Column Info
	 * @return o4F
	 */
	public String getO4F() {
		return this.o4F;
	}
	
	/**
	 * Column Info
	 * @return r9Q
	 */
	public String getR9Q() {
		return this.r9Q;
	}
	
	/**
	 * Column Info
	 * @return o2F
	 */
	public String getO2F() {
		return this.o2F;
	}
	
	/**
	 * Column Info
	 * @return a4Q
	 */
	public String getA4Q() {
		return this.a4Q;
	}
	
	/**
	 * Column Info
	 * @return oriOriOriLocCd
	 */
	public String getOriOriOriLocCd() {
		return this.oriOriOriLocCd;
	}
	
	/**
	 * Column Info
	 * @return d5Q
	 */
	public String getD5Q() {
		return this.d5Q;
	}
	
	/**
	 * Column Info
	 * @return f5Q
	 */
	public String getF5Q() {
		return this.f5Q;
	}
	
	/**
	 * Column Info
	 * @return a4F
	 */
	public String getA4F() {
		return this.a4F;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return o2Q
	 */
	public String getO2Q() {
		return this.o2Q;
	}
	
	/**
	 * Column Info
	 * @return o4Q
	 */
	public String getO4Q() {
		return this.o4Q;
	}
	
	/**
	 * Column Info
	 * @return d2Q
	 */
	public String getD2Q() {
		return this.d2Q;
	}
	
	/**
	 * Column Info
	 * @return oriLocCd
	 */
	public String getOriLocCd() {
		return this.oriLocCd;
	}
	
	/**
	 * Column Info
	 * @return r5F
	 */
	public String getR5F() {
		return this.r5F;
	}
	
	/**
	 * Column Info
	 * @return f2F
	 */
	public String getF2F() {
		return this.f2F;
	}
	
	/**
	 * Column Info
	 * @return r5Q
	 */
	public String getR5Q() {
		return this.r5Q;
	}
	
	/**
	 * Column Info
	 * @return f4F
	 */
	public String getF4F() {
		return this.f4F;
	}
	
	/**
	 * Column Info
	 * @return gtotal
	 */
	public String getGtotal() {
		return this.gtotal;
	}
	
	/**
	 * Column Info
	 * @return stotal
	 */
	public String getStotal() {
		return this.stotal;
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
	 * @param f2Q
	 */
	public void setF2Q(String f2Q) {
		this.f2Q = f2Q;
	}
	
	/**
	 * Column Info
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	/**
	 * Column Info
	 * @param s4Q
	 */
	public void setS4Q(String s4Q) {
		this.s4Q = s4Q;
	}
	
	/**
	 * Column Info
	 * @param d4F
	 */
	public void setD4F(String d4F) {
		this.d4F = d4F;
	}
	
	/**
	 * Column Info
	 * @param oriOriLocCd
	 */
	public void setOriOriLocCd(String oriOriLocCd) {
		this.oriOriLocCd = oriOriLocCd;
	}
	
	/**
	 * Column Info
	 * @param s2Q
	 */
	public void setS2Q(String s2Q) {
		this.s2Q = s2Q;
	}
	
	/**
	 * Column Info
	 * @param f4Q
	 */
	public void setF4Q(String f4Q) {
		this.f4Q = f4Q;
	}
	
	/**
	 * Column Info
	 * @param r2Q
	 */
	public void setR2Q(String r2Q) {
		this.r2Q = r2Q;
	}
	
	/**
	 * Column Info
	 * @param d4Q
	 */
	public void setD4Q(String d4Q) {
		this.d4Q = d4Q;
	}
	
	/**
	 * Column Info
	 * @param d2F
	 */
	public void setD2F(String d2F) {
		this.d2F = d2F;
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
	 * @param s2F
	 */
	public void setS2F(String s2F) {
		this.s2F = s2F;
	}
	
	/**
	 * Column Info
	 * @param d7Q
	 */
	public void setD7Q(String d7Q) {
		this.d7Q = d7Q;
	}
	
	/**
	 * Column Info
	 * @param r9F
	 */
	public void setR9F(String r9F) {
		this.r9F = r9F;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param tree
	 */
	public void setTree(String tree) {
		this.tree = tree;
	}
	
	/**
	 * Column Info
	 * @param s4F
	 */
	public void setS4F(String s4F) {
		this.s4F = s4F;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param headWeek
	 */
	public void setHeadWeek(String headWeek) {
		this.headWeek = headWeek;
	}
	
	/**
	 * Column Info
	 * @param dtotal
	 */
	public void setDtotal(String dtotal) {
		this.dtotal = dtotal;
	}
	
	/**
	 * Column Info
	 * @param a2Q
	 */
	public void setA2Q(String a2Q) {
		this.a2Q = a2Q;
	}
	
	/**
	 * Column Info
	 * @param f5F
	 */
	public void setF5F(String f5F) {
		this.f5F = f5F;
	}
	
	/**
	 * Column Info
	 * @param r2F
	 */
	public void setR2F(String r2F) {
		this.r2F = r2F;
	}
	
	/**
	 * Column Info
	 * @param d7F
	 */
	public void setD7F(String d7F) {
		this.d7F = d7F;
	}
	
	/**
	 * Column Info
	 * @param locGrpCd
	 */
	public void setLocGrpCd(String locGrpCd) {
		this.locGrpCd = locGrpCd;
	}
	
	/**
	 * Column Info
	 * @param d5F
	 */
	public void setD5F(String d5F) {
		this.d5F = d5F;
	}
	
	/**
	 * Column Info
	 * @param a2F
	 */
	public void setA2F(String a2F) {
		this.a2F = a2F;
	}
	
	/**
	 * Column Info
	 * @param o4F
	 */
	public void setO4F(String o4F) {
		this.o4F = o4F;
	}
	
	/**
	 * Column Info
	 * @param r9Q
	 */
	public void setR9Q(String r9Q) {
		this.r9Q = r9Q;
	}
	
	/**
	 * Column Info
	 * @param o2F
	 */
	public void setO2F(String o2F) {
		this.o2F = o2F;
	}
	
	/**
	 * Column Info
	 * @param a4Q
	 */
	public void setA4Q(String a4Q) {
		this.a4Q = a4Q;
	}
	
	/**
	 * Column Info
	 * @param oriOriOriLocCd
	 */
	public void setOriOriOriLocCd(String oriOriOriLocCd) {
		this.oriOriOriLocCd = oriOriOriLocCd;
	}
	
	/**
	 * Column Info
	 * @param d5Q
	 */
	public void setD5Q(String d5Q) {
		this.d5Q = d5Q;
	}
	
	/**
	 * Column Info
	 * @param f5Q
	 */
	public void setF5Q(String f5Q) {
		this.f5Q = f5Q;
	}
	
	/**
	 * Column Info
	 * @param a4F
	 */
	public void setA4F(String a4F) {
		this.a4F = a4F;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param o2Q
	 */
	public void setO2Q(String o2Q) {
		this.o2Q = o2Q;
	}
	
	/**
	 * Column Info
	 * @param o4Q
	 */
	public void setO4Q(String o4Q) {
		this.o4Q = o4Q;
	}
	
	/**
	 * Column Info
	 * @param d2Q
	 */
	public void setD2Q(String d2Q) {
		this.d2Q = d2Q;
	}
	
	/**
	 * Column Info
	 * @param oriLocCd
	 */
	public void setOriLocCd(String oriLocCd) {
		this.oriLocCd = oriLocCd;
	}
	
	/**
	 * Column Info
	 * @param r5F
	 */
	public void setR5F(String r5F) {
		this.r5F = r5F;
	}
	
	/**
	 * Column Info
	 * @param f2F
	 */
	public void setF2F(String f2F) {
		this.f2F = f2F;
	}
	
	/**
	 * Column Info
	 * @param r5Q
	 */
	public void setR5Q(String r5Q) {
		this.r5Q = r5Q;
	}
	
	/**
	 * Column Info
	 * @param f4F
	 */
	public void setF4F(String f4F) {
		this.f4F = f4F;
	}
	
	/**
	 * Column Info
	 * @param gtotal
	 */
	public void setGtotal(String gtotal) {
		this.gtotal = gtotal;
	}
	
	/**
	 * Column Info
	 * @param stotal
	 */
	public void setStotal(String stotal) {
		this.stotal = stotal;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
		setF2Q(JSPUtil.getParameter(request, prefix + "f2_q", ""));
		setSort(JSPUtil.getParameter(request, prefix + "sort", ""));
		setS4Q(JSPUtil.getParameter(request, prefix + "s4_q", ""));
		setD4F(JSPUtil.getParameter(request, prefix + "d4_f", ""));
		setOriOriLocCd(JSPUtil.getParameter(request, prefix + "ori_ori_loc_cd", ""));
		setS2Q(JSPUtil.getParameter(request, prefix + "s2_q", ""));
		setF4Q(JSPUtil.getParameter(request, prefix + "f4_q", ""));
		setR2Q(JSPUtil.getParameter(request, prefix + "r2_q", ""));
		setD4Q(JSPUtil.getParameter(request, prefix + "d4_q", ""));
		setD2F(JSPUtil.getParameter(request, prefix + "d2_f", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setS2F(JSPUtil.getParameter(request, prefix + "s2_f", ""));
		setD7Q(JSPUtil.getParameter(request, prefix + "d7_q", ""));
		setR9F(JSPUtil.getParameter(request, prefix + "r9_f", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTree(JSPUtil.getParameter(request, prefix + "tree", ""));
		setS4F(JSPUtil.getParameter(request, prefix + "s4_f", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setHeadWeek(JSPUtil.getParameter(request, prefix + "head_week", ""));
		setDtotal(JSPUtil.getParameter(request, prefix + "dtotal", ""));
		setA2Q(JSPUtil.getParameter(request, prefix + "a2_q", ""));
		setF5F(JSPUtil.getParameter(request, prefix + "f5_f", ""));
		setR2F(JSPUtil.getParameter(request, prefix + "r2_f", ""));
		setD7F(JSPUtil.getParameter(request, prefix + "d7_f", ""));
		setLocGrpCd(JSPUtil.getParameter(request, prefix + "loc_grp_cd", ""));
		setD5F(JSPUtil.getParameter(request, prefix + "d5_f", ""));
		setA2F(JSPUtil.getParameter(request, prefix + "a2_f", ""));
		setO4F(JSPUtil.getParameter(request, prefix + "o4_f", ""));
		setR9Q(JSPUtil.getParameter(request, prefix + "r9_q", ""));
		setO2F(JSPUtil.getParameter(request, prefix + "o2_f", ""));
		setA4Q(JSPUtil.getParameter(request, prefix + "a4_q", ""));
		setA5Q(JSPUtil.getParameter(request, prefix + "a5_q", ""));
		setOriOriOriLocCd(JSPUtil.getParameter(request, prefix + "ori_ori_ori_loc_cd", ""));
		setD5Q(JSPUtil.getParameter(request, prefix + "d5_q", ""));
		setF5Q(JSPUtil.getParameter(request, prefix + "f5_q", ""));
		setA4F(JSPUtil.getParameter(request, prefix + "a4_f", ""));
		setA5F(JSPUtil.getParameter(request, prefix + "a5_f", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setO2Q(JSPUtil.getParameter(request, prefix + "o2_q", ""));
		setO4Q(JSPUtil.getParameter(request, prefix + "o4_q", ""));
		setD2Q(JSPUtil.getParameter(request, prefix + "d2_q", ""));
		setOriLocCd(JSPUtil.getParameter(request, prefix + "ori_loc_cd", ""));
		setR5F(JSPUtil.getParameter(request, prefix + "r5_f", ""));
		setF2F(JSPUtil.getParameter(request, prefix + "f2_f", ""));
		setR5Q(JSPUtil.getParameter(request, prefix + "r5_q", ""));
		setF4F(JSPUtil.getParameter(request, prefix + "f4_f", ""));
		setGtotal(JSPUtil.getParameter(request, prefix + "gtotal", ""));
		setStotal(JSPUtil.getParameter(request, prefix + "stotal", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyWeeklySimulationVO[]
	 */
	public ForecastReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyWeeklySimulationVO[]
	 */
	public ForecastReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ForecastReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] f2Q = (JSPUtil.getParameter(request, prefix	+ "f2_q", length));
			String[] sort = (JSPUtil.getParameter(request, prefix	+ "sort", length));
			String[] s4Q = (JSPUtil.getParameter(request, prefix	+ "s4_q", length));
			String[] d4F = (JSPUtil.getParameter(request, prefix	+ "d4_f", length));
			String[] oriOriLocCd = (JSPUtil.getParameter(request, prefix	+ "ori_ori_loc_cd", length));
			String[] s2Q = (JSPUtil.getParameter(request, prefix	+ "s2_q", length));
			String[] f4Q = (JSPUtil.getParameter(request, prefix	+ "f4_q", length));
			String[] r2Q = (JSPUtil.getParameter(request, prefix	+ "r2_q", length));
			String[] d4Q = (JSPUtil.getParameter(request, prefix	+ "d4_q", length));
			String[] d2F = (JSPUtil.getParameter(request, prefix	+ "d2_f", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s2F = (JSPUtil.getParameter(request, prefix	+ "s2_f", length));
			String[] d7Q = (JSPUtil.getParameter(request, prefix	+ "d7_q", length));
			String[] r9F = (JSPUtil.getParameter(request, prefix	+ "r9_f", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tree = (JSPUtil.getParameter(request, prefix	+ "tree", length));
			String[] s4F = (JSPUtil.getParameter(request, prefix	+ "s4_f", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] headWeek = (JSPUtil.getParameter(request, prefix	+ "head_week", length));
			String[] dtotal = (JSPUtil.getParameter(request, prefix	+ "dtotal", length));
			String[] a2Q = (JSPUtil.getParameter(request, prefix	+ "a2_q", length));
			String[] f5F = (JSPUtil.getParameter(request, prefix	+ "f5_f", length));
			String[] r2F = (JSPUtil.getParameter(request, prefix	+ "r2_f", length));
			String[] d7F = (JSPUtil.getParameter(request, prefix	+ "d7_f", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));
			String[] d5F = (JSPUtil.getParameter(request, prefix	+ "d5_f", length));
			String[] a2F = (JSPUtil.getParameter(request, prefix	+ "a2_f", length));
			String[] o4F = (JSPUtil.getParameter(request, prefix	+ "o4_f", length));
			String[] r9Q = (JSPUtil.getParameter(request, prefix	+ "r9_q", length));
			String[] o2F = (JSPUtil.getParameter(request, prefix	+ "o2_f", length));
			String[] a4Q = (JSPUtil.getParameter(request, prefix	+ "a4_q", length));
			String[] a5Q = (JSPUtil.getParameter(request, prefix	+ "a5_q", length));
			String[] oriOriOriLocCd = (JSPUtil.getParameter(request, prefix	+ "ori_ori_ori_loc_cd", length));
			String[] d5Q = (JSPUtil.getParameter(request, prefix	+ "d5_q", length));
			String[] f5Q = (JSPUtil.getParameter(request, prefix	+ "f5_q", length));
			String[] a4F = (JSPUtil.getParameter(request, prefix	+ "a4_f", length));
			String[] a5F = (JSPUtil.getParameter(request, prefix	+ "a5_f", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] o2Q = (JSPUtil.getParameter(request, prefix	+ "o2_q", length));
			String[] o4Q = (JSPUtil.getParameter(request, prefix	+ "o4_q", length));
			String[] d2Q = (JSPUtil.getParameter(request, prefix	+ "d2_q", length));
			String[] oriLocCd = (JSPUtil.getParameter(request, prefix	+ "ori_loc_cd", length));
			String[] r5F = (JSPUtil.getParameter(request, prefix	+ "r5_f", length));
			String[] f2F = (JSPUtil.getParameter(request, prefix	+ "f2_f", length));
			String[] r5Q = (JSPUtil.getParameter(request, prefix	+ "r5_q", length));
			String[] f4F = (JSPUtil.getParameter(request, prefix	+ "f4_f", length));
			String[] gtotal = (JSPUtil.getParameter(request, prefix	+ "gtotal", length));
			String[] stotal = (JSPUtil.getParameter(request, prefix	+ "stotal", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new ForecastReportVO();
				if (f2Q[i] != null)
					model.setF2Q(f2Q[i]);
				if (sort[i] != null)
					model.setSort(sort[i]);
				if (s4Q[i] != null)
					model.setS4Q(s4Q[i]);
				if (d4F[i] != null)
					model.setD4F(d4F[i]);
				if (oriOriLocCd[i] != null)
					model.setOriOriLocCd(oriOriLocCd[i]);
				if (s2Q[i] != null)
					model.setS2Q(s2Q[i]);
				if (f4Q[i] != null)
					model.setF4Q(f4Q[i]);
				if (r2Q[i] != null)
					model.setR2Q(r2Q[i]);
				if (d4Q[i] != null)
					model.setD4Q(d4Q[i]);
				if (d2F[i] != null)
					model.setD2F(d2F[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s2F[i] != null)
					model.setS2F(s2F[i]);
				if (d7Q[i] != null)
					model.setD7Q(d7Q[i]);
				if (r9F[i] != null)
					model.setR9F(r9F[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tree[i] != null)
					model.setTree(tree[i]);
				if (s4F[i] != null)
					model.setS4F(s4F[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (headWeek[i] != null)
					model.setHeadWeek(headWeek[i]);
				if (dtotal[i] != null)
					model.setDtotal(dtotal[i]);
				if (a2Q[i] != null)
					model.setA2Q(a2Q[i]);
				if (f5F[i] != null)
					model.setF5F(f5F[i]);
				if (r2F[i] != null)
					model.setR2F(r2F[i]);
				if (d7F[i] != null)
					model.setD7F(d7F[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);
				if (d5F[i] != null)
					model.setD5F(d5F[i]);
				if (a2F[i] != null)
					model.setA2F(a2F[i]);
				if (o4F[i] != null)
					model.setO4F(o4F[i]);
				if (r9Q[i] != null)
					model.setR9Q(r9Q[i]);
				if (o2F[i] != null)
					model.setO2F(o2F[i]);
				if (a4Q[i] != null)
					model.setA4Q(a4Q[i]);
				if (a5Q[i] != null)
					model.setA5Q(a5Q[i]);
				if (oriOriOriLocCd[i] != null)
					model.setOriOriOriLocCd(oriOriOriLocCd[i]);
				if (d5Q[i] != null)
					model.setD5Q(d5Q[i]);
				if (f5Q[i] != null)
					model.setF5Q(f5Q[i]);
				if (a4F[i] != null)
					model.setA4F(a4F[i]);
				if (a5F[i] != null)
					model.setA5F(a5F[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (o2Q[i] != null)
					model.setO2Q(o2Q[i]);
				if (o4Q[i] != null)
					model.setO4Q(o4Q[i]);
				if (d2Q[i] != null)
					model.setD2Q(d2Q[i]);
				if (oriLocCd[i] != null)
					model.setOriLocCd(oriLocCd[i]);
				if (r5F[i] != null)
					model.setR5F(r5F[i]);
				if (f2F[i] != null)
					model.setF2F(f2F[i]);
				if (r5Q[i] != null)
					model.setR5Q(r5Q[i]);
				if (f4F[i] != null)
					model.setF4F(f4F[i]);
				if (gtotal[i] != null)
					model.setGtotal(gtotal[i]);
				if (stotal[i] != null)
					model.setStotal(stotal[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyWeeklySimulationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyWeeklySimulationVO[]
	 */
	public ForecastReportVO[] getMtyWeeklySimulationVOs(){
		ForecastReportVO[] vos = (ForecastReportVO[])models.toArray(new ForecastReportVO[models.size()]);
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
		this.f2Q = this.f2Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sort = this.sort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4Q = this.s4Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4F = this.d4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriOriLocCd = this.oriOriLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Q = this.s2Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Q = this.f4Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Q = this.r2Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Q = this.d4Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2F = this.d2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2F = this.s2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Q = this.d7Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9F = this.r9F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tree = this.tree .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4F = this.s4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headWeek = this.headWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtotal = this.dtotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Q = this.a2Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5F = this.f5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2F = this.r2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7F = this.d7F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5F = this.d5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2F = this.a2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4F = this.o4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9Q = this.r9Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2F = this.o2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Q = this.a4Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5Q = this.a5Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriOriOriLocCd = this.oriOriOriLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Q = this.d5Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5Q = this.f5Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4F = this.a4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5F = this.a5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Q = this.o2Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Q = this.o4Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Q = this.d2Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriLocCd = this.oriLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5F = this.r5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2F = this.f2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Q = this.r5Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4F = this.f4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtotal = this.gtotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stotal = this.stotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getA5Q() {
		return a5Q;
	}

	public void setA5Q(String a5q) {
		a5Q = a5q;
	}

	public String getA5F() {
		return a5F;
	}

	public void setA5F(String a5f) {
		a5F = a5f;
	}
}
