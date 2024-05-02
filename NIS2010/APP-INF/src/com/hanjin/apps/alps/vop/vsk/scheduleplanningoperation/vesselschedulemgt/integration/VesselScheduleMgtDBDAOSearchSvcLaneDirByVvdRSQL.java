/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchSvcLaneDirByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.04.23 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchSvcLaneDirByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchSvcLaneDirByVvdRSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchSvcLaneDirByVvdRSQL").append("\n"); 
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
		query.append("SELECT  VSL_SLAN_DIR_CD, NUM VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT  ROWNUM  NUM, VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("                        SELECT  VSL_SLAN_DIR_CD, VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                        FROM    MDM_VSL_SVC_LANE_DIR" ).append("\n"); 
		query.append("                        WHERE   1            = 1 " ).append("\n"); 
		query.append("                        AND     VSL_SLAN_CD  = (" ).append("\n"); 
		query.append("                                                SELECT  VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                FROM    VSK_VSL_SKD" ).append("\n"); 
		query.append("                                                WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                AND     SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                        AND     DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                        ORDER BY VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("ORDER BY NUM" ).append("\n"); 

	}
}