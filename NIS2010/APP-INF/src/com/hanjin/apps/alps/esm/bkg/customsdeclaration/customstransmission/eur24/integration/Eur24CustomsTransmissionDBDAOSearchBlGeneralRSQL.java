/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchBlGeneralRSQL
	  * * History
	  * 2012.07.16 김보배 [CHM-201218619] [BKG] ENS, D/R, A/N 전송시 ENS ETA 고정값 적용 요청
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlGeneralRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eu_1st_port_clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlGeneralRSQL").append("\n"); 
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
		query.append("/*  Eur24BlinfoVO Eur24CustomsTransmissionDBDAOSearchBlGeneral ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String pType) */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_type} != 'FI') " ).append("\n"); 
		query.append(" DECODE(MSG_ID,'315','ENSDAT','ENSAMD') AS MSG_ID_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" 'SANENT' AS MSG_ID_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",(SELECT CASE WHEN TO_DATE(Z.UNLOAD_LOC_ETA, 'YYYYMMDDHH24MISS') < GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE-30,@[cstms_port_cd])" ).append("\n"); 
		query.append("              THEN 'Y'" ).append("\n"); 
		query.append("              ELSE 'N'" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("    FROM DUAL " ).append("\n"); 
		query.append(") AS TRSM_VAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",TO_CHAR( (SELECT SND_DT" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("               WHERE MSG_SND_NO = ( SELECT MAX(MSG_SND_NO) " ).append("\n"); 
		query.append("                                      FROM BKG_CSTMS_ADV_EUR_SND " ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND MSG_SND_NO LIKE @[bl_no]||'%344'" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("          ) ,'yyyymmddhh24miss') AS ORIGINAL_DATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",( SELECT MSG_ACPT_REF_NO" ).append("\n"); 
		query.append("     FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n"); 
		query.append("    WHERE MSG_RCV_NO = ( SELECT MAX(MSG_RCV_NO)" ).append("\n"); 
		query.append("                           FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n"); 
		query.append("                          WHERE MSG_RCV_NO LIKE @[bl_no]||'%344'" ).append("\n"); 
		query.append("                            AND MSG_ACPT_REF_NO IS NOT NULL" ).append("\n"); 
		query.append("							AND EUR_EDI_MSG_TP_ID = 'A'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("	  AND EUR_EDI_MSG_TP_ID = 'A'" ).append("\n"); 
		query.append(" ) AS CUSTOMS_REF" ).append("\n"); 
		query.append(",Z.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${p_type} != 'FI')" ).append("\n"); 
		query.append(" BL_NO||'.'||LPAD(PRN_SEQ,3,'0')||'.'||DECODE(MRN,NULL,'315','313') AS PRN /* 4 */" ).append("\n"); 
		query.append(",DECODE(MRN,NULL,'315','313') AS MSG_ID" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" BL_NO||'.'||LPAD(PRN_SEQ,3,'0')||'.'||'344' AS PRN /* 4 */" ).append("\n"); 
		query.append(",'344' AS MSG_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,1) AS CT_NAME" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,2) AS CT_POSITION" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,3) AS CT_EMAIL" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,4) AS CT_TEL" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(CTMS_SETUP,5) AS CT_FAX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",Y.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    (SELECT COUNT(*)+1 FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("	#if (${p_type} != 'FI')" ).append("\n"); 
		query.append("	   AND EUR_EDI_MSG_TP_ID ='ENS'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   AND EUR_EDI_MSG_TP_ID ='344'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       AND BL_NO = X.BL_NO" ).append("\n"); 
		query.append("    ) AS PRN_SEQ" ).append("\n"); 
		query.append("   , X.MVMT_REF_NO AS MRN /* 7 */" ).append("\n"); 
		query.append("   , VSL.LLOYD_NO AS TRANS_IDENTITY /* 11 */   " ).append("\n"); 
		query.append("   , VSL.VSL_RGST_CNT_CD  AS TRANS_NATION /* 12 */       " ).append("\n"); 
		query.append("   , VSL.VSL_ENG_NM AS VSL_NAME /* 13 */      " ).append("\n"); 
		query.append("   , X.POL_CD AS LOAD_LOC_CD /* 14 */" ).append("\n"); 
		query.append("   , POL_NM AS LOAD_LOC_NAME /* 15 */" ).append("\n"); 
		query.append("   , '' AS LOAD_OFC_CD /* 16 */  " ).append("\n"); 
		query.append("   , TO_CHAR(SKD1.VPS_ETD_DT,'yyyymmddhh24miss') AS LOAD_LOC_ETD /* 17 */   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   /* 2011.06.27 그리스 부도 사태로 한시적으로 수정함*/" ).append("\n"); 
		query.append("   , CASE" ).append("\n"); 
		query.append("        WHEN (SUBSTR(X.MVMT_REF_NO, 1, 4) = '11IT'  AND SUBSTR(@[cstms_port_cd],1,2) = 'GR') THEN 'ITGIT'" ).append("\n"); 
		query.append("        ELSE X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("     END AS UNLOAD_LOC_CD /* 18 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   /* 2011.06.27 그리스 부도 사태로 한시적으로 수정함*/" ).append("\n"); 
		query.append("   , (SELECT LOC_NM " ).append("\n"); 
		query.append("        FROM MDM_LOCATION " ).append("\n"); 
		query.append("       WHERE LOC_CD = CASE" ).append("\n"); 
		query.append("                            WHEN (SUBSTR(X.MVMT_REF_NO, 1, 4) = '11IT' AND SUBSTR(@[cstms_port_cd],1,2) = 'GR') THEN 'ITGIT'" ).append("\n"); 
		query.append("                            ELSE X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("      ) AS UNLOAD_LOC_NAME /* 19 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,CASE WHEN XXX.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("          THEN  " ).append("\n"); 
		query.append("		       CASE WHEN VSL.CRR_CD = 'UAC' OR VSL.CRR_CD = 'HPL' OR VSL.CRR_CD = 'MSK' OR VSL.CRR_CD = 'EGL'  " ).append("\n"); 
		query.append("                    THEN TO_CHAR(XXX.CSTMS_ESTM_ARR_DT,'yyyymmdd')||'120000'" ).append("\n"); 
		query.append("        	        ELSE TO_CHAR(XXX.CSTMS_ESTM_ARR_DT,'yyyymmddhh24')||'0000'" ).append("\n"); 
		query.append("               END " ).append("\n"); 
		query.append("	      ELSE" ).append("\n"); 
		query.append("               CASE WHEN SKD2.SLAN_CD = 'TLS'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '6'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '050000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'IW') + 4, 'YYYYMMDD') || '050000'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                    WHEN SKD2.SLAN_CD = 'RFS' AND SKD2.SKD_DIR_CD = 'N'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '5'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '040000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'D') + 4, 'YYYYMMDD') || '040000' -- 일요일 기준" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                    WHEN SKD2.SLAN_CD = 'RFS' AND SKD2.SKD_DIR_CD = 'S'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '1'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '040000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'D'), 'YYYYMMDD') || '040000'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    WHEN SKD2.SLAN_CD = 'WA2'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '6'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '120000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'IW') + 4, 'YYYYMMDD') || '120000'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    WHEN SKD2.SLAN_CD = 'WAF'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '3'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '120000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'IW') + 1, 'YYYYMMDD') || '120000'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                         CASE WHEN VSL.CRR_CD = 'UAC' OR VSL.CRR_CD = 'HPL' OR VSL.CRR_CD = 'MSK' OR VSL.CRR_CD = 'EGL' THEN TO_CHAR(SKD2.INIT_ETA_DT,'yyyymmdd')||'120000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(SKD2.INIT_ETA_DT,'yyyymmddhh24')||'0000'" ).append("\n"); 
		query.append("                         END " ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("     END AS UNLOAD_LOC_ETA    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    ,CASE WHEN XXX.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("          THEN  " ).append("\n"); 
		query.append("		       CASE WHEN VSL.CRR_CD = 'UAC' OR VSL.CRR_CD = 'HPL' OR VSL.CRR_CD = 'MSK' OR VSL.CRR_CD = 'EGL' " ).append("\n"); 
		query.append("                    THEN TO_CHAR(XXX.CSTMS_ESTM_ARR_DT,'yyyymmddhh24miss')" ).append("\n"); 
		query.append("        	        ELSE TO_CHAR(XXX.CSTMS_ESTM_ARR_DT,'yyyymmddhh24miss')" ).append("\n"); 
		query.append("		       END " ).append("\n"); 
		query.append("	      ELSE" ).append("\n"); 
		query.append("               CASE WHEN SKD2.SLAN_CD = 'TLS'" ).append("\n"); 
		query.append("               THEN" ).append("\n"); 
		query.append("                    CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '6'" ).append("\n"); 
		query.append("                         THEN TO_CHAR(SKD2.INIT_ETA_DT, 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("                         ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'IW') + 4, 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    WHEN SKD2.SLAN_CD = 'RFS' AND SKD2.SKD_DIR_CD = 'N'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '5'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '040000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'D') + 4, 'YYYYMMDD') || '040000' -- 일요일 기준" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                    WHEN SKD2.SLAN_CD = 'RFS' AND SKD2.SKD_DIR_CD = 'S'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '1'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '040000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'D'), 'YYYYMMDD') || '040000'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    WHEN SKD2.SLAN_CD = 'WA2'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '6'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '120000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'IW') + 4, 'YYYYMMDD') || '120000'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    WHEN SKD2.SLAN_CD = 'WAF'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(SKD2.INIT_ETA_DT,'D') = '3'" ).append("\n"); 
		query.append("                              THEN TO_CHAR(SKD2.INIT_ETA_DT, 'YYYYMMDD')|| '120000'" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(TRUNC(SKD2.INIT_ETA_DT, 'IW') + 1, 'YYYYMMDD') || '120000'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                         CASE WHEN VSL.CRR_CD = 'UAC' OR VSL.CRR_CD = 'HPL' OR VSL.CRR_CD = 'MSK' OR VSL.CRR_CD = 'EGL' THEN TO_CHAR(SKD2.INIT_ETA_DT,'yyyymmddhh24miss')" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(SKD2.INIT_ETA_DT,'yyyymmddhh24miss')" ).append("\n"); 
		query.append("                         END " ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("     END AS UNLOAD_LOC_ETA_HIS    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   /* 2011.06.27 그리스 부도 사태로 한시적으로 수정함*/" ).append("\n"); 
		query.append("   , (SELECT A.EUR_CSTMS_OFC_ID FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("       WHERE A.PORT_CD = CASE" ).append("\n"); 
		query.append("                            WHEN (SUBSTR(X.MVMT_REF_NO, 1, 4) = '11IT' AND SUBSTR(@[cstms_port_cd],1,2) = 'GR' ) THEN 'ITGIT'" ).append("\n"); 
		query.append("                            ELSE X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                         END " ).append("\n"); 
		query.append("         AND A.TML_CD IN ('ALL',X.CSTMS_YD_CD)" ).append("\n"); 
		query.append("          AND ROWNUM=1 " ).append("\n"); 
		query.append("      ) AS UNLOAD_OFC_CD /* 21 */ " ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("   /* 2011.06.27 그리스 부도 사태로 한시적으로 수정함*/" ).append("\n"); 
		query.append("   , CASE WHEN (SUBSTR(X.MVMT_REF_NO, 1, 4) = '11IT' AND SUBSTR(@[cstms_port_cd],1,2) = 'GR' ) " ).append("\n"); 
		query.append("     THEN  @[cstms_port_cd]" ).append("\n"); 
		query.append(" 	 ELSE" ).append("\n"); 
		query.append("		(SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ VPS_PORT_CD" ).append("\n"); 
		query.append("        	FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("	        WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("    	      AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("        	  AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("	          AND K.CLPT_SEQ > SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("	          AND ROWNUM = 1 " ).append("\n"); 
		query.append("    	  )" ).append("\n"); 
		query.append("	  END AS NEXT_LOC_CD /* 23 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , " ).append("\n"); 
		query.append("     CASE WHEN VSL.CRR_CD = 'UAC' OR VSL.CRR_CD = 'HPL' OR VSL.CRR_CD = 'MSK' OR VSL.CRR_CD = 'EGL' " ).append("\n"); 
		query.append("            THEN " ).append("\n"); 
		query.append("                    (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ TO_CHAR(INIT_ETA_DT,'yyyymmdd')||'120000'" ).append("\n"); 
		query.append("                        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("                        WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("                          AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND K.CLPT_SEQ > SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("                          AND ROWNUM = 1 " ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("                    (SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ TO_CHAR(INIT_ETA_DT,'yyyymmddhh24')||'0000'" ).append("\n"); 
		query.append("                        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("                        WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("                          AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND K.CLPT_SEQ > SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("                          AND ROWNUM = 1 " ).append("\n"); 
		query.append("                      )            " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("     END AS NEXT_LOC_ETA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   /* 2011.06.27 그리스 부도 사태로 한시적으로 수정함*/" ).append("\n"); 
		query.append("   , CASE WHEN (SUBSTR(X.MVMT_REF_NO, 1, 4) = '11IT' AND SUBSTR(@[cstms_port_cd],1,2) = 'GR' )   " ).append("\n"); 
		query.append("     THEN  (SELECT LOC_NM" ).append("\n"); 
		query.append("			  FROM MDM_LOCATION" ).append("\n"); 
		query.append("		 	 WHERE LOC_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append(" 	 ELSE" ).append("\n"); 
		query.append("		(SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ B.LOC_NM" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K,MDM_LOCATION B" ).append("\n"); 
		query.append("        WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("          AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ > SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND K.VPS_PORT_CD= B.LOC_CD" ).append("\n"); 
		query.append("          AND ROWNUM = 1 " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	  END  AS NEXT_LOC_NAME /* 24 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_type} != 'FI') " ).append("\n"); 
		query.append("   , ( SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */ B.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD K,BKG_CSTMS_EUR_CD_STUP B" ).append("\n"); 
		query.append("        WHERE K.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("          AND K.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND K.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ > SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND B.PORT_CD = K.VPS_PORT_CD" ).append("\n"); 
		query.append("		  AND B.TML_CD IN ('ALL',K.YD_CD)" ).append("\n"); 
		query.append("          AND ROWNUM = 1 " ).append("\n"); 
		query.append("     ) AS NEXT_OFC_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   , DECODE ( (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("                WHERE K.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND K.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND K.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND K.CLPT_SEQ > (SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                     WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                       AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                       AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                       AND VPS_PORT_CD = 'FIKTK')" ).append("\n"); 
		query.append("                  AND ROWNUM = 1 ) , 'DEKEL', 'DE004851', 'DEHAM', 'DE004851', '') AS NEXT_OFC_CD /*  25 */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , X.BL_NO AS BLNBR /* 46 */" ).append("\n"); 
		query.append("   , VSL.LLOYD_NO AS BL_TRANS_IDENTITY /* 47 */   " ).append("\n"); 
		query.append("   , VSL.VSL_RGST_CNT_CD AS BL_TRANS_NATION/* 48 */      " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   , X.POL_CD      AS  BLPOL         /* 49 */ " ).append("\n"); 
		query.append("   , POL_NM      AS  POL_FULLNAME  /* 50 */ " ).append("\n"); 
		query.append("   , X.POD_CD      AS  BLPOD         /* 51 */ " ).append("\n"); 
		query.append("   , POD_NM      AS  POD_FULLNAME  /* 52 */ " ).append("\n"); 
		query.append("   , (SELECT A.EUR_CSTMS_OFC_ID FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("       WHERE A.PORT_CD = X.POD_CD  AND A.TML_CD IN ('ALL',X.POD_YD_CD)" ).append("\n"); 
		query.append("        AND ROWNUM=1) AS POD_OFC_CD" ).append("\n"); 
		query.append("   , X.DEL_CD      AS  BLDEL         /* 53 */ " ).append("\n"); 
		query.append("   , DEL_NM      AS  DEL_FULLNAME  /* 54 */ " ).append("\n"); 
		query.append("   , PCK_QTY     AS  BLPKG         /* 55 */ " ).append("\n"); 
		query.append("  , NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("	   FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append("	  WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("       AND PCK_TP_CD = X.PCK_TP_CD),X.PCK_TP_CD)  AS  BLPKGU  /* 56 */ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , MEAS_QTY    AS  BLMEA         /* 57 */ " ).append("\n"); 
		query.append("   , MEAS_UT_CD  AS  BLMEAU        /* 58 */ " ).append("\n"); 
		query.append("   , X.CMDT_CD     AS  COMMODITY     /* 59 */ " ).append("\n"); 
		query.append("   , TRSP_DOC_NO AS  TRANS_DOC_NO  /* 60 */" ).append("\n"); 
		query.append("   , '' AS TRANS_DOC_NAME /* 61 */" ).append("\n"); 
		query.append("   , '' AS CUSTOMS_STATUS_CD /* 62 */" ).append("\n"); 
		query.append("   , '' AS PROCESS_INFO /* 63 */" ).append("\n"); 
		query.append("   , 'NULL' AS PROCESS_TYPE /* 64 */" ).append("\n"); 
		query.append("   , '' AS AEO_STATUS /* 65 */" ).append("\n"); 
		query.append("   , 'N' AS PART_SHIPMENT /* 66 */" ).append("\n"); 
		query.append("   , '' AS CONSIGN_PLACE /* 67 */" ).append("\n"); 
		query.append("   , TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(CSTMS_PORT_CD),'YYYYMMDDHH24MISS') AS DECLARE_DATE /* 68 */" ).append("\n"); 
		query.append("   , CSTMS_PORT_CD AS DECLARE_LOC /* 69 */" ).append("\n"); 
		query.append("   , (SELECT LOC_NM FROM MDM_LOCATION " ).append("\n"); 
		query.append("       WHERE LOC_CD = X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      ) AS DECLARE_LOC_NAME /* 70 */" ).append("\n"); 
		query.append("   , DECODE((SELECT FRT_TERM_CD FROM BKG_RATE WHERE 1=1 AND BKG_NO = @[bl_no]), 'P', 'H', 'Z') AS PAYMENT_CD /* 71 */" ).append("\n"); 
		query.append("   , DECODE( BKG.CUST_TO_ORD_FLG , 'Y','10600','') AS SPECIAL_REMARKS /* 74 */" ).append("\n"); 
		query.append("   , BKG_SPCLCHAR_CONV_CLOB_FNC(CSTMS_DESC,'X') AS DESCS /* 93 */" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(" , BKG_JOIN_FULL_CLOB_FNC(CURSOR(SELECT BKG_SPCLCHAR_CONV_CLOB_FNC(MK_DESC,'X') FROM BKG_BOOKING A, BKG_BL_MK_DESC B" ).append("\n"); 
		query.append("                             WHERE A.BL_NO = X.BL_NO" ).append("\n"); 
		query.append("                               AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    ),'$@$') AS MARKNO /* 96 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" , (SELECT  CNTC_NM||','||CNTC_PSN_NM||','||CNTC_EML||','||CNTC_PHN_NO||','||CNTC_FAX_NO" ).append("\n"); 
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
		query.append("FROM BKG_CSTMS_EUR_BL X, MDM_VSL_CNTR VSL , VSK_VSL_PORT_SKD SKD1,VSK_VSL_PORT_SKD SKD2 , BKG_BOOKING BKG" ).append("\n"); 
		query.append(",(SELECT T1.CSTMS_ESTM_ARR_DT" ).append("\n"); 
		query.append("    FROM ( SELECT K.CSTMS_ESTM_ARR_DT" ).append("\n"); 
		query.append("             FROM BKG_CSTMS_EUR_BL K " ).append("\n"); 
		query.append("            WHERE K.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("              AND K.VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("              AND K.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("              AND K.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("              AND K.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("          ) T1 RIGHT OUTER JOIN dual" ).append("\n"); 
		query.append("      ON T1.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append(") XXX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE X.VSL_CD =  VSL.VSL_CD" ).append("\n"); 
		query.append("AND X.VSL_cD = SKD1.VSL_cD" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO =SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD =SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND X.POL_CD= SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("AND SKD1.CLPT_IND_SEQ = NVL(X.POL_CLPT_IND_SEQ, '1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND X.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO =SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD =SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND X.CSTMS_PORT_CD= SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND SKD2.CLPT_IND_SEQ = NVL(@[eu_1st_port_clpt_seq], '1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND X.BL_NO = BKG.BL_NO" ).append("\n"); 
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