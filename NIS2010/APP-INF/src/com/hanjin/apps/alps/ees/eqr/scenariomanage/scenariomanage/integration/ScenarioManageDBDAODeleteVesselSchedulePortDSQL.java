/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageDBDAODeleteVesselSchedulePortDSQL.java
*@FileTitle : Vessel SKD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.05 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioManageDBDAODeleteVesselSchedulePortDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_VSL_SKD  테이블의 특정 vvd 삭제
	  * </pre>
	  */
	public ScenarioManageDBDAODeleteVesselSchedulePortDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration ").append("\n"); 
		query.append("FileName : ScenarioManageDBDAODeleteVesselSchedulePortDSQL").append("\n"); 
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
		query.append("DELETE FROM" ).append("\n"); 
		query.append("EQR_SCNR_VSL_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID       		= @[scnr_id]   --SCEN200842W001" ).append("\n"); 
		query.append("AND VSL_CD        	= @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO    	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD    	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND VSL_SLAN_CD   	= @[vsl_slan_cd]" ).append("\n"); 

	}
}