/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageDBDAOSearchVesselSchedulePortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.12.30 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioManageDBDAOSearchVesselSchedulePortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_vsl_skd 테이블의 데이터 조회(port 정보 포함)
	  * </pre>
	  */
	public ScenarioManageDBDAOSearchVesselSchedulePortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : ScenarioManageDBDAOSearchVesselSchedulePortInfoRSQL").append("\n"); 
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
		query.append("RANK() OVER (ORDER BY A.VSL_CALL_SEQ ASC ) AS SEQ" ).append("\n"); 
		query.append(", A.VSL_LOC_CD" ).append("\n"); 
		query.append("--CSRNO : N200811110008 변경 vsl_eta_dt를 앞으로 당겨서 화면에 보여줌 ,scnr_id를 가져옴" ).append("\n"); 
		query.append(", TO_CHAR(A.VSL_ETA_DT,'YYYY-MM-DD HH24:MI:SS') VSL_ETA_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.VSL_ETB_DT,'YYYY-MM-DD HH24:MI:SS') VSL_ETB_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.VSL_ETD_DT,'YYYY-MM-DD HH24:MI:SS') VSL_ETD_DT" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", VSL_CALL_IND_CD" ).append("\n"); 
		query.append(", VSL_CALL_SEQ" ).append("\n"); 
		query.append(", VSL_TURN_PORT_INFO_CD" ).append("\n"); 
		query.append(", VSL_TURN_VOY_NO" ).append("\n"); 
		query.append(", VSL_TURN_DIR_CD" ).append("\n"); 
		query.append(", VSL_TURN_CALL_IND_CD" ).append("\n"); 
		query.append(", VSL_SLAN_CD" ).append("\n"); 
		query.append(", VSL_USD_CD" ).append("\n"); 
		query.append(", SCNR_ID" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_VSL_SKD A" ).append("\n"); 
		query.append("--  *  CSRNO : R200810109878 로 변경" ).append("\n"); 
		query.append("--	   WHERE a.vsl_call_ind_cd = '1'" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 

	}
}