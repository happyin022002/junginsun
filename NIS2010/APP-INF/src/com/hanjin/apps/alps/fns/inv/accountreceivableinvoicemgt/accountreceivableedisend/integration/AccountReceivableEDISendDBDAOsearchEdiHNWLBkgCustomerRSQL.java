/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchEdiHNWLBkgCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchEdiHNWLBkgCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiHNWLBkgCustomer
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchEdiHNWLBkgCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchEdiHNWLBkgCustomerRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(CUST_S.CUST_NM,1) SHPR1," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_S.CUST_ADDR,'*',' '),'~',' '),'^',' '),1) SHPR2," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_S.CUST_ADDR,'*',' '),'~',' '),'^',' '),2) SHPR3," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_S.CUST_ADDR,'*',' '),'~',' '),'^',' '),3) SHPR4, " ).append("\n"); 
		query.append("  		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_S.CUST_ADDR,'*',' '),'~',' '),'^',' '),4) SHPR5, " ).append("\n"); 
		query.append("        CUST_S.CUST_CTY_NM SHPR_CITY_NM," ).append("\n"); 
		query.append("        CUST_S.CUST_STE_CD SHPR_STAT_CD," ).append("\n"); 
		query.append("        CUST_S.CUST_ZIP_ID SHPR_ZIP_CD," ).append("\n"); 
		query.append("        CUST_S.CUST_CNT_CD SHPR_CNT_CD, " ).append("\n"); 
		query.append("        CUST_S.CUST_CNT_CD||LPAD(CUST_S.CUST_SEQ,6,0) SHPR_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(CUST_C.CUST_NM,1) CNEE1," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_C.CUST_ADDR,'*',' '),'~',' '),'^',' '),1) CNEE2," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_C.CUST_ADDR,'*',' '),'~',' '),'^',' '),2) CNEE3," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_C.CUST_ADDR,'*',' '),'~',' '),'^',' '),3) CNEE4," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_C.CUST_ADDR,'*',' '),'~',' '),'^',' '),4) CNEE5,        " ).append("\n"); 
		query.append("        CUST_C.CUST_CTY_NM CNEE_CITY_NM," ).append("\n"); 
		query.append("        CUST_C.CUST_STE_CD CNEE_STAT_CD," ).append("\n"); 
		query.append("        CUST_C.CUST_ZIP_ID CNEE_ZIP_CD," ).append("\n"); 
		query.append("        CUST_C.CUST_CNT_CD CNEE_CNT_CD, " ).append("\n"); 
		query.append("        CUST_C.CUST_CNT_CD||LPAD(CUST_C.CUST_SEQ,6,0) CNEE_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SCE_TOKEN_NL_FNC(CUST_N.CUST_NM,1) NTFY1," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_N.CUST_ADDR,'*',' '),'~',' '),'^',' '),1) NTFY2," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_N.CUST_ADDR,'*',' '),'~',' '),'^',' '),2) NTFY3," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_N.CUST_ADDR,'*',' '),'~',' '),'^',' '),3) NTFY4," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_N.CUST_ADDR,'*',' '),'~',' '),'^',' '),4) NTFY5,        " ).append("\n"); 
		query.append("        CUST_N.CUST_CTY_NM NTFY_CITY_NM," ).append("\n"); 
		query.append("        CUST_N.CUST_STE_CD NTFY_STAT_CD," ).append("\n"); 
		query.append("        CUST_N.CUST_ZIP_ID NTFY_ZIP_CD," ).append("\n"); 
		query.append("        CUST_N.CUST_CNT_CD NTFY_CNT_CD, " ).append("\n"); 
		query.append("        CUST_N.CUST_CNT_CD||LPAD(CUST_N.CUST_SEQ,6,0) NTFY_CD," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SCE_TOKEN_NL_FNC(CUST_F.CUST_NM,1) FFWD1," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_F.CUST_ADDR,'*',' '),'~',' '),'^',' '),1) FFWD2," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_F.CUST_ADDR,'*',' '),'~',' '),'^',' '),2) FFWD3," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_F.CUST_ADDR,'*',' '),'~',' '),'^',' '),3) FFWD4," ).append("\n"); 
		query.append("		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_F.CUST_ADDR,'*',' '),'~',' '),'^',' '),4) FFWD5,        " ).append("\n"); 
		query.append("        CUST_F.CUST_CTY_NM FFWD_CITY_NM," ).append("\n"); 
		query.append("        CUST_F.CUST_STE_CD FFWD_STAT_CD," ).append("\n"); 
		query.append("        CUST_F.CUST_ZIP_ID FFWD_ZIP_CD," ).append("\n"); 
		query.append("        CUST_F.CUST_CNT_CD FFWD_CNT_CD, " ).append("\n"); 
		query.append("        CUST_F.CUST_CNT_CD||LPAD(CUST_F.CUST_SEQ,6,0) FFWD_CD  " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_C," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_S," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_N," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_F" ).append("\n"); 
		query.append("WHERE   1=1 " ).append("\n"); 
		query.append("AND     CUST_C.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("AND     CUST_C.BKG_CUST_TP_CD(+) 	= 'C'" ).append("\n"); 
		query.append("AND     CUST_S.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("AND     CUST_S.BKG_CUST_TP_CD(+) 	= 'S'" ).append("\n"); 
		query.append("AND     CUST_N.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("AND     CUST_N.BKG_CUST_TP_CD(+) 	= 'N'" ).append("\n"); 
		query.append("AND     CUST_F.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("AND     CUST_F.BKG_CUST_TP_CD(+) 	= 'F'" ).append("\n"); 

	}
}