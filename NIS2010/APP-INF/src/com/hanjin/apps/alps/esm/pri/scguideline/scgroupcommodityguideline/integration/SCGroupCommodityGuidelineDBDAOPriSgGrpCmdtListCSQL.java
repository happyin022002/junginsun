/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.22 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Insert
	  * </pre>
	  */
	public SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtListCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO PRI_SG_GRP_CMDT_DTL (" ).append("\n"); 
		query.append("SVC_SCP_CD" ).append("\n"); 
		query.append(",   GLINE_SEQ" ).append("\n"); 
		query.append(",   PRC_CUST_TP_CD" ).append("\n"); 
		query.append(",   GRP_CMDT_SEQ" ).append("\n"); 
		query.append(",   GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(",   PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",   PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT)" ).append("\n"); 
		query.append("SELECT DT.SVC_SCP_CD" ).append("\n"); 
		query.append(", @[gline_seq] AS GLINE_SEQ" ).append("\n"); 
		query.append(", @[prc_cust_tp_cd] AS PRC_CUST_TP_CD" ).append("\n"); 
		query.append(", @[grp_cmdt_seq] AS GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY DT.CMDT_CD) AS GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(", 'L' AS PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(", DT.CMDT_CD AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM PRI_SCG_GRP_CMDT_DTL DT" ).append("\n"); 
		query.append("WHERE DT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   DT.CHG_CD = 'GRI'" ).append("\n"); 
		query.append("AND   DT.SCG_GRP_CMDT_SEQ = @[scg_grp_cmdt_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtListCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}