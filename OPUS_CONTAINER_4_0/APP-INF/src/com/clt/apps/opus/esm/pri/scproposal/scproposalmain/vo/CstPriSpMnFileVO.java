/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstPriSpMnFileVO.java
*@FileTitle : CstPriSpMnFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.12.15 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstPriSpMnFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstPriSpMnFileVO> models = new ArrayList<CstPriSpMnFileVO>();
	
	/* Column Info */
	private String propAproDt = null;
	/* Column Info */
//	private String realCustValSgmCd = null;
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String realCustCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String respbSlsOfcCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String realCustSeq = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String slsLdNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String respbSrepCd = null;
	/* Column Info */
	private String realCustSlsOfcCd = null;
	/* Column Info */
	private String blplHdrSeq = null;
	/* Column Info */
	private String gamtFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String effDtChg = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String realCustTpCd = null;
	/* Column Info */
	private String realCustSrepCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstPriSpMnFileVO() {}

	public CstPriSpMnFileVO(String ibflag, String pagerows, String propNo, String amdtSeq, String effDt, String expDt, String fileDt, String propSrepCd, String propOfcCd, String propAproOfcCd, String propAproDt, String propStsCd, String respbSrepCd, String respbSlsOfcCd, String realCustCntCd, String realCustSeq, String realCustValSgmCd, String realCustTpCd, String realCustSrepCd, String realCustSlsOfcCd, String slsLdNo, String rfFlg, String gamtFlg, String blplHdrSeq, String creUsrId, String creDt, String updUsrId, String updDt, String effDtChg) {
		this.propAproDt = propAproDt;
//		this.realCustValSgmCd = realCustValSgmCd;
		this.rfFlg = rfFlg;
		this.amdtSeq = amdtSeq;
		this.creDt = creDt;
		this.realCustCntCd = realCustCntCd;
		this.pagerows = pagerows;
		this.respbSlsOfcCd = respbSlsOfcCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.propStsCd = propStsCd;
		this.realCustSeq = realCustSeq;
		this.expDt = expDt;
		this.slsLdNo = slsLdNo;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.propSrepCd = propSrepCd;
		this.fileDt = fileDt;
		this.respbSrepCd = respbSrepCd;
		this.realCustSlsOfcCd = realCustSlsOfcCd;
		this.blplHdrSeq = blplHdrSeq;
		this.gamtFlg = gamtFlg;
		this.creUsrId = creUsrId;
		this.effDtChg = effDtChg;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.propNo = propNo;
		this.realCustTpCd = realCustTpCd;
		this.realCustSrepCd = realCustSrepCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prop_apro_dt", getPropAproDt());
//		this.hashColumns.put("real_cust_val_sgm_cd", getRealCustValSgmCd());
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("real_cust_cnt_cd", getRealCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("respb_sls_ofc_cd", getRespbSlsOfcCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("real_cust_seq", getRealCustSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("sls_ld_no", getSlsLdNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("respb_srep_cd", getRespbSrepCd());
		this.hashColumns.put("real_cust_sls_ofc_cd", getRealCustSlsOfcCd());
		this.hashColumns.put("blpl_hdr_seq", getBlplHdrSeq());
		this.hashColumns.put("gamt_flg", getGamtFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eff_dt_chg", getEffDtChg());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("real_cust_tp_cd", getRealCustTpCd());
		this.hashColumns.put("real_cust_srep_cd", getRealCustSrepCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prop_apro_dt", "propAproDt");
		this.hashFields.put("real_cust_val_sgm_cd", "realCustValSgmCd");
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("real_cust_cnt_cd", "realCustCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("respb_sls_ofc_cd", "respbSlsOfcCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("real_cust_seq", "realCustSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("sls_ld_no", "slsLdNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("respb_srep_cd", "respbSrepCd");
		this.hashFields.put("real_cust_sls_ofc_cd", "realCustSlsOfcCd");
		this.hashFields.put("blpl_hdr_seq", "blplHdrSeq");
		this.hashFields.put("gamt_flg", "gamtFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eff_dt_chg", "effDtChg");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("real_cust_tp_cd", "realCustTpCd");
		this.hashFields.put("real_cust_srep_cd", "realCustSrepCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return propAproDt
	 */
	public String getPropAproDt() {
		return this.propAproDt;
	}
	
	/**
	 * Column Info
	 * @return realCustValSgmCd
	 */
//	public String getRealCustValSgmCd() {
//		return this.realCustValSgmCd;
//	}
	
	/**
	 * Column Info
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return realCustCntCd
	 */
	public String getRealCustCntCd() {
		return this.realCustCntCd;
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
	 * @return respbSlsOfcCd
	 */
	public String getRespbSlsOfcCd() {
		return this.respbSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
	}
	
	/**
	 * Column Info
	 * @return realCustSeq
	 */
	public String getRealCustSeq() {
		return this.realCustSeq;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return slsLdNo
	 */
	public String getSlsLdNo() {
		return this.slsLdNo;
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
	 * @return propSrepCd
	 */
	public String getPropSrepCd() {
		return this.propSrepCd;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return respbSrepCd
	 */
	public String getRespbSrepCd() {
		return this.respbSrepCd;
	}
	
	/**
	 * Column Info
	 * @return realCustSlsOfcCd
	 */
	public String getRealCustSlsOfcCd() {
		return this.realCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blplHdrSeq
	 */
	public String getBlplHdrSeq() {
		return this.blplHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return gamtFlg
	 */
	public String getGamtFlg() {
		return this.gamtFlg;
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
	 * @return effDtChg
	 */
	public String getEffDtChg() {
		return this.effDtChg;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
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
	 * @return realCustTpCd
	 */
	public String getRealCustTpCd() {
		return this.realCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return realCustSrepCd
	 */
	public String getRealCustSrepCd() {
		return this.realCustSrepCd;
	}
	

	/**
	 * Column Info
	 * @param propAproDt
	 */
	public void setPropAproDt(String propAproDt) {
		this.propAproDt = propAproDt;
	}
	
	/**
	 * Column Info
	 * @param realCustValSgmCd
	 */
//	public void setRealCustValSgmCd(String realCustValSgmCd) {
//		this.realCustValSgmCd = realCustValSgmCd;
//	}
	
	/**
	 * Column Info
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param realCustCntCd
	 */
	public void setRealCustCntCd(String realCustCntCd) {
		this.realCustCntCd = realCustCntCd;
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
	 * @param respbSlsOfcCd
	 */
	public void setRespbSlsOfcCd(String respbSlsOfcCd) {
		this.respbSlsOfcCd = respbSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
	}
	
	/**
	 * Column Info
	 * @param realCustSeq
	 */
	public void setRealCustSeq(String realCustSeq) {
		this.realCustSeq = realCustSeq;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param slsLdNo
	 */
	public void setSlsLdNo(String slsLdNo) {
		this.slsLdNo = slsLdNo;
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
	 * @param propSrepCd
	 */
	public void setPropSrepCd(String propSrepCd) {
		this.propSrepCd = propSrepCd;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param respbSrepCd
	 */
	public void setRespbSrepCd(String respbSrepCd) {
		this.respbSrepCd = respbSrepCd;
	}
	
	/**
	 * Column Info
	 * @param realCustSlsOfcCd
	 */
	public void setRealCustSlsOfcCd(String realCustSlsOfcCd) {
		this.realCustSlsOfcCd = realCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blplHdrSeq
	 */
	public void setBlplHdrSeq(String blplHdrSeq) {
		this.blplHdrSeq = blplHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param gamtFlg
	 */
	public void setGamtFlg(String gamtFlg) {
		this.gamtFlg = gamtFlg;
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
	 * @param effDtChg
	 */
	public void setEffDtChg(String effDtChg) {
		this.effDtChg = effDtChg;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
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
	 * @param realCustTpCd
	 */
	public void setRealCustTpCd(String realCustTpCd) {
		this.realCustTpCd = realCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param realCustSrepCd
	 */
	public void setRealCustSrepCd(String realCustSrepCd) {
		this.realCustSrepCd = realCustSrepCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPropAproDt(JSPUtil.getParameter(request, "prop_apro_dt", ""));
//		setRealCustValSgmCd(JSPUtil.getParameter(request, "real_cust_val_sgm_cd", ""));
		setRfFlg(JSPUtil.getParameter(request, "rf_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRealCustCntCd(JSPUtil.getParameter(request, "real_cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRespbSlsOfcCd(JSPUtil.getParameter(request, "respb_sls_ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPropStsCd(JSPUtil.getParameter(request, "prop_sts_cd", ""));
		setRealCustSeq(JSPUtil.getParameter(request, "real_cust_seq", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setSlsLdNo(JSPUtil.getParameter(request, "sls_ld_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPropSrepCd(JSPUtil.getParameter(request, "prop_srep_cd", ""));
		setFileDt(JSPUtil.getParameter(request, "file_dt", ""));
		setRespbSrepCd(JSPUtil.getParameter(request, "respb_srep_cd", ""));
		setRealCustSlsOfcCd(JSPUtil.getParameter(request, "real_cust_sls_ofc_cd", ""));
		setBlplHdrSeq(JSPUtil.getParameter(request, "blpl_hdr_seq", ""));
		setGamtFlg(JSPUtil.getParameter(request, "gamt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEffDtChg(JSPUtil.getParameter(request, "eff_dt_chg", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, "prop_apro_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setRealCustTpCd(JSPUtil.getParameter(request, "real_cust_tp_cd", ""));
		setRealCustSrepCd(JSPUtil.getParameter(request, "real_cust_srep_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstPriSpMnFileVO[]
	 */
	public CstPriSpMnFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstPriSpMnFileVO[]
	 */
	public CstPriSpMnFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstPriSpMnFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] propAproDt = (JSPUtil.getParameter(request, prefix	+ "prop_apro_dt", length));
//			String[] realCustValSgmCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_val_sgm_cd", length));
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] realCustCntCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] respbSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_sls_ofc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] realCustSeq = (JSPUtil.getParameter(request, prefix	+ "real_cust_seq", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] slsLdNo = (JSPUtil.getParameter(request, prefix	+ "sls_ld_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] respbSrepCd = (JSPUtil.getParameter(request, prefix	+ "respb_srep_cd", length));
			String[] realCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_sls_ofc_cd", length));
			String[] blplHdrSeq = (JSPUtil.getParameter(request, prefix	+ "blpl_hdr_seq", length));
			String[] gamtFlg = (JSPUtil.getParameter(request, prefix	+ "gamt_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] effDtChg = (JSPUtil.getParameter(request, prefix	+ "eff_dt_chg", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] realCustTpCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_tp_cd", length));
			String[] realCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_srep_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstPriSpMnFileVO();
				if (propAproDt[i] != null)
					model.setPropAproDt(propAproDt[i]);
//				if (realCustValSgmCd[i] != null)
//					model.setRealCustValSgmCd(realCustValSgmCd[i]);
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (realCustCntCd[i] != null)
					model.setRealCustCntCd(realCustCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (respbSlsOfcCd[i] != null)
					model.setRespbSlsOfcCd(respbSlsOfcCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (realCustSeq[i] != null)
					model.setRealCustSeq(realCustSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (slsLdNo[i] != null)
					model.setSlsLdNo(slsLdNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (respbSrepCd[i] != null)
					model.setRespbSrepCd(respbSrepCd[i]);
				if (realCustSlsOfcCd[i] != null)
					model.setRealCustSlsOfcCd(realCustSlsOfcCd[i]);
				if (blplHdrSeq[i] != null)
					model.setBlplHdrSeq(blplHdrSeq[i]);
				if (gamtFlg[i] != null)
					model.setGamtFlg(gamtFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (effDtChg[i] != null)
					model.setEffDtChg(effDtChg[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (realCustTpCd[i] != null)
					model.setRealCustTpCd(realCustTpCd[i]);
				if (realCustSrepCd[i] != null)
					model.setRealCustSrepCd(realCustSrepCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstPriSpMnFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstPriSpMnFileVO[]
	 */
	public CstPriSpMnFileVO[] getCstPriSpMnFileVOs(){
		CstPriSpMnFileVO[] vos = (CstPriSpMnFileVO[])models.toArray(new CstPriSpMnFileVO[models.size()]);
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
		this.propAproDt = this.propAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.realCustValSgmCd = this.realCustValSgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustCntCd = this.realCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSlsOfcCd = this.respbSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSeq = this.realCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsLdNo = this.slsLdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSrepCd = this.respbSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSlsOfcCd = this.realCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplHdrSeq = this.blplHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gamtFlg = this.gamtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDtChg = this.effDtChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustTpCd = this.realCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSrepCd = this.realCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
