/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CllCdlVslSumForRDVO.java
*@FileTitle : CllCdlVslSumForRDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CllCdlVslSumForRDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CllCdlVslSumForRDVO> models = new ArrayList<CllCdlVslSumForRDVO>();
	
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String r5 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String mea = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String dw = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String dx = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String s2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String o5 = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String t40 = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String t20 = null;
	/* Column Info */
	private String cssmVvd = null;
	/* Column Info */
	private String z2 = null;
	/* Column Info */
	private String unLocCd = null;
	/* Column Info */
	private String z4 = null;
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String eWgt = null;
	/* Column Info */
	private String lcl = null;
	/* Column Info */
	private String ts = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CllCdlVslSumForRDVO() {}

	public CllCdlVslSumForRDVO(String ibflag, String pagerows, String vvd, String unLocCd, String vpsEtaDt, String vpsEtdDt, String vpsEtbDt, String cssmVvd, String d2, String d4, String d5, String d7, String d8, String d9, String dw, String dx, String r2, String r4, String r5, String f2, String f4, String f5, String o2, String o4, String o5, String s2, String s4, String t2, String t4, String a2, String a4, String p2, String p4, String z2, String z4, String t20, String t40, String wgt, String mea, String ttl, String eWgt, String lcl, String ts) {
		this.r2 = r2;
		this.t4 = t4;
		this.r4 = r4;
		this.p2 = p2;
		this.r5 = r5;
		this.ibflag = ibflag;
		this.p4 = p4;
		this.vpsEtdDt = vpsEtdDt;
		this.mea = mea;
		this.f2 = f2;
		this.vpsEtaDt = vpsEtaDt;
		this.vpsEtbDt = vpsEtbDt;
		this.d2 = d2;
		this.f4 = f4;
		this.f5 = f5;
		this.d4 = d4;
		this.d5 = d5;
		this.d7 = d7;
		this.dw = dw;
		this.d8 = d8;
		this.dx = dx;
		this.d9 = d9;
		this.s2 = s2;
		this.pagerows = pagerows;
		this.s4 = s4;
		this.o2 = o2;
		this.vvd = vvd;
		this.o4 = o4;
		this.wgt = wgt;
		this.o5 = o5;
		this.ttl = ttl;
		this.a2 = a2;
		this.t40 = t40;
		this.a4 = a4;
		this.t20 = t20;
		this.cssmVvd = cssmVvd;
		this.z2 = z2;
		this.unLocCd = unLocCd;
		this.z4 = z4;
		this.t2 = t2;
		this.eWgt = eWgt;
		this.lcl = lcl;
		this.ts = ts;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("mea", getMea());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("dw", getDw());
		this.hashColumns.put("d8", getD8());
		this.hashColumns.put("dx", getDx());
		this.hashColumns.put("d9", getD9());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("o5", getO5());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("t40", getT40());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("t20", getT20());
		this.hashColumns.put("cssm_vvd", getCssmVvd());
		this.hashColumns.put("z2", getZ2());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		this.hashColumns.put("z4", getZ4());
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("e_wgt", getEWgt());
		this.hashColumns.put("lcl", getLcl());
		this.hashColumns.put("ts", getTs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r2", "r2");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("mea", "mea");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("o5", "o5");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("t40", "t40");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("t20", "t20");
		this.hashFields.put("cssm_vvd", "cssmVvd");
		this.hashFields.put("z2", "z2");
		this.hashFields.put("un_loc_cd", "unLocCd");
		this.hashFields.put("z4", "z4");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("e_wgt", "eWgt");
		this.hashFields.put("lcl", "lcl");
		this.hashFields.put("ts", "ts");
		return this.hashFields;
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
	 * @return t4
	 */
	public String getT4() {
		return this.t4;
	}
	
	/**
	 * Column Info
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
	}
	
	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
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
	 * @return p4
	 */
	public String getP4() {
		return this.p4;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return mea
	 */
	public String getMea() {
		return this.mea;
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
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
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
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
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
	 * @return dw
	 */
	public String getDw() {
		return this.dw;
	}
	
	/**
	 * Column Info
	 * @return d8
	 */
	public String getD8() {
		return this.d8;
	}
	
	/**
	 * Column Info
	 * @return dx
	 */
	public String getDx() {
		return this.dx;
	}
	
	/**
	 * Column Info
	 * @return d9
	 */
	public String getD9() {
		return this.d9;
	}
	
	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
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
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
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
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
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
	 * @return t40
	 */
	public String getT40() {
		return this.t40;
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
	 * @return t20
	 */
	public String getT20() {
		return this.t20;
	}
	
	/**
	 * Column Info
	 * @return cssmVvd
	 */
	public String getCssmVvd() {
		return this.cssmVvd;
	}
	
	/**
	 * Column Info
	 * @return z2
	 */
	public String getZ2() {
		return this.z2;
	}
	
	/**
	 * Column Info
	 * @return unLocCd
	 */
	public String getUnLocCd() {
		return this.unLocCd;
	}
	
	/**
	 * Column Info
	 * @return z4
	 */
	public String getZ4() {
		return this.z4;
	}
	
	/**
	 * Column Info
	 * @return t2
	 */
	public String getT2() {
		return this.t2;
	}
	
	/**
	 * Column Info
	 * @return eWgt
	 */
	public String getEWgt() {
		return this.eWgt;
	}
	
	/**
	 * Column Info
	 * @return lcl
	 */
	public String getLcl() {
		return this.lcl;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
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
	 * @param t4
	 */
	public void setT4(String t4) {
		this.t4 = t4;
	}
	
	/**
	 * Column Info
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}
	
	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
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
	 * @param p4
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param mea
	 */
	public void setMea(String mea) {
		this.mea = mea;
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
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
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
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
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
	 * @param dw
	 */
	public void setDw(String dw) {
		this.dw = dw;
	}
	
	/**
	 * Column Info
	 * @param d8
	 */
	public void setD8(String d8) {
		this.d8 = d8;
	}
	
	/**
	 * Column Info
	 * @param dx
	 */
	public void setDx(String dx) {
		this.dx = dx;
	}
	
	/**
	 * Column Info
	 * @param d9
	 */
	public void setD9(String d9) {
		this.d9 = d9;
	}
	
	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
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
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param o5
	 */
	public void setO5(String o5) {
		this.o5 = o5;
	}
	
	/**
	 * Column Info
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
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
	 * @param t40
	 */
	public void setT40(String t40) {
		this.t40 = t40;
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
	 * @param t20
	 */
	public void setT20(String t20) {
		this.t20 = t20;
	}
	
	/**
	 * Column Info
	 * @param cssmVvd
	 */
	public void setCssmVvd(String cssmVvd) {
		this.cssmVvd = cssmVvd;
	}
	
	/**
	 * Column Info
	 * @param z2
	 */
	public void setZ2(String z2) {
		this.z2 = z2;
	}
	
	/**
	 * Column Info
	 * @param unLocCd
	 */
	public void setUnLocCd(String unLocCd) {
		this.unLocCd = unLocCd;
	}
	
	/**
	 * Column Info
	 * @param z4
	 */
	public void setZ4(String z4) {
		this.z4 = z4;
	}
	
	/**
	 * Column Info
	 * @param t2
	 */
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	/**
	 * Column Info
	 * @param eWgt
	 */
	public void setEWgt(String eWgt) {
		this.eWgt = eWgt;
	}
	
	/**
	 * Column Info
	 * @param lcl
	 */
	public void setLcl(String lcl) {
		this.lcl = lcl;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
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
		setR2(JSPUtil.getParameter(request, prefix + "r2", ""));
		setT4(JSPUtil.getParameter(request, prefix + "t4", ""));
		setR4(JSPUtil.getParameter(request, prefix + "r4", ""));
		setP2(JSPUtil.getParameter(request, prefix + "p2", ""));
		setR5(JSPUtil.getParameter(request, prefix + "r5", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setP4(JSPUtil.getParameter(request, prefix + "p4", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setMea(JSPUtil.getParameter(request, prefix + "mea", ""));
		setF2(JSPUtil.getParameter(request, prefix + "f2", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setD2(JSPUtil.getParameter(request, prefix + "d2", ""));
		setF4(JSPUtil.getParameter(request, prefix + "f4", ""));
		setF5(JSPUtil.getParameter(request, prefix + "f5", ""));
		setD4(JSPUtil.getParameter(request, prefix + "d4", ""));
		setD5(JSPUtil.getParameter(request, prefix + "d5", ""));
		setD7(JSPUtil.getParameter(request, prefix + "d7", ""));
		setDw(JSPUtil.getParameter(request, prefix + "dw", ""));
		setD8(JSPUtil.getParameter(request, prefix + "d8", ""));
		setDx(JSPUtil.getParameter(request, prefix + "dx", ""));
		setD9(JSPUtil.getParameter(request, prefix + "d9", ""));
		setS2(JSPUtil.getParameter(request, prefix + "s2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setS4(JSPUtil.getParameter(request, prefix + "s4", ""));
		setO2(JSPUtil.getParameter(request, prefix + "o2", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setO4(JSPUtil.getParameter(request, prefix + "o4", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setO5(JSPUtil.getParameter(request, prefix + "o5", ""));
		setTtl(JSPUtil.getParameter(request, prefix + "ttl", ""));
		setA2(JSPUtil.getParameter(request, prefix + "a2", ""));
		setT40(JSPUtil.getParameter(request, prefix + "t40", ""));
		setA4(JSPUtil.getParameter(request, prefix + "a4", ""));
		setT20(JSPUtil.getParameter(request, prefix + "t20", ""));
		setCssmVvd(JSPUtil.getParameter(request, prefix + "cssm_vvd", ""));
		setZ2(JSPUtil.getParameter(request, prefix + "z2", ""));
		setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
		setZ4(JSPUtil.getParameter(request, prefix + "z4", ""));
		setT2(JSPUtil.getParameter(request, prefix + "t2", ""));
		setEWgt(JSPUtil.getParameter(request, prefix + "e_wgt", ""));
		setLcl(JSPUtil.getParameter(request, prefix + "lcl", ""));
		setTs(JSPUtil.getParameter(request, prefix + "ts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllCdlVslSumForRDVO[]
	 */
	public CllCdlVslSumForRDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CllCdlVslSumForRDVO[]
	 */
	public CllCdlVslSumForRDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllCdlVslSumForRDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] mea = (JSPUtil.getParameter(request, prefix	+ "mea", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] dw = (JSPUtil.getParameter(request, prefix	+ "dw", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d8", length));
			String[] dx = (JSPUtil.getParameter(request, prefix	+ "dx", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d9", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] o5 = (JSPUtil.getParameter(request, prefix	+ "o5", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] t40 = (JSPUtil.getParameter(request, prefix	+ "t40", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] t20 = (JSPUtil.getParameter(request, prefix	+ "t20", length));
			String[] cssmVvd = (JSPUtil.getParameter(request, prefix	+ "cssm_vvd", length));
			String[] z2 = (JSPUtil.getParameter(request, prefix	+ "z2", length));
			String[] unLocCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd", length));
			String[] z4 = (JSPUtil.getParameter(request, prefix	+ "z4", length));
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] eWgt = (JSPUtil.getParameter(request, prefix	+ "e_wgt", length));
			String[] lcl = (JSPUtil.getParameter(request, prefix	+ "lcl", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			
			for (int i = 0; i < length; i++) {
				model = new CllCdlVslSumForRDVO();
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (mea[i] != null)
					model.setMea(mea[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (dw[i] != null)
					model.setDw(dw[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (dx[i] != null)
					model.setDx(dx[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (o5[i] != null)
					model.setO5(o5[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (t40[i] != null)
					model.setT40(t40[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (t20[i] != null)
					model.setT20(t20[i]);
				if (cssmVvd[i] != null)
					model.setCssmVvd(cssmVvd[i]);
				if (z2[i] != null)
					model.setZ2(z2[i]);
				if (unLocCd[i] != null)
					model.setUnLocCd(unLocCd[i]);
				if (z4[i] != null)
					model.setZ4(z4[i]);
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (eWgt[i] != null)
					model.setEWgt(eWgt[i]);
				if (lcl[i] != null)
					model.setLcl(lcl[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllCdlVslSumForRDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllCdlVslSumForRDVO[]
	 */
	public CllCdlVslSumForRDVO[] getCllCdlVslSumForRDVOs(){
		CllCdlVslSumForRDVO[] vos = (CllCdlVslSumForRDVO[])models.toArray(new CllCdlVslSumForRDVO[models.size()]);
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
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mea = this.mea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw = this.dw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx = this.dx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5 = this.o5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t40 = this.t40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t20 = this.t20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cssmVvd = this.cssmVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.z2 = this.z2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd = this.unLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.z4 = this.z4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eWgt = this.eWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcl = this.lcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
