/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArApprovalDBDAOUpdateAproGwFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.24 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArApprovalDBDAOUpdateAproGwFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR_INV_HDR 의 RQST_APRO_STEP_FLG, 생성 날짜 업데이트
	  * </pre>
	  */
	public ArApprovalDBDAOUpdateAproGwFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_cfm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_jb_tit_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration ").append("\n"); 
		query.append("FileName : ArApprovalDBDAOUpdateAproGwFlgUSQL").append("\n"); 
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
		query.append("UPDATE AR_INV_HDR " ).append("\n"); 
		query.append("SET CSR_APRO_TP_CD = @[csr_apro_tp_cd]" ).append("\n"); 
		query.append("	,APRO_USR_JB_TIT_CD = @[apro_usr_jb_tit_cd]" ).append("\n"); 
		query.append("	,AP_ACCT_VER_NO = @[ver_no]" ).append("\n"); 
		query.append("	,CSR_APRO_STEP_ASGN_RQST_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("	,RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("	,CSR_USD_AMT = @[csr_usd_amt]" ).append("\n"); 
		query.append("	,ACCT_XCH_RT_YRMON = @[acct_xch_rt_yrmon]" ).append("\n"); 
		query.append("	,AGMT_DOC_CFM_CD = @[agmt_doc_cfm_cd]" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}