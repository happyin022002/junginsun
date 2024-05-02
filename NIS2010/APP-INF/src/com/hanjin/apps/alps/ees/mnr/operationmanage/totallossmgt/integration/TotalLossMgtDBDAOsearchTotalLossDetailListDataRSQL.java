/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchTotalLossDetailListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2010.11.17 박명신
* 1.0 Creation
* --------------------------------------------------------
* 2012.04.17 신혜정 [CHM-201217355] 3rd Party 리스트내 SCAC Code 항목 추가
*                                   [Save], [Request]시 Sub Reason 이 Trucker 일 경우 필수 항목 체크
* 2012.05.02 신혜정 [CHM-201217379] 3rd Party 리스트내 buyer Code, buyer name 항목 추가   
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOsearchTotalLossDetailListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss Request 화면에서 Detail 조회
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchTotalLossDetailListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOsearchTotalLossDetailListDataRSQL").append("\n"); 
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
		query.append("SELECT A.TTL_LSS_NO" ).append("\n"); 
		query.append("      ,A.TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("      ,A.MNR_INV_TP_CD" ).append("\n"); 
		query.append("      ,A.TTL_LSS_DTL_STS_CD" ).append("\n"); 
		query.append("      ,A.EQ_KND_CD" ).append("\n"); 
		query.append("      ,A.RQST_EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.DPC_VAL_AMT" ).append("\n"); 
		query.append("      ,(SELECT LESSOR_NM FROM MNR_EQ_STS_V WHERE EQ_NO = A.RQST_EQ_NO)  LESSOR_NM" ).append("\n"); 
		query.append("	  ,(SELECT B.DISP_NO " ).append("\n"); 
		query.append("          FROM MNR_DISP_HDR B,MNR_DISP_DTL C " ).append("\n"); 
		query.append("         WHERE B.DISP_NO = C.DISP_NO AND B.DISP_STS_CD <> 'HD' AND C.EQ_NO = A.RQST_EQ_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1)  DISP_NO" ).append("\n"); 
		query.append("      ,A.TTL_LSS_N3PTY_TP_CD" ).append("\n"); 
		query.append("      ,A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("      ,A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("      ,DECODE(A.TTL_LSS_N3PTY_TP_CD, 'S', TO_CHAR(A.MNR_PRNR_SEQ), 'C', A.MNR_PRNR_CNT_CD||A.MNR_PRNR_SEQ,'O','', DECODE(A.MNR_INV_TP_CD,'DV',TO_CHAR(A.MNR_PRNR_SEQ),'')) PAYER_CODE" ).append("\n"); 
		query.append("      ,DECODE(A.TTL_LSS_N3PTY_TP_CD, 'S', (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                                             FROM MDM_VENDOR" ).append("\n"); 
		query.append("                                            WHERE VNDR_SEQ = A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                              AND NVL(DELT_FLG, 'N') <> 'Y') " ).append("\n"); 
		query.append("                                   , 'C', (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                             FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                            WHERE CUST_CNT_CD = A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("                                              AND CUST_SEQ = A.MNR_PRNR_SEQ)" ).append("\n"); 
		query.append("                                   ,  DECODE(A.MNR_INV_TP_CD,'DV',(SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                   FROM MDM_VENDOR" ).append("\n"); 
		query.append("                                                                   WHERE VNDR_SEQ = A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                                                   AND NVL(DELT_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append("                                                                 ,'')" ).append("\n"); 
		query.append("       ) PAYER_NAME" ).append("\n"); 
		query.append("      ,A.TTL_LSS_BUYR_SEQ BUYER_CODE" ).append("\n"); 
		query.append("      ,(SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM MDM_VENDOR" ).append("\n"); 
		query.append("        WHERE VNDR_SEQ = A.TTL_LSS_BUYR_SEQ" ).append("\n"); 
		query.append("        	AND NVL(DELT_FLG, 'N') <> 'Y'      " ).append("\n"); 
		query.append("       ) BUYER_NAME    " ).append("\n"); 
		query.append("      ,A.CNT_CD" ).append("\n"); 
		query.append("      ,A.VNDR_CUST_SEQ" ).append("\n"); 
		query.append("      ,A.TTL_LSS_PLC_NM" ).append("\n"); 
		query.append("      ,A.INV_NO" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.TTL_LSS_BIL_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.TTL_LSS_BIL_DT, 'yyyy-mm-dd') TTL_LSS_BIL_DT" ).append("\n"); 
		query.append("      ,A.TTL_LSS_EXPN_AMT" ).append("\n"); 
		query.append("      ,A.TTL_LSS_INCM_AMT" ).append("\n"); 
		query.append("      ,A.AR_CHK_NO" ).append("\n"); 
		query.append("      ,A.N3PTY_NO" ).append("\n"); 
		query.append("      ,A.CSR_NO" ).append("\n"); 
		query.append("      ,A.EQ_OWNR_FLG" ).append("\n"); 
		query.append("      ,A.TTL_LSS_CFM_FLG" ).append("\n"); 
		query.append("      ,A.PAY_INV_SEQ" ).append("\n"); 
		query.append("      ,A.IF_TRC_SEQ" ).append("\n"); 
		query.append("      ,A.DTL_RMK" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("      ,A.TTL_LSS_YD_CD" ).append("\n"); 
		query.append("	  ,NVL(A.BANK_NM,C.BANK_NM) AS BANK_NM" ).append("\n"); 
		query.append("	  ,NVL(A.BANK_ACCT_NO,C.BANK_ACCT_NO) AS BANK_ACCT_NO" ).append("\n"); 
		query.append("	  ,(SELECT LSTM_CD FROM MNR_EQ_STS_V WHERE EQ_NO = A.RQST_EQ_NO) AS LSTM_CD" ).append("\n"); 
		query.append("	  ,DECODE(A.RESPB_OFC_CD,null,B.RQST_OFC_CD,'',B.RQST_OFC_CD,A.RESPB_OFC_CD) AS RESPB_OFC_CD" ).append("\n"); 
		query.append("	  ,NVL((SELECT INV_RGST_NO FROM MNR_PAY_INV_WRK WHERE PAY_INV_SEQ=A.PAY_INV_SEQ),'') AS INV_RGST_NO" ).append("\n"); 
		query.append("	  ,NVL(A.MNR_SWIFT_NO,C.MNR_SWIFT_NO) AS MNR_SWIFT_NO" ).append("\n"); 
		query.append("	  ,A.TTL_LSS_CMPL_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(A.TTL_LSS_CMPL_DT, 'yyyy-mm-dd') AS TTL_LSS_CMPL_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(A.CR_END_DT, 'yyyy-mm-dd') AS CR_END_DT" ).append("\n"); 
		query.append("      ,A.USA_EDI_CD" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL A, MNR_TTL_LSS_RQST_HDR B" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("  			SELECT X.RQST_OFC_CD, X.BANK_NM, X.BANK_ACCT_NO, X.MNR_SWIFT_NO FROM " ).append("\n"); 
		query.append("  			(" ).append("\n"); 
		query.append("    			SELECT ROW_NUMBER() OVER (ORDER BY A.TTL_LSS_NO DESC) AS NUM,  B.RQST_OFC_CD, A.BANK_NM, A.BANK_ACCT_NO, A.MNR_SWIFT_NO" ).append("\n"); 
		query.append("    				FROM MNR_TTL_LSS_RQST_DTL A, MNR_TTL_LSS_RQST_HDR B" ).append("\n"); 
		query.append("    				WHERE A.TTL_LSS_NO = B.TTL_LSS_NO" ).append("\n"); 
		query.append("    				AND B.RQST_OFC_CD = @[in_rqst_ofc_cd]" ).append("\n"); 
		query.append("    				AND A.MNR_INV_TP_CD='TP'" ).append("\n"); 
		query.append("    				AND A.BANK_NM IS NOT NULL" ).append("\n"); 
		query.append("    				AND A.BANK_ACCT_NO IS NOT NULL" ).append("\n"); 
		query.append("    				AND A.MNR_SWIFT_NO IS NOT NULL" ).append("\n"); 
		query.append("  			) X " ).append("\n"); 
		query.append("  			WHERE NUM = 1" ).append("\n"); 
		query.append("		) C" ).append("\n"); 
		query.append(" WHERE A.TTL_LSS_NO = B.TTL_LSS_NO" ).append("\n"); 
		query.append("   AND A.TTL_LSS_NO = @[search_ttl_lss_no]" ).append("\n"); 
		query.append("   AND A.MNR_INV_TP_CD = @[mnr_inv_tp_cd]" ).append("\n"); 
		query.append("   AND B.RQST_OFC_CD =C.RQST_OFC_CD(+)" ).append("\n"); 
		query.append("   #if (${work_type} == 'request') " ).append("\n"); 
		query.append("   AND B.TTL_LSS_STS_CD IN ('HJ','HS','HR')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}