/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CBFAllSummaryPreviewVO.java
*@FileTitle : CBFAllSummaryPreviewVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

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

public class CBFAllSummaryPreviewVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CBFAllSummaryPreviewVO> models = new ArrayList<CBFAllSummaryPreviewVO>();
	
	/* Column Info */
	private String j40h = null;
	/* Column Info */
	private String k45 = null;
	/* Column Info */
	private String a20 = null;
	/* Column Info */
	private String sp45 = null;
	/* Column Info */
	private String k40h = null;
	/* Column Info */
	private String sp40 = null;
	/* Column Info */
	private String k40 = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String h40h = null;
	/* Column Info */
	private String i40h = null;
	/* Column Info */
	private String j40 = null;
	/* Column Info */
	private String d20 = null;
	/* Column Info */
	private String i40 = null;
	/* Column Info */
	private String i45 = null;
	/* Column Info */
	private String c20 = null;
	/* Column Info */
	private String j45 = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String k20 = null;
	/* Column Info */
	private String tot40 = null;
	/* Column Info */
	private String e40 = null;
	/* Column Info */
	private String f45 = null;
	/* Column Info */
	private String e45 = null;
	/* Column Info */
	private String f40h = null;
	/* Column Info */
	private String f40 = null;
	/* Column Info */
	private String h45 = null;
	/* Column Info */
	private String h40 = null;
	/* Column Info */
	private String tot45 = null;
	/* Column Info */
	private String g45 = null;
	/* Column Info */
	private String b20 = null;
	/* Column Info */
	private String g40 = null;
	/* Column Info */
	private String l20 = null;
	/* Column Info */
	private String sp40h = null;
	/* Column Info */
	private String b40 = null;
	/* Column Info */
	private String b40h = null;
	/* Column Info */
	private String sp20 = null;
	/* Column Info */
	private String a40 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String d40 = null;
	/* Column Info */
	private String d45 = null;
	/* Column Info */
	private String d40h = null;
	/* Column Info */
	private String i20 = null;
	/* Column Info */
	private String a40h = null;
	/* Column Info */
	private String j20 = null;
	/* Column Info */
	private String c40 = null;
	/* Column Info */
	private String g20 = null;
	/* Column Info */
	private String c45 = null;
	/* Column Info */
	private String f20 = null;
	/* Column Info */
	private String c40h = null;
	/* Column Info */
	private String h20 = null;
	/* Column Info */
	private String tot20 = null;
	/* Column Info */
	private String e40h = null;
	/* Column Info */
	private String e20 = null;
	/* Column Info */
	private String l40h = null;
	/* Column Info */
	private String tot40h = null;
	/* Column Info */
	private String g40h = null;
	/* Column Info */
	private String l40 = null;
	/* Column Info */
	private String a45 = null;
	/* Column Info */
	private String l45 = null;
	/* Column Info */
	private String b45 = null;
	/* Column Info */
	private String totteu = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CBFAllSummaryPreviewVO() {}

	public CBFAllSummaryPreviewVO(String ibflag, String pagerows, String pod, String a20, String a40, String a40h, String a45, String b20, String b40, String b40h, String b45, String c20, String c40, String c40h, String c45, String d20, String d40, String d40h, String d45, String e20, String e40, String e40h, String e45, String f20, String f40, String f40h, String f45, String g20, String g40, String g40h, String g45, String h20, String h40, String h40h, String h45, String i20, String i40, String i40h, String i45, String j20, String j40, String j40h, String j45, String k20, String k40, String k40h, String k45, String l20, String l40, String l40h, String l45, String tot20, String tot40, String tot40h, String tot45, String crrCd, String sp20, String sp40, String sp40h, String sp45, String totteu) {
		this.j40h = j40h;
		this.k45 = k45;
		this.a20 = a20;
		this.sp45 = sp45;
		this.k40h = k40h;
		this.sp40 = sp40;
		this.k40 = k40;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.h40h = h40h;
		this.i40h = i40h;
		this.j40 = j40;
		this.d20 = d20;
		this.i40 = i40;
		this.i45 = i45;
		this.c20 = c20;
		this.j45 = j45;
		this.pod = pod;
		this.k20 = k20;
		this.tot40 = tot40;
		this.e40 = e40;
		this.f45 = f45;
		this.e45 = e45;
		this.f40h = f40h;
		this.f40 = f40;
		this.h45 = h45;
		this.h40 = h40;
		this.tot45 = tot45;
		this.g45 = g45;
		this.b20 = b20;
		this.g40 = g40;
		this.l20 = l20;
		this.sp40h = sp40h;
		this.b40 = b40;
		this.b40h = b40h;
		this.sp20 = sp20;
		this.a40 = a40;
		this.ibflag = ibflag;
		this.d40 = d40;
		this.d45 = d45;
		this.d40h = d40h;
		this.i20 = i20;
		this.a40h = a40h;
		this.j20 = j20;
		this.c40 = c40;
		this.g20 = g20;
		this.c45 = c45;
		this.f20 = f20;
		this.c40h = c40h;
		this.h20 = h20;
		this.tot20 = tot20;
		this.e40h = e40h;
		this.e20 = e20;
		this.l40h = l40h;
		this.tot40h = tot40h;
		this.g40h = g40h;
		this.l40 = l40;
		this.a45 = a45;
		this.l45 = l45;
		this.b45 = b45;
		this.totteu = totteu;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("j_40h", getJ40h());
		this.hashColumns.put("k_45", getK45());
		this.hashColumns.put("a_20", getA20());
		this.hashColumns.put("sp_45", getSp45());
		this.hashColumns.put("k_40h", getK40h());
		this.hashColumns.put("sp_40", getSp40());
		this.hashColumns.put("k_40", getK40());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("h_40h", getH40h());
		this.hashColumns.put("i_40h", getI40h());
		this.hashColumns.put("j_40", getJ40());
		this.hashColumns.put("d_20", getD20());
		this.hashColumns.put("i_40", getI40());
		this.hashColumns.put("i_45", getI45());
		this.hashColumns.put("c_20", getC20());
		this.hashColumns.put("j_45", getJ45());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("k_20", getK20());
		this.hashColumns.put("tot_40", getTot40());
		this.hashColumns.put("e_40", getE40());
		this.hashColumns.put("f_45", getF45());
		this.hashColumns.put("e_45", getE45());
		this.hashColumns.put("f_40h", getF40h());
		this.hashColumns.put("f_40", getF40());
		this.hashColumns.put("h_45", getH45());
		this.hashColumns.put("h_40", getH40());
		this.hashColumns.put("tot_45", getTot45());
		this.hashColumns.put("g_45", getG45());
		this.hashColumns.put("b_20", getB20());
		this.hashColumns.put("g_40", getG40());
		this.hashColumns.put("l_20", getL20());
		this.hashColumns.put("sp_40h", getSp40h());
		this.hashColumns.put("b_40", getB40());
		this.hashColumns.put("b_40h", getB40h());
		this.hashColumns.put("sp_20", getSp20());
		this.hashColumns.put("a_40", getA40());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_40", getD40());
		this.hashColumns.put("d_45", getD45());
		this.hashColumns.put("d_40h", getD40h());
		this.hashColumns.put("i_20", getI20());
		this.hashColumns.put("a_40h", getA40h());
		this.hashColumns.put("j_20", getJ20());
		this.hashColumns.put("c_40", getC40());
		this.hashColumns.put("g_20", getG20());
		this.hashColumns.put("c_45", getC45());
		this.hashColumns.put("f_20", getF20());
		this.hashColumns.put("c_40h", getC40h());
		this.hashColumns.put("h_20", getH20());
		this.hashColumns.put("tot_20", getTot20());
		this.hashColumns.put("e_40h", getE40h());
		this.hashColumns.put("e_20", getE20());
		this.hashColumns.put("l_40h", getL40h());
		this.hashColumns.put("tot_40h", getTot40h());
		this.hashColumns.put("g_40h", getG40h());
		this.hashColumns.put("l_40", getL40());
		this.hashColumns.put("a_45", getA45());
		this.hashColumns.put("l_45", getL45());
		this.hashColumns.put("b_45", getB45());
		this.hashColumns.put("tot_teu", getTotteu());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("j_40h", "j40h");
		this.hashFields.put("k_45", "k45");
		this.hashFields.put("a_20", "a20");
		this.hashFields.put("sp_45", "sp45");
		this.hashFields.put("k_40h", "k40h");
		this.hashFields.put("sp_40", "sp40");
		this.hashFields.put("k_40", "k40");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("h_40h", "h40h");
		this.hashFields.put("i_40h", "i40h");
		this.hashFields.put("j_40", "j40");
		this.hashFields.put("d_20", "d20");
		this.hashFields.put("i_40", "i40");
		this.hashFields.put("i_45", "i45");
		this.hashFields.put("c_20", "c20");
		this.hashFields.put("j_45", "j45");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("k_20", "k20");
		this.hashFields.put("tot_40", "tot40");
		this.hashFields.put("e_40", "e40");
		this.hashFields.put("f_45", "f45");
		this.hashFields.put("e_45", "e45");
		this.hashFields.put("f_40h", "f40h");
		this.hashFields.put("f_40", "f40");
		this.hashFields.put("h_45", "h45");
		this.hashFields.put("h_40", "h40");
		this.hashFields.put("tot_45", "tot45");
		this.hashFields.put("g_45", "g45");
		this.hashFields.put("b_20", "b20");
		this.hashFields.put("g_40", "g40");
		this.hashFields.put("l_20", "l20");
		this.hashFields.put("sp_40h", "sp40h");
		this.hashFields.put("b_40", "b40");
		this.hashFields.put("b_40h", "b40h");
		this.hashFields.put("sp_20", "sp20");
		this.hashFields.put("a_40", "a40");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_40", "d40");
		this.hashFields.put("d_45", "d45");
		this.hashFields.put("d_40h", "d40h");
		this.hashFields.put("i_20", "i20");
		this.hashFields.put("a_40h", "a40h");
		this.hashFields.put("j_20", "j20");
		this.hashFields.put("c_40", "c40");
		this.hashFields.put("g_20", "g20");
		this.hashFields.put("c_45", "c45");
		this.hashFields.put("f_20", "f20");
		this.hashFields.put("c_40h", "c40h");
		this.hashFields.put("h_20", "h20");
		this.hashFields.put("tot_20", "tot20");
		this.hashFields.put("e_40h", "e40h");
		this.hashFields.put("e_20", "e20");
		this.hashFields.put("l_40h", "l40h");
		this.hashFields.put("tot_40h", "tot40h");
		this.hashFields.put("g_40h", "g40h");
		this.hashFields.put("l_40", "l40");
		this.hashFields.put("a_45", "a45");
		this.hashFields.put("l_45", "l45");
		this.hashFields.put("b_45", "b45");
		this.hashFields.put("tot_teu", "totteu");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return j40h
	 */
	public String getJ40h() {
		return this.j40h;
	}
	
	/**
	 * Column Info
	 * @return k45
	 */
	public String getK45() {
		return this.k45;
	}
	
	/**
	 * Column Info
	 * @return a20
	 */
	public String getA20() {
		return this.a20;
	}
	
	/**
	 * Column Info
	 * @return sp45
	 */
	public String getSp45() {
		return this.sp45;
	}
	
	/**
	 * Column Info
	 * @return k40h
	 */
	public String getK40h() {
		return this.k40h;
	}
	
	/**
	 * Column Info
	 * @return sp40
	 */
	public String getSp40() {
		return this.sp40;
	}
	
	/**
	 * Column Info
	 * @return k40
	 */
	public String getK40() {
		return this.k40;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return h40h
	 */
	public String getH40h() {
		return this.h40h;
	}
	
	/**
	 * Column Info
	 * @return i40h
	 */
	public String getI40h() {
		return this.i40h;
	}
	
	/**
	 * Column Info
	 * @return j40
	 */
	public String getJ40() {
		return this.j40;
	}
	
	/**
	 * Column Info
	 * @return d20
	 */
	public String getD20() {
		return this.d20;
	}
	
	/**
	 * Column Info
	 * @return i40
	 */
	public String getI40() {
		return this.i40;
	}
	
	/**
	 * Column Info
	 * @return i45
	 */
	public String getI45() {
		return this.i45;
	}
	
	/**
	 * Column Info
	 * @return c20
	 */
	public String getC20() {
		return this.c20;
	}
	
	/**
	 * Column Info
	 * @return j45
	 */
	public String getJ45() {
		return this.j45;
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
	 * @return k20
	 */
	public String getK20() {
		return this.k20;
	}
	
	/**
	 * Column Info
	 * @return tot40
	 */
	public String getTot40() {
		return this.tot40;
	}
	
	/**
	 * Column Info
	 * @return e40
	 */
	public String getE40() {
		return this.e40;
	}
	
	/**
	 * Column Info
	 * @return f45
	 */
	public String getF45() {
		return this.f45;
	}
	
	/**
	 * Column Info
	 * @return e45
	 */
	public String getE45() {
		return this.e45;
	}
	
	/**
	 * Column Info
	 * @return f40h
	 */
	public String getF40h() {
		return this.f40h;
	}
	
	/**
	 * Column Info
	 * @return f40
	 */
	public String getF40() {
		return this.f40;
	}
	
	/**
	 * Column Info
	 * @return h45
	 */
	public String getH45() {
		return this.h45;
	}
	
	/**
	 * Column Info
	 * @return h40
	 */
	public String getH40() {
		return this.h40;
	}
	
	/**
	 * Column Info
	 * @return tot45
	 */
	public String getTot45() {
		return this.tot45;
	}
	
	/**
	 * Column Info
	 * @return g45
	 */
	public String getG45() {
		return this.g45;
	}
	
	/**
	 * Column Info
	 * @return b20
	 */
	public String getB20() {
		return this.b20;
	}
	
	/**
	 * Column Info
	 * @return g40
	 */
	public String getG40() {
		return this.g40;
	}
	
	/**
	 * Column Info
	 * @return l20
	 */
	public String getL20() {
		return this.l20;
	}
	
	/**
	 * Column Info
	 * @return sp40h
	 */
	public String getSp40h() {
		return this.sp40h;
	}
	
	/**
	 * Column Info
	 * @return b40
	 */
	public String getB40() {
		return this.b40;
	}
	
	/**
	 * Column Info
	 * @return b40h
	 */
	public String getB40h() {
		return this.b40h;
	}
	
	/**
	 * Column Info
	 * @return sp20
	 */
	public String getSp20() {
		return this.sp20;
	}
	
	/**
	 * Column Info
	 * @return a40
	 */
	public String getA40() {
		return this.a40;
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
	 * @return d40
	 */
	public String getD40() {
		return this.d40;
	}
	
	/**
	 * Column Info
	 * @return d45
	 */
	public String getD45() {
		return this.d45;
	}
	
	/**
	 * Column Info
	 * @return d40h
	 */
	public String getD40h() {
		return this.d40h;
	}
	
	/**
	 * Column Info
	 * @return i20
	 */
	public String getI20() {
		return this.i20;
	}
	
	/**
	 * Column Info
	 * @return a40h
	 */
	public String getA40h() {
		return this.a40h;
	}
	
	/**
	 * Column Info
	 * @return j20
	 */
	public String getJ20() {
		return this.j20;
	}
	
	/**
	 * Column Info
	 * @return c40
	 */
	public String getC40() {
		return this.c40;
	}
	
	/**
	 * Column Info
	 * @return g20
	 */
	public String getG20() {
		return this.g20;
	}
	
	/**
	 * Column Info
	 * @return c45
	 */
	public String getC45() {
		return this.c45;
	}
	
	/**
	 * Column Info
	 * @return f20
	 */
	public String getF20() {
		return this.f20;
	}
	
	/**
	 * Column Info
	 * @return c40h
	 */
	public String getC40h() {
		return this.c40h;
	}
	
	/**
	 * Column Info
	 * @return h20
	 */
	public String getH20() {
		return this.h20;
	}
	
	/**
	 * Column Info
	 * @return tot20
	 */
	public String getTot20() {
		return this.tot20;
	}
	
	/**
	 * Column Info
	 * @return e40h
	 */
	public String getE40h() {
		return this.e40h;
	}
	
	/**
	 * Column Info
	 * @return e20
	 */
	public String getE20() {
		return this.e20;
	}
	
	/**
	 * Column Info
	 * @return l40h
	 */
	public String getL40h() {
		return this.l40h;
	}
	
	/**
	 * Column Info
	 * @return tot40h
	 */
	public String getTot40h() {
		return this.tot40h;
	}
	
	/**
	 * Column Info
	 * @return g40h
	 */
	public String getG40h() {
		return this.g40h;
	}
	
	/**
	 * Column Info
	 * @return l40
	 */
	public String getL40() {
		return this.l40;
	}
	
	/**
	 * Column Info
	 * @return a45
	 */
	public String getA45() {
		return this.a45;
	}
	
	/**
	 * Column Info
	 * @return l45
	 */
	public String getL45() {
		return this.l45;
	}
	
	/**
	 * Column Info
	 * @return b45
	 */
	public String getB45() {
		return this.b45;
	}
	
	/**
	 * Column Info
	 * @return totteu
	 */
	public String getTotteu() {
		return this.totteu;
	}

	/**
	 * Column Info
	 * @param j40h
	 */
	public void setJ40h(String j40h) {
		this.j40h = j40h;
	}
	
	/**
	 * Column Info
	 * @param k45
	 */
	public void setK45(String k45) {
		this.k45 = k45;
	}
	
	/**
	 * Column Info
	 * @param a20
	 */
	public void setA20(String a20) {
		this.a20 = a20;
	}
	
	/**
	 * Column Info
	 * @param sp45
	 */
	public void setSp45(String sp45) {
		this.sp45 = sp45;
	}
	
	/**
	 * Column Info
	 * @param k40h
	 */
	public void setK40h(String k40h) {
		this.k40h = k40h;
	}
	
	/**
	 * Column Info
	 * @param sp40
	 */
	public void setSp40(String sp40) {
		this.sp40 = sp40;
	}
	
	/**
	 * Column Info
	 * @param k40
	 */
	public void setK40(String k40) {
		this.k40 = k40;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param h40h
	 */
	public void setH40h(String h40h) {
		this.h40h = h40h;
	}
	
	/**
	 * Column Info
	 * @param i40h
	 */
	public void setI40h(String i40h) {
		this.i40h = i40h;
	}
	
	/**
	 * Column Info
	 * @param j40
	 */
	public void setJ40(String j40) {
		this.j40 = j40;
	}
	
	/**
	 * Column Info
	 * @param d20
	 */
	public void setD20(String d20) {
		this.d20 = d20;
	}
	
	/**
	 * Column Info
	 * @param i40
	 */
	public void setI40(String i40) {
		this.i40 = i40;
	}
	
	/**
	 * Column Info
	 * @param i45
	 */
	public void setI45(String i45) {
		this.i45 = i45;
	}
	
	/**
	 * Column Info
	 * @param c20
	 */
	public void setC20(String c20) {
		this.c20 = c20;
	}
	
	/**
	 * Column Info
	 * @param j45
	 */
	public void setJ45(String j45) {
		this.j45 = j45;
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
	 * @param k20
	 */
	public void setK20(String k20) {
		this.k20 = k20;
	}
	
	/**
	 * Column Info
	 * @param tot40
	 */
	public void setTot40(String tot40) {
		this.tot40 = tot40;
	}
	
	/**
	 * Column Info
	 * @param e40
	 */
	public void setE40(String e40) {
		this.e40 = e40;
	}
	
	/**
	 * Column Info
	 * @param f45
	 */
	public void setF45(String f45) {
		this.f45 = f45;
	}
	
	/**
	 * Column Info
	 * @param e45
	 */
	public void setE45(String e45) {
		this.e45 = e45;
	}
	
	/**
	 * Column Info
	 * @param f40h
	 */
	public void setF40h(String f40h) {
		this.f40h = f40h;
	}
	
	/**
	 * Column Info
	 * @param f40
	 */
	public void setF40(String f40) {
		this.f40 = f40;
	}
	
	/**
	 * Column Info
	 * @param h45
	 */
	public void setH45(String h45) {
		this.h45 = h45;
	}
	
	/**
	 * Column Info
	 * @param h40
	 */
	public void setH40(String h40) {
		this.h40 = h40;
	}
	
	/**
	 * Column Info
	 * @param tot45
	 */
	public void setTot45(String tot45) {
		this.tot45 = tot45;
	}
	
	/**
	 * Column Info
	 * @param g45
	 */
	public void setG45(String g45) {
		this.g45 = g45;
	}
	
	/**
	 * Column Info
	 * @param b20
	 */
	public void setB20(String b20) {
		this.b20 = b20;
	}
	
	/**
	 * Column Info
	 * @param g40
	 */
	public void setG40(String g40) {
		this.g40 = g40;
	}
	
	/**
	 * Column Info
	 * @param l20
	 */
	public void setL20(String l20) {
		this.l20 = l20;
	}
	
	/**
	 * Column Info
	 * @param sp40h
	 */
	public void setSp40h(String sp40h) {
		this.sp40h = sp40h;
	}
	
	/**
	 * Column Info
	 * @param b40
	 */
	public void setB40(String b40) {
		this.b40 = b40;
	}
	
	/**
	 * Column Info
	 * @param b40h
	 */
	public void setB40h(String b40h) {
		this.b40h = b40h;
	}
	
	/**
	 * Column Info
	 * @param sp20
	 */
	public void setSp20(String sp20) {
		this.sp20 = sp20;
	}
	
	/**
	 * Column Info
	 * @param a40
	 */
	public void setA40(String a40) {
		this.a40 = a40;
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
	 * @param d40
	 */
	public void setD40(String d40) {
		this.d40 = d40;
	}
	
	/**
	 * Column Info
	 * @param d45
	 */
	public void setD45(String d45) {
		this.d45 = d45;
	}
	
	/**
	 * Column Info
	 * @param d40h
	 */
	public void setD40h(String d40h) {
		this.d40h = d40h;
	}
	
	/**
	 * Column Info
	 * @param i20
	 */
	public void setI20(String i20) {
		this.i20 = i20;
	}
	
	/**
	 * Column Info
	 * @param a40h
	 */
	public void setA40h(String a40h) {
		this.a40h = a40h;
	}
	
	/**
	 * Column Info
	 * @param j20
	 */
	public void setJ20(String j20) {
		this.j20 = j20;
	}
	
	/**
	 * Column Info
	 * @param c40
	 */
	public void setC40(String c40) {
		this.c40 = c40;
	}
	
	/**
	 * Column Info
	 * @param g20
	 */
	public void setG20(String g20) {
		this.g20 = g20;
	}
	
	/**
	 * Column Info
	 * @param c45
	 */
	public void setC45(String c45) {
		this.c45 = c45;
	}
	
	/**
	 * Column Info
	 * @param f20
	 */
	public void setF20(String f20) {
		this.f20 = f20;
	}
	
	/**
	 * Column Info
	 * @param c40h
	 */
	public void setC40h(String c40h) {
		this.c40h = c40h;
	}
	
	/**
	 * Column Info
	 * @param h20
	 */
	public void setH20(String h20) {
		this.h20 = h20;
	}
	
	/**
	 * Column Info
	 * @param tot20
	 */
	public void setTot20(String tot20) {
		this.tot20 = tot20;
	}
	
	/**
	 * Column Info
	 * @param e40h
	 */
	public void setE40h(String e40h) {
		this.e40h = e40h;
	}
	
	/**
	 * Column Info
	 * @param e20
	 */
	public void setE20(String e20) {
		this.e20 = e20;
	}
	
	/**
	 * Column Info
	 * @param l40h
	 */
	public void setL40h(String l40h) {
		this.l40h = l40h;
	}
	
	/**
	 * Column Info
	 * @param tot40h
	 */
	public void setTot40h(String tot40h) {
		this.tot40h = tot40h;
	}
	
	/**
	 * Column Info
	 * @param g40h
	 */
	public void setG40h(String g40h) {
		this.g40h = g40h;
	}
	
	/**
	 * Column Info
	 * @param l40
	 */
	public void setL40(String l40) {
		this.l40 = l40;
	}
	
	/**
	 * Column Info
	 * @param a45
	 */
	public void setA45(String a45) {
		this.a45 = a45;
	}
	
	/**
	 * Column Info
	 * @param l45
	 */
	public void setL45(String l45) {
		this.l45 = l45;
	}
	
	/**
	 * Column Info
	 * @param b45
	 */
	public void setB45(String b45) {
		this.b45 = b45;
	}
	
	/**
	 * Column Info
	 * @param totteu
	 */
	public void setTotteu(String totteu) {
		this.totteu = totteu;
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
		setJ40h(JSPUtil.getParameter(request, prefix + "j_40h", ""));
		setK45(JSPUtil.getParameter(request, prefix + "k_45", ""));
		setA20(JSPUtil.getParameter(request, prefix + "a_20", ""));
		setSp45(JSPUtil.getParameter(request, prefix + "sp_45", ""));
		setK40h(JSPUtil.getParameter(request, prefix + "k_40h", ""));
		setSp40(JSPUtil.getParameter(request, prefix + "sp_40", ""));
		setK40(JSPUtil.getParameter(request, prefix + "k_40", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setH40h(JSPUtil.getParameter(request, prefix + "h_40h", ""));
		setI40h(JSPUtil.getParameter(request, prefix + "i_40h", ""));
		setJ40(JSPUtil.getParameter(request, prefix + "j_40", ""));
		setD20(JSPUtil.getParameter(request, prefix + "d_20", ""));
		setI40(JSPUtil.getParameter(request, prefix + "i_40", ""));
		setI45(JSPUtil.getParameter(request, prefix + "i_45", ""));
		setC20(JSPUtil.getParameter(request, prefix + "c_20", ""));
		setJ45(JSPUtil.getParameter(request, prefix + "j_45", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setK20(JSPUtil.getParameter(request, prefix + "k_20", ""));
		setTot40(JSPUtil.getParameter(request, prefix + "tot_40", ""));
		setE40(JSPUtil.getParameter(request, prefix + "e_40", ""));
		setF45(JSPUtil.getParameter(request, prefix + "f_45", ""));
		setE45(JSPUtil.getParameter(request, prefix + "e_45", ""));
		setF40h(JSPUtil.getParameter(request, prefix + "f_40h", ""));
		setF40(JSPUtil.getParameter(request, prefix + "f_40", ""));
		setH45(JSPUtil.getParameter(request, prefix + "h_45", ""));
		setH40(JSPUtil.getParameter(request, prefix + "h_40", ""));
		setTot45(JSPUtil.getParameter(request, prefix + "tot_45", ""));
		setG45(JSPUtil.getParameter(request, prefix + "g_45", ""));
		setB20(JSPUtil.getParameter(request, prefix + "b_20", ""));
		setG40(JSPUtil.getParameter(request, prefix + "g_40", ""));
		setL20(JSPUtil.getParameter(request, prefix + "l_20", ""));
		setSp40h(JSPUtil.getParameter(request, prefix + "sp_40h", ""));
		setB40(JSPUtil.getParameter(request, prefix + "b_40", ""));
		setB40h(JSPUtil.getParameter(request, prefix + "b_40h", ""));
		setSp20(JSPUtil.getParameter(request, prefix + "sp_20", ""));
		setA40(JSPUtil.getParameter(request, prefix + "a_40", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setD40(JSPUtil.getParameter(request, prefix + "d_40", ""));
		setD45(JSPUtil.getParameter(request, prefix + "d_45", ""));
		setD40h(JSPUtil.getParameter(request, prefix + "d_40h", ""));
		setI20(JSPUtil.getParameter(request, prefix + "i_20", ""));
		setA40h(JSPUtil.getParameter(request, prefix + "a_40h", ""));
		setJ20(JSPUtil.getParameter(request, prefix + "j_20", ""));
		setC40(JSPUtil.getParameter(request, prefix + "c_40", ""));
		setG20(JSPUtil.getParameter(request, prefix + "g_20", ""));
		setC45(JSPUtil.getParameter(request, prefix + "c_45", ""));
		setF20(JSPUtil.getParameter(request, prefix + "f_20", ""));
		setC40h(JSPUtil.getParameter(request, prefix + "c_40h", ""));
		setH20(JSPUtil.getParameter(request, prefix + "h_20", ""));
		setTot20(JSPUtil.getParameter(request, prefix + "tot_20", ""));
		setE40h(JSPUtil.getParameter(request, prefix + "e_40h", ""));
		setE20(JSPUtil.getParameter(request, prefix + "e_20", ""));
		setL40h(JSPUtil.getParameter(request, prefix + "l_40h", ""));
		setTot40h(JSPUtil.getParameter(request, prefix + "tot_40h", ""));
		setG40h(JSPUtil.getParameter(request, prefix + "g_40h", ""));
		setL40(JSPUtil.getParameter(request, prefix + "l_40", ""));
		setA45(JSPUtil.getParameter(request, prefix + "a_45", ""));
		setL45(JSPUtil.getParameter(request, prefix + "l_45", ""));
		setB45(JSPUtil.getParameter(request, prefix + "b_45", ""));
		setB45(JSPUtil.getParameter(request, prefix + "tot_teu", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CBFAllSummaryPreviewVO[]
	 */
	public CBFAllSummaryPreviewVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CBFAllSummaryPreviewVO[]
	 */
	public CBFAllSummaryPreviewVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CBFAllSummaryPreviewVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] j40h = (JSPUtil.getParameter(request, prefix	+ "j_40h", length));
			String[] k45 = (JSPUtil.getParameter(request, prefix	+ "k_45", length));
			String[] a20 = (JSPUtil.getParameter(request, prefix	+ "a_20", length));
			String[] sp45 = (JSPUtil.getParameter(request, prefix	+ "sp_45", length));
			String[] k40h = (JSPUtil.getParameter(request, prefix	+ "k_40h", length));
			String[] sp40 = (JSPUtil.getParameter(request, prefix	+ "sp_40", length));
			String[] k40 = (JSPUtil.getParameter(request, prefix	+ "k_40", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] h40h = (JSPUtil.getParameter(request, prefix	+ "h_40h", length));
			String[] i40h = (JSPUtil.getParameter(request, prefix	+ "i_40h", length));
			String[] j40 = (JSPUtil.getParameter(request, prefix	+ "j_40", length));
			String[] d20 = (JSPUtil.getParameter(request, prefix	+ "d_20", length));
			String[] i40 = (JSPUtil.getParameter(request, prefix	+ "i_40", length));
			String[] i45 = (JSPUtil.getParameter(request, prefix	+ "i_45", length));
			String[] c20 = (JSPUtil.getParameter(request, prefix	+ "c_20", length));
			String[] j45 = (JSPUtil.getParameter(request, prefix	+ "j_45", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] k20 = (JSPUtil.getParameter(request, prefix	+ "k_20", length));
			String[] tot40 = (JSPUtil.getParameter(request, prefix	+ "tot_40", length));
			String[] e40 = (JSPUtil.getParameter(request, prefix	+ "e_40", length));
			String[] f45 = (JSPUtil.getParameter(request, prefix	+ "f_45", length));
			String[] e45 = (JSPUtil.getParameter(request, prefix	+ "e_45", length));
			String[] f40h = (JSPUtil.getParameter(request, prefix	+ "f_40h", length));
			String[] f40 = (JSPUtil.getParameter(request, prefix	+ "f_40", length));
			String[] h45 = (JSPUtil.getParameter(request, prefix	+ "h_45", length));
			String[] h40 = (JSPUtil.getParameter(request, prefix	+ "h_40", length));
			String[] tot45 = (JSPUtil.getParameter(request, prefix	+ "tot_45", length));
			String[] g45 = (JSPUtil.getParameter(request, prefix	+ "g_45", length));
			String[] b20 = (JSPUtil.getParameter(request, prefix	+ "b_20", length));
			String[] g40 = (JSPUtil.getParameter(request, prefix	+ "g_40", length));
			String[] l20 = (JSPUtil.getParameter(request, prefix	+ "l_20", length));
			String[] sp40h = (JSPUtil.getParameter(request, prefix	+ "sp_40h", length));
			String[] b40 = (JSPUtil.getParameter(request, prefix	+ "b_40", length));
			String[] b40h = (JSPUtil.getParameter(request, prefix	+ "b_40h", length));
			String[] sp20 = (JSPUtil.getParameter(request, prefix	+ "sp_20", length));
			String[] a40 = (JSPUtil.getParameter(request, prefix	+ "a_40", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] d40 = (JSPUtil.getParameter(request, prefix	+ "d_40", length));
			String[] d45 = (JSPUtil.getParameter(request, prefix	+ "d_45", length));
			String[] d40h = (JSPUtil.getParameter(request, prefix	+ "d_40h", length));
			String[] i20 = (JSPUtil.getParameter(request, prefix	+ "i_20", length));
			String[] a40h = (JSPUtil.getParameter(request, prefix	+ "a_40h", length));
			String[] j20 = (JSPUtil.getParameter(request, prefix	+ "j_20", length));
			String[] c40 = (JSPUtil.getParameter(request, prefix	+ "c_40", length));
			String[] g20 = (JSPUtil.getParameter(request, prefix	+ "g_20", length));
			String[] c45 = (JSPUtil.getParameter(request, prefix	+ "c_45", length));
			String[] f20 = (JSPUtil.getParameter(request, prefix	+ "f_20", length));
			String[] c40h = (JSPUtil.getParameter(request, prefix	+ "c_40h", length));
			String[] h20 = (JSPUtil.getParameter(request, prefix	+ "h_20", length));
			String[] tot20 = (JSPUtil.getParameter(request, prefix	+ "tot_20", length));
			String[] e40h = (JSPUtil.getParameter(request, prefix	+ "e_40h", length));
			String[] e20 = (JSPUtil.getParameter(request, prefix	+ "e_20", length));
			String[] l40h = (JSPUtil.getParameter(request, prefix	+ "l_40h", length));
			String[] tot40h = (JSPUtil.getParameter(request, prefix	+ "tot_40h", length));
			String[] g40h = (JSPUtil.getParameter(request, prefix	+ "g_40h", length));
			String[] l40 = (JSPUtil.getParameter(request, prefix	+ "l_40", length));
			String[] a45 = (JSPUtil.getParameter(request, prefix	+ "a_45", length));
			String[] l45 = (JSPUtil.getParameter(request, prefix	+ "l_45", length));
			String[] b45 = (JSPUtil.getParameter(request, prefix	+ "b_45", length));
			String[] totteu = (JSPUtil.getParameter(request, prefix	+ "tot_teu", length));
			
			for (int i = 0; i < length; i++) {
				model = new CBFAllSummaryPreviewVO();
				if (j40h[i] != null)
					model.setJ40h(j40h[i]);
				if (k45[i] != null)
					model.setK45(k45[i]);
				if (a20[i] != null)
					model.setA20(a20[i]);
				if (sp45[i] != null)
					model.setSp45(sp45[i]);
				if (k40h[i] != null)
					model.setK40h(k40h[i]);
				if (sp40[i] != null)
					model.setSp40(sp40[i]);
				if (k40[i] != null)
					model.setK40(k40[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (h40h[i] != null)
					model.setH40h(h40h[i]);
				if (i40h[i] != null)
					model.setI40h(i40h[i]);
				if (j40[i] != null)
					model.setJ40(j40[i]);
				if (d20[i] != null)
					model.setD20(d20[i]);
				if (i40[i] != null)
					model.setI40(i40[i]);
				if (i45[i] != null)
					model.setI45(i45[i]);
				if (c20[i] != null)
					model.setC20(c20[i]);
				if (j45[i] != null)
					model.setJ45(j45[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (k20[i] != null)
					model.setK20(k20[i]);
				if (tot40[i] != null)
					model.setTot40(tot40[i]);
				if (e40[i] != null)
					model.setE40(e40[i]);
				if (f45[i] != null)
					model.setF45(f45[i]);
				if (e45[i] != null)
					model.setE45(e45[i]);
				if (f40h[i] != null)
					model.setF40h(f40h[i]);
				if (f40[i] != null)
					model.setF40(f40[i]);
				if (h45[i] != null)
					model.setH45(h45[i]);
				if (h40[i] != null)
					model.setH40(h40[i]);
				if (tot45[i] != null)
					model.setTot45(tot45[i]);
				if (g45[i] != null)
					model.setG45(g45[i]);
				if (b20[i] != null)
					model.setB20(b20[i]);
				if (g40[i] != null)
					model.setG40(g40[i]);
				if (l20[i] != null)
					model.setL20(l20[i]);
				if (sp40h[i] != null)
					model.setSp40h(sp40h[i]);
				if (b40[i] != null)
					model.setB40(b40[i]);
				if (b40h[i] != null)
					model.setB40h(b40h[i]);
				if (sp20[i] != null)
					model.setSp20(sp20[i]);
				if (a40[i] != null)
					model.setA40(a40[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (d40[i] != null)
					model.setD40(d40[i]);
				if (d45[i] != null)
					model.setD45(d45[i]);
				if (d40h[i] != null)
					model.setD40h(d40h[i]);
				if (i20[i] != null)
					model.setI20(i20[i]);
				if (a40h[i] != null)
					model.setA40h(a40h[i]);
				if (j20[i] != null)
					model.setJ20(j20[i]);
				if (c40[i] != null)
					model.setC40(c40[i]);
				if (g20[i] != null)
					model.setG20(g20[i]);
				if (c45[i] != null)
					model.setC45(c45[i]);
				if (f20[i] != null)
					model.setF20(f20[i]);
				if (c40h[i] != null)
					model.setC40h(c40h[i]);
				if (h20[i] != null)
					model.setH20(h20[i]);
				if (tot20[i] != null)
					model.setTot20(tot20[i]);
				if (e40h[i] != null)
					model.setE40h(e40h[i]);
				if (e20[i] != null)
					model.setE20(e20[i]);
				if (l40h[i] != null)
					model.setL40h(l40h[i]);
				if (tot40h[i] != null)
					model.setTot40h(tot40h[i]);
				if (g40h[i] != null)
					model.setG40h(g40h[i]);
				if (l40[i] != null)
					model.setL40(l40[i]);
				if (a45[i] != null)
					model.setA45(a45[i]);
				if (l45[i] != null)
					model.setL45(l45[i]);
				if (b45[i] != null)
					model.setB45(b45[i]);
				if (totteu[i] != null)
					model.setTotteu(totteu[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCBFAllSummaryPreviewVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CBFAllSummaryPreviewVO[]
	 */
	public CBFAllSummaryPreviewVO[] getCBFAllSummaryPreviewVOs(){
		CBFAllSummaryPreviewVO[] vos = (CBFAllSummaryPreviewVO[])models.toArray(new CBFAllSummaryPreviewVO[models.size()]);
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
		this.j40h = this.j40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.k45 = this.k45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a20 = this.a20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sp45 = this.sp45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.k40h = this.k40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sp40 = this.sp40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.k40 = this.k40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.h40h = this.h40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.i40h = this.i40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.j40 = this.j40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d20 = this.d20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.i40 = this.i40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.i45 = this.i45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c20 = this.c20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.j45 = this.j45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.k20 = this.k20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot40 = this.tot40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e40 = this.e40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f45 = this.f45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e45 = this.e45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f40h = this.f40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f40 = this.f40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.h45 = this.h45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.h40 = this.h40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot45 = this.tot45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g45 = this.g45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b20 = this.b20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g40 = this.g40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.l20 = this.l20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sp40h = this.sp40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b40 = this.b40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b40h = this.b40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sp20 = this.sp20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a40 = this.a40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d40 = this.d40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d45 = this.d45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d40h = this.d40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.i20 = this.i20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a40h = this.a40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.j20 = this.j20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c40 = this.c40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g20 = this.g20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c45 = this.c45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f20 = this.f20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c40h = this.c40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.h20 = this.h20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot20 = this.tot20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e40h = this.e40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e20 = this.e20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.l40h = this.l40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot40h = this.tot40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g40h = this.g40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.l40 = this.l40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a45 = this.a45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.l45 = this.l45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b45 = this.b45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totteu = this.totteu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
