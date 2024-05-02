/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRealCustomerProposalDBDAOSearchAffiliateLoadingagentInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.10
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.11.10 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRealCustomerProposalDBDAOSearchAffiliateLoadingagentInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Affiliate와 Loading Agent 의 cust 정보를 조회한다.
	  * </pre>
	  */
	public SCRealCustomerProposalDBDAOSearchAffiliateLoadingagentInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.integration").append("\n"); 
		query.append("FileName : SCRealCustomerProposalDBDAOSearchAffiliateLoadingagentInfoRSQL").append("\n"); 
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
		query.append("    ,A.AMDT_SEQ                   " ).append("\n"); 
		query.append("	,A.CUST_CNT_CD" ).append("\n"); 
		query.append("	,LPAD(A.CUST_SEQ, 6, '0') CUST_SEQ" ).append("\n"); 
		query.append("	,A.CUST_LOC_CD" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("     PRI_SP_AFIL        A  " ).append("\n"); 
		query.append("    ,PRI_SP_MN          M  " ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("    M.PROP_NO           	= A.PROP_NO" ).append("\n"); 
		query.append("AND M.AMDT_SEQ          	= @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PROP_NO 				= @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ          	= @[amdt_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT A.PROP_NO" ).append("\n"); 
		query.append("	 , A.AMDT_SEQ" ).append("\n"); 
		query.append("	 , A.CUST_CNT_CD" ).append("\n"); 
		query.append("	 , LPAD(A.CUST_SEQ, 6, '0') CUST_SEQ" ).append("\n"); 
		query.append("	 , A.CUST_LOC_CD" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_LODG_AGN A" ).append("\n"); 
		query.append("	 , PRI_SP_SCP_MN M" ).append("\n"); 
		query.append(" WHERE M.PROP_NO           	= A.PROP_NO" ).append("\n"); 
		query.append("   AND M.AMDT_SEQ          	= @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ          	= @[amdt_seq]" ).append("\n"); 
		query.append("   AND M.SVC_SCP_CD        	= A.SVC_SCP_CD " ).append("\n"); 
		query.append("   AND A.PROP_NO 			= @[prop_no]" ).append("\n"); 

	}
}