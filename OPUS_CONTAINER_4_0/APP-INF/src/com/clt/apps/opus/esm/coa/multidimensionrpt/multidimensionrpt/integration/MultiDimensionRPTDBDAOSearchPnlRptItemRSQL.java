/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchPnlRptItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.20 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-Sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchPnlRptItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Query for ESM_COA_2003
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchPnlRptItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchPnlRptItemRSQL").append("\n"); 
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
		query.append("SELECT 	 STND_COST_CD" ).append("\n"); 
		query.append("		,RPT_VW_CD" ).append("\n"); 
		query.append("		,SGRP_COST_CD" ).append("\n"); 
		query.append("		,STND_COST_TP_CD" ).append("\n"); 
		query.append("		,RPT_ITM_DESC" ).append("\n"); 
		query.append("		,LOCL_RPT_ITM_DESC" ).append("\n"); 
		query.append("		,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("		,SGRP_LOCL_DESC" ).append("\n"); 
		query.append("		,RPT_DP_SEQ" ).append("\n"); 
		query.append("		,RPT_DP_SGRP_SEQ" ).append("\n"); 
		query.append("		,RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("FROM COA_PFIT_LSS_RPT_ITM" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ, RPT_DP_SGRP_SEQ" ).append("\n"); 

	}
}