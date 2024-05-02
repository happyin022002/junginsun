/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEstimateUploadResultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.27
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.27 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
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
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEstimateUploadResultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
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
		query.append("SELECT  A.RQST_EQ_NO||A.RPR_RQST_TMP_SEQ||A.RPR_RQST_TMP_VER_NO AS COMPLEX_PK," ).append("\n"); 
		query.append("        A.RQST_EQ_NO, A.RQST_REF_NO, TO_CHAR(A.EQ_DMG_DT,'YYYYMMDD') AS EQ_DMG_DT," ).append("\n"); 
		query.append("        A.CURR_CD, A.EDI_ID, A.RPR_OFFH_FLG, A.EDI_ERR_CD," ).append("\n"); 
		query.append("        B.EQ_LOC_CD, B.EQ_CMPO_CD, B.EQ_DMG_CD, B.EQ_RPR_CD, B.TRF_DIV_CD," ).append("\n"); 
		query.append("        B.VOL_TP_CD, B.RPR_QTY, B.RPR_SZ_NO, B.RPR_LBR_HRS, B.RPR_LBR_RT," ).append("\n"); 
		query.append("        B.LBR_COST_AMT, B.MTRL_COST_AMT, B.MNR_WRK_AMT, C.MNR_CD_DP_DESC AS EDI_ERR_NM" ).append("\n"); 
		query.append("FROM    MNR_RPR_RQST_TMP_HDR A," ).append("\n"); 
		query.append("        MNR_RPR_RQST_TMP_DTL B," ).append("\n"); 
		query.append("		MNR_GEN_CD C" ).append("\n"); 
		query.append("WHERE   A.RQST_EQ_NO = B.RQST_EQ_NO" ).append("\n"); 
		query.append("AND     A.RPR_RQST_TMP_SEQ = B.RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append("AND     A.RPR_RQST_TMP_VER_NO = B.RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append("AND     A.RPR_RQST_LST_VER_FLG = 'Y'      " ).append("\n"); 
		query.append("AND     A.EDI_ERR_CD = C.MNR_CD_ID" ).append("\n"); 
		query.append("AND     C.PRNT_CD_ID = 'CD00004'    " ).append("\n"); 
		query.append("#if (${complex_pk} != '')" ).append("\n"); 
		query.append("AND    	A.RQST_EQ_NO||A.RPR_RQST_TMP_SEQ||A.RPR_RQST_TMP_VER_NO IN(" ).append("\n"); 
		query.append("	#foreach($key IN ${complex_pk})" ).append("\n"); 
		query.append("		#if($velocityCount < $complex_pk.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}