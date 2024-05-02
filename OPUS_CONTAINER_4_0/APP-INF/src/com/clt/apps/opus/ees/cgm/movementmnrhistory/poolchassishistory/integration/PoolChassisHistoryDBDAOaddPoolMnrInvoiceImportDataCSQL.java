/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.25 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_ownr_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lbr_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_cmpo_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rpr_cmpo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_cmpo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_use_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_insp_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_cmpo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtrl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_POOL_MAINT_RPR_HIS(" ).append("\n"); 
		query.append("CHSS_NO" ).append("\n"); 
		query.append(",SYS_SEQ" ).append("\n"); 
		query.append(",CHSS_POOL_CD" ).append("\n"); 
		query.append(",VNDR_NM" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",CHSS_CMPO_NM" ).append("\n"); 
		query.append(",CHSS_LOC_NM" ).append("\n"); 
		query.append(",DMG_DESC" ).append("\n"); 
		query.append(",RPR_DESC" ).append("\n"); 
		query.append(",RPR_CMPO_QTY" ).append("\n"); 
		query.append(",RPR_HRS" ).append("\n"); 
		query.append(",RPR_INSP_TP_DESC" ).append("\n"); 
		query.append(",LBR_COST_AMT" ).append("\n"); 
		query.append(",MTRL_COST_AMT" ).append("\n"); 
		query.append(",COST_TTL_AMT" ).append("\n"); 
		query.append(",INV_CRE_DT" ).append("\n"); 
		query.append(",RPR_RQST_DT" ).append("\n"); 
		query.append(",CHSS_USE_CO_NM" ).append("\n"); 
		query.append(",ISS_OFC_NM" ).append("\n"); 
		query.append(",CHSS_OWNR_CO_NM" ).append("\n"); 
		query.append(",RESPB_PTY_NM" ).append("\n"); 
		query.append(",INV_REF_NO" ).append("\n"); 
		query.append(",SPL_CMPO_TP_CD" ).append("\n"); 
		query.append(",SPL_CMPO_QTY" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES  (" ).append("\n"); 
		query.append("@[chss_no]" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(SYS_SEQ)+1 ,1) FROM CGM_POOL_MAINT_RPR_HIS WHERE CHSS_NO = @[chss_no]  )" ).append("\n"); 
		query.append(",@[chss_pool_cd]" ).append("\n"); 
		query.append(",@[vndr_nm]" ).append("\n"); 
		query.append(",@[inv_no]" ).append("\n"); 
		query.append(",@[chss_cmpo_nm]" ).append("\n"); 
		query.append(",@[chss_loc_nm]" ).append("\n"); 
		query.append(",@[dmg_desc]" ).append("\n"); 
		query.append(",@[rpr_desc]" ).append("\n"); 
		query.append(",@[rpr_cmpo_qty]" ).append("\n"); 
		query.append(",@[rpr_hrs]" ).append("\n"); 
		query.append(",@[rpr_insp_tp_desc]" ).append("\n"); 
		query.append(",@[lbr_cost_amt]" ).append("\n"); 
		query.append(",@[mtrl_cost_amt]" ).append("\n"); 
		query.append(",@[cost_ttl_amt]" ).append("\n"); 
		query.append(",DECODE(@[inv_cre_dt],NULL,NULL,'',NULL,to_date( @[inv_cre_dt],'MM/DD/yyyy'))" ).append("\n"); 
		query.append(",DECODE(@[rpr_rqst_dt],NULL,NULL,'',NULL,to_date( @[rpr_rqst_dt],'MM/DD/yyyy'))" ).append("\n"); 
		query.append(",@[chss_use_co_nm]" ).append("\n"); 
		query.append(",@[iss_ofc_nm]" ).append("\n"); 
		query.append(",@[chss_ownr_co_nm]" ).append("\n"); 
		query.append(",@[respb_pty_nm]" ).append("\n"); 
		query.append(",@[inv_ref_no]" ).append("\n"); 
		query.append(",@[spl_cmpo_tp_cd]" ).append("\n"); 
		query.append(",@[spl_cmpo_qty]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}