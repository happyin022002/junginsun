/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailBillingInquiryDBDAOsearchRailBillingInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingInquiryDBDAOsearchRailBillingInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Bill Order Inquiry 화면에 대한 조회
	  * </pre>
	  */
	public RailBillingInquiryDBDAOsearchRailBillingInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargoType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("provVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reqFromDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reqToDt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.integration").append("\n"); 
		query.append("FileName : RailBillingInquiryDBDAOsearchRailBillingInquiryRSQL").append("\n"); 
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
		query.append(",TO_CHAR(x.cxl_rqst_dt, 'YYYY-MM-DD HH24:MI:SS') cncl_dt" ).append("\n"); 
		query.append(",x.cxl_rqst_rsn" ).append("\n"); 
		query.append(",x.cxl_rqst_rjct_rsn" ).append("\n"); 
		query.append(",(CASE" ).append("\n"); 
		query.append("WHEN x.cxl_rqst_flg = 'N' AND NVL(x.cxl_rqst_rjct_flg, 'N') = 'Y' AND x.delt_flg = 'N' THEN '7' -- 'Cancellation Requested Rejected'" ).append("\n"); 
		query.append("WHEN x.cxl_rqst_flg = 'Y' AND NVL(x.cxl_rqst_rjct_flg, 'N') = 'N' AND x.delt_flg = 'N' THEN '6' -- 'Cancellation Requested'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'E' THEN '8' -- 'EDI Error'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'V' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'A' THEN '5' -- 'Acknowledged'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.delt_flg = 'N' AND b.bil_edi_rcv_rslt_cd = 'A' THEN '5' -- 'Acknowledged'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' AND b.bil_iss_sts_cd = 'X' THEN '4' -- 'Rail Billing Cancelled'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' THEN '3' -- 'Rail Billed'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'C' AND x.delt_flg = 'N' THEN '1' -- 'Requested'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'R' AND x.spnd_flg = 'N' AND x.delt_flg = 'N' THEN '1' -- 'Requested'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'C' AND x.delt_flg = 'Y' THEN '2' -- 'Request Cancelled'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'R' AND x.delt_flg = 'Y' THEN '2' -- 'Request Cancelled'" ).append("\n"); 
		query.append("WHEN b.bil_iss_sts_cd = 'X' AND x.delt_flg = 'Y' THEN '10' -- 'Rail Billing Cancelled & Deleted'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.delt_flg = 'Y' THEN '9' -- 'Rail Billing Deleted'" ).append("\n"); 
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
		query.append("WHEN x.trsp_so_sts_cd = 'R' AND x.delt_flg = 'Y' THEN 'Request Cancelled'" ).append("\n"); 
		query.append("WHEN b.bil_iss_sts_cd = 'X' AND x.delt_flg = 'Y' THEN 'Rail Billing Cancelled & Deleted'" ).append("\n"); 
		query.append("WHEN x.trsp_so_sts_cd = 'I' AND x.delt_flg = 'Y' THEN 'Rail Billing Deleted'" ).append("\n"); 
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
		query.append(",a.locl_cre_dt cre_dt" ).append("\n"); 
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
		query.append(",a.prov_vndr_seq as vndr_seq" ).append("\n"); 
		query.append("FROM trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("-- Date 조회이거나 Almighty가 아니면서  && Bkg혹은 Cntr 조회인경우만 Vndr_seq 넣는다." ).append("\n"); 
		query.append("#if (${condType} == '1' || (${userRoleCd} != '1' && ${condType} == '2'))" ).append("\n"); 
		query.append("AND a.prov_vndr_seq = @[provVndrSeq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${condType} == '1') -- Rail Billing Inquiry 조회구분  ( SEARCH_REQ_DT : 1, SEARCH_BKG_CNTL : 2)" ).append("\n"); 
		query.append("AND a.locl_cre_dt BETWEEN TO_DATE(@[reqFromDt] || '000000', 'yyyymmddhh24miss') AND TO_DATE(@[reqToDt] || '235959', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("#if (${cargoType} != '')" ).append("\n"); 
		query.append("AND a.cgo_tp_cd = @[cargoType]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if ($bkgNoList != \"\" )" ).append("\n"); 
		query.append("AND (a.bkg_no) IN (" ).append("\n"); 
		query.append("#foreach( ${bkgKey} in ${bkgNoList})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$bkgKey'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$bkgKey'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($cntrNoList != \"\" )" ).append("\n"); 
		query.append("AND a.eq_no IN (" ).append("\n"); 
		query.append("#foreach( ${cntrKey} in ${cntrNoList})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$cntrKey'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$cntrKey'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("#if (${condType} == '1') -- Rail Billing Inquiry 조회구분  ( SEARCH_REQ_DT : 1, SEARCH_BKG_CNTL : 2)" ).append("\n"); 
		query.append("#if (${statusCd} != '') -- Rail Billing Inquiry Status" ).append("\n"); 
		query.append("#if (${statusCd} == '2') -- Requested Cancelled" ).append("\n"); 
		query.append("AND x.trsp_so_sts_cd = 'C'" ).append("\n"); 
		query.append("AND x.delt_flg = 'Y'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '1') -- Requested" ).append("\n"); 
		query.append("AND ((x.trsp_so_sts_cd = 'C') OR (x.trsp_so_sts_cd = 'R' AND x.spnd_flg = 'N'))" ).append("\n"); 
		query.append("AND x.delt_flg = 'N'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '3') -- Rail Billed" ).append("\n"); 
		query.append("AND x.trsp_so_sts_cd = 'I'" ).append("\n"); 
		query.append("AND x.spnd_flg = 'N'" ).append("\n"); 
		query.append("AND x.delt_flg = 'N'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '4') -- Rail Billed Cancelled" ).append("\n"); 
		query.append("AND x.trsp_so_sts_cd = 'I'" ).append("\n"); 
		query.append("AND x.spnd_flg = 'N'" ).append("\n"); 
		query.append("AND x.delt_flg = 'N'" ).append("\n"); 
		query.append("AND b.bil_iss_sts_cd = 'X'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '5') --  Acknowledged" ).append("\n"); 
		query.append("AND x.trsp_so_sts_cd IN ('I', 'V')" ).append("\n"); 
		query.append("AND x.delt_flg = 'N'" ).append("\n"); 
		query.append("AND b.bil_edi_rcv_rslt_cd = 'A'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '8') -- EDI Error" ).append("\n"); 
		query.append("AND x.trsp_so_sts_cd = 'I'" ).append("\n"); 
		query.append("AND x.delt_flg = 'N'" ).append("\n"); 
		query.append("AND b.bil_edi_rcv_rslt_cd = 'E'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '6') -- Cancellation Requested" ).append("\n"); 
		query.append("AND x.cxl_rqst_flg = 'Y'" ).append("\n"); 
		query.append("AND NVL(x.cxl_rqst_rjct_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND x.delt_flg = 'N'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '7') -- Cancellation Request Rejected" ).append("\n"); 
		query.append("AND x.cxl_rqst_flg = 'N'" ).append("\n"); 
		query.append("AND NVL(x.cxl_rqst_rjct_flg, 'N') = 'Y'" ).append("\n"); 
		query.append("AND x.delt_flg = 'N'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '10') -- Rail Billing Cancelled & Deleted" ).append("\n"); 
		query.append("AND B.bil_iss_sts_cd = 'X'" ).append("\n"); 
		query.append("AND x.delt_flg = 'Y'" ).append("\n"); 
		query.append("#elseif (${statusCd} == '9') -- Rail Billing Deleted" ).append("\n"); 
		query.append("AND x.trsp_so_sts_cd = 'I'" ).append("\n"); 
		query.append("AND x.delt_flg = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}