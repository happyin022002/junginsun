/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstUsingVipsIfHisCSQL.java
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

public class InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstUsingVipsIfHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F MASTER CREATION USING I/F HISTORY
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstUsingVipsIfHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstUsingVipsIfHisCSQL").append("\n"); 
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
		query.append("MERGE INTO	VSK_VSL_SKD_VIPS_IF_MST		X" ).append("\n"); 
		query.append("USING      	(" ).append("\n"); 
		query.append("			--------------------------------------------------" ).append("\n"); 
		query.append("			SELECT	   M.VSL_CD" ).append("\n"); 
		query.append("					  ,M.SKD_VOY_NO" ).append("\n"); 
		query.append("					  ,M.SKD_DIR_CD" ).append("\n"); 
		query.append("					  ,@[vips_if_seq]			AS VIPS_IF_SEQ" ).append("\n"); 
		query.append("					  ,M.VSL_SLAN_CD" ).append("\n"); 
		query.append("					  ,M.VIPS_MODI_VSL_SLAN_CD" ).append("\n"); 
		query.append("					  ,M.VIPS_MODI_VSL_CD" ).append("\n"); 
		query.append("					  ,M.VIPS_MODI_SKD_DIR_CD" ).append("\n"); 
		query.append("					  ,M.CRE_USR_ID" ).append("\n"); 
		query.append("					  ,M.CRE_DT" ).append("\n"); 
		query.append("					  ,M.UPD_USR_ID" ).append("\n"); 
		query.append("					  ,M.UPD_DT" ).append("\n"); 
		query.append("					  ,M.PF_SVC_TP_CD" ).append("\n"); 
		query.append("					  ,@[insf_dv_cd]			AS INSF_DV_CD" ).append("\n"); 
		query.append("					  ,M.MODI_VOP_TP_CD" ).append("\n"); 
		query.append("					  ,M.MODI_VIP_TEAM_CD" ).append("\n"); 
		query.append("					  ,M.VIPS_VSL_ENG_NM" ).append("\n"); 
		query.append("					  ,M.VIPS_CALL_SGN_NO" ).append("\n"); 
		query.append("			FROM	  VSK_VSL_SKD_VIPS_IF_MST   M" ).append("\n"); 
		query.append("			WHERE     1 = 1" ).append("\n"); 
		query.append("			AND       M.VSL_CD                	= @[vsl_cd]" ).append("\n"); 
		query.append("			AND       M.SKD_VOY_NO            	= @[skd_voy_no] " ).append("\n"); 
		query.append("			AND       M.VIPS_IF_SEQ           	= (	SELECT   MAX(H.VIPS_IF_SEQ)" ).append("\n"); 
		query.append("			                                     	FROM     VSK_VSL_SKD_VIPS_IF_HDR H" ).append("\n"); 
		query.append("			                                     	WHERE    H.VSL_CD                = M.VSL_CD" ).append("\n"); 
		query.append("			                                     	AND      H.SKD_VOY_NO            = M.SKD_VOY_NO" ).append("\n"); 
		query.append("			                                     	AND      H.INSF_CNQE_VAL         = 'S'" ).append("\n"); 
		query.append("			                                     	)" ).append("\n"); 
		query.append("			--------------------------------------------------" ).append("\n"); 
		query.append("            ) XX" ).append("\n"); 
		query.append("	ON  	(" ).append("\n"); 
		query.append("            X.VSL_CD               		= XX.VSL_CD" ).append("\n"); 
		query.append("	AND    	X.SKD_VOY_NO           		= XX.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND    	X.SKD_DIR_CD           		= XX.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND    	X.VIPS_IF_SEQ          		= XX.VIPS_IF_SEQ" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT   " ).append("\n"); 
		query.append("  	(" ).append("\n"); 
		query.append("	   VSL_CD" ).append("\n"); 
		query.append("	  ,SKD_VOY_NO" ).append("\n"); 
		query.append("	  ,SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,VIPS_IF_SEQ" ).append("\n"); 
		query.append("	  ,VSL_SLAN_CD" ).append("\n"); 
		query.append("	  ,VIPS_MODI_VSL_SLAN_CD" ).append("\n"); 
		query.append("	  ,VIPS_MODI_VSL_CD" ).append("\n"); 
		query.append("	  ,VIPS_MODI_SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("	  ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("	  ,INSF_DV_CD" ).append("\n"); 
		query.append("	  ,MODI_VOP_TP_CD" ).append("\n"); 
		query.append("	  ,MODI_VIP_TEAM_CD" ).append("\n"); 
		query.append("	  ,VIPS_VSL_ENG_NM" ).append("\n"); 
		query.append("	  ,VIPS_CALL_SGN_NO" ).append("\n"); 
		query.append("  	)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	   XX.VSL_CD" ).append("\n"); 
		query.append("	  ,XX.SKD_VOY_NO" ).append("\n"); 
		query.append("	  ,XX.SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_IF_SEQ" ).append("\n"); 
		query.append("	  ,XX.VSL_SLAN_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_MODI_VSL_SLAN_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_MODI_VSL_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_MODI_SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,XX.CRE_USR_ID" ).append("\n"); 
		query.append("	  ,XX.CRE_DT" ).append("\n"); 
		query.append("	  ,XX.UPD_USR_ID" ).append("\n"); 
		query.append("	  ,XX.UPD_DT" ).append("\n"); 
		query.append("	  ,XX.PF_SVC_TP_CD" ).append("\n"); 
		query.append("	  ,XX.INSF_DV_CD" ).append("\n"); 
		query.append("	  ,XX.MODI_VOP_TP_CD" ).append("\n"); 
		query.append("	  ,XX.MODI_VIP_TEAM_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_VSL_ENG_NM" ).append("\n"); 
		query.append("	  ,XX.VIPS_CALL_SGN_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}