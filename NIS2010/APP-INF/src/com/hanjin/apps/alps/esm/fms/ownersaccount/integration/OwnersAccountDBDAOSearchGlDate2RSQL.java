/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOSearchGlDate2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOSearchGlDate2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/L Date - Payments Slip 조회
	  * </pre>
	  */
	public OwnersAccountDBDAOSearchGlDate2RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOSearchGlDate2RSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(DECODE(A.CNT, 1, DECODE(SUBSTR(MAX_EFF, 1, 6), " ).append("\n"); 
		query.append("                                TO_CHAR(SYSDATE, 'YYYYMM'), SYSDATE, " ).append("\n"); 
		query.append("                                TO_DATE(MAX_EFF, 'YYYYMMDD')), TO_DATE(MIN_EFF, 'YYYYMMDD')), 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("  FROM (SELECT TO_CHAR(MIN(LAST_DAY(TO_DATE(EFF_YRMON, 'YYYYMM'))), 'YYYYMMDD') MIN_EFF," ).append("\n"); 
		query.append("               TO_CHAR(MAX(TRUNC(TO_DATE(EFF_YRMON, 'YYYYMM'), 'MONTH')), 'YYYYMMDD') MAX_EFF," ).append("\n"); 
		query.append("               COUNT(P.EFF_YRMON) CNT" ).append("\n"); 
		query.append("          FROM AP_PERIOD P" ).append("\n"); 
		query.append("         WHERE P.SYS_DIV_CD = '17'" ).append("\n"); 
		query.append("           AND P.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("           AND P.CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("           AND OFC_CD = (SELECT S.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION S" ).append("\n"); 
		query.append("                 WHERE S.OFC_CD = @[ofc_cd]) ) A" ).append("\n"); 

	}
}