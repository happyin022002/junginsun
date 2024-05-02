/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchContiCdComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchContiCdComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.04.11 김종준 [CHM-201110033-01] ALPS/SPC의 TS booking status 기능보완 요청 
	  * - ContiCd List를 조회
	  * </pre>
	  */
	public CommonDBDAOSearchContiCdComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchContiCdComboListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("CONTI_CD ," ).append("\n"); 
		query.append("CONTI_NM " ).append("\n"); 
		query.append("FROM MDM_CONTINENT" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND CONTI_CD NOT IN ('X', 'Y')  ORDER BY 1" ).append("\n"); 

	}
}