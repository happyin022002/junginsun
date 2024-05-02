/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DaoNameDAOSPCLCmpnCSRHeaderVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.10 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSPCLCmpnCSRHeaderVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCLCmpnCSRHeaderVO
	  * </pre>
	  */
	public DaoNameDAOSPCLCmpnCSRHeaderVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo").append("\n"); 
		query.append("FileName : DaoNameDAOSPCLCmpnCSRHeaderVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("/* FFCMPNCSRHEADER */" ).append("\n"); 
		query.append("'' IMP_ERR_FLG" ).append("\n"); 
		query.append(",'' IF_DT" ).append("\n"); 
		query.append(",'' PAY_DT" ).append("\n"); 
		query.append(",'' RCV_ERR_RSN" ).append("\n"); 
		query.append(",'' GL_DT" ).append("\n"); 
		query.append(",'' ATTR_CTNT10" ).append("\n"); 
		query.append(",'' CSR_CURR_CD" ).append("\n"); 
		query.append(",'' ATTR_CTNT14" ).append("\n"); 
		query.append(",'' COA_RGN_CD" ).append("\n"); 
		query.append(",'' ATTR_CTNT13" ).append("\n"); 
		query.append(",'' PPD_NO" ).append("\n"); 
		query.append(",'' ATTR_CTNT12" ).append("\n"); 
		query.append(",'' ATTR_CTNT11" ).append("\n"); 
		query.append(",'' PPD_DTRB_NO" ).append("\n"); 
		query.append(",'' ATTR_CTNT15" ).append("\n"); 
		query.append(",'' INV_DESC" ).append("\n"); 
		query.append(",'' VNDR_NO" ).append("\n"); 
		query.append(",'' PAY_AMT" ).append("\n"); 
		query.append(",'' PPD_GL_DT" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT2" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT1" ).append("\n"); 
		query.append(",'' USR_EML" ).append("\n"); 
		query.append(",'' APRO_FLG" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT5" ).append("\n"); 
		query.append(",'' ATTR_CATE_NM" ).append("\n"); 
		query.append(",'' CSR_TP_CD" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT4" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT3" ).append("\n"); 
		query.append(",'' INV_DT" ).append("\n"); 
		query.append(",'' RCV_ERR_FLG" ).append("\n"); 
		query.append(",'' CSR_NO" ).append("\n"); 
		query.append(",'' PAY_GRP_LU_CD" ).append("\n"); 
		query.append(",'' IF_FLG" ).append("\n"); 
		query.append(",'' PPAY_APLY_FLG" ).append("\n"); 
		query.append(",'' COA_CO_CD" ).append("\n"); 
		query.append(",'' ERR_CSR_NO" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' PAY_MZD_LU_CD" ).append("\n"); 
		query.append(",'' INV_TERM_DT" ).append("\n"); 
		query.append(",'' TAX_DECL_FLG" ).append("\n"); 
		query.append(",'' COA_INTER_CO_CD" ).append("\n"); 
		query.append(",'' COA_ACCT_CD" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' ATTR_CTNT9" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(",'' ATTR_CTNT8" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(",'' IF_ERR_RSN" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(",'' ATTR_CTNT1" ).append("\n"); 
		query.append(",'' TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append(",'' COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",'' ATTR_CTNT2" ).append("\n"); 
		query.append(",'' ATTR_CTNT3" ).append("\n"); 
		query.append(",'' ATTR_CTNT4" ).append("\n"); 
		query.append(",'' ATTR_CTNT5" ).append("\n"); 
		query.append(",'' TJ_OFC_CD" ).append("\n"); 
		query.append(",'' ATTR_CTNT6" ).append("\n"); 
		query.append(",'' ATTR_CTNT7" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(",'' ACT_XCH_RT" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(",'' PPD_APLY_AMT" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(",'' VNDR_TERM_NM" ).append("\n"); 
		query.append(",'' GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(",'' COA_CTR_CD" ).append("\n"); 
		query.append(",'' EAI_EVNT_DT" ).append("\n"); 
		query.append(",'' COA_VVD_CD" ).append("\n"); 
		query.append(",'' COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",'' IMP_ERR_RSN" ).append("\n"); 
		query.append(",'' CSR_AMT" ).append("\n"); 
		query.append(",'' SRC_CTNT" ).append("\n"); 
		query.append(",'' USR_ID" ).append("\n"); 
		query.append(",'' USR_NM" ).append("\n"); 
		query.append(",'' USR_EM" ).append("\n"); 
		query.append(",'' AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("/* MASTER */" ).append("\n"); 
		query.append(",'' DATE_FM" ).append("\n"); 
		query.append(",'' IF_DT" ).append("\n"); 
		query.append(",'' PAY_DT" ).append("\n"); 
		query.append(",'' TOT_AMT" ).append("\n"); 
		query.append(",'' IF_OPT" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' FF_CNT_SEQ" ).append("\n"); 
		query.append(",'' INV_DESC" ).append("\n"); 
		query.append(",'' PAY_AMT" ).append("\n"); 
		query.append(",'' DATE_DIV" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT1" ).append("\n"); 
		query.append(",'' INV_DT" ).append("\n"); 
		query.append(",'' CSR_NO" ).append("\n"); 
		query.append(",'' VNDR_TERM_NM" ).append("\n"); 
		query.append(",'' AP_OFC_CD" ).append("\n"); 
		query.append(",'' TOT_CNT" ).append("\n"); 
		query.append(",'' DATE_TO" ).append("\n"); 
		query.append(",'' IF_FLG" ).append("\n"); 
		query.append(",'' RCV_FLG" ).append("\n"); 
		query.append(",'' CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",'' IF_RSN" ).append("\n"); 
		query.append(",'' RCV_RSN" ).append("\n"); 
		query.append(",'' PAY_MZD_LU_CD" ).append("\n"); 
		query.append(",'' VNDR_SEQ" ).append("\n"); 
		query.append(",'' FF_CNT_CD" ).append("\n"); 
		query.append(",'' COA_INTER_COMPY_CD" ).append("\n"); 
		query.append(",'' INV_TAX_RT" ).append("\n"); 
		query.append(",'' CUST_CNT_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}