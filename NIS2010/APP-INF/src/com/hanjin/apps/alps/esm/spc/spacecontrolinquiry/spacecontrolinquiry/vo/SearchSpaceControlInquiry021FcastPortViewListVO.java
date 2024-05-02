/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpaceControlInquiry021FcastPortViewListVO.java
*@FileTitle : SearchSpaceControlInquiry021FcastPortViewListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.12 한상훈 
* 1.0 Creation
*=========================================================
* History
* 2014.06.17 신자영 [CHM-201430603] FCST comparison 메뉴 일부 개선 요청 - Lane, VVD 추가  
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiry021FcastPortViewListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiry021FcastPortViewListVO> models = new ArrayList<SearchSpaceControlInquiry021FcastPortViewListVO>();
	
	/* Column Info */
	private String prefCm = null;
	/* Column Info */
	private String bkgLoad = null;
	/* Column Info */
	private String pfcCm = null;
	/* Column Info */
	private String qtaLoad = null;
	/* Column Info */
	private String fctLoad = null;
	/* Column Info */
	private String fctGrev = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfcGrev = null;
	/* Column Info */
	private String prefLoad = null;
	/* Column Info */
	private String bkgGrpb = null;
	/* Column Info */
	private String diffCm = null;
	/* Column Info */
	private String pfcCmb = null;
	/* Column Info */
	private String fctCm = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String diffLoad = null;
	/* Column Info */
	private String diffCmb = null;
	/* Column Info */
	private String qtaGrpb = null;
	/* Column Info */
	private String diffGrev = null;
	/* Column Info */
	private String prefGrpb = null;
	/* Column Info */
	private String prefCmb = null;
	/* Column Info */
	private String bkgGrev = null;
	/* Column Info */
	private String pfcGrpb = null;
	/* Column Info */
	private String qtaCm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String num = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String diffGrpb = null;
	/* Column Info */
	private String prefGrev = null;
	/* Column Info */
	private String pfcLoad = null;
	/* Column Info */
	private String pfcLoad2 = null;
	/* Column Info */
	private String pfcLoad3 = null;
	/* Column Info */
	private String pfcLoad4 = null;
	/* Column Info */
	private String pfcLoad5 = null;
	/* Column Info */
	private String pfcLoad6 = null;
	/* Column Info */
	private String qtaGrev = null;
	/* Column Info */
	private String lf = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String qtaCmb = null;
	/* Column Info */
	private String bkgCm = null;
	/* Column Info */
	private String fctGrpb = null;
	/* Column Info */
	private String fctCmb = null;
	/* Column Info */
	private String bkgCmb = null;
	
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String rNum = null;
	/* Column Info */
	private String vvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiry021FcastPortViewListVO() {}

	public SearchSpaceControlInquiry021FcastPortViewListVO(String ibflag, String pagerows, String aqCd, String ofcCd, 
			String num, String qtaLoad, String qtaGrev, String qtaGrpb, String qtaCm, String qtaCmb, String fctLoad, 
			String fctGrev, String fctGrpb, String fctCm, String fctCmb, String pfcLoad, String pfcLoad2, String pfcLoad3, 
			String pfcLoad4, String pfcLoad5, String pfcLoad6,String pfcGrev, String pfcGrpb, String pfcCm, String pfcCmb, 
			String diffLoad, String diffGrev, String diffGrpb, String diffCm, String diffCmb, String bkgLoad, String bkgGrev, 
			String bkgGrpb, String bkgCm, String bkgCmb, String prefLoad, String prefGrev, String prefGrpb, String prefCm, 
			String prefCmb, String bsa, String lf, String lvl, String rlaneCd, String rNum, String vvd) {
		this.prefCm = prefCm;
		this.bkgLoad = bkgLoad;
		this.pfcCm = pfcCm;
		this.qtaLoad = qtaLoad;
		this.fctLoad = fctLoad;
		this.fctGrev = fctGrev;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pfcGrev = pfcGrev;
		this.prefLoad = prefLoad;
		this.bkgGrpb = bkgGrpb;
		this.diffCm = diffCm;
		this.pfcCmb = pfcCmb;
		this.fctCm = fctCm;
		this.aqCd = aqCd;
		this.diffLoad = diffLoad;
		this.diffCmb = diffCmb;
		this.qtaGrpb = qtaGrpb;
		this.diffGrev = diffGrev;
		this.prefGrpb = prefGrpb;
		this.prefCmb = prefCmb;
		this.bkgGrev = bkgGrev;
		this.pfcGrpb = pfcGrpb;
		this.qtaCm = qtaCm;
		this.ofcCd = ofcCd;
		this.num = num;
		this.lvl = lvl;
		this.diffGrpb = diffGrpb;
		this.prefGrev = prefGrev;
		this.pfcLoad = pfcLoad;
		this.pfcLoad2 = pfcLoad2;
		this.pfcLoad3 = pfcLoad3;
		this.pfcLoad4 = pfcLoad4;
		this.pfcLoad5 = pfcLoad5;
		this.pfcLoad6 = pfcLoad6;
		this.qtaGrev = qtaGrev;
		this.lf = lf;
		this.bsa = bsa;
		this.qtaCmb = qtaCmb;
		this.bkgCm = bkgCm;
		this.fctGrpb = fctGrpb;
		this.fctCmb = fctCmb;
		this.bkgCmb = bkgCmb;
		
		this.rlaneCd = rlaneCd;
		this.rNum = rNum;
		this.vvd = vvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pref_cm", getPrefCm());
		this.hashColumns.put("bkg_load", getBkgLoad());
		this.hashColumns.put("pfc_cm", getPfcCm());
		this.hashColumns.put("qta_load", getQtaLoad());
		this.hashColumns.put("fct_load", getFctLoad());
		this.hashColumns.put("fct_grev", getFctGrev());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pfc_grev", getPfcGrev());
		this.hashColumns.put("pref_load", getPrefLoad());
		this.hashColumns.put("bkg_grpb", getBkgGrpb());
		this.hashColumns.put("diff_cm", getDiffCm());
		this.hashColumns.put("pfc_cmb", getPfcCmb());
		this.hashColumns.put("fct_cm", getFctCm());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("diff_load", getDiffLoad());
		this.hashColumns.put("diff_cmb", getDiffCmb());
		this.hashColumns.put("qta_grpb", getQtaGrpb());
		this.hashColumns.put("diff_grev", getDiffGrev());
		this.hashColumns.put("pref_grpb", getPrefGrpb());
		this.hashColumns.put("pref_cmb", getPrefCmb());
		this.hashColumns.put("bkg_grev", getBkgGrev());
		this.hashColumns.put("pfc_grpb", getPfcGrpb());
		this.hashColumns.put("qta_cm", getQtaCm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("num", getNum());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("diff_grpb", getDiffGrpb());
		this.hashColumns.put("pref_grev", getPrefGrev());
		this.hashColumns.put("pfc_load", getPfcLoad());
		this.hashColumns.put("pfc_load_2", getPfcLoad2());
		this.hashColumns.put("pfc_load_3", getPfcLoad3());
		this.hashColumns.put("pfc_load_4", getPfcLoad4());
		this.hashColumns.put("pfc_load_5", getPfcLoad5());
		this.hashColumns.put("pfc_load_6", getPfcLoad6());
		this.hashColumns.put("qta_grev", getQtaGrev());
		this.hashColumns.put("lf", getLf());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("qta_cmb", getQtaCmb());
		this.hashColumns.put("bkg_cm", getBkgCm());
		this.hashColumns.put("fct_grpb", getFctGrpb());
		this.hashColumns.put("fct_cmb", getFctCmb());
		this.hashColumns.put("bkg_cmb", getBkgCmb());
		
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("r_num", getRNum());
		this.hashColumns.put("vvd", getVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pref_cm", "prefCm");
		this.hashFields.put("bkg_load", "bkgLoad");
		this.hashFields.put("pfc_cm", "pfcCm");
		this.hashFields.put("qta_load", "qtaLoad");
		this.hashFields.put("fct_load", "fctLoad");
		this.hashFields.put("fct_grev", "fctGrev");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pfc_grev", "pfcGrev");
		this.hashFields.put("pref_load", "prefLoad");
		this.hashFields.put("bkg_grpb", "bkgGrpb");
		this.hashFields.put("diff_cm", "diffCm");
		this.hashFields.put("pfc_cmb", "pfcCmb");
		this.hashFields.put("fct_cm", "fctCm");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("diff_load", "diffLoad");
		this.hashFields.put("diff_cmb", "diffCmb");
		this.hashFields.put("qta_grpb", "qtaGrpb");
		this.hashFields.put("diff_grev", "diffGrev");
		this.hashFields.put("pref_grpb", "prefGrpb");
		this.hashFields.put("pref_cmb", "prefCmb");
		this.hashFields.put("bkg_grev", "bkgGrev");
		this.hashFields.put("pfc_grpb", "pfcGrpb");
		this.hashFields.put("qta_cm", "qtaCm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("num", "num");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("diff_grpb", "diffGrpb");
		this.hashFields.put("pref_grev", "prefGrev");
		this.hashFields.put("pfc_load", "pfcLoad");
		this.hashFields.put("pfc_load_2", "pfcLoad2");
		this.hashFields.put("pfc_load_3", "pfcLoad3");
		this.hashFields.put("pfc_load_4", "pfcLoad4");
		this.hashFields.put("pfc_load_5", "pfcLoad5");
		this.hashFields.put("pfc_load_6", "pfcLoad6");
		this.hashFields.put("qta_grev", "qtaGrev");
		this.hashFields.put("lf", "lf");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("qta_cmb", "qtaCmb");
		this.hashFields.put("bkg_cm", "bkgCm");
		this.hashFields.put("fct_grpb", "fctGrpb");
		this.hashFields.put("fct_cmb", "fctCmb");
		this.hashFields.put("bkg_cmb", "bkgCmb");
		
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("r_num", "rNum");
		this.hashFields.put("vvd", "vvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prefCm
	 */
	public String getPrefCm() {
		return this.prefCm;
	}
	
	/**
	 * Column Info
	 * @return bkgLoad
	 */
	public String getBkgLoad() {
		return this.bkgLoad;
	}
	
	/**
	 * Column Info
	 * @return pfcCm
	 */
	public String getPfcCm() {
		return this.pfcCm;
	}
	
	/**
	 * Column Info
	 * @return qtaLoad
	 */
	public String getQtaLoad() {
		return this.qtaLoad;
	}
	
	/**
	 * Column Info
	 * @return fctLoad
	 */
	public String getFctLoad() {
		return this.fctLoad;
	}
	
	/**
	 * Column Info
	 * @return fctGrev
	 */
	public String getFctGrev() {
		return this.fctGrev;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return pfcGrev
	 */
	public String getPfcGrev() {
		return this.pfcGrev;
	}
	
	/**
	 * Column Info
	 * @return prefLoad
	 */
	public String getPrefLoad() {
		return this.prefLoad;
	}
	
	/**
	 * Column Info
	 * @return bkgGrpb
	 */
	public String getBkgGrpb() {
		return this.bkgGrpb;
	}
	
	/**
	 * Column Info
	 * @return diffCm
	 */
	public String getDiffCm() {
		return this.diffCm;
	}
	
	/**
	 * Column Info
	 * @return pfcCmb
	 */
	public String getPfcCmb() {
		return this.pfcCmb;
	}
	
	/**
	 * Column Info
	 * @return fctCm
	 */
	public String getFctCm() {
		return this.fctCm;
	}
	
	/**
	 * Column Info
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
	}
	
	/**
	 * Column Info
	 * @return diffLoad
	 */
	public String getDiffLoad() {
		return this.diffLoad;
	}
	
	/**
	 * Column Info
	 * @return diffCmb
	 */
	public String getDiffCmb() {
		return this.diffCmb;
	}
	
	/**
	 * Column Info
	 * @return qtaGrpb
	 */
	public String getQtaGrpb() {
		return this.qtaGrpb;
	}
	
	/**
	 * Column Info
	 * @return diffGrev
	 */
	public String getDiffGrev() {
		return this.diffGrev;
	}
	
	/**
	 * Column Info
	 * @return prefGrpb
	 */
	public String getPrefGrpb() {
		return this.prefGrpb;
	}
	
	/**
	 * Column Info
	 * @return prefCmb
	 */
	public String getPrefCmb() {
		return this.prefCmb;
	}
	
	/**
	 * Column Info
	 * @return bkgGrev
	 */
	public String getBkgGrev() {
		return this.bkgGrev;
	}
	
	/**
	 * Column Info
	 * @return pfcGrpb
	 */
	public String getPfcGrpb() {
		return this.pfcGrpb;
	}
	
	/**
	 * Column Info
	 * @return qtaCm
	 */
	public String getQtaCm() {
		return this.qtaCm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return num
	 */
	public String getNum() {
		return this.num;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return diffGrpb
	 */
	public String getDiffGrpb() {
		return this.diffGrpb;
	}
	
	/**
	 * Column Info
	 * @return prefGrev
	 */
	public String getPrefGrev() {
		return this.prefGrev;
	}
	
	/**
	 * Column Info
	 * @return pfcLoad
	 */
	public String getPfcLoad() {
		return this.pfcLoad;
	}
	
	/**
	 * Column Info
	 * @return pfcLoad2
	 */
	public String getPfcLoad2() {
		return this.pfcLoad2;
	}
	
	/**
	 * Column Info
	 * @return pfcLoad3
	 */
	public String getPfcLoad3() {
		return this.pfcLoad3;
	} 
	
	/**
	 * Column Info
	 * @return pfcLoad4
	 */
	public String getPfcLoad4() {
		return this.pfcLoad4;
	}
	
	/**
	 * Column Info
	 * @return pfcLoad5
	 */
	public String getPfcLoad5() {
		return this.pfcLoad5;
	}
	
	/**
	 * Column Info
	 * @return pfcLoad6
	 */
	public String getPfcLoad6() {
		return this.pfcLoad6;
	}
	
	/**
	 * Column Info
	 * @return qtaGrev
	 */
	public String getQtaGrev() {
		return this.qtaGrev;
	}
	
	/**
	 * Column Info
	 * @return lf
	 */
	public String getLf() {
		return this.lf;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return qtaCmb
	 */
	public String getQtaCmb() {
		return this.qtaCmb;
	}
	
	/**
	 * Column Info
	 * @return bkgCm
	 */
	public String getBkgCm() {
		return this.bkgCm;
	}
	
	/**
	 * Column Info
	 * @return fctGrpb
	 */
	public String getFctGrpb() {
		return this.fctGrpb;
	}
	
	/**
	 * Column Info
	 * @return fctCmb
	 */
	public String getFctCmb() {
		return this.fctCmb;
	}
	
	/**
	 * Column Info
	 * @return bkgCmb
	 */
	public String getBkgCmb() {
		return this.bkgCmb;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return rNum
	 */
	public String getRNum() {
		return this.rNum;
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
	 * @param prefCm
	 */
	public void setPrefCm(String prefCm) {
		this.prefCm = prefCm;
	}
	
	/**
	 * Column Info
	 * @param bkgLoad
	 */
	public void setBkgLoad(String bkgLoad) {
		this.bkgLoad = bkgLoad;
	}
	
	/**
	 * Column Info
	 * @param pfcCm
	 */
	public void setPfcCm(String pfcCm) {
		this.pfcCm = pfcCm;
	}
	
	/**
	 * Column Info
	 * @param qtaLoad
	 */
	public void setQtaLoad(String qtaLoad) {
		this.qtaLoad = qtaLoad;
	}
	
	/**
	 * Column Info
	 * @param fctLoad
	 */
	public void setFctLoad(String fctLoad) {
		this.fctLoad = fctLoad;
	}
	
	/**
	 * Column Info
	 * @param fctGrev
	 */
	public void setFctGrev(String fctGrev) {
		this.fctGrev = fctGrev;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param pfcGrev
	 */
	public void setPfcGrev(String pfcGrev) {
		this.pfcGrev = pfcGrev;
	}
	
	/**
	 * Column Info
	 * @param prefLoad
	 */
	public void setPrefLoad(String prefLoad) {
		this.prefLoad = prefLoad;
	}
	
	/**
	 * Column Info
	 * @param bkgGrpb
	 */
	public void setBkgGrpb(String bkgGrpb) {
		this.bkgGrpb = bkgGrpb;
	}
	
	/**
	 * Column Info
	 * @param diffCm
	 */
	public void setDiffCm(String diffCm) {
		this.diffCm = diffCm;
	}
	
	/**
	 * Column Info
	 * @param pfcCmb
	 */
	public void setPfcCmb(String pfcCmb) {
		this.pfcCmb = pfcCmb;
	}
	
	/**
	 * Column Info
	 * @param fctCm
	 */
	public void setFctCm(String fctCm) {
		this.fctCm = fctCm;
	}
	
	/**
	 * Column Info
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}
	
	/**
	 * Column Info
	 * @param diffLoad
	 */
	public void setDiffLoad(String diffLoad) {
		this.diffLoad = diffLoad;
	}
	
	/**
	 * Column Info
	 * @param diffCmb
	 */
	public void setDiffCmb(String diffCmb) {
		this.diffCmb = diffCmb;
	}
	
	/**
	 * Column Info
	 * @param qtaGrpb
	 */
	public void setQtaGrpb(String qtaGrpb) {
		this.qtaGrpb = qtaGrpb;
	}
	
	/**
	 * Column Info
	 * @param diffGrev
	 */
	public void setDiffGrev(String diffGrev) {
		this.diffGrev = diffGrev;
	}
	
	/**
	 * Column Info
	 * @param prefGrpb
	 */
	public void setPrefGrpb(String prefGrpb) {
		this.prefGrpb = prefGrpb;
	}
	
	/**
	 * Column Info
	 * @param prefCmb
	 */
	public void setPrefCmb(String prefCmb) {
		this.prefCmb = prefCmb;
	}
	
	/**
	 * Column Info
	 * @param bkgGrev
	 */
	public void setBkgGrev(String bkgGrev) {
		this.bkgGrev = bkgGrev;
	}
	
	/**
	 * Column Info
	 * @param pfcGrpb
	 */
	public void setPfcGrpb(String pfcGrpb) {
		this.pfcGrpb = pfcGrpb;
	}
	
	/**
	 * Column Info
	 * @param qtaCm
	 */
	public void setQtaCm(String qtaCm) {
		this.qtaCm = qtaCm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param diffGrpb
	 */
	public void setDiffGrpb(String diffGrpb) {
		this.diffGrpb = diffGrpb;
	}
	
	/**
	 * Column Info
	 * @param prefGrev
	 */
	public void setPrefGrev(String prefGrev) {
		this.prefGrev = prefGrev;
	}
	
	/**
	 * Column Info
	 * @param pfcLoad
	 */
	public void setPfcLoad(String pfcLoad) {
		this.pfcLoad = pfcLoad;
	}
	
	/**
	 * Column Info
	 * @param pfcLoad2
	 */
	public void setPfcLoad2(String pfcLoad2) {
		this.pfcLoad2 = pfcLoad2;
	}
	
	/**
	 * Column Info
	 * @param pfcLoad3
	 */
	public void setPfcLoad3(String pfcLoad3) {
		this.pfcLoad3 = pfcLoad3;
	}
	
	/**
	 * Column Info
	 * @param pfcLoad4
	 */
	public void setPfcLoad4(String pfcLoad4) {
		this.pfcLoad4 = pfcLoad4;
	}
	
	/**
	 * Column Info
	 * @param pfcLoad5
	 */
	public void setPfcLoad5(String pfcLoad5) {
		this.pfcLoad5 = pfcLoad5;
	}
	
	/**
	 * Column Info
	 * @param pfcLoad6
	 */
	public void setPfcLoad6(String pfcLoad6) {
		this.pfcLoad6 = pfcLoad6;
	}
	
	/**
	 * Column Info
	 * @param qtaGrev
	 */
	public void setQtaGrev(String qtaGrev) {
		this.qtaGrev = qtaGrev;
	}
	
	/**
	 * Column Info
	 * @param lf
	 */
	public void setLf(String lf) {
		this.lf = lf;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param qtaCmb
	 */
	public void setQtaCmb(String qtaCmb) {
		this.qtaCmb = qtaCmb;
	}
	
	/**
	 * Column Info
	 * @param bkgCm
	 */
	public void setBkgCm(String bkgCm) {
		this.bkgCm = bkgCm;
	}
	
	/**
	 * Column Info
	 * @param fctGrpb
	 */
	public void setFctGrpb(String fctGrpb) {
		this.fctGrpb = fctGrpb;
	}
	
	/**
	 * Column Info
	 * @param fctCmb
	 */
	public void setFctCmb(String fctCmb) {
		this.fctCmb = fctCmb;
	}
	
	/**
	 * Column Info
	 * @param bkgCmb
	 */
	public void setBkgCmb(String bkgCmb) {
		this.bkgCmb = bkgCmb;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param rNum
	 */
	public void setRNum(String rNum) {
		this.rNum = rNum;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPrefCm(JSPUtil.getParameter(request, "pref_cm", ""));
		setBkgLoad(JSPUtil.getParameter(request, "bkg_load", ""));
		setPfcCm(JSPUtil.getParameter(request, "pfc_cm", ""));
		setQtaLoad(JSPUtil.getParameter(request, "qta_load", ""));
		setFctLoad(JSPUtil.getParameter(request, "fct_load", ""));
		setFctGrev(JSPUtil.getParameter(request, "fct_grev", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPfcGrev(JSPUtil.getParameter(request, "pfc_grev", ""));
		setPrefLoad(JSPUtil.getParameter(request, "pref_load", ""));
		setBkgGrpb(JSPUtil.getParameter(request, "bkg_grpb", ""));
		setDiffCm(JSPUtil.getParameter(request, "diff_cm", ""));
		setPfcCmb(JSPUtil.getParameter(request, "pfc_cmb", ""));
		setFctCm(JSPUtil.getParameter(request, "fct_cm", ""));
		setAqCd(JSPUtil.getParameter(request, "aq_cd", ""));
		setDiffLoad(JSPUtil.getParameter(request, "diff_load", ""));
		setDiffCmb(JSPUtil.getParameter(request, "diff_cmb", ""));
		setQtaGrpb(JSPUtil.getParameter(request, "qta_grpb", ""));
		setDiffGrev(JSPUtil.getParameter(request, "diff_grev", ""));
		setPrefGrpb(JSPUtil.getParameter(request, "pref_grpb", ""));
		setPrefCmb(JSPUtil.getParameter(request, "pref_cmb", ""));
		setBkgGrev(JSPUtil.getParameter(request, "bkg_grev", ""));
		setPfcGrpb(JSPUtil.getParameter(request, "pfc_grpb", ""));
		setQtaCm(JSPUtil.getParameter(request, "qta_cm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setNum(JSPUtil.getParameter(request, "num", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
		setDiffGrpb(JSPUtil.getParameter(request, "diff_grpb", ""));
		setPrefGrev(JSPUtil.getParameter(request, "pref_grev", ""));
		setPfcLoad(JSPUtil.getParameter(request, "pfc_load", ""));
		setPfcLoad2(JSPUtil.getParameter(request, "pfc_load_2", ""));
		setPfcLoad3(JSPUtil.getParameter(request, "pfc_load_3", ""));
		setPfcLoad4(JSPUtil.getParameter(request, "pfc_load_4", ""));
		setPfcLoad5(JSPUtil.getParameter(request, "pfc_load_5", ""));
		setPfcLoad6(JSPUtil.getParameter(request, "pfc_load_6", ""));
		setQtaGrev(JSPUtil.getParameter(request, "qta_grev", ""));
		setLf(JSPUtil.getParameter(request, "lf", ""));
		setBsa(JSPUtil.getParameter(request, "bsa", ""));
		setQtaCmb(JSPUtil.getParameter(request, "qta_cmb", ""));
		setBkgCm(JSPUtil.getParameter(request, "bkg_cm", ""));
		setFctGrpb(JSPUtil.getParameter(request, "fct_grpb", ""));
		setFctCmb(JSPUtil.getParameter(request, "fct_cmb", ""));
		setBkgCmb(JSPUtil.getParameter(request, "bkg_cmb", ""));
		
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRNum(JSPUtil.getParameter(request, "r_num", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiry021FcastPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021FcastPortViewListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchSpaceControlInquiry021FcastPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021FcastPortViewListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiry021FcastPortViewListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prefCm = (JSPUtil.getParameter(request, prefix	+ "pref_cm", length));
			String[] bkgLoad = (JSPUtil.getParameter(request, prefix	+ "bkg_load", length));
			String[] pfcCm = (JSPUtil.getParameter(request, prefix	+ "pfc_cm", length));
			String[] qtaLoad = (JSPUtil.getParameter(request, prefix	+ "qta_load", length));
			String[] fctLoad = (JSPUtil.getParameter(request, prefix	+ "fct_load", length));
			String[] fctGrev = (JSPUtil.getParameter(request, prefix	+ "fct_grev", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfcGrev = (JSPUtil.getParameter(request, prefix	+ "pfc_grev", length));
			String[] prefLoad = (JSPUtil.getParameter(request, prefix	+ "pref_load", length));
			String[] bkgGrpb = (JSPUtil.getParameter(request, prefix	+ "bkg_grpb", length));
			String[] diffCm = (JSPUtil.getParameter(request, prefix	+ "diff_cm", length));
			String[] pfcCmb = (JSPUtil.getParameter(request, prefix	+ "pfc_cmb", length));
			String[] fctCm = (JSPUtil.getParameter(request, prefix	+ "fct_cm", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] diffLoad = (JSPUtil.getParameter(request, prefix	+ "diff_load", length));
			String[] diffCmb = (JSPUtil.getParameter(request, prefix	+ "diff_cmb", length));
			String[] qtaGrpb = (JSPUtil.getParameter(request, prefix	+ "qta_grpb", length));
			String[] diffGrev = (JSPUtil.getParameter(request, prefix	+ "diff_grev", length));
			String[] prefGrpb = (JSPUtil.getParameter(request, prefix	+ "pref_grpb", length));
			String[] prefCmb = (JSPUtil.getParameter(request, prefix	+ "pref_cmb", length));
			String[] bkgGrev = (JSPUtil.getParameter(request, prefix	+ "bkg_grev", length));
			String[] pfcGrpb = (JSPUtil.getParameter(request, prefix	+ "pfc_grpb", length));
			String[] qtaCm = (JSPUtil.getParameter(request, prefix	+ "qta_cm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] num = (JSPUtil.getParameter(request, prefix	+ "num", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] diffGrpb = (JSPUtil.getParameter(request, prefix	+ "diff_grpb", length));
			String[] prefGrev = (JSPUtil.getParameter(request, prefix	+ "pref_grev", length));
			String[] pfcLoad = (JSPUtil.getParameter(request, prefix	+ "pfc_load", length));
			String[] pfcLoad2 = (JSPUtil.getParameter(request, prefix	+ "pfc_load_2", length));
			String[] pfcLoad3 = (JSPUtil.getParameter(request, prefix	+ "pfc_load_3", length));
			String[] pfcLoad4 = (JSPUtil.getParameter(request, prefix	+ "pfc_load_4", length));
			String[] pfcLoad5 = (JSPUtil.getParameter(request, prefix	+ "pfc_load_5", length));
			String[] pfcLoad6 = (JSPUtil.getParameter(request, prefix	+ "pfc_load_6", length));
			String[] qtaGrev = (JSPUtil.getParameter(request, prefix	+ "qta_grev", length));
			String[] lf = (JSPUtil.getParameter(request, prefix	+ "lf", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] qtaCmb = (JSPUtil.getParameter(request, prefix	+ "qta_cmb", length));
			String[] bkgCm = (JSPUtil.getParameter(request, prefix	+ "bkg_cm", length));
			String[] fctGrpb = (JSPUtil.getParameter(request, prefix	+ "fct_grpb", length));
			String[] fctCmb = (JSPUtil.getParameter(request, prefix	+ "fct_cmb", length));
			String[] bkgCmb = (JSPUtil.getParameter(request, prefix	+ "bkg_cmb", length));
			
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] rNum = (JSPUtil.getParameter(request, prefix	+ "r_num", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiry021FcastPortViewListVO();
				if (prefCm[i] != null)
					model.setPrefCm(prefCm[i]);
				if (bkgLoad[i] != null)
					model.setBkgLoad(bkgLoad[i]);
				if (pfcCm[i] != null)
					model.setPfcCm(pfcCm[i]);
				if (qtaLoad[i] != null)
					model.setQtaLoad(qtaLoad[i]);
				if (fctLoad[i] != null)
					model.setFctLoad(fctLoad[i]);
				if (fctGrev[i] != null)
					model.setFctGrev(fctGrev[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfcGrev[i] != null)
					model.setPfcGrev(pfcGrev[i]);
				if (prefLoad[i] != null)
					model.setPrefLoad(prefLoad[i]);
				if (bkgGrpb[i] != null)
					model.setBkgGrpb(bkgGrpb[i]);
				if (diffCm[i] != null)
					model.setDiffCm(diffCm[i]);
				if (pfcCmb[i] != null)
					model.setPfcCmb(pfcCmb[i]);
				if (fctCm[i] != null)
					model.setFctCm(fctCm[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (diffLoad[i] != null)
					model.setDiffLoad(diffLoad[i]);
				if (diffCmb[i] != null)
					model.setDiffCmb(diffCmb[i]);
				if (qtaGrpb[i] != null)
					model.setQtaGrpb(qtaGrpb[i]);
				if (diffGrev[i] != null)
					model.setDiffGrev(diffGrev[i]);
				if (prefGrpb[i] != null)
					model.setPrefGrpb(prefGrpb[i]);
				if (prefCmb[i] != null)
					model.setPrefCmb(prefCmb[i]);
				if (bkgGrev[i] != null)
					model.setBkgGrev(bkgGrev[i]);
				if (pfcGrpb[i] != null)
					model.setPfcGrpb(pfcGrpb[i]);
				if (qtaCm[i] != null)
					model.setQtaCm(qtaCm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (num[i] != null)
					model.setNum(num[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (diffGrpb[i] != null)
					model.setDiffGrpb(diffGrpb[i]);
				if (prefGrev[i] != null)
					model.setPrefGrev(prefGrev[i]);
				if (pfcLoad[i] != null)
					model.setPfcLoad(pfcLoad[i]);
				if (pfcLoad2[i] != null)
					model.setPfcLoad2(pfcLoad2[i]);
				if (pfcLoad3[i] != null)
					model.setPfcLoad3(pfcLoad3[i]);
				if (pfcLoad4[i] != null)
					model.setPfcLoad4(pfcLoad4[i]);
				if (pfcLoad5[i] != null)
					model.setPfcLoad5(pfcLoad5[i]);
				if (pfcLoad6[i] != null)
					model.setPfcLoad6(pfcLoad6[i]);
				if (qtaGrev[i] != null)
					model.setQtaGrev(qtaGrev[i]);
				if (lf[i] != null)
					model.setLf(lf[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (qtaCmb[i] != null)
					model.setQtaCmb(qtaCmb[i]);
				if (bkgCm[i] != null)
					model.setBkgCm(bkgCm[i]);
				if (fctGrpb[i] != null)
					model.setFctGrpb(fctGrpb[i]);
				if (fctCmb[i] != null)
					model.setFctCmb(fctCmb[i]);
				if (bkgCmb[i] != null)
					model.setBkgCmb(bkgCmb[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (rNum[i] != null)
					model.setRNum(rNum[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchSpaceControlInquiry021FcastPortViewListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiry021FcastPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021FcastPortViewListVO[] getsearchSpaceControlInquiry021FcastPortViewListVOs(){
		SearchSpaceControlInquiry021FcastPortViewListVO[] vos = (SearchSpaceControlInquiry021FcastPortViewListVO[])models.toArray(new SearchSpaceControlInquiry021FcastPortViewListVO[models.size()]);
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
		this.prefCm = this.prefCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLoad = this.bkgLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcCm = this.pfcCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaLoad = this.qtaLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctLoad = this.fctLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctGrev = this.fctGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcGrev = this.pfcGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefLoad = this.prefLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgGrpb = this.bkgGrpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffCm = this.diffCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcCmb = this.pfcCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctCm = this.fctCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffLoad = this.diffLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffCmb = this.diffCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaGrpb = this.qtaGrpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffGrev = this.diffGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefGrpb = this.prefGrpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefCmb = this.prefCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgGrev = this.bkgGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcGrpb = this.pfcGrpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaCm = this.qtaCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.num = this.num .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffGrpb = this.diffGrpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefGrev = this.prefGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcLoad = this.pfcLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcLoad2 = this.pfcLoad2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcLoad3 = this.pfcLoad3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcLoad4 = this.pfcLoad4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcLoad5 = this.pfcLoad5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfcLoad6 = this.pfcLoad6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaGrev = this.qtaGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lf = this.lf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaCmb = this.qtaCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCm = this.bkgCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctGrpb = this.fctGrpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctCmb = this.fctCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCmb = this.bkgCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rNum = this.rNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
