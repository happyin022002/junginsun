/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BeforeAfterStatusInputVO.java
*@FileTitle : BeforeAfterStatusInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BeforeAfterStatusInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BeforeAfterStatusInputVO> models = new ArrayList<BeforeAfterStatusInputVO>();
	
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loginOfcCd = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String tabTp = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String isTemp = null;
	/* Column Info */
	private String toCc = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String loginUsrId = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String groupBy = null;
	/* Column Info */
	private String isOwnedRole = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String usrOfcOnly = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String condTp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BeforeAfterStatusInputVO() {}

	public BeforeAfterStatusInputVO(String ibflag, String pagerows, String type, String condTp, String tabTp, String groupBy, String dmdtTrfCd, String fmDt, String toDt, String usrOfcCd, String usrOfcOnly, String usrRoleCd, String isOwnedRole, String loginOfcCd, String loginUsrId, String toCc, String usrId, String scNo, String rfaNo, String propNo, String darNo, String apvlNo, String bkgNo, String blNo, String custCd, String custCntCd, String custSeq, String isTemp) {
		this.type = type;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.loginOfcCd = loginOfcCd;
		this.usrOfcCd = usrOfcCd;
		this.usrId = usrId;
		this.scNo = scNo;
		this.custCntCd = custCntCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.tabTp = tabTp;
		this.fmDt = fmDt;
		this.isTemp = isTemp;
		this.toCc = toCc;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.usrRoleCd = usrRoleCd;
		this.custSeq = custSeq;
		this.loginUsrId = loginUsrId;
		this.toDt = toDt;
		this.groupBy = groupBy;
		this.isOwnedRole = isOwnedRole;
		this.bkgNo = bkgNo;
		this.usrOfcOnly = usrOfcOnly;
		this.propNo = propNo;
		this.custCd = custCd;
		this.condTp = condTp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("type", getType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("tab_tp", getTabTp());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("is_temp", getIsTemp());
		this.hashColumns.put("to_cc", getToCc());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("login_usr_id", getLoginUsrId());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("group_by", getGroupBy());
		this.hashColumns.put("is_owned_role", getIsOwnedRole());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("usr_ofc_only", getUsrOfcOnly());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cond_tp", getCondTp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("type", "type");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("tab_tp", "tabTp");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("is_temp", "isTemp");
		this.hashFields.put("to_cc", "toCc");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("login_usr_id", "loginUsrId");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("group_by", "groupBy");
		this.hashFields.put("is_owned_role", "isOwnedRole");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usr_ofc_only", "usrOfcOnly");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cond_tp", "condTp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return loginOfcCd
	 */
	public String getLoginOfcCd() {
		return this.loginOfcCd;
	}
	
	/**
	 * Column Info
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return tabTp
	 */
	public String getTabTp() {
		return this.tabTp;
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
	 * @return isTemp
	 */
	public String getIsTemp() {
		return this.isTemp;
	}
	
	/**
	 * Column Info
	 * @return toCc
	 */
	public String getToCc() {
		return this.toCc;
	}
	
	/**
	 * Column Info
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return apvlNo
	 */
	public String getApvlNo() {
		return this.apvlNo;
	}
	
	/**
	 * Column Info
	 * @return usrRoleCd
	 */
	public String getUsrRoleCd() {
		return this.usrRoleCd;
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
	 * @return loginUsrId
	 */
	public String getLoginUsrId() {
		return this.loginUsrId;
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
	 * @return groupBy
	 */
	public String getGroupBy() {
		return this.groupBy;
	}
	
	/**
	 * Column Info
	 * @return isOwnedRole
	 */
	public String getIsOwnedRole() {
		return this.isOwnedRole;
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
	 * @return usrOfcOnly
	 */
	public String getUsrOfcOnly() {
		return this.usrOfcOnly;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return condTp
	 */
	public String getCondTp() {
		return this.condTp;
	}
	

	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param loginOfcCd
	 */
	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}
	
	/**
	 * Column Info
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param tabTp
	 */
	public void setTabTp(String tabTp) {
		this.tabTp = tabTp;
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
	 * @param isTemp
	 */
	public void setIsTemp(String isTemp) {
		this.isTemp = isTemp;
	}
	
	/**
	 * Column Info
	 * @param toCc
	 */
	public void setToCc(String toCc) {
		this.toCc = toCc;
	}
	
	/**
	 * Column Info
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param apvlNo
	 */
	public void setApvlNo(String apvlNo) {
		this.apvlNo = apvlNo;
	}
	
	/**
	 * Column Info
	 * @param usrRoleCd
	 */
	public void setUsrRoleCd(String usrRoleCd) {
		this.usrRoleCd = usrRoleCd;
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
	 * @param loginUsrId
	 */
	public void setLoginUsrId(String loginUsrId) {
		this.loginUsrId = loginUsrId;
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
	 * @param groupBy
	 */
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	
	/**
	 * Column Info
	 * @param isOwnedRole
	 */
	public void setIsOwnedRole(String isOwnedRole) {
		this.isOwnedRole = isOwnedRole;
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
	 * @param usrOfcOnly
	 */
	public void setUsrOfcOnly(String usrOfcOnly) {
		this.usrOfcOnly = usrOfcOnly;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param condTp
	 */
	public void setCondTp(String condTp) {
		this.condTp = condTp;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setType(JSPUtil.getParameter(request, "type", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, "login_ofc_cd", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, "usr_ofc_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setTabTp(JSPUtil.getParameter(request, "tab_tp", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setIsTemp(JSPUtil.getParameter(request, "is_temp", ""));
		setToCc(JSPUtil.getParameter(request, "to_cc", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setApvlNo(JSPUtil.getParameter(request, "apvl_no", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, "usr_role_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setLoginUsrId(JSPUtil.getParameter(request, "login_usr_id", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setGroupBy(JSPUtil.getParameter(request, "group_by", ""));
		setIsOwnedRole(JSPUtil.getParameter(request, "is_owned_role", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUsrOfcOnly(JSPUtil.getParameter(request, "usr_ofc_only", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCondTp(JSPUtil.getParameter(request, "cond_tp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BeforeAfterStatusInputVO[]
	 */
	public BeforeAfterStatusInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BeforeAfterStatusInputVO[]
	 */
	public BeforeAfterStatusInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BeforeAfterStatusInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loginOfcCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] tabTp = (JSPUtil.getParameter(request, prefix	+ "tab_tp", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] isTemp = (JSPUtil.getParameter(request, prefix	+ "is_temp", length));
			String[] toCc = (JSPUtil.getParameter(request, prefix	+ "to_cc", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] loginUsrId = (JSPUtil.getParameter(request, prefix	+ "login_usr_id", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] groupBy = (JSPUtil.getParameter(request, prefix	+ "group_by", length));
			String[] isOwnedRole = (JSPUtil.getParameter(request, prefix	+ "is_owned_role", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] usrOfcOnly = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_only", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] condTp = (JSPUtil.getParameter(request, prefix	+ "cond_tp", length));
			
			for (int i = 0; i < length; i++) {
				model = new BeforeAfterStatusInputVO();
				if (type[i] != null)
					model.setType(type[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loginOfcCd[i] != null)
					model.setLoginOfcCd(loginOfcCd[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (tabTp[i] != null)
					model.setTabTp(tabTp[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (isTemp[i] != null)
					model.setIsTemp(isTemp[i]);
				if (toCc[i] != null)
					model.setToCc(toCc[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (loginUsrId[i] != null)
					model.setLoginUsrId(loginUsrId[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (groupBy[i] != null)
					model.setGroupBy(groupBy[i]);
				if (isOwnedRole[i] != null)
					model.setIsOwnedRole(isOwnedRole[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (usrOfcOnly[i] != null)
					model.setUsrOfcOnly(usrOfcOnly[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (condTp[i] != null)
					model.setCondTp(condTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBeforeAfterStatusInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BeforeAfterStatusInputVO[]
	 */
	public BeforeAfterStatusInputVO[] getBeforeAfterStatusInputVOs(){
		BeforeAfterStatusInputVO[] vos = (BeforeAfterStatusInputVO[])models.toArray(new BeforeAfterStatusInputVO[models.size()]);
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
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabTp = this.tabTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isTemp = this.isTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCc = this.toCc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginUsrId = this.loginUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupBy = this.groupBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isOwnedRole = this.isOwnedRole .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcOnly = this.usrOfcOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condTp = this.condTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
