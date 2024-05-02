/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOGetVariableheader2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOGetVariableheader2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CostStructureDBDAOGetVariableheader2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOGetVariableheader2RSQL").append("\n"); 
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
		query.append("SELECT A.MAS_COST_SRC_CD CODE, B.STND_COST_NM NAME" ).append("\n"); 
		query.append("FROM MAS_COST_SRC_ACCT A, MAS_STND_ACCT B, MAS_SUB_GRP_COST C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.SGRP_COST_CD = 'CVTR'" ).append("\n"); 
		query.append("AND A.COST_ASS_BSE_CD = 'C'" ).append("\n"); 
		query.append("AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("AND A.SGRP_COST_CD = C.SGRP_COST_CD" ).append("\n"); 
		query.append("ORDER BY NAME DESC" ).append("\n"); 

	}
}