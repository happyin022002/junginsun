/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FICCostInterfaceDBDAOSearchIhcCostTariffInterfaceListRSQL.java
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

public class FICCostInterfaceDBDAOSearchIhcCostTariffInterfaceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IHC(Barge/Rail/Truck) Cost tariff Interface
	  * 2013.02.27 전윤주 creation date 컬럼에 upd_dt를 보여주고 있어 에러 수정
	  * 2013.03.04 [CHM-201323352] 전윤주 AOC 테이블의 delt_flg 확인 로직 추가
	  * 2013.05.29 [CHM-201324375] 4개의 Scope의 대해서는 confirm status를 publish 로 변경하여 조회
	  * [CHM-201433135] [Add-on/IHC Tariff > SIN] 국가코드 ZA
	  * </pre>
	  */
	public FICCostInterfaceDBDAOSearchIhcCostTariffInterfaceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : FICCostInterfaceDBDAOSearchIhcCostTariffInterfaceListRSQL").append("\n"); 
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
		query.append(" (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("         CNT_CD," ).append("\n"); 
		query.append("         CNT_NM," ).append("\n"); 
		query.append("         IO_BND_CD," ).append("\n"); 
		query.append("         COST_TRF_NO," ).append("\n"); 
		query.append("         EFF_FM_DT," ).append("\n"); 
		query.append("         ROW_NO," ).append("\n"); 
		query.append("         CRE_DT," ).append("\n"); 
		query.append("         @[rhq_cd] AS RHQ_CD" ).append("\n"); 
		query.append("    FROM (SELECT RANK() OVER(PARTITION BY A.CNT_CD, A.IO_BND_CD ORDER BY A.COST_TRF_NO DESC) RNK," ).append("\n"); 
		query.append("                 B.SVC_SCP_CD," ).append("\n"); 
		query.append("                 B.CNT_CD," ).append("\n"); 
		query.append("                 C.CNT_NM," ).append("\n"); 
		query.append("                 A.IO_BND_CD," ).append("\n"); 
		query.append("                 A.COST_TRF_NO," ).append("\n"); 
		query.append("                 A.EFF_FM_DT," ).append("\n"); 
		query.append("                 A.CRE_DT," ).append("\n"); 
		query.append("                 (SELECT COUNT(T1.COST_TRF_NO) " ).append("\n"); 
		query.append("                    FROM #if(${rhq_cd} == 'NYCRA')" ).append("\n"); 
		query.append("                             AOC_USA_INLND_TRF_DTL T1  " ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("                             AOC_EUR_INLND_TRF_DTL T1 " ).append("\n"); 
		query.append("                         #end " ).append("\n"); 
		query.append("                         #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                             AOC_CHN_INLND_TRF_DTL T1" ).append("\n"); 
		query.append("                         #end " ).append("\n"); 
		query.append("                         #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                             AOC_CHN_INLND_TRF_DTL T1" ).append("\n"); 
		query.append("                         #end    " ).append("\n"); 
		query.append("                   WHERE T1.COST_TRF_NO = A.COST_TRF_NO AND T1.COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("                     AND NVL(T1.DELT_FLG, 'N') <> 'Y') ROW_NO" ).append("\n"); 
		query.append("            FROM #if(${rhq_cd} == 'NYCRA')" ).append("\n"); 
		query.append("                     AOC_USA_INLND_TRF_HDR A,  " ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("                     AOC_EUR_INLND_TRF_HDR A, " ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                     AOC_CHN_INLND_TRF_HDR A," ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                     AOC_CHN_INLND_TRF_HDR A," ).append("\n"); 
		query.append("                 #end    " ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                   SELECT DISTINCT SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  , DECODE(SCP.ORG_DEST_CD,'D','I','O','O') AS PRC_IO_BND_CD" ).append("\n"); 
		query.append("                                  , RGN.CNT_CD                 " ).append("\n"); 
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
		query.append("						AND NOT ( " ).append("\n"); 
		query.append("							(RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEE' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEF' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEE' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'IAA' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'O' and  SVC.SVC_SCP_CD = 'IAA' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'FES' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("							OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'O' and  SVC.SVC_SCP_CD = 'FEN' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("                        AND    SCP.ORG_DEST_CD = @[org_dest_tp_cd]                 " ).append("\n"); 
		query.append("                 ) B," ).append("\n"); 
		query.append("                 MDM_COUNTRY C" ).append("\n"); 
		query.append("           WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("             AND A.IO_BND_CD = B.PRC_IO_BND_CD" ).append("\n"); 
		query.append("             AND B.CNT_CD = C.CNT_CD(+)" ).append("\n"); 
		query.append("             AND A.COST_TRF_STS_CD = 'C'" ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '')" ).append("\n"); 
		query.append("             AND B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if(${cnt_cd} != '')  " ).append("\n"); 
		query.append("	         AND B.CNT_CD  IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cnt_cd}) " ).append("\n"); 
		query.append("	           #if($velocityCount < $cnt_cd.size())" ).append("\n"); 
		query.append("					'$key'," ).append("\n"); 
		query.append("			   #else" ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("			   #end	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   WHERE RNK = 1)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("SELECT T.SVC_SCP_CD," ).append("\n"); 
		query.append("       T.CNT_CD," ).append("\n"); 
		query.append("       T.CNT_NM," ).append("\n"); 
		query.append("       T.COST_TRF_NO," ).append("\n"); 
		query.append("       T.EFF_FM_DT," ).append("\n"); 
		query.append("       T.ROW_NO," ).append("\n"); 
		query.append("       V1.IHC_TRF_NO," ).append("\n"); 
		query.append("       V1.AMDT_SEQ," ).append("\n"); 
		query.append("       V1.EFF_DT," ).append("\n"); 
		query.append("       V1.CRE_DT," ).append("\n"); 
		query.append("       V1.FIC_PROP_STS_CD," ).append("\n"); 
		query.append("       V1.FIC_PROP_STS_CD_NM," ).append("\n"); 
		query.append("       '0' CHK," ).append("\n"); 
		query.append("       V1.COST_TRF_NO IHC_COST_TRF_NO," ).append("\n"); 
		query.append("       DECODE(T.IO_BND_CD,'I','D','O','O') ORG_DEST_TP_CD," ).append("\n"); 
		query.append("       T.RHQ_CD" ).append("\n"); 
		query.append("  FROM T," ).append("\n"); 
		query.append("       (SELECT H1.SVC_SCP_CD," ).append("\n"); 
		query.append("               H1.IHC_TRF_NO," ).append("\n"); 
		query.append("               H1.COST_TRF_NO," ).append("\n"); 
		query.append("               M1.AMDT_SEQ," ).append("\n"); 
		query.append("               M2.EFF_DT," ).append("\n"); 
		query.append("               M2.CRE_DT," ).append("\n"); 
		query.append("               M2.FIC_PROP_STS_CD,                " ).append("\n"); 
		query.append("               CASE WHEN" ).append("\n"); 
		query.append("               H1.SVC_SCP_CD IN ('TAW', 'TAE', 'ASW', 'ASE') AND M2.FIC_PROP_STS_CD = 'C' THEN 'Published'" ).append("\n"); 
		query.append("               ELSE C1.INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("               END FIC_PROP_STS_CD_NM," ).append("\n"); 
		query.append("               H1.COST_CNT_CD," ).append("\n"); 
		query.append("               H1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_HDR H1," ).append("\n"); 
		query.append("               (SELECT X2.SVC_SCP_CD," ).append("\n"); 
		query.append("                       X2.IHC_TRF_NO," ).append("\n"); 
		query.append("                       X2.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                       MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                  FROM (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("                               ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                               MAX(IHC_TRF_NO) IHC_TRF_NO" ).append("\n"); 
		query.append("                          FROM PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("                         GROUP BY SVC_SCP_CD, COST_CNT_CD, ORG_DEST_TP_CD) X1," ).append("\n"); 
		query.append("                       PRI_TRF_IHC_MN X2" ).append("\n"); 
		query.append("                 WHERE X1.SVC_SCP_CD = X2.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND X1.IHC_TRF_NO = X2.IHC_TRF_NO" ).append("\n"); 
		query.append("                   AND X1.ORG_DEST_TP_CD = X2.ORG_DEST_TP_CD                   " ).append("\n"); 
		query.append("                 GROUP BY X2.SVC_SCP_CD," ).append("\n"); 
		query.append("                          X2.IHC_TRF_NO," ).append("\n"); 
		query.append("                          X2.ORG_DEST_TP_CD) M1," ).append("\n"); 
		query.append("               PRI_TRF_IHC_MN M2," ).append("\n"); 
		query.append("               COM_INTG_CD_DTL C1" ).append("\n"); 
		query.append("         WHERE H1.SVC_SCP_CD = M1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND M1.SVC_SCP_CD = M2.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND H1.IHC_TRF_NO = M1.IHC_TRF_NO           " ).append("\n"); 
		query.append("           AND M1.IHC_TRF_NO = M2.IHC_TRF_NO" ).append("\n"); 
		query.append("           AND H1.ORG_DEST_TP_CD = M1.ORG_DEST_TP_CD           " ).append("\n"); 
		query.append("           AND M1.ORG_DEST_TP_CD = M2.ORG_DEST_TP_CD           " ).append("\n"); 
		query.append("           AND M1.AMDT_SEQ = M2.AMDT_SEQ" ).append("\n"); 
		query.append("           AND M2.FIC_PROP_STS_CD = C1.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("           AND C1.INTG_CD_ID(+) = 'CD03045'" ).append("\n"); 
		query.append("           AND H1.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("           ) V1" ).append("\n"); 
		query.append(" WHERE T.SVC_SCP_CD = V1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("       AND T.CNT_CD = V1.COST_CNT_CD(+)" ).append("\n"); 
		query.append(" ORDER BY T.SVC_SCP_CD, T.CNT_CD" ).append("\n"); 

	}
}