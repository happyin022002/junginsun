/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiKorDoCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
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
		query.append("      /* 2014.08.05 DMT 모듈에서 나가는 것도 ETA 추가함 */" ).append("\n"); 
		query.append("      || 'DMIF_END_DT:' || NVL(DMIF_END_DT,NVL(VPS_ETA_DT,' ')) || CHR(10)" ).append("\n"); 
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
		query.append("                /* ReeFeR는 + 5일, 기타 +8일로  */" ).append("\n"); 
		query.append("                ,TO_CHAR(MAX(VSKD.VPS_ETA_DT) + DECODE(SUBSTR(CNTR_TPSZ_CD,1,1),'R',5,8) , 'YYYYMMDD') AS VPS_ETA_DT" ).append("\n"); 
		query.append("        FROM    BKG_CONTAINER    BCNTR," ).append("\n"); 
		query.append("                BKG_VVD          VVD," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD VSKD," ).append("\n"); 
		query.append("                ( " ).append("\n"); 
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
		query.append("                AND     C.SYS_AREA_GRP_ID = 'KOR'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L', 'N', 'U')  " ).append("\n"); 
		query.append("                AND (   ( C.DMDT_TRF_CD = 'DMIF'  AND C.DMDT_CHG_LOC_DIV_CD = 'POD')" ).append("\n"); 
		query.append("                     OR ( C.DMDT_TRF_CD = 'CTIC'  AND C.DMDT_CHG_LOC_DIV_CD = 'DEL')" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("                AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("                AND C.DMDT_CHG_LOC_DIV_CD	<> 'SZP'  " ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append(" " ).append("\n"); 
		query.append("               /* 2015.06.12 이정은 차장" ).append("\n"); 
		query.append("                1,2,3 중 AR I/F " ).append("\n"); 
		query.append("                               다 안됐면 1번" ).append("\n"); 
		query.append("                                하나라도 됐으면 마지막 SEQ" ).append("\n"); 
		query.append("                */" ).append("\n"); 
		query.append("                AND     C.CHG_SEQ = (SELECT NVL(MAX(CHG_SEQ),1)" ).append("\n"); 
		query.append("                                       FROM DMT_CHG_CALC CC" ).append("\n"); 
		query.append("                                      WHERE CC.SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                        AND CC.CNTR_NO             = C.CNTR_NO" ).append("\n"); 
		query.append("                                        AND CC.CNTR_CYC_NO         = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                        AND CC.DMDT_TRF_CD         = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                        AND CC.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                                        AND EXISTS ( SELECT 'Y' FROM DMT_INV_MN WHERE DMDT_INV_NO = CC.DMDT_INV_NO AND DMDT_AR_IF_CD = 'Y' )" ).append("\n"); 
		query.append("                                    )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                GROUP BY C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT   C.CNTR_NO" ).append("\n"); 
		query.append("                        ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                        ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                        ,''             DMIF_END_DT" ).append("\n"); 
		query.append("                        /* 2015.02.23 수정 김기범 부장 CTIC는 정산완료한 날짜가 소위 무조건 반납때 까지의 기한이 됨(물론, 반출되었던 관계없이)  */" ).append("\n"); 
		query.append("                        ,MAX(DECODE( NVL(INVM1.DMDT_AR_IF_CD, 'N'), 'Y', DECODE(NVL(INVM1.DMDT_INV_STS_CD, 'I'), 'X', TO_CHAR(FT_END_DT,  'YYYYMMDD'), TO_CHAR(TO_MVMT_DT, 'YYYYMMDD') )," ).append("\n"); 
		query.append("                                                                    'N', TO_CHAR(FT_END_DT,  'YYYYMMDD') ) )  AS DMIF_END_DT" ).append("\n"); 
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