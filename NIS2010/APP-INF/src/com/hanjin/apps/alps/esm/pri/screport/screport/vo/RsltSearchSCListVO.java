/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltSearchSCListVO.java
*@FileTitle : RsltSearchSCListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2012.05.23 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCListVO> models = new ArrayList<RsltSearchSCListVO>();
	
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String lgcyIfFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String ttlMqcQty = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String chssExptFlg = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String areaGrp = null;
	/* Column Info */
	private String pscInclInd = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String newScgFlg = null;
	/* Column Info */
	private String ctrtOfc = null;
	/* Column Info */
	private String realCustNm = null;
	/* Column Info */
	private String convCfmFlg = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String gamtFlg = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String bucInd = null;
	/* Column Info */
	private String pscExptInd = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String griApplFlg = null;
	/* Column Info */
	private String bletNo = null;
	/* Column Info */
	private String fxRtFlg = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String afilNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCListVO() {}

	public RsltSearchSCListVO(String ibflag, String pagerows, String scNo, String propNo, String amdtSeq, String svcScpCd, String ctrtPtyNm, String realCustNm, String prcCtrtCustTpCd, String fnlMqcQty, String ttlMqcQty, String propAproOfcCd, String propOfcCd, String ctrtOfc, String areaGrp, String ctrtCustSrepCd, String ctrtEffDt, String ctrtExpDt, String fileDt, String lgcyIfFlg, String convCfmFlg, String rfFlg, String gamtFlg, String effDt, String expDt, String custNm, String actCustNm, String bucInd, String pscInclInd, String pscExptInd, String chssExptFlg, String griApplFlg, String newScgFlg, String bletNo,String fxRtFlg, String genSpclRtTpCd, String afilNm) {
		this.rfFlg = rfFlg;
		this.custNm = custNm;
		this.ctrtEffDt = ctrtEffDt;
		this.amdtSeq = amdtSeq;
		this.lgcyIfFlg = lgcyIfFlg;
		this.svcScpCd = svcScpCd;
		this.ttlMqcQty = ttlMqcQty;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.scNo = scNo;
		this.chssExptFlg = chssExptFlg;
		this.expDt = expDt;
		this.areaGrp = areaGrp;
		this.pscInclInd = pscInclInd;
		this.ctrtExpDt = ctrtExpDt;
		this.fileDt = fileDt;
		this.fnlMqcQty = fnlMqcQty;
		this.newScgFlg = newScgFlg;
		this.ctrtOfc = ctrtOfc;
		this.realCustNm = realCustNm;
		this.convCfmFlg = convCfmFlg;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.gamtFlg = gamtFlg;
		this.ctrtPtyNm = ctrtPtyNm;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.actCustNm = actCustNm;
		this.propNo = propNo;
		this.bucInd = bucInd;
		this.pscExptInd = pscExptInd;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.griApplFlg = griApplFlg;
		this.bletNo = bletNo;
		this.fxRtFlg = fxRtFlg;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.afilNm = afilNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("lgcy_if_flg", getLgcyIfFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("ttl_mqc_qty", getTtlMqcQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("chss_expt_flg", getChssExptFlg());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("area_grp", getAreaGrp());
		this.hashColumns.put("psc_incl_ind", getPscInclInd());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("new_scg_flg", getNewScgFlg());
		this.hashColumns.put("ctrt_ofc", getCtrtOfc());
		this.hashColumns.put("real_cust_nm", getRealCustNm());
		this.hashColumns.put("conv_cfm_flg", getConvCfmFlg());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("gamt_flg", getGamtFlg());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("buc_ind", getBucInd());
		this.hashColumns.put("psc_expt_ind", getPscExptInd());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("gri_appl_flg", getGriApplFlg());
		this.hashColumns.put("blet_no", getBletNo());
		this.hashColumns.put("fx_rt_flg", getFxRtFlg());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("afil_nm", getAfilNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("lgcy_if_flg", "lgcyIfFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("ttl_mqc_qty", "ttlMqcQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("chss_expt_flg", "chssExptFlg");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("area_grp", "areaGrp");
		this.hashFields.put("psc_incl_ind", "pscInclInd");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("new_scg_flg", "newScgFlg");
		this.hashFields.put("ctrt_ofc", "ctrtOfc");
		this.hashFields.put("real_cust_nm", "realCustNm");
		this.hashFields.put("conv_cfm_flg", "convCfmFlg");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("gamt_flg", "gamtFlg");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("buc_ind", "bucInd");
		this.hashFields.put("psc_expt_ind", "pscExptInd");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("gri_appl_flg", "griApplFlg");
		this.hashFields.put("blet_no", "bletNo");
		this.hashFields.put("fx_rt_flg", "fxRtFlg");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("afil_nm", "genAfilNm");
		return this.hashFields;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return lgcyIfFlg
	 */
	public String getLgcyIfFlg() {
		return this.lgcyIfFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return ttlMqcQty
	 */
	public String getTtlMqcQty() {
		return this.ttlMqcQty;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return chssExptFlg
	 */
	public String getChssExptFlg() {
		return this.chssExptFlg;
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
	 * @return areaGrp
	 */
	public String getAreaGrp() {
		return this.areaGrp;
	}
	
	/**
	 * Column Info
	 * @return pscInclInd
	 */
	public String getPscInclInd() {
		return this.pscInclInd;
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
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return fnlMqcQty
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @return newScgFlg
	 */
	public String getNewScgFlg() {
		return this.newScgFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfc
	 */
	public String getCtrtOfc() {
		return this.ctrtOfc;
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
	 * @return convCfmFlg
	 */
	public String getConvCfmFlg() {
		return this.convCfmFlg;
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
	 * @return actCustNm
	 */
	public String getActCustNm() {
		return this.actCustNm;
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
	 * @return bucInd
	 */
	public String getBucInd() {
		return this.bucInd;
	}
	
	/**
	 * Column Info
	 * @return pscExptInd
	 */
	public String getPscExptInd() {
		return this.pscExptInd;
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
	 * @return griApplFlg
	 */
	public String getGriApplFlg() {
		return this.griApplFlg;
	}
	
	/**
	 * Column Info
	 * @return bletNo
	 */
	public String getBletNo() {
		return this.bletNo;
	}
	
	/**
	 * Column Info
	 * @return fxRtFlg
	 */
	public String getFxRtFlg() {
		return this.fxRtFlg;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}

	/**
	 * Column Info
	 * @return afilNm
	 */
	public String getAfilNm() {
		return this.afilNm;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param lgcyIfFlg
	 */
	public void setLgcyIfFlg(String lgcyIfFlg) {
		this.lgcyIfFlg = lgcyIfFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param ttlMqcQty
	 */
	public void setTtlMqcQty(String ttlMqcQty) {
		this.ttlMqcQty = ttlMqcQty;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param chssExptFlg
	 */
	public void setChssExptFlg(String chssExptFlg) {
		this.chssExptFlg = chssExptFlg;
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
	 * @param areaGrp
	 */
	public void setAreaGrp(String areaGrp) {
		this.areaGrp = areaGrp;
	}
	
	/**
	 * Column Info
	 * @param pscInclInd
	 */
	public void setPscInclInd(String pscInclInd) {
		this.pscInclInd = pscInclInd;
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
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param fnlMqcQty
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @param newScgFlg
	 */
	public void setNewScgFlg(String newScgFlg) {
		this.newScgFlg = newScgFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfc
	 */
	public void setCtrtOfc(String ctrtOfc) {
		this.ctrtOfc = ctrtOfc;
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
	 * @param convCfmFlg
	 */
	public void setConvCfmFlg(String convCfmFlg) {
		this.convCfmFlg = convCfmFlg;
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
	 * @param actCustNm
	 */
	public void setActCustNm(String actCustNm) {
		this.actCustNm = actCustNm;
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
	 * @param bucInd
	 */
	public void setBucInd(String bucInd) {
		this.bucInd = bucInd;
	}
	
	/**
	 * Column Info
	 * @param pscExptInd
	 */
	public void setPscExptInd(String pscExptInd) {
		this.pscExptInd = pscExptInd;
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
	 * @param griApplFlg
	 */
	public void setGriApplFlg(String griApplFlg) {
		this.griApplFlg = griApplFlg;
	}
	/**
	 * Column Info
	 * @param bletNo
	 */
	public void setBletNo(String bletNo) {
		this.bletNo = bletNo;
	}
	/**
	 * Column Info
	 * @param fxRtFlg
	 */
	public void setFxRtFlg(String fxRtFlg) {
		this.fxRtFlg = fxRtFlg;
	}
	/**
	 * Column Info
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	/**
	 * Column Info
	 * @param afilNm
	 */
	public void setAfilNm(String afilNm) {
		this.afilNm = afilNm;
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
		setRfFlg(JSPUtil.getParameter(request, prefix + "rf_flg", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setLgcyIfFlg(JSPUtil.getParameter(request, prefix + "lgcy_if_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setTtlMqcQty(JSPUtil.getParameter(request, prefix + "ttl_mqc_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setChssExptFlg(JSPUtil.getParameter(request, prefix + "chss_expt_flg", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setAreaGrp(JSPUtil.getParameter(request, prefix + "area_grp", ""));
		setPscInclInd(JSPUtil.getParameter(request, prefix + "psc_incl_ind", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, prefix + "fnl_mqc_qty", ""));
		setNewScgFlg(JSPUtil.getParameter(request, prefix + "new_scg_flg", ""));
		setCtrtOfc(JSPUtil.getParameter(request, prefix + "ctrt_ofc", ""));
		setRealCustNm(JSPUtil.getParameter(request, prefix + "real_cust_nm", ""));
		setConvCfmFlg(JSPUtil.getParameter(request, prefix + "conv_cfm_flg", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setGamtFlg(JSPUtil.getParameter(request, prefix + "gamt_flg", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setBucInd(JSPUtil.getParameter(request, prefix + "buc_ind", ""));
		setPscExptInd(JSPUtil.getParameter(request, prefix + "psc_expt_ind", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", ""));
		setGriApplFlg(JSPUtil.getParameter(request, prefix + "gri_appl_flg", ""));
		setBletNo(JSPUtil.getParameter(request, prefix + "blet_no", ""));
		setFxRtFlg(JSPUtil.getParameter(request, prefix + "fx_rt_flg", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setAfilNm(JSPUtil.getParameter(request, prefix + "afil_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCListVO[]
	 */
	public RsltSearchSCListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCListVO[]
	 */
	public RsltSearchSCListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] lgcyIfFlg = (JSPUtil.getParameter(request, prefix	+ "lgcy_if_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] ttlMqcQty = (JSPUtil.getParameter(request, prefix	+ "ttl_mqc_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] chssExptFlg = (JSPUtil.getParameter(request, prefix	+ "chss_expt_flg", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] areaGrp = (JSPUtil.getParameter(request, prefix	+ "area_grp", length));
			String[] pscInclInd = (JSPUtil.getParameter(request, prefix	+ "psc_incl_ind", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] newScgFlg = (JSPUtil.getParameter(request, prefix	+ "new_scg_flg", length));
			String[] ctrtOfc = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc", length));
			String[] realCustNm = (JSPUtil.getParameter(request, prefix	+ "real_cust_nm", length));
			String[] convCfmFlg = (JSPUtil.getParameter(request, prefix	+ "conv_cfm_flg", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] gamtFlg = (JSPUtil.getParameter(request, prefix	+ "gamt_flg", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] bucInd = (JSPUtil.getParameter(request, prefix	+ "buc_ind", length));
			String[] pscExptInd = (JSPUtil.getParameter(request, prefix	+ "psc_expt_ind", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] griApplFlg = (JSPUtil.getParameter(request, prefix	+ "gri_appl_flg", length));
			String[] bletNo = (JSPUtil.getParameter(request, prefix	+ "blet_no", length));
			String[] fxRtFlg = (JSPUtil.getParameter(request, prefix	+ "fx_rt_flg", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] afilNm = (JSPUtil.getParameter(request, prefix	+ "afil_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCListVO();
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (lgcyIfFlg[i] != null)
					model.setLgcyIfFlg(lgcyIfFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (ttlMqcQty[i] != null)
					model.setTtlMqcQty(ttlMqcQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (chssExptFlg[i] != null)
					model.setChssExptFlg(chssExptFlg[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (areaGrp[i] != null)
					model.setAreaGrp(areaGrp[i]);
				if (pscInclInd[i] != null)
					model.setPscInclInd(pscInclInd[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (newScgFlg[i] != null)
					model.setNewScgFlg(newScgFlg[i]);
				if (ctrtOfc[i] != null)
					model.setCtrtOfc(ctrtOfc[i]);
				if (realCustNm[i] != null)
					model.setRealCustNm(realCustNm[i]);
				if (convCfmFlg[i] != null)
					model.setConvCfmFlg(convCfmFlg[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (gamtFlg[i] != null)
					model.setGamtFlg(gamtFlg[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (bucInd[i] != null)
					model.setBucInd(bucInd[i]);
				if (pscExptInd[i] != null)
					model.setPscExptInd(pscExptInd[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (griApplFlg[i] != null)
					model.setGriApplFlg(griApplFlg[i]);
				if (bletNo[i] != null)
					model.setBletNo(bletNo[i]);
				if (fxRtFlg[i] != null)
					model.setFxRtFlg(fxRtFlg[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (afilNm[i] != null)
					model.setAfilNm(afilNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCListVO[]
	 */
	public RsltSearchSCListVO[] getRsltSearchSCListVOs(){
		RsltSearchSCListVO[] vos = (RsltSearchSCListVO[])models.toArray(new RsltSearchSCListVO[models.size()]);
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
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgcyIfFlg = this.lgcyIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMqcQty = this.ttlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssExptFlg = this.chssExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaGrp = this.areaGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscInclInd = this.pscInclInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newScgFlg = this.newScgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfc = this.ctrtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustNm = this.realCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convCfmFlg = this.convCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gamtFlg = this.gamtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucInd = this.bucInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscExptInd = this.pscExptInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplFlg = this.griApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bletNo = this.bletNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxRtFlg = this.fxRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afilNm = this.afilNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
