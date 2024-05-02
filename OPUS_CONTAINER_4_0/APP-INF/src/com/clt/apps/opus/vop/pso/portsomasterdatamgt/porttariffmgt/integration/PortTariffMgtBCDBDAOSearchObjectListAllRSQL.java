/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchObjectListAllRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchObjectListAllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Object List
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchObjectListAllRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchObjectListAllRSQL").append("\n"); 
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
		query.append("SELECT /*DISTINCT*/" ).append("\n"); 
		query.append("       B.PSO_OBJ_CD PSO_OBJ_CD" ).append("\n"); 
		query.append("     , B.OBJ_LIST_NM PSO_OBJ_CD_DSP" ).append("\n"); 
		query.append("     , B.PSO_MEAS_UT_CD PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("     , C2.INTG_CD_VAL_DP_DESC PSO_MEAS_UT_CD_DSP" ).append("\n"); 
		query.append("     , B.OBJ_LIST_NO OBJ_LIST_NO" ).append("\n"); 
		query.append("  FROM PSO_OBJ_LIST B" ).append("\n"); 
		query.append("     , COM_INTG_CD_DTL C2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND B.PSO_MEAS_UT_CD = C2.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("   AND C2.INTG_CD_ID = 'CD01848'" ).append("\n"); 
		query.append(" ORDER BY B.OBJ_LIST_NM " ).append("\n"); 

	}
}