/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchVslSkdRepeatErpIfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.26 
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

public class VesselScheduleMgtDBDAOSearchVslSkdRepeatErpIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchVslSkdRepeatErpIfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("first_port_etb_fm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_combo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("first_port_etb_to",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchVslSkdRepeatErpIfRSQL").append("\n"); 
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
		query.append("SELECT   	'N'	AS DELETED_VVD_YN" ).append("\n"); 
		query.append("		,	PS.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("		,	PS.VSL_CD||PS.SKD_VOY_NO||PS.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("		,	TO_CHAR(VS.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("		,	PS.VPS_PORT_CD" ).append("\n"); 
		query.append("		,	TO_CHAR(PS.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("		,	TO_CHAR(PS.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("		,	TO_CHAR(PS.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("		,	TO_CHAR(VS.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("		,	TO_CHAR(MAX(LL.UPD_DT), 'YYYY-MM-DD HH24:MI') AS IF_DT" ).append("\n"); 
		query.append("		,	PS.VSL_CD" ).append("\n"); 
		query.append("		,	PS.SKD_VOY_NO" ).append("\n"); 
		query.append("  FROM 		VSK_VSL_SKD         VS" ).append("\n"); 
		query.append("		,	VSK_VSL_PORT_SKD 	PS" ).append("\n"); 
		query.append("		,	VSK_CUST_EDI_LOG 	LL" ).append("\n"); 
		query.append(" WHERE 		1 = 1" ).append("\n"); 
		query.append("   AND 		VS.VSL_CD 			= PS.VSL_CD" ).append("\n"); 
		query.append("   AND 		VS.SKD_VOY_NO 		= PS.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND 		VS.SKD_DIR_CD 		= PS.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND 		VS.VSL_CD 			= LL.N1ST_VSL_CD(+)" ).append("\n"); 
		query.append("   AND 		VS.SKD_VOY_NO 		= LL.N1ST_SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND 		VS.SKD_DIR_CD 		= LL.N1ST_SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND 		'FNS017-RESEND' 	= LL.CUST_TRD_PRNR_ID(+)" ).append("\n"); 
		query.append("   AND 		PS.CLPT_SEQ 		= (	SELECT 	MIN(P.CLPT_SEQ)" ).append("\n"); 
		query.append("                        			FROM 	VSK_VSL_PORT_SKD 			P" ).append("\n"); 
		query.append("                       				WHERE 	P.VSL_CD 					= PS.VSL_CD" ).append("\n"); 
		query.append("                         			AND 	P.SKD_VOY_NO 				= PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                         			AND 	P.SKD_DIR_CD 				= PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                         			AND 	P.TURN_PORT_IND_CD 			IN ('Y', 'N')" ).append("\n"); 
		query.append("                         			AND 	NVL(P.SKD_CNG_STS_CD, '*') 	<> 'S'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("   AND 		EXISTS 				(	SELECT 	''" ).append("\n"); 
		query.append("                 					FROM 	MDM_VSL_CNTR 	VC" ).append("\n"); 
		query.append("                					WHERE 	VC.VSL_CD 		= VS.VSL_CD" ).append("\n"); 
		query.append("                  					AND 	VC.VSL_CLSS_FLG <> 'T'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("   AND 		EXISTS 				(	SELECT 	''" ).append("\n"); 
		query.append("                 					FROM 	AR_ROUT_RNK RK" ).append("\n"); 
		query.append("                					WHERE 	SUBSTR(RK.RLANE_CD, 1, 3) 	= VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  					AND 	RK.DELT_FLG 				= 'N'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("  AND 		VS.VSL_SLAN_CD 		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("  AND 		VS.VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("  AND 		VS.SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("  AND 		VS.SKD_DIR_CD 		= @[skd_dir_cd]" ).append("\n"); 
		query.append("#elseif (${skd_dir_cd} == '' && ${skd_dir_combo} != '')" ).append("\n"); 
		query.append("  AND 		VS.SKD_DIR_CD 		= @[skd_dir_combo]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("  AND 		VS.CRE_DT 				BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') 			AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${first_port_etb_fm} != '' && ${first_port_etb_to} != '')" ).append("\n"); 
		query.append("  AND 		VS.N1ST_PORT_BRTH_DT	BETWEEN TO_DATE(@[first_port_etb_fm], 'YYYY-MM-DD') AND TO_DATE(@[first_port_etb_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY 	PS.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("		,	PS.VSL_CD||PS.SKD_VOY_NO||PS.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	VS.CRE_DT" ).append("\n"); 
		query.append("		,	PS.VPS_PORT_CD" ).append("\n"); 
		query.append("		,	PS.VPS_ETA_DT" ).append("\n"); 
		query.append("		,	PS.VPS_ETB_DT" ).append("\n"); 
		query.append("		,	PS.VPS_ETD_DT" ).append("\n"); 
		query.append("		,	VS.UPD_DT" ).append("\n"); 
		query.append("		,	PS.VSL_CD" ).append("\n"); 
		query.append("		,	PS.SKD_VOY_NO" ).append("\n"); 

	}
}