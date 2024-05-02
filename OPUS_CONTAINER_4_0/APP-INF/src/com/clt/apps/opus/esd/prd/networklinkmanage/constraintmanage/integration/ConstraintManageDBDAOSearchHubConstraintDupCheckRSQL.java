/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchHubConstraintDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOSearchHubConstraintDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConstraintManageDBDAOSearchHubConstraintDupCheck
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchHubConstraintDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnst_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchHubConstraintDupCheckRSQL").append("\n"); 
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
		query.append("SELECT COUNT(PORT_CD) CNT" ).append("\n"); 
		query.append("  FROM PRD_HUB_LOC_CNST_MGMT" ).append("\n"); 
		query.append(" WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append(" AND HUB_LOC_CD = @[hub_loc_cd]" ).append("\n"); 
		query.append(" AND NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append(" AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append(" AND SPCL_CGO_CNTR_TP_CD = @[spcl_cgo_cntr_tp_cd]" ).append("\n"); 
		query.append(" AND CNST_LANE_CD = @[cnst_lane_cd]" ).append("\n"); 
		query.append(" AND DIR_CD = @[dir_cd]" ).append("\n"); 

	}
}