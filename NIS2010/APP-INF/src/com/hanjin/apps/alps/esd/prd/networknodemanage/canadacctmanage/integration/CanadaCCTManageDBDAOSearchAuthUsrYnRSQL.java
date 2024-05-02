/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CanadaCCTManageDBDAOSearchAuthUsrYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCCTManageDBDAOSearchAuthUsrYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search User Auth Check
	  * </pre>
	  */
	public CanadaCCTManageDBDAOSearchAuthUsrYnRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration").append("\n"); 
		query.append("FileName : CanadaCCTManageDBDAOSearchAuthUsrYnRSQL").append("\n"); 
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
		query.append("SELECT DECODE (COUNT (*), 0, 'N', 'Y') AS auth_usr_yn" ).append("\n"); 
		query.append("  FROM COM_USER A, COM_USR_ROLE B, COM_USR_ROLE_MTCH C" ).append("\n"); 
		query.append(" WHERE     1 = 1" ).append("\n"); 
		query.append("       AND A.USR_ID = C.USR_ID" ).append("\n"); 
		query.append("       AND B.USR_ROLE_CD = C.USR_ROLE_CD" ).append("\n"); 
		query.append("       AND C.USR_ROLE_CD = 'PRD09'" ).append("\n"); 
		query.append("       AND DECODE (A.USE_FLG, NULL, 'N', A.USE_FLG) = 'Y'" ).append("\n"); 
		query.append("       --AND A.USR_AUTH_TP_CD IN ('A', 'S')" ).append("\n"); 
		query.append("       AND A.USR_ID = @[usr_id]" ).append("\n"); 

	}
}