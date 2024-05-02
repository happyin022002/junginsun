/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchTariffConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.11.11 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchTariffConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VOP_PSO_0206 조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchTariffConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchTariffConditionRSQL").append("\n"); 
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
		query.append("SELECT ROW_NO" ).append("\n"); 
		query.append(",MAX(DECODE(PSO_COND_DTL_TP_CD, 'P', CASE WHEN PSO_COND_OPR_CD IN ('AND', 'OR') THEN PSO_COND_OPR_CD END )) CONDITION" ).append("\n"); 
		query.append(",MAX(DECODE(PSO_COND_DTL_TP_CD, 'O', B.PSO_OBJ_CD)) OBJECT" ).append("\n"); 
		query.append(",MAX(DECODE(PSO_COND_DTL_TP_CD, 'O', A.OBJ_LIST_NO)) OBJ_LIST_NO" ).append("\n"); 
		query.append(",MAX(DECODE(PSO_COND_DTL_TP_CD, 'P', CASE WHEN PSO_COND_OPR_CD NOT IN ('AND', 'OR') THEN PSO_COND_OPR_CD END )) OPERATOR" ).append("\n"); 
		query.append(",MAX(DECODE(PSO_COND_DTL_TP_CD, 'C', COND_OPR_VAL_CTNT)) OBJ_VALUE" ).append("\n"); 
		query.append("FROM   PSO_COND_DTL A" ).append("\n"); 
		query.append(",PSO_OBJ_LIST B" ).append("\n"); 
		query.append("WHERE  COND_NO = @[cond_no]" ).append("\n"); 
		query.append("AND    A.OBJ_LIST_NO = B.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("GROUP  BY ROW_NO" ).append("\n"); 
		query.append("ORDER  BY ROW_NO" ).append("\n"); 

	}
}