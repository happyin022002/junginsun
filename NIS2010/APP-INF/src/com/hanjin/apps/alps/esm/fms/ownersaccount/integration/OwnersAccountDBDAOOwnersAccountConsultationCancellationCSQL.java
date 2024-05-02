/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnersAccountConsultationCancellationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.14 
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

public class OwnersAccountDBDAOOwnersAccountConsultationCancellationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Owner's Account Cancellation메인 전표 저장   
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnersAccountConsultationCancellationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("oa_inter_mm_desc",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnersAccountConsultationCancellationCSQL").append("\n"); 
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
		query.append(",	SLP_SER_NO	-- 5" ).append("\n"); 
		query.append(",	CSR_CURR_CD" ).append("\n"); 
		query.append(",	CSR_AMT" ).append("\n"); 
		query.append(",	CSR_USR_ID" ).append("\n"); 
		query.append(",	CSR_DESC" ).append("\n"); 
		query.append(",   DIFF_AMT	-- 10" ).append("\n"); 
		query.append(",   RQST_AMT" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EVID_TP_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID	-- 15" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	OA_INTER_MM_DESC" ).append("\n"); 
		query.append(",	OA_INV_DT	-- 20" ).append("\n"); 
		query.append(",   OA_IF_FLG" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[slp_tp_cd]" ).append("\n"); 
		query.append(",	@[slp_func_cd]" ).append("\n"); 
		query.append(",	@[slp_ofc_cd]" ).append("\n"); 
		query.append(",	@[slp_iss_dt]" ).append("\n"); 
		query.append(",	@[slp_ser_no]	-- 5" ).append("\n"); 
		query.append(",	@[csr_curr_cd]" ).append("\n"); 
		query.append(",	@[csr_amt]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	@[csr_desc]" ).append("\n"); 
		query.append(",	0	-- 10" ).append("\n"); 
		query.append(",	@[csr_amt]" ).append("\n"); 
		query.append(",	(SELECT TO_CHAR(SYSDATE + (SELECT DECODE(SUBSTR(GEN_PAY_TERM_CD, 1, 1), 'O', 0, GEN_PAY_TERM_CD) GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("                                 FROM MDM_VENDOR" ).append("\n"); 
		query.append("                           		WHERE VNDR_SEQ = @[vndr_seq]) , 'YYYYMMDD')" ).append("\n"); 
		query.append("  	   FROM DUAL)" ).append("\n"); 
		query.append(",	(SELECT TO_CHAR(DECODE(A.CNT, 1, MAX_EFF, MIN_EFF), 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("  	   FROM (SELECT MIN(LAST_DAY(TO_DATE(EFF_YRMON, 'YYYYMM'))) MIN_EFF," ).append("\n"); 
		query.append("               MAX(TRUNC(TO_DATE(EFF_YRMON, 'YYYYMM'), 'MONTH')) MAX_EFF," ).append("\n"); 
		query.append("               COUNT(P.EFF_YRMON) CNT" ).append("\n"); 
		query.append("          	   FROM AP_PERIOD P" ).append("\n"); 
		query.append("         	  WHERE P.SYS_DIV_CD = '17'" ).append("\n"); 
		query.append("           		AND P.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("           		AND P.CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("           		AND OFC_CD = (SELECT S.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  				FROM MDM_ORGANIZATION S" ).append("\n"); 
		query.append("                 			   WHERE S.OFC_CD = @[slp_ofc_cd]) ) A" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(",	'5'" ).append("\n"); 
		query.append(",	@[cre_usr_id]	-- 15" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[oa_inter_mm_desc]" ).append("\n"); 
		query.append(",	(SELECT TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("  	   FROM DUAL)	-- 20" ).append("\n"); 
		query.append(",   'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}