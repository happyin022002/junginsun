/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLogisticsRPT0080ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LogisticsRPTDBDAOSearchLogisticsRPT0080ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Logistics Lane조회
	  * 2011.06.21 이석준 [CHM-201111642-01] 
	  *                  COA Logistics Exp. By Office화면에서 R.Month / S.Month 구분요청
	  * 2012.11.28 원종규 [CHM-201221658-01] AVG(VOID_VOL) -> SUM(VOID_VOL) 로 변경
	  * 2014.07.10 PEJ [CHM-201431087] [COA] Multi-Dimension Report > Logistics PFMC > Expense 화면 조회로직 변경요청
	  *                       TMNL/TRANS Volume Incentive 제외
	  *                       모든계정의 AMT가 0 이 아니것
	  * 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchLogisticsRPT0080ListVORSQL(){
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
		params.put("f_excld_crr_hlg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_lgs_kpi3_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_incld_tml",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.integration").append("\n"); 
		query.append("FileName : LogisticsRPTDBDAOSearchLogisticsRPT0080ListVORSQL").append("\n"); 
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
		query.append("--Logistics Exp. By Lane - Sheet1" ).append("\n"); 
		query.append("SELECT P_REPORT" ).append("\n"); 
		query.append("      ,COST_YRMONWK" ).append("\n"); 
		query.append("      ,COST_YRMON" ).append("\n"); 
		query.append("      ,COST_RMON" ).append("\n"); 
		query.append("      ,COST_WK" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,SUM(LOAD) LOAD" ).append("\n"); 
		query.append("      ,SUM(VOID_VOL) VOID_VOL" ).append("\n"); 
		query.append("      ,SUM(TM_AMT) TM_AMT" ).append("\n"); 
		query.append("      ,SUM(TR_AMT) TR_AMT" ).append("\n"); 
		query.append("      ,SUM(TOTAL_AMT) TOTAL_AMT" ).append("\n"); 
		query.append("      ,SUM(TM_AMT) / DECODE(SUM(LOAD), 0, 1, SUM(LOAD)) UNIT_TM" ).append("\n"); 
		query.append("      ,SUM(TR_AMT) / DECODE(SUM(LOAD), 0, 1, SUM(LOAD)) UNIT_TR" ).append("\n"); 
		query.append("      ,SUM(TM_AMT + TR_AMT) / DECODE(SUM(LOAD), 0, 1, SUM(LOAD)) UNIT_TTL" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT BKG_NO" ).append("\n"); 
		query.append("               ,P_REPORT          /* split을 안하면 모두 X, 두개다 있는경우, month만 있는경우, week만 있는경우 */" ).append("\n"); 
		query.append("#if(${f_chkprd} =='W' && ${f_split_mw} =='T')" ).append("\n"); 
		query.append("               ,COST_YRMON || COST_WK AS COST_YRMONWK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("               ,COST_RMON || COST_WK AS COST_YRMONWK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ,COST_YRMON" ).append("\n"); 
		query.append("               ,COST_RMON" ).append("\n"); 
		query.append("               ,COST_WK" ).append("\n"); 
		query.append("               ,TRD_CD" ).append("\n"); 
		query.append("               ,RLANE_CD" ).append("\n"); 
		query.append("               ,DIR_CD" ).append("\n"); 
		query.append("               ,SUM(LOAD) AS LOAD" ).append("\n"); 
		query.append("               ,SUM(VOID_VOL) AS VOID_VOL" ).append("\n"); 
		query.append("               ,SUM(TM_AMT) AS TM_AMT" ).append("\n"); 
		query.append("               ,DECODE(@[f_excld_crr_hlg], 'T', SUM(TR_AMT), SUM(TR_AMT) - SUM(CRR_HLG_SVC_CHG_AMT)) AS TR_AMT" ).append("\n"); 
		query.append("               ,DECODE(@[f_excld_crr_hlg], 'T', SUM(TM_AMT + TR_AMT), SUM(TM_AMT + TR_AMT) - SUM(CRR_HLG_SVC_CHG_AMT)) AS TOTAL_AMT" ).append("\n"); 
		query.append("               ,SUM(CRR_HLG_SVC_CHG_AMT) AS CRR_HLG_SVC_CHG_AMT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                SELECT   /*+ ORDERED */" ).append("\n"); 
		query.append("                         C3.BKG_NO" ).append("\n"); 
		query.append("                        ,C5.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        ,C1.P_REPORT" ).append("\n"); 
		query.append("                        ,C1.P_SPLIT_MW" ).append("\n"); 
		query.append("                        ,C1.P_CHKPRD" ).append("\n"); 
		query.append("                        ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.SLS_YRMON, 'X') AS COST_YRMON" ).append("\n"); 
		query.append("                        ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_YRMON, 'TM', C2.COST_YRMON, 'X') AS COST_RMON" ).append("\n"); 
		query.append("                        ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_WK, 'X') AS COST_WK" ).append("\n"); 
		query.append("                        ,C2.TRD_CD" ).append("\n"); 
		query.append("                        ,DECODE(C1.P_REPORT, '1', 'X', C2.RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("                        ,DECODE(C1.P_REPORT, '1', 'X', C2.DIR_CD) DIR_CD" ).append("\n"); 
		query.append("                        ,AVG(DECODE(SUBSTR(C5.CNTR_TPSZ_CD, -1, 1), '2', NVL(C5.BKG_QTY, 0), '3', NVL(C5.BKG_QTY, 0), NVL(C5.BKG_QTY, 0) * 2)) AS LOAD" ).append("\n"); 
		query.append("                        ,AVG(NVL(C5.VOID_20FT_QTY, 0) + NVL(C5.VOID_40FT_QTY, 0) * 2) VOID_VOL" ).append("\n"); 
		query.append("                        ,CASE C1.P_INCLD_TML" ).append("\n"); 
		query.append("                             WHEN 'T' THEN SUM(C5.FCNTR_STVG_TTL_AMT - NVL(C5.TML_VOL_INCNT_AMT,0) )" ).append("\n"); 
		query.append("                             ELSE SUM(C5.FCNTR_STVG_TTL_AMT - NVL(C5.TML_VOL_INCNT_AMT,0) - C5.TML_AMT)" ).append("\n"); 
		query.append("                         END AS TM_AMT" ).append("\n"); 
		query.append("                        ,SUM(C5.FCNTR_TRSP_TTL_AMT - NVL(C5.TRNS_VOL_INCNT_AMT,0)) TR_AMT" ).append("\n"); 
		query.append("                        ,SUM(NVL(C5.CRR_HLG_SVC_CHG_AMT,0)) CRR_HLG_SVC_CHG_AMT" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("                        SELECT @[f_year]          P_YEAR" ).append("\n"); 
		query.append("                              ,@[f_fm_mon]        P_SCOST_YRMON" ).append("\n"); 
		query.append("                              ,@[f_to_mon]        P_ECOST_YRMON" ).append("\n"); 
		query.append("                              ,@[f_sls_mon]       P_SLS_MON" ).append("\n"); 
		query.append("                              ,@[f_fm_wk]         P_SCOST_WEEK" ).append("\n"); 
		query.append("                              ,@[f_to_wk]         P_ECOST_WEEK" ).append("\n"); 
		query.append("                              ,@[f_split_mw]      P_SPLIT_MW" ).append("\n"); 
		query.append("                              ,@[f_report]        P_REPORT" ).append("\n"); 
		query.append("                              ,@[f_trd_cd]        P_TRD_CD" ).append("\n"); 
		query.append("                              ,@[f_rlane_cd]      P_RLANE_CD" ).append("\n"); 
		query.append("                              ,@[f_skd_dir_cd]    P_SKD_DIR_CD" ).append("\n"); 
		query.append("                              ,@[f_kpi_type]      P_KPITYPE" ).append("\n"); 
		query.append("                              ,@[f_lgs_mn_kpi_cd] P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("                              ,@[f_lgs_kpi_cd]    P_LGS_KPI_CD" ).append("\n"); 
		query.append("                              ,@[f_lgs_kpi3_cd]   P_LGS_KPI3_CD" ).append("\n"); 
		query.append("                              ,@[f_incld_tml]     P_INCLD_TML" ).append("\n"); 
		query.append("                              ,@[f_chkprd]        P_CHKPRD" ).append("\n"); 
		query.append("                              ,DECODE(@[f_lgs_mn_kpi_cd], 'ST', 'Y', 'N') P_MN_SHTL   /*맨앞이 세팅할넘 P_LGS_KPI_MN_CD*/" ).append("\n"); 
		query.append("                              ,DECODE(@[f_lgs_kpi_cd], 'SHTL', 'Y', 'N') P_SHTL       /*맨앞이 세팅할넘 P_LGS_KPI_CD*/" ).append("\n"); 
		query.append("                          FROM DUAL" ).append("\n"); 
		query.append("                          ) C1" ).append("\n"); 
		query.append("                          ,COA_MON_VVD C2" ).append("\n"); 
		query.append("                          ,COA_RGST_BKG C3" ).append("\n"); 
		query.append("                          ,COA_BKG_LGS_SMRY C5" ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("    #if (${f_sls_mon} != '')" ).append("\n"); 
		query.append("                       AND SLS_YRMON           = C1.P_YEAR||C1.P_SLS_MON" ).append("\n"); 
		query.append("                       AND COST_WK             BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                       AND SLS_YRMON           LIKE C1.P_YEAR||'%'" ).append("\n"); 
		query.append("                       AND COST_WK             BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("                       AND COST_YRMON          BETWEEN C1.P_YEAR||P_SCOST_YRMON AND C1.P_YEAR||C1.P_ECOST_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} !='')" ).append("\n"); 
		query.append("                       AND C2.TRD_CD           = C1.P_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} !='')" ).append("\n"); 
		query.append("                       AND C2.RLANE_CD         = C1.P_RLANE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("                       AND C2.DIR_CD           = C1.P_SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${f_kpi_type} == '1') && ${f_lgs_mn_kpi_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_lgs_mn_kpi_cd} == 'ST')" ).append("\n"); 
		query.append("                       AND C5.STTL_FLG         = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                       AND C5.STTL_FLG         <> 'Y'" ).append("\n"); 
		query.append("                       AND C5.LGS_KPI_MN_CD    = C1.P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${f_kpi_type} == '2') && ${f_lgs_kpi_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_lgs_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("                       AND C5.STTL_FLG         = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                       AND C5.STTL_FLG         <> 'Y'" ).append("\n"); 
		query.append("                       AND C5.LGS_KPI_CD       = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${f_kpi_type} == '3') && ${f_lgs_kpi3_cd} != '')" ).append("\n"); 
		query.append("                       --KIP3는 코드를 들고 있는것이 아니라 DESC를 들고 있어서 아래와 같이 걸어 줘야 함" ).append("\n"); 
		query.append("                       AND C5.LGS_KPI_CD       IN (" ).append("\n"); 
		query.append("                                                    SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                                      FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                     WHERE INTG_CD_ID       = 'CD03163'" ).append("\n"); 
		query.append("                                                       AND INTG_CD_VAL_DESC = C1.P_LGS_KPI3_CD" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       AND C5.COST_ACT_GRP_CD  NOT IN ('NIBC','NOBC')" ).append("\n"); 
		query.append("                       AND C3.BKG_STS_CD       IN('F', 'S')" ).append("\n"); 
		query.append("                       AND C3.BL_NO_TP         IN('M', '0')" ).append("\n"); 
		query.append("                       AND C2.DELT_FLG         NOT IN('Y')" ).append("\n"); 
		query.append("                       AND C3.BKG_CGO_TP_CD    NOT IN('P')" ).append("\n"); 
		query.append("                       AND C2.VSL_CD           = C3.VSL_CD" ).append("\n"); 
		query.append("                       AND C2.SKD_VOY_NO       = C3.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND C2.DIR_CD           = C3.DIR_CD" ).append("\n"); 
		query.append("                       AND C2.TRD_CD           = C3.TRD_CD" ).append("\n"); 
		query.append("                       AND C2.RLANE_CD         = C3.RLANE_CD" ).append("\n"); 
		query.append("                       AND C2.IOC_CD           = C3.IOC_CD" ).append("\n"); 
		query.append("                       AND C3.BKG_NO           = C5.BKG_NO" ).append("\n"); 
		query.append("                     GROUP BY C3.BKG_NO" ).append("\n"); 
		query.append("                             ,C5.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             ,C1.P_REPORT" ).append("\n"); 
		query.append("                             ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.SLS_YRMON, 'X')" ).append("\n"); 
		query.append("                             ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_YRMON, 'TM', C2.COST_YRMON, 'X')" ).append("\n"); 
		query.append("                             ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_WK, 'X')" ).append("\n"); 
		query.append("                             ,C2.TRD_CD" ).append("\n"); 
		query.append("                             ,DECODE(C1.P_REPORT, '1', 'X', C2.RLANE_CD)" ).append("\n"); 
		query.append("                             ,DECODE(C1.P_REPORT, '1', 'X', C2.DIR_CD)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            GROUP BY BKG_NO" ).append("\n"); 
		query.append("                    ,P_REPORT" ).append("\n"); 
		query.append("                    ,COST_YRMON" ).append("\n"); 
		query.append("                    ,COST_RMON" ).append("\n"); 
		query.append("                    ,COST_WK" ).append("\n"); 
		query.append("                    ,TRD_CD" ).append("\n"); 
		query.append("                    ,RLANE_CD" ).append("\n"); 
		query.append("                    ,DIR_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY P_REPORT" ).append("\n"); 
		query.append("        ,COST_YRMONWK" ).append("\n"); 
		query.append("        ,COST_YRMON" ).append("\n"); 
		query.append("        ,COST_RMON" ).append("\n"); 
		query.append("        ,COST_WK" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("ORDER BY COST_YRMONWK" ).append("\n"); 
		query.append("        ,COST_YRMON" ).append("\n"); 
		query.append("        ,COST_RMON" ).append("\n"); 
		query.append("        ,COST_WK" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 

	}
}