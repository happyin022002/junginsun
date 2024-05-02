/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : AuthorizationAssignmentDBDAOSCOrganizationVORSQL.java
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

public class AuthorizationAssignmentDBDAOSCOrganizationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Organization Tree
	  * 2013.06.07 [CHM-201325078] 송호진 HAMRUC, SINRSC, NYCRAC 조직 코드 변경에 따른 수정
	  * ( HAMRUC SINRSC NYCRAC ) 
	  * 2013.06.27 [CHM-201325462] 송호진 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제
	  * 2014.01.13 [CHM-201428351] 전윤주 SELSC, TYOSC 조직변경으로 하드코딩 추가
	  * 2014.09.26 [CHM-201432173] 송호진 SST(Trade 그룹), SSC(Customer 그룹) MDM 반영에 대한 ALPS 상 조치 SELCM 코드 추가
	  * 2015.07.10 [CHM-201432173] 최성환 [CHM-201536867] S/C & TRI Authority Creation 상 Control Office 추가 SAOLA 추가) 
	  * 2015.01.05 [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOSCOrganizationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOSCOrganizationVORSQL").append("\n"); 
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
		query.append("WITH OFC AS ( " ).append("\n"); 
		query.append("    SELECT OFC_CD " ).append("\n"); 
		query.append("         , OFC_CD AS OFC_ENG_NM " ).append("\n"); 
		query.append("         , OFC_TP_CD " ).append("\n"); 
		query.append("         , PRNT_OFC_CD " ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("    WHERE (     ( " ).append("\n"); 
		query.append("                    OFC_TP_CD IN ('HQ', 'QT') " ).append("\n"); 
		query.append("                    OR OFC_CD IN ('SELDC', 'SELGNS','SELCMQ' ,'SELGMS'" ).append("\n"); 
		query.append("                      ,'SELCMA','SELCMI','SELCMD') " ).append("\n"); 
		query.append("                )     " ).append("\n"); 
		query.append("                AND   OFC_CD LIKE 'SEL%' " ).append("\n"); 
		query.append("                AND   OFC_CD NOT LIKE 'SELIB%' " ).append("\n"); 
		query.append("                AND   DELT_FLG = 'N' " ).append("\n"); 
		query.append("           ) OR  OFC_CD IN ('NYCRA', 'PHXSA') " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT LEVEL " ).append("\n"); 
		query.append("     , PRNT_OFC_CD " ).append("\n"); 
		query.append("     , A.OFC_CD " ).append("\n"); 
		query.append("     , A.OFC_ENG_NM " ).append("\n"); 
		query.append("FROM OFC A " ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("START WITH A.OFC_CD='SELDC'" ).append("\n"); 
		query.append("CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD" ).append("\n"); 
		query.append("ORDER SIBLINGS BY A.OFC_CD" ).append("\n"); 

	}
}