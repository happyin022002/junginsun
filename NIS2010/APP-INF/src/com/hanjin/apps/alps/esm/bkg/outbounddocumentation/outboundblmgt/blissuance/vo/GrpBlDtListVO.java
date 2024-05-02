/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GrpBlDtListVO.java
*@FileTitle : GrpBlDtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GrpBlDtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GrpBlDtListVO> models = new ArrayList<GrpBlDtListVO>();
	
	/* Column Info */
	private String obInfoIssRdyFlg = null;
	/* Column Info */
	private String blRdyTpCd = null;
	/* Column Info */
	private String blRdyFlg = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String blObrdDtSd = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String creditChk = null;
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String oblRlseFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String oblIssDtSd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String blObrdTpCd = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String custToOrgFlg = null;
	/* Column Info */
	private String flgRate = null;
	/* Column Info */
	private String flgMd = null;
	/* Column Info */
	private String flgPpd = null;
	/* Column Info */
	private String flgDo = null;
	/* Column Info */
	private String blRcvTp = null;
	/* Column Info */
	private String blRcvAt = null;
	/* Column Info */
	private String polEtdDt = null;
	/* Column Info */
	private String cgoRcvDt = null;
	/* Column Info */
	private String oblSrndFlg = null;
	/* Column Info */
	private String blIssNo = null;
	/* Column Info */
	private String doIssDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String fwdrCd = null;
	/* Column Info */
	private String fwdrNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String ppdRcvOfcCd = null;
	/* Column Info */
	private String irBlType = null;
	/* Column Info */
	private String oblIssRmk = null;
	/* Column Info */
	private String orgPpdRcvCd = null;
	/* Column Info */
	private String cntcPsonEml = null;
	/* Column Info */
	private String polEtaDt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GrpBlDtListVO() {}

	public GrpBlDtListVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String custCd, String custNm, String blObrdTpCd, String blObrdDt, String blObrdDtSd, String oblIssFlg, String oblRlseFlg, String oblIssDt, String oblIssDtSd, String oblIssOfcCd, String oblIssUsrId, String creUsrId, String updUsrId, String blRdyFlg, String creditChk, String custToOrgFlg, String flgRate, String flgMd, String flgPpd, String flgDo, String blRcvTp, String blRcvAt ,String polEtdDt, String cgoRcvDt, String oblSrndFlg, String doIssDt, String podCd, String blIssNo, String fwdrNm, String fwdrCd, String cneeCd, String cneeNm, String delCd, String ppdRcvOfcCd, String irBlType, String oblIssRmk, String orgPpdRcvCd, String cntcPsonEml, String polEtaDt, String blRdyTpCd, String obInfoIssRdyFlg) {
		this.obInfoIssRdyFlg = obInfoIssRdyFlg;
		this.blRdyFlg = blRdyFlg;
		this.custNm = custNm;
		this.blObrdDtSd = blObrdDtSd;
		this.oblIssFlg = oblIssFlg;
		this.creditChk = creditChk;
		this.oblIssDt = oblIssDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blTpCd = blTpCd;
		this.oblRlseFlg = oblRlseFlg;
		this.creUsrId = creUsrId;
		this.oblIssDtSd = oblIssDtSd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.oblIssUsrId = oblIssUsrId;
		this.custCd = custCd;
		this.blObrdTpCd = blObrdTpCd;
		this.blObrdDt = blObrdDt;
		this.updUsrId = updUsrId;
		this.oblIssOfcCd = oblIssOfcCd;		
		this.custToOrgFlg = custToOrgFlg;
		this.flgRate = flgRate;
		this.flgMd = flgMd;
		this.flgPpd = flgPpd;
		this.flgDo = flgDo;
		this.blRcvTp = blRcvTp;
		this.blRcvAt = blRcvAt;
		this.polEtdDt = polEtdDt;
		this.cgoRcvDt = cgoRcvDt;
		this.oblSrndFlg = oblSrndFlg;
		this.blIssNo = blIssNo;
		this.doIssDt = doIssDt;
		this.podCd = podCd;		
		this.fwdrCd = fwdrCd;
		this.fwdrNm = fwdrNm;
		this.cneeCd = cneeCd;
		this.cneeNm = cneeNm;	
		this.delCd = delCd;
		this.ppdRcvOfcCd = ppdRcvOfcCd;
		this.irBlType = irBlType;
		this.oblIssRmk = oblIssRmk;
		this.orgPpdRcvCd = orgPpdRcvCd;
		this.cntcPsonEml = cntcPsonEml;
		this.polEtaDt = polEtaDt;
		this.blRdyTpCd = blRdyTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ob_info_iss_rdy_flg", getObInfoIssRdyFlg());
		this.hashColumns.put("bl_rdy_flg", getBlRdyFlg());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bl_obrd_dt_sd", getBlObrdDtSd());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("credit_chk", getCreditChk());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("obl_iss_dt_sd", getOblIssDtSd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("bl_obrd_tp_cd", getBlObrdTpCd());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrgFlg());
		this.hashColumns.put("flg_rate", getFlgRate());
		this.hashColumns.put("flg_md", getFlgMd());
		this.hashColumns.put("flg_ppd", getFlgPpd());
		this.hashColumns.put("flg_do", getFlgDo());
		this.hashColumns.put("bl_rcv_at", getBlRcvTp());
		this.hashColumns.put("bl_rcv_at", getBlRcvAt());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
		this.hashColumns.put("obl_srnd_flg", getOblSrndFlg());
		this.hashColumns.put("bl_iss_no", getBlIssNo());
		this.hashColumns.put("do_iss_dt", getDoIssDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("fwdr_cd", getFwdrCd());
		this.hashColumns.put("fwdr_nm", getFwdrNm());
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ppd_rcv_ofc_cd", getPpdRcvOfcCd());
		
		this.hashColumns.put("ir_bl_type", getIrBlType());
		this.hashColumns.put("obl_iss_rmk", getOblIssRmk());
		this.hashColumns.put("org_ppd_rcv_cd", getOrgPpdRcvCd());
		this.hashColumns.put("cntc_pson_eml", getCntcPsonEml());
		this.hashColumns.put("pol_eta_dt", getPolEtaDt());
		this.hashColumns.put("bl_rdy_tp_cd", getBlRdyTpCd());
		

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ob_info_iss_rdy_flg", "obInfoIssRdyFlg");
		this.hashFields.put("bl_rdy_flg", "blRdyFlg");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bl_obrd_dt_sd", "blObrdDtSd");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("credit_chk", "creditChk");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("obl_iss_dt_sd", "oblIssDtSd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("bl_obrd_tp_cd", "blObrdTpCd");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("cust_to_ord_flg", "custToOrgFlg");
		this.hashFields.put("flg_rate", "flgRate");
		this.hashFields.put("flg_md", "flgMd");
		this.hashFields.put("flg_ppd", "flgPpd");
		this.hashFields.put("flg_do", "flgDo");
		this.hashFields.put("bl_rcv_tp", "blRcvTp");
		this.hashFields.put("bl_rcv_at", "blRcvAt");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
		this.hashFields.put("obl_srnd_flg", "oblSrndFlg");
		this.hashFields.put("bl_iss_no", "blIssNo");
		this.hashFields.put("do_iss_dt", "doIssDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("fwdr_cd", "fwdrCd");
		this.hashFields.put("fwdr_nm", "fwdrNm");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ppd_rcv_ofc_cd", "ppdRcvOfcCd");
		
		this.hashFields.put("ir_bl_type", "irBlType");
		this.hashFields.put("obl_iss_rmk", "oblIssRmk");
		this.hashFields.put("org_ppd_rcv_cd", "orgPpdRcvCd");
		this.hashFields.put("cntc_pson_eml", "cntcPsonEml");
		this.hashFields.put("pol_eta_dt", "polEtaDt");
		this.hashFields.put("bl_rdy_tp_cd", "blRdyTpCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return obInfoIssRdyFlg
	 */
	public String getObInfoIssRdyFlg() {
		return this.obInfoIssRdyFlg;
	}
	
	/**
	 * Column Info
	 * @return irBlType
	 */
	public String getBlRdyTpCd() {
		return this.blRdyTpCd;
	}
	
	/**
	 * Column Info
	 * @return irBlType
	 */
	public String getIrBlType() {
		return this.irBlType;
	}
	/**
	 * Column Info
	 * @return oblIssRmk
	 */
	public String getOblIssRmk() {
		return this.oblIssRmk;
	}
	/**
	 * Column Info
	 * @return orgPpdRcvCd
	 */
	public String getOrgPpdRcvCd() {
		return this.orgPpdRcvCd;
	}
	/**
	 * Column Info
	 * @return cntcPsonEml
	 */
	public String getCntcPsonEml() {
		return this.cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @return blRdyFlg
	 */
	public String getBlRdyFlg() {
		return this.blRdyFlg;
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
	 * @return blObrdDtSd
	 */
	public String getBlObrdDtSd() {
		return this.blObrdDtSd;
	}
	
	/**
	 * Column Info
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @return creditChk
	 */
	public String getCreditChk() {
		return this.creditChk;
	}
	
	/**
	 * Column Info
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return oblRlseFlg
	 */
	public String getOblRlseFlg() {
		return this.oblRlseFlg;
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
	 * @return oblIssDtSd
	 */
	public String getOblIssDtSd() {
		return this.oblIssDtSd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return blObrdTpCd
	 */
	public String getBlObrdTpCd() {
		return this.blObrdTpCd;
	}
	
	/**
	 * Column Info
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
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
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fwdrCd
	 */
	public String getFwdrCd() {
		return this.fwdrCd;
	}
	
	/**
	 * Column Info
	 * @return fwdrNm
	 */
	public String getFwdrNm() {
		return this.fwdrNm;
	}

	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @return ppdRcvOfcCd
	 */
	public String getPpdRcvOfcCd() {
		return this.ppdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return polEtaDt
	 */
	public String getPolEtaDt() {
		return this.polEtaDt;
	}
	
	/**
	 * Column Info
	 * @param polEtaDt
	 */
	public void setBlRdyTpCd(String blRdyTpCd) {
		this.blRdyTpCd = blRdyTpCd;
	}
	

	/**
	 * Column Info
	 * @param polEtaDt
	 */
	public void setPolEtaDt(String polEtaDt) {
		this.polEtaDt = polEtaDt;
	}
	
	/**
	 * Column Info
	 * @param ppdRcvOfcCd
	 */
	public void setPpdRcvOfcCd(String ppdRcvOfcCd) {
		this.ppdRcvOfcCd = ppdRcvOfcCd;
	}
	/**
	 * Column Info
	 * @param blRdyFlg
	 */
	public void setBlRdyFlg(String blRdyFlg) {
		this.blRdyFlg = blRdyFlg;
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
	 * @param blObrdDtSd
	 */
	public void setBlObrdDtSd(String blObrdDtSd) {
		this.blObrdDtSd = blObrdDtSd;
	}
	
	/**
	 * Column Info
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @param creditChk
	 */
	public void setCreditChk(String creditChk) {
		this.creditChk = creditChk;
	}
	
	/**
	 * Column Info
	 * @param oblIssDt
	 */
	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
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
	 * @param oblIssDtSd
	 */
	public void setOblIssDtSd(String oblIssDtSd) {
		this.oblIssDtSd = oblIssDtSd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param blObrdTpCd
	 */
	public void setBlObrdTpCd(String blObrdTpCd) {
		this.blObrdTpCd = blObrdTpCd;
	}
	
	/**
	 * Column Info
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
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
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	
/**
	 * @return the custToOrgFlg
	 */
	public String getCustToOrgFlg() {
		return custToOrgFlg;
	}

	/**
	 * @param custToOrgFlg the custToOrgFlg to set
	 */
	public void setCustToOrgFlg(String custToOrgFlg) {
		this.custToOrgFlg = custToOrgFlg;
	}

	/**
	 * @return the flgRate
	 */
	public String getFlgRate() {
		return flgRate;
	}

	/**
	 * @param flgRate the flgRate to set
	 */
	public void setFlgRate(String flgRate) {
		this.flgRate = flgRate;
	}

	/**
	 * @return the flgMd
	 */
	public String getFlgMd() {
		return flgMd;
	}

	/**
	 * @param flgMd the flgMd to set
	 */
	public void setFlgMd(String flgMd) {
		this.flgMd = flgMd;
	}

	/**
	 * @return the flgPpd
	 */
	public String getFlgPpd() {
		return flgPpd;
	}

	/**
	 * @param flgPpd the flgPpd to set
	 */
	public void setFlgPpd(String flgPpd) {
		this.flgPpd = flgPpd;
	}

	/**
	 * @return the flgDo
	 */
	public String getFlgDo() {
		return flgDo;
	}

	/**
	 * @param flgDo the flgDo to set
	 */
	public void setFlgDo(String flgDo) {
		this.flgDo = flgDo;
	}

	/**
	 * @return the blRcvTp
	 */
	public String getBlRcvTp() {
		return blRcvTp;
	}

	/**
	 * @param blRcvTp the blRcvTp to set
	 */
	public void setBlRcvTp(String blRcvTp) {
		this.blRcvTp = blRcvTp;
	}

	/**
	 * @return the blRcvAt
	 */
	public String getBlRcvAt() {
		return blRcvAt;
	}

	/**
	 * @return the polEtdDt
	 */
	public String getPolEtdDt() {
		return polEtdDt;
	}
	
	/**
	 * @param obInfoIssRdyFlg the obInfoIssRdyFlg to set
	 */
	public void setObInfoIssRdyFlg(String obInfoIssRdyFlg) {
		this.obInfoIssRdyFlg = obInfoIssRdyFlg;
	}

	/**
	 * @param polEtdDt the polEtdDt to set
	 */
	public void setPolEtdDt(String polEtdDt) {
		this.polEtdDt = polEtdDt;
	}

	/**
	 * @return the cgoRcvDt
	 */
	public String getCgoRcvDt() {
		return cgoRcvDt;
	}

	/**
	 * @param cgoRcvDt the cgoRcvDt to set
	 */
	public void setCgoRcvDt(String cgoRcvDt) {
		this.cgoRcvDt = cgoRcvDt;
	}

	/**
	 * @return the oblSrndFlg
	 */
	public String getOblSrndFlg() {
		return oblSrndFlg;
	}

	/**
	 * @param oblSrndFlg the oblSrndFlg to set
	 */
	public void setOblSrndFlg(String oblSrndFlg) {
		this.oblSrndFlg = oblSrndFlg;
	}

	/**
	 * @param blRcvAt the blRcvAt to set
	 */
	public void setBlRcvAt(String blRcvAt) {
		this.blRcvAt = blRcvAt;
	}

	
	/**
	 * @return the blIssNo
	 */
	public String getBlIssNo() {
		return blIssNo;
	}

	/**
	 * @param blIssNo the blIssNo to set
	 */
	public void setBlIssNo(String blIssNo) {
		this.blIssNo = blIssNo;
	}

	
	/**
	 * @return the doIssDt
	 */
	public String getDoIssDt() {
		return doIssDt;
	}
	
	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param doIssDt the doIssDt to set
	 */
	public void setDoIssDt(String doIssDt) {
		this.doIssDt = doIssDt;
	}
	/**
	 * @param fwdrCd the fwdrCd to set
	 */
	public void setFwdrCd(String fwdrCd) {
		this.fwdrCd = fwdrCd;
	}
	
	/**
	 * @param fwdrNm the fwdrNm to set
	 */
	public void setFwdrNm(String fwdrNm) {
		this.fwdrNm = fwdrNm;
	}
	
	/**
	 * @param cneeCd the cneeCd to set
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * @param cneeNm the cneeNm to set
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * @param irBlType the irBlType to set
	 */
	public void setIrBlType(String irBlType) {
		this.irBlType = irBlType;
	}
	
	
	/**
	 * @param oblIssRmk the oblIssRmk to set
	 */
	public void setOblIssRmk(String oblIssRmk) {
		this.oblIssRmk = oblIssRmk;
	}
	/**
	 * @param orgPpdRcvCd the orgPpdRcvCd to set
	 */
	public void setOrgPpdRcvCd(String orgPpdRcvCd) {
		this.orgPpdRcvCd = orgPpdRcvCd;
	}
	/**
	 * @param cntcPsonEml the cntcPsonEml to set
	 */
	public void setCntcPsonEml(String cntcPsonEml) {
		this.cntcPsonEml = cntcPsonEml;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param podCd the delCd to set
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
		setObInfoIssRdyFlg(JSPUtil.getParameter(request, prefix + "ob_info_iss_rdy_flg", ""));
		setBlRdyFlg(JSPUtil.getParameter(request, prefix + "bl_rdy_flg", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBlObrdDtSd(JSPUtil.getParameter(request, prefix + "bl_obrd_dt_sd", ""));
		setOblIssFlg(JSPUtil.getParameter(request, prefix + "obl_iss_flg", ""));
		setCreditChk(JSPUtil.getParameter(request, prefix + "credit_chk", ""));
		setOblIssDt(JSPUtil.getParameter(request, prefix + "obl_iss_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setOblRlseFlg(JSPUtil.getParameter(request, prefix + "obl_rlse_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOblIssDtSd(JSPUtil.getParameter(request, prefix + "obl_iss_dt_sd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, prefix + "obl_iss_usr_id", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setBlObrdTpCd(JSPUtil.getParameter(request, prefix + "bl_obrd_tp_cd", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", ""));
		setCustToOrgFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
		setFlgRate(JSPUtil.getParameter(request, prefix + "flg_rate", ""));
		setFlgMd(JSPUtil.getParameter(request, prefix + "flg_md", ""));
		setFlgPpd(JSPUtil.getParameter(request, prefix + "flg_ppd", ""));
		setFlgDo(JSPUtil.getParameter(request, prefix + "flg_do", ""));
		setBlRcvTp(JSPUtil.getParameter(request, prefix + "bl_rcv_tp", ""));
		setBlRcvAt(JSPUtil.getParameter(request, prefix + "bl_rcv_at", ""));
		setPolEtdDt(JSPUtil.getParameter(request, prefix + "pol_etd_dt", ""));
		setCgoRcvDt(JSPUtil.getParameter(request, prefix + "cgo_rcv_dt", ""));
		setOblSrndFlg(JSPUtil.getParameter(request, prefix + "obl_srnd_flg", ""));
		setBlIssNo(JSPUtil.getParameter(request, prefix + "bl_iss_no", ""));
		setDoIssDt(JSPUtil.getParameter(request, prefix + "do_iss_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFwdrCd(JSPUtil.getParameter(request, prefix + "fwdr_cd", ""));
		setFwdrNm(JSPUtil.getParameter(request, prefix + "fwdr_nm", ""));
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "ppd_rcv_ofc_cd", ""));
		
		setIrBlType(JSPUtil.getParameter(request, prefix + "ir_bl_type", ""));
		setOblIssRmk(JSPUtil.getParameter(request, prefix + "obl_iss_rmk", ""));
		setOrgPpdRcvCd(JSPUtil.getParameter(request, prefix + "org_ppd_rcv_cd", ""));
		setCntcPsonEml(JSPUtil.getParameter(request, prefix + "cntc_pson_eml", ""));
		setPolEtaDt(JSPUtil.getParameter(request, prefix + "pol_eta_dt", ""));
		setBlRdyTpCd(JSPUtil.getParameter(request, prefix + "bl_rdy_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GrpBlDtListVO[]
	 */
	public GrpBlDtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GrpBlDtListVO[]
	 */
	public GrpBlDtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GrpBlDtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] obInfoIssRdyFlg = (JSPUtil.getParameter(request, prefix	+ "ob_info_iss_rdy_flg", length));
			String[] blRdyFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rdy_flg", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] blObrdDtSd = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_sd", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] creditChk = (JSPUtil.getParameter(request, prefix	+ "credit_chk", length));
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] oblIssDtSd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt_sd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] blObrdTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_tp_cd", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] custToOrgFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] flgRate = (JSPUtil.getParameter(request, prefix	+ "flg_rate", length));
			String[] flgMd = (JSPUtil.getParameter(request, prefix	+ "flg_md", length));
			String[] flgPpd = (JSPUtil.getParameter(request, prefix	+ "flg_ppd", length));
			String[] flgDo = (JSPUtil.getParameter(request, prefix	+ "flg_do", length));
			String[] blRcvTp = (JSPUtil.getParameter(request, prefix	+ "bl_rcv_tp", length));
			String[] blRcvAt = (JSPUtil.getParameter(request, prefix	+ "bl_rcv_at", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix	+ "cgo_rcv_dt", length));
			String[] oblSrndFlg = (JSPUtil.getParameter(request, prefix	+ "obl_srnd_flg", length));
			String[] blIssNo = (JSPUtil.getParameter(request, prefix	+ "bl_iss_no", length));
			String[] doIssDt = (JSPUtil.getParameter(request, prefix	+ "do_iss_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] fwdrCd = (JSPUtil.getParameter(request, prefix	+ "fwdr_cd", length));
			String[] fwdrNm = (JSPUtil.getParameter(request, prefix	+ "fwdr_nm", length));
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ppdRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppd_rcv_ofc_cd", length));
			
			String[] irBlType = (JSPUtil.getParameter(request, prefix	+ "ir_bl_type", length));
			String[] oblIssRmk = (JSPUtil.getParameter(request, prefix	+ "obl_iss_rmk", length));
			String[] orgPpdRcvCd = (JSPUtil.getParameter(request, prefix	+ "org_ppd_rcv_cd", length));
			String[] cntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_eml", length));
			String[] polEtaDt = (JSPUtil.getParameter(request, prefix	+ "pol_eta_dt", length));
			String[] blRdyTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_rdy_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GrpBlDtListVO();
				if (blRdyFlg[i] != null)
					model.setBlRdyFlg(blRdyFlg[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (blObrdDtSd[i] != null)
					model.setBlObrdDtSd(blObrdDtSd[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (creditChk[i] != null)
					model.setCreditChk(creditChk[i]);
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (oblIssDtSd[i] != null)
					model.setOblIssDtSd(oblIssDtSd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (blObrdTpCd[i] != null)
					model.setBlObrdTpCd(blObrdTpCd[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (custToOrgFlg[i] != null)
					model.setCustToOrgFlg(custToOrgFlg[i]);
				if (flgRate[i] != null)
					model.setFlgRate(flgRate[i]);
				if (flgMd[i] != null)
					model.setFlgMd(flgMd[i]);
				if (flgPpd[i] != null)
					model.setFlgPpd(flgPpd[i]);
				if (flgDo[i] != null)
					model.setFlgDo(flgDo[i]);
				if (blRcvTp[i] != null)
					model.setBlRcvTp(blRcvTp[i]);
				if (blRcvAt[i] != null)
					model.setBlRcvAt(blRcvAt[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (cgoRcvDt[i] != null)
					model.setCgoRcvDt(cgoRcvDt[i]);
				if (oblSrndFlg[i] != null)
					model.setOblSrndFlg(oblSrndFlg[i]);
				if (blIssNo[i] != null)
					model.setBlIssNo(blIssNo[i]);
				if (doIssDt[i] != null)
					model.setDoIssDt(doIssDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (fwdrCd[i] != null)
					model.setFwdrCd(fwdrCd[i]);
				if (fwdrNm[i] != null)
					model.setFwdrNm(fwdrNm[i]);
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ppdRcvOfcCd[i] != null)
					model.setPpdRcvOfcCd(ppdRcvOfcCd[i]);
				
				if (irBlType[i] != null)
					model.setIrBlType(irBlType[i]);
				if (oblIssRmk[i] != null)
					model.setOblIssRmk(oblIssRmk[i]);
				if (orgPpdRcvCd[i] != null)
					model.setOrgPpdRcvCd(orgPpdRcvCd[i]);
				if (cntcPsonEml[i] != null)
					model.setCntcPsonEml(cntcPsonEml[i]);
				if (polEtaDt[i] != null)
					model.setPolEtaDt(polEtaDt[i]);
				if (blRdyTpCd[i] != null)
					model.setBlRdyTpCd(blRdyTpCd[i]);
				if (obInfoIssRdyFlg[i] != null)
					model.setObInfoIssRdyFlg(obInfoIssRdyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGrpBlDtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GrpBlDtListVO[]
	 */
	public GrpBlDtListVO[] getGrpBlDtListVOs(){
		GrpBlDtListVO[] vos = (GrpBlDtListVO[])models.toArray(new GrpBlDtListVO[models.size()]);
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
		this.obInfoIssRdyFlg = this.obInfoIssRdyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRdyFlg = this.blRdyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtSd = this.blObrdDtSd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditChk = this.creditChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDtSd = this.oblIssDtSd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdTpCd = this.blObrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrgFlg = this.custToOrgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgRate = this.flgRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgMd = this.flgMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgPpd = this.flgPpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgDo = this.flgDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRcvTp = this.blRcvTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRcvAt = this.blRcvAt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRcvDt = this.cgoRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblSrndFlg = this.oblSrndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssNo = this.blIssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssDt = this.doIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrCd = this.fwdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrNm = this.fwdrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdRcvOfcCd = this.ppdRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.irBlType = this.irBlType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssRmk = this.oblIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPpdRcvCd = this.orgPpdRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonEml = this.cntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtaDt = this.polEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRdyTpCd = this.blRdyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
