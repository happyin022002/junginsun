/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFADurationProposalDBDAOPriRpScpDurChgVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFADurationProposalDBDAOPriRpScpDurChgVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * duration auto change
	  * </pre>
	  */
	public RFADurationProposalDBDAOPriRpScpDurChgVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.integration").append("\n"); 
		query.append("FileName : RFADurationProposalDBDAOPriRpScpDurChgVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_DUR A SET" ).append("\n"); 
		query.append("CTRT_EXP_DT     = NVL(TO_DATE(@[ctrt_exp_dt],'YYYY-MM-DD'),CTRT_EXP_DT)" ).append("\n"); 
		query.append(",SRC_INFO_CD	 =DECODE(N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("(SELECT AMDT_SEQ FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = SVC_SCP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",SRC_INFO_CD,'AM')" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD ='I'" ).append("\n"); 
		query.append(",N1ST_CMNC_AMDT_SEQ	 = (SELECT AMDT_SEQ FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = SVC_SCP_CD )" ).append("\n"); 
		query.append(",UPD_USR_ID      = NVL(@[upd_usr_id],UPD_USR_ID )" ).append("\n"); 
		query.append(",UPD_DT          = sysdate" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO         = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ        = @[amdt_seq]" ).append("\n"); 
		query.append("AND TO_CHAR(CTRT_EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("= (" ).append("\n"); 
		query.append("SELECT TO_CHAR(CTRT_EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("FROM PRI_RP_DUR" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ  = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR (     PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND CTRT_EXP_DT > TO_DATE(@[ctrt_exp_dt],'YYYY-MM-DD'))" ).append("\n"); 

	}
}