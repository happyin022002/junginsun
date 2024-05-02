/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLogisticsRPT0080ListVO2RSQL.java
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

public class LogisticsRPTDBDAOSearchLogisticsRPT0080ListVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_COA_0080화면에서  DETAIL에 대한 쿼리입니다.
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchLogisticsRPT0080ListVO2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_load",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_incld_mt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_split_mw",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.integration").append("\n"); 
		query.append("FileName : LogisticsRPTDBDAOSearchLogisticsRPT0080ListVO2RSQL").append("\n"); 
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
		query.append("SELECT   P_REPORT" ).append("\n"); 
		query.append("		,TRD_CD   " ).append("\n"); 
		query.append("		,RLANE_CD" ).append("\n"); 
		query.append("		,DIR_CD" ).append("\n"); 
		query.append("		,P_LOAD" ).append("\n"); 
		query.append("		,COA_GET_CD_NM_FNC('CD01065', DECODE(COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR')) LGS_KPI_COST_GRP_NM" ).append("\n"); 
		query.append("	    ,COST_IO_BND_CD IN_OUT" ).append("\n"); 
		query.append("	    ,COA_GET_CD_NM_FNC(DECODE( P_KPITYPE, '1','CD01064', 'CD00950'), KPI_CD) KPI_NM" ).append("\n"); 
		query.append("		,SUM(VOL) VOL" ).append("\n"); 
		query.append("		,SUM(TM_AMT+TR_AMT) TOTAL_COST" ).append("\n"); 
		query.append("		,SUM(TM_AMT+TR_AMT)/DECODE(SUM(VOL), 0 , 1, SUM(VOL)) UNIT_COST" ).append("\n"); 
		query.append("FROM (SELECT   C3.BKG_NO" ).append("\n"); 
		query.append("			  ,C1.P_REPORT" ).append("\n"); 
		query.append("			  ,C1.P_LOAD" ).append("\n"); 
		query.append("			  ,C2.TRD_CD" ).append("\n"); 
		query.append("			  ,DECODE(C1.P_REPORT, 'T', 'X', C2.RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("			  ,DECODE(C1.P_REPORT, 'T', 'X', C2.DIR_CD) DIR_CD" ).append("\n"); 
		query.append("			  ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("			  ,CASE C5.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("			        WHEN 'PRWD' THEN 'O' " ).append("\n"); 
		query.append("			        WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("			        WHEN 'TRWD' THEN 'R' " ).append("\n"); 
		query.append("			   ELSE C5.COST_IO_BND_CD " ).append("\n"); 
		query.append("			   END AS COST_IO_BND_CD" ).append("\n"); 
		query.append("			  ,C1.P_KPITYPE" ).append("\n"); 
		query.append("			  ,DECODE(C1.P_KPITYPE,'1'" ).append("\n"); 
		query.append("			           ,DECODE(C5.STTL_FLG, 'Y', 'ST', C5.LGS_KPI_MN_CD)" ).append("\n"); 
		query.append("			           ,DECODE(C1.P_SHTL, 'Y', 'SHTL', C5.LGS_KPI_CD)) KPI_CD   /*Shuttle의 경우*/" ).append("\n"); 
		query.append("              ,AVG(NVL(C5.BKG_QTY, 0)) AS VOL" ).append("\n"); 
		query.append("              ,AVG(NVL(C5.VOID_20FT_QTY, 0) + NVL(C5.VOID_40FT_QTY, 0) * 2) AS VOID_VOL" ).append("\n"); 
		query.append("              ,SUM(C5.FCNTR_STVG_TTL_AMT) AS TM_AMT " ).append("\n"); 
		query.append("			  ,SUM(C5.FCNTR_TRSP_TTL_AMT) AS TR_AMT" ).append("\n"); 
		query.append("		FROM (SELECT   		 @[f_year] P_YEAR" ).append("\n"); 
		query.append("				            ,@[s_cost_yrmon2] P_COST_MON" ).append("\n"); 
		query.append("				            ,@[f_fm_mon] P_FM_MON" ).append("\n"); 
		query.append("				            ,@[f_to_mon] P_TO_MON" ).append("\n"); 
		query.append("				            ,@[f_sls_mon] P_SLS_MON" ).append("\n"); 
		query.append("				            ,@[s_cost_wk2] P_COST_WK" ).append("\n"); 
		query.append("				            ,@[f_fm_wk] P_FM_WK" ).append("\n"); 
		query.append("				            ,@[f_to_wk] P_TO_WK" ).append("\n"); 
		query.append("				            ,@[f_split_mw] P_SPLIT_MW" ).append("\n"); 
		query.append("				            ,@[f_report] P_REPORT" ).append("\n"); 
		query.append("				            ,NVL(@[s_trd_cd], @[f_trd_cd]) P_TRD_CD   " ).append("\n"); 
		query.append("				            ,NVL(@[s_rlane_cd], @[f_rlane_cd]) P_RLANE_CD   " ).append("\n"); 
		query.append("				            ,NVL(@[s_skd_dir_cd], @[f_skd_dir_cd]) P_SKD_DIR_CD " ).append("\n"); 
		query.append("				            ,@[f_kpi_type] P_KPITYPE" ).append("\n"); 
		query.append("				            ,@[f_lgs_mn_kpi_cd] P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("				            ,@[f_lgs_kpi_cd] P_LGS_KPI_CD" ).append("\n"); 
		query.append("				            ,@[f_incld_mt] P_INCLD_MT				            " ).append("\n"); 
		query.append("                    		,@[s_load] P_LOAD   " ).append("\n"); 
		query.append("				            ,DECODE(@[f_lgs_mn_kpi_cd], 'ST', 'Y', 'N') P_MN_SHTL   /*맨앞이 세팅할넘 P_LGS_KPI_MN_CD*/" ).append("\n"); 
		query.append("				            ,DECODE(@[f_lgs_kpi_cd], 'SHTL', 'Y', 'N') P_SHTL 		/*맨앞이 세팅할넘 P_LGS_KPI_CD*/" ).append("\n"); 
		query.append("				FROM DUAL) C1" ).append("\n"); 
		query.append("				          ,COA_MON_VVD C2" ).append("\n"); 
		query.append("				          ,COA_RGST_BKG C3" ).append("\n"); 
		query.append("				          ,COA_BKG_LGS_SMRY C5" ).append("\n"); 
		query.append("				WHERE 1 = 1" ).append("\n"); 
		query.append("		 			#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("		      		   #if (${s_cost_yrmon2} != '')" ).append("\n"); 
		query.append("		            	  AND SLS_YRMON = C1.P_YEAR||C1.P_COST_MON " ).append("\n"); 
		query.append("		             	  AND COST_WK = C1.P_COST_WK		" ).append("\n"); 
		query.append("		      		   #elseif (${s_cost_yrmon2} == '' && ${f_sls_mon} != '')	       " ).append("\n"); 
		query.append("                   		  AND SLS_YRMON LIKE C1.P_YEAR||C1.P_SLS_MON			" ).append("\n"); 
		query.append("  					      AND COST_WK BETWEEN C1.P_FM_WK AND C1.P_TO_WK	" ).append("\n"); 
		query.append("  				       #else " ).append("\n"); 
		query.append("  					      AND SLS_YRMON LIKE C1.P_YEAR||'%'  				" ).append("\n"); 
		query.append("  					      AND COST_WK BETWEEN C1.P_FM_WK AND C1.P_TO_WK	" ).append("\n"); 
		query.append("  				       #end" ).append("\n"); 
		query.append("  				    #elseif (${f_chkprd} == 'M')     	        	" ).append("\n"); 
		query.append("		               #if (${s_cost_yrmon2} != '')" ).append("\n"); 
		query.append("      				      AND COST_YRMON = C1.P_YEAR||C1.P_COST_MON  			" ).append("\n"); 
		query.append("      				   #else" ).append("\n"); 
		query.append("      				      AND COST_YRMON BETWEEN C1.P_YEAR||C1.P_FM_MON AND C1.P_YEAR||C1.P_TO_MON " ).append("\n"); 
		query.append("      				   #end				" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("		            #if (${s_trd_cd} != '')" ).append("\n"); 
		query.append("      				      AND C2.TRD_CD = C1.P_TRD_CD " ).append("\n"); 
		query.append("      		        #end" ).append("\n"); 
		query.append("			        #if (${s_rlane_cd} != '' || ${f_rlane_cd} != '')" ).append("\n"); 
		query.append("      		              AND C2.RLANE_CD = C1.P_RLANE_CD" ).append("\n"); 
		query.append("      		        #end" ).append("\n"); 
		query.append("			        #if (${s_skd_dir_cd} != '' || ${f_skd_dir_cd} != '')" ).append("\n"); 
		query.append("      		              AND C2.DIR_CD = C1.P_SKD_DIR_CD " ).append("\n"); 
		query.append("      		        #end" ).append("\n"); 
		query.append("		            #if (${f_lgs_kpi_cd} != '' && ${f_kpi_type} == '2')" ).append("\n"); 
		query.append("	      	           #if (${f_lgs_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("      			          AND C5.STTL_FLG = 'Y'" ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("				          AND C5.LGS_KPI_CD = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("      				   #end   " ).append("\n"); 
		query.append("      		        #end                 " ).append("\n"); 
		query.append("			        #if (${f_lgs_mn_kpi_cd} != '' && ${f_kpi_type} == '1')" ).append("\n"); 
		query.append("      		           #if (${f_lgs_mn_kpi_cd} == 'ST')" ).append("\n"); 
		query.append("		      		      AND C5.STTL_FLG = 'Y'" ).append("\n"); 
		query.append("        			   #else" ).append("\n"); 
		query.append("			              AND C5.LGS_KPI_MN_CD = C1.P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("      				   #end   " ).append("\n"); 
		query.append("      		        #end" ).append("\n"); 
		query.append("		            #if (${f_incld_mt} == '')" ).append("\n"); 
		query.append("			              AND C5.COST_ACT_GRP_CD  NOT IN ('NIBC','NOBC')			" ).append("\n"); 
		query.append("      		        #end" ).append("\n"); 
		query.append("      		" ).append("\n"); 
		query.append("                          AND C3.BKG_STS_CD IN('F', 'S')" ).append("\n"); 
		query.append("      				      AND C3.BL_NO_TP IN('M', '0')" ).append("\n"); 
		query.append("      				      AND C2.DELT_FLG NOT IN('Y')" ).append("\n"); 
		query.append("      				      AND C3.BKG_CGO_TP_CD NOT IN('P')" ).append("\n"); 
		query.append("      				      AND C2.VSL_CD = C3.VSL_CD" ).append("\n"); 
		query.append("      				      AND C2.SKD_VOY_NO = C3.SKD_VOY_NO" ).append("\n"); 
		query.append("      				      AND C2.DIR_CD = C3.DIR_CD" ).append("\n"); 
		query.append("      				      AND C2.TRD_CD = C3.TRD_CD" ).append("\n"); 
		query.append("      				      AND C2.RLANE_CD = C3.RLANE_CD" ).append("\n"); 
		query.append("      				      AND C2.IOC_CD = C3.IOC_CD" ).append("\n"); 
		query.append("      				      AND C3.BKG_NO = C5.BKG_NO" ).append("\n"); 
		query.append("			 GROUP BY C3.BKG_NO" ).append("\n"); 
		query.append(" 		             ,C1.P_REPORT" ).append("\n"); 
		query.append("				     ,C1.P_LOAD" ).append("\n"); 
		query.append("		             ,C2.TRD_CD" ).append("\n"); 
		query.append("				     ,DECODE(C1.P_REPORT, 'T', 'X', C2.RLANE_CD)" ).append("\n"); 
		query.append("				     ,DECODE(C1.P_REPORT, 'T', 'X', C2.DIR_CD)" ).append("\n"); 
		query.append("				     ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("				     ,CASE C5.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("				             WHEN 'PRWD' THEN 'O' " ).append("\n"); 
		query.append("				             WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("				             WHEN 'TRWD' THEN 'R' " ).append("\n"); 
		query.append("				             ELSE C5.COST_IO_BND_CD " ).append("\n"); 
		query.append("				       END" ).append("\n"); 
		query.append("				     ,C1.P_KPITYPE" ).append("\n"); 
		query.append("				     ,DECODE(C1.P_KPITYPE,'1' " ).append("\n"); 
		query.append("				     			,DECODE(C5.STTL_FLG, 'Y', 'ST', C5.LGS_KPI_MN_CD)" ).append("\n"); 
		query.append("				    			,DECODE(C1.P_SHTL, 'Y', 'SHTL', C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("			          )" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("GROUP BY P_REPORT" ).append("\n"); 
		query.append("		,P_LOAD" ).append("\n"); 
		query.append("		,TRD_CD" ).append("\n"); 
		query.append("		,RLANE_CD" ).append("\n"); 
		query.append("		,DIR_CD" ).append("\n"); 
		query.append("		,COA_GET_CD_NM_FNC('CD01065', DECODE(COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR'))" ).append("\n"); 
		query.append("		,COST_IO_BND_CD" ).append("\n"); 
		query.append("		,COA_GET_CD_NM_FNC(DECODE( P_KPITYPE, '1','CD01064', 'CD00950'), KPI_CD) " ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("		,COA_GET_CD_NM_FNC('CD01065', DECODE(COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR'))" ).append("\n"); 
		query.append("		,COST_IO_BND_CD" ).append("\n"); 

	}
}