/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScOftAutoRatingDBDAORemoveAutoratingTempGroupLocationDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScOftAutoRatingDBDAORemoveAutoratingTempGroupLocationDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScOftAutoRatingDBDAORemoveAutoratingTempGroupLocationDSQL
	  * </pre>
	  */
	public ScOftAutoRatingDBDAORemoveAutoratingTempGroupLocationDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : ScOftAutoRatingDBDAORemoveAutoratingTempGroupLocationDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_AUTO_RT_GRP_LOC_TMP" ).append("\n"); 

	}
}