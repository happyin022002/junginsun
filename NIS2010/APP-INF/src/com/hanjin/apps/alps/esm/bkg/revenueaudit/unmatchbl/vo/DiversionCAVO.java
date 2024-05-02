/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DiversionCAVO.java
*@FileTitle : DiversionCAVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19  
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

public class DiversionCAVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DiversionCAVO> models = new ArrayList<DiversionCAVO>();
	
	/* Column Info */
	private String dvcRatUtCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String dvcCurrCd = null;
	/* Column Info */
	private String newDelCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String newPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldDelCd = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String dvcChgAmt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String newPorCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String oldPorCd = null;
	/* Column Info */
	private String oldPolCd = null;
	/* Column Info */
	private String dateType = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String newCorrNo = null;
	/* Column Info */
	private String oldPodCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String caSeq = null;
	/* Column Info */
	private String newPodCd = null;
	/* Column Info */
	private String dvcRatAsQty = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String dvcChgUtAmt = null;
	/* Column Info */
	private String oldCorrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DiversionCAVO() {}

	public DiversionCAVO(String ibflag, String pagerows, String seq, String rhqCd, String bkgOfcCd, String svcScpCd, String blNo, String bkgNo, String bdrFlg, String rtAplyDt, String vpsEtdDt, String bkgCtrtTpCd, String ctrtNo, String newCorrNo, String oldCorrNo, String caSeq, String newPorCd, String newPolCd, String newPodCd, String newDelCd, String oldPorCd, String oldPolCd, String oldPodCd, String oldDelCd, String dvcCurrCd, String dvcChgUtAmt, String dvcRatAsQty, String dvcRatUtCd, String dvcChgAmt, String blCnt, String dateType, String fmDt, String toDt) {
		this.dvcRatUtCd = dvcRatUtCd;
		this.rtAplyDt = rtAplyDt;
		this.bdrFlg = bdrFlg;
		this.svcScpCd = svcScpCd;
		this.dvcCurrCd = dvcCurrCd;
		this.newDelCd = newDelCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.newPolCd = newPolCd;
		this.ibflag = ibflag;
		this.oldDelCd = oldDelCd;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.dvcChgAmt = dvcChgAmt;
		this.bkgOfcCd = bkgOfcCd;
		this.newPorCd = newPorCd;
		this.vpsEtdDt = vpsEtdDt;
		this.fmDt = fmDt;
		this.rhqCd = rhqCd;
		this.oldPorCd = oldPorCd;
		this.oldPolCd = oldPolCd;
		this.dateType = dateType;
		this.toDt = toDt;
		this.bkgNo = bkgNo;
		this.newCorrNo = newCorrNo;
		this.oldPodCd = oldPodCd;
		this.seq = seq;
		this.caSeq = caSeq;
		this.newPodCd = newPodCd;
		this.dvcRatAsQty = dvcRatAsQty;
		this.blCnt = blCnt;
		this.dvcChgUtAmt = dvcChgUtAmt;
		this.oldCorrNo = oldCorrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dvc_rat_ut_cd", getDvcRatUtCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dvc_curr_cd", getDvcCurrCd());
		this.hashColumns.put("new_del_cd", getNewDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("new_pol_cd", getNewPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_del_cd", getOldDelCd());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("dvc_chg_amt", getDvcChgAmt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("new_por_cd", getNewPorCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("old_por_cd", getOldPorCd());
		this.hashColumns.put("old_pol_cd", getOldPolCd());
		this.hashColumns.put("date_type", getDateType());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("new_corr_no", getNewCorrNo());
		this.hashColumns.put("old_pod_cd", getOldPodCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("ca_seq", getCaSeq());
		this.hashColumns.put("new_pod_cd", getNewPodCd());
		this.hashColumns.put("dvc_rat_as_qty", getDvcRatAsQty());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("dvc_chg_ut_amt", getDvcChgUtAmt());
		this.hashColumns.put("old_corr_no", getOldCorrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dvc_rat_ut_cd", "dvcRatUtCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dvc_curr_cd", "dvcCurrCd");
		this.hashFields.put("new_del_cd", "newDelCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("new_pol_cd", "newPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_del_cd", "oldDelCd");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("dvc_chg_amt", "dvcChgAmt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("new_por_cd", "newPorCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("old_por_cd", "oldPorCd");
		this.hashFields.put("old_pol_cd", "oldPolCd");
		this.hashFields.put("date_type", "dateType");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("new_corr_no", "newCorrNo");
		this.hashFields.put("old_pod_cd", "oldPodCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("ca_seq", "caSeq");
		this.hashFields.put("new_pod_cd", "newPodCd");
		this.hashFields.put("dvc_rat_as_qty", "dvcRatAsQty");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("dvc_chg_ut_amt", "dvcChgUtAmt");
		this.hashFields.put("old_corr_no", "oldCorrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dvcRatUtCd
	 */
	public String getDvcRatUtCd() {
		return this.dvcRatUtCd;
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
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
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
	 * @return dvcCurrCd
	 */
	public String getDvcCurrCd() {
		return this.dvcCurrCd;
	}
	
	/**
	 * Column Info
	 * @return newDelCd
	 */
	public String getNewDelCd() {
		return this.newDelCd;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return newPolCd
	 */
	public String getNewPolCd() {
		return this.newPolCd;
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
	 * @return oldDelCd
	 */
	public String getOldDelCd() {
		return this.oldDelCd;
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
	 * @return dvcChgAmt
	 */
	public String getDvcChgAmt() {
		return this.dvcChgAmt;
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
	 * @return newPorCd
	 */
	public String getNewPorCd() {
		return this.newPorCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return oldPorCd
	 */
	public String getOldPorCd() {
		return this.oldPorCd;
	}
	
	/**
	 * Column Info
	 * @return oldPolCd
	 */
	public String getOldPolCd() {
		return this.oldPolCd;
	}
	
	/**
	 * Column Info
	 * @return dateType
	 */
	public String getDateType() {
		return this.dateType;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return newCorrNo
	 */
	public String getNewCorrNo() {
		return this.newCorrNo;
	}
	
	/**
	 * Column Info
	 * @return oldPodCd
	 */
	public String getOldPodCd() {
		return this.oldPodCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return caSeq
	 */
	public String getCaSeq() {
		return this.caSeq;
	}
	
	/**
	 * Column Info
	 * @return newPodCd
	 */
	public String getNewPodCd() {
		return this.newPodCd;
	}
	
	/**
	 * Column Info
	 * @return dvcRatAsQty
	 */
	public String getDvcRatAsQty() {
		return this.dvcRatAsQty;
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
	 * @return dvcChgUtAmt
	 */
	public String getDvcChgUtAmt() {
		return this.dvcChgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return oldCorrNo
	 */
	public String getOldCorrNo() {
		return this.oldCorrNo;
	}
	

	/**
	 * Column Info
	 * @param dvcRatUtCd
	 */
	public void setDvcRatUtCd(String dvcRatUtCd) {
		this.dvcRatUtCd = dvcRatUtCd;
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
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
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
	 * @param dvcCurrCd
	 */
	public void setDvcCurrCd(String dvcCurrCd) {
		this.dvcCurrCd = dvcCurrCd;
	}
	
	/**
	 * Column Info
	 * @param newDelCd
	 */
	public void setNewDelCd(String newDelCd) {
		this.newDelCd = newDelCd;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param newPolCd
	 */
	public void setNewPolCd(String newPolCd) {
		this.newPolCd = newPolCd;
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
	 * @param oldDelCd
	 */
	public void setOldDelCd(String oldDelCd) {
		this.oldDelCd = oldDelCd;
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
	 * @param dvcChgAmt
	 */
	public void setDvcChgAmt(String dvcChgAmt) {
		this.dvcChgAmt = dvcChgAmt;
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
	 * @param newPorCd
	 */
	public void setNewPorCd(String newPorCd) {
		this.newPorCd = newPorCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param oldPorCd
	 */
	public void setOldPorCd(String oldPorCd) {
		this.oldPorCd = oldPorCd;
	}
	
	/**
	 * Column Info
	 * @param oldPolCd
	 */
	public void setOldPolCd(String oldPolCd) {
		this.oldPolCd = oldPolCd;
	}
	
	/**
	 * Column Info
	 * @param dateType
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param newCorrNo
	 */
	public void setNewCorrNo(String newCorrNo) {
		this.newCorrNo = newCorrNo;
	}
	
	/**
	 * Column Info
	 * @param oldPodCd
	 */
	public void setOldPodCd(String oldPodCd) {
		this.oldPodCd = oldPodCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param caSeq
	 */
	public void setCaSeq(String caSeq) {
		this.caSeq = caSeq;
	}
	
	/**
	 * Column Info
	 * @param newPodCd
	 */
	public void setNewPodCd(String newPodCd) {
		this.newPodCd = newPodCd;
	}
	
	/**
	 * Column Info
	 * @param dvcRatAsQty
	 */
	public void setDvcRatAsQty(String dvcRatAsQty) {
		this.dvcRatAsQty = dvcRatAsQty;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
	}
	
	/**
	 * Column Info
	 * @param dvcChgUtAmt
	 */
	public void setDvcChgUtAmt(String dvcChgUtAmt) {
		this.dvcChgUtAmt = dvcChgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param oldCorrNo
	 */
	public void setOldCorrNo(String oldCorrNo) {
		this.oldCorrNo = oldCorrNo;
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
		setDvcRatUtCd(JSPUtil.getParameter(request, prefix + "dvc_rat_ut_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDvcCurrCd(JSPUtil.getParameter(request, prefix + "dvc_curr_cd", ""));
		setNewDelCd(JSPUtil.getParameter(request, prefix + "new_del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setNewPolCd(JSPUtil.getParameter(request, prefix + "new_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOldDelCd(JSPUtil.getParameter(request, prefix + "old_del_cd", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setDvcChgAmt(JSPUtil.getParameter(request, prefix + "dvc_chg_amt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setNewPorCd(JSPUtil.getParameter(request, prefix + "new_por_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOldPorCd(JSPUtil.getParameter(request, prefix + "old_por_cd", ""));
		setOldPolCd(JSPUtil.getParameter(request, prefix + "old_pol_cd", ""));
		setDateType(JSPUtil.getParameter(request, prefix + "date_type", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setNewCorrNo(JSPUtil.getParameter(request, prefix + "new_corr_no", ""));
		setOldPodCd(JSPUtil.getParameter(request, prefix + "old_pod_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCaSeq(JSPUtil.getParameter(request, prefix + "ca_seq", ""));
		setNewPodCd(JSPUtil.getParameter(request, prefix + "new_pod_cd", ""));
		setDvcRatAsQty(JSPUtil.getParameter(request, prefix + "dvc_rat_as_qty", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setDvcChgUtAmt(JSPUtil.getParameter(request, prefix + "dvc_chg_ut_amt", ""));
		setOldCorrNo(JSPUtil.getParameter(request, prefix + "old_corr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DiversionCAVO[]
	 */
	public DiversionCAVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DiversionCAVO[]
	 */
	public DiversionCAVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DiversionCAVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dvcRatUtCd = (JSPUtil.getParameter(request, prefix	+ "dvc_rat_ut_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] dvcCurrCd = (JSPUtil.getParameter(request, prefix	+ "dvc_curr_cd", length));
			String[] newDelCd = (JSPUtil.getParameter(request, prefix	+ "new_del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] newPolCd = (JSPUtil.getParameter(request, prefix	+ "new_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldDelCd = (JSPUtil.getParameter(request, prefix	+ "old_del_cd", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] dvcChgAmt = (JSPUtil.getParameter(request, prefix	+ "dvc_chg_amt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] newPorCd = (JSPUtil.getParameter(request, prefix	+ "new_por_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] oldPorCd = (JSPUtil.getParameter(request, prefix	+ "old_por_cd", length));
			String[] oldPolCd = (JSPUtil.getParameter(request, prefix	+ "old_pol_cd", length));
			String[] dateType = (JSPUtil.getParameter(request, prefix	+ "date_type", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] newCorrNo = (JSPUtil.getParameter(request, prefix	+ "new_corr_no", length));
			String[] oldPodCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] caSeq = (JSPUtil.getParameter(request, prefix	+ "ca_seq", length));
			String[] newPodCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_cd", length));
			String[] dvcRatAsQty = (JSPUtil.getParameter(request, prefix	+ "dvc_rat_as_qty", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] dvcChgUtAmt = (JSPUtil.getParameter(request, prefix	+ "dvc_chg_ut_amt", length));
			String[] oldCorrNo = (JSPUtil.getParameter(request, prefix	+ "old_corr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DiversionCAVO();
				if (dvcRatUtCd[i] != null)
					model.setDvcRatUtCd(dvcRatUtCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (dvcCurrCd[i] != null)
					model.setDvcCurrCd(dvcCurrCd[i]);
				if (newDelCd[i] != null)
					model.setNewDelCd(newDelCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (newPolCd[i] != null)
					model.setNewPolCd(newPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldDelCd[i] != null)
					model.setOldDelCd(oldDelCd[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (dvcChgAmt[i] != null)
					model.setDvcChgAmt(dvcChgAmt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (newPorCd[i] != null)
					model.setNewPorCd(newPorCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (oldPorCd[i] != null)
					model.setOldPorCd(oldPorCd[i]);
				if (oldPolCd[i] != null)
					model.setOldPolCd(oldPolCd[i]);
				if (dateType[i] != null)
					model.setDateType(dateType[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (newCorrNo[i] != null)
					model.setNewCorrNo(newCorrNo[i]);
				if (oldPodCd[i] != null)
					model.setOldPodCd(oldPodCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (caSeq[i] != null)
					model.setCaSeq(caSeq[i]);
				if (newPodCd[i] != null)
					model.setNewPodCd(newPodCd[i]);
				if (dvcRatAsQty[i] != null)
					model.setDvcRatAsQty(dvcRatAsQty[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (dvcChgUtAmt[i] != null)
					model.setDvcChgUtAmt(dvcChgUtAmt[i]);
				if (oldCorrNo[i] != null)
					model.setOldCorrNo(oldCorrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDiversionCAVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DiversionCAVO[]
	 */
	public DiversionCAVO[] getDiversionCAVOs(){
		DiversionCAVO[] vos = (DiversionCAVO[])models.toArray(new DiversionCAVO[models.size()]);
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
		this.dvcRatUtCd = this.dvcRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcCurrCd = this.dvcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDelCd = this.newDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPolCd = this.newPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDelCd = this.oldDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcChgAmt = this.dvcChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPorCd = this.newPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPorCd = this.oldPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolCd = this.oldPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateType = this.dateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCorrNo = this.newCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodCd = this.oldPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caSeq = this.caSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodCd = this.newPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcRatAsQty = this.dvcRatAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcChgUtAmt = this.dvcChgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCorrNo = this.oldCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
