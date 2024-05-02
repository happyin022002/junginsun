/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VSKCodeFinderDBDAORhqOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAORhqOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port 정보를 관리하는 상위 Office 정보를 조회한다.
	  * </pre>
	  */
	public VSKCodeFinderDBDAORhqOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAORhqOfficeRSQL").append("\n"); 
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
		query.append("SELECT    DISTINCT" ).append("\n"); 
		query.append("          X.AR_HD_QTR_OFC_CD	AS PRNT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM      MDM_ORGANIZATION  	X" ).append("\n"); 
		query.append("WHERE     X.OFC_KND_CD       	= '2'" ).append("\n"); 
		query.append("AND       X.AR_HD_QTR_OFC_CD 	IS NOT NULL" ).append("\n"); 
		query.append("AND       X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY  DECODE(X.AR_HD_QTR_OFC_CD,'HAMRU','1','PHXRA','2','SHARC','3','SINRS','4','SELSC','5','TYOSC','6','VVOIA','7','9')                 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SELECT" ).append("\n"); 
		query.append("--	DISTINCT PRNT_OFC_CD" ).append("\n"); 
		query.append("--FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("--WHERE OFC_KND_CD = '2'" ).append("\n"); 
		query.append("--AND PRNT_OFC_CD != 'SELDC'" ).append("\n"); 
		query.append("--START WITH PRNT_OFC_CD = 'SELDC'" ).append("\n"); 
		query.append("--CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("--ORDER BY 1" ).append("\n"); 

	}
}