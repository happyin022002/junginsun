/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpScpProgChgVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.08.18 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpScpProgChgVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 상태가 변경된 scope만 insert 한다.
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpScpProgChgVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_scp_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpScpProgChgVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_PROG (" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	PROP_SCP_PROG_SEQ" ).append("\n"); 
		query.append(",	PROP_SCP_STS_CD" ).append("\n"); 
		query.append(",	PROG_USR_ID" ).append("\n"); 
		query.append(",	PROG_OFC_CD" ).append("\n"); 
		query.append(",	PROG_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[prop_no]                      	," ).append("\n"); 
		query.append("@[amdt_seq]                     	," ).append("\n"); 
		query.append("A.SVC_SCP_CD         				," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(MAX(PROP_SCP_PROG_SEQ)+1,1) FROM PRI_RP_SCP_PROG" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("@[prop_scp_sts_cd]              ," ).append("\n"); 
		query.append("@[prog_usr_id]                  ," ).append("\n"); 
		query.append("@[prog_ofc_cd]                  ," ).append("\n"); 
		query.append("SYSDATE                         ," ).append("\n"); 
		query.append("@[cre_usr_id]                   ," ).append("\n"); 
		query.append("SYSDATE                         ," ).append("\n"); 
		query.append("@[upd_usr_id]                   ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_RP_SCP_PROG  A" ).append("\n"); 
		query.append(",   PRI_RP_SCP_MN B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.PROP_SCP_STS_CD <> B.PROP_SCP_STS_CD" ).append("\n"); 
		query.append("AND A.PROP_SCP_PROG_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(PROP_SCP_PROG_SEQ) FROM PRI_RP_SCP_PROG" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}