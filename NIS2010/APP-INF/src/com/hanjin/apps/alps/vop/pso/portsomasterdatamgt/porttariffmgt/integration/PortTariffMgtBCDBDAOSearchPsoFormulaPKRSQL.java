/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchPsoFormulaPKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.16 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchPsoFormulaPKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_FORMULA 채번
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchPsoFormulaPKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchPsoFormulaPKRSQL").append("\n"); 
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
		query.append("/**** PSO_FORMULA 채번 ****/" ).append("\n"); 
		query.append("SELECT /*+INDEX_DESC(T XPKPSO_FORMULA)*/" ).append("\n"); 
		query.append("NVL(MAX(FOML_NO), 0) + 1 FOML_NO" ).append("\n"); 
		query.append("FROM   PSO_FORMULA T" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    T.FOML_NO > 0" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}