/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOsearchRHQComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.05.23 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCostManageDBDAOsearchRHQComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRHQCombo
	  * </pre>
	  */
	public InlandCostManageDBDAOsearchRHQComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOsearchRHQComboRSQL").append("\n"); 
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
		query.append("SELECT B.INTG_CD_VAL_CTNT     RHQ_CD" ).append("\n"); 
		query.append(",B.INTG_CD_VAL_DP_DESC  RHQ_NM" ).append("\n"); 
		query.append("FROM COM_INTG_CD A" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE A.INTG_CD_ID = B.INTG_CD_ID" ).append("\n"); 
		query.append("AND A.INTG_CD_USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.INTG_CD_ID = 'CD00961'" ).append("\n"); 

	}
}