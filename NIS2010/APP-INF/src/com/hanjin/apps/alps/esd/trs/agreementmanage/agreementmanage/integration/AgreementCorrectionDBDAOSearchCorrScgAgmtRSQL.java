/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AgreementCorrectionDBDAOSearchCorrScgAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAOSearchCorrScgAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Surcharge Rate정보 조회
	  * </pre>
	  */
	public AgreementCorrectionDBDAOSearchCorrScgAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_page_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmtno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_size",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOSearchCorrScgAgmtRSQL").append("\n"); 
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
		query.append("#if (${grid_flg} != 'Y')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    'Surcharge'" ).append("\n"); 
		query.append("    ,'Cost Mode'" ).append("\n"); 
		query.append("    ,'Trans Mode'" ).append("\n"); 
		query.append("    ,'Cargo Type'" ).append("\n"); 
		query.append("    ,'CNT Type'" ).append("\n"); 
		query.append("    ,'Customer Code'" ).append("\n"); 
		query.append("    ,'Commodity GroupCode'" ).append("\n"); 
		query.append("    ,'RailService Type'" ).append("\n"); 
		query.append("    ,'From'" ).append("\n"); 
		query.append("    ,'To'" ).append("\n"); 
		query.append("    ,'AllRoute'" ).append("\n"); 
		query.append("    ,'Loc'" ).append("\n"); 
		query.append("    ,'Node'" ).append("\n"); 
		query.append("    ,'Loc'" ).append("\n"); 
		query.append("    ,'Node'" ).append("\n"); 
		query.append("    ,'Loc'" ).append("\n"); 
		query.append("    ,'Node'" ).append("\n"); 
		query.append("    ,'Loc'" ).append("\n"); 
		query.append("    ,'Node'" ).append("\n"); 
		query.append("    ,'Fixed Ratio Div'" ).append("\n"); 
		query.append("    ,'Currency'" ).append("\n"); 
		query.append("    ,'One Way'" ).append("\n"); 
		query.append("    ,'Round Trip'" ).append("\n"); 
		query.append("    ,'ALAL'" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("    ,'DAL'" ).append("\n"); 
		query.append("    ,'RAL'" ).append("\n"); 
		query.append("    ,'AAL'" ).append("\n"); 
		query.append("    ,'FAL'" ).append("\n"); 
		query.append("    ,'TAL'" ).append("\n"); 
		query.append("    ,'SAL'" ).append("\n"); 
		query.append("    ,'OAL'" ).append("\n"); 
		query.append("    ,'PAL'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'Z')" ).append("\n"); 
		query.append("    ,'SFAL'" ).append("\n"); 
		query.append("    ,'SLAL'" ).append("\n"); 
		query.append("    ,'TAAL'" ).append("\n"); 
		query.append("    ,'GNAL'" ).append("\n"); 
		query.append("    ,'EGAL'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} != 'G')" ).append("\n"); 
		query.append("    ,'AL2'" ).append("\n"); 
		query.append("    ,'AL4'" ).append("\n"); 
		query.append("    ,'AL5'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("    ,'AL7'" ).append("\n"); 
		query.append("    ,'AL9'" ).append("\n"); 
		query.append("    ,'D2'" ).append("\n"); 
		query.append("    ,'D4'" ).append("\n"); 
		query.append("    ,'D5'" ).append("\n"); 
		query.append("    ,'D7'" ).append("\n"); 
		query.append("    ,'R2'" ).append("\n"); 
		query.append("    ,'R4'" ).append("\n"); 
		query.append("    ,'R5'" ).append("\n"); 
		query.append("    ,'R7'" ).append("\n"); 
		query.append("    ,'R8'" ).append("\n"); 
		query.append("    ,'R9'" ).append("\n"); 
		query.append("    ,'A2'" ).append("\n"); 
		query.append("    ,'A4'" ).append("\n"); 
		query.append("    ,'A5'" ).append("\n"); 
		query.append("    ,'F2'" ).append("\n"); 
		query.append("    ,'F4'" ).append("\n"); 
		query.append("    ,'F5'" ).append("\n"); 
		query.append("    ,'T2'" ).append("\n"); 
		query.append("    ,'T4'" ).append("\n"); 
		query.append("    ,'S2'" ).append("\n"); 
		query.append("    ,'S4'" ).append("\n"); 
		query.append("    ,'O2'" ).append("\n"); 
		query.append("    ,'O4'" ).append("\n"); 
		query.append("    ,'O5'" ).append("\n"); 
		query.append("    ,'O7'" ).append("\n"); 
		query.append("    ,'P2'" ).append("\n"); 
		query.append("    ,'P4'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'Z')" ).append("\n"); 
		query.append("    ,'AL8'" ).append("\n"); 
		query.append("    ,'SF2'" ).append("\n"); 
		query.append("    ,'SF4'" ).append("\n"); 
		query.append("    ,'SL2'" ).append("\n"); 
		query.append("    ,'TA2'" ).append("\n"); 
		query.append("    ,'GN4'" ).append("\n"); 
		query.append("    ,'GN5'" ).append("\n"); 
		query.append("    ,'EG5'" ).append("\n"); 
		query.append("    ,'EG8'" ).append("\n"); 
		query.append("    ,'ZT4'" ).append("\n"); 
		query.append("    ,'CB4'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'G')" ).append("\n"); 
		query.append("    ,'CG'" ).append("\n"); 
		query.append("    ,'UG'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,'Weight Tier'" ).append("\n"); 
		query.append("    ,'UOM'" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("    ,'Confirm(Manager Level)'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    TRSP_SCG_CD" ).append("\n"); 
		query.append("    ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("    ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("    ,CGO_TP_CD" ).append("\n"); 
		query.append("    ,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("    ,CUST_CD" ).append("\n"); 
		query.append("    ,CMDT_GRP_CD" ).append("\n"); 
		query.append("    ,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("    ,EFF_FM_DT" ).append("\n"); 
		query.append("    ,EFF_TO_DT" ).append("\n"); 
		query.append("    ,AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("    ,FM_NOD_CD" ).append("\n"); 
		query.append("    ,FM_NOD_YD" ).append("\n"); 
		query.append("    ,VIA_NOD_CD" ).append("\n"); 
		query.append("    ,VIA_NOD_YD" ).append("\n"); 
		query.append("    ,DOR_NOD_CD" ).append("\n"); 
		query.append("    ,DOR_NOD_YD" ).append("\n"); 
		query.append("    ,TO_NOD_CD" ).append("\n"); 
		query.append("    ,TO_NOD_YD" ).append("\n"); 
		query.append("    ,AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("    ,CURR_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(TRSP_ONE_WY_RT) AS TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("    ,TO_CHAR(TRSP_RND_RT) AS TRSP_RND_RT" ).append("\n"); 
		query.append("    ,EQ_ALAL" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("    ,EQ_DAL" ).append("\n"); 
		query.append("    ,EQ_RAL" ).append("\n"); 
		query.append("    ,EQ_AAL" ).append("\n"); 
		query.append("    ,EQ_FAL" ).append("\n"); 
		query.append("    ,EQ_TAL" ).append("\n"); 
		query.append("    ,EQ_SAL" ).append("\n"); 
		query.append("    ,EQ_OAL" ).append("\n"); 
		query.append("    ,EQ_PAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'Z')" ).append("\n"); 
		query.append("    ,EQ_SFAL" ).append("\n"); 
		query.append("    ,EQ_SLAL" ).append("\n"); 
		query.append("    ,EQ_TAAL" ).append("\n"); 
		query.append("    ,EQ_GNAL" ).append("\n"); 
		query.append("    ,EQ_EGAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} != 'G')" ).append("\n"); 
		query.append("    ,EQ_AL2" ).append("\n"); 
		query.append("    ,EQ_AL4" ).append("\n"); 
		query.append("    ,EQ_AL5" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("    ,EQ_AL7" ).append("\n"); 
		query.append("    ,EQ_AL9" ).append("\n"); 
		query.append("    ,EQ_D2" ).append("\n"); 
		query.append("    ,EQ_D4" ).append("\n"); 
		query.append("    ,EQ_D5" ).append("\n"); 
		query.append("    ,EQ_D7" ).append("\n"); 
		query.append("    ,EQ_R2" ).append("\n"); 
		query.append("    ,EQ_R4" ).append("\n"); 
		query.append("    ,EQ_R5" ).append("\n"); 
		query.append("    ,EQ_R7" ).append("\n"); 
		query.append("    ,EQ_R8" ).append("\n"); 
		query.append("    ,EQ_R9" ).append("\n"); 
		query.append("    ,EQ_A2" ).append("\n"); 
		query.append("    ,EQ_A4" ).append("\n"); 
		query.append("    ,EQ_A5" ).append("\n"); 
		query.append("    ,EQ_F2" ).append("\n"); 
		query.append("    ,EQ_F4" ).append("\n"); 
		query.append("    ,EQ_F5" ).append("\n"); 
		query.append("    ,EQ_T2" ).append("\n"); 
		query.append("    ,EQ_T4" ).append("\n"); 
		query.append("    ,EQ_S2" ).append("\n"); 
		query.append("    ,EQ_S4" ).append("\n"); 
		query.append("    ,EQ_O2" ).append("\n"); 
		query.append("    ,EQ_O4" ).append("\n"); 
		query.append("    ,EQ_O5" ).append("\n"); 
		query.append("    ,EQ_O7" ).append("\n"); 
		query.append("    ,EQ_P2" ).append("\n"); 
		query.append("    ,EQ_P4" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'Z')" ).append("\n"); 
		query.append("    ,EQ_AL8" ).append("\n"); 
		query.append("    ,EQ_SF2" ).append("\n"); 
		query.append("    ,EQ_SF4" ).append("\n"); 
		query.append("    ,EQ_SL2" ).append("\n"); 
		query.append("    ,EQ_TA2" ).append("\n"); 
		query.append("    ,EQ_GN4" ).append("\n"); 
		query.append("    ,EQ_GN5" ).append("\n"); 
		query.append("    ,EQ_EG5" ).append("\n"); 
		query.append("    ,EQ_EG8" ).append("\n"); 
		query.append("    ,EQ_ZT4" ).append("\n"); 
		query.append("    ,EQ_CB4" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'G')" ).append("\n"); 
		query.append("    ,EQ_CG" ).append("\n"); 
		query.append("    ,EQ_UG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,TO_WGT" ).append("\n"); 
		query.append("    ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("    ,CFM_FLG" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${grid_flg} == 'Y')" ).append("\n"); 
		query.append("    ,CK_VF" ).append("\n"); 
		query.append("    ,NUM" ).append("\n"); 
		query.append("    ,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("    ,EQ_D3" ).append("\n"); 
		query.append("    ,EQ_D8" ).append("\n"); 
		query.append("    ,EQ_D9" ).append("\n"); 
		query.append("    ,EQ_DW" ).append("\n"); 
		query.append("    ,EQ_DX" ).append("\n"); 
		query.append("    ,ALL_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT ROWNUM NUM, X.*" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT  C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("               ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("               ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("               ,C.CGO_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(C.CUST_NOMI_TRKR_IND_CD, 'HJS', 'SML', C.CUST_NOMI_TRKR_IND_CD) AS CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("               ,DECODE(C.CUST_CNT_CD||C.CUST_SEQ, 'XX0', NULL, C.CUST_CNT_CD||C.CUST_SEQ) CUST_CD" ).append("\n"); 
		query.append("               ,DECODE(C.CMDT_GRP_CD, 'XXXX', NULL, C.CMDT_GRP_CD) CMDT_GRP_CD" ).append("\n"); 
		query.append("               ,DECODE(C.RAIL_SVC_TP_CD, '00', NULL, C.RAIL_SVC_TP_CD) RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("               ,D.TRSP_SCG_CD" ).append("\n"); 
		query.append("               ,D.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.FM_NOD_CD,1,5), '00000', NULL, SUBSTR(D.FM_NOD_CD,1,5)) AS FM_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.FM_NOD_CD,6), '00', NULL, SUBSTR(D.FM_NOD_CD,6)) AS FM_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.VIA_NOD_CD,1,5), '00000', NULL, SUBSTR(D.VIA_NOD_CD,1,5)) AS VIA_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.VIA_NOD_CD,6), '00', NULL, SUBSTR(D.VIA_NOD_CD,6)) AS VIA_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.DOR_NOD_CD,1,5), '00000', NULL, SUBSTR(D.DOR_NOD_CD,1,5)) AS DOR_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.DOR_NOD_CD,6), '00', NULL, SUBSTR(D.DOR_NOD_CD,6)) AS DOR_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.TO_NOD_CD,1,5), '00000', NULL, SUBSTR(D.TO_NOD_CD,1,5)) AS TO_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.TO_NOD_CD,6), '00', NULL, SUBSTR(D.TO_NOD_CD,6)) AS TO_NOD_YD" ).append("\n"); 
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
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'A5', 'Y')) EQ_A5" ).append("\n"); 
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
		query.append("               ,DECODE(E.CURR_CD, 'XXX', NULL, E.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("               ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("               ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("               ,DECODE(E.TO_WGT, '0', NULL, E.TO_WGT) TO_WGT" ).append("\n"); 
		query.append("               ,DECODE(E.WGT_MEAS_UT_CD, 'XXX', NULL, E.WGT_MEAS_UT_CD) WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')  AS EFF_FM_DT" ).append("\n"); 
		query.append("               ,TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')  AS EFF_TO_DT" ).append("\n"); 
		query.append("               ,'0' AS CK_VF" ).append("\n"); 
		query.append("               ,CASE WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,1,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                     WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,2,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                     WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,3,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                END ALL_TP_CD" ).append("\n"); 
		query.append("               ,AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("               ,E.CFM_FLG" ).append("\n"); 
		query.append("          FROM  TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("               ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("               ,TRS_AGMT_SCG_NOD   D" ).append("\n"); 
		query.append("               ,TRS_AGMT_SCG_RT E" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_SCG_NOD_SEQ  = E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD   = SUBSTR(@[fm_agmtno],1,3)" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ          = SUBSTR(@[fm_agmtno],4)" ).append("\n"); 
		query.append("           AND NVL(E.DELT_FLG, 'N')     = 'N'" ).append("\n"); 
		query.append("#if (${fm_trsp_agmt_rt_tp_ser_no} != '' )" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_SER_NO = @[fm_trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("       AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD) FROM DUAL) BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} != '' )" ).append("\n"); 
		query.append("      AND E.EQ_KND_CD = @[fm_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_cfm_flg} != '' )" ).append("\n"); 
		query.append("      AND E.CFM_FLG = @[fm_cfm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        GROUP BY C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                ,C.CGO_TP_CD" ).append("\n"); 
		query.append("                ,C.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                ,C.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("                ,C.CUST_CNT_CD||C.CUST_SEQ" ).append("\n"); 
		query.append("                ,C.CMDT_GRP_CD" ).append("\n"); 
		query.append("                ,C.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("                ,D.TRSP_SCG_CD" ).append("\n"); 
		query.append("                ,D.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("                ,SUBSTR(D.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("                ,SUBSTR(D.FM_NOD_CD,6)" ).append("\n"); 
		query.append("                ,SUBSTR(D.VIA_NOD_CD,1,5)" ).append("\n"); 
		query.append("                ,SUBSTR(D.VIA_NOD_CD,6)" ).append("\n"); 
		query.append("                ,SUBSTR(D.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("                ,SUBSTR(D.DOR_NOD_CD,6)" ).append("\n"); 
		query.append("                ,SUBSTR(D.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("                ,SUBSTR(D.TO_NOD_CD,6)" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("                ,E.CURR_CD" ).append("\n"); 
		query.append("                ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("                ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("                ,E.TO_WGT" ).append("\n"); 
		query.append("                ,E.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("                ,TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                ,TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                ,CASE WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,1,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,2,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,3,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("                ,AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("                ,E.CFM_FLG" ).append("\n"); 
		query.append("        ORDER BY D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                ,C.CGO_TP_CD" ).append("\n"); 
		query.append("                ,C.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                ,C.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("                ,C.CUST_CNT_CD || CUST_SEQ" ).append("\n"); 
		query.append("                ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                ,C.CMDT_GRP_CD" ).append("\n"); 
		query.append("                ,C.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("                ,SUBSTR(D.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("                ,SUBSTR(D.FM_NOD_CD,6)" ).append("\n"); 
		query.append("                ,SUBSTR(D.VIA_NOD_CD,1,5)" ).append("\n"); 
		query.append("                ,SUBSTR(D.VIA_NOD_CD,6)" ).append("\n"); 
		query.append("                ,SUBSTR(D.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("                ,SUBSTR(D.DOR_NOD_CD,6)" ).append("\n"); 
		query.append("                ,SUBSTR(D.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("                ,SUBSTR(D.TO_NOD_CD,6)" ).append("\n"); 
		query.append("                ,E.CURR_CD" ).append("\n"); 
		query.append("                ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("                ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("                ,E.TO_WGT" ).append("\n"); 
		query.append("                ,E.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("                ,TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                ,TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                ,CASE WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,1,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,2,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,3,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append(") XX" ).append("\n"); 
		query.append("#if (${grid_flg} == 'Y')" ).append("\n"); 
		query.append("WHERE NUM BETWEEN 1 + ((@[cur_page_cnt]-1)*@[page_size]) AND (@[cur_page_cnt]*@[page_size])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}