/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchEur24EdiRcvKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.30 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchEur24EdiRcvKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchEur24EdiRcvKeyRSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchEur24EdiRcvKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchEur24EdiRcvKeyRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(SYSDATE,'YYYYMMDD') AS EDI_RCV_DT," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_EUR_RCV_SEQ.NEXTVAL AS EDI_RCV_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}