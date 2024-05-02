/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchVIPDeductAgreementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOSearchVIPDeductAgreementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * - Booking 정보에 부합하는 VIP Agreement 조회
	  * - 2016.07.27 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA/TAA No. 추가 요청
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchVIPDeductAgreementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOSearchVIPDeductAgreementListRSQL").append("\n"); 
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
		query.append("WITH BKG_INFO AS (" ).append("\n"); 
		query.append("  SELECT MAS_RGST.TRD_CD," ).append("\n"); 
		query.append("    MAS_RGST.DIR_CD," ).append("\n"); 
		query.append("    MAS_RGST.HUL_BND_CD," ).append("\n"); 
		query.append("    MAS_RGST.SUB_TRD_CD," ).append("\n"); 
		query.append("    POR.CONTI_CD AS POR_CNTI," ).append("\n"); 
		query.append("    POR.SCONTI_CD AS POR_SCNTI," ).append("\n"); 
		query.append("    POR.CNT_CD AS POR_CNT," ).append("\n"); 
		query.append("    POR.RGN_CD AS POR_RGN_CD," ).append("\n"); 
		query.append("    POR.LOC_CD AS POR_CD," ).append("\n"); 
		query.append("    POL.CONTI_CD AS POL_CNTI," ).append("\n"); 
		query.append("    POL.SCONTI_CD AS POL_SCNTI," ).append("\n"); 
		query.append("    POL.CNT_CD AS POL_CNT," ).append("\n"); 
		query.append("    POL.RGN_CD AS POL_RGN_CD," ).append("\n"); 
		query.append("    POL.LOC_CD AS POL_CD," ).append("\n"); 
		query.append("    POD.CONTI_CD AS POD_CNTI," ).append("\n"); 
		query.append("    POD.SCONTI_CD AS POD_SCNTI," ).append("\n"); 
		query.append("    POD.CNT_CD AS POD_CNT," ).append("\n"); 
		query.append("    POD.RGN_CD AS POD_RGN_CD," ).append("\n"); 
		query.append("    POD.LOC_CD AS POD_CD," ).append("\n"); 
		query.append("    DEL.CONTI_CD AS DEL_CNTI," ).append("\n"); 
		query.append("    DEL.SCONTI_CD AS DEL_SCNTI," ).append("\n"); 
		query.append("    DEL.CNT_CD AS DEL_CNT," ).append("\n"); 
		query.append("    DEL.RGN_CD AS DEL_RGN_CD," ).append("\n"); 
		query.append("    DEL.LOC_CD AS DEL_CD," ).append("\n"); 
		query.append("    CASE WHEN BKG.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("           THEN (SELECT CUST.CUST_GRP_ID" ).append("\n"); 
		query.append("                 FROM PRI_RP_MN PRI," ).append("\n"); 
		query.append("                   MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("                 WHERE PRI.PROP_NO = (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = BKG.RFA_NO)" ).append("\n"); 
		query.append("                   AND BKG.BKG_CRE_DT BETWEEN PRI.EFF_DT AND PRI.EXP_DT" ).append("\n"); 
		query.append("                   AND CUST.CUST_CNT_CD = PRI.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND CUST.CUST_SEQ = PRI.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         WHEN BKG.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("           THEN (SELECT CUST.CUST_GRP_ID" ).append("\n"); 
		query.append("                 FROM PRI_SP_MN PRI," ).append("\n"); 
		query.append("                   MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("                 WHERE PRI.PROP_NO = (SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = BKG.SC_NO)" ).append("\n"); 
		query.append("                   AND BKG.BKG_CRE_DT BETWEEN PRI.EFF_DT AND PRI.EXP_DT" ).append("\n"); 
		query.append("                   AND CUST.CUST_CNT_CD = PRI.REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND CUST.CUST_SEQ = PRI.REAL_CUST_SEQ" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         WHEN BKG.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("           THEN (SELECT CUST.CUST_GRP_ID" ).append("\n"); 
		query.append("                 FROM PRI_TAA_MN PRI," ).append("\n"); 
		query.append("                   MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("                 WHERE PRI.TAA_PROP_NO = (SELECT TAA_PROP_NO FROM PRI_TAA_HDR WHERE TAA_NO = BKG.TAA_NO)" ).append("\n"); 
		query.append("                   AND BKG.BKG_CRE_DT BETWEEN PRI.EFF_DT AND PRI.EXP_DT" ).append("\n"); 
		query.append("                   AND CUST.CUST_CNT_CD = PRI.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND CUST.CUST_SEQ = PRI.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    END AS CUST_GRP_ID," ).append("\n"); 
		query.append("    BKG.SC_NO," ).append("\n"); 
		query.append("    BKG.RFA_NO," ).append("\n"); 
		query.append("    BKG.TAA_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("    MAS_RGST_BKG MAS_BKG," ).append("\n"); 
		query.append("    MAS_LANE_RGST MAS_RGST," ).append("\n"); 
		query.append("    MDM_LOCATION POR," ).append("\n"); 
		query.append("    MDM_LOCATION POL," ).append("\n"); 
		query.append("    MDM_LOCATION POD," ).append("\n"); 
		query.append("    MDM_LOCATION DEL" ).append("\n"); 
		query.append("  WHERE 1 = 1" ).append("\n"); 
		query.append("    AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND MAS_BKG.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("    AND MAS_BKG.RLANE_CD = MAS_RGST.RLANE_CD" ).append("\n"); 
		query.append("    AND MAS_BKG.DIR_CD = MAS_RGST.DIR_CD" ).append("\n"); 
		query.append("    AND MAS_BKG.TRD_CD = MAS_RGST.TRD_CD" ).append("\n"); 
		query.append("    AND MAS_BKG.IOC_CD = MAS_RGST.IOC_CD" ).append("\n"); 
		query.append("    AND POR.LOC_CD = BKG.POR_CD" ).append("\n"); 
		query.append("    AND POL.LOC_CD = BKG.POL_CD" ).append("\n"); 
		query.append("    AND POD.LOC_CD = BKG.POD_CD" ).append("\n"); 
		query.append("    AND DEL.LOC_CD = BKG.DEL_CD" ).append("\n"); 
		query.append("    AND POR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND POL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND POD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND DEL.DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT AGMT.CUST_GRP_ID," ).append("\n"); 
		query.append("  AGMT.AGMT_SEQ" ).append("\n"); 
		query.append("FROM ACM_VIP_AGMT AGMT," ).append("\n"); 
		query.append("  BKG_INFO BKG" ).append("\n"); 
		query.append("WHERE AGMT.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("  AND @[sa_dt] BETWEEN AGMT.FM_EFF_DT AND AGMT.TO_EFF_DT" ).append("\n"); 
		query.append("  AND AGMT.CUST_GRP_ID = BKG.CUST_GRP_ID" ).append("\n"); 
		query.append("  AND NVL(AGMT.TRD_CD, '*') = DECODE(NVL(AGMT.TRD_CD, '*'), '*', '*', BKG.TRD_CD)" ).append("\n"); 
		query.append("  AND NVL(AGMT.DIR_CD, '*') = DECODE(NVL(AGMT.DIR_CD, '*'), '*', '*', BKG.DIR_CD)" ).append("\n"); 
		query.append("  AND NVL(AGMT.HUL_BND_CD, '*') = DECODE(NVL(AGMT.HUL_BND_CD, '*'), '*', '*', BKG.HUL_BND_CD)" ).append("\n"); 
		query.append("  AND NVL(AGMT.SUB_TRD_CD, '*') = DECODE(NVL(AGMT.SUB_TRD_CD, '*'), '*', '*', BKG.SUB_TRD_CD)" ).append("\n"); 
		query.append("  AND NVL(AGMT.POR_ROUT_CD, '*') = CASE AGMT.POR_GRP_TP_CD WHEN '1' THEN POR_CNTI" ).append("\n"); 
		query.append("                                                           WHEN '2' THEN POR_SCNTI" ).append("\n"); 
		query.append("                                                           WHEN '3' THEN POR_CNT" ).append("\n"); 
		query.append("                                                           WHEN '4' THEN POR_RGN_CD" ).append("\n"); 
		query.append("                                                           WHEN '5' THEN POR_CD" ).append("\n"); 
		query.append("                                                           ELSE '*'" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("  AND NVL(AGMT.POL_ROUT_CD, '*') = CASE AGMT.POL_GRP_TP_CD WHEN '1' THEN POL_CNTI" ).append("\n"); 
		query.append("                                                           WHEN '2' THEN POL_SCNTI" ).append("\n"); 
		query.append("                                                           WHEN '3' THEN POL_CNT" ).append("\n"); 
		query.append("                                                           WHEN '4' THEN POL_RGN_CD" ).append("\n"); 
		query.append("                                                           WHEN '5' THEN POL_CD" ).append("\n"); 
		query.append("                                                           ELSE '*'" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("  AND NVL(AGMT.POD_ROUT_CD, '*') = CASE AGMT.POD_GRP_TP_CD WHEN '1' THEN POD_CNTI" ).append("\n"); 
		query.append("                                                           WHEN '2' THEN POD_SCNTI" ).append("\n"); 
		query.append("                                                           WHEN '3' THEN POD_CNT" ).append("\n"); 
		query.append("                                                           WHEN '4' THEN POD_RGN_CD" ).append("\n"); 
		query.append("                                                           WHEN '5' THEN POD_CD" ).append("\n"); 
		query.append("                                                           ELSE '*'" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("  AND NVL(AGMT.DEL_ROUT_CD, '*') = CASE AGMT.DEL_GRP_TP_CD WHEN '1' THEN DEL_CNTI" ).append("\n"); 
		query.append("                                                           WHEN '2' THEN DEL_SCNTI" ).append("\n"); 
		query.append("                                                           WHEN '3' THEN DEL_CNT" ).append("\n"); 
		query.append("                                                           WHEN '4' THEN DEL_RGN_CD" ).append("\n"); 
		query.append("                                                           WHEN '5' THEN DEL_CD" ).append("\n"); 
		query.append("                                                           ELSE '*'" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("  -- RFA_NO - SC_NO - TAA_NO 순으로 비교해서 조회(Booking data에 SC_NO, RFA_NO, TAA_NO가 동시에 입력 된 경우도 있음)." ).append("\n"); 
		query.append("  AND 1 = CASE WHEN NVL(AGMT.SC_NO, '*') = '*' AND NVL(AGMT.RFA_NO, '*') = '*' AND NVL(AGMT.TAA_NO, '*') = '*'" ).append("\n"); 
		query.append("                 THEN 1" ).append("\n"); 
		query.append("               WHEN NVL(AGMT.RFA_NO, '*') != '*' AND AGMT.RFA_NO = BKG.RFA_NO" ).append("\n"); 
		query.append("                 THEN 1" ).append("\n"); 
		query.append("               WHEN NVL(AGMT.SC_NO, '*') != '*' AND AGMT.SC_NO = BKG.SC_NO" ).append("\n"); 
		query.append("                 THEN 1" ).append("\n"); 
		query.append("               WHEN NVL(AGMT.TAA_NO, '*') != '*' AND AGMT.TAA_NO = BKG.TAA_NO" ).append("\n"); 
		query.append("                 THEN 1" ).append("\n"); 
		query.append("               ELSE 0" ).append("\n"); 
		query.append("          END" ).append("\n"); 

	}
}