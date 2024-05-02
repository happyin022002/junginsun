/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchMfsDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchMfsDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMfsDetail
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchMfsDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchMfsDetailRSQL").append("\n"); 
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
		query.append("SELECT BL_NUMBER," ).append("\n"); 
		query.append("       BL_NUMBER2," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       BKG_DEL_CD," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       GRS_WGT," ).append("\n"); 
		query.append("       WGT_UT_CD," ).append("\n"); 
		query.append("       MEAS_QTY," ).append("\n"); 
		query.append("       MEAS_UT_CD," ).append("\n"); 
		query.append("       CUST_NM," ).append("\n"); 
		query.append("       CUST_ADDR," ).append("\n"); 
		query.append("       CUST_NM2," ).append("\n"); 
		query.append("       CUST_ADDR2," ).append("\n"); 
		query.append("       CUST_NM3," ).append("\n"); 
		query.append("       CUST_ADDR3," ).append("\n"); 
		query.append("       DIFF_RMK," ).append("\n"); 
		query.append("       BL_DESC," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_SEAL_NO," ).append("\n"); 
		query.append("       LOCL_TS_FLG," ).append("\n"); 
		query.append("       PST_VSL_CD," ).append("\n"); 
		query.append("       PST_RLY_POD_CD," ).append("\n"); 
		query.append("       FULL_MTY_CD," ).append("\n"); 
		query.append("       CY_OPR_CD," ).append("\n"); 
		query.append("       CALL_SGN_NO," ).append("\n"); 
		query.append("       ETA_DT," ).append("\n"); 
		query.append("       ' ' AS SEQ," ).append("\n"); 
		query.append("       JP_TML_VSL_NO," ).append("\n"); 
		query.append("       MSG_TP," ).append("\n"); 
		query.append("       PRE_VSL_CD," ).append("\n"); 
		query.append("       PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("       APP_FLG," ).append("\n"); 
		query.append("       (SELECT 'Y'" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_JP_WH_ROUT RT" ).append("\n"); 
		query.append("         WHERE RT.CSTMS_CD = MFR.POD_BND" ).append("\n"); 
		query.append("           AND (RT.CSTMS_CD1 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD2 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD3 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD4 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD5 = MFR.DEL_BND)" ).append("\n"); 
		query.append("           AND PST_RLY_POD_CD = ' '" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS BD_TR," ).append("\n"); 
		query.append("       ---------" ).append("\n"); 
		query.append("       (SELECT APRO_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_JP_WH_ROUT RT" ).append("\n"); 
		query.append("         WHERE RT.CSTMS_CD = MFR.POD_BND" ).append("\n"); 
		query.append("           AND (RT.CSTMS_CD1 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD2 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD3 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD4 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD5 = MFR.DEL_BND)" ).append("\n"); 
		query.append("           AND 1 = (SELECT COUNT(*)" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_JP_WH_ROUT RT" ).append("\n"); 
		query.append("                     WHERE RT.CSTMS_CD = MFR.POD_BND" ).append("\n"); 
		query.append("                       AND (RT.CSTMS_CD1 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                            RT.CSTMS_CD2 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                            RT.CSTMS_CD3 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                            RT.CSTMS_CD4 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                            RT.CSTMS_CD5 = MFR.DEL_BND))) AS APRO_NO," ).append("\n"); 
		query.append("       POD_BND," ).append("\n"); 
		query.append("       DEL_BND," ).append("\n"); 
		query.append("       (SELECT TRSP_MOD_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_JP_WH_ROUT RT" ).append("\n"); 
		query.append("         WHERE RT.CSTMS_CD = MFR.POD_BND" ).append("\n"); 
		query.append("           AND (RT.CSTMS_CD1 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD2 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD3 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD4 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                RT.CSTMS_CD5 = MFR.DEL_BND)" ).append("\n"); 
		query.append("           AND 1 = (SELECT COUNT(*)" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_JP_WH_ROUT RT" ).append("\n"); 
		query.append("                     WHERE RT.CSTMS_CD = MFR.POD_BND" ).append("\n"); 
		query.append("                       AND (RT.CSTMS_CD1 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                            RT.CSTMS_CD2 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                            RT.CSTMS_CD3 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                            RT.CSTMS_CD4 = MFR.DEL_BND OR" ).append("\n"); 
		query.append("                            RT.CSTMS_CD5 = MFR.DEL_BND))) AS TRSP_MOD_CD," ).append("\n"); 
		query.append("       DELT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT NVL(A.BL_NO, ' ')||NVL(A.BL_SPLIT_NO, ' ') AS BL_NUMBER," ).append("\n"); 
		query.append("               NVL(A.BL_NO, ' ')||NVL(A.BL_SPLIT_NO, ' ') AS BL_NUMBER2," ).append("\n"); 
		query.append("               NVL(A.POL_CD, ' ') AS POL_CD," ).append("\n"); 
		query.append("               NVL(A.BKG_DEL_CD, ' ') AS BKG_DEL_CD," ).append("\n"); 
		query.append("               DECODE(A.PCK_QTY, NULL, 'N', 0, 'N', 'Y') AS PCK_QTY," ).append("\n"); 
		query.append("               DECODE(A.PCK_TP_CD, NULL, 'N', 'Y') AS PCK_TP_CD," ).append("\n"); 
		query.append("               DECODE(A.GRS_WGT, NULL, 'N', 0, 'N', 'Y') AS GRS_WGT," ).append("\n"); 
		query.append("               DECODE(A.WGT_UT_CD, NULL, 'N', 'Y') AS WGT_UT_CD," ).append("\n"); 
		query.append("               DECODE(A.MEAS_QTY, NULL, 'N', 0, 'N', 'Y') AS MEAS_QTY," ).append("\n"); 
		query.append("               DECODE(A.MEAS_UT_CD, NULL, 'N', 'Y') AS MEAS_UT_CD," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(C1.CUST_NM)), NULL, 'N', 'Y') AS CUST_NM," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(C1.CUST_ADDR)), NULL, 'N', 'Y') AS CUST_ADDR," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(C2.CUST_NM)), NULL, 'N', 'Y') AS CUST_NM2," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(C2.CUST_ADDR)), NULL, 'N', 'Y') AS CUST_ADDR2," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(C3.CUST_NM)), NULL, 'N', 'Y') AS CUST_NM3," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(C3.CUST_ADDR)), NULL, 'N', 'Y') AS CUST_ADDR3," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(D.DIFF_RMK)), NULL, 'N', 'Y') AS DIFF_RMK," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(D.BL_DESC)), NULL, 'N', 'Y') AS BL_DESC," ).append("\n"); 
		query.append("               NVL(B.CNTR_NO, ' ') AS CNTR_NO," ).append("\n"); 
		query.append("               DECODE(LENGTH(RTRIM(B.CNTR_SEAL_NO)), NULL, 'N', 'Y') AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("               NVL(A.LOCL_TS_IND_CD, ' ') AS LOCL_TS_FLG," ).append("\n"); 
		query.append("               NVL(A.PST_VSL_CD||A.PST_SKD_VOY_NO||A.PST_SKD_DIR_CD, ' ') AS PST_VSL_CD," ).append("\n"); 
		query.append("               NVL(A.PST_RLY_POD_CD, ' ') AS PST_RLY_POD_CD," ).append("\n"); 
		query.append("               NVL(A.FULL_MTY_CD, ' ') AS FULL_MTY_CD," ).append("\n"); 
		query.append("               NVL(A.CY_OPR_ID, ' ') AS CY_OPR_CD," ).append("\n"); 
		query.append("               NVL(@[in_call_sgn_no], ' ') AS CALL_SGN_NO," ).append("\n"); 
		query.append("               NVL(TO_CHAR(TO_DATE(@[in_eta_dt], 'YYYY-MM-DD'), 'YYYY-MM-DD'), ' ') AS ETA_DT," ).append("\n"); 
		query.append("               NVL(A.JP_TML_VSL_NO, DECODE((SELECT DECODE(NVL(A.ACT_CRR_CD, B.CRR_CD), COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), 'Y', 'N')" ).append("\n"); 
		query.append("                                              FROM VSK_VSL_SKD A," ).append("\n"); 
		query.append("                                                   MDM_VSL_CNTR B" ).append("\n"); 
		query.append("                                             WHERE A.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                               AND A.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                               AND A.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                               AND A.VSL_CD = B.VSL_CD ), 'Y', SUBSTR(@[in_vvd_cd], 5, 5), ' ')) AS JP_TML_VSL_NO," ).append("\n"); 
		query.append("               DECODE(A.PRE_SKD_VOY_NO, NULL, 'MFR', 'CMF03') AS MSG_TP," ).append("\n"); 
		query.append("               NVL(A.PRE_VSL_CD||A.PRE_SKD_VOY_NO||A.PRE_SKD_DIR_CD, ' ') AS PRE_VSL_CD," ).append("\n"); 
		query.append("               NVL(A.PRE_RLY_PORT_CD, ' ') AS PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("               DECODE(A.APRO_NO, NULL, 'N', 'Y') AS APP_FLG," ).append("\n"); 
		query.append("               (SELECT WH.CSTMS_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("                       BKG_VVD VVD," ).append("\n"); 
		query.append("                       BKG_CSTMS_JP_WH WH" ).append("\n"); 
		query.append("                 WHERE A.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.POD_CD = @[in_pod_cd]" ).append("\n"); 
		query.append("                   AND WH.YD_CD = VVD.POD_YD_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS POD_BND," ).append("\n"); 
		query.append("               (SELECT WH.CSTMS_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("                       BKG_CSTMS_JP_WH WH" ).append("\n"); 
		query.append("                 WHERE A.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                   AND WH.YD_CD = BKG.DEL_NOD_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS DEL_BND," ).append("\n"); 
		query.append("               A.DELT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_JP_BL A," ).append("\n"); 
		query.append("               BKG_CSTMS_JP_BL_CNTR B," ).append("\n"); 
		query.append("               BKG_CSTMS_JP_BL_MK D," ).append("\n"); 
		query.append("               BKG_CSTMS_JP_BL_CUST C1," ).append("\n"); 
		query.append("               BKG_CSTMS_JP_BL_CUST C2," ).append("\n"); 
		query.append("               BKG_CSTMS_JP_BL_CUST C3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE A.VSL_CD = @[in_vsl_cd]" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("#if (${in_pol_cd} != '')" ).append("\n"); 
		query.append("           AND A.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A.POD_CD = @[in_pod_cd]" ).append("\n"); 
		query.append("#if (${in_del_cd} != '')" ).append("\n"); 
		query.append("           AND A.BKG_DEL_CD = @[in_del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_msg_tp} != '')" ).append("\n"); 
		query.append("#if (${in_msg_tp} == 'MFR')" ).append("\n"); 
		query.append("           AND A.PRE_SKD_VOY_NO IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND A.PRE_SKD_VOY_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A.JP_BL_STS_CD = 'A'" ).append("\n"); 
		query.append("           AND A.BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("           AND A.BL_SPLIT_NO = B.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("           AND B.JP_CSTMS_CNTR_STS_CD(+) = 'A'" ).append("\n"); 
		query.append("           AND A.BL_NO = D.BL_NO(+)" ).append("\n"); 
		query.append("           AND A.BL_SPLIT_NO = D.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("           AND D.BL_SEQ(+) = 1" ).append("\n"); 
		query.append("           AND A.BL_NO = C1.BL_NO(+)" ).append("\n"); 
		query.append("           AND A.BL_SPLIT_NO = C1.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("           AND C1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("           AND A.BL_NO = C2.BL_NO(+)" ).append("\n"); 
		query.append("           AND A.BL_SPLIT_NO = C2.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("           AND C2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("           AND A.BL_NO = C3.BL_NO(+)" ).append("\n"); 
		query.append("           AND A.BL_SPLIT_NO = C3.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("           AND C3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("#if (${in_err_gb} == 'E')" ).append("\n"); 
		query.append("           AND (DECODE(A.PCK_QTY, NULL, 'N', 0, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(A.PCK_TP_CD, NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(A.GRS_WGT, NULL, 'N', 0, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(A.WGT_UT_CD, NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(A.MEAS_QTY, NULL, 'N', 0, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(A.MEAS_UT_CD, NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(C1.CUST_NM)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(C1.CUST_ADDR)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(C2.CUST_NM)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(C2.CUST_ADDR)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(C3.CUST_NM)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(C3.CUST_ADDR)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(B.CNTR_NO)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(B.CNTR_SEAL_NO)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(D.DIFF_RMK)), NULL, 'N', 'Y') = 'N' OR" ).append("\n"); 
		query.append("                DECODE(LENGTH(RTRIM(D.BL_DESC)), NULL, 'N', 'Y') = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_bl_type} == '1')" ).append("\n"); 
		query.append("           AND A.LOCL_TS_IND_CD <> 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_bl_type} == '2')" ).append("\n"); 
		query.append("           AND A.LOCL_TS_IND_CD = 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) MFR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY FULL_MTY_CD," ).append("\n"); 
		query.append("          BL_NUMBER" ).append("\n"); 

	}
}