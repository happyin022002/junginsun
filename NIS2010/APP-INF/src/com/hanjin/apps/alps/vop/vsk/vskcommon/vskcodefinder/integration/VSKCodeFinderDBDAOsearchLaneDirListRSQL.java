/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VSKCodeFinderDBDAOsearchLaneDirListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.19 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOsearchLaneDirListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Lane 리스트를 조회합니다.
	  * 
	  * History
	  * 2011.03.25 진마리아 CHM-201109579-01 Lane Code의 Direction 조회 칼럼 추가 요청
	  * 2011.10.11 진마리아 CHM-201112822-01 Lane Code inquiry내 trade 및 Sub trade, SKD 로 lane Code 정보를 조회 가능하도록 로직 수정
	  * </pre>
	  */
	public VSKCodeFinderDBDAOsearchLaneDirListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOsearchLaneDirListRSQL").append("\n"); 
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
		query.append("SELECT M.VSL_SLAN_CD," ).append("\n"); 
		query.append("       M.RLANE_CD," ).append("\n"); 
		query.append("       M.VSL_SLAN_NM," ).append("\n"); 
		query.append("       M.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("       D.TRD_CD," ).append("\n"); 
		query.append("       D.SUB_TRD_CD," ).append("\n"); 
		query.append("       M.DIR_CD1," ).append("\n"); 
		query.append("       M.DIR_CD2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT S.VSL_SLAN_CD," ).append("\n"); 
		query.append("               R.RLANE_CD," ).append("\n"); 
		query.append("               S.VSL_SLAN_NM," ).append("\n"); 
		query.append("               S.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("               S.DIR_CD1," ).append("\n"); 
		query.append("               S.DIR_CD2" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("               	VSL_SLAN_CD," ).append("\n"); 
		query.append("               	VSL_SLAN_NM," ).append("\n"); 
		query.append("               	VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                   MAX(DECODE (SEQ,'1',VSL_SLAN_DIR_CD,'')) DIR_CD1," ).append("\n"); 
		query.append("                   MAX(DECODE (SEQ,'2',VSL_SLAN_DIR_CD,'')) DIR_CD2" ).append("\n"); 
		query.append("               FROM (" ).append("\n"); 
		query.append("                   SELECT " ).append("\n"); 
		query.append("                   	M.VSL_SLAN_CD," ).append("\n"); 
		query.append("                   	M.VSL_SLAN_NM," ).append("\n"); 
		query.append("                   	M.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                   	D.VSL_SLAN_DIR_CD," ).append("\n"); 
		query.append("                   	D.VSL_SLAN_DIR_SEQ," ).append("\n"); 
		query.append("                   	ROW_NUMBER()  OVER(PARTITION BY D.VSL_SLAN_CD ORDER BY D.VSL_SLAN_DIR_SEQ) SEQ" ).append("\n"); 
		query.append("                   FROM MDM_VSL_SVC_LANE M, MDM_VSL_SVC_LANE_DIR D" ).append("\n"); 
		query.append("                   WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND M.VSL_SLAN_CD = D.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("                  #if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("                   AND M.VSL_SLAN_CD LIKE UPPER(@[vsl_slan_cd]) ||'%'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  #if (${vsl_slan_nm} != '') " ).append("\n"); 
		query.append("                   AND UPPER(M.VSL_SLAN_NM) LIKE '%' || UPPER(@[vsl_slan_nm]) || '%'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  #if (${fdr_div_cd} == 'TRUNK')" ).append("\n"); 
		query.append("                   AND M.FDR_DIV_CD != 'O'" ).append("\n"); 
		query.append("                  #elseif (${fdr_div_cd} != '')" ).append("\n"); 
		query.append("                   AND M.FDR_DIV_CD = DECODE(@[fdr_div_cd], 'A', FDR_DIV_CD, @[fdr_div_cd])" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  #if (${vsl_svc_tp_cd} != '')" ).append("\n"); 
		query.append("                   AND M.VSL_SVC_TP_CD = @[vsl_svc_tp_cd]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  #if (${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("                   AND M.VSL_SLAN_CD IN (" ).append("\n"); 
		query.append("                                          SELECT T2.SLAN_CD" ).append("\n"); 
		query.append("                                          FROM (" ).append("\n"); 
		query.append("                                                 SELECT VSL_CD," ).append("\n"); 
		query.append("                                                        SKD_VOY_NO," ).append("\n"); 
		query.append("                                                        SKD_DIR_CD," ).append("\n"); 
		query.append("                                                        MIN(VPS_ETA_DT) MIN_DT," ).append("\n"); 
		query.append("                                                        MAX(VPS_ETD_DT) MAX_DT" ).append("\n"); 
		query.append("                                                 FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                 WHERE 1=1" ).append("\n"); 
		query.append("                                                 AND NVL(SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("                                                 GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                                               ) T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("                                          WHERE 1=1" ).append("\n"); 
		query.append("                                          AND (TO_DATE(@[fm_dt], 'YYYYMMDD') BETWEEN T1.MIN_DT AND T1.MAX_DT+0.99999 OR" ).append("\n"); 
		query.append("                                               TO_DATE(@[to_dt], 'YYYYMMDD') BETWEEN T1.MIN_DT AND T1.MAX_DT+0.99999)" ).append("\n"); 
		query.append("                                          AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("                                          AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                          AND T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                   AND M.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("                   AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               GROUP BY	VSL_SLAN_CD," ).append("\n"); 
		query.append("                       	VSL_SLAN_NM," ).append("\n"); 
		query.append("                       	VSL_SVC_TP_CD" ).append("\n"); 
		query.append("               ORDER BY VSL_SLAN_CD" ).append("\n"); 
		query.append("             ) S, MDM_REV_LANE R" ).append("\n"); 
		query.append("        WHERE S.VSL_SLAN_CD = R.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("        AND R.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("     ) M, MDM_DTL_REV_LANE D" ).append("\n"); 
		query.append("WHERE M.RLANE_CD = D.RLANE_CD(+)" ).append("\n"); 
		query.append("AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND NVL(D.SUB_TRD_CD,'X')<>'IP'" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append(" AND D.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '') " ).append("\n"); 
		query.append(" AND D.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY M.VSL_SLAN_CD," ).append("\n"); 
		query.append("       M.RLANE_CD," ).append("\n"); 
		query.append("       M.VSL_SLAN_NM," ).append("\n"); 
		query.append("       M.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("       D.TRD_CD," ).append("\n"); 
		query.append("       D.SUB_TRD_CD," ).append("\n"); 
		query.append("       M.DIR_CD1," ).append("\n"); 
		query.append("       M.DIR_CD2" ).append("\n"); 
		query.append("ORDER BY M.VSL_SLAN_CD, M.RLANE_CD, D.TRD_CD, D.SUB_TRD_CD" ).append("\n"); 

	}
}