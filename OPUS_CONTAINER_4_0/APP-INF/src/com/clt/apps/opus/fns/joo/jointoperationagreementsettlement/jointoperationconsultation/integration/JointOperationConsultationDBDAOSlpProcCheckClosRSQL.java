/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlpProcCheckClosRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlpProcCheckClosRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Effect Date일자로 closing 여부를 check한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlpProcCheckClosRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ap_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlpProcCheckClosRSQL").append("\n"); 
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
		query.append("SELECT CLZ_STS_CD AS VVD_CXL_FLG" ).append("\n"); 
		query.append("     , DECODE(A.CLZ_STS_CD, 'C', (  SELECT TO_CHAR(TO_DATE(NEX_EFF_YRMON||'01','YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("                                      FROM (SELECT '1' AS SEQ" ).append("\n"); 
		query.append("                                                 , MIN(EFF_YRMON) NEX_EFF_YRMON" ).append("\n"); 
		query.append("                                              FROM AP_PERIOD A" ).append("\n"); 
		query.append("                                             WHERE SYS_DIV_CD = DECODE(AR_AP_DIV_CD, 'R', '18', '19')" ).append("\n"); 
		query.append("                                               AND CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("                                               AND EFF_YRMON > SUBSTR(REPLACE(@[eff_dt],'-',''), 1, 6)" ).append("\n"); 
		query.append("                                               AND AR_AP_DIV_CD = @[ar_ap_div_cd]" ).append("\n"); 
		query.append("                                               AND OFC_CD = @[slp_ofc_cd]" ).append("\n"); 
		query.append("                                             UNION ALL" ).append("\n"); 
		query.append("                                            SELECT '2' AS SEQ" ).append("\n"); 
		query.append("                                                 , MIN(EFF_YRMON) NEX_EFF_YRMON" ).append("\n"); 
		query.append("                                              FROM AP_PERIOD A" ).append("\n"); 
		query.append("                                             WHERE SYS_DIV_CD = DECODE(AR_AP_DIV_CD, 'R', '18', '19')" ).append("\n"); 
		query.append("                                               AND CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("                                               AND EFF_YRMON > SUBSTR(REPLACE(@[eff_dt],'-',''), 1, 6)" ).append("\n"); 
		query.append("                                               AND AR_AP_DIV_CD = @[ar_ap_div_cd]" ).append("\n"); 
		query.append("                                               AND OFC_CD = (SELECT X.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                              FROM MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                                                             WHERE X.OFC_CD = @[slp_ofc_cd] )" ).append("\n"); 
		query.append("                                             ORDER BY 1 )" ).append("\n"); 
		query.append("                                     WHERE NEX_EFF_YRMON IS NOT NULL" ).append("\n"); 
		query.append("                                       AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                                 , TO_CHAR(TO_DATE(A.MAX_EFF_YRMON||'01','YYYYMMDD'),'YYYYMMDD')) EFF_DT" ).append("\n"); 
		query.append("  FROM (SELECT -- 입력한 월보다 이전것중 Open된 월이 여럿있을 경우 error message" ).append("\n"); 
		query.append("               DECODE(A.CLZ_STS_CD, 'O', DECODE(SUBSTR(REPLACE(@[eff_dt],'-',''), 1, 6), MAX_EFF_YRMON, DECODE(MIN_EFF_YRMON, MAX_EFF_YRMON, 'O','X'), 'C'), A.CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("             , A.MIN_EFF_YRMON" ).append("\n"); 
		query.append("             , A.MAX_EFF_YRMON" ).append("\n"); 
		query.append("          FROM (SELECT '1' AS SEQ" ).append("\n"); 
		query.append("                     , MAX(CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("                     , MIN(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MIN_EFF_YRMON" ).append("\n"); 
		query.append("                     , MAX(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MAX_EFF_YRMON" ).append("\n"); 
		query.append("                  FROM AP_PERIOD A" ).append("\n"); 
		query.append("                 WHERE SYS_DIV_CD = DECODE(AR_AP_DIV_CD, 'R', '18', '19')" ).append("\n"); 
		query.append("                   AND EFF_YRMON <= SUBSTR(REPLACE(@[eff_dt],'-',''), 1, 6)" ).append("\n"); 
		query.append("                   AND AR_AP_DIV_CD = @[ar_ap_div_cd]" ).append("\n"); 
		query.append("                   AND OFC_CD = @[slp_ofc_cd]" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT '2' AS SEQ" ).append("\n"); 
		query.append("                     , MAX(CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("                     , MIN(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MIN_EFF_YRMON" ).append("\n"); 
		query.append("                     , MAX(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MAX_EFF_YRMON" ).append("\n"); 
		query.append("                  FROM AP_PERIOD A" ).append("\n"); 
		query.append("                 WHERE SYS_DIV_CD = DECODE(AR_AP_DIV_CD, 'R', '18', '19')" ).append("\n"); 
		query.append("                   AND EFF_YRMON <= SUBSTR(REPLACE(@[eff_dt],'-',''), 1, 6)" ).append("\n"); 
		query.append("                   AND AR_AP_DIV_CD = @[ar_ap_div_cd]" ).append("\n"); 
		query.append("                   AND OFC_CD = (SELECT X.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                                 WHERE X.OFC_CD = @[slp_ofc_cd] )" ).append("\n"); 
		query.append("                 ORDER BY 1 ) A" ).append("\n"); 
		query.append("         WHERE A.CLZ_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("           AND ROWNUM = 1 ) A" ).append("\n"); 

	}
}