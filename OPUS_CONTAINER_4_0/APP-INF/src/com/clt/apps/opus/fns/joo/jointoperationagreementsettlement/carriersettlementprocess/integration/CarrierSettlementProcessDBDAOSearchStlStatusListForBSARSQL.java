/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
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

public class CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL").append("\n"); 
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
		query.append("WITH AR_MST AS (" ).append("\n"); 
		query.append("        SELECT DISTINCT B.REV_YRMON" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.REV_DIR_CD" ).append("\n"); 
		query.append("             , A.RLANE_CD" ).append("\n"); 
		query.append("             , A.JO_CRR_CD" ).append("\n"); 
		query.append("             , A.TRD_CD " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT A.JO_CRR_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , A.TRD_CD " ).append("\n"); 
		query.append("                  FROM JOO_STL_VVD A" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                    --AND A.ACCT_YRMON BETWEEN REPLACE('2015-07','-','') AND REPLACE('2015-07','-','')" ).append("\n"); 
		query.append("                   AND A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("                   AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("               	   AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND (A.JO_CRR_CD, A.RLANE_CD) IN (" ).append("\n"); 
		query.append("                        SELECT C.JO_CRR_CD" ).append("\n"); 
		query.append("                             , C.RLANE_CD" ).append("\n"); 
		query.append("                          FROM JOO_CRR_AUTH C" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND C.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                           AND C.JO_CRR_AUTH_CD = DECODE(@[ofc_cd],(" ).append("\n"); 
		query.append("                                        SELECT OFC_CD" ).append("\n"); 
		query.append("                                          FROM TABLE (COM_OFFICECODEMGR_PKG.COM_GETOFFICECODELIST_FNC('000001','JOO'))" ).append("\n"); 
		query.append("                                         WHERE ROWNUM = 1),'W',C.JO_CRR_AUTH_CD) )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("              ) A" ).append("\n"); 
		query.append("             ,(SELECT V.*" ).append("\n"); 
		query.append("                  FROM AR_MST_REV_VVD V" ).append("\n"); 
		query.append("                 WHERE REV_YRMON BETWEEN REPLACE(@[acct_yrmon_fr],'-','') AND REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("              ) B" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("--SELECT * FROM AR_MST;" ).append("\n"); 
		query.append("SELECT A.REV_YRMON AS COST_YRMON" ).append("\n"); 
		query.append("     , A.JO_CRR_CD" ).append("\n"); 
		query.append("     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , B.BSA_R_AMT" ).append("\n"); 
		query.append("     , B.JOO_R_AMT" ).append("\n"); 
		query.append("     , B.DIFF_R_YN" ).append("\n"); 
		query.append("     , B.BSA_E_AMT" ).append("\n"); 
		query.append("     , B.JOO_E_AMT" ).append("\n"); 
		query.append("     , B.DIFF_E_YN" ).append("\n"); 
		query.append("  FROM AR_MST A" ).append("\n"); 
		query.append("     , (SELECT" ).append("\n"); 
		query.append("               NVL(JOO.REV_YRMON, COA.REV_YRMON) AS COST_YRMON" ).append("\n"); 
		query.append("             , NVL(JOO.JO_CRR_CD, COA.JO_CRR_CD) AS JO_CRR_CD" ).append("\n"); 
		query.append("             , NVL(JOO.VSL_CD ,COA.VSL_CD ) AS VSL_CD" ).append("\n"); 
		query.append("             , NVL(JOO.SKD_VOY_NO,COA.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , NVL(JOO.SKD_DIR_CD,COA.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , NVL(JOO.REV_DIR_CD,COA.REV_DIR_CD) AS REV_DIR_CD" ).append("\n"); 
		query.append("             , NVL(JOO.TRD_CD, COA.TRD_CD) AS TRD_CD" ).append("\n"); 
		query.append("             , NVL(JOO.RLANE_CD, COA.RLANE_CD) AS RLANE_CD" ).append("\n"); 
		query.append("             , NVL(SUM(COA.BSA_R_AMT),0) AS BSA_R_AMT" ).append("\n"); 
		query.append("             , NVL(SUM(JOO.JOO_R_AMT),0) AS JOO_R_AMT" ).append("\n"); 
		query.append("             , CASE WHEN NVL(SUM(COA.BSA_R_AMT),0) <> NVL(SUM(JOO.JOO_R_AMT),0) THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END DIFF_R_YN" ).append("\n"); 
		query.append("             , NVL(SUM(COA.BSA_E_AMT),0) AS BSA_E_AMT" ).append("\n"); 
		query.append("             , NVL(SUM(JOO.JOO_E_AMT),0) AS JOO_E_AMT" ).append("\n"); 
		query.append("             , CASE WHEN NVL(SUM(COA.BSA_E_AMT),0) <> NVL(SUM(JOO.JOO_E_AMT),0) THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END DIFF_E_YN" ).append("\n"); 
		query.append("          FROM (SELECT A.REV_YRMON" ).append("\n"); 
		query.append("                     , B.CRR_CD AS JO_CRR_CD" ).append("\n"); 
		query.append("                     , B.TRD_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , SUM(CASE WHEN B.BSA_OP_JB_CD IN ('001','002','004') THEN B.CRR_PERF_AMT" ).append("\n"); 
		query.append("                                ELSE 0" ).append("\n"); 
		query.append("                           END) AS BSA_R_AMT" ).append("\n"); 
		query.append("                     , SUM(CASE WHEN B.BSA_OP_JB_CD IN ('000','003','005') THEN B.CRR_PERF_AMT" ).append("\n"); 
		query.append("                                ELSE 0" ).append("\n"); 
		query.append("                           END) AS BSA_E_AMT" ).append("\n"); 
		query.append("                     , 'S/H' AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("                  FROM AR_MST A" ).append("\n"); 
		query.append("                     , BSA_VVD_CRR_PERF B" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = B.CRR_CD" ).append("\n"); 
		query.append("                   AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND (B.CRR_CD, B.RLANE_CD) IN (" ).append("\n"); 
		query.append("                        SELECT C.JO_CRR_CD" ).append("\n"); 
		query.append("                             , C.RLANE_CD" ).append("\n"); 
		query.append("                          FROM JOO_CRR_AUTH C" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND C.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                           AND C.JO_CRR_AUTH_CD = DECODE(@[ofc_cd],(" ).append("\n"); 
		query.append("                                        SELECT OFC_CD" ).append("\n"); 
		query.append("                                          FROM TABLE (COM_OFFICECODEMGR_PKG.COM_GETOFFICECODELIST_FNC('000001','JOO'))" ).append("\n"); 
		query.append("                                         WHERE ROWNUM = 1),'W',C.JO_CRR_AUTH_CD) " ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND B.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("              	   AND B.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                   AND B.CRR_PERF_AMT <> 0" ).append("\n"); 
		query.append("                 GROUP BY A.REV_YRMON" ).append("\n"); 
		query.append("                     , B.CRR_CD" ).append("\n"); 
		query.append("                     , B.TRD_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD " ).append("\n"); 
		query.append("                /*2015.07.07 NYK Add OPR */" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT A.REV_YRMON" ).append("\n"); 
		query.append("                     , B.CRR_CD AS JO_CRR_CD" ).append("\n"); 
		query.append("                     , B.TRD_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , SUM(CASE WHEN B.BSA_OP_JB_CD IN ('001','002','004') THEN B.OP_CRR_PERF_AMT" ).append("\n"); 
		query.append("                                ELSE 0" ).append("\n"); 
		query.append("                           END) AS BSA_R_AMT" ).append("\n"); 
		query.append("                     , SUM(CASE WHEN B.BSA_OP_JB_CD IN ('000','003','005') THEN B.OP_CRR_PERF_AMT" ).append("\n"); 
		query.append("                                ELSE 0" ).append("\n"); 
		query.append("                           END) AS BSA_E_AMT" ).append("\n"); 
		query.append("                     , 'OPR' AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("                  FROM AR_MST A" ).append("\n"); 
		query.append("                     , BSA_VVD_CRR_PERF B" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = B.CRR_CD" ).append("\n"); 
		query.append("                   AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND (B.CRR_CD, B.RLANE_CD) IN (" ).append("\n"); 
		query.append("                        SELECT C.JO_CRR_CD" ).append("\n"); 
		query.append("                             , C.RLANE_CD" ).append("\n"); 
		query.append("                          FROM JOO_CRR_AUTH C" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND C.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                           AND C.JO_CRR_AUTH_CD = DECODE(@[ofc_cd],(" ).append("\n"); 
		query.append("                                        SELECT OFC_CD" ).append("\n"); 
		query.append("                                          FROM TABLE (COM_OFFICECODEMGR_PKG.COM_GETOFFICECODELIST_FNC('000001','JOO'))" ).append("\n"); 
		query.append("                                         WHERE ROWNUM = 1),'W',C.JO_CRR_AUTH_CD) " ).append("\n"); 
		query.append("				   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND B.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("              	   AND B.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND B.CRR_PERF_AMT <> 0" ).append("\n"); 
		query.append("                 GROUP BY A.REV_YRMON" ).append("\n"); 
		query.append("                     , B.CRR_CD" ).append("\n"); 
		query.append("                     , B.TRD_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD " ).append("\n"); 
		query.append("                ) COA FULL OUTER JOIN " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT A.REV_YRMON" ).append("\n"); 
		query.append("                     , J.JO_CRR_CD" ).append("\n"); 
		query.append("                     , J.TRD_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , J.JOO_R_AMT" ).append("\n"); 
		query.append("                     , J.JOO_E_AMT" ).append("\n"); 
		query.append("                     , J.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                  FROM AR_MST A, (" ).append("\n"); 
		query.append("                        SELECT J.JO_CRR_CD" ).append("\n"); 
		query.append("                             , J.TRD_CD" ).append("\n"); 
		query.append("                             , J.RLANE_CD" ).append("\n"); 
		query.append("                             , J.VSL_CD" ).append("\n"); 
		query.append("                             , J.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , J.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , J.REV_DIR_CD" ).append("\n"); 
		query.append("                             , SUM(DECODE(J.RE_DIVR_CD,'R',DECODE(J.LOCL_CURR_CD,'USD',J.STL_LOCL_AMT ,(ROUND(PSO_CONV_CURR_USD_FNC(J.LOCL_CURR_CD, NVL(J.STL_LOCL_AMT,0) ,(" ).append("\n"); 
		query.append("                                                                                SELECT MAX(V.REV_YRMON)" ).append("\n"); 
		query.append("                                                                                  FROM AR_MST_REV_VVD V" ).append("\n"); 
		query.append("                                                                                 WHERE V.VSL_CD = J.VSL_CD" ).append("\n"); 
		query.append("                                                                                   AND V.SKD_VOY_NO = J.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                   AND V.SKD_DIR_CD = J.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                   AND V.RLANE_CD = J.RLANE_CD),1),3))),0)) AS JOO_R_AMT" ).append("\n"); 
		query.append("                             , SUM(DECODE(J.RE_DIVR_CD,'E',DECODE(J.LOCL_CURR_CD,'USD',J.STL_LOCL_AMT ,(ROUND(PSO_CONV_CURR_USD_FNC(J.LOCL_CURR_CD, NVL(J.STL_LOCL_AMT,0) ,(" ).append("\n"); 
		query.append("                                                                                SELECT MAX(V.REV_YRMON)" ).append("\n"); 
		query.append("                                                                                  FROM AR_MST_REV_VVD V" ).append("\n"); 
		query.append("                                                                                 WHERE V.VSL_CD = J.VSL_CD" ).append("\n"); 
		query.append("                                                                                   AND V.SKD_VOY_NO = J.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                   AND V.SKD_DIR_CD = J.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                   AND V.RLANE_CD = J.RLANE_CD),1),3))),0)) AS JOO_E_AMT" ).append("\n"); 
		query.append("                             , J.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                          FROM JOO_SETTLEMENT J" ).append("\n"); 
		query.append("                             , JOO_STL_CMB_DTL D" ).append("\n"); 
		query.append("                             , JOO_STL_CMB C" ).append("\n"); 
		query.append("                             , COM_USER U" ).append("\n"); 
		query.append("                         WHERE J.ACCT_YRMON = D.ACCT_YRMON" ).append("\n"); 
		query.append("                           AND J.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("                           AND J.STL_SEQ = D.STL_SEQ" ).append("\n"); 
		query.append("                           AND D.ACCT_YRMON = C.ACCT_YRMON" ).append("\n"); 
		query.append("                           AND D.JO_CRR_CD = C.JO_CRR_CD" ).append("\n"); 
		query.append("                           AND D.STL_CMB_SEQ = C.STL_CMB_SEQ" ).append("\n"); 
		query.append("                           AND D.RE_DIVR_CD = C.RE_DIVR_CD" ).append("\n"); 
		query.append("                           AND J.CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND J.JO_STL_ITM_CD IN ( 'S/H', 'OPR')" ).append("\n"); 
		query.append("                           AND J.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                           AND J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                           AND NVL(C.RVS_CMB_FLG ,'N') = 'N'" ).append("\n"); 
		query.append("                           AND NVL(C.RJCT_CMB_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND J.STL_LOCL_AMT <> 0" ).append("\n"); 
		query.append("                           AND C.CRE_USR_ID = U.USR_ID(+)" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND NVL(C.SLP_OFC_CD, NVL(U.LST_LGIN_OFC_CD,U.OFC_CD)) = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY J.JO_CRR_CD" ).append("\n"); 
		query.append("                             , J.TRD_CD" ).append("\n"); 
		query.append("                             , J.RLANE_CD" ).append("\n"); 
		query.append("                             , J.VSL_CD" ).append("\n"); 
		query.append("                             , J.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , J.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , J.REV_DIR_CD" ).append("\n"); 
		query.append("                             , J.JO_STL_ITM_CD ) J" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = J.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = J.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = J.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND A.REV_DIR_CD = J.REV_DIR_CD" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = J.JO_CRR_CD" ).append("\n"); 
		query.append("                   AND A.TRD_CD = J.TRD_CD" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND (J.JO_CRR_CD, J.RLANE_CD) IN (" ).append("\n"); 
		query.append("                        SELECT C.JO_CRR_CD" ).append("\n"); 
		query.append("                             , C.RLANE_CD" ).append("\n"); 
		query.append("                          FROM JOO_CRR_AUTH C" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND C.AUTH_OFC_CD =  @[ofc_cd]" ).append("\n"); 
		query.append("                           AND C.JO_CRR_AUTH_CD = DECODE( @[ofc_cd],(" ).append("\n"); 
		query.append("                                        SELECT OFC_CD" ).append("\n"); 
		query.append("                                          FROM TABLE (COM_OFFICECODEMGR_PKG.COM_GETOFFICECODELIST_FNC('000001','JOO'))" ).append("\n"); 
		query.append("                                         WHERE ROWNUM = 1),'W',C.JO_CRR_AUTH_CD) " ).append("\n"); 
		query.append("					   ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) JOO " ).append("\n"); 
		query.append("                   ON (COA.VSL_CD       = JOO.VSL_CD" ).append("\n"); 
		query.append("                   AND COA.SKD_VOY_NO   = JOO.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND COA.SKD_DIR_CD   = JOO.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND COA.REV_DIR_CD   = JOO.REV_DIR_CD" ).append("\n"); 
		query.append("                   AND COA.JO_CRR_CD    = JOO.JO_CRR_CD" ).append("\n"); 
		query.append("                   AND COA.TRD_CD       = JOO.TRD_CD" ).append("\n"); 
		query.append("                   AND COA.RLANE_CD     = JOO.RLANE_CD" ).append("\n"); 
		query.append("                   AND COA.JO_STL_ITM_CD= JOO.JO_STL_ITM_CD )" ).append("\n"); 
		query.append("         GROUP BY NVL(JOO.REV_YRMON, COA.REV_YRMON)" ).append("\n"); 
		query.append("             , NVL(JOO.JO_CRR_CD, COA.JO_CRR_CD)" ).append("\n"); 
		query.append("             , NVL(JOO.VSL_CD, COA.VSL_CD)" ).append("\n"); 
		query.append("             , NVL(JOO.SKD_VOY_NO, COA.SKD_VOY_NO)" ).append("\n"); 
		query.append("             , NVL(JOO.SKD_DIR_CD, COA.SKD_DIR_CD)" ).append("\n"); 
		query.append("             , NVL(JOO.REV_DIR_CD, COA.REV_DIR_CD)" ).append("\n"); 
		query.append("             , NVL(JOO.TRD_CD, COA.TRD_CD)" ).append("\n"); 
		query.append("             , NVL(JOO.RLANE_CD, COA.RLANE_CD) " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.REV_YRMON  = B.COST_YRMON(+)" ).append("\n"); 
		query.append("   AND A.VSL_CD     = B.VSL_CD (+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.REV_DIR_CD = B.REV_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.RLANE_CD   = B.RLANE_CD (+)" ).append("\n"); 
		query.append(" ORDER BY 6, 1, 2, 3, 4, 5" ).append("\n"); 

	}
}