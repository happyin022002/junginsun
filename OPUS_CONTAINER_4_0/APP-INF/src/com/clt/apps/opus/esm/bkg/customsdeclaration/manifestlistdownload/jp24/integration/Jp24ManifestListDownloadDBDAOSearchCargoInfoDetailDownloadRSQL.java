/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailDownloadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailDownloadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailDownloadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_postfix",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_prefix",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_hdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailDownloadRSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER (ORDER BY BL_NO, VVD_POL_CD, BKG_POD_CD, BKG_DEL_CD) AS SEQ," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       MST_BL," ).append("\n"); 
		query.append("       BKG_POL_CD," ).append("\n"); 
		query.append("       VVD_POL_CD," ).append("\n"); 
		query.append("       BKG_POD_CD," ).append("\n"); 
		query.append("       VVD_POD_CD," ).append("\n"); 
		query.append("       BKG_DEL_CD," ).append("\n"); 
		query.append("       A_S_TYPE," ).append("\n"); 
		query.append("       A_CMR_KIND," ).append("\n"); 
		query.append("       -- 1. AMR/CMR 구분 2. ATD 체크 3. SA111 체크" ).append("\n"); 
		query.append("       CASE WHEN A_S_TYPE = ' ' AND PRE_T_S_TYPE = 'AMR' THEN CASE WHEN ATD_SND = ' ' THEN 'AMR' ELSE 'CMR' END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND A_CMR_KIND = '1' THEN CASE WHEN ATD_SND = ' ' THEN 'AMR' ELSE 'CMR' END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = ' ' AND (PRE_T_S_TYPE = 'CMR' OR PRE_T_S_TYPE = 'CMR_N') THEN CASE WHEN ATD_SND <> ' ' THEN 'CMR' END -- cmr 최초" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'CMR' THEN" ).append("\n"); 
		query.append("                  CASE WHEN ATD_SND <> ' ' THEN" ).append("\n"); 
		query.append("                       CASE WHEN SA111_RST <> ' ' THEN 'CMR'" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                       ' '" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                  ELSE 'CMR'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'CMR_N' THEN CASE WHEN ATD_SND <> ' ' THEN 'CMR' END -- 재전송 cmr" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'CMR_N' THEN CASE WHEN ATD_SND <> ' ' THEN 'CMR' END -- 재전송 cmr" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'CMR' THEN CASE WHEN ATD_SND <> ' ' THEN" ).append("\n"); 
		query.append("                  CASE WHEN SA111_RST <> ' ' THEN 'CMR'" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                       ' '" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                  ELSE 'CMR'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'AMR' THEN CASE WHEN ATD_SND = ' ' THEN 'AMR' ELSE 'CMR' END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'AMR' THEN CASE WHEN ATD_SND = ' ' THEN 'AMR' ELSE 'CMR' END" ).append("\n"); 
		query.append("       END AS T_S_TYPE," ).append("\n"); 
		query.append("       CASE WHEN A_S_TYPE = ' ' AND PRE_T_S_TYPE = 'AMR' THEN CASE WHEN ATD_SND = ' ' THEN '9' ELSE '2' END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND A_CMR_KIND = '1' THEN CASE WHEN ATD_SND = ' ' THEN '9' ELSE '2' END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = ' ' AND (PRE_T_S_TYPE = 'CMR' OR PRE_T_S_TYPE = 'CMR_N') THEN CASE WHEN ATD_SND <> ' ' THEN '2' END -- cmr 2" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'CMR' THEN" ).append("\n"); 
		query.append("                  CASE WHEN ATD_SND <> ' ' THEN" ).append("\n"); 
		query.append("                       CASE WHEN SA111_RST <> ' ' THEN '5'" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                       ' '" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                  ELSE '5'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'CMR_N' THEN CASE WHEN ATD_SND <> ' ' THEN '2' END -- 재전송 cmr" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'CMR_N' THEN CASE WHEN ATD_SND <> ' ' THEN '2' END -- 재전송 cmr" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'CMR' THEN" ).append("\n"); 
		query.append("                  CASE WHEN ATD_SND <> ' ' THEN" ).append("\n"); 
		query.append("                       CASE WHEN SA111_RST <> ' ' THEN CASE WHEN A_CMR_KIND = '2' AND SCMR_RST = ' ' THEN '2' ELSE '5' END" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                       ' '" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                  ELSE '5'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'AMR' THEN CASE WHEN ATD_SND = ' ' THEN '9' ELSE CASE WHEN A_CMR_KIND = '2' AND (SCMR_RST = ' ' OR SCMR_RST = 'Error') THEN '2' ELSE '5' END END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'AMR' THEN CASE WHEN ATD_SND = ' ' THEN '9' ELSE '2' END" ).append("\n"); 
		query.append("       END AS T_CMR_KIND," ).append("\n"); 
		query.append("       -- T_CMR_KIND," ).append("\n"); 
		query.append("       S_DT," ).append("\n"); 
		query.append("       SAMR_DT," ).append("\n"); 
		query.append("       SAMR_RST," ).append("\n"); 
		query.append("       TAMR_RST," ).append("\n"); 
		query.append("       SA111_DT," ).append("\n"); 
		query.append("       SA111_RST," ).append("\n"); 
		query.append("       SCMR_DT," ).append("\n"); 
		query.append("       SCMR_RST," ).append("\n"); 
		query.append("       SC108_DT," ).append("\n"); 
		query.append("       SC108_RST," ).append("\n"); 
		query.append("       SC108_RST_DTL," ).append("\n"); 
		query.append("       SHPR_NM," ).append("\n"); 
		query.append("       SHPR_ADDR," ).append("\n"); 
		query.append("       SHPR_CNT_CD," ).append("\n"); 
		query.append("       SHPR_PHN_NO," ).append("\n"); 
		query.append("       CNEE_NM," ).append("\n"); 
		query.append("       CNEE_ADDR," ).append("\n"); 
		query.append("       CNEE_CNT_CD," ).append("\n"); 
		query.append("       CNEE_PHN_NO," ).append("\n"); 
		query.append("       NTFY_NM," ).append("\n"); 
		query.append("       NTFY_ADDR," ).append("\n"); 
		query.append("       NTFY_CNT_CD," ).append("\n"); 
		query.append("       NTFY_PHN_NO," ).append("\n"); 
		query.append("       CMDT_CD," ).append("\n"); 
		query.append("       CMDT_HS_CD," ).append("\n"); 
		query.append("       MK_DESC," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       ACT_WGT," ).append("\n"); 
		query.append("       WGT_UT_CD," ).append("\n"); 
		query.append("       MEAS_QTY," ).append("\n"); 
		query.append("       MEAS_UT_CD," ).append("\n"); 
		query.append("       IMDG_CLS," ).append("\n"); 
		query.append("       UN_NO," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       POD_DIV," ).append("\n"); 
		query.append("       RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("       SHPR_NM||SHPR_ADDR||SHPR_CNT_CD||SHPR_PHN_NO||CNEE_NM||CNEE_ADDR||CNEE_CNT_CD||CNEE_PHN_NO||NTFY_NM||NTFY_ADDR||NTFY_CNT_CD||NTFY_PHN_NO||CMDT_CD||CMDT_HS_CD||MK_DESC||PCK_QTY||PCK_TP_CD||ACT_WGT||WGT_UT_CD||MEAS_QTY||MEAS_UT_CD||IMDG_CLS||UN_NO AS ERR_INFO," ).append("\n"); 
		query.append("       S_INFO" ).append("\n"); 
		query.append("       --, ATD_SND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (SELECT BL_NO," ).append("\n"); 
		query.append("               MST_BL," ).append("\n"); 
		query.append("               BKG_POL_CD," ).append("\n"); 
		query.append("               VVD_POL_CD," ).append("\n"); 
		query.append("               BKG_POD_CD," ).append("\n"); 
		query.append("               VVD_POD_CD," ).append("\n"); 
		query.append("               BKG_DEL_CD," ).append("\n"); 
		query.append("               NVL(SUBSTR(S_INFO, 17, 3), ' ') AS A_S_TYPE," ).append("\n"); 
		query.append("               NVL(SUBSTR(S_INFO, 35, 1), ' ') AS A_CMR_KIND," ).append("\n"); 
		query.append("               CASE" ).append("\n"); 
		query.append("                  WHEN S_INFO IS NULL OR SUBSTR(S_INFO, 20, 9) <> @[vvd] OR" ).append("\n"); 
		query.append("                       SUBSTR(S_INFO, 29, 6) <> @[pol_cd]||NVL(@[pol_split_no], ' ') OR" ).append("\n"); 
		query.append("                       NVL(SUBSTR(AMR_SAMR, 17, 5), ' ') <> '00000' OR" ).append("\n"); 
		query.append("                       TRIM(SUBSTR(S_INFO, 46, 15)) <> @[call_sgn_no] OR" ).append("\n"); 
		query.append("                       TRIM(SUBSTR(S_INFO, 36, 10)) <> @[ib_cssm_voy_no]" ).append("\n"); 
		query.append("                     THEN" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                           WHEN NVL(ATD_SND, 'N_ATD') = 'N_ATD' THEN 'AMR'" ).append("\n"); 
		query.append("                           ELSE 'CMR_N'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                  ELSE 'CMR'" ).append("\n"); 
		query.append("               END AS PRE_T_S_TYPE," ).append("\n"); 
		query.append("               NVL(SUBSTR(S_INFO, 1, 16), ' ') AS S_DT," ).append("\n"); 
		query.append("               NVL(SUBSTR(AMR_SAMR, 1, 16), ' ') AS SAMR_DT," ).append("\n"); 
		query.append("               --NVL(SUBSTR(AMR_SAMR, 17), ' ') AS SAMR_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(AMR_SAMR, 17, 5), '00000', 'Success', NULL, ' ', 'Error'), ' ') AS SAMR_RST," ).append("\n"); 
		query.append("               NVL2(AMR_TAMR, 'Tech File', ' ') AS TAMR_RST," ).append("\n"); 
		query.append("               NVL(SUBSTR(AMR_SAS111, 2, 16), ' ') AS SA111_DT," ).append("\n"); 
		query.append("               --NVL(SUBSTR(AMR_SAS111, 17), ' ') AS SA111_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(AMR_SAS111, 1, 1), '1', 'Clear', SUBSTR(AMR_SAS111, 18, 3)), ' ') AS SA111_RST," ).append("\n"); 
		query.append("               NVL(SUBSTR(CMR_SCMR, 1, 16), ' ') AS SCMR_DT," ).append("\n"); 
		query.append("               --NVL(SUBSTR(CMR_SCMR, 17), ' ') AS SCMR_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(CMR_SCMR, 17, 5), '00000', 'Success', NULL, ' ', 'Error'), ' ') AS SCMR_RST," ).append("\n"); 
		query.append("               NVL(SUBSTR(CMR_SAS108, 1, 16), ' ') AS SC108_DT," ).append("\n"); 
		query.append("               --NVL(SUBSTR(CMR_SAS108, 17), ' ') AS SC108_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(CMR_SAS108, 17, 11), '/////', 'Success', NULL, ' ', 'Error'), ' ') AS SC108_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(CMR_SAS108, 17, 11), '/////', ' ', NULL, ' ', SUBSTR(CMR_SAS108, 17)), ' ') AS SC108_RST_DTL," ).append("\n"); 
		query.append("               SHPR_NM," ).append("\n"); 
		query.append("               SHPR_ADDR," ).append("\n"); 
		query.append("               SHPR_CNT_CD," ).append("\n"); 
		query.append("               SHPR_PHN_NO," ).append("\n"); 
		query.append("               CNEE_NM," ).append("\n"); 
		query.append("               CNEE_ADDR," ).append("\n"); 
		query.append("               CNEE_CNT_CD," ).append("\n"); 
		query.append("               CNEE_PHN_NO," ).append("\n"); 
		query.append("               NTFY_NM," ).append("\n"); 
		query.append("               NTFY_ADDR," ).append("\n"); 
		query.append("               NTFY_CNT_CD," ).append("\n"); 
		query.append("               NTFY_PHN_NO," ).append("\n"); 
		query.append("               CMDT_CD," ).append("\n"); 
		query.append("               CMDT_HS_CD," ).append("\n"); 
		query.append("               MK_DESC," ).append("\n"); 
		query.append("               PCK_QTY," ).append("\n"); 
		query.append("               PCK_TP_CD," ).append("\n"); 
		query.append("               ACT_WGT," ).append("\n"); 
		query.append("               WGT_UT_CD," ).append("\n"); 
		query.append("               MEAS_QTY," ).append("\n"); 
		query.append("               MEAS_UT_CD," ).append("\n"); 
		query.append("               IMDG_CLS," ).append("\n"); 
		query.append("               UN_NO," ).append("\n"); 
		query.append("               CNTR_NO," ).append("\n"); 
		query.append("               POD_DIV," ).append("\n"); 
		query.append("               RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("               S_INFO," ).append("\n"); 
		query.append("               NVL(ATD_SND, ' ') AS ATD_SND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("               (SELECT ADVBL.BL_NO," ).append("\n"); 
		query.append("                       ADVBL.BKG_POL_CD," ).append("\n"); 
		query.append("                       ADVBL.POL_CD AS VVD_POL_CD," ).append("\n"); 
		query.append("                       (SELECT B.POD_CD FROM BKG_BOOKING B WHERE ADVBL.BL_NO = B.BL_NO) AS BKG_POD_CD," ).append("\n"); 
		query.append("                       ADVBL.POD_CD AS VVD_POD_CD," ).append("\n"); 
		query.append("                       ADVBL.BKG_DEL_CD," ).append("\n"); 
		query.append("                       DECODE(ADVBL.RVIS_CNTR_CUST_TP_CD, 'N', 'C', 'B', 'S', 'S') AS MST_BL," ).append("\n"); 
		query.append("                       CNTR.CNTR_NO," ).append("\n"); 
		query.append("                       DECODE(SHPR.CUST_NM, NULL, 'N', 'Y') AS SHPR_NM," ).append("\n"); 
		query.append("                       DECODE(SHPR.CUST_ADDR, NULL, 'N', 'Y') AS SHPR_ADDR," ).append("\n"); 
		query.append("                       DECODE(SHPR.CUST_CNT_CD, NULL, 'N', 'Y') AS SHPR_CNT_CD," ).append("\n"); 
		query.append("                       DECODE(SHPR.PHN_NO, NULL, 'N', 'Y') AS SHPR_PHN_NO," ).append("\n"); 
		query.append("                       DECODE(CNEE.CUST_NM, NULL, 'N', 'Y') AS CNEE_NM," ).append("\n"); 
		query.append("                       DECODE(CNEE.CUST_ADDR, NULL, 'N', 'Y') AS CNEE_ADDR," ).append("\n"); 
		query.append("                       DECODE(CNEE.CUST_CNT_CD, NULL, 'N', 'Y') AS CNEE_CNT_CD," ).append("\n"); 
		query.append("                       DECODE(CNEE.PHN_NO, NULL, 'N', 'Y') AS CNEE_PHN_NO," ).append("\n"); 
		query.append("                       DECODE(NTFY.CUST_NM, NULL, 'N', 'Y') AS NTFY_NM," ).append("\n"); 
		query.append("                       DECODE(NTFY.CUST_ADDR, NULL, 'N', 'Y') AS NTFY_ADDR," ).append("\n"); 
		query.append("                       DECODE(NTFY.CUST_CNT_CD, NULL, 'N', 'Y') AS NTFY_CNT_CD," ).append("\n"); 
		query.append("                       DECODE(NTFY.PHN_NO, NULL, 'N', 'Y') AS NTFY_PHN_NO," ).append("\n"); 
		query.append("                       DECODE(ADVBL.CMDT_CD, NULL, DECODE(LENGTH(BMD.BL_DESC), 0, 'N', 'Y'), 'Y') AS CMDT_CD," ).append("\n"); 
		query.append("                       DECODE(BMD.CMDT_HS_CD, NULL, 'N', 'Y') AS CMDT_HS_CD," ).append("\n"); 
		query.append("                       DECODE(LENGTH(BMD.DIFF_RMK), 0, 'N', 'Y') AS MK_DESC," ).append("\n"); 
		query.append("                       DECODE(ADVBL.PCK_QTY, NULL, 'N', 'Y') AS PCK_QTY," ).append("\n"); 
		query.append("                       DECODE(ADVBL.PCK_TP_CD, NULL, 'N', 'Y') AS PCK_TP_CD," ).append("\n"); 
		query.append("                       DECODE(ADVBL.GRS_WGT, NULL, 'N', 'Y') AS ACT_WGT," ).append("\n"); 
		query.append("                       DECODE(ADVBL.WGT_UT_CD, NULL, 'N', 'Y') AS WGT_UT_CD," ).append("\n"); 
		query.append("                       DECODE(ADVBL.MEAS_QTY, NULL, 'N', 'Y') AS MEAS_QTY," ).append("\n"); 
		query.append("                       DECODE(ADVBL.MEAS_UT_CD, NULL, 'N', 'Y') AS MEAS_UT_CD," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                          WHEN ADVBL.DCGO_FLG = 'Y' AND ADVBL.IMDG_UN_NO IS NOT NULL" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                          WHEN ADVBL.DCGO_FLG = 'Y' AND ADVBL.IMDG_UN_NO IS NULL" ).append("\n"); 
		query.append("                             THEN 'N'" ).append("\n"); 
		query.append("                          ELSE 'Y'" ).append("\n"); 
		query.append("                       END AS IMDG_CLS," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                          WHEN ADVBL.DCGO_FLG = 'Y' AND ADVBL.IMDG_CLSS_CD IS NOT NULL" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                          WHEN ADVBL.DCGO_FLG = 'Y' AND ADVBL.IMDG_CLSS_CD IS NULL" ).append("\n"); 
		query.append("                             THEN 'N'" ).append("\n"); 
		query.append("                          ELSE 'Y'" ).append("\n"); 
		query.append("                       END AS UN_NO," ).append("\n"); 
		query.append("                       (SELECT /*+ INDEX_DESC(RCV XAK1BKG_CSTMS_ADV_JP_RCV_LOG) */" ).append("\n"); 
		query.append("                               TO_CHAR(RCV.RCV_DT, 'YYYY-MM-DD HH24:MI')||RCV.RCV_KEY_DAT_CTNT" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_RCV_LOG RCV" ).append("\n"); 
		query.append("                         WHERE RCV.BKG_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                           AND RCV.JP_SVC_ID = 'SAMR'" ).append("\n"); 
		query.append("                           AND RCV.JP_MSG_TP_ID = 'SAMR'" ).append("\n"); 
		query.append("                           AND RCV.RCV_KEY_DAT_CTNT NOT LIKE 'W%'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS AMR_SAMR," ).append("\n"); 
		query.append("                       (SELECT /*+ INDEX_DESC(RCV XAK1BKG_CSTMS_ADV_JP_RCV_LOG) */" ).append("\n"); 
		query.append("                               TO_CHAR(RCV.RCV_DT, 'YYYY-MM-DD HH24:MI')||RCV.RCV_KEY_DAT_CTNT" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_RCV_LOG RCV" ).append("\n"); 
		query.append("                         WHERE RCV.BKG_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                           AND RCV.JP_SVC_ID = 'TAMR'" ).append("\n"); 
		query.append("                           AND RCV.JP_MSG_TP_ID = 'TAMR'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS AMR_TAMR," ).append("\n"); 
		query.append("                       (SELECT MAX((DECODE(RCV.JP_BAT_NO, NULL, ' ', RCV.JP_BAT_NO))||TO_CHAR(RCV.UPD_DT, 'YYYY-MM-DD HH24:MI')||RCV.RCV_KEY_DAT_CTNT)" ).append("\n"); 
		query.append("                              -- /*+ INDEX_DESC(RCV XAK1BKG_CSTMS_ADV_JP_RCV_LOG) */" ).append("\n"); 
		query.append("                              -- TO_CHAR(RCV.UPD_DT, 'YYYY-MM-DD HH24:MI')||RCV.RCV_KEY_DAT_CTNT||DECODE(RCV.JP_BAT_NO, NULL, ' ', RCV.JP_BAT_NO)" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_RCV_LOG RCV" ).append("\n"); 
		query.append("                         WHERE RCV.BKG_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                           AND RCV.JP_SVC_ID = 'SAS111'" ).append("\n"); 
		query.append("                           AND RCV.JP_MSG_TP_ID = 'SAS111'" ).append("\n"); 
		query.append("                           AND NVL(RCV.JP_BAT_NO, 0) < 1" ).append("\n"); 
		query.append("                          -- AND ROWNUM = 1" ).append("\n"); 
		query.append("                       ) AS AMR_SAS111," ).append("\n"); 
		query.append("                       (SELECT /*+ INDEX_DESC(RCV XAK1BKG_CSTMS_ADV_JP_RCV_LOG) */" ).append("\n"); 
		query.append("                               TO_CHAR(RCV.RCV_DT, 'YYYY-MM-DD HH24:MI')||RCV.RCV_KEY_DAT_CTNT" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_RCV_LOG RCV" ).append("\n"); 
		query.append("                         WHERE RCV.BKG_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                           AND RCV.JP_SVC_ID = 'SCMR'" ).append("\n"); 
		query.append("                           AND RCV.JP_MSG_TP_ID = 'SCMR'" ).append("\n"); 
		query.append("                           AND RCV.RCV_KEY_DAT_CTNT NOT LIKE 'W%'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS CMR_SCMR," ).append("\n"); 
		query.append("                       (SELECT /*+ INDEX_DESC(RCV XAK1BKG_CSTMS_ADV_JP_RCV_LOG) */" ).append("\n"); 
		query.append("                               TO_CHAR(RCV.RCV_DT, 'YYYY-MM-DD HH24:MI')||RCV.RCV_KEY_DAT_CTNT" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_RCV_LOG RCV" ).append("\n"); 
		query.append("                         WHERE RCV.BKG_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                           AND RCV.JP_SVC_ID = 'SAS108'" ).append("\n"); 
		query.append("                           AND RCV.JP_MSG_TP_ID = 'SAS108'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS CMR_SAS108," ).append("\n"); 
		query.append("                       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_ADV_JP_SND_LOG) */" ).append("\n"); 
		query.append("                               TO_CHAR(SND.SND_DT, 'YYYY-MM-DD HH24:MI')||SND.JP_SND_LOG_ID||VSL_CD||SKD_VOY_NO||SKD_DIR_CD||POL_CD||DECODE(YD_SEQ, NULL, ' ', YD_SEQ)||LOG_SEQ||RPAD(IB_CSSM_VOY_NO, 10, ' ')||RPAD(CALL_SGN_NO, 15, ' ')" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n"); 
		query.append("                         WHERE ADVBL.BL_NO = SND.BL_NO(+)" ).append("\n"); 
		query.append("                           AND SND.JP_SND_LOG_ID(+) NOT LIKE 'BLL%'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS S_INFO," ).append("\n"); 
		query.append("                       (SELECT JP_SND_LOG_ID ATD_SND" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n"); 
		query.append("                         WHERE SND.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                           AND SND.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           AND SND.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                           AND SND.JP_SND_LOG_ID = 'ATD'" ).append("\n"); 
		query.append("                           AND SND.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS ATD_SND," ).append("\n"); 
		query.append("                       DECODE(ADVBL.POD_CD, VVD.POD_CD, 'DIR', 'T/S') AS POD_DIV," ).append("\n"); 
		query.append("                       DECODE(ADVBL.RVIS_CNTR_CUST_TP_CD, 'C', 'N', 'S', 'B', ADVBL.RVIS_CNTR_CUST_TP_CD) AS RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  FROM BKG_VVD VVD," ).append("\n"); 
		query.append("                       BKG_BOOKING BKG," ).append("\n"); 
		query.append("                       BKG_CSTMS_ADV_JP_BL ADVBL," ).append("\n"); 
		query.append("                       BKG_CSTMS_ADV_JP_CUST SHPR," ).append("\n"); 
		query.append("                       BKG_CSTMS_ADV_JP_CUST CNEE," ).append("\n"); 
		query.append("                       BKG_CSTMS_ADV_JP_CUST NTFY," ).append("\n"); 
		query.append("                       BKG_CSTMS_ADV_JP_MK BMD," ).append("\n"); 
		query.append("                       BKG_CSTMS_ADV_JP_CNTR CNTR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                   AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#if (${lt_div} == 'L')" ).append("\n"); 
		query.append("                   AND VVD.POD_CD = BKG.POD_CD" ).append("\n"); 
		query.append("#elseif (${lt_div} == 'T')" ).append("\n"); 
		query.append("                   AND VVD.POD_CD <> BKG.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_div} == 'BKG_POD' && ${bkg_pod_hdr} != '')" ).append("\n"); 
		query.append("                   AND VVD.POD_CD LIKE @[vvd_pod_prefix]||'%'" ).append("\n"); 
		query.append("                   AND BKG.POD_CD LIKE @[bkg_pod_hdr]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                   AND VVD.POD_CD LIKE @[vvd_pod_prefix]||@[vvd_pod_postfix]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${doc_usr_id} != '')" ).append("\n"); 
		query.append("                   AND BKG.DOC_USR_ID = @[doc_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.BL_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = CNTR.BL_NO" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = SHPR.BL_NO(+)" ).append("\n"); 
		query.append("                   AND SHPR.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = CNEE.BL_NO(+)" ).append("\n"); 
		query.append("                   AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = NTFY.BL_NO(+)" ).append("\n"); 
		query.append("                   AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("                   AND BKG.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = BMD.BL_NO" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${error_div} == 'ERR')" ).append("\n"); 
		query.append("   AND (SHPR_NM = 'N' OR SHPR_ADDR = 'N' OR SHPR_CNT_CD = 'N' OR SHPR_PHN_NO = 'N' OR" ).append("\n"); 
		query.append("        CNEE_NM = 'N' OR CNEE_ADDR = 'N' OR CNEE_CNT_CD = 'N' OR CNEE_PHN_NO = 'N' OR" ).append("\n"); 
		query.append("        NTFY_NM = 'N' OR NTFY_ADDR = 'N' OR NTFY_CNT_CD = 'N' OR NTFY_PHN_NO = 'N' OR" ).append("\n"); 
		query.append("        CMDT_CD = 'N' OR CMDT_HS_CD = 'N' OR MK_DESC = 'N' OR PCK_QTY = 'N' OR" ).append("\n"); 
		query.append("        PCK_TP_CD = 'N' OR ACT_WGT = 'N' OR WGT_UT_CD = 'N' OR MEAS_QTY = 'N' OR" ).append("\n"); 
		query.append("        MEAS_UT_CD = 'N' OR IMDG_CLS = 'N' OR UN_NO = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cstms_rslts} == 'ALL_RSLT')" ).append("\n"); 
		query.append("   AND (SA111_RST <> ' ' OR SC108_RST <> ' ' OR SAMR_RST <> ' ' OR SCMR_RST <> ' ')" ).append("\n"); 
		query.append("#elseif (${cstms_rslts} == 'SAS111')" ).append("\n"); 
		query.append("   AND SA111_RST <> ' '" ).append("\n"); 
		query.append("#elseif (${cstms_rslts} == 'SAS108')" ).append("\n"); 
		query.append("   AND SC108_RST <> ' '" ).append("\n"); 
		query.append("#elseif (${cstms_rslts} == 'SAMR')" ).append("\n"); 
		query.append("   AND SAMR_RST <> ' '" ).append("\n"); 
		query.append("#elseif (${cstms_rslts} == 'SCMR')" ).append("\n"); 
		query.append("   AND SCMR_RST <> ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY BL_NO," ).append("\n"); 
		query.append("          CNTR_NO" ).append("\n"); 

	}
}