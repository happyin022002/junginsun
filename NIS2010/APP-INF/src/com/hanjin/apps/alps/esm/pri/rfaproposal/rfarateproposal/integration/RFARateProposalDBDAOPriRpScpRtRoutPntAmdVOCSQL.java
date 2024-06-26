/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtRoutPntAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.05.31 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriRpScpRtRoutPntAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFARateProposalDBDAOPriRpScpRtRoutPntAmdVOCSQL
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtRoutPntAmdVOCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtRoutPntAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_ROUT_PNT(" ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("    ROUT_SEQ," ).append("\n"); 
		query.append("    ORG_DEST_TP_CD," ).append("\n"); 
		query.append("    ROUT_PNT_SEQ," ).append("\n"); 
		query.append("    ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("    ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("    PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("    RCV_DE_TERM_CD," ).append("\n"); 
		query.append("    PRC_PROG_STS_CD," ).append("\n"); 
		query.append("    SRC_INFO_CD," ).append("\n"); 
		query.append("    ACPT_USR_ID," ).append("\n"); 
		query.append("    ACPT_OFC_CD," ).append("\n"); 
		query.append("    ACPT_DT," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("    FIC_ROUT_CMB_TP_CD," ).append("\n"); 
		query.append("    BSE_PORT_LOC_CD    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    PROP_NO                 ," ).append("\n"); 
		query.append("    AMDT_SEQ+1              ," ).append("\n"); 
		query.append("    SVC_SCP_CD              ," ).append("\n"); 
		query.append("    CMDT_HDR_SEQ            ," ).append("\n"); 
		query.append("    ROUT_SEQ                ," ).append("\n"); 
		query.append("    ORG_DEST_TP_CD          ," ).append("\n"); 
		query.append("    ROUT_PNT_SEQ            ," ).append("\n"); 
		query.append("    ROUT_PNT_LOC_TP_CD      ," ).append("\n"); 
		query.append("    ROUT_PNT_LOC_DEF_CD     ," ).append("\n"); 
		query.append("    PRC_TRSP_MOD_CD         ," ).append("\n"); 
		query.append("    RCV_DE_TERM_CD          ," ).append("\n"); 
		query.append("    PRC_PROG_STS_CD         ," ).append("\n"); 
		query.append("    SRC_INFO_CD             ," ).append("\n"); 
		query.append("    ACPT_USR_ID             ," ).append("\n"); 
		query.append("    ACPT_OFC_CD             ," ).append("\n"); 
		query.append("    ACPT_DT                 ," ).append("\n"); 
		query.append("    @[cre_usr_id]           ," ).append("\n"); 
		query.append("    SYSDATE                 ," ).append("\n"); 
		query.append("    @[upd_usr_id]           ," ).append("\n"); 
		query.append("    SYSDATE                 ," ).append("\n"); 
		query.append("    N1ST_CMNC_AMDT_SEQ      ," ).append("\n"); 
		query.append("    PNT.FIC_ROUT_CMB_TP_CD  ," ).append("\n"); 
		query.append("    PNT.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_RP_SCP_RT_ROUT_PNT PNT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND EXISTS ( " ).append("\n"); 
		query.append("    SELECT 'OK'" ).append("\n"); 
		query.append("    FROM    " ).append("\n"); 
		query.append("        PRI_RP_SCP_RT" ).append("\n"); 
		query.append("    WHERE   " ).append("\n"); 
		query.append("        PROP_NO             = PNT.PROP_NO" ).append("\n"); 
		query.append("    AND AMDT_SEQ            = PNT.AMDT_SEQ" ).append("\n"); 
		query.append("    AND SVC_SCP_CD          = PNT.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND CMDT_HDR_SEQ        = PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND ROUT_SEQ            = PNT.ROUT_SEQ " ).append("\n"); 
		query.append("	AND SRC_INFO_CD			<> 'AD'   " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}