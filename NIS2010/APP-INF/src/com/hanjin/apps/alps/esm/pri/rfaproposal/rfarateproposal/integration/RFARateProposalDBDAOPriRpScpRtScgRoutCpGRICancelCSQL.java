/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtScgRoutCpGRICancelCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.09
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.07.09 이은섭
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

public class RFARateProposalDBDAOPriRpScpRtScgRoutCpGRICancelCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Cancel시 PriSpScpRtScgRout 복구
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtScgRoutCpGRICancelCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtScgRoutCpGRICancelCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_SCG_ROUT" ).append("\n"); 
		query.append("  (PROP_NO" ).append("\n"); 
		query.append("  ,AMDT_SEQ" ).append("\n"); 
		query.append("  ,SVC_SCP_CD" ).append("\n"); 
		query.append("  ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("  ,ROUT_SEQ" ).append("\n"); 
		query.append("  ,RT_SEQ" ).append("\n"); 
		query.append("  ,POR_CD" ).append("\n"); 
		query.append("  ,POL_CD" ).append("\n"); 
		query.append("  ,POD_CD" ).append("\n"); 
		query.append("  ,DEL_CD" ).append("\n"); 
		query.append("  ,RCV_TERM_CD" ).append("\n"); 
		query.append("  ,DE_TERM_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT)" ).append("\n"); 
		query.append("  SELECT PROP_NO" ).append("\n"); 
		query.append("        ,AMDT_SEQ + 1" ).append("\n"); 
		query.append("        ,SVC_SCP_CD" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,ROUT_SEQ" ).append("\n"); 
		query.append("        ,RT_SEQ" ).append("\n"); 
		query.append("        ,POR_CD" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,POD_CD" ).append("\n"); 
		query.append("        ,DEL_CD" ).append("\n"); 
		query.append("        ,RCV_TERM_CD" ).append("\n"); 
		query.append("        ,DE_TERM_CD" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_RT_SCG_ROUT T" ).append("\n"); 
		query.append("   WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("     AND AMDT_SEQ = @[amdt_seq] - 1" ).append("\n"); 
		query.append("     AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("     AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                   FROM PRI_RP_SCP_RT A" ).append("\n"); 
		query.append("                  WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                    AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                    AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("					AND EXISTS (SELECT 'OK' FROM PRI_RP_SCP_RT_CMDT_HDR  X1 WHERE X1.PROP_NO = A.PROP_NO AND X1.AMDT_SEQ = A.AMDT_SEQ AND X1.SVC_SCP_CD = A.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ AND NVL(X1.FIC_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G'))" ).append("\n"); 
		query.append("                    AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                    AND A.GRI_APPL_TP_CD = 'A'" ).append("\n"); 
		query.append("                    AND A.CMDT_HDR_SEQ = T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND A.ROUT_SEQ = T.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND A.RT_SEQ = T.RT_SEQ)" ).append("\n"); 

	}
}