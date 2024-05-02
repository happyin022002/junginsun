/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCMQCProposalDBDAOPriSpScpMqcAcceptVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.01 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCMQCProposalDBDAOPriSpScpMqcAcceptVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scope Mqc Accept All,Cancel
	  * </pre>
	  */
	public SCMQCProposalDBDAOPriSpScpMqcAcceptVOUSQL(){
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
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.integration").append("\n"); 
		query.append("FileName : SCMQCProposalDBDAOPriSpScpMqcAcceptVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_MQC MQC SET " ).append("\n"); 
		query.append("#if (${prc_prog_sts_cd} == 'A')" ).append("\n"); 
		query.append("	PRC_PROG_STS_CD = @[prc_prog_sts_cd]" ).append("\n"); 
		query.append(",   FNL_MQC_QTY     = DECODE((SELECT PROP_STS_CD " ).append("\n"); 
		query.append("			 			      FROM PRI_SP_MN MN " ).append("\n"); 
		query.append("			 			  	  WHERE MN.PROP_NO = MQC.PROP_NO " ).append("\n"); 
		query.append("			 			  	  AND MN.AMDT_SEQ = MQC.AMDT_SEQ " ).append("\n"); 
		query.append("							  ),'R', COFFR_MQC_QTY,PROP_SCP_MQC_QTY )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	PRC_PROG_STS_CD = DECODE(SIGN(COFFR_MQC_QTY),0,'I','R')" ).append("\n"); 
		query.append(",   FNL_MQC_QTY     = 0	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	ACPT_USR_ID     = @[acpt_usr_id]" ).append("\n"); 
		query.append(",	ACPT_OFC_CD 	= @[acpt_ofc_cd]" ).append("\n"); 
		query.append(",	ACPT_DT 		= TO_DATE(@[acpt_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	UPD_USR_ID 		= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT 			= SYSDATE" ).append("\n"); 
		query.append("WHERE	PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ 	    = @[amdt_seq]" ).append("\n"); 
		query.append("--AND	PRC_PROG_STS_CD <> 'R'" ).append("\n"); 
		query.append("#if (${acpt_usr_id} != '')" ).append("\n"); 
		query.append("AND	PRC_PROG_STS_CD <> 'A'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	PRC_PROG_STS_CD = 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}