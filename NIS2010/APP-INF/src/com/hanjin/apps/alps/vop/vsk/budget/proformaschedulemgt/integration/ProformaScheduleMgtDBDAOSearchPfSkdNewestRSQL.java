/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchPfSkdNewestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchPfSkdNewestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 등록된 Proforma SKD 정보를 조회한다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchPfSkdNewestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchPfSkdNewestRSQL").append("\n"); 
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
		query.append("SELECT 	" ).append("\n"); 
		query.append("    VSL_SLAN_CD" ).append("\n"); 
		query.append(",	PF_SVC_TP_CD" ).append("\n"); 
		query.append(",	SLAN_STND_FLG" ).append("\n"); 
		query.append(",	SVC_DUR_DYS" ).append("\n"); 
		query.append(",	STND_SVC_SPD" ).append("\n"); 
		query.append(",	BRTH_ITVAL_DYS" ).append("\n"); 
		query.append(",	MML_USD_FLG" ).append("\n"); 
		query.append(",	SIM_DT" ).append("\n"); 
		query.append(",	SIM_NO" ).append("\n"); 
		query.append(",	N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	CLPT_KNT" ).append("\n"); 
		query.append(",	TTL_DIST" ).append("\n"); 
		query.append(",	MAX_SPD" ).append("\n"); 
		query.append(",	AVG_SPD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	PF_SKD_RMK" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	VSL_SLAN_CD" ).append("\n"); 
		query.append(",	PF_SVC_TP_CD" ).append("\n"); 
		query.append(",	SLAN_STND_FLG" ).append("\n"); 
		query.append(",	SVC_DUR_DYS" ).append("\n"); 
		query.append(",	STND_SVC_SPD" ).append("\n"); 
		query.append(",	BRTH_ITVAL_DYS" ).append("\n"); 
		query.append(",	MML_USD_FLG" ).append("\n"); 
		query.append(",	SIM_DT" ).append("\n"); 
		query.append(",	SIM_NO" ).append("\n"); 
		query.append(",	N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	CLPT_KNT" ).append("\n"); 
		query.append(",	TTL_DIST" ).append("\n"); 
		query.append(",	MAX_SPD" ).append("\n"); 
		query.append(",	AVG_SPD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	PF_SKD_RMK" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append("FROM  VSK_BUD_PF_SKD" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND DELT_FLG='N'" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}