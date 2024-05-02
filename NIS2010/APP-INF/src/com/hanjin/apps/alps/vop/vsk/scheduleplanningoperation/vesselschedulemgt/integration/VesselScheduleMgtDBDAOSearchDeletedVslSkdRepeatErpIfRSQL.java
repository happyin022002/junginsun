/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchDeletedVslSkdRepeatErpIfRSQL.java
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

public class VesselScheduleMgtDBDAOSearchDeletedVslSkdRepeatErpIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제된 VVD를 ERP Re-Interface 할 수 있는대상으로 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchDeletedVslSkdRepeatErpIfRSQL(){
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
		query.append("FileName : VesselScheduleMgtDBDAOSearchDeletedVslSkdRepeatErpIfRSQL").append("\n"); 
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
		query.append("SELECT     'Y'  											AS DELETED_VVD_YN" ).append("\n"); 
		query.append("    	,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("    	,  X.VSL_SLAN_CD" ).append("\n"); 
		query.append("    	,  X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD 			AS VVD" ).append("\n"); 
		query.append("    	,  TO_CHAR(X.CRE_DT		, 'YYYY-MM-DD HH24:MI') 	AS CRE_DT" ).append("\n"); 
		query.append("    	,  TO_CHAR(X.UPD_DT		, 'YYYY-MM-DD HH24:MI') 	AS UPD_DT" ).append("\n"); 
		query.append("    	,  TO_CHAR(X.HIS_CRE_DT	, 'YYYY-MM-DD HH24:MI') 	AS DELT_DT" ).append("\n"); 
		query.append("    	,  TO_CHAR(MAX(LL.UPD_DT), 'YYYY-MM-DD HH24:MI') 	AS IF_DT" ).append("\n"); 
		query.append("    	,  X.VSL_CD" ).append("\n"); 
		query.append("    	,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    	,  X.ST_PORT_CD      								AS VPS_PORT_CD" ).append("\n"); 
		query.append("    	,  ''                								AS VPS_ETA_DT" ).append("\n"); 
		query.append("    	,  ''                								AS VPS_ETB_DT" ).append("\n"); 
		query.append("    	,  ''                								AS VPS_ETD_DT    " ).append("\n"); 
		query.append("FROM     	VSK_VSL_SKD_CNG_HIS  	X" ).append("\n"); 
		query.append("    	,  	VSK_CUST_EDI_LOG   		LL" ).append("\n"); 
		query.append("WHERE     	1 = 1" ).append("\n"); 
		query.append("   AND     X.VSL_CD       			= LL.N1ST_VSL_CD(+)" ).append("\n"); 
		query.append("   AND     X.SKD_VOY_NO     		= LL.N1ST_SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND     X.SKD_DIR_CD     		= LL.N1ST_SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND     'FNS017-RESEND'   		= LL.CUST_TRD_PRNR_ID(+)" ).append("\n"); 
		query.append("   AND     EXISTS         			(  	SELECT  ''" ).append("\n"); 
		query.append("                           				FROM   	MDM_VSL_CNTR   			VC" ).append("\n"); 
		query.append("                          				WHERE   VC.VSL_CD     			= X.VSL_CD" ).append("\n"); 
		query.append("                            			AND   	VC.VSL_CLSS_FLG 		<> 'T'" ).append("\n"); 
		query.append("                					)" ).append("\n"); 
		query.append("   AND     EXISTS         			(  	SELECT  ''" ).append("\n"); 
		query.append("                           				FROM   	AR_ROUT_RNK 			RK" ).append("\n"); 
		query.append("                          				WHERE   SUBSTR(RK.RLANE_CD,1,3)	= X.VSL_SLAN_CD" ).append("\n"); 
		query.append("                            			AND   	RK.DELT_FLG         	= 'N'" ).append("\n"); 
		query.append("                					)" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("  AND 		X.VSL_SLAN_CD 			= @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("  AND 		X.VSL_CD 				= @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("  AND 		X.SKD_VOY_NO 			= @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("  AND 		X.SKD_DIR_CD 			= @[skd_dir_cd]" ).append("\n"); 
		query.append("#elseif (${skd_dir_cd} == '' && ${skd_dir_combo} != '')" ).append("\n"); 
		query.append("  AND 		X.SKD_DIR_CD 			= @[skd_dir_combo]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("  AND 		X.CRE_DT 				BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') 			AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${first_port_etb_fm} != '' && ${first_port_etb_to} != '')" ).append("\n"); 
		query.append("  AND 		X.N1ST_PORT_BRTH_DT		BETWEEN TO_DATE(@[first_port_etb_fm], 'YYYY-MM-DD') AND TO_DATE(@[first_port_etb_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY   " ).append("\n"); 
		query.append("       		X.VSL_SLAN_CD" ).append("\n"); 
		query.append("    	,  	X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD" ).append("\n"); 
		query.append("    	,  	X.VSL_CD" ).append("\n"); 
		query.append("    	,  	X.SKD_VOY_NO" ).append("\n"); 
		query.append("    	,  	X.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	X.ST_PORT_CD" ).append("\n"); 
		query.append("    	,  	X.CRE_DT" ).append("\n"); 
		query.append("    	,  	X.UPD_DT" ).append("\n"); 
		query.append("    	,  	X.HIS_CRE_DT" ).append("\n"); 

	}
}