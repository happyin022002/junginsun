/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsReverseCsrForSubletListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.23 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOFmsReverseCsrForSubletListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reverse CSR for Sublet Select
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsReverseCsrForSubletListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOFmsReverseCsrForSubletListRSQL").append("\n"); 
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
		query.append("SELECT BB.ACCT_CD," ).append("\n"); 
		query.append("BB.CUST_CNT_CD," ).append("\n"); 
		query.append("BB.CUST_SEQ," ).append("\n"); 
		query.append("(SELECT MAX(AR_CTR_CD) FROM MDM_ORGANIZATION WHERE OFC_CD = @[slp_ofc_cd]) CTR_CD," ).append("\n"); 
		query.append("(SELECT MAX(LOC_CD) FROM MDM_ORGANIZATION WHERE OFC_CD = @[slp_ofc_cd]) SLP_LOC_CD," ).append("\n"); 
		query.append("@[eff_dt] EFF_DT," ).append("\n"); 
		query.append("'' CSR_AMT," ).append("\n"); 
		query.append("(SELECT SUM(B.CSR_AMT)" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND A.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.ACCT_CD = '110811'" ).append("\n"); 
		query.append("AND B.TO_INV_NO = BB.TO_INV_NO) REV_AMT," ).append("\n"); 
		query.append("('Reverse Slip of ' || BB.CSR_DESC) CSR_DESC," ).append("\n"); 
		query.append("('Reverse Slip of ' || BB.CSR_DESC) CSR_DESC1," ).append("\n"); 
		query.append("('Reverse Slip of ' || BB.CSR_DESC) CSR_DESC2," ).append("\n"); 
		query.append("('Reverse Slip of ' || BB.CSR_DESC) CSR_DESC3," ).append("\n"); 
		query.append("('Reverse Slip of ' || BB.CSR_DESC) CSR_DESC4," ).append("\n"); 
		query.append("(BB.VSL_CD || BB.SKD_VOY_NO || BB.SKD_DIR_CD || BB.REV_DIR_CD) VVD_CD," ).append("\n"); 
		query.append("BB.TO_INV_NO," ).append("\n"); 
		query.append("BB.TO_INV_NO TO_INV_NO1," ).append("\n"); 
		query.append("AA.SLP_TP_CD," ).append("\n"); 
		query.append("AA.SLP_FUNC_CD," ).append("\n"); 
		query.append("AA.SLP_OFC_CD," ).append("\n"); 
		query.append("AA.SLP_ISS_DT," ).append("\n"); 
		query.append("AA.CSR_CURR_CD," ).append("\n"); 
		query.append("BB.INV_SEQ," ).append("\n"); 
		query.append("TO_CHAR(BB.VVD_EFF_DT,'YYYYMMDD') VVD_EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(BB.VVD_EXP_DT,'YYYYMMDD') VVD_EXP_DT," ).append("\n"); 
		query.append("BB.FLET_SRC_TP_CD," ).append("\n"); 
		query.append("AA.SLP_TP_CD ORG_SLP_TP_CD," ).append("\n"); 
		query.append("AA.SLP_FUNC_CD ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("AA.SLP_OFC_CD ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("AA.SLP_ISS_DT ORG_ISS_DT," ).append("\n"); 
		query.append("AA.SLP_SER_NO ORG_SLP_SER_NO," ).append("\n"); 
		query.append("AA.FLET_CTRT_NO," ).append("\n"); 
		query.append("'' CSR_NO" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION AA," ).append("\n"); 
		query.append("FMS_CSUL_SLP BB" ).append("\n"); 
		query.append("WHERE AA.SLP_TP_CD = BB.SLP_TP_CD" ).append("\n"); 
		query.append("AND AA.SLP_FUNC_CD = BB.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND AA.SLP_OFC_CD = BB.SLP_OFC_CD" ).append("\n"); 
		query.append("AND AA.SLP_ISS_DT = BB.SLP_ISS_DT" ).append("\n"); 
		query.append("AND AA.SLP_SER_NO = BB.SLP_SER_NO" ).append("\n"); 
		query.append("AND AA.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND AA.SLP_TP_CD = '20'" ).append("\n"); 
		query.append("AND AA.SLP_FUNC_CD = 'T'" ).append("\n"); 
		query.append("AND AA.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND AA.CSR_CURR_CD = @[csr_curr_cd]" ).append("\n"); 
		query.append("AND AA.FLET_CTRT_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${to_inv_no} != '')" ).append("\n"); 
		query.append("AND BB.TO_INV_NO = @[to_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND BB.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND BB.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND BB.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND BB.REV_DIR_CD = SUBSTR(@[vvd_cd],10,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BB.ACCT_CD = '110811'" ).append("\n"); 
		query.append("AND BB.ORG_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("ORDER BY BB.TO_INV_NO" ).append("\n"); 

	}
}