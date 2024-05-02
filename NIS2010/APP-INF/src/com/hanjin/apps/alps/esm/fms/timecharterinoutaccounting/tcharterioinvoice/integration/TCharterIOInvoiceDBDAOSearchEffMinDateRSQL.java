/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchEffMinDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOSearchEffMinDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 마감 테이블 MIN 오픈 날짜 자동 처리를 위해서 조회를 한다.
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchEffMinDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchEffMinDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(DECODE(A.CNT, 1, MAX_EFF, MIN_EFF),'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("       SUBSTR(TO_CHAR(SYSDATE, 'YYYYMMDD'),3) SYS_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SELECT MIN(LAST_DAY(TO_DATE(EFF_YRMON, 'YYYYMM'))) MIN_EFF," ).append("\n"); 
		query.append("         MAX(TRUNC(TO_DATE(EFF_YRMON, 'YYYYMM'), 'MONTH')) MAX_EFF," ).append("\n"); 
		query.append("         COUNT(P.EFF_YRMON) CNT" ).append("\n"); 
		query.append("  FROM   AP_PERIOD P" ).append("\n"); 
		query.append("  WHERE  P.SYS_DIV_CD   = '17'" ).append("\n"); 
		query.append("    AND  P.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("    AND  P.CLZ_STS_CD   = 'O'  " ).append("\n"); 
		query.append("    AND  OFC_CD =  (SELECT S.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                    FROM   MDM_ORGANIZATION S" ).append("\n"); 
		query.append("                    WHERE  S.OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append(") A " ).append("\n"); 

	}
}