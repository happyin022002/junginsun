/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DaoNameDAOSPCLCmpnCSRINFtoAPVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.04 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSPCLCmpnCSRINFtoAPVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCLCmpnCSRINFtoAPVO
	  * </pre>
	  */
	public DaoNameDAOSPCLCmpnCSRINFtoAPVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo ").append("\n"); 
		query.append("FileName : DaoNameDAOSPCLCmpnCSRINFtoAPVORSQL").append("\n"); 
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
		query.append("'' HDR_CSR_NO" ).append("\n"); 
		query.append(",'' HDR_COA_ACCT_CD" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT2" ).append("\n"); 
		query.append(",'' HDR_COA_VVD_CD" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT1" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT5" ).append("\n"); 
		query.append(",'' ATTR_CATE_NM" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT4" ).append("\n"); 
		query.append(",'' FTU_USE_CTNT3" ).append("\n"); 
		query.append(",'' HDR_PAY_AMT" ).append("\n"); 
		query.append(",'' HDR_PAY_GRP_LU_CD" ).append("\n"); 
		query.append(",'' INV_TAX_CD" ).append("\n"); 
		query.append(",'' HDR_IF_DT" ).append("\n"); 
		query.append(",'' HDR_SRC_CTNT" ).append("\n"); 
		query.append(",'' HDR_PPD_APLY_AMT" ).append("\n"); 
		query.append(",'' HDR_FTU_USE_CTNT1" ).append("\n"); 
		query.append(",'' HDR_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",'' HDR_FTU_USE_CTNT2" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' HDR_FTU_USE_CTNT3" ).append("\n"); 
		query.append(",'' HDR_FTU_USE_CTNT4" ).append("\n"); 
		query.append(",'' HDR_RCV_ERR_FLG" ).append("\n"); 
		query.append(",'' HDR_COA_CO_CD" ).append("\n"); 
		query.append(",'' HDR_ERR_CSR_NO" ).append("\n"); 
		query.append(",'' HDR_FTU_USE_CTNT5" ).append("\n"); 
		query.append(",'' DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(",'' HDR_ACT_XCH_RT" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(",'' HDR_PAY_MZD_LU_CD" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT5" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT4" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT3" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT2" ).append("\n"); 
		query.append(",'' HDR_CSR_TP_CD" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT1" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT9" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT8" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT7" ).append("\n"); 
		query.append(",'' DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",'' DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT6" ).append("\n"); 
		query.append(",'' HDR_GL_DT" ).append("\n"); 
		query.append(",'' SO_CRR_CD" ).append("\n"); 
		query.append(",'' HDR_INV_DESC" ).append("\n"); 
		query.append(",'' YD_CD" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(",'' HDR_INV_TERM_DT" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(",'' HDR_IMP_ERR_FLG" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(",'' HDR_PPD_NO" ).append("\n"); 
		query.append(",'' HDR_RCV_ERR_RSN" ).append("\n"); 
		query.append(",'' ATTR_CTNT10" ).append("\n"); 
		query.append(",'' ATTR_CTNT14" ).append("\n"); 
		query.append(",'' ATTR_CTNT13" ).append("\n"); 
		query.append(",'' ATTR_CTNT12" ).append("\n"); 
		query.append(",'' ATTR_CTNT11" ).append("\n"); 
		query.append(",'' HDR_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",'' HDR_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",'' ATTR_CTNT15" ).append("\n"); 
		query.append(",'' HDR_PPD_DTRB_NO" ).append("\n"); 
		query.append(",'' HDR_IF_FLG" ).append("\n"); 
		query.append(",'' HDR_TJ_OFC_CD" ).append("\n"); 
		query.append(",'' INV_DESC" ).append("\n"); 
		query.append(",'' HDR_CSR_CURR_CD" ).append("\n"); 
		query.append(",'' HDR_COA_RGN_CD" ).append("\n"); 
		query.append(",'' HDR_COA_CTR_CD" ).append("\n"); 
		query.append(",'' HDR_INV_DT" ).append("\n"); 
		query.append(",'' HDR_TAX_DECL_FLG" ).append("\n"); 
		query.append(",'' CSR_NO" ).append("\n"); 
		query.append(",'' HDR_VNDR_NO" ).append("\n"); 
		query.append(",'' ROW_KNT" ).append("\n"); 
		query.append(",'' HDR_IMP_ERR_RSN" ).append("\n"); 
		query.append(",'' LINE_NO" ).append("\n"); 
		query.append(",'' TTL_ROW_KNT" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT14" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT13" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT15" ).append("\n"); 
		query.append(",'' HDR_CSR_AMT" ).append("\n"); 
		query.append(",'' LIF_ID" ).append("\n"); 
		query.append(",'' HDR_VNDR_TERM_NM" ).append("\n"); 
		query.append(",'' ACT_VVD_CD" ).append("\n"); 
		query.append(",'' DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",'' LINE_SEQ" ).append("\n"); 
		query.append(",'' HDR_IF_ERR_RSN" ).append("\n"); 
		query.append(",'' HDR_USR_EML" ).append("\n"); 
		query.append(",'' ATTR_CTNT9" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT11" ).append("\n"); 
		query.append(",'' ATTR_CTNT8" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT12" ).append("\n"); 
		query.append(",'' HDR_ATTR_CTNT10" ).append("\n"); 
		query.append(",'' HDR_PAY_DT" ).append("\n"); 
		query.append(",'' ATTR_CTNT1" ).append("\n"); 
		query.append(",'' DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",'' ATTR_CTNT2" ).append("\n"); 
		query.append(",'' ATTR_CTNT3" ).append("\n"); 
		query.append(",'' ATTR_CTNT4" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(",'' ATTR_CTNT5" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(",'' HDR_PPAY_APLY_FLG" ).append("\n"); 
		query.append(",'' ATTR_CTNT6" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(",'' ATTR_CTNT7" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(",'' HDR_PPD_GL_DT" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(",'' INV_AMT" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(",'' LINE_TP_LU_CD" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(",'' HDR_GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(",'' DTRB_COA_CO_CD" ).append("\n"); 
		query.append(",'' DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(",'' PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(",'' HDR_APRO_FLG" ).append("\n"); 
		query.append(",'' HDR_TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append(",'' DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(",'' SEQ" ).append("\n"); 
		query.append(",'' HDR_ATTR_CATE_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}