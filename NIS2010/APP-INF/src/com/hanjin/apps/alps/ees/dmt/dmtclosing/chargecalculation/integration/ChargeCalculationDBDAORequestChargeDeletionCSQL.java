/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAORequestChargeDeletionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.11.11 김기태
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

public class ChargeCalculationDBDAORequestChargeDeletionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeDeletion  Request 등록
	  * </pre>
	  */
	public ChargeCalculationDBDAORequestChargeDeletionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("delt_spec_rsn_rmk_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inact_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_delt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_chg_delt_spec_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_chg_delt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAORequestChargeDeletionCSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_CHG_DELT_RQST_APRO M" ).append("\n"); 
		query.append("  USING " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  OFC_RHQ_CD" ).append("\n"); 
		query.append("           , OFC_CD" ).append("\n"); 
		query.append("    FROM    DMT_CHG_CALC " ).append("\n"); 
		query.append("    WHERE   SYS_AREA_GRP_ID        = @[svr_id]" ).append("\n"); 
		query.append("    AND     CNTR_NO                = @[cntr_no]" ).append("\n"); 
		query.append("    AND     CNTR_CYC_NO            = to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("    AND     DMDT_TRF_CD            = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("    AND     DMDT_CHG_LOC_DIV_CD    = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("    AND     CHG_SEQ                = to_number(@[chg_seq])" ).append("\n"); 
		query.append(") CALC" ).append("\n"); 
		query.append("  ON (      M.SYS_AREA_GRP_ID         = @[svr_id]" ).append("\n"); 
		query.append("     AND    M.CNTR_NO                 = @[cntr_no]" ).append("\n"); 
		query.append("     AND    M.CNTR_CYC_NO             = to_number(@[cntr_cyc_no])" ).append("\n"); 
		query.append("     AND    M.DMDT_TRF_CD             = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("     AND    M.DMDT_CHG_LOC_DIV_CD     = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("     AND    M.CHG_SEQ                 = to_number(@[chg_seq])" ).append("\n"); 
		query.append("     AND    M.CHG_OFC_CD              = @[chg_ofc_cd]" ).append("\n"); 
		query.append("     AND    M.DELT_SEQ                = to_number(@[delt_seq])" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("      SET DMDT_DELT_RQST_STS_CD      =   @[chg_delt_sts_cd]" ).append("\n"); 
		query.append("        , UPD_USR_ID    =   @[cre_usr_id]" ).append("\n"); 
		query.append("        , UPD_DT        =   nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("        , UPD_OFC_CD    =   @[cre_ofc_cd]" ).append("\n"); 
		query.append("        , DMDT_CHG_DELT_RSN_CD = @[dmdt_chg_delt_rsn_cd]" ).append("\n"); 
		query.append("        , DMDT_CHG_DELT_SPEC_RSN_CD = @[dmdt_chg_delt_spec_rsn_cd]" ).append("\n"); 
		query.append("        , DELT_SPEC_RSN_RMK_SEQ = to_number(@[delt_spec_rsn_rmk_seq])" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT" ).append("\n"); 
		query.append("    ( SYS_AREA_GRP_ID," ).append("\n"); 
		query.append("      CNTR_NO," ).append("\n"); 
		query.append("      CNTR_CYC_NO," ).append("\n"); 
		query.append("      DMDT_TRF_CD," ).append("\n"); 
		query.append("      DMDT_CHG_LOC_DIV_CD," ).append("\n"); 
		query.append("      CHG_SEQ," ).append("\n"); 
		query.append("      CHG_OFC_CD," ).append("\n"); 
		query.append("      DELT_SEQ," ).append("\n"); 
		query.append("      DMDT_DELT_RQST_STS_CD," ).append("\n"); 
		query.append("      RQST_USR_ID," ).append("\n"); 
		query.append("      RQST_OFC_CD," ).append("\n"); 
		query.append("      RQST_DT," ).append("\n"); 
		query.append("      APRO_OFC_CD," ).append("\n"); 
		query.append("      CRE_USR_ID," ).append("\n"); 
		query.append("      CRE_OFC_CD," ).append("\n"); 
		query.append("      CRE_DT," ).append("\n"); 
		query.append("      UPD_USR_ID," ).append("\n"); 
		query.append("      UPD_OFC_CD," ).append("\n"); 
		query.append("      UPD_DT," ).append("\n"); 
		query.append("      DMDT_CHG_DELT_RSN_CD," ).append("\n"); 
		query.append("      DMDT_CHG_DELT_SPEC_RSN_CD," ).append("\n"); 
		query.append("      DELT_SPEC_RSN_RMK_SEQ," ).append("\n"); 
		query.append("      DELT_RMK," ).append("\n"); 
		query.append("      INACT_RQST_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("    @[svr_id] ," ).append("\n"); 
		query.append("    @[cntr_no]," ).append("\n"); 
		query.append("    TO_NUMBER(@[cntr_cyc_no])," ).append("\n"); 
		query.append("    @[dmdt_trf_cd]," ).append("\n"); 
		query.append("    @[dmdt_chg_loc_div_cd]," ).append("\n"); 
		query.append("    TO_NUMBER(@[chg_seq])," ).append("\n"); 
		query.append("    @[chg_ofc_cd]," ).append("\n"); 
		query.append("    to_number(@[delt_seq])," ).append("\n"); 
		query.append("     'R'," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    @[cre_ofc_cd]," ).append("\n"); 
		query.append("    NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)," ).append("\n"); 
		query.append("    DECODE(CALC.OFC_RHQ_CD,'SINRS',CALC.OFC_RHQ_CD, " ).append("\n"); 
		query.append("                       'SHARC',CALC.OFC_RHQ_CD," ).append("\n"); 
		query.append("                       'SELIB','SELSC',  -- 2014.01.15 [CHM-201428544] [DMT] SELBB/TYOBB Deletion APVL OFC 추가" ).append("\n"); 
		query.append("                       'TYOIB','TYOSC',  -- 2014.01.15 [CHM-201428544] [DMT] SELBB/TYOBB Deletion APVL OFC 추가" ).append("\n"); 
		query.append("                       'VVOIA','VVOBA',  -- 블라디보스톡 대리점 가상 오피스 코드 추가" ).append("\n"); 
		query.append("                       'NYCRA',DECODE( CALC.OFC_CD,'TORSC', CALC.OFC_CD	," ).append("\n"); 
		query.append("                                                   'MEXSC', CALC.OFC_CD	," ).append("\n"); 
		query.append("                                                   'SAOSC', CALC.OFC_CD	," ).append("\n"); 
		query.append("                                                   'MTRBS', 'TORSC'," ).append("\n"); 
		query.append("                                                   'VANSO', 'TORSC',  CALC.OFC_RHQ_CD)," ).append("\n"); 
		query.append("                       'HAMRU',DECODE(SUBSTR(CALC.OFC_CD,4,2),'BB',CALC.OFC_CD	, " ).append("\n"); 
		query.append("                                                              'BO',CALC.OFC_CD	," ).append("\n"); 
		query.append("                                                              'BS',(SELECT PRNT_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = CALC.OFC_CD	), " ).append("\n"); 
		query.append("                                                               CALC.OFC_RHQ_CD),CALC.OFC_RHQ_CD)," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    @[cre_ofc_cd]," ).append("\n"); 
		query.append("    NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    @[cre_ofc_cd]," ).append("\n"); 
		query.append("    NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)," ).append("\n"); 
		query.append("    @[dmdt_chg_delt_rsn_cd]," ).append("\n"); 
		query.append("    @[dmdt_chg_delt_spec_rsn_cd]," ).append("\n"); 
		query.append("    to_number(@[delt_spec_rsn_rmk_seq])," ).append("\n"); 
		query.append("    @[corr_rmk]," ).append("\n"); 
		query.append("    @[inact_rqst_no] )" ).append("\n"); 

	}
}