/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RehandExpmanageDBDAOSearchSubOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RehandExpmanageDBDAOSearchSubOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSubOffice
	  * </pre>
	  */
	public RehandExpmanageDBDAOSearchSubOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.terminalmanage.integration ").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOSearchSubOfficeRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(OFC_CD,',')),',') ETC	" ).append("\n"); 
		query.append("	FROM(														" ).append("\n"); 
		query.append("		SELECT ROWNUM ROW_ID, OFC_CD							" ).append("\n"); 
		query.append("		FROM(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("	#foreach($ofc_cd_num IN ${ofc_cd})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("				SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("				WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("				CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("				START WITH OFC_CD = '$ofc_cd_num'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("				WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("				CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("				START WITH OFC_CD = '$ofc_cd_num'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		        )													" ).append("\n"); 
		query.append("		    )														" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1						" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 

	}
}