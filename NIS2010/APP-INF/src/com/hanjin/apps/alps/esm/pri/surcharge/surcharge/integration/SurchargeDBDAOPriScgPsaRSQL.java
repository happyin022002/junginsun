/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SurchargeDBDAOPriScgPsaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.07 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOPriScgPsaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA Group Code를 조회합니다.
	  * </pre>
	  */
	public SurchargeDBDAOPriScgPsaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration ").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgPsaRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT PSA_NO AS CD" ).append("\n"); 
		query.append("     , PSA_NO AS NM" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO" ).append("\n"); 
		query.append("WHERE PSA_NO NOT IN (' ' , '-')" ).append("\n"); 
		query.append("ORDER BY PSA_NO" ).append("\n"); 

	}
}