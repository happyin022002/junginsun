/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCommonManageDBDAOSearchSubContinentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.10 노승배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Noh Seung Bae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOSearchSubContinentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSubContinent
	  * </pre>
	  */
	public PrdCommonManageDBDAOSearchSubContinentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOSearchSubContinentRSQL").append("\n"); 
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
		query.append("SELECT SCONTI_CD conti_code, SCONTI_NM conti_name FROM MDM_SUBCONTINENT WHERE CONTI_CD= @[conti_code] and nvl( delt_flg,'N') <> 'Y'" ).append("\n"); 

	}

}