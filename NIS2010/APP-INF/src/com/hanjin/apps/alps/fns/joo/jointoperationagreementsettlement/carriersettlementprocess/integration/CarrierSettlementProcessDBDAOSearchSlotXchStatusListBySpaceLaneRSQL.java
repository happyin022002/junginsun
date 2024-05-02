/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpaceLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.06.26 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpaceLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpaceLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wkmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yr_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yr_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wkmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpaceLaneRSQL").append("\n"); 
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
		query.append("SELECT  S.COST_YRMON" ).append("\n"); 
		query.append(",       S.COST_YR" ).append("\n"); 
		query.append(",       S.COST_MON" ).append("\n"); 
		query.append(",       S.COST_WK" ).append("\n"); 
		query.append(",       S.TRD_CD" ).append("\n"); 
		query.append(",       S.RLANE_CD" ).append("\n"); 
		query.append(",       S.JO_CRR_CD" ).append("\n"); 
		query.append(",       S.VVD" ).append("\n"); 
		query.append(",       SUM(S.R_STL_BSA_QTY)     R_STL_BSA_QTY" ).append("\n"); 
		query.append(",       SUM(S.R_STL_BSA_SLT_PRC) R_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append(",       SUM(S.R_STL_LOCL_AMT   ) R_STL_LOCL_AMT" ).append("\n"); 
		query.append(",       R_JO_CRR_CD" ).append("\n"); 
		query.append(",       SUM(S.E_STL_BSA_QTY)E_STL_BSA_QTY" ).append("\n"); 
		query.append(",       SUM(S.E_STL_BSA_SLT_PRC)E_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append(",       SUM(S.E_STL_LOCL_AMT)E_STL_LOCL_AMT" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT    M.COST_YRMON," ).append("\n"); 
		query.append("                SUBSTR(M.COST_YRMON,0,4)COST_YR," ).append("\n"); 
		query.append("                SUBSTR(M.COST_YRMON,5)COST_MON," ).append("\n"); 
		query.append("                M.COST_WK" ).append("\n"); 
		query.append("                ,A.TRD_CD" ).append("\n"); 
		query.append("                ,A.RLANE_CD" ).append("\n"); 
		query.append("                ,A.JO_CRR_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY     ,A.BSA_QTY          )) AS R_STL_BSA_QTY" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC ,A.BSA_SLT_PRC  )) AS R_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,0)) AS R_STL_LOCL_AMT" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'R', A.JO_CRR_CD) AS R_JO_CRR_CD" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY     ,A.BSA_QTY      )) AS E_STL_BSA_QTY        " ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC ,A.BSA_SLT_PRC  )) AS E_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,0)) AS E_STL_LOCL_AMT" ).append("\n"); 
		query.append("        FROM    MAS_MON_VVD         M," ).append("\n"); 
		query.append("                JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("                JOO_STL_DTL     B " ).append("\n"); 
		query.append("        WHERE M.TRD_CD      = A.TRD_CD" ).append("\n"); 
		query.append("          AND M.RLANE_CD    = A.RLANE_CD" ).append("\n"); 
		query.append("          AND M.VSL_CD      = A.VSL_CD" ).append("\n"); 
		query.append("          AND M.SKD_VOY_NO  = A.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND M.DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND A.ACCT_YRMON  = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("          AND A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("          AND A.STL_SEQ     = B.STL_SEQ (+)" ).append("\n"); 
		query.append("          AND A.JO_STL_ITM_CD = 'OUS' AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("#if (${week_month} == 'W') " ).append("\n"); 
		query.append("AND   M.COST_YRMON  BETWEEN  @[yr_from]||'00' AND  @[yr_to]||'12'" ).append("\n"); 
		query.append("AND   M.COST_WK        BETWEEN  @[wkmon_fr] AND  @[wkmon_to]" ).append("\n"); 
		query.append("#elseif (${week_month} == 'M')" ).append("\n"); 
		query.append("AND   M.COST_YRMON     BETWEEN  @[yr_from]||@[wkmon_fr] AND  @[yr_to]||@[wkmon_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append("AND   A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("AND   A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '') " ).append("\n"); 
		query.append("AND   A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("AND   INSTR(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD , @[vvd] ) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  /*+ USE_HASH(SL1_18)*/ M.COST_YRMON," ).append("\n"); 
		query.append("                SUBSTR(M.COST_YRMON,0,4)COST_YR," ).append("\n"); 
		query.append("                SUBSTR(M.COST_YRMON,5)COST_MON," ).append("\n"); 
		query.append("                M.COST_WK" ).append("\n"); 
		query.append("                ,A.TRD_CD" ).append("\n"); 
		query.append("                ,A.RLANE_CD" ).append("\n"); 
		query.append("                ,A.JO_CRR_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD" ).append("\n"); 
		query.append("                ,0 R_STL_BSA_QTY" ).append("\n"); 
		query.append("                ,0 R_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'R', DECODE(A.STL_ADJ_FLG,'Y',0, SL1_18.CSR_LOCL_AMT)) AS R_STL_LOCL_AMT" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'R', A.JO_CRR_CD) AS R_JO_CRR_CD" ).append("\n"); 
		query.append("                ,0 E_STL_BSA_QTY        " ).append("\n"); 
		query.append("                ,0 E_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append("                ,0 E_STL_LOCL_AMT" ).append("\n"); 
		query.append("        FROM    MAS_MON_VVD         M," ).append("\n"); 
		query.append("                JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("                JOO_SLIP     SL1_18" ).append("\n"); 
		query.append("        WHERE M.TRD_CD      = A.TRD_CD" ).append("\n"); 
		query.append("          AND M.RLANE_CD    = A.RLANE_CD" ).append("\n"); 
		query.append("          AND M.VSL_CD      = A.VSL_CD" ).append("\n"); 
		query.append("          AND M.SKD_VOY_NO  = A.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND M.DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND   A.ACCT_YRMON  = SL1_18.ACCT_YRMON(+)" ).append("\n"); 
		query.append("          AND   A.STL_VVD_SEQ = SL1_18.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("          AND   A.STL_SEQ     = SL1_18.STL_SEQ(+)" ).append("\n"); 
		query.append("          AND   SL1_18.SLP_TP_CD(+) = '18' --18수입, 06비용" ).append("\n"); 
		query.append("          AND   SL1_18.DR_CR_CD(+)  = 'DR'" ).append("\n"); 
		query.append("          AND A.JO_STL_ITM_CD = 'OUS'  AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("#if (${week_month} == 'W') " ).append("\n"); 
		query.append("AND   M.COST_YRMON  BETWEEN  @[yr_from]||'00' AND  @[yr_to]||'12'" ).append("\n"); 
		query.append("AND   M.COST_WK        BETWEEN  @[wkmon_fr] AND  @[wkmon_to]" ).append("\n"); 
		query.append("#elseif (${week_month} == 'M')" ).append("\n"); 
		query.append("AND   M.COST_YRMON     BETWEEN  @[yr_from]||@[wkmon_fr] AND  @[yr_to]||@[wkmon_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append("AND   A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("AND   A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '') " ).append("\n"); 
		query.append("AND   A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("AND   INSTR(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD , @[vvd] ) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  /*+ USE_HASH(SL1_06)*/ M.COST_YRMON," ).append("\n"); 
		query.append("                SUBSTR(M.COST_YRMON,0,4)COST_YR," ).append("\n"); 
		query.append("                SUBSTR(M.COST_YRMON,5)COST_MON," ).append("\n"); 
		query.append("                M.COST_WK" ).append("\n"); 
		query.append("                ,A.TRD_CD" ).append("\n"); 
		query.append("                ,A.RLANE_CD" ).append("\n"); 
		query.append("                ,A.JO_CRR_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD" ).append("\n"); 
		query.append("                ,0 R_STL_BSA_QTY" ).append("\n"); 
		query.append("                ,0 R_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append("                ,0 R_STL_LOCL_AMT" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'R', A.JO_CRR_CD) AS R_JO_CRR_CD" ).append("\n"); 
		query.append("                ,0 E_STL_BSA_QTY        " ).append("\n"); 
		query.append("                ,0 E_STL_BSA_SLT_PRC" ).append("\n"); 
		query.append("                ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y', 0,SL1_06.CSR_LOCL_AMT)) AS E_STL_LOCL_AMT" ).append("\n"); 
		query.append("        FROM    MAS_MON_VVD         M," ).append("\n"); 
		query.append("                JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("                JOO_SLIP     SL1_06" ).append("\n"); 
		query.append("        WHERE M.TRD_CD      = A.TRD_CD" ).append("\n"); 
		query.append("          AND M.RLANE_CD    = A.RLANE_CD" ).append("\n"); 
		query.append("          AND M.VSL_CD      = A.VSL_CD" ).append("\n"); 
		query.append("          AND M.SKD_VOY_NO  = A.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND M.DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND A.ACCT_YRMON  = SL1_06.ACCT_YRMON(+)" ).append("\n"); 
		query.append("          AND A.STL_VVD_SEQ = SL1_06.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("          AND A.STL_SEQ     = SL1_06.STL_SEQ(+)" ).append("\n"); 
		query.append("          AND SL1_06.SLP_TP_CD(+) = '06' --18수입, 06비용" ).append("\n"); 
		query.append("          AND SL1_06.DR_CR_CD(+)  = 'DR'" ).append("\n"); 
		query.append("          AND A.JO_STL_ITM_CD = 'OUS'  AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("#if (${week_month} == 'W') " ).append("\n"); 
		query.append("AND   M.COST_YRMON  BETWEEN  @[yr_from]||'00' AND  @[yr_to]||'12'" ).append("\n"); 
		query.append("AND   M.COST_WK        BETWEEN  @[wkmon_fr] AND  @[wkmon_to]" ).append("\n"); 
		query.append("#elseif (${week_month} == 'M')" ).append("\n"); 
		query.append("AND   M.COST_YRMON     BETWEEN  @[yr_from]||@[wkmon_fr] AND  @[yr_to]||@[wkmon_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append("AND   A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("AND   A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '') " ).append("\n"); 
		query.append("AND   A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("AND   INSTR(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD , @[vvd] ) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      )S" ).append("\n"); 
		query.append("      ,JOO_CRR_AUTH AUTH" ).append("\n"); 
		query.append("WHERE  S.RLANE_CD  = AUTH.RLANE_CD" ).append("\n"); 
		query.append("AND    S.JO_CRR_CD  = AUTH.JO_CRR_CD" ).append("\n"); 
		query.append("AND    AUTH.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    AUTH.DELT_FLG = 'N'" ).append("\n"); 
		query.append("GROUP BY S.COST_YRMON" ).append("\n"); 
		query.append(",       S.COST_YR" ).append("\n"); 
		query.append(",       S.COST_MON" ).append("\n"); 
		query.append(",       S.COST_WK" ).append("\n"); 
		query.append(",       S.TRD_CD" ).append("\n"); 
		query.append(",       S.RLANE_CD" ).append("\n"); 
		query.append(",       S.JO_CRR_CD" ).append("\n"); 
		query.append(",       S.VVD" ).append("\n"); 
		query.append(",       S.R_JO_CRR_CD" ).append("\n"); 
		query.append("ORDER BY S.COST_YRMON, S.COST_WK , S.RLANE_CD, S.VVD" ).append("\n"); 

	}
}