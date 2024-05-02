/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchApSlipInterfaceListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.05.13 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchApSlipInterfaceListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Interface를 위한 데이터 조회
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchApSlipInterfaceListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchApSlipInterfaceListVORSQL").append("\n"); 
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
		query.append("		ROWNUM RNUM" ).append("\n"); 
		query.append("        ,C.TOT_CNT TTL_ROW_KNT " ).append("\n"); 
		query.append("        ,A.CSR_NO                               HDR_CSR_NO" ).append("\n"); 
		query.append("		,A.CSR_TP_CD                            HDR_CSR_TP_CD" ).append("\n"); 
		query.append("		,TO_CHAR(TO_DATE(A.INV_DT,'yyyymmdd'), 'yyyymmddhh24miss')               HDR_INV_DT" ).append("\n"); 
		query.append("		,TO_CHAR(TO_DATE(A.INV_TERM_DT,'yyyymmdd'), 'yyyymmddhh24miss')          HDR_INV_TERM_DT" ).append("\n"); 
		query.append("		,TO_CHAR(TO_DATE(A.GL_DT,'yyyymmdd'), 'yyyymmddhh24miss')                HDR_GL_DT" ).append("\n"); 
		query.append("		,A.VNDR_NO                              HDR_VNDR_NO" ).append("\n"); 
		query.append("		,A.CSR_AMT                              HDR_CSR_AMT" ).append("\n"); 
		query.append("		,A.PAY_AMT                              HDR_PAY_AMT" ).append("\n"); 
		query.append("		,A.PAY_DT                               HDR_PAY_DT" ).append("\n"); 
		query.append("		,A.CSR_CURR_CD                          HDR_CSR_CURR_CD" ).append("\n"); 
		query.append("		,A.VNDR_TERM_NM    HDR_VNDR_TERM_NM" ).append("\n"); 
		query.append("		,A.INV_DESC        HDR_INV_DESC" ).append("\n"); 
		query.append("		,A.ATTR_CATE_NM    HDR_ATTR_CATE_NM" ).append("\n"); 
		query.append("		,A.ATTR_CTNT1      HDR_ATTR_CTNT1" ).append("\n"); 
		query.append("--AIS6020172" ).append("\n"); 
		query.append("--SELECT SUBSTR('AIS6020172',1,3) || SUBSTR('AIS6020172',7,4) || SUBSTR('AIS6020172',4,3)  FROM DUAL;  " ).append("\n"); 
		query.append("--AIS0172602 " ).append("\n"); 
		query.append("--select substrb('AIS0172602', 1,3)||substrb('AIS0172602',8,3)||substrb('AIS0172602',4,4) from dual;" ).append("\n"); 
		query.append("--AIS6020172" ).append("\n"); 
		query.append("--사업자 등록번호랑 ASA가 HDR_ATTR_CTNT2에 같이 쓰임" ).append("\n"); 
		query.append("		,( " ).append("\n"); 
		query.append("            CASE WHEN (" ).append("\n"); 
		query.append("                       SELECT NVL(LENGTH(ASA_NO),1) FROM FMS_CONSULTATION A" ).append("\n"); 
		query.append("                       WHERE A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("                       ) = 1 THEN A.ATTR_CTNT2" ).append("\n"); 
		query.append("                 ELSE SUBSTR(A.ATTR_CTNT2,1,3) || SUBSTR(A.ATTR_CTNT2,7,4) || SUBSTR(A.ATTR_CTNT2,4,3)" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("         ) AS HDR_ATTR_CTNT2 " ).append("\n"); 
		query.append("		,A.ATTR_CTNT3      HDR_ATTR_CTNT3" ).append("\n"); 
		query.append("		,A.ATTR_CTNT4      HDR_ATTR_CTNT4" ).append("\n"); 
		query.append("		,A.ATTR_CTNT5      HDR_ATTR_CTNT5" ).append("\n"); 
		query.append("		,A.ATTR_CTNT6      HDR_ATTR_CTNT6" ).append("\n"); 
		query.append("		,A.ATTR_CTNT7      HDR_ATTR_CTNT7" ).append("\n"); 
		query.append("		,A.ATTR_CTNT8      HDR_ATTR_CTNT8" ).append("\n"); 
		query.append("		,A.ATTR_CTNT9      HDR_ATTR_CTNT9" ).append("\n"); 
		query.append("		,A.ATTR_CTNT10     HDR_ATTR_CTNT10" ).append("\n"); 
		query.append("		,A.ATTR_CTNT11     HDR_ATTR_CTNT11" ).append("\n"); 
		query.append("		,A.ATTR_CTNT12     HDR_ATTR_CTNT12" ).append("\n"); 
		query.append("		,A.ATTR_CTNT13     HDR_ATTR_CTNT13" ).append("\n"); 
		query.append("		,A.ATTR_CTNT14     HDR_ATTR_CTNT14" ).append("\n"); 
		query.append("		,A.ATTR_CTNT15     HDR_ATTR_CTNT15" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT1  HDR_GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT2  HDR_GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT3  HDR_GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT4  HDR_GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT5  HDR_GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT6  HDR_GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT7  HDR_GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT8  HDR_GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT9  HDR_GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT10 HDR_GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT11 HDR_GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT12 HDR_GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT13 HDR_GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT14 HDR_GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT15 HDR_GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT16 HDR_GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT17 HDR_GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("		,A.GLO_ATTR_CTNT18 HDR_GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("		,A.SRC_CTNT                             HDR_SRC_CTNT" ).append("\n"); 
		query.append("		,A.PAY_MZD_LU_CD                        HDR_PAY_MZD_LU_CD" ).append("\n"); 
		query.append("		,A.PAY_GRP_LU_CD   HDR_PAY_GRP_LU_CD" ).append("\n"); 
		query.append("		,A.COA_CO_CD                            HDR_COA_CO_CD" ).append("\n"); 
		query.append("--		,A.COA_RGN_CD                           HDR_COA_RGN_CD" ).append("\n"); 
		query.append("-- OFFICE에 따른 지역 코드를 조회" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("            SELECT O.FINC_RGN_CD" ).append("\n"); 
		query.append("            FROM   MDM_ORGANIZATION O" ).append("\n"); 
		query.append("            WHERE O.OFC_CD = A.TJ_OFC_CD        " ).append("\n"); 
		query.append("         ) AS HDR_COA_RGN_CD" ).append("\n"); 
		query.append("		,A.COA_CTR_CD                           HDR_COA_CTR_CD" ).append("\n"); 
		query.append("		,A.COA_ACCT_CD                          HDR_COA_ACCT_CD" ).append("\n"); 
		query.append("		,A.COA_VVD_CD                           HDR_COA_VVD_CD" ).append("\n"); 
		query.append("		,A.COA_INTER_CO_CD                      HDR_COA_INTER_CO_CD" ).append("\n"); 
		query.append("		,A.COA_FTU_N1ST_CD                      HDR_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append("		,A.COA_FTU_N2ND_CD                      HDR_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append("		,A.PPD_NO                               HDR_PPD_NO" ).append("\n"); 
		query.append("		,A.PPD_DTRB_NO                          HDR_PPD_DTRB_NO" ).append("\n"); 
		query.append("		,A.PPD_APLY_AMT                         HDR_PPD_APLY_AMT" ).append("\n"); 
		query.append("		,TO_CHAR(TO_DATE(A.PPD_GL_DT,'yyyymmdd'), 'yyyymmddhh24miss')            HDR_PPD_GL_DT" ).append("\n"); 
		query.append("		,A.APRO_FLG                             HDR_APRO_FLG" ).append("\n"); 
		query.append("		,A.TAX_DECL_FLG                         HDR_TAX_DECL_FLG" ).append("\n"); 
		query.append("		,A.ERR_CSR_NO                           HDR_ERR_CSR_NO" ).append("\n"); 
		query.append("		,A.IF_FLG                               HDR_IF_FLG" ).append("\n"); 
		query.append("		,A.IF_DT                                HDR_IF_DT" ).append("\n"); 
		query.append("		,A.IF_ERR_RSN                           HDR_IF_ERR_RSN" ).append("\n"); 
		query.append("		,A.PPAY_APLY_FLG                        HDR_PPAY_APLY_FLG" ).append("\n"); 
		query.append("		,A.TJ_OFC_CD                            HDR_TJ_OFC_CD" ).append("\n"); 
		query.append("		,A.ACT_XCH_RT                           HDR_ACT_XCH_RT" ).append("\n"); 
		query.append("		,A.IMP_ERR_FLG                          HDR_IMP_ERR_FLG" ).append("\n"); 
		query.append("		,A.RCV_ERR_FLG                          HDR_RCV_ERR_FLG" ).append("\n"); 
		query.append("		,A.TAX_CURR_XCH_FLG                     HDR_TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append("		,A.USR_EML                              HDR_USR_EML" ).append("\n"); 
		query.append("		,A.IMP_ERR_RSN                          HDR_IMP_ERR_RSN" ).append("\n"); 
		query.append("		,A.RCV_ERR_RSN                          HDR_RCV_ERR_RSN" ).append("\n"); 
		query.append("		,A.FTU_USE_CTNT1                        HDR_FTU_USE_CTNT1" ).append("\n"); 
		query.append("		,A.FTU_USE_CTNT2                        HDR_FTU_USE_CTNT2" ).append("\n"); 
		query.append("		,A.FTU_USE_CTNT3                        HDR_FTU_USE_CTNT3" ).append("\n"); 
		query.append("		,A.FTU_USE_CTNT4                        HDR_FTU_USE_CTNT4" ).append("\n"); 
		query.append("		,A.FTU_USE_CTNT5                        HDR_FTU_USE_CTNT5" ).append("\n"); 
		query.append("		,A.CRE_DT                               HDR_CRE_DT" ).append("\n"); 
		query.append("		,A.CRE_USR_ID                           HDR_CRE_USR_ID" ).append("\n"); 
		query.append("		,A.EAI_EVNT_DT                          HDR_EAI_EVNT_DT" ).append("\n"); 
		query.append("		,A.AFT_ACT_FLG                          HDR_AFT_ACT_FLG" ).append("\n"); 
		query.append("		,A.ESTM_ERR_RSN                         HDR_ESTM_ERR_RSN" ).append("\n"); 
		query.append("		,A.CXL_DT                               HDR_CXL_DT" ).append("\n"); 
		query.append("		,B.CSR_NO                               D_CSR_NO" ).append("\n"); 
		query.append("--		,B.LINE_SEQ                             D_LINE_SEQ" ).append("\n"); 
		query.append("--		,B.LINE_NO                              D_LINE_NO" ).append("\n"); 
		query.append("		,ROWNUM     	                        D_LINE_SEQ" ).append("\n"); 
		query.append("		,ROWNUM  	                            D_LINE_NO" ).append("\n"); 
		query.append("		,B.LINE_TP_LU_CD                        D_LINE_TP_LU_CD" ).append("\n"); 
		query.append("		,B.INV_AMT                              D_INV_AMT" ).append("\n"); 
		query.append("		,B.INV_DESC        D_INV_DESC" ).append("\n"); 
		query.append("		,B.INV_TAX_CD      D_INV_TAX_CD" ).append("\n"); 
		query.append("		,B.DTRB_COA_CO_CD                       D_DTRB_COA_CO_CD" ).append("\n"); 
		query.append("--		,B.DTRB_COA_RGN_CD                      D_DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("-- OFFICE에 따른 지역 코드를 조회" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("            SELECT O.FINC_RGN_CD" ).append("\n"); 
		query.append("            FROM   MDM_ORGANIZATION O" ).append("\n"); 
		query.append("            WHERE O.OFC_CD = A.TJ_OFC_CD        " ).append("\n"); 
		query.append("         ) AS D_DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("		,B.DTRB_COA_CTR_CD                      D_DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("		,B.DTRB_COA_ACCT_CD                     D_DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("		,B.DTRB_COA_VVD_CD                      D_DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("		,B.DTRB_COA_INTER_CO_CD                 D_DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("		,B.DTRB_COA_FTU_N1ST_CD                 D_DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append("		,B.DTRB_COA_FTU_N2ND_CD                 D_DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append("		,B.ATTR_CATE_NM                         D_ATTR_CATE_NM" ).append("\n"); 
		query.append("		,B.ATTR_CTNT1      D_ATTR_CTNT1" ).append("\n"); 
		query.append("		,B.ATTR_CTNT2      D_ATTR_CTNT2" ).append("\n"); 
		query.append("		,B.ATTR_CTNT3      D_ATTR_CTNT3" ).append("\n"); 
		query.append("		,B.ATTR_CTNT4      D_ATTR_CTNT4" ).append("\n"); 
		query.append("		,B.ATTR_CTNT5      D_ATTR_CTNT5" ).append("\n"); 
		query.append("		,B.ATTR_CTNT6      D_ATTR_CTNT6" ).append("\n"); 
		query.append("		,B.ATTR_CTNT7      D_ATTR_CTNT7" ).append("\n"); 
		query.append("		,B.ATTR_CTNT8      D_ATTR_CTNT8" ).append("\n"); 
		query.append("		,B.ATTR_CTNT9      D_ATTR_CTNT9" ).append("\n"); 
		query.append("		,B.ATTR_CTNT10     D_ATTR_CTNT10" ).append("\n"); 
		query.append("		,B.ATTR_CTNT11     D_ATTR_CTNT11" ).append("\n"); 
		query.append("		,B.ATTR_CTNT12     D_ATTR_CTNT12" ).append("\n"); 
		query.append("		,B.ATTR_CTNT13     D_ATTR_CTNT13" ).append("\n"); 
		query.append("		,B.ATTR_CTNT14     D_ATTR_CTNT14" ).append("\n"); 
		query.append("		,B.ATTR_CTNT15     D_ATTR_CTNT15" ).append("\n"); 
		query.append("		,B.BKG_NO                               D_BKG_NO" ).append("\n"); 
		query.append("		,B.CNTR_TPSZ_CD                         D_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,B.ACT_VVD_CD                           D_ACT_VVD_CD" ).append("\n"); 
		query.append("		,B.PLN_SCTR_DIV_CD                      D_PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append("		,B.SO_CRR_CD                            D_SO_CRR_CD" ).append("\n"); 
		query.append("		,B.YD_CD                                D_YD_CD" ).append("\n"); 
		query.append("		,B.FTU_USE_CTNT1                        D_FTU_USE_CTNT1" ).append("\n"); 
		query.append("		,B.FTU_USE_CTNT2                        D_FTU_USE_CTNT2" ).append("\n"); 
		query.append("		,B.FTU_USE_CTNT3                        D_FTU_USE_CTNT3" ).append("\n"); 
		query.append("		,B.FTU_USE_CTNT4                        D_FTU_USE_CTNT4" ).append("\n"); 
		query.append("		,B.FTU_USE_CTNT5                        D_FTU_USE_CTNT5" ).append("\n"); 
		query.append("		,B.CRE_DT                               D_CRE_DT" ).append("\n"); 
		query.append("		,B.CRE_USR_ID                           D_CRE_USR_ID" ).append("\n"); 
		query.append("		,B.EAI_EVNT_DT                          D_EAI_EVNT_DT" ).append("\n"); 
		query.append("		,B.TRSP_SO_TP_CD                        D_TRSP_SO_TP_CD" ).append("\n"); 
		query.append("		,B.SO_OFC_CTY_CD                        D_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		,B.SO_SEQ                               D_SO_SEQ" ).append("\n"); 
		query.append("FROM  AP_INV_HDR A, AP_INV_DTRB B, (SELECT COUNT(*) TOT_CNT FROM AP_INV_DTRB WHERE CSR_NO = @[csr_no]) C" ).append("\n"); 
		query.append("WHERE A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("AND   A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}