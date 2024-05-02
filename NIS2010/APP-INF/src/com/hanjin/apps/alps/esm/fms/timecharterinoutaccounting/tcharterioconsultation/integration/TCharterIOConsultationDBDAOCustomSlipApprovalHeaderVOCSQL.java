/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomSlipApprovalHeaderVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.03 
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

public class TCharterIOConsultationDBDAOCustomSlipApprovalHeaderVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Header 테이블에 생성된다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomSlipApprovalHeaderVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imp_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_ftu_n1st_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("if_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_curr_xch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_term_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_dtrb_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_ftu_n2nd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_aply_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_err_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_decl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_act_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tj_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt18",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imp_err_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_term_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("err_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCustomSlipApprovalHeaderVOCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_INV_HDR (" ).append("\n"); 
		query.append("	CSR_NO" ).append("\n"); 
		query.append(",	CSR_TP_CD" ).append("\n"); 
		query.append(",	INV_DT" ).append("\n"); 
		query.append(",	INV_TERM_DT" ).append("\n"); 
		query.append(",	GL_DT" ).append("\n"); 
		query.append(",	VNDR_NO" ).append("\n"); 
		query.append(",	CSR_AMT" ).append("\n"); 
		query.append(",	PAY_AMT" ).append("\n"); 
		query.append(",	PAY_DT" ).append("\n"); 
		query.append(",	CSR_CURR_CD" ).append("\n"); 
		query.append(",	VNDR_TERM_NM" ).append("\n"); 
		query.append(",	INV_DESC" ).append("\n"); 
		query.append(",	ATTR_CATE_NM" ).append("\n"); 
		query.append(",	ATTR_CTNT1" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append(",	ATTR_CTNT11" ).append("\n"); 
		query.append(",	ATTR_CTNT12" ).append("\n"); 
		query.append(",	ATTR_CTNT13" ).append("\n"); 
		query.append(",	ATTR_CTNT14" ).append("\n"); 
		query.append(",	ATTR_CTNT15" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(",	GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(",	SRC_CTNT" ).append("\n"); 
		query.append(",	PAY_MZD_LU_CD" ).append("\n"); 
		query.append(",	PAY_GRP_LU_CD" ).append("\n"); 
		query.append(",	COA_CO_CD" ).append("\n"); 
		query.append(",	COA_RGN_CD" ).append("\n"); 
		query.append(",	COA_CTR_CD" ).append("\n"); 
		query.append(",	COA_ACCT_CD" ).append("\n"); 
		query.append(",	COA_VVD_CD" ).append("\n"); 
		query.append(",	COA_INTER_CO_CD" ).append("\n"); 
		query.append(",	COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",	COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",	PPD_NO" ).append("\n"); 
		query.append(",	PPD_DTRB_NO" ).append("\n"); 
		query.append(",	PPD_APLY_AMT" ).append("\n"); 
		query.append(",	PPD_GL_DT" ).append("\n"); 
		query.append(",	APRO_FLG" ).append("\n"); 
		query.append(",	TAX_DECL_FLG" ).append("\n"); 
		query.append(",	ERR_CSR_NO" ).append("\n"); 
		query.append(",	IF_FLG" ).append("\n"); 
		query.append(",	IF_DT" ).append("\n"); 
		query.append(",	IF_ERR_RSN" ).append("\n"); 
		query.append(",	PPAY_APLY_FLG" ).append("\n"); 
		query.append(",	TJ_OFC_CD" ).append("\n"); 
		query.append(",	ACT_XCH_RT" ).append("\n"); 
		query.append(",	IMP_ERR_FLG" ).append("\n"); 
		query.append(",	RCV_ERR_FLG" ).append("\n"); 
		query.append(",	TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append(",	USR_EML" ).append("\n"); 
		query.append(",	IMP_ERR_RSN" ).append("\n"); 
		query.append(",	RCV_ERR_RSN" ).append("\n"); 
		query.append(",	FTU_USE_CTNT1" ).append("\n"); 
		query.append(",	FTU_USE_CTNT2" ).append("\n"); 
		query.append(",	FTU_USE_CTNT3" ).append("\n"); 
		query.append(",	FTU_USE_CTNT4" ).append("\n"); 
		query.append(",	FTU_USE_CTNT5" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	EAI_EVNT_DT" ).append("\n"); 
		query.append(",	AFT_ACT_FLG" ).append("\n"); 
		query.append(",	ESTM_ERR_RSN" ).append("\n"); 
		query.append(",	CXL_DT" ).append("\n"); 
		query.append(",   ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append(",   CSR_USD_AMT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[csr_no]" ).append("\n"); 
		query.append(",	@[csr_tp_cd]" ).append("\n"); 
		query.append(",	@[inv_dt]" ).append("\n"); 
		query.append(",	@[inv_term_dt]" ).append("\n"); 
		query.append(",	@[gl_dt]" ).append("\n"); 
		query.append(",	@[vndr_no]" ).append("\n"); 
		query.append(",	@[csr_amt]" ).append("\n"); 
		query.append(",	@[pay_amt]" ).append("\n"); 
		query.append(",	@[pay_dt]" ).append("\n"); 
		query.append(",	@[csr_curr_cd]" ).append("\n"); 
		query.append(",	@[vndr_term_nm]" ).append("\n"); 
		query.append(",	@[inv_desc]" ).append("\n"); 
		query.append(",	@[attr_cate_nm]" ).append("\n"); 
		query.append(",	@[attr_ctnt1]" ).append("\n"); 
		query.append(",	@[attr_ctnt2]  " ).append("\n"); 
		query.append(",	@[attr_ctnt3]" ).append("\n"); 
		query.append(",	@[attr_ctnt4]" ).append("\n"); 
		query.append(",	@[attr_ctnt5]" ).append("\n"); 
		query.append(",	@[attr_ctnt6]" ).append("\n"); 
		query.append(",	@[attr_ctnt7]" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("        SELECT A.DOC_EVID_TP_CD" ).append("\n"); 
		query.append("        FROM FMS_TAX A" ).append("\n"); 
		query.append("        WHERE A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT T.DOC_EVID_TP_CD" ).append("\n"); 
		query.append("          FROM FMS_CONSULTATION C, FMS_TAX T" ).append("\n"); 
		query.append("         WHERE C.VAT_SLP_TP_CD||C.VAT_SLP_FUNC_CD||C.VAT_SLP_OFC_CD||C.VAT_SLP_ISS_DT||C.VAT_SLP_SER_NO =" ).append("\n"); 
		query.append("               T.SLP_TP_CD||T.SLP_FUNC_CD||T.SLP_OFC_CD||T.SLP_ISS_DT||T.SLP_SER_NO" ).append("\n"); 
		query.append("           AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO = @[csr_no]  " ).append("\n"); 
		query.append("    )  --attr_ctnt8" ).append("\n"); 
		query.append(",	@[attr_ctnt9]" ).append("\n"); 
		query.append(",	@[attr_ctnt10]" ).append("\n"); 
		query.append(",	@[attr_ctnt11]" ).append("\n"); 
		query.append(",	@[attr_ctnt12]" ).append("\n"); 
		query.append(",	@[attr_ctnt13]" ).append("\n"); 
		query.append(",	@[attr_ctnt14]" ).append("\n"); 
		query.append(",	@[attr_ctnt15]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt1]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt2]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt3]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt4]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt5]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt6]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt7]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt8]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt9]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt10]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt11]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt12]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt13]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt14]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt15]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt16]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt17]" ).append("\n"); 
		query.append(",	@[glo_attr_ctnt18]" ).append("\n"); 
		query.append(",	@[src_ctnt]" ).append("\n"); 
		query.append(",	@[pay_mzd_lu_cd]" ).append("\n"); 
		query.append(",	@[pay_grp_lu_cd]" ).append("\n"); 
		query.append(",	@[coa_co_cd]" ).append("\n"); 
		query.append(",	@[coa_rgn_cd]" ).append("\n"); 
		query.append(",	@[coa_ctr_cd]" ).append("\n"); 
		query.append(",	@[coa_acct_cd]" ).append("\n"); 
		query.append(",	@[coa_vvd_cd]" ).append("\n"); 
		query.append(",	@[coa_inter_co_cd]" ).append("\n"); 
		query.append(",	@[coa_ftu_n1st_cd]" ).append("\n"); 
		query.append(",	@[coa_ftu_n2nd_cd]" ).append("\n"); 
		query.append(",	@[ppd_no]" ).append("\n"); 
		query.append(",	@[ppd_dtrb_no]" ).append("\n"); 
		query.append(",	@[ppd_aply_amt]" ).append("\n"); 
		query.append(",	@[ppd_gl_dt]" ).append("\n"); 
		query.append(",	@[apro_flg]" ).append("\n"); 
		query.append(",	@[tax_decl_flg]" ).append("\n"); 
		query.append(",	@[err_csr_no]" ).append("\n"); 
		query.append(",	@[if_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[if_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[if_err_rsn]" ).append("\n"); 
		query.append(",	@[ppay_aply_flg]" ).append("\n"); 
		query.append(",	@[tj_ofc_cd]" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("		SELECT T.LOCL_KRW_XCH_RT " ).append("\n"); 
		query.append("		 FROM GL_MON_XCH_RT T " ).append("\n"); 
		query.append("		 WHERE T.ACCT_XCH_RT_LVL   = 1 " ).append("\n"); 
		query.append("		 AND T.CURR_CD           = @[csr_curr_cd]   			 --  전표의 통화 " ).append("\n"); 
		query.append("		 AND T.ACCT_XCH_RT_YRMON = SUBSTR(@[gl_dt],0,6)  		 -- GL Date" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append(",	@[imp_err_flg]" ).append("\n"); 
		query.append(",	@[rcv_err_flg]" ).append("\n"); 
		query.append(",	@[tax_curr_xch_flg]" ).append("\n"); 
		query.append(",	@[usr_eml]" ).append("\n"); 
		query.append(",	@[imp_err_rsn]" ).append("\n"); 
		query.append(",	@[rcv_err_rsn]" ).append("\n"); 
		query.append(",	@[ftu_use_ctnt1]" ).append("\n"); 
		query.append(",	@[ftu_use_ctnt2]" ).append("\n"); 
		query.append(",	@[ftu_use_ctnt3]" ).append("\n"); 
		query.append(",	@[ftu_use_ctnt4]" ).append("\n"); 
		query.append(",	@[ftu_use_ctnt5]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[aft_act_flg]" ).append("\n"); 
		query.append(",	@[estm_err_rsn]" ).append("\n"); 
		query.append(",	@[cxl_dt]" ).append("\n"); 
		query.append(",	( " ).append("\n"); 
		query.append("	  SELECT SUBSTR(A.EFF_DT,0,6) FROM FMS_CONSULTATION A" ).append("\n"); 
		query.append("	  WHERE A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("		SELECT ROUND(NVL(@[csr_usd_amt]/ DECODE(@[csr_curr_cd],'USD',1, " ).append("\n"); 
		query.append("        			                                  (SELECT NVL(EX1.USD_LOCL_XCH_RT, 1) " ).append("\n"); 
		query.append("                    			                       FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                			           WHERE EX1.CURR_CD = @[csr_curr_cd]" ).append("\n"); 
		query.append("                                            			 AND EX1.ACCT_XCH_RT_YRMON = (SELECT SUBSTR(A.EFF_DT,0,6) FROM FMS_CONSULTATION A" ).append("\n"); 
		query.append("																			     	  WHERE A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("																					  )" ).append("\n"); 
		query.append("			                                             AND EX1.ACCT_XCH_RT_LVL = '1')" ).append("\n"); 
		query.append("            			                              )" ).append("\n"); 
		query.append("    		  ,0),2)" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}