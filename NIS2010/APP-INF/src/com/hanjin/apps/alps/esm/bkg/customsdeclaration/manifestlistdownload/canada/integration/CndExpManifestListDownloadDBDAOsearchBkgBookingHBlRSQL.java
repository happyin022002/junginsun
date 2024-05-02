/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOsearchBkgBookingHBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpManifestListDownloadDBDAOsearchBkgBookingHBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOsearchBkgBookingHBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOsearchBkgBookingHBlRSQL").append("\n"); 
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
		query.append("SELECT  'CA' AS CNT_CD" ).append("\n"); 
		query.append("      , H.CNTR_MF_NO AS BL_NO" ).append("\n"); 
		query.append("	  , B.BKG_NO" ).append("\n"); 
		query.append("      , V.VSL_CD" ).append("\n"); 
		query.append("      , V.SKD_VOY_NO" ).append("\n"); 
		query.append("      , V.SKD_DIR_CD" ).append("\n"); 
		query.append("	  , B.SLAN_CD" ).append("\n"); 
		query.append("	  , TO_CHAR(VPS.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS VSL_ARR_DT" ).append("\n"); 
		query.append("      , V.POL_CD AS CSTMS_POL_CD" ).append("\n"); 
		query.append("      , V.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("      , B.POR_CD" ).append("\n"); 
		query.append("      , B.POL_CD" ).append("\n"); 
		query.append("      , B.POD_CD" ).append("\n"); 
		query.append("      , B.DEL_CD" ).append("\n"); 
		query.append("      , CASE WHEN SUBSTR(V.POD_CD, 1, 2) <> 'CA' " ).append("\n"); 
		query.append("             THEN (SELECT /*+ INDEX_ASC(V2 XAK4VSK_VSL_PORT_SKD) */ V2.VPS_PORT_CD" ).append("\n"); 
		query.append("                     FROM VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND V2.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("                      AND V2.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND V2.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND NVL(V2.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                      AND V2.VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                      AND V2.CLPT_SEQ > (SELECT V3.CLPT_SEQ " ).append("\n"); 
		query.append("                                           FROM VSK_VSL_PORT_SKD V3 " ).append("\n"); 
		query.append("                                          WHERE 1=1" ).append("\n"); 
		query.append("                                            AND V3.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("                                            AND V3.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND V3.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            AND V3.VPS_PORT_CD = V.POL_CD" ).append("\n"); 
		query.append("                                            AND V3.CLPT_IND_SEQ = V.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                            AND NVL(V3.SKD_CNG_STS_CD,'X') <> 'S')" ).append("\n"); 
		query.append("                      AND V2.CLPT_SEQ < (SELECT V4.CLPT_SEQ " ).append("\n"); 
		query.append("                                           FROM VSK_VSL_PORT_SKD V4" ).append("\n"); 
		query.append("                                          WHERE 1=1" ).append("\n"); 
		query.append("                                            AND V4.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("                                            AND V4.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND V4.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            AND V4.VPS_PORT_CD = V.POD_CD" ).append("\n"); 
		query.append("                                            AND V4.CLPT_IND_SEQ = V.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                            AND NVL(V4.SKD_CNG_STS_CD,'X') <> 'S')" ).append("\n"); 
		query.append("											AND ROWNUM = 1" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("             ELSE ( SELECT SUBSTR( MAX( NVL( POD_YD_NO, '  ') ||HUB_LOC_CD) , 3)" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_CND_GDS_LOC GL" ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("                       AND GL.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("                       AND GL.DEL_CD = B.DEL_CD" ).append("\n"); 
		query.append("                       AND NVL(GL.POD_YD_NO, 'NL' ) IN ('NL',SUBSTR(B.POD_NOD_CD, 6))" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("         END AS HUB_LOC_CD" ).append("\n"); 
		query.append("      , CASE WHEN SUBSTR(V.POD_CD, 1, 2) = 'CA' THEN V.POD_CD" ).append("\n"); 
		query.append("             ELSE (  SELECT  SUBSTR(MIN(TO_CHAR(V2.VPS_ETA_DT, 'YYYYMMDDHH24MISS')||V2.VPS_PORT_CD), 15)" ).append("\n"); 
		query.append("                     FROM    VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append("                           , VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                     WHERE   V1.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("                     AND     V1.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND     V1.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND     V1.VPS_PORT_CD = V.POL_CD" ).append("\n"); 
		query.append("                     AND     V2.VSL_CD      = V1.VSL_CD" ).append("\n"); 
		query.append("                     AND     V2.SKD_VOY_NO  = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND     V2.SKD_DIR_CD  = V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND     V2.CLPT_SEQ    > V1.CLPT_SEQ" ).append("\n"); 
		query.append("                     AND     NVL(V2.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                     AND     V2.VPS_PORT_CD LIKE 'CA%')" ).append("\n"); 
		query.append("        END AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("      , DECODE(SUBSTR(V.POD_CD, 1, 2), 'CA', 'N', 'Y') AS FROB_FLG" ).append("\n"); 
		query.append("      , 'A' MF_STS_CD" ).append("\n"); 
		query.append("      , '' AS CSTMS_LOC_CD" ).append("\n"); 
		query.append("      , NVL(H.PCK_QTY, 0) AS PCK_QTY" ).append("\n"); 
		query.append("      , H.PCK_TP_CD AS AMS_PCK_TP_CD" ).append("\n"); 
		query.append("      , NVL(H.HBL_WGT, 0) AS CGO_WGT" ).append("\n"); 
		query.append("      , CASE H.WGT_UT_CD WHEN 'KG' THEN 'KGS' " ).append("\n"); 
		query.append("                         WHEN 'LB' THEN 'LBS' " ).append("\n"); 
		query.append("                         WHEN 'K' THEN 'KGS' " ).append("\n"); 
		query.append("                         ELSE D.WGT_UT_CD" ).append("\n"); 
		query.append("        END WGT_UT_CD" ).append("\n"); 
		query.append("      , NVL(H.CMDT_MEAS_QTY, 0) AS MEAS_QTY" ).append("\n"); 
		query.append("      , H.CMDT_MEAS_UT_CD AS MEAS_UT_CD" ).append("\n"); 
		query.append("      , B.RCV_TERM_CD" ).append("\n"); 
		query.append("      , B.DE_TERM_CD" ).append("\n"); 
		query.append("      , D.BDR_FLG" ).append("\n"); 
		query.append("      , TO_CHAR(D.BDR_DT,'YYYYMMDDHH24MISS') AS BDR_DT" ).append("\n"); 
		query.append("	  , '' AS BDR_OFC_CD" ).append("\n"); 
		query.append("      , '' AS BDR_IF_USR_ID" ).append("\n"); 
		query.append("      , '' AS BDR_IF_DT" ).append("\n"); 
		query.append("      , '' AS CA_FLG" ).append("\n"); 
		query.append("      , '' AS CA_ISS_DT" ).append("\n"); 
		query.append("      , '' AS CA_NO" ).append("\n"); 
		query.append("      , HRD.ATTR_CTNT1 AS SCAC_CD" ).append("\n"); 
		query.append("      , '' AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("      , B.BL_NO AS MF_NO" ).append("\n"); 
		query.append("	  , DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') AS FULL_MTY_CD" ).append("\n"); 
		query.append("      , '' AS CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("      , '' AS USR_CMT_CTNT" ).append("\n"); 
		query.append("      , 'Y' AS IF_FLG" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS') AS IF_DT" ).append("\n"); 
		query.append("      , '' AS DIFF_RMK" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("           SELECT  SUBSTR( MAX( NVL( POD_YD_NO, '  ') ||TRSP_MOD_ID) , 3)" ).append("\n"); 
		query.append("           FROM    BKG_CSTMS_CND_GDS_LOC GL" ).append("\n"); 
		query.append("           WHERE   1 = 1" ).append("\n"); 
		query.append("           AND     GL.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("           AND     GL.DEL_CD = B.DEL_CD" ).append("\n"); 
		query.append("           AND     NVL(GL.POD_YD_NO, 'NL' ) IN ('NL',SUBSTR(B.POD_NOD_CD, 6) )" ).append("\n"); 
		query.append("        ) AS TRSP_MOD_ID" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("           SELECT  SUBSTR( MAX( NVL( POD_YD_NO, '  ') ||GDS_DESC) , 3)" ).append("\n"); 
		query.append("           FROM    BKG_CSTMS_CND_GDS_LOC GL" ).append("\n"); 
		query.append("           WHERE   1 = 1" ).append("\n"); 
		query.append("           AND     GL.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("           AND     GL.DEL_CD = B.DEL_CD" ).append("\n"); 
		query.append("           AND     NVL(GL.POD_YD_NO, 'NL' ) IN ('NL',SUBSTR(B.POD_NOD_CD, 6) )" ).append("\n"); 
		query.append("        ) AS IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("      , '' AS CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("      , '' AS PRE_MF_NO" ).append("\n"); 
		query.append("      , '' AS CSTMS_FILE_LOC_CD" ).append("\n"); 
		query.append("      , '' AS FAX_OFC_CD" ).append("\n"); 
		query.append("      , C.CUST_CNT_CD AS FAX_CNT_CD" ).append("\n"); 
		query.append("      , C.CUST_SEQ AS FAX_CUST_SEQ" ).append("\n"); 
		query.append("      , '' AS FAX_NO" ).append("\n"); 
		query.append("      , CASE WHEN H.HBL_MF_TP_CD IS NOT NULL THEN H.HBL_MF_TP_CD" ).append("\n"); 
		query.append("             WHEN SUBSTR(V.POD_CD, 1, 2) = 'CA' AND SUBSTR(B.DEL_CD, 1,2) = 'CA' THEN '24' " ).append("\n"); 
		query.append("             WHEN SUBSTR(V.POD_CD, 1, 2) = 'CA' AND SUBSTR(B.DEL_CD, 1, 2) <> 'CA' THEN '23'" ).append("\n"); 
		query.append("             ELSE '26' " ).append("\n"); 
		query.append("         END AS TRSP_TP_ID" ).append("\n"); 
		query.append("      , '' AS IN_TZ_YD_CD" ).append("\n"); 
		query.append("      , '' AS IN_TZ_YD_NM" ).append("\n"); 
		query.append("      , '' AS IN_TZ_YD_ADDR" ).append("\n"); 
		query.append("      , '' AS IN_TZ_YD_CTY_NM" ).append("\n"); 
		query.append("      , '' AS IN_TZ_YD_STE_CD" ).append("\n"); 
		query.append("      , '' AS IN_TZ_YD_CNT_CD" ).append("\n"); 
		query.append("      , '' AS IN_TZ_YD_ZIP_ID" ).append("\n"); 
		query.append("      , B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("      , B.POD_NOD_CD" ).append("\n"); 
		query.append("      , B.DEL_NOD_CD" ).append("\n"); 
		query.append("FROM    BKG_BOOKING B" ).append("\n"); 
		query.append("      , BKG_VVD V" ).append("\n"); 
		query.append("      , BKG_BL_DOC D" ).append("\n"); 
		query.append("      , BKG_HBL H" ).append("\n"); 
		query.append("      , BKG_HBL_CUST C" ).append("\n"); 
		query.append("      , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("      , MDM_PCK_TP PCK" ).append("\n"); 
		query.append("      , BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("WHERE   B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND     B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND     B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("AND     H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND     V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     H.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND     H.HBL_SEQ = C.HBL_SEQ(+)" ).append("\n"); 
		query.append("AND     C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND     V.VSL_CD = VPS.VSL_CD(+)" ).append("\n"); 
		query.append("AND     V.SKD_VOY_NO = VPS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     V.SKD_DIR_CD = VPS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     V.POD_CD = VPS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND     VPS.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("AND     D.PCK_TP_CD = PCK.PCK_CD(+)" ).append("\n"); 
		query.append("AND     HRD.HRD_CDG_ID(+) = 'DFLT_SCAC'" ).append("\n"); 

	}
}