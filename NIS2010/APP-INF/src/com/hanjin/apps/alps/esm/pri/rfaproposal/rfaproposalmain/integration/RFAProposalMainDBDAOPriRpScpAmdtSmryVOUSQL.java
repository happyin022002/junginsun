/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.05.24 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
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
		query.append("#elseif(${prop_scp_term_tp_cd} == '71' || ${prop_scp_term_tp_cd} == '73' ) " ).append("\n"); 
		query.append("                (SELECT PROP_NO," ).append("\n"); 
		query.append("			       AMDT_SEQ," ).append("\n"); 
		query.append("			       SVC_SCP_CD," ).append("\n"); 
		query.append("			       N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("			       PRC_PROG_STS_CD," ).append("\n"); 
		query.append("			       (SELECT X1.FIC_RT_TP_CD FROM PRI_RP_SCP_RT_CMDT_HDR X1 WHERE X1.PROP_NO = T1.PROP_NO AND X1.AMDT_SEQ = T1.AMDT_SEQ AND X1.SVC_SCP_CD = T1.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ) FIC_RT_TP_CD" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_ACT_CUST T1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT PROP_NO," ).append("\n"); 
		query.append("			       AMDT_SEQ," ).append("\n"); 
		query.append("			       SVC_SCP_CD," ).append("\n"); 
		query.append("			       N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("			       PRC_PROG_STS_CD," ).append("\n"); 
		query.append("			(SELECT X1.FIC_RT_TP_CD FROM PRI_RP_SCP_RT_CMDT_HDR X1 WHERE X1.PROP_NO = T1.PROP_NO AND X1.AMDT_SEQ = T1.AMDT_SEQ AND X1.SVC_SCP_CD = T1.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ) FIC_RT_TP_CD" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_CNOTE T1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT PROP_NO," ).append("\n"); 
		query.append("			       AMDT_SEQ," ).append("\n"); 
		query.append("			       SVC_SCP_CD," ).append("\n"); 
		query.append("			       N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("			       PRC_PROG_STS_CD," ).append("\n"); 
		query.append("			(SELECT X1.FIC_RT_TP_CD FROM PRI_RP_SCP_RT_CMDT_HDR X1 WHERE X1.PROP_NO = T1.PROP_NO AND X1.AMDT_SEQ = T1.AMDT_SEQ AND X1.SVC_SCP_CD = T1.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ) FIC_RT_TP_CD" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_CMDT T1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT PROP_NO," ).append("\n"); 
		query.append("			       AMDT_SEQ," ).append("\n"); 
		query.append("			       SVC_SCP_CD," ).append("\n"); 
		query.append("			       N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("			       PRC_PROG_STS_CD," ).append("\n"); 
		query.append("			(SELECT X1.FIC_RT_TP_CD FROM PRI_RP_SCP_RT_CMDT_HDR X1 WHERE X1.PROP_NO = T1.PROP_NO AND X1.AMDT_SEQ = T1.AMDT_SEQ AND X1.SVC_SCP_CD = T1.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ) FIC_RT_TP_CD" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT T1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT PROP_NO," ).append("\n"); 
		query.append("			       AMDT_SEQ," ).append("\n"); 
		query.append("			       SVC_SCP_CD," ).append("\n"); 
		query.append("			       N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("			       PRC_PROG_STS_CD," ).append("\n"); 
		query.append("			(SELECT X1.FIC_RT_TP_CD FROM PRI_RP_SCP_RT_CMDT_HDR X1 WHERE X1.PROP_NO = T1.PROP_NO AND X1.AMDT_SEQ = T1.AMDT_SEQ AND X1.SVC_SCP_CD = T1.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ) FIC_RT_TP_CD" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_CMDT_RNOTE T1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT PROP_NO," ).append("\n"); 
		query.append("			       AMDT_SEQ," ).append("\n"); 
		query.append("			       SVC_SCP_CD," ).append("\n"); 
		query.append("			       N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("			       PRC_PROG_STS_CD," ).append("\n"); 
		query.append("			(SELECT X1.FIC_RT_TP_CD FROM PRI_RP_SCP_RT_CMDT_HDR X1 WHERE X1.PROP_NO = T1.PROP_NO AND X1.AMDT_SEQ = T1.AMDT_SEQ AND X1.SVC_SCP_CD = T1.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ) FIC_RT_TP_CD" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_ROUT_PNT T1" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT PROP_NO," ).append("\n"); 
		query.append("			       AMDT_SEQ," ).append("\n"); 
		query.append("			       SVC_SCP_CD," ).append("\n"); 
		query.append("			       N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("			       PRC_PROG_STS_CD," ).append("\n"); 
		query.append("			(SELECT X1.FIC_RT_TP_CD FROM PRI_RP_SCP_RT_CMDT_HDR X1 WHERE X1.PROP_NO = T1.PROP_NO AND X1.AMDT_SEQ = T1.AMDT_SEQ AND X1.SVC_SCP_CD = T1.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ) FIC_RT_TP_CD" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_ROUT_VIA T1) SRC," ).append("\n"); 
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
		query.append("            and src.add_chg_tp_cd 	= 'A'" ).append("\n"); 
		query.append("            and src.org_dest_tp_cd 	= 'O'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '52') " ).append("\n"); 
		query.append("            and src.add_chg_tp_cd 	= 'A'" ).append("\n"); 
		query.append("            and src.org_dest_tp_cd 	= 'D'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '71') " ).append("\n"); 
		query.append("            and NVL(src.fic_rt_tp_cd, 'G') 	= 'G'" ).append("\n"); 
		query.append("#elseif(${prop_scp_term_tp_cd} == '73') " ).append("\n"); 
		query.append("            and NVL(src.fic_rt_tp_cd, 'G') 	= 'A'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    prop_no    = @[prop_no]" ).append("\n"); 
		query.append("AND amdt_seq   = @[amdt_seq]" ).append("\n"); 
		query.append("AND svc_scp_cd = @[svc_scp_cd] " ).append("\n"); 
		query.append("AND prop_scp_term_tp_cd = @[prop_scp_term_tp_cd]" ).append("\n"); 

	}
}