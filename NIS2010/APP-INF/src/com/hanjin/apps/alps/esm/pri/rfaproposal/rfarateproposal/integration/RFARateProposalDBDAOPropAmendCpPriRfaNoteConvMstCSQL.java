/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFARateProposalDBDAOPropAmendCpPriRfaNoteConvMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.10.26 송민석
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

public class RFARateProposalDBDAOPropAmendCpPriRfaNoteConvMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic RFA에서 Auto Amend시사용
	  * </pre>
	  */
	public RFARateProposalDBDAOPropAmendCpPriRfaNoteConvMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mst_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPropAmendCpPriRfaNoteConvMstCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RFA_NOTE_CONV (" ).append("\n"); 
		query.append("          NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        , NOTE_CONV_SEQ" ).append("\n"); 
		query.append("        , NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("        , SVC_SCP_CD" ).append("\n"); 
		query.append("        , PROP_NO" ).append("\n"); 
		query.append("        , AMDT_SEQ" ).append("\n"); 
		query.append("        , CHG_RULE_TP_CD" ).append("\n"); 
		query.append("        , NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("        , NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("        , EFF_DT" ).append("\n"); 
		query.append("        , EXP_DT" ).append("\n"); 
		query.append("        , RT_APPL_TP_CD" ).append("\n"); 
		query.append("        , RT_OP_CD" ).append("\n"); 
		query.append("        , CURR_CD" ).append("\n"); 
		query.append("        , FRT_RT_AMT" ).append("\n"); 
		query.append("        , PAY_TERM_CD" ).append("\n"); 
		query.append("        , BKG_RAT_UT_CD" ).append("\n"); 
		query.append("        , BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("        , BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("        , BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("        , BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("        , BKG_POR_TP_CD" ).append("\n"); 
		query.append("        , BKG_POR_DEF_CD" ).append("\n"); 
		query.append("        , BKG_POL_TP_CD" ).append("\n"); 
		query.append("        , BKG_POL_DEF_CD" ).append("\n"); 
		query.append("        , BKG_POD_TP_CD" ).append("\n"); 
		query.append("        , BKG_POD_DEF_CD" ).append("\n"); 
		query.append("        , BKG_DEL_TP_CD" ).append("\n"); 
		query.append("        , BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("        , BKG_SLAN_CD" ).append("\n"); 
		query.append("        , BKG_VSL_CD" ).append("\n"); 
		query.append("        , BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("        , BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("        , BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("        , BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("        , BKG_SOC_FLG" ).append("\n"); 
		query.append("        , BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("        , BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("        , BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("        , BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , BKG_YD_CD" ).append("\n"); 
		query.append("        , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("        , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("        , SRC_INFO_CD" ).append("\n"); 
		query.append("        , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	, MST_RFA_ROUT_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH   NOTE_CONTS AS (" ).append("\n"); 
		query.append("	SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_NOTE_SEQ, NOTE_CTNT, NOTE_CONV_MAPG_ID, PRC_PROG_STS_CD, SRC_INFO_CD, N1ST_CMNC_AMDT_SEQ, ACPT_USR_ID, ACPT_OFC_CD, ACPT_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT " ).append("\n"); 
		query.append("	FROM  PRI_RP_SCP_RT_CMDT_RNOTE S" ).append("\n"); 
		query.append("	WHERE  S.PROP_NO = @[new_prop_no]" ).append("\n"); 
		query.append("		AND   S.AMDT_SEQ = @[new_amdt_seq]+1" ).append("\n"); 
		query.append("		AND   S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("		AND   S.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("		AND   S.ROUT_SEQ = @[new_rout_seq]" ).append("\n"); 
		query.append("		AND   S.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" ,MST_NOTE_CONTS AS (" ).append("\n"); 
		query.append("	SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_NOTE_SEQ, NOTE_CTNT, NOTE_CONV_MAPG_ID, PRC_PROG_STS_CD, SRC_INFO_CD, N1ST_CMNC_AMDT_SEQ, ACPT_USR_ID, ACPT_OFC_CD, ACPT_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT " ).append("\n"); 
		query.append("	FROM  PRI_RP_SCP_RT_CMDT_RNOTE S" ).append("\n"); 
		query.append("	WHERE  S.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("		AND   S.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		AND   S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("		AND   S.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("		AND   S.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("		AND   S.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT (SELECT NOTE_CONV_MAPG_ID FROM NOTE_CONTS WHERE ROWNUM=1) AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY V.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                          ORDER BY V.NOTE_CONV_MAPG_ID, V.NOTE_CONV_SEQ) AS NOTE_CONV_SEQ" ).append("\n"); 
		query.append("     , V.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("     , N.SVC_SCP_CD" ).append("\n"); 
		query.append("     ,  @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , @[new_amdt_seq]+1  AS AMDT_SEQ" ).append("\n"); 
		query.append("     , V.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("     , V.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("     , V.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("     , TO_DATE(NVL(@[eff_dt], '9999-12-31'), 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_DATE(NVL(@[exp_dt], '9999-12-31'), 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("     , V.RT_APPL_TP_CD" ).append("\n"); 
		query.append("     , V.RT_OP_CD" ).append("\n"); 
		query.append("     , V.CURR_CD" ).append("\n"); 
		query.append("     , V.FRT_RT_AMT" ).append("\n"); 
		query.append("     , V.PAY_TERM_CD" ).append("\n"); 
		query.append("     , V.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("     , V.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , V.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_POR_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_POL_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_POD_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_SLAN_CD" ).append("\n"); 
		query.append("     , V.BKG_VSL_CD" ).append("\n"); 
		query.append("     , V.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("     , V.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("     , V.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("     , V.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("     , V.BKG_SOC_FLG" ).append("\n"); 
		query.append("     , V.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("     , V.BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , V.BKG_YD_CD" ).append("\n"); 
		query.append("     , V.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("     , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , 'NW' AS SRC_INFO_CD" ).append("\n"); 
		query.append("     , @[new_amdt_seq]+1  AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      , CASE WHEN @[mst_rfa_no] IS NULL THEN V.MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("     	    ELSE @[mst_rfa_no] || '_' || LPAD(@[amdt_seq], 3, '0') || '_' || LPAD(@[rout_seq], 3, '0')" ).append("\n"); 
		query.append("       END AS MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("FROM  PRI_RFA_NOTE_CONV V" ).append("\n"); 
		query.append("    , MST_NOTE_CONTS N" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	V.NOTE_CONV_MAPG_ID = N.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("	 AND V.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}