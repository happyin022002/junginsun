/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrAccuracyTrendDBDAOSearchLoadingTrendByPortDefaultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrAccuracyTrendDBDAOSearchLoadingTrendByPortDefaultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면로딩시 기본정보 설정
	  * </pre>
	  */
	public CntrAccuracyTrendDBDAOSearchLoadingTrendByPortDefaultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.integration").append("\n"); 
		query.append("FileName : CntrAccuracyTrendDBDAOSearchLoadingTrendByPortDefaultRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', SYSDATE-7, @[ofc_cd]), 'YYYY-MM-DD') ETA_FM_DT " ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', SYSDATE+7, @[ofc_cd]), 'YYYY-MM-DD') ETA_TO_DT " ).append("\n"); 
		query.append("       ,( SELECT PLN_YR||PLN_WK" ).append("\n"); 
		query.append("            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("            WHERE TO_CHAR(SYSDATE-7,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT ) FM_WK" ).append("\n"); 
		query.append("       ,( SELECT PLN_YR||PLN_WK" ).append("\n"); 
		query.append("            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("            WHERE TO_CHAR(SYSDATE+7,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT ) TO_WK" ).append("\n"); 
		query.append("       ,( SELECT A.RCC_CD " ).append("\n"); 
		query.append("            FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                ,MDM_LOCATION B" ).append("\n"); 
		query.append("                ,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("           WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("             AND B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("             AND C.OFC_CD = @[ofc_cd] ) RCC_CD" ).append("\n"); 
		query.append("       ,( SELECT C.OFC_TP_CD " ).append("\n"); 
		query.append("            FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                ,MDM_LOCATION B" ).append("\n"); 
		query.append("                ,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("           WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("             AND B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("             AND C.OFC_CD = @[ofc_cd] ) OFC_TP_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}