/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOOffceLvlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.08.07 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOOffceLvlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인한 off_cd 로 offce 의 레벨을 조회한다.
	  * </pre>
	  */
	public EacMgtDBDAOOffceLvlRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOOffceLvlRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN @[ofc_cd] = 'SELADG' THEN 'H'" ).append("\n"); 
		query.append("            WHEN @[ofc_cd] = TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(@[ofc_cd]) THEN 'R'" ).append("\n"); 
		query.append("            ELSE 'O'" ).append("\n"); 
		query.append("       END OFC_TP_CD" ).append("\n"); 
		query.append("     , CASE WHEN @[ofc_cd] = 'SELADG' THEN 'SELADG'" ).append("\n"); 
		query.append("            ELSE TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(@[ofc_cd]) " ).append("\n"); 
		query.append("       END AS RHQ_OFC_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}