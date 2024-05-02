/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchFormulaNoForLoadingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.16 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchFormulaNoForLoadingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_FORMULA  FOML_NO IN (1, 2)
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchFormulaNoForLoadingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchFormulaNoForLoadingRSQL").append("\n"); 
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
		query.append("SELECT A.FOML_NO" ).append("\n"); 
		query.append(",A.FOML_NM" ).append("\n"); 
		query.append(",A.PSO_FOML_MZD_CD" ).append("\n"); 
		query.append(",A.FOML_DESC" ).append("\n"); 
		query.append(",A.FOML_SYS_DESC" ).append("\n"); 
		query.append(",A.UPD_MNU_NO" ).append("\n"); 
		query.append("FROM   PSO_FORMULA A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.FOML_NO IN (1, 2)" ).append("\n"); 
		query.append("ORDER BY A.FOML_NO" ).append("\n"); 

	}
}