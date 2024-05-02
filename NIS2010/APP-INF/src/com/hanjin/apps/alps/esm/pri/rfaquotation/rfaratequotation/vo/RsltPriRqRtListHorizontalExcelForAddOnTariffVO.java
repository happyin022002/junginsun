/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltPriRqRtListHorizontalExcelForAddOnTariffVO.java
*@FileTitle : RsltPriRqRtListHorizontalExcelForAddOnTariffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.31
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.31 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo;

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

public class RsltPriRqRtListHorizontalExcelForAddOnTariffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRqRtListHorizontalExcelForAddOnTariffVO> models = new ArrayList<RsltPriRqRtListHorizontalExcelForAddOnTariffVO>();
	
	/* Column Info */
	private String orgRateFicDry40 = null;
	/* Column Info */
	private String destRateFicDry40hc = null;
	/* Column Info */
	private String ficOrgRtUseStsCdRf40hc = null;
	/* Column Info */
	private String ficOrgGlineRtAmtDry45 = null;
	/* Column Info */
	private String ficDestGlineRtAmtDry40hc = null;
	/* Column Info */
	private String rateRd40hc = null;
	/* Column Info */
	private String ficOrgGlineRtAmtDry40 = null;
	/* Column Info */
	private String ficOrgGlineRtAmtRd40hc = null;
	/* Column Info */
	private String orgRateFicRf40hc = null;
	/* Column Info */
	private String destCyDorRtTpCd = null;
	/* Column Info */
	private String ficOrgGlineRtAmtRf40hc = null;
	/* Column Info */
	private String orgCyDorRtTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rateDry45 = null;
	/* Column Info */
	private String ficOrgRtUseStsCdRd40hc = null;
	/* Column Info */
	private String rateBofDry20 = null;
	/* Column Info */
	private String ficOrgRtUseStsCdDry40hc = null;
	/* Column Info */
	private String ficDestRtUseStsCdDry20 = null;
	/* Column Info */
	private String rateBofRf40hc = null;
	/* Column Info */
	private String destOptmTrspModFlgRf40hc = null;
	/* Column Info */
	private String rateDry40 = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String orgRateFicDry45 = null;
	/* Column Info */
	private String destRateFicDry40 = null;
	/* Column Info */
	private String destRateFicDry45 = null;
	/* Column Info */
	private String rateBofDry40hc = null;
	/* Column Info */
	private String orgOptmTrspModFlgDry20 = null;
	/* Column Info */
	private String ficDestGlineRtAmtDry20 = null;
	/* Column Info */
	private String destBsePortLocCd = null;
	/* Column Info */
	private String ficDestGlineRtAmtRd40hc = null;
	/* Column Info */
	private String rateBofDry45 = null;
	/* Column Info */
	private String ficDestRtUseStsCdRd40hc = null;
	/* Column Info */
	private String orgOptmTrspModFlgRd40hc = null;
	/* Column Info */
	private String destOptmTrspModFlgDry20 = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String ficDestGlineRtAmtRf40hc = null;
	/* Column Info */
	private String rateDry40hc = null;
	/* Column Info */
	private String destOptmTrspModFlgDry40hc = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String ficOrgRtUseStsCdDry20 = null;
	/* Column Info */
	private String destOptmTrspModFlgRd40hc = null;
	/* Column Info */
	private String destPrcTrspModNm = null;
	/* Column Info */
	private String rateBofDry40 = null;
	/* Column Info */
	private String orgRcvDeTermNm = null;
	/* Column Info */
	private String orgRateFicRd40hc = null;
	/* Column Info */
	private String ficDestRoutCmbTpCd = null;
	/* Column Info */
	private String orgRateFicDry20 = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String ficOrgRoutCmbTpCd = null;
	/* Column Info */
	private String orgOptmTrspModFlgDry40 = null;
	/* Column Info */
	private String orgOptmTrspModFlgRf40hc = null;
	/* Column Info */
	private String ficOrgGlineRtAmtDry20 = null;
	/* Column Info */
	private String ficDestRtUseStsCdDry40hc = null;
	/* Column Info */
	private String orgRateFicDry40hc = null;
	/* Column Info */
	private String rateDry20 = null;
	/* Column Info */
	private String orgPrcTrspModNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rateBofRd40hc = null;
	/* Column Info */
	private String ficDestRtUseStsCdDry40 = null;
	/* Column Info */
	private String orgOptmTrspModFlgDry40hc = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String orgOptmTrspModFlgDry45 = null;
	/* Column Info */
	private String ficDestRtUseStsCdDry45 = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String destOptmTrspModFlgDry40 = null;
	/* Column Info */
	private String destRateFicDry20 = null;
	/* Column Info */
	private String ficDestGlineRtAmtDry40 = null;
	/* Column Info */
	private String ficDestGlineRtAmtDry45 = null;
	/* Column Info */
	private String destOptmTrspModFlgDry45 = null;
	/* Column Info */
	private String ficOrgGlineRtAmtDry40hc = null;
	/* Column Info */
	private String ficOrgRtUseStsCdDry40 = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String destRateFicRf40hc = null;
	/* Column Info */
	private String rateRf40hc = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String orgBsePortLocCd = null;
	/* Column Info */
	private String ficDestRtUseStsCdRf40hc = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String destRateFicRd40hc = null;
	/* Column Info */
	private String ficOrgRtUseStsCdDry45 = null;
	/* Column Info */
	private String destRcvDeTermNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRqRtListHorizontalExcelForAddOnTariffVO() {}

	public RsltPriRqRtListHorizontalExcelForAddOnTariffVO(String ibflag, String pagerows, String cmdtDpSeq, String routDpSeq, String prcCmdtDefCd, String prcCmdtDefNm, String orgRoutPntLocDefCd, String orgRoutPntLocDefNm, String orgRcvDeTermNm, String orgPrcTrspModNm, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String destRoutPntLocDefNm, String destRcvDeTermNm, String destPrcTrspModNm, String rateDry20, String rateDry40, String rateDry40hc, String rateDry45, String rateRd40hc, String rateRf40hc, String orgRateFicDry20, String orgRateFicDry40, String orgRateFicDry40hc, String orgRateFicDry45, String orgRateFicRd40hc, String orgRateFicRf40hc, String destRateFicDry20, String destRateFicDry40, String destRateFicDry40hc, String destRateFicDry45, String destRateFicRd40hc, String destRateFicRf40hc, String rateBofDry20, String rateBofDry40, String rateBofDry40hc, String rateBofDry45, String rateBofRd40hc, String rateBofRf40hc, String orgBsePortLocCd, String ficOrgRoutCmbTpCd, String ficOrgGlineRtAmtDry20, String ficOrgGlineRtAmtDry40, String ficOrgGlineRtAmtDry40hc, String ficOrgGlineRtAmtDry45, String ficOrgGlineRtAmtRf40hc, String ficOrgGlineRtAmtRd40hc, String ficOrgRtUseStsCdDry20, String ficOrgRtUseStsCdDry40, String ficOrgRtUseStsCdDry40hc, String ficOrgRtUseStsCdDry45, String ficOrgRtUseStsCdRf40hc, String ficOrgRtUseStsCdRd40hc, String orgOptmTrspModFlgDry20, String orgOptmTrspModFlgDry40, String orgOptmTrspModFlgDry40hc, String orgOptmTrspModFlgDry45, String orgOptmTrspModFlgRf40hc, String orgOptmTrspModFlgRd40hc, String destBsePortLocCd, String ficDestRoutCmbTpCd, String ficDestGlineRtAmtDry20, String ficDestGlineRtAmtDry40, String ficDestGlineRtAmtDry40hc, String ficDestGlineRtAmtDry45, String ficDestGlineRtAmtRf40hc, String ficDestGlineRtAmtRd40hc, String ficDestRtUseStsCdDry20, String ficDestRtUseStsCdDry40, String ficDestRtUseStsCdDry40hc, String ficDestRtUseStsCdDry45, String ficDestRtUseStsCdRf40hc, String ficDestRtUseStsCdRd40hc, String destOptmTrspModFlgDry20, String destOptmTrspModFlgDry40, String destOptmTrspModFlgDry40hc, String destOptmTrspModFlgDry45, String destOptmTrspModFlgRf40hc, String destOptmTrspModFlgRd40hc, String orgCyDorRtTpCd, String destCyDorRtTpCd) {
		this.orgRateFicDry40 = orgRateFicDry40;
		this.destRateFicDry40hc = destRateFicDry40hc;
		this.ficOrgRtUseStsCdRf40hc = ficOrgRtUseStsCdRf40hc;
		this.ficOrgGlineRtAmtDry45 = ficOrgGlineRtAmtDry45;
		this.ficDestGlineRtAmtDry40hc = ficDestGlineRtAmtDry40hc;
		this.rateRd40hc = rateRd40hc;
		this.ficOrgGlineRtAmtDry40 = ficOrgGlineRtAmtDry40;
		this.ficOrgGlineRtAmtRd40hc = ficOrgGlineRtAmtRd40hc;
		this.orgRateFicRf40hc = orgRateFicRf40hc;
		this.destCyDorRtTpCd = destCyDorRtTpCd;
		this.ficOrgGlineRtAmtRf40hc = ficOrgGlineRtAmtRf40hc;
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
		this.pagerows = pagerows;
		this.rateDry45 = rateDry45;
		this.ficOrgRtUseStsCdRd40hc = ficOrgRtUseStsCdRd40hc;
		this.rateBofDry20 = rateBofDry20;
		this.ficOrgRtUseStsCdDry40hc = ficOrgRtUseStsCdDry40hc;
		this.ficDestRtUseStsCdDry20 = ficDestRtUseStsCdDry20;
		this.rateBofRf40hc = rateBofRf40hc;
		this.destOptmTrspModFlgRf40hc = destOptmTrspModFlgRf40hc;
		this.rateDry40 = rateDry40;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.orgRateFicDry45 = orgRateFicDry45;
		this.destRateFicDry40 = destRateFicDry40;
		this.destRateFicDry45 = destRateFicDry45;
		this.rateBofDry40hc = rateBofDry40hc;
		this.orgOptmTrspModFlgDry20 = orgOptmTrspModFlgDry20;
		this.ficDestGlineRtAmtDry20 = ficDestGlineRtAmtDry20;
		this.destBsePortLocCd = destBsePortLocCd;
		this.ficDestGlineRtAmtRd40hc = ficDestGlineRtAmtRd40hc;
		this.rateBofDry45 = rateBofDry45;
		this.ficDestRtUseStsCdRd40hc = ficDestRtUseStsCdRd40hc;
		this.orgOptmTrspModFlgRd40hc = orgOptmTrspModFlgRd40hc;
		this.destOptmTrspModFlgDry20 = destOptmTrspModFlgDry20;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.ficDestGlineRtAmtRf40hc = ficDestGlineRtAmtRf40hc;
		this.rateDry40hc = rateDry40hc;
		this.destOptmTrspModFlgDry40hc = destOptmTrspModFlgDry40hc;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.cmdtDpSeq = cmdtDpSeq;
		this.ficOrgRtUseStsCdDry20 = ficOrgRtUseStsCdDry20;
		this.destOptmTrspModFlgRd40hc = destOptmTrspModFlgRd40hc;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.rateBofDry40 = rateBofDry40;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.orgRateFicRd40hc = orgRateFicRd40hc;
		this.ficDestRoutCmbTpCd = ficDestRoutCmbTpCd;
		this.orgRateFicDry20 = orgRateFicDry20;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.ficOrgRoutCmbTpCd = ficOrgRoutCmbTpCd;
		this.orgOptmTrspModFlgDry40 = orgOptmTrspModFlgDry40;
		this.orgOptmTrspModFlgRf40hc = orgOptmTrspModFlgRf40hc;
		this.ficOrgGlineRtAmtDry20 = ficOrgGlineRtAmtDry20;
		this.ficDestRtUseStsCdDry40hc = ficDestRtUseStsCdDry40hc;
		this.orgRateFicDry40hc = orgRateFicDry40hc;
		this.rateDry20 = rateDry20;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.ibflag = ibflag;
		this.rateBofRd40hc = rateBofRd40hc;
		this.ficDestRtUseStsCdDry40 = ficDestRtUseStsCdDry40;
		this.orgOptmTrspModFlgDry40hc = orgOptmTrspModFlgDry40hc;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.orgOptmTrspModFlgDry45 = orgOptmTrspModFlgDry45;
		this.ficDestRtUseStsCdDry45 = ficDestRtUseStsCdDry45;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.destOptmTrspModFlgDry40 = destOptmTrspModFlgDry40;
		this.destRateFicDry20 = destRateFicDry20;
		this.ficDestGlineRtAmtDry40 = ficDestGlineRtAmtDry40;
		this.ficDestGlineRtAmtDry45 = ficDestGlineRtAmtDry45;
		this.destOptmTrspModFlgDry45 = destOptmTrspModFlgDry45;
		this.ficOrgGlineRtAmtDry40hc = ficOrgGlineRtAmtDry40hc;
		this.ficOrgRtUseStsCdDry40 = ficOrgRtUseStsCdDry40;
		this.routDpSeq = routDpSeq;
		this.destRateFicRf40hc = destRateFicRf40hc;
		this.rateRf40hc = rateRf40hc;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.orgBsePortLocCd = orgBsePortLocCd;
		this.ficDestRtUseStsCdRf40hc = ficDestRtUseStsCdRf40hc;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.destRateFicRd40hc = destRateFicRd40hc;
		this.ficOrgRtUseStsCdDry45 = ficOrgRtUseStsCdDry45;
		this.destRcvDeTermNm = destRcvDeTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_rate_fic_dry40", getOrgRateFicDry40());
		this.hashColumns.put("dest_rate_fic_dry40hc", getDestRateFicDry40hc());
		this.hashColumns.put("fic_org_rt_use_sts_cd_rf40hc", getFicOrgRtUseStsCdRf40hc());
		this.hashColumns.put("fic_org_gline_rt_amt_dry45", getFicOrgGlineRtAmtDry45());
		this.hashColumns.put("fic_dest_gline_rt_amt_dry40hc", getFicDestGlineRtAmtDry40hc());
		this.hashColumns.put("rate_rd40hc", getRateRd40hc());
		this.hashColumns.put("fic_org_gline_rt_amt_dry40", getFicOrgGlineRtAmtDry40());
		this.hashColumns.put("fic_org_gline_rt_amt_rd40hc", getFicOrgGlineRtAmtRd40hc());
		this.hashColumns.put("org_rate_fic_rf40hc", getOrgRateFicRf40hc());
		this.hashColumns.put("dest_cy_dor_rt_tp_cd", getDestCyDorRtTpCd());
		this.hashColumns.put("fic_org_gline_rt_amt_rf40hc", getFicOrgGlineRtAmtRf40hc());
		this.hashColumns.put("org_cy_dor_rt_tp_cd", getOrgCyDorRtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rate_dry45", getRateDry45());
		this.hashColumns.put("fic_org_rt_use_sts_cd_rd40hc", getFicOrgRtUseStsCdRd40hc());
		this.hashColumns.put("rate_bof_dry20", getRateBofDry20());
		this.hashColumns.put("fic_org_rt_use_sts_cd_dry40hc", getFicOrgRtUseStsCdDry40hc());
		this.hashColumns.put("fic_dest_rt_use_sts_cd_dry20", getFicDestRtUseStsCdDry20());
		this.hashColumns.put("rate_bof_rf40hc", getRateBofRf40hc());
		this.hashColumns.put("dest_optm_trsp_mod_flg_rf40hc", getDestOptmTrspModFlgRf40hc());
		this.hashColumns.put("rate_dry40", getRateDry40());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("org_rate_fic_dry45", getOrgRateFicDry45());
		this.hashColumns.put("dest_rate_fic_dry40", getDestRateFicDry40());
		this.hashColumns.put("dest_rate_fic_dry45", getDestRateFicDry45());
		this.hashColumns.put("rate_bof_dry40hc", getRateBofDry40hc());
		this.hashColumns.put("org_optm_trsp_mod_flg_dry20", getOrgOptmTrspModFlgDry20());
		this.hashColumns.put("fic_dest_gline_rt_amt_dry20", getFicDestGlineRtAmtDry20());
		this.hashColumns.put("dest_bse_port_loc_cd", getDestBsePortLocCd());
		this.hashColumns.put("fic_dest_gline_rt_amt_rd40hc", getFicDestGlineRtAmtRd40hc());
		this.hashColumns.put("rate_bof_dry45", getRateBofDry45());
		this.hashColumns.put("fic_dest_rt_use_sts_cd_rd40hc", getFicDestRtUseStsCdRd40hc());
		this.hashColumns.put("org_optm_trsp_mod_flg_rd40hc", getOrgOptmTrspModFlgRd40hc());
		this.hashColumns.put("dest_optm_trsp_mod_flg_dry20", getDestOptmTrspModFlgDry20());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("fic_dest_gline_rt_amt_rf40hc", getFicDestGlineRtAmtRf40hc());
		this.hashColumns.put("rate_dry40hc", getRateDry40hc());
		this.hashColumns.put("dest_optm_trsp_mod_flg_dry40hc", getDestOptmTrspModFlgDry40hc());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("fic_org_rt_use_sts_cd_dry20", getFicOrgRtUseStsCdDry20());
		this.hashColumns.put("dest_optm_trsp_mod_flg_rd40hc", getDestOptmTrspModFlgRd40hc());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("rate_bof_dry40", getRateBofDry40());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("org_rate_fic_rd40hc", getOrgRateFicRd40hc());
		this.hashColumns.put("fic_dest_rout_cmb_tp_cd", getFicDestRoutCmbTpCd());
		this.hashColumns.put("org_rate_fic_dry20", getOrgRateFicDry20());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("fic_org_rout_cmb_tp_cd", getFicOrgRoutCmbTpCd());
		this.hashColumns.put("org_optm_trsp_mod_flg_dry40", getOrgOptmTrspModFlgDry40());
		this.hashColumns.put("org_optm_trsp_mod_flg_rf40hc", getOrgOptmTrspModFlgRf40hc());
		this.hashColumns.put("fic_org_gline_rt_amt_dry20", getFicOrgGlineRtAmtDry20());
		this.hashColumns.put("fic_dest_rt_use_sts_cd_dry40hc", getFicDestRtUseStsCdDry40hc());
		this.hashColumns.put("org_rate_fic_dry40hc", getOrgRateFicDry40hc());
		this.hashColumns.put("rate_dry20", getRateDry20());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate_bof_rd40hc", getRateBofRd40hc());
		this.hashColumns.put("fic_dest_rt_use_sts_cd_dry40", getFicDestRtUseStsCdDry40());
		this.hashColumns.put("org_optm_trsp_mod_flg_dry40hc", getOrgOptmTrspModFlgDry40hc());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("org_optm_trsp_mod_flg_dry45", getOrgOptmTrspModFlgDry45());
		this.hashColumns.put("fic_dest_rt_use_sts_cd_dry45", getFicDestRtUseStsCdDry45());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("dest_optm_trsp_mod_flg_dry40", getDestOptmTrspModFlgDry40());
		this.hashColumns.put("dest_rate_fic_dry20", getDestRateFicDry20());
		this.hashColumns.put("fic_dest_gline_rt_amt_dry40", getFicDestGlineRtAmtDry40());
		this.hashColumns.put("fic_dest_gline_rt_amt_dry45", getFicDestGlineRtAmtDry45());
		this.hashColumns.put("dest_optm_trsp_mod_flg_dry45", getDestOptmTrspModFlgDry45());
		this.hashColumns.put("fic_org_gline_rt_amt_dry40hc", getFicOrgGlineRtAmtDry40hc());
		this.hashColumns.put("fic_org_rt_use_sts_cd_dry40", getFicOrgRtUseStsCdDry40());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("dest_rate_fic_rf40hc", getDestRateFicRf40hc());
		this.hashColumns.put("rate_rf40hc", getRateRf40hc());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("org_bse_port_loc_cd", getOrgBsePortLocCd());
		this.hashColumns.put("fic_dest_rt_use_sts_cd_rf40hc", getFicDestRtUseStsCdRf40hc());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("dest_rate_fic_rd40hc", getDestRateFicRd40hc());
		this.hashColumns.put("fic_org_rt_use_sts_cd_dry45", getFicOrgRtUseStsCdDry45());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_rate_fic_dry40", "orgRateFicDry40");
		this.hashFields.put("dest_rate_fic_dry40hc", "destRateFicDry40hc");
		this.hashFields.put("fic_org_rt_use_sts_cd_rf40hc", "ficOrgRtUseStsCdRf40hc");
		this.hashFields.put("fic_org_gline_rt_amt_dry45", "ficOrgGlineRtAmtDry45");
		this.hashFields.put("fic_dest_gline_rt_amt_dry40hc", "ficDestGlineRtAmtDry40hc");
		this.hashFields.put("rate_rd40hc", "rateRd40hc");
		this.hashFields.put("fic_org_gline_rt_amt_dry40", "ficOrgGlineRtAmtDry40");
		this.hashFields.put("fic_org_gline_rt_amt_rd40hc", "ficOrgGlineRtAmtRd40hc");
		this.hashFields.put("org_rate_fic_rf40hc", "orgRateFicRf40hc");
		this.hashFields.put("dest_cy_dor_rt_tp_cd", "destCyDorRtTpCd");
		this.hashFields.put("fic_org_gline_rt_amt_rf40hc", "ficOrgGlineRtAmtRf40hc");
		this.hashFields.put("org_cy_dor_rt_tp_cd", "orgCyDorRtTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rate_dry45", "rateDry45");
		this.hashFields.put("fic_org_rt_use_sts_cd_rd40hc", "ficOrgRtUseStsCdRd40hc");
		this.hashFields.put("rate_bof_dry20", "rateBofDry20");
		this.hashFields.put("fic_org_rt_use_sts_cd_dry40hc", "ficOrgRtUseStsCdDry40hc");
		this.hashFields.put("fic_dest_rt_use_sts_cd_dry20", "ficDestRtUseStsCdDry20");
		this.hashFields.put("rate_bof_rf40hc", "rateBofRf40hc");
		this.hashFields.put("dest_optm_trsp_mod_flg_rf40hc", "destOptmTrspModFlgRf40hc");
		this.hashFields.put("rate_dry40", "rateDry40");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("org_rate_fic_dry45", "orgRateFicDry45");
		this.hashFields.put("dest_rate_fic_dry40", "destRateFicDry40");
		this.hashFields.put("dest_rate_fic_dry45", "destRateFicDry45");
		this.hashFields.put("rate_bof_dry40hc", "rateBofDry40hc");
		this.hashFields.put("org_optm_trsp_mod_flg_dry20", "orgOptmTrspModFlgDry20");
		this.hashFields.put("fic_dest_gline_rt_amt_dry20", "ficDestGlineRtAmtDry20");
		this.hashFields.put("dest_bse_port_loc_cd", "destBsePortLocCd");
		this.hashFields.put("fic_dest_gline_rt_amt_rd40hc", "ficDestGlineRtAmtRd40hc");
		this.hashFields.put("rate_bof_dry45", "rateBofDry45");
		this.hashFields.put("fic_dest_rt_use_sts_cd_rd40hc", "ficDestRtUseStsCdRd40hc");
		this.hashFields.put("org_optm_trsp_mod_flg_rd40hc", "orgOptmTrspModFlgRd40hc");
		this.hashFields.put("dest_optm_trsp_mod_flg_dry20", "destOptmTrspModFlgDry20");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("fic_dest_gline_rt_amt_rf40hc", "ficDestGlineRtAmtRf40hc");
		this.hashFields.put("rate_dry40hc", "rateDry40hc");
		this.hashFields.put("dest_optm_trsp_mod_flg_dry40hc", "destOptmTrspModFlgDry40hc");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("fic_org_rt_use_sts_cd_dry20", "ficOrgRtUseStsCdDry20");
		this.hashFields.put("dest_optm_trsp_mod_flg_rd40hc", "destOptmTrspModFlgRd40hc");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("rate_bof_dry40", "rateBofDry40");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("org_rate_fic_rd40hc", "orgRateFicRd40hc");
		this.hashFields.put("fic_dest_rout_cmb_tp_cd", "ficDestRoutCmbTpCd");
		this.hashFields.put("org_rate_fic_dry20", "orgRateFicDry20");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("fic_org_rout_cmb_tp_cd", "ficOrgRoutCmbTpCd");
		this.hashFields.put("org_optm_trsp_mod_flg_dry40", "orgOptmTrspModFlgDry40");
		this.hashFields.put("org_optm_trsp_mod_flg_rf40hc", "orgOptmTrspModFlgRf40hc");
		this.hashFields.put("fic_org_gline_rt_amt_dry20", "ficOrgGlineRtAmtDry20");
		this.hashFields.put("fic_dest_rt_use_sts_cd_dry40hc", "ficDestRtUseStsCdDry40hc");
		this.hashFields.put("org_rate_fic_dry40hc", "orgRateFicDry40hc");
		this.hashFields.put("rate_dry20", "rateDry20");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate_bof_rd40hc", "rateBofRd40hc");
		this.hashFields.put("fic_dest_rt_use_sts_cd_dry40", "ficDestRtUseStsCdDry40");
		this.hashFields.put("org_optm_trsp_mod_flg_dry40hc", "orgOptmTrspModFlgDry40hc");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("org_optm_trsp_mod_flg_dry45", "orgOptmTrspModFlgDry45");
		this.hashFields.put("fic_dest_rt_use_sts_cd_dry45", "ficDestRtUseStsCdDry45");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("dest_optm_trsp_mod_flg_dry40", "destOptmTrspModFlgDry40");
		this.hashFields.put("dest_rate_fic_dry20", "destRateFicDry20");
		this.hashFields.put("fic_dest_gline_rt_amt_dry40", "ficDestGlineRtAmtDry40");
		this.hashFields.put("fic_dest_gline_rt_amt_dry45", "ficDestGlineRtAmtDry45");
		this.hashFields.put("dest_optm_trsp_mod_flg_dry45", "destOptmTrspModFlgDry45");
		this.hashFields.put("fic_org_gline_rt_amt_dry40hc", "ficOrgGlineRtAmtDry40hc");
		this.hashFields.put("fic_org_rt_use_sts_cd_dry40", "ficOrgRtUseStsCdDry40");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("dest_rate_fic_rf40hc", "destRateFicRf40hc");
		this.hashFields.put("rate_rf40hc", "rateRf40hc");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("org_bse_port_loc_cd", "orgBsePortLocCd");
		this.hashFields.put("fic_dest_rt_use_sts_cd_rf40hc", "ficDestRtUseStsCdRf40hc");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("dest_rate_fic_rd40hc", "destRateFicRd40hc");
		this.hashFields.put("fic_org_rt_use_sts_cd_dry45", "ficOrgRtUseStsCdDry45");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgRateFicDry40
	 */
	public String getOrgRateFicDry40() {
		return this.orgRateFicDry40;
	}
	
	/**
	 * Column Info
	 * @return destRateFicDry40hc
	 */
	public String getDestRateFicDry40hc() {
		return this.destRateFicDry40hc;
	}
	
	/**
	 * Column Info
	 * @return ficOrgRtUseStsCdRf40hc
	 */
	public String getFicOrgRtUseStsCdRf40hc() {
		return this.ficOrgRtUseStsCdRf40hc;
	}
	
	/**
	 * Column Info
	 * @return ficOrgGlineRtAmtDry45
	 */
	public String getFicOrgGlineRtAmtDry45() {
		return this.ficOrgGlineRtAmtDry45;
	}
	
	/**
	 * Column Info
	 * @return ficDestGlineRtAmtDry40hc
	 */
	public String getFicDestGlineRtAmtDry40hc() {
		return this.ficDestGlineRtAmtDry40hc;
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
	 * @return ficOrgGlineRtAmtDry40
	 */
	public String getFicOrgGlineRtAmtDry40() {
		return this.ficOrgGlineRtAmtDry40;
	}
	
	/**
	 * Column Info
	 * @return ficOrgGlineRtAmtRd40hc
	 */
	public String getFicOrgGlineRtAmtRd40hc() {
		return this.ficOrgGlineRtAmtRd40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRateFicRf40hc
	 */
	public String getOrgRateFicRf40hc() {
		return this.orgRateFicRf40hc;
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
	 * @return ficOrgGlineRtAmtRf40hc
	 */
	public String getFicOrgGlineRtAmtRf40hc() {
		return this.ficOrgGlineRtAmtRf40hc;
	}
	
	/**
	 * Column Info
	 * @return orgCyDorRtTpCd
	 */
	public String getOrgCyDorRtTpCd() {
		return this.orgCyDorRtTpCd;
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
	 * @return ficOrgRtUseStsCdRd40hc
	 */
	public String getFicOrgRtUseStsCdRd40hc() {
		return this.ficOrgRtUseStsCdRd40hc;
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
	 * @return ficOrgRtUseStsCdDry40hc
	 */
	public String getFicOrgRtUseStsCdDry40hc() {
		return this.ficOrgRtUseStsCdDry40hc;
	}
	
	/**
	 * Column Info
	 * @return ficDestRtUseStsCdDry20
	 */
	public String getFicDestRtUseStsCdDry20() {
		return this.ficDestRtUseStsCdDry20;
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
	 * @return destOptmTrspModFlgRf40hc
	 */
	public String getDestOptmTrspModFlgRf40hc() {
		return this.destOptmTrspModFlgRf40hc;
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
	 * @return orgRateFicDry45
	 */
	public String getOrgRateFicDry45() {
		return this.orgRateFicDry45;
	}
	
	/**
	 * Column Info
	 * @return destRateFicDry40
	 */
	public String getDestRateFicDry40() {
		return this.destRateFicDry40;
	}
	
	/**
	 * Column Info
	 * @return destRateFicDry45
	 */
	public String getDestRateFicDry45() {
		return this.destRateFicDry45;
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
	 * @return orgOptmTrspModFlgDry20
	 */
	public String getOrgOptmTrspModFlgDry20() {
		return this.orgOptmTrspModFlgDry20;
	}
	
	/**
	 * Column Info
	 * @return ficDestGlineRtAmtDry20
	 */
	public String getFicDestGlineRtAmtDry20() {
		return this.ficDestGlineRtAmtDry20;
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
	 * @return ficDestGlineRtAmtRd40hc
	 */
	public String getFicDestGlineRtAmtRd40hc() {
		return this.ficDestGlineRtAmtRd40hc;
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
	 * @return ficDestRtUseStsCdRd40hc
	 */
	public String getFicDestRtUseStsCdRd40hc() {
		return this.ficDestRtUseStsCdRd40hc;
	}
	
	/**
	 * Column Info
	 * @return orgOptmTrspModFlgRd40hc
	 */
	public String getOrgOptmTrspModFlgRd40hc() {
		return this.orgOptmTrspModFlgRd40hc;
	}
	
	/**
	 * Column Info
	 * @return destOptmTrspModFlgDry20
	 */
	public String getDestOptmTrspModFlgDry20() {
		return this.destOptmTrspModFlgDry20;
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
	 * @return ficDestGlineRtAmtRf40hc
	 */
	public String getFicDestGlineRtAmtRf40hc() {
		return this.ficDestGlineRtAmtRf40hc;
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
	 * @return destOptmTrspModFlgDry40hc
	 */
	public String getDestOptmTrspModFlgDry40hc() {
		return this.destOptmTrspModFlgDry40hc;
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
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return ficOrgRtUseStsCdDry20
	 */
	public String getFicOrgRtUseStsCdDry20() {
		return this.ficOrgRtUseStsCdDry20;
	}
	
	/**
	 * Column Info
	 * @return destOptmTrspModFlgRd40hc
	 */
	public String getDestOptmTrspModFlgRd40hc() {
		return this.destOptmTrspModFlgRd40hc;
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
	 * @return orgRcvDeTermNm
	 */
	public String getOrgRcvDeTermNm() {
		return this.orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return orgRateFicRd40hc
	 */
	public String getOrgRateFicRd40hc() {
		return this.orgRateFicRd40hc;
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
	 * @return orgRateFicDry20
	 */
	public String getOrgRateFicDry20() {
		return this.orgRateFicDry20;
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
	 * @return ficOrgRoutCmbTpCd
	 */
	public String getFicOrgRoutCmbTpCd() {
		return this.ficOrgRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgOptmTrspModFlgDry40
	 */
	public String getOrgOptmTrspModFlgDry40() {
		return this.orgOptmTrspModFlgDry40;
	}
	
	/**
	 * Column Info
	 * @return orgOptmTrspModFlgRf40hc
	 */
	public String getOrgOptmTrspModFlgRf40hc() {
		return this.orgOptmTrspModFlgRf40hc;
	}
	
	/**
	 * Column Info
	 * @return ficOrgGlineRtAmtDry20
	 */
	public String getFicOrgGlineRtAmtDry20() {
		return this.ficOrgGlineRtAmtDry20;
	}
	
	/**
	 * Column Info
	 * @return ficDestRtUseStsCdDry40hc
	 */
	public String getFicDestRtUseStsCdDry40hc() {
		return this.ficDestRtUseStsCdDry40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRateFicDry40hc
	 */
	public String getOrgRateFicDry40hc() {
		return this.orgRateFicDry40hc;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return ficDestRtUseStsCdDry40
	 */
	public String getFicDestRtUseStsCdDry40() {
		return this.ficDestRtUseStsCdDry40;
	}
	
	/**
	 * Column Info
	 * @return orgOptmTrspModFlgDry40hc
	 */
	public String getOrgOptmTrspModFlgDry40hc() {
		return this.orgOptmTrspModFlgDry40hc;
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
	 * @return orgOptmTrspModFlgDry45
	 */
	public String getOrgOptmTrspModFlgDry45() {
		return this.orgOptmTrspModFlgDry45;
	}
	
	/**
	 * Column Info
	 * @return ficDestRtUseStsCdDry45
	 */
	public String getFicDestRtUseStsCdDry45() {
		return this.ficDestRtUseStsCdDry45;
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
	 * @return destOptmTrspModFlgDry40
	 */
	public String getDestOptmTrspModFlgDry40() {
		return this.destOptmTrspModFlgDry40;
	}
	
	/**
	 * Column Info
	 * @return destRateFicDry20
	 */
	public String getDestRateFicDry20() {
		return this.destRateFicDry20;
	}
	
	/**
	 * Column Info
	 * @return ficDestGlineRtAmtDry40
	 */
	public String getFicDestGlineRtAmtDry40() {
		return this.ficDestGlineRtAmtDry40;
	}
	
	/**
	 * Column Info
	 * @return ficDestGlineRtAmtDry45
	 */
	public String getFicDestGlineRtAmtDry45() {
		return this.ficDestGlineRtAmtDry45;
	}
	
	/**
	 * Column Info
	 * @return destOptmTrspModFlgDry45
	 */
	public String getDestOptmTrspModFlgDry45() {
		return this.destOptmTrspModFlgDry45;
	}
	
	/**
	 * Column Info
	 * @return ficOrgGlineRtAmtDry40hc
	 */
	public String getFicOrgGlineRtAmtDry40hc() {
		return this.ficOrgGlineRtAmtDry40hc;
	}
	
	/**
	 * Column Info
	 * @return ficOrgRtUseStsCdDry40
	 */
	public String getFicOrgRtUseStsCdDry40() {
		return this.ficOrgRtUseStsCdDry40;
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
	 * @return destRateFicRf40hc
	 */
	public String getDestRateFicRf40hc() {
		return this.destRateFicRf40hc;
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
	 * @return orgBsePortLocCd
	 */
	public String getOrgBsePortLocCd() {
		return this.orgBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return ficDestRtUseStsCdRf40hc
	 */
	public String getFicDestRtUseStsCdRf40hc() {
		return this.ficDestRtUseStsCdRf40hc;
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
	 * @return destRateFicRd40hc
	 */
	public String getDestRateFicRd40hc() {
		return this.destRateFicRd40hc;
	}
	
	/**
	 * Column Info
	 * @return ficOrgRtUseStsCdDry45
	 */
	public String getFicOrgRtUseStsCdDry45() {
		return this.ficOrgRtUseStsCdDry45;
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
	 * @param orgRateFicDry40
	 */
	public void setOrgRateFicDry40(String orgRateFicDry40) {
		this.orgRateFicDry40 = orgRateFicDry40;
	}
	
	/**
	 * Column Info
	 * @param destRateFicDry40hc
	 */
	public void setDestRateFicDry40hc(String destRateFicDry40hc) {
		this.destRateFicDry40hc = destRateFicDry40hc;
	}
	
	/**
	 * Column Info
	 * @param ficOrgRtUseStsCdRf40hc
	 */
	public void setFicOrgRtUseStsCdRf40hc(String ficOrgRtUseStsCdRf40hc) {
		this.ficOrgRtUseStsCdRf40hc = ficOrgRtUseStsCdRf40hc;
	}
	
	/**
	 * Column Info
	 * @param ficOrgGlineRtAmtDry45
	 */
	public void setFicOrgGlineRtAmtDry45(String ficOrgGlineRtAmtDry45) {
		this.ficOrgGlineRtAmtDry45 = ficOrgGlineRtAmtDry45;
	}
	
	/**
	 * Column Info
	 * @param ficDestGlineRtAmtDry40hc
	 */
	public void setFicDestGlineRtAmtDry40hc(String ficDestGlineRtAmtDry40hc) {
		this.ficDestGlineRtAmtDry40hc = ficDestGlineRtAmtDry40hc;
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
	 * @param ficOrgGlineRtAmtDry40
	 */
	public void setFicOrgGlineRtAmtDry40(String ficOrgGlineRtAmtDry40) {
		this.ficOrgGlineRtAmtDry40 = ficOrgGlineRtAmtDry40;
	}
	
	/**
	 * Column Info
	 * @param ficOrgGlineRtAmtRd40hc
	 */
	public void setFicOrgGlineRtAmtRd40hc(String ficOrgGlineRtAmtRd40hc) {
		this.ficOrgGlineRtAmtRd40hc = ficOrgGlineRtAmtRd40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRateFicRf40hc
	 */
	public void setOrgRateFicRf40hc(String orgRateFicRf40hc) {
		this.orgRateFicRf40hc = orgRateFicRf40hc;
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
	 * @param ficOrgGlineRtAmtRf40hc
	 */
	public void setFicOrgGlineRtAmtRf40hc(String ficOrgGlineRtAmtRf40hc) {
		this.ficOrgGlineRtAmtRf40hc = ficOrgGlineRtAmtRf40hc;
	}
	
	/**
	 * Column Info
	 * @param orgCyDorRtTpCd
	 */
	public void setOrgCyDorRtTpCd(String orgCyDorRtTpCd) {
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
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
	 * @param ficOrgRtUseStsCdRd40hc
	 */
	public void setFicOrgRtUseStsCdRd40hc(String ficOrgRtUseStsCdRd40hc) {
		this.ficOrgRtUseStsCdRd40hc = ficOrgRtUseStsCdRd40hc;
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
	 * @param ficOrgRtUseStsCdDry40hc
	 */
	public void setFicOrgRtUseStsCdDry40hc(String ficOrgRtUseStsCdDry40hc) {
		this.ficOrgRtUseStsCdDry40hc = ficOrgRtUseStsCdDry40hc;
	}
	
	/**
	 * Column Info
	 * @param ficDestRtUseStsCdDry20
	 */
	public void setFicDestRtUseStsCdDry20(String ficDestRtUseStsCdDry20) {
		this.ficDestRtUseStsCdDry20 = ficDestRtUseStsCdDry20;
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
	 * @param destOptmTrspModFlgRf40hc
	 */
	public void setDestOptmTrspModFlgRf40hc(String destOptmTrspModFlgRf40hc) {
		this.destOptmTrspModFlgRf40hc = destOptmTrspModFlgRf40hc;
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
	 * @param orgRateFicDry45
	 */
	public void setOrgRateFicDry45(String orgRateFicDry45) {
		this.orgRateFicDry45 = orgRateFicDry45;
	}
	
	/**
	 * Column Info
	 * @param destRateFicDry40
	 */
	public void setDestRateFicDry40(String destRateFicDry40) {
		this.destRateFicDry40 = destRateFicDry40;
	}
	
	/**
	 * Column Info
	 * @param destRateFicDry45
	 */
	public void setDestRateFicDry45(String destRateFicDry45) {
		this.destRateFicDry45 = destRateFicDry45;
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
	 * @param orgOptmTrspModFlgDry20
	 */
	public void setOrgOptmTrspModFlgDry20(String orgOptmTrspModFlgDry20) {
		this.orgOptmTrspModFlgDry20 = orgOptmTrspModFlgDry20;
	}
	
	/**
	 * Column Info
	 * @param ficDestGlineRtAmtDry20
	 */
	public void setFicDestGlineRtAmtDry20(String ficDestGlineRtAmtDry20) {
		this.ficDestGlineRtAmtDry20 = ficDestGlineRtAmtDry20;
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
	 * @param ficDestGlineRtAmtRd40hc
	 */
	public void setFicDestGlineRtAmtRd40hc(String ficDestGlineRtAmtRd40hc) {
		this.ficDestGlineRtAmtRd40hc = ficDestGlineRtAmtRd40hc;
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
	 * @param ficDestRtUseStsCdRd40hc
	 */
	public void setFicDestRtUseStsCdRd40hc(String ficDestRtUseStsCdRd40hc) {
		this.ficDestRtUseStsCdRd40hc = ficDestRtUseStsCdRd40hc;
	}
	
	/**
	 * Column Info
	 * @param orgOptmTrspModFlgRd40hc
	 */
	public void setOrgOptmTrspModFlgRd40hc(String orgOptmTrspModFlgRd40hc) {
		this.orgOptmTrspModFlgRd40hc = orgOptmTrspModFlgRd40hc;
	}
	
	/**
	 * Column Info
	 * @param destOptmTrspModFlgDry20
	 */
	public void setDestOptmTrspModFlgDry20(String destOptmTrspModFlgDry20) {
		this.destOptmTrspModFlgDry20 = destOptmTrspModFlgDry20;
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
	 * @param ficDestGlineRtAmtRf40hc
	 */
	public void setFicDestGlineRtAmtRf40hc(String ficDestGlineRtAmtRf40hc) {
		this.ficDestGlineRtAmtRf40hc = ficDestGlineRtAmtRf40hc;
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
	 * @param destOptmTrspModFlgDry40hc
	 */
	public void setDestOptmTrspModFlgDry40hc(String destOptmTrspModFlgDry40hc) {
		this.destOptmTrspModFlgDry40hc = destOptmTrspModFlgDry40hc;
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
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param ficOrgRtUseStsCdDry20
	 */
	public void setFicOrgRtUseStsCdDry20(String ficOrgRtUseStsCdDry20) {
		this.ficOrgRtUseStsCdDry20 = ficOrgRtUseStsCdDry20;
	}
	
	/**
	 * Column Info
	 * @param destOptmTrspModFlgRd40hc
	 */
	public void setDestOptmTrspModFlgRd40hc(String destOptmTrspModFlgRd40hc) {
		this.destOptmTrspModFlgRd40hc = destOptmTrspModFlgRd40hc;
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
	 * @param orgRcvDeTermNm
	 */
	public void setOrgRcvDeTermNm(String orgRcvDeTermNm) {
		this.orgRcvDeTermNm = orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param orgRateFicRd40hc
	 */
	public void setOrgRateFicRd40hc(String orgRateFicRd40hc) {
		this.orgRateFicRd40hc = orgRateFicRd40hc;
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
	 * @param orgRateFicDry20
	 */
	public void setOrgRateFicDry20(String orgRateFicDry20) {
		this.orgRateFicDry20 = orgRateFicDry20;
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
	 * @param ficOrgRoutCmbTpCd
	 */
	public void setFicOrgRoutCmbTpCd(String ficOrgRoutCmbTpCd) {
		this.ficOrgRoutCmbTpCd = ficOrgRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgOptmTrspModFlgDry40
	 */
	public void setOrgOptmTrspModFlgDry40(String orgOptmTrspModFlgDry40) {
		this.orgOptmTrspModFlgDry40 = orgOptmTrspModFlgDry40;
	}
	
	/**
	 * Column Info
	 * @param orgOptmTrspModFlgRf40hc
	 */
	public void setOrgOptmTrspModFlgRf40hc(String orgOptmTrspModFlgRf40hc) {
		this.orgOptmTrspModFlgRf40hc = orgOptmTrspModFlgRf40hc;
	}
	
	/**
	 * Column Info
	 * @param ficOrgGlineRtAmtDry20
	 */
	public void setFicOrgGlineRtAmtDry20(String ficOrgGlineRtAmtDry20) {
		this.ficOrgGlineRtAmtDry20 = ficOrgGlineRtAmtDry20;
	}
	
	/**
	 * Column Info
	 * @param ficDestRtUseStsCdDry40hc
	 */
	public void setFicDestRtUseStsCdDry40hc(String ficDestRtUseStsCdDry40hc) {
		this.ficDestRtUseStsCdDry40hc = ficDestRtUseStsCdDry40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRateFicDry40hc
	 */
	public void setOrgRateFicDry40hc(String orgRateFicDry40hc) {
		this.orgRateFicDry40hc = orgRateFicDry40hc;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param ficDestRtUseStsCdDry40
	 */
	public void setFicDestRtUseStsCdDry40(String ficDestRtUseStsCdDry40) {
		this.ficDestRtUseStsCdDry40 = ficDestRtUseStsCdDry40;
	}
	
	/**
	 * Column Info
	 * @param orgOptmTrspModFlgDry40hc
	 */
	public void setOrgOptmTrspModFlgDry40hc(String orgOptmTrspModFlgDry40hc) {
		this.orgOptmTrspModFlgDry40hc = orgOptmTrspModFlgDry40hc;
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
	 * @param orgOptmTrspModFlgDry45
	 */
	public void setOrgOptmTrspModFlgDry45(String orgOptmTrspModFlgDry45) {
		this.orgOptmTrspModFlgDry45 = orgOptmTrspModFlgDry45;
	}
	
	/**
	 * Column Info
	 * @param ficDestRtUseStsCdDry45
	 */
	public void setFicDestRtUseStsCdDry45(String ficDestRtUseStsCdDry45) {
		this.ficDestRtUseStsCdDry45 = ficDestRtUseStsCdDry45;
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
	 * @param destOptmTrspModFlgDry40
	 */
	public void setDestOptmTrspModFlgDry40(String destOptmTrspModFlgDry40) {
		this.destOptmTrspModFlgDry40 = destOptmTrspModFlgDry40;
	}
	
	/**
	 * Column Info
	 * @param destRateFicDry20
	 */
	public void setDestRateFicDry20(String destRateFicDry20) {
		this.destRateFicDry20 = destRateFicDry20;
	}
	
	/**
	 * Column Info
	 * @param ficDestGlineRtAmtDry40
	 */
	public void setFicDestGlineRtAmtDry40(String ficDestGlineRtAmtDry40) {
		this.ficDestGlineRtAmtDry40 = ficDestGlineRtAmtDry40;
	}
	
	/**
	 * Column Info
	 * @param ficDestGlineRtAmtDry45
	 */
	public void setFicDestGlineRtAmtDry45(String ficDestGlineRtAmtDry45) {
		this.ficDestGlineRtAmtDry45 = ficDestGlineRtAmtDry45;
	}
	
	/**
	 * Column Info
	 * @param destOptmTrspModFlgDry45
	 */
	public void setDestOptmTrspModFlgDry45(String destOptmTrspModFlgDry45) {
		this.destOptmTrspModFlgDry45 = destOptmTrspModFlgDry45;
	}
	
	/**
	 * Column Info
	 * @param ficOrgGlineRtAmtDry40hc
	 */
	public void setFicOrgGlineRtAmtDry40hc(String ficOrgGlineRtAmtDry40hc) {
		this.ficOrgGlineRtAmtDry40hc = ficOrgGlineRtAmtDry40hc;
	}
	
	/**
	 * Column Info
	 * @param ficOrgRtUseStsCdDry40
	 */
	public void setFicOrgRtUseStsCdDry40(String ficOrgRtUseStsCdDry40) {
		this.ficOrgRtUseStsCdDry40 = ficOrgRtUseStsCdDry40;
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
	 * @param destRateFicRf40hc
	 */
	public void setDestRateFicRf40hc(String destRateFicRf40hc) {
		this.destRateFicRf40hc = destRateFicRf40hc;
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
	 * @param orgBsePortLocCd
	 */
	public void setOrgBsePortLocCd(String orgBsePortLocCd) {
		this.orgBsePortLocCd = orgBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param ficDestRtUseStsCdRf40hc
	 */
	public void setFicDestRtUseStsCdRf40hc(String ficDestRtUseStsCdRf40hc) {
		this.ficDestRtUseStsCdRf40hc = ficDestRtUseStsCdRf40hc;
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
	 * @param destRateFicRd40hc
	 */
	public void setDestRateFicRd40hc(String destRateFicRd40hc) {
		this.destRateFicRd40hc = destRateFicRd40hc;
	}
	
	/**
	 * Column Info
	 * @param ficOrgRtUseStsCdDry45
	 */
	public void setFicOrgRtUseStsCdDry45(String ficOrgRtUseStsCdDry45) {
		this.ficOrgRtUseStsCdDry45 = ficOrgRtUseStsCdDry45;
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
		setOrgRateFicDry40(JSPUtil.getParameter(request, prefix + "org_rate_fic_dry40", ""));
		setDestRateFicDry40hc(JSPUtil.getParameter(request, prefix + "dest_rate_fic_dry40hc", ""));
		setFicOrgRtUseStsCdRf40hc(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd_rf40hc", ""));
		setFicOrgGlineRtAmtDry45(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt_dry45", ""));
		setFicDestGlineRtAmtDry40hc(JSPUtil.getParameter(request, prefix + "fic_dest_gline_rt_amt_dry40hc", ""));
		setRateRd40hc(JSPUtil.getParameter(request, prefix + "rate_rd40hc", ""));
		setFicOrgGlineRtAmtDry40(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt_dry40", ""));
		setFicOrgGlineRtAmtRd40hc(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt_rd40hc", ""));
		setOrgRateFicRf40hc(JSPUtil.getParameter(request, prefix + "org_rate_fic_rf40hc", ""));
		setDestCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "dest_cy_dor_rt_tp_cd", ""));
		setFicOrgGlineRtAmtRf40hc(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt_rf40hc", ""));
		setOrgCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "org_cy_dor_rt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRateDry45(JSPUtil.getParameter(request, prefix + "rate_dry45", ""));
		setFicOrgRtUseStsCdRd40hc(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd_rd40hc", ""));
		setRateBofDry20(JSPUtil.getParameter(request, prefix + "rate_bof_dry20", ""));
		setFicOrgRtUseStsCdDry40hc(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd_dry40hc", ""));
		setFicDestRtUseStsCdDry20(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd_dry20", ""));
		setRateBofRf40hc(JSPUtil.getParameter(request, prefix + "rate_bof_rf40hc", ""));
		setDestOptmTrspModFlgRf40hc(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg_rf40hc", ""));
		setRateDry40(JSPUtil.getParameter(request, prefix + "rate_dry40", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setOrgRateFicDry45(JSPUtil.getParameter(request, prefix + "org_rate_fic_dry45", ""));
		setDestRateFicDry40(JSPUtil.getParameter(request, prefix + "dest_rate_fic_dry40", ""));
		setDestRateFicDry45(JSPUtil.getParameter(request, prefix + "dest_rate_fic_dry45", ""));
		setRateBofDry40hc(JSPUtil.getParameter(request, prefix + "rate_bof_dry40hc", ""));
		setOrgOptmTrspModFlgDry20(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg_dry20", ""));
		setFicDestGlineRtAmtDry20(JSPUtil.getParameter(request, prefix + "fic_dest_gline_rt_amt_dry20", ""));
		setDestBsePortLocCd(JSPUtil.getParameter(request, prefix + "dest_bse_port_loc_cd", ""));
		setFicDestGlineRtAmtRd40hc(JSPUtil.getParameter(request, prefix + "fic_dest_gline_rt_amt_rd40hc", ""));
		setRateBofDry45(JSPUtil.getParameter(request, prefix + "rate_bof_dry45", ""));
		setFicDestRtUseStsCdRd40hc(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd_rd40hc", ""));
		setOrgOptmTrspModFlgRd40hc(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg_rd40hc", ""));
		setDestOptmTrspModFlgDry20(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg_dry20", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setFicDestGlineRtAmtRf40hc(JSPUtil.getParameter(request, prefix + "fic_dest_gline_rt_amt_rf40hc", ""));
		setRateDry40hc(JSPUtil.getParameter(request, prefix + "rate_dry40hc", ""));
		setDestOptmTrspModFlgDry40hc(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg_dry40hc", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_nm", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, prefix + "cmdt_dp_seq", ""));
		setFicOrgRtUseStsCdDry20(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd_dry20", ""));
		setDestOptmTrspModFlgRd40hc(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg_rd40hc", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request, prefix + "dest_prc_trsp_mod_nm", ""));
		setRateBofDry40(JSPUtil.getParameter(request, prefix + "rate_bof_dry40", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request, prefix + "org_rcv_de_term_nm", ""));
		setOrgRateFicRd40hc(JSPUtil.getParameter(request, prefix + "org_rate_fic_rd40hc", ""));
		setFicDestRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_dest_rout_cmb_tp_cd", ""));
		setOrgRateFicDry20(JSPUtil.getParameter(request, prefix + "org_rate_fic_dry20", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setFicOrgRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_org_rout_cmb_tp_cd", ""));
		setOrgOptmTrspModFlgDry40(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg_dry40", ""));
		setOrgOptmTrspModFlgRf40hc(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg_rf40hc", ""));
		setFicOrgGlineRtAmtDry20(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt_dry20", ""));
		setFicDestRtUseStsCdDry40hc(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd_dry40hc", ""));
		setOrgRateFicDry40hc(JSPUtil.getParameter(request, prefix + "org_rate_fic_dry40hc", ""));
		setRateDry20(JSPUtil.getParameter(request, prefix + "rate_dry20", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request, prefix + "org_prc_trsp_mod_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRateBofRd40hc(JSPUtil.getParameter(request, prefix + "rate_bof_rd40hc", ""));
		setFicDestRtUseStsCdDry40(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd_dry40", ""));
		setOrgOptmTrspModFlgDry40hc(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg_dry40hc", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setOrgOptmTrspModFlgDry45(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg_dry45", ""));
		setFicDestRtUseStsCdDry45(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd_dry45", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setDestOptmTrspModFlgDry40(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg_dry40", ""));
		setDestRateFicDry20(JSPUtil.getParameter(request, prefix + "dest_rate_fic_dry20", ""));
		setFicDestGlineRtAmtDry40(JSPUtil.getParameter(request, prefix + "fic_dest_gline_rt_amt_dry40", ""));
		setFicDestGlineRtAmtDry45(JSPUtil.getParameter(request, prefix + "fic_dest_gline_rt_amt_dry45", ""));
		setDestOptmTrspModFlgDry45(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg_dry45", ""));
		setFicOrgGlineRtAmtDry40hc(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt_dry40hc", ""));
		setFicOrgRtUseStsCdDry40(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd_dry40", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, prefix + "rout_dp_seq", ""));
		setDestRateFicRf40hc(JSPUtil.getParameter(request, prefix + "dest_rate_fic_rf40hc", ""));
		setRateRf40hc(JSPUtil.getParameter(request, prefix + "rate_rf40hc", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setOrgBsePortLocCd(JSPUtil.getParameter(request, prefix + "org_bse_port_loc_cd", ""));
		setFicDestRtUseStsCdRf40hc(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd_rf40hc", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_nm", ""));
		setDestRateFicRd40hc(JSPUtil.getParameter(request, prefix + "dest_rate_fic_rd40hc", ""));
		setFicOrgRtUseStsCdDry45(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd_dry45", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request, prefix + "dest_rcv_de_term_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRqRtListHorizontalExcelForAddOnTariffVO[]
	 */
	public RsltPriRqRtListHorizontalExcelForAddOnTariffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRqRtListHorizontalExcelForAddOnTariffVO[]
	 */
	public RsltPriRqRtListHorizontalExcelForAddOnTariffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRqRtListHorizontalExcelForAddOnTariffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgRateFicDry40 = (JSPUtil.getParameter(request, prefix	+ "org_rate_fic_dry40", length));
			String[] destRateFicDry40hc = (JSPUtil.getParameter(request, prefix	+ "dest_rate_fic_dry40hc", length));
			String[] ficOrgRtUseStsCdRf40hc = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd_rf40hc", length));
			String[] ficOrgGlineRtAmtDry45 = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt_dry45", length));
			String[] ficDestGlineRtAmtDry40hc = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt_dry40hc", length));
			String[] rateRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_rd40hc", length));
			String[] ficOrgGlineRtAmtDry40 = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt_dry40", length));
			String[] ficOrgGlineRtAmtRd40hc = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt_rd40hc", length));
			String[] orgRateFicRf40hc = (JSPUtil.getParameter(request, prefix	+ "org_rate_fic_rf40hc", length));
			String[] destCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "dest_cy_dor_rt_tp_cd", length));
			String[] ficOrgGlineRtAmtRf40hc = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt_rf40hc", length));
			String[] orgCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "org_cy_dor_rt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rateDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_dry45", length));
			String[] ficOrgRtUseStsCdRd40hc = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd_rd40hc", length));
			String[] rateBofDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry20", length));
			String[] ficOrgRtUseStsCdDry40hc = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd_dry40hc", length));
			String[] ficDestRtUseStsCdDry20 = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd_dry20", length));
			String[] rateBofRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_rf40hc", length));
			String[] destOptmTrspModFlgRf40hc = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg_rf40hc", length));
			String[] rateDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_dry40", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] orgRateFicDry45 = (JSPUtil.getParameter(request, prefix	+ "org_rate_fic_dry45", length));
			String[] destRateFicDry40 = (JSPUtil.getParameter(request, prefix	+ "dest_rate_fic_dry40", length));
			String[] destRateFicDry45 = (JSPUtil.getParameter(request, prefix	+ "dest_rate_fic_dry45", length));
			String[] rateBofDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry40hc", length));
			String[] orgOptmTrspModFlgDry20 = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg_dry20", length));
			String[] ficDestGlineRtAmtDry20 = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt_dry20", length));
			String[] destBsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_bse_port_loc_cd", length));
			String[] ficDestGlineRtAmtRd40hc = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt_rd40hc", length));
			String[] rateBofDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry45", length));
			String[] ficDestRtUseStsCdRd40hc = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd_rd40hc", length));
			String[] orgOptmTrspModFlgRd40hc = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg_rd40hc", length));
			String[] destOptmTrspModFlgDry20 = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg_dry20", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] ficDestGlineRtAmtRf40hc = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt_rf40hc", length));
			String[] rateDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_dry40hc", length));
			String[] destOptmTrspModFlgDry40hc = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg_dry40hc", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] ficOrgRtUseStsCdDry20 = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd_dry20", length));
			String[] destOptmTrspModFlgRd40hc = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg_rd40hc", length));
			String[] destPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "dest_prc_trsp_mod_nm", length));
			String[] rateBofDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry40", length));
			String[] orgRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "org_rcv_de_term_nm", length));
			String[] orgRateFicRd40hc = (JSPUtil.getParameter(request, prefix	+ "org_rate_fic_rd40hc", length));
			String[] ficDestRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rout_cmb_tp_cd", length));
			String[] orgRateFicDry20 = (JSPUtil.getParameter(request, prefix	+ "org_rate_fic_dry20", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] ficOrgRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_org_rout_cmb_tp_cd", length));
			String[] orgOptmTrspModFlgDry40 = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg_dry40", length));
			String[] orgOptmTrspModFlgRf40hc = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg_rf40hc", length));
			String[] ficOrgGlineRtAmtDry20 = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt_dry20", length));
			String[] ficDestRtUseStsCdDry40hc = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd_dry40hc", length));
			String[] orgRateFicDry40hc = (JSPUtil.getParameter(request, prefix	+ "org_rate_fic_dry40hc", length));
			String[] rateDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_dry20", length));
			String[] orgPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "org_prc_trsp_mod_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rateBofRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_rd40hc", length));
			String[] ficDestRtUseStsCdDry40 = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd_dry40", length));
			String[] orgOptmTrspModFlgDry40hc = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg_dry40hc", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] orgOptmTrspModFlgDry45 = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg_dry45", length));
			String[] ficDestRtUseStsCdDry45 = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd_dry45", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] destOptmTrspModFlgDry40 = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg_dry40", length));
			String[] destRateFicDry20 = (JSPUtil.getParameter(request, prefix	+ "dest_rate_fic_dry20", length));
			String[] ficDestGlineRtAmtDry40 = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt_dry40", length));
			String[] ficDestGlineRtAmtDry45 = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt_dry45", length));
			String[] destOptmTrspModFlgDry45 = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg_dry45", length));
			String[] ficOrgGlineRtAmtDry40hc = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt_dry40hc", length));
			String[] ficOrgRtUseStsCdDry40 = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd_dry40", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] destRateFicRf40hc = (JSPUtil.getParameter(request, prefix	+ "dest_rate_fic_rf40hc", length));
			String[] rateRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_rf40hc", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] orgBsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "org_bse_port_loc_cd", length));
			String[] ficDestRtUseStsCdRf40hc = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd_rf40hc", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] destRateFicRd40hc = (JSPUtil.getParameter(request, prefix	+ "dest_rate_fic_rd40hc", length));
			String[] ficOrgRtUseStsCdDry45 = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd_dry45", length));
			String[] destRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dest_rcv_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRqRtListHorizontalExcelForAddOnTariffVO();
				if (orgRateFicDry40[i] != null)
					model.setOrgRateFicDry40(orgRateFicDry40[i]);
				if (destRateFicDry40hc[i] != null)
					model.setDestRateFicDry40hc(destRateFicDry40hc[i]);
				if (ficOrgRtUseStsCdRf40hc[i] != null)
					model.setFicOrgRtUseStsCdRf40hc(ficOrgRtUseStsCdRf40hc[i]);
				if (ficOrgGlineRtAmtDry45[i] != null)
					model.setFicOrgGlineRtAmtDry45(ficOrgGlineRtAmtDry45[i]);
				if (ficDestGlineRtAmtDry40hc[i] != null)
					model.setFicDestGlineRtAmtDry40hc(ficDestGlineRtAmtDry40hc[i]);
				if (rateRd40hc[i] != null)
					model.setRateRd40hc(rateRd40hc[i]);
				if (ficOrgGlineRtAmtDry40[i] != null)
					model.setFicOrgGlineRtAmtDry40(ficOrgGlineRtAmtDry40[i]);
				if (ficOrgGlineRtAmtRd40hc[i] != null)
					model.setFicOrgGlineRtAmtRd40hc(ficOrgGlineRtAmtRd40hc[i]);
				if (orgRateFicRf40hc[i] != null)
					model.setOrgRateFicRf40hc(orgRateFicRf40hc[i]);
				if (destCyDorRtTpCd[i] != null)
					model.setDestCyDorRtTpCd(destCyDorRtTpCd[i]);
				if (ficOrgGlineRtAmtRf40hc[i] != null)
					model.setFicOrgGlineRtAmtRf40hc(ficOrgGlineRtAmtRf40hc[i]);
				if (orgCyDorRtTpCd[i] != null)
					model.setOrgCyDorRtTpCd(orgCyDorRtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rateDry45[i] != null)
					model.setRateDry45(rateDry45[i]);
				if (ficOrgRtUseStsCdRd40hc[i] != null)
					model.setFicOrgRtUseStsCdRd40hc(ficOrgRtUseStsCdRd40hc[i]);
				if (rateBofDry20[i] != null)
					model.setRateBofDry20(rateBofDry20[i]);
				if (ficOrgRtUseStsCdDry40hc[i] != null)
					model.setFicOrgRtUseStsCdDry40hc(ficOrgRtUseStsCdDry40hc[i]);
				if (ficDestRtUseStsCdDry20[i] != null)
					model.setFicDestRtUseStsCdDry20(ficDestRtUseStsCdDry20[i]);
				if (rateBofRf40hc[i] != null)
					model.setRateBofRf40hc(rateBofRf40hc[i]);
				if (destOptmTrspModFlgRf40hc[i] != null)
					model.setDestOptmTrspModFlgRf40hc(destOptmTrspModFlgRf40hc[i]);
				if (rateDry40[i] != null)
					model.setRateDry40(rateDry40[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (orgRateFicDry45[i] != null)
					model.setOrgRateFicDry45(orgRateFicDry45[i]);
				if (destRateFicDry40[i] != null)
					model.setDestRateFicDry40(destRateFicDry40[i]);
				if (destRateFicDry45[i] != null)
					model.setDestRateFicDry45(destRateFicDry45[i]);
				if (rateBofDry40hc[i] != null)
					model.setRateBofDry40hc(rateBofDry40hc[i]);
				if (orgOptmTrspModFlgDry20[i] != null)
					model.setOrgOptmTrspModFlgDry20(orgOptmTrspModFlgDry20[i]);
				if (ficDestGlineRtAmtDry20[i] != null)
					model.setFicDestGlineRtAmtDry20(ficDestGlineRtAmtDry20[i]);
				if (destBsePortLocCd[i] != null)
					model.setDestBsePortLocCd(destBsePortLocCd[i]);
				if (ficDestGlineRtAmtRd40hc[i] != null)
					model.setFicDestGlineRtAmtRd40hc(ficDestGlineRtAmtRd40hc[i]);
				if (rateBofDry45[i] != null)
					model.setRateBofDry45(rateBofDry45[i]);
				if (ficDestRtUseStsCdRd40hc[i] != null)
					model.setFicDestRtUseStsCdRd40hc(ficDestRtUseStsCdRd40hc[i]);
				if (orgOptmTrspModFlgRd40hc[i] != null)
					model.setOrgOptmTrspModFlgRd40hc(orgOptmTrspModFlgRd40hc[i]);
				if (destOptmTrspModFlgDry20[i] != null)
					model.setDestOptmTrspModFlgDry20(destOptmTrspModFlgDry20[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (ficDestGlineRtAmtRf40hc[i] != null)
					model.setFicDestGlineRtAmtRf40hc(ficDestGlineRtAmtRf40hc[i]);
				if (rateDry40hc[i] != null)
					model.setRateDry40hc(rateDry40hc[i]);
				if (destOptmTrspModFlgDry40hc[i] != null)
					model.setDestOptmTrspModFlgDry40hc(destOptmTrspModFlgDry40hc[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (ficOrgRtUseStsCdDry20[i] != null)
					model.setFicOrgRtUseStsCdDry20(ficOrgRtUseStsCdDry20[i]);
				if (destOptmTrspModFlgRd40hc[i] != null)
					model.setDestOptmTrspModFlgRd40hc(destOptmTrspModFlgRd40hc[i]);
				if (destPrcTrspModNm[i] != null)
					model.setDestPrcTrspModNm(destPrcTrspModNm[i]);
				if (rateBofDry40[i] != null)
					model.setRateBofDry40(rateBofDry40[i]);
				if (orgRcvDeTermNm[i] != null)
					model.setOrgRcvDeTermNm(orgRcvDeTermNm[i]);
				if (orgRateFicRd40hc[i] != null)
					model.setOrgRateFicRd40hc(orgRateFicRd40hc[i]);
				if (ficDestRoutCmbTpCd[i] != null)
					model.setFicDestRoutCmbTpCd(ficDestRoutCmbTpCd[i]);
				if (orgRateFicDry20[i] != null)
					model.setOrgRateFicDry20(orgRateFicDry20[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (ficOrgRoutCmbTpCd[i] != null)
					model.setFicOrgRoutCmbTpCd(ficOrgRoutCmbTpCd[i]);
				if (orgOptmTrspModFlgDry40[i] != null)
					model.setOrgOptmTrspModFlgDry40(orgOptmTrspModFlgDry40[i]);
				if (orgOptmTrspModFlgRf40hc[i] != null)
					model.setOrgOptmTrspModFlgRf40hc(orgOptmTrspModFlgRf40hc[i]);
				if (ficOrgGlineRtAmtDry20[i] != null)
					model.setFicOrgGlineRtAmtDry20(ficOrgGlineRtAmtDry20[i]);
				if (ficDestRtUseStsCdDry40hc[i] != null)
					model.setFicDestRtUseStsCdDry40hc(ficDestRtUseStsCdDry40hc[i]);
				if (orgRateFicDry40hc[i] != null)
					model.setOrgRateFicDry40hc(orgRateFicDry40hc[i]);
				if (rateDry20[i] != null)
					model.setRateDry20(rateDry20[i]);
				if (orgPrcTrspModNm[i] != null)
					model.setOrgPrcTrspModNm(orgPrcTrspModNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rateBofRd40hc[i] != null)
					model.setRateBofRd40hc(rateBofRd40hc[i]);
				if (ficDestRtUseStsCdDry40[i] != null)
					model.setFicDestRtUseStsCdDry40(ficDestRtUseStsCdDry40[i]);
				if (orgOptmTrspModFlgDry40hc[i] != null)
					model.setOrgOptmTrspModFlgDry40hc(orgOptmTrspModFlgDry40hc[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (orgOptmTrspModFlgDry45[i] != null)
					model.setOrgOptmTrspModFlgDry45(orgOptmTrspModFlgDry45[i]);
				if (ficDestRtUseStsCdDry45[i] != null)
					model.setFicDestRtUseStsCdDry45(ficDestRtUseStsCdDry45[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (destOptmTrspModFlgDry40[i] != null)
					model.setDestOptmTrspModFlgDry40(destOptmTrspModFlgDry40[i]);
				if (destRateFicDry20[i] != null)
					model.setDestRateFicDry20(destRateFicDry20[i]);
				if (ficDestGlineRtAmtDry40[i] != null)
					model.setFicDestGlineRtAmtDry40(ficDestGlineRtAmtDry40[i]);
				if (ficDestGlineRtAmtDry45[i] != null)
					model.setFicDestGlineRtAmtDry45(ficDestGlineRtAmtDry45[i]);
				if (destOptmTrspModFlgDry45[i] != null)
					model.setDestOptmTrspModFlgDry45(destOptmTrspModFlgDry45[i]);
				if (ficOrgGlineRtAmtDry40hc[i] != null)
					model.setFicOrgGlineRtAmtDry40hc(ficOrgGlineRtAmtDry40hc[i]);
				if (ficOrgRtUseStsCdDry40[i] != null)
					model.setFicOrgRtUseStsCdDry40(ficOrgRtUseStsCdDry40[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (destRateFicRf40hc[i] != null)
					model.setDestRateFicRf40hc(destRateFicRf40hc[i]);
				if (rateRf40hc[i] != null)
					model.setRateRf40hc(rateRf40hc[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (orgBsePortLocCd[i] != null)
					model.setOrgBsePortLocCd(orgBsePortLocCd[i]);
				if (ficDestRtUseStsCdRf40hc[i] != null)
					model.setFicDestRtUseStsCdRf40hc(ficDestRtUseStsCdRf40hc[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (destRateFicRd40hc[i] != null)
					model.setDestRateFicRd40hc(destRateFicRd40hc[i]);
				if (ficOrgRtUseStsCdDry45[i] != null)
					model.setFicOrgRtUseStsCdDry45(ficOrgRtUseStsCdDry45[i]);
				if (destRcvDeTermNm[i] != null)
					model.setDestRcvDeTermNm(destRcvDeTermNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRqRtListHorizontalExcelForAddOnTariffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRqRtListHorizontalExcelForAddOnTariffVO[]
	 */
	public RsltPriRqRtListHorizontalExcelForAddOnTariffVO[] getRsltPriRqRtListHorizontalExcelForAddOnTariffVOs(){
		RsltPriRqRtListHorizontalExcelForAddOnTariffVO[] vos = (RsltPriRqRtListHorizontalExcelForAddOnTariffVO[])models.toArray(new RsltPriRqRtListHorizontalExcelForAddOnTariffVO[models.size()]);
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
		this.orgRateFicDry40 = this.orgRateFicDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRateFicDry40hc = this.destRateFicDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCdRf40hc = this.ficOrgRtUseStsCdRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmtDry45 = this.ficOrgGlineRtAmtDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineRtAmtDry40hc = this.ficDestGlineRtAmtDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRd40hc = this.rateRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmtDry40 = this.ficOrgGlineRtAmtDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmtRd40hc = this.ficOrgGlineRtAmtRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRateFicRf40hc = this.orgRateFicRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCyDorRtTpCd = this.destCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmtRf40hc = this.ficOrgGlineRtAmtRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCyDorRtTpCd = this.orgCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry45 = this.rateDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCdRd40hc = this.ficOrgRtUseStsCdRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry20 = this.rateBofDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCdDry40hc = this.ficOrgRtUseStsCdDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCdDry20 = this.ficDestRtUseStsCdDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofRf40hc = this.rateBofRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlgRf40hc = this.destOptmTrspModFlgRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry40 = this.rateDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRateFicDry45 = this.orgRateFicDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRateFicDry40 = this.destRateFicDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRateFicDry45 = this.destRateFicDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry40hc = this.rateBofDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlgDry20 = this.orgOptmTrspModFlgDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineRtAmtDry20 = this.ficDestGlineRtAmtDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destBsePortLocCd = this.destBsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineRtAmtRd40hc = this.ficDestGlineRtAmtRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry45 = this.rateBofDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCdRd40hc = this.ficDestRtUseStsCdRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlgRd40hc = this.orgOptmTrspModFlgRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlgDry20 = this.destOptmTrspModFlgDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineRtAmtRf40hc = this.ficDestGlineRtAmtRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry40hc = this.rateDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlgDry40hc = this.destOptmTrspModFlgDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCdDry20 = this.ficOrgRtUseStsCdDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlgRd40hc = this.destOptmTrspModFlgRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm = this.destPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry40 = this.rateBofDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm = this.orgRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRateFicRd40hc = this.orgRateFicRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRoutCmbTpCd = this.ficDestRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRateFicDry20 = this.orgRateFicDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRoutCmbTpCd = this.ficOrgRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlgDry40 = this.orgOptmTrspModFlgDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlgRf40hc = this.orgOptmTrspModFlgRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmtDry20 = this.ficOrgGlineRtAmtDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCdDry40hc = this.ficDestRtUseStsCdDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRateFicDry40hc = this.orgRateFicDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry20 = this.rateDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm = this.orgPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofRd40hc = this.rateBofRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCdDry40 = this.ficDestRtUseStsCdDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlgDry40hc = this.orgOptmTrspModFlgDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlgDry45 = this.orgOptmTrspModFlgDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCdDry45 = this.ficDestRtUseStsCdDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlgDry40 = this.destOptmTrspModFlgDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRateFicDry20 = this.destRateFicDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineRtAmtDry40 = this.ficDestGlineRtAmtDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineRtAmtDry45 = this.ficDestGlineRtAmtDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlgDry45 = this.destOptmTrspModFlgDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmtDry40hc = this.ficOrgGlineRtAmtDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCdDry40 = this.ficOrgRtUseStsCdDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRateFicRf40hc = this.destRateFicRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRf40hc = this.rateRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBsePortLocCd = this.orgBsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCdRf40hc = this.ficDestRtUseStsCdRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRateFicRd40hc = this.destRateFicRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCdDry45 = this.ficOrgRtUseStsCdDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm = this.destRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
