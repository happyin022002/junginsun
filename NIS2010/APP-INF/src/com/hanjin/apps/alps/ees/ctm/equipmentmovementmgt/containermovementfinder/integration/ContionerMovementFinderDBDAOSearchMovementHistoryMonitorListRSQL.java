/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContionerMovementFinderDBDAOSearchMovementHistoryMonitorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContionerMovementFinderDBDAOSearchMovementHistoryMonitorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerMovementHistoryMonitorList
	  * </pre>
	  */
	public ContionerMovementFinderDBDAOSearchMovementHistoryMonitorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upt_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_corr_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_his_col_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("correction_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upt_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContionerMovementFinderDBDAOSearchMovementHistoryMonitorListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM AS SEQ" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,CASE WHEN MODI_TP_FLG = 'I' THEN 'Insert'" ).append("\n"); 
		query.append("            WHEN MODI_TP_FLG = 'U' THEN 'Update'" ).append("\n"); 
		query.append("            WHEN MODI_TP_FLG = 'D' THEN 'Delete'" ).append("\n"); 
		query.append("            ELSE '' END AS CORRECTION_TYPE" ).append("\n"); 
		query.append("      ,CNMV_CYC_NO" ).append("\n"); 
		query.append("      ,CNMV_CO_CD" ).append("\n"); 
		query.append("      ,MVMT_STS_CD" ).append("\n"); 
		query.append("      ,MVMT_CRE_TP_CD" ).append("\n"); 
		query.append("      ,(SELECT MEOC.RCC_CD" ).append("\n"); 
		query.append("        FROM   MDM_YARD MY" ).append("\n"); 
		query.append("              ,MDM_LOCATION ML" ).append("\n"); 
		query.append("              ,MDM_EQ_ORZ_CHT MEOC" ).append("\n"); 
		query.append("        WHERE  ML.SCC_CD = MEOC.SCC_CD" ).append("\n"); 
		query.append("        AND    MY.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("        AND    ML.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("        AND    MEOC.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("        AND    MY.YD_CD = A.ORG_YD_CD" ).append("\n"); 
		query.append("        AND    ROWNUM = 1) AS RCC_CD" ).append("\n"); 
		query.append("      ,(SELECT MEOC.LCC_CD" ).append("\n"); 
		query.append("        FROM   MDM_YARD MY" ).append("\n"); 
		query.append("              ,MDM_LOCATION ML" ).append("\n"); 
		query.append("              ,MDM_EQ_ORZ_CHT MEOC" ).append("\n"); 
		query.append("        WHERE  ML.SCC_CD = MEOC.SCC_CD" ).append("\n"); 
		query.append("        AND    MY.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("        AND    ML.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("        AND    MEOC.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("        AND    MY.YD_CD = A.ORG_YD_CD" ).append("\n"); 
		query.append("        AND    ROWNUM = 1) AS LCC_CD" ).append("\n"); 
		query.append("      ,ORG_YD_CD" ).append("\n"); 
		query.append("      ,DEST_YD_CD" ).append("\n"); 
		query.append("      ,CNMV_EVNT_DT" ).append("\n"); 
		query.append("      ,TRNK_VSL_CD || TRNK_SKD_VOY_NO || TRNK_SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,DECODE(FCNTR_FLG, 'Y', 'F', 'M') AS FCNTR_FLG" ).append("\n"); 
		query.append("      ,DECODE(OB_CNTR_FLG, 'Y', 'O', 'I') AS OB_CNTR_FLG" ).append("\n"); 
		query.append("      ,MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("      ,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      ,CNTR_DMG_FLG " ).append("\n"); 
		query.append("      ,CNTR_DISP_FLG " ).append("\n"); 
		query.append("      ,IMDT_EXT_FLG " ).append("\n"); 
		query.append("      ,CNTR_RFUB_FLG " ).append("\n"); 
		query.append("      ,SPCL_CGO_FLG " ).append("\n"); 
		query.append("      ,NVL2(VNDR_SEQ, VNDR_SEQ || (SELECT VNDR_ABBR_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) ,'') AS SERVICE_PROVIDER" ).append("\n"); 
		query.append("      ,VNDR_SEQ AS VNDR" ).append("\n"); 
		query.append("      ,NVL2(VNDR_SEQ, (SELECT VNDR_ABBR_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) ,'') AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("      ,INP_DIV_FLG" ).append("\n"); 
		query.append("      ,MVMT_TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,CHSS_NO" ).append("\n"); 
		query.append("      ,MGST_NO" ).append("\n"); 
		query.append("      ,CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,WBL_NO" ).append("\n"); 
		query.append("      ,PKUP_NO" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03488' AND INTG_CD_VAL_CTNT = A.CNMV_CORR_RSN) AS CNMV_CORR_RSN" ).append("\n"); 
		query.append("      ,ATCH_FILE_SAV_ID" ).append("\n"); 
		query.append("      ,DECODE(NVL(ATCH_FILE_SAV_ID,''),'','N','Y') AS ATCH_FILE_SAV_YN" ).append("\n"); 
		query.append("      ,UPD_LOCL_DT" ).append("\n"); 
		query.append("      ,CRE_LOCL_DT" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,USR_NM" ).append("\n"); 
		query.append("      ,CNMV_RMK" ).append("\n"); 
		query.append("      ,CASE WHEN (SELECT COUNT(CNTR_NO) AS CNT" ).append("\n"); 
		query.append("                    FROM CTM_MVMT_MNL_HIS_COL " ).append("\n"); 
		query.append("                   WHERE CNTR_NO = A.CNTR_NO " ).append("\n"); 
		query.append("                     AND CNMV_YR = A.CNMV_YR " ).append("\n"); 
		query.append("                     AND CNMV_ID_NO = A.CNMV_ID_NO " ).append("\n"); 
		query.append("                     AND CNMV_HIS_SEQ = A.CNMV_HIS_SEQ) = 0" ).append("\n"); 
		query.append("            THEN 'N' ELSE 'Y' END AS CNG_YN" ).append("\n"); 
		query.append("      ,(SELECT NLS_LOWER(SUBSTR (XMLAGG (XMLELEMENT (B, ':', B.CNMV_COL_NM) ORDER BY B.CNMV_COL_NM).EXTRACT ('//text()'), 2)) AS CNMV_COL_NM" ).append("\n"); 
		query.append("          FROM CTM_MVMT_MNL_HIS_COL B" ).append("\n"); 
		query.append("         WHERE B.CNTR_NO = A.CNTR_NO " ).append("\n"); 
		query.append("           AND B.CNMV_YR = A.CNMV_YR " ).append("\n"); 
		query.append("           AND B.CNMV_ID_NO = A.CNMV_ID_NO " ).append("\n"); 
		query.append("           AND B.CNMV_HIS_SEQ = A.CNMV_HIS_SEQ" ).append("\n"); 
		query.append("       ) AS CNMV_HIS_COL_NM" ).append("\n"); 
		query.append("FROM CTM_MVMT_MNL_HIS A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND DAT_DIV_FLG = 'T' -- 변경된 ROW만 보여 주기 위한 조건" ).append("\n"); 
		query.append("#if ( ${divflag} == 1 )" ).append("\n"); 
		query.append("	#if(${event_from_dt} != '')" ).append("\n"); 
		query.append("  AND CNMV_EVNT_DT BETWEEN TO_DATE(@[event_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[event_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if(${upt_from_dt} != '')" ).append("\n"); 
		query.append("  AND UPD_DT BETWEEN TO_DATE(@[upt_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[upt_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yard_cd1} == '')" ).append("\n"); 
		query.append("  #if ((${lcc_cd} != '' && ${lcc_cd} != 'ALL') || (${rcc_cd} != '' && ${rcc_cd} != 'ALL'))" ).append("\n"); 
		query.append("  AND ORG_YD_CD IN (SELECT YD_CD FROM MDM_YARD" ).append("\n"); 
		query.append("                    WHERE LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                     WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                       AND SCC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                                                      WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("    #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("                                                        AND LCC_CD IN (${lcc_cd})" ).append("\n"); 
		query.append("    #elseif (${rcc_cd} != '')" ).append("\n"); 
		query.append("                                                        AND RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if (${yard_cd2} != '' && ${yard_cd2} != 'ALL')" ).append("\n"); 
		query.append("  AND ORG_YD_CD IN (${org_yd_cd})" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("  AND SUBSTR(ORG_YD_CD, 1, 5) = @[yard_cd1]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cnmv_his_col_nm} != '')" ).append("\n"); 
		query.append("  AND (CNTR_NO, CNMV_YR, CNMV_ID_NO, CNMV_HIS_SEQ) IN (SELECT CNTR_NO, CNMV_YR, CNMV_ID_NO, CNMV_HIS_SEQ" ).append("\n"); 
		query.append("                                                       FROM CTM_MVMT_MNL_HIS_COL" ).append("\n"); 
		query.append("                                                       WHERE 1 = 1" ).append("\n"); 
		query.append("                                                         AND CNMV_COL_NM = @[cnmv_his_col_nm]" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cnmv_corr_rsn} != '')" ).append("\n"); 
		query.append("  AND CNMV_CORR_RSN = @[cnmv_corr_rsn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${atch_file_sav_id} != '')" ).append("\n"); 
		query.append("	#if(${atch_file_sav_id} == 'Y')" ).append("\n"); 
		query.append("  AND ATCH_FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("  AND ATCH_FILE_SAV_ID IS NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${correction_type} != '')" ).append("\n"); 
		query.append("  AND MODI_TP_FLG = @[correction_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  -- 2016.05.17 김상현 [CHM-201641462] Correction reason 컨테이너 list 기능 보완 (no highlighted)" ).append("\n"); 
		query.append("  --  -'CNMV_SPLIT_NO'만 변경된 data는 보이지 않도록 조건 추가" ).append("\n"); 
		query.append("  AND 'TRUE' = CASE WHEN A.MODI_TP_FLG = 'U' AND EXISTS(SELECT 1" ).append("\n"); 
		query.append("                                                    FROM CTM_MVMT_MNL_HIS_COL" ).append("\n"); 
		query.append("                                                    WHERE 1 = 1" ).append("\n"); 
		query.append("                                                      AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                                                      AND CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("                                                      AND CNMV_ID_NO = A.CNMV_ID_NO" ).append("\n"); 
		query.append("                                                      AND CNMV_HIS_SEQ = A.CNMV_HIS_SEQ" ).append("\n"); 
		query.append("                                                      AND CNMV_COL_NM <> 'CNMV_SPLIT_NO'" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                      THEN 'TRUE'" ).append("\n"); 
		query.append("                    WHEN A.MODI_TP_FLG <> 'U' THEN 'TRUE'" ).append("\n"); 
		query.append("                    ELSE 'FALSE'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("ORDER BY A.UPD_DT DESC" ).append("\n"); 

	}
}