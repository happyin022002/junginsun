/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCMQCProposalDBDAOPriSpScpMqcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCMQCProposalDBDAOPriSpScpMqcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    RsltpriSpScpMqcVO 생성쿼리
	  * </pre>
	  */
	public SCMQCProposalDBDAOPriSpScpMqcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.integration").append("\n"); 
		query.append("FileName : SCMQCProposalDBDAOPriSpScpMqcVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     A.PROP_NO" ).append("\n"); 
		query.append("    ,A.AMDT_SEQ" ).append("\n"); 
		query.append("    ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("    ,A.CNTR_LOD_UT_CD " ).append("\n"); 
		query.append("    ,A.PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append("    ,A.COFFR_MQC_QTY" ).append("\n"); 
		query.append("    ,A.FNL_MQC_QTY" ).append("\n"); 
		query.append("	,A.N1ST_CMNC_AMDT_SEQ		" ).append("\n"); 
		query.append("    ,(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_SP_SCP_MN WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("										AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ  AND SVC_SCP_CD = A.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("    ,CASE" ).append("\n"); 
		query.append("        WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("        (    " ).append("\n"); 
		query.append("        SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("        FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("        WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1 AND SVC_SCP_CD = M.SVC_SCP_CD    " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    END  EXP_DT " ).append("\n"); 
		query.append("    ,A.SRC_INFO_CD" ).append("\n"); 
		query.append("    ,SRC.INTG_CD_VAL_DESC SRC_INFO_NM       " ).append("\n"); 
		query.append("    ,A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("    ,STS.INTG_CD_VAL_DESC PRC_PROG_STS_NM" ).append("\n"); 
		query.append("    ,A.ACPT_USR_ID" ).append("\n"); 
		query.append("    ,A.ACPT_OFC_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(A.ACPT_DT,'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(M.EFF_DT, 'YYYYMMDD') MN_EFF_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(M.EXP_DT, 'YYYYMMDD') MN_EXP_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(D.CTRT_EFF_DT, 'YYYYMMDD') DU_EFF_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(D.CTRT_EXP_DT, 'YYYYMMDD') DU_EXP_DT	" ).append("\n"); 
		query.append("      ,NVL((    " ).append("\n"); 
		query.append("        SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN 'Y'" ).append("\n"); 
		query.append("               ELSE 'N'" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("         WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1 AND SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("       ),'N') DUR_DUP_FLG" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("    PRI_SP_SCP_MQC      A  ," ).append("\n"); 
		query.append("    PRI_SP_SCP_MN       M  ," ).append("\n"); 
		query.append("	PRI_SP_SCP_DUR		D  ," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL     SRC," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL     STS" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("    M.PROP_NO      = A.PROP_NO" ).append("\n"); 
		query.append("AND M.SVC_SCP_CD   = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND M.PROP_NO	   = D.PROP_NO" ).append("\n"); 
		query.append("AND M.SVC_SCP_CD   = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND M.AMDT_SEQ	   = D.AMDT_SEQ" ).append("\n"); 
		query.append("AND M.AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PROP_NO      = @[prop_no]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ IN ( @[amdt_seq], @[amdt_seq]-1)" ).append("\n"); 
		query.append("AND    (( A.AMDT_SEQ = @[amdt_seq] AND A.SRC_INFO_CD <> 'ZZ')" ).append("\n"); 
		query.append("       OR ( A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("            AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            AND  NOT EXISTS ( SELECT 'X' FROM PRI_SP_SCP_MQC B" ).append("\n"); 
		query.append("                               WHERE " ).append("\n"); 
		query.append("                                   B.PROP_NO         = A.PROP_NO " ).append("\n"); 
		query.append("                               AND B.AMDT_SEQ        = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND B.SVC_SCP_CD      = A.SVC_SCP_CD " ).append("\n"); 
		query.append("                               AND B.N1ST_CMNC_AMDT_SEQ    = A.N1ST_CMNC_AMDT_SEQ           " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("AND SRC.INTG_CD_VAL_CTNT = A.SRC_INFO_CD" ).append("\n"); 
		query.append("AND SRC.INTG_CD_ID       = 'CD02064'" ).append("\n"); 
		query.append("AND STS.INTG_CD_VAL_CTNT = A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("AND STS.INTG_CD_ID       = 'CD01719'" ).append("\n"); 
		query.append("ORDER BY A.AMDT_SEQ" ).append("\n"); 

	}
}