/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEu24ManifestTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.12.16 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOEu24ManifestTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOEu24ManifestTransmitVORSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEu24ManifestTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEu24ManifestTransmitVORSQL").append("\n"); 
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
		query.append("/* Eu24ManifestTransmitVO ManifestListDetailVO " ).append("\n"); 
		query.append("import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  ' ' AS BL_NO" ).append("\n"); 
		query.append(", ' ' AS DT_SEQ" ).append("\n"); 
		query.append(", ' ' AS DT_CHECK" ).append("\n"); 
		query.append(", ' ' AS POL" ).append("\n"); 
		query.append(", ' ' AS POD" ).append("\n"); 
		query.append(", ' ' AS BPOL" ).append("\n"); 
		query.append(", ' ' AS BPOD" ).append("\n"); 
		query.append(", ' ' AS DEL" ).append("\n"); 
		query.append(", ' ' AS CT" ).append("\n"); 
		query.append(", ' ' AS LT" ).append("\n"); 
		query.append(", ' ' AS SH_NM" ).append("\n"); 
		query.append(", ' ' AS SH_AD" ).append("\n"); 
		query.append(", ' ' AS SH_CT" ).append("\n"); 
		query.append(", ' ' AS SH_CN" ).append("\n"); 
		query.append(", ' ' AS SH_ZIP" ).append("\n"); 
		query.append(", ' ' AS SH_STR " ).append("\n"); 
		query.append(", ' ' AS SH_EORI" ).append("\n"); 
		query.append(", ' ' AS CNEE_NM" ).append("\n"); 
		query.append(", ' ' AS CNEE_AD" ).append("\n"); 
		query.append(", ' ' AS CNEE_CT" ).append("\n"); 
		query.append(", ' ' AS CNEE_CN" ).append("\n"); 
		query.append(", ' ' AS CNEE_ZIP" ).append("\n"); 
		query.append(", ' ' AS CNEE_STR " ).append("\n"); 
		query.append(", ' ' AS CNEE_EORI" ).append("\n"); 
		query.append(", ' ' AS NTFY_NM" ).append("\n"); 
		query.append(", ' ' AS NTFY_AD" ).append("\n"); 
		query.append(", ' ' AS NTFY_CT" ).append("\n"); 
		query.append(", ' ' AS NTFY_CN" ).append("\n"); 
		query.append(", ' ' AS NTFY_ZIP" ).append("\n"); 
		query.append(", ' ' AS NTFY_STR " ).append("\n"); 
		query.append(", ' ' AS NTFY_EORI" ).append("\n"); 
		query.append(", ' ' AS BL_PK" ).append("\n"); 
		query.append(", ' ' AS BL_WT" ).append("\n"); 
		query.append(", ' ' AS BL_MS" ).append("\n"); 
		query.append(", ' ' AS CNTR_CNTR_NO" ).append("\n"); 
		query.append(", ' ' AS CNTR_SEAL" ).append("\n"); 
		query.append(", ' ' AS CNTR_PK" ).append("\n"); 
		query.append(", ' ' AS CNTR_WT" ).append("\n"); 
		query.append(", ' ' AS CNTR_MS" ).append("\n"); 
		query.append(", ' ' AS CM_PK" ).append("\n"); 
		query.append(", ' ' AS CM_WT" ).append("\n"); 
		query.append(", ' ' AS CM_MS" ).append("\n"); 
		query.append(", ' ' AS CM_DS" ).append("\n"); 
		query.append(", ' ' AS CM_MK" ).append("\n"); 
		query.append(", ' ' AS CM_HTS" ).append("\n"); 
		query.append(", ' ' AS EDI_SENT" ).append("\n"); 
		query.append(", ' ' AS EDI_TIME" ).append("\n"); 
		query.append(", ' ' AS EDI_MRN" ).append("\n"); 
		query.append(", ' ' AS EDI_REF_NO" ).append("\n"); 
		query.append(", ' ' AS VPS_ETD_DT" ).append("\n"); 
		query.append(", ' ' AS EU_1ST_PORT" ).append("\n"); 
		query.append(", ' ' AS VPS_ETA_DT" ).append("\n"); 
		query.append(", ' ' AS TTL_BL" ).append("\n"); 
		query.append(", ' ' AS TTL_ERR_BL" ).append("\n"); 
		query.append(", ' ' AS TTL_CNTR" ).append("\n"); 
		query.append(", ' ' AS VSL_CD" ).append("\n"); 
		query.append(", ' ' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", ' ' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", ' ' AS CNTR_LIST" ).append("\n"); 
		query.append(", ' ' AS CRE_USR_ID" ).append("\n"); 
		query.append(", ' ' AS P_ORI_AMD_CD" ).append("\n"); 
		query.append(", ' ' AS P_BL_NO" ).append("\n"); 
		query.append(", ' ' AS P_SEND_YN" ).append("\n"); 
		query.append(", ' ' AS P_TYPE" ).append("\n"); 
		query.append(", ' ' AS prtPgmNo -- 수기로 대소문자 확인해줘야 함" ).append("\n"); 
		query.append("-- 20131213 일치" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}