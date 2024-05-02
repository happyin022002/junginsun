/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOPropCpPriRpScpRtCmdtHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.06.22 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPropCpPriRpScpRtCmdtHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Scope Copy PRI_RP_SCP_RT_CMDT_HDR Insert
	  * </pre>
	  */
	public RFARateProposalDBDAOPropCpPriRpScpRtCmdtHdrCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPropCpPriRpScpRtCmdtHdrCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_CMDT_HDR (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , BLET_DP_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , FIC_RT_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD" ).append("\n"); 
		query.append("                          ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.BLET_DP_SEQ, A.CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD,NVL(A.FIC_RT_TP_CD,'G')" ).append("\n"); 
		query.append("                          ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.BLET_DP_SEQ, A.CMDT_HDR_SEQ) AS BLET_DP_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , NVL(A.FIC_RT_TP_CD,'G')" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("    EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_CMDT B" ).append("\n"); 
		query.append("        WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("        AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    OR EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_ACT_CUST C" ).append("\n"); 
		query.append("        WHERE C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("        AND   C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   C.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   C.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    OR EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_CNOTE D" ).append("\n"); 
		query.append("        WHERE D.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("        AND   D.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   D.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   D.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    OR EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_CMDT_ROUT E" ).append("\n"); 
		query.append("        WHERE E.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("        AND   E.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   E.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   E.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   (" ).append("\n"); 
		query.append("            EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                FROM PRI_RP_SCP_RT_ROUT_PNT F" ).append("\n"); 
		query.append("                WHERE F.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                AND   F.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                AND   F.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND   F.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND   F.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                AND   F.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            OR EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                FROM PRI_RP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("                WHERE G.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                AND   G.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                AND   G.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND   G.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND   G.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                AND   G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            OR EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                FROM PRI_RP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("                WHERE I.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                AND   I.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                AND   I.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND   I.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND   I.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                AND   I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            OR EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                FROM PRI_RP_SCP_RT J" ).append("\n"); 
		query.append("                WHERE J.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                AND   J.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                AND   J.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND   J.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND   J.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                AND   J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}