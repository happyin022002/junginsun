/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtCmdtRoutAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriRpScpRtCmdtRoutAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFARateProposalDBDAOPriRpScpRtCmdtRoutAmdVOCSQL
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtCmdtRoutAmdVOCSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtCmdtRoutAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_CMDT_ROUT(" ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("    ROUT_SEQ," ).append("\n"); 
		query.append("    DIR_CALL_FLG," ).append("\n"); 
		query.append("    N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("    NOTE_DP_SEQ," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    ORG_CY_DOR_RT_TP_CD," ).append("\n"); 
		query.append("    DEST_CY_DOR_RT_TP_CD," ).append("\n"); 
		query.append("    MST_ROUT_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    PROP_NO                 ," ).append("\n"); 
		query.append("    AMDT_SEQ+1              ," ).append("\n"); 
		query.append("    SVC_SCP_CD                ," ).append("\n"); 
		query.append("    CMDT_HDR_SEQ            ," ).append("\n"); 
		query.append("    ROUT_SEQ                ," ).append("\n"); 
		query.append("    DIR_CALL_FLG," ).append("\n"); 
		query.append("    N1ST_CMNC_AMDT_SEQ        ," ).append("\n"); 
		query.append("    DECODE((SELECT count(1) FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("            WHERE PROP_NO           = ROUT.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ            = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("            AND SVC_SCP_CD          = ROUT.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND CMDT_HDR_SEQ        = ROUT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND ROUT_SEQ            = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("            AND SRC_INFO_CD         <> 'AD'),0,NULL,NOTE_DP_SEQ)   " ).append("\n"); 
		query.append("    NOTE_DP_SEQ                ," ).append("\n"); 
		query.append("    @[cre_usr_id]           ," ).append("\n"); 
		query.append("    SYSDATE                 ," ).append("\n"); 
		query.append("    @[upd_usr_id]           ," ).append("\n"); 
		query.append("    SYSDATE                 ," ).append("\n"); 
		query.append("    ROUT.ORG_CY_DOR_RT_TP_CD   ," ).append("\n"); 
		query.append("    ROUT.DEST_CY_DOR_RT_TP_CD  ," ).append("\n"); 
		query.append("    ROUT.MST_ROUT_ID" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_RP_SCP_RT_CMDT_ROUT ROUT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND EXISTS ( " ).append("\n"); 
		query.append("    SELECT 'OK'" ).append("\n"); 
		query.append("    FROM    " ).append("\n"); 
		query.append("        PRI_RP_SCP_RT" ).append("\n"); 
		query.append("    WHERE   " ).append("\n"); 
		query.append("        PROP_NO             = ROUT.PROP_NO" ).append("\n"); 
		query.append("    AND AMDT_SEQ            = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("    AND SVC_SCP_CD          = ROUT.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND CMDT_HDR_SEQ        = ROUT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND ROUT_SEQ            = ROUT.ROUT_SEQ " ).append("\n"); 
		query.append("  AND SRC_INFO_CD      <> 'AD'   " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}