/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyVskVslPortSkdByClptSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOModifyVskVslPortSkdByClptSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOModifyVskVslPortSkdByClptSeqUSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOModifyVskVslPortSkdByClptSeqUSQL").append("\n"); 
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
		query.append("UPDATE  VSK_VSL_PORT_SKD 	XX" ).append("\n"); 
		query.append("SET 	XX.CLPT_SEQ 			= 	(" ).append("\n"); 
		query.append("                				SELECT 	T2.RNUM" ).append("\n"); 
		query.append("                				FROM 	(" ).append("\n"); 
		query.append("                        				SELECT 		T1.RID" ).append("\n"); 
		query.append("												, 	ROWNUM 		AS RNUM" ).append("\n"); 
		query.append("                        				FROM 		(" ).append("\n"); 
		query.append("                                					SELECT 		ROWID 				AS RID " ).append("\n"); 
		query.append("													FROM 		VSK_VSL_PORT_SKD	PS" ).append("\n"); 
		query.append("                                					WHERE 		PS.VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("                                					AND 		PS.SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("                                					AND 		PS.SKD_DIR_CD 		= @[skd_dir_cd]" ).append("\n"); 
		query.append("													--AND			PS.VT_ADD_CALL_FLG	IS NULL" ).append("\n"); 
		query.append("                                					ORDER BY 	PS.CLPT_SEQ" ).append("\n"); 
		query.append("                             						) T1" ).append("\n"); 
		query.append("                     					) T2" ).append("\n"); 
		query.append("                 				WHERE 	T2.RID 		= XX.ROWID" ).append("\n"); 
		query.append("                				)" ).append("\n"); 
		query.append("WHERE 	XX.VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("AND 	XX.SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND 	XX.SKD_DIR_CD 		= @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		XX.VT_ADD_CALL_FLG	IS NULL" ).append("\n"); 

	}
}