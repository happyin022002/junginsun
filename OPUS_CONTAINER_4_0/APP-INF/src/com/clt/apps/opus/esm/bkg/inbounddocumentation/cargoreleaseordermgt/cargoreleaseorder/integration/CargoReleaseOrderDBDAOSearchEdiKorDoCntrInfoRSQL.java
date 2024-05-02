/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiKorDoCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdiKorDoCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Container 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiKorDoCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiKorDoCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT   '{CNTR_INFO'   || CHR(10)" ).append("\n"); 
		query.append("      || 'CNTR_NO:'     || CNTR_NO || CHR(10)" ).append("\n"); 
		query.append("      || 'SIZE_TYPE:'   || SIZE_TYPE || CHR(10)" ).append("\n"); 
		query.append("      || 'DMIF_END_DT:' || DECODE(@[do_type],'KDL',NVL(DMIF_END_DT,' '),NVL(DMIF_END_DT,NVL(VPS_ETA_DT,' '))) || CHR(10)" ).append("\n"); 
		query.append("      || 'DTIC_END_DT:' || NVL(DTIC_END_DT,' ')  || CHR(10)" ).append("\n"); 
		query.append("      || 'DT_FT_DAYS:'  || DECODE(DT_FT_DAYS, '0',' ', DT_FT_DAYS) || CHR(10)" ).append("\n"); 
		query.append("      || '}CNTR_INFO'   || CHR(10)" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  ( " ).append("\n"); 
		query.append("        SELECT   BCNTR.CNTR_NO                                          AS CNTR_NO" ).append("\n"); 
		query.append("                ,BCNTR.CNTR_TPSZ_CD                                     AS SIZE_TYPE" ).append("\n"); 
		query.append("                ,MAX(DMT_CALC.DMIF_END_DT)                                   AS DMIF_END_DT" ).append("\n"); 
		query.append("                ,MAX(DMT_CALC.DTIC_END_DT)                                   AS DTIC_END_DT" ).append("\n"); 
		query.append("                ,MAX(DMT_CALC.OVER_DAY)                                      AS DT_FT_DAYS" ).append("\n"); 
		query.append("                ,MAX(TO_CHAR(VSKD.VPS_ETA_DT+6, 'YYYYMMDD'))            AS VPS_ETA_DT" ).append("\n"); 
		query.append("        FROM    BKG_CONTAINER    BCNTR," ).append("\n"); 
		query.append("                BKG_VVD          VVD," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD VSKD," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT   C.CNTR_NO" ).append("\n"); 
		query.append("                        ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                        ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                        ,MAX(DECODE(NVL(INVM1.DMDT_AR_IF_CD, 'N'),'Y', TO_CHAR(TO_MVMT_DT, 'YYYYMMDD')," ).append("\n"); 
		query.append("                                                                  'N', TO_CHAR(FT_END_DT,  'YYYYMMDD')))   AS DMIF_END_DT" ).append("\n"); 
		query.append("                        ,''             DTIC_END_DT" ).append("\n"); 
		query.append("                        ,''             OVER_DAY" ).append("\n"); 
		query.append("                FROM    DMT_CHG_CALC    C," ).append("\n"); 
		query.append("                        DMT_INV_MN  INVM1" ).append("\n"); 
		query.append("                WHERE   (SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO) IN" ).append("\n"); 
		query.append("                        ( SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO FROM DMT_CHG_BKG_CNTR WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                AND     C.DMDT_INV_NO        = INVM1.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("                AND     C.DMDT_TRF_CD          = 'DMIF'" ).append("\n"); 
		query.append("                AND     C.DUL_TP_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                AND     C.SYS_AREA_GRP_ID = 'KOR'" ).append("\n"); 
		query.append("                GROUP BY C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT   C.CNTR_NO" ).append("\n"); 
		query.append("                        ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                        ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                        ,''             DMIF_END_DT" ).append("\n"); 
		query.append("                        ,MAX(DECODE( NVL(INVM1.DMDT_AR_IF_CD, 'N'), 'Y', DECODE(NVL(INVM1.DMDT_INV_STS_CD, 'I'), 'X', TO_CHAR(FT_END_DT,  'YYYYMMDD'), TO_CHAR(TO_MVMT_DT, 'YYYYMMDD') )," ).append("\n"); 
		query.append("                                                                     'N', TO_CHAR(FT_END_DT,  'YYYYMMDD') ) )  AS DMIF_END_DT" ).append("\n"); 
		query.append("                        ,TO_CHAR(MIN(DTIC_OVER.OVER_DAY))" ).append("\n"); 
		query.append("                FROM    DMT_CHG_CALC    C," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT   C.CNTR_NO" ).append("\n"); 
		query.append("                                    ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                    ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                    ,C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                    ,TO_CHAR(NVL(SUM(FX_FT_OVR_DYS), 0))    OVER_DAY" ).append("\n"); 
		query.append("                            FROM    DMT_CHG_CALC    C," ).append("\n"); 
		query.append("                                    DMT_INV_MN  INVM1" ).append("\n"); 
		query.append("                            WHERE   (SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO) IN" ).append("\n"); 
		query.append("                                    ( SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO FROM DMT_CHG_BKG_CNTR WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                            AND     C.DMDT_INV_NO        = INVM1.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("                            AND     C.DMDT_TRF_CD        = 'DTIC'" ).append("\n"); 
		query.append("                            AND     DUL_TP_EXPT_FLG      = 'N'" ).append("\n"); 
		query.append("                            AND     NVL(INVM1.DMDT_AR_IF_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                            GROUP BY C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD,C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                        )   DTIC_OVER," ).append("\n"); 
		query.append("                        DMT_INV_MN  INVM1" ).append("\n"); 
		query.append("                WHERE   (C.SYS_AREA_GRP_ID,C.CNTR_NO,C.CNTR_CYC_NO) IN" ).append("\n"); 
		query.append("                        ( SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO FROM DMT_CHG_BKG_CNTR WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                AND     C.DMDT_INV_NO        = INVM1.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("                AND     C.DMDT_TRF_CD        = 'DTIC'" ).append("\n"); 
		query.append("                AND     C.DUL_TP_EXPT_FLG      = 'N'" ).append("\n"); 
		query.append("                AND     C.SYS_AREA_GRP_ID = 'KOR'" ).append("\n"); 
		query.append("                AND     C.SYS_AREA_GRP_ID    = DTIC_OVER.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("                AND     C.CNTR_NO    = DTIC_OVER.CNTR_NO(+)" ).append("\n"); 
		query.append("                AND     C.CNTR_CYC_NO    = DTIC_OVER.CNTR_CYC_NO(+)" ).append("\n"); 
		query.append("                AND     C.DMDT_TRF_CD   = DTIC_OVER.DMDT_TRF_CD(+)" ).append("\n"); 
		query.append("                GROUP BY C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT   C.CNTR_NO" ).append("\n"); 
		query.append("                        ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                        ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                        ,''             DMIF_END_DT" ).append("\n"); 
		query.append("                        ,MIN(TO_CHAR(FT_END_DT,  'YYYYMMDD'))   AS DTIC_END_DT" ).append("\n"); 
		query.append("                        ,TO_CHAR(NVL(SUM(FX_FT_OVR_DYS), 0))" ).append("\n"); 
		query.append("                FROM    DMT_CHG_CALC    C," ).append("\n"); 
		query.append("                        DMT_INV_MN  INVM1" ).append("\n"); 
		query.append("                WHERE   (SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO) IN" ).append("\n"); 
		query.append("                        ( SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO FROM DMT_CHG_BKG_CNTR WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                AND     C.DMDT_INV_NO        = INVM1.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("                AND     C.DMDT_TRF_CD          = 'CTIC'" ).append("\n"); 
		query.append("                AND     C.DUL_TP_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("                AND     C.SYS_AREA_GRP_ID = 'KOR' " ).append("\n"); 
		query.append("                GROUP BY C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                )   DMT_CALC" ).append("\n"); 
		query.append("        WHERE   BCNTR.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BCNTR.CNTR_NO         = DMT_CALC.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND     BCNTR.CNMV_CYC_NO     = DMT_CALC.CNTR_CYC_NO(+)" ).append("\n"); 
		query.append("        AND     VVD.BKG_NO               = BCNTR.BKG_NO" ).append("\n"); 
		query.append("        AND     VVD.VSL_PRE_PST_CD       IN ('T','U')" ).append("\n"); 
		query.append("        AND     VVD.VSL_CD               = VSKD.VSL_CD" ).append("\n"); 
		query.append("        AND     VVD.SKD_VOY_NO           = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     VVD.SKD_DIR_CD           = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     VVD.POD_CD               = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND     VVD.POD_CLPT_IND_SEQ     = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        GROUP BY  BCNTR.CNTR_NO, BCNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}