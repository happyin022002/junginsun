/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.12 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public RFAGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL(){
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
		query.append("SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append(",SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("FROM PRI_SCG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	CHG_CD 			 = 'GRI'" ).append("\n"); 
		query.append("AND DELT_FLG 		 = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration").append("\n"); 
		query.append("FileName : RFAGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}