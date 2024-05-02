/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrCraneVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrCraneVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrCraneVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bw_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crane_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lose_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("other_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdt_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("work_time",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrCraneVOCSQL").append("\n"); 
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
		query.append("INSERT INTO TDR_CRANE (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	VOY_NO" ).append("\n"); 
		query.append(",	DIR_CD" ).append("\n"); 
		query.append(",	PORT_CD" ).append("\n"); 
		query.append(",	CALL_IND" ).append("\n"); 
		query.append(",	CRANE_NO" ).append("\n"); 
		query.append(",	START_DATE" ).append("\n"); 
		query.append(",	END_DATE" ).append("\n"); 
		query.append(",	BDT_TIME" ).append("\n"); 
		query.append(",	MT_TIME" ).append("\n"); 
		query.append(",	BW_TIME" ).append("\n"); 
		query.append(",	OTHER_TIME" ).append("\n"); 
		query.append(",	LOSE_TIME" ).append("\n"); 
		query.append(",	WORK_TIME" ).append("\n"); 
		query.append(",	UPDATE_TIME" ).append("\n"); 
		query.append(",	UPDATE_USER" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[voy_no]" ).append("\n"); 
		query.append(",	@[dir_cd]" ).append("\n"); 
		query.append(",	@[port_cd]" ).append("\n"); 
		query.append(",	@[call_ind]" ).append("\n"); 
		query.append(",	@[crane_no]" ).append("\n"); 
		query.append(",	TO_DATE(@[start_date],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[end_date],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[bdt_time]" ).append("\n"); 
		query.append(",	@[mt_time]" ).append("\n"); 
		query.append(",	@[bw_time]" ).append("\n"); 
		query.append(",	@[other_time]" ).append("\n"); 
		query.append(",	@[lose_time]" ).append("\n"); 
		query.append(",	@[work_time]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[update_user]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}