/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchCurrCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.04.10 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchCurrCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCurrCd
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchCurrCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchCurrCdRSQL").append("\n"); 
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
		query.append("'EUR|USD'||DECODE((SELECT M.CURR_CD FROM MDM_COUNTRY M WHERE M.CNT_CD LIKE SUBSTR(DECODE(LENGTH(NVL(@[scc_cd2],'XXX')),1,'XXX',NVL(@[scc_cd2],'XXX')),1,2)||'%' AND M.CURR_CD NOT IN ('EUR','USD')),NULL,'','','','|')||(" ).append("\n"); 
		query.append("SELECT M.CURR_CD FROM MDM_COUNTRY M WHERE M.CNT_CD LIKE SUBSTR(DECODE(LENGTH(NVL(@[scc_cd2],'XXX')),1,'XXX',NVL(@[scc_cd2],'XXX')),1,2)||'%' AND M.CURR_CD NOT IN ('EUR','USD')) CURR_LIST_CTNT2" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("NVL((SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN B.YD_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END SCC_YD_CHK" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_YARD B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.SCC_CD = @[scc_cd2]" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("),'N') SCC_YD_CHK," ).append("\n"); 
		query.append("(   SELECT L.PORT_INLND_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND L.LOC_CD = @[scc_cd2] ) PORT_INLND_CD2" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}