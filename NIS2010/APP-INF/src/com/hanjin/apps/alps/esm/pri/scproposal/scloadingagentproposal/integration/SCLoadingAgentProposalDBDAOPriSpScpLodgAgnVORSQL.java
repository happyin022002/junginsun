/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.04
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.04.04 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History---------------------------------------
	  * 2011.03.30 이행지 [CHM-201109659-01]  Loading Agent POA Attach(L/Agent section) 기능 개발요청
	  *                          - PRI_SP_SCP_LODG_AGN.POA_ATCH_FILE_ID 컬럼 추가로 인한 쿼리 수정
	  * </pre>
	  */
	public SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.integration").append("\n"); 
		query.append("FileName : SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVORSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append("	 , A.AMDT_SEQ" ).append("\n"); 
		query.append("	 , A.SVC_SCP_CD" ).append("\n"); 
		query.append("	 , A.LODG_AGN_SEQ" ).append("\n"); 
		query.append("	 , A.CUST_CNT_CD" ).append("\n"); 
		query.append("	 , LPAD(A.CUST_SEQ, 6, '0') CUST_SEQ" ).append("\n"); 
		query.append("	 , A.MNL_INP_FLG" ).append("\n"); 
		query.append("	 , A.CUST_NM" ).append("\n"); 
		query.append("	 , A.CUST_ADDR" ).append("\n"); 
		query.append("	 , A.CUST_LOC_CD" ).append("\n"); 
		query.append("	 , A.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("	 , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("		  FROM PRI_SP_SCP_MN " ).append("\n"); 
		query.append("		 WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("		   AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("		   AND SVC_SCP_CD = A.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("	 , CASE WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        	 ELSE (    " ).append("\n"); 
		query.append("        		   SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               				   ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               			  END AS EXP_DT" ).append("\n"); 
		query.append("        			 FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("        			WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1 AND SVC_SCP_CD = M.SVC_SCP_CD ) " ).append("\n"); 
		query.append(" 		END EXP_DT " ).append("\n"); 
		query.append("	 , A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	 , A.SRC_INFO_CD" ).append("\n"); 
		query.append("	 , FIRST_VALUE(A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6, '0')) OVER ( PARTITION BY A.LODG_AGN_SEQ ORDER BY A.AMDT_SEQ ) FIRST_ORDER" ).append("\n"); 
		query.append("	 , FIRST_VALUE(A.CUST_NM) OVER ( PARTITION BY A.LODG_AGN_SEQ ORDER BY A.AMDT_SEQ ) SECOND_ORDER" ).append("\n"); 
		query.append("     , A.POA_ATCH_FILE_ID" ).append("\n"); 
		query.append("	 , F.FILE_UPLD_NM AS POA_ATCH_FILE_NM" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_LODG_AGN A" ).append("\n"); 
		query.append("	 , PRI_SP_SCP_MN M" ).append("\n"); 
		query.append("	 , (SELECT  FILE_SAV_ID,FILE_UPLD_NM" ).append("\n"); 
		query.append("          FROM  COM_UPLD_FILE" ).append("\n"); 
		query.append("         WHERE  PGM_SUB_SYS_CD = 'PRI'" ).append("\n"); 
		query.append("           AND  DELT_FLG = 'N' )F" ).append("\n"); 
		query.append(" WHERE M.PROP_NO           	= A.PROP_NO" ).append("\n"); 
		query.append("   AND M.AMDT_SEQ          	= @[amdt_seq]" ).append("\n"); 
		query.append("   AND M.SVC_SCP_CD        	= A.SVC_SCP_CD " ).append("\n"); 
		query.append("   AND A.PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ IN ( @[amdt_seq], DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]), 'Y', @[amdt_seq], @[amdt_seq]-1))" ).append("\n"); 
		query.append("   AND (( A.AMDT_SEQ = @[amdt_seq] AND A.SRC_INFO_CD <> DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]),'Y','AD','ZZ'))" ).append("\n"); 
		query.append("       OR ( A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("            AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            AND  NOT EXISTS ( SELECT 'x' FROM PRI_SP_SCP_LODG_AGN B" ).append("\n"); 
		query.append("                               WHERE " ).append("\n"); 
		query.append("                			       B.PROP_NO         = A.PROP_NO " ).append("\n"); 
		query.append("                			   AND B.AMDT_SEQ        = @[amdt_seq]" ).append("\n"); 
		query.append("                			   AND B.SVC_SCP_CD      = A.SVC_SCP_CD " ).append("\n"); 
		query.append("                			   AND B.LODG_AGN_SEQ    = A.LODG_AGN_SEQ" ).append("\n"); 
		query.append("                			   AND B.N1ST_CMNC_AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ      " ).append("\n"); 
		query.append("			                 )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   AND A.POA_ATCH_FILE_ID = F.FILE_SAV_ID(+)" ).append("\n"); 
		query.append(" ORDER BY FIRST_ORDER, SECOND_ORDER, A.AMDT_SEQ" ).append("\n"); 

	}
}