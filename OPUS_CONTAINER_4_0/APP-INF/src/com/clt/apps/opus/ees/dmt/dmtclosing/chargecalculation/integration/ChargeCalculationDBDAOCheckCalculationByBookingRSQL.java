/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOCheckCalculationByBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOCheckCalculationByBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOCheckCalculationByBookingRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOCheckCalculationByBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bat_run_tm_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOCheckCalculationByBookingRSQL").append("\n"); 
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
		query.append("SELECT ( SELECT DECODE(COUNT(*),0,'Y','N')" ).append("\n"); 
		query.append("           FROM DMT_MNL_BAT_HIS" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("            AND BAT_RUN_TM_ID = @[bat_run_tm_id]" ).append("\n"); 
		query.append("			AND BAT_RSLT_FLG = 'N' )" ).append("\n"); 
		query.append("       ||'|'||" ).append("\n"); 
		query.append("	   NVL(" ).append("\n"); 
		query.append("	   BKG_JOIN_FULL_CLOB_FNC(" ).append("\n"); 
		query.append("            CURSOR(" ).append("\n"); 
		query.append("            SELECT DECODE(BAT_RSLT_FLG,'Y',BAT_RSLT_RMK,'E','Manual Batch System Error','')||' - COUNT : '||COUNT(*)" ).append("\n"); 
		query.append("             FROM DMT_MNL_BAT_HIS" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("            AND BAT_RUN_TM_ID = @[bat_run_tm_id]" ).append("\n"); 
		query.append("            AND BAT_RSLT_FLG IN ( 'Y', 'E' )" ).append("\n"); 
		query.append("            AND BAT_RSLT_RMK IS NOT NULL" ).append("\n"); 
		query.append("            GROUP BY DECODE(BAT_RSLT_FLG,'Y',BAT_RSLT_RMK,'E','Manual Batch System Error','')" ).append("\n"); 
		query.append("            ), CHR(10)" ).append("\n"); 
		query.append("        ),' ')||'|'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}