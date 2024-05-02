/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOPfLaneTypeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOPfLaneTypeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proforma Type 정보를 조회합니다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOPfLaneTypeVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOPfLaneTypeVORSQL").append("\n"); 
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
		query.append("SELECT ROWNUM AS RNUM" ).append("\n"); 
		query.append("       , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("       , T2.VSL_SLAN_NM" ).append("\n"); 
		query.append("       , T1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("       , T1.SLAN_STND_FLG" ).append("\n"); 
		query.append("       , T2.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("  FROM MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("       , VSK_BUD_PF_SKD T1" ).append("\n"); 
		query.append(" WHERE T2.VSL_SLAN_CD = T1.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("   AND T2.VSL_SLAN_CD LIKE @[vsl_slan_cd] || '%'" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} == 'Y') " ).append("\n"); 
		query.append("   AND T1.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND T2.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("   AND T2.DELT_FLG = 'N'" ).append("\n"); 

	}
}