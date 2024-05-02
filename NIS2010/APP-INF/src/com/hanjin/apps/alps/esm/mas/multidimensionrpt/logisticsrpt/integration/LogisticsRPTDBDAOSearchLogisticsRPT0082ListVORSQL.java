/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLogisticsRPT0082ListVORSQL.java
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

public class LogisticsRPTDBDAOSearchLogisticsRPT0082ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Logistics Exp.by Node&Link (ESM_MAS_0082) 조회
	  * ** Cost Group : TMNL 일 경우 **
	  * 
	  * 2011.06.21 이석준 [CHM-201111642-01] 
	  *                  MAS Logistics Exp. By Office화면에서 R.Month / S.Month 구분요청
	  * 2014.07.09 PEJ [CHM-201431087] [MAS] Multi-Dimension Report > Logistics PFMC > Expense 화면 조회로직 변경요청
	  *                    - Expense는  모든계정에 대해서 AMT가 0 이 아닌 것을 대상으로 함(-금액도 포함)
	  *                    -  Volume 은 AMT가 0 이 아닌 것을 대상으로 함
	  *                        New Volume은 T/S Volume이고 계정이 TS Stevedorage인 경우는 0인 금액도 포함
	  * 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
	  * 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchLogisticsRPT0082ListVORSQL(){
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
		params.put("f_istpsz_display",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_isnode_display",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_lgs_kpi_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_islane_display",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration").append("\n"); 
		query.append("FileName : LogisticsRPTDBDAOSearchLogisticsRPT0082ListVORSQL").append("\n"); 
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
		query.append("/*1.TMNL일때*/" ).append("\n"); 
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("      ,COST_RMON" ).append("\n"); 
		query.append("      ,COST_WK" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,CTRL_OFC_CD" ).append("\n"); 
		query.append("      ,MAS_GET_CD_NM_FNC('CD00950', KPI_CD) KPI_NM" ).append("\n"); 
		query.append("      ,CASE WHEN KPI_CD = 'RAIL' AND RHQ_CD IN ('SHARC','SELSC','TYOSC') THEN 'Truck'" ).append("\n"); 
		query.append("      ELSE (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03163' AND INTG_CD_VAL_CTNT = KPI_CD)" ).append("\n"); 
		query.append("      END TRSP_MODE" ).append("\n"); 
		query.append("      ,COST_IO_BND_CD INOUT" ).append("\n"); 
		query.append("      ,NOD_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,VOL" ).append("\n"); 
		query.append("      ,CASE WHEN KPI_CD = 'OPVO' AND STND_COST_NM = 'Basic Stevedorage' THEN VOL" ).append("\n"); 
		query.append("            WHEN KPI_CD = 'TSVO' AND STND_COST_NM = 'TS Stevedorage' THEN VOL" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS NEW_VOL" ).append("\n"); 
		query.append("      ,STND_COST_NM" ).append("\n"); 
		query.append("      ,AMT TOTAL_COST" ).append("\n"); 
		query.append("      ,AMT / DECODE(VOL, 0, 1, VOL) UNIT_COST" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT D2.COST_YRMON" ).append("\n"); 
		query.append("              ,D2.COST_RMON" ).append("\n"); 
		query.append("              ,D2.COST_WK" ).append("\n"); 
		query.append("              ,D2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,D2.NOD_CD" ).append("\n"); 
		query.append("              ,D2.TRD_CD" ).append("\n"); 
		query.append("              ,D2.RLANE_CD" ).append("\n"); 
		query.append("              ,D2.DIR_CD" ).append("\n"); 
		query.append("              ,D2.RHQ_CD" ).append("\n"); 
		query.append("              ,D2.CTRL_OFC_CD" ).append("\n"); 
		query.append("              ,D2.COST_IO_BND_CD   --,D2.P_KPITYPE" ).append("\n"); 
		query.append("              ,D1.STND_COST_CD" ).append("\n"); 
		query.append("              ,D1.STND_COST_NM" ).append("\n"); 
		query.append("              ,D2.VOL" ).append("\n"); 
		query.append("              ,D2.KPI_CD" ).append("\n"); 
		query.append("              ,DECODE(D1.STND_COST_CD" ).append("\n"); 
		query.append("                        ,'51101011', D2.BZC_STVG_AMT      -- Basic Stevedorage" ).append("\n"); 
		query.append("                        ,'51101071', D2.OTR_CY_HNDL_AMT   -- Other CY Expense" ).append("\n"); 
		query.append("                        ,'51101021', D2.TS_STVG_AMT       -- TS Stevedorage" ).append("\n"); 
		query.append("                        ,'51101031', D2.DCK_CY_HNDL_AMT   -- On Dock CY Expense" ).append("\n"); 
		query.append("                        ,'51101051', D2.CGO_HNDL_AMT      -- Cargo Handling Expense" ).append("\n"); 
		query.append("                        ,'51101041', D2.FCNTR_STO_AMT     -- Storage" ).append("\n"); 
		query.append("                        ,'51101061', D2.MISC_CGO_HNDL_AMT -- Misc Cargo Handling Expense" ).append("\n"); 
		query.append("                        ,'92301000', D2.TML_AMT           -- Exclusive Terminal Additional Cost" ).append("\n"); 
		query.append("                        ,0" ).append("\n"); 
		query.append("                     ) AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT ROWNUM RN" ).append("\n"); 
		query.append("                      ,STND_COST_CD" ).append("\n"); 
		query.append("                      ,STND_COST_NM" ).append("\n"); 
		query.append("                  FROM MAS_STND_ACCT" ).append("\n"); 
		query.append("                 WHERE SGRP_COST_CD IN('CVFS', 'CVIP')" ).append("\n"); 
		query.append("#if (${f_incld_tml} == '')" ).append("\n"); 
		query.append("                   AND STND_COST_CD <> '92301000' -- Exclusive Terminal Additional Cost" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )D1   /*FULL STEVEDORAGE, 자가터미널*/" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.SLS_YRMON, 'X') AS COST_YRMON" ).append("\n"); 
		query.append("              ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_YRMON, 'TM', C2.COST_YRMON, 'X') AS COST_RMON" ).append("\n"); 
		query.append("              ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_WK, 'X') AS COST_WK" ).append("\n"); 
		query.append("              ,DECODE(C1.P_ISTPSZDISPLAY, '1', C5.CNTR_TPSZ_CD, 'X') CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,DECODE(C1.P_ISNODEDISPLAY, '1', C5.N1ST_NOD_CD, 'X') NOD_CD" ).append("\n"); 
		query.append("              ,DECODE(C1.P_ISLANEDISPLAY, '1', C2.TRD_CD, 'X') TRD_CD" ).append("\n"); 
		query.append("              ,DECODE(C1.P_ISLANEDISPLAY, '1', C2.RLANE_CD, 'X') RLANE_CD" ).append("\n"); 
		query.append("              ,DECODE(C1.P_ISLANEDISPLAY, '1', C2.DIR_CD, 'X') DIR_CD" ).append("\n"); 
		query.append("              ,C6.OFC_N2ND_LVL_CD AS RHQ_CD" ).append("\n"); 
		query.append("              ,C6.OFC_N5TH_LVL_CD AS CTRL_OFC_CD" ).append("\n"); 
		query.append("              ,C5.COST_IO_BND_CD" ).append("\n"); 
		query.append("              ,DECODE(C5.STTL_FLG, 'Y', 'SHTL', C5.LGS_KPI_CD) KPI_CD" ).append("\n"); 
		query.append("              ,SUM(NVL(C5.CNTR_QTY, 0)) VOL" ).append("\n"); 
		query.append("              ,SUM(BZC_STVG_AMT)        BZC_STVG_AMT" ).append("\n"); 
		query.append("              ,SUM(OTR_CY_HNDL_AMT)     OTR_CY_HNDL_AMT" ).append("\n"); 
		query.append("              ,SUM(TS_STVG_AMT)         TS_STVG_AMT" ).append("\n"); 
		query.append("              ,SUM(DCK_CY_HNDL_AMT)     DCK_CY_HNDL_AMT" ).append("\n"); 
		query.append("              ,SUM(CGO_HNDL_AMT)        CGO_HNDL_AMT" ).append("\n"); 
		query.append("              ,SUM(FCNTR_STO_AMT)       FCNTR_STO_AMT" ).append("\n"); 
		query.append("              ,SUM(MISC_CGO_HNDL_AMT)   MISC_CGO_HNDL_AMT" ).append("\n"); 
		query.append("              ,SUM(TML_AMT)             TML_AMT" ).append("\n"); 
		query.append("        FROM (SELECT @[f_year] P_YEAR" ).append("\n"); 
		query.append("                    ,@[f_fm_mon] P_FM_MON" ).append("\n"); 
		query.append("                    ,@[f_to_mon] P_TO_MON" ).append("\n"); 
		query.append("                    ,@[f_sls_mon] P_SLS_MON" ).append("\n"); 
		query.append("                    ,@[f_fm_wk] P_FM_WK" ).append("\n"); 
		query.append("                    ,@[f_to_wk] P_TO_WK" ).append("\n"); 
		query.append("                    ,@[f_trd_cd] P_TRD_CD" ).append("\n"); 
		query.append("                    ,@[f_rlane_cd] P_RLANE_CD" ).append("\n"); 
		query.append("                    ,@[f_skd_dir_cd] P_SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,@[f_rhq_cd] P_RHQ_CD" ).append("\n"); 
		query.append("                    ,@[f_ctrl_ofc_cd] P_CTRL_OFC_CD" ).append("\n"); 
		query.append("                    ,@[f_in_out] P_INOUT" ).append("\n"); 
		query.append("                    ,DECODE(@[f_lgs_kpi_cost_grp_cd], 'TR', 'L', 'N') P_COST_ACT_GRP_TP_CD   /*P_LGS_KPI_COST_GRP_CD*/" ).append("\n"); 
		query.append("                    ,@[f_lgs_kpi_cd] P_LGS_KPI_CD" ).append("\n"); 
		query.append("                    ,DECODE(@[f_lgs_kpi_cd], 'SHTL', 'Y', 'N') P_SHTL   /*맨앞이 세팅할넘 P_LGS_KPI_CD*/" ).append("\n"); 
		query.append("                    ,@[f_nod_cd] P_NOD_CD" ).append("\n"); 
		query.append("                    ,@[f_islane_display] P_ISLANEDISPLAY" ).append("\n"); 
		query.append("                    ,@[f_istpsz_display] P_ISTPSZDISPLAY" ).append("\n"); 
		query.append("                    ,@[f_isnode_display] P_ISNODEDISPLAY" ).append("\n"); 
		query.append("                    ,@[f_split_mw] P_SPLIT_MW" ).append("\n"); 
		query.append("                    ,@[f_chkprd] P_CHKPRD" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("             ) C1" ).append("\n"); 
		query.append("             ,MAS_MON_VVD C2" ).append("\n"); 
		query.append("             ,MAS_RGST_BKG C3" ).append("\n"); 
		query.append("             ,MAS_BKG_LGS_SMRY C5" ).append("\n"); 
		query.append("             ,MAS_OFC_LVL C6" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("          AND SLS_YRMON             LIKE C1.P_YEAR ||C1.P_SLS_MON || '%'          /* YEAR*/" ).append("\n"); 
		query.append("          AND COST_WK               BETWEEN C1.P_FM_WK AND C1.P_TO_WK             /* WEEK*/" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("          AND C2.COST_YRMON         BETWEEN C1.P_YEAR || C1.P_FM_MON AND C1.P_YEAR || C1.P_TO_MON  /* YEAR, MONTH */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '')" ).append("\n"); 
		query.append("          AND C2.TRD_CD             = C1.P_TRD_CD    /*TRADE*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("          AND C2.RLANE_CD           = C1.P_RLANE_CD  /*LANE*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '')" ).append("\n"); 
		query.append("          AND C2.DIR_CD             = C1.P_SKD_DIR_CD  /*DIR*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND C5.COST_ACT_GRP_CD    NOT IN ('NIBC','NOBC')" ).append("\n"); 
		query.append("#if (${f_lgs_kpi_cd} != '')" ).append("\n"); 
		query.append("   #if (${f_lgs_kpi_cd} == 'SHTL')" ).append("\n"); 
		query.append("          AND C5.STTL_FLG           = 'Y'" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("          AND C5.LGS_KPI_CD         = C1.P_LGS_KPI_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '')" ).append("\n"); 
		query.append("          AND C6.OFC_N2ND_LVL_CD    = C1.P_RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("          AND C6.OFC_N5TH_LVL_CD    = C1.P_CTRL_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_lgs_kpi_cost_grp_cd} != '')" ).append("\n"); 
		query.append("          AND C5.COST_ACT_GRP_TP_CD = C1.P_COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_nod_cd} != '')" ).append("\n"); 
		query.append("          AND C5.N1ST_NOD_CD        LIKE P_NOD_CD || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_in_out} != '')" ).append("\n"); 
		query.append("          AND CASE C5.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                   WHEN 'PRWD' THEN 'O'" ).append("\n"); 
		query.append("                   WHEN 'POWD' THEN 'I'" ).append("\n"); 
		query.append("                   WHEN 'TRWD' THEN 'R'" ).append("\n"); 
		query.append("                   ELSE C5.COST_IO_BND_CD" ).append("\n"); 
		query.append("              END = @[f_in_out]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND C3.BKG_STS_CD         IN('F', 'S')" ).append("\n"); 
		query.append("          AND C3.BL_NO_TP           IN('M', '0')" ).append("\n"); 
		query.append("          AND C2.DELT_FLG           NOT IN('Y')" ).append("\n"); 
		query.append("          AND C3.BKG_CGO_TP_CD      NOT IN('P')" ).append("\n"); 
		query.append("          AND C2.VSL_CD             = C3.VSL_CD" ).append("\n"); 
		query.append("          AND C2.SKD_VOY_NO         = C3.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND C2.DIR_CD             = C3.DIR_CD" ).append("\n"); 
		query.append("          AND C2.TRD_CD             = C3.TRD_CD" ).append("\n"); 
		query.append("          AND C2.RLANE_CD           = C3.RLANE_CD" ).append("\n"); 
		query.append("          AND C2.IOC_CD             = C3.IOC_CD" ).append("\n"); 
		query.append("          AND C3.BKG_NO             = C5.BKG_NO" ).append("\n"); 
		query.append("      --  AND C3.BKG_NO_SPLIT       = C5.BKG_NO_SPLIT" ).append("\n"); 
		query.append("          AND C5.CTRL_OFC_CD        = C6.OFC_CD" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("          AND C2.SLS_YRMON          BETWEEN C6.OFC_APLY_FM_YRMON AND C6.OFC_APLY_TO_YRMON              /*월별관리*/" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("          AND C2.COST_YRMON        BETWEEN C6.OFC_APLY_FM_YRMON AND C6.OFC_APLY_TO_YRMON               /*월별관리*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   GROUP BY DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.SLS_YRMON, 'X')" ).append("\n"); 
		query.append("           ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_YRMON, 'TM', C2.COST_YRMON, 'X')" ).append("\n"); 
		query.append("           ,DECODE(C1.P_SPLIT_MW||P_CHKPRD, 'TW', C2.COST_WK, 'X')" ).append("\n"); 
		query.append("           ,DECODE(C1.P_ISTPSZDISPLAY, '1', C5.CNTR_TPSZ_CD, 'X')" ).append("\n"); 
		query.append("           ,DECODE(C1.P_ISNODEDISPLAY, '1', C5.N1ST_NOD_CD, 'X')" ).append("\n"); 
		query.append("           ,DECODE(C1.P_ISLANEDISPLAY, '1', C2.TRD_CD, 'X')" ).append("\n"); 
		query.append("           ,DECODE(C1.P_ISLANEDISPLAY, '1', C2.RLANE_CD, 'X')" ).append("\n"); 
		query.append("           ,DECODE(C1.P_ISLANEDISPLAY, '1', C2.DIR_CD, 'X')" ).append("\n"); 
		query.append("           ,C6.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("           ,C6.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("           ,C5.COST_IO_BND_CD" ).append("\n"); 
		query.append("           ,DECODE(C5.STTL_FLG, 'Y', 'SHTL', C5.LGS_KPI_CD)" ).append("\n"); 
		query.append("           ) D2" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("WHERE (" ).append("\n"); 
		query.append("       ( AMT <> 0 ) -- 모든 Cost 에 대해서 0 이 아닌 것" ).append("\n"); 
		query.append("   --KPI_CD='T/S Volume' AND STND_COST_NM ='TS Stevedorage' AND AMT =0 )" ).append("\n"); 
		query.append("    OR (KPI_CD = 'TSVO' AND STND_COST_CD = '51101021' AND AMT = 0) /* KPI Activity Group TSVO(TS Volume) 이고 계정이 TS Stevedorage(51101021) 이면 금액이 0이여도 물량으로 집계 */" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("ORDER BY COST_YRMON" ).append("\n"); 
		query.append("        ,COST_RMON" ).append("\n"); 
		query.append("        ,COST_WK" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,CTRL_OFC_CD" ).append("\n"); 
		query.append("        ,KPI_CD" ).append("\n"); 
		query.append("        ,COST_IO_BND_CD" ).append("\n"); 
		query.append("        ,NOD_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,CNTR_TPSZ_CD" ).append("\n"); 

	}
}