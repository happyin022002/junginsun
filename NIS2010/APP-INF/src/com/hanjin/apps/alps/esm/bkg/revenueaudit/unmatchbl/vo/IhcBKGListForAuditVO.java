/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IhcBKGListForAuditVO.java
*@FileTitle : IhcBKGListForAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IhcBKGListForAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IhcBKGListForAuditVO> models = new ArrayList<IhcBKGListForAuditVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String bkgRhqCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cyr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ttlBkgCnt = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String oih = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dih = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	
	/* Column Info */
	private String soBnd = null;
	/* Column Info */
	private String audStsCd = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String revAudDt = null;
	
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String trspCostDtlMod = null;
	/* Column Info */
	private String rdnNo = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public IhcBKGListForAuditVO() {}

	public IhcBKGListForAuditVO(String ibflag, String pagerows, String bkgNo, String rtAplyDt, String bkgCtrtTpCd, String ctrtNo, String porCd, String polCd, String podCd, String delCd, String rcvTermCd, String deTermCd, String cntrNo, String cntrTpszCd, String cntrWgt, String oih, String dih, String cyr, String ttlBkgCnt, String bkgRhqCd, String svcScpCd, String fmDt, String toDt, String toNodCd, String fmNodCd, String soNo, String audStsCd, String soBnd, String revAudDt, String rdnNo, String trspCostDtlMod, String xterRmk, String interRmk) {
		this.porCd = porCd;
		this.cntrWgt = cntrWgt;
		this.fmDt = fmDt;
		this.svcScpCd = svcScpCd;
		this.rtAplyDt = rtAplyDt;
		this.bkgRhqCd = bkgRhqCd;
		this.delCd = delCd;
		this.cyr = cyr;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ttlBkgCnt = ttlBkgCnt;
		this.ctrtNo = ctrtNo;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.oih = oih;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.dih = dih;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.rcvTermCd = rcvTermCd;
		
		this.soBnd = soBnd;
		this.audStsCd = audStsCd;
		this.soNo = soNo;
		this.fmNodCd = fmNodCd;
		this.toNodCd = toNodCd;
		this.revAudDt = revAudDt;
		
		this.interRmk = interRmk;
		this.xterRmk = xterRmk;
		this.trspCostDtlMod = trspCostDtlMod;
		this.rdnNo = rdnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("bkg_rhq_cd", getBkgRhqCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cyr", getCyr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ttl_bkg_cnt", getTtlBkgCnt());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("oih", getOih());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dih", getDih());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		
		this.hashColumns.put("so_bnd", getSoBnd());
		this.hashColumns.put("aud_sts_cd", getAudStsCd());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("rev_aud_dt", getRevAudDt());
		
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("trsp_cost_dtl_mod", getTrspCostDtlMod());
		this.hashColumns.put("rdn_no", getRdnNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("bkg_rhq_cd", "bkgRhqCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cyr", "cyr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ttl_bkg_cnt", "ttlBkgCnt");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("oih", "oih");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dih", "dih");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		
		this.hashFields.put("so_bnd", "soBnd");
		this.hashFields.put("aud_sts_cd", "audStsCd");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("rev_aud_dt", "revAudDt");
		
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("trsp_cost_dtl_mod", "trspCostDtlMod");
		this.hashFields.put("rdn_no", "rdnNo");
		return this.hashFields;
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
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
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
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return bkgRhqCd
	 */
	public String getBkgRhqCd() {
		return this.bkgRhqCd;
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
	 * @return cyr
	 */
	public String getCyr() {
		return this.cyr;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ttlBkgCnt
	 */
	public String getTtlBkgCnt() {
		return this.ttlBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	/**
	 * Column Info
	 * @return trspCostDtlMod
	 */
	public String getTrspCostDtlMod() {
		return this.trspCostDtlMod;
	}
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return oih
	 */
	public String getOih() {
		return this.oih;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return soBnd
	 */
	public String getSoBnd() {
		return this.soBnd;
	}
	/**
	 * Column Info
	 * @return audStsCd
	 */
	public String getAudStsCd() {
		return this.audStsCd;
	}
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dih
	 */
	public String getDih() {
		return this.dih;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return revAudDt
	 */
	public String getRevAudDt() {
		return this.revAudDt;
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
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param revAudDt
	 */
	public void setRevAudDt(String revAudDt) {
		this.revAudDt = revAudDt;
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
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param bkgRhqCd
	 */
	public void setBkgRhqCd(String bkgRhqCd) {
		this.bkgRhqCd = bkgRhqCd;
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
	 * @param cyr
	 */
	public void setCyr(String cyr) {
		this.cyr = cyr;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ttlBkgCnt
	 */
	public void setTtlBkgCnt(String ttlBkgCnt) {
		this.ttlBkgCnt = ttlBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param oih
	 */
	public void setOih(String oih) {
		this.oih = oih;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dih
	 */
	public void setDih(String dih) {
		this.dih = dih;
	}
	
	
	/**
	 * Column Info
	 * @param soBnd
	 */
	public void setSoBnd(String soBnd) {
		this.soBnd = soBnd;
	}
	/**
	 * Column Info
	 * @param audStsCd
	 */
	public void setAudStsCd(String audStsCd) {
		this.audStsCd = audStsCd;
	}
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	/**
	 * Column Info
	 * @param trspCostDtlMod
	 */
	public void setTrspCostDtlMod(String trspCostDtlMod) {
		this.trspCostDtlMod = trspCostDtlMod;
	}
	/**
	 * Column Info
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setBkgRhqCd(JSPUtil.getParameter(request, prefix + "bkg_rhq_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCyr(JSPUtil.getParameter(request, prefix + "cyr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setTtlBkgCnt(JSPUtil.getParameter(request, prefix + "ttl_bkg_cnt", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setOih(JSPUtil.getParameter(request, prefix + "oih", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDih(JSPUtil.getParameter(request, prefix + "dih", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		
		setSoBnd(JSPUtil.getParameter(request, prefix + "so_bnd", ""));
		setAudStsCd(JSPUtil.getParameter(request, prefix + "aud_sts_cd", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setRevAudDt(JSPUtil.getParameter(request, prefix + "rev_aud_dt", ""));
		
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setTrspCostDtlMod(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IhcBKGListForAuditVO[]
	 */
	public IhcBKGListForAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IhcBKGListForAuditVO[]
	 */
	public IhcBKGListForAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IhcBKGListForAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] bkgRhqCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rhq_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cyr = (JSPUtil.getParameter(request, prefix	+ "cyr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ttlBkgCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg_cnt", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] oih = (JSPUtil.getParameter(request, prefix	+ "oih", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dih = (JSPUtil.getParameter(request, prefix	+ "dih", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			
			String[] soBnd = (JSPUtil.getParameter(request, prefix	+ "so_bnd", length));
			String[] audStsCd = (JSPUtil.getParameter(request, prefix	+ "aud_sts_cd", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] revAudDt = (JSPUtil.getParameter(request, prefix	+ "rev_aud_dt", length));
			
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] trspCostDtlMod = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			for (int i = 0; i < length; i++) {
				model = new IhcBKGListForAuditVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (bkgRhqCd[i] != null)
					model.setBkgRhqCd(bkgRhqCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cyr[i] != null)
					model.setCyr(cyr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ttlBkgCnt[i] != null)
					model.setTtlBkgCnt(ttlBkgCnt[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (oih[i] != null)
					model.setOih(oih[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dih[i] != null)
					model.setDih(dih[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				
				if (soBnd[i] != null)
					model.setSoBnd(soBnd[i]);
				if (audStsCd[i] != null)
					model.setAudStsCd(audStsCd[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (revAudDt[i] != null)
					model.setRevAudDt(revAudDt[i]);
				
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (trspCostDtlMod[i] != null)
					model.setTrspCostDtlMod(trspCostDtlMod[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIhcBKGListForAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IhcBKGListForAuditVO[]
	 */
	public IhcBKGListForAuditVO[] getIhcBKGListForAuditVOs(){
		IhcBKGListForAuditVO[] vos = (IhcBKGListForAuditVO[])models.toArray(new IhcBKGListForAuditVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRhqCd = this.bkgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyr = this.cyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkgCnt = this.ttlBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oih = this.oih .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dih = this.dih .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.soBnd = this.soBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audStsCd = this.audStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudDt = this.revAudDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlMod = this.trspCostDtlMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
