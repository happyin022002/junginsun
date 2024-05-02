/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FICCostInterfaceDBDAOSearchAddOnCostTraiffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOSearchAddOnCostTraiffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Table Interface - Add on (Ocean feeder)
	  * 2013.02.27 전윤주 creation date 컬럼에 upd_dt를 보여주고 있어 에러 수정
	  * 2013.03.04 [CHM-201323352] 전윤주 AOC 테이블의 delt_flg 확인 로직 추가
	  * 2014.12.09 [CHM-201433135] [Add-on/IHC Tariff > SIN] 국가코드 ZA 추가
	  * </pre>
	  */
	public FICCostInterfaceDBDAOSearchAddOnCostTraiffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOSearchAddOnCostTraiffListRSQL").append("\n"); 
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
		query.append("WITH T AS" ).append("\n"); 
		query.append(" (SELECT COST_TRF_NO," ).append("\n"); 
		query.append("         RHQ_CD," ).append("\n"); 
		query.append("         EFF_FM_DT," ).append("\n"); 
		query.append("         SVC_SCP_CD," ).append("\n"); 
		query.append("         ORG_DEST_CD," ).append("\n"); 
		query.append("         ROW_NO" ).append("\n"); 
		query.append("    FROM (SELECT RANK() OVER(PARTITION BY A.RHQ_CD ORDER BY A.COST_TRF_NO DESC) RNK," ).append("\n"); 
		query.append("                 A.COST_TRF_NO," ).append("\n"); 
		query.append("                 A.RHQ_CD," ).append("\n"); 
		query.append("                 A.EFF_FM_DT," ).append("\n"); 
		query.append("                 B.SVC_SCP_CD," ).append("\n"); 
		query.append("                 B.ORG_DEST_CD," ).append("\n"); 
		query.append("                 (SELECT COUNT(X.COST_TRF_NO)" ).append("\n"); 
		query.append("                    FROM #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("                             AOC_EUR_FDR_TRF_DTL X " ).append("\n"); 
		query.append("                         #end " ).append("\n"); 
		query.append("                         #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                             AOC_CHN_FDR_TRF_DTL X" ).append("\n"); 
		query.append("                         #end " ).append("\n"); 
		query.append("                         #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                             AOC_CHN_FDR_TRF_DTL X" ).append("\n"); 
		query.append("                         #end " ).append("\n"); 
		query.append("                   WHERE X.COST_TRF_NO = A.COST_TRF_NO" ).append("\n"); 
		query.append("                     AND X.PCTL_IO_BND_CD IN (DECODE(B.ORG_DEST_CD,'D','I','O','O'), 'B')" ).append("\n"); 
		query.append("                     AND NVL(X.DELT_FLG, 'N') <> 'Y') ROW_NO                     " ).append("\n"); 
		query.append("            FROM #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("                     AOC_EUR_FDR_TRF_HDR  A, " ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                     AOC_CHN_FDR_TRF_HDR  A," ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                     AOC_CHN_FDR_TRF_HDR  A," ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                   SELECT DISTINCT SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  , SCP.ORG_DEST_CD" ).append("\n"); 
		query.append("                                  , RHQ.RHQ_CD" ).append("\n"); 
		query.append("                        FROM MDM_SVC_SCP_LMT SCP, MDM_REGION RGN, MDM_SVC_SCP SVC, AOC_TRF_CURR AOC_CURR," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                        #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("          /* SHARC */" ).append("\n"); 
		query.append("                            SELECT 'SHARC' AS RHQ_CD, A.CONTI_CD , B.SCONTI_CD  , C.CNT_CD  , C.CNT_NM  " ).append("\n"); 
		query.append("                            FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("                            WHERE  A.CONTI_CD = 'A'" ).append("\n"); 
		query.append("                            AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("                            AND    B.SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("                            AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("                            AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                        #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("          /* SINRS */" ).append("\n"); 
		query.append("                            SELECT 'SINRS' AS RHQ_CD, A.CONTI_CD, B.SCONTI_CD, C.CNT_CD, C.CNT_NM" ).append("\n"); 
		query.append("                            FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("                            WHERE  A.CONTI_CD IN ('A', 'F')" ).append("\n"); 
		query.append("                            AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("                            AND    B.SCONTI_CD <> 'AF'" ).append("\n"); 
		query.append("                            AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("                            AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if(${rhq_cd} == 'NYCRA')" ).append("\n"); 
		query.append("          /* NYCRA */" ).append("\n"); 
		query.append("                            SELECT 'NYCRA' AS RHQ_CD, A.CONTI_CD, B.SCONTI_CD, C.CNT_CD, C.CNT_NM" ).append("\n"); 
		query.append("                            FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("                            WHERE  A.CONTI_CD = 'M'" ).append("\n"); 
		query.append("                            AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("                            AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("                            AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if(${rhq_cd} == 'HAMRU')" ).append("\n"); 
		query.append("          /* HAMRU */" ).append("\n"); 
		query.append("                            SELECT 'HAMRU' AS RHQ_CD, A.CONTI_CD, B.SCONTI_CD, C.CNT_CD, C.CNT_NM" ).append("\n"); 
		query.append("                            FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("                            WHERE  A.CONTI_CD IN ('E', 'F')" ).append("\n"); 
		query.append("                            AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("                            AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("                            AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        #end    " ).append("\n"); 
		query.append("                            ) RHQ                                  " ).append("\n"); 
		query.append("                        WHERE  SCP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        AND    SCP.RGN_CD   = RGN.RGN_CD" ).append("\n"); 
		query.append("                        AND    RGN.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        AND    RGN.CNT_CD   = RHQ.CNT_CD" ).append("\n"); 
		query.append("                        AND    SCP.SVC_SCP_CD = SVC.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND    RGN.CNT_CD = AOC_CURR.CNT_CD" ).append("\n"); 
		query.append("                        AND    RHQ.RHQ_CD = AOC_CURR.RHQ_CD" ).append("\n"); 
		query.append("                        AND    SCP.ORG_DEST_CD = @[org_dest_tp_cd]     " ).append("\n"); 
		query.append("						AND NOT ( " ).append("\n"); 
		query.append("							(RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEE' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEF' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEE' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'IAA' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'O' and  SVC.SVC_SCP_CD = 'IAA' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'FES' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'O' and  SVC.SVC_SCP_CD = 'FEN' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("                 ) B" ).append("\n"); 
		query.append("           WHERE A.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("                 AND A.COST_TRF_STS_CD = 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '')" ).append("\n"); 
		query.append("             	 AND B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("   WHERE RNK = 1)" ).append("\n"); 
		query.append("SELECT T.COST_TRF_NO," ).append("\n"); 
		query.append("       T.RHQ_CD," ).append("\n"); 
		query.append("       TO_CHAR(T.EFF_FM_DT, 'YYYY-MM-DD') EFF_FM_DT," ).append("\n"); 
		query.append("       T.SVC_SCP_CD," ).append("\n"); 
		query.append("       T.ROW_NO," ).append("\n"); 
		query.append("       T1.FDR_TRF_NO," ).append("\n"); 
		query.append("       T1.AMDT_SEQ," ).append("\n"); 
		query.append("       T1.EFF_DT," ).append("\n"); 
		query.append("       TO_CHAR(T1.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("       T1.FIC_PROP_STS_CD," ).append("\n"); 
		query.append("       T1.FIC_PROP_STS_CD_NM," ).append("\n"); 
		query.append("       T1.FDR_COST_TRF_NO ADD_FDR_COST_TRF_NO," ).append("\n"); 
		query.append("       T.ORG_DEST_CD AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("  FROM T," ).append("\n"); 
		query.append("       (SELECT A1.SVC_SCP_CD," ).append("\n"); 
		query.append("               A1.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("               A1.FDR_TRF_NO," ).append("\n"); 
		query.append("               A1.AMDT_SEQ," ).append("\n"); 
		query.append("               B1.EFF_DT," ).append("\n"); 
		query.append("               B1.CRE_DT," ).append("\n"); 
		query.append("               B1.FIC_PROP_STS_CD," ).append("\n"); 
		query.append("               D1.INTG_CD_VAL_DP_DESC FIC_PROP_STS_CD_NM," ).append("\n"); 
		query.append("               C1.RHQ_CD," ).append("\n"); 
		query.append("               C1.FDR_COST_TRF_NO" ).append("\n"); 
		query.append("          FROM (SELECT T2.SVC_SCP_CD," ).append("\n"); 
		query.append("                       T2.FDR_TRF_NO," ).append("\n"); 
		query.append("                       T2.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                       MAX(T2.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                  FROM (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("                               ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                               RHQ_CD," ).append("\n"); 
		query.append("                               MAX(FDR_TRF_NO) FDR_TRF_NO" ).append("\n"); 
		query.append("                          FROM PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("                         GROUP BY SVC_SCP_CD," ).append("\n"); 
		query.append("                                  ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                                  RHQ_CD) T1," ).append("\n"); 
		query.append("                       PRI_TRF_FDR_MN T2" ).append("\n"); 
		query.append("                 WHERE T1.SVC_SCP_CD = T2.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND T1.FDR_TRF_NO = T2.FDR_TRF_NO" ).append("\n"); 
		query.append("                   AND T1.ORG_DEST_TP_CD = T2.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                 GROUP BY T2.SVC_SCP_CD," ).append("\n"); 
		query.append("                          T2.FDR_TRF_NO," ).append("\n"); 
		query.append("                          T2.ORG_DEST_TP_CD) A1," ).append("\n"); 
		query.append("               PRI_TRF_FDR_MN B1," ).append("\n"); 
		query.append("               (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("                       ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                       FDR_TRF_NO," ).append("\n"); 
		query.append("                       RHQ_CD," ).append("\n"); 
		query.append("                       FDR_COST_TRF_NO" ).append("\n"); 
		query.append("                  FROM PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("                 GROUP BY SVC_SCP_CD," ).append("\n"); 
		query.append("                          ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                          FDR_TRF_NO," ).append("\n"); 
		query.append("                          RHQ_CD," ).append("\n"); 
		query.append("                          FDR_COST_TRF_NO) C1,  " ).append("\n"); 
		query.append("               COM_INTG_CD_DTL D1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND A1.FDR_TRF_NO = B1.FDR_TRF_NO" ).append("\n"); 
		query.append("               AND A1.AMDT_SEQ = B1.AMDT_SEQ" ).append("\n"); 
		query.append("               AND A1.ORG_DEST_TP_CD = B1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND A1.SVC_SCP_CD = C1.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND A1.FDR_TRF_NO = C1.FDR_TRF_NO" ).append("\n"); 
		query.append("               AND A1.ORG_DEST_TP_CD = C1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND D1.INTG_CD_ID(+) = 'CD03045'" ).append("\n"); 
		query.append("               AND B1.FIC_PROP_STS_CD = D1.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("               AND A1.ORG_DEST_TP_CD = @[org_dest_tp_cd]  " ).append("\n"); 
		query.append("               ) T1" ).append("\n"); 
		query.append(" WHERE T.SVC_SCP_CD = T1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("       AND T.RHQ_CD = T1.RHQ_CD(+)" ).append("\n"); 
		query.append("	   AND T.ORG_DEST_CD = T1.ORG_DEST_TP_CD(+)" ).append("\n"); 
		query.append(" ORDER BY T.SVC_SCP_CD," ).append("\n"); 
		query.append("          T.COST_TRF_NO" ).append("\n"); 

	}
}