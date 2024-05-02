/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOFullStorageDailyCalcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.23
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.10.23 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOFullStorageDailyCalcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FullStorageDailyCalc
	  * </pre>
	  */
	public WeeklyCMDBDAOFullStorageDailyCalcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sto_fm_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sto_to_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sto_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sto_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cal_rslt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sto_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOFullStorageDailyCalcRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.STO_CALC_STS_FLG, 'Y', 'F', 'N', 'U', NULL, 'U') AS STO_CALC_STS" ).append("\n"); 
		query.append("      ,A.CNTR_NO" ).append("\n"); 
		query.append("      ,A.BKG_NO" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,B.OFC_CD" ).append("\n"); 
		query.append("      ,DECODE(A.BKG_BND_CD, 'O', 'O/B', 'I', 'I/B') AS BKG_BND" ).append("\n"); 
		query.append("      ,A.STO_FM_MVMT_CD STO_FM_MVMT" ).append("\n"); 
		query.append("      ,A.STO_TO_MVMT_CD STO_TO_MVMT" ).append("\n"); 
		query.append("      ,A.STO_FM_NOD_CD  STO_FM_NOD" ).append("\n"); 
		query.append("      ,A.STO_TO_NOD_CD  STO_TO_NOD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.STO_FM_DT,'YYYY-MM-DD') AS STO_FM_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.STO_TO_DT,'YYYY-MM-DD') AS STO_TO_DT" ).append("\n"); 
		query.append("      ,A.FREE_DYS" ).append("\n"); 
		query.append("      ,A.STAY_DYS" ).append("\n"); 
		query.append("      ,A.FREE_XCLD_DYS" ).append("\n"); 
		query.append("      ,A.OVR_DYS" ).append("\n"); 
		query.append("      ,CASE WHEN B.YD_FCTY_TP_MRN_TML_FLG = 'Y' THEN" ).append("\n"); 
		query.append("              'MAT'" ).append("\n"); 
		query.append("            WHEN B.YD_FCTY_TP_MRN_TML_FLG = 'N' AND B.YD_FCTY_TP_RAIL_RMP_FLG = 'Y' THEN" ).append("\n"); 
		query.append("              'RR'" ).append("\n"); 
		query.append("            WHEN B.YD_FCTY_TP_MRN_TML_FLG = 'N' AND B.YD_FCTY_TP_RAIL_RMP_FLG = 'N' AND B.YD_FCTY_TP_CFS_FLG = 'N' AND B.YD_FCTY_TP_CY_FLG = 'Y' THEN" ).append("\n"); 
		query.append("              'ODCY'" ).append("\n"); 
		query.append("       END NOD_TP" ).append("\n"); 
		query.append("      ,DECODE(B.YD_CHR_CD, 'N', 'ON DOCK', 'F', 'OFF DOCK') YD_CHR" ).append("\n"); 
		query.append("      ,'Local' LOCL_TS" ).append("\n"); 
		query.append("      ,(SELECT MAX(IMDG_CLSS_CD) FROM BKG_DG_CGO D" ).append("\n"); 
		query.append("          WHERE D.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("			AND CNTR_CGO_SEQ = '1') DG_CLSS" ).append("\n"); 
		query.append("      ,B.N6TH_VNDR_SEQ DFLT_VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.LGS_COST_CD COST_CD" ).append("\n"); 
		query.append("      ,A.CURR_CD CURR_CD" ).append("\n"); 
		query.append("      ,A.STO_TTL_AMT STO_TTL_AMT" ).append("\n"); 
		query.append("      ,DECODE(A.STO_FM_NOD_CD, (SELECT NOD_CD FROM MAS_STO_EXP_NOD E" ).append("\n"); 
		query.append("                                WHERE E.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                  AND E.MAS_UC_FLG = 'Y'" ).append("\n"); 
		query.append("								  AND E.NOD_CD = A.STO_FM_NOD_CD)      " ).append("\n"); 
		query.append("        , 'MAS U/C', 'TES AGMT') CAL_SRC" ).append("\n"); 
		query.append("      ,MAS_CONV_CURR_USD_FNC(A.CURR_CD, A.STO_TTL_AMT, TO_CHAR(A.STO_FM_DT,'YYYYMM')) USD_AMT" ).append("\n"); 
		query.append("      ,(SELECT MAX(COST_YRMON)" ).append("\n"); 
		query.append("          FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append("              ,MAS_RGST_BKG A2" ).append("\n"); 
		query.append("          WHERE A2.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("            AND A1.TRD_CD = A2.TRD_CD" ).append("\n"); 
		query.append("            AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("            AND A1.IOC_CD = A2.IOC_CD" ).append("\n"); 
		query.append("            AND A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("            AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND A1.DIR_CD = A2.DIR_CD" ).append("\n"); 
		query.append("       ) REV_MON" ).append("\n"); 
		query.append("      ,C.POR_CD" ).append("\n"); 
		query.append("      ,C.POL_CD" ).append("\n"); 
		query.append("      ,C.POD_CD" ).append("\n"); 
		query.append("      ,C.DEL_CD" ).append("\n"); 
		query.append("      ,C.RCV_TERM_CD  -- R" ).append("\n"); 
		query.append("      ,C.DE_TERM_CD   -- D" ).append("\n"); 
		query.append("      ,(SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') FROM BKG_CUSTOMER B" ).append("\n"); 
		query.append("        WHERE B.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("          AND B.BKG_CUST_TP_CD = 'S') SHPR_CD" ).append("\n"); 
		query.append("      ,(SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') FROM BKG_CUSTOMER B" ).append("\n"); 
		query.append("        WHERE B.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("          AND B.BKG_CUST_TP_CD = 'C') CNEE_CD" ).append("\n"); 
		query.append("      ,(SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') FROM BKG_CUSTOMER B" ).append("\n"); 
		query.append("        WHERE B.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("          AND B.BKG_CUST_TP_CD = 'N') NTFY_CD" ).append("\n"); 
		query.append("      ,C.SC_NO        -- S/C NO." ).append("\n"); 
		query.append("      ,DECODE(C.SC_NO, NULL, NULL, C.CTRT_CUST_CNT_CD||LPAD(C.CTRT_CUST_SEQ,6,'0')) SC_CUST_SEQ" ).append("\n"); 
		query.append("      ,C.RFA_NO       -- RFA NO." ).append("\n"); 
		query.append("      ,(SELECT CTRT_CUST_CNT_CD||LPAD(CTRT_CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("          FROM PRI_RP_HDR HDR" ).append("\n"); 
		query.append("              ,PRI_RP_MN MN" ).append("\n"); 
		query.append("          WHERE HDR.RFA_NO = C.RFA_NO" ).append("\n"); 
		query.append("              AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("              AND ROWNUM = 1) RFA_CUST_SEQ" ).append("\n"); 
		query.append("      ,'' AS F_STO_TYPE" ).append("\n"); 
		query.append("      ,'' AS F_STO_STS" ).append("\n"); 
		query.append("      ,'' AS COND_TYPE" ).append("\n"); 
		query.append("      ,DECODE(STO_COST_CALC_FLG,'E','Exception Node','','-','Y','Pass','N','Fail','C','No SC FT for RR','V','No Default S/P') TES_CALC" ).append("\n"); 
		query.append("	  ,FT_ADD_DYS" ).append("\n"); 
		query.append("	  ,FT_TTL_DYS" ).append("\n"); 
		query.append("	  ,TO_CHAR(A.UPD_DT,'YYYYMMDD') CAL_UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_DMDT_COST_DLY_RSLT A" ).append("\n"); 
		query.append("      ,MDM_YARD B" ).append("\n"); 
		query.append("      ,BKG_BOOKING C" ).append("\n"); 
		query.append("  WHERE A.ORG_YD_CD = B.YD_CD      " ).append("\n"); 
		query.append("    AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("    AND A.STO_FM_MVMT_CD IS NOT NULL" ).append("\n"); 
		query.append("	AND (B.YD_FCTY_TP_MRN_TML_FLG = 'Y' OR B.YD_FCTY_TP_MRN_TML_FLG = 'N' AND B.YD_FCTY_TP_RAIL_RMP_FLG = 'Y')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("    AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("    AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'date')" ).append("\n"); 
		query.append("  #if (${f_sto_sts} == 'Y')" ).append("\n"); 
		query.append("    AND (A.STO_CALC_STS_FLG = @[f_sto_sts]" ).append("\n"); 
		query.append("         AND (A.STO_TO_DT BETWEEN TO_DATE(REPLACE(@[sto_fm_dt] ,'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[sto_to_dt] ,'-',''), 'YYYYMMDD') + 0.99999 )) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #elseif (${f_sto_sts} == 'N')" ).append("\n"); 
		query.append("    AND (A.STO_CALC_STS_FLG = @[f_sto_sts]" ).append("\n"); 
		query.append("         AND ( A.STO_FM_DT BETWEEN TO_DATE(REPLACE(@[sto_fm_dt] ,'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[sto_to_dt] ,'-',''), 'YYYYMMDD') + 0.99999 )) " ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("          (A.STO_CALC_STS_FLG = 'Y'" ).append("\n"); 
		query.append("           AND ( A.STO_TO_DT BETWEEN TO_DATE(REPLACE(@[sto_fm_dt] ,'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[sto_to_dt] ,'-',''), 'YYYYMMDD') + 0.99999 )) " ).append("\n"); 
		query.append("          OR" ).append("\n"); 
		query.append("          (A.STO_CALC_STS_FLG = 'N'" ).append("\n"); 
		query.append("           AND ( A.STO_FM_DT BETWEEN TO_DATE(REPLACE(@[sto_fm_dt] ,'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[sto_to_dt] ,'-',''), 'YYYYMMDD') + 0.99999 )) " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#elseif (${f_sto_sts} != '')" ).append("\n"); 
		query.append("    AND A.STO_CALC_STS_FLG = @[f_sto_sts]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sto_fm_nod} != '') " ).append("\n"); 
		query.append("	AND A.STO_FM_NOD_CD LIKE @[sto_fm_nod]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sto_to_nod} != '') " ).append("\n"); 
		query.append("	AND A.STO_TO_NOD_CD LIKE @[sto_to_nod]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("    AND B.OFC_CD IN (${ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cal_rslt} != '')" ).append("\n"); 
		query.append("	AND A.STO_COST_CALC_FLG = @[f_cal_rslt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sto_type} == 'P') " ).append("\n"); 
		query.append("        -- Port Storage" ).append("\n"); 
		query.append("        AND (B.YD_FCTY_TP_MRN_TML_FLG = 'Y')            " ).append("\n"); 
		query.append("#elseif (${f_sto_type} == 'R')" ).append("\n"); 
		query.append("        -- Rail Ramp Storage" ).append("\n"); 
		query.append("        AND (B.YD_FCTY_TP_MRN_TML_FLG = 'N' AND B.YD_FCTY_TP_RAIL_RMP_FLG = 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}