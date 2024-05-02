/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchEdiPHILSBkgCustomerRSQL.java
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

public class AccountReceivableEDISendDBDAOsearchEdiPHILSBkgCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiPHILSBkgCustomer
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchEdiPHILSBkgCustomerRSQL(){
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
		query.append("FileName : AccountReceivableEDISendDBDAOsearchEdiPHILSBkgCustomerRSQL").append("\n"); 
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
		query.append("SELECT DECODE(LENGTH(SHPR_CD), 8, SHPR1, '') SHPR1," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR2, '') SHPR2," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR3, '') SHPR3," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR4, '') SHPR4," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR5, '') SHPR5," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR_CITY_NM, '') SHPR_CITY_NM," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR_STAT_CD, '') SHPR_STAT_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR_ZIP_CD, '') SHPR_ZIP_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR_CNT_CD, '') SHPR_CNT_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(SHPR_CD), 8, SHPR_CD, '') SHPR_CD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE1, '') CNEE1," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE2, '') CNEE2," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE3, '') CNEE3," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE4, '') CNEE4," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE5, '') CNEE5," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE_CITY_NM, '') CNEE_CITY_NM," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE_STAT_CD, '') CNEE_STAT_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE_ZIP_CD, '') CNEE_ZIP_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE_CNT_CD, '') CNEE_CNT_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(CNEE_CD), 8, CNEE_CD, '') CNEE_CD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY1, '') NTFY1," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY2, '') NTFY2," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY3, '') NTFY3," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY4, '') NTFY4," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY5, '') NTFY5," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY_CITY_NM, '') NTFY_CITY_NM," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY_STAT_CD, '') NTFY_STAT_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY_ZIP_CD, '') NTFY_ZIP_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY_CNT_CD, '') NTFY_CNT_CD," ).append("\n"); 
		query.append("       DECODE(LENGTH(NTFY_CD), 8, NTFY_CD, '') NTFY_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(CUST_S.CUST_NM,1) SHPR1," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_S.CUST_ADDR,'*',' '),'~',' '),'^',' '),1) SHPR2," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_S.CUST_ADDR,'*',' '),'~',' '),'^',' '),2) SHPR3," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_S.CUST_ADDR,'*',' '),'~',' '),'^',' '),3) SHPR4, " ).append("\n"); 
		query.append("          		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_S.CUST_ADDR,'*',' '),'~',' '),'^',' '),4) SHPR5, " ).append("\n"); 
		query.append("                NVL(CUST_S.CUST_CTY_NM,( SELECT CTY_NM" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_S.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_S.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) SHPR_CITY_NM," ).append("\n"); 
		query.append("                NVL(CUST_S.CUST_STE_CD, ( SELECT STE_CD" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_S.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_S.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) SHPR_STAT_CD," ).append("\n"); 
		query.append("                NVL(CUST_S.CUST_ZIP_ID, ( SELECT ZIP_CD" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_S.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_S.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) SHPR_ZIP_CD," ).append("\n"); 
		query.append("                CUST_S.CUST_CNT_CD SHPR_CNT_CD, " ).append("\n"); 
		query.append("                CUST_S.CUST_CNT_CD||LPAD(CUST_S.CUST_SEQ,6,0) SHPR_CD,       " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(CUST_C.CUST_NM,1) CNEE1," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_C.CUST_ADDR,'*',' '),'~',' '),'^',' '),1) CNEE2," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_C.CUST_ADDR,'*',' '),'~',' '),'^',' '),2) CNEE3," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_C.CUST_ADDR,'*',' '),'~',' '),'^',' '),3) CNEE4," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_C.CUST_ADDR,'*',' '),'~',' '),'^',' '),4) CNEE5,        " ).append("\n"); 
		query.append("                NVL(CUST_C.CUST_CTY_NM, (SELECT CTY_NM" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_C.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_C.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) CNEE_CITY_NM," ).append("\n"); 
		query.append("                NVL(CUST_C.CUST_STE_CD, (SELECT STE_CD" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_C.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_C.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) CNEE_STAT_CD," ).append("\n"); 
		query.append("                NVL(CUST_C.CUST_ZIP_ID, (SELECT ZIP_CD" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_C.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_C.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) CNEE_ZIP_CD," ).append("\n"); 
		query.append("                CUST_C.CUST_CNT_CD CNEE_CNT_CD, " ).append("\n"); 
		query.append("                CUST_C.CUST_CNT_CD||LPAD(CUST_C.CUST_SEQ,6,0) CNEE_CD," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                SCE_TOKEN_NL_FNC(CUST_N.CUST_NM,1) NTFY1," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_N.CUST_ADDR,'*',' '),'~',' '),'^',' '),1) NTFY2," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_N.CUST_ADDR,'*',' '),'~',' '),'^',' '),2) NTFY3," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_N.CUST_ADDR,'*',' '),'~',' '),'^',' '),3) NTFY4," ).append("\n"); 
		query.append("        		SCE_TOKEN_NL_FNC(REPLACE(REPLACE(REPLACE(CUST_N.CUST_ADDR,'*',' '),'~',' '),'^',' '),4) NTFY5,        " ).append("\n"); 
		query.append("                NVL(CUST_N.CUST_CTY_NM, (SELECT CTY_NM" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_N.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_N.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) NTFY_CITY_NM," ).append("\n"); 
		query.append("                NVL(CUST_N.CUST_STE_CD, (SELECT STE_CD" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_N.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_N.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) NTFY_STAT_CD," ).append("\n"); 
		query.append("                NVL(CUST_N.CUST_ZIP_ID, (SELECT ZIP_CD" ).append("\n"); 
		query.append("                                         FROM   MDM_CUST_ADDR" ).append("\n"); 
		query.append("                                         WHERE  CUST_CNT_CD = CUST_N.CUST_CNT_CD" ).append("\n"); 
		query.append("                                         AND    CUST_SEQ = CUST_N.CUST_SEQ" ).append("\n"); 
		query.append("                                         AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND    PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                         AND    ROWNUM =1)) NTFY_ZIP_CD," ).append("\n"); 
		query.append("                CUST_N.CUST_CNT_CD NTFY_CNT_CD, " ).append("\n"); 
		query.append("                CUST_N.CUST_CNT_CD||LPAD(CUST_N.CUST_SEQ,6,0) NTFY_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("                BKG_CUSTOMER CUST_C," ).append("\n"); 
		query.append("                BKG_CUSTOMER CUST_S," ).append("\n"); 
		query.append("                BKG_CUSTOMER CUST_N" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     CUST_C.BKG_NO(+) = @[bkg_no] " ).append("\n"); 
		query.append("        AND     CUST_C.BKG_CUST_TP_CD(+) 	= 'C'" ).append("\n"); 
		query.append("        AND     CUST_S.BKG_NO(+) = @[bkg_no] " ).append("\n"); 
		query.append("        AND     CUST_S.BKG_CUST_TP_CD(+) 	= 'S'" ).append("\n"); 
		query.append("        AND     CUST_N.BKG_NO(+) = @[bkg_no] " ).append("\n"); 
		query.append("        AND     CUST_N.BKG_CUST_TP_CD(+) 	= 'N'" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}