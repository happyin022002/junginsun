/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchVvdByEdiActualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchVvdByEdiActualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI로 수신 받은 Call Sign No 또는 Vessel Code 또는 IMO No, Port Code 와 일치하고
	  * ETA, ETB, ETD 가 ATA, ATB, ATD 와 차이가 +-24시간 이내인 VVD를 구한다.
	  * --------------------------------------------------------------------------
	  * 2011.09.09 CHM-201113239-01 김민아 신규.  Sked EDI 수신후 Actual sked의 Voyage/Direction을 찿는 Logic 추가(2)
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchVvdByEdiActualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchVvdByEdiActualRSQL").append("\n"); 
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
		query.append("/** Virtual Port 인 경우, Turning Port로 변환하여 처리*/" ).append("\n"); 
		query.append("SELECT 		DISTINCT " ).append("\n"); 
		query.append("			VSL_CD" ).append("\n"); 
		query.append("		,	CASE 	WHEN TURN_PORT_IND_CD IN ('D', 'V', 'F') THEN TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("      				ELSE SKD_VOY_NO" ).append("\n"); 
		query.append("      		END 	SKD_VOY_NO" ).append("\n"); 
		query.append("		,	CASE 	WHEN TURN_PORT_IND_CD IN ('D', 'V', 'F') THEN TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("      				ELSE SKD_DIR_CD" ).append("\n"); 
		query.append("      		END 	SKD_DIR_CD" ).append("\n"); 
		query.append("		,	CASE 	WHEN TURN_PORT_IND_CD IN ('D', 'V', 'F') THEN TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      				ELSE CLPT_IND_SEQ" ).append("\n"); 
		query.append("      		END 	CLPT_IND_SEQ  " ).append("\n"); 
		query.append("FROM   		VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  		1 = 1" ).append("\n"); 
		query.append("AND    		VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("AND    		VPS_PORT_CD 	= @[vps_port_cd]" ).append("\n"); 
		query.append("AND			YD_CD			= @[yd_cd]" ).append("\n"); 
		query.append("AND    		'S'        		!= NVL(SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_arr_dt} != '' && ${act_brth_dt} != '' && ${act_dep_dt} != '') " ).append("\n"); 
		query.append("AND    		VPS_ETA_DT 		BETWEEN TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI')-1 AND TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI')+1" ).append("\n"); 
		query.append("AND    		VPS_ETB_DT 		BETWEEN TO_DATE(@[act_brth_dt], 'YYYYMMDDHH24MI')-1 AND TO_DATE(@[act_brth_dt], 'YYYYMMDDHH24MI')+1" ).append("\n"); 
		query.append("AND    		VPS_ETD_DT 		BETWEEN TO_DATE(@[act_dep_dt], 'YYYYMMDDHH24MI')-1 AND TO_DATE(@[act_dep_dt], 'YYYYMMDDHH24MI')+1" ).append("\n"); 
		query.append("#elseif (${act_arr_dt} != '' && ${act_brth_dt} != '')" ).append("\n"); 
		query.append("AND    		VPS_ETA_DT 		BETWEEN TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI')-1 AND TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI')+1" ).append("\n"); 
		query.append("AND    		VPS_ETB_DT 		BETWEEN TO_DATE(@[act_brth_dt], 'YYYYMMDDHH24MI')-1 AND TO_DATE(@[act_brth_dt], 'YYYYMMDDHH24MI')+1" ).append("\n"); 
		query.append("#elseif (${act_dep_dt} != '')" ).append("\n"); 
		query.append("AND    		VPS_ETD_DT 		BETWEEN TO_DATE(@[act_dep_dt], 'YYYYMMDDHH24MI')-1 AND TO_DATE(@[act_dep_dt], 'YYYYMMDDHH24MI')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}