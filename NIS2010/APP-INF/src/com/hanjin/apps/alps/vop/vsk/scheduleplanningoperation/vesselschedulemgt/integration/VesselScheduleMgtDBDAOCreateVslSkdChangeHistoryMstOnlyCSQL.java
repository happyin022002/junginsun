/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryMstOnlyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.19 
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

public class VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryMstOnlyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule 변경사항에 대한 History Master Only 데이터 생성
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryMstOnlyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_his_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryMstOnlyCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_CNG_HIS  H" ).append("\n"); 
		query.append("            (		H.VSL_CD" ).append("\n"); 
		query.append("				,  	H.SKD_VOY_NO" ).append("\n"); 
		query.append("				,  	H.SKD_DIR_CD" ).append("\n"); 
		query.append("				,	H.VVD_HIS_SEQ" ).append("\n"); 
		query.append("				---------------------------------------------------------------------" ).append("\n"); 
		query.append("				,	H.VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("				,  	H.VSL_SLAN_CD" ).append("\n"); 
		query.append("				,  	H.SKD_STS_CD" ).append("\n"); 
		query.append("				,  	H.RUSE_PROHI_FLG" ).append("\n"); 
		query.append("				,  	H.SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("				,  	H.SKD_VOY_TP_CD" ).append("\n"); 
		query.append("				,  	H.SKD_USD_IND_CD" ).append("\n"); 
		query.append("				,  	H.PF_SKD_TP_CD" ).append("\n"); 
		query.append("				,  	H.ST_PORT_CD" ).append("\n"); 
		query.append("				,  	H.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("				,  	H.PSDO_VVD_CD" ).append("\n"); 
		query.append("				,  	H.CO_CD" ).append("\n"); 
		query.append("				,  	H.SKD_RMK" ).append("\n"); 
		query.append("				,	H.DLS_EDI_SND_TGT_FLG" ).append("\n"); 
		query.append("				,	H.ACT_CRR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,  	H.CRE_USR_ID" ).append("\n"); 
		query.append("				,  	H.CRE_DT" ).append("\n"); 
		query.append("				,	H.UPD_USR_ID" ).append("\n"); 
		query.append("				,	H.UPD_DT" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				,	H.HIS_CRE_USR_ID" ).append("\n"); 
		query.append("				,	H.HIS_CRE_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,	H.HIS_DELT_PROHI_FLG " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,	H.SKD_HIS_DESC" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("	SELECT      	VS.VSL_CD" ).append("\n"); 
		query.append("            	,  	VS.SKD_VOY_NO" ).append("\n"); 
		query.append("            	,  	VS.SKD_DIR_CD" ).append("\n"); 
		query.append("				,	(	SELECT	NVL(MAX(HH.VVD_HIS_SEQ),0)+1" ).append("\n"); 
		query.append("						FROM	VSK_VSL_SKD_CNG_HIS				HH" ).append("\n"); 
		query.append("						WHERE	1 = 1" ).append("\n"); 
		query.append("						AND		HH.VSL_CD						= @[vsl_cd] " ).append("\n"); 
		query.append("						AND		HH.SKD_VOY_NO					= @[skd_voy_no]" ).append("\n"); 
		query.append("						AND		HH.SKD_DIR_CD					= @[skd_dir_cd]" ).append("\n"); 
		query.append("					)	" ).append("\n"); 
		query.append("				---------------------------------------------------------------------" ).append("\n"); 
		query.append("				,	@[vskd_cng_tp_cd]		AS VSKD_CNG_TP_CD	/* D : VVD DELETE */" ).append("\n"); 
		query.append("            	,  	VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("            	,  	VS.SKD_STS_CD" ).append("\n"); 
		query.append("            	,  	VS.RUSE_PROHI_FLG" ).append("\n"); 
		query.append("            	,  	VS.SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("            	,  	VS.SKD_VOY_TP_CD" ).append("\n"); 
		query.append("            	,  	VS.SKD_USD_IND_CD" ).append("\n"); 
		query.append("            	,  	VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("            	,  	VS.ST_PORT_CD" ).append("\n"); 
		query.append("            	,  	VS.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("            	,  	VS.PSDO_VVD_CD" ).append("\n"); 
		query.append("            	,  	VS.CO_CD" ).append("\n"); 
		query.append("            	,	VS.SKD_RMK" ).append("\n"); 
		query.append("            	,	VS.DLS_EDI_SND_TGT_FLG" ).append("\n"); 
		query.append("            	,	VS.ACT_CRR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            	,	VS.CRE_USR_ID" ).append("\n"); 
		query.append("            	,	VS.CRE_DT" ).append("\n"); 
		query.append("            	,	VS.UPD_USR_ID" ).append("\n"); 
		query.append("            	,	VS.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,	SUBSTR(NVL(@[his_cre_usr_id],'NO_ACCOUNT_USER_ID'),1,20)" ).append("\n"); 
		query.append("				,	SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,	'Y'								/* HIS_DELT_PROHI_FLG 	*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,	SUBSTR(@[skd_his_desc],1,500)	/* SKD_HIS_DESC			*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM        	VSK_VSL_SKD          VS" ).append("\n"); 
		query.append("	WHERE       	1 = 1" ).append("\n"); 
		query.append("	AND         	VS.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("	AND         	VS.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND         	VS.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 

	}
}