/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageDBDAOModifyVesselSchedulePortInfoAddCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.12.29 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioManageDBDAOModifyVesselSchedulePortInfoAddCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScenarioManage의 모든 목록을 화면의 내용을 그대로 저장
	  * </pre>
	  */
	public ScenarioManageDBDAOModifyVesselSchedulePortInfoAddCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etbEYrWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etbSYrWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration").append("\n"); 
		query.append("FileName : ScenarioManageDBDAOModifyVesselSchedulePortInfoAddCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_SCNR_VSL_SKD (" ).append("\n"); 
		query.append("SCNR_ID" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", VSL_LOC_CD" ).append("\n"); 
		query.append(", VSL_CALL_IND_CD" ).append("\n"); 
		query.append(", VSL_CALL_SEQ" ).append("\n"); 
		query.append(", CNG_STS_CD" ).append("\n"); 
		query.append(", VSL_ETA_DT" ).append("\n"); 
		query.append(", VSL_ETB_DT" ).append("\n"); 
		query.append(", VSL_ETD_DT" ).append("\n"); 
		query.append(", VSL_TURN_PORT_INFO_CD" ).append("\n"); 
		query.append(", VSL_TURN_VOY_NO" ).append("\n"); 
		query.append(", VSL_TURN_DIR_CD" ).append("\n"); 
		query.append(", VSL_TURN_CALL_IND_CD" ).append("\n"); 
		query.append(", VSL_SLAN_CD" ).append("\n"); 
		query.append(", VSL_USD_CD" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[scnr_id]" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.VPS_PORT_CD" ).append("\n"); 
		query.append(", A.CLPT_IND_SEQ" ).append("\n"); 
		query.append(", A.CLPT_SEQ" ).append("\n"); 
		query.append(", A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append(", A.VPS_ETA_DT" ).append("\n"); 
		query.append(", DECODE (A.VPS_ETB_DT,NULL , DECODE(A.VPS_ETA_DT , NULL ,A.VPS_ETD_DT , A.VPS_ETA_DT) , A.VPS_ETB_DT) VPS_ETB_DT" ).append("\n"); 
		query.append(", A.VPS_ETD_DT" ).append("\n"); 
		query.append(", A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(", A.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(", A.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(", A.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", A.SLAN_CD" ).append("\n"); 
		query.append(", B.SKD_USD_IND_CD" ).append("\n"); 
		query.append(", A.YD_CD		   -- 09.12.29 YD정보 추가 by ChangHoChae" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", 'SYSTEM'" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", 'SYSTEM'" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("VSK_VSL_SKD B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND		A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.VSL_CD    = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND A.SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND NVL(SKD_CNG_STS_CD,'N') not in ('S')" ).append("\n"); 
		query.append("AND A.VPS_ETD_DT BETWEEN (SELECT TO_DATE(WK_ST_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = @[etbSYrWk] )" ).append("\n"); 
		query.append("AND (SELECT TO_DATE(WK_END_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = @[etbEYrWk] )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}