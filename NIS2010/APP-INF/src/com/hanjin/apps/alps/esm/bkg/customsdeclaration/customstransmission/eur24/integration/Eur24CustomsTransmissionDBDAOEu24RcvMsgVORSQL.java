/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOEu24RcvMsgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.21 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOEu24RcvMsgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOEu24RcvMsgVORSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOEu24RcvMsgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOEu24RcvMsgVORSQL").append("\n"); 
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
		query.append("/* Eu24RcvMsgVO */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  'EDI_RCV_DT'              AS EDI_RCV_DT            " ).append("\n"); 
		query.append(", 'EDI_RCV_SEQ'             AS EDI_RCV_SEQ           " ).append("\n"); 
		query.append(", 'EUR_EDI_MSG_TP_ID'   AS EUR_EDI_MSG_TP_ID " ).append("\n"); 
		query.append(", 'EDI_SND_MSG_NM'      AS EDI_SND_MSG_NM    " ).append("\n"); 
		query.append(", 'MSG_RCV_NO'          AS MSG_RCV_NO        " ).append("\n"); 
		query.append(", 'VSL_CD'              AS VSL_CD            " ).append("\n"); 
		query.append(", 'SKD_VOY_NO'          AS SKD_VOY_NO        " ).append("\n"); 
		query.append(", 'SKD_DIR_CD'          AS SKD_DIR_CD        " ).append("\n"); 
		query.append(", 'CSTMS_PORT_CD'       AS CSTMS_PORT_CD     " ).append("\n"); 
		query.append(", 'BL_NO'               AS BL_NO             " ).append("\n"); 
		query.append(", 'ACK_KND_ID'          AS ACK_KND_ID        " ).append("\n"); 
		query.append(", 'ACK_RCV_STS_CD'      AS ACK_RCV_STS_CD    " ).append("\n"); 
		query.append(", 'EUR_CSTMS_ACK_CD'    AS EUR_CSTMS_ACK_CD  " ).append("\n"); 
		query.append(", 'ACK_DT'              AS ACK_DT            " ).append("\n"); 
		query.append(", 'APRO_DT'             AS APRO_DT           " ).append("\n"); 
		query.append(", 'MSG_ACPT_REF_NO'     AS MSG_ACPT_REF_NO   " ).append("\n"); 
		query.append(", 'MVMT_REF_NO'         AS MVMT_REF_NO       " ).append("\n"); 
		query.append(", 'EUR_CSTMS_RJCT_CD'   AS EUR_CSTMS_RJCT_CD " ).append("\n"); 
		query.append(", 'RJCT_RSN_RMK'        AS RJCT_RSN_RMK      " ).append("\n"); 
		query.append(", 'RJCT_DT'             AS RJCT_DT           " ).append("\n"); 
		query.append(", 'CRE_USR_ID'          AS CRE_USR_ID        " ).append("\n"); 
		query.append(", 'CRE_DT'              AS CRE_DT            " ).append("\n"); 
		query.append(", 'UPD_USR_ID'          AS UPD_USR_ID        " ).append("\n"); 
		query.append(", 'UPD_DT'              AS UPD_DT            " ).append("\n"); 
		query.append(", 'EDI_RCV_MSG_CTNT'    AS EDI_RCV_MSG_CTNT  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'RCV_LOG_ERR_SEQ'   AS RCV_LOG_ERR_SEQ" ).append("\n"); 
		query.append(", 'CSTMS_ERR_ID'      AS CSTMS_ERR_ID" ).append("\n"); 
		query.append(", 'CSTMS_ERR_MSG'     AS CSTMS_ERR_MSG" ).append("\n"); 
		query.append(", 'CSTMS_ERR_REF_NO1' AS CSTMS_ERR_REF_NO1" ).append("\n"); 
		query.append(", 'CSTMS_ERR_REF_NO2' AS CSTMS_ERR_REF_NO2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' AS cnt_cd" ).append("\n"); 
		query.append(", '' AS edi_msg_tp_id " ).append("\n"); 
		query.append(", '' AS eur_cstms_ack_cd" ).append("\n"); 
		query.append(", '' AS rcv_tms" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}