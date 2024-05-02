/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.03.19 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOsearchAncsCstmsVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsVvdListRSQL(){
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
		params.put("s_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsVvdListRSQL").append("\n"); 
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
		query.append("SELECT   A.*, NVL (B.TTL_COUNT, 0) AS BKG_COUNT," ).append("\n"); 
		query.append("         NVL (C.TTL_COUNT, 0) AS DNLD_COUNT, D.EDI_STS, D.SND_DT," ).append("\n"); 
		query.append("         D.SND_USR_ID, D.RCV_DT" ).append("\n"); 
		query.append("    FROM ( SELECT A.SLAN_CD AS SLAN_CD," ).append("\n"); 
		query.append("               A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               D.SVC_RQST_NO AS SSR_NO," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, C.VSL_ENG_NM, D.VVD_NM) AS VVD_NM," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, 'L', LLOYD_TP_CD) AS LLOYD_TP_CD," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, C.LLOYD_NO, D.LLOYD_NO) AS LLOYD_NO," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, A.VPS_ETA_DT, D.ETA_DT) AS ETA_DT," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, 'N', D.ANR_MSG_STS_CD) AS MSG_STS_CD," ).append("\n"); 
		query.append("               A.VPS_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("               VSK_VSL_SKD B," ).append("\n"); 
		query.append("               MDM_VSL_CNTR C," ).append("\n"); 
		query.append("               BKG_CSTMS_ANR_VVD D," ).append("\n"); 
		query.append("               BKG_HRD_CDG_CTNT E," ).append("\n"); 
		query.append("               BKG_CSTMS_CD_CONV_CTNT F" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VPS_ETA_DT >= TO_DATE (@[s_vps_eta_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("           AND A.VPS_ETA_DT < TO_DATE (@[e_vps_eta_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${vvd} != '')" ).append("\n"); 
		query.append("				   AND A.VSL_CD        =  SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("				   AND A.SKD_VOY_NO    =  SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("				   AND A.SKD_DIR_CD    =  SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND E.HRD_CDG_ID = 'ANR_CSTMS_SLAN_CD'" ).append("\n"); 
		query.append("           AND A.SLAN_CD = E.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = DECODE (E.ATTR_CTNT2, 'A', A.SKD_DIR_CD, 'W')" ).append("\n"); 
		query.append("           AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A.VPS_PORT_CD = F.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND F.CNT_CD = 'BE'" ).append("\n"); 
		query.append("           AND F.CSTMS_DIV_ID  = 'EUR_BE_PORT_LIST'" ).append("\n"); 
		query.append("           AND F.CSTMS_DIV_ID_SEQ > 0" ).append("\n"); 
		query.append("           AND F.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${svc_rqst_no} != '') " ).append("\n"); 
		query.append("				   AND D.SVC_RQST_NO   = @[svc_rqst_no]" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("				   #if (${msg_sts_cd} != 'L') " ).append("\n"); 
		query.append("				   AND D.ANR_MSG_STS_CD = @[msg_sts_cd]" ).append("\n"); 
		query.append("				   #end " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND D.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("           AND D.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND D.SKD_DIR_CD(+) = A.SKD_DIR_CD ) A, " ).append("\n"); 
		query.append("         ( SELECT   A.VVD AS VVD, COUNT (C.BKG_NO) AS TTL_COUNT" ).append("\n"); 
		query.append("            FROM ( SELECT A.SLAN_CD AS SLAN_CD," ).append("\n"); 
		query.append("               A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               D.SVC_RQST_NO AS SSR_NO," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, C.VSL_ENG_NM, D.VVD_NM) AS VVD_NM," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, 'L', LLOYD_TP_CD) AS LLOYD_TP_CD," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, C.LLOYD_NO, D.LLOYD_NO) AS LLOYD_NO," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, A.VPS_ETA_DT, D.ETA_DT) AS ETA_DT," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, 'N', D.ANR_MSG_STS_CD) AS MSG_STS_CD," ).append("\n"); 
		query.append("               A.VPS_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("               VSK_VSL_SKD B," ).append("\n"); 
		query.append("               MDM_VSL_CNTR C," ).append("\n"); 
		query.append("               BKG_CSTMS_ANR_VVD D," ).append("\n"); 
		query.append("               BKG_HRD_CDG_CTNT E," ).append("\n"); 
		query.append("               BKG_CSTMS_CD_CONV_CTNT F" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VPS_ETA_DT >= TO_DATE (@[s_vps_eta_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("           AND A.VPS_ETA_DT < TO_DATE (@[e_vps_eta_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND A.VPS_PORT_CD = F.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND F.CNT_CD = 'BE'" ).append("\n"); 
		query.append("           AND F.CSTMS_DIV_ID  = 'EUR_BE_PORT_LIST'" ).append("\n"); 
		query.append("           AND F.CSTMS_DIV_ID_SEQ > 0" ).append("\n"); 
		query.append("           AND F.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${vvd} != '')" ).append("\n"); 
		query.append("				   AND A.VSL_CD        =  SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("				   AND A.SKD_VOY_NO    =  SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("				   AND A.SKD_DIR_CD    =  SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND E.HRD_CDG_ID = 'ANR_CSTMS_SLAN_CD'" ).append("\n"); 
		query.append("           AND A.SLAN_CD = E.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = DECODE (E.ATTR_CTNT2, 'A', A.SKD_DIR_CD, 'W')" ).append("\n"); 
		query.append("           AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${svc_rqst_no} != '') " ).append("\n"); 
		query.append("				   AND D.SVC_RQST_NO   = @[svc_rqst_no]" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("				   #if (${msg_sts_cd} != 'L') " ).append("\n"); 
		query.append("				   AND D.ANR_MSG_STS_CD = @[msg_sts_cd]" ).append("\n"); 
		query.append("				   #end " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND D.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("           AND D.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND D.SKD_DIR_CD(+) = A.SKD_DIR_CD ) A, BKG_VVD B, BKG_BOOKING C" ).append("\n"); 
		query.append("           WHERE B.VSL_CD = SUBSTR (A.VVD, 1, 4)" ).append("\n"); 
		query.append("             AND B.SKD_VOY_NO = SUBSTR (A.VVD, 5, 4)" ).append("\n"); 
		query.append("             AND B.SKD_DIR_CD = SUBSTR (A.VVD, 9, 1)" ).append("\n"); 
		query.append("             AND B.POD_CD = A.PORT_CD" ).append("\n"); 
		query.append("             AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("             AND C.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND C.BKG_CGO_TP_CD IN ('F', 'B')" ).append("\n"); 
		query.append("        GROUP BY A.VVD ) B, " ).append("\n"); 
		query.append("        (SELECT   A.VVD AS VVD, COUNT (B.BL_NO) AS TTL_COUNT" ).append("\n"); 
		query.append("            FROM ( SELECT A.SLAN_CD AS SLAN_CD," ).append("\n"); 
		query.append("               A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               D.SVC_RQST_NO AS SSR_NO," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, C.VSL_ENG_NM, D.VVD_NM) AS VVD_NM," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, 'L', LLOYD_TP_CD) AS LLOYD_TP_CD," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, C.LLOYD_NO, D.LLOYD_NO) AS LLOYD_NO," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, A.VPS_ETA_DT, D.ETA_DT) AS ETA_DT," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, 'N', D.ANR_MSG_STS_CD) AS MSG_STS_CD," ).append("\n"); 
		query.append("               A.VPS_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("               VSK_VSL_SKD B," ).append("\n"); 
		query.append("               MDM_VSL_CNTR C," ).append("\n"); 
		query.append("               BKG_CSTMS_ANR_VVD D," ).append("\n"); 
		query.append("               BKG_HRD_CDG_CTNT E," ).append("\n"); 
		query.append("               BKG_CSTMS_CD_CONV_CTNT F" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VPS_ETA_DT >= TO_DATE (@[s_vps_eta_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("           AND A.VPS_ETA_DT < TO_DATE (@[e_vps_eta_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A.VPS_PORT_CD = F.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND F.CNT_CD = 'BE'" ).append("\n"); 
		query.append("           AND F.CSTMS_DIV_ID  = 'EUR_BE_PORT_LIST'" ).append("\n"); 
		query.append("           AND F.CSTMS_DIV_ID_SEQ > 0" ).append("\n"); 
		query.append("           AND F.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${vvd} != '')" ).append("\n"); 
		query.append("				   AND A.VSL_CD        =  SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("				   AND A.SKD_VOY_NO    =  SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("				   AND A.SKD_DIR_CD    =  SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND E.HRD_CDG_ID = 'ANR_CSTMS_SLAN_CD'" ).append("\n"); 
		query.append("           AND A.SLAN_CD = E.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = DECODE (E.ATTR_CTNT2, 'A', A.SKD_DIR_CD, 'W')" ).append("\n"); 
		query.append("           AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${svc_rqst_no} != '') " ).append("\n"); 
		query.append("				   AND D.SVC_RQST_NO   = @[svc_rqst_no]" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("				   #if (${msg_sts_cd} != 'L') " ).append("\n"); 
		query.append("				   AND D.ANR_MSG_STS_CD = @[msg_sts_cd]" ).append("\n"); 
		query.append("				   #end " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND D.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("           AND D.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND D.SKD_DIR_CD(+) = A.SKD_DIR_CD ) A, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("           WHERE B.VSL_CD = SUBSTR (A.VVD, 1, 4)" ).append("\n"); 
		query.append("             AND B.SKD_VOY_NO = SUBSTR (A.VVD, 5, 4)" ).append("\n"); 
		query.append("             AND B.SKD_DIR_CD = SUBSTR (A.VVD, 9, 1)" ).append("\n"); 
		query.append("        GROUP BY A.VVD) C, " ).append("\n"); 
		query.append("        ( SELECT B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("--      NVL(B.EDI_SND_STS_CD, 'N') || NVL(B.EDI_RCV_STS_CD, 'N') AS EDI_STS," ).append("\n"); 
		query.append("               C.ATTR_CTNT2 AS EDI_STS, B.SND_DT AS SND_DT," ).append("\n"); 
		query.append("               B.EDI_SND_USR_ID AS SND_USR_ID, B.RCV_DT AS RCV_DT" ).append("\n"); 
		query.append("          FROM ( SELECT A.SLAN_CD AS SLAN_CD," ).append("\n"); 
		query.append("               A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               D.SVC_RQST_NO AS SSR_NO," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, C.VSL_ENG_NM, D.VVD_NM) AS VVD_NM," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, 'L', LLOYD_TP_CD) AS LLOYD_TP_CD," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, C.LLOYD_NO, D.LLOYD_NO) AS LLOYD_NO," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, A.VPS_ETA_DT, D.ETA_DT) AS ETA_DT," ).append("\n"); 
		query.append("               DECODE (D.VSL_CD, NULL, 'N', D.ANR_MSG_STS_CD) AS MSG_STS_CD," ).append("\n"); 
		query.append("               A.VPS_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("               VSK_VSL_SKD B," ).append("\n"); 
		query.append("               MDM_VSL_CNTR C," ).append("\n"); 
		query.append("               BKG_CSTMS_ANR_VVD D," ).append("\n"); 
		query.append("               BKG_HRD_CDG_CTNT E," ).append("\n"); 
		query.append("               BKG_CSTMS_CD_CONV_CTNT F" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VPS_ETA_DT >= TO_DATE (@[s_vps_eta_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("           AND A.VPS_ETA_DT < TO_DATE (@[e_vps_eta_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND A.VPS_PORT_CD = F.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND F.CNT_CD = 'BE'" ).append("\n"); 
		query.append("           AND F.CSTMS_DIV_ID  = 'EUR_BE_PORT_LIST'" ).append("\n"); 
		query.append("           AND F.CSTMS_DIV_ID_SEQ > 0" ).append("\n"); 
		query.append("           AND F.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${vvd} != '')" ).append("\n"); 
		query.append("				   AND A.VSL_CD        =  SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("				   AND A.SKD_VOY_NO    =  SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("				   AND A.SKD_DIR_CD    =  SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND E.HRD_CDG_ID = 'ANR_CSTMS_SLAN_CD'" ).append("\n"); 
		query.append("           AND A.SLAN_CD = E.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = DECODE (E.ATTR_CTNT2, 'A', A.SKD_DIR_CD, 'W')" ).append("\n"); 
		query.append("           AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${svc_rqst_no} != '') " ).append("\n"); 
		query.append("				   AND D.SVC_RQST_NO   = @[svc_rqst_no]" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("				   #if (${msg_sts_cd} != 'L') " ).append("\n"); 
		query.append("				   AND D.ANR_MSG_STS_CD = @[msg_sts_cd]" ).append("\n"); 
		query.append("				   #end " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND D.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("           AND D.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND D.SKD_DIR_CD(+) = A.SKD_DIR_CD ) A," ).append("\n"); 
		query.append("               BKG_CSTMS_ANR_EDI_HIS B," ).append("\n"); 
		query.append("               BKG_HRD_CDG_CTNT C" ).append("\n"); 
		query.append("         WHERE B.MSG_TP_CD = 'R'                                     -- CUSREP" ).append("\n"); 
		query.append("           AND B.ANR_DECL_NO = A.SSR_NO || LLOYD_TP_CD || LLOYD_NO" ).append("\n"); 
		query.append("           AND B.VSL_CD = SUBSTR (A.VVD, 1, 4)" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = SUBSTR (A.VVD, 5, 4)" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = SUBSTR (A.VVD, 9, 1)" ).append("\n"); 
		query.append("           AND B.REF_SEQ =" ).append("\n"); 
		query.append("                  (SELECT MAX (C.REF_SEQ)" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_ANR_EDI_HIS C" ).append("\n"); 
		query.append("                    WHERE C.MSG_TP_CD = B.MSG_TP_CD" ).append("\n"); 
		query.append("                      AND C.ANR_DECL_NO = B.ANR_DECL_NO" ).append("\n"); 
		query.append("                      AND C.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                      AND C.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND C.SKD_DIR_CD = B.SKD_DIR_CD)" ).append("\n"); 
		query.append("           AND C.HRD_CDG_ID(+) = 'ANR_CSTMS_EDI_STS_CD'" ).append("\n"); 
		query.append("           AND C.ATTR_CTNT1(+) =" ).append("\n"); 
		query.append("                     NVL (B.EDI_SND_STS_CD, 'N')" ).append("\n"); 
		query.append("                     || NVL (B.EDI_RCV_STS_CD, 'N') ) D" ).append("\n"); 
		query.append("   WHERE B.VVD(+) = A.VVD " ).append("\n"); 
		query.append("   AND C.VVD(+) = A.VVD " ).append("\n"); 
		query.append("   AND D.VVD(+) = A.VVD" ).append("\n"); 
		query.append("   #if (${bkg_count} != 'A') " ).append("\n"); 
		query.append("       #if (${bkg_count} == 'N')" ).append("\n"); 
		query.append("	       AND ( (B.TTL_COUNT > 0) AND (B.TTL_COUNT <> C.TTL_COUNT) )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${bkg_count} == 'F')" ).append("\n"); 
		query.append("	       AND ( (B.TTL_COUNT = 0) OR (B.TTL_COUNT = C.TTL_COUNT) )    " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("ORDER BY A.ETA_DT ASC" ).append("\n"); 

	}
}