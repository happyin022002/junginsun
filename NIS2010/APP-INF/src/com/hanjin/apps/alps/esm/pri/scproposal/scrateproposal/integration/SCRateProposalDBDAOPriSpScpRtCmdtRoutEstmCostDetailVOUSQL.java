/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtCmdtRoutEstmCostDetailVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtCmdtRoutEstmCostDetailVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtCmdtRoutEstmCostDetailVOUSQL(){
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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtCmdtRoutEstmCostDetailVOUSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("MERGE INTO PRI_SP_SCP_RT_CMDT_ROUT A " ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("        ,PRC_CGO_TP_CD AS CGO_TP_CD" ).append("\n"); 
		query.append("        ,RAT_UT_CD" ).append("\n"); 
		query.append("        ,PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("        ,PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("        ,PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("        FROM   (       " ).append("\n"); 
		query.append("        SELECT  A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,A.CMDT_HDR_SEQ, A.ROUT_SEQ" ).append("\n"); 
		query.append("              ,B.PRC_CGO_TP_CD, B.RAT_UT_CD" ).append("\n"); 
		query.append("              ,B.PRS_RESPB_CMPB_AMT, B.PRS_PFIT_CMPB_AMT, B.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("		      ,ROW_NUMBER() OVER(PARTITION BY A.PROP_NO,A.AMDT_SEQ,A.SVC_SCP_CD,A.GEN_SPCL_RT_TP_CD,A.CMDT_HDR_SEQ,A.ROUT_SEQ " ).append("\n"); 
		query.append("	               ORDER BY DECODE(B.PRC_CGO_TP_CD,'DR','00','RF','01','DG','02','AK','03','04')" ).append("\n"); 
		query.append("	           || DECODE(B.RAT_UT_CD, 'D4','00', 'D5','01','02')    " ).append("\n"); 
		query.append("	           || DECODE(M.CNTR_SZ_CD,'4','00','2','01','3','02','5','03','6','04','7','05','8','06','9','07','W','08','X','09','10')" ).append("\n"); 
		query.append("	           ) RNK" ).append("\n"); 
		query.append("         FROM  PRI_SP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_RT B" ).append("\n"); 
		query.append("              ,PRI_RAT_UT M" ).append("\n"); 
		query.append("        WHERE    A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND  A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND  A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND  A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("           AND  A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND  A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("           AND  B.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("          AND  A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("          AND  A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("          AND  A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("          AND  A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("          AND  A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("          AND  A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("           AND  B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("          AND  B.RAT_UT_CD = M.RAT_UT_CD       " ).append("\n"); 
		query.append("          AND  B.PRS_RESPB_CMPB_AMT IS NOT NULL" ).append("\n"); 
		query.append("          )   " ).append("\n"); 
		query.append("          WHERE RNK = 1   " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("   A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND  A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND  A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND  A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("   AND  A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND  A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.PRS_RAT_UT_CD = B.RAT_UT_CD" ).append("\n"); 
		query.append("        ,A.PRS_CGO_TP_CD = B.CGO_TP_CD" ).append("\n"); 
		query.append("        ,A.PRS_ESTM_RESPB_CMPB_AMT = B.PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("        ,A.PRS_ESTM_PFIT_CMPB_AMT = B.PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("        ,A.PRS_ESTM_RESPB_OPB_AMT = B.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("        ,PRS_UPD_DT = SYSDATE" ).append("\n"); 

	}
}