/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageDBDAOAddSalesReportInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.06.15 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesActivityManageDBDAOAddSalesReportInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Activity Report 화면의 1번째 탭 ( Sales Report ) 생성 후 저장용 쿼리
	  * </pre>
	  */
	public SalesActivityManageDBDAOAddSalesReportInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rpt_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_prmt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nxt_pln_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_act_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rpt_smry_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgs_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vst_plc_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgs_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_rpt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_pln_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_area_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prb_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_act_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prb_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOAddSalesReportInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAM_SLS_ACT_RPT (" ).append("\n"); 
		query.append("            CUST_CNT_CD" ).append("\n"); 
		query.append("          , CUST_SEQ" ).append("\n"); 
		query.append("          , SREP_CD" ).append("\n"); 
		query.append("          , SLS_ACT_SEQ" ).append("\n"); 
		query.append("          , SLS_ACT_ACT_DT" ).append("\n"); 
		query.append("          , CNTC_PSON_NM" ).append("\n"); 
		query.append("          , SLS_RPT_CLSS_CD" ).append("\n"); 
		query.append("          , SLS_RPT_SMRY_DESC" ).append("\n"); 
		query.append("          , PRB_CLSS_CD" ).append("\n"); 
		query.append("          , PRB_DESC" ).append("\n"); 
		query.append("          , SGS_CLSS_CD" ).append("\n"); 
		query.append("          , SGS_DESC" ).append("\n"); 
		query.append("          , NXT_PLN_CLSS_CD" ).append("\n"); 
		query.append("          , NXT_PLN_DESC" ).append("\n"); 
		query.append("          , VST_PLC_CTNT" ).append("\n"); 
		query.append("          , SLS_PRMT_DESC" ).append("\n"); 
		query.append("          , BIZ_AREA_CD" ).append("\n"); 
		query.append("    	  , FREE_RPT_CTNT" ).append("\n"); 
		query.append("    	  , CRE_USR_ID" ).append("\n"); 
		query.append("    	  , CRE_DT" ).append("\n"); 
		query.append("    	  , UPD_USR_ID" ).append("\n"); 
		query.append("    	  , UPD_DT         ) " ).append("\n"); 
		query.append("VALUES ( @[cust_cnt_cd]" ).append("\n"); 
		query.append("       , @[cust_seq]" ).append("\n"); 
		query.append("       , @[srep_cd]" ).append("\n"); 
		query.append("       , @[sls_act_seq]" ).append("\n"); 
		query.append("       , @[sls_act_act_dt]" ).append("\n"); 
		query.append("       , @[cntc_pson_nm]" ).append("\n"); 
		query.append("       , @[sls_rpt_clss_cd]" ).append("\n"); 
		query.append("       , @[sls_rpt_smry_desc]" ).append("\n"); 
		query.append("       , @[prb_clss_cd]" ).append("\n"); 
		query.append("       , @[prb_desc]" ).append("\n"); 
		query.append("       , @[sgs_clss_cd]" ).append("\n"); 
		query.append("       , @[sgs_desc]" ).append("\n"); 
		query.append("       , @[nxt_pln_clss_cd]" ).append("\n"); 
		query.append("       , @[nxt_pln_desc]" ).append("\n"); 
		query.append("       , @[vst_plc_ctnt]" ).append("\n"); 
		query.append("       , @[sls_prmt_desc]" ).append("\n"); 
		query.append("       , @[biz_area_cd]" ).append("\n"); 
		query.append("       , @[free_rpt_ctnt]" ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}