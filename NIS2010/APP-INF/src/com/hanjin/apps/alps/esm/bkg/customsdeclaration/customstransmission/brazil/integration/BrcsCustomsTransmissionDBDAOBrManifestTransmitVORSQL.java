/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOBrManifestTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOBrManifestTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BrManifestTransmitVO 생성을 위해서
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOBrManifestTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOBrManifestTransmitVORSQL").append("\n"); 
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
		query.append("''POD_CD" ).append("\n"); 
		query.append(",''COMP_ID" ).append("\n"); 
		query.append(",''POL_CD" ).append("\n"); 
		query.append(",''BKG_NO" ).append("\n"); 
		query.append(",''VVD_CD" ).append("\n"); 
		query.append(",''CNTR_NO" ).append("\n"); 
		query.append(",''HIDDEN_RATE_TYPE" ).append("\n"); 
		query.append(",''HIDE_CHECK" ).append("\n"); 
		query.append(",''BL_NO" ).append("\n"); 
		query.append(",''EDI_SEND_ID" ).append("\n"); 
		query.append(",''SEARCH_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}