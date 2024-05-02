/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchLastCstSkdStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.12.22 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchLastCstSkdStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 Port Schedule의 최종 상태 ( Actual 혹은 Estimate ) 를 조회한다.
	  * ---------------------------------------------------------------------------
	  * 2010.12.22 CHM-201007901-01 진마리아 SPP에서 전송된 Actual Port SKD에 대한 처리 로직 수정
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchLastCstSkdStatusRSQL(){
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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchLastCstSkdStatusRSQL").append("\n"); 
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
		query.append("SELECT	CASE WHEN NVL(T1.PORT_SKD_STS_CD, '0') >= @[port_skd_sts_cd] THEN T1.PORT_SKD_STS_CD ELSE @[port_skd_sts_cd] END  AS PORT_SKD_STS_CD" ).append("\n"); 
		query.append("		, CASE WHEN ACT_ATA_INP_DT IS NULL AND @[act_arr_dt] IS NULL " ).append("\n"); 
		query.append("		       THEN NULL" ).append("\n"); 
		query.append("			   WHEN ACT_ATA_INP_DT IS NULL AND @[act_arr_dt] IS NOT NULL " ).append("\n"); 
		query.append("			   THEN TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			   ELSE TO_CHAR(LST_ETA_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("		  END AS LST_ETA_DT" ).append("\n"); 
		query.append("		, CASE WHEN ACT_ATB_INP_DT IS NULL AND @[act_brth_dt] IS NULL" ).append("\n"); 
		query.append("		       THEN NULL" ).append("\n"); 
		query.append("			   WHEN ACT_ATB_INP_DT IS NULL AND @[act_brth_dt] IS NOT NULL " ).append("\n"); 
		query.append("			   THEN TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			   ELSE TO_CHAR(LST_ETB_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("		  END AS LST_ETB_DT" ).append("\n"); 
		query.append("		, CASE WHEN ACT_ATD_INP_DT IS NULL AND @[act_dep_dt] IS NULL" ).append("\n"); 
		query.append("		       THEN NULL" ).append("\n"); 
		query.append("			   WHEN ACT_ATD_INP_DT IS NULL AND @[act_dep_dt] IS NOT NULL " ).append("\n"); 
		query.append("			   THEN TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			   ELSE TO_CHAR(LST_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("		  END AS LST_ETD_DT" ).append("\n"); 
		query.append("	    , T1.TURN_PORT_FLG" ).append("\n"); 
		query.append("        , T1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("        , T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("        , T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("        , T1.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , T1.SLAN_CD" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD T1, VSK_ACT_PORT_SKD T2" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		T1.VSL_CD		= T2.VSL_CD			(+)" ).append("\n"); 
		query.append("AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("AND		T1.VPS_PORT_CD	= T2.VPS_PORT_CD	(+)" ).append("\n"); 
		query.append("AND		T1.CLPT_IND_SEQ	= T2.CLPT_IND_SEQ	(+)" ).append("\n"); 
		query.append("AND		T1.VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("AND		T1.SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		T1.SKD_DIR_CD 	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND		T1.VPS_PORT_CD	= @[vps_port_cd]" ).append("\n"); 
		query.append("AND		T1.CLPT_IND_SEQ	= @[clpt_ind_seq]" ).append("\n"); 

	}
}