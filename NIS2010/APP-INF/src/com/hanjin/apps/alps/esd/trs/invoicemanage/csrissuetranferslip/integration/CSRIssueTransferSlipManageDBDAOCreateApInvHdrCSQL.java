/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCreateApInvHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCreateApInvHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Header 테이블에 자료 입력
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCreateApInvHdrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ATTR_CTNT10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PAY_GRP_LU_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("USR_EML",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PAY_TERM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("AP_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GLO_ATTR_CTNT10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CONTI_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PAY_MZD_LU_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ATTR_CTNT4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ATTR_CTNT3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("COST_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ATTR_CTNT2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SRC_CTNT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ATTR_CTNT8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ATTR_CTNT5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ATTR_CTNT6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ATTR_CATE_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_TERM_DT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCreateApInvHdrCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_INV_HDR (                                              													" ).append("\n"); 
		query.append("							CSR_NO                                          											" ).append("\n"); 
		query.append("						,	CSR_TP_CD                                       											" ).append("\n"); 
		query.append("						,	INV_DT                                          											" ).append("\n"); 
		query.append("						,	INV_TERM_DT                                     											" ).append("\n"); 
		query.append("						,	GL_DT                                           											" ).append("\n"); 
		query.append("						,	VNDR_NO                                         											" ).append("\n"); 
		query.append("						,	CSR_AMT                                         											" ).append("\n"); 
		query.append("						,	PAY_AMT                                         											" ).append("\n"); 
		query.append("						,	PAY_DT   " ).append("\n"); 
		query.append("						,	CSR_CURR_CD                                     											" ).append("\n"); 
		query.append("						,	VNDR_TERM_NM                                    											" ).append("\n"); 
		query.append("						,	INV_DESC                                        											" ).append("\n"); 
		query.append("						,	ATTR_CATE_NM                                    											" ).append("\n"); 
		query.append("						,	ATTR_CTNT1                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT2                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT3                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT4                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT5                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT6                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT7                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT8                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT9                                      											" ).append("\n"); 
		query.append("						,	ATTR_CTNT10                                     											" ).append("\n"); 
		query.append("						,	ATTR_CTNT11                                     											" ).append("\n"); 
		query.append("						,	ATTR_CTNT12                                     											" ).append("\n"); 
		query.append("						,	ATTR_CTNT13                                     											" ).append("\n"); 
		query.append("						,	ATTR_CTNT14                                     											" ).append("\n"); 
		query.append("						,	ATTR_CTNT15                                     	" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT1                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT2                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT3                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT4                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT5                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT6                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT7                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT8                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT9                                  											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT10                                 											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT11                                 											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT12                                 											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT13                                 											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT14                                 											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT15                                 											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT16                                 											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT17                                 											" ).append("\n"); 
		query.append("						,	GLO_ATTR_CTNT18                                 											" ).append("\n"); 
		query.append("						,	SRC_CTNT                                        											" ).append("\n"); 
		query.append("						,	PAY_MZD_LU_CD                                   											" ).append("\n"); 
		query.append("						,	PAY_GRP_LU_CD                                   											" ).append("\n"); 
		query.append("						,	COA_CO_CD                                       											" ).append("\n"); 
		query.append("						,	COA_RGN_CD                                      											" ).append("\n"); 
		query.append("						,	COA_CTR_CD                                      											" ).append("\n"); 
		query.append("						,	COA_ACCT_CD                                     											" ).append("\n"); 
		query.append("						,	COA_VVD_CD                                      											" ).append("\n"); 
		query.append("						,	COA_INTER_CO_CD                                 											" ).append("\n"); 
		query.append("						,	COA_FTU_N1ST_CD                                 											" ).append("\n"); 
		query.append("						,	COA_FTU_N2ND_CD                                 											" ).append("\n"); 
		query.append("						,	PPD_NO                                          											" ).append("\n"); 
		query.append("						,	PPD_DTRB_NO                                     											" ).append("\n"); 
		query.append("						,	PPD_APLY_AMT                                    											" ).append("\n"); 
		query.append("						,	PPD_GL_DT                                       											" ).append("\n"); 
		query.append("						,	APRO_FLG                                        											" ).append("\n"); 
		query.append("						,	TAX_DECL_FLG                                    											" ).append("\n"); 
		query.append("						,	ERR_CSR_NO                                      											" ).append("\n"); 
		query.append("						,	IF_FLG                                          											" ).append("\n"); 
		query.append("						,	IF_DT                                           											" ).append("\n"); 
		query.append("						,	IF_ERR_RSN                                      											" ).append("\n"); 
		query.append("						,	PPAY_APLY_FLG                                   											" ).append("\n"); 
		query.append("						,	TJ_OFC_CD                                       											" ).append("\n"); 
		query.append("						,	ACT_XCH_RT                                      											" ).append("\n"); 
		query.append("						,	IMP_ERR_FLG                                     											" ).append("\n"); 
		query.append("						,	RCV_ERR_FLG                                     											" ).append("\n"); 
		query.append("						,	TAX_CURR_XCH_FLG                                											" ).append("\n"); 
		query.append("						,	USR_EML                                         											" ).append("\n"); 
		query.append("						,	IMP_ERR_RSN                                     											" ).append("\n"); 
		query.append("						,	RCV_ERR_RSN                                     											" ).append("\n"); 
		query.append("						,	FTU_USE_CTNT1                                   											" ).append("\n"); 
		query.append("						,	FTU_USE_CTNT2                                   											" ).append("\n"); 
		query.append("						,	FTU_USE_CTNT3                                   											" ).append("\n"); 
		query.append("						,	FTU_USE_CTNT4                                   											" ).append("\n"); 
		query.append("						,	FTU_USE_CTNT5                                   											" ).append("\n"); 
		query.append("						,	CRE_DT                                          											" ).append("\n"); 
		query.append("						,	CRE_USR_ID                                      											" ).append("\n"); 
		query.append("						,	EAI_EVNT_DT                                     											" ).append("\n"); 
		query.append("						)																								" ).append("\n"); 
		query.append("				VALUES (                                     															" ).append("\n"); 
		query.append("							@[CSR_NO]                                                                    						-- csr_no" ).append("\n"); 
		query.append("						,	@[CSR_TP_CD]                                                                    					-- csr_tp_cd" ).append("\n"); 
		query.append("						,	@[INV_DT]                                                                    						-- inv_dt" ).append("\n"); 
		query.append("						,	@[INV_TERM_DT]        											        -- inv_term_dt" ).append("\n"); 
		query.append("						,	TRS_GET_GL_DT_FNC( '', @[AP_OFC_CD], @[INV_DT], '15')                          		-- gl_dt" ).append("\n"); 
		query.append("						,	@[VNDR_NO]	                                                               						-- vndr_no" ).append("\n"); 
		query.append("						,	ROUND(@[CSR_AMT], 2)                                                        					-- csr_amt" ).append("\n"); 
		query.append("						,	''                                                                  								-- pay_amt" ).append("\n"); 
		query.append("						,	''                                                                  								-- pay_dt" ).append("\n"); 
		query.append("						,	@[CSR_CURR_CD]                                                                  					-- csr_curr_cd" ).append("\n"); 
		query.append("						,	DECODE(@[CONTI_CD],'M',@[PAY_TERM],(SELECT GEN_PAY_TERM_CD FROM MDM_VENDOR WHERE VNDR_SEQ  = @[VNDR_NO]))       					-- vndr_term_nm <-- VNDR_SEQ" ).append("\n"); 
		query.append("						, 	CASE WHEN (SELECT V.VNDR_CNT_CD FROM MDM_VENDOR V WHERE V.VNDR_SEQ = @[VNDR_NO]) = 'KR' THEN 			-- inv_desc" ).append("\n"); 
		query.append("											(SELECT V.VNDR_LOCL_LANG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = @[VNDR_NO])         " ).append("\n"); 
		query.append("								 ELSE (SELECT V.VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = @[VNDR_NO])					" ).append("\n"); 
		query.append("							END																							" ).append("\n"); 
		query.append("						,	@[ATTR_CATE_NM]                                                                  				-- attr_cate_nm" ).append("\n"); 
		query.append("						,	''                                                                  								-- attr_ctnt1" ).append("\n"); 
		query.append("						,	@[ATTR_CTNT2]                                                                   					-- attr_ctnt2" ).append("\n"); 
		query.append("						,	@[ATTR_CTNT3]                                                                  					-- attr_ctnt3" ).append("\n"); 
		query.append("						,	@[ATTR_CTNT4]                                                                  					-- attr_ctnt4" ).append("\n"); 
		query.append("						,	@[ATTR_CTNT5]                                                                  					-- attr_ctnt5" ).append("\n"); 
		query.append("						,	@[ATTR_CTNT6]                                                                  					-- attr_ctnt6" ).append("\n"); 
		query.append("						,	''                                                                  								-- attr_ctnt7" ).append("\n"); 
		query.append("						,	@[ATTR_CTNT8]                                                          								-- attr_ctnt8" ).append("\n"); 
		query.append("						,	''                                                                  								-- attr_ctnt9" ).append("\n"); 
		query.append("						,	@[ATTR_CTNT10]                                                                  					-- attr_ctnt10" ).append("\n"); 
		query.append("						,	''                                                                  								-- attr_ctnt11" ).append("\n"); 
		query.append("						,	''                                                                  								-- attr_ctnt12" ).append("\n"); 
		query.append("						,	''                                                                  								-- attr_ctnt13" ).append("\n"); 
		query.append("						,	''                                                                  								-- attr_ctnt14" ).append("\n"); 
		query.append("						,	''                                                                  								-- attr_ctnt15" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT1]                                                                  				-- glo_attr_ctnt1" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT2]                                                                  				-- glo_attr_ctnt2" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT3]                                                                  				-- glo_attr_ctnt3" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT4]                                                                  				-- glo_attr_ctnt4" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT5]                                                                  				-- glo_attr_ctnt5" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT6]                                                                  				-- glo_attr_ctnt6" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT7]                                                                  				-- glo_attr_ctnt7" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT8]                                                                  				-- glo_attr_ctnt8" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT9]                                                                  				-- glo_attr_ctnt9" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT10]                                                                  				-- glo_attr_ctnt10" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT11]                                                                  				-- glo_attr_ctnt11" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT12]                                                                  				-- glo_attr_ctnt12" ).append("\n"); 
		query.append("						,	@[GLO_ATTR_CTNT13]                                                 						-- glo_attr_ctnt13" ).append("\n"); 
		query.append("						,	''                                                                  								-- glo_attr_ctnt14" ).append("\n"); 
		query.append("						,	''                                                                  								-- glo_attr_ctnt15" ).append("\n"); 
		query.append("						,	''                                                                  								-- glo_attr_ctnt16" ).append("\n"); 
		query.append("						,	''                                                                  								-- glo_attr_ctnt17" ).append("\n"); 
		query.append("						,	''                                                                  								-- glo_attr_ctnt18" ).append("\n"); 
		query.append("						,	@[SRC_CTNT]                                                                  					-- src_ctnt" ).append("\n"); 
		query.append("						,	@[PAY_MZD_LU_CD]													-- pay_mzd_lu_cd" ).append("\n"); 
		query.append("						,	@[PAY_GRP_LU_CD]                                                                  				-- pay_grp_lu_cd" ).append("\n"); 
		query.append("						,	'01'                                                                  								-- coa_co_cd" ).append("\n"); 
		query.append("						,	(SELECT FINC_RGN_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[COST_OFC_CD] AND NVL(DELT_FLG,'N') = 'N')		-- coa_rgn_cd" ).append("\n"); 
		query.append("						,	(SELECT AP_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[COST_OFC_CD] AND NVL(DELT_FLG,'N') = 'N') 		-- coa_ctr_cd" ).append("\n"); 
		query.append("						,	'210111'                                                                    							-- coa_acct_cd" ).append("\n"); 
		query.append("						,	'0000000000'                                                                    							-- coa_vvd_cd" ).append("\n"); 
		query.append("						,	(SELECT NVL(SUBS_CO_CD,'00')  FROM MDM_VENDOR WHERE VNDR_SEQ = @[VNDR_NO])    				-- coa_inter_co_cd" ).append("\n"); 
		query.append("						,	'000000'                                                                   						-- coa_ftu_n1st_cd" ).append("\n"); 
		query.append("						,	'000000'                                                                   						-- coa_ftu_n2nd_cd" ).append("\n"); 
		query.append("						,	''                                                                   							-- ppd_no" ).append("\n"); 
		query.append("						,	''                                                                   							-- ppd_dtrb_no" ).append("\n"); 
		query.append("						,	''                                                                   							-- ppd_aply_amt" ).append("\n"); 
		query.append("						,	''                                                                   							-- ppd_gl_dt" ).append("\n"); 
		query.append("						,	'N'                                                                   							-- apro_flg" ).append("\n"); 
		query.append("						,	'N'                                                                 							-- tax_decl_flg" ).append("\n"); 
		query.append("						,	''                                                                   							-- err_csr_no" ).append("\n"); 
		query.append("						,	''                                                                   							-- if_flg" ).append("\n"); 
		query.append("						,	''                                                                   							-- if_dt" ).append("\n"); 
		query.append("						,	''                                                                   							-- if_err_rsn" ).append("\n"); 
		query.append("						,	''                                                                   							-- ppay_aply_flg" ).append("\n"); 
		query.append("						,	@[AP_OFC_CD]                                                                   				-- tj_ofc_cd" ).append("\n"); 
		query.append("						,	''                                                                   							-- act_xch_rt" ).append("\n"); 
		query.append("						,	''                                                                    							-- imp_err_flg" ).append("\n"); 
		query.append("						,	''                                                                    							-- rcv_err_flg" ).append("\n"); 
		query.append("						,	''                                                                    							-- tax_curr_xch_flg" ).append("\n"); 
		query.append("						,	@[USR_EML]                                                                    				-- usr_eml" ).append("\n"); 
		query.append("						,	''                                                                    							-- imp_err_rsn" ).append("\n"); 
		query.append("						,	''                                                                    							-- rcv_err_rsn" ).append("\n"); 
		query.append("						,	''                                                                    							-- ftu_use_ctnt1" ).append("\n"); 
		query.append("						,	''                                                                    						  	-- ftu_use_ctnt2" ).append("\n"); 
		query.append("						,	''                                                                    						  	-- ftu_use_ctnt3" ).append("\n"); 
		query.append("						,	''                                                                    						  	-- ftu_use_ctnt4" ).append("\n"); 
		query.append("						,	''                                                                    						  	-- ftu_use_ctnt5" ).append("\n"); 
		query.append("						,	SYSDATE                                                              						-- cre_dt" ).append("\n"); 
		query.append("						,	@[CRE_USR_ID]		                                                             			-- cre_usr_id" ).append("\n"); 
		query.append("						,	SYSDATE                                                              						-- eai_evnt_dt" ).append("\n"); 
		query.append("							)" ).append("\n"); 

	}
}