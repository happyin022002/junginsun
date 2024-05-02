/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScOftAutoRatingDBDAORemoveAutoratingTempDestARBDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScOftAutoRatingDBDAORemoveAutoratingTempDestARBDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_AUTO_RT_DEST_ARB_TMP
	  * </pre>
	  */
	public ScOftAutoRatingDBDAORemoveAutoratingTempDestARBDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : ScOftAutoRatingDBDAORemoveAutoratingTempDestARBDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_AUTO_RT_DEST_ARB_TMP" ).append("\n"); 

	}
}