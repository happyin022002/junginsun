/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchNotifyFailureCountVO.java
*@FileTitle : SearchNotifyFailureCountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.08.19 김성일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copreport.exceptionreport.vo;

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
 * @author 김성일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchNotifyFailureCountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNotifyFailureCountVO> models = new ArrayList<SearchNotifyFailureCountVO>();
	
	/* Column Info */
	private String tActdt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fmActNm = null;
	/* Column Info */
	private String consignee = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String failFmDt = null;
	/* Column Info */
	private String fAct = null;
	/* Column Info */
	private String logiMail = null;
	/* Column Info */
	private String delayDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String logiGid = null;
	/* Column Info */
	private String custMail = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String toActNm = null;
	/* Column Info */
	private String tAct = null;
	/* Column Info */
	private String urtGid = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String notify = null;
	/* Column Info */
	private String occurFmDt = null;
	/* Column Info */
	private String occrNodCd = null;
	/* Column Info */
	private String iExptType = null;
	/* Column Info */
	private String urtMail = null;
	/* Column Info */
	private String iExptdtlType = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgFmDt = null;
	/* Column Info */
	private String custCntSeq = null;
	/* Column Info */
	private String fActdt = null;
	/* Column Info */
	private String occurToDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String custGid = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String exptNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String occurDt = null;
	/* Column Info */
	private String failToDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNotifyFailureCountVO() {}

	public SearchNotifyFailureCountVO(String ibflag, String pagerows, String totCnt, String exptNo, String bkgNo, String blNo, String copNo, String cntrNo, String iExptType, String iExptdtlType, String shipper, String consignee, String notify, String vvd, String porCd, String polCd, String podCd, String delCd, String occurDt, String creOfcCd, String occrNodCd, String delayDt, String logiGid, String logiMail, String custGid, String custMail, String urtGid, String urtMail, String fAct, String fActdt, String tAct, String tActdt, String fmActNm, String toActNm, String failFmDt, String failToDt, String occurFmDt, String occurToDt, String custCntSeq, String scNo, String bkgFmDt, String bkgToDt) {
		this.tActdt = tActdt;
		this.porCd = porCd;
		this.fmActNm = fmActNm;
		this.consignee = consignee;
		this.copNo = copNo;
		this.failFmDt = failFmDt;
		this.fAct = fAct;
		this.logiMail = logiMail;
		this.delayDt = delayDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.logiGid = logiGid;
		this.custMail = custMail;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.toActNm = toActNm;
		this.tAct = tAct;
		this.urtGid = urtGid;
		this.bkgToDt = bkgToDt;
		this.scNo = scNo;
		this.creOfcCd = creOfcCd;
		this.notify = notify;
		this.occurFmDt = occurFmDt;
		this.occrNodCd = occrNodCd;
		this.iExptType = iExptType;
		this.urtMail = urtMail;
		this.iExptdtlType = iExptdtlType;
		this.totCnt = totCnt;
		this.shipper = shipper;
		this.delCd = delCd;
		this.bkgFmDt = bkgFmDt;
		this.custCntSeq = custCntSeq;
		this.fActdt = fActdt;
		this.occurToDt = occurToDt;
		this.vvd = vvd;
		this.podCd = podCd;
		this.custGid = custGid;
		this.bkgNo = bkgNo;
		this.exptNo = exptNo;
		this.cntrNo = cntrNo;
		this.occurDt = occurDt;
		this.failToDt = failToDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t_actdt", getTActdt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("fm_act_nm", getFmActNm());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("fail_fm_dt", getFailFmDt());
		this.hashColumns.put("f_act", getFAct());
		this.hashColumns.put("logi_mail", getLogiMail());
		this.hashColumns.put("delay_dt", getDelayDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("logi_gid", getLogiGid());
		this.hashColumns.put("cust_mail", getCustMail());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("to_act_nm", getToActNm());
		this.hashColumns.put("t_act", getTAct());
		this.hashColumns.put("urt_gid", getUrtGid());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("notify", getNotify());
		this.hashColumns.put("occur_fm_dt", getOccurFmDt());
		this.hashColumns.put("occr_nod_cd", getOccrNodCd());
		this.hashColumns.put("i_expt_type", getIExptType());
		this.hashColumns.put("urt_mail", getUrtMail());
		this.hashColumns.put("i_exptdtl_type", getIExptdtlType());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_fm_dt", getBkgFmDt());
		this.hashColumns.put("cust_cnt_seq", getCustCntSeq());
		this.hashColumns.put("f_actdt", getFActdt());
		this.hashColumns.put("occur_to_dt", getOccurToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cust_gid", getCustGid());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("expt_no", getExptNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("occur_dt", getOccurDt());
		this.hashColumns.put("fail_to_dt", getFailToDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t_actdt", "tActdt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("fm_act_nm", "fmActNm");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("fail_fm_dt", "failFmDt");
		this.hashFields.put("f_act", "fAct");
		this.hashFields.put("logi_mail", "logiMail");
		this.hashFields.put("delay_dt", "delayDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("logi_gid", "logiGid");
		this.hashFields.put("cust_mail", "custMail");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("to_act_nm", "toActNm");
		this.hashFields.put("t_act", "tAct");
		this.hashFields.put("urt_gid", "urtGid");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("notify", "notify");
		this.hashFields.put("occur_fm_dt", "occurFmDt");
		this.hashFields.put("occr_nod_cd", "occrNodCd");
		this.hashFields.put("i_expt_type", "iExptType");
		this.hashFields.put("urt_mail", "urtMail");
		this.hashFields.put("i_exptdtl_type", "iExptdtlType");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_fm_dt", "bkgFmDt");
		this.hashFields.put("cust_cnt_seq", "custCntSeq");
		this.hashFields.put("f_actdt", "fActdt");
		this.hashFields.put("occur_to_dt", "occurToDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cust_gid", "custGid");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("expt_no", "exptNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("occur_dt", "occurDt");
		this.hashFields.put("fail_to_dt", "failToDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tActdt
	 */
	public String getTActdt() {
		return this.tActdt;
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
	 * @return fmActNm
	 */
	public String getFmActNm() {
		return this.fmActNm;
	}
	
	/**
	 * Column Info
	 * @return consignee
	 */
	public String getConsignee() {
		return this.consignee;
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
	 * @return failFmDt
	 */
	public String getFailFmDt() {
		return this.failFmDt;
	}
	
	/**
	 * Column Info
	 * @return fAct
	 */
	public String getFAct() {
		return this.fAct;
	}
	
	/**
	 * Column Info
	 * @return logiMail
	 */
	public String getLogiMail() {
		return this.logiMail;
	}
	
	/**
	 * Column Info
	 * @return delayDt
	 */
	public String getDelayDt() {
		return this.delayDt;
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
	 * @return logiGid
	 */
	public String getLogiGid() {
		return this.logiGid;
	}
	
	/**
	 * Column Info
	 * @return custMail
	 */
	public String getCustMail() {
		return this.custMail;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return toActNm
	 */
	public String getToActNm() {
		return this.toActNm;
	}
	
	/**
	 * Column Info
	 * @return tAct
	 */
	public String getTAct() {
		return this.tAct;
	}
	
	/**
	 * Column Info
	 * @return urtGid
	 */
	public String getUrtGid() {
		return this.urtGid;
	}
	
	/**
	 * Column Info
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return notify
	 */
	public String getNotify() {
		return this.notify;
	}
	
	/**
	 * Column Info
	 * @return occurFmDt
	 */
	public String getOccurFmDt() {
		return this.occurFmDt;
	}
	
	/**
	 * Column Info
	 * @return occrNodCd
	 */
	public String getOccrNodCd() {
		return this.occrNodCd;
	}
	
	/**
	 * Column Info
	 * @return iExptType
	 */
	public String getIExptType() {
		return this.iExptType;
	}
	
	/**
	 * Column Info
	 * @return urtMail
	 */
	public String getUrtMail() {
		return this.urtMail;
	}
	
	/**
	 * Column Info
	 * @return iExptdtlType
	 */
	public String getIExptdtlType() {
		return this.iExptdtlType;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
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
	 * @return bkgFmDt
	 */
	public String getBkgFmDt() {
		return this.bkgFmDt;
	}
	
	/**
	 * Column Info
	 * @return custCntSeq
	 */
	public String getCustCntSeq() {
		return this.custCntSeq;
	}
	
	/**
	 * Column Info
	 * @return fActdt
	 */
	public String getFActdt() {
		return this.fActdt;
	}
	
	/**
	 * Column Info
	 * @return occurToDt
	 */
	public String getOccurToDt() {
		return this.occurToDt;
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
	 * @return custGid
	 */
	public String getCustGid() {
		return this.custGid;
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
	 * @return exptNo
	 */
	public String getExptNo() {
		return this.exptNo;
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
	 * @return occurDt
	 */
	public String getOccurDt() {
		return this.occurDt;
	}
	
	/**
	 * Column Info
	 * @return failToDt
	 */
	public String getFailToDt() {
		return this.failToDt;
	}
	

	/**
	 * Column Info
	 * @param tActdt
	 */
	public void setTActdt(String tActdt) {
		this.tActdt = tActdt;
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
	 * @param fmActNm
	 */
	public void setFmActNm(String fmActNm) {
		this.fmActNm = fmActNm;
	}
	
	/**
	 * Column Info
	 * @param consignee
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
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
	 * @param failFmDt
	 */
	public void setFailFmDt(String failFmDt) {
		this.failFmDt = failFmDt;
	}
	
	/**
	 * Column Info
	 * @param fAct
	 */
	public void setFAct(String fAct) {
		this.fAct = fAct;
	}
	
	/**
	 * Column Info
	 * @param logiMail
	 */
	public void setLogiMail(String logiMail) {
		this.logiMail = logiMail;
	}
	
	/**
	 * Column Info
	 * @param delayDt
	 */
	public void setDelayDt(String delayDt) {
		this.delayDt = delayDt;
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
	 * @param logiGid
	 */
	public void setLogiGid(String logiGid) {
		this.logiGid = logiGid;
	}
	
	/**
	 * Column Info
	 * @param custMail
	 */
	public void setCustMail(String custMail) {
		this.custMail = custMail;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param toActNm
	 */
	public void setToActNm(String toActNm) {
		this.toActNm = toActNm;
	}
	
	/**
	 * Column Info
	 * @param tAct
	 */
	public void setTAct(String tAct) {
		this.tAct = tAct;
	}
	
	/**
	 * Column Info
	 * @param urtGid
	 */
	public void setUrtGid(String urtGid) {
		this.urtGid = urtGid;
	}
	
	/**
	 * Column Info
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param notify
	 */
	public void setNotify(String notify) {
		this.notify = notify;
	}
	
	/**
	 * Column Info
	 * @param occurFmDt
	 */
	public void setOccurFmDt(String occurFmDt) {
		this.occurFmDt = occurFmDt;
	}
	
	/**
	 * Column Info
	 * @param occrNodCd
	 */
	public void setOccrNodCd(String occrNodCd) {
		this.occrNodCd = occrNodCd;
	}
	
	/**
	 * Column Info
	 * @param iExptType
	 */
	public void setIExptType(String iExptType) {
		this.iExptType = iExptType;
	}
	
	/**
	 * Column Info
	 * @param urtMail
	 */
	public void setUrtMail(String urtMail) {
		this.urtMail = urtMail;
	}
	
	/**
	 * Column Info
	 * @param iExptdtlType
	 */
	public void setIExptdtlType(String iExptdtlType) {
		this.iExptdtlType = iExptdtlType;
	}
	
	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
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
	 * @param bkgFmDt
	 */
	public void setBkgFmDt(String bkgFmDt) {
		this.bkgFmDt = bkgFmDt;
	}
	
	/**
	 * Column Info
	 * @param custCntSeq
	 */
	public void setCustCntSeq(String custCntSeq) {
		this.custCntSeq = custCntSeq;
	}
	
	/**
	 * Column Info
	 * @param fActdt
	 */
	public void setFActdt(String fActdt) {
		this.fActdt = fActdt;
	}
	
	/**
	 * Column Info
	 * @param occurToDt
	 */
	public void setOccurToDt(String occurToDt) {
		this.occurToDt = occurToDt;
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
	 * @param custGid
	 */
	public void setCustGid(String custGid) {
		this.custGid = custGid;
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
	 * @param exptNo
	 */
	public void setExptNo(String exptNo) {
		this.exptNo = exptNo;
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
	 * @param occurDt
	 */
	public void setOccurDt(String occurDt) {
		this.occurDt = occurDt;
	}
	
	/**
	 * Column Info
	 * @param failToDt
	 */
	public void setFailToDt(String failToDt) {
		this.failToDt = failToDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTActdt(JSPUtil.getParameter(request, "t_actdt", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setFmActNm(JSPUtil.getParameter(request, "fm_act_nm", ""));
		setConsignee(JSPUtil.getParameter(request, "consignee", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setFailFmDt(JSPUtil.getParameter(request, "fail_fm_dt", ""));
		setFAct(JSPUtil.getParameter(request, "f_act", ""));
		setLogiMail(JSPUtil.getParameter(request, "logi_mail", ""));
		setDelayDt(JSPUtil.getParameter(request, "delay_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLogiGid(JSPUtil.getParameter(request, "logi_gid", ""));
		setCustMail(JSPUtil.getParameter(request, "cust_mail", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setToActNm(JSPUtil.getParameter(request, "to_act_nm", ""));
		setTAct(JSPUtil.getParameter(request, "t_act", ""));
		setUrtGid(JSPUtil.getParameter(request, "urt_gid", ""));
		setBkgToDt(JSPUtil.getParameter(request, "bkg_to_dt", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setNotify(JSPUtil.getParameter(request, "notify", ""));
		setOccurFmDt(JSPUtil.getParameter(request, "occur_fm_dt", ""));
		setOccrNodCd(JSPUtil.getParameter(request, "occr_nod_cd", ""));
		setIExptType(JSPUtil.getParameter(request, "i_expt_type", ""));
		setUrtMail(JSPUtil.getParameter(request, "urt_mail", ""));
		setIExptdtlType(JSPUtil.getParameter(request, "i_exptdtl_type", ""));
		setTotCnt(JSPUtil.getParameter(request, "tot_cnt", ""));
		setShipper(JSPUtil.getParameter(request, "shipper", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBkgFmDt(JSPUtil.getParameter(request, "bkg_fm_dt", ""));
		setCustCntSeq(JSPUtil.getParameter(request, "cust_cnt_seq", ""));
		setFActdt(JSPUtil.getParameter(request, "f_actdt", ""));
		setOccurToDt(JSPUtil.getParameter(request, "occur_to_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCustGid(JSPUtil.getParameter(request, "cust_gid", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setExptNo(JSPUtil.getParameter(request, "expt_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOccurDt(JSPUtil.getParameter(request, "occur_dt", ""));
		setFailToDt(JSPUtil.getParameter(request, "fail_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNotifyFailureCountVO[]
	 */
	public SearchNotifyFailureCountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNotifyFailureCountVO[]
	 */
	public SearchNotifyFailureCountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNotifyFailureCountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tActdt = (JSPUtil.getParameter(request, prefix	+ "t_actdt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fmActNm = (JSPUtil.getParameter(request, prefix	+ "fm_act_nm", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] failFmDt = (JSPUtil.getParameter(request, prefix	+ "fail_fm_dt", length));
			String[] fAct = (JSPUtil.getParameter(request, prefix	+ "f_act", length));
			String[] logiMail = (JSPUtil.getParameter(request, prefix	+ "logi_mail", length));
			String[] delayDt = (JSPUtil.getParameter(request, prefix	+ "delay_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] logiGid = (JSPUtil.getParameter(request, prefix	+ "logi_gid", length));
			String[] custMail = (JSPUtil.getParameter(request, prefix	+ "cust_mail", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] toActNm = (JSPUtil.getParameter(request, prefix	+ "to_act_nm", length));
			String[] tAct = (JSPUtil.getParameter(request, prefix	+ "t_act", length));
			String[] urtGid = (JSPUtil.getParameter(request, prefix	+ "urt_gid", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] notify = (JSPUtil.getParameter(request, prefix	+ "notify", length));
			String[] occurFmDt = (JSPUtil.getParameter(request, prefix	+ "occur_fm_dt", length));
			String[] occrNodCd = (JSPUtil.getParameter(request, prefix	+ "occr_nod_cd", length));
			String[] iExptType = (JSPUtil.getParameter(request, prefix	+ "i_expt_type", length));
			String[] urtMail = (JSPUtil.getParameter(request, prefix	+ "urt_mail", length));
			String[] iExptdtlType = (JSPUtil.getParameter(request, prefix	+ "i_exptdtl_type", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgFmDt = (JSPUtil.getParameter(request, prefix	+ "bkg_fm_dt", length));
			String[] custCntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_seq", length));
			String[] fActdt = (JSPUtil.getParameter(request, prefix	+ "f_actdt", length));
			String[] occurToDt = (JSPUtil.getParameter(request, prefix	+ "occur_to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] custGid = (JSPUtil.getParameter(request, prefix	+ "cust_gid", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] exptNo = (JSPUtil.getParameter(request, prefix	+ "expt_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] occurDt = (JSPUtil.getParameter(request, prefix	+ "occur_dt", length));
			String[] failToDt = (JSPUtil.getParameter(request, prefix	+ "fail_to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNotifyFailureCountVO();
				if (tActdt[i] != null)
					model.setTActdt(tActdt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fmActNm[i] != null)
					model.setFmActNm(fmActNm[i]);
				if (consignee[i] != null)
					model.setConsignee(consignee[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (failFmDt[i] != null)
					model.setFailFmDt(failFmDt[i]);
				if (fAct[i] != null)
					model.setFAct(fAct[i]);
				if (logiMail[i] != null)
					model.setLogiMail(logiMail[i]);
				if (delayDt[i] != null)
					model.setDelayDt(delayDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (logiGid[i] != null)
					model.setLogiGid(logiGid[i]);
				if (custMail[i] != null)
					model.setCustMail(custMail[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (toActNm[i] != null)
					model.setToActNm(toActNm[i]);
				if (tAct[i] != null)
					model.setTAct(tAct[i]);
				if (urtGid[i] != null)
					model.setUrtGid(urtGid[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (notify[i] != null)
					model.setNotify(notify[i]);
				if (occurFmDt[i] != null)
					model.setOccurFmDt(occurFmDt[i]);
				if (occrNodCd[i] != null)
					model.setOccrNodCd(occrNodCd[i]);
				if (iExptType[i] != null)
					model.setIExptType(iExptType[i]);
				if (urtMail[i] != null)
					model.setUrtMail(urtMail[i]);
				if (iExptdtlType[i] != null)
					model.setIExptdtlType(iExptdtlType[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgFmDt[i] != null)
					model.setBkgFmDt(bkgFmDt[i]);
				if (custCntSeq[i] != null)
					model.setCustCntSeq(custCntSeq[i]);
				if (fActdt[i] != null)
					model.setFActdt(fActdt[i]);
				if (occurToDt[i] != null)
					model.setOccurToDt(occurToDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (custGid[i] != null)
					model.setCustGid(custGid[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (exptNo[i] != null)
					model.setExptNo(exptNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (occurDt[i] != null)
					model.setOccurDt(occurDt[i]);
				if (failToDt[i] != null)
					model.setFailToDt(failToDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNotifyFailureCountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNotifyFailureCountVO[]
	 */
	public SearchNotifyFailureCountVO[] getSearchNotifyFailureCountVOs(){
		SearchNotifyFailureCountVO[] vos = (SearchNotifyFailureCountVO[])models.toArray(new SearchNotifyFailureCountVO[models.size()]);
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
		this.tActdt = this.tActdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmActNm = this.fmActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.failFmDt = this.failFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAct = this.fAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logiMail = this.logiMail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delayDt = this.delayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logiGid = this.logiGid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custMail = this.custMail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toActNm = this.toActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tAct = this.tAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urtGid = this.urtGid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notify = this.notify .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occurFmDt = this.occurFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occrNodCd = this.occrNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iExptType = this.iExptType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urtMail = this.urtMail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iExptdtlType = this.iExptdtlType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFmDt = this.bkgFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntSeq = this.custCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fActdt = this.fActdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occurToDt = this.occurToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGid = this.custGid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptNo = this.exptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occurDt = this.occurDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.failToDt = this.failToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
