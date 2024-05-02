/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRnoteMstCSQL.java
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

public class RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRnoteMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA에서 Copy 시 사용
	  * </pre>
	  */
	public RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRnoteMstCSQL(){
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
		query.append("FileName : RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRnoteMstCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_CMDT_RNOTE (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    , ROUT_SEQ" ).append("\n"); 
		query.append("    , ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("    , NOTE_CTNT" ).append("\n"); 
		query.append("    , NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("    , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("    , SRC_INFO_CD" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH NOTE_CONTS AS (" ).append("\n"); 
		query.append("    SELECT A.PROP_NO" ).append("\n"); 
		query.append("         ,A.AMDT_SEQ" ).append("\n"); 
		query.append("         ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("         ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         ,A.ROUT_SEQ" ).append("\n"); 
		query.append("          , CASE WHEN NOTE_CONV_CHG_CD IS NULL" ).append("\n"); 
		query.append("                 THEN NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("                 WHEN NOTE_CONV_RULE_CD IS NULL" ).append("\n"); 
		query.append("                 THEN NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("            ELSE NOTE_CONV_RULE_CD ||','|| NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("             END AS NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("        SELECT A.PROP_NO" ).append("\n"); 
		query.append("             ,A.AMDT_SEQ" ).append("\n"); 
		query.append("             ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("             ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             ,A.ROUT_SEQ" ).append("\n"); 
		query.append("             ,WM_CONCAT(DISTINCT(NOTE_CONV_CHG_CD)) AS NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("             ,WM_CONCAT(DISTINCT(NOTE_CONV_RULE_CD)) AS NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("         FROM PRI_RP_SCP_RT_CMDT_RNOTE A, PRI_RFA_NOTE_CONV B " ).append("\n"); 
		query.append("        WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("          AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("          AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("          AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("          AND A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("          AND B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        GROUP BY A.PROP_NO" ).append("\n"); 
		query.append("                ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,A.ROUT_SEQ" ).append("\n"); 
		query.append("     ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , @[new_amdt_seq]+1  AS AMDT_SEQ" ).append("\n"); 
		query.append("     , S.SVC_SCP_CD" ).append("\n"); 
		query.append("     , S.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , @[new_rout_seq] ROUT_SEQ" ).append("\n"); 
		query.append("     , S.ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("     , N.NOTE_CONV_CHG_CD NOTE_CTNT" ).append("\n"); 
		query.append("     , TO_SINGLE_BYTE(SYS_GUID()) AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , 'NW' AS SRC_INFO_CD" ).append("\n"); 
		query.append("     , @[new_amdt_seq]+1  AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM  PRI_RP_SCP_RT_CMDT_RNOTE S" ).append("\n"); 
		query.append("    ,NOTE_CONTS N" ).append("\n"); 
		query.append("WHERE  S.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND   S.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND   S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	AND   S.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("	AND   S.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND   S.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("	AND   N.PROP_NO = S.PROP_NO" ).append("\n"); 
		query.append("	AND   N.AMDT_SEQ = S.AMDT_SEQ" ).append("\n"); 
		query.append("	AND   N.SVC_SCP_CD = S.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND   N.CMDT_HDR_SEQ = S.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	AND   N.ROUT_SEQ = S.ROUT_SEQ" ).append("\n"); 

	}
}