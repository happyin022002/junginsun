/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomInterfaceStatusVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.08 
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

public class TCharterIOConsultationDBDAOCustomInterfaceStatusVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * A/P에서 취소 했을 경우 전표에 대한 취소 전표를 Master 생성한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomInterfaceStatusVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCustomInterfaceStatusVOCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_CONSULTATION (" ).append("\n"); 
		query.append("	SLP_TP_CD" ).append("\n"); 
		query.append(",	SLP_FUNC_CD" ).append("\n"); 
		query.append(",	SLP_OFC_CD" ).append("\n"); 
		query.append(",	SLP_ISS_DT" ).append("\n"); 
		query.append(",	SLP_SER_NO" ).append("\n"); 
		query.append(",	FLET_CTRT_NO" ).append("\n"); 
		query.append(",	CSR_CURR_CD" ).append("\n"); 
		query.append(",	CSR_AMT" ).append("\n"); 
		query.append(",	CSR_USR_ID" ).append("\n"); 
		query.append(",	CSR_DESC" ).append("\n"); 
		query.append(",	DIFF_AMT" ).append("\n"); 
		query.append(",	DIFF_DESC" ).append("\n"); 
		query.append(",	RQST_AMT" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EVID_TP_CD" ).append("\n"); 
		query.append(",	APRO_FLG" ).append("\n"); 
		query.append(",	APRO_DT" ).append("\n"); 
		query.append(",	CXL_FLG" ).append("\n"); 
		query.append(",	CXL_DESC" ).append("\n"); 
		query.append(",	MNL_TP_FLG" ).append("\n"); 
		query.append(",	VAT_SLP_TP_CD" ).append("\n"); 
		query.append(",	VAT_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	VAT_SLP_OFC_CD" ).append("\n"); 
		query.append(",	VAT_SLP_ISS_DT" ).append("\n"); 
		query.append(",	VAT_SLP_SER_NO" ).append("\n"); 
		query.append(",	PPAY_HIR_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[slp_tp_cd] SLP_TP_CD" ).append("\n"); 
		query.append(",	@[slp_func_cd] SLP_FUNC_CD" ).append("\n"); 
		query.append(",	@[slp_ofc_cd] SLP_OFC_CD" ).append("\n"); 
		query.append(",	@[slp_iss_dt] SLP_ISS_DT" ).append("\n"); 
		query.append(",	@[slp_ser_no] SLP_SER_NO" ).append("\n"); 
		query.append(",	FLET_CTRT_NO" ).append("\n"); 
		query.append(",	CSR_CURR_CD" ).append("\n"); 
		query.append(",	CSR_AMT*-1" ).append("\n"); 
		query.append(",	CSR_USR_ID" ).append("\n"); 
		query.append(",	CSR_DESC" ).append("\n"); 
		query.append(",	DIFF_AMT*-1" ).append("\n"); 
		query.append(",	DIFF_DESC" ).append("\n"); 
		query.append(",	RQST_AMT*-1" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append("#if (${org_slp_tp_cd} == '07')" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", (SELECT TO_CHAR(DECODE(A.CNT, 1, DECODE(SUBSTR(MAX_EFF, 1, 6), " ).append("\n"); 
		query.append("                                TO_CHAR(SYSDATE, 'YYYYMM'), SYSDATE, " ).append("\n"); 
		query.append("                                TO_DATE(MAX_EFF, 'YYYYMMDD')), TO_DATE(MIN_EFF, 'YYYYMMDD')), 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("    FROM (SELECT TO_CHAR(MIN(LAST_DAY(TO_DATE(EFF_YRMON, 'YYYYMM'))), 'YYYYMMDD') MIN_EFF," ).append("\n"); 
		query.append("                 TO_CHAR(MAX(TRUNC(TO_DATE(EFF_YRMON, 'YYYYMM'), 'MONTH')), 'YYYYMMDD') MAX_EFF," ).append("\n"); 
		query.append("                 COUNT(P.EFF_YRMON) CNT" ).append("\n"); 
		query.append("            FROM AP_PERIOD P" ).append("\n"); 
		query.append("           WHERE P.SYS_DIV_CD = '18'" ).append("\n"); 
		query.append("             AND P.AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("             AND P.CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("             AND OFC_CD = (SELECT S.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION S" ).append("\n"); 
		query.append("                   WHERE S.OFC_CD = @[slp_ofc_cd]))A) EFF_DT  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	EVID_TP_CD" ).append("\n"); 
		query.append("#if (${org_slp_tp_cd} == '07')" ).append("\n"); 
		query.append(",	'Y' APRO_FLG" ).append("\n"); 
		query.append(",	SYSDATE APRO_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'N' APRO_FLG" ).append("\n"); 
		query.append(",	'' APRO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	CXL_FLG" ).append("\n"); 
		query.append(",	CXL_DESC" ).append("\n"); 
		query.append(",	MNL_TP_FLG" ).append("\n"); 
		query.append(",	VAT_SLP_TP_CD" ).append("\n"); 
		query.append(",	VAT_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	VAT_SLP_OFC_CD" ).append("\n"); 
		query.append(",	VAT_SLP_ISS_DT" ).append("\n"); 
		query.append(",	VAT_SLP_SER_NO" ).append("\n"); 
		query.append(",	PPAY_HIR_NO" ).append("\n"); 
		query.append(",	@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION" ).append("\n"); 
		query.append("WHERE	SLP_TP_CD = @[org_slp_tp_cd]" ).append("\n"); 
		query.append("AND	SLP_FUNC_CD = @[org_slp_func_cd]" ).append("\n"); 
		query.append("AND	SLP_OFC_CD = @[org_slp_ofc_cd]" ).append("\n"); 
		query.append("AND	SLP_ISS_DT = @[org_slp_iss_dt]" ).append("\n"); 
		query.append("AND	SLP_SER_NO = @[org_slp_ser_no]" ).append("\n"); 

	}
}