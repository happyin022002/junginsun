/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.17 
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

public class ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 포트에 입력될 ATA(Actual Time of Arrival)에 대해
	  * 그 이전 포트의 ATD(Actual Time of Departure)와 비교하여
	  * ATA가 이후 시간인지 체크한다.
	  * ---------------------------------------------------------------------------
	  * Ticket ID : CHM-201112897-01
	  * 개발자 : 진마리아
	  * Title : [VOP-VSK] Terminal EDI 변경 요청건
	  * Desc. :
	  * 1. Actual SKD 수신 시 수행하는 이전 포트와의 SKD 연속성 검증 로직에서 이전 포트가 Skip 인 경우는 그 이전 포트와 검증하도록 변경
	  * 2. Voyage No, Direction Code가 ALPS VVD와 일치하지 않아 Actual SKD 을 이용하여 VVD를 찾는 경우, Call Sign No., IMU No. 를 이용하여 Vessel Code를 찾도록 로직 변경
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL").append("\n"); 
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
		query.append("SELECT 		CASE 	WHEN TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI') - PRE_ETD_DT > 0 THEN 'Y'" ).append("\n"); 
		query.append("         			ELSE 'N'" ).append("\n"); 
		query.append("       		END 	AS CHK_FLG" ).append("\n"); 
		query.append("FROM   		(" ).append("\n"); 
		query.append("			SELECT 		NVL((	SELECT 	S1.VPS_ETD_DT" ).append("\n"); 
		query.append("                        		FROM   	VSK_VSL_PORT_SKD 	S1" ).append("\n"); 
		query.append("                        		WHERE  	VSL_CD 				= T1.VSL_CD" ).append("\n"); 
		query.append("                        		AND    	SKD_VOY_NO 			= CASE	WHEN T1.SEQ = '1' THEN T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                              						ELSE T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                              				  END" ).append("\n"); 
		query.append("                        		AND    	SKD_DIR_CD 			= CASE	WHEN T1.SEQ = '1' THEN T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                              						ELSE T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                              				  END" ).append("\n"); 
		query.append("                        		AND    	CLPT_SEQ 			= CASE	WHEN T1.SEQ = '1' THEN (SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                    						FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                    						WHERE  VSL_CD					= T1.VSL_CD" ).append("\n"); 
		query.append("                                                                    						AND    SKD_VOY_NO 				= T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                    						AND    SKD_DIR_CD 				= T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                    						AND    TURN_PORT_IND_CD 		NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                                                                    						AND    NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("																							)" ).append("\n"); 
		query.append("                                            						ELSE T1.PRE_CLPT_SEQ" ).append("\n"); 
		query.append("                                            				  END )" ).append("\n"); 
		query.append("							, TO_DATE('19000101', 'YYYYMMDD')" ).append("\n"); 
		query.append("						) 	  AS PRE_ETD_DT" ).append("\n"); 
		query.append("        	FROM   		(	  SELECT 	ROW_NUMBER()	OVER(PARTITION BY VSL_CD ORDER BY CLPT_SEQ) SEQ" ).append("\n"); 
		query.append("									,	LAG(CLPT_SEQ) 	OVER(PARTITION BY VSL_CD ORDER BY CLPT_SEQ) PRE_CLPT_SEQ" ).append("\n"); 
		query.append("                       				, 	T1.*" ).append("\n"); 
		query.append("                			  FROM   	VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("                			  WHERE  	VSL_CD 				  	 = @[vsl_cd]" ).append("\n"); 
		query.append("                			  AND    	SKD_VOY_NO 			  	 = @[skd_voy_no]" ).append("\n"); 
		query.append("                			  AND    	SKD_DIR_CD 			  	 = @[skd_dir_cd]" ).append("\n"); 
		query.append("                			  AND    	NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("						) T1" ).append("\n"); 
		query.append("			WHERE  		VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("			AND    		SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("			AND    		SKD_DIR_CD 		= @[skd_dir_cd]" ).append("\n"); 
		query.append("			AND    		VPS_PORT_CD 	= @[vps_port_cd]" ).append("\n"); 
		query.append("			AND    		CLPT_IND_SEQ 	= @[clpt_ind_seq] " ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}