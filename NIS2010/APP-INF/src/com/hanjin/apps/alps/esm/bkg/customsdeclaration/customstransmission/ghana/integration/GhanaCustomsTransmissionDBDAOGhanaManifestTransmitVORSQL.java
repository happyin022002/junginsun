/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GhanaCustomsTransmissionDBDAOGhanaManifestTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.04.23 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GhanaCustomsTransmissionDBDAOGhanaManifestTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GhanaManifestTransmitVO 생성 쿼리
	  * </pre>
	  */
	public GhanaCustomsTransmissionDBDAOGhanaManifestTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.integration ").append("\n"); 
		query.append("FileName : GhanaCustomsTransmissionDBDAOGhanaManifestTransmitVORSQL").append("\n"); 
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
		query.append("SELECT '' bkg_no" ).append("\n"); 
		query.append("	 , '' bl_no" ).append("\n"); 
		query.append("	 , '' vvd_cd" ).append("\n"); 
		query.append("	 , '' pol_cd" ).append("\n"); 
		query.append("	 , '' pod_cd" ).append("\n"); 
		query.append("	 , '' mf_snd_dt" ).append("\n"); 
		query.append("	 , '' user_id" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}