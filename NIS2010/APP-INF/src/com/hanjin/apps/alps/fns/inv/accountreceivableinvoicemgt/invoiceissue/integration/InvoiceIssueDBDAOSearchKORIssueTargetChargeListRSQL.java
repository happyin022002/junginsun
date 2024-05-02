/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchKORIssueTargetChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.05.27 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchKORIssueTargetChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L NO 입력하고 TAB 또는 FOCUS 이동 시 Invoice CHARGE 테이블에서 해당 B/L NO의 I/F NO로 CHARGE 정보를 SELECT 한다.
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchKORIssueTargetChargeListRSQL(){
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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchKORIssueTargetChargeListRSQL").append("\n"); 
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
		query.append("SELECT BL_SRC_NO," ).append("\n"); 
		query.append("  ROWNUM CHG_SEQ," ).append("\n"); 
		query.append("  CHG_CD," ).append("\n"); 
		query.append("  CURR_CD," ).append("\n"); 
		query.append("  INV_XCH_RT," ).append("\n"); 
		query.append("  CHG_AMT," ).append("\n"); 
		query.append("  CASE WHEN RAT_AS_CNTR_QTY < 0 THEN RAT_AS_CNTR_QTY*-1 ELSE RAT_AS_CNTR_QTY END RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("  TRF_RT_AMT," ).append("\n"); 
		query.append("  PER_TP_CD," ).append("\n"); 
		query.append("  AR_CURR_CD," ).append("\n"); 
		query.append("  AR_OFC_CD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT MAX(D.DP_PRCS_KNT)" ).append("\n"); 
		query.append("    FROM MDM_CURRENCY D" ).append("\n"); 
		query.append("    WHERE D.CURR_CD IN (" ).append("\n"); 
		query.append("        SELECT CURR_CD" ).append("\n"); 
		query.append("        FROM INV_AR_MN S1," ).append("\n"); 
		query.append("          INV_AR_CHG S2" ).append("\n"); 
		query.append("        WHERE S1.AR_IF_NO = S2.AR_IF_NO" ).append("\n"); 
		query.append("          AND S1.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("          AND S1.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("          AND NVL(S1.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("          AND S2.INV_CLR_FLG = 'N' )) DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.BL_SRC_NO," ).append("\n"); 
		query.append("      B.CHG_CD," ).append("\n"); 
		query.append("      B.CURR_CD," ).append("\n"); 
		query.append("      B.INV_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("      SUM(B.CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("      SUM(CASE WHEN B.CHG_AMT>0 THEN B.RAT_AS_CNTR_QTY ELSE B.RAT_AS_CNTR_QTY*-1 END) RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("      B.TRF_RT_AMT TRF_RT_AMT," ).append("\n"); 
		query.append("      B.PER_TP_CD PER_TP_CD," ).append("\n"); 
		query.append("      C.AR_CURR_CD," ).append("\n"); 
		query.append("	  A.AR_OFC_CD" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      INV_AR_CHG B," ).append("\n"); 
		query.append("      MDM_ORGANIZATION C" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = C.OFC_CD    " ).append("\n"); 
		query.append("	  AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE (LOC_CD LIKE 'KR%' OR LOC_CD LIKE 'HQ%')" ).append("\n"); 
		query.append("          AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("          AND OFC_CD IS NOT NULL )" ).append("\n"); 
		query.append("      AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND B.INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("    GROUP BY A.BL_SRC_NO, B.CHG_CD, B.CURR_CD, C.AR_CURR_CD, B.PER_TP_CD, B.INV_XCH_RT, B.TRF_RT_AMT, A.AR_OFC_CD" ).append("\n"); 
		query.append("    HAVING SUM(B.CHG_AMT) <> 0" ).append("\n"); 
		query.append("    ORDER BY A.BL_SRC_NO, B.CHG_CD, B.CURR_CD)" ).append("\n"); 

	}
}