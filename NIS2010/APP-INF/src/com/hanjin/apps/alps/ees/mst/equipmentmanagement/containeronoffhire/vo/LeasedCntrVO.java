/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasedCntrVO.java
*@FileTitle : LeasedCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.10.26 이호선 
* 1.0 Creation
* 2013.06.19 채창호 [CHM-201324954-01] Master에서 SOC creation시 CTM의 OC event date 확인기능 추가       
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LeasedCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LeasedCntrVO> models = new ArrayList<LeasedCntrVO>();
	
	/* Column Info */
	private String cntrNo2 = null;
	/* Column Info */
	private String cntrNo3 = null;
	/* Column Info */
	private String cntrSpecNo = null;
	/* Column Info */
	private String ieflg = null;
	/* Column Info */
	private String stsEvntYdCd = null;
	/* Column Info */
	private String liftOnChrg = null;
	/* Column Info */
	private String ceflg = null;
	/* Column Info */
	private String cntrNo0 = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ueflg = null;
	/* Column Info */
	private String pickUpDueDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String teflg = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String approvalVol = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String hireDate = null;
	/* Column Info */
	private String approvalNo = null;
	/* Column Info */
	private String ctype = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String minOnhDys = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String pickUpVol = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String eeflg = null;
	/* Column Info */
	private String cntrOldVanFlg = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String pkupChgAmt = null;
	/* Column Info */
	private String cntrMtrlCd = null;
	/* Column Info */
	private String heflg = null;
	/* Column Info */
	private String cntrUpdflg = null;
	/* Column Info */
	private String pkupChgCrAmt = null;
	/* Column Info */
	private String rfTpCd = null;
	/* Column Info */
	private String errMsg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LeasedCntrVO() {}

	public LeasedCntrVO(String ibflag, String pagerows, String cntrNo2, String cntrNo3, String ieflg, String stsEvntYdCd, String ceflg, String liftOnChrg, String cntrNo0, String cntrNo1, String ueflg, String pickUpDueDate, String agmtCtyCd, String hisSeq, String lstmCd, String updUsrId, String teflg, String agmtSeq, String eccCd, String approvalVol, String agmtNo, String hireDate, String approvalNo, String ctype, String rccCd, String eqTpszCd, String minOnhDys, String mftDt, String ofcCd, String lccCd, String creUsrId, String sccCd, String pickUpVol, String freeDys, String eeflg, String vndrSeq, String cntrNo, String refNo, String cntrOldVanFlg, String pkupChgAmt, String vndrAbbrNm, String heflg, String cntrUpdflg, String cntrMtrlCd, String pkupChgCrAmt, String rfTpCd, String cntrSpecNo ,String ediflg ,String errMsg) {
		this.cntrNo2 = cntrNo2;
		this.cntrNo3 = cntrNo3;
		this.cntrSpecNo = cntrSpecNo;
		this.ieflg = ieflg;
		this.stsEvntYdCd = stsEvntYdCd;
		this.liftOnChrg = liftOnChrg;
		this.ceflg = ceflg;
		this.cntrNo0 = cntrNo0;
		this.cntrNo1 = cntrNo1;
		this.pagerows = pagerows;
		this.ueflg = ueflg;
		this.pickUpDueDate = pickUpDueDate;
		this.ibflag = ibflag;
		this.agmtCtyCd = agmtCtyCd;
		this.hisSeq = hisSeq;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.teflg = teflg;
		this.agmtSeq = agmtSeq;
		this.eccCd = eccCd;
		this.approvalVol = approvalVol;
		this.agmtNo = agmtNo;
		this.hireDate = hireDate;
		this.approvalNo = approvalNo;
		this.ctype = ctype;
		this.rccCd = rccCd;
		this.eqTpszCd = eqTpszCd;
		this.mftDt = mftDt;
		this.minOnhDys = minOnhDys;
		this.lccCd = lccCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.sccCd = sccCd;
		this.pickUpVol = pickUpVol;
		this.freeDys = freeDys;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.eeflg = eeflg;
		this.cntrOldVanFlg = cntrOldVanFlg;
		this.refNo = refNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.pkupChgAmt = pkupChgAmt;
		this.cntrMtrlCd = cntrMtrlCd;
		this.heflg = heflg;
		this.cntrUpdflg = cntrUpdflg;
		this.pkupChgCrAmt = pkupChgCrAmt;
		this.rfTpCd = rfTpCd;
		this.errMsg = errMsg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_no2", getCntrNo2());
		this.hashColumns.put("cntr_no3", getCntrNo3());
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());
		this.hashColumns.put("ieflg", getIeflg());
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());
		this.hashColumns.put("lift_on_chrg", getLiftOnChrg());
		this.hashColumns.put("ceflg", getCeflg());
		this.hashColumns.put("cntr_no0", getCntrNo0());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ueflg", getUeflg());
		this.hashColumns.put("pick_up_due_date", getPickUpDueDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("teflg", getTeflg());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("approval_vol", getApprovalVol());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("hire_date", getHireDate());
		this.hashColumns.put("approval_no", getApprovalNo());
		this.hashColumns.put("ctype", getCtype());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("min_onh_dys", getMinOnhDys());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("pick_up_vol", getPickUpVol());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eeflg", getEeflg());
		this.hashColumns.put("cntr_old_van_flg", getCntrOldVanFlg());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("pkup_chg_amt", getPkupChgAmt());
		this.hashColumns.put("cntr_mtrl_cd", getCntrMtrlCd());
		this.hashColumns.put("heflg", getHeflg());
		this.hashColumns.put("cntrUpdflg", getCntrUpdflg());
		this.hashColumns.put("pkup_chg_cr_amt", getPkupChgCrAmt());
		this.hashColumns.put("rf_tp_cd", getRfTpCd());
		this.hashColumns.put("err_msg", getErrMsg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_no2", "cntrNo2");
		this.hashFields.put("cntr_no3", "cntrNo3");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("ieflg", "ieflg");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("lift_on_chrg", "liftOnChrg");
		this.hashFields.put("ceflg", "ceflg");
		this.hashFields.put("cntr_no0", "cntrNo0");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ueflg", "ueflg");
		this.hashFields.put("pick_up_due_date", "pickUpDueDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("teflg", "teflg");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("approval_vol", "approvalVol");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("hire_date", "hireDate");
		this.hashFields.put("approval_no", "approvalNo");
		this.hashFields.put("ctype", "ctype");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("min_onh_dys", "minOnhDys");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("pick_up_vol", "pickUpVol");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eeflg", "eeflg");
		this.hashFields.put("cntr_old_van_flg", "cntrOldVanFlg");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("pkup_chg_amt", "pkupChgAmt");
		this.hashFields.put("cntr_mtrl_cd", "cntrMtrlCd");
		this.hashFields.put("heflg", "heflg");
		this.hashFields.put("cntrUpdflg", "cntrUpdflg");
		this.hashFields.put("pkup_chg_cr_amt", "pkupChgCrAmt");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("err_msg", "errMsg");
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
	 * @return cntrSpecNo
	 */
	public String getCntrSpecNo() {
		return this.cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @return ieflg
	 */
	public String getIeflg() {
		return this.ieflg;
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
	 * @return liftOnChrg
	 */
	public String getLiftOnChrg() {
		return this.liftOnChrg;
	}
	
	/**
	 * Column Info
	 * @return ceflg
	 */
	public String getCeflg() {
		return this.ceflg;
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
	 * @return ueflg
	 */
	public String getUeflg() {
		return this.ueflg;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
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
	 * @return teflg
	 */
	public String getTeflg() {
		return this.teflg;
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
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
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
	 * @return approvalNo
	 */
	public String getApprovalNo() {
		return this.approvalNo;
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
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return minOnhDys
	 */
	public String getMinOnhDys() {
		return this.minOnhDys;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
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
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
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
	 * @return eeflg
	 */
	public String getEeflg() {
		return this.eeflg;
	}
	
	/**
	 * Column Info
	 * @return cntrOldVanFlg
	 */
	public String getCntrOldVanFlg() {
		return this.cntrOldVanFlg;
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
	 * @return pkupChgAmt
	 */
	public String getPkupChgAmt() {
		return this.pkupChgAmt;
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
	 * @return heflg
	 */
	public String getHeflg() {
		return this.heflg;
	}
	
	/**
	 * Column Info
	 * @return cntrUpdflg
	 */
	public String getCntrUpdflg() {
		return this.cntrUpdflg;
	}	
	
	/**
	 * Column Info
	 * @return pkupChgCrAmt
	 */
	public String getPkupChgCrAmt() {
		return this.pkupChgCrAmt;
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
	 * @param cntrSpecNo
	 */
	public void setCntrSpecNo(String cntrSpecNo) {
		this.cntrSpecNo = cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @param ieflg
	 */
	public void setIeflg(String ieflg) {
		this.ieflg = ieflg;
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
	 * @param liftOnChrg
	 */
	public void setLiftOnChrg(String liftOnChrg) {
		this.liftOnChrg = liftOnChrg;
	}
	
	/**
	 * Column Info
	 * @param ceflg
	 */
	public void setCeflg(String ceflg) {
		this.ceflg = ceflg;
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
	 * @param ueflg
	 */
	public void setUeflg(String ueflg) {
		this.ueflg = ueflg;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
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
	 * @param teflg
	 */
	public void setTeflg(String teflg) {
		this.teflg = teflg;
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
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
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
	 * @param approvalNo
	 */
	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
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
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param minOnhDys
	 */
	public void setMinOnhDys(String minOnhDys) {
		this.minOnhDys = minOnhDys;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
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
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
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
	 * @param eeflg
	 */
	public void setEeflg(String eeflg) {
		this.eeflg = eeflg;
	}
	
	/**
	 * Column Info
	 * @param cntrOldVanFlg
	 */
	public void setCntrOldVanFlg(String cntrOldVanFlg) {
		this.cntrOldVanFlg = cntrOldVanFlg;
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
	 * @param pkupChgAmt
	 */
	public void setPkupChgAmt(String pkupChgAmt) {
		this.pkupChgAmt = pkupChgAmt;
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
	 * @param heflg
	 */
	public void setHeflg(String heflg) {
		this.heflg = heflg;
	}
	
	/**
	 * Column Info
	 * @param cntrUpdflg
	 */
	public void setCntrUpdflg(String cntrUpdflg) {
		this.cntrUpdflg = cntrUpdflg;
	}	
	
	/**
	 * Column Info
	 * @param pkupChgCrAmt
	 */
	public void setPkupChgCrAmt(String pkupChgCrAmt) {
		this.pkupChgCrAmt = pkupChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param rfTpCd
	 */
	public void setRfTpCd(String rfTpCd) {
		this.rfTpCd = rfTpCd;
	}
	
	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrNo2(JSPUtil.getParameter(request, "cntr_no2", ""));
		setCntrNo3(JSPUtil.getParameter(request, "cntr_no3", ""));
		setCntrSpecNo(JSPUtil.getParameter(request, "cntr_spec_no", ""));
		setIeflg(JSPUtil.getParameter(request, "ieflg", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request, "sts_evnt_yd_cd", ""));
		setLiftOnChrg(JSPUtil.getParameter(request, "lift_on_chrg", ""));
		setCeflg(JSPUtil.getParameter(request, "ceflg", ""));
		setCntrNo0(JSPUtil.getParameter(request, "cntr_no0", ""));
		setCntrNo1(JSPUtil.getParameter(request, "cntr_no1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUeflg(JSPUtil.getParameter(request, "ueflg", ""));
		setPickUpDueDate(JSPUtil.getParameter(request, "pick_up_due_date", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTeflg(JSPUtil.getParameter(request, "teflg", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setApprovalVol(JSPUtil.getParameter(request, "approval_vol", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setHireDate(JSPUtil.getParameter(request, "hire_date", ""));
		setApprovalNo(JSPUtil.getParameter(request, "approval_no", ""));
		setCtype(JSPUtil.getParameter(request, "ctype", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setMinOnhDys(JSPUtil.getParameter(request, "min_onh_dys", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setPickUpVol(JSPUtil.getParameter(request, "pick_up_vol", ""));
		setFreeDys(JSPUtil.getParameter(request, "free_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setEeflg(JSPUtil.getParameter(request, "eeflg", ""));
		setCntrOldVanFlg(JSPUtil.getParameter(request, "cntr_old_van_flg", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setPkupChgAmt(JSPUtil.getParameter(request, "pkup_chg_amt", ""));
		setCntrMtrlCd(JSPUtil.getParameter(request, "cntr_mtrl_cd", ""));
		setHeflg(JSPUtil.getParameter(request, "heflg", ""));
		setCntrUpdflg(JSPUtil.getParameter(request, "cntrUpdflg", ""));
		setPkupChgCrAmt(JSPUtil.getParameter(request, "pkup_chg_cr_amt", ""));
		setRfTpCd(JSPUtil.getParameter(request, "rf_tp_cd", ""));
		setErrMsg(JSPUtil.getParameter(request, "err_msg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LeasedCntrVO[]
	 */
	public LeasedCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LeasedCntrVO[]
	 */
	public LeasedCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LeasedCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_no2", length));
			String[] cntrNo3 = (JSPUtil.getParameter(request, prefix	+ "cntr_no3", length));
			String[] cntrSpecNo = (JSPUtil.getParameter(request, prefix	+ "cntr_spec_no", length));
			String[] ieflg = (JSPUtil.getParameter(request, prefix	+ "ieflg", length));
			String[] stsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_yd_cd", length));
			String[] liftOnChrg = (JSPUtil.getParameter(request, prefix	+ "lift_on_chrg", length));
			String[] ceflg = (JSPUtil.getParameter(request, prefix	+ "ceflg", length));
			String[] cntrNo0 = (JSPUtil.getParameter(request, prefix	+ "cntr_no0", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ueflg = (JSPUtil.getParameter(request, prefix	+ "ueflg", length));
			String[] pickUpDueDate = (JSPUtil.getParameter(request, prefix	+ "pick_up_due_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] teflg = (JSPUtil.getParameter(request, prefix	+ "teflg", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] approvalVol = (JSPUtil.getParameter(request, prefix	+ "approval_vol", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] hireDate = (JSPUtil.getParameter(request, prefix	+ "hire_date", length));
			String[] approvalNo = (JSPUtil.getParameter(request, prefix	+ "approval_no", length));
			String[] ctype = (JSPUtil.getParameter(request, prefix	+ "ctype", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] minOnhDys = (JSPUtil.getParameter(request, prefix	+ "min_onh_dys", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] pickUpVol = (JSPUtil.getParameter(request, prefix	+ "pick_up_vol", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] eeflg = (JSPUtil.getParameter(request, prefix	+ "eeflg", length));
			String[] cntrOldVanFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_old_van_flg", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] pkupChgAmt = (JSPUtil.getParameter(request, prefix	+ "pkup_chg_amt", length));
			String[] cntrMtrlCd = (JSPUtil.getParameter(request, prefix	+ "cntr_mtrl_cd", length));
			String[] heflg = (JSPUtil.getParameter(request, prefix	+ "heflg", length));
			String[] cntrUpdflg = (JSPUtil.getParameter(request, prefix	+ "cntrUpdflg", length));
			String[] pkupChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "pkup_chg_cr_amt", length));
			String[] rfTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			
			for (int i = 0; i < length; i++) {
				model = new LeasedCntrVO();
				if (cntrNo2[i] != null)
					model.setCntrNo2(cntrNo2[i]);
				if (cntrNo3[i] != null)
					model.setCntrNo3(cntrNo3[i]);
				if (cntrSpecNo[i] != null)
					model.setCntrSpecNo(cntrSpecNo[i]);
				if (ieflg[i] != null)
					model.setIeflg(ieflg[i]);
				if (stsEvntYdCd[i] != null)
					model.setStsEvntYdCd(stsEvntYdCd[i]);
				if (liftOnChrg[i] != null)
					model.setLiftOnChrg(liftOnChrg[i]);
				if (ceflg[i] != null)
					model.setCeflg(ceflg[i]);
				if (cntrNo0[i] != null)
					model.setCntrNo0(cntrNo0[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ueflg[i] != null)
					model.setUeflg(ueflg[i]);
				if (pickUpDueDate[i] != null)
					model.setPickUpDueDate(pickUpDueDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (teflg[i] != null)
					model.setTeflg(teflg[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (approvalVol[i] != null)
					model.setApprovalVol(approvalVol[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (hireDate[i] != null)
					model.setHireDate(hireDate[i]);
				if (approvalNo[i] != null)
					model.setApprovalNo(approvalNo[i]);
				if (ctype[i] != null)
					model.setCtype(ctype[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (minOnhDys[i] != null)
					model.setMinOnhDys(minOnhDys[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (pickUpVol[i] != null)
					model.setPickUpVol(pickUpVol[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (eeflg[i] != null)
					model.setEeflg(eeflg[i]);
				if (cntrOldVanFlg[i] != null)
					model.setCntrOldVanFlg(cntrOldVanFlg[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (pkupChgAmt[i] != null)
					model.setPkupChgAmt(pkupChgAmt[i]);
				if (cntrMtrlCd[i] != null)
					model.setCntrMtrlCd(cntrMtrlCd[i]);
				if (heflg[i] != null)
					model.setHeflg(heflg[i]);
				if (cntrUpdflg[i] != null)
					model.setCntrUpdflg(cntrUpdflg[i]);
				if (pkupChgCrAmt[i] != null)
					model.setPkupChgCrAmt(pkupChgCrAmt[i]);
				if (rfTpCd[i] != null)
					model.setRfTpCd(rfTpCd[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLeasedCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LeasedCntrVO[]
	 */
	public LeasedCntrVO[] getLeasedCntrVOs(){
		LeasedCntrVO[] vos = (LeasedCntrVO[])models.toArray(new LeasedCntrVO[models.size()]);
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
		this.cntrSpecNo = this.cntrSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieflg = this.ieflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd = this.stsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liftOnChrg = this.liftOnChrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceflg = this.ceflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo0 = this.cntrNo0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ueflg = this.ueflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpDueDate = this.pickUpDueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teflg = this.teflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalVol = this.approvalVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hireDate = this.hireDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalNo = this.approvalNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctype = this.ctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDys = this.minOnhDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpVol = this.pickUpVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeflg = this.eeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOldVanFlg = this.cntrOldVanFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupChgAmt = this.pkupChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtrlCd = this.cntrMtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.heflg = this.heflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUpdflg = this.cntrUpdflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupChgCrAmt = this.pkupChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd = this.rfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
