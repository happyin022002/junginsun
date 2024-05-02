/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseInOutInquiryVO.java
*@FileTitle : MisUseInOutInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.20 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MisUseInOutInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<MisUseInOutInquiryVO> models = new ArrayList<MisUseInOutInquiryVO>();

	/* Column Info */
	private String mssRqstIoModCd = null;
	/* Column Info */
	private String liborPtyNm = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String aproAgmtCtyCd = null;
	/* Column Info */
	private String rqstLocCd = null;
	/* Column Info */
	private String rqstLocNm = null;
	/* Column Info */
	private String n2ndRefOfcCd = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String mssUsdFmNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lftChgRtAmt = null;
	/* Column Info */
	private String pdChgRtAmt = null;
	/* Column Info */
	private String n3rdRefOfcCd = null;
	/* Column Info */
	private String aproAgmtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproAgmtSeq = null;
	/* Column Info */
	private String mssUsePlcNm = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String n1stRefOfcCd = null;
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String aproNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String refOfcCd = null;
	/* Column Info */
	private String mssUsdAproModCd = null;
	/* Column Info */
	private String mssUsdDt = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String n4thRefOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rqstFileSavId = null;
	/* Column Info */
	private String rqstFileSavNm = null;
	/* Column Info */
	private String rqstRsnDesc = null;
	/* Column Info */
	private String aproFileSavId = null;
	/* Column Info */
	private String aproFileSavNm = null;
	/* Column Info */
	private String aproRsnDesc = null;
	/* Column Info */
	private String cxlFileSavId = null;
	/* Column Info */
	private String cxlFileSavNm = null;
	/* Column Info */
	private String cxlRsnDesc = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public MisUseInOutInquiryVO() {}

	public MisUseInOutInquiryVO(String ibflag, String mvmtStsCd, String podCd, String polCd, String rqstFileSavId, String rqstFileSavNm, String rqstRsnDesc, String aproFileSavId, String aproFileSavNm, String aproRsnDesc, String cxlFileSavId, String cxlFileSavNm, String cxlRsnDesc, String pagerows, String updUsrId, String rqstLocNm, String rqstNo, String aproNo, String rqstOfcCd, String rqstDt, String mssRqstIoModCd, String refOfcCd, String n1stRefOfcCd, String n2ndRefOfcCd, String n3rdRefOfcCd, String n4thRefOfcCd, String rqstUsrId, String diffRmk, String currCd, String aproOfcCd, String aproUsrId, String aproRmk, String cntrNo, String agmtCtyCd, String agmtSeq, String cntrTpszCd, String lstmCd, String mssUsdDt, String mssUsdFmNm, String mssUsePlcNm, String pdChgRtAmt, String lftChgRtAmt, String liborPtyNm, String mssUsdAproModCd, String rqstLocCd, String aproAgmtCtyCd, String aproAgmtSeq, String aproAgmtNo) {
		this.mssRqstIoModCd = mssRqstIoModCd;
		this.liborPtyNm = liborPtyNm;
		this.rqstUsrId = rqstUsrId;
		this.rqstNo = rqstNo;
		this.currCd = currCd;
		this.aproAgmtCtyCd = aproAgmtCtyCd;
		this.rqstLocCd = rqstLocCd;
		this.rqstLocNm = rqstLocNm;
		this.n2ndRefOfcCd = n2ndRefOfcCd;
		this.aproOfcCd = aproOfcCd;
		this.mssUsdFmNm = mssUsdFmNm;
		this.pagerows = pagerows;
		this.lftChgRtAmt = lftChgRtAmt;
		this.pdChgRtAmt = pdChgRtAmt;
		this.n3rdRefOfcCd = n3rdRefOfcCd;
		this.aproAgmtNo = aproAgmtNo;
		this.ibflag = ibflag;
		this.aproAgmtSeq = aproAgmtSeq;
		this.mssUsePlcNm = mssUsePlcNm;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.n1stRefOfcCd = n1stRefOfcCd;
		this.aproRmk = aproRmk;
		this.rqstDt = rqstDt;
		this.aproNo = aproNo;
		this.agmtSeq = agmtSeq;
		this.refOfcCd = refOfcCd;
		this.mssUsdAproModCd = mssUsdAproModCd;
		this.mssUsdDt = mssUsdDt;
		this.diffRmk = diffRmk;
		this.aproUsrId = aproUsrId;
		this.cntrNo = cntrNo;
		this.rqstOfcCd = rqstOfcCd;
		this.n4thRefOfcCd = n4thRefOfcCd;
		this.updUsrId = updUsrId;
		this.rqstFileSavId = rqstFileSavId;
		this.rqstFileSavNm = rqstFileSavNm;
		this.rqstRsnDesc = rqstRsnDesc;
		this.aproFileSavId = aproFileSavId;
		this.aproFileSavNm = aproFileSavNm;
		this.aproRsnDesc = aproRsnDesc;
		this.cxlFileSavId = cxlFileSavId;
		this.cxlFileSavNm = cxlFileSavNm;
		this.cxlRsnDesc = cxlRsnDesc;
		this.mvmtStsCd = mvmtStsCd;
		this.podCd = podCd;
		this.polCd = polCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mss_rqst_io_mod_cd", getMssRqstIoModCd());
		this.hashColumns.put("libor_pty_nm", getLiborPtyNm());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("apro_agmt_cty_cd", getAproAgmtCtyCd());
		this.hashColumns.put("rqst_loc_cd", getRqstLocCd());
		this.hashColumns.put("rqst_loc_nm", getRqstLocNm());
		this.hashColumns.put("n2nd_ref_ofc_cd", getN2ndRefOfcCd());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("mss_usd_fm_nm", getMssUsdFmNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lft_chg_rt_amt", getLftChgRtAmt());
		this.hashColumns.put("pd_chg_rt_amt", getPdChgRtAmt());
		this.hashColumns.put("n3rd_ref_ofc_cd", getN3rdRefOfcCd());
		this.hashColumns.put("apro_agmt_no", getAproAgmtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_agmt_seq", getAproAgmtSeq());
		this.hashColumns.put("mss_use_plc_nm", getMssUsePlcNm());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("n1st_ref_ofc_cd", getN1stRefOfcCd());
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("ref_ofc_cd", getRefOfcCd());
		this.hashColumns.put("mss_usd_apro_mod_cd", getMssUsdAproModCd());
		this.hashColumns.put("mss_usd_dt", getMssUsdDt());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("n4th_ref_ofc_cd", getN4thRefOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rqst_file_sav_id", getRqstFileSavId());
		this.hashColumns.put("rqst_file_sav_nm", getRqstFileSavNm());
		this.hashColumns.put("rqst_rsn_desc", getRqstRsnDesc());
		this.hashColumns.put("apro_file_sav_id", getAproFileSavId());
		this.hashColumns.put("apro_file_sav_nm", getAproFileSavNm());
		this.hashColumns.put("apro_rsn_desc", getAproRsnDesc());
		this.hashColumns.put("cxl_file_sav_id", getCxlFileSavId());
		this.hashColumns.put("cxl_file_sav_nm", getCxlFileSavNm());
		this.hashColumns.put("cxl_rsn_desc", getCxlRsnDesc());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mss_rqst_io_mod_cd", "mssRqstIoModCd");
		this.hashFields.put("libor_pty_nm", "liborPtyNm");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("apro_agmt_cty_cd", "aproAgmtCtyCd");
		this.hashFields.put("rqst_loc_cd", "rqstLocCd");
		this.hashFields.put("rqst_loc_nm", "rqstLocNm");
		this.hashFields.put("n2nd_ref_ofc_cd", "n2ndRefOfcCd");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("mss_usd_fm_nm", "mssUsdFmNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lft_chg_rt_amt", "lftChgRtAmt");
		this.hashFields.put("pd_chg_rt_amt", "pdChgRtAmt");
		this.hashFields.put("n3rd_ref_ofc_cd", "n3rdRefOfcCd");
		this.hashFields.put("apro_agmt_no", "aproAgmtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_agmt_seq", "aproAgmtSeq");
		this.hashFields.put("mss_use_plc_nm", "mssUsePlcNm");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("n1st_ref_ofc_cd", "n1stRefOfcCd");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("ref_ofc_cd", "refOfcCd");
		this.hashFields.put("mss_usd_apro_mod_cd", "mssUsdAproModCd");
		this.hashFields.put("mss_usd_dt", "mssUsdDt");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("n4th_ref_ofc_cd", "n4thRefOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rqst_file_sav_id", "rqstFileSavId");
		this.hashFields.put("rqst_file_sav_nm", "rqstFileSavNm");
		this.hashFields.put("rqst_rsn_desc", "rqstRsnDesc");
		this.hashFields.put("apro_file_sav_id", "aproFileSavId");
		this.hashFields.put("apro_file_sav_nm", "aproFileSavNm");
		this.hashFields.put("apro_rsn_desc", "aproRsnDesc");
		this.hashFields.put("cxl_file_sav_id", "cxlFileSavId");
		this.hashFields.put("cxl_file_sav_nm", "cxlFileSavNm");
		this.hashFields.put("cxl_rsn_desc", "cxlRsnDesc");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return mssRqstIoModCd
	 */
	public String getMssRqstIoModCd() {
		return this.mssRqstIoModCd;
	}

	/**
	 * Column Info
	 * @return liborPtyNm
	 */
	public String getLiborPtyNm() {
		return this.liborPtyNm;
	}

	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}

	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
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
	 * @return aproAgmtCtyCd
	 */
	public String getAproAgmtCtyCd() {
		return this.aproAgmtCtyCd;
	}

	/**
	 * Column Info
	 * @return rqstLocCd
	 */
	public String getRqstLocCd() {
		return this.rqstLocCd;
	}

	/**
	 * Column Info
	 * @return n2ndRefOfcCd
	 */
	public String getN2ndRefOfcCd() {
		return this.n2ndRefOfcCd;
	}

	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}

	/**
	 * Column Info
	 * @return mssUsdFmNm
	 */
	public String getMssUsdFmNm() {
		return this.mssUsdFmNm;
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
	 * @return lftChgRtAmt
	 */
	public String getLftChgRtAmt() {
		return this.lftChgRtAmt;
	}

	/**
	 * Column Info
	 * @return pdChgRtAmt
	 */
	public String getPdChgRtAmt() {
		return this.pdChgRtAmt;
	}

	/**
	 * Column Info
	 * @return n3rdRefOfcCd
	 */
	public String getN3rdRefOfcCd() {
		return this.n3rdRefOfcCd;
	}

	/**
	 * Column Info
	 * @return aproAgmtNo
	 */
	public String getAproAgmtNo() {
		return this.aproAgmtNo;
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
	 * @return aproAgmtSeq
	 */
	public String getAproAgmtSeq() {
		return this.aproAgmtSeq;
	}

	/**
	 * Column Info
	 * @return mssUsePlcNm
	 */
	public String getMssUsePlcNm() {
		return this.mssUsePlcNm;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return n1stRefOfcCd
	 */
	public String getN1stRefOfcCd() {
		return this.n1stRefOfcCd;
	}

	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}

	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}

	/**
	 * Column Info
	 * @return aproNo
	 */
	public String getAproNo() {
		return this.aproNo;
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
	 * @return refOfcCd
	 */
	public String getRefOfcCd() {
		return this.refOfcCd;
	}

	/**
	 * Column Info
	 * @return mssUsdAproModCd
	 */
	public String getMssUsdAproModCd() {
		return this.mssUsdAproModCd;
	}

	/**
	 * Column Info
	 * @return mssUsdDt
	 */
	public String getMssUsdDt() {
		return this.mssUsdDt;
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
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
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
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}

	/**
	 * Column Info
	 * @return n4thRefOfcCd
	 */
	public String getN4thRefOfcCd() {
		return this.n4thRefOfcCd;
	}


	/**
	 * Column Info
	 * @param mssRqstIoModCd
	 */
	public void setMssRqstIoModCd(String mssRqstIoModCd) {
		this.mssRqstIoModCd = mssRqstIoModCd;
	}

	/**
	 * Column Info
	 * @param liborPtyNm
	 */
	public void setLiborPtyNm(String liborPtyNm) {
		this.liborPtyNm = liborPtyNm;
	}

	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}

	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
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
	 * @param aproAgmtCtyCd
	 */
	public void setAproAgmtCtyCd(String aproAgmtCtyCd) {
		this.aproAgmtCtyCd = aproAgmtCtyCd;
	}

	/**
	 * Column Info
	 * @param rqstLocCd
	 */
	public void setRqstLocCd(String rqstLocCd) {
		this.rqstLocCd = rqstLocCd;
	}

	/**
	 * Column Info
	 * @param n2ndRefOfcCd
	 */
	public void setN2ndRefOfcCd(String n2ndRefOfcCd) {
		this.n2ndRefOfcCd = n2ndRefOfcCd;
	}

	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}

	/**
	 * Column Info
	 * @param mssUsdFmNm
	 */
	public void setMssUsdFmNm(String mssUsdFmNm) {
		this.mssUsdFmNm = mssUsdFmNm;
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
	 * @param lftChgRtAmt
	 */
	public void setLftChgRtAmt(String lftChgRtAmt) {
		this.lftChgRtAmt = lftChgRtAmt;
	}

	/**
	 * Column Info
	 * @param pdChgRtAmt
	 */
	public void setPdChgRtAmt(String pdChgRtAmt) {
		this.pdChgRtAmt = pdChgRtAmt;
	}

	/**
	 * Column Info
	 * @param n3rdRefOfcCd
	 */
	public void setN3rdRefOfcCd(String n3rdRefOfcCd) {
		this.n3rdRefOfcCd = n3rdRefOfcCd;
	}

	/**
	 * Column Info
	 * @param aproAgmtNo
	 */
	public void setAproAgmtNo(String aproAgmtNo) {
		this.aproAgmtNo = aproAgmtNo;
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
	 * @param aproAgmtSeq
	 */
	public void setAproAgmtSeq(String aproAgmtSeq) {
		this.aproAgmtSeq = aproAgmtSeq;
	}

	/**
	 * Column Info
	 * @param mssUsePlcNm
	 */
	public void setMssUsePlcNm(String mssUsePlcNm) {
		this.mssUsePlcNm = mssUsePlcNm;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param n1stRefOfcCd
	 */
	public void setN1stRefOfcCd(String n1stRefOfcCd) {
		this.n1stRefOfcCd = n1stRefOfcCd;
	}

	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}

	/**
	 * Column Info
	 * @param aproNo
	 */
	public void setAproNo(String aproNo) {
		this.aproNo = aproNo;
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
	 * @param refOfcCd
	 */
	public void setRefOfcCd(String refOfcCd) {
		this.refOfcCd = refOfcCd;
	}

	/**
	 * Column Info
	 * @param mssUsdAproModCd
	 */
	public void setMssUsdAproModCd(String mssUsdAproModCd) {
		this.mssUsdAproModCd = mssUsdAproModCd;
	}

	/**
	 * Column Info
	 * @param mssUsdDt
	 */
	public void setMssUsdDt(String mssUsdDt) {
		this.mssUsdDt = mssUsdDt;
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
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
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
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}

	/**
	 * Column Info
	 * @param n4thRefOfcCd
	 */
	public void setN4thRefOfcCd(String n4thRefOfcCd) {
		this.n4thRefOfcCd = n4thRefOfcCd;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the rqstLocNm
	 */
	public String getRqstLocNm() {
		return rqstLocNm;
	}

	/**
	 * @param rqstLocNm the rqstLocNm to set
	 */
	public void setRqstLocNm(String rqstLocNm) {
		this.rqstLocNm = rqstLocNm;
	}

	/**
	 * @return the rqstFileSavId
	 */
	public String getRqstFileSavId() {
		return rqstFileSavId;
	}

	/**
	 * @param rqstFileSavId the rqstFileSavId to set
	 */
	public void setRqstFileSavId(String rqstFileSavId) {
		this.rqstFileSavId = rqstFileSavId;
	}

	/**
	 * @return the rqstFileSavNm
	 */
	public String getRqstFileSavNm() {
		return rqstFileSavNm;
	}

	/**
	 * @param rqstFileSavNm the rqstFileSavNm to set
	 */
	public void setRqstFileSavNm(String rqstFileSavNm) {
		this.rqstFileSavNm = rqstFileSavNm;
	}

	/**
	 * @return the rqstRsnDesc
	 */
	public String getRqstRsnDesc() {
		return rqstRsnDesc;
	}

	/**
	 * @param rqstRsnDesc the rqstRsnDesc to set
	 */
	public void setRqstRsnDesc(String rqstRsnDesc) {
		this.rqstRsnDesc = rqstRsnDesc;
	}

	/**
	 * @return the aproFileSavId
	 */
	public String getAproFileSavId() {
		return aproFileSavId;
	}

	/**
	 * @param aproFileSavId the aproFileSavId to set
	 */
	public void setAproFileSavId(String aproFileSavId) {
		this.aproFileSavId = aproFileSavId;
	}

	/**
	 * @return the aproFileSavNm
	 */
	public String getAproFileSavNm() {
		return aproFileSavNm;
	}

	/**
	 * @param aproFileSavNm the aproFileSavNm to set
	 */
	public void setAproFileSavNm(String aproFileSavNm) {
		this.aproFileSavNm = aproFileSavNm;
	}

	/**
	 * @return the aproRsnDesc
	 */
	public String getAproRsnDesc() {
		return aproRsnDesc;
	}

	/**
	 * @param aproRsnDesc the aproRsnDesc to set
	 */
	public void setAproRsnDesc(String aproRsnDesc) {
		this.aproRsnDesc = aproRsnDesc;
	}

	/**
	 * @return the cxlFileSavId
	 */
	public String getCxlFileSavId() {
		return cxlFileSavId;
	}

	/**
	 * @param cxlFileSavId the cxlFileSavId to set
	 */
	public void setCxlFileSavId(String cxlFileSavId) {
		this.cxlFileSavId = cxlFileSavId;
	}

	/**
	 * @return the cxlFileSavNm
	 */
	public String getCxlFileSavNm() {
		return cxlFileSavNm;
	}

	/**
	 * @param cxlFileSavNm the cxlFileSavNm to set
	 */
	public void setCxlFileSavNm(String cxlFileSavNm) {
		this.cxlFileSavNm = cxlFileSavNm;
	}

	/**
	 * @return the cxlRsnDesc
	 */
	public String getCxlRsnDesc() {
		return cxlRsnDesc;
	}

	/**
	 * @param cxlRsnDesc the cxlRsnDesc to set
	 */
	public void setCxlRsnDesc(String cxlRsnDesc) {
		this.cxlRsnDesc = cxlRsnDesc;
	}

	/**
	 * @return the mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return mvmtStsCd;
	}

	/**
	 * @param mvmtStsCd the mvmtStsCd to set
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMssRqstIoModCd(JSPUtil.getParameter(request, "mss_rqst_io_mod_cd", ""));
		setLiborPtyNm(JSPUtil.getParameter(request, "libor_pty_nm", ""));
		setRqstUsrId(JSPUtil.getParameter(request, "rqst_usr_id", ""));
		setRqstNo(JSPUtil.getParameter(request, "rqst_no", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setAproAgmtCtyCd(JSPUtil.getParameter(request, "apro_agmt_cty_cd", ""));
		setRqstLocCd(JSPUtil.getParameter(request, "rqst_loc_cd", ""));
		setRqstLocNm(JSPUtil.getParameter(request, "rqst_loc_nm", ""));
		setN2ndRefOfcCd(JSPUtil.getParameter(request, "n2nd_ref_ofc_cd", ""));
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setMssUsdFmNm(JSPUtil.getParameter(request, "mss_usd_fm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLftChgRtAmt(JSPUtil.getParameter(request, "lft_chg_rt_amt", ""));
		setPdChgRtAmt(JSPUtil.getParameter(request, "pd_chg_rt_amt", ""));
		setN3rdRefOfcCd(JSPUtil.getParameter(request, "n3rd_ref_ofc_cd", ""));
		setAproAgmtNo(JSPUtil.getParameter(request, "apro_agmt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAproAgmtSeq(JSPUtil.getParameter(request, "apro_agmt_seq", ""));
		setMssUsePlcNm(JSPUtil.getParameter(request, "mss_use_plc_nm", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setN1stRefOfcCd(JSPUtil.getParameter(request, "n1st_ref_ofc_cd", ""));
		setAproRmk(JSPUtil.getParameter(request, "apro_rmk", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setAproNo(JSPUtil.getParameter(request, "apro_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setRefOfcCd(JSPUtil.getParameter(request, "ref_ofc_cd", ""));
		setMssUsdAproModCd(JSPUtil.getParameter(request, "mss_usd_apro_mod_cd", ""));
		setMssUsdDt(JSPUtil.getParameter(request, "mss_usd_dt", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setAproUsrId(JSPUtil.getParameter(request, "apro_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setN4thRefOfcCd(JSPUtil.getParameter(request, "n4th_ref_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRqstFileSavId(JSPUtil.getParameter(request, "rqst_file_sav_id", ""));
		setRqstFileSavNm(JSPUtil.getParameter(request, "rqst_file_sav_nm", ""));
		setRqstRsnDesc(JSPUtil.getParameter(request, "rqst_rsn_desc", ""));
		setAproFileSavId(JSPUtil.getParameter(request, "apro_file_sav_id", ""));
		setAproFileSavNm(JSPUtil.getParameter(request, "apro_file_sav_nm", ""));
		setAproRsnDesc(JSPUtil.getParameter(request, "apro_rsn_desc", ""));
		setCxlFileSavId(JSPUtil.getParameter(request, "cxl_file_sav_id", ""));
		setCxlFileSavNm(JSPUtil.getParameter(request, "cxl_file_sav_nm", ""));
		setCxlRsnDesc(JSPUtil.getParameter(request, "cxl_rsn_desc", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MisUseInOutInquiryVO[]
	 */
	public MisUseInOutInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MisUseInOutInquiryVO[]
	 */
	public MisUseInOutInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MisUseInOutInquiryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] mssRqstIoModCd = (JSPUtil.getParameter(request, prefix	+ "mss_rqst_io_mod_cd", length));
			String[] liborPtyNm = (JSPUtil.getParameter(request, prefix	+ "libor_pty_nm", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] aproAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "apro_agmt_cty_cd", length));
			String[] rqstLocCd = (JSPUtil.getParameter(request, prefix	+ "rqst_loc_cd", length));
			String[] rqstLocNm = (JSPUtil.getParameter(request, prefix	+ "rqst_loc_nm", length));
			String[] n2ndRefOfcCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ref_ofc_cd", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] mssUsdFmNm = (JSPUtil.getParameter(request, prefix	+ "mss_usd_fm_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lftChgRtAmt = (JSPUtil.getParameter(request, prefix	+ "lft_chg_rt_amt", length));
			String[] pdChgRtAmt = (JSPUtil.getParameter(request, prefix	+ "pd_chg_rt_amt", length));
			String[] n3rdRefOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_ref_ofc_cd", length));
			String[] aproAgmtNo = (JSPUtil.getParameter(request, prefix	+ "apro_agmt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "apro_agmt_seq", length));
			String[] mssUsePlcNm = (JSPUtil.getParameter(request, prefix	+ "mss_use_plc_nm", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] n1stRefOfcCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ref_ofc_cd", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] refOfcCd = (JSPUtil.getParameter(request, prefix	+ "ref_ofc_cd", length));
			String[] mssUsdAproModCd = (JSPUtil.getParameter(request, prefix	+ "mss_usd_apro_mod_cd", length));
			String[] mssUsdDt = (JSPUtil.getParameter(request, prefix	+ "mss_usd_dt", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] n4thRefOfcCd = (JSPUtil.getParameter(request, prefix	+ "n4th_ref_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rqstFileSavId = (JSPUtil.getParameter(request, prefix	+ "rqst_file_sav_id", length));
			String[] rqstFileSavNm = (JSPUtil.getParameter(request, prefix	+ "rqst_file_sav_nm", length));
			String[] rqstRsnDesc = (JSPUtil.getParameter(request, prefix	+ "rqst_rsn_desc", length));
			String[] aproFileSavId = (JSPUtil.getParameter(request, prefix	+ "apro_file_sav_id", length));
			String[] aproFileSavNm = (JSPUtil.getParameter(request, prefix	+ "apro_rsn_desc", length));
			String[] aproRsnDesc = (JSPUtil.getParameter(request, prefix	+ "apro_rsn_desc", length));
			String[] cxlFileSavId = (JSPUtil.getParameter(request, prefix	+ "cxl_file_sav_id", length));
			String[] cxlFileSavNm = (JSPUtil.getParameter(request, prefix	+ "cxl_file_sav_nm", length));
			String[] cxlRsnDesc = (JSPUtil.getParameter(request, prefix	+ "cxl_rsn_desc", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));

			for (int i = 0; i < length; i++) {
				model = new MisUseInOutInquiryVO();
				if (mssRqstIoModCd[i] != null)
					model.setMssRqstIoModCd(mssRqstIoModCd[i]);
				if (liborPtyNm[i] != null)
					model.setLiborPtyNm(liborPtyNm[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (aproAgmtCtyCd[i] != null)
					model.setAproAgmtCtyCd(aproAgmtCtyCd[i]);
				if (rqstLocCd[i] != null)
					model.setRqstLocCd(rqstLocCd[i]);
				if (rqstLocNm[i] != null)
					model.setRqstLocNm(rqstLocNm[i]);
				if (n2ndRefOfcCd[i] != null)
					model.setN2ndRefOfcCd(n2ndRefOfcCd[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (mssUsdFmNm[i] != null)
					model.setMssUsdFmNm(mssUsdFmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lftChgRtAmt[i] != null)
					model.setLftChgRtAmt(lftChgRtAmt[i]);
				if (pdChgRtAmt[i] != null)
					model.setPdChgRtAmt(pdChgRtAmt[i]);
				if (n3rdRefOfcCd[i] != null)
					model.setN3rdRefOfcCd(n3rdRefOfcCd[i]);
				if (aproAgmtNo[i] != null)
					model.setAproAgmtNo(aproAgmtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproAgmtSeq[i] != null)
					model.setAproAgmtSeq(aproAgmtSeq[i]);
				if (mssUsePlcNm[i] != null)
					model.setMssUsePlcNm(mssUsePlcNm[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (n1stRefOfcCd[i] != null)
					model.setN1stRefOfcCd(n1stRefOfcCd[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (refOfcCd[i] != null)
					model.setRefOfcCd(refOfcCd[i]);
				if (mssUsdAproModCd[i] != null)
					model.setMssUsdAproModCd(mssUsdAproModCd[i]);
				if (mssUsdDt[i] != null)
					model.setMssUsdDt(mssUsdDt[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (n4thRefOfcCd[i] != null)
					model.setN4thRefOfcCd(n4thRefOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rqstFileSavId[i] != null)
					model.setRqstFileSavId(rqstFileSavId[i]);
				if (rqstFileSavNm[i] != null)
					model.setRqstFileSavNm(rqstFileSavNm[i]);
				if (rqstRsnDesc[i] != null)
					model.setRqstRsnDesc(rqstRsnDesc[i]);
				if (aproFileSavId[i] != null)
					model.setAproFileSavId(aproFileSavId[i]);
				if (aproFileSavNm[i] != null)
					model.setAproFileSavNm(aproFileSavNm[i]);
				if (aproRsnDesc[i] != null)
					model.setAproRsnDesc(aproRsnDesc[i]);
				if (cxlFileSavId[i] != null)
					model.setCxlFileSavId(cxlFileSavId[i]);
				if (cxlFileSavNm[i] != null)
					model.setCxlFileSavNm(cxlFileSavNm[i]);
				if (cxlRsnDesc[i] != null)
					model.setCxlRsnDesc(cxlRsnDesc[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMisUseInOutInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MisUseInOutInquiryVO[]
	 */
	public MisUseInOutInquiryVO[] getMisUseInOutInquiryListVOs(){
		MisUseInOutInquiryVO[] vos = (MisUseInOutInquiryVO[])models.toArray(new MisUseInOutInquiryVO[models.size()]);
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
		this.mssRqstIoModCd = this.mssRqstIoModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liborPtyNm = this.liborPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproAgmtCtyCd = this.aproAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstLocCd = this.rqstLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstLocNm = this.rqstLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRefOfcCd = this.n2ndRefOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsdFmNm = this.mssUsdFmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lftChgRtAmt = this.lftChgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdChgRtAmt = this.pdChgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRefOfcCd = this.n3rdRefOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproAgmtNo = this.aproAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproAgmtSeq = this.aproAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsePlcNm = this.mssUsePlcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stRefOfcCd = this.n1stRefOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refOfcCd = this.refOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsdAproModCd = this.mssUsdAproModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsdDt = this.mssUsdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thRefOfcCd = this.n4thRefOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFileSavId = this.rqstFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFileSavNm = this.rqstFileSavNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRsnDesc = this.rqstRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFileSavId = this.aproFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFileSavNm = this.aproFileSavNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRsnDesc = this.aproRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFileSavId = this.cxlFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFileSavNm = this.cxlFileSavNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRsnDesc = this.cxlRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
