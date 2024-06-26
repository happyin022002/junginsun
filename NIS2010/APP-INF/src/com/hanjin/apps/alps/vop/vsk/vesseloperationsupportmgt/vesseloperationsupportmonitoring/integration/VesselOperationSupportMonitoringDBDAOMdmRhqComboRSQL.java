/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselOperationSupportMonitoringDBDAOMdmRhqComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselOperationSupportMonitoringDBDAOMdmRhqComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public VesselOperationSupportMonitoringDBDAOMdmRhqComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.integration").append("\n"); 
		query.append("FileName : VesselOperationSupportMonitoringDBDAOMdmRhqComboRSQL").append("\n"); 
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
		query.append("SELECT loc_nm as name," ).append("\n"); 
		query.append("  case when DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E' and NVL(DELT_FLG, 'N') = 'N' and CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("   then 'HAMRU'" ).append("\n"); 
		query.append("   else" ).append("\n"); 
		query.append("    case when CONTI_CD  = 'M' and NVL(DELT_FLG, 'N') = 'N' and CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("    then 'PHXRA'" ).append("\n"); 
		query.append("    else" ).append("\n"); 
		query.append("     case when CONTI_CD  = 'A' and NVL(DELT_FLG, 'N') = 'N' and CALL_PORT_FLG = 'Y' and SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("     then 'SHARC'" ).append("\n"); 
		query.append("     else" ).append("\n"); 
		query.append("      case when CONTI_CD  = 'A' and NVL(DELT_FLG, 'N') = 'N' and CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("      then 'SINRS'" ).append("\n"); 
		query.append("      else null" ).append("\n"); 
		query.append("      end" ).append("\n"); 
		query.append("     end" ).append("\n"); 
		query.append("    end" ).append("\n"); 
		query.append("   end as val" ).append("\n"); 
		query.append("FROM mdm_location" ).append("\n"); 
		query.append("WHERE loc_cd = @[loc_cd]" ).append("\n"); 

	}
}