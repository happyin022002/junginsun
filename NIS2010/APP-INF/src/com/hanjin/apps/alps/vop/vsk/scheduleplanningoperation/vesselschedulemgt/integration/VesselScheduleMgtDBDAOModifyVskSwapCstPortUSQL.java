/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyVskSwapCstPortUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.08.05 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOModifyVskSwapCstPortUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_SWAP_CST_PORT 테이블의 자기 자신의 VVD의 다음 차수를 업데이트한다
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOModifyVskSwapCstPortUSQL(){
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
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOModifyVskSwapCstPortUSQL").append("\n"); 
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
		query.append("UPDATE  VSK_SWAP_CST_PORT SET" ).append("\n"); 
		query.append("TURN_PORT_FLG = 'N'," ).append("\n"); 
		query.append("TURN_PORT_IND_CD = 'N'," ).append("\n"); 
		query.append("TURN_SKD_VOY_NO  = NULL," ).append("\n"); 
		query.append("TURN_SKD_DIR_CD  = NULL," ).append("\n"); 
		query.append("TURN_CLPT_IND_SEQ = NULL" ).append("\n"); 
		query.append("WHERE   VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO      = @[turn_skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD      = @[turn_skd_dir_cd]" ).append("\n"); 
		query.append("AND     TURN_SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     TURN_SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 

	}
}