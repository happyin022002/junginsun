/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpMnCmSummaryVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.12.09 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpMnCmSummaryVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpMnCmSummaryVOUSQL(){
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpMnCmSummaryVOUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_SP_SCP_MN A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT   NVL(SUM(PRS_CRNT_LOD_QTY * PRS_CRNT_RESPB_CMPB_AMT ), 0) AS PRS_CRNT_CM_AMT" ).append("\n"); 
		query.append(",NVL(SUM(PRS_ESTM_LOD_QTY * DECODE(U.CNTR_SZ_CD,'2',CR.PRS_ESTM_RESPB_CMPB_AMT,CR.PRS_ESTM_RESPB_CMPB_AMT/2) ), 0) AS PRS_ESTM_CM_AMT" ).append("\n"); 
		query.append(",NVL(SUM(PRS_RMN_LOD_QTY * PRS_RMN_RESPB_CMPB_AMT ), 0) AS PRS_RMN_CM_AMT" ).append("\n"); 
		query.append(",CR.PROP_NO, CR.AMDT_SEQ, CR.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM  PRI_SP_SCP_RT_CMDT_ROUT CR" ).append("\n"); 
		query.append(", PRI_RAT_UT U" ).append("\n"); 
		query.append("WHERE  CR.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND  CR.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND  CR.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND  CR.PRS_RAT_UT_CD = U.RAT_UT_CD(+)" ).append("\n"); 
		query.append("GROUP BY CR.PROP_NO, CR.AMDT_SEQ, CR.SVC_SCP_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("PRS_CRNT_CM_AMT = B.PRS_CRNT_CM_AMT," ).append("\n"); 
		query.append("PRS_ESTM_CM_AMT = B.PRS_ESTM_CM_AMT," ).append("\n"); 
		query.append("PRS_RMN_CM_AMT = B.PRS_RMN_CM_AMT," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = sysdate" ).append("\n"); 

	}
}