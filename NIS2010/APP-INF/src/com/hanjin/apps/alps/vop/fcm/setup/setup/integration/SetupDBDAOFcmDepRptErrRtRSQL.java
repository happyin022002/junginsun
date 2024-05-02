/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SetupDBDAOFcmDepRptErrRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SetupDBDAOFcmDepRptErrRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERROR RATE SETTING
	  * </pre>
	  */
	public SetupDBDAOFcmDepRptErrRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.setup.setup.integration").append("\n"); 
		query.append("FileName : SetupDBDAOFcmDepRptErrRtRSQL").append("\n"); 
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
		query.append("WITH VSL_INFO AS (" ).append("\n"); 
		query.append("SELECT VSL_CD, VSL_ENG_NM , CNTR_VSL_CLSS_CAPA, MN_ENG_MKR_NM, " ).append("\n"); 
		query.append("       DECODE(MN_ENG_HOR_PWR_UT_CD,'KW',MN_ENG_BHP_PWR,ROUND(MN_ENG_BHP_PWR*1.35941,2)) AS MN_ENG_BHP_PWR," ).append("\n"); 
		query.append("       DECODE(MN_ENG_HOR_PWR_UT_CD,'KW',ROUND(MN_ENG_BHP_PWR*0.73561,2), MN_ENG_BHP_PWR) AS MN_ENG_RPM_PWR," ).append("\n"); 
		query.append("       MN_ENG_TP_DESC, TBCGR_RPM_PWR" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T1.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_HOR_PWR_UT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T2.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T2.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.MN_ENG_RPM_PWR AS TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_HOR_PWR_UT_CD" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD     = T2.VSL_CD(+)" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD = 'T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD     = 'SML'" ).append("\n"); 
		query.append(")T1" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    T1.VSL_CD" ).append("\n"); 
		query.append("    ,NVL((" ).append("\n"); 
		query.append("    SELECT A.OWNR_NM" ).append("\n"); 
		query.append("    FROM   FMS_OWNER A" ).append("\n"); 
		query.append("         , MDM_VENDOR B" ).append("\n"); 
		query.append("    WHERE  A.OWNR_SEQ = B.FLET_MGMT_OWNR_VNDR_SEQ" ).append("\n"); 
		query.append("    AND T1.VNDR_SEQ=B.VNDR_SEQ(+)), (" ).append("\n"); 
		query.append("    SELECT A.OWNR_NM" ).append("\n"); 
		query.append("    FROM   FMS_OWNER A" ).append("\n"); 
		query.append("         , MDM_CUSTOMER B" ).append("\n"); 
		query.append("    WHERE  A.OWNR_SEQ  = B.FLET_MGMT_OWNR_CUST_SEQ" ).append("\n"); 
		query.append("    AND T1.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND T1.CUST_SEQ    = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("    )) OWNR_NM" ).append("\n"); 
		query.append("    ,TO_CHAR(TO_DATE(VSL_BLD_DT, 'YYYYMMDD'), 'YYYY-MM-DD') VSL_BLD_DT" ).append("\n"); 
		query.append("    ,VSL_DZND_CAPA" ).append("\n"); 
		query.append("    ,BSE_14TON_VSL_CAPA" ).append("\n"); 
		query.append("    ,TO_CHAR(EFF_DT, 'YYYY-MM-DD') FM_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(EXP_DT, 'YYYY-MM-DD') TO_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(PARTITION BY VSL_CD ORDER BY EXP_DT DESC) SEQ" ).append("\n"); 
		query.append("        ,T1.*" ).append("\n"); 
		query.append("        FROM FMS_CONTRACT T1" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.FLET_CTRT_TP_CD!='TO'" ).append("\n"); 
		query.append("        AND T1.EXP_DT > TO_DATE('2011-08-01', 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    ) T1" ).append("\n"); 
		query.append("    WHERE T1.SEQ=1" ).append("\n"); 
		query.append(")T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T1.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_HOR_PWR_UT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T2.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T2.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_RPM_PWR AS TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_HOR_PWR_UT_CD" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("    AND T2.VSL_CD NOT IN (SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD!='TO' AND EXP_DT > TO_DATE('2011-08-01', 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD='T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append(")T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.CNTR_VSL_CLSS_CAPA   " ).append("\n"); 
		query.append("    ,T1.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_HOR_PWR_UT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T2.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T2.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.MN_ENG_RPM_PWR AS TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_HOR_PWR_UT_CD" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD --NOT OUTER JOIN" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD='T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD<>'SML'" ).append("\n"); 
		query.append(")T1" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    T1.VSL_CD" ).append("\n"); 
		query.append("    ,NVL((" ).append("\n"); 
		query.append("    SELECT A.OWNR_NM" ).append("\n"); 
		query.append("    FROM   FMS_OWNER A" ).append("\n"); 
		query.append("         , MDM_VENDOR B" ).append("\n"); 
		query.append("    WHERE  A.OWNR_SEQ = B.FLET_MGMT_OWNR_VNDR_SEQ" ).append("\n"); 
		query.append("    AND T1.VNDR_SEQ=B.VNDR_SEQ(+)), (" ).append("\n"); 
		query.append("    SELECT A.OWNR_NM" ).append("\n"); 
		query.append("    FROM   FMS_OWNER A" ).append("\n"); 
		query.append("         , MDM_CUSTOMER B" ).append("\n"); 
		query.append("    WHERE  A.OWNR_SEQ = B.FLET_MGMT_OWNR_CUST_SEQ" ).append("\n"); 
		query.append("    AND T1.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND T1.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("    )) OWNR_NM" ).append("\n"); 
		query.append("    ,TO_CHAR(TO_DATE(VSL_BLD_DT, 'YYYYMMDD'), 'YYYY-MM-DD') VSL_BLD_DT" ).append("\n"); 
		query.append("    ,VSL_DZND_CAPA" ).append("\n"); 
		query.append("    ,BSE_14TON_VSL_CAPA" ).append("\n"); 
		query.append("    ,TO_CHAR(EFF_DT, 'YYYY-MM-DD') FM_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(EXP_DT, 'YYYY-MM-DD') TO_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(PARTITION BY VSL_CD ORDER BY EXP_DT DESC) SEQ" ).append("\n"); 
		query.append("        ,T1.*" ).append("\n"); 
		query.append("        FROM FMS_CONTRACT T1" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.FLET_CTRT_TP_CD!='TO'" ).append("\n"); 
		query.append("        AND T1.EXP_DT > TO_DATE('2011-08-01', 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    ) T1" ).append("\n"); 
		query.append("    WHERE T1.SEQ=1" ).append("\n"); 
		query.append(")T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T1.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_HOR_PWR_UT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T2.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T2.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.MN_ENG_RPM_PWR AS TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_HOR_PWR_UT_CD" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("    AND T2.VSL_CD NOT IN (SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD!='TO' AND EXP_DT > TO_DATE('2011-08-01', 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG   ='N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD ='T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD<>'SML'" ).append("\n"); 
		query.append("    ORDER BY T1.VSL_CD" ).append("\n"); 
		query.append(")T1" ).append("\n"); 
		query.append("WHERE 1=1 )  ) " ).append("\n"); 
		query.append("SELECT A.VSL_CD,             A.VSL_ENG_NM,    A.CNTR_VSL_CLSS_CAPA,    A.MN_ENG_MKR_NM,            A.MN_ENG_RPM_PWR,          A.MN_ENG_BHP_PWR, A.MN_ENG_TP_DESC," ).append("\n"); 
		query.append("       B.NVGT_ML_DIST_RT,    B.ENG_ML_DIST_RT,B.MNVR_IN_ML_DIST_RT,    B.MNVR_OUT_ML_DIST_RT,      B.AVG_SPD_RT,              B.AVG_RPM_PWR_RT," ).append("\n"); 
		query.append("       B.PRLR_PCH_RT,        B.SAIL_TM_RT,    B.ARR_FOIL_RT,           B.ARR_LOW_SULP_FOIL_RT,     B.ARR_DOIL_RT,             B.ARR_LOW_SULP_DOIL_RT," ).append("\n"); 
		query.append("       B.DEP_FOIL_RT,        B.DEP_LOW_SULP_FOIL_RT, B.DEP_DOIL_RT,    B.DEP_LOW_SULP_DOIL_RT,     B.SEA_STMNG_MN_ENG_RT,     B.PORT_TTL_RT, " ).append("\n"); 
		query.append("       B.PORT_TTL_HR_RT_RT,  B.SB_ENG_DT_RT,  B.PLT_IN_DT_RT,          B.BFR_BRTH_ANK_DRP_DT_RT,   B.BFR_BRTH_ANK_OFF_DT_RT,  B.VPS_ETB_DT_RT,                 " ).append("\n"); 
		query.append("       B.CGO_WRK_ST_DT_RT,   B.CGO_WRK_END_DT_RT, B.VPS_ETD_DT_RT,     B.AFT_UNBRTH_ANK_DRP_DT_RT, B.AFT_UNBRTH_ANK_OFF_DT_RT,B.PLT_OUT_DT_RT," ).append("\n"); 
		query.append("       B.RUP_DT_RT,          B.FCNTR_OBRD_TEU_RT, B.MCNTR_OBRD_TEU_RT, B.TTL_CNTR_OBRD_TEU_RT,B.DEP_CGO_RT, B.RF_CNTR_DCHG_KNT_RT, A.TBCGR_RPM_PWR," ).append("\n"); 
		query.append("       B.RF_CNTR_LOD_KNT_RT, B.RF_CNTR_OBRD_KNT_RT" ).append("\n"); 
		query.append(" FROM VSL_INFO A, FCM_DEP_RPT_ERR_RT_SET B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CNTR_VSL_CLSS_CAPA DESC, A.VSL_CD" ).append("\n"); 

	}
}