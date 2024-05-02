/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOmakeAwkCgoExtraCostByRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.29
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.04.29 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOmakeAwkCgoExtraCostByRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_ROUT
	  * PRI_SCQ_AWK_ROUT_COST
	  * PRI_SCQ_AWK_YD_COST
	  * </pre>
	  */
	public ScqAwkwardDBDAOmakeAwkCgoExtraCostByRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOmakeAwkCgoExtraCostByRouteRSQL").append("\n"); 
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
		query.append("SELECT     " ).append("\n"); 
		query.append(" '' COST_AMT" ).append("\n"); 
		query.append(",'' COST_TP_CD" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' IB_YD_CD" ).append("\n"); 
		query.append(",'' IO_BND_CD" ).append("\n"); 
		query.append(",'' LANE_CD" ).append("\n"); 
		query.append(",'' OB_YD_CD" ).append("\n"); 
		query.append(",'' ROUT_COST_SEQ" ).append("\n"); 
		query.append(",'' ROUT_SEQ" ).append("\n"); 
		query.append(",'' ROUT_TP_CD" ).append("\n"); 
		query.append(",'' ROUT_TP_SEQ" ).append("\n"); 
		query.append(",'' SCQ_RQST_NO" ).append("\n"); 
		query.append(",'' SCQ_VER_NO" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' YD_CD" ).append("\n"); 
		query.append(",'' YD_COST_SEQ" ).append("\n"); 
		query.append(",'' SCQ_VER_NO_TMP" ).append("\n"); 
		query.append(",'' N_COST" ).append("\n"); 
		query.append(",'' S_COST" ).append("\n"); 
		query.append(",'' A_COST" ).append("\n"); 
		query.append(",'' G_COST" ).append("\n"); 
		query.append(",'' T_COST" ).append("\n"); 
		query.append(",'' W_COST" ).append("\n"); 
		query.append(",'' TMP_YN" ).append("\n"); 
		query.append(",'' N_COST_ZERO_EXIST" ).append("\n"); 
		query.append(",'' W_COST_ZERO_EXIST" ).append("\n"); 
		query.append(",'' G_COST_ZERO_EXIST" ).append("\n"); 
		query.append(",'' T_COST_ZERO_EXIST" ).append("\n"); 
		query.append(",'' S_COST_ZERO_EXIST" ).append("\n"); 
		query.append(",'' A_COST_ZERO_EXIST" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}