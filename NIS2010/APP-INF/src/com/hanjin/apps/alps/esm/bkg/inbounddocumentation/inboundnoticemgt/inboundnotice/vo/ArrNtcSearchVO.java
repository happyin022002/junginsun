/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcSearchVO.java
*@FileTitle : ArrNtcSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.09.29 박성호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class ArrNtcSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcSearchVO> models = new ArrayList<ArrNtcSearchVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String vpsEtaDtEnd = null;
	/* Column Info */
	private String vpsEtdDtEnd = null;
	/* Column Info */
	private String valUsrId = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String valDtm = null;
	/* Column Info */
	private String tsFlg = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String vpsEtaDtStart = null;
	/* Column Info */
	private String vpsEtdDtStart = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String sNo = null;
	/* Column Info */
	private String mtchChkFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String custRefNoCtnt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String cNo = null;
	/* Column Info */
	private String schTp = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String valOfcCd = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String isValidated = null;
	/* Column Info */
	private String sheetDelCnt = null;
	/* Column Info */
	private String backgroundJobKey = null;
	/* Column Info */
	private String frtTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcSearchVO() {}

	public ArrNtcSearchVO(String ibflag, String pagerows, String vvd, String vpsEtaDtStart, String vpsEtaDtEnd, String vpsEtdDtStart, String vpsEtdDtEnd, String podCd, String delCd, String blNo, String blTpCd, String custCntCd, String custSeq, String custNm, String custRefNoCtnt, String sNo, String cNo, String pageNo, String schTp, String backgroundJobKey, String mtchChkFlg, String valUsrId, String valOfcCd, String excelFlg, String usrId, String ofcCd, String valDtm, String updUsrId, String creUsrId, String polCd, String sheetDelCnt, String isValidated, String tsFlg, String frtTermCd) {
		this.custNm = custNm;
		this.vpsEtaDtEnd = vpsEtaDtEnd;
		this.vpsEtdDtEnd = vpsEtdDtEnd;
		this.valUsrId = valUsrId;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.valDtm = valDtm;
		this.tsFlg = tsFlg;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.vpsEtaDtStart = vpsEtaDtStart;
		this.vpsEtdDtStart = vpsEtdDtStart;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.sNo = sNo;
		this.mtchChkFlg = mtchChkFlg;
		this.delCd = delCd;
		this.custRefNoCtnt = custRefNoCtnt;
		this.custSeq = custSeq;
		this.blTpCd = blTpCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.cNo = cNo;
		this.schTp = schTp;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.valOfcCd = valOfcCd;
		this.excelFlg = excelFlg;
		this.pageNo = pageNo;
		this.isValidated = isValidated;
		this.sheetDelCnt = sheetDelCnt;
		this.backgroundJobKey = backgroundJobKey;
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("vps_eta_dt_end", getVpsEtaDtEnd());
		this.hashColumns.put("vps_etd_dt_end", getVpsEtdDtEnd());
		this.hashColumns.put("val_usr_id", getValUsrId());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("val_dtm", getValDtm());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("vps_eta_dt_start", getVpsEtaDtStart());
		this.hashColumns.put("vps_etd_dt_start", getVpsEtdDtStart());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("s_no", getSNo());
		this.hashColumns.put("mtch_chk_flg", getMtchChkFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cust_ref_no_ctnt", getCustRefNoCtnt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("c_no", getCNo());
		this.hashColumns.put("sch_tp", getSchTp());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("val_ofc_cd", getValOfcCd());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("is_validated", getIsValidated());
		this.hashColumns.put("sheet_del_cnt", getSheetDelCnt());
		this.hashColumns.put("background_job_key", getBackgroundJobKey());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("vps_eta_dt_end", "vpsEtaDtEnd");
		this.hashFields.put("vps_etd_dt_end", "vpsEtdDtEnd");
		this.hashFields.put("val_usr_id", "valUsrId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("val_dtm", "valDtm");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("vps_eta_dt_start", "vpsEtaDtStart");
		this.hashFields.put("vps_etd_dt_start", "vpsEtdDtStart");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("s_no", "sNo");
		this.hashFields.put("mtch_chk_flg", "mtchChkFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_ref_no_ctnt", "custRefNoCtnt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("c_no", "cNo");
		this.hashFields.put("sch_tp", "schTp");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("val_ofc_cd", "valOfcCd");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("is_validated", "isValidated");
		this.hashFields.put("sheet_del_cnt", "sheetDelCnt");
		this.hashFields.put("background_job_key", "backgroundJobKey");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtEnd
	 */
	public String getVpsEtaDtEnd() {
		return this.vpsEtaDtEnd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDtEnd
	 */
	public String getVpsEtdDtEnd() {
		return this.vpsEtdDtEnd;
	}
		
	/**
	 * Column Info
	 * @return valUsrId
	 */
	public String getValUsrId() {
		return this.valUsrId;
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
	 * @return valDtm
	 */
	public String getValDtm() {
		return this.valDtm;
	}
	
	/**
	 * Column Info
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtStart
	 */
	public String getVpsEtaDtStart() {
		return this.vpsEtaDtStart;
	}

	/**
	 * Column Info
	 * @return vpsEtdDtStart
	 */
	public String getVpsEtdDtStart() {
		return this.vpsEtdDtStart;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return sNo
	 */
	public String getSNo() {
		return this.sNo;
	}
	
	/**
	 * Column Info
	 * @return mtchChkFlg
	 */
	public String getMtchChkFlg() {
		return this.mtchChkFlg;
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
	 * @return custRefNoCtnt
	 */
	public String getCustRefNoCtnt() {
		return this.custRefNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return cNo
	 */
	public String getCNo() {
		return this.cNo;
	}
	
	/**
	 * Column Info
	 * @return schTp
	 */
	public String getSchTp() {
		return this.schTp;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return valOfcCd
	 */
	public String getValOfcCd() {
		return this.valOfcCd;
	}
	
	/**
	 * Column Info
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return isValidated
	 */
	public String getIsValidated() {
		return this.isValidated;
	}
	
	/**
	 * Column Info
	 * @return sheetDelCnt
	 */
	public String getSheetDelCnt() {
		return this.sheetDelCnt;
	}
	
	/**
	 * Column Info
	 * @return backgroundJobKey
	 */
	public String getBackgroundJobKey() {
		return this.backgroundJobKey;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	

	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtEnd
	 */
	public void setVpsEtaDtEnd(String vpsEtaDtEnd) {
		this.vpsEtaDtEnd = vpsEtaDtEnd;
	}

	/**
	 * Column Info
	 * @param vpsEtdDtEnd
	 */
	public void setVpsEtdDtEnd(String vpsEtdDtEnd) {
		this.vpsEtdDtEnd = vpsEtdDtEnd;
	}
	
	/**
	 * Column Info
	 * @param valUsrId
	 */
	public void setValUsrId(String valUsrId) {
		this.valUsrId = valUsrId;
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
	 * @param valDtm
	 */
	public void setValDtm(String valDtm) {
		this.valDtm = valDtm;
	}
	
	/**
	 * Column Info
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtStart
	 */
	public void setVpsEtaDtStart(String vpsEtaDtStart) {
		this.vpsEtaDtStart = vpsEtaDtStart;
	}

	/**
	 * Column Info
	 * @param vpsEtdDtStart
	 */
	public void setVpsEtdDtStart(String vpsEtdDtStart) {
		this.vpsEtdDtStart = vpsEtdDtStart;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param sNo
	 */
	public void setSNo(String sNo) {
		this.sNo = sNo;
	}
	
	/**
	 * Column Info
	 * @param mtchChkFlg
	 */
	public void setMtchChkFlg(String mtchChkFlg) {
		this.mtchChkFlg = mtchChkFlg;
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
	 * @param custRefNoCtnt
	 */
	public void setCustRefNoCtnt(String custRefNoCtnt) {
		this.custRefNoCtnt = custRefNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param cNo
	 */
	public void setCNo(String cNo) {
		this.cNo = cNo;
	}
	
	/**
	 * Column Info
	 * @param schTp
	 */
	public void setSchTp(String schTp) {
		this.schTp = schTp;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param valOfcCd
	 */
	public void setValOfcCd(String valOfcCd) {
		this.valOfcCd = valOfcCd;
	}
	
	/**
	 * Column Info
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param isValidated
	 */
	public void setIsValidated(String isValidated) {
		this.isValidated = isValidated;
	}
	
	/**
	 * Column Info
	 * @param sheetDelCnt
	 */
	public void setSheetDelCnt(String sheetDelCnt) {
		this.sheetDelCnt = sheetDelCnt;
	}
	
	/**
	 * Column Info
	 * @param backgroundJobKey
	 */
	public void setBackgroundJobKey(String backgroundJobKey) {
		this.backgroundJobKey = backgroundJobKey;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setVpsEtaDtEnd(JSPUtil.getParameter(request, "vps_eta_dt_end", ""));
		setVpsEtdDtEnd(JSPUtil.getParameter(request, "vps_etd_dt_end", ""));
		setValUsrId(JSPUtil.getParameter(request, "val_usr_id", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setValDtm(JSPUtil.getParameter(request, "val_dtm", ""));
		setTsFlg(JSPUtil.getParameter(request, "ts_flg", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setVpsEtaDtStart(JSPUtil.getParameter(request, "vps_eta_dt_start", ""));
		setVpsEtdDtStart(JSPUtil.getParameter(request, "vps_etd_dt_start", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setSNo(JSPUtil.getParameter(request, "s_no", ""));
		setMtchChkFlg(JSPUtil.getParameter(request, "mtch_chk_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCustRefNoCtnt(JSPUtil.getParameter(request, "cust_ref_no_ctnt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCNo(JSPUtil.getParameter(request, "c_no", ""));
		setSchTp(JSPUtil.getParameter(request, "sch_tp", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setValOfcCd(JSPUtil.getParameter(request, "val_ofc_cd", ""));
		setExcelFlg(JSPUtil.getParameter(request, "excel_flg", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setIsValidated(JSPUtil.getParameter(request, "is_validated", ""));
		setSheetDelCnt(JSPUtil.getParameter(request, "sheet_del_cnt", ""));
		setBackgroundJobKey(JSPUtil.getParameter(request, "background_job_key", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcSearchVO[]
	 */
	public ArrNtcSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcSearchVO[]
	 */
	public ArrNtcSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] vpsEtaDtEnd = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_end", length));
			String[] vpsEtdDtEnd = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_end", length));
			String[] valUsrId = (JSPUtil.getParameter(request, prefix	+ "val_usr_id", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] valDtm = (JSPUtil.getParameter(request, prefix	+ "val_dtm", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] vpsEtaDtStart = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_start", length));
			String[] vpsEtdDtStart = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_start", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] sNo = (JSPUtil.getParameter(request, prefix	+ "s_no", length));
			String[] mtchChkFlg = (JSPUtil.getParameter(request, prefix	+ "mtch_chk_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] custRefNoCtnt = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no_ctnt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] cNo = (JSPUtil.getParameter(request, prefix	+ "c_no", length));
			String[] schTp = (JSPUtil.getParameter(request, prefix	+ "sch_tp", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] valOfcCd = (JSPUtil.getParameter(request, prefix	+ "val_ofc_cd", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] isValidated = (JSPUtil.getParameter(request, prefix	+ "is_validated", length));
			String[] sheetDelCnt = (JSPUtil.getParameter(request, prefix	+ "sheet_del_cnt", length));
			String[] backgroundJobKey = (JSPUtil.getParameter(request, prefix	+ "background_job_key", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcSearchVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (vpsEtaDtEnd[i] != null)
					model.setVpsEtaDtEnd(vpsEtaDtEnd[i]);
				if (vpsEtdDtEnd[i] != null)
					model.setVpsEtdDtEnd(vpsEtdDtEnd[i]);
				if (valUsrId[i] != null)
					model.setValUsrId(valUsrId[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (valDtm[i] != null)
					model.setValDtm(valDtm[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (vpsEtaDtStart[i] != null)
					model.setVpsEtaDtStart(vpsEtaDtStart[i]);
				if (vpsEtdDtStart[i] != null)
					model.setVpsEtdDtStart(vpsEtdDtStart[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (sNo[i] != null)
					model.setSNo(sNo[i]);
				if (mtchChkFlg[i] != null)
					model.setMtchChkFlg(mtchChkFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (custRefNoCtnt[i] != null)
					model.setCustRefNoCtnt(custRefNoCtnt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (cNo[i] != null)
					model.setCNo(cNo[i]);
				if (schTp[i] != null)
					model.setSchTp(schTp[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (valOfcCd[i] != null)
					model.setValOfcCd(valOfcCd[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (isValidated[i] != null)
					model.setIsValidated(isValidated[i]);
				if (sheetDelCnt[i] != null)
					model.setSheetDelCnt(sheetDelCnt[i]);
				if (backgroundJobKey[i] != null)
					model.setBackgroundJobKey(backgroundJobKey[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcSearchVO[]
	 */
	public ArrNtcSearchVO[] getArrNtcSearchVOs(){
		ArrNtcSearchVO[] vos = (ArrNtcSearchVO[])models.toArray(new ArrNtcSearchVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtEnd = this.vpsEtaDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtEnd = this.vpsEtdDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valUsrId = this.valUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valDtm = this.valDtm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtStart = this.vpsEtaDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtStart = this.vpsEtdDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNo = this.sNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchChkFlg = this.mtchChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNoCtnt = this.custRefNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cNo = this.cNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTp = this.schTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valOfcCd = this.valOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidated = this.isValidated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetDelCnt = this.sheetDelCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backgroundJobKey = this.backgroundJobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
	}
}
