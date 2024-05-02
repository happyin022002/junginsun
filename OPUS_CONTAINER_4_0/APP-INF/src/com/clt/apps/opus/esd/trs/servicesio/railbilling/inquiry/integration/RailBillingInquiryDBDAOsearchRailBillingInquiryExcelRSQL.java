/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingInquiryDBDAOsearchRailBillingInquiryExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.10.26 박연진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingInquiryDBDAOsearchRailBillingInquiryExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Bill Order Inquiry Excel 화면에 대한 조회
	  * </pre>
	  */
	public RailBillingInquiryDBDAOsearchRailBillingInquiryExcelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("provVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.integration").append("\n"); 
		query.append("FileName : RailBillingInquiryDBDAOsearchRailBillingInquiryExcelRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT /*+ ORDERD USE_NL(x b c loc1 cnt1 loc2 cnt2) */" ).append("\n"); 
		query.append("TRIM(x.trsp_so_ofc_cty_cd) || TRIM(x.trsp_so_seq) row_idx" ).append("\n"); 
		query.append(",'' chk" ).append("\n"); 
		query.append(",x.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(",x.trsp_so_seq" ).append("\n"); 
		query.append(",x.bkg_no" ).append("\n"); 
		query.append(",x.cgo_tp_cd" ).append("\n"); 
		query.append(",commcode_pkg.get_comdtl_name_fnc ('CD00748', x.cgo_tp_cd) cgo_tp_nm" ).append("\n"); 
		query.append(",x.eq_no cntr_no" ).append("\n"); 
		query.append(",x.eq_tpsz_cd cntr_tpsz_cd" ).append("\n"); 
		query.append(",c.cntr_tpsz_rmk cntr_tpsz_nm" ).append("\n"); 
		query.append(",loc1.loc_nm || ' ' || cnt1.cnt_nm org_splc_loc_nm" ).append("\n"); 
		query.append(",loc2.loc_nm || ' ' || cnt2.cnt_nm dest_loc_nm" ).append("\n"); 
		query.append(",TO_CHAR(x.cre_dt, 'YYYY-MM-DD') req_dt" ).append("\n"); 
		query.append(",x.cre_dt rail_bill_dt" ).append("\n"); 
		query.append(",TO_CHAR(x.cxl_rqst_dt, 'YYYY-MM-DD') cncl_dt" ).append("\n"); 
		query.append(",x.cxl_rqst_rsn" ).append("\n"); 
		query.append(",x.cxl_rqst_rjct_rsn" ).append("\n"); 
		query.append(",(CASE" ).append("\n"); 
		query.append("WHEN x.cxl_rqst_flg = 'N' AND NVL(x.cxl_rqst_rjct_flg, 'N') = 'Y' AND x.delt_flg = 'N' THEN '7'" ).append("\n"); 
		query.append("WHEN x.cxl_rqst_flg = 'Y' AND NVL(x.cxl_rqst_rjct_flg, 'N') = 'N' AND x.delt_flg = 'N' THEN '6'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'E' THEN '8'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'V' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'A' THEN '5'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'A' THEN '5'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' AND b.bil_iss_sts_cd = 'X' THEN '4'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' THEN '3'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'C' AND x.delt_flg = 'N' THEN '1'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'R' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' THEN '1'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'C' AND x.delt_flg = 'Y' THEN '2'" ).append("\n"); 
		query.append("END) status_cd" ).append("\n"); 
		query.append(",(CASE" ).append("\n"); 
		query.append("WHEN x.cxl_rqst_flg = 'N' AND NVL(x.cxl_rqst_rjct_flg, 'N') = 'Y' AND x.delt_flg = 'N' THEN 'Cancellation Requested Rejected'" ).append("\n"); 
		query.append("WHEN x.cxl_rqst_flg = 'Y' AND NVL(x.cxl_rqst_rjct_flg, 'N') = 'N' AND x.delt_flg = 'N' THEN 'Cancellation Requested'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'E' THEN 'EDI Error'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'V' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'A' THEN 'Acknowledged'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'A' THEN 'Acknowledged'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' AND b.bil_iss_sts_cd = 'X' THEN 'Rail Billing Cancelled'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' THEN 'Rail Billed'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'C' AND x.delt_flg = 'N' THEN 'Requested'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'R' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' THEN 'Requested'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'C' AND x.delt_flg = 'Y' THEN 'Request Cancelled'" ).append("\n"); 
		query.append("END) status_nm" ).append("\n"); 
		query.append(",b.bil_iss_knt" ).append("\n"); 
		query.append(",b.spcl_instr_rmk" ).append("\n"); 
		query.append(",b.rail_ord_rjct_flg" ).append("\n"); 
		query.append(",b.wo_rjct_rsn" ).append("\n"); 
		query.append(",case when b.inter_rmk is null then x.inter_rmk" ).append("\n"); 
		query.append("else b.inter_rmk" ).append("\n"); 
		query.append("end inter_rmk" ).append("\n"); 
		query.append(",x.fm_nod_cd" ).append("\n"); 
		query.append(",x.to_nod_cd" ).append("\n"); 
		query.append(",x.bl_no" ).append("\n"); 
		query.append(",x.bkg_cgo_tp_cd" ).append("\n"); 
		query.append(",x.cop_no" ).append("\n"); 
		query.append(",x.cost_act_grp_seq" ).append("\n"); 
		query.append(",x.repo_pln_id" ).append("\n"); 
		query.append(",x.pln_yrwk" ).append("\n"); 
		query.append(",x.ref_id" ).append("\n"); 
		query.append(",x.ref_seq" ).append("\n"); 
		query.append(",x.trsp_rqst_bkg_flg" ).append("\n"); 
		query.append(",vnd.ofc_cd" ).append("\n"); 
		query.append("FROM (SELECT a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(",a.trsp_so_seq" ).append("\n"); 
		query.append(",a.bkg_no" ).append("\n"); 
		query.append(",a.cgo_tp_cd" ).append("\n"); 
		query.append(",a.eq_no" ).append("\n"); 
		query.append(",a.eq_tpsz_cd" ).append("\n"); 
		query.append(",a.trsp_so_sts_cd" ).append("\n"); 
		query.append(",a.spnd_flg" ).append("\n"); 
		query.append(",a.cxl_rqst_flg" ).append("\n"); 
		query.append(",a.cxl_rqst_rjct_flg" ).append("\n"); 
		query.append(",a.delt_flg" ).append("\n"); 
		query.append(",a.fm_nod_cd" ).append("\n"); 
		query.append(",a.to_nod_cd" ).append("\n"); 
		query.append(",a.cre_dt" ).append("\n"); 
		query.append(",a.cxl_rqst_dt" ).append("\n"); 
		query.append(",a.cxl_rqst_rsn" ).append("\n"); 
		query.append(",a.cxl_rqst_rjct_rsn" ).append("\n"); 
		query.append(",(SELECT   MAX(a2.bil_iss_knt)" ).append("\n"); 
		query.append("FROM trs_trsp_edi_rail_ord a2" ).append("\n"); 
		query.append("WHERE a2.trsp_so_ofc_cty_cd = a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND a2.trsp_so_seq = a.trsp_so_seq" ).append("\n"); 
		query.append("GROUP BY a2.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(",a2.trsp_so_seq) bil_iss_knt" ).append("\n"); 
		query.append(",a.inter_rmk" ).append("\n"); 
		query.append(",a.bl_no" ).append("\n"); 
		query.append(",a.bkg_cgo_tp_cd" ).append("\n"); 
		query.append(",a.cop_no" ).append("\n"); 
		query.append(",a.cost_act_grp_seq" ).append("\n"); 
		query.append(",a.repo_pln_id" ).append("\n"); 
		query.append(",a.pln_yrwk" ).append("\n"); 
		query.append(",a.ref_id" ).append("\n"); 
		query.append(",a.ref_seq" ).append("\n"); 
		query.append(",a.trsp_rqst_bkg_flg" ).append("\n"); 
		query.append(",a.prov_vndr_seq as vndr_seq" ).append("\n"); 
		query.append("FROM trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("-- Almighty가 아닌 경우" ).append("\n"); 
		query.append("#if (${userRoleCd} != '1') -- almighty 계정 구분 (almighty : 1)" ).append("\n"); 
		query.append("AND a.prov_vndr_seq = @[provVndrSeq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($trsRailOrderKey.size() > 0)" ).append("\n"); 
		query.append("AND (a.trsp_so_ofc_cty_cd, a.trsp_so_seq) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${trsRailOrderKey})" ).append("\n"); 
		query.append("#if($velocityCount < $trsRailOrderKey.size())" ).append("\n"); 
		query.append("('$key.velParamField1','$key.velParamField2')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("('$key.velParamField1','$key.velParamField2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") x" ).append("\n"); 
		query.append(",trs_trsp_edi_rail_ord b" ).append("\n"); 
		query.append(",mdm_cntr_tp_sz c" ).append("\n"); 
		query.append(",mdm_location loc1" ).append("\n"); 
		query.append(",mdm_location loc2" ).append("\n"); 
		query.append(",mdm_country cnt1" ).append("\n"); 
		query.append(",mdm_country cnt2" ).append("\n"); 
		query.append(",mdm_vendor vnd" ).append("\n"); 
		query.append("WHERE x.trsp_so_ofc_cty_cd = b.trsp_so_ofc_cty_cd(+)" ).append("\n"); 
		query.append("AND x.trsp_so_seq        = b.trsp_so_seq(+)" ).append("\n"); 
		query.append("AND x.bil_iss_knt        = b.bil_iss_knt(+)" ).append("\n"); 
		query.append("AND x.eq_tpsz_cd = c.cntr_tpsz_cd" ).append("\n"); 
		query.append("AND SUBSTR(x.fm_nod_cd, 1, 5) = loc1.loc_cd(+)" ).append("\n"); 
		query.append("AND loc1.cnt_cd = cnt1.cnt_cd(+)" ).append("\n"); 
		query.append("AND SUBSTR(x.to_nod_cd, 1, 5) = loc2.loc_cd(+)" ).append("\n"); 
		query.append("AND loc2.cnt_cd = cnt2.cnt_cd(+)" ).append("\n"); 
		query.append("AND vnd.vndr_seq = x.vndr_seq" ).append("\n"); 

	}
}