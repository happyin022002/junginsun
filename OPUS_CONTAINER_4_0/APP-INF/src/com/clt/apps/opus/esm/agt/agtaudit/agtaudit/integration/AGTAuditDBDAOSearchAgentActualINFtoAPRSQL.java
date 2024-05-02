/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOSearchAgentActualINFtoAPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOSearchAgentActualINFtoAPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAgentActualINFtoAP
	  * </pre>
	  */
	public AGTAuditDBDAOSearchAgentActualINFtoAPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOSearchAgentActualINFtoAPRSQL").append("\n"); 
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
		query.append("SELECT 'FNS008-0003' AS IF_ID," ).append("\n"); 
		query.append("'' AS SEQ," ).append("\n"); 
		query.append("(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE CSR_NO = A.CSR_NO ) AS TTL_ROW_KNT," ).append("\n"); 
		query.append("ROWNUM AS ROW_KNT," ).append("\n"); 
		query.append("A.CSR_NO AS HDR_CSR_NO," ).append("\n"); 
		query.append("A.CSR_TP_CD AS HDR_CSR_TP_CD," ).append("\n"); 
		query.append("ROUND(A.INV_DT, 2) AS HDR_INV_DT," ).append("\n"); 
		query.append("A.INV_TERM_DT AS HDR_INV_TERM_DT," ).append("\n"); 
		query.append("A.GL_DT AS HDR_GL_DT," ).append("\n"); 
		query.append("A.VNDR_NO AS HDR_VNDR_NO," ).append("\n"); 
		query.append("A.CSR_AMT AS HDR_CSR_AMT," ).append("\n"); 
		query.append("A.PAY_AMT AS HDR_PAY_AMT," ).append("\n"); 
		query.append("A.PAY_DT AS HDR_PAY_DT," ).append("\n"); 
		query.append("A.CSR_CURR_CD AS HDR_CSR_CURR_CD," ).append("\n"); 
		query.append("A.VNDR_TERM_NM AS HDR_VNDR_TERM_NM," ).append("\n"); 
		query.append("A.INV_DESC AS HDR_INV_DESC," ).append("\n"); 
		query.append("A.ATTR_CATE_NM AS HDR_ATTR_CATE_NM," ).append("\n"); 
		query.append("A.ATTR_CTNT1 AS HDR_ATTR_CTNT1," ).append("\n"); 
		query.append("A.ATTR_CTNT2 AS HDR_ATTR_CTNT2," ).append("\n"); 
		query.append("A.ATTR_CTNT3 AS HDR_ATTR_CTNT3," ).append("\n"); 
		query.append("A.ATTR_CTNT4 AS HDR_ATTR_CTNT4," ).append("\n"); 
		query.append("A.ATTR_CTNT5 AS HDR_ATTR_CTNT5," ).append("\n"); 
		query.append("A.ATTR_CTNT6 AS HDR_ATTR_CTNT6," ).append("\n"); 
		query.append("A.ATTR_CTNT7 AS HDR_ATTR_CTNT7," ).append("\n"); 
		query.append("A.ATTR_CTNT8 AS HDR_ATTR_CTNT8," ).append("\n"); 
		query.append("A.ATTR_CTNT9 AS HDR_ATTR_CTNT9," ).append("\n"); 
		query.append("A.ATTR_CTNT10 AS HDR_ATTR_CTNT10," ).append("\n"); 
		query.append("A.ATTR_CTNT11 AS HDR_ATTR_CTNT11," ).append("\n"); 
		query.append("A.ATTR_CTNT12 AS HDR_ATTR_CTNT12," ).append("\n"); 
		query.append("A.ATTR_CTNT13 AS HDR_ATTR_CTNT13," ).append("\n"); 
		query.append("A.ATTR_CTNT14 AS HDR_ATTR_CTNT14," ).append("\n"); 
		query.append("A.ATTR_CTNT15 AS HDR_ATTR_CTNT15," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT1 AS HDR_GLO_ATTR_CTNT1," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT2 AS HDR_GLO_ATTR_CTNT2," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT3 AS HDR_GLO_ATTR_CTNT3," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT4 AS HDR_GLO_ATTR_CTNT4," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT5 AS HDR_GLO_ATTR_CTNT5," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT6 AS HDR_GLO_ATTR_CTNT6," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT7 AS HDR_GLO_ATTR_CTNT7," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT8 AS HDR_GLO_ATTR_CTNT8," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT9 AS HDR_GLO_ATTR_CTNT9," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT10 AS HDR_GLO_ATTR_CTNT10," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT11 AS HDR_GLO_ATTR_CTNT11," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT12 AS HDR_GLO_ATTR_CTNT12," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT13 AS HDR_GLO_ATTR_CTNT13," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT14 AS HDR_GLO_ATTR_CTNT14," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT15 AS HDR_GLO_ATTR_CTNT15," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT16 AS HDR_GLO_ATTR_CTNT16," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT17 AS HDR_GLO_ATTR_CTNT17," ).append("\n"); 
		query.append("A.GLO_ATTR_CTNT18 AS HDR_GLO_ATTR_CTNT18," ).append("\n"); 
		query.append("A.SRC_CTNT AS HDR_SRC_CTNT," ).append("\n"); 
		query.append("A.PAY_MZD_LU_CD AS HDR_PAY_MZD_LU_CD," ).append("\n"); 
		query.append("A.PAY_GRP_LU_CD AS HDR_PAY_GRP_LU_CD," ).append("\n"); 
		query.append("A.COA_CO_CD AS HDR_COA_CO_CD," ).append("\n"); 
		query.append("A.COA_RGN_CD AS HDR_COA_RGN_CD," ).append("\n"); 
		query.append("A.COA_CTR_CD AS HDR_COA_CTR_CD," ).append("\n"); 
		query.append("A.COA_ACCT_CD AS HDR_COA_ACCT_CD," ).append("\n"); 
		query.append("A.COA_VVD_CD AS HDR_COA_VVD_CD," ).append("\n"); 
		query.append("A.COA_INTER_CO_CD AS HDR_COA_INTER_CO_CD," ).append("\n"); 
		query.append("A.COA_FTU_N1ST_CD AS HDR_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("A.COA_FTU_N2ND_CD AS HDR_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("A.PPD_NO AS HDR_PPD_NO," ).append("\n"); 
		query.append("A.PPD_DTRB_NO AS HDR_PPD_DTRB_NO," ).append("\n"); 
		query.append("A.PPD_APLY_AMT AS HDR_PPD_APLY_AMT," ).append("\n"); 
		query.append("A.PPD_GL_DT AS HDR_PPD_GL_DT," ).append("\n"); 
		query.append("A.APRO_FLG AS HDR_APRO_FLG," ).append("\n"); 
		query.append("A.TAX_DECL_FLG AS HDR_TAX_DECL_FLG," ).append("\n"); 
		query.append("A.ERR_CSR_NO AS HDR_ERR_CSR_NO," ).append("\n"); 
		query.append("A.IF_FLG AS HDR_IF_FLG," ).append("\n"); 
		query.append("NULL AS HDR_IF_DT," ).append("\n"); 
		query.append("NULL AS HDR_IF_ERR_RSN," ).append("\n"); 
		query.append("A.PPAY_APLY_FLG AS HDR_PPAY_APLY_FLG," ).append("\n"); 
		query.append("A.TJ_OFC_CD AS HDR_TJ_OFC_CD," ).append("\n"); 
		query.append("A.ACT_XCH_RT AS HDR_ACT_XCH_RT," ).append("\n"); 
		query.append("A.IMP_ERR_FLG AS HDR_IMP_ERR_FLG," ).append("\n"); 
		query.append("A.RCV_ERR_FLG AS HDR_RCV_ERR_FLG," ).append("\n"); 
		query.append("A.TAX_CURR_XCH_FLG AS HDR_TAX_CURR_XCH_FLG," ).append("\n"); 
		query.append("A.USR_EML AS HDR_USR_EML," ).append("\n"); 
		query.append("A.IMP_ERR_RSN AS HDR_IMP_ERR_RSN," ).append("\n"); 
		query.append("A.RCV_ERR_RSN AS HDR_RCV_ERR_RSN," ).append("\n"); 
		query.append("A.FTU_USE_CTNT1 AS HDR_FTU_USE_CTNT1," ).append("\n"); 
		query.append("A.FTU_USE_CTNT2 AS HDR_FTU_USE_CTNT2," ).append("\n"); 
		query.append("A.FTU_USE_CTNT3 AS HDR_FTU_USE_CTNT3," ).append("\n"); 
		query.append("A.FTU_USE_CTNT4 AS HDR_FTU_USE_CTNT4," ).append("\n"); 
		query.append("A.FTU_USE_CTNT5 AS HDR_FTU_USE_CTNT5," ).append("\n"); 
		query.append("B.CSR_NO AS CSR_NO," ).append("\n"); 
		query.append("B.LINE_SEQ AS LINE_SEQ," ).append("\n"); 
		query.append("B.LINE_NO AS LINE_NO," ).append("\n"); 
		query.append("B.LINE_TP_LU_CD AS LINE_TP_LU_CD," ).append("\n"); 
		query.append("ROUND(B.INV_AMT, 2) AS INV_AMT," ).append("\n"); 
		query.append("B.INV_DESC AS INV_DESC," ).append("\n"); 
		query.append("B.INV_TAX_CD AS INV_TAX_CD," ).append("\n"); 
		query.append("B.DTRB_COA_CO_CD AS DTRB_COA_CO_CD," ).append("\n"); 
		query.append("B.DTRB_COA_RGN_CD AS DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("B.DTRB_COA_CTR_CD AS DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("B.DTRB_COA_ACCT_CD AS DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("B.DTRB_COA_VVD_CD AS DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("B.DTRB_COA_INTER_CO_CD AS DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("B.DTRB_COA_FTU_N1ST_CD AS DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("B.DTRB_COA_FTU_N2ND_CD AS DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("B.ATTR_CATE_NM AS ATTR_CATE_NM," ).append("\n"); 
		query.append("B.ATTR_CTNT1 AS ATTR_CTNT1," ).append("\n"); 
		query.append("B.ATTR_CTNT2 AS ATTR_CTNT2," ).append("\n"); 
		query.append("B.ATTR_CTNT3 AS ATTR_CTNT3," ).append("\n"); 
		query.append("B.ATTR_CTNT4 AS ATTR_CTNT4," ).append("\n"); 
		query.append("B.ATTR_CTNT5 AS ATTR_CTNT5," ).append("\n"); 
		query.append("B.ATTR_CTNT6 AS ATTR_CTNT6," ).append("\n"); 
		query.append("B.ATTR_CTNT7 AS ATTR_CTNT7," ).append("\n"); 
		query.append("B.ATTR_CTNT8 AS ATTR_CTNT8," ).append("\n"); 
		query.append("B.ATTR_CTNT9 AS ATTR_CTNT9," ).append("\n"); 
		query.append("B.ATTR_CTNT10 AS ATTR_CTNT10," ).append("\n"); 
		query.append("B.ATTR_CTNT11 AS ATTR_CTNT11," ).append("\n"); 
		query.append("B.ATTR_CTNT12 AS ATTR_CTNT12," ).append("\n"); 
		query.append("B.ATTR_CTNT13 AS ATTR_CTNT13," ).append("\n"); 
		query.append("B.ATTR_CTNT14 AS ATTR_CTNT14," ).append("\n"); 
		query.append("B.ATTR_CTNT15 AS ATTR_CTNT15," ).append("\n"); 
		query.append("B.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("B.ACT_VVD_CD AS ACT_VVD_CD," ).append("\n"); 
		query.append("B.PLN_SCTR_DIV_CD AS PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("B.SO_CRR_CD AS SO_CRR_CD," ).append("\n"); 
		query.append("B.YD_CD AS YD_CD," ).append("\n"); 
		query.append("B.FTU_USE_CTNT1 AS FTU_USE_CTNT1," ).append("\n"); 
		query.append("B.FTU_USE_CTNT2 AS FTU_USE_CTNT2," ).append("\n"); 
		query.append("B.FTU_USE_CTNT3 AS FTU_USE_CTNT3," ).append("\n"); 
		query.append("B.FTU_USE_CTNT4 AS FTU_USE_CTNT4," ).append("\n"); 
		query.append("B.FTU_USE_CTNT5 AS FTU_USE_CTNT5" ).append("\n"); 
		query.append("FROM AP_INV_HDR  A," ).append("\n"); 
		query.append("AP_INV_DTRB B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR (GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD),'YYYYMMDD') AS LOCAL_DT" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE (VNDR_CNT_CD,'CN',AR_OFC_CD,AGN_CD)" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE A.CSR_NO           = @[csr_no]" ).append("\n"); 
		query.append("AND A.CSR_NO           = B.CSR_NO" ).append("\n"); 
		query.append("AND NVL(A.IF_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY B.CSR_NO," ).append("\n"); 
		query.append("B.LINE_SEQ," ).append("\n"); 
		query.append("B.LINE_NO" ).append("\n"); 

	}
}