/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneDBDAOSearchLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.lane.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneDBDAOSearchLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select Lane list
	  * </pre>
	  */
	public LaneDBDAOSearchLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trade_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.lane.integration").append("\n"); 
		query.append("FileName : LaneDBDAOSearchLaneListRSQL").append("\n"); 
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
		query.append("#if(${mode} == 'rev')" ).append("\n"); 
		query.append("SELECT Z.COL1," ).append("\n"); 
		query.append("	Z.COL2," ).append("\n"); 
		query.append("	Z.COL3," ).append("\n"); 
		query.append("	Z.COL4," ).append("\n"); 
		query.append("	Z.COL5" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT ROW_NUMBER() OVER (ORDER BY A.RLANE_CD ASC) no, " ).append("\n"); 
		query.append("		A.RLN_TRADE_CD COL1," ).append("\n"); 
		query.append("		A.RLN_SUB_TRADE_CD COL2," ).append("\n"); 
		query.append("		A.RLANE_CD COL3," ).append("\n"); 
		query.append("		A.RLANE_NM COL4," ).append("\n"); 
		query.append("		A.VSL_TP_CD COL5" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT DISTINCT --ROW_NUMBER() OVER (ORDER BY A.RLANE_CD ASC) no," ).append("\n"); 
		query.append("			A.REP_TRD_CD RLN_TRADE_CD," ).append("\n"); 
		query.append("			C.SUB_TRD_CD RLN_SUB_TRADE_CD," ).append("\n"); 
		query.append("			A.RLANE_CD," ).append("\n"); 
		query.append("			A.RLANE_NM," ).append("\n"); 
		query.append("			B.VSL_TP_CD" ).append("\n"); 
		query.append("		FROM MDM_REV_LANE A, MDM_VSL_SVC_LANE B, MDM_DTL_REV_LANE C" ).append("\n"); 
		query.append("		WHERE 1 = 1" ).append("\n"); 
		query.append("		AND A.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("		AND A.RLANE_CD = C.RLANE_CD(+)" ).append("\n"); 
		query.append("		AND A.REP_TRD_CD = C.TRD_CD(+)" ).append("\n"); 
		query.append("	#if(${lane_cd} != '')" ).append("\n"); 
		query.append("		 	AND A.RLANE_CD LIKE @[lane_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${lane_nm} != '')" ).append("\n"); 
		query.append("			AND A.RLANE_NM LIKE '%' || @[lane_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${svc_tp} != '')" ).append("\n"); 
		query.append("		 	AND B.VSL_SVC_TP_CD = @[svc_tp]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${trade_cd} != '')" ).append("\n"); 
		query.append("		 	AND A.REP_TRD_CD = @[trade_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sub_trade_cd} != '')" ).append("\n"); 
		query.append("		 	AND C.SUB_TRD_CD = @[sub_trade_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			 AND NVL(A.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("			 AND NVL(B.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("		ORDER BY A.RLANE_CD" ).append("\n"); 
		query.append("		)Z                    " ).append("\n"); 
		query.append("	WHERE Z.NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 SELECT VSL_SLAN_CD COL1,      " ).append("\n"); 
		query.append("	        VSL_SLAN_NM COL2,      " ).append("\n"); 
		query.append("	        VSL_SVC_TP_CD COL3,      " ).append("\n"); 
		query.append("	        CO_CD COL4,      " ).append("\n"); 
		query.append("			'' COL5" ).append("\n"); 
		query.append("	 FROM (SELECT ROW_NUMBER() OVER (ORDER BY VSL_SLAN_CD ASC) no,  	" ).append("\n"); 
		query.append("		                VSL_SLAN_CD,              						" ).append("\n"); 
		query.append("		                VSL_SLAN_NM,          							" ).append("\n"); 
		query.append("		                VSL_SVC_TP_CD,               						" ).append("\n"); 
		query.append("		                CO_CD               						" ).append("\n"); 
		query.append("		   FROM MDM_VSL_SVC_LANE        								" ).append("\n"); 
		query.append("		   WHERE 1 = 1 " ).append("\n"); 
		query.append("	#if(${lane_cd} != '')" ).append("\n"); 
		query.append("			 AND VSL_SLAN_CD LIKE @[lane_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${lane_nm} != '')" ).append("\n"); 
		query.append("			 AND VSL_SLAN_NM LIKE '%' || @[lane_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${svc_tp} != '')" ).append("\n"); 
		query.append("			 AND VSL_SVC_TP_CD = @[svc_tp]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${trade_cd} != '')" ).append("\n"); 
		query.append("		 	AND A.REP_TRD_CD = @[trade_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sub_trade_cd} != '')" ).append("\n"); 
		query.append("		 	AND C.SUB_TRD_CD = @[sub_trade_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			AND NVL(DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("         ) A	                     								" ).append("\n"); 
		query.append("	WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}