/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BrcsManifestDownloadDBDAOsearchBrManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.03.11 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsManifestDownloadDBDAOsearchBrManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Brazil세관에서 대상 조회를 한다.
	  * searchBrManifestList
	  * </pre>
	  */
	public BrcsManifestDownloadDBDAOsearchBrManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnpj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("br_mid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_duv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration").append("\n"); 
		query.append("FileName : BrcsManifestDownloadDBDAOsearchBrManifestListRSQL").append("\n"); 
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
		query.append("SELECT  MAIN.BL_NO                                                       AS BL_NO" ).append("\n"); 
		query.append("      , SUM(MAIN.C_BL_NO) OVER (ORDER BY BL_NO)                          AS BL_GROUP" ).append("\n"); 
		query.append("      , MAIN.BKG_NO                                                      AS BKG_NO" ).append("\n"); 
		query.append("      , MAIN.BKG_CGO_TP_CD                                               AS SEARCH_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      , MAIN.CUST_TO_ORD_FLG                                             AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("      , MAIN.SHIPPER_CUST_NM                                             AS SHIPPER_CUST_NM" ).append("\n"); 
		query.append("      , MAIN.OB_SHPR_TAX_NO                                              AS OB_SHPR_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.SHPR_TAX_NO                                                 AS SHPR_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.CONSIGNEE_CUST_NM                                           AS CONSIGNEE_CUST_NM" ).append("\n"); 
		query.append("      , MAIN.OB_CNEE_TAX_NO                                              AS OB_CNEE_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.CNEE_TAX_NO                                                 AS CNEE_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.NOTIFY_CUST_NM                                              AS NOTIFY_CUST_NM" ).append("\n"); 
		query.append("      , MAIN.OB_NTFY_TAX_NO                                              AS OB_NTFY_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.NTFY_TAX_NO                                                 AS NTFY_TAX_NO" ).append("\n"); 
		query.append("      , MAIN.BRZ_DECL_NO                                                 AS BRZ_DECL_NO" ).append("\n"); 
		query.append("      , MAIN.IF_FLAG                                                     AS IF_FLAG" ).append("\n"); 
		query.append("      , MAIN.CNTR_NO                                                     AS CNTR_NO" ).append("\n"); 
		query.append("      , MAIN.PCK_QTY                                                     AS PCK_QTY" ).append("\n"); 
		query.append("      , MAIN.PCK_TP_CD                                                   AS PCK_TP_CD" ).append("\n"); 
		query.append("      , MAIN.WEIGHT                                                      AS WEIGHT" ).append("\n"); 
		query.append("      , MAIN.WGT_UT_CD                                                   AS WGT_UT_CD" ).append("\n"); 
		query.append("      , MAIN.MEASURE                                                     AS MEASURE" ).append("\n"); 
		query.append("      , MAIN.MEAS_UT_CD                                                  AS MEAS_UT_CD" ).append("\n"); 
		query.append("      , MAIN.NCM_NO                                                      AS NCM_NO" ).append("\n"); 
		query.append("      , MAIN.NCM_MULTI_NO                                                AS NCM_MULTI_NO" ).append("\n"); 
		query.append("      , MAIN.CSTMS_DESC                                                  AS CSTMS_DESC" ).append("\n"); 
		query.append("      , MAIN.BOOKING_CMDT_NM                                             AS BOOKING_CMDT_NM" ).append("\n"); 
		query.append("      , MAIN.CNTR_MF_SEQ                                                 AS CNTR_MF_SEQ" ).append("\n"); 
		query.append("      , MAIN.VVD_CD                                                      AS VVD_CD" ).append("\n"); 
		query.append("      , MAIN.POL_CD                                                      AS POL_CD" ).append("\n"); 
		query.append("      , MAIN.POD_CD                                                      AS POD_CD" ).append("\n"); 
		query.append("      , MAIN.DEL_CD                                                      AS DEL_CD" ).append("\n"); 
		query.append("      , MAIN.OFT                                                         AS OFT" ).append("\n"); 
		query.append("      , CASE WHEN @[io_type] = 'O' THEN MAIN.OTH" ).append("\n"); 
		query.append("                                   ELSE MAIN.DTH" ).append("\n"); 
		query.append("         END                                                             AS CAP" ).append("\n"); 
		query.append("      , NVL(MAIN.BRZ_CSTMS_DUV_NM, ' ')                                  AS BR_DUV" ).append("\n"); 
		query.append("      , NVL(MAIN.BRZ_CSTMS_MF_ID, ' ')                                   AS BR_MID" ).append("\n"); 
		query.append("      , DECODE(MAIN.IF_FLAG, 'Y', '1', '0')                              AS NCM_MULTI_POP" ).append("\n"); 
		query.append("      , DECODE(NVL(INSTR(MAIN.NCM_MULTI_NO, ',', 1), 0), 0, 'N', 'Y')    AS NCM_MULTI_FLG" ).append("\n"); 
		query.append("      -- Data Delete 버튼이 보이게 하는 여부" ).append("\n"); 
		query.append("	   ,NVL((SELECT 'Y'  " ).append("\n"); 
		query.append("             FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("	         WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("             AND CSTMS_DIV_ID = 'NA_STAFF'" ).append("\n"); 
		query.append("             AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("             AND ATTR_CTNT1 = @[upd_usr_id]" ).append("\n"); 
		query.append("             AND ROWNUM = 1), 'N') AS NA_STF_FLG" ).append("\n"); 
		query.append("  FROM  (SELECT  B.BL_NO" ).append("\n"); 
		query.append("               , DECODE(LAG(B.BL_NO) OVER ( ORDER BY B.BL_NO, B.CNTR_NO, B.CNTR_MF_SEQ) , B.BL_NO, 0, 1) AS C_BL_NO" ).append("\n"); 
		query.append("               , B.BKG_NO" ).append("\n"); 
		query.append("               , B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("               , B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("               , (SELECT  REPLACE(CUST_NM, CHR(13)||CHR(10), ' ')" ).append("\n"); 
		query.append("                    FROM  BKG_CUSTOMER" ).append("\n"); 
		query.append("                   WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                     AND  BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                 )                                                       AS SHIPPER_CUST_NM" ).append("\n"); 
		query.append("               , B.SHPR_TAX_NO                                           AS OB_SHPR_TAX_NO" ).append("\n"); 
		query.append("               , DECODE(BL.BL_NO, NULL, B.SHPR_TAX_NO, BL.SHPR_TAX_NO)   AS SHPR_TAX_NO" ).append("\n"); 
		query.append("               , (SELECT  REPLACE(CUST_NM, CHR(13)||CHR(10), ' ')" ).append("\n"); 
		query.append("                    FROM  BKG_CUSTOMER" ).append("\n"); 
		query.append("                   WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                     AND  BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                 )                                                       AS CONSIGNEE_CUST_NM" ).append("\n"); 
		query.append("               , B.CNEE_TAX_NO                                           AS OB_CNEE_TAX_NO" ).append("\n"); 
		query.append("               , DECODE(BL.BL_NO, NULL, B.CNEE_TAX_NO, BL.CNEE_TAX_NO)   AS CNEE_TAX_NO" ).append("\n"); 
		query.append("               , (SELECT  REPLACE(CUST_NM, CHR(13)||CHR(10), ' ')" ).append("\n"); 
		query.append("                    FROM  BKG_CUSTOMER" ).append("\n"); 
		query.append("                   WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                     AND  BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                 )                                                       AS NOTIFY_CUST_NM" ).append("\n"); 
		query.append("               , B.NTFY_TAX_NO                                           AS OB_NTFY_TAX_NO" ).append("\n"); 
		query.append("               , DECODE(BL.BL_NO, NULL, B.NTFY_TAX_NO, BL.NTFY_TAX_NO)   AS NTFY_TAX_NO" ).append("\n"); 
		query.append("               , DECODE(BL.BL_NO, NULL, B.BRZ_DECL_NO, BL.BRZ_DECL_NO)   AS BRZ_DECL_NO" ).append("\n"); 
		query.append("               , DECODE(BL.BL_NO, NULL, 'N', 'Y')                        AS IF_FLAG" ).append("\n"); 
		query.append("               , B.CNTR_NO" ).append("\n"); 
		query.append("               , B.PCK_QTY" ).append("\n"); 
		query.append("               , B.PCK_TP_CD" ).append("\n"); 
		query.append("               , B.CNTR_MF_WGT AS WEIGHT" ).append("\n"); 
		query.append("               , B.WGT_UT_CD" ).append("\n"); 
		query.append("               , B.MEAS_QTY    AS MEASURE" ).append("\n"); 
		query.append("               , B.MEAS_UT_CD" ).append("\n"); 
		query.append("               , DECODE(BL.BL_NO, NULL, B.NCM_NO, BC.BRZ_CMDT_CD)        AS NCM_NO" ).append("\n"); 
		query.append("               , BKG_JOIN_FNC(CURSOR(SELECT BRZ_CMDT_CD" ).append("\n"); 
		query.append("                                       FROM BKG_CSTMS_BRZ_CNTR_MF_DTL" ).append("\n"); 
		query.append("                                      WHERE BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("                                        AND CNTR_NO     = B.CNTR_NO" ).append("\n"); 
		query.append("                                        AND CNTR_MF_SEQ = B.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                              )                                          AS NCM_MULTI_NO" ).append("\n"); 
		query.append("               ,(SELECT Z.CMDT_DESC" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_CMDT Z" ).append("\n"); 
		query.append("                  WHERE Z.CNT_CD = 'BR'" ).append("\n"); 
		query.append("                    AND Z.MF_CMDT_CD = DECODE(BL.BL_NO, NULL, B.NCM_NO, BC.BRZ_CMDT_CD)" ).append("\n"); 
		query.append("                )                                                        AS CSTMS_DESC" ).append("\n"); 
		query.append("               , (SELECT  CMDT_NM" ).append("\n"); 
		query.append("                    FROM  MDM_COMMODITY" ).append("\n"); 
		query.append("                   WHERE  CMDT_CD = B.CMDT_CD" ).append("\n"); 
		query.append("                 ) BOOKING_CMDT_NM" ).append("\n"); 
		query.append("               , B.CNTR_MF_SEQ" ).append("\n"); 
		query.append("               , NVL((SELECT  'Y'" ).append("\n"); 
		query.append("                        FROM  BKG_CHG_RT" ).append("\n"); 
		query.append("                       WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND  CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                         AND  ROWNUM = 1" ).append("\n"); 
		query.append("                     ),'N') AS OFT" ).append("\n"); 
		query.append("               , NVL((SELECT  'Y'" ).append("\n"); 
		query.append("                        FROM  BKG_CHG_RT" ).append("\n"); 
		query.append("                       WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND  CHG_CD = 'OTH'" ).append("\n"); 
		query.append("                         AND  ROWNUM = 1" ).append("\n"); 
		query.append("                      ),'N') AS OTH" ).append("\n"); 
		query.append("               , NVL((SELECT  'Y'" ).append("\n"); 
		query.append("                        FROM  BKG_CHG_RT" ).append("\n"); 
		query.append("                       WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND  CHG_CD = 'DTH'" ).append("\n"); 
		query.append("                         AND  ROWNUM = 1" ).append("\n"); 
		query.append("                      ),'N') DTH" ).append("\n"); 
		query.append("               , BL.BRZ_CSTMS_DUV_NM" ).append("\n"); 
		query.append("               , BL.BRZ_CSTMS_MF_ID" ).append("\n"); 
		query.append("               , B.VVD_CD" ).append("\n"); 
		query.append("               , B.POL_CD" ).append("\n"); 
		query.append("               , B.POD_CD" ).append("\n"); 
		query.append("               , B.DEL_CD" ).append("\n"); 
		query.append("           FROM  (SELECT  B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                        , B.BKG_NO" ).append("\n"); 
		query.append("                        , B.BL_NO,B.CMDT_CD" ).append("\n"); 
		query.append("                        , D.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                        , C.CNTR_NO" ).append("\n"); 
		query.append("                        , B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                        , MAX(D.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("                        , MAX(NVL(D.PCK_TP_CD, C.PCK_TP_CD) ) PCK_TP_CD" ).append("\n"); 
		query.append("                        , MAX(D.CNTR_MF_WGT) CNTR_MF_WGT" ).append("\n"); 
		query.append("                        , MAX(NVL(D.WGT_UT_CD, C.WGT_UT_CD) ) WGT_UT_CD" ).append("\n"); 
		query.append("                        , MAX(D.MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("                        , MAX(NVL(D.MEAS_UT_CD, C.MEAS_UT_CD) ) MEAS_UT_CD" ).append("\n"); 
		query.append("                        , MAX(D.NCM_NO) NCM_NO" ).append("\n"); 
		query.append("                        , MAX(V.VSL_CD||V.SKD_VOY_NO||V.SKD_dIR_cD) VVD_CD" ).append("\n"); 
		query.append("                        , MAX(V.POL_CD) POL_CD" ).append("\n"); 
		query.append("                        , MAX(V.POD_CD) POD_CD" ).append("\n"); 
		query.append("                        , MAX(B.DEL_CD) DEL_CD" ).append("\n"); 
		query.append("                        , MAX(A.XPT_IMP_SEQ) XPT_IMP_SEQ" ).append("\n"); 
		query.append("                        , MAX(A.SHPR_TAX_NO) SHPR_TAX_NO" ).append("\n"); 
		query.append("                        , MAX(A.CNEE_TAX_NO) CNEE_TAX_NO" ).append("\n"); 
		query.append("                        , MAX(A.NTFY_TAX_NO) NTFY_TAX_NO" ).append("\n"); 
		query.append("                        , MAX(A.BRZ_DECL_NO) BRZ_DECL_NO" ).append("\n"); 
		query.append("                        , MAX(A.BRZ_CMDT_CD) BRZ_CMDT_CD" ).append("\n"); 
		query.append("                    FROM  BKG_BOOKING       B" ).append("\n"); 
		query.append("                        , BKG_VVD           V" ).append("\n"); 
		query.append("                        , BKG_CONTAINER     C" ).append("\n"); 
		query.append("                        , BKG_CNTR_MF_DESC  D" ).append("\n"); 
		query.append("                        , BKG_XPT_IMP_LIC   A" ).append("\n"); 
		query.append("                   WHERE  1 = 1" ).append("\n"); 
		query.append("                     AND  B.BKG_NO  = V.BKG_NO" ).append("\n"); 
		query.append("                     AND  B.BKG_NO  = C.BKG_NO(+)" ).append("\n"); 
		query.append("                     AND  C.BKG_NO  = D.BKG_NO(+)" ).append("\n"); 
		query.append("                     AND  C.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("                     AND  B.BKG_NO  = A.BKG_NO(+)" ).append("\n"); 
		query.append("                     AND  A.IO_BND_CD(+) = @[io_type]" ).append("\n"); 
		query.append("                     AND  (B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                           OR (B.BKG_STS_CD = 'S' AND B.SPLIT_RSN_CD ='M')" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                     AND  V.VSL_CD     = SUBSTR (@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                     AND  V.SKD_VOY_NO = SUBSTR (@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                     AND  V.SKD_DIR_CD = SUBSTR (@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                     AND  V.POL_CD        = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                     AND  V.POD_CD        = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                     AND  B.BL_NO         = @[bl_no]" ).append("\n"); 
		query.append("                     AND  DECODE( @[io_type], 'O', SUBSTR(V.POL_CD,1,2), SUBSTR(V.POD_CD,1,2) )  = 'BR'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'F')" ).append("\n"); 
		query.append("                     AND  B.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("#elseif (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("                     AND  B.BKG_CGO_TP_CD IN ('P')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                     AND  B.DEL_CD        = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                GROUP BY  B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                        , B.BKG_NO" ).append("\n"); 
		query.append("                        , B.BL_NO,B.CMDT_CD" ).append("\n"); 
		query.append("                        , B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                        , D.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                        , C.CNTR_NO" ).append("\n"); 
		query.append("                 ) B" ).append("\n"); 
		query.append("                 , BKG_CSTMS_BRZ_BL          BL" ).append("\n"); 
		query.append("                 , BKG_CSTMS_BRZ_CNTR_MF_DTL BC" ).append("\n"); 
		query.append("            WHERE  1 = 1" ).append("\n"); 
		query.append("              AND  B.BL_NO             = BL.BL_NO(+)" ).append("\n"); 
		query.append("              AND  B.BL_NO             = BC.BL_NO(+)" ).append("\n"); 
		query.append("              AND  B.CNTR_NO           = BC.CNTR_NO(+)" ).append("\n"); 
		query.append("              AND  B.CNTR_MF_SEQ       = BC.CNTR_MF_SEQ(+)" ).append("\n"); 
		query.append("              AND  BC.MF_DTL_SEQ(+)    = 1" ).append("\n"); 
		query.append("#if (${br_duv} != '')" ).append("\n"); 
		query.append("              AND  UPPER(BL.BRZ_CSTMS_DUV_NM) = @[br_duv]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${br_mid} != '')" ).append("\n"); 
		query.append("              AND  UPPER(BL.BRZ_CSTMS_MF_ID)  = @[br_mid]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ORDER BY  BL_NO" ).append("\n"); 
		query.append("                 , CNTR_NO" ).append("\n"); 
		query.append("                 , B.CNTR_MF_SEQ" ).append("\n"); 
		query.append("      ) MAIN" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${cnpj_no} != '')" ).append("\n"); 
		query.append("   AND  UPPER(CNEE_TAX_NO) = @[cnpj_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${error_type} == '2')" ).append("\n"); 
		query.append("  #if (${io_type} == 'O')" ).append("\n"); 
		query.append("  AND  (   NVL(CNEE_TAX_NO, ' ') = ' '" ).append("\n"); 
		query.append("        OR NVL(BRZ_DECL_NO, ' ') = ' '" ).append("\n"); 
		query.append("        OR NVL(PCK_QTY, 0) = 0" ).append("\n"); 
		query.append("        OR NVL(PCK_TP_CD, ' ') = ' '" ).append("\n"); 
		query.append("        OR NVL(WEIGHT, 0) = 0" ).append("\n"); 
		query.append("        OR NVL(MEASURE, 0) = 0" ).append("\n"); 
		query.append("        OR NVL(NCM_NO, ' ') = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${io_type} == 'I')" ).append("\n"); 
		query.append("  AND  (   NVL(SHPR_TAX_NO, ' ') = ' '" ).append("\n"); 
		query.append("        OR NVL(PCK_QTY, 0) = 0" ).append("\n"); 
		query.append("        OR NVL(PCK_TP_CD, ' ') = ' '" ).append("\n"); 
		query.append("        OR NVL(WEIGHT, 0) = 0" ).append("\n"); 
		query.append("        OR NVL(MEASURE, 0) = 0" ).append("\n"); 
		query.append("        OR NVL(NCM_NO, ' ') = ' '" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}