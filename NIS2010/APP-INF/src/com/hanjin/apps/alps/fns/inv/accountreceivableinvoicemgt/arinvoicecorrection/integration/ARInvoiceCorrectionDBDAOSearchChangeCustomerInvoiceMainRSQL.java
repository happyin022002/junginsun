/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.02 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceMainRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT DTL.INV_NO," ).append("\n"); 
		query.append("       MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.AR_OFC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("       MN.BKG_NO," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(ISS.ISS_DT,'YYYYMMDD'),'YYYY-MM-DD') ISS_DT," ).append("\n"); 
		query.append("       MN.INV_REF_NO," ).append("\n"); 
		query.append("       MN.VSL_CD||MN.SKD_VOY_NO||MN.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       MN.POR_CD," ).append("\n"); 
		query.append("       MN.POL_CD," ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.DEL_CD," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(MN.SAIL_ARR_DT,'YYYYMMDD'),'YYYY-MM-DD') SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.IO_BND_CD,       " ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(MN.ACT_CUST_SEQ,6,0) ACT_CUST_SEQ," ).append("\n"); 
		query.append("       NVL(CUST.CUST_LOCL_LANG_NM, CUST.CUST_LGL_ENG_NM) CUST_NM," ).append("\n"); 
		query.append("	   MN.INV_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(MN.INV_CUST_SEQ,6,0) INV_CUST_SEQ," ).append("\n"); 
		query.append("       NVL(CUST2.CUST_LOCL_LANG_NM, CUST2.CUST_LGL_ENG_NM) INV_CUST_NM," ).append("\n"); 
		query.append("	   MN.GL_EFF_DT," ).append("\n"); 
		query.append("	   MN.REV_TP_CD," ).append("\n"); 
		query.append("	   MN.REV_SRC_CD" ).append("\n"); 
		query.append("  FROM INV_AR_ISS     ISS," ).append("\n"); 
		query.append("       INV_AR_ISS_DTL DTL," ).append("\n"); 
		query.append("       INV_AR_CHG     CHG," ).append("\n"); 
		query.append("       INV_AR_MN      MN," ).append("\n"); 
		query.append("       MDM_CUSTOMER   CUST," ).append("\n"); 
		query.append("	   MDM_CUSTOMER   CUST2" ).append("\n"); 
		query.append(" WHERE ISS.INV_NO = DTL.INV_NO" ).append("\n"); 
		query.append("   AND ISS.INV_SEQ = 1" ).append("\n"); 
		query.append("   AND DTL.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("   AND DTL.CHG_SEQ      = CHG.CHG_SEQ" ).append("\n"); 
		query.append("   AND CHG.AR_IF_NO     = MN.AR_IF_NO" ).append("\n"); 
		query.append("   AND MN.ACT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND MN.ACT_CUST_SEQ    = CUST.CUST_SEQ" ).append("\n"); 
		query.append("   AND MN.INV_CUST_CNT_CD = CUST2.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND MN.INV_CUST_SEQ    = CUST2.CUST_SEQ" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD       = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   --AND MN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append("   AND DTL.INV_NO         = @[inv_no] " ).append("\n"); 
		query.append("   AND DTL.AR_IF_NO       = NVL((SELECT MAX(C.AR_IF_NO)" ).append("\n"); 
		query.append("                               FROM INV_AR_ISS_DTL A," ).append("\n"); 
		query.append("                                    INV_AR_CHG     B," ).append("\n"); 
		query.append("                                    INV_AR_MN      C" ).append("\n"); 
		query.append("                              WHERE A.INV_NO = DTL.INV_NO" ).append("\n"); 
		query.append("                                AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                                AND A.CHG_SEQ      = B.CHG_SEQ" ).append("\n"); 
		query.append("                                AND B.AR_IF_NO     = C.AR_IF_NO " ).append("\n"); 
		query.append("                                AND C.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                                AND NVL(C.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                                --AND NVL(C.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append("                              GROUP BY A.INV_NO)," ).append("\n"); 
		query.append("                              (SELECT MIN(C.AR_IF_NO)" ).append("\n"); 
		query.append("                               FROM INV_AR_ISS_DTL A," ).append("\n"); 
		query.append("                                    INV_AR_CHG     B," ).append("\n"); 
		query.append("                                    INV_AR_MN      C" ).append("\n"); 
		query.append("                              WHERE A.INV_NO = DTL.INV_NO" ).append("\n"); 
		query.append("                                AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                                AND A.CHG_SEQ      = B.CHG_SEQ" ).append("\n"); 
		query.append("                                AND B.AR_IF_NO     = C.AR_IF_NO" ).append("\n"); 
		query.append("                                AND NVL(C.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                              GROUP BY A.INV_NO))" ).append("\n"); 

	}
}