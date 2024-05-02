/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
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

public class CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL").append("\n"); 
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
		query.append("SELECT A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (ORDER BY ORD)||'. '||T.JO_STL_ITM_NM AS JO_STL_ITM_CD_NM" ).append("\n"); 
		query.append("     , A1.RLANE_CD" ).append("\n"); 
		query.append("     , A1.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , A1.R_VVD" ).append("\n"); 
		query.append("     , DECODE(A1.R_BSA_QTY, 0, NULL, A1.R_BSA_QTY) AS R_BSA_QTY" ).append("\n"); 
		query.append("     , DECODE(A1.R_BSA_SLT_PRC, 0, NULL, A1.R_BSA_SLT_PRC) AS R_BSA_SLT_PRC" ).append("\n"); 
		query.append("     , A1.R_STL_LOCL_AMT" ).append("\n"); 
		query.append("     , A1.E_VVD" ).append("\n"); 
		query.append("     , DECODE(A1.E_BSA_QTY, 0, NULL, A1.E_BSA_QTY) AS E_BSA_QTY" ).append("\n"); 
		query.append("     , DECODE(A1.E_BSA_SLT_PRC, 0, NULL, A1.E_BSA_SLT_PRC) AS E_BSA_SLT_PRC" ).append("\n"); 
		query.append("     , A1.E_STL_LOCL_AMT" ).append("\n"); 
		query.append("     , CASE WHEN A1.JO_STL_ITM_CD='S/H' OR A1.JO_STL_ITM_CD ='OPR' THEN '['||A1.PRE_STL_RMK||'] '||A1.STL_RMK " ).append("\n"); 
		query.append("            ELSE A1.STL_RMK " ).append("\n"); 
		query.append("       END AS STL_RMK" ).append("\n"); 
		query.append("     , A1.ORD_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , A1.RLANE_CD" ).append("\n"); 
		query.append("             , A1.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , A1.R_VVD" ).append("\n"); 
		query.append("             , A1.R_BSA_QTY" ).append("\n"); 
		query.append("             , A1.R_BSA_SLT_PRC" ).append("\n"); 
		query.append("             , A1.R_STL_LOCL_AMT" ).append("\n"); 
		query.append("             , A1.E_VVD" ).append("\n"); 
		query.append("             , A1.E_BSA_QTY" ).append("\n"); 
		query.append("             , A1.E_BSA_SLT_PRC" ).append("\n"); 
		query.append("             , A1.E_STL_LOCL_AMT" ).append("\n"); 
		query.append("             , SUBSTR(DECODE(A1.STL_RMK,NULL,NULL,','||A1.STL_RMK)|| DECODE(A1.SAIL_DYS,NULL,NULL,',Sail Days:'||A1.SAIL_DYS), 2) AS STL_RMK" ).append("\n"); 
		query.append("             , A1.PRE_STL_RMK" ).append("\n"); 
		query.append("             , A1.ORD_SEQ" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT DECODE(A1.JO_STL_ITM_CD,'OPR','S/H',A1.JO_STL_ITM_CD) AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , A1.RLANE_CD" ).append("\n"); 
		query.append("                     , A1.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , A1.R_VVD" ).append("\n"); 
		query.append("                     , SUM(A1.R_BSA_QTY)R_BSA_QTY" ).append("\n"); 
		query.append("                     , A1.R_BSA_SLT_PRC" ).append("\n"); 
		query.append("                     , SUM(A1.R_STL_LOCL_AMT)R_STL_LOCL_AMT" ).append("\n"); 
		query.append("                     , A1.E_VVD" ).append("\n"); 
		query.append("                     , SUM(A1.E_BSA_QTY)E_BSA_QTY" ).append("\n"); 
		query.append("                     , A1.E_BSA_SLT_PRC" ).append("\n"); 
		query.append("                     , SUM(A1.E_STL_LOCL_AMT)E_STL_LOCL_AMT" ).append("\n"); 
		query.append("                     , CASE WHEN A1.R_VVD IS NOT NULL THEN CASE WHEN SUM(A1.SAIL_DYS) > 0 THEN TO_CHAR(ROUND(SUM(A1.R_STL_LOCL_AMT)/(SUM(A1.R_BSA_QTY)*A1.R_BSA_SLT_PRC), 3) ,'FM999,990.999') ELSE NULL END" ).append("\n"); 
		query.append("                            WHEN A1.R_VVD IS NOT NULL THEN CASE WHEN SUM(A1.SAIL_DYS) > 0 THEN TO_CHAR(ROUND(SUM(A1.E_STL_LOCL_AMT)/(SUM(A1.E_BSA_QTY)*A1.E_BSA_SLT_PRC), 3) ,'FM999,990.999') ELSE NULL END" ).append("\n"); 
		query.append("                            ELSE NULL" ).append("\n"); 
		query.append("                       END AS SAIL_DYS" ).append("\n"); 
		query.append("                     , A1.STL_RMK" ).append("\n"); 
		query.append("                     , A1.PRE_STL_RMK" ).append("\n"); 
		query.append("                     , A1.ORD_SEQ" ).append("\n"); 
		query.append("                  FROM (SELECT A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                             , A.RLANE_CD" ).append("\n"); 
		query.append("                             , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                             , A.RE_DIVR_CD" ).append("\n"); 
		query.append("                             , DECODE(A.RE_DIVR_CD,'R',A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,'') AS R_VVD" ).append("\n"); 
		query.append("                             , DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY,    CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.USD_SLT_BSA_QTY ELSE A.BSA_QTY END)) AS R_BSA_QTY" ).append("\n"); 
		query.append("                             , DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.RF_SCG_PRC ELSE A.BSA_SLT_PRC END)) AS R_BSA_SLT_PRC" ).append("\n"); 
		query.append("                             , DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT)) AS R_STL_LOCL_AMT" ).append("\n"); 
		query.append("                             , DECODE(A.RE_DIVR_CD,'E',A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,'') AS E_VVD" ).append("\n"); 
		query.append("                             , DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY,    CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.USD_SLT_BSA_QTY ELSE A.BSA_QTY END)) AS E_BSA_QTY" ).append("\n"); 
		query.append("                             , DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.RF_SCG_PRC ELSE A.BSA_SLT_PRC END)) AS E_BSA_SLT_PRC" ).append("\n"); 
		query.append("                             , DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT)) AS E_STL_LOCL_AMT" ).append("\n"); 
		query.append("                             , SUBSTR(DECODE(A.STL_RMK,NULL,NULL,','||A.STL_RMK)||DECODE(A.FM_PORT_CD,NULL,NULL,DECODE(A.JO_MNU_NM,'RDR',DECODE(A.TO_PORT_CD, NULL,',RDR Port:'||A.FM_PORT_CD,','||A.FM_PORT_CD||'-'||A.TO_PORT_CD), ','||A.FM_PORT_CD||DECODE(A.TO_PORT_CD,NULL,NULL,'-'||A.TO_PORT_CD))) || DECODE(A.SAIL_DYS,NULL,NULL,',Sail Days:'||A.SAIL_DYS), 2) AS STL_RMK" ).append("\n"); 
		query.append("                             , A.SAIL_DYS" ).append("\n"); 
		query.append("                             , C.JO_STL_ITM_NM AS PRE_STL_RMK" ).append("\n"); 
		query.append("                             , C.ORD_SEQ" ).append("\n"); 
		query.append("                          FROM JOO_SETTLEMENT A" ).append("\n"); 
		query.append("                             , JOO_STL_DTL B" ).append("\n"); 
		query.append("                             , JOO_CRR_AUTH Z" ).append("\n"); 
		query.append("                             , JOO_STL_ITM C" ).append("\n"); 
		query.append("                         WHERE A.ACCT_YRMON = B.ACCT_YRMON(+)" ).append("\n"); 
		query.append("                           AND A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("                           AND A.STL_SEQ = B.STL_SEQ(+)" ).append("\n"); 
		query.append("                           AND A.JO_CRR_CD = Z.JO_CRR_CD" ).append("\n"); 
		query.append("                           AND A.RLANE_CD = Z.RLANE_CD" ).append("\n"); 
		query.append("                           AND Z.AUTH_OFC_CD =  @[ofc_cd]" ).append("\n"); 
		query.append("                           AND Z.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND Z.JO_CRR_AUTH_CD = 'W'" ).append("\n"); 
		query.append("                           AND A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-')" ).append("\n"); 
		query.append("                           AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("           		#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("           				   AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("           		#end" ).append("\n"); 
		query.append("           		#if (${stl_cmb_seq} != '')" ).append("\n"); 
		query.append("                           AND (A.ACCT_YRMON, A.STL_VVD_SEQ, A.STL_SEQ) IN (SELECT CMB.ACCT_YRMON" ).append("\n"); 
		query.append("                                                                         , CMB.STL_VVD_SEQ" ).append("\n"); 
		query.append("                                                                         , CMB.STL_SEQ" ).append("\n"); 
		query.append("                                                                      FROM JOO_STL_CMB_DTL CMB" ).append("\n"); 
		query.append("                                                                     WHERE CMB.ACCT_YRMON = REPLACE(@[acct_yrmon],'-')" ).append("\n"); 
		query.append("                                                                       AND CMB.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("                                                                       AND CMB.STL_CMB_SEQ = @[stl_cmb_seq] )" ).append("\n"); 
		query.append("                   			AND A.CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("           		#else" ).append("\n"); 
		query.append("				   			AND NVL(A.CMB_CFM_FLG,'N') = 'N' " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                           AND A.JO_STL_ITM_CD = C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                       )A1" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                 GROUP BY A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , A1.RLANE_CD" ).append("\n"); 
		query.append("                     , A1.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , A1.R_VVD" ).append("\n"); 
		query.append("                     , A1.R_BSA_SLT_PRC" ).append("\n"); 
		query.append("                     , A1.E_VVD" ).append("\n"); 
		query.append("                     , A1.E_BSA_SLT_PRC" ).append("\n"); 
		query.append("                     , A1.STL_RMK" ).append("\n"); 
		query.append("                     , A1.PRE_STL_RMK" ).append("\n"); 
		query.append("                     , A1.ORD_SEQ" ).append("\n"); 
		query.append("                HAVING (SUM(A1.R_STL_LOCL_AMT) != 0 OR SUM(A1.E_STL_LOCL_AMT) != 0)" ).append("\n"); 
		query.append("                ) A1           " ).append("\n"); 
		query.append("        ) A1" ).append("\n"); 
		query.append("     , (SELECT ORD_SEQ AS ORD" ).append("\n"); 
		query.append("             , JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , JO_STL_ITM_NM" ).append("\n"); 
		query.append("          FROM JOO_STL_ITM) T" ).append("\n"); 
		query.append(" WHERE T.JO_STL_ITM_CD = A1.JO_STL_ITM_CD                " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append(" ORDER BY T.ORD" ).append("\n"); 
		query.append("     , A1.RLANE_CD" ).append("\n"); 
		query.append("     , A1.R_VVD" ).append("\n"); 
		query.append("     , A1.E_VVD" ).append("\n"); 
		query.append("     , A1.ORD_SEQ" ).append("\n"); 

	}
}