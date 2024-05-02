/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchSubmitToGWListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchSubmitToGWListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Submit to GW
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchSubmitToGWListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchSubmitToGWListRSQL").append("\n"); 
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
		query.append("SELECT SP.APRO_FLG," ).append("\n"); 
		query.append("	   SP.CSR_NO," ).append("\n"); 
		query.append("	   CSR_DT," ).append("\n"); 
		query.append("	   PRODUCED_BY," ).append("\n"); 
		query.append("	   SP.CSR_CURR_CD," ).append("\n"); 
		query.append("	   SP.CSR_AMT," ).append("\n"); 
		query.append("	   CSR_DESC," ).append("\n"); 
		query.append("	   REQUEST_TEAM," ).append("\n"); 
		query.append("	   RQST_DT," ).append("\n"); 
		query.append("       CASE WHEN SP.CUST_CNT_CD IS NOT NULL AND SP.CUST_SEQ IS NOT NULL THEN" ).append("\n"); 
		query.append("                 SP.CUST_CNT_CD || ' ' || SP.CUST_SEQ" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 TO_CHAR(SP.VNDR_SEQ)" ).append("\n"); 
		query.append("        END OWNR_CD, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        CASE WHEN FT.OWNR_SEQ IS NULL THEN" ).append("\n"); 
		query.append("        (  " ).append("\n"); 
		query.append("          CASE WHEN SP.CUST_CNT_CD IS NOT NULL AND SP.CUST_SEQ IS NOT NULL THEN" ).append("\n"); 
		query.append("          (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("          WHERE MV.CUST_CNT_CD = SP.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND MV.CUST_SEQ = SP.CUST_SEQ" ).append("\n"); 
		query.append("          AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("          AND ROWNUM =1)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("          (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("          WHERE MV.VNDR_SEQ = SP.VNDR_SEQ" ).append("\n"); 
		query.append("          AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("          AND ROWNUM =1)" ).append("\n"); 
		query.append("          END " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("      ELSE  " ).append("\n"); 
		query.append("          (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("           FROM FMS_OWNER FO" ).append("\n"); 
		query.append("           WHERE FT.OWNR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM =1" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      END OWNR_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  		(SELECT MV.SUBS_CO_CD " ).append("\n"); 
		query.append("  			FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("  			WHERE MV.VNDR_SEQ = VNDR_SEQ" ).append("\n"); 
		query.append("  			AND MV.VNDR_SEQ = SP.VNDR_SEQ" ).append("\n"); 
		query.append("  		) INTER_CO_CD," ).append("\n"); 
		query.append("  		(SELECT mc.subs_co_cd" ).append("\n"); 
		query.append("    		FROM mdm_customer mc" ).append("\n"); 
		query.append("    		WHERE mc.cust_cnt_cd = SP.CUST_CNT_CD" ).append("\n"); 
		query.append("     		and mc.cust_seq = SP.CUST_SEQ" ).append("\n"); 
		query.append("     		AND ROWNUM =1 " ).append("\n"); 
		query.append("     	) AR_INTER_CO_CD," ).append("\n"); 
		query.append("	   EVID_TP," ).append("\n"); 
		query.append("	   DEDUCTION," ).append("\n"); 
		query.append("	   RQST_AMT," ).append("\n"); 
		query.append("       DIFF_DESC," ).append("\n"); 
		query.append("       CXL_FLG," ).append("\n"); 
		query.append("       CXL_DESC," ).append("\n"); 
		query.append("       SP.VSL_CD," ).append("\n"); 
		query.append("       VSL_ENG_NM," ).append("\n"); 
		query.append("       SP.FLET_CTRT_NO," ).append("\n"); 
		query.append("       SUBSTR(SP.FLET_CTRT_NO, 5, 2) FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("	   AP.RQST_APRO_STEP_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT FC.APRO_FLG," ).append("\n"); 
		query.append("                  FC.SLP_TP_CD" ).append("\n"); 
		query.append("               || FC.SLP_FUNC_CD" ).append("\n"); 
		query.append("               || FC.SLP_OFC_CD" ).append("\n"); 
		query.append("               || FC.SLP_ISS_DT" ).append("\n"); 
		query.append("               || FC.SLP_SER_NO CSR_NO," ).append("\n"); 
		query.append("               TO_CHAR(FC.CRE_DT,'YYYYMMDD') CSR_DT," ).append("\n"); 
		query.append("               (SELECT USR_NM" ).append("\n"); 
		query.append("                  FROM COM_USER" ).append("\n"); 
		query.append("                 WHERE USR_ID = FC.CSR_USR_ID" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) PRODUCED_BY," ).append("\n"); 
		query.append("               FC.CSR_CURR_CD," ).append("\n"); 
		query.append("               TO_CHAR(FC.CSR_AMT,'FM999,999,999,999,999,990.00') CSR_AMT," ).append("\n"); 
		query.append("               FC.CSR_DESC," ).append("\n"); 
		query.append("               FC.SLP_OFC_CD REQUEST_TEAM," ).append("\n"); 
		query.append("               FC.RQST_DT," ).append("\n"); 
		query.append("               (SELECT CUST_CNT_CD" ).append("\n"); 
		query.append("                  FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                 WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("				   AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) CUST_CNT_CD," ).append("\n"); 
		query.append("               (SELECT CUST_SEQ" ).append("\n"); 
		query.append("                  FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                 WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("				   AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) CUST_SEQ," ).append("\n"); 
		query.append("               (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("                  FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                 WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("				   AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("				   AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) VNDR_SEQ," ).append("\n"); 
		query.append("               DECODE(FC.EVID_TP_CD,'1','TAX','4','CI','ETC') EVID_TP," ).append("\n"); 
		query.append("               CASE WHEN FC.DIFF_AMT > 0 THEN" ).append("\n"); 
		query.append("                         'Y'" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         'N'" ).append("\n"); 
		query.append("                END DEDUCTION," ).append("\n"); 
		query.append("               TO_CHAR(FC.RQST_AMT,'FM999,999,999,999,999,990.00') RQST_AMT," ).append("\n"); 
		query.append("               TO_CHAR(FC.DIFF_AMT,'FM999,999,999,999,999,990.00') DIFF_DESC," ).append("\n"); 
		query.append("               FC.CXL_FLG," ).append("\n"); 
		query.append("               FC.CXL_DESC," ).append("\n"); 
		query.append("               FC.FLET_CTRT_NO," ).append("\n"); 
		query.append("			   (SELECT NVL(VSL_CD,(SELECT VSL_CD" ).append("\n"); 
		query.append("			   						 FROM FMS_CONTRACT" ).append("\n"); 
		query.append("			                        WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("			                          AND ROWNUM = 1))" ).append("\n"); 
		query.append("                 FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("                WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("				  AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("				  AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("				  AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("				  AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                  AND ROWNUM = 1) VSL_CD," ).append("\n"); 
		query.append("			   (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("  				  FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append(" 				 WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("   				   AND VSL_CD = (SELECT NVL(VSL_CD,(SELECT VSL_CD" ).append("\n"); 
		query.append("			   						                  FROM FMS_CONTRACT" ).append("\n"); 
		query.append("			                                         WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("			                                           AND ROWNUM = 1))" ).append("\n"); 
		query.append("                  				   FROM FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("					              WHERE FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("									AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("									AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("									AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("									AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("                   				    AND ROWNUM = 1)) VSL_ENG_NM" ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION FC" ).append("\n"); 
		query.append("         WHERE FC.CXL_FLG = 'N'" ).append("\n"); 
		query.append("         #if (${vat_slp_tp_cd} != '')" ).append("\n"); 
		query.append("		   AND FC.VAT_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 #if (${from_eff_dt} != '')" ).append("\n"); 
		query.append("           AND FC.EFF_DT BETWEEN REPLACE(@[from_eff_dt],'-','') AND REPLACE(@[to_eff_dt],'-','')" ).append("\n"); 
		query.append("		 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 #if (${from_cre_dt} != '')" ).append("\n"); 
		query.append("           AND TO_CHAR(FC.CRE_DT,'YYYYMMDD') BETWEEN REPLACE(@[from_cre_dt],'-','') AND REPLACE(@[to_cre_dt],'-','')  " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("           AND FC.FLET_CTRT_NO IN (SELECT FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                                    WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                   UNION ALL" ).append("\n"); 
		query.append("                                   SELECT FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     FROM FMS_ID_VSL" ).append("\n"); 
		query.append("                                    WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                      AND USE_FLG = 'Y')  " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         #if (${csr_no} != '')" ).append("\n"); 
		query.append("           AND    FC.SLP_TP_CD" ).append("\n"); 
		query.append("               || FC.SLP_FUNC_CD" ).append("\n"); 
		query.append("               || FC.SLP_OFC_CD" ).append("\n"); 
		query.append("               || FC.SLP_ISS_DT" ).append("\n"); 
		query.append("               || FC.SLP_SER_NO LIKE @[csr_no] || '%'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("       ) SP" ).append("\n"); 
		query.append("	   ,FMS_CONTRACT  FT" ).append("\n"); 
		query.append("	   ,AP_INV_HDR AP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SP.FLET_CTRT_NO = FT.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("AND SP.CSR_NO = AP.CSR_NO(+)" ).append("\n"); 
		query.append("AND AP.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY CSR_NO" ).append("\n"); 

	}
}