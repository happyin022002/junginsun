/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TESCommonDBDAOGetUserOfcCdChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOGetUserOfcCdChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetUserOfcCdChk
	  * </pre>
	  */
	public TESCommonDBDAOGetUserOfcCdChkRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOGetUserOfcCdChkRSQL").append("\n"); 
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
		query.append("SELECT (CASE WHEN MO.OFC_KND_CD  = '1' THEN 'Y' " ).append("\n"); 
		query.append("            WHEN CU.OFC_CD = @[ofc_cd] THEN 'Y'" ).append("\n"); 
		query.append("       ELSE 'N' END) CHK_OFC_CD" ).append("\n"); 
		query.append("FROM COM_USER CU, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE CU.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND CU.USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND CU.OFC_CD = MO.OFC_CD" ).append("\n"); 

	}
}