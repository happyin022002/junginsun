/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvHDR2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCreateApInvHDR2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvHDR2
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvHDR2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvHDR2CSQL").append("\n"); 
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
		query.append("	 CSR_NO," ).append("\n"); 
		query.append("	 CSR_TP_CD," ).append("\n"); 
		query.append("	 INV_DT," ).append("\n"); 
		query.append("	 INV_TERM_DT," ).append("\n"); 
		query.append("	 GL_DT," ).append("\n"); 
		query.append("	 VNDR_NO," ).append("\n"); 
		query.append("	 CSR_AMT," ).append("\n"); 
		query.append("	 PAY_AMT," ).append("\n"); 
		query.append("	 PAY_DT," ).append("\n"); 
		query.append("	 CSR_CURR_CD," ).append("\n"); 
		query.append("	 VNDR_TERM_NM," ).append("\n"); 
		query.append("	 INV_DESC," ).append("\n"); 
		query.append("	 ATTR_CATE_NM," ).append("\n"); 
		query.append("	 ATTR_CTNT1," ).append("\n"); 
		query.append("	 ATTR_CTNT2," ).append("\n"); 
		query.append("	 ATTR_CTNT3," ).append("\n"); 
		query.append("	 ATTR_CTNT4," ).append("\n"); 
		query.append("	 ATTR_CTNT5," ).append("\n"); 
		query.append("	 ATTR_CTNT6," ).append("\n"); 
		query.append("	 ATTR_CTNT7," ).append("\n"); 
		query.append("	 ATTR_CTNT8," ).append("\n"); 
		query.append("	 ATTR_CTNT9," ).append("\n"); 
		query.append("	 ATTR_CTNT10," ).append("\n"); 
		query.append("	 ATTR_CTNT11," ).append("\n"); 
		query.append("	 ATTR_CTNT12," ).append("\n"); 
		query.append("	 ATTR_CTNT13," ).append("\n"); 
		query.append("	 ATTR_CTNT14," ).append("\n"); 
		query.append("	 ATTR_CTNT15," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT1," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT2," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT3," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT4," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT5," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT6," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT7," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT8," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT9," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT10," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT11," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT12," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT13," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT14," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT15," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT16," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT17," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT18," ).append("\n"); 
		query.append("	 SRC_CTNT," ).append("\n"); 
		query.append("	 PAY_MZD_LU_CD," ).append("\n"); 
		query.append("	 PAY_GRP_LU_CD," ).append("\n"); 
		query.append("	 COA_CO_CD," ).append("\n"); 
		query.append("	 COA_RGN_CD," ).append("\n"); 
		query.append("	 COA_CTR_CD," ).append("\n"); 
		query.append("	 COA_ACCT_CD," ).append("\n"); 
		query.append("	 COA_VVD_CD," ).append("\n"); 
		query.append("	 COA_INTER_CO_CD," ).append("\n"); 
		query.append("	 COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("	 COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("	 PPD_NO," ).append("\n"); 
		query.append("	 PPD_DTRB_NO," ).append("\n"); 
		query.append("	 PPD_APLY_AMT," ).append("\n"); 
		query.append("	 PPD_GL_DT," ).append("\n"); 
		query.append("	 APRO_FLG," ).append("\n"); 
		query.append("	 TAX_DECL_FLG," ).append("\n"); 
		query.append("	 ERR_CSR_NO," ).append("\n"); 
		query.append("	 IF_FLG," ).append("\n"); 
		query.append("	 IF_DT," ).append("\n"); 
		query.append("	 IF_ERR_RSN," ).append("\n"); 
		query.append("	 PPAY_APLY_FLG," ).append("\n"); 
		query.append("	 TJ_OFC_CD," ).append("\n"); 
		query.append("	 ACT_XCH_RT," ).append("\n"); 
		query.append("	 IMP_ERR_FLG," ).append("\n"); 
		query.append("	 RCV_ERR_FLG," ).append("\n"); 
		query.append("	 TAX_CURR_XCH_FLG," ).append("\n"); 
		query.append("	 USR_EML," ).append("\n"); 
		query.append("	 IMP_ERR_RSN," ).append("\n"); 
		query.append("	 RCV_ERR_RSN," ).append("\n"); 
		query.append("	 FTU_USE_CTNT1," ).append("\n"); 
		query.append("	 FTU_USE_CTNT2," ).append("\n"); 
		query.append("	 FTU_USE_CTNT3," ).append("\n"); 
		query.append("	 FTU_USE_CTNT4," ).append("\n"); 
		query.append("	 FTU_USE_CTNT5," ).append("\n"); 
		query.append("	 CRE_DT," ).append("\n"); 
		query.append("	 CRE_USR_ID," ).append("\n"); 
		query.append("	 EAI_EVNT_DT," ).append("\n"); 
		query.append("	 AFT_ACT_FLG," ).append("\n"); 
		query.append("	 ESTM_ERR_RSN )" ).append("\n"); 
		query.append("	 SELECT" ).append("\n"); 
		query.append("	 @[new_csr_no] CSR_NO," ).append("\n"); 
		query.append("	 'STANDARD' CSR_TP_CD," ).append("\n"); 
		query.append("	 INV_DT," ).append("\n"); 
		query.append("	 INV_TERM_DT," ).append("\n"); 
		query.append("	 SUBSTR((SELECT EXE_YRMON" ).append("\n"); 
		query.append("			 FROM LEA_REV_VVD_CNG" ).append("\n"); 
		query.append("			 WHERE  CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("			 AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			 AND OLD_VSL_CD||OLD_SKD_VOY_NO||OLD_SKD_DIR_CD||OLD_REV_DIR_CD = @[old_vsl_cd]||@[old_skd_voy_no]||@[old_skd_dir_cd]||@[old_rev_dir_cd]" ).append("\n"); 
		query.append("			 AND ROWNUM = 1),1,6)||" ).append("\n"); 
		query.append("			 SUBSTR(TO_CHAR(LAST_DAY(TO_DATE(SUBSTR((SELECT EXE_YRMON" ).append("\n"); 
		query.append("													 FROM LEA_REV_VVD_CNG" ).append("\n"); 
		query.append("													 WHERE  CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("													 AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("													 AND OLD_VSL_CD||OLD_SKD_VOY_NO||OLD_SKD_DIR_CD||OLD_REV_DIR_CD = @[old_vsl_cd]||@[old_skd_voy_no]||@[old_skd_dir_cd]||@[old_rev_dir_cd]" ).append("\n"); 
		query.append("													 AND ROWNUM = 1),1,6),'YYYYMM')),'YYYYMMDD'),7,8) GL_DT," ).append("\n"); 
		query.append("	 VNDR_NO," ).append("\n"); 
		query.append("	 0 CSR_AMT," ).append("\n"); 
		query.append("	 NULL PAY_AMT," ).append("\n"); 
		query.append("	 NULL PAY_DT," ).append("\n"); 
		query.append("	 CSR_CURR_CD," ).append("\n"); 
		query.append("	 VNDR_TERM_NM," ).append("\n"); 
		query.append("	 INV_DESC," ).append("\n"); 
		query.append("	 ATTR_CATE_NM," ).append("\n"); 
		query.append("	 ATTR_CTNT1," ).append("\n"); 
		query.append("	 ATTR_CTNT2," ).append("\n"); 
		query.append("	 ATTR_CTNT3," ).append("\n"); 
		query.append("	 ATTR_CTNT4," ).append("\n"); 
		query.append("	 ATTR_CTNT5," ).append("\n"); 
		query.append("	 ATTR_CTNT6," ).append("\n"); 
		query.append("	 ATTR_CTNT7," ).append("\n"); 
		query.append("	 ATTR_CTNT8," ).append("\n"); 
		query.append("	 ATTR_CTNT9," ).append("\n"); 
		query.append("	 ATTR_CTNT10," ).append("\n"); 
		query.append("	 ATTR_CTNT11," ).append("\n"); 
		query.append("	 ATTR_CTNT12," ).append("\n"); 
		query.append("	 ATTR_CTNT13," ).append("\n"); 
		query.append("	 ATTR_CTNT14," ).append("\n"); 
		query.append("	 ATTR_CTNT15," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT1," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT2," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT3," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT4," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT5," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT6," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT7," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT8," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT9," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT10," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT11," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT12," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT13," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT14," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT15," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT16," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT17," ).append("\n"); 
		query.append("	 GLO_ATTR_CTNT18," ).append("\n"); 
		query.append("	 SRC_CTNT," ).append("\n"); 
		query.append("	 PAY_MZD_LU_CD," ).append("\n"); 
		query.append("	 PAY_GRP_LU_CD," ).append("\n"); 
		query.append("	 COA_CO_CD," ).append("\n"); 
		query.append("	 COA_RGN_CD," ).append("\n"); 
		query.append("	 COA_CTR_CD," ).append("\n"); 
		query.append("	 COA_ACCT_CD," ).append("\n"); 
		query.append("	 COA_VVD_CD," ).append("\n"); 
		query.append("	 COA_INTER_CO_CD," ).append("\n"); 
		query.append("	 COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("	 COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("	 PPD_NO," ).append("\n"); 
		query.append("	 PPD_DTRB_NO," ).append("\n"); 
		query.append("	 PPD_APLY_AMT," ).append("\n"); 
		query.append("	 PPD_GL_DT," ).append("\n"); 
		query.append("	 'Y' APRO_FLG," ).append("\n"); 
		query.append("	 TAX_DECL_FLG," ).append("\n"); 
		query.append("	 @[csr_no] ERR_CSR_NO," ).append("\n"); 
		query.append("	 NULL IF_FLG," ).append("\n"); 
		query.append("	 NULL IF_DT," ).append("\n"); 
		query.append("	 NULL IF_ERR_RSN," ).append("\n"); 
		query.append("	 PPAY_APLY_FLG," ).append("\n"); 
		query.append("	 TJ_OFC_CD," ).append("\n"); 
		query.append("	 ACT_XCH_RT," ).append("\n"); 
		query.append("	 IMP_ERR_FLG," ).append("\n"); 
		query.append("	 NULL RCV_ERR_FLG," ).append("\n"); 
		query.append("	 TAX_CURR_XCH_FLG," ).append("\n"); 
		query.append("	 @[usr_eml] USR_EML," ).append("\n"); 
		query.append("	 IMP_ERR_RSN," ).append("\n"); 
		query.append("	 NULL RCV_ERR_RSN," ).append("\n"); 
		query.append("	 FTU_USE_CTNT1," ).append("\n"); 
		query.append("	 FTU_USE_CTNT2," ).append("\n"); 
		query.append("	 FTU_USE_CTNT3," ).append("\n"); 
		query.append("	 FTU_USE_CTNT4," ).append("\n"); 
		query.append("	 FTU_USE_CTNT5," ).append("\n"); 
		query.append("	 SYSDATE CRE_DT," ).append("\n"); 
		query.append("	 @[usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("	 EAI_EVNT_DT," ).append("\n"); 
		query.append("	 NULL AFT_ACT_FLG," ).append("\n"); 
		query.append("	 ESTM_ERR_RSN" ).append("\n"); 
		query.append("	 FROM AP_INV_HDR" ).append("\n"); 
		query.append("	 WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}