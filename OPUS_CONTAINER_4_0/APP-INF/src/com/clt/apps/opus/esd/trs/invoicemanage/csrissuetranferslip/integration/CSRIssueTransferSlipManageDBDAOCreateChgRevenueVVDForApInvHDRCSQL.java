/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvHDRCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvHDRCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateChgRevenueVVDForApInvHDR
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvHDRCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("USER_EMAIL",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEW_CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEW_VSL_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEW_SKD_DIR_CD",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("CRE_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEW_SKD_VOY_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEW_REV_DIR_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvHDRCSQL").append("\n"); 
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
		query.append("   CSR_NO" ).append("\n"); 
		query.append("  ,CSR_TP_CD" ).append("\n"); 
		query.append("  ,INV_DT" ).append("\n"); 
		query.append("  ,INV_TERM_DT" ).append("\n"); 
		query.append("  ,GL_DT" ).append("\n"); 
		query.append("  ,VNDR_NO" ).append("\n"); 
		query.append("  ,CSR_AMT" ).append("\n"); 
		query.append("  ,PAY_AMT" ).append("\n"); 
		query.append("  ,PAY_DT" ).append("\n"); 
		query.append("  ,CSR_CURR_CD" ).append("\n"); 
		query.append("  ,VNDR_TERM_NM" ).append("\n"); 
		query.append("  ,INV_DESC" ).append("\n"); 
		query.append("  ,ATTR_CATE_NM" ).append("\n"); 
		query.append("  ,ATTR_CTNT1" ).append("\n"); 
		query.append("  ,ATTR_CTNT2" ).append("\n"); 
		query.append("  ,ATTR_CTNT3" ).append("\n"); 
		query.append("  ,ATTR_CTNT4" ).append("\n"); 
		query.append("  ,ATTR_CTNT5" ).append("\n"); 
		query.append("  ,ATTR_CTNT6" ).append("\n"); 
		query.append("  ,ATTR_CTNT7" ).append("\n"); 
		query.append("  ,ATTR_CTNT8" ).append("\n"); 
		query.append("  ,ATTR_CTNT9" ).append("\n"); 
		query.append("  ,ATTR_CTNT10" ).append("\n"); 
		query.append("  ,ATTR_CTNT11" ).append("\n"); 
		query.append("  ,ATTR_CTNT12" ).append("\n"); 
		query.append("  ,ATTR_CTNT13" ).append("\n"); 
		query.append("  ,ATTR_CTNT14" ).append("\n"); 
		query.append("  ,ATTR_CTNT15" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("  ,GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("  ,SRC_CTNT" ).append("\n"); 
		query.append("  ,PAY_MZD_LU_CD" ).append("\n"); 
		query.append("  ,PAY_GRP_LU_CD" ).append("\n"); 
		query.append("  ,COA_CO_CD" ).append("\n"); 
		query.append("  ,COA_RGN_CD" ).append("\n"); 
		query.append("  ,COA_CTR_CD" ).append("\n"); 
		query.append("  ,COA_ACCT_CD" ).append("\n"); 
		query.append("  ,COA_VVD_CD" ).append("\n"); 
		query.append("  ,COA_INTER_CO_CD" ).append("\n"); 
		query.append("  ,COA_FTU_N1ST_CD" ).append("\n"); 
		query.append("  ,COA_FTU_N2ND_CD" ).append("\n"); 
		query.append("  ,PPD_NO" ).append("\n"); 
		query.append("  ,PPD_DTRB_NO" ).append("\n"); 
		query.append("  ,PPD_APLY_AMT" ).append("\n"); 
		query.append("  ,PPD_GL_DT" ).append("\n"); 
		query.append("  ,APRO_FLG" ).append("\n"); 
		query.append("  ,TAX_DECL_FLG" ).append("\n"); 
		query.append("  ,ERR_CSR_NO" ).append("\n"); 
		query.append("  ,IF_FLG" ).append("\n"); 
		query.append("  ,IF_DT" ).append("\n"); 
		query.append("  ,IF_ERR_RSN" ).append("\n"); 
		query.append("  ,PPAY_APLY_FLG" ).append("\n"); 
		query.append("  ,TJ_OFC_CD" ).append("\n"); 
		query.append("  ,ACT_XCH_RT" ).append("\n"); 
		query.append("  ,IMP_ERR_FLG" ).append("\n"); 
		query.append("  ,RCV_ERR_FLG" ).append("\n"); 
		query.append("  ,TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append("  ,USR_EML" ).append("\n"); 
		query.append("  ,IMP_ERR_RSN" ).append("\n"); 
		query.append("  ,RCV_ERR_RSN" ).append("\n"); 
		query.append("  ,FTU_USE_CTNT1" ).append("\n"); 
		query.append("  ,FTU_USE_CTNT2" ).append("\n"); 
		query.append("  ,FTU_USE_CTNT3" ).append("\n"); 
		query.append("  ,FTU_USE_CTNT4" ).append("\n"); 
		query.append("  ,FTU_USE_CTNT5" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,EAI_EVNT_DT" ).append("\n"); 
		query.append("  ,AFT_ACT_FLG" ).append("\n"); 
		query.append("  ,ESTM_ERR_RSN" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT @[NEW_CSR_NO]" ).append("\n"); 
		query.append("        ,'STANDARD'" ).append("\n"); 
		query.append("        ,INV_DT" ).append("\n"); 
		query.append("        ,INV_TERM_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(LAST_DAY(TO_DATE((SELECT C.EXE_YRMON" ).append("\n"); 
		query.append("                                    FROM LEA_REV_VVD_CNG C" ).append("\n"); 
		query.append("                                   WHERE C.CSR_NO = @[OLD_CSR_NO]" ).append("\n"); 
		query.append("                                     AND C.BKG_NO = @[BKG_NO]" ).append("\n"); 
		query.append("                                     AND C.INV_SYS_ID = 'TRS'" ).append("\n"); 
		query.append("                                     AND C.NEW_VSL_CD = @[NEW_VSL_CD]" ).append("\n"); 
		query.append("                                     AND C.NEW_SKD_VOY_NO = @[NEW_SKD_VOY_NO]" ).append("\n"); 
		query.append("                                     AND C.NEW_SKD_DIR_CD = @[NEW_SKD_DIR_CD]" ).append("\n"); 
		query.append("                                     AND C.NEW_REV_DIR_CD = @[NEW_REV_DIR_CD])," ).append("\n"); 
		query.append("                                  'YYYYMM'))," ).append("\n"); 
		query.append("                 'YYYYMMDD')" ).append("\n"); 
		query.append("        ,VNDR_NO" ).append("\n"); 
		query.append("        ,0" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,CSR_CURR_CD" ).append("\n"); 
		query.append("        ,VNDR_TERM_NM" ).append("\n"); 
		query.append("        ,INV_DESC" ).append("\n"); 
		query.append("        ,ATTR_CATE_NM" ).append("\n"); 
		query.append("        ,ATTR_CTNT1" ).append("\n"); 
		query.append("        ,ATTR_CTNT2" ).append("\n"); 
		query.append("        ,ATTR_CTNT3" ).append("\n"); 
		query.append("        ,ATTR_CTNT4" ).append("\n"); 
		query.append("        ,ATTR_CTNT5" ).append("\n"); 
		query.append("        ,ATTR_CTNT6" ).append("\n"); 
		query.append("        ,ATTR_CTNT7" ).append("\n"); 
		query.append("        ,ATTR_CTNT8" ).append("\n"); 
		query.append("        ,ATTR_CTNT9" ).append("\n"); 
		query.append("        ,ATTR_CTNT10" ).append("\n"); 
		query.append("        ,ATTR_CTNT11" ).append("\n"); 
		query.append("        ,ATTR_CTNT12" ).append("\n"); 
		query.append("        ,ATTR_CTNT13" ).append("\n"); 
		query.append("        ,ATTR_CTNT14" ).append("\n"); 
		query.append("        ,ATTR_CTNT15" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("        ,GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("        ,SRC_CTNT" ).append("\n"); 
		query.append("        ,PAY_MZD_LU_CD" ).append("\n"); 
		query.append("        ,PAY_GRP_LU_CD" ).append("\n"); 
		query.append("        ,COA_CO_CD" ).append("\n"); 
		query.append("        ,COA_RGN_CD" ).append("\n"); 
		query.append("        ,COA_CTR_CD" ).append("\n"); 
		query.append("        ,COA_ACCT_CD" ).append("\n"); 
		query.append("        ,COA_VVD_CD" ).append("\n"); 
		query.append("        ,COA_INTER_CO_CD" ).append("\n"); 
		query.append("        ,COA_FTU_N1ST_CD" ).append("\n"); 
		query.append("        ,COA_FTU_N2ND_CD" ).append("\n"); 
		query.append("        ,PPD_NO" ).append("\n"); 
		query.append("        ,PPD_DTRB_NO" ).append("\n"); 
		query.append("        ,PPD_APLY_AMT" ).append("\n"); 
		query.append("        ,PPD_GL_DT" ).append("\n"); 
		query.append("        ,'Y'" ).append("\n"); 
		query.append("        ,TAX_DECL_FLG" ).append("\n"); 
		query.append("        ,CSR_NO" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,PPAY_APLY_FLG" ).append("\n"); 
		query.append("        ,TJ_OFC_CD" ).append("\n"); 
		query.append("        ,ACT_XCH_RT" ).append("\n"); 
		query.append("        ,IMP_ERR_FLG" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append("        ,@[USER_EMAIL]" ).append("\n"); 
		query.append("        ,IMP_ERR_RSN" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,FTU_USE_CTNT1" ).append("\n"); 
		query.append("        ,FTU_USE_CTNT2" ).append("\n"); 
		query.append("        ,FTU_USE_CTNT3" ).append("\n"); 
		query.append("        ,FTU_USE_CTNT4" ).append("\n"); 
		query.append("        ,FTU_USE_CTNT5" ).append("\n"); 
		query.append("        ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[CRE_OFC_CD])" ).append("\n"); 
		query.append("        ,@[CRE_USR_ID]" ).append("\n"); 
		query.append("        ,EAI_EVNT_DT" ).append("\n"); 
		query.append("        ,NULL" ).append("\n"); 
		query.append("        ,ESTM_ERR_RSN" ).append("\n"); 
		query.append("    FROM AP_INV_HDR" ).append("\n"); 
		query.append("   WHERE CSR_NO = @[OLD_CSR_NO]" ).append("\n"); 
		query.append("     AND SRC_CTNT = 'SO_TRANS'" ).append("\n"); 

	}
}