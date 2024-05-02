/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpaceAllocationManageDBDAORemoveMultiSpaceAllocation0033LanePortRgstListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAORemoveMultiSpaceAllocation0033LanePortRgstListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveMultiSpaceAllocation0033LanePortRgstList
	  * </pre>
	  */
	public SpaceAllocationManageDBDAORemoveMultiSpaceAllocation0033LanePortRgstListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration ").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAORemoveMultiSpaceAllocation0033LanePortRgstListDSQL").append("\n"); 
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
		query.append("DELETE SPC_LANE_PORT_RGST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND REP_TRD_CD = @[rep_trd_cd]" ).append("\n"); 
		query.append("AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND EFF_FM_DT = REPLACE(@[eff_fm_dt], '-', '')" ).append("\n"); 
		query.append("AND BSA_CAPA = @[bsa_capa]" ).append("\n"); 
		query.append("AND POL_CD = @[pol_cd]" ).append("\n"); 

	}
}