/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAORqCpPriRpScpRtRoutViaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.16 송민석
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

public class RFARateProposalDBDAORqCpPriRpScpRtRoutViaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RqCpPriRpScpRtRoutVia
	  * </pre>
	  */
	public RFARateProposalDBDAORqCpPriRpScpRtRoutViaCSQL(){
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
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORqCpPriRpScpRtRoutViaCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_ROUT_VIA (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    , ROUT_SEQ" ).append("\n"); 
		query.append("    , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("    , ROUT_VIA_SEQ" ).append("\n"); 
		query.append("    , ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("    , ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("    , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("    , SRC_INFO_CD" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("    SELECT A.QTTN_NO" ).append("\n"); 
		query.append("         , A.QTTN_VER_NO" ).append("\n"); 
		query.append("         , A.CMDT_HDR_SEQ AS OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY A.QTTN_NO, A.QTTN_VER_NO" ).append("\n"); 
		query.append("                              ORDER BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    FROM PRI_RQ_RT_CMDT_HDR A" ).append("\n"); 
		query.append("    WHERE A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("    AND   A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("    AND   (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RQ_RT_CMDT B" ).append("\n"); 
		query.append("            WHERE B.QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("            AND   B.QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("            AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RQ_RT_CMDT_ROUT E" ).append("\n"); 
		query.append("            WHERE E.QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("            AND   E.QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("            AND   E.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   (" ).append("\n"); 
		query.append("                EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RQ_RT_ROUT_PNT F" ).append("\n"); 
		query.append("                    WHERE F.QTTN_NO = E.QTTN_NO" ).append("\n"); 
		query.append("                    AND   F.QTTN_VER_NO = E.QTTN_VER_NO" ).append("\n"); 
		query.append("                    AND   F.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   F.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RQ_RT_ROUT_VIA G" ).append("\n"); 
		query.append("                    WHERE G.QTTN_NO = E.QTTN_NO" ).append("\n"); 
		query.append("                    AND   G.QTTN_VER_NO = E.QTTN_VER_NO" ).append("\n"); 
		query.append("                    AND   G.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   G.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RQ_RT J" ).append("\n"); 
		query.append("                    WHERE J.QTTN_NO = E.QTTN_NO" ).append("\n"); 
		query.append("                    AND   J.QTTN_VER_NO = E.QTTN_VER_NO" ).append("\n"); 
		query.append("                    AND   J.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   J.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CMDT_ROUT AS (" ).append("\n"); 
		query.append("    SELECT L.QTTN_NO" ).append("\n"); 
		query.append("         , L.QTTN_VER_NO" ).append("\n"); 
		query.append("         , K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , K.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , L.ROUT_SEQ AS OLD_ROUT_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY L.QTTN_NO, L.QTTN_VER_NO, K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ORDER BY L.QTTN_NO, L.QTTN_VER_NO, K.OLD_CMDT_HDR_SEQ, L.ROUT_SEQ) AS ROUT_SEQ" ).append("\n"); 
		query.append("    FROM CMDT_HDR K" ).append("\n"); 
		query.append("        ,PRI_RQ_RT_CMDT_ROUT L" ).append("\n"); 
		query.append("    WHERE L.QTTN_NO = K.QTTN_NO" ).append("\n"); 
		query.append("    AND   L.QTTN_VER_NO = K.QTTN_VER_NO" ).append("\n"); 
		query.append("    AND   L.CMDT_HDR_SEQ = K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RQ_RT_ROUT_PNT F" ).append("\n"); 
		query.append("            WHERE F.QTTN_NO = L.QTTN_NO" ).append("\n"); 
		query.append("            AND   F.QTTN_VER_NO = L.QTTN_VER_NO" ).append("\n"); 
		query.append("            AND   F.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   F.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RQ_RT_ROUT_VIA G" ).append("\n"); 
		query.append("            WHERE G.QTTN_NO = L.QTTN_NO" ).append("\n"); 
		query.append("            AND   G.QTTN_VER_NO = L.QTTN_VER_NO" ).append("\n"); 
		query.append("            AND   G.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   G.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RQ_RT J" ).append("\n"); 
		query.append("            WHERE J.QTTN_NO = L.QTTN_NO" ).append("\n"); 
		query.append("            AND   J.QTTN_VER_NO = L.QTTN_VER_NO" ).append("\n"); 
		query.append("            AND   J.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   J.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , Z.SVC_SCP_CD" ).append("\n"); 
		query.append("     , R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , R.ROUT_SEQ" ).append("\n"); 
		query.append("     , S.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY S.QTTN_NO, S.QTTN_VER_NO" ).append("\n"); 
		query.append("                                     , S.CMDT_HDR_SEQ, S.ROUT_SEQ, S.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                          ORDER BY S.QTTN_NO, S.QTTN_VER_NO" ).append("\n"); 
		query.append("                                 , S.CMDT_HDR_SEQ, S.ROUT_SEQ, S.ORG_DEST_TP_CD, S.ROUT_VIA_SEQ) AS ROUT_VIA_SEQ" ).append("\n"); 
		query.append("     , S.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("     , S.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("     , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , S.SRC_INFO_CD" ).append("\n"); 
		query.append("     , 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM CMDT_ROUT R" ).append("\n"); 
		query.append("    ,PRI_RQ_RT_ROUT_VIA S" ).append("\n"); 
		query.append("    ,PRI_RQ_MN Z" ).append("\n"); 
		query.append("WHERE S.QTTN_NO = R.QTTN_NO" ).append("\n"); 
		query.append("AND   S.QTTN_VER_NO = R.QTTN_VER_NO" ).append("\n"); 
		query.append("AND   S.CMDT_HDR_SEQ = R.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   S.ROUT_SEQ = R.OLD_ROUT_SEQ" ).append("\n"); 
		query.append("AND   S.QTTN_NO = Z.QTTN_NO" ).append("\n"); 
		query.append("AND   S.QTTN_VER_NO = Z.QTTN_VER_NO" ).append("\n"); 

	}
}