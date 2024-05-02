/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOPriTriNoteConvCpyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOPriTriNoteConvCpyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 붙혀넣기
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOPriTriNoteConvCpyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOPriTriNoteConvCpyVORSQL").append("\n"); 
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
		query.append("SELECT '' NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("		, '0' NOTE_CONV_SEQ" ).append("\n"); 
		query.append("		, A.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("		, A.TRF_PFX_CD" ).append("\n"); 
		query.append("		, A.TRF_NO" ).append("\n"); 
		query.append("		, A.TRI_PROP_NO" ).append("\n"); 
		query.append("		, A.AMDT_SEQ" ).append("\n"); 
		query.append("		, CASE WHEN A.CHG_RULE_TP_CD = 'C' THEN NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("			   WHEN A.CHG_RULE_TP_CD = 'R' THEN NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("			   END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("		, A.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("		, A.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("		, A.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("		, TO_CHAR(A.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("		, TO_CHAR(A.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("		, A.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("		, A.RT_APPL_TP_CD" ).append("\n"); 
		query.append("		, A.RT_OP_CD" ).append("\n"); 
		query.append("		, A.CURR_CD" ).append("\n"); 
		query.append("		, A.FRT_RT_AMT" ).append("\n"); 
		query.append("		, A.PAY_TERM_CD" ).append("\n"); 
		query.append("		, A.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("		, A.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		, A.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("		, A.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("		, A.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("		, A.BKG_POR_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POR_TP_CD, 'T', SUBSTR(A.BKG_POR_DEF_CD, 3), A.BKG_POR_DEF_CD) BKG_POR_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_POL_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POL_TP_CD, 'T', SUBSTR(A.BKG_POL_DEF_CD, 3), A.BKG_POL_DEF_CD) BKG_POL_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_POD_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POD_TP_CD, 'T', SUBSTR(A.BKG_POD_DEF_CD, 3), A.BKG_POD_DEF_CD) BKG_POD_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_DEL_TP_CD, 'T', SUBSTR(A.BKG_DEL_DEF_CD, 3), A.BKG_DEL_DEF_CD) BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("		, A.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("		, A.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("		, A.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("		, A.BKG_SOC_FLG" ).append("\n"); 
		query.append("		, A.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("		, A.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("		, A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("		, A.BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("		, A.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("		, A.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		, A.CRE_USR_ID" ).append("\n"); 
		query.append("		, A.CRE_DT" ).append("\n"); 
		query.append("		, A.UPD_USR_ID" ).append("\n"); 
		query.append("		, A.UPD_DT" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POR_TP_CD, 'T', SUBSTR(A.BKG_POR_DEF_CD, 1, 2), '') BKG_POR_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POL_TP_CD, 'T', SUBSTR(A.BKG_POL_DEF_CD, 1, 2), '') BKG_POL_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_POD_TP_CD, 'T', SUBSTR(A.BKG_POD_DEF_CD, 1, 2), '') BKG_POD_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(A.BKG_DEL_TP_CD, 'T', SUBSTR(A.BKG_DEL_DEF_CD, 1, 2), '') BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("        , A.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("	 FROM PRI_TRI_NOTE_CONV_CPY A" ).append("\n"); 
		query.append("	WHERE A.USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	  AND A.NOTE_CONV_TP_CD = @[note_conv_tp_cd]" ).append("\n"); 
		query.append("	ORDER BY A.BKG_PRC_CGO_TP_CD	ASC NULLS FIRST" ).append("\n"); 
		query.append("		, A.BKG_RAT_UT_CD			ASC NULLS FIRST" ).append("\n"); 
		query.append("		, A.PAY_TERM_CD				ASC NULLS FIRST" ).append("\n"); 
		query.append("		, A.CURR_CD" ).append("\n"); 

	}
}