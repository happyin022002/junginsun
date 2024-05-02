/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchVesselScheduleCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.12.30 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchVesselScheduleCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel schedule 정보 조회
	  * </pre>
	  */
	public CommonDBDAOSearchVesselScheduleCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchVesselScheduleCheckRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(VSL_CD) VSL_CD" ).append("\n"); 
		query.append(", MAX(SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append(", MAX(SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append(", MAX(VPS_PORT_CD) VPS_PORT_CD  -- VSL_LOC_CD" ).append("\n"); 
		query.append(", MAX(CLPT_IND_SEQ) CLPT_IND_SEQ -- VSL_CALL_IND_CD" ).append("\n"); 
		query.append(", MAX(CLPT_SEQ) CLPT_SEQ     -- VSL_CALL_SEQ" ).append("\n"); 
		query.append(", MAX(TO_CHAR(VPS_ETA_DT ,'YYYY-MM-DD HH24:MI:SS')) VPS_ETA_DT   -- VSL_ETA_DT" ).append("\n"); 
		query.append(", MAX(TO_CHAR(VPS_ETB_DT ,'YYYY-MM-DD HH24:MI:SS')) VPS_ETB_DT   -- VSL_ETB_DT" ).append("\n"); 
		query.append(", MAX(TO_CHAR(VPS_ETD_DT ,'YYYY-MM-DD HH24:MI:SS')) VPS_ETD_DT   -- VSL_ETD_DT" ).append("\n"); 
		query.append(", MAX(TURN_PORT_IND_CD) TURN_PORT_IND_CD -- VSL_TURN_PORT_INFO_CD" ).append("\n"); 
		query.append(", MAX(TURN_SKD_VOY_NO) TURN_SKD_VOY_NO  -- VSL_TURN_VOY_NO" ).append("\n"); 
		query.append(", MAX(TURN_SKD_DIR_CD) TURN_SKD_DIR_CD  -- VSL_TURN_DIR_CD" ).append("\n"); 
		query.append(", MAX(TURN_CLPT_IND_SEQ) TURN_CLPT_IND_SEQ -- VSL_TURN_CALL_IND_CD" ).append("\n"); 
		query.append(", MAX(SLAN_CD) SLAN_CD          -- VSL_SLAN_CD" ).append("\n"); 
		query.append(", MAX(YD_CD) YD_CD" ).append("\n"); 
		query.append("--max(SKD_OWNR_CD) SKD_OWNR_CD      -- VSL_USD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VSL_CD     = @[vsl_cd]    -- VSL_CD 입력값   EX) EME7" ).append("\n"); 
		query.append("AND   SKD_VOY_NO = @[skd_voy_no]    -- SKD VOY 입력값  EX) 0718" ).append("\n"); 
		query.append("AND   SKD_DIR_CD = @[skd_dir_cd]       -- SKD DIR 입력값  EX) N" ).append("\n"); 
		query.append("AND   VPS_PORT_CD = @[vsl_port_cd] -- port" ).append("\n"); 
		query.append("AND   SLAN_CD = @[slan_cd] -- lane" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_DATE(WK_ST_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK = @[fm_wk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_DATE(WK_END_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK = @[to_wk]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}