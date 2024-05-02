/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchNewDARYrMonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchNewDARYrMonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DB 시스템의 Year, Month 정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchNewDARYrMonRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchNewDARYrMonRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), SYSDATE), 'YYMM')" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}