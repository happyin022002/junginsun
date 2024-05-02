/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.29 
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

public class TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTotalLossLessorReportListData
	  * </pre>
	  */
	public TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL").append("\n"); 
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
		query.append("WITH TOTAL_LOSS AS (" ).append("\n"); 
		query.append("        SELECT DECODE(EV.LESSOR_CD, '0', (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("                          FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("                         WHERE EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("                           AND ROWNUM = 1), EV.LESSOR_CD) LESSOR_CD," ).append("\n"); 
		query.append("               DECODE(EV.LESSOR_CD, '0', (SELECT B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                          FROM CGM_EQUIPMENT A," ).append("\n"); 
		query.append("                               MDM_VENDOR B" ).append("\n"); 
		query.append("                         WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                           AND A.EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("                           AND ROWNUM = 1), EV.LESSOR_NM) LESSOR_NM," ).append("\n"); 
		query.append("               DECODE(RD.EQ_KND_CD, 'U', 'Container', 'G', 'MG Set', 'Z', 'Chassis') EQ_TYPE," ).append("\n"); 
		query.append("               RD.RQST_EQ_NO EQ_NO," ).append("\n"); 
		query.append("               RD.INV_NO INV_NO," ).append("\n"); 
		query.append("               RD.TTL_LSS_NO," ).append("\n"); 
		query.append("               RD.TTL_LSS_DTL_SEQ," ).append("\n"); 
		query.append("               TO_CHAR(RH.RQST_DT, 'YYYY-MM-DD') RQST_DT," ).append("\n"); 
		query.append("               TO_CHAR(RH.TTL_LSS_CFM_DT, 'YYYY-MM-DD') TTL_LSS_CFM_DT," ).append("\n"); 
		query.append("               (SELECT MNR_CD_DESC" ).append("\n"); 
		query.append("                  FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                 WHERE PRNT_CD_ID = 'TR'" ).append("\n"); 
		query.append("                   AND MNR_CD_ID = RH.TTL_LSS_RSN_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) TTL_LSS_RSN_NM," ).append("\n"); 
		query.append("               DECODE(RD.TTL_LSS_CMPL_DT, NULL, 'N', 'Y') CMPL_FLG," ).append("\n"); 
		query.append("               TO_CHAR(RH.TTL_LSS_DT, 'YYYY-MM-DD') TLL_DT," ).append("\n"); 
		query.append("               RD.DPC_VAL_AMT DV_VALUE," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                         WHEN RD.EQ_KND_CD = 'U' THEN (SELECT AGMT_CTY_CD||LPAD(AGMT_SEQ, 6, 0)" ).append("\n"); 
		query.append("                  FROM MST_CONTAINER" ).append("\n"); 
		query.append("                 WHERE CNTR_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1)" ).append("\n"); 
		query.append("                         ELSE (SELECT AGMT_OFC_CTY_CD||LPAD(AGMT_SEQ, 6, 0)" ).append("\n"); 
		query.append("                  FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("                 WHERE EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1)" ).append("\n"); 
		query.append("                       END AGMT_NO" ).append("\n"); 
		query.append("          FROM MNR_TTL_LSS_RQST_HDR RH," ).append("\n"); 
		query.append("               MNR_TTL_LSS_RQST_DTL RD," ).append("\n"); 
		query.append("               MNR_EQ_STS_V EV" ).append("\n"); 
		query.append("         WHERE RH.TTL_LSS_NO = RD.TTL_LSS_NO" ).append("\n"); 
		query.append("           AND RH.RQST_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD')+0.99999  " ).append("\n"); 
		query.append("           AND RD.RQST_EQ_NO = EV.EQ_NO" ).append("\n"); 
		query.append("           AND RD.MNR_INV_TP_CD IN ('DV')" ).append("\n"); 
		query.append("--           AND EV.LSTM_CD IN ('LT', 'ST') " ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("       COLLECTION AS (" ).append("\n"); 
		query.append("        SELECT A.TTL_LSS_NO," ).append("\n"); 
		query.append("               C.RQST_EQ_NO EQ_NO," ).append("\n"); 
		query.append("               NVL(TO_NUMBER(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(B.TTL_LSS_CFM_DT, 'YYYYMM'), A.CURR_CD, 'USD', A.CLT_AMT, 3))), 0) CLT_AMT" ).append("\n"); 
		query.append("          FROM MNR_TTL_LSS_CLT A," ).append("\n"); 
		query.append("               MNR_TTL_LSS_RQST_HDR B," ).append("\n"); 
		query.append("               MNR_TTL_LSS_RQST_DTL C" ).append("\n"); 
		query.append("         WHERE A.TTL_LSS_NO = B.TTL_LSS_NO" ).append("\n"); 
		query.append("           AND A.TTL_LSS_NO = C.TTL_LSS_NO" ).append("\n"); 
		query.append("           AND A.TTL_LSS_DTL_SEQ = C.TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("           AND B.RQST_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD')+0.99999  " ).append("\n"); 
		query.append("         GROUP BY A.TTL_LSS_NO," ).append("\n"); 
		query.append("               B.TTL_LSS_CFM_DT," ).append("\n"); 
		query.append("               C.RQST_EQ_NO)" ).append("\n"); 
		query.append("SELECT TL.LESSOR_CD," ).append("\n"); 
		query.append("       TL.LESSOR_NM," ).append("\n"); 
		query.append("       TL.EQ_TYPE," ).append("\n"); 
		query.append("       TL.EQ_NO," ).append("\n"); 
		query.append("       TL.INV_NO," ).append("\n"); 
		query.append("       TL.TTL_LSS_NO," ).append("\n"); 
		query.append("       TL.RQST_DT," ).append("\n"); 
		query.append("       TL.TTL_LSS_CFM_DT," ).append("\n"); 
		query.append("       TL.TTL_LSS_RSN_NM," ).append("\n"); 
		query.append("       TL.CMPL_FLG," ).append("\n"); 
		query.append("       TL.TLL_DT," ).append("\n"); 
		query.append("       ROUND(TL.DV_VALUE, 2) DV_VALUE," ).append("\n"); 
		query.append("       ROUND(CL.CLT_AMT, 2) CLT_AMT," ).append("\n"); 
		query.append("       TL.AGMT_NO" ).append("\n"); 
		query.append("  FROM TOTAL_LOSS TL," ).append("\n"); 
		query.append("       COLLECTION CL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND TL.TTL_LSS_NO = CL.TTL_LSS_NO (+)" ).append("\n"); 
		query.append("   AND TL.EQ_NO = CL.EQ_NO (+)" ).append("\n"); 

	}
}