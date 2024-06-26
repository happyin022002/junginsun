/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostSetUpDBDAOSearchMtyRepoCostCreateDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2015.04.07 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOSearchMtyRepoCostCreateDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MtyRepoCostCreateDate
	  * </pre>
	  */
	public CostSetUpDBDAOSearchMtyRepoCostCreateDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOSearchMtyRepoCostCreateDateRSQL").append("\n"); 
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
		query.append("SELECT 'Creation Date : '|| TO_CHAR(UPD_DT,'YYYY/MM/DD HH24:MI:SS') mty_repo_cre_dt" ).append("\n"); 
		query.append("FROM  COA_UT_COST_CRE_STS" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("  AND COST_WK  = '00'" ).append("\n"); 
		query.append("  AND CM_UC_CD = 'MRCD'" ).append("\n"); 

	}
}