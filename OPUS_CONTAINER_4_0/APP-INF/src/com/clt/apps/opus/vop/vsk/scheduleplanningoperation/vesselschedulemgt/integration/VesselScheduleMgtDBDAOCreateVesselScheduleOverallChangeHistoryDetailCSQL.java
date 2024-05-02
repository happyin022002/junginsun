/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryDetailCSQL.java
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

public class VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateVesselScheduleOverallChangeHistoryDetail
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bfr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_CNG_HIS_DTL" ).append("\n"); 
		query.append("      	(" ).append("\n"); 
		query.append("         	VSL_CD" ).append("\n"); 
		query.append("      	,  	SKD_VOY_NO" ).append("\n"); 
		query.append("      	,  	SKD_DIR_CD" ).append("\n"); 
		query.append("      	,  	HIS_VVD_SEQ" ).append("\n"); 
		query.append("      	,  	HIS_SKD_SEQ" ).append("\n"); 
		query.append("      	,  	VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("      	,  	VSL_SLAN_CD" ).append("\n"); 
		query.append("      	,  	VPS_PORT_CD" ).append("\n"); 
		query.append("      	,  	BFR_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      	,  	CLPT_IND_SEQ" ).append("\n"); 
		query.append("      	,  	CLPT_SEQ" ).append("\n"); 
		query.append("      	,  	BFR_YD_CD" ).append("\n"); 
		query.append("      	,  	YD_CD" ).append("\n"); 
		query.append("      	,  	SKD_CNG_STS_CD" ).append("\n"); 
		query.append("      	,  	TURN_PORT_FLG" ).append("\n"); 
		query.append("      	,  	TURN_PORT_IND_CD" ).append("\n"); 
		query.append("      	,  	TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("      	,  	TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("      	,  	TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      	,  	PORT_SKD_STS_CD" ).append("\n"); 
		query.append("      	,  	PF_ETA_DT" ).append("\n"); 
		query.append("      	,  	PF_ETB_DT" ).append("\n"); 
		query.append("      	,  	PF_ETD_DT" ).append("\n"); 
		query.append("      	,  	INIT_ETA_DT" ).append("\n"); 
		query.append("      	,  	INIT_ETB_DT" ).append("\n"); 
		query.append("      	,  	INIT_ETD_DT" ).append("\n"); 
		query.append("      	,  	VPS_ETA_DT" ).append("\n"); 
		query.append("      	,  	VPS_ETB_DT" ).append("\n"); 
		query.append("      	,  	VPS_ETD_DT" ).append("\n"); 
		query.append("      	,  	PRIV_CALL_FLG" ).append("\n"); 
		query.append("      	,  	SKP_CALL_FLG" ).append("\n"); 
		query.append("      	,  	ADD_CALL_FLG" ).append("\n"); 
		query.append("      	,  	ADD_CALL_XTER_FLG" ).append("\n"); 
		query.append("      	,  	VT_ADD_CALL_FLG" ).append("\n"); 
		query.append("      	,  	IN_BND_CSSM_VOY_NO" ).append("\n"); 
		query.append("      	,  	OUT_BND_CSSM_VOY_NO" ).append("\n"); 
		query.append("      	,  	CSSM_VOY_INIT_CRE_FLG" ).append("\n"); 
		query.append("      	,  	SKD_CRE_USR_ID" ).append("\n"); 
		query.append("      	,  	SKD_CRE_DT" ).append("\n"); 
		query.append("      	,  	SKD_UPD_USR_ID" ).append("\n"); 
		query.append("      	,  	SKD_UPD_DT" ).append("\n"); 
		query.append("      	,  	SKD_CNG_ID" ).append("\n"); 
		query.append("      	,  	SKD_CNG_DESC" ).append("\n"); 
		query.append("      	,  	CRE_USR_ID" ).append("\n"); 
		query.append("      	,  	CRE_DT" ).append("\n"); 
		query.append("      	,  	UPD_USR_ID" ).append("\n"); 
		query.append("      	,  	UPD_DT" ).append("\n"); 
		query.append("      	)" ).append("\n"); 
		query.append("SELECT   " ).append("\n"); 
		query.append("         	PS.VSL_CD      						/*	VSL_CD          		*/" ).append("\n"); 
		query.append("      	,  	PS.SKD_VOY_NO  						/*	SKD_VOY_NO              */" ).append("\n"); 
		query.append("      	,  	PS.SKD_DIR_CD  						/*	SKD_DIR_CD              */" ).append("\n"); 
		query.append("      	,  	@[his_vvd_seq] 						/*	HIS_VVD_SEQ             */" ).append("\n"); 
		query.append("      	,  	VSK_VSL_SKD_HIS_SKD_SEQ.NEXTVAL     /*	HIS_SKD_SEQ             */" ).append("\n"); 
		query.append("      	,  	@[vskd_cng_tp_cd]                   /*	VSKD_CNG_TP_CD          */" ).append("\n"); 
		query.append("      	,  	PS.SLAN_CD                          /*	VSL_SLAN_CD             */" ).append("\n"); 
		query.append("      	,  	PS.VPS_PORT_CD						/*	VPS_PORT_CD             */" ).append("\n"); 
		query.append("      	,  	@[bfr_clpt_ind_seq]					/*	BFR_CLPT_IND_SEQ        */" ).append("\n"); 
		query.append("      	,  	PS.CLPT_IND_SEQ						/*	CLPT_IND_SEQ            */" ).append("\n"); 
		query.append("      	,  	PS.CLPT_SEQ							/*	CLPT_SEQ                */" ).append("\n"); 
		query.append("      	,  	@[bfr_yd_cd]						/*	BFR_YD_CD               */" ).append("\n"); 
		query.append("      	,  	PS.YD_CD							/*	YD_CD                   */" ).append("\n"); 
		query.append("      	,  	PS.SKD_CNG_STS_CD					/*	SKD_CNG_STS_CD          */" ).append("\n"); 
		query.append("      	,  	PS.TURN_PORT_FLG					/*  TURN_PORT_FLG           */" ).append("\n"); 
		query.append("      	,  	PS.TURN_PORT_IND_CD					/*  TURN_PORT_IND_CD        */" ).append("\n"); 
		query.append("      	,  	PS.TURN_SKD_VOY_NO					/*  TURN_SKD_VOY_NO         */" ).append("\n"); 
		query.append("      	,  	PS.TURN_SKD_DIR_CD					/*  TURN_SKD_DIR_CD         */" ).append("\n"); 
		query.append("      	,  	PS.TURN_CLPT_IND_SEQ				/*  TURN_CLPT_IND_SEQ       */" ).append("\n"); 
		query.append("      	,  	PS.PORT_SKD_STS_CD					/*  PORT_SKD_STS_CD         */" ).append("\n"); 
		query.append("      	,  	PS.PF_ETA_DT						/*  PF_ETA_DT               */" ).append("\n"); 
		query.append("      	,  	PS.PF_ETB_DT						/*  PF_ETB_DT               */" ).append("\n"); 
		query.append("      	,  	PS.PF_ETD_DT						/*  PF_ETD_DT               */" ).append("\n"); 
		query.append("      	,  	PS.INIT_ETA_DT						/*  INIT_ETA_DT             */" ).append("\n"); 
		query.append("      	,  	PS.INIT_ETB_DT						/*  INIT_ETB_DT             */" ).append("\n"); 
		query.append("      	,  	PS.INIT_ETD_DT						/*  INIT_ETD_DT             */" ).append("\n"); 
		query.append("      	,  	PS.VPS_ETA_DT						/*  VPS_ETA_DT              */" ).append("\n"); 
		query.append("      	,  	PS.VPS_ETB_DT						/*  VPS_ETB_DT              */" ).append("\n"); 
		query.append("      	,  	PS.VPS_ETD_DT						/*  VPS_ETD_DT              */" ).append("\n"); 
		query.append("      	,  	PS.PRIV_CALL_FLG					/*  PRIV_CALL_FLG           */" ).append("\n"); 
		query.append("      	,  	PS.SKP_CALL_FLG						/*  SKP_CALL_FLG            */" ).append("\n"); 
		query.append("      	,  	PS.ADD_CALL_FLG						/*  ADD_CALL_FLG            */" ).append("\n"); 
		query.append("      	,  	PS.ADD_CALL_XTER_FLG				/*  ADD_CALL_XTER_FLG       */" ).append("\n"); 
		query.append("      	,  	PS.VT_ADD_CALL_FLG					/*  VT_ADD_CALL_FLG         */" ).append("\n"); 
		query.append("      	,  	PS.IB_CSSM_VOY_NO					/*  IN_BND_CSSM_VOY_NO      */" ).append("\n"); 
		query.append("      	,  	PS.OB_CSSM_VOY_NO					/*  OUT_BND_CSSM_VOY_NO     */" ).append("\n"); 
		query.append("      	,  	PS.CSSM_VOY_INIT_CRE_FLG			/*  CSSM_VOY_INIT_CRE_FLG   */" ).append("\n"); 
		query.append("      	,  	PS.CRE_USR_ID						/*  SKD_CRE_USR_ID          */" ).append("\n"); 
		query.append("     	,  	PS.CRE_DT							/*  SKD_CRE_DT              */" ).append("\n"); 
		query.append("      	,  	PS.UPD_USR_ID						/*  SKD_UPD_USR_ID          */" ).append("\n"); 
		query.append("      	,  	PS.UPD_DT							/*  SKD_UPD_DT              */" ).append("\n"); 
		query.append("      	,  	@[skd_cng_id]                       /*  SKD_CNG_ID              */" ).append("\n"); 
		query.append("      	,  	@[skd_cng_desc]                     /*  SKD_CNG_DESC            */" ).append("\n"); 
		query.append("      	,  	NVL(@[upd_usr_id],'NO-ACCOUNT')		/*  CRE_USR_ID              */" ).append("\n"); 
		query.append("      	,  	SYSDATE								/*  CRE_DT                  */" ).append("\n"); 
		query.append("      	,  	NVL(@[upd_usr_id],'NO-ACCOUNT')		/*  UPD_USR_ID              */" ).append("\n"); 
		query.append("      	,  	SYSDATE								/*  UPD_DT                  */" ).append("\n"); 
		query.append("FROM     	VSK_VSL_PORT_SKD   					PS" ).append("\n"); 
		query.append("WHERE    	PS.VSL_CD        					= @[vsl_cd]" ).append("\n"); 
		query.append("AND      	PS.SKD_VOY_NO    					= @[skd_voy_no]" ).append("\n"); 
		query.append("AND      	PS.SKD_DIR_CD    					= @[skd_dir_cd]" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}