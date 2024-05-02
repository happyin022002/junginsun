/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BasicDataDBDAOCheckOfficeValidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOCheckOfficeValidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Office가 Region Office 체크합니다.
	  * </pre>
	  */
	public BasicDataDBDAOCheckOfficeValidRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCheckOfficeValidRSQL").append("\n"); 
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
		query.append("SELECT N4TH_PRNT_OFC_CD AS SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("  FROM SPC_OFC_LVL SOV," ).append("\n"); 
		query.append("       COA_WK_PRD  W" ).append("\n"); 
		query.append(" WHERE SOV.OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("   AND SOV.OFC_CD = N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("   AND W.COST_YR || W.COST_WK BETWEEN SOV.OFC_APLY_FM_YRWK AND SOV.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("   AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 

	}
}