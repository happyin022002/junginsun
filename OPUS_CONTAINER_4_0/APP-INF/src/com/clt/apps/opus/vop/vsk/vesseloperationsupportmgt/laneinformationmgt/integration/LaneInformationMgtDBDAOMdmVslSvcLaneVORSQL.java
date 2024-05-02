/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneInformationMgtDBDAOMdmVslSvcLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.09.29 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneInformationMgtDBDAOMdmVslSvcLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Group
	  * </pre>
	  */
	public LaneInformationMgtDBDAOMdmVslSvcLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_flet_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOMdmVslSvcLaneVORSQL").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD," ).append("\n"); 
		query.append("VSL_SLAN_NM," ).append("\n"); 
		query.append("VSKD_FLET_GRP_CD," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT," ).append("\n"); 
		query.append("VSL_SVC_TP_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("#if (${vskd_flet_grp_cd} != '')" ).append("\n"); 
		query.append("WHERE	VSKD_FLET_GRP_CD = @[vskd_flet_grp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE	VSKD_FLET_GRP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} != '')" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} == '1')" ).append("\n"); 
		query.append("AND 	NVL(VSL_SVC_TP_CD, '-')  != 'O'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 	VSL_SVC_TP_CD  = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

	}
}