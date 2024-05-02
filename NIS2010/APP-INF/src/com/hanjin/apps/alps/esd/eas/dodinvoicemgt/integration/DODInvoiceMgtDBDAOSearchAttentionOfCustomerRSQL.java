/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchAttentionOfCustomerRSQL.java
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

public class DODInvoiceMgtDBDAOSearchAttentionOfCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAttentionOfCustomer
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchAttentionOfCustomerRSQL(){
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
		query.append("FileName : DODInvoiceMgtDBDAOSearchAttentionOfCustomerRSQL").append("\n"); 
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
		query.append("#if(${cust_cnt_cd} == '00')" ).append("\n"); 
		query.append("SELECT  VNDR.VNDR_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("    ,   VNDR.VNDR_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append("    ,   '1' AS CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("    ,   VNDR.CNTC_PSON_NM AS CNTC_PNT_NM" ).append("\n"); 
		query.append("    ,   VNDR_CNTC_PNT.PHN_NO AS CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("    ,   VNDR_CNTC_PNT.FAX_NO AS CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("    ,   VNDR_CNTC_PNT.VNDR_EML AS CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM    MDM_VENDOR VNDR" ).append("\n"); 
		query.append("    ,   MDM_VNDR_CNTC_PNT VNDR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE   VNDR.VNDR_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    AND VNDR.VNDR_SEQ = VNDR_CNTC_PNT.VNDR_SEQ(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT  CUST_CNTC_PNT.CUST_SEQ" ).append("\n"); 
		query.append("    ,   CUST_CNTC_PNT.CUST_CNT_CD" ).append("\n"); 
		query.append("    ,   '1' AS CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("    ,   CR_CUST.CNTC_PSON_NM AS CNTC_PNT_NM" ).append("\n"); 
		query.append("    ,   DECODE(CR_CUST.IB_PHN_NO, NULL, CUST_CNTC_PNT.PHN_NO, CR_CUST.IB_PHN_NO) AS CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("    ,   DECODE(CR_CUST.IB_FAX_NO, NULL, CUST_CNTC_PNT.FAX_NO, CR_CUST.IB_FAX_NO) AS CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("    ,   DECODE(CR_CUST.IB_EML, NULL, CUST_CNTC_PNT.CUST_EML, CR_CUST.IB_EML) AS CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM    MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("    ,   MDM_CUST_CNTC_PNT CUST_CNTC_PNT" ).append("\n"); 
		query.append("	,   MDM_CR_CUST CR_CUST" ).append("\n"); 
		query.append("WHERE   CUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("    AND CUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    AND CUST.CUST_CNT_CD = CUST_CNTC_PNT.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND CUST.CUST_SEQ = CUST_CNTC_PNT.CUST_SEQ(+)" ).append("\n"); 
		query.append("	AND CUST.CUST_CNT_CD = CR_CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	AND CUST.CUST_SEQ = CR_CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}