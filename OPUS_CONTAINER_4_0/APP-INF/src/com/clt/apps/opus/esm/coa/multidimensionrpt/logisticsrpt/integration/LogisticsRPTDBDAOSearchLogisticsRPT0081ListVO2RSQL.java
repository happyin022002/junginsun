/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLogisticsRPT0081ListVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LogisticsRPTDBDAOSearchLogisticsRPT0081ListVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Logistics Exp. by Office [ESM_COA_0081화면] 쿼리2
	  * 2010.12.13 이윤정[CHM-201007143-01] Fuel Surcharge Code 분리 요건
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchLogisticsRPT0081ListVO2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_report",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_in_out",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lgs_kpi_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_incld_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_kpi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cost_wk2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lgs_kpi_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_kpi_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cost_yrmon2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lgs_mn_kpi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lgs_kpi_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.integration").append("\n"); 
		query.append("FileName : LogisticsRPTDBDAOSearchLogisticsRPT0081ListVO2RSQL").append("\n"); 
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
		query.append("SELECT P_REPORT" ).append("\n"); 
		query.append("    ,RHQ_CD" ).append("\n"); 
		query.append("    ,CTRL_OFC_CD" ).append("\n"); 
		query.append("    ,COA_GET_CD_NM_FNC('CD01065', DECODE(COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR')) LGS_KPI_COST_GRP_NM" ).append("\n"); 
		query.append("    ,COA_GET_CD_NM_FNC(DECODE(P_KPITYPE, '1', 'CD01064', 'CD00950'), KPI_CD) KPI_NM" ).append("\n"); 
		query.append("    ,COST_IO_BND_CD IN_OUT" ).append("\n"); 
		query.append("    ,VOL" ).append("\n"); 
		query.append("    ,STND_COST_NM" ).append("\n"); 
		query.append("    ,AMT TOTAL_COST" ).append("\n"); 
		query.append("    ,AMT / DECODE(VOL, 0, 1, VOL) UNIT_COST" ).append("\n"); 
		query.append("    FROM (SELECT 	D2.P_REPORT" ).append("\n"); 
		query.append("           ,D2.RHQ_CD" ).append("\n"); 
		query.append("           ,D2.CTRL_OFC_CD" ).append("\n"); 
		query.append("           ,D2.COST_IO_BND_CD" ).append("\n"); 
		query.append("           ,D2.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("           ,D2.P_KPITYPE" ).append("\n"); 
		query.append("           ,D2.KPI_CD" ).append("\n"); 
		query.append("           ,D2.VOL" ).append("\n"); 
		query.append("           ,D1.STND_COST_CD" ).append("\n"); 
		query.append("           ,D1.STND_COST_NM" ).append("\n"); 
		query.append("           ,DECODE(D1.STND_COST_CD" ).append("\n"); 
		query.append("           			,'51101011', BZC_STVG_AMT" ).append("\n"); 
		query.append("           			,'51101071', OTR_CY_HNDL_AMT" ).append("\n"); 
		query.append("           			,'51101021', TS_STVG_AMT" ).append("\n"); 
		query.append("           			,'51101031', DCK_CY_HNDL_AMT" ).append("\n"); 
		query.append("           			,'51101051', CGO_HNDL_AMT" ).append("\n"); 
		query.append("           			,'51101041', FCNTR_STO_AMT" ).append("\n"); 
		query.append("           			,'51101061', MISC_CGO_HNDL_AMT" ).append("\n"); 
		query.append("           			,'51301011', FCNTR_TRSP_RAIL_DIR_AMT" ).append("\n"); 
		query.append("           			,'51301021', FCNTR_TRSP_RAIL_TRK_AMT" ).append("\n"); 
		query.append("           			,'51301031', FCNTR_TRSP_TRK_DIR_AMT" ).append("\n"); 
		query.append("           			,'51301041', FCNTR_TRSP_WTR_DIR_AMT" ).append("\n"); 
		query.append("           			,'51301051', FCNTR_TRSP_WTR_RAIL_AMT" ).append("\n"); 
		query.append("           			,'51301061', FCNTR_TRSP_WTR_TRK_AMT" ).append("\n"); 
		query.append("           			,'51301081', MISC_FCNTR_TRSP_AMT" ).append("\n"); 
		query.append("					,'51301091', FCNTR_TRSP_FUEL_SCG_AMT  -- 추가           			" ).append("\n"); 
		query.append("           			) AMT" ).append("\n"); 
		query.append("           FROM (SELECT  ROWNUM RN" ).append("\n"); 
		query.append("        				,STND_COST_CD" ).append("\n"); 
		query.append("        				,STND_COST_NM" ).append("\n"); 
		query.append("        		   FROM COA_STND_ACCT" ).append("\n"); 
		query.append("        		  WHERE SGRP_COST_CD IN ('CVFS', 'CVTR', 'CVIP')       			" ).append("\n"); 
		query.append("        		 ) D1" ).append("\n"); 
		query.append("                  ,(SELECT  " ).append("\n"); 
		query.append("                            C1.P_REPORT" ).append("\n"); 
		query.append("                           ,DECODE(C1.P_REPORT, '1', 'X', C6.OFC_N3RD_LVL_CD) RHQ_CD  /*RHQ, Control OFFICE에서만 보여준다.*/" ).append("\n"); 
		query.append("                           ,DECODE(C1.P_REPORT, '3', C6.OFC_N5TH_LVL_CD, 'X') CTRL_OFC_CD  /*Control OFFICE에서만 보여준다.*/" ).append("\n"); 
		query.append("                           ,CASE C5.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                         		WHEN 'PRWD' THEN 'O' " ).append("\n"); 
		query.append("                         		WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("                         		WHEN 'TRWD' THEN 'C' " ).append("\n"); 
		query.append("                         		ELSE C5.COST_IO_BND_CD " ).append("\n"); 
		query.append("                            END AS COST_IO_BND_CD" ).append("\n"); 
		query.append("                          ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("                          ,C1.P_KPITYPE" ).append("\n"); 
		query.append("                          ,DECODE(C1.P_KPITYPE, '1', " ).append("\n"); 
		query.append("                                    DECODE(C5.STTL_FLG, 'Y', 'ST', C5.LGS_KPI_MN_CD), " ).append("\n"); 
		query.append("                                    DECODE(C5.STTL_FLG, 'Y', 'SHTL', C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                            ) KPI_CD							/*Shuttle의 경우*/" ).append("\n"); 
		query.append("                          ,SUM(NVL(C5.CNTR_QTY, 0)) VOL" ).append("\n"); 
		query.append("                          ,SUM(BZC_STVG_AMT) BZC_STVG_AMT" ).append("\n"); 
		query.append("                          ,SUM(OTR_CY_HNDL_AMT) OTR_CY_HNDL_AMT" ).append("\n"); 
		query.append("                          ,SUM(TS_STVG_AMT) TS_STVG_AMT" ).append("\n"); 
		query.append("                          ,SUM(DCK_CY_HNDL_AMT) DCK_CY_HNDL_AMT" ).append("\n"); 
		query.append("                          ,SUM(CGO_HNDL_AMT) CGO_HNDL_AMT" ).append("\n"); 
		query.append("                          ,SUM(FCNTR_STO_AMT) FCNTR_STO_AMT" ).append("\n"); 
		query.append("                          ,SUM(MISC_CGO_HNDL_AMT) MISC_CGO_HNDL_AMT" ).append("\n"); 
		query.append("                          ,SUM(FCNTR_TRSP_RAIL_DIR_AMT) FCNTR_TRSP_RAIL_DIR_AMT" ).append("\n"); 
		query.append("                          ,SUM(FCNTR_TRSP_RAIL_TRK_AMT) FCNTR_TRSP_RAIL_TRK_AMT" ).append("\n"); 
		query.append("                          ,SUM(FCNTR_TRSP_TRK_DIR_AMT) FCNTR_TRSP_TRK_DIR_AMT" ).append("\n"); 
		query.append("                          ,SUM(FCNTR_TRSP_WTR_DIR_AMT) FCNTR_TRSP_WTR_DIR_AMT" ).append("\n"); 
		query.append("                          ,SUM(FCNTR_TRSP_WTR_RAIL_AMT) FCNTR_TRSP_WTR_RAIL_AMT" ).append("\n"); 
		query.append("                          ,SUM(FCNTR_TRSP_WTR_TRK_AMT) FCNTR_TRSP_WTR_TRK_AMT" ).append("\n"); 
		query.append("                          ,SUM(MISC_FCNTR_TRSP_AMT) MISC_FCNTR_TRSP_AMT" ).append("\n"); 
		query.append("                          ,SUM(FCNTR_TRSP_FUEL_SCG_AMT) FCNTR_TRSP_FUEL_SCG_AMT                          " ).append("\n"); 
		query.append("                    FROM (SELECT  @[f_year] P_YEAR" ).append("\n"); 
		query.append("                                 ,@[s_cost_yrmon2] P_SCOST_MON" ).append("\n"); 
		query.append("                                 ,@[f_fm_mon] P_FM_MON" ).append("\n"); 
		query.append("                                 ,@[f_to_mon] P_TO_MON" ).append("\n"); 
		query.append("                                 ,@[f_sls_mon] P_SLS_MON" ).append("\n"); 
		query.append("                                 ,@[s_cost_wk2] P_SCOST_WEEK" ).append("\n"); 
		query.append("                                 ,@[f_fm_wk] P_FM_WEEK" ).append("\n"); 
		query.append("                                 ,@[f_to_wk] P_TO_WEEK" ).append("\n"); 
		query.append("                                 ,@[f_report] P_REPORT" ).append("\n"); 
		query.append("                                 ,NVL(@[s_rhq_cd], @[f_rhq_cd]) P_RHQ_CD" ).append("\n"); 
		query.append("                                 ,NVL(@[s_cntr_ofc_cd], @[f_ctrl_ofc_cd]) P_CTRL_OFC_CD" ).append("\n"); 
		query.append("                                 ,@[f_in_out] P_INOUT" ).append("\n"); 
		query.append("                                 ,NVL(@[s_lgs_kpi_cost_grp_cd], @[f_lgs_kpi_cost_grp_cd]) P_COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("                                 ,@[f_kpi_type] P_KPITYPE" ).append("\n"); 
		query.append("                                 ,DECODE(@[f_kpi_type], '1', NVL(@[s_kpi_cd], @[f_lgs_mn_kpi_cd]), '') P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("                                 ,DECODE(@[f_kpi_type], '2', NVL(@[s_kpi_cd], @[f_lgs_kpi_cd]), '') P_LGS_KPI_CD" ).append("\n"); 
		query.append("                                 ,@[f_incld_mt] P_INCLD_MT" ).append("\n"); 
		query.append("                                 ,DECODE(NVL(@[s_kpi_cd], @[f_lgs_mn_kpi_cd]), 'ST', 'Y', 'N') P_MN_SHTL   /*맨앞이 세팅할넘 p_lgs_kpi_mn_cd*/" ).append("\n"); 
		query.append("                                 ,DECODE(NVL(@[s_kpi_cd], @[f_lgs_kpi_cd]), 'SHTL', 'Y', 'N') P_SHTL  	   /*맨앞이 세팅할넘 p_lgs_kpi_cd*/" ).append("\n"); 
		query.append("                         FROM DUAL) C1" ).append("\n"); 
		query.append("    	                           ,COA_MON_VVD C2" ).append("\n"); 
		query.append("    	                           ,COA_RGST_BKG C3" ).append("\n"); 
		query.append("    	                           ,COA_BKG_LGS_SMRY C5" ).append("\n"); 
		query.append("    	                           ,COA_OFC_LVL C6" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("    					#if (${f_chkprd} == 'W') " ).append("\n"); 
		query.append("                        	#if (${s_cost_yrmon2} != '')" ).append("\n"); 
		query.append("                          		AND SLS_YRMON = P_YEAR||P_SCOST_MON" ).append("\n"); 
		query.append("                          		AND COST_WK = C1.P_SCOST_WEEK	" ).append("\n"); 
		query.append("                        	#elseif (${s_cost_yrmon2} == '' && ${f_sls_mon} == '')  " ).append("\n"); 
		query.append("                          		AND SLS_YRMON LIKE P_YEAR||'%' " ).append("\n"); 
		query.append("                          		AND COST_WK BETWEEN C1.P_FM_WEEK AND C1.P_TO_WEEK" ).append("\n"); 
		query.append("                        	#elseif (${s_cost_yrmon2} == '' && ${f_sls_mon} != '')  " ).append("\n"); 
		query.append("                          		AND SLS_YRMON LIKE P_YEAR||P_SLS_MON" ).append("\n"); 
		query.append("                          		AND COST_WK BETWEEN C1.P_FM_WEEK AND C1.P_TO_WEEK" ).append("\n"); 
		query.append("                        	#end" ).append("\n"); 
		query.append("                        #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("                            #if (${s_cost_yrmon2} != '')" ).append("\n"); 
		query.append("                              	AND C2.COST_YRMON = C1.P_YEAR||C1.P_SCOST_MON " ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("                              	AND C2.COST_YRMON BETWEEN C1.P_YEAR||C1.P_FM_MON AND C1.P_YEAR||C1.P_TO_MON" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                      	#if (${f_lgs_kpi_cd} != '' && ${f_kpi_type} == '2')" ).append("\n"); 
		query.append("          	       			#if (${f_lgs_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("        			        	AND C5.STTL_FLG = 'Y'" ).append("\n"); 
		query.append("                   			#else" ).append("\n"); 
		query.append("    			            	AND C5.LGS_KPI_CD = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("        			    	#end   " ).append("\n"); 
		query.append("                 		#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                        #if (${f_lgs_mn_kpi_cd} != '' && ${f_kpi_type} == '1')" ).append("\n"); 
		query.append("        		       		#if (${f_lgs_mn_kpi_cd} == 'ST' ||${s_kpi_cd} == 'ST')" ).append("\n"); 
		query.append("    	      		      		AND C5.STTL_FLG = 'Y'" ).append("\n"); 
		query.append("          		     		#else" ).append("\n"); 
		query.append("    		              		AND C5.LGS_KPI_MN_CD = C1.P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("        				   #end   " ).append("\n"); 
		query.append("                  		#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                      	#if (${s_kpi_cd} != '')" ).append("\n"); 
		query.append("                           #if (${f_kpi_type} == '2')" ).append("\n"); 
		query.append("                              #if (${s_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("                                  AND C5.STTL_FLG = 'Y'" ).append("\n"); 
		query.append("                              #else" ).append("\n"); 
		query.append("                                  AND C5.LGS_KPI_CD = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                          #elseif(${f_kpi_type} == '1')" ).append("\n"); 
		query.append("                              #if (${f_lgs_mn_kpi_cd} == 'ST' || ${s_kpi_cd} == 'ST')" ).append("\n"); 
		query.append("                                  AND C5.STTL_FLG = 'Y'" ).append("\n"); 
		query.append("                              #else" ).append("\n"); 
		query.append("                                  AND C5.LGS_KPI_MN_CD = C1.P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                       #if (${f_incld_mt} == '')" ).append("\n"); 
		query.append("                          	AND C5.COST_ACT_GRP_CD  NOT IN ('NIBC','NOBC')" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                      #if (${f_rhq_cd} != '' || ${s_rhq_cd} != '')                          " ).append("\n"); 
		query.append("                              AND C6.OFC_N2ND_LVL_CD = C1.P_RHQ_CD" ).append("\n"); 
		query.append("                  	  #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                      #if (${f_ctrl_ofc_cd} != '' || ${s_cntr_ofc_cd} != '')" ).append("\n"); 
		query.append("                         AND C6.OFC_N5TH_LVL_CD = C1.P_CTRL_OFC_CD" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                	  #if (${f_lgs_kpi_cost_grp_cd} != '' || ${s_lgs_kpi_cost_grp_cd} != '')" ).append("\n"); 
		query.append("                         AND C5.COST_ACT_GRP_TP_CD = C1.P_COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                      #if (${f_in_out} != '')" ).append("\n"); 
		query.append("                         AND CASE C5.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("    	                     WHEN 'PRWD' THEN 'O'" ).append("\n"); 
		query.append("                             WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("                             WHEN 'TRWD' THEN 'C'" ).append("\n"); 
		query.append("                             ELSE C5.COST_IO_BND_CD" ).append("\n"); 
		query.append("                             	END = @[f_in_out]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          AND C3.BKG_STS_CD IN('F', 'S')" ).append("\n"); 
		query.append("                          AND C3.BL_NO_TP IN('M', '0')" ).append("\n"); 
		query.append("                          AND C2.DELT_FLG NOT IN('Y')" ).append("\n"); 
		query.append("                          AND C3.BKG_CGO_TP_CD NOT IN('P')" ).append("\n"); 
		query.append("                          AND C2.VSL_CD = C3.VSL_CD" ).append("\n"); 
		query.append("                          AND C2.SKD_VOY_NO = C3.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND C2.DIR_CD = C3.DIR_CD" ).append("\n"); 
		query.append("                          AND C2.TRD_CD = C3.TRD_CD" ).append("\n"); 
		query.append("                          AND C2.RLANE_CD = C3.RLANE_CD" ).append("\n"); 
		query.append("                          AND C2.IOC_CD = C3.IOC_CD" ).append("\n"); 
		query.append("                          AND C3.BKG_NO = C5.BKG_NO" ).append("\n"); 
		query.append("                          AND C5.CTRL_OFC_CD = C6.OFC_CD" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("                      #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("                          AND C2.SLS_YRMON BETWEEN C6.OFC_APLY_FM_YRMON  and C6.OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("                      #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("                          AND C2.COST_YRMON BETWEEN C6.OFC_APLY_FM_YRMON  and C6.OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("                      #end    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("             GROUP BY C1.P_REPORT" ).append("\n"); 
		query.append("                     ,DECODE(C1.P_REPORT, '1', 'X', C6.OFC_N3RD_LVL_CD)" ).append("\n"); 
		query.append("                     ,DECODE(C1.P_REPORT, '3', C6.OFC_N5TH_LVL_CD, 'X')" ).append("\n"); 
		query.append("                     ,CASE C5.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                     		WHEN 'PRWD' THEN 'O' " ).append("\n"); 
		query.append("                     		WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("                     		WHEN 'TRWD' THEN 'C' " ).append("\n"); 
		query.append("                     		ELSE C5.COST_IO_BND_CD " ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                     ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("                     ,C1.P_KPITYPE" ).append("\n"); 
		query.append("                     ,DECODE(C1.P_KPITYPE, '1', " ).append("\n"); 
		query.append("                                  DECODE(C5.STTL_FLG, 'Y', 'ST', C5.LGS_KPI_MN_CD), " ).append("\n"); 
		query.append("                                  DECODE(C5.STTL_FLG, 'Y', 'SHTL', C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("              ) D2" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE  AMT  > 0" ).append("\n"); 

	}
}