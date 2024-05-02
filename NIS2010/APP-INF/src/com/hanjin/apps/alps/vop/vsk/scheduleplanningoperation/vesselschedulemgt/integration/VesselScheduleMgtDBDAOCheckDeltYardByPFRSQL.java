/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckDeltYardByPFRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.05.14 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCheckDeltYardByPFRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PF에서 사용중인 Yard 중 삭제된 Yard를 조회한다.
	  * 
	  * History
	  * 2012.05.14 진마리아 CHM-201217742-01 PF 사용하여 SKD 생성시 DELETE YARD 제어 로직 추가
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckDeltYardByPFRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckDeltYardByPFRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT T1.YD_CD, T1.VSL_SLAN_CD, T1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("FROM VSK_PF_SKD_DTL T1, MDM_YARD T2" ).append("\n"); 
		query.append("WHERE T1.YD_CD=T2.YD_CD" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND T1.PF_SVC_TP_CD = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND T2.DELT_FLG = 'Y'" ).append("\n"); 

	}
}