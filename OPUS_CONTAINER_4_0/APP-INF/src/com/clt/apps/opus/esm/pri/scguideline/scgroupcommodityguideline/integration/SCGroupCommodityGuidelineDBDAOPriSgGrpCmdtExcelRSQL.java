/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.12 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * excel 용 조회
	  * </pre>
	  */
	public SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtExcelRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT B.PRC_GRP_CMDT_CD," ).append("\n"); 
		query.append("B.PRC_GRP_CMDT_DESC," ).append("\n"); 
		query.append("A.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("C.CMDT_NM" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_CMDT_DTL A" ).append("\n"); 
		query.append(", PRI_SG_GRP_CMDT B" ).append("\n"); 
		query.append(", MDM_COMMODITY C" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD 		= A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ 		= A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.PRC_CUST_TP_CD 	= A.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND   B.GRP_CMDT_SEQ 	= A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("AND   A.PRC_CMDT_DEF_CD = C.CMDT_CD" ).append("\n"); 
		query.append("AND   B.SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ 		= @[gline_seq]" ).append("\n"); 
		query.append("AND   B.PRC_CUST_TP_CD  = @[prc_cust_tp_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtExcelRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}