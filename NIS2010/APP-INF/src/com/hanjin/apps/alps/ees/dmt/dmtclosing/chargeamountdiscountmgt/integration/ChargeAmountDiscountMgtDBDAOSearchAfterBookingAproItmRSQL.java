/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproItmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproItmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproItm
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproItmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproItmRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1 SEQ, '1' NO" ).append("\n"); 
		query.append("     , ATTR_CTNT2 AS RVW_ITM" ).append("\n"); 
		query.append("     , ATTR_CTNT3 AS FOML_NM" ).append("\n"); 
		query.append("     , ATTR_CTNT4 AS VALUE_1" ).append("\n"); 
		query.append("     , ATTR_CTNT5 AS VALUE_2" ).append("\n"); 
		query.append("     , '-1' AS VALUE_3" ).append("\n"); 
		query.append("FROM dmt_hrd_cdg_ctnt" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'AFT_BKG_APRO_ITME'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 != 4" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.ATTR_CTNT1 SEQ, '2' NO" ).append("\n"); 
		query.append("     , A.ATTR_CTNT2 AS RVW_ITM" ).append("\n"); 
		query.append("     , A.ATTR_CTNT3 AS FOML_NM" ).append("\n"); 
		query.append("     , CASE WHEN A.ATTR_CTNT1 = '5' THEN TRIM(TO_CHAR(B.AFT_BKG_ITM_CTNT1,'9,999,999,999,990'))" ).append("\n"); 
		query.append("			ELSE CASE WHEN A.ATTR_CTNT1 IN ( '1','2','3' ) THEN '$ '||TRIM(TO_CHAR(B.AFT_BKG_ITM_CTNT1,'9,999,999,990.00')) " ).append("\n"); 
		query.append("					  WHEN A.ATTR_CTNT1 IN ( '6','7' ) THEN TRIM(TO_CHAR(B.AFT_BKG_ITM_CTNT1,'990.00'))|| ' %'" ).append("\n"); 
		query.append("					  WHEN A.ATTR_CTNT1 = '4' THEN " ).append("\n"); 
		query.append("							( SELECT DECODE(NVL(UC_CGO_PSBL_FLG,' '),'Y','HIGH','N','LOW',' ')" ).append("\n"); 
		query.append("                               FROM DMT_AFT_BKG_ADJ_RQST WHERE AFT_EXPT_DAR_NO = @[dar_no] AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                      ELSE B.AFT_BKG_ITM_CTNT1 END" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AS VALUE_1" ).append("\n"); 
		query.append("     , CASE WHEN A.ATTR_CTNT1 = '5' THEN TRIM(TO_CHAR(B.AFT_BKG_ITM_CTNT2,'9,999,999,999,990'))" ).append("\n"); 
		query.append("			ELSE CASE WHEN A.ATTR_CTNT1 IN ( '1','2','3' ) THEN '$ '||TRIM(TO_CHAR(B.AFT_BKG_ITM_CTNT2,'9,999,999,990.00')) " ).append("\n"); 
		query.append("					  WHEN A.ATTR_CTNT1 IN ( '6','7' ) THEN TRIM(TO_CHAR(B.AFT_BKG_ITM_CTNT2,'990.00'))|| ' %'" ).append("\n"); 
		query.append("					  WHEN A.ATTR_CTNT1 = '4' THEN " ).append("\n"); 
		query.append("							( SELECT DECODE(NVL(UC_CGO_PSBL_FLG,' '),'Y','HIGH','N','LOW',' ')" ).append("\n"); 
		query.append("                               FROM DMT_AFT_BKG_ADJ_RQST WHERE AFT_EXPT_DAR_NO = @[dar_no] AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                      ELSE B.AFT_BKG_ITM_CTNT2 END" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AS VALUE_2" ).append("\n"); 
		query.append("     , CASE ATTR_CTNT1 WHEN '1' THEN " ).append("\n"); 
		query.append("                            CASE WHEN TO_NUMBER(B.AFT_BKG_ITM_CTNT1) > ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT2) * 0.3,2) THEN '0'" ).append("\n"); 
		query.append("                                 WHEN ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) = ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT2) * 0.3,0) THEN '1'" ).append("\n"); 
		query.append("                                 ELSE '2' END" ).append("\n"); 
		query.append("                       WHEN '2' THEN" ).append("\n"); 
		query.append("                            CASE WHEN ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) > ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT2),0) THEN '0'" ).append("\n"); 
		query.append("                                 WHEN ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) = ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT2),0) THEN '1'" ).append("\n"); 
		query.append("                                 ELSE '2' END" ).append("\n"); 
		query.append("                       WHEN '3' THEN" ).append("\n"); 
		query.append("                            CASE WHEN TO_NUMBER(B.AFT_BKG_ITM_CTNT1) <= TO_NUMBER(B.AFT_BKG_ITM_CTNT2) THEN '0'" ).append("\n"); 
		query.append("                                 ELSE '2' END" ).append("\n"); 
		query.append("                       WHEN '4' THEN ( SELECT DECODE(NVL(UC_CGO_PSBL_FLG,' '),'Y','0','N','2',' ')" ).append("\n"); 
		query.append("                               			 FROM DMT_AFT_BKG_ADJ_RQST WHERE AFT_EXPT_DAR_NO = @[dar_no] AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                       WHEN '5' THEN " ).append("\n"); 
		query.append("                            CASE WHEN NVL(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) = 0 AND NVL(TO_NUMBER(B.AFT_BKG_ITM_CTNT2),0) = 0 THEN '0'" ).append("\n"); 
		query.append("                                 WHEN NVL(TO_NUMBER(B.AFT_BKG_ITM_CTNT2),0) > 0 THEN '2'" ).append("\n"); 
		query.append("                                 WHEN NVL(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) > 0 THEN '1'" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                       WHEN '6' THEN" ).append("\n"); 
		query.append("                            CASE WHEN ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) > 90 THEN '0'" ).append("\n"); 
		query.append("                                 WHEN ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) = 90 THEN '1'" ).append("\n"); 
		query.append("                                 ELSE '2'" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                       WHEN '7' THEN " ).append("\n"); 
		query.append("                            CASE WHEN ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) < 50 THEN '0'" ).append("\n"); 
		query.append("                                 WHEN ROUND(TO_NUMBER(B.AFT_BKG_ITM_CTNT1),0) = 50 THEN '1'" ).append("\n"); 
		query.append("                                 ELSE '2'" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       AS VALUE_3 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DMT_HRD_CDG_CTNT A, DMT_AFT_BKG_APRO_ITM B" ).append("\n"); 
		query.append("WHERE A.HRD_CDG_ID = 'AFT_BKG_APRO_ITME'" ).append("\n"); 
		query.append("AND B.AFT_EXPT_DAR_NO(+) = @[dar_no]" ).append("\n"); 
		query.append("AND A.ATTR_CTNT1 = B.AFT_BKG_ITM_LVL(+)" ).append("\n"); 
		query.append("ORDER BY 1,2" ).append("\n"); 

	}
}