/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOCheckLaneDirectionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOCheckLaneDirectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkLaneDirection Lane의 Direction을 체크한다 
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOCheckLaneDirectionRSQL(){
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
		params.put("vsl_slan_dir_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOCheckLaneDirectionRSQL").append("\n"); 
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
		query.append("SELECT  NVL((" ).append("\n"); 
		query.append("            SELECT  'Y'" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("                        SELECT  ROWNUM AS NUM, T1.DIR_CD, T1.DIR_SEQ, T1.FLAG" ).append("\n"); 
		query.append("                        FROM    (" ).append("\n"); 
		query.append("                                    SELECT  T1.VSL_SLAN_DIR_CD AS DIR_CD, VSL_SLAN_DIR_SEQ AS DIR_SEQ, T1.DELT_FLG AS FLAG" ).append("\n"); 
		query.append("                                    FROM    MDM_VSL_SVC_LANE_DIR T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("                                    WHERE   T1.VSL_SLAN_CD  = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                    AND     T1.VSL_SLAN_CD  = @[vsl_slan_cd]" ).append("\n"); 
		query.append("                                    AND     T1.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                                    AND     T2.VSL_TP_CD    = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("                                    ORDER BY VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                                ) T1" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            WHERE   1       = 1" ).append("\n"); 
		query.append("            AND     DIR_CD  = @[vsl_slan_dir_cd]" ).append("\n"); 
		query.append("            AND     DIR_SEQ LIKE @[vsl_slan_dir_seq]||'%'" ).append("\n"); 
		query.append("        ), 'N') ||" ).append("\n"); 
		query.append("        NVL((" ).append("\n"); 
		query.append("                SELECT  'Y'" ).append("\n"); 
		query.append("                FROM    MDM_VSL_SVC_LANE_DIR" ).append("\n"); 
		query.append("                WHERE   VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("                AND     VSL_SLAN_DIR_CD = @[vsl_slan_dir_cd]             " ).append("\n"); 
		query.append("        ), 'N') ||" ).append("\n"); 
		query.append("         NVL((" ).append("\n"); 
		query.append("                SELECT  'N'" ).append("\n"); 
		query.append("                FROM    MDM_VSL_SVC_LANE_DIR" ).append("\n"); 
		query.append("                WHERE   VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("                AND     VSL_SLAN_DIR_CD = @[vsl_slan_dir_cd]" ).append("\n"); 
		query.append("                AND     DELT_FLG        = 'Y'                " ).append("\n"); 
		query.append("        ), 'Y')  AS FLAG" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}