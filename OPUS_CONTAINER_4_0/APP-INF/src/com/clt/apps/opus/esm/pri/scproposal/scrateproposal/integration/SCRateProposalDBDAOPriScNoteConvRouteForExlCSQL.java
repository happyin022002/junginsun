/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCRateProposalDBDAOPriScNoteConvRouteForExlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.17
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2016.10.17 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriScNoteConvRouteForExlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 존재하는 Route Note Conversion 데이터를 Copy 하여 새로 생성한다.
	  * </pre>
	  */
	public SCRateProposalDBDAOPriScNoteConvRouteForExlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration ").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriScNoteConvRouteForExlCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SC_NOTE_CONV (" ).append("\n"); 
		query.append("	NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",	NOTE_CONV_SEQ" ).append("\n"); 
		query.append(",	NOTE_CONV_TP_CD" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	NOTE_HDR_SEQ" ).append("\n"); 
		query.append(",	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	CHG_RULE_TP_CD" ).append("\n"); 
		query.append(",	NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append(",	NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append(",	RT_APPL_TP_CD" ).append("\n"); 
		query.append(",	RT_OP_CD" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	FRT_RT_AMT" ).append("\n"); 
		query.append(",	PAY_TERM_CD" ).append("\n"); 
		query.append(",	GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	BKG_RAT_UT_CD" ).append("\n"); 
		query.append(",	BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	BKG_CMDT_TP_CD" ).append("\n"); 
		query.append(",	BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append(",	BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",	BKG_POR_TP_CD" ).append("\n"); 
		query.append(",	BKG_POR_DEF_CD" ).append("\n"); 
		query.append(",	BKG_POL_TP_CD" ).append("\n"); 
		query.append(",	BKG_POL_DEF_CD" ).append("\n"); 
		query.append(",	BKG_POD_TP_CD" ).append("\n"); 
		query.append(",	BKG_POD_DEF_CD" ).append("\n"); 
		query.append(",	BKG_DEL_TP_CD" ).append("\n"); 
		query.append(",	BKG_DEL_DEF_CD" ).append("\n"); 
		query.append(",	BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",	BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",	BKG_SLAN_CD" ).append("\n"); 
		query.append(",	BKG_VSL_CD" ).append("\n"); 
		query.append(",	BKG_SKD_VOY_NO" ).append("\n"); 
		query.append(",	BKG_SKD_DIR_CD" ).append("\n"); 
		query.append(",	BKG_SOC_FLG" ).append("\n"); 
		query.append(",	BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",	BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",	BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append(",	BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append(",	BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append(",	BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append(",	CONV_RAT_UT_CD" ).append("\n"); 
		query.append(",	CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	CONV_CMDT_TP_CD" ).append("\n"); 
		query.append(",	CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append(",	CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append(",	CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append(",	CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append(",	CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append(",	CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append(",	CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append(",	CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(",	CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append(",	CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	BKG_IO_GA_CD" ).append("\n"); 
		query.append(",	BKG_CNL_TZ_CD" ).append("\n"); 
		query.append(",	BKG_ESVC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT C.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",	N.NOTE_CONV_SEQ" ).append("\n"); 
		query.append(",	N.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append(",	N.SVC_SCP_CD" ).append("\n"); 
		query.append(",	N.NOTE_HDR_SEQ" ).append("\n"); 
		query.append(",	N.PROP_NO" ).append("\n"); 
		query.append(",	N.AMDT_SEQ" ).append("\n"); 
		query.append(",	N.CHG_RULE_TP_CD" ).append("\n"); 
		query.append(",	N.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append(",	N.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append(",	N.EFF_DT" ).append("\n"); 
		query.append(",	N.EXP_DT" ).append("\n"); 
		query.append(",	N.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append(",	N.RT_APPL_TP_CD" ).append("\n"); 
		query.append(",	N.RT_OP_CD" ).append("\n"); 
		query.append(",	N.CURR_CD" ).append("\n"); 
		query.append(",	N.FRT_RT_AMT" ).append("\n"); 
		query.append(",	N.PAY_TERM_CD" ).append("\n"); 
		query.append(",	N.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	N.BKG_RAT_UT_CD" ).append("\n"); 
		query.append(",	N.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	N.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	N.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append(",	N.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	N.BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append(",	N.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",	N.BKG_POR_TP_CD" ).append("\n"); 
		query.append(",	N.BKG_POR_DEF_CD" ).append("\n"); 
		query.append(",	N.BKG_POL_TP_CD" ).append("\n"); 
		query.append(",	N.BKG_POL_DEF_CD" ).append("\n"); 
		query.append(",	N.BKG_POD_TP_CD" ).append("\n"); 
		query.append(",	N.BKG_POD_DEF_CD" ).append("\n"); 
		query.append(",	N.BKG_DEL_TP_CD" ).append("\n"); 
		query.append(",	N.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append(",	N.BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	N.BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	N.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",	N.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",	N.BKG_SLAN_CD" ).append("\n"); 
		query.append(",	N.BKG_VSL_CD" ).append("\n"); 
		query.append(",	N.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append(",	N.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append(",	N.BKG_SOC_FLG" ).append("\n"); 
		query.append(",	N.BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",	N.BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",	N.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append(",	N.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append(",	N.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append(",	N.BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append(",	N.CONV_RAT_UT_CD" ).append("\n"); 
		query.append(",	N.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	N.CONV_CMDT_TP_CD" ).append("\n"); 
		query.append(",	N.CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	N.CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append(",	N.CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append(",	N.CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append(",	N.CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append(",	N.CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append(",	N.CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append(",	N.CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append(",	N.CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(",	N.CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append(",	N.CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append(",   @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",   SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(",   @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",   SYSDATE AS UPD_DT" ).append("\n"); 
		query.append(",	N.BKG_IO_GA_CD" ).append("\n"); 
		query.append(",	N.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append(",	N.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("FROM PRI_SC_NOTE_CONV N" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("    SELECT C.PROP_NO, C.AMDT_SEQ, C.SVC_SCP_CD, C.GEN_SPCL_RT_TP_CD, C.CMDT_HDR_SEQ, C.ROUT_SEQ, C.ROUT_NOTE_SEQ, C.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("         , OLD.NOTE_CONV_MAPG_ID AS OLD_NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      FROM PRI_SP_SCP_RT_CMDT_RNOTE C" ).append("\n"); 
		query.append("         , (  SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_NOTE_SEQ, NOTE_CONV_MAPG_ID " ).append("\n"); 
		query.append("                FROM PRI_SP_SCP_RT_CMDT_RNOTE " ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                  AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                  AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                  AND CMDT_HDR_SEQ = @[acpt_usr_id]" ).append("\n"); 
		query.append("                  AND ROUT_SEQ = @[acpt_ofc_cd]                  " ).append("\n"); 
		query.append("           ) OLD" ).append("\n"); 
		query.append("    WHERE C.PROP_NO = OLD.PROP_NO        " ).append("\n"); 
		query.append("      AND C.AMDT_SEQ = OLD.AMDT_SEQ" ).append("\n"); 
		query.append("      AND C.SVC_SCP_CD = OLD.SVC_SCP_CD" ).append("\n"); 
		query.append("      AND C.GEN_SPCL_RT_TP_CD = OLD.GEN_SPCL_RT_TP_CD    " ).append("\n"); 
		query.append("      AND C.ROUT_NOTE_SEQ = OLD.ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("      AND C.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("      AND C.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("      ) C      " ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("  AND N.NOTE_CONV_MAPG_ID = C.OLD_NOTE_CONV_MAPG_ID" ).append("\n"); 

	}
}