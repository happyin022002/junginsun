/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchObjectListARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.08 정명훈
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

public class PortTariffMgtBCDBDAOSearchObjectListARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_OBJ_LIST
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchObjectListARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchObjectListARSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.PSO_OBJ_CD           PSO_OBJ_CD" ).append("\n"); 
		query.append(",C1.INTG_CD_VAL_DP_DESC PSO_OBJ_CD_DSP" ).append("\n"); 
		query.append("FROM   PSO_OBJ_LIST    B" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL C1" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    B.PSO_OBJ_CD = C1.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND    C1.INTG_CD_ID = 'CD01846'" ).append("\n"); 
		query.append("ORDER  BY C1.INTG_CD_VAL_DP_DESC" ).append("\n"); 

	}
}