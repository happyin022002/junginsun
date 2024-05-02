/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOSearchPairPortScheduleListRSQL.java
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

public class InterfaceScheduleToExternalDBDAOSearchPairPortScheduleListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Searching for port schudule list of pair VVD
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOSearchPairPortScheduleListRSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOSearchPairPortScheduleListRSQL").append("\n"); 
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
		query.append("SELECT		D.VSL_CD" ).append("\n"); 
		query.append("		,	D.SKD_VOY_NO" ).append("\n"); 
		query.append("		,	D.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	D.VIPS_IF_SEQ" ).append("\n"); 
		query.append("		,	D.VPS_PORT_CD" ).append("\n"); 
		query.append("		,	D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	     	" ).append("\n"); 
		query.append("		,	D.CLPT_SEQ" ).append("\n"); 
		query.append("		,	D.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("		,	D.YD_CD" ).append("\n"); 
		query.append("		,	D.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("		,	D.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("	     	" ).append("\n"); 
		query.append("		,	D.VIPS_IB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("		,	D.VIPS_OB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("		,	TO_CHAR(D.PF_ETA_DT   		,'YYYYMMDDHH24MI')	AS PF_ETA_DT   		" ).append("\n"); 
		query.append("		,	TO_CHAR(D.PF_ETB_DT         ,'YYYYMMDDHH24MI')	AS PF_ETB_DT           	" ).append("\n"); 
		query.append("		,	TO_CHAR(D.PF_ETD_DT         ,'YYYYMMDDHH24MI')	AS PF_ETD_DT           	" ).append("\n"); 
		query.append("		,	TO_CHAR(D.INIT_ETA_DT       ,'YYYYMMDDHH24MI')	AS INIT_ETA_DT         	      " ).append("\n"); 
		query.append("		,	TO_CHAR(D.INIT_ETB_DT       ,'YYYYMMDDHH24MI')	AS INIT_ETB_DT         	" ).append("\n"); 
		query.append("		,	TO_CHAR(D.INIT_ETD_DT       ,'YYYYMMDDHH24MI')	AS INIT_ETD_DT         	      " ).append("\n"); 
		query.append("		,	TO_CHAR(D.VIPS_VPS_ETA_DT   ,'YYYYMMDDHH24MI')	AS VIPS_VPS_ETA_DT     	" ).append("\n"); 
		query.append("	  	,	TO_CHAR(D.VIPS_VPS_ETB_DT   ,'YYYYMMDDHH24MI')	AS VIPS_VPS_ETB_DT     	" ).append("\n"); 
		query.append("	  	,	TO_CHAR(D.VIPS_VPS_ETD_DT   ,'YYYYMMDDHH24MI')	AS VIPS_VPS_ETD_DT     	" ).append("\n"); 
		query.append("	  	,	TO_CHAR(D.VIPS_ACT_ARR_DT   ,'YYYYMMDDHH24MI')	AS VIPS_ACT_ARR_DT     	" ).append("\n"); 
		query.append("	  	,	TO_CHAR(D.VIPS_ACT_BRTH_DT  ,'YYYYMMDDHH24MI')	AS VIPS_ACT_BRTH_DT    	" ).append("\n"); 
		query.append("	  	,	TO_CHAR(D.VIPS_ACT_DEP_DT   ,'YYYYMMDDHH24MI')	AS VIPS_ACT_DEP_DT     	" ).append("\n"); 
		query.append("	  	,	D.TURN_PORT_FLG" ).append("\n"); 
		query.append("	  	,	D.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	  	,	D.TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("	  	,	D.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	  	,	D.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	  	,	D.VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("	  	,	D.VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("	  	,	D.VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("	  	,	D.SKD_UPD_USR_ID" ).append("\n"); 
		query.append("	  	,	D.SKD_UPD_USR_NM" ).append("\n"); 
		query.append("	  	,	TO_CHAR(D.SKD_UPD_DT,'YYYYMMDDHH24MI')	AS SKD_UPD_DT" ).append("\n"); 
		query.append("	  	,	D.ADD_CALL_FLG" ).append("\n"); 
		query.append("	  	,	D.VT_ADD_CALL_FLG      " ).append("\n"); 
		query.append("	  	,	D.CRE_USR_ID" ).append("\n"); 
		query.append("	  	,	TO_CHAR(D.CRE_DT,'YYYYMMDDHH24MI')		AS CRE_DT " ).append("\n"); 
		query.append("	  	,	D.UPD_USR_ID" ).append("\n"); 
		query.append("	  	,	TO_CHAR(D.UPD_DT,'YYYYMMDDHH24MI')		AS UPD_DT" ).append("\n"); 
		query.append("FROM    	VSK_VSL_SKD_VIPS_IF_DTL D" ).append("\n"); 
		query.append("WHERE   	1 = 1" ).append("\n"); 
		query.append("AND       	D.VSL_CD                				= @[vsl_cd]" ).append("\n"); 
		query.append("AND       	D.SKD_VOY_NO            				= @[skd_voy_no]" ).append("\n"); 
		query.append("AND       	D.SKD_DIR_CD            				= @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND     	D.VIPS_IF_SEQ           				= (	SELECT	MAX(H.VIPS_IF_SEQ)" ).append("\n"); 
		query.append("--                                   					FROM    VSK_VSL_SKD_VIPS_IF_HDR  H" ).append("\n"); 
		query.append("--                                   					WHERE   H.VSL_CD                = [vsl_cd]" ).append("\n"); 
		query.append("--                                   					AND     H.SKD_VOY_NO            = [skd_voy_no]" ).append("\n"); 
		query.append("--														AND		H.INSF_CNQE_VAL			= 'S'" ).append("\n"); 
		query.append("--                                 						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       	D.VIPS_IF_SEQ                   		= (SELECT  MAX(HH.VIPS_IF_SEQ)" ).append("\n"); 
		query.append("                                                       FROM    VSK_VSL_SKD_VIPS_IF_HDR  HH              " ).append("\n"); 
		query.append("                                                            ,  VSK_VSL_SKD_VIPS_IF_MST  MM              " ).append("\n"); 
		query.append("                                                            ,  VSK_VSL_SKD_VIPS_IF_DTL  DD              " ).append("\n"); 
		query.append("                                                       WHERE   1 = 1                                    " ).append("\n"); 
		query.append("                                                       AND     HH.VSL_CD                = MM.VSL_CD     " ).append("\n"); 
		query.append("                                                       AND     HH.SKD_VOY_NO            = MM.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                       AND     HH.VIPS_IF_SEQ           = MM.VIPS_IF_SEQ" ).append("\n"); 
		query.append("                                                       AND     MM.VSL_CD                = DD.VSL_CD     " ).append("\n"); 
		query.append("                                                       AND     MM.SKD_VOY_NO            = DD.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                       AND     MM.SKD_DIR_CD            = DD.SKD_DIR_CD " ).append("\n"); 
		query.append("                                                       AND     MM.VIPS_IF_SEQ           = DD.VIPS_IF_SEQ" ).append("\n"); 
		query.append("                                                       AND     MM.VSL_CD                = @[vsl_cd]     " ).append("\n"); 
		query.append("                                                       AND     MM.SKD_VOY_NO            = @[skd_voy_no] " ).append("\n"); 
		query.append("                                                       AND     MM.SKD_DIR_CD            = @[skd_dir_cd] " ).append("\n"); 
		query.append("                                                       )                                                                                                                                                                                             " ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}