/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchUsaCstmsManifestDeleteAmendmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchUsaCstmsManifestDeleteAmendmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaCustomsTransmissionDBDAOsearchUsaCstmsManifestDeleteAmendmentRSQL
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchUsaCstmsManifestDeleteAmendmentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_gubun",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mbl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("end_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchUsaCstmsManifestDeleteAmendmentRSQL").append("\n"); 
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
		query.append("SELECT '' AI_TYPE" ).append("\n"); 
		query.append("      ,'' ACTION_CODE" ).append("\n"); 
		query.append("      ,'' ACTION_DESC" ).append("\n"); 
		query.append("      ,'' CNTR_NO" ).append("\n"); 
		query.append("      ,TB.*" ).append("\n"); 
		query.append("      ,DECODE(TB.FULL_MTY_CD, 'F', BKG_GET_CSTMS_ADV_ERR_CD_FNC(TB.BKG_NO, TB.MH, 'US')) AS ERROR" ).append("\n"); 
		query.append("      ,(SELECT /*+INDEX_DESC(A XPKBKG_CORRECTION)*/ CORR_NO" ).append("\n"); 
		query.append("          FROM BKG_CORRECTION A" ).append("\n"); 
		query.append("         WHERE BKG_NO = TB.BKG_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS CA_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , DECODE(NVL(TB.AI_FLAG, 'Y'), 'N', 'Y', 'Y', 'N') AS AI_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    #if (${snd_dt_flg} != '')" ).append("\n"); 
		query.append("        SELECT TB2.*" ).append("\n"); 
		query.append("              ,TB2.T_VSL_CD || TB2.T_SKD_VOY_NO || TB2.T_SKD_DIR_CD AS T_VVD_CD" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(ORDER BY TB2.BL_NO) RNUM" ).append("\n"); 
		query.append("           	  ,( " ).append("\n"); 
		query.append("                SELECT DOC_PERF_DELT_FLG--DECODE(NVL(DOC_PERF_DELT_FLG, 'Y'), 'N', 'Y', 'Y', 'N') AS AI_FLAG" ).append("\n"); 
		query.append("                FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                WHERE BKG_NO = TB2.BL_NO" ).append("\n"); 
		query.append("                AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                AND DIFF_RMK LIKE 'Amendment%'" ).append("\n"); 
		query.append("                AND DOC_PROC_SEQ = (" ).append("\n"); 
		query.append("                                        SELECT MAX(DOC_PROC_SEQ)" ).append("\n"); 
		query.append("                                        FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                                        WHERE BKG_NO = TB2.BL_NO" ).append("\n"); 
		query.append("                                        AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                                        AND DIFF_RMK LIKE 'Amendment%'                        " ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                AND 'M' = TB2.MH" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT DOC_PERF_DELT_FLG--DECODE(NVL(DOC_PERF_DELT_FLG, 'Y'), 'N', 'Y', 'Y', 'N') AS AI_FLAG" ).append("\n"); 
		query.append("                FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                WHERE BKG_NO = TB2.MBL_NO" ).append("\n"); 
		query.append("                AND DIFF_RMK = TB2.BL_NO " ).append("\n"); 
		query.append("                AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                AND DOC_PROC_SEQ = (" ).append("\n"); 
		query.append("                                        SELECT MAX(DOC_PROC_SEQ)" ).append("\n"); 
		query.append("                                        FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                                        WHERE BKG_NO = TB2.MBL_NO" ).append("\n"); 
		query.append("                                        AND DIFF_RMK = TB2.BL_NO" ).append("\n"); 
		query.append("                                        AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                AND 'H' = TB2.MH" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ) AS AI_FLAG      " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT TB.*" ).append("\n"); 
		query.append("                      ,DECODE(LOG.SND_DT, NULL, 'N', 'Y') AS V_MI" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TB.BL_NO ORDER BY LOG.SND_DT DESC) AS LOG_RNUM" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT BL.BKG_NO" ).append("\n"); 
		query.append("                              ,BL.BL_NO" ).append("\n"); 
		query.append("                              ,DECODE(BL.MF_NO, NULL, 'M', 'H') AS MH" ).append("\n"); 
		query.append("                              ,DECODE(BL.MF_NO, NULL, B.USA_CSTMS_FILE_CD, '0') AS CSTMS_FILE_CD" ).append("\n"); 
		query.append("                              ,NVL(BL.MF_NO, BL.BL_NO) AS MBL_NO" ).append("\n"); 
		query.append("                              ,B.BKG_STS_CD" ).append("\n"); 
		query.append("                              ,B.VSL_CD AS T_VSL_CD" ).append("\n"); 
		query.append("                              ,B.SKD_VOY_NO AS T_SKD_VOY_NO" ).append("\n"); 
		query.append("                              ,B.SKD_DIR_CD AS T_SKD_DIR_CD" ).append("\n"); 
		query.append("                              ,B.POL_CD AS BKG_POL_CD" ).append("\n"); 
		query.append("                              ,B.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("                              ,'Y' AS B_MI" ).append("\n"); 
		query.append("                              ,BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS B_VVD_CD" ).append("\n"); 
		query.append("                              ,CASE WHEN BL.MF_SND_DT IS NOT NULL AND BL.AMDT_SND_DT IS NOT NULL " ).append("\n"); 
		query.append("                                         THEN TO_CHAR(GREATEST(BL.MF_SND_DT, BL.AMDT_SND_DT),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                    WHEN BL.MF_SND_DT IS NULL AND BL.AMDT_SND_DT IS NOT NULL " ).append("\n"); 
		query.append("                                         THEN TO_CHAR(BL.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                    WHEN BL.MF_SND_DT IS NOT NULL AND BL.AMDT_SND_DT IS NULL " ).append("\n"); 
		query.append("                                         THEN TO_CHAR(BL.MF_SND_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                    ELSE '' END AS MI_SND_DT" ).append("\n"); 
		query.append("                              ,DECODE(BL.MF_NO, NULL, BL.CSTMS_FILE_TP_CD, '0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("                              ,BL.MF_STS_CD" ).append("\n"); 
		query.append("                              ,BL.CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("                              ,BL.FULL_MTY_CD" ).append("\n"); 
		query.append("                              ,BL.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("                              ,BL.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("                              ,B.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("                              ,BL.VSL_CD" ).append("\n"); 
		query.append("                              ,BL.SKD_VOY_NO" ).append("\n"); 
		query.append("                              ,BL.SKD_DIR_CD" ).append("\n"); 
		query.append("                              ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("                              ,B.DOC_USR_ID" ).append("\n"); 
		query.append("                              ,B.OB_SREP_CD" ).append("\n"); 
		query.append("                              ,CASE WHEN BDR.TRNK_MNL_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                                    WHEN BDR.TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                                    WHEN BDR.TRNK_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                                    ELSE 'N' " ).append("\n"); 
		query.append("                                    END BDR_FLG" ).append("\n"); 
		query.append("                              ,COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("                              ,'MI' AS TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                              ,BKG_BOOKING B" ).append("\n"); 
		query.append("                              ,BKG_VVD_BDR_LOG BDR" ).append("\n"); 
		query.append("                         WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND BL.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND BL.VSL_CD = BDR.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND BL.SKD_VOY_NO = BDR.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND BL.SKD_DIR_CD = BDR.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                           AND BL.CSTMS_POL_CD = BDR.POL_CD(+)" ).append("\n"); 
		query.append("                           AND BL.CSTMS_POD_CD = BDR.POD_CD(+)" ).append("\n"); 
		query.append("                           AND (" ).append("\n"); 
		query.append("                                B.BKG_STS_CD NOT IN ('X', 'A' ,'S') " ).append("\n"); 
		query.append("                                OR " ).append("\n"); 
		query.append("                                (B.BKG_STS_CD IN ('X', 'A' ,'S') AND BL.MF_STS_CD = 'A' AND BL.CSTMS_MF_TP_CD = 'MI')" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                        #if (${mbl_no} != '')" ).append("\n"); 
		query.append("                           AND (BL.BL_NO = @[mbl_no] OR BL.MF_NO = @[mbl_no])" ).append("\n"); 
		query.append("                        #elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("                           AND BL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                               AND BL.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                               AND BL.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                               AND BL.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                               AND BL.CSTMS_POL_CD=@[pol_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                               AND BL.CSTMS_POD_CD=@[pod_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                               AND B.BKG_OFC_CD LIKE @[bkg_ofc_cd] || '%'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${doc_usr_id} != '')" ).append("\n"); 
		query.append("                               AND B.DOC_USR_ID LIKE @[doc_usr_id] || '%'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("                               AND B.OB_SREP_CD LIKE @[ob_srep_cd] || '%'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${snd_dt_flg} != '')" ).append("\n"); 
		query.append("                               AND CASE WHEN BL.MF_SND_DT IS NOT NULL AND BL.AMDT_SND_DT IS NOT NULL " ).append("\n"); 
		query.append("                                         THEN GREATEST(BL.MF_SND_DT, BL.AMDT_SND_DT)" ).append("\n"); 
		query.append("                                    WHEN BL.AMDT_SND_DT IS NOT NULL THEN BL.AMDT_SND_DT" ).append("\n"); 
		query.append("                                    WHEN BL.MF_SND_DT IS NOT NULL THEN BL.MF_SND_DT" ).append("\n"); 
		query.append("                                    END " ).append("\n"); 
		query.append("                                   BETWEEN TO_DATE(@[s_snd_dt] || ' 000000', 'YYYY-MM-DD HH24MISS') " ).append("\n"); 
		query.append("                                       AND TO_DATE(@[e_snd_dt] || ' 235959', 'YYYY-MM-DD HH24MISS') " ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${full_mty_cd} != '')" ).append("\n"); 
		query.append("                               AND BL.FULL_MTY_CD = @[full_mty_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                       ) TB" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_SND_LOG LOG" ).append("\n"); 
		query.append("                 WHERE TB.T_VSL_CD       = LOG.VSL_CD" ).append("\n"); 
		query.append("                   AND TB.T_SKD_VOY_NO   = LOG.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND TB.T_SKD_DIR_CD   = LOG.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND TB.POL_CD         = LOG.POL_CD" ).append("\n"); 
		query.append("                   AND TB.POD_CD         = LOG.POD_CD" ).append("\n"); 
		query.append("                   AND TB.TRSM_MSG_TP_ID = LOG.TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("        		   AND LOG.IO_BND_CD = 'I' /*추가*/ " ).append("\n"); 
		query.append("                   #if (${status_gubun} != '')" ).append("\n"); 
		query.append("			       		AND BL.MF_STS_CD =  @[status_gubun]  /*추가*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("               ) TB2" ).append("\n"); 
		query.append("         WHERE LOG_RNUM = 1" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        SELECT TB2.*" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(ORDER BY TB2.BL_NO) RNUM" ).append("\n"); 
		query.append("              ,COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,( " ).append("\n"); 
		query.append("                SELECT DOC_PERF_DELT_FLG--DECODE(NVL(DOC_PERF_DELT_FLG, 'Y'), 'N', 'Y', 'Y', 'N') AS AI_FLAG" ).append("\n"); 
		query.append("                FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                WHERE BKG_NO = TB2.BL_NO" ).append("\n"); 
		query.append("                AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                AND DIFF_RMK LIKE 'Amendment%'" ).append("\n"); 
		query.append("                AND DOC_PROC_SEQ = (" ).append("\n"); 
		query.append("                                        SELECT MAX(DOC_PROC_SEQ)" ).append("\n"); 
		query.append("                                        FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                                        WHERE BKG_NO = TB2.BL_NO" ).append("\n"); 
		query.append("                                        AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                                        AND DIFF_RMK LIKE 'Amendment%'                        " ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                AND 'M' = TB2.MH" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT DOC_PERF_DELT_FLG--DECODE(NVL(DOC_PERF_DELT_FLG, 'Y'), 'N', 'Y', 'Y', 'N') AS AI_FLAG" ).append("\n"); 
		query.append("                FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                WHERE BKG_NO = TB2.MBL_NO" ).append("\n"); 
		query.append("                AND DIFF_RMK = TB2.BL_NO " ).append("\n"); 
		query.append("                AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                AND DOC_PROC_SEQ = (" ).append("\n"); 
		query.append("                                        SELECT MAX(DOC_PROC_SEQ)" ).append("\n"); 
		query.append("                                        FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                                        WHERE BKG_NO = TB2.MBL_NO" ).append("\n"); 
		query.append("                                        AND DIFF_RMK = TB2.BL_NO" ).append("\n"); 
		query.append("                                        AND BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                AND 'H' = TB2.MH" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ) AS AI_FLAG   " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT BKG.*" ).append("\n"); 
		query.append("                      ,DECODE(LOG.SND_DT, NULL, 'N', 'Y') AS V_MI" ).append("\n"); 
		query.append("                      ,BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS B_VVD_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN BL.MF_SND_DT IS NULL AND BL.AMDT_SND_DT IS NULL THEN 'N'" ).append("\n"); 
		query.append("                            ELSE 'Y' END AS B_MI" ).append("\n"); 
		query.append("                      ,CASE WHEN BL.MF_SND_DT IS NOT NULL AND BL.AMDT_SND_DT IS NOT NULL " ).append("\n"); 
		query.append("                                 THEN TO_CHAR(GREATEST(BL.MF_SND_DT, BL.AMDT_SND_DT),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                            WHEN BL.MF_SND_DT IS NULL AND BL.AMDT_SND_DT IS NOT NULL " ).append("\n"); 
		query.append("                                 THEN TO_CHAR(BL.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                            WHEN BL.MF_SND_DT IS NOT NULL AND BL.AMDT_SND_DT IS NULL " ).append("\n"); 
		query.append("                                 THEN TO_CHAR(BL.MF_SND_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                            ELSE '' END AS MI_SND_DT" ).append("\n"); 
		query.append("                      ,DECODE(BL.BL_NO, NULL, '', DECODE(BL.MF_NO, NULL, BL.CSTMS_FILE_TP_CD, '0')) AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("                      ,BL.MF_STS_CD" ).append("\n"); 
		query.append("                      ,BL.CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN BDR.TRNK_MNL_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                            WHEN BDR.TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                            WHEN BDR.TRNK_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                            ELSE 'N' " ).append("\n"); 
		query.append("                            END BDR_FLG" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY BKG.BL_NO ORDER BY LOG.SND_DT DESC) AS LOG_RNUM" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("                              ,BKG.BL_NO" ).append("\n"); 
		query.append("                              ,'M' AS MH" ).append("\n"); 
		query.append("                              ,BKG.USA_CSTMS_FILE_CD AS CSTMS_FILE_CD" ).append("\n"); 
		query.append("                              ,BKG.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("                              ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                              ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS T_VVD_CD" ).append("\n"); 
		query.append("                              ,BKG.POL_CD AS BKG_POL_CD" ).append("\n"); 
		query.append("                              ,BKG.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("                              ,BKG.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("                              ,VVD.POL_CD" ).append("\n"); 
		query.append("                              ,VVD.POD_CD" ).append("\n"); 
		query.append("                              ,DECODE(BKG.BKG_CGO_TP_CD,'F','F','M') AS FULL_MTY_CD" ).append("\n"); 
		query.append("                              ,VVD.VSL_CD" ).append("\n"); 
		query.append("                              ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                              ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                              ,'MI' AS TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("                              ,BKG_VVD VVD" ).append("\n"); 
		query.append("                         WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                    #if (${mbl_no} != '')" ).append("\n"); 
		query.append("                           AND BKG.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("                    #elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("                           AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                           AND VVD.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                           AND VVD.POL_CD=@[pol_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                           AND VVD.POD_CD=@[pod_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BKG.BKG_OFC_CD LIKE @[bkg_ofc_cd] || '%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${doc_usr_id} != '')" ).append("\n"); 
		query.append("                           AND BKG.DOC_USR_ID LIKE @[doc_usr_id] || '%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("                           AND BKG.OB_SREP_CD LIKE @[ob_srep_cd] || '%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${full_mty_cd} == 'F')" ).append("\n"); 
		query.append("                           AND BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("                        #elseif (${full_mty_cd} == 'M')" ).append("\n"); 
		query.append("                           AND BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("                              ,HBL.CNTR_MF_NO" ).append("\n"); 
		query.append("                              ,'H' AS MH" ).append("\n"); 
		query.append("                              ,'0' AS CSTMS_FILE_CD" ).append("\n"); 
		query.append("                              ,BKG.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("                              ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                              ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS T_VVD_CD" ).append("\n"); 
		query.append("                              ,BKG.POL_CD AS BKG_POL_CD" ).append("\n"); 
		query.append("                              ,BKG.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("                              ,BKG.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("                              ,VVD.POL_CD" ).append("\n"); 
		query.append("                              ,VVD.POD_CD" ).append("\n"); 
		query.append("                              ,DECODE(BKG.BKG_CGO_TP_CD,'F','F','M') AS FULL_MTY_CD" ).append("\n"); 
		query.append("                              ,VVD.VSL_CD" ).append("\n"); 
		query.append("                              ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                              ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                              ,'MI' AS TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("                              ,BKG_VVD VVD" ).append("\n"); 
		query.append("                              ,BKG_HBL HBL" ).append("\n"); 
		query.append("                         WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                           AND BKG.BKG_NO = HBL.BKG_NO" ).append("\n"); 
		query.append("                           AND BKG.USA_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append("                    #if (${mbl_no} != '')" ).append("\n"); 
		query.append("                           AND BKG.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("                    #elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("                           AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                           AND VVD.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                           AND VVD.POL_CD=@[pol_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                           AND VVD.POD_CD=@[pod_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BKG.BKG_OFC_CD LIKE @[bkg_ofc_cd] || '%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${doc_usr_id} != '')" ).append("\n"); 
		query.append("                           AND BKG.DOC_USR_ID LIKE @[doc_usr_id] || '%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("                           AND BKG.OB_SREP_CD LIKE @[ob_srep_cd] || '%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${full_mty_cd} == 'F')" ).append("\n"); 
		query.append("                           AND BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("                        #elseif (${full_mty_cd} == 'M')" ).append("\n"); 
		query.append("                           AND BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                       ) BKG" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_SND_LOG LOG" ).append("\n"); 
		query.append("                      ,BKG_VVD_BDR_LOG BDR" ).append("\n"); 
		query.append("#if (${vsl_skd_flg} == 'Y')" ).append("\n"); 
		query.append("                      ,VSK_VSL_PORT_SKD VSL" ).append("\n"); 
		query.append("					  ,VSK_VSL_PORT_SKD SKD_POD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      ,MDM_LOCATION M" ).append("\n"); 
		query.append("                 WHERE BKG.BL_NO = BL.BL_NO(+)" ).append("\n"); 
		query.append("                   AND BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND BL.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("                   AND LOG.CNT_CD = 'US'" ).append("\n"); 
		query.append("                   AND LOG.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND LOG.TRSM_MSG_TP_ID = BKG.TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                   AND LOG.VSL_CD = BKG.VSL_CD" ).append("\n"); 
		query.append("                   AND LOG.SKD_VOY_NO = BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND LOG.SKD_DIR_CD = BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND LOG.POL_CD = BKG.POL_CD" ).append("\n"); 
		query.append("                   AND LOG.POD_CD = BKG.POD_CD" ).append("\n"); 
		query.append("                   AND BKG.VSL_CD = BDR.VSL_CD(+)" ).append("\n"); 
		query.append("                   AND BKG.SKD_VOY_NO = BDR.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                   AND BKG.SKD_DIR_CD = BDR.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                   AND BKG.POL_CD = BDR.POL_CD(+)" ).append("\n"); 
		query.append("                   AND BKG.POD_CD = BDR.POD_CD(+)" ).append("\n"); 
		query.append("                   AND BKG.BL_NO IS NOT NULL " ).append("\n"); 
		query.append("                   AND (" ).append("\n"); 
		query.append("                        BKG.BKG_STS_CD NOT IN ('X', 'A' ,'S') " ).append("\n"); 
		query.append("                        OR " ).append("\n"); 
		query.append("                        (BKG.BKG_STS_CD IN ('X', 'A' ,'S') AND BL.MF_STS_CD = 'A' AND BL.CSTMS_MF_TP_CD = 'MI')" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("        		   AND LOG.IO_BND_CD = 'I' /*추가*/ " ).append("\n"); 
		query.append("#if (${status_gubun} != '')" ).append("\n"); 
		query.append("					AND BL.MF_STS_CD = @[status_gubun]  /*추가*/" ).append("\n"); 
		query.append("#end                       " ).append("\n"); 
		query.append("#if (${vsl_skd_flg} == 'Y')" ).append("\n"); 
		query.append("                   AND BKG.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                   AND BKG.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND BKG.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND BKG.POD_CD = VSL.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VSL.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                   AND VSL.CLPT_SEQ >= @[min_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   				   AND VSL.VSL_CD = SKD_POD.VSL_CD" ).append("\n"); 
		query.append("   				   AND VSL.SKD_VOY_NO = SKD_POD.SKD_VOY_NO" ).append("\n"); 
		query.append("   				   AND VSL.SKD_DIR_CD = SKD_POD.SKD_DIR_CD" ).append("\n"); 
		query.append("   				   AND SKD_POD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("   				   AND NVL(SKD_POD.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   				   AND SUBSTR(SKD_POD.VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                        WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                        AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                            )  " ).append("\n"); 
		query.append("   				   AND VSL.CLPT_SEQ >= SKD_POD.CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND BKG.POD_CD = M.LOC_CD" ).append("\n"); 
		query.append("                   --AND M.CONTI_CD = 'M' " ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("                ) TB2" ).append("\n"); 
		query.append("           WHERE LOG_RNUM = 1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 
		query.append("#if (${ai_type} == '' and ${status_gubun} == '')" ).append("\n"); 
		query.append(" WHERE RNUM BETWEEN @[start_no] AND @[end_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}