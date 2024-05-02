/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchGlInquiryOwnerInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.01 
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

public class TCharterIOInvoiceDBDAOSearchGlInquiryOwnerInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL Inquiry Owner Accout 정보를 조회한다
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchGlInquiryOwnerInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eff_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldgr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchGlInquiryOwnerInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT VVD_CD" ).append("\n"); 
		query.append("     , N1ST_CURR_CD" ).append("\n"); 
		query.append("     , N1ST_AMT" ).append("\n"); 
		query.append("     , ORG_SLP_NO" ).append("\n"); 
		query.append("     , SLP_NO" ).append("\n"); 
		query.append("     , CXL_SLP_NO" ).append("\n"); 
		query.append("     , AP_DESC" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , ACCT_CD" ).append("\n"); 
		query.append("     , CTR_CD" ).append("\n"); 
		query.append("     , STL_DT" ).append("\n"); 
		query.append("     , SUM(N1ST_AMT) OVER(PARTITION BY ORG_SLP_NO, STL_DT) ORG_SUM_AMT" ).append("\n"); 
		query.append("     , MAX(EFF_DT) OVER(PARTITION BY ORG_SLP_NO, STL_DT) MAX_EFF_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT VVD_CD" ).append("\n"); 
		query.append("             , N1ST_CURR_CD" ).append("\n"); 
		query.append("             , N1ST_AMT" ).append("\n"); 
		query.append("             , DECODE(SUBSTR(OWNR_SLP_NO, 3, 1), 'C', (SELECT PAIR_SLP_TP_CD||PAIR_SLP_FUNC_CD||PAIR_SLP_OFC_CD||PAIR_SLP_ISS_DT||PAIR_SLP_SER_NO||PAIR_SLP_SEQ_NO" ).append("\n"); 
		query.append("                                                       FROM FMS_OWNR_ACCT_SLP" ).append("\n"); 
		query.append("                                                       WHERE SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO||SLP_SEQ_NO = OWNR_SLP_NO), OWNR_SLP_NO) ORG_SLP_NO" ).append("\n"); 
		query.append("             , SLP_NO" ).append("\n"); 
		query.append("             , DECODE(SUBSTR(OWNR_SLP_NO, 3, 1), 'C', OWNR_SLP_NO, '') CXL_SLP_NO" ).append("\n"); 
		query.append("             , AP_DESC" ).append("\n"); 
		query.append("             , EFF_DT" ).append("\n"); 
		query.append("             , ACCT_CD" ).append("\n"); 
		query.append("             , CTR_CD" ).append("\n"); 
		query.append("             , STL_DT" ).append("\n"); 
		query.append("             , CRE_DT" ).append("\n"); 
		query.append("        FROM (     " ).append("\n"); 
		query.append("                 SELECT D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD||D.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("                      , D.CSR_CURR_CD N1ST_CURR_CD" ).append("\n"); 
		query.append("                      , D.CSR_AMT N1ST_AMT" ).append("\n"); 
		query.append("                      , NVL(D.ORG_SLP_TP_CD||D.ORG_SLP_FUNC_CD||D.ORG_SLP_OFC_CD||D.ORG_ISS_DT||D.ORG_SLP_SER_NO||D.ORG_SLP_SEQ_NO, " ).append("\n"); 
		query.append("                            D.AP_SLP_TP_CD||D.AP_SLP_FUNC_CD||D.AP_SLP_OFC_CD||D.AP_SLP_ISS_DT||D.AP_SLP_SER_NO||D.AP_SLP_SEQ_NO) OWNR_SLP_NO" ).append("\n"); 
		query.append("                      , D.SLP_TP_CD||D.SLP_FUNC_CD||D.SLP_OFC_CD||D.SLP_ISS_DT||D.SLP_SER_NO||D.SLP_SEQ_NO SLP_NO" ).append("\n"); 
		query.append("                      , D.CSR_DESC AP_DESC" ).append("\n"); 
		query.append("                      , M.EFF_DT EFF_DT" ).append("\n"); 
		query.append("                      , D.ACCT_CD ACCT_CD" ).append("\n"); 
		query.append("                      , D.CTR_CD CTR_CD" ).append("\n"); 
		query.append("                      , D.STL_DT  " ).append("\n"); 
		query.append("                      , D.CRE_DT    " ).append("\n"); 
		query.append("                 FROM FMS_CONSULTATION M,  " ).append("\n"); 
		query.append("                      FMS_CSUL_SLP D" ).append("\n"); 
		query.append("                 WHERE M.SLP_TP_CD = D.SLP_TP_CD" ).append("\n"); 
		query.append("                 AND M.SLP_FUNC_CD = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("                 AND M.SLP_OFC_CD = D.SLP_OFC_CD" ).append("\n"); 
		query.append("                 AND M.SLP_ISS_DT = D.SLP_ISS_DT" ).append("\n"); 
		query.append("                 AND M.SLP_SER_NO = D.SLP_SER_NO" ).append("\n"); 
		query.append("                 AND M.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("                 AND M.CXL_FLG = 'N'" ).append("\n"); 
		query.append("                 AND D.ACCT_CD = '111071'    " ).append("\n"); 
		query.append("                 #if (${dt_opt} == 'L') " ).append("\n"); 
		query.append("                    AND M.EFF_DT <= @[ldgr_dt]" ).append("\n"); 
		query.append("                    AND (D.STL_DT IS NULL OR D.STL_DT > @[ldgr_dt])" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    AND M.EFF_DT >= @[eff_dt1] " ).append("\n"); 
		query.append("                    AND M.EFF_DT <= @[eff_dt2]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${stl_flg} == 'Y')" ).append("\n"); 
		query.append("                    AND D.STL_DT IS NOT NULL" ).append("\n"); 
		query.append("                 #elseif (${stl_flg} == 'N')" ).append("\n"); 
		query.append("                    AND D.STL_DT IS NULL" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if (${vsl_cd} != '')                                                                               " ).append("\n"); 
		query.append("                    AND D.VSL_CD = @[vsl_cd]                                                                          " ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("	 )" ).append("\n"); 
		query.append("ORDER BY ORG_SLP_NO, CRE_DT" ).append("\n"); 

	}
}