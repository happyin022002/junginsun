/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchTaxCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.17 
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

public class AccountPayableCommonDBDAOSearchTaxCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTaxCodeList
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchTaxCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_tax_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchTaxCodeListRSQL").append("\n"); 
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
		query.append("SELECT  D.LU_CD AS TAX_NO" ).append("\n"); 
		query.append("      , D.LU_DESC AS AP_TAX_NM" ).append("\n"); 
		query.append("      , D.ATTR_CTNT1 AS TAX_RT" ).append("\n"); 
		query.append("      , D.ATTR_CTNT2" ).append("\n"); 
		query.append("      , D.ATTR_CTNT3" ).append("\n"); 
		query.append("      , D.ATTR_CTNT4" ).append("\n"); 
		query.append("      , D.ATTR_CTNT5      " ).append("\n"); 
		query.append("FROM  SCO_LU_HDR H, SCO_LU_DTL D" ).append("\n"); 
		query.append("WHERE H.LU_TP_CD = D.LU_TP_CD " ).append("\n"); 
		query.append("AND   H.LU_TP_CD = 'AP TAX CODE'" ).append("\n"); 
		query.append("AND   H.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("AND   D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${tax_no} != '') " ).append("\n"); 
		query.append("AND D.LU_CD = @[tax_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ap_tax_nm} != '') " ).append("\n"); 
		query.append("AND D.LU_DESC LIKE @[ap_tax_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY D.DP_SEQ" ).append("\n"); 

	}
}