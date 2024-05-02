/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbCancleUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2016.01.08 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbCancleUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * gri cal 취소
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbCancleUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbCancleUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_TRSP_ADD_CHG A SET" ).append("\n"); 
		query.append("       A.GRI_APPL_TP_CD = 'N'" ).append("\n"); 
		query.append("	  #if (${amdt_seq} != '0')" ).append("\n"); 
		query.append("      ,(A.PRC_PROG_STS_CD, A.SRC_INFO_CD, A.N1ST_CMNC_AMDT_SEQ, A.PROP_FRT_RT_AMT, A.COFFR_FRT_RT_AMT, A.FNL_FRT_RT_AMT) = " ).append("\n"); 
		query.append("       (SELECT PRC_PROG_STS_CD, SRC_INFO_CD, N1ST_CMNC_AMDT_SEQ, PROP_FRT_RT_AMT, COFFR_FRT_RT_AMT, FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("        FROM   PRI_SP_SCP_TRSP_ADD_CHG " ).append("\n"); 
		query.append("        WHERE  PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("        AND    AMDT_SEQ = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("        AND    SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND    ADD_CHG_TP_CD = A.ADD_CHG_TP_CD" ).append("\n"); 
		query.append("        AND    ORG_DEST_TP_CD = A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("        AND    ADD_CHG_SEQ = A.ADD_CHG_SEQ" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	  #else" ).append("\n"); 
		query.append("      ,A.PROP_FRT_RT_AMT = A.PROP_FRT_RT_AMT - A.GRI_APPL_AMT" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      ,A.GRI_APPL_AMT = 0" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND A.GRI_APPL_TP_CD = 'A'" ).append("\n"); 

	}
}