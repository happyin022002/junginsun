/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchEU24EDIHistoryOBRSQL.java
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

public class Eur24ManifestDownloadDBDAOSearchEU24EDIHistoryOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchEU24EDIHistoryOBRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchEU24EDIHistoryOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchEU24EDIHistoryOBRSQL").append("\n"); 
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
		query.append("/* EU24EDIHistoryOB	VO */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'Transmit'                                                                          AS TYPE_CD" ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , CSTMS_PORT_CD                  AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(SND.SND_DT ,'YYYY-MM-DD HH24:MI:SS')                                        AS LOCAL_TIME" ).append("\n"); 
		query.append("     , TO_CHAR(SND.SND_GDT ,'YYYY-MM-DD HH24:MI:SS')                                       AS GMT_TIME" ).append("\n"); 
		query.append("     , DECODE(MSG_FUNC_ID,'O','Original','U','Amendment')                                  AS MSG_TYPE" ).append("\n"); 
		query.append("     , ''                                                                                  AS RESULT" ).append("\n"); 
		query.append("     , SND.CRE_USR_ID                                                                      AS BY_ID" ).append("\n"); 
		query.append("     , USR.OFC_CD                                                                          AS BY_OFC_CD" ).append("\n"); 
		query.append("     , USR.USR_NM                                                                          AS BY_NAME" ).append("\n"); 
		query.append("     , ''																				   AS RCV_MSG" ).append("\n"); 
		query.append("     , '1'	                                                                               AS MSG_IMG" ).append("\n"); 
		query.append("     , ''                                                                                  AS MRN_NO" ).append("\n"); 
		query.append("     , NULL AS EDI_RCV_DT" ).append("\n"); 
		query.append("     , NULL AS EDI_RCV_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_IO_SND SND, COM_USER USR" ).append("\n"); 
		query.append("WHERE SND.CRE_USR_ID      = USR.USR_ID " ).append("\n"); 
		query.append("   AND SND.BL_NO           = @[p_bl_no]" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'Receive'                                                                             AS TYPE_CD" ).append("\n"); 
		query.append("     , SND.VSL_CD||SND.SKD_VOY_NO||SND.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , SND.CSTMS_PORT_CD                          AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(),RCV.CRE_DT, SND_USR_OFC_CD ), 'YYYY-MM-DD HH24:MI:SS') AS LOCAL_TIME" ).append("\n"); 
		query.append("     , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(),RCV.CRE_DT, 'GMT'),           'YYYY-MM-DD HH24:MI:SS') AS GMT_TIME" ).append("\n"); 
		query.append("     , DECODE(EUR_CSTMS_ACK_CD,'561','HOLD',DECODE(ACK_RCV_STS_CD,NULL,'','A','ACK','R','REJECT','F','FAIL','D','HOLD', 'P', 'HOLD', 'L', 'RELEASE')) AS MSG_TYPE" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("     , CASE WHEN EUR_CSTMS_ACK_CD ='561' 								THEN 'Hold'||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("			WHEN ACK_RCV_STS_CD = 'A'                                   THEN 'Accepted'   ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("            WHEN ACK_RCV_STS_CD = 'R'       AND EUR_CSTMS_ACK_CD ='351' THEN 'Do Not Load'||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("            WHEN ACK_RCV_STS_CD = 'R'                                   THEN 'Rejected'   ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("            WHEN ACK_RCV_STS_CD = 'D'                                   THEN 'Hold(Doc.)' ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("            WHEN ACK_RCV_STS_CD = 'P'                                   THEN 'Hold(Phys.)'||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("            WHEN ACK_RCV_STS_CD = 'L'                                   THEN 'Hold Release'||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("       END AS RESULT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CASE WHEN RCV.CRE_USR_ID  ='SYSTEM' 			THEN SND.CSTMS_PORT_CD" ).append("\n"); 
		query.append("			ELSE RCV.CRE_USR_ID " ).append("\n"); 
		query.append("       END AS BY_ID" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("     , CASE WHEN RCV.CRE_USR_ID  ='SYSTEM' 			THEN ''" ).append("\n"); 
		query.append("			ELSE USR.OFC_CD " ).append("\n"); 
		query.append("       END AS BY_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CASE WHEN RCV.CRE_USR_ID  ='SYSTEM' 			THEN ''" ).append("\n"); 
		query.append("			ELSE USR.USR_NM" ).append("\n"); 
		query.append("       END AS BY_NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , RJCT_RSN_RMK                                                                          AS RCV_MSG" ).append("\n"); 
		query.append("     , '0'                                                     								 AS MSG_IMG" ).append("\n"); 
		query.append("     , RCV.MVMT_REF_NO                                                                       AS MRN_NO" ).append("\n"); 
		query.append("     ,EDI_RCV_DT" ).append("\n"); 
		query.append("     ,EDI_RCV_SEQ " ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_IO_RCV RCV, BKG_CSTMS_EUR_IO_SND SND, COM_USER USR" ).append("\n"); 
		query.append(" WHERE RCV.MSG_RCV_NO = SND.MSG_SND_NO" ).append("\n"); 
		query.append("   AND RCV.CRE_USR_ID      = USR.USR_ID(+) " ).append("\n"); 
		query.append("   AND SND.BL_NO           = @[p_bl_no]" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append(" ORDER BY GMT_TIME" ).append("\n"); 

	}
}