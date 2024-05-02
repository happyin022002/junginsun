/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtCmdtRouteCmpbVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.02.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriRpScpRtCmdtRouteCmpbVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtCmdtRouteCmpbVOUSQL(){
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
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtCmdtRouteCmpbVOUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_RP_SCP_RT_CMDT_ROUT ROUT" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT PROP_NO ,AMDT_SEQ ,SVC_SCP_CD ,CMDT_HDR_SEQ ,ROUT_SEQ , RAT_UT_CD, PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                , PRS_RESPB_CMPB_AMT, PRS_PFIT_CMPB_AMT, PRS_RESPB_OPB_AMT " ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("        WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("            AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("            AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${UPDATE_LEVEL} == '1') " ).append("\n"); 
		query.append("-- 모든 route에 적용" ).append("\n"); 
		query.append("#elseif (${UPDATE_LEVEL} == '2') " ).append("\n"); 
		query.append("            AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("            AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("            AND RT_SEQ = @[rt_seq]       " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(") RT" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("            ROUT.PROP_NO           = RT.PROP_NO" ).append("\n"); 
		query.append("        AND ROUT.AMDT_SEQ          = RT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND ROUT.SVC_SCP_CD        = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND ROUT.CMDT_HDR_SEQ      = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND ROUT.ROUT_SEQ          = RT.ROUT_SEQ" ).append("\n"); 
		query.append("        AND ROUT.PRS_RAT_UT_CD     = RT.RAT_UT_CD" ).append("\n"); 
		query.append("        AND ROUT.PRS_CGO_TP_CD = RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE SET " ).append("\n"); 
		query.append("                  ROUT.PRS_ESTM_RESPB_CMPB_AMT = RT.PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("                , ROUT.PRS_ESTM_PFIT_CMPB_AMT   = RT.PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("                , ROUT.PRS_ESTM_RESPB_OPB_AMT   = RT.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("                , ROUT.UPD_USR_ID            =  @[upd_usr_id]" ).append("\n"); 
		query.append("                , ROUT.UPD_DT                =  SYSDATE" ).append("\n"); 

	}
}