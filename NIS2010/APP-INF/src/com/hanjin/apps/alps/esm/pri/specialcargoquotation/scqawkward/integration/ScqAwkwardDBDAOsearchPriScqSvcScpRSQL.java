/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOsearchPriScqSvcScpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.01
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.04.01 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOsearchPriScqSvcScpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_LOCATION
	  * MDM_SVC_SCP_LMT
	  * </pre>
	  */
	public ScqAwkwardDBDAOsearchPriScqSvcScpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOsearchPriScqSvcScpRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.SVC_SCP_CD AS SVC_SCP_CD" ).append("\n"); 
		query.append(" FROM  MDM_LOCATION A, MDM_SVC_SCP_LMT B," ).append("\n"); 
		query.append("       MDM_LOCATION C, MDM_SVC_SCP_LMT D" ).append("\n"); 
		query.append(" WHERE A.LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND A.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("   AND C.LOC_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND C.RGN_CD = D.RGN_CD" ).append("\n"); 
		query.append("   AND B.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("   AND D.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("   AND B.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append(" ORDER BY SVC_SCP_CD" ).append("\n"); 

	}
}