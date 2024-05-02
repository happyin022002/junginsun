/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPropMnInqVO.java
*@FileTitle : RsltPropMnInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.06 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPropMnInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropMnInqVO> models = new ArrayList<RsltPropMnInqVO>();
	
	/* Column Info */
	private String propAproDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String realCustValSgm = null;
	/* Column Info */
	private String prsCrntCmAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcCtrtPtyTpCd = null;
	/* Column Info */
	private String propSrepNm = null;
	/* Column Info */
	private String scNo1 = null;
	/* Column Info */
	private String otiAmt = null;
	/* Column Info */
	private String scNo2 = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String ctrtCustSrepNm = null;
	/* Column Info */
	private String prsEstmCmAmt = null;
	/* Column Info */
	private String slsLdNo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String realCustNm = null;
	/* Column Info */
	private String propMqcQty = null;
	/* Column Info */
	private String realCustSrepNm = null;
	/* Column Info */
	private String gamtFlg = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String realCustTpCd = null;
	/* Column Info */
	private String realCustSrepCd = null;
	/* Column Info */
	private String ctrtPtySgnNm = null;
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String realCustValSgmCd = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String realCustCntCd = null;
	/* Column Info */
	private String otiEffDt = null;
	/* Column Info */
	private String ctrtPtySgnTitNm = null;
	/* Column Info */
	private String otiExpDt = null;
	/* Column Info */
	private String propSts = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtCustSlsOfcCd = null;
	/* Column Info */
	private String otiNo = null;
	/* Column Info */
	private String ctrtCustValSgm = null;
	/* Column Info */
	private String ctrtPtyAddr = null;
	/* Column Info */
	private String realCustSeq = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String realCustSlsOfcCd = null;
	/* Column Info */
	private String cntrLodUtCd = null;
	/* Column Info */
	private String blplHdrSeq = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String propAproStaff = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String prcMstPropTpCd = null;
	/* Column Info */
	private String ctrtCustValSgmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPropMnInqVO() {}

	public RsltPropMnInqVO(String ibflag, String pagerows, String scNo1, String scNo2, String prcMstPropTpCd, String propNo, String amdtSeq, String ctrtEffDt, String ctrtExpDt, String rfFlg, String gamtFlg, String propStsCd, String propSts, String propOfcCd, String propSrepCd, String propSrepNm, String propAproOfcCd, String propAproDt, String creDt, String fileDt, String custCntCd, String custSeq, String ctrtPtyNm, String ctrtCustValSgmCd, String ctrtCustValSgm, String prcCtrtCustTpCd, String ctrtCustSlsOfcCd, String ctrtCustSrepCd, String propAproStaff, String ctrtCustSrepNm, String realCustCntCd, String realCustSeq, String realCustNm, String realCustValSgmCd, String realCustValSgm, String realCustTpCd, String realCustSlsOfcCd, String realCustSrepCd, String realCustSrepNm, String propMqcQty, String cntrLodUtCd, String unit, String slsLdNo, String blplHdrSeq, String prcCtrtPtyTpCd, String ctrtPtyAddr, String ctrtPtySgnNm, String ctrtPtySgnTitNm, String otiNo, String otiEffDt, String otiExpDt, String otiAmt, String prsCrntCmAmt, String prsEstmCmAmt) {
		this.propAproDt = propAproDt;
		this.amdtSeq = amdtSeq;
		this.realCustValSgm = realCustValSgm;
		this.prsCrntCmAmt = prsCrntCmAmt;
		this.pagerows = pagerows;
		this.prcCtrtPtyTpCd = prcCtrtPtyTpCd;
		this.propSrepNm = propSrepNm;
		this.scNo1 = scNo1;
		this.otiAmt = otiAmt;
		this.scNo2 = scNo2;
		this.propStsCd = propStsCd;
		this.ctrtCustSrepNm = ctrtCustSrepNm;
		this.prsEstmCmAmt = prsEstmCmAmt;
		this.slsLdNo = slsLdNo;
		this.custCntCd = custCntCd;
		this.fileDt = fileDt;
		this.realCustNm = realCustNm;
		this.propMqcQty = propMqcQty;
		this.realCustSrepNm = realCustSrepNm;
		this.gamtFlg = gamtFlg;
		this.ctrtPtyNm = ctrtPtyNm;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.realCustTpCd = realCustTpCd;
		this.realCustSrepCd = realCustSrepCd;
		this.ctrtPtySgnNm = ctrtPtySgnNm;
		this.rfFlg = rfFlg;
		this.realCustValSgmCd = realCustValSgmCd;
		this.ctrtEffDt = ctrtEffDt;
		this.creDt = creDt;
		this.realCustCntCd = realCustCntCd;
		this.otiEffDt = otiEffDt;
		this.ctrtPtySgnTitNm = ctrtPtySgnTitNm;
		this.otiExpDt = otiExpDt;
		this.propSts = propSts;
		this.ibflag = ibflag;
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
		this.otiNo = otiNo;
		this.ctrtCustValSgm = ctrtCustValSgm;
		this.ctrtPtyAddr = ctrtPtyAddr;
		this.realCustSeq = realCustSeq;
		this.ctrtExpDt = ctrtExpDt;
		this.propSrepCd = propSrepCd;
		this.custSeq = custSeq;
		this.realCustSlsOfcCd = realCustSlsOfcCd;
		this.cntrLodUtCd = cntrLodUtCd;
		this.blplHdrSeq = blplHdrSeq;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.unit = unit;
		this.propNo = propNo;
		this.propAproStaff = propAproStaff;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.prcMstPropTpCd = prcMstPropTpCd;
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prop_apro_dt", getPropAproDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("real_cust_val_sgm", getRealCustValSgm());
		this.hashColumns.put("prs_crnt_cm_amt", getPrsCrntCmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_ctrt_pty_tp_cd", getPrcCtrtPtyTpCd());
		this.hashColumns.put("prop_srep_nm", getPropSrepNm());
		this.hashColumns.put("sc_no1", getScNo1());
		this.hashColumns.put("oti_amt", getOtiAmt());
		this.hashColumns.put("sc_no2", getScNo2());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("ctrt_cust_srep_nm", getCtrtCustSrepNm());
		this.hashColumns.put("prs_estm_cm_amt", getPrsEstmCmAmt());
		this.hashColumns.put("sls_ld_no", getSlsLdNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("real_cust_nm", getRealCustNm());
		this.hashColumns.put("prop_mqc_qty", getPropMqcQty());
		this.hashColumns.put("real_cust_srep_nm", getRealCustSrepNm());
		this.hashColumns.put("gamt_flg", getGamtFlg());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("real_cust_tp_cd", getRealCustTpCd());
		this.hashColumns.put("real_cust_srep_cd", getRealCustSrepCd());
		this.hashColumns.put("ctrt_pty_sgn_nm", getCtrtPtySgnNm());
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("real_cust_val_sgm_cd", getRealCustValSgmCd());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("real_cust_cnt_cd", getRealCustCntCd());
		this.hashColumns.put("oti_eff_dt", getOtiEffDt());
		this.hashColumns.put("ctrt_pty_sgn_tit_nm", getCtrtPtySgnTitNm());
		this.hashColumns.put("oti_exp_dt", getOtiExpDt());
		this.hashColumns.put("prop_sts", getPropSts());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_cust_sls_ofc_cd", getCtrtCustSlsOfcCd());
		this.hashColumns.put("oti_no", getOtiNo());
		this.hashColumns.put("ctrt_cust_val_sgm", getCtrtCustValSgm());
		this.hashColumns.put("ctrt_pty_addr", getCtrtPtyAddr());
		this.hashColumns.put("real_cust_seq", getRealCustSeq());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("real_cust_sls_ofc_cd", getRealCustSlsOfcCd());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("blpl_hdr_seq", getBlplHdrSeq());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prop_apro_staff", getPropAproStaff());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("prc_mst_prop_tp_cd", getPrcMstPropTpCd());
		this.hashColumns.put("ctrt_cust_val_sgm_cd", getCtrtCustValSgmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prop_apro_dt", "propAproDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("real_cust_val_sgm", "realCustValSgm");
		this.hashFields.put("prs_crnt_cm_amt", "prsCrntCmAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_ctrt_pty_tp_cd", "prcCtrtPtyTpCd");
		this.hashFields.put("prop_srep_nm", "propSrepNm");
		this.hashFields.put("sc_no1", "scNo1");
		this.hashFields.put("oti_amt", "otiAmt");
		this.hashFields.put("sc_no2", "scNo2");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("ctrt_cust_srep_nm", "ctrtCustSrepNm");
		this.hashFields.put("prs_estm_cm_amt", "prsEstmCmAmt");
		this.hashFields.put("sls_ld_no", "slsLdNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("real_cust_nm", "realCustNm");
		this.hashFields.put("prop_mqc_qty", "propMqcQty");
		this.hashFields.put("real_cust_srep_nm", "realCustSrepNm");
		this.hashFields.put("gamt_flg", "gamtFlg");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("real_cust_tp_cd", "realCustTpCd");
		this.hashFields.put("real_cust_srep_cd", "realCustSrepCd");
		this.hashFields.put("ctrt_pty_sgn_nm", "ctrtPtySgnNm");
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("real_cust_val_sgm_cd", "realCustValSgmCd");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("real_cust_cnt_cd", "realCustCntCd");
		this.hashFields.put("oti_eff_dt", "otiEffDt");
		this.hashFields.put("ctrt_pty_sgn_tit_nm", "ctrtPtySgnTitNm");
		this.hashFields.put("oti_exp_dt", "otiExpDt");
		this.hashFields.put("prop_sts", "propSts");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_cust_sls_ofc_cd", "ctrtCustSlsOfcCd");
		this.hashFields.put("oti_no", "otiNo");
		this.hashFields.put("ctrt_cust_val_sgm", "ctrtCustValSgm");
		this.hashFields.put("ctrt_pty_addr", "ctrtPtyAddr");
		this.hashFields.put("real_cust_seq", "realCustSeq");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("real_cust_sls_ofc_cd", "realCustSlsOfcCd");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("blpl_hdr_seq", "blplHdrSeq");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prop_apro_staff", "propAproStaff");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("prc_mst_prop_tp_cd", "prcMstPropTpCd");
		this.hashFields.put("ctrt_cust_val_sgm_cd", "ctrtCustValSgmCd");
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return realCustValSgm
	 */
	public String getRealCustValSgm() {
		return this.realCustValSgm;
	}
	
	/**
	 * Column Info
	 * @return prsCrntCmAmt
	 */
	public String getPrsCrntCmAmt() {
		return this.prsCrntCmAmt;
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
	 * @return prcCtrtPtyTpCd
	 */
	public String getPrcCtrtPtyTpCd() {
		return this.prcCtrtPtyTpCd;
	}
	
	/**
	 * Column Info
	 * @return propSrepNm
	 */
	public String getPropSrepNm() {
		return this.propSrepNm;
	}
	
	/**
	 * Column Info
	 * @return scNo1
	 */
	public String getScNo1() {
		return this.scNo1;
	}
	
	/**
	 * Column Info
	 * @return otiAmt
	 */
	public String getOtiAmt() {
		return this.otiAmt;
	}
	
	/**
	 * Column Info
	 * @return scNo2
	 */
	public String getScNo2() {
		return this.scNo2;
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
	 * @return ctrtCustSrepNm
	 */
	public String getCtrtCustSrepNm() {
		return this.ctrtCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @return prsEstmCmAmt
	 */
	public String getPrsEstmCmAmt() {
		return this.prsEstmCmAmt;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return realCustNm
	 */
	public String getRealCustNm() {
		return this.realCustNm;
	}
	
	/**
	 * Column Info
	 * @return propMqcQty
	 */
	public String getPropMqcQty() {
		return this.propMqcQty;
	}
	
	/**
	 * Column Info
	 * @return realCustSrepNm
	 */
	public String getRealCustSrepNm() {
		return this.realCustSrepNm;
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
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
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
	 * @return ctrtPtySgnNm
	 */
	public String getCtrtPtySgnNm() {
		return this.ctrtPtySgnNm;
	}
	
	/**
	 * Column Info
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
	}
	
	/**
	 * Column Info
	 * @return realCustValSgmCd
	 */
	public String getRealCustValSgmCd() {
		return this.realCustValSgmCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
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
	 * Column Info
	 * @return otiEffDt
	 */
	public String getOtiEffDt() {
		return this.otiEffDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtySgnTitNm
	 */
	public String getCtrtPtySgnTitNm() {
		return this.ctrtPtySgnTitNm;
	}
	
	/**
	 * Column Info
	 * @return otiExpDt
	 */
	public String getOtiExpDt() {
		return this.otiExpDt;
	}
	
	/**
	 * Column Info
	 * @return propSts
	 */
	public String getPropSts() {
		return this.propSts;
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
	 * @return ctrtCustSlsOfcCd
	 */
	public String getCtrtCustSlsOfcCd() {
		return this.ctrtCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return otiNo
	 */
	public String getOtiNo() {
		return this.otiNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustValSgm
	 */
	public String getCtrtCustValSgm() {
		return this.ctrtCustValSgm;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyAddr
	 */
	public String getCtrtPtyAddr() {
		return this.ctrtPtyAddr;
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
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return cntrLodUtCd
	 */
	public String getCntrLodUtCd() {
		return this.cntrLodUtCd;
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
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
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
	 * @return propAproStaff
	 */
	public String getPropAproStaff() {
		return this.propAproStaff;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return prcMstPropTpCd
	 */
	public String getPrcMstPropTpCd() {
		return this.prcMstPropTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustValSgmCd
	 */
	public String getCtrtCustValSgmCd() {
		return this.ctrtCustValSgmCd;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param realCustValSgm
	 */
	public void setRealCustValSgm(String realCustValSgm) {
		this.realCustValSgm = realCustValSgm;
	}
	
	/**
	 * Column Info
	 * @param prsCrntCmAmt
	 */
	public void setPrsCrntCmAmt(String prsCrntCmAmt) {
		this.prsCrntCmAmt = prsCrntCmAmt;
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
	 * @param prcCtrtPtyTpCd
	 */
	public void setPrcCtrtPtyTpCd(String prcCtrtPtyTpCd) {
		this.prcCtrtPtyTpCd = prcCtrtPtyTpCd;
	}
	
	/**
	 * Column Info
	 * @param propSrepNm
	 */
	public void setPropSrepNm(String propSrepNm) {
		this.propSrepNm = propSrepNm;
	}
	
	/**
	 * Column Info
	 * @param scNo1
	 */
	public void setScNo1(String scNo1) {
		this.scNo1 = scNo1;
	}
	
	/**
	 * Column Info
	 * @param otiAmt
	 */
	public void setOtiAmt(String otiAmt) {
		this.otiAmt = otiAmt;
	}
	
	/**
	 * Column Info
	 * @param scNo2
	 */
	public void setScNo2(String scNo2) {
		this.scNo2 = scNo2;
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
	 * @param ctrtCustSrepNm
	 */
	public void setCtrtCustSrepNm(String ctrtCustSrepNm) {
		this.ctrtCustSrepNm = ctrtCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @param prsEstmCmAmt
	 */
	public void setPrsEstmCmAmt(String prsEstmCmAmt) {
		this.prsEstmCmAmt = prsEstmCmAmt;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param realCustNm
	 */
	public void setRealCustNm(String realCustNm) {
		this.realCustNm = realCustNm;
	}
	
	/**
	 * Column Info
	 * @param propMqcQty
	 */
	public void setPropMqcQty(String propMqcQty) {
		this.propMqcQty = propMqcQty;
	}
	
	/**
	 * Column Info
	 * @param realCustSrepNm
	 */
	public void setRealCustSrepNm(String realCustSrepNm) {
		this.realCustSrepNm = realCustSrepNm;
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
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
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
	 * Column Info
	 * @param ctrtPtySgnNm
	 */
	public void setCtrtPtySgnNm(String ctrtPtySgnNm) {
		this.ctrtPtySgnNm = ctrtPtySgnNm;
	}
	
	/**
	 * Column Info
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
	}
	
	/**
	 * Column Info
	 * @param realCustValSgmCd
	 */
	public void setRealCustValSgmCd(String realCustValSgmCd) {
		this.realCustValSgmCd = realCustValSgmCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
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
	 * Column Info
	 * @param otiEffDt
	 */
	public void setOtiEffDt(String otiEffDt) {
		this.otiEffDt = otiEffDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtySgnTitNm
	 */
	public void setCtrtPtySgnTitNm(String ctrtPtySgnTitNm) {
		this.ctrtPtySgnTitNm = ctrtPtySgnTitNm;
	}
	
	/**
	 * Column Info
	 * @param otiExpDt
	 */
	public void setOtiExpDt(String otiExpDt) {
		this.otiExpDt = otiExpDt;
	}
	
	/**
	 * Column Info
	 * @param propSts
	 */
	public void setPropSts(String propSts) {
		this.propSts = propSts;
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
	 * @param ctrtCustSlsOfcCd
	 */
	public void setCtrtCustSlsOfcCd(String ctrtCustSlsOfcCd) {
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param otiNo
	 */
	public void setOtiNo(String otiNo) {
		this.otiNo = otiNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustValSgm
	 */
	public void setCtrtCustValSgm(String ctrtCustValSgm) {
		this.ctrtCustValSgm = ctrtCustValSgm;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyAddr
	 */
	public void setCtrtPtyAddr(String ctrtPtyAddr) {
		this.ctrtPtyAddr = ctrtPtyAddr;
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
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param cntrLodUtCd
	 */
	public void setCntrLodUtCd(String cntrLodUtCd) {
		this.cntrLodUtCd = cntrLodUtCd;
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
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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
	 * @param propAproStaff
	 */
	public void setPropAproStaff(String propAproStaff) {
		this.propAproStaff = propAproStaff;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param prcMstPropTpCd
	 */
	public void setPrcMstPropTpCd(String prcMstPropTpCd) {
		this.prcMstPropTpCd = prcMstPropTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustValSgmCd
	 */
	public void setCtrtCustValSgmCd(String ctrtCustValSgmCd) {
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPropAproDt(JSPUtil.getParameter(request, "prop_apro_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setRealCustValSgm(JSPUtil.getParameter(request, "real_cust_val_sgm", ""));
		setPrsCrntCmAmt(JSPUtil.getParameter(request, "prs_crnt_cm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcCtrtPtyTpCd(JSPUtil.getParameter(request, "prc_ctrt_pty_tp_cd", ""));
		setPropSrepNm(JSPUtil.getParameter(request, "prop_srep_nm", ""));
		setScNo1(JSPUtil.getParameter(request, "sc_no1", ""));
		setOtiAmt(JSPUtil.getParameter(request, "oti_amt", ""));
		setScNo2(JSPUtil.getParameter(request, "sc_no2", ""));
		setPropStsCd(JSPUtil.getParameter(request, "prop_sts_cd", ""));
		setCtrtCustSrepNm(JSPUtil.getParameter(request, "ctrt_cust_srep_nm", ""));
		setPrsEstmCmAmt(JSPUtil.getParameter(request, "prs_estm_cm_amt", ""));
		setSlsLdNo(JSPUtil.getParameter(request, "sls_ld_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setFileDt(JSPUtil.getParameter(request, "file_dt", ""));
		setRealCustNm(JSPUtil.getParameter(request, "real_cust_nm", ""));
		setPropMqcQty(JSPUtil.getParameter(request, "prop_mqc_qty", ""));
		setRealCustSrepNm(JSPUtil.getParameter(request, "real_cust_srep_nm", ""));
		setGamtFlg(JSPUtil.getParameter(request, "gamt_flg", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, "prop_apro_ofc_cd", ""));
		setRealCustTpCd(JSPUtil.getParameter(request, "real_cust_tp_cd", ""));
		setRealCustSrepCd(JSPUtil.getParameter(request, "real_cust_srep_cd", ""));
		setCtrtPtySgnNm(JSPUtil.getParameter(request, "ctrt_pty_sgn_nm", ""));
		setRfFlg(JSPUtil.getParameter(request, "rf_flg", ""));
		setRealCustValSgmCd(JSPUtil.getParameter(request, "real_cust_val_sgm_cd", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, "ctrt_eff_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRealCustCntCd(JSPUtil.getParameter(request, "real_cust_cnt_cd", ""));
		setOtiEffDt(JSPUtil.getParameter(request, "oti_eff_dt", ""));
		setCtrtPtySgnTitNm(JSPUtil.getParameter(request, "ctrt_pty_sgn_tit_nm", ""));
		setOtiExpDt(JSPUtil.getParameter(request, "oti_exp_dt", ""));
		setPropSts(JSPUtil.getParameter(request, "prop_sts", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtCustSlsOfcCd(JSPUtil.getParameter(request, "ctrt_cust_sls_ofc_cd", ""));
		setOtiNo(JSPUtil.getParameter(request, "oti_no", ""));
		setCtrtCustValSgm(JSPUtil.getParameter(request, "ctrt_cust_val_sgm", ""));
		setCtrtPtyAddr(JSPUtil.getParameter(request, "ctrt_pty_addr", ""));
		setRealCustSeq(JSPUtil.getParameter(request, "real_cust_seq", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, "ctrt_exp_dt", ""));
		setPropSrepCd(JSPUtil.getParameter(request, "prop_srep_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setRealCustSlsOfcCd(JSPUtil.getParameter(request, "real_cust_sls_ofc_cd", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request, "cntr_lod_ut_cd", ""));
		setBlplHdrSeq(JSPUtil.getParameter(request, "blpl_hdr_seq", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, "prc_ctrt_cust_tp_cd", ""));
		setUnit(JSPUtil.getParameter(request, "unit", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setPropAproStaff(JSPUtil.getParameter(request, "prop_apro_staff", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, "ctrt_cust_srep_cd", ""));
		setPrcMstPropTpCd(JSPUtil.getParameter(request, "prc_mst_prop_tp_cd", ""));
		setCtrtCustValSgmCd(JSPUtil.getParameter(request, "ctrt_cust_val_sgm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropMnInqVO[]
	 */
	public RsltPropMnInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropMnInqVO[]
	 */
	public RsltPropMnInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropMnInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] propAproDt = (JSPUtil.getParameter(request, prefix	+ "prop_apro_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] realCustValSgm = (JSPUtil.getParameter(request, prefix	+ "real_cust_val_sgm", length));
			String[] prsCrntCmAmt = (JSPUtil.getParameter(request, prefix	+ "prs_crnt_cm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcCtrtPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_pty_tp_cd", length));
			String[] propSrepNm = (JSPUtil.getParameter(request, prefix	+ "prop_srep_nm", length));
			String[] scNo1 = (JSPUtil.getParameter(request, prefix	+ "sc_no1", length));
			String[] otiAmt = (JSPUtil.getParameter(request, prefix	+ "oti_amt", length));
			String[] scNo2 = (JSPUtil.getParameter(request, prefix	+ "sc_no2", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] ctrtCustSrepNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_nm", length));
			String[] prsEstmCmAmt = (JSPUtil.getParameter(request, prefix	+ "prs_estm_cm_amt", length));
			String[] slsLdNo = (JSPUtil.getParameter(request, prefix	+ "sls_ld_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] realCustNm = (JSPUtil.getParameter(request, prefix	+ "real_cust_nm", length));
			String[] propMqcQty = (JSPUtil.getParameter(request, prefix	+ "prop_mqc_qty", length));
			String[] realCustSrepNm = (JSPUtil.getParameter(request, prefix	+ "real_cust_srep_nm", length));
			String[] gamtFlg = (JSPUtil.getParameter(request, prefix	+ "gamt_flg", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] realCustTpCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_tp_cd", length));
			String[] realCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_srep_cd", length));
			String[] ctrtPtySgnNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_sgn_nm", length));
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] realCustValSgmCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_val_sgm_cd", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] realCustCntCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_cnt_cd", length));
			String[] otiEffDt = (JSPUtil.getParameter(request, prefix	+ "oti_eff_dt", length));
			String[] ctrtPtySgnTitNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_sgn_tit_nm", length));
			String[] otiExpDt = (JSPUtil.getParameter(request, prefix	+ "oti_exp_dt", length));
			String[] propSts = (JSPUtil.getParameter(request, prefix	+ "prop_sts", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_sls_ofc_cd", length));
			String[] otiNo = (JSPUtil.getParameter(request, prefix	+ "oti_no", length));
			String[] ctrtCustValSgm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm", length));
			String[] ctrtPtyAddr = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_addr", length));
			String[] realCustSeq = (JSPUtil.getParameter(request, prefix	+ "real_cust_seq", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] realCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_sls_ofc_cd", length));
			String[] cntrLodUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_lod_ut_cd", length));
			String[] blplHdrSeq = (JSPUtil.getParameter(request, prefix	+ "blpl_hdr_seq", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] propAproStaff = (JSPUtil.getParameter(request, prefix	+ "prop_apro_staff", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] prcMstPropTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_mst_prop_tp_cd", length));
			String[] ctrtCustValSgmCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropMnInqVO();
				if (propAproDt[i] != null)
					model.setPropAproDt(propAproDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (realCustValSgm[i] != null)
					model.setRealCustValSgm(realCustValSgm[i]);
				if (prsCrntCmAmt[i] != null)
					model.setPrsCrntCmAmt(prsCrntCmAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcCtrtPtyTpCd[i] != null)
					model.setPrcCtrtPtyTpCd(prcCtrtPtyTpCd[i]);
				if (propSrepNm[i] != null)
					model.setPropSrepNm(propSrepNm[i]);
				if (scNo1[i] != null)
					model.setScNo1(scNo1[i]);
				if (otiAmt[i] != null)
					model.setOtiAmt(otiAmt[i]);
				if (scNo2[i] != null)
					model.setScNo2(scNo2[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (ctrtCustSrepNm[i] != null)
					model.setCtrtCustSrepNm(ctrtCustSrepNm[i]);
				if (prsEstmCmAmt[i] != null)
					model.setPrsEstmCmAmt(prsEstmCmAmt[i]);
				if (slsLdNo[i] != null)
					model.setSlsLdNo(slsLdNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (realCustNm[i] != null)
					model.setRealCustNm(realCustNm[i]);
				if (propMqcQty[i] != null)
					model.setPropMqcQty(propMqcQty[i]);
				if (realCustSrepNm[i] != null)
					model.setRealCustSrepNm(realCustSrepNm[i]);
				if (gamtFlg[i] != null)
					model.setGamtFlg(gamtFlg[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (realCustTpCd[i] != null)
					model.setRealCustTpCd(realCustTpCd[i]);
				if (realCustSrepCd[i] != null)
					model.setRealCustSrepCd(realCustSrepCd[i]);
				if (ctrtPtySgnNm[i] != null)
					model.setCtrtPtySgnNm(ctrtPtySgnNm[i]);
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (realCustValSgmCd[i] != null)
					model.setRealCustValSgmCd(realCustValSgmCd[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (realCustCntCd[i] != null)
					model.setRealCustCntCd(realCustCntCd[i]);
				if (otiEffDt[i] != null)
					model.setOtiEffDt(otiEffDt[i]);
				if (ctrtPtySgnTitNm[i] != null)
					model.setCtrtPtySgnTitNm(ctrtPtySgnTitNm[i]);
				if (otiExpDt[i] != null)
					model.setOtiExpDt(otiExpDt[i]);
				if (propSts[i] != null)
					model.setPropSts(propSts[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtCustSlsOfcCd[i] != null)
					model.setCtrtCustSlsOfcCd(ctrtCustSlsOfcCd[i]);
				if (otiNo[i] != null)
					model.setOtiNo(otiNo[i]);
				if (ctrtCustValSgm[i] != null)
					model.setCtrtCustValSgm(ctrtCustValSgm[i]);
				if (ctrtPtyAddr[i] != null)
					model.setCtrtPtyAddr(ctrtPtyAddr[i]);
				if (realCustSeq[i] != null)
					model.setRealCustSeq(realCustSeq[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (realCustSlsOfcCd[i] != null)
					model.setRealCustSlsOfcCd(realCustSlsOfcCd[i]);
				if (cntrLodUtCd[i] != null)
					model.setCntrLodUtCd(cntrLodUtCd[i]);
				if (blplHdrSeq[i] != null)
					model.setBlplHdrSeq(blplHdrSeq[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (propAproStaff[i] != null)
					model.setPropAproStaff(propAproStaff[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (prcMstPropTpCd[i] != null)
					model.setPrcMstPropTpCd(prcMstPropTpCd[i]);
				if (ctrtCustValSgmCd[i] != null)
					model.setCtrtCustValSgmCd(ctrtCustValSgmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropMnInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropMnInqVO[]
	 */
	public RsltPropMnInqVO[] getRsltPropMnInqVOs(){
		RsltPropMnInqVO[] vos = (RsltPropMnInqVO[])models.toArray(new RsltPropMnInqVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustValSgm = this.realCustValSgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntCmAmt = this.prsCrntCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtPtyTpCd = this.prcCtrtPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepNm = this.propSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo1 = this.scNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiAmt = this.otiAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo2 = this.scNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepNm = this.ctrtCustSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmCmAmt = this.prsEstmCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsLdNo = this.slsLdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustNm = this.realCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propMqcQty = this.propMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSrepNm = this.realCustSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gamtFlg = this.gamtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustTpCd = this.realCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSrepCd = this.realCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnNm = this.ctrtPtySgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustValSgmCd = this.realCustValSgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustCntCd = this.realCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiEffDt = this.otiEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnTitNm = this.ctrtPtySgnTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiExpDt = this.otiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSts = this.propSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSlsOfcCd = this.ctrtCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiNo = this.otiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgm = this.ctrtCustValSgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyAddr = this.ctrtPtyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSeq = this.realCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSlsOfcCd = this.realCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd = this.cntrLodUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplHdrSeq = this.blplHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaff = this.propAproStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcMstPropTpCd = this.prcMstPropTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgmCd = this.ctrtCustValSgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}