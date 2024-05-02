/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchBlFIArrivalNoticeRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.07
*@LastModifier :
*@LastVersion : 1.0
* 2014.08.07
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchBlFIArrivalNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchBlFIArrivalNotice
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchBlFIArrivalNoticeRSQL(){
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
		params.put("form_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n");
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchBlFIArrivalNoticeRSQL").append("\n");
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
		query.append("SELECT        DENSE_RANK() OVER (ORDER BY POD,BL_NO) AS DT_SEQ" ).append("\n");
		query.append("              , DECODE(ENS_SEND_DT,NULL,'',ENS_SEND_DT||CHR(10)||'('||ENS_SEND_GMT_DT||')') AS SENT_TIME" ).append("\n");
		query.append("              , DECODE(ACK_RCV_DT,NULL,'',ACK_RCV_DT||CHR(10)||'('||ACK_RCV_GMT_DT||')') AS RECEIVED_TIME" ).append("\n");
		query.append("              , Y.*" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT " ).append("\n");
		query.append("    " ).append("\n");
		query.append("     DECODE( ( SELECT BKG_NO FROM BKG_VVD WHERE BKG_NO = X.BKG_NO AND SLAN_CD ='RFS' AND ROWNUM = 1)," ).append("\n");
		query.append("              NULL, 'N', 'Y') AS RFS_YN" ).append("\n");
		query.append("    " ).append("\n");
		query.append("      , CASE WHEN DOWNLOAD_YN = 'N'                          				THEN ''" ).append("\n");
		query.append("           WHEN ACK = 'A' AND RESULT_CD ='348'             				THEN 'Accepted'   ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n");
		query.append("		   WHEN ACK = 'A' AND RESULT_CD ='900'             				THEN 'Accepted'   ||DECODE(ACK_KND_ID,'S','(S)')  --system ack" ).append("\n");
		query.append("           WHEN ACK = 'R' AND RESULT_CD ='351'             				THEN 'Do Not Load'||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n");
		query.append("           WHEN ACK = 'R' AND RESULT_CD ='398'             				THEN 'Cancellation'    ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n");
		query.append("           WHEN ACK = 'R'                                  				THEN 'Rejected'   ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n");
		query.append("           WHEN RESULT_CD ='361'                           				THEN 'Customs Hold'       ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n");
		query.append("           WHEN ACK = 'A' AND RESULT_CD ='330' OR RESULT_CD ='329'      THEN 'Customs Release'    ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n");
		query.append("           WHEN RESULT_CD ='100'                           				THEN 'Conditionally Accepted'  ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n");
		query.append("           WHEN RESULT_CD ='322'                           				THEN 'Customs Release rejection'||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n");
		query.append("           WHEN MSG_SND_NO IS NOT NULL AND RCV IS NULL     				THEN 'Not Received'" ).append("\n");
		query.append("       END AS ENS_RESULT" ).append("\n");
		query.append("       " ).append("\n");
		query.append("    , CASE WHEN DOWNLOAD_YN = 'N'                          					THEN ''" ).append("\n");
		query.append("           WHEN ACK = 'A'                                  					THEN 'A'  --Accepted" ).append("\n");
		query.append("           WHEN ACK = 'R' AND RESULT_CD ='351'             					THEN 'DNL' --Do Not Load" ).append("\n");
		query.append("           WHEN ACK = 'R'                                  					THEN 'R' --Rejected" ).append("\n");
		query.append("           WHEN RESULT_CD ='361'                           					THEN 'H' --Customs Hold" ).append("\n");
		query.append("           WHEN ACK = 'A' AND RESULT_CD ='330' OR RESULT_CD ='329'          THEN 'L' --Customs Release" ).append("\n");
		query.append("           WHEN RESULT_CD ='100'                                		 	THEN 'CA' --Conditionally Accepted" ).append("\n");
		query.append("           WHEN ACK = 'R' AND RESULT_CD ='398'             					THEN 'CC' --Cancellation" ).append("\n");
		query.append("           WHEN RESULT_CD ='322'                                  			THEN 'D' --Customs Relase rejection" ).append("\n");
		query.append("           WHEN MSG_SND_NO IS NOT NULL AND RCV IS NULL     					THEN 'NR' --Not Received" ).append("\n");
		query.append("       END AS RESULT2" ).append("\n");
		query.append("    " ).append("\n");
		query.append("    , DECODE(EDI_MRN,NULL,'Original','Amendment') AS BL_STATUS" ).append("\n");
		query.append("    , X.*" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("(                    " ).append("\n");
		query.append("  SELECT" ).append("\n");
		query.append("   ACK ," ).append("\n");
		query.append("   ACK_KND_ID ," ).append("\n");
		query.append("   ACK_RCV_DT ," ).append("\n");
		query.append("   ACK_RCV_GMT_DT ," ).append("\n");
		query.append("   BKG_NO ," ).append("\n");
		query.append("   BL_NO ," ).append("\n");
		query.append("   BPOD ," ).append("\n");
		query.append("   BPOL ," ).append("\n");
		query.append("   CNTR_CNTR_NO ," ).append("\n");
		query.append("   DEL ," ).append("\n");
		query.append("   DOWNLOAD_YN ," ).append("\n");
		query.append("   EDI_MRN ," ).append("\n");
		query.append("   KTS_SEND_DT," ).append("\n");
		query.append("   ENS_SEND_DT ," ).append("\n");
		query.append("   ENS_SEND_GMT_DT ," ).append("\n");
		query.append("   EU_1ST_PORT ," ).append("\n");
		query.append("   MSG_SND_NO," ).append("\n");
		query.append("   POD ," ).append("\n");
		query.append("   POL ," ).append("\n");
		query.append("   RCV ," ).append("\n");
		query.append("   RESULT_CD," ).append("\n");
		query.append("   SKD_DIR_CD ," ).append("\n");
		query.append("   SKD_VOY_NO ," ).append("\n");
		query.append("   SND_USR_OFC_CD," ).append("\n");
		query.append("   VSL_CD ," ).append("\n");
		query.append("   VVD ," ).append("\n");
		query.append("   RCV_MSG," ).append("\n");
		query.append("   EDI_RCV_DT ," ).append("\n");
		query.append("   EDI_RCV_SEQ " ).append("\n");
		query.append("   FROM " ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT BKG_GET_TOKEN_FNC(RCV,3) AS ACK" ).append("\n");
		query.append("       , BKG_GET_TOKEN_FNC(RCV,5) AS RESULT_CD" ).append("\n");
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(),TO_DATE(BKG_GET_TOKEN_FNC(RCV,4),'YYYY-MM-DD HH24:MI'), SND_USR_OFC_CD ), 'YYYY-MM-DD HH24:MI')  AS ACK_RCV_DT" ).append("\n");
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(),TO_DATE(BKG_GET_TOKEN_FNC(RCV,4),'YYYY-MM-DD HH24:MI'), 'GMT'),           'YYYY-MM-DD HH24:MI')  AS ACK_RCV_GMT_DT" ).append("\n");
		query.append("       , BKG_GET_TOKEN_FNC(RCV,6) AS ACK_KND_ID" ).append("\n");
		query.append("       , BKG_GET_TOKEN_FNC(RCV,7) AS RCV_MSG" ).append("\n");
		query.append("       , DECODE(EBL_NO,NULL,'N','Y')AS DOWNLOAD_YN" ).append("\n");
		query.append("       , MVMT_REF_NO AS EDI_MRN  -- EDI_MRN ENS MRN" ).append("\n");
		query.append("       , NVL(KTS_SEND_DT1,KTS_SEND_DT2) AS KTS_SEND_DT" ).append("\n");
		query.append("       , BKG_GET_TOKEN_FNC(RCV,1) AS EDI_RCV_DT" ).append("\n");
		query.append("       , BKG_GET_TOKEN_FNC(RCV,2) AS EDI_RCV_SEQ" ).append("\n");
		query.append("       , K.*" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT " ).append("\n");
		query.append("    (" ).append("\n");
		query.append("    SELECT EDI_RCV_DT ||','||EDI_RCV_SEQ ||','||ACK_RCV_STS_CD ||','||TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI') ||','||EUR_CSTMS_ACK_CD ||','||ACK_KND_ID ||','||RJCT_RSN_RMK ||','|| MVMT_REF_NO" ).append("\n");
		query.append("    FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n");
		query.append("    WHERE RCV_TMS = (" ).append("\n");
		query.append("        SELECT MAX(RCV_TMS)" ).append("\n");
		query.append("        FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n");
		query.append("        WHERE MSG_RCV_NO = BKG_GET_TOKEN_FNC(KKK.SND, 1)" ).append("\n");
		query.append("          AND (ACK_KND_ID != 'S'" ).append("\n");
		query.append("              OR ACK_RCV_STS_CD != 'A')" ).append("\n");
		query.append("          AND  EUR_CSTMS_ACK_CD <> '348' )" ).append("\n");
		query.append("           ) AS RCV ," ).append("\n");
		query.append("  BKG_GET_TOKEN_FNC(KKK.SND, 1) AS MSG_SND_NO ," ).append("\n");
		query.append("  BKG_GET_TOKEN_FNC(KKK.SND, 2) AS ENS_SEND_DT ," ).append("\n");
		query.append("  BKG_GET_TOKEN_FNC(KKK.SND, 3) AS ENS_SEND_GMT_DT ," ).append("\n");
		query.append("  BKG_GET_TOKEN_FNC(KKK.SND, 4) AS SND_USR_OFC_CD ," ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append(" (" ).append("\n");
		query.append("       SELECT MVMT_REF_NO" ).append("\n");
		query.append("       FROM BKG_CSTMS_EUR_BL EBL" ).append("\n");
		query.append("       WHERE  EBL.BL_NO = KKK.BL_NO" ).append("\n");
		query.append("              AND EBL.CSTMS_PORT_CD = KKK.EU_1ST_PORT" ).append("\n");
		query.append("              AND EBL.VSL_CD = KKK.VSL_CD" ).append("\n");
		query.append("              AND EBL.SKD_VOY_NO = KKK.SKD_VOY_NO" ).append("\n");
		query.append("              AND EBL.SKD_DIR_CD = KKK.SKD_DIR_CD  )  AS MVMT_REF_NO," ).append("\n");
		query.append("" ).append("\n");
		query.append("  BKG_GET_TOKEN_FNC(KKK.SND, 6) AS KTS_SEND_DT1 ," ).append("\n");
		query.append("  (" ).append("\n");
		query.append("    SELECT MAX(TO_CHAR(CRE_DT, 'YYYYMMDDHH24'))" ).append("\n");
		query.append("    FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n");
		query.append("    WHERE BL_NO = KKK.BL_NO" ).append("\n");
		query.append("      AND CSTMS_PORT_CD = KKK.EU_1ST_PORT ) AS KTS_SEND_DT2 ," ).append("\n");
		query.append("  BKG_GET_TOKEN_FNC(KKK.SND, 5) AS EBL_NO ," ).append("\n");
		query.append("  KKK.*" ).append("\n");
		query.append("---------------------------" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("    --SELECT (" ).append("\n");
		query.append("       -- SELECT A.MSG_SND_NO ||','||TO_CHAR(A.SND_DT, 'YYYY-MM-DD HH24:MI') ||','||TO_CHAR(A.SND_GDT, 'YYYY-MM-DD HH24:MI') ||','||A.SND_USR_OFC_CD ||','||A.BL_NO ||','||TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24')" ).append("\n");
		query.append("       -- FROM BKG_CSTMS_ADV_EUR_SND A --, BKG_CSTMS_EUR_BL EBL" ).append("\n");
		query.append("       -- WHERE 1=1" ).append("\n");
		query.append("         -- AND A.EUR_EDI_MSG_TP_ID ='347'" ).append("\n");
		query.append("         -- AND A.bl_no =KK.BL_NO" ).append("\n");
		query.append("          --and A.MSG_SND_NO = (" ).append("\n");
		query.append("            --SELECT MAX(MSG_SND_NO)" ).append("\n");
		query.append("            --FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n");
		query.append("            --WHERE EUR_EDI_MSG_TP_ID ='347'" ).append("\n");
		query.append("              --AND BL_NO =KK.BL_NO) ) AS SND," ).append("\n");
		query.append(" SELECT (" ).append("\n");
		query.append("        SELECT A.MSG_SND_NO ||','||TO_CHAR(A.SND_DT, 'YYYY-MM-DD HH24:MI') ||','||TO_CHAR(A.SND_GDT, 'YYYY-MM-DD HH24:MI') ||','||A.SND_USR_OFC_CD ||','||A.BL_NO ||','||TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24')" ).append("\n");
		query.append("        FROM BKG_CSTMS_ADV_EUR_SND A " ).append("\n");
		query.append("        WHERE 1=1" ).append("\n");
		query.append("          AND A.EUR_EDI_MSG_TP_ID ='347'" ).append("\n");
		query.append("          AND A.bl_no =KK.BL_NO" ).append("\n");
		query.append("          and A.MSG_SND_NO = (" ).append("\n");
		query.append("            SELECT MAX(SND.MSG_SND_NO)" ).append("\n");
		query.append("            FROM BKG_CSTMS_ADV_EUR_SND SND ,BKG_CSTMS_EUR_BL B" ).append("\n");
		query.append("            WHERE SND.EUR_EDI_MSG_TP_ID ='347'" ).append("\n");
		query.append("              AND SND.BL_NO =KK.BL_NO" ).append("\n");
		query.append("              AND SND.BL_NO=B.BL_NO" ).append("\n");
		query.append("              AND SND.VSL_CD = B.VSL_CD" ).append("\n");
		query.append("              AND SND.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n");
		query.append("              AND SND.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n");
		query.append("              AND SND.CSTMS_PORT_CD = B.CSTMS_PORT_CD" ).append("\n");
		query.append("              AND SND.MSG_SND_NO like KK.BL_NO || '%') ) AS SND," ).append("\n");
		query.append("      KK.*" ).append("\n");
		query.append("    FROM (" ).append("\n");
		query.append("        SELECT VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD ," ).append("\n");
		query.append("          VVD.VSL_CD ," ).append("\n");
		query.append("          VVD.SKD_VOY_NO ," ).append("\n");
		query.append("          VVD.SKD_DIR_CD ," ).append("\n");
		query.append("          BKG.BL_NO AS BL_NO ," ).append("\n");
		query.append("          BKG.BKG_NO AS BKG_NO ," ).append("\n");
		query.append("          VVD.POL_CD AS POL ," ).append("\n");
		query.append("          VVD.POD_CD AS POD ," ).append("\n");
		query.append("          BKG.POL_CD AS BPOL ," ).append("\n");
		query.append("          BKG.POD_CD AS BPOD ," ).append("\n");
		query.append("          BKG.DEL_CD AS DEL ," ).append("\n");
		query.append("          BC.CNTR_NO AS CNTR_CNTR_NO," ).append("\n");
		query.append("          SUBSTR(@[cstms_port_cd], 1, 5) AS EU_1ST_PORT --" ).append("\n");
		query.append("        FROM BKG_VVD VVD ," ).append("\n");
		query.append("          BKG_BOOKING BKG ," ).append("\n");
		query.append("          BKG_BL_DOC BD ," ).append("\n");
		query.append("          VSK_VSL_PORT_SKD SKD1,  " ).append("\n");
		query.append("          VSK_VSL_PORT_SKD SKD2, " ).append("\n");
		query.append("          BKG_CONTAINER BC ," ).append("\n");
		query.append("          BKG_CSTMS_EUR_BL BL" ).append("\n");
		query.append("        WHERE 1=1" ).append("\n");
		query.append("          AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n");
		query.append("          AND BKG.BKG_STS_CD IN ('F','W')" ).append("\n");
		query.append("          AND BKG.BKG_CGO_TP_CD IN ('F','R')" ).append("\n");
		query.append("          AND BKG.BL_NO IS NOT NULL" ).append("\n");
		query.append("          AND BKG.BKG_NO = BD.BKG_NO" ).append("\n");
		query.append("          AND BKG.BKG_NO = BC.BKG_NO(+)" ).append("\n");
		query.append("---------------------------------------" ).append("\n");
		query.append("          AND BKG.BL_NO = BL.BL_NO (+)" ).append("\n");
		query.append("          AND VVD.VSL_CD = BL.VSL_CD" ).append("\n");
		query.append("          AND VVD.SKD_VOY_NO = BL.SKD_VOY_NO" ).append("\n");
		query.append("          AND VVD.SKD_DIR_CD = BL.SKD_DIR_CD" ).append("\n");
		query.append("----------------------------------------" ).append("\n");
		query.append("          AND VVD.VSL_CD = SKD1.VSL_CD" ).append("\n");
		query.append("          AND VVD.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n");
		query.append("          AND VVD.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n");
		query.append("          AND VVD.POL_CD = SKD1.VPS_PORT_CD" ).append("\n");
		query.append("          AND VVD.POL_CLPT_IND_SEQ = SKD1.CLPT_IND_SEQ" ).append("\n");
		query.append("          AND SKD2.VSL_CD = VVD.VSL_CD" ).append("\n");
		query.append("          AND SKD2.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n");
		query.append("          AND SKD2.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n");
		query.append("          AND SKD2.CLPT_IND_SEQ = 1" ).append("\n");
		query.append("          AND SKD1.CLPT_SEQ < SKD2.CLPT_SEQ" ).append("\n");
		query.append(" " ).append("\n");
		query.append("        " ).append("\n");
		query.append("" ).append("\n");
		query.append("          AND VVD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("          AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("          AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("" ).append("\n");
		query.append("          AND VVD.BKG_NO > ' '" ).append("\n");
		query.append("          AND VVD.SLAN_CD > ' '" ).append("\n");
		query.append("          AND SKD2.VPS_PORT_CD = VVD.POD_CD -- FI (NEW)" ).append("\n");
		query.append("          AND VVD.POD_CD = @[cstms_port_cd]" ).append("\n");
		query.append("          AND SKD2.VPS_PORT_CD = SUBSTR(@[cstms_port_cd], 1, 5)" ).append("\n");
		query.append("         " ).append("\n");
		query.append("		UNION" ).append("\n");
		query.append("" ).append("\n");
		query.append("        SELECT " ).append("\n");
		query.append("         VVD," ).append("\n");
		query.append("         VSL_CD," ).append("\n");
		query.append("         SKD_VOY_NO," ).append("\n");
		query.append("         SKD_DIR_CD," ).append("\n");
		query.append("         BL_NO," ).append("\n");
		query.append("         BKG_NO," ).append("\n");
		query.append("         POL," ).append("\n");
		query.append("         POD," ).append("\n");
		query.append("         BPOL," ).append("\n");
		query.append("         BPOD," ).append("\n");
		query.append("         DEL," ).append("\n");
		query.append("         CNTR_CNTR_NO," ).append("\n");
		query.append("         EU_1ST_PORT" ).append("\n");
		query.append("         FROM (          " ).append("\n");
		query.append("         SELECT " ).append("\n");
		query.append("          VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD ," ).append("\n");
		query.append("          VVD.VSL_CD ," ).append("\n");
		query.append("          VVD.SKD_VOY_NO ," ).append("\n");
		query.append("          VVD.SKD_DIR_CD ," ).append("\n");
		query.append("          BKG.BL_NO AS BL_NO ," ).append("\n");
		query.append("          BKG.BKG_NO AS BKG_NO ," ).append("\n");
		query.append("          VVD.POL_CD AS POL ," ).append("\n");
		query.append("          VVD.POD_CD AS POD ," ).append("\n");
		query.append("          BKG.POL_CD AS BPOL ," ).append("\n");
		query.append("          BKG.POD_CD AS BPOD ," ).append("\n");
		query.append("          BKG.DEL_CD AS DEL ," ).append("\n");
		query.append("          BC.CNTR_NO AS CNTR_CNTR_NO," ).append("\n");
		query.append("          SUBSTR(@[cstms_port_cd], 1, 5) AS EU_1ST_PORT --" ).append("\n");
		query.append("         ,ROW_NUMBER() OVER(PARTITION BY ENS.BL_NO ORDER BY ENS.BL_NO,MVMT_REF_NO ASC) RM" ).append("\n");
		query.append("           FROM VSK_VSL_PORT_SKD VSK, BKG_VVD VVD , BKG_CSTMS_EUR_BL ENS , BKG_BOOKING BKG, BKG_CONTAINER BC" ).append("\n");
		query.append("          WHERE 1=1" ).append("\n");
		query.append("          AND VSK.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("          AND VSK.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("          AND VSK.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("          AND VSK.VSL_CD = VVD.VSL_CD" ).append("\n");
		query.append("          AND VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n");
		query.append("          AND VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n");
		query.append("          AND VSK.VPS_PORT_CD = VVD.POD_CD" ).append("\n");
		query.append("          AND VSK.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n");
		query.append("          AND BKG.BKG_NO = BC.BKG_NO(+)" ).append("\n");
		query.append("          --AND VSK.VPS_PORT_CD ='FIKTK'" ).append("\n");
		query.append("          AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n");
		query.append("          AND ENS.BL_NO = BKG.BL_NO" ).append("\n");
		query.append("          AND VSK.CLPT_SEQ > (SELECT MAX(CLPT_SEQ) FROM VSK_VSL_PORT_SKD" ).append("\n");
		query.append("                               WHERE 1=1" ).append("\n");
		query.append("                                 AND VSL_CD = VSK.VSL_CD" ).append("\n");
		query.append("                                 AND SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n");
		query.append("                                 AND SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n");
		query.append("                                 AND VPS_PORT_CD =@[cstms_port_cd]" ).append("\n");
		query.append("                               )" ).append("\n");
		query.append("        )" ).append("\n");
		query.append("        WHERE RM = 1 " ).append("\n");
		query.append("" ).append("\n");
		query.append("          #if (${chk_all} != '') " ).append("\n");
		query.append("            " ).append("\n");
		query.append("		  #else " ).append("\n");
		query.append("            AND 2=1" ).append("\n");
		query.append("		  #end " ).append("\n");
		query.append("" ).append("\n");
		query.append("          ) KK" ).append("\n");
		query.append(" ) KKK --, (SELECT * FROM BKG_CSTMS_ADV_EUR_RCV WHERE (ACK_RCV_STS_CD <> 'A' OR ACK_KND_ID <> 'S') ) RCV " ).append("\n");
		query.append(" WHERE 1=1" ).append("\n");
		query.append(" --AND BKG_GET_TOKEN_FNC(KKK.SND, 1) = RCV.MSG_RCV_NO(+)" ).append("\n");
		query.append(") K" ).append("\n");
		query.append(")" ).append("\n");
		query.append(" WHERE 1=1" ).append("\n");
		query.append("  " ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("              #if (${form_bl_no} != '') " ).append("\n");
		query.append("				AND BL_NO = @[form_bl_no]" ).append("\n");
		query.append("             #end" ).append("\n");
		query.append("" ).append("\n");
		query.append("                                          #if (${p_ack_status} == 'A' )" ).append("\n");
		query.append("                                                AND ACK  = 'A' AND RESULT_CD  = '348'" ).append("\n");
		query.append("                                           #elseif (${p_ack_status} == 'R')" ).append("\n");
		query.append("                                                AND ACK  != 'A' AND ACK IS NOT NULL" ).append("\n");
		query.append("                                           #elseif (${p_ack_status} == 'DNL')" ).append("\n");
		query.append("                                                AND RESULT_CD  = '351'" ).append("\n");
		query.append("                                           #elseif (${p_ack_status} == 'NR')" ).append("\n");
		query.append("                                                AND MSG_SND_NO IS NOT NULL AND RCV IS NULL" ).append("\n");
		query.append("                                           #elseif (${p_ack_status} == 'NA')" ).append("\n");
		query.append("                                                AND MSG_SND_NO IS NULL" ).append("\n");
		query.append("" ).append("\n");
		query.append("										   #elseif (${p_ack_status} == 'CA')" ).append("\n");
		query.append("                                                AND RESULT_CD  = '100'" ).append("\n");
		query.append("										   #elseif (${p_ack_status} == 'H')" ).append("\n");
		query.append("                                                AND RESULT_CD  = '361'" ).append("\n");
		query.append("										   #elseif (${p_ack_status} == 'L')" ).append("\n");
		query.append("                                                AND ( RESULT_CD  = '330' OR RESULT_CD  = '329')" ).append("\n");
		query.append("										   #elseif (${p_ack_status} == 'D')" ).append("\n");
		query.append("                                                AND RESULT_CD  = '322'" ).append("\n");
		query.append("										   #elseif (${p_ack_status} == 'CC')" ).append("\n");
		query.append("                                                AND RESULT_CD  = '398'" ).append("\n");
		query.append("                                           #end" ).append("\n");
		query.append("                                           " ).append("\n");
		query.append(" ) X ) Y" ).append("\n");

	}
}