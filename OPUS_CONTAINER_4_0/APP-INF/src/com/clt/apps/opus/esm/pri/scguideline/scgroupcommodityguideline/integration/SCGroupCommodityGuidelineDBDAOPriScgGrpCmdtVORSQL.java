/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.01.22 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public SCGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	 SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append("	,DELT_FLG" ).append("\n"); 
		query.append("	,SVC_SCP_CD" ).append("\n"); 
		query.append("	,CHG_CD" ).append("\n"); 
		query.append("	,SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("	,SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("FROM PRI_SCG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	CHG_CD 			 = 'OFT'" ).append("\n"); 
		query.append("AND DELT_FLG 		 = 'N'" ).append("\n"); 

	}
}