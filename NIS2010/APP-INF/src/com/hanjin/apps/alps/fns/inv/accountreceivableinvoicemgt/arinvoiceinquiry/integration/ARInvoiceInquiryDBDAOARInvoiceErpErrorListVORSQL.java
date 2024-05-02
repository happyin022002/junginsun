/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceErpErrorListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.05
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.04.05 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOARInvoiceErpErrorListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP IF Error Inquiry
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceErpErrorListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceErpErrorListVORSQL").append("\n"); 
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
		query.append("SELECT C.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("     , A.AR_OFC_CD" ).append("\n"); 
		query.append("     , B.INV_ERP_IF_STS_CD" ).append("\n"); 
		query.append("     , B.AR_IF_NO" ).append("\n"); 
		query.append("     , B.AR_IF_SER_NO" ).append("\n"); 
		query.append("     , A.BL_SRC_NO" ).append("\n"); 
		query.append("     , A.INV_NO" ).append("\n"); 
		query.append("     , DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI') AS REV_TP" ).append("\n"); 
		query.append("     , A.REV_TP_CD||A.REV_SRC_CD  AS REV_TP_SRC" ).append("\n"); 
		query.append("     , B.TJ_SRC_NM" ).append("\n"); 
		query.append("     , B.CURR_CD" ).append("\n"); 
		query.append("     , B.INV_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(A.BL_INV_IF_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS IF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(A.BL_INV_CFM_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS GOOD_DT" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(B.ERP_IF_GL_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS GL_DT" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , B.ERR_DESC" ).append("\n"); 
		query.append("FROM INV_AR_MN A, " ).append("\n"); 
		query.append("     INV_AR_AMT B, " ).append("\n"); 
		query.append("     MDM_ORGANIZATION C" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND   A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND   NVL(A.INV_DELT_DIV_CD,'N') <> 'Y' " ).append("\n"); 
		query.append("#if (${date_option} == 'I') " ).append("\n"); 
		query.append("    AND A.BL_INV_IF_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'C') " ).append("\n"); 
		query.append("    AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#elseif (${date_option} == 'G') " ).append("\n"); 
		query.append("    AND B.ERP_IF_GL_DT BETWEEN REPLACE(@[from_date],'-','') AND REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${if_flag} != 'A' && ${if_flag} != '') && (${if_no} == '' && ${bl_no} == '' && ${inv_no} == ''))" ).append("\n"); 
		query.append("    AND DECODE(NVL(B.INV_ERP_IF_STS_CD,'N'),'U','E',NVL(B.INV_ERP_IF_STS_CD,'N')) = @[if_flag]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_no} == '' && ${bl_no} == '' && ${inv_no} == '')" ).append("\n"); 
		query.append("    AND NVL(B.INV_ERP_IF_STS_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_ofc_cd} != 'ALL' && ${ar_hd_qtr_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND C.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != 'ALL' && ${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_no} != '')" ).append("\n"); 
		query.append("    AND A.AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("    AND A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("    AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != 'A' && ${rev_tp_cd} != '')" ).append("\n"); 
		query.append("    AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_src_cd} != 'A' && ${rev_src_cd} != '')" ).append("\n"); 
		query.append("    AND A.REV_SRC_CD IN (@[rev_src_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY C.AR_HD_QTR_OFC_CD, A.AR_OFC_CD, B.INV_ERP_IF_STS_CD, B.AR_IF_NO, B.AR_IF_SER_NO" ).append("\n"); 

	}
}