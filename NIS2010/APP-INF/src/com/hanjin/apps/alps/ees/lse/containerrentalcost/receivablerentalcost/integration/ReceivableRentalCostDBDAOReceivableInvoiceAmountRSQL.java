/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableInvoiceAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.28 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableInvoiceAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Rental Invoice Amount 정보를 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableInvoiceAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_isu_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableInvoiceAmountRSQL").append("\n"); 
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
		query.append("SELECT  A.FM_CURR_CD, A.FM_CURR_RT, A.TO_CURR_CD, A.TO_CURR_RT, A.FM_CHG_AMT," ).append("\n"); 
		query.append("        NVL(ROUND(A.FM_CHG_AMT/A.FM_CURR_RT*A.TO_CURR_RT, 2), 0) AS TO_CHG_AMT," ).append("\n"); 
		query.append("		NVL(ROUND(A.FM_CHG_AMT/A.FM_CURR_RT*A.TO_CURR_RT/10, 2), 0) AS TO_TAX_AMT," ).append("\n"); 
		query.append("        NVL(ROUND(A.FM_CHG_AMT/A.FM_CURR_RT*A.TO_CURR_RT +" ).append("\n"); 
		query.append("                  A.FM_CHG_AMT/A.FM_CURR_RT*A.TO_CURR_RT/10, 2), 0) AS TO_TTL_AMT," ).append("\n"); 
		query.append("		CASE WHEN B.CLZ_STS_CD = 'O' THEN A.INV_ISU_DT" ).append("\n"); 
		query.append("             WHEN B.CLZ_STS_CD = 'C' THEN B.MIN_GL_DT END INV_ISU_DT" ).append("\n"); 
		query.append("FROM   (SELECT  'INFO' AS OUT_COL, " ).append("\n"); 
		query.append("				P.FM_CURR_CD, P.TO_CURR_CD, P.FM_CHG_AMT, P.INV_ISU_DT,  " ).append("\n"); 
		query.append("                MAX(DECODE(A.CURR_CD, P.FM_CURR_CD, A.USD_LOCL_XCH_RT)) AS FM_CURR_RT," ).append("\n"); 
		query.append("                MAX(DECODE(A.CURR_CD, P.TO_CURR_CD, A.USD_LOCL_XCH_RT)) AS TO_CURR_RT" ).append("\n"); 
		query.append("        FROM   (SELECT  @[fm_curr_cd]     		  AS FM_CURR_CD," ).append("\n"); 
		query.append("						NVL(@[to_curr_cd]," ).append("\n"); 
		query.append("							(SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("						) AS TO_CURR_CD," ).append("\n"); 
		query.append("			            @[inv_isu_dt]     		  AS INV_ISU_DT, " ).append("\n"); 
		query.append("			            @[fm_chg_amt]     		  AS FM_CHG_AMT" ).append("\n"); 
		query.append("			    FROM    DUAL) P," ).append("\n"); 
		query.append("                GL_MON_XCH_RT A" ).append("\n"); 
		query.append("        WHERE   A.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("        AND     A.CURR_CD IN (P.FM_CURR_CD, P.TO_CURR_CD)" ).append("\n"); 
		query.append("        AND     A.ACCT_XCH_RT_YRMON = TO_CHAR(TO_DATE(P.INV_ISU_DT, 'YYYYMMDD'),'YYYYMM')" ).append("\n"); 
		query.append("        GROUP BY A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("        ) A," ).append("\n"); 
		query.append("	   (SELECT  'INFO' AS OUT_COL, A.CLZ_STS_CD, A.EFF_YRMON, A.MIN_GL_DT" ).append("\n"); 
		query.append("        FROM   (SELECT  A.CLZ_STS_CD, A.EFF_YRMON, " ).append("\n"); 
		query.append("                        MIN(B.EFF_YRMON||'01') OVER() AS MIN_GL_DT " ).append("\n"); 
		query.append("                FROM    AP_PERIOD A," ).append("\n"); 
		query.append("                        AP_PERIOD B                        " ).append("\n"); 
		query.append("                WHERE   A.SYS_DIV_CD = B.SYS_DIV_CD" ).append("\n"); 
		query.append("                AND     A.AR_AP_DIV_CD = B.AR_AP_DIV_CD" ).append("\n"); 
		query.append("                AND     A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                AND     A.SYS_DIV_CD = 33" ).append("\n"); 
		query.append("                AND     A.AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("                AND     A.OFC_CD IN (SELECT  DECODE(ROWNUM,1, AR_OFC_CD, AR_HD_QTR_OFC_CD)    " ).append("\n"); 
		query.append("                                     FROM    MDM_ORGANIZATION," ).append("\n"); 
		query.append("                                            (SELECT LEVEL  FROM  DUAL" ).append("\n"); 
		query.append("                                             CONNECT BY LEVEL <= 2)" ).append("\n"); 
		query.append("                                     WHERE   OFC_CD = @[ofc_cd]) " ).append("\n"); 
		query.append("                AND     A.EFF_YRMON  = TO_CHAR(TO_DATE(@[inv_isu_dt], 'YYYYMMDD'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND     B.EFF_YRMON >= TO_CHAR(TO_DATE(@[inv_isu_dt], 'YYYYMMDD'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND     B.CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("        WHERE   ROWNUM = 1                                                                                                " ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("WHERE   A.OUT_COL = B.OUT_COL(+)" ).append("\n"); 

	}
}