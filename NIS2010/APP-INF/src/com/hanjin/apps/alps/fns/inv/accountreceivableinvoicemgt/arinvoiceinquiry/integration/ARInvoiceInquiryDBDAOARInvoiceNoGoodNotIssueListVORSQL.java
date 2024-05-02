/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceNoGoodNotIssueListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.24 
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

public class ARInvoiceInquiryDBDAOARInvoiceNoGoodNotIssueListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceNoGoodNotIssueListVORSQL(){
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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceNoGoodNotIssueListVORSQL").append("\n"); 
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
		query.append("#if (${date_option} == 'I')                        " ).append("\n"); 
		query.append("SELECT /*+ index(A XAK3INV_AR_MN)  */ A.AR_OFC_CD, --20100708" ).append("\n"); 
		query.append("#elseif (${date_option} == 'A')" ).append("\n"); 
		query.append("SELECT /*+ index(A XAK8INV_AR_MN)  */ A.AR_OFC_CD," ).append("\n"); 
		query.append("#elseif (${date_option} == 'S')" ).append("\n"); 
		query.append("SELECT /*+ index(A XAK9INV_AR_MN)  */ A.AR_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       A.SAIL_ARR_DT," ).append("\n"); 
		query.append("       A.SAIL_DT," ).append("\n"); 
		query.append("       A.BL_SRC_NO," ).append("\n"); 
		query.append("       A.AR_IF_NO," ).append("\n"); 
		query.append("       A.BKG_CORR_NO," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       A.ACT_CUST_CNT_CD||'-'||LPAD(TO_CHAR(A.ACT_CUST_SEQ), 6, '0') CUSTOMER," ).append("\n"); 
		query.append("	   (SELECT CUST_LGL_ENG_NM  FROM MDM_CUSTOMER WHERE A.ACT_CUST_CNT_CD = CUST_CNT_CD  AND A.ACT_CUST_SEQ = CUST_SEQ ) CUST_NM," ).append("\n"); 
		query.append("       DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI') REV_TP_CD," ).append("\n"); 
		query.append("       A.REV_SRC_CD," ).append("\n"); 
		query.append("       DECODE(A.IO_BND_CD, 'I', 'I/B', 'O', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("       A.POL_CD," ).append("\n"); 
		query.append("       A.POD_CD," ).append("\n"); 
		query.append("       SUM(DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0)) USD_CHG_TOT, " ).append("\n"); 
		query.append("       ROUND(SUM(DECODE(B.CURR_CD, 'USD', 0, B.CHG_AMT*B.INV_XCH_RT)),F.DP_PRCS_KNT) LCL_CHG_TOT, " ).append("\n"); 
		query.append("       A.USD_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("	   DECODE(A.XCH_RT_USD_TP_CD,'I','I','') XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("       A.INV_TTL_LOCL_AMT," ).append("\n"); 
		query.append("       A.BL_INV_IF_DT," ).append("\n"); 
		query.append("       F.DP_PRCS_KNT" ).append("\n"); 
		query.append("  FROM INV_AR_MN A, " ).append("\n"); 
		query.append("       INV_AR_CHG B," ).append("\n"); 
		query.append("       MDM_CURRENCY F" ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("   AND A.LOCL_CURR_CD = F.CURR_CD" ).append("\n"); 
		query.append("#if (${date_option} == 'I' && ${from_date} != '' && ${to_date} != '') " ).append("\n"); 
		query.append("   AND A.BL_INV_IF_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '') -- I/F DATE 20100708" ).append("\n"); 
		query.append("#elseif (${date_option} == 'A' && ${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("   AND A.SAIL_ARR_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '') -- S/A DATE" ).append("\n"); 
		query.append("#elseif (${date_option} == 'S' && ${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("   AND A.SAIL_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '') -- SAILING DATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                         WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                     WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                       WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                           AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND A.INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("   --AND A.BL_INV_IF_DT BETWEEN TO_CHAR(SYSDATE-365,'YYYYMMDD') AND TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("   AND A.BL_INV_IF_DT >= '20070101' --20100715" ).append("\n"); 
		query.append("#if (${select_option} == 'A')" ).append("\n"); 
		query.append("   AND A.BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("#elseif (${select_option} == 'B')" ).append("\n"); 
		query.append("   AND A.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND A.INV_SRC_NO IS NULL          --2010-07-08" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD IN (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                         FROM INV_AR_STUP_OFC" ).append("\n"); 
		query.append("                        WHERE OTS_SMRY_CD IN ('INV','CLR')" ).append("\n"); 
		query.append("                          AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("#elseif (${select_option} == 'C')" ).append("\n"); 
		query.append("   AND A.ACT_CUST_CNT_CD = (" ).append("\n"); 
		query.append("     SELECT REP_CUST_CNT_CD" ).append("\n"); 
		query.append("     FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("     WHERE OFC_CD = @[office])" ).append("\n"); 
		query.append("   AND A.ACT_CUST_SEQ = (" ).append("\n"); 
		query.append("     SELECT REP_CUST_SEQ" ).append("\n"); 
		query.append("     FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("     WHERE OFC_CD = @[office])" ).append("\n"); 
		query.append("   AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${select_option} == 'D')" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                 FROM INV_AR_CHG D " ).append("\n"); 
		query.append("                WHERE A.AR_IF_NO = D.AR_IF_NO " ).append("\n"); 
		query.append("                  AND INV_XCH_RT = 0 ) " ).append("\n"); 
		query.append("   AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != '')" ).append("\n"); 
		query.append("   AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#if ((${io_bnd_cd} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("   AND A.POD_CD = @[port]" ).append("\n"); 
		query.append("#elseif ((${io_bnd_cd} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("   AND A.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("   AND ((A.IO_BND_CD = 'I' AND A.POD_CD = @[port]) OR (A.IO_BND_CD = 'O' AND A.POL_CD = @[port]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.AR_OFC_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD, A.SAIL_ARR_DT, A.SAIL_DT, A.BL_SRC_NO, A.AR_IF_NO, A.BKG_CORR_NO, A.BKG_NO, A.ACT_CUST_CNT_CD||'-'||LPAD(TO_CHAR(A.ACT_CUST_SEQ), 6, '0'), DECODE(A.REV_TP_CD, 'B', 'B/L', 'C', 'C/A', 'M', 'MRI'), A.REV_SRC_CD, DECODE(A.IO_BND_CD, 'I', 'I/B', 'O', 'O/B'), A.POL_CD, A.POD_CD, A.USD_XCH_RT, A.INV_TTL_LOCL_AMT, A.BL_INV_IF_DT, F.DP_PRCS_KNT, DECODE(A.XCH_RT_USD_TP_CD,'I','I',''),A.ACT_CUST_CNT_CD,A.ACT_CUST_SEQ" ).append("\n"); 

	}
}