/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceMaxIfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOARInvoiceMaxIfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceMaxIfNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceMaxIfNoRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(DECODE(REV_TP_CD,'M','A','B')||AR_IF_NO),2,11) AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("  AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("  AND BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("  AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rev_type} == 'B') " ).append("\n"); 
		query.append("  AND REV_TP_CD = 'B'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'C') " ).append("\n"); 
		query.append("  AND REV_TP_CD = 'C'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'D') " ).append("\n"); 
		query.append("  AND REV_TP_CD = 'M' AND REV_SRC_CD IN ('DM','DT')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'M') " ).append("\n"); 
		query.append("  AND REV_TP_CD = 'M' AND REV_SRC_CD NOT IN ('DM','DT')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BC') " ).append("\n"); 
		query.append("  AND REV_TP_CD IN ('B','C')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BD') " ).append("\n"); 
		query.append("  AND (REV_TP_CD = 'B' OR (REV_TP_CD = 'M' AND REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BM') " ).append("\n"); 
		query.append("  AND (REV_TP_CD = 'B' OR (REV_TP_CD = 'M' AND REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CD') " ).append("\n"); 
		query.append("  AND (REV_TP_CD = 'C' OR (REV_TP_CD = 'M' AND REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CM') " ).append("\n"); 
		query.append("  AND (REV_TP_CD = 'C' OR (REV_TP_CD = 'M' AND REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'DM') " ).append("\n"); 
		query.append("  AND REV_TP_CD = 'M'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BCD') " ).append("\n"); 
		query.append("  AND (REV_TP_CD IN ('B','C') OR (REV_TP_CD = 'M' AND REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BCM') " ).append("\n"); 
		query.append("  AND (REV_TP_CD IN ('B','C') OR (REV_TP_CD = 'M' AND REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BDM') " ).append("\n"); 
		query.append("  AND REV_TP_CD IN ('B','M')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CDM') " ).append("\n"); 
		query.append("  AND REV_TP_CD IN ('C','M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}