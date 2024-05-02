/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FinanceOfficeInfoVO.java
*@FileTitle : FinanceOfficeInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.23 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FeederageInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FeederageInfoVO> models = new ArrayList<FeederageInfoVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String agnInfoSeq = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String agnFmDtCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String ofcTmpNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofcGrpId = null;
	/* Column Info */
	private String codeErrChk = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String xchRtDivLvl = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agnToDtCd = null;
	/* Column Info */
	private String ofcChrCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String dateErrChk = null;
	/* Column Info */
	private String dpGrpNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ddctAmt = null;
	/* Column Info */
	private String deltFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FeederageInfoVO() {}

	public FeederageInfoVO(String ibflag, String pagerows, String dateErrChk, String codeErrChk, String agnInfoSeq, String rhqCd, String agnCd, String ofcCd, String ofcGrpId, String dpGrpNm, String ofcChrCd, String agnFmDtCd, String fmEffDt, String agnToDtCd, String toEffDt, String vndrSeq, String xchRtDivLvl, String currCd, String arOfcCd, String usrId, String ofcTmpNo, String seq, String polCd, String podCd, String cntrTpszCd, String ddctAmt, String deltFlg) {
		this.currCd = currCd;
		this.agnInfoSeq = agnInfoSeq;
		this.rhqCd = rhqCd;
		this.agnFmDtCd = agnFmDtCd;
		this.arOfcCd = arOfcCd;
		this.ofcTmpNo = ofcTmpNo;
		this.pagerows = pagerows;
		this.toEffDt = toEffDt;
		this.fmEffDt = fmEffDt;
		this.agnCd = agnCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.ofcGrpId = ofcGrpId;
		this.codeErrChk = codeErrChk;
		this.usrId = usrId;
		this.xchRtDivLvl = xchRtDivLvl;
		this.vndrSeq = vndrSeq;
		this.agnToDtCd = agnToDtCd;
		this.ofcChrCd = ofcChrCd;
		this.seq = seq;
		this.dateErrChk = dateErrChk;
		this.dpGrpNm = dpGrpNm;
		this.polCd = polCd;
		this.podCd = podCd;
		this.cntrTpszCd = cntrTpszCd;
		this.ddctAmt = ddctAmt;
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("agn_info_seq", getAgnInfoSeq());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("agn_fm_dt_cd", getAgnFmDtCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("ofc_tmp_no", getOfcTmpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_grp_id", getOfcGrpId());
		this.hashColumns.put("code_err_chk", getCodeErrChk());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("xch_rt_div_lvl", getXchRtDivLvl());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agn_to_dt_cd", getAgnToDtCd());
		this.hashColumns.put("ofc_chr_cd", getOfcChrCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("date_err_chk", getDateErrChk());
		this.hashColumns.put("dp_grp_nm", getDpGrpNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ddct_amt", getDdctAmt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		return this.hashColumns;
		
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agn_info_seq", "agnInfoSeq");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("agn_fm_dt_cd", "agnFmDtCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("ofc_tmp_no", "ofcTmpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_grp_id", "ofcGrpId");
		this.hashFields.put("code_err_chk", "codeErrChk");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("xch_rt_div_lvl", "xchRtDivLvl");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agn_to_dt_cd", "agnToDtCd");
		this.hashFields.put("ofc_chr_cd", "ofcChrCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("date_err_chk", "dateErrChk");
		this.hashFields.put("dp_grp_nm", "dpGrpNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ddct_amt", "ddctAmt");
		this.hashFields.put("delt_flg", "deltFlg");
		
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
	 * @return agnInfoSeq
	 */
	public String getAgnInfoSeq() {
		return this.agnInfoSeq;
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
	 * @return agnFmDtCd
	 */
	public String getAgnFmDtCd() {
		return this.agnFmDtCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcTmpNo
	 */
	public String getOfcTmpNo() {
		return this.ofcTmpNo;
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
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return ofcGrpId
	 */
	public String getOfcGrpId() {
		return this.ofcGrpId;
	}
	
	/**
	 * Column Info
	 * @return codeErrChk
	 */
	public String getCodeErrChk() {
		return this.codeErrChk;
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
	 * @return xchRtDivLvl
	 */
	public String getXchRtDivLvl() {
		return this.xchRtDivLvl;
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
	 * @return agnToDtCd
	 */
	public String getAgnToDtCd() {
		return this.agnToDtCd;
	}
	
	/**
	 * Column Info
	 * @return ofcChrCd
	 */
	public String getOfcChrCd() {
		return this.ofcChrCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return dateErrChk
	 */
	public String getDateErrChk() {
		return this.dateErrChk;
	}
	
	/**
	 * Column Info
	 * @return dpGrpNm
	 */
	public String getDpGrpNm() {
		return this.dpGrpNm;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return ddctAmt
	 */
	public String getDdctAmt() {
		return this.ddctAmt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param agnInfoSeq
	 */
	public void setAgnInfoSeq(String agnInfoSeq) {
		this.agnInfoSeq = agnInfoSeq;
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
	 * @param agnFmDtCd
	 */
	public void setAgnFmDtCd(String agnFmDtCd) {
		this.agnFmDtCd = agnFmDtCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcTmpNo
	 */
	public void setOfcTmpNo(String ofcTmpNo) {
		this.ofcTmpNo = ofcTmpNo;
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
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param ofcGrpId
	 */
	public void setOfcGrpId(String ofcGrpId) {
		this.ofcGrpId = ofcGrpId;
	}
	
	/**
	 * Column Info
	 * @param codeErrChk
	 */
	public void setCodeErrChk(String codeErrChk) {
		this.codeErrChk = codeErrChk;
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
	 * @param xchRtDivLvl
	 */
	public void setXchRtDivLvl(String xchRtDivLvl) {
		this.xchRtDivLvl = xchRtDivLvl;
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
	 * @param agnToDtCd
	 */
	public void setAgnToDtCd(String agnToDtCd) {
		this.agnToDtCd = agnToDtCd;
	}
	
	/**
	 * Column Info
	 * @param ofcChrCd
	 */
	public void setOfcChrCd(String ofcChrCd) {
		this.ofcChrCd = ofcChrCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param dateErrChk
	 */
	public void setDateErrChk(String dateErrChk) {
		this.dateErrChk = dateErrChk;
	}
	
	/**
	 * Column Info
	 * @param dpGrpNm
	 */
	public void setDpGrpNm(String dpGrpNm) {
		this.dpGrpNm = dpGrpNm;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param ddctAmt
	 */
	public void setDdctAmt(String ddctAmt) {
		this.ddctAmt = ddctAmt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
		setAgnInfoSeq(JSPUtil.getParameter(request, prefix + "agn_info_seq", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setAgnFmDtCd(JSPUtil.getParameter(request, prefix + "agn_fm_dt_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setOfcTmpNo(JSPUtil.getParameter(request, prefix + "ofc_tmp_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfcGrpId(JSPUtil.getParameter(request, prefix + "ofc_grp_id", ""));
		setCodeErrChk(JSPUtil.getParameter(request, prefix + "code_err_chk", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setXchRtDivLvl(JSPUtil.getParameter(request, prefix + "xch_rt_div_lvl", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setAgnToDtCd(JSPUtil.getParameter(request, prefix + "agn_to_dt_cd", ""));
		setOfcChrCd(JSPUtil.getParameter(request, prefix + "ofc_chr_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setDateErrChk(JSPUtil.getParameter(request, prefix + "date_err_chk", ""));
		setDpGrpNm(JSPUtil.getParameter(request, prefix + "dp_grp_nm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDdctAmt(JSPUtil.getParameter(request, prefix + "ddct_amt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FinanceOfficeInfoVO[]
	 */
	public FeederageInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FinanceOfficeInfoVO[]
	 */
	public FeederageInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FeederageInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] agnInfoSeq = (JSPUtil.getParameter(request, prefix	+ "agn_info_seq", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] agnFmDtCd = (JSPUtil.getParameter(request, prefix	+ "agn_fm_dt_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] ofcTmpNo = (JSPUtil.getParameter(request, prefix	+ "ofc_tmp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofcGrpId = (JSPUtil.getParameter(request, prefix	+ "ofc_grp_id", length));
			String[] codeErrChk = (JSPUtil.getParameter(request, prefix	+ "code_err_chk", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] xchRtDivLvl = (JSPUtil.getParameter(request, prefix	+ "xch_rt_div_lvl", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agnToDtCd = (JSPUtil.getParameter(request, prefix	+ "agn_to_dt_cd", length));
			String[] ofcChrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_chr_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] dateErrChk = (JSPUtil.getParameter(request, prefix	+ "date_err_chk", length));
			String[] dpGrpNm = (JSPUtil.getParameter(request, prefix	+ "dp_grp_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ddctAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_amt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new FeederageInfoVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (agnInfoSeq[i] != null)
					model.setAgnInfoSeq(agnInfoSeq[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (agnFmDtCd[i] != null)
					model.setAgnFmDtCd(agnFmDtCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (ofcTmpNo[i] != null)
					model.setOfcTmpNo(ofcTmpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcGrpId[i] != null)
					model.setOfcGrpId(ofcGrpId[i]);
				if (codeErrChk[i] != null)
					model.setCodeErrChk(codeErrChk[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (xchRtDivLvl[i] != null)
					model.setXchRtDivLvl(xchRtDivLvl[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agnToDtCd[i] != null)
					model.setAgnToDtCd(agnToDtCd[i]);
				if (ofcChrCd[i] != null)
					model.setOfcChrCd(ofcChrCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (dateErrChk[i] != null)
					model.setDateErrChk(dateErrChk[i]);
				if (dpGrpNm[i] != null)
					model.setDpGrpNm(dpGrpNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ddctAmt[i] != null)
					model.setDdctAmt(ddctAmt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFeederageInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FinanceOfficeInfoVO[]
	 */
	public FeederageInfoVO[] getFeederageInfoVOs(){
		FeederageInfoVO[] vos = (FeederageInfoVO[])models.toArray(new FeederageInfoVO[models.size()]);
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
		this.agnInfoSeq = this.agnInfoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnFmDtCd = this.agnFmDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTmpNo = this.ofcTmpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcGrpId = this.ofcGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeErrChk = this.codeErrChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDivLvl = this.xchRtDivLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnToDtCd = this.agnToDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcChrCd = this.ofcChrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateErrChk = this.dateErrChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpGrpNm = this.dpGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctAmt = this.ddctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
