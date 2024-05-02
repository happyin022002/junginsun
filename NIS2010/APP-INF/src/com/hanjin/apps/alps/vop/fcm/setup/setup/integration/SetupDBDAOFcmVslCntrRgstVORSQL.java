/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SetupDBDAOFcmVslCntrRgstVORSQL.java
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

public class SetupDBDAOFcmVslCntrRgstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Registration 정보를 조회한다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * 2012.04.19 진마리아 CHM-201217192-01 Vessel Registration내 선박 추가 로직 변경 요청건
	  * 2013.01.02 진마리아 CHM-201322241-01 FCM 사용 하지않는 소스 및 화면 정리
	  * </pre>
	  */
	public SetupDBDAOFcmVslCntrRgstVORSQL(){
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
		query.append("FileName : SetupDBDAOFcmVslCntrRgstVORSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T2.OWNR_NM" ).append("\n"); 
		query.append("    ,T2.VSL_BLD_DT" ).append("\n"); 
		query.append("    ,T2.VSL_DZND_CAPA" ).append("\n"); 
		query.append("    ,T2.BSE_14TON_VSL_CAPA" ).append("\n"); 
		query.append("    ,T2.FM_DT" ).append("\n"); 
		query.append("    ,T2.TO_DT" ).append("\n"); 
		query.append("    ,T1.DWT_WGT" ).append("\n"); 
		query.append("    ,T1.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.LLOYD_NO" ).append("\n"); 
		query.append("    ,T1.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T1.VSL_CLSS_SUB_CD     " ).append("\n"); 
		query.append("    ,T1.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.TBCGR_NO" ).append("\n"); 
		query.append("    ,T1.TBCGR_MKR_NM" ).append("\n"); 
		query.append("    ,T1.TBCGR_TP_DESC" ).append("\n"); 
		query.append("    ,T1.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.TBCGR_COFF_FLG" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("    ,T1.FOIL_ADTV_CD" ).append("\n"); 
		query.append("    ,T1.HL_PNT_CD" ).append("\n"); 
		query.append("    ,T1.GNR_CSM_WGT" ).append("\n"); 
		query.append("    ,T1.FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("    ,T1.FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T1.FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T1.OP_MAX_SPD" ).append("\n"); 
		query.append("    ,T1.OP_MIN_SPD" ).append("\n"); 
		query.append("    ,T1.OP_GNR_SPD" ).append("\n"); 
		query.append("    ,T1.TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("    ,T1.MNVR_CSM_WGT" ).append("\n"); 
		query.append("    ,T1.CRE_DT" ).append("\n"); 
		query.append("    ,T1.CRE_USR_ID" ).append("\n"); 
		query.append("    ,T1.UPD_DT" ).append("\n"); 
		query.append("    ,T1.UPD_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.DWT_WGT" ).append("\n"); 
		query.append("    ,T1.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.LLOYD_NO" ).append("\n"); 
		query.append("    ,T1.CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T2.VSL_CLSS_SUB_CD" ).append("\n"); 
		query.append("    ,T2.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T2.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T2.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("    ,T2.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T2.TBCGR_NO" ).append("\n"); 
		query.append("    ,T2.TBCGR_MKR_NM" ).append("\n"); 
		query.append("    ,T2.TBCGR_TP_DESC" ).append("\n"); 
		query.append("    ,T2.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T2.TBCGR_COFF_FLG" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("    ,T2.FOIL_ADTV_CD" ).append("\n"); 
		query.append("    ,T2.HL_PNT_CD" ).append("\n"); 
		query.append("    ,T2.GNR_CSM_WGT" ).append("\n"); 
		query.append("    ,T2.FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("    ,T2.FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T2.FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T2.OP_MAX_SPD" ).append("\n"); 
		query.append("    ,T2.OP_MIN_SPD" ).append("\n"); 
		query.append("    ,T2.OP_GNR_SPD" ).append("\n"); 
		query.append("    ,T2.TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("    ,T2.MNVR_CSM_WGT" ).append("\n"); 
		query.append("    ,T2.CRE_DT" ).append("\n"); 
		query.append("    ,T2.CRE_USR_ID" ).append("\n"); 
		query.append("    ,T2.UPD_DT" ).append("\n"); 
		query.append("    ,T2.UPD_USR_ID" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD(+)" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD='T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append("    ORDER BY T1.VSL_CD" ).append("\n"); 
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
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND T1.VSL_CD LIKE '%'||@[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,'' OWNR_NM" ).append("\n"); 
		query.append("    ,'' VSL_BLD_DT" ).append("\n"); 
		query.append("    ,TO_NUMBER('') VSL_DZND_CAPA" ).append("\n"); 
		query.append("    ,TO_NUMBER('') BSE_14TON_VSL_CAPA" ).append("\n"); 
		query.append("    ,'' FM_DT" ).append("\n"); 
		query.append("    ,'' TO_DT" ).append("\n"); 
		query.append("    ,T1.DWT_WGT" ).append("\n"); 
		query.append("    ,T1.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.LLOYD_NO" ).append("\n"); 
		query.append("    ,T1.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T1.VSL_CLSS_SUB_CD     " ).append("\n"); 
		query.append("    ,T1.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.TBCGR_NO" ).append("\n"); 
		query.append("    ,T1.TBCGR_MKR_NM" ).append("\n"); 
		query.append("    ,T1.TBCGR_TP_DESC" ).append("\n"); 
		query.append("    ,T1.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.TBCGR_COFF_FLG" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("    ,T1.FOIL_ADTV_CD" ).append("\n"); 
		query.append("    ,T1.HL_PNT_CD" ).append("\n"); 
		query.append("    ,T1.GNR_CSM_WGT" ).append("\n"); 
		query.append("    ,T1.FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("    ,T1.FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T1.FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T1.OP_MAX_SPD" ).append("\n"); 
		query.append("    ,T1.OP_MIN_SPD" ).append("\n"); 
		query.append("    ,T1.OP_GNR_SPD" ).append("\n"); 
		query.append("    ,T1.TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("    ,T1.MNVR_CSM_WGT" ).append("\n"); 
		query.append("    ,T1.CRE_DT" ).append("\n"); 
		query.append("    ,T1.CRE_USR_ID" ).append("\n"); 
		query.append("    ,T1.UPD_DT" ).append("\n"); 
		query.append("    ,T1.UPD_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.DWT_WGT" ).append("\n"); 
		query.append("    ,T1.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.LLOYD_NO" ).append("\n"); 
		query.append("    ,T1.CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T2.VSL_CLSS_SUB_CD" ).append("\n"); 
		query.append("    ,T2.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T2.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T2.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("    ,T2.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T2.TBCGR_NO" ).append("\n"); 
		query.append("    ,T2.TBCGR_MKR_NM" ).append("\n"); 
		query.append("    ,T2.TBCGR_TP_DESC" ).append("\n"); 
		query.append("    ,T2.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T2.TBCGR_COFF_FLG" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("    ,T2.FOIL_ADTV_CD" ).append("\n"); 
		query.append("    ,T2.HL_PNT_CD" ).append("\n"); 
		query.append("    ,T2.GNR_CSM_WGT" ).append("\n"); 
		query.append("    ,T2.FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("    ,T2.FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T2.FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T2.OP_MAX_SPD" ).append("\n"); 
		query.append("    ,T2.OP_MIN_SPD" ).append("\n"); 
		query.append("    ,T2.OP_GNR_SPD" ).append("\n"); 
		query.append("    ,T2.TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("    ,T2.MNVR_CSM_WGT" ).append("\n"); 
		query.append("    ,T2.CRE_DT" ).append("\n"); 
		query.append("    ,T2.CRE_USR_ID" ).append("\n"); 
		query.append("    ,T2.UPD_DT" ).append("\n"); 
		query.append("    ,T2.UPD_USR_ID" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("    AND T2.VSL_CD NOT IN (SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD!='TO' AND EXP_DT > TO_DATE('2011-08-01', 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD='T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append("    ORDER BY T1.VSL_CD" ).append("\n"); 
		query.append(")T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND T1.VSL_CD LIKE '%'||@[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--FOR CRR CD IS NOT SML" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T2.OWNR_NM" ).append("\n"); 
		query.append("    ,T2.VSL_BLD_DT" ).append("\n"); 
		query.append("    ,T2.VSL_DZND_CAPA" ).append("\n"); 
		query.append("    ,T2.BSE_14TON_VSL_CAPA" ).append("\n"); 
		query.append("    ,T2.FM_DT" ).append("\n"); 
		query.append("    ,T2.TO_DT" ).append("\n"); 
		query.append("    ,T1.DWT_WGT" ).append("\n"); 
		query.append("    ,T1.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.LLOYD_NO" ).append("\n"); 
		query.append("    ,T1.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T1.VSL_CLSS_SUB_CD     " ).append("\n"); 
		query.append("    ,T1.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.TBCGR_NO" ).append("\n"); 
		query.append("    ,T1.TBCGR_MKR_NM" ).append("\n"); 
		query.append("    ,T1.TBCGR_TP_DESC" ).append("\n"); 
		query.append("    ,T1.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.TBCGR_COFF_FLG" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("    ,T1.FOIL_ADTV_CD" ).append("\n"); 
		query.append("    ,T1.HL_PNT_CD" ).append("\n"); 
		query.append("    ,T1.GNR_CSM_WGT" ).append("\n"); 
		query.append("    ,T1.FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("    ,T1.FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T1.FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T1.OP_MAX_SPD" ).append("\n"); 
		query.append("    ,T1.OP_MIN_SPD" ).append("\n"); 
		query.append("    ,T1.OP_GNR_SPD" ).append("\n"); 
		query.append("    ,T1.TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("    ,T1.MNVR_CSM_WGT" ).append("\n"); 
		query.append("    ,T1.CRE_DT" ).append("\n"); 
		query.append("    ,T1.CRE_USR_ID" ).append("\n"); 
		query.append("    ,T1.UPD_DT" ).append("\n"); 
		query.append("    ,T1.UPD_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.DWT_WGT" ).append("\n"); 
		query.append("    ,T1.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.LLOYD_NO" ).append("\n"); 
		query.append("    ,T1.CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T2.VSL_CLSS_SUB_CD" ).append("\n"); 
		query.append("    ,T2.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T2.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T2.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("    ,T2.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T2.TBCGR_NO" ).append("\n"); 
		query.append("    ,T2.TBCGR_MKR_NM" ).append("\n"); 
		query.append("    ,T2.TBCGR_TP_DESC" ).append("\n"); 
		query.append("    ,T2.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T2.TBCGR_COFF_FLG" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("    ,T2.FOIL_ADTV_CD" ).append("\n"); 
		query.append("    ,T2.HL_PNT_CD" ).append("\n"); 
		query.append("    ,T2.GNR_CSM_WGT" ).append("\n"); 
		query.append("    ,T2.FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("    ,T2.FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T2.FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T2.OP_MAX_SPD" ).append("\n"); 
		query.append("    ,T2.OP_MIN_SPD" ).append("\n"); 
		query.append("    ,T2.OP_GNR_SPD" ).append("\n"); 
		query.append("    ,T2.TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("    ,T2.MNVR_CSM_WGT" ).append("\n"); 
		query.append("    ,T2.CRE_DT" ).append("\n"); 
		query.append("    ,T2.CRE_USR_ID" ).append("\n"); 
		query.append("    ,T2.UPD_DT" ).append("\n"); 
		query.append("    ,T2.UPD_USR_ID" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD --NOT OUTER JOIN" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD='T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD<>'SML'" ).append("\n"); 
		query.append("    ORDER BY T1.VSL_CD" ).append("\n"); 
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
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND T1.VSL_CD LIKE '%'||@[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,'' OWNR_NM" ).append("\n"); 
		query.append("    ,'' VSL_BLD_DT" ).append("\n"); 
		query.append("    ,TO_NUMBER('') VSL_DZND_CAPA" ).append("\n"); 
		query.append("    ,TO_NUMBER('') BSE_14TON_VSL_CAPA" ).append("\n"); 
		query.append("    ,'' FM_DT" ).append("\n"); 
		query.append("    ,'' TO_DT" ).append("\n"); 
		query.append("    ,T1.DWT_WGT" ).append("\n"); 
		query.append("    ,T1.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.LLOYD_NO" ).append("\n"); 
		query.append("    ,T1.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T1.VSL_CLSS_SUB_CD     " ).append("\n"); 
		query.append("    ,T1.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T1.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T1.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T1.TBCGR_NO" ).append("\n"); 
		query.append("    ,T1.TBCGR_MKR_NM" ).append("\n"); 
		query.append("    ,T1.TBCGR_TP_DESC" ).append("\n"); 
		query.append("    ,T1.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T1.TBCGR_COFF_FLG" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("    ,T1.SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("    ,T1.FOIL_ADTV_CD" ).append("\n"); 
		query.append("    ,T1.HL_PNT_CD" ).append("\n"); 
		query.append("    ,T1.GNR_CSM_WGT" ).append("\n"); 
		query.append("    ,T1.FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("    ,T1.FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T1.FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T1.OP_MAX_SPD" ).append("\n"); 
		query.append("    ,T1.OP_MIN_SPD" ).append("\n"); 
		query.append("    ,T1.OP_GNR_SPD" ).append("\n"); 
		query.append("    ,T1.TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("    ,T1.MNVR_CSM_WGT" ).append("\n"); 
		query.append("    ,T1.CRE_DT" ).append("\n"); 
		query.append("    ,T1.CRE_USR_ID" ).append("\n"); 
		query.append("    ,T1.UPD_DT" ).append("\n"); 
		query.append("    ,T1.UPD_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     T1.VSL_CD" ).append("\n"); 
		query.append("    ,T1.VSL_ENG_NM" ).append("\n"); 
		query.append("    ,T1.DWT_WGT" ).append("\n"); 
		query.append("    ,T1.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("    ,T1.LLOYD_NO" ).append("\n"); 
		query.append("    ,T1.CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,T2.VSL_CLSS_SUB_CD" ).append("\n"); 
		query.append("    ,T2.MN_ENG_MKR_NM" ).append("\n"); 
		query.append("    ,T2.MN_ENG_TP_DESC" ).append("\n"); 
		query.append("    ,T2.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("    ,T2.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("    ,T2.TBCGR_NO" ).append("\n"); 
		query.append("    ,T2.TBCGR_MKR_NM" ).append("\n"); 
		query.append("    ,T2.TBCGR_TP_DESC" ).append("\n"); 
		query.append("    ,T2.TBCGR_RPM_PWR" ).append("\n"); 
		query.append("    ,T2.TBCGR_COFF_FLG" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_MKR_NM" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_TP_DESC" ).append("\n"); 
		query.append("    ,T2.SPR_AUX_BLW_NO" ).append("\n"); 
		query.append("    ,T2.FOIL_ADTV_CD" ).append("\n"); 
		query.append("    ,T2.HL_PNT_CD" ).append("\n"); 
		query.append("    ,T2.GNR_CSM_WGT" ).append("\n"); 
		query.append("    ,T2.FOIL_TNK_CBM_CAPA" ).append("\n"); 
		query.append("    ,T2.FOIL_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T2.FOIL_STL_SVC_TNK_MT_CAPA" ).append("\n"); 
		query.append("    ,T2.OP_MAX_SPD" ).append("\n"); 
		query.append("    ,T2.OP_MIN_SPD" ).append("\n"); 
		query.append("    ,T2.OP_GNR_SPD" ).append("\n"); 
		query.append("    ,T2.TRND_LINE_USE_FLG" ).append("\n"); 
		query.append("    ,T2.MNVR_CSM_WGT" ).append("\n"); 
		query.append("    ,T2.CRE_DT" ).append("\n"); 
		query.append("    ,T2.CRE_USR_ID" ).append("\n"); 
		query.append("    ,T2.UPD_DT" ).append("\n"); 
		query.append("    ,T2.UPD_USR_ID" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("    AND T2.VSL_CD NOT IN (SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD!='TO' AND EXP_DT > TO_DATE('2011-08-01', 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("    AND NVL(T1.VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("    AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND T1.FDR_DIV_CD='T'" ).append("\n"); 
		query.append("    AND T1.CRR_CD<>'SML'" ).append("\n"); 
		query.append("    ORDER BY T1.VSL_CD" ).append("\n"); 
		query.append(")T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND T1.VSL_CD LIKE '%'||@[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY VSL_CD" ).append("\n"); 

	}
}