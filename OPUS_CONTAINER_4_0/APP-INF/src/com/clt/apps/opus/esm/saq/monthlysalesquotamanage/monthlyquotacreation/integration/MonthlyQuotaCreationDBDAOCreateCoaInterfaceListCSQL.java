/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOCreateCoaInterfaceListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOCreateCoaInterfaceListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateCoaInterfaceList
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOCreateCoaInterfaceListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOCreateCoaInterfaceListCSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("           MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         , SLS_FCAST_NO " ).append("\n"); 
		query.append("         , ALTN_FCAST_SEQ " ).append("\n"); 
		query.append("         , RLANE_CD " ).append("\n"); 
		query.append("         , DIR_CD " ).append("\n"); 
		query.append("         , VSL_CD " ).append("\n"); 
		query.append("         , SKD_VOY_NO " ).append("\n"); 
		query.append("         , SKD_DIR_CD " ).append("\n"); 
		query.append("         , CUST_CNT_CD " ).append("\n"); 
		query.append("         , CUST_SEQ " ).append("\n"); 
		query.append("         , CTRT_OFC_CD " ).append("\n"); 
		query.append("         , SLS_OFC_CD " ).append("\n"); 
		query.append("         , POR_CD " ).append("\n"); 
		query.append("         , DEL_CD " ).append("\n"); 
		query.append("         , N1ST_POL_CD " ).append("\n"); 
		query.append("         , LST_POD_CD " ).append("\n"); 
		query.append("         , TRNK_POL_CD " ).append("\n"); 
		query.append("         , TRNK_POD_CD " ).append("\n"); 
		query.append("         , FCAST_CNTR_TPSZ_CD " ).append("\n"); 
		query.append("         , LOD_QTY " ).append("\n"); 
		query.append("         , CNTR_WGT " ).append("\n"); 
		query.append("         , GRS_RPB_REV " ).append("\n"); 
		query.append("         , CM_UC_AMT " ).append("\n"); 
		query.append("         , OPFIT_UC_AMT " ).append("\n"); 
		query.append("         , RA_CM_UC_AMT " ).append("\n"); 
		query.append("         , RA_STP_PFIT_UT_AMT " ).append("\n"); 
		query.append("         , RA_OPFIT_UC_AMT " ).append("\n"); 
		query.append("         , MDL_RSLT_FLG " ).append("\n"); 
		query.append("         , MDL_ALOC_QTY " ).append("\n"); 
		query.append("         , REP_TRD_CD " ).append("\n"); 
		query.append("         , REP_SUB_TRD_CD " ).append("\n"); 
		query.append("         , TRD_CD " ).append("\n"); 
		query.append("         , SUB_TRD_CD " ).append("\n"); 
		query.append("         , IOC_CD " ).append("\n"); 
		query.append("         , CTRT_RHQ_CD " ).append("\n"); 
		query.append("         , CTRT_AQ_CD " ).append("\n"); 
		query.append("         , CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("         , CTRT_SREP_CD " ).append("\n"); 
		query.append("         , SLS_RHQ_CD " ).append("\n"); 
		query.append("         , SLS_AQ_CD " ).append("\n"); 
		query.append("         , SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("         , SREP_CD " ).append("\n"); 
		query.append("         , COST_ASGN_STEP_CD " ).append("\n"); 
		query.append("         , LGS_COST_ASGN_STEP_CD " ).append("\n"); 
		query.append("         , SVC_MOD_CD " ).append("\n"); 
		query.append("         , SAQ_SVC_MOD_CD " ).append("\n"); 
		query.append("         , FULL_STVG_UC_AMT " ).append("\n"); 
		query.append("         , FULL_TRSP_UC_AMT " ).append("\n"); 
		query.append("         , MTY_STVG_UC_AMT " ).append("\n"); 
		query.append("         , MTY_TRSP_UC_AMT " ).append("\n"); 
		query.append("         , CNTR_FX_UC_AMT " ).append("\n"); 
		query.append("         , CHSS_FX_UC_AMT " ).append("\n"); 
		query.append("         , AGN_COMM_UT_AMT " ).append("\n"); 
		query.append("         , BIZ_ACT_UC_AMT " ).append("\n"); 
		query.append("         , SLT_MGMT_UC_AMT " ).append("\n"); 
		query.append("         , OWN_VOL_ACT_UC_AMT " ).append("\n"); 
		query.append("         , STP_UC_AMT " ).append("\n"); 
		query.append("         , EQ_HLD_UC_AMT " ).append("\n"); 
		query.append("         , EQ_REPO_UC_AMT " ).append("\n"); 
		query.append("         , EQ_SIM_UC_AMT " ).append("\n"); 
		query.append("         , DMDT_UT_AMT " ).append("\n"); 
		query.append("         , TML_VOL_INCNT_AMT " ).append("\n"); 
		query.append("         , SAQ_MISC_REV_AMT " ).append("\n"); 
		query.append("         , CUST_GRP_ID " ).append("\n"); 
		query.append("         , DMND_FCAST_UT_NM " ).append("\n"); 
		query.append("         , DMND_FCAST_GRP_NM " ).append("\n"); 
		query.append("         , DMND_FCAST_EQ_TPSZ_NO " ).append("\n"); 
		query.append("         , ST_DT " ).append("\n"); 
		query.append("         , ORG_LOD_QTY" ).append("\n"); 
		query.append("         , ORG_GRS_RPB_REV" ).append("\n"); 
		query.append("         , ORG_CM_UC_AMT" ).append("\n"); 
		query.append("         , FCAST_TRNS_STS_CD" ).append("\n"); 
		query.append("         , CRE_USR_ID " ).append("\n"); 
		query.append("         , CRE_DT " ).append("\n"); 
		query.append("         , UPD_USR_ID " ).append("\n"); 
		query.append("         , UPD_DT " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("SELECT @[h_ver_no] AS MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , SUBSTR(@[h_ver_no],1,2)|| LPAD(ROWNUM, 8,'0') SLS_FCAST_NO " ).append("\n"); 
		query.append("     , 0 AS ALTN_FCAST_SEQ " ).append("\n"); 
		query.append("     , RLANE_CD " ).append("\n"); 
		query.append("     , DIR_CD " ).append("\n"); 
		query.append("     , NULL AS VSL_CD " ).append("\n"); 
		query.append("     , NULL AS SKD_VOY_NO " ).append("\n"); 
		query.append("     , NULL AS SKD_DIR_CD " ).append("\n"); 
		query.append("     , NULL AS CUST_CNT_CD " ).append("\n"); 
		query.append("     , NULL AS CUST_SEQ " ).append("\n"); 
		query.append("     , CTRT_OFC_CD " ).append("\n"); 
		query.append("     , SLS_OFC_CD " ).append("\n"); 
		query.append("     , '00000' AS POR_CD " ).append("\n"); 
		query.append("     , '00000' AS DEL_CD " ).append("\n"); 
		query.append("     , '00000' AS N1ST_POL_CD " ).append("\n"); 
		query.append("     , '00000' AS LST_POD_CD " ).append("\n"); 
		query.append("     , '0000' AS TRNK_POL_CD " ).append("\n"); 
		query.append("     , '0000' AS TRNK_POD_CD " ).append("\n"); 
		query.append("     , '' AS FCAST_CNTR_TPSZ_CD " ).append("\n"); 
		query.append("     , C1.TEU_VOL AS LOD_QTY " ).append("\n"); 
		query.append("     , 0 AS CNTR_WGT " ).append("\n"); 
		query.append("     , C1.FREIGHT_REV AS GRS_RPB_REV " ).append("\n"); 
		query.append("     , C1.CM_UC_AMT AS CM_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS OPFIT_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS RA_CM_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS RA_STP_PFIT_UT_AMT " ).append("\n"); 
		query.append("     , 0 AS RA_OPFIT_UC_AMT " ).append("\n"); 
		query.append("     , 'N' AS MDL_RSLT_FLG " ).append("\n"); 
		query.append("     , C1.TEU_VOL AS MDL_ALOC_QTY " ).append("\n"); 
		query.append("     , TRD_CD AS REP_TRD_CD " ).append("\n"); 
		query.append("     , SUB_TRD_CD AS REP_SUB_TRD_CD " ).append("\n"); 
		query.append("     , TRD_CD " ).append("\n"); 
		query.append("     , SUB_TRD_CD " ).append("\n"); 
		query.append("     , IOC_CD " ).append("\n"); 
		query.append("     , CTRT_RHQ_CD " ).append("\n"); 
		query.append("     , CTRT_AQ_CD " ).append("\n"); 
		query.append("     , CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("     , NULL AS CTRT_SREP_CD " ).append("\n"); 
		query.append("     , SLS_RHQ_CD " ).append("\n"); 
		query.append("     , SLS_AQ_CD " ).append("\n"); 
		query.append("     , SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("     , 'NA' AS SREP_CD " ).append("\n"); 
		query.append("     , '10' AS COST_ASGN_STEP_CD " ).append("\n"); 
		query.append("     , '00' AS LGS_COST_ASGN_STEP_CD " ).append("\n"); 
		query.append("     , '0000' AS SVC_MOD_CD " ).append("\n"); 
		query.append("     , '0000' AS SAQ_SVC_MOD_CD " ).append("\n"); 
		query.append("     , 0 AS FULL_STVG_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS FULL_TRSP_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS MTY_STVG_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS MTY_TRSP_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS CNTR_FX_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS CHSS_FX_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS AGN_COMM_UT_AMT " ).append("\n"); 
		query.append("     , 0 AS BIZ_ACT_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS SLT_MGMT_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS OWN_VOL_ACT_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS STP_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS EQ_HLD_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS EQ_REPO_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS EQ_SIM_UC_AMT " ).append("\n"); 
		query.append("     , 0 AS DMDT_UT_AMT " ).append("\n"); 
		query.append("     , 0 AS TML_VOL_INCNT_AMT " ).append("\n"); 
		query.append("     , 0 AS SAQ_MISC_REV_AMT " ).append("\n"); 
		query.append("     , '00000' AS CUST_GRP_ID " ).append("\n"); 
		query.append("     , '' AS DMND_FCAST_UT_NM " ).append("\n"); 
		query.append("     , '' AS DMND_FCAST_GRP_NM " ).append("\n"); 
		query.append("     , '' AS DMND_FCAST_EQ_TPSZ_NO " ).append("\n"); 
		query.append("     , C2.ST_DT " ).append("\n"); 
		query.append("     , C1.TEU_VOL AS ORG_LOD_QTY " ).append("\n"); 
		query.append("     , C1.FREIGHT_REV AS ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("     , C1.CM_UC_AMT AS ORG_CM_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("     , @[usr_id] AS CRE_USR_ID " ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT " ).append("\n"); 
		query.append("     , @[usr_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT TO_DATE(@[h_year]||to_char(@[h_mon], 'FM00')||'01','YYYY/MM/DD') ST_DT " ).append("\n"); 
		query.append("            , B1.TRD_CD " ).append("\n"); 
		query.append("            , B1.RLANE_CD " ).append("\n"); 
		query.append("            , B1.DIR_CD " ).append("\n"); 
		query.append("            , B1.SUB_TRD_CD " ).append("\n"); 
		query.append("            , B1.IOC_CD " ).append("\n"); 
		query.append("            , MAX(B1.CTRT_RHQ_CD) AS CTRT_RHQ_CD " ).append("\n"); 
		query.append("            , MAX(B1.CTRT_AQ_CD) AS CTRT_AQ_CD " ).append("\n"); 
		query.append("            , MAX(B1.CTRT_RGN_OFC_CD) AS CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("            , B1.CTRT_OFC_CD " ).append("\n"); 
		query.append("            , MAX(B1.SLS_RHQ_CD) AS SLS_RHQ_CD " ).append("\n"); 
		query.append("            , MAX(B1.SLS_AQ_CD) AS SLS_AQ_CD " ).append("\n"); 
		query.append("            , MAX(B1.SLS_RGN_OFC_CD) AS SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("            , B1.SLS_OFC_CD " ).append("\n"); 
		query.append("            , ROUND(SUM(B1.TEU_VOL / VVD_CNT)) AS TEU_VOL /* 4레벨 Office Vessel 별 TEU (AVG) */ " ).append("\n"); 
		query.append("            , ROUND(MAX(B1.GROSS_CM_UC_AMT) / MAX(TEU_SUM)) AS CM_UC_AMT /* 4레벨 Office로 변환 후 비용 재계산 */ " ).append("\n"); 
		query.append("            , ROUND(SUM(B1.TEU_VOL)) AS TEU_VOL2 /* 4레벨 Office별 총 TEU */ " ).append("\n"); 
		query.append("            , ROUND(MAX(B1.GROSS_FREIGHT_REV) / MAX(TEU_SUM)) AS FREIGHT_REV /* 4레벨 Office로 변환 후 비용 재계산 */ " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT A1.BKG_NO " ).append("\n"); 
		query.append("                   , A1.COST_YRMON " ).append("\n"); 
		query.append("                   , A1.TRD_CD " ).append("\n"); 
		query.append("                   , A1.RLANE_CD " ).append("\n"); 
		query.append("                   , A1.DIR_CD " ).append("\n"); 
		query.append("                   , A1.SUB_TRD_CD " ).append("\n"); 
		query.append("                   , A1.IOC_CD " ).append("\n"); 
		query.append("                   , A1.CTRT_OFC_CD " ).append("\n"); 
		query.append("                   , A1.CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("                   , A1.CTRT_AQ_CD " ).append("\n"); 
		query.append("                   , A1.CTRT_RHQ_CD " ).append("\n"); 
		query.append("                   , A1.SLS_OFC_CD " ).append("\n"); 
		query.append("                   , A1.SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("                   , A1.SLS_AQ_CD " ).append("\n"); 
		query.append("                   , A1.SLS_RHQ_CD " ).append("\n"); 
		query.append("                   , A1.SPCL_CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                   , A1.CM_UC_AMT " ).append("\n"); 
		query.append("                   , A1.BKG_QTY " ).append("\n"); 
		query.append("                   , A1.TEU_VOL " ).append("\n"); 
		query.append("                   , A1.FREIGHT_REV " ).append("\n"); 
		query.append("                   , A1.VVD_CNT " ).append("\n"); 
		query.append("                   , SUM(A1.TEU_VOL) OVER(PARTITION BY A1.TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.SUB_TRD_CD, A1.IOC_CD, A1.CTRT_OFC_CD, A1.SLS_OFC_CD) AS TEU_SUM " ).append("\n"); 
		query.append("                   , SUM(A1.FREIGHT_REV) OVER(PARTITION BY A1.TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.SUB_TRD_CD, A1.IOC_CD, A1.CTRT_OFC_CD, A1.SLS_OFC_CD) AS GROSS_FREIGHT_REV " ).append("\n"); 
		query.append("                   , SUM(A1.CM_UC_AMT) OVER(PARTITION BY A1.TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.SUB_TRD_CD, A1.IOC_CD, A1.CTRT_OFC_CD, A1.SLS_OFC_CD) AS GROSS_CM_UC_AMT " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                     (SELECT T1.BKG_NO " ).append("\n"); 
		query.append("                          , T1.COST_YRMON " ).append("\n"); 
		query.append("                          , T1.TRD_CD " ).append("\n"); 
		query.append("                          , T1.RLANE_CD " ).append("\n"); 
		query.append("                          , T1.DIR_CD " ).append("\n"); 
		query.append("                          , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("                          , T1.IOC_CD " ).append("\n"); 
		query.append("                          , NVL(T2.N4TH_PRNT_OFC_CD, T1.CTRT_OFC_CD) AS CTRT_OFC_CD " ).append("\n"); 
		query.append("                          , NVL(T2.N4TH_PRNT_OFC_CD, T1.CTRT_OFC_CD) AS CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("                          , T2.N3RD_PRNT_OFC_CD AS CTRT_AQ_CD " ).append("\n"); 
		query.append("                          , T2.N2ND_PRNT_OFC_CD AS CTRT_RHQ_CD " ).append("\n"); 
		query.append("                          , NVL(T3.N4TH_PRNT_OFC_CD, T1.SLS_OFC_CD) AS SLS_OFC_CD " ).append("\n"); 
		query.append("                          , NVL(T3.N4TH_PRNT_OFC_CD, T1.SLS_OFC_CD) AS SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("                          , T3.N3RD_PRNT_OFC_CD AS SLS_AQ_CD " ).append("\n"); 
		query.append("                          , T3.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD " ).append("\n"); 
		query.append("                          , T1.SPCL_CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                          , T1.PA_CM_COST_TTL_AMT AS CM_UC_AMT " ).append("\n"); 
		query.append("                          , T1.BKG_QTY " ).append("\n"); 
		query.append("                          , DECODE(SUBSTR(SPCL_CNTR_TPSZ_CD,-1), '2', BKG_QTY, BKG_QTY *2) AS TEU_VOL /* 수량을 TEU로 변환 */ " ).append("\n"); 
		query.append("                          , BKG_REV + BKG_OFT_REV + SCR_CHG_REV AS FREIGHT_REV " ).append("\n"); 
		query.append("                          , COUNT(DISTINCT VSL_CD||SKD_VOY_NO||DIR_CD) OVER(PARTITION BY TRD_CD, RLANE_CD, DIR_CD, IOC_CD) AS VVD_CNT /* Vessel 수*/ " ).append("\n"); 
		query.append("                       FROM COA_BKG_EXPN_DTL T1 " ).append("\n"); 
		query.append("                          , SAQ_ORGANIZATION_V T2 " ).append("\n"); 
		query.append("                          , SAQ_ORGANIZATION_V T3 " ).append("\n"); 
		query.append("                      WHERE 1=1 " ).append("\n"); 
		query.append("                            AND T1.CTRT_OFC_CD = T2.OFC_CD " ).append("\n"); 
		query.append("                            AND T1.SLS_OFC_CD = T3.OFC_CD " ).append("\n"); 
		query.append("                            AND T1.BKG_STS_CD IN ('F','S','W') " ).append("\n"); 
		query.append("                            AND T1.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("                            AND T1.SUB_TRD_CD <> 'IP' " ).append("\n"); 
		query.append("                            AND T1.BL_NO_TP IN ('M','0') " ).append("\n"); 
		query.append("                            AND T1.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                            AND MOD(T1.BKG_QTY,1) = 0 " ).append("\n"); 
		query.append("      					#if(${sel_div} == 'Q')" ).append("\n"); 
		query.append("                     		AND COST_YRMON IN(" ).append("\n"); 
		query.append("              				#foreach($key IN ${qtr_yrmon}) " ).append("\n"); 
		query.append("                   				#if($velocityCount < $qtr_yrmon.size()) " ).append("\n"); 
		query.append("                    			'$key', " ).append("\n"); 
		query.append("                   				#else " ).append("\n"); 
		query.append("                    			'$key' " ).append("\n"); 
		query.append("                   				#end " ).append("\n"); 
		query.append("              				#end )" ).append("\n"); 
		query.append("						#elseif(${sel_div} == 'Y')" ).append("\n"); 
		query.append("                     		AND COST_YRMON IN(" ).append("\n"); 
		query.append("              				#foreach($key IN ${slct_yrmon}) " ).append("\n"); 
		query.append("                   				#if($velocityCount < $slct_yrmon.size()) " ).append("\n"); 
		query.append("                    			'$key', " ).append("\n"); 
		query.append("                   				#else " ).append("\n"); 
		query.append("                    			'$key' " ).append("\n"); 
		query.append("                   				#end " ).append("\n"); 
		query.append("              				#end )" ).append("\n"); 
		query.append("      					#end" ).append("\n"); 
		query.append("                            AND T1.RLANE_CD <> 'RBCCO' " ).append("\n"); 
		query.append("                     ) A1 " ).append("\n"); 
		query.append("              ) B1 " ).append("\n"); 
		query.append("        GROUP BY B1.TRD_CD " ).append("\n"); 
		query.append("            , B1.RLANE_CD " ).append("\n"); 
		query.append("            , B1.DIR_CD " ).append("\n"); 
		query.append("            , B1.SUB_TRD_CD " ).append("\n"); 
		query.append("            , B1.IOC_CD " ).append("\n"); 
		query.append("            , B1.CTRT_OFC_CD " ).append("\n"); 
		query.append("            , B1.SLS_OFC_CD " ).append("\n"); 
		query.append("       ) C1 " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT TO_DATE(@[h_year]||to_char(@[h_mon],'FM00')||'01','YYYY/MM/DD') ST_DT " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("           UNION ALL " ).append("\n"); 
		query.append("       SELECT TO_DATE(@[h_year]||to_char(@[h_mon]+1, 'FM00')||'01','YYYY/MM/DD') ST_DT " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("           UNION ALL " ).append("\n"); 
		query.append("       SELECT TO_DATE(@[h_year]||to_char(@[h_mon]+2, 'FM00')||'01','YYYY/MM/DD') ST_DT " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("       ) C2" ).append("\n"); 

	}
}