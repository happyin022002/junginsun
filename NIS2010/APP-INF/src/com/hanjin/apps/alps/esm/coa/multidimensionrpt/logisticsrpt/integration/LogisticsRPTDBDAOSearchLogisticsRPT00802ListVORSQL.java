/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLogisticsRPT00802ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.03
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.08.03 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LogisticsRPTDBDAOSearchLogisticsRPT00802ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_COA_0080화면에서  DETAIL에 대한 쿼리입니다. - 품질향상
	  * 
	  * 
	  * 2014.07.10 PEJ [CHM-201431087] [COA] Multi-Dimension Report > Logistics PFMC > Expense 화면 조회로직 변경요청
	  *                       TMNL/TRANS Volume Incentive 제외
	  *                       Detail의 물량정보를 BKG_QTY -> CNTR_QTY로 변경
	  * 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
	  * 2014.09.15 박은주 [CHM-201431910]  Logistics Exp by Lane 화면에 Trade Direction 칼럼추가 요청
	  * 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchLogisticsRPT00802ListVORSQL(){
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
		query.append("FileName : LogisticsRPTDBDAOSearchLogisticsRPT00802ListVORSQL").append("\n"); 
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
		query.append("--Logistics Exp. By Lane - Sheet2" ).append("\n"); 
		query.append("SELECT D1.P_REPORT" ).append("\n"); 
		query.append("      ,D1.TRD_CD" ).append("\n"); 
		query.append("      ,D1.RLANE_CD" ).append("\n"); 
		query.append("      ,D1.DIR_CD" ).append("\n"); 
		query.append("      ,D3.HUL_BND_CD" ).append("\n"); 
		query.append("      ,D3.LOAD P_LOAD  " ).append("\n"); 
		query.append("      ,D1.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("      ,COA_GET_CD_NM_FNC('CD01065', DECODE(D1.COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR')) LGS_KPI_COST_GRP_NM" ).append("\n"); 
		query.append("      ,D1.COST_IO_BND_CD AS IN_OUT" ).append("\n"); 
		query.append("      ,D1.P_KPITYPE" ).append("\n"); 
		query.append("      ,CASE WHEN D1.P_KPITYPE = '3' THEN" ).append("\n"); 
		query.append("           D2.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("           COA_GET_CD_NM_FNC(DECODE( D1.P_KPITYPE, '1','CD01064', '2', 'CD00950'), D1.KPI_CD)" ).append("\n"); 
		query.append("       END KPI_NM" ).append("\n"); 
		query.append("      ,SUM(D1.VOL) VOL" ).append("\n"); 
		query.append("      ,SUM(D1.TM_AMT+D1.TR_AMT) TOTAL_COST" ).append("\n"); 
		query.append("      ,SUM(D1.TM_AMT+D1.TR_AMT)/DECODE(SUM(D1.VOL), 0 , 1, SUM(D1.VOL)) UNIT_COST" ).append("\n"); 
		query.append("  FROM (SELECT C3.BKG_NO" ).append("\n"); 
		query.append("              ,C5.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,C1.P_REPORT" ).append("\n"); 
		query.append("              ,C2.TRD_CD" ).append("\n"); 
		query.append("              ,DECODE(C1.P_REPORT, '1', 'X', C2.RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("              ,DECODE(C1.P_REPORT, '1', 'X', C2.DIR_CD) DIR_CD" ).append("\n"); 
		query.append("              ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("              ,CASE C5.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                    WHEN 'PRWD' THEN 'O'" ).append("\n"); 
		query.append("                    WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("                    WHEN 'TRWD' THEN 'R'" ).append("\n"); 
		query.append("               ELSE C5.COST_IO_BND_CD" ).append("\n"); 
		query.append("               END AS COST_IO_BND_CD" ).append("\n"); 
		query.append("              ,C1.P_KPITYPE" ).append("\n"); 
		query.append("              ,DECODE(C1.P_KPITYPE,'1',DECODE(C5.STTL_FLG, 'Y',   'ST', C5.LGS_KPI_MN_CD)" ).append("\n"); 
		query.append("                                  ,'2',DECODE(C5.STTL_FLG, 'Y', 'SHTL', C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                  ,'3',DECODE(C5.RHQ_CD,'SELSC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                       ,'TYOSC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                       ,C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                      ) KPI_CD   /*Shuttle의 경우*/" ).append("\n"); 
		query.append("              ,SUM(NVL(C5.CNTR_QTY, 0)) AS VOL" ).append("\n"); 
		query.append("              ,SUM(NVL(C5.VOID_20FT_QTY, 0) + NVL(C5.VOID_40FT_QTY, 0) * 2) AS VOID_VOL" ).append("\n"); 
		query.append("              ,AVG(DECODE(SUBSTR(C5.CNTR_TPSZ_CD, -1, 1), '2', NVL(C5.BKG_QTY, 0), '3', NVL(C5.BKG_QTY, 0), NVL(C5.BKG_QTY, 0) * 2)) AS LOAD" ).append("\n"); 
		query.append("              ,CASE C1.P_INCLD_TML" ).append("\n"); 
		query.append("                   WHEN 'T' THEN SUM(C5.FCNTR_STVG_TTL_AMT - NVL(C5.TML_VOL_INCNT_AMT,0))" ).append("\n"); 
		query.append("                   ELSE SUM(C5.FCNTR_STVG_TTL_AMT - NVL(C5.TML_VOL_INCNT_AMT,0) - C5.TML_AMT)" ).append("\n"); 
		query.append("               END AS TM_AMT" ).append("\n"); 
		query.append("              ,DECODE(@[f_excld_crr_hlg], 'T', SUM(C5.FCNTR_TRSP_TTL_AMT - NVL(C5.TRNS_VOL_INCNT_AMT,0))" ).append("\n"); 
		query.append("                                             , SUM(C5.FCNTR_TRSP_TTL_AMT - NVL(C5.TRNS_VOL_INCNT_AMT,0) - NVL(C5.CRR_HLG_SVC_CHG_AMT,0))" ).append("\n"); 
		query.append("                     ) TR_AMT" ).append("\n"); 
		query.append("          FROM (SELECT       @[f_year]          P_YEAR" ).append("\n"); 
		query.append("                            ,@[f_fm_mon]        P_SCOST_YRMON" ).append("\n"); 
		query.append("                            ,@[f_to_mon]        P_ECOST_YRMON" ).append("\n"); 
		query.append("                            ,@[f_sls_mon]       P_SLS_MON" ).append("\n"); 
		query.append("                            ,@[f_fm_wk]         P_SCOST_WEEK" ).append("\n"); 
		query.append("                            ,@[f_to_wk]         P_ECOST_WEEK" ).append("\n"); 
		query.append("                            ,@[f_split_mw]      P_SPLIT_MW" ).append("\n"); 
		query.append("                            ,@[f_report]        P_REPORT" ).append("\n"); 
		query.append("                            ,@[f_trd_cd]        P_TRD_CD" ).append("\n"); 
		query.append("                            ,@[f_rlane_cd]      P_RLANE_CD" ).append("\n"); 
		query.append("                            ,@[f_skd_dir_cd]    P_SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,@[f_kpi_type]      P_KPITYPE" ).append("\n"); 
		query.append("                            ,@[f_lgs_mn_kpi_cd] P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("                            ,@[f_lgs_kpi_cd]    P_LGS_KPI_CD" ).append("\n"); 
		query.append("                            ,@[f_lgs_kpi3_cd]   P_LGS_KPI3_CD" ).append("\n"); 
		query.append("                            ,@[f_incld_tml]     P_INCLD_TML" ).append("\n"); 
		query.append("                            ,DECODE(@[f_lgs_mn_kpi_cd], 'ST', 'Y', 'N') P_MN_SHTL    /*맨앞이 세팅할넘 P_LGS_KPI_MN_CD*/" ).append("\n"); 
		query.append("                            ,DECODE(@[f_lgs_kpi_cd], 'SHTL', 'Y', 'N')  P_SHTL       /*맨앞이 세팅할넘 P_LGS_KPI_CD*/" ).append("\n"); 
		query.append("                  FROM DUAL) C1" ).append("\n"); 
		query.append("                ,COA_MON_VVD C2" ).append("\n"); 
		query.append("                ,COA_RGST_BKG C3" ).append("\n"); 
		query.append("                ,COA_BKG_LGS_SMRY C5" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("    #if (${f_sls_mon} != '')" ).append("\n"); 
		query.append("           AND SLS_YRMON           = C1.P_YEAR||C1.P_SLS_MON" ).append("\n"); 
		query.append("           AND COST_WK             BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("           AND SLS_YRMON           LIKE C1.P_YEAR||'%'" ).append("\n"); 
		query.append("           AND COST_WK             BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("           AND COST_YRMON          BETWEEN C1.P_YEAR||P_SCOST_YRMON AND C1.P_YEAR||C1.P_ECOST_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '')" ).append("\n"); 
		query.append("           AND C2.TRD_CD           = C1.P_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("           AND C2.RLANE_CD         = C1.P_RLANE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '')" ).append("\n"); 
		query.append("           AND C2.DIR_CD           = C1.P_SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_kpi_type} == '2' && ${f_lgs_kpi_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_lgs_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("           AND C5.STTL_FLG         = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("           AND C5.STTL_FLG         <> 'Y'" ).append("\n"); 
		query.append("           AND C5.LGS_KPI_CD       = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_kpi_type} == '1' && ${f_lgs_mn_kpi_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_lgs_mn_kpi_cd} == 'ST')" ).append("\n"); 
		query.append("           AND C5.STTL_FLG         = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("           AND C5.STTL_FLG         <> 'Y'" ).append("\n"); 
		query.append("           AND C5.LGS_KPI_MN_CD    = C1.P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${f_kpi_type} == '3') && ${f_lgs_kpi3_cd} != '')" ).append("\n"); 
		query.append("           --KIP3는 코드를 들고 있는것이 아니라 DESC를 들고 있어서 아래와 같이 걸어 줘야 함" ).append("\n"); 
		query.append("           AND C5.LGS_KPI_CD       IN (" ).append("\n"); 
		query.append("                                        SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                         WHERE INTG_CD_ID       = 'CD03163'" ).append("\n"); 
		query.append("                                           AND INTG_CD_VAL_DESC = C1.P_LGS_KPI3_CD" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND C5.COST_ACT_GRP_CD  NOT IN ('NIBC','NOBC')" ).append("\n"); 
		query.append("           AND C3.BKG_STS_CD       IN('F', 'S')" ).append("\n"); 
		query.append("           AND C3.BL_NO_TP         IN('M', '0')" ).append("\n"); 
		query.append("           AND C2.DELT_FLG         NOT IN('Y')" ).append("\n"); 
		query.append("           AND C3.BKG_CGO_TP_CD    NOT IN('P')" ).append("\n"); 
		query.append("           AND C2.VSL_CD           = C3.VSL_CD" ).append("\n"); 
		query.append("           AND C2.SKD_VOY_NO       = C3.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND C2.DIR_CD           = C3.DIR_CD" ).append("\n"); 
		query.append("           AND C2.TRD_CD           = C3.TRD_CD" ).append("\n"); 
		query.append("           AND C2.RLANE_CD         = C3.RLANE_CD" ).append("\n"); 
		query.append("           AND C2.IOC_CD           = C3.IOC_CD" ).append("\n"); 
		query.append("           AND C3.BKG_NO           = C5.BKG_NO" ).append("\n"); 
		query.append("         GROUP BY C3.BKG_NO" ).append("\n"); 
		query.append("                 ,C5.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 ,C1.P_REPORT" ).append("\n"); 
		query.append("                 ,C2.TRD_CD" ).append("\n"); 
		query.append("                 ,DECODE(C1.P_REPORT, '1', 'X', C2.RLANE_CD)" ).append("\n"); 
		query.append("                 ,DECODE(C1.P_REPORT, '1', 'X', C2.DIR_CD)" ).append("\n"); 
		query.append("                 ,C5.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("                 ,CASE C5.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                         WHEN 'PRWD' THEN 'O'" ).append("\n"); 
		query.append("                         WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("                         WHEN 'TRWD' THEN 'R'" ).append("\n"); 
		query.append("                         ELSE C5.COST_IO_BND_CD" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("                 ,C1.P_KPITYPE" ).append("\n"); 
		query.append("                 ,DECODE(C1.P_KPITYPE,'1',DECODE(C5.STTL_FLG, 'Y',   'ST', C5.LGS_KPI_MN_CD)" ).append("\n"); 
		query.append("                                  ,'2',DECODE(C5.STTL_FLG, 'Y', 'SHTL', C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                  ,'3',DECODE(C5.RHQ_CD,'SELSC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                       ,'TYOSC',DECODE(C5.LGS_KPI_CD, 'RAIL','TRCK',C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                                                       ,C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("      ) D1" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL D2" ).append("\n"); 
		query.append("      ,(-- LOAD를 구하기 위해서 추가" ).append("\n"); 
		query.append("        SELECT TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,SUBSTR(HUL_BND_CD,1,1)||'/'||SUBSTR(HUL_BND_CD,-1) HUL_BND_CD" ).append("\n"); 
		query.append("              ,SUM(LOAD) LOAD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A2.BKG_NO" ).append("\n"); 
		query.append("                      ,A3.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      ,A2.TRD_CD" ).append("\n"); 
		query.append("                      ,DECODE(C1.P_REPORT,'1','X', A2.RLANE_CD)  RLANE_CD" ).append("\n"); 
		query.append("                      ,DECODE(C1.P_REPORT,'1','X', A2.DIR_CD)    DIR_CD" ).append("\n"); 
		query.append("                      ,DECODE(C1.P_REPORT,'1','X', A4.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append("                      ,AVG(DECODE(SUBSTR(A3.CNTR_TPSZ_CD, -1, 1), '2', NVL(A3.BKG_QTY, 0), '3', NVL(A3.BKG_QTY, 0), NVL(A3.BKG_QTY, 0) * 2)) AS LOAD" ).append("\n"); 
		query.append("                  FROM (SELECT @[f_year]          P_YEAR" ).append("\n"); 
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
		query.append("                              ,DECODE(@[f_lgs_mn_kpi_cd], 'ST', 'Y', 'N') P_MN_SHTL    /*맨앞이 세팅할넘 P_LGS_KPI_MN_CD*/" ).append("\n"); 
		query.append("                              ,DECODE(@[f_lgs_kpi_cd], 'SHTL', 'Y', 'N')  P_SHTL       /*맨앞이 세팅할넘 P_LGS_KPI_CD*/" ).append("\n"); 
		query.append("                          FROM DUAL) C1" ).append("\n"); 
		query.append("                      ,COA_MON_VVD A1" ).append("\n"); 
		query.append("                      ,COA_RGST_BKG A2" ).append("\n"); 
		query.append("                      ,COA_BKG_LGS_SMRY A3" ).append("\n"); 
		query.append("                      ,COA_LANE_RGST A4" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                      AND A1.TRD_CD        = A2.TRD_CD" ).append("\n"); 
		query.append("                      AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("                      AND A1.IOC_CD        = A2.IOC_CD" ).append("\n"); 
		query.append("                      AND A1.VSL_CD        = A2.VSL_CD" ).append("\n"); 
		query.append("                      AND A1.SKD_VOY_NO    = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND A1.DIR_CD        = A2.DIR_CD" ).append("\n"); 
		query.append("                      AND A1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                      AND A2.BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("                      AND A2.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                      AND A2.BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("                      AND A2.BKG_NO        = A3.BKG_NO" ).append("\n"); 
		query.append("                      AND A1.TRD_CD        = A4.TRD_CD" ).append("\n"); 
		query.append("                      AND A1.RLANE_CD      = A4.RLANE_CD" ).append("\n"); 
		query.append("                      AND A1.DIR_CD        = A4.DIR_CD" ).append("\n"); 
		query.append("                      AND A1.IOC_CD        = A4.IOC_CD" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("    #if (${f_sls_mon} != '')" ).append("\n"); 
		query.append("                      AND A1.SLS_YRMON     = C1.P_YEAR||C1.P_SLS_MON" ).append("\n"); 
		query.append("                      AND A1.COST_WK       BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                      AND A1.SLS_YRMON     LIKE C1.P_YEAR||'%'" ).append("\n"); 
		query.append("                      AND A1.COST_WK       BETWEEN C1.P_SCOST_WEEK AND C1.P_ECOST_WEEK" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("                      AND A1.COST_YRMON    BETWEEN C1.P_YEAR||P_SCOST_YRMON AND C1.P_YEAR||C1.P_ECOST_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '')" ).append("\n"); 
		query.append("                      AND A1.TRD_CD           = C1.P_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("                      AND A1.RLANE_CD         = C1.P_RLANE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '')" ).append("\n"); 
		query.append("                      AND A1.DIR_CD           = C1.P_SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_kpi_type} == '2' && ${f_lgs_kpi_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_lgs_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("                     AND A3.STTL_FLG         = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                     AND A3.LGS_KPI_CD       = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_kpi_type} == '1' && ${f_lgs_mn_kpi_cd} != '')" ).append("\n"); 
		query.append("    #if (${f_lgs_mn_kpi_cd} == 'ST')" ).append("\n"); 
		query.append("                     AND A3.STTL_FLG         = 'Y'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                     AND A3.LGS_KPI_MN_CD    = C1.P_LGS_KPI_MN_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${f_kpi_type} == '3') && ${f_lgs_kpi3_cd} != '')" ).append("\n"); 
		query.append("           --KIP3는 코드를 들고 있는것이 아니라 DESC를 들고 있어서 아래와 같이 걸어 줘야 함" ).append("\n"); 
		query.append("                    AND A3.LGS_KPI_CD       IN (" ).append("\n"); 
		query.append("                                                 SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                                   FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                  WHERE INTG_CD_ID       = 'CD03163'" ).append("\n"); 
		query.append("                                                    AND INTG_CD_VAL_DESC = C1.P_LGS_KPI3_CD" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY A2.BKG_NO" ).append("\n"); 
		query.append("                         ,A3.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                         ,A2.TRD_CD" ).append("\n"); 
		query.append("                         ,DECODE(C1.P_REPORT,'1','X', A2.RLANE_CD)" ).append("\n"); 
		query.append("                         ,DECODE(C1.P_REPORT,'1','X', A2.DIR_CD)" ).append("\n"); 
		query.append("                         ,DECODE(C1.P_REPORT,'1','X', A4.HUL_BND_CD)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        GROUP BY TRD_CD" ).append("\n"); 
		query.append("                ,RLANE_CD" ).append("\n"); 
		query.append("                ,DIR_CD" ).append("\n"); 
		query.append("                ,HUL_BND_CD" ).append("\n"); 
		query.append("        ) D3" ).append("\n"); 
		query.append(" WHERE D2.INTG_CD_ID       = DECODE( P_KPITYPE, '1','CD01064', '2', 'CD00950', '3' ,'CD03163') " ).append("\n"); 
		query.append("   AND D2.INTG_CD_VAL_CTNT = D1.KPI_CD  " ).append("\n"); 
		query.append("   AND D1.TRD_CD           = D3.TRD_CD" ).append("\n"); 
		query.append("   AND D1.RLANE_CD         = D3.RLANE_CD" ).append("\n"); 
		query.append("   AND D1.DIR_CD           = D3.DIR_CD              " ).append("\n"); 
		query.append(" GROUP BY D1.P_REPORT" ).append("\n"); 
		query.append("         ,D1.TRD_CD" ).append("\n"); 
		query.append("         ,D1.RLANE_CD" ).append("\n"); 
		query.append("         ,D1.DIR_CD" ).append("\n"); 
		query.append("         ,D3.HUL_BND_CD" ).append("\n"); 
		query.append("         ,D3.LOAD" ).append("\n"); 
		query.append("         ,D1.COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("         ,COA_GET_CD_NM_FNC('CD01065', DECODE(D1.COST_ACT_GRP_TP_CD, 'N', 'TM', 'TR')) " ).append("\n"); 
		query.append("         ,D1.COST_IO_BND_CD" ).append("\n"); 
		query.append("         ,D1.P_KPITYPE" ).append("\n"); 
		query.append("         ,CASE WHEN P_KPITYPE = '3' THEN" ).append("\n"); 
		query.append("              D2.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("              COA_GET_CD_NM_FNC(DECODE( D1.P_KPITYPE, '1','CD01064', '2', 'CD00950'), D1.KPI_CD)" ).append("\n"); 
		query.append("          END " ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,LGS_KPI_COST_GRP_NM" ).append("\n"); 
		query.append("        ,IN_OUT" ).append("\n"); 
		query.append("        ,KPI_NM" ).append("\n"); 

	}
}