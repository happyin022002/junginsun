/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOAddOtsDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.03.29 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOAddOtsDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOAddOtsDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_ofc_curr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_frt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_ctt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_wfg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_tax_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_rsv_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_ctt_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_wfg_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_wfg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_wfg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_frt_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_wfg_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_usd_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_rsv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_tax_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_frt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_ctt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_frt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_frt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_frt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_rsv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_rsv_ofc_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ctt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_ctt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOAddOtsDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_OTS_DTL (" ).append("\n"); 
		query.append("	OFC_CD" ).append("\n"); 
		query.append(",	CLT_BL_NO" ).append("\n"); 
		query.append(",	INV_NO" ).append("\n"); 
		query.append(",	BL_CURR_CD" ).append("\n"); 
		query.append(",	INV_FRT_AMT" ).append("\n"); 
		query.append(",	INV_WFG_AMT" ).append("\n"); 
		query.append(",	INV_CTT_AMT" ).append("\n"); 
		query.append(",	INV_TAX_AMT" ).append("\n"); 
		query.append(",	INV_RSV_AMT" ).append("\n"); 
		query.append(",	INV_LST_UPD_DT" ).append("\n"); 
		query.append(",	CLT_FRT_AMT" ).append("\n"); 
		query.append(",	CLT_WFG_AMT" ).append("\n"); 
		query.append(",	CLT_CTT_AMT" ).append("\n"); 
		query.append(",	CLT_TAX_AMT" ).append("\n"); 
		query.append(",	CLT_RSV_AMT" ).append("\n"); 
		query.append(",	CLT_LST_UPD_DT" ).append("\n"); 
		query.append(",	ADJ_FRT_AMT" ).append("\n"); 
		query.append(",	ADJ_WFG_AMT" ).append("\n"); 
		query.append(",	ADJ_CTT_AMT" ).append("\n"); 
		query.append(",	ADJ_TAX_AMT" ).append("\n"); 
		query.append(",	ADJ_RSV_AMT" ).append("\n"); 
		query.append(",	ADJ_LST_UPD_DT" ).append("\n"); 
		query.append(",	BAL_FRT_AMT" ).append("\n"); 
		query.append(",	BAL_WFG_AMT" ).append("\n"); 
		query.append(",	BAL_CTT_AMT" ).append("\n"); 
		query.append(",	BAL_TAX_AMT" ).append("\n"); 
		query.append(",	BAL_RSV_AMT" ).append("\n"); 
		query.append(",	BAL_LST_UPD_DT" ).append("\n"); 
		query.append(",	WRTF_AMT" ).append("\n"); 
		query.append(",	WRTF_LST_UPD_DT" ).append("\n"); 
		query.append(",	PPD_AMT" ).append("\n"); 
		query.append(",	PPD_LST_UPD_DT" ).append("\n"); 
		query.append(",	PRE_CFM_OFC_CURR_RTO" ).append("\n"); 
		query.append(",	PRE_CFM_USD_RTO" ).append("\n"); 
		query.append(",	CFM_OFC_CURR_RTO" ).append("\n"); 
		query.append(",	CFM_USD_RTO" ).append("\n"); 
		query.append(",	BAL_FRT_OFC_CURR_AMT" ).append("\n"); 
		query.append(",	BAL_WFG_OFC_CURR_AMT" ).append("\n"); 
		query.append(",	BAL_CTT_OFC_CURR_AMT" ).append("\n"); 
		query.append(",	BAL_TAX_OFC_CURR_AMT" ).append("\n"); 
		query.append(",	BAL_RSV_OFC_CURR_AMT" ).append("\n"); 
		query.append(",	BAL_FRT_USD_AMT" ).append("\n"); 
		query.append(",	BAL_WFG_USD_AMT" ).append("\n"); 
		query.append(",	BAL_CTT_USD_AMT" ).append("\n"); 
		query.append(",	BAL_TAX_USD_AMT" ).append("\n"); 
		query.append(",	BAL_RSV_USD_AMT" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("	@[ofc_cd]" ).append("\n"); 
		query.append(",	@[clt_bl_no]" ).append("\n"); 
		query.append(",	@[inv_no]" ).append("\n"); 
		query.append(",	@[bl_curr_cd]" ).append("\n"); 
		query.append(",	@[inv_frt_amt]" ).append("\n"); 
		query.append(",	@[inv_wfg_amt]" ).append("\n"); 
		query.append(",	@[inv_ctt_amt]" ).append("\n"); 
		query.append(",	@[inv_tax_amt]" ).append("\n"); 
		query.append(",	@[inv_rsv_amt]" ).append("\n"); 
		query.append(",	TO_DATE(@[inv_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[clt_frt_amt]" ).append("\n"); 
		query.append(",	@[clt_wfg_amt]" ).append("\n"); 
		query.append(",	@[clt_ctt_amt]" ).append("\n"); 
		query.append(",	@[clt_tax_amt]" ).append("\n"); 
		query.append(",	@[clt_rsv_amt]" ).append("\n"); 
		query.append(",	TO_DATE(@[clt_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[adj_frt_amt]" ).append("\n"); 
		query.append(",	@[adj_wfg_amt]" ).append("\n"); 
		query.append(",	@[adj_ctt_amt]" ).append("\n"); 
		query.append(",	@[adj_tax_amt]" ).append("\n"); 
		query.append(",	@[adj_rsv_amt]" ).append("\n"); 
		query.append(",	TO_DATE(@[adj_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[bal_frt_amt]" ).append("\n"); 
		query.append(",	@[bal_wfg_amt]" ).append("\n"); 
		query.append(",	@[bal_ctt_amt]" ).append("\n"); 
		query.append(",	@[bal_tax_amt]" ).append("\n"); 
		query.append(",	@[bal_rsv_amt]" ).append("\n"); 
		query.append(",	TO_DATE(@[bal_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[wrtf_amt]" ).append("\n"); 
		query.append(",	TO_DATE(@[wrtf_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[ppd_amt]" ).append("\n"); 
		query.append(",	TO_DATE(@[ppd_lst_upd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[pre_cfm_ofc_curr_rto]" ).append("\n"); 
		query.append(",	@[pre_cfm_usd_rto]" ).append("\n"); 
		query.append(",	@[cfm_ofc_curr_rto]" ).append("\n"); 
		query.append(",	@[cfm_usd_rto]" ).append("\n"); 
		query.append(",	@[bal_frt_ofc_curr_amt]" ).append("\n"); 
		query.append(",	@[bal_wfg_ofc_curr_amt]" ).append("\n"); 
		query.append(",	@[bal_ctt_ofc_curr_amt]" ).append("\n"); 
		query.append(",	@[bal_tax_ofc_curr_amt]" ).append("\n"); 
		query.append(",	@[bal_rsv_ofc_curr_amt]" ).append("\n"); 
		query.append(",	@[bal_frt_usd_amt]" ).append("\n"); 
		query.append(",	@[bal_wfg_usd_amt]" ).append("\n"); 
		query.append(",	@[bal_ctt_usd_amt]" ).append("\n"); 
		query.append(",	@[bal_tax_usd_amt]" ).append("\n"); 
		query.append(",	@[bal_rsv_usd_amt]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	'BKG_ESM071'" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	'BKG_ESM071'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}