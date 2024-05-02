/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustActvityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.09
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.09 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustActvityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustActvityList
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustActvityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustActvityListRSQL").append("\n"); 
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
		query.append("SELECT SLS_ACT_SEQ" ).append("\n"); 
		query.append("     , SREP_CMT_DESC" ).append("\n"); 
		query.append("--     , KMAN_LST_NM || KMAN_N1ST_NM AS KEYMAN_NM" ).append("\n"); 
		query.append("     , SREP_CD" ).append("\n"); 
		query.append("     , MST.SLS_ACT_TP_DESC AS SLS_ACT_TP_DESC" ).append("\n"); 
		query.append("     , DTL.SLS_ACT_SUB_TP_DESC AS SLS_ACT_SUB_TP_DESC      " ).append("\n"); 
		query.append("     , ACT_PLN_DT" ).append("\n"); 
		query.append("     , SLS_ACT_ACT_DT" ).append("\n"); 
		query.append("     , NVL2(SLS_ACT_ACT_DT, 'Close','Processing') AS SLS_STS" ).append("\n"); 
		query.append("--	 , '' KEYMAN_NM" ).append("\n"); 
		query.append("	 , '' USER_ID" ).append("\n"); 
		query.append("FROM SAM_SLS_ACT " ).append("\n"); 
		query.append("--   , SAM_CUST_KMAN_INFO" ).append("\n"); 
		query.append("   , SAM_SLS_ACT_TP_MST MST" ).append("\n"); 
		query.append("   , SAM_SLS_ACT_TP_DTL DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("--AND SAM_SLS_ACT.CUST_CNT_CD = SAM_CUST_KMAN_INFO.CUST_CNT_CD" ).append("\n"); 
		query.append("--AND SAM_SLS_ACT.CUST_SEQ = SAM_CUST_KMAN_INFO.CUST_SEQ" ).append("\n"); 
		query.append("AND SAM_SLS_ACT.SLS_ACT_TP_CD = MST.SLS_ACT_TP_CD" ).append("\n"); 
		query.append("AND SAM_SLS_ACT.SLS_ACT_SUB_TP_CD = DTL.SLS_ACT_SUB_TP_CD" ).append("\n"); 
		query.append("AND SAM_SLS_ACT.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND SAM_SLS_ACT.CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("ORDER BY SLS_ACT_SEQ" ).append("\n"); 

	}
}