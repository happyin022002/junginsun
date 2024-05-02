/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOMergeOtsDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2010.04.06 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOMergeOtsDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ....
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOMergeOtsDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_wfg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_lst_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_cfm_ofc_curr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_lst_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_ofc_curr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_frt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rsv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_ctt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_wfg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_tax_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ctt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_lst_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_rsv_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_ctt_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rsv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_lst_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lst_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_wfg_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_wfg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_wfg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_frt_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_wfg_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_usd_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_rsv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_tax_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_frt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_ctt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_frt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_frt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_frt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_rsv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_cfm_usd_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_lst_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_rsv_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ctt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_ctt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOMergeOtsDtlUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_OTS_DTL A" ).append("\n"); 
		query.append("USING ( SELECT  @[ofc_cd]                                             AS  OFC_CD" ).append("\n"); 
		query.append("               ,@[clt_bl_no]                                          AS  CLT_BL_NO" ).append("\n"); 
		query.append("               ,@[inv_no]                                             AS  INV_NO" ).append("\n"); 
		query.append("               ,@[bl_curr_cd]                                         AS  BL_CURR_CD" ).append("\n"); 
		query.append("               ,@[inv_frt_amt]                                        AS  INV_FRT_AMT" ).append("\n"); 
		query.append("               ,@[inv_wfg_amt]                                        AS  INV_WFG_AMT" ).append("\n"); 
		query.append("               ,@[inv_ctt_amt]                                        AS  INV_CTT_AMT" ).append("\n"); 
		query.append("               ,@[inv_tax_amt]                                        AS  INV_TAX_AMT" ).append("\n"); 
		query.append("               ,@[inv_rsv_amt]                                        AS  INV_RSV_AMT" ).append("\n"); 
		query.append("               ,TO_DATE(@[inv_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')    AS  INV_LST_UPD_DT" ).append("\n"); 
		query.append("               ,@[clt_frt_amt]                                        AS  CLT_FRT_AMT" ).append("\n"); 
		query.append("               ,@[clt_wfg_amt]                                        AS  CLT_WFG_AMT" ).append("\n"); 
		query.append("               ,@[clt_ctt_amt]                                        AS  CLT_CTT_AMT" ).append("\n"); 
		query.append("               ,@[clt_tax_amt]                                        AS  CLT_TAX_AMT" ).append("\n"); 
		query.append("               ,@[clt_rsv_amt]                                        AS  CLT_RSV_AMT" ).append("\n"); 
		query.append("               ,TO_DATE(@[clt_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')    AS  CLT_LST_UPD_DT" ).append("\n"); 
		query.append("               ,@[adj_frt_amt]                                        AS  ADJ_FRT_AMT" ).append("\n"); 
		query.append("               ,@[adj_wfg_amt]                                        AS  ADJ_WFG_AMT" ).append("\n"); 
		query.append("               ,@[adj_ctt_amt]                                        AS  ADJ_CTT_AMT" ).append("\n"); 
		query.append("               ,@[adj_tax_amt]                                        AS  ADJ_TAX_AMT" ).append("\n"); 
		query.append("               ,@[adj_rsv_amt]                                        AS  ADJ_RSV_AMT" ).append("\n"); 
		query.append("               ,TO_DATE(@[adj_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')    AS  ADJ_LST_UPD_DT" ).append("\n"); 
		query.append("               ,@[bal_frt_amt]                                        AS  BAL_FRT_AMT" ).append("\n"); 
		query.append("               ,@[bal_wfg_amt]                                        AS  BAL_WFG_AMT" ).append("\n"); 
		query.append("               ,@[bal_ctt_amt]                                        AS  BAL_CTT_AMT" ).append("\n"); 
		query.append("               ,@[bal_tax_amt]                                        AS  BAL_TAX_AMT" ).append("\n"); 
		query.append("               ,@[bal_rsv_amt]                                        AS  BAL_RSV_AMT" ).append("\n"); 
		query.append("               ,TO_DATE(@[bal_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')    AS  BAL_LST_UPD_DT" ).append("\n"); 
		query.append("               ,@[wrtf_amt]                                           AS  WRTF_AMT" ).append("\n"); 
		query.append("               ,TO_DATE(@[wrtf_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')   AS  WRTF_LST_UPD_DT" ).append("\n"); 
		query.append("               ,@[ppd_amt]                                            AS  PPD_AMT" ).append("\n"); 
		query.append("               ,TO_DATE(@[ppd_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')    AS  PPD_LST_UPD_DT" ).append("\n"); 
		query.append("               ,@[pre_cfm_ofc_curr_rto]                               AS  PRE_CFM_OFC_CURR_RTO" ).append("\n"); 
		query.append("               ,@[pre_cfm_usd_rto]                                    AS  PRE_CFM_USD_RTO" ).append("\n"); 
		query.append("               ,@[cfm_ofc_curr_rto]                                   AS  CFM_OFC_CURR_RTO" ).append("\n"); 
		query.append("               ,@[cfm_usd_rto]                                        AS  CFM_USD_RTO" ).append("\n"); 
		query.append("               ,@[bal_frt_ofc_curr_amt]                               AS  BAL_FRT_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,@[bal_wfg_ofc_curr_amt]                               AS  BAL_WFG_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,@[bal_ctt_ofc_curr_amt]                               AS  BAL_CTT_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,@[bal_tax_ofc_curr_amt]                               AS  BAL_TAX_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,@[bal_rsv_ofc_curr_amt]                               AS  BAL_RSV_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,@[bal_frt_usd_amt]                                    AS  BAL_FRT_USD_AMT" ).append("\n"); 
		query.append("               ,@[bal_wfg_usd_amt]                                    AS  BAL_WFG_USD_AMT" ).append("\n"); 
		query.append("               ,@[bal_ctt_usd_amt]                                    AS  BAL_CTT_USD_AMT" ).append("\n"); 
		query.append("               ,@[bal_tax_usd_amt]                                    AS  BAL_TAX_USD_AMT" ).append("\n"); 
		query.append("               ,@[bal_rsv_usd_amt]                                    AS  BAL_RSV_USD_AMT" ).append("\n"); 
		query.append("               ,sysdate                                               AS  CRE_DT" ).append("\n"); 
		query.append("               ,'BKG_ESM071'                                          AS  CRE_USR_ID" ).append("\n"); 
		query.append("               ,sysdate                                               AS  UPD_DT" ).append("\n"); 
		query.append("               ,'BKG_ESM071'					       AS UPD_USR_ID" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (A.OFC_CD = B.OFC_CD AND A.CLT_BL_NO = B.CLT_BL_NO AND A.INV_NO = B.INV_NO AND A.BL_CURR_CD = B.BL_CURR_CD )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE  SET   INV_FRT_AMT 		= B.INV_FRT_AMT" ).append("\n"); 
		query.append("             ,INV_WFG_AMT 		= B.INV_WFG_AMT" ).append("\n"); 
		query.append("             ,INV_CTT_AMT 		= B.INV_CTT_AMT" ).append("\n"); 
		query.append("             ,INV_TAX_AMT 		= B.INV_TAX_AMT" ).append("\n"); 
		query.append("             ,INV_RSV_AMT 		= B.INV_RSV_AMT" ).append("\n"); 
		query.append("             ,INV_LST_UPD_DT 		= B.INV_LST_UPD_DT" ).append("\n"); 
		query.append("             ,CLT_FRT_AMT 		= B.CLT_FRT_AMT" ).append("\n"); 
		query.append("             ,CLT_WFG_AMT 		= B.CLT_WFG_AMT" ).append("\n"); 
		query.append("             ,CLT_CTT_AMT 		= B.CLT_CTT_AMT" ).append("\n"); 
		query.append("             ,CLT_TAX_AMT 		= B.CLT_TAX_AMT" ).append("\n"); 
		query.append("             ,CLT_RSV_AMT 		= B.CLT_RSV_AMT" ).append("\n"); 
		query.append("             ,CLT_LST_UPD_DT 		= B.CLT_LST_UPD_DT" ).append("\n"); 
		query.append("             ,ADJ_FRT_AMT 		= B.ADJ_FRT_AMT" ).append("\n"); 
		query.append("             ,ADJ_WFG_AMT 		= B.ADJ_WFG_AMT" ).append("\n"); 
		query.append("             ,ADJ_CTT_AMT 		= B.ADJ_CTT_AMT" ).append("\n"); 
		query.append("             ,ADJ_TAX_AMT 		= B.ADJ_TAX_AMT" ).append("\n"); 
		query.append("             ,ADJ_RSV_AMT 		= B.ADJ_RSV_AMT" ).append("\n"); 
		query.append("             ,ADJ_LST_UPD_DT 		= B.ADJ_LST_UPD_DT" ).append("\n"); 
		query.append("             ,BAL_FRT_AMT 		= B.BAL_FRT_AMT" ).append("\n"); 
		query.append("             ,BAL_WFG_AMT 		= B.BAL_WFG_AMT" ).append("\n"); 
		query.append("             ,BAL_CTT_AMT 		= B.BAL_CTT_AMT" ).append("\n"); 
		query.append("             ,BAL_TAX_AMT 		= B.BAL_TAX_AMT" ).append("\n"); 
		query.append("             ,BAL_RSV_AMT 		= B.BAL_RSV_AMT" ).append("\n"); 
		query.append("             ,BAL_LST_UPD_DT 		= B.BAL_LST_UPD_DT" ).append("\n"); 
		query.append("             ,WRTF_AMT 			= B.WRTF_AMT" ).append("\n"); 
		query.append("             ,WRTF_LST_UPD_DT 		= B.WRTF_LST_UPD_DT" ).append("\n"); 
		query.append("             ,PPD_AMT 			= B.PPD_AMT" ).append("\n"); 
		query.append("             ,PPD_LST_UPD_DT 		= B.PPD_LST_UPD_DT" ).append("\n"); 
		query.append("             ,PRE_CFM_OFC_CURR_RTO 	= B.PRE_CFM_OFC_CURR_RTO" ).append("\n"); 
		query.append("             ,PRE_CFM_USD_RTO 		= B.PRE_CFM_USD_RTO" ).append("\n"); 
		query.append("             ,CFM_OFC_CURR_RTO 		= B.CFM_OFC_CURR_RTO" ).append("\n"); 
		query.append("             ,CFM_USD_RTO 		= B.CFM_USD_RTO" ).append("\n"); 
		query.append("             ,BAL_FRT_OFC_CURR_AMT 	= B.BAL_FRT_OFC_CURR_AMT" ).append("\n"); 
		query.append("             ,BAL_WFG_OFC_CURR_AMT 	= B.BAL_WFG_OFC_CURR_AMT" ).append("\n"); 
		query.append("             ,BAL_CTT_OFC_CURR_AMT 	= B.BAL_CTT_OFC_CURR_AMT" ).append("\n"); 
		query.append("             ,BAL_TAX_OFC_CURR_AMT 	= B.BAL_TAX_OFC_CURR_AMT" ).append("\n"); 
		query.append("             ,BAL_RSV_OFC_CURR_AMT 	= B.BAL_RSV_OFC_CURR_AMT" ).append("\n"); 
		query.append("             ,BAL_FRT_USD_AMT 		= B.BAL_FRT_USD_AMT" ).append("\n"); 
		query.append("             ,BAL_WFG_USD_AMT 		= B.BAL_WFG_USD_AMT" ).append("\n"); 
		query.append("             ,BAL_CTT_USD_AMT 		= B.BAL_CTT_USD_AMT" ).append("\n"); 
		query.append("             ,BAL_TAX_USD_AMT 		= B.BAL_TAX_USD_AMT" ).append("\n"); 
		query.append("             ,BAL_RSV_USD_AMT 		= B.BAL_RSV_USD_AMT" ).append("\n"); 
		query.append("             ,UPD_DT 			= B.UPD_DT" ).append("\n"); 
		query.append("             ,UPD_USR_ID 		= B.UPD_USR_ID   " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT VALUES ( B.OFC_CD" ).append("\n"); 
		query.append("               ,B.CLT_BL_NO" ).append("\n"); 
		query.append("               ,B.INV_NO" ).append("\n"); 
		query.append("               ,B.BL_CURR_CD" ).append("\n"); 
		query.append("               ,B.INV_FRT_AMT" ).append("\n"); 
		query.append("               ,B.INV_WFG_AMT" ).append("\n"); 
		query.append("               ,B.INV_CTT_AMT" ).append("\n"); 
		query.append("               ,B.INV_TAX_AMT" ).append("\n"); 
		query.append("               ,B.INV_RSV_AMT" ).append("\n"); 
		query.append("               ,B.INV_LST_UPD_DT" ).append("\n"); 
		query.append("               ,B.CLT_FRT_AMT" ).append("\n"); 
		query.append("               ,B.CLT_WFG_AMT" ).append("\n"); 
		query.append("               ,B.CLT_CTT_AMT" ).append("\n"); 
		query.append("               ,B.CLT_TAX_AMT" ).append("\n"); 
		query.append("               ,B.CLT_RSV_AMT" ).append("\n"); 
		query.append("               ,B.CLT_LST_UPD_DT" ).append("\n"); 
		query.append("               ,B.ADJ_FRT_AMT" ).append("\n"); 
		query.append("               ,B.ADJ_WFG_AMT" ).append("\n"); 
		query.append("               ,B.ADJ_CTT_AMT" ).append("\n"); 
		query.append("               ,B.ADJ_TAX_AMT" ).append("\n"); 
		query.append("               ,B.ADJ_RSV_AMT" ).append("\n"); 
		query.append("               ,B.ADJ_LST_UPD_DT" ).append("\n"); 
		query.append("               ,B.BAL_FRT_AMT" ).append("\n"); 
		query.append("               ,B.BAL_WFG_AMT" ).append("\n"); 
		query.append("               ,B.BAL_CTT_AMT" ).append("\n"); 
		query.append("               ,B.BAL_TAX_AMT" ).append("\n"); 
		query.append("               ,B.BAL_RSV_AMT" ).append("\n"); 
		query.append("               ,B.BAL_LST_UPD_DT" ).append("\n"); 
		query.append("               ,B.WRTF_AMT" ).append("\n"); 
		query.append("               ,B.WRTF_LST_UPD_DT" ).append("\n"); 
		query.append("               ,B.PPD_AMT" ).append("\n"); 
		query.append("               ,B.PPD_LST_UPD_DT" ).append("\n"); 
		query.append("               ,B.PRE_CFM_OFC_CURR_RTO" ).append("\n"); 
		query.append("               ,B.PRE_CFM_USD_RTO" ).append("\n"); 
		query.append("               ,B.CFM_OFC_CURR_RTO" ).append("\n"); 
		query.append("               ,B.CFM_USD_RTO" ).append("\n"); 
		query.append("               ,B.BAL_FRT_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,B.BAL_WFG_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,B.BAL_CTT_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,B.BAL_TAX_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,B.BAL_RSV_OFC_CURR_AMT" ).append("\n"); 
		query.append("               ,B.BAL_FRT_USD_AMT" ).append("\n"); 
		query.append("               ,B.BAL_WFG_USD_AMT" ).append("\n"); 
		query.append("               ,B.BAL_CTT_USD_AMT" ).append("\n"); 
		query.append("               ,B.BAL_TAX_USD_AMT" ).append("\n"); 
		query.append("               ,B.BAL_RSV_USD_AMT" ).append("\n"); 
		query.append("               ,B.CRE_DT" ).append("\n"); 
		query.append("               ,B.CRE_USR_ID" ).append("\n"); 
		query.append("               ,B.UPD_DT" ).append("\n"); 
		query.append("               ,B.UPD_USR_ID    " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}