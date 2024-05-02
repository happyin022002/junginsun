/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpAfilVO.java
*@FileTitle : RsltPriSpAfilVO
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
* 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직  (rvisCntrCustTpNm추가)
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class RsltPriSpAfilVO extends AbstractValueObject { 

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpAfilVO> models = new ArrayList<RsltPriSpAfilVO>();
	
	/* Column Info */
	private String scAfilTpCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String afilRgstRqstLtrNm = null;
	/* Column Info */
	private String trfTitAtchFileNm = null;
	/* Column Info */
	private String srcInfoDtl = null;
	/* Column Info */
	private String custLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String afilRgstRqstLtrId = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* Column Info */
	private String otiBdAtchFileNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String otiLicAtchFileId = null;
	/* Column Info */
	private String rvisCntrCustTpNm = null;
	/* Column Info */
	private String prcProgStsDtl = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String acptOfcCd = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String nvoccLicNo = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String acptUsrId = null;
	/* Column Info */
	private String otiBdAtchFileId = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String trfTitAtchFileId = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String nvoccBdNo = null;
	/* Column Info */
	private String mnlInpFlg = null;
	/* Column Info */
	private String otiLicAtchFileNm = null;
	/* Column Info */
	private String afilSeq = null;
	/* Column Info */
	private String mocLicNo = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltPriSpAfilVO() {}

	public RsltPriSpAfilVO(String ibflag, String pagerows, String acptDt, String acptOfcCd, String custNm, String amdtSeq, String acptUsrId, String srcInfoCd, String custAddr, String srcInfoDtl, String custSeq, String custLocCd, String prcProgStsCd, String effDt, String n1stCmncAmdtSeq, String propNo, String mnlInpFlg, String prcProgStsDtl, String expDt, String afilSeq, String custCntCd, String nvoccBdNo, String nvoccLicNo, String otiLicAtchFileId, String otiBdAtchFileId, String trfTitAtchFileId, String otiLicAtchFileNm, String otiBdAtchFileNm, String trfTitAtchFileNm, String rvisCntrCustTpNm, String scAfilTpCd, String afilRgstRqstLtrId, String afilRgstRqstLtrNm, String mocLicNo) {
		this.scAfilTpCd = scAfilTpCd;
		this.custNm = custNm;
		this.amdtSeq = amdtSeq;
		this.afilRgstRqstLtrNm = afilRgstRqstLtrNm;
		this.trfTitAtchFileNm = trfTitAtchFileNm;
		this.srcInfoDtl = srcInfoDtl;
		this.custLocCd = custLocCd;
		this.pagerows = pagerows;
		this.afilRgstRqstLtrId = afilRgstRqstLtrId;
		this.prcProgStsCd = prcProgStsCd;
		this.otiBdAtchFileNm = otiBdAtchFileNm;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.otiLicAtchFileId = otiLicAtchFileId;
		this.rvisCntrCustTpNm = rvisCntrCustTpNm;
		this.prcProgStsDtl = prcProgStsDtl;
		this.expDt = expDt;
		this.custCntCd = custCntCd;
		this.acptOfcCd = acptOfcCd;
		this.acptDt = acptDt;
		this.nvoccLicNo = nvoccLicNo;
		this.srcInfoCd = srcInfoCd;
		this.acptUsrId = acptUsrId;
		this.otiBdAtchFileId = otiBdAtchFileId;
		this.custAddr = custAddr;
		this.custSeq = custSeq;
		this.trfTitAtchFileId = trfTitAtchFileId;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
		this.nvoccBdNo = nvoccBdNo;
		this.mnlInpFlg = mnlInpFlg;
		this.otiLicAtchFileNm = otiLicAtchFileNm;
		this.afilSeq = afilSeq;
		this.mocLicNo = mocLicNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sc_afil_tp_cd", getScAfilTpCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("afil_rgst_rqst_ltr_nm", getAfilRgstRqstLtrNm());
		this.hashColumns.put("trf_tit_atch_file_nm", getTrfTitAtchFileNm());
		this.hashColumns.put("src_info_dtl", getSrcInfoDtl());
		this.hashColumns.put("cust_loc_cd", getCustLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("afil_rgst_rqst_ltr_id", getAfilRgstRqstLtrId());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("oti_bd_atch_file_nm", getOtiBdAtchFileNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("oti_lic_atch_file_id", getOtiLicAtchFileId());
		this.hashColumns.put("rvis_cntr_cust_tp_nm", getRvisCntrCustTpNm());
		this.hashColumns.put("prc_prog_sts_dtl", getPrcProgStsDtl());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("acpt_usr_id", getAcptUsrId());
		this.hashColumns.put("oti_bd_atch_file_id", getOtiBdAtchFileId());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("trf_tit_atch_file_id", getTrfTitAtchFileId());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
		this.hashColumns.put("mnl_inp_flg", getMnlInpFlg());
		this.hashColumns.put("oti_lic_atch_file_nm", getOtiLicAtchFileNm());
		this.hashColumns.put("afil_seq", getAfilSeq());
		this.hashColumns.put("moc_lic_no", getMocLicNo());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sc_afil_tp_cd", "scAfilTpCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("afil_rgst_rqst_ltr_nm", "afilRgstRqstLtrNm");
		this.hashFields.put("trf_tit_atch_file_nm", "trfTitAtchFileNm");
		this.hashFields.put("src_info_dtl", "srcInfoDtl");
		this.hashFields.put("cust_loc_cd", "custLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("afil_rgst_rqst_ltr_id", "afilRgstRqstLtrId");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("oti_bd_atch_file_nm", "otiBdAtchFileNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("oti_lic_atch_file_id", "otiLicAtchFileId");
		this.hashFields.put("rvis_cntr_cust_tp_nm", "rvisCntrCustTpNm");
		this.hashFields.put("prc_prog_sts_dtl", "prcProgStsDtl");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("acpt_usr_id", "acptUsrId");
		this.hashFields.put("oti_bd_atch_file_id", "otiBdAtchFileId");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("trf_tit_atch_file_id", "trfTitAtchFileId");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
		this.hashFields.put("mnl_inp_flg", "mnlInpFlg");
		this.hashFields.put("oti_lic_atch_file_nm", "otiLicAtchFileNm");
		this.hashFields.put("afil_seq", "afilSeq");
		this.hashFields.put("moc_lic_no", "mocLicNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scAfilTpCd
	 */
	public String getScAfilTpCd() {
		return this.scAfilTpCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return afilRgstRqstLtrNm
	 */
	public String getAfilRgstRqstLtrNm() {
		return this.afilRgstRqstLtrNm;
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
	 * @return srcInfoDtl
	 */
	public String getSrcInfoDtl() {
		return this.srcInfoDtl;
	}
	
	/**
	 * Column Info
	 * @return custLocCd
	 */
	public String getCustLocCd() {
		return this.custLocCd;
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
	 * @return afilRgstRqstLtrId
	 */
	public String getAfilRgstRqstLtrId() {
		return this.afilRgstRqstLtrId;
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
	 * @return otiBdAtchFileNm
	 */
	public String getOtiBdAtchFileNm() {
		return this.otiBdAtchFileNm;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return rvisCntrCustTpNm
	 */
	public String getRvisCntrCustTpNm() {
		return this.rvisCntrCustTpNm;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsDtl
	 */
	public String getPrcProgStsDtl() {
		return this.prcProgStsDtl;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
	}
	
	/**
	 * Column Info
	 * @return nvoccLicNo
	 */
	public String getNvoccLicNo() {
		return this.nvoccLicNo;
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
	 * @return acptUsrId
	 */
	public String getAcptUsrId() {
		return this.acptUsrId;
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
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
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
	 * @return trfTitAtchFileId
	 */
	public String getTrfTitAtchFileId() {
		return this.trfTitAtchFileId;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return nvoccBdNo
	 */
	public String getNvoccBdNo() {
		return this.nvoccBdNo;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlg
	 */
	public String getMnlInpFlg() {
		return this.mnlInpFlg;
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
	 * @return afilSeq
	 */
	public String getAfilSeq() {
		return this.afilSeq;
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
	 * @param scAfilTpCd
	 */
	public void setScAfilTpCd(String scAfilTpCd) {
		this.scAfilTpCd = scAfilTpCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param afilRgstRqstLtrNm
	 */
	public void setAfilRgstRqstLtrNm(String afilRgstRqstLtrNm) {
		this.afilRgstRqstLtrNm = afilRgstRqstLtrNm;
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
	 * @param srcInfoDtl
	 */
	public void setSrcInfoDtl(String srcInfoDtl) {
		this.srcInfoDtl = srcInfoDtl;
	}
	
	/**
	 * Column Info
	 * @param custLocCd
	 */
	public void setCustLocCd(String custLocCd) {
		this.custLocCd = custLocCd;
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
	 * @param afilRgstRqstLtrId
	 */
	public void setAfilRgstRqstLtrId(String afilRgstRqstLtrId) {
		this.afilRgstRqstLtrId = afilRgstRqstLtrId;
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
	 * @param otiBdAtchFileNm
	 */
	public void setOtiBdAtchFileNm(String otiBdAtchFileNm) {
		this.otiBdAtchFileNm = otiBdAtchFileNm;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param rvisCntrCustTpNm
	 */
	public void setRvisCntrCustTpNm(String rvisCntrCustTpNm) {
		this.rvisCntrCustTpNm = rvisCntrCustTpNm;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsDtl
	 */
	public void setPrcProgStsDtl(String prcProgStsDtl) {
		this.prcProgStsDtl = prcProgStsDtl;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
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
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
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
	 * @param otiBdAtchFileId
	 */
	public void setOtiBdAtchFileId(String otiBdAtchFileId) {
		this.otiBdAtchFileId = otiBdAtchFileId;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
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
	 * @param trfTitAtchFileId
	 */
	public void setTrfTitAtchFileId(String trfTitAtchFileId) {
		this.trfTitAtchFileId = trfTitAtchFileId;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
	 * @param mnlInpFlg
	 */
	public void setMnlInpFlg(String mnlInpFlg) {
		this.mnlInpFlg = mnlInpFlg;
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
	 * @param afilSeq
	 */
	public void setAfilSeq(String afilSeq) {
		this.afilSeq = afilSeq;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setScAfilTpCd(JSPUtil.getParameter(request, prefix + "sc_afil_tp_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setAfilRgstRqstLtrNm(JSPUtil.getParameter(request, prefix + "afil_rgst_rqst_ltr_nm", ""));
		setTrfTitAtchFileNm(JSPUtil.getParameter(request, prefix + "trf_tit_atch_file_nm", ""));
		setSrcInfoDtl(JSPUtil.getParameter(request, prefix + "src_info_dtl", ""));
		setCustLocCd(JSPUtil.getParameter(request, prefix + "cust_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAfilRgstRqstLtrId(JSPUtil.getParameter(request, prefix + "afil_rgst_rqst_ltr_id", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, prefix + "prc_prog_sts_cd", ""));
		setOtiBdAtchFileNm(JSPUtil.getParameter(request, prefix + "oti_bd_atch_file_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setOtiLicAtchFileId(JSPUtil.getParameter(request, prefix + "oti_lic_atch_file_id", ""));
		setRvisCntrCustTpNm(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_nm", ""));
		setPrcProgStsDtl(JSPUtil.getParameter(request, prefix + "prc_prog_sts_dtl", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setAcptOfcCd(JSPUtil.getParameter(request, prefix + "acpt_ofc_cd", ""));
		setAcptDt(JSPUtil.getParameter(request, prefix + "acpt_dt", ""));
		setNvoccLicNo(JSPUtil.getParameter(request, prefix + "nvocc_lic_no", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setAcptUsrId(JSPUtil.getParameter(request, prefix + "acpt_usr_id", ""));
		setOtiBdAtchFileId(JSPUtil.getParameter(request, prefix + "oti_bd_atch_file_id", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setTrfTitAtchFileId(JSPUtil.getParameter(request, prefix + "trf_tit_atch_file_id", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setNvoccBdNo(JSPUtil.getParameter(request, prefix + "nvocc_bd_no", ""));
		setMnlInpFlg(JSPUtil.getParameter(request, prefix + "mnl_inp_flg", ""));
		setOtiLicAtchFileNm(JSPUtil.getParameter(request, prefix + "oti_lic_atch_file_nm", ""));
		setAfilSeq(JSPUtil.getParameter(request, prefix + "afil_seq", ""));
		setMocLicNo(JSPUtil.getParameter(request, prefix + "moc_lic_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpAfilVO[]
	 */
	public RsltPriSpAfilVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpAfilVO[]
	 */
	public RsltPriSpAfilVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpAfilVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scAfilTpCd = (JSPUtil.getParameter(request, prefix	+ "sc_afil_tp_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] afilRgstRqstLtrNm = (JSPUtil.getParameter(request, prefix	+ "afil_rgst_rqst_ltr_nm", length));
			String[] trfTitAtchFileNm = (JSPUtil.getParameter(request, prefix	+ "trf_tit_atch_file_nm", length));
			String[] srcInfoDtl = (JSPUtil.getParameter(request, prefix	+ "src_info_dtl", length));
			String[] custLocCd = (JSPUtil.getParameter(request, prefix	+ "cust_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] afilRgstRqstLtrId = (JSPUtil.getParameter(request, prefix	+ "afil_rgst_rqst_ltr_id", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] otiBdAtchFileNm = (JSPUtil.getParameter(request, prefix	+ "oti_bd_atch_file_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] otiLicAtchFileId = (JSPUtil.getParameter(request, prefix	+ "oti_lic_atch_file_id", length));
			String[] rvisCntrCustTpNm = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_nm", length));
			String[] prcProgStsDtl = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_dtl", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] acptOfcCd = (JSPUtil.getParameter(request, prefix	+ "acpt_ofc_cd", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_lic_no", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] acptUsrId = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_id", length));
			String[] otiBdAtchFileId = (JSPUtil.getParameter(request, prefix	+ "oti_bd_atch_file_id", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] trfTitAtchFileId = (JSPUtil.getParameter(request, prefix	+ "trf_tit_atch_file_id", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_no", length));
			String[] mnlInpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg", length));
			String[] otiLicAtchFileNm = (JSPUtil.getParameter(request, prefix	+ "oti_lic_atch_file_nm", length));
			String[] afilSeq = (JSPUtil.getParameter(request, prefix	+ "afil_seq", length));
			String[] mocLicNo = (JSPUtil.getParameter(request, prefix	+ "moc_lic_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpAfilVO();
				if (scAfilTpCd[i] != null)
					model.setScAfilTpCd(scAfilTpCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (afilRgstRqstLtrNm[i] != null)
					model.setAfilRgstRqstLtrNm(afilRgstRqstLtrNm[i]);
				if (trfTitAtchFileNm[i] != null)
					model.setTrfTitAtchFileNm(trfTitAtchFileNm[i]);
				if (srcInfoDtl[i] != null)
					model.setSrcInfoDtl(srcInfoDtl[i]);
				if (custLocCd[i] != null)
					model.setCustLocCd(custLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (afilRgstRqstLtrId[i] != null)
					model.setAfilRgstRqstLtrId(afilRgstRqstLtrId[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (otiBdAtchFileNm[i] != null)
					model.setOtiBdAtchFileNm(otiBdAtchFileNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (otiLicAtchFileId[i] != null)
					model.setOtiLicAtchFileId(otiLicAtchFileId[i]);
				if (rvisCntrCustTpNm[i] != null)
					model.setRvisCntrCustTpNm(rvisCntrCustTpNm[i]);
				if (prcProgStsDtl[i] != null)
					model.setPrcProgStsDtl(prcProgStsDtl[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (acptOfcCd[i] != null)
					model.setAcptOfcCd(acptOfcCd[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (nvoccLicNo[i] != null)
					model.setNvoccLicNo(nvoccLicNo[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (acptUsrId[i] != null)
					model.setAcptUsrId(acptUsrId[i]);
				if (otiBdAtchFileId[i] != null)
					model.setOtiBdAtchFileId(otiBdAtchFileId[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (trfTitAtchFileId[i] != null)
					model.setTrfTitAtchFileId(trfTitAtchFileId[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (nvoccBdNo[i] != null)
					model.setNvoccBdNo(nvoccBdNo[i]);
				if (mnlInpFlg[i] != null)
					model.setMnlInpFlg(mnlInpFlg[i]);
				if (otiLicAtchFileNm[i] != null)
					model.setOtiLicAtchFileNm(otiLicAtchFileNm[i]);
				if (afilSeq[i] != null)
					model.setAfilSeq(afilSeq[i]);
				if (mocLicNo[i] != null)
					model.setMocLicNo(mocLicNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpAfilVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpAfilVO[]
	 */
	public RsltPriSpAfilVO[] getRsltPriSpAfilVOs(){
		RsltPriSpAfilVO[] vos = (RsltPriSpAfilVO[])models.toArray(new RsltPriSpAfilVO[models.size()]);
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
		this.scAfilTpCd = this.scAfilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afilRgstRqstLtrNm = this.afilRgstRqstLtrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfTitAtchFileNm = this.trfTitAtchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoDtl = this.srcInfoDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLocCd = this.custLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afilRgstRqstLtrId = this.afilRgstRqstLtrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiBdAtchFileNm = this.otiBdAtchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiLicAtchFileId = this.otiLicAtchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpNm = this.rvisCntrCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsDtl = this.prcProgStsDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd = this.acptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccLicNo = this.nvoccLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrId = this.acptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiBdAtchFileId = this.otiBdAtchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfTitAtchFileId = this.trfTitAtchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdNo = this.nvoccBdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlg = this.mnlInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiLicAtchFileNm = this.otiLicAtchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afilSeq = this.afilSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mocLicNo = this.mocLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}