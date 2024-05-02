/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchStopOffBkgListforAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchStopOffBkgListforAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_1405 화면에서 사용하는 SQL
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchStopOffBkgListforAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchStopOffBkgListforAuditRSQL").append("\n"); 
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
		query.append("SELECT B.BKG_NO," ).append("\n"); 
		query.append("       S.CUST_CNT_CD||LPAD(S.CUST_SEQ,6,'0') SHPR_CD," ).append("\n"); 
		query.append("       NVL((SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("        FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("        WHERE CUST_CNT_CD = S.CUST_CNT_CD " ).append("\n"); 
		query.append("        AND CUST_SEQ = S.CUST_SEQ" ).append("\n"); 
		query.append("       ),' ')  AS SHPR_NM, /* 머지 위해 공백 추가 */" ).append("\n"); 
		query.append("       NVL(R.BKG_CTRT_TP_CD,' ') AS BKG_CTRT_TP_CD,  /* Contract Type. Hidden (R : RFA, S : S/C, T : TARIFF) */" ).append("\n"); 
		query.append("       NVL(CASE WHEN R.BKG_CTRT_TP_CD = 'R' THEN B.RFA_NO" ).append("\n"); 
		query.append("            WHEN R.BKG_CTRT_TP_CD = 'S' THEN B.SC_NO" ).append("\n"); 
		query.append("            WHEN R.BKG_CTRT_TP_CD = 'T' THEN B.TAA_NO" ).append("\n"); 
		query.append("       END,' ') AS CTRT_NO," ).append("\n"); 
		query.append("       NVL(B.SVC_SCP_CD,' ') AS SVC_SCP_CD, " ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       NVL((SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = B.CMDT_CD),' ') CMDT_NM, /* 머지 위해 공백 추가 */" ).append("\n"); 
		query.append("       NVL(B.STOP_OFF_LOC_CD,' ')   AS STOP_OFF_LOC_CD," ).append("\n"); 
		query.append("       NVL(B.STOP_OFF_DIFF_RMK,' ') AS STOP_OFF_DIFF_RMK," ).append("\n"); 
		query.append("       NVL(B.INTER_RMK,' ')         AS INTER_RMK," ).append("\n"); 
		query.append("       NVL(B.XTER_RMK,' ')          AS XTER_RMK," ).append("\n"); 
		query.append("       NVL(R.RT_INTER_RMK,' ')      AS RT_INTER_RMK," ).append("\n"); 
		query.append("       NVL(R.DIFF_RMK,' ')          AS DIFF_RMK," ).append("\n"); 
		query.append("       C.CHG_CD, " ).append("\n"); 
		query.append("       C.CURR_CD," ).append("\n"); 
		query.append("       C.RAT_UT_CD," ).append("\n"); 
		query.append("       C.RAT_AS_QTY," ).append("\n"); 
		query.append("       C.CHG_UT_AMT," ).append("\n"); 
		query.append("       C.CHG_AMT" ).append("\n"); 
		query.append("FROM BKG_RATE R " ).append("\n"); 
		query.append("     JOIN BKG_BOOKING B ON ( R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                             AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                             AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                             AND B.STOP_OFF_LOC_CD IS NOT NULL  -- Stop Off 정보가 있는 BKG만 조회" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("     JOIN BKG_CUSTOMER S ON ( R.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("                              AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("     LEFT OUTER JOIN BKG_CHG_RT C ON ( R.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                                       AND CHG_CD IN ('MIS','MSC')" ).append("\n"); 
		query.append("                                       AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("WHERE R.RT_APLY_DT BETWEEN TO_DATE(REPLACE(@[fm_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 0.99999" ).append("\n"); 

	}
}