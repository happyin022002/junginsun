/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsReverseCsrForSubletSaveListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.19 최우석
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

public class TCharterIOConsultationDBDAOFmsReverseCsrForSubletSaveListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reverse CSR for Sublet Select after Save
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsReverseCsrForSubletSaveListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOFmsReverseCsrForSubletSaveListRSQL").append("\n"); 
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
		query.append("BB.CTR_CD," ).append("\n"); 
		query.append("BB.SLP_LOC_CD," ).append("\n"); 
		query.append("AA.EFF_DT," ).append("\n"); 
		query.append("BB.CSR_AMT," ).append("\n"); 
		query.append("(SELECT SUM(B.CSR_AMT)" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND B.ACCT_CD = '110811'" ).append("\n"); 
		query.append("AND B.TO_INV_NO = BB.TO_INV_NO) REV_AMT," ).append("\n"); 
		query.append("BB.CSR_DESC," ).append("\n"); 
		query.append("BB.CSR_DESC CSR_DESC1," ).append("\n"); 
		query.append("BB.CSR_DESC CSR_DESC2," ).append("\n"); 
		query.append("BB.CSR_DESC CSR_DESC3," ).append("\n"); 
		query.append("BB.CSR_DESC CSR_DESC4," ).append("\n"); 
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
		query.append("(AA.SLP_TP_CD || AA.SLP_FUNC_CD || AA.SLP_OFC_CD || AA.SLP_ISS_DT || AA.SLP_SER_NO) CSR_NO" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION AA," ).append("\n"); 
		query.append("FMS_CSUL_SLP BB" ).append("\n"); 
		query.append("WHERE AA.SLP_TP_CD = BB.SLP_TP_CD" ).append("\n"); 
		query.append("AND AA.SLP_FUNC_CD = BB.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND AA.SLP_OFC_CD = BB.SLP_OFC_CD" ).append("\n"); 
		query.append("AND AA.SLP_ISS_DT = BB.SLP_ISS_DT" ).append("\n"); 
		query.append("AND AA.SLP_SER_NO = BB.SLP_SER_NO" ).append("\n"); 
		query.append("AND AA.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND AA.SLP_TP_CD = @[slp_tp_cd]" ).append("\n"); 
		query.append("AND AA.SLP_FUNC_CD = @[slp_func_cd]" ).append("\n"); 
		query.append("AND AA.SLP_OFC_CD = @[slp_ofc_cd]" ).append("\n"); 
		query.append("AND AA.SLP_ISS_DT = SUBSTR(@[slp_iss_dt],3,6)" ).append("\n"); 
		query.append("AND AA.SLP_SER_NO =@[slp_ser_no]" ).append("\n"); 
		query.append("AND BB.ACCT_CD = '110811'" ).append("\n"); 
		query.append("ORDER BY BB.TO_INV_NO" ).append("\n"); 

	}
}