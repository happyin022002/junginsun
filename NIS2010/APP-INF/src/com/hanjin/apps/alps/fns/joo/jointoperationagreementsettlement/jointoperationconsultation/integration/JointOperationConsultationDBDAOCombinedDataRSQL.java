/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCombinedDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.04
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.08.04 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCombinedDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combined된 data조회
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCombinedDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCombinedDataRSQL").append("\n"); 
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
		query.append("	  'R' AS IBFLAG" ).append("\n"); 
		query.append("      ,A.ACCT_YRMON" ).append("\n"); 
		query.append("      ,A.JO_CRR_CD" ).append("\n"); 
		query.append("      ,A.RLANE_CD" ).append("\n"); 
		query.append("      ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("      ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,A.STL_SEQ" ).append("\n"); 
		query.append("      ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("      ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,A.CMB_CFM_FLG" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID     " ).append("\n"); 
		query.append("      ,DECODE(A.RE_DIVR_CD,'R',A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,'') AS R_VVD" ).append("\n"); 
		query.append("      ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.USD_SLT_BSA_QTY ELSE A.BSA_QTY END)) AS R_BSA_QTY" ).append("\n"); 
		query.append("      ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.RF_SCG_PRC ELSE A.BSA_SLT_PRC END)) AS R_BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT)) AS R_STL_LOCL_AMT" ).append("\n"); 
		query.append("      ,DECODE(A.RE_DIVR_CD,'E',A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,'') AS E_VVD" ).append("\n"); 
		query.append("      ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.USD_SLT_BSA_QTY ELSE A.BSA_QTY END)) AS E_BSA_QTY" ).append("\n"); 
		query.append("      ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.RF_SCG_PRC ELSE A.BSA_SLT_PRC END)) AS E_BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT)) AS E_STL_LOCL_AMT" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("         SELECT 'DUP' || '/' || DTL.ACCT_YRMON || '/' || DTL.STL_CMB_SEQ" ).append("\n"); 
		query.append("          FROM JOO_SETTLEMENT STL" ).append("\n"); 
		query.append("             , JOO_STL_CMB_DTL DTL" ).append("\n"); 
		query.append("             , JOO_STL_CMB CMB" ).append("\n"); 
		query.append("             , JOO_CSR CSR" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND A.TRD_CD = STL.TRD_CD" ).append("\n"); 
		query.append("           AND A.RLANE_CD = STL.RLANE_CD" ).append("\n"); 
		query.append("           AND A.JO_CRR_CD = STL.JO_CRR_CD" ).append("\n"); 
		query.append("           AND A.RE_DIVR_CD = STL.RE_DIVR_CD" ).append("\n"); 
		query.append("           AND A.JO_STL_ITM_CD = STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("           AND A.VSL_CD = STL.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = STL.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = STL.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND STL.ACCT_YRMON = DTL.ACCT_YRMON" ).append("\n"); 
		query.append("           AND STL.STL_VVD_SEQ = DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("           AND STL.STL_SEQ = DTL.STL_SEQ" ).append("\n"); 
		query.append("           AND DTL.ACCT_YRMON = CMB.ACCT_YRMON" ).append("\n"); 
		query.append("           AND DTL.JO_CRR_CD = CMB.JO_CRR_CD" ).append("\n"); 
		query.append("           AND DTL.STL_CMB_SEQ = CMB.STL_CMB_SEQ" ).append("\n"); 
		query.append("           AND DTL.RE_DIVR_CD = CMB.RE_DIVR_CD" ).append("\n"); 
		query.append("           AND CMB.SLP_TP_CD = CSR.SLP_TP_CD" ).append("\n"); 
		query.append("           AND CMB.SLP_FUNC_CD = CSR.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND CMB.SLP_OFC_CD = CSR.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND CMB.SLP_ISS_DT = CSR.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND CMB.SLP_SER_NO = CSR.SLP_SER_NO" ).append("\n"); 
		query.append("           AND CSR.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("           AND CSR.CXL_FLG = 'N'" ).append("\n"); 
		query.append("           AND CMB.ACCT_YRMON  BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[acct_yrmon],'-',''),'YYYYMM'),-24),'YYYYMM') AND REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("           AND DTL.ACCT_YRMON || DTL.JO_CRR_CD || DTL.STL_CMB_SEQ != REPLACE(@[acct_yrmon],'-','') || @[jo_crr_cd] || @[stl_cmb_seq]" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) REMARK " ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("       JOO_STL_DTL     B " ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND   (A.ACCT_YRMON, A.STL_VVD_SEQ, A.STL_SEQ) IN (" ).append("\n"); 
		query.append("       SELECT C.ACCT_YRMON, C.STL_VVD_SEQ, C.STL_SEQ" ).append("\n"); 
		query.append("       FROM   JOO_STL_CMB_DTL C" ).append("\n"); 
		query.append("       WHERE  C.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("       AND    C.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("       AND    C.STL_CMB_SEQ = TO_NUMBER(@[stl_cmb_seq])" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("AND    A.CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY A.RLANE_CD, A.REV_DIR_CD DESC, A.STL_VVD_SEQ, A.STL_SEQ" ).append("\n"); 

	}
}