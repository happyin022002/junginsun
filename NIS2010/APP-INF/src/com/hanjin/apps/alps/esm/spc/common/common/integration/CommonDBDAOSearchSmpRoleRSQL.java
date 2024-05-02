/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOSearchSmpRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSmpRoleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Login user의 Office Kind와 Level을 조회합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public CommonDBDAOSearchSmpRoleRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSmpRoleRSQL").append("\n"); 
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
		query.append("SELECT (SELECT DECODE(COUNT(*),0,'N','Y')" ).append("\n"); 
		query.append("          FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append("         WHERE USR_ID = T.USR_ID" ).append("\n"); 
		query.append("           AND USR_ROLE_CD = 'SPC01'" ).append("\n"); 
		query.append("       ) AS SPC_01_YN," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(*),0,'N','Y')" ).append("\n"); 
		query.append("          FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append("         WHERE USR_ID = T.USR_ID" ).append("\n"); 
		query.append("           AND USR_ROLE_CD = 'SPC08'" ).append("\n"); 
		query.append("       ) AS SPC_08_YN," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(*),0,'N','Y')" ).append("\n"); 
		query.append("          FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append("         WHERE USR_ID = T.USR_ID" ).append("\n"); 
		query.append("           AND USR_ROLE_CD = 'SPC09'" ).append("\n"); 
		query.append("       ) AS SPC_09_YN" ).append("\n"); 
		query.append("FROM COM_USER T" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 

	}
}