/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSCCheckmanageDBDAOSearchSubOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.10.16 최진오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JIN O CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSCCheckmanageDBDAOSearchSubOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * User가 선택한 Office의 하위 Office를 찾아옴.
	  * </pre>
	  */
	public MSCCheckmanageDBDAOSearchSubOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration ").append("\n"); 
		query.append("FileName : MSCCheckmanageDBDAOSearchSubOfcListRSQL").append("\n"); 
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
		query.append("#set(${asoOfc}=${asoOfc})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${asoOfc} != '' )" ).append("\n"); 
		query.append("#foreach(${key} IN ${asoOfc})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("START WITH OFC_CD = '${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("START WITH OFC_CD = '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}