/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchOffsetInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOsearchOffsetInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search offset master
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchOffsetInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_offst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchOffsetInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      DECODE(OFFST_TP_CD, 'AP', VNDR_NO, BIL_TO_CNT_CD || LPAD(A.BIL_TO_CUST_SEQ, 6,'0'))  AS VNDR_NO" ).append("\n"); 
		query.append("	, CASE " ).append("\n"); 
		query.append("	      WHEN OFFST_TP_CD = 'AP' THEN " ).append("\n"); 
		query.append("	       (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = TO_NUMBER(A.VNDR_NO) AND ROWNUM = 1) " ).append("\n"); 
		query.append("	      ELSE " ).append("\n"); 
		query.append("	       (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.BIL_TO_CNT_CD AND CUST_SEQ = A.BIL_TO_CUST_SEQ AND ROWNUM = 1)" ).append("\n"); 
		query.append("	  END AS VNDR_LGL_ENG_NM	" ).append("\n"); 
		query.append("	, DECODE(OFFST_TP_CD, 'AP', AP_INV_NO, DECODE(A.INV_NO, '**********' , BL_NO, INV_NO)) AS BL_INV_NO" ).append("\n"); 
		query.append("    , AR_OFFST_NO" ).append("\n"); 
		query.append("    , AR_OFFST_DT" ).append("\n"); 
		query.append("    , OFC_CD" ).append("\n"); 
		query.append("    , OFFST_CURR_CD" ).append("\n"); 
		query.append("    , BIL_TO_CNT_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , VNDR_NO AS VNDR_NO1" ).append("\n"); 
		query.append("    , OFFST_TP_CD" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , OFFST_AMT" ).append("\n"); 
		query.append("    , OFFST_XCH_RT" ).append("\n"); 
		query.append("    , OFFST_XCH_AMT" ).append("\n"); 
		query.append("    , TO_CHAR(GL_DT, 'YYYYMMDD') GL_DT" ).append("\n"); 
		query.append("    , CXL_FLG" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , CHG_TP_CD" ).append("\n"); 
		query.append("    , MAX_AR_IF_NO" ).append("\n"); 
		query.append("    , AP_INV_NO" ).append("\n"); 
		query.append("    , RHQ_CD" ).append("\n"); 
		query.append("    , OTS_OFC_CD" ).append("\n"); 
		query.append("    , AR_OFFST_SEQ" ).append("\n"); 
		query.append("    , OTS_BAL_AMT" ).append("\n"); 
		query.append("    , OFFST_OFC_CD" ).append("\n"); 
		query.append("    , '' AS AR_OFFST_DT_FM" ).append("\n"); 
		query.append("    , '' AS AR_OFFST_DT_TO" ).append("\n"); 
		query.append("    , AP_RMK AS AP_REMARK    " ).append("\n"); 
		query.append("    , AP_INV_TERM_DT AS  AP_DU_DT" ).append("\n"); 
		query.append("    , (SELECT MAX(ADJ_GL_DT) FROM SAR_ADJ_HIS WHERE ADJ_NO = A.AR_OFFST_NO AND ADJ_STS_CD = 'REVERSE') AS REV_GL_DT" ).append("\n"); 
		query.append("    , (SELECT NVL(MC.DP_PRCS_KNT,0) FROM MDM_CURRENCY MC WHERE MC.CURR_CD = A.CURR_CD) AS DP_PRCS_KNT " ).append("\n"); 
		query.append("FROM SAR_OFFST_MST A" ).append("\n"); 
		query.append("WHERE A.AR_OFFST_NO = @[ar_offst_no]" ).append("\n"); 
		query.append("AND   A.OFFST_OFC_CD = @[offst_ofc_cd]" ).append("\n"); 

	}
}