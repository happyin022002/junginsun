/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MnrStatusCrIssVO.java
*@FileTitle : MnrStatusCrIssVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.09 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrStatusCrIssVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrStatusCrIssVO> models = new ArrayList<MnrStatusCrIssVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crIssRsn = null;
	/* Column Info */
	private String crIssUtAmt = null;
	/* Column Info */
	private String crIssTtlAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String crIssDt = null;
	/* Column Info */
	private String teamCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String crIssNo = null;
	/* Column Info */
	private String atchFlg = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String crIssQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mkrCd = null;
	/* Column Info */
	private String crIssRmk = null;
	/* Column Info */
	private String usdRt = null;
	/* Column Info */
	private String crIssEvidNo = null;
	/* Column Info */
	private String lrNm = null;
	/* Column Info */
	private String crSumUsdAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrStatusCrIssVO() {}

	public MnrStatusCrIssVO(String ibflag, String pagerows, String crIssNo, String rhqCd, String teamCd, String mkrCd, String crIssDt, String crIssUtAmt, String currCd, String crIssQty, String crIssTtlAmt, String crSumUsdAmt, String crIssRsn, String lrNm, String agmtNo, String lstmCd, String eqTpszCd, String crIssRmk, String crIssEvidNo, String atchFlg, String atchFileLnkId, String usdRt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.crIssRsn = crIssRsn;
		this.crIssUtAmt = crIssUtAmt;
		this.crIssTtlAmt = crIssTtlAmt;
		this.pagerows = pagerows;
		this.atchFileLnkId = atchFileLnkId;
		this.ibflag = ibflag;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rhqCd = rhqCd;
		this.crIssDt = crIssDt;
		this.teamCd = teamCd;
		this.agmtNo = agmtNo;
		this.crIssNo = crIssNo;
		this.atchFlg = atchFlg;
		this.eqTpszCd = eqTpszCd;
		this.crIssQty = crIssQty;
		this.creUsrId = creUsrId;
		this.mkrCd = mkrCd;
		this.crIssRmk = crIssRmk;
		this.usdRt = usdRt;
		this.crIssEvidNo = crIssEvidNo;
		this.lrNm = lrNm;
		this.crSumUsdAmt = crSumUsdAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cr_iss_rsn", getCrIssRsn());
		this.hashColumns.put("cr_iss_ut_amt", getCrIssUtAmt());
		this.hashColumns.put("cr_iss_ttl_amt", getCrIssTtlAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cr_iss_dt", getCrIssDt());
		this.hashColumns.put("team_cd", getTeamCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cr_iss_no", getCrIssNo());
		this.hashColumns.put("atch_flg", getAtchFlg());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cr_iss_qty", getCrIssQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mkr_cd", getMkrCd());
		this.hashColumns.put("cr_iss_rmk", getCrIssRmk());
		this.hashColumns.put("usd_rt", getUsdRt());
		this.hashColumns.put("cr_iss_evid_no", getCrIssEvidNo());
		this.hashColumns.put("lr_nm", getLrNm());
		this.hashColumns.put("cr_sum_usd_amt", getCrSumUsdAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cr_iss_rsn", "crIssRsn");
		this.hashFields.put("cr_iss_ut_amt", "crIssUtAmt");
		this.hashFields.put("cr_iss_ttl_amt", "crIssTtlAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cr_iss_dt", "crIssDt");
		this.hashFields.put("team_cd", "teamCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cr_iss_no", "crIssNo");
		this.hashFields.put("atch_flg", "atchFlg");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cr_iss_qty", "crIssQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mkr_cd", "mkrCd");
		this.hashFields.put("cr_iss_rmk", "crIssRmk");
		this.hashFields.put("usd_rt", "usdRt");
		this.hashFields.put("cr_iss_evid_no", "crIssEvidNo");
		this.hashFields.put("lr_nm", "lrNm");
		this.hashFields.put("cr_sum_usd_amt", "crSumUsdAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return crIssRsn
	 */
	public String getCrIssRsn() {
		return this.crIssRsn;
	}
	
	/**
	 * Column Info
	 * @return crIssUtAmt
	 */
	public String getCrIssUtAmt() {
		return this.crIssUtAmt;
	}
	
	/**
	 * Column Info
	 * @return crIssTtlAmt
	 */
	public String getCrIssTtlAmt() {
		return this.crIssTtlAmt;
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
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return crIssDt
	 */
	public String getCrIssDt() {
		return this.crIssDt;
	}
	
	/**
	 * Column Info
	 * @return teamCd
	 */
	public String getTeamCd() {
		return this.teamCd;
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
	 * @return crIssNo
	 */
	public String getCrIssNo() {
		return this.crIssNo;
	}
	
	/**
	 * Column Info
	 * @return atchFlg
	 */
	public String getAtchFlg() {
		return this.atchFlg;
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
	 * @return crIssQty
	 */
	public String getCrIssQty() {
		return this.crIssQty;
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
	 * @return mkrCd
	 */
	public String getMkrCd() {
		return this.mkrCd;
	}
	
	/**
	 * Column Info
	 * @return crIssRmk
	 */
	public String getCrIssRmk() {
		return this.crIssRmk;
	}
	
	/**
	 * Column Info
	 * @return usdRt
	 */
	public String getUsdRt() {
		return this.usdRt;
	}
	
	/**
	 * Column Info
	 * @return crIssEvidNo
	 */
	public String getCrIssEvidNo() {
		return this.crIssEvidNo;
	}
	
	/**
	 * Column Info
	 * @return lrNm
	 */
	public String getLrNm() {
		return this.lrNm;
	}
	
	/**
	 * Column Info
	 * @return crSumUsdAmt
	 */
	public String getCrSumUsdAmt() {
		return this.crSumUsdAmt;
	}
	

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param crIssRsn
	 */
	public void setCrIssRsn(String crIssRsn) {
		this.crIssRsn = crIssRsn;
	}
	
	/**
	 * Column Info
	 * @param crIssUtAmt
	 */
	public void setCrIssUtAmt(String crIssUtAmt) {
		this.crIssUtAmt = crIssUtAmt;
	}
	
	/**
	 * Column Info
	 * @param crIssTtlAmt
	 */
	public void setCrIssTtlAmt(String crIssTtlAmt) {
		this.crIssTtlAmt = crIssTtlAmt;
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
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param crIssDt
	 */
	public void setCrIssDt(String crIssDt) {
		this.crIssDt = crIssDt;
	}
	
	/**
	 * Column Info
	 * @param teamCd
	 */
	public void setTeamCd(String teamCd) {
		this.teamCd = teamCd;
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
	 * @param crIssNo
	 */
	public void setCrIssNo(String crIssNo) {
		this.crIssNo = crIssNo;
	}
	
	/**
	 * Column Info
	 * @param atchFlg
	 */
	public void setAtchFlg(String atchFlg) {
		this.atchFlg = atchFlg;
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
	 * @param crIssQty
	 */
	public void setCrIssQty(String crIssQty) {
		this.crIssQty = crIssQty;
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
	 * @param mkrCd
	 */
	public void setMkrCd(String mkrCd) {
		this.mkrCd = mkrCd;
	}
	
	/**
	 * Column Info
	 * @param crIssRmk
	 */
	public void setCrIssRmk(String crIssRmk) {
		this.crIssRmk = crIssRmk;
	}
	
	/**
	 * Column Info
	 * @param usdRt
	 */
	public void setUsdRt(String usdRt) {
		this.usdRt = usdRt;
	}
	
	/**
	 * Column Info
	 * @param crIssEvidNo
	 */
	public void setCrIssEvidNo(String crIssEvidNo) {
		this.crIssEvidNo = crIssEvidNo;
	}
	
	/**
	 * Column Info
	 * @param lrNm
	 */
	public void setLrNm(String lrNm) {
		this.lrNm = lrNm;
	}
	
	/**
	 * Column Info
	 * @param crSumUsdAmt
	 */
	public void setCrSumUsdAmt(String crSumUsdAmt) {
		this.crSumUsdAmt = crSumUsdAmt;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrIssRsn(JSPUtil.getParameter(request, prefix + "cr_iss_rsn", ""));
		setCrIssUtAmt(JSPUtil.getParameter(request, prefix + "cr_iss_ut_amt", ""));
		setCrIssTtlAmt(JSPUtil.getParameter(request, prefix + "cr_iss_ttl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCrIssDt(JSPUtil.getParameter(request, prefix + "cr_iss_dt", ""));
		setTeamCd(JSPUtil.getParameter(request, prefix + "team_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCrIssNo(JSPUtil.getParameter(request, prefix + "cr_iss_no", ""));
		setAtchFlg(JSPUtil.getParameter(request, prefix + "atch_flg", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setCrIssQty(JSPUtil.getParameter(request, prefix + "cr_iss_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMkrCd(JSPUtil.getParameter(request, prefix + "mkr_cd", ""));
		setCrIssRmk(JSPUtil.getParameter(request, prefix + "cr_iss_rmk", ""));
		setUsdRt(JSPUtil.getParameter(request, prefix + "usd_rt", ""));
		setCrIssEvidNo(JSPUtil.getParameter(request, prefix + "cr_iss_evid_no", ""));
		setLrNm(JSPUtil.getParameter(request, prefix + "lr_nm", ""));
		setCrSumUsdAmt(JSPUtil.getParameter(request, prefix + "cr_sum_usd_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrStatusCrIssVO[]
	 */
	public MnrStatusCrIssVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrStatusCrIssVO[]
	 */
	public MnrStatusCrIssVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrStatusCrIssVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crIssRsn = (JSPUtil.getParameter(request, prefix	+ "cr_iss_rsn", length));
			String[] crIssUtAmt = (JSPUtil.getParameter(request, prefix	+ "cr_iss_ut_amt", length));
			String[] crIssTtlAmt = (JSPUtil.getParameter(request, prefix	+ "cr_iss_ttl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] crIssDt = (JSPUtil.getParameter(request, prefix	+ "cr_iss_dt", length));
			String[] teamCd = (JSPUtil.getParameter(request, prefix	+ "team_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] crIssNo = (JSPUtil.getParameter(request, prefix	+ "cr_iss_no", length));
			String[] atchFlg = (JSPUtil.getParameter(request, prefix	+ "atch_flg", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] crIssQty = (JSPUtil.getParameter(request, prefix	+ "cr_iss_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mkrCd = (JSPUtil.getParameter(request, prefix	+ "mkr_cd", length));
			String[] crIssRmk = (JSPUtil.getParameter(request, prefix	+ "cr_iss_rmk", length));
			String[] usdRt = (JSPUtil.getParameter(request, prefix	+ "usd_rt", length));
			String[] crIssEvidNo = (JSPUtil.getParameter(request, prefix	+ "cr_iss_evid_no", length));
			String[] lrNm = (JSPUtil.getParameter(request, prefix	+ "lr_nm", length));
			String[] crSumUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cr_sum_usd_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrStatusCrIssVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crIssRsn[i] != null)
					model.setCrIssRsn(crIssRsn[i]);
				if (crIssUtAmt[i] != null)
					model.setCrIssUtAmt(crIssUtAmt[i]);
				if (crIssTtlAmt[i] != null)
					model.setCrIssTtlAmt(crIssTtlAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (crIssDt[i] != null)
					model.setCrIssDt(crIssDt[i]);
				if (teamCd[i] != null)
					model.setTeamCd(teamCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (crIssNo[i] != null)
					model.setCrIssNo(crIssNo[i]);
				if (atchFlg[i] != null)
					model.setAtchFlg(atchFlg[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (crIssQty[i] != null)
					model.setCrIssQty(crIssQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mkrCd[i] != null)
					model.setMkrCd(mkrCd[i]);
				if (crIssRmk[i] != null)
					model.setCrIssRmk(crIssRmk[i]);
				if (usdRt[i] != null)
					model.setUsdRt(usdRt[i]);
				if (crIssEvidNo[i] != null)
					model.setCrIssEvidNo(crIssEvidNo[i]);
				if (lrNm[i] != null)
					model.setLrNm(lrNm[i]);
				if (crSumUsdAmt[i] != null)
					model.setCrSumUsdAmt(crSumUsdAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrStatusCrIssVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrStatusCrIssVO[]
	 */
	public MnrStatusCrIssVO[] getMnrStatusCrIssVOs(){
		MnrStatusCrIssVO[] vos = (MnrStatusCrIssVO[])models.toArray(new MnrStatusCrIssVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssRsn = this.crIssRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssUtAmt = this.crIssUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssTtlAmt = this.crIssTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssDt = this.crIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamCd = this.teamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssNo = this.crIssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFlg = this.atchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssQty = this.crIssQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkrCd = this.mkrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssRmk = this.crIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdRt = this.usdRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssEvidNo = this.crIssEvidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lrNm = this.lrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crSumUsdAmt = this.crSumUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
