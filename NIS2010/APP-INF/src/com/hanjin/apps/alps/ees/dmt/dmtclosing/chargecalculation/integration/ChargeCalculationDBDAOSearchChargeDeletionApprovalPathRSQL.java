/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDeletionApprovalPathRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.12 
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

public class ChargeCalculationDBDAOSearchChargeDeletionApprovalPathRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchChargeDeletionApprovalPathRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDeletionApprovalPathRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_delt_path_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDeletionApprovalPathRSQL").append("\n"); 
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
		query.append("SELECT  CASE" ).append("\n"); 
		query.append("			WHEN DECODE(@[chg_delt_path_cd], 'OOM', 0, 'BBG', 1, 'RHQ', 2, 'HDO', 3, -1) >= " ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT  MAX(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("					  FROM  DMT_CHG_DELT_PATH " ).append("\n"); 
		query.append("					 WHERE  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   AND  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("					   AND  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   AND  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   AND  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   AND  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("					   AND  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("					   AND  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("					   AND  (CHG_DELT_PATH_CPLS_FLG = 'Y' OR CHG_DELT_STS_CD IN ('A', 'J'))" ).append("\n"); 
		query.append("				 ) THEN 'Y'" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  DECODE(COUNT(1), 0, 'N', 'Y')" ).append("\n"); 
		query.append("				  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("				 WHERE  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				   AND  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("				   AND  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("				   AND  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("				   AND  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				   AND  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("				   AND  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("				   AND  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("				   AND  CHG_DELT_PATH_CD       = @[chg_delt_path_cd]" ).append("\n"); 
		query.append("				   AND  CHG_DELT_PATH_LVL     >= DECODE(T1.DMDT_DELT_RQST_STS_CD, 'R', 0, 'O', 0, 'P', 0, 'B', 1, 'E', 1, 'Q', 2, 'F', 2, 'H', 3, 'G', 3, 0)" ).append("\n"); 
		query.append("				   AND  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		END	" ).append("\n"); 
		query.append("  FROM  DMT_CHG_DELT_RQST_APRO  T1" ).append("\n"); 
		query.append(" WHERE  T1.SYS_AREA_GRP_ID     = @[svr_id]" ).append("\n"); 
		query.append("   AND  T1.CNTR_NO        	   = @[cntr_no]" ).append("\n"); 
		query.append("   AND  T1.CNTR_CYC_NO 		   = TO_NUMBER(@[cntr_cyc_no])" ).append("\n"); 
		query.append("   AND  T1.DMDT_TRF_CD 		   = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   AND  T1.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   AND  T1.CHG_SEQ 			   = TO_NUMBER(@[chg_seq])" ).append("\n"); 
		query.append("   AND  T1.CHG_OFC_CD 		   = @[ofc_cd]" ).append("\n"); 
		query.append("   AND  T1.DELT_SEQ 		   = TO_NUMBER(@[delt_seq])" ).append("\n"); 

	}
}