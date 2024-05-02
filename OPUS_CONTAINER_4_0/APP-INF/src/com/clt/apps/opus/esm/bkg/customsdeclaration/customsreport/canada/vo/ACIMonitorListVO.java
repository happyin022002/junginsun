/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ACIMonitorListVO.java
*@FileTitle : ACIMonitorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.07.15 김봉균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ACIMonitorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ACIMonitorListVO> models = new ArrayList<ACIMonitorListVO>();
	
	/* Column Info */
	private String podHold = null;
	/* Column Info */
	private String cmsSmcAmt = null;
	/* Column Info */
	private String totalSinwaMcf = null;
	/* Column Info */
	private String dnlCnt = null;
	/* Column Info */
	private String unsentCnt = null;
	/* Column Info */
	private String unsent = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String released = null;
	/* Column Info */
	private String totalHamurEns = null;
	/* Column Info */
	private String notReceived = null;
	/* Column Info */
	private String totalHamurMcf = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalNycnaEns = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String accepted = null;
	/* Column Info */
	private String totalVvdCnt = null;
	/* Column Info */
	private String notReceivedCnt = null;
	/* Column Info */
	private String rejected = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String doNotUnload = null;
	/* Column Info */
	private String totalShaasEns = null;
	/* Column Info */
	private String totalShaasMcf = null;
	/* Column Info */
	private String totalMcfAmt = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String dnl = null;
	/* Column Info */
	private String doNotUnloadCnt = null;
	/* Column Info */
	private String blType = null;
	/* Column Info */
	private String rejectedCnt = null;
	/* Column Info */
	private String podHoldCnt = null;
	/* Column Info */
	private String releaseCnt = null;
	/* Column Info */
	private String totalSinwaEns = null;
	/* Column Info */
	private String totalNycnaMcf = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String acceptedCnt = null;
	/* Column Info */
	private String mcfAmt = null;
	/* Column Info */
	private String blCount = null;
	/* Column Info */
	private String polOfc = null;
	/* Column Info */
	private String amendCnt = null;
	private String amendCnt2 = null;	
	/* Column Info */
	private String totalCmsSmcAmt = null;
	/* Column Info */
	private String blCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ACIMonitorListVO() {}

	public ACIMonitorListVO(String ibflag, String pagerows, String vvd, String lane, String polOfc, String rhq, String bkgOfc, String pol, String pod, String blType, String blCount, String accepted, String rejected, String dnl, String released, String podHold, String doNotUnload, String notReceived, String unsent, String amendCnt, String amendCnt2, String cmsSmcAmt, String mcfAmt, String blCnt, String acceptedCnt, String rejectedCnt, String dnlCnt, String releaseCnt, String podHoldCnt, String doNotUnloadCnt, String notReceivedCnt, String unsentCnt, String totalCmsSmcAmt, String totalShaasEns, String totalNycnaEns, String totalHamurEns, String totalSinwaEns, String totalMcfAmt, String totalShaasMcf, String totalNycnaMcf, String totalHamurMcf, String totalSinwaMcf, String totalVvdCnt) {
		this.podHold = podHold;
		this.cmsSmcAmt = cmsSmcAmt;
		this.totalSinwaMcf = totalSinwaMcf;
		this.dnlCnt = dnlCnt;
		this.unsentCnt = unsentCnt;
		this.unsent = unsent;
		this.lane = lane;
		this.pagerows = pagerows;
		this.released = released;
		this.totalHamurEns = totalHamurEns;
		this.notReceived = notReceived;
		this.totalHamurMcf = totalHamurMcf;
		this.ibflag = ibflag;
		this.totalNycnaEns = totalNycnaEns;
		this.bkgOfc = bkgOfc;
		this.accepted = accepted;
		this.totalVvdCnt = totalVvdCnt;
		this.notReceivedCnt = notReceivedCnt;
		this.rejected = rejected;
		this.pol = pol;
		this.doNotUnload = doNotUnload;
		this.totalShaasEns = totalShaasEns;
		this.totalShaasMcf = totalShaasMcf;
		this.totalMcfAmt = totalMcfAmt;
		this.pod = pod;
		this.rhq = rhq;
		this.dnl = dnl;
		this.doNotUnloadCnt = doNotUnloadCnt;
		this.blType = blType;
		this.rejectedCnt = rejectedCnt;
		this.podHoldCnt = podHoldCnt;
		this.releaseCnt = releaseCnt;
		this.totalSinwaEns = totalSinwaEns;
		this.totalNycnaMcf = totalNycnaMcf;
		this.vvd = vvd;
		this.acceptedCnt = acceptedCnt;
		this.mcfAmt = mcfAmt;
		this.blCount = blCount;
		this.polOfc = polOfc;
		this.amendCnt = amendCnt;
		this.amendCnt2 = amendCnt2;		
		this.totalCmsSmcAmt = totalCmsSmcAmt;
		this.blCnt = blCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_hold", getPodHold());
		this.hashColumns.put("cms_smc_amt", getCmsSmcAmt());
		this.hashColumns.put("total_sinwa_mcf", getTotalSinwaMcf());
		this.hashColumns.put("dnl_cnt", getDnlCnt());
		this.hashColumns.put("unsent_cnt", getUnsentCnt());
		this.hashColumns.put("unsent", getUnsent());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("released", getReleased());
		this.hashColumns.put("total_hamur_ens", getTotalHamurEns());
		this.hashColumns.put("not_received", getNotReceived());
		this.hashColumns.put("total_hamur_mcf", getTotalHamurMcf());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_nycna_ens", getTotalNycnaEns());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("accepted", getAccepted());
		this.hashColumns.put("total_vvd_cnt", getTotalVvdCnt());
		this.hashColumns.put("not_received_cnt", getNotReceivedCnt());
		this.hashColumns.put("rejected", getRejected());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("do_not_unload", getDoNotUnload());
		this.hashColumns.put("total_shaas_ens", getTotalShaasEns());
		this.hashColumns.put("total_shaas_mcf", getTotalShaasMcf());
		this.hashColumns.put("total_mcf_amt", getTotalMcfAmt());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("dnl", getDnl());
		this.hashColumns.put("do_not_unload_cnt", getDoNotUnloadCnt());
		this.hashColumns.put("bl_type", getBlType());
		this.hashColumns.put("rejected_cnt", getRejectedCnt());
		this.hashColumns.put("pod_hold_cnt", getPodHoldCnt());
		this.hashColumns.put("release_cnt", getReleaseCnt());
		this.hashColumns.put("total_sinwa_ens", getTotalSinwaEns());
		this.hashColumns.put("total_nycna_mcf", getTotalNycnaMcf());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("accepted_cnt", getAcceptedCnt());
		this.hashColumns.put("mcf_amt", getMcfAmt());
		this.hashColumns.put("bl_count", getBlCount());
		this.hashColumns.put("pol_ofc", getPolOfc());
		this.hashColumns.put("amend_cnt", getAmendCnt());
		this.hashColumns.put("amend_cnt2", getAmendCnt2());		
		this.hashColumns.put("total_cms_smc_amt", getTotalCmsSmcAmt());
		this.hashColumns.put("bl_cnt", getBlCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_hold", "podHold");
		this.hashFields.put("cms_smc_amt", "cmsSmcAmt");
		this.hashFields.put("total_sinwa_mcf", "totalSinwaMcf");
		this.hashFields.put("dnl_cnt", "dnlCnt");
		this.hashFields.put("unsent_cnt", "unsentCnt");
		this.hashFields.put("unsent", "unsent");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("released", "released");
		this.hashFields.put("total_hamur_ens", "totalHamurEns");
		this.hashFields.put("not_received", "notReceived");
		this.hashFields.put("total_hamur_mcf", "totalHamurMcf");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_nycna_ens", "totalNycnaEns");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("accepted", "accepted");
		this.hashFields.put("total_vvd_cnt", "totalVvdCnt");
		this.hashFields.put("not_received_cnt", "notReceivedCnt");
		this.hashFields.put("rejected", "rejected");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("do_not_unload", "doNotUnload");
		this.hashFields.put("total_shaas_ens", "totalShaasEns");
		this.hashFields.put("total_shaas_mcf", "totalShaasMcf");
		this.hashFields.put("total_mcf_amt", "totalMcfAmt");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("dnl", "dnl");
		this.hashFields.put("do_not_unload_cnt", "doNotUnloadCnt");
		this.hashFields.put("bl_type", "blType");
		this.hashFields.put("rejected_cnt", "rejectedCnt");
		this.hashFields.put("pod_hold_cnt", "podHoldCnt");
		this.hashFields.put("release_cnt", "releaseCnt");
		this.hashFields.put("total_sinwa_ens", "totalSinwaEns");
		this.hashFields.put("total_nycna_mcf", "totalNycnaMcf");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("accepted_cnt", "acceptedCnt");
		this.hashFields.put("mcf_amt", "mcfAmt");
		this.hashFields.put("bl_count", "blCount");
		this.hashFields.put("pol_ofc", "polOfc");
		this.hashFields.put("amend_cnt", "amendCnt");
		this.hashFields.put("amend_cnt2", "amendCnt2");		
		this.hashFields.put("total_cms_smc_amt", "totalCmsSmcAmt");
		this.hashFields.put("bl_cnt", "blCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podHold
	 */
	public String getPodHold() {
		return this.podHold;
	}
	
	/**
	 * Column Info
	 * @return cmsSmcAmt
	 */
	public String getCmsSmcAmt() {
		return this.cmsSmcAmt;
	}
	
	/**
	 * Column Info
	 * @return totalSinwaMcf
	 */
	public String getTotalSinwaMcf() {
		return this.totalSinwaMcf;
	}
	
	/**
	 * Column Info
	 * @return dnlCnt
	 */
	public String getDnlCnt() {
		return this.dnlCnt;
	}
	
	/**
	 * Column Info
	 * @return unsentCnt
	 */
	public String getUnsentCnt() {
		return this.unsentCnt;
	}
	
	/**
	 * Column Info
	 * @return unsent
	 */
	public String getUnsent() {
		return this.unsent;
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
	 * @return released
	 */
	public String getReleased() {
		return this.released;
	}
	
	/**
	 * Column Info
	 * @return totalHamurEns
	 */
	public String getTotalHamurEns() {
		return this.totalHamurEns;
	}
	
	/**
	 * Column Info
	 * @return notReceived
	 */
	public String getNotReceived() {
		return this.notReceived;
	}
	
	/**
	 * Column Info
	 * @return totalHamurMcf
	 */
	public String getTotalHamurMcf() {
		return this.totalHamurMcf;
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
	 * @return totalNycnaEns
	 */
	public String getTotalNycnaEns() {
		return this.totalNycnaEns;
	}
	
	/**
	 * Column Info
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return accepted
	 */
	public String getAccepted() {
		return this.accepted;
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
	 * @return notReceivedCnt
	 */
	public String getNotReceivedCnt() {
		return this.notReceivedCnt;
	}
	
	/**
	 * Column Info
	 * @return rejected
	 */
	public String getRejected() {
		return this.rejected;
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
	 * @return doNotUnload
	 */
	public String getDoNotUnload() {
		return this.doNotUnload;
	}
	
	/**
	 * Column Info
	 * @return totalShaasEns
	 */
	public String getTotalShaasEns() {
		return this.totalShaasEns;
	}
	
	/**
	 * Column Info
	 * @return totalShaasMcf
	 */
	public String getTotalShaasMcf() {
		return this.totalShaasMcf;
	}
	
	/**
	 * Column Info
	 * @return totalMcfAmt
	 */
	public String getTotalMcfAmt() {
		return this.totalMcfAmt;
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
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return dnl
	 */
	public String getDnl() {
		return this.dnl;
	}
	
	/**
	 * Column Info
	 * @return doNotUnloadCnt
	 */
	public String getDoNotUnloadCnt() {
		return this.doNotUnloadCnt;
	}
	
	/**
	 * Column Info
	 * @return blType
	 */
	public String getBlType() {
		return this.blType;
	}
	
	/**
	 * Column Info
	 * @return rejectedCnt
	 */
	public String getRejectedCnt() {
		return this.rejectedCnt;
	}
	
	/**
	 * Column Info
	 * @return podHoldCnt
	 */
	public String getPodHoldCnt() {
		return this.podHoldCnt;
	}
	
	/**
	 * Column Info
	 * @return releaseCnt
	 */
	public String getReleaseCnt() {
		return this.releaseCnt;
	}
	
	/**
	 * Column Info
	 * @return totalSinwaEns
	 */
	public String getTotalSinwaEns() {
		return this.totalSinwaEns;
	}
	
	/**
	 * Column Info
	 * @return totalNycnaMcf
	 */
	public String getTotalNycnaMcf() {
		return this.totalNycnaMcf;
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
	 * @return acceptedCnt
	 */
	public String getAcceptedCnt() {
		return this.acceptedCnt;
	}
	
	/**
	 * Column Info
	 * @return mcfAmt
	 */
	public String getMcfAmt() {
		return this.mcfAmt;
	}
	
	/**
	 * Column Info
	 * @return blCount
	 */
	public String getBlCount() {
		return this.blCount;
	}
	
	/**
	 * Column Info
	 * @return polOfc
	 */
	public String getPolOfc() {
		return this.polOfc;
	}
	
	/**
	 * Column Info
	 * @return amendCnt
	 */
	public String getAmendCnt() {
		return this.amendCnt;
	}
	
	/**
	 * Column Info
	 * @return amendCnt
	 */
	public String getAmendCnt2() {
		return this.amendCnt2;
	}
	
	/**
	 * Column Info
	 * @return totalCmsSmcAmt
	 */
	public String getTotalCmsSmcAmt() {
		return this.totalCmsSmcAmt;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	

	/**
	 * Column Info
	 * @param podHold
	 */
	public void setPodHold(String podHold) {
		this.podHold = podHold;
	}
	
	/**
	 * Column Info
	 * @param cmsSmcAmt
	 */
	public void setCmsSmcAmt(String cmsSmcAmt) {
		this.cmsSmcAmt = cmsSmcAmt;
	}
	
	/**
	 * Column Info
	 * @param totalSinwaMcf
	 */
	public void setTotalSinwaMcf(String totalSinwaMcf) {
		this.totalSinwaMcf = totalSinwaMcf;
	}
	
	/**
	 * Column Info
	 * @param dnlCnt
	 */
	public void setDnlCnt(String dnlCnt) {
		this.dnlCnt = dnlCnt;
	}
	
	/**
	 * Column Info
	 * @param unsentCnt
	 */
	public void setUnsentCnt(String unsentCnt) {
		this.unsentCnt = unsentCnt;
	}
	
	/**
	 * Column Info
	 * @param unsent
	 */
	public void setUnsent(String unsent) {
		this.unsent = unsent;
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
	 * @param released
	 */
	public void setReleased(String released) {
		this.released = released;
	}
	
	/**
	 * Column Info
	 * @param totalHamurEns
	 */
	public void setTotalHamurEns(String totalHamurEns) {
		this.totalHamurEns = totalHamurEns;
	}
	
	/**
	 * Column Info
	 * @param notReceived
	 */
	public void setNotReceived(String notReceived) {
		this.notReceived = notReceived;
	}
	
	/**
	 * Column Info
	 * @param totalHamurMcf
	 */
	public void setTotalHamurMcf(String totalHamurMcf) {
		this.totalHamurMcf = totalHamurMcf;
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
	 * @param totalNycnaEns
	 */
	public void setTotalNycnaEns(String totalNycnaEns) {
		this.totalNycnaEns = totalNycnaEns;
	}
	
	/**
	 * Column Info
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param accepted
	 */
	public void setAccepted(String accepted) {
		this.accepted = accepted;
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
	 * @param notReceivedCnt
	 */
	public void setNotReceivedCnt(String notReceivedCnt) {
		this.notReceivedCnt = notReceivedCnt;
	}
	
	/**
	 * Column Info
	 * @param rejected
	 */
	public void setRejected(String rejected) {
		this.rejected = rejected;
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
	 * @param doNotUnload
	 */
	public void setDoNotUnload(String doNotUnload) {
		this.doNotUnload = doNotUnload;
	}
	
	/**
	 * Column Info
	 * @param totalShaasEns
	 */
	public void setTotalShaasEns(String totalShaasEns) {
		this.totalShaasEns = totalShaasEns;
	}
	
	/**
	 * Column Info
	 * @param totalShaasMcf
	 */
	public void setTotalShaasMcf(String totalShaasMcf) {
		this.totalShaasMcf = totalShaasMcf;
	}
	
	/**
	 * Column Info
	 * @param totalMcfAmt
	 */
	public void setTotalMcfAmt(String totalMcfAmt) {
		this.totalMcfAmt = totalMcfAmt;
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
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param dnl
	 */
	public void setDnl(String dnl) {
		this.dnl = dnl;
	}
	
	/**
	 * Column Info
	 * @param doNotUnloadCnt
	 */
	public void setDoNotUnloadCnt(String doNotUnloadCnt) {
		this.doNotUnloadCnt = doNotUnloadCnt;
	}
	
	/**
	 * Column Info
	 * @param blType
	 */
	public void setBlType(String blType) {
		this.blType = blType;
	}
	
	/**
	 * Column Info
	 * @param rejectedCnt
	 */
	public void setRejectedCnt(String rejectedCnt) {
		this.rejectedCnt = rejectedCnt;
	}
	
	/**
	 * Column Info
	 * @param podHoldCnt
	 */
	public void setPodHoldCnt(String podHoldCnt) {
		this.podHoldCnt = podHoldCnt;
	}
	
	/**
	 * Column Info
	 * @param releaseCnt
	 */
	public void setReleaseCnt(String releaseCnt) {
		this.releaseCnt = releaseCnt;
	}
	
	/**
	 * Column Info
	 * @param totalSinwaEns
	 */
	public void setTotalSinwaEns(String totalSinwaEns) {
		this.totalSinwaEns = totalSinwaEns;
	}
	
	/**
	 * Column Info
	 * @param totalNycnaMcf
	 */
	public void setTotalNycnaMcf(String totalNycnaMcf) {
		this.totalNycnaMcf = totalNycnaMcf;
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
	 * @param acceptedCnt
	 */
	public void setAcceptedCnt(String acceptedCnt) {
		this.acceptedCnt = acceptedCnt;
	}
	
	/**
	 * Column Info
	 * @param mcfAmt
	 */
	public void setMcfAmt(String mcfAmt) {
		this.mcfAmt = mcfAmt;
	}
	
	/**
	 * Column Info
	 * @param blCount
	 */
	public void setBlCount(String blCount) {
		this.blCount = blCount;
	}
	
	/**
	 * Column Info
	 * @param polOfc
	 */
	public void setPolOfc(String polOfc) {
		this.polOfc = polOfc;
	}
	
	/**
	 * Column Info
	 * @param amendCnt
	 */
	public void setAmendCnt(String amendCnt) {
		this.amendCnt = amendCnt;
	}
	
	/**
	 * Column Info
	 * @param amendCnt
	 */
	public void setAmendCnt2(String amendCnt2) {
		this.amendCnt2 = amendCnt2;
	}
	
	/**
	 * Column Info
	 * @param totalCmsSmcAmt
	 */
	public void setTotalCmsSmcAmt(String totalCmsSmcAmt) {
		this.totalCmsSmcAmt = totalCmsSmcAmt;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setPodHold(JSPUtil.getParameter(request, prefix + "pod_hold", ""));
		setCmsSmcAmt(JSPUtil.getParameter(request, prefix + "cms_smc_amt", ""));
		setTotalSinwaMcf(JSPUtil.getParameter(request, prefix + "total_sinwa_mcf", ""));
		setDnlCnt(JSPUtil.getParameter(request, prefix + "dnl_cnt", ""));
		setUnsentCnt(JSPUtil.getParameter(request, prefix + "unsent_cnt", ""));
		setUnsent(JSPUtil.getParameter(request, prefix + "unsent", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setReleased(JSPUtil.getParameter(request, prefix + "released", ""));
		setTotalHamurEns(JSPUtil.getParameter(request, prefix + "total_hamur_ens", ""));
		setNotReceived(JSPUtil.getParameter(request, prefix + "not_received", ""));
		setTotalHamurMcf(JSPUtil.getParameter(request, prefix + "total_hamur_mcf", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotalNycnaEns(JSPUtil.getParameter(request, prefix + "total_nycna_ens", ""));
		setBkgOfc(JSPUtil.getParameter(request, prefix + "bkg_ofc", ""));
		setAccepted(JSPUtil.getParameter(request, prefix + "accepted", ""));
		setTotalVvdCnt(JSPUtil.getParameter(request, prefix + "total_vvd_cnt", ""));
		setNotReceivedCnt(JSPUtil.getParameter(request, prefix + "not_received_cnt", ""));
		setRejected(JSPUtil.getParameter(request, prefix + "rejected", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setDoNotUnload(JSPUtil.getParameter(request, prefix + "do_not_unload", ""));
		setTotalShaasEns(JSPUtil.getParameter(request, prefix + "total_shaas_ens", ""));
		setTotalShaasMcf(JSPUtil.getParameter(request, prefix + "total_shaas_mcf", ""));
		setTotalMcfAmt(JSPUtil.getParameter(request, prefix + "total_mcf_amt", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setDnl(JSPUtil.getParameter(request, prefix + "dnl", ""));
		setDoNotUnloadCnt(JSPUtil.getParameter(request, prefix + "do_not_unload_cnt", ""));
		setBlType(JSPUtil.getParameter(request, prefix + "bl_type", ""));
		setRejectedCnt(JSPUtil.getParameter(request, prefix + "rejected_cnt", ""));
		setPodHoldCnt(JSPUtil.getParameter(request, prefix + "pod_hold_cnt", ""));
		setReleaseCnt(JSPUtil.getParameter(request, prefix + "release_cnt", ""));
		setTotalSinwaEns(JSPUtil.getParameter(request, prefix + "total_sinwa_ens", ""));
		setTotalNycnaMcf(JSPUtil.getParameter(request, prefix + "total_nycna_mcf", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setAcceptedCnt(JSPUtil.getParameter(request, prefix + "accepted_cnt", ""));
		setMcfAmt(JSPUtil.getParameter(request, prefix + "mcf_amt", ""));
		setBlCount(JSPUtil.getParameter(request, prefix + "bl_count", ""));
		setPolOfc(JSPUtil.getParameter(request, prefix + "pol_ofc", ""));
		setAmendCnt(JSPUtil.getParameter(request, prefix + "amend_cnt", ""));
		setAmendCnt2(JSPUtil.getParameter(request, prefix + "amend_cnt2", ""));		
		setTotalCmsSmcAmt(JSPUtil.getParameter(request, prefix + "total_cms_smc_amt", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ACIMonitorListVO[]
	 */
	public ACIMonitorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ACIMonitorListVO[]
	 */
	public ACIMonitorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ACIMonitorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podHold = (JSPUtil.getParameter(request, prefix	+ "pod_hold", length));
			String[] cmsSmcAmt = (JSPUtil.getParameter(request, prefix	+ "cms_smc_amt", length));
			String[] totalSinwaMcf = (JSPUtil.getParameter(request, prefix	+ "total_sinwa_mcf", length));
			String[] dnlCnt = (JSPUtil.getParameter(request, prefix	+ "dnl_cnt", length));
			String[] unsentCnt = (JSPUtil.getParameter(request, prefix	+ "unsent_cnt", length));
			String[] unsent = (JSPUtil.getParameter(request, prefix	+ "unsent", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] released = (JSPUtil.getParameter(request, prefix	+ "released", length));
			String[] totalHamurEns = (JSPUtil.getParameter(request, prefix	+ "total_hamur_ens", length));
			String[] notReceived = (JSPUtil.getParameter(request, prefix	+ "not_received", length));
			String[] totalHamurMcf = (JSPUtil.getParameter(request, prefix	+ "total_hamur_mcf", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalNycnaEns = (JSPUtil.getParameter(request, prefix	+ "total_nycna_ens", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] accepted = (JSPUtil.getParameter(request, prefix	+ "accepted", length));
			String[] totalVvdCnt = (JSPUtil.getParameter(request, prefix	+ "total_vvd_cnt", length));
			String[] notReceivedCnt = (JSPUtil.getParameter(request, prefix	+ "not_received_cnt", length));
			String[] rejected = (JSPUtil.getParameter(request, prefix	+ "rejected", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] doNotUnload = (JSPUtil.getParameter(request, prefix	+ "do_not_unload", length));
			String[] totalShaasEns = (JSPUtil.getParameter(request, prefix	+ "total_shaas_ens", length));
			String[] totalShaasMcf = (JSPUtil.getParameter(request, prefix	+ "total_shaas_mcf", length));
			String[] totalMcfAmt = (JSPUtil.getParameter(request, prefix	+ "total_mcf_amt", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] dnl = (JSPUtil.getParameter(request, prefix	+ "dnl", length));
			String[] doNotUnloadCnt = (JSPUtil.getParameter(request, prefix	+ "do_not_unload_cnt", length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type", length));
			String[] rejectedCnt = (JSPUtil.getParameter(request, prefix	+ "rejected_cnt", length));
			String[] podHoldCnt = (JSPUtil.getParameter(request, prefix	+ "pod_hold_cnt", length));
			String[] releaseCnt = (JSPUtil.getParameter(request, prefix	+ "release_cnt", length));
			String[] totalSinwaEns = (JSPUtil.getParameter(request, prefix	+ "total_sinwa_ens", length));
			String[] totalNycnaMcf = (JSPUtil.getParameter(request, prefix	+ "total_nycna_mcf", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] acceptedCnt = (JSPUtil.getParameter(request, prefix	+ "accepted_cnt", length));
			String[] mcfAmt = (JSPUtil.getParameter(request, prefix	+ "mcf_amt", length));
			String[] blCount = (JSPUtil.getParameter(request, prefix	+ "bl_count", length));
			String[] polOfc = (JSPUtil.getParameter(request, prefix	+ "pol_ofc", length));
			String[] amendCnt = (JSPUtil.getParameter(request, prefix	+ "amend_cnt", length));
			String[] amendCnt2 = (JSPUtil.getParameter(request, prefix	+ "amend_cnt2", length));			
			String[] totalCmsSmcAmt = (JSPUtil.getParameter(request, prefix	+ "total_cms_smc_amt", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ACIMonitorListVO();
				if (podHold[i] != null)
					model.setPodHold(podHold[i]);
				if (cmsSmcAmt[i] != null)
					model.setCmsSmcAmt(cmsSmcAmt[i]);
				if (totalSinwaMcf[i] != null)
					model.setTotalSinwaMcf(totalSinwaMcf[i]);
				if (dnlCnt[i] != null)
					model.setDnlCnt(dnlCnt[i]);
				if (unsentCnt[i] != null)
					model.setUnsentCnt(unsentCnt[i]);
				if (unsent[i] != null)
					model.setUnsent(unsent[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (released[i] != null)
					model.setReleased(released[i]);
				if (totalHamurEns[i] != null)
					model.setTotalHamurEns(totalHamurEns[i]);
				if (notReceived[i] != null)
					model.setNotReceived(notReceived[i]);
				if (totalHamurMcf[i] != null)
					model.setTotalHamurMcf(totalHamurMcf[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalNycnaEns[i] != null)
					model.setTotalNycnaEns(totalNycnaEns[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (accepted[i] != null)
					model.setAccepted(accepted[i]);
				if (totalVvdCnt[i] != null)
					model.setTotalVvdCnt(totalVvdCnt[i]);
				if (notReceivedCnt[i] != null)
					model.setNotReceivedCnt(notReceivedCnt[i]);
				if (rejected[i] != null)
					model.setRejected(rejected[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (doNotUnload[i] != null)
					model.setDoNotUnload(doNotUnload[i]);
				if (totalShaasEns[i] != null)
					model.setTotalShaasEns(totalShaasEns[i]);
				if (totalShaasMcf[i] != null)
					model.setTotalShaasMcf(totalShaasMcf[i]);
				if (totalMcfAmt[i] != null)
					model.setTotalMcfAmt(totalMcfAmt[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (dnl[i] != null)
					model.setDnl(dnl[i]);
				if (doNotUnloadCnt[i] != null)
					model.setDoNotUnloadCnt(doNotUnloadCnt[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				if (rejectedCnt[i] != null)
					model.setRejectedCnt(rejectedCnt[i]);
				if (podHoldCnt[i] != null)
					model.setPodHoldCnt(podHoldCnt[i]);
				if (releaseCnt[i] != null)
					model.setReleaseCnt(releaseCnt[i]);
				if (totalSinwaEns[i] != null)
					model.setTotalSinwaEns(totalSinwaEns[i]);
				if (totalNycnaMcf[i] != null)
					model.setTotalNycnaMcf(totalNycnaMcf[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (acceptedCnt[i] != null)
					model.setAcceptedCnt(acceptedCnt[i]);
				if (mcfAmt[i] != null)
					model.setMcfAmt(mcfAmt[i]);
				if (blCount[i] != null)
					model.setBlCount(blCount[i]);
				if (polOfc[i] != null)
					model.setPolOfc(polOfc[i]);
				if (amendCnt[i] != null)
					model.setAmendCnt(amendCnt[i]);
				if (amendCnt2[i] != null)
					model.setAmendCnt2(amendCnt2[i]);				
				if (totalCmsSmcAmt[i] != null)
					model.setTotalCmsSmcAmt(totalCmsSmcAmt[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getACIMonitorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ACIMonitorListVO[]
	 */
	public ACIMonitorListVO[] getACIMonitorListVOs(){
		ACIMonitorListVO[] vos = (ACIMonitorListVO[])models.toArray(new ACIMonitorListVO[models.size()]);
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
		this.podHold = this.podHold .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmsSmcAmt = this.cmsSmcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSinwaMcf = this.totalSinwaMcf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnlCnt = this.dnlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unsentCnt = this.unsentCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unsent = this.unsent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.released = this.released .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalHamurEns = this.totalHamurEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notReceived = this.notReceived .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalHamurMcf = this.totalHamurMcf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNycnaEns = this.totalNycnaEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accepted = this.accepted .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVvdCnt = this.totalVvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notReceivedCnt = this.notReceivedCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejected = this.rejected .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNotUnload = this.doNotUnload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalShaasEns = this.totalShaasEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalShaasMcf = this.totalShaasMcf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalMcfAmt = this.totalMcfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnl = this.dnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNotUnloadCnt = this.doNotUnloadCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectedCnt = this.rejectedCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podHoldCnt = this.podHoldCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseCnt = this.releaseCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSinwaEns = this.totalSinwaEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNycnaMcf = this.totalNycnaMcf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acceptedCnt = this.acceptedCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcfAmt = this.mcfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCount = this.blCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polOfc = this.polOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendCnt = this.amendCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendCnt2 = this.amendCnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.totalCmsSmcAmt = this.totalCmsSmcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
