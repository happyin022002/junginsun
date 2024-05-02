/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAORsltCommodityNoteConvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltCommodityNoteConvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * retrive the conversion data according to Commodity's NOTE_CONV_MAPG_ID
	  * </pre>
	  */
	public RFARateProposalDBDAORsltCommodityNoteConvListRSQL(){
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
		params.put("note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration ").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltCommodityNoteConvListRSQL").append("\n"); 
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
		query.append("SELECT A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      ,A.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("      ,A.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A.PROP_NO" ).append("\n"); 
		query.append("      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN A.CHG_RULE_TP_CD = 'C' THEN" ).append("\n"); 
		query.append("          NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("         WHEN A.CHG_RULE_TP_CD = 'R' THEN" ).append("\n"); 
		query.append("          NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("       END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("      ,A.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("      ,A.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("      ,A.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EFF_DT, 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EXP_DT, 'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("      ,A.RT_APPL_TP_CD" ).append("\n"); 
		query.append("      ,A.RT_OP_CD" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.FRT_RT_AMT" ).append("\n"); 
		query.append("      ,A.PAY_TERM_CD" ).append("\n"); 
		query.append("      ,A.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("      ,A.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,A.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("      ,A.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("      ,A.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("      ,A.BKG_POR_TP_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POR_TP_CD, 'T', SUBSTR(A.BKG_POR_DEF_CD, 3), A.BKG_POR_DEF_CD) BKG_POR_DEF_CD" ).append("\n"); 
		query.append("	  , A.BKG_POL_TP_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POL_TP_CD, 'T', SUBSTR(A.BKG_POL_DEF_CD, 3), A.BKG_POL_DEF_CD) BKG_POL_DEF_CD" ).append("\n"); 
		query.append("	  , A.BKG_POD_TP_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POD_TP_CD, 'T', SUBSTR(A.BKG_POD_DEF_CD, 3), A.BKG_POD_DEF_CD) BKG_POD_DEF_CD" ).append("\n"); 
		query.append("	  , A.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_DEL_TP_CD, 'T', SUBSTR(A.BKG_DEL_DEF_CD, 3), A.BKG_DEL_DEF_CD) BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("      ,A.BKG_SLAN_CD" ).append("\n"); 
		query.append("      ,(A.BKG_VSL_CD || A.BKG_SKD_VOY_NO || A.BKG_SKD_DIR_CD) BKG_VVD_CD" ).append("\n"); 
		query.append("      ,A.BKG_VSL_CD" ).append("\n"); 
		query.append("      ,A.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.BKG_SOC_FLG" ).append("\n"); 
		query.append("      ,A.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("      ,A.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("      ,A.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("      ,A.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("      ,A.BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("      ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POR_TP_CD, 'T', SUBSTR(A.BKG_POR_DEF_CD, 1, 2), '') BKG_POR_CNT_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POL_TP_CD, 'T', SUBSTR(A.BKG_POL_DEF_CD, 1, 2), '') BKG_POL_CNT_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POD_TP_CD, 'T', SUBSTR(A.BKG_POD_DEF_CD, 1, 2), '') BKG_POD_CNT_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_DEL_TP_CD, 'T', SUBSTR(A.BKG_DEL_DEF_CD, 1, 2), '') BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("      ,A.BKG_YD_CD" ).append("\n"); 
		query.append("      ,A.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("      ,A.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("  FROM PRI_RFA_NOTE_CONV A" ).append("\n"); 
		query.append(" WHERE NOTE_CONV_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND (AMDT_SEQ = @[amdt_seq] OR" ).append("\n"); 
		query.append("               (AMDT_SEQ = @[amdt_seq] - 1 AND" ).append("\n"); 
		query.append("               SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND NOTE_CONV_MAPG_ID = A.NOTE_CONV_MAPG_ID)" ).append("\n"); 
		query.append("   AND NOTE_CONV_MAPG_ID = @[note_conv_mapg_id]" ).append("\n"); 
		query.append(" ORDER BY CHG_RULE_DEF_CD" ).append("\n"); 

	}
}