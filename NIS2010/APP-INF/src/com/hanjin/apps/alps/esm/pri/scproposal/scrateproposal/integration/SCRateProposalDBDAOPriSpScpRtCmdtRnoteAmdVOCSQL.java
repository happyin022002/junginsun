/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtCmdtRnoteAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtCmdtRnoteAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCRateProposalDBDAOPriSpScpRtCmdtRnoteAmdVOCSQL
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtCmdtRnoteAmdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtCmdtRnoteAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_RT_CMDT_RNOTE(" ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("    ROUT_SEQ," ).append("\n"); 
		query.append("    ROUT_NOTE_SEQ," ).append("\n"); 
		query.append("    NOTE_CLSS_CD," ).append("\n"); 
		query.append("    CHG_CD," ).append("\n"); 
		query.append("    NOTE_CTNT," ).append("\n"); 
		query.append("    NOTE_CONV_MAPG_ID," ).append("\n"); 
		query.append("    NOTE_CHG_TP_CD," ).append("\n"); 
		query.append("    PRC_PROG_STS_CD," ).append("\n"); 
		query.append("    SRC_INFO_CD," ).append("\n"); 
		query.append("    ACPT_USR_ID," ).append("\n"); 
		query.append("    ACPT_OFC_CD," ).append("\n"); 
		query.append("    ACPT_DT," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("	N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    PROP_NO                 ," ).append("\n"); 
		query.append("    AMDT_SEQ+1              ," ).append("\n"); 
		query.append("    SVC_SCP_CD              ," ).append("\n"); 
		query.append("    GEN_SPCL_RT_TP_CD       ," ).append("\n"); 
		query.append("    CMDT_HDR_SEQ            ," ).append("\n"); 
		query.append("    ROUT_SEQ                ," ).append("\n"); 
		query.append("    ROUT_NOTE_SEQ           ," ).append("\n"); 
		query.append("    NOTE_CLSS_CD            ," ).append("\n"); 
		query.append("    CHG_CD                  ," ).append("\n"); 
		query.append("    NOTE_CTNT               ," ).append("\n"); 
		query.append("    DECODE(NOTE_CONV_MAPG_ID,'','', SYS_GUID())       ," ).append("\n"); 
		query.append("    NOTE_CHG_TP_CD          ," ).append("\n"); 
		query.append("    PRC_PROG_STS_CD         ," ).append("\n"); 
		query.append("    SRC_INFO_CD             ," ).append("\n"); 
		query.append("    ACPT_USR_ID				," ).append("\n"); 
		query.append("    ACPT_OFC_CD				," ).append("\n"); 
		query.append("    ACPT_DT					," ).append("\n"); 
		query.append("    @[cre_usr_id]           ," ).append("\n"); 
		query.append("    SYSDATE                 ," ).append("\n"); 
		query.append("    @[upd_usr_id]           ," ).append("\n"); 
		query.append("    SYSDATE			," ).append("\n"); 
		query.append("	N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_SP_SCP_RT_CMDT_RNOTE RNOTE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND EXISTS ( " ).append("\n"); 
		query.append("    SELECT 'OK'" ).append("\n"); 
		query.append("    FROM    " ).append("\n"); 
		query.append("        PRI_SP_SCP_RT" ).append("\n"); 
		query.append("    WHERE   " ).append("\n"); 
		query.append("        PROP_NO             = RNOTE.PROP_NO" ).append("\n"); 
		query.append("    AND AMDT_SEQ            = RNOTE.AMDT_SEQ" ).append("\n"); 
		query.append("    AND SVC_SCP_CD          = RNOTE.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND GEN_SPCL_RT_TP_CD   = RNOTE.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND CMDT_HDR_SEQ        = RNOTE.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND ROUT_SEQ            = RNOTE.ROUT_SEQ " ).append("\n"); 
		query.append("	AND SRC_INFO_CD			<> 'AD'   " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}