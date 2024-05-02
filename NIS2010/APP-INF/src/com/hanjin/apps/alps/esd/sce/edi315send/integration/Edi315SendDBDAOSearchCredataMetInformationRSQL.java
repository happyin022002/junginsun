/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCredataMetInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.09.30 전병석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Byoung Suk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCredataMetInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for searchCredataInformation
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCredataMetInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_poleta1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_blpod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bv_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_poleta1_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_blpol1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCredataMetInformationRSQL").append("\n"); 
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
		query.append("SELECT      TO_CHAR(TO_DATE(@[e_poleta1],     'YYYYMMDDHH24MI') + TZTM_HRS/24 + 2,    'YYYYMMDDHH24MI') podeta1," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[e_poleta1_gmt],'YYYYMMDDHH24MI') + TZTM_HRS/24 + 2,    'YYYYMMDDHH24MI') podeta1_gmt," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[e_poleta1] ,   'YYYYMMDDHH24MI') + TZTM_HRS/24 + 2 + 2,'YYYYMMDDHH24MI') podetd1," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[e_poleta1_gmt],'YYYYMMDDHH24MI') + TZTM_HRS/24 + 2 + 2,'YYYYMMDDHH24MI') podetd1_gmt" ).append("\n"); 
		query.append("FROM    PRD_OCN_ROUT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ORG_LOC_CD   = @[e_blpol1]" ).append("\n"); 
		query.append("AND DEST_LOC_CD  = @[e_blpod1]" ).append("\n"); 
		query.append("AND N1ST_LANE_CD = @[e_bv_lane]" ).append("\n"); 

	}
}