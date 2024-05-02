/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchTmlManifestListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.14
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

public class ChinaCustomsTransmissionDBDAOsearchTmlManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchTmlManifestList
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchTmlManifestListRSQL(){
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
		params.put("bl_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchTmlManifestListRSQL").append("\n");
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
		query.append("SELECT  INFO.BKG_NO," ).append("\n");
		query.append("        INFO.BL_NO," ).append("\n");
		query.append("        INFO.POL_CD," ).append("\n");
		query.append("        INFO.POD_CD," ).append("\n");
		query.append("        INFO.DEL_CD," ).append("\n");
		query.append("		INFO.BKG_STS_CD," ).append("\n");
		query.append("        INFO.PCK_QTY," ).append("\n");
		query.append("        INFO.PCK_TP_CD," ).append("\n");
		query.append("        INFO.ACT_WGT," ).append("\n");
		query.append("        INFO.WGT_UT_CD," ).append("\n");
		query.append("        INFO.SHPR_NM," ).append("\n");
		query.append("        INFO.SHPR_ADDR," ).append("\n");
		query.append("        INFO.CNEE_NM," ).append("\n");
		query.append("        INFO.CNEE_ADDR," ).append("\n");
		query.append("        INFO.NTFY_NM," ).append("\n");
		query.append("        INFO.NTFY_ADDR," ).append("\n");
		query.append("        INFO.BKG_CGO_TP_CD," ).append("\n");
		query.append("        INFO.TR," ).append("\n");
		query.append("        INFO.DCGO_FLG, " ).append("\n");
		query.append("        INFO.RC_FLG," ).append("\n");
		query.append("		NTC.SND_USR_ID TRSM_MSG_TP_ID," ).append("\n");
		query.append("		MAX(TO_CHAR(NTC.SND_DT, 'YYYYMMDDHH24MISS')) MF_SND_DT," ).append("\n");
		query.append("        CNTR.SEAL_NO_FLG," ).append("\n");
		query.append("        CNTR.SEALER_CD_FLG," ).append("\n");
		query.append("        CNTR.CNTR_CNT," ).append("\n");
		query.append("		-- VSL Info" ).append("\n");
		query.append("		'' AS CALL_SGN_NO," ).append("\n");
		query.append("		'' AS PRE_PORT," ).append("\n");
		query.append("		'' AS NXT_PORT," ).append("\n");
		query.append("		'' AS VPS_ETA_DT," ).append("\n");
		query.append("		'' AS VPS_ETD_DT," ).append("\n");
		query.append("		'' AS VSL_ENG_NM," ).append("\n");
		query.append("		-- 조회 조건" ).append("\n");
		query.append("		@[vvd] 	  AS VVD," ).append("\n");
		query.append("		@[loc_cd] AS LOC_CD," ).append("\n");
		query.append("		-- 총 개수" ).append("\n");
		query.append("		'' AS TOTAL" ).append("\n");
		query.append("  FROM (" ).append("\n");
		query.append("            SELECT  B.BKG_NO BKG_NO," ).append("\n");
		query.append("                    B.BL_NO BL_NO," ).append("\n");
		query.append("                    B.POL_CD POL_CD," ).append("\n");
		query.append("                    B.POD_CD POD_CD," ).append("\n");
		query.append("                    B.DEL_CD DEL_CD," ).append("\n");
		query.append("					B.BKG_STS_CD," ).append("\n");
		query.append("                    DECODE(NVL(BL.PCK_QTY,0),0,'N','Y') PCK_QTY," ).append("\n");
		query.append("                    DECODE(BL.PCK_TP_CD,NULL,'N','Y') PCK_TP_CD," ).append("\n");
		query.append("                    DECODE(NVL(BL.ACT_WGT,0),0,'N','Y') ACT_WGT," ).append("\n");
		query.append("                    DECODE(BL.WGT_UT_CD,NULL,'N','Y') WGT_UT_CD," ).append("\n");
		query.append("                    DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_NM)), 0, 'N',NULL,'N', 'Y')) SHPR_NM," ).append("\n");
		query.append("                    DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_ADDR)), 0, 'N',NULL,'N', 'Y')) SHPR_ADDR," ).append("\n");
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.CUST_NM)), 0, 'N',NULL,'N', 'Y')) CNEE_NM," ).append("\n");
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(B.CUST_TO_ORD_FLG,'Y','Y',DECODE(LENGTH(TRIM(C.CUST_ADDR)), 0, 'N',NULL,'N', 'Y'))) CNEE_ADDR," ).append("\n");
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.CUST_NM)), 0, 'N',NULL,'N', 'Y')) NTFY_NM," ).append("\n");
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(B.SAM_CNEE_NTFY_FLG,'Y','Y',DECODE(LENGTH(TRIM(N.CUST_ADDR)), 0, 'N',NULL,'N', 'Y'))) NTFY_ADDR," ).append("\n");
		query.append("                    B.BKG_CGO_TP_CD," ).append("\n");
		query.append("                    DECODE(B.POL_CD, @[loc_cd], 'E', 'R') TR," ).append("\n");
		query.append("                    DECODE(B.DCGO_FLG,'N','N','Y') DCGO_FLG, " ).append("\n");
		query.append("                    DECODE(B.RC_FLG,'N','N','Y') RC_FLG" ).append("\n");
		query.append("            FROM    BKG_VVD BV, " ).append("\n");
		query.append("                    BKG_BOOKING B, " ).append("\n");
		query.append("                    BKG_BL_DOC BL," ).append("\n");
		query.append("                    BKG_CUSTOMER S, " ).append("\n");
		query.append("                    BKG_CUSTOMER C, " ).append("\n");
		query.append("                    BKG_CUSTOMER N," ).append("\n");
		query.append("    			    BKG_BL_ISS I" ).append("\n");
		query.append("            WHERE   BV.VSL_CD           =    SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("            AND     BV.SKD_VOY_NO       =    SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("            AND     BV.SKD_DIR_CD       =    SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("            AND     BV.BKG_NO           =    B.BKG_NO" ).append("\n");
		query.append("            AND     BV.BKG_NO           =    BL.BKG_NO" ).append("\n");
		query.append("            AND	    B.BKG_STS_CD		<>	'S'				" ).append("\n");
		query.append("		    AND	    B.BKG_STS_CD		<>	decode(@[bl_type],'C',' ','X')" ).append("\n");
		query.append("			AND	    BV.POL_CD	        =	@[loc_cd]				--T/S 물량 포함을 위해 SQL 문으로 수정. 2009.12.31 전창현" ).append("\n");
		query.append("		    --AND     SUBSTR(B.POD_CD,1,2) not in ('CA', 'US')" ).append("\n");
		query.append("			AND     B.POL_CD            LIKE 'CN%'					--T/S 물량 포함을 위해 SQL 문으로 수정. 2009.12.31 전창현" ).append("\n");
		query.append("		    AND     B.BKG_NO			=    I.BKG_NO" ).append("\n");
		query.append("		    AND     (I.OBL_ISS_DT is not null or I.OBL_ISS_FLG = 'Y')" ).append("\n");
		query.append("            AND     B.BKG_NO            =    S.BKG_NO(+)" ).append("\n");
		query.append("            AND     B.BKG_NO            =    C.BKG_NO(+)" ).append("\n");
		query.append("            AND     B.BKG_NO            =    N.BKG_NO(+)" ).append("\n");
		query.append("            AND     S.BKG_CUST_TP_CD(+) =    'S'" ).append("\n");
		query.append("            AND     C.BKG_CUST_TP_CD(+) =    'C'" ).append("\n");
		query.append("            AND     N.BKG_CUST_TP_CD(+) =    'N' " ).append("\n");
		query.append("        	--ZONE 콤보리스트에 따른 조건" ).append("\n");
		query.append("			#if (${zone} == 'I') " ).append("\n");
		query.append("        	--2) IPT : I ->" ).append("\n");
		query.append("        	AND (SUBSTR(B.ORG_SCONTI_CD,1,1) = SUBSTR(B.DEST_SCONTI_CD,1,1))" ).append("\n");
		query.append("			#elseif (${zone} == 'O') " ).append("\n");
		query.append("        	--3) OCN : O -> " ).append("\n");
		query.append("        	AND (SUBSTR(B.ORG_SCONTI_CD,1,1) <> SUBSTR(B.DEST_SCONTI_CD,1,1))" ).append("\n");
		query.append("			#else" ).append("\n");
		query.append("        	--1) All : A -> 추가 조건 없음." ).append("\n");
		query.append("			#end" ).append("\n");
		query.append("        	UNION" ).append("\n");
		query.append("        	SELECT  B.BKG_NO BKG_NO," ).append("\n");
		query.append("                    B.BL_NO BL_NO," ).append("\n");
		query.append("                    B.POL_CD POL_CD," ).append("\n");
		query.append("                    B.POD_CD POD_CD," ).append("\n");
		query.append("                    B.DEL_CD DEL_CD," ).append("\n");
		query.append("					B.BKG_STS_CD," ).append("\n");
		query.append("                    DECODE(NVL(BL.PCK_QTY,0),0,'N','Y') PCK_QTY," ).append("\n");
		query.append("                    DECODE(BL.PCK_TP_CD,NULL,'N','Y') PCK_TP_CD," ).append("\n");
		query.append("                    DECODE(NVL(BL.ACT_WGT,0),0,'N','Y') ACT_WGT," ).append("\n");
		query.append("                    DECODE(BL.WGT_UT_CD,NULL,'N','Y') WGT_UT_CD," ).append("\n");
		query.append("                    DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_NM)), 0, 'N',NULL,'N', 'Y')) SHPR_NM," ).append("\n");
		query.append("                    DECODE(S.BKG_CUST_TP_CD,'S',DECODE(LENGTH(TRIM(S.CUST_ADDR)), 0, 'N',NULL,'N', 'Y')) SHPR_ADDR," ).append("\n");
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(LENGTH(TRIM(C.CUST_NM)), 0, 'N',NULL,'N', 'Y')) CNEE_NM," ).append("\n");
		query.append("                    DECODE(C.BKG_CUST_TP_CD,'C',DECODE(B.CUST_TO_ORD_FLG,'Y','Y',DECODE(LENGTH(TRIM(C.CUST_ADDR)), 0, 'N',NULL,'N', 'Y'))) CNEE_ADDR," ).append("\n");
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(LENGTH(TRIM(N.CUST_NM)), 0, 'N',NULL,'N', 'Y')) NTFY_NM," ).append("\n");
		query.append("                    DECODE(N.BKG_CUST_TP_CD,'N',DECODE(B.SAM_CNEE_NTFY_FLG,'Y','Y',DECODE(LENGTH(TRIM(N.CUST_ADDR)), 0, 'N',NULL,'N', 'Y'))) NTFY_ADDR," ).append("\n");
		query.append("                    B.BKG_CGO_TP_CD," ).append("\n");
		query.append("                    DECODE(B.POL_CD, @[loc_cd], 'E', 'R') TR," ).append("\n");
		query.append("                    DECODE(B.DCGO_FLG,'N','N','Y') DCGO_FLG, " ).append("\n");
		query.append("                    DECODE(B.RC_FLG,'N','N','Y') RC_FLG" ).append("\n");
		query.append("            FROM    BKG_VVD BV, " ).append("\n");
		query.append("                    BKG_BOOKING B, " ).append("\n");
		query.append("                    BKG_BL_DOC BL," ).append("\n");
		query.append("                    BKG_CUSTOMER S, " ).append("\n");
		query.append("                    BKG_CUSTOMER C, " ).append("\n");
		query.append("                    BKG_CUSTOMER N," ).append("\n");
		query.append("    			    BKG_CSTMS_ADV_BL A" ).append("\n");
		query.append("            WHERE   BV.VSL_CD           =    SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("            AND     BV.SKD_VOY_NO       =    SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("            AND     BV.SKD_DIR_CD       =    SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("			AND		BV.POL_CD			= 	@[loc_cd]" ).append("\n");
		query.append("            AND     BV.BKG_NO           =    B.BKG_NO" ).append("\n");
		query.append("            AND     BV.BKG_NO           =    BL.BKG_NO" ).append("\n");
		query.append("            AND	    B.BKG_STS_CD		<>	'S'				" ).append("\n");
		query.append("		    AND	    B.BKG_STS_CD		<>	decode(@[bl_type],'C',' ','X')" ).append("\n");
		query.append("	        AND     B.POL_CD            LIKE    'CN%'" ).append("\n");
		query.append("		    AND     BV.BKG_NO			=    A.BKG_NO" ).append("\n");
		query.append("		    --AND     A.CNT_CD            in   ('CA', 'US')	" ).append("\n");
		query.append("            AND     B.BKG_NO            =    S.BKG_NO(+)" ).append("\n");
		query.append("            AND     B.BKG_NO            =    C.BKG_NO(+)" ).append("\n");
		query.append("            AND     B.BKG_NO            =    N.BKG_NO(+)" ).append("\n");
		query.append("            AND     S.BKG_CUST_TP_CD(+) =    'S'" ).append("\n");
		query.append("            AND     C.BKG_CUST_TP_CD(+) =    'C'" ).append("\n");
		query.append("            AND     N.BKG_CUST_TP_CD(+) =    'N' " ).append("\n");
		query.append("        	--ZONE 콤보리스트에 따른 조건" ).append("\n");
		query.append("			#if (${zone} == 'I') " ).append("\n");
		query.append("        	--2) IPT : I -> " ).append("\n");
		query.append("        	AND (SUBSTR(B.ORG_SCONTI_CD,1,1) = SUBSTR(B.DEST_SCONTI_CD,1,1))" ).append("\n");
		query.append("			#elseif (${zone} == 'O') " ).append("\n");
		query.append("        	--3) OCN : O -> " ).append("\n");
		query.append("        	AND (SUBSTR(B.ORG_SCONTI_CD,1,1) <> SUBSTR(B.DEST_SCONTI_CD,1,1))" ).append("\n");
		query.append("			#else" ).append("\n");
		query.append("        	--1) All : A -> 추가 조건 없음." ).append("\n");
		query.append("			#end" ).append("\n");
		query.append("         ) INFO, " ).append("\n");
		query.append("    	 (   SELECT  CNTR.BKG_NO," ).append("\n");
		query.append("                	 COUNT(*) CNTR_CNT," ).append("\n");
		query.append("                	 MIN(DECODE(TRIM(SEAL.CNTR_SEAL_NO),NULL,'N','Y')) SEAL_NO_FLG," ).append("\n");
		query.append("                	 MIN(DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD,1,1),'F','Y','A','Y',DECODE(TRIM(SEAL.SEAL_PTY_TP_CD),NULL,'N','Y'))) SEALER_CD_FLG" ).append("\n");
		query.append("        	 FROM    BKG_VVD BV," ).append("\n");
		query.append("           	     	 BKG_CONTAINER CNTR," ).append("\n");
		query.append("                	 BKG_CNTR_SEAL_NO SEAL" ).append("\n");
		query.append("             WHERE   BV.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("             AND     BV.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("             AND     BV.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("        	 AND     BV.BKG_NO     = CNTR.BKG_NO" ).append("\n");
		query.append("        	 AND     CNTR.BKG_NO   = SEAL.BKG_NO(+)" ).append("\n");
		query.append("        	 AND     CNTR.CNTR_NO  = SEAL.CNTR_NO(+)" ).append("\n");
		query.append("        	 GROUP BY CNTR.BKG_NO" ).append("\n");
		query.append("    	 ) CNTR," ).append("\n");
		query.append("		(	SELECT * " ).append("\n");
		query.append(" 		 	FROM (" ).append("\n");
		query.append("    			SELECT  N.BKG_NO, N.SND_USR_ID, N.SND_DT, N.NTC_KND_CD, N.NTC_VIA_CD, " ).append("\n");
		query.append("            			DENSE_RANK() OVER(PARTITION BY N.BKG_NO ORDER BY N.SND_DT DESC) AS RNUM" ).append("\n");
		query.append("    			FROM    BKG_VVD V, BKG_NTC_HIS N" ).append("\n");
		query.append("    			WHERE   V.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("    			AND     V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("    			AND     V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("    			AND     V.BKG_NO     = N.BKG_NO" ).append("\n");
		query.append("				AND     N.NTC_KND_CD = 'TM'" ).append("\n");
		query.append("				AND		N.SND_DT 	 IS NOT NULL" ).append("\n");
		query.append(" 			)" ).append("\n");
		query.append(" 			WHERE RNUM = 1" ).append("\n");
		query.append("		) NTC" ).append("\n");
		query.append("   WHERE INFO.BKG_NO       = CNTR.BKG_NO(+)" ).append("\n");
		query.append("     AND INFO.BKG_NO       = NTC.BKG_NO(+)" ).append("\n");
		query.append("	 AND NTC.NTC_VIA_CD(+) = 'E'" ).append("\n");
		query.append("	 AND NTC.NTC_KND_CD(+) = 'TM'  --기존 터미널 EDI 는 BT 인자로 입력됨. 겹치지 않음." ).append("\n");
		query.append("	 AND decode(NVL(NTC.SND_USR_ID,'N'),'N','N','S') like decode(@[bl_type],'A','%','N','N','C','S',@[bl_type])" ).append("\n");
		query.append("GROUP BY INFO.BKG_NO," ).append("\n");
		query.append("         INFO.BL_NO," ).append("\n");
		query.append("         INFO.POL_CD," ).append("\n");
		query.append("         INFO.POD_CD," ).append("\n");
		query.append("         INFO.DEL_CD," ).append("\n");
		query.append("		 INFO.BKG_STS_CD," ).append("\n");
		query.append("         INFO.PCK_QTY," ).append("\n");
		query.append("         INFO.PCK_TP_CD," ).append("\n");
		query.append("         INFO.ACT_WGT," ).append("\n");
		query.append("         INFO.WGT_UT_CD," ).append("\n");
		query.append("         INFO.SHPR_NM," ).append("\n");
		query.append("         INFO.SHPR_ADDR," ).append("\n");
		query.append("         INFO.CNEE_NM," ).append("\n");
		query.append("         INFO.CNEE_ADDR," ).append("\n");
		query.append("         INFO.NTFY_NM," ).append("\n");
		query.append("         INFO.NTFY_ADDR," ).append("\n");
		query.append("         INFO.BKG_CGO_TP_CD," ).append("\n");
		query.append("         INFO.TR," ).append("\n");
		query.append("         INFO.DCGO_FLG, " ).append("\n");
		query.append("         INFO.RC_FLG," ).append("\n");
		query.append("		 NTC.SND_USR_ID," ).append("\n");
		query.append("         CNTR.SEAL_NO_FLG," ).append("\n");
		query.append("         CNTR.SEALER_CD_FLG," ).append("\n");
		query.append("         CNTR.CNTR_CNT" ).append("\n");
		query.append("ORDER BY INFO.BL_NO" ).append("\n");

	}
}