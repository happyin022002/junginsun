/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchCostModeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.09 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchCostModeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CY&Door구분에 따른 CostMode 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchCostModeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchCostModeRSQL").append("\n"); 
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
		query.append("SELECT B.INTG_CD_VAL_CTNT || B.INTG_CD_VAL_DP_DESC AS CODE" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00594'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT IN ('CY', 'DR', 'LS', 'TS')" ).append("\n"); 
		query.append("#if (${cydoordiv} == 'DR')" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = 'DR'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT <> 'DR'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}