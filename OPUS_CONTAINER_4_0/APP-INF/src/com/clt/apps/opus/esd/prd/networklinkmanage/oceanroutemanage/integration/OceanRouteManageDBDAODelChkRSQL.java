/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanRouteManageDBDAODelChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAODelChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DelChk
	  * </pre>
	  */
	public OceanRouteManageDBDAODelChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts3_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts1_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts1_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts2_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts2_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts3_lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAODelChkRSQL").append("\n"); 
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
		query.append("SELECT DECODE(UPD_IND_CD, 'D', 'Y', UPD_IND_CD) UPD_IND_CD" ).append("\n"); 
		query.append("  FROM PRD_OCN_ROUT" ).append("\n"); 
		query.append(" WHERE ORG_LOC_CD = RTRIM(@[s_pol])" ).append("\n"); 
		query.append("   AND DEST_LOC_CD = RTRIM(@[s_pod])" ).append("\n"); 
		query.append("   AND NVL(N1ST_POL_CD, 'X') = RTRIM(@[s_pol1])" ).append("\n"); 
		query.append("   AND NVL(N1ST_POD_CD, 'X') = RTRIM(@[s_pod1])" ).append("\n"); 
		query.append("   AND NVL(N1ST_LANE_CD, 'X') = RTRIM(@[s_lane])" ).append("\n"); 
		query.append("   AND NVL(N1ST_SKD_DIR_CD, 'X') = RTRIM(@[s_dir1])" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("   AND NVL(N2ND_POL_CD, 'X') = NVL(RTRIM(@[s_ts1_port]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N2ND_POD_CD, 'X') = NVL(RTRIM(@[s_pod2]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N2ND_LANE_CD, 'X') = NVL(RTRIM(@[s_ts1_lane]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N2ND_SKD_DIR_CD, 'X') = NVL(RTRIM(@[s_dir2]), 'X')" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("   AND NVL(N3RD_POL_CD, 'X') = NVL(RTRIM(@[s_ts2_port]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N3RD_POD_CD, 'X') = NVL(RTRIM(@[s_pod3]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N3RD_LANE_CD, 'X') = NVL(RTRIM(@[s_ts2_lane]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N3RD_SKD_DIR_CD, 'X') = NVL(RTRIM(@[s_dir3]), 'X')" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("   AND NVL(N4TH_POL_CD, 'X') = NVL(RTRIM(@[s_ts3_port]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N4TH_POD_CD, 'X') = NVL(RTRIM(@[s_pod4]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N4TH_LANE_CD, 'X') = NVL(RTRIM(@[s_ts3_lane]), 'X')" ).append("\n"); 
		query.append("   AND NVL(N4TH_SKD_DIR_CD, 'X') = NVL(RTRIM(@[s_dir4]), 'X')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}