/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOSearchOfficeCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchOfficeCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office 코드 정보 조회.
	  * 2010.12.30 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * </pre>
	  */
	public CommonDBDAOSearchOfficeCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchOfficeCondRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    -- 화면별 CONVERSION된 OFFICE정보를 가져온다(화면별 권한 처리)" ).append("\n"); 
		query.append("    SELECT SPC_SCR_OFC_CONV_FNC(@[ofc_cd], @[ui_name]) AS OFC_CD," ).append("\n"); 
		query.append("           @[ofc_cd] ORG_OFC_CD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT O.ADM   ," ).append("\n"); 
		query.append("         O.RHQ_CD," ).append("\n"); 
		query.append("         O.AQ_CD ," ).append("\n"); 
		query.append("         SO.N4TH_PRNT_OFC_CD AS RGN_OFC_CD," ).append("\n"); 
		query.append("         O.OFC_CD," ).append("\n"); 
		query.append("         SO.OFC_TP_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT DECODE(SUM(DECODE(O.OFC_TP_CD, 'HT', 1, 'HG', 1, 0)) * SUM(DECODE(O.OFC_CD, 'SELMDC', 1, 0)), 0, 'N', 'Y') AS ADM," ).append("\n"); 
		query.append("                   -- 본사조직이고 컨선SBU의 USER는 ADMIN" ).append("\n"); 
		query.append("                   MAX(DECODE(O.OFC_TP_CD, 'HQ', O.OFC_CD)) AS RHQ_CD    ," ).append("\n"); 
		query.append("                   MAX(DECODE(O.OFC_TP_CD, 'AQ', O.OFC_CD)) AS AQ_CD     ," ).append("\n"); 
		query.append("                   MAX(P.OFC_CD)                            AS OFC_CD    ," ).append("\n"); 
		query.append("                   MAX(P.ORG_OFC_CD)                        AS ORG_OFC_CD" ).append("\n"); 
		query.append("              FROM MDM_ORGANIZATION O," ).append("\n"); 
		query.append("                   PARAM            P" ).append("\n"); 
		query.append("        CONNECT BY NOCYCLE PRIOR O.PRNT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                   START WITH O.OFC_CD = P.OFC_CD" ).append("\n"); 
		query.append("         ) O," ).append("\n"); 
		query.append("         SPC_OFC_LVL SO," ).append("\n"); 
		query.append("         COA_WK_PRD  WK" ).append("\n"); 
		query.append("   WHERE SO.OFC_CD = --지역그룹팀의 경우 본인의 타입을 넣어준다(HQ로 인식되는것을 막기 위해)" ).append("\n"); 
		query.append("                     CASE" ).append("\n"); 
		query.append("                          WHEN ORG_OFC_CD IN ( 'HAMUAG'," ).append("\n"); 
		query.append("                                               'HAMUOG'," ).append("\n"); 
		query.append("                                               'HAMUSG'," ).append("\n"); 
		query.append("                                               'HAMUXG'," ).append("\n"); 
		query.append("                                               'SHAAAG'," ).append("\n"); 
		query.append("                                               'SHAADG'," ).append("\n"); 
		query.append("                                               'SHAALG'," ).append("\n"); 
		query.append("                                               'SHAAOG'," ).append("\n"); 
		query.append("                                               'SHAASG'" ).append("\n"); 
		query.append("                                             ) THEN O.ORG_OFC_CD" ).append("\n"); 
		query.append("                                               ELSE O.OFC_CD" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("     AND WK.COST_YR || WK.COST_WK BETWEEN SO.OFC_APLY_FM_YRWK AND SO.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN WK.SLS_FM_DT AND WK.SLS_TO_DT" ).append("\n"); 

	}
}