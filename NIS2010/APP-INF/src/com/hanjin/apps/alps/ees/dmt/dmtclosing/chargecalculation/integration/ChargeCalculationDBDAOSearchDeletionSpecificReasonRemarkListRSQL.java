/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchDeletionSpecificReasonRemarkListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.12.29 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchDeletionSpecificReasonRemarkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchDeletionSpecificReasonRemarkListRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchDeletionSpecificReasonRemarkListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_path_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchDeletionSpecificReasonRemarkListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.*" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("        SELECT	/*+ INDEX_DESC(BKG_EUR_TRO XPKBKG_EUR_TRO) */" ).append("\n"); 
		query.append("                NVL(HLG_TP_CD, 'N')" ).append("\n"); 
		query.append("        FROM	BKG_EUR_TRO" ).append("\n"); 
		query.append("        WHERE	BKG_NO              = A.BKG_NO" ).append("\n"); 
		query.append("        AND     IO_BND_CD           = SUBSTR(A.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("        AND     NVL(CXL_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("        AND     CNTR_NO	            = A.CNTR_NO" ).append("\n"); 
		query.append("        AND     ROWNUM              = 1" ).append("\n"); 
		query.append("        ) as CH" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("select  T1.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("       ,T1.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("       ,T1.CNTR_CYC_NO AS CNTR_CYC_NO" ).append("\n"); 
		query.append("       ,T1.DMDT_TRF_CD AS " ).append("\n"); 
		query.append("       ,T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,T1.CHG_SEQ" ).append("\n"); 
		query.append("       ,T1.CHG_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("	   ,T1.DELT_SEQ" ).append("\n"); 
		query.append("       ,T3.BKG_NO" ).append("\n"); 
		query.append("       ,DECODE(T1.CHG_SEQ,1,'G','B') AS CHG_TYPE" ).append("\n"); 
		query.append("	   ,T3.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,T1.DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append("       ,T1.DELT_RMK" ).append("\n"); 
		query.append("       ,T1.DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append("       ,( SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("            FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("           WHERE INTG_CD_ID = 'CD03382' " ).append("\n"); 
		query.append("             AND INTG_CD_VAL_CTNT = T1.DMDT_DELT_RQST_STS_CD ) AS STS_CD" ).append("\n"); 
		query.append("       ,T1.INACT_RQST_NO" ).append("\n"); 
		query.append("       ,T1.INACT_APRO_NO " ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,1,T2.DELT_RMK,'')) DETAIL_1_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,2,T2.DELT_RMK,'')) DETAIL_2_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,3,T2.DELT_RMK,'')) DETAIL_3_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,4,T2.DELT_RMK,'')) DETAIL_4_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,5,T2.DELT_RMK,'')) DETAIL_5_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,6,T2.DELT_RMK,'')) DETAIL_6_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,7,T2.DELT_RMK,'')) DETAIL_7_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,8,T2.DELT_RMK,'')) DETAIL_8_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,9,T2.DELT_RMK,'')) DETAIL_9_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,MAX(case" ).append("\n"); 
		query.append("			when decode(@[chg_delt_path_cd], 'BBG', 1, 'RHQ', 2, 'HDO', 3, 0) >= " ).append("\n"); 
		query.append("				 (" ).append("\n"); 
		query.append("					select  max(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("					  from  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("					 where  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   and  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("					   and  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   and  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   and  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   and  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("					   and  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("					   and  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("					   and  (CHG_DELT_PATH_CPLS_FLG = 'Y' or CHG_DELT_STS_CD in ('A', 'J'))" ).append("\n"); 
		query.append("				 ) " ).append("\n"); 
		query.append("				 then " ).append("\n"); 
		query.append("				 (" ).append("\n"); 
		query.append("					case " ).append("\n"); 
		query.append("						when @[chg_delt_path_cd] = 'RHQ' and T1.RQST_OFC_CD in ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') then" ).append("\n"); 
		query.append("							case when @[usr_id] in ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) then 'Y' else 'N' end" ).append("\n"); 
		query.append("						else" ).append("\n"); 
		query.append("							'Y'" ).append("\n"); 
		query.append("					end" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append("			else" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				select  case" ).append("\n"); 
		query.append("							when SYS_AREA_GRP_ID IS NOT NULL then" ).append("\n"); 
		query.append("								case " ).append("\n"); 
		query.append("									when @[chg_delt_path_cd] = 'RHQ' and T1.RQST_OFC_CD in ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') then" ).append("\n"); 
		query.append("										case when @[usr_id] in ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) then 'Y' else 'N' end" ).append("\n"); 
		query.append("									else" ).append("\n"); 
		query.append("										'Y'" ).append("\n"); 
		query.append("								end								" ).append("\n"); 
		query.append("							else" ).append("\n"); 
		query.append("								'N'" ).append("\n"); 
		query.append("						end" ).append("\n"); 
		query.append("				  from  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("				 where  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				   and  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("				   and  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("				   and  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("				   and  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				   and  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("				   and  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("				   and  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_CD       = @[chg_delt_path_cd]" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_LVL     >= decode(T1.DMDT_DELT_RQST_STS_CD, 'R', 1, 'B', 1, 'E', 1, 'Q', 2, 'F', 2, 'H', 3, 'G', 3, 0)" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		end)													as CHG_DELT_USR_YN		--// Charge Deletion 요청에 대해 승인권한자인지 여부를 나타낸다." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , TO_CHAR(T4.FM_MVMT_DT,'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append("	   , TO_CHAR(T4.TO_MVMT_DT,'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append("	   , TO_CHAR(T4.FT_CMNC_DT,'YYYYMMDD') FT_CMNC_DT" ).append("\n"); 
		query.append("	   , TO_CHAR(T4.FT_END_DT,'YYYYMMDD') FT_END_DT" ).append("\n"); 
		query.append("	   , T4.BIL_AMT" ).append("\n"); 
		query.append("       , T4.OFC_RHQ_CD" ).append("\n"); 
		query.append("       , T4.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("       , T4.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("       , T4.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       , T4.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("	   , T3.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	   , T3.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	   , T4.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("       , T4.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("  from  DMT_CHG_DELT_RQST_APRO     T1 " ).append("\n"); 
		query.append("       ,DMT_CHG_DELT_SPEC_RSN_RMK  T2" ).append("\n"); 
		query.append("       ,DMT_CHG_BKG_CNTR           T3" ).append("\n"); 
		query.append("       ,DMT_CHG_CALC	           T4" ).append("\n"); 
		query.append(" where  T1.SYS_AREA_GRP_ID       = @[svr_id]" ).append("\n"); 
		query.append("   and  T1.CNTR_NO               = @[cntr_no]" ).append("\n"); 
		query.append("   and  T1.CNTR_CYC_NO           = to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("   and  T1.DMDT_TRF_CD           = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   and  T1.DMDT_CHG_LOC_DIV_CD   = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   and  T1.CHG_SEQ               = to_number(@[chg_seq])" ).append("\n"); 
		query.append("   and  T1.CHG_OFC_CD            = NVL(@[chg_ofc_cd],T1.CHG_OFC_CD)" ).append("\n"); 
		query.append("   and  T1.DELT_SEQ              = NVL(to_number(@[delt_seq]),T1.DELT_SEQ)" ).append("\n"); 
		query.append("   AND  T1.DMDT_DELT_RQST_STS_CD = NVL(@[chg_delt_sts_cd],T1.DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("   and  T1.DELT_SPEC_RSN_RMK_SEQ = T2.DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append("   AND  T1.SYS_AREA_GRP_ID       = T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   AND  T1.CNTR_NO               = T3.CNTR_NO" ).append("\n"); 
		query.append("   AND  T1.CNTR_CYC_NO           = T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("   AND  T1.SYS_AREA_GRP_ID       = T4.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   AND  T1.CNTR_NO               = T4.CNTR_NO" ).append("\n"); 
		query.append("   AND  T1.CNTR_CYC_NO           = T4.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  T1.DMDT_TRF_CD           = T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("   and  T1.DMDT_CHG_LOC_DIV_CD   = T4.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   and  T1.CHG_SEQ               = T4.CHG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",T1.CNTR_NO" ).append("\n"); 
		query.append(",T1.CNTR_CYC_NO" ).append("\n"); 
		query.append(",T1.DMDT_TRF_CD " ).append("\n"); 
		query.append(",T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",T1.CHG_SEQ" ).append("\n"); 
		query.append(",T1.CHG_OFC_CD" ).append("\n"); 
		query.append(",T1.DELT_SEQ" ).append("\n"); 
		query.append(",T3.BKG_NO" ).append("\n"); 
		query.append(",T3.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",T1.DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append(",T1.DELT_RMK" ).append("\n"); 
		query.append(",T1.DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append(",T1.DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",T1.INACT_RQST_NO" ).append("\n"); 
		query.append(",T1.INACT_APRO_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", T4.FM_MVMT_DT" ).append("\n"); 
		query.append(", T4.TO_MVMT_DT" ).append("\n"); 
		query.append(", T4.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(", T4.TO_MVMT_YD_CD" ).append("\n"); 
		query.append(", T4.FT_CMNC_DT" ).append("\n"); 
		query.append(", T4.FT_END_DT" ).append("\n"); 
		query.append(", T4.BIL_AMT" ).append("\n"); 
		query.append(", T4.OFC_RHQ_CD" ).append("\n"); 
		query.append(", T4.FM_MVMT_STS_CD" ).append("\n"); 
		query.append(", T4.TO_MVMT_STS_CD" ).append("\n"); 
		query.append(", T3.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(", T3.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(", T4.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(", T4.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select  T1.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("       ,T1.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("       ,T1.CNTR_CYC_NO AS CNTR_CYC_NO" ).append("\n"); 
		query.append("       ,T1.DMDT_TRF_CD AS " ).append("\n"); 
		query.append("       ,T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,T1.CHG_SEQ" ).append("\n"); 
		query.append("       ,T1.CHG_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("	   ,T1.DELT_SEQ" ).append("\n"); 
		query.append("       ,T3.BKG_NO" ).append("\n"); 
		query.append("       ,DECODE(T1.CHG_SEQ,1,'G','B') AS CHG_TYPE" ).append("\n"); 
		query.append("	   ,T3.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,T1.DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append("       ,T1.DELT_RMK" ).append("\n"); 
		query.append("       ,T1.DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append("       ,( SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("            FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("           WHERE INTG_CD_ID = 'CD03382' " ).append("\n"); 
		query.append("             AND INTG_CD_VAL_CTNT = T1.DMDT_DELT_RQST_STS_CD ) AS STS_CD" ).append("\n"); 
		query.append("       ,T1.INACT_RQST_NO" ).append("\n"); 
		query.append("       ,T1.INACT_APRO_NO " ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,1,T2.DELT_RMK,'')) DETAIL_1_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,2,T2.DELT_RMK,'')) DETAIL_2_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,3,T2.DELT_RMK,'')) DETAIL_3_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,4,T2.DELT_RMK,'')) DETAIL_4_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,5,T2.DELT_RMK,'')) DETAIL_5_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,6,T2.DELT_RMK,'')) DETAIL_6_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,7,T2.DELT_RMK,'')) DETAIL_7_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,8,T2.DELT_RMK,'')) DETAIL_8_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(T2.DELT_RMK_LVL,9,T2.DELT_RMK,'')) DETAIL_9_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,MAX(case" ).append("\n"); 
		query.append("			when decode(@[chg_delt_path_cd], 'BBG', 1, 'RHQ', 2, 'HDO', 3, 0) >= " ).append("\n"); 
		query.append("				 (" ).append("\n"); 
		query.append("					select  max(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("					  from  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("					 where  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   and  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("					   and  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   and  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   and  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   and  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("					   and  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("					   and  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("					   and  (CHG_DELT_PATH_CPLS_FLG = 'Y' or CHG_DELT_STS_CD in ('A', 'J'))" ).append("\n"); 
		query.append("				 ) " ).append("\n"); 
		query.append("				 then " ).append("\n"); 
		query.append("				 (" ).append("\n"); 
		query.append("					case " ).append("\n"); 
		query.append("						when @[chg_delt_path_cd] = 'RHQ' and T1.RQST_OFC_CD in ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') then" ).append("\n"); 
		query.append("							case when @[usr_id] in ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) then 'Y' else 'N' end" ).append("\n"); 
		query.append("						else" ).append("\n"); 
		query.append("							'Y'" ).append("\n"); 
		query.append("					end" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append("			else" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				select  case" ).append("\n"); 
		query.append("							when SYS_AREA_GRP_ID IS NOT NULL then" ).append("\n"); 
		query.append("								case " ).append("\n"); 
		query.append("									when @[chg_delt_path_cd] = 'RHQ' and T1.RQST_OFC_CD in ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') then" ).append("\n"); 
		query.append("										case when @[usr_id] in ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) then 'Y' else 'N' end" ).append("\n"); 
		query.append("									else" ).append("\n"); 
		query.append("										'Y'" ).append("\n"); 
		query.append("								end								" ).append("\n"); 
		query.append("							else" ).append("\n"); 
		query.append("								'N'" ).append("\n"); 
		query.append("						end" ).append("\n"); 
		query.append("				  from  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("				 where  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				   and  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("				   and  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("				   and  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("				   and  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				   and  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("				   and  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("				   and  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_CD       = @[chg_delt_path_cd]" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_LVL     >= decode(T1.DMDT_DELT_RQST_STS_CD, 'R', 1, 'B', 1, 'E', 1, 'Q', 2, 'F', 2, 'H', 3, 'G', 3, 0)" ).append("\n"); 
		query.append("				   and  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		end)													as CHG_DELT_USR_YN		--// Charge Deletion 요청에 대해 승인권한자인지 여부를 나타낸다." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , TO_CHAR(T4.FM_MVMT_DT,'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append("	   , TO_CHAR(T4.TO_MVMT_DT,'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append("	   , TO_CHAR(T4.FT_CMNC_DT,'YYYYMMDD') FT_CMNC_DT" ).append("\n"); 
		query.append("	   , TO_CHAR(T4.FT_END_DT,'YYYYMMDD') FT_END_DT" ).append("\n"); 
		query.append("	   , T4.BIL_AMT" ).append("\n"); 
		query.append("       , T4.OFC_RHQ_CD" ).append("\n"); 
		query.append("       , T4.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("       , T4.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("       , T4.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       , T4.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("	   , T3.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	   , T3.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	   , T4.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("       , T4.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("  from  DMT_CHG_DELT_RQST_APRO     T1 " ).append("\n"); 
		query.append("       ,DMT_CHG_DELT_SPEC_RSN_RMK  T2" ).append("\n"); 
		query.append("       ,DMT_CHG_BKG_CNTR           T3" ).append("\n"); 
		query.append("       ,DMT_CHG_CALC	           T4" ).append("\n"); 
		query.append(" where 1=1" ).append("\n"); 
		query.append("   AND  T1.DMDT_DELT_RQST_STS_CD = NVL(@[chg_delt_sts_cd],T1.DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("   and  T1.DELT_SPEC_RSN_RMK_SEQ = T2.DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append("   AND  T1.SYS_AREA_GRP_ID       = T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   AND  T1.CNTR_NO               = T3.CNTR_NO" ).append("\n"); 
		query.append("   AND  T1.CNTR_CYC_NO           = T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("   AND  T1.SYS_AREA_GRP_ID       = T4.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   AND  T1.CNTR_NO               = T4.CNTR_NO" ).append("\n"); 
		query.append("   AND  T1.CNTR_CYC_NO           = T4.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  T1.DMDT_TRF_CD           = T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("   and  T1.DMDT_CHG_LOC_DIV_CD   = T4.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   and  T1.CHG_SEQ               = T4.CHG_SEQ" ).append("\n"); 
		query.append("   AND  T1.INACT_RQST_NO = ( SELECT INACT_RQST_NO FROM DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("                            WHERE  SYS_AREA_GRP_ID       = @[svr_id]" ).append("\n"); 
		query.append("   							and  CNTR_NO               = @[cntr_no]" ).append("\n"); 
		query.append("   							and  CNTR_CYC_NO           = to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("   							and  DMDT_TRF_CD           = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   							and  DMDT_CHG_LOC_DIV_CD   = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   							and  CHG_SEQ               = to_number(@[chg_seq])" ).append("\n"); 
		query.append("   							and  CHG_OFC_CD            = NVL(@[chg_ofc_cd],CHG_OFC_CD)" ).append("\n"); 
		query.append("   							and  DELT_SEQ              = NVL(to_number(@[delt_seq]),DELT_SEQ)" ).append("\n"); 
		query.append("   							AND  DMDT_DELT_RQST_STS_CD = NVL(@[chg_delt_sts_cd],DMDT_DELT_RQST_STS_CD) " ).append("\n"); 
		query.append("                            AND  ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND DELT_SEQ        = ( SELECT  /*+ NO_UNNEST */ MAX(DELT_SEQ) " ).append("\n"); 
		query.append("                            FROM    DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("                            WHERE   SYS_AREA_GRP_ID       = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   							and     CNTR_NO               = T1.CNTR_NO" ).append("\n"); 
		query.append("   							and     CNTR_CYC_NO           = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("   							and     DMDT_TRF_CD           = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("   							and     DMDT_CHG_LOC_DIV_CD   = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   							and     CHG_SEQ               = T1.CHG_SEQ )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",T1.CNTR_NO" ).append("\n"); 
		query.append(",T1.CNTR_CYC_NO" ).append("\n"); 
		query.append(",T1.DMDT_TRF_CD " ).append("\n"); 
		query.append(",T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",T1.CHG_SEQ" ).append("\n"); 
		query.append(",T1.CHG_OFC_CD" ).append("\n"); 
		query.append(",T1.DELT_SEQ" ).append("\n"); 
		query.append(",T3.BKG_NO" ).append("\n"); 
		query.append(",T3.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",T1.DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append(",T1.DELT_RMK" ).append("\n"); 
		query.append(",T1.DELT_SPEC_RSN_RMK_SEQ" ).append("\n"); 
		query.append(",T1.DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",T1.INACT_RQST_NO" ).append("\n"); 
		query.append(",T1.INACT_APRO_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", T4.FM_MVMT_DT" ).append("\n"); 
		query.append(", T4.TO_MVMT_DT" ).append("\n"); 
		query.append(", T4.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(", T4.TO_MVMT_YD_CD" ).append("\n"); 
		query.append(", T4.FT_CMNC_DT" ).append("\n"); 
		query.append(", T4.FT_END_DT" ).append("\n"); 
		query.append(", T4.BIL_AMT" ).append("\n"); 
		query.append(", T4.OFC_RHQ_CD" ).append("\n"); 
		query.append(", T4.FM_MVMT_STS_CD" ).append("\n"); 
		query.append(", T4.TO_MVMT_STS_CD" ).append("\n"); 
		query.append(", T3.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(", T3.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(", T4.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(", T4.FX_FT_OVR_DYS ) A" ).append("\n"); 

	}
}