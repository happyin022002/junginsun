/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOsearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlGeneral
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchBlGeneralRSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchBlGeneralRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(MSG_ID,'915','FROBDAT','FROBAMD') AS MSG_ID_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",Z.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" BL_NO||'.'||LPAD(PRN_SEQ,3,'0')||'.'||DECODE(MRN,NULL,'915','913') AS PRN" ).append("\n"); 
		query.append(",DECODE(MRN,NULL,'915','913') AS MSG_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,1) AS CT_NAME" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,2) AS CT_POSITION" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,3) AS CT_EMAIL" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,4) AS CT_TEL" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,5) AS CT_FAX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",Y.*" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    (SELECT COUNT(*)+1 FROM BKG_CSTMS_EUR_IB_SND" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("	   AND CNT_CD = 'IL'" ).append("\n"); 
		query.append("       AND EDI_MSG_TP_ID ='ILC'" ).append("\n"); 
		query.append("	   AND BL_NO = BK.BL_NO" ).append("\n"); 
		query.append("    ) AS PRN_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , (SELECT MVMT_REF_NO FROM BKG_CSTMS_EUR_IB_RCV" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("	   AND CNT_CD = 'IL'" ).append("\n"); 
		query.append("       AND MSG_RCV_NO = (SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                             FROM BKG_CSTMS_EUR_IB_SND" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                              AND CNT_CD = 'IL'" ).append("\n"); 
		query.append("                              AND BL_NO          = BK.BL_NO" ).append("\n"); 
		query.append("                              AND CSTMS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("                              AND (VSL_CD != BV.VSL_CD " ).append("\n"); 
		query.append("                               OR SKD_VOY_NO != BV.SKD_VOY_NO " ).append("\n"); 
		query.append("                               OR SKD_DIR_CD != BV.SKD_DIR_CD) )" ).append("\n"); 
		query.append("     ) AS MRN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , VSL.LLOYD_NO AS TRANS_IDENTITY" ).append("\n"); 
		query.append("   , VSL.VSL_RGST_CNT_CD  AS TRANS_NATION" ).append("\n"); 
		query.append("   , VSL.VSL_ENG_NM AS VSL_NAME" ).append("\n"); 
		query.append("   , BD.POL_CD AS LOAD_LOC_CD" ).append("\n"); 
		query.append("   , BD.POL_NM AS LOAD_LOC_NAME" ).append("\n"); 
		query.append("   , '' AS LOAD_OFC_CD" ).append("\n"); 
		query.append("   , TO_CHAR(SKD1.VPS_ETD_DT,'yyyymmddhh24miss') AS LOAD_LOC_ETD" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("   , BK.POD_CD AS UNLOAD_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , (SELECT LOC_NM " ).append("\n"); 
		query.append("        FROM MDM_LOCATION " ).append("\n"); 
		query.append("       WHERE LOC_CD = BK.POD_CD" ).append("\n"); 
		query.append("      ) AS UNLOAD_LOC_NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , TO_CHAR(SKD2.INIT_ETA_DT,'yyyymmddhh24miss') AS UNLOAD_LOC_ETA    " ).append("\n"); 
		query.append("    , TO_CHAR(SKD2.INIT_ETA_DT,'yyyymmddhh24miss') AS UNLOAD_LOC_ETA_HIS    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--   , (SELECT A.EUR_CSTMS_OFC_ID FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("--       WHERE A.PORT_CD = X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("--         AND A.TML_CD IN ('ALL',X.CSTMS_YD_CD)" ).append("\n"); 
		query.append("--          AND ROWNUM=1 " ).append("\n"); 
		query.append("--      ) AS UNLOAD_OFC_CD /* 21 */ " ).append("\n"); 
		query.append("   , '' AS UNLOAD_OFC_CD" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   , (SELECT /*+ INDEX_DESC(K XAK4VSK_VSL_PORT_SKD) */ VPS_PORT_CD" ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("      WHERE K.VSL_CD = SKD3.VSL_CD" ).append("\n"); 
		query.append("        AND K.SKD_VOY_NO = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND K.SKD_DIR_CD = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND K.CLPT_SEQ < SKD3.CLPT_SEQ" ).append("\n"); 
		query.append("        AND NVL(K.PORT_SKD_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("        AND K.CLPT_SEQ >= SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("        AND K.CLPT_SEQ <= SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("        AND ROWNUM = 1 " ).append("\n"); 
		query.append("      ) AS PREV_LOC_CD      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ VPS_PORT_CD" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("       WHERE K.VSL_CD = SKD3.VSL_CD" ).append("\n"); 
		query.append("         AND K.SKD_VOY_NO = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND K.SKD_DIR_CD = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND K.CLPT_SEQ = SKD3.CLPT_SEQ" ).append("\n"); 
		query.append("         AND NVL(K.PORT_SKD_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("         AND K.CLPT_SEQ >= SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("         AND K.CLPT_SEQ <= SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("         AND ROWNUM = 1 " ).append("\n"); 
		query.append("     ) AS NEXT_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ TO_CHAR(INIT_ETA_DT,'yyyymmddhh24')||'0000'" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("        WHERE K.VSL_CD = SKD3.VSL_CD" ).append("\n"); 
		query.append("          AND K.SKD_VOY_NO = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND K.SKD_DIR_CD = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ = SKD3.CLPT_SEQ" ).append("\n"); 
		query.append("          AND NVL(K.PORT_SKD_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ >= SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ <= SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND ROWNUM = 1 " ).append("\n"); 
		query.append("      ) AS NEXT_LOC_ETA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ B.LOC_NM" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K,MDM_LOCATION B" ).append("\n"); 
		query.append("       WHERE K.VSL_CD = SKD3.VSL_CD" ).append("\n"); 
		query.append("         AND K.SKD_VOY_NO = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND K.SKD_DIR_CD = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND K.CLPT_SEQ = SKD3.CLPT_SEQ" ).append("\n"); 
		query.append("         AND K.VPS_PORT_CD= B.LOC_CD" ).append("\n"); 
		query.append("         AND NVL(K.PORT_SKD_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("         AND K.CLPT_SEQ >= SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("         AND K.CLPT_SEQ <= SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("         AND ROWNUM = 1 " ).append("\n"); 
		query.append("     ) AS NEXT_LOC_NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ B.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD K,BKG_CSTMS_EUR_CD_STUP B" ).append("\n"); 
		query.append("      WHERE K.VSL_CD = SKD3.VSL_CD" ).append("\n"); 
		query.append("        AND K.SKD_VOY_NO = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND K.SKD_DIR_CD = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND K.CLPT_SEQ = SKD3.CLPT_SEQ" ).append("\n"); 
		query.append("        AND B.PORT_CD = K.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND B.TML_CD IN ('ALL',K.YD_CD)" ).append("\n"); 
		query.append("        AND NVL(K.PORT_SKD_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("        AND K.CLPT_SEQ >= SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("        AND K.CLPT_SEQ <= SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("        AND ROWNUM = 1 " ).append("\n"); 
		query.append("    ) AS NEXT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , BK.BL_NO AS BLNBR" ).append("\n"); 
		query.append("   , VSL.LLOYD_NO AS BL_TRANS_IDENTITY" ).append("\n"); 
		query.append("   , VSL.VSL_RGST_CNT_CD AS BL_TRANS_NATION" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   , BD.POL_CD      AS  BLPOL" ).append("\n"); 
		query.append("   , BD.POL_NM      AS  POL_FULLNAME" ).append("\n"); 
		query.append("   , BD.POD_CD      AS  BLPOD" ).append("\n"); 
		query.append("   , BD.POD_NM      AS  POD_FULLNAME" ).append("\n"); 
		query.append("--   , (SELECT A.EUR_CSTMS_OFC_ID FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("--       WHERE A.PORT_CD = X.POD_CD  AND A.TML_CD IN ('ALL',X.POD_YD_CD)" ).append("\n"); 
		query.append("--        AND ROWNUM=1) AS POD_OFC_CD" ).append("\n"); 
		query.append("   , '' AS POD_OFC_CD" ).append("\n"); 
		query.append("   , BD.DEL_CD      AS  BLDEL" ).append("\n"); 
		query.append("   , BD.DEL_NM      AS  DEL_FULLNAME" ).append("\n"); 
		query.append("   , BD.PCK_QTY     AS  BLPKG" ).append("\n"); 
		query.append("   , BD.PCK_TP_CD  AS  BLPKGU" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , BD.MEAS_QTY    AS  BLMEA" ).append("\n"); 
		query.append("   , BD.MEAS_UT_CD  AS  BLMEAU" ).append("\n"); 
		query.append("   , BK.CMDT_CD     AS  COMMODITY" ).append("\n"); 
		query.append("   , '' AS TRANS_DOC_NO" ).append("\n"); 
		query.append("   , '' AS TRANS_DOC_NAME" ).append("\n"); 
		query.append("   , '' AS CUSTOMS_STATUS_CD" ).append("\n"); 
		query.append("   , '' AS PROCESS_INFO" ).append("\n"); 
		query.append("   , 'NULL' AS PROCESS_TYPE" ).append("\n"); 
		query.append("   , '' AS AEO_STATUS" ).append("\n"); 
		query.append("   , 'N' AS PART_SHIPMENT" ).append("\n"); 
		query.append("   , '' AS CONSIGN_PLACE" ).append("\n"); 
		query.append("   , TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(BK.POD_CD),'YYYYMMDDHH24MISS') AS DECLARE_DATE" ).append("\n"); 
		query.append("   , BK.POD_CD AS DECLARE_LOC" ).append("\n"); 
		query.append("   , (SELECT LOC_NM FROM MDM_LOCATION " ).append("\n"); 
		query.append("       WHERE LOC_CD = BK.POD_CD" ).append("\n"); 
		query.append("      ) AS DECLARE_LOC_NAME" ).append("\n"); 
		query.append("   , DECODE((SELECT FRT_TERM_CD FROM BKG_RATE WHERE 1=1 AND BKG_NO = @[bl_no]), 'P', 'H', 'Z') AS PAYMENT_CD" ).append("\n"); 
		query.append("   , DECODE( BK.CUST_TO_ORD_FLG , 'Y','10600','') AS SPECIAL_REMARKS" ).append("\n"); 
		query.append("   , BKG_SPCLCHAR_CONV_CLOB_FNC(BD.CSTMS_DESC,'X') AS DESCS" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(" , BKG_JOIN_FULL_CLOB_FNC(CURSOR(SELECT BKG_SPCLCHAR_CONV_CLOB_FNC(MK_DESC,'X') FROM BKG_BOOKING A, BKG_BL_MK_DESC B" ).append("\n"); 
		query.append("                             WHERE A.BL_NO = BD.BKG_NO" ).append("\n"); 
		query.append("                               AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    ),'$@$') AS MARKNO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- , (SELECT  CNTC_NM||','||CNTC_PSN_NM||','||CNTC_EML||','||CNTC_PHN_NO||','||CNTC_FAX_NO" ).append("\n"); 
		query.append("--	 FROM BKG_CSTMS_EUR_CD_STUP" ).append("\n"); 
		query.append("--    WHERE PORT_CD = BV.POD_YD_CD" ).append("\n"); 
		query.append("--	  AND TML_CD  IN ('ALL',BV.POD_YD_CD )" ).append("\n"); 
		query.append("--      AND ROWNUM =1 " ).append("\n"); 
		query.append("--     ) AS CTMS_SETUP" ).append("\n"); 
		query.append("   , '' AS CTMS_SETUP " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" , BV.VSL_CD,    BV.SKD_VOY_NO,  BV.SKD_DIR_CD,  BK.BL_NO,      BV.POD_YD_CD" ).append("\n"); 
		query.append(" , BK.POL_CD AS BKG_POL_CD,   BK.POD_CD AS BKG_POD_CD,    BD.POL_CD,      BD.POD_CD,     BD.DEL_CD" ).append("\n"); 
		query.append(" , BD.POL_NM,    BD.POD_NM,        BD.DEL_NM,        BD.PCK_QTY,      BD.PCK_TP_CD" ).append("\n"); 
		query.append(" , BD.MEAS_QTY,  BD.MEAS_UT_CD,    BK.CMDT_CD,     '' AS TRSP_DOC_NO,  '' AS CSTMS_DECL_DT,  '' AS DECL_LOC_CD" ).append("\n"); 
		query.append(" , BD.CRE_USR_ID, BD.CRE_DT, BD.UPD_USR_ID,  BD.UPD_DT   " ).append("\n"); 
		query.append("FROM BKG_BL_DOC BD " ).append("\n"); 
		query.append("   , BKG_BOOKING BK" ).append("\n"); 
		query.append("   , BKG_VVD BV" ).append("\n"); 
		query.append("   , MDM_VSL_CNTR VSL " ).append("\n"); 
		query.append("   , VSK_VSL_PORT_SKD SKD1 , VSK_VSL_PORT_SKD SKD2 " ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("          WHERE K.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("            AND K.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND K.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("            AND NVL(K.PORT_SKD_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("            AND K.VPS_PORT_CD LIKE 'IL%'" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("            ORDER BY CLPT_SEQ   " ).append("\n"); 
		query.append("   ) SKD3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD NOT IN ('P')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BV.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("AND BV.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BV.POL_CD = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("AND SKD1.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BV.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BV.POD_CD = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND SKD2.CLPT_IND_SEQ = BV.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BV.POL_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ts_tp_cd} == 'L') " ).append("\n"); 
		query.append("AND BK.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("#elseif (${ts_tp_cd} == 'T') " ).append("\n"); 
		query.append("AND BK.POL_CD != BV.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append(")Z" ).append("\n"); 

	}
}