/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorCllSpclStowRqstDetail2VO.java
*@FileTitle : KorCllSpclStowRqstDetail2VO
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

public class KorCllSpclStowRqstDetail2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCllSpclStowRqstDetail2VO> models = new ArrayList<KorCllSpclStowRqstDetail2VO>();

	/* Column Info */
	private String op40h = null;
	/* Column Info */
	private String odbc45 = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String odft20 = null;
	/* Column Info */
	private String odbc20 = null;
	/* Column Info */
	private String odal40 = null;
	/* Column Info */
	private String odbc40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String odal20 = null;
	/* Column Info */
	private String odft45 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String op45 = null;
	/* Column Info */
	private String odft40h = null;
	/* Column Info */
	private String odet40h = null;
	/* Column Info */
	private String odhd40 = null;
	/* Column Info */
	private String gubunCd3 = null;
	/* Column Info */
	private String ot20 = null;
	/* Column Info */
	private String pc40h = null;
	/* Column Info */
	private String pc40 = null;
	/* Column Info */
	private String odbc40h = null;
	/* Column Info */
	private String odhd20 = null;
	/* Column Info */
	private String odet40 = null;
	/* Column Info */
	private String odft40 = null;
	/* Column Info */
	private String odet45 = null;
	/* Column Info */
	private String op20 = null;
	/* Column Info */
	private String otno40h = null;
	/* Column Info */
	private String op40 = null;
	/* Column Info */
	private String odet20 = null;
	/* Column Info */
	private String odal40h = null;
	/* Column Info */
	private String odhd40h = null;
	/* Column Info */
	private String odal45 = null;
	/* Column Info */
	private String pc20 = null;
	/* Column Info */
	private String otno45 = null;
	/* Column Info */
	private String ot40h = null;
	/* Column Info */
	private String ot45 = null;
	/* Column Info */
	private String otno40 = null;
	/* Column Info */
	private String ot40 = null;
	/* Column Info */
	private String pc45 = null;
	/* Column Info */
	private String otno20 = null;
	/* Column Info */
	private String odhd45 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCllSpclStowRqstDetail2VO() {}

	public KorCllSpclStowRqstDetail2VO(String ibflag, String pagerows, String gubunCd3, String blckStwgCd, String odal20, String odal40, String odal40h, String odal45, String odbc20, String odbc40, String odbc40h, String odbc45, String odet20, String odet40, String odet40h, String odet45, String odft20, String odft40, String odft40h, String odft45, String odhd20, String odhd40, String odhd40h, String odhd45, String op20, String op40, String op40h, String op45, String ot20, String ot40, String ot40h, String ot45, String otno20, String otno40, String otno40h, String otno45, String pc20, String pc40, String pc40h, String pc45) {
		this.op40h = op40h;
		this.odbc45 = odbc45;
		this.blckStwgCd = blckStwgCd;
		this.odft20 = odft20;
		this.odbc20 = odbc20;
		this.odal40 = odal40;
		this.odbc40 = odbc40;
		this.pagerows = pagerows;
		this.odal20 = odal20;
		this.odft45 = odft45;
		this.ibflag = ibflag;
		this.op45 = op45;
		this.odft40h = odft40h;
		this.odet40h = odet40h;
		this.odhd40 = odhd40;
		this.gubunCd3 = gubunCd3;
		this.ot20 = ot20;
		this.pc40h = pc40h;
		this.pc40 = pc40;
		this.odbc40h = odbc40h;
		this.odhd20 = odhd20;
		this.odet40 = odet40;
		this.odft40 = odft40;
		this.odet45 = odet45;
		this.op20 = op20;
		this.otno40h = otno40h;
		this.op40 = op40;
		this.odet20 = odet20;
		this.odal40h = odal40h;
		this.odhd40h = odhd40h;
		this.odal45 = odal45;
		this.pc20 = pc20;
		this.otno45 = otno45;
		this.ot40h = ot40h;
		this.ot45 = ot45;
		this.otno40 = otno40;
		this.ot40 = ot40;
		this.pc45 = pc45;
		this.otno20 = otno20;
		this.odhd45 = odhd45;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("op_40h", getOp40h());
		this.hashColumns.put("odbc_45", getOdbc45());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("odft_20", getOdft20());
		this.hashColumns.put("odbc_20", getOdbc20());
		this.hashColumns.put("odal_40", getOdal40());
		this.hashColumns.put("odbc_40", getOdbc40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("odal_20", getOdal20());
		this.hashColumns.put("odft_45", getOdft45());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("op_45", getOp45());
		this.hashColumns.put("odft_40h", getOdft40h());
		this.hashColumns.put("odet_40h", getOdet40h());
		this.hashColumns.put("odhd_40", getOdhd40());
		this.hashColumns.put("gubun_cd3", getGubunCd3());
		this.hashColumns.put("ot_20", getOt20());
		this.hashColumns.put("pc_40h", getPc40h());
		this.hashColumns.put("pc_40", getPc40());
		this.hashColumns.put("odbc_40h", getOdbc40h());
		this.hashColumns.put("odhd_20", getOdhd20());
		this.hashColumns.put("odet_40", getOdet40());
		this.hashColumns.put("odft_40", getOdft40());
		this.hashColumns.put("odet_45", getOdet45());
		this.hashColumns.put("op_20", getOp20());
		this.hashColumns.put("otno_40h", getOtno40h());
		this.hashColumns.put("op_40", getOp40());
		this.hashColumns.put("odet_20", getOdet20());
		this.hashColumns.put("odal_40h", getOdal40h());
		this.hashColumns.put("odhd_40h", getOdhd40h());
		this.hashColumns.put("odal_45", getOdal45());
		this.hashColumns.put("pc_20", getPc20());
		this.hashColumns.put("otno_45", getOtno45());
		this.hashColumns.put("ot_40h", getOt40h());
		this.hashColumns.put("ot_45", getOt45());
		this.hashColumns.put("otno_40", getOtno40());
		this.hashColumns.put("ot_40", getOt40());
		this.hashColumns.put("pc_45", getPc45());
		this.hashColumns.put("otno_20", getOtno20());
		this.hashColumns.put("odhd_45", getOdhd45());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("op_40h", "op40h");
		this.hashFields.put("odbc_45", "odbc45");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("odft_20", "odft20");
		this.hashFields.put("odbc_20", "odbc20");
		this.hashFields.put("odal_40", "odal40");
		this.hashFields.put("odbc_40", "odbc40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("odal_20", "odal20");
		this.hashFields.put("odft_45", "odft45");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("op_45", "op45");
		this.hashFields.put("odft_40h", "odft40h");
		this.hashFields.put("odet_40h", "odet40h");
		this.hashFields.put("odhd_40", "odhd40");
		this.hashFields.put("gubun_cd3", "gubunCd3");
		this.hashFields.put("ot_20", "ot20");
		this.hashFields.put("pc_40h", "pc40h");
		this.hashFields.put("pc_40", "pc40");
		this.hashFields.put("odbc_40h", "odbc40h");
		this.hashFields.put("odhd_20", "odhd20");
		this.hashFields.put("odet_40", "odet40");
		this.hashFields.put("odft_40", "odft40");
		this.hashFields.put("odet_45", "odet45");
		this.hashFields.put("op_20", "op20");
		this.hashFields.put("otno_40h", "otno40h");
		this.hashFields.put("op_40", "op40");
		this.hashFields.put("odet_20", "odet20");
		this.hashFields.put("odal_40h", "odal40h");
		this.hashFields.put("odhd_40h", "odhd40h");
		this.hashFields.put("odal_45", "odal45");
		this.hashFields.put("pc_20", "pc20");
		this.hashFields.put("otno_45", "otno45");
		this.hashFields.put("ot_40h", "ot40h");
		this.hashFields.put("ot_45", "ot45");
		this.hashFields.put("otno_40", "otno40");
		this.hashFields.put("ot_40", "ot40");
		this.hashFields.put("pc_45", "pc45");
		this.hashFields.put("otno_20", "otno20");
		this.hashFields.put("odhd_45", "odhd45");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return op40h
	 */
	public String getOp40h() {
		return this.op40h;
	}

	/**
	 * Column Info
	 * @return odbc45
	 */
	public String getOdbc45() {
		return this.odbc45;
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
	 * @return odft20
	 */
	public String getOdft20() {
		return this.odft20;
	}

	/**
	 * Column Info
	 * @return odbc20
	 */
	public String getOdbc20() {
		return this.odbc20;
	}

	/**
	 * Column Info
	 * @return odal40
	 */
	public String getOdal40() {
		return this.odal40;
	}

	/**
	 * Column Info
	 * @return odbc40
	 */
	public String getOdbc40() {
		return this.odbc40;
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
	 * @return odal20
	 */
	public String getOdal20() {
		return this.odal20;
	}

	/**
	 * Column Info
	 * @return odft45
	 */
	public String getOdft45() {
		return this.odft45;
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
	 * @return op45
	 */
	public String getOp45() {
		return this.op45;
	}

	/**
	 * Column Info
	 * @return odft40h
	 */
	public String getOdft40h() {
		return this.odft40h;
	}

	/**
	 * Column Info
	 * @return odet40h
	 */
	public String getOdet40h() {
		return this.odet40h;
	}

	/**
	 * Column Info
	 * @return odhd40
	 */
	public String getOdhd40() {
		return this.odhd40;
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
	 * @return ot20
	 */
	public String getOt20() {
		return this.ot20;
	}

	/**
	 * Column Info
	 * @return pc40h
	 */
	public String getPc40h() {
		return this.pc40h;
	}

	/**
	 * Column Info
	 * @return pc40
	 */
	public String getPc40() {
		return this.pc40;
	}

	/**
	 * Column Info
	 * @return odbc40h
	 */
	public String getOdbc40h() {
		return this.odbc40h;
	}

	/**
	 * Column Info
	 * @return odhd20
	 */
	public String getOdhd20() {
		return this.odhd20;
	}

	/**
	 * Column Info
	 * @return odet40
	 */
	public String getOdet40() {
		return this.odet40;
	}

	/**
	 * Column Info
	 * @return odft40
	 */
	public String getOdft40() {
		return this.odft40;
	}

	/**
	 * Column Info
	 * @return odet45
	 */
	public String getOdet45() {
		return this.odet45;
	}

	/**
	 * Column Info
	 * @return op20
	 */
	public String getOp20() {
		return this.op20;
	}

	/**
	 * Column Info
	 * @return otno40h
	 */
	public String getOtno40h() {
		return this.otno40h;
	}

	/**
	 * Column Info
	 * @return op40
	 */
	public String getOp40() {
		return this.op40;
	}

	/**
	 * Column Info
	 * @return odet20
	 */
	public String getOdet20() {
		return this.odet20;
	}

	/**
	 * Column Info
	 * @return odal40h
	 */
	public String getOdal40h() {
		return this.odal40h;
	}

	/**
	 * Column Info
	 * @return odhd40h
	 */
	public String getOdhd40h() {
		return this.odhd40h;
	}

	/**
	 * Column Info
	 * @return odal45
	 */
	public String getOdal45() {
		return this.odal45;
	}

	/**
	 * Column Info
	 * @return pc20
	 */
	public String getPc20() {
		return this.pc20;
	}

	/**
	 * Column Info
	 * @return otno45
	 */
	public String getOtno45() {
		return this.otno45;
	}

	/**
	 * Column Info
	 * @return ot40h
	 */
	public String getOt40h() {
		return this.ot40h;
	}

	/**
	 * Column Info
	 * @return ot45
	 */
	public String getOt45() {
		return this.ot45;
	}

	/**
	 * Column Info
	 * @return otno40
	 */
	public String getOtno40() {
		return this.otno40;
	}

	/**
	 * Column Info
	 * @return ot40
	 */
	public String getOt40() {
		return this.ot40;
	}

	/**
	 * Column Info
	 * @return pc45
	 */
	public String getPc45() {
		return this.pc45;
	}

	/**
	 * Column Info
	 * @return otno20
	 */
	public String getOtno20() {
		return this.otno20;
	}

	/**
	 * Column Info
	 * @return odhd45
	 */
	public String getOdhd45() {
		return this.odhd45;
	}


	/**
	 * Column Info
	 * @param op40h
	 */
	public void setOp40h(String op40h) {
		this.op40h = op40h;
	}

	/**
	 * Column Info
	 * @param odbc45
	 */
	public void setOdbc45(String odbc45) {
		this.odbc45 = odbc45;
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
	 * @param odft20
	 */
	public void setOdft20(String odft20) {
		this.odft20 = odft20;
	}

	/**
	 * Column Info
	 * @param odbc20
	 */
	public void setOdbc20(String odbc20) {
		this.odbc20 = odbc20;
	}

	/**
	 * Column Info
	 * @param odal40
	 */
	public void setOdal40(String odal40) {
		this.odal40 = odal40;
	}

	/**
	 * Column Info
	 * @param odbc40
	 */
	public void setOdbc40(String odbc40) {
		this.odbc40 = odbc40;
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
	 * @param odal20
	 */
	public void setOdal20(String odal20) {
		this.odal20 = odal20;
	}

	/**
	 * Column Info
	 * @param odft45
	 */
	public void setOdft45(String odft45) {
		this.odft45 = odft45;
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
	 * @param op45
	 */
	public void setOp45(String op45) {
		this.op45 = op45;
	}

	/**
	 * Column Info
	 * @param odft40h
	 */
	public void setOdft40h(String odft40h) {
		this.odft40h = odft40h;
	}

	/**
	 * Column Info
	 * @param odet40h
	 */
	public void setOdet40h(String odet40h) {
		this.odet40h = odet40h;
	}

	/**
	 * Column Info
	 * @param odhd40
	 */
	public void setOdhd40(String odhd40) {
		this.odhd40 = odhd40;
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
	 * @param ot20
	 */
	public void setOt20(String ot20) {
		this.ot20 = ot20;
	}

	/**
	 * Column Info
	 * @param pc40h
	 */
	public void setPc40h(String pc40h) {
		this.pc40h = pc40h;
	}

	/**
	 * Column Info
	 * @param pc40
	 */
	public void setPc40(String pc40) {
		this.pc40 = pc40;
	}

	/**
	 * Column Info
	 * @param odbc40h
	 */
	public void setOdbc40h(String odbc40h) {
		this.odbc40h = odbc40h;
	}

	/**
	 * Column Info
	 * @param odhd20
	 */
	public void setOdhd20(String odhd20) {
		this.odhd20 = odhd20;
	}

	/**
	 * Column Info
	 * @param odet40
	 */
	public void setOdet40(String odet40) {
		this.odet40 = odet40;
	}

	/**
	 * Column Info
	 * @param odft40
	 */
	public void setOdft40(String odft40) {
		this.odft40 = odft40;
	}

	/**
	 * Column Info
	 * @param odet45
	 */
	public void setOdet45(String odet45) {
		this.odet45 = odet45;
	}

	/**
	 * Column Info
	 * @param op20
	 */
	public void setOp20(String op20) {
		this.op20 = op20;
	}

	/**
	 * Column Info
	 * @param otno40h
	 */
	public void setOtno40h(String otno40h) {
		this.otno40h = otno40h;
	}

	/**
	 * Column Info
	 * @param op40
	 */
	public void setOp40(String op40) {
		this.op40 = op40;
	}

	/**
	 * Column Info
	 * @param odet20
	 */
	public void setOdet20(String odet20) {
		this.odet20 = odet20;
	}

	/**
	 * Column Info
	 * @param odal40h
	 */
	public void setOdal40h(String odal40h) {
		this.odal40h = odal40h;
	}

	/**
	 * Column Info
	 * @param odhd40h
	 */
	public void setOdhd40h(String odhd40h) {
		this.odhd40h = odhd40h;
	}

	/**
	 * Column Info
	 * @param odal45
	 */
	public void setOdal45(String odal45) {
		this.odal45 = odal45;
	}

	/**
	 * Column Info
	 * @param pc20
	 */
	public void setPc20(String pc20) {
		this.pc20 = pc20;
	}

	/**
	 * Column Info
	 * @param otno45
	 */
	public void setOtno45(String otno45) {
		this.otno45 = otno45;
	}

	/**
	 * Column Info
	 * @param ot40h
	 */
	public void setOt40h(String ot40h) {
		this.ot40h = ot40h;
	}

	/**
	 * Column Info
	 * @param ot45
	 */
	public void setOt45(String ot45) {
		this.ot45 = ot45;
	}

	/**
	 * Column Info
	 * @param otno40
	 */
	public void setOtno40(String otno40) {
		this.otno40 = otno40;
	}

	/**
	 * Column Info
	 * @param ot40
	 */
	public void setOt40(String ot40) {
		this.ot40 = ot40;
	}

	/**
	 * Column Info
	 * @param pc45
	 */
	public void setPc45(String pc45) {
		this.pc45 = pc45;
	}

	/**
	 * Column Info
	 * @param otno20
	 */
	public void setOtno20(String otno20) {
		this.otno20 = otno20;
	}

	/**
	 * Column Info
	 * @param odhd45
	 */
	public void setOdhd45(String odhd45) {
		this.odhd45 = odhd45;
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
		setOp40h(JSPUtil.getParameter(request, prefix + "op_40h", ""));
		setOdbc45(JSPUtil.getParameter(request, prefix + "odbc_45", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setOdft20(JSPUtil.getParameter(request, prefix + "odft_20", ""));
		setOdbc20(JSPUtil.getParameter(request, prefix + "odbc_20", ""));
		setOdal40(JSPUtil.getParameter(request, prefix + "odal_40", ""));
		setOdbc40(JSPUtil.getParameter(request, prefix + "odbc_40", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOdal20(JSPUtil.getParameter(request, prefix + "odal_20", ""));
		setOdft45(JSPUtil.getParameter(request, prefix + "odft_45", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOp45(JSPUtil.getParameter(request, prefix + "op_45", ""));
		setOdft40h(JSPUtil.getParameter(request, prefix + "odft_40h", ""));
		setOdet40h(JSPUtil.getParameter(request, prefix + "odet_40h", ""));
		setOdhd40(JSPUtil.getParameter(request, prefix + "odhd_40", ""));
		setGubunCd3(JSPUtil.getParameter(request, prefix + "gubun_cd3", ""));
		setOt20(JSPUtil.getParameter(request, prefix + "ot_20", ""));
		setPc40h(JSPUtil.getParameter(request, prefix + "pc_40h", ""));
		setPc40(JSPUtil.getParameter(request, prefix + "pc_40", ""));
		setOdbc40h(JSPUtil.getParameter(request, prefix + "odbc_40h", ""));
		setOdhd20(JSPUtil.getParameter(request, prefix + "odhd_20", ""));
		setOdet40(JSPUtil.getParameter(request, prefix + "odet_40", ""));
		setOdft40(JSPUtil.getParameter(request, prefix + "odft_40", ""));
		setOdet45(JSPUtil.getParameter(request, prefix + "odet_45", ""));
		setOp20(JSPUtil.getParameter(request, prefix + "op_20", ""));
		setOtno40h(JSPUtil.getParameter(request, prefix + "otno_40h", ""));
		setOp40(JSPUtil.getParameter(request, prefix + "op_40", ""));
		setOdet20(JSPUtil.getParameter(request, prefix + "odet_20", ""));
		setOdal40h(JSPUtil.getParameter(request, prefix + "odal_40h", ""));
		setOdhd40h(JSPUtil.getParameter(request, prefix + "odhd_40h", ""));
		setOdal45(JSPUtil.getParameter(request, prefix + "odal_45", ""));
		setPc20(JSPUtil.getParameter(request, prefix + "pc_20", ""));
		setOtno45(JSPUtil.getParameter(request, prefix + "otno_45", ""));
		setOt40h(JSPUtil.getParameter(request, prefix + "ot_40h", ""));
		setOt45(JSPUtil.getParameter(request, prefix + "ot_45", ""));
		setOtno40(JSPUtil.getParameter(request, prefix + "otno_40", ""));
		setOt40(JSPUtil.getParameter(request, prefix + "ot_40", ""));
		setPc45(JSPUtil.getParameter(request, prefix + "pc_45", ""));
		setOtno20(JSPUtil.getParameter(request, prefix + "otno_20", ""));
		setOdhd45(JSPUtil.getParameter(request, prefix + "odhd_45", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllSpclStowRqstDetail2VO[]
	 */
	public KorCllSpclStowRqstDetail2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCllSpclStowRqstDetail2VO[]
	 */
	public KorCllSpclStowRqstDetail2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllSpclStowRqstDetail2VO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] op40h = (JSPUtil.getParameter(request, prefix	+ "op_40h", length));
			String[] odbc45 = (JSPUtil.getParameter(request, prefix	+ "odbc_45", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] odft20 = (JSPUtil.getParameter(request, prefix	+ "odft_20", length));
			String[] odbc20 = (JSPUtil.getParameter(request, prefix	+ "odbc_20", length));
			String[] odal40 = (JSPUtil.getParameter(request, prefix	+ "odal_40", length));
			String[] odbc40 = (JSPUtil.getParameter(request, prefix	+ "odbc_40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] odal20 = (JSPUtil.getParameter(request, prefix	+ "odal_20", length));
			String[] odft45 = (JSPUtil.getParameter(request, prefix	+ "odft_45", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] op45 = (JSPUtil.getParameter(request, prefix	+ "op_45", length));
			String[] odft40h = (JSPUtil.getParameter(request, prefix	+ "odft_40h", length));
			String[] odet40h = (JSPUtil.getParameter(request, prefix	+ "odet_40h", length));
			String[] odhd40 = (JSPUtil.getParameter(request, prefix	+ "odhd_40", length));
			String[] gubunCd3 = (JSPUtil.getParameter(request, prefix	+ "gubun_cd3", length));
			String[] ot20 = (JSPUtil.getParameter(request, prefix	+ "ot_20", length));
			String[] pc40h = (JSPUtil.getParameter(request, prefix	+ "pc_40h", length));
			String[] pc40 = (JSPUtil.getParameter(request, prefix	+ "pc_40", length));
			String[] odbc40h = (JSPUtil.getParameter(request, prefix	+ "odbc_40h", length));
			String[] odhd20 = (JSPUtil.getParameter(request, prefix	+ "odhd_20", length));
			String[] odet40 = (JSPUtil.getParameter(request, prefix	+ "odet_40", length));
			String[] odft40 = (JSPUtil.getParameter(request, prefix	+ "odft_40", length));
			String[] odet45 = (JSPUtil.getParameter(request, prefix	+ "odet_45", length));
			String[] op20 = (JSPUtil.getParameter(request, prefix	+ "op_20", length));
			String[] otno40h = (JSPUtil.getParameter(request, prefix	+ "otno_40h", length));
			String[] op40 = (JSPUtil.getParameter(request, prefix	+ "op_40", length));
			String[] odet20 = (JSPUtil.getParameter(request, prefix	+ "odet_20", length));
			String[] odal40h = (JSPUtil.getParameter(request, prefix	+ "odal_40h", length));
			String[] odhd40h = (JSPUtil.getParameter(request, prefix	+ "odhd_40h", length));
			String[] odal45 = (JSPUtil.getParameter(request, prefix	+ "odal_45", length));
			String[] pc20 = (JSPUtil.getParameter(request, prefix	+ "pc_20", length));
			String[] otno45 = (JSPUtil.getParameter(request, prefix	+ "otno_45", length));
			String[] ot40h = (JSPUtil.getParameter(request, prefix	+ "ot_40h", length));
			String[] ot45 = (JSPUtil.getParameter(request, prefix	+ "ot_45", length));
			String[] otno40 = (JSPUtil.getParameter(request, prefix	+ "otno_40", length));
			String[] ot40 = (JSPUtil.getParameter(request, prefix	+ "ot_40", length));
			String[] pc45 = (JSPUtil.getParameter(request, prefix	+ "pc_45", length));
			String[] otno20 = (JSPUtil.getParameter(request, prefix	+ "otno_20", length));
			String[] odhd45 = (JSPUtil.getParameter(request, prefix	+ "odhd_45", length));

			for (int i = 0; i < length; i++) {
				model = new KorCllSpclStowRqstDetail2VO();
				if (op40h[i] != null)
					model.setOp40h(op40h[i]);
				if (odbc45[i] != null)
					model.setOdbc45(odbc45[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (odft20[i] != null)
					model.setOdft20(odft20[i]);
				if (odbc20[i] != null)
					model.setOdbc20(odbc20[i]);
				if (odal40[i] != null)
					model.setOdal40(odal40[i]);
				if (odbc40[i] != null)
					model.setOdbc40(odbc40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (odal20[i] != null)
					model.setOdal20(odal20[i]);
				if (odft45[i] != null)
					model.setOdft45(odft45[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (op45[i] != null)
					model.setOp45(op45[i]);
				if (odft40h[i] != null)
					model.setOdft40h(odft40h[i]);
				if (odet40h[i] != null)
					model.setOdet40h(odet40h[i]);
				if (odhd40[i] != null)
					model.setOdhd40(odhd40[i]);
				if (gubunCd3[i] != null)
					model.setGubunCd3(gubunCd3[i]);
				if (ot20[i] != null)
					model.setOt20(ot20[i]);
				if (pc40h[i] != null)
					model.setPc40h(pc40h[i]);
				if (pc40[i] != null)
					model.setPc40(pc40[i]);
				if (odbc40h[i] != null)
					model.setOdbc40h(odbc40h[i]);
				if (odhd20[i] != null)
					model.setOdhd20(odhd20[i]);
				if (odet40[i] != null)
					model.setOdet40(odet40[i]);
				if (odft40[i] != null)
					model.setOdft40(odft40[i]);
				if (odet45[i] != null)
					model.setOdet45(odet45[i]);
				if (op20[i] != null)
					model.setOp20(op20[i]);
				if (otno40h[i] != null)
					model.setOtno40h(otno40h[i]);
				if (op40[i] != null)
					model.setOp40(op40[i]);
				if (odet20[i] != null)
					model.setOdet20(odet20[i]);
				if (odal40h[i] != null)
					model.setOdal40h(odal40h[i]);
				if (odhd40h[i] != null)
					model.setOdhd40h(odhd40h[i]);
				if (odal45[i] != null)
					model.setOdal45(odal45[i]);
				if (pc20[i] != null)
					model.setPc20(pc20[i]);
				if (otno45[i] != null)
					model.setOtno45(otno45[i]);
				if (ot40h[i] != null)
					model.setOt40h(ot40h[i]);
				if (ot45[i] != null)
					model.setOt45(ot45[i]);
				if (otno40[i] != null)
					model.setOtno40(otno40[i]);
				if (ot40[i] != null)
					model.setOt40(ot40[i]);
				if (pc45[i] != null)
					model.setPc45(pc45[i]);
				if (otno20[i] != null)
					model.setOtno20(otno20[i]);
				if (odhd45[i] != null)
					model.setOdhd45(odhd45[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllSpclStowRqstDetail2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllSpclStowRqstDetail2VO[]
	 */
	public KorCllSpclStowRqstDetail2VO[] getKorCllSpclStowRqstDetail2VOs(){
		KorCllSpclStowRqstDetail2VO[] vos = (KorCllSpclStowRqstDetail2VO[])models.toArray(new KorCllSpclStowRqstDetail2VO[models.size()]);
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
		this.op40h = this.op40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odbc45 = this.odbc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odft20 = this.odft20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odbc20 = this.odbc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odal40 = this.odal40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odbc40 = this.odbc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odal20 = this.odal20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odft45 = this.odft45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op45 = this.op45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odft40h = this.odft40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odet40h = this.odet40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odhd40 = this.odhd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubunCd3 = this.gubunCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ot20 = this.ot20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pc40h = this.pc40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pc40 = this.pc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odbc40h = this.odbc40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odhd20 = this.odhd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odet40 = this.odet40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odft40 = this.odft40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odet45 = this.odet45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op20 = this.op20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otno40h = this.otno40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op40 = this.op40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odet20 = this.odet20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odal40h = this.odal40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odhd40h = this.odhd40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odal45 = this.odal45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pc20 = this.pc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otno45 = this.otno45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ot40h = this.ot40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ot45 = this.ot45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otno40 = this.otno40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ot40 = this.ot40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pc45 = this.pc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otno20 = this.otno20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odhd45 = this.odhd45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
