/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RejectEdiDgVO.java
*@FileTitle : RejectEdiDgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.03 전용진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RejectEdiDgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RejectEdiDgVO> models = new ArrayList<RejectEdiDgVO>();
	
	/* Column Info */
	private String aDgDesc = null;
	/* Column Info */
	private String aDgLabelDesc = null;
	/* Column Info */
	private String aDgStwg = null;
	/* Column Info */
	private String aDgMeaUnit = null;
	/* Column Info */
	private String aDgGwgt = null;
	/* Column Info */
	private String aDgLabel = null;
	/* Column Info */
	private String aDgPkggrp = null;
	/* Column Info */
	private String aDgFpun = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String aDgDPkgunit = null;
	/* Column Info */
	private String aDgClas = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aDgNwgt = null;
	/* Column Info */
	private String aDgMea = null;
	/* Column Info */
	private String aDgMfag1 = null;
	/* Column Info */
	private String aDgMfag2 = null;
	/* Column Info */
	private String aDgMarPoll = null;
	/* Column Info */
	private String aDgNwgtUnit = null;
	/* Column Info */
	private String aDgEmsno = null;
	/* Column Info */
	private String aDgFpnt = null;
	/* Column Info */
	private String aDgDgRemark = null;
	/* Column Info */
	private String aDgUnbr = null;
	/* Column Info */
	private String aDgGwgtUnit = null;
	/* Column Info */
	private String aDgPage = null;
	/* Column Info */
	private String aDgDPkg = null;
	/* Column Info */
	private String aDgPsacls = null;
	/* Column Info */
	private String aDgHazCont = null;
	/* Column Info */
	private String aDgLabelCd = null;
	/* Column Info */
	private String aDgPhon = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RejectEdiDgVO() {}

	public RejectEdiDgVO(String ibflag, String pagerows, String aDgUnbr, String aDgClas, String aDgDesc, String aDgPhon, String aDgPage, String aDgFpnt, String aDgFpun, String aDgDgRemark, String aDgEmsno, String aDgPsacls, String aDgPkggrp, String aDgMfag1, String aDgMfag2, String aDgMarPoll, String aDgLabelCd, String aDgLabelDesc, String aDgDPkg, String aDgDPkgunit, String aDgNwgt, String aDgNwgtUnit, String aDgGwgt, String aDgGwgtUnit, String aDgMea, String aDgMeaUnit, String aDgHazCont, String aDgStwg, String aDgLabel) {
		this.aDgDesc = aDgDesc;
		this.aDgLabelDesc = aDgLabelDesc;
		this.aDgStwg = aDgStwg;
		this.aDgMeaUnit = aDgMeaUnit;
		this.aDgGwgt = aDgGwgt;
		this.aDgLabel = aDgLabel;
		this.aDgPkggrp = aDgPkggrp;
		this.aDgFpun = aDgFpun;
		this.pagerows = pagerows;
		this.aDgDPkgunit = aDgDPkgunit;
		this.aDgClas = aDgClas;
		this.ibflag = ibflag;
		this.aDgNwgt = aDgNwgt;
		this.aDgMea = aDgMea;
		this.aDgMfag1 = aDgMfag1;
		this.aDgMfag2 = aDgMfag2;
		this.aDgMarPoll = aDgMarPoll;
		this.aDgNwgtUnit = aDgNwgtUnit;
		this.aDgEmsno = aDgEmsno;
		this.aDgFpnt = aDgFpnt;
		this.aDgDgRemark = aDgDgRemark;
		this.aDgUnbr = aDgUnbr;
		this.aDgGwgtUnit = aDgGwgtUnit;
		this.aDgPage = aDgPage;
		this.aDgDPkg = aDgDPkg;
		this.aDgPsacls = aDgPsacls;
		this.aDgHazCont = aDgHazCont;
		this.aDgLabelCd = aDgLabelCd;
		this.aDgPhon = aDgPhon;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("a_dg_desc", getADgDesc());
		this.hashColumns.put("a_dg_label_desc", getADgLabelDesc());
		this.hashColumns.put("a_dg_stwg", getADgStwg());
		this.hashColumns.put("a_dg_mea_unit", getADgMeaUnit());
		this.hashColumns.put("a_dg_gwgt", getADgGwgt());
		this.hashColumns.put("a_dg_label", getADgLabel());
		this.hashColumns.put("a_dg_pkggrp", getADgPkggrp());
		this.hashColumns.put("a_dg_fpun", getADgFpun());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("a_dg_d_pkgunit", getADgDPkgunit());
		this.hashColumns.put("a_dg_clas", getADgClas());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("a_dg_nwgt", getADgNwgt());
		this.hashColumns.put("a_dg_mea", getADgMea());
		this.hashColumns.put("a_dg_mfag1", getADgMfag1());
		this.hashColumns.put("a_dg_mfag2", getADgMfag2());
		this.hashColumns.put("a_dg_mar_poll", getADgMarPoll());
		this.hashColumns.put("a_dg_nwgt_unit", getADgNwgtUnit());
		this.hashColumns.put("a_dg_emsno", getADgEmsno());
		this.hashColumns.put("a_dg_fpnt", getADgFpnt());
		this.hashColumns.put("a_dg_dg_remark", getADgDgRemark());
		this.hashColumns.put("a_dg_unbr", getADgUnbr());
		this.hashColumns.put("a_dg_gwgt_unit", getADgGwgtUnit());
		this.hashColumns.put("a_dg_page", getADgPage());
		this.hashColumns.put("a_dg_d_pkg", getADgDPkg());
		this.hashColumns.put("a_dg_psacls", getADgPsacls());
		this.hashColumns.put("a_dg_haz_cont", getADgHazCont());
		this.hashColumns.put("a_dg_label_cd", getADgLabelCd());
		this.hashColumns.put("a_dg_phon", getADgPhon());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("a_dg_desc", "aDgDesc");
		this.hashFields.put("a_dg_label_desc", "aDgLabelDesc");
		this.hashFields.put("a_dg_stwg", "aDgStwg");
		this.hashFields.put("a_dg_mea_unit", "aDgMeaUnit");
		this.hashFields.put("a_dg_gwgt", "aDgGwgt");
		this.hashFields.put("a_dg_label", "aDgLabel");
		this.hashFields.put("a_dg_pkggrp", "aDgPkggrp");
		this.hashFields.put("a_dg_fpun", "aDgFpun");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("a_dg_d_pkgunit", "aDgDPkgunit");
		this.hashFields.put("a_dg_clas", "aDgClas");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("a_dg_nwgt", "aDgNwgt");
		this.hashFields.put("a_dg_mea", "aDgMea");
		this.hashFields.put("a_dg_mfag1", "aDgMfag1");
		this.hashFields.put("a_dg_mfag2", "aDgMfag2");
		this.hashFields.put("a_dg_mar_poll", "aDgMarPoll");
		this.hashFields.put("a_dg_nwgt_unit", "aDgNwgtUnit");
		this.hashFields.put("a_dg_emsno", "aDgEmsno");
		this.hashFields.put("a_dg_fpnt", "aDgFpnt");
		this.hashFields.put("a_dg_dg_remark", "aDgDgRemark");
		this.hashFields.put("a_dg_unbr", "aDgUnbr");
		this.hashFields.put("a_dg_gwgt_unit", "aDgGwgtUnit");
		this.hashFields.put("a_dg_page", "aDgPage");
		this.hashFields.put("a_dg_d_pkg", "aDgDPkg");
		this.hashFields.put("a_dg_psacls", "aDgPsacls");
		this.hashFields.put("a_dg_haz_cont", "aDgHazCont");
		this.hashFields.put("a_dg_label_cd", "aDgLabelCd");
		this.hashFields.put("a_dg_phon", "aDgPhon");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aDgDesc
	 */
	public String getADgDesc() {
		return this.aDgDesc;
	}
	
	/**
	 * Column Info
	 * @return aDgLabelDesc
	 */
	public String getADgLabelDesc() {
		return this.aDgLabelDesc;
	}
	
	/**
	 * Column Info
	 * @return aDgStwg
	 */
	public String getADgStwg() {
		return this.aDgStwg;
	}
	
	/**
	 * Column Info
	 * @return aDgMeaUnit
	 */
	public String getADgMeaUnit() {
		return this.aDgMeaUnit;
	}
	
	/**
	 * Column Info
	 * @return aDgGwgt
	 */
	public String getADgGwgt() {
		return this.aDgGwgt;
	}
	
	/**
	 * Column Info
	 * @return aDgLabel
	 */
	public String getADgLabel() {
		return this.aDgLabel;
	}
	
	/**
	 * Column Info
	 * @return aDgPkggrp
	 */
	public String getADgPkggrp() {
		return this.aDgPkggrp;
	}
	
	/**
	 * Column Info
	 * @return aDgFpun
	 */
	public String getADgFpun() {
		return this.aDgFpun;
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
	 * @return aDgDPkgunit
	 */
	public String getADgDPkgunit() {
		return this.aDgDPkgunit;
	}
	
	/**
	 * Column Info
	 * @return aDgClas
	 */
	public String getADgClas() {
		return this.aDgClas;
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
	 * @return aDgNwgt
	 */
	public String getADgNwgt() {
		return this.aDgNwgt;
	}
	
	/**
	 * Column Info
	 * @return aDgMea
	 */
	public String getADgMea() {
		return this.aDgMea;
	}
	
	/**
	 * Column Info
	 * @return aDgMfag1
	 */
	public String getADgMfag1() {
		return this.aDgMfag1;
	}
	
	/**
	 * Column Info
	 * @return aDgMfag2
	 */
	public String getADgMfag2() {
		return this.aDgMfag2;
	}
	
	/**
	 * Column Info
	 * @return aDgMarPoll
	 */
	public String getADgMarPoll() {
		return this.aDgMarPoll;
	}
	
	/**
	 * Column Info
	 * @return aDgNwgtUnit
	 */
	public String getADgNwgtUnit() {
		return this.aDgNwgtUnit;
	}
	
	/**
	 * Column Info
	 * @return aDgEmsno
	 */
	public String getADgEmsno() {
		return this.aDgEmsno;
	}
	
	/**
	 * Column Info
	 * @return aDgFpnt
	 */
	public String getADgFpnt() {
		return this.aDgFpnt;
	}
	
	/**
	 * Column Info
	 * @return aDgDgRemark
	 */
	public String getADgDgRemark() {
		return this.aDgDgRemark;
	}
	
	/**
	 * Column Info
	 * @return aDgUnbr
	 */
	public String getADgUnbr() {
		return this.aDgUnbr;
	}
	
	/**
	 * Column Info
	 * @return aDgGwgtUnit
	 */
	public String getADgGwgtUnit() {
		return this.aDgGwgtUnit;
	}
	
	/**
	 * Column Info
	 * @return aDgPage
	 */
	public String getADgPage() {
		return this.aDgPage;
	}
	
	/**
	 * Column Info
	 * @return aDgDPkg
	 */
	public String getADgDPkg() {
		return this.aDgDPkg;
	}
	
	/**
	 * Column Info
	 * @return aDgPsacls
	 */
	public String getADgPsacls() {
		return this.aDgPsacls;
	}
	
	/**
	 * Column Info
	 * @return aDgHazCont
	 */
	public String getADgHazCont() {
		return this.aDgHazCont;
	}
	
	/**
	 * Column Info
	 * @return aDgLabelCd
	 */
	public String getADgLabelCd() {
		return this.aDgLabelCd;
	}
	
	/**
	 * Column Info
	 * @return aDgPhon
	 */
	public String getADgPhon() {
		return this.aDgPhon;
	}
	

	/**
	 * Column Info
	 * @param aDgDesc
	 */
	public void setADgDesc(String aDgDesc) {
		this.aDgDesc = aDgDesc;
	}
	
	/**
	 * Column Info
	 * @param aDgLabelDesc
	 */
	public void setADgLabelDesc(String aDgLabelDesc) {
		this.aDgLabelDesc = aDgLabelDesc;
	}
	
	/**
	 * Column Info
	 * @param aDgStwg
	 */
	public void setADgStwg(String aDgStwg) {
		this.aDgStwg = aDgStwg;
	}
	
	/**
	 * Column Info
	 * @param aDgMeaUnit
	 */
	public void setADgMeaUnit(String aDgMeaUnit) {
		this.aDgMeaUnit = aDgMeaUnit;
	}
	
	/**
	 * Column Info
	 * @param aDgGwgt
	 */
	public void setADgGwgt(String aDgGwgt) {
		this.aDgGwgt = aDgGwgt;
	}
	
	/**
	 * Column Info
	 * @param aDgLabel
	 */
	public void setADgLabel(String aDgLabel) {
		this.aDgLabel = aDgLabel;
	}
	
	/**
	 * Column Info
	 * @param aDgPkggrp
	 */
	public void setADgPkggrp(String aDgPkggrp) {
		this.aDgPkggrp = aDgPkggrp;
	}
	
	/**
	 * Column Info
	 * @param aDgFpun
	 */
	public void setADgFpun(String aDgFpun) {
		this.aDgFpun = aDgFpun;
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
	 * @param aDgDPkgunit
	 */
	public void setADgDPkgunit(String aDgDPkgunit) {
		this.aDgDPkgunit = aDgDPkgunit;
	}
	
	/**
	 * Column Info
	 * @param aDgClas
	 */
	public void setADgClas(String aDgClas) {
		this.aDgClas = aDgClas;
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
	 * @param aDgNwgt
	 */
	public void setADgNwgt(String aDgNwgt) {
		this.aDgNwgt = aDgNwgt;
	}
	
	/**
	 * Column Info
	 * @param aDgMea
	 */
	public void setADgMea(String aDgMea) {
		this.aDgMea = aDgMea;
	}
	
	/**
	 * Column Info
	 * @param aDgMfag1
	 */
	public void setADgMfag1(String aDgMfag1) {
		this.aDgMfag1 = aDgMfag1;
	}
	
	/**
	 * Column Info
	 * @param aDgMfag2
	 */
	public void setADgMfag2(String aDgMfag2) {
		this.aDgMfag2 = aDgMfag2;
	}
	
	/**
	 * Column Info
	 * @param aDgMarPoll
	 */
	public void setADgMarPoll(String aDgMarPoll) {
		this.aDgMarPoll = aDgMarPoll;
	}
	
	/**
	 * Column Info
	 * @param aDgNwgtUnit
	 */
	public void setADgNwgtUnit(String aDgNwgtUnit) {
		this.aDgNwgtUnit = aDgNwgtUnit;
	}
	
	/**
	 * Column Info
	 * @param aDgEmsno
	 */
	public void setADgEmsno(String aDgEmsno) {
		this.aDgEmsno = aDgEmsno;
	}
	
	/**
	 * Column Info
	 * @param aDgFpnt
	 */
	public void setADgFpnt(String aDgFpnt) {
		this.aDgFpnt = aDgFpnt;
	}
	
	/**
	 * Column Info
	 * @param aDgDgRemark
	 */
	public void setADgDgRemark(String aDgDgRemark) {
		this.aDgDgRemark = aDgDgRemark;
	}
	
	/**
	 * Column Info
	 * @param aDgUnbr
	 */
	public void setADgUnbr(String aDgUnbr) {
		this.aDgUnbr = aDgUnbr;
	}
	
	/**
	 * Column Info
	 * @param aDgGwgtUnit
	 */
	public void setADgGwgtUnit(String aDgGwgtUnit) {
		this.aDgGwgtUnit = aDgGwgtUnit;
	}
	
	/**
	 * Column Info
	 * @param aDgPage
	 */
	public void setADgPage(String aDgPage) {
		this.aDgPage = aDgPage;
	}
	
	/**
	 * Column Info
	 * @param aDgDPkg
	 */
	public void setADgDPkg(String aDgDPkg) {
		this.aDgDPkg = aDgDPkg;
	}
	
	/**
	 * Column Info
	 * @param aDgPsacls
	 */
	public void setADgPsacls(String aDgPsacls) {
		this.aDgPsacls = aDgPsacls;
	}
	
	/**
	 * Column Info
	 * @param aDgHazCont
	 */
	public void setADgHazCont(String aDgHazCont) {
		this.aDgHazCont = aDgHazCont;
	}
	
	/**
	 * Column Info
	 * @param aDgLabelCd
	 */
	public void setADgLabelCd(String aDgLabelCd) {
		this.aDgLabelCd = aDgLabelCd;
	}
	
	/**
	 * Column Info
	 * @param aDgPhon
	 */
	public void setADgPhon(String aDgPhon) {
		this.aDgPhon = aDgPhon;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setADgDesc(JSPUtil.getParameter(request, "a_dg_desc", ""));
		setADgLabelDesc(JSPUtil.getParameter(request, "a_dg_label_desc", ""));
		setADgStwg(JSPUtil.getParameter(request, "a_dg_stwg", ""));
		setADgMeaUnit(JSPUtil.getParameter(request, "a_dg_mea_unit", ""));
		setADgGwgt(JSPUtil.getParameter(request, "a_dg_gwgt", ""));
		setADgLabel(JSPUtil.getParameter(request, "a_dg_label", ""));
		setADgPkggrp(JSPUtil.getParameter(request, "a_dg_pkggrp", ""));
		setADgFpun(JSPUtil.getParameter(request, "a_dg_fpun", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setADgDPkgunit(JSPUtil.getParameter(request, "a_dg_d_pkgunit", ""));
		setADgClas(JSPUtil.getParameter(request, "a_dg_clas", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setADgNwgt(JSPUtil.getParameter(request, "a_dg_nwgt", ""));
		setADgMea(JSPUtil.getParameter(request, "a_dg_mea", ""));
		setADgMfag1(JSPUtil.getParameter(request, "a_dg_mfag1", ""));
		setADgMfag2(JSPUtil.getParameter(request, "a_dg_mfag2", ""));
		setADgMarPoll(JSPUtil.getParameter(request, "a_dg_mar_poll", ""));
		setADgNwgtUnit(JSPUtil.getParameter(request, "a_dg_nwgt_unit", ""));
		setADgEmsno(JSPUtil.getParameter(request, "a_dg_emsno", ""));
		setADgFpnt(JSPUtil.getParameter(request, "a_dg_fpnt", ""));
		setADgDgRemark(JSPUtil.getParameter(request, "a_dg_dg_remark", ""));
		setADgUnbr(JSPUtil.getParameter(request, "a_dg_unbr", ""));
		setADgGwgtUnit(JSPUtil.getParameter(request, "a_dg_gwgt_unit", ""));
		setADgPage(JSPUtil.getParameter(request, "a_dg_page", ""));
		setADgDPkg(JSPUtil.getParameter(request, "a_dg_d_pkg", ""));
		setADgPsacls(JSPUtil.getParameter(request, "a_dg_psacls", ""));
		setADgHazCont(JSPUtil.getParameter(request, "a_dg_haz_cont", ""));
		setADgLabelCd(JSPUtil.getParameter(request, "a_dg_label_cd", ""));
		setADgPhon(JSPUtil.getParameter(request, "a_dg_phon", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RejectEdiDgVO[]
	 */
	public RejectEdiDgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RejectEdiDgVO[]
	 */
	public RejectEdiDgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RejectEdiDgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aDgDesc = (JSPUtil.getParameter(request, prefix	+ "a_dg_desc", length));
			String[] aDgLabelDesc = (JSPUtil.getParameter(request, prefix	+ "a_dg_label_desc", length));
			String[] aDgStwg = (JSPUtil.getParameter(request, prefix	+ "a_dg_stwg", length));
			String[] aDgMeaUnit = (JSPUtil.getParameter(request, prefix	+ "a_dg_mea_unit", length));
			String[] aDgGwgt = (JSPUtil.getParameter(request, prefix	+ "a_dg_gwgt", length));
			String[] aDgLabel = (JSPUtil.getParameter(request, prefix	+ "a_dg_label", length));
			String[] aDgPkggrp = (JSPUtil.getParameter(request, prefix	+ "a_dg_pkggrp", length));
			String[] aDgFpun = (JSPUtil.getParameter(request, prefix	+ "a_dg_fpun", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] aDgDPkgunit = (JSPUtil.getParameter(request, prefix	+ "a_dg_d_pkgunit", length));
			String[] aDgClas = (JSPUtil.getParameter(request, prefix	+ "a_dg_clas", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aDgNwgt = (JSPUtil.getParameter(request, prefix	+ "a_dg_nwgt", length));
			String[] aDgMea = (JSPUtil.getParameter(request, prefix	+ "a_dg_mea", length));
			String[] aDgMfag1 = (JSPUtil.getParameter(request, prefix	+ "a_dg_mfag1", length));
			String[] aDgMfag2 = (JSPUtil.getParameter(request, prefix	+ "a_dg_mfag2", length));
			String[] aDgMarPoll = (JSPUtil.getParameter(request, prefix	+ "a_dg_mar_poll", length));
			String[] aDgNwgtUnit = (JSPUtil.getParameter(request, prefix	+ "a_dg_nwgt_unit", length));
			String[] aDgEmsno = (JSPUtil.getParameter(request, prefix	+ "a_dg_emsno", length));
			String[] aDgFpnt = (JSPUtil.getParameter(request, prefix	+ "a_dg_fpnt", length));
			String[] aDgDgRemark = (JSPUtil.getParameter(request, prefix	+ "a_dg_dg_remark", length));
			String[] aDgUnbr = (JSPUtil.getParameter(request, prefix	+ "a_dg_unbr", length));
			String[] aDgGwgtUnit = (JSPUtil.getParameter(request, prefix	+ "a_dg_gwgt_unit", length));
			String[] aDgPage = (JSPUtil.getParameter(request, prefix	+ "a_dg_page", length));
			String[] aDgDPkg = (JSPUtil.getParameter(request, prefix	+ "a_dg_d_pkg", length));
			String[] aDgPsacls = (JSPUtil.getParameter(request, prefix	+ "a_dg_psacls", length));
			String[] aDgHazCont = (JSPUtil.getParameter(request, prefix	+ "a_dg_haz_cont", length));
			String[] aDgLabelCd = (JSPUtil.getParameter(request, prefix	+ "a_dg_label_cd", length));
			String[] aDgPhon = (JSPUtil.getParameter(request, prefix	+ "a_dg_phon", length));
			
			for (int i = 0; i < length; i++) {
				model = new RejectEdiDgVO();
				if (aDgDesc[i] != null)
					model.setADgDesc(aDgDesc[i]);
				if (aDgLabelDesc[i] != null)
					model.setADgLabelDesc(aDgLabelDesc[i]);
				if (aDgStwg[i] != null)
					model.setADgStwg(aDgStwg[i]);
				if (aDgMeaUnit[i] != null)
					model.setADgMeaUnit(aDgMeaUnit[i]);
				if (aDgGwgt[i] != null)
					model.setADgGwgt(aDgGwgt[i]);
				if (aDgLabel[i] != null)
					model.setADgLabel(aDgLabel[i]);
				if (aDgPkggrp[i] != null)
					model.setADgPkggrp(aDgPkggrp[i]);
				if (aDgFpun[i] != null)
					model.setADgFpun(aDgFpun[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (aDgDPkgunit[i] != null)
					model.setADgDPkgunit(aDgDPkgunit[i]);
				if (aDgClas[i] != null)
					model.setADgClas(aDgClas[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aDgNwgt[i] != null)
					model.setADgNwgt(aDgNwgt[i]);
				if (aDgMea[i] != null)
					model.setADgMea(aDgMea[i]);
				if (aDgMfag1[i] != null)
					model.setADgMfag1(aDgMfag1[i]);
				if (aDgMfag2[i] != null)
					model.setADgMfag2(aDgMfag2[i]);
				if (aDgMarPoll[i] != null)
					model.setADgMarPoll(aDgMarPoll[i]);
				if (aDgNwgtUnit[i] != null)
					model.setADgNwgtUnit(aDgNwgtUnit[i]);
				if (aDgEmsno[i] != null)
					model.setADgEmsno(aDgEmsno[i]);
				if (aDgFpnt[i] != null)
					model.setADgFpnt(aDgFpnt[i]);
				if (aDgDgRemark[i] != null)
					model.setADgDgRemark(aDgDgRemark[i]);
				if (aDgUnbr[i] != null)
					model.setADgUnbr(aDgUnbr[i]);
				if (aDgGwgtUnit[i] != null)
					model.setADgGwgtUnit(aDgGwgtUnit[i]);
				if (aDgPage[i] != null)
					model.setADgPage(aDgPage[i]);
				if (aDgDPkg[i] != null)
					model.setADgDPkg(aDgDPkg[i]);
				if (aDgPsacls[i] != null)
					model.setADgPsacls(aDgPsacls[i]);
				if (aDgHazCont[i] != null)
					model.setADgHazCont(aDgHazCont[i]);
				if (aDgLabelCd[i] != null)
					model.setADgLabelCd(aDgLabelCd[i]);
				if (aDgPhon[i] != null)
					model.setADgPhon(aDgPhon[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRejectEdiDgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RejectEdiDgVO[]
	 */
	public RejectEdiDgVO[] getRejectEdiDgVOs(){
		RejectEdiDgVO[] vos = (RejectEdiDgVO[])models.toArray(new RejectEdiDgVO[models.size()]);
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
		this.aDgDesc = this.aDgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgLabelDesc = this.aDgLabelDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgStwg = this.aDgStwg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgMeaUnit = this.aDgMeaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgGwgt = this.aDgGwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgLabel = this.aDgLabel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgPkggrp = this.aDgPkggrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgFpun = this.aDgFpun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgDPkgunit = this.aDgDPkgunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgClas = this.aDgClas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgNwgt = this.aDgNwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgMea = this.aDgMea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgMfag1 = this.aDgMfag1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgMfag2 = this.aDgMfag2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgMarPoll = this.aDgMarPoll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgNwgtUnit = this.aDgNwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgEmsno = this.aDgEmsno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgFpnt = this.aDgFpnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgDgRemark = this.aDgDgRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgUnbr = this.aDgUnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgGwgtUnit = this.aDgGwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgPage = this.aDgPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgDPkg = this.aDgDPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgPsacls = this.aDgPsacls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgHazCont = this.aDgHazCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgLabelCd = this.aDgLabelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aDgPhon = this.aDgPhon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
