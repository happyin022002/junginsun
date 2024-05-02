/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297ShHeadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi102297ShHeadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_102297_SH_HEAD
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297ShHeadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297ShHeadRSQL").append("\n"); 
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
		query.append("SELECT 	  NVL(wo.trsp_wo_ofc_cty_cd||LPAD(wo.trsp_wo_seq, 17, '0'),@[trsp_wo_ofc_cty_cd]||LPAD(@[trsp_wo_seq], 17, '0')) AS wo_no" ).append("\n"); 
		query.append("      	 ,DECODE(so.trsp_cost_dtl_mod_cd, 'TS', 'T','L') local_ts" ).append("\n"); 
		query.append("      	 ,DECODE (wo.wo_iss_sts_cd,'I','C','R','U','C','U','N','X') purpose" ).append("\n"); 
		query.append("      	 ,TO_CHAR(wo.locl_upd_dt, 'YYYYMMDDHH24MI') snd_dt" ).append("\n"); 
		query.append("      	 ,'Hanjin Transportation (PUS Brandch)' receiver" ).append("\n"); 
		query.append("      	 ,usr.usr_nm	sender" ).append("\n"); 
		query.append("    	 ,usr.xtn_phn_no tel_no" ).append("\n"); 
		query.append("    	 ,'' pickup_dt" ).append("\n"); 
		query.append("    	 ,so.fm_nod_cd pickup_cy" ).append("\n"); 
		query.append("    	 ,yd.yd_nm pickup_cy_nm" ).append("\n"); 
		query.append("    	 ,DECODE(so.trsp_cost_dtl_mod_cd,'TS', so.ib_vvd_cd,'') in_vvd" ).append("\n"); 
		query.append("    	 ,SUM(DECODE(SUBSTR(so.eq_tpsz_cd,2,1),'2',1,0)) qty_teu_t" ).append("\n"); 
		query.append("    	 ,SUM(DECODE(SUBSTR(so.eq_tpsz_cd,2,1),'2',0,1)) qty_feu_t" ).append("\n"); 
		query.append("    	 ,so.curr_cd amt_cur" ).append("\n"); 
		query.append("    	 ,SUM(NVL(so.bzc_amt,0)+NVL(so.nego_amt,0)+NVL(so.etc_add_amt,0)+NVL(so.toll_fee_amt,0)) amt_t" ).append("\n"); 
		query.append("    	 ,'' ins" ).append("\n"); 
		query.append("    	 ,wo.wo_rmk rmk" ).append("\n"); 
		query.append("	 FROM com_user usr" ).append("\n"); 
		query.append("    	 ,mdm_yard yd" ).append("\n"); 
		query.append("    	 ,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("    	 ,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("    WHERE so.delt_flg <> 'Y'	            " ).append("\n"); 
		query.append("	  AND wo.trsp_wo_ofc_cty_cd	= @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("	  AND wo.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("	  AND wo.trsp_wo_ofc_cty_cd	= so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("	  AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("	  AND wo.cre_usr_id	= usr.usr_id" ).append("\n"); 
		query.append("	  AND so.fm_nod_cd = yd.yd_cd      " ).append("\n"); 
		query.append("	  AND so.trsp_cost_dtl_mod_cd IN ('LS','TS','CY')" ).append("\n"); 
		query.append("	  AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("	  AND wo.hjl_no IS NULL      															" ).append("\n"); 
		query.append(" GROUP BY wo.trsp_wo_ofc_cty_cd||LPAD(wo.trsp_wo_seq, 17, '0')" ).append("\n"); 
		query.append("		 ,so.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("		 ,wo.wo_iss_sts_cd" ).append("\n"); 
		query.append("		 ,wo.locl_upd_dt" ).append("\n"); 
		query.append("		 ,usr.usr_nm" ).append("\n"); 
		query.append("		 ,usr.xtn_phn_no" ).append("\n"); 
		query.append("		 ,so.fm_nod_cd" ).append("\n"); 
		query.append("		 ,yd.yd_nm" ).append("\n"); 
		query.append("		 ,DECODE(so.trsp_cost_dtl_mod_cd,'TS', SO.IB_VVD_CD	,'')" ).append("\n"); 
		query.append("		 ,so.curr_cd" ).append("\n"); 
		query.append("		 ,wo.wo_rmk" ).append("\n"); 

	}
}