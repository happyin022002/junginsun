/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCBoilerPlateProposalDBDAOPriSpBlplVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.05 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateProposalDBDAOPriSpBlplVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCBoilerPlateProposalDBDAOPriSpBlplVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.integration").append("\n"); 
		query.append("FileName : SCBoilerPlateProposalDBDAOPriSpBlplVORSQL").append("\n"); 
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
		query.append("     A.PROP_NO             " ).append("\n"); 
		query.append("    ,A.AMDT_SEQ            " ).append("\n"); 
		query.append("    ,A.BLPL_SEQ           " ).append("\n"); 
		query.append("	,A.BLPL_TIT_NM" ).append("\n"); 
		query.append("	,A.DP_SEQ" ).append("\n"); 
		query.append("    ,A.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("    ,(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_SP_MN WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("										AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ  ) EFF_DT" ).append("\n"); 
		query.append("    ,CASE" ).append("\n"); 
		query.append("        WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("        (    " ).append("\n"); 
		query.append("        SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("        FROM PRI_SP_MN N" ).append("\n"); 
		query.append("        WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1    " ).append("\n"); 
		query.append("        )    " ).append("\n"); 
		query.append("    END  EXP_DT                " ).append("\n"); 
		query.append("    ,A.SRC_INFO_CD            " ).append("\n"); 
		query.append("    ,SRC.INTG_CD_VAL_DESC SRC_INFO_DTL       " ).append("\n"); 
		query.append("    ,A.PRC_PROG_STS_CD " ).append("\n"); 
		query.append("    ,STS.INTG_CD_VAL_DESC PRC_PROG_STS_DTL " ).append("\n"); 
		query.append("    ,A.ACPT_USR_ID" ).append("\n"); 
		query.append("    ,A.ACPT_OFC_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(A.ACPT_DT,'YYYYMMDD') ACPT_DT	" ).append("\n"); 
		query.append("    ,DPSEQ.MAX_DP_SEQ" ).append("\n"); 
		query.append("    ,(SELECT MAX(DP_SEQ) FROM PRI_SP_BLPL_CTNT " ).append("\n"); 
		query.append("	  WHERE A.PROP_NO = PROP_NO " ).append("\n"); 
		query.append("	  AND A.BLPL_SEQ = BLPL_SEQ" ).append("\n"); 
		query.append("	  and AMDT_SEQ = @[amdt_seq] - 1) MAX_DP_SEQ_CTNT" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("     PRI_SP_BLPL        A  " ).append("\n"); 
		query.append("    ,PRI_SP_MN          M  " ).append("\n"); 
		query.append("    ,COM_INTG_CD_DTL    SRC" ).append("\n"); 
		query.append("    ,COM_INTG_CD_DTL    STS" ).append("\n"); 
		query.append("    ,(SELECT MAX(DP_SEQ) MAX_DP_SEQ " ).append("\n"); 
		query.append("	  FROM PRI_SP_BLPL " ).append("\n"); 
		query.append("	  WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	  AND AMDT_SEQ = @[amdt_seq] - 1) DPSEQ" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("    M.PROP_NO           = A.PROP_NO" ).append("\n"); 
		query.append("AND M.AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ IN ( @[amdt_seq], DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]), 'Y', @[amdt_seq], @[amdt_seq]-1))" ).append("\n"); 
		query.append("AND    (( A.AMDT_SEQ = @[amdt_seq] AND A.SRC_INFO_CD <> DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]),'Y','AD','ZZ'))" ).append("\n"); 
		query.append("       OR ( A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("            AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            AND  NOT EXISTS ( SELECT 'X' FROM PRI_SP_BLPL B" ).append("\n"); 
		query.append("                               WHERE " ).append("\n"); 
		query.append("                                   B.PROP_NO         = A.PROP_NO " ).append("\n"); 
		query.append("                               AND B.AMDT_SEQ        = @[amdt_seq]" ).append("\n"); 
		query.append("							   AND B.BLPL_SEQ		 = A.BLPL_SEQ" ).append("\n"); 
		query.append("                               AND B.N1ST_CMNC_AMDT_SEQ    = A.N1ST_CMNC_AMDT_SEQ          " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("		   AND EXISTS (SELECT 'X' FROM PRI_SP_BLPL_CTNT B " ).append("\n"); 
		query.append("					   WHERE A.PROP_NO = B.PROP_NO " ).append("\n"); 
		query.append("                       AND B.AMDT_SEQ  =  @[amdt_seq]" ).append("\n"); 
		query.append("                       AND A.BLPL_SEQ  = B.BLPL_SEQ )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("AND SRC.INTG_CD_VAL_CTNT = A.SRC_INFO_CD" ).append("\n"); 
		query.append("AND SRC.INTG_CD_ID       = 'CD02064'" ).append("\n"); 
		query.append("AND STS.INTG_CD_VAL_CTNT = A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("AND STS.INTG_CD_ID       = 'CD01719'       " ).append("\n"); 
		query.append("ORDER BY A.DP_SEQ, A.BLPL_SEQ, A.AMDT_SEQ" ).append("\n"); 

	}
}