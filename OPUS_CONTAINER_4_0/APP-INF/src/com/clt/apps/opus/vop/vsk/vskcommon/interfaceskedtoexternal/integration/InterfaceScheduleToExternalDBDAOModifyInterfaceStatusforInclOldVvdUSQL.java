/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforInclOldVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.10 
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

public class InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforInclOldVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F 수정대상 VVD 업데이트
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforInclOldVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_if_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforInclOldVvdUSQL").append("\n"); 
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
		query.append("UPDATE    	VSK_VSL_SKD_VIPS_IF_MST		X" ).append("\n"); 
		query.append("SET       	X.INSF_DV_CD				= NVL(@[vvd_del_cd]		,X.INSF_DV_CD		)" ).append("\n"); 
		query.append("       	,  	X.VIPS_IF_RMK             	= SUBSTR(X.VIPS_IF_RMK,1,3000)" ).append("\n"); 
		query.append("									  		||CHR(10)||'-------------------------------------------------------------'" ).append("\n"); 
		query.append("									  		||CHR(10)||' > '||'I/F TIME : ['||TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH24:MI:SS FF6')||']'" ).append("\n"); 
		query.append("									  		||CHR(10)||' > '||NVL(@[vips_if_rmk]	,'Update Interface Target Indicator by System')" ).append("\n"); 
		query.append("									  		||CHR(10)||'-------------------------------------------------------------'" ).append("\n"); 
		query.append("									  		||CHR(10)" ).append("\n"); 
		query.append("       	,  	X.UPD_USR_ID              	= 'UPD IF TGT BY SYS'" ).append("\n"); 
		query.append("       	,  	X.UPD_DT                  	= SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	X.VSL_SLAN_CD				= NVL(@[vsl_slan_cd],X.VSL_SLAN_CD)" ).append("\n"); 
		query.append("		,	X.VIPS_MODI_VSL_SLAN_CD    	= (SELECT MODI_VSL_SLAN_CD 		FROM MDM_VSL_SVC_LANE 		WHERE VSL_SLAN_CD	= @[vsl_slan_cd])	" ).append("\n"); 
		query.append("		,	X.VIPS_MODI_VSL_CD         	= (SELECT MODI_VSL_CD 			FROM MDM_VSL_CNTR 			WHERE VSL_CD 		= @[vsl_cd])		    " ).append("\n"); 
		query.append("		,	X.VIPS_MODI_SKD_DIR_CD     	= (SELECT MODI_VSL_SLAN_DIR_CD	FROM MDM_VSL_SVC_LANE_DIR 	WHERE VSL_SLAN_CD 	= @[vsl_slan_cd] AND VSL_SLAN_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append("		,	X.PF_SVC_TP_CD             	= CASE 	WHEN @[pf_svc_tp_cd] IS NOT NULL THEN @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("												ELSE (SELECT VS.PF_SKD_TP_CD FROM VSK_VSL_SKD VS WHERE VS.VSL_CD = @[vsl_cd] AND VS.SKD_VOY_NO = @[skd_voy_no] AND VS.SKD_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append("	   									  END        " ).append("\n"); 
		query.append("		,	X.MODI_VOP_TP_CD           	= (SELECT MODI_VSL_OPR_TP_CD	FROM MDM_VSL_CNTR VC 		WHERE VSL_CD 		= @[vsl_cd])      " ).append("\n"); 
		query.append("		,	X.MODI_VIP_TEAM_CD         	= (SELECT MODI_VIP_TEAM_CD		FROM MDM_VSL_SVC_LANE 		WHERE VSL_SLAN_CD	= @[vsl_slan_cd])	    " ).append("\n"); 
		query.append("		,	X.VIPS_VSL_ENG_NM          	= (SELECT VSL_ENG_NM 			FROM MDM_VSL_CNTR 			WHERE VSL_CD 		= @[vsl_cd])		     " ).append("\n"); 
		query.append("		,	X.VIPS_CALL_SGN_NO         	= (SELECT CALL_SGN_NO 			FROM MDM_VSL_CNTR 			WHERE VSL_CD 		= @[vsl_cd])		    " ).append("\n"); 
		query.append("WHERE     	1 = 1" ).append("\n"); 
		query.append("----AND   	X.VIPS_IF_TGT_FLG         	= 'Y'" ).append("\n"); 
		query.append("AND       	X.VSL_CD                  	= @[vsl_cd]" ).append("\n"); 
		query.append("AND       	X.SKD_VOY_NO              	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND       	X.SKD_DIR_CD              	= @[skd_dir_cd]     " ).append("\n"); 
		query.append("AND       	X.VIPS_IF_SEQ             	= @[vips_if_seq]" ).append("\n"); 

	}
}