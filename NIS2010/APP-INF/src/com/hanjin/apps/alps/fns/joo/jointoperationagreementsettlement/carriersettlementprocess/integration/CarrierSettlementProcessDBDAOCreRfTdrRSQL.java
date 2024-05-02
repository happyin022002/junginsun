/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOCreRfTdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOCreRfTdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reefer Surcharge TDR Create 용 query
	  * 모두 Field를 가져온다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOCreRfTdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOCreRfTdrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       'R' AS IBFLAG " ).append("\n"); 
		query.append("     , A.ACCT_YRMON" ).append("\n"); 
		query.append("     , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("     , A.JO_CRR_CD" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.RE_DIVR_CD" ).append("\n"); 
		query.append("     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , A.JO_MNU_NM" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , A.ETA_DT" ).append("\n"); 
		query.append("     , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("     , A.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("     , A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("     , A.IOC_CD" ).append("\n"); 
		query.append("     , A.SCONTI_CD" ).append("\n"); 
		query.append("     , A.FM_PORT_CD" ).append("\n"); 
		query.append("     , A.TO_PORT_CD" ).append("\n"); 
		query.append("     , A.FM_PORT_CD1" ).append("\n"); 
		query.append("     , A.TO_PORT_CD1" ).append("\n"); 
		query.append("     , A.VVD_SUM_AMT" ).append("\n"); 
		query.append("     , MIN(A.STL_CMB_SEQ) AS STL_CMB_SEQ" ).append("\n"); 
		query.append("     , MIN(A.SLIP_NO) AS SLIP_NO" ).append("\n"); 
		query.append("     , SUM(DECODE(A.JO_STL_JB_CD,'301',A.USD_SLT_BSA_QTY,0)) AS USD_SLT_BSA_QTY_20" ).append("\n"); 
		query.append("     , SUM(DECODE(A.JO_STL_JB_CD,'302',A.USD_SLT_BSA_QTY,0)) AS USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("     , SUM(DECODE(A.JO_STL_JB_CD,'301',A.RF_SCG_PRC,0)) AS RF_SCG_PRC_20" ).append("\n"); 
		query.append("     , SUM(DECODE(A.JO_STL_JB_CD,'302',A.RF_SCG_PRC,0)) AS RF_SCG_PRC_40" ).append("\n"); 
		query.append("     , SUM(DECODE(A.JO_STL_JB_CD,'301',A.STL_LOCL_AMT,0)) AS STL_LOCL_AMT_20" ).append("\n"); 
		query.append("     , SUM(DECODE(A.JO_STL_JB_CD,'302',A.STL_LOCL_AMT,0)) AS STL_LOCL_AMT_40" ).append("\n"); 
		query.append("     , MIN(DECODE(A.JO_STL_JB_CD,'301',A.STL_SEQ)) AS STL_SEQ_20" ).append("\n"); 
		query.append("     , MIN(DECODE(A.JO_STL_JB_CD,'302',A.STL_SEQ)) AS STL_SEQ_40" ).append("\n"); 
		query.append("     , MIN(DECODE(A.JO_STL_JB_CD,'301',A.STL_DUP_FLG)) AS STL_DUP_FLG_20" ).append("\n"); 
		query.append("     , MIN(DECODE(A.JO_STL_JB_CD,'302',A.STL_DUP_FLG)) AS STL_DUP_FLG_40" ).append("\n"); 
		query.append("     , MIN(DECODE(A.JO_STL_JB_CD,'301',A.STL_ADJ_FLG)) AS STL_ADJ_FLG_20" ).append("\n"); 
		query.append("     , MIN(DECODE(A.JO_STL_JB_CD,'302',A.STL_ADJ_FLG)) AS STL_ADJ_FLG_40" ).append("\n"); 
		query.append("     , MIN(DECODE(A.JO_STL_JB_CD,'301',A.STL_LST_FLG)) AS STL_LST_FLG_20" ).append("\n"); 
		query.append("     , MIN(DECODE(A.JO_STL_JB_CD,'302',A.STL_LST_FLG)) AS STL_LST_FLG_40" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("              A.ACCT_YRMON, A.STL_VVD_SEQ, A.JO_CRR_CD, A.TRD_CD, A.RLANE_CD, A.RE_DIVR_CD, A.JO_STL_ITM_CD, A.JO_MNU_NM, " ).append("\n"); 
		query.append("              A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.STL_BZC_PORT_CD, TO_CHAR(A.ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT," ).append("\n"); 
		query.append("              A.LOCL_CURR_CD, A.UC_BSS_PORT_CD, TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT," ).append("\n"); 
		query.append("              A.RF_SCG_STL_TP_CD, A.IOC_CD, A.SCONTI_CD, A.FM_PORT_CD, A.TO_PORT_CD, A.FM_PORT_CD AS FM_PORT_CD1, A.TO_PORT_CD AS TO_PORT_CD1," ).append("\n"); 
		query.append("              B.STL_CMB_SEQ, B.SLIP_NO, A.JO_STL_JB_CD, A.USD_SLT_BSA_QTY, A.RF_SCG_PRC, A.STL_LOCL_AMT, A.STL_SEQ, A.STL_DUP_FLG, A.STL_ADJ_FLG, A.STL_LST_FLG," ).append("\n"); 
		query.append("              SUM(DECODE(A.JO_STL_JB_CD,'301',A.STL_LOCL_AMT,'302',A.STL_LOCL_AMT,0)) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD) AS VVD_SUM_AMT" ).append("\n"); 
		query.append("       FROM   JOO_SETTLEMENT A," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT" ).append("\n"); 
		query.append("                     B.ACCT_YRMON" ).append("\n"); 
		query.append("                    ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("                    ,B.STL_SEQ" ).append("\n"); 
		query.append("                    ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("                    ,A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS SLIP_NO" ).append("\n"); 
		query.append("              FROM   JOO_STL_CMB     A," ).append("\n"); 
		query.append("                     JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("              WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("              AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("              AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("              AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("              AND    A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("              AND    A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("              AND    A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("              -- 2010.01.06 REVERSE 된 것은 COMBINED NO가 보여져서는 안된다 => 삭제가능하게 " ).append("\n"); 
		query.append("              AND    A.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("              AND    A.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("              ) B" ).append("\n"); 
		query.append("       WHERE A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("       AND   A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("       AND   A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("       AND   A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("       AND	 A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("       AND	 A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("       AND	 A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("       AND	 A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("       AND   A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("       AND   A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("GROUP  BY" ).append("\n"); 
		query.append("       A.ACCT_YRMON" ).append("\n"); 
		query.append("     , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("     , A.JO_CRR_CD" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.RE_DIVR_CD" ).append("\n"); 
		query.append("     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , A.JO_MNU_NM" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , A.ETA_DT" ).append("\n"); 
		query.append("     , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("     , A.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("     , A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("     , A.IOC_CD" ).append("\n"); 
		query.append("     , A.SCONTI_CD" ).append("\n"); 
		query.append("     , A.FM_PORT_CD" ).append("\n"); 
		query.append("     , A.TO_PORT_CD" ).append("\n"); 
		query.append("     , A.FM_PORT_CD1" ).append("\n"); 
		query.append("     , A.TO_PORT_CD1" ).append("\n"); 
		query.append("     , A.VVD_SUM_AMT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     'I' AS IBFLAG" ).append("\n"); 
		query.append("    , J.ACCT_YRMON" ).append("\n"); 
		query.append("    , J.STL_VVD_SEQ" ).append("\n"); 
		query.append("    , J.JO_CRR_CD" ).append("\n"); 
		query.append("    , J.TRD_CD" ).append("\n"); 
		query.append("    , J.RLANE_CD" ).append("\n"); 
		query.append("    , J.RE_DIVR_CD" ).append("\n"); 
		query.append("    , J.JO_STL_ITM_CD" ).append("\n"); 
		query.append("    , J.JO_MNU_NM" ).append("\n"); 
		query.append("    , J.VSL_CD" ).append("\n"); 
		query.append("    , J.SKD_VOY_NO" ).append("\n"); 
		query.append("    , J.SKD_DIR_CD" ).append("\n"); 
		query.append("    , J.REV_DIR_CD" ).append("\n"); 
		query.append("    , J.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("    , TO_CHAR(J.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT" ).append("\n"); 
		query.append("    , @[locl_curr_cd] AS LOCL_CURR_CD" ).append("\n"); 
		query.append("    , J.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("    , TO_CHAR(J.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("    , 'T' AS RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("    , 'I' AS IOC_CD" ).append("\n"); 
		query.append("    , 'A' AS SCONTI_CD" ).append("\n"); 
		query.append("    , O.POL AS FM_PORT_CD" ).append("\n"); 
		query.append("    , O.POD AS TO_PORT_CD" ).append("\n"); 
		query.append("    , O.POL AS FM_PORT_CD1" ).append("\n"); 
		query.append("    , O.POD AS TO_PORT_CD1" ).append("\n"); 
		query.append("    , 0  AS VVD_SUM_AMT" ).append("\n"); 
		query.append("    , NULL AS STL_CMB_SEQ" ).append("\n"); 
		query.append("    , NULL AS SLIP_NO" ).append("\n"); 
		query.append("    , O.RF_20_QTY AS USD_SLT_BSA_QTY_20" ).append("\n"); 
		query.append("    , O.RF_40_QTY AS USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("    , P.RF_20_PRC AS USD_RF_SCG_PRC_20" ).append("\n"); 
		query.append("    , P.RF_40_PRC AS USD_RF_SCG_PRC_40" ).append("\n"); 
		query.append("    , NULL AS STL_LOCL_AMT_20" ).append("\n"); 
		query.append("    , NULL AS STL_LOCL_AMT_40" ).append("\n"); 
		query.append("    , NULL AS STL_SEQ_20" ).append("\n"); 
		query.append("    , NULL AS STL_SEQ_40" ).append("\n"); 
		query.append("    , 'N' AS STL_DUP_FLG_20" ).append("\n"); 
		query.append("    , 'N' AS STL_DUP_FLG_40" ).append("\n"); 
		query.append("    , 'N' AS STL_ADJ_FLG_20" ).append("\n"); 
		query.append("    , 'N' AS STL_ADJ_FLG_40" ).append("\n"); 
		query.append("    , 'Y' AS STL_LST_FLG_20" ).append("\n"); 
		query.append("    , 'Y' AS STL_LST_FLG_40    " ).append("\n"); 
		query.append("FROM  JOO_STL_VVD J," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT M.TRD_CD, M.RLANE_CD, M.DIR_CD, M.BSA_SLT_PRC_FM_DT, M.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("           , SUM(DECODE(M.RT_TEU_FLG, 'A', D.UC_AMT, 'T', D.UC_AMT, 0)) RF_20_PRC" ).append("\n"); 
		query.append("           , SUM(DECODE(M.RT_TEU_FLG, 'A', D.UC_AMT, 'F', D.UC_AMT, 0)) RF_40_PRC" ).append("\n"); 
		query.append("        FROM BSA_RF_SCG_MST M" ).append("\n"); 
		query.append("           , BSA_RF_SCG_SLT_PRC D" ).append("\n"); 
		query.append("       WHERE M.BSA_SLT_COST_TP_CD = D.BSA_SLT_COST_TP_CD" ).append("\n"); 
		query.append("         AND M.RF_SCG_SLT_PRC_SEQ = D.RF_SCG_SLT_PRC_SEQ" ).append("\n"); 
		query.append("         AND M.TRD_CD             = D.TRD_CD" ).append("\n"); 
		query.append("         AND M.RLANE_CD           = D.RLANE_CD" ).append("\n"); 
		query.append("         AND M.DIR_CD             = D.DIR_CD" ).append("\n"); 
		query.append("         --2010.01.21 박효숙차장 TDR인 경우 Inter/Ocean 구분이 없으며 Long Leg(Ocean)을 가져와야함" ).append("\n"); 
		query.append("         AND M.BSA_SLT_COST_TP_CD = '018'" ).append("\n"); 
		query.append("         AND M.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("         AND D.TRD_CD             = @[trd_cd]" ).append("\n"); 
		query.append("         AND D.RLANE_CD           = @[rlane_cd]" ).append("\n"); 
		query.append("         AND D.CRR_CD             = @[jo_crr_cd]" ).append("\n"); 
		query.append("      GROUP BY M.TRD_CD, M.RLANE_CD, M.DIR_CD, M.BSA_SLT_PRC_FM_DT, M.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("      )P," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT D.VSL_CD, D.VOY_NO SKD_VOY_NO, D.DIR_CD SKD_DIR_CD, H.PORT_CD POL, D.POD," ).append("\n"); 
		query.append("             SUM(DECODE(D.CNTR_SIZE,'2',1,'3',1,0)) RF_20_QTY," ).append("\n"); 
		query.append("             SUM(DECODE(D.CNTR_SIZE,'4',1,'H',1,'L',1,0)) RF_40_QTY" ).append("\n"); 
		query.append("      FROM   TDR_HEADER H, TDR_CNTR_DETAIL D" ).append("\n"); 
		query.append("      WHERE  1=1" ).append("\n"); 
		query.append("      AND    H.VSL_CD   = D.VSL_CD" ).append("\n"); 
		query.append("      AND    H.VOY_NO   = D.VOY_NO" ).append("\n"); 
		query.append("      AND    H.DIR_CD   = D.DIR_CD" ).append("\n"); 
		query.append("      AND    H.PORT_CD  = D.PORT_CD" ).append("\n"); 
		query.append("      AND    H.CALL_IND = D.CALL_IND" ).append("\n"); 
		query.append("      AND    D.STATUS   = 'LS'" ).append("\n"); 
		query.append("      AND   (D.OPR_CD, H.VSL_CD, H.VOY_NO, H.DIR_CD) IN " ).append("\n"); 
		query.append("           (SELECT B.JO_CRR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("            FROM   JOO_STL_VVD A," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("            		SELECT DECODE(@[re_divr_cd], 'E', 'SML', @[jo_crr_cd]) AS JO_CRR_CD, TO_DATE('99991231','YYYYMMDD') AS EFF_ETA_DT" ).append("\n"); 
		query.append("            		FROM   DUAL" ).append("\n"); 
		query.append("            		UNION  ALL" ).append("\n"); 
		query.append("            		SELECT JO_N2ND_CRR_CD AS JO_CRR_CD, EFF_ETA_DT" ).append("\n"); 
		query.append("            		FROM   JOO_CRR_MRG A" ).append("\n"); 
		query.append("            		WHERE  A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("            		AND    A.ACCTG_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("            		AND    A.JO_N1ST_CRR_CD = DECODE(@[re_divr_cd], 'E', 'SML', @[jo_crr_cd])" ).append("\n"); 
		query.append("            		AND    A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("            		AND    A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("                   ) B" ).append("\n"); 
		query.append("            WHERE  A.BZC_PORT_ETA_DT <= B.EFF_ETA_DT" ).append("\n"); 
		query.append("            AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("            AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("            AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("            AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("            AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("            AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("            AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("            AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("      AND    D.TEMP IS NOT NULL" ).append("\n"); 
		query.append("      GROUP BY D.VSL_CD, D.VOY_NO, D.DIR_CD, H.PORT_CD, D.POD" ).append("\n"); 
		query.append("      )O" ).append("\n"); 
		query.append("WHERE J.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND   J.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND   J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND   J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND   J.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND   J.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND   J.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("AND   J.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("AND   J.TRD_CD        = P.TRD_CD(+)" ).append("\n"); 
		query.append("AND   J.RLANE_CD      = P.RLANE_CD(+)" ).append("\n"); 
		query.append("AND   J.SKD_DIR_CD    = P.DIR_CD(+)" ).append("\n"); 
		query.append("AND   J.VSL_CD        = O.VSL_CD(+)" ).append("\n"); 
		query.append("AND   J.SKD_VOY_NO    = O.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND   J.SKD_DIR_CD    = O.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND   J.UC_BSS_PORT_ETD_DT BETWEEN TO_DATE(P.BSA_SLT_PRC_FM_DT(+),'YYYYMMDDHH24MISS') AND TO_DATE(P.BSA_SLT_PRC_TO_DT(+),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("ORDER BY IBFLAG DESC, SKD_DIR_CD, VSL_CD, SKD_VOY_NO, REV_DIR_CD, FM_PORT_CD, TO_PORT_CD" ).append("\n"); 

	}
}