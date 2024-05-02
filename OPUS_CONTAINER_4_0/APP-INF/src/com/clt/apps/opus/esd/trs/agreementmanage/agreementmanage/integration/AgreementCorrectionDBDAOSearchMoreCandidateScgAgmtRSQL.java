/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementCorrectionDBDAOSearchMoreCandidateScgAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.31
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.10.31 김성욱
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

public class AgreementCorrectionDBDAOSearchMoreCandidateScgAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * More Candidate Surcharge Rate정보 조회
	  * </pre>
	  */
	public AgreementCorrectionDBDAOSearchMoreCandidateScgAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_loce",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loce",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loce",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_loce",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("basis_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOSearchMoreCandidateScgAgmtRSQL").append("\n"); 
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
		query.append("SELECT A.*, B.*" ).append("\n"); 
		query.append("	  ,C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	  ,C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	  ,C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	  ,C.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("	  ,C.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN DECODE(C.TRSP_AGMT_EQ_TP_SZ_CD, 'XXXX', '', C.TRSP_AGMT_EQ_TP_SZ_CD)" ).append("\n"); 
		query.append("            ELSE DECODE(D.TRSP_AGMT_EQ_TP_SZ_CD, 'XXXX', '', D.TRSP_AGMT_EQ_TP_SZ_CD)" ).append("\n"); 
		query.append("       END TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append("	  ,C.EQ_KND_CD" ).append("\n"); 
		query.append("	  ,DECODE(C.TO_WGT, 0, '', C.TO_WGT) TO_WGT" ).append("\n"); 
		query.append("	  ,DECODE(C.WGT_MEAS_UT_CD, 'XXX', '', C.WGT_MEAS_UT_CD) WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("	  ,C.EFF_FM_DT" ).append("\n"); 
		query.append("	  ,C.EFF_TO_DT" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN C.AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("            ELSE D.AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("       END AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN DECODE(C.CURR_CD, NULL, @[curr_cd], 'XXX', @[curr_cd], C.CURR_CD) " ).append("\n"); 
		query.append("            ELSE DECODE(D.CURR_CD, NULL, @[curr_cd], 'XXX', @[curr_cd], D.CURR_CD) " ).append("\n"); 
		query.append("       END CURR_CD" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN DECODE(C.AGMT_SCG_RT_DIV_CD, 'F', DECODE(@[fm_cost_mod_cd], 'DR', NVL(C.TRSP_RND_RT, C.TRSP_ONE_WY_RT)" ).append("\n"); 
		query.append("                                                                                 , NVL(C.TRSP_ONE_WY_RT, C.TRSP_RND_RT))" ).append("\n"); 
		query.append("                                            , 'R', ROUND((@[total_amt] * DECODE(@[fm_cost_mod_cd], 'DR', NVL(C.TRSP_RND_RT, C.TRSP_ONE_WY_RT), NVL(C.TRSP_ONE_WY_RT, C.TRSP_RND_RT)) / 100), 3))" ).append("\n"); 
		query.append("            ELSE DECODE(D.AGMT_SCG_RT_DIV_CD, 'F', DECODE(@[fm_cost_mod_cd], 'DR', D.TRSP_RND_RT" ).append("\n"); 
		query.append("                                                                                 , D.TRSP_ONE_WY_RT)" ).append("\n"); 
		query.append("                                            , 'R', ROUND((@[total_amt] * DECODE(@[fm_cost_mod_cd], 'DR', D.TRSP_RND_RT, D.TRSP_ONE_WY_RT) / 100), 3))" ).append("\n"); 
		query.append("       END TRSP_RT" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN DECODE(C.AGMT_SCG_RT_DIV_CD, 'F', C.TRSP_ONE_WY_RT, 'R', ROUND((@[total_amt] * C.TRSP_ONE_WY_RT / 100), 3))" ).append("\n"); 
		query.append("            ELSE DECODE(D.AGMT_SCG_RT_DIV_CD, 'F', D.TRSP_ONE_WY_RT, 'R', ROUND((@[total_amt] * D.TRSP_ONE_WY_RT / 100), 3))" ).append("\n"); 
		query.append("       END TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN DECODE(C.AGMT_SCG_RT_DIV_CD, 'F', C.TRSP_RND_RT, 'R', ROUND((@[total_amt] * C.TRSP_RND_RT / 100), 3))" ).append("\n"); 
		query.append("            ELSE DECODE(D.AGMT_SCG_RT_DIV_CD, 'F', D.TRSP_RND_RT, 'R', ROUND((@[total_amt] * D.TRSP_RND_RT / 100), 3))" ).append("\n"); 
		query.append("       END TRSP_RND_RT" ).append("\n"); 
		query.append("	  ,C.COM_SCG_APLY_FLG" ).append("\n"); 
		query.append("	  ,C.WO_APLY_FLG" ).append("\n"); 
		query.append("	  ,C.USR_DEF_RMK" ).append("\n"); 
		query.append("      ,A.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,C.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(C.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("	  ,H.*" ).append("\n"); 
		query.append("      ,F.INTG_CD_VAL_DP_DESC AS TRSP_SCG_NM" ).append("\n"); 
		query.append("      ,DECODE(DECODE(C.COM_SCG_APLY_FLG, '0', C.AGMT_SCG_RT_DIV_CD, D.AGMT_SCG_RT_DIV_CD), 'F', 'Fixed', 'R', 'Ratio') AS AGMT_SCG_RT_DIV_NM" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN DECODE(C.AGMT_SCG_RT_DIV_CD, 'F', '0.00', 'R', DECODE(@[fm_cost_mod_cd], 'DR', NVL(C.TRSP_RND_RT, C.TRSP_ONE_WY_RT), NVL(C.TRSP_ONE_WY_RT, C.TRSP_RND_RT)))" ).append("\n"); 
		query.append("            ELSE DECODE(D.AGMT_SCG_RT_DIV_CD, 'F', '0.00', 'R', DECODE(@[fm_cost_mod_cd], 'DR', D.TRSP_RND_RT, D.TRSP_ONE_WY_RT))" ).append("\n"); 
		query.append("       END AS RATIO" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN NULL" ).append("\n"); 
		query.append("            ELSE D.COM_SCG_KND_CD" ).append("\n"); 
		query.append("       END AS COM_SCG_KND_CD" ).append("\n"); 
		query.append("      ,CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("            THEN NULL" ).append("\n"); 
		query.append("            ELSE D.COM_SCG_SEQ" ).append("\n"); 
		query.append("       END AS COM_SCG_SEQ" ).append("\n"); 
		query.append("     ,(SELECT ROUND((X1.USD_LOCL_XCH_RT / X2.USD_LOCL_XCH_RT),6) AS RATE" ).append("\n"); 
		query.append("         FROM GL_MON_XCH_RT X1" ).append("\n"); 
		query.append("            , GL_MON_XCH_RT X2" ).append("\n"); 
		query.append("        WHERE X1.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[basis_dt],'-',''),1,6) -- S/O Creation Date" ).append("\n"); 
		query.append("          AND X1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("          AND X1.CURR_CD = @[curr_cd] -- BZC Currency" ).append("\n"); 
		query.append("          AND X2.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[basis_dt],'-',''),1,6) -- S/O Creation Date" ).append("\n"); 
		query.append("          AND X2.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("          AND X2.CURR_CD = CASE WHEN C.COM_SCG_APLY_FLG = '0' " ).append("\n"); 
		query.append("                                THEN DECODE(C.CURR_CD, NULL, @[curr_cd], 'XXX', @[curr_cd], C.CURR_CD) " ).append("\n"); 
		query.append("                                ELSE DECODE(D.CURR_CD, NULL, @[curr_cd], 'XXX', @[curr_cd], D.CURR_CD) " ).append("\n"); 
		query.append("                            END -- SCG Currency" ).append("\n"); 
		query.append("          AND X1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("          AND X2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      ) AS WO_SCG_XCH_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT * FROM TRS_AGMT_RT_TP" ).append("\n"); 
		query.append("         WHERE TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[agmt_no], 1, 3)" ).append("\n"); 
		query.append("           AND TRSP_AGMT_SEQ = SUBSTR(@[agmt_no], 4)" ).append("\n"); 
		query.append("           AND TRSP_AGMT_RT_TP_SER_NO = @[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("           AND CGO_TP_CD=DECODE(@[fm_cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')" ).append("\n"); 
		query.append("           AND TRSP_COST_MOD_CD = DECODE(@[fm_cost_mod_cd], 'DR', 'DR', 'CY')" ).append("\n"); 
		query.append("           AND AGMT_TRSP_TP_CD = @[fm_crr_mod_cd]" ).append("\n"); 
		query.append("#if(${trsp_bnd_cd} == 'T')" ).append("\n"); 
		query.append("           AND (TRSP_BND_CD IS NULL OR TRSP_BND_CD IN ('Y','0'))" ).append("\n"); 
		query.append("#else                     -- TRSP_BND_CD : not T(I,O,NULL)" ).append("\n"); 
		query.append("           AND (TRSP_BND_CD IS NULL OR TRSP_BND_CD IN ('N','0'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${spcl_cgo_cntr_tp_cd} != '')" ).append("\n"); 
		query.append("           AND (SPCL_CGO_CNTR_TP_CD IS NULL OR SPCL_CGO_CNTR_TP_CD = @[spcl_cgo_cntr_tp_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ) A" ).append("\n"); 
		query.append("    ,TRS_AGMT_SCG_NOD B" ).append("\n"); 
		query.append("    ,TRS_AGMT_SCG_RT C" ).append("\n"); 
		query.append("    ,(SELECT COM_SCG_KND_CD, MAX(EQ_TPSZ_CD) TRSP_AGMT_EQ_TP_SZ_CD, MAX(CURR_CD) CURR_CD, MAX(RT_TP_CD) AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("            ,DECODE(@[fm_cost_mod_cd], 'DR', 0, SUM(NVL(ONE_WY_RT, RND_RT))) TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("            ,DECODE(@[fm_cost_mod_cd], 'DR', SUM(NVL(RND_RT, ONE_WY_RT)), 0) TRSP_RND_RT" ).append("\n"); 
		query.append("            ,DECODE(@[fm_cost_mod_cd], 'DR', SUM(NVL(RND_RT, ONE_WY_RT)), SUM(NVL(ONE_WY_RT, RND_RT))) ETC_ADD_AMT" ).append("\n"); 
		query.append("            ,COM_SCG_SEQ" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("               SELECT COM_SCG_KND_CD, ONE_WY_RT, RND_RT, EQ_TPSZ_CD, CURR_CD, RT_TP_CD" ).append("\n"); 
		query.append("                    , ROW_NUMBER() OVER (ORDER BY SCC_CD, LCC_CD, RCC_CD, BND_CD" ).append("\n"); 
		query.append("                                                 ,DECODE(EQ_TPSZ_CD, @[eq_tpsz_cd],1, 'ALAL', 2, SUBSTR(@[eq_tpsz_cd], 1, 1) || 'AL', 3, " ).append("\n"); 
		query.append("                                                                     'AL' || SUBSTR(@[eq_tpsz_cd], 2, 1), 4) ASC) RN" ).append("\n"); 
		query.append("                    , COM_SCG_SEQ" ).append("\n"); 
		query.append("                 FROM TRS_COM_SCG_MGMT" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND TRSP_COST_MOD_CD = DECODE(@[fm_cost_mod_cd], 'DR', 'DR', 'CY')" ).append("\n"); 
		query.append("                  AND AGMT_TRSP_TP_CD  = @[fm_crr_mod_cd]" ).append("\n"); 
		query.append("                  AND (SCC_CD = MST_LOC_FNC(SUBSTR(@[fm_loce], 1, 5),'SCC') OR" ).append("\n"); 
		query.append("		               LCC_CD IN (MST_LOC_FNC(SUBSTR(@[fm_loce], 1, 5),'LCC')) OR" ).append("\n"); 
		query.append("		               RCC_CD IN (MST_LOC_FNC(SUBSTR(@[fm_loce], 1, 5),'RCC'))" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                  AND NVL(CGO_TP_CD, DECODE(@[fm_cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')) = DECODE(@[fm_cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')" ).append("\n"); 
		query.append("                  AND NVL(BND_CD, NVL(@[trsp_bnd_cd],'X')) = NVL(@[trsp_bnd_cd],'X')" ).append("\n"); 
		query.append("                  AND SUBSTR(@[basis_dt],1,10) BETWEEN TO_CHAR(EFF_FM_DT,'YYYY-MM-DD') AND TO_CHAR(EFF_TO_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("--       WHERE RN = 1" ).append("\n"); 
		query.append("       GROUP BY COM_SCG_KND_CD" ).append("\n"); 
		query.append("               ,COM_SCG_SEQ" ).append("\n"); 
		query.append("     ) D" ).append("\n"); 
		query.append("    ,(SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_SEQ, INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE INTG_CD_ID = 'CD30002') F" ).append("\n"); 
		query.append("    , TRS_AGMT_HDR H" ).append("\n"); 
		query.append(" WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("   AND ((" ).append("\n"); 
		query.append("              B.FM_NOD_CD  = DECODE(LENGTH(DECODE(B.FM_NOD_CD,'0000000', NULL, B.FM_NOD_CD)), 7, @[fm_loce]||@[fm_yard], 5, @[fm_loce], '0000000')" ).append("\n"); 
		query.append("          AND B.VIA_NOD_CD = DECODE(LENGTH(DECODE(B.VIA_NOD_CD,'0000000', NULL, B.VIA_NOD_CD)), 7, @[via_loce]||@[via_yard], 5, @[via_loce], '0000000')" ).append("\n"); 
		query.append("          AND B.DOR_NOD_CD = DECODE(LENGTH(DECODE(B.DOR_NOD_CD,'0000000', NULL, B.DOR_NOD_CD)), 7, @[dor_loce]||@[dor_yard], 5, @[dor_loce], '0000000')" ).append("\n"); 
		query.append("          AND B.TO_NOD_CD  = DECODE(LENGTH(DECODE(B.TO_NOD_CD,'0000000', NULL, B.TO_NOD_CD)), 7, @[to_loce]||@[to_yard], 5, @[to_loce], '0000000')" ).append("\n"); 
		query.append("       ) OR (" ).append("\n"); 
		query.append("              B.FM_NOD_CD  = '0000000'" ).append("\n"); 
		query.append("          AND B.VIA_NOD_CD = '0000000'" ).append("\n"); 
		query.append("          AND B.DOR_NOD_CD = '0000000'" ).append("\n"); 
		query.append("          AND B.TO_NOD_CD  = '0000000'" ).append("\n"); 
		query.append("       ))" ).append("\n"); 
		query.append("   AND B.TRSP_SCG_CD            = F.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND B.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND B.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("   AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("   AND B.TRSP_AGMT_SCG_NOD_SEQ = C.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("         C.TRSP_AGMT_EQ_TP_SZ_CD IN (@[eq_tpsz_cd], 'AL'||SUBSTR(@[eq_tpsz_cd],2), SUBSTR(@[eq_tpsz_cd],1,1)||'AL', 'ALAL')" ).append("\n"); 
		query.append("         OR" ).append("\n"); 
		query.append("         (C.COM_SCG_APLY_FLG = '1' AND C.TRSP_AGMT_EQ_TP_SZ_CD = 'XXXX')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND SUBSTR(@[basis_dt],1,10) BETWEEN TO_CHAR(C.EFF_FM_DT,'YYYY-MM-DD') AND TO_CHAR(C.EFF_TO_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("   AND (C.COM_SCG_APLY_FLG = '0' OR " ).append("\n"); 
		query.append("        (C.COM_SCG_APLY_FLG = '1' AND (D.TRSP_RND_RT IS NOT NULL OR D.TRSP_ONE_WY_RT IS NOT NULL))" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_OFC_CTY_CD   = H.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_SEQ          = H.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("   AND B.TRSP_SCG_CD            = D.COM_SCG_KND_CD(+)" ).append("\n"); 
		query.append(" ORDER BY F.INTG_CD_VAL_DP_DESC" ).append("\n"); 

	}
}