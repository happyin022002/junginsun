/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiADIDASTotalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiADIDASTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiADIDASTotal
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiADIDASTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiADIDASTotalRSQL").append("\n"); 
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
		query.append("SELECT (SELECT NVL(SUM(INV_TTL_LOCL_AMT), '0.00')" ).append("\n"); 
		query.append("        FROM (SELECT ROUND(SUM(C.CHG_AMT*C.INV_XCH_RT),2) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("              FROM INV_AR_ISS_DTL B, INV_AR_CHG C" ).append("\n"); 
		query.append("              WHERE B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("                AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("                AND B.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("              GROUP BY C.CURR_CD, C.INV_XCH_RT)" ).append("\n"); 
		query.append("       ) INV_TOTAL_AMT," ).append("\n"); 
		query.append("  (SELECT NVL(SUM(INV_TTL_LOCL_AMT), '0.00')" ).append("\n"); 
		query.append("   FROM (SELECT  A.CURR_CD, ROUND(SUM(A.CHG_AMT*A.INV_XCH_RT),2) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("         FROM INV_AR_CHG A, INV_AR_ISS_DTL B" ).append("\n"); 
		query.append("         WHERE A.AR_IF_NO = B.AR_IF_NO(+)" ).append("\n"); 
		query.append("           AND A.CHG_SEQ = B.CHG_SEQ(+)" ).append("\n"); 
		query.append("           AND A.TVA_FLG = 'Y'" ).append("\n"); 
		query.append("           AND B.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("         GROUP BY A.CURR_CD, A.INV_XCH_RT)" ).append("\n"); 
		query.append("  ) INV_VAT_BASIS," ).append("\n"); 
		query.append("  (SELECT NVL(INV_VAT_CHG_RT, '0.00')" ).append("\n"); 
		query.append("   FROM (SELECT INV_VAT_CHG_RT" ).append("\n"); 
		query.append("         FROM INV_AR_STUP_OFC" ).append("\n"); 
		query.append("         WHERE AR_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("  ) INV_VAT_RATE," ).append("\n"); 
		query.append("  (SELECT NVL(SUM(INV_TTL_LOCL_AMT), '0.00')" ).append("\n"); 
		query.append("   FROM (SELECT A.CURR_CD, ROUND(SUM(A.CHG_AMT*A.INV_XCH_RT),2) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("         FROM INV_AR_CHG A, INV_AR_ISS_DTL B" ).append("\n"); 
		query.append("         WHERE A.AR_IF_NO = B.AR_IF_NO(+)" ).append("\n"); 
		query.append("           AND A.CHG_SEQ = B.CHG_SEQ(+)" ).append("\n"); 
		query.append("           AND A.CHG_CD IN ('TVA','IEV')" ).append("\n"); 
		query.append("           AND B.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("         GROUP BY A.CURR_CD, A.INV_XCH_RT)" ).append("\n"); 
		query.append("  ) INV_VAT_AMT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}