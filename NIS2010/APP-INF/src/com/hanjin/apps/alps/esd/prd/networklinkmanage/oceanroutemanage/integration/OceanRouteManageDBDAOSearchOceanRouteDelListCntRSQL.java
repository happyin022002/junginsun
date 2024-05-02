/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OceanRouteManageDBDAOSearchOceanRouteDelListCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSearchOceanRouteDelListCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OceanRouteManageDBDAOSearchOceanRouteDelListCntRSQL
	  * </pre>
	  */
	public OceanRouteManageDBDAOSearchOceanRouteDelListCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cnty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stay_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tnk_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cont_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cont_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration ").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOSearchOceanRouteDelListCntRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("COUNT(*) CNT" ).append("\n"); 
		query.append("FROM   PRD_OCN_ROUT A, PRD_PF_TZ_TM B, PRD_PF_TZ_TM C, PRD_PF_TZ_TM D, PRD_PF_TZ_TM E " ).append("\n"); 
		query.append("WHERE  ORG_LOC_CD   LIKE RTRIM( @[pol_port_cd] )||'%'                         " ).append("\n"); 
		query.append("  AND  DEST_LOC_CD  LIKE RTRIM( @[pod_port_cd] )||'%'                          " ).append("\n"); 
		query.append("  AND  TS_IND_CD    =  DECODE( @[ts_type], 'A', TS_IND_CD, @[ts_type])   " ).append("\n"); 
		query.append("  AND  UPD_IND_CD   = 'D'                                        " ).append("\n"); 
		query.append("  AND  N1ST_POL_CD  = B.FM_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N1ST_POD_CD  = B.TO_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N1ST_LANE_CD = B.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("  AND  N2ND_POL_CD  = C.FM_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N2ND_POD_CD  = C.TO_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N2ND_LANE_CD = C.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("  AND  N3RD_POL_CD  = D.FM_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N3RD_POD_CD  = D.TO_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N3RD_LANE_CD = D.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("  AND  N4TH_POL_CD  = E.FM_PORT_CD(+)  " ).append("\n"); 
		query.append("  AND  N4TH_POD_CD  = E.TO_PORT_CD(+) " ).append("\n"); 
		query.append("  AND  N4TH_LANE_CD = E.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("  AND	(NVL(N1ST_STAY_TM_HRS, 0) + NVL(N2ND_STAY_TM_HRS, 0))/24 <= DECODE(TO_NUMBER(NVL(@[stay_time],0)), 0, 50*24, TO_NUMBER(NVL(@[stay_time],0)))" ).append("\n"); 
		query.append("  AND  (DECODE(RTRIM(@[tnk_lane_cd]), NULL, 'ZZZZZ', N1ST_LANE_CD) = NVL(RTRIM(@[tnk_lane_cd]), 'ZZZZZ') OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[tnk_lane_cd]), NULL, 'ZZZZZ', N2ND_LANE_CD) = NVL(RTRIM(@[tnk_lane_cd]), 'ZZZZZ') OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[tnk_lane_cd]), NULL, 'ZZZZZ', N3RD_LANE_CD) = NVL(RTRIM(@[tnk_lane_cd]), 'ZZZZZ') OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[tnk_lane_cd]), NULL, 'ZZZZZ', N4TH_LANE_CD) = NVL(RTRIM(@[tnk_lane_cd]), 'ZZZZZ') )   " ).append("\n"); 
		query.append("  AND  (DECODE(RTRIM(@[ts_port_cd]), NULL, 'ZZZZZ', DECODE(LNK_KNT, 1, 'XXXXX', N1ST_POD_CD))  LIKE NVL(RTRIM(@[ts_port_cd]), 'ZZZZZ')||'%%' OR " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[ts_port_cd]), NULL, 'ZZZZZ', DECODE(LNK_KNT, 2, 'XXXXX', N2ND_POD_CD))  LIKE NVL(RTRIM(@[ts_port_cd]), 'ZZZZZ')||'%%' OR  " ).append("\n"); 
		query.append("        DECODE(RTRIM(@[ts_port_cd]), NULL, 'ZZZZZ', DECODE(LNK_KNT, 3, 'XXXXX', N3RD_POD_CD))  LIKE NVL(RTRIM(@[ts_port_cd]), 'ZZZZZ')||'%%' )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND EXISTS ( SELECT 'X'               " ).append("\n"); 
		query.append("                 FROM MDM_LOCATION L " ).append("\n"); 
		query.append("                WHERE A.ORG_LOC_CD = L.LOC_CD " ).append("\n"); 
		query.append("                  AND L.CONTI_CD LIKE RTRIM(@[pol_cont_cd])||'%'  " ).append("\n"); 
		query.append("                  AND L.CNT_CD LIKE RTRIM(@[pol_cnty_cd])||'%'   " ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("  AND EXISTS ( SELECT 'X'               " ).append("\n"); 
		query.append("                 FROM MDM_LOCATION L " ).append("\n"); 
		query.append("                WHERE A.DEST_LOC_CD = L.LOC_CD " ).append("\n"); 
		query.append("                  AND L.CONTI_CD LIKE RTRIM(@[pod_cont_cd])||'%'  " ).append("\n"); 
		query.append("                  AND L.CNT_CD LIKE RTRIM(@[pod_cnty_cd])||'%'   " ).append("\n"); 
		query.append("             )  " ).append("\n"); 
		query.append("-- order by ord, U_DATE desc" ).append("\n"); 

	}
}