/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConstraintManageDBDAOAddRouteConstraintHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.01
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.01 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOAddRouteConstraintHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route History 정보를 생성한다.
	  * </pre>
	  */
	public ConstraintManageDBDAOAddRouteConstraintHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cnst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOAddRouteConstraintHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_ROUT_CNST_HIS" ).append("\n"); 
		query.append("     ( TRNK_LANE_CD" ).append("\n"); 
		query.append("     , POL_NOD_CD" ).append("\n"); 
		query.append("     , POD_NOD_CD" ).append("\n"); 
		query.append("     , ROUT_CNST_SEQ" ).append("\n"); 
		query.append("     , HIS_CRE_DT" ).append("\n"); 
		query.append("     , DEL_NOD_CD" ).append("\n"); 
		query.append("     , N1ST_LANE_CD" ).append("\n"); 
		query.append("     , N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("     , N2ND_LANE_CD" ).append("\n"); 
		query.append("     , N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("     , N3RD_LANE_CD" ).append("\n"); 
		query.append("     , SVC_USE_FLG" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , ROUT_CNST_RMK" ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append("     , UPD_OFC_CD" ).append("\n"); 
		query.append("     , DIR_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , CNTR_TP_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT TRNK_LANE_CD" ).append("\n"); 
		query.append("     , POL_NOD_CD" ).append("\n"); 
		query.append("     , POD_NOD_CD" ).append("\n"); 
		query.append("     , ROUT_CNST_SEQ" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , DEL_NOD_CD" ).append("\n"); 
		query.append("     , N1ST_LANE_CD" ).append("\n"); 
		query.append("     , N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("     , N2ND_LANE_CD" ).append("\n"); 
		query.append("     , N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("     , N3RD_LANE_CD" ).append("\n"); 
		query.append("     , SVC_USE_FLG" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , ROUT_CNST_RMK" ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append("     , UPD_OFC_CD" ).append("\n"); 
		query.append("     , DIR_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , CNTR_TP_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("  FROM PRD_ROUT_CNST" ).append("\n"); 
		query.append(" WHERE TRNK_LANE_CD = @[trnk_lane_cd] " ).append("\n"); 
		query.append("   AND POL_NOD_CD = @[pol_cd] || @[pol_nod_cd]" ).append("\n"); 
		query.append("   AND POD_NOD_CD = @[pod_cd] || @[pod_nod_cd] " ).append("\n"); 
		query.append("   AND ROUT_CNST_SEQ = TO_NUMBER(@[rout_cnst_seq])" ).append("\n"); 

	}
}