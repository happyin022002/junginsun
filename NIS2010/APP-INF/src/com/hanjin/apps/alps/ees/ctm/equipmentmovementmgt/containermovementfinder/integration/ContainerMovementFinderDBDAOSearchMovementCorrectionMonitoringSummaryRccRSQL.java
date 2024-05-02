/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchMovementCorrectionMonitoringSummaryRccRSQL.java
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

public class ContainerMovementFinderDBDAOSearchMovementCorrectionMonitoringSummaryRccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 20160425 HongSeongPill Movement Correction Monitoring Summary Rcc
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchMovementCorrectionMonitoringSummaryRccRSQL(){
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
		query.append("FileName : ContainerMovementFinderDBDAOSearchMovementCorrectionMonitoringSummaryRccRSQL").append("\n"); 
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
		query.append("SELECT C.RCC_CD" ).append("\n"); 
		query.append("      ,C.INTG_CD_VAL_CTNT AS CNMV_CORR_RSN_CD" ).append("\n"); 
		query.append("      ,C.INTG_CD_VAL_DESC AS CNMV_CORR_RSN_NM" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'D' THEN 1 ELSE 0 END) AS DEL_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'I' THEN 1 ELSE 0 END) AS INS_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'MVMT_STS_CD' THEN 1 ELSE 0 END) AS MVMT_STS_CD_CNT      " ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'CNMV_EVNT_DT' THEN 1 ELSE 0 END) AS CNMV_EVNT_DT_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'ORG_YD_CD' THEN 1 ELSE 0 END) AS ORG_YD_CD_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'VVD' THEN 1 ELSE 0 END) AS VVD_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'FCNTR_FLG' THEN 1 ELSE 0 END) AS FCNTR_FLG_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'OB_CNTR_FLG' THEN 1 ELSE 0 END) AS OB_CNTR_FLG_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'VNDR' THEN 1 ELSE 0 END) AS VNDR_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'MVMT_TRSP_MOD_CD' THEN 1 ELSE 0 END) AS MVMT_TRSP_MOD_CD_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'CNTR_SEAL_NO' THEN 1 ELSE 0 END) AS CNTR_SEAL_NO_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'WBL_NO' THEN 1 ELSE 0 END) AS WBL_NO_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM = 'PKUP_NO' THEN 1 ELSE 0 END) AS PKUP_NO_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG = 'U' AND A.CNMV_COL_NM NOT IN ('MVMT_STS_CD','CNMV_EVNT_DT','ORG_YD_CD','ORG_YD_CD','VVD','FCNTR_FLG','OB_CNTR_FLG','VNDR','MVMT_TRSP_MOD_CD','CNTR_SEAL_NO','WBL_NO','PKUP_NO') THEN 1 ELSE 0 END) AS ETC_CNT" ).append("\n"); 
		query.append("      ,SUM(CASE WHEN A.MODI_TP_FLG IN ('I','U','D') THEN 1 ELSE 0 END) AS TOT_CNT" ).append("\n"); 
		query.append("      ,2 - ROUND(LOG(2, GROUPING_ID(RCC_CD,INTG_CD_VAL_CTNT) + 1)) AS LVL" ).append("\n"); 
		query.append("FROM   (SELECT CMH.ORG_YD_CD" ).append("\n"); 
		query.append("              ,(CASE WHEN NVL(CMH.CNMV_CORR_RSN,'ZZ') NOT IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03488') THEN 'ZZ' ELSE CMH.CNMV_CORR_RSN END ) AS CNMV_CORR_RSN" ).append("\n"); 
		query.append("              ,CMH.MODI_TP_FLG" ).append("\n"); 
		query.append("              ,NVL(CMHC.CNMV_COL_NM,'NULL') AS CNMV_COL_NM" ).append("\n"); 
		query.append("        FROM   CTM_MVMT_MNL_HIS CMH" ).append("\n"); 
		query.append("              ,CTM_MVMT_MNL_HIS_COL CMHC" ).append("\n"); 
		query.append("        WHERE  CMH.DAT_DIV_FLG = 'T'" ).append("\n"); 
		query.append("        AND    CMH.CNTR_NO = CMHC.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND    CMH.CNMV_YR = CMHC.CNMV_YR(+)" ).append("\n"); 
		query.append("        AND    CMH.CNMV_ID_NO = CMHC.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("        AND    CMH.CNMV_HIS_SEQ = CMHC.CNMV_HIS_SEQ(+)" ).append("\n"); 
		query.append("#if ( ${divflag} == 1 )" ).append("\n"); 
		query.append("	#if(${event_from_dt} != '')" ).append("\n"); 
		query.append("        AND    CMH.CNMV_EVNT_DT BETWEEN TO_DATE(@[event_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[event_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if(${upt_from_dt} != '')" ).append("\n"); 
		query.append("        AND    CMH.UPD_DT BETWEEN TO_DATE(@[upt_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[upt_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yard_cd1} == '')" ).append("\n"); 
		query.append("	#if ((${lcc_cd} != '' && ${lcc_cd} != 'ALL') || (${rcc_cd} != '' && ${rcc_cd} != 'ALL'))" ).append("\n"); 
		query.append("        AND    CMH.ORG_YD_CD IN (SELECT YD_CD FROM MDM_YARD" ).append("\n"); 
		query.append("                                 WHERE LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                  WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                                  AND SCC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                                                                  WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("		#if (${lcc_cd} != '')" ).append("\n"); 
		query.append("                                                                    AND LCC_CD IN (${lcc_cd})" ).append("\n"); 
		query.append("		#elseif (${rcc_cd} != '')" ).append("\n"); 
		query.append("                                                                    AND RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                                                                )" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${yard_cd2} != '' && ${yard_cd2} != 'ALL')" ).append("\n"); 
		query.append("        AND    CMH.ORG_YD_CD IN (${org_yd_cd})" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        AND    SUBSTR(CMH.ORG_YD_CD, 1, 5) = @[yard_cd1]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cnmv_his_col_nm} != '')" ).append("\n"); 
		query.append("        AND    CMHC.CNMV_COL_NM = @[cnmv_his_col_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cnmv_corr_rsn} != '')" ).append("\n"); 
		query.append("        AND    CMH.CNMV_CORR_RSN = @[cnmv_corr_rsn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${atch_file_sav_id} != '')" ).append("\n"); 
		query.append("	#if(${atch_file_sav_id} == 'Y')" ).append("\n"); 
		query.append("        AND    CMH.ATCH_FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        AND    CMH.ATCH_FILE_SAV_ID IS NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${correction_type} != '')" ).append("\n"); 
		query.append("        AND    CMH.MODI_TP_FLG = @[correction_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,(SELECT MEOC.RCC_CD" ).append("\n"); 
		query.append("              ,MEOC.LCC_CD" ).append("\n"); 
		query.append("              ,ML.LOC_CD" ).append("\n"); 
		query.append("              ,MY.YD_CD" ).append("\n"); 
		query.append("              ,CICD.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("              ,CICD.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM   MDM_YARD MY" ).append("\n"); 
		query.append("              ,MDM_LOCATION ML" ).append("\n"); 
		query.append("              ,MDM_EQ_ORZ_CHT MEOC" ).append("\n"); 
		query.append("              ,(SELECT ORG_YD_CD " ).append("\n"); 
		query.append("                FROM   CTM_MVMT_MNL_HIS" ).append("\n"); 
		query.append("                WHERE  DAT_DIV_FLG = 'T'" ).append("\n"); 
		query.append("#if ( ${divflag} == 1 )" ).append("\n"); 
		query.append("	#if(${event_from_dt} != '')" ).append("\n"); 
		query.append("                AND    CNMV_EVNT_DT BETWEEN TO_DATE(@[event_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[event_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if(${upt_from_dt} != '')" ).append("\n"); 
		query.append("                AND    UPD_DT BETWEEN TO_DATE(@[upt_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[upt_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yard_cd1} == '')" ).append("\n"); 
		query.append("	#if ((${lcc_cd} != '' && ${lcc_cd} != 'ALL') || (${rcc_cd} != '' && ${rcc_cd} != 'ALL'))" ).append("\n"); 
		query.append("                AND    ORG_YD_CD IN (SELECT YD_CD FROM MDM_YARD" ).append("\n"); 
		query.append("                                     WHERE LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                       WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                                         AND SCC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                                                                         WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("		#if (${lcc_cd} != '')" ).append("\n"); 
		query.append("                                                                           AND LCC_CD IN (${lcc_cd})" ).append("\n"); 
		query.append("		#elseif (${rcc_cd} != '')" ).append("\n"); 
		query.append("                                                                           AND RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                                                                       )" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${yard_cd2} != '' && ${yard_cd2} != 'ALL')" ).append("\n"); 
		query.append("                AND    ORG_YD_CD IN (${org_yd_cd})" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("                AND    SUBSTR(ORG_YD_CD, 1, 5) = @[yard_cd1]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cnmv_his_col_nm} != '')" ).append("\n"); 
		query.append("                AND    (CNTR_NO, CNMV_YR, CNMV_ID_NO, CNMV_HIS_SEQ) IN (SELECT CNTR_NO, CNMV_YR, CNMV_ID_NO, CNMV_HIS_SEQ" ).append("\n"); 
		query.append("                                                                          FROM CTM_MVMT_MNL_HIS_COL" ).append("\n"); 
		query.append("                                                                         WHERE CNMV_COL_NM = @[cnmv_his_col_nm]" ).append("\n"); 
		query.append("                                                                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cnmv_corr_rsn} != '')" ).append("\n"); 
		query.append("                AND    CNMV_CORR_RSN = @[cnmv_corr_rsn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${atch_file_sav_id} != '')" ).append("\n"); 
		query.append("	#if(${atch_file_sav_id} == 'Y')" ).append("\n"); 
		query.append("                AND    ATCH_FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("                AND    ATCH_FILE_SAV_ID IS NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${correction_type} != '')" ).append("\n"); 
		query.append("                AND    MODI_TP_FLG = @[correction_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                GROUP BY ORG_YD_CD) CMH" ).append("\n"); 
		query.append("              ,(SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03488'" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 'ZZ' INTG_CD_VAL_CTNT, 'etc.' AS INTG_CD_VAL_DESC FROM DUAL) CICD" ).append("\n"); 
		query.append("        WHERE  ML.SCC_CD = MEOC.SCC_CD" ).append("\n"); 
		query.append("        AND    MY.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("        AND    MY.YD_CD = CMH.ORG_YD_CD" ).append("\n"); 
		query.append("        AND    ML.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("        AND    MEOC.DELT_FLG <> 'Y') C" ).append("\n"); 
		query.append("WHERE  C.YD_CD = A.ORG_YD_CD(+)" ).append("\n"); 
		query.append("AND    C.INTG_CD_VAL_CTNT = A.CNMV_CORR_RSN(+)" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                        (C.RCC_CD, C.INTG_CD_VAL_CTNT,C.INTG_CD_VAL_DESC)," ).append("\n"); 
		query.append("                        (C.RCC_CD)" ).append("\n"); 
		query.append("                       ) " ).append("\n"); 
		query.append("ORDER BY C.RCC_CD, C.INTG_CD_VAL_CTNT NULLS FIRST" ).append("\n"); 

	}
}