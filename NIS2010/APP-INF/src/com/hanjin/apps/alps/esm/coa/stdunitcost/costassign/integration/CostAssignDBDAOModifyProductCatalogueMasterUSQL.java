/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostAssignDBDAOModifyProductCatalogueMasterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.11.11 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author OKYOUNG IM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOModifyProductCatalogueMasterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    PRD_PROD_CTL_MST 테이블의 비용정보를 초기화한다
	  * </pre>
	  */
	public CostAssignDBDAOModifyProductCatalogueMasterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOModifyProductCatalogueMasterUSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("--// void modifyPRD_PROD_CTL_MST(String startPctlNo, String endPctlNo)" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("UPDATE PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("SET TTL_EXPN_AMT = 0" ).append("\n"); 
		query.append(",UPD_USR_ID = 'SYSTEM_COA2'" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE PCTL_NO BETWEEN '${start_pctl_no}' AND '${end_pctl_no}'" ).append("\n"); 

	}
}