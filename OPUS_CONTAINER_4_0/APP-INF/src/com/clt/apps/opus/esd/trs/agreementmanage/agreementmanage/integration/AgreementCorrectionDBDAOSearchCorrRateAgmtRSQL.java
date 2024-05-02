/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementCorrectionDBDAOSearchCorrRateAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.07.06 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAOSearchCorrRateAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Rate 정보 조회
	  * </pre>
	  */
	public AgreementCorrectionDBDAOSearchCorrRateAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dor_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_to_nod",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_trsp_agmt_dist",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_fm_nod",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_via_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_size",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOSearchCorrRateAgmtRSQL").append("\n"); 
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
		query.append("SELECT    " ).append("\n"); 
		query.append("    'Cost Mode'" ).append("\n"); 
		query.append("    ,'Trans Mode'" ).append("\n"); 
		query.append("    ,'Bound'" ).append("\n"); 
		query.append("    ,'Cargo Type'" ).append("\n"); 
		query.append("    ,'Cargo Nature'" ).append("\n"); 
		query.append("    ,'Customer Code'   " ).append("\n"); 
		query.append("    ,'Commodity Group Code'" ).append("\n"); 
		query.append("    ,'Rail Service Type'" ).append("\n"); 
		query.append("    ,'Loc'" ).append("\n"); 
		query.append("    ,'Node'" ).append("\n"); 
		query.append("    ,'Loc'" ).append("\n"); 
		query.append("    ,'Node'" ).append("\n"); 
		query.append("    ,'Loc'" ).append("\n"); 
		query.append("    ,'Node'" ).append("\n"); 
		query.append("    ,'Loc'" ).append("\n"); 
		query.append("    ,'Node'" ).append("\n"); 
		query.append("    ,'Fixed or Per Distance'" ).append("\n"); 
		query.append("    ,'Distance'" ).append("\n"); 
		query.append("    ,'Unit'" ).append("\n"); 
		query.append("    ,'Currency'" ).append("\n"); 
		query.append("    ,'ALAL'" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')     " ).append("\n"); 
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
		query.append("#if (${fm_eq_knd_cd} != 'G')    " ).append("\n"); 
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
		query.append("    ,'A2'" ).append("\n"); 
		query.append("    ,'A4'" ).append("\n"); 
		query.append("    ,'F2'" ).append("\n"); 
		query.append("    ,'F4'" ).append("\n"); 
		query.append("    ,'F5'" ).append("\n"); 
		query.append("    ,'T2'" ).append("\n"); 
		query.append("    ,'T4'" ).append("\n"); 
		query.append("    ,'S2'" ).append("\n"); 
		query.append("    ,'S4'" ).append("\n"); 
		query.append("    ,'O2'" ).append("\n"); 
		query.append("    ,'O4'" ).append("\n"); 
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
		query.append("#end    " ).append("\n"); 
		query.append("    ,'One Way'" ).append("\n"); 
		query.append("    ,'Round Trip'" ).append("\n"); 
		query.append("    ,'Receiving'" ).append("\n"); 
		query.append("    ,'Delivery'" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')  " ).append("\n"); 
		query.append("    ,'No of Container'" ).append("\n"); 
		query.append("    ,'Weight Tier'" ).append("\n"); 
		query.append("    ,'UOM'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'Z')" ).append("\n"); 
		query.append("    ,'No of Chassis'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'G')" ).append("\n"); 
		query.append("    ,'No of Genset'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,'Reverse'" ).append("\n"); 
		query.append("    ,'COA'" ).append("\n"); 
		query.append("    ,'From'" ).append("\n"); 
		query.append("    ,'To'" ).append("\n"); 
		query.append("    ,'UDU'" ).append("\n"); 
		query.append("    ,'UDU2'" ).append("\n"); 
		query.append("    ,'Eq Kind Cd'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("    ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("    ,TRSP_BND_CD" ).append("\n"); 
		query.append("    ,CGO_TP_CD" ).append("\n"); 
		query.append("    ,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("    ,CUST_CD" ).append("\n"); 
		query.append("    ,CMDT_GRP_CD" ).append("\n"); 
		query.append("    ,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("    ,FM_NOD_CD" ).append("\n"); 
		query.append("    ,FM_NOD_YD" ).append("\n"); 
		query.append("    ,VIA_NOD_CD" ).append("\n"); 
		query.append("    ,VIA_NOD_YD" ).append("\n"); 
		query.append("    ,DOR_NOD_CD" ).append("\n"); 
		query.append("    ,DOR_NOD_YD" ).append("\n"); 
		query.append("    ,TO_NOD_CD" ).append("\n"); 
		query.append("    ,TO_NOD_YD" ).append("\n"); 
		query.append("    ,TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("    ,TRSP_AGMT_DIST" ).append("\n"); 
		query.append("    ,DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("    ,CURR_CD" ).append("\n"); 
		query.append("    ,EQ_ALAL" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')  " ).append("\n"); 
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
		query.append("#if (${fm_eq_knd_cd} != 'G')    " ).append("\n"); 
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
		query.append("    ,EQ_A2" ).append("\n"); 
		query.append("    ,EQ_A4" ).append("\n"); 
		query.append("    ,EQ_F2" ).append("\n"); 
		query.append("    ,EQ_F4" ).append("\n"); 
		query.append("    ,EQ_F5" ).append("\n"); 
		query.append("    ,EQ_T2" ).append("\n"); 
		query.append("    ,EQ_T4" ).append("\n"); 
		query.append("    ,EQ_S2" ).append("\n"); 
		query.append("    ,EQ_S4" ).append("\n"); 
		query.append("    ,EQ_O2" ).append("\n"); 
		query.append("    ,EQ_O4" ).append("\n"); 
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
		query.append("#end   " ).append("\n"); 
		query.append("    ,TO_CHAR(TRSP_ONE_WY_RT) AS TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("    ,TO_CHAR(TRSP_RND_RT) AS TRSP_RND_RT" ).append("\n"); 
		query.append("    ,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("    ,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("    ,TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')  " ).append("\n"); 
		query.append("    ,TO_WGT" ).append("\n"); 
		query.append("    ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("    ,TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("    ,AGMT_COST_FLG " ).append("\n"); 
		query.append("    ,EFF_FM_DT" ).append("\n"); 
		query.append("    ,EFF_TO_DT" ).append("\n"); 
		query.append("    ,USR_DEF_RMK" ).append("\n"); 
		query.append("    ,USR_DEF_RMK AS ORG_USR_DEF_RMK" ).append("\n"); 
		query.append("    ,EQ_KND_CD" ).append("\n"); 
		query.append("#if (${grid_flg} == 'Y')" ).append("\n"); 
		query.append("    ,NUM" ).append("\n"); 
		query.append("    ,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("    ,EQ_D3" ).append("\n"); 
		query.append("    ,EQ_D8" ).append("\n"); 
		query.append("    ,EQ_D9" ).append("\n"); 
		query.append("    ,EQ_DW" ).append("\n"); 
		query.append("    ,EQ_DX" ).append("\n"); 
		query.append("    ,CK_VF" ).append("\n"); 
		query.append("    ,ALL_TP_CD" ).append("\n"); 
		query.append("    ,TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("    ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("    ,TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("    ,TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,EQ_ALAL_RT_SEQ" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')  " ).append("\n"); 
		query.append("    ,EQ_DAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_RAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_AAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_FAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_TAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_SAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_OAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_PAL_RT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'Z')" ).append("\n"); 
		query.append("    ,EQ_SFAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_SLAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_TAAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_GNAL_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_EGAL_RT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} != 'G')    " ).append("\n"); 
		query.append("    ,EQ_AL2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_AL4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_AL5_RT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("    ,EQ_AL7_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_AL9_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_D2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_D4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_D5_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_D7_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_R2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_R4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_R5_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_R7_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_A2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_A4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_F2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_F4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_F5_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_T2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_T4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_S2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_S4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_O2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_O4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_P2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_P4_RT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'Z')" ).append("\n"); 
		query.append("    ,EQ_AL8_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_SF2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_SF4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_SL2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_TA2_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_GN4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_GN5_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_EG5_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_EG8_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_ZT4_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_CB4_RT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_eq_knd_cd} == 'G')" ).append("\n"); 
		query.append("    ,EQ_CG_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_UG_RT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${grid_flg} == 'Y')" ).append("\n"); 
		query.append("    ,EQ_D3_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_D8_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_D9_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_DW_RT_SEQ" ).append("\n"); 
		query.append("    ,EQ_DX_RT_SEQ" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT ROWNUM NUM, X.*" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT  C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("               ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("               ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(C.TRSP_BND_CD, '0', NULL, C.TRSP_BND_CD) AS TRSP_BND_CD" ).append("\n"); 
		query.append("               ,DECODE(C.CGO_TP_CD, '0', NULL, C.CGO_TP_CD) AS CGO_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(C.SPCL_CGO_CNTR_TP_CD, '00', NULL, C.SPCL_CGO_CNTR_TP_CD) AS SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(C.CUST_CNT_CD||C.CUST_SEQ, 'XX0', NULL, C.CUST_CNT_CD||C.CUST_SEQ) CUST_CD" ).append("\n"); 
		query.append("               ,DECODE(C.CMDT_GRP_CD, 'XXXX', NULL, C.CMDT_GRP_CD) CMDT_GRP_CD" ).append("\n"); 
		query.append("               ,DECODE(C.RAIL_SVC_TP_CD, '00', NULL, C.RAIL_SVC_TP_CD) RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.FM_NOD_CD,1,5), '00000', NULL, SUBSTR(D.FM_NOD_CD,1,5)) AS FM_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.FM_NOD_CD,6), '00', NULL, SUBSTR(D.FM_NOD_CD,6)) AS FM_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.VIA_NOD_CD,1,5), '00000', NULL, SUBSTR(D.VIA_NOD_CD,1,5)) AS VIA_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.VIA_NOD_CD,6), '00', NULL, SUBSTR(D.VIA_NOD_CD,6)) AS VIA_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.DOR_NOD_CD,1,5), '00000', NULL, SUBSTR(D.DOR_NOD_CD,1,5)) AS DOR_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.DOR_NOD_CD,6), '00', NULL, SUBSTR(D.DOR_NOD_CD,6)) AS DOR_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.TO_NOD_CD,1,5), '00000', NULL, SUBSTR(D.TO_NOD_CD,1,5)) AS TO_NOD_CD" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(D.TO_NOD_CD,6), '00', NULL, SUBSTR(D.TO_NOD_CD,6)) AS TO_NOD_YD" ).append("\n"); 
		query.append("               ,DECODE(D.TRSP_DIST_TP_CD, 'X', NULL, D.TRSP_DIST_TP_CD) TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(D.TRSP_AGMT_DIST, '0', NULL, D.TRSP_AGMT_DIST) TRSP_AGMT_DIST" ).append("\n"); 
		query.append("               ,DECODE(D.DIST_MEAS_UT_CD, 'XX', NULL, D.DIST_MEAS_UT_CD) DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D2', '1')) EQ_D2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D3', '1')) EQ_D3" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D4', '1')) EQ_D4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D5', '1')) EQ_D5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D7', '1')) EQ_D7" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D8', '1')) EQ_D8" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D9', '1')) EQ_D9" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DW', '1')) EQ_DW" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DX', '1')) EQ_DX" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R2', '1')) EQ_R2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R4', '1')) EQ_R4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R5', '1')) EQ_R5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R7', '1')) EQ_R7" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'A2', '1')) EQ_A2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'A4', '1')) EQ_A4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F2', '1')) EQ_F2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F4', '1')) EQ_F4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F5', '1')) EQ_F5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'T2', '1')) EQ_T2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'T4', '1')) EQ_T4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'S2', '1')) EQ_S2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'S4', '1')) EQ_S4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'O2', '1')) EQ_O2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'O4', '1')) EQ_O4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'P2', '1')) EQ_P2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'P4', '1')) EQ_P4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SF2', '1')) EQ_SF2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SF4', '1')) EQ_SF4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SL2', '1')) EQ_SL2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TA2', '1')) EQ_TA2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GN4', '1')) EQ_GN4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GN5', '1')) EQ_GN5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EG5', '1')) EQ_EG5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EG8', '1')) EQ_EG8" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'ZT4', '1')) EQ_ZT4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'CB4', '1')) EQ_CB4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'CG', '1'))  EQ_CG" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'UG', '1'))  EQ_UG" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'ALAL', '1')) EQ_ALAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DAL', '1'))  EQ_DAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'RAL', '1'))  EQ_RAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AAL', '1'))  EQ_AAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'FAL', '1'))  EQ_FAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TAL', '1'))  EQ_TAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SAL', '1'))  EQ_SAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'OAL', '1'))  EQ_OAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'PAL', '1'))  EQ_PAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL2', '1'))  EQ_AL2" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL4', '1'))  EQ_AL4" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL5', '1'))  EQ_AL5" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL7', '1'))  EQ_AL7" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL8', '1'))  EQ_AL8" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL9', '1'))  EQ_AL9" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SFAL', '1'))  EQ_SFAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SLAL', '1'))  EQ_SLAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TAAL', '1'))  EQ_TAAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GNAL', '1'))  EQ_GNAL" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EGAL', '1'))  EQ_EGAL" ).append("\n"); 
		query.append("               ----------------------------------------------------------" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D2', E.TRSP_AGMT_RT_SEQ)) EQ_D2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D3', E.TRSP_AGMT_RT_SEQ)) EQ_D3_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D4', E.TRSP_AGMT_RT_SEQ)) EQ_D4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D5', E.TRSP_AGMT_RT_SEQ)) EQ_D5_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D7', E.TRSP_AGMT_RT_SEQ)) EQ_D7_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D8', E.TRSP_AGMT_RT_SEQ)) EQ_D8_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'D9', E.TRSP_AGMT_RT_SEQ)) EQ_D9_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DW', E.TRSP_AGMT_RT_SEQ)) EQ_DW_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DX', E.TRSP_AGMT_RT_SEQ)) EQ_DX_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R2', E.TRSP_AGMT_RT_SEQ)) EQ_R2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R4', E.TRSP_AGMT_RT_SEQ)) EQ_R4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R5', E.TRSP_AGMT_RT_SEQ)) EQ_R5_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'R7', E.TRSP_AGMT_RT_SEQ)) EQ_R7_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'A2', E.TRSP_AGMT_RT_SEQ)) EQ_A2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'A4', E.TRSP_AGMT_RT_SEQ)) EQ_A4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F2', E.TRSP_AGMT_RT_SEQ)) EQ_F2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F4', E.TRSP_AGMT_RT_SEQ)) EQ_F4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'F5', E.TRSP_AGMT_RT_SEQ)) EQ_F5_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'T2', E.TRSP_AGMT_RT_SEQ)) EQ_T2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'T4', E.TRSP_AGMT_RT_SEQ)) EQ_T4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'S2', E.TRSP_AGMT_RT_SEQ)) EQ_S2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'S4', E.TRSP_AGMT_RT_SEQ)) EQ_S4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'O2', E.TRSP_AGMT_RT_SEQ)) EQ_O2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'O4', E.TRSP_AGMT_RT_SEQ)) EQ_O4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'P2', E.TRSP_AGMT_RT_SEQ)) EQ_P2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'P4', E.TRSP_AGMT_RT_SEQ)) EQ_P4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SF2', E.TRSP_AGMT_RT_SEQ)) EQ_SF2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SF4', E.TRSP_AGMT_RT_SEQ)) EQ_SF4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SL2', E.TRSP_AGMT_RT_SEQ)) EQ_SL2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TA2', E.TRSP_AGMT_RT_SEQ)) EQ_TA2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GN4', E.TRSP_AGMT_RT_SEQ)) EQ_GN4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GN5', E.TRSP_AGMT_RT_SEQ)) EQ_GN5_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EG5', E.TRSP_AGMT_RT_SEQ)) EQ_EG5_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EG8', E.TRSP_AGMT_RT_SEQ)) EQ_EG8_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'ZT4', E.TRSP_AGMT_RT_SEQ)) EQ_ZT4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'CB4', E.TRSP_AGMT_RT_SEQ)) EQ_CB4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'CG', E.TRSP_AGMT_RT_SEQ))  EQ_CG_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'UG', E.TRSP_AGMT_RT_SEQ))  EQ_UG_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'ALAL', E.TRSP_AGMT_RT_SEQ)) EQ_ALAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'DAL', E.TRSP_AGMT_RT_SEQ))  EQ_DAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'RAL', E.TRSP_AGMT_RT_SEQ))  EQ_RAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AAL', E.TRSP_AGMT_RT_SEQ))  EQ_AAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'FAL', E.TRSP_AGMT_RT_SEQ))  EQ_FAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TAL', E.TRSP_AGMT_RT_SEQ))  EQ_TAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SAL', E.TRSP_AGMT_RT_SEQ))  EQ_SAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'OAL', E.TRSP_AGMT_RT_SEQ))  EQ_OAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'PAL', E.TRSP_AGMT_RT_SEQ))  EQ_PAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL2', E.TRSP_AGMT_RT_SEQ))  EQ_AL2_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL4', E.TRSP_AGMT_RT_SEQ))  EQ_AL4_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL5', E.TRSP_AGMT_RT_SEQ))  EQ_AL5_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL7', E.TRSP_AGMT_RT_SEQ))  EQ_AL7_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL8', E.TRSP_AGMT_RT_SEQ))  EQ_AL8_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'AL9', E.TRSP_AGMT_RT_SEQ))  EQ_AL9_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SFAL', E.TRSP_AGMT_RT_SEQ))  EQ_SFAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'SLAL', E.TRSP_AGMT_RT_SEQ))  EQ_SLAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'TAAL', E.TRSP_AGMT_RT_SEQ))  EQ_TAAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'GNAL', E.TRSP_AGMT_RT_SEQ))  EQ_GNAL_RT_SEQ" ).append("\n"); 
		query.append("               ,MAX(DECODE(E.TRSP_AGMT_EQ_TP_SZ_CD, 'EGAL', E.TRSP_AGMT_RT_SEQ))  EQ_EGAL_RT_SEQ" ).append("\n"); 
		query.append("               ----------------------------------------------------------" ).append("\n"); 
		query.append("               ,DECODE(E.CURR_CD, 'XXX', NULL, E.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("               ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("               ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("               ,DECODE(E.WTR_RCV_TERM_CD, '0', NULL, E.WTR_RCV_TERM_CD) WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("               ,DECODE(E.WTR_DE_TERM_CD, '0', NULL, E.WTR_DE_TERM_CD) WTR_DE_TERM_CD" ).append("\n"); 
		query.append("               ,DECODE(E.TRSP_AGMT_BDL_QTY, '0', NULL, E.TRSP_AGMT_BDL_QTY) TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("               ,DECODE(E.TO_WGT, '0', NULL, '999999.99', 'MAX', E.TO_WGT) TO_WGT" ).append("\n"); 
		query.append("               ,DECODE(E.WGT_MEAS_UT_CD, 'XXX', NULL, E.WGT_MEAS_UT_CD) WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("               ,MAX(E.TRSP_RVS_APLY_FLG) TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("               ,E.AGMT_COST_FLG AGMT_COST_FLG " ).append("\n"); 
		query.append("               ,TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')  AS EFF_FM_DT" ).append("\n"); 
		query.append("               ,TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')  AS EFF_TO_DT" ).append("\n"); 
		query.append("               ,'0' AS CK_VF" ).append("\n"); 
		query.append("               ,CASE WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,1,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                     WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,2,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                     WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,3,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                END ALL_TP_CD" ).append("\n"); 
		query.append("               ,E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("               ,E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("               ,E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("               ,E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("               ,MAX(E.TRSP_AGMT_RT_SEQ) AS TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("               ,E.USR_DEF_RMK" ).append("\n"); 
		query.append("               ,MAX(E.EQ_KND_CD) AS EQ_KND_CD" ).append("\n"); 
		query.append("          FROM  TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("               ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("               ,TRS_AGMT_NOD   D" ).append("\n"); 
		query.append("               ,TRS_AGMT_EQ_RT E" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_NOD_SEQ      = E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[fm_agmtno],1,3)" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ        = SUBSTR(@[fm_agmtno],4)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("       AND (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD),'YYYYMMDD') FROM DUAL) BETWEEN TO_CHAR(E.EFF_FM_DT,'YYYYMMDD') AND TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${fm_eq_knd_cd} != '' )" ).append("\n"); 
		query.append("        AND E.EQ_KND_CD = @[fm_eq_knd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fm_trsp_agmt_rt_tp_ser_no} != '' )" ).append("\n"); 
		query.append("        AND C.TRSP_AGMT_RT_TP_SER_NO = @[fm_trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${fm_fm_nod} != '' )" ).append("\n"); 
		query.append("        AND D.FM_NOD_CD LIKE @[fm_fm_nod]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fm_via_nod} != '' )" ).append("\n"); 
		query.append("        AND D.VIA_NOD_CD LIKE @[fm_via_nod]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fm_to_nod} != '' )" ).append("\n"); 
		query.append("        AND D.TO_NOD_CD LIKE @[fm_to_nod]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fm_dor_nod} != '' )" ).append("\n"); 
		query.append("        AND D.DOR_NOD_CD LIKE @[fm_dor_nod]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fm_trsp_agmt_dist} != '' )" ).append("\n"); 
		query.append("        AND D.TRSP_AGMT_DIST = @[fm_trsp_agmt_dist]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        GROUP BY C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                ,C.TRSP_BND_CD" ).append("\n"); 
		query.append("                ,C.CGO_TP_CD" ).append("\n"); 
		query.append("                ,C.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                ,C.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                ,C.CUST_CNT_CD||C.CUST_SEQ" ).append("\n"); 
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
		query.append("                ,D.TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_DIST" ).append("\n"); 
		query.append("                ,D.DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("                ,E.CURR_CD" ).append("\n"); 
		query.append("                ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("                ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("                ,E.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                ,E.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                ,E.TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("                ,E.TO_WGT" ).append("\n"); 
		query.append("                ,E.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("                ,TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                ,TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                ,CASE WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,1,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,2,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,3,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("                ,E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                ,E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                ,E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("                ,E.USR_DEF_RMK" ).append("\n"); 
		query.append("                ,E.AGMT_COST_FLG" ).append("\n"); 
		query.append("        ORDER BY D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                ,C.CGO_TP_CD" ).append("\n"); 
		query.append("                ,C.CUST_NOMI_TRKR_FLG" ).append("\n"); 
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
		query.append("                ,E.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                ,E.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                ,E.TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("                ,E.TO_WGT" ).append("\n"); 
		query.append("                ,E.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("                ,TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                ,TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                ,CASE WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,1,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,2,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,3,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append(") XX" ).append("\n"); 
		query.append("#if (${grid_flg} == 'Y')" ).append("\n"); 
		query.append("WHERE NUM BETWEEN 1 + ((@[cur_page_cnt]-1)*@[page_size]) AND (@[cur_page_cnt]*@[page_size])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}