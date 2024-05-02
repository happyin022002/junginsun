/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckVskVslPortSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCheckVskVslPortSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Port Schedule에 VVD, Port가 존재하는지 확인한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckVskVslPortSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckVskVslPortSkdRSQL").append("\n"); 
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
		query.append("SELECT  NVL(SUM (1), 0) AS CNT" ).append("\n"); 
		query.append("		, NVL(SUM (" ).append("\n"); 
		query.append("                  CASE WHEN TURN_PORT_IND_CD IN ('D', 'V', 'F') AND (TURN_SKD_VOY_NO != @[turn_skd_voy_no] OR TURN_SKD_DIR_CD != @[turn_skd_dir_cd])" ).append("\n"); 
		query.append("                       THEN 1" ).append("\n"); 
		query.append("                       ELSE 0" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("              ), 0) AS VRT_CNT /* 연결하려는 VVD에 쪽 VIRUAL PORT에 사용자가 입력하는 TURN VVD가 같은지 확인*/ " ).append("\n"); 
		query.append("        , MAX((" ).append("\n"); 
		query.append("            SELECT  MAX(VSL_CD || TURN_SKD_VOY_NO || TURN_SKD_DIR_CD)" ).append("\n"); 
		query.append("            FROM    VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("            WHERE   VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("            AND     SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND     TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("          )) AS VVD	/* 연결하려는 VVD에 쪽 VIRUAL PORT에 VVD를 조회 */ " ).append("\n"); 
		query.append("        , MAX((" ).append("\n"); 
		query.append("            SELECT  MAX(TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("            FROM    VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("            WHERE   VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("            AND     SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND     NVL(SKD_CNG_STS_CD, 'SKD_CNG_STS_CD')  <> 'S'" ).append("\n"); 
		query.append("            AND     TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("            AND     NVL(VT_ADD_CALL_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("          )) AS VPS_ETD_DT" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("WHERE	VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 

	}
}