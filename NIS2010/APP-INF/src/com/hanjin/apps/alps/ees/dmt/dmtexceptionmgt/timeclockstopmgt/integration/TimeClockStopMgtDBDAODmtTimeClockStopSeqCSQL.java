/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TimeClockStopMgtDBDAODmtTimeClockStopSeqCSQL.java
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

public class TimeClockStopMgtDBDAODmtTimeClockStopSeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT DmtTimeClockStopSeq
	  * </pre>
	  */
	public TimeClockStopMgtDBDAODmtTimeClockStopSeqCSQL(){
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
		params.put("all_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clk_stop_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clk_stop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAODmtTimeClockStopSeqCSQL").append("\n"); 
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
		query.append("INSERT INTO dmt_tm_clk_stop" ).append("\n"); 
		query.append("            (clk_stop_no," ).append("\n"); 
		query.append("             dmdt_trf_cd," ).append("\n"); 
		query.append("             clk_stop_ofc_cd," ).append("\n"); 
		query.append("             clk_stop_fm_dt," ).append("\n"); 
		query.append("             clk_stop_to_dt," ).append("\n"); 
		query.append("             clk_stop_rmk," ).append("\n"); 
		query.append("             cxl_flg," ).append("\n"); 
		query.append("             cre_usr_id," ).append("\n"); 
		query.append("             cre_dt," ).append("\n"); 
		query.append("             cre_ofc_cd," ).append("\n"); 
		query.append("             upd_usr_id," ).append("\n"); 
		query.append("             upd_dt," ).append("\n"); 
		query.append("             upd_ofc_cd," ).append("\n"); 
		query.append("             all_yd_flg," ).append("\n"); 
		query.append("             dmdt_bkg_term_ctnt" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     VALUES (@[clk_stop_ofc_cd]" ).append("\n"); 
		query.append("             || TO_CHAR (NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE), 'rrmm')" ).append("\n"); 
		query.append("             || LTRIM (TO_CHAR (@[seq], '0000'))," ).append("\n"); 
		query.append("             @[dmdt_trf_cd]," ).append("\n"); 
		query.append("             @[clk_stop_ofc_cd]," ).append("\n"); 
		query.append("             TO_DATE (@[clk_stop_fm_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("             + .00001," ).append("\n"); 
		query.append("             TO_DATE (@[clk_stop_to_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("             + .99999," ).append("\n"); 
		query.append("             @[clk_stop_rmk]," ).append("\n"); 
		query.append("             'N'," ).append("\n"); 
		query.append("             @[cre_usr_id]," ).append("\n"); 
		query.append("             NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)," ).append("\n"); 
		query.append("             @[cre_ofc_cd]," ).append("\n"); 
		query.append("             @[upd_usr_id]," ).append("\n"); 
		query.append("             NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE)," ).append("\n"); 
		query.append("             @[upd_ofc_cd]," ).append("\n"); 
		query.append("             @[all_yd_flg]," ).append("\n"); 
		query.append("             @[dmdt_bkg_term_ctnt]" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}