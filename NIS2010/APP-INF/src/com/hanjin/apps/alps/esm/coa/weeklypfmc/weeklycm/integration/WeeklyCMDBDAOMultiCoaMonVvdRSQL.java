/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WeeklyCMDBDAOMultiCoaMonVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOMultiCoaMonVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchYrWkDu SELECT
	  * </pre>
	  */
	public WeeklyCMDBDAOMultiCoaMonVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOMultiCoaMonVvdRSQL").append("\n"); 
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
		query.append("SELECT '' TRD_CD" ).append("\n"); 
		query.append("	, '' RLANE_CD" ).append("\n"); 
		query.append("	, '' IOC_CD" ).append("\n"); 
		query.append("	, '' VSL_CD" ).append("\n"); 
		query.append("	, '' SKD_VOY_NO" ).append("\n"); 
		query.append("	, '' DIR_CD" ).append("\n"); 
		query.append("	, '' VVD_SEQ" ).append("\n"); 
		query.append("	, '' COST_YRMON" ).append("\n"); 
		query.append("	, '' COST_WK" ).append("\n"); 
		query.append("	, '' SLAN_CD" ).append("\n"); 
		query.append("	, '' LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("	, '' N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("	, '' LST_LODG_PORT_CD" ).append("\n"); 
		query.append("	, '' BKG_TTL_QTY" ).append("\n"); 
		query.append("	, '' IOC_RULE_DESC" ).append("\n"); 
		query.append("	, '' HJS_BSA_RTO" ).append("\n"); 
		query.append("	, '' CHTR_BSA_RTO" ).append("\n"); 
		query.append("	, '' VVD_BSA_CAPA" ).append("\n"); 
		query.append("	, '' WKY_TGT_FLG" ).append("\n"); 
		query.append("	, '' MON_TGT_FLG" ).append("\n"); 
		query.append("	, '' SUB_TRD_CD" ).append("\n"); 
		query.append("	, '' DELT_FLG" ).append("\n"); 
		query.append("	, '' WKY_MNL_FLG" ).append("\n"); 
		query.append("	, '' SLS_YRMON" ).append("\n"); 
		query.append("	, '' BSA_ZR_FLG" ).append("\n"); 
		query.append("	, '' VVD_RMK" ).append("\n"); 
		query.append("	, '' CRE_USR_ID" ).append("\n"); 
		query.append("	, '' CRE_DT" ).append("\n"); 
		query.append("	, '' UPD_USR_ID" ).append("\n"); 
		query.append("	, '' UPD_DT" ).append("\n"); 
		query.append("	, '' OLD_COST_WK" ).append("\n"); 
		query.append("	, '' OLD_BSA_ZR_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}