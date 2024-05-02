/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckFirstCallingPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.01.13 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCheckFirstCallingPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckFirstCallingPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : VesselScheduleMgtDBDAOCheckFirstCallingPortRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[vsl_cd]||@[skd_voy_no]||@[skd_dir_cd]||@[vps_port_cd]||@[clpt_ind_seq], (" ).append("\n"); 
		query.append("                                                SELECT /*+INDEX_ASC(T XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                                                    VSL_CD||SKD_VOY_NO ||SKD_DIR_CD||VPS_PORT_CD|| CLPT_IND_SEQ " ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD T" ).append("\n"); 
		query.append("                                                WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                AND (SKD_CNG_STS_CD IS NULL OR SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1" ).append("\n"); 
		query.append("), 'Y', 'N') AS FLAG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}