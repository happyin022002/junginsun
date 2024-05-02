/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommonDBDAOSearchAsaNoListBySbOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchAsaNoListBySbOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAsaNoListBySbOfcCd
	  * </pre>
	  */
	public AGTCommonDBDAOSearchAsaNoListBySbOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchAsaNoListBySbOfcCdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT A.ASA_NO AS CODE," ).append("\n"); 
		query.append("A.ASA_NO||' ('||A.ASA_CURR_CD||', '" ).append("\n"); 
		query.append("||TO_CHAR(TO_DATE(A.ASA_PRD_FM_DT,'YYYYMMDD'),'YYYY/MM/DD')" ).append("\n"); 
		query.append("||' ~ '" ).append("\n"); 
		query.append("||TO_CHAR(TO_DATE(A.ASA_PRD_TO_DT,'YYYYMMDD'),'YYYY/MM/DD')" ).append("\n"); 
		query.append("||')' AS NAME," ).append("\n"); 
		query.append("A.ASA_PRD_FM_DT" ).append("\n"); 
		query.append("FROM AR_AGN_STMT_AGMT A," ).append("\n"); 
		query.append("MDM_ORGANIZATION B," ).append("\n"); 
		query.append("MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE A.ASA_OFC_CD IN" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("DISTINCT AR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE ((SUBSTR(LOC_CD,1,2) = 'CN' AND OFC_CD = @[code]) OR (AR_OFC_CD = @[code]))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.EXPN_EFF_DT IS NULL" ).append("\n"); 
		query.append("AND A.AC_EFF_DT IS NULL" ).append("\n"); 
		query.append("AND A.ASA_CLZ_DT IS NULL" ).append("\n"); 
		query.append("AND A.ASA_APRO_DT IS NULL" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND A.ASA_OFC_CD  = B.AR_OFC_CD" ).append("\n"); 
		query.append("AND A.ASA_CURR_CD = B.AR_CURR_CD" ).append("\n"); 
		query.append("AND NVL(B.SO_IF_CD,' ') = 'O'" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY 3 DESC" ).append("\n"); 

	}
}