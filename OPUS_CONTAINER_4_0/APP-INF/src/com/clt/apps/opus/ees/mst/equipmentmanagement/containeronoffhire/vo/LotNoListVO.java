/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LotNoListVO.java
*@FileTitle : LotNoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.28 민정호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LotNoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LotNoListVO> models = new ArrayList<LotNoListVO>();
	
	/* Column Info */
	private String cntrNo2 = null;
	/* Column Info */
	private String cntrNo3 = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String fmSerNo = null;
	/* Column Info */
	private String lotPlnYr = null;
	/* Column Info */
	private String stsEvntYdCd = null;
	/* Column Info */
	private String lotSeq = null;
	/* Column Info */
	private String lotLocCd = null;
	/* Column Info */
	private String cntrNo0 = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pickUpDueDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hidType = null;
	/* Column Info */
	private String lotCntrPfxCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String toSerNo = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ifCd = null;
	/* Column Info */
	private String lotNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String approvalVol = null;
	/* Column Info */
	private String approvalNo = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String hireDate = null;
	/* Column Info */
	private String ctype = null;
	/* Column Info */
	private String deYrmon = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String pickUpVol = null;
	/* Column Info */
	private String serialRange = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String cntrMtrlCd = null;
	/* Column Info */
	private String rfTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LotNoListVO() {}

	public LotNoListVO(String ibflag, String pagerows, String cntrNo2, String cntrNo3, String gubun, String fmSerNo, String stsEvntYdCd, String lotPlnYr, String lotSeq, String lotLocCd, String cntrNo0, String cntrNo1, String pickUpDueDate, String hidType, String lotCntrPfxCd, String cntrTpszCd, String agmtCtyCd, String toSerNo, String lstmCd, String updUsrId, String ifCd, String lotNo, String agmtSeq, String approvalVol, String hireDate, String agmtNo, String approvalNo, String ctype, String deYrmon, String mftDt, String creUsrId, String pickUpVol, String serialRange, String vndrSeq, String cntrNo, String refNo, String vndrAbbrNm, String cntrMtrlCd, String rfTpCd) {
		this.cntrNo2 = cntrNo2;
		this.cntrNo3 = cntrNo3;
		this.gubun = gubun;
		this.fmSerNo = fmSerNo;
		this.lotPlnYr = lotPlnYr;
		this.stsEvntYdCd = stsEvntYdCd;
		this.lotSeq = lotSeq;
		this.lotLocCd = lotLocCd;
		this.cntrNo0 = cntrNo0;
		this.cntrNo1 = cntrNo1;
		this.pagerows = pagerows;
		this.pickUpDueDate = pickUpDueDate;
		this.ibflag = ibflag;
		this.hidType = hidType;
		this.lotCntrPfxCd = lotCntrPfxCd;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.toSerNo = toSerNo;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.ifCd = ifCd;
		this.lotNo = lotNo;
		this.agmtSeq = agmtSeq;
		this.approvalVol = approvalVol;
		this.approvalNo = approvalNo;
		this.agmtNo = agmtNo;
		this.hireDate = hireDate;
		this.ctype = ctype;
		this.deYrmon = deYrmon;
		this.mftDt = mftDt;
		this.creUsrId = creUsrId;
		this.pickUpVol = pickUpVol;
		this.serialRange = serialRange;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.refNo = refNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.cntrMtrlCd = cntrMtrlCd;
		this.rfTpCd = rfTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_no2", getCntrNo2());
		this.hashColumns.put("cntr_no3", getCntrNo3());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("fm_ser_no", getFmSerNo());
		this.hashColumns.put("lot_pln_yr", getLotPlnYr());
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());
		this.hashColumns.put("lot_seq", getLotSeq());
		this.hashColumns.put("lot_loc_cd", getLotLocCd());
		this.hashColumns.put("cntr_no0", getCntrNo0());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pick_up_due_date", getPickUpDueDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hid_type", getHidType());
		this.hashColumns.put("lot_cntr_pfx_cd", getLotCntrPfxCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("to_ser_no", getToSerNo());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("if_cd", getIfCd());
		this.hashColumns.put("lot_no", getLotNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("approval_vol", getApprovalVol());
		this.hashColumns.put("approval_no", getApprovalNo());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("hire_date", getHireDate());
		this.hashColumns.put("ctype", getCtype());
		this.hashColumns.put("de_yrmon", getDeYrmon());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pick_up_vol", getPickUpVol());
		this.hashColumns.put("serial_range", getSerialRange());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("cntr_mtrl_cd", getCntrMtrlCd());
		this.hashColumns.put("rf_tp_cd", getRfTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_no2", "cntrNo2");
		this.hashFields.put("cntr_no3", "cntrNo3");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("lot_pln_yr", "lotPlnYr");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("lot_seq", "lotSeq");
		this.hashFields.put("lot_loc_cd", "lotLocCd");
		this.hashFields.put("cntr_no0", "cntrNo0");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pick_up_due_date", "pickUpDueDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hid_type", "hidType");
		this.hashFields.put("lot_cntr_pfx_cd", "lotCntrPfxCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("if_cd", "ifCd");
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("approval_vol", "approvalVol");
		this.hashFields.put("approval_no", "approvalNo");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("hire_date", "hireDate");
		this.hashFields.put("ctype", "ctype");
		this.hashFields.put("de_yrmon", "deYrmon");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pick_up_vol", "pickUpVol");
		this.hashFields.put("serial_range", "serialRange");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cntr_mtrl_cd", "cntrMtrlCd");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrNo2
	 */
	public String getCntrNo2() {
		return this.cntrNo2;
	}
	
	/**
	 * Column Info
	 * @return cntrNo3
	 */
	public String getCntrNo3() {
		return this.cntrNo3;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return fmSerNo
	 */
	public String getFmSerNo() {
		return this.fmSerNo;
	}
	
	/**
	 * Column Info
	 * @return lotPlnYr
	 */
	public String getLotPlnYr() {
		return this.lotPlnYr;
	}
	
	/**
	 * Column Info
	 * @return stsEvntYdCd
	 */
	public String getStsEvntYdCd() {
		return this.stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return lotSeq
	 */
	public String getLotSeq() {
		return this.lotSeq;
	}
	
	/**
	 * Column Info
	 * @return lotLocCd
	 */
	public String getLotLocCd() {
		return this.lotLocCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo0
	 */
	public String getCntrNo0() {
		return this.cntrNo0;
	}
	
	/**
	 * Column Info
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
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
	 * @return pickUpDueDate
	 */
	public String getPickUpDueDate() {
		return this.pickUpDueDate;
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
	 * @return hidType
	 */
	public String getHidType() {
		return this.hidType;
	}
	
	/**
	 * Column Info
	 * @return lotCntrPfxCd
	 */
	public String getLotCntrPfxCd() {
		return this.lotCntrPfxCd;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return toSerNo
	 */
	public String getToSerNo() {
		return this.toSerNo;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return ifCd
	 */
	public String getIfCd() {
		return this.ifCd;
	}
	
	/**
	 * Column Info
	 * @return lotNo
	 */
	public String getLotNo() {
		return this.lotNo;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return approvalVol
	 */
	public String getApprovalVol() {
		return this.approvalVol;
	}
	
	/**
	 * Column Info
	 * @return approvalNo
	 */
	public String getApprovalNo() {
		return this.approvalNo;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return hireDate
	 */
	public String getHireDate() {
		return this.hireDate;
	}
	
	/**
	 * Column Info
	 * @return ctype
	 */
	public String getCtype() {
		return this.ctype;
	}
	
	/**
	 * Column Info
	 * @return deYrmon
	 */
	public String getDeYrmon() {
		return this.deYrmon;
	}
	
	/**
	 * Column Info
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
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
	 * @return pickUpVol
	 */
	public String getPickUpVol() {
		return this.pickUpVol;
	}
	
	/**
	 * Column Info
	 * @return serialRange
	 */
	public String getSerialRange() {
		return this.serialRange;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrMtrlCd
	 */
	public String getCntrMtrlCd() {
		return this.cntrMtrlCd;
	}
	
	/**
	 * Column Info
	 * @return rfTpCd
	 */
	public String getRfTpCd() {
		return this.rfTpCd;
	}
	

	/**
	 * Column Info
	 * @param cntrNo2
	 */
	public void setCntrNo2(String cntrNo2) {
		this.cntrNo2 = cntrNo2;
	}
	
	/**
	 * Column Info
	 * @param cntrNo3
	 */
	public void setCntrNo3(String cntrNo3) {
		this.cntrNo3 = cntrNo3;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param fmSerNo
	 */
	public void setFmSerNo(String fmSerNo) {
		this.fmSerNo = fmSerNo;
	}
	
	/**
	 * Column Info
	 * @param lotPlnYr
	 */
	public void setLotPlnYr(String lotPlnYr) {
		this.lotPlnYr = lotPlnYr;
	}
	
	/**
	 * Column Info
	 * @param stsEvntYdCd
	 */
	public void setStsEvntYdCd(String stsEvntYdCd) {
		this.stsEvntYdCd = stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param lotSeq
	 */
	public void setLotSeq(String lotSeq) {
		this.lotSeq = lotSeq;
	}
	
	/**
	 * Column Info
	 * @param lotLocCd
	 */
	public void setLotLocCd(String lotLocCd) {
		this.lotLocCd = lotLocCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo0
	 */
	public void setCntrNo0(String cntrNo0) {
		this.cntrNo0 = cntrNo0;
	}
	
	/**
	 * Column Info
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
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
	 * @param pickUpDueDate
	 */
	public void setPickUpDueDate(String pickUpDueDate) {
		this.pickUpDueDate = pickUpDueDate;
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
	 * @param hidType
	 */
	public void setHidType(String hidType) {
		this.hidType = hidType;
	}
	
	/**
	 * Column Info
	 * @param lotCntrPfxCd
	 */
	public void setLotCntrPfxCd(String lotCntrPfxCd) {
		this.lotCntrPfxCd = lotCntrPfxCd;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param toSerNo
	 */
	public void setToSerNo(String toSerNo) {
		this.toSerNo = toSerNo;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param ifCd
	 */
	public void setIfCd(String ifCd) {
		this.ifCd = ifCd;
	}
	
	/**
	 * Column Info
	 * @param lotNo
	 */
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param approvalVol
	 */
	public void setApprovalVol(String approvalVol) {
		this.approvalVol = approvalVol;
	}
	
	/**
	 * Column Info
	 * @param approvalNo
	 */
	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param hireDate
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	/**
	 * Column Info
	 * @param ctype
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	
	/**
	 * Column Info
	 * @param deYrmon
	 */
	public void setDeYrmon(String deYrmon) {
		this.deYrmon = deYrmon;
	}
	
	/**
	 * Column Info
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
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
	 * @param pickUpVol
	 */
	public void setPickUpVol(String pickUpVol) {
		this.pickUpVol = pickUpVol;
	}
	
	/**
	 * Column Info
	 * @param serialRange
	 */
	public void setSerialRange(String serialRange) {
		this.serialRange = serialRange;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrMtrlCd
	 */
	public void setCntrMtrlCd(String cntrMtrlCd) {
		this.cntrMtrlCd = cntrMtrlCd;
	}
	
	/**
	 * Column Info
	 * @param rfTpCd
	 */
	public void setRfTpCd(String rfTpCd) {
		this.rfTpCd = rfTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrNo2(JSPUtil.getParameter(request, "cntr_no2", ""));
		setCntrNo3(JSPUtil.getParameter(request, "cntr_no3", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setFmSerNo(JSPUtil.getParameter(request, "fm_ser_no", ""));
		setLotPlnYr(JSPUtil.getParameter(request, "lot_pln_yr", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request, "sts_evnt_yd_cd", ""));
		setLotSeq(JSPUtil.getParameter(request, "lot_seq", ""));
		setLotLocCd(JSPUtil.getParameter(request, "lot_loc_cd", ""));
		setCntrNo0(JSPUtil.getParameter(request, "cntr_no0", ""));
		setCntrNo1(JSPUtil.getParameter(request, "cntr_no1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPickUpDueDate(JSPUtil.getParameter(request, "pick_up_due_date", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHidType(JSPUtil.getParameter(request, "hid_type", ""));
		setLotCntrPfxCd(JSPUtil.getParameter(request, "lot_cntr_pfx_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setToSerNo(JSPUtil.getParameter(request, "to_ser_no", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setIfCd(JSPUtil.getParameter(request, "if_cd", ""));
		setLotNo(JSPUtil.getParameter(request, "lot_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setApprovalVol(JSPUtil.getParameter(request, "approval_vol", ""));
		setApprovalNo(JSPUtil.getParameter(request, "approval_no", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setHireDate(JSPUtil.getParameter(request, "hire_date", ""));
		setCtype(JSPUtil.getParameter(request, "ctype", ""));
		setDeYrmon(JSPUtil.getParameter(request, "de_yrmon", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPickUpVol(JSPUtil.getParameter(request, "pick_up_vol", ""));
		setSerialRange(JSPUtil.getParameter(request, "serial_range", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setCntrMtrlCd(JSPUtil.getParameter(request, "cntr_mtrl_cd", ""));
		setRfTpCd(JSPUtil.getParameter(request, "rf_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LotNoListVO[]
	 */
	public LotNoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LotNoListVO[]
	 */
	public LotNoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LotNoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_no2", length));
			String[] cntrNo3 = (JSPUtil.getParameter(request, prefix	+ "cntr_no3", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] fmSerNo = (JSPUtil.getParameter(request, prefix	+ "fm_ser_no", length));
			String[] lotPlnYr = (JSPUtil.getParameter(request, prefix	+ "lot_pln_yr", length));
			String[] stsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_yd_cd", length));
			String[] lotSeq = (JSPUtil.getParameter(request, prefix	+ "lot_seq", length));
			String[] lotLocCd = (JSPUtil.getParameter(request, prefix	+ "lot_loc_cd", length));
			String[] cntrNo0 = (JSPUtil.getParameter(request, prefix	+ "cntr_no0", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pickUpDueDate = (JSPUtil.getParameter(request, prefix	+ "pick_up_due_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hidType = (JSPUtil.getParameter(request, prefix	+ "hid_type", length));
			String[] lotCntrPfxCd = (JSPUtil.getParameter(request, prefix	+ "lot_cntr_pfx_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] toSerNo = (JSPUtil.getParameter(request, prefix	+ "to_ser_no", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ifCd = (JSPUtil.getParameter(request, prefix	+ "if_cd", length));
			String[] lotNo = (JSPUtil.getParameter(request, prefix	+ "lot_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] approvalVol = (JSPUtil.getParameter(request, prefix	+ "approval_vol", length));
			String[] approvalNo = (JSPUtil.getParameter(request, prefix	+ "approval_no", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] hireDate = (JSPUtil.getParameter(request, prefix	+ "hire_date", length));
			String[] ctype = (JSPUtil.getParameter(request, prefix	+ "ctype", length));
			String[] deYrmon = (JSPUtil.getParameter(request, prefix	+ "de_yrmon", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] pickUpVol = (JSPUtil.getParameter(request, prefix	+ "pick_up_vol", length));
			String[] serialRange = (JSPUtil.getParameter(request, prefix	+ "serial_range", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] cntrMtrlCd = (JSPUtil.getParameter(request, prefix	+ "cntr_mtrl_cd", length));
			String[] rfTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new LotNoListVO();
				if (cntrNo2[i] != null)
					model.setCntrNo2(cntrNo2[i]);
				if (cntrNo3[i] != null)
					model.setCntrNo3(cntrNo3[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (fmSerNo[i] != null)
					model.setFmSerNo(fmSerNo[i]);
				if (lotPlnYr[i] != null)
					model.setLotPlnYr(lotPlnYr[i]);
				if (stsEvntYdCd[i] != null)
					model.setStsEvntYdCd(stsEvntYdCd[i]);
				if (lotSeq[i] != null)
					model.setLotSeq(lotSeq[i]);
				if (lotLocCd[i] != null)
					model.setLotLocCd(lotLocCd[i]);
				if (cntrNo0[i] != null)
					model.setCntrNo0(cntrNo0[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pickUpDueDate[i] != null)
					model.setPickUpDueDate(pickUpDueDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hidType[i] != null)
					model.setHidType(hidType[i]);
				if (lotCntrPfxCd[i] != null)
					model.setLotCntrPfxCd(lotCntrPfxCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (toSerNo[i] != null)
					model.setToSerNo(toSerNo[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ifCd[i] != null)
					model.setIfCd(ifCd[i]);
				if (lotNo[i] != null)
					model.setLotNo(lotNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (approvalVol[i] != null)
					model.setApprovalVol(approvalVol[i]);
				if (approvalNo[i] != null)
					model.setApprovalNo(approvalNo[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (hireDate[i] != null)
					model.setHireDate(hireDate[i]);
				if (ctype[i] != null)
					model.setCtype(ctype[i]);
				if (deYrmon[i] != null)
					model.setDeYrmon(deYrmon[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pickUpVol[i] != null)
					model.setPickUpVol(pickUpVol[i]);
				if (serialRange[i] != null)
					model.setSerialRange(serialRange[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (cntrMtrlCd[i] != null)
					model.setCntrMtrlCd(cntrMtrlCd[i]);
				if (rfTpCd[i] != null)
					model.setRfTpCd(rfTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLotNoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LotNoListVO[]
	 */
	public LotNoListVO[] getLotNoListVOs(){
		LotNoListVO[] vos = (LotNoListVO[])models.toArray(new LotNoListVO[models.size()]);
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
		this.cntrNo2 = this.cntrNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo3 = this.cntrNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSerNo = this.fmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotPlnYr = this.lotPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd = this.stsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotSeq = this.lotSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotLocCd = this.lotLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo0 = this.cntrNo0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpDueDate = this.pickUpDueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidType = this.hidType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotCntrPfxCd = this.lotCntrPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo = this.toSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCd = this.ifCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo = this.lotNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalVol = this.approvalVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalNo = this.approvalNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hireDate = this.hireDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctype = this.ctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYrmon = this.deYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpVol = this.pickUpVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serialRange = this.serialRange .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtrlCd = this.cntrMtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd = this.rfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
