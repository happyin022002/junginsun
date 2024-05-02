/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOVslDepRptOverlapRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOVslDepRptOverlapRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VslDepRptOverlap
	  * </pre>
	  */
	public VesselReportDBDAOVslDepRptOverlapRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOVslDepRptOverlapRSQL").append("\n"); 
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
		query.append("SELECT	*" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("            SELECT  F.DEP_RPT_ERR_SEQ" ).append("\n"); 
		query.append("                    , F.VSL_CD||F.SKD_VOY_NO||F.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                    , F.DEP_PORT_CD " ).append("\n"); 
		query.append("                    , F.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    , F.DEP_RPT_ERR_TP_CD" ).append("\n"); 
		query.append("                    , F.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    , F.NXT_PORT_CD" ).append("\n"); 
		query.append("                    , F.RUP_DT" ).append("\n"); 
		query.append("                    , F.RCV_DT" ).append("\n"); 
		query.append("                    , F.RCV_SEQ" ).append("\n"); 
		query.append("                    , F.VSL_CD" ).append("\n"); 
		query.append("                    , F.VPS_ETD_DT" ).append("\n"); 
		query.append("            FROM    VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                    , FCM_DEP_RPT_ERR F" ).append("\n"); 
		query.append("            WHERE   1=1" ).append("\n"); 
		query.append("            AND     F.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("            AND     F.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     F.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND     F.DEP_PORT_CD = V.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND     F.CLPT_IND_SEQ = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			AND     F.DEP_RPT_ERR_TP_CD = 'PO'" ).append("\n"); 
		query.append("#if( ${fm_dt} != '' )" ).append("\n"); 
		query.append("    -- Canal SKD does not have ETD. RUP_DT is all exist." ).append("\n"); 
		query.append("    AND F.RUP_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYY-MM-DD')     -- UI Condition : Period From" ).append("\n"); 
		query.append("                     AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYY-MM-DD')+0.99999 -- UI Condition : Period To" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_slan_cd} != '' )								  " ).append("\n"); 
		query.append("	-- UI Condition : Lane Code" ).append("\n"); 
		query.append("    AND F.VSL_SLAN_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslSlanCd in ${vel_vsl_slan_cd})  " ).append("\n"); 
		query.append("			'$sVslSlanCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("	-- UI Condition : Vessel Code" ).append("\n"); 
		query.append("    AND F.VSL_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("			'$sVslCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vps_port_cd} != '' )" ).append("\n"); 
		query.append("	-- UI Condition : Port Code" ).append("\n"); 
		query.append("    AND F.DEP_PORT_CD IN (                     " ).append("\n"); 
		query.append("		#foreach($sVpsPortCd in ${vel_vps_port_cd})  " ).append("\n"); 
		query.append("			'$sVpsPortCd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${skd_dir_cd} != '' )" ).append("\n"); 
		query.append("	-- UI Condition : Direction Code" ).append("\n"); 
		query.append("    AND F.SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY VSL_CD, VPS_ETD_DT" ).append("\n"); 

	}
}