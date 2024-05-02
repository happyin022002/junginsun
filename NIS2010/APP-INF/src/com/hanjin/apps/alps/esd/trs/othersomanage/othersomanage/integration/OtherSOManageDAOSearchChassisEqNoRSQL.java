/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OtherSOManageDAOSearchChassisEqNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDAOSearchChassisEqNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chasis정보를 조회한다.
	  * </pre>
	  */
	public OtherSOManageDAOSearchChassisEqNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDAOSearchChassisEqNoRSQL").append("\n"); 
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
		query.append("EQ_NO" ).append("\n"); 
		query.append(", EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("AND EQ_NO in (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( ${key} in ${eqNo})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($velocityCount < $eqNo.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND EQ_KND_CD = 'Z'" ).append("\n"); 

	}
}