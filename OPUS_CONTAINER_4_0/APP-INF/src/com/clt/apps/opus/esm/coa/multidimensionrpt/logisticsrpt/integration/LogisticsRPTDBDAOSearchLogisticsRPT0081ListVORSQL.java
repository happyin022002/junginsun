/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLogisticsRPT0081ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.12 
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

public class LogisticsRPTDBDAOSearchLogisticsRPT0081ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Logistics Exp. by Office [ESM_COA_0081화면] 쿼리1
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchLogisticsRPT0081ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chkprd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_in_out",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_incld_mt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.integration").append("\n"); 
		query.append("FileName : LogisticsRPTDBDAOSearchLogisticsRPT0081ListVORSQL").append("\n"); 
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
		query.append("        ,COST_YRMON||COST_WK AS COST_YRMONWK" ).append("\n"); 
		query.append("        ,COST_YRMON" ).append("\n"); 
		query.append("        ,COST_WK" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,CTRL_OFC_CD" ).append("\n"); 
		query.append("        ,COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("        ,COA_GET_CD_NM_FNC('CD01065', DECODE(COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR')) LGS_KPI_COST_GRP_NM" ).append("\n"); 
		query.append("        ,KPI_CD" ).append("\n"); 
		query.append("        ,COA_GET_CD_NM_FNC(DECODE(P_KPITYPE, '1', 'CD01064', 'CD00950'), KPI_CD) KPI_NM" ).append("\n"); 
		query.append("        ,SUM(VOL) VOL" ).append("\n"); 
		query.append("        ,SUM(TM_AMT + TR_AMT) TOTAL_COST" ).append("\n"); 
		query.append("        ,SUM(TM_AMT + TR_AMT) / DECODE(SUM(VOL), 0, 1, SUM(VOL)) UNIT_COST" ).append("\n"); 
		query.append("        ,'3' KPI_ORDER" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("       SELECT   #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("                  /*+  FULL(c3) PARALLEL(c3,4)*/" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                  /*+ ordered FULL(c3) PARALLEL(c3,4) use_nl(c6)*/" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("               C1.P_REPORT       /*split을 안하면 모두 X, 두개다 있는경우, month만 있는경우, week만 있는경우*/" ).append("\n"); 
		query.append("              ,(CASE WHEN C1.P_SPLIT_MW||P_CHKPRD = 'TW' THEN C2.SLS_YRMON" ).append("\n"); 
		query.append("                     WHEN C1.P_SPLIT_MW||P_CHKPRD = 'TM' THEN C2.COST_YRMON" ).append("\n"); 
		query.append("                     ELSE 'X'" ).append("\n"); 
		query.append("                END) AS COST_YRMON" ).append("\n"); 
		query.append("              ,(CASE WHEN C1.P_SPLIT_MW||P_CHKPRD = 'TW' THEN C2.COST_WK" ).append("\n"); 
		query.append("                     ELSE 'X'" ).append("\n"); 
		query.append("                END) AS COST_WK" ).append("\n"); 
		query.append("              ,(CASE WHEN C1.P_REPORT = '1' THEN 'X'" ).append("\n"); 
		query.append("                     ELSE C6.OFC_N2ND_LVL_CD                          " ).append("\n"); 
		query.append("                 END ) AS RHQ_CD     /*RHQ, Control OFFICE에서만 보여준다.*/" ).append("\n"); 
		query.append("              ,(CASE WHEN C1.P_REPORT = '3' THEN C6.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                     ELSE 'X'" ).append("\n"); 
		query.append("                 END) AS CTRL_OFC_CD    /*Control OFFICE에서만 보여준다.*/" ).append("\n"); 
		query.append("              ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("              ,C1.P_KPITYPE" ).append("\n"); 
		query.append("              ,(CASE WHEN C1.P_KPITYPE = '1' THEN (CASE WHEN C5.STTL_FLG = 'Y' THEN 'ST' ELSE C5.LGS_KPI_MN_CD END)" ).append("\n"); 
		query.append("                     ELSE(CASE WHEN C5.STTL_FLG = 'Y' THEN 'SHTL' ELSE C5.LGS_KPI_CD END)" ).append("\n"); 
		query.append("                 END) AS KPI_CD" ).append("\n"); 
		query.append("              ,SUM(NVL(C5.CNTR_QTY, 0)) VOL" ).append("\n"); 
		query.append("              ,SUM(C5.FCNTR_STVG_TTL_AMT) AS TM_AMT" ).append("\n"); 
		query.append("              ,SUM(C5.FCNTR_TRSP_TTL_AMT) AS TR_AMT" ).append("\n"); 
		query.append("        FROM (SELECT  @[f_year] P_YEAR" ).append("\n"); 
		query.append("                  , @[f_fm_mon] P_SCOST_YRMON" ).append("\n"); 
		query.append("                  , @[f_to_mon] P_ECOST_YRMON" ).append("\n"); 
		query.append("                  , @[f_sls_mon] P_SLS_MON" ).append("\n"); 
		query.append("                  , @[f_fm_wk] P_SCOST_WEEK" ).append("\n"); 
		query.append("                  , @[f_to_wk] P_ECOST_WEEK" ).append("\n"); 
		query.append("                  , @[f_split_mw] P_SPLIT_MW" ).append("\n"); 
		query.append("                  , @[f_chkprd] P_CHKPRD" ).append("\n"); 
		query.append("                  , @[f_report] P_REPORT" ).append("\n"); 
		query.append("                  , @[f_rhq_cd] P_RHQ_CD" ).append("\n"); 
		query.append("                  , @[f_ctrl_ofc_cd] P_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  , @[f_in_out] P_INOUT" ).append("\n"); 
		query.append("                  ,DECODE(@[f_lgs_kpi_cost_grp_cd], 'TM', 'N', 'TR', 'L', '') P_COST_ACT_GRP_TP_CD   /*P_LGS_KPI_COST_GRP_CD*/" ).append("\n"); 
		query.append("                  ,@[f_kpi_type] P_KPITYPE" ).append("\n"); 
		query.append("                  ,@[f_lgs_mn_kpi_cd] P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("                  ,@[f_lgs_kpi_cd] P_LGS_KPI_CD" ).append("\n"); 
		query.append("                  ,@[f_incld_mt] P_INCLD_MT                  " ).append("\n"); 
		query.append("                  ,DECODE(@[f_lgs_mn_kpi_cd], 'ST', 'Y', 'N') P_MN_SHTL" ).append("\n"); 
		query.append("                  ,DECODE(@[f_lgs_kpi_cd], 'SHTL', 'Y', 'N') P_SHTL" ).append("\n"); 
		query.append("             FROM DUAL) C1" ).append("\n"); 
		query.append("                       ,COA_MON_VVD C2" ).append("\n"); 
		query.append("                       ,COA_RGST_BKG C3" ).append("\n"); 
		query.append("                       ,COA_BKG_LGS_SMRY C5" ).append("\n"); 
		query.append("                       ,COA_OFC_LVL C6" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("                #if (${f_sls_mon} != '')" ).append("\n"); 
		query.append("               AND SLS_YRMON = C1.P_YEAR || C1.P_SLS_MON" ).append("\n"); 
		query.append("               AND COST_WK BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("               AND SLS_YRMON LIKE C1.P_YEAR||'%'  /*SLS_YRMON*/" ).append("\n"); 
		query.append("               AND COST_WK BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK     /*COST_WK*/" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("             #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("               AND C2.COST_YRMON BETWEEN C1.P_SCOST_YRMON AND C1.P_ECOST_YRMON" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_lgs_kpi_cd} != '' && ${f_kpi_type} == '2')" ).append("\n"); 
		query.append("                #if (${f_lgs_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("               AND C5.STTL_FLG = 'Y'" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("               AND C5.LGS_KPI_CD = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_lgs_mn_kpi_cd} != '' && ${f_kpi_type} == '1')" ).append("\n"); 
		query.append("                #if (${f_lgs_mn_kpi_cd} == 'ST')" ).append("\n"); 
		query.append("               AND C5.STTL_FLG = 'Y'" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("               AND C5.LGS_KPI_MN_CD = C1.P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_incld_mt} == '')" ).append("\n"); 
		query.append("               AND C5.COST_ACT_GRP_CD  NOT IN ('NIBC','NOBC')" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_rhq_cd} != '')                " ).append("\n"); 
		query.append("               AND C6.OFC_N2ND_LVL_CD = C1.P_RHQ_CD                " ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("               AND C6.OFC_N5TH_LVL_CD = C1.P_CTRL_OFC_CD" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_lgs_kpi_cost_grp_cd} != '')" ).append("\n"); 
		query.append("               AND C5.COST_ACT_GRP_TP_CD = C1.P_COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_in_out} != '')" ).append("\n"); 
		query.append("               AND CASE C5.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                     WHEN 'PRWD' THEN 'O'" ).append("\n"); 
		query.append("                     WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("                     WHEN 'TRWD' THEN 'C'" ).append("\n"); 
		query.append("                     ELSE C5.COST_IO_BND_CD" ).append("\n"); 
		query.append("                   END = @[f_in_out]" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               AND C3.BKG_STS_CD IN('F', 'S')" ).append("\n"); 
		query.append("               AND C3.BL_NO_TP IN('M', '0')" ).append("\n"); 
		query.append("               AND C2.DELT_FLG NOT IN('Y')" ).append("\n"); 
		query.append("               AND C3.BKG_CGO_TP_CD NOT IN('P')" ).append("\n"); 
		query.append("               AND C2.VSL_CD = C3.VSL_CD" ).append("\n"); 
		query.append("               AND C2.SKD_VOY_NO = C3.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND C2.DIR_CD = C3.DIR_CD" ).append("\n"); 
		query.append("               AND C2.TRD_CD = C3.TRD_CD" ).append("\n"); 
		query.append("               AND C2.RLANE_CD = C3.RLANE_CD" ).append("\n"); 
		query.append("               AND C2.IOC_CD = C3.IOC_CD" ).append("\n"); 
		query.append("               AND C3.BKG_NO = C5.BKG_NO" ).append("\n"); 
		query.append("               AND C5.CTRL_OFC_CD = C6.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("               AND C2.SLS_YRMON BETWEEN C6.OFC_APLY_FM_YRMON  and C6.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("             #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("               AND C2.COST_YRMON BETWEEN C6.OFC_APLY_FM_YRMON  and C6.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            GROUP BY C1.P_REPORT" ).append("\n"); 
		query.append("                    ,(CASE WHEN C1.P_SPLIT_MW||P_CHKPRD = 'TW' THEN C2.SLS_YRMON" ).append("\n"); 
		query.append("                           WHEN C1.P_SPLIT_MW||P_CHKPRD = 'TM' THEN C2.COST_YRMON" ).append("\n"); 
		query.append("                           ELSE 'X'" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("                    ,(CASE WHEN C1.P_SPLIT_MW||P_CHKPRD = 'TW' THEN C2.COST_WK" ).append("\n"); 
		query.append("                           ELSE 'X'" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("                    ,(CASE WHEN C1.P_REPORT = '1' THEN 'X'" ).append("\n"); 
		query.append("                           ELSE C6.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("                    ,(CASE WHEN C1.P_REPORT = '3' THEN C6.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                           ELSE 'X'" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("                    ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("                    ,C1.P_KPITYPE" ).append("\n"); 
		query.append("                    ,(CASE WHEN C1.P_KPITYPE = '1' THEN (CASE WHEN C5.STTL_FLG = 'Y' THEN 'ST' ELSE C5.LGS_KPI_MN_CD END )" ).append("\n"); 
		query.append("                           ELSE (CASE WHEN C5.STTL_FLG = 'Y' THEN 'SHTL' ELSE C5.LGS_KPI_CD END)" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("GROUP BY P_REPORT" ).append("\n"); 
		query.append("        ,COST_YRMON" ).append("\n"); 
		query.append("        ,COST_WK" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,CTRL_OFC_CD" ).append("\n"); 
		query.append("        ,COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("        ,KPI_CD" ).append("\n"); 
		query.append("        ,COA_GET_CD_NM_FNC('CD01065', DECODE(COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR'))" ).append("\n"); 
		query.append("        ,COA_GET_CD_NM_FNC(DECODE(P_KPITYPE, '1', 'CD01064', 'CD00950'), KPI_CD)" ).append("\n"); 
		query.append("ORDER BY COST_YRMON" ).append("\n"); 
		query.append("        ,COST_WK" ).append("\n"); 
		query.append("        , COST_ACT_GRP_TP_CD DESC" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,CTRL_OFC_CD" ).append("\n"); 
		query.append("        ,KPI_ORDER" ).append("\n"); 
		query.append("        ,KPI_CD" ).append("\n"); 

	}
}