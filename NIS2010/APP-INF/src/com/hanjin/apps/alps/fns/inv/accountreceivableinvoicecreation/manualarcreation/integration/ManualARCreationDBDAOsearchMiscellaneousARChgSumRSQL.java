/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchMiscellaneousARChgSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.03.12 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchMiscellaneousARChgSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualARCreationDBDAOsearchMiscellaneousARChgSumRSQL
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchMiscellaneousARChgSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchMiscellaneousARChgSumRSQL").append("\n"); 
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
		query.append("SELECT A.CURR_CD" ).append("\n"); 
		query.append("--, SUM(A.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append(", DECODE(INSTR(SUM(A.CHG_AMT), '.'), 0, RPAD(TRIM(TO_CHAR(TRUNC(SUM(A.CHG_AMT)), '999,999,999,999'))|| '.', LENGTH(TRIM(TO_CHAR(TRUNC(SUM(A.CHG_AMT)), '999,999,999,999'))) + DECODE(C.DP_PRCS_KNT, 0, C.DP_PRCS_KNT, C.DP_PRCS_KNT + 1), '0')" ).append("\n"); 
		query.append(", RPAD(TRIM(TO_CHAR(TRUNC(SUM(A.CHG_AMT)), '999,999,999,999'))|| '.' ||SUBSTR(SUM(A.CHG_AMT), INSTR(SUM(A.CHG_AMT), '.')+1, LENGTH(SUM(A.CHG_AMT))), LENGTH(TRIM(TO_CHAR(TRUNC(SUM(A.CHG_AMT)), '999,999,999,999'))) + DECODE(C.DP_PRCS_KNT, 0, C.DP_PRCS_KNT, C.DP_PRCS_KNT + 1), '0')) CHG_AMT" ).append("\n"); 
		query.append(", MIN(A.INV_XCH_RT) INV_XCH_RT" ).append("\n"); 
		query.append(", B.LOCL_CURR_CD" ).append("\n"); 
		query.append("--, SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT) LOCAL_TOTAL" ).append("\n"); 
		query.append(", DECODE(INSTR(SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT), '.'), 0, RPAD(TRIM(TO_CHAR(TRUNC(SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT)), '999,999,999,999'))|| '.', LENGTH(TRIM(TO_CHAR(TRUNC(SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT)), '999,999,999,999'))) + DECODE(D.DP_PRCS_KNT, 0, D.DP_PRCS_KNT, D.DP_PRCS_KNT + 1), '0')" ).append("\n"); 
		query.append(", RPAD(TRIM(TO_CHAR(TRUNC(SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT)), '999,999,999,999'))|| '.' ||SUBSTR(SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT), INSTR(SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT), '.')+1, LENGTH(SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT))), LENGTH(TRIM(TO_CHAR(TRUNC(SUM(A.CHG_AMT) * MIN(A.INV_XCH_RT)), '999,999,999,999'))) + DECODE(D.DP_PRCS_KNT, 0, D.DP_PRCS_KNT, D.DP_PRCS_KNT + 1), '0')) LOCAL_TOTAL" ).append("\n"); 
		query.append(", C.DP_PRCS_KNT" ).append("\n"); 
		query.append(", D.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM INV_AR_CHG A" ).append("\n"); 
		query.append(", INV_AR_MN B" ).append("\n"); 
		query.append(", (SELECT CURR_CD" ).append("\n"); 
		query.append(", CURR_NM" ).append("\n"); 
		query.append(", DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE NVL(TO_EFF_DT,SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("AND DELT_FLG!='Y'" ).append("\n"); 
		query.append("ORDER BY CURR_CD) C" ).append("\n"); 
		query.append(", (SELECT EE.DP_PRCS_KNT" ).append("\n"); 
		query.append(", AA.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION AA" ).append("\n"); 
		query.append(", MDM_CURRENCY EE" ).append("\n"); 
		query.append("WHERE AA.AR_CURR_CD = EE.CURR_CD) D" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND A.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("AND B.AR_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("GROUP BY A.CURR_CD" ).append("\n"); 
		query.append(", B.LOCL_CURR_CD" ).append("\n"); 
		query.append(", C.DP_PRCS_KNT" ).append("\n"); 
		query.append(", D.DP_PRCS_KNT" ).append("\n"); 

	}
}