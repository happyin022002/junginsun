/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOArMnChgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.05.18 박희동
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

public class JointOperationConsultationDBDAOArMnChgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전표승인시 ERP로 보낼 data를 JOO_AR_MN, JOO_AR_CHG에 미리 insert하기 위해 조회한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOArMnChgVORSQL(){
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
		query.append("FileName : JointOperationConsultationDBDAOArMnChgVORSQL").append("\n"); 
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
		query.append("        NVL((SELECT /*+INDEX_DESC(A XPKJOO_AR_MN)*/ SUBSTR(A.AR_IF_NO,4) FROM JOO_AR_MN A WHERE A.AR_IF_NO LIKE 'JOO%' AND A.AR_IF_SER_NO = 1 AND ROWNUM = 1),'0') AS AR_IF_NO" ).append("\n"); 
		query.append("       ,1 AS AR_IF_SER_NO" ).append("\n"); 
		query.append("       ,B.KEY_NO AS JO_BL_NO" ).append("\n"); 
		query.append("       ,'JO' AS AR_SRC_CD" ).append("\n"); 
		query.append("--2010.05.18 invoice no에도 bil no가 넘어가게 해달라..." ).append("\n"); 
		query.append("--       ,NULL AS INV_NO" ).append("\n"); 
		query.append("       ,B.KEY_NO AS INV_NO" ).append("\n"); 
		query.append("       ,F.AR_HD_QTR_OFC_CD AS RHQ_CD" ).append("\n"); 
		query.append("       ,F.AR_OFC_CD" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD AS ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.CUST_SEQ AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD AS INV_CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.CUST_SEQ AS INV_CUST_SEQ" ).append("\n"); 
		query.append("       ,B.VSL_CD" ).append("\n"); 
		query.append("       ,B.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,B.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,B.VSL_CD AS TRNK_VSL_CD" ).append("\n"); 
		query.append("       ,B.SKD_VOY_NO AS TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,B.SKD_DIR_CD AS TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,B.VSL_CD AS REV_VSL_CD" ).append("\n"); 
		query.append("       ,B.SKD_VOY_NO AS REV_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,B.SKD_DIR_CD AS REV_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,B.REV_DIR_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(B.EFF_DT,'YYYYMMDD') AS SAIL_ARR_DT" ).append("\n"); 
		query.append("       ,NVL(G.REV_PORT_CD, B.LOC_CD) AS POR_CD" ).append("\n"); 
		query.append("       ,NVL(G.REV_PORT_CD, B.LOC_CD) AS POL_CD" ).append("\n"); 
		query.append("       ,NVL(G.REV_PORT_CD, B.LOC_CD) AS POD_CD" ).append("\n"); 
		query.append("       ,NVL(G.REV_PORT_CD, B.LOC_CD) AS DEL_CD" ).append("\n"); 
		query.append("       ,SUBSTR(B.RLANE_CD,1,3) AS SLAN_CD" ).append("\n"); 
		query.append("       ,'O' AS IO_BND_CD" ).append("\n"); 
		query.append("       ,'Y' AS CUST_CR_FLG" ).append("\n"); 
		query.append("       ,TO_CHAR(A.RQST_DT,'YYYYMMDD') AS DUE_DT" ).append("\n"); 
		query.append("       ,0 AS USD_AMT" ).append("\n"); 
		query.append("       ,B.CSR_LOCL_AMT AS LOCL_AMT" ).append("\n"); 
		query.append("       ,'OO' AS ZN_IOC_CD" ).append("\n"); 
		query.append("       ,NULL AS ERP_IF_FLG" ).append("\n"); 
		query.append("       ,NULL AS ERP_IF_DT" ).append("\n"); 
		query.append("       ,'01' AS INV_COA_CO_CD" ).append("\n"); 
		query.append("       ,A.SLP_ISS_RGN_CD AS INV_COA_RGN_CD" ).append("\n"); 
		query.append("       ,B.CTR_CD AS INV_COA_CTR_CD" ).append("\n"); 
		query.append("       ,B.ACCT_CD AS INV_COA_ACCT_CD" ).append("\n"); 
		query.append("       ,A.SLP_ISS_INTER_CO_CD AS INV_COA_INTER_CO_CD" ).append("\n"); 
		query.append("       ,'0000' AS INV_COA_VSL_CD" ).append("\n"); 
		query.append("       ,'0000' AS INV_COA_VOY_NO" ).append("\n"); 
		query.append("       ,'0'    AS INV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,'0'    AS INV_COA_REV_DIR_CD" ).append("\n"); 
		query.append("       ,B.RLANE_CD" ).append("\n"); 
		query.append("       ,NULL AS INV_CTRT_NO" ).append("\n"); 
		query.append("       ,'10' AS CR_TERM_DYS" ).append("\n"); 
		query.append("       ,TO_CHAR(B.EFF_DT,'YYYYMMDD') AS SAIL_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(B.EFF_DT,'YYYYMMDD') AS GL_DT" ).append("\n"); 
		query.append("       ,'A' AS XCH_RT_TP_CD" ).append("\n"); 
		query.append("       ,A.CSR_OFFST_NO" ).append("\n"); 
		query.append("       ,0 AS TAX_XCH_RT" ).append("\n"); 
		query.append("       ,'0' AS AR_TAX_IND_CD" ).append("\n"); 
		query.append("       ,B.LOC_CD AS AR_LOC_CD" ).append("\n"); 
		query.append("       ,A.SLP_ISS_OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("       ,NULL AS INV_RMK" ).append("\n"); 
		query.append("       ,A.CSR_LOCL_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       ,A.CRE_USR_ID AS USR_ID" ).append("\n"); 
		query.append("       ,NULL AS LOG_UPD_DT" ).append("\n"); 
		query.append("       ,B.SLP_ISS_DT AS ISS_DT" ).append("\n"); 
		query.append("       ,B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||TO_CHAR(TO_DATE(B.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||B.SLP_SER_NO AS SLP_NO" ).append("\n"); 
		query.append("       --JOO_AR_CHG" ).append("\n"); 
		query.append("       ,1 AS CHG_SEQ" ).append("\n"); 
		query.append("       ,'SCR' AS CHG_CD" ).append("\n"); 
		query.append("       ,'ERP' AS REP_CHG_CD" ).append("\n"); 
		query.append("       ,B.CSR_LOCL_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       ,DECODE(B.JO_STL_ITM_CD, NULL, '', 'S/H', 'JOP', 'OUS', 'JOU', 'JSC') AS JO_REV_TP_CD" ).append("\n"); 
		query.append("       ,B.CSR_LOCL_AMT AS CHG_AMT" ).append("\n"); 
		query.append("       ,0 AS TAX_AMT" ).append("\n"); 
		query.append("       ,'01' AS REV_COA_CO_CD" ).append("\n"); 
		query.append("       ,A.SLP_ISS_RGN_CD AS REV_COA_RGN_CD" ).append("\n"); 
		query.append("       ,B.CTR_CD AS REV_COA_CTR_CD" ).append("\n"); 
		query.append("       ,I.CR_ACCT_CD AS REV_COA_ACCT_CD" ).append("\n"); 
		query.append("       ,A.SLP_ISS_INTER_CO_CD AS REV_COA_INTER_CO_CD" ).append("\n"); 
		query.append("       ,'0000' AS REV_COA_VSL_CD" ).append("\n"); 
		query.append("       ,'0000' AS REV_COA_VOY_NO" ).append("\n"); 
		query.append("       ,'0'    AS REV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,'0'    AS REV_COA_DIR_CD" ).append("\n"); 
		query.append("       ,B.CSR_LOCL_AMT AS TRF_RT_AMT" ).append("\n"); 
		query.append("       ,'1' AS RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("       ,'1' AS SOB_ID" ).append("\n"); 
		query.append("       ,H.JO_STL_ITM_NM AS CHG_FULL_NM" ).append("\n"); 
		query.append("       ,NVL(I.JO_ESTM_ACCT_CD, B.ACCT_CD) AS ACCT_CD" ).append("\n"); 
		query.append("       ,'' AS USR_ID" ).append("\n"); 
		query.append("FROM   JOO_CSR          A," ).append("\n"); 
		query.append("       JOO_SLIP         B," ).append("\n"); 
		query.append("       MDM_ORGANIZATION F," ).append("\n"); 
		query.append("       AR_MST_REV_VVD   G," ).append("\n"); 
		query.append("       JOO_STL_ITM      H," ).append("\n"); 
		query.append("       JOO_STL_ITM_ACCT I" ).append("\n"); 
		query.append("WHERE  A.SLP_TP_CD       = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD     = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD      = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT      = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO      = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND    A.SLP_ISS_OFC_CD  = F.OFC_CD" ).append("\n"); 
		query.append("AND    B.VSL_CD          = G.VSL_CD       " ).append("\n"); 
		query.append("AND    B.SKD_VOY_NO      = G.SKD_VOY_NO   " ).append("\n"); 
		query.append("AND    B.SKD_DIR_CD      = G.SKD_DIR_CD   " ).append("\n"); 
		query.append("AND    B.REV_DIR_CD      = G.RLANE_DIR_CD " ).append("\n"); 
		query.append("AND    B.JO_STL_ITM_CD   = H.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    B.JO_STL_ITM_CD   = I.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    I.RE_DIVR_CD      = DECODE(B.SLP_TP_CD,'18','R','E')" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD       = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD     = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD      = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no], 4, 6),19,SUBSTR(@[csr_no], 4, 5))" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT      = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10, 6),19,SUBSTR(@[csr_no], 9, 6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO      = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16, 5),19,SUBSTR(@[csr_no],15, 5))" ).append("\n"); 
		query.append("AND    B.DR_CR_CD        = 'DR'" ).append("\n"); 

	}
}