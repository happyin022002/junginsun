/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ImpRuleSetupVO.java
*@FileTitle : ImpRuleSetupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.10
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2012.01.10 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ImpRuleSetupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ImpRuleSetupVO> models = new ArrayList<ImpRuleSetupVO>();
	
	/* Column Info */
	private String shprStNmFlg = null;
	/* Column Info */
	private String shprCoRgstFlg = null;
	/* Column Info */
	private String frobFlg = null;
	/* Column Info */
	private String cntrMfCmdtFlg = null;
	/* Column Info */
	private String cntrWgtFlg = null;
	/* Column Info */
	private String ntfyCoRgstFlg = null;
	/* Column Info */
	private String measFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blMkFlg = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String shprPhnFlg = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cntrMeasFlg = null;
	/* Column Info */
	private String shprCtyFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String shprCntFlg = null;
	/* Column Info */
	private String ntfyNmFlg = null;
	/* Column Info */
	private String wgtFlg = null;
	/* Column Info */
	private String cneeCntFlg = null;
	/* Column Info */
	private String cntrMfPckFlg = null;
	/* Column Info */
	private String cneeStNmFlg = null;
	/* Column Info */
	private String ntfyStNmFlg = null;
	/* Column Info */
	private String ntfyZipFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cstmsDivId = null;
	/* Column Info */
	private String cntrMfMkFlg = null;
	/* Column Info */
	private String cntrMfDescFlg = null;
	/* Column Info */
	private String ntfyEoriNoFlg = null;
	/* Column Info */
	private String cneeAddrFlg = null;
	/* Column Info */
	private String sealNoFlg = null;
	/* Column Info */
	private String shprEoriNoFlg = null;
	/* Column Info */
	private String cntrNoFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String cntrMfNcmFlg = null;
	/* Column Info */
	private String ntfySteFlg = null;
	/* Column Info */
	private String cneeSteFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ntfyAddrFlg = null;
	/* Column Info */
	private String cneeCtyFlg = null;
	/* Column Info */
	private String cneeFaxFlg = null;
	/* Column Info */
	private String cntrMfMeasFlg = null;
	/* Column Info */
	private String cmdtHsCdFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntfyFaxFlg = null;
	/* Column Info */
	private String xptImpCd = null;
	/* Column Info */
	private String cneeZipFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cneeCoRgstFlg = null;
	/* Column Info */
	private String blDescFlg = null;
	/* Column Info */
	private String cneePhnFlg = null;
	/* Column Info */
	private String shprNmFlg = null;
	/* Column Info */
	private String ntfyCtyFlg = null;
	/* Column Info */
	private String shprSteFlg = null;
	/* Column Info */
	private String ntfyPhnFlg = null;
	/* Column Info */
	private String cntrPckFlg = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String shprZipFlg = null;
	/* Column Info */
	private String cneeNmFlg = null;
	/* Column Info */
	private String xptImpRefFlg1 = null;
	/* Column Info */
	private String xptImpRefFlg4 = null;
	/* Column Info */
	private String pckFlg = null;
	/* Column Info */
	private String shprFaxFlg = null;
	/* Column Info */
	private String xptImpRefFlg5 = null;
	/* Column Info */
	private String cneeEoriNoFlg = null;
	/* Column Info */
	private String xptImpRefFlg2 = null;
	/* Column Info */
	private String xptImpRefFlg3 = null;
	/* Column Info */
	private String ntfyCntFlg = null;
	/* Column Info */
	private String shprAddrFlg = null;
	/* Column Info */
	private String xptImpRefFlg6 = null;
	/* Column Info */
	private String cntrMfWgtFlg = null;
	/* Column Info */
	private String xptImpRefFlg7 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ImpRuleSetupVO() {}

	public ImpRuleSetupVO(String ibflag, String pagerows, String shprCoRgstFlg, String frobFlg, String cntrMfCmdtFlg, String cntrWgtFlg, String ntfyCoRgstFlg, String measFlg, String blMkFlg, String locCd, String shprPhnFlg, String cntCd, String cntrMeasFlg, String updUsrId, String shprCtyFlg, String shprCntFlg, String ntfyNmFlg, String wgtFlg, String cneeCntFlg, String cntrMfPckFlg, String creUsrId, String ntfyZipFlg, String cstmsDivId, String cntrMfMkFlg, String cntrMfDescFlg, String cneeAddrFlg, String sealNoFlg, String cntrNoFlg, String deltFlg, String cntrMfNcmFlg, String ntfySteFlg, String cneeSteFlg, String creDt, String ntfyAddrFlg, String cneeCtyFlg, String cneeFaxFlg, String cntrMfMeasFlg, String ntfyFaxFlg, String xptImpCd, String cneeZipFlg, String updDt, String cneeCoRgstFlg, String blDescFlg, String cneePhnFlg, String shprNmFlg, String ntfyCtyFlg, String shprSteFlg, String ntfyPhnFlg, String cntrPckFlg, String blTpCd, String xptImpRefFlg1, String cneeNmFlg, String shprZipFlg, String xptImpRefFlg4, String xptImpRefFlg5, String xptImpRefFlg6, String xptImpRefFlg7, String shprFaxFlg, String pckFlg, String xptImpRefFlg2, String xptImpRefFlg3, String ntfyCntFlg, String shprAddrFlg, String cntrMfWgtFlg, String shprStNmFlg, String shprEoriNoFlg, String cneeStNmFlg, String cneeEoriNoFlg, String ntfyStNmFlg, String ntfyEoriNoFlg, String cmdtHsCdFlg) {
		this.shprStNmFlg = shprStNmFlg;
		this.shprCoRgstFlg = shprCoRgstFlg;
		this.frobFlg = frobFlg;
		this.cntrMfCmdtFlg = cntrMfCmdtFlg;
		this.cntrWgtFlg = cntrWgtFlg;
		this.ntfyCoRgstFlg = ntfyCoRgstFlg;
		this.measFlg = measFlg;
		this.pagerows = pagerows;
		this.blMkFlg = blMkFlg;
		this.locCd = locCd;
		this.shprPhnFlg = shprPhnFlg;
		this.cntCd = cntCd;
		this.cntrMeasFlg = cntrMeasFlg;
		this.shprCtyFlg = shprCtyFlg;
		this.updUsrId = updUsrId;
		this.shprCntFlg = shprCntFlg;
		this.ntfyNmFlg = ntfyNmFlg;
		this.wgtFlg = wgtFlg;
		this.cneeCntFlg = cneeCntFlg;
		this.cntrMfPckFlg = cntrMfPckFlg;
		this.cneeStNmFlg = cneeStNmFlg;
		this.ntfyStNmFlg = ntfyStNmFlg;
		this.ntfyZipFlg = ntfyZipFlg;
		this.creUsrId = creUsrId;
		this.cstmsDivId = cstmsDivId;
		this.cntrMfMkFlg = cntrMfMkFlg;
		this.cntrMfDescFlg = cntrMfDescFlg;
		this.ntfyEoriNoFlg = ntfyEoriNoFlg;
		this.cneeAddrFlg = cneeAddrFlg;
		this.sealNoFlg = sealNoFlg;
		this.shprEoriNoFlg = shprEoriNoFlg;
		this.cntrNoFlg = cntrNoFlg;
		this.deltFlg = deltFlg;
		this.cntrMfNcmFlg = cntrMfNcmFlg;
		this.ntfySteFlg = ntfySteFlg;
		this.cneeSteFlg = cneeSteFlg;
		this.creDt = creDt;
		this.ntfyAddrFlg = ntfyAddrFlg;
		this.cneeCtyFlg = cneeCtyFlg;
		this.cneeFaxFlg = cneeFaxFlg;
		this.cntrMfMeasFlg = cntrMfMeasFlg;
		this.cmdtHsCdFlg = cmdtHsCdFlg;
		this.ibflag = ibflag;
		this.ntfyFaxFlg = ntfyFaxFlg;
		this.xptImpCd = xptImpCd;
		this.cneeZipFlg = cneeZipFlg;
		this.updDt = updDt;
		this.cneeCoRgstFlg = cneeCoRgstFlg;
		this.blDescFlg = blDescFlg;
		this.cneePhnFlg = cneePhnFlg;
		this.shprNmFlg = shprNmFlg;
		this.ntfyCtyFlg = ntfyCtyFlg;
		this.shprSteFlg = shprSteFlg;
		this.ntfyPhnFlg = ntfyPhnFlg;
		this.cntrPckFlg = cntrPckFlg;
		this.blTpCd = blTpCd;
		this.shprZipFlg = shprZipFlg;
		this.cneeNmFlg = cneeNmFlg;
		this.xptImpRefFlg1 = xptImpRefFlg1;
		this.xptImpRefFlg4 = xptImpRefFlg4;
		this.pckFlg = pckFlg;
		this.shprFaxFlg = shprFaxFlg;
		this.xptImpRefFlg5 = xptImpRefFlg5;
		this.cneeEoriNoFlg = cneeEoriNoFlg;
		this.xptImpRefFlg2 = xptImpRefFlg2;
		this.xptImpRefFlg3 = xptImpRefFlg3;
		this.ntfyCntFlg = ntfyCntFlg;
		this.shprAddrFlg = shprAddrFlg;
		this.xptImpRefFlg6 = xptImpRefFlg6;
		this.cntrMfWgtFlg = cntrMfWgtFlg;
		this.xptImpRefFlg7 = xptImpRefFlg7;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shpr_st_nm_flg", getShprStNmFlg());
		this.hashColumns.put("shpr_co_rgst_flg", getShprCoRgstFlg());
		this.hashColumns.put("frob_flg", getFrobFlg());
		this.hashColumns.put("cntr_mf_cmdt_flg", getCntrMfCmdtFlg());
		this.hashColumns.put("cntr_wgt_flg", getCntrWgtFlg());
		this.hashColumns.put("ntfy_co_rgst_flg", getNtfyCoRgstFlg());
		this.hashColumns.put("meas_flg", getMeasFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_mk_flg", getBlMkFlg());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("shpr_phn_flg", getShprPhnFlg());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cntr_meas_flg", getCntrMeasFlg());
		this.hashColumns.put("shpr_cty_flg", getShprCtyFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("shpr_cnt_flg", getShprCntFlg());
		this.hashColumns.put("ntfy_nm_flg", getNtfyNmFlg());
		this.hashColumns.put("wgt_flg", getWgtFlg());
		this.hashColumns.put("cnee_cnt_flg", getCneeCntFlg());
		this.hashColumns.put("cntr_mf_pck_flg", getCntrMfPckFlg());
		this.hashColumns.put("cnee_st_nm_flg", getCneeStNmFlg());
		this.hashColumns.put("ntfy_st_nm_flg", getNtfyStNmFlg());
		this.hashColumns.put("ntfy_zip_flg", getNtfyZipFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cstms_div_id", getCstmsDivId());
		this.hashColumns.put("cntr_mf_mk_flg", getCntrMfMkFlg());
		this.hashColumns.put("cntr_mf_desc_flg", getCntrMfDescFlg());
		this.hashColumns.put("ntfy_eori_no_flg", getNtfyEoriNoFlg());
		this.hashColumns.put("cnee_addr_flg", getCneeAddrFlg());
		this.hashColumns.put("seal_no_flg", getSealNoFlg());
		this.hashColumns.put("shpr_eori_no_flg", getShprEoriNoFlg());
		this.hashColumns.put("cntr_no_flg", getCntrNoFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cntr_mf_ncm_flg", getCntrMfNcmFlg());
		this.hashColumns.put("ntfy_ste_flg", getNtfySteFlg());
		this.hashColumns.put("cnee_ste_flg", getCneeSteFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ntfy_addr_flg", getNtfyAddrFlg());
		this.hashColumns.put("cnee_cty_flg", getCneeCtyFlg());
		this.hashColumns.put("cnee_fax_flg", getCneeFaxFlg());
		this.hashColumns.put("cntr_mf_meas_flg", getCntrMfMeasFlg());
		this.hashColumns.put("cmdt_hs_cd_flg", getCmdtHsCdFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntfy_fax_flg", getNtfyFaxFlg());
		this.hashColumns.put("xpt_imp_cd", getXptImpCd());
		this.hashColumns.put("cnee_zip_flg", getCneeZipFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cnee_co_rgst_flg", getCneeCoRgstFlg());
		this.hashColumns.put("bl_desc_flg", getBlDescFlg());
		this.hashColumns.put("cnee_phn_flg", getCneePhnFlg());
		this.hashColumns.put("shpr_nm_flg", getShprNmFlg());
		this.hashColumns.put("ntfy_cty_flg", getNtfyCtyFlg());
		this.hashColumns.put("shpr_ste_flg", getShprSteFlg());
		this.hashColumns.put("ntfy_phn_flg", getNtfyPhnFlg());
		this.hashColumns.put("cntr_pck_flg", getCntrPckFlg());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("shpr_zip_flg", getShprZipFlg());
		this.hashColumns.put("cnee_nm_flg", getCneeNmFlg());
		this.hashColumns.put("xpt_imp_ref_flg1", getXptImpRefFlg1());
		this.hashColumns.put("xpt_imp_ref_flg4", getXptImpRefFlg4());
		this.hashColumns.put("pck_flg", getPckFlg());
		this.hashColumns.put("shpr_fax_flg", getShprFaxFlg());
		this.hashColumns.put("xpt_imp_ref_flg5", getXptImpRefFlg5());
		this.hashColumns.put("cnee_eori_no_flg", getCneeEoriNoFlg());
		this.hashColumns.put("xpt_imp_ref_flg2", getXptImpRefFlg2());
		this.hashColumns.put("xpt_imp_ref_flg3", getXptImpRefFlg3());
		this.hashColumns.put("ntfy_cnt_flg", getNtfyCntFlg());
		this.hashColumns.put("shpr_addr_flg", getShprAddrFlg());
		this.hashColumns.put("xpt_imp_ref_flg6", getXptImpRefFlg6());
		this.hashColumns.put("cntr_mf_wgt_flg", getCntrMfWgtFlg());
		this.hashColumns.put("xpt_imp_ref_flg7", getXptImpRefFlg7());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shpr_st_nm_flg", "shprStNmFlg");
		this.hashFields.put("shpr_co_rgst_flg", "shprCoRgstFlg");
		this.hashFields.put("frob_flg", "frobFlg");
		this.hashFields.put("cntr_mf_cmdt_flg", "cntrMfCmdtFlg");
		this.hashFields.put("cntr_wgt_flg", "cntrWgtFlg");
		this.hashFields.put("ntfy_co_rgst_flg", "ntfyCoRgstFlg");
		this.hashFields.put("meas_flg", "measFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_mk_flg", "blMkFlg");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("shpr_phn_flg", "shprPhnFlg");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntr_meas_flg", "cntrMeasFlg");
		this.hashFields.put("shpr_cty_flg", "shprCtyFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("shpr_cnt_flg", "shprCntFlg");
		this.hashFields.put("ntfy_nm_flg", "ntfyNmFlg");
		this.hashFields.put("wgt_flg", "wgtFlg");
		this.hashFields.put("cnee_cnt_flg", "cneeCntFlg");
		this.hashFields.put("cntr_mf_pck_flg", "cntrMfPckFlg");
		this.hashFields.put("cnee_st_nm_flg", "cneeStNmFlg");
		this.hashFields.put("ntfy_st_nm_flg", "ntfyStNmFlg");
		this.hashFields.put("ntfy_zip_flg", "ntfyZipFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cstms_div_id", "cstmsDivId");
		this.hashFields.put("cntr_mf_mk_flg", "cntrMfMkFlg");
		this.hashFields.put("cntr_mf_desc_flg", "cntrMfDescFlg");
		this.hashFields.put("ntfy_eori_no_flg", "ntfyEoriNoFlg");
		this.hashFields.put("cnee_addr_flg", "cneeAddrFlg");
		this.hashFields.put("seal_no_flg", "sealNoFlg");
		this.hashFields.put("shpr_eori_no_flg", "shprEoriNoFlg");
		this.hashFields.put("cntr_no_flg", "cntrNoFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cntr_mf_ncm_flg", "cntrMfNcmFlg");
		this.hashFields.put("ntfy_ste_flg", "ntfySteFlg");
		this.hashFields.put("cnee_ste_flg", "cneeSteFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ntfy_addr_flg", "ntfyAddrFlg");
		this.hashFields.put("cnee_cty_flg", "cneeCtyFlg");
		this.hashFields.put("cnee_fax_flg", "cneeFaxFlg");
		this.hashFields.put("cntr_mf_meas_flg", "cntrMfMeasFlg");
		this.hashFields.put("cmdt_hs_cd_flg", "cmdtHsCdFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntfy_fax_flg", "ntfyFaxFlg");
		this.hashFields.put("xpt_imp_cd", "xptImpCd");
		this.hashFields.put("cnee_zip_flg", "cneeZipFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cnee_co_rgst_flg", "cneeCoRgstFlg");
		this.hashFields.put("bl_desc_flg", "blDescFlg");
		this.hashFields.put("cnee_phn_flg", "cneePhnFlg");
		this.hashFields.put("shpr_nm_flg", "shprNmFlg");
		this.hashFields.put("ntfy_cty_flg", "ntfyCtyFlg");
		this.hashFields.put("shpr_ste_flg", "shprSteFlg");
		this.hashFields.put("ntfy_phn_flg", "ntfyPhnFlg");
		this.hashFields.put("cntr_pck_flg", "cntrPckFlg");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("shpr_zip_flg", "shprZipFlg");
		this.hashFields.put("cnee_nm_flg", "cneeNmFlg");
		this.hashFields.put("xpt_imp_ref_flg1", "xptImpRefFlg1");
		this.hashFields.put("xpt_imp_ref_flg4", "xptImpRefFlg4");
		this.hashFields.put("pck_flg", "pckFlg");
		this.hashFields.put("shpr_fax_flg", "shprFaxFlg");
		this.hashFields.put("xpt_imp_ref_flg5", "xptImpRefFlg5");
		this.hashFields.put("cnee_eori_no_flg", "cneeEoriNoFlg");
		this.hashFields.put("xpt_imp_ref_flg2", "xptImpRefFlg2");
		this.hashFields.put("xpt_imp_ref_flg3", "xptImpRefFlg3");
		this.hashFields.put("ntfy_cnt_flg", "ntfyCntFlg");
		this.hashFields.put("shpr_addr_flg", "shprAddrFlg");
		this.hashFields.put("xpt_imp_ref_flg6", "xptImpRefFlg6");
		this.hashFields.put("cntr_mf_wgt_flg", "cntrMfWgtFlg");
		this.hashFields.put("xpt_imp_ref_flg7", "xptImpRefFlg7");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shprStNmFlg
	 */
	public String getShprStNmFlg() {
		return this.shprStNmFlg;
	}
	
	/**
	 * Column Info
	 * @return shprCoRgstFlg
	 */
	public String getShprCoRgstFlg() {
		return this.shprCoRgstFlg;
	}
	
	/**
	 * Column Info
	 * @return frobFlg
	 */
	public String getFrobFlg() {
		return this.frobFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrMfCmdtFlg
	 */
	public String getCntrMfCmdtFlg() {
		return this.cntrMfCmdtFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtFlg
	 */
	public String getCntrWgtFlg() {
		return this.cntrWgtFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfyCoRgstFlg
	 */
	public String getNtfyCoRgstFlg() {
		return this.ntfyCoRgstFlg;
	}
	
	/**
	 * Column Info
	 * @return measFlg
	 */
	public String getMeasFlg() {
		return this.measFlg;
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
	 * @return blMkFlg
	 */
	public String getBlMkFlg() {
		return this.blMkFlg;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return shprPhnFlg
	 */
	public String getShprPhnFlg() {
		return this.shprPhnFlg;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMeasFlg
	 */
	public String getCntrMeasFlg() {
		return this.cntrMeasFlg;
	}
	
	/**
	 * Column Info
	 * @return shprCtyFlg
	 */
	public String getShprCtyFlg() {
		return this.shprCtyFlg;
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
	 * @return shprCntFlg
	 */
	public String getShprCntFlg() {
		return this.shprCntFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfyNmFlg
	 */
	public String getNtfyNmFlg() {
		return this.ntfyNmFlg;
	}
	
	/**
	 * Column Info
	 * @return wgtFlg
	 */
	public String getWgtFlg() {
		return this.wgtFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeCntFlg
	 */
	public String getCneeCntFlg() {
		return this.cneeCntFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrMfPckFlg
	 */
	public String getCntrMfPckFlg() {
		return this.cntrMfPckFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeStNmFlg
	 */
	public String getCneeStNmFlg() {
		return this.cneeStNmFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfyStNmFlg
	 */
	public String getNtfyStNmFlg() {
		return this.ntfyStNmFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfyZipFlg
	 */
	public String getNtfyZipFlg() {
		return this.ntfyZipFlg;
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
	 * @return cstmsDivId
	 */
	public String getCstmsDivId() {
		return this.cstmsDivId;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkFlg
	 */
	public String getCntrMfMkFlg() {
		return this.cntrMfMkFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrMfDescFlg
	 */
	public String getCntrMfDescFlg() {
		return this.cntrMfDescFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfyEoriNoFlg
	 */
	public String getNtfyEoriNoFlg() {
		return this.ntfyEoriNoFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeAddrFlg
	 */
	public String getCneeAddrFlg() {
		return this.cneeAddrFlg;
	}
	
	/**
	 * Column Info
	 * @return sealNoFlg
	 */
	public String getSealNoFlg() {
		return this.sealNoFlg;
	}
	
	/**
	 * Column Info
	 * @return shprEoriNoFlg
	 */
	public String getShprEoriNoFlg() {
		return this.shprEoriNoFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrNoFlg
	 */
	public String getCntrNoFlg() {
		return this.cntrNoFlg;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrMfNcmFlg
	 */
	public String getCntrMfNcmFlg() {
		return this.cntrMfNcmFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfySteFlg
	 */
	public String getNtfySteFlg() {
		return this.ntfySteFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeSteFlg
	 */
	public String getCneeSteFlg() {
		return this.cneeSteFlg;
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
	 * @return ntfyAddrFlg
	 */
	public String getNtfyAddrFlg() {
		return this.ntfyAddrFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeCtyFlg
	 */
	public String getCneeCtyFlg() {
		return this.cneeCtyFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeFaxFlg
	 */
	public String getCneeFaxFlg() {
		return this.cneeFaxFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMeasFlg
	 */
	public String getCntrMfMeasFlg() {
		return this.cntrMfMeasFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsCdFlg
	 */
	public String getCmdtHsCdFlg() {
		return this.cmdtHsCdFlg;
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
	 * @return ntfyFaxFlg
	 */
	public String getNtfyFaxFlg() {
		return this.ntfyFaxFlg;
	}
	
	/**
	 * Column Info
	 * @return xptImpCd
	 */
	public String getXptImpCd() {
		return this.xptImpCd;
	}
	
	/**
	 * Column Info
	 * @return cneeZipFlg
	 */
	public String getCneeZipFlg() {
		return this.cneeZipFlg;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return cneeCoRgstFlg
	 */
	public String getCneeCoRgstFlg() {
		return this.cneeCoRgstFlg;
	}
	
	/**
	 * Column Info
	 * @return blDescFlg
	 */
	public String getBlDescFlg() {
		return this.blDescFlg;
	}
	
	/**
	 * Column Info
	 * @return cneePhnFlg
	 */
	public String getCneePhnFlg() {
		return this.cneePhnFlg;
	}
	
	/**
	 * Column Info
	 * @return shprNmFlg
	 */
	public String getShprNmFlg() {
		return this.shprNmFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfyCtyFlg
	 */
	public String getNtfyCtyFlg() {
		return this.ntfyCtyFlg;
	}
	
	/**
	 * Column Info
	 * @return shprSteFlg
	 */
	public String getShprSteFlg() {
		return this.shprSteFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfyPhnFlg
	 */
	public String getNtfyPhnFlg() {
		return this.ntfyPhnFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrPckFlg
	 */
	public String getCntrPckFlg() {
		return this.cntrPckFlg;
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
	 * @return shprZipFlg
	 */
	public String getShprZipFlg() {
		return this.shprZipFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeNmFlg
	 */
	public String getCneeNmFlg() {
		return this.cneeNmFlg;
	}
	
	/**
	 * Column Info
	 * @return xptImpRefFlg1
	 */
	public String getXptImpRefFlg1() {
		return this.xptImpRefFlg1;
	}
	
	/**
	 * Column Info
	 * @return xptImpRefFlg4
	 */
	public String getXptImpRefFlg4() {
		return this.xptImpRefFlg4;
	}
	
	/**
	 * Column Info
	 * @return pckFlg
	 */
	public String getPckFlg() {
		return this.pckFlg;
	}
	
	/**
	 * Column Info
	 * @return shprFaxFlg
	 */
	public String getShprFaxFlg() {
		return this.shprFaxFlg;
	}
	
	/**
	 * Column Info
	 * @return xptImpRefFlg5
	 */
	public String getXptImpRefFlg5() {
		return this.xptImpRefFlg5;
	}
	
	/**
	 * Column Info
	 * @return cneeEoriNoFlg
	 */
	public String getCneeEoriNoFlg() {
		return this.cneeEoriNoFlg;
	}
	
	/**
	 * Column Info
	 * @return xptImpRefFlg2
	 */
	public String getXptImpRefFlg2() {
		return this.xptImpRefFlg2;
	}
	
	/**
	 * Column Info
	 * @return xptImpRefFlg3
	 */
	public String getXptImpRefFlg3() {
		return this.xptImpRefFlg3;
	}
	
	/**
	 * Column Info
	 * @return ntfyCntFlg
	 */
	public String getNtfyCntFlg() {
		return this.ntfyCntFlg;
	}
	
	/**
	 * Column Info
	 * @return shprAddrFlg
	 */
	public String getShprAddrFlg() {
		return this.shprAddrFlg;
	}
	
	/**
	 * Column Info
	 * @return xptImpRefFlg6
	 */
	public String getXptImpRefFlg6() {
		return this.xptImpRefFlg6;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgtFlg
	 */
	public String getCntrMfWgtFlg() {
		return this.cntrMfWgtFlg;
	}
	
	/**
	 * Column Info
	 * @return xptImpRefFlg7
	 */
	public String getXptImpRefFlg7() {
		return this.xptImpRefFlg7;
	}
	

	/**
	 * Column Info
	 * @param shprStNmFlg
	 */
	public void setShprStNmFlg(String shprStNmFlg) {
		this.shprStNmFlg = shprStNmFlg;
	}
	
	/**
	 * Column Info
	 * @param shprCoRgstFlg
	 */
	public void setShprCoRgstFlg(String shprCoRgstFlg) {
		this.shprCoRgstFlg = shprCoRgstFlg;
	}
	
	/**
	 * Column Info
	 * @param frobFlg
	 */
	public void setFrobFlg(String frobFlg) {
		this.frobFlg = frobFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrMfCmdtFlg
	 */
	public void setCntrMfCmdtFlg(String cntrMfCmdtFlg) {
		this.cntrMfCmdtFlg = cntrMfCmdtFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtFlg
	 */
	public void setCntrWgtFlg(String cntrWgtFlg) {
		this.cntrWgtFlg = cntrWgtFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfyCoRgstFlg
	 */
	public void setNtfyCoRgstFlg(String ntfyCoRgstFlg) {
		this.ntfyCoRgstFlg = ntfyCoRgstFlg;
	}
	
	/**
	 * Column Info
	 * @param measFlg
	 */
	public void setMeasFlg(String measFlg) {
		this.measFlg = measFlg;
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
	 * @param blMkFlg
	 */
	public void setBlMkFlg(String blMkFlg) {
		this.blMkFlg = blMkFlg;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param shprPhnFlg
	 */
	public void setShprPhnFlg(String shprPhnFlg) {
		this.shprPhnFlg = shprPhnFlg;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMeasFlg
	 */
	public void setCntrMeasFlg(String cntrMeasFlg) {
		this.cntrMeasFlg = cntrMeasFlg;
	}
	
	/**
	 * Column Info
	 * @param shprCtyFlg
	 */
	public void setShprCtyFlg(String shprCtyFlg) {
		this.shprCtyFlg = shprCtyFlg;
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
	 * @param shprCntFlg
	 */
	public void setShprCntFlg(String shprCntFlg) {
		this.shprCntFlg = shprCntFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfyNmFlg
	 */
	public void setNtfyNmFlg(String ntfyNmFlg) {
		this.ntfyNmFlg = ntfyNmFlg;
	}
	
	/**
	 * Column Info
	 * @param wgtFlg
	 */
	public void setWgtFlg(String wgtFlg) {
		this.wgtFlg = wgtFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeCntFlg
	 */
	public void setCneeCntFlg(String cneeCntFlg) {
		this.cneeCntFlg = cneeCntFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrMfPckFlg
	 */
	public void setCntrMfPckFlg(String cntrMfPckFlg) {
		this.cntrMfPckFlg = cntrMfPckFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeStNmFlg
	 */
	public void setCneeStNmFlg(String cneeStNmFlg) {
		this.cneeStNmFlg = cneeStNmFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfyStNmFlg
	 */
	public void setNtfyStNmFlg(String ntfyStNmFlg) {
		this.ntfyStNmFlg = ntfyStNmFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfyZipFlg
	 */
	public void setNtfyZipFlg(String ntfyZipFlg) {
		this.ntfyZipFlg = ntfyZipFlg;
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
	 * @param cstmsDivId
	 */
	public void setCstmsDivId(String cstmsDivId) {
		this.cstmsDivId = cstmsDivId;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkFlg
	 */
	public void setCntrMfMkFlg(String cntrMfMkFlg) {
		this.cntrMfMkFlg = cntrMfMkFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrMfDescFlg
	 */
	public void setCntrMfDescFlg(String cntrMfDescFlg) {
		this.cntrMfDescFlg = cntrMfDescFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfyEoriNoFlg
	 */
	public void setNtfyEoriNoFlg(String ntfyEoriNoFlg) {
		this.ntfyEoriNoFlg = ntfyEoriNoFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeAddrFlg
	 */
	public void setCneeAddrFlg(String cneeAddrFlg) {
		this.cneeAddrFlg = cneeAddrFlg;
	}
	
	/**
	 * Column Info
	 * @param sealNoFlg
	 */
	public void setSealNoFlg(String sealNoFlg) {
		this.sealNoFlg = sealNoFlg;
	}
	
	/**
	 * Column Info
	 * @param shprEoriNoFlg
	 */
	public void setShprEoriNoFlg(String shprEoriNoFlg) {
		this.shprEoriNoFlg = shprEoriNoFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrNoFlg
	 */
	public void setCntrNoFlg(String cntrNoFlg) {
		this.cntrNoFlg = cntrNoFlg;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrMfNcmFlg
	 */
	public void setCntrMfNcmFlg(String cntrMfNcmFlg) {
		this.cntrMfNcmFlg = cntrMfNcmFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfySteFlg
	 */
	public void setNtfySteFlg(String ntfySteFlg) {
		this.ntfySteFlg = ntfySteFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeSteFlg
	 */
	public void setCneeSteFlg(String cneeSteFlg) {
		this.cneeSteFlg = cneeSteFlg;
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
	 * @param ntfyAddrFlg
	 */
	public void setNtfyAddrFlg(String ntfyAddrFlg) {
		this.ntfyAddrFlg = ntfyAddrFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeCtyFlg
	 */
	public void setCneeCtyFlg(String cneeCtyFlg) {
		this.cneeCtyFlg = cneeCtyFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeFaxFlg
	 */
	public void setCneeFaxFlg(String cneeFaxFlg) {
		this.cneeFaxFlg = cneeFaxFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMeasFlg
	 */
	public void setCntrMfMeasFlg(String cntrMfMeasFlg) {
		this.cntrMfMeasFlg = cntrMfMeasFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsCdFlg
	 */
	public void setCmdtHsCdFlg(String cmdtHsCdFlg) {
		this.cmdtHsCdFlg = cmdtHsCdFlg;
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
	 * @param ntfyFaxFlg
	 */
	public void setNtfyFaxFlg(String ntfyFaxFlg) {
		this.ntfyFaxFlg = ntfyFaxFlg;
	}
	
	/**
	 * Column Info
	 * @param xptImpCd
	 */
	public void setXptImpCd(String xptImpCd) {
		this.xptImpCd = xptImpCd;
	}
	
	/**
	 * Column Info
	 * @param cneeZipFlg
	 */
	public void setCneeZipFlg(String cneeZipFlg) {
		this.cneeZipFlg = cneeZipFlg;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cneeCoRgstFlg
	 */
	public void setCneeCoRgstFlg(String cneeCoRgstFlg) {
		this.cneeCoRgstFlg = cneeCoRgstFlg;
	}
	
	/**
	 * Column Info
	 * @param blDescFlg
	 */
	public void setBlDescFlg(String blDescFlg) {
		this.blDescFlg = blDescFlg;
	}
	
	/**
	 * Column Info
	 * @param cneePhnFlg
	 */
	public void setCneePhnFlg(String cneePhnFlg) {
		this.cneePhnFlg = cneePhnFlg;
	}
	
	/**
	 * Column Info
	 * @param shprNmFlg
	 */
	public void setShprNmFlg(String shprNmFlg) {
		this.shprNmFlg = shprNmFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfyCtyFlg
	 */
	public void setNtfyCtyFlg(String ntfyCtyFlg) {
		this.ntfyCtyFlg = ntfyCtyFlg;
	}
	
	/**
	 * Column Info
	 * @param shprSteFlg
	 */
	public void setShprSteFlg(String shprSteFlg) {
		this.shprSteFlg = shprSteFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfyPhnFlg
	 */
	public void setNtfyPhnFlg(String ntfyPhnFlg) {
		this.ntfyPhnFlg = ntfyPhnFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrPckFlg
	 */
	public void setCntrPckFlg(String cntrPckFlg) {
		this.cntrPckFlg = cntrPckFlg;
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
	 * @param shprZipFlg
	 */
	public void setShprZipFlg(String shprZipFlg) {
		this.shprZipFlg = shprZipFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeNmFlg
	 */
	public void setCneeNmFlg(String cneeNmFlg) {
		this.cneeNmFlg = cneeNmFlg;
	}
	
	/**
	 * Column Info
	 * @param xptImpRefFlg1
	 */
	public void setXptImpRefFlg1(String xptImpRefFlg1) {
		this.xptImpRefFlg1 = xptImpRefFlg1;
	}
	
	/**
	 * Column Info
	 * @param xptImpRefFlg4
	 */
	public void setXptImpRefFlg4(String xptImpRefFlg4) {
		this.xptImpRefFlg4 = xptImpRefFlg4;
	}
	
	/**
	 * Column Info
	 * @param pckFlg
	 */
	public void setPckFlg(String pckFlg) {
		this.pckFlg = pckFlg;
	}
	
	/**
	 * Column Info
	 * @param shprFaxFlg
	 */
	public void setShprFaxFlg(String shprFaxFlg) {
		this.shprFaxFlg = shprFaxFlg;
	}
	
	/**
	 * Column Info
	 * @param xptImpRefFlg5
	 */
	public void setXptImpRefFlg5(String xptImpRefFlg5) {
		this.xptImpRefFlg5 = xptImpRefFlg5;
	}
	
	/**
	 * Column Info
	 * @param cneeEoriNoFlg
	 */
	public void setCneeEoriNoFlg(String cneeEoriNoFlg) {
		this.cneeEoriNoFlg = cneeEoriNoFlg;
	}
	
	/**
	 * Column Info
	 * @param xptImpRefFlg2
	 */
	public void setXptImpRefFlg2(String xptImpRefFlg2) {
		this.xptImpRefFlg2 = xptImpRefFlg2;
	}
	
	/**
	 * Column Info
	 * @param xptImpRefFlg3
	 */
	public void setXptImpRefFlg3(String xptImpRefFlg3) {
		this.xptImpRefFlg3 = xptImpRefFlg3;
	}
	
	/**
	 * Column Info
	 * @param ntfyCntFlg
	 */
	public void setNtfyCntFlg(String ntfyCntFlg) {
		this.ntfyCntFlg = ntfyCntFlg;
	}
	
	/**
	 * Column Info
	 * @param shprAddrFlg
	 */
	public void setShprAddrFlg(String shprAddrFlg) {
		this.shprAddrFlg = shprAddrFlg;
	}
	
	/**
	 * Column Info
	 * @param xptImpRefFlg6
	 */
	public void setXptImpRefFlg6(String xptImpRefFlg6) {
		this.xptImpRefFlg6 = xptImpRefFlg6;
	}
	
	/**
	 * Column Info
	 * @param cntrMfWgtFlg
	 */
	public void setCntrMfWgtFlg(String cntrMfWgtFlg) {
		this.cntrMfWgtFlg = cntrMfWgtFlg;
	}
	
	/**
	 * Column Info
	 * @param xptImpRefFlg7
	 */
	public void setXptImpRefFlg7(String xptImpRefFlg7) {
		this.xptImpRefFlg7 = xptImpRefFlg7;
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
		setShprStNmFlg(JSPUtil.getParameter(request, prefix + "shpr_st_nm_flg", ""));
		setShprCoRgstFlg(JSPUtil.getParameter(request, prefix + "shpr_co_rgst_flg", ""));
		setFrobFlg(JSPUtil.getParameter(request, prefix + "frob_flg", ""));
		setCntrMfCmdtFlg(JSPUtil.getParameter(request, prefix + "cntr_mf_cmdt_flg", ""));
		setCntrWgtFlg(JSPUtil.getParameter(request, prefix + "cntr_wgt_flg", ""));
		setNtfyCoRgstFlg(JSPUtil.getParameter(request, prefix + "ntfy_co_rgst_flg", ""));
		setMeasFlg(JSPUtil.getParameter(request, prefix + "meas_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlMkFlg(JSPUtil.getParameter(request, prefix + "bl_mk_flg", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setShprPhnFlg(JSPUtil.getParameter(request, prefix + "shpr_phn_flg", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCntrMeasFlg(JSPUtil.getParameter(request, prefix + "cntr_meas_flg", ""));
		setShprCtyFlg(JSPUtil.getParameter(request, prefix + "shpr_cty_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setShprCntFlg(JSPUtil.getParameter(request, prefix + "shpr_cnt_flg", ""));
		setNtfyNmFlg(JSPUtil.getParameter(request, prefix + "ntfy_nm_flg", ""));
		setWgtFlg(JSPUtil.getParameter(request, prefix + "wgt_flg", ""));
		setCneeCntFlg(JSPUtil.getParameter(request, prefix + "cnee_cnt_flg", ""));
		setCntrMfPckFlg(JSPUtil.getParameter(request, prefix + "cntr_mf_pck_flg", ""));
		setCneeStNmFlg(JSPUtil.getParameter(request, prefix + "cnee_st_nm_flg", ""));
		setNtfyStNmFlg(JSPUtil.getParameter(request, prefix + "ntfy_st_nm_flg", ""));
		setNtfyZipFlg(JSPUtil.getParameter(request, prefix + "ntfy_zip_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCstmsDivId(JSPUtil.getParameter(request, prefix + "cstms_div_id", ""));
		setCntrMfMkFlg(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_flg", ""));
		setCntrMfDescFlg(JSPUtil.getParameter(request, prefix + "cntr_mf_desc_flg", ""));
		setNtfyEoriNoFlg(JSPUtil.getParameter(request, prefix + "ntfy_eori_no_flg", ""));
		setCneeAddrFlg(JSPUtil.getParameter(request, prefix + "cnee_addr_flg", ""));
		setSealNoFlg(JSPUtil.getParameter(request, prefix + "seal_no_flg", ""));
		setShprEoriNoFlg(JSPUtil.getParameter(request, prefix + "shpr_eori_no_flg", ""));
		setCntrNoFlg(JSPUtil.getParameter(request, prefix + "cntr_no_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCntrMfNcmFlg(JSPUtil.getParameter(request, prefix + "cntr_mf_ncm_flg", ""));
		setNtfySteFlg(JSPUtil.getParameter(request, prefix + "ntfy_ste_flg", ""));
		setCneeSteFlg(JSPUtil.getParameter(request, prefix + "cnee_ste_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNtfyAddrFlg(JSPUtil.getParameter(request, prefix + "ntfy_addr_flg", ""));
		setCneeCtyFlg(JSPUtil.getParameter(request, prefix + "cnee_cty_flg", ""));
		setCneeFaxFlg(JSPUtil.getParameter(request, prefix + "cnee_fax_flg", ""));
		setCntrMfMeasFlg(JSPUtil.getParameter(request, prefix + "cntr_mf_meas_flg", ""));
		setCmdtHsCdFlg(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNtfyFaxFlg(JSPUtil.getParameter(request, prefix + "ntfy_fax_flg", ""));
		setXptImpCd(JSPUtil.getParameter(request, prefix + "xpt_imp_cd", ""));
		setCneeZipFlg(JSPUtil.getParameter(request, prefix + "cnee_zip_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCneeCoRgstFlg(JSPUtil.getParameter(request, prefix + "cnee_co_rgst_flg", ""));
		setBlDescFlg(JSPUtil.getParameter(request, prefix + "bl_desc_flg", ""));
		setCneePhnFlg(JSPUtil.getParameter(request, prefix + "cnee_phn_flg", ""));
		setShprNmFlg(JSPUtil.getParameter(request, prefix + "shpr_nm_flg", ""));
		setNtfyCtyFlg(JSPUtil.getParameter(request, prefix + "ntfy_cty_flg", ""));
		setShprSteFlg(JSPUtil.getParameter(request, prefix + "shpr_ste_flg", ""));
		setNtfyPhnFlg(JSPUtil.getParameter(request, prefix + "ntfy_phn_flg", ""));
		setCntrPckFlg(JSPUtil.getParameter(request, prefix + "cntr_pck_flg", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setShprZipFlg(JSPUtil.getParameter(request, prefix + "shpr_zip_flg", ""));
		setCneeNmFlg(JSPUtil.getParameter(request, prefix + "cnee_nm_flg", ""));
		setXptImpRefFlg1(JSPUtil.getParameter(request, prefix + "xpt_imp_ref_flg1", ""));
		setXptImpRefFlg4(JSPUtil.getParameter(request, prefix + "xpt_imp_ref_flg4", ""));
		setPckFlg(JSPUtil.getParameter(request, prefix + "pck_flg", ""));
		setShprFaxFlg(JSPUtil.getParameter(request, prefix + "shpr_fax_flg", ""));
		setXptImpRefFlg5(JSPUtil.getParameter(request, prefix + "xpt_imp_ref_flg5", ""));
		setCneeEoriNoFlg(JSPUtil.getParameter(request, prefix + "cnee_eori_no_flg", ""));
		setXptImpRefFlg2(JSPUtil.getParameter(request, prefix + "xpt_imp_ref_flg2", ""));
		setXptImpRefFlg3(JSPUtil.getParameter(request, prefix + "xpt_imp_ref_flg3", ""));
		setNtfyCntFlg(JSPUtil.getParameter(request, prefix + "ntfy_cnt_flg", ""));
		setShprAddrFlg(JSPUtil.getParameter(request, prefix + "shpr_addr_flg", ""));
		setXptImpRefFlg6(JSPUtil.getParameter(request, prefix + "xpt_imp_ref_flg6", ""));
		setCntrMfWgtFlg(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt_flg", ""));
		setXptImpRefFlg7(JSPUtil.getParameter(request, prefix + "xpt_imp_ref_flg7", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ImpRuleSetupVO[]
	 */
	public ImpRuleSetupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ImpRuleSetupVO[]
	 */
	public ImpRuleSetupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ImpRuleSetupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shprStNmFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_st_nm_flg", length));
			String[] shprCoRgstFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_co_rgst_flg", length));
			String[] frobFlg = (JSPUtil.getParameter(request, prefix	+ "frob_flg", length));
			String[] cntrMfCmdtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_cmdt_flg", length));
			String[] cntrWgtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_flg", length));
			String[] ntfyCoRgstFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_co_rgst_flg", length));
			String[] measFlg = (JSPUtil.getParameter(request, prefix	+ "meas_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blMkFlg = (JSPUtil.getParameter(request, prefix	+ "bl_mk_flg", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] shprPhnFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_phn_flg", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntrMeasFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_meas_flg", length));
			String[] shprCtyFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_cty_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] shprCntFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_flg", length));
			String[] ntfyNmFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm_flg", length));
			String[] wgtFlg = (JSPUtil.getParameter(request, prefix	+ "wgt_flg", length));
			String[] cneeCntFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_flg", length));
			String[] cntrMfPckFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_pck_flg", length));
			String[] cneeStNmFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_st_nm_flg", length));
			String[] ntfyStNmFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_st_nm_flg", length));
			String[] ntfyZipFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_zip_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cstmsDivId = (JSPUtil.getParameter(request, prefix	+ "cstms_div_id", length));
			String[] cntrMfMkFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_flg", length));
			String[] cntrMfDescFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_desc_flg", length));
			String[] ntfyEoriNoFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_eori_no_flg", length));
			String[] cneeAddrFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_addr_flg", length));
			String[] sealNoFlg = (JSPUtil.getParameter(request, prefix	+ "seal_no_flg", length));
			String[] shprEoriNoFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_eori_no_flg", length));
			String[] cntrNoFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_no_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] cntrMfNcmFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_ncm_flg", length));
			String[] ntfySteFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_ste_flg", length));
			String[] cneeSteFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_ste_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ntfyAddrFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr_flg", length));
			String[] cneeCtyFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_cty_flg", length));
			String[] cneeFaxFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_fax_flg", length));
			String[] cntrMfMeasFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_meas_flg", length));
			String[] cmdtHsCdFlg = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntfyFaxFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_fax_flg", length));
			String[] xptImpCd = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_cd", length));
			String[] cneeZipFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_zip_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cneeCoRgstFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_co_rgst_flg", length));
			String[] blDescFlg = (JSPUtil.getParameter(request, prefix	+ "bl_desc_flg", length));
			String[] cneePhnFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_phn_flg", length));
			String[] shprNmFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_nm_flg", length));
			String[] ntfyCtyFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_cty_flg", length));
			String[] shprSteFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_ste_flg", length));
			String[] ntfyPhnFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_phn_flg", length));
			String[] cntrPckFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_pck_flg", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] shprZipFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_zip_flg", length));
			String[] cneeNmFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_nm_flg", length));
			String[] xptImpRefFlg1 = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_ref_flg1", length));
			String[] xptImpRefFlg4 = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_ref_flg4", length));
			String[] pckFlg = (JSPUtil.getParameter(request, prefix	+ "pck_flg", length));
			String[] shprFaxFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_fax_flg", length));
			String[] xptImpRefFlg5 = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_ref_flg5", length));
			String[] cneeEoriNoFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_eori_no_flg", length));
			String[] xptImpRefFlg2 = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_ref_flg2", length));
			String[] xptImpRefFlg3 = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_ref_flg3", length));
			String[] ntfyCntFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_flg", length));
			String[] shprAddrFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_addr_flg", length));
			String[] xptImpRefFlg6 = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_ref_flg6", length));
			String[] cntrMfWgtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt_flg", length));
			String[] xptImpRefFlg7 = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_ref_flg7", length));
			
			for (int i = 0; i < length; i++) {
				model = new ImpRuleSetupVO();
				if (shprStNmFlg[i] != null)
					model.setShprStNmFlg(shprStNmFlg[i]);
				if (shprCoRgstFlg[i] != null)
					model.setShprCoRgstFlg(shprCoRgstFlg[i]);
				if (frobFlg[i] != null)
					model.setFrobFlg(frobFlg[i]);
				if (cntrMfCmdtFlg[i] != null)
					model.setCntrMfCmdtFlg(cntrMfCmdtFlg[i]);
				if (cntrWgtFlg[i] != null)
					model.setCntrWgtFlg(cntrWgtFlg[i]);
				if (ntfyCoRgstFlg[i] != null)
					model.setNtfyCoRgstFlg(ntfyCoRgstFlg[i]);
				if (measFlg[i] != null)
					model.setMeasFlg(measFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blMkFlg[i] != null)
					model.setBlMkFlg(blMkFlg[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (shprPhnFlg[i] != null)
					model.setShprPhnFlg(shprPhnFlg[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cntrMeasFlg[i] != null)
					model.setCntrMeasFlg(cntrMeasFlg[i]);
				if (shprCtyFlg[i] != null)
					model.setShprCtyFlg(shprCtyFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (shprCntFlg[i] != null)
					model.setShprCntFlg(shprCntFlg[i]);
				if (ntfyNmFlg[i] != null)
					model.setNtfyNmFlg(ntfyNmFlg[i]);
				if (wgtFlg[i] != null)
					model.setWgtFlg(wgtFlg[i]);
				if (cneeCntFlg[i] != null)
					model.setCneeCntFlg(cneeCntFlg[i]);
				if (cntrMfPckFlg[i] != null)
					model.setCntrMfPckFlg(cntrMfPckFlg[i]);
				if (cneeStNmFlg[i] != null)
					model.setCneeStNmFlg(cneeStNmFlg[i]);
				if (ntfyStNmFlg[i] != null)
					model.setNtfyStNmFlg(ntfyStNmFlg[i]);
				if (ntfyZipFlg[i] != null)
					model.setNtfyZipFlg(ntfyZipFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cstmsDivId[i] != null)
					model.setCstmsDivId(cstmsDivId[i]);
				if (cntrMfMkFlg[i] != null)
					model.setCntrMfMkFlg(cntrMfMkFlg[i]);
				if (cntrMfDescFlg[i] != null)
					model.setCntrMfDescFlg(cntrMfDescFlg[i]);
				if (ntfyEoriNoFlg[i] != null)
					model.setNtfyEoriNoFlg(ntfyEoriNoFlg[i]);
				if (cneeAddrFlg[i] != null)
					model.setCneeAddrFlg(cneeAddrFlg[i]);
				if (sealNoFlg[i] != null)
					model.setSealNoFlg(sealNoFlg[i]);
				if (shprEoriNoFlg[i] != null)
					model.setShprEoriNoFlg(shprEoriNoFlg[i]);
				if (cntrNoFlg[i] != null)
					model.setCntrNoFlg(cntrNoFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (cntrMfNcmFlg[i] != null)
					model.setCntrMfNcmFlg(cntrMfNcmFlg[i]);
				if (ntfySteFlg[i] != null)
					model.setNtfySteFlg(ntfySteFlg[i]);
				if (cneeSteFlg[i] != null)
					model.setCneeSteFlg(cneeSteFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ntfyAddrFlg[i] != null)
					model.setNtfyAddrFlg(ntfyAddrFlg[i]);
				if (cneeCtyFlg[i] != null)
					model.setCneeCtyFlg(cneeCtyFlg[i]);
				if (cneeFaxFlg[i] != null)
					model.setCneeFaxFlg(cneeFaxFlg[i]);
				if (cntrMfMeasFlg[i] != null)
					model.setCntrMfMeasFlg(cntrMfMeasFlg[i]);
				if (cmdtHsCdFlg[i] != null)
					model.setCmdtHsCdFlg(cmdtHsCdFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntfyFaxFlg[i] != null)
					model.setNtfyFaxFlg(ntfyFaxFlg[i]);
				if (xptImpCd[i] != null)
					model.setXptImpCd(xptImpCd[i]);
				if (cneeZipFlg[i] != null)
					model.setCneeZipFlg(cneeZipFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cneeCoRgstFlg[i] != null)
					model.setCneeCoRgstFlg(cneeCoRgstFlg[i]);
				if (blDescFlg[i] != null)
					model.setBlDescFlg(blDescFlg[i]);
				if (cneePhnFlg[i] != null)
					model.setCneePhnFlg(cneePhnFlg[i]);
				if (shprNmFlg[i] != null)
					model.setShprNmFlg(shprNmFlg[i]);
				if (ntfyCtyFlg[i] != null)
					model.setNtfyCtyFlg(ntfyCtyFlg[i]);
				if (shprSteFlg[i] != null)
					model.setShprSteFlg(shprSteFlg[i]);
				if (ntfyPhnFlg[i] != null)
					model.setNtfyPhnFlg(ntfyPhnFlg[i]);
				if (cntrPckFlg[i] != null)
					model.setCntrPckFlg(cntrPckFlg[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (shprZipFlg[i] != null)
					model.setShprZipFlg(shprZipFlg[i]);
				if (cneeNmFlg[i] != null)
					model.setCneeNmFlg(cneeNmFlg[i]);
				if (xptImpRefFlg1[i] != null)
					model.setXptImpRefFlg1(xptImpRefFlg1[i]);
				if (xptImpRefFlg4[i] != null)
					model.setXptImpRefFlg4(xptImpRefFlg4[i]);
				if (pckFlg[i] != null)
					model.setPckFlg(pckFlg[i]);
				if (shprFaxFlg[i] != null)
					model.setShprFaxFlg(shprFaxFlg[i]);
				if (xptImpRefFlg5[i] != null)
					model.setXptImpRefFlg5(xptImpRefFlg5[i]);
				if (cneeEoriNoFlg[i] != null)
					model.setCneeEoriNoFlg(cneeEoriNoFlg[i]);
				if (xptImpRefFlg2[i] != null)
					model.setXptImpRefFlg2(xptImpRefFlg2[i]);
				if (xptImpRefFlg3[i] != null)
					model.setXptImpRefFlg3(xptImpRefFlg3[i]);
				if (ntfyCntFlg[i] != null)
					model.setNtfyCntFlg(ntfyCntFlg[i]);
				if (shprAddrFlg[i] != null)
					model.setShprAddrFlg(shprAddrFlg[i]);
				if (xptImpRefFlg6[i] != null)
					model.setXptImpRefFlg6(xptImpRefFlg6[i]);
				if (cntrMfWgtFlg[i] != null)
					model.setCntrMfWgtFlg(cntrMfWgtFlg[i]);
				if (xptImpRefFlg7[i] != null)
					model.setXptImpRefFlg7(xptImpRefFlg7[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getImpRuleSetupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ImpRuleSetupVO[]
	 */
	public ImpRuleSetupVO[] getImpRuleSetupVOs(){
		ImpRuleSetupVO[] vos = (ImpRuleSetupVO[])models.toArray(new ImpRuleSetupVO[models.size()]);
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
		this.shprStNmFlg = this.shprStNmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCoRgstFlg = this.shprCoRgstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frobFlg = this.frobFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfCmdtFlg = this.cntrMfCmdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtFlg = this.cntrWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCoRgstFlg = this.ntfyCoRgstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measFlg = this.measFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMkFlg = this.blMkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprPhnFlg = this.shprPhnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeasFlg = this.cntrMeasFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCtyFlg = this.shprCtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntFlg = this.shprCntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNmFlg = this.ntfyNmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtFlg = this.wgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntFlg = this.cneeCntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfPckFlg = this.cntrMfPckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeStNmFlg = this.cneeStNmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyStNmFlg = this.ntfyStNmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyZipFlg = this.ntfyZipFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDivId = this.cstmsDivId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkFlg = this.cntrMfMkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfDescFlg = this.cntrMfDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyEoriNoFlg = this.ntfyEoriNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddrFlg = this.cneeAddrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNoFlg = this.sealNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprEoriNoFlg = this.shprEoriNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoFlg = this.cntrNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNcmFlg = this.cntrMfNcmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfySteFlg = this.ntfySteFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSteFlg = this.cneeSteFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddrFlg = this.ntfyAddrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCtyFlg = this.cneeCtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeFaxFlg = this.cneeFaxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMeasFlg = this.cntrMfMeasFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCdFlg = this.cmdtHsCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyFaxFlg = this.ntfyFaxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpCd = this.xptImpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeZipFlg = this.cneeZipFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCoRgstFlg = this.cneeCoRgstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDescFlg = this.blDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneePhnFlg = this.cneePhnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNmFlg = this.shprNmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCtyFlg = this.ntfyCtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSteFlg = this.shprSteFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyPhnFlg = this.ntfyPhnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPckFlg = this.cntrPckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprZipFlg = this.shprZipFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNmFlg = this.cneeNmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpRefFlg1 = this.xptImpRefFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpRefFlg4 = this.xptImpRefFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckFlg = this.pckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprFaxFlg = this.shprFaxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpRefFlg5 = this.xptImpRefFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeEoriNoFlg = this.cneeEoriNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpRefFlg2 = this.xptImpRefFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpRefFlg3 = this.xptImpRefFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntFlg = this.ntfyCntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddrFlg = this.shprAddrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpRefFlg6 = this.xptImpRefFlg6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgtFlg = this.cntrMfWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpRefFlg7 = this.xptImpRefFlg7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
