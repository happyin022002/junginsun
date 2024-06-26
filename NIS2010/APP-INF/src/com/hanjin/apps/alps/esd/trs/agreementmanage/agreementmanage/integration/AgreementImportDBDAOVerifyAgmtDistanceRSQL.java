/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementImportDBDAOVerifyAgmtDistanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOVerifyAgmtDistanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Distance Type data Verify 수행
	  * </pre>
	  */
	public AgreementImportDBDAOVerifyAgmtDistanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOVerifyAgmtDistanceRSQL").append("\n"); 
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
		query.append("SELECT SR" ).append("\n"); 
		query.append("      ,SUBSTR(MAX(RULE_CHK)" ).append("\n"); 
		query.append("       || CASE WHEN MIN(ALL_CHK) <> MAX(ALL_CHK) THEN ',TPSZ DUP ERR' END" ).append("\n"); 
		query.append("       || MAX(UI_DUP),2) RMK --UI에 동일한 자료가 있는지 체크" ).append("\n"); 
		query.append("      ,DECODE(RT_UPD_STS_CD, 'I', MAX(DB_DUP), '') RMK2 --DB에 동일한 자료가 있는지 체크" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT -- Effective date CHECK" ).append("\n"); 
		query.append("               CASE WHEN T.EFF_TO_DT IS NULL" ).append("\n"); 
		query.append("                      OR T.EFF_FM_DT IS NULL" ).append("\n"); 
		query.append("                      OR T.EFF_TO_DT - T.EFF_FM_DT < 0" ).append("\n"); 
		query.append("                    THEN ',EF DATE ER'" ).append("\n"); 
		query.append("               END " ).append("\n"); 
		query.append("               || -- Customer code CHECK" ).append("\n"); 
		query.append("               CASE WHEN T.CUST_CNT_CD <> 'XX'" ).append("\n"); 
		query.append("                     AND" ).append("\n"); 
		query.append("                        (SELECT 1" ).append("\n"); 
		query.append("                           FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND M.CUST_CNT_CD   = T.CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND M.CUST_SEQ      = T.CUST_SEQ" ).append("\n"); 
		query.append("                            AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("                        ) IS NULL " ).append("\n"); 
		query.append("                    THEN ',CUST ERR'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("               || -- Commodity group code CHECK" ).append("\n"); 
		query.append("               CASE WHEN T.CMDT_GRP_CD <> 'XXXX'" ).append("\n"); 
		query.append("                     AND" ).append("\n"); 
		query.append("                        (SELECT 1" ).append("\n"); 
		query.append("                           FROM TRS_TRSP_CMDT_GRP C" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND C.TRSP_GRP_CMDT_CD = T.CMDT_GRP_CD" ).append("\n"); 
		query.append("                            AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("                        ) IS NULL " ).append("\n"); 
		query.append("                    THEN ',CMDT GRP ERR'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("               || -- REVERSE CHECK" ).append("\n"); 
		query.append("               CASE WHEN T.TRSP_RVS_APLY_FLG = 'Y'" ).append("\n"); 
		query.append("                    THEN ',REVERSE FLAG ERR'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("               || -- WEIGHT CHECK" ).append("\n"); 
		query.append("               CASE WHEN T.CGO_TP_CD = 'F' AND (T.TO_WGT IS NULL OR T.TO_WGT = 0) THEN ',WGT CHK' END" ).append("\n"); 
		query.append("               || -- RE-CHK AGMT TYPE" ).append("\n"); 
		query.append("               CASE WHEN T.FM_NOD_CD IS NOT NULL AND T.TRSP_AGMT_DIST != 0 THEN ',RE-CHK AGMT TYPE' END" ).append("\n"); 
		query.append("			   || -- EF DATE ER" ).append("\n"); 
		query.append("	    	   CASE WHEN " ).append("\n"); 
		query.append("		   			(SELECT 1" ).append("\n"); 
		query.append("		    		 FROM TRS_AGMT_TMP T" ).append("\n"); 
		query.append("		    		 WHERE 1=1 " ).append("\n"); 
		query.append("					 AND TRS_COMMON_PKG.IS_DATE_FNC(T.EFF_FM_DT) = 0" ).append("\n"); 
		query.append("		    		 AND TRS_COMMON_PKG.IS_DATE_FNC(T.EFF_TO_DT) = 0	" ).append("\n"); 
		query.append("					 AND ROWNUM = 1" ).append("\n"); 
		query.append("	           		) IS NULL THEN ',EF DATE ER'" ).append("\n"); 
		query.append("			   END" ).append("\n"); 
		query.append("               || -- RULE-A CHECK" ).append("\n"); 
		query.append("               CASE WHEN" ).append("\n"); 
		query.append("                   (SELECT 1" ).append("\n"); 
		query.append("                      FROM TRS_AGMT_EQ_TP_RULE            H" ).append("\n"); 
		query.append("                     WHERE TRSP_AGMT_RULE_TP_CD                = 'D'" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_STEP_KNT                  = 1" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_TP_CD                     = T.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                       AND TRSP_MOD_CD                         = T.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                       AND NVL(TO_DIST_COND_CD, 'N/A')         = DECODE(T.TRSP_AGMT_DIST, 0, 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND NVL(FX_PER_DIST_COND_CD, 'N/A')     = DECODE(T.TRSP_DIST_TP_CD, 'X', 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND NVL(DIST_UT_COND_CD, 'N/A')         = DECODE(T.DIST_MEAS_UT_CD, 'XX', 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND NVL(RCV_COND_CD, 'N/A')             = DECODE(T.WTR_RCV_TERM_CD, '0', 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND NVL(DE_COND_CD, 'N/A')              = DECODE(T.WTR_DE_TERM_CD, '0', 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND ROWNUM                              = 1" ).append("\n"); 
		query.append("                   ) IS NULL THEN ',RULE-A ERR'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("               || -- RULE-B CHECK" ).append("\n"); 
		query.append("               CASE WHEN" ).append("\n"); 
		query.append("                   (SELECT 1" ).append("\n"); 
		query.append("                      FROM TRS_AGMT_EQ_TP_RULE            H" ).append("\n"); 
		query.append("                     WHERE TRSP_AGMT_RULE_TP_CD                = 'D'" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_STEP_KNT                  = 2" ).append("\n"); 
		query.append("                       AND NVL(RAIL_SVC_TP_CD, 'N/A')          = DECODE(T.RAIL_SVC_TP_CD, '00', 'N/A', T.RAIL_SVC_TP_CD)" ).append("\n"); 
		query.append("                       AND NVL(CURR_COND_CD, 'N/A')            = DECODE(T.CURR_CD, 'XXX', 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND NVL(RT_COND_CD, 'N/A')              = DECODE(T.TRSP_ONE_WY_RT, NULL, 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND NVL(RND_TRP_RT_COND_CD, 'N/A')      = DECODE(T.TRSP_RND_RT, NULL, 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND ROWNUM                              = 1" ).append("\n"); 
		query.append("                   ) IS NULL THEN ',RULE-B ERR'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("               || -- RULE-C RULE CHECK" ).append("\n"); 
		query.append("               CASE WHEN" ).append("\n"); 
		query.append("                   (SELECT 1" ).append("\n"); 
		query.append("                      FROM TRS_AGMT_EQ_TP_RULE            H" ).append("\n"); 
		query.append("                     WHERE TRSP_AGMT_RULE_TP_CD                = 'D'" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_STEP_KNT                  = 3" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_COST_MOD_CD               = T.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                       AND NVL(TRSP_AGMT_CGO_TP_CD, 'N/A')     = DECODE(T.CGO_TP_CD, '0', 'N/A', T.CGO_TP_CD)" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_EQ_KND_CD                 = T.EQ_KND_CD" ).append("\n"); 
		query.append("                       AND H.TRSP_AGMT_EQ_SZ_CD                = T.TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("                       AND ROWNUM                              = 1" ).append("\n"); 
		query.append("                   ) IS NULL THEN ',RULE-C ERR'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("               || -- RULE-D RULE CHECK" ).append("\n"); 
		query.append("               CASE WHEN" ).append("\n"); 
		query.append("                   (SELECT 1" ).append("\n"); 
		query.append("                      FROM TRS_AGMT_EQ_TP_RULE            H" ).append("\n"); 
		query.append("                     WHERE TRSP_AGMT_RULE_TP_CD                = 'D'" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_STEP_KNT                  = 4" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_COST_MOD_CD               = T.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                       AND NVL(TRSP_AGMT_CGO_TP_CD, 'N/A')     = DECODE(T.CGO_TP_CD, '0', 'N/A', T.CGO_TP_CD)" ).append("\n"); 
		query.append("                       AND H.TRSP_AGMT_EQ_KND_CD               = T.EQ_KND_CD" ).append("\n"); 
		query.append("                       AND H.TRSP_AGMT_EQ_TP_CD                = T.TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append("                       AND NVL(CHSS_NO_COND_CD, 'N/A')         = DECODE(T.TRSP_AGMT_BDL_QTY, '0', 'N/A', 'NN')" ).append("\n"); 
		query.append("                       AND ROWNUM                              = 1" ).append("\n"); 
		query.append("                   ) IS NULL THEN ',RULE-D ERR'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("               || -- RULE-F RULE CHECK" ).append("\n"); 
		query.append("               CASE WHEN" ).append("\n"); 
		query.append("                   (SELECT 1" ).append("\n"); 
		query.append("                      FROM TRS_AGMT_EQ_TP_RULE            H" ).append("\n"); 
		query.append("                     WHERE TRSP_AGMT_RULE_TP_CD                = 'D'" ).append("\n"); 
		query.append("                       AND TRSP_AGMT_STEP_KNT                  = 6" ).append("\n"); 
		query.append("                       AND H.TRSP_AGMT_EQ_TP_CD                = T.TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append("                       AND NVL(H.TRSP_AGMT_EQ_SZ_CD, 'N/A')    = NVL(T.TRSP_AGMT_EQ_SZ_CD, 'N/A') --Genset은 Size가 없으므로 NVL처리" ).append("\n"); 
		query.append("                       AND ROWNUM                              = 1" ).append("\n"); 
		query.append("                   ) IS NULL THEN ',RULE-F ERR'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("               || -- Agreement Approval Date" ).append("\n"); 
		query.append("               CASE WHEN T.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("                     AND T.AGMT_APRO_DT IS NULL" ).append("\n"); 
		query.append("                    THEN ',AGMT Approval Date is missing'" ).append("\n"); 
		query.append("               END " ).append("\n"); 
		query.append("               AS RULE_CHK" ).append("\n"); 
		query.append("               ,TO_NUMBER(ROW_NO) SR" ).append("\n"); 
		query.append("               ,CASE WHEN INSTR(TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD, 'AL') > 0 THEN 1 ELSE 0 END ALL_CHK" ).append("\n"); 
		query.append("               ,TRSP_TMP_SEQ  " ).append("\n"); 
		query.append("               ,RT_UPD_STS_CD" ).append("\n"); 
		query.append("               ,(SELECT '; LINE '||U.ROW_NO ||' DUP'" ).append("\n"); 
		query.append("                   FROM TRS_AGMT_TMP U" ).append("\n"); 
		query.append("                  WHERE U.TRSP_AGMT_OFC_CTY_CD = T.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    AND U.TRSP_AGMT_SEQ       = T.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                    AND U.AGMT_TRSP_TP_CD     = T.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                    AND U.CGO_TP_CD           = T.CGO_TP_CD" ).append("\n"); 
		query.append("                    AND U.CUST_NOMI_TRKR_FLG  = T.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                    AND U.CUST_CNT_CD         = T.CUST_CNT_CD" ).append("\n"); 
		query.append("                    AND U.CUST_SEQ            = T.CUST_SEQ" ).append("\n"); 
		query.append("                    AND U.TRSP_COST_MOD_CD    = T.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                    AND U.AGMT_TRSP_TP_CD     = T.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                    AND U.CMDT_GRP_CD         = T.CMDT_GRP_CD" ).append("\n"); 
		query.append("                    AND U.RAIL_SVC_TP_CD      = T.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("                    AND U.FM_NOD_CD           = T.FM_NOD_CD" ).append("\n"); 
		query.append("                    AND U.VIA_NOD_CD          = T.VIA_NOD_CD" ).append("\n"); 
		query.append("                    AND U.DOR_NOD_CD          = T.DOR_NOD_CD" ).append("\n"); 
		query.append("                    AND U.TO_NOD_CD           = T.TO_NOD_CD" ).append("\n"); 
		query.append("                    AND U.TRSP_AGMT_DIST      = T.TRSP_AGMT_DIST" ).append("\n"); 
		query.append("                    AND U.DIST_MEAS_UT_CD     = T.DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("                    AND U.TRSP_DIST_TP_CD     = T.TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("                    AND U.TRSP_AGMT_EQ_TP_CD  = T.TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append("                    AND U.TRSP_AGMT_EQ_SZ_CD  = T.TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("                    AND U.EQ_KND_CD           = T.EQ_KND_CD" ).append("\n"); 
		query.append("                    AND U.WTR_RCV_TERM_CD     = T.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                    AND U.WTR_DE_TERM_CD      = T.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                    AND U.TRSP_AGMT_BDL_QTY   = T.TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("                    AND U.TO_WGT              = DECODE(T.TRSP_SCG_CD, 'XX', T.TO_WGT, U.TO_WGT) -- BASIC RATE일 경우만 WEIGHT를 체크한다." ).append("\n"); 
		query.append("                    AND U.WGT_MEAS_UT_CD      = DECODE(T.TRSP_SCG_CD, 'XX', T.WGT_MEAS_UT_CD, U.WGT_MEAS_UT_CD) -- BASIC RATE일 경우만 WEIGHT를 체크한다." ).append("\n"); 
		query.append("                    AND U.TRSP_RVS_APLY_FLG   = T.TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("                    AND U.TRSP_SCG_CD         = T.TRSP_SCG_CD" ).append("\n"); 
		query.append("                    AND U.TRSP_TMP_SEQ        = T.TRSP_TMP_SEQ" ).append("\n"); 
		query.append("                    AND U.ROW_NO             <> T.ROW_NO" ).append("\n"); 
		query.append("                    AND U.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) UI_DUP" ).append("\n"); 
		query.append("               ,(SELECT 'DUP'" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("                      ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("                      ,TRS_AGMT_NOD   D" ).append("\n"); 
		query.append("                      ,TRS_AGMT_EQ_RT E" ).append("\n"); 
		query.append("                 WHERE A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND D.TRSP_AGMT_NOD_SEQ      = E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_OFC_CTY_CD   = T.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_SEQ          = T.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_RT_TP_CD     = T.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                   AND C.CGO_TP_CD              = T.CGO_TP_CD" ).append("\n"); 
		query.append("                   AND C.CUST_NOMI_TRKR_FLG     = T.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                   AND C.CUST_CNT_CD            = T.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND C.CUST_SEQ               = T.CUST_SEQ" ).append("\n"); 
		query.append("                   AND C.TRSP_COST_MOD_CD       = T.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                   AND C.AGMT_TRSP_TP_CD        = T.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                   AND C.CMDT_GRP_CD            = T.CMDT_GRP_CD" ).append("\n"); 
		query.append("                   AND C.RAIL_SVC_TP_CD         = T.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("                   AND D.FM_NOD_CD              = T.FM_NOD_CD" ).append("\n"); 
		query.append("                   AND D.VIA_NOD_CD             = T.VIA_NOD_CD" ).append("\n"); 
		query.append("                   AND D.DOR_NOD_CD             = T.DOR_NOD_CD" ).append("\n"); 
		query.append("                   AND D.TO_NOD_CD              = T.TO_NOD_CD" ).append("\n"); 
		query.append("                   AND D.TRSP_AGMT_DIST         = T.TRSP_AGMT_DIST" ).append("\n"); 
		query.append("                   AND D.DIST_MEAS_UT_CD        = T.DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("                   AND D.TRSP_DIST_TP_CD        = T.TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("                   AND E.TRSP_AGMT_EQ_TP_SZ_CD  = T.TRSP_AGMT_EQ_TP_CD||T.TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("                   AND E.EQ_KND_CD              = T.EQ_KND_CD            " ).append("\n"); 
		query.append("                   AND E.WTR_RCV_TERM_CD        = T.WTR_RCV_TERM_CD      " ).append("\n"); 
		query.append("                   AND E.WTR_DE_TERM_CD         = T.WTR_DE_TERM_CD       " ).append("\n"); 
		query.append("                   AND E.TRSP_AGMT_BDL_QTY      = T.TRSP_AGMT_BDL_QTY    " ).append("\n"); 
		query.append("                   AND E.TO_WGT                 = T.TO_WGT               " ).append("\n"); 
		query.append("                   AND E.WGT_MEAS_UT_CD         = T.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("                   AND T.RT_UPD_STS_CD         <> 'I'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1  " ).append("\n"); 
		query.append("                ) DB_DUP" ).append("\n"); 
		query.append("           FROM TRS_AGMT_TMP T" ).append("\n"); 
		query.append("          WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("            AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("            AND ROW_NO IS NOT NULL" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("GROUP BY TRSP_TMP_SEQ ,SR ,RT_UPD_STS_CD" ).append("\n"); 
		query.append("ORDER BY SR" ).append("\n"); 

	}
}