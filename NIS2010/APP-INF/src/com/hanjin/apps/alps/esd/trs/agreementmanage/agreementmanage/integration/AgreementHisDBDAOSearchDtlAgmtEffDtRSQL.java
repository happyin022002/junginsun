/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AgreementHisDBDAOSearchDtlAgmtEffDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.04 
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

public class AgreementHisDBDAOSearchDtlAgmtEffDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AgreementHisDBDAOSearchDtlAgmtEffDt
	  * </pre>
	  */
	public AgreementHisDBDAOSearchDtlAgmtEffDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_size",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delete_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("costmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspAgmtOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_page_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqtype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmVndrPrmrySeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmAgmtTrspTpCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspAgmtSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("approval_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("effectiveDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementHisDBDAOSearchDtlAgmtEffDtRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT ROWNUM NUM" ).append("\n"); 
		query.append(",X.VNDR_SEQ" ).append("\n"); 
		query.append(",X.VNDR_NM" ).append("\n"); 
		query.append(",X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",X.AGMT_NO" ).append("\n"); 
		query.append(",X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append(",X.CGO_TP_CD" ).append("\n"); 
		query.append(",X.CUST_CNT_CD" ).append("\n"); 
		query.append(",X.CUST_SEQ" ).append("\n"); 
		query.append(",X.CUSTOMER_CD" ).append("\n"); 
		query.append(",X.CMDT_GRP_CD" ).append("\n"); 
		query.append(",X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append(",X.FM_NOD_CD" ).append("\n"); 
		query.append(",X.VIA_NOD_CD" ).append("\n"); 
		query.append(",X.DOR_NOD_CD" ).append("\n"); 
		query.append(",X.TO_NOD_CD" ).append("\n"); 
		query.append(",X.FM_NOD_CD_NM" ).append("\n"); 
		query.append(",X.VIA_NOD_CD_NM" ).append("\n"); 
		query.append(",X.DOR_NOD_CD_NM" ).append("\n"); 
		query.append(",X.TO_NOD_CD_NM" ).append("\n"); 
		query.append(",X.TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append(",X.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(",X.WTR_DE_TERM_CD" ).append("\n"); 
		query.append(",X.TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append(",X.TO_WGT" ).append("\n"); 
		query.append(",X.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(",X.CURR_CD" ).append("\n"); 
		query.append(",X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append(",X.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append(",X.TRSP_RND_RT" ).append("\n"); 
		query.append(",X.CTRT_OFC_CD" ).append("\n"); 
		query.append(",X.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append(",X.EFF_FM_DT" ).append("\n"); 
		query.append(",X.EFF_TO_DT" ).append("\n"); 
		query.append(",X.TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append(",X.CNT" ).append("\n"); 
		query.append(",DECODE(X.SCG_CNT,0,X.SCG_CNT,X.SCG_CNT-1) AS SCG_CNT" ).append("\n"); 
		query.append(",X.DELT_FLG" ).append("\n"); 
		query.append(",X.CHK" ).append("\n"); 
		query.append(",X.AGMT_APRO_DT" ).append("\n"); 
		query.append(",X.UPD_DT" ).append("\n"); 
		query.append(",X.DT_GAP" ).append("\n"); 
		query.append(",X.UPD_USR_NM" ).append("\n"); 
		query.append(",X.CFM_FLG" ).append("\n"); 
		query.append(",X.CFM_USR_NM" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("------------추가------------------" ).append("\n"); 
		query.append("SELECT * FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("----------------------------------" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        E.VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT MDM.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MDM" ).append("\n"); 
		query.append("         WHERE MDM.VNDR_SEQ = E.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("     , A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("     , A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("     , A.TRSP_AGMT_OFC_CTY_CD||A.TRSP_AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("     , B.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("     , B.CGO_TP_CD" ).append("\n"); 
		query.append("     , DECODE(B.CUST_CNT_CD , 'XX', NULL, B.CUST_CNT_CD ) CUST_CNT_CD" ).append("\n"); 
		query.append("     , DECODE(B.CUST_SEQ , '0', NULL, B.CUST_SEQ ) CUST_SEQ" ).append("\n"); 
		query.append("     , DECODE(B.CUST_CNT_CD||B.CUST_SEQ, 'XX0', NULL, B.CUST_CNT_CD||B.CUST_SEQ) AS CUSTOMER_CD" ).append("\n"); 
		query.append("     , DECODE(B.CMDT_GRP_CD, 'XXXX', NULL, B.CMDT_GRP_CD) CMDT_GRP_CD" ).append("\n"); 
		query.append("     , DECODE(B.RAIL_SVC_TP_CD, '00', NULL, B.RAIL_SVC_TP_CD) RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("     , DECODE(C.FM_NOD_CD, '0000000', NULL, C.FM_NOD_CD) FM_NOD_CD" ).append("\n"); 
		query.append("     , DECODE(C.VIA_NOD_CD, '0000000', NULL, C.VIA_NOD_CD) VIA_NOD_CD" ).append("\n"); 
		query.append("     , DECODE(C.DOR_NOD_CD, '0000000', NULL, C.DOR_NOD_CD) DOR_NOD_CD" ).append("\n"); 
		query.append("     , DECODE(C.TO_NOD_CD, '0000000', NULL, C.TO_NOD_CD) TO_NOD_CD" ).append("\n"); 
		query.append("     , D.TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append("     , DECODE(D.WTR_RCV_TERM_CD, '0', NULL, D.WTR_RCV_TERM_CD) WTR_RCV_TERM_CD --FEEDER TERM (R)" ).append("\n"); 
		query.append("     , DECODE(D.WTR_DE_TERM_CD, '0', NULL, D.WTR_DE_TERM_CD) WTR_DE_TERM_CD --FEEDER TERM (D)" ).append("\n"); 
		query.append("     , DECODE(D.TRSP_AGMT_BDL_QTY, '0', NULL, D.TRSP_AGMT_BDL_QTY) TRSP_AGMT_BDL_QTY --CHASSIS" ).append("\n"); 
		query.append("     , DECODE(D.TO_WGT, '0', NULL, '999999.99', 'MAX', D.TO_WGT) TO_WGT --WEIGHT TIER" ).append("\n"); 
		query.append("     , DECODE(D.WGT_MEAS_UT_CD, 'XXX', NULL, D.WGT_MEAS_UT_CD) WGT_MEAS_UT_CD --UOM" ).append("\n"); 
		query.append("     , D.CURR_CD" ).append("\n"); 
		query.append("     , B.AGMT_TRSP_TP_CD --TRANS MODE TYPE" ).append("\n"); 
		query.append("     , D.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("     , D.TRSP_RND_RT" ).append("\n"); 
		query.append("     , A.CTRT_OFC_CD" ).append("\n"); 
		query.append("     , D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("     , TO_CHAR(D.EFF_FM_DT,'YYYYMMDD') EFF_FM_DT" ).append("\n"); 
		query.append("     , TO_CHAR(D.EFF_TO_DT,'YYYYMMDD') EFF_TO_DT" ).append("\n"); 
		query.append("     , D.TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("     , NVL(NVL(FM_Y.YD_NM, FM_S.LSE_CO_YD_NM), FM_L.LOC_NM) FM_NOD_CD_NM" ).append("\n"); 
		query.append("     , NVL(NVL(VA_Y.YD_NM, VA_S.LSE_CO_YD_NM), VA_L.LOC_NM) VIA_NOD_CD_NM" ).append("\n"); 
		query.append("     , NVL(DR_Z.ZN_NM, DR_L.LOC_NM) DOR_NOD_CD_NM" ).append("\n"); 
		query.append("     , NVL(NVL(TO_Y.YD_NM, TO_S.LSE_CO_YD_NM), TO_L.LOC_NM) TO_NOD_CD_NM" ).append("\n"); 
		query.append("      ------------------------- 변경 -------------------------" ).append("\n"); 
		query.append("      --, F.CNT" ).append("\n"); 
		query.append("     , COUNT(F.TRSP_AGMT_RT_HIS_SEQ) OVER(PARTITION BY F.TRSP_AGMT_OFC_CTY_CD, F.TRSP_AGMT_SEQ, F.TRSP_AGMT_RT_TP_SER_NO, F.TRSP_AGMT_NOD_SEQ, F.TRSP_AGMT_RT_SEQ) AS CNT" ).append("\n"); 
		query.append("      --------------------------------------------------------" ).append("\n"); 
		query.append("     , CASE WHEN G.TRSP_AGMT_OFC_CTY_CD IS NULL THEN 'Y'" ).append("\n"); 
		query.append("            WHEN G.AGMT_EXP_DT IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("            ELSE D.DELT_FLG" ).append("\n"); 
		query.append("       END DELT_FLG" ).append("\n"); 
		query.append("     ," ).append("\n"); 
		query.append("     DECODE(H.CHK, 'Y'," ).append("\n"); 
		query.append("        -- US RAIL SURCHARGE" ).append("\n"); 
		query.append("        (SELECT COUNT(*)" ).append("\n"); 
		query.append("              FROM  TRS_AGMT_APLY_VNDR VNDR" ).append("\n"); 
		query.append("                   ,TRS_AGMT_RAIL_SCG_RT_HIS HIS" ).append("\n"); 
		query.append("                   ,TRS_AGMT_RAIL_SCG_RT  RT" ).append("\n"); 
		query.append("             WHERE VNDR.TRSP_AGMT_OFC_CTY_CD = HIS.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND VNDR.TRSP_AGMT_SEQ        = HIS.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("               AND HIS.TRSP_AGMT_SCG_SEQ     = RT.TRSP_AGMT_SCG_SEQ" ).append("\n"); 
		query.append("               AND HIS.TRSP_AGMT_OFC_CTY_CD  = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND HIS.TRSP_AGMT_SEQ         = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("               AND HIS.CGO_TP_CD             = B.CGO_TP_CD" ).append("\n"); 
		query.append("               #if (${delete_yn} != '')" ).append("\n"); 
		query.append("                 AND HIS.DELT_FLG = @[delete_yn]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               AND TO_DATE(@[effectiveDate], 'YYYY-MM-DD') BETWEEN HIS.EFF_FM_DT AND HIS.EFF_TO_DT" ).append("\n"); 
		query.append("               AND ((HIS.AGMT_ROUT_ALL_FLG = 'Y')" ).append("\n"); 
		query.append("                 OR (    SUBSTR(HIS.FM_NOD_CD,1,5)  = SUBSTR(C.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("                     AND SUBSTR(HIS.TO_NOD_CD,1,5)  = SUBSTR(C.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("               AND DECODE(HIS.TRSP_RAIL_SCG_CD, 'FSG', 'N/A', HIS.CURR_CD) = DECODE(HIS.TRSP_RAIL_SCG_CD, 'FSG', 'N/A', D.CURR_CD)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               AND (CASE WHEN HIS.TRSP_RAIL_SCG_CD = 'OWS' THEN CASE WHEN SUBSTR(REPLACE(D.TRSP_AGMT_EQ_TP_SZ_CD, 'AL', '@'), 2) = '@' THEN 'N/A'" ).append("\n"); 
		query.append("                                                                ELSE CASE SUBSTR(REPLACE(D.TRSP_AGMT_EQ_TP_SZ_CD, 'AL', '@'), 2)" ).append("\n"); 
		query.append("                                                                          WHEN '2' THEN '20'" ).append("\n"); 
		query.append("                                                                          WHEN '3' THEN '20'" ).append("\n"); 
		query.append("                                                                          WHEN '4' THEN '40'" ).append("\n"); 
		query.append("                                                                          WHEN '5' THEN '40'" ).append("\n"); 
		query.append("                                                                          WHEN '6' THEN '45'" ).append("\n"); 
		query.append("                                                                          WHEN '7' THEN '45'" ).append("\n"); 
		query.append("                                                                     END" ).append("\n"); 
		query.append("                                                           END" ).append("\n"); 
		query.append("                       ELSE 'N/A'" ).append("\n"); 
		query.append("                    END)" ).append("\n"); 
		query.append("                    =" ).append("\n"); 
		query.append("                    (CASE WHEN HIS.TRSP_RAIL_SCG_CD = 'OWS' THEN CASE WHEN SUBSTR(REPLACE(D.TRSP_AGMT_EQ_TP_SZ_CD, 'AL', '@'), 2) = '@' THEN 'N/A'" ).append("\n"); 
		query.append("                                                                ELSE HIS.AGMT_EQ_SZ_NO" ).append("\n"); 
		query.append("                                                           END" ).append("\n"); 
		query.append("                       ELSE 'N/A'" ).append("\n"); 
		query.append("                    END)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         , " ).append("\n"); 
		query.append("         -- BASIC RATE가 D2, D4일 경우 SURCHARGE에 DAL 또는 AL2, ALAL TPSZ의 SURCHARGE가 존재하는지 검색한다. (BASIC이 MULTI일 경우)" ).append("\n"); 
		query.append("         (SELECT  COUNT(*) CNT" ).append("\n"); 
		query.append("            FROM  TRS_AGMT_SCG_NOD NOD" ).append("\n"); 
		query.append("                , TRS_AGMT_SCG_RT_HIS HIS" ).append("\n"); 
		query.append("                , TRS_AGMT_SCG_RT RT    " ).append("\n"); 
		query.append("           WHERE NOD.TRSP_AGMT_OFC_CTY_CD   = HIS.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("             AND NOD.TRSP_AGMT_SEQ          = HIS.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("             AND NOD.TRSP_AGMT_RT_TP_SER_NO = HIS.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("             AND NOD.TRSP_AGMT_SCG_NOD_SEQ  = HIS.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("             AND HIS.TRSP_AGMT_OFC_CTY_CD   = RT.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("             AND HIS.TRSP_AGMT_SEQ          = RT.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("             AND HIS.TRSP_AGMT_RT_TP_SER_NO = RT.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("             AND HIS.TRSP_AGMT_SCG_NOD_SEQ  = RT.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("             AND HIS.TRSP_AGMT_SCG_RT_SEQ   = RT.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("             AND NOD.TRSP_AGMT_OFC_CTY_CD   = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("             AND NOD.TRSP_AGMT_SEQ          = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("             AND NOD.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("             #if (${delete_yn} != '')" ).append("\n"); 
		query.append("               AND HIS.DELT_FLG = @[delete_yn]" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             AND TO_DATE(@[effectiveDate], 'YYYY-MM-DD') BETWEEN HIS.EFF_FM_DT AND HIS.EFF_TO_DT" ).append("\n"); 
		query.append("             AND ((NOD.AGMT_ROUT_ALL_FLG = 'Y')" ).append("\n"); 
		query.append("               OR (    SUBSTR(NOD.FM_NOD_CD,1,5)  = SUBSTR(C.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("                   AND SUBSTR(NOD.VIA_NOD_CD,1,5) = SUBSTR(C.VIA_NOD_CD,1,5)" ).append("\n"); 
		query.append("                   AND SUBSTR(NOD.DOR_NOD_CD,1,5) = SUBSTR(C.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("                   AND SUBSTR(NOD.TO_NOD_CD,1,5)  = SUBSTR(C.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("             AND HIS.TRSP_AGMT_EQ_TP_SZ_CD IN (SELECT T.TRSP_AGMT_EQ_TP_CD||T.TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("                                                 FROM TRS_AGMT_EQ_TP_RULE T" ).append("\n"); 
		query.append("                                                WHERE T.TRSP_AGMT_RULE_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                  AND T.TRSP_AGMT_STEP_KNT = 6" ).append("\n"); 
		query.append("                                                  AND T.TRSP_AGMT_EQ_SZ_CD NOT IN ('X', 'W')                 " ).append("\n"); 
		query.append("                                                  AND ( REPLACE(SUBSTR(REPLACE(D.TRSP_AGMT_EQ_TP_SZ_CD, 'AL', '@'), 1, 1), '@', 'AL') = T.TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append("                                                        OR 'AL' = T.TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                                                  AND ( REPLACE(SUBSTR(REPLACE(D.TRSP_AGMT_EQ_TP_SZ_CD, 'AL', '@'), DECODE(D.EQ_KND_CD, 'U', 2, 3)), '@', 'AL') = T.TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("                                                        OR 'AL' = T.TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("         ) " ).append("\n"); 
		query.append("         + -- BASIC이 AL2, DAL, ALAL 일경우 SURCHARGE에서 D2, D4와 같은 SURCHARGE가 등록되어 있는지 검색한다. (SURCHARGE가 MULTI일 경우)" ).append("\n"); 
		query.append("         NVL(" ).append("\n"); 
		query.append("           (SELECT  COUNT(DISTINCT HIS.TRSP_AGMT_EQ_TP_SZ_CD) CNT" ).append("\n"); 
		query.append("              FROM  TRS_AGMT_SCG_NOD NOD" ).append("\n"); 
		query.append("                  , TRS_AGMT_SCG_RT_HIS HIS" ).append("\n"); 
		query.append("                  , TRS_AGMT_SCG_RT RT" ).append("\n"); 
		query.append("             WHERE NOD.TRSP_AGMT_OFC_CTY_CD   = HIS.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND NOD.TRSP_AGMT_SEQ          = HIS.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("               AND NOD.TRSP_AGMT_RT_TP_SER_NO = HIS.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("               AND NOD.TRSP_AGMT_SCG_NOD_SEQ  = HIS.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("               AND HIS.TRSP_AGMT_OFC_CTY_CD   = RT.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND HIS.TRSP_AGMT_SEQ          = RT.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("               AND HIS.TRSP_AGMT_RT_TP_SER_NO = RT.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("               AND HIS.TRSP_AGMT_SCG_NOD_SEQ  = RT.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("               AND HIS.TRSP_AGMT_SCG_RT_SEQ   = RT.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("               AND NOD.TRSP_AGMT_OFC_CTY_CD   = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND NOD.TRSP_AGMT_SEQ          = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("               AND NOD.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("               #if (${delete_yn} != '')" ).append("\n"); 
		query.append("                 AND HIS.DELT_FLG = @[delete_yn]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               AND TO_DATE(@[effectiveDate], 'YYYY-MM-DD') BETWEEN HIS.EFF_FM_DT AND HIS.EFF_TO_DT" ).append("\n"); 
		query.append("               AND ((NOD.AGMT_ROUT_ALL_FLG = 'Y')" ).append("\n"); 
		query.append("                 OR (    SUBSTR(NOD.FM_NOD_CD,1,5)  = SUBSTR(C.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("                     AND SUBSTR(NOD.VIA_NOD_CD,1,5) = SUBSTR(C.VIA_NOD_CD,1,5)" ).append("\n"); 
		query.append("                     AND SUBSTR(NOD.DOR_NOD_CD,1,5) = SUBSTR(C.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("                     AND SUBSTR(NOD.TO_NOD_CD,1,5)  = SUBSTR(C.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                 AND (      -- AL2와 같이 TYPE이 AL일 경우" ).append("\n"); 
		query.append("                       (    SUBSTR(D.TRSP_AGMT_EQ_TP_SZ_CD, 3) = SUBSTR(HIS.TRSP_AGMT_EQ_TP_SZ_CD, DECODE(D.EQ_KND_CD, 'U', 2, 3))" ).append("\n"); 
		query.append("                        AND HIS.TRSP_AGMT_EQ_TP_SZ_CD NOT LIKE '%AL%'" ).append("\n"); 
		query.append("                        AND D.TRSP_AGMT_EQ_TP_SZ_CD LIKE '%AL%'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                     OR     -- DAL와 같이 SIZE가 AL일 경우" ).append("\n"); 
		query.append("                       (    SUBSTR(D.TRSP_AGMT_EQ_TP_SZ_CD, 1, DECODE(D.EQ_KND_CD, 'U', 1, 2)) = SUBSTR(HIS.TRSP_AGMT_EQ_TP_SZ_CD, 1, DECODE(D.EQ_KND_CD, 'U', 1, 2))" ).append("\n"); 
		query.append("                        AND HIS.TRSP_AGMT_EQ_TP_SZ_CD NOT LIKE '%AL%'" ).append("\n"); 
		query.append("                        AND D.TRSP_AGMT_EQ_TP_SZ_CD LIKE '%AL%'" ).append("\n"); 
		query.append("                       )    -- ALAL일 경우               " ).append("\n"); 
		query.append("                     OR DECODE(D.TRSP_AGMT_EQ_TP_SZ_CD, 'ALAL', 'ALAL', 'X') = 'ALAL'" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("               AND ROWNUM <= 2  " ).append("\n"); 
		query.append("               GROUP BY HIS.TRSP_AGMT_EQ_TP_SZ_CD  " ).append("\n"); 
		query.append("               HAVING COUNT(*) > 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           ,0)" ).append("\n"); 
		query.append("         ) AS SCG_CNT" ).append("\n"); 
		query.append("         ,H.CHK" ).append("\n"); 
		query.append("          -------------------- 추가 --------------------" ).append("\n"); 
		query.append("         ,MAX(F.TRSP_AGMT_RT_HIS_SEQ) OVER(PARTITION BY F.TRSP_AGMT_OFC_CTY_CD, F.TRSP_AGMT_SEQ, F.TRSP_AGMT_RT_TP_SER_NO, F.TRSP_AGMT_NOD_SEQ, F.TRSP_AGMT_RT_SEQ) F_SEQ" ).append("\n"); 
		query.append("         ,D.TRSP_AGMT_RT_HIS_SEQ D_SEQ" ).append("\n"); 
		query.append("          -------------------------------------------" ).append("\n"); 
		query.append("         ,TO_CHAR(D.AGMT_APRO_DT,'YYYYMMDD') AGMT_APRO_DT" ).append("\n"); 
		query.append("         ,TO_CHAR(D.UPD_DT,'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("         ,TO_CHAR(TO_DATE(TO_CHAR(D.AGMT_APRO_DT,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(D.UPD_DT,'YYYYMMDD'),'YYYYMMDD')) DT_GAP" ).append("\n"); 
		query.append("         ,NVL((SELECT MAX(X.USR_NM) FROM COM_USER X WHERE X.USR_ID = D.UPD_USR_ID),D.UPD_USR_ID) UPD_USR_NM" ).append("\n"); 
		query.append("         ,B.CFM_FLG" ).append("\n"); 
		query.append("         ,NVL((SELECT MAX(X.USR_NM) FROM COM_USER X WHERE X.USR_ID = B.CFM_USR_ID),B.CFM_USR_ID) CFM_USR_NM            " ).append("\n"); 
		query.append("FROM TRS_AGMT_HDR A" ).append("\n"); 
		query.append("   , TRS_AGMT_RT_TP B" ).append("\n"); 
		query.append("   , TRS_AGMT_NOD C" ).append("\n"); 
		query.append("   , TRS_AGMT_EQ_RT_HIS D" ).append("\n"); 
		query.append("   , TRS_AGMT_APLY_VNDR E" ).append("\n"); 
		query.append("   , TRS_AGMT_EQ_RT G" ).append("\n"); 
		query.append("   , (SELECT  HIS.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            , HIS.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            , HIS.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("            , HIS.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("            , HIS.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("            --------------------- 변경 ---------------------------" ).append("\n"); 
		query.append("            --, MAX(HIS.TRSP_AGMT_RT_HIS_SEQ) TRSP_AGMT_RT_HIS_SEQ" ).append("\n"); 
		query.append("            --, COUNT(1) CNT" ).append("\n"); 
		query.append("            , (HIS.TRSP_AGMT_RT_HIS_SEQ) TRSP_AGMT_RT_HIS_SEQ" ).append("\n"); 
		query.append("            ------------------------------------------------------" ).append("\n"); 
		query.append("        FROM TRS_AGMT_EQ_RT_HIS HIS" ).append("\n"); 
		query.append("            ,TRS_AGMT_HDR       HDR" ).append("\n"); 
		query.append("       WHERE HDR.TRSP_AGMT_OFC_CTY_CD = HIS.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("         AND HDR.TRSP_AGMT_SEQ        = HIS.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("         AND TO_DATE(@[effectiveDate], 'YYYY-MM-DD') BETWEEN HIS.EFF_FM_DT AND HIS.EFF_TO_DT" ).append("\n"); 
		query.append("         #if (${delete_yn} != '')" ).append("\n"); 
		query.append("           AND HIS.DELT_FLG = @[delete_yn]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("            --GROUP BY HIS.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            --,HIS.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            --,HIS.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("            --,HIS.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("            --,HIS.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("            ------------------------------------------------------" ).append("\n"); 
		query.append("     ) F" ).append("\n"); 
		query.append("   , (SELECT INTG_CD_VAL_CTNT VNDR_SEQ, 'Y' CHK" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("       WHERE INTG_CD_ID = 'CD00930') H" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   ,MDM_YARD      FM_Y" ).append("\n"); 
		query.append("   ,MDM_LSE_CO_YD FM_S" ).append("\n"); 
		query.append("   ,MDM_LOCATION  FM_L" ).append("\n"); 
		query.append("   ,MDM_YARD      VA_Y" ).append("\n"); 
		query.append("   ,MDM_LSE_CO_YD VA_S" ).append("\n"); 
		query.append("   ,MDM_LOCATION  VA_L" ).append("\n"); 
		query.append("   ,MDM_ZONE      DR_Z" ).append("\n"); 
		query.append("   ,MDM_LOCATION  DR_L" ).append("\n"); 
		query.append("   ,MDM_YARD      TO_Y" ).append("\n"); 
		query.append("   ,MDM_LSE_CO_YD TO_S" ).append("\n"); 
		query.append("   ,MDM_LOCATION  TO_L" ).append("\n"); 
		query.append("WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  AND B.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND B.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_OFC_CTY_CD = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_SEQ = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_NOD_SEQ = D.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("  AND B.TRSP_AGMT_RT_TP_CD = 'P'" ).append("\n"); 
		query.append("  AND E.TRSP_AGMT_OFC_CTY_CD = A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND E.TRSP_AGMT_SEQ = A.TRSP_AGMT_SEQ    " ).append("\n"); 
		query.append("  AND F.TRSP_AGMT_OFC_CTY_CD   = G.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("  AND F.TRSP_AGMT_SEQ          = G.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("  AND F.TRSP_AGMT_RT_TP_SER_NO = G.TRSP_AGMT_RT_TP_SER_NO(+)" ).append("\n"); 
		query.append("  AND F.TRSP_AGMT_NOD_SEQ      = G.TRSP_AGMT_NOD_SEQ(+)" ).append("\n"); 
		query.append("  AND F.TRSP_AGMT_RT_SEQ       = G.TRSP_AGMT_RT_SEQ(+)" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_OFC_CTY_CD   = F.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_SEQ          = F.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_RT_TP_SER_NO = F.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_NOD_SEQ      = F.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_RT_SEQ       = F.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_RT_HIS_SEQ   = F.TRSP_AGMT_RT_HIS_SEQ" ).append("\n"); 
		query.append("  AND E.VNDR_SEQ               = H.VNDR_SEQ(+)" ).append("\n"); 
		query.append("  AND E.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("  AND C.FM_NOD_CD = FM_Y.YD_CD(+)" ).append("\n"); 
		query.append("  AND C.FM_NOD_CD = FM_S.LSE_CO_YD_CD(+)" ).append("\n"); 
		query.append("  AND SUBSTR(C.FM_NOD_CD,1,5) = FM_L.LOC_CD(+)" ).append("\n"); 
		query.append("  AND C.VIA_NOD_CD = VA_Y.YD_CD(+)" ).append("\n"); 
		query.append("  AND C.VIA_NOD_CD = VA_S.LSE_CO_YD_CD(+)" ).append("\n"); 
		query.append("  AND SUBSTR(C.VIA_NOD_CD,1,5) = VA_L.LOC_CD(+)" ).append("\n"); 
		query.append("  AND C.DOR_NOD_CD = DR_Z.ZN_CD(+)" ).append("\n"); 
		query.append("  AND SUBSTR(C.DOR_NOD_CD,1,5) = DR_L.LOC_CD(+)" ).append("\n"); 
		query.append("  AND C.TO_NOD_CD = TO_Y.YD_CD(+)" ).append("\n"); 
		query.append("  AND C.TO_NOD_CD = TO_S.LSE_CO_YD_CD(+)" ).append("\n"); 
		query.append("  AND SUBSTR(C.TO_NOD_CD,1,5) = TO_L.LOC_CD(+)" ).append("\n"); 
		query.append("#if (${delete_yn} == 'N')" ).append("\n"); 
		query.append("  AND G.TRSP_AGMT_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("  AND NVL(G.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#elseif (${delete_yn} != '')" ).append("\n"); 
		query.append("  AND D.DELT_FLG = @[delete_yn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_nod} != '' )" ).append("\n"); 
		query.append("    AND C.FM_NOD_CD LIKE @[fm_nod]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${via_nod} != '' )" ).append("\n"); 
		query.append("    AND C.VIA_NOD_CD LIKE @[via_nod]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND C.VIA_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_nod} != '' )" ).append("\n"); 
		query.append("    AND C.TO_NOD_CD LIKE @[to_nod]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND C.TO_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dor_nod} != '' )" ).append("\n"); 
		query.append("    AND C.DOR_NOD_CD LIKE @[dor_nod]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND C.DOR_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${costmode} != '') " ).append("\n"); 
		query.append("      AND B.TRSP_COST_MOD_CD = @[costmode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cargo} != '') " ).append("\n"); 
		query.append("      AND B.CGO_TP_CD = @[cargo]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND D.EQ_KND_CD = @[eqtype]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($eqtpsz.size() > 0)" ).append("\n"); 
		query.append("      AND D.TRSP_AGMT_EQ_TP_SZ_CD IN (" ).append("\n"); 
		query.append("    #foreach($key in ${eqtpsz}) " ).append("\n"); 
		query.append("        #if($velocityCount < $eqtpsz.size()) " ).append("\n"); 
		query.append("            '$key', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fmAgmtTrspTpCd} != '') " ).append("\n"); 
		query.append("      AND B.AGMT_TRSP_TP_CD = @[fmAgmtTrspTpCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fmVndrPrmrySeq} != '') " ).append("\n"); 
		query.append("    AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN (" ).append("\n"); 
		query.append("        SELECT TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("          FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = @[fmVndrPrmrySeq]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trspAgmtOfcCtyCd} != '')" ).append("\n"); 
		query.append("	AND A.TRSP_AGMT_OFC_CTY_CD = @[trspAgmtOfcCtyCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trspAgmtSeq} != '')" ).append("\n"); 
		query.append("	AND A.TRSP_AGMT_SEQ LIKE @[trspAgmtSeq]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${effectiveDate} != '')" ).append("\n"); 
		query.append("	AND TO_DATE(@[effectiveDate], 'YYYY-MM-DD') BETWEEN D.EFF_FM_DT AND D.EFF_TO_DT" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${approval_date} != '')" ).append("\n"); 
		query.append("    AND D.AGMT_APRO_DT >= TO_DATE(REPLACE(@[approval_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("------------------- 추가 -----------------------" ).append("\n"); 
		query.append(") WHERE F_SEQ=D_SEQ" ).append("\n"); 
		query.append("------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NUM BETWEEN 1 + ((@[cur_page_cnt]-1)*@[page_size]) AND (@[cur_page_cnt]*@[page_size])" ).append("\n"); 

	}
}