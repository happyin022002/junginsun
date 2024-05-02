/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCGroupCommodityProposalDB PriSpScpGrpCmdtDtlAmdVO
	  * </pre>
	  */
	public SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtAmdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_GRP_CMDT(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("GRP_CMDT_SEQ," ).append("\n"); 
		query.append("PRC_GRP_CMDT_CD," ).append("\n"); 
		query.append("PRC_GRP_CMDT_DESC," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO             ," ).append("\n"); 
		query.append("AMDT_SEQ+1          ," ).append("\n"); 
		query.append("SVC_SCP_CD          ," ).append("\n"); 
		query.append("GRP_CMDT_SEQ        ," ).append("\n"); 
		query.append("PRC_GRP_CMDT_CD     ," ).append("\n"); 
		query.append("PRC_GRP_CMDT_DESC   ," ).append("\n"); 
		query.append("@[cre_usr_id]       ," ).append("\n"); 
		query.append("SYSDATE             ," ).append("\n"); 
		query.append("@[upd_usr_id]       ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_CMDT CMDT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO 		= CMDT.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ 		= CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD  	= CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GRP_CMDT_SEQ	= CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("AND SRC_INFO_CD     <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}