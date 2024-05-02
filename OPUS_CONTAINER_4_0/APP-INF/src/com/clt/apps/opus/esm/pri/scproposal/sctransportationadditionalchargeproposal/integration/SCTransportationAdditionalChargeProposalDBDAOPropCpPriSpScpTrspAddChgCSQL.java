/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOPropCpPriSpScpTrspAddChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.06.12 CHLOE MIJIN SEO
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

public class SCTransportationAdditionalChargeProposalDBDAOPropCpPriSpScpTrspAddChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Scope Copy PRI_SP_SCP_TRSP_ADD_CHG Insert
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOPropCpPriSpScpTrspAddChgCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOPropCpPriSpScpTrspAddChgCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_TRSP_ADD_CHG (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , ADD_CHG_TP_CD" ).append("\n"); 
		query.append("    , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("    , ADD_CHG_SEQ" ).append("\n"); 
		query.append("    , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("    , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("    , LOC_GRD_CNT_CD" ).append("\n"); 
		query.append("    , LOC_GRD_CD" ).append("\n"); 
		query.append("    , BSE_PORT_TP_CD" ).append("\n"); 
		query.append("    , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("    , VIA_PORT_TP_CD" ).append("\n"); 
		query.append("    , VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("    , DIR_CALL_FLG" ).append("\n"); 
		query.append("    , RAT_UT_CD" ).append("\n"); 
		query.append("    , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("    , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("    , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("    , PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("    , PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("    , GRI_APPL_TP_CD" ).append("\n"); 
		query.append("    , GRI_APPL_AMT" ).append("\n"); 
		query.append("    , ADD_CHG_NOTE_CTNT" ).append("\n"); 
		query.append("    , NOTE_DP_SEQ" ).append("\n"); 
		query.append("    , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("    , SRC_INFO_CD" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , ADD_CHG_TP_CD" ).append("\n"); 
		query.append("     , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, ADD_CHG_TP_CD, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                          ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, ADD_CHG_TP_CD, ORG_DEST_TP_CD, ADD_CHG_SEQ) AS ADD_CHG_SEQ" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , LOC_GRD_CNT_CD" ).append("\n"); 
		query.append("     , LOC_GRD_CD" ).append("\n"); 
		query.append("     , BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , VIA_PORT_TP_CD" ).append("\n"); 
		query.append("     , VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("     , DIR_CALL_FLG" ).append("\n"); 
		query.append("     , RAT_UT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("     , PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , DECODE((SELECT PROP_STS_CD FROM PRI_SP_MN " ).append("\n"); 
		query.append("               WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq]),'F',FNL_FRT_RT_AMT,PROP_FRT_RT_AMT) AS PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , 'N' AS GRI_APPL_TP_CD" ).append("\n"); 
		query.append("     , 0 AS GRI_APPL_AMT" ).append("\n"); 
		query.append("     , ADD_CHG_NOTE_CTNT" ).append("\n"); 
		query.append("     , DECODE(NOTE_DP_SEQ, NULL, NULL, " ).append("\n"); 
		query.append("                           DENSE_RANK() OVER (PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, ADD_CHG_TP_CD, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                 ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, ADD_CHG_TP_CD, ORG_DEST_TP_CD, NOTE_DP_SEQ NULLS LAST)) AS NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , 'PC' AS SRC_INFO_CD" ).append("\n"); 
		query.append("     , 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   DECODE(@[org_dest_tp_cd], NULL, 1, ORG_DEST_TP_CD, 1, 0) = 1" ).append("\n"); 
		query.append("AND   SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}