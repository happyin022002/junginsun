/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : dumyDaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.25 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class dumyDaoNameDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dumy
	  * </pre>
	  */
	public dumyDaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : dumyDaoNameDAOSqlNameRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' COP_NO," ).append("\n"); 
		query.append("'' CNTR_NO," ).append("\n"); 
		query.append("'' CNTR_TPSZ_CD," ).append("\n"); 
		query.append("'' PCTL_NO," ).append("\n"); 
		query.append("'' OB_TRO_FLG," ).append("\n"); 
		query.append("'' IB_TRO_FLG," ).append("\n"); 
		query.append("'' POR_NOD_CD," ).append("\n"); 
		query.append("'' POL_YD_CD," ).append("\n"); 
		query.append("'' NEW_POL," ).append("\n"); 
		query.append("'' NEW_POD," ).append("\n"); 
		query.append("'' POR_CD," ).append("\n"); 
		query.append("'' POL_CD," ).append("\n"); 
		query.append("'' POD_CD," ).append("\n"); 
		query.append("'' DEL_CD," ).append("\n"); 
		query.append("'' OB_TRSP_MODE," ).append("\n"); 
		query.append("'' IB_TRSP_MODE," ).append("\n"); 
		query.append("'' DEL_NOD_CD," ).append("\n"); 
		query.append("'' FULL_RTN_YD_CD," ).append("\n"); 
		query.append("'' FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("'' RCV_TERM_CD," ).append("\n"); 
		query.append("'' DE_TERM_CD," ).append("\n"); 
		query.append("'' MT_PU," ).append("\n"); 
		query.append("'' MT_RTN," ).append("\n"); 
		query.append("'' IO_BND_CD," ).append("\n"); 
		query.append("'' INCL_SHTL_SO_FLG," ).append("\n"); 
		query.append("'' ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("'' ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("'' ROUT_SEQ," ).append("\n"); 
		query.append("'' CCT," ).append("\n"); 
		query.append("'' POL_T," ).append("\n"); 
		query.append("'' POD_T," ).append("\n"); 
		query.append("'' OUT_BOUND," ).append("\n"); 
		query.append("'' IN_BOUND," ).append("\n"); 
		query.append("'' OCN_BOUND," ).append("\n"); 
		query.append("'' T_VVD," ).append("\n"); 
		query.append("'' ORG_LOC_CD," ).append("\n"); 
		query.append("'' DEST_LOC_CD," ).append("\n"); 
		query.append("'' OCN_SEQ," ).append("\n"); 
		query.append("'' OB_TRSP_MODE," ).append("\n"); 
		query.append("'' IB_TRSP_MODE," ).append("\n"); 
		query.append("'' VVD1," ).append("\n"); 
		query.append("'' VVD2," ).append("\n"); 
		query.append("'' VVD3," ).append("\n"); 
		query.append("'' VVD4" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}