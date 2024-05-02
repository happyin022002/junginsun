/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AutoratingReportVO.java
*@FileTitle : AutoratingReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.03.12 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AutoratingReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AutoratingReportVO> models = new ArrayList<AutoratingReportVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String autoCnt = null;
	/* Column Info */
	private String autoDelFlg = null;
	/* Column Info */
	private String ofcIncSub = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String tTtl = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String autoRatFlg = null;
	/* Column Info */
	private String tNonAutoCnt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String autoRatCd = null;
	/* Column Info */
	private String tAutoCnt = null;
	/* Column Info */
	private String ctrtCd = null;
	/* Column Info */
	private String nonAutoCnt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String rater = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String raterOfc = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String tRatio = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String selScpCd = null;
	/* Column Info */
	private String changeHistory = null;
	/* Column Info */
	private String tRateCnt = null;
	/* Column Info */
	private String rateCnt = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String selOfcCd = null;
	/* Column Info */
	private String dtOption = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AutoratingReportVO() {}

	public AutoratingReportVO(String ibflag, String pagerows, String svcScpCd, String bkgOfcCd, String region, String ttl, String rateCnt, String autoCnt, String nonAutoCnt, String ratio, String tTtl, String tRateCnt, String tNonAutoCnt, String tAutoCnt, String tRatio, String bkgNo, String scNo, String cmdtCd, String cmdtNm, String changeHistory, String rater, String raterOfc, String selOfcCd, String dtOption, String selScpCd, String ofcIncSub, String chgCd, String frDt, String toDt, String ctrtCd, String ratUtCd, String autoRatFlg, String autoDelFlg, String rtSeq, String rowNum, String autoRatCd) {
		this.region = region;
		this.autoCnt = autoCnt;
		this.autoDelFlg = autoDelFlg;
		this.ofcIncSub = ofcIncSub;
		this.svcScpCd = svcScpCd;
		this.frDt = frDt;
		this.chgCd = chgCd;
		this.tTtl = tTtl;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.scNo = scNo;
		this.autoRatFlg = autoRatFlg;
		this.tNonAutoCnt = tNonAutoCnt;
		this.bkgOfcCd = bkgOfcCd;
		this.autoRatCd = autoRatCd;
		this.tAutoCnt = tAutoCnt;
		this.ctrtCd = ctrtCd;
		this.nonAutoCnt = nonAutoCnt;
		this.ratUtCd = ratUtCd;
		this.rater = rater;
		this.ttl = ttl;
		this.raterOfc = raterOfc;
		this.rtSeq = rtSeq;
		this.cmdtNm = cmdtNm;
		this.toDt = toDt;
		this.tRatio = tRatio;
		this.bkgNo = bkgNo;
		this.ratio = ratio;
		this.selScpCd = selScpCd;
		this.changeHistory = changeHistory;
		this.tRateCnt = tRateCnt;
		this.rateCnt = rateCnt;
		this.rowNum = rowNum;
		this.selOfcCd = selOfcCd;
		this.dtOption = dtOption;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("auto_cnt", getAutoCnt());
		this.hashColumns.put("auto_del_flg", getAutoDelFlg());
		this.hashColumns.put("ofc_inc_sub", getOfcIncSub());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("t_ttl", getTTtl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("t_non_auto_cnt", getTNonAutoCnt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("auto_rat_cd", getAutoRatCd());
		this.hashColumns.put("t_auto_cnt", getTAutoCnt());
		this.hashColumns.put("ctrt_cd", getCtrtCd());
		this.hashColumns.put("non_auto_cnt", getNonAutoCnt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("rater", getRater());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("rater_ofc", getRaterOfc());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("t_ratio", getTRatio());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("sel_scp_cd", getSelScpCd());
		this.hashColumns.put("change_history", getChangeHistory());
		this.hashColumns.put("t_rate_cnt", getTRateCnt());
		this.hashColumns.put("rate_cnt", getRateCnt());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("sel_ofc_cd", getSelOfcCd());
		this.hashColumns.put("dt_option", getDtOption());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("auto_cnt", "autoCnt");
		this.hashFields.put("auto_del_flg", "autoDelFlg");
		this.hashFields.put("ofc_inc_sub", "ofcIncSub");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("t_ttl", "tTtl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("t_non_auto_cnt", "tNonAutoCnt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("auto_rat_cd", "autoRatCd");
		this.hashFields.put("t_auto_cnt", "tAutoCnt");
		this.hashFields.put("ctrt_cd", "ctrtCd");
		this.hashFields.put("non_auto_cnt", "nonAutoCnt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("rater", "rater");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("rater_ofc", "raterOfc");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("t_ratio", "tRatio");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("sel_scp_cd", "selScpCd");
		this.hashFields.put("change_history", "changeHistory");
		this.hashFields.put("t_rate_cnt", "tRateCnt");
		this.hashFields.put("rate_cnt", "rateCnt");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("sel_ofc_cd", "selOfcCd");
		this.hashFields.put("dt_option", "dtOption");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return autoCnt
	 */
	public String getAutoCnt() {
		return this.autoCnt;
	}
	
	/**
	 * Column Info
	 * @return autoDelFlg
	 */
	public String getAutoDelFlg() {
		return this.autoDelFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcIncSub
	 */
	public String getOfcIncSub() {
		return this.ofcIncSub;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return tTtl
	 */
	public String getTTtl() {
		return this.tTtl;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return autoRatFlg
	 */
	public String getAutoRatFlg() {
		return this.autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @return tNonAutoCnt
	 */
	public String getTNonAutoCnt() {
		return this.tNonAutoCnt;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return autoRatCd
	 */
	public String getAutoRatCd() {
		return this.autoRatCd;
	}
	
	/**
	 * Column Info
	 * @return tAutoCnt
	 */
	public String getTAutoCnt() {
		return this.tAutoCnt;
	}
	
	/**
	 * Column Info
	 * @return ctrtCd
	 */
	public String getCtrtCd() {
		return this.ctrtCd;
	}
	
	/**
	 * Column Info
	 * @return nonAutoCnt
	 */
	public String getNonAutoCnt() {
		return this.nonAutoCnt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return rater
	 */
	public String getRater() {
		return this.rater;
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
	 * @return raterOfc
	 */
	public String getRaterOfc() {
		return this.raterOfc;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return tRatio
	 */
	public String getTRatio() {
		return this.tRatio;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return selScpCd
	 */
	public String getSelScpCd() {
		return this.selScpCd;
	}
	
	/**
	 * Column Info
	 * @return changeHistory
	 */
	public String getChangeHistory() {
		return this.changeHistory;
	}
	
	/**
	 * Column Info
	 * @return tRateCnt
	 */
	public String getTRateCnt() {
		return this.tRateCnt;
	}
	
	/**
	 * Column Info
	 * @return rateCnt
	 */
	public String getRateCnt() {
		return this.rateCnt;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return selOfcCd
	 */
	public String getSelOfcCd() {
		return this.selOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dtOption
	 */
	public String getDtOption() {
		return this.dtOption;
	}
	

	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param autoCnt
	 */
	public void setAutoCnt(String autoCnt) {
		this.autoCnt = autoCnt;
	}
	
	/**
	 * Column Info
	 * @param autoDelFlg
	 */
	public void setAutoDelFlg(String autoDelFlg) {
		this.autoDelFlg = autoDelFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcIncSub
	 */
	public void setOfcIncSub(String ofcIncSub) {
		this.ofcIncSub = ofcIncSub;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param tTtl
	 */
	public void setTTtl(String tTtl) {
		this.tTtl = tTtl;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param autoRatFlg
	 */
	public void setAutoRatFlg(String autoRatFlg) {
		this.autoRatFlg = autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @param tNonAutoCnt
	 */
	public void setTNonAutoCnt(String tNonAutoCnt) {
		this.tNonAutoCnt = tNonAutoCnt;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param autoRatCd
	 */
	public void setAutoRatCd(String autoRatCd) {
		this.autoRatCd = autoRatCd;
	}
	
	/**
	 * Column Info
	 * @param tAutoCnt
	 */
	public void setTAutoCnt(String tAutoCnt) {
		this.tAutoCnt = tAutoCnt;
	}
	
	/**
	 * Column Info
	 * @param ctrtCd
	 */
	public void setCtrtCd(String ctrtCd) {
		this.ctrtCd = ctrtCd;
	}
	
	/**
	 * Column Info
	 * @param nonAutoCnt
	 */
	public void setNonAutoCnt(String nonAutoCnt) {
		this.nonAutoCnt = nonAutoCnt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param rater
	 */
	public void setRater(String rater) {
		this.rater = rater;
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
	 * @param raterOfc
	 */
	public void setRaterOfc(String raterOfc) {
		this.raterOfc = raterOfc;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param tRatio
	 */
	public void setTRatio(String tRatio) {
		this.tRatio = tRatio;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param selScpCd
	 */
	public void setSelScpCd(String selScpCd) {
		this.selScpCd = selScpCd;
	}
	
	/**
	 * Column Info
	 * @param changeHistory
	 */
	public void setChangeHistory(String changeHistory) {
		this.changeHistory = changeHistory;
	}
	
	/**
	 * Column Info
	 * @param tRateCnt
	 */
	public void setTRateCnt(String tRateCnt) {
		this.tRateCnt = tRateCnt;
	}
	
	/**
	 * Column Info
	 * @param rateCnt
	 */
	public void setRateCnt(String rateCnt) {
		this.rateCnt = rateCnt;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param selOfcCd
	 */
	public void setSelOfcCd(String selOfcCd) {
		this.selOfcCd = selOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dtOption
	 */
	public void setDtOption(String dtOption) {
		this.dtOption = dtOption;
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
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setAutoCnt(JSPUtil.getParameter(request, prefix + "auto_cnt", ""));
		setAutoDelFlg(JSPUtil.getParameter(request, prefix + "auto_del_flg", ""));
		setOfcIncSub(JSPUtil.getParameter(request, prefix + "ofc_inc_sub", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFrDt(JSPUtil.getParameter(request, prefix + "fr_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setTTtl(JSPUtil.getParameter(request, prefix + "t_ttl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setTNonAutoCnt(JSPUtil.getParameter(request, prefix + "t_non_auto_cnt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setAutoRatCd(JSPUtil.getParameter(request, prefix + "auto_rat_cd", ""));
		setTAutoCnt(JSPUtil.getParameter(request, prefix + "t_auto_cnt", ""));
		setCtrtCd(JSPUtil.getParameter(request, prefix + "ctrt_cd", ""));
		setNonAutoCnt(JSPUtil.getParameter(request, prefix + "non_auto_cnt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setRater(JSPUtil.getParameter(request, prefix + "rater", ""));
		setTtl(JSPUtil.getParameter(request, prefix + "ttl", ""));
		setRaterOfc(JSPUtil.getParameter(request, prefix + "rater_ofc", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setTRatio(JSPUtil.getParameter(request, prefix + "t_ratio", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRatio(JSPUtil.getParameter(request, prefix + "ratio", ""));
		setSelScpCd(JSPUtil.getParameter(request, prefix + "sel_scp_cd", ""));
		setChangeHistory(JSPUtil.getParameter(request, prefix + "change_history", ""));
		setTRateCnt(JSPUtil.getParameter(request, prefix + "t_rate_cnt", ""));
		setRateCnt(JSPUtil.getParameter(request, prefix + "rate_cnt", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setSelOfcCd(JSPUtil.getParameter(request, prefix + "sel_ofc_cd", ""));
		setDtOption(JSPUtil.getParameter(request, prefix + "dt_option", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AutoratingReportVO[]
	 */
	public AutoratingReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AutoratingReportVO[]
	 */
	public AutoratingReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutoratingReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] autoCnt = (JSPUtil.getParameter(request, prefix	+ "auto_cnt", length));
			String[] autoDelFlg = (JSPUtil.getParameter(request, prefix	+ "auto_del_flg", length));
			String[] ofcIncSub = (JSPUtil.getParameter(request, prefix	+ "ofc_inc_sub", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] tTtl = (JSPUtil.getParameter(request, prefix	+ "t_ttl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] tNonAutoCnt = (JSPUtil.getParameter(request, prefix	+ "t_non_auto_cnt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] autoRatCd = (JSPUtil.getParameter(request, prefix	+ "auto_rat_cd", length));
			String[] tAutoCnt = (JSPUtil.getParameter(request, prefix	+ "t_auto_cnt", length));
			String[] ctrtCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cd", length));
			String[] nonAutoCnt = (JSPUtil.getParameter(request, prefix	+ "non_auto_cnt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] rater = (JSPUtil.getParameter(request, prefix	+ "rater", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] raterOfc = (JSPUtil.getParameter(request, prefix	+ "rater_ofc", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] tRatio = (JSPUtil.getParameter(request, prefix	+ "t_ratio", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] selScpCd = (JSPUtil.getParameter(request, prefix	+ "sel_scp_cd", length));
			String[] changeHistory = (JSPUtil.getParameter(request, prefix	+ "change_history", length));
			String[] tRateCnt = (JSPUtil.getParameter(request, prefix	+ "t_rate_cnt", length));
			String[] rateCnt = (JSPUtil.getParameter(request, prefix	+ "rate_cnt", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] selOfcCd = (JSPUtil.getParameter(request, prefix	+ "sel_ofc_cd", length));
			String[] dtOption = (JSPUtil.getParameter(request, prefix	+ "dt_option", length));
			
			for (int i = 0; i < length; i++) {
				model = new AutoratingReportVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (autoCnt[i] != null)
					model.setAutoCnt(autoCnt[i]);
				if (autoDelFlg[i] != null)
					model.setAutoDelFlg(autoDelFlg[i]);
				if (ofcIncSub[i] != null)
					model.setOfcIncSub(ofcIncSub[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (tTtl[i] != null)
					model.setTTtl(tTtl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (tNonAutoCnt[i] != null)
					model.setTNonAutoCnt(tNonAutoCnt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (autoRatCd[i] != null)
					model.setAutoRatCd(autoRatCd[i]);
				if (tAutoCnt[i] != null)
					model.setTAutoCnt(tAutoCnt[i]);
				if (ctrtCd[i] != null)
					model.setCtrtCd(ctrtCd[i]);
				if (nonAutoCnt[i] != null)
					model.setNonAutoCnt(nonAutoCnt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (rater[i] != null)
					model.setRater(rater[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (raterOfc[i] != null)
					model.setRaterOfc(raterOfc[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (tRatio[i] != null)
					model.setTRatio(tRatio[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (selScpCd[i] != null)
					model.setSelScpCd(selScpCd[i]);
				if (changeHistory[i] != null)
					model.setChangeHistory(changeHistory[i]);
				if (tRateCnt[i] != null)
					model.setTRateCnt(tRateCnt[i]);
				if (rateCnt[i] != null)
					model.setRateCnt(rateCnt[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (selOfcCd[i] != null)
					model.setSelOfcCd(selOfcCd[i]);
				if (dtOption[i] != null)
					model.setDtOption(dtOption[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAutoratingReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AutoratingReportVO[]
	 */
	public AutoratingReportVO[] getAutoratingReportVOs(){
		AutoratingReportVO[] vos = (AutoratingReportVO[])models.toArray(new AutoratingReportVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoCnt = this.autoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoDelFlg = this.autoDelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcIncSub = this.ofcIncSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tTtl = this.tTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatFlg = this.autoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tNonAutoCnt = this.tNonAutoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatCd = this.autoRatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tAutoCnt = this.tAutoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCd = this.ctrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonAutoCnt = this.nonAutoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rater = this.rater .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raterOfc = this.raterOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tRatio = this.tRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selScpCd = this.selScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.changeHistory = this.changeHistory .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tRateCnt = this.tRateCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateCnt = this.rateCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selOfcCd = this.selOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtOption = this.dtOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
