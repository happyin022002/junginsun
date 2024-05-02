/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.03.27 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomerInfo
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustomerInfoRSQL(){
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
		query.append("FileName : CustomerInfoManageDBDAOSearchCustomerInfoRSQL").append("\n"); 
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
		query.append("SELECT     CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           CUST_STS_CD," ).append("\n"); 
		query.append("           SREP_CD," ).append("\n"); 
		query.append("           CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("           INDIV_CORP_DIV_CD," ).append("\n"); 
		query.append("           LOC_CD," ).append("\n"); 
		query.append("           CUST_RGST_NO," ).append("\n"); 
		query.append("           KEY_ACCT_FLG," ).append("\n"); 
		query.append("           CUST_GRP_ID," ).append("\n"); 
		query.append("           MLT_TRD_ACCT_FLG," ).append("\n"); 
		query.append("           A.CRE_USR_ID," ).append("\n"); 
		query.append("           OFC_ENG_NM," ).append("\n"); 
		query.append("           SREP_NM," ).append("\n"); 
		query.append("           B.PHN_NO," ).append("\n"); 
		query.append("           B.FAX_NO," ).append("\n"); 
		query.append("           B.CUST_EML," ).append("\n"); 
		query.append("           BZET_ADDR," ).append("\n"); 
		query.append("           USR_NM," ).append("\n"); 
		query.append("           CRE_OFC_CD ," ).append("\n"); 
		query.append("    	   CTS_NO," ).append("\n"); 
		query.append("    	   B.INTL_PHN_NO," ).append("\n"); 
		query.append("    	   B.INTL_FAX_NO," ).append("\n"); 
		query.append("    	   CUST_GRP_NM," ).append("\n"); 
		query.append("    	   MAX_ADR_SEQ AS CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT C.CUST_CNT_CD,C.CUST_SEQ," ).append("\n"); 
		query.append("           C.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("           C.OFC_CD," ).append("\n"); 
		query.append("           C.CUST_STS_CD," ).append("\n"); 
		query.append("           C.SREP_CD," ).append("\n"); 
		query.append("           C.CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("           C.INDIV_CORP_DIV_CD," ).append("\n"); 
		query.append("           C.LOC_CD," ).append("\n"); 
		query.append("           C.CUST_RGST_NO," ).append("\n"); 
		query.append("           C.KEY_ACCT_FLG," ).append("\n"); 
		query.append("           C.CUST_GRP_ID," ).append("\n"); 
		query.append("           C.MLT_TRD_ACCT_FLG," ).append("\n"); 
		query.append("           C.CRE_USR_ID," ).append("\n"); 
		query.append("           O.OFC_ENG_NM," ).append("\n"); 
		query.append("           S.SREP_NM," ).append("\n"); 
		query.append("           AD.BZET_ADDR," ).append("\n"); 
		query.append("           US.USR_NM," ).append("\n"); 
		query.append("           C.OFC_CD AS CRE_OFC_CD," ).append("\n"); 
		query.append("    	   C.CTS_NO," ).append("\n"); 
		query.append("    	   PE.CUST_GRP_NM," ).append("\n"); 
		query.append("    	   (SELECT MAX(CNP.CUST_CNTC_PNT_SEQ) FROM MDM_CUST_CNTC_PNT CNP WHERE CNP.CUST_CNT_CD = C.CUST_CNT_CD AND CNP.CUST_SEQ = C.CUST_SEQ) MAX_ADR_SEQ" ).append("\n"); 
		query.append("    FROM MDM_CUSTOMER C, MDM_ORGANIZATION O, MDM_SLS_REP S,MDM_CUST_ADDR AD, COM_USER US, MDM_CUST_PERF_GRP PE" ).append("\n"); 
		query.append("    WHERE C.OFC_CD    = O.OFC_CD" ).append("\n"); 
		query.append("    AND C.SREP_CD     = S.SREP_CD" ).append("\n"); 
		query.append("    AND C.CUST_CNT_CD = AD.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("    AND C.CUST_SEQ    = AD.CUST_SEQ(+)" ).append("\n"); 
		query.append("    AND C.CRE_USR_ID  = US.USR_ID(+)" ).append("\n"); 
		query.append("    AND C.CUST_GRP_ID = PE.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("    AND AD.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("    AND AD.ADDR_TP_CD(+)    = '1'" ).append("\n"); 
		query.append("    AND C.CUST_CNT_CD       = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("    AND C.CUST_SEQ          = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append(") A,MDM_CUST_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND A.CUST_SEQ    = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND A.MAX_ADR_SEQ = B.CUST_CNTC_PNT_SEQ(+)" ).append("\n"); 

	}
}