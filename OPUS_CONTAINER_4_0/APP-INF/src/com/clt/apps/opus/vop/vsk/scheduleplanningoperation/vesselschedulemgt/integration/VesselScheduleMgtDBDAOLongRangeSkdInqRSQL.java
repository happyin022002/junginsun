/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOLongRangeSkdInqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.28 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOLongRangeSkdInqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LongRageSkd를 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOLongRangeSkdInqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_skd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOLongRangeSkdInqRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD ," ).append("\n"); 
		query.append("SKD_VOY_NO ," ).append("\n"); 
		query.append("SKD_DIR_CD ," ).append("\n"); 
		query.append("VPS_PORT_CD ," ).append("\n"); 
		query.append("CLPT_IND_SEQ ," ).append("\n"); 
		query.append("CLPT_SEQ ," ).append("\n"); 
		query.append("PORT_SKD_STS_CD ," ).append("\n"); 
		query.append("SKD_CNG_STS_CD ," ).append("\n"); 
		query.append("VPS_RMK ," ).append("\n"); 
		query.append("VSL_SLAN_CD ," ).append("\n"); 
		query.append("@[pf_skd_tp_cd] PF_SKD_TP_CD ," ).append("\n"); 
		query.append("VPS_ETA_DT ," ).append("\n"); 
		query.append("VPS_ETB_DT ," ).append("\n"); 
		query.append("VPS_ETD_DT ," ).append("\n"); 
		query.append("CRE_DT ," ).append("\n"); 
		query.append("CRE_USR_ID ," ).append("\n"); 
		query.append("UPD_DT ," ).append("\n"); 
		query.append("UPD_USR_ID ," ).append("\n"); 
		query.append("PORT_ROTN_SEQ ," ).append("\n"); 
		query.append("ETB_DY_CD ," ).append("\n"); 
		query.append("ETB_TM_HRMNT ," ).append("\n"); 
		query.append("ETD_DY_CD ," ).append("\n"); 
		query.append("ETD_TM_HRMNT ," ).append("\n"); 
		query.append("GRP ," ).append("\n"); 
		query.append("GRP_SEQ ," ).append("\n"); 
		query.append("N_GRP_SEQ," ).append("\n"); 
		query.append("LAST_GRP ," ).append("\n"); 
		query.append("SKD_DIR_SEQ," ).append("\n"); 
		query.append("MAX_NUMBER," ).append("\n"); 
		query.append("MIN_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("/* T61 START */" ).append("\n"); 
		query.append("SELECT T61.* ," ).append("\n"); 
		query.append("MAX(LAST_GRP) OVER(PARTITION BY PF_SKD_TP_CD) MAX_NUMBER ," ).append("\n"); 
		query.append("MIN(VPS_ETB_DT) OVER(PARTITION BY VSL_CD, SKD_VOY_NO) MIN_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("/* T51 START */" ).append("\n"); 
		query.append("SELECT T51.*," ).append("\n"); 
		query.append("DENSE_RANK() OVER (" ).append("\n"); 
		query.append("ORDER BY SKD_DIR_SEQ, GRP, N_GRP_SEQ, VPS_PORT_CD, CLPT_IND_SEQ) LAST_GRP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T42.* ," ).append("\n"); 
		query.append("MIN(GRP_SEQ) OVER (PARTITION BY GRP, VPS_PORT_CD, CLPT_IND_SEQ) N_GRP_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T41.* ," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, GRP" ).append("\n"); 
		query.append("ORDER BY DECODE(PORT_ROTN_SEQ, NULL, 1, 0), NVL(CLPT_SEQ, PORT_ROTN_SEQ)) GRP_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T31.* ," ).append("\n"); 
		query.append("-- NVL(MAX(PORT_ROTN_SEQ) OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD ORDER BY NVL(CLPT_SEQ, PORT_ROTN_SEQ)), 0) GRP" ).append("\n"); 
		query.append("NVL(NVL(PORT_ROTN_SEQ, MAX(PORT_ROTN_SEQ) OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("ORDER BY NVL(CLPT_SEQ, PORT_ROTN_SEQ))), 0) GRP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("/* T21 START */" ).append("\n"); 
		query.append("SELECT T21.VSL_CD," ).append("\n"); 
		query.append("T21.SKD_VOY_NO," ).append("\n"); 
		query.append("NVL(T21.SKD_DIR_CD, T22.SKD_DIR_CD) SKD_DIR_CD," ).append("\n"); 
		query.append("NVL(T21.VPS_PORT_CD, T22.PORT_CD) VPS_PORT_CD," ).append("\n"); 
		query.append("NVL(T21.CLPT_IND_SEQ, T22.CLPT_SEQ) CLPT_IND_SEQ," ).append("\n"); 
		query.append("T21.CLPT_SEQ," ).append("\n"); 
		query.append("T21.PORT_SKD_STS_CD," ).append("\n"); 
		query.append("T21.SKD_CNG_STS_CD," ).append("\n"); 
		query.append("T21.VPS_RMK," ).append("\n"); 
		query.append("NVL(T21.VSL_SLAN_CD, T22.VSL_SLAN_CD) VSL_SLAN_CD," ).append("\n"); 
		query.append("NVL(T21.PF_SKD_TP_CD, T22.PF_SVC_TP_CD) PF_SKD_TP_CD," ).append("\n"); 
		query.append("T21.VPS_ETA_DT," ).append("\n"); 
		query.append("T21.VPS_ETB_DT," ).append("\n"); 
		query.append("T21.VPS_ETD_DT," ).append("\n"); 
		query.append("T21.CRE_DT," ).append("\n"); 
		query.append("T21.CRE_USR_ID," ).append("\n"); 
		query.append("T21.UPD_DT," ).append("\n"); 
		query.append("T21.UPD_USR_ID," ).append("\n"); 
		query.append("T22.PORT_ROTN_SEQ ," ).append("\n"); 
		query.append("T22.ETB_DY_CD," ).append("\n"); 
		query.append("T22.ETB_TM_HRMNT ," ).append("\n"); 
		query.append("T22.ETD_DY_CD," ).append("\n"); 
		query.append("T22.ETD_TM_HRMNT," ).append("\n"); 
		query.append("MIN(PORT_ROTN_SEQ) OVER (PARTITION BY NVL(T21.SKD_DIR_CD, T22.SKD_DIR_CD)) SKD_DIR_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T2.VSL_CD," ).append("\n"); 
		query.append("T2.SKD_VOY_NO," ).append("\n"); 
		query.append("T2.SKD_DIR_CD," ).append("\n"); 
		query.append("T2.VPS_PORT_CD," ).append("\n"); 
		query.append("T2.CLPT_IND_SEQ," ).append("\n"); 
		query.append("T2.CLPT_SEQ," ).append("\n"); 
		query.append("T2.PORT_SKD_STS_CD," ).append("\n"); 
		query.append("T2.SKD_CNG_STS_CD," ).append("\n"); 
		query.append("T1.SKD_RMK AS VPS_RMK," ).append("\n"); 
		query.append("T1.VSL_SLAN_CD," ).append("\n"); 
		query.append("T1.PF_SKD_TP_CD ," ).append("\n"); 
		query.append("T2.VPS_ETA_DT," ).append("\n"); 
		query.append("T2.VPS_ETB_DT," ).append("\n"); 
		query.append("T2.VPS_ETD_DT," ).append("\n"); 
		query.append("T1.CRE_DT," ).append("\n"); 
		query.append("T1.CRE_USR_ID," ).append("\n"); 
		query.append("T1.UPD_DT," ).append("\n"); 
		query.append("T1.UPD_USR_ID" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD T1," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND (T1.VSL_CD," ).append("\n"); 
		query.append("T1.SKD_VOY_NO," ).append("\n"); 
		query.append("T1.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VPS_ETB_DT BETWEEN TO_DATE(@[start_date], 'YYYY-MM-DD') AND TO_DATE(@[end_date], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND SLAN_CD = @[vsl_slan_cd])" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND T1.PF_SKD_TP_CD = @[pf_skd_tp_cd]" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND    T2.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(T2.TURN_PORT_IND_CD, ' ') NOT IN ('D'," ).append("\n"); 
		query.append("'V') ) T21 FULL OUTER JOIN (" ).append("\n"); 
		query.append("SELECT VSL_SLAN_CD, PF_SVC_TP_CD, PORT_CD, SKD_DIR_CD, CLPT_SEQ, PORT_ROTN_SEQ , ETB_DY_CD, SUBSTR(ETB_TM_HRMNT, 1, 2) ETB_TM_HRMNT, ETD_DY_CD, SUBSTR(ETD_TM_HRMNT, 1, 2) ETD_TM_HRMNT" ).append("\n"); 
		query.append("FROM VSK_PF_SKD_DTL" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("AND PF_SVC_TP_CD = @[pf_skd_tp_cd]) T22 ON 1 = 1" ).append("\n"); 
		query.append("AND T21.VSL_SLAN_CD = T22.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND T21.PF_SKD_TP_CD = T22.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND T21.VPS_PORT_CD = T22.PORT_CD" ).append("\n"); 
		query.append("AND T21.SKD_DIR_CD = T22.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T21.CLPT_IND_SEQ = T22.CLPT_SEQ" ).append("\n"); 
		query.append("/* T21 END */" ).append("\n"); 
		query.append(") T31 ) T41 ) T42 ) T51 /* T51 END */" ).append("\n"); 
		query.append(") T61 /* T61 END */" ).append("\n"); 
		query.append(") T71" ).append("\n"); 
		query.append("ORDER BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, LAST_GRP" ).append("\n"); 

	}
}