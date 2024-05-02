/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOAddChgDeltCngHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.21 
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

public class ChargeCalculationDBDAOAddChgDeltCngHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOAddChgDeltCngHisCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOAddChgDeltCngHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOAddChgDeltCngHisCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_CHG_DELT_CNG_HIS" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	   ,CNTR_NO" ).append("\n"); 
		query.append("	   ,CNTR_CYC_NO" ).append("\n"); 
		query.append("	   ,DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	   ,CHG_SEQ" ).append("\n"); 
		query.append("	   ,CHG_OFC_CD" ).append("\n"); 
		query.append("	   ,DELT_SEQ" ).append("\n"); 
		query.append("	   ,DELT_CNG_HIS_SEQ" ).append("\n"); 
		query.append("	   ,CHG_DELT_PATH_CD" ).append("\n"); 
		query.append("	   ,CHG_DELT_USR_ID" ).append("\n"); 
		query.append("	   ,CHG_DELT_STS_CD" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("	   ,UPD_OFC_CD" ).append("\n"); 
		query.append("	   ,INACT_RMK" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT  T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	   ,T1.CNTR_NO" ).append("\n"); 
		query.append("	   ,T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("	   ,T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	   ,T1.CHG_SEQ" ).append("\n"); 
		query.append("	   ,T1.CHG_OFC_CD" ).append("\n"); 
		query.append("	   ,T1.DELT_SEQ" ).append("\n"); 
		query.append("       ,ROWNUM AS DELT_CNG_HIS_SEQ" ).append("\n"); 
		query.append("       ,T2.CHG_DELT_PATH_CD" ).append("\n"); 
		query.append("       ,T2.CHG_DELT_USR_ID" ).append("\n"); 
		query.append("	   ,T2.CHG_DELT_STS_CD" ).append("\n"); 
		query.append("	   ,T2.CRE_USR_ID" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,T2.CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,T2.CRE_USR_ID" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,T2.CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,T1.DELT_RMK" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  DMT_CHG_DELT_RQST_APRO  T1" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  0 				AS CHG_DELT_PATH_LVL" ).append("\n"); 
		query.append("			       ,'RQT'			AS CHG_DELT_PATH_CD" ).append("\n"); 
		query.append("				   ,'R'				AS CHG_DELT_STS_CD" ).append("\n"); 
		query.append("				   ,@[cre_usr_id]	AS CHG_DELT_USR_ID" ).append("\n"); 
		query.append("				   ,@[cre_usr_id]	AS CRE_USR_ID" ).append("\n"); 
		query.append("				   ,@[cre_ofc_cd]	AS CRE_OFC_CD" ).append("\n"); 
		query.append("			  FROM  DUAL" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("            SELECT  1    			AS CHG_DELT_PATH_LVL" ).append("\n"); 
		query.append("			       ,'BBG' 			AS CHG_DELT_PATH_CD" ).append("\n"); 
		query.append("				   ,'A'				AS CHG_DELT_STS_CD" ).append("\n"); 
		query.append("				   ,@[cre_usr_id]	AS CHG_DELT_USR_ID" ).append("\n"); 
		query.append("				   ,@[cre_usr_id]	AS CRE_USR_ID" ).append("\n"); 
		query.append("				   ,@[cre_ofc_cd]	AS CRE_OFC_CD" ).append("\n"); 
		query.append("			  FROM  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append("			 WHERE  EXISTS" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  1" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_OFC_STUP" ).append("\n"); 
		query.append("						 WHERE  CHG_DELT_PATH_STUP_SEQ = T1.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("						   AND  CHG_DELT_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   AND  (T1.EFF_DT <= SYSDATE AND (T1.EXP_DT IS NULL OR T1.EXP_DT >= SYSDATE))" ).append("\n"); 
		query.append("			   AND  T1.DMDT_BRNC_FLG = 'Y'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT  2    			AS CHG_DELT_PATH_LVL" ).append("\n"); 
		query.append("			       ,'RHQ' 			AS CHG_DELT_PATH_CD" ).append("\n"); 
		query.append("				   ,'A'				AS CHG_DELT_STS_CD" ).append("\n"); 
		query.append("				   ,@[cre_usr_id]	AS CHG_DELT_USR_ID" ).append("\n"); 
		query.append("				   ,@[cre_usr_id]	AS CRE_USR_ID" ).append("\n"); 
		query.append("				   ,@[cre_ofc_cd]	AS CRE_OFC_CD" ).append("\n"); 
		query.append("			  FROM  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append("			 WHERE  EXISTS" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  1" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_OFC_STUP" ).append("\n"); 
		query.append("						 WHERE  CHG_DELT_PATH_STUP_SEQ = T1.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("						   AND  CHG_DELT_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   AND  (T1.EFF_DT <= SYSDATE AND (T1.EXP_DT IS NULL OR T1.EXP_DT >= SYSDATE))" ).append("\n"); 
		query.append("               AND  T1.DMDT_RHQ_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			SELECT  3    			AS CHG_DELT_PATH_LVL" ).append("\n"); 
		query.append("			       ,'HDO' 			AS CHG_DELT_PATH_CD" ).append("\n"); 
		query.append("				   ,'A'				AS CHG_DELT_STS_CD" ).append("\n"); 
		query.append("				   ,@[apro_usr_id]	AS CHG_DELT_USR_ID" ).append("\n"); 
		query.append("				   ,@[apro_usr_id]	AS CRE_USR_ID" ).append("\n"); 
		query.append("				   ,@[apro_ofc_cd]	AS CRE_OFC_CD" ).append("\n"); 
		query.append("			  FROM  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append("			 WHERE  EXISTS" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  1" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_OFC_STUP" ).append("\n"); 
		query.append("						 WHERE  CHG_DELT_PATH_STUP_SEQ = T1.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("						   AND  CHG_DELT_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   AND  (T1.EFF_DT <= SYSDATE AND (T1.EXP_DT IS NULL OR T1.EXP_DT >= SYSDATE)) " ).append("\n"); 
		query.append("               AND  T1.DMDT_BRNC_FLG = 'Y'" ).append("\n"); 
		query.append("        ) T2" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append(" WHERE  T1.SYS_AREA_GRP_ID     = @[sys_area_grp_id]" ).append("\n"); 
		query.append("   AND  T1.CNTR_NO             = @[cntr_no]" ).append("\n"); 
		query.append("   AND  T1.CNTR_CYC_NO         = @[cntr_cyc_no]" ).append("\n"); 
		query.append("   AND  T1.DMDT_TRF_CD         = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   AND  T1.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   AND  T1.CHG_SEQ             = @[chg_seq]" ).append("\n"); 
		query.append("   AND  T1.CHG_OFC_CD          = @[ofc_cd]" ).append("\n"); 
		query.append("   AND  T1.DELT_SEQ            = @[delt_seq]" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("ORDER BY T2.CHG_DELT_PATH_LVL" ).append("\n"); 

	}
}