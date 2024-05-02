/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryDetailByVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryDetailByVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule 변경이력에 대한 VVD 단위 일괄생성
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryDetailByVvdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_tml_cng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_rvs_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_rvs_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryDetailByVvdCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_CNG_HIS_DTL  D" ).append("\n"); 
		query.append("            (   D.VSL_CD" ).append("\n"); 
		query.append("        	,   D.SKD_VOY_NO" ).append("\n"); 
		query.append("        	,	D.SKD_DIR_CD" ).append("\n"); 
		query.append("        	,  	D.VVD_HIS_SEQ" ).append("\n"); 
		query.append("        	,  	D.VPS_PORT_CD" ).append("\n"); 
		query.append("        	,  	D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        	,  	D.HIS_DTL_SEQ" ).append("\n"); 
		query.append("        	---------------------------------------------------------------------" ).append("\n"); 
		query.append("        	,   D.VSL_SLAN_CD" ).append("\n"); 
		query.append("        	,   D.CLPT_SEQ" ).append("\n"); 
		query.append("        	,   D.BFR_YD_CD" ).append("\n"); 
		query.append("            ,   D.CRNT_YD_CD" ).append("\n"); 
		query.append("        	,   D.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("        	,   D.VSKD_TML_CNG_TP_CD" ).append("\n"); 
		query.append("        	,   D.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("        	,   D.PF_ETA_DT" ).append("\n"); 
		query.append("        	,   D.PF_ETB_DT" ).append("\n"); 
		query.append("        	,   D.PF_ETD_DT" ).append("\n"); 
		query.append("        	,   D.INIT_ETA_DT" ).append("\n"); 
		query.append("        	,   D.INIT_ETB_DT" ).append("\n"); 
		query.append("        	,   D.INIT_ETD_DT" ).append("\n"); 
		query.append("        	,   D.VPS_ETA_DT" ).append("\n"); 
		query.append("        	,   D.VPS_ETB_DT" ).append("\n"); 
		query.append("        	,   D.VPS_ETD_DT" ).append("\n"); 
		query.append("        	,   D.TURN_PORT_FLG" ).append("\n"); 
		query.append("        	,   D.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("        	,   D.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("        	,   D.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("        	,   D.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        	,   D.PAIR_RVS_PORT_CD" ).append("\n"); 
		query.append("        	,   D.PAIR_RVS_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        	,   D.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("        	,   D.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("			,	D.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("        	---------------------------------------------------------------------" ).append("\n"); 
		query.append("        	,   D.CRE_USR_ID" ).append("\n"); 
		query.append("        	,   D.CRE_DT" ).append("\n"); 
		query.append("        	,	D.UPD_USR_ID" ).append("\n"); 
		query.append("        	,	D.UPD_DT" ).append("\n"); 
		query.append("        	---------------------------------------------------------------------" ).append("\n"); 
		query.append("			,	D.HIS_CRE_USR_ID" ).append("\n"); 
		query.append("			,	D.HIS_CRE_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("  SELECT        PS.VSL_CD" ).append("\n"); 
		query.append("			,   PS.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,   PS.SKD_DIR_CD" ).append("\n"); 
		query.append("        	,   @[vvd_his_seq]" ).append("\n"); 
		query.append("        	,	PS.VPS_PORT_CD" ).append("\n"); 
		query.append("        	,  	PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        	,  	VSK_CNG_HIS_DTL_SEQ.NEXTVAL" ).append("\n"); 
		query.append("        	---------------------------------------------------------------------" ).append("\n"); 
		query.append("			,	PS.SLAN_CD			   		/*	SLAN_CD					*/" ).append("\n"); 
		query.append("			,	PS.CLPT_SEQ                	/*	CLPT_SEQ                */" ).append("\n"); 
		query.append("			,	@[bfr_yd_cd]               	/*	BFR_YD_CD               */" ).append("\n"); 
		query.append("			,	PS.YD_CD               	   	/*	CRNT_YD_CD              */" ).append("\n"); 
		query.append("			,	PS.CALL_YD_IND_SEQ          /*	CALL_YD_IND_SEQ         */" ).append("\n"); 
		query.append("			,	@[vskd_tml_cng_tp_cd]		/*	VSKD_TML_CNG_TP_CD   	*/" ).append("\n"); 
		query.append("			,	PS.SKD_CNG_STS_CD          	/*	SKD_CNG_STS_CD          */" ).append("\n"); 
		query.append("			,	PS.PF_ETA_DT               	/*	PF_ETA_DT               */" ).append("\n"); 
		query.append("			,	PS.PF_ETB_DT               	/*	PF_ETB_DT               */" ).append("\n"); 
		query.append("			,	PS.PF_ETD_DT               	/*	PF_ETD_DT               */" ).append("\n"); 
		query.append("			,	PS.INIT_ETA_DT             	/*	INIT_ETA_DT             */" ).append("\n"); 
		query.append("			,	PS.INIT_ETB_DT             	/*	INIT_ETB_DT             */" ).append("\n"); 
		query.append("			,	PS.INIT_ETD_DT             	/*	INIT_ETD_DT             */" ).append("\n"); 
		query.append("			,	PS.VPS_ETA_DT              	/*	VPS_ETA_DT              */" ).append("\n"); 
		query.append("			,	PS.VPS_ETB_DT              	/*	VPS_ETB_DT              */" ).append("\n"); 
		query.append("			,	PS.VPS_ETD_DT              	/*	VPS_ETD_DT              */" ).append("\n"); 
		query.append("			,	PS.TURN_PORT_FLG           	/*	TURN_PORT_FLG           */" ).append("\n"); 
		query.append("			,	PS.TURN_PORT_IND_CD       	/*	TURN_PORT_IND_CD        */" ).append("\n"); 
		query.append("			,	PS.TURN_SKD_VOY_NO         	/*	TURN_SKD_VOY_NO         */" ).append("\n"); 
		query.append("			,	PS.TURN_SKD_DIR_CD         	/*	TURN_SKD_DIR_CD         */" ).append("\n"); 
		query.append("			,	PS.TURN_CLPT_IND_SEQ       	/*	TURN_CLPT_IND_SEQ       */" ).append("\n"); 
		query.append("			,	@[pair_rvs_port_cd]        	/*	PAIR_RVS_PORT_CD        */" ).append("\n"); 
		query.append("			,	@[pair_rvs_clpt_ind_seq]	/*	PAIR_RVS_CLPT_IND_SEQ   */" ).append("\n"); 
		query.append("			,	PS.PORT_SKP_TP_CD          	/*	PORT_SKP_TP_CD          */" ).append("\n"); 
		query.append("			,	PS.PORT_SKP_RSN_CD          /*	PORT_SKP_RSN_CD         */" ).append("\n"); 
		query.append("			,	PS.PHS_IO_RSN_CD			/*  PHS_IO_RSN_CD			*/" ).append("\n"); 
		query.append("			---------------------------------------------------------------------" ).append("\n"); 
		query.append("			,	PS.CRE_USR_ID              	/*	CRE_USR_ID              */" ).append("\n"); 
		query.append("			,	PS.CRE_DT                  	/*	CRE_DT                  */" ).append("\n"); 
		query.append("			,	PS.UPD_USR_ID              	/*	UPD_USR_ID              */" ).append("\n"); 
		query.append("			,	PS.UPD_DT                  	/*	UPD_DT                  */" ).append("\n"); 
		query.append("			---------------------------------------------------------------------" ).append("\n"); 
		query.append("			,	SUBSTR(@[his_cre_usr_id],1,20)	/*	HIS_CRE_USR_ID      */" ).append("\n"); 
		query.append("			,	SYSDATE						/*	HIS_CRE_DT              */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM          VSK_VSL_PORT_SKD     		PS" ).append("\n"); 
		query.append("  WHERE         1 = 1" ).append("\n"); 
		query.append("  AND           PS.VSL_CD            		= @[vsl_cd]" ).append("\n"); 
		query.append("  AND           PS.SKD_VOY_NO        		= @[skd_voy_no]" ).append("\n"); 
		query.append("  AND           PS.SKD_DIR_CD        		= @[skd_dir_cd]" ).append("\n"); 

	}
}