/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchBayPlanInputPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.12.09 정진우
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

public class VesselScheduleMgtDBDAOSearchBayPlanInputPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNSHA Port 및 이전 Boud에 기항지 정보를 찾고 Bay Plan이 입력되는 Port를 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchBayPlanInputPortRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchBayPlanInputPortRSQL").append("\n"); 
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
		query.append("SELECT	VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD T" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		(VSL_CD, SKD_VOY_NO, SKD_DIR_CD) =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	VSL_CD, TURN_SKD_VOY_NO, TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		VSL_CD			= @[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD		= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND		TURN_PORT_FLG	= 'Y'" ).append("\n"); 
		query.append("AND		ROWNUM			= 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND		TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	/*+ INDEX(T XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD T" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND		CLPT_SEQ 	< (" ).append("\n"); 
		query.append("SELECT	CLPT_SEQ" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD	S" ).append("\n"); 
		query.append("WHERE	S.VSL_CD		= T.VSL_CD" ).append("\n"); 
		query.append("AND		S.SKD_VOY_NO 	= T.SKD_VOY_NO" ).append("\n"); 
		query.append("AND		S.SKD_DIR_CD	= T.SKD_DIR_CD" ).append("\n"); 
		query.append("AND		S.VPS_PORT_CD	= @[vps_port_cd]" ).append("\n"); 
		query.append("AND		S.CLPT_IND_SEQ	= @[clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		EXISTS	(" ).append("\n"); 
		query.append("SELECT	'X'" ).append("\n"); 
		query.append("FROM	BAY_PLAN S" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		T1.VSL_CD		= S.VSL_CD" ).append("\n"); 
		query.append("AND		T1.SKD_VOY_NO 	= S.VOY_NO" ).append("\n"); 
		query.append("AND		T1.SKD_DIR_CD	= S.DIR_CD" ).append("\n"); 
		query.append("AND		T1.VPS_PORT_CD	= S.PORT_CD" ).append("\n"); 
		query.append("AND		T1.CLPT_IND_SEQ	= S.CALL_IND" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}