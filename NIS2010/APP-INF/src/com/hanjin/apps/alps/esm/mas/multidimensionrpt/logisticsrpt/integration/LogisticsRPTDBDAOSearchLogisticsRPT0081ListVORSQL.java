/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLogisticsRPT0081ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class LogisticsRPTDBDAOSearchLogisticsRPT0081ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Logistics Exp. by Office [ESM_MAS_0081화면] 쿼리1
	  * 2011.06.21 이석준 [CHM-201111642-01] 
	  *                  MAS Logistics Exp. By Office화면에서 R.Month / S.Month 구분요청
	  * 2014.07.10 PEJ [CHM-201431087] [MAS] Multi-Dimension Report > Logistics PFMC > Expense 화면 조회로직 변경요청
	  *                       모든계정의 AMT가 0 이 아니것
	  *                       VOLUME INCENTIVE AMT 제외
	  * 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
	  * 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
		params.put("f_excld_crr_hlg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration").append("\n"); 
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
		query.append("--Logistics Exp. By Office - Sheet1" ).append("\n"); 
		query.append("SELECT P_REPORT" ).append("\n"); 
		query.append("#if(${f_chkprd} =='W' && ${f_split_mw} =='T')" ).append("\n"); 
		query.append("      ,COST_YRMON || COST_WK AS COST_YRMONWK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,COST_RMON || COST_WK  AS COST_YRMONWK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,COST_YRMON" ).append("\n"); 
		query.append("      ,COST_RMON" ).append("\n"); 
		query.append("      ,COST_WK" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,CASE WHEN KPI_CD = 'RAIL' THEN DECODE(CTRL_OFC_CD, 'PHXSA', 'NYCRA', CTRL_OFC_CD)" ).append("\n"); 
		query.append("       ELSE CTRL_OFC_CD" ).append("\n"); 
		query.append("       END CTRL_OFC_CD" ).append("\n"); 
		query.append("      ,COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("      ,MAS_GET_CD_NM_FNC('CD01065', DECODE(COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR')) LGS_KPI_COST_GRP_NM" ).append("\n"); 
		query.append("--      ,KPI_CD" ).append("\n"); 
		query.append("      ,CASE WHEN P_KPITYPE = '3' THEN" ).append("\n"); 
		query.append("           D2.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("           MAS_GET_CD_NM_FNC(DECODE( P_KPITYPE, '1','CD01064', '2', 'CD00950'), KPI_CD)" ).append("\n"); 
		query.append("       END KPI_NM              " ).append("\n"); 
		query.append("      ,P_KPITYPE" ).append("\n"); 
		query.append("      ,SUM(VOL) VOL" ).append("\n"); 
		query.append("      ,DECODE(@[f_excld_crr_hlg], 'T', SUM(TM_AMT + TR_AMT), SUM(TM_AMT + TR_AMT - CRR_HLG_AMT)) TOTAL_COST" ).append("\n"); 
		query.append("      ,DECODE(@[f_excld_crr_hlg], 'T', SUM(TM_AMT + TR_AMT), SUM(TM_AMT + TR_AMT - CRR_HLG_AMT)) / DECODE(SUM(VOL), 0, 1, SUM(VOL)) UNIT_COST" ).append("\n"); 
		query.append("      ,'3' KPI_ORDER" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("               /*+  FULL(c3) PARALLEL(c3,4)*/" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("               /*+ ordered FULL(c3) PARALLEL(c3,4) use_nl(c6)*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               C1.P_REPORT       /*split을 안하면 모두 X, 두개다 있는경우, month만 있는경우, week만 있는경우*/" ).append("\n"); 
		query.append("              ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.SLS_YRMON, 'X') AS COST_YRMON" ).append("\n"); 
		query.append("              ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_YRMON, 'TM', C2.COST_YRMON, 'X') AS COST_RMON" ).append("\n"); 
		query.append("              ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_WK, 'X') AS COST_WK" ).append("\n"); 
		query.append("              ,(CASE WHEN C1.P_REPORT = '1' THEN 'X'" ).append("\n"); 
		query.append("                     ELSE (CASE WHEN C1.P_YEAR = '2007' OR C1.P_YEAR = '2008' THEN C6.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                                ELSE C6.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("                            END)" ).append("\n"); 
		query.append("                 END ) AS RHQ_CD     /*RHQ, Control OFFICE에서만 보여준다.*/" ).append("\n"); 
		query.append("              ,(CASE WHEN C1.P_REPORT = '3' THEN C6.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                     ELSE 'X'" ).append("\n"); 
		query.append("                 END) AS CTRL_OFC_CD    /*Control OFFICE에서만 보여준다.*/" ).append("\n"); 
		query.append("              ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("              ,C1.P_KPITYPE" ).append("\n"); 
		query.append("              ,DECODE(C1.P_KPITYPE,'1',DECODE(C5.STTL_FLG, 'Y',   'ST', C5.LGS_KPI_MN_CD)" ).append("\n"); 
		query.append("                                  ,'2',DECODE(C5.STTL_FLG, 'Y', 'SHTL', C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                  ,'3',DECODE(C5.RHQ_CD,'SHARC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                       ,'SELSC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                       ,'TYOSC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                       ,C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                      ) KPI_CD   /*Shuttle의 경우*/" ).append("\n"); 
		query.append("              ,SUM(NVL(C5.CNTR_QTY, 0)) VOL" ).append("\n"); 
		query.append("              ,(CASE C1.P_INCLD_TML" ).append("\n"); 
		query.append("                    WHEN 'T' THEN SUM(C5.FCNTR_STVG_TTL_AMT - NVL(C5.TML_VOL_INCNT_AMT,0))" ).append("\n"); 
		query.append("                    ELSE SUM(C5.FCNTR_STVG_TTL_AMT - NVL(C5.TML_VOL_INCNT_AMT,0) - C5.TML_AMT)" ).append("\n"); 
		query.append("               END) AS TM_AMT" ).append("\n"); 
		query.append("              ,SUM(C5.FCNTR_TRSP_TTL_AMT - NVL(C5.TRNS_VOL_INCNT_AMT,0)) TR_AMT" ).append("\n"); 
		query.append("              ,SUM(NVL(C5.CRR_HLG_SVC_CHG_AMT,0)) CRR_HLG_AMT" ).append("\n"); 
		query.append("         FROM (SELECT @[f_year]     P_YEAR" ).append("\n"); 
		query.append("                    ,@[f_fm_mon]   P_SCOST_YRMON" ).append("\n"); 
		query.append("                    ,@[f_to_mon]   P_ECOST_YRMON" ).append("\n"); 
		query.append("                    ,@[f_sls_mon]  P_SLS_MON" ).append("\n"); 
		query.append("                    ,@[f_fm_wk]    P_SCOST_WEEK" ).append("\n"); 
		query.append("                    ,@[f_to_wk]    P_ECOST_WEEK" ).append("\n"); 
		query.append("                    ,@[f_split_mw] P_SPLIT_MW" ).append("\n"); 
		query.append("                    ,@[f_chkprd]   P_CHKPRD" ).append("\n"); 
		query.append("                    ,@[f_report]   P_REPORT" ).append("\n"); 
		query.append("                    ,@[f_rhq_cd]   P_RHQ_CD" ).append("\n"); 
		query.append("                    ,@[f_ctrl_ofc_cd] P_CTRL_OFC_CD" ).append("\n"); 
		query.append("                    ,@[f_in_out]   P_INOUT" ).append("\n"); 
		query.append("                    ,DECODE(@[f_lgs_kpi_cost_grp_cd], 'TM', 'N', 'TR', 'L', '') P_COST_ACT_GRP_TP_CD   /*P_LGS_KPI_COST_GRP_CD*/" ).append("\n"); 
		query.append("                    ,@[f_kpi_type] P_KPITYPE" ).append("\n"); 
		query.append("                    ,@[f_lgs_mn_kpi_cd] P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("                    ,@[f_lgs_kpi_cd] P_LGS_KPI_CD" ).append("\n"); 
		query.append("                    ,@[f_incld_tml] P_INCLD_TML" ).append("\n"); 
		query.append("                    ,DECODE(@[f_lgs_mn_kpi_cd], 'ST', 'Y', 'N') P_MN_SHTL" ).append("\n"); 
		query.append("                    ,DECODE(@[f_lgs_kpi_cd], 'SHTL', 'Y', 'N') P_SHTL" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("              ) C1" ).append("\n"); 
		query.append("             ,MAS_MON_VVD C2" ).append("\n"); 
		query.append("             ,MAS_RGST_BKG C3" ).append("\n"); 
		query.append("             ,MAS_BKG_LGS_SMRY C5" ).append("\n"); 
		query.append("             ,MAS_OFC_LVL C6" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("    #if (${f_sls_mon} != '')" ).append("\n"); 
		query.append("          AND C2.SLS_YRMON           = C1.P_YEAR || C1.P_SLS_MON" ).append("\n"); 
		query.append("          AND C2.COST_WK             BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          AND C2.SLS_YRMON           LIKE C1.P_YEAR||'%'" ).append("\n"); 
		query.append("          AND C2.COST_WK             BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK     /*COST_WK*/" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("          AND C2.COST_YRMON          BETWEEN C1.P_SCOST_YRMON AND C1.P_ECOST_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_kpi_type} == '2' && ${f_lgs_kpi_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_lgs_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("          AND C5.STTL_FLG            = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          AND C5.STTL_FLG            <> 'Y'" ).append("\n"); 
		query.append("          AND C5.LGS_KPI_CD          = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_kpi_type} == '1' && ${f_lgs_mn_kpi_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_lgs_mn_kpi_cd} == 'ST')" ).append("\n"); 
		query.append("          AND C5.STTL_FLG            = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          AND C5.STTL_FLG            <> 'Y'" ).append("\n"); 
		query.append("          AND C5.LGS_KPI_MN_CD       = C1.P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${f_kpi_type} == '3') && ${f_lgs_kpi3_cd} != '')" ).append("\n"); 
		query.append("                   --KIP3는 코드를 들고 있는것이 아니라 DESC를 들고 있어서 아래와 같이 걸어 줘야 함" ).append("\n"); 
		query.append("          AND C5.LGS_KPI_CD       IN (" ).append("\n"); 
		query.append("                                       SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                        WHERE INTG_CD_ID       = 'CD03163'" ).append("\n"); 
		query.append("                                          AND INTG_CD_VAL_DESC = C1.P_LGS_KPI3_CD" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND C5.COST_ACT_GRP_CD     NOT IN ('NIBC','NOBC')" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_year} == '2007' || ${f_year} == '2008')" ).append("\n"); 
		query.append("          AND C6.OFC_N3RD_LVL_CD     = C1.P_RHQ_CD" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          AND C6.OFC_N2ND_LVL_CD     = C1.P_RHQ_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_ctrl_ofc_cd} == 'PHXSA')" ).append("\n"); 
		query.append("          AND C6.OFC_N5TH_LVL_CD     = C1.P_CTRL_OFC_CD" ).append("\n"); 
		query.append("          AND C5.LGS_KPI_CD         != 'RAIL'" ).append("\n"); 
		query.append("    #elseif (${f_ctrl_ofc_cd} == 'NYCRA')" ).append("\n"); 
		query.append("          AND (C6.OFC_N5TH_LVL_CD    = 'NYCRA' OR (C6.OFC_N5TH_LVL_CD = 'PHXSA' AND C5.LGS_KPI_CD = 'RAIL'))" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          AND C6.OFC_N5TH_LVL_CD     = C1.P_CTRL_OFC_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_lgs_kpi_cost_grp_cd} != '')" ).append("\n"); 
		query.append("          AND C5.COST_ACT_GRP_TP_CD  = C1.P_COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_in_out} != '')" ).append("\n"); 
		query.append("          AND CASE C5.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                WHEN 'PRWD' THEN 'O'" ).append("\n"); 
		query.append("                WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("                WHEN 'TRWD' THEN 'R'" ).append("\n"); 
		query.append("                ELSE C5.COST_IO_BND_CD" ).append("\n"); 
		query.append("              END = @[f_in_out]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("          AND C2.SLS_YRMON           BETWEEN C6.OFC_APLY_FM_YRMON  and C6.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("          AND C2.COST_YRMON          BETWEEN C6.OFC_APLY_FM_YRMON  and C6.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND C3.BKG_STS_CD          IN('F', 'S')" ).append("\n"); 
		query.append("          AND C3.BL_NO_TP            IN('M', '0')" ).append("\n"); 
		query.append("          AND C2.DELT_FLG            NOT IN('Y')" ).append("\n"); 
		query.append("          AND C3.BKG_CGO_TP_CD       NOT IN('P')" ).append("\n"); 
		query.append("          AND C2.VSL_CD              = C3.VSL_CD" ).append("\n"); 
		query.append("          AND C2.SKD_VOY_NO          = C3.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND C2.DIR_CD              = C3.DIR_CD" ).append("\n"); 
		query.append("          AND C2.TRD_CD              = C3.TRD_CD" ).append("\n"); 
		query.append("          AND C2.RLANE_CD            = C3.RLANE_CD" ).append("\n"); 
		query.append("          AND C2.IOC_CD              = C3.IOC_CD" ).append("\n"); 
		query.append("          AND C3.BKG_NO              = C5.BKG_NO" ).append("\n"); 
		query.append("          AND C5.CTRL_OFC_CD         = C6.OFC_CD" ).append("\n"); 
		query.append("        GROUP BY C1.P_REPORT" ).append("\n"); 
		query.append("                ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.SLS_YRMON, 'X')" ).append("\n"); 
		query.append("                ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_YRMON, 'TM', C2.COST_YRMON, 'X')" ).append("\n"); 
		query.append("                ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_WK, 'X')" ).append("\n"); 
		query.append("                ,(CASE WHEN C1.P_REPORT = '1' THEN 'X'" ).append("\n"); 
		query.append("                       ELSE (CASE WHEN C1.P_YEAR = '2007' OR C1.P_YEAR = '2008' THEN C6.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                                  ELSE C6.OFC_N2ND_LVL_CD END)" ).append("\n"); 
		query.append("                   END)" ).append("\n"); 
		query.append("                ,(CASE WHEN C1.P_REPORT = '3' THEN C6.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                       ELSE 'X'" ).append("\n"); 
		query.append("                   END)" ).append("\n"); 
		query.append("                ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("                ,C1.P_KPITYPE" ).append("\n"); 
		query.append("                ,DECODE(C1.P_KPITYPE,'1',DECODE(C5.STTL_FLG, 'Y',   'ST', C5.LGS_KPI_MN_CD)" ).append("\n"); 
		query.append("                                    ,'2',DECODE(C5.STTL_FLG, 'Y', 'SHTL', C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                    ,'3',DECODE(C5.RHQ_CD,'SHARC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                         ,'SELSC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                         ,'TYOSC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                         ,C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("      ) D1" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL D2" ).append("\n"); 
		query.append(" WHERE D2.INTG_CD_ID       = DECODE( P_KPITYPE, '1','CD01064', '2', 'CD00950', '3' ,'CD03163')" ).append("\n"); 
		query.append("   AND D2.INTG_CD_VAL_CTNT = D1.KPI_CD" ).append("\n"); 
		query.append(" GROUP BY P_REPORT" ).append("\n"); 
		query.append("         ,COST_YRMON" ).append("\n"); 
		query.append("         ,COST_RMON" ).append("\n"); 
		query.append("         ,COST_WK" ).append("\n"); 
		query.append("         ,RHQ_CD" ).append("\n"); 
		query.append("         ,CASE WHEN KPI_CD = 'RAIL' THEN DECODE(CTRL_OFC_CD, 'PHXSA', 'NYCRA', CTRL_OFC_CD)" ).append("\n"); 
		query.append("          ELSE CTRL_OFC_CD" ).append("\n"); 
		query.append("          END " ).append("\n"); 
		query.append("         ,COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("         ,MAS_GET_CD_NM_FNC('CD01065', DECODE(COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR')) " ).append("\n"); 
		query.append("         ,CASE WHEN P_KPITYPE = '3' THEN" ).append("\n"); 
		query.append("              D2.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("              MAS_GET_CD_NM_FNC(DECODE( P_KPITYPE, '1','CD01064', '2', 'CD00950'), KPI_CD)" ).append("\n"); 
		query.append("          END               " ).append("\n"); 
		query.append("         ,P_KPITYPE" ).append("\n"); 
		query.append("ORDER BY COST_YRMON" ).append("\n"); 
		query.append("        ,COST_RMON" ).append("\n"); 
		query.append("        ,COST_WK" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,CTRL_OFC_CD" ).append("\n"); 
		query.append("        ,KPI_ORDER" ).append("\n"); 
		query.append("        ,KPI_NM" ).append("\n"); 

	}
}