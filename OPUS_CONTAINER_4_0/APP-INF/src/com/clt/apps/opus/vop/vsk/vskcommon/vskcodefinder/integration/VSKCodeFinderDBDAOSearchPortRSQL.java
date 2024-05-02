/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정PORT에 대한 VVD 목록추출
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchPortRSQL").append("\n"); 
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
		query.append("SELECT  	VPS_PORT_CD AS VAL" ).append("\n"); 
		query.append("       ,	ROW_NUMBER() OVER(ORDER BY CLPT_SEQ) || '|' || YD_CD || '|' || CLPT_IND_SEQ || '|' || " ).append("\n"); 
		query.append("        	DECODE(PORT_SKD_STS_CD, 'A', 'Y', 'B', 'Y', 'D', 'Y', 'N') AS NAME" ).append("\n"); 
		query.append("  FROM  	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE  	VSL_CD     				= @[vsl_cd]" ).append("\n"); 
		query.append("   AND  	SKD_VOY_NO 				= @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  	SKD_DIR_CD 				= @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND  	TURN_PORT_IND_CD 		IN ('Y', 'N')" ).append("\n"); 
		query.append("   AND  	NVL(SKD_CNG_STS_CD,'X')	<> 'S'" ).append("\n"); 
		query.append("   AND VT_ADD_CALL_FLG IS NULL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${statusflag} == 'I')" ).append("\n"); 
		query.append("   AND  	PORT_SKD_STS_CD 		IN ('A', 'B', 'D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}