/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchPayerContactPointRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.16 KIM HYUN HWA
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

public class DODInvoiceMgtDBDAOSearchPayerContactPointRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPayerContactPoint
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchPayerContactPointRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchPayerContactPointRSQL").append("\n"); 
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
		query.append("SELECT  CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,CUST_CNT_CD" ).append("\n"); 
		query.append("       ,CUST_SEQ" ).append("\n"); 
		query.append("       ,CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("       ,CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("       ,CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("       ,CNTC_PNT_EML          " ).append("\n"); 
		query.append("FROM EAS_PAYR_CNTC_PNT A" ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD 	= substr(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ 		= substr(@[s_cust_cd],3,6)" ).append("\n"); 
		query.append("ORDER BY CUST_CNTC_PNT_SEQ" ).append("\n"); 

	}
}