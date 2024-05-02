/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlpProcJooCsrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.28
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.10.28 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlpProcJooCsrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Creation 시 JOO_CSR에 데이터입력한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlpProcJooCsrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evid_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_offst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issuer_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_doc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot_amount",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rjct_csr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlpProcJooCsrCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_CSR (" ).append("\n"); 
		query.append(" SLP_TP_CD" ).append("\n"); 
		query.append(",SLP_FUNC_CD" ).append("\n"); 
		query.append(",SLP_OFC_CD" ).append("\n"); 
		query.append(",SLP_ISS_DT" ).append("\n"); 
		query.append(",SLP_SER_NO" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",CSR_DESC" ).append("\n"); 
		query.append(",CSR_LOCL_CURR_CD" ).append("\n"); 
		query.append(",CSR_LOCL_AMT" ).append("\n"); 
		query.append(",CSR_USD_AMT" ).append("\n"); 
		query.append(",EFF_DT" ).append("\n"); 
		query.append(",EVID_TP_CD" ).append("\n"); 
		query.append(",APRO_FLG" ).append("\n"); 
		query.append(",APRO_DT" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(",CXL_DESC" ).append("\n"); 
		query.append(",CSR_OFFST_NO" ).append("\n"); 
		query.append(",DDCT_FLG" ).append("\n"); 
		query.append(",DDCT_LOCL_AMT" ).append("\n"); 
		query.append(",DDCT_DESC" ).append("\n"); 
		query.append(",RQST_LOCL_AMT" ).append("\n"); 
		query.append(",RQST_DT" ).append("\n"); 
		query.append(",CSR_TP_CD" ).append("\n"); 
		query.append(",RVS_CSR_FLG" ).append("\n"); 
		query.append(",ORG_SLP_TP_CD" ).append("\n"); 
		query.append(",ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append(",ORG_SLP_OFC_CD" ).append("\n"); 
		query.append(",ORG_SLP_ISS_DT" ).append("\n"); 
		query.append(",ORG_SLP_SER_NO" ).append("\n"); 
		query.append(",SLP_ISS_OFC_CD" ).append("\n"); 
		query.append(",SLP_ISS_RGN_CD" ).append("\n"); 
		query.append(",SLP_ISS_INTER_CO_CD" ).append("\n"); 
		query.append(",RJCT_CSR_FLG" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",AGMT_DOC_NO" ).append("\n"); 
		query.append(",AGMT_DOC_DESC" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append(" @[slp_tp_cd]" ).append("\n"); 
		query.append(",@[slp_func_cd]" ).append("\n"); 
		query.append(",@[slp_ofc_cd]" ).append("\n"); 
		query.append(",REPLACE(@[slp_iss_dt],'-','')" ).append("\n"); 
		query.append(",@[slp_ser_no]" ).append("\n"); 
		query.append("#if (${re_divr_cd} == 'E')" ).append("\n"); 
		query.append(",@[cust_vndr_seq]" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",@[cust_vndr_cnt_cd]" ).append("\n"); 
		query.append(",@[cust_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",@[csr_desc]" ).append("\n"); 
		query.append(",@[locl_curr_cd]" ).append("\n"); 
		query.append(",@[tot_amount]" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",TO_DATE(REPLACE(@[eff_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append(",@[evid_tp_cd]" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",@[csr_offst_no]" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",TO_DATE(REPLACE(@[rqst_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append(",@[csr_tp_cd]" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",@[slp_iss_ofc_cd]" ).append("\n"); 
		query.append(",@[slp_iss_rgn_cd]" ).append("\n"); 
		query.append(",@[slp_iss_inter_co_cd]" ).append("\n"); 
		query.append(",NVL(@[rjct_csr_flg],'N')" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[issuer_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[issuer_id]" ).append("\n"); 
		query.append(",@[agmt_doc_no]" ).append("\n"); 
		query.append(",@[agmt_doc_desc]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}