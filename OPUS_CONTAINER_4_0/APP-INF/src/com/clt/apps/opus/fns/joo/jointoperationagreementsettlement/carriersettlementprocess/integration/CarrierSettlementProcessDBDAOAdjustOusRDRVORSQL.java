/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOAdjustOusRDRVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOAdjustOusRDRVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR Settlement Adjust
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOAdjustOusRDRVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOAdjustOusRDRVORSQL").append("\n"); 
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
		query.append("WITH JO_CRR AS (" ).append("\n"); 
		query.append("  SELECT B.JO_CRR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM JOO_STL_VVD A," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("    		 SELECT DECODE(@[re_divr_cd], 'E', COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC, @[jo_crr_cd]) AS JO_CRR_CD, TO_DATE('99991231','YYYYMMDD') AS EFF_ETA_DT" ).append("\n"); 
		query.append("    		 FROM   DUAL" ).append("\n"); 
		query.append("    		 UNION  ALL" ).append("\n"); 
		query.append("    		 SELECT JO_N2ND_CRR_CD AS JO_CRR_CD, EFF_ETA_DT" ).append("\n"); 
		query.append("    		 FROM   JOO_CRR_MRG A" ).append("\n"); 
		query.append("    		 WHERE  A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("    		 AND    A.ACCTG_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("    		 AND    A.JO_N1ST_CRR_CD = DECODE(@[re_divr_cd], 'E', COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC, @[jo_crr_cd])" ).append("\n"); 
		query.append("    		 AND    A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("    		 AND    A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("   WHERE A.BZC_PORT_ETA_DT <= B.EFF_ETA_DT" ).append("\n"); 
		query.append("     AND A.ACCT_YRMON   >= REPLACE(@[fm_acct_yrmon],'-','')" ).append("\n"); 
		query.append("     AND A.ACCT_YRMON   <= REPLACE(@[to_acct_yrmon],'-','')" ).append("\n"); 
		query.append("     AND A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("     AND A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("     AND A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("     AND A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("     AND A.JO_STL_ITM_CD = 'OUS'" ).append("\n"); 
		query.append("     AND A.JO_MNU_NM    IN ('RDR','TDR')" ).append("\n"); 
		query.append("     AND A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, UC_BSS_PORT_CD, IOC_CD, SCONTI_CD, FM_PORT_CD, FM_PORT_ETD_DT, JO_STL_ITM_CD, LOCL_CURR_CD, STL_CMB_SEQ," ).append("\n"); 
		query.append("       COA_TEU, COA_WGT, FNL_OWN_BSA_QTY, FNL_BSA_WGT, DIFF_TEU, DIFF_WGT, USD_SLT_BSA_QTY, USD_SLT_WGT, RDR_TEU, RDR_WGT, BSA_QTY, UC_AMT, BSA_SLT_PRC" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.UC_BSS_PORT_CD, J.IOC_CD, J.SCONTI_CD, J.FM_PORT_CD, J.FM_PORT_ETD_DT, J.JO_STL_ITM_CD, J.LOCL_CURR_CD, J.STL_CMB_SEQ," ).append("\n"); 
		query.append("       NVL(A.TEU,0) AS COA_TEU, NVL(A.WGT,0) AS COA_WGT, J.FNL_OWN_BSA_QTY, J.FNL_BSA_WGT, NVL(A.TEU,0) - J.FNL_OWN_BSA_QTY AS DIFF_TEU, NVL(A.WGT,0) - J.FNL_BSA_WGT AS DIFF_WGT," ).append("\n"); 
		query.append("       J.USD_SLT_BSA_QTY, J.USD_SLT_WGT, NVL(R.RDR_TEU,0) AS RDR_TEU, NVL(R.RDR_WGT,0) AS RDR_WGT, J.BSA_QTY, NVL(C.UC_AMT,0) AS UC_AMT, J.BSA_SLT_PRC" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT " ).append("\n"); 
		query.append("              J.ACCT_YRMON, J.STL_VVD_SEQ, J.STL_SEQ, L.STL_CMB_SEQ," ).append("\n"); 
		query.append("              J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.UC_BSS_PORT_CD, J.IOC_CD, J.SCONTI_CD, J.FM_PORT_CD, V.FM_PORT_ETD_DT," ).append("\n"); 
		query.append("              J.JO_STL_ITM_CD, J.FNL_OWN_BSA_QTY, J.FNL_BSA_WGT, J.USD_SLT_BSA_QTY, J.USD_SLT_WGT, J.BSA_QTY, J.BSA_SLT_PRC, J.LOCL_CURR_CD" ).append("\n"); 
		query.append("       FROM   JOO_SETTLEMENT  J," ).append("\n"); 
		query.append("              JOO_STL_CMB_DTL K," ).append("\n"); 
		query.append("              JOO_STL_CMB     L," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.VPS_PORT_CD, X.SLAN_CD, " ).append("\n"); 
		query.append("                     MIN(TO_CHAR(X.VPS_ETD_DT, 'YYYYMMDDHH24MISS')) AS FM_PORT_ETD_DT" ).append("\n"); 
		query.append("              FROM   VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("              GROUP  BY X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.VPS_PORT_CD, X.SLAN_CD" ).append("\n"); 
		query.append("              ) V" ).append("\n"); 
		query.append("       WHERE  J.ACCT_YRMON   >= REPLACE(@[fm_acct_yrmon],'-','')" ).append("\n"); 
		query.append("       AND    J.ACCT_YRMON   <= REPLACE(@[to_acct_yrmon],'-','')" ).append("\n"); 
		query.append("       AND    J.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("       AND    J.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("       AND    J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("       AND    J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("       AND    J.JO_STL_ITM_CD = 'OUS'" ).append("\n"); 
		query.append("       AND    J.JO_MNU_NM     IN ('RDR', 'M/S')" ).append("\n"); 
		query.append("       AND   (CASE WHEN J.JO_MNU_NM = 'M/S' " ).append("\n"); 
		query.append("                   THEN ( SELECT JO_STL_TGT_TP_CD " ).append("\n"); 
		query.append("                            FROM JOO_STL_BSS_PORT P " ).append("\n"); 
		query.append("                           WHERE P.JO_CRR_CD     = J.JO_CRR_CD " ).append("\n"); 
		query.append("                             AND P.RLANE_CD      = J.RLANE_CD" ).append("\n"); 
		query.append("                             AND P.SKD_DIR_CD    = J.SKD_DIR_CD " ).append("\n"); 
		query.append("                             AND P.JO_STL_ITM_CD = J.JO_STL_ITM_CD)" ).append("\n"); 
		query.append("                   ELSE 'R' END) = 'R'" ).append("\n"); 
		query.append("       AND    J.IOC_CD        = 'O'" ).append("\n"); 
		query.append("       AND    J.ACCT_YRMON    = K.ACCT_YRMON " ).append("\n"); 
		query.append("       AND    J.STL_VVD_SEQ   = K.STL_VVD_SEQ" ).append("\n"); 
		query.append("       AND    J.STL_SEQ       = K.STL_SEQ    " ).append("\n"); 
		query.append("       AND    K.ACCT_YRMON    = L.ACCT_YRMON" ).append("\n"); 
		query.append("       AND    K.JO_CRR_CD     = L.JO_CRR_CD" ).append("\n"); 
		query.append("       AND    K.STL_CMB_SEQ   = L.STL_CMB_SEQ" ).append("\n"); 
		query.append("       AND    K.RE_DIVR_CD    = L.RE_DIVR_CD" ).append("\n"); 
		query.append("       AND    J.STL_LST_FLG   = 'Y'" ).append("\n"); 
		query.append("       AND    J.CMB_CFM_FLG   = 'Y'" ).append("\n"); 
		query.append("       AND    L.SLP_SER_NO    IS NOT NULL" ).append("\n"); 
		query.append("       AND    J.VSL_CD        = V.VSL_CD     (+)" ).append("\n"); 
		query.append("       AND    J.SKD_VOY_NO    = V.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("       AND    J.SKD_DIR_CD    = V.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("       AND    J.FM_PORT_CD    = V.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("       AND    SUBSTR(J.RLANE_CD,1,3) = V.SLAN_CD(+)       " ).append("\n"); 
		query.append("       ) J, " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT  H.VSL_CD, H.VOY_NO, H.DIR_CD, H.REGION, H.PORT_CD, " ).append("\n"); 
		query.append("               SUM(A.BSA_SLOT) AS TEU, " ).append("\n"); 
		query.append("               SUM(A.BSA_WGT ) AS WGT" ).append("\n"); 
		query.append("         FROM  RDR_HEADER H, " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT VSL_CD, VOY_NO, DIR_CD, REGION, BSA_SLOT, BSA_WGT" ).append("\n"); 
		query.append("                 FROM RDR_ALLOCATION" ).append("\n"); 
		query.append("                WHERE (OPR_CD, VSL_CD, VOY_NO, DIR_CD) IN (SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM JO_CRR)" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("        WHERE  H.VSL_CD  = A.VSL_CD(+)" ).append("\n"); 
		query.append("          AND  H.VOY_NO  = A.VOY_NO(+)" ).append("\n"); 
		query.append("          AND  H.DIR_CD  = A.DIR_CD(+)" ).append("\n"); 
		query.append("          AND  H.REGION  = A.REGION(+)" ).append("\n"); 
		query.append("        GROUP  BY H.VSL_CD, H.VOY_NO, H.DIR_CD, H.REGION, H.PORT_CD" ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("              CP.DIR_CD," ).append("\n"); 
		query.append("              CP.UC_AMT" ).append("\n"); 
		query.append("       FROM   BSA_OCN_OVR_SLT_PRC CP," ).append("\n"); 
		query.append("              BSA_OCN_OVR_MST     CM" ).append("\n"); 
		query.append("       WHERE CM.BSA_SLT_COST_TP_CD  = CP.BSA_SLT_COST_TP_CD" ).append("\n"); 
		query.append("       AND   CM.OVR_USD_SLT_PRC_SEQ = CP.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append("       AND   CM.TRD_CD              = CP.TRD_CD" ).append("\n"); 
		query.append("       AND   CM.RLANE_CD            = CP.RLANE_CD" ).append("\n"); 
		query.append("       AND   CM.DIR_CD              = CP.DIR_CD" ).append("\n"); 
		query.append("       AND   CP.BSA_SLT_COST_TP_CD  = '020'" ).append("\n"); 
		query.append("       AND   CP.CRR_CD              = @[jo_crr_cd]" ).append("\n"); 
		query.append("       AND   CP.TRD_CD              = @[trd_cd]" ).append("\n"); 
		query.append("       AND   CP.RLANE_CD            = @[rlane_cd]" ).append("\n"); 
		query.append("       AND   CM.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("       AND   CP.OVR_USD_SLT_PRC_SEQ = (" ).append("\n"); 
		query.append("                SELECT MAX(Y.OVR_USD_SLT_PRC_SEQ)" ).append("\n"); 
		query.append("                FROM   BSA_OCN_OVR_SLT_PRC Y," ).append("\n"); 
		query.append("                       BSA_OCN_OVR_MST     X" ).append("\n"); 
		query.append("                WHERE  X.BSA_SLT_COST_TP_CD  = Y.BSA_SLT_COST_TP_CD" ).append("\n"); 
		query.append("                AND    X.OVR_USD_SLT_PRC_SEQ = Y.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append("                AND    X.TRD_CD              = Y.TRD_CD" ).append("\n"); 
		query.append("                AND    X.RLANE_CD            = Y.RLANE_CD" ).append("\n"); 
		query.append("                AND    X.DIR_CD              = Y.DIR_CD" ).append("\n"); 
		query.append("                AND    X.BSA_SLT_COST_TP_CD  = CP.BSA_SLT_COST_TP_CD" ).append("\n"); 
		query.append("                AND    Y.CRR_CD              = CP.CRR_CD" ).append("\n"); 
		query.append("                AND    X.TRD_CD              = CP.TRD_CD" ).append("\n"); 
		query.append("                AND    X.RLANE_CD            = CP.RLANE_CD" ).append("\n"); 
		query.append("                AND    X.DIR_CD              = CP.DIR_CD" ).append("\n"); 
		query.append("                AND    X.DELT_FLG            ='N'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("       ) C,              " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("              U.VSL_CD, U.VOY_NO AS SKD_VOY_NO, H.PORT_CD, U.DIR_CD AS SKD_DIR_CD, H.REGION," ).append("\n"); 
		query.append("              SUM(U.SLOT_QTY) AS RDR_TEU, SUM(U.WEIGHT) AS RDR_WGT" ).append("\n"); 
		query.append("       FROM   RDR_HEADER H, " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT VSL_CD, VOY_NO, DIR_CD, REGION, SLOT_QTY, WEIGHT" ).append("\n"); 
		query.append("                 FROM RDR_UTILIZE U" ).append("\n"); 
		query.append("                WHERE (U.VSL_CD, U.VOY_NO, U.DIR_CD, U.OPR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, JO_CRR_CD FROM JO_CRR)" ).append("\n"); 
		query.append("                  AND TYPE <> 'R' /*Reefer 제외.*/" ).append("\n"); 
		query.append("               ) U" ).append("\n"); 
		query.append("       WHERE  H.VSL_CD  = U.VSL_CD(+)" ).append("\n"); 
		query.append("       AND    H.VOY_NO  = U.VOY_NO(+)" ).append("\n"); 
		query.append("       AND    H.DIR_CD  = U.DIR_CD(+)" ).append("\n"); 
		query.append("       AND    H.REGION  = U.REGION(+)" ).append("\n"); 
		query.append("       GROUP  BY U.VSL_CD, U.VOY_NO, H.PORT_CD, U.DIR_CD, H.REGION" ).append("\n"); 
		query.append("       ) R" ).append("\n"); 
		query.append("WHERE  1 = 1   " ).append("\n"); 
		query.append("AND    J.VSL_CD        = A.VSL_CD     (+)" ).append("\n"); 
		query.append("AND    J.SKD_VOY_NO    = A.VOY_NO     (+)" ).append("\n"); 
		query.append("AND    J.SKD_DIR_CD    = A.DIR_CD     (+)" ).append("\n"); 
		query.append("AND    J.SCONTI_CD     = A.REGION     (+)" ).append("\n"); 
		query.append("AND    J.FM_PORT_CD    = A.PORT_CD    (+)" ).append("\n"); 
		query.append("AND    J.SKD_DIR_CD    = C.DIR_CD     (+)    " ).append("\n"); 
		query.append("AND    J.VSL_CD        = R.VSL_CD     (+)" ).append("\n"); 
		query.append("AND    J.SKD_VOY_NO    = R.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND    J.SKD_DIR_CD    = R.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND    J.FM_PORT_CD    = R.PORT_CD    (+)" ).append("\n"); 
		query.append("AND    J.SCONTI_CD     = R.REGION     (+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE  DIFF_TEU <> 0" ).append("\n"); 
		query.append("OR     DIFF_WGT <> 0" ).append("\n"); 
		query.append("OR     USD_SLT_BSA_QTY <> RDR_TEU" ).append("\n"); 
		query.append("OR     USD_SLT_WGT     <> RDR_WGT" ).append("\n"); 
		query.append("OR     UC_AMT          <> BSA_SLT_PRC" ).append("\n"); 
		query.append("ORDER  BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 

	}
}