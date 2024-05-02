/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOCheckLanePortValidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.04.14 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOCheckLanePortValidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane, Bound 에 등록 가능한 Port인지 체크합니다.
	  * 
	  * 2013.05.20 진마리아 [CHM-201324741-01] Lane Office POL 화면 로직 보완 - validation 및 error handling
	  * 2015.04.14 Arie Im [CHM-201535311] "IMU"노선에 대한 T/S적용 예외 룰 삭제 요청
	  * </pre>
	  */
	public BasicDataDBDAOCheckLanePortValidRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCheckLanePortValidRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD    ," ).append("\n"); 
		query.append("       SUB_TRD_CD" ).append("\n"); 
		query.append("  FROM MDM_DTL_REV_LANE MDR" ).append("\n"); 
		query.append(" WHERE MDR.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("   AND MDR.FM_CONTI_CD     = SPC_CONTI_CONV_FNC('',@[rlane_cd],'',@[pol_cd])" ).append("\n"); 
		query.append("   AND MDR.VSL_SLAN_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("--   AND MDR.IOC_CD   =  DECODE([ioc_ts_cd],'T/S',DECODE(SUBSTR([rlane_cd],1,3),'IMU','O','I'),SUBSTR([ioc_ts_cd],0,1))" ).append("\n"); 
		query.append("   AND MDR.IOC_CD   =  DECODE(@[ioc_ts_cd],'T/S','I',SUBSTR(@[ioc_ts_cd],0,1))" ).append("\n"); 
		query.append("   AND MDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}