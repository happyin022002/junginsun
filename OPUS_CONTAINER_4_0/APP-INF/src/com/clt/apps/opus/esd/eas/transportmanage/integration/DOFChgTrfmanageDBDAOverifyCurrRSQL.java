/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOverifyCurrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOverifyCurrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * verifyCurr 입력된 curr_cd의 MDM내 존재여부 확인.
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOverifyCurrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration ").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOverifyCurrRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CURR_CNT" ).append("\n"); 
		query.append("FROM MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}