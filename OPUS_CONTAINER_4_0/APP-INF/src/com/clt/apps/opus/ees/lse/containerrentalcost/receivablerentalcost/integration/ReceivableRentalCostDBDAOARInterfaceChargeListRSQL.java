/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOARInterfaceChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.29 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOARInterfaceChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 자료의 AR Interface Charge 정보를 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOARInterfaceChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_tax_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_amount",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOARInterfaceChargeListRSQL").append("\n"); 
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
		query.append("SELECT  1 AS CHG_SEQ," ).append("\n"); 
		query.append("        P.CURR_CD," ).append("\n"); 
		query.append("        'EQL' AS CHG_CD," ).append("\n"); 
		query.append("        'MIS. REVENUE(CNTR) - EQ RENTAL' AS CHG_FULL_NM," ).append("\n"); 
		query.append("        'BL' PER_TP_CD,                     " ).append("\n"); 
		query.append("        P.CHG_AMT AS TRF_RT_AMT,        " ).append("\n"); 
		query.append("        1 AS RAT_AS_CNTR_QTY,                  " ).append("\n"); 
		query.append("		P.CHG_AMT AS CHG_AMT,        " ).append("\n"); 
		query.append("       (SELECT  MAX(DECODE(P.CURR_CD, B.AR_CURR_CD, 1, A.USD_LOCL_XCH_RT)) TO_USD_RT" ).append("\n"); 
		query.append("        FROM    GL_MON_XCH_RT A," ).append("\n"); 
		query.append("                MDM_ORGANIZATION B " ).append("\n"); 
		query.append("        WHERE   A.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("		AND     B.OFC_CD = P.OFC_CD" ).append("\n"); 
		query.append("		AND     A.CURR_CD IN (P.CURR_CD, B.AR_CURR_CD)" ).append("\n"); 
		query.append("		AND     A.CURR_CD = B.AR_CURR_CD" ).append("\n"); 
		query.append("    	AND     A.ACCT_XCH_RT_YRMON = TO_CHAR(TO_DATE(P.INV_ISU_DT,'YYYYMMDD'), 'YYYYMM')        " ).append("\n"); 
		query.append("    	GROUP BY A.ACCT_XCH_RT_YRMON) AS INV_XCH_RT," ).append("\n"); 
		query.append("        DECODE(P.LOCL_TAX_FLG, 'Y','Y','N') AS TVA_FLG,                       " ).append("\n"); 
		query.append("        'XXX' AS REP_CHG_CD,                   " ).append("\n"); 
		query.append("        'Container Lease' AS CHG_RMK,          " ).append("\n"); 
		query.append("        P.CRE_USR_ID AS CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("        P.CRE_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("        SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM   (SELECT  @[to_chg_amt] AS CHG_AMT,                        " ).append("\n"); 
		query.append("	            @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("				@[inv_isu_dt] AS INV_ISU_DT," ).append("\n"); 
		query.append("				@[ofc_cd]     AS OFC_CD," ).append("\n"); 
		query.append("				@[to_curr_cd] AS CURR_CD," ).append("\n"); 
		query.append("				@[locl_tax_flg] AS LOCL_TAX_FLG                                               " ).append("\n"); 
		query.append("	    FROM    DUAL) P" ).append("\n"); 
		query.append("#if (${locl_tax_flg} == 'Y')            " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  2 AS CHG_SEQ," ).append("\n"); 
		query.append("        P.CURR_CD," ).append("\n"); 
		query.append("        'TVA' AS CHG_CD," ).append("\n"); 
		query.append("        'V.A.T RECEIVED' AS CHG_FULL_NM," ).append("\n"); 
		query.append("        'BL' PER_TP_CD," ).append("\n"); 
		query.append("        P.CHG_AMT AS TRF_RT_AMT," ).append("\n"); 
		query.append("        1 AS RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("        P.CHG_AMT AS CHG_AMT," ).append("\n"); 
		query.append("       (SELECT  MAX(DECODE(P.CURR_CD, B.AR_CURR_CD, 1, A.USD_LOCL_XCH_RT)) TO_USD_RT" ).append("\n"); 
		query.append("        FROM    GL_MON_XCH_RT A," ).append("\n"); 
		query.append("                MDM_ORGANIZATION B " ).append("\n"); 
		query.append("        WHERE   A.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("		AND     B.OFC_CD = P.OFC_CD" ).append("\n"); 
		query.append("		AND     A.CURR_CD IN (P.CURR_CD, B.AR_CURR_CD)" ).append("\n"); 
		query.append("		AND     A.CURR_CD = B.AR_CURR_CD" ).append("\n"); 
		query.append("    	AND     A.ACCT_XCH_RT_YRMON = TO_CHAR(TO_DATE(P.INV_ISU_DT,'YYYYMMDD'), 'YYYYMM')        " ).append("\n"); 
		query.append("    	GROUP BY A.ACCT_XCH_RT_YRMON) AS INV_XCH_RT," ).append("\n"); 
		query.append("        'N'  AS TVA_FLG," ).append("\n"); 
		query.append("        'XXX' AS REP_CHG_CD," ).append("\n"); 
		query.append("        'Container Lease' AS CHG_RMK," ).append("\n"); 
		query.append("        P.CRE_USR_ID AS CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("        P.CRE_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("        SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM   (SELECT  @[tax_amount] AS CHG_AMT,                        " ).append("\n"); 
		query.append("	            @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("				@[inv_isu_dt] AS INV_ISU_DT," ).append("\n"); 
		query.append("				@[ofc_cd]     AS OFC_CD," ).append("\n"); 
		query.append("				@[to_curr_cd] AS CURR_CD," ).append("\n"); 
		query.append("				@[locl_tax_flg] AS LOCL_TAX_FLG                                                " ).append("\n"); 
		query.append("	    FROM    DUAL) P " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}