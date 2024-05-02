/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : RsltPropMnVO.java
 *@FileTitle : RsltPropMnVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.23
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2011.05.23 서미진 
 * 1.0 Creation
 * =========================================================
 * History
 * 2015.09.21 최성환 [CHM-201537786] SC 다운로드 보안 강화_1차 보완
 * 2015.11.09 최성환 [CHM-201538667] ALPS S/C Autofiling 관련 보완 요청
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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPropMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltPropMnVO> models = new ArrayList<RsltPropMnVO>();

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
	private String reqUsrFlg = null;
	/* Column Info */
	private String nConvCfmFlg = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String prcCtrtPtyTpCd = null;
	/* Column Info */
	private String propSrepNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String otiAmt = null;
	/* Column Info */
	private String ctrtCustSrepNm = null;
	/* Column Info */
	private String propStsCd = null;
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
	private String allUsrFlg = null;
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
	private String lgcyIfFlg = null;
	/* Column Info */
	private String otiLicNo = null;
	/* Column Info */
	private String ptyProgStsCd = null;
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
	private String expDt = null;
	/* Column Info */
	private String aproUsrFlg = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String preExpDt = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String otiMap = null;
	/* Column Info */
	private String convCfmFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cntrLodUtCd = null;
	/* Column Info */
	private String realCustSlsOfcCd = null;
	/* Column Info */
	private String blplHdrSeq = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String preAmdtSeq = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String propAproStaff = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String n1stIfFlg = null;
	/* Column Info */
	private String prcMstPropTpCd = null;
	/* Column Info */
	private String ctrtCustValSgmCd = null;
	/* Column Info */
	private String durDupFlg = null;

	/* Column Info */
	private String propAproStaffId = null;
	
	/* Column Info */
	private String lstProgAproOfcCd = null;
	
	/* Column Info */
	private String maxPropUsrId = null;
	
	/* Column Info */
	private String fmcCfmFlg = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltPropMnVO() {
	}

	public RsltPropMnVO(String ibflag, String pagerows, String propAproDt, String amdtSeq, String realCustValSgm, String prsCrntCmAmt, String reqUsrFlg,
			String nConvCfmFlg, String effDt, String prcCtrtPtyTpCd, String propSrepNm, String scNo, String otiAmt, String propStsCd, String ctrtCustSrepNm,
			String prsEstmCmAmt, String slsLdNo, String custCntCd, String fileDt, String realCustNm, String propMqcQty, String allUsrFlg, String realCustSrepNm,
			String gamtFlg, String ctrtPtyNm, String propOfcCd, String propAproOfcCd, String realCustTpCd, String realCustSrepCd, String ctrtPtySgnNm, String rfFlg,
			String realCustValSgmCd, String ctrtEffDt, String lgcyIfFlg, String otiLicNo, String creDt, String realCustCntCd, String otiEffDt, String ctrtPtySgnTitNm,
			String otiExpDt, String propSts, String ctrtCustSlsOfcCd, String otiNo, String ctrtCustValSgm, String ctrtPtyAddr, String realCustSeq, String expDt,
			String aproUsrFlg, String ctrtExpDt, String updDt, String preExpDt, String propSrepCd, String otiMap, String convCfmFlg, String custSeq,
			String realCustSlsOfcCd, String cntrLodUtCd, String blplHdrSeq, String preAmdtSeq, String prcCtrtCustTpCd, String unit, String propNo, String propAproStaff,
			String ctrtCustSrepCd, String n1stIfFlg, String prcMstPropTpCd, String durDupFlg, String ctrtCustValSgmCd, String ptyProgStsCd, String propAproStaffId, String lstProgAproOfcCd, String maxPropUsrId, String fmcCfmFlg) {
		this.propAproDt = propAproDt;
		this.amdtSeq = amdtSeq;
		this.realCustValSgm = realCustValSgm;
		this.prsCrntCmAmt = prsCrntCmAmt;
		this.pagerows = pagerows;
		this.reqUsrFlg = reqUsrFlg;
		this.nConvCfmFlg = nConvCfmFlg;
		this.effDt = effDt;
		this.prcCtrtPtyTpCd = prcCtrtPtyTpCd;
		this.propSrepNm = propSrepNm;
		this.scNo = scNo;
		this.otiAmt = otiAmt;
		this.ctrtCustSrepNm = ctrtCustSrepNm;
		this.propStsCd = propStsCd;
		this.prsEstmCmAmt = prsEstmCmAmt;
		this.slsLdNo = slsLdNo;
		this.custCntCd = custCntCd;
		this.fileDt = fileDt;
		this.realCustNm = realCustNm;
		this.propMqcQty = propMqcQty;
		this.allUsrFlg = allUsrFlg;
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
		this.lgcyIfFlg = lgcyIfFlg;
		this.otiLicNo = otiLicNo;
		this.ptyProgStsCd = ptyProgStsCd;
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
		this.expDt = expDt;
		this.aproUsrFlg = aproUsrFlg;
		this.ctrtExpDt = ctrtExpDt;
		this.updDt = updDt;
		this.preExpDt = preExpDt;
		this.propSrepCd = propSrepCd;
		this.otiMap = otiMap;
		this.convCfmFlg = convCfmFlg;
		this.custSeq = custSeq;
		this.cntrLodUtCd = cntrLodUtCd;
		this.realCustSlsOfcCd = realCustSlsOfcCd;
		this.blplHdrSeq = blplHdrSeq;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.preAmdtSeq = preAmdtSeq;
		this.unit = unit;
		this.propNo = propNo;
		this.propAproStaff = propAproStaff;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.n1stIfFlg = n1stIfFlg;
		this.prcMstPropTpCd = prcMstPropTpCd;
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
		this.durDupFlg = durDupFlg;
		this.propAproStaffId = propAproStaffId;
		this.lstProgAproOfcCd = lstProgAproOfcCd;
		this.maxPropUsrId = maxPropUsrId;
		this.fmcCfmFlg = fmcCfmFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prop_apro_dt", getPropAproDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("real_cust_val_sgm", getRealCustValSgm());
		this.hashColumns.put("prs_crnt_cm_amt", getPrsCrntCmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("req_usr_flg", getReqUsrFlg());
		this.hashColumns.put("n_conv_cfm_flg", getNConvCfmFlg());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prc_ctrt_pty_tp_cd", getPrcCtrtPtyTpCd());
		this.hashColumns.put("prop_srep_nm", getPropSrepNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("oti_amt", getOtiAmt());
		this.hashColumns.put("ctrt_cust_srep_nm", getCtrtCustSrepNm());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("prs_estm_cm_amt", getPrsEstmCmAmt());
		this.hashColumns.put("sls_ld_no", getSlsLdNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("real_cust_nm", getRealCustNm());
		this.hashColumns.put("prop_mqc_qty", getPropMqcQty());
		this.hashColumns.put("all_usr_flg", getAllUsrFlg());
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
		this.hashColumns.put("lgcy_if_flg", getLgcyIfFlg());
		this.hashColumns.put("oti_lic_no", getOtiLicNo());
		this.hashColumns.put("pty_prog_sts_cd", getPtyProgStsCd());
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
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("apro_usr_flg", getAproUsrFlg());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pre_exp_dt", getPreExpDt());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("oti_map", getOtiMap());
		this.hashColumns.put("conv_cfm_flg", getConvCfmFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("real_cust_sls_ofc_cd", getRealCustSlsOfcCd());
		this.hashColumns.put("blpl_hdr_seq", getBlplHdrSeq());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("pre_amdt_seq", getPreAmdtSeq());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prop_apro_staff", getPropAproStaff());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("n1st_if_flg", getN1stIfFlg());
		this.hashColumns.put("prc_mst_prop_tp_cd", getPrcMstPropTpCd());
		this.hashColumns.put("ctrt_cust_val_sgm_cd", getCtrtCustValSgmCd());
		this.hashColumns.put("dur_dup_flg", getDurDupFlg());
		this.hashColumns.put("prop_apro_staff_id", getPropAproStaffId());
		this.hashColumns.put("lst_prog_apro_ofc_cd", getLstProgAproOfcCd());
		this.hashColumns.put("max_prop_usr_id", getMaxPropUsrId());
		this.hashColumns.put("fmc_cfm_flg", getFmcCfmFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("prop_apro_dt", "propAproDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("real_cust_val_sgm", "realCustValSgm");
		this.hashFields.put("prs_crnt_cm_amt", "prsCrntCmAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("req_usr_flg", "reqUsrFlg");
		this.hashFields.put("n_conv_cfm_flg", "nConvCfmFlg");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prc_ctrt_pty_tp_cd", "prcCtrtPtyTpCd");
		this.hashFields.put("prop_srep_nm", "propSrepNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("oti_amt", "otiAmt");
		this.hashFields.put("ctrt_cust_srep_nm", "ctrtCustSrepNm");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("prs_estm_cm_amt", "prsEstmCmAmt");
		this.hashFields.put("sls_ld_no", "slsLdNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("real_cust_nm", "realCustNm");
		this.hashFields.put("prop_mqc_qty", "propMqcQty");
		this.hashFields.put("all_usr_flg", "allUsrFlg");
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
		this.hashFields.put("lgcy_if_flg", "lgcyIfFlg");
		this.hashFields.put("oti_lic_no", "otiLicNo");
		this.hashFields.put("pty_prog_sts_cd", "ptyProgStsCd");
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
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("apro_usr_flg", "aproUsrFlg");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("oti_map", "otiMap");
		this.hashFields.put("conv_cfm_flg", "convCfmFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("real_cust_sls_ofc_cd", "realCustSlsOfcCd");
		this.hashFields.put("blpl_hdr_seq", "blplHdrSeq");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("pre_amdt_seq", "preAmdtSeq");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prop_apro_staff", "propAproStaff");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("n1st_if_flg", "n1stIfFlg");
		this.hashFields.put("prc_mst_prop_tp_cd", "prcMstPropTpCd");
		this.hashFields.put("ctrt_cust_val_sgm_cd", "ctrtCustValSgmCd");
		this.hashFields.put("dur_dup_flg", "durDupFlg");
		this.hashFields.put("prop_apro_staff_id", "propAproStaffId");
		this.hashFields.put("lst_prog_apro_ofc_cd", "lstProgAproOfcCd");
		this.hashFields.put("max_prop_usr_id", "maxPropUsrId");
		this.hashFields.put("fmc_cfm_flg", "fmcCfmFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return propAproDt
	 */
	public String getPropAproDt() {
		return this.propAproDt;
	}

	/**
	 * Column Info
	 * 
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustValSgm
	 */
	public String getRealCustValSgm() {
		return this.realCustValSgm;
	}

	/**
	 * Column Info
	 * 
	 * @return prsCrntCmAmt
	 */
	public String getPrsCrntCmAmt() {
		return this.prsCrntCmAmt;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return reqUsrFlg
	 */
	public String getReqUsrFlg() {
		return this.reqUsrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return nConvCfmFlg
	 */
	public String getNConvCfmFlg() {
		return this.nConvCfmFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}

	/**
	 * Column Info
	 * 
	 * @return prcCtrtPtyTpCd
	 */
	public String getPrcCtrtPtyTpCd() {
		return this.prcCtrtPtyTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return propSrepNm
	 */
	public String getPropSrepNm() {
		return this.propSrepNm;
	}

	/**
	 * Column Info
	 * 
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}

	/**
	 * Column Info
	 * 
	 * @return otiAmt
	 */
	public String getOtiAmt() {
		return this.otiAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtCustSrepNm
	 */
	public String getCtrtCustSrepNm() {
		return this.ctrtCustSrepNm;
	}

	/**
	 * Column Info
	 * 
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return prsEstmCmAmt
	 */
	public String getPrsEstmCmAmt() {
		return this.prsEstmCmAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return slsLdNo
	 */
	public String getSlsLdNo() {
		return this.slsLdNo;
	}

	/**
	 * Column Info
	 * 
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}

	/**
	 * Column Info
	 * 
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustNm
	 */
	public String getRealCustNm() {
		return this.realCustNm;
	}

	/**
	 * Column Info
	 * 
	 * @return propMqcQty
	 */
	public String getPropMqcQty() {
		return this.propMqcQty;
	}

	/**
	 * Column Info
	 * 
	 * @return allUsrFlg
	 */
	public String getAllUsrFlg() {
		return this.allUsrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustSrepNm
	 */
	public String getRealCustSrepNm() {
		return this.realCustSrepNm;
	}

	/**
	 * Column Info
	 * 
	 * @return gamtFlg
	 */
	public String getGamtFlg() {
		return this.gamtFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}

	/**
	 * Column Info
	 * 
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustTpCd
	 */
	public String getRealCustTpCd() {
		return this.realCustTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustSrepCd
	 */
	public String getRealCustSrepCd() {
		return this.realCustSrepCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtPtySgnNm
	 */
	public String getCtrtPtySgnNm() {
		return this.ctrtPtySgnNm;
	}

	/**
	 * Column Info
	 * 
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustValSgmCd
	 */
	public String getRealCustValSgmCd() {
		return this.realCustValSgmCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
	}

	/**
	 * Column Info
	 * 
	 * @return lgcyIfFlg
	 */
	public String getLgcyIfFlg() {
		return this.lgcyIfFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return otiLicNo
	 */
	public String getOtiLicNo() {
		return this.otiLicNo;
	}

	/**
	 * Column Info
	 * 
	 * @return ptyProgStsCd
	 */
	public String getPtyProgStsCd() {
		return this.ptyProgStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustCntCd
	 */
	public String getRealCustCntCd() {
		return this.realCustCntCd;
	}

	/**
	 * Column Info
	 * 
	 * @return otiEffDt
	 */
	public String getOtiEffDt() {
		return this.otiEffDt;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtPtySgnTitNm
	 */
	public String getCtrtPtySgnTitNm() {
		return this.ctrtPtySgnTitNm;
	}

	/**
	 * Column Info
	 * 
	 * @return otiExpDt
	 */
	public String getOtiExpDt() {
		return this.otiExpDt;
	}

	/**
	 * Column Info
	 * 
	 * @return propSts
	 */
	public String getPropSts() {
		return this.propSts;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtCustSlsOfcCd
	 */
	public String getCtrtCustSlsOfcCd() {
		return this.ctrtCustSlsOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return otiNo
	 */
	public String getOtiNo() {
		return this.otiNo;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtCustValSgm
	 */
	public String getCtrtCustValSgm() {
		return this.ctrtCustValSgm;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtPtyAddr
	 */
	public String getCtrtPtyAddr() {
		return this.ctrtPtyAddr;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustSeq
	 */
	public String getRealCustSeq() {
		return this.realCustSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}

	/**
	 * Column Info
	 * 
	 * @return aproUsrFlg
	 */
	public String getAproUsrFlg() {
		return this.aproUsrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return preExpDt
	 */
	public String getPreExpDt() {
		return this.preExpDt;
	}

	/**
	 * Column Info
	 * 
	 * @return propSrepCd
	 */
	public String getPropSrepCd() {
		return this.propSrepCd;
	}

	/**
	 * Column Info
	 * 
	 * @return otiMap
	 */
	public String getOtiMap() {
		return this.otiMap;
	}

	/**
	 * Column Info
	 * 
	 * @return convCfmFlg
	 */
	public String getConvCfmFlg() {
		return this.convCfmFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrLodUtCd
	 */
	public String getCntrLodUtCd() {
		return this.cntrLodUtCd;
	}

	/**
	 * Column Info
	 * 
	 * @return realCustSlsOfcCd
	 */
	public String getRealCustSlsOfcCd() {
		return this.realCustSlsOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return blplHdrSeq
	 */
	public String getBlplHdrSeq() {
		return this.blplHdrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return preAmdtSeq
	 */
	public String getPreAmdtSeq() {
		return this.preAmdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
	}

	/**
	 * Column Info
	 * 
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}

	/**
	 * Column Info
	 * 
	 * @return propAproStaff
	 */
	public String getPropAproStaff() {
		return this.propAproStaff;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}

	/**
	 * Column Info
	 * 
	 * @return n1stIfFlg
	 */
	public String getN1stIfFlg() {
		return this.n1stIfFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return prcMstPropTpCd
	 */
	public String getPrcMstPropTpCd() {
		return this.prcMstPropTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtCustValSgmCd
	 */
	public String getCtrtCustValSgmCd() {
		return this.ctrtCustValSgmCd;
	}

	/**
	 * Column Info
	 * 
	 * @return durDupFlg
	 */
	public String getDurDupFlg() {
		return this.durDupFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param propAproDt
	 */
	public void setPropAproDt(String propAproDt) {
		this.propAproDt = propAproDt;
	}

	/**
	 * Column Info
	 * 
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustValSgm
	 */
	public void setRealCustValSgm(String realCustValSgm) {
		this.realCustValSgm = realCustValSgm;
	}

	/**
	 * Column Info
	 * 
	 * @param prsCrntCmAmt
	 */
	public void setPrsCrntCmAmt(String prsCrntCmAmt) {
		this.prsCrntCmAmt = prsCrntCmAmt;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param reqUsrFlg
	 */
	public void setReqUsrFlg(String reqUsrFlg) {
		this.reqUsrFlg = reqUsrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param nConvCfmFlg
	 */
	public void setNConvCfmFlg(String nConvCfmFlg) {
		this.nConvCfmFlg = nConvCfmFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	/**
	 * Column Info
	 * 
	 * @param prcCtrtPtyTpCd
	 */
	public void setPrcCtrtPtyTpCd(String prcCtrtPtyTpCd) {
		this.prcCtrtPtyTpCd = prcCtrtPtyTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param propSrepNm
	 */
	public void setPropSrepNm(String propSrepNm) {
		this.propSrepNm = propSrepNm;
	}

	/**
	 * Column Info
	 * 
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	/**
	 * Column Info
	 * 
	 * @param otiAmt
	 */
	public void setOtiAmt(String otiAmt) {
		this.otiAmt = otiAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtCustSrepNm
	 */
	public void setCtrtCustSrepNm(String ctrtCustSrepNm) {
		this.ctrtCustSrepNm = ctrtCustSrepNm;
	}

	/**
	 * Column Info
	 * 
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param prsEstmCmAmt
	 */
	public void setPrsEstmCmAmt(String prsEstmCmAmt) {
		this.prsEstmCmAmt = prsEstmCmAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param slsLdNo
	 */
	public void setSlsLdNo(String slsLdNo) {
		this.slsLdNo = slsLdNo;
	}

	/**
	 * Column Info
	 * 
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * Column Info
	 * 
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustNm
	 */
	public void setRealCustNm(String realCustNm) {
		this.realCustNm = realCustNm;
	}

	/**
	 * Column Info
	 * 
	 * @param propMqcQty
	 */
	public void setPropMqcQty(String propMqcQty) {
		this.propMqcQty = propMqcQty;
	}

	/**
	 * Column Info
	 * 
	 * @param allUsrFlg
	 */
	public void setAllUsrFlg(String allUsrFlg) {
		this.allUsrFlg = allUsrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustSrepNm
	 */
	public void setRealCustSrepNm(String realCustSrepNm) {
		this.realCustSrepNm = realCustSrepNm;
	}

	/**
	 * Column Info
	 * 
	 * @param gamtFlg
	 */
	public void setGamtFlg(String gamtFlg) {
		this.gamtFlg = gamtFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}

	/**
	 * Column Info
	 * 
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustTpCd
	 */
	public void setRealCustTpCd(String realCustTpCd) {
		this.realCustTpCd = realCustTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustSrepCd
	 */
	public void setRealCustSrepCd(String realCustSrepCd) {
		this.realCustSrepCd = realCustSrepCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtPtySgnNm
	 */
	public void setCtrtPtySgnNm(String ctrtPtySgnNm) {
		this.ctrtPtySgnNm = ctrtPtySgnNm;
	}

	/**
	 * Column Info
	 * 
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustValSgmCd
	 */
	public void setRealCustValSgmCd(String realCustValSgmCd) {
		this.realCustValSgmCd = realCustValSgmCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
	}

	/**
	 * Column Info
	 * 
	 * @param lgcyIfFlg
	 */
	public void setLgcyIfFlg(String lgcyIfFlg) {
		this.lgcyIfFlg = lgcyIfFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param otiLicNo
	 */
	public void setOtiLicNo(String otiLicNo) {
		this.otiLicNo = otiLicNo;
	}

	/**
	 * Column Info
	 * 
	 * @param ptyProgStsCd
	 */
	public void setPtyProgStsCd(String ptyProgStsCd) {
		this.ptyProgStsCd = ptyProgStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustCntCd
	 */
	public void setRealCustCntCd(String realCustCntCd) {
		this.realCustCntCd = realCustCntCd;
	}

	/**
	 * Column Info
	 * 
	 * @param otiEffDt
	 */
	public void setOtiEffDt(String otiEffDt) {
		this.otiEffDt = otiEffDt;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtPtySgnTitNm
	 */
	public void setCtrtPtySgnTitNm(String ctrtPtySgnTitNm) {
		this.ctrtPtySgnTitNm = ctrtPtySgnTitNm;
	}

	/**
	 * Column Info
	 * 
	 * @param otiExpDt
	 */
	public void setOtiExpDt(String otiExpDt) {
		this.otiExpDt = otiExpDt;
	}

	/**
	 * Column Info
	 * 
	 * @param propSts
	 */
	public void setPropSts(String propSts) {
		this.propSts = propSts;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtCustSlsOfcCd
	 */
	public void setCtrtCustSlsOfcCd(String ctrtCustSlsOfcCd) {
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param otiNo
	 */
	public void setOtiNo(String otiNo) {
		this.otiNo = otiNo;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtCustValSgm
	 */
	public void setCtrtCustValSgm(String ctrtCustValSgm) {
		this.ctrtCustValSgm = ctrtCustValSgm;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtPtyAddr
	 */
	public void setCtrtPtyAddr(String ctrtPtyAddr) {
		this.ctrtPtyAddr = ctrtPtyAddr;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustSeq
	 */
	public void setRealCustSeq(String realCustSeq) {
		this.realCustSeq = realCustSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	/**
	 * Column Info
	 * 
	 * @param aproUsrFlg
	 */
	public void setAproUsrFlg(String aproUsrFlg) {
		this.aproUsrFlg = aproUsrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param preExpDt
	 */
	public void setPreExpDt(String preExpDt) {
		this.preExpDt = preExpDt;
	}

	/**
	 * Column Info
	 * 
	 * @param propSrepCd
	 */
	public void setPropSrepCd(String propSrepCd) {
		this.propSrepCd = propSrepCd;
	}

	/**
	 * Column Info
	 * 
	 * @param otiMap
	 */
	public void setOtiMap(String otiMap) {
		this.otiMap = otiMap;
	}

	/**
	 * Column Info
	 * 
	 * @param convCfmFlg
	 */
	public void setConvCfmFlg(String convCfmFlg) {
		this.convCfmFlg = convCfmFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrLodUtCd
	 */
	public void setCntrLodUtCd(String cntrLodUtCd) {
		this.cntrLodUtCd = cntrLodUtCd;
	}

	/**
	 * Column Info
	 * 
	 * @param realCustSlsOfcCd
	 */
	public void setRealCustSlsOfcCd(String realCustSlsOfcCd) {
		this.realCustSlsOfcCd = realCustSlsOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param blplHdrSeq
	 */
	public void setBlplHdrSeq(String blplHdrSeq) {
		this.blplHdrSeq = blplHdrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param preAmdtSeq
	 */
	public void setPreAmdtSeq(String preAmdtSeq) {
		this.preAmdtSeq = preAmdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * Column Info
	 * 
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}

	/**
	 * Column Info
	 * 
	 * @param propAproStaff
	 */
	public void setPropAproStaff(String propAproStaff) {
		this.propAproStaff = propAproStaff;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}

	/**
	 * Column Info
	 * 
	 * @param n1stIfFlg
	 */
	public void setN1stIfFlg(String n1stIfFlg) {
		this.n1stIfFlg = n1stIfFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param prcMstPropTpCd
	 */
	public void setPrcMstPropTpCd(String prcMstPropTpCd) {
		this.prcMstPropTpCd = prcMstPropTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtCustValSgmCd
	 */
	public void setCtrtCustValSgmCd(String ctrtCustValSgmCd) {
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}

	/**
	 * Column Info
	 * 
	 * @param durDupFlg
	 */
	public void setDurDupFlg(String durDupFlg) {
		this.durDupFlg = durDupFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return propAproStaffId
	 */
	public String getPropAproStaffId() {
		return propAproStaffId;
	}

	/**
	 * Column Info
	 * 
	 * @param propAproStaffId
	 */
	public void setPropAproStaffId(String propAproStaffId) {
		this.propAproStaffId = propAproStaffId;
	}
	
	
	/**
	 * Column Info
	 * 
	 * @return lstProgAproOfcCd
	 */
	public String getLstProgAproOfcCd() {
		return lstProgAproOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param lstProgAproOfcCd
	 */
	public void setLstProgAproOfcCd(String lstProgAproOfcCd) {
		this.lstProgAproOfcCd = lstProgAproOfcCd;
	}
	
	/**
	 * Column Info
	 * 
	 * @return maxPropUsrId
	 */
	public String getMaxPropUsrId() {
		return maxPropUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param maxPropUsrId
	 */
	public void setMaxPropUsrId(String maxPropUsrId) {
		this.maxPropUsrId = maxPropUsrId;
	}
	
	
	/**
	 * Column Info
	 * 
	 * @return fmcCfmFlg
	 */
	public String getFmcCfmFlg() {
		return fmcCfmFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param fmcCfmFlg
	 */
	public void setFmcCfmFlg(String fmcCfmFlg) {
		this.fmcCfmFlg = fmcCfmFlg;
	}	

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPropAproDt(JSPUtil.getParameter(request, prefix + "prop_apro_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setRealCustValSgm(JSPUtil.getParameter(request, prefix + "real_cust_val_sgm", ""));
		setPrsCrntCmAmt(JSPUtil.getParameter(request, prefix + "prs_crnt_cm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setReqUsrFlg(JSPUtil.getParameter(request, prefix + "req_usr_flg", ""));
		setNConvCfmFlg(JSPUtil.getParameter(request, prefix + "n_conv_cfm_flg", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setPrcCtrtPtyTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_pty_tp_cd", ""));
		setPropSrepNm(JSPUtil.getParameter(request, prefix + "prop_srep_nm", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setOtiAmt(JSPUtil.getParameter(request, prefix + "oti_amt", ""));
		setCtrtCustSrepNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_nm", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setPrsEstmCmAmt(JSPUtil.getParameter(request, prefix + "prs_estm_cm_amt", ""));
		setSlsLdNo(JSPUtil.getParameter(request, prefix + "sls_ld_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setRealCustNm(JSPUtil.getParameter(request, prefix + "real_cust_nm", ""));
		setPropMqcQty(JSPUtil.getParameter(request, prefix + "prop_mqc_qty", ""));
		setAllUsrFlg(JSPUtil.getParameter(request, prefix + "all_usr_flg", ""));
		setRealCustSrepNm(JSPUtil.getParameter(request, prefix + "real_cust_srep_nm", ""));
		setGamtFlg(JSPUtil.getParameter(request, prefix + "gamt_flg", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setRealCustTpCd(JSPUtil.getParameter(request, prefix + "real_cust_tp_cd", ""));
		setRealCustSrepCd(JSPUtil.getParameter(request, prefix + "real_cust_srep_cd", ""));
		setCtrtPtySgnNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_sgn_nm", ""));
		setRfFlg(JSPUtil.getParameter(request, prefix + "rf_flg", ""));
		setRealCustValSgmCd(JSPUtil.getParameter(request, prefix + "real_cust_val_sgm_cd", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setLgcyIfFlg(JSPUtil.getParameter(request, prefix + "lgcy_if_flg", ""));
		setOtiLicNo(JSPUtil.getParameter(request, prefix + "oti_lic_no", ""));
		setPtyProgStsCd(JSPUtil.getParameter(request, prefix + "pty_prog_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRealCustCntCd(JSPUtil.getParameter(request, prefix + "real_cust_cnt_cd", ""));
		setOtiEffDt(JSPUtil.getParameter(request, prefix + "oti_eff_dt", ""));
		setCtrtPtySgnTitNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_sgn_tit_nm", ""));
		setOtiExpDt(JSPUtil.getParameter(request, prefix + "oti_exp_dt", ""));
		setPropSts(JSPUtil.getParameter(request, prefix + "prop_sts", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtCustSlsOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_sls_ofc_cd", ""));
		setOtiNo(JSPUtil.getParameter(request, prefix + "oti_no", ""));
		setCtrtCustValSgm(JSPUtil.getParameter(request, prefix + "ctrt_cust_val_sgm", ""));
		setCtrtPtyAddr(JSPUtil.getParameter(request, prefix + "ctrt_pty_addr", ""));
		setRealCustSeq(JSPUtil.getParameter(request, prefix + "real_cust_seq", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setAproUsrFlg(JSPUtil.getParameter(request, prefix + "apro_usr_flg", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPreExpDt(JSPUtil.getParameter(request, prefix + "pre_exp_dt", ""));
		setPropSrepCd(JSPUtil.getParameter(request, prefix + "prop_srep_cd", ""));
		setOtiMap(JSPUtil.getParameter(request, prefix + "oti_map", ""));
		setConvCfmFlg(JSPUtil.getParameter(request, prefix + "conv_cfm_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request, prefix + "cntr_lod_ut_cd", ""));
		setRealCustSlsOfcCd(JSPUtil.getParameter(request, prefix + "real_cust_sls_ofc_cd", ""));
		setBlplHdrSeq(JSPUtil.getParameter(request, prefix + "blpl_hdr_seq", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setPreAmdtSeq(JSPUtil.getParameter(request, prefix + "pre_amdt_seq", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setPropAproStaff(JSPUtil.getParameter(request, prefix + "prop_apro_staff", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", ""));
		setN1stIfFlg(JSPUtil.getParameter(request, prefix + "n1st_if_flg", ""));
		setPrcMstPropTpCd(JSPUtil.getParameter(request, prefix + "prc_mst_prop_tp_cd", ""));
		setCtrtCustValSgmCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_val_sgm_cd", ""));
		setDurDupFlg(JSPUtil.getParameter(request, prefix + "dur_dup_flg", ""));
		setPropAproStaffId(JSPUtil.getParameter(request, prefix + "propAproStaffId", ""));
		setLstProgAproOfcCd(JSPUtil.getParameter(request, prefix + "lstProgAproOfcCd", ""));
		setMaxPropUsrId(JSPUtil.getParameter(request, prefix + "maxPropUsrId", ""));
		setFmcCfmFlg(JSPUtil.getParameter(request, prefix + "fmcCfmFlg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return RsltPropMnVO[]
	 */
	public RsltPropMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return RsltPropMnVO[]
	 */
	public RsltPropMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropMnVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] propAproDt = (JSPUtil.getParameter(request, prefix + "prop_apro_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix + "amdt_seq", length));
			String[] realCustValSgm = (JSPUtil.getParameter(request, prefix + "real_cust_val_sgm", length));
			String[] prsCrntCmAmt = (JSPUtil.getParameter(request, prefix + "prs_crnt_cm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] reqUsrFlg = (JSPUtil.getParameter(request, prefix + "req_usr_flg", length));
			String[] nConvCfmFlg = (JSPUtil.getParameter(request, prefix + "n_conv_cfm_flg", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
			String[] prcCtrtPtyTpCd = (JSPUtil.getParameter(request, prefix + "prc_ctrt_pty_tp_cd", length));
			String[] propSrepNm = (JSPUtil.getParameter(request, prefix + "prop_srep_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
			String[] otiAmt = (JSPUtil.getParameter(request, prefix + "oti_amt", length));
			String[] ctrtCustSrepNm = (JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_nm", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix + "prop_sts_cd", length));
			String[] prsEstmCmAmt = (JSPUtil.getParameter(request, prefix + "prs_estm_cm_amt", length));
			String[] slsLdNo = (JSPUtil.getParameter(request, prefix + "sls_ld_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix + "file_dt", length));
			String[] realCustNm = (JSPUtil.getParameter(request, prefix + "real_cust_nm", length));
			String[] propMqcQty = (JSPUtil.getParameter(request, prefix + "prop_mqc_qty", length));
			String[] allUsrFlg = (JSPUtil.getParameter(request, prefix + "all_usr_flg", length));
			String[] realCustSrepNm = (JSPUtil.getParameter(request, prefix + "real_cust_srep_nm", length));
			String[] gamtFlg = (JSPUtil.getParameter(request, prefix + "gamt_flg", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix + "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", length));
			String[] realCustTpCd = (JSPUtil.getParameter(request, prefix + "real_cust_tp_cd", length));
			String[] realCustSrepCd = (JSPUtil.getParameter(request, prefix + "real_cust_srep_cd", length));
			String[] ctrtPtySgnNm = (JSPUtil.getParameter(request, prefix + "ctrt_pty_sgn_nm", length));
			String[] rfFlg = (JSPUtil.getParameter(request, prefix + "rf_flg", length));
			String[] realCustValSgmCd = (JSPUtil.getParameter(request, prefix + "real_cust_val_sgm_cd", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", length));
			String[] lgcyIfFlg = (JSPUtil.getParameter(request, prefix + "lgcy_if_flg", length));
			String[] otiLicNo = (JSPUtil.getParameter(request, prefix + "oti_lic_no", length));
			String[] ptyProgStsCd = (JSPUtil.getParameter(request, prefix + "pty_prog_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] realCustCntCd = (JSPUtil.getParameter(request, prefix + "real_cust_cnt_cd", length));
			String[] otiEffDt = (JSPUtil.getParameter(request, prefix + "oti_eff_dt", length));
			String[] ctrtPtySgnTitNm = (JSPUtil.getParameter(request, prefix + "ctrt_pty_sgn_tit_nm", length));
			String[] otiExpDt = (JSPUtil.getParameter(request, prefix + "oti_exp_dt", length));
			String[] propSts = (JSPUtil.getParameter(request, prefix + "prop_sts", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] ctrtCustSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ctrt_cust_sls_ofc_cd", length));
			String[] otiNo = (JSPUtil.getParameter(request, prefix + "oti_no", length));
			String[] ctrtCustValSgm = (JSPUtil.getParameter(request, prefix + "ctrt_cust_val_sgm", length));
			String[] ctrtPtyAddr = (JSPUtil.getParameter(request, prefix + "ctrt_pty_addr", length));
			String[] realCustSeq = (JSPUtil.getParameter(request, prefix + "real_cust_seq", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix + "exp_dt", length));
			String[] aproUsrFlg = (JSPUtil.getParameter(request, prefix + "apro_usr_flg", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] preExpDt = (JSPUtil.getParameter(request, prefix + "pre_exp_dt", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix + "prop_srep_cd", length));
			String[] otiMap = (JSPUtil.getParameter(request, prefix + "oti_map", length));
			String[] convCfmFlg = (JSPUtil.getParameter(request, prefix + "conv_cfm_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
			String[] cntrLodUtCd = (JSPUtil.getParameter(request, prefix + "cntr_lod_ut_cd", length));
			String[] realCustSlsOfcCd = (JSPUtil.getParameter(request, prefix + "real_cust_sls_ofc_cd", length));
			String[] blplHdrSeq = (JSPUtil.getParameter(request, prefix + "blpl_hdr_seq", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", length));
			String[] preAmdtSeq = (JSPUtil.getParameter(request, prefix + "pre_amdt_seq", length));
			String[] unit = (JSPUtil.getParameter(request, prefix + "unit", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix + "prop_no", length));
			String[] propAproStaff = (JSPUtil.getParameter(request, prefix + "prop_apro_staff", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", length));
			String[] n1stIfFlg = (JSPUtil.getParameter(request, prefix + "n1st_if_flg", length));
			String[] prcMstPropTpCd = (JSPUtil.getParameter(request, prefix + "prc_mst_prop_tp_cd", length));
			String[] ctrtCustValSgmCd = (JSPUtil.getParameter(request, prefix + "ctrt_cust_val_sgm_cd", length));
			String[] durDupFlg = (JSPUtil.getParameter(request, prefix + "dur_dup_flg", length));
			String[] propAproStaffId = (JSPUtil.getParameter(request, prefix + "prop_apro_staff_id", length));
			String[] lstProgAproOfcCd = (JSPUtil.getParameter(request, prefix + "lst_prog_apro_ofc_cd", length));
			String[] maxPropUsrId = (JSPUtil.getParameter(request, prefix + "max_prop_usr_id", length));
			String[] fmcCfmFlg = (JSPUtil.getParameter(request, prefix + "fmc_cfm_flg", length));

			for (int i = 0; i < length; i++) {
				model = new RsltPropMnVO();
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
				if (reqUsrFlg[i] != null)
					model.setReqUsrFlg(reqUsrFlg[i]);
				if (nConvCfmFlg[i] != null)
					model.setNConvCfmFlg(nConvCfmFlg[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (prcCtrtPtyTpCd[i] != null)
					model.setPrcCtrtPtyTpCd(prcCtrtPtyTpCd[i]);
				if (propSrepNm[i] != null)
					model.setPropSrepNm(propSrepNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (otiAmt[i] != null)
					model.setOtiAmt(otiAmt[i]);
				if (ctrtCustSrepNm[i] != null)
					model.setCtrtCustSrepNm(ctrtCustSrepNm[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
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
				if (allUsrFlg[i] != null)
					model.setAllUsrFlg(allUsrFlg[i]);
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
				if (lgcyIfFlg[i] != null)
					model.setLgcyIfFlg(lgcyIfFlg[i]);
				if (otiLicNo[i] != null)
					model.setOtiLicNo(otiLicNo[i]);
				if (ptyProgStsCd[i] != null)
					model.setPtyProgStsCd(ptyProgStsCd[i]);
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
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (aproUsrFlg[i] != null)
					model.setAproUsrFlg(aproUsrFlg[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (preExpDt[i] != null)
					model.setPreExpDt(preExpDt[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (otiMap[i] != null)
					model.setOtiMap(otiMap[i]);
				if (convCfmFlg[i] != null)
					model.setConvCfmFlg(convCfmFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cntrLodUtCd[i] != null)
					model.setCntrLodUtCd(cntrLodUtCd[i]);
				if (realCustSlsOfcCd[i] != null)
					model.setRealCustSlsOfcCd(realCustSlsOfcCd[i]);
				if (blplHdrSeq[i] != null)
					model.setBlplHdrSeq(blplHdrSeq[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (preAmdtSeq[i] != null)
					model.setPreAmdtSeq(preAmdtSeq[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (propAproStaff[i] != null)
					model.setPropAproStaff(propAproStaff[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (n1stIfFlg[i] != null)
					model.setN1stIfFlg(n1stIfFlg[i]);
				if (prcMstPropTpCd[i] != null)
					model.setPrcMstPropTpCd(prcMstPropTpCd[i]);
				if (ctrtCustValSgmCd[i] != null)
					model.setCtrtCustValSgmCd(ctrtCustValSgmCd[i]);
				if (durDupFlg[i] != null)
					model.setDurDupFlg(durDupFlg[i]);
				if (propAproStaffId[i] != null)
					model.setPropAproStaffId(propAproStaffId[i]);
				if (lstProgAproOfcCd[i] != null)
					model.setLstProgAproOfcCd(lstProgAproOfcCd[i]);
				if (maxPropUsrId[i] != null)
					model.setMaxPropUsrId(maxPropUsrId[i]);
				if (fmcCfmFlg[i] != null)
					model.setFmcCfmFlg(fmcCfmFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return RsltPropMnVO[]
	 */
	public RsltPropMnVO[] getRsltPropMnVOs() {
		RsltPropMnVO[] vos = (RsltPropMnVO[]) models.toArray(new RsltPropMnVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.propAproDt = this.propAproDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustValSgm = this.realCustValSgm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntCmAmt = this.prsCrntCmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrFlg = this.reqUsrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nConvCfmFlg = this.nConvCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtPtyTpCd = this.prcCtrtPtyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepNm = this.propSrepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiAmt = this.otiAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepNm = this.ctrtCustSrepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmCmAmt = this.prsEstmCmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsLdNo = this.slsLdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustNm = this.realCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propMqcQty = this.propMqcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allUsrFlg = this.allUsrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSrepNm = this.realCustSrepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gamtFlg = this.gamtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustTpCd = this.realCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSrepCd = this.realCustSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnNm = this.ctrtPtySgnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlg = this.rfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustValSgmCd = this.realCustValSgmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgcyIfFlg = this.lgcyIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiLicNo = this.otiLicNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyProgStsCd = this.ptyProgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustCntCd = this.realCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiEffDt = this.otiEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnTitNm = this.ctrtPtySgnTitNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiExpDt = this.otiExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSts = this.propSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSlsOfcCd = this.ctrtCustSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiNo = this.otiNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgm = this.ctrtCustValSgm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyAddr = this.ctrtPtyAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSeq = this.realCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrFlg = this.aproUsrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExpDt = this.preExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiMap = this.otiMap.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convCfmFlg = this.convCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd = this.cntrLodUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSlsOfcCd = this.realCustSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplHdrSeq = this.blplHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preAmdtSeq = this.preAmdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaff = this.propAproStaff.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stIfFlg = this.n1stIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcMstPropTpCd = this.prcMstPropTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgmCd = this.ctrtCustValSgmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durDupFlg = this.durDupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaffId = this.propAproStaffId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstProgAproOfcCd = this.lstProgAproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxPropUsrId = this.maxPropUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcCfmFlg = this.fmcCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
