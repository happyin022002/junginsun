/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityProposalDBDAOPropCpPriSpScpGrpCmdtCSQL.java
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

public class SCGroupCommodityProposalDBDAOPropCpPriSpScpGrpCmdtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Scope Copy PRI_SP_SCP_GRP_CMDT Insert
	  * </pre>
	  */
	public SCGroupCommodityProposalDBDAOPropCpPriSpScpGrpCmdtCSQL(){
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
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityProposalDBDAOPropCpPriSpScpGrpCmdtCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_GRP_CMDT (" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", SVC_SCP_CD" ).append("\n"); 
		query.append(", GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append(", PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT)" ).append("\n"); 
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", SVC_SCP_CD" ).append("\n"); 
		query.append(", GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append(", PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append(", 0 AS AMDT_SEQ" ).append("\n"); 
		query.append(", A.SVC_SCP_CD" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD" ).append("\n"); 
		query.append("ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GRP_CMDT_SEQ) AS GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GRP_CMDT_SEQ, B.GRP_CMDT_DTL_SEQ) AS SEQ" ).append("\n"); 
		query.append(", A.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append(", A.PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_CMDT A" ).append("\n"); 
		query.append(",PRI_SP_SCP_GRP_CMDT_DTL B" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GRP_CMDT_SEQ = A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("AND   B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 

	}
}