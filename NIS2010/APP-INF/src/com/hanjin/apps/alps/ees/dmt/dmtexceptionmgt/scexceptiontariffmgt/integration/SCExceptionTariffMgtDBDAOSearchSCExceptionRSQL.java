/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchSCExceptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.12.20 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchSCExceptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C 별 DEM/DET 등록된 특별 계약 내용을 조회
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchSCExceptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchSCExceptionRSQL").append("\n"); 
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
		query.append("SELECT  NEW.PROP_NO" ).append("\n"); 
		query.append("       ,NEW.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("       ,NEW.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("       ,NEW.DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,NEW.EFF_DT" ).append("\n"); 
		query.append("       ,NEW.EXP_DT" ).append("\n"); 
		query.append("       ,NEW.DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("       ,NEW.CVRG_MULTI" ).append("\n"); 
		query.append("       ,NEW.CURR_CVRG_MULTI" ).append("\n"); 
		query.append("       ,NEW.CVRG_SEQ" ).append("\n"); 
		query.append("       ,NEW.CNT_CD" ).append("\n"); 
		query.append("       ,NEW.RGN_CD" ).append("\n"); 
		query.append("       ,NEW.STE_CD" ).append("\n"); 
		query.append("       ,NEW.LOC_CD" ).append("\n"); 
		query.append("       ,NEW.FT_FLG" ).append("\n"); 
		query.append("       ,NEW.FT_TIR" ).append("\n"); 
		query.append("       ,NEW.FT_ADD_DYS" ).append("\n"); 
		query.append("       ,NEW.FT_TOT_DYS" ).append("\n"); 
		query.append("       ,NEW.XCLD_SAT_FLG" ).append("\n"); 
		query.append("       ,NEW.XCLD_SUN_FLG" ).append("\n"); 
		query.append("       ,NEW.XCLD_HOL_FLG" ).append("\n"); 
		query.append("       ,NEW.SC_EXPT_FM_CONTI_CD" ).append("\n"); 
		query.append("       ,NEW.SC_EXPT_FM_CNT_CD" ).append("\n"); 
		query.append("       ,NEW.SC_EXPT_FM_RGN_CD" ).append("\n"); 
		query.append("       ,NEW.SC_EXPT_FM_STE_CD" ).append("\n"); 
		query.append("       ,NEW.SC_EXPT_FM_LOC_CD" ).append("\n"); 
		query.append("       ,NEW.FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("       ,NEW.FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("       ,NEW.FNL_DEST_STE_CD" ).append("\n"); 
		query.append("       ,NEW.FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("       ,NEW.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("       ,NEW.EXPT_TRF_RMK" ).append("\n"); 
		query.append("       ,NEW.FULL_EXPT_TRF_RMK" ).append("\n"); 
		query.append("       ,NEW.CURR_CD" ).append("\n"); 
		query.append("       ,NEW.RT_CHK_FLG" ).append("\n"); 
		query.append("       ,NEW.RT_CHK" ).append("\n"); 
		query.append("       ,DECODE(OLD.SC_EXPT_GRP_SEQ, null, 'Y','N') AS NEW_FLG" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("        (   SELECT 	A.PROP_NO" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                   ,A.DMDT_TRF_CD" ).append("\n"); 
		query.append("                   ,TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("                   ,TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("                   ,A.DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("                   ,B.CVRG_MULTI" ).append("\n"); 
		query.append("                   ,B.CVRG_MULTI AS CURR_CVRG_MULTI" ).append("\n"); 
		query.append("                   ,B.CVRG_SEQ" ).append("\n"); 
		query.append("                   ,B.CNT_CD" ).append("\n"); 
		query.append("                   ,B.RGN_CD" ).append("\n"); 
		query.append("                   ,B.STE_CD" ).append("\n"); 
		query.append("                   ,B.LOC_CD" ).append("\n"); 
		query.append("                   ,DECODE(A.FT_FLG, 'Y', '1', '0') AS FT_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.FT_ADJ_FLG, 'Y', 'M', DECODE(A.FT_FLG, 'Y', 'S', '')) AS FT_TIR" ).append("\n"); 
		query.append("                   ,CASE WHEN A.FT_FLG = 'Y' AND A.FT_ADD_FLG = 'Y' THEN A.FT_ADD_DYS END AS FT_ADD_DYS" ).append("\n"); 
		query.append("                   ,CASE WHEN A.FT_FLG = 'Y' AND A.FT_ADD_FLG = 'N' THEN A.FT_ADD_DYS END AS FT_TOT_DYS" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_SAT_FLG, 'Y', '1', '0') AS XCLD_SAT_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_SUN_FLG, 'Y', '1', '0') AS XCLD_SUN_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_HOL_FLG, 'Y', '1', '0') AS XCLD_HOL_FLG" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_CONTI_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_CNT_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_RGN_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_STE_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_LOC_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_STE_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("                   ,A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                   ,SUBSTR(A.EXPT_TRF_RMK, 0, 50) AS EXPT_TRF_RMK" ).append("\n"); 
		query.append("                   ,A.EXPT_TRF_RMK FULL_EXPT_TRF_RMK" ).append("\n"); 
		query.append("                   ,A.CURR_CD" ).append("\n"); 
		query.append("                   ,A.RT_CHK_FLG" ).append("\n"); 
		query.append("                   ,CASE" ).append("\n"); 
		query.append("                		WHEN A.RT_CHK_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                		WHEN A.CURR_CD IS NOT NULL OR A.CURR_CD <> '' THEN 'Y'" ).append("\n"); 
		query.append("                		WHEN (  SELECT	COUNT(*)" ).append("\n"); 
		query.append("                				FROM	DMT_SC_EXPT_RT_ADJ" ).append("\n"); 
		query.append("                				WHERE	PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                				AND	SC_EXPT_VER_SEQ = A.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                				AND SC_EXPT_GRP_SEQ = A.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                				) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                		ELSE 'N'" ).append("\n"); 
		query.append("                	END AS RT_CHK" ).append("\n"); 
		query.append("                FROM    DMT_SC_EXPT_GRP A, " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                				SELECT	PROP_NO" ).append("\n"); 
		query.append("                						, SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                						, SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                						, CVRG_SEQ" ).append("\n"); 
		query.append("                						, CASE WHEN CVRG_MULTI < 2 THEN 'S' ELSE 'M' END CVRG_MULTI" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN CNT_CD ELSE '' END CNT_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN RGN_CD ELSE '' END RGN_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN STE_CD ELSE '' END STE_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN LOC_CD ELSE '' END LOC_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                				FROM	(" ).append("\n"); 
		query.append("                							SELECT	COUNT(CVRG_SEQ) OVER (PARTITION BY PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ) CVRG_MULTI" ).append("\n"); 
		query.append("                									, ROW_NUMBER () OVER (PARTITION BY PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ ORDER BY SC_EXPT_GRP_SEQ, CVRG_SEQ) SEQ" ).append("\n"); 
		query.append("                            						, PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ, CVRG_SEQ, CNT_CD, RGN_CD, STE_CD, LOC_CD" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    						FROM    DMT_SC_EXPT_CVRG" ).append("\n"); 
		query.append("                    						WHERE   PROP_NO 		= @[prop_no] " ).append("\n"); 
		query.append("                								AND SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                								#if(${sc_expt_grp_seq} != '')" ).append("\n"); 
		query.append("                								AND SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("                								#end" ).append("\n"); 
		query.append("                    					)" ).append("\n"); 
		query.append("                				WHERE SEQ < 2" ).append("\n"); 
		query.append("                            ) B" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                WHERE   A.PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_VER_SEQ 	= @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                	#if(${sc_expt_grp_seq} != '')" ).append("\n"); 
		query.append("                	AND A.SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("                	#end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                	AND A.DELT_FLG 			= 'N'" ).append("\n"); 
		query.append("                    AND A.PROP_NO 			= B.PROP_NO" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_VER_SEQ 	= B.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_GRP_SEQ 	= B.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(") NEW," ).append("\n"); 
		query.append("(         SELECT 	A.PROP_NO" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                   ,A.DMDT_TRF_CD" ).append("\n"); 
		query.append("                   ,TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("                   ,TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("                   ,A.DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("                   ,B.CVRG_MULTI" ).append("\n"); 
		query.append("                   ,B.CVRG_MULTI AS CURR_CVRG_MULTI" ).append("\n"); 
		query.append("                   ,B.CVRG_SEQ" ).append("\n"); 
		query.append("                   ,B.CNT_CD" ).append("\n"); 
		query.append("                   ,B.RGN_CD" ).append("\n"); 
		query.append("                   ,B.STE_CD" ).append("\n"); 
		query.append("                   ,B.LOC_CD" ).append("\n"); 
		query.append("                   ,DECODE(A.FT_FLG, 'Y', '1', '0') AS FT_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.FT_ADJ_FLG, 'Y', 'M', DECODE(A.FT_FLG, 'Y', 'S', '')) AS FT_TIR" ).append("\n"); 
		query.append("                   ,CASE WHEN A.FT_FLG = 'Y' AND A.FT_ADD_FLG = 'Y' THEN A.FT_ADD_DYS END AS FT_ADD_DYS" ).append("\n"); 
		query.append("                   ,CASE WHEN A.FT_FLG = 'Y' AND A.FT_ADD_FLG = 'N' THEN A.FT_ADD_DYS END AS FT_TOT_DYS" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_SAT_FLG, 'Y', '1', '0') AS XCLD_SAT_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_SUN_FLG, 'Y', '1', '0') AS XCLD_SUN_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_HOL_FLG, 'Y', '1', '0') AS XCLD_HOL_FLG" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_CONTI_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_CNT_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_RGN_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_STE_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_LOC_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_STE_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("                   ,A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                   ,SUBSTR(A.EXPT_TRF_RMK, 0, 50) AS EXPT_TRF_RMK" ).append("\n"); 
		query.append("                   ,A.EXPT_TRF_RMK FULL_EXPT_TRF_RMK" ).append("\n"); 
		query.append("                   ,A.CURR_CD" ).append("\n"); 
		query.append("                   ,A.RT_CHK_FLG" ).append("\n"); 
		query.append("                   ,CASE" ).append("\n"); 
		query.append("                		WHEN A.RT_CHK_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                		WHEN A.CURR_CD IS NOT NULL OR A.CURR_CD <> '' THEN 'Y'" ).append("\n"); 
		query.append("                		WHEN (  SELECT	COUNT(*)" ).append("\n"); 
		query.append("                				FROM	DMT_SC_EXPT_RT_ADJ" ).append("\n"); 
		query.append("                				WHERE	PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                				AND	SC_EXPT_VER_SEQ = A.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                				AND SC_EXPT_GRP_SEQ = A.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                				) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                		ELSE 'N'" ).append("\n"); 
		query.append("                	END AS RT_CHK" ).append("\n"); 
		query.append("                FROM    DMT_SC_EXPT_GRP A, " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                				SELECT	PROP_NO" ).append("\n"); 
		query.append("                						, SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                						, SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                						, CVRG_SEQ" ).append("\n"); 
		query.append("                						, CASE WHEN CVRG_MULTI < 2 THEN 'S' ELSE 'M' END CVRG_MULTI" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN CNT_CD ELSE '' END CNT_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN RGN_CD ELSE '' END RGN_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN STE_CD ELSE '' END STE_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN LOC_CD ELSE '' END LOC_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                				FROM	(" ).append("\n"); 
		query.append("                							SELECT	COUNT(CVRG_SEQ) OVER (PARTITION BY PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ) CVRG_MULTI" ).append("\n"); 
		query.append("                									, ROW_NUMBER () OVER (PARTITION BY PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ ORDER BY SC_EXPT_GRP_SEQ, CVRG_SEQ) SEQ" ).append("\n"); 
		query.append("                            						, PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ, CVRG_SEQ, CNT_CD, RGN_CD, STE_CD, LOC_CD" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    						FROM    DMT_SC_EXPT_CVRG" ).append("\n"); 
		query.append("                    						WHERE   PROP_NO 		= @[prop_no] " ).append("\n"); 
		query.append("                								AND SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                								#if(${sc_expt_grp_seq} != '')" ).append("\n"); 
		query.append("                								AND SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("                								#end" ).append("\n"); 
		query.append("                    					)" ).append("\n"); 
		query.append("                				WHERE SEQ < 2" ).append("\n"); 
		query.append("                            ) B" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                WHERE   A.PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_VER_SEQ 	= @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                	#if(${sc_expt_grp_seq} != '')" ).append("\n"); 
		query.append("                	AND A.SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("                	#end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                	AND A.DELT_FLG 			= 'N'" ).append("\n"); 
		query.append("                    AND A.PROP_NO 			= B.PROP_NO" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_VER_SEQ 	= B.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_GRP_SEQ 	= B.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("         INTERSECT" ).append("\n"); 
		query.append("         SELECT 	A.PROP_NO" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                   ,A.DMDT_TRF_CD" ).append("\n"); 
		query.append("                   ,TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("                   ,TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("                   ,A.DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("                   ,B.CVRG_MULTI" ).append("\n"); 
		query.append("                   ,B.CVRG_MULTI AS CURR_CVRG_MULTI" ).append("\n"); 
		query.append("                   ,B.CVRG_SEQ" ).append("\n"); 
		query.append("                   ,B.CNT_CD" ).append("\n"); 
		query.append("                   ,B.RGN_CD" ).append("\n"); 
		query.append("                   ,B.STE_CD" ).append("\n"); 
		query.append("                   ,B.LOC_CD" ).append("\n"); 
		query.append("                   ,DECODE(A.FT_FLG, 'Y', '1', '0') AS FT_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.FT_ADJ_FLG, 'Y', 'M', DECODE(A.FT_FLG, 'Y', 'S', '')) AS FT_TIR" ).append("\n"); 
		query.append("                   ,CASE WHEN A.FT_FLG = 'Y' AND A.FT_ADD_FLG = 'Y' THEN A.FT_ADD_DYS END AS FT_ADD_DYS" ).append("\n"); 
		query.append("                   ,CASE WHEN A.FT_FLG = 'Y' AND A.FT_ADD_FLG = 'N' THEN A.FT_ADD_DYS END AS FT_TOT_DYS" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_SAT_FLG, 'Y', '1', '0') AS XCLD_SAT_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_SUN_FLG, 'Y', '1', '0') AS XCLD_SUN_FLG" ).append("\n"); 
		query.append("                   ,DECODE(A.XCLD_HOL_FLG, 'Y', '1', '0') AS XCLD_HOL_FLG" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_CONTI_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_CNT_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_RGN_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_STE_CD" ).append("\n"); 
		query.append("                   ,A.SC_EXPT_FM_LOC_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_STE_CD" ).append("\n"); 
		query.append("                   ,A.FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("                   ,A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                   ,SUBSTR(A.EXPT_TRF_RMK, 0, 50) AS EXPT_TRF_RMK" ).append("\n"); 
		query.append("                   ,A.EXPT_TRF_RMK FULL_EXPT_TRF_RMK" ).append("\n"); 
		query.append("                   ,A.CURR_CD" ).append("\n"); 
		query.append("                   ,A.RT_CHK_FLG" ).append("\n"); 
		query.append("                   ,CASE" ).append("\n"); 
		query.append("                		WHEN A.RT_CHK_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                		WHEN A.CURR_CD IS NOT NULL OR A.CURR_CD <> '' THEN 'Y'" ).append("\n"); 
		query.append("                		WHEN (  SELECT	COUNT(*)" ).append("\n"); 
		query.append("                				FROM	DMT_SC_EXPT_RT_ADJ" ).append("\n"); 
		query.append("                				WHERE	PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                				AND	SC_EXPT_VER_SEQ = A.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                				AND SC_EXPT_GRP_SEQ = A.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                				) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                		ELSE 'N'" ).append("\n"); 
		query.append("                	END AS RT_CHK" ).append("\n"); 
		query.append("                FROM    DMT_SC_EXPT_GRP A, " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                				SELECT	PROP_NO" ).append("\n"); 
		query.append("                						, SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                						, SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                						, CVRG_SEQ" ).append("\n"); 
		query.append("                						, CASE WHEN CVRG_MULTI < 2 THEN 'S' ELSE 'M' END CVRG_MULTI" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN CNT_CD ELSE '' END CNT_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN RGN_CD ELSE '' END RGN_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN STE_CD ELSE '' END STE_CD" ).append("\n"); 
		query.append("                        				, CASE WHEN CVRG_MULTI < 2 THEN LOC_CD ELSE '' END LOC_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                				FROM	(" ).append("\n"); 
		query.append("                							SELECT	COUNT(CVRG_SEQ) OVER (PARTITION BY PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ) CVRG_MULTI" ).append("\n"); 
		query.append("                									, ROW_NUMBER () OVER (PARTITION BY PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ ORDER BY SC_EXPT_GRP_SEQ, CVRG_SEQ) SEQ" ).append("\n"); 
		query.append("                            						, PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ, CVRG_SEQ, CNT_CD, RGN_CD, STE_CD, LOC_CD" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    						FROM    DMT_SC_EXPT_CVRG" ).append("\n"); 
		query.append("                    						WHERE   PROP_NO 		= @[prop_no] " ).append("\n"); 
		query.append("                								AND SC_EXPT_VER_SEQ = @[sc_expt_ver_seq] - 1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                								#if(${sc_expt_grp_seq} != '')" ).append("\n"); 
		query.append("                								AND SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("                								#end" ).append("\n"); 
		query.append("                    					)" ).append("\n"); 
		query.append("                				WHERE SEQ < 2" ).append("\n"); 
		query.append("                            ) B" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                WHERE   A.PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_VER_SEQ 	= @[sc_expt_ver_seq] - 1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                	#if(${sc_expt_grp_seq} != '')" ).append("\n"); 
		query.append("                	AND A.SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("                	#end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                	AND A.DELT_FLG 			= 'N'" ).append("\n"); 
		query.append("                    AND A.PROP_NO 			= B.PROP_NO" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_VER_SEQ 	= B.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                    AND A.SC_EXPT_GRP_SEQ 	= B.SC_EXPT_GRP_SEQ  " ).append("\n"); 
		query.append(" ) OLD" ).append("\n"); 
		query.append(" WHERE NEW.PROP_NO = OLD.PROP_NO(+)" ).append("\n"); 
		query.append(" AND   NEW.SC_EXPT_GRP_SEQ =  OLD.SC_EXPT_GRP_SEQ(+)" ).append("\n"); 
		query.append(" ORDER BY NEW.SC_EXPT_GRP_SEQ ASC" ).append("\n"); 

	}
}