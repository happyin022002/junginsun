/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOSearchAgmtCostCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchAgmtCostCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Cost Code를 조회한다.
	  * </pre>
	  */
	public TESCommonDBDAOSearchAgmtCostCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchAgmtCostCdListRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(COST_CODE,'|')),'|') AS COST_CODE " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT ROWNUM ROW_ID " ).append("\n"); 
		query.append("            , Z.COST_CODE " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT COST_CODE" ).append("\n"); 
		query.append("                  FROM" ).append("\n"); 
		query.append("                       (SELECT DISTINCT DECODE(1,0,C.LGS_COST_CD,DECODE(C.LGS_COST_CD,CD,TP,C.LGS_COST_CD)) COST_CODE " ).append("\n"); 
		query.append("                         FROM " ).append("\n"); 
		query.append("                              (SELECT COUNT(T.LGS_COST_CD) CNT" ).append("\n"); 
		query.append("                                   , T.LGS_COST_CD TP" ).append("\n"); 
		query.append("                                   , T.THRP_LGS_COST_CD CD" ).append("\n"); 
		query.append("                                   , H.TML_AGMT_OFC_CTY_CD CTY" ).append("\n"); 
		query.append("                                   , H.TML_AGMT_SEQ SEQ" ).append("\n"); 
		query.append("                                   , H.TML_AGMT_VER_NO NO " ).append("\n"); 
		query.append("                                FROM TES_TML_AGMT_HDR H" ).append("\n"); 
		query.append("                                   , TES_TML_AGMT_THRP_COST T " ).append("\n"); 
		query.append("                               WHERE H.YD_CD = @[yd_cd] " ).append("\n"); 
		query.append("                                     AND H.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("                                     AND H.TML_AGMT_STS_CD = 'C' " ).append("\n"); 
		query.append("                                     AND H.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                     " ).append("\n"); 
		query.append("                               #if (${agmt_ftr_inv_tp_cd} == 'MT') " ).append("\n"); 
		query.append("                                     AND TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice " ).append("\n"); 
		query.append("                                     AND TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice  " ).append("\n"); 
		query.append("                               #elseif (${agmt_ftr_inv_tp_cd} == 'ST' || ${agmt_ftr_inv_tp_cd} == 'OS') " ).append("\n"); 
		query.append("                                     AND TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("                                     AND TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice  " ).append("\n"); 
		query.append("                               #elseif (${agmt_ftr_inv_tp_cd} == 'OT' || ${agmt_ftr_inv_tp_cd} == 'OFON' || ${agmt_ftr_inv_tp_cd} == 'OTOS') " ).append("\n"); 
		query.append("                                     AND TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[to_prd_dt],'-') -- To Period Date([to_prd_dt]) ==> OFF Dock Terminal Invoice (ON Dock 비용계산시) " ).append("\n"); 
		query.append("                                     AND TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_prd_dt],'-') -- To Period Date([to_prd_dt]) ==> OFF Dock Terminal Invoice (ON Dock 비용계산시)  " ).append("\n"); 
		query.append("                               #elseif (${agmt_ftr_inv_tp_cd} == 'ON') " ).append("\n"); 
		query.append("                                     AND TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-') -- Min Work Date([min_wrk_dt]) ==> OnDock Rail Invoice " ).append("\n"); 
		query.append("                                     AND TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[min_wrk_dt],'-') -- Max Work Date([max_wrk_dt]) ==> OnDock Rail Invoice  " ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                                     AND H.TML_AGMT_VER_NO = " ).append("\n"); 
		query.append("                                     (SELECT MAX(M.TML_AGMT_VER_NO) " ).append("\n"); 
		query.append("                                       FROM TES_TML_AGMT_HDR M " ).append("\n"); 
		query.append("                                      WHERE M.YD_CD = @[yd_cd] " ).append("\n"); 
		query.append("                                            AND M.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("                                            AND M.TML_AGMT_STS_CD = 'C' " ).append("\n"); 
		query.append("                                            AND M.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                    #if (${agmt_ftr_inv_tp_cd} == 'MT') " ).append("\n"); 
		query.append("                                            AND TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice " ).append("\n"); 
		query.append("                                            AND TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice  " ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                                    #elseif (${agmt_ftr_inv_tp_cd} == 'ST' || ${agmt_ftr_inv_tp_cd} == 'OS') " ).append("\n"); 
		query.append("                                            AND TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("                                            AND TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice  " ).append("\n"); 
		query.append("                                     ) " ).append("\n"); 
		query.append("                                    #elseif (${agmt_ftr_inv_tp_cd} == 'OT' || ${agmt_ftr_inv_tp_cd} == 'OFON' || ${agmt_ftr_inv_tp_cd} == 'OTOS') " ).append("\n"); 
		query.append("                                            AND TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[to_prd_dt],'-') -- To Period Date([to_prd_dt]) ==> OFF Dock Terminal Invoice (ON Dock 비용계산시) " ).append("\n"); 
		query.append("                                            AND TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_prd_dt],'-') -- To Period Date([to_prd_dt]) ==> OFF Dock Terminal Invoice (ON Dock 비용계산시)  " ).append("\n"); 
		query.append("                                     ) " ).append("\n"); 
		query.append("                                    #elseif (${agmt_ftr_inv_tp_cd} == 'ON') " ).append("\n"); 
		query.append("                                            AND TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-') -- Min Work Date([min_wrk_dt]) ==> OnDock Rail Invoice " ).append("\n"); 
		query.append("                                            AND TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[min_wrk_dt],'-') -- Max Work Date([max_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("                                     ) " ).append("\n"); 
		query.append("                                    #else " ).append("\n"); 
		query.append("                                            AND 1=2 " ).append("\n"); 
		query.append("                                     ) " ).append("\n"); 
		query.append("                                    #end  " ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("                                    AND H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("                                    AND H.TML_AGMT_SEQ = T.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("                                    AND H.TML_AGMT_VER_NO = T.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("                                    GROUP BY H.TML_AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("                                                  H.TML_AGMT_SEQ, " ).append("\n"); 
		query.append("                                                  H.TML_AGMT_VER_NO, " ).append("\n"); 
		query.append("                                                  T.LGS_COST_CD, " ).append("\n"); 
		query.append("                                                  T.THRP_LGS_COST_CD " ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                               , TES_TML_SO_COST C" ).append("\n"); 
		query.append("                               , TES_TML_AGMT_DTL D " ).append("\n"); 
		query.append("                      WHERE C.COST_CALC_MZD_CD = 'A' " ).append("\n"); 
		query.append("                      AND C.TML_AGMT_MGMT_CD = 'A' " ).append("\n"); 
		query.append("                		" ).append("\n"); 
		query.append("                    #if (${agmt_ftr_inv_tp_cd} == 'MT') " ).append("\n"); 
		query.append("                      AND C.MRN_TML_FLG = 'Y' -- Marine Terminal Invoice  " ).append("\n"); 
		query.append("                   	" ).append("\n"); 
		query.append("                    #elseif (${agmt_ftr_inv_tp_cd} == 'ON') " ).append("\n"); 
		query.append("                      AND C.ODCK_RAIL_CHG_FLG = 'Y' -- OnDock Rail Invoice  " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                    #elseif (${agmt_ftr_inv_tp_cd} == 'OT' || ${agmt_ftr_inv_tp_cd} == 'OTOS' ) " ).append("\n"); 
		query.append("                      AND C.FDCK_CY_TML_FLG = 'Y' -- OFF Dock Terminal Invoice  " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                    #elseif (${agmt_ftr_inv_tp_cd} == 'OS') " ).append("\n"); 
		query.append("                      AND C.FDCK_CY_STO_FLG = 'Y' -- OFF Dock Storage Invoice  " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                    #elseif (${agmt_ftr_inv_tp_cd} == 'OFON') " ).append("\n"); 
		query.append("                      AND C.MRN_TML_FLG = 'Y' " ).append("\n"); 
		query.append("                      AND C.LGS_COST_CD LIKE 'TMND%' -- OFF Dock 화면에서 ON Dock 비용계산시  " ).append("\n"); 
		query.append("                   	" ).append("\n"); 
		query.append("                    #elseif (${agmt_ftr_inv_tp_cd} == 'ST') " ).append("\n"); 
		query.append("                      AND C.STO_INV_FLG = 'Y' -- Marine Storage Invoice  " ).append("\n"); 
		query.append("                   	" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                      AND D.TML_AGMT_OFC_CTY_CD = A.CTY " ).append("\n"); 
		query.append("                      AND D.TML_AGMT_SEQ = A.SEQ " ).append("\n"); 
		query.append("                      AND D.TML_AGMT_VER_NO = A.NO " ).append("\n"); 
		query.append("                      AND C.LGS_COST_CD = D.LGS_COST_CD " ).append("\n"); 
		query.append("                      AND DECODE(A.CNT,0,DECODE(SUBSTR(C.LGS_COST_CD,1,2),'TP','N','Y'),'Y') = 'Y' " ).append("\n"); 
		query.append("                      AND D.THRP_COST_CD_FLG IS NULL" ).append("\n"); 
		query.append("                   )  " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                #if (${agmt_ftr_inv_tp_cd} == 'OTOS') --OTOS이면 OS용 " ).append("\n"); 
		query.append("                UNION ALL  " ).append("\n"); 
		query.append("                SELECT COST_CODE  " ).append("\n"); 
		query.append("                     FROM" ).append("\n"); 
		query.append("                          (SELECT DISTINCT DECODE(1,0,C.LGS_COST_CD,DECODE(C.LGS_COST_CD,CD,TP,C.LGS_COST_CD)) COST_CODE " ).append("\n"); 
		query.append("                            FROM " ).append("\n"); 
		query.append("                                 (SELECT COUNT(T.LGS_COST_CD) CNT" ).append("\n"); 
		query.append("                                      , T.LGS_COST_CD TP" ).append("\n"); 
		query.append("                                      , T.THRP_LGS_COST_CD CD" ).append("\n"); 
		query.append("                                      , H.TML_AGMT_OFC_CTY_CD CTY" ).append("\n"); 
		query.append("                                      , H.TML_AGMT_SEQ SEQ" ).append("\n"); 
		query.append("                                      , H.TML_AGMT_VER_NO NO " ).append("\n"); 
		query.append("                                   FROM TES_TML_AGMT_HDR H" ).append("\n"); 
		query.append("                                      , TES_TML_AGMT_THRP_COST T " ).append("\n"); 
		query.append("                                  WHERE H.YD_CD = @[yd_cd] " ).append("\n"); 
		query.append("                                        AND H.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("                                        AND H.TML_AGMT_STS_CD = 'C' " ).append("\n"); 
		query.append("                                        AND H.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                        AND TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("                                        AND TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice  " ).append("\n"); 
		query.append("                                        AND H.TML_AGMT_VER_NO = " ).append("\n"); 
		query.append("                                        (SELECT MAX(M.TML_AGMT_VER_NO) " ).append("\n"); 
		query.append("                                          FROM TES_TML_AGMT_HDR M " ).append("\n"); 
		query.append("                                         WHERE M.YD_CD = @[yd_cd] " ).append("\n"); 
		query.append("                                               AND M.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("                                               AND M.TML_AGMT_STS_CD = 'C' " ).append("\n"); 
		query.append("                                               AND M.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                               AND TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("                                               AND TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice  " ).append("\n"); 
		query.append("                                        ) " ).append("\n"); 
		query.append("                                        AND H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("                                        AND H.TML_AGMT_SEQ = T.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("                                        AND H.TML_AGMT_VER_NO = T.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("                                  GROUP BY H.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                      , H.TML_AGMT_SEQ" ).append("\n"); 
		query.append("                                      , H.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("                                      , T.LGS_COST_CD" ).append("\n"); 
		query.append("                                      , T.THRP_LGS_COST_CD " ).append("\n"); 
		query.append("                                 ) A" ).append("\n"); 
		query.append("                               , TES_TML_SO_COST C" ).append("\n"); 
		query.append("                               , TES_TML_AGMT_DTL D " ).append("\n"); 
		query.append("                           WHERE C.COST_CALC_MZD_CD = 'A' " ).append("\n"); 
		query.append("                                 AND C.TML_AGMT_MGMT_CD = 'A' " ).append("\n"); 
		query.append("                                 AND C.FDCK_CY_STO_FLG = 'Y' -- OFF Dock Storage Invoice " ).append("\n"); 
		query.append("                                 AND D.TML_AGMT_OFC_CTY_CD = A.CTY " ).append("\n"); 
		query.append("                                 AND D.TML_AGMT_SEQ = A.SEQ " ).append("\n"); 
		query.append("                                 AND D.TML_AGMT_VER_NO = A.NO " ).append("\n"); 
		query.append("                                 AND C.LGS_COST_CD = D.LGS_COST_CD " ).append("\n"); 
		query.append("                                 AND DECODE(A.CNT,0,DECODE(SUBSTR(C.LGS_COST_CD,1,2),'TP','N','Y'),'Y') = 'Y' " ).append("\n"); 
		query.append("                                 AND D.THRP_COST_CD_FLG IS NULL " ).append("\n"); 
		query.append("                          )  " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("           ) Z " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1 " ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 

	}
}