/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOModifyDrwRptVslSkdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOModifyDrwRptVslSkdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drewry Report 테이블 업데이트
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOModifyDrwRptVslSkdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pod_act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOModifyDrwRptVslSkdUSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_VSL_DRW_SKD DRW" ).append("\n"); 
		query.append("    USING" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT    @[vvd]                VVD" ).append("\n"); 
		query.append("                , @[pol_cd]             POL_CD" ).append("\n"); 
		query.append("                , @[pol_yd_cd]          POL_YD_CD" ).append("\n"); 
		query.append("                , @[pol_clpt_ind_seq]   POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , @[pol_clpt_seq]       POL_CLPT_SEQ" ).append("\n"); 
		query.append("                , @[pod_cd]             POD_CD" ).append("\n"); 
		query.append("                , @[pod_yd_cd]          POD_YD_CD" ).append("\n"); 
		query.append("                , @[pod_clpt_ind_seq]   POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , @[pod_clpt_seq]       POD_CLPT_SEQ" ).append("\n"); 
		query.append("                , @[slan_cd]            SLAN_CD" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("    )   SRC" ).append("\n"); 
		query.append("    ON" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("                DRW.VSL_CD||DRW.SKD_VOY_NO||DRW.SKD_DIR_CD	= SRC.VVD			" ).append("\n"); 
		query.append("                AND DRW.POL_CD				= 	SRC.POL_CD			" ).append("\n"); 
		query.append("                AND DRW.POL_YD_CD			= 	SRC.POL_YD_CD		" ).append("\n"); 
		query.append("                AND DRW.POL_CLPT_IND_SEQ	= 	SRC.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND DRW.POL_CLPT_SEQ		= 	SRC.POL_CLPT_SEQ	" ).append("\n"); 
		query.append("                AND DRW.POD_CD				= 	SRC.POD_CD			" ).append("\n"); 
		query.append("                AND DRW.POD_YD_CD			= 	SRC.POD_YD_CD		" ).append("\n"); 
		query.append("                AND DRW.POD_CLPT_IND_SEQ	= 	SRC.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND DRW.POD_CLPT_SEQ		= 	SRC.POD_CLPT_SEQ	" ).append("\n"); 
		query.append("                AND DRW.SLAN_CD				=	SRC.SLAN_CD		" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET       " ).append("\n"); 
		query.append("                  UPD_USR_ID            =   @[upd_usr_id]" ).append("\n"); 
		query.append("                , UPD_DT                =   SYSDATE" ).append("\n"); 
		query.append("                , DRW_INP_YRMON         =   TO_CHAR(TO_DATE(@[pod_act_arr_dt], 'YYYYMMDDHH24MI'), 'YYYYMM')" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("                  VSL_CD" ).append("\n"); 
		query.append("                , SKD_VOY_NO" ).append("\n"); 
		query.append("                , SKD_DIR_CD" ).append("\n"); 
		query.append("                , POL_CD" ).append("\n"); 
		query.append("                , POL_YD_CD" ).append("\n"); 
		query.append("                , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , POL_CLPT_SEQ" ).append("\n"); 
		query.append("                , POD_CD" ).append("\n"); 
		query.append("                , POD_YD_CD" ).append("\n"); 
		query.append("                , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , POD_CLPT_SEQ" ).append("\n"); 
		query.append("                , SLAN_CD" ).append("\n"); 
		query.append("                , POL_ACT_DEP_DT" ).append("\n"); 
		query.append("                , POL_ACT_ATD_INP_DT" ).append("\n"); 
		query.append("                , POD_VPS_ETA_DT" ).append("\n"); 
		query.append("                , POD_VPS_ETB_DT" ).append("\n"); 
		query.append("                , CRE_USR_ID" ).append("\n"); 
		query.append("                , CRE_DT" ).append("\n"); 
		query.append("                , UPD_USR_ID" ).append("\n"); 
		query.append("                , UPD_DT" ).append("\n"); 
		query.append("                , DRW_INP_YRMON" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("                  SUBSTR(@[vvd],1,4)   " ).append("\n"); 
		query.append("                , SUBSTR(@[vvd],5,4)   " ).append("\n"); 
		query.append("                , SUBSTR(@[vvd],9,1)    " ).append("\n"); 
		query.append("	            , @[pol_cd]" ).append("\n"); 
		query.append("	            , @[pol_yd_cd]" ).append("\n"); 
		query.append("	            , @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("	            , @[pol_clpt_seq]" ).append("\n"); 
		query.append("	            , @[pod_cd]" ).append("\n"); 
		query.append("	            , @[pod_yd_cd]" ).append("\n"); 
		query.append("	            , @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("	            , @[pod_clpt_seq]" ).append("\n"); 
		query.append("	            , @[slan_cd]" ).append("\n"); 
		query.append("	            , TO_DATE(@[pol_act_dep_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	            , SYSDATE" ).append("\n"); 
		query.append("	            , TO_DATE(@[pod_vps_eta_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	            , TO_DATE(@[pod_vps_etb_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	            , @[cre_usr_id] " ).append("\n"); 
		query.append("	            , SYSDATE " ).append("\n"); 
		query.append("	            , @[upd_usr_id]" ).append("\n"); 
		query.append("	            , SYSDATE" ).append("\n"); 
		query.append("	            , TO_CHAR(@[pod_act_arr_dt], 'YYYYMM') " ).append("\n"); 
		query.append("	   )" ).append("\n"); 

	}
}