/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CMSummaryDBDAOPriPrsCtrtSmryCostSurchageTmpVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMSummaryDBDAOPriPrsCtrtSmryCostSurchageTmpVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Simulatoin을 위해 temp데이터에 실제 데이터 update
	  * * 2011.06.29 김민아 [CHM-201111837] Split 20-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 : DUAL Table을 부적절하게 사용한 DBDAO의 SQL을 .Query로 이동
	  * </pre>
	  */
	public CMSummaryDBDAOPriPrsCtrtSmryCostSurchageTmpVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAOPriPrsCtrtSmryCostSurchageTmpVOUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_PRS_CTRT_SMRY_SCG_TMP TBL" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("	SELECT PRS_YRMON, PRS_WK, PRC_CTRT_TP_CD, PRC_CTRT_NO, SVC_SCP_CD, VSL_SLAN_DIR_CD, TRD_CD, SUB_TRD_CD, RLANE_CD, PRC_CGO_TP_CD, ORG_LOC_TP_CD, ORG_LOC_DEF_CD, DEST_LOC_TP_CD, DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("		, CHG_CD" ).append("\n"); 
		query.append("		, ( SCG_AMT +  DECODE(DT_CALC_TP_CD,'+', DT_AMOUNT , (SCG_AMT  * DT_AMOUNT /100 ) ) ) AS SIMUL_DT" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT   " ).append("\n"); 
		query.append("			SR_CST_DTL.PRS_YRMON, SR_CST_DTL.PRS_WK, SR_CST_DTL.PRC_CTRT_TP_CD, SR_CST_DTL.PRC_CTRT_NO" ).append("\n"); 
		query.append("			, SR_CST_DTL.SVC_SCP_CD, SR_CST_DTL.VSL_SLAN_DIR_CD, SR_CST_DTL.TRD_CD, SR_CST_DTL.SUB_TRD_CD" ).append("\n"); 
		query.append("			, SR_CST_DTL.RLANE_CD, SR_CST_DTL.PRC_CGO_TP_CD, SR_CST_DTL.ORG_LOC_TP_CD, SR_CST_DTL.ORG_LOC_DEF_CD,SR_CST_DTL. DEST_LOC_TP_CD, SR_CST_DTL.DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("			, SR_CST_DTL.CHG_CD" ).append("\n"); 
		query.append("			, SR_CST_DTL.SCG_AMT  " ).append("\n"); 
		query.append("			, DT.SUB_TRD_CD        AS DT_SUB_TRD_CD      " ).append("\n"); 
		query.append("			, DT.RLANE_CD	   AS DT_RLANE_CD        " ).append("\n"); 
		query.append("			, DT.ORG_LOC_TP_CD	   AS DT_ORG_LOC_TP_CD   " ).append("\n"); 
		query.append("			, DT.ORG_LOC_DEF_CD	   AS DT_ORG_LOC_DEF_CD  " ).append("\n"); 
		query.append("			, DT.DEST_LOC_TP_CD    AS DT_DEST_LOC_TP_CD  " ).append("\n"); 
		query.append("			, DT.DEST_LOC_DEF_CD   AS DT_DEST_LOC_DEF_CD " ).append("\n"); 
		query.append("			, DT.APR_OFC_CD	   AS DT_APR_OFC_CD      " ).append("\n"); 
		query.append("			, DT.CALC_TP_CD	   AS DT_CALC_TP_CD" ).append("\n"); 
		query.append("			, DT.AMOUNT	           AS DT_AMOUNT" ).append("\n"); 
		query.append("			, DT.EFF_YRWK          AS DT_EFF_YRWK" ).append("\n"); 
		query.append("			, DT.EXP_YRWK          AS DT_EXP_YRWK" ).append("\n"); 
		query.append(" 			, ROW_NUMBER() OVER( PARTITION BY " ).append("\n"); 
		query.append("							SR_CST_DTL.PRS_YRMON, SR_CST_DTL.PRS_WK, SR_CST_DTL.PRC_CTRT_TP_CD, SR_CST_DTL.PRC_CTRT_NO" ).append("\n"); 
		query.append("							, SR_CST_DTL.SVC_SCP_CD, SR_CST_DTL.VSL_SLAN_DIR_CD, SR_CST_DTL.TRD_CD, SR_CST_DTL.SUB_TRD_CD" ).append("\n"); 
		query.append("							, SR_CST_DTL.RLANE_CD, SR_CST_DTL.PRC_CGO_TP_CD, SR_CST_DTL.ORG_LOC_TP_CD, SR_CST_DTL.ORG_LOC_DEF_CD,SR_CST_DTL. DEST_LOC_TP_CD, SR_CST_DTL.DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("							, SR_CST_DTL.CHG_CD" ).append("\n"); 
		query.append("					ORDER BY (DT.SCORE) DESC ) RN" ).append("\n"); 
		query.append("		FROM    PRI_PRS_CTRT_SMRY_SCG_TMP SR_CST_DTL" ).append("\n"); 
		query.append("			, (" ).append("\n"); 
		query.append("                                SELECT  'NULL' AS SUB_TRD_CD" ).append("\n"); 
		query.append("                                        , 'NULL' AS RLANE_CD" ).append("\n"); 
		query.append("                                        , 'NULL' AS ORG_LOC_TP_CD" ).append("\n"); 
		query.append("                                        , 'NULL' AS ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("                                        , 'NULL' AS DEST_LOC_TP_CD" ).append("\n"); 
		query.append("                                        , 'NULL' AS DEST_LOC_DEF_CD " ).append("\n"); 
		query.append("                                        , 'NULL' AS APR_OFC_CD" ).append("\n"); 
		query.append("                                        , 'IAON' AS CUST_TP_CD" ).append("\n"); 
		query.append("                                        , 'NULL' AS SCG_CD" ).append("\n"); 
		query.append("                                        , 0 AS SCORE" ).append("\n"); 
		query.append("                                        , NULL AS EFF_YRWK" ).append("\n"); 
		query.append("                                        , NULL AS EXP_YRWK" ).append("\n"); 
		query.append("                                        , 'NULL' AS CALC_TP_CD" ).append("\n"); 
		query.append("                                        , 0 AS AMOUNT" ).append("\n"); 
		query.append("                                FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                #foreach( ${obj} in ${list_obj} )" ).append("\n"); 
		query.append("                                UNION ALL " ).append("\n"); 
		query.append("                                SELECT" ).append("\n"); 
		query.append("                                        DECODE('$obj.getSubTrdCd()', NULL, 'NULL', '$obj.getSubTrdCd()') AS SUB_TRD_CD " ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getRlaneCd()', NULL, 'NULL', '$obj.getRlaneCd()') AS RLANE_CD " ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getOriLocTp()', NULL, 'NULL', '$obj.getOriLocTp()') AS ORG_LOC_TP_CD " ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getOriRoutCd()', NULL, 'NULL', '$obj.getOriRoutCd()') AS ORG_LOC_DEF_CD " ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getDestLocTp()', NULL, 'NULL', '$obj.getDestLocTp()') AS DEST_LOC_TP_CD " ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getDestRoutCd()', NULL, 'NULL', '$obj.getDestRoutCd()') AS DEST_LOC_DEF_CD " ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getAprOfcCd()', NULL, 'NULL', '$obj.getAprOfcCd()') AS APR_OFC_CD " ).append("\n"); 
		query.append("                                       ,'$obj.getCustTpCd()' AS CUST_TP_CD " ).append("\n"); 
		query.append("                                       ,'$obj.getChgCd()' AS SCG_CD " ).append("\n"); 
		query.append("                                       ,$obj.getScore() AS SCORE " ).append("\n"); 
		query.append("                                       ,REPLACE('$obj.getEffYrwk()','-','') AS EFF_YRWK " ).append("\n"); 
		query.append("                                       ,REPLACE('$obj.getExpYrwk()','-','') AS EXP_YRWK " ).append("\n"); 
		query.append("                                       ,'$obj.getCalcTpCd()' AS CALC_TP_CD " ).append("\n"); 
		query.append("                                       ,$obj.getAmount() AS AMOUNT " ).append("\n"); 
		query.append("                                  FROM  DUAL" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        ) DT" ).append("\n"); 
		query.append("		WHERE   --SR_CST_DTL.PRC_CTRT_TP_CD = 'S' -- S/C" ).append("\n"); 
		query.append("			-- LOAD" ).append("\n"); 
		query.append("			 SR_CST_DTL.SUB_TRD_CD = DECODE(DT.SUB_TRD_CD,'NULL', SR_CST_DTL.SUB_TRD_CD, DT.SUB_TRD_CD)" ).append("\n"); 
		query.append("			AND SR_CST_DTL.RLANE_CD = DECODE(DT.RLANE_CD,'NULL', SR_CST_DTL.RLANE_CD, DT.RLANE_CD)" ).append("\n"); 
		query.append("			AND SR_CST_DTL.ORG_LOC_TP_CD = DECODE(DT.ORG_LOC_TP_CD,'NULL', SR_CST_DTL.ORG_LOC_TP_CD, DT.ORG_LOC_TP_CD)" ).append("\n"); 
		query.append("			AND SR_CST_DTL.ORG_LOC_DEF_CD = DECODE(DT.ORG_LOC_DEF_CD,'NULL', SR_CST_DTL.ORG_LOC_DEF_CD, DT.ORG_LOC_DEF_CD)" ).append("\n"); 
		query.append("			AND SR_CST_DTL.DEST_LOC_TP_CD = DECODE(DT.DEST_LOC_TP_CD,'NULL', SR_CST_DTL.DEST_LOC_TP_CD, DT.DEST_LOC_TP_CD)" ).append("\n"); 
		query.append("			AND SR_CST_DTL.DEST_LOC_DEF_CD = DECODE(DT.DEST_LOC_DEF_CD,'NULL', SR_CST_DTL.DEST_LOC_DEF_CD, DT.DEST_LOC_DEF_CD)" ).append("\n"); 
		query.append("			AND INSTR(DT.CUST_TP_CD,  SR_CST_DTL.PRS_CUST_TP_CD ) > 0" ).append("\n"); 
		query.append("			AND SR_CST_DTL.PROP_APRO_OFC_CD = DECODE(DT.APR_OFC_CD,'NULL', SR_CST_DTL.PROP_APRO_OFC_CD, DT.APR_OFC_CD)" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND (SUBSTR(SR_CST_DTL.PRS_YRMON,1,4)  || SR_CST_DTL.PRS_WK) >= DT.EFF_YRWK  AND (SUBSTR(SR_CST_DTL.PRS_YRMON,1,4)  || SR_CST_DTL.PRS_WK) <= DT.EXP_YRWK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${virtual_query_tp_cd}== 'SURCHAGE') " ).append("\n"); 
		query.append("			AND  DECODE(DT.SCG_CD,'NULL',1, INSTR(DT.SCG_CD,SR_CST_DTL.CHG_CD))  > 0 -- SURCHARGE를 위한코드" ).append("\n"); 
		query.append("			AND SR_CST_DTL.CHG_CD <> 'OFT'" ).append("\n"); 
		query.append("		#elseif (${virtual_query_tp_cd} == 'RATE') " ).append("\n"); 
		query.append("			AND SR_CST_DTL.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("	WHERE  RN = 1" ).append("\n"); 
		query.append(") RSLT" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("	TBL.PRS_YRMON         =  RSLT.PRS_YRMON       " ).append("\n"); 
		query.append("	AND TBL.PRS_WK            =	 RSLT.PRS_WK          " ).append("\n"); 
		query.append("	AND TBL.PRC_CTRT_TP_CD    =	 RSLT.PRC_CTRT_TP_CD  " ).append("\n"); 
		query.append("	AND TBL.PRC_CTRT_NO       =	 RSLT.PRC_CTRT_NO     " ).append("\n"); 
		query.append("	AND TBL.SVC_SCP_CD        =	 RSLT.SVC_SCP_CD      " ).append("\n"); 
		query.append("	AND TBL.VSL_SLAN_DIR_CD   =	 RSLT.VSL_SLAN_DIR_CD " ).append("\n"); 
		query.append("	AND TBL.TRD_CD	      =	 RSLT.TRD_CD	    " ).append("\n"); 
		query.append("	AND TBL.SUB_TRD_CD        =	 RSLT.SUB_TRD_CD      " ).append("\n"); 
		query.append("	AND TBL.RLANE_CD          =	 RSLT.RLANE_CD        " ).append("\n"); 
		query.append("	AND TBL.PRC_CGO_TP_CD     =	 RSLT.PRC_CGO_TP_CD   " ).append("\n"); 
		query.append("	AND TBL.ORG_LOC_TP_CD     =  RSLT.ORG_LOC_TP_CD   " ).append("\n"); 
		query.append("	AND TBL.ORG_LOC_DEF_CD    =	 RSLT.ORG_LOC_DEF_CD  " ).append("\n"); 
		query.append("	AND TBL.DEST_LOC_TP_CD    =	 RSLT.DEST_LOC_TP_CD  " ).append("\n"); 
		query.append("	AND TBL.DEST_LOC_DEF_CD   =	 RSLT.DEST_LOC_DEF_CD " ).append("\n"); 
		query.append("	AND TBL.CHG_CD   =	 RSLT.CHG_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET TBL.SCG_AMT = RSLT.SIMUL_DT" ).append("\n"); 
		query.append(", TBL.UPD_USR_ID = 'Y'" ).append("\n"); 

	}
}