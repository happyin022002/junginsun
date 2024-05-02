/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DominicanManifestDownloadDBDAOsearchDominicanManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DominicanManifestDownloadDBDAOsearchDominicanManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDominicanManifestList
	  * </pre>
	  */
	public DominicanManifestDownloadDBDAOsearchDominicanManifestListRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.integration").append("\n"); 
		query.append("FileName : DominicanManifestDownloadDBDAOsearchDominicanManifestListRSQL").append("\n"); 
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
		query.append("SELECT TT.*" ).append("\n"); 
		query.append("       ,SUBSTR(TT.Spcl_Cgo_Desc_TMP, 1, LENGTH(TT.Spcl_Cgo_Desc_TMP) - 3) AS Spcl_Cgo_Desc" ).append("\n"); 
		query.append("       ,CASE WHEN INSTR(SUBSTR(TT.Spcl_Cgo_Desc_TMP, 1, LENGTH(TT.Spcl_Cgo_Desc_TMP) - 3), '/') > 0  " ).append("\n"); 
		query.append("                THEN 'M'" ).append("\n"); 
		query.append("                ELSE spcl_Cgo_Desc_Type_tmp" ).append("\n"); 
		query.append("        END AS spcl_Cgo_Desc_Type" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT T.*" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,(         " ).append("\n"); 
		query.append("               CASE WHEN DG_Spcl_Cgo_Desc IS NOT NULL THEN DG_Spcl_Cgo_Desc || ' / ' ELSE '' END" ).append("\n"); 
		query.append("            || CASE WHEN AW_Spcl_Cgo_Desc IS NOT NULL THEN AW_Spcl_Cgo_Desc || ' / ' ELSE '' END" ).append("\n"); 
		query.append("            || CASE WHEN RC_Spcl_Cgo_Desc IS NOT NULL THEN RC_Spcl_Cgo_Desc || ' / ' ELSE '' END" ).append("\n"); 
		query.append("            || CASE WHEN PC_Spcl_Cgo_Desc IS NOT NULL THEN PC_Spcl_Cgo_Desc || ' / ' ELSE '' END" ).append("\n"); 
		query.append("            || CASE WHEN RD_Spcl_Cgo_Desc IS NOT NULL THEN RD_Spcl_Cgo_Desc || ' / ' ELSE '' END" ).append("\n"); 
		query.append("            || CASE WHEN HG_Spcl_Cgo_Desc IS NOT NULL THEN HG_Spcl_Cgo_Desc || ' / ' ELSE '' END" ).append("\n"); 
		query.append("           ) Spcl_Cgo_Desc_TMP                " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("         ,( SELECT DECODE(NVL(MAX(SO.BKG_NO), 'N'), 'N', 'N', 'Y') AS woFlg" ).append("\n"); 
		query.append("                FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                ,TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                AND SO.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("                AND NVL(SO.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                AND SO.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("                AND SO.EQ_NO = T.CNTR_NO" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("                AND SO.TO_NOD_CD LIKE T.POD_CD||'%'" ).append("\n"); 
		query.append("           ) WO_FLG" ).append("\n"); 
		query.append("           ,ROUND((round(nvl(ACT_WGT, 0) * decode(substr(CNTR_TPSZ_CD, 2, 1), '2', 1, 2) / TOT) +" ).append("\n"); 
		query.append("            NVL(CNTR_VOL_QTY, 1)* decode(nvl(mst_tare,0), 0, decode(nvl(mdm_tare,0), 0, 2500, mdm_tare), mst_tare))/1000) E_CNTR_WGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT CNTR.CNTR_NO," ).append("\n"); 
		query.append("               CNTR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               SEAL.CNTR_SEAL_NO," ).append("\n"); 
		query.append("               SEAL.SEAL_KND_CD," ).append("\n"); 
		query.append("               SEAL.SEAL_PTY_TP_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               MAX(CNTR.CNTR_WGT) A_CNTR_WGT," ).append("\n"); 
		query.append("               ROUND(CNTR.CNTR_WGT/1000, 0) CNTR_WGT," ).append("\n"); 
		query.append("               DOC.ACT_WGT," ).append("\n"); 
		query.append("               CNTR.PCK_QTY," ).append("\n"); 
		query.append("               BKG.BKG_NO," ).append("\n"); 
		query.append("               BKG.BL_NO||BKG.BL_TP_CD BL_NO," ).append("\n"); 
		query.append("               BKG.POR_CD," ).append("\n"); 
		query.append("               BKG.POL_CD A_POL_CD," ).append("\n"); 
		query.append("               BKG.POD_CD A_POD_CD," ).append("\n"); 
		query.append("               BKG.DEL_CD," ).append("\n"); 
		query.append("               BKG.BLCK_STWG_CD," ).append("\n"); 
		query.append("               CNTR.RCV_TERM_CD," ).append("\n"); 
		query.append("               CNTR.DE_TERM_CD," ).append("\n"); 
		query.append("               DECODE(BKG.POD_CD, VVD.POD_CD, 'L', 'T') TS_CD," ).append("\n"); 
		query.append("               BKG.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("               BKG.HOT_DE_FLG," ).append("\n"); 
		query.append("               DECODE(BKG.CUST_TO_ORD_FLG, 'Y', REPLACE(TRANSLATE(NVL(BCN.CUST_NM, ' '), CHR(13)||CHR(10), ' '), '''', ' '), REPLACE(TRANSLATE(NVL(MAX(BCC.CUST_NM), ' '), CHR(13)||CHR(10), ' '), '''', ' ')) CUST_NM," ).append("\n"); 
		query.append("               CNTR.SOC_FLG," ).append("\n"); 
		query.append("               BKG.STWG_CD," ).append("\n"); 
		query.append("               CM.HAMO_TRF_CD," ).append("\n"); 
		query.append("               CM.CMDT_HS_CD," ).append("\n"); 
		query.append("               CNTR.CNTR_VOL_QTY," ).append("\n"); 
		query.append("               (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, 2)) TOT" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                 WHERE BC.BKG_NO = BKG.BKG_NO ) TOT," ).append("\n"); 
		query.append("               CNTR.PCK_TP_CD," ).append("\n"); 
		query.append("               SUBSTR(BKG.POR_NOD_CD, 6, 2) POR_NOD_CD," ).append("\n"); 
		query.append("               SUBSTR(BKG.POL_NOD_CD, 6, 2) POL_NOD_CD," ).append("\n"); 
		query.append("               SUBSTR(BKG.POD_NOD_CD, 6, 2) POD_NOD_CD," ).append("\n"); 
		query.append("               SUBSTR(BKG.DEL_NOD_CD, 6, 2) DEL_NOD_CD," ).append("\n"); 
		query.append("               BKG.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("               VVD.POL_CD," ).append("\n"); 
		query.append("               SUBSTR(VVD.POL_YD_CD, 6, 2) POL_YD_CD," ).append("\n"); 
		query.append("               VVD.POD_CD," ).append("\n"); 
		query.append("               SUBSTR(VVD.POD_YD_CD, 6, 2) POD_YD_CD," ).append("\n"); 
		query.append("               CNTR.MEAS_QTY*1000 MEAS_QTY," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               CNTR.DCGO_FLG," ).append("\n"); 
		query.append("               CNTR.RC_FLG," ).append("\n"); 
		query.append("               CNTR.AWK_CGO_FLG," ).append("\n"); 
		query.append("               CNTR.RD_CGO_FLG," ).append("\n"); 
		query.append("               BKG.PRCT_FLG," ).append("\n"); 
		query.append("               CNTR.HNGR_FLG," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               CASE WHEN CNTR.DCGO_FLG = 'Y' THEN 'D'" ).append("\n"); 
		query.append("                    WHEN CNTR.RC_FLG = 'Y' THEN 'R'" ).append("\n"); 
		query.append("                    WHEN CNTR.AWK_CGO_FLG = 'Y' THEN 'A'" ).append("\n"); 
		query.append("                    WHEN BKG.PRCT_FLG = 'Y' THEN 'P'" ).append("\n"); 
		query.append("                    WHEN CNTR.RD_CGO_FLG = 'Y' THEN 'RD'" ).append("\n"); 
		query.append("                    WHEN CNTR.HNGR_FLG = 'Y' THEN 'GOH'" ).append("\n"); 
		query.append("                    ELSE ''" ).append("\n"); 
		query.append("               END AS spcl_Cgo_Desc_Type_TMP," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               CASE WHEN CNTR.DCGO_FLG = 'Y' " ).append("\n"); 
		query.append("                    THEN " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT	" ).append("\n"); 
		query.append("                                'Cls:'||NVL(IMDG_CLSS_CD,' ')||' UN:'||NVL(IMDG_UN_NO,' ')||DECODE(NVL(TRIM(HCDG_FLG), 'N'), 'Y', ' HCDG', '') SPCL_CGO_DESC" ).append("\n"); 
		query.append("                            FROM	BKG_DG_CGO" ).append("\n"); 
		query.append("                            WHERE	BKG_NO   = BKG.BKG_NO" ).append("\n"); 
		query.append("                            AND	CNTR_NO      = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                            AND	ROWNUM       = 1                    " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    ELSE ''" ).append("\n"); 
		query.append("               END AS DG_Spcl_Cgo_Desc," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               CASE WHEN CNTR.AWK_CGO_FLG = 'Y' " ).append("\n"); 
		query.append("                    THEN " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT	TO_CHAR(NVL(CDO_TEMP,0),9990.9)||'C'  SPCL_CGO_DESC" ).append("\n"); 
		query.append("                            FROM	BKG_RF_CGO" ).append("\n"); 
		query.append("                            WHERE	BKG_NO   = BKG.BKG_NO" ).append("\n"); 
		query.append("                            AND	CNTR_NO      = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                            AND	ROWNUM       = 1                 " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    ELSE ''" ).append("\n"); 
		query.append("               END AS AW_Spcl_Cgo_Desc," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               CASE WHEN CNTR.RC_FLG = 'Y' " ).append("\n"); 
		query.append("                    THEN " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT	'F:'||TO_CHAR(NVL(OVR_FWRD_LEN,0))||'/'||" ).append("\n"); 
		query.append("                                    'B:'||TO_CHAR(NVL(OVR_BKWD_LEN,0))||'/'||" ).append("\n"); 
		query.append("                                    'H:'||TO_CHAR(NVL(OVR_HGT,0))||'/'||" ).append("\n"); 
		query.append("                                    'P:'||TO_CHAR(NVL(OVR_LF_LEN,0))||'/'||" ).append("\n"); 
		query.append("                                    'S:'||TO_CHAR(NVL(OVR_RT_LEN,0))  SPCL_CGO_DESC" ).append("\n"); 
		query.append("                            FROM	BKG_AWK_CGO" ).append("\n"); 
		query.append("                            WHERE	BKG_NO   = BKG.BKG_NO" ).append("\n"); 
		query.append("                            AND	CNTR_NO      = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                            AND	ROWNUM = 1" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    ELSE ''" ).append("\n"); 
		query.append("               END AS RC_Spcl_Cgo_Desc," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               CASE WHEN BKG.PRCT_FLG = 'Y' " ).append("\n"); 
		query.append("                    THEN 'Precaution cargo'" ).append("\n"); 
		query.append("                    ELSE ''" ).append("\n"); 
		query.append("               END AS PC_Spcl_Cgo_Desc," ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("               CASE WHEN CNTR.RD_CGO_FLG = 'Y' " ).append("\n"); 
		query.append("                    THEN 'Reefer Dry'" ).append("\n"); 
		query.append("                    ELSE ''" ).append("\n"); 
		query.append("               END AS RD_Spcl_Cgo_Desc," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               CASE WHEN CNTR.HNGR_FLG = 'Y' " ).append("\n"); 
		query.append("                    THEN 'Hanger'" ).append("\n"); 
		query.append("                    ELSE ''" ).append("\n"); 
		query.append("               END AS HG_Spcl_Cgo_Desc," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            (SELECT /*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                  nvl(DEST_YD_CD, NVL(ORG_YD_CD, ' ')) ORG_YD_CD" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                 WHERE CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                   AND MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("                   AND CNMV_YR = to_char(sysdate, 'YYYY')" ).append("\n"); 
		query.append("                   AND ROWNUM = 1 ) ORG_YD_CD," ).append("\n"); 
		query.append("               (SELECT /*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                  to_char(CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                 WHERE CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                   AND MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("                   AND CNMV_YR = to_char(sysdate, 'YYYY')" ).append("\n"); 
		query.append("                   AND ROWNUM =1 ) CNMV_EVNT_DT," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("    --           MAX(CNTR.RD_CGO_FLG) RD_CGO_FLG, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               MAX(DOC.CSTMS_DESC) CSTMS_DESC," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               (SELECT MAX(NVL(SPEC.TARE_WGT, 0)) MST_WGT" ).append("\n"); 
		query.append("                FROM MST_CONTAINER MST," ).append("\n"); 
		query.append("                MST_CNTR_SPEC SPEC" ).append("\n"); 
		query.append("                WHERE MST.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                AND MST.CNTR_SPEC_NO = SPEC.CNTR_SPEC_NO ) MST_TARE," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT MAX(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0)) MDM_WGT" ).append("\n"); 
		query.append("                FROM MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                WHERE MDM.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ) MDM_TARE" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("               BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("               BKG_BL_DOC DOC," ).append("\n"); 
		query.append("               BKG_VVD VVD," ).append("\n"); 
		query.append("               BKG_VVD BKGVVD," ).append("\n"); 
		query.append("               BKG_CUSTOMER BCS," ).append("\n"); 
		query.append("               BKG_CUSTOMER BCC," ).append("\n"); 
		query.append("               BKG_CUSTOMER BCN," ).append("\n"); 
		query.append("               BKG_CNTR_MF_DESC CM," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               BKG_CNTR_SEAL_NO SEAL," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               MDM_LOCATION MDM ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               MDM_LOCATION POR ," ).append("\n"); 
		query.append("               MDM_LOCATION APOL ," ).append("\n"); 
		query.append("               MDM_LOCATION APOD ," ).append("\n"); 
		query.append("               MDM_LOCATION BPOL ," ).append("\n"); 
		query.append("               MDM_LOCATION BPOD ," ).append("\n"); 
		query.append("               MDM_LOCATION DEL" ).append("\n"); 
		query.append("         WHERE VVD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = BKGVVD.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD <> 'S'" ).append("\n"); 
		query.append("           AND BKG.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BKG.POL_CD = APOL.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BKG.POD_CD = APOD.LOC_CD(+)" ).append("\n"); 
		query.append("           AND VVD.POL_CD = BPOL.LOC_CD(+)" ).append("\n"); 
		query.append("           AND VVD.POD_CD = BPOD.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BKG.DEL_CD = DEL.LOC_CD(+)" ).append("\n"); 
		query.append("           AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.POD_CD <> 'XXXXX'" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("           AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = BCC.BKG_NO" ).append("\n"); 
		query.append("           AND BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = BCN.BKG_NO" ).append("\n"); 
		query.append("           AND BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("           AND NVL(BKG.BKG_STS_CD, ' ') NOT IN ('X','A')" ).append("\n"); 
		query.append("           AND '1' = '1'" ).append("\n"); 
		query.append("           AND MDM.LOC_CD = BKG.DEL_CD" ).append("\n"); 
		query.append("           AND CNTR.BKG_NO = CM.BKG_NO (+)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = CM.CNTR_NO (+)" ).append("\n"); 
		query.append("           AND CM.CNTR_MF_SEQ (+) = 1" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND CNTR.BKG_NO = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND CNTR_SEAL_SEQ(+) = 1" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         GROUP BY CNTR.CNTR_NO," ).append("\n"); 
		query.append("               CNTR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               SEAL.CNTR_SEAL_NO," ).append("\n"); 
		query.append("               SEAL.SEAL_KND_CD," ).append("\n"); 
		query.append("               SEAL.SEAL_PTY_TP_CD,       " ).append("\n"); 
		query.append("               CNTR.CNTR_WGT," ).append("\n"); 
		query.append("               DOC.ACT_WGT," ).append("\n"); 
		query.append("               CNTR.PCK_QTY," ).append("\n"); 
		query.append("               BKG.BKG_NO," ).append("\n"); 
		query.append("               BKG.BL_NO||BKG.BL_TP_CD," ).append("\n"); 
		query.append("               BKG.POR_CD," ).append("\n"); 
		query.append("               BKG.POL_CD," ).append("\n"); 
		query.append("               BKG.POD_CD," ).append("\n"); 
		query.append("               BKG.DEL_CD," ).append("\n"); 
		query.append("               BKG.BLCK_STWG_CD," ).append("\n"); 
		query.append("               CNTR.RCV_TERM_CD," ).append("\n"); 
		query.append("               CNTR.DE_TERM_CD," ).append("\n"); 
		query.append("               BKG.POL_CD," ).append("\n"); 
		query.append("               VVD.POL_CD," ).append("\n"); 
		query.append("               BKG.POD_CD," ).append("\n"); 
		query.append("               VVD.POD_CD," ).append("\n"); 
		query.append("               BKG.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("               BKG.HOT_DE_FLG," ).append("\n"); 
		query.append("               BKG.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("               BCN.CUST_NM," ).append("\n"); 
		query.append("               CNTR.SOC_FLG," ).append("\n"); 
		query.append("               BKG.STWG_CD," ).append("\n"); 
		query.append("               CM.HAMO_TRF_CD," ).append("\n"); 
		query.append("               CM.CMDT_HS_CD," ).append("\n"); 
		query.append("               CNTR.CNTR_VOL_QTY," ).append("\n"); 
		query.append("               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               CNTR.PCK_TP_CD," ).append("\n"); 
		query.append("               BKG.POR_NOD_CD," ).append("\n"); 
		query.append("               BKG.POL_NOD_CD," ).append("\n"); 
		query.append("               BKG.POD_NOD_CD," ).append("\n"); 
		query.append("               BKG.DEL_NOD_CD," ).append("\n"); 
		query.append("               BKG.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("               VVD.POL_CD," ).append("\n"); 
		query.append("               VVD.POL_YD_CD," ).append("\n"); 
		query.append("               VVD.POD_CD," ).append("\n"); 
		query.append("               VVD.POD_YD_CD," ).append("\n"); 
		query.append("               CNTR.MEAS_QTY," ).append("\n"); 
		query.append("               BKG.PRCT_FLG," ).append("\n"); 
		query.append("               CNTR.DCGO_FLG," ).append("\n"); 
		query.append("               CNTR.RC_FLG," ).append("\n"); 
		query.append("               CNTR.AWK_CGO_FLG," ).append("\n"); 
		query.append("               CNTR.RD_CGO_FLG," ).append("\n"); 
		query.append("               CNTR.HNGR_FLG," ).append("\n"); 
		query.append("               DEST_YD_CD," ).append("\n"); 
		query.append("               ORG_YD_CD," ).append("\n"); 
		query.append("               CNMV_EVNT_DT" ).append("\n"); 
		query.append("         ORDER BY POL_CD," ).append("\n"); 
		query.append("               POD_CD," ).append("\n"); 
		query.append("               CNTR_NO," ).append("\n"); 
		query.append("               BKG_NO " ).append("\n"); 
		query.append("        ) T           " ).append("\n"); 
		query.append("    ) TT        " ).append("\n"); 

	}
}