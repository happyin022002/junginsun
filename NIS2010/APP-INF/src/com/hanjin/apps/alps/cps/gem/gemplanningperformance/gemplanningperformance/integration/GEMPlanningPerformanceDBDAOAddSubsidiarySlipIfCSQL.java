/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOAddSubsidiarySlipIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOAddSubsidiarySlipIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.04.09 [CHM-201217079-01] 이준범
	  * 1.subsidiary Slip Upload  신규 기능 추가
	  *   : GEM_SLP_IF 저장 SQL
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOAddSubsidiarySlipIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_splr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prpr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_shop_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tj_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_crd_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subs_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_splr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOAddSubsidiarySlipIfCSQL").append("\n"); 
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
		query.append("INSERT INTO GEM_SLP_IF " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SLP_TJ_NO" ).append("\n"); 
		query.append(" ,SLP_SEQ_NO" ).append("\n"); 
		query.append(" ,SYS_CATE_NM" ).append("\n"); 
		query.append(" ,GL_EFF_DT" ).append("\n"); 
		query.append(" ,SUBS_ACCT_CD" ).append("\n"); 
		query.append(" ,SLP_CURR_CD" ).append("\n"); 
		query.append(" ,SLP_AMT" ).append("\n"); 
		query.append(" ,SLP_CTR_CD" ).append("\n"); 
		query.append(" ,SLP_DESC" ).append("\n"); 
		query.append(" ,OFC_CD" ).append("\n"); 
		query.append(" ,SLP_VNDR_CD" ).append("\n"); 
		query.append(" ,PRPR_USR_ID" ).append("\n"); 
		query.append(" ,APRO_USR_ID" ).append("\n"); 
		query.append(" ,SLP_IF_FLG" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(" ,SLP_SPLR_CD" ).append("\n"); 
		query.append(" ,SLP_SPLR_NM" ).append("\n"); 
		query.append(" ,CR_CRD_USR_NM " ).append("\n"); 
		query.append(" ,CRD_SHOP_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("  @[slp_tj_no]" ).append("\n"); 
		query.append(" ,SUBSTR(@[slp_seq_no] + 10000,2,5)" ).append("\n"); 
		query.append(" ,'Subsidiary'" ).append("\n"); 
		query.append(" ,SUBSTR(@[gl_eff_dt],1,8)" ).append("\n"); 
		query.append(" ,@[subs_acct_cd]" ).append("\n"); 
		query.append(" ,@[slp_curr_cd]" ).append("\n"); 
		query.append(" ,@[slp_amt]" ).append("\n"); 
		query.append(" ,@[slp_ctr_cd]" ).append("\n"); 
		query.append(" ,@[slp_desc]" ).append("\n"); 
		query.append(" ,@[ofc_cd]" ).append("\n"); 
		query.append(" ,@[slp_vndr_cd]" ).append("\n"); 
		query.append(" ,@[prpr_usr_id]" ).append("\n"); 
		query.append(" ,@[apro_usr_id]" ).append("\n"); 
		query.append(" ,@[slp_if_flg]" ).append("\n"); 
		query.append(" ,@[cre_usr_id]" ).append("\n"); 
		query.append(" ,sysdate" ).append("\n"); 
		query.append(" ,@[upd_usr_id]" ).append("\n"); 
		query.append(" ,sysdate" ).append("\n"); 
		query.append(" ,@[slp_splr_cd]" ).append("\n"); 
		query.append(" ,@[slp_splr_nm]" ).append("\n"); 
		query.append(" ,@[cr_crd_usr_nm]" ).append("\n"); 
		query.append(" ,@[crd_shop_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}