/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAOApprovalOfficeNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOApprovalOfficeNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval Office list
	  * 2013.06.14 [CHM-201325245] 송호진 조직코드 변경 및 병행 관리 관련 기존 코드에 신규 코드 추가
	  * 6 월 말 기존 코드 삭제 예정 ( CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB )
	  * 2013.06.27 [CHM-201325462] 송호진 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
	  * 2015.07.10 최성환 [CHM-201536867] S/C & TRI Authority Creation 상 Control Office 추가 SAOLA 추가) 
	  * 2015.01.05 [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
	  * </pre>
	  */
	public PRICommonDBDAOApprovalOfficeNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOApprovalOfficeNewRSQL").append("\n"); 
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
		query.append("SELECT   OFC_CD CD" ).append("\n"); 
		query.append("        ,OFC_ENG_NM NM" ).append("\n"); 
		query.append("FROM     MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE    DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND      OFC_CD IN" ).append("\n"); 
		query.append("           (SELECT AUTH_APRO_OFC_CD " ).append("\n"); 
		query.append("              FROM PRI_AUTH_APRO_OFC" ).append("\n"); 
		query.append("             WHERE PRC_CTRT_TP_CD = 'S'" ).append("\n"); 
		query.append("               AND PRC_OFC_AUTH_TP_CD = 'A'" ).append("\n"); 
		query.append("               AND AUTH_APRO_USE_FLG = 'Y')" ).append("\n"); 

	}
}