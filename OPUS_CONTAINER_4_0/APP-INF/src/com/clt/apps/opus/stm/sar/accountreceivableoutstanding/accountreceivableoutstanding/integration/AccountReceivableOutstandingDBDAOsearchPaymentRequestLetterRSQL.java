/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payment Request Letter inquiry
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("overdue_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("overdue_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT MAX(SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD)	VVD_CD" ).append("\n"); 
		query.append("	     , SOH.CLT_OFC_CD OFFICE" ).append("\n"); 
		query.append("         , SOH.BL_NO BL_NO" ).append("\n"); 
		query.append("         , SOH.INV_NO INV_NO" ).append("\n"); 
		query.append("         , MAX(SOH.BKG_REF_NO) REF_NO             " ).append("\n"); 
		query.append("         , MAX(TO_CHAR(TO_DATE(SOH.SAIL_ARR_DT,'YYYY-MM-DD'),'YYYY-MM-DD')) SAIL_ARR_DT" ).append("\n"); 
		query.append("         , MAX(TO_CHAR(TO_DATE(SOH.INV_DT,'YYYY-MM-DD'),'YYYY-MM-DD')) INV_DT" ).append("\n"); 
		query.append("         , MAX(TO_CHAR(TO_DATE(SOH.DUE_DT,'YYYY-MM-DD'),'YYYY-MM-DD')) DUE_DT" ).append("\n"); 
		query.append("         , MAX(TRUNC(SYSDATE) - TRUNC(TO_DATE(SOH.DUE_DT,'YYYYMMDD')))  OVER_DUE" ).append("\n"); 
		query.append("         , SAR_GET_FMT_MASK_FNC(NVL(SOH.INV_CURR_CD, SOH.OFC_CURR_CD),SUM(SOD.INV_AMT * DECODE(SOH.INV_CURR_CD, 'USD', SOD.USD_XCH_RT, SOD.LOCL_XCH_RT))) INV_AMT" ).append("\n"); 
		query.append("         , SAR_GET_FMT_MASK_FNC(NVL(SOH.INV_CURR_CD, SOH.OFC_CURR_CD),SUM(SOD.RCT_AMT * DECODE(SOH.INV_CURR_CD, 'USD', SOD.USD_XCH_RT, SOD.LOCL_XCH_RT))) RCT_AMT" ).append("\n"); 
		query.append("         , SAR_GET_FMT_MASK_FNC(NVL(SOH.INV_CURR_CD, SOH.OFC_CURR_CD),SUM(SOD.ADJ_AMT * DECODE(SOH.INV_CURR_CD, 'USD', SOD.USD_XCH_RT, SOD.LOCL_XCH_RT))) ADJ_AMT" ).append("\n"); 
		query.append("         , SAR_GET_FMT_MASK_FNC(NVL(SOH.INV_CURR_CD, SOH.OFC_CURR_CD),SUM(SOD.BAL_AMT * DECODE(SOH.INV_CURR_CD, 'USD', SOD.USD_XCH_RT, SOD.LOCL_XCH_RT))) BAL_AMT" ).append("\n"); 
		query.append("         , NVL(SOH.INV_CURR_CD, SOH.OFC_CURR_CD) INV_CURR_CD" ).append("\n"); 
		query.append("         , SOH.BIL_TO_CUST_CNT_CD||LPAD(SOH.BIL_TO_CUST_SEQ,6, '0') AS CUST_CD" ).append("\n"); 
		query.append("         , (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM   MDM_CUSTOMER MC" ).append("\n"); 
		query.append("              WHERE  MC.CUST_CNT_CD = SOH.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("              AND    MC.CUST_SEQ = SOH.BIL_TO_CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("         , (SELECT LU_DESC FROM SCO_LU_DTL WHERE LU_TP_CD = 'OTS TYPE' AND LU_CD = SOH.OTS_TP_CD) AS OTS_TP_CD" ).append("\n"); 
		query.append("		 ,'OTS' TYPE" ).append("\n"); 
		query.append("         , SOH.RHQ_CD RHQ_CD " ).append("\n"); 
		query.append("         , SOH.OTS_OFC_CD CTRL_OFC_CD_TEXT   			" ).append("\n"); 
		query.append("	FROM SAR_OTS_HDR SOH, " ).append("\n"); 
		query.append("	     SAR_OTS_DTL SOD" ).append("\n"); 
		query.append("	WHERE SOH.RHQ_CD            = SOD.RHQ_CD  " ).append("\n"); 
		query.append("	AND SOH.OTS_OFC_CD          = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("	AND SOH.BL_NO               = SOD.BL_NO " ).append("\n"); 
		query.append("	AND SOH.INV_NO              = SOD.INV_NO " ).append("\n"); 
		query.append("	AND SOH.OTS_RT_FLG = 'Y' " ).append("\n"); 
		query.append("	#if (${cust_cd} != '')" ).append("\n"); 
		query.append("		#if (${cnsd_cust_flg} == 'N')" ).append("\n"); 
		query.append("			AND SOH.BIL_TO_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	        AND SOH.BIL_TO_CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("	                  		FROM   (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("	                          			FROM   MDM_CUSTOMER" ).append("\n"); 
		query.append("	                          			WHERE  CNSD_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	                          			AND    CNSD_CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("	                          			UNION ALL" ).append("\n"); 
		query.append("	                          			SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("	                          			FROM   MDM_CUSTOMER" ).append("\n"); 
		query.append("	                          			WHERE  CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	                          			AND    CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("	                         		) CON" ).append("\n"); 
		query.append("	                  		WHERE  CON.CUST_CNT_CD = SOH.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	                  		AND    CON.CUST_SEQ    = SOH.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("	                	)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND SOH.OTS_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${colOfcs} != '')" ).append("\n"); 
		query.append("		AND	SOH.CLT_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach ($user_colOfcs IN ${colOfcs})" ).append("\n"); 
		query.append("				#if($velocityCount < $colOfcs.size())" ).append("\n"); 
		query.append("					'$user_colOfcs'," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					'$user_colOfcs'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end			  " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if ( ${bnd} != 'ALL')" ).append("\n"); 
		query.append("	   AND SOH.BKG_IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if ( ${overdue_from} != '')" ).append("\n"); 
		query.append("		AND (TRUNC(SYSDATE) - TRUNC(TO_DATE(SOH.DUE_DT,'YYYYMMDD')))  >= @[overdue_from]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if ( ${overdue_to} != '')" ).append("\n"); 
		query.append("		AND (TRUNC(SYSDATE) - TRUNC(TO_DATE(SOH.DUE_DT,'YYYYMMDD')))  <= @[overdue_to]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if ( ${sail_arr_dt} != '')" ).append("\n"); 
		query.append("	    AND SOH.SAIL_ARR_DT <= REPLACE(@[sail_arr_dt],'-','')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${vvd_cd} != '')" ).append("\n"); 
		query.append("	    AND SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD = @[vvd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND EXISTS" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT 'X'" ).append("\n"); 
		query.append("	  					FROM SAR_OTS_DTL SOD2" ).append("\n"); 
		query.append("	 				WHERE SOD2.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("	   				AND SOD2.OTS_OFC_CD = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("	   				AND SOD2.BL_NO = SOD.BL_NO" ).append("\n"); 
		query.append("	   				AND SOD2.INV_NO = SOD.INV_NO           " ).append("\n"); 
		query.append("	             	#if ( ${ots_opy} == 'OTS')" ).append("\n"); 
		query.append("	             	HAVING SUM(SOD2.BAL_AMT) > 0" ).append("\n"); 
		query.append("	             	#elseif ( ${ots_opy} == 'OPY')" ).append("\n"); 
		query.append("	             	HAVING SUM(SOD2.BAL_AMT) < 0" ).append("\n"); 
		query.append("	             	#else" ).append("\n"); 
		query.append("	             	HAVING SUM(SOD2.BAL_AMT) <> 0" ).append("\n"); 
		query.append("	             	#end" ).append("\n"); 
		query.append("	            )" ).append("\n"); 
		query.append("	#if (${xcld_ots_tp_cd} != '')" ).append("\n"); 
		query.append("		AND NVL(SOH.OTS_TP_CD,'A')    NOT   IN (${xcld_ots_tp_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bl_no} != '')" ).append("\n"); 
		query.append("		AND SOH.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("	    #if(${inv_no} != '')  " ).append("\n"); 
		query.append("	        AND SOH.INV_NO = @[inv_no] " ).append("\n"); 
		query.append("	    #else  " ).append("\n"); 
		query.append("	        AND SOH.INV_NO <> '**********' " ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    	#if(${inv_no} != '')  " ).append("\n"); 
		query.append("	        AND 1 = 2" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("	GROUP BY SOH.RHQ_CD, SOH.CLT_OFC_CD ,SOH.BL_NO ,SOH.INV_NO, SOH.INV_CURR_CD, SOH.OFC_CURR_CD, SOH.BIL_TO_CUST_CNT_CD, SOH.BIL_TO_CUST_SEQ, SOH.OTS_TP_CD, SOH.OTS_OFC_CD" ).append("\n"); 
		query.append("#if ( ${ots_opy} != 'OTS')	" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("    SELECT  NULL VVD_CD" ).append("\n"); 
		query.append("          , SR.RCT_OFC_CD OFFICE" ).append("\n"); 
		query.append("          , SR.RCT_NO BL_NO" ).append("\n"); 
		query.append("          #if (${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("		  , SR.RCT_NO INV_NO" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("          , '**********'             " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          , NULL REF_NO" ).append("\n"); 
		query.append("          --Office가 INV 지역이면 INV_DT에 BL이면 SAIL_ARR_DT에 RCT_DT 조회" ).append("\n"); 
		query.append("          #if (${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("          , NULL SAIL_ARR_DT" ).append("\n"); 
		query.append("          , TO_CHAR(TO_DATE(SR.RCT_DT,'YYYYMMDD'),'YYYY-MM-DD') INV_DT" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("          , TO_CHAR(TO_DATE(SR.RCT_DT,'YYYYMMDD'),'YYYY-MM-DD') SAIL_ARR_DT" ).append("\n"); 
		query.append("          , NULL INV_DT              " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          , TO_CHAR(TO_DATE(SR.RCT_DT,'YYYYMMDD'),'YYYY-MM-DD') DUE_DT" ).append("\n"); 
		query.append("          , TRUNC(SYSDATE) - TRUNC(TO_DATE(SR.RCT_DT,'YYYYMMDD')) OVER_DUE" ).append("\n"); 
		query.append("		  , SAR_GET_FMT_MASK_FNC(SR.RCT_CURR_CD, (SR.RCT_AMT * -1)) INV_AMT" ).append("\n"); 
		query.append("          -- , SAR_GET_FMT_MASK_FNC(MO.AR_CURR_CD, (APL.RCT_APLY_AMT * -1) * SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)) RCT_AMT" ).append("\n"); 
		query.append("          , (SELECT SAR_GET_FMT_MASK_FNC(SR.RCT_CURR_CD,(SUM(SRAD.RCT_APLY_AMT *-1))) FROM " ).append("\n"); 
		query.append("                    SAR_RCT_APLY_HDR SRAH" ).append("\n"); 
		query.append("                  , SAR_RCT_APLY_DTL SRAD" ).append("\n"); 
		query.append("                  , MDM_CURRENCY MC" ).append("\n"); 
		query.append("                   WHERE  " ).append("\n"); 
		query.append("                   SRAH.RCT_SEQ = SR.RCT_SEQ" ).append("\n"); 
		query.append("                   AND SRAH.RCT_SEQ = SRAD.RCT_SEQ" ).append("\n"); 
		query.append("                   AND SRAH.RCT_APLY_HDR_SEQ = SRAD.RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("                   AND SRAH.RVS_FLG = 'N'" ).append("\n"); 
		query.append("                   AND MC.CURR_CD = MO.AR_CURR_CD" ).append("\n"); 
		query.append("                   GROUP BY SRAH.RCT_SEQ" ).append("\n"); 
		query.append("            ) AS RCT_AMT  " ).append("\n"); 
		query.append("          , SAR_GET_FMT_MASK_FNC(SR.RCT_CURR_CD, 0 ) ADJ_AMT" ).append("\n"); 
		query.append("          , SAR_GET_FMT_MASK_FNC(SR.RCT_CURR_CD, (SR.BAL_RCT_AMT * -1)) BAL_AMT" ).append("\n"); 
		query.append("          , SR.RCT_CURR_CD INV_CURR_CD             " ).append("\n"); 
		query.append("          , SR.RCT_CUST_CNT_CD||LPAD(SR.RCT_CUST_SEQ,6,0) CUST_CD" ).append("\n"); 
		query.append("          , (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("               FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("              WHERE MC.CUST_CNT_CD = SR.RCT_CUST_CNT_CD" ).append("\n"); 
		query.append("                AND MC.CUST_SEQ = SR.RCT_CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("          , '' OTS_TP_CD" ).append("\n"); 
		query.append("          , 'RCT' TYPE" ).append("\n"); 
		query.append("          , MO.AR_HD_QTR_OFC_CD RHQ_CD " ).append("\n"); 
		query.append("          , SR.RCT_OFC_CD CTRL_OFC_CD_TEXT" ).append("\n"); 
		query.append("    FROM SAR_RECEIPT SR" ).append("\n"); 
		query.append("       , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("       , MDM_CUSTOMER MC" ).append("\n"); 
		query.append("    WHERE SR.RCT_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND SR.RCT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND SR.RCT_CUST_SEQ = MC.CUST_SEQ         " ).append("\n"); 
		query.append("        AND SR.RCT_CXL_DT IS NULL" ).append("\n"); 
		query.append("        AND SR.RCT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND SR.RCT_CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("	#if ( ${sail_arr_dt} != '')" ).append("\n"); 
		query.append("	    AND SR.RCT_DT <= REPLACE(@[sail_arr_dt],'-','')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${rhq_cd} != '')" ).append("\n"); 
		query.append("	    AND MO.AR_HD_QTR_OFC_CD = @[rhq_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${colOfcs} != '')" ).append("\n"); 
		query.append("		AND	SR.RCT_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach ($user_colOfcs IN ${colOfcs})" ).append("\n"); 
		query.append("				#if($velocityCount < $colOfcs.size())" ).append("\n"); 
		query.append("					'$user_colOfcs'," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					'$user_colOfcs'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end			  " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    AND	SR.RCT_STS_CD = 'UNAPP'" ).append("\n"); 
		query.append("	#if (${cust_cd} != '')" ).append("\n"); 
		query.append("		#if (${cnsd_cust_flg} == 'N')" ).append("\n"); 
		query.append("			AND SR.RCT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	        AND SR.RCT_CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("	                  		FROM   (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("	                          			FROM   MDM_CUSTOMER" ).append("\n"); 
		query.append("	                          			WHERE  CNSD_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	                          			AND    CNSD_CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("	                          			UNION ALL" ).append("\n"); 
		query.append("	                          			SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("	                          			FROM   MDM_CUSTOMER" ).append("\n"); 
		query.append("	                          			WHERE  CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	                          			AND    CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("	                         		) CON" ).append("\n"); 
		query.append("	                  		WHERE  CON.CUST_CNT_CD = SR.RCT_CUST_CNT_CD" ).append("\n"); 
		query.append("	                  		AND    CON.CUST_SEQ    = SR.RCT_CUST_SEQ" ).append("\n"); 
		query.append("	                	)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("    --Receipt Balance가 + 이면 OPY, -이면 OTS" ).append("\n"); 
		query.append("    #if (${ots_opy} == 'OPY')" ).append("\n"); 
		query.append("    AND   SR.BAL_RCT_AMT > 0 " ).append("\n"); 
		query.append("    #elseif (${ots_opy} == 'OTS')" ).append("\n"); 
		query.append("    AND   SR.BAL_RCT_AMT < 0         " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    AND   SR.BAL_RCT_AMT <> 0" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${bl_no} != '')" ).append("\n"); 
		query.append("		AND SR.RCT_NO      = @[bl_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if(${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("	    #if(${inv_no} != '')  " ).append("\n"); 
		query.append("	        AND SR.RCT_NO  = @[inv_no]  " ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    	#if(${inv_no} != '')  " ).append("\n"); 
		query.append("	        AND 1 = 2" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("	#if ( ${overdue_from} != '')" ).append("\n"); 
		query.append("		AND (TRUNC(SYSDATE) - TRUNC(TO_DATE(SR.RCT_DT,'YYYYMMDD')))  >= @[overdue_from]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if ( ${overdue_to} != '')" ).append("\n"); 
		query.append("		AND (TRUNC(SYSDATE) - TRUNC(TO_DATE(SR.RCT_DT,'YYYYMMDD')))  <= @[overdue_to]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if ( ${vvd_cd} != '')" ).append("\n"); 
		query.append("	    AND 1 = 2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY TYPE, BL_NO ,INV_NO" ).append("\n"); 

	}
}