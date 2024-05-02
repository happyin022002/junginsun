/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OptmRoutPassDtlVO.java
*@FileTitle : OptmRoutPassDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.06.19 박만건 
* 1.0 Creation
* --------------------------------------------------------------------------------------------------------
* History
* 2013.04.29 조인영 [CHM-201323843] [SCE] Optimum Route Pass의 조회 조건 및 칼럼 추가
* 2013.07.09 조인영 [CHM-201325044] [TRS] Optimum Route Pass에 Alternative Optimum 관련 보완
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OptmRoutPassDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OptmRoutPassDtlVO> models = new ArrayList<OptmRoutPassDtlVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String optmToNode = null;
	/* Column Info */
	private String vndrName = null;
	/* Column Info */
	private String viaColrFlg = null;
	/* Column Info */
	private String totKnt = null;
	/* Column Info */
	private String optmViaNode = null;
	/* Column Info */
	private String optmDoorNode = null;
	/* Column Info */
	private String optmFromNode = null;
	/* Column Info */
	private String woVndrSeq = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String optmTrspModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String optmSpName = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String optmRoutPassFlg = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String woIssDt = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String modColrFlg = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String notOptmRsn = null;
	/* Column Info */
	private String cngRsnDesc = null;
	/* Column Info */
	private String optmSpCode = null;
	/* Column Info */
	private String dorColrFlg = null;
	/* Column Info */
	private String woCreOfcCd = null;
	/* Column Info */
	private String troOfcCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String doorZip = null;
	/* Column Info */
	private String doorFctryNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeCustNm = null;
	/* Column Info */
	private String dscrRsnDesc = null;
	/* Column Info */
	private String toColrFlg = null;
	/* Column Info */
	private String bkgDorNodCd = null;
	/* Column Info */
	private String bkgDorNodName = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String bkgFmNodCd = null;
	/* Column Info */
	private String fmColrFlg = null;
	/* Column Info */
	private String woIssUsrId = null;
	/* Column Info */
	private String selDate = null;
	/* Column Info */
	private String fromNode = null;
	/* Column Info */
	private String doorNode = null;
	/* Column Info */
	private String passType = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String taaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OptmRoutPassDtlVO() {}

	public OptmRoutPassDtlVO(String ibflag, String pagerows, String optmRoutPassFlg, String woCreOfcCd, String troOfcCd, String trspModCd, String dscrRsnDesc, String bkgFmNodCd, String bkgDorNodCd, String eqNo, String eqTpszCd, String trspBndCd, String trspCostDtlModCd, String bkgNo, String troSeq, String soNo, String woNo, String woIssDt, String invCfmDt, String woIssUsrId, String trspCrrModCd, String woVndrSeq, String vndrName, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String doorFctryNm, String doorZip, String optmTrspModCd, String optmSpCode, String optmSpName, String optmFromNode, String optmViaNode, String optmToNode, String optmDoorNode, String porCd, String polCd, String podCd, String delCd, String notOptmRsn, String cngRsnDesc, String shprCustNm, String cneeCustNm, String totKnt, String modColrFlg, String fmColrFlg, String viaColrFlg, String toColrFlg, String dorColrFlg, String bkgDorNodName, String selDate, String fromNode, String doorNode, String passType, String scNo, String rfaNo, String taaNo) {
		this.porCd = porCd;
		this.toNodCd = toNodCd;
		this.optmToNode = optmToNode;
		this.vndrName = vndrName;
		this.viaColrFlg = viaColrFlg;
		this.totKnt = totKnt;
		this.optmViaNode = optmViaNode;
		this.optmDoorNode = optmDoorNode;
		this.optmFromNode = optmFromNode;
		this.woVndrSeq = woVndrSeq;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.optmTrspModCd = optmTrspModCd;
		this.ibflag = ibflag;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.eqNo = eqNo;
		this.optmSpName = optmSpName;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.optmRoutPassFlg = optmRoutPassFlg;
		this.trspCrrModCd = trspCrrModCd;
		this.shprCustNm = shprCustNm;
		this.trspBndCd = trspBndCd;
		this.soNo = soNo;
		this.woIssDt = woIssDt;
		this.invCfmDt = invCfmDt;		
		this.modColrFlg = modColrFlg;
		this.troSeq = troSeq;
		this.delCd = delCd;
		this.notOptmRsn = notOptmRsn;
		this.cngRsnDesc = cngRsnDesc;
		this.optmSpCode = optmSpCode;
		this.dorColrFlg = dorColrFlg;
		this.woCreOfcCd = woCreOfcCd;
		this.troOfcCd = troOfcCd;
		this.eqTpszCd = eqTpszCd;
		this.podCd = podCd;
		this.fmNodCd = fmNodCd;
		this.doorZip = doorZip;
		this.doorFctryNm = doorFctryNm;
		this.bkgNo = bkgNo;
		this.cneeCustNm = cneeCustNm;
		this.dscrRsnDesc = dscrRsnDesc;
		this.toColrFlg = toColrFlg;
		this.bkgDorNodCd = bkgDorNodCd;
		this.bkgDorNodName = bkgDorNodName;
		this.viaNodCd = viaNodCd;
		this.bkgFmNodCd = bkgFmNodCd;
		this.fmColrFlg = fmColrFlg;
		this.woIssUsrId = woIssUsrId;
		this.selDate = selDate;
		this.fromNode = fromNode;
		this.doorNode = doorNode;
		this.passType = passType;
		this.scNo = scNo;
		this.rfaNo = rfaNo;
		this.taaNo = taaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("optm_to_node", getOptmToNode());
		this.hashColumns.put("vndr_name", getVndrName());
		this.hashColumns.put("via_colr_flg", getViaColrFlg());
		this.hashColumns.put("tot_knt", getTotKnt());
		this.hashColumns.put("optm_via_node", getOptmViaNode());
		this.hashColumns.put("optm_door_node", getOptmDoorNode());
		this.hashColumns.put("optm_from_node", getOptmFromNode());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("optm_trsp_mod_cd", getOptmTrspModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("optm_sp_name", getOptmSpName());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("optm_rout_pass_flg", getOptmRoutPassFlg());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("wo_iss_dt", getWoIssDt());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());		
		this.hashColumns.put("mod_colr_flg", getModColrFlg());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("not_optm_rsn", getNotOptmRsn());
		this.hashColumns.put("cng_rsn_desc", getCngRsnDesc());
		this.hashColumns.put("optm_sp_code", getOptmSpCode());
		this.hashColumns.put("dor_colr_flg", getDorColrFlg());
		this.hashColumns.put("wo_cre_ofc_cd", getWoCreOfcCd());
		this.hashColumns.put("tro_ofc_cd", getTroOfcCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("door_zip", getDoorZip());
		this.hashColumns.put("door_fctry_nm", getDoorFctryNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_cust_nm", getCneeCustNm());
		this.hashColumns.put("dscr_rsn_desc", getDscrRsnDesc());
		this.hashColumns.put("to_colr_flg", getToColrFlg());
		this.hashColumns.put("bkg_dor_nod_cd", getBkgDorNodCd());
		this.hashColumns.put("bkg_dor_nod_name", getBkgDorNodName());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("bkg_fm_nod_cd", getBkgFmNodCd());
		this.hashColumns.put("fm_colr_flg", getFmColrFlg());
		this.hashColumns.put("wo_iss_usr_id", getWoIssUsrId());
		this.hashColumns.put("sel_date", getSelDate());
		this.hashColumns.put("from_node", getFromNode());
		this.hashColumns.put("door_node", getDoorNode());
		this.hashColumns.put("pass_type", getPassType());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("taa_no", getTaaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("optm_to_node", "optmToNode");
		this.hashFields.put("vndr_name", "vndrName");
		this.hashFields.put("via_colr_flg", "viaColrFlg");
		this.hashFields.put("tot_knt", "totKnt");
		this.hashFields.put("optm_via_node", "optmViaNode");
		this.hashFields.put("optm_door_node", "optmDoorNode");
		this.hashFields.put("optm_from_node", "optmFromNode");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("optm_trsp_mod_cd", "optmTrspModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("optm_sp_name", "optmSpName");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("optm_rout_pass_flg", "optmRoutPassFlg");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("wo_iss_dt", "woIssDt");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");		
		this.hashFields.put("mod_colr_flg", "modColrFlg");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("not_optm_rsn", "notOptmRsn");
		this.hashFields.put("cng_rsn_desc", "cngRsnDesc");
		this.hashFields.put("optm_sp_code", "optmSpCode");
		this.hashFields.put("dor_colr_flg", "dorColrFlg");
		this.hashFields.put("wo_cre_ofc_cd", "woCreOfcCd");
		this.hashFields.put("tro_ofc_cd", "troOfcCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("door_zip", "doorZip");
		this.hashFields.put("door_fctry_nm", "doorFctryNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_cust_nm", "cneeCustNm");
		this.hashFields.put("dscr_rsn_desc", "dscrRsnDesc");
		this.hashFields.put("to_colr_flg", "toColrFlg");
		this.hashFields.put("bkg_dor_nod_cd", "bkgDorNodCd");
		this.hashFields.put("bkg_dor_nod_name", "bkgDorNodName");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("bkg_fm_nod_cd", "bkgFmNodCd");
		this.hashFields.put("fm_colr_flg", "fmColrFlg");
		this.hashFields.put("wo_iss_usr_id", "woIssUsrId");
		this.hashFields.put("sel_date", "selDate");
		this.hashFields.put("from_node", "fromNode");
		this.hashFields.put("door_node", "doorNode");
		this.hashFields.put("pass_type", "passType");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("taa_no", "taaNo");
		return this.hashFields;
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
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return optmToNode
	 */
	public String getOptmToNode() {
		return this.optmToNode;
	}
	
	/**
	 * Column Info
	 * @return vndrName
	 */
	public String getVndrName() {
		return this.vndrName;
	}
	
	/**
	 * Column Info
	 * @return viaColrFlg
	 */
	public String getViaColrFlg() {
		return this.viaColrFlg;
	}
	
	/**
	 * Column Info
	 * @return totKnt
	 */
	public String getTotKnt() {
		return this.totKnt;
	}
	
	/**
	 * Column Info
	 * @return optmViaNode
	 */
	public String getOptmViaNode() {
		return this.optmViaNode;
	}
	
	/**
	 * Column Info
	 * @return optmDoorNode
	 */
	public String getOptmDoorNode() {
		return this.optmDoorNode;
	}
	
	/**
	 * Column Info
	 * @return optmFromNode
	 */
	public String getOptmFromNode() {
		return this.optmFromNode;
	}
	
	/**
	 * Column Info
	 * @return woVndrSeq
	 */
	public String getWoVndrSeq() {
		return this.woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModCd
	 */
	public String getOptmTrspModCd() {
		return this.optmTrspModCd;
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
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return optmSpName
	 */
	public String getOptmSpName() {
		return this.optmSpName;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return optmRoutPassFlg
	 */
	public String getOptmRoutPassFlg() {
		return this.optmRoutPassFlg;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return woIssDt
	 */
	public String getWoIssDt() {
		return this.woIssDt;
	}
	
	/**
	 * Column Info
	 * @return invCfmDt
	 */
	public String getInvCfmDt() {
		return this.invCfmDt;
	}
	
	/**
	 * Column Info
	 * @return modColrFlg
	 */
	public String getModColrFlg() {
		return this.modColrFlg;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
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
	 * @return notOptmRsn
	 */
	public String getNotOptmRsn() {
		return this.notOptmRsn;
	}
	
	/**
	 * Column Info
	 * @return cngRsnDesc
	 */
	public String getCngRsnDesc() {
		return this.cngRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return optmSpCode
	 */
	public String getOptmSpCode() {
		return this.optmSpCode;
	}
	
	/**
	 * Column Info
	 * @return dorColrFlg
	 */
	public String getDorColrFlg() {
		return this.dorColrFlg;
	}
	
	/**
	 * Column Info
	 * @return woCreOfcCd
	 */
	public String getWoCreOfcCd() {
		return this.woCreOfcCd;
	}

	/**
	 * Column Info
	 * @return troOfcCd
	 */
	public String getTroOfcCd() {
		return this.troOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return doorZip
	 */
	public String getDoorZip() {
		return this.doorZip;
	}
	
	/**
	 * Column Info
	 * @return doorFctryNm
	 */
	public String getDoorFctryNm() {
		return this.doorFctryNm;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cneeCustNm
	 */
	public String getCneeCustNm() {
		return this.cneeCustNm;
	}
	
	/**
	 * Column Info
	 * @return dscrRsnDesc
	 */
	public String getDscrRsnDesc() {
		return this.dscrRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return toColrFlg
	 */
	public String getToColrFlg() {
		return this.toColrFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgDorNodCd
	 */
	public String getBkgDorNodCd() {
		return this.bkgDorNodCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDorNodName
	 */
	public String getBkgDorNodName() {
		return this.bkgDorNodName;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return bkgFmNodCd
	 */
	public String getBkgFmNodCd() {
		return this.bkgFmNodCd;
	}
	
	/**
	 * Column Info
	 * @return fmColrFlg
	 */
	public String getFmColrFlg() {
		return this.fmColrFlg;
	}
	
	/**
	 * Column Info
	 * @return woIssUsrId
	 */
	public String getWoIssUsrId() {
		return this.woIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return selDate
	 */
	public String getSelDate() {
		return this.selDate;
	}

	/**
	 * Column Info
	 * @return fromNode
	 */
	public String getFromNode() {
		return this.fromNode;
	}
	
	/**
	 * Column Info
	 * @return doorNode
	 */
	public String getDoorNode() {
		return this.doorNode;
	}
	
	/**
	 * Column Info
	 * @return passType
	 */
	public String getPassType() {
		return this.passType;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return passType
	 */
	public String getTaaNo() {
		return this.taaNo;
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
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param optmToNode
	 */
	public void setOptmToNode(String optmToNode) {
		this.optmToNode = optmToNode;
	}
	
	/**
	 * Column Info
	 * @param vndrName
	 */
	public void setVndrName(String vndrName) {
		this.vndrName = vndrName;
	}
	
	/**
	 * Column Info
	 * @param viaColrFlg
	 */
	public void setViaColrFlg(String viaColrFlg) {
		this.viaColrFlg = viaColrFlg;
	}
	
	/**
	 * Column Info
	 * @param totKnt
	 */
	public void setTotKnt(String totKnt) {
		this.totKnt = totKnt;
	}
	
	/**
	 * Column Info
	 * @param optmViaNode
	 */
	public void setOptmViaNode(String optmViaNode) {
		this.optmViaNode = optmViaNode;
	}
	
	/**
	 * Column Info
	 * @param optmDoorNode
	 */
	public void setOptmDoorNode(String optmDoorNode) {
		this.optmDoorNode = optmDoorNode;
	}
	
	/**
	 * Column Info
	 * @param optmFromNode
	 */
	public void setOptmFromNode(String optmFromNode) {
		this.optmFromNode = optmFromNode;
	}
	
	/**
	 * Column Info
	 * @param woVndrSeq
	 */
	public void setWoVndrSeq(String woVndrSeq) {
		this.woVndrSeq = woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModCd
	 */
	public void setOptmTrspModCd(String optmTrspModCd) {
		this.optmTrspModCd = optmTrspModCd;
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
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param optmSpName
	 */
	public void setOptmSpName(String optmSpName) {
		this.optmSpName = optmSpName;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param optmRoutPassFlg
	 */
	public void setOptmRoutPassFlg(String optmRoutPassFlg) {
		this.optmRoutPassFlg = optmRoutPassFlg;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param woIssDt
	 */
	public void setWoIssDt(String woIssDt) {
		this.woIssDt = woIssDt;
	}
	
	/**
	 * Column Info
	 * @param invCfmDt
	 */
	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
	}
	
	/**
	 * Column Info
	 * @param modColrFlg
	 */
	public void setModColrFlg(String modColrFlg) {
		this.modColrFlg = modColrFlg;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
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
	 * @param notOptmRsn
	 */
	public void setNotOptmRsn(String notOptmRsn) {
		this.notOptmRsn = notOptmRsn;
	}
	
	/**
	 * Column Info
	 * @param cngRsnDesc
	 */
	public void setCngRsnDesc(String cngRsnDesc) {
		this.cngRsnDesc = cngRsnDesc;
	}
	
	
	/**
	 * Column Info
	 * @param optmSpCode
	 */
	public void setOptmSpCode(String optmSpCode) {
		this.optmSpCode = optmSpCode;
	}
	
	/**
	 * Column Info
	 * @param dorColrFlg
	 */
	public void setDorColrFlg(String dorColrFlg) {
		this.dorColrFlg = dorColrFlg;
	}
	
	/**
	 * Column Info
	 * @param woCreOfcCd
	 */
	public void setWoCreOfcCd(String woCreOfcCd) {
		this.woCreOfcCd = woCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param troOfcCd
	 */
	public void setTroOfcCd(String troOfcCd) {
		this.troOfcCd = troOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param doorZip
	 */
	public void setDoorZip(String doorZip) {
		this.doorZip = doorZip;
	}
	
	/**
	 * Column Info
	 * @param doorFctryNm
	 */
	public void setDoorFctryNm(String doorFctryNm) {
		this.doorFctryNm = doorFctryNm;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cneeCustNm
	 */
	public void setCneeCustNm(String cneeCustNm) {
		this.cneeCustNm = cneeCustNm;
	}
	
	/**
	 * Column Info
	 * @param dscrRsnDesc
	 */
	public void setDscrRsnDesc(String dscrRsnDesc) {
		this.dscrRsnDesc = dscrRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param toColrFlg
	 */
	public void setToColrFlg(String toColrFlg) {
		this.toColrFlg = toColrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgDorNodCd
	 */
	public void setBkgDorNodCd(String bkgDorNodCd) {
		this.bkgDorNodCd = bkgDorNodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDorNodName
	 */
	public void setBkgDorNodName(String bkgDorNodName) {
		this.bkgDorNodName = bkgDorNodName;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgFmNodCd
	 */
	public void setBkgFmNodCd(String bkgFmNodCd) {
		this.bkgFmNodCd = bkgFmNodCd;
	}
	
	/**
	 * Column Info
	 * @param fmColrFlg
	 */
	public void setFmColrFlg(String fmColrFlg) {
		this.fmColrFlg = fmColrFlg;
	}
	
	/**
	 * Column Info
	 * @param woIssUsrId
	 */
	public void setWoIssUsrId(String woIssUsrId) {
		this.woIssUsrId = woIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param selDate
	 */
	public void setSelDate(String selDate) {
		this.selDate = selDate;
	}
	
	/**
	 * Column Info
	 * @param fromNode
	 */
	public void setFromNode(String fromNode) {
		this.fromNode = fromNode;
	}
	
	/**
	 * Column Info
	 * @param doorNode
	 */
	public void setDoorNode(String doorNode) {
		this.doorNode = doorNode;
	}
	
	/**
	 * Column Info
	 * @param passType
	 */
	public void setPassType(String passType) {
		this.passType = passType;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setOptmToNode(JSPUtil.getParameter(request, prefix + "optm_to_node", ""));
		setVndrName(JSPUtil.getParameter(request, prefix + "vndr_name", ""));
		setViaColrFlg(JSPUtil.getParameter(request, prefix + "via_colr_flg", ""));
		setTotKnt(JSPUtil.getParameter(request, prefix + "tot_knt", ""));
		setOptmViaNode(JSPUtil.getParameter(request, prefix + "optm_via_node", ""));
		setOptmDoorNode(JSPUtil.getParameter(request, prefix + "optm_door_node", ""));
		setOptmFromNode(JSPUtil.getParameter(request, prefix + "optm_from_node", ""));
		setWoVndrSeq(JSPUtil.getParameter(request, prefix + "wo_vndr_seq", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setOptmTrspModCd(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setOptmSpName(JSPUtil.getParameter(request, prefix + "optm_sp_name", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setOptmRoutPassFlg(JSPUtil.getParameter(request, prefix + "optm_rout_pass_flg", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setShprCustNm(JSPUtil.getParameter(request, prefix + "shpr_cust_nm", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setWoIssDt(JSPUtil.getParameter(request, prefix + "wo_iss_dt", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));		
		setModColrFlg(JSPUtil.getParameter(request, prefix + "mod_colr_flg", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setNotOptmRsn(JSPUtil.getParameter(request, prefix + "not_optm_rsn", ""));
		setCngRsnDesc(JSPUtil.getParameter(request, prefix + "cng_rsn_desc", ""));
		setOptmSpCode(JSPUtil.getParameter(request, prefix + "optm_sp_code", ""));
		setDorColrFlg(JSPUtil.getParameter(request, prefix + "dor_colr_flg", ""));
		setWoCreOfcCd(JSPUtil.getParameter(request, prefix + "wo_cre_ofc_cd", ""));
		setTroOfcCd(JSPUtil.getParameter(request, prefix + "tro_ofc_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setDoorZip(JSPUtil.getParameter(request, prefix + "door_zip", ""));
		setDoorFctryNm(JSPUtil.getParameter(request, prefix + "door_fctry_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeCustNm(JSPUtil.getParameter(request, prefix + "cnee_cust_nm", ""));
		setDscrRsnDesc(JSPUtil.getParameter(request, prefix + "dscr_rsn_desc", ""));
		setToColrFlg(JSPUtil.getParameter(request, prefix + "to_colr_flg", ""));
		setBkgDorNodCd(JSPUtil.getParameter(request, prefix + "bkg_dor_nod_cd", ""));
		setBkgDorNodName(JSPUtil.getParameter(request, prefix + "bkg_dor_nod_name", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setBkgFmNodCd(JSPUtil.getParameter(request, prefix + "bkg_fm_nod_cd", ""));
		setFmColrFlg(JSPUtil.getParameter(request, prefix + "fm_colr_flg", ""));
		setWoIssUsrId(JSPUtil.getParameter(request, prefix + "wo_iss_usr_id", ""));
		setSelDate(JSPUtil.getParameter(request, prefix + "sel_date", ""));
		setFromNode(JSPUtil.getParameter(request, prefix + "from_node", ""));
		setDoorNode(JSPUtil.getParameter(request, prefix + "door_node", ""));
		setPassType(JSPUtil.getParameter(request, prefix + "pass_type", ""));
		setPassType(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setPassType(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPassType(JSPUtil.getParameter(request, prefix + "taa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OptmRoutPassDtlVO[]
	 */
	public OptmRoutPassDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OptmRoutPassDtlVO[]
	 */
	public OptmRoutPassDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OptmRoutPassDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] optmToNode = (JSPUtil.getParameter(request, prefix	+ "optm_to_node", length));
			String[] vndrName = (JSPUtil.getParameter(request, prefix	+ "vndr_name", length));
			String[] viaColrFlg = (JSPUtil.getParameter(request, prefix	+ "via_colr_flg", length));
			String[] totKnt = (JSPUtil.getParameter(request, prefix	+ "tot_knt", length));
			String[] optmViaNode = (JSPUtil.getParameter(request, prefix	+ "optm_via_node", length));
			String[] optmDoorNode = (JSPUtil.getParameter(request, prefix	+ "optm_door_node", length));
			String[] optmFromNode = (JSPUtil.getParameter(request, prefix	+ "optm_from_node", length));
			String[] woVndrSeq = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_seq", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] optmTrspModCd = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] optmSpName = (JSPUtil.getParameter(request, prefix	+ "optm_sp_name", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] optmRoutPassFlg = (JSPUtil.getParameter(request, prefix	+ "optm_rout_pass_flg", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] woIssDt = (JSPUtil.getParameter(request, prefix	+ "wo_iss_dt", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));			
			String[] modColrFlg = (JSPUtil.getParameter(request, prefix	+ "mod_colr_flg", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] notOptmRsn = (JSPUtil.getParameter(request, prefix	+ "not_optm_rsn", length));
			String[] cngRsnDesc = (JSPUtil.getParameter(request, prefix	+ "cng_rsn_desc", length));
			String[] optmSpCode = (JSPUtil.getParameter(request, prefix	+ "optm_sp_code", length));
			String[] dorColrFlg = (JSPUtil.getParameter(request, prefix	+ "dor_colr_flg", length));
			String[] woCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_cre_ofc_cd", length));
			String[] troOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_ofc_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] doorZip = (JSPUtil.getParameter(request, prefix	+ "door_zip", length));
			String[] doorFctryNm = (JSPUtil.getParameter(request, prefix	+ "door_fctry_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeCustNm = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_nm", length));
			String[] dscrRsnDesc = (JSPUtil.getParameter(request, prefix	+ "dscr_rsn_desc", length));
			String[] toColrFlg = (JSPUtil.getParameter(request, prefix	+ "to_colr_flg", length));
			String[] bkgDorNodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_dor_nod_cd", length));
			String[] bkgDorNodName = (JSPUtil.getParameter(request, prefix	+ "bkg_dor_nod_name", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] bkgFmNodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_fm_nod_cd", length));
			String[] fmColrFlg = (JSPUtil.getParameter(request, prefix	+ "fm_colr_flg", length));
			String[] woIssUsrId = (JSPUtil.getParameter(request, prefix	+ "wo_iss_usr_id", length));
			String[] selDate = (JSPUtil.getParameter(request, prefix	+ "sel_date", length));
			String[] fromNode = (JSPUtil.getParameter(request, prefix	+ "from_node", length));
			String[] doorNode = (JSPUtil.getParameter(request, prefix	+ "door_node", length));
			String[] passType = (JSPUtil.getParameter(request, prefix	+ "pass_type", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new OptmRoutPassDtlVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (optmToNode[i] != null)
					model.setOptmToNode(optmToNode[i]);
				if (vndrName[i] != null)
					model.setVndrName(vndrName[i]);
				if (viaColrFlg[i] != null)
					model.setViaColrFlg(viaColrFlg[i]);
				if (totKnt[i] != null)
					model.setTotKnt(totKnt[i]);
				if (optmViaNode[i] != null)
					model.setOptmViaNode(optmViaNode[i]);
				if (optmDoorNode[i] != null)
					model.setOptmDoorNode(optmDoorNode[i]);
				if (optmFromNode[i] != null)
					model.setOptmFromNode(optmFromNode[i]);
				if (woVndrSeq[i] != null)
					model.setWoVndrSeq(woVndrSeq[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (optmTrspModCd[i] != null)
					model.setOptmTrspModCd(optmTrspModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (optmSpName[i] != null)
					model.setOptmSpName(optmSpName[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (optmRoutPassFlg[i] != null)
					model.setOptmRoutPassFlg(optmRoutPassFlg[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (woIssDt[i] != null)
					model.setWoIssDt(woIssDt[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (modColrFlg[i] != null)
					model.setModColrFlg(modColrFlg[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (notOptmRsn[i] != null)
					model.setNotOptmRsn(notOptmRsn[i]);
				if (cngRsnDesc[i] != null)
					model.setCngRsnDesc(cngRsnDesc[i]);
				if (optmSpCode[i] != null)
					model.setOptmSpCode(optmSpCode[i]);
				if (dorColrFlg[i] != null)
					model.setDorColrFlg(dorColrFlg[i]);
				if (woCreOfcCd[i] != null)
					model.setWoCreOfcCd(woCreOfcCd[i]);
				if (troOfcCd[i] != null)
					model.setTroOfcCd(troOfcCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (doorZip[i] != null)
					model.setDoorZip(doorZip[i]);
				if (doorFctryNm[i] != null)
					model.setDoorFctryNm(doorFctryNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeCustNm[i] != null)
					model.setCneeCustNm(cneeCustNm[i]);
				if (dscrRsnDesc[i] != null)
					model.setDscrRsnDesc(dscrRsnDesc[i]);
				if (toColrFlg[i] != null)
					model.setToColrFlg(toColrFlg[i]);
				if (bkgDorNodCd[i] != null)
					model.setBkgDorNodCd(bkgDorNodCd[i]);
				if (bkgDorNodName[i] != null)
					model.setBkgDorNodName(bkgDorNodName[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (bkgFmNodCd[i] != null)
					model.setBkgFmNodCd(bkgFmNodCd[i]);
				if (fmColrFlg[i] != null)
					model.setFmColrFlg(fmColrFlg[i]);
				if (woIssUsrId[i] != null)
					model.setWoIssUsrId(woIssUsrId[i]);
				if (selDate[i] != null)
					model.setSelDate(selDate[i]);
				if (fromNode[i] != null)
					model.setFromNode(fromNode[i]);
				if (doorNode[i] != null)
					model.setDoorNode(doorNode[i]);
				if (passType[i] != null)
					model.setPassType(passType[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOptmRoutPassDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OptmRoutPassDtlVO[]
	 */
	public OptmRoutPassDtlVO[] getOptmRoutPassDtlVOs(){
		OptmRoutPassDtlVO[] vos = (OptmRoutPassDtlVO[])models.toArray(new OptmRoutPassDtlVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmToNode = this.optmToNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrName = this.vndrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaColrFlg = this.viaColrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totKnt = this.totKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmViaNode = this.optmViaNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmDoorNode = this.optmDoorNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmFromNode = this.optmFromNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq = this.woVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModCd = this.optmTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmSpName = this.optmSpName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmRoutPassFlg = this.optmRoutPassFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssDt = this.woIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modColrFlg = this.modColrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notOptmRsn = this.notOptmRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngRsnDesc = this.cngRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmSpCode = this.optmSpCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorColrFlg = this.dorColrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCreOfcCd = this.woCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troOfcCd = this.troOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doorZip = this.doorZip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doorFctryNm = this.doorFctryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustNm = this.cneeCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrRsnDesc = this.dscrRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toColrFlg = this.toColrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDorNodCd = this.bkgDorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDorNodName = this.bkgDorNodName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFmNodCd = this.bkgFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmColrFlg = this.fmColrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssUsrId = this.woIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selDate = this.selDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromNode = this.fromNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doorNode = this.doorNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passType = this.passType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
