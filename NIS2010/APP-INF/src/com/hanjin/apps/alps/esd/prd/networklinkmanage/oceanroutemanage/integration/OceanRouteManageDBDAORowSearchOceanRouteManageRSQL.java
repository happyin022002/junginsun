/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OceanRouteManageDBDAORowSearchOceanRouteManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAORowSearchOceanRouteManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RowSearchOceanRouteManage
	  * </pre>
	  */
	public OceanRouteManageDBDAORowSearchOceanRouteManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAORowSearchOceanRouteManageRSQL").append("\n"); 
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
		query.append("SELECT DECODE(UPD_IND_CD, 'O', 'Y', 'N') UPD_IND_CD				" ).append("\n"); 
		query.append("	FROM   PRD_OCN_ROUT												" ).append("\n"); 
		query.append("	WHERE  ORG_LOC_CD = RTRIM(@[org_loc_cd])											" ).append("\n"); 
		query.append("	AND    DEST_LOC_CD = RTRIM(@[dest_loc_cd])											" ).append("\n"); 
		query.append("	AND    NVL(N1ST_POL_CD, 'X')  = RTRIM(@[n1st_pol_cd])								" ).append("\n"); 
		query.append("	AND    NVL(N1ST_POD_CD, 'X')  = RTRIM(@[n1st_pod_cd])								" ).append("\n"); 
		query.append("	AND    NVL(N1ST_LANE_CD, 'X') = RTRIM(@[n1st_lane_cd])								" ).append("\n"); 
		query.append("	AND    NVL(N2ND_POL_CD, 'X')     = NVL(RTRIM(@[n2nd_pol_cd]), 'X')					" ).append("\n"); 
		query.append("	AND    NVL(N2ND_POD_CD, 'X')     = NVL(RTRIM(@[n2nd_pod_cd]), 'X')					" ).append("\n"); 
		query.append("	AND    NVL(N2ND_LANE_CD, 'X')    = NVL(RTRIM(@[n2nd_lane_cd]), 'X')					" ).append("\n"); 
		query.append("	AND    NVL(N3RD_POL_CD,'X')     = NVL(RTRIM(@[n3rd_pol_cd]), 'X')					" ).append("\n"); 
		query.append("	AND    NVL(N3RD_POD_CD,'X')     = NVL(RTRIM(@[n3rd_pod_cd]), 'X')					" ).append("\n"); 
		query.append("	AND    NVL(N3RD_LANE_CD,'X')    = NVL(RTRIM(@[n3rd_lane_cd]), 'X')					" ).append("\n"); 
		query.append("	AND    NVL(N4TH_POL_CD,'X')     = NVL(RTRIM(@[n4th_pol_cd]), 'X')					" ).append("\n"); 
		query.append("	AND    NVL(N4TH_POD_CD,'X')     = NVL(RTRIM(@[n4th_pod_cd]), 'X')					" ).append("\n"); 
		query.append("	AND    NVL(N4TH_LANE_CD,'X')    = NVL(RTRIM(@[n4th_lane_cd]), 'X')					" ).append("\n"); 
		query.append("--	AND    NVL(UPD_IND_CD, 'S')     = 'O'		" ).append("\n"); 
		query.append("    AND    NVL(UPD_IND_CD, 'S')     <> 'D'							" ).append("\n"); 
		query.append("	AND    ROWNUM = 1" ).append("\n"); 

	}
}