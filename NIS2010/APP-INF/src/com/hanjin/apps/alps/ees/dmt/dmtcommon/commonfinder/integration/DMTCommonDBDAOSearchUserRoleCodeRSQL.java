/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DMTCommonDBDAOSearchUserRoleCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.24
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.07.24 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchUserRoleCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자의 DMT User Role Code 정보를 확인한다.
	  * </pre>
	  */
	public DMTCommonDBDAOSearchUserRoleCodeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchUserRoleCodeRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(*), 0, 'N', 'Y') AS USR_AUTH" ).append("\n"); 
		query.append("FROM    DMT_USR_ROLE_MTCH" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("#if (${prg_no} == 'EES_DMT_4001')" ).append("\n"); 
		query.append("AND     USR_ROLE_CD IN ('DMT01', 'DMT02')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     USR_ROLE_CD IN ('DMT01', 'DMT02', 'DMT03', 'DMT04')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}