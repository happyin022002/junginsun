/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRealCustomerProposalDBDAOAddRealCustomerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.09
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.11.09 서미진
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

public class SCRealCustomerProposalDBDAOAddRealCustomerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Real Customer를 추가한다.
	  * </pre>
	  */
	public SCRealCustomerProposalDBDAOAddRealCustomerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_val_sgm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.integration").append("\n"); 
		query.append("FileName : SCRealCustomerProposalDBDAOAddRealCustomerCSQL").append("\n"); 
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
		query.append("       VALUES(" ).append("\n"); 
		query.append("           @[prop_no]" ).append("\n"); 
		query.append("          ,@[amdt_seq]" ).append("\n"); 
		query.append("          ,(SELECT NVL(MAX(REAL_CUST_SEQ)+1,'000') " ).append("\n"); 
		query.append("              FROM PRI_SP_REAL_CUST" ).append("\n"); 
		query.append("             WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("               AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("          ,@[cust_cnt_cd]" ).append("\n"); 
		query.append("          ,@[cust_seq]" ).append("\n"); 
		query.append("  	      ,@[cust_val_sgm_cd]" ).append("\n"); 
		query.append("          ,@[prc_ctrt_cust_tp_cd]" ).append("\n"); 
		query.append("          ,@[cust_srep_cd]" ).append("\n"); 
		query.append("          ,@[cust_sls_ofc_cd]" ).append("\n"); 
		query.append("          ,@[rep_cust_flg]" ).append("\n"); 
		query.append("		  ,@[cust_loc_cd]" ).append("\n"); 
		query.append("          ,@[cre_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}