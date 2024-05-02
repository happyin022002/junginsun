/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOInvHdrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.29
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.10.29 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOInvHdrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Invoice 조회
	  * </pre>
	  */
	public JointOperationConsultationDBDAOInvHdrVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOInvHdrVORSQL").append("\n"); 
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
		query.append("       A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS CSR_NO," ).append("\n"); 
		query.append("       A.CSR_TP_CD," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',TO_CHAR(B.ISS_DT, 'YYYYMMDD'), A.SLP_ISS_DT) AS INV_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.RQST_DT,'YYYYMMDD') AS INV_TERM_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.EFF_DT,'YYYYMMDD') AS GL_DT," ).append("\n"); 
		query.append("       A.VNDR_SEQ AS VNDR_NO," ).append("\n"); 
		query.append("       A.CSR_LOCL_AMT AS CSR_AMT," ).append("\n"); 
		query.append("       NULL AS PAY_AMT," ).append("\n"); 
		query.append("       NULL AS PAY_DT," ).append("\n"); 
		query.append("       A.CSR_LOCL_CURR_CD AS CSR_CURR_CD," ).append("\n"); 
		query.append("       '0' AS VNDR_TERM_NM," ).append("\n"); 
		query.append("       A.CSR_DESC AS INV_DESC," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1','세금계산서', 'ARAP Offset') AS ATTR_CATE_NM," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT1," ).append("\n"); 
		query.append("       B.SPL_RGST_NO AS ATTR_CTNT2," ).append("\n"); 
		query.append("       TO_CHAR(B.ISS_DT,'YYYYMMDD') AS ATTR_CTNT3," ).append("\n"); 
		query.append("       B.SPL_AMT AS ATTR_CTNT4," ).append("\n"); 
		query.append("       B.OFC_CD AS ATTR_CTNT5," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',0, NULL) AS ATTR_CTNT6," ).append("\n"); 
		query.append("       A.CSR_OFFST_NO AS ATTR_CTNT7 ," ).append("\n"); 
		query.append("       NVL(B.DOC_EVID_TP_CD,'ELECTRONIC') AS ATTR_CTNT8 , --H_ATTRIBUTE8로 넘어감 (세금계산서의 종류(종이,전자)가 넘어가야함)" ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT9 ," ).append("\n"); 
		query.append("       C.USR_NM AS ATTR_CTNT10," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT11," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT12," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT13," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT14," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT15," ).append("\n"); 
		query.append("       B.ITM_NM AS GLO_ATTR_CTNT1 ," ).append("\n"); 
		query.append("       B.SPL_AMT AS GLO_ATTR_CTNT2 ," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',0, NULL) AS GLO_ATTR_CTNT3 ," ).append("\n"); 
		query.append("       NULL AS GLO_ATTR_CTNT4 ," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',0, NULL) AS GLO_ATTR_CTNT5 ," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',0, NULL) AS GLO_ATTR_CTNT6 ," ).append("\n"); 
		query.append("       NULL AS GLO_ATTR_CTNT7 ," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',0, NULL) AS GLO_ATTR_CTNT8 ," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',0, NULL) AS GLO_ATTR_CTNT9 ," ).append("\n"); 
		query.append("       NULL AS GLO_ATTR_CTNT10," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',0, NULL) AS GLO_ATTR_CTNT11," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1',0, NULL) AS GLO_ATTR_CTNT12," ).append("\n"); 
		query.append("       B.TAX_INV_YRMON||B.OFC_CD||B.TAX_SER_NO AS GLO_ATTR_CTNT13," ).append("\n"); 
		query.append("       NULL AS GLO_ATTR_CTNT14," ).append("\n"); 
		query.append("       NULL AS GLO_ATTR_CTNT15," ).append("\n"); 
		query.append("       NULL AS GLO_ATTR_CTNT16," ).append("\n"); 
		query.append("       NULL AS GLO_ATTR_CTNT17," ).append("\n"); 
		query.append("       NULL AS GLO_ATTR_CTNT18," ).append("\n"); 
		query.append("       'JO' AS SRC_CTNT        ," ).append("\n"); 
		query.append("       'WIRE' AS PAY_MZD_LU_CD ," ).append("\n"); 
		query.append("       CASE WHEN D.VNDR_CNT_CD = 'HQ' THEN" ).append("\n"); 
		query.append("               DECODE(A.CSR_LOCL_AMT,0,'ZERO PAYMENT','대내지불')" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("               DECODE(A.CSR_LOCL_AMT,0,D.AP_OFC_CD||'_ZERO PAYMENT',D.AP_OFC_CD||'_O/EXP')" ).append("\n"); 
		query.append("       END AS PAY_GRP_LU_CD," ).append("\n"); 
		query.append("       '01' AS COA_CO_CD       ," ).append("\n"); 
		query.append("       A.SLP_ISS_RGN_CD AS COA_RGN_CD      ," ).append("\n"); 
		query.append("       D.AP_CTR_CD AS COA_CTR_CD      ," ).append("\n"); 
		query.append("       '210111' AS COA_ACCT_CD     ," ).append("\n"); 
		query.append("       '0000000000' AS COA_VVD_CD      ," ).append("\n"); 
		query.append("       A.SLP_ISS_INTER_CO_CD AS COA_INTER_CO_CD ," ).append("\n"); 
		query.append("       '000000' AS COA_FTU_N1ST_CD ," ).append("\n"); 
		query.append("       '000000' AS COA_FTU_N2ND_CD ," ).append("\n"); 
		query.append("       NULL AS PPD_NO          ," ).append("\n"); 
		query.append("       NULL AS PPD_DTRB_NO     ," ).append("\n"); 
		query.append("       NULL AS PPD_APLY_AMT    ," ).append("\n"); 
		query.append("       NULL AS PPD_GL_DT       ," ).append("\n"); 
		query.append("       A.APRO_FLG AS APRO_FLG        ," ).append("\n"); 
		query.append("       DECODE(A.EVID_TP_CD,'1','Y','N') AS TAX_DECL_FLG    ," ).append("\n"); 
		query.append("       NULL AS ERR_CSR_NO      ," ).append("\n"); 
		query.append("       NULL AS IF_FLG          ," ).append("\n"); 
		query.append("       NULL AS IF_DT           ," ).append("\n"); 
		query.append("       NULL AS IF_ERR_RSN      ," ).append("\n"); 
		query.append("       NULL AS PPAY_APLY_FLG   ," ).append("\n"); 
		query.append("       A.SLP_OFC_CD AS TJ_OFC_CD,/*20091208 SLP_ISS_OFC_CD->SLP_OFC_CD 로 변경*/" ).append("\n"); 
		query.append("       NULL AS ACT_XCH_RT      ," ).append("\n"); 
		query.append("       NULL AS IMP_ERR_FLG     ," ).append("\n"); 
		query.append("       NULL AS RCV_ERR_FLG     ," ).append("\n"); 
		query.append("       NULL AS TAX_CURR_XCH_FLG," ).append("\n"); 
		query.append("       NULL AS USR_EML         ," ).append("\n"); 
		query.append("       NULL AS IMP_ERR_RSN     ," ).append("\n"); 
		query.append("       NULL AS RCV_ERR_RSN     ," ).append("\n"); 
		query.append("       NULL AS FTU_USE_CTNT1   ," ).append("\n"); 
		query.append("       NULL AS FTU_USE_CTNT2   ," ).append("\n"); 
		query.append("       NULL AS FTU_USE_CTNT3   ," ).append("\n"); 
		query.append("       NULL AS FTU_USE_CTNT4   ," ).append("\n"); 
		query.append("       NULL AS FTU_USE_CTNT5   ," ).append("\n"); 
		query.append("       '' AS CRE_USR_ID" ).append("\n"); 
		query.append("FROM   JOO_CSR A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("              X.SLP_TP_CD, X.SLP_FUNC_CD, X.SLP_OFC_CD, X.SLP_ISS_DT, X.SLP_SER_NO," ).append("\n"); 
		query.append("              X.ISS_DT, X.SPL_RGST_NO, Y.SPL_AMT, Y.ITM_NM," ).append("\n"); 
		query.append("              X.TAX_INV_YRMON, X.OFC_CD, X.TAX_SER_NO, X.DOC_EVID_TP_CD" ).append("\n"); 
		query.append("       FROM   JOO_TAX     X," ).append("\n"); 
		query.append("              JOO_TAX_DTL Y" ).append("\n"); 
		query.append("       WHERE  X.TAX_INV_YRMON = Y.TAX_INV_YRMON" ).append("\n"); 
		query.append("       AND    X.OFC_CD        = Y.OFC_CD" ).append("\n"); 
		query.append("       AND    X.TAX_SER_NO    = Y.TAX_SER_NO" ).append("\n"); 
		query.append("       ) B," ).append("\n"); 
		query.append("       COM_USER C," ).append("\n"); 
		query.append("       MDM_ORGANIZATION D" ).append("\n"); 
		query.append("WHERE  A.SLP_TP_CD   = B.SLP_TP_CD   (+)" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD = B.SLP_FUNC_CD (+)" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD  = B.SLP_OFC_CD  (+)" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  = B.SLP_ISS_DT  (+)" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO  = B.SLP_SER_NO  (+)" ).append("\n"); 
		query.append("AND    A.CRE_USR_ID  = C.USR_ID" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD  = D.OFC_CD" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD       = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD     = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD      = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no], 4, 6),19,SUBSTR(@[csr_no], 4, 5))" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT      = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10, 6),19,SUBSTR(@[csr_no], 9, 6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO      = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16, 5),19,SUBSTR(@[csr_no],15, 5))" ).append("\n"); 

	}
}