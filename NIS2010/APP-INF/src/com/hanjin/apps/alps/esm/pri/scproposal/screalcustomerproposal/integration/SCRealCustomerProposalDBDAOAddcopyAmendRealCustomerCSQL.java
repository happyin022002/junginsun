/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCRealCustomerProposalDBDAOAddcopyAmendRealCustomerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.09
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.01.09 서미진
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

public class SCRealCustomerProposalDBDAOAddcopyAmendRealCustomerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 조건의 Real Customer 데이터를 Amend Seq + 1하여 추가합니다.
	  * </pre>
	  */
	public SCRealCustomerProposalDBDAOAddcopyAmendRealCustomerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.integration").append("\n"); 
		query.append("FileName : SCRealCustomerProposalDBDAOAddcopyAmendRealCustomerCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_REAL_CUST(" ).append("\n"); 
		query.append("       PROP_NO" ).append("\n"); 
		query.append("      ,AMDT_SEQ" ).append("\n"); 
		query.append("      ,REAL_CUST_SEQ" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ" ).append("\n"); 
		query.append("	  ,CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("      ,PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      ,CUST_SREP_CD" ).append("\n"); 
		query.append("      ,CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("      ,REP_CUST_FLG" ).append("\n"); 
		query.append("	  ,CUST_LOC_CD" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      )              " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("           PROP_NO" ).append("\n"); 
		query.append("          ,@[amdt_seq]+1" ).append("\n"); 
		query.append("          ,REAL_CUST_SEQ" ).append("\n"); 
		query.append("          ,CUST_CNT_CD" ).append("\n"); 
		query.append("          ,CUST_SEQ" ).append("\n"); 
		query.append("          ,CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("          ,PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("          ,CUST_SREP_CD" ).append("\n"); 
		query.append("          ,CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("          ,REP_CUST_FLG" ).append("\n"); 
		query.append("		  ,CUST_LOC_CD" ).append("\n"); 
		query.append("          ,@[cre_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("FROM PRI_SP_REAL_CUST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}