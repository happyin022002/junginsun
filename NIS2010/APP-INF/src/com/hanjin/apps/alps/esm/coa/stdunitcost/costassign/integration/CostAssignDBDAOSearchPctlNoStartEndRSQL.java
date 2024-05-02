/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostAssignDBDAOSearchPctlNoStartEndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOSearchPctlNoStartEndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CostAssignDBDAOSearchPctlNoStartEndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOSearchPctlNoStartEndRSQL").append("\n"); 
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
		query.append("/* COP HEADER가 아니라 COA_COM_PARA로 변경" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("--//DBRowSet searchPctlNoStartEnd(String BkgNo, String BkgNoSplit)" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("SELECT   MIN(COP_NO) START_PCTL_NO" ).append("\n"); 
		query.append(",MAX(COP_NO) END_PCTL_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE BKG_NO =" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT MIN(PCTL_NO) START_PCTL_NO, MAX(PCTL_NO) END_PCTL_NO" ).append("\n"); 
		query.append("FROM COA_COM_PARA" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}