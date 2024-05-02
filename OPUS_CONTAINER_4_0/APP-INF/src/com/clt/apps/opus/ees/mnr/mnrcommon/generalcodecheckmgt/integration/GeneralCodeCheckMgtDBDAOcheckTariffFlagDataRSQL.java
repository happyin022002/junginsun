/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcheckTariffFlagDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOcheckTariffFlagDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOcheckTariffFlagDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOcheckTariffFlagDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_CD_DESC CODE" ).append("\n"); 
		query.append("  FROM MNR_GEN_CD" ).append("\n"); 
		query.append(" WHERE PRNT_CD_ID ='CD00096'" ).append("\n"); 
		query.append("   AND MNR_CD_ID='TC' " ).append("\n"); 

	}
}