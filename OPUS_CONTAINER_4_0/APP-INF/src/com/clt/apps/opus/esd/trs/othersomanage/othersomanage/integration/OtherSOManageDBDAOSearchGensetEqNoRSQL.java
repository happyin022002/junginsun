/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageDAOSearchGensetEqNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.09.15 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOSearchGensetEqNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Genset정보를 조회한다.
	  * </pre>
	  */
	public OtherSOManageDBDAOSearchGensetEqNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDAOSearchGensetEqNoRSQL").append("\n"); 
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
		query.append("MGST_NO AS EQ_NO" ).append("\n"); 
		query.append(",MGST_TP_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM 	MGS_MGST_MST" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("AND MGST_NO in (" ).append("\n"); 
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

	}
}