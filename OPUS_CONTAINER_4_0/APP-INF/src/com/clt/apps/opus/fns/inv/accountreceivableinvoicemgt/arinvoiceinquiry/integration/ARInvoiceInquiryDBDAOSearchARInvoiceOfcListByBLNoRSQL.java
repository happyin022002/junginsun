/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchARInvoiceOfcListByBLNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.01.11 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchARInvoiceOfcListByBLNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchARInvoiceOfcListByBLNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchARInvoiceOfcListByBLNoRSQL").append("\n"); 
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
		query.append("SELECT AR_OFC_CD," ).append("\n"); 
		query.append("NVL(INV_DUP_FLG, 'N') INV_DUP_FLG" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT DISTINCT A.AR_OFC_CD," ).append("\n"); 
		query.append("      DECODE(B.AR_OFC_CD, A.AR_OFC_CD, 0, 1) OFCSEQ," ).append("\n"); 
		query.append("      C.INV_DUP_FLG" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      MDM_ORGANIZATION B," ).append("\n"); 
		query.append("      INV_AR_STUP_OFC C" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("    WHERE A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("    WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT AR_OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("            SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("          AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("      AND B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = C.AR_OFC_CD (+)" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("ORDER BY OFCSEQ" ).append("\n"); 

	}
}