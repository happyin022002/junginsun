/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffMonitorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.01.06 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchBasicTariffMonitorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Tariff Monitor 관련 SQL문
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffMonitorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bill_exem",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffMonitorRSQL").append("\n"); 
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
		query.append("WITH T AS (" ).append("\n"); 
		query.append("SELECT AA.*,    NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                        FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                       WHERE IO_BND_CD = SUBSTR(AA.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                         AND CVRG_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("                         AND ORG_DEST_CONTI_CD = AA.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                    NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                            FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                           WHERE IO_BND_CD = SUBSTR(AA.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                             AND CVRG_STE_CD = AA.STE_CD" ).append("\n"); 
		query.append("                             AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("                             AND ORG_DEST_CONTI_CD = AA.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                        NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                                FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                               WHERE IO_BND_CD = SUBSTR(AA.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                                 AND CVRG_RGN_CD = AA.RGN_CD" ).append("\n"); 
		query.append("                                 AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("                                 AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("                                 AND ORG_DEST_CONTI_CD = AA.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                            NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                                    FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                                   WHERE IO_BND_CD = SUBSTR(AA.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                                     AND CVRG_CNT_CD = AA.CNT_CD" ).append("\n"); 
		query.append("                                     AND CVRG_RGN_CD IS NULL" ).append("\n"); 
		query.append("                                     AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("                                     AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("                                     AND ORG_DEST_CONTI_CD = AA.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                                NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                                        FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                                       WHERE IO_BND_CD = SUBSTR(AA.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                                         AND CVRG_CONTI_CD = CASE WHEN AA.CNT_CD IN ('DJ','SD','TZ','ZA' ) THEN 'A'" ).append("\n"); 
		query.append("                                                                  ELSE AA.CONTI_CD END" ).append("\n"); 
		query.append("                                         AND CVRG_CNT_CD IS NULL" ).append("\n"); 
		query.append("                                         AND CVRG_RGN_CD IS NULL" ).append("\n"); 
		query.append("                                         AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("                                         AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("                                         AND ORG_DEST_CONTI_CD = AA.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                                'ERROR')" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                ) AS PIC_TEAM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("    WHEN BAS.CVRG_CNT_CD IS NULL THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("          WHEN NVL(ORG.LOC_CD, ' ') != ' ' THEN ORG.LOC_CD" ).append("\n"); 
		query.append("          WHEN NVL(ORG.RGN_CD, ' ') != ' ' THEN ORG.RGN_CD" ).append("\n"); 
		query.append("          ELSE ORG.CNT_CD" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("    ELSE " ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("          WHEN NVL(BAS.CVRG_YD_CD, ' ') != ' ' THEN BAS.CVRG_YD_CD" ).append("\n"); 
		query.append("          WHEN NVL(BAS.CVRG_LOC_CD, ' ') != ' ' THEN BAS.CVRG_LOC_CD" ).append("\n"); 
		query.append("		  WHEN NVL(BAS.CVRG_RGN_CD, ' ') != ' ' THEN BAS.CVRG_RGN_CD" ).append("\n"); 
		query.append("          ELSE BAS.CVRG_CNT_CD" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("  END AS COVERAGE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN BAS.CVRG_CNT_CD IS NULL THEN" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("              WHEN NVL(ORG.LOC_CD, ' ') != ' ' THEN ORG.LOC_CD" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("              WHEN NVL(BAS.CVRG_LOC_CD, ' ') != ' ' THEN BAS.CVRG_LOC_CD" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("          END LOC_CD," ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN BAS.CVRG_CNT_CD IS NULL THEN" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("              WHEN NVL(ORG.RGN_CD, ' ') != ' ' THEN ORG.RGN_CD" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("              WHEN NVL(BAS.CVRG_RGN_CD, ' ') != ' ' THEN BAS.CVRG_RGN_CD" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("          END RGN_CD," ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN BAS.CVRG_CNT_CD IS NULL THEN" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("              WHEN NVL(ORG.RGN_CD, ' ') != ' ' THEN ORG.RGN_CD" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("              WHEN NVL(BAS.CVRG_STE_CD, ' ') != ' ' THEN BAS.CVRG_STE_CD" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("          END STE_CD," ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN BAS.CVRG_CNT_CD IS NULL THEN ORG.CNT_CD" ).append("\n"); 
		query.append("            ELSE CVRG_CNT_CD" ).append("\n"); 
		query.append("          END CNT_CD," ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN BAS.CVRG_CNT_CD IS NULL THEN ORG.CONTI_CD" ).append("\n"); 
		query.append("            ELSE BAS.CVRG_CONTI_CD" ).append("\n"); 
		query.append("          END CONTI_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  NVL(ORG.DMDT_TRF_CD, BAS.DMDT_TRF_CD) DMDT_TRF_CD ," ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("    WHEN BAS.ORG_DEST_CONTI_CD IS NULL THEN ORG.ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("      WHEN NVL(BAS.ORG_DEST_LOC_CD, ' ') != ' ' THEN BAS.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("      WHEN NVL(BAS.ORG_DEST_RGN_CD, ' ') != ' ' THEN BAS.ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("      WHEN NVL(BAS.ORG_DEST_CNT_CD, ' ') != ' ' THEN BAS.ORG_DEST_CNT_CD" ).append("\n"); 
		query.append("      ELSE BAS.ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append("    END" ).append("\n"); 
		query.append("  END AS ORG_DEST, " ).append("\n"); 
		query.append("  NVL(BAS.ORG_DEST_CONTI_CD,ORG.ORG_DEST_CONTI_CD) ORG_DEST_CONTI_CD," ).append("\n"); 
		query.append("  NVL(BAS.DMDT_DE_TERM_NM,'-') DMDT_DE_TERM_NM," ).append("\n"); 
		query.append("  NVL(ORG.DMDT_CNTR_TP_DESC, BAS.DMDT_CNTR_TP_NM) DMDT_CNTR_TP_DESC ," ).append("\n"); 
		query.append("  NVL(ORG.DMDT_CGO_TP_DESC, BAS.DMDT_CGO_TP_NM) DMDT_CGO_TP_DESC ," ).append("\n"); 
		query.append("  NVL2(BAS.SVR_ID, 'Y', 'N') EXIST ," ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("    WHEN NVL(BAS.DMDT_TRF_GRP_TP_CD, 'A') = 'A' THEN ''" ).append("\n"); 
		query.append("    WHEN BAS.DMDT_TRF_GRP_TP_CD = 'N' THEN 'E'" ).append("\n"); 
		query.append("    ELSE 'B'" ).append("\n"); 
		query.append("  END BILL_EXEM ," ).append("\n"); 
		query.append("  TO_CHAR(BAS.EFF_DT, 'YYYY-MM-DD') EFF_DT ," ).append("\n"); 
		query.append("  NVL(TO_CHAR(BAS.EXP_DT, 'YYYY-MM-DD'), ' ') EXP_DT," ).append("\n"); 
		query.append("  NVL(BAS.CURRENT_YN, 'E') CURRENT_YN," ).append("\n"); 
		query.append("  (SELECT COUNT(AA.DMDT_TRF_CD)" ).append("\n"); 
		query.append("      FROM DMT_TRF_RGN AA" ).append("\n"); 
		query.append("         , DMT_TRF_GRP BB" ).append("\n"); 
		query.append("         , DMT_TRF_CMB CC" ).append("\n"); 
		query.append("     WHERE AA.SYS_AREA_GRP_ID=BB.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("       AND AA.DMDT_TRF_CD=BB.DMDT_TRF_CD" ).append("\n"); 
		query.append("       AND AA.TRF_SEQ=BB.TRF_GRP_SEQ" ).append("\n"); 
		query.append("       AND BB.SYS_AREA_GRP_ID=CC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("       AND BB.DMDT_TRF_CD=CC.DMDT_TRF_CD" ).append("\n"); 
		query.append("       AND BB.TRF_SEQ=CC.TRF_SEQ" ).append("\n"); 
		query.append("       AND BB.DMDT_DE_TERM_CD=CC.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("       AND BB.TRF_GRP_SEQ=CC.TRF_GRP_SEQ" ).append("\n"); 
		query.append("       AND AA.SYS_AREA_GRP_ID=BAS.SVR_ID" ).append("\n"); 
		query.append("       AND BB.DMDT_TRF_CD=BAS.DMDT_TRF_CD" ).append("\n"); 
		query.append("       AND BB.TRF_SEQ=BAS.TRF_SEQ" ).append("\n"); 
		query.append("       AND BB.TRF_GRP_SEQ>=BAS.TRF_GRP_SEQ" ).append("\n"); 
		query.append("       AND BB.EFF_DT > NVL(BAS.EXP_DT, TO_DATE('99991231', 'YYYYMMDD'))" ).append("\n"); 
		query.append("       AND CC.DMDT_CNTR_TP_CD=BAS.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("       AND CC.DMDT_CGO_TP_CD=BAS.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("           ) AS NEXT_TRF_COUNT," ).append("\n"); 
		query.append("  BAS.TRF_MNG_USR_ID," ).append("\n"); 
		query.append("  BAS.TRF_MNG_USR_NM," ).append("\n"); 
		query.append("  NVL(BAS.GRP_CFM_FLG,'N') TRF_CFM_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("            SELECT *" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("            SELECT ( SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD LIKE A.CNT_CD||'%' AND ROWNUM = 1 ) CONTI_CD" ).append("\n"); 
		query.append("				 , CNT_CD, RGN_CD, LOC_CD" ).append("\n"); 
		query.append("                 , CASE WHEN IO_BND_CD = 'I' AND DMDT_CALC_TP_CD = 'D' THEN 'DMIF'" ).append("\n"); 
		query.append("                        WHEN IO_BND_CD = 'O' AND DMDT_CALC_TP_CD = 'D' THEN 'DMOF'" ).append("\n"); 
		query.append("                        WHEN IO_BND_CD = 'I' AND DMDT_CALC_TP_CD = 'C' THEN 'CTIC'" ).append("\n"); 
		query.append("                        WHEN IO_BND_CD = 'O' AND DMDT_CALC_TP_CD = 'C' THEN 'CTOC'   " ).append("\n"); 
		query.append("                        ELSE 'ERROR'" ).append("\n"); 
		query.append("                        END DMDT_TRF_CD" ).append("\n"); 
		query.append("            FROM DMT_CALC_TP A" ).append("\n"); 
		query.append("			WHERE EFF_DT <= SYSDATE" ).append("\n"); 
		query.append("			  AND NVL(EXP_DT,SYSDATE + 1) > SYSDATE" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT ( SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD LIKE A.CNT_CD||'%' AND ROWNUM = 1 ) CONTI_CD" ).append("\n"); 
		query.append("				 , CNT_CD, RGN_CD, LOC_CD" ).append("\n"); 
		query.append("                 , CASE WHEN IO_BND_CD = 'I' AND DMDT_CALC_TP_CD = 'D' THEN 'DTIC'" ).append("\n"); 
		query.append("                        WHEN IO_BND_CD = 'O' AND DMDT_CALC_TP_CD = 'D' THEN 'DTOC'   " ).append("\n"); 
		query.append("                        ELSE 'ERROR'" ).append("\n"); 
		query.append("                        END DMDT_TRF_CD" ).append("\n"); 
		query.append("            FROM DMT_CALC_TP A" ).append("\n"); 
		query.append("            WHERE DMDT_CALC_TP_CD = 'D'" ).append("\n"); 
		query.append("              AND EFF_DT <= SYSDATE" ).append("\n"); 
		query.append("			  AND NVL(EXP_DT,SYSDATE + 1) > SYSDATE  ) A," ).append("\n"); 
		query.append("                ( SELECT 'A' AS ORG_DEST_CONTI_CD FROM DUAL" ).append("\n"); 
		query.append("                  UNION ALL " ).append("\n"); 
		query.append("                  SELECT 'E' FROM DUAL" ).append("\n"); 
		query.append("                  UNION ALL " ).append("\n"); 
		query.append("                  SELECT 'M' FROM DUAL" ).append("\n"); 
		query.append("                  UNION ALL " ).append("\n"); 
		query.append("                  SELECT 'F' FROM DUAL ) C," ).append("\n"); 
		query.append("            ( SELECT CNTR.INTG_CD_VAL_CTNT AS DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("                   , CNTR.INTG_CD_VAL_DP_DESC AS DMDT_CNTR_TP_DESC" ).append("\n"); 
		query.append("                   , CGO.INTG_CD_VAL_CTNT AS DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("                   , CGO.INTG_CD_VAL_DP_DESC AS DMDT_CGO_TP_DESC" ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL CNTR, COM_INTG_CD_DTL CGO" ).append("\n"); 
		query.append("                WHERE CNTR.INTG_CD_ID        = 'CD02053' " ).append("\n"); 
		query.append("                  AND CGO.INTG_CD_ID        = 'CD01963'" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                    #if (${dmdt_cntr_cgo_cd_in} == 'Y')" ).append("\n"); 
		query.append("                    AND (" ).append("\n"); 
		query.append("                    	#if(${dmdt_cntr_cgo_cd_size} == '1')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '2')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '3')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd3] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '4')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd3] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd4] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '5')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd3] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd4] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd5] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '6')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd3] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd4] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd5] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd6] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '7')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd3] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd4] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd5] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd6] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd7] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '8')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd3] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd4] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd5] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd6] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd7] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd8] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '9')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd3] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd4] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd5] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd6] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd7] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd8] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd9] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd9])" ).append("\n"); 
		query.append("                    	#elseif(${dmdt_cntr_cgo_cd_size} == '10')" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd1] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd2] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd3] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd4] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd5] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd6] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd7] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd8] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd9] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd9])" ).append("\n"); 
		query.append("                    		OR" ).append("\n"); 
		query.append("                    		(CNTR.INTG_CD_VAL_CTNT = @[dmdt_cntr_tp_cd10] AND CGO.INTG_CD_VAL_CTNT = @[dmdt_cgo_tp_cd10])" ).append("\n"); 
		query.append("                    	#end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                ) B " ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				  AND CNT_CD = NVL(@[cvrg_cnt_cd],CNT_CD)		" ).append("\n"); 
		query.append("				  AND RGN_CD = NVL(@[cvrg_rgn_cd],RGN_CD)	" ).append("\n"); 
		query.append("				  AND LOC_CD = NVL(@[cvrg_loc_cd],LOC_CD)	" ).append("\n"); 
		query.append("			      AND ORG_DEST_CONTI_CD = CASE WHEN NVL(@[org_dest_cnt_cd],' ') != ' ' THEN 'KK'" ).append("\n"); 
		query.append("										       ELSE NVL(@[org_dest_conti_cd],ORG_DEST_CONTI_CD)" ).append("\n"); 
		query.append("											    END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_trf_cd in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("           '$dmdt_trf_cd', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_trf_cd' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_cntr_tp_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND DMDT_CNTR_TP_CD IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_cntr_tp_cd in ${dmdt_cntr_tp_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $dmdt_cntr_tp_list.size()) " ).append("\n"); 
		query.append("           '$dmdt_cntr_tp_cd', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_cntr_tp_cd' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_cgo_tp_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND DMDT_CGO_TP_CD IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_cgo_tp_cd in ${dmdt_cgo_tp_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $dmdt_cgo_tp_list.size()) " ).append("\n"); 
		query.append("           '$dmdt_cgo_tp_cd', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_cgo_tp_cd' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				) ORG" ).append("\n"); 
		query.append("				FULL OUTER JOIN" ).append("\n"); 
		query.append("                (SELECT   B.SYS_AREA_GRP_ID                                         AS SVR_ID" ).append("\n"); 
		query.append("                        , B.DMDT_TRF_CD                                             AS DMDT_TRF_CD" ).append("\n"); 
		query.append("                        , B.TRF_SEQ" ).append("\n"); 
		query.append("                        , B.TRF_GRP_SEQ                        " ).append("\n"); 
		query.append("                        ,  CASE WHEN B.DMDT_TRF_GRP_TP_CD = 'N' THEN 'Exempted'" ).append("\n"); 
		query.append("                                ELSE B.DMDT_BZC_TRF_GRP_NM END DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append("                        , B.EFF_DT" ).append("\n"); 
		query.append("                        , B.EXP_DT" ).append("\n"); 
		query.append("                        , (SELECT CASE WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') BETWEEN B.EFF_DT AND NVL(B.EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) THEN 'Y' ELSE 'N' END FROM DUAL) CURRENT_YN" ).append("\n"); 
		query.append("                        , DECODE(B.UPD_OFC_CD, NULL, B.CRE_OFC_CD, B.UPD_OFC_CD)    AS USER_OFFICE" ).append("\n"); 
		query.append("                        , C.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("                        , C.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("                        , D.INTG_CD_VAL_DP_DESC                                     AS DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append("                        , E.INTG_CD_VAL_DP_DESC                                     AS DMDT_CGO_TP_NM" ).append("\n"); 
		query.append("                        , B.XCLD_SAT_FLG" ).append("\n"); 
		query.append("                        , B.XCLD_SUN_FLG" ).append("\n"); 
		query.append("                        , B.XCLD_HOL_FLG" ).append("\n"); 
		query.append("                        , B.DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append("                        ," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT  INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("                        FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                        WHERE   INTG_CD_ID          = 'CD01964'" ).append("\n"); 
		query.append("                        AND     INTG_CD_VAL_CTNT    = B.DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append("                        )                                                           AS DMDT_CHG_CMNC_TP_NM" ).append("\n"); 
		query.append("                        , B.CMNC_HR" ).append("\n"); 
		query.append("                        , B.CURR_CD" ).append("\n"); 
		query.append("                        , A.CFM_FLG                                                 AS RGN_CFM_FLG" ).append("\n"); 
		query.append("                        , B.CFM_FLG                                                 AS GRP_CFM_FLG" ).append("\n"); 
		query.append("                        , CEIL(B.EFF_DT - SYSDATE)                                  AS EFF_DAY" ).append("\n"); 
		query.append("                        , B.DMDT_TRF_GRP_TP_CD" ).append("\n"); 
		query.append("                        , '' USR_ID" ).append("\n"); 
		query.append("                        , '' OFC_CD" ).append("\n"); 
		query.append("                        , '' WKND1" ).append("\n"); 
		query.append("                        , '' WKND2" ).append("\n"); 
		query.append("                        , '' RGN_CFM_SEQ" ).append("\n"); 
		query.append("                        , '' CRNT_CFM_FLG" ).append("\n"); 
		query.append("                        , '' BUTTON_MODE" ).append("\n"); 
		query.append("                        , B.DMDT_BZC_TRF_GRP_NM                                     AS DMDT_BZC_TRF_GRP_NM2" ).append("\n"); 
		query.append("                        , B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                        ," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                        FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                        WHERE   INTG_CD_ID          = 'CD03257'" ).append("\n"); 
		query.append("                        AND     INTG_CD_VAL_CTNT    = B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                        )                                                           AS DMDT_DE_TERM_NM" ).append("\n"); 
		query.append("						, A.CVRG_CONTI_CD" ).append("\n"); 
		query.append("                        , A.CVRG_CNT_CD" ).append("\n"); 
		query.append("                        , A.CVRG_RGN_CD" ).append("\n"); 
		query.append("						, A.CVRG_STE_CD" ).append("\n"); 
		query.append("                        , A.CVRG_LOC_CD" ).append("\n"); 
		query.append("						, A.CVRG_YD_CD" ).append("\n"); 
		query.append("                        , A.ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append("                        , A.ORG_DEST_CNT_CD" ).append("\n"); 
		query.append("                        , A.ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("                        , A.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("                		, C.TRF_MNG_USR_ID" ).append("\n"); 
		query.append("                		, ( SELECT USR_NM FROM COM_USER WHERE USR_ID = C.TRF_MNG_USR_ID ) AS TRF_MNG_USR_NM" ).append("\n"); 
		query.append("                FROM    DMT_TRF_RGN     A, " ).append("\n"); 
		query.append("                        DMT_TRF_GRP     B, " ).append("\n"); 
		query.append("                        DMT_TRF_CMB     C," ).append("\n"); 
		query.append("                        COM_INTG_CD_DTL D, " ).append("\n"); 
		query.append("                        COM_INTG_CD_DTL E" ).append("\n"); 
		query.append("                WHERE   A.SYS_AREA_GRP_ID   = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND     A.DMDT_TRF_CD       = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("                AND     A.TRF_SEQ           = B.TRF_SEQ" ).append("\n"); 
		query.append("                AND     B.SYS_AREA_GRP_ID   = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND     B.DMDT_TRF_CD       = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                AND     B.TRF_SEQ           = C.TRF_SEQ" ).append("\n"); 
		query.append("                AND     B.DMDT_DE_TERM_CD   = C.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                AND     B.TRF_GRP_SEQ       = C.TRF_GRP_SEQ" ).append("\n"); 
		query.append("                AND     D.INTG_CD_VAL_CTNT  = C.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("                AND     E.INTG_CD_VAL_CTNT  = C.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("                AND     D.INTG_CD_ID        = 'CD02053'" ).append("\n"); 
		query.append("                AND     E.INTG_CD_ID        = 'CD01963'            " ).append("\n"); 
		query.append("                AND     B.CFM_FLG           = 'Y'" ).append("\n"); 
		query.append("		#if (${cvrg_conti_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.CVRG_CONTI_CD         = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cvrg_cnt_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.CVRG_CNT_CD       = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cvrg_cnt_cd} == 'US' || ${cvrg_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("        	#if (${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.CVRG_STE_CD       = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("        	#if (${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.CVRG_RGN_CD       = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${cvrg_loc_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.CVRG_LOC_CD       = @[cvrg_loc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${org_dest_conti_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.ORG_DEST_CONTI_CD = @[org_dest_conti_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${org_dest_cnt_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.ORG_DEST_CNT_CD   = @[org_dest_cnt_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${org_dest_cnt_cd} == 'US' || ${org_dest_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("        	#if (${org_dest_rgn_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.ORG_DEST_STE_CD   = @[org_dest_rgn_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("        	#if (${org_dest_rgn_cd} != '')" ).append("\n"); 
		query.append("        		AND     A.ORG_DEST_RGN_CD = @[org_dest_rgn_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${org_dest_loc_cd} != '')" ).append("\n"); 
		query.append("        		AND A.ORG_DEST_LOC_CD = @[org_dest_loc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_trf_cd in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("           '$dmdt_trf_cd', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_trf_cd' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${dmdt_cntr_cgo_cd_in} == 'Y')" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("        	#if(${dmdt_cntr_cgo_cd_size} == '1')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '2')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '3')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '4')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '5')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '6')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '7')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '8')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '9')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd9] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd9])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '10')" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd9] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd9])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(C.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd10] AND C.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd10])" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${validity1} != '')" ).append("\n"); 
		query.append("AND ( TO_CHAR(B.EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("      AND NVL(TO_CHAR(B.EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("    #if (${validity2} != '')" ).append("\n"); 
		query.append("		OR (TO_CHAR(B.EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("            AND NVL(TO_CHAR(B.EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${validity2} != '')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("		TO_CHAR(B.EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("        AND NVL(TO_CHAR(B.EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND     C.TRF_GRP_SEQ = (" ).append("\n"); 
		query.append("                                SELECT MAX(S.TRF_GRP_SEQ)" ).append("\n"); 
		query.append("                                FROM DMT_TRF_CMB S, DMT_TRF_GRP Z" ).append("\n"); 
		query.append("                                WHERE Z.SYS_AREA_GRP_ID = S.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                  AND Z.DMDT_TRF_CD = S.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                  AND Z.TRF_SEQ = S.TRF_SEQ" ).append("\n"); 
		query.append("                                  AND Z.TRF_GRP_SEQ = S.TRF_GRP_SEQ" ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("#if (${validity1} != '')" ).append("\n"); 
		query.append("AND ( TO_CHAR(Z.EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("      AND NVL(TO_CHAR(Z.EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("    #if (${validity2} != '')" ).append("\n"); 
		query.append("		OR (TO_CHAR(B.EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("            AND NVL(TO_CHAR(B.EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${validity2} != '')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("		TO_CHAR(Z.EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("        AND NVL(TO_CHAR(Z.EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                  AND C.SYS_AREA_GRP_ID = S.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                  AND C.DMDT_TRF_CD = S.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                  AND C.TRF_SEQ = S.TRF_SEQ" ).append("\n"); 
		query.append("                                  AND C.DMDT_DE_TERM_CD = S.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                                  AND C.DMDT_CNTR_TP_CD = S.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("                                  AND C.DMDT_CGO_TP_CD = S.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				) BAS" ).append("\n"); 
		query.append("                   ON BAS.CVRG_CNT_CD = ORG.CNT_CD" ).append("\n"); 
		query.append("                  AND BAS.CVRG_RGN_CD = ORG.RGN_CD" ).append("\n"); 
		query.append("                  AND BAS.CVRG_LOC_CD = ORG.LOC_CD" ).append("\n"); 
		query.append("                  AND BAS.DMDT_TRF_CD = ORG.DMDT_TRF_CD" ).append("\n"); 
		query.append("                  AND BAS.DMDT_CNTR_TP_CD = ORG.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("                  AND BAS.DMDT_CGO_TP_CD = ORG.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("                  AND BAS.ORG_DEST_CONTI_CD = ORG.ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${exist} != 'A') " ).append("\n"); 
		query.append("				  AND EXIST = @[exist]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bill_exem} != 'A') " ).append("\n"); 
		query.append("				  AND BILL_EXEM = @[bill_exem]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${validity3} != '') " ).append("\n"); 
		query.append("	#if (${validity4} != '')" ).append("\n"); 
		query.append("		AND CURRENT_YN = 'Y' AND NEXT_TRF_COUNT >= 0" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND CURRENT_YN = 'Y' AND NEXT_TRF_COUNT > 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${validity4} != '')" ).append("\n"); 
		query.append("		AND CURRENT_YN = 'Y' AND NEXT_TRF_COUNT = 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SUBSTR(COVERAGE,1,2), LENGTH(COVERAGE), COVERAGE, DMDT_TRF_CD, ORG_DEST, DMDT_DE_TERM_NM, DMDT_CNTR_TP_DESC, DMDT_CGO_TP_DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT T.*, DECODE(NEXT_TRF_COUNT, 0, 'N', 'Y') TO_BE_YN  FROM T" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("#if (${exp_ofc_cd} != 'A') " ).append("\n"); 
		query.append("		AND PIC_TEAM = @[exp_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}