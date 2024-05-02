/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailDownloadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		params.put("pod_prefix",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_postfix",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER (ORDER BY BL_NO, POL_CD, POD_CD, BKG_DEL_CD) AS SEQ," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       MST_BL," ).append("\n"); 
		query.append("       BKG_POL_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       BKG_POD_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       BKG_DEL_CD," ).append("\n"); 
		query.append("	   BB_CGO_FLG," ).append("\n"); 
		query.append("       A_S_TYPE," ).append("\n"); 
		query.append("       A_CMR_KIND," ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("   1. AMR/CMR 구분 2. ATD 체크 3. SA111 체크 ---------------------------------------------------------------------- 수정" ).append("\n"); 
		query.append("              미 전송 BL이고, VVD,POD등이 최초전송이거나 바뀐 상태, ATD신고 전이면 AMR 최초 전송 , 후이면 CMR-ADD로 전송" ).append("\n"); 
		query.append("               AMR/CMR 기신고 BL > ATD 신고 전이면 CMR, 후이면 초치 사항이 없으면 CMR전송하지 않는다." ).append("\n"); 
		query.append("               AMR/CMR 기신고 BL > VVD,POL등이 바뀐 상태(T/S건) > ATD신고 전이면 AMR, 후이면 CMR  " ).append("\n"); 
		query.append("       CASE WHEN A_S_TYPE = ' '            AND PRE_T_S_TYPE = 'AMR' THEN DECODE(ATD_SND, ' ', 'AMR','CMR') " ).append("\n"); 
		query.append("            WHEN A_S_TYPE IN ('AMR','CMR') AND PRE_T_S_TYPE = 'CMR' THEN DECODE(ATD_SND, ' ', 'CMR', DECODE(SA111_RST, ' ', ' ', 'CMR'))" ).append("\n"); 
		query.append("            WHEN A_S_TYPE IN ('AMR','CMR') AND PRE_T_S_TYPE = 'AMR' THEN DECODE(ATD_SND, ' ', 'AMR','CMR')" ).append("\n"); 
		query.append("       END AS T_S_TYPE," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("               해당 BL은 전송 안했어도, VVD의 타 BL들이 AMR 신고 및 ATD 전이면 AMR 최초전송, 후이면 CMR-ADD로 전송, " ).append("\n"); 
		query.append("               AMR/CMR 기신고 BL > ATD 신고 전이면 CMR, 후이면 초치 사항이 없으면 CMR전송하지 않는다." ).append("\n"); 
		query.append("               CMR 신고 BL       > ATD 신고 전이면 CMR, 후이면 초치 사항이 없으면 CMR 전송하지 않음. 조치사항이 있고 기존 전송이 ADD(2)이면 ADD, 아니면 Correction 5" ).append("\n"); 
		query.append("               AMR/CMR 기신고 BL > VVD,POL등이 바뀐 상태(T/S건) > ATD신고 전이면 최초전송 9, 후이면 기 Add전송이고 조치사항이 없거나 Error일경우 Add 2, 아니면 Correction 5" ).append("\n"); 
		query.append("               AMR 기신고 BL     > VVD,POL등이 바뀐 상태(T/S건) > ATD신고 전이면 최초전송 9, 후이면 기 Add 2 전송" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("       CASE WHEN A_S_TYPE = ' '   AND PRE_T_S_TYPE = 'AMR' THEN DECODE(ATD_SND, ' ', '9', '2')" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'CMR' THEN DECODE(ATD_SND, ' ', '5', DECODE(SA111_RST, ' ', ' ', '5'))" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'CMR' THEN DECODE(ATD_SND, ' ', '5', DECODE(SA111_RST, ' ', ' ', DECODE(A_CMR_KIND||SCMR_RST, '2 ', '2', '5')))" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'AMR' THEN CASE WHEN ATD_SND = ' ' THEN '9' ELSE CASE WHEN A_CMR_KIND = '2' AND (SCMR_RST = ' ' OR SCMR_RST = 'Error') THEN '2' ELSE '5' END   END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'AMR' THEN CASE WHEN ATD_SND = ' ' THEN '9' ELSE '2'   END" ).append("\n"); 
		query.append("       END AS T_CMR_KIND," ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       -- 1. AMR/CMR 구분 2. ATD 체크 3. SA111 체크" ).append("\n"); 
		query.append("       CASE WHEN A_S_TYPE = ' '   AND PRE_T_S_TYPE = 'AMR' THEN " ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND = ' ' THEN 'AMR' " ).append("\n"); 
		query.append("                      ELSE 'CMR' " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'CMR' THEN" ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND <> ' ' THEN" ).append("\n"); 
		query.append("                           CASE WHEN SA111_RST <> ' ' THEN 'CMR'" ).append("\n"); 
		query.append("                                ELSE ' '" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                      ELSE 'CMR'" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'CMR' THEN " ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND <> ' ' THEN" ).append("\n"); 
		query.append("                           CASE WHEN SA111_RST <> ' ' THEN 'CMR'" ).append("\n"); 
		query.append("                                ELSE ' '" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                      ELSE 'CMR'" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'AMR' THEN " ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND = ' ' THEN 'AMR' " ).append("\n"); 
		query.append("                      ELSE 'CMR' " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'AMR' THEN " ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND = ' ' THEN " ).append("\n"); 
		query.append("                           CASE WHEN VVD_POL_CD <> POL_CD AND SAMR_RST='Error' THEN 'CMR' " ).append("\n"); 
		query.append("                                ELSE 'AMR' " ).append("\n"); 
		query.append("                           END " ).append("\n"); 
		query.append("                      ELSE 'CMR' " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("       END AS T_S_TYPE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CASE WHEN A_S_TYPE = ' '   AND PRE_T_S_TYPE = 'AMR' THEN " ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND = ' ' THEN '9' " ).append("\n"); 
		query.append("                      ELSE '2'   " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'CMR' THEN" ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND <> ' ' THEN" ).append("\n"); 
		query.append("                           CASE WHEN SA111_RST <> ' ' THEN '5'" ).append("\n"); 
		query.append("                                ELSE ' '" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                      ELSE '5'" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'CMR' THEN" ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND <> ' ' THEN" ).append("\n"); 
		query.append("                           CASE WHEN SA111_RST <> ' ' THEN " ).append("\n"); 
		query.append("                                     CASE WHEN A_CMR_KIND = '2' AND SCMR_RST = ' ' THEN '2' " ).append("\n"); 
		query.append("                                          ELSE '5' " ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                                ELSE ' '" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                      ELSE '5'" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'CMR' AND PRE_T_S_TYPE = 'AMR' THEN " ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND = ' ' THEN '9' " ).append("\n"); 
		query.append("                      ELSE CASE WHEN A_CMR_KIND = '2' AND (SCMR_RST = ' ' OR SCMR_RST = 'Error') THEN '2' " ).append("\n"); 
		query.append("                                ELSE '5' " ).append("\n"); 
		query.append("                           END   " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            WHEN A_S_TYPE = 'AMR' AND PRE_T_S_TYPE = 'AMR' THEN " ).append("\n"); 
		query.append("                 CASE WHEN ATD_SND = ' ' THEN " ).append("\n"); 
		query.append("                           CASE WHEN VVD_POL_CD <> POL_CD AND SAMR_RST='Error' THEN '1' " ).append("\n"); 
		query.append("                                ELSE '9' " ).append("\n"); 
		query.append("                           END " ).append("\n"); 
		query.append("                      ELSE '2'   " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("       END AS T_CMR_KIND," ).append("\n"); 
		query.append("       --  T_CMR_KIND," ).append("\n"); 
		query.append("       S_DT," ).append("\n"); 
		query.append("       SAMR_DT," ).append("\n"); 
		query.append("       SAMR_RST," ).append("\n"); 
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
		query.append("	   SHPR_PHN_NO," ).append("\n"); 
		query.append("	   SHPR_VIA," ).append("\n"); 
		query.append("       CNEE_NM," ).append("\n"); 
		query.append("       CNEE_ADDR," ).append("\n"); 
		query.append("       CNEE_CNT_CD," ).append("\n"); 
		query.append("	   CNEE_PHN_NO," ).append("\n"); 
		query.append("	   CNEE_VIA," ).append("\n"); 
		query.append("       NTFY_NM," ).append("\n"); 
		query.append("       NTFY_ADDR," ).append("\n"); 
		query.append("       NTFY_CNT_CD," ).append("\n"); 
		query.append("	   NTFY_PHN_NO," ).append("\n"); 
		query.append("	   NTFY_VIA," ).append("\n"); 
		query.append("       USR_EML," ).append("\n"); 
		query.append("       OLD_USR_EML," ).append("\n"); 
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
		query.append("       SHPR_NM||SHPR_ADDR||SHPR_CNT_CD||SHPR_PHN_NO||SHPR_VIA||CNEE_NM||CNEE_ADDR||CNEE_CNT_CD||CNEE_PHN_NO||CNEE_VIA||NTFY_NM||NTFY_ADDR||NTFY_CNT_CD||NTFY_PHN_NO||NTFY_VIA||CMDT_CD||CMDT_HS_CD||MK_DESC||PCK_QTY||PCK_TP_CD||ACT_WGT||WGT_UT_CD||MEAS_QTY||MEAS_UT_CD||IMDG_CLS||UN_NO AS ERR_INFO," ).append("\n"); 
		query.append("       S_INFO" ).append("\n"); 
		query.append("--,       ATD_SND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (SELECT BL_NO," ).append("\n"); 
		query.append("               MST_BL," ).append("\n"); 
		query.append("               BKG_POL_CD," ).append("\n"); 
		query.append("               POL_CD," ).append("\n"); 
		query.append("               VVD_POL_CD," ).append("\n"); 
		query.append("               BKG_POD_CD," ).append("\n"); 
		query.append("			   POD_CD," ).append("\n"); 
		query.append("               BKG_DEL_CD," ).append("\n"); 
		query.append("               BB_CGO_FLG," ).append("\n"); 
		query.append("			   NVL(SUBSTR(S_INFO, 17, 3), ' ') AS A_S_TYPE," ).append("\n"); 
		query.append("               NVL(SUBSTR(S_INFO, 35, 1), ' ') AS A_CMR_KIND," ).append("\n"); 
		query.append("               CASE" ).append("\n"); 
		query.append("                  WHEN S_INFO IS NULL OR SUBSTR(S_INFO, 20, 9) <> @[vvd] OR SUBSTR(S_INFO, 29, 6) <> @[pol_cd]||NVL(@[pol_split_no], ' ') OR NVL(SUBSTR(AMR_SAMR, 17, 5), ' ') <> '00000'" ).append("\n"); 
		query.append("                     THEN 'AMR'" ).append("\n"); 
		query.append("                  ELSE 'CMR'" ).append("\n"); 
		query.append("               END AS PRE_T_S_TYPE," ).append("\n"); 
		query.append("               NVL(SUBSTR(S_INFO, 1, 16), ' ') AS S_DT," ).append("\n"); 
		query.append("               NVL(SUBSTR(AMR_SAMR, 1, 16), ' ') AS SAMR_DT," ).append("\n"); 
		query.append("               --NVL(SUBSTR(AMR_SAMR, 17), ' ') AS SAMR_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(AMR_SAMR, 17, 5), '00000', 'Success', NULL, ' ', 'Error'), ' ') AS SAMR_RST," ).append("\n"); 
		query.append("               NVL(SUBSTR(AMR_SAS111, 1, 16), ' ') AS SA111_DT," ).append("\n"); 
		query.append("               --NVL(SUBSTR(AMR_SAS111, 17), ' ') AS SA111_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(AMR_SAS111, 20, 1), '1', 'Clear', SUBSTR(AMR_SAS111, 17, 3)), ' ') AS SA111_RST," ).append("\n"); 
		query.append("               NVL(SUBSTR(CMR_SCMR, 1, 16), ' ') AS SCMR_DT," ).append("\n"); 
		query.append("               --NVL(SUBSTR(CMR_SCMR, 17), ' ') AS SCMR_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(CMR_SCMR, 17, 5), '00000', 'Success', NULL, ' ', 'Error'), ' ') AS SCMR_RST," ).append("\n"); 
		query.append("               NVL(SUBSTR(CMR_SAS108, 1, 16), ' ') AS SC108_DT," ).append("\n"); 
		query.append("              --NVL(SUBSTR(CMR_SAS108, 17), ' ') AS SC108_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(CMR_SAS108, 17, 11), '/////', 'Success', NULL, ' ', 'Error'), ' ') AS SC108_RST," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(CMR_SAS108, 17, 11), '/////', ' ', NULL, ' ', SUBSTR(CMR_SAS108, 17)), ' ') AS SC108_RST_DTL," ).append("\n"); 
		query.append("               SHPR_NM," ).append("\n"); 
		query.append("               SHPR_ADDR," ).append("\n"); 
		query.append("               SHPR_CNT_CD," ).append("\n"); 
		query.append("               SHPR_PHN_NO," ).append("\n"); 
		query.append("			   SHPR_VIA, " ).append("\n"); 
		query.append("			   CNEE_NM," ).append("\n"); 
		query.append("               CNEE_ADDR," ).append("\n"); 
		query.append("               CNEE_CNT_CD," ).append("\n"); 
		query.append("			   CNEE_PHN_NO," ).append("\n"); 
		query.append("			   CNEE_VIA," ).append("\n"); 
		query.append("               NTFY_NM," ).append("\n"); 
		query.append("               NTFY_ADDR," ).append("\n"); 
		query.append("               NTFY_CNT_CD," ).append("\n"); 
		query.append("			   NTFY_PHN_NO," ).append("\n"); 
		query.append("			   NTFY_VIA," ).append("\n"); 
		query.append("               USR_EML," ).append("\n"); 
		query.append("               USR_EML AS OLD_USR_EML," ).append("\n"); 
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
		query.append("                       ADVBL.POL_CD," ).append("\n"); 
		query.append("                       VVD.POL_CD AS VVD_POL_CD," ).append("\n"); 
		query.append("                       BKG.POD_CD AS BKG_POD_CD," ).append("\n"); 
		query.append("					   ADVBL.POD_CD," ).append("\n"); 
		query.append("                       ADVBL.BKG_DEL_CD," ).append("\n"); 
		query.append("                       ADVBL.BB_CGO_FLG," ).append("\n"); 
		query.append("					   DECODE(ADVBL.RVIS_CNTR_CUST_TP_CD, 'N', 'C', 'B', 'S', 'S') AS MST_BL," ).append("\n"); 
		query.append("                       CNTR.CNTR_NO," ).append("\n"); 
		query.append("                       DECODE(SHPR.CUST_NM, NULL, 'N', 'Y') AS SHPR_NM," ).append("\n"); 
		query.append("                       DECODE(SHPR.CUST_ADDR, NULL, 'N', 'Y') AS SHPR_ADDR," ).append("\n"); 
		query.append("                       DECODE(SHPR.CUST_CNT_CD, NULL, 'N', 'Y') AS SHPR_CNT_CD," ).append("\n"); 
		query.append("                       DECODE(SHPR.PHN_NO, NULL, 'N', 'Y') AS SHPR_PHN_NO," ).append("\n"); 
		query.append("                       DECODE(SHPR.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("                                              FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                             WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                                               AND ML.LOC_CD         = ADVBL.POD_CD), 'D', '', 'N', 'B') AS SHPR_VIA," ).append("\n"); 
		query.append("					   DECODE(CNEE.CUST_NM, NULL, 'N', 'Y') AS CNEE_NM," ).append("\n"); 
		query.append("                       DECODE(CNEE.CUST_ADDR, NULL, 'N', 'Y') AS CNEE_ADDR," ).append("\n"); 
		query.append("                       DECODE(CNEE.CUST_CNT_CD, NULL, 'N', 'Y') AS CNEE_CNT_CD," ).append("\n"); 
		query.append("                       DECODE(CNEE.PHN_NO, NULL, 'N', 'Y') AS CNEE_PHN_NO," ).append("\n"); 
		query.append("                       DECODE(CNEE.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("                                              FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                             WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                                               AND ML.LOC_CD         = ADVBL.POD_CD), 'D', '', 'N', 'B') AS CNEE_VIA," ).append("\n"); 
		query.append("					   DECODE(NTFY.CUST_NM, NULL, 'N', 'Y') AS NTFY_NM," ).append("\n"); 
		query.append("                       DECODE(NTFY.CUST_ADDR, NULL, 'N', 'Y') AS NTFY_ADDR," ).append("\n"); 
		query.append("                       DECODE(NTFY.CUST_CNT_CD, NULL, 'N', 'Y') AS NTFY_CNT_CD," ).append("\n"); 
		query.append("                       DECODE(NTFY.PHN_NO, NULL, 'N', 'Y') AS NTFY_PHN_NO," ).append("\n"); 
		query.append("                       DECODE(NTFY.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("                                              FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                             WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                                               AND ML.LOC_CD         = ADVBL.POD_CD), 'D', '', 'N', 'B') AS NTFY_VIA," ).append("\n"); 
		query.append("					   NVL(ADVBL.USR_EML, ' ') AS USR_EML," ).append("\n"); 
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
		query.append("                               TO_CHAR(RCV.UPD_DT, 'YYYY-MM-DD HH24:MI')||RCV.RCV_KEY_DAT_CTNT||DECODE(RCV.JP_BAT_NO, NULL, ' ', RCV.JP_BAT_NO)" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_RCV_LOG RCV" ).append("\n"); 
		query.append("                         WHERE RCV.BKG_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                           AND RCV.JP_SVC_ID = 'SAS111'" ).append("\n"); 
		query.append("                           AND RCV.JP_MSG_TP_ID = 'SAS111'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS AMR_SAS111," ).append("\n"); 
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
		query.append("                               TO_CHAR(SND.SND_DT, 'YYYY-MM-DD HH24:MI')||SND.JP_SND_LOG_ID||VSL_CD||SKD_VOY_NO||SKD_DIR_CD||POL_CD||DECODE(YD_SEQ, NULL, ' ', YD_SEQ)||LOG_SEQ" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n"); 
		query.append("                         WHERE ADVBL.BL_NO = SND.BL_NO(+)" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS S_INFO," ).append("\n"); 
		query.append("                       (SELECT JP_SND_LOG_ID ATD_SND" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n"); 
		query.append("                         WHERE SND.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                           and SND.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           and SND.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
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
		query.append("        #if (${lt_div} == 'L')" ).append("\n"); 
		query.append("                   AND VVD.POL_CD = ADVBL.BKG_POL_CD" ).append("\n"); 
		query.append("        #elseif (${lt_div} == 'T')" ).append("\n"); 
		query.append("                   AND VVD.POL_CD <> ADVBL.BKG_POL_CD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                   AND ADVBL.POD_CD LIKE @[pod_prefix]||@[pod_postfix]||'%'" ).append("\n"); 
		query.append("        #if (${bl_no} != '')" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${doc_usr_id} != '')" ).append("\n"); 
		query.append("                   AND BKG.DOC_USR_ID = @[doc_usr_id]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                   AND VVD.BKG_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                   AND VVD.BKG_NO = CNTR.BL_NO" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = SHPR.BL_NO(+)" ).append("\n"); 
		query.append("                   AND SHPR.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = CNEE.BL_NO(+)" ).append("\n"); 
		query.append("                   AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = NTFY.BL_NO(+)" ).append("\n"); 
		query.append("                   AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("                   AND BKG.BKG_CGO_TP_CD !='P'" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = ADVBL.BL_NO" ).append("\n"); 
		query.append("                   AND ADVBL.BL_NO = BMD.BL_NO" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${error_div} == 'ERR')" ).append("\n"); 
		query.append("   AND (SHPR_NM = 'N' OR SHPR_ADDR = 'N' OR SHPR_CNT_CD = 'N' OR SHPR_PHN_NO = 'N' OR SHPR_VIA = 'N' OR" ).append("\n"); 
		query.append("        CNEE_NM = 'N' OR CNEE_ADDR = 'N' OR CNEE_CNT_CD = 'N' OR CNEE_PHN_NO = 'N' OR CNEE_VIA = 'N' OR" ).append("\n"); 
		query.append("        NTFY_NM = 'N' OR NTFY_ADDR = 'N' OR NTFY_CNT_CD = 'N' OR NTFY_PHN_NO = 'N' OR NTFY_VIA = 'N' OR" ).append("\n"); 
		query.append("        CMDT_CD = 'N' OR CMDT_HS_CD = 'N' OR MK_DESC = 'N' OR" ).append("\n"); 
		query.append("        PCK_QTY = 'N' OR PCK_TP_CD = 'N' OR ACT_WGT = 'N' OR WGT_UT_CD = 'N' OR" ).append("\n"); 
		query.append("        MEAS_QTY = 'N' OR MEAS_UT_CD = 'N' OR IMDG_CLS = 'N' OR UN_NO = 'N')" ).append("\n"); 
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