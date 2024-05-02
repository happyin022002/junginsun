/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchEur24ItarySeq2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.03.18 김경섭
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

public class Eur24CustomsTransmissionDBDAOSearchEur24ItarySeq2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchEur24ItarySeq2RSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchEur24ItarySeq2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchEur24ItarySeq2RSQL").append("\n"); 
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
		query.append("SELECT BKG_CSTMS_ADV_EUR_IT_SEQ.NEXTVAL AS IT_SEQ_N FROM DUAL " ).append("\n"); 

	}
}