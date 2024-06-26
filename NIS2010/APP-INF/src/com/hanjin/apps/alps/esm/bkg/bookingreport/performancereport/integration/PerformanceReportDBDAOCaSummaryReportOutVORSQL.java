/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOCaSummaryReportOutVORSQL.java
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

public class PerformanceReportDBDAOCaSummaryReportOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C/A Summary Report 결과를 조회한다.
	  * 
	  * History
	  * * 2010.12.29 진마리아  CHM-201007773-01 C/A Summary 화면 변경 (GSO Office 추가)
	  * * 2012.02.14 김보배 [CHM-201215888] [BKG] C/A Summary 화면에 Contract Sales Rep. 추가
	  * </pre>
	  */
	public PerformanceReportDBDAOCaSummaryReportOutVORSQL(){
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
		query.append("FileName : PerformanceReportDBDAOCaSummaryReportOutVORSQL").append("\n"); 
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
		query.append("#if (${vo_cre_flg} != '')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  '' AS CORR_DT" ).append("\n"); 
		query.append(", '' AS CNT_HLG_C" ).append("\n"); 
		query.append(", '' AS BL_NO" ).append("\n"); 
		query.append(", '' AS CXL_MODI_FLG" ).append("\n"); 
		query.append(", '' AS POL_CD" ).append("\n"); 
		query.append(", '' AS CNT_HLG_M" ).append("\n"); 
		query.append(", '' AS CTRT_OFC_CD" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS BKG_OFC_CD" ).append("\n"); 
		query.append(", '' AS DEL_CD" ).append("\n"); 
		query.append(", '' AS CORR_USR_ID" ).append("\n"); 
		query.append(", '' AS SLS_RHQ_CD" ).append("\n"); 
		query.append(", '' AS VVD" ).append("\n"); 
		query.append(", '' AS POD_CD" ).append("\n"); 
		query.append(", '' AS CNT_CA_TTL" ).append("\n"); 
		query.append(", '' AS BKG_NO" ).append("\n"); 
		query.append(", '' AS BL_OBRD_DT" ).append("\n"); 
		query.append(", '' AS POR_CD" ).append("\n"); 
		query.append(", '' AS CUST_NM" ).append("\n"); 
		query.append(", '' AS CRE_DT" ).append("\n"); 
		query.append(", '' AS CNT_CLASS_N" ).append("\n"); 
		query.append(", '' AS CNT_RSN_A" ).append("\n"); 
		query.append(", '' AS CNT_RSN_C" ).append("\n"); 
		query.append(", '' AS CNT_EXEMPT" ).append("\n"); 
		query.append(", '' AS CNT_CLASS_E" ).append("\n"); 
		query.append(", '' AS CORR_OFC_CD" ).append("\n"); 
		query.append(", '' AS UPD_DT" ).append("\n"); 
		query.append(", '' AS CA_RSN_CD" ).append("\n"); 
		query.append(", '' AS CNT_RSN_M" ).append("\n"); 
		query.append(", '' AS BKG_SPLIT_MODI_FLG" ).append("\n"); 
		query.append(", '' AS CNT_BL_TTL" ).append("\n"); 
		query.append(", '' AS CNT_RSN_R" ).append("\n"); 
		query.append(", '' AS CORR_NO" ).append("\n"); 
		query.append(", '' AS CNT_RSN_G" ).append("\n"); 
		query.append(", '' AS CNT_CLASS_R" ).append("\n"); 
		query.append(", '' AS CNT_KIND_A" ).append("\n"); 
		query.append(", '' AS CNT_KIND_B" ).append("\n"); 
		query.append(", '' AS CNT_KIND_C" ).append("\n"); 
		query.append(", '' AS DIFF_RMK" ).append("\n"); 
		query.append(", '' AS CNT_KIND_D" ).append("\n"); 
		query.append(", '' AS CNT_KIND_I" ).append("\n"); 
		query.append(", '' AS CNT_KIND_J" ).append("\n"); 
		query.append(", '' AS CNT_KIND_K" ).append("\n"); 
		query.append(", '' AS CNT_KIND_E" ).append("\n"); 
		query.append(", '' AS CNT_KIND_F" ).append("\n"); 
		query.append(", '' AS CNT_KIND_G" ).append("\n"); 
		query.append(", '' AS CNT_KIND_H" ).append("\n"); 
		query.append(", '' AS REV" ).append("\n"); 
		query.append(", '' AS NONREV" ).append("\n"); 
		query.append(", '' AS EXP" ).append("\n"); 
		query.append(", '' AS EXEMPTION" ).append("\n"); 
		query.append(", '' AS GSO_OFC_CD" ).append("\n"); 
		query.append(", '' AS CTRT_SREP_CD" ).append("\n"); 
		query.append(", '' AS TOT_CNT_BL_TTL" ).append("\n"); 
		query.append(", '' AS CNT_RSN_D" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT CNT.* " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${off_dis_op_2} != '' || ${off_dis_op_3} != ''|| ${off_dis_op_4} != '' ) || (${contract_off} != '' ||${bkg_off} != '' ||${ca_issue_off} != '') )" ).append("\n"); 
		query.append(",tot_cnt_bl_ttl" ).append("\n"); 
		query.append(",COUNT(DISTINCT cnt.g_ofc) OVER(PARTITION BY 'A' ) ofc_cnt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '' TEMP" ).append("\n"); 
		query.append("--       POR_CD" ).append("\n"); 
		query.append("--      ,POL_CD" ).append("\n"); 
		query.append("--      ,POD_CD" ).append("\n"); 
		query.append("--      ,DEL_CD" ).append("\n"); 
		query.append("#if (${off_dis_op} != '') --GROUP BY 옵션" ).append("\n"); 
		query.append("	  ${off_dis_op}" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----------------------------------------------------------" ).append("\n"); 
		query.append("--BKG2 와 조인 걸기 위한 조건 'G' 조건에 따른 " ).append("\n"); 
		query.append("----------------------------------------------------------" ).append("\n"); 
		query.append("#if ((${off_dis_op_2} != '' || ${off_dis_op_3} != ''|| ${off_dis_op_4} != '' ) || (${contract_off} != '' ||${bkg_off} != '' ||${ca_issue_off} != '') )  -- bkg2 조건 " ).append("\n"); 
		query.append("    #if(${ca_reason_g}=='G') " ).append("\n"); 
		query.append("              ------------------------------------" ).append("\n"); 
		query.append("            #if(${off_dis_op_4} == '' && ${contract_off} == '' )" ).append("\n"); 
		query.append("              ------------------------------------" ).append("\n"); 
		query.append("                  ,ctrt_ofc_cd g_ofc" ).append("\n"); 
		query.append("		          ,ctrt_ofc_cd,CTRT_SREP_CD" ).append("\n"); 
		query.append("		    #elseif(${off_dis_op_4} == '' && ${contract_off} != '' )" ).append("\n"); 
		query.append("                  ,ctrt_ofc_cd g_ofc" ).append("\n"); 
		query.append("		          ,ctrt_ofc_cd,CTRT_SREP_CD" ).append("\n"); 
		query.append("		    #else" ).append("\n"); 
		query.append("		          ,ctrt_ofc_cd g_ofc" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		      ------------------------------------" ).append("\n"); 
		query.append("		--select 항목 추가 (group by 항목)" ).append("\n"); 
		query.append("            #if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            	#if (${bkg_off} != '')" ).append("\n"); 
		query.append("            		,bkg_ofc_cd  " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("            	#if (${ca_issue_off} != '')" ).append("\n"); 
		query.append("            		,corr_ofc_cd " ).append("\n"); 
		query.append("            	#end" ).append("\n"); 
		query.append("            	" ).append("\n"); 
		query.append("            #end		" ).append("\n"); 
		query.append("		----------------" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("              ------------------------------------" ).append("\n"); 
		query.append("            #if (${off_dis_op_4} != '')" ).append("\n"); 
		query.append("            	  ,ctrt_ofc_cd g_ofc" ).append("\n"); 
		query.append("            #elseif (${off_dis_op_2} != '')" ).append("\n"); 
		query.append("            	  ,bkg_ofc_cd g_ofc" ).append("\n"); 
		query.append("            -- 비교 대상 ofc     " ).append("\n"); 
		query.append("            #elseif (${off_dis_op_2} == '' && ${off_dis_op_3} != '')" ).append("\n"); 
		query.append("            	  ,corr_ofc_cd g_ofc" ).append("\n"); 
		query.append("            #end    " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            	#if (${contract_off} != ''  )" ).append("\n"); 
		query.append("            		,ctrt_ofc_cd g_ofc" ).append("\n"); 
		query.append("            		,ctrt_ofc_cd,CTRT_SREP_CD" ).append("\n"); 
		query.append("    			#end" ).append("\n"); 
		query.append("            	#if (${bkg_off} != ''  )" ).append("\n"); 
		query.append("            		,bkg_ofc_cd g_ofc" ).append("\n"); 
		query.append("                    ,bkg_ofc_cd  " ).append("\n"); 
		query.append("    			#end" ).append("\n"); 
		query.append("            	#if (${bkg_off} == '' && ${ca_issue_off} != '' )" ).append("\n"); 
		query.append("            		,corr_ofc_cd g_ofc" ).append("\n"); 
		query.append("                    ,corr_ofc_cd" ).append("\n"); 
		query.append("            	#end" ).append("\n"); 
		query.append("            	" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		      ------------------------------------" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("----------------------------------------------------------" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("      ,COUNT(DISTINCT BKG_NO)                                                           AS CNT_BL_TTL" ).append("\n"); 
		query.append("      ,SUM(DECODE(CA_RSN_CD,'M',1,0)+DECODE(CA_RSN_CD,'C',1,0)" ).append("\n"); 
		query.append("       + DECODE(CA_RSN_CD,'G',1,0)+DECODE(CA_RSN_CD,'O',1,0)+DECODE(CA_RSN_CD,'R',1,0)" ).append("\n"); 
		query.append("       + DECODE(CA_RSN_CD,'A',1,0)+DECODE(CA_RSN_CD,'H',1,0)+DECODE(CA_RSN_CD,'D',1,0)) AS CNT_CA_TTL" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'M',1,'O',1,0),0))                           AS CNT_RSN_M" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'D',1,0),0))                                 AS CNT_RSN_D" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'C',1,'H',1,0),0))                           AS CNT_RSN_C" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'G',1,0),0))                                 AS CNT_RSN_G" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'A',1,0),0))                                 AS CNT_RSN_A" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'R',1,0),0))                                 AS CNT_RSN_R" ).append("\n"); 
		query.append("--      ,SUM(DECODE(REV,'Y',0,1))                                       				AS CNT_CLASS_R" ).append("\n"); 
		query.append("      ,SUM(DECODE(SLS_RHQ_CD,'NON CA',0,DECODE(REV,'Y',0,DECODE(( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		  FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		  WHERE    INTG_CD_ID = 'CD02572'" ).append("\n"); 
		query.append("		  AND INTG_CD_VAL_CTNT = DOC_PERF_EXPT_CD), '', 1, 0))))" ).append("\n"); 
		query.append("        															                    AS CNT_CLASS_N" ).append("\n"); 
		query.append("--      ,SUM(DECODE(SLS_RHQ_CD,'NON CA',0,DECODE(REV,'Y',0,1)))                         AS CNT_CLASS_R" ).append("\n"); 
		query.append("      ,SUM(DECODE(REV,'N',0,DECODE(( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		  FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		  WHERE    INTG_CD_ID = 'CD02572'" ).append("\n"); 
		query.append("		  AND INTG_CD_VAL_CTNT = DOC_PERF_EXPT_CD), '', 1, 0))) " ).append("\n"); 
		query.append("		                                         										AS CNT_CLASS_R" ).append("\n"); 
		query.append("--      ,SUM(DECODE(REV,'N',0,1))                                       				AS CNT_CLASS_N" ).append("\n"); 
		query.append("      ,SUM(DECODE(EXP,'N',0,1))                                       					AS CNT_CLASS_E" ).append("\n"); 
		query.append("      ,SUM(NVL(C_HAUL,0))                                                               AS CNT_HLG_C" ).append("\n"); 
		query.append("      ,SUM(NVL(M_HAUL,0))                                                               AS CNT_HLG_M" ).append("\n"); 
		query.append("--     ,SUM(DECODE(CA_RSN_CD,'M',1,0)+DECODE(CA_RSN_CD,'C',1,0)+DECODE(CA_RSN_CD,'G',1,0)" ).append("\n"); 
		query.append("--      + DECODE(CA_RSN_CD,'O',1,0)+DECODE(CA_RSN_CD,'R',1,0)+DECODE(CA_RSN_CD,'A',1,0)) " ).append("\n"); 
		query.append("--      - SUM(DECODE(UNCNT,0,DECODE(REV,'N',0,1),0))-SUM(UNCNT)                          AS CNT_EXEMPT " ).append("\n"); 
		query.append("    ,SUM(DECODE(( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		  FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		  WHERE    INTG_CD_ID = 'CD02572'" ).append("\n"); 
		query.append("		  AND INTG_CD_VAL_CTNT = DOC_PERF_EXPT_CD), '', 0, 1))		                    AS CNT_EXEMPT 														 " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_A,'N',0,1))                                    					AS CNT_KIND_A" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_B,'N',0,1))                                    					AS CNT_KIND_B" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_C,'N',0,1))                                    					AS CNT_KIND_C" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_D,'N',0,1))                                    					AS CNT_KIND_D" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_E,'N',0,1))                                    					AS CNT_KIND_E" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_F,'N',0,1))                                    					AS CNT_KIND_F" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_G,'N',0,1))                                    					AS CNT_KIND_G" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_H,'N',0,1))                                    					AS CNT_KIND_H" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_I,'N',0,1))                                    					AS CNT_KIND_I" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_J,'N',0,1))                                    					AS CNT_KIND_J" ).append("\n"); 
		query.append("	  ,SUM(DECODE(KIND_K,'N',0,1))                                    					AS CNT_KIND_K" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO                                   AS BKG_NO" ).append("\n"); 
		query.append("      ,BKG.BL_NO                                    AS BL_NO" ).append("\n"); 
		query.append("--      ,TRIM(BKG.POR_CD)								AS POR_CD" ).append("\n"); 
		query.append("--      ,TRIM(BKG.POL_CD)								AS POL_CD" ).append("\n"); 
		query.append("--      ,TRIM(BKG.POD_CD)								AS POD_CD" ).append("\n"); 
		query.append("--      ,TRIM(BKG.DEL_CD)							 	AS DEL_CD" ).append("\n"); 
		query.append("      ,BKG.BKG_OFC_CD                               AS BKG_OFC_CD       " ).append("\n"); 
		query.append("--      ,BKG.SLS_RHQ_CD                               AS SLS_RHQ_CD" ).append("\n"); 
		query.append("      ,NVL((SELECT DISTINCT OFC_N3RD_LVL_CD FROM BKG_OFC_LVL_V WHERE OFC_CD = COR.CORR_OFC_CD),'NON CA') AS SLS_RHQ_CD    " ).append("\n"); 
		query.append("      ,BKG.CTRT_OFC_CD                              AS CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,BKG.CTRT_SREP_CD                             AS CTRT_SREP_CD" ).append("\n"); 
		query.append("      ,COR.CORR_NO                                  AS CORR_NO" ).append("\n"); 
		query.append("      ,COR.CORR_OFC_CD                              AS CORR_OFC_CD" ).append("\n"); 
		query.append("      ,NVL(COR.CA_RSN_CD,'*')                       AS CA_RSN_CD     " ).append("\n"); 
		query.append("      ,NVL(COR.RAT_FLG,'N')                         AS REV" ).append("\n"); 
		query.append("      ,NVL(COR.EXPN_FLG,'N')                        AS EXP" ).append("\n"); 
		query.append("      ,NVL(COR.RT_CORR_FLG,'N')                     AS KIND_A" ).append("\n"); 
		query.append("      ,NVL(COR.CHG_TERM_CORR_FLG,'N')               AS KIND_B  " ).append("\n"); 
		query.append("      ,NVL(COR.RCVDE_TERM_CORR_FLG,'N')             AS KIND_C" ).append("\n"); 
		query.append("      ,NVL(COR.ROUT_CORR_FLG,'N')                   AS KIND_D" ).append("\n"); 
		query.append("      ,NVL(COR.CUST_CORR_FLG,'N')                   AS KIND_E" ).append("\n"); 
		query.append("      ,NVL(COR.QTY_CORR_FLG,'N')                    AS KIND_F" ).append("\n"); 
		query.append("      ,NVL(COR.MEAS_QTY_CORR_FLG,'N')               AS KIND_G" ).append("\n"); 
		query.append("      ,NVL(COR.CMDT_CORR_FLG,'N')                   AS KIND_H" ).append("\n"); 
		query.append("      ,NVL(COR.TRNK_VSL_CORR_FLG,'N')               AS KIND_I " ).append("\n"); 
		query.append("      ,NVL(COR.PRPST_VSL_CORR_FLG,'N')              AS KIND_J" ).append("\n"); 
		query.append("      ,NVL(COR.CA_OTR_RSN_CORR_FLG,'N')             AS KIND_K" ).append("\n"); 
		query.append("      ,DECODE(COR.DOC_PERF_EXPT_CD,NULL,0,1)        AS UNCNT" ).append("\n"); 
		query.append("      ,(Select SUM(CRR_HNGR_QTY)  from BKG_QTY_HIS where bkg_no = cor.bkg_no and cor.corr_no = corr_no)  AS C_HAUL" ).append("\n"); 
		query.append("      ,(Select SUM(MER_HNGR_QTY)  from BKG_QTY_HIS where bkg_no = cor.bkg_no and cor.corr_no = corr_no)  AS M_HAUL" ).append("\n"); 
		query.append("	  ,COR.DOC_PERF_EXPT_CD" ).append("\n"); 
		query.append("--	  ,PERF.GSO_OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING       BKG" ).append("\n"); 
		query.append("      ,BKG_CORRECTION    COR" ).append("\n"); 
		query.append("#if(${gso_ofc_cd} != '')      " ).append("\n"); 
		query.append("	  ,(SELECT BKG_OFC_CD, GSO_OFC_CD FROM BKG_DOC_PERF_OFC_V GROUP BY BKG_OFC_CD, GSO_OFC_CD)  PERF" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ctrt_ofc_cd} != '')	  " ).append("\n"); 
		query.append("	  ,(SELECT BKG_OFC_CD, GSO_OFC_CD FROM BKG_DOC_PERF_OFC_V GROUP BY BKG_OFC_CD, GSO_OFC_CD)  CTRT" ).append("\n"); 
		query.append("#end	  " ).append("\n"); 
		query.append("#if (${corr_from_dt} != '')" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = COR.BKG_NO" ).append("\n"); 
		query.append("   AND COR.CORR_NO <> '0000000001'" ).append("\n"); 
		query.append("   AND COR.CORR_NO <> 'TMP0000001'" ).append("\n"); 
		query.append("   AND COR.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND COR.CA_RSN_CD NOT IN ('F','E')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = COR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND COR.CORR_NO(+) <> '0000000001'" ).append("\n"); 
		query.append("   AND COR.CORR_NO(+) <> 'TMP0000001'" ).append("\n"); 
		query.append("   AND COR.CORR_CXL_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND COR.CA_RSN_CD(+) NOT IN ('F','E')" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD IN ('F','W','A')" ).append("\n"); 
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
		query.append("" ).append("\n"); 
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
		query.append("#if(${gso_ofc_cd} != '')" ).append("\n"); 
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
		query.append(")" ).append("\n"); 
		query.append(" GROUP BY ''" ).append("\n"); 
		query.append("--          POR_CD" ).append("\n"); 
		query.append("--         ,POL_CD" ).append("\n"); 
		query.append("--         ,POD_CD" ).append("\n"); 
		query.append("--         ,DEL_CD" ).append("\n"); 
		query.append("#if (${off_dis_op} != '')" ).append("\n"); 
		query.append("	  ${off_dis_op}" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("----------------------------------------------------------" ).append("\n"); 
		query.append("--BKG2 와 조인 걸기 위한 조건 'G' 조건에 따른 " ).append("\n"); 
		query.append("----------------------------------------------------------" ).append("\n"); 
		query.append("#if ((${off_dis_op_2} != '' || ${off_dis_op_3} != ''|| ${off_dis_op_4} != '' ) || (${contract_off} != '' ||${bkg_off} != '' ||${ca_issue_off} != '') )  -- bkg2 조건 " ).append("\n"); 
		query.append("    #if(${ca_reason_g}=='G') " ).append("\n"); 
		query.append("              ------------------------------------" ).append("\n"); 
		query.append("            #if(${off_dis_op_4} == '' && ${contract_off} == '' )" ).append("\n"); 
		query.append("              ------------------------------------" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("		          ,ctrt_ofc_cd,CTRT_SREP_CD" ).append("\n"); 
		query.append("		    #elseif(${off_dis_op_4} == '' && ${contract_off} != '' )" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("		          ,ctrt_ofc_cd,CTRT_SREP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		      ------------------------------------" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("            ------------------------------------" ).append("\n"); 
		query.append("              --todo--" ).append("\n"); 
		query.append("            #if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            	#if (${contract_off} != '' && ${ca_reason_g}!='G' )" ).append("\n"); 
		query.append("            		,CTRT_OFC_CD, CTRT_SREP_CD" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("            	#if (${bkg_off} != '')" ).append("\n"); 
		query.append("            		,bkg_ofc_cd  " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("            	#if (${ca_issue_off} != '')" ).append("\n"); 
		query.append("            		,corr_ofc_cd " ).append("\n"); 
		query.append("            	#end" ).append("\n"); 
		query.append("            	" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		    ------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("----------------------------------------------------------" ).append("\n"); 
		query.append("-- ORDER BY POR_CD" ).append("\n"); 
		query.append("--         ,POL_CD" ).append("\n"); 
		query.append("--         ,POD_CD" ).append("\n"); 
		query.append("--         ,DEL_CD       " ).append("\n"); 
		query.append(")CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${off_dis_op_2} != '' || ${off_dis_op_3} != ''|| ${off_dis_op_4} != '' ) || (${contract_off} != '' ||${bkg_off} != '' ||${ca_issue_off} != '') )" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT /*+ INDEX(B XAK6BKG_BOOKING) */ " ).append("\n"); 
		query.append("---jsy add2" ).append("\n"); 
		query.append("#if(${ca_reason_g}=='G') " ).append("\n"); 
		query.append("        B.CTRT_OFC_CD ,B.CTRT_SREP_CD, B.CTRT_OFC_CD g_ofc, COUNT(B.BKG_NO) tot_cnt_bl_ttl" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    	#if(${off_dis_op_4} != '')" ).append("\n"); 
		query.append("    	    B.CTRT_OFC_CD,B.CTRT_OFC_CD g_ofc, B.CTRT_SREP_CD, COUNT(B.BKG_NO) tot_cnt_bl_ttl--B.CTRT_OFC_CD, B.BKG_NO --, C.CORR_OFC_CD, C.CORR_OFC_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    	#elseif(${off_dis_op_2} != ''|| ${off_dis_op_3} != '')" ).append("\n"); 
		query.append("    	    B.BKG_OFC_CD,B.BKG_OFC_CD g_ofc, COUNT(B.BKG_NO) tot_cnt_bl_ttl--B.CTRT_OFC_CD, B.BKG_NO --, C.CORR_OFC_CD, C.CORR_OFC_CD" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        #if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        	#if (${contract_off} != '')" ).append("\n"); 
		query.append("        		B.CTRT_OFC_CD,B.CTRT_OFC_CD g_ofc, B.CTRT_SREP_CD, COUNT(B.BKG_NO) tot_cnt_bl_ttl" ).append("\n"); 
		query.append("        	#elseif (${bkg_off} != '' || ${ca_issue_off} != '')" ).append("\n"); 
		query.append("        		B.BKG_OFC_CD,B.BKG_OFC_CD g_ofc, COUNT(B.BKG_NO) tot_cnt_bl_ttl" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("---jsy add2     " ).append("\n"); 
		query.append("--	#if(${off_dis_op_4} != '')" ).append("\n"); 
		query.append("--	    B.CTRT_OFC_CD,B.CTRT_OFC_CD g_ofc, B.CTRT_SREP_CD, COUNT(B.BKG_NO) tot_cnt_bl_ttl--B.CTRT_OFC_CD, B.BKG_NO --, C.CORR_OFC_CD, C.CORR_OFC_CD" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--	#elseif(${off_dis_op_2} != ''|| ${off_dis_op_3} != '')" ).append("\n"); 
		query.append("--	    B.BKG_OFC_CD,B.BKG_OFC_CD g_ofc, COUNT(B.BKG_NO) tot_cnt_bl_ttl--B.CTRT_OFC_CD, B.BKG_NO --, C.CORR_OFC_CD, C.CORR_OFC_CD" ).append("\n"); 
		query.append("--	#end" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--#if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--	#if (${contract_off} != '')" ).append("\n"); 
		query.append("--		B.CTRT_OFC_CD,B.CTRT_OFC_CD g_ofc, B.CTRT_SREP_CD, COUNT(B.BKG_NO) tot_cnt_bl_ttl" ).append("\n"); 
		query.append("--	#elseif (${bkg_off} != '' || ${ca_issue_off} != '')" ).append("\n"); 
		query.append("--		B.BKG_OFC_CD,B.BKG_OFC_CD g_ofc, COUNT(B.BKG_NO) tot_cnt_bl_ttl" ).append("\n"); 
		query.append("--	#end" ).append("\n"); 
		query.append("--	" ).append("\n"); 
		query.append("--#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--B.BKG_OFC_CD, B.BKG_OFC_CD g_ofc, COUNT(B.BKG_NO) tot_cnt_bl_ttl--B.CTRT_OFC_CD, B.BKG_NO --, C.CORR_OFC_CD, C.CORR_OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_BOOKING B --,BKG_CORRECTION  C" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("	AND B.BKG_CRE_DT BETWEEN TO_DATE(nvl(@[corr_from_dt],@[cre_from_dt]) || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(nvl(@[corr_to_dt],@[cre_to_dt]) || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    AND B.BKG_STS_CD IN ('F','W','A')" ).append("\n"); 
		query.append("    GROUP BY " ).append("\n"); 
		query.append("---jsy add2" ).append("\n"); 
		query.append("#if(${ca_reason_g}=='G') " ).append("\n"); 
		query.append("        B.CTRT_OFC_CD ,B.CTRT_SREP_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        --------------------------------- " ).append("\n"); 
		query.append("    	#if(${off_dis_op_4} != '')" ).append("\n"); 
		query.append("    		B.CTRT_OFC_CD ,B.CTRT_SREP_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    	#elseif(${off_dis_op_2} != ''|| ${off_dis_op_3} != '')" ).append("\n"); 
		query.append("    		B.BKG_OFC_CD" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("        #if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        	#if (${contract_off} != '')" ).append("\n"); 
		query.append("        		B.CTRT_OFC_CD ,B.CTRT_SREP_CD" ).append("\n"); 
		query.append("        	#elseif (${bkg_off} != '' || ${ca_issue_off} != '')" ).append("\n"); 
		query.append("        		B.BKG_OFC_CD" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        --------------------------------- 	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("---jsy add2    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--	#if(${off_dis_op_4} != '')" ).append("\n"); 
		query.append("--		B.CTRT_OFC_CD ,B.CTRT_SREP_CD" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--	#elseif(${off_dis_op_2} != ''|| ${off_dis_op_3} != '')" ).append("\n"); 
		query.append("--		B.BKG_OFC_CD" ).append("\n"); 
		query.append("--	#end" ).append("\n"); 
		query.append("--#if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--	#if (${contract_off} != '')" ).append("\n"); 
		query.append("--		B.CTRT_OFC_CD ,B.CTRT_SREP_CD" ).append("\n"); 
		query.append("--	#elseif (${bkg_off} != '' || ${ca_issue_off} != '')" ).append("\n"); 
		query.append("--		B.BKG_OFC_CD" ).append("\n"); 
		query.append("--	#end" ).append("\n"); 
		query.append("--	" ).append("\n"); 
		query.append("--#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append(") BKG2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 0 = 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---jsy add2" ).append("\n"); 
		query.append("#if ((${off_dis_op_2} != '' || ${off_dis_op_3} != ''|| ${off_dis_op_4} != '' ) || (${contract_off} != '' ||${bkg_off} != '' ||${ca_issue_off} != '') )" ).append("\n"); 
		query.append("	#if(${ca_reason_g}=='G') " ).append("\n"); 
		query.append("    	AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("	    and bkg2.CTRT_SREP_CD(+) = cnt.CTRT_SREP_CD" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        ----------------------------" ).append("\n"); 
		query.append("        #if (${off_dis_op_4} != '' )" ).append("\n"); 
		query.append("        AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("        and bkg2.CTRT_SREP_CD(+) = cnt.CTRT_SREP_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #elseif (${off_dis_op_2} != '' || ${off_dis_op_3} != '')" ).append("\n"); 
		query.append("        AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        	#if (${contract_off} != '')" ).append("\n"); 
		query.append("        		AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("        		and bkg2.CTRT_SREP_CD (+)= cnt.CTRT_SREP_CD" ).append("\n"); 
		query.append("        	#elseif (${bkg_off} != '' || ${ca_issue_off} != '')" ).append("\n"); 
		query.append("        		AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ---------------------------" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("---jsy add2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--#if (${off_dis_op_4} != '' )" ).append("\n"); 
		query.append("--AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("--and bkg2.CTRT_SREP_CD(+) = cnt.CTRT_SREP_CD" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--#elseif (${off_dis_op_2} != '' || ${off_dis_op_3} != '')" ).append("\n"); 
		query.append("--AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("--#end" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--#if (${off_dis_op_2} == '' && ${off_dis_op_3} == '' && ${off_dis_op_4} == '')" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--	#if (${contract_off} != '')" ).append("\n"); 
		query.append("--		AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("--		and bkg2.CTRT_SREP_CD (+)= cnt.CTRT_SREP_CD" ).append("\n"); 
		query.append("--	#elseif (${bkg_off} != '' || ${ca_issue_off} != '')" ).append("\n"); 
		query.append("--		AND BKG2.g_ofc(+)= CNT.g_ofc" ).append("\n"); 
		query.append("--	#end" ).append("\n"); 
		query.append("--	" ).append("\n"); 
		query.append("--#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${other_op_1} != '')" ).append("\n"); 
		query.append("  AND CNT.CNT_HLG_C <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${other_op_2} != '')" ).append("\n"); 
		query.append("  AND CNT.CNT_HLG_M <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${other_op_3} != '')" ).append("\n"); 
		query.append("  AND CNT.CNT_EXEMPT <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}