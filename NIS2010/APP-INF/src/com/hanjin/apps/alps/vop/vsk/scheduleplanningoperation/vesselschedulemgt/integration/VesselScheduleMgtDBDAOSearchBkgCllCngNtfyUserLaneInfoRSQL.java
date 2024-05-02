/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchBkgCllCngNtfyUserLaneInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchBkgCllCngNtfyUserLaneInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CLL_CNG_NTFY_SET 테이블에서 LANE에 대한 User Information 추출
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchBkgCllCngNtfyUserLaneInfoRSQL(){
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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchBkgCllCngNtfyUserLaneInfoRSQL").append("\n"); 
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
		query.append("SELECT    X.SLAN_CD" ).append("\n"); 
		query.append("       ,  X.DIR_CD  " ).append("\n"); 
		query.append("       ,  X.OFC_CD    " ).append("\n"); 
		query.append("       ,  X.RCVR_USR_ID" ).append("\n"); 
		query.append("       ,  (SELECT C.USR_NM FROM COM_USER C WHERE C.USR_ID = X.RCVR_USR_ID)	AS USR_NM" ).append("\n"); 
		query.append("       ,  X.RCVR_EML" ).append("\n"); 
		query.append("       ,  X.OFC_PHN_NO" ).append("\n"); 
		query.append("       ,  X.OFC_FAX_NO" ).append("\n"); 
		query.append("FROM      BKG_CLL_CNG_NTFY_SET   X" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND	      X.OFC_CD			     IN ('PUSBO','KANKS','INCKS')" ).append("\n"); 
		query.append("AND	      X.PORT_CD              = @[vps_port_cd]" ).append("\n"); 
		query.append("AND       X.SLAN_CD              = @[slan_cd]  " ).append("\n"); 
		query.append("AND       X.DIR_CD               = @[skd_dir_cd]" ).append("\n"); 

	}
}