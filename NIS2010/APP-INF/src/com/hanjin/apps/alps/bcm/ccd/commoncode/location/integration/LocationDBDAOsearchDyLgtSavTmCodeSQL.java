/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : LocationDBDAOsearchDyLgtSavTmCodeSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOsearchDyLgtSavTmCodeSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DST Code를 생성한다
	  * </pre>
	  */
	public LocationDBDAOsearchDyLgtSavTmCodeSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnDstId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dstNotAplySteCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOsearchDyLgtSavTmCodeSQL").append("\n"); 
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
		query.append("#if(${dstNotAplySteCd} != '') " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("CASE WHEN DST_ID is NULL THEN  DST_ID2" ).append("\n"); 
		query.append("	 ELSE 'exist'" ).append("\n"); 
		query.append("END AS DST_ID     " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT (SELECT DST_ID FROM MDM_DYLGT_SAV_TM WHERE DST_ID LIKE @[fnDstId]||'%' AND DST_NOT_APLY_STE_CD = @[dstNotAplySteCd])DST_ID," ).append("\n"); 
		query.append("		   (SELECT @[fnDstId]||LPAD(NVL(MAX(SUBSTR(DST_ID, 5, 6)),0)+1,2,0) FROM MDM_DYLGT_SAV_TM WHERE DST_ID LIKE @[fnDstId]||'%') DST_ID2" ).append("\n"); 
		query.append("FROM dual)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("DECODE(DST_ID_SEQ, null, @[fnDstId]||'01', 'exist') DST_ID" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT MAX(SUBSTR(DST_ID, 5, 6)) DST_ID_SEQ" ).append("\n"); 
		query.append("    FROM MDM_DYLGT_SAV_TM" ).append("\n"); 
		query.append("    WHERE DST_ID LIKE @[fnDstId]||'%'" ).append("\n"); 
		query.append("    ORDER BY DST_ID DESC)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}