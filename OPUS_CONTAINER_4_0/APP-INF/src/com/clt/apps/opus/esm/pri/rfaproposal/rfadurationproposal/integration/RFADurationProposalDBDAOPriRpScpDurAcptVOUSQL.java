/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFADurationProposalDBDAOPriRpScpDurAcptVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.08 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFADurationProposalDBDAOPriRpScpDurAcptVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Main duration Accept시 Scope Duration도 같이 Accept한다.
	  * </pre>
	  */
	public RFADurationProposalDBDAOPriRpScpDurAcptVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.integration").append("\n"); 
		query.append("FileName : RFADurationProposalDBDAOPriRpScpDurAcptVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_DUR SET" ).append("\n"); 
		query.append("    ACPT_USR_ID     = @[acpt_usr_id]," ).append("\n"); 
		query.append("    ACPT_OFC_CD     = @[acpt_ofc_cd]," ).append("\n"); 
		query.append("    ACPT_DT         = SYSDATE," ).append("\n"); 
		query.append("	PRC_PROG_STS_CD = 'A'," ).append("\n"); 
		query.append("    UPD_USR_ID      = @[upd_usr_id]," ).append("\n"); 
		query.append("    UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO         = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ        = @[amdt_seq]" ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD = 'I'" ).append("\n"); 
		query.append("AND TO_CHAR(CTRT_EXP_DT, 'yyyy-MM-dd') = (" ).append("\n"); 
		query.append("			SELECT TO_CHAR(CTRT_EXP_DT, 'yyyy-MM-dd')" ).append("\n"); 
		query.append("	   	  	FROM PRI_RP_DUR" ).append("\n"); 
		query.append("			WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}