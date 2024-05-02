/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DetailYearlyExpenseVO.java
*@FileTitle : DetailYearlyExpenseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.07.02 최정미 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DetailYearlyExpenseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DetailYearlyExpenseVO> models = new ArrayList<DetailYearlyExpenseVO>();
	
	/* Column Info */
	private String lvl2Code = null;
	/* Column Info */
	private String genExpnItmDesc = null;
	/* Column Info */
	private String lvl2Name = null;
	/* Column Info */
	private String intTtl = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dec = null;
	/* Column Info */
	private String ofcCoDivCd = null;
	/* Column Info */
	private String jan = null;
	/* Column Info */
	private String mar = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String genExpnItmNo = null;
	/* Column Info */
	private String lvl1Name = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String trnTtl = null;
	/* Column Info */
	private String may = null;
	/* Column Info */
	private String apr = null;
	/* Column Info */
	private String salyFlg = null;
	/* Column Info */
	private String lvl1Code = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String jul = null;
	/* Column Info */
	private String jun = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String addTtl = null;
	/* Column Info */
	private String lvl4Tic = null;
	/* Column Info */
	private String calBasis = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String lvl4Name = null;
	/* Column Info */
	private String lvl4Code = null;
	/* Column Info */
	private String grdTtl = null;
	/* Column Info */
	private String oct = null;
	/* Column Info */
	private String feb = null;
	/* Column Info */
	private String nov = null;
	/* Column Info */
	private String aproOpinRmk = null;
	/* Column Info */
	private String sep = null;
	/* Column Info */
	private String aug = null;
	/* Column Info */
	private String genExpnRqstTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DetailYearlyExpenseVO() {}

	public DetailYearlyExpenseVO(String ibflag, String pagerows, String plnYrmon, String genExpnRqstTpCd, String lvl1Code, String lvl1Name, String lvl2Code, String lvl2Name, String lvl4Code, String lvl4Name, String genExpnCd, String genExpnItmNo, String genExpnItmDesc, String lvl4Tic, String ofcCd, String rhq, String loclCurrCd, String rqstUtVal, String salyFlg, String ofcCoDivCd, String jan, String feb, String mar, String apr, String may, String jun, String jul, String aug, String sep, String oct, String nov, String dec, String intTtl, String addTtl, String trnTtl, String grdTtl, String calBasis, String aproOpinRmk) {
		this.lvl2Code = lvl2Code;
		this.genExpnItmDesc = genExpnItmDesc;
		this.lvl2Name = lvl2Name;
		this.intTtl = intTtl;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dec = dec;
		this.ofcCoDivCd = ofcCoDivCd;
		this.jan = jan;
		this.mar = mar;
		this.rqstUtVal = rqstUtVal;
		this.rhq = rhq;
		this.genExpnItmNo = genExpnItmNo;
		this.lvl1Name = lvl1Name;
		this.plnYrmon = plnYrmon;
		this.trnTtl = trnTtl;
		this.may = may;
		this.apr = apr;
		this.salyFlg = salyFlg;
		this.lvl1Code = lvl1Code;
		this.loclCurrCd = loclCurrCd;
		this.jul = jul;
		this.jun = jun;
		this.genExpnCd = genExpnCd;
		this.addTtl = addTtl;
		this.lvl4Tic = lvl4Tic;
		this.calBasis = calBasis;
		this.ofcCd = ofcCd;
		this.lvl4Name = lvl4Name;
		this.lvl4Code = lvl4Code;
		this.grdTtl = grdTtl;
		this.oct = oct;
		this.feb = feb;
		this.nov = nov;
		this.aproOpinRmk = aproOpinRmk;
		this.sep = sep;
		this.aug = aug;
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lvl2_code", getLvl2Code());
		this.hashColumns.put("gen_expn_itm_desc", getGenExpnItmDesc());
		this.hashColumns.put("lvl2_name", getLvl2Name());
		this.hashColumns.put("int_ttl", getIntTtl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dec", getDec());
		this.hashColumns.put("ofc_co_div_cd", getOfcCoDivCd());
		this.hashColumns.put("jan", getJan());
		this.hashColumns.put("mar", getMar());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("gen_expn_itm_no", getGenExpnItmNo());
		this.hashColumns.put("lvl1_name", getLvl1Name());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("trn_ttl", getTrnTtl());
		this.hashColumns.put("may", getMay());
		this.hashColumns.put("apr", getApr());
		this.hashColumns.put("saly_flg", getSalyFlg());
		this.hashColumns.put("lvl1_code", getLvl1Code());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("jul", getJul());
		this.hashColumns.put("jun", getJun());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("add_ttl", getAddTtl());
		this.hashColumns.put("lvl4_tic", getLvl4Tic());
		this.hashColumns.put("cal_basis", getCalBasis());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("lvl4_name", getLvl4Name());
		this.hashColumns.put("lvl4_code", getLvl4Code());
		this.hashColumns.put("grd_ttl", getGrdTtl());
		this.hashColumns.put("oct", getOct());
		this.hashColumns.put("feb", getFeb());
		this.hashColumns.put("nov", getNov());
		this.hashColumns.put("apro_opin_rmk", getAproOpinRmk());
		this.hashColumns.put("sep", getSep());
		this.hashColumns.put("aug", getAug());
		this.hashColumns.put("gen_expn_rqst_tp_cd", getGenExpnRqstTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lvl2_code", "lvl2Code");
		this.hashFields.put("gen_expn_itm_desc", "genExpnItmDesc");
		this.hashFields.put("lvl2_name", "lvl2Name");
		this.hashFields.put("int_ttl", "intTtl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dec", "dec");
		this.hashFields.put("ofc_co_div_cd", "ofcCoDivCd");
		this.hashFields.put("jan", "jan");
		this.hashFields.put("mar", "mar");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("gen_expn_itm_no", "genExpnItmNo");
		this.hashFields.put("lvl1_name", "lvl1Name");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("trn_ttl", "trnTtl");
		this.hashFields.put("may", "may");
		this.hashFields.put("apr", "apr");
		this.hashFields.put("saly_flg", "salyFlg");
		this.hashFields.put("lvl1_code", "lvl1Code");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("jul", "jul");
		this.hashFields.put("jun", "jun");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("add_ttl", "addTtl");
		this.hashFields.put("lvl4_tic", "lvl4Tic");
		this.hashFields.put("cal_basis", "calBasis");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("lvl4_name", "lvl4Name");
		this.hashFields.put("lvl4_code", "lvl4Code");
		this.hashFields.put("grd_ttl", "grdTtl");
		this.hashFields.put("oct", "oct");
		this.hashFields.put("feb", "feb");
		this.hashFields.put("nov", "nov");
		this.hashFields.put("apro_opin_rmk", "aproOpinRmk");
		this.hashFields.put("sep", "sep");
		this.hashFields.put("aug", "aug");
		this.hashFields.put("gen_expn_rqst_tp_cd", "genExpnRqstTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lvl2Code
	 */
	public String getLvl2Code() {
		return this.lvl2Code;
	}
	
	/**
	 * Column Info
	 * @return genExpnItmDesc
	 */
	public String getGenExpnItmDesc() {
		return this.genExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @return lvl2Name
	 */
	public String getLvl2Name() {
		return this.lvl2Name;
	}
	
	/**
	 * Column Info
	 * @return intTtl
	 */
	public String getIntTtl() {
		return this.intTtl;
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
	 * @return dec
	 */
	public String getDec() {
		return this.dec;
	}
	
	/**
	 * Column Info
	 * @return ofcCoDivCd
	 */
	public String getOfcCoDivCd() {
		return this.ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @return jan
	 */
	public String getJan() {
		return this.jan;
	}
	
	/**
	 * Column Info
	 * @return mar
	 */
	public String getMar() {
		return this.mar;
	}
	
	/**
	 * Column Info
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return genExpnItmNo
	 */
	public String getGenExpnItmNo() {
		return this.genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return lvl1Name
	 */
	public String getLvl1Name() {
		return this.lvl1Name;
	}
	
	/**
	 * Column Info
	 * @return plnYrmon
	 */
	public String getPlnYrmon() {
		return this.plnYrmon;
	}
	
	/**
	 * Column Info
	 * @return trnTtl
	 */
	public String getTrnTtl() {
		return this.trnTtl;
	}
	
	/**
	 * Column Info
	 * @return may
	 */
	public String getMay() {
		return this.may;
	}
	
	/**
	 * Column Info
	 * @return apr
	 */
	public String getApr() {
		return this.apr;
	}
	
	/**
	 * Column Info
	 * @return salyFlg
	 */
	public String getSalyFlg() {
		return this.salyFlg;
	}
	
	/**
	 * Column Info
	 * @return lvl1Code
	 */
	public String getLvl1Code() {
		return this.lvl1Code;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return jul
	 */
	public String getJul() {
		return this.jul;
	}
	
	/**
	 * Column Info
	 * @return jun
	 */
	public String getJun() {
		return this.jun;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return addTtl
	 */
	public String getAddTtl() {
		return this.addTtl;
	}
	
	/**
	 * Column Info
	 * @return lvl4Tic
	 */
	public String getLvl4Tic() {
		return this.lvl4Tic;
	}
	
	/**
	 * Column Info
	 * @return calBasis
	 */
	public String getCalBasis() {
		return this.calBasis;
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
	 * @return lvl4Name
	 */
	public String getLvl4Name() {
		return this.lvl4Name;
	}
	
	/**
	 * Column Info
	 * @return lvl4Code
	 */
	public String getLvl4Code() {
		return this.lvl4Code;
	}
	
	/**
	 * Column Info
	 * @return grdTtl
	 */
	public String getGrdTtl() {
		return this.grdTtl;
	}
	
	/**
	 * Column Info
	 * @return oct
	 */
	public String getOct() {
		return this.oct;
	}
	
	/**
	 * Column Info
	 * @return feb
	 */
	public String getFeb() {
		return this.feb;
	}
	
	/**
	 * Column Info
	 * @return nov
	 */
	public String getNov() {
		return this.nov;
	}
	
	/**
	 * Column Info
	 * @return aproOpinRmk
	 */
	public String getAproOpinRmk() {
		return this.aproOpinRmk;
	}
	
	/**
	 * Column Info
	 * @return sep
	 */
	public String getSep() {
		return this.sep;
	}
	
	/**
	 * Column Info
	 * @return aug
	 */
	public String getAug() {
		return this.aug;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstTpCd
	 */
	public String getGenExpnRqstTpCd() {
		return this.genExpnRqstTpCd;
	}
	

	/**
	 * Column Info
	 * @param lvl2Code
	 */
	public void setLvl2Code(String lvl2Code) {
		this.lvl2Code = lvl2Code;
	}
	
	/**
	 * Column Info
	 * @param genExpnItmDesc
	 */
	public void setGenExpnItmDesc(String genExpnItmDesc) {
		this.genExpnItmDesc = genExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @param lvl2Name
	 */
	public void setLvl2Name(String lvl2Name) {
		this.lvl2Name = lvl2Name;
	}
	
	/**
	 * Column Info
	 * @param intTtl
	 */
	public void setIntTtl(String intTtl) {
		this.intTtl = intTtl;
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
	 * @param dec
	 */
	public void setDec(String dec) {
		this.dec = dec;
	}
	
	/**
	 * Column Info
	 * @param ofcCoDivCd
	 */
	public void setOfcCoDivCd(String ofcCoDivCd) {
		this.ofcCoDivCd = ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @param jan
	 */
	public void setJan(String jan) {
		this.jan = jan;
	}
	
	/**
	 * Column Info
	 * @param mar
	 */
	public void setMar(String mar) {
		this.mar = mar;
	}
	
	/**
	 * Column Info
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param genExpnItmNo
	 */
	public void setGenExpnItmNo(String genExpnItmNo) {
		this.genExpnItmNo = genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param lvl1Name
	 */
	public void setLvl1Name(String lvl1Name) {
		this.lvl1Name = lvl1Name;
	}
	
	/**
	 * Column Info
	 * @param plnYrmon
	 */
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	
	/**
	 * Column Info
	 * @param trnTtl
	 */
	public void setTrnTtl(String trnTtl) {
		this.trnTtl = trnTtl;
	}
	
	/**
	 * Column Info
	 * @param may
	 */
	public void setMay(String may) {
		this.may = may;
	}
	
	/**
	 * Column Info
	 * @param apr
	 */
	public void setApr(String apr) {
		this.apr = apr;
	}
	
	/**
	 * Column Info
	 * @param salyFlg
	 */
	public void setSalyFlg(String salyFlg) {
		this.salyFlg = salyFlg;
	}
	
	/**
	 * Column Info
	 * @param lvl1Code
	 */
	public void setLvl1Code(String lvl1Code) {
		this.lvl1Code = lvl1Code;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param jul
	 */
	public void setJul(String jul) {
		this.jul = jul;
	}
	
	/**
	 * Column Info
	 * @param jun
	 */
	public void setJun(String jun) {
		this.jun = jun;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param addTtl
	 */
	public void setAddTtl(String addTtl) {
		this.addTtl = addTtl;
	}
	
	/**
	 * Column Info
	 * @param lvl4Tic
	 */
	public void setLvl4Tic(String lvl4Tic) {
		this.lvl4Tic = lvl4Tic;
	}
	
	/**
	 * Column Info
	 * @param calBasis
	 */
	public void setCalBasis(String calBasis) {
		this.calBasis = calBasis;
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
	 * @param lvl4Name
	 */
	public void setLvl4Name(String lvl4Name) {
		this.lvl4Name = lvl4Name;
	}
	
	/**
	 * Column Info
	 * @param lvl4Code
	 */
	public void setLvl4Code(String lvl4Code) {
		this.lvl4Code = lvl4Code;
	}
	
	/**
	 * Column Info
	 * @param grdTtl
	 */
	public void setGrdTtl(String grdTtl) {
		this.grdTtl = grdTtl;
	}
	
	/**
	 * Column Info
	 * @param oct
	 */
	public void setOct(String oct) {
		this.oct = oct;
	}
	
	/**
	 * Column Info
	 * @param feb
	 */
	public void setFeb(String feb) {
		this.feb = feb;
	}
	
	/**
	 * Column Info
	 * @param nov
	 */
	public void setNov(String nov) {
		this.nov = nov;
	}
	
	/**
	 * Column Info
	 * @param aproOpinRmk
	 */
	public void setAproOpinRmk(String aproOpinRmk) {
		this.aproOpinRmk = aproOpinRmk;
	}
	
	/**
	 * Column Info
	 * @param sep
	 */
	public void setSep(String sep) {
		this.sep = sep;
	}
	
	/**
	 * Column Info
	 * @param aug
	 */
	public void setAug(String aug) {
		this.aug = aug;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstTpCd
	 */
	public void setGenExpnRqstTpCd(String genExpnRqstTpCd) {
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLvl2Code(JSPUtil.getParameter(request, "lvl2_code", ""));
		setGenExpnItmDesc(JSPUtil.getParameter(request, "gen_expn_itm_desc", ""));
		setLvl2Name(JSPUtil.getParameter(request, "lvl2_name", ""));
		setIntTtl(JSPUtil.getParameter(request, "int_ttl", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDec(JSPUtil.getParameter(request, "dec", ""));
		setOfcCoDivCd(JSPUtil.getParameter(request, "ofc_co_div_cd", ""));
		setJan(JSPUtil.getParameter(request, "jan", ""));
		setMar(JSPUtil.getParameter(request, "mar", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setGenExpnItmNo(JSPUtil.getParameter(request, "gen_expn_itm_no", ""));
		setLvl1Name(JSPUtil.getParameter(request, "lvl1_name", ""));
		setPlnYrmon(JSPUtil.getParameter(request, "pln_yrmon", ""));
		setTrnTtl(JSPUtil.getParameter(request, "trn_ttl", ""));
		setMay(JSPUtil.getParameter(request, "may", ""));
		setApr(JSPUtil.getParameter(request, "apr", ""));
		setSalyFlg(JSPUtil.getParameter(request, "saly_flg", ""));
		setLvl1Code(JSPUtil.getParameter(request, "lvl1_code", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setJul(JSPUtil.getParameter(request, "jul", ""));
		setJun(JSPUtil.getParameter(request, "jun", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setAddTtl(JSPUtil.getParameter(request, "add_ttl", ""));
		setLvl4Tic(JSPUtil.getParameter(request, "lvl4_tic", ""));
		setCalBasis(JSPUtil.getParameter(request, "cal_basis", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setLvl4Name(JSPUtil.getParameter(request, "lvl4_name", ""));
		setLvl4Code(JSPUtil.getParameter(request, "lvl4_code", ""));
		setGrdTtl(JSPUtil.getParameter(request, "grd_ttl", ""));
		setOct(JSPUtil.getParameter(request, "oct", ""));
		setFeb(JSPUtil.getParameter(request, "feb", ""));
		setNov(JSPUtil.getParameter(request, "nov", ""));
		setAproOpinRmk(JSPUtil.getParameter(request, "apro_opin_rmk", ""));
		setSep(JSPUtil.getParameter(request, "sep", ""));
		setAug(JSPUtil.getParameter(request, "aug", ""));
		setGenExpnRqstTpCd(JSPUtil.getParameter(request, "gen_expn_rqst_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DetailYearlyExpenseVO[]
	 */
	public DetailYearlyExpenseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DetailYearlyExpenseVO[]
	 */
	public DetailYearlyExpenseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DetailYearlyExpenseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lvl2Code = (JSPUtil.getParameter(request, prefix	+ "lvl2_code", length));
			String[] genExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_desc", length));
			String[] lvl2Name = (JSPUtil.getParameter(request, prefix	+ "lvl2_name", length));
			String[] intTtl = (JSPUtil.getParameter(request, prefix	+ "int_ttl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dec = (JSPUtil.getParameter(request, prefix	+ "dec", length));
			String[] ofcCoDivCd = (JSPUtil.getParameter(request, prefix	+ "ofc_co_div_cd", length));
			String[] jan = (JSPUtil.getParameter(request, prefix	+ "jan", length));
			String[] mar = (JSPUtil.getParameter(request, prefix	+ "mar", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] genExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_no", length));
			String[] lvl1Name = (JSPUtil.getParameter(request, prefix	+ "lvl1_name", length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon", length));
			String[] trnTtl = (JSPUtil.getParameter(request, prefix	+ "trn_ttl", length));
			String[] may = (JSPUtil.getParameter(request, prefix	+ "may", length));
			String[] apr = (JSPUtil.getParameter(request, prefix	+ "apr", length));
			String[] salyFlg = (JSPUtil.getParameter(request, prefix	+ "saly_flg", length));
			String[] lvl1Code = (JSPUtil.getParameter(request, prefix	+ "lvl1_code", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] jul = (JSPUtil.getParameter(request, prefix	+ "jul", length));
			String[] jun = (JSPUtil.getParameter(request, prefix	+ "jun", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] addTtl = (JSPUtil.getParameter(request, prefix	+ "add_ttl", length));
			String[] lvl4Tic = (JSPUtil.getParameter(request, prefix	+ "lvl4_tic", length));
			String[] calBasis = (JSPUtil.getParameter(request, prefix	+ "cal_basis", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] lvl4Name = (JSPUtil.getParameter(request, prefix	+ "lvl4_name", length));
			String[] lvl4Code = (JSPUtil.getParameter(request, prefix	+ "lvl4_code", length));
			String[] grdTtl = (JSPUtil.getParameter(request, prefix	+ "grd_ttl", length));
			String[] oct = (JSPUtil.getParameter(request, prefix	+ "oct", length));
			String[] feb = (JSPUtil.getParameter(request, prefix	+ "feb", length));
			String[] nov = (JSPUtil.getParameter(request, prefix	+ "nov", length));
			String[] aproOpinRmk = (JSPUtil.getParameter(request, prefix	+ "apro_opin_rmk", length));
			String[] sep = (JSPUtil.getParameter(request, prefix	+ "sep", length));
			String[] aug = (JSPUtil.getParameter(request, prefix	+ "aug", length));
			String[] genExpnRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DetailYearlyExpenseVO();
				if (lvl2Code[i] != null)
					model.setLvl2Code(lvl2Code[i]);
				if (genExpnItmDesc[i] != null)
					model.setGenExpnItmDesc(genExpnItmDesc[i]);
				if (lvl2Name[i] != null)
					model.setLvl2Name(lvl2Name[i]);
				if (intTtl[i] != null)
					model.setIntTtl(intTtl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dec[i] != null)
					model.setDec(dec[i]);
				if (ofcCoDivCd[i] != null)
					model.setOfcCoDivCd(ofcCoDivCd[i]);
				if (jan[i] != null)
					model.setJan(jan[i]);
				if (mar[i] != null)
					model.setMar(mar[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (genExpnItmNo[i] != null)
					model.setGenExpnItmNo(genExpnItmNo[i]);
				if (lvl1Name[i] != null)
					model.setLvl1Name(lvl1Name[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (trnTtl[i] != null)
					model.setTrnTtl(trnTtl[i]);
				if (may[i] != null)
					model.setMay(may[i]);
				if (apr[i] != null)
					model.setApr(apr[i]);
				if (salyFlg[i] != null)
					model.setSalyFlg(salyFlg[i]);
				if (lvl1Code[i] != null)
					model.setLvl1Code(lvl1Code[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (jul[i] != null)
					model.setJul(jul[i]);
				if (jun[i] != null)
					model.setJun(jun[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (addTtl[i] != null)
					model.setAddTtl(addTtl[i]);
				if (lvl4Tic[i] != null)
					model.setLvl4Tic(lvl4Tic[i]);
				if (calBasis[i] != null)
					model.setCalBasis(calBasis[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (lvl4Name[i] != null)
					model.setLvl4Name(lvl4Name[i]);
				if (lvl4Code[i] != null)
					model.setLvl4Code(lvl4Code[i]);
				if (grdTtl[i] != null)
					model.setGrdTtl(grdTtl[i]);
				if (oct[i] != null)
					model.setOct(oct[i]);
				if (feb[i] != null)
					model.setFeb(feb[i]);
				if (nov[i] != null)
					model.setNov(nov[i]);
				if (aproOpinRmk[i] != null)
					model.setAproOpinRmk(aproOpinRmk[i]);
				if (sep[i] != null)
					model.setSep(sep[i]);
				if (aug[i] != null)
					model.setAug(aug[i]);
				if (genExpnRqstTpCd[i] != null)
					model.setGenExpnRqstTpCd(genExpnRqstTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDetailYearlyExpenseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DetailYearlyExpenseVO[]
	 */
	public DetailYearlyExpenseVO[] getDetailYearlyExpenseVOs(){
		DetailYearlyExpenseVO[] vos = (DetailYearlyExpenseVO[])models.toArray(new DetailYearlyExpenseVO[models.size()]);
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
		this.lvl2Code = this.lvl2Code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmDesc = this.genExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl2Name = this.lvl2Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intTtl = this.intTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dec = this.dec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCoDivCd = this.ofcCoDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jan = this.jan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mar = this.mar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmNo = this.genExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl1Name = this.lvl1Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnTtl = this.trnTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.may = this.may .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apr = this.apr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salyFlg = this.salyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl1Code = this.lvl1Code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jul = this.jul .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jun = this.jun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addTtl = this.addTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl4Tic = this.lvl4Tic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calBasis = this.calBasis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl4Name = this.lvl4Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl4Code = this.lvl4Code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdTtl = this.grdTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oct = this.oct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feb = this.feb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nov = this.nov .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOpinRmk = this.aproOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sep = this.sep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aug = this.aug .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstTpCd = this.genExpnRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
