/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchMissingListVO.java
*@FileTitle : SearchMissingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.03.30 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

import java.lang.reflect.Field;
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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMissingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMissingListVO> models = new ArrayList<SearchMissingListVO>();
	
	/* Column Info */
	private String gmtDt2 = null;
	/* Column Info */
	private String gmtDt1 = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String custSts = null;
	/* Column Info */
	private String clickday = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String missingStatus = null;
	/* Column Info */
	private String sBlNo = null;
	/* Column Info */
	private String maxEdiSndKnt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String sortSeq = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String totcnt = null;
	/* Column Info */
	private String toddt = null;
	/* Column Info */
	private String copsts = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String creDt2 = null;
	/* Column Info */
	private String polFromdate = null;
	/* Column Info */
	private String creDt1 = null;
	/* Column Info */
	private String titleRow = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String sCntrNo = null;
	/* Column Info */
	private String ediSubStsCd = null;
	/* Column Info */
	private String ediSndKnt = null;
	/* Column Info */
	private String csGrpId = null;
	/* Column Info */
	private String maxEdiSmdKnt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String actDt2 = null;
	/* Column Info */
	private String missingCnt = null;
	/* Column Info */
	private String ediStsCd = null;
	/* Column Info */
	private String custSt = null;
	/* Column Info */
	private String podFromdate = null;
	/* Column Info */
	private String polTodate = null;
	/* Column Info */
	private String podTodate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsMode = null;
	/* Column Info */
	private String fromddt = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String actDt1 = null;
	/* Column Info */
	private String actDtHours = null;
	/* Column Info */
	private String fromadt = null;
	/* Column Info */
	private String rbtn = null;
	/* Column Info */
	private String sortDt = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String actDtDays = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String toadt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMissingListVO() {}

	public SearchMissingListVO(String ibflag, String pagerows, String diff, String missingCnt, String titleRow, String clickday, String missingStatus, String csGrpId, String custSts, String trsMode, String vvd, String por, String pol, String pod, String del, String fromddt, String toddt, String fromadt, String toadt, String bkgNo, String blNo, String copsts, String ediSts, String cntrNo, String porCd, String polCd, String podCd, String delCd, String ediStsCd, String ediSubStsCd, String ediSndKnt, String actDt1, String actDt2, String nodCd, String creDt1, String creDt2, String copNo, String sortSeq, String sortDt, String maxEdiSmdKnt, String gmtDt1, String gmtDt2, String totcnt, String iPage, String custSt, String actDtDays, String actDtHours, String maxEdiSndKnt, String rbtn, String polFromdate, String polTodate, String podFromdate, String podTodate, String sVvd, String sBkgNo, String sCntrNo, String sBlNo) {
		this.gmtDt2 = gmtDt2;
		this.gmtDt1 = gmtDt1;
		this.diff = diff;
		this.custSts = custSts;
		this.clickday = clickday;
		this.por = por;
		this.copNo = copNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.missingStatus = missingStatus;
		this.sBlNo = sBlNo;
		this.maxEdiSndKnt = maxEdiSndKnt;
		this.polCd = polCd;
		this.pol = pol;
		this.sortSeq = sortSeq;
		this.iPage = iPage;
		this.totcnt = totcnt;
		this.toddt = toddt;
		this.copsts = copsts;
		this.pod = pod;
		this.creDt2 = creDt2;
		this.polFromdate = polFromdate;
		this.creDt1 = creDt1;
		this.titleRow = titleRow;
		this.delCd = delCd;
		this.sCntrNo = sCntrNo;
		this.ediSubStsCd = ediSubStsCd;
		this.ediSndKnt = ediSndKnt;
		this.csGrpId = csGrpId;
		this.maxEdiSmdKnt = maxEdiSmdKnt;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.nodCd = nodCd;
		this.porCd = porCd;
		this.sBkgNo = sBkgNo;
		this.actDt2 = actDt2;
		this.missingCnt = missingCnt;
		this.ediStsCd = ediStsCd;
		this.custSt = custSt;
		this.podFromdate = podFromdate;
		this.polTodate = polTodate;
		this.podTodate = podTodate;
		this.ibflag = ibflag;
		this.trsMode = trsMode;
		this.fromddt = fromddt;
		this.del = del;
		this.actDt1 = actDt1;
		this.actDtHours = actDtHours;
		this.fromadt = fromadt;
		this.rbtn = rbtn;
		this.sortDt = sortDt;
		this.sVvd = sVvd;
		this.actDtDays = actDtDays;
		this.ediSts = ediSts;
		this.cntrNo = cntrNo;
		this.toadt = toadt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gmt_dt2", getGmtDt2());
		this.hashColumns.put("gmt_dt1", getGmtDt1());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("cust_sts", getCustSts());
		this.hashColumns.put("clickday", getClickday());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("missing_status", getMissingStatus());
		this.hashColumns.put("s_bl_no", getSBlNo());
		this.hashColumns.put("max_edi_snd_knt", getMaxEdiSndKnt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("sort_seq", getSortSeq());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("totcnt", getTotcnt());
		this.hashColumns.put("toddt", getToddt());
		this.hashColumns.put("copsts", getCopsts());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("cre_dt2", getCreDt2());
		this.hashColumns.put("pol_fromdate", getPolFromdate());
		this.hashColumns.put("cre_dt1", getCreDt1());
		this.hashColumns.put("title_row", getTitleRow());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("edi_sub_sts_cd", getEdiSubStsCd());
		this.hashColumns.put("edi_snd_knt", getEdiSndKnt());
		this.hashColumns.put("cs_grp_id", getCsGrpId());
		this.hashColumns.put("max_edi_smd_knt", getMaxEdiSmdKnt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("act_dt2", getActDt2());
		this.hashColumns.put("missing_cnt", getMissingCnt());
		this.hashColumns.put("edi_sts_cd", getEdiStsCd());
		this.hashColumns.put("cust_st", getCustSt());
		this.hashColumns.put("pod_fromdate", getPodFromdate());
		this.hashColumns.put("pol_todate", getPolTodate());
		this.hashColumns.put("pod_todate", getPodTodate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trs_mode", getTrsMode());
		this.hashColumns.put("fromddt", getFromddt());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("act_dt1", getActDt1());
		this.hashColumns.put("act_dt_hours", getActDtHours());
		this.hashColumns.put("fromadt", getFromadt());
		this.hashColumns.put("rbtn", getRbtn());
		this.hashColumns.put("sort_dt", getSortDt());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("act_dt_days", getActDtDays());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("toadt", getToadt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gmt_dt2", "gmtDt2");
		this.hashFields.put("gmt_dt1", "gmtDt1");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("cust_sts", "custSts");
		this.hashFields.put("clickday", "clickday");
		this.hashFields.put("por", "por");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("missing_status", "missingStatus");
		this.hashFields.put("s_bl_no", "sBlNo");
		this.hashFields.put("max_edi_snd_knt", "maxEdiSndKnt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("sort_seq", "sortSeq");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("totcnt", "totcnt");
		this.hashFields.put("toddt", "toddt");
		this.hashFields.put("copsts", "copsts");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("cre_dt2", "creDt2");
		this.hashFields.put("pol_fromdate", "polFromdate");
		this.hashFields.put("cre_dt1", "creDt1");
		this.hashFields.put("title_row", "titleRow");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("edi_sub_sts_cd", "ediSubStsCd");
		this.hashFields.put("edi_snd_knt", "ediSndKnt");
		this.hashFields.put("cs_grp_id", "csGrpId");
		this.hashFields.put("max_edi_smd_knt", "maxEdiSmdKnt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("act_dt2", "actDt2");
		this.hashFields.put("missing_cnt", "missingCnt");
		this.hashFields.put("edi_sts_cd", "ediStsCd");
		this.hashFields.put("cust_st", "custSt");
		this.hashFields.put("pod_fromdate", "podFromdate");
		this.hashFields.put("pol_todate", "polTodate");
		this.hashFields.put("pod_todate", "podTodate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trs_mode", "trsMode");
		this.hashFields.put("fromddt", "fromddt");
		this.hashFields.put("del", "del");
		this.hashFields.put("act_dt1", "actDt1");
		this.hashFields.put("act_dt_hours", "actDtHours");
		this.hashFields.put("fromadt", "fromadt");
		this.hashFields.put("rbtn", "rbtn");
		this.hashFields.put("sort_dt", "sortDt");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("act_dt_days", "actDtDays");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("toadt", "toadt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return gmtDt2
	 */
	public String getGmtDt2() {
		return this.gmtDt2;
	}
	
	/**
	 * Column Info
	 * @return gmtDt1
	 */
	public String getGmtDt1() {
		return this.gmtDt1;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}
	
	/**
	 * Column Info
	 * @return custSts
	 */
	public String getCustSts() {
		return this.custSts;
	}
	
	/**
	 * Column Info
	 * @return clickday
	 */
	public String getClickday() {
		return this.clickday;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return missingStatus
	 */
	public String getMissingStatus() {
		return this.missingStatus;
	}
	
	/**
	 * Column Info
	 * @return sBlNo
	 */
	public String getSBlNo() {
		return this.sBlNo;
	}
	
	/**
	 * Column Info
	 * @return maxEdiSndKnt
	 */
	public String getMaxEdiSndKnt() {
		return this.maxEdiSndKnt;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return sortSeq
	 */
	public String getSortSeq() {
		return this.sortSeq;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	
	/**
	 * Column Info
	 * @return totcnt
	 */
	public String getTotcnt() {
		return this.totcnt;
	}
	
	/**
	 * Column Info
	 * @return toddt
	 */
	public String getToddt() {
		return this.toddt;
	}
	
	/**
	 * Column Info
	 * @return copsts
	 */
	public String getCopsts() {
		return this.copsts;
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
	 * @return creDt2
	 */
	public String getCreDt2() {
		return this.creDt2;
	}
	
	/**
	 * Column Info
	 * @return polFromdate
	 */
	public String getPolFromdate() {
		return this.polFromdate;
	}
	
	/**
	 * Column Info
	 * @return creDt1
	 */
	public String getCreDt1() {
		return this.creDt1;
	}
	
	/**
	 * Column Info
	 * @return titleRow
	 */
	public String getTitleRow() {
		return this.titleRow;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return sCntrNo
	 */
	public String getSCntrNo() {
		return this.sCntrNo;
	}
	
	/**
	 * Column Info
	 * @return ediSubStsCd
	 */
	public String getEdiSubStsCd() {
		return this.ediSubStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndKnt
	 */
	public String getEdiSndKnt() {
		return this.ediSndKnt;
	}
	
	/**
	 * Column Info
	 * @return csGrpId
	 */
	public String getCsGrpId() {
		return this.csGrpId;
	}
	
	/**
	 * Column Info
	 * @return maxEdiSmdKnt
	 */
	public String getMaxEdiSmdKnt() {
		return this.maxEdiSmdKnt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return actDt2
	 */
	public String getActDt2() {
		return this.actDt2;
	}
	
	/**
	 * Column Info
	 * @return missingCnt
	 */
	public String getMissingCnt() {
		return this.missingCnt;
	}
	
	/**
	 * Column Info
	 * @return ediStsCd
	 */
	public String getEdiStsCd() {
		return this.ediStsCd;
	}
	
	/**
	 * Column Info
	 * @return custSt
	 */
	public String getCustSt() {
		return this.custSt;
	}
	
	/**
	 * Column Info
	 * @return podFromdate
	 */
	public String getPodFromdate() {
		return this.podFromdate;
	}
	
	/**
	 * Column Info
	 * @return polTodate
	 */
	public String getPolTodate() {
		return this.polTodate;
	}
	
	/**
	 * Column Info
	 * @return podTodate
	 */
	public String getPodTodate() {
		return this.podTodate;
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
	 * @return trsMode
	 */
	public String getTrsMode() {
		return this.trsMode;
	}
	
	/**
	 * Column Info
	 * @return fromddt
	 */
	public String getFromddt() {
		return this.fromddt;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return actDt1
	 */
	public String getActDt1() {
		return this.actDt1;
	}
	
	/**
	 * Column Info
	 * @return actDtHours
	 */
	public String getActDtHours() {
		return this.actDtHours;
	}
	
	/**
	 * Column Info
	 * @return fromadt
	 */
	public String getFromadt() {
		return this.fromadt;
	}
	
	/**
	 * Column Info
	 * @return rbtn
	 */
	public String getRbtn() {
		return this.rbtn;
	}
	
	/**
	 * Column Info
	 * @return sortDt
	 */
	public String getSortDt() {
		return this.sortDt;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return actDtDays
	 */
	public String getActDtDays() {
		return this.actDtDays;
	}
	
	/**
	 * Column Info
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return toadt
	 */
	public String getToadt() {
		return this.toadt;
	}
	

	/**
	 * Column Info
	 * @param gmtDt2
	 */
	public void setGmtDt2(String gmtDt2) {
		this.gmtDt2 = gmtDt2;
	}
	
	/**
	 * Column Info
	 * @param gmtDt1
	 */
	public void setGmtDt1(String gmtDt1) {
		this.gmtDt1 = gmtDt1;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Column Info
	 * @param custSts
	 */
	public void setCustSts(String custSts) {
		this.custSts = custSts;
	}
	
	/**
	 * Column Info
	 * @param clickday
	 */
	public void setClickday(String clickday) {
		this.clickday = clickday;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param missingStatus
	 */
	public void setMissingStatus(String missingStatus) {
		this.missingStatus = missingStatus;
	}
	
	/**
	 * Column Info
	 * @param sBlNo
	 */
	public void setSBlNo(String sBlNo) {
		this.sBlNo = sBlNo;
	}
	
	/**
	 * Column Info
	 * @param maxEdiSndKnt
	 */
	public void setMaxEdiSndKnt(String maxEdiSndKnt) {
		this.maxEdiSndKnt = maxEdiSndKnt;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param sortSeq
	 */
	public void setSortSeq(String sortSeq) {
		this.sortSeq = sortSeq;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param totcnt
	 */
	public void setTotcnt(String totcnt) {
		this.totcnt = totcnt;
	}
	
	/**
	 * Column Info
	 * @param toddt
	 */
	public void setToddt(String toddt) {
		this.toddt = toddt;
	}
	
	/**
	 * Column Info
	 * @param copsts
	 */
	public void setCopsts(String copsts) {
		this.copsts = copsts;
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
	 * @param creDt2
	 */
	public void setCreDt2(String creDt2) {
		this.creDt2 = creDt2;
	}
	
	/**
	 * Column Info
	 * @param polFromdate
	 */
	public void setPolFromdate(String polFromdate) {
		this.polFromdate = polFromdate;
	}
	
	/**
	 * Column Info
	 * @param creDt1
	 */
	public void setCreDt1(String creDt1) {
		this.creDt1 = creDt1;
	}
	
	/**
	 * Column Info
	 * @param titleRow
	 */
	public void setTitleRow(String titleRow) {
		this.titleRow = titleRow;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param sCntrNo
	 */
	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	
	/**
	 * Column Info
	 * @param ediSubStsCd
	 */
	public void setEdiSubStsCd(String ediSubStsCd) {
		this.ediSubStsCd = ediSubStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndKnt
	 */
	public void setEdiSndKnt(String ediSndKnt) {
		this.ediSndKnt = ediSndKnt;
	}
	
	/**
	 * Column Info
	 * @param csGrpId
	 */
	public void setCsGrpId(String csGrpId) {
		this.csGrpId = csGrpId;
	}
	
	/**
	 * Column Info
	 * @param maxEdiSmdKnt
	 */
	public void setMaxEdiSmdKnt(String maxEdiSmdKnt) {
		this.maxEdiSmdKnt = maxEdiSmdKnt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param actDt2
	 */
	public void setActDt2(String actDt2) {
		this.actDt2 = actDt2;
	}
	
	/**
	 * Column Info
	 * @param missingCnt
	 */
	public void setMissingCnt(String missingCnt) {
		this.missingCnt = missingCnt;
	}
	
	/**
	 * Column Info
	 * @param ediStsCd
	 */
	public void setEdiStsCd(String ediStsCd) {
		this.ediStsCd = ediStsCd;
	}
	
	/**
	 * Column Info
	 * @param custSt
	 */
	public void setCustSt(String custSt) {
		this.custSt = custSt;
	}
	
	/**
	 * Column Info
	 * @param podFromdate
	 */
	public void setPodFromdate(String podFromdate) {
		this.podFromdate = podFromdate;
	}
	
	/**
	 * Column Info
	 * @param polTodate
	 */
	public void setPolTodate(String polTodate) {
		this.polTodate = polTodate;
	}
	
	/**
	 * Column Info
	 * @param podTodate
	 */
	public void setPodTodate(String podTodate) {
		this.podTodate = podTodate;
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
	 * @param trsMode
	 */
	public void setTrsMode(String trsMode) {
		this.trsMode = trsMode;
	}
	
	/**
	 * Column Info
	 * @param fromddt
	 */
	public void setFromddt(String fromddt) {
		this.fromddt = fromddt;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param actDt1
	 */
	public void setActDt1(String actDt1) {
		this.actDt1 = actDt1;
	}
	
	/**
	 * Column Info
	 * @param actDtHours
	 */
	public void setActDtHours(String actDtHours) {
		this.actDtHours = actDtHours;
	}
	
	/**
	 * Column Info
	 * @param fromadt
	 */
	public void setFromadt(String fromadt) {
		this.fromadt = fromadt;
	}
	
	/**
	 * Column Info
	 * @param rbtn
	 */
	public void setRbtn(String rbtn) {
		this.rbtn = rbtn;
	}
	
	/**
	 * Column Info
	 * @param sortDt
	 */
	public void setSortDt(String sortDt) {
		this.sortDt = sortDt;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param actDtDays
	 */
	public void setActDtDays(String actDtDays) {
		this.actDtDays = actDtDays;
	}
	
	/**
	 * Column Info
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param toadt
	 */
	public void setToadt(String toadt) {
		this.toadt = toadt;
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
		setGmtDt2(JSPUtil.getParameter(request, prefix + "gmt_dt2", ""));
		setGmtDt1(JSPUtil.getParameter(request, prefix + "gmt_dt1", ""));
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
		setCustSts(JSPUtil.getParameter(request, prefix + "cust_sts", ""));
		setClickday(JSPUtil.getParameter(request, prefix + "clickday", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMissingStatus(JSPUtil.getParameter(request, prefix + "missing_status", ""));
		setSBlNo(JSPUtil.getParameter(request, prefix + "s_bl_no", ""));
		setMaxEdiSndKnt(JSPUtil.getParameter(request, prefix + "max_edi_snd_knt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setSortSeq(JSPUtil.getParameter(request, prefix + "sort_seq", ""));
		setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
		setTotcnt(JSPUtil.getParameter(request, prefix + "totcnt", ""));
		setToddt(JSPUtil.getParameter(request, prefix + "toddt", ""));
		setCopsts(JSPUtil.getParameter(request, prefix + "copsts", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setCreDt2(JSPUtil.getParameter(request, prefix + "cre_dt2", ""));
		setPolFromdate(JSPUtil.getParameter(request, prefix + "pol_fromdate", ""));
		setCreDt1(JSPUtil.getParameter(request, prefix + "cre_dt1", ""));
		setTitleRow(JSPUtil.getParameter(request, prefix + "title_row", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
		setEdiSubStsCd(JSPUtil.getParameter(request, prefix + "edi_sub_sts_cd", ""));
		setEdiSndKnt(JSPUtil.getParameter(request, prefix + "edi_snd_knt", ""));
		setCsGrpId(JSPUtil.getParameter(request, prefix + "cs_grp_id", ""));
		setMaxEdiSmdKnt(JSPUtil.getParameter(request, prefix + "max_edi_smd_knt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setActDt2(JSPUtil.getParameter(request, prefix + "act_dt2", ""));
		setMissingCnt(JSPUtil.getParameter(request, prefix + "missing_cnt", ""));
		setEdiStsCd(JSPUtil.getParameter(request, prefix + "edi_sts_cd", ""));
		setCustSt(JSPUtil.getParameter(request, prefix + "cust_st", ""));
		setPodFromdate(JSPUtil.getParameter(request, prefix + "pod_fromdate", ""));
		setPolTodate(JSPUtil.getParameter(request, prefix + "pol_todate", ""));
		setPodTodate(JSPUtil.getParameter(request, prefix + "pod_todate", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrsMode(JSPUtil.getParameter(request, prefix + "trs_mode", ""));
		setFromddt(JSPUtil.getParameter(request, prefix + "fromddt", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setActDt1(JSPUtil.getParameter(request, prefix + "act_dt1", ""));
		setActDtHours(JSPUtil.getParameter(request, prefix + "act_dt_hours", ""));
		setFromadt(JSPUtil.getParameter(request, prefix + "fromadt", ""));
		setRbtn(JSPUtil.getParameter(request, prefix + "rbtn", ""));
		setSortDt(JSPUtil.getParameter(request, prefix + "sort_dt", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setActDtDays(JSPUtil.getParameter(request, prefix + "act_dt_days", ""));
		setEdiSts(JSPUtil.getParameter(request, prefix + "edi_sts", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setToadt(JSPUtil.getParameter(request, prefix + "toadt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMissingListVO[]
	 */
	public SearchMissingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMissingListVO[]
	 */
	public SearchMissingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMissingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] gmtDt2 = (JSPUtil.getParameter(request, prefix	+ "gmt_dt2", length));
			String[] gmtDt1 = (JSPUtil.getParameter(request, prefix	+ "gmt_dt1", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] custSts = (JSPUtil.getParameter(request, prefix	+ "cust_sts", length));
			String[] clickday = (JSPUtil.getParameter(request, prefix	+ "clickday", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] missingStatus = (JSPUtil.getParameter(request, prefix	+ "missing_status", length));
			String[] sBlNo = (JSPUtil.getParameter(request, prefix	+ "s_bl_no", length));
			String[] maxEdiSndKnt = (JSPUtil.getParameter(request, prefix	+ "max_edi_snd_knt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] sortSeq = (JSPUtil.getParameter(request, prefix	+ "sort_seq", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] totcnt = (JSPUtil.getParameter(request, prefix	+ "totcnt", length));
			String[] toddt = (JSPUtil.getParameter(request, prefix	+ "toddt", length));
			String[] copsts = (JSPUtil.getParameter(request, prefix	+ "copsts", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] creDt2 = (JSPUtil.getParameter(request, prefix	+ "cre_dt2", length));
			String[] polFromdate = (JSPUtil.getParameter(request, prefix	+ "pol_fromdate", length));
			String[] creDt1 = (JSPUtil.getParameter(request, prefix	+ "cre_dt1", length));
			String[] titleRow = (JSPUtil.getParameter(request, prefix	+ "title_row", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] ediSubStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_sub_sts_cd", length));
			String[] ediSndKnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_knt", length));
			String[] csGrpId = (JSPUtil.getParameter(request, prefix	+ "cs_grp_id", length));
			String[] maxEdiSmdKnt = (JSPUtil.getParameter(request, prefix	+ "max_edi_smd_knt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] actDt2 = (JSPUtil.getParameter(request, prefix	+ "act_dt2", length));
			String[] missingCnt = (JSPUtil.getParameter(request, prefix	+ "missing_cnt", length));
			String[] ediStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_sts_cd", length));
			String[] custSt = (JSPUtil.getParameter(request, prefix	+ "cust_st", length));
			String[] podFromdate = (JSPUtil.getParameter(request, prefix	+ "pod_fromdate", length));
			String[] polTodate = (JSPUtil.getParameter(request, prefix	+ "pol_todate", length));
			String[] podTodate = (JSPUtil.getParameter(request, prefix	+ "pod_todate", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trsMode = (JSPUtil.getParameter(request, prefix	+ "trs_mode", length));
			String[] fromddt = (JSPUtil.getParameter(request, prefix	+ "fromddt", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] actDt1 = (JSPUtil.getParameter(request, prefix	+ "act_dt1", length));
			String[] actDtHours = (JSPUtil.getParameter(request, prefix	+ "act_dt_hours", length));
			String[] fromadt = (JSPUtil.getParameter(request, prefix	+ "fromadt", length));
			String[] rbtn = (JSPUtil.getParameter(request, prefix	+ "rbtn", length));
			String[] sortDt = (JSPUtil.getParameter(request, prefix	+ "sort_dt", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] actDtDays = (JSPUtil.getParameter(request, prefix	+ "act_dt_days", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] toadt = (JSPUtil.getParameter(request, prefix	+ "toadt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMissingListVO();
				if (gmtDt2[i] != null)
					model.setGmtDt2(gmtDt2[i]);
				if (gmtDt1[i] != null)
					model.setGmtDt1(gmtDt1[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (custSts[i] != null)
					model.setCustSts(custSts[i]);
				if (clickday[i] != null)
					model.setClickday(clickday[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (missingStatus[i] != null)
					model.setMissingStatus(missingStatus[i]);
				if (sBlNo[i] != null)
					model.setSBlNo(sBlNo[i]);
				if (maxEdiSndKnt[i] != null)
					model.setMaxEdiSndKnt(maxEdiSndKnt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (sortSeq[i] != null)
					model.setSortSeq(sortSeq[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (totcnt[i] != null)
					model.setTotcnt(totcnt[i]);
				if (toddt[i] != null)
					model.setToddt(toddt[i]);
				if (copsts[i] != null)
					model.setCopsts(copsts[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (creDt2[i] != null)
					model.setCreDt2(creDt2[i]);
				if (polFromdate[i] != null)
					model.setPolFromdate(polFromdate[i]);
				if (creDt1[i] != null)
					model.setCreDt1(creDt1[i]);
				if (titleRow[i] != null)
					model.setTitleRow(titleRow[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (ediSubStsCd[i] != null)
					model.setEdiSubStsCd(ediSubStsCd[i]);
				if (ediSndKnt[i] != null)
					model.setEdiSndKnt(ediSndKnt[i]);
				if (csGrpId[i] != null)
					model.setCsGrpId(csGrpId[i]);
				if (maxEdiSmdKnt[i] != null)
					model.setMaxEdiSmdKnt(maxEdiSmdKnt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (actDt2[i] != null)
					model.setActDt2(actDt2[i]);
				if (missingCnt[i] != null)
					model.setMissingCnt(missingCnt[i]);
				if (ediStsCd[i] != null)
					model.setEdiStsCd(ediStsCd[i]);
				if (custSt[i] != null)
					model.setCustSt(custSt[i]);
				if (podFromdate[i] != null)
					model.setPodFromdate(podFromdate[i]);
				if (polTodate[i] != null)
					model.setPolTodate(polTodate[i]);
				if (podTodate[i] != null)
					model.setPodTodate(podTodate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsMode[i] != null)
					model.setTrsMode(trsMode[i]);
				if (fromddt[i] != null)
					model.setFromddt(fromddt[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (actDt1[i] != null)
					model.setActDt1(actDt1[i]);
				if (actDtHours[i] != null)
					model.setActDtHours(actDtHours[i]);
				if (fromadt[i] != null)
					model.setFromadt(fromadt[i]);
				if (rbtn[i] != null)
					model.setRbtn(rbtn[i]);
				if (sortDt[i] != null)
					model.setSortDt(sortDt[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (actDtDays[i] != null)
					model.setActDtDays(actDtDays[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (toadt[i] != null)
					model.setToadt(toadt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMissingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMissingListVO[]
	 */
	public SearchMissingListVO[] getSearchMissingListVOs(){
		SearchMissingListVO[] vos = (SearchMissingListVO[])models.toArray(new SearchMissingListVO[models.size()]);
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
		this.gmtDt2 = this.gmtDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtDt1 = this.gmtDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSts = this.custSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clickday = this.clickday .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.missingStatus = this.missingStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNo = this.sBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxEdiSndKnt = this.maxEdiSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortSeq = this.sortSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totcnt = this.totcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toddt = this.toddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copsts = this.copsts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt2 = this.creDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFromdate = this.polFromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt1 = this.creDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.titleRow = this.titleRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSubStsCd = this.ediSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndKnt = this.ediSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csGrpId = this.csGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxEdiSmdKnt = this.maxEdiSmdKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt2 = this.actDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.missingCnt = this.missingCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStsCd = this.ediStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSt = this.custSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFromdate = this.podFromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTodate = this.polTodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTodate = this.podTodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsMode = this.trsMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromddt = this.fromddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt1 = this.actDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDtHours = this.actDtHours .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromadt = this.fromadt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rbtn = this.rbtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortDt = this.sortDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDtDays = this.actDtDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toadt = this.toadt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
