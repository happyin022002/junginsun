/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BnfStatusMlgVO.java
*@FileTitle : BnfStatusMlgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.16 신동일 
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

public class BnfStatusMlgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BnfStatusMlgVO> models = new ArrayList<BnfStatusMlgVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String incntNo = null;
	/* Column Info */
	private String cshBakAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String cshBakBalAmt = null;
	/* Column Info */
	private String atch2Flg = null;
	/* Column Info */
	private String cshBakDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mlgIssDt = null;
	/* Column Info */
	private String teamNm = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String mlgToDt = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String atchFlg = null;
	/* Column Info */
	private String atchN2ndFileLnkId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mlgPntAmt = null;
	/* Column Info */
	private String incntRmk = null;
	/* Column Info */
	private String mlgFmDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BnfStatusMlgVO() {}

	public BnfStatusMlgVO(String ibflag, String pagerows, String bseYr, String incntNo, String rhqCd, String teamNm, String bankNm, String mlgFmDt, String mlgToDt, String payAmt, String mlgIssDt, String mlgPntAmt, String cshBakDt, String cshBakAmt, String cshBakBalAmt, String incntRmk, String atchFlg, String atchFileLnkId, String atch2Flg, String atchN2ndFileLnkId, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.incntNo = incntNo;
		this.cshBakAmt = cshBakAmt;
		this.pagerows = pagerows;
		this.atchFileLnkId = atchFileLnkId;
		this.ibflag = ibflag;
		this.payAmt = payAmt;
		this.bankNm = bankNm;
		this.cshBakBalAmt = cshBakBalAmt;
		this.atch2Flg = atch2Flg;
		this.cshBakDt = cshBakDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.mlgIssDt = mlgIssDt;
		this.teamNm = teamNm;
		this.rhqCd = rhqCd;
		this.mlgToDt = mlgToDt;
		this.bseYr = bseYr;
		this.atchFlg = atchFlg;
		this.atchN2ndFileLnkId = atchN2ndFileLnkId;
		this.creUsrId = creUsrId;
		this.mlgPntAmt = mlgPntAmt;
		this.incntRmk = incntRmk;
		this.mlgFmDt = mlgFmDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("incnt_no", getIncntNo());
		this.hashColumns.put("csh_bak_amt", getCshBakAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("csh_bak_bal_amt", getCshBakBalAmt());
		this.hashColumns.put("atch2_flg", getAtch2Flg());
		this.hashColumns.put("csh_bak_dt", getCshBakDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mlg_iss_dt", getMlgIssDt());
		this.hashColumns.put("team_nm", getTeamNm());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("mlg_to_dt", getMlgToDt());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("atch_flg", getAtchFlg());
		this.hashColumns.put("atch_n2nd_file_lnk_id", getAtchN2ndFileLnkId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mlg_pnt_amt", getMlgPntAmt());
		this.hashColumns.put("incnt_rmk", getIncntRmk());
		this.hashColumns.put("mlg_fm_dt", getMlgFmDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("incnt_no", "incntNo");
		this.hashFields.put("csh_bak_amt", "cshBakAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("csh_bak_bal_amt", "cshBakBalAmt");
		this.hashFields.put("atch2_flg", "atch2Flg");
		this.hashFields.put("csh_bak_dt", "cshBakDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mlg_iss_dt", "mlgIssDt");
		this.hashFields.put("team_nm", "teamNm");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("mlg_to_dt", "mlgToDt");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("atch_flg", "atchFlg");
		this.hashFields.put("atch_n2nd_file_lnk_id", "atchN2ndFileLnkId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mlg_pnt_amt", "mlgPntAmt");
		this.hashFields.put("incnt_rmk", "incntRmk");
		this.hashFields.put("mlg_fm_dt", "mlgFmDt");
		return this.hashFields;
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
	 * @return incntNo
	 */
	public String getIncntNo() {
		return this.incntNo;
	}
	
	/**
	 * Column Info
	 * @return cshBakAmt
	 */
	public String getCshBakAmt() {
		return this.cshBakAmt;
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
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}
	
	/**
	 * Column Info
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}
	
	/**
	 * Column Info
	 * @return cshBakBalAmt
	 */
	public String getCshBakBalAmt() {
		return this.cshBakBalAmt;
	}
	
	/**
	 * Column Info
	 * @return atch2Flg
	 */
	public String getAtch2Flg() {
		return this.atch2Flg;
	}
	
	/**
	 * Column Info
	 * @return cshBakDt
	 */
	public String getCshBakDt() {
		return this.cshBakDt;
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
	 * @return mlgIssDt
	 */
	public String getMlgIssDt() {
		return this.mlgIssDt;
	}
	
	/**
	 * Column Info
	 * @return teamNm
	 */
	public String getTeamNm() {
		return this.teamNm;
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
	 * @return mlgToDt
	 */
	public String getMlgToDt() {
		return this.mlgToDt;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
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
	 * @return atchN2ndFileLnkId
	 */
	public String getAtchN2ndFileLnkId() {
		return this.atchN2ndFileLnkId;
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
	 * @return mlgPntAmt
	 */
	public String getMlgPntAmt() {
		return this.mlgPntAmt;
	}
	
	/**
	 * Column Info
	 * @return incntRmk
	 */
	public String getIncntRmk() {
		return this.incntRmk;
	}
	
	/**
	 * Column Info
	 * @return mlgFmDt
	 */
	public String getMlgFmDt() {
		return this.mlgFmDt;
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
	 * @param incntNo
	 */
	public void setIncntNo(String incntNo) {
		this.incntNo = incntNo;
	}
	
	/**
	 * Column Info
	 * @param cshBakAmt
	 */
	public void setCshBakAmt(String cshBakAmt) {
		this.cshBakAmt = cshBakAmt;
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
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}
	
	/**
	 * Column Info
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	/**
	 * Column Info
	 * @param cshBakBalAmt
	 */
	public void setCshBakBalAmt(String cshBakBalAmt) {
		this.cshBakBalAmt = cshBakBalAmt;
	}
	
	/**
	 * Column Info
	 * @param atch2Flg
	 */
	public void setAtch2Flg(String atch2Flg) {
		this.atch2Flg = atch2Flg;
	}
	
	/**
	 * Column Info
	 * @param cshBakDt
	 */
	public void setCshBakDt(String cshBakDt) {
		this.cshBakDt = cshBakDt;
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
	 * @param mlgIssDt
	 */
	public void setMlgIssDt(String mlgIssDt) {
		this.mlgIssDt = mlgIssDt;
	}
	
	/**
	 * Column Info
	 * @param teamNm
	 */
	public void setTeamNm(String teamNm) {
		this.teamNm = teamNm;
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
	 * @param mlgToDt
	 */
	public void setMlgToDt(String mlgToDt) {
		this.mlgToDt = mlgToDt;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
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
	 * @param atchN2ndFileLnkId
	 */
	public void setAtchN2ndFileLnkId(String atchN2ndFileLnkId) {
		this.atchN2ndFileLnkId = atchN2ndFileLnkId;
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
	 * @param mlgPntAmt
	 */
	public void setMlgPntAmt(String mlgPntAmt) {
		this.mlgPntAmt = mlgPntAmt;
	}
	
	/**
	 * Column Info
	 * @param incntRmk
	 */
	public void setIncntRmk(String incntRmk) {
		this.incntRmk = incntRmk;
	}
	
	/**
	 * Column Info
	 * @param mlgFmDt
	 */
	public void setMlgFmDt(String mlgFmDt) {
		this.mlgFmDt = mlgFmDt;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIncntNo(JSPUtil.getParameter(request, prefix + "incnt_no", ""));
		setCshBakAmt(JSPUtil.getParameter(request, prefix + "csh_bak_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setBankNm(JSPUtil.getParameter(request, prefix + "bank_nm", ""));
		setCshBakBalAmt(JSPUtil.getParameter(request, prefix + "csh_bak_bal_amt", ""));
		setAtch2Flg(JSPUtil.getParameter(request, prefix + "atch2_flg", ""));
		setCshBakDt(JSPUtil.getParameter(request, prefix + "csh_bak_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMlgIssDt(JSPUtil.getParameter(request, prefix + "mlg_iss_dt", ""));
		setTeamNm(JSPUtil.getParameter(request, prefix + "team_nm", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setMlgToDt(JSPUtil.getParameter(request, prefix + "mlg_to_dt", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setAtchFlg(JSPUtil.getParameter(request, prefix + "atch_flg", ""));
		setAtchN2ndFileLnkId(JSPUtil.getParameter(request, prefix + "atch_n2nd_file_lnk_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMlgPntAmt(JSPUtil.getParameter(request, prefix + "mlg_pnt_amt", ""));
		setIncntRmk(JSPUtil.getParameter(request, prefix + "incnt_rmk", ""));
		setMlgFmDt(JSPUtil.getParameter(request, prefix + "mlg_fm_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BnfStatusMlgVO[]
	 */
	public BnfStatusMlgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BnfStatusMlgVO[]
	 */
	public BnfStatusMlgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BnfStatusMlgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] incntNo = (JSPUtil.getParameter(request, prefix	+ "incnt_no", length));
			String[] cshBakAmt = (JSPUtil.getParameter(request, prefix	+ "csh_bak_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] cshBakBalAmt = (JSPUtil.getParameter(request, prefix	+ "csh_bak_bal_amt", length));
			String[] atch2Flg = (JSPUtil.getParameter(request, prefix	+ "atch2_flg", length));
			String[] cshBakDt = (JSPUtil.getParameter(request, prefix	+ "csh_bak_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mlgIssDt = (JSPUtil.getParameter(request, prefix	+ "mlg_iss_dt", length));
			String[] teamNm = (JSPUtil.getParameter(request, prefix	+ "team_nm", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] mlgToDt = (JSPUtil.getParameter(request, prefix	+ "mlg_to_dt", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] atchFlg = (JSPUtil.getParameter(request, prefix	+ "atch_flg", length));
			String[] atchN2ndFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_n2nd_file_lnk_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mlgPntAmt = (JSPUtil.getParameter(request, prefix	+ "mlg_pnt_amt", length));
			String[] incntRmk = (JSPUtil.getParameter(request, prefix	+ "incnt_rmk", length));
			String[] mlgFmDt = (JSPUtil.getParameter(request, prefix	+ "mlg_fm_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BnfStatusMlgVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (incntNo[i] != null)
					model.setIncntNo(incntNo[i]);
				if (cshBakAmt[i] != null)
					model.setCshBakAmt(cshBakAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (cshBakBalAmt[i] != null)
					model.setCshBakBalAmt(cshBakBalAmt[i]);
				if (atch2Flg[i] != null)
					model.setAtch2Flg(atch2Flg[i]);
				if (cshBakDt[i] != null)
					model.setCshBakDt(cshBakDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mlgIssDt[i] != null)
					model.setMlgIssDt(mlgIssDt[i]);
				if (teamNm[i] != null)
					model.setTeamNm(teamNm[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (mlgToDt[i] != null)
					model.setMlgToDt(mlgToDt[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (atchFlg[i] != null)
					model.setAtchFlg(atchFlg[i]);
				if (atchN2ndFileLnkId[i] != null)
					model.setAtchN2ndFileLnkId(atchN2ndFileLnkId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mlgPntAmt[i] != null)
					model.setMlgPntAmt(mlgPntAmt[i]);
				if (incntRmk[i] != null)
					model.setIncntRmk(incntRmk[i]);
				if (mlgFmDt[i] != null)
					model.setMlgFmDt(mlgFmDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBnfStatusMlgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BnfStatusMlgVO[]
	 */
	public BnfStatusMlgVO[] getBnfStatusMlgVOs(){
		BnfStatusMlgVO[] vos = (BnfStatusMlgVO[])models.toArray(new BnfStatusMlgVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incntNo = this.incntNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cshBakAmt = this.cshBakAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cshBakBalAmt = this.cshBakBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atch2Flg = this.atch2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cshBakDt = this.cshBakDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlgIssDt = this.mlgIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamNm = this.teamNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlgToDt = this.mlgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFlg = this.atchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchN2ndFileLnkId = this.atchN2ndFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlgPntAmt = this.mlgPntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incntRmk = this.incntRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlgFmDt = this.mlgFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
