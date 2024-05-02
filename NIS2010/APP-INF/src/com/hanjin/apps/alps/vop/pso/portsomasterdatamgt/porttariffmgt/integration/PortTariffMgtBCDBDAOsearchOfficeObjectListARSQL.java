/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchOfficeObjectListARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.01.29 정명훈
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

public class PortTariffMgtBCDBDAOsearchOfficeObjectListARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * object 조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchOfficeObjectListARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchOfficeObjectListARSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT /*DISTINCT*/" ).append("\n"); 
		query.append("B.PSO_OBJ_CD             PSO_OBJ_CD" ).append("\n"); 
		query.append(",C1.INTG_CD_VAL_DP_DESC   PSO_OBJ_CD_DSP" ).append("\n"); 
		query.append(",B.PSO_MEAS_UT_CD         PSO_MEAS_UT_CD" ).append("\n"); 
		query.append(",C2.INTG_CD_VAL_DP_DESC   PSO_MEAS_UT_CD_DSP" ).append("\n"); 
		query.append(",B.OBJ_LIST_NO            OBJ_LIST_NO" ).append("\n"); 
		query.append("FROM   PSO_OBJ_LIST         B" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL      C1" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL      C2" ).append("\n"); 
		query.append("WHERE  B.PSO_OBJ_CD = C1.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND    B.PSO_MEAS_UT_CD = C2.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND    C1.INTG_CD_ID = 'CD01846'" ).append("\n"); 
		query.append("AND    C2.INTG_CD_ID = 'CD01848'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${types} != '0206')" ).append("\n"); 
		query.append("AND    PSO_MEAS_UT_CD != 12  -- 12 FLAG 이 아닌것" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER  BY C1.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",C2.INTG_CD_VAL_DP_DESC" ).append("\n"); 

	}
}