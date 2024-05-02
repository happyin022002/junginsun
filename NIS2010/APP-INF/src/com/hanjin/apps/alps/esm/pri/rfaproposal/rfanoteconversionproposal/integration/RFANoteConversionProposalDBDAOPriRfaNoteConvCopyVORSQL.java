/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL.java
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

public class RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COPY된 데이터를 조회한다.
	  * </pre>
	  */
	public RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration").append("\n"); 
		query.append("FileName : RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL").append("\n"); 
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
		query.append("		, BKG_RAT_UT_CD" ).append("\n"); 
		query.append("		, BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		, BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("		, BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("		, BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("		, BKG_POR_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POR_TP_CD, 'T', SUBSTR(BKG_POR_DEF_CD, 3), BKG_POR_DEF_CD) BKG_POR_DEF_CD" ).append("\n"); 
		query.append("		, BKG_POL_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POL_TP_CD, 'T', SUBSTR(BKG_POL_DEF_CD, 3), BKG_POL_DEF_CD) BKG_POL_DEF_CD" ).append("\n"); 
		query.append("		, BKG_POD_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POD_TP_CD, 'T', SUBSTR(BKG_POD_DEF_CD, 3), BKG_POD_DEF_CD) BKG_POD_DEF_CD" ).append("\n"); 
		query.append("		, BKG_DEL_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_DEL_TP_CD, 'T', SUBSTR(BKG_DEL_DEF_CD, 3), BKG_DEL_DEF_CD) BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("		, BKG_SLAN_CD" ).append("\n"); 
		query.append("		, (BKG_VSL_CD||BKG_SKD_VOY_NO||BKG_SKD_DIR_CD) BKG_VVD_CD" ).append("\n"); 
		query.append("		, BKG_VSL_CD" ).append("\n"); 
		query.append("		, BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("		, BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("		, BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("		, BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("		, BKG_SOC_FLG" ).append("\n"); 
		query.append("		, BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("		, BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("		, BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("		, BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POR_TP_CD, 'T', SUBSTR(BKG_POR_DEF_CD, 1, 2), '') BKG_POR_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POL_TP_CD, 'T', SUBSTR(BKG_POL_DEF_CD, 1, 2), '') BKG_POL_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_POD_TP_CD, 'T', SUBSTR(BKG_POD_DEF_CD, 1, 2), '') BKG_POD_CNT_CD" ).append("\n"); 
		query.append("		, DECODE(BKG_DEL_TP_CD, 'T', SUBSTR(BKG_DEL_DEF_CD, 1, 2), '') BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("		, BKG_YD_CD" ).append("\n"); 
		query.append("        , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("	 FROM PRI_RFA_NOTE_CONV_CPY" ).append("\n"); 
		query.append("    WHERE USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	ORDER BY CHG_RULE_DEF_CD" ).append("\n"); 

	}
}