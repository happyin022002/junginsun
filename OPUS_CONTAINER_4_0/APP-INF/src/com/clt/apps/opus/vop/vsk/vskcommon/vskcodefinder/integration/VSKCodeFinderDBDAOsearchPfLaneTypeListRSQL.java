/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VSKCodeFinderDBDAOsearchPfLaneTypeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.19 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOsearchPfLaneTypeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPfLaneTypeList
	  * </pre>
	  */
	public VSKCodeFinderDBDAOsearchPfLaneTypeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOsearchPfLaneTypeListRSQL").append("\n"); 
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
		query.append("SELECT	ROWNUM AS RNUM,T1.VSL_SLAN_CD, T2.VSL_SLAN_NM, T1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("FROM	VSK_PF_SKD T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("WHERE	T1.VSL_SLAN_CD	= T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND	T1.VSL_SLAN_CD	LIKE @[vsl_slan_cd] || '%'" ).append("\n"); 
		query.append("AND	T1.DELT_FLG	= 'N'" ).append("\n"); 
		query.append("AND T2.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 

	}
}