/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchPayerContactPointMdmRSQL.java
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

public class DODInvoiceMgtDBDAOSearchPayerContactPointMdmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPayerContactPointMdm
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchPayerContactPointMdmRSQL(){
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
		query.append("FileName : DODInvoiceMgtDBDAOSearchPayerContactPointMdmRSQL").append("\n"); 
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
		query.append("#if (${s_cust_gubun} == '1') " ).append("\n"); 
		query.append("SELECT A.CNTC_PSON_NM AS CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,B.PHN_NO AS CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("       ,B.FAX_NO AS CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("       ,B.VNDR_EML AS CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[s_cust_cd]" ).append("\n"); 
		query.append("AND B.VNDR_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("SELECT C.CNTC_PSON_NM AS CNTC_PNT_NM" ).append("\n"); 
		query.append("	,DECODE(C.IB_PHN_NO, NULL, B.PHN_NO, C.IB_PHN_NO) AS CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("	,DECODE(C.IB_FAX_NO, NULL, B.FAX_NO, C.IB_FAX_NO) AS CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("	,DECODE(C.IB_EML, NULL, B.CUST_EML, C.IB_EML) AS CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CUST_CNTC_PNT B, MDM_CR_CUST C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD 	= B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD		= C.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("AND A.CUST_SEQ			= C.CUST_SEQ(+) " ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 		= substr(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("AND B.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}