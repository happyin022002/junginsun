/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchPortInfoListRSQL.java
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

public class VSKCodeFinderDBDAOSearchPortInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM에서 Port Code Inquiry 에서의 Port 정보를 조회합니다.
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchPortInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_lat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_lon_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vop_port_mntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_lat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_lat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_lat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_loc_lon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_lon_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_lon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchPortInfoListRSQL").append("\n"); 
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
		query.append("T1.LOC_CD" ).append("\n"); 
		query.append(",T1.SCC_CD" ).append("\n"); 
		query.append(",T1.LOC_NM" ).append("\n"); 
		query.append(",T1.RGN_CD" ).append("\n"); 
		query.append(",T1.CNT_CD" ).append("\n"); 
		query.append(",T1.STE_CD" ).append("\n"); 
		query.append(",T1.CONTI_CD" ).append("\n"); 
		query.append(",(SELECT CONTI_NM FROM MDM_CONTINENT WHERE CONTI_CD = T1.CONTI_CD) CONTI_NM" ).append("\n"); 
		query.append(",T1.SCONTI_CD" ).append("\n"); 
		query.append(",(SELECT SCONTI_NM FROM MDM_SUBCONTINENT WHERE SCONTI_CD = T1.SCONTI_CD) SCONTI_NM" ).append("\n"); 
		query.append(",T1.LOC_LAT" ).append("\n"); 
		query.append(",T1.LAT_UT_CD" ).append("\n"); 
		query.append(",T1.LOC_LON" ).append("\n"); 
		query.append(",T1.LON_UT_CD" ).append("\n"); 
		query.append(",T1.PORT_INLND_CD" ).append("\n"); 
		query.append(",T1.LOC_CHR_CD" ).append("\n"); 
		query.append(",T1.BLK_PORT_FLG" ).append("\n"); 
		query.append(",T1.HUB_LOC_CD" ).append("\n"); 
		query.append(",T1.SLS_OFC_CD" ).append("\n"); 
		query.append(",T1.LOC_GRD_NO" ).append("\n"); 
		query.append(",T1.GMT_HRS" ).append("\n"); 
		query.append(",T1.GMT_HRS/60 AS ZD" ).append("\n"); 
		query.append(",T1.BKG_BL_PFX_CD" ).append("\n"); 
		query.append(",T1.CALL_PORT_FLG" ).append("\n"); 
		query.append(",T1.LOC_AMS_PORT_CD" ).append("\n"); 
		query.append(",T1.FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append(",T1.SEN_EQ_OFC_CD" ).append("\n"); 
		query.append(",T1.EQ_RTN_YD_CD" ).append("\n"); 
		query.append(",T1.UN_LOC_IND_CD" ).append("\n"); 
		query.append(",T1.UN_LOC_CD" ).append("\n"); 
		query.append(",T1.CML_ZN_FLG" ).append("\n"); 
		query.append(",T1.CSTMS_CD" ).append("\n"); 
		query.append(",T1.LOC_TP_CD" ).append("\n"); 
		query.append(",T1.BFR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.BFR_EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.BFR_SLS_OFC_CD" ).append("\n"); 
		query.append(",T1.BFR_OFC_CNG_DT" ).append("\n"); 
		query.append(",T1.REP_ZN_CD" ).append("\n"); 
		query.append(",T1.ZIP_CD" ).append("\n"); 
		query.append(",T1.EXPT_LGS_OFC_CD" ).append("\n"); 
		query.append(",T1.EXPT_CUST_SVC_OFC_CD" ).append("\n"); 
		query.append(",T1.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append(",T1.VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.VOP_PORT_MNTR_FLG" ).append("\n"); 
		query.append(",T1.VOP_LOC_URL" ).append("\n"); 
		query.append(",T1.VOP_PORT_FLG" ).append("\n"); 
		query.append(",T2.CNT_NM" ).append("\n"); 
		query.append(",T2.CURR_CD" ).append("\n"); 
		query.append(",T2.FRGN_VAT_FLG" ).append("\n"); 
		query.append(",T2.ZN_DIV_BSEL_CD" ).append("\n"); 
		query.append(",T2.BKG_ADDR_ORD_CD" ).append("\n"); 
		query.append(",T2.BKG_ADDR_ORD_DESC" ).append("\n"); 
		query.append(",(CASE WHEN T1.CNT_CD IN (SELECT DISTINCT ATTR_CTNT1" ).append("\n"); 
		query.append("                         FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                         WHERE CNT_CD = 'EU'" ).append("\n"); 
		query.append("                         AND CSTMS_DIV_ID ='EU_MEMBER_CNT')" ).append("\n"); 
		query.append("      THEN 'Y'" ).append("\n"); 
		query.append(" ELSE 'N'" ).append("\n"); 
		query.append(" END) AS EU_PORT" ).append("\n"); 
		query.append("FROM MDM_LOCATION T1, MDM_COUNTRY T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.CNT_CD=T2.CNT_CD" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("AND T1.CNT_CD LIKE upper(@[cnt_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND T1.LOC_CD LIKE upper(@[loc_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_nm} != '') " ).append("\n"); 
		query.append("AND T1.LOC_NM LIKE '%' || upper(@[loc_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${conti_cd} != '') " ).append("\n"); 
		query.append("AND T1.CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sconti_cd} != '') " ).append("\n"); 
		query.append("AND T1.SCONTI_CD = @[sconti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL') " ).append("\n"); 
		query.append("AND T1.VSKD_PORT_RHQ_CD = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vop_port_mntr_flg} != '')" ).append("\n"); 
		query.append("AND T1.VOP_PORT_MNTR_FLG=@[vop_port_mntr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_loc_lat} != '' && ${fm_lat_ut_cd} != '' && ${to_loc_lat} != '' && ${to_lat_ut_cd} != '')" ).append("\n"); 
		query.append(" #if (${fm_lat_ut_cd} == ${to_lat_ut_cd})" ).append("\n"); 
		query.append(" AND LOC_LAT BETWEEN @[fm_loc_lat] AND @[to_loc_lat]" ).append("\n"); 
		query.append(" AND LAT_UT_CD = @[fm_lat_ut_cd]" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append(" AND ((LOC_LAT < @[fm_loc_lat] AND LAT_UT_CD = @[fm_lat_ut_cd])" ).append("\n"); 
		query.append("   OR (LOC_LAT < @[to_loc_lat] AND LAT_UT_CD = @[to_lat_ut_cd]))" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_loc_lon} != '' && ${fm_lon_ut_cd} != '' && ${to_loc_lon} != '' && ${to_lon_ut_cd} != '')" ).append("\n"); 
		query.append(" #if (${fm_lon_ut_cd} == ${to_lon_ut_cd})" ).append("\n"); 
		query.append(" AND LOC_LON BETWEEN @[fm_loc_lon] AND @[to_loc_lon]" ).append("\n"); 
		query.append(" AND LON_UT_CD = @[fm_lon_ut_cd]" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append(" AND ((LOC_LON <= @[fm_loc_lon] AND LON_UT_CD = @[fm_lon_ut_cd])" ).append("\n"); 
		query.append("   OR (LOC_LON <= @[to_loc_lon] AND LON_UT_CD = @[to_lon_ut_cd]))" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eu_port} == 'Y') " ).append("\n"); 
		query.append("AND T1.CNT_CD IN (SELECT DISTINCT ATTR_CTNT1" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                  WHERE CNT_CD = 'EU'" ).append("\n"); 
		query.append("                  AND CSTMS_DIV_ID ='EU_MEMBER_CNT')" ).append("\n"); 
		query.append("#elseif (${eu_port} == 'N')" ).append("\n"); 
		query.append("AND T1.CNT_CD NOT IN (SELECT DISTINCT ATTR_CTNT1" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                      WHERE CNT_CD = 'EU'" ).append("\n"); 
		query.append("                      AND CSTMS_DIV_ID ='EU_MEMBER_CNT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("AND T1.LOC_CD IN (SELECT DISTINCT VPS_PORT_CD" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append(" #if (${vsl_svc_tp_cd} == 'T')" ).append("\n"); 
		query.append("                  AND SLAN_CD IN (SELECT VSL_SLAN_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SVC_TP_CD<>'O')" ).append("\n"); 
		query.append(" #elseif (${vsl_svc_tp_cd} == 'F')" ).append("\n"); 
		query.append("                  AND SLAN_CD IN (SELECT VSL_SLAN_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SVC_TP_CD='O')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("                  AND (" ).append("\n"); 
		query.append("                       (VPS_ETA_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999)" ).append("\n"); 
		query.append("                     OR (VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999)" ).append("\n"); 
		query.append("                     OR (TO_DATE(@[fm_dt],'YYYY-MM-DD') BETWEEN VPS_ETA_DT AND VPS_ETD_DT)" ).append("\n"); 
		query.append("                     OR (TO_DATE(@[to_dt],'YYYY-MM-DD') BETWEEN VPS_ETA_DT AND VPS_ETD_DT)" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                  AND NVL(SKD_CNG_STS_CD,'X')<>'S'" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("AND T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY LOC_CD" ).append("\n"); 

	}
}