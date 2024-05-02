/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchContiCodeCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.03.26 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchContiCodeCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Control Office를 기준으로 Conti code를 체크한다.
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchContiCodeCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchContiCodeCheckRSQL").append("\n"); 
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
		query.append("SELECT CONTI_CD, COUNT(DISTINCT CONTI_CD) CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append(",LEVEL" ).append("\n"); 
		query.append(",SYS_CONNECT_BY_PATH(A.OFC_CD, '/') FULL_PATH" ).append("\n"); 
		query.append(",(SELECT Y.CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION X," ).append("\n"); 
		query.append("MDM_LOCATION     Y" ).append("\n"); 
		query.append("WHERE X.LOC_CD   = Y.LOC_CD" ).append("\n"); 
		query.append("AND X.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append(") CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("WHERE A.OFC_KND_CD = 2" ).append("\n"); 
		query.append("START WITH A.OFC_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_so_office})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_so_office.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CONNECT BY A.OFC_CD = PRIOR A.PRNT_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CONTI_CD" ).append("\n"); 

	}
}