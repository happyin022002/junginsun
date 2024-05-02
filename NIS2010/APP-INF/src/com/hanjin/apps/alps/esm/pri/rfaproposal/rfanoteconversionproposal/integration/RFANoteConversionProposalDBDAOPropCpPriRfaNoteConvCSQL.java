/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAOPropCpPriRfaNoteConvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.31 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteConversionProposalDBDAOPropCpPriRfaNoteConvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Note Conversion Copy
	  * </pre>
	  */
	public RFANoteConversionProposalDBDAOPropCpPriRfaNoteConvCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration").append("\n"); 
		query.append("FileName : RFANoteConversionProposalDBDAOPropCpPriRfaNoteConvCSQL").append("\n"); 
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
		query.append(")" ).append("\n"); 
		query.append("WITH PRE_NOTE AS (" ).append("\n"); 
		query.append("    SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("         , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("         , B.SVC_SCP_CD" ).append("\n"); 
		query.append("         , B.NOTE_TP_CD" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.NOTE_TP_CD" ).append("\n"); 
		query.append("                              ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.NOTE_TP_CD, A.DP_SEQ, A.NOTE_SEQ) AS NOTE_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.NOTE_TP_CD, A.NOTE_SEQ" ).append("\n"); 
		query.append("                              ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.NOTE_TP_CD, A.NOTE_SEQ, B.NOTE_CTNT_SEQ) AS NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("         , B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_NOTE A" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_NOTE_CTNT B" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND   A.NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("    AND   B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("    AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   B.NOTE_TP_CD = A.NOTE_TP_CD" ).append("\n"); 
		query.append("    AND   B.NOTE_SEQ = A.NOTE_SEQ" ).append("\n"); 
		query.append("    AND   B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NEW_CONV AS (" ).append("\n"); 
		query.append("    SELECT C.PROP_NO" ).append("\n"); 
		query.append("         , C.AMDT_SEQ" ).append("\n"); 
		query.append("         , C.SVC_SCP_CD" ).append("\n"); 
		query.append("         , C.NOTE_TP_CD" ).append("\n"); 
		query.append("         , C.NOTE_SEQ" ).append("\n"); 
		query.append("         , C.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("         , C.NOTE_CONV_MAPG_ID AS OLD_CONV_MAPG_ID" ).append("\n"); 
		query.append("         , D.NOTE_CONV_MAPG_ID AS NEW_CONV_MAPG_ID" ).append("\n"); 
		query.append("    FROM PRE_NOTE C" ).append("\n"); 
		query.append("       , PRI_RP_SCP_NOTE_CTNT D" ).append("\n"); 
		query.append("    WHERE D.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("    AND   D.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   D.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   D.NOTE_TP_CD = C.NOTE_TP_CD" ).append("\n"); 
		query.append("    AND   D.NOTE_SEQ = C.NOTE_SEQ" ).append("\n"); 
		query.append("    AND   D.NOTE_CTNT_SEQ = C.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT F.NEW_CONV_MAPG_ID AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY E.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                          ORDER BY E.NOTE_CONV_MAPG_ID, E.NOTE_CONV_SEQ) AS NOTE_CONV_SEQ" ).append("\n"); 
		query.append("     , E.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("     , F.SVC_SCP_CD" ).append("\n"); 
		query.append("     , F.PROP_NO" ).append("\n"); 
		query.append("     , F.AMDT_SEQ" ).append("\n"); 
		query.append("     , E.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("     , E.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("     , E.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , E.RT_APPL_TP_CD" ).append("\n"); 
		query.append("     , E.RT_OP_CD" ).append("\n"); 
		query.append("     , E.CURR_CD" ).append("\n"); 
		query.append("     , E.FRT_RT_AMT" ).append("\n"); 
		query.append("     , E.PAY_TERM_CD" ).append("\n"); 
		query.append("     , E.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("     , E.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , E.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , E.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("     , E.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , E.BKG_POR_TP_CD" ).append("\n"); 
		query.append("     , E.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("     , E.BKG_POL_TP_CD" ).append("\n"); 
		query.append("     , E.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("     , E.BKG_POD_TP_CD" ).append("\n"); 
		query.append("     , E.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("     , E.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("     , E.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("     , E.BKG_SLAN_CD" ).append("\n"); 
		query.append("     , E.BKG_VSL_CD" ).append("\n"); 
		query.append("     , E.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("     , E.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("     , E.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("     , E.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("     , E.BKG_SOC_FLG" ).append("\n"); 
		query.append("     , E.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("     , E.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("     , E.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("     , E.BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , E.BKG_YD_CD" ).append("\n"); 
		query.append("     , E.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("FROM PRI_RFA_NOTE_CONV E" ).append("\n"); 
		query.append("   , NEW_CONV F" ).append("\n"); 
		query.append("WHERE E.NOTE_CONV_MAPG_ID = F.OLD_CONV_MAPG_ID" ).append("\n"); 

	}
}