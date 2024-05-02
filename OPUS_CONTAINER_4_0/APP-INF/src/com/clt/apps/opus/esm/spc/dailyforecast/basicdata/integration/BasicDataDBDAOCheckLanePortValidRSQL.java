/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOCheckLanePortValidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOCheckLanePortValidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane, Bound 에 등록 가능한 Port인지 체크합니다.
	  * </pre>
	  */
	public BasicDataDBDAOCheckLanePortValidRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCheckLanePortValidRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD    ," ).append("\n"); 
		query.append("       SUB_TRD_CD" ).append("\n"); 
		query.append("  FROM MDM_DTL_REV_LANE MDR" ).append("\n"); 
		query.append(" WHERE MDR.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("   AND MDR.FM_CONTI_CD     = ( SELECT L.CONTI_CD" ).append("\n"); 
		query.append("                                 FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                WHERE L.LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("   AND MDR.VSL_SLAN_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("   AND MDR.IOC_CD   =  DECODE(@[ioc_ts_cd],'T/S',DECODE(SUBSTR(@[rlane_cd],1,3),'IMU','O','I'),SUBSTR(@[ioc_ts_cd],0,1))" ).append("\n"); 
		query.append("   AND MDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#if (${tab_index} == 0) " ).append("\n"); 
		query.append("   AND EXISTS" ).append("\n"); 
		query.append("       (SELECT T1.PORT_CD " ).append("\n"); 
		query.append("         FROM VSK_PF_SKD_DTL T1 " ).append("\n"); 
		query.append("            , VSK_PF_SKD T2 " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND T1.PF_SVC_TP_CD = T2.PF_SVC_TP_CD " ).append("\n"); 
		query.append("              AND T1.VSL_SLAN_CD = T2.VSL_SLAN_CD " ).append("\n"); 
		query.append("              AND T2.VSL_SLAN_CD = SUBSTR(@[rlane_cd], 1, 3) " ).append("\n"); 
		query.append("              AND T1.SKD_DIR_CD = @[dir_cd] " ).append("\n"); 
		query.append("              AND T1.PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tab_index} == 1) " ).append("\n"); 
		query.append("   AND EXISTS" ).append("\n"); 
		query.append("       (SELECT T1.VPS_PORT_CD " ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD T1            " ).append("\n"); 
		query.append("        WHERE 1=1        " ).append("\n"); 
		query.append("              AND T1.SLAN_CD = SUBSTR(@[rlane_cd], 1, 3)               " ).append("\n"); 
		query.append("              AND T1.VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("              AND T1.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("              AND T1.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("              AND T1.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("              AND T1.VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}