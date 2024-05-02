/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesActivityManageDBDAOAddActivityInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.09
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.09 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesActivityManageDBDAOAddActivityInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Activity 정보 입력
	  * </pre>
	  */
	public SalesActivityManageDBDAOAddActivityInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_mgr_cmt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cmt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plan_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("purpose1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cus_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("purpose2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("actual_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("channel",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOAddActivityInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAM_SLS_ACT (" ).append("\n"); 
		query.append("            SLS_ACT_SEQ" ).append("\n"); 
		query.append("          , SREP_CD" ).append("\n"); 
		query.append("          , CUST_CNT_CD" ).append("\n"); 
		query.append("          , CUST_SEQ" ).append("\n"); 
		query.append("          , SLS_MGR_CMT_DESC" ).append("\n"); 
		query.append("          , SREP_CMT_DESC" ).append("\n"); 
		query.append("          , CALL_RPT_FLG" ).append("\n"); 
		query.append("          , ACT_PLN_DT" ).append("\n"); 
		query.append("          , SLS_ACT_ACT_DT" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , ACT_CHNL_CD" ).append("\n"); 
		query.append("          , UPD_DT		" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , SLS_ACT_TP_CD" ).append("\n"); 
		query.append("          , SLS_ACT_SUB_TP_CD" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("VALUES (  (SELECT @[sls_code] || NVL(TRIM(TO_CHAR(MAX(SUBSTR(SLS_ACT_SEQ, 6, 8))+1,'000')), '001')" ).append("\n"); 
		query.append("          FROM SAM_SLS_ACT" ).append("\n"); 
		query.append("          WHERE CUST_CNT_CD = SUBSTR(@[cus_code],1,2)" ).append("\n"); 
		query.append("		  AND CUST_SEQ = SUBSTR(@[cus_code],3,6)" ).append("\n"); 
		query.append("          AND SREP_CD = @[sls_code] )" ).append("\n"); 
		query.append("       , @[sls_code]" ).append("\n"); 
		query.append("       , SUBSTR(@[cus_code],1,2)" ).append("\n"); 
		query.append("       , SUBSTR(@[cus_code],3,6)" ).append("\n"); 
		query.append("       , @[sls_mgr_cmt_desc]" ).append("\n"); 
		query.append("       , @[srep_cmt_desc]" ).append("\n"); 
		query.append("	   , 'N'" ).append("\n"); 
		query.append("       , @[plan_dt]" ).append("\n"); 
		query.append("       , @[actual_dt]" ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[channel]" ).append("\n"); 
		query.append("       , SYSDATE       " ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , @[purpose1]" ).append("\n"); 
		query.append("       , @[purpose2]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}