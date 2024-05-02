/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCombinedDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.27
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.07.27 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCombinedDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD ITEM DUP Check
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCombinedDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCombinedDupRSQL").append("\n"); 
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
		query.append("SELECT C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO CSR_NO," ).append("\n"); 
		query.append("       T.BSA_QTY E_BSA_QTY, T.BSA_SLT_PRC E_BSA_SLT_PRC, T.STL_LOCL_AMT E_STL_LOCL_AMT" ).append("\n"); 
		query.append("FROM JOO_SETTLEMENT T, JOO_SLIP S, JOO_CSR C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND T.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("AND T.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND	T.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND	T.REV_DIR_CD = S.REV_DIR_CD" ).append("\n"); 
		query.append("AND T.JO_STL_ITM_CD = S.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND T.ACCT_YRMON = S.ACCT_YRMON" ).append("\n"); 
		query.append("AND T.STL_VVD_SEQ = S.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND T.STL_SEQ = S.STL_SEQ" ).append("\n"); 
		query.append("AND S.SLP_TP_CD = C.SLP_TP_CD" ).append("\n"); 
		query.append("AND S.SLP_FUNC_CD = C.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND S.SLP_OFC_CD = C.SLP_OFC_CD" ).append("\n"); 
		query.append("AND S.SLP_ISS_DT = C.SLP_ISS_DT" ).append("\n"); 
		query.append("AND S.SLP_SER_NO = C.SLP_SER_NO" ).append("\n"); 
		query.append("AND C.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND C.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND T.ACCT_YRMON  BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[acct_yrmon],'-',''),'YYYYMM'),-24),'YYYYMM') " ).append("\n"); 
		query.append("AND REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND  ((T.VSL_CD = SUBSTR(@[r_vvd], 1, 4)" ).append("\n"); 
		query.append("      AND T.SKD_VOY_NO = SUBSTR(@[r_vvd], 5, 4)" ).append("\n"); 
		query.append("      AND	T.SKD_DIR_CD = SUBSTR(@[r_vvd], 9, 1)" ).append("\n"); 
		query.append("      AND	T.REV_DIR_CD = SUBSTR(@[r_vvd], 10, 1))" ).append("\n"); 
		query.append("   OR" ).append("\n"); 
		query.append("     (T.VSL_CD = SUBSTR(@[e_vvd], 1, 4)" ).append("\n"); 
		query.append("     AND T.SKD_VOY_NO = SUBSTR(@[e_vvd], 5, 4)" ).append("\n"); 
		query.append("     AND	T.SKD_DIR_CD = SUBSTR(@[e_vvd], 9, 1)" ).append("\n"); 
		query.append("     AND	T.REV_DIR_CD = SUBSTR(@[e_vvd], 10, 1)))" ).append("\n"); 
		query.append("AND T.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND T.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND T.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 

	}
}