/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryForDeletionOnlyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryForDeletionOnlyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateVesselScheduleOverallChangeHistoryForDeletion
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryForDeletionOnlyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_delt_prohi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_cng_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_cng_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_cng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_skd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryForDeletionOnlyCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_CNG_HIS" ).append("\n"); 
		query.append("      	(	VSL_CD" ).append("\n"); 
		query.append("      	,  	SKD_VOY_NO" ).append("\n"); 
		query.append("      	,  	SKD_DIR_CD" ).append("\n"); 
		query.append("      	,  	HIS_VVD_SEQ" ).append("\n"); 
		query.append("      	,  	VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("      	,  	VSL_SLAN_CD" ).append("\n"); 
		query.append("      	,  	PF_SKD_TP_CD" ).append("\n"); 
		query.append("      	,  	ACT_CRR_CD" ).append("\n"); 
		query.append("      	--,	HIS_DTL_DELT_DT--" ).append("\n"); 
		query.append("      	,  	HIS_DELT_PROHI_FLG" ).append("\n"); 
		query.append("      	,  	VVD_CRE_USR_ID" ).append("\n"); 
		query.append("      	,  	VVD_CRE_DT" ).append("\n"); 
		query.append("      	,  	VVD_UPD_USR_ID" ).append("\n"); 
		query.append("      	,  	VVD_UPD_DT" ).append("\n"); 
		query.append("      	,  	SKD_CNG_ID" ).append("\n"); 
		query.append("      	,  	SKD_CNG_DESC" ).append("\n"); 
		query.append("      	,  	CRE_USR_ID" ).append("\n"); 
		query.append("      	,  	CRE_DT" ).append("\n"); 
		query.append("      	,  	UPD_USR_ID" ).append("\n"); 
		query.append("      	,  	UPD_DT" ).append("\n"); 
		query.append("      		)" ).append("\n"); 
		query.append("VALUES		(" ).append("\n"); 
		query.append("   			NVL(@[vsl_cd]    	,'****' )	--VS.VSL_CD" ).append("\n"); 
		query.append("      	,  	NVL(@[skd_voy_no]  	,'****' )	--VS.SKD_VOY_NO" ).append("\n"); 
		query.append("      	,  	NVL(@[skd_dir_cd]  	,'*'  	)	--VS.SKD_DIR_CD" ).append("\n"); 
		query.append("      	,  	@[his_vvd_seq]" ).append("\n"); 
		query.append("      	,  	@[vskd_cng_tp_cd]" ).append("\n"); 
		query.append("      	,  	@[vsl_slan_cd]					--VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("      	,  	NVL(@[pf_svc_tp_cd],@[pf_skd_tp_cd])--VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("      	,  	@[act_crr_cd]			" ).append("\n"); 
		query.append("      	--,	''	--" ).append("\n"); 
		query.append("      	,  	@[his_delt_prohi_flg]" ).append("\n"); 
		query.append("      	,  	@[cre_usr_id]					--VS.CRE_USR_ID" ).append("\n"); 
		query.append("      	,  	TO_DATE(@[cre_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("      	,  	@[upd_usr_id]					--VS.UPD_USR_ID" ).append("\n"); 
		query.append("      	,  	TO_DATE(@[upd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	@[skd_cng_id]" ).append("\n"); 
		query.append("		,	@[skd_cng_desc]" ).append("\n"); 
		query.append("      	,  	NVL(@[upd_usr_id],'NO-ACCOUNT')" ).append("\n"); 
		query.append("      	,  	SYSDATE" ).append("\n"); 
		query.append("      	,  	NVL(@[upd_usr_id],'NO-ACCOUNT')" ).append("\n"); 
		query.append("      	,  	SYSDATE " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}