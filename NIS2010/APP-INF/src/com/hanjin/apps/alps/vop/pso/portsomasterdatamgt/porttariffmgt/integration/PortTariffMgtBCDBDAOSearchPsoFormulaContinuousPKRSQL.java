/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchPsoFormulaContinuousPKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.26 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchPsoFormulaContinuousPKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 비어있는 Formula No. 채번
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchPsoFormulaContinuousPKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchPsoFormulaContinuousPKRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(DECODE(X.RNUM, X.CNT, X.RNUM+1, X.RNUM)), 1) NEW_FOML_NO" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT /*+ INDEX_ASC(A XPKPSO_FORMULA) */" ).append("\n"); 
		query.append("ROWNUM             RNUM" ).append("\n"); 
		query.append(",A.FOML_NO - ROWNUM DIFF" ).append("\n"); 
		query.append(",COUNT(*) OVER()    CNT" ).append("\n"); 
		query.append("FROM   PSO_FORMULA A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND   (X.DIFF > 0 OR X.RNUM = X.CNT)" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}