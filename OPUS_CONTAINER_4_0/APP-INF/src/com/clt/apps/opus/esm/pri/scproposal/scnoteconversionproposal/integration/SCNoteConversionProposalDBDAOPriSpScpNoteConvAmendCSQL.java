/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.05.24 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SUNGMIN CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * amend cancel 시 이전 mapping id에 해당하는 데이터를 조회해서 insert한다.
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bef_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prev_note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SC_NOTE_CONV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	   NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("	 , NOTE_CONV_SEQ" ).append("\n"); 
		query.append("	 , NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("	 , SVC_SCP_CD" ).append("\n"); 
		query.append("	 , PROP_NO" ).append("\n"); 
		query.append("	 , AMDT_SEQ" ).append("\n"); 
		query.append("	 , CHG_RULE_TP_CD" ).append("\n"); 
		query.append("	 , NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("	 , NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("	 , EFF_DT" ).append("\n"); 
		query.append("	 , EXP_DT" ).append("\n"); 
		query.append("	 , RT_APPL_TP_CD" ).append("\n"); 
		query.append("	 , RT_OP_CD" ).append("\n"); 
		query.append("	 , CURR_CD" ).append("\n"); 
		query.append("	 , FRT_RT_AMT" ).append("\n"); 
		query.append("	 , PAY_TERM_CD" ).append("\n"); 
		query.append("	 , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	 , BKG_RAT_UT_CD" ).append("\n"); 
		query.append("	 , BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	 , BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	 , BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("	 , BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("	 , BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("	 , BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("	 , BKG_POR_TP_CD" ).append("\n"); 
		query.append("	 , BKG_POR_DEF_CD" ).append("\n"); 
		query.append("	 , BKG_POL_TP_CD" ).append("\n"); 
		query.append("	 , BKG_POL_DEF_CD" ).append("\n"); 
		query.append("	 , BKG_POD_TP_CD" ).append("\n"); 
		query.append("	 , BKG_POD_DEF_CD" ).append("\n"); 
		query.append("	 , BKG_DEL_TP_CD" ).append("\n"); 
		query.append("	 , BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("	 , BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("	 , BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("	 , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	 , BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	 , BKG_SLAN_CD" ).append("\n"); 
		query.append("	 , BKG_VSL_CD" ).append("\n"); 
		query.append("	 , BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("	 , BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("	 , BKG_SOC_FLG" ).append("\n"); 
		query.append("	 , BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("	 , BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("	 , BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("	 , BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("	 , BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("	 , BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("	 , CONV_RAT_UT_CD" ).append("\n"); 
		query.append("	 , CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	 , CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("	 , CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("	 , CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("	 , CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("	 , CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("	 , CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("	 , CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("	 , CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("	 , CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("	 , CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("	 , CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("	 , CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("	 , CRE_USR_ID" ).append("\n"); 
		query.append("	 , CRE_DT" ).append("\n"); 
		query.append("	 , UPD_USR_ID" ).append("\n"); 
		query.append("	 , UPD_DT" ).append("\n"); 
		query.append("	 , NOTE_HDR_SEQ" ).append("\n"); 
		query.append("	 , RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("	 , BKG_IO_GA_CD" ).append("\n"); 
		query.append("	 , BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("	 , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[note_conv_mapg_id]" ).append("\n"); 
		query.append(" 	 , NOTE_CONV_SEQ" ).append("\n"); 
		query.append(" 	 , NOTE_CONV_TP_CD" ).append("\n"); 
		query.append(" 	 , SVC_SCP_CD" ).append("\n"); 
		query.append(" 	 , PROP_NO" ).append("\n"); 
		query.append(" 	 , @[amdt_seq]" ).append("\n"); 
		query.append(" 	 , CHG_RULE_TP_CD" ).append("\n"); 
		query.append(" 	 , NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append(" 	 , NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append(" 	 , CASE WHEN EFF_DT < TO_DATE(@[eff_dt],'YYYYMMDD') THEN TO_DATE(@[eff_dt],'YYYYMMDD') ELSE EFF_DT END" ).append("\n"); 
		query.append(" 	 , CASE WHEN EXP_DT = TO_DATE(@[bef_exp_dt],'YYYYMMDD') THEN TO_DATE(@[exp_dt],'YYYYMMDD') " ).append("\n"); 
		query.append("			WHEN EXP_DT > TO_DATE(@[exp_dt],'YYYYMMDD') THEN TO_DATE(@[exp_dt],'YYYYMMDD') ELSE EXP_DT END" ).append("\n"); 
		query.append(" 	 , RT_APPL_TP_CD" ).append("\n"); 
		query.append(" 	 , RT_OP_CD" ).append("\n"); 
		query.append(" 	 , CURR_CD" ).append("\n"); 
		query.append(" 	 , FRT_RT_AMT" ).append("\n"); 
		query.append(" 	 , PAY_TERM_CD" ).append("\n"); 
		query.append(" 	 , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_RAT_UT_CD" ).append("\n"); 
		query.append(" 	 , BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(" 	 , BKG_CMDT_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append(" 	 , BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append(" 	 , BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append(" 	 , BKG_POR_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_POR_DEF_CD" ).append("\n"); 
		query.append(" 	 , BKG_POL_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_POL_DEF_CD" ).append("\n"); 
		query.append(" 	 , BKG_POD_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_POD_DEF_CD" ).append("\n"); 
		query.append(" 	 , BKG_DEL_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_DEL_DEF_CD" ).append("\n"); 
		query.append(" 	 , BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append(" 	 , BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append(" 	 , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(" 	 , BKG_DE_TERM_CD" ).append("\n"); 
		query.append(" 	 , BKG_SLAN_CD" ).append("\n"); 
		query.append(" 	 , BKG_VSL_CD" ).append("\n"); 
		query.append(" 	 , BKG_SKD_VOY_NO" ).append("\n"); 
		query.append(" 	 , BKG_SKD_DIR_CD" ).append("\n"); 
		query.append(" 	 , BKG_SOC_FLG" ).append("\n"); 
		query.append(" 	 , BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(" 	 , BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append(" 	 , BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append(" 	 , BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append(" 	 , BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append(" 	 , CONV_RAT_UT_CD" ).append("\n"); 
		query.append(" 	 , CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(" 	 , CONV_CMDT_TP_CD" ).append("\n"); 
		query.append(" 	 , CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append(" 	 , CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append(" 	 , CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append(" 	 , CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append(" 	 , CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append(" 	 , CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append(" 	 , CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append(" 	 , CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append(" 	 , CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(" 	 , CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append(" 	 , CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append(" 	 , CRE_USR_ID" ).append("\n"); 
		query.append(" 	 , CRE_DT" ).append("\n"); 
		query.append(" 	 , UPD_USR_ID" ).append("\n"); 
		query.append(" 	 , UPD_DT" ).append("\n"); 
		query.append(" 	 , NOTE_HDR_SEQ" ).append("\n"); 
		query.append(" 	 , RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append(" 	 , BKG_IO_GA_CD" ).append("\n"); 
		query.append(" 	 , BKG_CNL_TZ_CD" ).append("\n"); 
		query.append(" 	 , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("  FROM PRI_SC_NOTE_CONV" ).append("\n"); 
		query.append(" WHERE NOTE_CONV_MAPG_ID = @[prev_note_conv_mapg_id]" ).append("\n"); 

	}
}