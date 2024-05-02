/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TimeClockStopMgtDBDAODmtTimeClockStopListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TimeClockStopMgtDBDAODmtTimeClockStopListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtTimeClockStopList
	  * </pre>
	  */
	public TimeClockStopMgtDBDAODmtTimeClockStopListRSQL(){
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
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAODmtTimeClockStopListRSQL").append("\n"); 
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
		query.append("WITH CLK AS (" ).append("\n"); 
		query.append("SELECT ROWNUM AS num," ).append("\n"); 
		query.append("       clk_stop_no," ).append("\n"); 
		query.append("       DECODE (cxl_flg, 'N', 'Live', 'Y', 'Cancelled') AS cxl_flg," ).append("\n"); 
		query.append("       dmdt_trf_cd," ).append("\n"); 
		query.append("       (SELECT dmdt_trf_nm" ).append("\n"); 
		query.append("          FROM dmt_trf_tp" ).append("\n"); 
		query.append("         WHERE dmt_trf_tp.dmdt_trf_cd = dmt_tm_clk_stop.dmdt_trf_cd)" ).append("\n"); 
		query.append("                                                               AS dmdt_trf_nm," ).append("\n"); 
		query.append("       clk_stop_ofc_cd," ).append("\n"); 
		query.append("       (SELECT ofc_eng_nm" ).append("\n"); 
		query.append("          FROM mdm_organization" ).append("\n"); 
		query.append("         WHERE mdm_organization.ofc_cd = dmt_tm_clk_stop.clk_stop_ofc_cd)" ).append("\n"); 
		query.append("                                                           AS clk_stop_ofc_nm," ).append("\n"); 
		query.append("       TO_CHAR(clk_stop_fm_dt,'YYYY-MM-DD') AS clk_stop_fm_dt," ).append("\n"); 
		query.append("       TO_CHAR(clk_stop_to_dt,'YYYY-MM-DD') AS clk_stop_to_dt," ).append("\n"); 
		query.append("		CEIL((TO_DATE (TO_CHAR (clk_stop_to_dt, 'rrrrmmdd'),'rrrrmmdd')+ .99999) -" ).append("\n"); 
		query.append("		(TO_DATE (TO_CHAR (clk_stop_fm_dt, 'rrrrmmdd'),'rrrrmmdd')+ .00001)) AS stop_days," ).append("\n"); 
		query.append("       clk_stop_rmk," ).append("\n"); 
		query.append("       cre_usr_id," ).append("\n"); 
		query.append("       TO_CHAR (cre_dt, 'yyyy-mm-dd') AS cre_dt," ).append("\n"); 
		query.append("       cre_ofc_cd," ).append("\n"); 
		query.append("       (SELECT usr_nm" ).append("\n"); 
		query.append("          FROM com_user" ).append("\n"); 
		query.append("         WHERE com_user.usr_id = dmt_tm_clk_stop.upd_usr_id) AS upd_usr_id," ).append("\n"); 
		query.append("       TO_CHAR (upd_dt, 'yyyy-mm-dd') AS upd_dt," ).append("\n"); 
		query.append("       upd_ofc_cd," ).append("\n"); 
		query.append("       ALL_YD_FLG" ).append("\n"); 
		query.append("  FROM dmt_tm_clk_stop" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("		#if (${date_period} == 'creation') " ).append("\n"); 
		query.append("            cre_dt BETWEEN TO_DATE (@[fm_dt], 'rrrrmmdd') + .00001 AND TO_DATE (@[to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("		#elseif (${date_period} == 'stop_date')" ).append("\n"); 
		query.append("            clk_stop_fm_dt BETWEEN TO_DATE (@[fm_dt], 'rrrrmmdd') + .00001 AND TO_DATE (@[to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        #if (${cxl_flg} != '') " ).append("\n"); 
		query.append("		and" ).append("\n"); 
		query.append("            cxl_flg = @[cxl_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${office} == 'creation')" ).append("\n"); 
		query.append("			#if (${clk_stop_ofc_cd} != '') " ).append("\n"); 
		query.append("		and" ).append("\n"); 
		query.append("           	cre_ofc_cd in   (" ).append("\n"); 
		query.append("                       #foreach($ofc_cd IN ${sch_ofc_cd})								" ).append("\n"); 
		query.append("							#if($sch_ofc_cd.hasNext()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("		  			   #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        #elseif (${office} == 'stop_office')" ).append("\n"); 
		query.append("			#if (${clk_stop_ofc_cd} != '') " ).append("\n"); 
		query.append("		and" ).append("\n"); 
		query.append("           	clk_stop_ofc_cd in  (" ).append("\n"); 
		query.append("                       #foreach($ofc_cd IN ${sch_ofc_cd})								" ).append("\n"); 
		query.append("							#if($sch_ofc_cd.hasNext()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("        #if (${dmdt_trf_cd} != '') " ).append("\n"); 
		query.append("		and " ).append("\n"); 
		query.append("            dmdt_trf_cd in  (" ).append("\n"); 
		query.append("                        #foreach($trf_cd IN ${sch_trf_cd})								" ).append("\n"); 
		query.append("								#if($sch_trf_cd.hasNext()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        #if (${date_period} == 'creation') " ).append("\n"); 
		query.append("			ORDER BY cre_dt DESC" ).append("\n"); 
		query.append("        #elseif (${date_period} == 'stop_date')" ).append("\n"); 
		query.append("			ORDER BY clk_stop_fm_dt DESC" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT ROWNUM AS num," ).append("\n"); 
		query.append("       T1.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT CLK.*, B.YD_CD CLK_STOP_YD_CD FROM CLK, DMT_TM_CLK_STOP_YD B" ).append("\n"); 
		query.append("    WHERE CLK.ALL_YD_FLG = 'N'" ).append("\n"); 
		query.append("    AND CLK.CLK_STOP_NO = B.CLK_STOP_NO" ).append("\n"); 
		query.append("    AND B.YD_CD != 'All'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT CLK.*, C.YD_CD CLK_STOP_YD_CD FROM CLK, MDM_YARD C" ).append("\n"); 
		query.append("    WHERE CLK.ALL_YD_FLG = 'Y'" ).append("\n"); 
		query.append("    AND C.DMDT_OFC_CD = CLK.CLK_STOP_OFC_CD" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("    	C.DEM_IB_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("    	OR C.DEM_OB_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    ) T1" ).append("\n"); 

	}
}