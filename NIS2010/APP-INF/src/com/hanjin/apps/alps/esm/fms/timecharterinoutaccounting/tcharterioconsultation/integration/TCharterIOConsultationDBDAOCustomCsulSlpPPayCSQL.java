/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomCsulSlpPPayCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.24 윤세영
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

public class TCharterIOConsultationDBDAOCustomCsulSlpPPayCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기 지급한 선급금을 실제 비용 계정으로 정리하여 전표를 생성한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomCsulSlpPPayCSQL(){
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
		params.put("csr_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lsg_gr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCustomCsulSlpPPayCSQL").append("\n"); 
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
		query.append(",	TRNS_CURR_CD" ).append("\n"); 
		query.append(",	TRNS_AMT" ).append("\n"); 
		query.append(",	STL_FLG" ).append("\n"); 
		query.append(",	INV_SEQ" ).append("\n"); 
		query.append(",   FLET_SRC_TP_CD" ).append("\n"); 
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
		query.append(",	VVD_EFF_DT" ).append("\n"); 
		query.append(",	VVD_EXP_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") SELECT" ).append("\n"); 
		query.append("@[slp_tp_cd]" ).append("\n"); 
		query.append(",	@[slp_func_cd]" ).append("\n"); 
		query.append(",	@[slp_ofc_cd]" ).append("\n"); 
		query.append(",	SUBSTR(@[slp_iss_dt],3)" ).append("\n"); 
		query.append(",	@[slp_ser_no]" ).append("\n"); 
		query.append(",	(SELECT LPAD(NVL(TO_NUMBER(MAX(SLP_SEQ_NO)),0)+1,4,'0')" ).append("\n"); 
		query.append("FROM 	FMS_CSUL_SLP" ).append("\n"); 
		query.append("WHERE	SLP_TP_CD	= @[slp_tp_cd]" ).append("\n"); 
		query.append("AND	SLP_FUNC_CD = @[slp_func_cd]" ).append("\n"); 
		query.append("AND	SLP_OFC_CD  = @[slp_ofc_cd]" ).append("\n"); 
		query.append("AND	SLP_ISS_DT  = SUBSTR(@[slp_iss_dt],3)" ).append("\n"); 
		query.append("AND	SLP_SER_NO  = @[slp_ser_no])" ).append("\n"); 
		query.append(",	@[acct_cd]" ).append("\n"); 
		query.append(",	@[ctr_cd]" ).append("\n"); 
		query.append(",	@[slp_loc_cd]" ).append("\n"); 
		query.append(",	@[csr_curr_cd]" ).append("\n"); 
		query.append(",	@[csr_amt]" ).append("\n"); 
		query.append(",	@[csr_desc]" ).append("\n"); 
		query.append(",	@[vndr_seq]" ).append("\n"); 
		query.append(",	'USD'" ).append("\n"); 
		query.append(",	@[trns_amt]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	@[inv_seq]" ).append("\n"); 
		query.append(",   '30'" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],10,1)" ).append("\n"); 
		query.append(",	@[org_slp_tp_cd]" ).append("\n"); 
		query.append(",	@[org_slp_func_cd]" ).append("\n"); 
		query.append(",	@[org_slp_ofc_cd]" ).append("\n"); 
		query.append(",	@[org_slp_iss_dt]" ).append("\n"); 
		query.append(",	@[org_slp_ser_no]" ).append("\n"); 
		query.append(",	@[org_slp_seq_no]" ).append("\n"); 
		query.append(",	@[lsg_gr_no]" ).append("\n"); 
		query.append(",	TO_DATE(REPLACE(@[vvd_eff_dt],'-',''),'yyyymmdd')" ).append("\n"); 
		query.append(",	TO_DATE(REPLACE(@[vvd_exp_dt],'-',''),'yyyymmdd')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}