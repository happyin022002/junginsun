/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAOCheckComUserRoleMtchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOCheckComUserRoleMtchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check User Role. 'xtn_phn_no' parameter (ComUserVO parameter) is set to check the user role code.
	  * </pre>
	  */
	public PRICommonDBDAOCheckComUserRoleMtchRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtn_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOCheckComUserRoleMtchRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN NVL(COUNT(*),0) <= 0  THEN 'N' ELSE 'Y' END ISROLE" ).append("\n"); 
		query.append("  FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append(" WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#if (${xtn_phn_no} != '')" ).append("\n"); 
		query.append("   AND USR_ROLE_CD = (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                        FROM PRI_PARA_CD_DTL" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = @[xtn_phn_no])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND USR_ROLE_CD = (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                        FROM PRI_PARA_CD_DTL" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'PRICD0002')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}