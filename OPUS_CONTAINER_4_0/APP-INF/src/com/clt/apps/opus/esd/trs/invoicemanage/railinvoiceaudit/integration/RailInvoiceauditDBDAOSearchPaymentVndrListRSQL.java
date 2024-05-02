/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchPaymentVndrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchPaymentVndrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Invoice Payment Vendor 정보 조회
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchPaymentVndrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchPaymentVndrListRSQL").append("\n"); 
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
		query.append("##" ).append("\n"); 
		query.append("#if (${vndr_tp} != 'P')" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ" ).append("\n"); 
		query.append("      ,V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM AP_INV_NO_CHK_V" ).append("\n"); 
		query.append("         WHERE INV_NO = @[invNo]" ).append("\n"); 
		query.append("           AND VNDR_SEQ = V.VNDR_SEQ) FLAG" ).append("\n"); 
		query.append("  FROM MDM_VENDOR V" ).append("\n"); 
		query.append(" WHERE V.VNDR_SEQ = @[railRoadCode]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ" ).append("\n"); 
		query.append("      ,V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM AP_INV_NO_CHK_V" ).append("\n"); 
		query.append("         WHERE INV_NO = @[invNo]" ).append("\n"); 
		query.append("           AND VNDR_SEQ = V.PRNT_VNDR_SEQ) FLAG" ).append("\n"); 
		query.append("  FROM MDM_VENDOR V" ).append("\n"); 
		query.append(" WHERE V.VNDR_SEQ = (SELECT PRNT_VNDR_SEQ FROM MDM_VENDOR WHERE VNDR_SEQ = @[railRoadCode])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}