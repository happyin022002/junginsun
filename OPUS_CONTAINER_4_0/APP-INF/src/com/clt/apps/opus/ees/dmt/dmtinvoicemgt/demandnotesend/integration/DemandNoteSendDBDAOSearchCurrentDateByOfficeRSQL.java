/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DemandNoteSendDBDAOSearchCurrentDateByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemandNoteSendDBDAOSearchCurrentDateByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCurrentDateByOffice
	  * </pre>
	  */
	public DemandNoteSendDBDAOSearchCurrentDateByOfficeRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration ").append("\n"); 
		query.append("FileName : DemandNoteSendDBDAOSearchCurrentDateByOfficeRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),SYSDATE),'YYYYMMDD') AS CURR_DAY" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}