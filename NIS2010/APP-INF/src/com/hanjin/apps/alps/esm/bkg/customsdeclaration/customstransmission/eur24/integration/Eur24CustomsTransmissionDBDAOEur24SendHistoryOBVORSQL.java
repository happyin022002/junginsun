/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOEur24SendHistoryOBVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.08.05 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOEur24SendHistoryOBVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOEur24SendHistoryOBVORSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOEur24SendHistoryOBVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOEur24SendHistoryOBVORSQL").append("\n"); 
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
		query.append("/* Eur24SendHistoryOB	VO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   MSG_SND_NO ," ).append("\n"); 
		query.append("   EUR_EDI_MSG_TP_ID,      SND_DT,        SND_GDT,       SND_USR_ID,    MSG_FUNC_ID," ).append("\n"); 
		query.append("   VSL_CD,                 SKD_VOY_NO,    SKD_DIR_CD,    BL_NO,         CSTMS_PORT_CD,    EDI_SND_MSG_CTNT," ).append("\n"); 
		query.append("   CRE_USR_ID,             CRE_DT,        UPD_USR_ID,    UPD_DT," ).append("\n"); 
		query.append("   '' AS SND_OFC_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("WHERE ROWNUM  = 1" ).append("\n"); 

	}
}