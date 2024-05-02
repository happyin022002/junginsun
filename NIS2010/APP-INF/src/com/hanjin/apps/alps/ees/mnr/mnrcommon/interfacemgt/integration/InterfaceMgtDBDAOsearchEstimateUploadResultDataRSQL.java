/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEstimateUploadResultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.11.03 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchEstimateUploadResultDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Estimate Upload 처리된 결과를 조회합니다.
	  * --------------------------------------------------------
	  * History
	  * 2011.10.28 김상수 [CHM-201114133-01] ALPS MNR->REPAIR Estimate 에서 EDI Upload 시 Man-Hour 계산로직 수정
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEstimateUploadResultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchEstimateUploadResultDataRSQL").append("\n"); 
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
		query.append("SELECT A.RQST_EQ_NO||A.RPR_RQST_TMP_SEQ ||A.RPR_RQST_TMP_VER_NO AS COMPLEX_PK," ).append("\n"); 
		query.append("       A.RQST_EQ_NO," ).append("\n"); 
		query.append("       A.RQST_REF_NO," ).append("\n"); 
		query.append("       TO_CHAR(A.EQ_DMG_DT, 'YYYYMMDD') AS EQ_DMG_DT," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       A.EDI_ID," ).append("\n"); 
		query.append("       A.RPR_OFFH_FLG," ).append("\n"); 
		query.append("       A.EDI_ERR_CD," ).append("\n"); 
		query.append("       B.EQ_LOC_CD," ).append("\n"); 
		query.append("       B.EQ_CMPO_CD," ).append("\n"); 
		query.append("       B.EQ_DMG_CD," ).append("\n"); 
		query.append("       B.EQ_RPR_CD," ).append("\n"); 
		query.append("       B.TRF_DIV_CD," ).append("\n"); 
		query.append("       B.VOL_TP_CD," ).append("\n"); 
		query.append("       B.RPR_QTY," ).append("\n"); 
		query.append("       B.RPR_SZ_NO," ).append("\n"); 
		query.append("       B.RPR_LBR_HRS," ).append("\n"); 
		query.append("       B.RPR_LBR_RT," ).append("\n"); 
		query.append("       B.LBR_COST_AMT," ).append("\n"); 
		query.append("       B.MTRL_COST_AMT," ).append("\n"); 
		query.append("       B.MNR_WRK_AMT," ).append("\n"); 
		query.append("       C.MNR_CD_DP_DESC AS EDI_ERR_NM" ).append("\n"); 
		query.append("  FROM MNR_RPR_RQST_TMP_HDR A," ).append("\n"); 
		query.append("       MNR_RPR_RQST_TMP_DTL B," ).append("\n"); 
		query.append("       MNR_GEN_CD C" ).append("\n"); 
		query.append(" WHERE A.RQST_EQ_NO = B.RQST_EQ_NO" ).append("\n"); 
		query.append("   AND A.RPR_RQST_TMP_SEQ = B.RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append("   AND A.RPR_RQST_TMP_VER_NO = B.RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append("   AND A.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.EDI_ERR_CD = C.MNR_CD_ID" ).append("\n"); 
		query.append("   AND C.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("#if (${complex_pk} != '')" ).append("\n"); 
		query.append("   AND A.RQST_EQ_NO||A.RPR_RQST_TMP_SEQ||A.RPR_RQST_TMP_VER_NO IN (" ).append("\n"); 
		query.append("     #foreach ($key IN ${complex_pk})" ).append("\n"); 
		query.append("          #if($velocityCount < $complex_pk.size())" ).append("\n"); 
		query.append("               '$key'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("               '$key'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}