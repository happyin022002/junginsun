/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerforManceMgtDBDAOManagePortTimeAcitvityListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerforManceMgtDBDAOManagePortTimeAcitvityListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Port별 Activity Time 정보을 생성 및 변경한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * </pre>
	  */
	public PortTimePerforManceMgtDBDAOManagePortTimeAcitvityListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_perf_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_svr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_act_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("op_stpg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hndl_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerforManceMgtDBDAOManagePortTimeAcitvityListCSQL").append("\n"); 
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
		query.append("MERGE INTO OPF_PORT_TM_ACT T" ).append("\n"); 
		query.append("USING   (" ).append("\n"); 
		query.append("        SELECT    @[vsl_cd]        AS VSL_CD" ).append("\n"); 
		query.append("                , @[skd_voy_no]    AS SKD_VOY_NO" ).append("\n"); 
		query.append("                , @[skd_dir_cd]    AS SKD_DIR_CD" ).append("\n"); 
		query.append("                , @[vps_port_cd]   AS VPS_PORT_CD" ).append("\n"); 
		query.append("                , @[clpt_ind_seq]  AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , @[port_act_ctnt] AS PORT_ACT_CTNT" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        ) S" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(           T.VSL_CD        = S.VSL_CD" ).append("\n"); 
		query.append("    AND     T.SKD_VOY_NO    = S.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND     T.SKD_DIR_CD    = S.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND     T.VPS_PORT_CD   = S.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND     T.CLPT_IND_SEQ  = S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND     T.PORT_ACT_CTNT = S.PORT_ACT_CTNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("        WRK_PERF_DT     = TO_DATE(@[wrk_perf_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("      , CNTR_HNDL_KNT   = NVL(@[cntr_hndl_knt], 0)          " ).append("\n"); 
		query.append("      , OP_STPG_CTNT    = @[op_stpg_ctnt]" ).append("\n"); 
		query.append("      , SRC_SVR_NM      = @[src_svr_nm]" ).append("\n"); 
		query.append("      , DIFF_RMK        = @[diff_rmk]" ).append("\n"); 
		query.append("      , UPD_USR_ID      = @[cre_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHERE   T.VSL_CD        = S.VSL_CD" ).append("\n"); 
		query.append("AND     T.SKD_VOY_NO    = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T.SKD_DIR_CD    = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T.VPS_PORT_CD   = S.VPS_PORT_CD" ).append("\n"); 
		query.append("AND     T.CLPT_IND_SEQ  = S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND     T.PORT_ACT_CTNT = S.PORT_ACT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("          VSL_CD                       " ).append("\n"); 
		query.append("        , SKD_VOY_NO                   " ).append("\n"); 
		query.append("        , SKD_DIR_CD                   " ).append("\n"); 
		query.append("        , VPS_PORT_CD                  " ).append("\n"); 
		query.append("        , CLPT_IND_SEQ             --05" ).append("\n"); 
		query.append("        , PORT_ACT_CTNT                " ).append("\n"); 
		query.append("        , WRK_PERF_DT                  " ).append("\n"); 
		query.append("        , CNTR_HNDL_KNT                " ).append("\n"); 
		query.append("        , OP_STPG_CTNT                 " ).append("\n"); 
		query.append("        , SRC_SVR_NM               --10" ).append("\n"); 
		query.append("        , DIFF_RMK                     " ).append("\n"); 
		query.append("        , CRE_USR_ID                   " ).append("\n"); 
		query.append("        , CRE_DT                       " ).append("\n"); 
		query.append("        , UPD_USR_ID                   " ).append("\n"); 
		query.append("        , UPD_DT                   --15" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("          @[vsl_cd]                     " ).append("\n"); 
		query.append("        , @[skd_voy_no]                 " ).append("\n"); 
		query.append("        , @[skd_dir_cd]                 " ).append("\n"); 
		query.append("        , @[vps_port_cd]                " ).append("\n"); 
		query.append("        , @[clpt_ind_seq]          --05 " ).append("\n"); 
		query.append("        , @[port_act_ctnt]              " ).append("\n"); 
		query.append("        , TO_DATE(@[wrk_perf_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        , NVL(@[cntr_hndl_knt], 0)      " ).append("\n"); 
		query.append("        , @[op_stpg_ctnt]               " ).append("\n"); 
		query.append("        , @[src_svr_nm]            --10 " ).append("\n"); 
		query.append("        , @[diff_rmk]                   " ).append("\n"); 
		query.append("        , @[cre_usr_id]                 " ).append("\n"); 
		query.append("        , SYSDATE                       " ).append("\n"); 
		query.append("        , @[upd_usr_id]                 " ).append("\n"); 
		query.append("        , SYSDATE                  --15 " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}