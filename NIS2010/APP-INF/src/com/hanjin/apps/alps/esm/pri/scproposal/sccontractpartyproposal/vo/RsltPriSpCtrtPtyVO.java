/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpCtrtPtyVO.java
*@FileTitle : RsltPriSpCtrtPtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.03 공백진 
* 1.0 Creation
=========================================================
* History
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section) 및 Loading Agent POA Attach(L/Agent section) 기능 개발요청
*                                    - 조회시 OTI Bond No, OTI License No., FileName 가져와서 보여주기 위해 VO 수정
=========================================================*/


package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */ 

public class RsltPriSpCtrtPtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpCtrtPtyVO> models = new ArrayList<RsltPriSpCtrtPtyVO>();
	
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String acptOfcCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String prcProgStsNm = null;
	/* Column Info */
	private String acptUsrId = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String srcInfoNm = null;
	/* Column Info */
	private String ctrtPtySgnTitNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtCustSlsOfcCd = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String prcCtrtPtyTpCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String ctrtPtyAddr = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ctrtPtySgnNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ctrtCustValSgmCd = null;
	/* Column Info */
	private String nvoccBdNo = null;
	/* Column Info */
	private String nvoccLicNo = null;
	/* Column Info */
	private String otiLicAtchFileId = null;
	/* Column Info */
	private String otiBdAtchFileId = null;
	/* Column Info */
	private String trfTitAtchFileId = null;
	/* Column Info */
	private String poaAtchFileId = null;
	/* Column Info */
	private String otiLicAtchFileNm = null;
	/* Column Info */
	private String otiBdAtchFileNm = null;
	/* Column Info */
	private String trfTitAtchFileNm = null;
	/* Column Info */
	private String poaAtchFileNm = null;
	/* Column Info */
	private String otiLicAtchFileNmOrg = null;
	/* Column Info */
	private String poaAtchFileNmOrg = null;
	/* Column Info */
	private String trfTitAtchFileNmOrg = null;
	/* Column Info */
	private String otiBdAtchFileNmOrg = null;
	/* Column Info */
	private String mocLicNo = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpCtrtPtyVO() {}

	public RsltPriSpCtrtPtyVO(String ibflag, String pagerows, String propNo, String amdtSeq, String prcCtrtPtyTpCd, String custCntCd, String custSeq, String ctrtCustValSgmCd, String ctrtCustSrepCd, String ctrtCustSlsOfcCd, String ctrtPtyNm, String ctrtPtyAddr
			, String ctrtPtySgnNm, String ctrtPtySgnTitNm, String n1stCmncAmdtSeq, String effDt, String expDt, String srcInfoCd, String srcInfoNm, String prcProgStsCd, String prcProgStsNm, String acptUsrId, String acptOfcCd, String acptDt
			, String nvoccBdNo, String nvoccLicNo,String otiLicAtchFileId, String otiBdAtchFileId, String trfTitAtchFileId, String poaAtchFileId, String otiLicAtchFileNm, String otiBdAtchFileNm, String trfTitAtchFileNm, String poaAtchFileNm
			, String otiLicAtchFileNmOrg, String otiBdAtchFileNmOrg, String trfTitAtchFileNmOrg, String poaAtchFileNmOrg,String mocLicNo) {
		this.acptDt = acptDt;
		this.acptOfcCd = acptOfcCd;
		this.amdtSeq = amdtSeq;
		this.prcProgStsNm = prcProgStsNm;
		this.acptUsrId = acptUsrId;
		this.srcInfoCd = srcInfoCd;
		this.srcInfoNm = srcInfoNm;
		this.ctrtPtySgnTitNm = ctrtPtySgnTitNm;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.prcProgStsCd = prcProgStsCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
		this.ctrtPtyNm = ctrtPtyNm;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.prcCtrtPtyTpCd = prcCtrtPtyTpCd;
		this.propNo = propNo;
		this.ctrtPtyAddr = ctrtPtyAddr;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.expDt = expDt;
		this.ctrtPtySgnNm = ctrtPtySgnNm;
		this.custCntCd = custCntCd;
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
		this.nvoccBdNo = nvoccBdNo;
		this.nvoccLicNo = nvoccLicNo;
		this.otiLicAtchFileId = otiLicAtchFileId;
		this.otiBdAtchFileId = otiBdAtchFileId;
		this.trfTitAtchFileId = trfTitAtchFileId;
		this.poaAtchFileId = poaAtchFileId;
		this.otiLicAtchFileNm = otiLicAtchFileNm;
		this.otiBdAtchFileNm = otiBdAtchFileNm;
		this.trfTitAtchFileNm = trfTitAtchFileNm;
		this.poaAtchFileNm = poaAtchFileNm;
		this.otiLicAtchFileNmOrg = otiLicAtchFileNmOrg;
		this.otiBdAtchFileNmOrg = otiBdAtchFileNmOrg;
		this.trfTitAtchFileNmOrg = trfTitAtchFileNmOrg;
		this.poaAtchFileNmOrg = poaAtchFileNmOrg;
		this.mocLicNo = mocLicNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prc_prog_sts_nm", getPrcProgStsNm());
		this.hashColumns.put("acpt_usr_id", getAcptUsrId());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("src_info_nm", getSrcInfoNm());
		this.hashColumns.put("ctrt_pty_sgn_tit_nm", getCtrtPtySgnTitNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_cust_sls_ofc_cd", getCtrtCustSlsOfcCd());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prc_ctrt_pty_tp_cd", getPrcCtrtPtyTpCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("ctrt_pty_addr", getCtrtPtyAddr());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ctrt_pty_sgn_nm", getCtrtPtySgnNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ctrt_cust_val_sgm_cd", getCtrtCustValSgmCd());
		this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
		this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
		this.hashColumns.put("oti_lic_atch_file_id", getOtiLicAtchFileId());
		this.hashColumns.put("oti_bd_atch_file_id", getOtiBdAtchFileId());
		this.hashColumns.put("trf_tit_atch_file_id", getTrfTitAtchFileId());
		this.hashColumns.put("poa_atch_file_id", getPoaAtchFileId());
		this.hashColumns.put("oti_lic_atch_file_nm", getOtiLicAtchFileNm());
		this.hashColumns.put("oti_bd_atch_file_nm", getOtiBdAtchFileNm());
		this.hashColumns.put("trf_tit_atch_file_nm", getTrfTitAtchFileNm());
		this.hashColumns.put("poa_atch_file_nm", getPoaAtchFileNm());
		this.hashColumns.put("oti_lic_atch_file_nm_org", getOtiLicAtchFileNmOrg());
		this.hashColumns.put("oti_bd_atch_file_nm_org", getOtiBdAtchFileNmOrg());
		this.hashColumns.put("trf_tit_atch_file_nm_org", getTrfTitAtchFileNmOrg());
		this.hashColumns.put("poa_atch_file_nm_org", getPoaAtchFileNmOrg());
		this.hashColumns.put("moc_lic_no", getMocLicNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prc_prog_sts_nm", "prcProgStsNm");
		this.hashFields.put("acpt_usr_id", "acptUsrId");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("src_info_nm", "srcInfoNm");
		this.hashFields.put("ctrt_pty_sgn_tit_nm", "ctrtPtySgnTitNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_cust_sls_ofc_cd", "ctrtCustSlsOfcCd");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prc_ctrt_pty_tp_cd", "prcCtrtPtyTpCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("ctrt_pty_addr", "ctrtPtyAddr");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ctrt_pty_sgn_nm", "ctrtPtySgnNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ctrt_cust_val_sgm_cd", "ctrtCustValSgmCd");
		this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
		this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
		this.hashFields.put("oti_lic_atch_file_id", "otiLicAtchFileId");
		this.hashFields.put("oti_bd_atch_file_id", "otiBdAtchFileId");
		this.hashFields.put("trf_tit_atch_file_id", "trfTitAtchFileId");
		this.hashFields.put("poa_atch_file_id", "poaAtchFileId");
		this.hashFields.put("oti_lic_atch_file_nm", "otiLicAtchFileNm");
		this.hashFields.put("oti_bd_atch_file_nm", "otiBdAtchFileNm");
		this.hashFields.put("trf_tit_atch_file_nm", "trfTitAtchFileNm");
		this.hashFields.put("poa_atch_file_nm", "poaAtchFileNm");
		this.hashFields.put("oti_lic_atch_file_nm_org", "otiLicAtchFileNmOrg");
		this.hashFields.put("oti_bd_atch_file_nm_org", "otiBdAtchFileNmOrg");
		this.hashFields.put("trf_tit_atch_file_nm_org", "trfTitAtchFileNmOrg");
		this.hashFields.put("poa_atch_file_nm_org", "poaAtchFileNmOrg");
		this.hashFields.put("moc_lic_no", "mocLicNo");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
	}
	
	/**
	 * Column Info
	 * @return acptOfcCd
	 */
	public String getAcptOfcCd() {
		return this.acptOfcCd;
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
	 * @return prcProgStsNm
	 */
	public String getPrcProgStsNm() {
		return this.prcProgStsNm;
	}
	
	/**
	 * Column Info
	 * @return acptUsrId
	 */
	public String getAcptUsrId() {
		return this.acptUsrId;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return srcInfoNm
	 */
	public String getSrcInfoNm() {
		return this.srcInfoNm;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
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
	 * @return ctrtCustSlsOfcCd
	 */
	public String getCtrtCustSlsOfcCd() {
		return this.ctrtCustSlsOfcCd;
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
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
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
	 * @return ctrtPtySgnNm
	 */
	public String getCtrtPtySgnNm() {
		return this.ctrtPtySgnNm;
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
	 * @return ctrtCustValSgmCd
	 */
	public String getCtrtCustValSgmCd() {
		return this.ctrtCustValSgmCd;
	}
	

	/**
	 * Column Info
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
	}
	
	/**
	 * Column Info
	 * @param acptOfcCd
	 */
	public void setAcptOfcCd(String acptOfcCd) {
		this.acptOfcCd = acptOfcCd;
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
	 * @param prcProgStsNm
	 */
	public void setPrcProgStsNm(String prcProgStsNm) {
		this.prcProgStsNm = prcProgStsNm;
	}
	
	/**
	 * Column Info
	 * @param acptUsrId
	 */
	public void setAcptUsrId(String acptUsrId) {
		this.acptUsrId = acptUsrId;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param srcInfoNm
	 */
	public void setSrcInfoNm(String srcInfoNm) {
		this.srcInfoNm = srcInfoNm;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
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
	 * @param ctrtCustSlsOfcCd
	 */
	public void setCtrtCustSlsOfcCd(String ctrtCustSlsOfcCd) {
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
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
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
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
	 * @param ctrtPtySgnNm
	 */
	public void setCtrtPtySgnNm(String ctrtPtySgnNm) {
		this.ctrtPtySgnNm = ctrtPtySgnNm;
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
	 * @param ctrtCustValSgmCd
	 */
	public void setCtrtCustValSgmCd(String ctrtCustValSgmCd) {
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}
	
	/**
	 * Column Info
	 * @return nvoccBdNo
	 */
	public String getNvoccBdNo() {
		return nvoccBdNo;
	}

	/**
	 * Column Info
	 * @param nvoccBdNo
	 */
	public void setNvoccBdNo(String nvoccBdNo) {
		this.nvoccBdNo = nvoccBdNo;
	}

	/**
	 * Column Info
	 * @return nvoccLicNo
	 */
	public String getNvoccLicNo() {
		return nvoccLicNo;
	}

	/**
	 * Column Info
	 * @param nvoccLicNo
	 */
	public void setNvoccLicNo(String nvoccLicNo) {
		this.nvoccLicNo = nvoccLicNo;
	}

	/**
	 * Column Info
	 * @return otiLicAtchFileId
	 */
	public String getOtiLicAtchFileId() {
		return this.otiLicAtchFileId;
	}
	
	/**
	 * Column Info
	 * @return otiBdAtchFileId
	 */
	public String getOtiBdAtchFileId() {
		return this.otiBdAtchFileId;
	}
	
	/**
	 * Column Info
	 * @return trfTitAtchFileId
	 */
	public String getTrfTitAtchFileId() {
		return this.trfTitAtchFileId;
	}
	
	/**
	 * Column Info
	 * @return poaAtchFileId
	 */
	public String getPoaAtchFileId() {
		return this.poaAtchFileId;
	}
	
	/**
	 * Column Info
	 * @param otiLicAtchFileId
	 */
	public void setOtiLicAtchFileId(String otiLicAtchFileId) {
		this.otiLicAtchFileId = otiLicAtchFileId;
	}
	
	/**
	 * Column Info
	 * @param otiBdAtchFileId
	 */
	public void setOtiBdAtchFileId(String otiBdAtchFileId) {
		this.otiBdAtchFileId = otiBdAtchFileId;
	}
	
	/**
	 * Column Info
	 * @param trfTitAtchFileId
	 */
	public void setTrfTitAtchFileId(String trfTitAtchFileId) {
		this.trfTitAtchFileId = trfTitAtchFileId;
	}
	
	/**
	 * Column Info
	 * @param poaAtchFileId
	 */
	public void setPoaAtchFileId(String poaAtchFileId) {
		this.poaAtchFileId = poaAtchFileId;
	}
	
	/**
	 * Column Info
	 * @return otiLicAtchFileNm
	 */
	public String getOtiLicAtchFileNm() {
		return this.otiLicAtchFileNm;
	}
	
	/**
	 * Column Info
	 * @return otiBdAtchFileNm
	 */
	public String getOtiBdAtchFileNm() {
		return this.otiBdAtchFileNm;
	}
	
	/**
	 * Column Info
	 * @return trfTitAtchFileNm
	 */
	public String getTrfTitAtchFileNm() {
		return this.trfTitAtchFileNm;
	}
	
	/**
	 * Column Info
	 * @return poaAtchFileNm
	 */
	public String getPoaAtchFileNm() {
		return this.poaAtchFileNm;
	}
	
	/**
	 * Column Info
	 * @param otiLicAtchFileNm
	 */
	public void setOtiLicAtchFileNm(String otiLicAtchFileNm) {
		this.otiLicAtchFileNm = otiLicAtchFileNm;
	}
	
	/**
	 * Column Info
	 * @param otiBdAtchFileNm
	 */
	public void setOtiBdAtchFileNm(String otiBdAtchFileNm) {
		this.otiBdAtchFileNm = otiBdAtchFileNm;
	}
	
	/**
	 * Column Info
	 * @param trfTitAtchFileNm
	 */
	public void setTrfTitAtchFileNm(String trfTitAtchFileNm) {
		this.trfTitAtchFileNm = trfTitAtchFileNm;
	}
	
	/**
	 * Column Info
	 * @param poaAtchFileNm
	 */
	public void setPoaAtchFileNm(String poaAtchFileNm) {
		this.poaAtchFileNm = poaAtchFileNm;
	}
	
	/**
	 * Column Info
	 * @return otiLicAtchFileNmOrg
	 */
	public String getOtiLicAtchFileNmOrg() {
		return this.otiLicAtchFileNmOrg;
	}
	
	/**
	 * Column Info
	 * @return otiBdAtchFileNmOrg
	 */
	public String getOtiBdAtchFileNmOrg() {
		return this.otiBdAtchFileNmOrg;
	}
	
	/**
	 * Column Info
	 * @return trfTitAtchFileNmOrg
	 */
	public String getTrfTitAtchFileNmOrg() {
		return this.trfTitAtchFileNmOrg;
	}
	
	/**
	 * Column Info
	 * @return poaAtchFileNmOrg
	 */
	public String getPoaAtchFileNmOrg() {
		return this.poaAtchFileNmOrg;
	}
	
	/**
	 * Column Info
	 * @return mocLicNo
	 */
	public String getMocLicNo() {
		return this.mocLicNo;
	}
	
	/**
	 * Column Info
	 * @param otiLicAtchFileNmOrg
	 */
	public void setOtiLicAtchFileNmOrg(String otiLicAtchFileNmOrg) {
		this.otiLicAtchFileNmOrg = otiLicAtchFileNmOrg;
	}
	
	/**
	 * Column Info
	 * @param otiBdAtchFileNmOrg
	 */
	public void setOtiBdAtchFileNmOrg(String otiBdAtchFileNmOrg) {
		this.otiBdAtchFileNmOrg = otiBdAtchFileNmOrg;
	}
	
	
	/**
	 * Column Info
	 * @param trfTitAtchFileNmOrg
	 */
	public void setTrfTitAtchFileNmOrg(String trfTitAtchFileNmOrg) {
		this.trfTitAtchFileNmOrg = trfTitAtchFileNmOrg;
	}
	
	/**
	 * Column Info
	 * @param poaAtchFileNmOrg
	 */
	public void setPoaAtchFileNmOrg(String poaAtchFileNmOrg) {
		this.poaAtchFileNmOrg = poaAtchFileNmOrg;
	}
	
	/**
	 * Column Info
	 * @param mocLicNo
	 */
	public void setMocLicNo(String mocLicNo) {
		this.mocLicNo = mocLicNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAcptDt(JSPUtil.getParameter(request, "acpt_dt", ""));
		setAcptOfcCd(JSPUtil.getParameter(request, "acpt_ofc_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPrcProgStsNm(JSPUtil.getParameter(request, "prc_prog_sts_nm", ""));
		setAcptUsrId(JSPUtil.getParameter(request, "acpt_usr_id", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, "src_info_cd", ""));
		setSrcInfoNm(JSPUtil.getParameter(request, "src_info_nm", ""));
		setCtrtPtySgnTitNm(JSPUtil.getParameter(request, "ctrt_pty_sgn_tit_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, "prc_prog_sts_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtCustSlsOfcCd(JSPUtil.getParameter(request, "ctrt_cust_sls_ofc_cd", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, "n1st_cmnc_amdt_seq", ""));
		setPrcCtrtPtyTpCd(JSPUtil.getParameter(request, "prc_ctrt_pty_tp_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCtrtPtyAddr(JSPUtil.getParameter(request, "ctrt_pty_addr", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, "ctrt_cust_srep_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCtrtPtySgnNm(JSPUtil.getParameter(request, "ctrt_pty_sgn_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCtrtCustValSgmCd(JSPUtil.getParameter(request, "ctrt_cust_val_sgm_cd", ""));
		setNvoccBdNo(JSPUtil.getParameter(request, "nvocc_bd_no", ""));
		setNvoccLicNo(JSPUtil.getParameter(request, "nvocc_lic_no", ""));
		setOtiLicAtchFileId(JSPUtil.getParameter(request, "oti_lic_atch_file_id", ""));
		setOtiBdAtchFileId(JSPUtil.getParameter(request, "oti_bd_atch_file_id", ""));
		setTrfTitAtchFileId(JSPUtil.getParameter(request, "trf_tit_atch_file_id", ""));
		setPoaAtchFileId(JSPUtil.getParameter(request, "poa_atch_file_id", ""));
		setOtiLicAtchFileNm(JSPUtil.getParameter(request, "oti_lic_atch_file_nm", ""));
		setOtiBdAtchFileNm(JSPUtil.getParameter(request, "oti_bd_atch_file_nm", ""));
		setTrfTitAtchFileNm(JSPUtil.getParameter(request, "trf_tit_atch_file_nm", ""));
		setPoaAtchFileNm(JSPUtil.getParameter(request, "poa_atch_file_nm", ""));
		setOtiLicAtchFileNmOrg(JSPUtil.getParameter(request, "oti_lic_atch_file_nm_org", ""));
		setOtiBdAtchFileNmOrg(JSPUtil.getParameter(request, "oti_bd_atch_file_nm_org", ""));
		setTrfTitAtchFileNmOrg(JSPUtil.getParameter(request, "trf_tit_atch_file_nm_org", ""));
		setPoaAtchFileNmOrg(JSPUtil.getParameter(request, "poa_atch_file_nm_org", ""));
		setMocLicNo(JSPUtil.getParameter(request, "moc_lic_no", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpCtrtPtyVO[]
	 */
	public RsltPriSpCtrtPtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpCtrtPtyVO[]
	 */
	public RsltPriSpCtrtPtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpCtrtPtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] acptOfcCd = (JSPUtil.getParameter(request, prefix	+ "acpt_ofc_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] prcProgStsNm = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_nm", length));
			String[] acptUsrId = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_id", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] srcInfoNm = (JSPUtil.getParameter(request, prefix	+ "src_info_nm", length));
			String[] ctrtPtySgnTitNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_sgn_tit_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_sls_ofc_cd", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] prcCtrtPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_pty_tp_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] ctrtPtyAddr = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_addr", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ctrtPtySgnNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_sgn_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ctrtCustValSgmCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm_cd", length));
			String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_no", length));
			String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_lic_no", length));
			String[] otiLicAtchFileId = (JSPUtil.getParameter(request, prefix	+ "oti_lic_atch_file_id", length));
			String[] otiBdAtchFileId = (JSPUtil.getParameter(request, prefix	+ "oti_bd_atch_file_id", length));
			String[] trfTitAtchFileId = (JSPUtil.getParameter(request, prefix	+ "trf_tit_atch_file_id", length));
			String[] poaAtchFileId = (JSPUtil.getParameter(request, prefix	+ "poa_atch_file_id", length));
			String[] otiLicAtchFileNm = (JSPUtil.getParameter(request, prefix	+ "oti_lic_atch_file_nm", length));
			String[] otiBdAtchFileNm = (JSPUtil.getParameter(request, prefix	+ "oti_bd_atch_file_nm", length));
			String[] trfTitAtchFileNm = (JSPUtil.getParameter(request, prefix	+ "trf_tit_atch_file_nm", length));
			String[] poaAtchFileNm = (JSPUtil.getParameter(request, prefix	+ "poa_atch_file_nm", length));
			String[] otiLicAtchFileNmOrg = (JSPUtil.getParameter(request, prefix	+ "oti_lic_atch_file_nm_org", length));
			String[] otiBdAtchFileNmOrg = (JSPUtil.getParameter(request, prefix	+ "oti_bd_atch_file_nm_org", length));
			String[] trfTitAtchFileNmOrg = (JSPUtil.getParameter(request, prefix	+ "trf_tit_atch_file_nm_org", length));
			String[] poaAtchFileNmOrg = (JSPUtil.getParameter(request, prefix	+ "poa_atch_file_nm_org", length));
			String[] mocLicNo = (JSPUtil.getParameter(request, prefix	+ "moc_lic_no", length));

			for (int i = 0; i < length; i++) {
				model = new RsltPriSpCtrtPtyVO();
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (acptOfcCd[i] != null)
					model.setAcptOfcCd(acptOfcCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (prcProgStsNm[i] != null)
					model.setPrcProgStsNm(prcProgStsNm[i]);
				if (acptUsrId[i] != null)
					model.setAcptUsrId(acptUsrId[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (srcInfoNm[i] != null)
					model.setSrcInfoNm(srcInfoNm[i]);
				if (ctrtPtySgnTitNm[i] != null)
					model.setCtrtPtySgnTitNm(ctrtPtySgnTitNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtCustSlsOfcCd[i] != null)
					model.setCtrtCustSlsOfcCd(ctrtCustSlsOfcCd[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (prcCtrtPtyTpCd[i] != null)
					model.setPrcCtrtPtyTpCd(prcCtrtPtyTpCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (ctrtPtyAddr[i] != null)
					model.setCtrtPtyAddr(ctrtPtyAddr[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ctrtPtySgnNm[i] != null)
					model.setCtrtPtySgnNm(ctrtPtySgnNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ctrtCustValSgmCd[i] != null)
					model.setCtrtCustValSgmCd(ctrtCustValSgmCd[i]);
				if (nvoccBdNo[i] != null)
					model.setNvoccBdNo(nvoccBdNo[i]);
				if (nvoccLicNo[i] != null)
					model.setNvoccLicNo(nvoccLicNo[i]);
				if (otiLicAtchFileId[i] != null)
					model.setOtiLicAtchFileId(otiLicAtchFileId[i]);
				if (otiBdAtchFileId[i] != null)
					model.setOtiBdAtchFileId(otiBdAtchFileId[i]);
				if (trfTitAtchFileId[i] != null)
					model.setTrfTitAtchFileId(trfTitAtchFileId[i]);
				if (poaAtchFileId[i] != null)
					model.setPoaAtchFileId(poaAtchFileId[i]);
				if (otiLicAtchFileNm[i] != null)
					model.setOtiLicAtchFileNm(otiLicAtchFileNm[i]);
				if (otiBdAtchFileNm[i] != null)
					model.setOtiBdAtchFileNm(otiBdAtchFileNm[i]);
				if (trfTitAtchFileNm[i] != null)
					model.setTrfTitAtchFileNm(trfTitAtchFileNm[i]);
				if (poaAtchFileNm[i] != null)
					model.setPoaAtchFileNm(poaAtchFileNm[i]);
				if (otiLicAtchFileNmOrg[i] != null)
					model.setOtiLicAtchFileNmOrg(otiLicAtchFileNmOrg[i]);
				if (otiBdAtchFileNmOrg[i] != null)
					model.setOtiBdAtchFileNmOrg(otiBdAtchFileNmOrg[i]);
				if (trfTitAtchFileNmOrg[i] != null)
					model.setTrfTitAtchFileNmOrg(trfTitAtchFileNmOrg[i]);
				if (poaAtchFileNmOrg[i] != null)
					model.setPoaAtchFileNmOrg(poaAtchFileNmOrg[i]);
				if (mocLicNo[i] != null)
					model.setMocLicNo(mocLicNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpCtrtPtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpCtrtPtyVO[]
	 */
	public RsltPriSpCtrtPtyVO[] getRsltPriSpCtrtPtyVOs(){
		RsltPriSpCtrtPtyVO[] vos = (RsltPriSpCtrtPtyVO[])models.toArray(new RsltPriSpCtrtPtyVO[models.size()]);
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
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd = this.acptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsNm = this.prcProgStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrId = this.acptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoNm = this.srcInfoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnTitNm = this.ctrtPtySgnTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSlsOfcCd = this.ctrtCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtPtyTpCd = this.prcCtrtPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyAddr = this.ctrtPtyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnNm = this.ctrtPtySgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgmCd = this.ctrtCustValSgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdNo = this.nvoccBdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccLicNo = this.nvoccLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiLicAtchFileId = this.otiLicAtchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiBdAtchFileId = this.otiBdAtchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfTitAtchFileId = this.trfTitAtchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiLicAtchFileNm = this.otiLicAtchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiBdAtchFileNm = this.otiBdAtchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfTitAtchFileNm = this.trfTitAtchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poaAtchFileNm = this.poaAtchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiLicAtchFileNmOrg = this.otiLicAtchFileNmOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiBdAtchFileNmOrg = this.otiBdAtchFileNmOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfTitAtchFileNmOrg = this.trfTitAtchFileNmOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poaAtchFileNmOrg = this.poaAtchFileNmOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mocLicNo = this.mocLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
