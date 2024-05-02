/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueApPeriodDBDAOAddApPeriodCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.03.10 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueApPeriodDBDAOAddApPeriodCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 등록
	  * </pre>
	  */
	public ReceiveQueueApPeriodDBDAOAddApPeriodCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ap_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clz_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueApPeriodDBDAOAddApPeriodCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_PERIOD (" ).append("\n"); 
		query.append("SYS_DIV_CD" ).append("\n"); 
		query.append(", EFF_YRMON" ).append("\n"); 
		query.append(", OFC_CD" ).append("\n"); 
		query.append(", AR_AP_DIV_CD" ).append("\n"); 
		query.append(", CLZ_STS_CD" ).append("\n"); 
		query.append(", SYS_DESC" ).append("\n"); 
		query.append(", RHQ_CD" ).append("\n"); 
		query.append(", EAI_EVNT_DT" ).append("\n"); 
		query.append(", LST_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES	(" ).append("\n"); 
		query.append("@[sys_div_cd]" ).append("\n"); 
		query.append(", @[eff_yrmon]" ).append("\n"); 
		query.append(", @[ofc_cd]" ).append("\n"); 
		query.append(", @[ar_ap_div_cd]" ).append("\n"); 
		query.append(", @[clz_sts_cd]" ).append("\n"); 
		query.append(", HJSEAI_PKG.h_decode(@[sys_desc], 'UTF8' ,'UTF8')" ).append("\n"); 
		query.append(", @[rhq_cd]" ).append("\n"); 
		query.append(", TO_DATE(@[eai_evnt_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", TO_DATE(@[lst_upd_dt], 'yyyymmdd hh24:mi:ss')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}