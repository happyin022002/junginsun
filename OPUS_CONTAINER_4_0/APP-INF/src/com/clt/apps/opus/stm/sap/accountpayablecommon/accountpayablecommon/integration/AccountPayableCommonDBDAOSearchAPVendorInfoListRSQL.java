/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchAPVendorInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchAPVendorInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPVendorInfoList
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchAPVendorInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchAPVendorInfoListRSQL").append("\n"); 
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
		query.append("SELECT      S.VNDR_NO          AS VNDR_NO" ).append("\n"); 
		query.append("          , M.VNDR_LGL_ENG_NM  AS VNDR_NM" ).append("\n"); 
		query.append("          , S.LIAB_CD_CMB_SEQ  AS LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append("          , S.PAY_CD_CMB_SEQ   AS PAY_CD_CMB_SEQ" ).append("\n"); 
		query.append("          , L.SGM_CTNT1        AS L_COMPANY_CODE" ).append("\n"); 
		query.append("          , L.SGM_CTNT2        AS L_REGION_CODE" ).append("\n"); 
		query.append("          , L.SGM_CTNT3        AS L_CENTER_CODE" ).append("\n"); 
		query.append("          , L.SGM_CTNT4        AS L_ACCOUNT_CODE" ).append("\n"); 
		query.append("          , L.SGM_CTNT5        AS L_INTERCOMPANY_CODE" ).append("\n"); 
		query.append("          , L.SGM_CTNT6        AS L_VVD_CODE  " ).append("\n"); 
		query.append("          , P.SGM_CTNT1        AS P_COMPANY_CODE" ).append("\n"); 
		query.append("          , P.SGM_CTNT2        AS P_REGION_CODE" ).append("\n"); 
		query.append("          , P.SGM_CTNT3        AS P_CENTER_CODE" ).append("\n"); 
		query.append("          , P.SGM_CTNT4        AS P_ACCOUNT_CODE" ).append("\n"); 
		query.append("          , P.SGM_CTNT5        AS P_INTERCOMPANY_CODE" ).append("\n"); 
		query.append("          , P.SGM_CTNT6        AS P_VVD_CODE " ).append("\n"); 
		query.append("          ,'' USR_ID " ).append("\n"); 
		query.append("          , S.PAY_PRIO_CD" ).append("\n"); 
		query.append("FROM      SAP_VENDOR S" ).append("\n"); 
		query.append("          ,MDM_VENDOR M" ).append("\n"); 
		query.append("          ,SCO_LEGR_CD_CMB L" ).append("\n"); 
		query.append("          ,SCO_LEGR_CD_CMB P " ).append("\n"); 
		query.append("WHERE   S.VNDR_NO = M.VNDR_SEQ" ).append("\n"); 
		query.append("AND S.LIAB_CD_CMB_SEQ = L.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND S.PAY_CD_CMB_SEQ = P.CD_CMB_SEQ" ).append("\n"); 
		query.append("#if (${vndr_no} != '') " ).append("\n"); 
		query.append("AND S.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(S.VNDR_NO)" ).append("\n"); 

	}
}