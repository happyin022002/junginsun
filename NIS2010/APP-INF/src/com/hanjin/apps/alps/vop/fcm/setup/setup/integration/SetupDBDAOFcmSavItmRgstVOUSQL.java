/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SetupDBDAOFcmSavItmRgstVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.04 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SetupDBDAOFcmSavItmRgstVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Saving Item Registration 정보를 변경합니다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * </pre>
	  */
	public SetupDBDAOFcmSavItmRgstVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itm_ut_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_var_dgr_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_cons_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_var_dgr_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_csm_sub_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_coef_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itm_csm_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_coef_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("itm_trnd_line_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.setup.setup.integration").append("\n"); 
		query.append("FileName : SetupDBDAOFcmSavItmRgstVOUSQL").append("\n"); 
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
		query.append("MERGE INTO FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("USING DUAL ON(SAV_ITM_CD = @[sav_itm_cd] AND SAV_CSM_SUB_ITM_CD = @[sav_csm_sub_itm_cd] AND CNTR_VSL_CLSS_CAPA = @[cntr_vsl_clss_capa] AND ITM_TRND_LINE_CD = @[itm_trnd_line_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET                                                         " ).append("\n"); 
		query.append("	  ITM_CSM_RTO               = @[itm_csm_rto]  " ).append("\n"); 
		query.append("     ,VSL_CLSS_SUB_CD           = @[vsl_clss_sub_cd]" ).append("\n"); 
		query.append("	 ,ITM_UT_PRC                = @[itm_ut_prc]           " ).append("\n"); 
		query.append("	 ,TRND_LINE_SEQ             = @[trnd_line_seq]       " ).append("\n"); 
		query.append("     ,TRND_LINE_NO              = @[trnd_line_no]" ).append("\n"); 
		query.append("	 ,N1ST_COEF_VAL             = @[n1st_coef_val]       " ).append("\n"); 
		query.append("	 ,N1ST_VAR_DGR_VAL          = @[n1st_var_dgr_val]    " ).append("\n"); 
		query.append("	 ,N2ND_COEF_VAL             = @[n2nd_coef_val]       " ).append("\n"); 
		query.append("	 ,N2ND_VAR_DGR_VAL          = @[n2nd_var_dgr_val]    " ).append("\n"); 
		query.append("	 ,TRND_LINE_CONS_VAL                  = @[trnd_line_cons_val]            " ).append("\n"); 
		query.append("	 ,UPD_USR_ID                = @[upd_usr_id]" ).append("\n"); 
		query.append("	 ,UPD_DT                    = SYSDATE" ).append("\n"); 
		query.append("	WHERE SAV_ITM_CD = @[sav_itm_cd] " ).append("\n"); 
		query.append("      AND SAV_CSM_SUB_ITM_CD = @[sav_csm_sub_itm_cd] " ).append("\n"); 
		query.append("      AND CNTR_VSL_CLSS_CAPA = @[cntr_vsl_clss_capa] " ).append("\n"); 
		query.append("      AND ITM_TRND_LINE_CD = @[itm_trnd_line_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT(" ).append("\n"); 
		query.append("	  SAV_ITM_CD" ).append("\n"); 
		query.append("	 ,VSL_CLSS_SUB_CD" ).append("\n"); 
		query.append("	 ,SAV_CSM_SUB_ITM_CD" ).append("\n"); 
		query.append("	 ,ITM_NM" ).append("\n"); 
		query.append("	 ,ITM_CSM_RTO" ).append("\n"); 
		query.append("	 ,ITM_UT_PRC" ).append("\n"); 
		query.append("	 ,CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("	 ,ITM_TRND_LINE_CD" ).append("\n"); 
		query.append("	 ,TRND_LINE_SEQ" ).append("\n"); 
		query.append("     ,TRND_LINE_NO" ).append("\n"); 
		query.append("	 ,N1ST_COEF_VAL" ).append("\n"); 
		query.append("	 ,N1ST_VAR_DGR_VAL" ).append("\n"); 
		query.append("	 ,N2ND_COEF_VAL" ).append("\n"); 
		query.append("	 ,N2ND_VAR_DGR_VAL" ).append("\n"); 
		query.append("	 ,TRND_LINE_CONS_VAL" ).append("\n"); 
		query.append("	 ,CRE_USR_ID" ).append("\n"); 
		query.append("	 ,CRE_DT" ).append("\n"); 
		query.append("	 ,UPD_USR_ID" ).append("\n"); 
		query.append("	 ,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("		 @[sav_itm_cd]" ).append("\n"); 
		query.append("        ,@[vsl_clss_sub_cd]" ).append("\n"); 
		query.append("	 	,@[sav_csm_sub_itm_cd]" ).append("\n"); 
		query.append("	 	,@[itm_nm]" ).append("\n"); 
		query.append("	 	,@[itm_csm_rto]" ).append("\n"); 
		query.append("	 	,@[itm_ut_prc]" ).append("\n"); 
		query.append("	 	,@[cntr_vsl_clss_capa]" ).append("\n"); 
		query.append("	 	,@[itm_trnd_line_cd]" ).append("\n"); 
		query.append("	 	,@[trnd_line_seq]" ).append("\n"); 
		query.append("        ,@[trnd_line_no]" ).append("\n"); 
		query.append("	 	,@[n1st_coef_val]" ).append("\n"); 
		query.append("	 	,@[n1st_var_dgr_val]" ).append("\n"); 
		query.append("	 	,@[n2nd_coef_val]" ).append("\n"); 
		query.append("	 	,@[n2nd_var_dgr_val]" ).append("\n"); 
		query.append("	 	,@[trnd_line_cons_val]" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[upd_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}