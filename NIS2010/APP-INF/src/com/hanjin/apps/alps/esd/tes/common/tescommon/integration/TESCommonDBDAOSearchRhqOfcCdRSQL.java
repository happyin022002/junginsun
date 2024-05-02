/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESCommonDBDAOSearchRhqOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.17 
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

public class TESCommonDBDAOSearchRhqOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Regional Head Office 조회
	  * </pre>
	  */
	public TESCommonDBDAOSearchRhqOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchRhqOfcCdRSQL").append("\n"); 
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
		query.append("CASE WHEN NVL(COUNT(R.RHQ),0) > 0 THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("DISTINCT M.AR_HD_QTR_OFC_CD RHQ" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(M.DELT_fLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND M.OFC_TP_CD IN ('HQ','QT')" ).append("\n"); 
		query.append(") R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND R.RHQ = @[acct_ofc_cd]" ).append("\n"); 

	}
}