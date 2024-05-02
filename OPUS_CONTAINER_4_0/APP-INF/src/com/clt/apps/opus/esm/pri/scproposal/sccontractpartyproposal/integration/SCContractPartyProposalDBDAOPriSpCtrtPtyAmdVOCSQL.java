/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.02 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOPriSpCtrtPtyAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCContractPartyProposalDB PriSpCtrtCustTpAmdVO
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtPtyAmdVOCSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_CTRT_PTY(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("PRC_CTRT_PTY_TP_CD," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("CTRT_CUST_VAL_SGM_CD," ).append("\n"); 
		query.append("CTRT_CUST_SREP_CD," ).append("\n"); 
		query.append("CTRT_CUST_SLS_OFC_CD," ).append("\n"); 
		query.append("CTRT_PTY_NM," ).append("\n"); 
		query.append("CTRT_PTY_ADDR," ).append("\n"); 
		query.append("CTRT_PTY_SGN_NM," ).append("\n"); 
		query.append("CTRT_PTY_SGN_TIT_NM," ).append("\n"); 
		query.append("PRC_PROG_STS_CD," ).append("\n"); 
		query.append("SRC_INFO_CD," ).append("\n"); 
		query.append("ACPT_USR_ID," ).append("\n"); 
		query.append("ACPT_OFC_CD," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO					," ).append("\n"); 
		query.append("AMDT_SEQ+1				," ).append("\n"); 
		query.append("PRC_CTRT_PTY_TP_CD		," ).append("\n"); 
		query.append("CUST_CNT_CD				," ).append("\n"); 
		query.append("CUST_SEQ				," ).append("\n"); 
		query.append("CTRT_CUST_VAL_SGM_CD    ," ).append("\n"); 
		query.append("CTRT_CUST_SREP_CD        ," ).append("\n"); 
		query.append("CTRT_CUST_SLS_OFC_CD    ," ).append("\n"); 
		query.append("CTRT_PTY_NM                ," ).append("\n"); 
		query.append("CTRT_PTY_ADDR            ," ).append("\n"); 
		query.append("CTRT_PTY_SGN_NM            ," ).append("\n"); 
		query.append("CTRT_PTY_SGN_TIT_NM        ," ).append("\n"); 
		query.append("PRC_PROG_STS_CD            ," ).append("\n"); 
		query.append("SRC_INFO_CD                ," ).append("\n"); 
		query.append("ACPT_USR_ID                ," ).append("\n"); 
		query.append("ACPT_OFC_CD                ," ).append("\n"); 
		query.append("ACPT_DT                    ," ).append("\n"); 
		query.append("@[cre_usr_id]            ," ).append("\n"); 
		query.append("sysdate                    ," ).append("\n"); 
		query.append("@[upd_usr_id]            ," ).append("\n"); 
		query.append("SYSDATE			," ).append("\n"); 
		query.append("N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}