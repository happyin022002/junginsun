/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnersAccountSlpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOOwnersAccountSlpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS_OWNR_ACCT_SLP
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnersAccountSlpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_csr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnersAccountSlpCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_OWNR_ACCT_SLP" ).append("\n"); 
		query.append("(SLP_TP_CD" ).append("\n"); 
		query.append(", SLP_FUNC_CD" ).append("\n"); 
		query.append(", SLP_OFC_CD" ).append("\n"); 
		query.append(", SLP_ISS_DT" ).append("\n"); 
		query.append(", SLP_SER_NO	-- 5" ).append("\n"); 
		query.append(", SLP_SEQ_NO" ).append("\n"); 
		query.append(", FLET_PPAY_RLT_CD" ).append("\n"); 
		query.append(", ACCT_CD" ).append("\n"); 
		query.append(", CTR_CD" ).append("\n"); 
		query.append(", EFF_DT	-- 10" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", REV_DIR_CD" ).append("\n"); 
		query.append(", N1ST_CURR_CD	-- 15" ).append("\n"); 
		query.append(", N1ST_AMT" ).append("\n"); 
		query.append(", N2ND_CURR_CD" ).append("\n"); 
		query.append(", N2ND_AMT" ).append("\n"); 
		query.append(", LOCL_XCH_RT_AMT" ).append("\n"); 
		query.append(", AP_DESC	-- 20" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", ACCT_ITM_SEQ	-- 25" ).append("\n"); 
		query.append(", PAIR_SLP_TP_CD" ).append("\n"); 
		query.append(", PAIR_SLP_FUNC_CD" ).append("\n"); 
		query.append(", PAIR_SLP_OFC_CD" ).append("\n"); 
		query.append(", PAIR_SLP_ISS_DT" ).append("\n"); 
		query.append(", PAIR_SLP_SER_NO	-- 30" ).append("\n"); 
		query.append(", PAIR_SLP_SEQ_NO" ).append("\n"); 
		query.append(", OA_STL_STS_CD" ).append("\n"); 
		query.append(", VNDR_SEQ)" ).append("\n"); 
		query.append("SELECT FCS.SLP_TP_CD" ).append("\n"); 
		query.append("       , FCS.SLP_FUNC_CD" ).append("\n"); 
		query.append("       , FCS.SLP_OFC_CD" ).append("\n"); 
		query.append("       , FCS.SLP_ISS_DT" ).append("\n"); 
		query.append("       , FCS.SLP_SER_NO	-- 5 " ).append("\n"); 
		query.append("       , FCS.SLP_SEQ_NO" ).append("\n"); 
		query.append("       , 'O' FLET_PPAY_RLT_CD" ).append("\n"); 
		query.append("       , '111071' ACCT_CD" ).append("\n"); 
		query.append("       , FCS.CTR_CD" ).append("\n"); 
		query.append("       , FC.EFF_DT	-- 10" ).append("\n"); 
		query.append("       , FCS.VSL_CD" ).append("\n"); 
		query.append("       , FCS.SKD_VOY_NO" ).append("\n"); 
		query.append("       , FCS.SKD_DIR_CD" ).append("\n"); 
		query.append("       , FCS.REV_DIR_CD" ).append("\n"); 
		query.append("       , 'USD' N1ST_CURR_CD -- USD 15" ).append("\n"); 
		query.append("       , (SELECT ROUND(FMS_CAL_CURR_RATE_FNC(SUBSTR(FC.EFF_DT, 1, 6), FCS.CSR_CURR_CD, FCS.CSR_AMT),2) USD_AMT" ).append("\n"); 
		query.append("            FROM DUAL) N1ST_AMT" ).append("\n"); 
		query.append("       , FCS.CSR_CURR_CD N2ND_CURR_CD -- LCL" ).append("\n"); 
		query.append("       , @[org_csr_amt] N2ND_AMT" ).append("\n"); 
		query.append("       , (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("    			FROM GL_MON_XCH_RT A" ).append("\n"); 
		query.append("    			WHERE A.ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("    			  AND A.CURR_CD           = @[src_curr_cd]" ).append("\n"); 
		query.append("    			  AND A.ACCT_XCH_RT_YRMON = SUBSTR(FC.EFF_DT, 1, 6)) LOCL_XCH_RT_AMT" ).append("\n"); 
		query.append("       , FCS.CSR_DESC AP_DESC	-- 20" ).append("\n"); 
		query.append("       , @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("	   , FCS.ACCT_ITM_SEQ	-- 25" ).append("\n"); 
		query.append("       , FCS.PAIR_SLP_TP_CD" ).append("\n"); 
		query.append("       , FCS.PAIR_SLP_FUNC_CD" ).append("\n"); 
		query.append("       , FCS.PAIR_SLP_OFC_CD" ).append("\n"); 
		query.append("       , FCS.PAIR_SLP_ISS_DT" ).append("\n"); 
		query.append("       , FCS.PAIR_SLP_SER_NO	-- 30" ).append("\n"); 
		query.append("       , FCS.PAIR_SLP_SEQ_NO" ).append("\n"); 
		query.append("       , CASE WHEN FCS.PAIR_SLP_TP_CD IS NULL THEN ''" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("          (SELECT " ).append("\n"); 
		query.append("                  CASE WHEN FC.SLP_FUNC_CD = 'C' AND P.AP_SLP_TP_CD IS NOT NULL THEN 'RF'" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                            CASE WHEN FC.SLP_FUNC_CD = 'C' AND P.AP_SLP_TP_CD IS NULL THEN 'CN'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("            FROM  FMS_CSUL_SLP S," ).append("\n"); 
		query.append("                  FMS_CSUL_SLP P" ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("              AND S.PAIR_SLP_TP_CD = FCS.SLP_TP_CD" ).append("\n"); 
		query.append("              AND S.PAIR_SLP_FUNC_CD = FCS.SLP_FUNC_CD" ).append("\n"); 
		query.append("              AND S.PAIR_SLP_OFC_CD = FCS.SLP_OFC_CD" ).append("\n"); 
		query.append("              AND S.PAIR_SLP_ISS_DT = FCS.SLP_ISS_DT" ).append("\n"); 
		query.append("              AND S.PAIR_SLP_SER_NO = FCS.SLP_SER_NO" ).append("\n"); 
		query.append("              AND S.PAIR_SLP_SEQ_NO = FCS.SLP_SEQ_NO " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              AND S.SLP_TP_CD = P.AP_SLP_TP_CD(+)" ).append("\n"); 
		query.append("              AND S.SLP_FUNC_CD = P.AP_SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("              AND S.SLP_OFC_CD = P.AP_SLP_OFC_CD(+)" ).append("\n"); 
		query.append("              AND S.SLP_ISS_DT = P.AP_SLP_ISS_DT(+)" ).append("\n"); 
		query.append("              AND S.SLP_SER_NO = P.AP_SLP_SER_NO(+)" ).append("\n"); 
		query.append("              AND S.SLP_SEQ_NO = P.AP_SLP_SEQ_NO(+)" ).append("\n"); 
		query.append("            ) END OA_STL_STS_CD" ).append("\n"); 
		query.append("        , FCS.VNDR_SEQ" ).append("\n"); 
		query.append("  FROM FMS_CONSULTATION FC," ).append("\n"); 
		query.append("       FMS_CSUL_SLP FCS" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND FC.SLP_TP_CD = FCS.SLP_TP_CD" ).append("\n"); 
		query.append("   AND FC.SLP_FUNC_CD = FCS.SLP_FUNC_CD" ).append("\n"); 
		query.append("   AND FC.SLP_OFC_CD = FCS.SLP_OFC_CD" ).append("\n"); 
		query.append("   AND FC.SLP_ISS_DT = FCS.SLP_ISS_DT" ).append("\n"); 
		query.append("   AND FC.SLP_SER_NO = FCS.SLP_SER_NO" ).append("\n"); 
		query.append("   AND FCS.SLP_TP_CD||FCS.SLP_FUNC_CD||FCS.SLP_OFC_CD||FCS.SLP_ISS_DT||FCS.SLP_SER_NO||FCS.SLP_SEQ_NO = @[csr_no]" ).append("\n"); 

	}
}