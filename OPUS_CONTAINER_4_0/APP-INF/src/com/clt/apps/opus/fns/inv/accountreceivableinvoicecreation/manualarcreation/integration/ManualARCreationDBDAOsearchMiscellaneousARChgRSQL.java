/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchMiscellaneousARChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.03.12 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchMiscellaneousARChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualARCreationDBDAOsearchMiscellaneousARChgRSQL
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchMiscellaneousARChgRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchMiscellaneousARChgRSQL").append("\n"); 
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
		query.append("SELECT A.CHG_SEQ" ).append("\n"); 
		query.append(", A.AR_IF_SER_NO" ).append("\n"); 
		query.append(", A.CHG_CD" ).append("\n"); 
		query.append(", A.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(", A.TRF_RT_AMT" ).append("\n"); 
		query.append(", A.PER_TP_CD" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", DECODE(INSTR(A.CHG_AMT, '.'), 0, RPAD(TRIM(TO_CHAR(TRUNC(A.CHG_AMT), '999,999,999,999'))|| '.', LENGTH(TRIM(TO_CHAR(TRUNC(A.CHG_AMT), '999,999,999,999'))) + DECODE(B.DP_PRCS_KNT, 0, B.DP_PRCS_KNT, B.DP_PRCS_KNT + 1), '0')" ).append("\n"); 
		query.append(", RPAD(TRIM(TO_CHAR(TRUNC(A.CHG_AMT), '999,999,999,999'))|| '.' ||SUBSTR(A.CHG_AMT, INSTR(A.CHG_AMT, '.')+1, LENGTH(A.CHG_AMT)), LENGTH(TRIM(TO_CHAR(TRUNC(A.CHG_AMT), '999,999,999,999'))) + DECODE(B.DP_PRCS_KNT, 0, B.DP_PRCS_KNT, B.DP_PRCS_KNT + 1), '0')) CHG_AMT" ).append("\n"); 
		query.append(", A.CHG_RMK" ).append("\n"); 
		query.append(", A.TVA_FLG" ).append("\n"); 
		query.append(", A.INV_XCH_RT" ).append("\n"); 
		query.append(", B.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM INV_AR_CHG A" ).append("\n"); 
		query.append(", (SELECT CURR_CD" ).append("\n"); 
		query.append(", CURR_NM" ).append("\n"); 
		query.append(", DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE NVL(TO_EFF_DT,SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("AND DELT_FLG!='Y'" ).append("\n"); 
		query.append("ORDER BY CURR_CD) B" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND A.CURR_CD = B.CURR_CD" ).append("\n"); 

	}
}