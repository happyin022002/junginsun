/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesRPTDBDAOsearchShipperListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOsearchShipperListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SalesRPTDBDAOsearchShipperListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOsearchShipperListRSQL").append("\n"); 
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
		query.append("SELECT	CUST_CNT_CD" ).append("\n"); 
		query.append("       ,CUST_SEQ" ).append("\n"); 
		query.append("       ,MODI_CUST_CNT_CD" ).append("\n"); 
		query.append("       ,MODI_CUST_SEQ" ).append("\n"); 
		query.append("       ,CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       ,CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("       ,OFC_CD " ).append("\n"); 
		query.append("FROM	MDM_CUSTOMER " ).append("\n"); 
		query.append("WHERE	DELT_FLG    <> 'Y' " ).append("\n"); 
		query.append("AND		CUST_CNT_CD = @[f_cust_cnt_cd] " ).append("\n"); 
		query.append("#if(${f_cust_seq} != '' )" ).append("\n"); 
		query.append("AND		CUST_SEQ    = TO_NUMBER( @[f_cust_seq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER	BY CUST_CNT_CD, CUST_SEQ" ).append("\n"); 

	}
}