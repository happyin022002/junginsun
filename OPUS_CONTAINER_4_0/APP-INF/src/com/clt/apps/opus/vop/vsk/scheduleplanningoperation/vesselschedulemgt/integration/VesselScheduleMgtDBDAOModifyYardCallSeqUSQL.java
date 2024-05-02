/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyYardCallSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.01.07 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOModifyYardCallSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOModifyYardCallSeqUSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOModifyYardCallSeqUSQL").append("\n"); 
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
		query.append("UPDATE 	VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("SET  	CALL_YD_IND_SEQ =  (" ).append("\n"); 
		query.append("SELECT 	SEQ_YD" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("SELECT 	ROWID, CLPT_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY YD_CD ORDER BY CLPT_SEQ) AS SEQ_YD" ).append("\n"); 
		query.append("FROM 	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 	VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND  	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND  	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("WHERE T1.ROWID = S.ROWID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 	VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND  	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND  	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 

	}
}