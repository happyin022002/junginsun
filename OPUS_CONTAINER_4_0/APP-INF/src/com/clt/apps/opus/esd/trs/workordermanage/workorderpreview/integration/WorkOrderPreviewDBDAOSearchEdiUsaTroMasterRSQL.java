/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiUsaTroMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdiUsaTroMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_USA_TRO_MASTER
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiUsaTroMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiUsaTroMasterRSQL").append("\n"); 
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
		query.append("SELECT  so.trsp_wo_ofc_cty_cd||so.trsp_wo_seq as wo_no" ).append("\n"); 
		query.append("	#if (${wo_iss_sts_cd} == 'N' && ${conti_cd}== 'M')" ).append("\n"); 
		query.append("	   	,'C' as UDT_FLAG" ).append("\n"); 
		query.append("	#elseif (${wo_iss_sts_cd} == 'C' && ${conti_cd}== 'M') " ).append("\n"); 
		query.append("       	,DECODE(wo.wo_iss_sts_cd,'I','C','R','C','E') as UDT_FLAG" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	    ,DECODE(wo.wo_iss_sts_cd,'I','I','R','R') as UDT_FLAG	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		,REPLACE(th.diff_rmk, CHR(13)||CHR(10), ' ')	as trm_remark" ).append("\n"); 
		query.append("		,REPLACE(NVL(wo.wo_rmk, wrk_instr.wo_instr_rmk),CHR(13)||CHR(10), ' ') as wo_remark" ).append("\n"); 
		query.append("		,'' as t1_ind" ).append("\n"); 
		query.append("		,TO_CHAR(wo.locl_cre_dt,'YYYYMMDD') as wo_date" ).append("\n"); 
		query.append("		,TO_CHAR(wo.locl_cre_dt,'HHMM') as wo_time" ).append("\n"); 
		query.append("		,so.trsp_cost_dtl_mod_cd as cost_mode" ).append("\n"); 
		query.append("		,so.trsp_crr_mod_cd as trans_mode" ).append("\n"); 
		query.append(" 		,so.dor_svc_tp_cd||DECODE(so.dor_svc_tp_cd,'','','(')||commcode_pkg.get_comdtl_name_fnc('CD00284',so.dor_svc_tp_cd)||DECODE(so.dor_svc_tp_cd,'','',')')	as dr_svc_type" ).append("\n"); 
		query.append(" 		,vndr.usa_edi_cd as trucker_scac" ).append("\n"); 
		query.append("		,so.vndr_seq as trucker_code" ).append("\n"); 
		query.append(" 		,vndr.vndr_lgl_eng_nm as trucker_name" ).append("\n"); 
		query.append("		,REPLACE(vndr.eng_addr, CHR(13)||CHR(10), ' ') as trucker_addr" ).append("\n"); 
		query.append("		,'' as trucker_city" ).append("\n"); 
		query.append("		,'' as trucker_state" ).append("\n"); 
		query.append("		,vndr.zip_cd as trucker_zip" ).append("\n"); 
		query.append(" 		,phn_vndr_cntc.phn_no as trucker_tel" ).append("\n"); 
		query.append("		,NVL(wo.wo_n1st_fax_no, NVL(wo.wo_n2nd_fax_no, wo.wo_n3rd_fax_no)) as trucker_fax" ).append("\n"); 
		query.append(" 		, '' as trucker_pic " ).append("\n"); 
		query.append("		,(SELECT COUNT(x.trsp_so_seq) " ).append("\n"); 
		query.append("			FROM trs_trsp_svc_ord x" ).append("\n"); 
		query.append("		   WHERE x.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("			 AND x.trsp_wo_seq = so.trsp_wo_seq) as cntr_total" ).append("\n"); 
		query.append(" 		,(SELECT COUNT(x.trsp_so_seq) " ).append("\n"); 
		query.append("			FROM trs_trsp_svc_ord x" ).append("\n"); 
		query.append(" 		   WHERE x.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append(" 	    	 AND x.trsp_wo_seq = so.trsp_wo_seq " ).append("\n"); 
		query.append("       	 	 AND x.eq_tpsz_cd LIKE '%2') as cntr_20ft_total" ).append("\n"); 
		query.append("		,(SELECT COUNT(x.trsp_so_seq) " ).append("\n"); 
		query.append("			FROM trs_trsp_svc_ord x" ).append("\n"); 
		query.append("	       WHERE x.trsp_wo_ofc_cty_cd= so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("			 AND x.trsp_wo_seq = so.trsp_wo_seq " ).append("\n"); 
		query.append("			 AND x.eq_tpsz_cd NOT LIKE '%2') as cntr_40ft_total" ).append("\n"); 
		query.append(" 		,LTRIM(TO_CHAR((SELECT SUM(NVL(x.bzc_amt,0)+NVL(x.nego_amt,0)+NVL(x.etc_add_amt,0)+NVL(x.fuel_scg_amt,0))" ).append("\n"); 
		query.append(" 						  FROM trs_trsp_svc_ord x" ).append("\n"); 
		query.append("				   		 WHERE x.trsp_wo_ofc_cty_cd= so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("						   AND x.trsp_wo_seq = so.trsp_wo_seq), '999999999999990.00')) rate_total" ).append("\n"); 
		query.append("		,so.curr_cd as rate_total_cur	" ).append("\n"); 
		query.append("	FROM trs_trsp_svc_ord so" ).append("\n"); 
		query.append("		,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append(" 		,trs_trsp_wrk_ord_instr wrk_instr" ).append("\n"); 
		query.append(" 		,mdm_vendor vndr" ).append("\n"); 
		query.append(" 		,bkg_tro th" ).append("\n"); 
		query.append(" 		,mdm_vndr_cntc_pnt phn_vndr_cntc" ).append("\n"); 
		query.append("   WHERE so.trsp_wo_ofc_cty_cd = wo.trsp_wo_ofc_cty_cd(+)				" ).append("\n"); 
		query.append(" 	 AND so.trsp_wo_seq	= wo.trsp_wo_seq(+)					" ).append("\n"); 
		query.append(" 	 AND so.trsp_cost_dtl_mod_cd = wrk_instr.trsp_cost_mod_cd(+)			" ).append("\n"); 
		query.append(" 	 AND so.trsp_crr_mod_cd = wrk_instr.trsp_crr_mod_cd(+)			" ).append("\n"); 
		query.append(" 	 AND so.trsp_bnd_cd = wrk_instr.trsp_bnd_cd(+) 				" ).append("\n"); 
		query.append(" 	 AND so.cre_ofc_cd = wrk_instr.wo_instr_ofc_cd(+) 			" ).append("\n"); 
		query.append(" 	 AND so.vndr_seq = vndr.vndr_seq(+)								" ).append("\n"); 
		query.append(" 	 AND so.bkg_no = th.bkg_no(+) 							" ).append("\n"); 
		query.append(" 	 AND th.tro_seq(+) = so.tro_seq	" ).append("\n"); 
		query.append("	 AND so.vndr_seq = phn_vndr_cntc.vndr_seq				" ).append("\n"); 
		query.append("	 AND phn_vndr_cntc.cntc_div_cd(+) =  'PHN'								" ).append("\n"); 
		query.append("	 AND phn_vndr_cntc.delt_flg(+) =  'N'									" ).append("\n"); 
		query.append("	 AND vndr.delt_flg <> 'Y'									" ).append("\n"); 
		query.append("	 AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	 AND so.trsp_so_seq = @[trsp_so_seq]										 				" ).append("\n"); 
		query.append("ORDER BY trucker_tel ASC" ).append("\n"); 

	}
}