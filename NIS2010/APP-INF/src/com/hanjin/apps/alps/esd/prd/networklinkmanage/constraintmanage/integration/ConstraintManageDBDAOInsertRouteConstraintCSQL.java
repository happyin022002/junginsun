/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ConstraintManageDBDAOInsertRouteConstraintCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.05 
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
		params.put("rout_cnst_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
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
		query.append("MERGE INTO PRD_ROUT_CNST E " ).append("\n"); 
		query.append("      USING (SELECT @[trnk_lane_cd]  TRNK_LANE_CD, @[pol_cd] || @[pol_nod_cd]  POL_NOD_CD,  " ).append("\n"); 
		query.append("                    @[pod_cd] || @[pod_nod_cd]  POD_NOD_CD, NVL(@[del_cd]||@[del_nod_cd] , ' ')  DEL_NOD_CD, NVL(@[n1st_lane_cd] , ' ')  N1ST_LANE_CD, " ).append("\n"); 
		query.append("                    NVL(@[n1st_ts_port_cd] , ' ')  N1ST_TS_PORT_CD, NVL(@[n2nd_lane_cd] , ' ') N2ND_LANE_CD, NVL(@[n2nd_ts_port_cd] , ' ') N2ND_TS_PORT_CD, " ).append("\n"); 
		query.append("                     NVL(@[n3rd_lane_cd] , ' ') N3RD_LANE_CD,NVL(SUBSTR(@[vvd],1,4), ' ') VSL_CD,NVL(SUBSTR(@[vvd],5,4), ' ') SKD_VOY_NO ," ).append("\n"); 
		query.append("                     NVL(SUBSTR(@[vvd],9,1), ' ') SKD_DIR_CD, NVL(@[cntr_tp_cd], ' ') CNTR_TP_CD, NVL(@[cmdt_cd], ' ') CMDT_CD, NVL(@[dir_cd], ' ') DIR_CD" ).append("\n"); 
		query.append("               FROM DUAL    " ).append("\n"); 
		query.append("            ) D ON (" ).append("\n"); 
		query.append("                E.TRNK_LANE_CD = D.TRNK_LANE_CD " ).append("\n"); 
		query.append("                AND E.POL_NOD_CD = D.POL_NOD_CD " ).append("\n"); 
		query.append("                AND E.POD_NOD_CD = D.POD_NOD_CD" ).append("\n"); 
		query.append("                AND NVL(E.DEL_NOD_CD, ' ') = D.DEL_NOD_CD" ).append("\n"); 
		query.append("                AND NVL(E.N1ST_LANE_CD, ' ') = D.N1ST_LANE_CD" ).append("\n"); 
		query.append("                AND NVL(E.N1ST_TS_PORT_CD, ' ') = D.N1ST_TS_PORT_CD " ).append("\n"); 
		query.append("                AND NVL(E.N2ND_LANE_CD, ' ') = D.N2ND_LANE_CD " ).append("\n"); 
		query.append("                AND NVL(E.N2ND_TS_PORT_CD, ' ') = D.N2ND_TS_PORT_CD " ).append("\n"); 
		query.append("                AND NVL(E.N3RD_LANE_CD, ' ') = D.N3RD_LANE_CD" ).append("\n"); 
		query.append("                AND NVL(E.VSL_CD, ' ')     = D.VSL_CD" ).append("\n"); 
		query.append("                AND NVL(E.SKD_VOY_NO, ' ') = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND NVL(E.SKD_DIR_CD, ' ') = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(E.CNTR_TP_CD, ' ') = D.CNTR_TP_CD" ).append("\n"); 
		query.append("                AND NVL(E.CMDT_CD, ' ') = D.CMDT_CD" ).append("\n"); 
		query.append("                AND NVL(E.DIR_CD, ' ') = D.DIR_CD          " ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN  " ).append("\n"); 
		query.append("     UPDATE SET " ).append("\n"); 
		query.append("      DELT_FLG = 'N'" ).append("\n"); 
		query.append("     , SVC_USE_FLG = @[svc_use_flg]" ).append("\n"); 
		query.append("	 , ROUT_CNST_RMK = @[rout_cnst_rmk]" ).append("\n"); 
		query.append("	 , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	 , UPD_OFC_CD = @[upd_ofc_cd] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN  " ).append("\n"); 
		query.append("     INSERT ( " ).append("\n"); 
		query.append("		TRNK_LANE_CD, POL_NOD_CD, POD_NOD_CD, ROUT_CNST_SEQ, DEL_NOD_CD, " ).append("\n"); 
		query.append("		N1ST_LANE_CD, N1ST_TS_PORT_CD, N2ND_LANE_CD, N2ND_TS_PORT_CD, N3RD_LANE_CD, " ).append("\n"); 
		query.append("		SVC_USE_FLG, ROUT_CNST_RMK, CRE_USR_ID, CRE_DT, CRE_OFC_CD ,UPD_USR_ID,DIR_CD," ).append("\n"); 
		query.append("        UPD_OFC_CD, UPD_DT, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CNTR_TP_CD, CMDT_CD" ).append("\n"); 
		query.append("		)  " ).append("\n"); 
		query.append("     VALUES (" ).append("\n"); 
		query.append("	   @[trnk_lane_cd], @[pol_cd] ||@[pol_nod_cd], @[pod_cd] ||@[pod_nod_cd] , (SELECT NVL(MAX(ROUT_CNST_SEQ),0) + 1 FROM PRD_ROUT_CNST WHERE  TRNK_LANE_CD = @[trnk_lane_cd] AND POL_NOD_CD = @[pol_cd] || @[pol_nod_cd] AND POD_NOD_CD = @[pod_cd] ||@[pod_nod_cd]) , @[del_cd] || @[del_nod_cd] ," ).append("\n"); 
		query.append("       @[n1st_lane_cd], @[n1st_ts_port_cd], @[n2nd_lane_cd], @[n2nd_ts_port_cd], @[n3rd_lane_cd]," ).append("\n"); 
		query.append("       @[svc_use_flg], @[rout_cnst_rmk], @[cre_usr_id], SYSDATE, @[cre_ofc_cd],@[upd_usr_id],@[dir_cd]," ).append("\n"); 
		query.append("       @[upd_ofc_cd], SYSDATE, SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), SUBSTR(@[vvd], 9,1), @[cntr_tp_cd], @[cmdt_cd]" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}