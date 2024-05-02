/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : AuthorizationAssignmentDBDAORFAOrganizationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.16
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.03.16 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationAssignmentDBDAORFAOrganizationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Organization Tree
	  * 2013.06.07 [CHM-201325078] 송호진 HAMUKG, SINWKG, NYCNKG 조직 코드 변경에 따른 수정
	  * ( HAMRUC, SINRSC, NYCRAC) 
	  * 2013.06.14 [CHM-201325245] 송호진 조직코드 변경 및 병행 관리 관련 기존 코드에 신규 코드 추가
	  * 6 월 말 기존 코드 삭제 예정 ( CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB )
	  * 2013.06.27 [CHM-201325462] 송호진 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제
	  * 2014.01.09 [CHM-201428351] 전윤주 SELIB, TYOIB, SELCMI 가상 조직 추가에 따른 하드코딩 추가 
	  * 2014.09.26 [CHM-201432173] 송호진 SST(Trade 그룹), SSC(Customer 그룹) MDM 반영에 대한 ALPS 상 조치 SELCM 코드 추가
	  * 2015.01.05 [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAORFAOrganizationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAORFAOrganizationVORSQL").append("\n"); 
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
		query.append("WITH OFC AS (" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT PRNT_OFC_CD" ).append("\n"); 
		query.append("             , OFC_CD" ).append("\n"); 
		query.append("             , OFC_CD AS OFC_ENG_NM" ).append("\n"); 
		query.append("             , LTRIM(SYS_CONNECT_BY_PATH(LPAD(OFC_CD, 6, ' '), '|'), '|') BY_PATH" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND   DECODE(DELT_FLG, 'Y', 0, 1) = 1" ).append("\n"); 
		query.append("        START WITH OFC_CD='SELDC'" ).append("\n"); 
		query.append("        CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("    ) OFC" ).append("\n"); 
		query.append("    WHERE OFC.OFC_CD = 'SELDC'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%SELGNS%'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%SELGMS%'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%SELIB%'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%TYOIB%'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%NYCRA%'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%SHARC%'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%SINRS%'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%SELCMI%'" ).append("\n"); 
		query.append("    OR    OFC.BY_PATH LIKE '%SELCMD%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT LEVEL" ).append("\n"); 
		query.append("      ,PRNT_OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_ENG_NM" ).append("\n"); 
		query.append("FROM OFC A" ).append("\n"); 
		query.append("START WITH A.OFC_CD='SELDC'" ).append("\n"); 
		query.append("CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD" ).append("\n"); 
		query.append("ORDER SIBLINGS BY A.OFC_CD" ).append("\n"); 

	}
}