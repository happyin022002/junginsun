/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesActivityManageDBDAOSearchCustSatisFactionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.17
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.17 서미진
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

public class SalesActivityManageDBDAOSearchCustSatisFactionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Activity Report 화면의 3번째 탭 ( Cust.SatisFaction ) 조회용 쿼리
	  * </pre>
	  */
	public SalesActivityManageDBDAOSearchCustSatisFactionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sls_act_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOSearchCustSatisFactionRSQL").append("\n"); 
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
		query.append("SELECT CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , SREP_CD" ).append("\n"); 
		query.append("     , SLS_ACT_SEQ" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'SES', CUST_SATSFC_GRD_CD, null)) SES" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'SCR', CUST_SATSFC_GRD_CD, null)) SCR" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'EQS', CUST_SATSFC_GRD_CD, null)) EQS" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'CAH', CUST_SATSFC_GRD_CD, null)) CAH" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'SEP', CUST_SATSFC_GRD_CD, null)) SEP" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'REL', CUST_SATSFC_GRD_CD, null)) REL" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'USF', CUST_SATSFC_GRD_CD, null)) USF" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'BOC', CUST_SATSFC_GRD_CD, null)) BOC" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'DOB', CUST_SATSFC_GRD_CD, null)) DOB" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'ATS', CUST_SATSFC_GRD_CD, null)) ATS" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'CLH', CUST_SATSFC_GRD_CD, null)) CLH" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'QUR', CUST_SATSFC_GRD_CD, null)) QUR" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'CUN', CUST_SATSFC_GRD_CD, null)) CUN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'SRC', CUST_SATSFC_GRD_CD, null)) SRC" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'SES', CUST_SATSFC_RSN)) SES_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'SCR', CUST_SATSFC_RSN)) SCR_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'EQS', CUST_SATSFC_RSN)) EQS_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'CAH', CUST_SATSFC_RSN)) CAH_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'SEP', CUST_SATSFC_RSN)) SEP_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'REL', CUST_SATSFC_RSN)) REL_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'USF', CUST_SATSFC_RSN)) USF_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'BOC', CUST_SATSFC_RSN)) BOC_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'DOB', CUST_SATSFC_RSN)) DOB_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'ATS', CUST_SATSFC_RSN)) ATS_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'CLH', CUST_SATSFC_RSN)) CLH_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'QUR', CUST_SATSFC_RSN)) QUR_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'CUN', CUST_SATSFC_RSN)) CUN_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'WSI', CUST_SATSFC_RSN)) WSI_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'CUR', CUST_SATSFC_RSN)) CUR_RSN" ).append("\n"); 
		query.append("     , MAX(DECODE(CUST_SATSFC_ITM_CD, 'SRC', CUST_SATSFC_RSN)) SRC_RSN" ).append("\n"); 
		query.append("FROM SAM_CUST_SATSFC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SREP_CD 	= @[srep_cd]" ).append("\n"); 
		query.append("AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ	= @[cust_seq]" ).append("\n"); 
		query.append("AND SLS_ACT_SEQ	= @[sls_act_seq]" ).append("\n"); 
		query.append("GROUP BY (CUST_CNT_CD" ).append("\n"); 
		query.append("        , CUST_SEQ" ).append("\n"); 
		query.append("        , SREP_CD" ).append("\n"); 
		query.append("        , SLS_ACT_SEQ)" ).append("\n"); 

	}
}