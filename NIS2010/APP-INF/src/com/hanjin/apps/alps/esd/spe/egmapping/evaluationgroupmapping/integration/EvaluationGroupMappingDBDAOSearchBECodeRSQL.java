/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingDBDAOSearchBECodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.08
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.08 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupMappingDBDAOSearchBECodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Evaluation 데이터를 조회한다.
	  * </pre>
	  */
	public EvaluationGroupMappingDBDAOSearchBECodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration").append("\n"); 
		query.append("FileName : EvaluationGroupMappingDBDAOSearchBECodeRSQL").append("\n"); 
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
		query.append("SELECT BZC_EV_GRD_CD" ).append("\n"); 
		query.append("--       , BZC_EV_GRD_NM || ' (' ||BZC_EV_GRD_VAL|| ')' AS BZC_EV_GRD_NM" ).append("\n"); 
		query.append("     , BZC_EV_GRD_NM" ).append("\n"); 
		query.append("FROM SPE_BZC_EV_GRD" ).append("\n"); 
		query.append("ORDER BY BZC_EV_GRD_VAL  DESC" ).append("\n"); 

	}
}