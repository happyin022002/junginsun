/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintManageDBDAOInsertRouteConstraintCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.04 
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

public class ConstraintManageDBDAOInsertRouteConstraintCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertRouteConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOInsertRouteConstraintCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_por",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_del_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ts1_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_del",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_por_node",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ts2_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod_node",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOInsertRouteConstraintCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_ROUT_CNST (" ).append("\n"); 
		query.append("     TRNK_LANE_CD" ).append("\n"); 
		query.append("	,POL_NOD_CD" ).append("\n"); 
		query.append("	,POD_NOD_CD" ).append("\n"); 
		query.append("	,ROUT_CNST_SEQ" ).append("\n"); 
		query.append("	,DEL_NOD_CD" ).append("\n"); 
		query.append("	,POR_NOD_CD" ).append("\n"); 
		query.append("	,N1ST_LANE_CD" ).append("\n"); 
		query.append("	,N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("	,N2ND_LANE_CD" ).append("\n"); 
		query.append("	,N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("	,N3RD_LANE_CD" ).append("\n"); 
		query.append("	,SVC_USE_FLG" ).append("\n"); 
		query.append("	,ROUT_CNST_RMK" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,CRE_OFC_CD" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,DIR_CD" ).append("\n"); 
		query.append("	,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("	,CNTR_TP_CD" ).append("\n"); 
		query.append("	,CNTR_SZ_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	 @[s_trunk_lane]" ).append("\n"); 
		query.append("	,@[s_pol_node]" ).append("\n"); 
		query.append("	,@[s_pod] || @[s_pod_node]" ).append("\n"); 
		query.append("	,(SELECT NVL(MAX(ROUT_CNST_SEQ), 0) + 1 FROM PRD_ROUT_CNST	WHERE TRNK_LANE_CD = @[s_trunk_lane] AND POL_NOD_CD = @[s_pol_node]	AND POD_NOD_CD = @[s_pod] || @[s_pod_node])" ).append("\n"); 
		query.append("	,@[s_del] || @[s_del_node]" ).append("\n"); 
		query.append("    ,@[s_por] || @[s_por_node]" ).append("\n"); 
		query.append("	,@[s_lane]" ).append("\n"); 
		query.append("	,@[s_ts1_port]" ).append("\n"); 
		query.append("	,@[s_ts1_lane]" ).append("\n"); 
		query.append("	,@[s_ts2_port]" ).append("\n"); 
		query.append("	,@[s_ts2_lane]" ).append("\n"); 
		query.append("	,@[s_svc_flg]" ).append("\n"); 
		query.append("	,@[s_remark]" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,@[s_dir_cd]" ).append("\n"); 
		query.append("    ,@[spcl_cgo_cntr_tp_cd]" ).append("\n"); 
		query.append("    ,@[cntr_tp_cd]" ).append("\n"); 
		query.append("    ,@[cntr_sz_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}