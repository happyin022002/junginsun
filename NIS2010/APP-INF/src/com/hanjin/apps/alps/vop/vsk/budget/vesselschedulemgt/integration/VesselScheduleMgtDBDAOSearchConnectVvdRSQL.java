/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchConnectVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchConnectVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 자신에 VVD와 연결되는 Pre-VVD와 Next-VVD 정보를 찾아 온다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchConnectVvdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchConnectVvdRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD,SKD_VOY_NO,SKD_DIR_CD,TURN_PORT_IND_CD,TURN_SKD_VOY_NO,TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM VSK_BUD_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'Y')" ).append("\n"); 
		query.append("AND    NVL(TURN_SKD_VOY_NO, ' ') != ' '" ).append("\n"); 
		query.append("AND    NVL(TURN_SKD_DIR_CD, ' ') != ' '" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT VSL_CD,SKD_VOY_NO,SKD_DIR_CD,TURN_PORT_IND_CD,TURN_SKD_VOY_NO,TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM VSK_BUD_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    NVL(TURN_PORT_IND_CD, ' ') in ('D', 'V', 'F')" ).append("\n"); 
		query.append("AND    NVL(TURN_SKD_VOY_NO, ' ') != ' '" ).append("\n"); 
		query.append("AND    NVL(TURN_SKD_DIR_CD, ' ') != ' '" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY TURN_SKD_VOY_NO" ).append("\n"); 

	}
}