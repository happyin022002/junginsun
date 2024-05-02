/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOCaSummaryReportOutVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaSummaryReportOutVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C/A Summary Report BL List 결과를 조회한다
	  * 
	  * History
	  * * 2010.12.29 진마리아  CHM-201007773-01 C/A Summary 화면 변경 (GSO Office 추가)
	  * * 2012.02.14 김보배 [CHM-201215888] [BKG] C/A Summary 화면에 Contract Sales Rep. 추가
	  * </pre>
	  */
	public PerformanceReportDBDAOCaSummaryReportOutVO2RSQL(){
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
		params.put("del_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gso_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contract_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dlv_ctnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_issue_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_issue_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaSummaryReportOutVO2RSQL").append("\n"); 
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
		query.append("SELECT BKG.BL_NO || BL_TP_CD                                AS BL_NO" ).append("\n"); 
		query.append("      ,BKG.BKG_NO                                           AS BKG_NO" ).append("\n"); 
		query.append("      ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD       AS VVD" ).append("\n"); 
		query.append("      ,( SELECT TO_CHAR( BL_OBRD_DT ,'YYYY-MM-DD') FROM BKG_BL_DOC WHERE BKG_NO = BKG.BKG_NO  AND ROWNUM=1 )                 AS BL_OBRD_DT   " ).append("\n"); 
		query.append("      ,BKG.BKG_OFC_CD                                       AS BKG_OFC_CD       " ).append("\n"); 
		query.append("      ,BKG.SLS_RHQ_CD                                       AS SLS_RHQ_CD" ).append("\n"); 
		query.append("      ,BKG.CTRT_OFC_CD                                      AS CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,BKG.CTRT_SREP_CD                            			AS CTRT_SREP_CD" ).append("\n"); 
		query.append("--      ,PERF.GSO_OFC_CD                                      AS GSO_OFC_CD" ).append("\n"); 
		query.append("      ,BKG.POR_CD                                           AS POR_CD" ).append("\n"); 
		query.append("      ,BKG.POL_CD                                           AS POL_CD" ).append("\n"); 
		query.append("      ,BKG.POD_CD                                           AS POD_CD" ).append("\n"); 
		query.append("      ,BKG.DEL_CD                                           AS DEL_CD" ).append("\n"); 
		query.append("      ,COR.CORR_NO                                          AS CORR_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(COR.CORR_DT,'YYYY-MM-DD')                    AS CORR_DT" ).append("\n"); 
		query.append("      ,COR.CORR_OFC_CD                                      AS CORR_OFC_CD" ).append("\n"); 
		query.append("      ,COR.CORR_USR_ID                                      AS CORR_USR_ID" ).append("\n"); 
		query.append("      ,COR.CA_RSN_CD                                        AS CA_RSN_CD" ).append("\n"); 
		query.append("      ,COR.RT_CORR_FLG                                      AS CNT_KIND_A                                                  " ).append("\n"); 
		query.append("      ,COR.CHG_TERM_CORR_FLG                                AS CNT_KIND_B                                             " ).append("\n"); 
		query.append("      ,COR.RCVDE_TERM_CORR_FLG                              AS CNT_KIND_C                                             " ).append("\n"); 
		query.append("      ,COR.ROUT_CORR_FLG                                    AS CNT_KIND_D                                             " ).append("\n"); 
		query.append("      ,COR.CUST_CORR_FLG                                    AS CNT_KIND_E                                             " ).append("\n"); 
		query.append("      ,COR.QTY_CORR_FLG                                     AS CNT_KIND_F                                             " ).append("\n"); 
		query.append("      ,COR.MEAS_QTY_CORR_FLG                                AS CNT_KIND_G                                             " ).append("\n"); 
		query.append("      ,COR.CMDT_CORR_FLG                                    AS CNT_KIND_H                                             " ).append("\n"); 
		query.append("      ,COR.TRNK_VSL_CORR_FLG                                AS CNT_KIND_I                                             " ).append("\n"); 
		query.append("      ,COR.PRPST_VSL_CORR_FLG                               AS CNT_KIND_J                                             " ).append("\n"); 
		query.append("      ,COR.CA_OTR_RSN_CORR_FLG                              AS CNT_KIND_K" ).append("\n"); 
		query.append("      ,COR.BKG_SPLIT_MODI_FLG                               AS BKG_SPLIT_MODI_FLG" ).append("\n"); 
		query.append("      ,COR.CXL_MODI_FLG                                     AS CXL_MODI_FLG                        " ).append("\n"); 
		query.append("      ,TO_CHAR(COR.CRE_DT,'YYYY-MM-DD')                     AS CRE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(COR.UPD_DT,'YYYY-MM-DD')                     AS UPD_DT      " ).append("\n"); 
		query.append("      ,( SELECT UPD_USR_ID FROM BKG_RATE WHERE BKG_NO = BKG.BKG_NO) AS UPD_USR_ID" ).append("\n"); 
		query.append("      , ( SELECT REPLACE( CUST_NM,CHR(13) || CHR(10),' ') FROM BKG_CUSTOMER WHERE BKG_NO = BKG.BKG_NO AND BKG_CUST_TP_CD = 'S' AND ROWNUM=1)         AS CUST_NM " ).append("\n"); 
		query.append("      ,REPLACE(COR.BKG_CORR_RMK,CHR(13) || CHR(10),' ')         AS DIFF_RMK" ).append("\n"); 
		query.append("      , ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		  FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		  WHERE    INTG_CD_ID = 'CD02572'" ).append("\n"); 
		query.append("		  AND INTG_CD_VAL_CTNT =DOC_PERF_EXPT_CD" ).append("\n"); 
		query.append("		) AS CNT_EXEMPT " ).append("\n"); 
		query.append("      ,DECODE(COR.RAT_FLG,'Y','Y')             AS REV" ).append("\n"); 
		query.append("      ,DECODE(NVL(COR.RAT_FLG,'N'), 'N','Y')   AS NONREV" ).append("\n"); 
		query.append("      ,NVL(COR.EXPN_FLG,'N')                   AS EXP " ).append("\n"); 
		query.append("		 ,DECODE((SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		  FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("	  WHERE    INTG_CD_ID = 'CD02572'" ).append("\n"); 
		query.append("	  AND INTG_CD_VAL_CTNT =DOC_PERF_EXPT_CD)" ).append("\n"); 
		query.append("		, '', 'N', 'Y')					  AS EXEMPTION  " ).append("\n"); 
		query.append("  FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append("      ,BKG_CORRECTION   COR" ).append("\n"); 
		query.append("#if(${gso_ofc_cd} != '')      " ).append("\n"); 
		query.append("	  ,(SELECT BKG_OFC_CD, GSO_OFC_CD FROM BKG_DOC_PERF_OFC_V GROUP BY BKG_OFC_CD, GSO_OFC_CD)  PERF" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ctrt_ofc_cd} != '')	  " ).append("\n"); 
		query.append("	  ,(SELECT BKG_OFC_CD, GSO_OFC_CD FROM BKG_DOC_PERF_OFC_V GROUP BY BKG_OFC_CD, GSO_OFC_CD)  CTRT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${corr_from_dt} != '')" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = COR.BKG_NO" ).append("\n"); 
		query.append("   AND COR.CORR_NO <> '0000000001'" ).append("\n"); 
		query.append("   AND COR.CORR_NO <> 'TMP0000001'" ).append("\n"); 
		query.append("   AND COR.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND COR.CA_RSN_CD NOT IN ('F','E')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = COR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND COR.CORR_NO(+) <> '0000000001'" ).append("\n"); 
		query.append("   AND COR.CORR_NO(+) <> 'TMP0000001'" ).append("\n"); 
		query.append("   AND COR.CORR_CXL_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND COR.CA_RSN_CD(+) NOT IN ('F','E')" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD IN ('F','W','A')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dlv_ctnt_cd} != '')" ).append("\n"); 
		query.append("   AND @[dlv_ctnt_cd] = ( SELECT  CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BKG.DEL_CD)      " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("   AND BKG.VSL_CD = SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("   AND BKG.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND BKG.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${corr_from_dt} != '')" ).append("\n"); 
		query.append("   AND COR.CORR_DT BETWEEN TO_DATE(@[corr_from_dt] || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[corr_to_dt] || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_from_dt} != '')" ).append("\n"); 
		query.append("   AND BKG.BKG_CRE_DT BETWEEN TO_DATE(@[cre_from_dt] || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[cre_to_dt] || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_reason} != '')" ).append("\n"); 
		query.append("   AND ( ${ca_reason} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_class} != '')" ).append("\n"); 
		query.append("   AND ( ${ca_class} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_kind} != '')" ).append("\n"); 
		query.append("   AND ( ${ca_kind} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_issue_off} != '')" ).append("\n"); 
		query.append("   AND COR.CORR_OFC_CD = @[ca_issue_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_off} != '')" ).append("\n"); 
		query.append("   AND BKG.BKG_OFC_CD = @[bkg_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')  " ).append("\n"); 
		query.append("	AND     BKG.BKG_OFC_CD IN" ).append("\n"); 
		query.append("        		( SELECT DISTINCT LVL.OFC_CD " ).append("\n"); 
		query.append("					FROM BKG_OFC_LVL_V  LVL" ).append("\n"); 
		query.append("				   WHERE 1=1" ).append("\n"); 
		query.append("					 AND LVL.REGION = @[rhq_cd]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_off} != '')" ).append("\n"); 
		query.append("   AND BKG.IB_SLS_OFC_CD = @[del_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${part} != '')" ).append("\n"); 
		query.append("   --AND" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${contract_off} != '')" ).append("\n"); 
		query.append("   AND BKG.CTRT_OFC_CD = @[contract_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_issue_staff} != '')" ).append("\n"); 
		query.append("   AND COR.CRE_USR_ID = @[ca_issue_staff]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por} != '')" ).append("\n"); 
		query.append("   AND BKG.POR_CD = @[por]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("   AND BKG.POL_CD = @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("   AND BKG.POD_CD = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del} != '')" ).append("\n"); 
		query.append("   AND BKG.DEL_CD = @[del]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${off_dis_op_5} != '')" ).append("\n"); 
		query.append("   AND COR.CORR_OFC_CD IN (SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("                             FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                            WHERE @[ca_issue_off] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                      OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${off_dis_op_6} != '')" ).append("\n"); 
		query.append("   AND BKG.DEL_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE SLS_OFC_CD = @[del_off])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gso_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND PERF.GSO_OFC_CD = @[gso_ofc_cd]" ).append("\n"); 
		query.append("   AND BKG.BKG_OFC_CD = PERF.BKG_OFC_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND CTRT.GSO_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("   AND BKG.CTRT_OFC_CD = CTRT.BKG_OFC_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ctrt_srep_cd} != '')" ).append("\n"); 
		query.append("   AND BKG.CTRT_SREP_CD = @[ctrt_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY BKG.POR_CD" ).append("\n"); 
		query.append("         ,BKG.POL_CD" ).append("\n"); 
		query.append("         ,BKG.POD_CD" ).append("\n"); 
		query.append("         ,BKG.DEL_CD" ).append("\n"); 

	}
}