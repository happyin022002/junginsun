/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaBlInfoListVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchManifestListRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchManifestListRSQL").append("\n"); 
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
		query.append("WITH EDI_INFO AS (SELECT *" ).append("\n"); 
		query.append("                   FROM (SELECT /*+ USE_HASH(B) */" ).append("\n"); 
		query.append("                                DISTINCT DENSE_RANK() OVER(PARTITION BY BL.BL_NO ORDER BY SLOG.MF_SND_DT DESC) AS RNUM," ).append("\n"); 
		query.append("                                BL.BL_NO," ).append("\n"); 
		query.append("                                SLOG.MF_SND_DT," ).append("\n"); 
		query.append("                                SLOG.EDI_REF_ID" ).append("\n"); 
		query.append("                           FROM BKG_CSTMS_CHN_SND_LOG_BL BL," ).append("\n"); 
		query.append("                                BKG_CSTMS_CHN_SND_LOG SLOG," ).append("\n"); 
		query.append("                                BKG_CSTMS_CHN_BL B" ).append("\n"); 
		query.append("                          WHERE SLOG.CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("                            AND SLOG.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                            AND SLOG.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                            AND SLOG.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                            AND BL.EDI_REF_ID = SLOG.EDI_REF_ID" ).append("\n"); 
		query.append("                            AND BL.BL_NO = B.BL_NO)" ).append("\n"); 
		query.append("                  WHERE RNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT INFO.BKG_NO," ).append("\n"); 
		query.append("       INFO.BL_NO," ).append("\n"); 
		query.append("       INFO.POL_CD," ).append("\n"); 
		query.append("       INFO.POD_CD," ).append("\n"); 
		query.append("       INFO.BKG_POL_CD," ).append("\n"); 
		query.append("       INFO.BKG_POD_CD," ).append("\n"); 
		query.append("       INFO.DEL_CD," ).append("\n"); 
		query.append("       INFO.PCK_QTY," ).append("\n"); 
		query.append("       INFO.PCK_TP_CD," ).append("\n"); 
		query.append("       INFO.ACT_WGT," ).append("\n"); 
		query.append("       INFO.WGT_UT_CD," ).append("\n"); 
		query.append("       MIN(DECODE(TRIM(SEAL.SEAL_NO), NULL, 'N', 'Y')) AS SEAL_NO_FLG," ).append("\n"); 
		query.append("       MIN(DECODE(TRIM(SEAL.SEAL_KND_CD), NULL, 'N', 'Y')) AS SEAL_KND_FLG," ).append("\n"); 
		query.append("       MIN(DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD, 1, 1), 'F', 'Y', 'A', 'Y', DECODE(TRIM(SEAL.SEAL_PTY_TP_CD), NULL, 'N', 'Y'))) AS SEALER_CD_FLG," ).append("\n"); 
		query.append("       INFO.SHPR_NM," ).append("\n"); 
		query.append("       INFO.SHPR_ADDR," ).append("\n"); 
		query.append("       INFO.CNEE_NM," ).append("\n"); 
		query.append("       INFO.CNEE_ADDR," ).append("\n"); 
		query.append("       INFO.NTFY_NM," ).append("\n"); 
		query.append("       INFO.NTFY_ADDR," ).append("\n"); 
		query.append("       INFO.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       INFO.TR," ).append("\n"); 
		query.append("       INFO.DCGO_FLG," ).append("\n"); 
		query.append("       INFO.RC_FLG," ).append("\n"); 
		query.append("       INFO.CNTR_CNT," ).append("\n"); 
		query.append("       --SUM(DECODE(CNTR.CNTR_NO,NULL,0,1)) CNTR_CNT," ).append("\n"); 
		query.append("       DECODE(SLOG.TRSM_MSG_TP_ID, '9', 'Original', '0', 'Secondly', '5', 'Change', '3', 'Delete') AS TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("       TO_CHAR(SLOG.MF_SND_DT, 'YYYYMMDDHH24MISS') AS MF_SND_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       -- VSL Info" ).append("\n"); 
		query.append("       '' AS CALL_SGN_NO," ).append("\n"); 
		query.append("       '' AS PRE_PORT," ).append("\n"); 
		query.append("       '' AS NXT_PORT," ).append("\n"); 
		query.append("       '' AS VPS_ETA_DT," ).append("\n"); 
		query.append("       '' AS VPS_ETD_DT," ).append("\n"); 
		query.append("       '' AS VPS_ETB_DT," ).append("\n"); 
		query.append("       '' AS VSL_ENG_NM," ).append("\n"); 
		query.append("       '' AS SND_DATE," ).append("\n"); 
		query.append("       '' AS ETA_FLG," ).append("\n"); 
		query.append("       '' AS ETD_FLG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       -- 조회 조건" ).append("\n"); 
		query.append("       @[vvd] AS VVD," ).append("\n"); 
		query.append("       @[bkg_cgo_tp_cd] AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       @[loc_cd] AS LOC_CD," ).append("\n"); 
		query.append("       @[trans_mode] AS TRANS_MODE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       -- 총 개수" ).append("\n"); 
		query.append("       '' AS TOTAL," ).append("\n"); 
		query.append("       INFO.MEA_QTY," ).append("\n"); 
		query.append("       MIN(DECODE(DG.BL_NO, NULL, ' ', DECODE(TRIM(DG.CNTC_PSON_NM), NULL, 'N', 'Y'))) AS CNTC_PSON_NM," ).append("\n"); 
		query.append("       MIN(DECODE(DG.BL_NO, NULL, ' ', DECODE(TRIM(DG.CNTC_PSON_TELCM_NO), NULL, 'N', 'Y'))) AS CNTC_PSON_TELCM_NO," ).append("\n"); 
		query.append("       MIN(DECODE(DG.BL_NO, NULL, ' ', DECODE(TRIM(DG.IMDG_UN_NO), NULL, 'N', 'Y'))) AS IMDG_UN_NO," ).append("\n"); 
		query.append("       INFO.FRT_TERM_CD," ).append("\n"); 
		query.append("       INFO.RCV_TERM_CD," ).append("\n"); 
		query.append("       INFO.DE_TERM_CD," ).append("\n"); 
		query.append("       MIN(DECODE(TRIM(TO_CHAR(MK.BL_MK_DESC)), NULL, 'N', 'Y')) AS BL_MK_DESC," ).append("\n"); 
		query.append("       MIN(DECODE(TRIM(CM.PCK_QTY), 0, 'N', NULL, 'N', 'Y')) AS CM_PCK_QTY," ).append("\n"); 
		query.append("       MIN(DECODE(TRIM(CM.PCK_TP_CD), NULL, 'N', 'Y')) AS CM_PCK_TP_CD," ).append("\n"); 
		query.append("       MIN(DECODE(TRIM(CM.CNTR_MF_WGT), 0, 'N', NULL, 'N', 'Y')) AS CM_CNTR_MF_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (SELECT B.CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("               (SELECT COUNT(CNTR_NO)" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CNTR CC" ).append("\n"); 
		query.append("                 WHERE CC.CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("                   AND B.BL_NO = CC.BL_NO" ).append("\n"); 
		query.append("                 GROUP BY CC.BL_NO) AS CNTR_CNT," ).append("\n"); 
		query.append("               B.BL_NO," ).append("\n"); 
		query.append("               B.BKG_NO," ).append("\n"); 
		query.append("               B.POL_CD," ).append("\n"); 
		query.append("               B.POD_CD," ).append("\n"); 
		query.append("               B.BKG_POL_CD," ).append("\n"); 
		query.append("               B.BKG_POD_CD," ).append("\n"); 
		query.append("               B.DEL_CD," ).append("\n"); 
		query.append("               DECODE(NVL(B.PCK_QTY, 0), 0, 'N', 'Y') AS PCK_QTY," ).append("\n"); 
		query.append("               DECODE(B.PCK_TP_CD, NULL, 'N', 'Y') AS PCK_TP_CD," ).append("\n"); 
		query.append("               DECODE(NVL(B.ACT_WGT, 0), 0, 'N', 'Y') AS ACT_WGT," ).append("\n"); 
		query.append("               DECODE(B.WGT_UT_CD, NULL, 'N', 'Y') AS WGT_UT_CD," ).append("\n"); 
		query.append("               DECODE(S.BKG_CUST_TP_CD, 'S', DECODE(LENGTH(TRIM(S.CUST_NM)), 0, 'N', NULL, 'N', 'Y')) AS SHPR_NM," ).append("\n"); 
		query.append("               DECODE(S.BKG_CUST_TP_CD, 'S', DECODE(LENGTH(TRIM(S.CUST_ADDR)), 0, 'N', NULL, 'N', 'Y')) AS SHPR_ADDR," ).append("\n"); 
		query.append("               DECODE(C.BKG_CUST_TP_CD, 'C', DECODE(LENGTH(TRIM(C.CUST_NM)), 0, 'N', NULL, 'N', 'Y')) AS CNEE_NM," ).append("\n"); 
		query.append("               DECODE(C.BKG_CUST_TP_CD, 'C', DECODE(LENGTH(TRIM(C.CUST_ADDR)), 0, 'N', NULL, 'N', 'Y')) AS CNEE_ADDR," ).append("\n"); 
		query.append("               DECODE(N.BKG_CUST_TP_CD, 'N', DECODE(LENGTH(TRIM(N.CUST_NM)), 0, 'N', NULL, 'N', 'Y')) AS NTFY_NM," ).append("\n"); 
		query.append("               DECODE(N.BKG_CUST_TP_CD, 'N', DECODE(LENGTH(TRIM(N.CUST_ADDR)), 0, 'N', NULL, 'N', 'Y')) AS NTFY_ADDR," ).append("\n"); 
		query.append("               B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("               DECODE(@[trans_mode], 'D', DECODE(B.POD_CD, @[loc_cd], 'I', 'T'), DECODE(B.POL_CD, @[loc_cd], 'E', 'R')) AS TR," ).append("\n"); 
		query.append("               DECODE(B.DCGO_FLG, 'N', 'N', 'Y') AS DCGO_FLG," ).append("\n"); 
		query.append("               DECODE(B.RC_FLG, 'N', 'N', 'Y') AS RC_FLG," ).append("\n"); 
		query.append("               EDI_INFO.EDI_REF_ID," ).append("\n"); 
		query.append("               DECODE(NVL(B.MEAS_QTY, 0), 0, 'N', 'Y') AS MEA_QTY," ).append("\n"); 
		query.append("               DECODE(B.FRT_TERM_CD, NULL, 'N', 'Y') AS FRT_TERM_CD," ).append("\n"); 
		query.append("               DECODE(B.RCV_TERM_CD, NULL, 'N', 'Y') AS RCV_TERM_CD," ).append("\n"); 
		query.append("               DECODE(B.DE_TERM_CD, NULL, 'N', 'Y') AS DE_TERM_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CHN_BL B," ).append("\n"); 
		query.append("               BKG_CSTMS_CHN_CUST S," ).append("\n"); 
		query.append("               BKG_CSTMS_CHN_CUST C," ).append("\n"); 
		query.append("               BKG_CSTMS_CHN_CUST N," ).append("\n"); 
		query.append("               EDI_INFO" ).append("\n"); 
		query.append("         WHERE B.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND B.CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("           AND DECODE(B.BKG_CGO_TP_CD, 'P', 'P', 'F') LIKE @[bkg_cgo_tp_cd]||'%'" ).append("\n"); 
		query.append("           AND DECODE(@[trans_mode], 'D', B.BKG_POD_CD, 'O', B.BKG_POL_CD, B.BKG_POL_CD) = @[loc_cd]" ).append("\n"); 
		query.append("           AND B.CHN_MF_SND_IND_CD = S.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("           AND B.CHN_MF_SND_IND_CD = C.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("           AND B.CHN_MF_SND_IND_CD = N.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("           AND B.BL_NO = S.BL_NO(+)" ).append("\n"); 
		query.append("           AND B.BL_NO = C.BL_NO(+)" ).append("\n"); 
		query.append("           AND B.BL_NO = N.BL_NO(+)" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("           AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("           AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("           AND B.BL_NO = EDI_INFO.BL_NO(+)) INFO," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_CNTR CNTR," ).append("\n"); 
		query.append("       BKG_CSTMS_SEAL_NO SEAL," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_DG_CGO DG," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_MK MK," ).append("\n"); 
		query.append("       BKG_CNTR_MF_DESC CM," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_SND_LOG SLOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE INFO.BL_NO = CNTR.BL_NO(+)" ).append("\n"); 
		query.append("   AND INFO.CHN_MF_SND_IND_CD = CNTR.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("   AND CNTR.BL_NO = SEAL.BL_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND SEAL.CNT_CD(+) = 'CN'" ).append("\n"); 
		query.append("   AND SEAL.CSTMS_DIV_ID(+) = 'CTM'" ).append("\n"); 
		query.append("   AND SEAL.SEAL_NO_SEQ(+) = 1 -- 2014.06.24 적용 seal number 1개이상 있는 경우존재" ).append("\n"); 
		query.append("   AND INFO.EDI_REF_ID = SLOG.EDI_REF_ID(+)" ).append("\n"); 
		query.append("   AND INFO.CHN_MF_SND_IND_CD = DG.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("   AND INFO.BL_NO = DG.BL_NO(+)" ).append("\n"); 
		query.append("   AND INFO.CHN_MF_SND_IND_CD = MK.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("   AND INFO.BL_NO = MK.BL_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.BL_NO = CM.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO = CM.CNTR_NO(+)" ).append("\n"); 
		query.append("#if (${trans_type} == 'local')" ).append("\n"); 
		query.append("   AND INFO.TR IN ('E', 'I')" ).append("\n"); 
		query.append("#elseif (${trans_type} == 'ts')" ).append("\n"); 
		query.append("   AND INFO.TR IN ('R', 'T')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY INFO.BL_NO," ).append("\n"); 
		query.append("       INFO.BKG_NO," ).append("\n"); 
		query.append("       INFO.POL_CD," ).append("\n"); 
		query.append("       INFO.POD_CD," ).append("\n"); 
		query.append("       INFO.BKG_POL_CD," ).append("\n"); 
		query.append("       INFO.BKG_POD_CD," ).append("\n"); 
		query.append("       INFO.DEL_CD," ).append("\n"); 
		query.append("       INFO.PCK_QTY," ).append("\n"); 
		query.append("       INFO.PCK_TP_CD," ).append("\n"); 
		query.append("       INFO.ACT_WGT," ).append("\n"); 
		query.append("       INFO.WGT_UT_CD," ).append("\n"); 
		query.append("       INFO.SHPR_NM," ).append("\n"); 
		query.append("       INFO.SHPR_ADDR," ).append("\n"); 
		query.append("       INFO.CNEE_NM," ).append("\n"); 
		query.append("       INFO.CNEE_ADDR," ).append("\n"); 
		query.append("       INFO.NTFY_NM," ).append("\n"); 
		query.append("       INFO.NTFY_ADDR," ).append("\n"); 
		query.append("       INFO.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       INFO.TR," ).append("\n"); 
		query.append("       INFO.DCGO_FLG," ).append("\n"); 
		query.append("       INFO.RC_FLG," ).append("\n"); 
		query.append("       SLOG.TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("       SLOG.MF_SND_DT," ).append("\n"); 
		query.append("       INFO.CNTR_CNT," ).append("\n"); 
		query.append("       INFO.MEA_QTY," ).append("\n"); 
		query.append("       INFO.FRT_TERM_CD," ).append("\n"); 
		query.append("       INFO.RCV_TERM_CD," ).append("\n"); 
		query.append("       INFO.DE_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY INFO.BL_NO" ).append("\n"); 

	}
}