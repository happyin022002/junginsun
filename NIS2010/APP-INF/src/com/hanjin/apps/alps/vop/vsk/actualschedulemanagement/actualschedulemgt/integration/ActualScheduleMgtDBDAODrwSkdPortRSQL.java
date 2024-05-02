/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualScheduleMgtDBDAODrwSkdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAODrwSkdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drewry 노선 POD PORT estimate time 을 가지고 온다
	  * </pre>
	  */
	public ActualScheduleMgtDBDAODrwSkdPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAODrwSkdPortRSQL").append("\n"); 
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
		query.append("SELECT distinct T2.VSL_CD" ).append("\n"); 
		query.append("	, T2.SKD_VOY_NO" ).append("\n"); 
		query.append("	, T2.SKD_DIR_CD " ).append("\n"); 
		query.append("	, T2.VPS_PORT_CD        AS POL_CD" ).append("\n"); 
		query.append("	, T2.YD_CD              AS POL_YD_CD" ).append("\n"); 
		query.append("	, T2.CLPT_IND_SEQ       AS POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, T2.CLPT_SEQ           AS POL_CLPT_SEQ" ).append("\n"); 
		query.append("	, T1.SLAN_CD		AS SLAN_CD" ).append("\n"); 
		query.append("	, T1.VPS_PORT_CD	AS POD_CD" ).append("\n"); 
		query.append("	, T1.YD_CD		AS POD_YD_CD" ).append("\n"); 
		query.append("	, T1.CLPT_IND_SEQ	AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, T1.CLPT_SEQ		AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("	, TO_CHAR(T1.VPS_ETA_DT,'YYYYMMDDHH24MI')     AS POD_VPS_ETA_DT" ).append("\n"); 
		query.append("	, TO_CHAR(T1.VPS_ETB_DT,'YYYYMMDDHH24MI')     AS POD_VPS_ETB_DT	" ).append("\n"); 
		query.append("	,@[cre_usr_id] as CRE_USR_ID " ).append("\n"); 
		query.append("	,@[upd_usr_id] as UPD_USR_ID" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("		SELECT  VSL_CD ,SKD_VOY_NO ,SKD_DIR_CD ,CLPT_IND_SEQ ,CLPT_SEQ" ).append("\n"); 
		query.append("		       ,VPS_PORT_CD ,YD_CD ,SLAN_CD ,VPS_ETA_DT ,VPS_ETB_DT " ).append("\n"); 
		query.append("		FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		AND VSL_CD =  @[vsl_cd]" ).append("\n"); 
		query.append("		AND SKD_VOY_NO =  @[skd_voy_no] " ).append("\n"); 
		query.append("		AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		AND NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("		AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("	) T1" ).append("\n"); 
		query.append("   ,VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("   ,MDM_LOCATION T3" ).append("\n"); 
		query.append("   ,MDM_LOCATION T4" ).append("\n"); 
		query.append("   ,MDM_VSL_SVC_LANE T6" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T2.VPS_PORT_CD = T3.LOC_CD" ).append("\n"); 
		query.append("AND T1.VPS_PORT_CD = T4.LOC_CD" ).append("\n"); 
		query.append("AND T3.CONTI_CD <> T4.CONTI_CD" ).append("\n"); 
		query.append("AND TO_DATE(  @[act_dep_dt],'YYYYMMDDHH24MI')  < T1.VPS_ETA_DT" ).append("\n"); 
		query.append("AND T2.VSL_CD =  @[vsl_cd]" ).append("\n"); 
		query.append("AND T2.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND T2.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND T2.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND  T2.VPS_PORT_CD  = (SELECT PORT_CD FROM VSK_DRW_TGT_PORT WHERE PORT_CD = @[vps_port_cd] )" ).append("\n"); 
		query.append("AND  T1.VPS_PORT_CD IN (    SELECT PORT_CD" ).append("\n"); 
		query.append("                                FROM VSK_DRW_TGT_PORT" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND  PORT_CD <> @[vps_port_cd]" ).append("\n"); 
		query.append("				AND  DELT_FLG = 'N' )" ).append("\n"); 
		query.append("AND  T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD||T2.VPS_PORT_CD||T1.VPS_PORT_CD  NOT IN ( SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||POL_CD||POD_CD" ).append("\n"); 
		query.append("                                                                                             FROM VSK_VSL_DRW_SKD)" ).append("\n"); 
		query.append("AND  T2.SLAN_CD = T6.VSL_SLAN_CD " ).append("\n"); 
		query.append("AND  T6.FDR_DIV_CD <> 'O'" ).append("\n"); 

	}
}