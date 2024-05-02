/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EventDateUpdateHistoryParmVO.java
*@FileTitle : EventDateUpdateHistoryParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.02
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.12.02 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EventDateUpdateHistoryParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EventDateUpdateHistoryParmVO> models = new ArrayList<EventDateUpdateHistoryParmVO>();
	
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String locationGb = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pDate1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String preCnmvEvntDt = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String pCntrno = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String socCd = null;
	/* Column Info */
	private String ydCdDisp = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String statusCd = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String crntCnmvEvntDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String peCo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cnmvUpdHisSeq = null;
	/* Column Info */
	private String gap = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EventDateUpdateHistoryParmVO() {}

	public EventDateUpdateHistoryParmVO(String ibflag, String pagerows, String mvmtEdiMsgTpId, String locationGb, String checkDigit, String fcntrFlg, String pDate1, String usrNm, String pDate2, String preCnmvEvntDt, String tpSz, String updLoclDt, String orgYdCd, String cnmvIdNo, String vvd, String pCntrno, String ofcCd, String bkgNo, String socCd, String ydCdDisp, String statusCd, String creLoclDt, String pYard2, String crntCnmvEvntDt, String cntrNo, String sts, String peCo, String cnmvUpdHisSeq, String cnmvYr, String gap, String cnmvRmk) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.locationGb = locationGb;
		this.checkDigit = checkDigit;
		this.fcntrFlg = fcntrFlg;
		this.pagerows = pagerows;
		this.pDate1 = pDate1;
		this.ibflag = ibflag;
		this.pDate2 = pDate2;
		this.usrNm = usrNm;
		this.tpSz = tpSz;
		this.preCnmvEvntDt = preCnmvEvntDt;
		this.updLoclDt = updLoclDt;
		this.orgYdCd = orgYdCd;
		this.cnmvIdNo = cnmvIdNo;
		this.vvd = vvd;
		this.pCntrno = pCntrno;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.socCd = socCd;
		this.ydCdDisp = ydCdDisp;
		this.cnmvRmk = cnmvRmk;
		this.statusCd = statusCd;
		this.creLoclDt = creLoclDt;
		this.pYard2 = pYard2;
		this.crntCnmvEvntDt = crntCnmvEvntDt;
		this.cntrNo = cntrNo;
		this.sts = sts;
		this.peCo = peCo;
		this.cnmvYr = cnmvYr;
		this.cnmvUpdHisSeq = cnmvUpdHisSeq;
		this.gap = gap;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("location_gb", getLocationGb());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("pre_cnmv_evnt_dt", getPreCnmvEvntDt());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("soc_cd", getSocCd());
		this.hashColumns.put("yd_cd_disp", getYdCdDisp());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("crnt_cnmv_evnt_dt", getCrntCnmvEvntDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("pe_co", getPeCo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cnmv_upd_his_seq", getCnmvUpdHisSeq());
		this.hashColumns.put("gap", getGap());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("location_gb", "locationGb");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("pre_cnmv_evnt_dt", "preCnmvEvntDt");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("soc_cd", "socCd");
		this.hashFields.put("yd_cd_disp", "ydCdDisp");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("crnt_cnmv_evnt_dt", "crntCnmvEvntDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("pe_co", "peCo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_upd_his_seq", "cnmvUpdHisSeq");
		this.hashFields.put("gap", "gap");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return locationGb
	 */
	public String getLocationGb() {
		return this.locationGb;
	}
	
	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
	}
	
	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
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
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * Column Info
	 * @return preCnmvEvntDt
	 */
	public String getPreCnmvEvntDt() {
		return this.preCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return updLoclDt
	 */
	public String getUpdLoclDt() {
		return this.updLoclDt;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
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
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return socCd
	 */
	public String getSocCd() {
		return this.socCd;
	}
	
	/**
	 * Column Info
	 * @return ydCdDisp
	 */
	public String getYdCdDisp() {
		return this.ydCdDisp;
	}
	
	/**
	 * Column Info
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @return statusCd
	 */
	public String getStatusCd() {
		return this.statusCd;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}
	
	/**
	 * Column Info
	 * @return crntCnmvEvntDt
	 */
	public String getCrntCnmvEvntDt() {
		return this.crntCnmvEvntDt;
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
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return peCo
	 */
	public String getPeCo() {
		return this.peCo;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return cnmvUpdHisSeq
	 */
	public String getCnmvUpdHisSeq() {
		return this.cnmvUpdHisSeq;
	}
	
	/**
	 * Column Info
	 * @return gap
	 */
	public String getGap() {
		return this.gap;
	}
	

	/**
	 * Column Info
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param locationGb
	 */
	public void setLocationGb(String locationGb) {
		this.locationGb = locationGb;
	}
	
	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}
	
	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
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
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * Column Info
	 * @param preCnmvEvntDt
	 */
	public void setPreCnmvEvntDt(String preCnmvEvntDt) {
		this.preCnmvEvntDt = preCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param updLoclDt
	 */
	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
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
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param socCd
	 */
	public void setSocCd(String socCd) {
		this.socCd = socCd;
	}
	
	/**
	 * Column Info
	 * @param ydCdDisp
	 */
	public void setYdCdDisp(String ydCdDisp) {
		this.ydCdDisp = ydCdDisp;
	}
	
	/**
	 * Column Info
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @param statusCd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}
	
	/**
	 * Column Info
	 * @param crntCnmvEvntDt
	 */
	public void setCrntCnmvEvntDt(String crntCnmvEvntDt) {
		this.crntCnmvEvntDt = crntCnmvEvntDt;
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
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param peCo
	 */
	public void setPeCo(String peCo) {
		this.peCo = peCo;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param cnmvUpdHisSeq
	 */
	public void setCnmvUpdHisSeq(String cnmvUpdHisSeq) {
		this.cnmvUpdHisSeq = cnmvUpdHisSeq;
	}
	
	/**
	 * Column Info
	 * @param gap
	 */
	public void setGap(String gap) {
		this.gap = gap;
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
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setLocationGb(JSPUtil.getParameter(request, prefix + "location_gb", ""));
		setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setTpSz(JSPUtil.getParameter(request, prefix + "tp_sz", ""));
		setPreCnmvEvntDt(JSPUtil.getParameter(request, prefix + "pre_cnmv_evnt_dt", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, prefix + "upd_locl_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPCntrno(JSPUtil.getParameter(request, prefix + "p_cntrno", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSocCd(JSPUtil.getParameter(request, prefix + "soc_cd", ""));
		setYdCdDisp(JSPUtil.getParameter(request, prefix + "yd_cd_disp", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setStatusCd(JSPUtil.getParameter(request, prefix + "status_cd", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setPYard2(JSPUtil.getParameter(request, prefix + "p_yard2", ""));
		setCrntCnmvEvntDt(JSPUtil.getParameter(request, prefix + "crnt_cnmv_evnt_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSts(JSPUtil.getParameter(request, prefix + "sts", ""));
		setPeCo(JSPUtil.getParameter(request, prefix + "pe_co", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setCnmvUpdHisSeq(JSPUtil.getParameter(request, prefix + "cnmv_upd_his_seq", ""));
		setGap(JSPUtil.getParameter(request, prefix + "gap", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EventDateUpdateHistoryParmVO[]
	 */
	public EventDateUpdateHistoryParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EventDateUpdateHistoryParmVO[]
	 */
	public EventDateUpdateHistoryParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EventDateUpdateHistoryParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] locationGb = (JSPUtil.getParameter(request, prefix	+ "location_gb", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] preCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "pre_cnmv_evnt_dt", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] socCd = (JSPUtil.getParameter(request, prefix	+ "soc_cd", length));
			String[] ydCdDisp = (JSPUtil.getParameter(request, prefix	+ "yd_cd_disp", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] crntCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "crnt_cnmv_evnt_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] peCo = (JSPUtil.getParameter(request, prefix	+ "pe_co", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cnmvUpdHisSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_upd_his_seq", length));
			String[] gap = (JSPUtil.getParameter(request, prefix	+ "gap", length));
			
			for (int i = 0; i < length; i++) {
				model = new EventDateUpdateHistoryParmVO();
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (locationGb[i] != null)
					model.setLocationGb(locationGb[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (preCnmvEvntDt[i] != null)
					model.setPreCnmvEvntDt(preCnmvEvntDt[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (socCd[i] != null)
					model.setSocCd(socCd[i]);
				if (ydCdDisp[i] != null)
					model.setYdCdDisp(ydCdDisp[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (crntCnmvEvntDt[i] != null)
					model.setCrntCnmvEvntDt(crntCnmvEvntDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (peCo[i] != null)
					model.setPeCo(peCo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cnmvUpdHisSeq[i] != null)
					model.setCnmvUpdHisSeq(cnmvUpdHisSeq[i]);
				if (gap[i] != null)
					model.setGap(gap[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEventDateUpdateHistoryParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EventDateUpdateHistoryParmVO[]
	 */
	public EventDateUpdateHistoryParmVO[] getEventDateUpdateHistoryParmVOs(){
		EventDateUpdateHistoryParmVO[] vos = (EventDateUpdateHistoryParmVO[])models.toArray(new EventDateUpdateHistoryParmVO[models.size()]);
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
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationGb = this.locationGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCnmvEvntDt = this.preCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socCd = this.socCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCdDisp = this.ydCdDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCnmvEvntDt = this.crntCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.peCo = this.peCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvUpdHisSeq = this.cnmvUpdHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gap = this.gap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
