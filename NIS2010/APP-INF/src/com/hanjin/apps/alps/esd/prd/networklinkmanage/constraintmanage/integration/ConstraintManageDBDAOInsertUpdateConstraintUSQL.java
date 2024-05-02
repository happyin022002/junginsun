/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ConstraintManageDBDAOInsertUpdateConstraintUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOInsertUpdateConstraintUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertUpdateConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOInsertUpdateConstraintUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cnst_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOInsertUpdateConstraintUSQL").append("\n"); 
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
		query.append("UPDATE PRD_ROUT_CNST " ).append("\n"); 
		query.append("SET DELT_FLG = 'N'" ).append("\n"); 
		query.append("	 , SVC_USE_FLG = @[svc_use_flg]" ).append("\n"); 
		query.append("	 , ROUT_CNST_RMK = @[rout_cnst_rmk]" ).append("\n"); 
		query.append("	 , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	 , UPD_OFC_CD = @[upd_ofc_cd] " ).append("\n"); 
		query.append("     , VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("     , SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("     , SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("     , CNTR_TP_CD = @[cntr_tp_cd]" ).append("\n"); 
		query.append("     , CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("WHERE TRNK_LANE_CD = @[trnk_lane_cd] " ).append("\n"); 
		query.append("	AND POL_NOD_CD = @[pol_cd] || @[pol_nod_cd] " ).append("\n"); 
		query.append("	AND POD_NOD_CD = @[pod_cd] || @[pod_nod_cd] " ).append("\n"); 
		query.append("	AND NVL(DEL_NOD_CD, ' ') = NVL(@[del_cd]||@[del_nod_cd] , ' ') " ).append("\n"); 
		query.append("	AND NVL(N1ST_LANE_CD, ' ') = NVL(@[n1st_lane_cd] , ' ') " ).append("\n"); 
		query.append("	AND NVL(N1ST_TS_PORT_CD, ' ') = NVL(@[n1st_ts_port_cd] , ' ') " ).append("\n"); 
		query.append("	AND NVL(N2ND_LANE_CD, ' ') = NVL(@[n2nd_lane_cd] , ' ') " ).append("\n"); 
		query.append("	AND NVL(N2ND_TS_PORT_CD, ' ') = NVL(@[n2nd_ts_port_cd] , ' ') " ).append("\n"); 
		query.append("	AND NVL(N3RD_LANE_CD, ' ') = NVL(@[n3rd_lane_cd] , ' ')" ).append("\n"); 
		query.append("	AND NVL(DIR_CD, 'X') = NVL(@[dir_cd], 'X')" ).append("\n"); 
		query.append("    AND NVL(VSL_CD, ' ')     = NVL(SUBSTR(@[vvd],1,4), ' ')" ).append("\n"); 
		query.append("    AND NVL(SKD_VOY_NO, ' ') = NVL(SUBSTR(@[vvd],5,4), ' ')" ).append("\n"); 
		query.append("    AND NVL(SKD_DIR_CD, ' ') = NVL(SUBSTR(@[vvd],9,1), ' ')" ).append("\n"); 
		query.append("    AND NVL(CNTR_TP_CD, ' ') = NVL(@[cntr_tp_cd], ' ')" ).append("\n"); 
		query.append("    AND NVL(CMDT_CD, ' ') = NVL(@[cmdt_cd], ' ')" ).append("\n"); 

	}
}