/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchAttentionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.17
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.17 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchAttentionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAttention
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchAttentionRSQL(){
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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchAttentionRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	 B.CNTC_PNT_NM" ).append("\n"); 
		query.append("	,B.CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("	,B.CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("	,B.CNTC_PNT_EML" ).append("\n"); 
		query.append("	,'KOR' AS SVR_ID" ).append("\n"); 
		query.append("	,B.CUST_CNT_CD" ).append("\n"); 
		query.append("	,B.CUST_SEQ" ).append("\n"); 
		query.append("	,B.CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("    ,'' OFC_CD" ).append("\n"); 
		query.append("    ,(SELECT DECODE(A.CNTC_PNT_NM,B.CNTC_PNT_NM, 'Y','') FROM EAS_PAYR_INFO A" ).append("\n"); 
		query.append("      WHERE A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND   A.CUST_SEQ 	  = @[cust_seq] ) AS SHEET_FLG " ).append("\n"); 
		query.append("FROM EAS_PAYR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE B.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND   B.CUST_SEQ 	= @[cust_seq]" ).append("\n"); 

	}
}