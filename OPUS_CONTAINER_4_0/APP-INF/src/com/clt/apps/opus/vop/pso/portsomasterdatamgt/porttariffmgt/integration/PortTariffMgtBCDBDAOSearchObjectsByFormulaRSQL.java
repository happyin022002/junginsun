/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchObjectsByFormulaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.01.12 정명훈
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

public class PortTariffMgtBCDBDAOSearchObjectsByFormulaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Formula에 속한 Object List 구하기
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchObjectsByFormulaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchObjectsByFormulaRSQL").append("\n"); 
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
		query.append("SELECT P.OBJ_LIST_NO" ).append("\n"); 
		query.append(",Q.OBJ_LIST_NM" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT DISTINCT DECODE(Y.RNUM, 1, X.OBJ_LIST_NO, X.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT BB.OBJ_LIST_NO" ).append("\n"); 
		query.append(",BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("FROM   PSO_FORMULA   B" ).append("\n"); 
		query.append(",PSO_FOML_DTL  BB" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("AND    BB.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("AND    B.FOML_NO = ${foml_no}" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(",(SELECT LEVEL RNUM" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= 2" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE  DECODE(Y.RNUM, 1, X.OBJ_LIST_NO, X.RT_OBJ_LIST_NO) IS NOT NULL" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append(",PSO_OBJ_LIST Q" ).append("\n"); 
		query.append("WHERE  P.OBJ_LIST_NO = Q.OBJ_LIST_NO" ).append("\n"); 
		query.append("ORDER BY P.OBJ_LIST_NO" ).append("\n"); 

	}
}