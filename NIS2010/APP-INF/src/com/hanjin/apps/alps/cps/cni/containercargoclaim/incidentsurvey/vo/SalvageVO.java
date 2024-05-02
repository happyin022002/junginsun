/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalvageVO.java
*@FileTitle : SalvageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.11.20 양정란 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo;

import java.lang.reflect.Field;
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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SalvageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SalvageVO> models = new ArrayList<SalvageVO>();
	
	/* Column Info */
	private String clmInciPlcTpCd = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String smnsSveDt = null;
	/* Column Info */
	private String ptyNm = null;
	/* Column Info */
	private String insurRefNo = null;
	/* Column Info */
	private String clmCgoTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String slvUsdAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slvLoclAmt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String slvXchRt = null;
	/* Column Info */
	private String slvDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mjrClmDmgLssCd = null;
	/* Column Info */
	private String nhp = null;
	/* Column Info */
	private String updDt2 = null;
	/* Column Info */
	private String updDt1 = null;
	/* Column Info */
	private String clmPtyAbbrNm2 = null;
	/* Column Info */
	private String clmPtyAbbrNm1 = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String hpc = null;
	/* Column Info */
	private String clmMiscNm = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String slvLoclCurrCd = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* Column Info */
	private String refSlvNo = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String slvDesc = null;
	/* Column Info */
	private String clmTmBarDt = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String n3rdLablPtyCd = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String crmVocNo = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmAreaCd = null;
	/* Column Info */
	private String clmMiscCd = null;
	/* Column Info */
	private String cgoQltyDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SalvageVO() {}

	public SalvageVO(String ibflag, String pagerows, String cgoClmNo, String clmAreaCd, String hdlrOfcCd, String hdlrUsrId, String updDt1, String cgoClmInciNo, String crmVocNo, String clmMiscCd, String clmMiscNm, String hpc, String nhp, String cgoClmStlTpCd, String csClzDt, String clmTmBarDt, String smnsSveDt, String cgoClmTpCd, String mjrClmDmgLssCd, String n3rdLablPtyCd, String clmCgoTpCd, String cgoQltyDesc, String clmtUsdAmt, String slanCd, String clmInciPlcTpCd, String inciOccrDt, String insurClmPtyNo, String clmPtyAbbrNm1, String insurRefNo, String clmPtyNo, String clmPtyAbbrNm2, String ptyNm, String refSlvNo, String slvDt, String updUsrId, String updDt2, String slvLoclAmt, String slvLoclCurrCd, String slvXchRt, String slvUsdAmt, String slvDesc) {
		this.clmInciPlcTpCd = clmInciPlcTpCd;
		this.csClzDt = csClzDt;
		this.smnsSveDt = smnsSveDt;
		this.ptyNm = ptyNm;
		this.insurRefNo = insurRefNo;
		this.clmCgoTpCd = clmCgoTpCd;
		this.pagerows = pagerows;
		this.slvUsdAmt = slvUsdAmt;
		this.ibflag = ibflag;
		this.slvLoclAmt = slvLoclAmt;
		this.cgoClmNo = cgoClmNo;
		this.slvXchRt = slvXchRt;
		this.slvDt = slvDt;
		this.updUsrId = updUsrId;
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
		this.nhp = nhp;
		this.updDt2 = updDt2;
		this.updDt1 = updDt1;
		this.clmPtyAbbrNm2 = clmPtyAbbrNm2;
		this.clmPtyAbbrNm1 = clmPtyAbbrNm1;
		this.inciOccrDt = inciOccrDt;
		this.hpc = hpc;
		this.clmMiscNm = clmMiscNm;
		this.hdlrUsrId = hdlrUsrId;
		this.slvLoclCurrCd = slvLoclCurrCd;
		this.clmPtyNo = clmPtyNo;
		this.refSlvNo = refSlvNo;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.slanCd = slanCd;
		this.slvDesc = slvDesc;
		this.clmTmBarDt = clmTmBarDt;
		this.cgoClmInciNo = cgoClmInciNo;
		this.n3rdLablPtyCd = n3rdLablPtyCd;
		this.clmtUsdAmt = clmtUsdAmt;
		this.insurClmPtyNo = insurClmPtyNo;
		this.crmVocNo = crmVocNo;
		this.cgoClmTpCd = cgoClmTpCd;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmAreaCd = clmAreaCd;
		this.clmMiscCd = clmMiscCd;
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clm_inci_plc_tp_cd", getClmInciPlcTpCd());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("smns_sve_dt", getSmnsSveDt());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("insur_ref_no", getInsurRefNo());
		this.hashColumns.put("clm_cgo_tp_cd", getClmCgoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("slv_usd_amt", getSlvUsdAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slv_locl_amt", getSlvLoclAmt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("slv_xch_rt", getSlvXchRt());
		this.hashColumns.put("slv_dt", getSlvDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mjr_clm_dmg_lss_cd", getMjrClmDmgLssCd());
		this.hashColumns.put("nhp", getNhp());
		this.hashColumns.put("upd_dt2", getUpdDt2());
		this.hashColumns.put("upd_dt1", getUpdDt1());
		this.hashColumns.put("clm_pty_abbr_nm2", getClmPtyAbbrNm2());
		this.hashColumns.put("clm_pty_abbr_nm1", getClmPtyAbbrNm1());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("hpc", getHpc());
		this.hashColumns.put("clm_misc_nm", getClmMiscNm());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("slv_locl_curr_cd", getSlvLoclCurrCd());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("ref_slv_no", getRefSlvNo());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("slv_desc", getSlvDesc());
		this.hashColumns.put("clm_tm_bar_dt", getClmTmBarDt());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("n3rd_labl_pty_cd", getN3rdLablPtyCd());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("crm_voc_no", getCrmVocNo());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		this.hashColumns.put("clm_misc_cd", getClmMiscCd());
		this.hashColumns.put("cgo_qlty_desc", getCgoQltyDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clm_inci_plc_tp_cd", "clmInciPlcTpCd");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("smns_sve_dt", "smnsSveDt");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("insur_ref_no", "insurRefNo");
		this.hashFields.put("clm_cgo_tp_cd", "clmCgoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("slv_usd_amt", "slvUsdAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slv_locl_amt", "slvLoclAmt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("slv_xch_rt", "slvXchRt");
		this.hashFields.put("slv_dt", "slvDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mjr_clm_dmg_lss_cd", "mjrClmDmgLssCd");
		this.hashFields.put("nhp", "nhp");
		this.hashFields.put("upd_dt2", "updDt2");
		this.hashFields.put("upd_dt1", "updDt1");
		this.hashFields.put("clm_pty_abbr_nm2", "clmPtyAbbrNm2");
		this.hashFields.put("clm_pty_abbr_nm1", "clmPtyAbbrNm1");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("hpc", "hpc");
		this.hashFields.put("clm_misc_nm", "clmMiscNm");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("slv_locl_curr_cd", "slvLoclCurrCd");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("ref_slv_no", "refSlvNo");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("slv_desc", "slvDesc");
		this.hashFields.put("clm_tm_bar_dt", "clmTmBarDt");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("n3rd_labl_pty_cd", "n3rdLablPtyCd");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("crm_voc_no", "crmVocNo");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("clm_misc_cd", "clmMiscCd");
		this.hashFields.put("cgo_qlty_desc", "cgoQltyDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clmInciPlcTpCd
	 */
	public String getClmInciPlcTpCd() {
		return this.clmInciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @return csClzDt
	 */
	public String getCsClzDt() {
		return this.csClzDt;
	}
	
	/**
	 * Column Info
	 * @return smnsSveDt
	 */
	public String getSmnsSveDt() {
		return this.smnsSveDt;
	}
	
	/**
	 * Column Info
	 * @return ptyNm
	 */
	public String getPtyNm() {
		return this.ptyNm;
	}
	
	/**
	 * Column Info
	 * @return insurRefNo
	 */
	public String getInsurRefNo() {
		return this.insurRefNo;
	}
	
	/**
	 * Column Info
	 * @return clmCgoTpCd
	 */
	public String getClmCgoTpCd() {
		return this.clmCgoTpCd;
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
	 * @return slvUsdAmt
	 */
	public String getSlvUsdAmt() {
		return this.slvUsdAmt;
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
	 * @return slvLoclAmt
	 */
	public String getSlvLoclAmt() {
		return this.slvLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return slvXchRt
	 */
	public String getSlvXchRt() {
		return this.slvXchRt;
	}
	
	/**
	 * Column Info
	 * @return slvDt
	 */
	public String getSlvDt() {
		return this.slvDt;
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
	 * @return mjrClmDmgLssCd
	 */
	public String getMjrClmDmgLssCd() {
		return this.mjrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @return nhp
	 */
	public String getNhp() {
		return this.nhp;
	}
	
	/**
	 * Column Info
	 * @return updDt2
	 */
	public String getUpdDt2() {
		return this.updDt2;
	}
	
	/**
	 * Column Info
	 * @return updDt1
	 */
	public String getUpdDt1() {
		return this.updDt1;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm2
	 */
	public String getClmPtyAbbrNm2() {
		return this.clmPtyAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm1
	 */
	public String getClmPtyAbbrNm1() {
		return this.clmPtyAbbrNm1;
	}
	
	/**
	 * Column Info
	 * @return inciOccrDt
	 */
	public String getInciOccrDt() {
		return this.inciOccrDt;
	}
	
	/**
	 * Column Info
	 * @return hpc
	 */
	public String getHpc() {
		return this.hpc;
	}
	
	/**
	 * Column Info
	 * @return clmMiscNm
	 */
	public String getClmMiscNm() {
		return this.clmMiscNm;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @return slvLoclCurrCd
	 */
	public String getSlvLoclCurrCd() {
		return this.slvLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return clmPtyNo
	 */
	public String getClmPtyNo() {
		return this.clmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return refSlvNo
	 */
	public String getRefSlvNo() {
		return this.refSlvNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlTpCd
	 */
	public String getCgoClmStlTpCd() {
		return this.cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return slvDesc
	 */
	public String getSlvDesc() {
		return this.slvDesc;
	}
	
	/**
	 * Column Info
	 * @return clmTmBarDt
	 */
	public String getClmTmBarDt() {
		return this.clmTmBarDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmInciNo
	 */
	public String getCgoClmInciNo() {
		return this.cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdLablPtyCd
	 */
	public String getN3rdLablPtyCd() {
		return this.n3rdLablPtyCd;
	}
	
	/**
	 * Column Info
	 * @return clmtUsdAmt
	 */
	public String getClmtUsdAmt() {
		return this.clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return crmVocNo
	 */
	public String getCrmVocNo() {
		return this.crmVocNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmTpCd
	 */
	public String getCgoClmTpCd() {
		return this.cgoClmTpCd;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @return clmMiscCd
	 */
	public String getClmMiscCd() {
		return this.clmMiscCd;
	}
	
	/**
	 * Column Info
	 * @return cgoQltyDesc
	 */
	public String getCgoQltyDesc() {
		return this.cgoQltyDesc;
	}
	

	/**
	 * Column Info
	 * @param clmInciPlcTpCd
	 */
	public void setClmInciPlcTpCd(String clmInciPlcTpCd) {
		this.clmInciPlcTpCd = clmInciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @param csClzDt
	 */
	public void setCsClzDt(String csClzDt) {
		this.csClzDt = csClzDt;
	}
	
	/**
	 * Column Info
	 * @param smnsSveDt
	 */
	public void setSmnsSveDt(String smnsSveDt) {
		this.smnsSveDt = smnsSveDt;
	}
	
	/**
	 * Column Info
	 * @param ptyNm
	 */
	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
	}
	
	/**
	 * Column Info
	 * @param insurRefNo
	 */
	public void setInsurRefNo(String insurRefNo) {
		this.insurRefNo = insurRefNo;
	}
	
	/**
	 * Column Info
	 * @param clmCgoTpCd
	 */
	public void setClmCgoTpCd(String clmCgoTpCd) {
		this.clmCgoTpCd = clmCgoTpCd;
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
	 * @param slvUsdAmt
	 */
	public void setSlvUsdAmt(String slvUsdAmt) {
		this.slvUsdAmt = slvUsdAmt;
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
	 * @param slvLoclAmt
	 */
	public void setSlvLoclAmt(String slvLoclAmt) {
		this.slvLoclAmt = slvLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param slvXchRt
	 */
	public void setSlvXchRt(String slvXchRt) {
		this.slvXchRt = slvXchRt;
	}
	
	/**
	 * Column Info
	 * @param slvDt
	 */
	public void setSlvDt(String slvDt) {
		this.slvDt = slvDt;
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
	 * @param mjrClmDmgLssCd
	 */
	public void setMjrClmDmgLssCd(String mjrClmDmgLssCd) {
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @param nhp
	 */
	public void setNhp(String nhp) {
		this.nhp = nhp;
	}
	
	/**
	 * Column Info
	 * @param updDt2
	 */
	public void setUpdDt2(String updDt2) {
		this.updDt2 = updDt2;
	}
	
	/**
	 * Column Info
	 * @param updDt1
	 */
	public void setUpdDt1(String updDt1) {
		this.updDt1 = updDt1;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm2
	 */
	public void setClmPtyAbbrNm2(String clmPtyAbbrNm2) {
		this.clmPtyAbbrNm2 = clmPtyAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm1
	 */
	public void setClmPtyAbbrNm1(String clmPtyAbbrNm1) {
		this.clmPtyAbbrNm1 = clmPtyAbbrNm1;
	}
	
	/**
	 * Column Info
	 * @param inciOccrDt
	 */
	public void setInciOccrDt(String inciOccrDt) {
		this.inciOccrDt = inciOccrDt;
	}
	
	/**
	 * Column Info
	 * @param hpc
	 */
	public void setHpc(String hpc) {
		this.hpc = hpc;
	}
	
	/**
	 * Column Info
	 * @param clmMiscNm
	 */
	public void setClmMiscNm(String clmMiscNm) {
		this.clmMiscNm = clmMiscNm;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @param slvLoclCurrCd
	 */
	public void setSlvLoclCurrCd(String slvLoclCurrCd) {
		this.slvLoclCurrCd = slvLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param clmPtyNo
	 */
	public void setClmPtyNo(String clmPtyNo) {
		this.clmPtyNo = clmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param refSlvNo
	 */
	public void setRefSlvNo(String refSlvNo) {
		this.refSlvNo = refSlvNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlTpCd
	 */
	public void setCgoClmStlTpCd(String cgoClmStlTpCd) {
		this.cgoClmStlTpCd = cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param slvDesc
	 */
	public void setSlvDesc(String slvDesc) {
		this.slvDesc = slvDesc;
	}
	
	/**
	 * Column Info
	 * @param clmTmBarDt
	 */
	public void setClmTmBarDt(String clmTmBarDt) {
		this.clmTmBarDt = clmTmBarDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmInciNo
	 */
	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdLablPtyCd
	 */
	public void setN3rdLablPtyCd(String n3rdLablPtyCd) {
		this.n3rdLablPtyCd = n3rdLablPtyCd;
	}
	
	/**
	 * Column Info
	 * @param clmtUsdAmt
	 */
	public void setClmtUsdAmt(String clmtUsdAmt) {
		this.clmtUsdAmt = clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param crmVocNo
	 */
	public void setCrmVocNo(String crmVocNo) {
		this.crmVocNo = crmVocNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmTpCd
	 */
	public void setCgoClmTpCd(String cgoClmTpCd) {
		this.cgoClmTpCd = cgoClmTpCd;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @param clmMiscCd
	 */
	public void setClmMiscCd(String clmMiscCd) {
		this.clmMiscCd = clmMiscCd;
	}
	
	/**
	 * Column Info
	 * @param cgoQltyDesc
	 */
	public void setCgoQltyDesc(String cgoQltyDesc) {
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setClmInciPlcTpCd(JSPUtil.getParameter(request, "clm_inci_plc_tp_cd", ""));
		setCsClzDt(JSPUtil.getParameter(request, "cs_clz_dt", ""));
		setSmnsSveDt(JSPUtil.getParameter(request, "smns_sve_dt", ""));
		setPtyNm(JSPUtil.getParameter(request, "pty_nm", ""));
		setInsurRefNo(JSPUtil.getParameter(request, "insur_ref_no", ""));
		setClmCgoTpCd(JSPUtil.getParameter(request, "clm_cgo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSlvUsdAmt(JSPUtil.getParameter(request, "slv_usd_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlvLoclAmt(JSPUtil.getParameter(request, "slv_locl_amt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setSlvXchRt(JSPUtil.getParameter(request, "slv_xch_rt", ""));
		setSlvDt(JSPUtil.getParameter(request, "slv_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMjrClmDmgLssCd(JSPUtil.getParameter(request, "mjr_clm_dmg_lss_cd", ""));
		setNhp(JSPUtil.getParameter(request, "nhp", ""));
		setUpdDt2(JSPUtil.getParameter(request, "upd_dt2", ""));
		setUpdDt1(JSPUtil.getParameter(request, "upd_dt1", ""));
		setClmPtyAbbrNm2(JSPUtil.getParameter(request, "clm_pty_abbr_nm2", ""));
		setClmPtyAbbrNm1(JSPUtil.getParameter(request, "clm_pty_abbr_nm1", ""));
		setInciOccrDt(JSPUtil.getParameter(request, "inci_occr_dt", ""));
		setHpc(JSPUtil.getParameter(request, "hpc", ""));
		setClmMiscNm(JSPUtil.getParameter(request, "clm_misc_nm", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, "hdlr_usr_id", ""));
		setSlvLoclCurrCd(JSPUtil.getParameter(request, "slv_locl_curr_cd", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setRefSlvNo(JSPUtil.getParameter(request, "ref_slv_no", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, "cgo_clm_stl_tp_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setSlvDesc(JSPUtil.getParameter(request, "slv_desc", ""));
		setClmTmBarDt(JSPUtil.getParameter(request, "clm_tm_bar_dt", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, "cgo_clm_inci_no", ""));
		setN3rdLablPtyCd(JSPUtil.getParameter(request, "n3rd_labl_pty_cd", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, "clmt_usd_amt", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, "insur_clm_pty_no", ""));
		setCrmVocNo(JSPUtil.getParameter(request, "crm_voc_no", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, "cgo_clm_tp_cd", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, "hdlr_ofc_cd", ""));
		setClmAreaCd(JSPUtil.getParameter(request, "clm_area_cd", ""));
		setClmMiscCd(JSPUtil.getParameter(request, "clm_misc_cd", ""));
		setCgoQltyDesc(JSPUtil.getParameter(request, "cgo_qlty_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SalvageVO[]
	 */
	public SalvageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SalvageVO[]
	 */
	public SalvageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SalvageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clmInciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_inci_plc_tp_cd", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] smnsSveDt = (JSPUtil.getParameter(request, prefix	+ "smns_sve_dt", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] insurRefNo = (JSPUtil.getParameter(request, prefix	+ "insur_ref_no", length));
			String[] clmCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cgo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] slvUsdAmt = (JSPUtil.getParameter(request, prefix	+ "slv_usd_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slvLoclAmt = (JSPUtil.getParameter(request, prefix	+ "slv_locl_amt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] slvXchRt = (JSPUtil.getParameter(request, prefix	+ "slv_xch_rt", length));
			String[] slvDt = (JSPUtil.getParameter(request, prefix	+ "slv_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mjrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "mjr_clm_dmg_lss_cd", length));
			String[] nhp = (JSPUtil.getParameter(request, prefix	+ "nhp", length));
			String[] updDt2 = (JSPUtil.getParameter(request, prefix	+ "upd_dt2", length));
			String[] updDt1 = (JSPUtil.getParameter(request, prefix	+ "upd_dt1", length));
			String[] clmPtyAbbrNm2 = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm2", length));
			String[] clmPtyAbbrNm1 = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm1", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] hpc = (JSPUtil.getParameter(request, prefix	+ "hpc", length));
			String[] clmMiscNm = (JSPUtil.getParameter(request, prefix	+ "clm_misc_nm", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] slvLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "slv_locl_curr_cd", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] refSlvNo = (JSPUtil.getParameter(request, prefix	+ "ref_slv_no", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] slvDesc = (JSPUtil.getParameter(request, prefix	+ "slv_desc", length));
			String[] clmTmBarDt = (JSPUtil.getParameter(request, prefix	+ "clm_tm_bar_dt", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] n3rdLablPtyCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_labl_pty_cd", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] crmVocNo = (JSPUtil.getParameter(request, prefix	+ "crm_voc_no", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] clmMiscCd = (JSPUtil.getParameter(request, prefix	+ "clm_misc_cd", length));
			String[] cgoQltyDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_qlty_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SalvageVO();
				if (clmInciPlcTpCd[i] != null)
					model.setClmInciPlcTpCd(clmInciPlcTpCd[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (smnsSveDt[i] != null)
					model.setSmnsSveDt(smnsSveDt[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (insurRefNo[i] != null)
					model.setInsurRefNo(insurRefNo[i]);
				if (clmCgoTpCd[i] != null)
					model.setClmCgoTpCd(clmCgoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (slvUsdAmt[i] != null)
					model.setSlvUsdAmt(slvUsdAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slvLoclAmt[i] != null)
					model.setSlvLoclAmt(slvLoclAmt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (slvXchRt[i] != null)
					model.setSlvXchRt(slvXchRt[i]);
				if (slvDt[i] != null)
					model.setSlvDt(slvDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mjrClmDmgLssCd[i] != null)
					model.setMjrClmDmgLssCd(mjrClmDmgLssCd[i]);
				if (nhp[i] != null)
					model.setNhp(nhp[i]);
				if (updDt2[i] != null)
					model.setUpdDt2(updDt2[i]);
				if (updDt1[i] != null)
					model.setUpdDt1(updDt1[i]);
				if (clmPtyAbbrNm2[i] != null)
					model.setClmPtyAbbrNm2(clmPtyAbbrNm2[i]);
				if (clmPtyAbbrNm1[i] != null)
					model.setClmPtyAbbrNm1(clmPtyAbbrNm1[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (hpc[i] != null)
					model.setHpc(hpc[i]);
				if (clmMiscNm[i] != null)
					model.setClmMiscNm(clmMiscNm[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (slvLoclCurrCd[i] != null)
					model.setSlvLoclCurrCd(slvLoclCurrCd[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (refSlvNo[i] != null)
					model.setRefSlvNo(refSlvNo[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (slvDesc[i] != null)
					model.setSlvDesc(slvDesc[i]);
				if (clmTmBarDt[i] != null)
					model.setClmTmBarDt(clmTmBarDt[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (n3rdLablPtyCd[i] != null)
					model.setN3rdLablPtyCd(n3rdLablPtyCd[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (crmVocNo[i] != null)
					model.setCrmVocNo(crmVocNo[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				if (clmMiscCd[i] != null)
					model.setClmMiscCd(clmMiscCd[i]);
				if (cgoQltyDesc[i] != null)
					model.setCgoQltyDesc(cgoQltyDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSalvageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SalvageVO[]
	 */
	public SalvageVO[] getSalvageVOs(){
		SalvageVO[] vos = (SalvageVO[])models.toArray(new SalvageVO[models.size()]);
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
		this.clmInciPlcTpCd = this.clmInciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smnsSveDt = this.smnsSveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRefNo = this.insurRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCgoTpCd = this.clmCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvUsdAmt = this.slvUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvLoclAmt = this.slvLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvXchRt = this.slvXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvDt = this.slvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrClmDmgLssCd = this.mjrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nhp = this.nhp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt2 = this.updDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt1 = this.updDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm2 = this.clmPtyAbbrNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm1 = this.clmPtyAbbrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpc = this.hpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscNm = this.clmMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvLoclCurrCd = this.slvLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSlvNo = this.refSlvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvDesc = this.slvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTmBarDt = this.clmTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLablPtyCd = this.n3rdLablPtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmVocNo = this.crmVocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscCd = this.clmMiscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoQltyDesc = this.cgoQltyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
