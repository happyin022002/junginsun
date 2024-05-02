/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOGetUserLocInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.30 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOGetUserLocInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * user 별 office code의 해당 지역정보(location information)
	  * </pre>
	  */
	public CommonDBDAOGetUserLocInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOGetUserLocInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("${columnName}" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- 임시로 데이타 조회를 방해(라이브에서는 삭제해야함)" ).append("\n"); 
		query.append("--	AND 1 = 0" ).append("\n"); 

	}
}