/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchIsraelEdiRcvKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.20 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOsearchIsraelEdiRcvKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIsraelEdiRcvKey
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchIsraelEdiRcvKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration ").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchIsraelEdiRcvKeyRSQL").append("\n"); 
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
		query.append("      TO_CHAR(SYSDATE,'YYYYMMDD') AS EDI_RCV_DT," ).append("\n"); 
		query.append("      BKG_CSTMS_ADV_EUR_RCV_SEQ.NEXTVAL AS EDI_RCV_SEQ " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}