/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOEurManifestListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.28
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.28 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOEurManifestListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManifestListCondVO를 상속받아서 EurManifestListCondVO에 넣어준다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOEurManifestListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOEurManifestListCondVORSQL").append("\n"); 
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
		query.append("       '' VVD_CD" ).append("\n"); 
		query.append("     , '' POD_CD" ).append("\n"); 
		query.append("     , '' POL_CD" ).append("\n"); 
		query.append("     , '' BL_NO" ).append("\n"); 
		query.append("     , '' RECEIVER_ID" ).append("\n"); 
		query.append("     , '' CHECK_FROB_SEARCH" ).append("\n"); 
		query.append("     , '' POD_YD_CD" ).append("\n"); 
		query.append("     , '' POL_YD_CD" ).append("\n"); 
		query.append("     , '' MODE_TYPE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}