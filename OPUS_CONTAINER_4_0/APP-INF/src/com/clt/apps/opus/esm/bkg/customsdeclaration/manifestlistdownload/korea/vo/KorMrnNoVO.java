/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorMrnNoVO.java
*@FileTitle : KorMrnNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMrnNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorMrnNoVO> models = new ArrayList<KorMrnNoVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String blEmpty = null;
	/* Column Info */
	private String inPod = null;
	/* Column Info */
	private String inBound = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String correction = null;
	/* Column Info */
	private String elType = null;
	/* Column Info */
	private String inPol = null;
	/* Column Info */
	private String blDl = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrTsEmpty = null;
	/* Column Info */
	private String cntrLocal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String blTsEmpty = null;
	/* Column Info */
	private String ktPort = null;
	/* Column Info */
	private String cntrTotal = null;
	/* Column Info */
	private String inPolYd = null;
	/* Column Info */
	private String inPodTmnl = null;
	/* Column Info */
	private String blLocal = null;
	/* Column Info */
	private String selType = null;
	/* Column Info */
	private String mrnChkNo = null;
	/* Column Info */
	private String blType = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String downCnt = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String inPolTmnl = null;
	/* Column Info */
	private String allErr = null;
	/* Column Info */
	private String etaEtd = null;
	/* Column Info */
	private String blTotal = null;
	/* Column Info */
	private String cntrEmpty = null;
	/* Column Info */
	private String inBlno = null;
	/* Column Info */
	private String inHn = null;
	/* Column Info */
	private String blTs = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String cntrTs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorMrnNoVO() {}

	public KorMrnNoVO(String ibflag, String pagerows, String allErr, String blDl, String blEmpty, String blLocal, String blNo, String blTotal, String blTs, String blTsEmpty, String blType, String cntrEmpty, String cntrLocal, String cntrTotal, String cntrTs, String cntrTsEmpty, String correction, String downCnt, String elType, String etaDt, String etaEtd, String etbDt, String etdDt, String inBkgNo, String inBlno, String inBound, String inHn, String inPod, String inPodTmnl, String inPol, String inPolYd, String inPolTmnl, String inVvd, String ktPort, String mrnChkNo, String mrnNo, String sc, String selType) {
		this.inVvd = inVvd;
		this.blEmpty = blEmpty;
		this.inPod = inPod;
		this.inBound = inBound;
		this.etaDt = etaDt;
		this.correction = correction;
		this.elType = elType;
		this.inPol = inPol;
		this.blDl = blDl;
		this.mrnNo = mrnNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cntrTsEmpty = cntrTsEmpty;
		this.cntrLocal = cntrLocal;
		this.ibflag = ibflag;
		this.etbDt = etbDt;
		this.blTsEmpty = blTsEmpty;
		this.ktPort = ktPort;
		this.cntrTotal = cntrTotal;
		this.inPolYd = inPolYd;
		this.inPodTmnl = inPodTmnl;
		this.blLocal = blLocal;
		this.selType = selType;
		this.mrnChkNo = mrnChkNo;
		this.blType = blType;
		this.sc = sc;
		this.downCnt = downCnt;
		this.etdDt = etdDt;
		this.inPolTmnl = inPolTmnl;
		this.allErr = allErr;
		this.etaEtd = etaEtd;
		this.blTotal = blTotal;
		this.cntrEmpty = cntrEmpty;
		this.inBlno = inBlno;
		this.inHn = inHn;
		this.blTs = blTs;
		this.inBkgNo = inBkgNo;
		this.cntrTs = cntrTs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("bl_empty", getBlEmpty());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("in_bound", getInBound());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("correction", getCorrection());
		this.hashColumns.put("el_type", getElType());
		this.hashColumns.put("in_pol", getInPol());
		this.hashColumns.put("bl_dl", getBlDl());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_ts_empty", getCntrTsEmpty());
		this.hashColumns.put("cntr_local", getCntrLocal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("bl_ts_empty", getBlTsEmpty());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("cntr_total", getCntrTotal());
		this.hashColumns.put("in_pol_yd", getInPolYd());
		this.hashColumns.put("in_pod_tmnl", getInPodTmnl());
		this.hashColumns.put("bl_local", getBlLocal());
		this.hashColumns.put("sel_type", getSelType());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("bl_type", getBlType());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("down_cnt", getDownCnt());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("in_pol_tmnl", getInPolTmnl());
		this.hashColumns.put("all_err", getAllErr());
		this.hashColumns.put("eta_etd", getEtaEtd());
		this.hashColumns.put("bl_total", getBlTotal());
		this.hashColumns.put("cntr_empty", getCntrEmpty());
		this.hashColumns.put("in_blno", getInBlno());
		this.hashColumns.put("in_hn", getInHn());
		this.hashColumns.put("bl_ts", getBlTs());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("cntr_ts", getCntrTs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("bl_empty", "blEmpty");
		this.hashFields.put("in_pod", "inPod");
		this.hashFields.put("in_bound", "inBound");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("correction", "correction");
		this.hashFields.put("el_type", "elType");
		this.hashFields.put("in_pol", "inPol");
		this.hashFields.put("bl_dl", "blDl");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_ts_empty", "cntrTsEmpty");
		this.hashFields.put("cntr_local", "cntrLocal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("bl_ts_empty", "blTsEmpty");
		this.hashFields.put("kt_port", "ktPort");
		this.hashFields.put("cntr_total", "cntrTotal");
		this.hashFields.put("in_pol_yd", "inPolYd");
		this.hashFields.put("in_pod_tmnl", "inPodTmnl");
		this.hashFields.put("bl_local", "blLocal");
		this.hashFields.put("sel_type", "selType");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("bl_type", "blType");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("down_cnt", "downCnt");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("in_pol_tmnl", "inPolTmnl");
		this.hashFields.put("all_err", "allErr");
		this.hashFields.put("eta_etd", "etaEtd");
		this.hashFields.put("bl_total", "blTotal");
		this.hashFields.put("cntr_empty", "cntrEmpty");
		this.hashFields.put("in_blno", "inBlno");
		this.hashFields.put("in_hn", "inHn");
		this.hashFields.put("bl_ts", "blTs");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("cntr_ts", "cntrTs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return blEmpty
	 */
	public String getBlEmpty() {
		return this.blEmpty;
	}
	
	/**
	 * Column Info
	 * @return inPod
	 */
	public String getInPod() {
		return this.inPod;
	}
	
	/**
	 * Column Info
	 * @return inBound
	 */
	public String getInBound() {
		return this.inBound;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return correction
	 */
	public String getCorrection() {
		return this.correction;
	}
	
	/**
	 * Column Info
	 * @return elType
	 */
	public String getElType() {
		return this.elType;
	}
	
	/**
	 * Column Info
	 * @return inPol
	 */
	public String getInPol() {
		return this.inPol;
	}
	
	/**
	 * Column Info
	 * @return blDl
	 */
	public String getBlDl() {
		return this.blDl;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return cntrTsEmpty
	 */
	public String getCntrTsEmpty() {
		return this.cntrTsEmpty;
	}
	
	/**
	 * Column Info
	 * @return cntrLocal
	 */
	public String getCntrLocal() {
		return this.cntrLocal;
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
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}
	
	/**
	 * Column Info
	 * @return blTsEmpty
	 */
	public String getBlTsEmpty() {
		return this.blTsEmpty;
	}
	
	/**
	 * Column Info
	 * @return ktPort
	 */
	public String getKtPort() {
		return this.ktPort;
	}
	
	/**
	 * Column Info
	 * @return cntrTotal
	 */
	public String getCntrTotal() {
		return this.cntrTotal;
	}
	
	/**
	 * Column Info
	 * @return inPolYd
	 */
	public String getInPolYd() {
		return this.inPolYd;
	}
	
	/**
	 * Column Info
	 * @return inPodTmnl
	 */
	public String getInPodTmnl() {
		return this.inPodTmnl;
	}
	
	/**
	 * Column Info
	 * @return blLocal
	 */
	public String getBlLocal() {
		return this.blLocal;
	}
	
	/**
	 * Column Info
	 * @return selType
	 */
	public String getSelType() {
		return this.selType;
	}
	
	/**
	 * Column Info
	 * @return mrnChkNo
	 */
	public String getMrnChkNo() {
		return this.mrnChkNo;
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
	 * @return sc
	 */
	public String getSc() {
		return this.sc;
	}
	
	/**
	 * Column Info
	 * @return downCnt
	 */
	public String getDownCnt() {
		return this.downCnt;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return inPolTmnl
	 */
	public String getInPolTmnl() {
		return this.inPolTmnl;
	}
	
	/**
	 * Column Info
	 * @return allErr
	 */
	public String getAllErr() {
		return this.allErr;
	}
	
	/**
	 * Column Info
	 * @return etaEtd
	 */
	public String getEtaEtd() {
		return this.etaEtd;
	}
	
	/**
	 * Column Info
	 * @return blTotal
	 */
	public String getBlTotal() {
		return this.blTotal;
	}
	
	/**
	 * Column Info
	 * @return cntrEmpty
	 */
	public String getCntrEmpty() {
		return this.cntrEmpty;
	}
	
	/**
	 * Column Info
	 * @return inBlno
	 */
	public String getInBlno() {
		return this.inBlno;
	}
	
	/**
	 * Column Info
	 * @return inHn
	 */
	public String getInHn() {
		return this.inHn;
	}
	
	/**
	 * Column Info
	 * @return blTs
	 */
	public String getBlTs() {
		return this.blTs;
	}
	
	/**
	 * Column Info
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTs
	 */
	public String getCntrTs() {
		return this.cntrTs;
	}
	

	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param blEmpty
	 */
	public void setBlEmpty(String blEmpty) {
		this.blEmpty = blEmpty;
	}
	
	/**
	 * Column Info
	 * @param inPod
	 */
	public void setInPod(String inPod) {
		this.inPod = inPod;
	}
	
	/**
	 * Column Info
	 * @param inBound
	 */
	public void setInBound(String inBound) {
		this.inBound = inBound;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param correction
	 */
	public void setCorrection(String correction) {
		this.correction = correction;
	}
	
	/**
	 * Column Info
	 * @param elType
	 */
	public void setElType(String elType) {
		this.elType = elType;
	}
	
	/**
	 * Column Info
	 * @param inPol
	 */
	public void setInPol(String inPol) {
		this.inPol = inPol;
	}
	
	/**
	 * Column Info
	 * @param blDl
	 */
	public void setBlDl(String blDl) {
		this.blDl = blDl;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param cntrTsEmpty
	 */
	public void setCntrTsEmpty(String cntrTsEmpty) {
		this.cntrTsEmpty = cntrTsEmpty;
	}
	
	/**
	 * Column Info
	 * @param cntrLocal
	 */
	public void setCntrLocal(String cntrLocal) {
		this.cntrLocal = cntrLocal;
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
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}
	
	/**
	 * Column Info
	 * @param blTsEmpty
	 */
	public void setBlTsEmpty(String blTsEmpty) {
		this.blTsEmpty = blTsEmpty;
	}
	
	/**
	 * Column Info
	 * @param ktPort
	 */
	public void setKtPort(String ktPort) {
		this.ktPort = ktPort;
	}
	
	/**
	 * Column Info
	 * @param cntrTotal
	 */
	public void setCntrTotal(String cntrTotal) {
		this.cntrTotal = cntrTotal;
	}
	
	/**
	 * Column Info
	 * @param inPolYd
	 */
	public void setInPolYd(String inPolYd) {
		this.inPolYd = inPolYd;
	}
	
	/**
	 * Column Info
	 * @param inPodTmnl
	 */
	public void setInPodTmnl(String inPodTmnl) {
		this.inPodTmnl = inPodTmnl;
	}
	
	/**
	 * Column Info
	 * @param blLocal
	 */
	public void setBlLocal(String blLocal) {
		this.blLocal = blLocal;
	}
	
	/**
	 * Column Info
	 * @param selType
	 */
	public void setSelType(String selType) {
		this.selType = selType;
	}
	
	/**
	 * Column Info
	 * @param mrnChkNo
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
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
	 * @param sc
	 */
	public void setSc(String sc) {
		this.sc = sc;
	}
	
	/**
	 * Column Info
	 * @param downCnt
	 */
	public void setDownCnt(String downCnt) {
		this.downCnt = downCnt;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param inPolTmnl
	 */
	public void setInPolTmnl(String inPolTmnl) {
		this.inPolTmnl = inPolTmnl;
	}
	
	/**
	 * Column Info
	 * @param allErr
	 */
	public void setAllErr(String allErr) {
		this.allErr = allErr;
	}
	
	/**
	 * Column Info
	 * @param etaEtd
	 */
	public void setEtaEtd(String etaEtd) {
		this.etaEtd = etaEtd;
	}
	
	/**
	 * Column Info
	 * @param blTotal
	 */
	public void setBlTotal(String blTotal) {
		this.blTotal = blTotal;
	}
	
	/**
	 * Column Info
	 * @param cntrEmpty
	 */
	public void setCntrEmpty(String cntrEmpty) {
		this.cntrEmpty = cntrEmpty;
	}
	
	/**
	 * Column Info
	 * @param inBlno
	 */
	public void setInBlno(String inBlno) {
		this.inBlno = inBlno;
	}
	
	/**
	 * Column Info
	 * @param inHn
	 */
	public void setInHn(String inHn) {
		this.inHn = inHn;
	}
	
	/**
	 * Column Info
	 * @param blTs
	 */
	public void setBlTs(String blTs) {
		this.blTs = blTs;
	}
	
	/**
	 * Column Info
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTs
	 */
	public void setCntrTs(String cntrTs) {
		this.cntrTs = cntrTs;
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
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setBlEmpty(JSPUtil.getParameter(request, prefix + "bl_empty", ""));
		setInPod(JSPUtil.getParameter(request, prefix + "in_pod", ""));
		setInBound(JSPUtil.getParameter(request, prefix + "in_bound", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setCorrection(JSPUtil.getParameter(request, prefix + "correction", ""));
		setElType(JSPUtil.getParameter(request, prefix + "el_type", ""));
		setInPol(JSPUtil.getParameter(request, prefix + "in_pol", ""));
		setBlDl(JSPUtil.getParameter(request, prefix + "bl_dl", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrTsEmpty(JSPUtil.getParameter(request, prefix + "cntr_ts_empty", ""));
		setCntrLocal(JSPUtil.getParameter(request, prefix + "cntr_local", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEtbDt(JSPUtil.getParameter(request, prefix + "etb_dt", ""));
		setBlTsEmpty(JSPUtil.getParameter(request, prefix + "bl_ts_empty", ""));
		setKtPort(JSPUtil.getParameter(request, prefix + "kt_port", ""));
		setCntrTotal(JSPUtil.getParameter(request, prefix + "cntr_total", ""));
		setInPolYd(JSPUtil.getParameter(request, prefix + "in_pol_yd", ""));
		setInPodTmnl(JSPUtil.getParameter(request, prefix + "in_pod_tmnl", ""));
		setBlLocal(JSPUtil.getParameter(request, prefix + "bl_local", ""));
		setSelType(JSPUtil.getParameter(request, prefix + "sel_type", ""));
		setMrnChkNo(JSPUtil.getParameter(request, prefix + "mrn_chk_no", ""));
		setBlType(JSPUtil.getParameter(request, prefix + "bl_type", ""));
		setSc(JSPUtil.getParameter(request, prefix + "sc", ""));
		setDownCnt(JSPUtil.getParameter(request, prefix + "down_cnt", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setInPolTmnl(JSPUtil.getParameter(request, prefix + "in_pol_tmnl", ""));
		setAllErr(JSPUtil.getParameter(request, prefix + "all_err", ""));
		setEtaEtd(JSPUtil.getParameter(request, prefix + "eta_etd", ""));
		setBlTotal(JSPUtil.getParameter(request, prefix + "bl_total", ""));
		setCntrEmpty(JSPUtil.getParameter(request, prefix + "cntr_empty", ""));
		setInBlno(JSPUtil.getParameter(request, prefix + "in_blno", ""));
		setInHn(JSPUtil.getParameter(request, prefix + "in_hn", ""));
		setBlTs(JSPUtil.getParameter(request, prefix + "bl_ts", ""));
		setInBkgNo(JSPUtil.getParameter(request, prefix + "in_bkg_no", ""));
		setCntrTs(JSPUtil.getParameter(request, prefix + "cntr_ts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMrnNoVO[]
	 */
	public KorMrnNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorMrnNoVO[]
	 */
	public KorMrnNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMrnNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] blEmpty = (JSPUtil.getParameter(request, prefix	+ "bl_empty", length));
			String[] inPod = (JSPUtil.getParameter(request, prefix	+ "in_pod", length));
			String[] inBound = (JSPUtil.getParameter(request, prefix	+ "in_bound", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] correction = (JSPUtil.getParameter(request, prefix	+ "correction", length));
			String[] elType = (JSPUtil.getParameter(request, prefix	+ "el_type", length));
			String[] inPol = (JSPUtil.getParameter(request, prefix	+ "in_pol", length));
			String[] blDl = (JSPUtil.getParameter(request, prefix	+ "bl_dl", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrTsEmpty = (JSPUtil.getParameter(request, prefix	+ "cntr_ts_empty", length));
			String[] cntrLocal = (JSPUtil.getParameter(request, prefix	+ "cntr_local", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] blTsEmpty = (JSPUtil.getParameter(request, prefix	+ "bl_ts_empty", length));
			String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));
			String[] cntrTotal = (JSPUtil.getParameter(request, prefix	+ "cntr_total", length));
			String[] inPolYd = (JSPUtil.getParameter(request, prefix	+ "in_pol_yd", length));
			String[] inPodTmnl = (JSPUtil.getParameter(request, prefix	+ "in_pod_tmnl", length));
			String[] blLocal = (JSPUtil.getParameter(request, prefix	+ "bl_local", length));
			String[] selType = (JSPUtil.getParameter(request, prefix	+ "sel_type", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type", length));
			String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc", length));
			String[] downCnt = (JSPUtil.getParameter(request, prefix	+ "down_cnt", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] inPolTmnl = (JSPUtil.getParameter(request, prefix	+ "in_pol_tmnl", length));
			String[] allErr = (JSPUtil.getParameter(request, prefix	+ "all_err", length));
			String[] etaEtd = (JSPUtil.getParameter(request, prefix	+ "eta_etd", length));
			String[] blTotal = (JSPUtil.getParameter(request, prefix	+ "bl_total", length));
			String[] cntrEmpty = (JSPUtil.getParameter(request, prefix	+ "cntr_empty", length));
			String[] inBlno = (JSPUtil.getParameter(request, prefix	+ "in_blno", length));
			String[] inHn = (JSPUtil.getParameter(request, prefix	+ "in_hn", length));
			String[] blTs = (JSPUtil.getParameter(request, prefix	+ "bl_ts", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] cntrTs = (JSPUtil.getParameter(request, prefix	+ "cntr_ts", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorMrnNoVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (blEmpty[i] != null)
					model.setBlEmpty(blEmpty[i]);
				if (inPod[i] != null)
					model.setInPod(inPod[i]);
				if (inBound[i] != null)
					model.setInBound(inBound[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (correction[i] != null)
					model.setCorrection(correction[i]);
				if (elType[i] != null)
					model.setElType(elType[i]);
				if (inPol[i] != null)
					model.setInPol(inPol[i]);
				if (blDl[i] != null)
					model.setBlDl(blDl[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrTsEmpty[i] != null)
					model.setCntrTsEmpty(cntrTsEmpty[i]);
				if (cntrLocal[i] != null)
					model.setCntrLocal(cntrLocal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (blTsEmpty[i] != null)
					model.setBlTsEmpty(blTsEmpty[i]);
				if (ktPort[i] != null)
					model.setKtPort(ktPort[i]);
				if (cntrTotal[i] != null)
					model.setCntrTotal(cntrTotal[i]);
				if (inPolYd[i] != null)
					model.setInPolYd(inPolYd[i]);
				if (inPodTmnl[i] != null)
					model.setInPodTmnl(inPodTmnl[i]);
				if (blLocal[i] != null)
					model.setBlLocal(blLocal[i]);
				if (selType[i] != null)
					model.setSelType(selType[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				if (sc[i] != null)
					model.setSc(sc[i]);
				if (downCnt[i] != null)
					model.setDownCnt(downCnt[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (inPolTmnl[i] != null)
					model.setInPolTmnl(inPolTmnl[i]);
				if (allErr[i] != null)
					model.setAllErr(allErr[i]);
				if (etaEtd[i] != null)
					model.setEtaEtd(etaEtd[i]);
				if (blTotal[i] != null)
					model.setBlTotal(blTotal[i]);
				if (cntrEmpty[i] != null)
					model.setCntrEmpty(cntrEmpty[i]);
				if (inBlno[i] != null)
					model.setInBlno(inBlno[i]);
				if (inHn[i] != null)
					model.setInHn(inHn[i]);
				if (blTs[i] != null)
					model.setBlTs(blTs[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (cntrTs[i] != null)
					model.setCntrTs(cntrTs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMrnNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMrnNoVO[]
	 */
	public KorMrnNoVO[] getKorMrnNoVOs(){
		KorMrnNoVO[] vos = (KorMrnNoVO[])models.toArray(new KorMrnNoVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blEmpty = this.blEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPod = this.inPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBound = this.inBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.correction = this.correction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elType = this.elType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPol = this.inPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDl = this.blDl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTsEmpty = this.cntrTsEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLocal = this.cntrLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTsEmpty = this.blTsEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTotal = this.cntrTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolYd = this.inPolYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodTmnl = this.inPodTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLocal = this.blLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selType = this.selType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChkNo = this.mrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downCnt = this.downCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolTmnl = this.inPolTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allErr = this.allErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaEtd = this.etaEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTotal = this.blTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEmpty = this.cntrEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlno = this.inBlno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHn = this.inHn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTs = this.blTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTs = this.cntrTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
