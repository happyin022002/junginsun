/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOAddChgDeltRqstAproCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOAddChgDeltRqstAproCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOAddChgDeltRqstAproCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOAddChgDeltRqstAproCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_chg_delt_spec_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inact_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_delt_rqst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_delt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_spec_rsn_rmk_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inact_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_area_grp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOAddChgDeltRqstAproCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	   ,CNTR_NO" ).append("\n"); 
		query.append("	   ,CNTR_CYC_NO" ).append("\n"); 
		query.append("	   ,DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	   ,CHG_SEQ" ).append("\n"); 
		query.append("	   ,CHG_OFC_CD" ).append("\n"); 
		query.append("	   ,DELT_SEQ" ).append("\n"); 
		query.append("	   ,DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("	   ,RQST_USR_ID" ).append("\n"); 
		query.append("	   ,RQST_DT" ).append("\n"); 
		query.append("	   ,RQST_OFC_CD" ).append("\n"); 
		query.append("	   ,APRO_USR_ID" ).append("\n"); 
		query.append("	   ,APRO_DT" ).append("\n"); 
		query.append("	   ,APRO_OFC_CD" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("	   ,UPD_OFC_CD" ).append("\n"); 
		query.append("	   ,DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("	   ,DELT_RMK" ).append("\n"); 
		query.append("	   ,DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append("	   ,DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append("	   ,INACT_APRO_NO" ).append("\n"); 
		query.append("	   ,INACT_RQST_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		@[sys_area_grp_id]" ).append("\n"); 
		query.append("	   ,@[cntr_no]" ).append("\n"); 
		query.append("	   ,@[cntr_cyc_no]" ).append("\n"); 
		query.append("	   ,@[dmdt_trf_cd]" ).append("\n"); 
		query.append("	   ,@[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("	   ,@[chg_seq]" ).append("\n"); 
		query.append("	   ,@[ofc_cd]" ).append("\n"); 
		query.append("	   ,@[delt_seq]" ).append("\n"); 
		query.append("	   ,@[dmdt_delt_rqst_sts_cd]" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	   ,@[apro_usr_id]" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,@[apro_ofc_cd]" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	   ,@[dmdt_chg_delt_rsn_cd]" ).append("\n"); 
		query.append("	   ,@[delt_rmk]" ).append("\n"); 
		query.append("	   ,@[dmdt_chg_delt_spec_rsn_cd]" ).append("\n"); 
		query.append("	   ,@[delt_spec_rsn_rmk_seq]" ).append("\n"); 
		query.append("	   ,@[inact_apro_no]" ).append("\n"); 
		query.append("	   ,@[inact_rqst_no]" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}