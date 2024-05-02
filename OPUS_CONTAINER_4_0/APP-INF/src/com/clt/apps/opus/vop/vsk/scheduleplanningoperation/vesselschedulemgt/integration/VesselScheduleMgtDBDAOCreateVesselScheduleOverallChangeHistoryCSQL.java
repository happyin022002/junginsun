/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
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

public class VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateVesselScheduleOverallChangeHistory
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryCSQL(){
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
		params.put("his_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_cng_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vskd_cng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryCSQL").append("\n"); 
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
		query.append("      	(" ).append("\n"); 
		query.append("        	VSL_CD" ).append("\n"); 
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
		query.append("      )" ).append("\n"); 
		query.append("SELECT   	VS.VSL_CD" ).append("\n"); 
		query.append("      	,  	VS.SKD_VOY_NO" ).append("\n"); 
		query.append("      	,  	VS.SKD_DIR_CD" ).append("\n"); 
		query.append("      	,  	@[his_vvd_seq]" ).append("\n"); 
		query.append("      	,  	@[vskd_cng_tp_cd]" ).append("\n"); 
		query.append("      	,  	VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("      	,  	VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("      	,  	VS.ACT_CRR_CD" ).append("\n"); 
		query.append("      	--,	''	--" ).append("\n"); 
		query.append("      	,  	NVL(@[his_delt_prohi_flg]	,'N')" ).append("\n"); 
		query.append("      	,  	VS.CRE_USR_ID" ).append("\n"); 
		query.append("      	,  	VS.CRE_DT" ).append("\n"); 
		query.append("      	,  	VS.UPD_USR_ID" ).append("\n"); 
		query.append("      	,  	VS.UPD_DT" ).append("\n"); 
		query.append("		,	@[skd_cng_id]" ).append("\n"); 
		query.append("		,	@[skd_cng_desc]" ).append("\n"); 
		query.append("      	,  	NVL(@[upd_usr_id],'NO-ACCOUNT')" ).append("\n"); 
		query.append("      	,  	SYSDATE" ).append("\n"); 
		query.append("      	,  	NVL(@[upd_usr_id],'NO-ACCOUNT')" ).append("\n"); 
		query.append("      	,  	SYSDATE      " ).append("\n"); 
		query.append("FROM     	VSK_VSL_SKD      				VS  " ).append("\n"); 
		query.append("WHERE    	VS.VSL_CD        				= @[vsl_cd]" ).append("\n"); 
		query.append("AND      	VS.SKD_VOY_NO    				= @[skd_voy_no]" ).append("\n"); 
		query.append("AND      	VS.SKD_DIR_CD    				= @[skd_dir_cd]" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}