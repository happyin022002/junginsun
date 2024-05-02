/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchSADateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchSADateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchSADateRSQL
	  * 
	  * 2015.11.06 Sang-Hyun Kim [CHM-201538500] PDM Rev. Lane 귀속 로직 변경 관련 ACM 처리 요청
	  *  - Revenue Lane direct code 조회 쿼리 변경(AR_FINC_DIR_CONV 조회 쿼리 변경 - POD 조건 추가)
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchSADateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOSearchSADateRSQL").append("\n"); 
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
		query.append("SELECT 'OTS' AS SA_DT_DIV," ).append("\n"); 
		query.append("  DECODE(A.VSL_SEQ, 0, (SELECT NVL(MAX(C.VSL_SEQ), 0) + 1 FROM BKG_VVD C WHERE BKG_NO = A.BKG_NO AND VSL_PRE_PST_CD = 'S'), A.VSL_SEQ) AS VSL_SEQ," ).append("\n"); 
		query.append("  A.VSL_PRE_PST_CD AS VSL_PRE_PST_CD," ).append("\n"); 
		query.append("  NVL(A.VSL_CD, '*') AS VSL_CD," ).append("\n"); 
		query.append("  NVL(A.SKD_VOY_NO, '*') AS SKD_VOY_NO," ).append("\n"); 
		query.append("  NVL(A.SKD_DIR_CD, '*') AS SKD_DIR_CD," ).append("\n"); 
		query.append("  NVL(NVL(E.POD_RLANE_DIR_CD, E.RLANE_DIR_CD), A.SKD_DIR_CD) AS RLANE_DIR_CD," ).append("\n"); 
		query.append("  NVL(A.SLAN_CD, '*') AS SLAN_CD," ).append("\n"); 
		query.append("  NVL(A.POL_CD, '*') AS VSL_POL_CD," ).append("\n"); 
		query.append("  NVL(B.CONTI_CD, '*') AS OS_CONTI_CD," ).append("\n"); 
		query.append("  NVL(A.POD_CD, '*') AS VSL_POD_CD," ).append("\n"); 
		query.append("  DECODE(A.VSL_PRE_PST_CD, 'U', ACM_OFC_NEW_OLD_FNC(BB.FINC_CTRL_OFC_CD), ACM_OFC_NEW_OLD_FNC(B.FINC_CTRL_OFC_CD)) AS FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("  DECODE(A.VSL_PRE_PST_CD, 'U', GG.AR_OFC_CD, G.AR_OFC_CD) AS AR_OFC_CD," ).append("\n"); 
		query.append("  DECODE(C.VSL_SVC_TP_CD, 'O', 1, 0) AS PRE_FEEDER_CHECK," ).append("\n"); 
		query.append("  DECODE(D.VSL_SVC_TP_CD, 'O', 1, 0) AS POST_FEEDER_CHECK," ).append("\n"); 
		query.append("  '' RLANE_CD" ).append("\n"); 
		query.append("FROM BKG_VVD A," ).append("\n"); 
		query.append("  MDM_LOCATION B," ).append("\n"); 
		query.append("  MDM_LOCATION BB," ).append("\n"); 
		query.append("  MDM_VSL_SVC_LANE C," ).append("\n"); 
		query.append("  MDM_VSL_SVC_LANE D," ).append("\n"); 
		query.append("  AR_FINC_DIR_CONV E," ).append("\n"); 
		query.append("  MDM_ORGANIZATION G," ).append("\n"); 
		query.append("  MDM_ORGANIZATION GG" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.POD_CD = B.LOC_CD" ).append("\n"); 
		query.append("  AND A.POL_CD = BB.LOC_CD" ).append("\n"); 
		query.append("  AND A.SLAN_CD = C.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("  AND A.SLAN_CD = D.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("  AND A.SLAN_CD = E.SLAN_CD(+)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = E.SLAN_DIR_CD(+)" ).append("\n"); 
		query.append("  AND A.VSL_PRE_PST_CD IN ('S')" ).append("\n"); 
		query.append("  AND B.SCONTI_CD = NVL(E.SCONTI_CD, B.SCONTI_CD)" ).append("\n"); 
		query.append("  AND E.DIR_CNG_CD(+) = 'Y'" ).append("\n"); 
		query.append("  AND NVL(E.POD_CONTI_CD, '*') = CASE WHEN E.POD_CONTI_CD IS NULL THEN '*'" ).append("\n"); 
		query.append("                                      WHEN E.POD_CONTI_CD IS NOT NULL THEN BB.CONTI_CD" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("  AND ACM_OFC_NEW_OLD_FNC(B.FINC_CTRL_OFC_CD) = G.MODI_OFC_CD(+)" ).append("\n"); 
		query.append("  AND NVL(G.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND ACM_OFC_NEW_OLD_FNC(BB.FINC_CTRL_OFC_CD) = GG.MODI_OFC_CD(+)" ).append("\n"); 
		query.append("  AND NVL(GG.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'ITS' AS SA_DT_DIV," ).append("\n"); 
		query.append("  A.VSL_SEQ," ).append("\n"); 
		query.append("  A.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("  NVL(A.VSL_CD, '*') AS VSL_CD," ).append("\n"); 
		query.append("  NVL(A.SKD_VOY_NO, '*') AS SKD_VOY_NO," ).append("\n"); 
		query.append("  NVL(A.SKD_DIR_CD, '*') AS SKD_DIR_CD," ).append("\n"); 
		query.append("  NVL(NVL(E.POD_RLANE_DIR_CD, E.RLANE_DIR_CD), A.SKD_DIR_CD) AS RLANE_DIR_CD," ).append("\n"); 
		query.append("  NVL(A.SLAN_CD, '*') AS SLAN_CD," ).append("\n"); 
		query.append("  NVL(A.POL_CD, '*') AS VSL_POL_CD," ).append("\n"); 
		query.append("  NVL(B.CONTI_CD, '*') AS IS_CONTI_CD," ).append("\n"); 
		query.append("  NVL(A.POD_CD, '*') AS VSL_POD_CD," ).append("\n"); 
		query.append("  DECODE(A.VSL_PRE_PST_CD, 'U', ACM_OFC_NEW_OLD_FNC(B.FINC_CTRL_OFC_CD), ACM_OFC_NEW_OLD_FNC(BB.FINC_CTRL_OFC_CD)) AS FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("  DECODE(A.VSL_PRE_PST_CD, 'U', G.AR_OFC_CD, GG.AR_OFC_CD) AS AR_OFC_CD," ).append("\n"); 
		query.append("  DECODE(C.VSL_SVC_TP_CD, 'O', 1, 0) AS PRE_FEEDER_CHECK," ).append("\n"); 
		query.append("  DECODE(D.VSL_SVC_TP_CD, 'O', 1, 0) AS POST_FEEDER_CHECK," ).append("\n"); 
		query.append("  '' RLANE_CD" ).append("\n"); 
		query.append("FROM BKG_VVD A," ).append("\n"); 
		query.append("  MDM_LOCATION B," ).append("\n"); 
		query.append("  MDM_LOCATION BB," ).append("\n"); 
		query.append("  MDM_VSL_SVC_LANE C," ).append("\n"); 
		query.append("  MDM_VSL_SVC_LANE D," ).append("\n"); 
		query.append("  AR_FINC_DIR_CONV E," ).append("\n"); 
		query.append("  MDM_ORGANIZATION G," ).append("\n"); 
		query.append("  MDM_ORGANIZATION GG" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.POL_CD = B.LOC_CD" ).append("\n"); 
		query.append("  AND A.POD_CD = BB.LOC_CD" ).append("\n"); 
		query.append("  AND A.SLAN_CD = C.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("  AND A.SLAN_CD = D.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("  AND A.VSL_PRE_PST_CD IN ('U', 'T')" ).append("\n"); 
		query.append("  AND A.SLAN_CD = E.SLAN_CD(+)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = E.SLAN_DIR_CD(+)" ).append("\n"); 
		query.append("  AND B.SCONTI_CD = NVL(E.SCONTI_CD, B.SCONTI_CD)" ).append("\n"); 
		query.append("  AND E.DIR_CNG_CD(+) = 'Y'" ).append("\n"); 
		query.append("  AND NVL(E.POD_CONTI_CD, '*') = CASE WHEN E.POD_CONTI_CD IS NULL THEN '*'" ).append("\n"); 
		query.append("                                      WHEN E.POD_CONTI_CD IS NOT NULL THEN BB.CONTI_CD" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("  AND ACM_OFC_NEW_OLD_FNC(B.FINC_CTRL_OFC_CD) = G.MODI_OFC_CD(+)" ).append("\n"); 
		query.append("  AND NVL(G.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND ACM_OFC_NEW_OLD_FNC(BB.FINC_CTRL_OFC_CD) = GG.MODI_OFC_CD(+)" ).append("\n"); 
		query.append("  AND NVL(GG.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND A.VSL_SEQ != 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'TSA' AS SA_DT_DIV," ).append("\n"); 
		query.append("  A.VSL_SEQ," ).append("\n"); 
		query.append("  '' AS VSL_PRE_PST_CD," ).append("\n"); 
		query.append("  NVL(A.VSL_CD, '*') AS VSL_CD," ).append("\n"); 
		query.append("  NVL(A.SKD_VOY_NO, '*') AS SKD_VOY_NO," ).append("\n"); 
		query.append("  NVL(A.SKD_DIR_CD, '*') AS SKD_DIR_CD," ).append("\n"); 
		query.append("  NVL(NVL(E.POD_RLANE_DIR_CD, E.RLANE_DIR_CD), A.SKD_DIR_CD) AS RLANE_DIR_CD," ).append("\n"); 
		query.append("  NVL(A.SLAN_CD, '*') AS SLAN_CD," ).append("\n"); 
		query.append("  NVL(A.POL_CD, '*') AS VSL_POL_CD," ).append("\n"); 
		query.append("  '' AS IS_CONTI_CD," ).append("\n"); 
		query.append("  NVL(A.POD_CD, '*') AS VSL_POD_CD," ).append("\n"); 
		query.append("  '' AS FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("  '' AS AR_OFC_CD," ).append("\n"); 
		query.append("  0 AS PRE_FEEDER_CHECK," ).append("\n"); 
		query.append("  0 AS POST_FEEDER_CHECK," ).append("\n"); 
		query.append("  ACM_GET_TRNK_RLANE_FNC(A.BKG_NO) RLANE_CD" ).append("\n"); 
		query.append("FROM BKG_VVD A," ).append("\n"); 
		query.append("  MDM_LOCATION B," ).append("\n"); 
		query.append("  AR_FINC_DIR_CONV E" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("  AND A.POL_CD = B.LOC_CD" ).append("\n"); 
		query.append("  AND A.SLAN_CD = E.SLAN_CD(+)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = E.SLAN_DIR_CD(+)" ).append("\n"); 
		query.append("  AND B.SCONTI_CD = NVL(E.SCONTI_CD, B.SCONTI_CD)" ).append("\n"); 
		query.append("  AND E.DIR_CNG_CD(+) = 'Y'" ).append("\n"); 
		query.append("  AND NVL(E.POD_CONTI_CD, '*') = CASE WHEN E.POD_CONTI_CD IS NULL THEN '*'" ).append("\n"); 
		query.append("                                      WHEN E.POD_CONTI_CD IS NOT NULL THEN (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD)" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("ORDER BY VSL_PRE_PST_CD, VSL_SEQ" ).append("\n"); 

	}
}