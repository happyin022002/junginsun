/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportSeacasDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.28 최민회
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

public class PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportSeacasDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportSeacasDataCSQL(){
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
		params.put("rpr_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tax_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_cmpl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chss_aspt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportSeacasDataCSQL").append("\n"); 
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
		query.append(",VNDR_NM" ).append("\n"); 
		query.append(",VNDR_LOC_NM" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",CHSS_ASPT_NM" ).append("\n"); 
		query.append(",CHSS_CMPO_NM" ).append("\n"); 
		query.append(",CHSS_LOC_NM" ).append("\n"); 
		query.append(",DMG_DESC" ).append("\n"); 
		query.append(",RPR_DESC" ).append("\n"); 
		query.append(",LBR_COST_AMT" ).append("\n"); 
		query.append(",MTRL_COST_AMT" ).append("\n"); 
		query.append(",TAX_AMT" ).append("\n"); 
		query.append(",COST_TTL_AMT" ).append("\n"); 
		query.append(",INV_CRE_DT" ).append("\n"); 
		query.append(",RPR_RQST_DT" ).append("\n"); 
		query.append(",RPR_CMPL_DT" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CHSS_OWNR_CO_NM" ).append("\n"); 
		query.append(",INV_REF_NO" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES  (" ).append("\n"); 
		query.append("@[chss_no]" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(SYS_SEQ)+1 ,1) FROM CGM_POOL_MAINT_RPR_HIS WHERE CHSS_NO = @[chss_no]  )" ).append("\n"); 
		query.append(",@[vndr_nm]" ).append("\n"); 
		query.append(",@[vndr_loc_nm]" ).append("\n"); 
		query.append(",@[inv_no]" ).append("\n"); 
		query.append(",@[chss_aspt_nm]" ).append("\n"); 
		query.append(",@[chss_cmpo_nm]" ).append("\n"); 
		query.append(",@[chss_loc_nm]" ).append("\n"); 
		query.append(",@[dmg_desc]" ).append("\n"); 
		query.append(",@[rpr_desc]" ).append("\n"); 
		query.append(",@[lbr_cost_amt]" ).append("\n"); 
		query.append(",@[mtrl_cost_amt]" ).append("\n"); 
		query.append(",@[tax_amt]" ).append("\n"); 
		query.append(",@[cost_ttl_amt]" ).append("\n"); 
		query.append(",DECODE(@[inv_cre_dt],NULL,'',to_date( @[inv_cre_dt],  'DD/MON/yyyy', 'NLS_DATE_LANGUAGE = American'))" ).append("\n"); 
		query.append(",DECODE(@[rpr_rqst_dt],NULL,'',to_date( @[rpr_rqst_dt],  'DD/MON/yy', 'NLS_DATE_LANGUAGE = American'))" ).append("\n"); 
		query.append(",DECODE(@[rpr_cmpl_dt],NULL,'',to_date( @[rpr_cmpl_dt],  'DD/MON/yy', 'NLS_DATE_LANGUAGE = American'))" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",@[chss_ownr_co_nm]" ).append("\n"); 
		query.append(",@[inv_ref_no]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}