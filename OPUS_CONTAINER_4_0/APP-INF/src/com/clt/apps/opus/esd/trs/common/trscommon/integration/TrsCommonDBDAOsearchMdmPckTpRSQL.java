/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsCommonDBDAOsearchMdmPckTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.26
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.12.26 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOsearchMdmPckTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select Package Code from MDM_PCK_TP table
	  * </pre>
	  */
	public TrsCommonDBDAOsearchMdmPckTpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.trscommon.integration ").append("\n"); 
		query.append("FileName : TrsCommonDBDAOsearchMdmPckTpRSQL").append("\n"); 
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
		query.append("SELECT PCK_CD" ).append("\n"); 
		query.append("  FROM MDM_PCK_TP" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY PCK_CD" ).append("\n"); 

	}
}