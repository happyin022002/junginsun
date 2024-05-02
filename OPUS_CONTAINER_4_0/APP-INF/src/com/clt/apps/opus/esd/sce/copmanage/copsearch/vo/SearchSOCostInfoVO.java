/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SearchSOCostInfoVO.java
 *@FileTitle : SearchSOCostInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.16
 *@LastModifier : 오현경
 *@LastVersion : 1.0
 * 2009.09.16 오현경 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copsearch.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSOCostInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchSOCostInfoVO> models = new ArrayList<SearchSOCostInfoVO>();

	/* Column Info */
	private String soDt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String soNum = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String fmTo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String soRmk2 = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String soRmk3 = null;
	/* Column Info */
	private String spHNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String soRmk1 = null;
	/* Column Info */
	private String woDt = null;
	/* Column Info */
	private String trspSoSts = null;
	/* Column Info */
	private String costActGrpNm = null;
	/* Column Info */
	private String cxlRqstRjctRsn = null;
	/* Column Info */
	private String mtcEdiRcvRsltFlg = null;
	/* Column Info */
	private String mtcEdiRcvRsltDt = null;
	/* Column Info */
	private String mtcEdiRcvRsltDtHms = null;
	/* Column Info */
	private String bilEdiSntDt = null;
	/* Column Info */
	private String bilEdiSntDtHms = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String railVndrNm = null;
	/* Column Info */
	private String bilEdiRcvRsltCd = null;
	/* Column Info */
	private String bilEdiRcvRsltDt = null;
	/* Column Info */
	private String bilEdiRcvRsltDtHms = null;
	/* Column Info */
	private String railFlg = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Column Info */
	private String deltDt = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchSOCostInfoVO() {
	}

	public SearchSOCostInfoVO(String ibflag, String pagerows, String copNo, String costActGrpSeq, String ctrlOfcCd, String costActGrpNm, String vndrAbbrNm, String trspSoSts, String soNum, String fmTo, String soDt, String userId, String spHNo, String soRmk1, String soRmk2, String soRmk3,
			String woNo, String woDt, String railVndrNm, String bilEdiSntDt, String bilEdiSntDtHms, String mtcEdiRcvRsltFlg, String mtcEdiRcvRsltDt, String mtcEdiRcvRsltDtHms, String cxlRqstRjctRsn, String wblNo, String bilEdiRcvRsltCd, String bilEdiRcvRsltDt, String bilEdiRcvRsltDtHms,
			String railFlg, String deltUsrId, String deltDt) {
		this.soDt = soDt;
		this.copNo = copNo;
		this.soNum = soNum;
		this.ctrlOfcCd = ctrlOfcCd;
		this.fmTo = fmTo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costActGrpSeq = costActGrpSeq;
		this.userId = userId;
		this.soRmk2 = soRmk2;
		this.woNo = woNo;
		this.soRmk3 = soRmk3;
		this.spHNo = spHNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.soRmk1 = soRmk1;
		this.woDt = woDt;
		this.trspSoSts = trspSoSts;
		this.costActGrpNm = costActGrpNm;
		this.mtcEdiRcvRsltDtHms = mtcEdiRcvRsltDtHms;
		this.cxlRqstRjctRsn = cxlRqstRjctRsn;
		this.mtcEdiRcvRsltDt = mtcEdiRcvRsltDt;
		this.bilEdiSntDt = bilEdiSntDt;
		this.wblNo = wblNo;
		this.mtcEdiRcvRsltFlg = mtcEdiRcvRsltFlg;
		this.railVndrNm = railVndrNm;
		this.bilEdiSntDtHms = bilEdiSntDtHms;
		this.bilEdiRcvRsltCd = bilEdiRcvRsltCd;
		this.bilEdiRcvRsltDt = bilEdiRcvRsltDt;
		this.bilEdiRcvRsltDtHms = bilEdiRcvRsltDtHms;
		this.railFlg = railFlg;
		this.deltUsrId = deltUsrId;
		this.deltDt= deltDt; 
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("so_dt", getSoDt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("so_num", getSoNum());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("fm_to", getFmTo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("so_rmk2", getSoRmk2());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("so_rmk3", getSoRmk3());
		this.hashColumns.put("sp_h_no", getSpHNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("so_rmk1", getSoRmk1());
		this.hashColumns.put("wo_dt", getWoDt());
		this.hashColumns.put("trsp_so_sts", getTrspSoSts());
		this.hashColumns.put("cost_act_grp_nm", getCostActGrpNm());
		this.hashColumns.put("mtc_edi_rcv_rslt_dt_hms", getMtcEdiRcvRsltDtHms());
		this.hashColumns.put("cxl_rqst_rjct_rsn", getCxlRqstRjctRsn());
		this.hashColumns.put("mtc_edi_rcv_rslt_dt", getMtcEdiRcvRsltDt());
		this.hashColumns.put("bil_edi_snt_dt", getBilEdiSntDt());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("mtc_edi_rcv_rslt_flg", getMtcEdiRcvRsltFlg());
		this.hashColumns.put("rail_vndr_nm", getRailVndrNm());
		this.hashColumns.put("bil_edi_snt_dt_hms", getBilEdiSntDtHms());
		this.hashColumns.put("bil_edi_rcv_rslt_cd", getBilEdiRcvRsltCd());
		this.hashColumns.put("bil_edi_rcv_rslt_dt", getBilEdiRcvRsltDt());
		this.hashColumns.put("bil_edi_rcv_rslt_dt_hms", getBilEdiRcvRsltDtHms());
		this.hashColumns.put("rail_flg", getRailFlg());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("delt_dt", getDeltDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("so_dt", "soDt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("so_num", "soNum");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("fm_to", "fmTo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("so_rmk2", "soRmk2");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("so_rmk3", "soRmk3");
		this.hashFields.put("sp_h_no", "spHNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("so_rmk1", "soRmk1");
		this.hashFields.put("wo_dt", "woDt");
		this.hashFields.put("trsp_so_sts", "trspSoSts");
		this.hashFields.put("cost_act_grp_nm", "costActGrpNm");
		this.hashFields.put("mtc_edi_rcv_rslt_dt_hms", "mtcEdiRcvRsltDtHms");
		this.hashFields.put("cxl_rqst_rjct_rsn", "cxlRqstRjctRsn");
		this.hashFields.put("mtc_edi_rcv_rslt_dt", "mtcEdiRcvRsltDt");
		this.hashFields.put("bil_edi_snt_dt", "bilEdiSntDt");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("mtc_edi_rcv_rslt_flg", "mtcEdiRcvRsltFlg");
		this.hashFields.put("rail_vndr_nm", "railVndrNm");
		this.hashFields.put("bil_edi_snt_dt_hms", "bilEdiSntDtHms");
		this.hashFields.put("bil_edi_rcv_rslt_cd", "bilEdiRcvRsltCd");
		this.hashFields.put("bil_edi_rcv_rslt_dt", "bilEdiRcvRsltDt");
		this.hashFields.put("bil_edi_rcv_rslt_dt_hms", "bilEdiRcvRsltDtHms");
		this.hashFields.put("rail_flg", "railFlg");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("delt_dt", "deltDt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return soDt
	 */
	public String getSoDt() {
		return this.soDt;
	}

	/**
	 * Column Info
	 * 
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}

	/**
	 * Column Info
	 * 
	 * @return soNum
	 */
	public String getSoNum() {
		return this.soNum;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return fmTo
	 */
	public String getFmTo() {
		return this.fmTo;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * 
	 * @return soRmk2
	 */
	public String getSoRmk2() {
		return this.soRmk2;
	}

	/**
	 * Column Info
	 * 
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}

	/**
	 * Column Info
	 * 
	 * @return soRmk3
	 */
	public String getSoRmk3() {
		return this.soRmk3;
	}

	/**
	 * Column Info
	 * 
	 * @return spHNo
	 */
	public String getSpHNo() {
		return this.spHNo;
	}

	/**
	 * Column Info
	 * 
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}

	/**
	 * Column Info
	 * 
	 * @return soRmk1
	 */
	public String getSoRmk1() {
		return this.soRmk1;
	}

	/**
	 * Column Info
	 * 
	 * @return woDt
	 */
	public String getWoDt() {
		return this.woDt;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoSts
	 */
	public String getTrspSoSts() {
		return this.trspSoSts;
	}

	/**
	 * Column Info
	 * 
	 * @return costActGrpNm
	 */
	public String getCostActGrpNm() {
		return this.costActGrpNm;
	}

	/**
	 * Column Info
	 * 
	 * @param soDt
	 */
	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}

	/**
	 * Column Info
	 * 
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	/**
	 * Column Info
	 * 
	 * @param soNum
	 */
	public void setSoNum(String soNum) {
		this.soNum = soNum;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param fmTo
	 */
	public void setFmTo(String fmTo) {
		this.fmTo = fmTo;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * 
	 * @param soRmk2
	 */
	public void setSoRmk2(String soRmk2) {
		this.soRmk2 = soRmk2;
	}

	/**
	 * Column Info
	 * 
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}

	/**
	 * Column Info
	 * 
	 * @param soRmk3
	 */
	public void setSoRmk3(String soRmk3) {
		this.soRmk3 = soRmk3;
	}

	/**
	 * Column Info
	 * 
	 * @param spHNo
	 */
	public void setSpHNo(String spHNo) {
		this.spHNo = spHNo;
	}

	/**
	 * Column Info
	 * 
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}

	/**
	 * Column Info
	 * 
	 * @param soRmk1
	 */
	public void setSoRmk1(String soRmk1) {
		this.soRmk1 = soRmk1;
	}

	/**
	 * Column Info
	 * 
	 * @param woDt
	 */
	public void setWoDt(String woDt) {
		this.woDt = woDt;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoSts
	 */
	public void setTrspSoSts(String trspSoSts) {
		this.trspSoSts = trspSoSts;
	}

	/**
	 * Column Info
	 * 
	 * @param costActGrpNm
	 */
	public void setCostActGrpNm(String costActGrpNm) {
		this.costActGrpNm = costActGrpNm;
	}

	/**
	 * Column Info
	 * 
	 * @return mtcEdiRcvRsltDtHms
	 */
	public String getMtcEdiRcvRsltDtHms() {
		return this.mtcEdiRcvRsltDtHms;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstRjctRsn
	 */
	public String getCxlRqstRjctRsn() {
		return this.cxlRqstRjctRsn;
	}

	/**
	 * Column Info
	 * 
	 * @return mtcEdiRcvRsltDt
	 */
	public String getMtcEdiRcvRsltDt() {
		return this.mtcEdiRcvRsltDt;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiSntDt
	 */
	public String getBilEdiSntDt() {
		return this.bilEdiSntDt;
	}

	/**
	 * Column Info
	 * 
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}

	/**
	 * Column Info
	 * 
	 * @return mtcEdiRcvRsltFlg
	 */
	public String getMtcEdiRcvRsltFlg() {
		return this.mtcEdiRcvRsltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return railVndrNm
	 */
	public String getRailVndrNm() {
		return this.railVndrNm;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiSntDtHms
	 */
	public String getBilEdiSntDtHms() {
		return this.bilEdiSntDtHms;
	}

	/**
	 * Column Info
	 * 
	 * @param mtcEdiRcvRsltDtHms
	 */
	public void setMtcEdiRcvRsltDtHms(String mtcEdiRcvRsltDtHms) {
		this.mtcEdiRcvRsltDtHms = mtcEdiRcvRsltDtHms;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstRjctRsn
	 */
	public void setCxlRqstRjctRsn(String cxlRqstRjctRsn) {
		this.cxlRqstRjctRsn = cxlRqstRjctRsn;
	}

	/**
	 * Column Info
	 * 
	 * @param mtcEdiRcvRsltDt
	 */
	public void setMtcEdiRcvRsltDt(String mtcEdiRcvRsltDt) {
		this.mtcEdiRcvRsltDt = mtcEdiRcvRsltDt;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiSntDt
	 */
	public void setBilEdiSntDt(String bilEdiSntDt) {
		this.bilEdiSntDt = bilEdiSntDt;
	}

	/**
	 * Column Info
	 * 
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}

	/**
	 * Column Info
	 * 
	 * @param mtcEdiRcvRsltFlg
	 */
	public void setMtcEdiRcvRsltFlg(String mtcEdiRcvRsltFlg) {
		this.mtcEdiRcvRsltFlg = mtcEdiRcvRsltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param railVndrNm
	 */
	public void setRailVndrNm(String railVndrNm) {
		this.railVndrNm = railVndrNm;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiSntDtHms
	 */
	public void setBilEdiSntDtHms(String bilEdiSntDtHms) {
		this.bilEdiSntDtHms = bilEdiSntDtHms;
	}

	public String getBilEdiRcvRsltCd() {
		return bilEdiRcvRsltCd;
	}

	public void setBilEdiRcvRsltCd(String bilEdiRcvRsltCd) {
		this.bilEdiRcvRsltCd = bilEdiRcvRsltCd;
	}

	public String getBilEdiRcvRsltDt() {
		return bilEdiRcvRsltDt;
	}

	public void setBilEdiRcvRsltDt(String bilEdiRcvRsltDt) {
		this.bilEdiRcvRsltDt = bilEdiRcvRsltDt;
	}

	public String getBilEdiRcvRsltDtHms() {
		return bilEdiRcvRsltDtHms;
	}

	public void setBilEdiRcvRsltDtHms(String bilEdiRcvRsltDtHms) {
		this.bilEdiRcvRsltDtHms = bilEdiRcvRsltDtHms;
	}

	/**
	 * 
	 * @return
	 */
	public String getRailFlg() {
		return railFlg;
	}

	/**
	 * 
	 * @param railFlg
	 */
	public void setRailFlg(String railFlg) {
		this.railFlg = railFlg;
	}

	public String getDeltUsrId() {
		return deltUsrId;
	}

	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
	}

	public String getDeltDt() {
		return deltDt;
	}

	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSoDt(JSPUtil.getParameter(request, "so_dt", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setSoNum(JSPUtil.getParameter(request, "so_num", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setFmTo(JSPUtil.getParameter(request, "fm_to", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, "cost_act_grp_seq", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setSoRmk2(JSPUtil.getParameter(request, "so_rmk2", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setSoRmk3(JSPUtil.getParameter(request, "so_rmk3", ""));
		setSpHNo(JSPUtil.getParameter(request, "sp_h_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setSoRmk1(JSPUtil.getParameter(request, "so_rmk1", ""));
		setWoDt(JSPUtil.getParameter(request, "wo_dt", ""));
		setTrspSoSts(JSPUtil.getParameter(request, "trsp_so_sts", ""));
		setCostActGrpNm(JSPUtil.getParameter(request, "cost_act_grp_nm", ""));
		setMtcEdiRcvRsltDtHms(JSPUtil.getParameter(request, "mtc_edi_rcv_rslt_dt_hms", ""));
		setCxlRqstRjctRsn(JSPUtil.getParameter(request, "cxl_rqst_rjct_rsn", ""));
		setMtcEdiRcvRsltDt(JSPUtil.getParameter(request, "mtc_edi_rcv_rslt_dt", ""));
		setBilEdiSntDt(JSPUtil.getParameter(request, "bil_edi_snt_dt", ""));
		setWblNo(JSPUtil.getParameter(request, "wbl_no", ""));
		setMtcEdiRcvRsltFlg(JSPUtil.getParameter(request, "mtc_edi_rcv_rslt_flg", ""));
		setRailVndrNm(JSPUtil.getParameter(request, "rail_vndr_nm", ""));
		setBilEdiSntDtHms(JSPUtil.getParameter(request, "bil_edi_snt_dt_hms", ""));
		setBilEdiRcvRsltCd(JSPUtil.getParameter(request, "bil_edi_rcv_rslt_cd", ""));
		setBilEdiRcvRsltDt(JSPUtil.getParameter(request, "bil_edi_rcv_rslt_dt", ""));
		setBilEdiRcvRsltDtHms(JSPUtil.getParameter(request, "bil_edi_rcv_rslt_dt_hms", ""));
		setRailFlg(JSPUtil.getParameter(request, "rail_flg", ""));
		setDeltUsrId(JSPUtil.getParameter(request, "delt_usr_id", ""));
		setDeltDt(JSPUtil.getParameter(request, "delt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return SearchSOCostInfoVO[]
	 */
	public SearchSOCostInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return SearchSOCostInfoVO[]
	 */
	public SearchSOCostInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSOCostInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] soDt = (JSPUtil.getParameter(request, prefix + "so_dt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix + "cop_no", length));
			String[] soNum = (JSPUtil.getParameter(request, prefix + "so_num", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", length));
			String[] fmTo = (JSPUtil.getParameter(request, prefix + "fm_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", length));
			String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
			String[] soRmk2 = (JSPUtil.getParameter(request, prefix + "so_rmk2", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix + "wo_no", length));
			String[] soRmk3 = (JSPUtil.getParameter(request, prefix + "so_rmk3", length));
			String[] spHNo = (JSPUtil.getParameter(request, prefix + "sp_h_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", length));
			String[] soRmk1 = (JSPUtil.getParameter(request, prefix + "so_rmk1", length));
			String[] woDt = (JSPUtil.getParameter(request, prefix + "wo_dt", length));
			String[] trspSoSts = (JSPUtil.getParameter(request, prefix + "trsp_so_sts", length));
			String[] costActGrpNm = (JSPUtil.getParameter(request, prefix + "cost_act_grp_nm", length));
			String[] mtcEdiRcvRsltDtHms = (JSPUtil.getParameter(request, prefix + "mtc_edi_rcv_rslt_dt_hms", length));
			String[] cxlRqstRjctRsn = (JSPUtil.getParameter(request, prefix + "cxl_rqst_rjct_rsn", length));
			String[] mtcEdiRcvRsltDt = (JSPUtil.getParameter(request, prefix + "mtc_edi_rcv_rslt_dt", length));
			String[] bilEdiSntDt = (JSPUtil.getParameter(request, prefix + "bil_edi_snt_dt", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix + "wbl_no", length));
			String[] mtcEdiRcvRsltFlg = (JSPUtil.getParameter(request, prefix + "mtc_edi_rcv_rslt_flg", length));
			String[] railVndrNm = (JSPUtil.getParameter(request, prefix + "rail_vndr_nm", length));
			String[] bilEdiSntDtHms = (JSPUtil.getParameter(request, prefix + "bil_edi_snt_dt_hms", length));
			String[] bilEdiRcvRsltCd = (JSPUtil.getParameter(request, prefix + "bil_edi_rcv_rslt_cd", length));
			String[] bilEdiRcvRsltDt = (JSPUtil.getParameter(request, prefix + "bil_edi_rcv_rslt_dt", length));
			String[] bilEdiRcvRsltDtHms = (JSPUtil.getParameter(request, prefix + "bil_edi_rcv_rslt_dt_hms", length));
			String[] railFlg = (JSPUtil.getParameter(request, prefix + "rail_flg", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix + "delt_usr_id", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix + "delt_dt", length));

			for (int i = 0; i < length; i++) {
				model = new SearchSOCostInfoVO();
				if (soDt[i] != null)
					model.setSoDt(soDt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (soNum[i] != null)
					model.setSoNum(soNum[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (fmTo[i] != null)
					model.setFmTo(fmTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (soRmk2[i] != null)
					model.setSoRmk2(soRmk2[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (soRmk3[i] != null)
					model.setSoRmk3(soRmk3[i]);
				if (spHNo[i] != null)
					model.setSpHNo(spHNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (soRmk1[i] != null)
					model.setSoRmk1(soRmk1[i]);
				if (woDt[i] != null)
					model.setWoDt(woDt[i]);
				if (trspSoSts[i] != null)
					model.setTrspSoSts(trspSoSts[i]);
				if (costActGrpNm[i] != null)
					model.setCostActGrpNm(costActGrpNm[i]);
				if (mtcEdiRcvRsltDtHms[i] != null)
					model.setMtcEdiRcvRsltDtHms(mtcEdiRcvRsltDtHms[i]);
				if (cxlRqstRjctRsn[i] != null)
					model.setCxlRqstRjctRsn(cxlRqstRjctRsn[i]);
				if (mtcEdiRcvRsltDt[i] != null)
					model.setMtcEdiRcvRsltDt(mtcEdiRcvRsltDt[i]);
				if (bilEdiSntDt[i] != null)
					model.setBilEdiSntDt(bilEdiSntDt[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (mtcEdiRcvRsltFlg[i] != null)
					model.setMtcEdiRcvRsltFlg(mtcEdiRcvRsltFlg[i]);
				if (railVndrNm[i] != null)
					model.setRailVndrNm(railVndrNm[i]);
				if (bilEdiSntDtHms[i] != null)
					model.setBilEdiSntDtHms(bilEdiSntDtHms[i]);
				if (bilEdiRcvRsltCd[i] != null)
					model.setBilEdiRcvRsltCd(bilEdiRcvRsltCd[i]);
				if (bilEdiRcvRsltDt[i] != null)
					model.setBilEdiRcvRsltDt(bilEdiRcvRsltDt[i]);
				if (bilEdiRcvRsltDtHms[i] != null)
					model.setBilEdiRcvRsltDtHms(bilEdiRcvRsltDtHms[i]);
				if (railFlg[i] != null)
					model.setRailFlg(railFlg[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSOCostInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return SearchSOCostInfoVO[]
	 */
	public SearchSOCostInfoVO[] getSearchSOCostInfoVOs() {
		SearchSOCostInfoVO[] vos = (SearchSOCostInfoVO[]) models.toArray(new SearchSOCostInfoVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.soDt = this.soDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNum = this.soNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTo = this.fmTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRmk2 = this.soRmk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRmk3 = this.soRmk3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spHNo = this.spHNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRmk1 = this.soRmk1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woDt = this.woDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSts = this.trspSoSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpNm = this.costActGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtcEdiRcvRsltDtHms = this.mtcEdiRcvRsltDtHms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstRjctRsn = this.cxlRqstRjctRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtcEdiRcvRsltDt = this.mtcEdiRcvRsltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiSntDt = this.bilEdiSntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtcEdiRcvRsltFlg = this.mtcEdiRcvRsltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railVndrNm = this.railVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiSntDtHms = this.bilEdiSntDtHms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiRcvRsltCd = this.bilEdiRcvRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiRcvRsltDt = this.bilEdiRcvRsltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiRcvRsltDtHms = this.bilEdiRcvRsltDtHms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railFlg = this.railFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
