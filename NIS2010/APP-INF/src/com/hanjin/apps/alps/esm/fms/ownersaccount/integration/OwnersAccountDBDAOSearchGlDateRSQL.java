/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOSearchGlDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.03.25 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOSearchGlDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/L Date 조회
	  * </pre>
	  */
	public OwnersAccountDBDAOSearchGlDateRSQL(){
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
		query.append("FileName : OwnersAccountDBDAOSearchGlDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(DECODE(A.CNT, 1, MAX_EFF, MIN_EFF), 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("  FROM (SELECT MIN(LAST_DAY(TO_DATE(EFF_YRMON, 'YYYYMM'))) MIN_EFF," ).append("\n"); 
		query.append("               MAX(TRUNC(TO_DATE(EFF_YRMON, 'YYYYMM'), 'MONTH')) MAX_EFF," ).append("\n"); 
		query.append("               COUNT(P.EFF_YRMON) CNT" ).append("\n"); 
		query.append("          FROM AP_PERIOD P" ).append("\n"); 
		query.append("         WHERE P.SYS_DIV_CD = '17'" ).append("\n"); 
		query.append("           AND P.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("           AND P.CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("           AND OFC_CD = (SELECT S.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION S" ).append("\n"); 
		query.append("                 WHERE S.OFC_CD = @[ofc_cd]) ) A " ).append("\n"); 

	}
}