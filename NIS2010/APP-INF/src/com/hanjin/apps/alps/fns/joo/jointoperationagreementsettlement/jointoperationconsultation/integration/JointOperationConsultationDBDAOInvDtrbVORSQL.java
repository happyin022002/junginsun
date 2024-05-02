/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOInvDtrbVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.22 박희동
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

public class JointOperationConsultationDBDAOInvDtrbVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Detail 조회
	  * </pre>
	  */
	public JointOperationConsultationDBDAOInvDtrbVORSQL(){
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
		query.append("FileName : JointOperationConsultationDBDAOInvDtrbVORSQL").append("\n"); 
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
		query.append("CSR_NO," ).append("\n"); 
		query.append("SLP_SEQ_NO AS LINE_SEQ," ).append("\n"); 
		query.append("SLP_SEQ_NO AS LINE_NO," ).append("\n"); 
		query.append("ITM AS LINE_TP_LU_CD," ).append("\n"); 
		query.append("CSR_LOCL_AMT AS INV_AMT," ).append("\n"); 
		query.append("SLP_DESC AS INV_DESC," ).append("\n"); 
		query.append("TAX_CD AS INV_TAX_CD," ).append("\n"); 
		query.append("COMP_CD AS DTRB_COA_CO_CD," ).append("\n"); 
		query.append("SLP_ISS_RGN_CD AS DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("CTR_CD AS DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("ACCT_CD AS DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("VVD AS DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("SLP_ISS_INTER_CO_CD AS DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("'000000' DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("'000000' DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("ACCT_CD AS ATTR_CATE_NM," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT1  ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT2  ," ).append("\n"); 
		query.append("LOC_CD AS ATTR_CTNT3," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT4  ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT5  ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT6  ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT7  ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT8  ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT9  ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT10 ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT11 ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT12 ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT13 ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT14 ," ).append("\n"); 
		query.append("NULL AS ATTR_CTNT15 ," ).append("\n"); 
		query.append("NULL AS BKG_NO      ," ).append("\n"); 
		query.append("NULL AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("VVD  AS ACT_VVD_CD," ).append("\n"); 
		query.append("'O'  AS PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("NULL AS SO_CRR_CD    ," ).append("\n"); 
		query.append("NULL AS YD_CD        ," ).append("\n"); 
		query.append("NULL AS FTU_USE_CTNT1," ).append("\n"); 
		query.append("NULL AS FTU_USE_CTNT2," ).append("\n"); 
		query.append("NULL AS FTU_USE_CTNT3," ).append("\n"); 
		query.append("NULL AS FTU_USE_CTNT4," ).append("\n"); 
		query.append("NULL AS FTU_USE_CTNT5," ).append("\n"); 
		query.append("'' AS CRE_USR_ID" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("C.SLP_TP_CD ||C.SLP_FUNC_CD||C.SLP_OFC_CD||TO_CHAR(TO_DATE(C.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||C.SLP_SER_NO AS CSR_NO" ).append("\n"); 
		query.append(", S.SLP_SEQ_NO" ).append("\n"); 
		query.append(", 'ITEM' AS ITM" ).append("\n"); 
		query.append(", S.CSR_LOCL_AMT" ).append("\n"); 
		query.append(", S.SLP_DESC" ).append("\n"); 
		query.append(", NULL AS TAX_CD" ).append("\n"); 
		query.append(", '01' AS COMP_CD" ).append("\n"); 
		query.append(", C.SLP_ISS_RGN_CD" ).append("\n"); 
		query.append(", S.CTR_CD" ).append("\n"); 
		query.append(", S.ACCT_CD" ).append("\n"); 
		query.append(", S.VSL_CD||S.SKD_VOY_NO||S.SKD_DIR_CD||S.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append(", NVL(SLP_ISS_INTER_CO_CD,'00') AS SLP_ISS_INTER_CO_CD" ).append("\n"); 
		query.append(", S.LOC_CD" ).append("\n"); 
		query.append("FROM   JOO_CSR  C," ).append("\n"); 
		query.append("JOO_SLIP S" ).append("\n"); 
		query.append("WHERE  C.SLP_TP_CD   = S.SLP_TP_CD" ).append("\n"); 
		query.append("AND    C.SLP_FUNC_CD = S.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND    C.SLP_OFC_CD  = S.SLP_OFC_CD" ).append("\n"); 
		query.append("AND    C.SLP_ISS_DT  = S.SLP_ISS_DT" ).append("\n"); 
		query.append("AND    C.SLP_SER_NO  = S.SLP_SER_NO" ).append("\n"); 
		query.append("AND    S.DR_CR_CD    = 'DR'" ).append("\n"); 
		query.append("AND    C.SLP_TP_CD   = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND    C.SLP_FUNC_CD = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND    C.SLP_OFC_CD  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no], 4, 6),19,SUBSTR(@[csr_no], 4, 5))" ).append("\n"); 
		query.append("AND    C.SLP_ISS_DT  = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10, 6),19,SUBSTR(@[csr_no], 9, 6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    C.SLP_SER_NO  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16, 5),19,SUBSTR(@[csr_no],15, 5))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO CSR_NO" ).append("\n"); 
		query.append(", S.SLP_SEQ_NO" ).append("\n"); 
		query.append(", 'TAX' AS ITM" ).append("\n"); 
		query.append(", 0 AS CSR_LOCL_AMT" ).append("\n"); 
		query.append(", C.CSR_DESC AS SLP_DESC" ).append("\n"); 
		query.append(", DECODE(C.EVID_TP_CD, '1','매입0%일반','5', NULL) TAX_CD" ).append("\n"); 
		query.append(", '01' COMP_CD" ).append("\n"); 
		query.append(", C.SLP_ISS_RGN_CD" ).append("\n"); 
		query.append(", S.CTR_CD" ).append("\n"); 
		query.append(", '111811' AS ACCT_CD" ).append("\n"); 
		query.append(", '0000000000' VVD" ).append("\n"); 
		query.append(", C.SLP_ISS_INTER_CO_CD" ).append("\n"); 
		query.append(", S.LOC_CD" ).append("\n"); 
		query.append("FROM   JOO_CSR  C," ).append("\n"); 
		query.append("JOO_SLIP S" ).append("\n"); 
		query.append("WHERE  C.SLP_TP_CD   = S.SLP_TP_CD" ).append("\n"); 
		query.append("AND    C.SLP_FUNC_CD = S.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND    C.SLP_OFC_CD  = S.SLP_OFC_CD" ).append("\n"); 
		query.append("AND    C.SLP_ISS_DT  = S.SLP_ISS_DT" ).append("\n"); 
		query.append("AND    C.SLP_SER_NO  = S.SLP_SER_NO" ).append("\n"); 
		query.append("AND    S.DR_CR_CD    = 'CR'" ).append("\n"); 
		query.append("AND    C.EVID_TP_CD  = '1'" ).append("\n"); 
		query.append("AND    C.SLP_TP_CD   = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND    C.SLP_FUNC_CD = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND    C.SLP_OFC_CD  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no], 4, 6),19,SUBSTR(@[csr_no], 4, 5))" ).append("\n"); 
		query.append("AND    C.SLP_ISS_DT  = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10, 6),19,SUBSTR(@[csr_no], 9, 6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    C.SLP_SER_NO  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16, 5),19,SUBSTR(@[csr_no],15, 5))" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}