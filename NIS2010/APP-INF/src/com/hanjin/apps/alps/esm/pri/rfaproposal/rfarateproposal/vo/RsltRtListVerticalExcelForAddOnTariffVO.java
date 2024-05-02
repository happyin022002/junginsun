/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltRtListVerticalExcelForAddOnTariffVO.java
*@FileTitle : RsltRtListVerticalExcelForAddOnTariffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.18
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.18 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtListVerticalExcelForAddOnTariffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtListVerticalExcelForAddOnTariffVO> models = new ArrayList<RsltRtListVerticalExcelForAddOnTariffVO>();
	
	/* Column Info */
	private String ficDestGlineRtAmt = null;
	/* Column Info */
	private String ficDestRoutCmbTpCd = null;
	/* Column Info */
	private String ficOrgRoutCmbTpCd = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String destCyDorRtTpCd = null;
	/* Column Info */
	private String ficDestRtUseStsCd = null;
	/* Column Info */
	private String orgCyDorRtTpCd = null;
	/* Column Info */
	private String destOptmTrspModFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgPrcTrspModNm = null;
	/* Column Info */
	private String propBofAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bucUsdAmt = null;
	/* Column Info */
	private String ifcUsdAmt = null;
	/* Column Info */
	private String ficDestGlineUpdDt = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String ficOrgGlineRtAmt = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String orgOptmTrspModFlg = null;
	/* Column Info */
	private String ficOrgPropRtAmt = null;
	/* Column Info */
	private String destBsePortLocCd = null;
	/* Column Info */
	private String ficOrgRtUseStsCd = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String ficDestPropRtAmt = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String pscUsdAmt = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String destPrcTrspModNm = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String orgBsePortLocCd = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String orgRcvDeTermNm = null;
	/* Column Info */
	private String ficOrgGlineUpdDt = null;
	/* Column Info */
	private String destRcvDeTermNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtListVerticalExcelForAddOnTariffVO() {}

	public RsltRtListVerticalExcelForAddOnTariffVO(String ibflag, String pagerows, String cmdtDpSeq, String prcCmdtDefCd, String prcCmdtDefNm, String custSeq, String custLglEngNm, String routDpSeq, String orgRoutPntLocDefCd, String orgRoutPntLocDefNm, String orgRcvDeTermNm, String orgPrcTrspModNm, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String destRoutPntLocDefNm, String destRcvDeTermNm, String destPrcTrspModNm, String ratUtCd, String prcCgoTpCd, String currCd, String propFrtRtAmt, String propBofAmt, String ficOrgPropRtAmt, String ficOrgGlineRtAmt, String ficOrgGlineUpdDt, String orgOptmTrspModFlg, String ficOrgRtUseStsCd, String ficDestPropRtAmt, String ficDestGlineRtAmt, String ficDestGlineUpdDt, String destOptmTrspModFlg, String ficDestRtUseStsCd, String bucUsdAmt, String ifcUsdAmt, String pscUsdAmt, String orgBsePortLocCd, String destBsePortLocCd, String ficOrgRoutCmbTpCd, String ficDestRoutCmbTpCd, String orgCyDorRtTpCd, String destCyDorRtTpCd) {
		this.ficDestGlineRtAmt = ficDestGlineRtAmt;
		this.ficDestRoutCmbTpCd = ficDestRoutCmbTpCd;
		this.ficOrgRoutCmbTpCd = ficOrgRoutCmbTpCd;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.destCyDorRtTpCd = destCyDorRtTpCd;
		this.ficDestRtUseStsCd = ficDestRtUseStsCd;
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
		this.destOptmTrspModFlg = destOptmTrspModFlg;
		this.pagerows = pagerows;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.propBofAmt = propBofAmt;
		this.ibflag = ibflag;
		this.bucUsdAmt = bucUsdAmt;
		this.ifcUsdAmt = ifcUsdAmt;
		this.ficDestGlineUpdDt = ficDestGlineUpdDt;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.ficOrgGlineRtAmt = ficOrgGlineRtAmt;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.orgOptmTrspModFlg = orgOptmTrspModFlg;
		this.ficOrgPropRtAmt = ficOrgPropRtAmt;
		this.destBsePortLocCd = destBsePortLocCd;
		this.ficOrgRtUseStsCd = ficOrgRtUseStsCd;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.ratUtCd = ratUtCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.custSeq = custSeq;
		this.custLglEngNm = custLglEngNm;
		this.ficDestPropRtAmt = ficDestPropRtAmt;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.pscUsdAmt = pscUsdAmt;
		this.routDpSeq = routDpSeq;
		this.cmdtDpSeq = cmdtDpSeq;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.orgBsePortLocCd = orgBsePortLocCd;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.ficOrgGlineUpdDt = ficOrgGlineUpdDt;
		this.destRcvDeTermNm = destRcvDeTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fic_dest_gline_rt_amt", getFicDestGlineRtAmt());
		this.hashColumns.put("fic_dest_rout_cmb_tp_cd", getFicDestRoutCmbTpCd());
		this.hashColumns.put("fic_org_rout_cmb_tp_cd", getFicOrgRoutCmbTpCd());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("dest_cy_dor_rt_tp_cd", getDestCyDorRtTpCd());
		this.hashColumns.put("fic_dest_rt_use_sts_cd", getFicDestRtUseStsCd());
		this.hashColumns.put("org_cy_dor_rt_tp_cd", getOrgCyDorRtTpCd());
		this.hashColumns.put("dest_optm_trsp_mod_flg", getDestOptmTrspModFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("prop_bof_amt", getPropBofAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("buc_usd_amt", getBucUsdAmt());
		this.hashColumns.put("ifc_usd_amt", getIfcUsdAmt());
		this.hashColumns.put("fic_dest_gline_upd_dt", getFicDestGlineUpdDt());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("fic_org_gline_rt_amt", getFicOrgGlineRtAmt());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("org_optm_trsp_mod_flg", getOrgOptmTrspModFlg());
		this.hashColumns.put("fic_org_prop_rt_amt", getFicOrgPropRtAmt());
		this.hashColumns.put("dest_bse_port_loc_cd", getDestBsePortLocCd());
		this.hashColumns.put("fic_org_rt_use_sts_cd", getFicOrgRtUseStsCd());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("fic_dest_prop_rt_amt", getFicDestPropRtAmt());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("psc_usd_amt", getPscUsdAmt());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("org_bse_port_loc_cd", getOrgBsePortLocCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("fic_org_gline_upd_dt", getFicOrgGlineUpdDt());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fic_dest_gline_rt_amt", "ficDestGlineRtAmt");
		this.hashFields.put("fic_dest_rout_cmb_tp_cd", "ficDestRoutCmbTpCd");
		this.hashFields.put("fic_org_rout_cmb_tp_cd", "ficOrgRoutCmbTpCd");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("dest_cy_dor_rt_tp_cd", "destCyDorRtTpCd");
		this.hashFields.put("fic_dest_rt_use_sts_cd", "ficDestRtUseStsCd");
		this.hashFields.put("org_cy_dor_rt_tp_cd", "orgCyDorRtTpCd");
		this.hashFields.put("dest_optm_trsp_mod_flg", "destOptmTrspModFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("prop_bof_amt", "propBofAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("buc_usd_amt", "bucUsdAmt");
		this.hashFields.put("ifc_usd_amt", "ifcUsdAmt");
		this.hashFields.put("fic_dest_gline_upd_dt", "ficDestGlineUpdDt");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("fic_org_gline_rt_amt", "ficOrgGlineRtAmt");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("org_optm_trsp_mod_flg", "orgOptmTrspModFlg");
		this.hashFields.put("fic_org_prop_rt_amt", "ficOrgPropRtAmt");
		this.hashFields.put("dest_bse_port_loc_cd", "destBsePortLocCd");
		this.hashFields.put("fic_org_rt_use_sts_cd", "ficOrgRtUseStsCd");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("fic_dest_prop_rt_amt", "ficDestPropRtAmt");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("psc_usd_amt", "pscUsdAmt");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("org_bse_port_loc_cd", "orgBsePortLocCd");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("fic_org_gline_upd_dt", "ficOrgGlineUpdDt");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ficDestGlineRtAmt
	 */
	public String getFicDestGlineRtAmt() {
		return this.ficDestGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ficDestRoutCmbTpCd
	 */
	public String getFicDestRoutCmbTpCd() {
		return this.ficDestRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @return ficOrgRoutCmbTpCd
	 */
	public String getFicOrgRoutCmbTpCd() {
		return this.ficOrgRoutCmbTpCd;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return destCyDorRtTpCd
	 */
	public String getDestCyDorRtTpCd() {
		return this.destCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return ficDestRtUseStsCd
	 */
	public String getFicDestRtUseStsCd() {
		return this.ficDestRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @return orgCyDorRtTpCd
	 */
	public String getOrgCyDorRtTpCd() {
		return this.orgCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return destOptmTrspModFlg
	 */
	public String getDestOptmTrspModFlg() {
		return this.destOptmTrspModFlg;
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
	 * @return orgPrcTrspModNm
	 */
	public String getOrgPrcTrspModNm() {
		return this.orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return propBofAmt
	 */
	public String getPropBofAmt() {
		return this.propBofAmt;
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
	 * @return bucUsdAmt
	 */
	public String getBucUsdAmt() {
		return this.bucUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ifcUsdAmt
	 */
	public String getIfcUsdAmt() {
		return this.ifcUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ficDestGlineUpdDt
	 */
	public String getFicDestGlineUpdDt() {
		return this.ficDestGlineUpdDt;
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
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @return ficOrgGlineRtAmt
	 */
	public String getFicOrgGlineRtAmt() {
		return this.ficOrgGlineRtAmt;
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
	 * @return orgOptmTrspModFlg
	 */
	public String getOrgOptmTrspModFlg() {
		return this.orgOptmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @return ficOrgPropRtAmt
	 */
	public String getFicOrgPropRtAmt() {
		return this.ficOrgPropRtAmt;
	}
	
	/**
	 * Column Info
	 * @return destBsePortLocCd
	 */
	public String getDestBsePortLocCd() {
		return this.destBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return ficOrgRtUseStsCd
	 */
	public String getFicOrgRtUseStsCd() {
		return this.ficOrgRtUseStsCd;
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
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return ficDestPropRtAmt
	 */
	public String getFicDestPropRtAmt() {
		return this.ficDestPropRtAmt;
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
	 * @return pscUsdAmt
	 */
	public String getPscUsdAmt() {
		return this.pscUsdAmt;
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
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
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
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return orgBsePortLocCd
	 */
	public String getOrgBsePortLocCd() {
		return this.orgBsePortLocCd;
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
	 * @return orgRcvDeTermNm
	 */
	public String getOrgRcvDeTermNm() {
		return this.orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return ficOrgGlineUpdDt
	 */
	public String getFicOrgGlineUpdDt() {
		return this.ficOrgGlineUpdDt;
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
	 * @param ficDestGlineRtAmt
	 */
	public void setFicDestGlineRtAmt(String ficDestGlineRtAmt) {
		this.ficDestGlineRtAmt = ficDestGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ficDestRoutCmbTpCd
	 */
	public void setFicDestRoutCmbTpCd(String ficDestRoutCmbTpCd) {
		this.ficDestRoutCmbTpCd = ficDestRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @param ficOrgRoutCmbTpCd
	 */
	public void setFicOrgRoutCmbTpCd(String ficOrgRoutCmbTpCd) {
		this.ficOrgRoutCmbTpCd = ficOrgRoutCmbTpCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param destCyDorRtTpCd
	 */
	public void setDestCyDorRtTpCd(String destCyDorRtTpCd) {
		this.destCyDorRtTpCd = destCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param ficDestRtUseStsCd
	 */
	public void setFicDestRtUseStsCd(String ficDestRtUseStsCd) {
		this.ficDestRtUseStsCd = ficDestRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @param orgCyDorRtTpCd
	 */
	public void setOrgCyDorRtTpCd(String orgCyDorRtTpCd) {
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param destOptmTrspModFlg
	 */
	public void setDestOptmTrspModFlg(String destOptmTrspModFlg) {
		this.destOptmTrspModFlg = destOptmTrspModFlg;
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
	 * @param orgPrcTrspModNm
	 */
	public void setOrgPrcTrspModNm(String orgPrcTrspModNm) {
		this.orgPrcTrspModNm = orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param propBofAmt
	 */
	public void setPropBofAmt(String propBofAmt) {
		this.propBofAmt = propBofAmt;
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
	 * @param bucUsdAmt
	 */
	public void setBucUsdAmt(String bucUsdAmt) {
		this.bucUsdAmt = bucUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ifcUsdAmt
	 */
	public void setIfcUsdAmt(String ifcUsdAmt) {
		this.ifcUsdAmt = ifcUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ficDestGlineUpdDt
	 */
	public void setFicDestGlineUpdDt(String ficDestGlineUpdDt) {
		this.ficDestGlineUpdDt = ficDestGlineUpdDt;
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
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @param ficOrgGlineRtAmt
	 */
	public void setFicOrgGlineRtAmt(String ficOrgGlineRtAmt) {
		this.ficOrgGlineRtAmt = ficOrgGlineRtAmt;
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
	 * @param orgOptmTrspModFlg
	 */
	public void setOrgOptmTrspModFlg(String orgOptmTrspModFlg) {
		this.orgOptmTrspModFlg = orgOptmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @param ficOrgPropRtAmt
	 */
	public void setFicOrgPropRtAmt(String ficOrgPropRtAmt) {
		this.ficOrgPropRtAmt = ficOrgPropRtAmt;
	}
	
	/**
	 * Column Info
	 * @param destBsePortLocCd
	 */
	public void setDestBsePortLocCd(String destBsePortLocCd) {
		this.destBsePortLocCd = destBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param ficOrgRtUseStsCd
	 */
	public void setFicOrgRtUseStsCd(String ficOrgRtUseStsCd) {
		this.ficOrgRtUseStsCd = ficOrgRtUseStsCd;
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
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param ficDestPropRtAmt
	 */
	public void setFicDestPropRtAmt(String ficDestPropRtAmt) {
		this.ficDestPropRtAmt = ficDestPropRtAmt;
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
	 * @param pscUsdAmt
	 */
	public void setPscUsdAmt(String pscUsdAmt) {
		this.pscUsdAmt = pscUsdAmt;
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
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
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
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param orgBsePortLocCd
	 */
	public void setOrgBsePortLocCd(String orgBsePortLocCd) {
		this.orgBsePortLocCd = orgBsePortLocCd;
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
	 * @param orgRcvDeTermNm
	 */
	public void setOrgRcvDeTermNm(String orgRcvDeTermNm) {
		this.orgRcvDeTermNm = orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param ficOrgGlineUpdDt
	 */
	public void setFicOrgGlineUpdDt(String ficOrgGlineUpdDt) {
		this.ficOrgGlineUpdDt = ficOrgGlineUpdDt;
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
		setFicDestGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_dest_gline_rt_amt", ""));
		setFicDestRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_dest_rout_cmb_tp_cd", ""));
		setFicOrgRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_org_rout_cmb_tp_cd", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setDestCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "dest_cy_dor_rt_tp_cd", ""));
		setFicDestRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd", ""));
		setOrgCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "org_cy_dor_rt_tp_cd", ""));
		setDestOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request, prefix + "org_prc_trsp_mod_nm", ""));
		setPropBofAmt(JSPUtil.getParameter(request, prefix + "prop_bof_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBucUsdAmt(JSPUtil.getParameter(request, prefix + "buc_usd_amt", ""));
		setIfcUsdAmt(JSPUtil.getParameter(request, prefix + "ifc_usd_amt", ""));
		setFicDestGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_dest_gline_upd_dt", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setFicOrgGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setOrgOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg", ""));
		setFicOrgPropRtAmt(JSPUtil.getParameter(request, prefix + "fic_org_prop_rt_amt", ""));
		setDestBsePortLocCd(JSPUtil.getParameter(request, prefix + "dest_bse_port_loc_cd", ""));
		setFicOrgRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setFicDestPropRtAmt(JSPUtil.getParameter(request, prefix + "fic_dest_prop_rt_amt", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_nm", ""));
		setPscUsdAmt(JSPUtil.getParameter(request, prefix + "psc_usd_amt", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, prefix + "rout_dp_seq", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, prefix + "cmdt_dp_seq", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request, prefix + "dest_prc_trsp_mod_nm", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setOrgBsePortLocCd(JSPUtil.getParameter(request, prefix + "org_bse_port_loc_cd", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_nm", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request, prefix + "org_rcv_de_term_nm", ""));
		setFicOrgGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_org_gline_upd_dt", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request, prefix + "dest_rcv_de_term_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtListVerticalExcelForAddOnTariffVO[]
	 */
	public RsltRtListVerticalExcelForAddOnTariffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtListVerticalExcelForAddOnTariffVO[]
	 */
	public RsltRtListVerticalExcelForAddOnTariffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtListVerticalExcelForAddOnTariffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ficDestGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt", length));
			String[] ficDestRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rout_cmb_tp_cd", length));
			String[] ficOrgRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_org_rout_cmb_tp_cd", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] destCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "dest_cy_dor_rt_tp_cd", length));
			String[] ficDestRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd", length));
			String[] orgCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "org_cy_dor_rt_tp_cd", length));
			String[] destOptmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "org_prc_trsp_mod_nm", length));
			String[] propBofAmt = (JSPUtil.getParameter(request, prefix	+ "prop_bof_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bucUsdAmt = (JSPUtil.getParameter(request, prefix	+ "buc_usd_amt", length));
			String[] ifcUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ifc_usd_amt", length));
			String[] ficDestGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_upd_dt", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] ficOrgGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] orgOptmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg", length));
			String[] ficOrgPropRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_org_prop_rt_amt", length));
			String[] destBsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_bse_port_loc_cd", length));
			String[] ficOrgRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] ficDestPropRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_prop_rt_amt", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] pscUsdAmt = (JSPUtil.getParameter(request, prefix	+ "psc_usd_amt", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] destPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "dest_prc_trsp_mod_nm", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] orgBsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "org_bse_port_loc_cd", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] orgRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "org_rcv_de_term_nm", length));
			String[] ficOrgGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_upd_dt", length));
			String[] destRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dest_rcv_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtListVerticalExcelForAddOnTariffVO();
				if (ficDestGlineRtAmt[i] != null)
					model.setFicDestGlineRtAmt(ficDestGlineRtAmt[i]);
				if (ficDestRoutCmbTpCd[i] != null)
					model.setFicDestRoutCmbTpCd(ficDestRoutCmbTpCd[i]);
				if (ficOrgRoutCmbTpCd[i] != null)
					model.setFicOrgRoutCmbTpCd(ficOrgRoutCmbTpCd[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (destCyDorRtTpCd[i] != null)
					model.setDestCyDorRtTpCd(destCyDorRtTpCd[i]);
				if (ficDestRtUseStsCd[i] != null)
					model.setFicDestRtUseStsCd(ficDestRtUseStsCd[i]);
				if (orgCyDorRtTpCd[i] != null)
					model.setOrgCyDorRtTpCd(orgCyDorRtTpCd[i]);
				if (destOptmTrspModFlg[i] != null)
					model.setDestOptmTrspModFlg(destOptmTrspModFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgPrcTrspModNm[i] != null)
					model.setOrgPrcTrspModNm(orgPrcTrspModNm[i]);
				if (propBofAmt[i] != null)
					model.setPropBofAmt(propBofAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bucUsdAmt[i] != null)
					model.setBucUsdAmt(bucUsdAmt[i]);
				if (ifcUsdAmt[i] != null)
					model.setIfcUsdAmt(ifcUsdAmt[i]);
				if (ficDestGlineUpdDt[i] != null)
					model.setFicDestGlineUpdDt(ficDestGlineUpdDt[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (ficOrgGlineRtAmt[i] != null)
					model.setFicOrgGlineRtAmt(ficOrgGlineRtAmt[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (orgOptmTrspModFlg[i] != null)
					model.setOrgOptmTrspModFlg(orgOptmTrspModFlg[i]);
				if (ficOrgPropRtAmt[i] != null)
					model.setFicOrgPropRtAmt(ficOrgPropRtAmt[i]);
				if (destBsePortLocCd[i] != null)
					model.setDestBsePortLocCd(destBsePortLocCd[i]);
				if (ficOrgRtUseStsCd[i] != null)
					model.setFicOrgRtUseStsCd(ficOrgRtUseStsCd[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (ficDestPropRtAmt[i] != null)
					model.setFicDestPropRtAmt(ficDestPropRtAmt[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (pscUsdAmt[i] != null)
					model.setPscUsdAmt(pscUsdAmt[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (destPrcTrspModNm[i] != null)
					model.setDestPrcTrspModNm(destPrcTrspModNm[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (orgBsePortLocCd[i] != null)
					model.setOrgBsePortLocCd(orgBsePortLocCd[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (orgRcvDeTermNm[i] != null)
					model.setOrgRcvDeTermNm(orgRcvDeTermNm[i]);
				if (ficOrgGlineUpdDt[i] != null)
					model.setFicOrgGlineUpdDt(ficOrgGlineUpdDt[i]);
				if (destRcvDeTermNm[i] != null)
					model.setDestRcvDeTermNm(destRcvDeTermNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtListVerticalExcelForAddOnTariffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtListVerticalExcelForAddOnTariffVO[]
	 */
	public RsltRtListVerticalExcelForAddOnTariffVO[] getRsltRtListVerticalExcelForAddOnTariffVOs(){
		RsltRtListVerticalExcelForAddOnTariffVO[] vos = (RsltRtListVerticalExcelForAddOnTariffVO[])models.toArray(new RsltRtListVerticalExcelForAddOnTariffVO[models.size()]);
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
		this.ficDestGlineRtAmt = this.ficDestGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRoutCmbTpCd = this.ficDestRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRoutCmbTpCd = this.ficOrgRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCyDorRtTpCd = this.destCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCd = this.ficDestRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCyDorRtTpCd = this.orgCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlg = this.destOptmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm = this.orgPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propBofAmt = this.propBofAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucUsdAmt = this.bucUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcUsdAmt = this.ifcUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineUpdDt = this.ficDestGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmt = this.ficOrgGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlg = this.orgOptmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgPropRtAmt = this.ficOrgPropRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destBsePortLocCd = this.destBsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCd = this.ficOrgRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestPropRtAmt = this.ficDestPropRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscUsdAmt = this.pscUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm = this.destPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBsePortLocCd = this.orgBsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm = this.orgRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineUpdDt = this.ficOrgGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm = this.destRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
