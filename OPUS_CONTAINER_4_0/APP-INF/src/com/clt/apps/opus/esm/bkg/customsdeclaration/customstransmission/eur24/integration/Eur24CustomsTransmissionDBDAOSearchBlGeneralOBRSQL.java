/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlGeneralOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2015.09.01 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlGeneralOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchBlGeneralOBRSQL
	  * * History
	  * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlGeneralOBRSQL(){
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlGeneralOBRSQL").append("\n"); 
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
		query.append("/*  Eur24BlinfoVO Eur24CustomsTransmissionDBDAOSearchBlGeneralOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd) */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" DECODE(MSG_ID,'615','EXSDAT','EXSAMD') AS MSG_ID_CD     " ).append("\n"); 
		query.append(",Z.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" BL_NO||'.'||LPAD(PRN_SEQ,3,'0')||'.'||DECODE(MRN,NULL,'615','613') AS PRN /* 4 */" ).append("\n"); 
		query.append(",DECODE(MRN,NULL,'615','613') AS MSG_ID" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,1) AS CT_NAME" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,2) AS CT_POSITION" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,3) AS CT_EMAIL" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,4) AS CT_TEL" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,5) AS CT_FAX" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,6) AS CUSTOMS_LODGE_OFC" ).append("\n"); 
		query.append(",'XSUM' AS PREVIOUS_DOC_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(PREVIOUS_DOC_INFO,1) AS PREVIOUS_DOC_REF" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(PREVIOUS_DOC_INFO,2) AS PRE_VSL_DCHG_YD_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",Y.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    (SELECT COUNT(*)+1 FROM BKG_CSTMS_EUR_IO_SND" ).append("\n"); 
		query.append("     WHERE EUR_EDI_MSG_TP_ID ='EXS'" ).append("\n"); 
		query.append("     AND BL_NO = X.BL_NO" ).append("\n"); 
		query.append("    ) AS PRN_SEQ" ).append("\n"); 
		query.append("   , X.MVMT_REF_NO AS MRN /* 7 */" ).append("\n"); 
		query.append("   , VSL.LLOYD_NO AS TRANS_IDENTITY /* 11 */   " ).append("\n"); 
		query.append("   , VSL.VSL_RGST_CNT_CD  AS TRANS_NATION /* 12 */       " ).append("\n"); 
		query.append("   , VSL.VSL_ENG_NM AS VSL_NAME /* 13 */  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("   , X.CSTMS_PORT_CD AS LOAD_LOC_CD /* 14 */" ).append("\n"); 
		query.append("   , (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = X.CSTMS_PORT_CD) AS LOAD_LOC_NAME /* 15 */" ).append("\n"); 
		query.append("   , (SELECT DECODE(PORT_CD,'MTMAR','MT000113',A.EUR_CSTMS_OFC_ID) FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("       WHERE A.PORT_CD = X.CSTMS_PORT_CD  AND A.TML_CD IN ('ALL',X.CSTMS_YD_CD)" ).append("\n"); 
		query.append("        AND ROWNUM=1 " ).append("\n"); 
		query.append("      ) AS LOAD_OFC_CD /* 16 */ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , TO_CHAR(SKD1.VPS_ETD_DT,'yyyymmddhh24miss') AS LOAD_LOC_ETD /* 17 */   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , X.POD_CD AS UNLOAD_LOC_CD /* 18 */" ).append("\n"); 
		query.append("   , X.POD_NM AS UNLOAD_LOC_NAME /* 19 */" ).append("\n"); 
		query.append("   , CASE WHEN VSL.CRR_CD = 'UAC' OR VSL.CRR_CD = 'HPL' THEN TO_CHAR(SKD2.INIT_ETA_DT,'yyyymmdd')||'120000'" ).append("\n"); 
		query.append("          ELSE TO_CHAR(SKD2.INIT_ETA_DT,'yyyymmddhh24')||'0000'" ).append("\n"); 
		query.append("     END AS UNLOAD_LOC_ETA /* 20 */     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , '' AS UNLOAD_OFC_CD /* 21 */" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   , (SELECT /*+ INDEX_DESC(K XAK4VSK_VSL_PORT_SKD) */ VPS_PORT_CD" ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("      WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("        AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND K.CLPT_SEQ < SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("        AND ROWNUM = 1 " ).append("\n"); 
		query.append("      ) AS PREV_LOC_CD /* 22 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ VPS_PORT_CD" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("        WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("          AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ > SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND ROWNUM = 1 " ).append("\n"); 
		query.append("      ) AS NEXT_LOC_CD /* 23 */" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ B.LOC_NM" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K,MDM_LOCATION B" ).append("\n"); 
		query.append("        WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("          AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ > SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND K.VPS_PORT_CD= B.LOC_CD" ).append("\n"); 
		query.append("          AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ) AS NEXT_LOC_NAME /* 24 */" ).append("\n"); 
		query.append("    , (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ B.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K,BKG_CSTMS_EUR_CD_STUP B" ).append("\n"); 
		query.append("        WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("          AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ > SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND B.PORT_CD = K.VPS_PORT_CD" ).append("\n"); 
		query.append("		  AND B.TML_CD IN ('ALL',K.YD_CD)" ).append("\n"); 
		query.append("          AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ) AS NEXT_OFC_CD  /*  25 */" ).append("\n"); 
		query.append("	   ,(SELECT STUP.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("FROM (SELECT *" ).append("\n"); 
		query.append("      FROM(" ).append("\n"); 
		query.append("            SELECT A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , SLAN_CD" ).append("\n"); 
		query.append("            , A.VPS_PORT_CD AS EU_LAST_PORT" ).append("\n"); 
		query.append("            , A.VPS_PORT_CD" ).append("\n"); 
		query.append("            , A.EU_LAST_PORT_YD_CD" ).append("\n"); 
		query.append("            , A.CLPT_SEQ" ).append("\n"); 
		query.append("            , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("               , CASE WHEN LAG( EU ) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ DESC ) IS NULL" ).append("\n"); 
		query.append("                             AND EU IS NOT NULL" ).append("\n"); 
		query.append("                             AND CLPT_SEQ >1 " ).append("\n"); 
		query.append("                            THEN 'EULAST'" ).append("\n"); 
		query.append("                        END EU_FLAG" ).append("\n"); 
		query.append("            FROM(" ).append("\n"); 
		query.append("                 SELECT A.VSL_CD " ).append("\n"); 
		query.append("                    , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                    , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    , SLAN_CD " ).append("\n"); 
		query.append("                    , A.VPS_PORT_CD " ).append("\n"); 
		query.append("                    , A.YD_CD          AS EU_LAST_PORT_YD_CD " ).append("\n"); 
		query.append("                    , ROW_NUMBER() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) AS CLPT_SEQ" ).append("\n"); 
		query.append("                    , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    , B.ATTR_CTNT1 EU" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                    , BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                    AND B.CSTMS_DIV_ID(+)='EU_MEMBER_CNT'" ).append("\n"); 
		query.append("                    AND B.CNT_CD(+) = 'EU'" ).append("\n"); 
		query.append("                    AND SUBSTR(A.VPS_PORT_CD, 1, 2) = B.ATTR_CTNT1(+) " ).append("\n"); 
		query.append("                    AND B.ATTR_CTNT1 IS NOT NULL" ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("                 )SKD" ).append("\n"); 
		query.append("				WHERE  SKD.EU_FLAG IS NOT NULL" ).append("\n"); 
		query.append("        )SKD , BKG_CSTMS_EUR_CD_STUP STUP" ).append("\n"); 
		query.append("        WHERE SKD.EU_LAST_PORT_YD_CD LIKE DECODE(STUP.TML_CD,'ALL','%',STUP.TML_CD)" ).append("\n"); 
		query.append("        AND SUBSTR(STUP.EUR_CSTMS_OFC_ID,1,2) = SUBSTR(SKD.EU_LAST_PORT_YD_CD,1,2)) AS EU_LST_OFC_CD" ).append("\n"); 
		query.append("  , X.BL_NO AS BLNBR /* 46 */" ).append("\n"); 
		query.append("   , VSL.LLOYD_NO AS BL_TRANS_IDENTITY /* 47 */   " ).append("\n"); 
		query.append("   , VSL.VSL_RGST_CNT_CD AS BL_TRANS_NATION/* 48 */      " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   , X.POL_CD      AS  BLPOL         /* 49 */ " ).append("\n"); 
		query.append("   , POL_NM      AS  POL_FULLNAME  /* 50 */ " ).append("\n"); 
		query.append("   , X.POD_CD      AS  BLPOD         /* 51 */ " ).append("\n"); 
		query.append("   , POD_NM      AS  POD_FULLNAME  /* 52 */ " ).append("\n"); 
		query.append("   , (SELECT A.EUR_CSTMS_OFC_ID FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("       WHERE A.PORT_CD = X.POD_CD  AND A.TML_CD IN ('ALL',X.CSTMS_YD_CD)" ).append("\n"); 
		query.append("        AND ROWNUM=1) AS POD_OFC_CD" ).append("\n"); 
		query.append("   , X.DEL_CD      AS  BLDEL         /* 53 */ " ).append("\n"); 
		query.append("   , DEL_NM      AS  DEL_FULLNAME  /* 54 */ " ).append("\n"); 
		query.append("   , PCK_QTY     AS  BLPKG         /* 55 */ " ).append("\n"); 
		query.append("  , NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("	   FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append("	  WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("        AND RCVR_ID = 'ENS'" ).append("\n"); 
		query.append("        AND PCK_TP_CD = X.PCK_TP_CD),X.PCK_TP_CD)  AS  BLPKGU  /* 56 */ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , MEAS_QTY    AS  BLMEA         /* 57 */ " ).append("\n"); 
		query.append("   , MEAS_UT_CD  AS  BLMEAU        /* 58 */ " ).append("\n"); 
		query.append("   , X.CMDT_CD     AS  COMMODITY     /* 59 */ " ).append("\n"); 
		query.append("   , TRSP_DOC_NO AS  TRANS_DOC_NO  /* 60 */" ).append("\n"); 
		query.append("   , '' AS TRANS_DOC_NAME /* 61 */" ).append("\n"); 
		query.append("   , '' AS CUSTOMS_STATUS_CD /* 62 */" ).append("\n"); 
		query.append("   , '' AS PROCESS_INFO /* 63 */" ).append("\n"); 
		query.append("   , '' AS PROCESS_TYPE /* 64 */" ).append("\n"); 
		query.append("   , '' AS AEO_STATUS /* 65 */" ).append("\n"); 
		query.append("   , '' AS PART_SHIPMENT /* 66 */" ).append("\n"); 
		query.append("   , '' AS CONSIGN_PLACE /* 67 */" ).append("\n"); 
		query.append("   , TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(CSTMS_PORT_CD),'YYYYMMDDHH24MISS') AS DECLARE_DATE /* 68 */" ).append("\n"); 
		query.append("   , CSTMS_PORT_CD AS DECLARE_LOC /* 69 */" ).append("\n"); 
		query.append("   , (SELECT LOC_NM FROM MDM_LOCATION " ).append("\n"); 
		query.append("       WHERE LOC_CD = X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      ) AS DECLARE_LOC_NAME /* 70 */" ).append("\n"); 
		query.append("   , '' AS PAYMENT_CD /* 71 */" ).append("\n"); 
		query.append("   , DECODE( BKG.CUST_TO_ORD_FLG , 'Y','10600','') AS SPECIAL_REMARKS /* 74 */" ).append("\n"); 
		query.append("   , BKG_SPCLCHAR_CONV_CLOB_FNC(CSTMS_DESC,'X') AS DESCS /* 93 */" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(" , BKG_JOIN_FULL_CLOB_FNC(CURSOR(SELECT BKG_SPCLCHAR_CONV_CLOB_FNC(MK_DESC,'X') FROM BKG_BOOKING A, BKG_BL_MK_DESC B" ).append("\n"); 
		query.append("                             WHERE A.BL_NO = X.BL_NO" ).append("\n"); 
		query.append("                               AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    ),'$@$') AS MARKNO /* 96 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" , (SELECT  DECODE(PORT_CD,'MTMAR',CNTC_NM||','||CNTC_PSN_NM||','||CNTC_EML||','||CNTC_PHN_NO||','||CNTC_FAX_NO||','||'MT000113'" ).append("\n"); 
		query.append("			,CNTC_NM||','||CNTC_PSN_NM||','||CNTC_EML||','||CNTC_PHN_NO||','||CNTC_FAX_NO||','||EUR_CSTMS_OFC_ID)" ).append("\n"); 
		query.append("	 FROM BKG_CSTMS_EUR_CD_STUP" ).append("\n"); 
		query.append("    WHERE PORT_CD = X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("	  AND TML_CD  IN ('ALL',X.CSTMS_YD_CD )" ).append("\n"); 
		query.append("      AND ROWNUM =1 " ).append("\n"); 
		query.append("     ) AS CTMS_SETUP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" , X.VSL_CD,     X.SKD_VOY_NO,  X.SKD_DIR_CD,  X.BL_NO,      CSTMS_PORT_CD" ).append("\n"); 
		query.append(" , BKG_POL_CD,   BKG_POD_CD,    X.POL_CD,      X.POD_CD,     X.DEL_CD" ).append("\n"); 
		query.append(" , POL_NM,       POD_NM,        DEL_NM,        PCK_QTY,      PCK_TP_CD" ).append("\n"); 
		query.append(" , MEAS_QTY,     MEAS_UT_CD,    X.CMDT_CD,     TRSP_DOC_NO,  CSTMS_DECL_DT,  DECL_LOC_CD" ).append("\n"); 
		query.append(" , X.CRE_USR_ID, X.CRE_DT,      X.UPD_USR_ID,  X.UPD_DT   " ).append("\n"); 
		query.append(" , X.ACT_WGT,    X.WGT_UT_CD /* EXS ONLY */" ).append("\n"); 
		query.append(" , X.CSTMS_YD_CD  AS LOAD_TMNL_LOC_CD  /* EXS ONLY */" ).append("\n"); 
		query.append(", (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = X.CSTMS_YD_CD ) AS LOAD_TMNL_NAME  /* EXS ONLY */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",(SELECT  " ).append("\n"); 
		query.append("    NVL(DECODE(CNT_CD, 'ES', MF_NO || REF_GDS_ITM_NM, REF_GDS_ITM_NM),'') ||','||PRE_VSL_DCHG_YD_NM FROM BKG_CSTMS_EUR_CRN_RCV" ).append("\n"); 
		query.append("	WHERE BL_NO =X.BL_NO AND MSG_FUNC_ID = 'F' AND ROWNUM = 1) AS PREVIOUS_DOC_INFO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_IO_BL X, MDM_VSL_CNTR VSL , VSK_VSL_PORT_SKD SKD1,VSK_VSL_PORT_SKD SKD2 , BKG_BOOKING BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE X.VSL_CD =  VSL.VSL_CD" ).append("\n"); 
		query.append("AND X.VSL_cD = SKD1.VSL_cD" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO =SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD =SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND X.POL_CD= SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("AND SKD1.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND X.VSL_cD = SKD2.VSL_cD" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO =SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD =SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND X.CSTMS_PORT_CD= SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND SKD2.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND X.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("AND X.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("AND X.VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND X.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND X.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append(")Z" ).append("\n"); 

	}
}