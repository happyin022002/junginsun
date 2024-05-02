/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorCllSpclStowRqstDetailVO.java
*@FileTitle : KorCllSpclStowRqstDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.18
*@LastModifier :
*@LastVersion : 1.0
* 2013.01.18
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCllSpclStowRqstDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCllSpclStowRqstDetailVO> models = new ArrayList<KorCllSpclStowRqstDetailVO>();

	/* Column Info */
	private String af40h = null;
	/* Column Info */
	private String al45 = null;
	/* Column Info */
	private String al20 = null;
	/* Column Info */
	private String od45 = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String mupg45 = null;
	/* Column Info */
	private String obss40h = null;
	/* Column Info */
	private String al40h = null;
	/* Column Info */
	private String od40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String al40 = null;
	/* Column Info */
	private String ab20 = null;
	/* Column Info */
	private String bc40h = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String od20 = null;
	/* Column Info */
	private String obsg45 = null;
	/* Column Info */
	private String ab40 = null;
	/* Column Info */
	private String odab40h = null;
	/* Column Info */
	private String od40h = null;
	/* Column Info */
	private String bc20 = null;
	/* Column Info */
	private String obsg40 = null;
	/* Column Info */
	private String bc40 = null;
	/* Column Info */
	private String ab40h = null;
	/* Column Info */
	private String odab40 = null;
	/* Column Info */
	private String gubunCd3 = null;
	/* Column Info */
	private String odab45 = null;
	/* Column Info */
	private String obsg40h = null;
	/* Column Info */
	private String obsg20 = null;
	/* Column Info */
	private String odab20 = null;
	/* Column Info */
	private String ab45 = null;
	/* Column Info */
	private String obss40 = null;
	/* Column Info */
	private String obss20 = null;
	/* Column Info */
	private String bc45 = null;
	/* Column Info */
	private String mupg20 = null;
	/* Column Info */
	private String mupg40 = null;
	/* Column Info */
	private String mupg40h = null;
	/* Column Info */
	private String obss45 = null;
	/* Column Info */
	private String af20 = null;
	/* Column Info */
	private String af45 = null;
	/* Column Info */
	private String af40 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCllSpclStowRqstDetailVO() {}

	public KorCllSpclStowRqstDetailVO(String ibflag, String pagerows, String gubunCd3, String blckStwgCd, String ab20, String ab40, String ab40h, String ab45, String af20, String af40, String af40h, String af45, String al20, String al40, String al40h, String al45, String bc20, String bc40, String bc40h, String bc45, String mupg20, String mupg40, String mupg40h, String mupg45, String od20, String od40, String od40h, String od45, String obss20, String obss40, String obss40h, String obss45, String obsg20, String obsg40, String obsg40h, String obsg45, String odab20, String odab40, String odab40h, String odab45) {
		this.af40h = af40h;
		this.al45 = al45;
		this.al20 = al20;
		this.od45 = od45;
		this.blckStwgCd = blckStwgCd;
		this.mupg45 = mupg45;
		this.obss40h = obss40h;
		this.al40h = al40h;
		this.od40 = od40;
		this.pagerows = pagerows;
		this.al40 = al40;
		this.ab20 = ab20;
		this.bc40h = bc40h;
		this.ibflag = ibflag;
		this.od20 = od20;
		this.obsg45 = obsg45;
		this.ab40 = ab40;
		this.odab40h = odab40h;
		this.od40h = od40h;
		this.bc20 = bc20;
		this.obsg40 = obsg40;
		this.bc40 = bc40;
		this.ab40h = ab40h;
		this.odab40 = odab40;
		this.gubunCd3 = gubunCd3;
		this.odab45 = odab45;
		this.obsg40h = obsg40h;
		this.obsg20 = obsg20;
		this.odab20 = odab20;
		this.ab45 = ab45;
		this.obss40 = obss40;
		this.obss20 = obss20;
		this.bc45 = bc45;
		this.mupg20 = mupg20;
		this.mupg40 = mupg40;
		this.mupg40h = mupg40h;
		this.obss45 = obss45;
		this.af20 = af20;
		this.af45 = af45;
		this.af40 = af40;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("af_40h", getAf40h());
		this.hashColumns.put("al_45", getAl45());
		this.hashColumns.put("al_20", getAl20());
		this.hashColumns.put("od_45", getOd45());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("mupg_45", getMupg45());
		this.hashColumns.put("obss_40h", getObss40h());
		this.hashColumns.put("al_40h", getAl40h());
		this.hashColumns.put("od_40", getOd40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("al_40", getAl40());
		this.hashColumns.put("ab_20", getAb20());
		this.hashColumns.put("bc_40h", getBc40h());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("od_20", getOd20());
		this.hashColumns.put("obsg_45", getObsg45());
		this.hashColumns.put("ab_40", getAb40());
		this.hashColumns.put("odab_40h", getOdab40h());
		this.hashColumns.put("od_40h", getOd40h());
		this.hashColumns.put("bc_20", getBc20());
		this.hashColumns.put("obsg_40", getObsg40());
		this.hashColumns.put("bc_40", getBc40());
		this.hashColumns.put("ab_40h", getAb40h());
		this.hashColumns.put("odab_40", getOdab40());
		this.hashColumns.put("gubun_cd3", getGubunCd3());
		this.hashColumns.put("odab_45", getOdab45());
		this.hashColumns.put("obsg_40h", getObsg40h());
		this.hashColumns.put("obsg_20", getObsg20());
		this.hashColumns.put("odab_20", getOdab20());
		this.hashColumns.put("ab_45", getAb45());
		this.hashColumns.put("obss_40", getObss40());
		this.hashColumns.put("obss_20", getObss20());
		this.hashColumns.put("bc_45", getBc45());
		this.hashColumns.put("mupg_20", getMupg20());
		this.hashColumns.put("mupg_40", getMupg40());
		this.hashColumns.put("mupg_40h", getMupg40h());
		this.hashColumns.put("obss_45", getObss45());
		this.hashColumns.put("af_20", getAf20());
		this.hashColumns.put("af_45", getAf45());
		this.hashColumns.put("af_40", getAf40());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("af_40h", "af40h");
		this.hashFields.put("al_45", "al45");
		this.hashFields.put("al_20", "al20");
		this.hashFields.put("od_45", "od45");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("mupg_45", "mupg45");
		this.hashFields.put("obss_40h", "obss40h");
		this.hashFields.put("al_40h", "al40h");
		this.hashFields.put("od_40", "od40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("al_40", "al40");
		this.hashFields.put("ab_20", "ab20");
		this.hashFields.put("bc_40h", "bc40h");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("od_20", "od20");
		this.hashFields.put("obsg_45", "obsg45");
		this.hashFields.put("ab_40", "ab40");
		this.hashFields.put("odab_40h", "odab40h");
		this.hashFields.put("od_40h", "od40h");
		this.hashFields.put("bc_20", "bc20");
		this.hashFields.put("obsg_40", "obsg40");
		this.hashFields.put("bc_40", "bc40");
		this.hashFields.put("ab_40h", "ab40h");
		this.hashFields.put("odab_40", "odab40");
		this.hashFields.put("gubun_cd3", "gubunCd3");
		this.hashFields.put("odab_45", "odab45");
		this.hashFields.put("obsg_40h", "obsg40h");
		this.hashFields.put("obsg_20", "obsg20");
		this.hashFields.put("odab_20", "odab20");
		this.hashFields.put("ab_45", "ab45");
		this.hashFields.put("obss_40", "obss40");
		this.hashFields.put("obss_20", "obss20");
		this.hashFields.put("bc_45", "bc45");
		this.hashFields.put("mupg_20", "mupg20");
		this.hashFields.put("mupg_40", "mupg40");
		this.hashFields.put("mupg_40h", "mupg40h");
		this.hashFields.put("obss_45", "obss45");
		this.hashFields.put("af_20", "af20");
		this.hashFields.put("af_45", "af45");
		this.hashFields.put("af_40", "af40");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return af40h
	 */
	public String getAf40h() {
		return this.af40h;
	}

	/**
	 * Column Info
	 * @return al45
	 */
	public String getAl45() {
		return this.al45;
	}

	/**
	 * Column Info
	 * @return al20
	 */
	public String getAl20() {
		return this.al20;
	}

	/**
	 * Column Info
	 * @return od45
	 */
	public String getOd45() {
		return this.od45;
	}

	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}

	/**
	 * Column Info
	 * @return mupg45
	 */
	public String getMupg45() {
		return this.mupg45;
	}

	/**
	 * Column Info
	 * @return obss40h
	 */
	public String getObss40h() {
		return this.obss40h;
	}

	/**
	 * Column Info
	 * @return al40h
	 */
	public String getAl40h() {
		return this.al40h;
	}

	/**
	 * Column Info
	 * @return od40
	 */
	public String getOd40() {
		return this.od40;
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
	 * @return al40
	 */
	public String getAl40() {
		return this.al40;
	}

	/**
	 * Column Info
	 * @return ab20
	 */
	public String getAb20() {
		return this.ab20;
	}

	/**
	 * Column Info
	 * @return bc40h
	 */
	public String getBc40h() {
		return this.bc40h;
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
	 * @return od20
	 */
	public String getOd20() {
		return this.od20;
	}

	/**
	 * Column Info
	 * @return obsg45
	 */
	public String getObsg45() {
		return this.obsg45;
	}

	/**
	 * Column Info
	 * @return ab40
	 */
	public String getAb40() {
		return this.ab40;
	}

	/**
	 * Column Info
	 * @return odab40h
	 */
	public String getOdab40h() {
		return this.odab40h;
	}

	/**
	 * Column Info
	 * @return od40h
	 */
	public String getOd40h() {
		return this.od40h;
	}

	/**
	 * Column Info
	 * @return bc20
	 */
	public String getBc20() {
		return this.bc20;
	}

	/**
	 * Column Info
	 * @return obsg40
	 */
	public String getObsg40() {
		return this.obsg40;
	}

	/**
	 * Column Info
	 * @return bc40
	 */
	public String getBc40() {
		return this.bc40;
	}

	/**
	 * Column Info
	 * @return ab40h
	 */
	public String getAb40h() {
		return this.ab40h;
	}

	/**
	 * Column Info
	 * @return odab40
	 */
	public String getOdab40() {
		return this.odab40;
	}

	/**
	 * Column Info
	 * @return gubunCd3
	 */
	public String getGubunCd3() {
		return this.gubunCd3;
	}

	/**
	 * Column Info
	 * @return odab45
	 */
	public String getOdab45() {
		return this.odab45;
	}

	/**
	 * Column Info
	 * @return obsg40h
	 */
	public String getObsg40h() {
		return this.obsg40h;
	}

	/**
	 * Column Info
	 * @return obsg20
	 */
	public String getObsg20() {
		return this.obsg20;
	}

	/**
	 * Column Info
	 * @return odab20
	 */
	public String getOdab20() {
		return this.odab20;
	}

	/**
	 * Column Info
	 * @return ab45
	 */
	public String getAb45() {
		return this.ab45;
	}

	/**
	 * Column Info
	 * @return obss40
	 */
	public String getObss40() {
		return this.obss40;
	}

	/**
	 * Column Info
	 * @return obss20
	 */
	public String getObss20() {
		return this.obss20;
	}

	/**
	 * Column Info
	 * @return bc45
	 */
	public String getBc45() {
		return this.bc45;
	}

	/**
	 * Column Info
	 * @return mupg20
	 */
	public String getMupg20() {
		return this.mupg20;
	}

	/**
	 * Column Info
	 * @return mupg40
	 */
	public String getMupg40() {
		return this.mupg40;
	}

	/**
	 * Column Info
	 * @return mupg40h
	 */
	public String getMupg40h() {
		return this.mupg40h;
	}

	/**
	 * Column Info
	 * @return obss45
	 */
	public String getObss45() {
		return this.obss45;
	}

	/**
	 * Column Info
	 * @return af20
	 */
	public String getAf20() {
		return this.af20;
	}

	/**
	 * Column Info
	 * @return af45
	 */
	public String getAf45() {
		return this.af45;
	}

	/**
	 * Column Info
	 * @return af40
	 */
	public String getAf40() {
		return this.af40;
	}


	/**
	 * Column Info
	 * @param af40h
	 */
	public void setAf40h(String af40h) {
		this.af40h = af40h;
	}

	/**
	 * Column Info
	 * @param al45
	 */
	public void setAl45(String al45) {
		this.al45 = al45;
	}

	/**
	 * Column Info
	 * @param al20
	 */
	public void setAl20(String al20) {
		this.al20 = al20;
	}

	/**
	 * Column Info
	 * @param od45
	 */
	public void setOd45(String od45) {
		this.od45 = od45;
	}

	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}

	/**
	 * Column Info
	 * @param mupg45
	 */
	public void setMupg45(String mupg45) {
		this.mupg45 = mupg45;
	}

	/**
	 * Column Info
	 * @param obss40h
	 */
	public void setObss40h(String obss40h) {
		this.obss40h = obss40h;
	}

	/**
	 * Column Info
	 * @param al40h
	 */
	public void setAl40h(String al40h) {
		this.al40h = al40h;
	}

	/**
	 * Column Info
	 * @param od40
	 */
	public void setOd40(String od40) {
		this.od40 = od40;
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
	 * @param al40
	 */
	public void setAl40(String al40) {
		this.al40 = al40;
	}

	/**
	 * Column Info
	 * @param ab20
	 */
	public void setAb20(String ab20) {
		this.ab20 = ab20;
	}

	/**
	 * Column Info
	 * @param bc40h
	 */
	public void setBc40h(String bc40h) {
		this.bc40h = bc40h;
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
	 * @param od20
	 */
	public void setOd20(String od20) {
		this.od20 = od20;
	}

	/**
	 * Column Info
	 * @param obsg45
	 */
	public void setObsg45(String obsg45) {
		this.obsg45 = obsg45;
	}

	/**
	 * Column Info
	 * @param ab40
	 */
	public void setAb40(String ab40) {
		this.ab40 = ab40;
	}

	/**
	 * Column Info
	 * @param odab40h
	 */
	public void setOdab40h(String odab40h) {
		this.odab40h = odab40h;
	}

	/**
	 * Column Info
	 * @param od40h
	 */
	public void setOd40h(String od40h) {
		this.od40h = od40h;
	}

	/**
	 * Column Info
	 * @param bc20
	 */
	public void setBc20(String bc20) {
		this.bc20 = bc20;
	}

	/**
	 * Column Info
	 * @param obsg40
	 */
	public void setObsg40(String obsg40) {
		this.obsg40 = obsg40;
	}

	/**
	 * Column Info
	 * @param bc40
	 */
	public void setBc40(String bc40) {
		this.bc40 = bc40;
	}

	/**
	 * Column Info
	 * @param ab40h
	 */
	public void setAb40h(String ab40h) {
		this.ab40h = ab40h;
	}

	/**
	 * Column Info
	 * @param odab40
	 */
	public void setOdab40(String odab40) {
		this.odab40 = odab40;
	}

	/**
	 * Column Info
	 * @param gubunCd3
	 */
	public void setGubunCd3(String gubunCd3) {
		this.gubunCd3 = gubunCd3;
	}

	/**
	 * Column Info
	 * @param odab45
	 */
	public void setOdab45(String odab45) {
		this.odab45 = odab45;
	}

	/**
	 * Column Info
	 * @param obsg40h
	 */
	public void setObsg40h(String obsg40h) {
		this.obsg40h = obsg40h;
	}

	/**
	 * Column Info
	 * @param obsg20
	 */
	public void setObsg20(String obsg20) {
		this.obsg20 = obsg20;
	}

	/**
	 * Column Info
	 * @param odab20
	 */
	public void setOdab20(String odab20) {
		this.odab20 = odab20;
	}

	/**
	 * Column Info
	 * @param ab45
	 */
	public void setAb45(String ab45) {
		this.ab45 = ab45;
	}

	/**
	 * Column Info
	 * @param obss40
	 */
	public void setObss40(String obss40) {
		this.obss40 = obss40;
	}

	/**
	 * Column Info
	 * @param obss20
	 */
	public void setObss20(String obss20) {
		this.obss20 = obss20;
	}

	/**
	 * Column Info
	 * @param bc45
	 */
	public void setBc45(String bc45) {
		this.bc45 = bc45;
	}

	/**
	 * Column Info
	 * @param mupg20
	 */
	public void setMupg20(String mupg20) {
		this.mupg20 = mupg20;
	}

	/**
	 * Column Info
	 * @param mupg40
	 */
	public void setMupg40(String mupg40) {
		this.mupg40 = mupg40;
	}

	/**
	 * Column Info
	 * @param mupg40h
	 */
	public void setMupg40h(String mupg40h) {
		this.mupg40h = mupg40h;
	}

	/**
	 * Column Info
	 * @param obss45
	 */
	public void setObss45(String obss45) {
		this.obss45 = obss45;
	}

	/**
	 * Column Info
	 * @param af20
	 */
	public void setAf20(String af20) {
		this.af20 = af20;
	}

	/**
	 * Column Info
	 * @param af45
	 */
	public void setAf45(String af45) {
		this.af45 = af45;
	}

	/**
	 * Column Info
	 * @param af40
	 */
	public void setAf40(String af40) {
		this.af40 = af40;
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
		setAf40h(JSPUtil.getParameter(request, prefix + "af_40h", ""));
		setAl45(JSPUtil.getParameter(request, prefix + "al_45", ""));
		setAl20(JSPUtil.getParameter(request, prefix + "al_20", ""));
		setOd45(JSPUtil.getParameter(request, prefix + "od_45", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setMupg45(JSPUtil.getParameter(request, prefix + "mupg_45", ""));
		setObss40h(JSPUtil.getParameter(request, prefix + "obss_40h", ""));
		setAl40h(JSPUtil.getParameter(request, prefix + "al_40h", ""));
		setOd40(JSPUtil.getParameter(request, prefix + "od_40", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAl40(JSPUtil.getParameter(request, prefix + "al_40", ""));
		setAb20(JSPUtil.getParameter(request, prefix + "ab_20", ""));
		setBc40h(JSPUtil.getParameter(request, prefix + "bc_40h", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOd20(JSPUtil.getParameter(request, prefix + "od_20", ""));
		setObsg45(JSPUtil.getParameter(request, prefix + "obsg_45", ""));
		setAb40(JSPUtil.getParameter(request, prefix + "ab_40", ""));
		setOdab40h(JSPUtil.getParameter(request, prefix + "odab_40h", ""));
		setOd40h(JSPUtil.getParameter(request, prefix + "od_40h", ""));
		setBc20(JSPUtil.getParameter(request, prefix + "bc_20", ""));
		setObsg40(JSPUtil.getParameter(request, prefix + "obsg_40", ""));
		setBc40(JSPUtil.getParameter(request, prefix + "bc_40", ""));
		setAb40h(JSPUtil.getParameter(request, prefix + "ab_40h", ""));
		setOdab40(JSPUtil.getParameter(request, prefix + "odab_40", ""));
		setGubunCd3(JSPUtil.getParameter(request, prefix + "gubun_cd3", ""));
		setOdab45(JSPUtil.getParameter(request, prefix + "odab_45", ""));
		setObsg40h(JSPUtil.getParameter(request, prefix + "obsg_40h", ""));
		setObsg20(JSPUtil.getParameter(request, prefix + "obsg_20", ""));
		setOdab20(JSPUtil.getParameter(request, prefix + "odab_20", ""));
		setAb45(JSPUtil.getParameter(request, prefix + "ab_45", ""));
		setObss40(JSPUtil.getParameter(request, prefix + "obss_40", ""));
		setObss20(JSPUtil.getParameter(request, prefix + "obss_20", ""));
		setBc45(JSPUtil.getParameter(request, prefix + "bc_45", ""));
		setMupg20(JSPUtil.getParameter(request, prefix + "mupg_20", ""));
		setMupg40(JSPUtil.getParameter(request, prefix + "mupg_40", ""));
		setMupg40h(JSPUtil.getParameter(request, prefix + "mupg_40h", ""));
		setObss45(JSPUtil.getParameter(request, prefix + "obss_45", ""));
		setAf20(JSPUtil.getParameter(request, prefix + "af_20", ""));
		setAf45(JSPUtil.getParameter(request, prefix + "af_45", ""));
		setAf40(JSPUtil.getParameter(request, prefix + "af_40", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllSpclStowRqstDetailVO[]
	 */
	public KorCllSpclStowRqstDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCllSpclStowRqstDetailVO[]
	 */
	public KorCllSpclStowRqstDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllSpclStowRqstDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] af40h = (JSPUtil.getParameter(request, prefix	+ "af_40h", length));
			String[] al45 = (JSPUtil.getParameter(request, prefix	+ "al_45", length));
			String[] al20 = (JSPUtil.getParameter(request, prefix	+ "al_20", length));
			String[] od45 = (JSPUtil.getParameter(request, prefix	+ "od_45", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] mupg45 = (JSPUtil.getParameter(request, prefix	+ "mupg_45", length));
			String[] obss40h = (JSPUtil.getParameter(request, prefix	+ "obss_40h", length));
			String[] al40h = (JSPUtil.getParameter(request, prefix	+ "al_40h", length));
			String[] od40 = (JSPUtil.getParameter(request, prefix	+ "od_40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] al40 = (JSPUtil.getParameter(request, prefix	+ "al_40", length));
			String[] ab20 = (JSPUtil.getParameter(request, prefix	+ "ab_20", length));
			String[] bc40h = (JSPUtil.getParameter(request, prefix	+ "bc_40h", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] od20 = (JSPUtil.getParameter(request, prefix	+ "od_20", length));
			String[] obsg45 = (JSPUtil.getParameter(request, prefix	+ "obsg_45", length));
			String[] ab40 = (JSPUtil.getParameter(request, prefix	+ "ab_40", length));
			String[] odab40h = (JSPUtil.getParameter(request, prefix	+ "odab_40h", length));
			String[] od40h = (JSPUtil.getParameter(request, prefix	+ "od_40h", length));
			String[] bc20 = (JSPUtil.getParameter(request, prefix	+ "bc_20", length));
			String[] obsg40 = (JSPUtil.getParameter(request, prefix	+ "obsg_40", length));
			String[] bc40 = (JSPUtil.getParameter(request, prefix	+ "bc_40", length));
			String[] ab40h = (JSPUtil.getParameter(request, prefix	+ "ab_40h", length));
			String[] odab40 = (JSPUtil.getParameter(request, prefix	+ "odab_40", length));
			String[] gubunCd3 = (JSPUtil.getParameter(request, prefix	+ "gubun_cd3", length));
			String[] odab45 = (JSPUtil.getParameter(request, prefix	+ "odab_45", length));
			String[] obsg40h = (JSPUtil.getParameter(request, prefix	+ "obsg_40h", length));
			String[] obsg20 = (JSPUtil.getParameter(request, prefix	+ "obsg_20", length));
			String[] odab20 = (JSPUtil.getParameter(request, prefix	+ "odab_20", length));
			String[] ab45 = (JSPUtil.getParameter(request, prefix	+ "ab_45", length));
			String[] obss40 = (JSPUtil.getParameter(request, prefix	+ "obss_40", length));
			String[] obss20 = (JSPUtil.getParameter(request, prefix	+ "obss_20", length));
			String[] bc45 = (JSPUtil.getParameter(request, prefix	+ "bc_45", length));
			String[] mupg20 = (JSPUtil.getParameter(request, prefix	+ "mupg_20", length));
			String[] mupg40 = (JSPUtil.getParameter(request, prefix	+ "mupg_40", length));
			String[] mupg40h = (JSPUtil.getParameter(request, prefix	+ "mupg_40h", length));
			String[] obss45 = (JSPUtil.getParameter(request, prefix	+ "obss_45", length));
			String[] af20 = (JSPUtil.getParameter(request, prefix	+ "af_20", length));
			String[] af45 = (JSPUtil.getParameter(request, prefix	+ "af_45", length));
			String[] af40 = (JSPUtil.getParameter(request, prefix	+ "af_40", length));

			for (int i = 0; i < length; i++) {
				model = new KorCllSpclStowRqstDetailVO();
				if (af40h[i] != null)
					model.setAf40h(af40h[i]);
				if (al45[i] != null)
					model.setAl45(al45[i]);
				if (al20[i] != null)
					model.setAl20(al20[i]);
				if (od45[i] != null)
					model.setOd45(od45[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (mupg45[i] != null)
					model.setMupg45(mupg45[i]);
				if (obss40h[i] != null)
					model.setObss40h(obss40h[i]);
				if (al40h[i] != null)
					model.setAl40h(al40h[i]);
				if (od40[i] != null)
					model.setOd40(od40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (al40[i] != null)
					model.setAl40(al40[i]);
				if (ab20[i] != null)
					model.setAb20(ab20[i]);
				if (bc40h[i] != null)
					model.setBc40h(bc40h[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (od20[i] != null)
					model.setOd20(od20[i]);
				if (obsg45[i] != null)
					model.setObsg45(obsg45[i]);
				if (ab40[i] != null)
					model.setAb40(ab40[i]);
				if (odab40h[i] != null)
					model.setOdab40h(odab40h[i]);
				if (od40h[i] != null)
					model.setOd40h(od40h[i]);
				if (bc20[i] != null)
					model.setBc20(bc20[i]);
				if (obsg40[i] != null)
					model.setObsg40(obsg40[i]);
				if (bc40[i] != null)
					model.setBc40(bc40[i]);
				if (ab40h[i] != null)
					model.setAb40h(ab40h[i]);
				if (odab40[i] != null)
					model.setOdab40(odab40[i]);
				if (gubunCd3[i] != null)
					model.setGubunCd3(gubunCd3[i]);
				if (odab45[i] != null)
					model.setOdab45(odab45[i]);
				if (obsg40h[i] != null)
					model.setObsg40h(obsg40h[i]);
				if (obsg20[i] != null)
					model.setObsg20(obsg20[i]);
				if (odab20[i] != null)
					model.setOdab20(odab20[i]);
				if (ab45[i] != null)
					model.setAb45(ab45[i]);
				if (obss40[i] != null)
					model.setObss40(obss40[i]);
				if (obss20[i] != null)
					model.setObss20(obss20[i]);
				if (bc45[i] != null)
					model.setBc45(bc45[i]);
				if (mupg20[i] != null)
					model.setMupg20(mupg20[i]);
				if (mupg40[i] != null)
					model.setMupg40(mupg40[i]);
				if (mupg40h[i] != null)
					model.setMupg40h(mupg40h[i]);
				if (obss45[i] != null)
					model.setObss45(obss45[i]);
				if (af20[i] != null)
					model.setAf20(af20[i]);
				if (af45[i] != null)
					model.setAf45(af45[i]);
				if (af40[i] != null)
					model.setAf40(af40[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllSpclStowRqstDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllSpclStowRqstDetailVO[]
	 */
	public KorCllSpclStowRqstDetailVO[] getKorCllSpclStowRqstDetailVOs(){
		KorCllSpclStowRqstDetailVO[] vos = (KorCllSpclStowRqstDetailVO[])models.toArray(new KorCllSpclStowRqstDetailVO[models.size()]);
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
		this.af40h = this.af40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.al45 = this.al45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.al20 = this.al20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.od45 = this.od45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mupg45 = this.mupg45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obss40h = this.obss40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.al40h = this.al40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.od40 = this.od40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.al40 = this.al40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ab20 = this.ab20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bc40h = this.bc40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.od20 = this.od20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obsg45 = this.obsg45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ab40 = this.ab40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odab40h = this.odab40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.od40h = this.od40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bc20 = this.bc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obsg40 = this.obsg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bc40 = this.bc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ab40h = this.ab40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odab40 = this.odab40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubunCd3 = this.gubunCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odab45 = this.odab45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obsg40h = this.obsg40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obsg20 = this.obsg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odab20 = this.odab20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ab45 = this.ab45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obss40 = this.obss40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obss20 = this.obss20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bc45 = this.bc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mupg20 = this.mupg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mupg40 = this.mupg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mupg40h = this.mupg40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obss45 = this.obss45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.af20 = this.af20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.af45 = this.af45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.af40 = this.af40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
