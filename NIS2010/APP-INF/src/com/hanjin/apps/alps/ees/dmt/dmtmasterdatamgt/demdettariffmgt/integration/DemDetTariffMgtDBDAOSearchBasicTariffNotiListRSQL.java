/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffNotiListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.12.17 김기태
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

public class DemDetTariffMgtDBDAOSearchBasicTariffNotiListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemDetTariffMgtDBDAOSearchBasicTariffNotiListRSQL
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffNotiListRSQL(){
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
		params.put("dmdt_cgo_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvrg_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvrg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_cntr_tp_cd10",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_cntr_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffNotiListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT COVRG, DMDT_TRF_CD, ORG_DEST, DMDT_DE_TERM_CD, DMDT_DE_TERM_NM " ).append("\n"); 
		query.append("     , DMDT_CNTR_TP_NM, DMDT_CGO_TP_NM, EXP_DT, PIC_TEAM, TRF_MNG_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT, UPD_USR_NM, UPD_OFC_CD, 'Weekly' AS CYC_NOTI" ).append("\n"); 
		query.append("     , SYS_AREA_GRP_ID, TRF_SEQ, TRF_GRP_SEQ, DMDT_CNTR_TP_CD, DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("     , EFF_DT, EXIST, ( SELECT USR_NM FROM COM_USER WHERE USR_ID = TRF_MNG_USR_ID AND ROWNUM = 1 ) AS TRF_MNG_USR_NM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  A.DMDT_TRF_CD" ).append("\n"); 
		query.append("                ,CASE WHEN TRIM(A.CVRG_YD_CD) IS NULL THEN " ).append("\n"); 
		query.append("                	(CASE WHEN TRIM(A.CVRG_LOC_CD) IS NULL THEN" ).append("\n"); 
		query.append("                		(CASE WHEN TRIM(A.CVRG_STE_CD) IS NULL THEN" ).append("\n"); 
		query.append("                			(CASE WHEN TRIM(A.CVRG_RGN_CD) IS NULL THEN A.CVRG_CNT_CD ELSE A.CVRG_RGN_CD END)" ).append("\n"); 
		query.append("                		ELSE A.CVRG_STE_CD" ).append("\n"); 
		query.append("                		END)" ).append("\n"); 
		query.append("                	ELSE A.CVRG_LOC_CD" ).append("\n"); 
		query.append("                	END)" ).append("\n"); 
		query.append("                ELSE A.CVRG_YD_CD" ).append("\n"); 
		query.append("                END COVRG" ).append("\n"); 
		query.append("                ,CASE WHEN TRIM(A.ORG_DEST_LOC_CD) IS NULL THEN " ).append("\n"); 
		query.append("                	(CASE WHEN TRIM(A.ORG_DEST_STE_CD) IS NULL THEN" ).append("\n"); 
		query.append("                		(CASE WHEN TRIM(A.ORG_DEST_RGN_CD) IS NULL THEN " ).append("\n"); 
		query.append("                			(CASE WHEN TRIM(A.ORG_DEST_CNT_CD) IS NULL THEN A.ORG_DEST_CONTI_CD ELSE A.ORG_DEST_CNT_CD END)" ).append("\n"); 
		query.append("                		ELSE A.ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("                		END)" ).append("\n"); 
		query.append("                	ELSE A.ORG_DEST_STE_CD" ).append("\n"); 
		query.append("                	END)" ).append("\n"); 
		query.append("                ELSE A.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("                END ORG_DEST" ).append("\n"); 
		query.append("                , B.TRF_GRP_SEQ" ).append("\n"); 
		query.append("                , CASE WHEN B.DMDT_TRF_GRP_TP_CD = 'N' THEN 'Exempted'" ).append("\n"); 
		query.append("                      ELSE B.DMDT_BZC_TRF_GRP_NM END DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append("                ,NVL( TO_CHAR(B.EFF_DT,'YYYY-MM-DD') , '-' ) AS EFF_DT" ).append("\n"); 
		query.append("                ,NVL( TO_CHAR(B.EXP_DT,'YYYY-MM-DD') , '-' ) AS EXP_DT" ).append("\n"); 
		query.append("                ,B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                SELECT  S.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                FROM    COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("                WHERE   S.INTG_CD_ID        = 'CD03257'" ).append("\n"); 
		query.append("                AND     S.INTG_CD_VAL_CTNT  = B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                )                                            AS DMDT_DE_TERM_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                        FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                       WHERE IO_BND_CD = SUBSTR(A.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                         AND CVRG_LOC_CD = A.CVRG_LOC_CD" ).append("\n"); 
		query.append("                         AND ORG_DEST_CONTI_CD = A.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                    NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                            FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                           WHERE IO_BND_CD = SUBSTR(A.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                             AND CVRG_STE_CD = A.CVRG_STE_CD" ).append("\n"); 
		query.append("                             AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("                             AND ORG_DEST_CONTI_CD = A.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                        NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                                FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                               WHERE IO_BND_CD = SUBSTR(A.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                                 AND CVRG_RGN_CD = A.CVRG_RGN_CD" ).append("\n"); 
		query.append("                                 AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("                                 AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("                                 AND ORG_DEST_CONTI_CD = A.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                            NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                                    FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                                   WHERE IO_BND_CD = SUBSTR(A.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                                     AND CVRG_CNT_CD = A.CVRG_CNT_CD" ).append("\n"); 
		query.append("                                     AND CVRG_RGN_CD IS NULL" ).append("\n"); 
		query.append("                                     AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("                                     AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("                                     AND ORG_DEST_CONTI_CD = A.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                                NVL(( SELECT TRF_EXP_NTC_OFC_CD " ).append("\n"); 
		query.append("                                        FROM DMT_TRF_EXP_NTC_OFC" ).append("\n"); 
		query.append("                                       WHERE IO_BND_CD = SUBSTR(A.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("                                         AND CVRG_CONTI_CD = CASE WHEN A.CVRG_CNT_CD IN ('DJ','SD','TZ','ZA' ) THEN 'A'" ).append("\n"); 
		query.append("                                                                  ELSE A.CVRG_CONTI_CD END" ).append("\n"); 
		query.append("                                         AND CVRG_CNT_CD IS NULL" ).append("\n"); 
		query.append("                                         AND CVRG_RGN_CD IS NULL" ).append("\n"); 
		query.append("                                         AND CVRG_STE_CD IS NULL" ).append("\n"); 
		query.append("                                         AND CVRG_LOC_CD IS NULL" ).append("\n"); 
		query.append("                                         AND ORG_DEST_CONTI_CD = A.ORG_DEST_CONTI_CD )," ).append("\n"); 
		query.append("                                'ERROR')" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                ) AS PIC_TEAM" ).append("\n"); 
		query.append("                , C.TRF_MNG_USR_ID" ).append("\n"); 
		query.append("                , C.UPD_DT" ).append("\n"); 
		query.append("                , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = C.UPD_USR_ID ) AS UPD_USR_NM" ).append("\n"); 
		query.append("                , C.UPD_OFC_CD" ).append("\n"); 
		query.append("                , C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                , C.TRF_SEQ" ).append("\n"); 
		query.append("                , C.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("                , C.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("                , F.INTG_CD_VAL_DP_DESC                                     AS DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append("                , G.INTG_CD_VAL_DP_DESC                                     AS DMDT_CGO_TP_NM" ).append("\n"); 
		query.append("				, NVL(B.BZC_TRF_XTN_FLG, 'N') 								AS EXIST" ).append("\n"); 
		query.append("        FROM    DMT_TRF_RGN     A, " ).append("\n"); 
		query.append("                DMT_TRF_GRP     B," ).append("\n"); 
		query.append("                DMT_TRF_CMB     C, " ).append("\n"); 
		query.append("                DMT_TRF_FREE_TM D, " ).append("\n"); 
		query.append("                DMT_TRF_RT      E," ).append("\n"); 
		query.append("                COM_INTG_CD_DTL F, " ).append("\n"); 
		query.append("                COM_INTG_CD_DTL G" ).append("\n"); 
		query.append("        WHERE   A.SYS_AREA_GRP_ID   = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND     A.DMDT_TRF_CD       = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("        AND     A.TRF_SEQ           = B.TRF_SEQ" ).append("\n"); 
		query.append("        AND     B.SYS_AREA_GRP_ID   = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND     B.DMDT_TRF_CD       = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("        AND     B.TRF_SEQ           = C.TRF_SEQ" ).append("\n"); 
		query.append("        AND     B.DMDT_DE_TERM_CD   = C.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        AND     B.TRF_GRP_SEQ       = C.TRF_GRP_SEQ" ).append("\n"); 
		query.append("        AND     B.SYS_AREA_GRP_ID   = D.SYS_AREA_GRP_ID     (+)" ).append("\n"); 
		query.append("        AND     B.DMDT_TRF_CD       = D.DMDT_TRF_CD         (+)" ).append("\n"); 
		query.append("        AND     B.TRF_SEQ           = D.TRF_SEQ             (+)" ).append("\n"); 
		query.append("        AND     B.DMDT_DE_TERM_CD   = D.DMDT_DE_TERM_CD     (+)" ).append("\n"); 
		query.append("        AND     B.TRF_GRP_SEQ       = D.TRF_GRP_SEQ         (+)" ).append("\n"); 
		query.append("        AND     B.SYS_AREA_GRP_ID   = E.SYS_AREA_GRP_ID     (+)" ).append("\n"); 
		query.append("        AND     B.DMDT_TRF_CD       = E.DMDT_TRF_CD         (+)" ).append("\n"); 
		query.append("        AND     B.TRF_SEQ           = E.TRF_SEQ             (+)" ).append("\n"); 
		query.append("        AND     B.DMDT_DE_TERM_CD   = E.DMDT_DE_TERM_CD     (+)" ).append("\n"); 
		query.append("        AND     B.TRF_GRP_SEQ       = E.TRF_GRP_SEQ         (+)" ).append("\n"); 
		query.append("        AND     F.INTG_CD_VAL_CTNT  = C.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("        AND     G.INTG_CD_VAL_CTNT  = C.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("        AND     F.INTG_CD_ID        = 'CD02053'" ).append("\n"); 
		query.append("        AND     G.INTG_CD_ID        = 'CD01963'" ).append("\n"); 
		query.append("        AND     B.CFM_FLG           = 'Y'" ).append("\n"); 
		query.append("        #if (${dmdt_de_term_cd} != 'A')" ).append("\n"); 
		query.append("        AND     B.DMDT_DE_TERM_CD   = @[dmdt_de_term_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cvrg_conti_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CVRG_CONTI_CD         = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cvrg_cnt_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CVRG_CNT_CD       = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cvrg_cnt_cd} == 'US' || ${cvrg_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("        	#if (${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CVRG_STE_CD       = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("        	#if (${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CVRG_RGN_CD       = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${cvrg_loc_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CVRG_LOC_CD       = @[cvrg_loc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cvrg_yd_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CVRG_YD_CD        = @[cvrg_yd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${org_dest_conti_cd} != '')" ).append("\n"); 
		query.append("        AND     A.ORG_DEST_CONTI_CD = @[org_dest_conti_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${org_dest_cnt_cd} != '')" ).append("\n"); 
		query.append("        AND     A.ORG_DEST_CNT_CD   = @[org_dest_cnt_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${org_dest_cnt_cd} == 'US' || ${org_dest_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("        	#if (${org_dest_rgn_cd} != '')" ).append("\n"); 
		query.append("        AND     A.ORG_DEST_STE_CD   = @[org_dest_rgn_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("        	#if (${org_dest_rgn_cd} != '')" ).append("\n"); 
		query.append("        AND     A.ORG_DEST_RGN_CD = @[org_dest_rgn_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${org_dest_loc_cd} != '')" ).append("\n"); 
		query.append("        AND A.ORG_DEST_LOC_CD = @[org_dest_loc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${dmdt_trf_cd_in} == 'Y')" ).append("\n"); 
		query.append("        	AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("            	#foreach( $dmdt_trf_cd in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("                	#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("                   		'$dmdt_trf_cd', " ).append("\n"); 
		query.append("                	#else " ).append("\n"); 
		query.append("                   		'$dmdt_trf_cd' " ).append("\n"); 
		query.append("                	#end " ).append("\n"); 
		query.append("            	#end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
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
		query.append("        " ).append("\n"); 
		query.append("        #if (${validity1} != '')" ).append("\n"); 
		query.append("        AND ( TO_CHAR(EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("              AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("            #if (${validity2} != '')" ).append("\n"); 
		query.append("        		OR (TO_CHAR(EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("                    AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("                #if (${validity3} != '')" ).append("\n"); 
		query.append("        			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#else" ).append("\n"); 
		query.append("                #if (${validity3} != '')" ).append("\n"); 
		query.append("        			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        	)" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("            #if (${validity2} != '')" ).append("\n"); 
		query.append("        		TO_CHAR(EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("                AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("        		#if (${validity3} != '')" ).append("\n"); 
		query.append("        			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#else" ).append("\n"); 
		query.append("        		TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        	)" ).append("\n"); 
		query.append("        #end        " ).append("\n"); 
		query.append("        ) X" ).append("\n"); 
		query.append("WHERE   1=1 " ).append("\n"); 
		query.append("#if (${exp_ofc_cd} != 'All')" ).append("\n"); 
		query.append("  AND   X.PIC_TEAM = @[exp_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${exist} != 'A')" ).append("\n"); 
		query.append("  AND   EXIST = @[exist]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DMDT_TRF_CD, COVRG, ORG_DEST, DMDT_DE_TERM_CD, DMDT_DE_TERM_NM " ).append("\n"); 
		query.append("     , DMDT_CNTR_TP_NM, DMDT_CGO_TP_NM, EFF_DT, EXP_DT" ).append("\n"); 
		query.append("--ORDER BY DMDT_TRF_CD, LENGTH(COVRG),COVRG,ORG_DEST, DMDT_DE_TERM_CD, TRF_GRP_SEQ, EFF_DT, EXP_DT" ).append("\n"); 

	}
}