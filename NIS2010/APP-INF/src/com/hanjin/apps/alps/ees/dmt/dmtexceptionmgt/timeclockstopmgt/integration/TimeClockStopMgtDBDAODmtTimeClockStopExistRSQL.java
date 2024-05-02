/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TimeClockStopMgtDBDAODmtTimeClockStopExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.16
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.03.16 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TimeClockStopMgtDBDAODmtTimeClockStopExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtTimeClockStopExist
	  * </pre>
	  */
	public TimeClockStopMgtDBDAODmtTimeClockStopExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clk_stop_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clk_stop_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_bkg_term_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clk_stop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAODmtTimeClockStopExistRSQL").append("\n"); 
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
		query.append("SELECT 'A' AS exist" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(" WHERE EXISTS (" ).append("\n"); 
		query.append("          SELECT 'X'" ).append("\n"); 
		query.append("            FROM dmt_tm_clk_stop" ).append("\n"); 
		query.append("           WHERE dmdt_trf_cd = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("             AND clk_stop_ofc_cd = @[clk_stop_ofc_cd]" ).append("\n"); 
		query.append("             AND ((clk_stop_to_dt BETWEEN TO_DATE (@[clk_stop_fm_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("                                      AND TO_DATE (@[clk_stop_to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                  OR (clk_stop_fm_dt BETWEEN TO_DATE (@[clk_stop_fm_dt],'rrrrmmdd')" ).append("\n"); 
		query.append("                                         AND TO_DATE (@[clk_stop_to_dt],'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                  OR (clk_stop_fm_dt <= TO_DATE (@[clk_stop_fm_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("                      AND clk_stop_to_dt >= TO_DATE (@[clk_stop_to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                  OR (clk_stop_fm_dt >= TO_DATE (@[clk_stop_fm_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("                      AND clk_stop_to_dt <= TO_DATE (@[clk_stop_to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("             AND cxl_flg = 'N'" ).append("\n"); 
		query.append("             AND all_yd_flg = 'Y'" ).append("\n"); 
		query.append("             AND dmdt_bkg_term_ctnt like '%'||@[dmdt_bkg_term_ctnt]||'%'" ).append("\n"); 
		query.append("           UNION ALL" ).append("\n"); 
		query.append("          SELECT 'X'" ).append("\n"); 
		query.append("            FROM dmt_tm_clk_stop a, dmt_tm_clk_stop_yd b" ).append("\n"); 
		query.append("           WHERE a.dmdt_trf_cd = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("             AND a.clk_stop_ofc_cd = @[clk_stop_ofc_cd]" ).append("\n"); 
		query.append("             AND ((a.clk_stop_to_dt BETWEEN TO_DATE (@[clk_stop_fm_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("                                      AND TO_DATE (@[clk_stop_to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                  OR (a.clk_stop_fm_dt BETWEEN TO_DATE (@[clk_stop_fm_dt],'rrrrmmdd')" ).append("\n"); 
		query.append("                                         AND TO_DATE (@[clk_stop_to_dt],'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                  OR (a.clk_stop_fm_dt <= TO_DATE (@[clk_stop_fm_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("                      AND a.clk_stop_to_dt >= TO_DATE (@[clk_stop_to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                  OR (a.clk_stop_fm_dt >= TO_DATE (@[clk_stop_fm_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("                      AND a.clk_stop_to_dt <= TO_DATE (@[clk_stop_to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("             AND a.cxl_flg = 'N'" ).append("\n"); 
		query.append("             AND all_yd_flg <> 'Y'" ).append("\n"); 
		query.append("             AND a.dmdt_bkg_term_ctnt like '%'||@[dmdt_bkg_term_ctnt]||'%'" ).append("\n"); 
		query.append("             AND a.clk_stop_no = b.clk_stop_no" ).append("\n"); 
		query.append("             AND b.yd_cd IN (" ).append("\n"); 
		query.append("    #foreach( $yd_cd in ${yd_cd_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $yd_cd_list.size()) " ).append("\n"); 
		query.append("           '$yd_cd', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$yd_cd' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}