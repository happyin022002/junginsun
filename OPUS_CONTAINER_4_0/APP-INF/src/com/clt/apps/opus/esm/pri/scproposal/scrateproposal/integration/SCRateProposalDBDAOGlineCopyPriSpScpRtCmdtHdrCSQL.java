/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRateProposalDBDAOGlineCopyPriSpScpRtCmdtHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOGlineCopyPriSpScpRtCmdtHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Copy PRI_SP_SCP_RT_CMDT_HDR Insert	
	  * </pre>
	  */
	public SCRateProposalDBDAOGlineCopyPriSpScpRtCmdtHdrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOGlineCopyPriSpScpRtCmdtHdrCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_RT_CMDT_HDR (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , BLET_DP_SEQ" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , @[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append("     , B.SVC_SCP_CD" ).append("\n"); 
		query.append("     , 'G' AS GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY B.SVC_SCP_CD, B.GLINE_SEQ, B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("                          ORDER BY B.SVC_SCP_CD, B.GLINE_SEQ, B.PRC_CUST_TP_CD, B.CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , ROW_NUMBER() OVER (ORDER BY B.SVC_SCP_CD, B.GLINE_SEQ, B.PRC_CUST_TP_CD, B.CMDT_HDR_SEQ) AS BLET_DP_SEQ" ).append("\n"); 
		query.append("     , @[amdt_seq] AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("FROM PRI_SG_RT_CMDT_HDR B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND   B.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_SG_RT_CMDT C" ).append("\n"); 
		query.append("        WHERE C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("        AND   C.PRC_CUST_TP_CD = B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("        AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_SG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("        WHERE D.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   D.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("        AND   D.PRC_CUST_TP_CD = B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("        AND   D.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                FROM PRI_SG_RT H" ).append("\n"); 
		query.append("                   , PRI_SP_MQC J" ).append("\n"); 
		query.append("                   , PRI_SP_SCP_MQC I" ).append("\n"); 
		query.append("                WHERE H.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND   H.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("                AND   H.PRC_CUST_TP_CD = D.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("                AND   H.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND   H.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                AND   J.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                AND   J.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                AND   I.PROP_NO = J.PROP_NO" ).append("\n"); 
		query.append("                AND   I.AMDT_SEQ = J.AMDT_SEQ" ).append("\n"); 
		query.append("                AND   I.SVC_SCP_CD = H.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND   DECODE(I.PROP_SCP_MQC_QTY, 0, J.PROP_MQC_QTY, I.PROP_SCP_MQC_QTY) BETWEEN H.MQC_RNG_FM_QTY AND H.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}