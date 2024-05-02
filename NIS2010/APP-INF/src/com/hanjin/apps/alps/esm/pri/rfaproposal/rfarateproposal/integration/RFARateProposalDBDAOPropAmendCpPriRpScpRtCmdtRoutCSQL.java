/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRoutCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.30
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.30 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRoutCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Scope Copy PRI_RP_SCP_RT_CMDT_ROUT Insert
	  * </pre>
	  */
	public RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRoutCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("new_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRoutCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_CMDT_ROUT (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    , ROUT_SEQ" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , NOTE_DP_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , ORG_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("    , DEST_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("    , MST_ROUT_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , @[new_amdt_seq]+1 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , L.SVC_SCP_CD" ).append("\n"); 
		query.append("     , L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , @[new_rout_seq] ROUT_SEQ" ).append("\n"); 
		query.append("     , @[new_amdt_seq]+1 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , L.NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , L.ORG_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("     , L.DEST_CY_DOR_RT_TP_CD    " ).append("\n"); 
		query.append("     , @[rout_seq] MST_ROUT_ID" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_CMDT_ROUT L" ).append("\n"); 
		query.append("WHERE L.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   L.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   L.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   L.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND   L.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("    EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_ROUT_PNT M" ).append("\n"); 
		query.append("        WHERE M.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("        AND   M.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   M.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   M.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   M.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("        AND   M.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    OR EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("        WHERE G.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("        AND   G.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   G.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   G.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   G.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("        AND   G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    OR EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("        WHERE I.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("        AND   I.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   I.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   I.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   I.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("        AND   I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    OR EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT J" ).append("\n"); 
		query.append("        WHERE J.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("        AND   J.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   J.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   J.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   J.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("        AND   J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}