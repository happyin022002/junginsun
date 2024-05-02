/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlUsingVipsIfHisCSQL.java
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

public class InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlUsingVipsIfHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F DETAIL USING I/F HISTORY
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlUsingVipsIfHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlUsingVipsIfHisCSQL").append("\n"); 
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
		query.append("MERGE INTO	VSK_VSL_SKD_VIPS_IF_DTL 		X" ).append("\n"); 
		query.append("USING        (SELECT  	" ).append("\n"); 
		query.append("				   D.VSL_CD" ).append("\n"); 
		query.append("				  ,D.SKD_VOY_NO" ).append("\n"); 
		query.append("				  ,D.SKD_DIR_CD" ).append("\n"); 
		query.append("				  ,@[vips_if_seq]    	AS VIPS_IF_SEQ" ).append("\n"); 
		query.append("				  ,D.VPS_PORT_CD" ).append("\n"); 
		query.append("				  ,D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("				  ,D.CLPT_SEQ" ).append("\n"); 
		query.append("				  ,D.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("				  ,D.YD_CD" ).append("\n"); 
		query.append("				  ,D.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("				  ,D.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("				  ,D.VIPS_IB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("				  ,D.VIPS_OB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("				  ,D.PF_ETA_DT" ).append("\n"); 
		query.append("				  ,D.PF_ETB_DT" ).append("\n"); 
		query.append("				  ,D.PF_ETD_DT" ).append("\n"); 
		query.append("				  ,D.INIT_ETA_DT             " ).append("\n"); 
		query.append("				  ,D.INIT_ETB_DT" ).append("\n"); 
		query.append("				  ,D.INIT_ETD_DT             " ).append("\n"); 
		query.append("				  ,D.VIPS_VPS_ETA_DT" ).append("\n"); 
		query.append("				  ,D.VIPS_VPS_ETB_DT" ).append("\n"); 
		query.append("				  ,D.VIPS_VPS_ETD_DT" ).append("\n"); 
		query.append("				  ,D.VIPS_ACT_ARR_DT" ).append("\n"); 
		query.append("				  ,D.VIPS_ACT_BRTH_DT" ).append("\n"); 
		query.append("				  ,D.VIPS_ACT_DEP_DT" ).append("\n"); 
		query.append("				  ,D.VIPS_MODI_LOC_CD" ).append("\n"); 
		query.append("				  ,D.TURN_PORT_FLG" ).append("\n"); 
		query.append("				  ,D.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("				  ,D.TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("				  ,D.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("				  ,D.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				  ,D.VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("				  ,D.VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("				  ,D.VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("				  ,D.SKD_UPD_USR_ID" ).append("\n"); 
		query.append("				  ,D.SKD_UPD_USR_NM" ).append("\n"); 
		query.append("				  ,D.SKD_UPD_DT" ).append("\n"); 
		query.append("				  ,D.ADD_CALL_FLG" ).append("\n"); 
		query.append("				  ,D.VT_ADD_CALL_FLG      " ).append("\n"); 
		query.append("				  ,D.CRE_USR_ID" ).append("\n"); 
		query.append("				  ,D.CRE_DT" ).append("\n"); 
		query.append("				  ,D.UPD_USR_ID" ).append("\n"); 
		query.append("				  ,D.UPD_DT      " ).append("\n"); 
		query.append("			FROM	  VSK_VSL_SKD_VIPS_IF_DTL   D            	" ).append("\n"); 
		query.append("			WHERE     1 = 1" ).append("\n"); 
		query.append("			AND		  D.VSL_CD                	= @[vsl_cd]" ).append("\n"); 
		query.append("			AND       D.SKD_VOY_NO            	= @[skd_voy_no] " ).append("\n"); 
		query.append("			AND       D.VIPS_IF_SEQ           	= (	SELECT   MAX(H.VIPS_IF_SEQ)" ).append("\n"); 
		query.append("			                                     	FROM     VSK_VSL_SKD_VIPS_IF_HDR H" ).append("\n"); 
		query.append("			                                     	WHERE    H.VSL_CD                = D.VSL_CD" ).append("\n"); 
		query.append("			                                     	AND      H.SKD_VOY_NO            = D.SKD_VOY_NO" ).append("\n"); 
		query.append("			                                     	AND      H.INSF_CNQE_VAL         = 'S'" ).append("\n"); 
		query.append("			                                     	)" ).append("\n"); 
		query.append("            ) XX" ).append("\n"); 
		query.append("  ON    (" ).append("\n"); 
		query.append("           X.VSL_CD                   = XX.VSL_CD" ).append("\n"); 
		query.append("  AND      X.SKD_VOY_NO               = XX.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND      X.SKD_DIR_CD               = XX.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND      X.VIPS_IF_SEQ              = XX.VIPS_IF_SEQ" ).append("\n"); 
		query.append("  AND      X.VPS_PORT_CD              = XX.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND      X.CLPT_IND_SEQ             = XX.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("	   VSL_CD" ).append("\n"); 
		query.append("	  ,SKD_VOY_NO" ).append("\n"); 
		query.append("	  ,SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,VIPS_IF_SEQ" ).append("\n"); 
		query.append("	  ,VPS_PORT_CD" ).append("\n"); 
		query.append("	  ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("	  ,CLPT_SEQ" ).append("\n"); 
		query.append("	  ,PORT_SKD_STS_CD" ).append("\n"); 
		query.append("	  ,YD_CD" ).append("\n"); 
		query.append("	  ,CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("	  ,SKD_CNG_STS_CD" ).append("\n"); 
		query.append("	  ,VIPS_IB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("	  ,VIPS_OB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("	  ,PF_ETA_DT" ).append("\n"); 
		query.append("	  ,PF_ETB_DT" ).append("\n"); 
		query.append("	  ,PF_ETD_DT" ).append("\n"); 
		query.append("	  ,INIT_ETA_DT             " ).append("\n"); 
		query.append("	  ,INIT_ETB_DT" ).append("\n"); 
		query.append("	  ,INIT_ETD_DT             " ).append("\n"); 
		query.append("	  ,VIPS_VPS_ETA_DT" ).append("\n"); 
		query.append("	  ,VIPS_VPS_ETB_DT" ).append("\n"); 
		query.append("	  ,VIPS_VPS_ETD_DT" ).append("\n"); 
		query.append("	  ,VIPS_ACT_ARR_DT" ).append("\n"); 
		query.append("	  ,VIPS_ACT_BRTH_DT" ).append("\n"); 
		query.append("	  ,VIPS_ACT_DEP_DT" ).append("\n"); 
		query.append("	  ,VIPS_MODI_LOC_CD" ).append("\n"); 
		query.append("	  ,TURN_PORT_FLG" ).append("\n"); 
		query.append("	  ,TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	  ,TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("	  ,TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	  ,VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("	  ,VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("	  ,VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("	  ,SKD_UPD_USR_ID" ).append("\n"); 
		query.append("	  ,SKD_UPD_USR_NM" ).append("\n"); 
		query.append("	  ,SKD_UPD_DT" ).append("\n"); 
		query.append("	  ,ADD_CALL_FLG" ).append("\n"); 
		query.append("	  ,VT_ADD_CALL_FLG      " ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("   VALUES" ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("	   XX.VSL_CD" ).append("\n"); 
		query.append("	  ,XX.SKD_VOY_NO" ).append("\n"); 
		query.append("	  ,XX.SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_IF_SEQ" ).append("\n"); 
		query.append("	  ,XX.VPS_PORT_CD" ).append("\n"); 
		query.append("	  ,XX.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	  ,XX.CLPT_SEQ" ).append("\n"); 
		query.append("	  ,XX.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("	  ,XX.YD_CD" ).append("\n"); 
		query.append("	  ,XX.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("	  ,XX.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_IB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("	  ,XX.VIPS_OB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("	  ,XX.PF_ETA_DT" ).append("\n"); 
		query.append("	  ,XX.PF_ETB_DT" ).append("\n"); 
		query.append("	  ,XX.PF_ETD_DT" ).append("\n"); 
		query.append("	  ,XX.INIT_ETA_DT             " ).append("\n"); 
		query.append("	  ,XX.INIT_ETB_DT" ).append("\n"); 
		query.append("	  ,XX.INIT_ETD_DT             " ).append("\n"); 
		query.append("	  ,XX.VIPS_VPS_ETA_DT" ).append("\n"); 
		query.append("	  ,XX.VIPS_VPS_ETB_DT" ).append("\n"); 
		query.append("	  ,XX.VIPS_VPS_ETD_DT" ).append("\n"); 
		query.append("	  ,XX.VIPS_ACT_ARR_DT" ).append("\n"); 
		query.append("	  ,XX.VIPS_ACT_BRTH_DT" ).append("\n"); 
		query.append("	  ,XX.VIPS_ACT_DEP_DT" ).append("\n"); 
		query.append("	  ,XX.VIPS_MODI_LOC_CD" ).append("\n"); 
		query.append("	  ,XX.TURN_PORT_FLG" ).append("\n"); 
		query.append("	  ,XX.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	  ,XX.TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("	  ,XX.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,XX.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	  ,XX.VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("	  ,XX.VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("	  ,XX.SKD_UPD_USR_ID" ).append("\n"); 
		query.append("	  ,XX.SKD_UPD_USR_NM" ).append("\n"); 
		query.append("	  ,XX.SKD_UPD_DT" ).append("\n"); 
		query.append("	  ,XX.ADD_CALL_FLG" ).append("\n"); 
		query.append("	  ,XX.VT_ADD_CALL_FLG      " ).append("\n"); 
		query.append("	  ,XX.CRE_USR_ID" ).append("\n"); 
		query.append("	  ,XX.CRE_DT" ).append("\n"); 
		query.append("	  ,XX.UPD_USR_ID" ).append("\n"); 
		query.append("	  ,XX.UPD_DT " ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}