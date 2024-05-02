/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOUsaStowageManifestCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.12 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOUsaStowageManifestCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, UsaStowageManifestCondVO생성용
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOUsaStowageManifestCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration ").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOUsaStowageManifestCondRSQL").append("\n"); 
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
		query.append("'' vvd," ).append("\n"); 
		query.append("'' allerror," ).append("\n"); 
		query.append("'' lastpol," ).append("\n"); 
		query.append("'' pol," ).append("\n"); 
		query.append("'' pod," ).append("\n"); 
		query.append("'' cntropr," ).append("\n"); 
		query.append("'' excludeca," ).append("\n"); 
		query.append("'' pageno," ).append("\n"); 
		query.append("'' tmp1," ).append("\n"); 
		query.append("'' tmp2," ).append("\n"); 
		query.append("'' tmp3," ).append("\n"); 
		query.append("'' tmp4," ).append("\n"); 
		query.append("'' tmp5" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}