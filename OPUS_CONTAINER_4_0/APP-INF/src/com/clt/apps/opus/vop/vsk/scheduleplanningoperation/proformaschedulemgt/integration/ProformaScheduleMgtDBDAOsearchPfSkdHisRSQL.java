/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOsearchPfSkdHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOsearchPfSkdHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPfSkdHis
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOsearchPfSkdHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOsearchPfSkdHisRSQL").append("\n"); 
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
		query.append("SELECT	ROWNUM AS NUM," ).append("\n"); 
		query.append("		VSL_SLAN_CD," ).append("\n"); 
		query.append("		PF_SVC_TP_CD," ).append("\n"); 
		query.append("		SIM_DT," ).append("\n"); 
		query.append("		SIM_NO," ).append("\n"); 
		query.append("		PF_HIS_SEQ," ).append("\n"); 
		query.append("		PF_SKD_STS_CD," ).append("\n"); 
		query.append("		DIFF_RMK," ).append("\n"); 
		query.append("		CRE_USR_ID," ).append("\n"); 
		query.append("		TO_CHAR(CRE_DT, 'YYYYMMDDHH24MI') AS CRE_DT," ).append("\n"); 
		query.append("		UPD_USR_ID," ).append("\n"); 
		query.append("		TO_CHAR(UPD_DT, 'YYYYMMDDHH24MI') AS UPD_DT," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("  			SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("  			FROM COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("		  	WHERE 1 = 1" ).append("\n"); 
		query.append("	  		AND  S.INTG_CD_VAL_CTNT = PF_SKD_STS_CD" ).append("\n"); 
		query.append("  			AND  S.INTG_CD_ID = 'CD01824'" ).append("\n"); 
		query.append("	 	) AS HISTORY" ).append("\n"); 
		query.append("FROM	VSK_PF_SKD_HIS" ).append("\n"); 
		query.append("WHERE	VSL_SLAN_CD	= @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND	PF_SVC_TP_CD	= @[pf_svc_tp_cd]" ).append("\n"); 

	}
}