/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvCopyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScNoteConvCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COPY된 데이터를 조회한다.
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvCopyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvCopyVORSQL").append("\n"); 
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
		query.append("SELECT    '' NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("		, '0' NOTE_CONV_SEQ" ).append("\n"); 
		query.append("		, NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("		, SVC_SCP_CD" ).append("\n"); 
		query.append("		, PROP_NO" ).append("\n"); 
		query.append("		, AMDT_SEQ" ).append("\n"); 
		query.append("		, CASE WHEN CHG_RULE_TP_CD = 'C' THEN NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("			   WHEN CHG_RULE_TP_CD = 'R' THEN NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("			   END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("		, CHG_RULE_TP_CD" ).append("\n"); 
		query.append("		, NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("		, NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("		, TO_CHAR(EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("		, TO_CHAR(EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("		, RT_APPL_TP_CD" ).append("\n"); 
		query.append("		, RT_OP_CD" ).append("\n"); 
		query.append("		, CURR_CD" ).append("\n"); 
		query.append("		, FRT_RT_AMT" ).append("\n"); 
		query.append("		, PAY_TERM_CD" ).append("\n"); 
		query.append("		, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("		, BKG_RAT_UT_CD" ).append("\n"); 
		query.append("		, BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		, BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("		, BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("		, BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("		, BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("		, BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("		, BKG_POR_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POR_TP_CD, 'T', SUBSTR(BKG_POR_DEF_CD, 3), BKG_POR_DEF_CD) BKG_POR_DEF_CD" ).append("\n"); 
		query.append("		, BKG_POL_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POL_TP_CD, 'T', SUBSTR(BKG_POL_DEF_CD, 3), BKG_POL_DEF_CD) BKG_POL_DEF_CD" ).append("\n"); 
		query.append("		, BKG_POD_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POD_TP_CD, 'T', SUBSTR(BKG_POD_DEF_CD, 3), BKG_POD_DEF_CD) BKG_POD_DEF_CD" ).append("\n"); 
		query.append("		, BKG_DEL_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_DEL_TP_CD, 'T', SUBSTR(BKG_DEL_DEF_CD, 3), BKG_DEL_DEF_CD) BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("		, BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("		, BKG_DE_TERM_CD" ).append("\n"); 
		query.append("		, BKG_SLAN_CD" ).append("\n"); 
		query.append("		, (BKG_VSL_CD||BKG_SKD_VOY_NO||BKG_SKD_DIR_CD) BKG_VVD_CD" ).append("\n"); 
		query.append("		, BKG_VSL_CD" ).append("\n"); 
		query.append("		, BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("		, BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("		, BKG_SOC_FLG" ).append("\n"); 
		query.append("		, (BKG_ACT_CUST_CNT_CD||LPAD(BKG_ACT_CUST_SEQ,6,0)) BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("		, BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("		, BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("		, BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("		, BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("		, BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("		, BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("		, CONV_RAT_UT_CD" ).append("\n"); 
		query.append("		, CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		, CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("		, CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("		, CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("		, DECODE(CONV_ORG_LOC_TP_CD, 'T', SUBSTR(CONV_ORG_LOC_DEF_CD, 3), CONV_ORG_LOC_DEF_CD) CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("		, CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("		, DECODE(CONV_ORG_VIA_LOC_TP_CD, 'T', SUBSTR(CONV_ORG_VIA_LOC_DEF_CD, 3), CONV_ORG_VIA_LOC_DEF_CD) CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("		, CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("		, DECODE(CONV_DEST_VIA_LOC_TP_CD, 'T', SUBSTR(CONV_DEST_VIA_LOC_DEF_CD, 3), CONV_DEST_VIA_LOC_DEF_CD) CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("		, CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("		, DECODE(CONV_DEST_LOC_TP_CD, 'T', SUBSTR(CONV_DEST_LOC_DEF_CD, 3), CONV_DEST_LOC_DEF_CD) CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("		, CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("		, CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("		, NOTE_HDR_SEQ" ).append("\n"); 
		query.append("		, RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, DECODE(BKG_POR_TP_CD, 'T', SUBSTR(BKG_POR_DEF_CD, 1, 2), '') BKG_POR_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POL_TP_CD, 'T', SUBSTR(BKG_POL_DEF_CD, 1, 2), '') BKG_POL_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POD_TP_CD, 'T', SUBSTR(BKG_POD_DEF_CD, 1, 2), '') BKG_POD_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_DEL_TP_CD, 'T', SUBSTR(BKG_DEL_DEF_CD, 1, 2), '') BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(CONV_ORG_LOC_TP_CD, 'T', SUBSTR(CONV_ORG_LOC_DEF_CD, 1, 2), '') 			CONV_ORG_LOC_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(CONV_ORG_VIA_LOC_TP_CD, 'T', SUBSTR(CONV_ORG_VIA_LOC_DEF_CD, 1, 2), '') 	CONV_ORG_VIA_LOC_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(CONV_DEST_VIA_LOC_TP_CD, 'T', SUBSTR(CONV_DEST_VIA_LOC_DEF_CD, 1, 2), '') 	CONV_DEST_VIA_LOC_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(CONV_DEST_LOC_TP_CD, 'T', SUBSTR(CONV_DEST_LOC_DEF_CD, 1, 2), '') 			CONV_DEST_LOC_CNT_CD" ).append("\n"); 
		query.append("		, BKG_IO_GA_CD" ).append("\n"); 
		query.append("		, BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("		, BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("        , BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("        , BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("	 FROM PRI_SC_NOTE_CONV_CPY" ).append("\n"); 
		query.append("    WHERE USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	ORDER BY CHG_RULE_DEF_CD" ).append("\n"); 

	}
}