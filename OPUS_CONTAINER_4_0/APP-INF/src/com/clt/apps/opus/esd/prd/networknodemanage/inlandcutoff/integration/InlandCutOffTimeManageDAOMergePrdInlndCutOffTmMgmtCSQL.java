/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandCutOffTimeManageDAOMergePrdInlndCutOffTmMgmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCutOffTimeManageDAOMergePrdInlndCutOffTmMgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandCutOffTimeManageDAOMergePrdInlndCutOffTmMgmt
	  * </pre>
	  */
	public InlandCutOffTimeManageDAOMergePrdInlndCutOffTmMgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_cct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("thu_st_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sat_st_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fri_st_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_wk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_trsp_freq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tue_st_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_trsp_wk_itval_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sun_st_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wed_st_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_clz_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mon_st_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prio_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.integration").append("\n"); 
		query.append("FileName : InlandCutOffTimeManageDAOMergePrdInlndCutOffTmMgmtCSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_INLND_CUT_OFF_TM_MGMT C" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (LANE_CD = @[lane_cd] AND ORG_YD_CD = @[org_yd_cd] AND DEST_YD_CD = @[dest_yd_cd] AND SPCL_CGO_CNTR_TP_CD = @[spcl_cgo_cntr_tp_cd] AND EFF_FM_DT = TO_DATE(@[eff_fm_dt], 'YYYYMMDD') AND EFF_TO_DT = TO_DATE(@[eff_to_dt], 'YYYYMMDD') AND PRIO_SEQ = DECODE(@[prio_seq],'ALL',0,TO_NUMBER(@[prio_seq])))" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE" ).append("\n"); 
		query.append("		 SET INLND_CCT_TP_CD        = @[inlnd_cct_tp_cd]" ).append("\n"); 
		query.append("			,CCT_DY_CD              = @[cct_dy_cd]" ).append("\n"); 
		query.append("			,CGO_CLZ_HRMNT          = @[cgo_clz_hrmnt]" ).append("\n"); 
		query.append("			,AVAL_WK_NO             = @[aval_wk_no]" ).append("\n"); 
		query.append("			,AVAL_DY_CD             = @[aval_dy_cd]" ).append("\n"); 
		query.append("			,AVAL_HRMNT             = @[aval_hrmnt]" ).append("\n"); 
		query.append("			,INLND_TRSP_FREQ_CD     = @[inlnd_trsp_freq_cd]" ).append("\n"); 
		query.append("			,INLND_TRSP_WK_ITVAL_NO = @[inlnd_trsp_wk_itval_no]" ).append("\n"); 
		query.append("			,SUN_ST_FLG         	= NVL(@[sun_st_flg], 'N')" ).append("\n"); 
		query.append("			,MON_ST_FLG         	= NVL(@[mon_st_flg], 'N')" ).append("\n"); 
		query.append("			,TUE_ST_FLG         	= NVL(@[tue_st_flg], 'N')" ).append("\n"); 
		query.append("			,WED_ST_FLG         	= NVL(@[wed_st_flg], 'N')" ).append("\n"); 
		query.append("			,THU_ST_FLG         	= NVL(@[thu_st_flg], 'N')" ).append("\n"); 
		query.append("			,FRI_ST_FLG         	= NVL(@[fri_st_flg], 'N')" ).append("\n"); 
		query.append("			,SAT_ST_FLG         	= NVL(@[sat_st_flg], 'N')" ).append("\n"); 
		query.append("			,DELT_FLG               = 'N'" ).append("\n"); 
		query.append("			,UPD_USR_ID             = @[upd_usr_id]" ).append("\n"); 
		query.append("			,UPD_DT                 = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (" ).append("\n"); 
		query.append("	     LANE_CD" ).append("\n"); 
		query.append("		,ORG_YD_CD" ).append("\n"); 
		query.append("		,DEST_YD_CD" ).append("\n"); 
		query.append("		,EFF_FM_DT" ).append("\n"); 
		query.append("		,EFF_TO_DT" ).append("\n"); 
		query.append("		,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("		,INLND_CCT_TP_CD" ).append("\n"); 
		query.append("		,CCT_DY_CD" ).append("\n"); 
		query.append("		,CGO_CLZ_HRMNT" ).append("\n"); 
		query.append("		,AVAL_WK_NO" ).append("\n"); 
		query.append("		,AVAL_DY_CD" ).append("\n"); 
		query.append("		,AVAL_HRMNT" ).append("\n"); 
		query.append("		,INLND_TRSP_FREQ_CD" ).append("\n"); 
		query.append("		,INLND_TRSP_WK_ITVAL_NO" ).append("\n"); 
		query.append("		,SUN_ST_FLG" ).append("\n"); 
		query.append("		,MON_ST_FLG" ).append("\n"); 
		query.append("		,TUE_ST_FLG" ).append("\n"); 
		query.append("		,WED_ST_FLG" ).append("\n"); 
		query.append("		,THU_ST_FLG" ).append("\n"); 
		query.append("		,FRI_ST_FLG" ).append("\n"); 
		query.append("		,SAT_ST_FLG" ).append("\n"); 
		query.append("		,DELT_FLG" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("		,PRIO_SEQ" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("		 @[lane_cd]" ).append("\n"); 
		query.append("		,@[org_yd_cd]" ).append("\n"); 
		query.append("		,@[dest_yd_cd]" ).append("\n"); 
		query.append("		,TO_DATE(@[eff_fm_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("		,TO_DATE(@[eff_to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("		,@[spcl_cgo_cntr_tp_cd]" ).append("\n"); 
		query.append("		,@[inlnd_cct_tp_cd]" ).append("\n"); 
		query.append("		,@[cct_dy_cd]" ).append("\n"); 
		query.append("		,@[cgo_clz_hrmnt]" ).append("\n"); 
		query.append("		,@[aval_wk_no]" ).append("\n"); 
		query.append("		,@[aval_dy_cd]" ).append("\n"); 
		query.append("		,@[aval_hrmnt]" ).append("\n"); 
		query.append("		,@[inlnd_trsp_freq_cd]" ).append("\n"); 
		query.append("		,@[inlnd_trsp_wk_itval_no]" ).append("\n"); 
		query.append("		,NVL(@[sun_st_flg], 'N')" ).append("\n"); 
		query.append("		,NVL(@[mon_st_flg], 'N')" ).append("\n"); 
		query.append("		,NVL(@[tue_st_flg], 'N')" ).append("\n"); 
		query.append("		,NVL(@[wed_st_flg], 'N')" ).append("\n"); 
		query.append("		,NVL(@[thu_st_flg], 'N')" ).append("\n"); 
		query.append("		,NVL(@[fri_st_flg], 'N')" ).append("\n"); 
		query.append("		,NVL(@[sat_st_flg], 'N')" ).append("\n"); 
		query.append("		,'N'" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[upd_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,DECODE(@[prio_seq],'ALL', 0, TO_NUMBER(@[prio_seq]))" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}