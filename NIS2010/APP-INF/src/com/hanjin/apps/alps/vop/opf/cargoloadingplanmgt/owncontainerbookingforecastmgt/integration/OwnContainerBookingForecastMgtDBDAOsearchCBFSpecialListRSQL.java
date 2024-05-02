/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.25
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2013.06.25 서관영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seo Kwan Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFSpecialList
	  * 2012.12.03 CHM-201221299-01 이혜민 신규 장비 R8,R9 을 40’HC으로 분류하여 CBF 및 COD 메뉴에 반영
	  * 2013.06.12[CHM-201324915]  [VOP-OPF] CBF – POD TMNL code로 구분 
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_shpr_ownr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(POD,'G.Total','G.Total',SUBSTR(POD,1,5)) AS POD," ).append("\n"); 
		query.append("       DECODE(POD,'','',SUBSTR(POD,12,2)) AS POD_YD_CD," ).append("\n"); 
		query.append("       MLB," ).append("\n"); 
		query.append("       OPR1," ).append("\n"); 
		query.append("       DG_20_OPR1, DG_2H_OPR1, DG_40_OPR1, DG_4H_OPR1," ).append("\n"); 
		query.append("       DG_45_OPR1, RF_20_OPR1, RF_2H_OPR1, RF_40_OPR1," ).append("\n"); 
		query.append("       RF_4H_OPR1, RF_45_OPR1, AK_20_OPR1, AK_40_OPR1," ).append("\n"); 
		query.append("       AK_4H_OPR1, AK_45_OPR1, BB_20_OPR1, BB_40_OPR1" ).append("\n"); 
		query.append("FROM ( SELECT CASE " ).append("\n"); 
		query.append("              WHEN P=1 AND M=1 THEN 'G.Total'" ).append("\n"); 
		query.append("              ELSE POD" ).append("\n"); 
		query.append("              END  POD," ).append("\n"); 
		query.append("              CASE " ).append("\n"); 
		query.append("              WHEN P=0 AND M=1 THEN 'S.Total'" ).append("\n"); 
		query.append("              ELSE MLB" ).append("\n"); 
		query.append("              END  MLB," ).append("\n"); 
		query.append("              OPR1," ).append("\n"); 
		query.append("              DG_20_OPR1, DG_2H_OPR1, DG_40_OPR1, DG_4H_OPR1," ).append("\n"); 
		query.append("              DG_45_OPR1, RF_20_OPR1, RF_2H_OPR1, RF_40_OPR1," ).append("\n"); 
		query.append("              RF_4H_OPR1, RF_45_OPR1, AK_20_OPR1, AK_40_OPR1," ).append("\n"); 
		query.append("              AK_4H_OPR1, AK_45_OPR1, BB_20_OPR1, BB_40_OPR1," ).append("\n"); 
		query.append("              P.SEQ" ).append("\n"); 
		query.append("       FROM   ( SELECT (POD||POD_CLPT_IND_SEQ||POD_YD_CD) AS POD, MLB," ).append("\n"); 
		query.append("                       GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD) P, GROUPING(MLB) M," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD)=0 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD)=0 AND GROUPING(MLB)=0 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD)=0 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD)=1 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       ELSE 0" ).append("\n"); 
		query.append("                       END C2," ).append("\n"); 
		query.append("                       MAX(OPR1) OPR1," ).append("\n"); 
		query.append("                       SUM(DG_20_OPR1) DG_20_OPR1, SUM(DG_2H_OPR1) DG_2H_OPR1, SUM(DG_40_OPR1) DG_40_OPR1, SUM(DG_4H_OPR1) DG_4H_OPR1," ).append("\n"); 
		query.append("                       SUM(DG_45_OPR1) DG_45_OPR1, SUM(RF_20_OPR1) RF_20_OPR1, SUM(RF_2H_OPR1) RF_2H_OPR1, SUM(RF_40_OPR1) RF_40_OPR1," ).append("\n"); 
		query.append("                       SUM(RF_4H_OPR1) RF_4H_OPR1, SUM(RF_45_OPR1) RF_45_OPR1, SUM(AK_20_OPR1) AK_20_OPR1, SUM(AK_40_OPR1) AK_40_OPR1," ).append("\n"); 
		query.append("                       SUM(AK_4H_OPR1) AK_4H_OPR1, SUM(AK_45_OPR1) AK_45_OPR1, SUM(BB_20_OPR1) BB_20_OPR1, SUM(BB_40_OPR1) BB_40_OPR1              " ).append("\n"); 
		query.append("                FROM ( SELECT POD," ).append("\n"); 
		query.append("                              POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                              POD_YD_CD," ).append("\n"); 
		query.append("                              MLB," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,OPR,0))   OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_20,0)) DG_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_2H,0)) DG_2H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_40,0)) DG_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_4H,0)) DG_4H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_45,0)) DG_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_20,0)) RF_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_2H,0)) RF_2H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_40,0)) RF_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_4H,0)) RF_4H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_45,0)) RF_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,AK_20,0)) AK_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,AK_40,0)) AK_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,AK_4H,0)) AK_4H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,AK_45,0)) AK_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,BB_20,0)) BB_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,BB_40,0)) BB_40_OPR1" ).append("\n"); 
		query.append("                       FROM ( SELECT POD," ).append("\n"); 
		query.append("                                     POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                     POD_YD_CD," ).append("\n"); 
		query.append("                                     OPR," ).append("\n"); 
		query.append("                                     MLB," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) DG_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) DG_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) DG_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END),0)) DG_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) DG_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) RF_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) RF_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) RF_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END),0)) RF_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) RF_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(AWK_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) AK_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(AWK_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) AK_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(AWK_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END),0)) AK_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(AWK_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) AK_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(BB_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) BB_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(BB_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',0,1),0)) BB_40," ).append("\n"); 
		query.append("                                     MIN(ROW_NUM) ROW_NUM" ).append("\n"); 
		query.append("                              FROM ( SELECT DISTINCT " ).append("\n"); 
		query.append("                                            POD," ).append("\n"); 
		query.append("                                            POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                            POD_YD_CD," ).append("\n"); 
		query.append("                                            OPR," ).append("\n"); 
		query.append("                                            MLB," ).append("\n"); 
		query.append("                                            BKG_NO," ).append("\n"); 
		query.append("                                            CNTR_NO," ).append("\n"); 
		query.append("                                            DCGO_FLG," ).append("\n"); 
		query.append("                                            RC_FLG," ).append("\n"); 
		query.append("                                            AWK_CGO_FLG," ).append("\n"); 
		query.append("                                            BB_CGO_FLG," ).append("\n"); 
		query.append("                                            CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                            ROW_NUM," ).append("\n"); 
		query.append("                                            CNTR_RN" ).append("\n"); 
		query.append("                                     FROM   ( SELECT D.POD_CD   POD," ).append("\n"); 
		query.append("                                                     D.POD_YD_CD," ).append("\n"); 
		query.append("                                                     D.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                                     D.CRR_CD   OPR," ).append("\n"); 
		query.append("                                                     D.MLB_CD   MLB," ).append("\n"); 
		query.append("                                                     DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.BKG_NO, D.PRNR_BKG_REF_NO) BKG_NO," ).append("\n"); 
		query.append("                                                     DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO) CNTR_NO," ).append("\n"); 
		query.append("                                                     D.DCGO_FLG," ).append("\n"); 
		query.append("                                                     D.RC_FLG," ).append("\n"); 
		query.append("                                                     D.AWK_CGO_FLG," ).append("\n"); 
		query.append("                                                     D.BB_CGO_FLG," ).append("\n"); 
		query.append("                                                     D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                     1 ROW_NUM," ).append("\n"); 
		query.append("                                                     DECODE(DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO),NULL,1,ROW_NUMBER() OVER (PARTITION BY D.CRR_CD, DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO), D.CNTR_SEQ ORDER BY DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.BKG_NO, D.PRNR_BKG_REF_NO))) CNTR_RN" ).append("\n"); 
		query.append("                                              FROM   OPF_CGO_BKG_FCAST H, OPF_CGO_BKG_FCAST_CNTR D" ).append("\n"); 
		query.append("                              			 					WHERE  H.VSL_CD                    = @[vsl_cd]" ).append("\n"); 
		query.append("                              			 					AND    H.SKD_VOY_NO                = @[skd_voy_no]" ).append("\n"); 
		query.append("                              			 					AND    H.SKD_DIR_CD                = @[skd_dir_cd]" ).append("\n"); 
		query.append("                              			 					AND    H.YD_CD||H.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                                              AND    H.BKG_SHPR_OWNR_FLG = @[bkg_shpr_ownr_flg]" ).append("\n"); 
		query.append("                                              AND    H.VSL_CD            = D.VSL_CD" ).append("\n"); 
		query.append("                                              AND    H.SKD_VOY_NO        = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                                              AND    H.SKD_DIR_CD        = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                              AND    H.BKG_SHPR_OWNR_FLG = D.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("                                              AND    H.CRR_CD            = D.CRR_CD" ).append("\n"); 
		query.append("                                              AND    H.YD_CD             = D.YD_CD" ).append("\n"); 
		query.append("                                              AND    H.POL_CLPT_IND_SEQ  = D.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                              AND    D.CBF_DP_CD         = 'S'" ).append("\n"); 
		query.append("                                              AND    D.CRR_CD            = @[crr_cd]" ).append("\n"); 
		query.append("                                  			 )" ).append("\n"); 
		query.append("                                     WHERE CNTR_RN = 1 )" ).append("\n"); 
		query.append("                              GROUP BY POD, POD_CLPT_IND_SEQ, POD_YD_CD, OPR, MLB )" ).append("\n"); 
		query.append("                       GROUP BY POD, POD_CLPT_IND_SEQ, POD_YD_CD, MLB )" ).append("\n"); 
		query.append("               GROUP BY CUBE(POD||POD_CLPT_IND_SEQ||POD_YD_CD, MLB) ) A," ).append("\n"); 
		query.append("               ( SELECT V.VPS_PORT_CD PORT, V.CLPT_IND_SEQ, V.CLPT_SEQ SEQ" ).append("\n"); 
		query.append("                 FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                 WHERE  V.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                 AND    V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                 AND    V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                 AND    V.CLPT_SEQ   > ( SELECT CLPT_SEQ" ).append("\n"); 
		query.append("                                         FROM   VSK_VSL_PORT_SKD R" ).append("\n"); 
		query.append("                                         WHERE  R.VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("                                         AND    R.SKD_VOY_NO            = @[skd_voy_no]" ).append("\n"); 
		query.append("                                         AND    R.SKD_DIR_CD            = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                         AND    R.YD_CD||R.CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                                         AND    ROWNUM = 1 ) ) P" ).append("\n"); 
		query.append("       WHERE NVL(C2,0)         = 1" ).append("\n"); 
		query.append("       AND   SUBSTR(A.POD,1,5) = P.PORT(+) " ).append("\n"); 
		query.append("       AND   SUBSTR(A.POD,6,1) = P.CLPT_IND_SEQ(+))" ).append("\n"); 
		query.append("ORDER BY SEQ, DECODE(POD,'G.Total','ZZZZZ',SUBSTR(POD,1,5)), DECODE(POD,'','ZZZZZ',SUBSTR(POD,12,2)), DECODE(NVL(MLB,'YYY'),'S.Total','ZZZ',NVL(MLB,'YYY')) ASC" ).append("\n"); 

	}
}