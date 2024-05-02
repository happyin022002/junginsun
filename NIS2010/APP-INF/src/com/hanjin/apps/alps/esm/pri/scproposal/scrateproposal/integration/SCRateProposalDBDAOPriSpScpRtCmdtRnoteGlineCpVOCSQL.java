/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtCmdtRnoteGlineCpVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtCmdtRnoteGlineCpVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMDT note 입력
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtCmdtRnoteGlineCpVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtCmdtRnoteGlineCpVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("  (PROP_NO" ).append("\n"); 
		query.append("  ,AMDT_SEQ" ).append("\n"); 
		query.append("  ,SVC_SCP_CD" ).append("\n"); 
		query.append("  ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("  ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("  ,ROUT_SEQ" ).append("\n"); 
		query.append("  ,ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("  ,NOTE_CLSS_CD" ).append("\n"); 
		query.append("  ,CHG_CD" ).append("\n"); 
		query.append("  ,NOTE_CTNT" ).append("\n"); 
		query.append("  ,NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("  ,NOTE_CHG_TP_CD" ).append("\n"); 
		query.append("  ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("  ,SRC_INFO_CD" ).append("\n"); 
		query.append("  ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT)" ).append("\n"); 
		query.append("  SELECT @[prop_no]" ).append("\n"); 
		query.append("        ,@[amdt_seq]" ).append("\n"); 
		query.append("        ,@[svc_scp_cd]" ).append("\n"); 
		query.append("        ,@[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,ROUT_SEQ" ).append("\n"); 
		query.append("        ,ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("        ,NOTE_CLSS_CD" ).append("\n"); 
		query.append("        ,CHG_CD" ).append("\n"); 
		query.append("        ,NOTE_CTNT" ).append("\n"); 
		query.append("        ,SYS_GUID()" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,'I'" ).append("\n"); 
		query.append("        ,'GC'" ).append("\n"); 
		query.append("        ,@[amdt_seq]" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("    FROM (SELECT DENSE_RANK() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD ORDER BY CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,DENSE_RANK() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ ORDER BY ROUT_SEQ) AS ROUT_SEQ" ).append("\n"); 
		query.append("                ,DENSE_RANK() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY ROUT_NOTE_SEQ) AS ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("                ,NOTE_CLSS_CD" ).append("\n"); 
		query.append("                ,CHG_CD" ).append("\n"); 
		query.append("                ,NOTE_CTNT" ).append("\n"); 
		query.append("            FROM (SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append("                        ,B.GLINE_SEQ" ).append("\n"); 
		query.append("                        ,B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("                        ,B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        ,C.ROUT_SEQ" ).append("\n"); 
		query.append("                        ,D.ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("                        ,D.NOTE_CLSS_CD" ).append("\n"); 
		query.append("                        ,D.CHG_CD" ).append("\n"); 
		query.append("                        ,D.NOTE_CTNT" ).append("\n"); 
		query.append("                    FROM (SELECT T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                ,T.GLINE_SEQ" ).append("\n"); 
		query.append("                                ,RANK() OVER(PARTITION BY SVC_SCP_CD ORDER BY EFF_DT DESC) AS RNK" ).append("\n"); 
		query.append("                            FROM PRI_SG_MN T" ).append("\n"); 
		query.append("                           WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN T.EFF_DT AND T.EXP_DT" ).append("\n"); 
		query.append("                             AND T.CFM_FLG = 'Y') A" ).append("\n"); 
		query.append("                        ,PRI_SG_RT_CMDT_HDR B" ).append("\n"); 
		query.append("                        ,PRI_SG_RT_CMDT_ROUT C" ).append("\n"); 
		query.append("                        ,PRI_SG_RT_CMDT_RNOTE D" ).append("\n"); 
		query.append("                   WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("                     AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND B.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("                     AND B.PRC_CUST_TP_CD = C.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("                     AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND C.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                     AND C.GLINE_SEQ = D.GLINE_SEQ(+)" ).append("\n"); 
		query.append("                     AND C.PRC_CUST_TP_CD = D.PRC_CUST_TP_CD(+)" ).append("\n"); 
		query.append("                     AND C.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                     AND C.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.RNK = 1" ).append("\n"); 
		query.append("                     AND B.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                     AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN B.EFF_DT AND B.EXP_DT) T" ).append("\n"); 
		query.append("           WHERE EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                           FROM PRI_SG_RT S, PRI_SP_MQC MN, PRI_SP_SCP_MQC SCP" ).append("\n"); 
		query.append("                          WHERE S.SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("                            AND S.GLINE_SEQ = T.GLINE_SEQ" ).append("\n"); 
		query.append("                            AND S.PRC_CUST_TP_CD = T.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("                            AND S.CMDT_HDR_SEQ = T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                            AND S.ROUT_SEQ = T.ROUT_SEQ" ).append("\n"); 
		query.append("                            AND MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                            AND MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                            AND MN.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("                            AND MN.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("                            AND SCP.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                            AND DECODE(SCP.PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append("                                      ,0" ).append("\n"); 
		query.append("                                      ,MN.PROP_MQC_QTY" ).append("\n"); 
		query.append("                                      ,SCP.PROP_SCP_MQC_QTY) BETWEEN S.MQC_RNG_FM_QTY AND S.MQC_RNG_TO_QTY) " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   WHERE NOTE_CLSS_CD IS NOT NULL" ).append("\n"); 

	}
}