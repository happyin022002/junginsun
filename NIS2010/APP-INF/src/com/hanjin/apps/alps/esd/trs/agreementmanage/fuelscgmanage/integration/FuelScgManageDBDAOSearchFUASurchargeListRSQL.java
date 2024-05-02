/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : FuelScgManageDBDAOSearchFUASurchargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FuelScgManageDBDAOSearchFUASurchargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fuel Surcharge (FUA) Update List 조회
	  * </pre>
	  */
	public FuelScgManageDBDAOSearchFUASurchargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_vndr_prmry_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration").append("\n"); 
		query.append("FileName : FuelScgManageDBDAOSearchFUASurchargeListRSQL").append("\n"); 
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
		query.append("SELECT  A.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("        ,A.AGMT_NO" ).append("\n"); 
		query.append("        ,A.VNDR_SEQ" ).append("\n"); 
		query.append("        ,A.VNDR_NM" ).append("\n"); 
		query.append("        ,A.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("        ,A.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("        ,A.EQ_KND_CD" ).append("\n"); 
		query.append("        ,A.CGO_TP_CD" ).append("\n"); 
		query.append("        ,A.CUST_CD" ).append("\n"); 
		query.append("        ,A.CMDT_GRP_CD" ).append("\n"); 
		query.append("        ,A.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("        ,A.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("        ,TO_CHAR(A.EFF_FM_DT,'YYYYMMDD')  AS EFF_FM_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(A.EFF_TO_DT,'YYYYMMDD')  AS EFF_TO_DT" ).append("\n"); 
		query.append("        ,A.AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("        ,A.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("        ,A.TRSP_RND_RT" ).append("\n"); 
		query.append("        ,A.EQ_D2" ).append("\n"); 
		query.append("        ,A.EQ_D3" ).append("\n"); 
		query.append("        ,A.EQ_D4" ).append("\n"); 
		query.append("        ,A.EQ_D5" ).append("\n"); 
		query.append("        ,A.EQ_D7" ).append("\n"); 
		query.append("        ,A.EQ_D8" ).append("\n"); 
		query.append("        ,A.EQ_D9" ).append("\n"); 
		query.append("        ,A.EQ_DW" ).append("\n"); 
		query.append("        ,A.EQ_DX" ).append("\n"); 
		query.append("        ,A.EQ_R2" ).append("\n"); 
		query.append("        ,A.EQ_R4" ).append("\n"); 
		query.append("        ,A.EQ_R5" ).append("\n"); 
		query.append("        ,A.EQ_R7" ).append("\n"); 
		query.append("        ,A.EQ_R8" ).append("\n"); 
		query.append("        ,A.EQ_R9" ).append("\n"); 
		query.append("        ,A.EQ_A2" ).append("\n"); 
		query.append("        ,A.EQ_A4" ).append("\n"); 
		query.append("        ,A.EQ_F2" ).append("\n"); 
		query.append("        ,A.EQ_F4" ).append("\n"); 
		query.append("        ,A.EQ_F5" ).append("\n"); 
		query.append("        ,A.EQ_T2" ).append("\n"); 
		query.append("        ,A.EQ_T4" ).append("\n"); 
		query.append("        ,A.EQ_S2" ).append("\n"); 
		query.append("        ,A.EQ_S4" ).append("\n"); 
		query.append("        ,A.EQ_O2" ).append("\n"); 
		query.append("        ,A.EQ_O4" ).append("\n"); 
		query.append("        ,A.EQ_O5" ).append("\n"); 
		query.append("        ,A.EQ_O7" ).append("\n"); 
		query.append("        ,A.EQ_P2" ).append("\n"); 
		query.append("        ,A.EQ_P4" ).append("\n"); 
		query.append("        ,A.EQ_SF2" ).append("\n"); 
		query.append("        ,A.EQ_SF4" ).append("\n"); 
		query.append("        ,A.EQ_SL2" ).append("\n"); 
		query.append("        ,A.EQ_TA2" ).append("\n"); 
		query.append("        ,A.EQ_GN4" ).append("\n"); 
		query.append("        ,A.EQ_GN5" ).append("\n"); 
		query.append("        ,A.EQ_EG5" ).append("\n"); 
		query.append("        ,A.EQ_EG8" ).append("\n"); 
		query.append("        ,A.EQ_ZT4" ).append("\n"); 
		query.append("        ,A.EQ_CB4" ).append("\n"); 
		query.append("        ,A.EQ_CG" ).append("\n"); 
		query.append("        ,A.EQ_UG" ).append("\n"); 
		query.append("        ,A.EQ_ALAL" ).append("\n"); 
		query.append("        ,A.EQ_DAL" ).append("\n"); 
		query.append("        ,A.EQ_RAL" ).append("\n"); 
		query.append("        ,A.EQ_AAL" ).append("\n"); 
		query.append("        ,A.EQ_FAL" ).append("\n"); 
		query.append("        ,A.EQ_TAL" ).append("\n"); 
		query.append("        ,A.EQ_SAL" ).append("\n"); 
		query.append("        ,A.EQ_OAL" ).append("\n"); 
		query.append("        ,A.EQ_PAL" ).append("\n"); 
		query.append("        ,A.EQ_AL2" ).append("\n"); 
		query.append("        ,A.EQ_AL4" ).append("\n"); 
		query.append("        ,A.EQ_AL5" ).append("\n"); 
		query.append("        ,A.EQ_AL7" ).append("\n"); 
		query.append("        ,A.EQ_AL8" ).append("\n"); 
		query.append("        ,A.EQ_AL9" ).append("\n"); 
		query.append("        ,A.EQ_SFAL" ).append("\n"); 
		query.append("        ,A.EQ_SLAL" ).append("\n"); 
		query.append("        ,A.EQ_TAAL" ).append("\n"); 
		query.append("        ,A.EQ_GNAL" ).append("\n"); 
		query.append("        ,A.EQ_EGAL" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,A.UPD_USR_NM" ).append("\n"); 
		query.append("        ,A.UPD_OFC_CD" ).append("\n"); 
		query.append("        ,A.RATE_TOT_CNT" ).append("\n"); 
		query.append("        ,A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("        ,A.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("        ,A.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("        ,A.FM_NOD_CD" ).append("\n"); 
		query.append("        ,A.FM_NOD_YD" ).append("\n"); 
		query.append("        ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("        ,A.VIA_NOD_YD" ).append("\n"); 
		query.append("        ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("        ,A.DOR_NOD_YD" ).append("\n"); 
		query.append("        ,A.TO_NOD_CD" ).append("\n"); 
		query.append("        ,A.TO_NOD_YD" ).append("\n"); 
		query.append("        ,A.TO_WGT" ).append("\n"); 
		query.append("        ,A.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("        ,A.TRSP_SCG_CD" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("  FROM (SELECT  C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                  ,C.TRSP_AGMT_OFC_CTY_CD || C.TRSP_AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("               ,B.VNDR_SEQ" ).append("\n"); 
		query.append("                  ,(SELECT MDM.VNDR_LGL_ENG_NM FROM MDM_VENDOR MDM WHERE MDM.VNDR_SEQ = B.VNDR_SEQ ) VNDR_NM" ).append("\n"); 
		query.append("                  ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("               ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("               ,E.EQ_KND_CD" ).append("\n"); 
		query.append("               ,C.CGO_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(C.CUST_CNT_CD||C.CUST_SEQ, 'XX0', NULL, C.CUST_CNT_CD||C.CUST_SEQ) CUST_CD" ).append("\n"); 
		query.append("               ,DECODE(C.CMDT_GRP_CD, 'XXXX', NULL, C.CMDT_GRP_CD) CMDT_GRP_CD" ).append("\n"); 
		query.append("               ,DECODE(C.RAIL_SVC_TP_CD, '00', NULL, C.RAIL_SVC_TP_CD) RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("               ,D.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("               ,E.EFF_FM_DT" ).append("\n"); 
		query.append("               ,E.EFF_TO_DT" ).append("\n"); 
		query.append("               ,E.AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("               ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("               ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D2', 'Y')) EQ_D2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D3', 'Y')) EQ_D3" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D4', 'Y')) EQ_D4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D5', 'Y')) EQ_D5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D7', 'Y')) EQ_D7" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D8', 'Y')) EQ_D8" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D9', 'Y')) EQ_D9" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DW', 'Y')) EQ_DW" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DX', 'Y')) EQ_DX" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R2', 'Y')) EQ_R2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R4', 'Y')) EQ_R4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R5', 'Y')) EQ_R5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R7', 'Y')) EQ_R7" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R8', 'Y')) EQ_R8" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R9', 'Y')) EQ_R9" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'A2', 'Y')) EQ_A2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'A4', 'Y')) EQ_A4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F2', 'Y')) EQ_F2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F4', 'Y')) EQ_F4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F5', 'Y')) EQ_F5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'T2', 'Y')) EQ_T2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'T4', 'Y')) EQ_T4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'S2', 'Y')) EQ_S2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'S4', 'Y')) EQ_S4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'O2', 'Y')) EQ_O2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'O4', 'Y')) EQ_O4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'O5', 'Y')) EQ_O5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'O7', 'Y')) EQ_O7" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'P2', 'Y')) EQ_P2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'P4', 'Y')) EQ_P4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SF2', 'Y')) EQ_SF2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SF4', 'Y')) EQ_SF4 " ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SL2', 'Y')) EQ_SL2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TA2', 'Y')) EQ_TA2 " ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GN4', 'Y')) EQ_GN4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GN5', 'Y')) EQ_GN5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EG5', 'Y')) EQ_EG5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EG8', 'Y')) EQ_EG8" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'ZT4', 'Y')) EQ_ZT4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'CB4', 'Y')) EQ_CB4 " ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'CG', 'Y'))  EQ_CG" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'UG', 'Y'))  EQ_UG" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'ALAL', 'Y')) EQ_ALAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DAL', 'Y'))  EQ_DAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'RAL', 'Y'))  EQ_RAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AAL', 'Y'))  EQ_AAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'FAL', 'Y'))  EQ_FAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TAL', 'Y'))  EQ_TAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SAL', 'Y'))  EQ_SAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'OAL', 'Y'))  EQ_OAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'PAL', 'Y'))  EQ_PAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL2', 'Y'))  EQ_AL2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL4', 'Y'))  EQ_AL4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL5', 'Y'))  EQ_AL5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL7', 'Y'))  EQ_AL7" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL8', 'Y'))  EQ_AL8" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL9', 'Y'))  EQ_AL9      " ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SFAL', 'Y'))  EQ_SFAL      " ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SLAL', 'Y'))  EQ_SLAL      " ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TAAL', 'Y'))  EQ_TAAL      " ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GNAL', 'Y'))  EQ_GNAL      " ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EGAL', 'Y'))  EQ_EGAL  " ).append("\n"); 
		query.append("               ,C.UPD_USR_ID" ).append("\n"); 
		query.append("               ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = C.UPD_USR_ID) UPD_USR_NM" ).append("\n"); 
		query.append("               ,C.UPD_OFC_CD" ).append("\n"); 
		query.append("               ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("                   FROM TRS_AGMT_EQ_RT X" ).append("\n"); 
		query.append("                  WHERE X.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    AND X.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                    AND X.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                    AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("           #if (${fm_effective_agmt} == 'C' )" ).append("\n"); 
		query.append("                    AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD)  FROM DUAL ) BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("                ) AS RATE_TOT_CNT " ).append("\n"); 
		query.append("               ,C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("               ,C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("               ,E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("               ,E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("--               ,E.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.FM_NOD_CD,1,5), '00000', NULL, SUBSTR(D.FM_NOD_CD,1,5)) AS FM_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.FM_NOD_CD,6), '00', NULL, SUBSTR(D.FM_NOD_CD,6)) AS FM_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.VIA_NOD_CD,1,5), '00000', NULL, SUBSTR(D.VIA_NOD_CD,1,5)) AS VIA_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.VIA_NOD_CD,6), '00', NULL, SUBSTR(D.VIA_NOD_CD,6)) AS VIA_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.DOR_NOD_CD,1,5), '00000', NULL, SUBSTR(D.DOR_NOD_CD,1,5)) AS DOR_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.DOR_NOD_CD,6), '00', NULL, SUBSTR(D.DOR_NOD_CD,6)) AS DOR_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.TO_NOD_CD,1,5), '00000', NULL, SUBSTR(D.TO_NOD_CD,1,5)) AS TO_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.TO_NOD_CD,6), '00', NULL, SUBSTR(D.TO_NOD_CD,6)) AS TO_NOD_YD" ).append("\n"); 
		query.append("               ,E.TO_WGT" ).append("\n"); 
		query.append("               ,E.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("               ,D.TRSP_SCG_CD" ).append("\n"); 
		query.append("               ,DECODE(E.CURR_CD, 'XXX', NULL, E.CURR_CD) CURR_CD " ).append("\n"); 
		query.append("               ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("          FROM  TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("               ,TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("                ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("               ,TRS_AGMT_SCG_NOD   D" ).append("\n"); 
		query.append("               ,TRS_AGMT_SCG_RT E" ).append("\n"); 
		query.append("           WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                  AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("            AND D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("            AND D.TRSP_AGMT_SCG_NOD_SEQ  = E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("            AND B.AGMT_VNDR_PRMRY_FLG  = 'Y'" ).append("\n"); 
		query.append("    #if (${fm_cmd} =='103') " ).append("\n"); 
		query.append("            AND D.TRSP_SCG_CD = 'FUE'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("            AND D.TRSP_SCG_CD = 'FUA'" ).append("\n"); 
		query.append("            AND D.AGMT_ROUT_ALL_FLG = 'Y'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${fm_agmt_no} !='') " ).append("\n"); 
		query.append("            AND A.TRSP_AGMT_OFC_CTY_CD = SUBSTR( @[fm_agmt_no],1,3)" ).append("\n"); 
		query.append("            AND A.TRSP_AGMT_SEQ = SUBSTR( @[fm_agmt_no],4)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${fm_vndr_prmry_seq} != '')" ).append("\n"); 
		query.append("            AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN ( SELECT TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                                                                 FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("                                                                WHERE VNDR_SEQ =  @[fm_vndr_prmry_seq]" ).append("\n"); 
		query.append("                                                                    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                              )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if ($arr_ctrt_office.size() > 0) " ).append("\n"); 
		query.append("            AND A.CTRT_OFC_CD IN (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${arr_ctrt_office}) " ).append("\n"); 
		query.append("            #if($velocityCount < $arr_ctrt_office.size()) " ).append("\n"); 
		query.append("                '$key', " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                '$key' " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${fm_effective_agmt} == 'C' )" ).append("\n"); 
		query.append("            AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD)  FROM DUAL ) BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${fm_trsp_cost_mod_cd} != '' )" ).append("\n"); 
		query.append("             AND C.TRSP_COST_MOD_CD =  @[fm_trsp_cost_mod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fm_agmt_trsp_tp_cd} != '' )" ).append("\n"); 
		query.append("            AND C.AGMT_TRSP_TP_CD = @[fm_agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("            AND NVL(E.DELT_FLG, 'N')     = 'N'" ).append("\n"); 
		query.append("            AND E.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("          GROUP BY     C.TRSP_AGMT_RT_TP_CD    " ).append("\n"); 
		query.append("                     ,C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                     ,C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   ,C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   ,B.VNDR_SEQ" ).append("\n"); 
		query.append("                   ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                   ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                   ,E.EQ_KND_CD" ).append("\n"); 
		query.append("                   ,C.CGO_TP_CD" ).append("\n"); 
		query.append("                   ,DECODE(C.CUST_CNT_CD||C.CUST_SEQ, 'XX0', NULL, C.CUST_CNT_CD||C.CUST_SEQ)" ).append("\n"); 
		query.append("                   ,DECODE(C.CMDT_GRP_CD, 'XXXX', NULL, C.CMDT_GRP_CD)" ).append("\n"); 
		query.append("                   ,DECODE(C.RAIL_SVC_TP_CD, '00', NULL, C.RAIL_SVC_TP_CD)" ).append("\n"); 
		query.append("                   ,D.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("                   ,DECODE(SUBSTR(D.FM_NOD_CD,1,5), '00000', NULL, SUBSTR(D.FM_NOD_CD,1,5))" ).append("\n"); 
		query.append("                   ,DECODE(SUBSTR(D.FM_NOD_CD,6), '00', NULL, SUBSTR(D.FM_NOD_CD,6))" ).append("\n"); 
		query.append("                    ,DECODE(SUBSTR(D.VIA_NOD_CD,1,5), '00000', NULL, SUBSTR(D.VIA_NOD_CD,1,5))" ).append("\n"); 
		query.append("                   ,DECODE(SUBSTR(D.VIA_NOD_CD,6), '00', NULL, SUBSTR(D.VIA_NOD_CD,6))" ).append("\n"); 
		query.append("                   ,DECODE(SUBSTR(D.DOR_NOD_CD,1,5), '00000', NULL, SUBSTR(D.DOR_NOD_CD,1,5))" ).append("\n"); 
		query.append("                   ,DECODE(SUBSTR(D.DOR_NOD_CD,6), '00', NULL, SUBSTR(D.DOR_NOD_CD,6))" ).append("\n"); 
		query.append("                   ,DECODE(SUBSTR(D.TO_NOD_CD,1,5), '00000', NULL, SUBSTR(D.TO_NOD_CD,1,5))" ).append("\n"); 
		query.append("                   ,DECODE(SUBSTR(D.TO_NOD_CD,6), '00', NULL, SUBSTR(D.TO_NOD_CD,6))" ).append("\n"); 
		query.append("                   ,E.EFF_FM_DT" ).append("\n"); 
		query.append("                   ,E.EFF_TO_DT" ).append("\n"); 
		query.append("                   ,E.AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("                   ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("                   ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("                   ,C.UPD_USR_ID" ).append("\n"); 
		query.append("                   ,C.UPD_OFC_CD" ).append("\n"); 
		query.append("                   ,E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   ,E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("--                   ,E.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("                   ,E.TO_WGT" ).append("\n"); 
		query.append("                   ,E.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("                   ,D.TRSP_SCG_CD" ).append("\n"); 
		query.append("                   ,DECODE(E.CURR_CD, 'XXX', NULL, E.CURR_CD)" ).append("\n"); 
		query.append("                   ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.RATE_TOT_CNT > 0" ).append("\n"); 

	}
}