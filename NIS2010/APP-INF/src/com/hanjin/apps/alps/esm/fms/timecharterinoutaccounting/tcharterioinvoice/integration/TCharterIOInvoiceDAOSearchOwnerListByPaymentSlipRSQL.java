/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOwnerListByPaymentSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.14 
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

public class TCharterIOInvoiceDAOSearchOwnerListByPaymentSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchOwnerListByPaymentSlipRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOwnerListByPaymentSlipRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOwnerListByPaymentSlipRSQL").append("\n"); 
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
		query.append("SELECT ACCT_NM," ).append("\n"); 
		query.append("ACCT_CD," ).append("\n"); 
		query.append("VVD_BUNKER," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("N1ST_AMT," ).append("\n"); 
		query.append("LOC_CURR_CD," ).append("\n"); 
		query.append("LOC_AMT," ).append("\n"); 
		query.append("DECODE(MANHOUR_CH,NULL,0,TO_CHAR(MANHOUR_CH,'FM999,999,999,999,999,990.00')) MANHOUR_CH," ).append("\n"); 
		query.append("AP_DESC," ).append("\n"); 
		query.append("CTR_CD," ).append("\n"); 
		query.append("SLP_LOC_CD," ).append("\n"); 
		query.append("DECODE(FLET_OLAY_COMM_RT_AMT,NULL,0,TO_CHAR(FLET_OLAY_COMM_RT_AMT,'FM999,999,999,990.00')) FLET_OLAY_COMM_RT_AMT," ).append("\n"); 
		query.append("FLET_SRC_TP_CD," ).append("\n"); 
		query.append("SLP_TP_CD," ).append("\n"); 
		query.append("SLP_FUNC_CD," ).append("\n"); 
		query.append("SLP_OFC_CD," ).append("\n"); 
		query.append("SLP_ISS_DT," ).append("\n"); 
		query.append("SLP_SER_NO," ).append("\n"); 
		query.append("SLP_SEQ_NO," ).append("\n"); 
		query.append("VVD_YN," ).append("\n"); 
		query.append("ORG_SLP_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("WHERE ACCT_CD = FO.ACCT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) ACCT_NM," ).append("\n"); 
		query.append("FO.ACCT_CD," ).append("\n"); 
		query.append("FO.N1ST_CURR_CD CURR_CD," ).append("\n"); 
		query.append("TO_CHAR(FO.N1ST_AMT,'FM999,999,999,999,999,990.00') N1ST_AMT," ).append("\n"); 
		query.append("FO.N2ND_CURR_CD LOC_CURR_CD," ).append("\n"); 
		query.append("TO_CHAR(FO.N2ND_AMT,'FM999,999,999,999,999,990.00') LOC_AMT," ).append("\n"); 
		query.append("CASE WHEN FO.MAN_HR_FLG = 'Y' THEN" ).append("\n"); 
		query.append("(SELECT NVL(SUM(FM.MGR_WRK_AMT),0) + NVL(SUM(FM.MBR_WRK_AMT),0) + NVL(SUM(FM.AGN_WRK_AMT),0)" ).append("\n"); 
		query.append("FROM FMS_MAN_HR_CHG FM" ).append("\n"); 
		query.append("WHERE FO.SLP_TP_CD = FM.SLP_TP_CD" ).append("\n"); 
		query.append("AND FO.SLP_FUNC_CD = FM.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND FO.SLP_OFC_CD = FM.SLP_OFC_CD" ).append("\n"); 
		query.append("AND FO.SLP_ISS_DT = FM.SLP_ISS_DT" ).append("\n"); 
		query.append("AND FO.SLP_SER_NO = FM.SLP_SER_NO" ).append("\n"); 
		query.append("AND FO.SLP_SEQ_NO = FM.SLP_SEQ_NO)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append("END MANHOUR_CH," ).append("\n"); 
		query.append("FO.AP_DESC," ).append("\n"); 
		query.append("(SELECT AP_CTR_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1) CTR_CD," ).append("\n"); 
		query.append("(SELECT LOC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1) SLP_LOC_CD," ).append("\n"); 
		query.append("'04' FLET_SRC_TP_CD," ).append("\n"); 
		query.append("FO.VSL_CD || FO.SKD_VOY_NO || FO.SKD_DIR_CD || FO.REV_DIR_CD VVD_BUNKER," ).append("\n"); 
		query.append("(SELECT FC.FLET_OLAY_COMM_RT_AMT" ).append("\n"); 
		query.append("FROM FMS_CONTRACT  FC" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = @[flet_ctrt_no]) FLET_OLAY_COMM_RT_AMT," ).append("\n"); 
		query.append("FO.SLP_TP_CD," ).append("\n"); 
		query.append("FO.SLP_FUNC_CD," ).append("\n"); 
		query.append("FO.SLP_OFC_CD," ).append("\n"); 
		query.append("FO.SLP_ISS_DT," ).append("\n"); 
		query.append("FO.SLP_SER_NO," ).append("\n"); 
		query.append("FO.SLP_SEQ_NO," ).append("\n"); 
		query.append("(SELECT DECODE(VSL_CD,NULL,'N','Y')" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("WHERE    VSL_CD" ).append("\n"); 
		query.append("|| SKD_VOY_NO" ).append("\n"); 
		query.append("|| SKD_DIR_CD" ).append("\n"); 
		query.append("|| RLANE_DIR_CD =    FO.VSL_CD" ).append("\n"); 
		query.append("|| FO.SKD_VOY_NO" ).append("\n"); 
		query.append("|| FO.SKD_DIR_CD" ).append("\n"); 
		query.append("|| FO.REV_DIR_CD" ).append("\n"); 
		query.append("AND (   DELT_FLG = 'N'" ).append("\n"); 
		query.append("OR DELT_FLG IS NULL)) VVD_YN," ).append("\n"); 
		query.append("SLP_TP_CD || SLP_FUNC_CD || SLP_OFC_CD || SLP_ISS_DT || SLP_SER_NO || SLP_SEQ_NO ORG_SLP_NO" ).append("\n"); 
		query.append("FROM FMS_OWNR_ACCT_SLP FO" ).append("\n"); 
		query.append("WHERE FO.ACCT_CD = '111071'" ).append("\n"); 
		query.append("AND FO.FLET_PPAY_RLT_CD = 'O'" ).append("\n"); 
		query.append("AND FO.CSR_SLP_FLG = 'N'" ).append("\n"); 
		query.append("AND FO.N1ST_CURR_CD = @[csr_curr_cd]" ).append("\n"); 
		query.append("AND FO.VSL_CD IN (SELECT VSL_CD" ).append("\n"); 
		query.append("FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("FROM FMS_ID_VSL" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND USE_FLG = 'Y')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}