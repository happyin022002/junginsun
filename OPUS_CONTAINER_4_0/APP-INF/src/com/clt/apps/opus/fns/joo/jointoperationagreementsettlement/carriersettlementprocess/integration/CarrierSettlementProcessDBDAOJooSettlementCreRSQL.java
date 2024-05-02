/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOJooSettlementCreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.03.18 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOJooSettlementCreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 생성용 query(S/H, OTH, W/R, P/B)
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOJooSettlementCreRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOJooSettlementCreRSQL").append("\n"); 
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
		query.append("      ,A.FNL_OWN_BSA_QTY" ).append("\n"); 
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
		query.append("      , CASE WHEN NVL(C.REV_YRMON,'null') = 'null' THEN 'Y' ELSE 'N' END AS CXL_VVD_FLG" ).append("\n"); 
		query.append("      , NVL(B.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT A," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("             B.ACCT_YRMON" ).append("\n"); 
		query.append("            ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("            ,B.STL_SEQ" ).append("\n"); 
		query.append("            ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("            ,'' AS SLIP_NO" ).append("\n"); 
		query.append("            ,A.RVS_CMB_FLG" ).append("\n"); 
		query.append("            ,A.RJCT_CMB_FLG" ).append("\n"); 
		query.append("      FROM   JOO_STL_CMB     A," ).append("\n"); 
		query.append("             JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("      WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("      AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("      AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("      AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("      AND    A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("      AND    A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("      AND    A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("      -- 2010.01.06 REVERSE 된 것은 COMBINED NO가 보여져서는 안된다 => 삭제가능하게 " ).append("\n"); 
		query.append("      -- 2010.03.23 REVERSE 된 것은 copy를 하므로 기존 reverse data는 combined no를 보여주도록 한다. (삭제불가)" ).append("\n"); 
		query.append("      --AND    A.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("      --AND    A.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("      ) B," ).append("\n"); 
		query.append("       AR_MST_REV_VVD C" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND    A.VSL_CD        = C.VSL_CD     (+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = C.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = C.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = C.RLANE_CD   (+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("--2010.04.14 누락된 조회조건 추가 => Settlement단에는 Adjust내역을 보여주지 않는다." ).append("\n"); 
		query.append("AND    NVL(A.STL_ADJ_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if (${jo_mnu_nm} == 'M/S')" ).append("\n"); 
		query.append("	AND  (A.JO_STL_ITM_CD = 'OTH' OR A.JO_MNU_NM = @[jo_mnu_nm])" ).append("\n"); 
		query.append("	#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("		AND	  A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND	  A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("	AND   A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       'I' AS IBFLAG" ).append("\n"); 
		query.append("       ,A.ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,0 AS STL_SEQ" ).append("\n"); 
		query.append("       ,A.TRD_CD" ).append("\n"); 
		query.append("       ,A.JO_CRR_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("       ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ,A.JO_MNU_NM" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.REV_DIR_CD" ).append("\n"); 
		query.append("       ,A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') ETA_DT" ).append("\n"); 
		query.append("       ,NULL AS JO_STL_JB_CD" ).append("\n"); 
		query.append("       ,NULL AS BSA_QTY" ).append("\n"); 
		query.append("       ,NULL AS BSA_SLT_PRC" ).append("\n"); 
		query.append("       ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("       ,NULL AS ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("       ,NULL AS ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("       ,NULL AS STL_LOCL_AMT" ).append("\n"); 
		query.append("       ,NULL AS STL_USD_AMT" ).append("\n"); 
		query.append("       ,NULL AS IOC_CD" ).append("\n"); 
		query.append("       ,NULL AS SCONTI_CD" ).append("\n"); 
		query.append("       ,NULL AS FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("       ,NULL AS FNL_BSA_WGT" ).append("\n"); 
		query.append("       ,NULL AS USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("       ,NULL AS USD_SLT_WGT" ).append("\n"); 
		query.append("       ,NULL AS BSA_PER_WGT" ).append("\n"); 
		query.append("       ,NULL AS FM_PORT_CD" ).append("\n"); 
		query.append("       ,NULL AS TO_PORT_CD" ).append("\n"); 
		query.append("       ,NULL AS RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("       ,NULL AS RF_SCG_PRC" ).append("\n"); 
		query.append("       ,NULL AS STL_RMK" ).append("\n"); 
		query.append("       ,NULL AS CMB_CFM_FLG" ).append("\n"); 
		query.append("       ,NULL AS STL_CMB_SEQ" ).append("\n"); 
		query.append("       ,NULL AS STL_TJ_NO" ).append("\n"); 
		query.append("       ,'N'  AS STL_ADJ_FLG" ).append("\n"); 
		query.append("       ,NULL AS PRE_ACCT_YRMON" ).append("\n"); 
		query.append("       ,NULL AS PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,NULL AS PRE_STL_SEQ" ).append("\n"); 
		query.append("       ,'Y'  AS STL_LST_FLG" ).append("\n"); 
		query.append("       ,A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("       ,'' AS SLIP_NO" ).append("\n"); 
		query.append("       ,CASE WHEN NVL(C.REV_YRMON,'null') = 'null' THEN 'Y' ELSE 'N' END AS CXL_VVD_FLG" ).append("\n"); 
		query.append("       ,'N' AS RVS_CMB_FLG" ).append("\n"); 
		query.append("FROM   JOO_STL_VVD    A," ).append("\n"); 
		query.append("       JOO_FINC_MTX   B," ).append("\n"); 
		query.append("       AR_MST_REV_VVD C" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD     = B.JO_CRR_CD(+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = B.RLANE_CD (+)" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = B.RE_DIVR_CD (+)" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = B.JO_STL_ITM_CD (+)" ).append("\n"); 
		query.append("AND    A.VSL_CD        = C.VSL_CD     (+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = C.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = C.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = C.RLANE_CD   (+)" ).append("\n"); 
		query.append("--AND    NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#if (${jo_mnu_nm} == 'M/S')" ).append("\n"); 
		query.append("AND   (A.JO_STL_ITM_CD = 'OTH' OR A.JO_MNU_NM = @[jo_mnu_nm])" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("AND	   A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	   A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.JO_STL_ITM_CD, A.JO_MNU_NM, 'N') NOT IN (" ).append("\n"); 
		query.append("        SELECT X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.REV_DIR_CD, X.JO_STL_ITM_CD, X.JO_MNU_NM, NVL(Y.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
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
		query.append("#if (${jo_mnu_nm} == 'M/S')" ).append("\n"); 
		query.append("        AND    X.JO_MNU_NM      = @[jo_mnu_nm]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND	   X.JO_STL_ITM_CD  = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("        AND    X.JO_MNU_NM      = @[jo_mnu_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("AND    NOT EXISTS (" ).append("\n"); 
		query.append("        SELECT 1" ).append("\n"); 
		query.append("        FROM   JOO_SETTLEMENT  X" ).append("\n"); 
		query.append("        WHERE  X.ACCT_YRMON     = A.ACCT_YRMON" ).append("\n"); 
		query.append("        AND    X.JO_CRR_CD      = A.JO_CRR_CD" ).append("\n"); 
		query.append("        AND    X.RE_DIVR_CD     = A.RE_DIVR_CD" ).append("\n"); 
		query.append("        AND    X.TRD_CD         = A.TRD_CD" ).append("\n"); 
		query.append("        AND    X.RLANE_CD       = A.RLANE_CD" ).append("\n"); 
		query.append("        AND    X.JO_STL_ITM_CD  = A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("        AND    X.JO_MNU_NM      = A.JO_MNU_NM" ).append("\n"); 
		query.append("        AND    X.VSL_CD         = A.VSL_CD" ).append("\n"); 
		query.append("        AND    X.SKD_VOY_NO     = A.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    X.SKD_DIR_CD     = A.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    X.REV_DIR_CD     = A.REV_DIR_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("ORDER BY 1 DESC, SKD_DIR_CD, VSL_CD, SKD_VOY_NO, REV_DIR_CD" ).append("\n"); 

	}
}