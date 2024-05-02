/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyTargetVVDDBDAOSearchMonthlyTargetVVDOrg0040Tab01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyTargetVVDDBDAOSearchMonthlyTargetVVDOrg0040Tab01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public MonthlyTargetVVDDBDAOSearchMonthlyTargetVVDOrg0040Tab01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration").append("\n"); 
		query.append("FileName : MonthlyTargetVVDDBDAOSearchMonthlyTargetVVDOrg0040Tab01RSQL").append("\n"); 
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
		query.append("WITH GRP_MAX AS (" ).append("\n"); 
		query.append("    SELECT  TRD_CD,RLANE_CD,DIR_CD," ).append("\n"); 
		query.append("            MAX(SPRT_GRP_CD) MAX_GRP_CD," ).append("\n"); 
		query.append("            SUBSTR(MAX(SPRT_GRP_CD),0,1) MAX_SPRT_GRP_CD," ).append("\n"); 
		query.append("            SUBSTR(MAX(SPRT_GRP_CD),2,2) MAX_BSA_GRP_CD            " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           TRD_CD, RLANE_CD, DIR_CD, " ).append("\n"); 
		query.append("           'A'||(V.BSA_GRP_CD)  SPRT_GRP_CD" ).append("\n"); 
		query.append("    FROM SAQ_MON_TGT_BSA_GRP V" ).append("\n"); 
		query.append("    WHERE V.BSE_YR = @[year] " ).append("\n"); 
		query.append("#if (${trade} != '')     " ).append("\n"); 
		query.append("      AND V.TRD_CD = @[trade]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')       " ).append("\n"); 
		query.append("	  AND V.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end	  " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           TRD_CD, RLANE_CD, DIR_CD, " ).append("\n"); 
		query.append("           (SPRT_GRP_CD||BSA_GRP_CD) SPRT_GRP_CD" ).append("\n"); 
		query.append("    FROM   SAQ_MON_TGT_VVD M" ).append("\n"); 
		query.append("    WHERE  M.BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    M.BSE_QTR_CD = @[quarter]" ).append("\n"); 
		query.append("#if (${trade} != '')     " ).append("\n"); 
		query.append("    AND M.TRD_CD = @[trade]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')     " ).append("\n"); 
		query.append("    AND M.DIR_CD = @[bound] " ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("    )  A" ).append("\n"); 
		query.append("--    WHERE 1=1" ).append("\n"); 
		query.append("--        AND rlane_cd IN ( 'AUPAE', 'CMXAE' , 'IMUAE')" ).append("\n"); 
		query.append("    GROUP BY   --FLAG, " ).append("\n"); 
		query.append("               TRD_CD, RLANE_CD, DIR_CD" ).append("\n"); 
		query.append(")       " ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("GRP_CAPA AS (" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("            TRD_CD,RLANE_CD,DIR_CD," ).append("\n"); 
		query.append("            NVL(MAX(T_SPRT_GRP_CD) , MAX(G_SPRT_GRP_CD) ) SPRT_GRP_CD," ).append("\n"); 
		query.append("            NVL(MAX(T_BSA_GRP_CD) , MAX(G_BSA_GRP_CD) )  BSA_GRP_CD,            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            MAX(MAX(MAX_SPRT_GRP_CD)) OVER(PARTITION BY  TRD_CD, RLANE_CD,  DIR_CD) MAX_SPRT_GRP_CD," ).append("\n"); 
		query.append("            FNL_BSA_CAPA" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT 'BSA_GROUP' FLAG," ).append("\n"); 
		query.append("           TRD_CD, RLANE_CD, DIR_CD, " ).append("\n"); 
		query.append("           'A'  G_SPRT_GRP_CD," ).append("\n"); 
		query.append("           (V.BSA_GRP_CD) G_BSA_GRP_CD," ).append("\n"); 
		query.append("           NULL  T_SPRT_GRP_CD," ).append("\n"); 
		query.append("           NULL  T_BSA_GRP_CD," ).append("\n"); 
		query.append("           'A'||(V.BSA_GRP_CD)  MAX_SPRT_GRP_CD," ).append("\n"); 
		query.append("           FNL_BSA_CAPA" ).append("\n"); 
		query.append("    FROM SAQ_MON_TGT_BSA_GRP V" ).append("\n"); 
		query.append("    WHERE V.BSE_YR = @[year] " ).append("\n"); 
		query.append("#if (${trade} != '')     " ).append("\n"); 
		query.append("      AND V.TRD_CD = @[trade]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')       " ).append("\n"); 
		query.append("	  AND V.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end	  " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'TGT_VVD' FLAG," ).append("\n"); 
		query.append("           TRD_CD, RLANE_CD, DIR_CD, " ).append("\n"); 
		query.append("           NULL G_SPRT_GRP_CD," ).append("\n"); 
		query.append("           NULL G_BSA_GRP_CD," ).append("\n"); 
		query.append("           (SPRT_GRP_CD) T_SPRT_GRP_CD," ).append("\n"); 
		query.append("           (BSA_GRP_CD)  T_BSA_GRP_CD, " ).append("\n"); 
		query.append("           (SPRT_GRP_CD||BSA_GRP_CD) MAX_SPRT_GRP_CD," ).append("\n"); 
		query.append("           FNL_BSA_CAPA" ).append("\n"); 
		query.append("    FROM   SAQ_MON_TGT_VVD M" ).append("\n"); 
		query.append("    WHERE  M.BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    M.BSE_QTR_CD = @[quarter]" ).append("\n"); 
		query.append("#if (${trade} != '')      " ).append("\n"); 
		query.append("    AND M.TRD_CD = @[trade] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')      " ).append("\n"); 
		query.append("    AND M.DIR_CD = @[bound] " ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("    )  A" ).append("\n"); 
		query.append("--    WHERE 1=1" ).append("\n"); 
		query.append("--        AND rlane_cd IN ( 'AUPAE', 'CMXAE' )" ).append("\n"); 
		query.append("    GROUP BY   --FLAG, " ).append("\n"); 
		query.append("               TRD_CD, RLANE_CD, DIR_CD, FNL_BSA_CAPA " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("COA_MON_VVD_V AS ( " ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("        V.TRD_CD, V.RLANE_CD,  " ).append("\n"); 
		query.append("        V.VSL_CD, V.SKD_VOY_NO, V.DIR_CD , " ).append("\n"); 
		query.append("        V.SLS_YRMON, " ).append("\n"); 
		query.append("        V.COST_WK , " ).append("\n"); 
		query.append("        V.SUB_TRD_CD, V.IOC_CD, V.VVD_SEQ, " ).append("\n"); 
		query.append("        V.LST_LODG_PORT_ETD_DT, " ).append("\n"); 
		query.append("        V.LST_LODG_PORT_CD " ).append("\n"); 
		query.append("    FROM COA_MON_VVD V " ).append("\n"); 
		query.append("    WHERE   V.SLS_YRMON BETWEEN @[year]||@[month] AND @[year]||@[month2] " ).append("\n"); 
		query.append("#if (${trade} != '') " ).append("\n"); 
		query.append("      AND V.TRD_CD = @[trade] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '') " ).append("\n"); 
		query.append("	  AND V.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("        AND V.SUB_TRD_CD <> 'IP'    " ).append("\n"); 
		query.append("        AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N') " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------SELECT START --------------------------------------------" ).append("\n"); 
		query.append("SELECT A.TRD_CD,A.RLANE_CD, A.DIR_CD," ).append("\n"); 
		query.append("       A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD," ).append("\n"); 
		query.append("       --A.SPRT_GRP_CD," ).append("\n"); 
		query.append("       -- 2010.05.03 대표 Group 관련 CSR " ).append("\n"); 
		query.append("       SUBSTR( SPRT_GRP.SPRT_GRP_CD, A.RANK_1,  1 )  SPRT_GRP_CD ," ).append("\n"); 
		query.append("       --NVL(A.BSA_GRP_CD , '01' ) BSA_GRP_CD," ).append("\n"); 
		query.append("       '01' BSA_GRP_CD," ).append("\n"); 
		query.append("        SUBSTR( SPRT_GRP.SPRT_GRP_CD," ).append("\n"); 
		query.append("            (MAX( A.RANK_1 )  OVER(PARTITION BY A.TRD_CD, A.RLANE_CD, A.DIR_CD) )" ).append("\n"); 
		query.append("         ,  1 )||'01'   GRP_MAX," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   A.BSE_MON,A.BSE_WK," ).append("\n"); 
		query.append("       A.SUB_TRD_CD, A.IOC_CD, A.VVD_SEQ," ).append("\n"); 
		query.append("       A.FNL_BSA_CAPA," ).append("\n"); 
		query.append("       TO_CHAR(A.FNL_BSA_CAPA,'FM099999999990') AS STR_FNL_BSA_CAPA," ).append("\n"); 
		query.append("       A.UPD_RMK," ).append("\n"); 
		query.append("       A.ETD_DT," ).append("\n"); 
		query.append("       A.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        V.TRD_CD, V.RLANE_CD, V.DIR_CD, " ).append("\n"); 
		query.append("        V.VSL_CD, V.SKD_VOY_NO, V.DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("		-- 2010.05.03 대표 Group 관련 CSR " ).append("\n"); 
		query.append("		GC.SPRT_GRP_CD," ).append("\n"); 
		query.append("		GC.BSA_GRP_CD," ).append("\n"); 
		query.append("		GM.MAX_GRP_CD GRP_MAX," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        DENSE_RANK() OVER(PARTITION BY V.TRD_CD, V.RLANE_CD, V.DIR_CD --, M.FNL_BSA_CAPA " ).append("\n"); 
		query.append("                            ORDER BY   V.TRD_CD, V.RLANE_CD, V.DIR_CD, ROUND(NVL(M.FNL_CO_BSA_CAPA, 0))" ).append("\n"); 
		query.append("                         )  RANK_1,      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        --TO_NUMBER (GM.MAX_BSA_GRP_CD )  MAX_NUM," ).append("\n"); 
		query.append("		--INSTR( 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', GM.MAX_SPRT_GRP_CD)  MAX_NUM," ).append("\n"); 
		query.append("        --NVL(GC.GRP_CD, '01') BSA_GRP_CD, " ).append("\n"); 
		query.append("        --NVL(TO_CHAR(GM.GRP_CD, 'FM00'), '00') GRP_MAX," ).append("\n"); 
		query.append("        SUBSTR(V.SLS_YRMON, 5) BSE_MON," ).append("\n"); 
		query.append("        V.COST_WK BSE_WK," ).append("\n"); 
		query.append("        V.SUB_TRD_CD, V.IOC_CD, V.VVD_SEQ," ).append("\n"); 
		query.append("        ROUND(NVL(M.FNL_CO_BSA_CAPA, 0)) FNL_BSA_CAPA," ).append("\n"); 
		query.append("        '' UPD_RMK," ).append("\n"); 
		query.append("        TO_CHAR(V.LST_LODG_PORT_ETD_DT, 'YYYY/MM/DD HH24:MI:SS') ETD_DT," ).append("\n"); 
		query.append("        V.LST_LODG_PORT_CD," ).append("\n"); 
		query.append("        V.LST_LODG_PORT_ETD_DT,V.SLS_YRMON,V.COST_WK" ).append("\n"); 
		query.append("    FROM COA_MON_VVD_V V, BSA_VVD_MST M, GRP_CAPA GC, GRP_MAX GM, " ).append("\n"); 
		query.append("         SAQ_TGT_GRP_TRD T" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND V.TRD_CD = T.TRD_CD  " ).append("\n"); 
		query.append("        AND V.DIR_CD = T.DIR_CD" ).append("\n"); 
		query.append("        AND V.SUB_TRD_CD = T.SUB_TRD_CD" ).append("\n"); 
		query.append("        AND V.TRD_CD = M.TRD_CD(+) " ).append("\n"); 
		query.append("        AND V.RLANE_CD = M.RLANE_CD(+) " ).append("\n"); 
		query.append("        AND V.VSL_CD = M.VSL_CD(+) " ).append("\n"); 
		query.append("        AND V.SKD_VOY_NO = M.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("        AND V.DIR_CD = M.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("        -- GSM MAX CAPA JOIN        " ).append("\n"); 
		query.append("        AND M.TRD_CD = GC.TRD_CD(+)" ).append("\n"); 
		query.append("        AND M.RLANE_CD = GC.RLANE_CD(+)" ).append("\n"); 
		query.append("        AND M.SKD_DIR_CD = GC.DIR_CD(+)" ).append("\n"); 
		query.append("        AND ROUND(NVL(M.FNL_CO_BSA_CAPA, 0)) = GC.FNL_BSA_CAPA(+)" ).append("\n"); 
		query.append("        -- GSM MAX JOIN" ).append("\n"); 
		query.append("        AND V.TRD_CD = GM.TRD_CD(+)" ).append("\n"); 
		query.append("        AND V.RLANE_CD = GM.RLANE_CD(+)" ).append("\n"); 
		query.append("        AND V.DIR_CD = GM.DIR_CD(+)" ).append("\n"); 
		query.append("        --AND V.RLANE_CD IN ('NE4AE')" ).append("\n"); 
		query.append(") A	," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' SPRT_GRP_CD" ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append("    ) SPRT_GRP" ).append("\n"); 
		query.append("ORDER BY A.SUB_TRD_CD, A.RLANE_CD,A.SLS_YRMON,A.COST_WK, A.LST_LODG_PORT_ETD_DT" ).append("\n"); 

	}
}