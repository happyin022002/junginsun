/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlpProcJooSlipCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.11.04 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlpProcJooSlipCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Creation시 JOO_SLIP테이블에 data를 입력한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlpProcJooSlipCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bil_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dr_cr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cr_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dr_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlpProcJooSlipCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_SLIP (" ).append("\n"); 
		query.append("SLP_TP_CD" ).append("\n"); 
		query.append(",SLP_FUNC_CD" ).append("\n"); 
		query.append(",SLP_OFC_CD" ).append("\n"); 
		query.append(",SLP_ISS_DT" ).append("\n"); 
		query.append(",SLP_SER_NO" ).append("\n"); 
		query.append(",SLP_SEQ_NO" ).append("\n"); 
		query.append(",DR_CR_CD" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",EFF_DT" ).append("\n"); 
		query.append(",CSR_LOCL_CURR_CD" ).append("\n"); 
		query.append(",CSR_LOCL_AMT" ).append("\n"); 
		query.append(",CSR_USD_AMT" ).append("\n"); 
		query.append(",SLP_DESC" ).append("\n"); 
		query.append(",CTR_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",REV_DIR_CD" ).append("\n"); 
		query.append(",KEY_NO" ).append("\n"); 
		query.append(",JO_BIL_NO" ).append("\n"); 
		query.append(",VVD_CXL_FLG" ).append("\n"); 
		query.append(",JO_STL_ITM_CD" ).append("\n"); 
		query.append(",BSA_QTY" ).append("\n"); 
		query.append(",BSA_SLT_PRC" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",ACCT_YRMON" ).append("\n"); 
		query.append(",STL_VVD_SEQ" ).append("\n"); 
		query.append(",STL_SEQ" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[slp_tp_cd]" ).append("\n"); 
		query.append(",@[slp_func_cd]" ).append("\n"); 
		query.append(",@[slp_ofc_cd]" ).append("\n"); 
		query.append(",REPLACE(@[slp_iss_dt],'-','')" ).append("\n"); 
		query.append(",@[slp_ser_no]" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT /*+INDEX_DESC(A XPKJOO_SLIP)*/" ).append("\n"); 
		query.append("LPAD(TO_NUMBER(A.SLP_SEQ_NO)+1,4,'0')" ).append("\n"); 
		query.append("FROM   JOO_SLIP A" ).append("\n"); 
		query.append("WHERE  A.SLP_TP_CD   = @[slp_tp_cd]" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD = @[slp_func_cd]" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD  = @[slp_ofc_cd]" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  = REPLACE(@[slp_iss_dt],'-','')" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO  = @[slp_ser_no]" ).append("\n"); 
		query.append("AND    ROWNUM =1),'0001')" ).append("\n"); 
		query.append(",@[dr_cr_cd]" ).append("\n"); 
		query.append("#if (${dr_cr_cd}=='DR')" ).append("\n"); 
		query.append(",@[dr_acct_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",@[cr_acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",TO_DATE(REPLACE(@[eff_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append(",@[locl_curr_cd]" ).append("\n"); 
		query.append("#if (${dr_cr_cd}=='DR')" ).append("\n"); 
		query.append(",@[stl_locl_amt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${slp_tp_cd}=='06')" ).append("\n"); 
		query.append(",@[tot_amount]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",@[stl_locl_amt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",@[slp_desc]" ).append("\n"); 
		query.append("#if (${dr_cr_cd}=='DR')" ).append("\n"); 
		query.append(",@[dr_ctr_cd]" ).append("\n"); 
		query.append(",@[dr_loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",@[cr_ctr_cd]" ).append("\n"); 
		query.append(",@[cr_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",@[rlane_cd]" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[rev_dir_cd]" ).append("\n"); 
		query.append(",@[key_no]" ).append("\n"); 
		query.append("#if (${slp_tp_cd}=='06')" ).append("\n"); 
		query.append(",@[jo_bil_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${dr_cr_cd}=='DR')" ).append("\n"); 
		query.append(",@[key_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",@[vvd_cxl_flg]" ).append("\n"); 
		query.append(",@[jo_stl_itm_cd]" ).append("\n"); 
		query.append(",@[bsa_qty]" ).append("\n"); 
		query.append(",@[bsa_slt_prc]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[issuer_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[issuer_id]" ).append("\n"); 
		query.append(",REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append(",DECODE(@[stl_vvd_seq],0,NULL,@[stl_vvd_seq])" ).append("\n"); 
		query.append(",DECODE(@[stl_seq],0,NULL,@[stl_seq])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}