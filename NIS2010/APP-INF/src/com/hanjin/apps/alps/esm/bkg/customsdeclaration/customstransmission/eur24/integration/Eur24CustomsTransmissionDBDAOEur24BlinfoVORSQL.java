/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOEur24BlinfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.05 
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

public class Eur24CustomsTransmissionDBDAOEur24BlinfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOEur24BlinfoVORSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOEur24BlinfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOEur24BlinfoVORSQL").append("\n"); 
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
		query.append("/* Eur24BlinfoVO */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  ' ' AS AEO_STATUS" ).append("\n"); 
		query.append(", ' ' AS B" ).append("\n"); 
		query.append(", ' ' AS BKG_POD_CD" ).append("\n"); 
		query.append(", ' ' AS BKG_POL_CD" ).append("\n"); 
		query.append(", ' ' AS BL_NO" ).append("\n"); 
		query.append(", ' ' AS BL_TRANS_IDENTITY" ).append("\n"); 
		query.append(", ' ' AS BL_TRANS_NATION" ).append("\n"); 
		query.append(", ' ' AS BLDEL" ).append("\n"); 
		query.append(", ' ' AS BLMEA" ).append("\n"); 
		query.append(", ' ' AS BLMEAU" ).append("\n"); 
		query.append(", ' ' AS BLNBR" ).append("\n"); 
		query.append(", ' ' AS BLPKG" ).append("\n"); 
		query.append(", ' ' AS BLPKGU" ).append("\n"); 
		query.append(", ' ' AS BLPOD" ).append("\n"); 
		query.append(", ' ' AS BLPOL" ).append("\n"); 
		query.append(", ' ' AS C" ).append("\n"); 
		query.append(", ' ' AS CMDT_CD" ).append("\n"); 
		query.append(", ' ' AS COMMODITY" ).append("\n"); 
		query.append(", ' ' AS CONSIGN_PLACE" ).append("\n"); 
		query.append(", ' ' AS CRE_DT" ).append("\n"); 
		query.append(", ' ' AS CRE_USR_ID" ).append("\n"); 
		query.append(", ' ' AS CSTMS_DECL_DT" ).append("\n"); 
		query.append(", ' ' AS CSTMS_PORT_CD" ).append("\n"); 
		query.append(", ' ' AS CUSTOMS_STATUS_CD" ).append("\n"); 
		query.append(", ' ' AS DECL_LOC_CD" ).append("\n"); 
		query.append(", ' ' AS DECLARE_DATE" ).append("\n"); 
		query.append(", ' ' AS DECLARE_LOC" ).append("\n"); 
		query.append(", ' ' AS DECLARE_LOC_NAME" ).append("\n"); 
		query.append(", ' ' AS DEL_CD" ).append("\n"); 
		query.append(", ' ' AS DEL_FULLNAME" ).append("\n"); 
		query.append(", ' ' AS DEL_NM" ).append("\n"); 
		query.append(", ' ' AS DESCS" ).append("\n"); 
		query.append(", ' ' AS IT_FILE_SEQ" ).append("\n"); 
		query.append(", ' ' AS IT_SEQ" ).append("\n"); 
		query.append(", ' ' AS IT_SEQ_N" ).append("\n"); 
		query.append(", ' ' AS LOAD_LOC_CD" ).append("\n"); 
		query.append(", ' ' AS LOAD_LOC_ETD" ).append("\n"); 
		query.append(", ' ' AS LOAD_LOC_NAME" ).append("\n"); 
		query.append(", ' ' AS LOAD_OFC_CD" ).append("\n"); 
		query.append(", ' ' AS MARKNO" ).append("\n"); 
		query.append(", ' ' AS MEAS_QTY" ).append("\n"); 
		query.append(", ' ' AS MEAS_UT_CD" ).append("\n"); 
		query.append(", ' ' AS MRN" ).append("\n"); 
		query.append(", ' ' AS MSG_ID" ).append("\n"); 
		query.append(", ' ' AS MSG_ID_CD" ).append("\n"); 
		query.append(", ' ' AS NEXT_LOC_CD" ).append("\n"); 
		query.append(", ' ' AS NEXT_LOC_ETA" ).append("\n"); 
		query.append(", ' ' AS NEXT_LOC_NAME" ).append("\n"); 
		query.append(", ' ' AS NEXT_OFC_CD" ).append("\n"); 
		query.append(", ' ' AS PART_SHIPMENT" ).append("\n"); 
		query.append(", ' ' AS PAYMENT_CD" ).append("\n"); 
		query.append(", ' ' AS PCK_QTY" ).append("\n"); 
		query.append(", ' ' AS PCK_TP_CD" ).append("\n"); 
		query.append(", ' ' AS POD_CD" ).append("\n"); 
		query.append(", ' ' AS POD_FULLNAME" ).append("\n"); 
		query.append(", ' ' AS POD_OFC_CD" ).append("\n"); 
		query.append(", ' ' AS POD_NM" ).append("\n"); 
		query.append(", ' ' AS POL_CD" ).append("\n"); 
		query.append(", ' ' AS POL_FULLNAME" ).append("\n"); 
		query.append(", ' ' AS POL_NM" ).append("\n"); 
		query.append(", ' ' AS PREV_LOC_CD" ).append("\n"); 
		query.append(", ' ' AS PRN" ).append("\n"); 
		query.append(", ' ' AS PRN_SEQ" ).append("\n"); 
		query.append(", ' ' AS PROCESS_INFO" ).append("\n"); 
		query.append(", ' ' AS PROCESS_TYPE" ).append("\n"); 
		query.append(", ' ' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", ' ' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", ' ' AS SPECIAL_REMARKS" ).append("\n"); 
		query.append(", ' ' AS TRANS_DOC_NAME" ).append("\n"); 
		query.append(", ' ' AS TRANS_DOC_NO" ).append("\n"); 
		query.append(", ' ' AS TRANS_IDENTITY" ).append("\n"); 
		query.append(", ' ' AS TRANS_NATION" ).append("\n"); 
		query.append(", ' ' AS TRSP_DOC_NO" ).append("\n"); 
		query.append(", ' ' AS UNLOAD_LOC_CD" ).append("\n"); 
		query.append(", ' ' AS UNLOAD_LOC_ETA" ).append("\n"); 
		query.append(", ' ' AS UNLOAD_LOC_NAME" ).append("\n"); 
		query.append(", ' ' AS UNLOAD_OFC_CD" ).append("\n"); 
		query.append(", ' ' AS UPD_DT" ).append("\n"); 
		query.append(", ' ' AS UPD_USR_ID" ).append("\n"); 
		query.append(", ' ' AS VSL_CD" ).append("\n"); 
		query.append(", ' ' AS VSL_NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS SVC_ENS_YN" ).append("\n"); 
		query.append(", ' ' AS SVC_AN_YN" ).append("\n"); 
		query.append(", ' ' AS SVC_DR_YN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS CT_NAME" ).append("\n"); 
		query.append(", ' ' AS CT_POSITION" ).append("\n"); 
		query.append(", ' ' AS CT_EMAIL" ).append("\n"); 
		query.append(", ' ' AS CT_TEL" ).append("\n"); 
		query.append(", ' ' AS CT_FAX" ).append("\n"); 
		query.append(", ' ' AS ACT_WGT" ).append("\n"); 
		query.append(", ' ' AS WGT_UT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS UNLOAD_LOC_ETA_HIS" ).append("\n"); 
		query.append(", ' ' AS ORIGINAL_DATE" ).append("\n"); 
		query.append(", ' ' AS CUSTOMS_REF" ).append("\n"); 
		query.append(", ' ' AS MVMT_REF_NO" ).append("\n"); 
		query.append(", ' ' AS BL_ENTRY_LOC" ).append("\n"); 
		query.append(", ' ' AS TRSM_VAL" ).append("\n"); 
		query.append("-- 131205 모두 일치" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}