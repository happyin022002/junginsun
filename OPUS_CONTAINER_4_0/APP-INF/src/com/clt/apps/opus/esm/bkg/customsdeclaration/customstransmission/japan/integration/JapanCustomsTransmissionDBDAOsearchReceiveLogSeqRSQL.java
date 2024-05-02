/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchReceiveLogSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchReceiveLogSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchReceiveLogSeq
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchReceiveLogSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchReceiveLogSeqRSQL").append("\n"); 
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
		query.append("SELECT TO_NUMBER(SUBSTR(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL, '000009'), -3))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}