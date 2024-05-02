/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchOffHireVerifyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.10.12 최종혁
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

public class SingleTransportationSOManageDBDAOSearchOffHireVerifyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR 직반납을 위해 OffHireVerify check
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchOffHireVerifyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchOffHireVerifyRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO, OFFH_YD_CD" ).append("\n"); 
		query.append("FROM LSE_AVAL_OFFH" ).append("\n"); 
		query.append("WHERE OFFH_DUE_DT > TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND OFFH_STS_CD IN ('R','C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arr_cntrno.size() > 0)" ).append("\n"); 
		query.append("AND CNTR_NO in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_cntrno})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_cntrno.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}