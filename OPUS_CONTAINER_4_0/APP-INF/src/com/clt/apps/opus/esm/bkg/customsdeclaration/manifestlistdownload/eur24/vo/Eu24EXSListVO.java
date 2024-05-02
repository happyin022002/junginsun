/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eu24EXSListVO.java
*@FileTitle : Eu24EXSListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.30
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.30 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

import java.lang.reflect.Field;
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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eu24EXSListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eu24EXSListVO> models = new ArrayList<Eu24EXSListVO>();
	
	/* Column Info */
	private String relsBlCnt = null;
	/* Column Info */
	private String pFromMt = null;
	/* Column Info */
	private String exsSntRels = null;
	/* Column Info */
	private String exsSntRejt = null;
	/* Column Info */
	private String nrcvBlCnt = null;
	/* Column Info */
	private String sentBlCnt = null;
	/* Column Info */
	private String exsUnsntCnt = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgPol = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blTotCnt = null;
	/* Column Info */
	private String totalVvdCnt = null;
	/* Column Info */
	private String rejBlCnt = null;
	/* Column Info */
	private String accBlCnt = null;
	/* Column Info */
	private String condLane = null;
	/* Column Info */
	private String exsSntHold = null;
	/* Column Info */
	private String unsentBlCnt = null;
	/* Column Info */
	private String pBOfcCd = null;
	/* Column Info */
	private String pRhqGb = null;
	/* Column Info */
	private String pVvd = null;
	/* Column Info */
	private String totalAmdCnt = null;
	/* Column Info */
	private String exsSntCnt = null;
	/* Column Info */
	private String euPol = null;
	/* Column Info */
	private String pToDt = null;
	/* Column Info */
	private String pToMt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String exsSntNrcv = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String holdBlCnt = null;
	/* Column Info */
	private String pPol = null;
	/* Column Info */
	private String exsAmdCnt = null;
	/* Column Info */
	private String pFromDt = null;
	/* Column Info */
	private String totalBlCnt = null;
	/* Column Info */
	private String donldBlCnt = null;
	/* Column Info */
	private String exsSntDonl = null;
	/* Column Info */
	private String exsSntAccp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eu24EXSListVO() {}

	public Eu24EXSListVO(String ibflag, String pagerows, String vvd, String lane, String euPol, String bkgPol, String ofcCd, String blTotCnt, String exsSntCnt, String exsSntAccp, String exsSntRejt, String exsSntDonl, String exsSntNrcv, String exsSntHold, String exsSntRels, String exsUnsntCnt, String exsAmdCnt, String sentBlCnt, String accBlCnt, String rejBlCnt, String donldBlCnt, String nrcvBlCnt, String holdBlCnt, String relsBlCnt, String unsentBlCnt, String totalBlCnt, String totalVvdCnt, String totalAmdCnt, String pFromDt, String pFromMt, String pToDt, String pToMt, String pPol, String pBOfcCd, String pRhqGb, String pVvd, String condLane) {
		this.relsBlCnt = relsBlCnt;
		this.pFromMt = pFromMt;
		this.exsSntRels = exsSntRels;
		this.exsSntRejt = exsSntRejt;
		this.nrcvBlCnt = nrcvBlCnt;
		this.sentBlCnt = sentBlCnt;
		this.exsUnsntCnt = exsUnsntCnt;
		this.lane = lane;
		this.pagerows = pagerows;
		this.bkgPol = bkgPol;
		this.ibflag = ibflag;
		this.blTotCnt = blTotCnt;
		this.totalVvdCnt = totalVvdCnt;
		this.rejBlCnt = rejBlCnt;
		this.accBlCnt = accBlCnt;
		this.condLane = condLane;
		this.exsSntHold = exsSntHold;
		this.unsentBlCnt = unsentBlCnt;
		this.pBOfcCd = pBOfcCd;
		this.pRhqGb = pRhqGb;
		this.pVvd = pVvd;
		this.totalAmdCnt = totalAmdCnt;
		this.exsSntCnt = exsSntCnt;
		this.euPol = euPol;
		this.pToDt = pToDt;
		this.pToMt = pToMt;
		this.vvd = vvd;
		this.exsSntNrcv = exsSntNrcv;
		this.ofcCd = ofcCd;
		this.holdBlCnt = holdBlCnt;
		this.pPol = pPol;
		this.exsAmdCnt = exsAmdCnt;
		this.pFromDt = pFromDt;
		this.totalBlCnt = totalBlCnt;
		this.donldBlCnt = donldBlCnt;
		this.exsSntDonl = exsSntDonl;
		this.exsSntAccp = exsSntAccp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rels_bl_cnt", getRelsBlCnt());
		this.hashColumns.put("p_from_mt", getPFromMt());
		this.hashColumns.put("exs_snt_rels", getExsSntRels());
		this.hashColumns.put("exs_snt_rejt", getExsSntRejt());
		this.hashColumns.put("nrcv_bl_cnt", getNrcvBlCnt());
		this.hashColumns.put("sent_bl_cnt", getSentBlCnt());
		this.hashColumns.put("exs_unsnt_cnt", getExsUnsntCnt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_pol", getBkgPol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_tot_cnt", getBlTotCnt());
		this.hashColumns.put("total_vvd_cnt", getTotalVvdCnt());
		this.hashColumns.put("rej_bl_cnt", getRejBlCnt());
		this.hashColumns.put("acc_bl_cnt", getAccBlCnt());
		this.hashColumns.put("cond_lane", getCondLane());
		this.hashColumns.put("exs_snt_hold", getExsSntHold());
		this.hashColumns.put("unsent_bl_cnt", getUnsentBlCnt());
		this.hashColumns.put("p_b_ofc_cd", getPBOfcCd());
		this.hashColumns.put("p_rhq_gb", getPRhqGb());
		this.hashColumns.put("p_vvd", getPVvd());
		this.hashColumns.put("total_amd_cnt", getTotalAmdCnt());
		this.hashColumns.put("exs_snt_cnt", getExsSntCnt());
		this.hashColumns.put("eu_pol", getEuPol());
		this.hashColumns.put("p_to_dt", getPToDt());
		this.hashColumns.put("p_to_mt", getPToMt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("exs_snt_nrcv", getExsSntNrcv());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("hold_bl_cnt", getHoldBlCnt());
		this.hashColumns.put("p_pol", getPPol());
		this.hashColumns.put("exs_amd_cnt", getExsAmdCnt());
		this.hashColumns.put("p_from_dt", getPFromDt());
		this.hashColumns.put("total_bl_cnt", getTotalBlCnt());
		this.hashColumns.put("donld_bl_cnt", getDonldBlCnt());
		this.hashColumns.put("exs_snt_donl", getExsSntDonl());
		this.hashColumns.put("exs_snt_accp", getExsSntAccp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rels_bl_cnt", "relsBlCnt");
		this.hashFields.put("p_from_mt", "pFromMt");
		this.hashFields.put("exs_snt_rels", "exsSntRels");
		this.hashFields.put("exs_snt_rejt", "exsSntRejt");
		this.hashFields.put("nrcv_bl_cnt", "nrcvBlCnt");
		this.hashFields.put("sent_bl_cnt", "sentBlCnt");
		this.hashFields.put("exs_unsnt_cnt", "exsUnsntCnt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_pol", "bkgPol");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_tot_cnt", "blTotCnt");
		this.hashFields.put("total_vvd_cnt", "totalVvdCnt");
		this.hashFields.put("rej_bl_cnt", "rejBlCnt");
		this.hashFields.put("acc_bl_cnt", "accBlCnt");
		this.hashFields.put("cond_lane", "condLane");
		this.hashFields.put("exs_snt_hold", "exsSntHold");
		this.hashFields.put("unsent_bl_cnt", "unsentBlCnt");
		this.hashFields.put("p_b_ofc_cd", "pBOfcCd");
		this.hashFields.put("p_rhq_gb", "pRhqGb");
		this.hashFields.put("p_vvd", "pVvd");
		this.hashFields.put("total_amd_cnt", "totalAmdCnt");
		this.hashFields.put("exs_snt_cnt", "exsSntCnt");
		this.hashFields.put("eu_pol", "euPol");
		this.hashFields.put("p_to_dt", "pToDt");
		this.hashFields.put("p_to_mt", "pToMt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("exs_snt_nrcv", "exsSntNrcv");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("hold_bl_cnt", "holdBlCnt");
		this.hashFields.put("p_pol", "pPol");
		this.hashFields.put("exs_amd_cnt", "exsAmdCnt");
		this.hashFields.put("p_from_dt", "pFromDt");
		this.hashFields.put("total_bl_cnt", "totalBlCnt");
		this.hashFields.put("donld_bl_cnt", "donldBlCnt");
		this.hashFields.put("exs_snt_donl", "exsSntDonl");
		this.hashFields.put("exs_snt_accp", "exsSntAccp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return relsBlCnt
	 */
	public String getRelsBlCnt() {
		return this.relsBlCnt;
	}
	
	/**
	 * Column Info
	 * @return pFromMt
	 */
	public String getPFromMt() {
		return this.pFromMt;
	}
	
	/**
	 * Column Info
	 * @return exsSntRels
	 */
	public String getExsSntRels() {
		return this.exsSntRels;
	}
	
	/**
	 * Column Info
	 * @return exsSntRejt
	 */
	public String getExsSntRejt() {
		return this.exsSntRejt;
	}
	
	/**
	 * Column Info
	 * @return nrcvBlCnt
	 */
	public String getNrcvBlCnt() {
		return this.nrcvBlCnt;
	}
	
	/**
	 * Column Info
	 * @return sentBlCnt
	 */
	public String getSentBlCnt() {
		return this.sentBlCnt;
	}
	
	/**
	 * Column Info
	 * @return exsUnsntCnt
	 */
	public String getExsUnsntCnt() {
		return this.exsUnsntCnt;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return bkgPol
	 */
	public String getBkgPol() {
		return this.bkgPol;
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
	 * @return blTotCnt
	 */
	public String getBlTotCnt() {
		return this.blTotCnt;
	}
	
	/**
	 * Column Info
	 * @return totalVvdCnt
	 */
	public String getTotalVvdCnt() {
		return this.totalVvdCnt;
	}
	
	/**
	 * Column Info
	 * @return rejBlCnt
	 */
	public String getRejBlCnt() {
		return this.rejBlCnt;
	}
	
	/**
	 * Column Info
	 * @return accBlCnt
	 */
	public String getAccBlCnt() {
		return this.accBlCnt;
	}
	
	/**
	 * Column Info
	 * @return condLane
	 */
	public String getCondLane() {
		return this.condLane;
	}
	
	/**
	 * Column Info
	 * @return exsSntHold
	 */
	public String getExsSntHold() {
		return this.exsSntHold;
	}
	
	/**
	 * Column Info
	 * @return unsentBlCnt
	 */
	public String getUnsentBlCnt() {
		return this.unsentBlCnt;
	}
	
	/**
	 * Column Info
	 * @return pBOfcCd
	 */
	public String getPBOfcCd() {
		return this.pBOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pRhqGb
	 */
	public String getPRhqGb() {
		return this.pRhqGb;
	}
	
	/**
	 * Column Info
	 * @return pVvd
	 */
	public String getPVvd() {
		return this.pVvd;
	}
	
	/**
	 * Column Info
	 * @return totalAmdCnt
	 */
	public String getTotalAmdCnt() {
		return this.totalAmdCnt;
	}
	
	/**
	 * Column Info
	 * @return exsSntCnt
	 */
	public String getExsSntCnt() {
		return this.exsSntCnt;
	}
	
	/**
	 * Column Info
	 * @return euPol
	 */
	public String getEuPol() {
		return this.euPol;
	}
	
	/**
	 * Column Info
	 * @return pToDt
	 */
	public String getPToDt() {
		return this.pToDt;
	}
	
	/**
	 * Column Info
	 * @return pToMt
	 */
	public String getPToMt() {
		return this.pToMt;
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
	 * @return exsSntNrcv
	 */
	public String getExsSntNrcv() {
		return this.exsSntNrcv;
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
	 * @return holdBlCnt
	 */
	public String getHoldBlCnt() {
		return this.holdBlCnt;
	}
	
	/**
	 * Column Info
	 * @return pPol
	 */
	public String getPPol() {
		return this.pPol;
	}
	
	/**
	 * Column Info
	 * @return exsAmdCnt
	 */
	public String getExsAmdCnt() {
		return this.exsAmdCnt;
	}
	
	/**
	 * Column Info
	 * @return pFromDt
	 */
	public String getPFromDt() {
		return this.pFromDt;
	}
	
	/**
	 * Column Info
	 * @return totalBlCnt
	 */
	public String getTotalBlCnt() {
		return this.totalBlCnt;
	}
	
	/**
	 * Column Info
	 * @return donldBlCnt
	 */
	public String getDonldBlCnt() {
		return this.donldBlCnt;
	}
	
	/**
	 * Column Info
	 * @return exsSntDonl
	 */
	public String getExsSntDonl() {
		return this.exsSntDonl;
	}
	
	/**
	 * Column Info
	 * @return exsSntAccp
	 */
	public String getExsSntAccp() {
		return this.exsSntAccp;
	}
	

	/**
	 * Column Info
	 * @param relsBlCnt
	 */
	public void setRelsBlCnt(String relsBlCnt) {
		this.relsBlCnt = relsBlCnt;
	}
	
	/**
	 * Column Info
	 * @param pFromMt
	 */
	public void setPFromMt(String pFromMt) {
		this.pFromMt = pFromMt;
	}
	
	/**
	 * Column Info
	 * @param exsSntRels
	 */
	public void setExsSntRels(String exsSntRels) {
		this.exsSntRels = exsSntRels;
	}
	
	/**
	 * Column Info
	 * @param exsSntRejt
	 */
	public void setExsSntRejt(String exsSntRejt) {
		this.exsSntRejt = exsSntRejt;
	}
	
	/**
	 * Column Info
	 * @param nrcvBlCnt
	 */
	public void setNrcvBlCnt(String nrcvBlCnt) {
		this.nrcvBlCnt = nrcvBlCnt;
	}
	
	/**
	 * Column Info
	 * @param sentBlCnt
	 */
	public void setSentBlCnt(String sentBlCnt) {
		this.sentBlCnt = sentBlCnt;
	}
	
	/**
	 * Column Info
	 * @param exsUnsntCnt
	 */
	public void setExsUnsntCnt(String exsUnsntCnt) {
		this.exsUnsntCnt = exsUnsntCnt;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param bkgPol
	 */
	public void setBkgPol(String bkgPol) {
		this.bkgPol = bkgPol;
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
	 * @param blTotCnt
	 */
	public void setBlTotCnt(String blTotCnt) {
		this.blTotCnt = blTotCnt;
	}
	
	/**
	 * Column Info
	 * @param totalVvdCnt
	 */
	public void setTotalVvdCnt(String totalVvdCnt) {
		this.totalVvdCnt = totalVvdCnt;
	}
	
	/**
	 * Column Info
	 * @param rejBlCnt
	 */
	public void setRejBlCnt(String rejBlCnt) {
		this.rejBlCnt = rejBlCnt;
	}
	
	/**
	 * Column Info
	 * @param accBlCnt
	 */
	public void setAccBlCnt(String accBlCnt) {
		this.accBlCnt = accBlCnt;
	}
	
	/**
	 * Column Info
	 * @param condLane
	 */
	public void setCondLane(String condLane) {
		this.condLane = condLane;
	}
	
	/**
	 * Column Info
	 * @param exsSntHold
	 */
	public void setExsSntHold(String exsSntHold) {
		this.exsSntHold = exsSntHold;
	}
	
	/**
	 * Column Info
	 * @param unsentBlCnt
	 */
	public void setUnsentBlCnt(String unsentBlCnt) {
		this.unsentBlCnt = unsentBlCnt;
	}
	
	/**
	 * Column Info
	 * @param pBOfcCd
	 */
	public void setPBOfcCd(String pBOfcCd) {
		this.pBOfcCd = pBOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pRhqGb
	 */
	public void setPRhqGb(String pRhqGb) {
		this.pRhqGb = pRhqGb;
	}
	
	/**
	 * Column Info
	 * @param pVvd
	 */
	public void setPVvd(String pVvd) {
		this.pVvd = pVvd;
	}
	
	/**
	 * Column Info
	 * @param totalAmdCnt
	 */
	public void setTotalAmdCnt(String totalAmdCnt) {
		this.totalAmdCnt = totalAmdCnt;
	}
	
	/**
	 * Column Info
	 * @param exsSntCnt
	 */
	public void setExsSntCnt(String exsSntCnt) {
		this.exsSntCnt = exsSntCnt;
	}
	
	/**
	 * Column Info
	 * @param euPol
	 */
	public void setEuPol(String euPol) {
		this.euPol = euPol;
	}
	
	/**
	 * Column Info
	 * @param pToDt
	 */
	public void setPToDt(String pToDt) {
		this.pToDt = pToDt;
	}
	
	/**
	 * Column Info
	 * @param pToMt
	 */
	public void setPToMt(String pToMt) {
		this.pToMt = pToMt;
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
	 * @param exsSntNrcv
	 */
	public void setExsSntNrcv(String exsSntNrcv) {
		this.exsSntNrcv = exsSntNrcv;
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
	 * @param holdBlCnt
	 */
	public void setHoldBlCnt(String holdBlCnt) {
		this.holdBlCnt = holdBlCnt;
	}
	
	/**
	 * Column Info
	 * @param pPol
	 */
	public void setPPol(String pPol) {
		this.pPol = pPol;
	}
	
	/**
	 * Column Info
	 * @param exsAmdCnt
	 */
	public void setExsAmdCnt(String exsAmdCnt) {
		this.exsAmdCnt = exsAmdCnt;
	}
	
	/**
	 * Column Info
	 * @param pFromDt
	 */
	public void setPFromDt(String pFromDt) {
		this.pFromDt = pFromDt;
	}
	
	/**
	 * Column Info
	 * @param totalBlCnt
	 */
	public void setTotalBlCnt(String totalBlCnt) {
		this.totalBlCnt = totalBlCnt;
	}
	
	/**
	 * Column Info
	 * @param donldBlCnt
	 */
	public void setDonldBlCnt(String donldBlCnt) {
		this.donldBlCnt = donldBlCnt;
	}
	
	/**
	 * Column Info
	 * @param exsSntDonl
	 */
	public void setExsSntDonl(String exsSntDonl) {
		this.exsSntDonl = exsSntDonl;
	}
	
	/**
	 * Column Info
	 * @param exsSntAccp
	 */
	public void setExsSntAccp(String exsSntAccp) {
		this.exsSntAccp = exsSntAccp;
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
		setRelsBlCnt(JSPUtil.getParameter(request, prefix + "rels_bl_cnt", ""));
		setPFromMt(JSPUtil.getParameter(request, prefix + "p_from_mt", ""));
		setExsSntRels(JSPUtil.getParameter(request, prefix + "exs_snt_rels", ""));
		setExsSntRejt(JSPUtil.getParameter(request, prefix + "exs_snt_rejt", ""));
		setNrcvBlCnt(JSPUtil.getParameter(request, prefix + "nrcv_bl_cnt", ""));
		setSentBlCnt(JSPUtil.getParameter(request, prefix + "sent_bl_cnt", ""));
		setExsUnsntCnt(JSPUtil.getParameter(request, prefix + "exs_unsnt_cnt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgPol(JSPUtil.getParameter(request, prefix + "bkg_pol", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlTotCnt(JSPUtil.getParameter(request, prefix + "bl_tot_cnt", ""));
		setTotalVvdCnt(JSPUtil.getParameter(request, prefix + "total_vvd_cnt", ""));
		setRejBlCnt(JSPUtil.getParameter(request, prefix + "rej_bl_cnt", ""));
		setAccBlCnt(JSPUtil.getParameter(request, prefix + "acc_bl_cnt", ""));
		setCondLane(JSPUtil.getParameter(request, prefix + "cond_lane", ""));
		setExsSntHold(JSPUtil.getParameter(request, prefix + "exs_snt_hold", ""));
		setUnsentBlCnt(JSPUtil.getParameter(request, prefix + "unsent_bl_cnt", ""));
		setPBOfcCd(JSPUtil.getParameter(request, prefix + "p_b_ofc_cd", ""));
		setPRhqGb(JSPUtil.getParameter(request, prefix + "p_rhq_gb", ""));
		setPVvd(JSPUtil.getParameter(request, prefix + "p_vvd", ""));
		setTotalAmdCnt(JSPUtil.getParameter(request, prefix + "total_amd_cnt", ""));
		setExsSntCnt(JSPUtil.getParameter(request, prefix + "exs_snt_cnt", ""));
		setEuPol(JSPUtil.getParameter(request, prefix + "eu_pol", ""));
		setPToDt(JSPUtil.getParameter(request, prefix + "p_to_dt", ""));
		setPToMt(JSPUtil.getParameter(request, prefix + "p_to_mt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setExsSntNrcv(JSPUtil.getParameter(request, prefix + "exs_snt_nrcv", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setHoldBlCnt(JSPUtil.getParameter(request, prefix + "hold_bl_cnt", ""));
		setPPol(JSPUtil.getParameter(request, prefix + "p_pol", ""));
		setExsAmdCnt(JSPUtil.getParameter(request, prefix + "exs_amd_cnt", ""));
		setPFromDt(JSPUtil.getParameter(request, prefix + "p_from_dt", ""));
		setTotalBlCnt(JSPUtil.getParameter(request, prefix + "total_bl_cnt", ""));
		setDonldBlCnt(JSPUtil.getParameter(request, prefix + "donld_bl_cnt", ""));
		setExsSntDonl(JSPUtil.getParameter(request, prefix + "exs_snt_donl", ""));
		setExsSntAccp(JSPUtil.getParameter(request, prefix + "exs_snt_accp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eu24EXSListVO[]
	 */
	public Eu24EXSListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eu24EXSListVO[]
	 */
	public Eu24EXSListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eu24EXSListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] relsBlCnt = (JSPUtil.getParameter(request, prefix	+ "rels_bl_cnt", length));
			String[] pFromMt = (JSPUtil.getParameter(request, prefix	+ "p_from_mt", length));
			String[] exsSntRels = (JSPUtil.getParameter(request, prefix	+ "exs_snt_rels", length));
			String[] exsSntRejt = (JSPUtil.getParameter(request, prefix	+ "exs_snt_rejt", length));
			String[] nrcvBlCnt = (JSPUtil.getParameter(request, prefix	+ "nrcv_bl_cnt", length));
			String[] sentBlCnt = (JSPUtil.getParameter(request, prefix	+ "sent_bl_cnt", length));
			String[] exsUnsntCnt = (JSPUtil.getParameter(request, prefix	+ "exs_unsnt_cnt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgPol = (JSPUtil.getParameter(request, prefix	+ "bkg_pol", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blTotCnt = (JSPUtil.getParameter(request, prefix	+ "bl_tot_cnt", length));
			String[] totalVvdCnt = (JSPUtil.getParameter(request, prefix	+ "total_vvd_cnt", length));
			String[] rejBlCnt = (JSPUtil.getParameter(request, prefix	+ "rej_bl_cnt", length));
			String[] accBlCnt = (JSPUtil.getParameter(request, prefix	+ "acc_bl_cnt", length));
			String[] condLane = (JSPUtil.getParameter(request, prefix	+ "cond_lane", length));
			String[] exsSntHold = (JSPUtil.getParameter(request, prefix	+ "exs_snt_hold", length));
			String[] unsentBlCnt = (JSPUtil.getParameter(request, prefix	+ "unsent_bl_cnt", length));
			String[] pBOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_b_ofc_cd", length));
			String[] pRhqGb = (JSPUtil.getParameter(request, prefix	+ "p_rhq_gb", length));
			String[] pVvd = (JSPUtil.getParameter(request, prefix	+ "p_vvd", length));
			String[] totalAmdCnt = (JSPUtil.getParameter(request, prefix	+ "total_amd_cnt", length));
			String[] exsSntCnt = (JSPUtil.getParameter(request, prefix	+ "exs_snt_cnt", length));
			String[] euPol = (JSPUtil.getParameter(request, prefix	+ "eu_pol", length));
			String[] pToDt = (JSPUtil.getParameter(request, prefix	+ "p_to_dt", length));
			String[] pToMt = (JSPUtil.getParameter(request, prefix	+ "p_to_mt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] exsSntNrcv = (JSPUtil.getParameter(request, prefix	+ "exs_snt_nrcv", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] holdBlCnt = (JSPUtil.getParameter(request, prefix	+ "hold_bl_cnt", length));
			String[] pPol = (JSPUtil.getParameter(request, prefix	+ "p_pol", length));
			String[] exsAmdCnt = (JSPUtil.getParameter(request, prefix	+ "exs_amd_cnt", length));
			String[] pFromDt = (JSPUtil.getParameter(request, prefix	+ "p_from_dt", length));
			String[] totalBlCnt = (JSPUtil.getParameter(request, prefix	+ "total_bl_cnt", length));
			String[] donldBlCnt = (JSPUtil.getParameter(request, prefix	+ "donld_bl_cnt", length));
			String[] exsSntDonl = (JSPUtil.getParameter(request, prefix	+ "exs_snt_donl", length));
			String[] exsSntAccp = (JSPUtil.getParameter(request, prefix	+ "exs_snt_accp", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eu24EXSListVO();
				if (relsBlCnt[i] != null)
					model.setRelsBlCnt(relsBlCnt[i]);
				if (pFromMt[i] != null)
					model.setPFromMt(pFromMt[i]);
				if (exsSntRels[i] != null)
					model.setExsSntRels(exsSntRels[i]);
				if (exsSntRejt[i] != null)
					model.setExsSntRejt(exsSntRejt[i]);
				if (nrcvBlCnt[i] != null)
					model.setNrcvBlCnt(nrcvBlCnt[i]);
				if (sentBlCnt[i] != null)
					model.setSentBlCnt(sentBlCnt[i]);
				if (exsUnsntCnt[i] != null)
					model.setExsUnsntCnt(exsUnsntCnt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgPol[i] != null)
					model.setBkgPol(bkgPol[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blTotCnt[i] != null)
					model.setBlTotCnt(blTotCnt[i]);
				if (totalVvdCnt[i] != null)
					model.setTotalVvdCnt(totalVvdCnt[i]);
				if (rejBlCnt[i] != null)
					model.setRejBlCnt(rejBlCnt[i]);
				if (accBlCnt[i] != null)
					model.setAccBlCnt(accBlCnt[i]);
				if (condLane[i] != null)
					model.setCondLane(condLane[i]);
				if (exsSntHold[i] != null)
					model.setExsSntHold(exsSntHold[i]);
				if (unsentBlCnt[i] != null)
					model.setUnsentBlCnt(unsentBlCnt[i]);
				if (pBOfcCd[i] != null)
					model.setPBOfcCd(pBOfcCd[i]);
				if (pRhqGb[i] != null)
					model.setPRhqGb(pRhqGb[i]);
				if (pVvd[i] != null)
					model.setPVvd(pVvd[i]);
				if (totalAmdCnt[i] != null)
					model.setTotalAmdCnt(totalAmdCnt[i]);
				if (exsSntCnt[i] != null)
					model.setExsSntCnt(exsSntCnt[i]);
				if (euPol[i] != null)
					model.setEuPol(euPol[i]);
				if (pToDt[i] != null)
					model.setPToDt(pToDt[i]);
				if (pToMt[i] != null)
					model.setPToMt(pToMt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (exsSntNrcv[i] != null)
					model.setExsSntNrcv(exsSntNrcv[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (holdBlCnt[i] != null)
					model.setHoldBlCnt(holdBlCnt[i]);
				if (pPol[i] != null)
					model.setPPol(pPol[i]);
				if (exsAmdCnt[i] != null)
					model.setExsAmdCnt(exsAmdCnt[i]);
				if (pFromDt[i] != null)
					model.setPFromDt(pFromDt[i]);
				if (totalBlCnt[i] != null)
					model.setTotalBlCnt(totalBlCnt[i]);
				if (donldBlCnt[i] != null)
					model.setDonldBlCnt(donldBlCnt[i]);
				if (exsSntDonl[i] != null)
					model.setExsSntDonl(exsSntDonl[i]);
				if (exsSntAccp[i] != null)
					model.setExsSntAccp(exsSntAccp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEu24EXSListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eu24EXSListVO[]
	 */
	public Eu24EXSListVO[] getEu24EXSListVOs(){
		Eu24EXSListVO[] vos = (Eu24EXSListVO[])models.toArray(new Eu24EXSListVO[models.size()]);
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
		this.relsBlCnt = this.relsBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFromMt = this.pFromMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsSntRels = this.exsSntRels .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsSntRejt = this.exsSntRejt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrcvBlCnt = this.nrcvBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentBlCnt = this.sentBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsUnsntCnt = this.exsUnsntCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPol = this.bkgPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTotCnt = this.blTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVvdCnt = this.totalVvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejBlCnt = this.rejBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accBlCnt = this.accBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condLane = this.condLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsSntHold = this.exsSntHold .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unsentBlCnt = this.unsentBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBOfcCd = this.pBOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqGb = this.pRhqGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvd = this.pVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmdCnt = this.totalAmdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsSntCnt = this.exsSntCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euPol = this.euPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pToDt = this.pToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pToMt = this.pToMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsSntNrcv = this.exsSntNrcv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holdBlCnt = this.holdBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPol = this.pPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsAmdCnt = this.exsAmdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFromDt = this.pFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBlCnt = this.totalBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.donldBlCnt = this.donldBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsSntDonl = this.exsSntDonl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsSntAccp = this.exsSntAccp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
