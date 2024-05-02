/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtCmdtRnoteAmdBasicVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.20 
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

public class RFARateProposalDBDAOPriRpScpRtCmdtRnoteAmdBasicVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA에서 가져온 Rate Commodity Rnote 데이터를 Basic Rate에 넣는다.
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtCmdtRnoteAmdBasicVOCSQL(){
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
		params.put("mst_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtCmdtRnoteAmdBasicVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_CMDT_RNOTE(" ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("    ROUT_SEQ," ).append("\n"); 
		query.append("    ROUT_NOTE_SEQ," ).append("\n"); 
		query.append("    NOTE_CTNT," ).append("\n"); 
		query.append("    NOTE_CONV_MAPG_ID," ).append("\n"); 
		query.append("    PRC_PROG_STS_CD," ).append("\n"); 
		query.append("    SRC_INFO_CD," ).append("\n"); 
		query.append("    ACPT_USR_ID," ).append("\n"); 
		query.append("    ACPT_OFC_CD," ).append("\n"); 
		query.append("    ACPT_DT," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH MASTER_RFA_INFO AS (" ).append("\n"); 
		query.append("    SELECT MN.PROP_NO, MAX(MN.AMDT_SEQ) AS AMDT_SEQ, SVC_SCP_CD" ).append("\n"); 
		query.append("       FROM PRI_RP_MN MN, PRI_RP_SCP_RT_CMDT_ROUT ROUT" ).append("\n"); 
		query.append("      WHERE MN.PROP_NO = (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = @[mst_rfa_no]) -- Mst RFA No" ).append("\n"); 
		query.append("        AND MN.PROP_NO = ROUT.PROP_NO" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("      GROUP BY MN.PROP_NO, SVC_SCP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("BASIC_RFA_INFO AS (" ).append("\n"); 
		query.append("	SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, MST_ROUT_ID" ).append("\n"); 
		query.append("	  FROM PRI_RP_SCP_RT_CMDT_ROUT" ).append("\n"); 
		query.append("	 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	   AND AMDT_SEQ =  @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       B.PROP_NO                 ," ).append("\n"); 
		query.append("       B.AMDT_SEQ+1              ," ).append("\n"); 
		query.append("       B.SVC_SCP_CD              ," ).append("\n"); 
		query.append("       B.CMDT_HDR_SEQ            ," ).append("\n"); 
		query.append("       B.ROUT_SEQ                ," ).append("\n"); 
		query.append("       M.ROUT_NOTE_SEQ           ," ).append("\n"); 
		query.append("       M.NOTE_CTNT               ," ).append("\n"); 
		query.append("       DECODE(B.NOTE_CONV_MAPG_ID,'','', SYS_GUID())       ," ).append("\n"); 
		query.append("       DECODE(M.SRC_INFO_CD, 'AM', 'I', 'AD', 'I', M.PRC_PROG_STS_CD)," ).append("\n"); 
		query.append("       M.SRC_INFO_CD             ," ).append("\n"); 
		query.append("       B.ACPT_USR_ID," ).append("\n"); 
		query.append("       B.ACPT_OFC_CD," ).append("\n"); 
		query.append("       B.ACPT_DT," ).append("\n"); 
		query.append("       @[cre_usr_id]           ," ).append("\n"); 
		query.append("       SYSDATE                 ," ).append("\n"); 
		query.append("       @[upd_usr_id]           ," ).append("\n"); 
		query.append("       SYSDATE			," ).append("\n"); 
		query.append("--       M.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("       CASE WHEN M.SRC_INFO_CD IN ('AM', 'AD') THEN B.AMDT_SEQ+1 " ).append("\n"); 
		query.append("            ELSE B.AMDT_SEQ " ).append("\n"); 
		query.append("       END AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("  FROM MASTER_RFA_INFO MST_INFO," ).append("\n"); 
		query.append("       BASIC_RFA_INFO BSC_INFO," ).append("\n"); 
		query.append("       PRI_RP_SCP_RT_CMDT_RNOTE B,-- Basic" ).append("\n"); 
		query.append("       PRI_RP_SCP_RT_CMDT_RNOTE M-- Master" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("   -- Master" ).append("\n"); 
		query.append("       M.PROP_NO = MST_INFO.PROP_NO" ).append("\n"); 
		query.append("   AND M.AMDT_SEQ = MST_INFO.AMDT_SEQ" ).append("\n"); 
		query.append("   AND M.SVC_SCP_CD = MST_INFO.SVC_SCP_CD" ).append("\n"); 
		query.append("   -- Basic" ).append("\n"); 
		query.append("   AND B.PROP_NO = BSC_INFO.PROP_NO" ).append("\n"); 
		query.append("   AND B.AMDT_SEQ = BSC_INFO.AMDT_SEQ" ).append("\n"); 
		query.append("   AND B.SVC_SCP_CD = BSC_INFO.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND B.CMDT_HDR_SEQ = BSC_INFO.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND B.ROUT_SEQ = BSC_INFO.ROUT_SEQ" ).append("\n"); 
		query.append("   -- Join" ).append("\n"); 
		query.append("   AND B.SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND B.CMDT_HDR_SEQ = M.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND BSC_INFO.MST_ROUT_ID = M.ROUT_SEQ" ).append("\n"); 

	}
}