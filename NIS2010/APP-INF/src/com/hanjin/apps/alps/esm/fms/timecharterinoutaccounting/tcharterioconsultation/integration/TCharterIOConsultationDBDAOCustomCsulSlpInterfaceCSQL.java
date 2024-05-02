/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomCsulSlpInterfaceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.04 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOCustomCsulSlpInterfaceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * A/P에서 취소 했을 경우 전표에 대한 취소 전표를 Slip 생성한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomCsulSlpInterfaceCSQL(){
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
		params.put("org_slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TCharterIOConsultationDBDAOCustomCsulSlpInterfaceCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_CSUL_SLP (" ).append("\n"); 
		query.append("SLP_TP_CD" ).append("\n"); 
		query.append(",	SLP_FUNC_CD" ).append("\n"); 
		query.append(",	SLP_OFC_CD" ).append("\n"); 
		query.append(",	SLP_ISS_DT" ).append("\n"); 
		query.append(",	SLP_SER_NO" ).append("\n"); 
		query.append(",	SLP_SEQ_NO" ).append("\n"); 
		query.append(",	ACCT_CD" ).append("\n"); 
		query.append(",	CTR_CD" ).append("\n"); 
		query.append(",	SLP_LOC_CD" ).append("\n"); 
		query.append(",	CSR_CURR_CD" ).append("\n"); 
		query.append(",	CSR_AMT" ).append("\n"); 
		query.append(",	CSR_DESC" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	TRNS_CURR_CD" ).append("\n"); 
		query.append(",	TRNS_AMT" ).append("\n"); 
		query.append(",	VAT_FLG" ).append("\n"); 
		query.append(",	STL_FLG" ).append("\n"); 
		query.append(",	INV_SEQ" ).append("\n"); 
		query.append(",	FLET_SRC_TP_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	ORG_SLP_TP_CD" ).append("\n"); 
		query.append(",	ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	ORG_SLP_OFC_CD" ).append("\n"); 
		query.append(",	ORG_ISS_DT" ).append("\n"); 
		query.append(",	ORG_SLP_SER_NO" ).append("\n"); 
		query.append(",	ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append(",	LSG_GR_NO" ).append("\n"); 
		query.append(",	TO_INV_NO" ).append("\n"); 
		query.append(",	AP_SLP_TP_CD" ).append("\n"); 
		query.append(",	AP_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	AP_SLP_OFC_CD" ).append("\n"); 
		query.append(",	AP_SLP_ISS_DT" ).append("\n"); 
		query.append(",	AP_SLP_SER_NO" ).append("\n"); 
		query.append(",	AP_SLP_SEQ_NO" ).append("\n"); 
		query.append(",	SLP_KEY_NO" ).append("\n"); 
		query.append(",	VVD_EFF_DT" ).append("\n"); 
		query.append(",	VVD_EXP_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[slp_tp_cd] SLP_TP_CD" ).append("\n"); 
		query.append(",	@[slp_func_cd] SLP_FUNC_CD" ).append("\n"); 
		query.append(",	@[slp_ofc_cd] SLP_OFC_CD" ).append("\n"); 
		query.append(",	@[slp_iss_dt] SLP_ISS_DT" ).append("\n"); 
		query.append(",	@[slp_ser_no] SLP_SER_NO" ).append("\n"); 
		query.append(",	(SELECT LPAD(NVL(TO_NUMBER(MAX(SLP_SEQ_NO)),0)+1,4,'0')" ).append("\n"); 
		query.append("FROM 	FMS_CSUL_SLP" ).append("\n"); 
		query.append("WHERE	SLP_TP_CD	= @[slp_tp_cd]" ).append("\n"); 
		query.append("AND	SLP_FUNC_CD = @[slp_func_cd]" ).append("\n"); 
		query.append("AND	SLP_OFC_CD  = @[slp_ofc_cd]" ).append("\n"); 
		query.append("AND	SLP_ISS_DT  = @[slp_iss_dt]" ).append("\n"); 
		query.append("AND	SLP_SER_NO  = @[slp_ser_no]) SLP_SEQ_NO" ).append("\n"); 
		query.append(",	ACCT_CD" ).append("\n"); 
		query.append(",	CTR_CD" ).append("\n"); 
		query.append(",	SLP_LOC_CD" ).append("\n"); 
		query.append(",	CSR_CURR_CD" ).append("\n"); 
		query.append(",	CSR_AMT*-1" ).append("\n"); 
		query.append(",	CSR_DESC" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	TRNS_CURR_CD" ).append("\n"); 
		query.append(",	TRNS_AMT*-1" ).append("\n"); 
		query.append(",	VAT_FLG" ).append("\n"); 
		query.append(",	STL_FLG" ).append("\n"); 
		query.append(",	INV_SEQ" ).append("\n"); 
		query.append(",	FLET_SRC_TP_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	@[org_slp_tp_cd] ORG_SLP_TP_CD" ).append("\n"); 
		query.append(",	@[org_slp_func_cd] ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	@[org_slp_ofc_cd] ORG_SLP_OFC_CD" ).append("\n"); 
		query.append(",	@[org_slp_iss_dt] ORG_ISS_DT" ).append("\n"); 
		query.append(",	@[org_slp_ser_no] ORG_SLP_SER_NO" ).append("\n"); 
		query.append(",	@[org_slp_seq_no] ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append(",	LSG_GR_NO" ).append("\n"); 
		query.append(",	TO_INV_NO" ).append("\n"); 
		query.append(",	AP_SLP_TP_CD" ).append("\n"); 
		query.append(",	AP_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	AP_SLP_OFC_CD" ).append("\n"); 
		query.append(",	AP_SLP_ISS_DT" ).append("\n"); 
		query.append(",	AP_SLP_SER_NO" ).append("\n"); 
		query.append(",	AP_SLP_SEQ_NO" ).append("\n"); 
		query.append(",	SLP_KEY_NO" ).append("\n"); 
		query.append(",	VVD_EFF_DT" ).append("\n"); 
		query.append(",	VVD_EXP_DT" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM FMS_CSUL_SLP" ).append("\n"); 
		query.append("WHERE	SLP_TP_CD = @[org_slp_tp_cd]" ).append("\n"); 
		query.append("AND	SLP_FUNC_CD = @[org_slp_func_cd]" ).append("\n"); 
		query.append("AND	SLP_OFC_CD = @[org_slp_ofc_cd]" ).append("\n"); 
		query.append("AND	SLP_ISS_DT = @[org_slp_iss_dt]" ).append("\n"); 
		query.append("AND	SLP_SER_NO = @[org_slp_ser_no]" ).append("\n"); 
		query.append("AND	SLP_SEQ_NO = @[org_slp_seq_no]" ).append("\n"); 

	}
}