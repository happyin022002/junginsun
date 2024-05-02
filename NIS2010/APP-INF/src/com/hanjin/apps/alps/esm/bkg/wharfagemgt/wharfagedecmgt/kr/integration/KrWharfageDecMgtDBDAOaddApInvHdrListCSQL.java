/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOaddApInvHdrListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.26 정재엽
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOaddApInvHdrListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOaddApInvHdrListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("glo_attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOaddApInvHdrListCSQL").append("\n"); 
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
		query.append("CSR_NO," ).append("\n"); 
		query.append("CSR_TP_CD," ).append("\n"); 
		query.append("INV_DT," ).append("\n"); 
		query.append("INV_TERM_DT," ).append("\n"); 
		query.append("GL_DT," ).append("\n"); 
		query.append("VNDR_NO," ).append("\n"); 
		query.append("CSR_AMT," ).append("\n"); 
		query.append("PAY_AMT," ).append("\n"); 
		query.append("PAY_DT," ).append("\n"); 
		query.append("CSR_CURR_CD," ).append("\n"); 
		query.append("VNDR_TERM_NM," ).append("\n"); 
		query.append("INV_DESC," ).append("\n"); 
		query.append("ATTR_CATE_NM," ).append("\n"); 
		query.append("ATTR_CTNT1," ).append("\n"); 
		query.append("ATTR_CTNT2," ).append("\n"); 
		query.append("ATTR_CTNT3," ).append("\n"); 
		query.append("ATTR_CTNT4," ).append("\n"); 
		query.append("ATTR_CTNT5," ).append("\n"); 
		query.append("ATTR_CTNT6," ).append("\n"); 
		query.append("ATTR_CTNT7," ).append("\n"); 
		query.append("ATTR_CTNT8," ).append("\n"); 
		query.append("ATTR_CTNT9," ).append("\n"); 
		query.append("ATTR_CTNT10," ).append("\n"); 
		query.append("ATTR_CTNT11," ).append("\n"); 
		query.append("ATTR_CTNT12," ).append("\n"); 
		query.append("ATTR_CTNT13," ).append("\n"); 
		query.append("ATTR_CTNT14," ).append("\n"); 
		query.append("ATTR_CTNT15," ).append("\n"); 
		query.append("GLO_ATTR_CTNT1," ).append("\n"); 
		query.append("GLO_ATTR_CTNT2," ).append("\n"); 
		query.append("GLO_ATTR_CTNT3," ).append("\n"); 
		query.append("GLO_ATTR_CTNT4," ).append("\n"); 
		query.append("GLO_ATTR_CTNT5," ).append("\n"); 
		query.append("GLO_ATTR_CTNT6," ).append("\n"); 
		query.append("GLO_ATTR_CTNT7," ).append("\n"); 
		query.append("GLO_ATTR_CTNT8," ).append("\n"); 
		query.append("GLO_ATTR_CTNT9," ).append("\n"); 
		query.append("GLO_ATTR_CTNT10," ).append("\n"); 
		query.append("GLO_ATTR_CTNT11," ).append("\n"); 
		query.append("GLO_ATTR_CTNT12," ).append("\n"); 
		query.append("GLO_ATTR_CTNT13," ).append("\n"); 
		query.append("GLO_ATTR_CTNT14," ).append("\n"); 
		query.append("GLO_ATTR_CTNT15," ).append("\n"); 
		query.append("GLO_ATTR_CTNT16," ).append("\n"); 
		query.append("GLO_ATTR_CTNT17," ).append("\n"); 
		query.append("GLO_ATTR_CTNT18," ).append("\n"); 
		query.append("SRC_CTNT," ).append("\n"); 
		query.append("PAY_MZD_LU_CD," ).append("\n"); 
		query.append("PAY_GRP_LU_CD," ).append("\n"); 
		query.append("COA_CO_CD," ).append("\n"); 
		query.append("COA_RGN_CD," ).append("\n"); 
		query.append("COA_CTR_CD," ).append("\n"); 
		query.append("COA_ACCT_CD," ).append("\n"); 
		query.append("COA_VVD_CD," ).append("\n"); 
		query.append("COA_INTER_CO_CD," ).append("\n"); 
		query.append("COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("PPD_NO," ).append("\n"); 
		query.append("PPD_DTRB_NO," ).append("\n"); 
		query.append("PPD_APLY_AMT," ).append("\n"); 
		query.append("PPD_GL_DT," ).append("\n"); 
		query.append("APRO_FLG," ).append("\n"); 
		query.append("TAX_DECL_FLG," ).append("\n"); 
		query.append("ERR_CSR_NO," ).append("\n"); 
		query.append("IF_FLG," ).append("\n"); 
		query.append("IF_DT," ).append("\n"); 
		query.append("IF_ERR_RSN," ).append("\n"); 
		query.append("PPAY_APLY_FLG," ).append("\n"); 
		query.append("TJ_OFC_CD," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("CRE_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[csr_no]," ).append("\n"); 
		query.append("@[csr_tp_cd]," ).append("\n"); 
		query.append("@[inv_dt]," ).append("\n"); 
		query.append("@[inv_term_dt]," ).append("\n"); 
		query.append("@[gl_dt]," ).append("\n"); 
		query.append("@[vndr_no]," ).append("\n"); 
		query.append("@[csr_amt]," ).append("\n"); 
		query.append("@[pay_amt]," ).append("\n"); 
		query.append("@[pay_dt]," ).append("\n"); 
		query.append("@[csr_curr_cd]," ).append("\n"); 
		query.append("@[vndr_term_nm]," ).append("\n"); 
		query.append("@[inv_desc]," ).append("\n"); 
		query.append("@[attr_cate_nm]," ).append("\n"); 
		query.append("@[attr_ctnt1]," ).append("\n"); 
		query.append("@[attr_ctnt2]," ).append("\n"); 
		query.append("@[attr_ctnt3]," ).append("\n"); 
		query.append("@[attr_ctnt4]," ).append("\n"); 
		query.append("@[attr_ctnt5]," ).append("\n"); 
		query.append("@[attr_ctnt6]," ).append("\n"); 
		query.append("@[attr_ctnt7]," ).append("\n"); 
		query.append("@[attr_ctnt8]," ).append("\n"); 
		query.append("@[attr_ctnt9]," ).append("\n"); 
		query.append("@[attr_ctnt10]," ).append("\n"); 
		query.append("@[attr_ctnt11]," ).append("\n"); 
		query.append("@[attr_ctnt12]," ).append("\n"); 
		query.append("@[attr_ctnt13]," ).append("\n"); 
		query.append("@[attr_ctnt14]," ).append("\n"); 
		query.append("@[attr_ctnt15]," ).append("\n"); 
		query.append("@[glo_attr_ctnt1]," ).append("\n"); 
		query.append("@[glo_attr_ctnt2]," ).append("\n"); 
		query.append("@[glo_attr_ctnt3]," ).append("\n"); 
		query.append("@[glo_attr_ctnt4]," ).append("\n"); 
		query.append("@[glo_attr_ctnt5]," ).append("\n"); 
		query.append("@[glo_attr_ctnt6]," ).append("\n"); 
		query.append("@[glo_attr_ctnt7]," ).append("\n"); 
		query.append("@[glo_attr_ctnt8]," ).append("\n"); 
		query.append("@[glo_attr_ctnt9]," ).append("\n"); 
		query.append("@[glo_attr_ctnt10]," ).append("\n"); 
		query.append("@[glo_attr_ctnt11]," ).append("\n"); 
		query.append("@[glo_attr_ctnt12]," ).append("\n"); 
		query.append("@[glo_attr_ctnt13]," ).append("\n"); 
		query.append("@[glo_attr_ctnt14]," ).append("\n"); 
		query.append("@[glo_attr_ctnt15]," ).append("\n"); 
		query.append("@[glo_attr_ctnt16]," ).append("\n"); 
		query.append("@[glo_attr_ctnt17]," ).append("\n"); 
		query.append("@[glo_attr_ctnt18]," ).append("\n"); 
		query.append("@[src_ctnt]," ).append("\n"); 
		query.append("@[pay_mzd_lu_cd]," ).append("\n"); 
		query.append("@[pay_grp_lu_cd]," ).append("\n"); 
		query.append("@[coa_co_cd]," ).append("\n"); 
		query.append("@[coa_rgn_cd]," ).append("\n"); 
		query.append("@[coa_ctr_cd]," ).append("\n"); 
		query.append("@[coa_acct_cd]," ).append("\n"); 
		query.append("@[coa_vvd_cd]," ).append("\n"); 
		query.append("@[coa_inter_co_cd]," ).append("\n"); 
		query.append("@[coa_ftu_n1st_cd]," ).append("\n"); 
		query.append("@[coa_ftu_n2nd_cd]," ).append("\n"); 
		query.append("@[ppd_no]," ).append("\n"); 
		query.append("@[ppd_dtrb_no]," ).append("\n"); 
		query.append("@[ppd_aply_amt]," ).append("\n"); 
		query.append("@[ppd_gl_dt]," ).append("\n"); 
		query.append("@[apro_flg]," ).append("\n"); 
		query.append("@[tax_decl_flg]," ).append("\n"); 
		query.append("@[err_csr_no]," ).append("\n"); 
		query.append("@[if_flg]," ).append("\n"); 
		query.append("@[if_dt]," ).append("\n"); 
		query.append("@[if_err_rsn]," ).append("\n"); 
		query.append("@[ppay_aply_flg]," ).append("\n"); 
		query.append("@[tj_ofc_cd]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}