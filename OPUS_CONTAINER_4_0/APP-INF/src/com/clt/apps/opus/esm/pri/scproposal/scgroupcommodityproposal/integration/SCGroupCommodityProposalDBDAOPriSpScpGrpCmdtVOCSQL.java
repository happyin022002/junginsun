/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.08.07 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Byeon Young Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_grp_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GRP_CMDT_SEQ" ).append("\n"); 
		query.append(",PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append(",PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[prop_no]" ).append("\n"); 
		query.append(",@[amdt_seq]" ).append("\n"); 
		query.append(",@[svc_scp_cd]" ).append("\n"); 
		query.append(",@[grp_cmdt_seq]" ).append("\n"); 
		query.append(",@[prc_grp_cmdt_cd]" ).append("\n"); 
		query.append(",@[prc_grp_cmdt_desc]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}