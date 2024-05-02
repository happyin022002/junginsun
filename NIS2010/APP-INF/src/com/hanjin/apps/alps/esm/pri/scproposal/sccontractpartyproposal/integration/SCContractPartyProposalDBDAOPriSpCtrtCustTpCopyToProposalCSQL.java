/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtCustTpCopyToProposalCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.22 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOPriSpCtrtCustTpCopyToProposalCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriSpCtrtCustTpCopyToProposal
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtCustTpCopyToProposalCSQL(){
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
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtCustTpCopyToProposalCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_CTRT_CUST_TP(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("PRC_CTRT_PTY_TP_CD," ).append("\n"); 
		query.append("PRC_CTRT_CUST_TP_CD," ).append("\n"); 
		query.append("PRC_PROG_STS_CD," ).append("\n"); 
		query.append("SRC_INFO_CD," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("ACPT_USR_ID," ).append("\n"); 
		query.append("ACPT_OFC_CD," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append(",0 AS AMDT_SEQ" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",A.PRC_CUST_TP_CD" ).append("\n"); 
		query.append(",'I'" ).append("\n"); 
		query.append(",'PC'" ).append("\n"); 
		query.append(",0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM	PRI_SQ_MN A" ).append("\n"); 
		query.append("WHERE	A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 

	}
}