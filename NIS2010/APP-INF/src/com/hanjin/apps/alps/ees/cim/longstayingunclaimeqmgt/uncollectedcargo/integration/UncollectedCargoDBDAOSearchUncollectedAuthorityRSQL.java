/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedAuthorityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOSearchUncollectedAuthorityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Uncollected Creation 권한조회
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedAuthorityRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedAuthorityRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN CNT = 0 THEN 0  -- 권한등록되지 않은 사용자" ).append("\n"); 
		query.append("            WHEN CNT = 1 THEN CASE WHEN (SELECT COUNT(1) CNT FROM CIM_UC_CGO_AUTH WHERE UC_AUTH_USR_ID = AA.USR_ID AND UC_AUTH_OFC_CD ='SELCTY' ) = 1 THEN 2 ELSE 1 END  -- 권한등록된 사람 구분" ).append("\n"); 
		query.append("       END AS ISAUTHORITY" ).append("\n"); 
		query.append("    , (SELECT UC_AUTH_OFC_CD  FROM CIM_UC_CGO_AUTH WHERE UC_AUTH_USR_ID = AA.USR_ID group by UC_AUTH_OFC_CD ) AS UC_AUTH_OFC_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("           , @[usr_id] AS USR_ID" ).append("\n"); 
		query.append("       FROM CIM_UC_CGO_AUTH" ).append("\n"); 
		query.append("       WHERE UC_AUTH_USR_ID = @[usr_id] " ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 

	}
}