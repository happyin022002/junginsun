/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltRtListHorizontalLoadExcelForIHCVO.java
*@FileTitle : RsltRtListHorizontalLoadExcelForIHCVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.02
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.07.02 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo;

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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtListHorizontalLoadExcelForIHCVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtListHorizontalLoadExcelForIHCVO> models = new ArrayList<RsltRtListHorizontalLoadExcelForIHCVO>();
	
	/* Column Info */
	private String ratePropDry45 = null;
	/* Column Info */
	private String pscDry45 = null;
	/* Column Info */
	private String ficGlineRtAmtRateRf40hc = null;
	/* Column Info */
	private String rateRd40hc = null;
	/* Column Info */
	private String bucDry20 = null;
	/* Column Info */
	private String ratePropDry40 = null;
	/* Column Info */
	private String bucDry40hc = null;
	/* Column Info */
	private String pscDry40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rateDry45 = null;
	/* Column Info */
	private String rateBofDry20 = null;
	/* Column Info */
	private String ficGlineUpdDt = null;
	/* Column Info */
	private String ratePropRf40hc = null;
	/* Column Info */
	private String ratePropRd40hc = null;
	/* Column Info */
	private String rateBofRf40hc = null;
	/* Column Info */
	private String rateDry40 = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String rateBofDry40hc = null;
	/* Column Info */
	private String optmTrspModFlgRateDry20 = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String bucRf40hc = null;
	/* Column Info */
	private String ifcRd40hc = null;
	/* Column Info */
	private String rateBofDry45 = null;
	/* Column Info */
	private String basePortList = null;
	/* Column Info */
	private String ficRoutCmbTpCd = null;
	/* Column Info */
	private String pscRf40hc = null;
	/* Column Info */
	private String ficGlineRtAmtRateDry40 = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String rateDry40hc = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String ficRtUseStsCdRateDry45 = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String ratePropDry40hc = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String ficRtUseStsCdRateDry40 = null;
	/* Column Info */
	private String pscDry40hc = null;
	/* Column Info */
	private String ifcDry20 = null;
	/* Column Info */
	private String destPrcTrspModNm = null;
	/* Column Info */
	private String rateBofDry40 = null;
	/* Column Info */
	private String ficRtUseStsCdRateDry40hc = null;
	/* Column Info */
	private String orgRcvDeTermNm = null;
	/* Column Info */
	private String ficGlineRtAmtRateRd40hc = null;
	/* Column Info */
	private String bucDry40 = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String ifcDry45 = null;
	/* Column Info */
	private String bucDry45 = null;
	/* Column Info */
	private String pscDry20 = null;
	/* Column Info */
	private String optmTrspModFlgRateRd40hc = null;
	/* Column Info */
	private String pscRd40hc = null;
	/* Column Info */
	private String ifcDry40 = null;
	/* Column Info */
	private String ratePropDry20 = null;
	/* Column Info */
	private String rateDry20 = null;
	/* Column Info */
	private String orgPrcTrspModNm = null;
	/* Column Info */
	private String groupNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ifcDry40hc = null;
	/* Column Info */
	private String rateBofRd40hc = null;
	/* Column Info */
	private String optmTrspModFlgRateDry45 = null;
	/* Column Info */
	private String ifcRf40hc = null;
	/* Column Info */
	private String bucRd40hc = null;
	/* Column Info */
	private String ficGlineRtAmtRateDry45 = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String ficRtUseStsCdRateRd40hc = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String optmTrspModFlgRateDry40 = null;
	/* Column Info */
	private String ficRtUseStsCdRateRf40hc = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String optmTrspModFlgRateRf40hc = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ficGlineRtAmtRateDry20 = null;
	/* Column Info */
	private String optmTrspModFlgRateDry40hc = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String rateRf40hc = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String ficRtUseStsCdRateDry20 = null;
	/* Column Info */
	private String ficGlineRtAmtRateDry40hc = null;
	/* Column Info */
	private String destRcvDeTermNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtListHorizontalLoadExcelForIHCVO() {}

	public RsltRtListHorizontalLoadExcelForIHCVO(String ibflag, String pagerows, String cmdtDpSeq, String prcCmdtDefCd, String prcCmdtDefNm, String custSeq, String custLglEngNm, String routDpSeq, String orgRoutPntLocDefCd, String orgRoutPntLocDefNm, String orgRcvDeTermNm, String orgPrcTrspModNm, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String destRoutPntLocDefNm, String destRcvDeTermNm, String destPrcTrspModNm, String rateDry20, String rateBofDry20, String ratePropDry20, String rateDry40, String rateBofDry40, String ratePropDry40, String rateDry40hc, String rateBofDry40hc, String ratePropDry40hc, String rateDry45, String rateBofDry45, String ratePropDry45, String rateRf40hc, String rateBofRf40hc, String ratePropRf40hc, String rateRd40hc, String rateBofRd40hc, String ratePropRd40hc, String ficRtUseStsCd, String optmTrspModFlg, String basePortList, String ficRoutCmbTpCd, String ficGlineUpdDt, String groupNo, String bsePortLocCd, String ficGlineRtAmtRateDry20, String ficRtUseStsCdRateDry20, String optmTrspModFlgRateDry20, String ficGlineRtAmtRateDry40, String ficRtUseStsCdRateDry40, String optmTrspModFlgRateDry40, String ficGlineRtAmtRateDry40hc, String ficRtUseStsCdRateDry40hc, String optmTrspModFlgRateDry40hc, String ficGlineRtAmtRateDry45, String ficRtUseStsCdRateDry45, String optmTrspModFlgRateDry45, String ficGlineRtAmtRateRf40hc, String ficRtUseStsCdRateRf40hc, String optmTrspModFlgRateRf40hc, String ficGlineRtAmtRateRd40hc, String ficRtUseStsCdRateRd40hc, String optmTrspModFlgRateRd40hc, String bucDry20, String bucDry40, String bucDry40hc, String bucDry45, String bucRf40hc, String bucRd40hc, String ifcDry20, String ifcDry40, String ifcDry40hc, String ifcDry45, String ifcRf40hc, String ifcRd40hc, String pscDry20, String pscDry40, String pscDry40hc, String pscDry45, String pscRf40hc, String pscRd40hc) {
		this.ratePropDry45 = ratePropDry45;
		this.pscDry45 = pscDry45;
		this.ficGlineRtAmtRateRf40hc = ficGlineRtAmtRateRf40hc;
		this.rateRd40hc = rateRd40hc;
		this.bucDry20 = bucDry20;
		this.ratePropDry40 = ratePropDry40;
		this.bucDry40hc = bucDry40hc;
		this.pscDry40 = pscDry40;
		this.pagerows = pagerows;
		this.rateDry45 = rateDry45;
		this.rateBofDry20 = rateBofDry20;
		this.ficGlineUpdDt = ficGlineUpdDt;
		this.ratePropRf40hc = ratePropRf40hc;
		this.ratePropRd40hc = ratePropRd40hc;
		this.rateBofRf40hc = rateBofRf40hc;
		this.rateDry40 = rateDry40;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.rateBofDry40hc = rateBofDry40hc;
		this.optmTrspModFlgRateDry20 = optmTrspModFlgRateDry20;
		this.bsePortLocCd = bsePortLocCd;
		this.bucRf40hc = bucRf40hc;
		this.ifcRd40hc = ifcRd40hc;
		this.rateBofDry45 = rateBofDry45;
		this.basePortList = basePortList;
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
		this.pscRf40hc = pscRf40hc;
		this.ficGlineRtAmtRateDry40 = ficGlineRtAmtRateDry40;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.rateDry40hc = rateDry40hc;
		this.custLglEngNm = custLglEngNm;
		this.ficRtUseStsCdRateDry45 = ficRtUseStsCdRateDry45;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.ratePropDry40hc = ratePropDry40hc;
		this.cmdtDpSeq = cmdtDpSeq;
		this.ficRtUseStsCdRateDry40 = ficRtUseStsCdRateDry40;
		this.pscDry40hc = pscDry40hc;
		this.ifcDry20 = ifcDry20;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.rateBofDry40 = rateBofDry40;
		this.ficRtUseStsCdRateDry40hc = ficRtUseStsCdRateDry40hc;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.ficGlineRtAmtRateRd40hc = ficGlineRtAmtRateRd40hc;
		this.bucDry40 = bucDry40;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.ifcDry45 = ifcDry45;
		this.bucDry45 = bucDry45;
		this.pscDry20 = pscDry20;
		this.optmTrspModFlgRateRd40hc = optmTrspModFlgRateRd40hc;
		this.pscRd40hc = pscRd40hc;
		this.ifcDry40 = ifcDry40;
		this.ratePropDry20 = ratePropDry20;
		this.rateDry20 = rateDry20;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.groupNo = groupNo;
		this.ibflag = ibflag;
		this.ifcDry40hc = ifcDry40hc;
		this.rateBofRd40hc = rateBofRd40hc;
		this.optmTrspModFlgRateDry45 = optmTrspModFlgRateDry45;
		this.ifcRf40hc = ifcRf40hc;
		this.bucRd40hc = bucRd40hc;
		this.ficGlineRtAmtRateDry45 = ficGlineRtAmtRateDry45;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.ficRtUseStsCdRateRd40hc = ficRtUseStsCdRateRd40hc;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.optmTrspModFlgRateDry40 = optmTrspModFlgRateDry40;
		this.ficRtUseStsCdRateRf40hc = ficRtUseStsCdRateRf40hc;
		this.optmTrspModFlg = optmTrspModFlg;
		this.optmTrspModFlgRateRf40hc = optmTrspModFlgRateRf40hc;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.custSeq = custSeq;
		this.ficGlineRtAmtRateDry20 = ficGlineRtAmtRateDry20;
		this.optmTrspModFlgRateDry40hc = optmTrspModFlgRateDry40hc;
		this.routDpSeq = routDpSeq;
		this.rateRf40hc = rateRf40hc;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.ficRtUseStsCdRateDry20 = ficRtUseStsCdRateDry20;
		this.ficGlineRtAmtRateDry40hc = ficGlineRtAmtRateDry40hc;
		this.destRcvDeTermNm = destRcvDeTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rate_prop_dry45", getRatePropDry45());
		this.hashColumns.put("psc_dry45", getPscDry45());
		this.hashColumns.put("fic_gline_rt_amt_rate_rf40hc", getFicGlineRtAmtRateRf40hc());
		this.hashColumns.put("rate_rd40hc", getRateRd40hc());
		this.hashColumns.put("buc_dry20", getBucDry20());
		this.hashColumns.put("rate_prop_dry40", getRatePropDry40());
		this.hashColumns.put("buc_dry40hc", getBucDry40hc());
		this.hashColumns.put("psc_dry40", getPscDry40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rate_dry45", getRateDry45());
		this.hashColumns.put("rate_bof_dry20", getRateBofDry20());
		this.hashColumns.put("fic_gline_upd_dt", getFicGlineUpdDt());
		this.hashColumns.put("rate_prop_rf40hc", getRatePropRf40hc());
		this.hashColumns.put("rate_prop_rd40hc", getRatePropRd40hc());
		this.hashColumns.put("rate_bof_rf40hc", getRateBofRf40hc());
		this.hashColumns.put("rate_dry40", getRateDry40());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("rate_bof_dry40hc", getRateBofDry40hc());
		this.hashColumns.put("optm_trsp_mod_flg_rate_dry20", getOptmTrspModFlgRateDry20());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("buc_rf_40hc", getBucRf40hc());
		this.hashColumns.put("ifc_rd40hc", getIfcRd40hc());
		this.hashColumns.put("rate_bof_dry45", getRateBofDry45());
		this.hashColumns.put("base_port_list", getBasePortList());
		this.hashColumns.put("fic_rout_cmb_tp_cd", getFicRoutCmbTpCd());
		this.hashColumns.put("psc_rf_40hc", getPscRf40hc());
		this.hashColumns.put("fic_gline_rt_amt_rate_dry40", getFicGlineRtAmtRateDry40());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("rate_dry40hc", getRateDry40hc());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("fic_rt_use_sts_cd_rate_dry45", getFicRtUseStsCdRateDry45());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("rate_prop_dry40hc", getRatePropDry40hc());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("fic_rt_use_sts_cd_rate_dry40", getFicRtUseStsCdRateDry40());
		this.hashColumns.put("psc_dry40hc", getPscDry40hc());
		this.hashColumns.put("ifc_dry20", getIfcDry20());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("rate_bof_dry40", getRateBofDry40());
		this.hashColumns.put("fic_rt_use_sts_cd_rate_dry40hc", getFicRtUseStsCdRateDry40hc());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("fic_gline_rt_amt_rate_rd40hc", getFicGlineRtAmtRateRd40hc());
		this.hashColumns.put("buc_dry40", getBucDry40());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("ifc_dry45", getIfcDry45());
		this.hashColumns.put("buc_dry45", getBucDry45());
		this.hashColumns.put("psc_dry20", getPscDry20());
		this.hashColumns.put("optm_trsp_mod_flg_rate_rd40hc", getOptmTrspModFlgRateRd40hc());
		this.hashColumns.put("psc_rd40hc", getPscRd40hc());
		this.hashColumns.put("ifc_dry40", getIfcDry40());
		this.hashColumns.put("rate_prop_dry20", getRatePropDry20());
		this.hashColumns.put("rate_dry20", getRateDry20());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("group_no", getGroupNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ifc_dry40hc", getIfcDry40hc());
		this.hashColumns.put("rate_bof_rd40hc", getRateBofRd40hc());
		this.hashColumns.put("optm_trsp_mod_flg_rate_dry45", getOptmTrspModFlgRateDry45());
		this.hashColumns.put("ifc_rf_40hc", getIfcRf40hc());
		this.hashColumns.put("buc_rd40hc", getBucRd40hc());
		this.hashColumns.put("fic_gline_rt_amt_rate_dry45", getFicGlineRtAmtRateDry45());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("fic_rt_use_sts_cd_rate_rd40hc", getFicRtUseStsCdRateRd40hc());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("optm_trsp_mod_flg_rate_dry40", getOptmTrspModFlgRateDry40());
		this.hashColumns.put("fic_rt_use_sts_cd_rate_rf40hc", getFicRtUseStsCdRateRf40hc());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("optm_trsp_mod_flg_rate_rf40hc", getOptmTrspModFlgRateRf40hc());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("fic_gline_rt_amt_rate_dry20", getFicGlineRtAmtRateDry20());
		this.hashColumns.put("optm_trsp_mod_flg_rate_dry40hc", getOptmTrspModFlgRateDry40hc());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("rate_rf40hc", getRateRf40hc());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("fic_rt_use_sts_cd_rate_dry20", getFicRtUseStsCdRateDry20());
		this.hashColumns.put("fic_gline_rt_amt_rate_dry40hc", getFicGlineRtAmtRateDry40hc());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rate_prop_dry45", "ratePropDry45");
		this.hashFields.put("psc_dry45", "pscDry45");
		this.hashFields.put("fic_gline_rt_amt_rate_rf40hc", "ficGlineRtAmtRateRf40hc");
		this.hashFields.put("rate_rd40hc", "rateRd40hc");
		this.hashFields.put("buc_dry20", "bucDry20");
		this.hashFields.put("rate_prop_dry40", "ratePropDry40");
		this.hashFields.put("buc_dry40hc", "bucDry40hc");
		this.hashFields.put("psc_dry40", "pscDry40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rate_dry45", "rateDry45");
		this.hashFields.put("rate_bof_dry20", "rateBofDry20");
		this.hashFields.put("fic_gline_upd_dt", "ficGlineUpdDt");
		this.hashFields.put("rate_prop_rf40hc", "ratePropRf40hc");
		this.hashFields.put("rate_prop_rd40hc", "ratePropRd40hc");
		this.hashFields.put("rate_bof_rf40hc", "rateBofRf40hc");
		this.hashFields.put("rate_dry40", "rateDry40");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("rate_bof_dry40hc", "rateBofDry40hc");
		this.hashFields.put("optm_trsp_mod_flg_rate_dry20", "optmTrspModFlgRateDry20");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("buc_rf_40hc", "bucRf40hc");
		this.hashFields.put("ifc_rd40hc", "ifcRd40hc");
		this.hashFields.put("rate_bof_dry45", "rateBofDry45");
		this.hashFields.put("base_port_list", "basePortList");
		this.hashFields.put("fic_rout_cmb_tp_cd", "ficRoutCmbTpCd");
		this.hashFields.put("psc_rf_40hc", "pscRf40hc");
		this.hashFields.put("fic_gline_rt_amt_rate_dry40", "ficGlineRtAmtRateDry40");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("rate_dry40hc", "rateDry40hc");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("fic_rt_use_sts_cd_rate_dry45", "ficRtUseStsCdRateDry45");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("rate_prop_dry40hc", "ratePropDry40hc");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("fic_rt_use_sts_cd_rate_dry40", "ficRtUseStsCdRateDry40");
		this.hashFields.put("psc_dry40hc", "pscDry40hc");
		this.hashFields.put("ifc_dry20", "ifcDry20");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("rate_bof_dry40", "rateBofDry40");
		this.hashFields.put("fic_rt_use_sts_cd_rate_dry40hc", "ficRtUseStsCdRateDry40hc");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("fic_gline_rt_amt_rate_rd40hc", "ficGlineRtAmtRateRd40hc");
		this.hashFields.put("buc_dry40", "bucDry40");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("ifc_dry45", "ifcDry45");
		this.hashFields.put("buc_dry45", "bucDry45");
		this.hashFields.put("psc_dry20", "pscDry20");
		this.hashFields.put("optm_trsp_mod_flg_rate_rd40hc", "optmTrspModFlgRateRd40hc");
		this.hashFields.put("psc_rd40hc", "pscRd40hc");
		this.hashFields.put("ifc_dry40", "ifcDry40");
		this.hashFields.put("rate_prop_dry20", "ratePropDry20");
		this.hashFields.put("rate_dry20", "rateDry20");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("group_no", "groupNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ifc_dry40hc", "ifcDry40hc");
		this.hashFields.put("rate_bof_rd40hc", "rateBofRd40hc");
		this.hashFields.put("optm_trsp_mod_flg_rate_dry45", "optmTrspModFlgRateDry45");
		this.hashFields.put("ifc_rf_40hc", "ifcRf40hc");
		this.hashFields.put("buc_rd40hc", "bucRd40hc");
		this.hashFields.put("fic_gline_rt_amt_rate_dry45", "ficGlineRtAmtRateDry45");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("fic_rt_use_sts_cd_rate_rd40hc", "ficRtUseStsCdRateRd40hc");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("optm_trsp_mod_flg_rate_dry40", "optmTrspModFlgRateDry40");
		this.hashFields.put("fic_rt_use_sts_cd_rate_rf40hc", "ficRtUseStsCdRateRf40hc");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("optm_trsp_mod_flg_rate_rf40hc", "optmTrspModFlgRateRf40hc");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("fic_gline_rt_amt_rate_dry20", "ficGlineRtAmtRateDry20");
		this.hashFields.put("optm_trsp_mod_flg_rate_dry40hc", "optmTrspModFlgRateDry40hc");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("rate_rf40hc", "rateRf40hc");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("fic_rt_use_sts_cd_rate_dry20", "ficRtUseStsCdRateDry20");
		this.hashFields.put("fic_gline_rt_amt_rate_dry40hc", "ficGlineRtAmtRateDry40hc");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ratePropDry45
	 */
	public String getRatePropDry45() {
		return this.ratePropDry45;
	}
	
	/**
	 * Column Info
	 * @return pscDry45
	 */
	public String getPscDry45() {
		return this.pscDry45;
	}
	
	/**
	 * Column Info
	 * @return ficGlineRtAmtRateRf40hc
	 */
	public String getFicGlineRtAmtRateRf40hc() {
		return this.ficGlineRtAmtRateRf40hc;
	}
	
	/**
	 * Column Info
	 * @return rateRd40hc
	 */
	public String getRateRd40hc() {
		return this.rateRd40hc;
	}
	
	/**
	 * Column Info
	 * @return bucDry20
	 */
	public String getBucDry20() {
		return this.bucDry20;
	}
	
	/**
	 * Column Info
	 * @return ratePropDry40
	 */
	public String getRatePropDry40() {
		return this.ratePropDry40;
	}
	
	/**
	 * Column Info
	 * @return bucDry40hc
	 */
	public String getBucDry40hc() {
		return this.bucDry40hc;
	}
	
	/**
	 * Column Info
	 * @return pscDry40
	 */
	public String getPscDry40() {
		return this.pscDry40;
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
	 * @return rateDry45
	 */
	public String getRateDry45() {
		return this.rateDry45;
	}
	
	/**
	 * Column Info
	 * @return rateBofDry20
	 */
	public String getRateBofDry20() {
		return this.rateBofDry20;
	}
	
	/**
	 * Column Info
	 * @return ficGlineUpdDt
	 */
	public String getFicGlineUpdDt() {
		return this.ficGlineUpdDt;
	}
	
	/**
	 * Column Info
	 * @return ratePropRf40hc
	 */
	public String getRatePropRf40hc() {
		return this.ratePropRf40hc;
	}
	
	/**
	 * Column Info
	 * @return ratePropRd40hc
	 */
	public String getRatePropRd40hc() {
		return this.ratePropRd40hc;
	}
	
	/**
	 * Column Info
	 * @return rateBofRf40hc
	 */
	public String getRateBofRf40hc() {
		return this.rateBofRf40hc;
	}
	
	/**
	 * Column Info
	 * @return rateDry40
	 */
	public String getRateDry40() {
		return this.rateDry40;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return rateBofDry40hc
	 */
	public String getRateBofDry40hc() {
		return this.rateBofDry40hc;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlgRateDry20
	 */
	public String getOptmTrspModFlgRateDry20() {
		return this.optmTrspModFlgRateDry20;
	}
	
	/**
	 * Column Info
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return bucRf40hc
	 */
	public String getBucRf40hc() {
		return this.bucRf40hc;
	}
	
	/**
	 * Column Info
	 * @return ifcRd40hc
	 */
	public String getIfcRd40hc() {
		return this.ifcRd40hc;
	}
	
	/**
	 * Column Info
	 * @return rateBofDry45
	 */
	public String getRateBofDry45() {
		return this.rateBofDry45;
	}
	
	/**
	 * Column Info
	 * @return basePortList
	 */
	public String getBasePortList() {
		return this.basePortList;
	}
	
	/**
	 * Column Info
	 * @return ficRoutCmbTpCd
	 */
	public String getFicRoutCmbTpCd() {
		return this.ficRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @return pscRf40hc
	 */
	public String getPscRf40hc() {
		return this.pscRf40hc;
	}
	
	/**
	 * Column Info
	 * @return ficGlineRtAmtRateDry40
	 */
	public String getFicGlineRtAmtRateDry40() {
		return this.ficGlineRtAmtRateDry40;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return rateDry40hc
	 */
	public String getRateDry40hc() {
		return this.rateDry40hc;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCdRateDry45
	 */
	public String getFicRtUseStsCdRateDry45() {
		return this.ficRtUseStsCdRateDry45;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefNm
	 */
	public String getOrgRoutPntLocDefNm() {
		return this.orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return ratePropDry40hc
	 */
	public String getRatePropDry40hc() {
		return this.ratePropDry40hc;
	}
	
	/**
	 * Column Info
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCdRateDry40
	 */
	public String getFicRtUseStsCdRateDry40() {
		return this.ficRtUseStsCdRateDry40;
	}
	
	/**
	 * Column Info
	 * @return pscDry40hc
	 */
	public String getPscDry40hc() {
		return this.pscDry40hc;
	}
	
	/**
	 * Column Info
	 * @return ifcDry20
	 */
	public String getIfcDry20() {
		return this.ifcDry20;
	}
	
	/**
	 * Column Info
	 * @return destPrcTrspModNm
	 */
	public String getDestPrcTrspModNm() {
		return this.destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return rateBofDry40
	 */
	public String getRateBofDry40() {
		return this.rateBofDry40;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCdRateDry40hc
	 */
	public String getFicRtUseStsCdRateDry40hc() {
		return this.ficRtUseStsCdRateDry40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRcvDeTermNm
	 */
	public String getOrgRcvDeTermNm() {
		return this.orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return ficGlineRtAmtRateRd40hc
	 */
	public String getFicGlineRtAmtRateRd40hc() {
		return this.ficGlineRtAmtRateRd40hc;
	}
	
	/**
	 * Column Info
	 * @return bucDry40
	 */
	public String getBucDry40() {
		return this.bucDry40;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return ifcDry45
	 */
	public String getIfcDry45() {
		return this.ifcDry45;
	}
	
	/**
	 * Column Info
	 * @return bucDry45
	 */
	public String getBucDry45() {
		return this.bucDry45;
	}
	
	/**
	 * Column Info
	 * @return pscDry20
	 */
	public String getPscDry20() {
		return this.pscDry20;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlgRateRd40hc
	 */
	public String getOptmTrspModFlgRateRd40hc() {
		return this.optmTrspModFlgRateRd40hc;
	}
	
	/**
	 * Column Info
	 * @return pscRd40hc
	 */
	public String getPscRd40hc() {
		return this.pscRd40hc;
	}
	
	/**
	 * Column Info
	 * @return ifcDry40
	 */
	public String getIfcDry40() {
		return this.ifcDry40;
	}
	
	/**
	 * Column Info
	 * @return ratePropDry20
	 */
	public String getRatePropDry20() {
		return this.ratePropDry20;
	}
	
	/**
	 * Column Info
	 * @return rateDry20
	 */
	public String getRateDry20() {
		return this.rateDry20;
	}
	
	/**
	 * Column Info
	 * @return orgPrcTrspModNm
	 */
	public String getOrgPrcTrspModNm() {
		return this.orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return groupNo
	 */
	public String getGroupNo() {
		return this.groupNo;
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
	 * @return ifcDry40hc
	 */
	public String getIfcDry40hc() {
		return this.ifcDry40hc;
	}
	
	/**
	 * Column Info
	 * @return rateBofRd40hc
	 */
	public String getRateBofRd40hc() {
		return this.rateBofRd40hc;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlgRateDry45
	 */
	public String getOptmTrspModFlgRateDry45() {
		return this.optmTrspModFlgRateDry45;
	}
	
	/**
	 * Column Info
	 * @return ifcRf40hc
	 */
	public String getIfcRf40hc() {
		return this.ifcRf40hc;
	}
	
	/**
	 * Column Info
	 * @return bucRd40hc
	 */
	public String getBucRd40hc() {
		return this.bucRd40hc;
	}
	
	/**
	 * Column Info
	 * @return ficGlineRtAmtRateDry45
	 */
	public String getFicGlineRtAmtRateDry45() {
		return this.ficGlineRtAmtRateDry45;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCdRateRd40hc
	 */
	public String getFicRtUseStsCdRateRd40hc() {
		return this.ficRtUseStsCdRateRd40hc;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlgRateDry40
	 */
	public String getOptmTrspModFlgRateDry40() {
		return this.optmTrspModFlgRateDry40;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCdRateRf40hc
	 */
	public String getFicRtUseStsCdRateRf40hc() {
		return this.ficRtUseStsCdRateRf40hc;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlg
	 */
	public String getOptmTrspModFlg() {
		return this.optmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlgRateRf40hc
	 */
	public String getOptmTrspModFlgRateRf40hc() {
		return this.optmTrspModFlgRateRf40hc;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCd
	 */
	public String getFicRtUseStsCd() {
		return this.ficRtUseStsCd;
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
	 * @return ficGlineRtAmtRateDry20
	 */
	public String getFicGlineRtAmtRateDry20() {
		return this.ficGlineRtAmtRateDry20;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlgRateDry40hc
	 */
	public String getOptmTrspModFlgRateDry40hc() {
		return this.optmTrspModFlgRateDry40hc;
	}
	
	/**
	 * Column Info
	 * @return routDpSeq
	 */
	public String getRoutDpSeq() {
		return this.routDpSeq;
	}
	
	/**
	 * Column Info
	 * @return rateRf40hc
	 */
	public String getRateRf40hc() {
		return this.rateRf40hc;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefNm
	 */
	public String getDestRoutPntLocDefNm() {
		return this.destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCdRateDry20
	 */
	public String getFicRtUseStsCdRateDry20() {
		return this.ficRtUseStsCdRateDry20;
	}
	
	/**
	 * Column Info
	 * @return ficGlineRtAmtRateDry40hc
	 */
	public String getFicGlineRtAmtRateDry40hc() {
		return this.ficGlineRtAmtRateDry40hc;
	}
	
	/**
	 * Column Info
	 * @return destRcvDeTermNm
	 */
	public String getDestRcvDeTermNm() {
		return this.destRcvDeTermNm;
	}
	

	/**
	 * Column Info
	 * @param ratePropDry45
	 */
	public void setRatePropDry45(String ratePropDry45) {
		this.ratePropDry45 = ratePropDry45;
	}
	
	/**
	 * Column Info
	 * @param pscDry45
	 */
	public void setPscDry45(String pscDry45) {
		this.pscDry45 = pscDry45;
	}
	
	/**
	 * Column Info
	 * @param ficGlineRtAmtRateRf40hc
	 */
	public void setFicGlineRtAmtRateRf40hc(String ficGlineRtAmtRateRf40hc) {
		this.ficGlineRtAmtRateRf40hc = ficGlineRtAmtRateRf40hc;
	}
	
	/**
	 * Column Info
	 * @param rateRd40hc
	 */
	public void setRateRd40hc(String rateRd40hc) {
		this.rateRd40hc = rateRd40hc;
	}
	
	/**
	 * Column Info
	 * @param bucDry20
	 */
	public void setBucDry20(String bucDry20) {
		this.bucDry20 = bucDry20;
	}
	
	/**
	 * Column Info
	 * @param ratePropDry40
	 */
	public void setRatePropDry40(String ratePropDry40) {
		this.ratePropDry40 = ratePropDry40;
	}
	
	/**
	 * Column Info
	 * @param bucDry40hc
	 */
	public void setBucDry40hc(String bucDry40hc) {
		this.bucDry40hc = bucDry40hc;
	}
	
	/**
	 * Column Info
	 * @param pscDry40
	 */
	public void setPscDry40(String pscDry40) {
		this.pscDry40 = pscDry40;
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
	 * @param rateDry45
	 */
	public void setRateDry45(String rateDry45) {
		this.rateDry45 = rateDry45;
	}
	
	/**
	 * Column Info
	 * @param rateBofDry20
	 */
	public void setRateBofDry20(String rateBofDry20) {
		this.rateBofDry20 = rateBofDry20;
	}
	
	/**
	 * Column Info
	 * @param ficGlineUpdDt
	 */
	public void setFicGlineUpdDt(String ficGlineUpdDt) {
		this.ficGlineUpdDt = ficGlineUpdDt;
	}
	
	/**
	 * Column Info
	 * @param ratePropRf40hc
	 */
	public void setRatePropRf40hc(String ratePropRf40hc) {
		this.ratePropRf40hc = ratePropRf40hc;
	}
	
	/**
	 * Column Info
	 * @param ratePropRd40hc
	 */
	public void setRatePropRd40hc(String ratePropRd40hc) {
		this.ratePropRd40hc = ratePropRd40hc;
	}
	
	/**
	 * Column Info
	 * @param rateBofRf40hc
	 */
	public void setRateBofRf40hc(String rateBofRf40hc) {
		this.rateBofRf40hc = rateBofRf40hc;
	}
	
	/**
	 * Column Info
	 * @param rateDry40
	 */
	public void setRateDry40(String rateDry40) {
		this.rateDry40 = rateDry40;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param rateBofDry40hc
	 */
	public void setRateBofDry40hc(String rateBofDry40hc) {
		this.rateBofDry40hc = rateBofDry40hc;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlgRateDry20
	 */
	public void setOptmTrspModFlgRateDry20(String optmTrspModFlgRateDry20) {
		this.optmTrspModFlgRateDry20 = optmTrspModFlgRateDry20;
	}
	
	/**
	 * Column Info
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param bucRf40hc
	 */
	public void setBucRf40hc(String bucRf40hc) {
		this.bucRf40hc = bucRf40hc;
	}
	
	/**
	 * Column Info
	 * @param ifcRd40hc
	 */
	public void setIfcRd40hc(String ifcRd40hc) {
		this.ifcRd40hc = ifcRd40hc;
	}
	
	/**
	 * Column Info
	 * @param rateBofDry45
	 */
	public void setRateBofDry45(String rateBofDry45) {
		this.rateBofDry45 = rateBofDry45;
	}
	
	/**
	 * Column Info
	 * @param basePortList
	 */
	public void setBasePortList(String basePortList) {
		this.basePortList = basePortList;
	}
	
	/**
	 * Column Info
	 * @param ficRoutCmbTpCd
	 */
	public void setFicRoutCmbTpCd(String ficRoutCmbTpCd) {
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @param pscRf40hc
	 */
	public void setPscRf40hc(String pscRf40hc) {
		this.pscRf40hc = pscRf40hc;
	}
	
	/**
	 * Column Info
	 * @param ficGlineRtAmtRateDry40
	 */
	public void setFicGlineRtAmtRateDry40(String ficGlineRtAmtRateDry40) {
		this.ficGlineRtAmtRateDry40 = ficGlineRtAmtRateDry40;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param rateDry40hc
	 */
	public void setRateDry40hc(String rateDry40hc) {
		this.rateDry40hc = rateDry40hc;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCdRateDry45
	 */
	public void setFicRtUseStsCdRateDry45(String ficRtUseStsCdRateDry45) {
		this.ficRtUseStsCdRateDry45 = ficRtUseStsCdRateDry45;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefNm
	 */
	public void setOrgRoutPntLocDefNm(String orgRoutPntLocDefNm) {
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param ratePropDry40hc
	 */
	public void setRatePropDry40hc(String ratePropDry40hc) {
		this.ratePropDry40hc = ratePropDry40hc;
	}
	
	/**
	 * Column Info
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCdRateDry40
	 */
	public void setFicRtUseStsCdRateDry40(String ficRtUseStsCdRateDry40) {
		this.ficRtUseStsCdRateDry40 = ficRtUseStsCdRateDry40;
	}
	
	/**
	 * Column Info
	 * @param pscDry40hc
	 */
	public void setPscDry40hc(String pscDry40hc) {
		this.pscDry40hc = pscDry40hc;
	}
	
	/**
	 * Column Info
	 * @param ifcDry20
	 */
	public void setIfcDry20(String ifcDry20) {
		this.ifcDry20 = ifcDry20;
	}
	
	/**
	 * Column Info
	 * @param destPrcTrspModNm
	 */
	public void setDestPrcTrspModNm(String destPrcTrspModNm) {
		this.destPrcTrspModNm = destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param rateBofDry40
	 */
	public void setRateBofDry40(String rateBofDry40) {
		this.rateBofDry40 = rateBofDry40;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCdRateDry40hc
	 */
	public void setFicRtUseStsCdRateDry40hc(String ficRtUseStsCdRateDry40hc) {
		this.ficRtUseStsCdRateDry40hc = ficRtUseStsCdRateDry40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRcvDeTermNm
	 */
	public void setOrgRcvDeTermNm(String orgRcvDeTermNm) {
		this.orgRcvDeTermNm = orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param ficGlineRtAmtRateRd40hc
	 */
	public void setFicGlineRtAmtRateRd40hc(String ficGlineRtAmtRateRd40hc) {
		this.ficGlineRtAmtRateRd40hc = ficGlineRtAmtRateRd40hc;
	}
	
	/**
	 * Column Info
	 * @param bucDry40
	 */
	public void setBucDry40(String bucDry40) {
		this.bucDry40 = bucDry40;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param ifcDry45
	 */
	public void setIfcDry45(String ifcDry45) {
		this.ifcDry45 = ifcDry45;
	}
	
	/**
	 * Column Info
	 * @param bucDry45
	 */
	public void setBucDry45(String bucDry45) {
		this.bucDry45 = bucDry45;
	}
	
	/**
	 * Column Info
	 * @param pscDry20
	 */
	public void setPscDry20(String pscDry20) {
		this.pscDry20 = pscDry20;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlgRateRd40hc
	 */
	public void setOptmTrspModFlgRateRd40hc(String optmTrspModFlgRateRd40hc) {
		this.optmTrspModFlgRateRd40hc = optmTrspModFlgRateRd40hc;
	}
	
	/**
	 * Column Info
	 * @param pscRd40hc
	 */
	public void setPscRd40hc(String pscRd40hc) {
		this.pscRd40hc = pscRd40hc;
	}
	
	/**
	 * Column Info
	 * @param ifcDry40
	 */
	public void setIfcDry40(String ifcDry40) {
		this.ifcDry40 = ifcDry40;
	}
	
	/**
	 * Column Info
	 * @param ratePropDry20
	 */
	public void setRatePropDry20(String ratePropDry20) {
		this.ratePropDry20 = ratePropDry20;
	}
	
	/**
	 * Column Info
	 * @param rateDry20
	 */
	public void setRateDry20(String rateDry20) {
		this.rateDry20 = rateDry20;
	}
	
	/**
	 * Column Info
	 * @param orgPrcTrspModNm
	 */
	public void setOrgPrcTrspModNm(String orgPrcTrspModNm) {
		this.orgPrcTrspModNm = orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param groupNo
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
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
	 * @param ifcDry40hc
	 */
	public void setIfcDry40hc(String ifcDry40hc) {
		this.ifcDry40hc = ifcDry40hc;
	}
	
	/**
	 * Column Info
	 * @param rateBofRd40hc
	 */
	public void setRateBofRd40hc(String rateBofRd40hc) {
		this.rateBofRd40hc = rateBofRd40hc;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlgRateDry45
	 */
	public void setOptmTrspModFlgRateDry45(String optmTrspModFlgRateDry45) {
		this.optmTrspModFlgRateDry45 = optmTrspModFlgRateDry45;
	}
	
	/**
	 * Column Info
	 * @param ifcRf40hc
	 */
	public void setIfcRf40hc(String ifcRf40hc) {
		this.ifcRf40hc = ifcRf40hc;
	}
	
	/**
	 * Column Info
	 * @param bucRd40hc
	 */
	public void setBucRd40hc(String bucRd40hc) {
		this.bucRd40hc = bucRd40hc;
	}
	
	/**
	 * Column Info
	 * @param ficGlineRtAmtRateDry45
	 */
	public void setFicGlineRtAmtRateDry45(String ficGlineRtAmtRateDry45) {
		this.ficGlineRtAmtRateDry45 = ficGlineRtAmtRateDry45;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCdRateRd40hc
	 */
	public void setFicRtUseStsCdRateRd40hc(String ficRtUseStsCdRateRd40hc) {
		this.ficRtUseStsCdRateRd40hc = ficRtUseStsCdRateRd40hc;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlgRateDry40
	 */
	public void setOptmTrspModFlgRateDry40(String optmTrspModFlgRateDry40) {
		this.optmTrspModFlgRateDry40 = optmTrspModFlgRateDry40;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCdRateRf40hc
	 */
	public void setFicRtUseStsCdRateRf40hc(String ficRtUseStsCdRateRf40hc) {
		this.ficRtUseStsCdRateRf40hc = ficRtUseStsCdRateRf40hc;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlg
	 */
	public void setOptmTrspModFlg(String optmTrspModFlg) {
		this.optmTrspModFlg = optmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlgRateRf40hc
	 */
	public void setOptmTrspModFlgRateRf40hc(String optmTrspModFlgRateRf40hc) {
		this.optmTrspModFlgRateRf40hc = optmTrspModFlgRateRf40hc;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCd
	 */
	public void setFicRtUseStsCd(String ficRtUseStsCd) {
		this.ficRtUseStsCd = ficRtUseStsCd;
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
	 * @param ficGlineRtAmtRateDry20
	 */
	public void setFicGlineRtAmtRateDry20(String ficGlineRtAmtRateDry20) {
		this.ficGlineRtAmtRateDry20 = ficGlineRtAmtRateDry20;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlgRateDry40hc
	 */
	public void setOptmTrspModFlgRateDry40hc(String optmTrspModFlgRateDry40hc) {
		this.optmTrspModFlgRateDry40hc = optmTrspModFlgRateDry40hc;
	}
	
	/**
	 * Column Info
	 * @param routDpSeq
	 */
	public void setRoutDpSeq(String routDpSeq) {
		this.routDpSeq = routDpSeq;
	}
	
	/**
	 * Column Info
	 * @param rateRf40hc
	 */
	public void setRateRf40hc(String rateRf40hc) {
		this.rateRf40hc = rateRf40hc;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefNm
	 */
	public void setDestRoutPntLocDefNm(String destRoutPntLocDefNm) {
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCdRateDry20
	 */
	public void setFicRtUseStsCdRateDry20(String ficRtUseStsCdRateDry20) {
		this.ficRtUseStsCdRateDry20 = ficRtUseStsCdRateDry20;
	}
	
	/**
	 * Column Info
	 * @param ficGlineRtAmtRateDry40hc
	 */
	public void setFicGlineRtAmtRateDry40hc(String ficGlineRtAmtRateDry40hc) {
		this.ficGlineRtAmtRateDry40hc = ficGlineRtAmtRateDry40hc;
	}
	
	/**
	 * Column Info
	 * @param destRcvDeTermNm
	 */
	public void setDestRcvDeTermNm(String destRcvDeTermNm) {
		this.destRcvDeTermNm = destRcvDeTermNm;
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
		setRatePropDry45(JSPUtil.getParameter(request, prefix + "rate_prop_dry45", ""));
		setPscDry45(JSPUtil.getParameter(request, prefix + "psc_dry45", ""));
		setFicGlineRtAmtRateRf40hc(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt_rate_rf40hc", ""));
		setRateRd40hc(JSPUtil.getParameter(request, prefix + "rate_rd40hc", ""));
		setBucDry20(JSPUtil.getParameter(request, prefix + "buc_dry20", ""));
		setRatePropDry40(JSPUtil.getParameter(request, prefix + "rate_prop_dry40", ""));
		setBucDry40hc(JSPUtil.getParameter(request, prefix + "buc_dry40hc", ""));
		setPscDry40(JSPUtil.getParameter(request, prefix + "psc_dry40", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRateDry45(JSPUtil.getParameter(request, prefix + "rate_dry45", ""));
		setRateBofDry20(JSPUtil.getParameter(request, prefix + "rate_bof_dry20", ""));
		setFicGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_gline_upd_dt", ""));
		setRatePropRf40hc(JSPUtil.getParameter(request, prefix + "rate_prop_rf40hc", ""));
		setRatePropRd40hc(JSPUtil.getParameter(request, prefix + "rate_prop_rd40hc", ""));
		setRateBofRf40hc(JSPUtil.getParameter(request, prefix + "rate_bof_rf40hc", ""));
		setRateDry40(JSPUtil.getParameter(request, prefix + "rate_dry40", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setRateBofDry40hc(JSPUtil.getParameter(request, prefix + "rate_bof_dry40hc", ""));
		setOptmTrspModFlgRateDry20(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg_rate_dry20", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setBucRf40hc(JSPUtil.getParameter(request, prefix + "buc_rf_40hc", ""));
		setIfcRd40hc(JSPUtil.getParameter(request, prefix + "ifc_rd40hc", ""));
		setRateBofDry45(JSPUtil.getParameter(request, prefix + "rate_bof_dry45", ""));
		setBasePortList(JSPUtil.getParameter(request, prefix + "base_port_list", ""));
		setFicRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_rout_cmb_tp_cd", ""));
		setPscRf40hc(JSPUtil.getParameter(request, prefix + "psc_rf_40hc", ""));
		setFicGlineRtAmtRateDry40(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt_rate_dry40", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setRateDry40hc(JSPUtil.getParameter(request, prefix + "rate_dry40hc", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setFicRtUseStsCdRateDry45(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd_rate_dry45", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_nm", ""));
		setRatePropDry40hc(JSPUtil.getParameter(request, prefix + "rate_prop_dry40hc", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, prefix + "cmdt_dp_seq", ""));
		setFicRtUseStsCdRateDry40(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd_rate_dry40", ""));
		setPscDry40hc(JSPUtil.getParameter(request, prefix + "psc_dry40hc", ""));
		setIfcDry20(JSPUtil.getParameter(request, prefix + "ifc_dry20", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request, prefix + "dest_prc_trsp_mod_nm", ""));
		setRateBofDry40(JSPUtil.getParameter(request, prefix + "rate_bof_dry40", ""));
		setFicRtUseStsCdRateDry40hc(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd_rate_dry40hc", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request, prefix + "org_rcv_de_term_nm", ""));
		setFicGlineRtAmtRateRd40hc(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt_rate_rd40hc", ""));
		setBucDry40(JSPUtil.getParameter(request, prefix + "buc_dry40", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setIfcDry45(JSPUtil.getParameter(request, prefix + "ifc_dry45", ""));
		setBucDry45(JSPUtil.getParameter(request, prefix + "buc_dry45", ""));
		setPscDry20(JSPUtil.getParameter(request, prefix + "psc_dry20", ""));
		setOptmTrspModFlgRateRd40hc(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg_rate_rd40hc", ""));
		setPscRd40hc(JSPUtil.getParameter(request, prefix + "psc_rd40hc", ""));
		setIfcDry40(JSPUtil.getParameter(request, prefix + "ifc_dry40", ""));
		setRatePropDry20(JSPUtil.getParameter(request, prefix + "rate_prop_dry20", ""));
		setRateDry20(JSPUtil.getParameter(request, prefix + "rate_dry20", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request, prefix + "org_prc_trsp_mod_nm", ""));
		setGroupNo(JSPUtil.getParameter(request, prefix + "group_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIfcDry40hc(JSPUtil.getParameter(request, prefix + "ifc_dry40hc", ""));
		setRateBofRd40hc(JSPUtil.getParameter(request, prefix + "rate_bof_rd40hc", ""));
		setOptmTrspModFlgRateDry45(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg_rate_dry45", ""));
		setIfcRf40hc(JSPUtil.getParameter(request, prefix + "ifc_rf_40hc", ""));
		setBucRd40hc(JSPUtil.getParameter(request, prefix + "buc_rd40hc", ""));
		setFicGlineRtAmtRateDry45(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt_rate_dry45", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setFicRtUseStsCdRateRd40hc(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd_rate_rd40hc", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setOptmTrspModFlgRateDry40(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg_rate_dry40", ""));
		setFicRtUseStsCdRateRf40hc(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd_rate_rf40hc", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setOptmTrspModFlgRateRf40hc(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg_rate_rf40hc", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFicGlineRtAmtRateDry20(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt_rate_dry20", ""));
		setOptmTrspModFlgRateDry40hc(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg_rate_dry40hc", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, prefix + "rout_dp_seq", ""));
		setRateRf40hc(JSPUtil.getParameter(request, prefix + "rate_rf40hc", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_nm", ""));
		setFicRtUseStsCdRateDry20(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd_rate_dry20", ""));
		setFicGlineRtAmtRateDry40hc(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt_rate_dry40hc", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request, prefix + "dest_rcv_de_term_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtListHorizontalLoadExcelForIHCVO[]
	 */
	public RsltRtListHorizontalLoadExcelForIHCVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtListHorizontalLoadExcelForIHCVO[]
	 */
	public RsltRtListHorizontalLoadExcelForIHCVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtListHorizontalLoadExcelForIHCVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ratePropDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_prop_dry45", length));
			String[] pscDry45 = (JSPUtil.getParameter(request, prefix	+ "psc_dry45", length));
			String[] ficGlineRtAmtRateRf40hc = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt_rate_rf40hc", length));
			String[] rateRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_rd40hc", length));
			String[] bucDry20 = (JSPUtil.getParameter(request, prefix	+ "buc_dry20", length));
			String[] ratePropDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_prop_dry40", length));
			String[] bucDry40hc = (JSPUtil.getParameter(request, prefix	+ "buc_dry40hc", length));
			String[] pscDry40 = (JSPUtil.getParameter(request, prefix	+ "psc_dry40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rateDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_dry45", length));
			String[] rateBofDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry20", length));
			String[] ficGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_upd_dt", length));
			String[] ratePropRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_prop_rf40hc", length));
			String[] ratePropRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_prop_rd40hc", length));
			String[] rateBofRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_rf40hc", length));
			String[] rateDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_dry40", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] rateBofDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry40hc", length));
			String[] optmTrspModFlgRateDry20 = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg_rate_dry20", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] bucRf40hc = (JSPUtil.getParameter(request, prefix	+ "buc_rf_40hc", length));
			String[] ifcRd40hc = (JSPUtil.getParameter(request, prefix	+ "ifc_rd40hc", length));
			String[] rateBofDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry45", length));
			String[] basePortList = (JSPUtil.getParameter(request, prefix	+ "base_port_list", length));
			String[] ficRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_rout_cmb_tp_cd", length));
			String[] pscRf40hc = (JSPUtil.getParameter(request, prefix	+ "psc_rf_40hc", length));
			String[] ficGlineRtAmtRateDry40 = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt_rate_dry40", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] rateDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_dry40hc", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] ficRtUseStsCdRateDry45 = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd_rate_dry45", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] ratePropDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_prop_dry40hc", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] ficRtUseStsCdRateDry40 = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd_rate_dry40", length));
			String[] pscDry40hc = (JSPUtil.getParameter(request, prefix	+ "psc_dry40hc", length));
			String[] ifcDry20 = (JSPUtil.getParameter(request, prefix	+ "ifc_dry20", length));
			String[] destPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "dest_prc_trsp_mod_nm", length));
			String[] rateBofDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry40", length));
			String[] ficRtUseStsCdRateDry40hc = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd_rate_dry40hc", length));
			String[] orgRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "org_rcv_de_term_nm", length));
			String[] ficGlineRtAmtRateRd40hc = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt_rate_rd40hc", length));
			String[] bucDry40 = (JSPUtil.getParameter(request, prefix	+ "buc_dry40", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] ifcDry45 = (JSPUtil.getParameter(request, prefix	+ "ifc_dry45", length));
			String[] bucDry45 = (JSPUtil.getParameter(request, prefix	+ "buc_dry45", length));
			String[] pscDry20 = (JSPUtil.getParameter(request, prefix	+ "psc_dry20", length));
			String[] optmTrspModFlgRateRd40hc = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg_rate_rd40hc", length));
			String[] pscRd40hc = (JSPUtil.getParameter(request, prefix	+ "psc_rd40hc", length));
			String[] ifcDry40 = (JSPUtil.getParameter(request, prefix	+ "ifc_dry40", length));
			String[] ratePropDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_prop_dry20", length));
			String[] rateDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_dry20", length));
			String[] orgPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "org_prc_trsp_mod_nm", length));
			String[] groupNo = (JSPUtil.getParameter(request, prefix	+ "group_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ifcDry40hc = (JSPUtil.getParameter(request, prefix	+ "ifc_dry40hc", length));
			String[] rateBofRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_rd40hc", length));
			String[] optmTrspModFlgRateDry45 = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg_rate_dry45", length));
			String[] ifcRf40hc = (JSPUtil.getParameter(request, prefix	+ "ifc_rf_40hc", length));
			String[] bucRd40hc = (JSPUtil.getParameter(request, prefix	+ "buc_rd40hc", length));
			String[] ficGlineRtAmtRateDry45 = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt_rate_dry45", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] ficRtUseStsCdRateRd40hc = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd_rate_rd40hc", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] optmTrspModFlgRateDry40 = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg_rate_dry40", length));
			String[] ficRtUseStsCdRateRf40hc = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd_rate_rf40hc", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] optmTrspModFlgRateRf40hc = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg_rate_rf40hc", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ficGlineRtAmtRateDry20 = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt_rate_dry20", length));
			String[] optmTrspModFlgRateDry40hc = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg_rate_dry40hc", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] rateRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_rf40hc", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] ficRtUseStsCdRateDry20 = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd_rate_dry20", length));
			String[] ficGlineRtAmtRateDry40hc = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt_rate_dry40hc", length));
			String[] destRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dest_rcv_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtListHorizontalLoadExcelForIHCVO();
				if (ratePropDry45[i] != null)
					model.setRatePropDry45(ratePropDry45[i]);
				if (pscDry45[i] != null)
					model.setPscDry45(pscDry45[i]);
				if (ficGlineRtAmtRateRf40hc[i] != null)
					model.setFicGlineRtAmtRateRf40hc(ficGlineRtAmtRateRf40hc[i]);
				if (rateRd40hc[i] != null)
					model.setRateRd40hc(rateRd40hc[i]);
				if (bucDry20[i] != null)
					model.setBucDry20(bucDry20[i]);
				if (ratePropDry40[i] != null)
					model.setRatePropDry40(ratePropDry40[i]);
				if (bucDry40hc[i] != null)
					model.setBucDry40hc(bucDry40hc[i]);
				if (pscDry40[i] != null)
					model.setPscDry40(pscDry40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rateDry45[i] != null)
					model.setRateDry45(rateDry45[i]);
				if (rateBofDry20[i] != null)
					model.setRateBofDry20(rateBofDry20[i]);
				if (ficGlineUpdDt[i] != null)
					model.setFicGlineUpdDt(ficGlineUpdDt[i]);
				if (ratePropRf40hc[i] != null)
					model.setRatePropRf40hc(ratePropRf40hc[i]);
				if (ratePropRd40hc[i] != null)
					model.setRatePropRd40hc(ratePropRd40hc[i]);
				if (rateBofRf40hc[i] != null)
					model.setRateBofRf40hc(rateBofRf40hc[i]);
				if (rateDry40[i] != null)
					model.setRateDry40(rateDry40[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (rateBofDry40hc[i] != null)
					model.setRateBofDry40hc(rateBofDry40hc[i]);
				if (optmTrspModFlgRateDry20[i] != null)
					model.setOptmTrspModFlgRateDry20(optmTrspModFlgRateDry20[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (bucRf40hc[i] != null)
					model.setBucRf40hc(bucRf40hc[i]);
				if (ifcRd40hc[i] != null)
					model.setIfcRd40hc(ifcRd40hc[i]);
				if (rateBofDry45[i] != null)
					model.setRateBofDry45(rateBofDry45[i]);
				if (basePortList[i] != null)
					model.setBasePortList(basePortList[i]);
				if (ficRoutCmbTpCd[i] != null)
					model.setFicRoutCmbTpCd(ficRoutCmbTpCd[i]);
				if (pscRf40hc[i] != null)
					model.setPscRf40hc(pscRf40hc[i]);
				if (ficGlineRtAmtRateDry40[i] != null)
					model.setFicGlineRtAmtRateDry40(ficGlineRtAmtRateDry40[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (rateDry40hc[i] != null)
					model.setRateDry40hc(rateDry40hc[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (ficRtUseStsCdRateDry45[i] != null)
					model.setFicRtUseStsCdRateDry45(ficRtUseStsCdRateDry45[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (ratePropDry40hc[i] != null)
					model.setRatePropDry40hc(ratePropDry40hc[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (ficRtUseStsCdRateDry40[i] != null)
					model.setFicRtUseStsCdRateDry40(ficRtUseStsCdRateDry40[i]);
				if (pscDry40hc[i] != null)
					model.setPscDry40hc(pscDry40hc[i]);
				if (ifcDry20[i] != null)
					model.setIfcDry20(ifcDry20[i]);
				if (destPrcTrspModNm[i] != null)
					model.setDestPrcTrspModNm(destPrcTrspModNm[i]);
				if (rateBofDry40[i] != null)
					model.setRateBofDry40(rateBofDry40[i]);
				if (ficRtUseStsCdRateDry40hc[i] != null)
					model.setFicRtUseStsCdRateDry40hc(ficRtUseStsCdRateDry40hc[i]);
				if (orgRcvDeTermNm[i] != null)
					model.setOrgRcvDeTermNm(orgRcvDeTermNm[i]);
				if (ficGlineRtAmtRateRd40hc[i] != null)
					model.setFicGlineRtAmtRateRd40hc(ficGlineRtAmtRateRd40hc[i]);
				if (bucDry40[i] != null)
					model.setBucDry40(bucDry40[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (ifcDry45[i] != null)
					model.setIfcDry45(ifcDry45[i]);
				if (bucDry45[i] != null)
					model.setBucDry45(bucDry45[i]);
				if (pscDry20[i] != null)
					model.setPscDry20(pscDry20[i]);
				if (optmTrspModFlgRateRd40hc[i] != null)
					model.setOptmTrspModFlgRateRd40hc(optmTrspModFlgRateRd40hc[i]);
				if (pscRd40hc[i] != null)
					model.setPscRd40hc(pscRd40hc[i]);
				if (ifcDry40[i] != null)
					model.setIfcDry40(ifcDry40[i]);
				if (ratePropDry20[i] != null)
					model.setRatePropDry20(ratePropDry20[i]);
				if (rateDry20[i] != null)
					model.setRateDry20(rateDry20[i]);
				if (orgPrcTrspModNm[i] != null)
					model.setOrgPrcTrspModNm(orgPrcTrspModNm[i]);
				if (groupNo[i] != null)
					model.setGroupNo(groupNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ifcDry40hc[i] != null)
					model.setIfcDry40hc(ifcDry40hc[i]);
				if (rateBofRd40hc[i] != null)
					model.setRateBofRd40hc(rateBofRd40hc[i]);
				if (optmTrspModFlgRateDry45[i] != null)
					model.setOptmTrspModFlgRateDry45(optmTrspModFlgRateDry45[i]);
				if (ifcRf40hc[i] != null)
					model.setIfcRf40hc(ifcRf40hc[i]);
				if (bucRd40hc[i] != null)
					model.setBucRd40hc(bucRd40hc[i]);
				if (ficGlineRtAmtRateDry45[i] != null)
					model.setFicGlineRtAmtRateDry45(ficGlineRtAmtRateDry45[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (ficRtUseStsCdRateRd40hc[i] != null)
					model.setFicRtUseStsCdRateRd40hc(ficRtUseStsCdRateRd40hc[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (optmTrspModFlgRateDry40[i] != null)
					model.setOptmTrspModFlgRateDry40(optmTrspModFlgRateDry40[i]);
				if (ficRtUseStsCdRateRf40hc[i] != null)
					model.setFicRtUseStsCdRateRf40hc(ficRtUseStsCdRateRf40hc[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (optmTrspModFlgRateRf40hc[i] != null)
					model.setOptmTrspModFlgRateRf40hc(optmTrspModFlgRateRf40hc[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ficGlineRtAmtRateDry20[i] != null)
					model.setFicGlineRtAmtRateDry20(ficGlineRtAmtRateDry20[i]);
				if (optmTrspModFlgRateDry40hc[i] != null)
					model.setOptmTrspModFlgRateDry40hc(optmTrspModFlgRateDry40hc[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (rateRf40hc[i] != null)
					model.setRateRf40hc(rateRf40hc[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (ficRtUseStsCdRateDry20[i] != null)
					model.setFicRtUseStsCdRateDry20(ficRtUseStsCdRateDry20[i]);
				if (ficGlineRtAmtRateDry40hc[i] != null)
					model.setFicGlineRtAmtRateDry40hc(ficGlineRtAmtRateDry40hc[i]);
				if (destRcvDeTermNm[i] != null)
					model.setDestRcvDeTermNm(destRcvDeTermNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtListHorizontalLoadExcelForIHCVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtListHorizontalLoadExcelForIHCVO[]
	 */
	public RsltRtListHorizontalLoadExcelForIHCVO[] getRsltRtListHorizontalLoadExcelForIHCVOs(){
		RsltRtListHorizontalLoadExcelForIHCVO[] vos = (RsltRtListHorizontalLoadExcelForIHCVO[])models.toArray(new RsltRtListHorizontalLoadExcelForIHCVO[models.size()]);
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
		this.ratePropDry45 = this.ratePropDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscDry45 = this.pscDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmtRateRf40hc = this.ficGlineRtAmtRateRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRd40hc = this.rateRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucDry20 = this.bucDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratePropDry40 = this.ratePropDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucDry40hc = this.bucDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscDry40 = this.pscDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry45 = this.rateDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry20 = this.rateBofDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineUpdDt = this.ficGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratePropRf40hc = this.ratePropRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratePropRd40hc = this.ratePropRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofRf40hc = this.rateBofRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry40 = this.rateDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry40hc = this.rateBofDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlgRateDry20 = this.optmTrspModFlgRateDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucRf40hc = this.bucRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcRd40hc = this.ifcRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry45 = this.rateBofDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basePortList = this.basePortList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRoutCmbTpCd = this.ficRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscRf40hc = this.pscRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmtRateDry40 = this.ficGlineRtAmtRateDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry40hc = this.rateDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCdRateDry45 = this.ficRtUseStsCdRateDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratePropDry40hc = this.ratePropDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCdRateDry40 = this.ficRtUseStsCdRateDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscDry40hc = this.pscDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcDry20 = this.ifcDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm = this.destPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry40 = this.rateBofDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCdRateDry40hc = this.ficRtUseStsCdRateDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm = this.orgRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmtRateRd40hc = this.ficGlineRtAmtRateRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucDry40 = this.bucDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcDry45 = this.ifcDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucDry45 = this.bucDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscDry20 = this.pscDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlgRateRd40hc = this.optmTrspModFlgRateRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscRd40hc = this.pscRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcDry40 = this.ifcDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratePropDry20 = this.ratePropDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry20 = this.rateDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm = this.orgPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupNo = this.groupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcDry40hc = this.ifcDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofRd40hc = this.rateBofRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlgRateDry45 = this.optmTrspModFlgRateDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcRf40hc = this.ifcRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucRd40hc = this.bucRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmtRateDry45 = this.ficGlineRtAmtRateDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCdRateRd40hc = this.ficRtUseStsCdRateRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlgRateDry40 = this.optmTrspModFlgRateDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCdRateRf40hc = this.ficRtUseStsCdRateRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlgRateRf40hc = this.optmTrspModFlgRateRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmtRateDry20 = this.ficGlineRtAmtRateDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlgRateDry40hc = this.optmTrspModFlgRateDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRf40hc = this.rateRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCdRateDry20 = this.ficRtUseStsCdRateDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmtRateDry40hc = this.ficGlineRtAmtRateDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm = this.destRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
