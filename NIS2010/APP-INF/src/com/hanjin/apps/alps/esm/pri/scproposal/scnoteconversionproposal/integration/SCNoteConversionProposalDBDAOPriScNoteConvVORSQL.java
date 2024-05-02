/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.12.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScNoteConvVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvVORSQL").append("\n"); 
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
		query.append("SELECT    A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("		, A.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("		, A.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("		, A.SVC_SCP_CD" ).append("\n"); 
		query.append("		, A.PROP_NO" ).append("\n"); 
		query.append("		, A.AMDT_SEQ" ).append("\n"); 
		query.append("		, CASE WHEN A.CHG_RULE_TP_CD = 'C' THEN NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("			   WHEN A.CHG_RULE_TP_CD = 'R' THEN NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("			   END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("		, A.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("		, A.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("		, A.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("		, TO_CHAR(A.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("		, TO_CHAR(A.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("		, A.RT_APPL_TP_CD" ).append("\n"); 
		query.append("		, A.RT_OP_CD" ).append("\n"); 
		query.append("		, A.CURR_CD" ).append("\n"); 
		query.append("		, A.FRT_RT_AMT" ).append("\n"); 
		query.append("		, A.PAY_TERM_CD" ).append("\n"); 
		query.append("		, A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("		, A.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("		, A.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		, A.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("		, A.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("		, A.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("		, A.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("		, A.BKG_POR_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POR_TP_CD, 'T', SUBSTR(A.BKG_POR_DEF_CD, 3), A.BKG_POR_DEF_CD) BKG_POR_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_POL_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POL_TP_CD, 'T', SUBSTR(A.BKG_POL_DEF_CD, 3), A.BKG_POL_DEF_CD) BKG_POL_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_POD_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POD_TP_CD, 'T', SUBSTR(A.BKG_POD_DEF_CD, 3), A.BKG_POD_DEF_CD) BKG_POD_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_DEL_TP_CD, 'T', SUBSTR(A.BKG_DEL_DEF_CD, 3), A.BKG_DEL_DEF_CD) BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, A.BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, A.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("		, A.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("		, A.BKG_SLAN_CD" ).append("\n"); 
		query.append("		, (A.BKG_VSL_CD||A.BKG_SKD_VOY_NO||A.BKG_SKD_DIR_CD) BKG_VVD_CD" ).append("\n"); 
		query.append("		, A.BKG_VSL_CD" ).append("\n"); 
		query.append("		, A.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("		, A.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("		, A.BKG_SOC_FLG" ).append("\n"); 
		query.append("		, (A.BKG_ACT_CUST_CNT_CD||LPAD(A.BKG_ACT_CUST_SEQ,6,0)) BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("		, A.BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("		, A.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("		, A.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("		, A.BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("		, A.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("		, A.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		, A.CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("		, A.CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("		, A.CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.CONV_ORG_LOC_TP_CD, 'T', SUBSTR(A.CONV_ORG_LOC_DEF_CD, 3), A.CONV_ORG_LOC_DEF_CD) CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("		, A.CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.CONV_ORG_VIA_LOC_TP_CD, 'T', SUBSTR(A.CONV_ORG_VIA_LOC_DEF_CD, 3), A.CONV_ORG_VIA_LOC_DEF_CD) CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("		, A.CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.CONV_DEST_VIA_LOC_TP_CD, 'T', SUBSTR(A.CONV_DEST_VIA_LOC_DEF_CD, 3), A.CONV_DEST_VIA_LOC_DEF_CD) CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("		, A.CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.CONV_DEST_LOC_TP_CD, 'T', SUBSTR(A.CONV_DEST_LOC_DEF_CD, 3), A.CONV_DEST_LOC_DEF_CD) CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("		, A.CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("		, A.CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("		, A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("		, A.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("		, TO_CHAR(A.UPD_DT,'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("		, (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POR_TP_CD, 'T', SUBSTR(A.BKG_POR_DEF_CD, 1, 2), '') BKG_POR_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POL_TP_CD, 'T', SUBSTR(A.BKG_POL_DEF_CD, 1, 2), '') BKG_POL_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POD_TP_CD, 'T', SUBSTR(A.BKG_POD_DEF_CD, 1, 2), '') BKG_POD_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_DEL_TP_CD, 'T', SUBSTR(A.BKG_DEL_DEF_CD, 1, 2), '') BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.CONV_ORG_LOC_TP_CD, 'T', SUBSTR(A.CONV_ORG_LOC_DEF_CD, 1, 2), '') 			CONV_ORG_LOC_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.CONV_ORG_VIA_LOC_TP_CD, 'T', SUBSTR(A.CONV_ORG_VIA_LOC_DEF_CD, 1, 2), '') 	CONV_ORG_VIA_LOC_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.CONV_DEST_VIA_LOC_TP_CD, 'T', SUBSTR(A.CONV_DEST_VIA_LOC_DEF_CD, 1, 2), '') 	CONV_DEST_VIA_LOC_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.CONV_DEST_LOC_TP_CD, 'T', SUBSTR(A.CONV_DEST_LOC_DEF_CD, 1, 2), '') 			CONV_DEST_LOC_CNT_CD" ).append("\n"); 
		query.append("		, A.BKG_IO_GA_CD" ).append("\n"); 
		query.append("		, A.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("		, A.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("		, A.RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("        , A.RT_PATT_TP_CD" ).append("\n"); 
		query.append("        , A.IGN_TRF_FLG" ).append("\n"); 
		query.append("		, A.BKG_NO" ).append("\n"); 
		query.append("	 FROM PRI_SC_NOTE_CONV A" ).append("\n"); 
		query.append("	WHERE A.NOTE_CONV_MAPG_ID = @[note_conv_mapg_id]" ).append("\n"); 
		query.append("	ORDER BY CHG_RULE_TP_CD" ).append("\n"); 

	}
}