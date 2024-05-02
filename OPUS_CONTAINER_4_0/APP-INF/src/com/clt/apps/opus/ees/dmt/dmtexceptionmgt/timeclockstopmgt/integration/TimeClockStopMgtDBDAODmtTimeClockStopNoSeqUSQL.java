/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TimeClockStopMgtDBDAODmtTimeClockStopNoSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
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

public class TimeClockStopMgtDBDAODmtTimeClockStopNoSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtTimeClockStopNoSeq
	  * </pre>
	  */
	public TimeClockStopMgtDBDAODmtTimeClockStopNoSeqUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAODmtTimeClockStopNoSeqUSQL").append("\n"); 
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
		query.append("UPDATE dmt_tm_clk_stop_no" ).append("\n"); 
		query.append("   SET clk_stop_no_seq = @[seq]," ).append("\n"); 
		query.append("       clk_stop_no =" ).append("\n"); 
		query.append("          @[clk_stop_ofc_cd]" ).append("\n"); 
		query.append("          || TO_CHAR (SYSDATE, 'rrmm')" ).append("\n"); 
		query.append("          || LTRIM (TO_CHAR (@[seq], '0000'))," ).append("\n"); 
		query.append("       upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("       upd_dt = SYSDATE," ).append("\n"); 
		query.append("       upd_ofc_cd = @[upd_ofc_cd]" ).append("\n"); 
		query.append(" WHERE clk_stop_ofc_cd = @[clk_stop_ofc_cd]" ).append("\n"); 
		query.append("   AND clk_stop_yrmon_no = TO_CHAR (SYSDATE, 'rrmm')" ).append("\n"); 

	}
}