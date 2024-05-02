/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOSearchSpclRepoCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchSpclRepoCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스페셜 컨테이너 타입사이즈를 조회한다
	  * </pre>
	  */
	public CostStructureDBDAOSearchSpclRepoCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchSpclRepoCntrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DELT_FLG" ).append("\n"); 
		query.append(",'R' IBFLAG" ).append("\n"); 
		query.append(",''  SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",REPO_FLG" ).append("\n"); 
		query.append(",LIST_BX_DESC" ).append("\n"); 
		query.append("FROM COA_SPCL_REPO_CNTR_RGST" ).append("\n"); 
		query.append("WHERE LIST_BX_SET_LVL_CD = '0001'" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}