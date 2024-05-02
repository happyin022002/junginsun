/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.03.17 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriRpScpAmdtSmryVO
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_AMDT_SMRY UPD" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    ( amdt_flg  ,acpt_flg ) = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("				DECODE(count(src.amdt_seq),0,'N','','N','Y'), " ).append("\n"); 
		query.append("				DECODE(MAX(src.prc_prog_sts_cd),'A','Y','N')" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("#if(${prop_scp_term_tp_cd} == '11') " ).append("\n"); 
		query.append("				pri_Rp_scp_dur src," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '13') " ).append("\n"); 
		query.append("				pri_Rp_scp_grp_loc_dtl src," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '14') " ).append("\n"); 
		query.append("				pri_Rp_scp_grp_cmdt_dtl src," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '32') " ).append("\n"); 
		query.append("				PRI_RP_SCP_NOTE_CTNT src," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '51' || ${prop_scp_term_tp_cd} == '52') " ).append("\n"); 
		query.append("				PRI_RP_SCP_TRSP_ADD_CHG src," ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '71' || ${prop_scp_term_tp_cd} == '73')  " ).append("\n"); 
		query.append("                (SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                   FROM PRI_RP_SCP_RT_ACT_CUST" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                   FROM PRI_RP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                   FROM PRI_RP_SCP_RT_CMDT" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                   FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                   FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                   FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                   FROM PRI_RP_SCP_RT_ROUT_VIA) SRC," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("				pri_Rp_scp_mn mn" ).append("\n"); 
		query.append("            where " ).append("\n"); 
		query.append("				src.prop_no 		= upd.prop_no" ).append("\n"); 
		query.append("            and src.amdt_seq 		= upd.amdt_seq" ).append("\n"); 
		query.append("            and src.svc_scp_cd 		= upd.svc_scp_cd" ).append("\n"); 
		query.append("            and src.prop_no 		= mn.prop_no" ).append("\n"); 
		query.append("            and src.amdt_seq 		= mn.amdt_seq" ).append("\n"); 
		query.append("            and src.svc_scp_cd 		= upd.svc_scp_cd" ).append("\n"); 
		query.append("			AND SRC.N1ST_CMNC_AMDT_SEQ 	= MN.AMDT_SEQ" ).append("\n"); 
		query.append("#if(${prop_scp_term_tp_cd} == '32') " ).append("\n"); 
		query.append("            and src.note_tp_cd 	= 'P'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '51') " ).append("\n"); 
		query.append("            and src.org_dest_tp_cd 	= 'O'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '52') " ).append("\n"); 
		query.append("            and src.org_dest_tp_cd 	= 'D'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    prop_no    = @[prop_no]" ).append("\n"); 
		query.append("AND amdt_seq   = @[amdt_seq]" ).append("\n"); 
		query.append("AND svc_scp_cd = @[svc_scp_cd] " ).append("\n"); 
		query.append("AND prop_scp_term_tp_cd = @[prop_scp_term_tp_cd]" ).append("\n"); 

	}
}