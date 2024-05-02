/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchYardListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.09.24 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchYardListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchYardList
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchYardListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration ").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchYardListRSQL").append("\n"); 
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
		query.append("SELECT  T1.YD_CD , YD_NM" ).append("\n"); 
		query.append(", NVL(PLT_MNVR_TM_HRS, 0) AS MNVR_IN_HRS" ).append("\n"); 
		query.append(", NVL(PLT_MNVR_TM_HRS, 0) AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("FROM	MDM_YARD T1, VSK_PORT_MNVR T2" ).append("\n"); 
		query.append("WHERE	1		= 1" ).append("\n"); 
		query.append("AND	T1.YD_CD	= T2.YD_CD (+)" ).append("\n"); 
		query.append("AND	T1.DELT_FLG	= 'N'" ).append("\n"); 
		query.append("AND	T1.YD_CHR_CD	= 'N'" ).append("\n"); 
		query.append("AND	T1.YD_CD	=  @[yd_cd]" ).append("\n"); 

	}
}