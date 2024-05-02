/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOSitProCntrSealListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.17
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.12.17 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOSitProCntrSealListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SitProCntrSealListVO
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOSitProCntrSealListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOSitProCntrSealListVORSQL").append("\n"); 
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
		query.append("  ' ' AS SEAL_SEQ " ).append("\n"); 
		query.append(", ' ' AS SEAL_NBR" ).append("\n"); 
		query.append(", ' ' AS SEAL_NO_SEQ" ).append("\n"); 
		query.append(", ' ' AS SEAL_NO" ).append("\n"); 
		query.append(", ' ' AS SEAL_PTY_TP_CD" ).append("\n"); 
		query.append(", ' ' AS SEAL_PTY_NM" ).append("\n"); 
		query.append(", ' ' AS SEAL_KND_CD" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}