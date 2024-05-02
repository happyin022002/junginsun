/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCDurationProposalDBDAOPriSpScpDurAutoAcceptVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCDurationProposalDBDAOPriSpScpDurAutoAcceptVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request 시 자동 Accept
	  * </pre>
	  */
	public SCDurationProposalDBDAOPriSpScpDurAutoAcceptVOUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.integration").append("\n"); 
		query.append("FileName : SCDurationProposalDBDAOPriSpScpDurAutoAcceptVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_DUR SET" ).append("\n"); 
		query.append("PRC_PROG_STS_CD = @[prc_prog_sts_cd]" ).append("\n"); 
		query.append(", ACPT_USR_ID     = @[acpt_usr_id]" ).append("\n"); 
		query.append(",ACPT_OFC_CD     = @[acpt_ofc_cd]" ).append("\n"); 
		query.append(",ACPT_DT         = SYSDATE" ).append("\n"); 
		query.append(",UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO         = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ        = @[amdt_seq]" ).append("\n"); 

	}
}