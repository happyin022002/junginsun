/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOSearchCurrencyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchCurrencyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Currency Inquiry
	  * </pre>
	  */
	public TESCommonDBDAOSearchCurrencyListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchCurrencyListRSQL").append("\n"); 
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
		query.append("	(SELECT	AR_CURR_CD" ).append("\n"); 
		query.append("	FROM	MDM_ORGANIZATION" ).append("\n"); 
		query.append("	WHERE	OFC_CD = @[ofc_cd] AND DELT_FLG = 'N') DEF" ).append("\n"); 
		query.append("	,(SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(CURR_CD,'|')),'|')" ).append("\n"); 
		query.append("	FROM	(SELECT	ROWNUM ROW_ID" ).append("\n"); 
		query.append("			, Z.CURR_CD" ).append("\n"); 
		query.append("		FROM	(SELECT CURR_CD" ).append("\n"); 
		query.append("			FROM	MDM_CURRENCY" ).append("\n"); 
		query.append("			WHERE	NVL(DELT_FLG,'N')<>'Y'  " ).append("\n"); 
		query.append("			ORDER BY CURR_CD" ).append("\n"); 
		query.append("			)  Z" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("	START WITH ROW_ID = 1" ).append("\n"); 
		query.append("	) CURR_LIST" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}