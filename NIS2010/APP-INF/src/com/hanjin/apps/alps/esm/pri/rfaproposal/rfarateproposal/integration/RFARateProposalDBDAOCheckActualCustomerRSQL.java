/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFARateProposalDBDAOCheckActualCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.19
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.19 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOCheckActualCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Type이 Contract 일때, actual customer check
	  * </pre>
	  */
	public RFARateProposalDBDAOCheckActualCustomerRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOCheckActualCustomerRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT CUST_CNT_CD, LPAD(CUST_SEQ,6,0) AS CUST_SEQ , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_ACT_CUST " ).append("\n"); 
		query.append(" WHERE 1=1  " ).append("\n"); 
		query.append("  AND PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("  AND CMDT_HDR_SEQ =  (SELECT MIN(CMDT_HDR_SEQ) FROM PRI_RP_SCP_RT_CMDT " ).append("\n"); 
		query.append("                        WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD <> 'AD')" ).append("\n"); 

	}
}