/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchInvoiceIssueTermByDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.04.04 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchInvoiceIssueTermByDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office code, issue date/Good date 조건으로 조회된 데이타의 issue date와 S/A  date, issue date와 Good date간의 Trem별 현황데이터를 조회해 온다.
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchInvoiceIssueTermByDateRSQL(){
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
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchInvoiceIssueTermByDateRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${office} == 'A' )" ).append("\n"); 
		query.append("  /*+ LEADING(B) USE_HASH(B A) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  OFFICE," ).append("\n"); 
		query.append("  MONTH," ).append("\n"); 
		query.append("  NVL(DECODE(GROUPING(MONTH), 1, '', DECODE(IO_BND_CD, 'O', 'O/B', 'I', 'I/B')), 'ALL') IO_BND_CD," ).append("\n"); 
		query.append("  DECODE(SUM(TOTAL_CNT), 0, 0, ROUND(SUM(TOTAL_SUM) / SUM(TOTAL_CNT), 1)) TOTAL_AVERAGE," ).append("\n"); 
		query.append("  SUM(TOTAL_CNT) TOTAL_CNT," ).append("\n"); 
		query.append("  DECODE(SUM(BELOW_CNT), 0, 0, ROUND(SUM(BELOW_SUM) / SUM(BELOW_CNT), 1)) BELOW," ).append("\n"); 
		query.append("  SUM(BELOW_CNT) BELOW_CNT," ).append("\n"); 
		query.append("  DECODE(SUM(CNT10_0), 0, 0, ROUND(SUM(SUM10_0) / SUM(CNT10_0), 1)) AVERAGE10_0," ).append("\n"); 
		query.append("  SUM(CNT10_0) CNT10_0," ).append("\n"); 
		query.append("  DECODE(SUM(CNT0_10), 0, 0, ROUND(SUM(SUM0_10) / SUM(CNT0_10), 1)) AVERAGE0_10," ).append("\n"); 
		query.append("  SUM(CNT0_10) CNT0_10," ).append("\n"); 
		query.append("  DECODE(SUM(CNT10_20), 0, 0, ROUND(SUM(SUM10_20) / SUM(CNT10_20), 1)) AVERAGE10_20," ).append("\n"); 
		query.append("  SUM(CNT10_20) CNT10_20," ).append("\n"); 
		query.append("  DECODE(SUM(CNT20_30), 0, 0, ROUND(SUM(SUM20_30) / SUM(CNT20_30), 1)) AVERAGE20_30," ).append("\n"); 
		query.append("  SUM(CNT20_30) CNT20_30," ).append("\n"); 
		query.append("  DECODE(SUM(CNT30_40), 0, 0, ROUND(SUM(SUM30_40) / SUM(CNT30_40), 1)) AVERAGE30_40," ).append("\n"); 
		query.append("  SUM(CNT30_40) CNT30_40," ).append("\n"); 
		query.append("  DECODE(SUM(CNT40_50), 0, 0, ROUND(SUM(SUM40_50) / SUM(CNT40_50), 1)) AVERAGE40_50," ).append("\n"); 
		query.append("  SUM(CNT40_50) CNT40_50," ).append("\n"); 
		query.append("  DECODE(SUM(OVER_CNT), 0, 0, ROUND(SUM(OVER_SUM) / SUM(OVER_CNT), 1)) OVER," ).append("\n"); 
		query.append("  SUM(OVER_CNT) OVER_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT TB.AR_OFC_CD OFFICE," ).append("\n"); 
		query.append("      SUBSTR(TB.ISS_DT, 1, 6) MONTH," ).append("\n"); 
		query.append("      TB.IO_BND_CD," ).append("\n"); 
		query.append("      SUM(TB.CAL_DT) TOTAL_SUM," ).append("\n"); 
		query.append("      COUNT(TB.INV_NO) TOTAL_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.CAL_DT < -10 THEN TB.CAL_DT ELSE 0 END) BELOW_SUM," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.CAL_DT < -10 THEN 1 ELSE 0 END) BELOW_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN -10 <= TB.CAL_DT AND TB.CAL_DT < 0 THEN TB.CAL_DT ELSE 0 END) SUM10_0," ).append("\n"); 
		query.append("      SUM(CASE WHEN -10 <= TB.CAL_DT AND TB.CAL_DT < 0 THEN 1 ELSE 0 END) CNT10_0," ).append("\n"); 
		query.append("      SUM(CASE WHEN 0 <= TB.CAL_DT AND TB.CAL_DT < 10 THEN TB.CAL_DT ELSE 0 END) SUM0_10," ).append("\n"); 
		query.append("      SUM(CASE WHEN 0 <= TB.CAL_DT AND TB.CAL_DT < 10 THEN 1 ELSE 0 END) CNT0_10," ).append("\n"); 
		query.append("      SUM(CASE WHEN 10 <= TB.CAL_DT AND TB.CAL_DT < 20 THEN TB.CAL_DT ELSE 0 END) SUM10_20," ).append("\n"); 
		query.append("      SUM(CASE WHEN 10 <= TB.CAL_DT AND TB.CAL_DT < 20 THEN 1 ELSE 0 END) CNT10_20," ).append("\n"); 
		query.append("      SUM(CASE WHEN 20 <= TB.CAL_DT AND TB.CAL_DT < 30 THEN TB.CAL_DT ELSE 0 END) SUM20_30," ).append("\n"); 
		query.append("      SUM(CASE WHEN 20 <= TB.CAL_DT AND TB.CAL_DT < 30 THEN 1 ELSE 0 END) CNT20_30," ).append("\n"); 
		query.append("      SUM(CASE WHEN 30 <= TB.CAL_DT AND TB.CAL_DT < 40 THEN TB.CAL_DT ELSE 0 END) SUM30_40," ).append("\n"); 
		query.append("      SUM(CASE WHEN 30 <= TB.CAL_DT AND TB.CAL_DT < 40 THEN 1 ELSE 0 END) CNT30_40," ).append("\n"); 
		query.append("      SUM(CASE WHEN 40 <= TB.CAL_DT AND TB.CAL_DT < 50 THEN TB.CAL_DT ELSE 0 END) SUM40_50," ).append("\n"); 
		query.append("      SUM(CASE WHEN 40 <= TB.CAL_DT AND TB.CAL_DT < 50 THEN 1 ELSE 0 END) CNT40_50," ).append("\n"); 
		query.append("      SUM(CASE WHEN 50 <= TB.CAL_DT THEN TB.CAL_DT ELSE 0 END) OVER_SUM," ).append("\n"); 
		query.append("      SUM(CASE WHEN 50 <= TB.CAL_DT THEN 1 ELSE 0 END) OVER_CNT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT A.AR_IF_NO," ).append("\n"); 
		query.append("          C.INV_NO," ).append("\n"); 
		query.append("          A.AR_OFC_CD," ).append("\n"); 
		query.append("          A.IO_BND_CD," ).append("\n"); 
		query.append("          C.ISS_DT," ).append("\n"); 
		query.append("#if (${date_option} == 'S')" ).append("\n"); 
		query.append("          TO_DATE(C.ISS_DT, 'YYYYMMDD') - TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD') CAL_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          TO_DATE(C.ISS_DT, 'YYYYMMDD') - TO_DATE(A.BL_INV_CFM_DT, 'YYYYMMDD') CAL_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("          INV_AR_ISS C" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = (" ).append("\n"); 
		query.append("            SELECT SUBSTR(MAX(DECODE(K.REV_TP_CD, 'M', '1', '2')||B.AR_IF_NO), 2,11)" ).append("\n"); 
		query.append("            FROM INV_AR_ISS_DTL B," ).append("\n"); 
		query.append("              INV_AR_MN K" ).append("\n"); 
		query.append("            WHERE B.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("              AND B.AR_IF_NO = K.AR_IF_NO)" ).append("\n"); 
		query.append("#if (${office} != 'A' )" ).append("\n"); 
		query.append("          AND A.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("          AND C.ISS_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')" ).append("\n"); 
		query.append("          AND C.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("            SELECT OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE AR_OFC_CD = @[office] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("            SELECT OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("                SELECT  AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("                WHERE   OFC_CD = (" ).append("\n"); 
		query.append("                    SELECT  AR_OFC_CD" ).append("\n"); 
		query.append("                    FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE   OFC_CD = @[login_ofc_cd] ) )" ).append("\n"); 
		query.append("                  AND     OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("          AND C.ISS_DT BETWEEN REPLACE(@[from_date], '-', '') AND REPLACE(@[to_date], '-', '')" ).append("\n"); 
		query.append("          AND C.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("            SELECT OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("                SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                WHERE OFC_CD = (" ).append("\n"); 
		query.append("                    SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE OFC_CD = @[login_ofc_cd] ) )" ).append("\n"); 
		query.append("              AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("          AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("          AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_tp_cd} != 'A')" ).append("\n"); 
		query.append("          AND A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ) TB" ).append("\n"); 
		query.append("#if (${office} != 'A' )" ).append("\n"); 
		query.append("    WHERE TB.CAL_DT IS NOT NULL" ).append("\n"); 
		query.append("    GROUP BY TB.AR_OFC_CD, SUBSTR(TB.ISS_DT, 1, 6), TB.IO_BND_CD )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    WHERE TB.CAL_DT IS NOT NULL" ).append("\n"); 
		query.append("    GROUP BY TB.AR_OFC_CD, SUBSTR(TB.ISS_DT, 1, 6), TB.IO_BND_CD ) A," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT OFC_CD," ).append("\n"); 
		query.append("      ROWNUM" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("        SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE OFC_CD = (" ).append("\n"); 
		query.append("            SELECT AR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[login_ofc_cd] ) )" ).append("\n"); 
		query.append("      AND OFC_CD = AR_OFC_CD ) B" ).append("\n"); 
		query.append("WHERE A.OFFICE = B.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY ROLLUP (OFFICE, MONTH, IO_BND_CD)" ).append("\n"); 
		query.append("ORDER BY OFFICE, MONTH, DECODE(IO_BND_CD, 'O/B', 1, 'I/B', 2)" ).append("\n"); 

	}
}