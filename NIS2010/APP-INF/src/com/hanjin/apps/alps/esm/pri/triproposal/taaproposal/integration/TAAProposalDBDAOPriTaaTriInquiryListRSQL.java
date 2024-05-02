/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TAAProposalDBDAOPriTaaTriInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOPriTaaTriInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TAA Inquiry List 조회
	  * </pre>
	  */
	public TAAProposalDBDAOPriTaaTriInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOPriTaaTriInquiryListRSQL").append("\n"); 
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
		query.append("SELECT B1.TAA_NO" ).append("\n"); 
		query.append("     , A1.TRI_PROP_NO" ).append("\n"); 
		query.append("     , B1.SVC_SCP_CD" ).append("\n"); 
		query.append("     , B1.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , B1.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("     , B1.CTRT_CUST_NM" ).append("\n"); 
		query.append("     , B1.RESPB_SREP_CD" ).append("\n"); 
		query.append("     , B1.RESPB_SREP_NM" ).append("\n"); 
		query.append("     , B1.EFF_DT" ).append("\n"); 
		query.append("     , B1.EXP_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.TRI_PROP_NO" ).append("\n"); 
		query.append("             , B.EFF_DT" ).append("\n"); 
		query.append("             , B.EXP_DT" ).append("\n"); 
		query.append("             , B.AMDT_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                  FROM PRI_TRI_MN" ).append("\n"); 
		query.append("                 WHERE TRI_NO = REPLACE(@[tri_no],'-','')" ).append("\n"); 
		query.append("                   AND TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("                   AND TRF_NO = @[trf_no]) A" ).append("\n"); 
		query.append("             , (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                     , TO_CHAR(EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("                     , TO_CHAR(EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("                     , AMDT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT A" ).append("\n"); 
		query.append("                 WHERE PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("				 AND   AMDT_SEQ = (SELECT MAX(AMDT_SEQ) FROM PRI_TRI_RT " ).append("\n"); 
		query.append("								   WHERE A.TRI_PROP_NO = TRI_PROP_NO " ).append("\n"); 
		query.append("								   AND PROP_STS_CD='F')" ).append("\n"); 
		query.append("				) B" ).append("\n"); 
		query.append("         WHERE A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("       ) A1" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT D.TRI_PROP_NO" ).append("\n"); 
		query.append("             , A.TAA_NO" ).append("\n"); 
		query.append("             , B.SVC_SCP_CD" ).append("\n"); 
		query.append("             , B.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("             , B.CTRT_CUST_CNT_CD || LPAD(B.CTRT_CUST_SEQ, 6, '0') AS CTRT_CUST_SEQ" ).append("\n"); 
		query.append("             , (SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("                 WHERE CUST_CNT_CD = CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("                   AND CUST_SEQ = CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N') AS CTRT_CUST_NM" ).append("\n"); 
		query.append("             , B.RESPB_SREP_CD" ).append("\n"); 
		query.append("             , (SELECT SREP_NM " ).append("\n"); 
		query.append("                  FROM MDM_SLS_REP " ).append("\n"); 
		query.append("                 WHERE SREP_CD = RESPB_SREP_CD) AS RESPB_SREP_NM" ).append("\n"); 
		query.append("             , TO_CHAR(B.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("             , TO_CHAR(B.EXP_DT, 'YYYYMMDD') AS EXP_DT    " ).append("\n"); 
		query.append("             , B.AMDT_SEQ" ).append("\n"); 
		query.append("          FROM PRI_TAA_HDR A" ).append("\n"); 
		query.append("             , PRI_TAA_MN B" ).append("\n"); 
		query.append("             , (SELECT TAA_PROP_NO" ).append("\n"); 
		query.append("                     , MAX(AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_TAA_MN" ).append("\n"); 
		query.append("                 WHERE CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                GROUP BY TAA_PROP_NO) C" ).append("\n"); 
		query.append("             , PRI_TAA_TRI_LIST D" ).append("\n"); 
		query.append("         WHERE A.TAA_PROP_NO = B.TAA_PROP_NO" ).append("\n"); 
		query.append("           AND B.TAA_PROP_NO = C.TAA_PROP_NO" ).append("\n"); 
		query.append("           AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("           AND B.TAA_PROP_NO = D.TAA_PROP_NO" ).append("\n"); 
		query.append("           AND B.AMDT_SEQ = D.AMDT_SEQ" ).append("\n"); 
		query.append("        ORDER BY TRI_PROP_NO" ).append("\n"); 
		query.append("      ) B1" ).append("\n"); 
		query.append(" WHERE A1.TRI_PROP_NO = B1.TRI_PROP_NO" ).append("\n"); 
		query.append(" AND (B1.EXP_DT >= A1.EFF_DT AND B1.EFF_DT <= A1.EXP_DT )" ).append("\n"); 
		query.append("ORDER BY B1.TAA_NO" ).append("\n"); 

	}
}