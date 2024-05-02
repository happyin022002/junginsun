/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPCLCmpnAgreementDBDAOSearchSCompAgreementDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.01.07 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnAgreementDBDAOSearchSCompAgreementDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSCompAgreementDup
	  * </pre>
	  */
	public SPCLCmpnAgreementDBDAOSearchSCompAgreementDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.integration").append("\n"); 
		query.append("FileName : SPCLCmpnAgreementDBDAOSearchSCompAgreementDupRSQL").append("\n"); 
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
		query.append("SELECT SPCL_OFC_CD ," ).append("\n"); 
		query.append("  CUST_CNT_CD ," ).append("\n"); 
		query.append("  CUST_SEQ ," ).append("\n"); 
		query.append("  CUST_CNT_SEQ ," ).append("\n"); 
		query.append("  SPCL_CNT_CUST_NM ," ).append("\n"); 
		query.append("  SPCL_AGMT_SEQ ," ).append("\n"); 
		query.append("  CUST_KND_CD ," ).append("\n"); 
		query.append("  SC_NO ," ).append("\n"); 
		query.append("  RFA_NO ," ).append("\n"); 
		query.append("  SHPR_CNT_SEQ ," ).append("\n"); 
		query.append("  SHPR_CNT_NM ," ).append("\n"); 
		query.append("  FM_EFF_DT ," ).append("\n"); 
		query.append("  TO_EFF_DT ," ).append("\n"); 
		query.append("  CMDT_TP_CD ," ).append("\n"); 
		query.append("  CMDT_CD ," ).append("\n"); 
		query.append("  CMDT_NM ," ).append("\n"); 
		query.append("  POR_GRP_TP_CD ," ).append("\n"); 
		query.append("  POR_ROUT_CD ," ).append("\n"); 
		query.append("  POL_GRP_TP_CD ," ).append("\n"); 
		query.append("  POL_ROUT_CD ," ).append("\n"); 
		query.append("  POD_GRP_TP_CD ," ).append("\n"); 
		query.append("  POD_ROUT_CD ," ).append("\n"); 
		query.append("  SPCL_DIV_CD ," ).append("\n"); 
		query.append("  SPCL_BKG_RT ," ).append("\n"); 
		query.append("  SPCL_BX_AMT ," ).append("\n"); 
		query.append("  SPCL_TEU_AMT ," ).append("\n"); 
		query.append("  SPCL_FEU_AMT ," ).append("\n"); 
		query.append("  SPCL_RF_AMT ," ).append("\n"); 
		query.append("  SPCL_RF_TEU_AMT ," ).append("\n"); 
		query.append("  SPCL_RF_FEU_AMT ," ).append("\n"); 
		query.append("  SPCL_CHG_CTNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.SPCL_OFC_CD," ).append("\n"); 
		query.append("      A.CUST_CNT_CD," ).append("\n"); 
		query.append("      A.CUST_SEQ," ).append("\n"); 
		query.append("      A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ, 'FM000000') AS CUST_CNT_SEQ," ).append("\n"); 
		query.append("          CASE TO_CHAR(A.CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append("            WHEN '999999' THEN 'All customer for General Rate Case'" ).append("\n"); 
		query.append("            WHEN '888888' THEN 'All customer for Special Rate Case'" ).append("\n"); 
		query.append("            WHEN '777777' THEN 'All customer for Canadian Special Rate Case'" ).append("\n"); 
		query.append("            ELSE NVL(REPLACE(REPLACE(B.CUST_LGL_ENG_NM, CHR(13)||CHR(10), ' '), CHR(9), ' '), ' ')" ).append("\n"); 
		query.append("          END AS SPCL_CNT_CUST_NM," ).append("\n"); 
		query.append("      A.SPCL_AGMT_SEQ," ).append("\n"); 
		query.append("      NVL(A.CUST_KND_CD, 'F') AS CUST_KND_CD," ).append("\n"); 
		query.append("      NVL(A.SC_NO, '*') AS SC_NO," ).append("\n"); 
		query.append("      NVL(A.RFA_NO, '*') AS RFA_NO," ).append("\n"); 
		query.append("          CASE A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000')" ).append("\n"); 
		query.append("            WHEN '*000000' THEN '*'" ).append("\n"); 
		query.append("            ELSE NVL(A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000'), '*')" ).append("\n"); 
		query.append("          END AS SHPR_CNT_SEQ," ).append("\n"); 
		query.append("      NVL(REPLACE(REPLACE(C.CUST_LGL_ENG_NM, CHR(13)||CHR(10), ' '), CHR(9), ' '), ' ') AS SHPR_CNT_NM," ).append("\n"); 
		query.append("      NVL(A.FM_EFF_DT, '20000101') AS FM_EFF_DT," ).append("\n"); 
		query.append("      NVL(A.TO_EFF_DT, '29991231') AS TO_EFF_DT," ).append("\n"); 
		query.append("      NVL(A.CMDT_TP_CD, '*') AS CMDT_TP_CD," ).append("\n"); 
		query.append("      NVL(A.CMDT_CD, '*') AS CMDT_CD," ).append("\n"); 
		query.append("          CASE A.CMDT_TP_CD" ).append("\n"); 
		query.append("            WHEN '2' THEN E.REP_CMDT_NM" ).append("\n"); 
		query.append("            WHEN '3' THEN F.CMDT_NM" ).append("\n"); 
		query.append("          END AS CMDT_NM," ).append("\n"); 
		query.append("      NVL(A.POR_GRP_TP_CD, '*') AS POR_GRP_TP_CD," ).append("\n"); 
		query.append("      NVL(A.POR_ROUT_CD, '*') AS POR_ROUT_CD," ).append("\n"); 
		query.append("      NVL(A.POL_GRP_TP_CD, '*') AS POL_GRP_TP_CD," ).append("\n"); 
		query.append("      NVL(A.POL_ROUT_CD, '*') AS POL_ROUT_CD," ).append("\n"); 
		query.append("      NVL(A.POD_GRP_TP_CD, '*') AS POD_GRP_TP_CD," ).append("\n"); 
		query.append("      NVL(A.POD_ROUT_CD, '*') AS POD_ROUT_CD," ).append("\n"); 
		query.append("      NVL(A.SPCL_DIV_CD, ' ') AS SPCL_DIV_CD," ).append("\n"); 
		query.append("      NVL(A.SPCL_BKG_RT, 0) AS SPCL_BKG_RT," ).append("\n"); 
		query.append("      NVL(A.SPCL_BX_AMT, 0) AS SPCL_BX_AMT," ).append("\n"); 
		query.append("      NVL(A.SPCL_TEU_AMT, 0) AS SPCL_TEU_AMT," ).append("\n"); 
		query.append("      NVL(A.SPCL_FEU_AMT, 0) AS SPCL_FEU_AMT," ).append("\n"); 
		query.append("      NVL(A.SPCL_RF_AMT, 0) AS SPCL_RF_AMT," ).append("\n"); 
		query.append("      NVL(A.SPCL_RF_TEU_AMT, 0) AS SPCL_RF_TEU_AMT," ).append("\n"); 
		query.append("      NVL(A.SPCL_RF_FEU_AMT, 0) AS SPCL_RF_FEU_AMT," ).append("\n"); 
		query.append("      NVL(A.SPCL_CHG_CTNT, ' ') AS SPCL_CHG_CTNT" ).append("\n"); 
		query.append("    FROM ACM_SPCL_AGMT A," ).append("\n"); 
		query.append("      MDM_CUSTOMER B," ).append("\n"); 
		query.append("      MDM_CUSTOMER C," ).append("\n"); 
		query.append("      MDM_REP_CMDT E," ).append("\n"); 
		query.append("      MDM_COMMODITY F" ).append("\n"); 
		query.append("    WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("      AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("      AND A.SHPR_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("      AND A.SHPR_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("      AND A.CMDT_CD = E.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("      AND A.CMDT_CD = F.CMDT_CD(+)" ).append("\n"); 
		query.append("      AND A.SPCL_OFC_CD = @[spcl_ofc_cd] " ).append("\n"); 
		query.append("      #if (${cust_cnt_seq} != '')" ).append("\n"); 
		query.append("        AND A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ, 'FM000000') LIKE @[cust_cnt_seq]||'%' " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      #if (${delt_flg} != 'Y')" ).append("\n"); 
		query.append("        AND A.DELT_FLG <> 'Y' " ).append("\n"); 
		query.append("      #end )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND SPCL_OFC_CD = @[spcl_ofc_cd]" ).append("\n"); 
		query.append("  AND CUST_KND_CD = @[cust_knd_cd]" ).append("\n"); 
		query.append("#if (${cust_cnt_seq} != '')" ).append("\n"); 
		query.append("  AND CUST_CNT_SEQ = @[cust_cnt_seq]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  AND SHPR_CNT_SEQ = @[shpr_cnt_seq]" ).append("\n"); 
		query.append("  AND POR_GRP_TP_CD = @[por_grp_tp_cd]" ).append("\n"); 
		query.append("  AND POR_ROUT_CD = @[por_rout_cd]" ).append("\n"); 
		query.append("  AND POL_GRP_TP_CD = @[pol_grp_tp_cd]" ).append("\n"); 
		query.append("  AND POL_ROUT_CD = @[pol_rout_cd]" ).append("\n"); 
		query.append("  AND POD_GRP_TP_CD = @[pod_grp_tp_cd]" ).append("\n"); 
		query.append("  AND POD_ROUT_CD = @[pod_rout_cd]" ).append("\n"); 
		query.append("  AND FM_EFF_DT = @[fm_eff_dt]" ).append("\n"); 
		query.append("  AND TO_EFF_DT = @[to_eff_dt]" ).append("\n"); 
		query.append("  AND SC_NO = @[sc_no]" ).append("\n"); 
		query.append("  AND RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("  AND CMDT_TP_CD = @[cmdt_tp_cd]" ).append("\n"); 
		query.append("  AND CMDT_CD = @[cmdt_cd]" ).append("\n"); 

	}
}