/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchTotalLossListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOsearchTotalLossListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTotalLossListData
	  * 2014-01-08 Jonghee HAN [CHM-201328248] Performance조회시 Recovery 금액 반영 수정 요청
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchTotalLossListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOsearchTotalLossListDataRSQL").append("\n"); 
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
		query.append("#if (${work_type} == 'collection')" ).append("\n"); 
		query.append("WITH CLT_PARAM " ).append("\n"); 
		query.append("AS (SELECT MTRD.TTL_LSS_NO, MTRD.TTL_LSS_DTL_SEQ, MTRD.MNR_INV_TP_CD, MTLC.CLT_AMT, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MTRH.TTL_LSS_DT, 'YYYYMM'), MTLC.CURR_CD, 'USD', MTLC.CLT_AMT) CLT_USD_AMT, MTLC.CURR_CD CLT_CURR_CD" ).append("\n"); 
		query.append("      FROM MNR_TTL_LSS_RQST_HDR MTRH, MNR_TTL_LSS_RQST_DTL MTRD, MNR_TTL_LSS_CLT MTLC" ).append("\n"); 
		query.append("     WHERE MTRH.TTL_LSS_NO = MTRD.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_NO = MTLC.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_DTL_SEQ IN MTLC.TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("    UNION ALL   " ).append("\n"); 
		query.append("    SELECT MTRD.TTL_LSS_NO, MTRD.TTL_LSS_DTL_SEQ, MTRD.MNR_INV_TP_CD, BOD.CLT_FRT_AMT + BOD.CLT_TAX_AMT CLT_AMT, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MTRH.TTL_LSS_DT, 'YYYYMM'), BOD.BL_CURR_CD, 'USD', BOD.CLT_FRT_AMT + BOD.CLT_TAX_AMT) CLT_USD_AMT, BOD.BL_CURR_CD CLT_CURR_CD" ).append("\n"); 
		query.append("      FROM MNR_TTL_LSS_RQST_HDR MTRH, MNR_TTL_LSS_RQST_DTL MTRD, BKG_OTS_DTL BOD" ).append("\n"); 
		query.append("     WHERE MTRH.TTL_LSS_NO = MTRD.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.INV_NO = BOD.CLT_BL_NO" ).append("\n"); 
		query.append("       AND MTRD.MNR_INV_TP_CD = 'DS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("         A.TTL_LSS_NO" ).append("\n"); 
		query.append("        ,MAX(A.RQST_OFC_CD) RQST_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(A.APRO_OFC_CD) APRO_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(DECODE(A.RESPB_OFC_CD,null,A.RQST_OFC_CD,'',A.RQST_OFC_CD,A.RESPB_OFC_CD)) AS RESPB_OFC_CD  " ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(A.TTL_LSS_DT), 'yyyy-mm-dd') TTL_LSS_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MAX(A.RQST_DT),@[user_ofc_cd]), 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append("        ,MAX(A.TTL_LSS_STS_CD) TTL_LSS_STS_CD" ).append("\n"); 
		query.append("        ,MAX(A.MNR_STS_REF_NO) MNR_STS_REF_NO" ).append("\n"); 
		query.append("        ,MAX(A.TTL_LSS_CMPL_CD) TTL_LSS_CMPL_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.TTL_LSS_CFM_DT),@[user_ofc_cd]), 'yyyy-mm-dd') TTL_LSS_CFM_DT" ).append("\n"); 
		query.append("        ,MAX(A.TTL_LSS_CFM_ID) TTL_LSS_CFM_ID" ).append("\n"); 
		query.append("        ,MAX(A.TTL_LSS_RSN_CD) TTL_LSS_RSN_CD" ).append("\n"); 
		query.append("        ,MAX(A.TTL_LSS_DTL_RSN_CD) TTL_LSS_DTL_RSN_CD" ).append("\n"); 
		query.append("        ,MAX((SELECT MNR_CD_DP_DESC " ).append("\n"); 
		query.append("          FROM MNR_GEN_CD " ).append("\n"); 
		query.append("          WHERE PRNT_CD_ID=A.TTL_LSS_RSN_CD" ).append("\n"); 
		query.append("            AND MNR_CD_ID=A.TTL_LSS_DTL_RSN_CD" ).append("\n"); 
		query.append("         )) AS TTL_LSS_DTL_RSN_NM" ).append("\n"); 
		query.append("        ,MAX(A.TTL_LSS_RMK) TTL_LSS_RMK" ).append("\n"); 
		query.append("        ,MAX(A.FILE_SEQ) FILE_SEQ" ).append("\n"); 
		query.append("        ,MAX(A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(A.CRE_DT), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,MAX(A.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(A.UPD_DT), 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DV', 1)) DV_EQ_QTY" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.DPC_VAL_AMT)) DV_DV_VAL" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DV', TTL_LSS_BIL_AMT)) DV_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) DV_BAL" ).append("\n"); 
		query.append("#if (${work_type} == 'collection')" ).append("\n"); 
		query.append("        ,SUM(DECODE(C.MNR_INV_TP_CD, 'TP', 1, 0)) TP_EQ_QTY" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'TP', B.DPC_VAL_AMT)) TP_DV_VAL" ).append("\n"); 
		query.append("        ,MAX(DECODE(C.MNR_INV_TP_CD, 'TP', C.CLT_CURR_CD)) TP_CURR_CD" ).append("\n"); 
		query.append("        ,SUM(DECODE(C.MNR_INV_TP_CD, 'TP', C.CLT_AMT)) TP_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(C.MNR_INV_TP_CD, 'TP', C.CLT_USD_AMT)) TP_USD_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'TP', B.DPC_VAL_AMT)) - SUM(DECODE(C.MNR_INV_TP_CD, 'TP', C.CLT_AMT)) TP_BAL" ).append("\n"); 
		query.append("        ,SUM(DECODE(C.MNR_INV_TP_CD, 'DS', 1, 0)) DS_EQ_QTY" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DS', B.DPC_VAL_AMT)) DS_DV_VAL" ).append("\n"); 
		query.append("        ,MAX(DECODE(C.MNR_INV_TP_CD, 'DS', C.CLT_CURR_CD)) DS_CURR_CD" ).append("\n"); 
		query.append("        ,SUM(DECODE(C.MNR_INV_TP_CD, 'DS', C.CLT_AMT)) DS_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(C.MNR_INV_TP_CD, 'DS', C.CLT_USD_AMT)) DS_USD_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DS', B.DPC_VAL_AMT)) - SUM(DECODE(C.MNR_INV_TP_CD, 'DS', C.CLT_AMT)) DS_BAL" ).append("\n"); 
		query.append("#else       " ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'TP', 1)) TP_EQ_QTY" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'TP', B.DPC_VAL_AMT)) TP_DV_VAL" ).append("\n"); 
		query.append("        ,MAX(DECODE(B.MNR_INV_TP_CD, 'TP', B.CURR_CD)) TP_CURR_CD" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'TP', TTL_LSS_BIL_AMT)) TP_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'TP', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(A.TTL_LSS_DT, 'YYYYMM'), B.CURR_CD, 'USD', B.TTL_LSS_BIL_AMT))) TP_USD_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'TP', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) TP_BAL  " ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DS', 1)) DS_EQ_QTY" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DS', B.DPC_VAL_AMT)) DS_DV_VAL" ).append("\n"); 
		query.append("        ,MAX(DECODE(B.MNR_INV_TP_CD, 'DS', B.CURR_CD)) DS_CURR_CD" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DS', TTL_LSS_BIL_AMT)) DS_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DS', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(A.TTL_LSS_DT, 'YYYYMM'), B.CURR_CD, 'USD', B.TTL_LSS_BIL_AMT))) DS_USD_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'DS', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) DS_VAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'SC', 1)) SC_EQ_QTY" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'SC', B.DPC_VAL_AMT)) SC_DV_VAL" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'SC', TTL_LSS_INCM_AMT)) + SUM(DECODE(B.MNR_INV_TP_CD, 'SC', NVL(B.TTL_LSS_EXPN_AMT,0))) SC_EXP" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'SC', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) SC_VAL" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'IR', 1)) IR_EQ_QTY" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'IR', B.DPC_VAL_AMT)) IR_DV_VAL" ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'IR', TTL_LSS_EXPN_AMT)) IR_EXP  " ).append("\n"); 
		query.append("        ,SUM(DECODE(B.MNR_INV_TP_CD, 'IR', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) IR_VAL       " ).append("\n"); 
		query.append("		,TO_CHAR(MAX(A.ACC_DT), 'yyyy-mm-dd') ACC_DT" ).append("\n"); 
		query.append("        ,A.ACC_FLG" ).append("\n"); 
		query.append("        ,A.ACC_VSL_CD" ).append("\n"); 
		query.append("        ,A.ACC_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.ACC_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A.ACC_PORT_CD" ).append("\n"); 
		query.append("  FROM MNR_TTL_LSS_RQST_HDR A, MNR_TTL_LSS_RQST_DTL B" ).append("\n"); 
		query.append("#if (${work_type} == 'collection')" ).append("\n"); 
		query.append("     , CLT_PARAM C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE A.TTL_LSS_NO = B.TTL_LSS_NO" ).append("\n"); 
		query.append("#if (${work_type} == 'collection')" ).append("\n"); 
		query.append("   AND C.TTL_LSS_NO(+) = B.TTL_LSS_NO" ).append("\n"); 
		query.append("   AND C.TTL_LSS_DTL_SEQ(+) IN B.TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_search_dt_tp} == 'R')" ).append("\n"); 
		query.append("   AND A.RQST_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[in_st_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[in_end_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999    " ).append("\n"); 
		query.append("#elseif (${in_search_dt_tp} == 'T')" ).append("\n"); 
		query.append("   AND A.TTL_LSS_DT BETWEEN TO_DATE(@[in_st_dt], 'yyyy-mm-dd') AND TO_DATE(@[in_end_dt], 'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("#elseif (${in_search_dt_tp} == 'C')" ).append("\n"); 
		query.append("   AND A.TTL_LSS_CFM_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[in_st_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[in_end_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${work_type} == 'collection')" ).append("\n"); 
		query.append("   #if (${rhq_ofc_cd} != 'NYCRA')		" ).append("\n"); 
		query.append("	   #if (${in_ofc_cd_tp} == 'R')" ).append("\n"); 
		query.append("	      AND (A.RQST_OFC_CD = @[in_rqst_ofc_cd]  OR A.RESPB_OFC_CD = @[in_rqst_ofc_cd])  " ).append("\n"); 
		query.append("	   #else " ).append("\n"); 
		query.append("	      AND A.APRO_OFC_CD = @[in_rqst_ofc_cd]" ).append("\n"); 
		query.append("	   #end " ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("	   #if (${in_ofc_cd_tp} == 'R')" ).append("\n"); 
		query.append("		  AND (A.RQST_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                           FROM MNR_OFC_GEN_INFO" ).append("\n"); 
		query.append("                          WHERE COST_CD = 'RPRINV'" ).append("\n"); 
		query.append("                            AND MNR_GRP_TP_CD = 'OFC')" ).append("\n"); 
		query.append("    	   OR A.RESPB_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                           FROM MNR_OFC_GEN_INFO" ).append("\n"); 
		query.append("                          WHERE COST_CD = 'RPRINV'" ).append("\n"); 
		query.append("                            AND MNR_GRP_TP_CD = 'OFC'))" ).append("\n"); 
		query.append("	   #else " ).append("\n"); 
		query.append("	      AND (A.APRO_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                           FROM MNR_OFC_GEN_INFO" ).append("\n"); 
		query.append("                          WHERE COST_CD = 'RPRINV'" ).append("\n"); 
		query.append("                            AND MNR_GRP_TP_CD = 'OFC'))	" ).append("\n"); 
		query.append("	   #end  " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${in_status_tp} == 'P')" ).append("\n"); 
		query.append("     AND A.TTL_LSS_STS_CD IN ('HA','HC')" ).append("\n"); 
		query.append("   #else " ).append("\n"); 
		query.append("     AND A.TTL_LSS_STS_CD IN ('HE')" ).append("\n"); 
		query.append("   #end " ).append("\n"); 
		query.append("#elseif (${work_type} == 'management')" ).append("\n"); 
		query.append("AND A.TTL_LSS_STS_CD IN ('HR', 'AA')" ).append("\n"); 
		query.append("AND A.APRO_OFC_CD = @[in_rqst_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_ttl_lss_no} != '')" ).append("\n"); 
		query.append("        AND A.TTL_LSS_NO IN (" ).append("\n"); 
		query.append("                #foreach ($userTtlNo IN ${ttlNos})" ).append("\n"); 
		query.append("                        #if($velocityCount < $ttlNos.size())" ).append("\n"); 
		query.append("                                '$userTtlNo'," ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                                '$userTtlNo'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                #end                      " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_rqst_eq_no} != '')" ).append("\n"); 
		query.append("	AND A.TTL_LSS_NO IN ( SELECT DISTINCT TTL_LSS_NO " ).append("\n"); 
		query.append("							FROM MNR_TTL_LSS_RQST_DTL" ).append("\n"); 
		query.append("							WHERE RQST_EQ_NO IN (" ).append("\n"); 
		query.append("								#foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("									#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("										'$user_eq_no'," ).append("\n"); 
		query.append("									#else" ).append("\n"); 
		query.append("										'$user_eq_no'" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.TTL_LSS_NO" ).append("\n"); 
		query.append("        ,A.ACC_DT" ).append("\n"); 
		query.append("        ,A.ACC_FLG" ).append("\n"); 
		query.append("        ,A.ACC_VSL_CD" ).append("\n"); 
		query.append("        ,A.ACC_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.ACC_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A.ACC_PORT_CD" ).append("\n"); 

	}
}