/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TimeClockStopMgtDBDAODmtTimeClockStopListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.14
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.03.14 KIM HYUN HWA
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
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
		query.append("SELECT ROWNUM AS num," ).append("\n"); 
		query.append("       B.clk_stop_no," ).append("\n"); 
		query.append("       DECODE (B.cxl_flg, 'N', 'Live', 'Y', 'Cancelled') AS cxl_flg," ).append("\n"); 
		query.append("       B.dmdt_trf_cd," ).append("\n"); 
		query.append("      (SELECT dmdt_trf_nm" ).append("\n"); 
		query.append("       FROM dmt_trf_tp T" ).append("\n"); 
		query.append("       WHERE T.dmdt_trf_cd = B.dmdt_trf_cd)          AS dmdt_trf_nm," ).append("\n"); 
		query.append("       B.clk_stop_ofc_cd," ).append("\n"); 
		query.append("      (SELECT ofc_eng_nm" ).append("\n"); 
		query.append("       FROM mdm_organization M" ).append("\n"); 
		query.append("       WHERE M.ofc_cd = B.clk_stop_ofc_cd)  AS clk_stop_ofc_nm," ).append("\n"); 
		query.append("       TO_CHAR(B.clk_stop_fm_dt,'YYYY-MM-DD') AS clk_stop_fm_dt," ).append("\n"); 
		query.append("       TO_CHAR(B.clk_stop_to_dt,'YYYY-MM-DD') AS clk_stop_to_dt," ).append("\n"); 
		query.append("	   CEIL((TO_DATE (TO_CHAR (B.clk_stop_to_dt, 'rrrrmmdd'),'rrrrmmdd')+ .99999) -" ).append("\n"); 
		query.append("		    (TO_DATE (TO_CHAR (B.clk_stop_fm_dt, 'rrrrmmdd'),'rrrrmmdd')+ .00001)) AS stop_days," ).append("\n"); 
		query.append("       B.clk_stop_rmk," ).append("\n"); 
		query.append("       B.cre_usr_id," ).append("\n"); 
		query.append("       TO_CHAR (B.cre_dt, 'yyyy-mm-dd') AS cre_dt," ).append("\n"); 
		query.append("       B.cre_ofc_cd," ).append("\n"); 
		query.append("      (SELECT usr_nm" ).append("\n"); 
		query.append("       FROM com_user U" ).append("\n"); 
		query.append("       WHERE U.usr_id = B.upd_usr_id) AS upd_usr_id," ).append("\n"); 
		query.append("       TO_CHAR (B.upd_dt, 'yyyy-mm-dd') AS upd_dt," ).append("\n"); 
		query.append("       B.upd_ofc_cd," ).append("\n"); 
		query.append("       B.dmdt_bkg_term_ctnt," ).append("\n"); 
		query.append("      (SELECT SUBSTR(XMLAGG(XMLELEMENT(A, ',' ||A.YD_CD) ORDER BY A.YD_CD).EXTRACT( '//text()'), 2)" ).append("\n"); 
		query.append("       FROM   DMT_TM_CLK_STOP_YD A " ).append("\n"); 
		query.append("       WHERE  A.CLK_STOP_NO = B.CLK_STOP_NO ) AS clk_stop_yd_cd" ).append("\n"); 
		query.append(" FROM dmt_tm_clk_stop B" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("#if (${date_period} == 'creation') " ).append("\n"); 
		query.append("       B.cre_dt BETWEEN TO_DATE (@[fm_dt], 'rrrrmmdd') + .00001 AND TO_DATE (@[to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("#elseif (${date_period} == 'stop_date')" ).append("\n"); 
		query.append("       B.clk_stop_fm_dt BETWEEN TO_DATE (@[fm_dt], 'rrrrmmdd') + .00001 AND TO_DATE (@[to_dt], 'rrrrmmdd') + .99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${cxl_flg} != '') " ).append("\n"); 
		query.append(" and   B.cxl_flg = @[cxl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${office} == 'creation')" ).append("\n"); 
		query.append("	#if (${clk_stop_ofc_cd} != '') " ).append("\n"); 
		query.append("		and B.cre_ofc_cd in   (" ).append("\n"); 
		query.append("                   #foreach($ofc_cd IN ${sch_ofc_cd})								" ).append("\n"); 
		query.append("						#if($sch_ofc_cd.hasNext()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("		  		   #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${office} == 'stop_office')" ).append("\n"); 
		query.append("	#if (${clk_stop_ofc_cd} != '') " ).append("\n"); 
		query.append("		and  B.clk_stop_ofc_cd in  (" ).append("\n"); 
		query.append("                  #foreach($ofc_cd IN ${sch_ofc_cd})								" ).append("\n"); 
		query.append("						#if($sch_ofc_cd.hasNext()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("				  #end" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} != '') " ).append("\n"); 
		query.append("	and B.dmdt_trf_cd in  (" ).append("\n"); 
		query.append("            #foreach($trf_cd IN ${sch_trf_cd})								" ).append("\n"); 
		query.append("							#if($sch_trf_cd.hasNext()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${date_period} == 'creation') " ).append("\n"); 
		query.append(" ORDER BY B.cre_dt DESC" ).append("\n"); 
		query.append("#elseif (${date_period} == 'stop_date')" ).append("\n"); 
		query.append(" ORDER BY B.clk_stop_fm_dt DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}