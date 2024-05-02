/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F 목적의 MASTER DATA 생성
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vips_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_VIPS_IF_MST  " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   VSL_CD" ).append("\n"); 
		query.append("  ,SKD_VOY_NO" ).append("\n"); 
		query.append("  ,SKD_DIR_CD" ).append("\n"); 
		query.append("  ,VIPS_IF_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,VSL_SLAN_CD" ).append("\n"); 
		query.append("  ,VIPS_MODI_VSL_SLAN_CD" ).append("\n"); 
		query.append("  ,VIPS_MODI_VSL_CD" ).append("\n"); 
		query.append("  ,VIPS_MODI_SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("  ,INSF_DV_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,MODI_VOP_TP_CD" ).append("\n"); 
		query.append("  ,MODI_VIP_TEAM_CD" ).append("\n"); 
		query.append("  ,VIPS_VSL_ENG_NM" ).append("\n"); 
		query.append("  ,VIPS_CALL_SGN_NO" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ( @[vsl_cd]" ).append("\n"); 
		query.append("     , @[skd_voy_no]" ).append("\n"); 
		query.append("     , @[skd_dir_cd] " ).append("\n"); 
		query.append("     , @[vips_if_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , @[vsl_slan_cd]" ).append("\n"); 
		query.append("     , (SELECT MODI_VSL_SLAN_CD   	FROM MDM_VSL_SVC_LANE     	WHERE VSL_SLAN_CD  	= @[vsl_slan_cd])" ).append("\n"); 
		query.append("     , (SELECT MODI_VSL_CD       	FROM MDM_VSL_CNTR       	WHERE VSL_CD     	= @[vsl_cd])" ).append("\n"); 
		query.append("     , (SELECT MODI_VSL_SLAN_DIR_CD FROM MDM_VSL_SVC_LANE_DIR   WHERE VSL_SLAN_CD   = @[vsl_slan_cd] AND VSL_SLAN_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("     , 'VIPS_IF'" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , 'VIPS_IF'" ).append("\n"); 
		query.append("     , SYSDATE  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   	 , CASE WHEN @[pf_svc_tp_cd] IS NOT NULL THEN @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("      		ELSE (SELECT VS.PF_SKD_TP_CD FROM VSK_VSL_SKD VS 	WHERE VS.VSL_CD = @[vsl_cd] AND VS.SKD_VOY_NO = @[skd_voy_no] AND VS.SKD_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append("	   END" ).append("\n"); 
		query.append("	 , @[vvd_del_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   	 , (SELECT MODI_VSL_OPR_TP_CD	FROM MDM_VSL_CNTR VC 		WHERE VSL_CD 		= @[vsl_cd])" ).append("\n"); 
		query.append("   	 , (SELECT MODI_VIP_TEAM_CD		FROM MDM_VSL_SVC_LANE 		WHERE VSL_SLAN_CD	= @[vsl_slan_cd])" ).append("\n"); 
		query.append("	 , (SELECT VSL_ENG_NM 			FROM MDM_VSL_CNTR 			WHERE VSL_CD 		= @[vsl_cd])" ).append("\n"); 
		query.append("	 , (SELECT CALL_SGN_NO 			FROM MDM_VSL_CNTR 			WHERE VSL_CD 		= @[vsl_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}