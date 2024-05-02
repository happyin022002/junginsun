/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtVORSQL.java
*@FileTitle : RFA Guideline Creation - Arbitrary[Load Excel]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.30 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtVORSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration").append("\n"); 
		query.append("FileName : RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtVORSQL").append("\n"); 
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
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("GRP_CMDT_SEQ," ).append("\n"); 
		query.append("PRC_GRP_CMDT_CD," ).append("\n"); 
		query.append("PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("ORDER BY PRC_GRP_CMDT_CD" ).append("\n"); 

	}
}