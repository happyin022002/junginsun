/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderDetailDBDAOsearchDetailExcelPrintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.07
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.10.07 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderDetailDBDAOsearchDetailExcelPrintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Work Order Detail Excel 정보를 조회 한다.
	  * </pre>
	  */
	public WorkOrderDetailDBDAOsearchDetailExcelPrintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderDetailDBDAOsearchDetailExcelPrintRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    DISTINCT eq_no" ).append("\n"); 
		query.append("    ,trsp_so_ofc_cty_cd ||trsp_so_seq   trsp_so_no" ).append("\n"); 
		query.append("    ,trsp_wo_ofc_cty_cd ||trsp_wo_seq  trsp_wo_no" ).append("\n"); 
		query.append("    ,DECODE(nvl(trsp_inv_act_sts_cd,'N'), 'N','Normal','Invoiced') validity" ).append("\n"); 
		query.append("    ,DECODE (trsp_inv_act_sts_cd, null,'N','Y') invoiced" ).append("\n"); 
		query.append("    ,trsp_so_sts_cd" ).append("\n"); 
		query.append("    ,eq_tpsz_cd" ).append("\n"); 
		query.append("    ,(SELECT cntr_tpsz_rmk FROM mdm_cntr_tp_sz WHERE cntr_tpsz_cd = eq_tpsz_cd) eq_tpsz_nm" ).append("\n"); 
		query.append("	,(SELECT cntr_tpsz_iso_cd FROM mdm_cntr_tp_sz WHERE cntr_tpsz_cd = eq_tpsz_cd) iso_cd" ).append("\n"); 
		query.append("	,(SELECT iso_cntr_tpsz_nm" ).append("\n"); 
		query.append("	    FROM mst_iso_cntr_tp_sz" ).append("\n"); 
		query.append("	   WHERE iso_cntr_tpsz_cd = (SELECT cntr_tpsz_iso_cd" ).append("\n"); 
		query.append("	                                FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("	                              WHERE cntr_tpsz_cd = eq_tpsz_cd)) iso_nm" ).append("\n"); 
		query.append("	,to_char(apnt_dt, 'YYYY-MM-DD HH24:MI:SS') apnt_dt" ).append("\n"); 
		query.append("	,to_char(de_dt, 'YYYY-MM-DD HH24:MI:SS') de_dt" ).append("\n"); 
		query.append("	,wo_rjct_rsn" ).append("\n"); 
		query.append("	,bkg_no" ).append("\n"); 
		query.append("	,wo_amt" ).append("\n"); 
		query.append("	,spot_bid_no" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT" ).append("\n"); 
		query.append("     so.*" ).append("\n"); 
		query.append("    FROM trs_trsp_wrk_ord wo," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("           so.eq_no" ).append("\n"); 
		query.append("           ,so.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("           ,so.trsp_so_seq" ).append("\n"); 
		query.append("           ,so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("           ,so.trsp_wo_seq" ).append("\n"); 
		query.append("           ,so.trsp_inv_act_sts_cd" ).append("\n"); 
		query.append("           ,so.trsp_so_sts_cd" ).append("\n"); 
		query.append("           ,so.eq_tpsz_cd" ).append("\n"); 
		query.append("           ,so.apnt_dt" ).append("\n"); 
		query.append("           ,so.de_dt" ).append("\n"); 
		query.append("           ,so.bkg_no" ).append("\n"); 
		query.append("           ,hs.wo_rjct_rsn" ).append("\n"); 
		query.append("   		   ,nvl(so.bzc_amt,0)+nvl(so.nego_amt,0)+nvl(so.fuel_scg_amt,0)+nvl(so.ovr_wgt_scg_amt,0)+nvl(so.etc_add_amt,0)+nvl(so.toll_fee_amt,0) as wo_amt" ).append("\n"); 
		query.append("           ,so.spot_bid_no" ).append("\n"); 
		query.append("		 FROM trs_trsp_svc_ord so, trs_trsp_wrk_ord_rjct_his hs" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("#if ($trsp_so_no.size() > 0) " ).append("\n"); 
		query.append("       AND (so.trsp_so_ofc_cty_cd,so.trsp_so_seq) in (" ).append("\n"); 
		query.append("	#foreach($soKey in ${trsp_so_no}) " ).append("\n"); 
		query.append("		#if($velocityCount < $trsp_so_no.size()) " ).append("\n"); 
		query.append("			(substr('$soKey',0,3),to_number(substr('$soKey',4,length('$soKey'))))," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(substr('$soKey',0,3),to_number(substr('$soKey',4,length('$soKey'))))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	  AND 1=2 " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("           AND so.trsp_so_ofc_cty_cd = hs.trsp_so_ofc_cty_cd(+)" ).append("\n"); 
		query.append("           AND so.trsp_so_seq = hs.trsp_so_seq(+)" ).append("\n"); 
		query.append("     ) so" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND wo.delt_flg = 'N'" ).append("\n"); 
		query.append("       AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("       AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("ORDER BY eq_no asc" ).append("\n"); 

	}
}