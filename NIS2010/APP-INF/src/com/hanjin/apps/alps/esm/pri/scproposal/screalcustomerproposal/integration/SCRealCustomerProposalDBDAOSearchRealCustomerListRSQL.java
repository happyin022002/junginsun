/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRealCustomerProposalDBDAOSearchRealCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.11
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.11.11 서미진
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

public class SCRealCustomerProposalDBDAOSearchRealCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Real Customer를 조회한다.
	  * </pre>
	  */
	public SCRealCustomerProposalDBDAOSearchRealCustomerListRSQL(){
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
		query.append("FileName : SCRealCustomerProposalDBDAOSearchRealCustomerListRSQL").append("\n"); 
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
		query.append("SELECT PRI.REAL_CUST_SEQ" ).append("\n"); 
		query.append("      ,PRI.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(PRI.CUST_SEQ,'FM000000') AS CUST_SEQ" ).append("\n"); 
		query.append("      ,PRI.CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("      ,PRI.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      ,PRI.CUST_SREP_CD" ).append("\n"); 
		query.append("      ,PRI.CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("      ,PRI.REP_CUST_FLG" ).append("\n"); 
		query.append("      ,PRI.PROP_NO" ).append("\n"); 
		query.append("      ,PRI.AMDT_SEQ" ).append("\n"); 
		query.append("      ,CUST.CUST_LGL_ENG_NM REAL_CUST_NM" ).append("\n"); 
		query.append("      ,REP.SREP_NM REAL_CUST_SREP_NM" ).append("\n"); 
		query.append("      ,VAL.INTG_CD_VAL_DP_DESC REAL_CUST_VAL_SGM" ).append("\n"); 
		query.append("	  ,PRI.CUST_LOC_CD" ).append("\n"); 
		query.append("FROM PRI_SP_REAL_CUST PRI" ).append("\n"); 
		query.append("    ,MDM_SLS_REP REP" ).append("\n"); 
		query.append("    ,MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("    ,COM_INTG_CD_DTL VAL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD = PRI.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = PRI.CUST_SEQ" ).append("\n"); 
		query.append("AND REP.SREP_CD = PRI.CUST_SREP_CD" ).append("\n"); 
		query.append("AND VAL.INTG_CD_ID(+) = 'CD00698'" ).append("\n"); 
		query.append("AND VAL.INTG_CD_VAL_CTNT(+) = PRI.CUST_VAL_SGM_CD" ).append("\n"); 

	}
}