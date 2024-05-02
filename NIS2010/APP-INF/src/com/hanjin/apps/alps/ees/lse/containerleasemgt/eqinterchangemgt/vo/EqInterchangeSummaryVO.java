/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeSummaryVO.java
*@FileTitle : EqInterchangeSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02  
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo;

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

public class EqInterchangeSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqInterchangeSummaryVO> models = new ArrayList<EqInterchangeSummaryVO>();
	
	/* Column Info */
	private String lstStsFlg = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String strEvntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String balance = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String endEvntDt = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String inVol = null;
	/* Column Info */
	private String authSeq = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String outVol = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String authVol = null;
	/* Column Info */
	private String locTp2 = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String lstmSocTp = null;
	/* Column Info */
	private String sDays = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String locCd2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqInterchangeSummaryVO() {}

	public EqInterchangeSummaryVO(String ibflag, String pagerows, String cntrStsCd, String lstStsFlg, String lstmSocTp, String locTp, String locCd, String locTp2, String locCd2, String cntrTpszCd, String strEvntDt, String endEvntDt, String vndrSeq, String rccCd, String lccCd, String authVol, String outVol, String inVol, String balance, String lessor, String agmtNo, String authNo, String authSeq, String creDt, String sDays, String fmLocCd, String toLocCd) {
		this.lstStsFlg = lstStsFlg;
		this.cntrStsCd = cntrStsCd;
		this.creDt = creDt;
		this.strEvntDt = strEvntDt;
		this.pagerows = pagerows;
		this.balance = balance;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.endEvntDt = endEvntDt;
		this.fmLocCd = fmLocCd;
		this.cntrTpszCd = cntrTpszCd;
		this.locTp = locTp;
		this.inVol = inVol;
		this.authSeq = authSeq;
		this.lessor = lessor;
		this.outVol = outVol;
		this.agmtNo = agmtNo;
		this.authNo = authNo;
		this.toLocCd = toLocCd;
		this.authVol = authVol;
		this.locTp2 = locTp2;
		this.rccCd = rccCd;
		this.lstmSocTp = lstmSocTp;
		this.sDays = sDays;
		this.lccCd = lccCd;
		this.vndrSeq = vndrSeq;
		this.locCd2 = locCd2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lst_sts_flg", getLstStsFlg());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("str_evnt_dt", getStrEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("balance", getBalance());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("end_evnt_dt", getEndEvntDt());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("in_vol", getInVol());
		this.hashColumns.put("auth_seq", getAuthSeq());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("out_vol", getOutVol());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("auth_vol", getAuthVol());
		this.hashColumns.put("loc_tp2", getLocTp2());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("lstm_soc_tp", getLstmSocTp());
		this.hashColumns.put("s_days", getSDays());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("loc_cd2", getLocCd2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lst_sts_flg", "lstStsFlg");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("str_evnt_dt", "strEvntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("balance", "balance");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("end_evnt_dt", "endEvntDt");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("in_vol", "inVol");
		this.hashFields.put("auth_seq", "authSeq");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("out_vol", "outVol");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("auth_vol", "authVol");
		this.hashFields.put("loc_tp2", "locTp2");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("lstm_soc_tp", "lstmSocTp");
		this.hashFields.put("s_days", "sDays");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("loc_cd2", "locCd2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lstStsFlg
	 */
	public String getLstStsFlg() {
		return this.lstStsFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return strEvntDt
	 */
	public String getStrEvntDt() {
		return this.strEvntDt;
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
	 * @return balance
	 */
	public String getBalance() {
		return this.balance;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return endEvntDt
	 */
	public String getEndEvntDt() {
		return this.endEvntDt;
	}
	
	/**
	 * Column Info
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
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
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
	}
	
	/**
	 * Column Info
	 * @return inVol
	 */
	public String getInVol() {
		return this.inVol;
	}
	
	/**
	 * Column Info
	 * @return authSeq
	 */
	public String getAuthSeq() {
		return this.authSeq;
	}
	
	/**
	 * Column Info
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}
	
	/**
	 * Column Info
	 * @return outVol
	 */
	public String getOutVol() {
		return this.outVol;
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
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
	}
	
	/**
	 * Column Info
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
	}
	
	/**
	 * Column Info
	 * @return authVol
	 */
	public String getAuthVol() {
		return this.authVol;
	}
	
	/**
	 * Column Info
	 * @return locTp2
	 */
	public String getLocTp2() {
		return this.locTp2;
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
	 * @return lstmSocTp
	 */
	public String getLstmSocTp() {
		return this.lstmSocTp;
	}
	
	/**
	 * Column Info
	 * @return sDays
	 */
	public String getSDays() {
		return this.sDays;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return locCd2
	 */
	public String getLocCd2() {
		return this.locCd2;
	}
	

	/**
	 * Column Info
	 * @param lstStsFlg
	 */
	public void setLstStsFlg(String lstStsFlg) {
		this.lstStsFlg = lstStsFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param strEvntDt
	 */
	public void setStrEvntDt(String strEvntDt) {
		this.strEvntDt = strEvntDt;
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
	 * @param balance
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param endEvntDt
	 */
	public void setEndEvntDt(String endEvntDt) {
		this.endEvntDt = endEvntDt;
	}
	
	/**
	 * Column Info
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
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
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	
	/**
	 * Column Info
	 * @param inVol
	 */
	public void setInVol(String inVol) {
		this.inVol = inVol;
	}
	
	/**
	 * Column Info
	 * @param authSeq
	 */
	public void setAuthSeq(String authSeq) {
		this.authSeq = authSeq;
	}
	
	/**
	 * Column Info
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	
	/**
	 * Column Info
	 * @param outVol
	 */
	public void setOutVol(String outVol) {
		this.outVol = outVol;
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
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	/**
	 * Column Info
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
	}
	
	/**
	 * Column Info
	 * @param authVol
	 */
	public void setAuthVol(String authVol) {
		this.authVol = authVol;
	}
	
	/**
	 * Column Info
	 * @param locTp2
	 */
	public void setLocTp2(String locTp2) {
		this.locTp2 = locTp2;
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
	 * @param lstmSocTp
	 */
	public void setLstmSocTp(String lstmSocTp) {
		this.lstmSocTp = lstmSocTp;
	}
	
	/**
	 * Column Info
	 * @param sDays
	 */
	public void setSDays(String sDays) {
		this.sDays = sDays;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param locCd2
	 */
	public void setLocCd2(String locCd2) {
		this.locCd2 = locCd2;
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
		setLstStsFlg(JSPUtil.getParameter(request, prefix + "lst_sts_flg", ""));
		setCntrStsCd(JSPUtil.getParameter(request, prefix + "cntr_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setStrEvntDt(JSPUtil.getParameter(request, prefix + "str_evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBalance(JSPUtil.getParameter(request, prefix + "balance", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEndEvntDt(JSPUtil.getParameter(request, prefix + "end_evnt_dt", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setLocTp(JSPUtil.getParameter(request, prefix + "loc_tp", ""));
		setInVol(JSPUtil.getParameter(request, prefix + "in_vol", ""));
		setAuthSeq(JSPUtil.getParameter(request, prefix + "auth_seq", ""));
		setLessor(JSPUtil.getParameter(request, prefix + "lessor", ""));
		setOutVol(JSPUtil.getParameter(request, prefix + "out_vol", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setAuthNo(JSPUtil.getParameter(request, prefix + "auth_no", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setAuthVol(JSPUtil.getParameter(request, prefix + "auth_vol", ""));
		setLocTp2(JSPUtil.getParameter(request, prefix + "loc_tp2", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setLstmSocTp(JSPUtil.getParameter(request, prefix + "lstm_soc_tp", ""));
		setSDays(JSPUtil.getParameter(request, prefix + "s_days", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLocCd2(JSPUtil.getParameter(request, prefix + "loc_cd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqInterchangeSummaryVO[]
	 */
	public EqInterchangeSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqInterchangeSummaryVO[]
	 */
	public EqInterchangeSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqInterchangeSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lstStsFlg = (JSPUtil.getParameter(request, prefix	+ "lst_sts_flg", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] strEvntDt = (JSPUtil.getParameter(request, prefix	+ "str_evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] balance = (JSPUtil.getParameter(request, prefix	+ "balance", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] endEvntDt = (JSPUtil.getParameter(request, prefix	+ "end_evnt_dt", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] inVol = (JSPUtil.getParameter(request, prefix	+ "in_vol", length));
			String[] authSeq = (JSPUtil.getParameter(request, prefix	+ "auth_seq", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix	+ "lessor", length));
			String[] outVol = (JSPUtil.getParameter(request, prefix	+ "out_vol", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] authVol = (JSPUtil.getParameter(request, prefix	+ "auth_vol", length));
			String[] locTp2 = (JSPUtil.getParameter(request, prefix	+ "loc_tp2", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] lstmSocTp = (JSPUtil.getParameter(request, prefix	+ "lstm_soc_tp", length));
			String[] sDays = (JSPUtil.getParameter(request, prefix	+ "s_days", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] locCd2 = (JSPUtil.getParameter(request, prefix	+ "loc_cd2", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqInterchangeSummaryVO();
				if (lstStsFlg[i] != null)
					model.setLstStsFlg(lstStsFlg[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (strEvntDt[i] != null)
					model.setStrEvntDt(strEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (balance[i] != null)
					model.setBalance(balance[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (endEvntDt[i] != null)
					model.setEndEvntDt(endEvntDt[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (inVol[i] != null)
					model.setInVol(inVol[i]);
				if (authSeq[i] != null)
					model.setAuthSeq(authSeq[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (outVol[i] != null)
					model.setOutVol(outVol[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (authVol[i] != null)
					model.setAuthVol(authVol[i]);
				if (locTp2[i] != null)
					model.setLocTp2(locTp2[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (lstmSocTp[i] != null)
					model.setLstmSocTp(lstmSocTp[i]);
				if (sDays[i] != null)
					model.setSDays(sDays[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (locCd2[i] != null)
					model.setLocCd2(locCd2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqInterchangeSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqInterchangeSummaryVO[]
	 */
	public EqInterchangeSummaryVO[] getEqInterchangeSummaryVOs(){
		EqInterchangeSummaryVO[] vos = (EqInterchangeSummaryVO[])models.toArray(new EqInterchangeSummaryVO[models.size()]);
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
		this.lstStsFlg = this.lstStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strEvntDt = this.strEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balance = this.balance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEvntDt = this.endEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVol = this.inVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authSeq = this.authSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor = this.lessor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outVol = this.outVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authVol = this.authVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp2 = this.locTp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmSocTp = this.lstmSocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDays = this.sDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd2 = this.locCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
