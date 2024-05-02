/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSgGrpCmdtVORSQL.java
*@FileTitle : S/C Quotation Rate Creation - G/L Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.23
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.23 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSgGrpCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSgGrpCmdtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSgGrpCmdtVORSQL").append("\n"); 
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
		query.append("SELECT CM.SVC_SCP_CD" ).append("\n"); 
		query.append(", CM.GLINE_SEQ" ).append("\n"); 
		query.append(", CM.PRC_CUST_TP_CD" ).append("\n"); 
		query.append(", CM.GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", CM.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append(", CM.PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#if (${prop_no} != '')" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT GM.SVC_SCP_CD" ).append("\n"); 
		query.append(", GM.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY GM.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_SP_SCP_MN PM" ).append("\n"); 
		query.append(", PRI_SG_MN GM" ).append("\n"); 
		query.append("WHERE PM.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   PM.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   PM.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   GM.SVC_SCP_CD = PM.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   GM.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND   PM.EFF_DT BETWEEN GM.EFF_DT AND GM.EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1 ) GM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_no} == '')" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", 	   GLINE_SEQ" ).append("\n"); 
		query.append(", 	   ROW_NUMBER() OVER (ORDER BY EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_SG_MN" ).append("\n"); 
		query.append("WHERE  SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND    CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND    TO_CHAR(EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(EXP_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1 ) GM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", PRI_SG_GRP_CMDT CM" ).append("\n"); 
		query.append("WHERE CM.SVC_SCP_CD = GM.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   CM.GLINE_SEQ = GM.GLINE_SEQ" ).append("\n"); 
		query.append("AND   CM.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("ORDER BY CM.SVC_SCP_CD" ).append("\n"); 
		query.append(", CM.GLINE_SEQ" ).append("\n"); 
		query.append(", CM.PRC_CUST_TP_CD" ).append("\n"); 
		query.append(", CM.GRP_CMDT_SEQ" ).append("\n"); 

	}
}