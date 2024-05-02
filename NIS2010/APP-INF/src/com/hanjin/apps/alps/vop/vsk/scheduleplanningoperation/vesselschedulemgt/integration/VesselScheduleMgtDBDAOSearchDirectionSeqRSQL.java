/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchDirectionSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.25 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author RYU HYUK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchDirectionSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchDirectionSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchDirectionSeqRSQL").append("\n"); 
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
		query.append("SELECT  RNUM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  ROWNUM AS RNUM, VSL_SLAN_DIR_CD, VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  VSL_SLAN_DIR_CD, VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                FROM    MDM_VSL_SVC_LANE T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     T1.VSL_SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND     T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("                AND     T1.VSL_TP_CD   = 'C'" ).append("\n"); 
		query.append("#if (${delt_flg} == 'N') " ).append("\n"); 
		query.append("                AND     T1.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("#elseif (${delt_flg} == 'Y') " ).append("\n"); 
		query.append("                AND     T1.DELT_FLG    = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ORDER BY VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     VSL_SLAN_DIR_CD = @[vsl_slan_dir_cd]" ).append("\n"); 

	}
}