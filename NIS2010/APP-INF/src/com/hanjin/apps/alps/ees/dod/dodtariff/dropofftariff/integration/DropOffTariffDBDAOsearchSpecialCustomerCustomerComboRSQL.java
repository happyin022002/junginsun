/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffTariffDBDAOsearchSpecialCustomerCustomerComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffTariffDBDAOsearchSpecialCustomerCustomerComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Creation Special Customer TAB에서 RFA NO, SC NO에 종속된 Customer Combo Box 데이터 조회
	  * </pre>
	  */
	public DropOffTariffDBDAOsearchSpecialCustomerCustomerComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAOsearchSpecialCustomerCustomerComboRSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD || LPAD(A.CUST_SEQ, 6, '0') AS CUST_ID" ).append("\n"); 
		query.append("     , (SELECT SUBSTR(M.CUST_LGL_ENG_NM, 0, 20) CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = A.CUST_CNT_CD AND M.CUST_SEQ=A.CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("#if(${rfa_no} != '')" ).append("\n"); 
		query.append("      ,(SELECT /*+ DRIVING_SITE (MN) USE_NL(MN HDR CUST) */" ).append("\n"); 
		query.append("            	        CUST.CUST_LGL_ENG_NM CTRT_PTY_NM" ).append("\n"); 
		query.append("                FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("              	   ,PRI_RP_MN MN" ).append("\n"); 
		query.append("              	   ,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("               WHERE MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND MN.CTRT_CUST_SEQ    = CUST.CUST_SEQ" ).append("\n"); 
		query.append("               AND CUST.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("               AND CNTR_DIV_FLG 		= 'Y' " ).append("\n"); 
		query.append("               AND MN.RFA_CTRT_TP_CD IN ('C','S')" ).append("\n"); 
		query.append("               AND HDR.PROP_NO 	 	= MN.PROP_NO" ).append("\n"); 
		query.append("               AND MN.AMDT_SEQ = ( SELECT /*+ INDEX_DESC(A XPKPRI_RP_MN)*/ AMDT_SEQ FROM PRI_RP_MN A WHERE MN.PROP_NO = PROP_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("               AND HDR.RFA_NO = B.RFA_NO) CUST_NM2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_no} != '')" ).append("\n"); 
		query.append("      ,(SELECT /*+ DRIVING_SITE (MN) USE_NL(MN HDR CUST) */" ).append("\n"); 
		query.append("                   CUST.CUST_LGL_ENG_NM CTRT_PTY_NM" ).append("\n"); 
		query.append("              FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("                ,PRI_SP_MN MN" ).append("\n"); 
		query.append("                ,PRI_SP_HDR HDR" ).append("\n"); 
		query.append("              WHERE MN.REAL_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("              AND MN.REAL_CUST_SEQ    = CUST.CUST_SEQ" ).append("\n"); 
		query.append("              AND CUST.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("              AND CNTR_DIV_FLG 		= 'Y' " ).append("\n"); 
		query.append("              AND HDR.PROP_NO 	 	= MN.PROP_NO" ).append("\n"); 
		query.append("              AND MN.AMDT_SEQ = ( SELECT /*+ INDEX_DESC(A XPKPRI_RP_MN)*/ AMDT_SEQ FROM PRI_SP_MN A WHERE MN.PROP_NO = PROP_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("              AND HDR.SC_NO = B.SC_NO) CUST_NM2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rfa_no} != '')" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_ACT_CUST A, PRI_RP_HDR B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND B.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = (SELECT MAX(C.AMDT_SEQ)" ).append("\n"); 
		query.append("                      FROM  PRI_RP_PROG C" ).append("\n"); 
		query.append("                      WHERE A.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                        AND A.PRC_PROG_STS_CD = 'A')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_no} != '')" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_RT_ACT_CUST A, PRI_SP_HDR B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND B.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = (SELECT MAX(C.AMDT_SEQ)" ).append("\n"); 
		query.append("                      FROM  PRI_SP_PROG C" ).append("\n"); 
		query.append("                      WHERE A.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                        AND A.PRC_PROG_STS_CD = 'A')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(" ORDER BY A.CMDT_HDR_SEQ, A.ACT_CUST_SEQ" ).append("\n"); 

	}
}