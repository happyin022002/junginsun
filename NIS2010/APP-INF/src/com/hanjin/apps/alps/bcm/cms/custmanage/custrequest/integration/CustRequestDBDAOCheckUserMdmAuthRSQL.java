/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustRequestDBDAOCheckUserMdmAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRequestDBDAOCheckUserMdmAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * User MDM Auth check
	  * </pre>
	  */
	public CustRequestDBDAOCheckUserMdmAuthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration ").append("\n"); 
		query.append("FileName : CustRequestDBDAOCheckUserMdmAuthRSQL").append("\n"); 
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
		query.append("SELECT NVL(CU.MDM_AUTH_FLG,'N') MDM_AUTH_FLG" ).append("\n"); 
		query.append("FROM COM_USER CU" ).append("\n"); 
		query.append("WHERE CU.USR_ID = @[usr_id]" ).append("\n"); 

	}
}