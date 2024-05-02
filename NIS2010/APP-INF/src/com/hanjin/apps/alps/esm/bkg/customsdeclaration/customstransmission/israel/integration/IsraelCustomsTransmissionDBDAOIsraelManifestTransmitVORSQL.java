/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOIsraelManifestTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.20 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOIsraelManifestTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IsraelManifestTransmitVO
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOIsraelManifestTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOIsraelManifestTransmitVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  ' ' AS BL_NO" ).append("\n"); 
		query.append(", ' ' AS VVD_CD" ).append("\n"); 
		query.append(", ' ' AS DT_SEQ" ).append("\n"); 
		query.append(", ' ' AS DT_CHECK" ).append("\n"); 
		query.append(", ' ' AS POL" ).append("\n"); 
		query.append(", ' ' AS POD" ).append("\n"); 
		query.append(", ' ' AS POL_CD" ).append("\n"); 
		query.append(", ' ' AS POD_CD" ).append("\n"); 
		query.append(", ' ' AS BPOL" ).append("\n"); 
		query.append(", ' ' AS BPOD" ).append("\n"); 
		query.append(", ' ' AS BPOL_CD" ).append("\n"); 
		query.append(", ' ' AS BPOD_CD" ).append("\n"); 
		query.append(", ' ' AS DEL" ).append("\n"); 
		query.append(", ' ' AS CT" ).append("\n"); 
		query.append(", ' ' AS LT" ).append("\n"); 
		query.append(", ' ' AS SH_NM" ).append("\n"); 
		query.append(", ' ' AS SH_AD" ).append("\n"); 
		query.append(", ' ' AS CNEE_NM" ).append("\n"); 
		query.append(", ' ' AS CNEE_AD" ).append("\n"); 
		query.append(", ' ' AS NTFY_NM" ).append("\n"); 
		query.append(", ' ' AS NTFY_AD" ).append("\n"); 
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
		query.append("FROM DUAL" ).append("\n"); 

	}
}