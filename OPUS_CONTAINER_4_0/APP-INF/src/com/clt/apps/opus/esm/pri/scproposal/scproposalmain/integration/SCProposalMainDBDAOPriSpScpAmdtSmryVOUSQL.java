/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpScpAmdtSmryVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.06.12 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpScpAmdtSmryVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriSpScpAmdtSmryVO
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpScpAmdtSmryVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_term_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpScpAmdtSmryVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_AMDT_SMRY UPD" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    ( AMDT_FLG  ,ACPT_FLG ) = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("				DECODE(COUNT(SRC.AMDT_SEQ),0,'N','','N','Y'), " ).append("\n"); 
		query.append("				DECODE(MAX(SRC.PRC_PROG_STS_CD),'A','Y','N')" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("#if(${prop_scp_term_tp_cd} == '11') " ).append("\n"); 
		query.append("				PRI_SP_SCP_DUR SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '12') " ).append("\n"); 
		query.append("				PRI_SP_SCP_MQC SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '13') " ).append("\n"); 
		query.append("				PRI_SP_SCP_GRP_LOC_DTL SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '14') " ).append("\n"); 
		query.append("				PRI_SP_SCP_GRP_CMDT_DTL SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '15') " ).append("\n"); 
		query.append("				PRI_SP_SCP_LODG_AGN SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '31' || ${prop_scp_term_tp_cd} == '32') " ).append("\n"); 
		query.append("                PRI_SP_SCP_NOTE_CTNT SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '41' || ${prop_scp_term_tp_cd} == '42') " ).append("\n"); 
		query.append("				PRI_SP_SCP_ROUT_PNT SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '51' || ${prop_scp_term_tp_cd} == '52') " ).append("\n"); 
		query.append("				PRI_SP_SCP_TRSP_ADD_CHG SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '16') " ).append("\n"); 
		query.append("				PRI_SP_SCP_GOH_CHG SRC," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '71' || ${prop_scp_term_tp_cd} == '72') " ).append("\n"); 
		query.append("                (SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_RT_ACT_CUST" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_RT_CMDT" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_RT_ROUT_DIR" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_RT_ROUT_VIA) SRC," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("				PRI_SP_SCP_MN MN" ).append("\n"); 
		query.append("            WHERE " ).append("\n"); 
		query.append("				SRC.PROP_NO 		= UPD.PROP_NO" ).append("\n"); 
		query.append("            AND SRC.AMDT_SEQ 		= UPD.AMDT_SEQ" ).append("\n"); 
		query.append("            AND SRC.SVC_SCP_CD 		= UPD.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND SRC.PROP_NO 		= MN.PROP_NO" ).append("\n"); 
		query.append("            AND SRC.AMDT_SEQ 		= MN.AMDT_SEQ" ).append("\n"); 
		query.append("            AND SRC.SVC_SCP_CD 		= UPD.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND SRC.N1ST_CMNC_AMDT_SEQ 	= MN.AMDT_SEQ" ).append("\n"); 
		query.append("#if(${prop_scp_term_tp_cd} == '31') " ).append("\n"); 
		query.append("            AND SRC.NOTE_TP_CD 	= 'T'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '32') " ).append("\n"); 
		query.append("            AND SRC.NOTE_TP_CD 	= 'P'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '41') " ).append("\n"); 
		query.append("            AND SRC.ORG_DEST_TP_CD 	= 'O'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '42') " ).append("\n"); 
		query.append("            AND SRC.ORG_DEST_TP_CD 	= 'D'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '51') " ).append("\n"); 
		query.append("            AND SRC.ORG_DEST_TP_CD 	= 'O'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '52') " ).append("\n"); 
		query.append("            AND SRC.ORG_DEST_TP_CD 	= 'D'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '71') " ).append("\n"); 
		query.append("            AND SRC.GEN_SPCL_RT_TP_CD 	= 'G'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '72') " ).append("\n"); 
		query.append("            AND SRC.GEN_SPCL_RT_TP_CD 	= 'S'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("AND PROP_SCP_TERM_TP_CD = @[prop_scp_term_tp_cd]" ).append("\n"); 

	}
}