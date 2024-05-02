/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCReportDBDAORsltNoteCtntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltNoteCtntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA/SC NOTE CTNT
	  * </pre>
	  */
	public SCReportDBDAORsltNoteCtntRSQL(){
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
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltNoteCtntRSQL").append("\n"); 
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
		query.append("#if (${is_sc} == 'Y' && ${note_gubun} == 'R')" ).append("\n"); 
		query.append("SELECT BKG_JOIN_FULL_CLOB_FNC(CURSOR(" ).append("\n"); 
		query.append("                SELECT  t.ROUT_NOTE_SEQ ||'. '||t.NOTE_CTNT NOTE_CTNT" ).append("\n"); 
		query.append("                FROM    PRI_SP_SCP_RT_CMDT_RNOTE t" ).append("\n"); 
		query.append("                WHERE   t.PROP_NO            = @[prop_no]" ).append("\n"); 
		query.append("                AND     t.AMDT_SEQ           = @[amdt_seq]" ).append("\n"); 
		query.append("                AND     t.SVC_SCP_CD         = @[svc_scp_cd]" ).append("\n"); 
		query.append("                AND     t.GEN_SPCL_RT_TP_CD  = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                AND     t.CMDT_HDR_SEQ       = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                AND     t.ROUT_SEQ           = @[rout_seq]" ).append("\n"); 
		query.append("                AND     t.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                ORDER BY t.ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("        ),CHR(13)||CHR(13)) AS NOTE_CTNT FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${is_sc} == 'Y' && ${note_gubun} == 'C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BKG_JOIN_FULL_CLOB_FNC(CURSOR(" ).append("\n"); 
		query.append("                SELECT  t.CMDT_HDR_SEQ ||'. '||t.NOTE_CTNT NOTE_CTNT" ).append("\n"); 
		query.append("                FROM    PRI_SP_SCP_RT_CNOTE t" ).append("\n"); 
		query.append("                WHERE   t.PROP_NO            = @[prop_no]" ).append("\n"); 
		query.append("                AND     t.AMDT_SEQ           = @[amdt_seq]" ).append("\n"); 
		query.append("                AND     t.SVC_SCP_CD         = @[svc_scp_cd]" ).append("\n"); 
		query.append("                AND     t.GEN_SPCL_RT_TP_CD  = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                AND     t.CMDT_HDR_SEQ       = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                AND     t.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                ORDER BY t.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("        ),CHR(13)||CHR(13)) AS NOTE_CTNT FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${is_sc} == 'Y' && ${note_gubun} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BKG_JOIN_FULL_CLOB_FNC(CURSOR(" ).append("\n"); 
		query.append("                SELECT SND.NOTE_CTNT" ).append("\n"); 
		query.append("                FROM PRI_SP_SCP_NOTE SN, PRI_SP_SCP_NOTE_CTNT SND" ).append("\n"); 
		query.append("                WHERE SN.PROP_NO = SND.PROP_NO" ).append("\n"); 
		query.append("                AND SN.AMDT_SEQ = SND.AMDT_SEQ" ).append("\n"); 
		query.append("                AND SN.SVC_SCP_CD = SND.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND SN.NOTE_TP_CD = SND.NOTE_TP_CD" ).append("\n"); 
		query.append("                AND SN.NOTE_SEQ = SND.NOTE_SEQ" ).append("\n"); 
		query.append("                AND SN.NOTE_TP_CD = 'P' --Special Note" ).append("\n"); 
		query.append("                AND SN.NOTE_CLSS_CD <> 'D' --O:Surcharge Exceptions S:Fixed Surcharge D:DEM/DET" ).append("\n"); 
		query.append("                AND SND.SRC_INFO_CD <> 'AD' --DELETE" ).append("\n"); 
		query.append("                AND SN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                AND SN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                AND SN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                ORDER BY DECODE(SN.NOTE_CLSS_CD, 'O', 1, 'S', 2, 3), SND.DP_SEQ" ).append("\n"); 
		query.append("                ),CHR(13)||CHR(13)) AS NOTE_CTNT FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${is_sc} != 'Y' && ${note_gubun} == 'R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT BKG_JOIN_FULL_CLOB_FNC(CURSOR(" ).append("\n"); 
		query.append("                SELECT  RN.ROUT_NOTE_SEQ ||'. '||RN.NOTE_CTNT NOTE_CTNT" ).append("\n"); 
		query.append("                FROM    PRI_RP_SCP_RT_CMDT_RNOTE RN" ).append("\n"); 
		query.append("                WHERE   RN.PROP_NO            = @[prop_no]" ).append("\n"); 
		query.append("                AND     RN.AMDT_SEQ           = @[amdt_seq]" ).append("\n"); 
		query.append("                AND     RN.SVC_SCP_CD         = @[svc_scp_cd]" ).append("\n"); 
		query.append("                AND     RN.CMDT_HDR_SEQ       = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                AND     RN.ROUT_SEQ           = @[rout_seq]" ).append("\n"); 
		query.append("                AND     RN.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                ORDER BY RN.ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("                ),CHR(13)||CHR(13)) AS NOTE_CTNT FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${is_sc} != 'Y' && ${note_gubun} == 'C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BKG_JOIN_FULL_CLOB_FNC(CURSOR(" ).append("\n"); 
		query.append("                SELECT  CN.CMDT_HDR_SEQ ||'. '||CN.NOTE_CTNT NOTE_CTNT" ).append("\n"); 
		query.append("                FROM    PRI_RP_SCP_RT_CNOTE  CN" ).append("\n"); 
		query.append("                WHERE   CN.PROP_NO            = @[prop_no]" ).append("\n"); 
		query.append("                AND     CN.AMDT_SEQ           = @[amdt_seq]" ).append("\n"); 
		query.append("                AND     CN.SVC_SCP_CD         = @[svc_scp_cd]" ).append("\n"); 
		query.append("                AND     CN.CMDT_HDR_SEQ       = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                AND     CN.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                ORDER BY CN.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("                ),CHR(13)||CHR(13)) AS NOTE_CTNT FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${is_sc} != 'Y' && ${note_gubun} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BKG_JOIN_FULL_CLOB_FNC(CURSOR(" ).append("\n"); 
		query.append("                SELECT NOTE_CTNT" ).append("\n"); 
		query.append("                FROM PRI_RP_SCP_NOTE SN, PRI_RP_SCP_NOTE_CTNT SND" ).append("\n"); 
		query.append("                WHERE SN.PROP_NO = SND.PROP_NO" ).append("\n"); 
		query.append("                AND SN.AMDT_SEQ = SND.AMDT_SEQ" ).append("\n"); 
		query.append("                AND SN.SVC_SCP_CD = SND.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND SN.NOTE_TP_CD = SND.NOTE_TP_CD" ).append("\n"); 
		query.append("                AND SN.NOTE_SEQ = SND.NOTE_SEQ" ).append("\n"); 
		query.append("                AND SN.NOTE_TP_CD = 'P' --Special Note" ).append("\n"); 
		query.append("                AND SND.SRC_INFO_CD <> 'AD' --DELETE" ).append("\n"); 
		query.append("                AND SN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                AND SN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                AND SN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                ORDER BY SND.NOTE_SEQ, SND.DP_SEQ" ).append("\n"); 
		query.append("                ),CHR(13)||CHR(13)) AS NOTE_CTNT FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}