/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOMxManifestListByVvdCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.24
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.24 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOMxManifestListByVvdCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, MxManifestListByVvdCondVO 생성용.
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOMxManifestListByVvdCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mex.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOMxManifestListByVvdCondRSQL").append("\n"); 
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
		query.append("SELECT '' VVD, '' POD_CD, '' POL_CD, '' search_flg," ).append("\n"); 
		query.append("'' TMP1, '' TMP2, '' TMP3" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}