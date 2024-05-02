/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchNonShippingARListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchNonShippingARListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Main, Invoice Charge, Security 테이블을 Select
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchNonShippingARListRSQL(){
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchNonShippingARListRSQL").append("\n"); 
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
		query.append("SELECT /*+ ALL_ROWS */A.AR_OFC_CD," ).append("\n"); 
		query.append("      TO_CHAR(TO_DATE(A.GL_EFF_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') GL_EFF_DT," ).append("\n"); 
		query.append("      TO_CHAR(TO_DATE(A.BL_INV_IF_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("      B.ACCT_CD," ).append("\n"); 
		query.append("      A.SLP_NO," ).append("\n"); 
		query.append("      A.BL_SRC_NO," ).append("\n"); 
		query.append("      A.AR_IF_NO," ).append("\n"); 
		query.append("      A.ACT_CUST_CNT_CD ||'-'|| LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("      C.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("      C.CUST_RGST_NO," ).append("\n"); 
		query.append("      B.CURR_CD," ).append("\n"); 
		query.append("      A.INV_RMK CHG_RMK," ).append("\n"); 
		query.append("      SAR_GET_FMT_MASK_FNC(D.CURR_CD,B.CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("      A.CRE_USR_ID," ).append("\n"); 
		query.append("      (SELECT E.USR_NM FROM COM_USER E WHERE A.CRE_USR_ID = E.USR_ID) USR_NM" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      INV_AR_CHG B," ).append("\n"); 
		query.append("      MDM_CUSTOMER C," ).append("\n"); 
		query.append("      MDM_CURRENCY D" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("      AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("      AND A.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("      AND D.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                            WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                        WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                          WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                              AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gubun} == '1')" ).append("\n"); 
		query.append("      AND A.GL_EFF_DT BETWEEN REPLACE(@[fm_dt], '-', '') AND REPLACE(@[to_dt], '-', '') " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.BL_INV_IF_DT BETWEEN REPLACE(@[fm_dt], '-', '') AND REPLACE(@[to_dt], '-', '') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("      AND A.REV_SRC_CD = 'TH' " ).append("\n"); 
		query.append("#if (${acct_cd} != '')" ).append("\n"); 
		query.append("      AND B.ACCT_CD = @[acct_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slp_no} != '')" ).append("\n"); 
		query.append("      AND A.SLP_NO = @[slp_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("      AND A.ACT_CUST_SEQ = @[act_cust_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("      AND A.CRE_USR_ID = @[cre_usr_id] " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}