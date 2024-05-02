/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLogisticsRPT0158ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LogisticsRPTDBDAOSearchLogisticsRPT0158ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Logistics Vol  by Office[esm_mas_0158화면]
	  * 2011.01.25 송민석: CHM-201108507-01 MEXBA 조회되도록 수정(OFC_GRP_NO 컬럼 추가)
	  * 2011.06.21 이석준 [CHM-201111642-01] 
	  *                  MAS Logistics Exp. By Office화면에서 R.Month / S.Month 구분요청
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchLogisticsRPT0158ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration").append("\n"); 
		query.append("FileName : LogisticsRPTDBDAOSearchLogisticsRPT0158ListVORSQL").append("\n"); 
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
		query.append("/*Sales & Inland Vol.*/" ).append("\n"); 
		query.append("WITH " ).append("\n"); 
		query.append("CONV_MAS_OFC_LVL AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        CURR.OFC_CD" ).append("\n"); 
		query.append("        ,LVL.OFC_CD AS OLD_OFC" ).append("\n"); 
		query.append("        , LVL.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("        , LVL.OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("        , LVL.OFC_LVL" ).append("\n"); 
		query.append("        , LVL.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N2ND_LVL_TP_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N4TH_LVL_TP_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N5TH_LVL_TP_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N6TH_LVL_TP_CD" ).append("\n"); 
		query.append("        , LVL.PRNT_OFC_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("        , LVL.OFC_N7TH_LVL_TP_CD" ).append("\n"); 
		query.append("        , LVL.CRE_USR_ID" ).append("\n"); 
		query.append("        , LVL.CRE_DT" ).append("\n"); 
		query.append("        , LVL.UPD_USR_ID" ).append("\n"); 
		query.append("        , LVL.UPD_DT" ).append("\n"); 
		query.append("        , LVL.OFC_GRP_NO" ).append("\n"); 
		query.append("	FROM (    " ).append("\n"); 
		query.append("	    SELECT ROW_NUMBER() OVER (PARTITION BY LVL_CURR.OFC_GRP_NO ORDER BY LVL_CURR.OFC_APLY_TO_YRMON DESC ) NUM" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_LVL" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N2ND_LVL_TP_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N4TH_LVL_TP_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N5TH_LVL_TP_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N6TH_LVL_TP_CD" ).append("\n"); 
		query.append("		, LVL_CURR.PRNT_OFC_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_N7TH_LVL_TP_CD" ).append("\n"); 
		query.append("		, LVL_CURR.CRE_USR_ID" ).append("\n"); 
		query.append("		, LVL_CURR.CRE_DT" ).append("\n"); 
		query.append("		, LVL_CURR.UPD_USR_ID" ).append("\n"); 
		query.append("		, LVL_CURR.UPD_DT" ).append("\n"); 
		query.append("		, LVL_CURR.OFC_GRP_NO" ).append("\n"); 
		query.append("	    FROM  MAS_OFC_LVL LVL_CURR" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	) CURR , MAS_OFC_LVL LVL" ).append("\n"); 
		query.append("	WHERE CURR.NUM =1" ).append("\n"); 
		query.append("	AND CURR.OFC_GRP_NO = LVL.OFC_GRP_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	ORDER BY CURR.OFC_GRP_NO" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append(" QTY AS" ).append("\n"); 
		query.append("  (SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("           D.P_REPORT" ).append("\n"); 
		query.append("          ,D.P_SPLIT_MW" ).append("\n"); 
		query.append("          ,D.P_CHKPRD" ).append("\n"); 
		query.append("          ,D.P_RHQ_CD" ).append("\n"); 
		query.append("          ,D.P_CTRL_OFC_CD" ).append("\n"); 
		query.append("          ,DECODE(D.P_SPLIT_MW||D.P_CHKPRD, 'TW', A.SLS_YRMON, 'X') AS COST_YRMON" ).append("\n"); 
		query.append("          ,DECODE(D.P_SPLIT_MW||D.P_CHKPRD, 'TW', A.COST_YRMON, 'TM', A.COST_YRMON, 'X') AS COST_RMON" ).append("\n"); 
		query.append("          ,DECODE(D.P_SPLIT_MW||D.P_CHKPRD, 'TW', A.COST_WK, 'X') AS COST_WK" ).append("\n"); 
		query.append("          ,DECODE(D.P_REPORT, 1, 'X', F.OFC_N2ND_LVL_CD) AS RHQ_OUT" ).append("\n"); 
		query.append("          ,DECODE(D.P_REPORT, 1, 'X', H.OFC_N2ND_LVL_CD) AS RHQ_IN" ).append("\n"); 
		query.append("          ,DECODE(D.P_REPORT, 3, F.OFC_N5TH_LVL_CD, 'X') AS OFC_OUT" ).append("\n"); 
		query.append("          ,DECODE(D.P_REPORT, 3, H.OFC_N5TH_LVL_CD, 'X') AS OFC_IN" ).append("\n"); 
		query.append("          ,A.BKG_POL_CD" ).append("\n"); 
		query.append("          ,A.BKG_POR_CD" ).append("\n"); 
		query.append("          ,A.BKG_POD_CD" ).append("\n"); 
		query.append("          ,A.BKG_DEL_CD" ).append("\n"); 
		query.append("          ,SUM(A.BKG_QTY) AS BKG_QTY_BOX" ).append("\n"); 
		query.append("          ,SUM(DECODE(SUBSTR(A.SPCL_CNTR_TPSZ_CD,-1,1),'2', A.BKG_QTY, '3', A.BKG_QTY, A.BKG_QTY*2)) AS BKG_QTY_TEU" ).append("\n"); 
		query.append("     FROM (SELECT '${f_report}' P_REPORT" ).append("\n"); 
		query.append("                 ,'${f_rhq_cd}' P_RHQ_CD" ).append("\n"); 
		query.append("                 ,'${f_ctrl_ofc_cd}' P_CTRL_OFC_CD" ).append("\n"); 
		query.append("                 ,'${f_split_mw}' P_SPLIT_MW" ).append("\n"); 
		query.append("                 ,'${f_year}' P_YEAR" ).append("\n"); 
		query.append("                 ,'${f_fm_mon}' P_FM_MON" ).append("\n"); 
		query.append("                 ,'${f_to_mon}' P_TO_MON" ).append("\n"); 
		query.append("                 ,'${f_sls_mon}' P_SLS_MON" ).append("\n"); 
		query.append("                 ,'${f_fm_wk}' P_FM_WK" ).append("\n"); 
		query.append("                 ,'${f_to_wk}' P_TO_WK" ).append("\n"); 
		query.append("                 ,'${f_chkprd}' P_CHKPRD" ).append("\n"); 
		query.append("            FROM DUAL ) D" ).append("\n"); 
		query.append("#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("          ,MAS_BKG_EXPN_DTL A" ).append("\n"); 
		query.append("#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("          ,MAS_BKG_EXPN_DTL_WK A" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ,MDM_LOCATION E" ).append("\n"); 
		query.append("          ,CONV_MAS_OFC_LVL F" ).append("\n"); 
		query.append("          ,MDM_LOCATION G" ).append("\n"); 
		query.append("          ,CONV_MAS_OFC_LVL H" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("#if ( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("        AND A.COST_YRMON BETWEEN D.P_YEAR||D.P_FM_MON AND D.P_YEAR||D.P_TO_MON" ).append("\n"); 
		query.append("        AND A.COST_YRMON BETWEEN F.OFC_APLY_FM_YRMON AND F.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("        AND A.COST_YRMON BETWEEN H.OFC_APLY_FM_YRMON AND H.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#elseif ( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("        AND SUBSTR(A.SLS_YRMON, 1, 4)||A.COST_WK BETWEEN D.P_YEAR||D.P_FM_WK AND D.P_YEAR||P_TO_WK" ).append("\n"); 
		query.append("    #if ( ${f_sls_mon} != '' )" ).append("\n"); 
		query.append("        AND A.SLS_YRMON = D.P_YEAR||D.P_SLS_MON" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        AND A.SLS_YRMON BETWEEN F.OFC_APLY_FM_YRMON AND F.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("        AND A.SLS_YRMON BETWEEN H.OFC_APLY_FM_YRMON AND H.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND A.BKG_STS_CD IN ('F', 'S')" ).append("\n"); 
		query.append("        AND A.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("        AND NVL(A.DELT_FLG, 'N') ='N'" ).append("\n"); 
		query.append("        AND A.BL_NO_TP IN ('M', '0')" ).append("\n"); 
		query.append("        AND A.BKG_POR_CD = E.LOC_CD" ).append("\n"); 
		query.append("        AND F.OFC_CD =  NVL(E.FINC_CTRL_OFC_CD, NVL(E.EQ_CTRL_OFC_CD, E.SLS_OFC_CD))" ).append("\n"); 
		query.append("        AND A.BKG_DEL_CD = G.LOC_CD" ).append("\n"); 
		query.append("        AND H.OFC_CD =  NVL(G.FINC_CTRL_OFC_CD, NVL(G.EQ_CTRL_OFC_CD, G.SLS_OFC_CD))" ).append("\n"); 
		query.append("        AND NVL(E.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("        AND NVL(G.DELT_FLG, 'N') = 'N'  " ).append("\n"); 
		query.append("        AND ( DECODE(D.P_RHQ_CD, '', F.OFC_N2ND_LVL_CD, D.P_RHQ_CD) = F.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("           OR DECODE(D.P_RHQ_CD, '', H.OFC_N2ND_LVL_CD, D.P_RHQ_CD) = H.OFC_N2ND_LVL_CD )" ).append("\n"); 
		query.append("        AND ( DECODE(D.P_CTRL_OFC_CD, '', F.OFC_N5TH_LVL_CD, D.P_CTRL_OFC_CD) = F.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("           OR DECODE(D.P_CTRL_OFC_CD, '', H.OFC_N5TH_LVL_CD, D.P_CTRL_OFC_CD) = H.OFC_N5TH_LVL_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      GROUP BY DECODE(D.P_SPLIT_MW||D.P_CHKPRD, 'TW', A.SLS_YRMON, 'X')" ).append("\n"); 
		query.append("          	  ,DECODE(D.P_SPLIT_MW||D.P_CHKPRD, 'TW', A.COST_YRMON, 'TM', A.COST_YRMON, 'X')" ).append("\n"); 
		query.append("              ,DECODE(D.P_SPLIT_MW||D.P_CHKPRD, 'TW', A.COST_WK, 'X')" ).append("\n"); 
		query.append("              ,DECODE(D.P_REPORT, 1, 'X', D.P_RHQ_CD)" ).append("\n"); 
		query.append("              ,DECODE(D.P_REPORT, 3, D.P_CTRL_OFC_CD, 'X') " ).append("\n"); 
		query.append("              ,DECODE(D.P_REPORT, 1, 'X', F.OFC_N2ND_LVL_CD)" ).append("\n"); 
		query.append("              ,DECODE(D.P_REPORT, 1, 'X', H.OFC_N2ND_LVL_CD)" ).append("\n"); 
		query.append("              ,DECODE(D.P_REPORT, 3, H.OFC_N5TH_LVL_CD, 'X')" ).append("\n"); 
		query.append("              ,DECODE(D.P_REPORT, 3, F.OFC_N5TH_LVL_CD, 'X')" ).append("\n"); 
		query.append("              ,A.BKG_POL_CD" ).append("\n"); 
		query.append("              ,A.BKG_POR_CD" ).append("\n"); 
		query.append("              ,A.BKG_POD_CD" ).append("\n"); 
		query.append("              ,A.BKG_DEL_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      /*Sales Vol. */" ).append("\n"); 
		query.append("      SELECT P_REPORT" ).append("\n"); 
		query.append("#if(${f_chkprd} =='W' && ${f_split_mw} =='T')" ).append("\n"); 
		query.append("            ,COST_YRMON || COST_WK AS COST_YRMONWK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            ,COST_RMON || COST_WK AS COST_YRMONWK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ,COST_YRMON" ).append("\n"); 
		query.append("            ,COST_RMON" ).append("\n"); 
		query.append("            ,COST_WK" ).append("\n"); 
		query.append("            ,RHQ_CD" ).append("\n"); 
		query.append("            ,CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,'V' AS COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("            ,'VOL' AS LGS_KPI_COST_GRP_NM" ).append("\n"); 
		query.append("            ,KPI_CD" ).append("\n"); 
		query.append("            ,KPI_NM" ).append("\n"); 
		query.append("            ,SUM(BKG_QTY_TEU) AS VOL" ).append("\n"); 
		query.append("            ,NULL AS TOTAL_COST" ).append("\n"); 
		query.append("            ,NULL AS UNIT_COST" ).append("\n"); 
		query.append("            ,'1' AS KPI_ORDER" ).append("\n"); 
		query.append("      FROM ( /*SALES VOL. OUTBOUND    */" ).append("\n"); 
		query.append("             SELECT QTY.P_REPORT" ).append("\n"); 
		query.append("                   ,QTY.COST_YRMON" ).append("\n"); 
		query.append("                   ,QTY.COST_RMON" ).append("\n"); 
		query.append("                   ,QTY.COST_WK" ).append("\n"); 
		query.append("                   ,RHQ_OUT AS RHQ_CD" ).append("\n"); 
		query.append("                   ,OFC_OUT AS CTRL_OFC_CD" ).append("\n"); 
		query.append("                   ,'SVO' AS KPI_CD" ).append("\n"); 
		query.append("                   ,'Outbound Sales Vol.(TEU)' AS KPI_NM" ).append("\n"); 
		query.append("                   ,QTY.BKG_QTY_TEU" ).append("\n"); 
		query.append("             FROM QTY" ).append("\n"); 
		query.append("               WHERE DECODE(QTY.P_RHQ_CD, 'X', QTY.RHQ_OUT" ).append("\n"); 
		query.append("                                             , '', QTY.RHQ_OUT" ).append("\n"); 
		query.append("                                             , QTY.P_RHQ_CD) = QTY.RHQ_OUT" ).append("\n"); 
		query.append("             AND DECODE(QTY.P_CTRL_OFC_CD, 'X', QTY.OFC_OUT" ).append("\n"); 
		query.append("                                                  , '', QTY.OFC_OUT" ).append("\n"); 
		query.append("                                                  , QTY.P_CTRL_OFC_CD) = QTY.OFC_OUT" ).append("\n"); 
		query.append("             /*Sales Vol. Inbound*/" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("            SELECT QTY.P_REPORT" ).append("\n"); 
		query.append("                  ,QTY.COST_YRMON" ).append("\n"); 
		query.append("                  ,QTY.COST_RMON" ).append("\n"); 
		query.append("                  ,QTY.COST_WK" ).append("\n"); 
		query.append("                  ,RHQ_IN AS RHQ_CD" ).append("\n"); 
		query.append("                  ,OFC_IN AS CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,'SVI' AS KPI_CD" ).append("\n"); 
		query.append("                  ,'Inbound Sales Vol.(TEU)' AS KPI_NM" ).append("\n"); 
		query.append("                  ,QTY.BKG_QTY_TEU" ).append("\n"); 
		query.append("             FROM QTY" ).append("\n"); 
		query.append("               WHERE DECODE(QTY.P_RHQ_CD, 'X', QTY.RHQ_IN" ).append("\n"); 
		query.append("                                             , '', QTY.RHQ_IN" ).append("\n"); 
		query.append("                                             , QTY.P_RHQ_CD) = QTY.RHQ_IN" ).append("\n"); 
		query.append("              AND DECODE(QTY.P_CTRL_OFC_CD, 'X', QTY.OFC_IN" ).append("\n"); 
		query.append("                                                  , '', QTY.OFC_IN" ).append("\n"); 
		query.append("                                                  , QTY.P_CTRL_OFC_CD) = QTY.OFC_IN" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("            GROUP BY P_REPORT" ).append("\n"); 
		query.append("                 ,COST_YRMON" ).append("\n"); 
		query.append("                 ,COST_RMON" ).append("\n"); 
		query.append("                 ,COST_WK" ).append("\n"); 
		query.append("                 ,RHQ_CD" ).append("\n"); 
		query.append("                 ,CTRL_OFC_CD" ).append("\n"); 
		query.append("                 ,KPI_CD" ).append("\n"); 
		query.append("                 ,KPI_NM" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            /*Inland Vol.   */" ).append("\n"); 
		query.append("           SELECT P_REPORT" ).append("\n"); 
		query.append("#if(${f_chkprd} =='W' && ${f_split_mw} =='T')" ).append("\n"); 
		query.append("            	 ,COST_YRMON || COST_WK AS COST_YRMONWK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            	 ,COST_RMON || COST_WK AS COST_YRMONWK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 ,COST_YRMON" ).append("\n"); 
		query.append("                 ,COST_RMON" ).append("\n"); 
		query.append("                 ,COST_WK" ).append("\n"); 
		query.append("                 ,RHQ_CD" ).append("\n"); 
		query.append("                 ,CTRL_OFC_CD" ).append("\n"); 
		query.append("                 ,'V' AS COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("                 ,'VOL' AS LGS_KPI_COST_GRP_NM" ).append("\n"); 
		query.append("                 ,'IV' AS KPI_CD" ).append("\n"); 
		query.append("                 ,'Inland Vol.(BOX)' AS KPI_NM" ).append("\n"); 
		query.append("                 ,SUM(BKG_QTY_BOX) AS VOL" ).append("\n"); 
		query.append("                 ,NULL AS TOTAL_COST" ).append("\n"); 
		query.append("                 ,NULL AS UNIT_COST" ).append("\n"); 
		query.append("                 ,'2' AS KPI_ORDER" ).append("\n"); 
		query.append("             FROM (/* Inland Vol. Outbound    */" ).append("\n"); 
		query.append("                   SELECT QTY.P_REPORT" ).append("\n"); 
		query.append("                         ,QTY.COST_YRMON" ).append("\n"); 
		query.append("                         ,QTY.COST_RMON" ).append("\n"); 
		query.append("                         ,QTY.COST_WK" ).append("\n"); 
		query.append("                         ,RHQ_OUT AS RHQ_CD" ).append("\n"); 
		query.append("                         ,OFC_OUT AS CTRL_OFC_CD" ).append("\n"); 
		query.append("                         ,QTY.BKG_QTY_BOX" ).append("\n"); 
		query.append("                     FROM QTY" ).append("\n"); 
		query.append("                     WHERE QTY.BKG_POL_CD <> QTY.BKG_POR_CD" ).append("\n"); 
		query.append("                      AND DECODE(QTY.P_RHQ_CD, 'X', QTY.RHQ_OUT" ).append("\n"); 
		query.append("                                             , '', QTY.RHQ_OUT" ).append("\n"); 
		query.append("                                             , QTY.P_RHQ_CD) = QTY.RHQ_OUT" ).append("\n"); 
		query.append("                      AND DECODE(QTY.P_CTRL_OFC_CD, 'X', QTY.OFC_OUT" ).append("\n"); 
		query.append("                                                  , '', QTY.OFC_OUT" ).append("\n"); 
		query.append("                                                  , QTY.P_CTRL_OFC_CD) = QTY.OFC_OUT" ).append("\n"); 
		query.append("                    /* Inland Vol. Inbound */" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT QTY.P_REPORT" ).append("\n"); 
		query.append("                          ,QTY.COST_YRMON" ).append("\n"); 
		query.append("                          ,QTY.COST_RMON" ).append("\n"); 
		query.append("                          ,QTY.COST_WK" ).append("\n"); 
		query.append("                          ,RHQ_IN AS RHQ_CD" ).append("\n"); 
		query.append("                          ,OFC_IN AS CTRL_OFC_CD" ).append("\n"); 
		query.append("                          ,QTY.BKG_QTY_BOX" ).append("\n"); 
		query.append("                    FROM QTY" ).append("\n"); 
		query.append("                    WHERE QTY.BKG_POD_CD <> QTY.BKG_DEL_CD" ).append("\n"); 
		query.append("                      AND DECODE(QTY.P_RHQ_CD, 'X', QTY.RHQ_IN" ).append("\n"); 
		query.append("                                             , '', QTY.RHQ_IN" ).append("\n"); 
		query.append("                                             , QTY.P_RHQ_CD) = QTY.RHQ_IN" ).append("\n"); 
		query.append("                      AND DECODE(QTY.P_CTRL_OFC_CD, 'X', QTY.OFC_IN" ).append("\n"); 
		query.append("                                                  , '', QTY.OFC_IN" ).append("\n"); 
		query.append("                                                  , QTY.P_CTRL_OFC_CD) = QTY.OFC_IN" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      GROUP BY P_REPORT" ).append("\n"); 
		query.append("              ,COST_YRMON" ).append("\n"); 
		query.append("              ,COST_RMON" ).append("\n"); 
		query.append("              ,COST_WK" ).append("\n"); 
		query.append("              ,RHQ_CD" ).append("\n"); 
		query.append("              ,CTRL_OFC_CD" ).append("\n"); 
		query.append("      ORDER BY COST_YRMON,COST_RMON, COST_WK, RHQ_CD, CTRL_OFC_CD, KPI_ORDER, KPI_CD" ).append("\n"); 

	}
}