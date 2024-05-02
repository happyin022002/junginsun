/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentClaimInquiryVO.java
*@FileTitle : IncidentClaimInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.11.13 양정란 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo;

import java.lang.reflect.Field;
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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IncidentClaimInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IncidentClaimInquiryVO> models = new ArrayList<IncidentClaimInquiryVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String ptyNm2 = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String clmAreaCd2 = null;
	/* Column Info */
	private String ptyNm1 = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String smnsSveDt = null;
	/* Column Info */
	private String deDt = null;
	/* Column Info */
	private String n1stPreTsLocCd = null;
	/* Column Info */
	private String inciSubjNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String crrTermCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String inciRefVvdNo = null;
	/* Column Info */
	private String cgoClmStlUsdAmt = null;
	/* Column Info */
	private String prlmClmNtcDt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String cgoClmRefBlNo = null;
	/* Column Info */
	private String cgoClmDivCd = null;
	/* Column Info */
	private String inciLocCd = null;
	/* Column Info */
	private String updDt2 = null;
	/* Column Info */
	private String updDt1 = null;
	/* Column Info */
	private String cgoClmStlDt = null;
	/* Column Info */
	private String n1stPstTsLocCd = null;
	/* Column Info */
	private String sveyInpDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String cgoClmRefCntrNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String n1stPreRefVvdNo = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String svyrFeeUsdAmt = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmAreaCd1 = null;
	/* Column Info */
	private String cgoQltyDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IncidentClaimInquiryVO() {}

	public IncidentClaimInquiryVO(String ibflag, String pagerows, String cgoClmDivCd, String cgoClmNo, String clmAreaCd1, String hdlrOfcCd, String cgoClmStsCd, String smnsSveDt, String csClzDt, String prlmClmNtcDt, String fmalClmRcvDt, String updDt1, String ptyNm1, String trnkRefVvdNo, String cgoClmRefBlNo, String cgoClmRefCntrNo, String crrTermCd, String porCd, String polCd, String podCd, String delCd, String deDt, String n1stPreRefVvdNo, String n1stPreTsLocCd, String n1stPstTsLocCd, String cgoQltyDesc, String cgoClmTpCd, String clmtLoclAmt, String cgoClmStlTpCd, String cgoClmStlDt, String cgoClmStlUsdAmt, String ptyNm2, String sveyInpDt, String svyrFeeUsdAmt, String rowNum, String total, String cgoClmInciNo, String clmAreaCd2, String creOfcCd, String creUsrId, String creDt, String updDt2, String inciPlcTpCd, String inciRefVvdNo, String inciLocCd, String inciOccrDt, String inciSubjNm) {
		this.total = total;
		this.ptyNm2 = ptyNm2;
		this.porCd = porCd;
		this.clmAreaCd2 = clmAreaCd2;
		this.ptyNm1 = ptyNm1;
		this.clmtLoclAmt = clmtLoclAmt;
		this.csClzDt = csClzDt;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.creDt = creDt;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.smnsSveDt = smnsSveDt;
		this.deDt = deDt;
		this.n1stPreTsLocCd = n1stPreTsLocCd;
		this.inciSubjNm = inciSubjNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.crrTermCd = crrTermCd;
		this.creOfcCd = creOfcCd;
		this.cgoClmStsCd = cgoClmStsCd;
		this.inciRefVvdNo = inciRefVvdNo;
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
		this.prlmClmNtcDt = prlmClmNtcDt;
		this.cgoClmNo = cgoClmNo;
		this.cgoClmRefBlNo = cgoClmRefBlNo;
		this.cgoClmDivCd = cgoClmDivCd;
		this.inciLocCd = inciLocCd;
		this.updDt2 = updDt2;
		this.updDt1 = updDt1;
		this.cgoClmStlDt = cgoClmStlDt;
		this.n1stPstTsLocCd = n1stPstTsLocCd;
		this.sveyInpDt = sveyInpDt;
		this.delCd = delCd;
		this.inciOccrDt = inciOccrDt;
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.n1stPreRefVvdNo = n1stPreRefVvdNo;
		this.cgoClmInciNo = cgoClmInciNo;
		this.svyrFeeUsdAmt = svyrFeeUsdAmt;
		this.inciPlcTpCd = inciPlcTpCd;
		this.cgoClmTpCd = cgoClmTpCd;
		this.rowNum = rowNum;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmAreaCd1 = clmAreaCd1;
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("pty_nm2", getPtyNm2());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("clm_area_cd2", getClmAreaCd2());
		this.hashColumns.put("pty_nm1", getPtyNm1());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("smns_sve_dt", getSmnsSveDt());
		this.hashColumns.put("de_dt", getDeDt());
		this.hashColumns.put("n1st_pre_ts_loc_cd", getN1stPreTsLocCd());
		this.hashColumns.put("inci_subj_nm", getInciSubjNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("crr_term_cd", getCrrTermCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("inci_ref_vvd_no", getInciRefVvdNo());
		this.hashColumns.put("cgo_clm_stl_usd_amt", getCgoClmStlUsdAmt());
		this.hashColumns.put("prlm_clm_ntc_dt", getPrlmClmNtcDt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("cgo_clm_ref_bl_no", getCgoClmRefBlNo());
		this.hashColumns.put("cgo_clm_div_cd", getCgoClmDivCd());
		this.hashColumns.put("inci_loc_cd", getInciLocCd());
		this.hashColumns.put("upd_dt2", getUpdDt2());
		this.hashColumns.put("upd_dt1", getUpdDt1());
		this.hashColumns.put("cgo_clm_stl_dt", getCgoClmStlDt());
		this.hashColumns.put("n1st_pst_ts_loc_cd", getN1stPstTsLocCd());
		this.hashColumns.put("svey_inp_dt", getSveyInpDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("cgo_clm_ref_cntr_no", getCgoClmRefCntrNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("n1st_pre_ref_vvd_no", getN1stPreRefVvdNo());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("svyr_fee_usd_amt", getSvyrFeeUsdAmt());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_area_cd1", getClmAreaCd1());
		this.hashColumns.put("cgo_qlty_desc", getCgoQltyDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("pty_nm2", "ptyNm2");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("clm_area_cd2", "clmAreaCd2");
		this.hashFields.put("pty_nm1", "ptyNm1");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("smns_sve_dt", "smnsSveDt");
		this.hashFields.put("de_dt", "deDt");
		this.hashFields.put("n1st_pre_ts_loc_cd", "n1stPreTsLocCd");
		this.hashFields.put("inci_subj_nm", "inciSubjNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("crr_term_cd", "crrTermCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("inci_ref_vvd_no", "inciRefVvdNo");
		this.hashFields.put("cgo_clm_stl_usd_amt", "cgoClmStlUsdAmt");
		this.hashFields.put("prlm_clm_ntc_dt", "prlmClmNtcDt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("cgo_clm_ref_bl_no", "cgoClmRefBlNo");
		this.hashFields.put("cgo_clm_div_cd", "cgoClmDivCd");
		this.hashFields.put("inci_loc_cd", "inciLocCd");
		this.hashFields.put("upd_dt2", "updDt2");
		this.hashFields.put("upd_dt1", "updDt1");
		this.hashFields.put("cgo_clm_stl_dt", "cgoClmStlDt");
		this.hashFields.put("n1st_pst_ts_loc_cd", "n1stPstTsLocCd");
		this.hashFields.put("svey_inp_dt", "sveyInpDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("cgo_clm_ref_cntr_no", "cgoClmRefCntrNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("n1st_pre_ref_vvd_no", "n1stPreRefVvdNo");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("svyr_fee_usd_amt", "svyrFeeUsdAmt");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_area_cd1", "clmAreaCd1");
		this.hashFields.put("cgo_qlty_desc", "cgoQltyDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return ptyNm2
	 */
	public String getPtyNm2() {
		return this.ptyNm2;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd2
	 */
	public String getClmAreaCd2() {
		return this.clmAreaCd2;
	}
	
	/**
	 * Column Info
	 * @return ptyNm1
	 */
	public String getPtyNm1() {
		return this.ptyNm1;
	}
	
	/**
	 * Column Info
	 * @return clmtLoclAmt
	 */
	public String getClmtLoclAmt() {
		return this.clmtLoclAmt;
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
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
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
	 * @return fmalClmRcvDt
	 */
	public String getFmalClmRcvDt() {
		return this.fmalClmRcvDt;
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
	 * @return deDt
	 */
	public String getDeDt() {
		return this.deDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPreTsLocCd
	 */
	public String getN1stPreTsLocCd() {
		return this.n1stPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return inciSubjNm
	 */
	public String getInciSubjNm() {
		return this.inciSubjNm;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return crrTermCd
	 */
	public String getCrrTermCd() {
		return this.crrTermCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStsCd
	 */
	public String getCgoClmStsCd() {
		return this.cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return inciRefVvdNo
	 */
	public String getInciRefVvdNo() {
		return this.inciRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlUsdAmt
	 */
	public String getCgoClmStlUsdAmt() {
		return this.cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return prlmClmNtcDt
	 */
	public String getPrlmClmNtcDt() {
		return this.prlmClmNtcDt;
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
	 * @return cgoClmRefBlNo
	 */
	public String getCgoClmRefBlNo() {
		return this.cgoClmRefBlNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmDivCd
	 */
	public String getCgoClmDivCd() {
		return this.cgoClmDivCd;
	}
	
	/**
	 * Column Info
	 * @return inciLocCd
	 */
	public String getInciLocCd() {
		return this.inciLocCd;
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
	 * @return cgoClmStlDt
	 */
	public String getCgoClmStlDt() {
		return this.cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPstTsLocCd
	 */
	public String getN1stPstTsLocCd() {
		return this.n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return sveyInpDt
	 */
	public String getSveyInpDt() {
		return this.sveyInpDt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return cgoClmRefCntrNo
	 */
	public String getCgoClmRefCntrNo() {
		return this.cgoClmRefCntrNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return n1stPreRefVvdNo
	 */
	public String getN1stPreRefVvdNo() {
		return this.n1stPreRefVvdNo;
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
	 * @return svyrFeeUsdAmt
	 */
	public String getSvyrFeeUsdAmt() {
		return this.svyrFeeUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return inciPlcTpCd
	 */
	public String getInciPlcTpCd() {
		return this.inciPlcTpCd;
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
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
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
	 * @return clmAreaCd1
	 */
	public String getClmAreaCd1() {
		return this.clmAreaCd1;
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
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param ptyNm2
	 */
	public void setPtyNm2(String ptyNm2) {
		this.ptyNm2 = ptyNm2;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd2
	 */
	public void setClmAreaCd2(String clmAreaCd2) {
		this.clmAreaCd2 = clmAreaCd2;
	}
	
	/**
	 * Column Info
	 * @param ptyNm1
	 */
	public void setPtyNm1(String ptyNm1) {
		this.ptyNm1 = ptyNm1;
	}
	
	/**
	 * Column Info
	 * @param clmtLoclAmt
	 */
	public void setClmtLoclAmt(String clmtLoclAmt) {
		this.clmtLoclAmt = clmtLoclAmt;
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
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
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
	 * @param fmalClmRcvDt
	 */
	public void setFmalClmRcvDt(String fmalClmRcvDt) {
		this.fmalClmRcvDt = fmalClmRcvDt;
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
	 * @param deDt
	 */
	public void setDeDt(String deDt) {
		this.deDt = deDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPreTsLocCd
	 */
	public void setN1stPreTsLocCd(String n1stPreTsLocCd) {
		this.n1stPreTsLocCd = n1stPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param inciSubjNm
	 */
	public void setInciSubjNm(String inciSubjNm) {
		this.inciSubjNm = inciSubjNm;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param crrTermCd
	 */
	public void setCrrTermCd(String crrTermCd) {
		this.crrTermCd = crrTermCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStsCd
	 */
	public void setCgoClmStsCd(String cgoClmStsCd) {
		this.cgoClmStsCd = cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param inciRefVvdNo
	 */
	public void setInciRefVvdNo(String inciRefVvdNo) {
		this.inciRefVvdNo = inciRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlUsdAmt
	 */
	public void setCgoClmStlUsdAmt(String cgoClmStlUsdAmt) {
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param prlmClmNtcDt
	 */
	public void setPrlmClmNtcDt(String prlmClmNtcDt) {
		this.prlmClmNtcDt = prlmClmNtcDt;
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
	 * @param cgoClmRefBlNo
	 */
	public void setCgoClmRefBlNo(String cgoClmRefBlNo) {
		this.cgoClmRefBlNo = cgoClmRefBlNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmDivCd
	 */
	public void setCgoClmDivCd(String cgoClmDivCd) {
		this.cgoClmDivCd = cgoClmDivCd;
	}
	
	/**
	 * Column Info
	 * @param inciLocCd
	 */
	public void setInciLocCd(String inciLocCd) {
		this.inciLocCd = inciLocCd;
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
	 * @param cgoClmStlDt
	 */
	public void setCgoClmStlDt(String cgoClmStlDt) {
		this.cgoClmStlDt = cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPstTsLocCd
	 */
	public void setN1stPstTsLocCd(String n1stPstTsLocCd) {
		this.n1stPstTsLocCd = n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param sveyInpDt
	 */
	public void setSveyInpDt(String sveyInpDt) {
		this.sveyInpDt = sveyInpDt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param cgoClmRefCntrNo
	 */
	public void setCgoClmRefCntrNo(String cgoClmRefCntrNo) {
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param n1stPreRefVvdNo
	 */
	public void setN1stPreRefVvdNo(String n1stPreRefVvdNo) {
		this.n1stPreRefVvdNo = n1stPreRefVvdNo;
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
	 * @param svyrFeeUsdAmt
	 */
	public void setSvyrFeeUsdAmt(String svyrFeeUsdAmt) {
		this.svyrFeeUsdAmt = svyrFeeUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param inciPlcTpCd
	 */
	public void setInciPlcTpCd(String inciPlcTpCd) {
		this.inciPlcTpCd = inciPlcTpCd;
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
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
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
	 * @param clmAreaCd1
	 */
	public void setClmAreaCd1(String clmAreaCd1) {
		this.clmAreaCd1 = clmAreaCd1;
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
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setPtyNm2(JSPUtil.getParameter(request, "pty_nm2", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setClmAreaCd2(JSPUtil.getParameter(request, "clm_area_cd2", ""));
		setPtyNm1(JSPUtil.getParameter(request, "pty_nm1", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, "clmt_locl_amt", ""));
		setCsClzDt(JSPUtil.getParameter(request, "cs_clz_dt", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, "trnk_ref_vvd_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, "fmal_clm_rcv_dt", ""));
		setSmnsSveDt(JSPUtil.getParameter(request, "smns_sve_dt", ""));
		setDeDt(JSPUtil.getParameter(request, "de_dt", ""));
		setN1stPreTsLocCd(JSPUtil.getParameter(request, "n1st_pre_ts_loc_cd", ""));
		setInciSubjNm(JSPUtil.getParameter(request, "inci_subj_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCrrTermCd(JSPUtil.getParameter(request, "crr_term_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, "cgo_clm_sts_cd", ""));
		setInciRefVvdNo(JSPUtil.getParameter(request, "inci_ref_vvd_no", ""));
		setCgoClmStlUsdAmt(JSPUtil.getParameter(request, "cgo_clm_stl_usd_amt", ""));
		setPrlmClmNtcDt(JSPUtil.getParameter(request, "prlm_clm_ntc_dt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setCgoClmRefBlNo(JSPUtil.getParameter(request, "cgo_clm_ref_bl_no", ""));
		setCgoClmDivCd(JSPUtil.getParameter(request, "cgo_clm_div_cd", ""));
		setInciLocCd(JSPUtil.getParameter(request, "inci_loc_cd", ""));
		setUpdDt2(JSPUtil.getParameter(request, "upd_dt2", ""));
		setUpdDt1(JSPUtil.getParameter(request, "upd_dt1", ""));
		setCgoClmStlDt(JSPUtil.getParameter(request, "cgo_clm_stl_dt", ""));
		setN1stPstTsLocCd(JSPUtil.getParameter(request, "n1st_pst_ts_loc_cd", ""));
		setSveyInpDt(JSPUtil.getParameter(request, "svey_inp_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setInciOccrDt(JSPUtil.getParameter(request, "inci_occr_dt", ""));
		setCgoClmRefCntrNo(JSPUtil.getParameter(request, "cgo_clm_ref_cntr_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, "cgo_clm_stl_tp_cd", ""));
		setN1stPreRefVvdNo(JSPUtil.getParameter(request, "n1st_pre_ref_vvd_no", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, "cgo_clm_inci_no", ""));
		setSvyrFeeUsdAmt(JSPUtil.getParameter(request, "svyr_fee_usd_amt", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, "inci_plc_tp_cd", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, "cgo_clm_tp_cd", ""));
		setRowNum(JSPUtil.getParameter(request, "row_num", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, "hdlr_ofc_cd", ""));
		setClmAreaCd1(JSPUtil.getParameter(request, "clm_area_cd1", ""));
		setCgoQltyDesc(JSPUtil.getParameter(request, "cgo_qlty_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IncidentClaimInquiryVO[]
	 */
	public IncidentClaimInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IncidentClaimInquiryVO[]
	 */
	public IncidentClaimInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IncidentClaimInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] ptyNm2 = (JSPUtil.getParameter(request, prefix	+ "pty_nm2", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] clmAreaCd2 = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd2", length));
			String[] ptyNm1 = (JSPUtil.getParameter(request, prefix	+ "pty_nm1", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] smnsSveDt = (JSPUtil.getParameter(request, prefix	+ "smns_sve_dt", length));
			String[] deDt = (JSPUtil.getParameter(request, prefix	+ "de_dt", length));
			String[] n1stPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_loc_cd", length));
			String[] inciSubjNm = (JSPUtil.getParameter(request, prefix	+ "inci_subj_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] crrTermCd = (JSPUtil.getParameter(request, prefix	+ "crr_term_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] inciRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "inci_ref_vvd_no", length));
			String[] cgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_usd_amt", length));
			String[] prlmClmNtcDt = (JSPUtil.getParameter(request, prefix	+ "prlm_clm_ntc_dt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] cgoClmRefBlNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_bl_no", length));
			String[] cgoClmDivCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_div_cd", length));
			String[] inciLocCd = (JSPUtil.getParameter(request, prefix	+ "inci_loc_cd", length));
			String[] updDt2 = (JSPUtil.getParameter(request, prefix	+ "upd_dt2", length));
			String[] updDt1 = (JSPUtil.getParameter(request, prefix	+ "upd_dt1", length));
			String[] cgoClmStlDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_dt", length));
			String[] n1stPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_loc_cd", length));
			String[] sveyInpDt = (JSPUtil.getParameter(request, prefix	+ "svey_inp_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] cgoClmRefCntrNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_cntr_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] n1stPreRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ref_vvd_no", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] svyrFeeUsdAmt = (JSPUtil.getParameter(request, prefix	+ "svyr_fee_usd_amt", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmAreaCd1 = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd1", length));
			String[] cgoQltyDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_qlty_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new IncidentClaimInquiryVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (ptyNm2[i] != null)
					model.setPtyNm2(ptyNm2[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (clmAreaCd2[i] != null)
					model.setClmAreaCd2(clmAreaCd2[i]);
				if (ptyNm1[i] != null)
					model.setPtyNm1(ptyNm1[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (smnsSveDt[i] != null)
					model.setSmnsSveDt(smnsSveDt[i]);
				if (deDt[i] != null)
					model.setDeDt(deDt[i]);
				if (n1stPreTsLocCd[i] != null)
					model.setN1stPreTsLocCd(n1stPreTsLocCd[i]);
				if (inciSubjNm[i] != null)
					model.setInciSubjNm(inciSubjNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (crrTermCd[i] != null)
					model.setCrrTermCd(crrTermCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (inciRefVvdNo[i] != null)
					model.setInciRefVvdNo(inciRefVvdNo[i]);
				if (cgoClmStlUsdAmt[i] != null)
					model.setCgoClmStlUsdAmt(cgoClmStlUsdAmt[i]);
				if (prlmClmNtcDt[i] != null)
					model.setPrlmClmNtcDt(prlmClmNtcDt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (cgoClmRefBlNo[i] != null)
					model.setCgoClmRefBlNo(cgoClmRefBlNo[i]);
				if (cgoClmDivCd[i] != null)
					model.setCgoClmDivCd(cgoClmDivCd[i]);
				if (inciLocCd[i] != null)
					model.setInciLocCd(inciLocCd[i]);
				if (updDt2[i] != null)
					model.setUpdDt2(updDt2[i]);
				if (updDt1[i] != null)
					model.setUpdDt1(updDt1[i]);
				if (cgoClmStlDt[i] != null)
					model.setCgoClmStlDt(cgoClmStlDt[i]);
				if (n1stPstTsLocCd[i] != null)
					model.setN1stPstTsLocCd(n1stPstTsLocCd[i]);
				if (sveyInpDt[i] != null)
					model.setSveyInpDt(sveyInpDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (cgoClmRefCntrNo[i] != null)
					model.setCgoClmRefCntrNo(cgoClmRefCntrNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (n1stPreRefVvdNo[i] != null)
					model.setN1stPreRefVvdNo(n1stPreRefVvdNo[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (svyrFeeUsdAmt[i] != null)
					model.setSvyrFeeUsdAmt(svyrFeeUsdAmt[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmAreaCd1[i] != null)
					model.setClmAreaCd1(clmAreaCd1[i]);
				if (cgoQltyDesc[i] != null)
					model.setCgoQltyDesc(cgoQltyDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIncidentClaimInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IncidentClaimInquiryVO[]
	 */
	public IncidentClaimInquiryVO[] getIncidentClaimInquiryVOs(){
		IncidentClaimInquiryVO[] vos = (IncidentClaimInquiryVO[])models.toArray(new IncidentClaimInquiryVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm2 = this.ptyNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd2 = this.clmAreaCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm1 = this.ptyNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smnsSveDt = this.smnsSveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDt = this.deDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsLocCd = this.n1stPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciSubjNm = this.inciSubjNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrTermCd = this.crrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciRefVvdNo = this.inciRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlUsdAmt = this.cgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prlmClmNtcDt = this.prlmClmNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefBlNo = this.cgoClmRefBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmDivCd = this.cgoClmDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciLocCd = this.inciLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt2 = this.updDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt1 = this.updDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDt = this.cgoClmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsLocCd = this.n1stPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sveyInpDt = this.sveyInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefCntrNo = this.cgoClmRefCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreRefVvdNo = this.n1stPreRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrFeeUsdAmt = this.svyrFeeUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd1 = this.clmAreaCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoQltyDesc = this.cgoQltyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
