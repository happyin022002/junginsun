/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOCreOusRdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.29 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOCreOusRdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OUS RDR Create 용
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOCreOusRdrRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOCreOusRdrRSQL").append("\n"); 
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
		query.append("      'I' AS IBFLAG" ).append("\n"); 
		query.append("     , T.ACCT_YRMON" ).append("\n"); 
		query.append("     , T.STL_VVD_SEQ" ).append("\n"); 
		query.append("     , 0 AS STL_SEQ" ).append("\n"); 
		query.append("     , T.TRD_CD" ).append("\n"); 
		query.append("     , T.JO_CRR_CD" ).append("\n"); 
		query.append("     , T.RLANE_CD" ).append("\n"); 
		query.append("     , T.RE_DIVR_CD" ).append("\n"); 
		query.append("     , T.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , T.JO_MNU_NM" ).append("\n"); 
		query.append("     , T.VSL_CD" ).append("\n"); 
		query.append("     , T.SKD_VOY_NO" ).append("\n"); 
		query.append("     , T.SKD_DIR_CD" ).append("\n"); 
		query.append("     , T.REV_DIR_CD" ).append("\n"); 
		query.append("     , T.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(T.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT" ).append("\n"); 
		query.append("     , '' JO_STL_JB_CD" ).append("\n"); 
		query.append("     , 0 AS BSA_QTY" ).append("\n"); 
		query.append("     , 0 AS BSA_SLT_PRC" ).append("\n"); 
		query.append("     , E.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , 0 ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("     , 0 ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("     , 0 AS STL_LOCL_AMT" ).append("\n"); 
		query.append("     , 0 STL_USD_AMT" ).append("\n"); 
		query.append("     , '' AS IOC_CD" ).append("\n"); 
		query.append("     , '' AS SCONTI_CD" ).append("\n"); 
		query.append("     , 0 AS FNL_HJS_BSA_QTY" ).append("\n"); 
		query.append("     , 0 AS FNL_BSA_WGT" ).append("\n"); 
		query.append("     , NULL AS USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("     , NULL AS USD_SLT_WGT" ).append("\n"); 
		query.append("     , T.BSA_PER_WGT" ).append("\n"); 
		query.append("     , NULL AS FM_PORT_CD" ).append("\n"); 
		query.append("     , NULL AS TO_PORT_CD" ).append("\n"); 
		query.append("     , NULL AS RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("     , NULL AS RF_SCG_PRC" ).append("\n"); 
		query.append("     , NULL AS STL_RMK" ).append("\n"); 
		query.append("     , NULL AS CMB_CFM_FLG" ).append("\n"); 
		query.append("     , NULL AS STL_CMB_SEQ" ).append("\n"); 
		query.append("     , NULL AS STL_TJ_NO" ).append("\n"); 
		query.append("     , 'N'  AS STL_ADJ_FLG" ).append("\n"); 
		query.append("     , NULL AS PRE_ACCT_YRMON" ).append("\n"); 
		query.append("     , NULL AS PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("     , NULL AS PRE_STL_SEQ" ).append("\n"); 
		query.append("     , 'Y'  AS STL_LST_FLG" ).append("\n"); 
		query.append("     , T.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(T.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("     , NULL AS SLIP_NO" ).append("\n"); 
		query.append("     , 'N' AS RVS_CMB_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("     SELECT J.ACCT_YRMON, J.STL_VVD_SEQ, J.TRD_CD, J.JO_CRR_CD, J.RLANE_CD, J.RE_DIVR_CD, J.JO_STL_ITM_CD, 'RDR' AS JO_MNU_NM" ).append("\n"); 
		query.append("          , J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.STL_BZC_PORT_CD, J.BZC_PORT_ETD_DT BZC_PORT_ETA_DT, J.UC_BSS_PORT_CD, J.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("          -- 2010.01.19 WEIGHT PER TEU 는 CARRIER MERGE하지말고 해당 선사것만 가져온다." ).append("\n"); 
		query.append("          -- 2010.03.25 WEIGHT PER TEU 는 EXPENSE일지라고 HJS가 아니 해당 선사 것을 가져온다." ).append("\n"); 
		query.append("          , TRUNC(SUM(C.CRR_BSA_CAPA),2) BSA_PER_WGT" ).append("\n"); 
		query.append("     FROM   JOO_STL_VVD     J" ).append("\n"); 
		query.append("          , BSA_VVD_OTR_CRR C" ).append("\n"); 
		query.append("     WHERE  J.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("     AND    J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("     AND    J.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("     AND    J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("     AND    J.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("     AND    J.JO_MNU_NM     IN ('RDR','TDR')" ).append("\n"); 
		query.append("     AND    J.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("     AND    J.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("     AND    J.VSL_CD        = C.VSL_CD    (+)" ).append("\n"); 
		query.append("     AND    J.SKD_VOY_NO    = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("     AND    J.SKD_DIR_CD    = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("     AND    J.RLANE_CD      = C.RLANE_CD  (+)" ).append("\n"); 
		query.append("     AND    J.JO_CRR_CD     = C.CRR_CD    (+)" ).append("\n"); 
		query.append("     AND    J.TRD_CD        = C.TRD_CD    (+)" ).append("\n"); 
		query.append("     AND    C.BSA_OP_JB_CD(+) = '008'" ).append("\n"); 
		query.append("     GROUP  BY J.ACCT_YRMON, J.STL_VVD_SEQ, J.TRD_CD, J.JO_CRR_CD, J.RLANE_CD, J.RE_DIVR_CD, J.JO_STL_ITM_CD" ).append("\n"); 
		query.append("          , J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.STL_BZC_PORT_CD, J.BZC_PORT_ETD_DT, J.UC_BSS_PORT_CD, J.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("     )T," ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("     SELECT LOCL_CURR_CD" ).append("\n"); 
		query.append("     FROM   JOO_FINC_MTX" ).append("\n"); 
		query.append("     WHERE  JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("     AND    RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("     AND    RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("     AND    JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("     )E" ).append("\n"); 
		query.append("--2010.03.29 REVERSE 된 VVD는 나와야 한다." ).append("\n"); 
		query.append("WHERE (T.VSL_CD, T.SKD_VOY_NO, T.SKD_DIR_CD, T.REV_DIR_CD, 'N') NOT IN (" ).append("\n"); 
		query.append("        SELECT X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.REV_DIR_CD, NVL(Y.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("        FROM   JOO_SETTLEMENT  X," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT Y.ACCT_YRMON, Y.STL_VVD_SEQ, Y.STL_SEQ, Z.RVS_CMB_FLG" ).append("\n"); 
		query.append("               FROM   JOO_STL_CMB_DTL Y," ).append("\n"); 
		query.append("                      JOO_STL_CMB     Z" ).append("\n"); 
		query.append("               WHERE  Y.ACCT_YRMON = Z.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    Y.JO_CRR_CD  = Z.JO_CRR_CD" ).append("\n"); 
		query.append("               AND    Y.STL_CMB_SEQ= Z.STL_CMB_SEQ" ).append("\n"); 
		query.append("               AND    Y.RE_DIVR_CD = Z.RE_DIVR_CD" ).append("\n"); 
		query.append("               ) Y" ).append("\n"); 
		query.append("        WHERE  X.ACCT_YRMON     = Y.ACCT_YRMON  (+)" ).append("\n"); 
		query.append("        AND    X.STL_VVD_SEQ    = Y.STL_VVD_SEQ (+)" ).append("\n"); 
		query.append("        AND    X.STL_SEQ        = Y.STL_SEQ     (+) " ).append("\n"); 
		query.append("        AND    X.ACCT_YRMON     = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("        AND    X.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("        AND    X.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("        AND    X.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("        AND    X.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("        AND    X.JO_STL_ITM_CD  = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("        AND    X.JO_MNU_NM      = 'RDR'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("WHERE  NOT EXISTS (" ).append("\n"); 
		query.append("        SELECT 1" ).append("\n"); 
		query.append("        FROM   JOO_SETTLEMENT  X" ).append("\n"); 
		query.append("        WHERE  X.ACCT_YRMON     = T.ACCT_YRMON" ).append("\n"); 
		query.append("        AND    X.JO_CRR_CD      = T.JO_CRR_CD" ).append("\n"); 
		query.append("        AND    X.RE_DIVR_CD     = T.RE_DIVR_CD" ).append("\n"); 
		query.append("        AND    X.TRD_CD         = T.TRD_CD" ).append("\n"); 
		query.append("        AND    X.RLANE_CD       = T.RLANE_CD" ).append("\n"); 
		query.append("        AND    X.JO_STL_ITM_CD  = T.JO_STL_ITM_CD" ).append("\n"); 
		query.append("        AND    X.JO_MNU_NM      = T.JO_MNU_NM" ).append("\n"); 
		query.append("        AND    X.VSL_CD         = T.VSL_CD" ).append("\n"); 
		query.append("        AND    X.SKD_VOY_NO     = T.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    X.SKD_DIR_CD     = T.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    X.REV_DIR_CD     = T.REV_DIR_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      'R' AS IBFLAG" ).append("\n"); 
		query.append("      ,A.ACCT_YRMON" ).append("\n"); 
		query.append("      ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,A.STL_SEQ" ).append("\n"); 
		query.append("      ,A.TRD_CD" ).append("\n"); 
		query.append("      ,A.JO_CRR_CD" ).append("\n"); 
		query.append("      ,A.RLANE_CD" ).append("\n"); 
		query.append("      ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("      ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("      ,A.JO_MNU_NM" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.REV_DIR_CD" ).append("\n"); 
		query.append("      ,A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.ETA_DT,'YYYYMMDDHH24MISS') ETA_DT" ).append("\n"); 
		query.append("      ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("      ,A.BSA_QTY" ).append("\n"); 
		query.append("      ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,A.ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.STL_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.STL_USD_AMT" ).append("\n"); 
		query.append("      ,A.IOC_CD" ).append("\n"); 
		query.append("      ,A.SCONTI_CD" ).append("\n"); 
		query.append("      ,A.FNL_HJS_BSA_QTY" ).append("\n"); 
		query.append("      ,A.FNL_BSA_WGT" ).append("\n"); 
		query.append("      ,A.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("      ,A.USD_SLT_WGT" ).append("\n"); 
		query.append("      ,A.BSA_PER_WGT" ).append("\n"); 
		query.append("      ,A.FM_PORT_CD" ).append("\n"); 
		query.append("      ,A.TO_PORT_CD" ).append("\n"); 
		query.append("      ,A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("      ,A.RF_SCG_PRC" ).append("\n"); 
		query.append("      ,A.STL_RMK" ).append("\n"); 
		query.append("      ,A.CMB_CFM_FLG" ).append("\n"); 
		query.append("      ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("      ,A.STL_TJ_NO" ).append("\n"); 
		query.append("      ,A.STL_ADJ_FLG" ).append("\n"); 
		query.append("      ,A.PRE_ACCT_YRMON" ).append("\n"); 
		query.append("      ,A.PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,A.PRE_STL_SEQ" ).append("\n"); 
		query.append("      ,A.STL_LST_FLG" ).append("\n"); 
		query.append("      ,A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("      ,B.SLIP_NO" ).append("\n"); 
		query.append("      ,NVL(B.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("              B.ACCT_YRMON" ).append("\n"); 
		query.append("             ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("             ,B.STL_SEQ" ).append("\n"); 
		query.append("             ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("             ,A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS SLIP_NO" ).append("\n"); 
		query.append("             ,A.RVS_CMB_FLG" ).append("\n"); 
		query.append("             ,A.RJCT_CMB_FLG" ).append("\n"); 
		query.append("       FROM   JOO_STL_CMB     A," ).append("\n"); 
		query.append("              JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("       WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("       AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("       AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("       AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("       AND    A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("       AND    A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("       AND    A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("       -- 2010.01.06 REVERSE 된 것은 COMBINED NO가 보여져서는 안된다 => 삭제가능하게 " ).append("\n"); 
		query.append("      -- 2010.03.23 REVERSE 된 것은 copy를 하므로 기존 reverse data는 combined no를 보여주도록 한다. (삭제불가)" ).append("\n"); 
		query.append("       --AND    A.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("       --AND    A.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND	   A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("ORDER  BY 1 DESC, SKD_DIR_CD, VSL_CD, SKD_VOY_NO, REV_DIR_CD" ).append("\n"); 

	}
}