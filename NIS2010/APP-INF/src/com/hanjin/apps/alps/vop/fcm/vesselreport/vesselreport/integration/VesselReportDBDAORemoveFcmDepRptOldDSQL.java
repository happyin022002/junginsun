/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselReportDBDAORemoveFcmDepRptOldDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.07 
* 1.0 Creation
* 
* 2014.04.07 박다은 [CHM-201429498] [FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAORemoveFcmDepRptOldDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.04.07 박다은 [CHM-201429498] [FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
	  * </pre>
	  */
	public VesselReportDBDAORemoveFcmDepRptOldDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_voy_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAORemoveFcmDepRptOldDSQL").append("\n"); 
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
		query.append("DELETE FROM FCM_DEP_RPT" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    VSL_CD       = @[old_vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO   = SUBSTR(@[old_voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD   = SUBSTR(@[old_voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("AND    DEP_PORT_CD  = @[old_dep_port_cd]" ).append("\n"); 
		query.append("AND    CLPT_IND_SEQ = DECODE(@[old_clpt_ind_seq], 'F', '1', 'S', '2', 'T', '3')" ).append("\n"); 

	}
}