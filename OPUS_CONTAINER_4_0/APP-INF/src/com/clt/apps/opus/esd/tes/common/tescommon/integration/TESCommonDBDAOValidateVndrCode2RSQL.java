/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESCommonDBDAOValidateVndrCode2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOValidateVndrCode2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Validate Vendor Code
	  * </pre>
	  */
	public TESCommonDBDAOValidateVndrCode2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOValidateVndrCode2RSQL").append("\n"); 
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
		query.append("SELECT	CASE WHEN COUNT(VNDR_SEQ)>0 THEN 'Y' ELSE 'N' END VNDR_SEQ_EXISTING" ).append("\n"); 
		query.append(", VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append("FROM	MDM_VENDOR" ).append("\n"); 
		query.append("WHERE	VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("GROUP BY VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 

	}
}