/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtCmdtRoutVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.25 
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

public class RFARateProposalDBDAOPriRpScpRtCmdtRoutVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMDT route 입력
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtCmdtRoutVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dest_cy_dor_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cy_dor_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtCmdtRoutVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_CMDT_ROUT (" ).append("\n"); 
		query.append("	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",	ROUT_SEQ" ).append("\n"); 
		query.append(",   N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	ORG_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append(",	DEST_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("#if (${IS_MASTER} == 'Y')" ).append("\n"); 
		query.append("-- 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)" ).append("\n"); 
		query.append(",   MST_ROUT_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[prop_no]" ).append("\n"); 
		query.append(",	@[amdt_seq]" ).append("\n"); 
		query.append(",	@[svc_scp_cd]" ).append("\n"); 
		query.append(",	@[cmdt_hdr_seq]" ).append("\n"); 
		query.append(",	@[rout_seq]" ).append("\n"); 
		query.append(",	@[amdt_seq]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	NVL(@[org_cy_dor_rt_tp_cd], 'C')" ).append("\n"); 
		query.append(",	NVL(@[dest_cy_dor_rt_tp_cd], 'C')" ).append("\n"); 
		query.append("#if (${IS_MASTER} == 'Y')" ).append("\n"); 
		query.append("-- 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)" ).append("\n"); 
		query.append(",   (SELECT NVL(MAX(ROUT_SEQ), 0)+1" ).append("\n"); 
		query.append("       FROM PRI_RP_SCP_RT_CMDT_ROUT" ).append("\n"); 
		query.append("      WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}