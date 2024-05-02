/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CODRequestListVO.java
*@FileTitle : CODRequestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.28
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.02.28 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CODRequestListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CODRequestListVO> models = new ArrayList<CODRequestListVO>();
	
	/* Column Info */
	private String codStsCd = null;
	/* Column Info */
	private String oldPod = null;
	/* Column Info */
	private String aprvRjctId = null;
	/* Column Info */
	private String requestedDate = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String codRqstSeq = null;
	/* Column Info */
	private String codRhndPortCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String codRqstRsnCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String newSkdVoyNo = null;
	/* Column Info */
	private String codRhndPortYdCd = null;
	/* Column Info */
	private String newVslCd = null;
	/* Column Info */
	private String codRqstOfcCd = null;
	/* Column Info */
	private String rhndPordEtaDt = null;
	/* Column Info */
	private String firstReactDate = null;
	/* Column Info */
	private String newSkdDirCd = null;
	/* Column Info */
	private String podEtaDt = null;
	/* Column Info */
	private String oldDel = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oldPol = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String newPod = null;
	/* Column Info */
	private String actDeptYn = null;
	/* Column Info */
	private String elapsedDay = null;
	/* Column Info */
	private String codEmailSendYn = null;
	/* Column Info */
	private String newPol = null;
	/* Column Info */
	private String newDel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CODRequestListVO() {}

	public CODRequestListVO(String ibflag, String pagerows, String vslSlanCd, String vvd, String bkgNo, String codRqstRsnCd, String oldPol, String oldPod, String oldDel, String newPol, String newPod, String newDel, String cntrQty, String codRqstOfcCd, String codStsCd, String chgAmt, String diffRmk, String blNo, String codRqstSeq, String codRhndPortCd, String actDeptYn, String podEtaDt, String codEmailSendYn, String newVslCd, String newSkdVoyNo, String newSkdDirCd, String codRhndPortYdCd, String rhndPordEtaDt, String elapsedDay, String requestedDate, String firstReactDate, String aprvRjctId) {
		this.codStsCd = codStsCd;
		this.oldPod = oldPod;
		this.aprvRjctId = aprvRjctId;
		this.requestedDate = requestedDate;
		this.vslSlanCd = vslSlanCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.codRqstSeq = codRqstSeq;
		this.codRhndPortCd = codRhndPortCd;
		this.chgAmt = chgAmt;
		this.codRqstRsnCd = codRqstRsnCd;
		this.cntrQty = cntrQty;
		this.newSkdVoyNo = newSkdVoyNo;
		this.codRhndPortYdCd = codRhndPortYdCd;
		this.newVslCd = newVslCd;
		this.codRqstOfcCd = codRqstOfcCd;
		this.rhndPordEtaDt = rhndPordEtaDt;
		this.firstReactDate = firstReactDate;
		this.newSkdDirCd = newSkdDirCd;
		this.podEtaDt = podEtaDt;
		this.oldDel = oldDel;
		this.vvd = vvd;
		this.oldPol = oldPol;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.newPod = newPod;
		this.actDeptYn = actDeptYn;
		this.elapsedDay = elapsedDay;
		this.codEmailSendYn = codEmailSendYn;
		this.newPol = newPol;
		this.newDel = newDel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cod_sts_cd", getCodStsCd());
		this.hashColumns.put("old_pod", getOldPod());
		this.hashColumns.put("aprv_rjct_id", getAprvRjctId());
		this.hashColumns.put("requested_date", getRequestedDate());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("cod_rhnd_port_cd", getCodRhndPortCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("cod_rqst_rsn_cd", getCodRqstRsnCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("new_skd_voy_no", getNewSkdVoyNo());
		this.hashColumns.put("cod_rhnd_port_yd_cd", getCodRhndPortYdCd());
		this.hashColumns.put("new_vsl_cd", getNewVslCd());
		this.hashColumns.put("cod_rqst_ofc_cd", getCodRqstOfcCd());
		this.hashColumns.put("rhnd_pord_eta_dt", getRhndPordEtaDt());
		this.hashColumns.put("first_react_date", getFirstReactDate());
		this.hashColumns.put("new_skd_dir_cd", getNewSkdDirCd());
		this.hashColumns.put("pod_eta_dt", getPodEtaDt());
		this.hashColumns.put("old_del", getOldDel());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("old_pol", getOldPol());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("new_pod", getNewPod());
		this.hashColumns.put("act_dept_yn", getActDeptYn());
		this.hashColumns.put("elapsed_day", getElapsedDay());
		this.hashColumns.put("cod_email_send_yn", getCodEmailSendYn());
		this.hashColumns.put("new_pol", getNewPol());
		this.hashColumns.put("new_del", getNewDel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cod_sts_cd", "codStsCd");
		this.hashFields.put("old_pod", "oldPod");
		this.hashFields.put("aprv_rjct_id", "aprvRjctId");
		this.hashFields.put("requested_date", "requestedDate");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("cod_rhnd_port_cd", "codRhndPortCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("cod_rqst_rsn_cd", "codRqstRsnCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("new_skd_voy_no", "newSkdVoyNo");
		this.hashFields.put("cod_rhnd_port_yd_cd", "codRhndPortYdCd");
		this.hashFields.put("new_vsl_cd", "newVslCd");
		this.hashFields.put("cod_rqst_ofc_cd", "codRqstOfcCd");
		this.hashFields.put("rhnd_pord_eta_dt", "rhndPordEtaDt");
		this.hashFields.put("first_react_date", "firstReactDate");
		this.hashFields.put("new_skd_dir_cd", "newSkdDirCd");
		this.hashFields.put("pod_eta_dt", "podEtaDt");
		this.hashFields.put("old_del", "oldDel");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("old_pol", "oldPol");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("new_pod", "newPod");
		this.hashFields.put("act_dept_yn", "actDeptYn");
		this.hashFields.put("elapsed_day", "elapsedDay");
		this.hashFields.put("cod_email_send_yn", "codEmailSendYn");
		this.hashFields.put("new_pol", "newPol");
		this.hashFields.put("new_del", "newDel");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return codStsCd
	 */
	public String getCodStsCd() {
		return this.codStsCd;
	}
	
	/**
	 * Column Info
	 * @return oldPod
	 */
	public String getOldPod() {
		return this.oldPod;
	}
	
	/**
	 * Column Info
	 * @return aprvRjctId
	 */
	public String getAprvRjctId() {
		return this.aprvRjctId;
	}
	
	/**
	 * Column Info
	 * @return requestedDate
	 */
	public String getRequestedDate() {
		return this.requestedDate;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return codRhndPortCd
	 */
	public String getCodRhndPortCd() {
		return this.codRhndPortCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return codRqstRsnCd
	 */
	public String getCodRqstRsnCd() {
		return this.codRqstRsnCd;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return newSkdVoyNo
	 */
	public String getNewSkdVoyNo() {
		return this.newSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return codRhndPortYdCd
	 */
	public String getCodRhndPortYdCd() {
		return this.codRhndPortYdCd;
	}
	
	/**
	 * Column Info
	 * @return newVslCd
	 */
	public String getNewVslCd() {
		return this.newVslCd;
	}
	
	/**
	 * Column Info
	 * @return codRqstOfcCd
	 */
	public String getCodRqstOfcCd() {
		return this.codRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhndPordEtaDt
	 */
	public String getRhndPordEtaDt() {
		return this.rhndPordEtaDt;
	}
	
	/**
	 * Column Info
	 * @return firstReactDate
	 */
	public String getFirstReactDate() {
		return this.firstReactDate;
	}
	
	/**
	 * Column Info
	 * @return newSkdDirCd
	 */
	public String getNewSkdDirCd() {
		return this.newSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return podEtaDt
	 */
	public String getPodEtaDt() {
		return this.podEtaDt;
	}
	
	/**
	 * Column Info
	 * @return oldDel
	 */
	public String getOldDel() {
		return this.oldDel;
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
	 * @return oldPol
	 */
	public String getOldPol() {
		return this.oldPol;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return newPod
	 */
	public String getNewPod() {
		return this.newPod;
	}
	
	/**
	 * Column Info
	 * @return actDeptYn
	 */
	public String getActDeptYn() {
		return this.actDeptYn;
	}
	
	/**
	 * Column Info
	 * @return elapsedDay
	 */
	public String getElapsedDay() {
		return this.elapsedDay;
	}
	
	/**
	 * Column Info
	 * @return codEmailSendYn
	 */
	public String getCodEmailSendYn() {
		return this.codEmailSendYn;
	}
	
	/**
	 * Column Info
	 * @return newPol
	 */
	public String getNewPol() {
		return this.newPol;
	}
	
	/**
	 * Column Info
	 * @return newDel
	 */
	public String getNewDel() {
		return this.newDel;
	}
	

	/**
	 * Column Info
	 * @param codStsCd
	 */
	public void setCodStsCd(String codStsCd) {
		this.codStsCd = codStsCd;
	}
	
	/**
	 * Column Info
	 * @param oldPod
	 */
	public void setOldPod(String oldPod) {
		this.oldPod = oldPod;
	}
	
	/**
	 * Column Info
	 * @param aprvRjctId
	 */
	public void setAprvRjctId(String aprvRjctId) {
		this.aprvRjctId = aprvRjctId;
	}
	
	/**
	 * Column Info
	 * @param requestedDate
	 */
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param codRhndPortCd
	 */
	public void setCodRhndPortCd(String codRhndPortCd) {
		this.codRhndPortCd = codRhndPortCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param codRqstRsnCd
	 */
	public void setCodRqstRsnCd(String codRqstRsnCd) {
		this.codRqstRsnCd = codRqstRsnCd;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setNewSkdVoyNo(String newSkdVoyNo) {
		this.newSkdVoyNo = newSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param codRhndPortYdCd
	 */
	public void setCodRhndPortYdCd(String codRhndPortYdCd) {
		this.codRhndPortYdCd = codRhndPortYdCd;
	}
	
	/**
	 * Column Info
	 * @param newVslCd
	 */
	public void setNewVslCd(String newVslCd) {
		this.newVslCd = newVslCd;
	}
	
	/**
	 * Column Info
	 * @param codRqstOfcCd
	 */
	public void setCodRqstOfcCd(String codRqstOfcCd) {
		this.codRqstOfcCd = codRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhndPordEtaDt
	 */
	public void setRhndPordEtaDt(String rhndPordEtaDt) {
		this.rhndPordEtaDt = rhndPordEtaDt;
	}
	
	/**
	 * Column Info
	 * @param firstReactDate
	 */
	public void setFirstReactDate(String firstReactDate) {
		this.firstReactDate = firstReactDate;
	}
	
	/**
	 * Column Info
	 * @param newSkdDirCd
	 */
	public void setNewSkdDirCd(String newSkdDirCd) {
		this.newSkdDirCd = newSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param podEtaDt
	 */
	public void setPodEtaDt(String podEtaDt) {
		this.podEtaDt = podEtaDt;
	}
	
	/**
	 * Column Info
	 * @param oldDel
	 */
	public void setOldDel(String oldDel) {
		this.oldDel = oldDel;
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
	 * @param oldPol
	 */
	public void setOldPol(String oldPol) {
		this.oldPol = oldPol;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param newPod
	 */
	public void setNewPod(String newPod) {
		this.newPod = newPod;
	}
	
	/**
	 * Column Info
	 * @param actDeptYn
	 */
	public void setActDeptYn(String actDeptYn) {
		this.actDeptYn = actDeptYn;
	}
	
	/**
	 * Column Info
	 * @param elapsedDay
	 */
	public void setElapsedDay(String elapsedDay) {
		this.elapsedDay = elapsedDay;
	}
	
	/**
	 * Column Info
	 * @param codEmailSendYn
	 */
	public void setCodEmailSendYn(String codEmailSendYn) {
		this.codEmailSendYn = codEmailSendYn;
	}
	
	/**
	 * Column Info
	 * @param newPol
	 */
	public void setNewPol(String newPol) {
		this.newPol = newPol;
	}
	
	/**
	 * Column Info
	 * @param newDel
	 */
	public void setNewDel(String newDel) {
		this.newDel = newDel;
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
		setCodStsCd(JSPUtil.getParameter(request, prefix + "cod_sts_cd", ""));
		setOldPod(JSPUtil.getParameter(request, prefix + "old_pod", ""));
		setAprvRjctId(JSPUtil.getParameter(request, prefix + "aprv_rjct_id", ""));
		setRequestedDate(JSPUtil.getParameter(request, prefix + "requested_date", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, prefix + "cod_rqst_seq", ""));
		setCodRhndPortCd(JSPUtil.getParameter(request, prefix + "cod_rhnd_port_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setCodRqstRsnCd(JSPUtil.getParameter(request, prefix + "cod_rqst_rsn_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setNewSkdVoyNo(JSPUtil.getParameter(request, prefix + "new_skd_voy_no", ""));
		setCodRhndPortYdCd(JSPUtil.getParameter(request, prefix + "cod_rhnd_port_yd_cd", ""));
		setNewVslCd(JSPUtil.getParameter(request, prefix + "new_vsl_cd", ""));
		setCodRqstOfcCd(JSPUtil.getParameter(request, prefix + "cod_rqst_ofc_cd", ""));
		setRhndPordEtaDt(JSPUtil.getParameter(request, prefix + "rhnd_pord_eta_dt", ""));
		setFirstReactDate(JSPUtil.getParameter(request, prefix + "first_react_date", ""));
		setNewSkdDirCd(JSPUtil.getParameter(request, prefix + "new_skd_dir_cd", ""));
		setPodEtaDt(JSPUtil.getParameter(request, prefix + "pod_eta_dt", ""));
		setOldDel(JSPUtil.getParameter(request, prefix + "old_del", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOldPol(JSPUtil.getParameter(request, prefix + "old_pol", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setNewPod(JSPUtil.getParameter(request, prefix + "new_pod", ""));
		setActDeptYn(JSPUtil.getParameter(request, prefix + "act_dept_yn", ""));
		setElapsedDay(JSPUtil.getParameter(request, prefix + "elapsed_day", ""));
		setCodEmailSendYn(JSPUtil.getParameter(request, prefix + "cod_email_send_yn", ""));
		setNewPol(JSPUtil.getParameter(request, prefix + "new_pol", ""));
		setNewDel(JSPUtil.getParameter(request, prefix + "new_del", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CODRequestListVO[]
	 */
	public CODRequestListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CODRequestListVO[]
	 */
	public CODRequestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CODRequestListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] codStsCd = (JSPUtil.getParameter(request, prefix	+ "cod_sts_cd", length));
			String[] oldPod = (JSPUtil.getParameter(request, prefix	+ "old_pod", length));
			String[] aprvRjctId = (JSPUtil.getParameter(request, prefix	+ "aprv_rjct_id", length));
			String[] requestedDate = (JSPUtil.getParameter(request, prefix	+ "requested_date", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] codRqstSeq = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_seq", length));
			String[] codRhndPortCd = (JSPUtil.getParameter(request, prefix	+ "cod_rhnd_port_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] codRqstRsnCd = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_rsn_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] newSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "new_skd_voy_no", length));
			String[] codRhndPortYdCd = (JSPUtil.getParameter(request, prefix	+ "cod_rhnd_port_yd_cd", length));
			String[] newVslCd = (JSPUtil.getParameter(request, prefix	+ "new_vsl_cd", length));
			String[] codRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_ofc_cd", length));
			String[] rhndPordEtaDt = (JSPUtil.getParameter(request, prefix	+ "rhnd_pord_eta_dt", length));
			String[] firstReactDate = (JSPUtil.getParameter(request, prefix	+ "first_react_date", length));
			String[] newSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "new_skd_dir_cd", length));
			String[] podEtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_dt", length));
			String[] oldDel = (JSPUtil.getParameter(request, prefix	+ "old_del", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oldPol = (JSPUtil.getParameter(request, prefix	+ "old_pol", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] newPod = (JSPUtil.getParameter(request, prefix	+ "new_pod", length));
			String[] actDeptYn = (JSPUtil.getParameter(request, prefix	+ "act_dept_yn", length));
			String[] elapsedDay = (JSPUtil.getParameter(request, prefix	+ "elapsed_day", length));
			String[] codEmailSendYn = (JSPUtil.getParameter(request, prefix	+ "cod_email_send_yn", length));
			String[] newPol = (JSPUtil.getParameter(request, prefix	+ "new_pol", length));
			String[] newDel = (JSPUtil.getParameter(request, prefix	+ "new_del", length));
			
			for (int i = 0; i < length; i++) {
				model = new CODRequestListVO();
				if (codStsCd[i] != null)
					model.setCodStsCd(codStsCd[i]);
				if (oldPod[i] != null)
					model.setOldPod(oldPod[i]);
				if (aprvRjctId[i] != null)
					model.setAprvRjctId(aprvRjctId[i]);
				if (requestedDate[i] != null)
					model.setRequestedDate(requestedDate[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (codRhndPortCd[i] != null)
					model.setCodRhndPortCd(codRhndPortCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (codRqstRsnCd[i] != null)
					model.setCodRqstRsnCd(codRqstRsnCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (newSkdVoyNo[i] != null)
					model.setNewSkdVoyNo(newSkdVoyNo[i]);
				if (codRhndPortYdCd[i] != null)
					model.setCodRhndPortYdCd(codRhndPortYdCd[i]);
				if (newVslCd[i] != null)
					model.setNewVslCd(newVslCd[i]);
				if (codRqstOfcCd[i] != null)
					model.setCodRqstOfcCd(codRqstOfcCd[i]);
				if (rhndPordEtaDt[i] != null)
					model.setRhndPordEtaDt(rhndPordEtaDt[i]);
				if (firstReactDate[i] != null)
					model.setFirstReactDate(firstReactDate[i]);
				if (newSkdDirCd[i] != null)
					model.setNewSkdDirCd(newSkdDirCd[i]);
				if (podEtaDt[i] != null)
					model.setPodEtaDt(podEtaDt[i]);
				if (oldDel[i] != null)
					model.setOldDel(oldDel[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oldPol[i] != null)
					model.setOldPol(oldPol[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (newPod[i] != null)
					model.setNewPod(newPod[i]);
				if (actDeptYn[i] != null)
					model.setActDeptYn(actDeptYn[i]);
				if (elapsedDay[i] != null)
					model.setElapsedDay(elapsedDay[i]);
				if (codEmailSendYn[i] != null)
					model.setCodEmailSendYn(codEmailSendYn[i]);
				if (newPol[i] != null)
					model.setNewPol(newPol[i]);
				if (newDel[i] != null)
					model.setNewDel(newDel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCODRequestListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CODRequestListVO[]
	 */
	public CODRequestListVO[] getCODRequestListVOs(){
		CODRequestListVO[] vos = (CODRequestListVO[])models.toArray(new CODRequestListVO[models.size()]);
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
		this.codStsCd = this.codStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPod = this.oldPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprvRjctId = this.aprvRjctId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.requestedDate = this.requestedDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRhndPortCd = this.codRhndPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstRsnCd = this.codRqstRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSkdVoyNo = this.newSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRhndPortYdCd = this.codRhndPortYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVslCd = this.newVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstOfcCd = this.codRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhndPordEtaDt = this.rhndPordEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstReactDate = this.firstReactDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSkdDirCd = this.newSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaDt = this.podEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDel = this.oldDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPol = this.oldPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPod = this.newPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDeptYn = this.actDeptYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elapsedDay = this.elapsedDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codEmailSendYn = this.codEmailSendYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPol = this.newPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDel = this.newDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
