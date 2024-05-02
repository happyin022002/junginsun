/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.17
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2017.01.17 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrStatusUpdateHistoryData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("(SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("                 CNTR_NO " ).append("\n"); 
		query.append("                 FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 ##${cntr_no} " ).append("\n"); 
		query.append("                 #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 AND CNMV_DT = (" ).append("\n"); 
		query.append("                               SELECT MAX(CNMV_DT) " ).append("\n"); 
		query.append("                               FROM MST_CONTAINER " ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                 AND ROWNUM = 1 " ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	A.CNTR_STS_CD" ).append("\n"); 
		query.append("	,TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYY-MM-DD') CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("	,A.YD_CD" ).append("\n"); 
		query.append("    ,A.AGMT_CTY_CD" ).append("\n"); 
		query.append("    ,A.AGMT_SEQ" ).append("\n"); 
		query.append("	,B.LSTM_CD" ).append("\n"); 
		query.append("	,B.REF_NO," ).append("\n"); 
		query.append("	 CASE WHEN A.CNTR_STS_CD IN ('SLD') " ).append("\n"); 
		query.append("	      THEN DECODE(NVL(A.CUST_CNT_CD,'0'), '0', '', A.CUST_CNT_CD||A.CUST_SEQ)" ).append("\n"); 
		query.append("	 ELSE TO_CHAR(B.VNDR_SEQ) END VNDR_SEQ," ).append("\n"); 
		query.append("	 CASE WHEN A.CNTR_STS_CD IN ('SLD') " ).append("\n"); 
		query.append("	      THEN DECODE(NVL(A.CUST_CNT_CD,'0'), '0', A.CUST_NM, (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.CUST_CNT_CD AND CUST_SEQ = A.CUST_SEQ))" ).append("\n"); 
		query.append("	 ELSE C.VNDR_LGL_ENG_NM END VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	,A.DIR_ITCHG_VNDR_SEQ" ).append("\n"); 
		query.append("    ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.DIR_ITCHG_VNDR_SEQ) DIR_VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	,A.OFC_CD" ).append("\n"); 
		query.append("	,A.CNTR_OLD_VAN_FLG" ).append("\n"); 
		query.append("   ,CASE WHEN A.CNTR_PKUP_CHG_AMT > 0 THEN" ).append("\n"); 
		query.append("      A.CNTR_PKUP_CHG_AMT " ).append("\n"); 
		query.append("   ELSE  0 END CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("   ,CASE WHEN A.CNTR_PKUP_CHG_AMT < 0 THEN" ).append("\n"); 
		query.append("      A.CNTR_PKUP_CHG_AMT * (-1)" ).append("\n"); 
		query.append("   ELSE 0 END CNTR_PKUP_CR_CHG_AMT" ).append("\n"); 
		query.append("	,A.CNTR_MIN_ONH_DYS" ).append("\n"); 
		query.append("	,A.RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("	,A.CNTR_DIR_ITCHG_FEE_AMT" ).append("\n"); 
		query.append("   ,CASE WHEN A.CNTR_DRFF_CR_AMT > 0 THEN" ).append("\n"); 
		query.append("      A.CNTR_DRFF_CR_AMT " ).append("\n"); 
		query.append("   ELSE  0 END CNTR_DRFF_AMT" ).append("\n"); 
		query.append("   ,CASE WHEN A.CNTR_DRFF_CR_AMT < 0 THEN" ).append("\n"); 
		query.append("      A.CNTR_DRFF_CR_AMT * (-1)" ).append("\n"); 
		query.append("   ELSE 0 END CNTR_DRFF_CR_AMT   " ).append("\n"); 
		query.append("	,A.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("	,A.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("	,TO_CHAR(A.CRE_DT, 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(A.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("	,A.CNTR_STS_RMK" ).append("\n"); 
		query.append("    ,D.CNMV_STS_CD MVMT_STS_CD" ).append("\n"); 
		query.append("    ,A.CNTR_STS_SEQ" ).append("\n"); 
		query.append("    ,A.CURR_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR(A.YD_CD, 1, 5)) , 'YYYY-MM-DD') TIME_LOCAL" ).append("\n"); 
		query.append("    ,CASE WHEN A.CNTR_STS_CD = 'LSI' AND " ).append("\n"); 
		query.append("          	   D.CNMV_STS_CD = 'MT' AND " ).append("\n"); 
		query.append("              NVL((SELECT TO_NUMBER(SUBSTR(MAX(TO_CHAR(CRE_DT,'YYYYMMDDHH24MISS')||LTRIM(TO_CHAR(CNMV_CYC_NO,'0000'))), 15))" ).append("\n"); 
		query.append("               FROM BKG_CONTAINER " ).append("\n"); 
		query.append("               WHERE CNTR_NO = P.CNTR_NO),88888888) != 9999 THEN 'O'" ).append("\n"); 
		query.append("      ELSE 'X' END DEL_FLG" ).append("\n"); 
		query.append("    , DECODE((SELECT MIN(SUB.CNTR_STS_SEQ)" ).append("\n"); 
		query.append("              FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("              WHERE A.CNTR_NO = SUB.CNTR_NO), A.CNTR_STS_SEQ, 'Y', 'N') AS INIT_FLG" ).append("\n"); 
		query.append("	,A.PRNR_STS_SEQ" ).append("\n"); 
		query.append("	,MST_COMMON_PKG.MST_DATA_ACSS_CHK_FNC(@[usr_ofc_cd], A.YD_CD) AS CHK_FLG" ).append("\n"); 
		query.append("    ,MST_AUTH_FNC('DATE', @[usr_ofc_cd], A.CNTR_NO, A.CNTR_STS_SEQ) DATE_FLG" ).append("\n"); 
		query.append("    ,MST_AUTH_FNC('AGMT', @[usr_ofc_cd], A.CNTR_NO, A.CNTR_STS_SEQ) AGMT_FLG" ).append("\n"); 
		query.append("    ,MST_AUTH_FNC('DELT', @[usr_ofc_cd], A.CNTR_NO, A.CNTR_STS_SEQ) DELT_FLG" ).append("\n"); 
		query.append("    , (SELECT /*+ INDEX_DESC(CM XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("              CM.CNMV_YR" ).append("\n"); 
		query.append("         FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("           AND A.YD_CD     = CM.ORG_YD_CD" ).append("\n"); 
		query.append("           AND TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYYMMDD') = TO_CHAR(CM.CNMV_EVNT_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("           AND A.CNTR_STS_CD  = DECODE(CM.MVMT_STS_CD||TRIM(CM.MVMT_CRE_TP_CD), 'XXC', 'LSO', CM.CNMV_RMK)" ).append("\n"); 
		query.append("           AND SUBSTR(REPLACE(CM.MVMT_STS_CD||TRIM(CM.MVMT_CRE_TP_CD), 'XXC', 'E'), -1) = 'E'" ).append("\n"); 
		query.append("           AND ROWNUM                = 1) CNMV_YR" ).append("\n"); 
		query.append("   , (SELECT /*+ INDEX_DESC(CM XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("              CM.CNMV_ID_NO" ).append("\n"); 
		query.append("         FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("           AND A.YD_CD     = CM.ORG_YD_CD" ).append("\n"); 
		query.append("           AND TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYYMMDD') = TO_CHAR(CM.CNMV_EVNT_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("           AND A.CNTR_STS_CD  = DECODE(CM.MVMT_STS_CD||TRIM(CM.MVMT_CRE_TP_CD), 'XXC', 'LSO', CM.CNMV_RMK)" ).append("\n"); 
		query.append("           AND SUBSTR(REPLACE(CM.MVMT_STS_CD||TRIM(CM.MVMT_CRE_TP_CD), 'XXC', 'E'), -1) = 'E'" ).append("\n"); 
		query.append("           AND ROWNUM                = 1) CNMV_ID_NO " ).append("\n"); 
		query.append("   , (SELECT TO_CHAR(TRUNC(NVL(MAX(SM.CNMV_EVNT_DT), SYSDATE - 10000)), 'YYYYMMDD')" ).append("\n"); 
		query.append("       FROM CTM_MOVEMENT SM" ).append("\n"); 
		query.append("      WHERE  A.CNTR_NO               = SM.CNTR_NO" ).append("\n"); 
		query.append("        AND  CASE WHEN A.CNTR_STS_CD IN ('LSI', 'OWN', 'SBI', 'MUI') THEN" ).append("\n"); 
		query.append("                       TRUNC(A.CNTR_STS_EVNT_DT)" ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                       TRUNC(A.CNTR_STS_EVNT_DT)+0.99999" ).append("\n"); 
		query.append("             END > SM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("        AND  SUBSTR(REPLACE(SM.MVMT_STS_CD||TRIM(SM.MVMT_CRE_TP_CD), 'XXC', 'E'), -1) != 'E'" ).append("\n"); 
		query.append("     ) CHK_FM_DT" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(TRUNC(NVL(MIN(SM.CNMV_EVNT_DT), SYSDATE)), 'YYYYMMDD')" ).append("\n"); 
		query.append("       FROM CTM_MOVEMENT SM" ).append("\n"); 
		query.append("      WHERE  A.CNTR_NO               = SM.CNTR_NO" ).append("\n"); 
		query.append("        AND  CASE WHEN A.CNTR_STS_CD IN ('LSI', 'OWN', 'SBI', 'MUI') THEN" ).append("\n"); 
		query.append("                       TRUNC(A.CNTR_STS_EVNT_DT)" ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                       TRUNC(A.CNTR_STS_EVNT_DT)+0.99999" ).append("\n"); 
		query.append("             END < SM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("        AND  SUBSTR(REPLACE(SM.MVMT_STS_CD||TRIM(SM.MVMT_CRE_TP_CD), 'XXC', 'E'), -1) != 'E'" ).append("\n"); 
		query.append("     ) CHK_TO_DT" ).append("\n"); 
		query.append("     , NVL((SELECT TO_CHAR(ATH.PKUP_FM_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("        FROM LSE_ONH_APRO ATH" ).append("\n"); 
		query.append("       WHERE ATH.CNTR_ONH_AUTH_NO IN (A.CNTR_AUTH_NO, A.CNTR_OFFH_AUTH_NO)" ).append("\n"); 
		query.append("         AND  A.CNTR_STS_CD     IN ('LSI', 'SBO', 'MUO')" ).append("\n"); 
		query.append("         AND  ROWNUM            = 1), '19000101') AS PKUP_FM_DT" ).append("\n"); 
		query.append("     , NVL((SELECT TO_CHAR(ATH.PKUP_DUE_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("        FROM LSE_ONH_APRO ATH" ).append("\n"); 
		query.append("       WHERE ATH.CNTR_ONH_AUTH_NO IN (A.CNTR_AUTH_NO, A.CNTR_OFFH_AUTH_NO)" ).append("\n"); 
		query.append("         AND  A.CNTR_STS_CD     IN ('LSI', 'SBO', 'MUO')" ).append("\n"); 
		query.append("         AND  ROWNUM            = 1), TO_CHAR(SYSDATE, 'YYYYMMDD')) AS PKUP_TO_DT    " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("   MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("   LSE_AGREEMENT B," ).append("\n"); 
		query.append("   MDM_VENDOR C," ).append("\n"); 
		query.append("   MST_CONTAINER D," ).append("\n"); 
		query.append("   PARAM P" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.CNTR_NO     = P.CNTR_NO" ).append("\n"); 
		query.append("AND B.AGMT_CTY_CD(+) = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND B.AGMT_SEQ(+)    = A.AGMT_SEQ" ).append("\n"); 
		query.append("AND C.VNDR_SEQ(+)    = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND D.CNTR_NO     = A.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY A.CNTR_STS_EVNT_DT, A.CNTR_STS_SEQ" ).append("\n"); 

	}
}