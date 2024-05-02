/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOEur24SendDtlHistoryOBVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.08.05 김경섭
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

public class Eur24CustomsTransmissionDBDAOEur24SendDtlHistoryOBVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOEur24SendDtlHistoryOBVORSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOEur24SendDtlHistoryOBVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOEur24SendDtlHistoryOBVORSQL").append("\n"); 
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
		query.append("	'' FORM1_VVD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}