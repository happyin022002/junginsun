/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFBKGList 조회
	  * 2013.06.12 [CHM-201324915] [VOP-OPF] CBF – POD TMNL code로 구분
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL").append("\n"); 
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
		query.append("WITH WGT_GRP AS ( " ).append("\n"); 
		query.append("     SELECT SLAN_CD," ).append("\n"); 
		query.append("            SKD_DIR_CD," ).append("\n"); 
		query.append("            POL_CD," ).append("\n"); 
		query.append("            CNTR_SZ_CD," ).append("\n"); 
		query.append("            FULL_MTY_CD," ).append("\n"); 
		query.append("            CNTR_WGT_GRP_CD," ).append("\n"); 
		query.append("            FM_LMT_WGT FROM_LMT_WGT," ).append("\n"); 
		query.append("            TO_LMT_WGT TO_LMT_WGT" ).append("\n"); 
		query.append("       FROM OPF_CGO_BKG_FCAST_WGT_GRP " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT QT.BKG_NO," ).append("\n"); 
		query.append("       QT.CNTR_NO," ).append("\n"); 
		query.append("       QT.POD POD_CD," ).append("\n"); 
		query.append("       QT.POD_YD_CD," ).append("\n"); 
		query.append("       QT.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       QT.MLB MLB_CD," ).append("\n"); 
		query.append("       'SML' CRR_CD," ).append("\n"); 
		query.append("       QT.TP CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       WP.CNTR_WGT_GRP_CD CNTR_WGT_GRP_CD," ).append("\n"); 
		query.append("       QT.FM FULL_MTY_CD," ).append("\n"); 
		query.append("       QT.DG DCGO_FLG," ).append("\n"); 
		query.append("       QT.RF RC_FLG," ).append("\n"); 
		query.append("       QT.AK AWK_CGO_FLG," ).append("\n"); 
		query.append("       QT.BB BB_CGO_FLG," ).append("\n"); 
		query.append("       QT.STWG_CD," ).append("\n"); 
		query.append("       QT.PRCT_FLG," ).append("\n"); 
		query.append("       ROUND(CNTR_GRS_WGT,3) CNTR_GRS_WGT," ).append("\n"); 
		query.append("       QT.STS BKG_STS_CD," ).append("\n"); 
		query.append("       @[vsl_cd] VSL_CD," ).append("\n"); 
		query.append("       @[skd_voy_no] SKD_VOY_NO," ).append("\n"); 
		query.append("       @[skd_dir_cd] SKD_DIR_CD," ).append("\n"); 
		query.append("       QT.POL_YD_CD  YD_CD," ).append("\n"); 
		query.append("       QT.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       'D' RD_ST," ).append("\n"); 
		query.append("       'Y' BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("       (SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = @[skd_dir_cd]) SLAN_CD," ).append("\n"); 
		query.append("       'V' CBF_DP_CD" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("        SELECT QT.BKG_NO," ).append("\n"); 
		query.append("               QT.CNTR_NO," ).append("\n"); 
		query.append("               QT.POD," ).append("\n"); 
		query.append("               QT.POD_YD_CD   POD_YD_CD ," ).append("\n"); 
		query.append("               QT.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("               QT.POL_YD_CD," ).append("\n"); 
		query.append("               QT.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("               QT.MLB," ).append("\n"); 
		query.append("               QT.TP," ).append("\n"); 
		query.append("               QT.FM," ).append("\n"); 
		query.append("               QT.DG," ).append("\n"); 
		query.append("               QT.RF," ).append("\n"); 
		query.append("               QT.AK," ).append("\n"); 
		query.append("               QT.BB," ).append("\n"); 
		query.append("               QT.CNTR_GRS_WGT+DECODE(NVL(TP.CNTR_TPSZ_TARE_WGT,0),0,DECODE(SUBSTR(QT.TP,2,1),2,2500,4000),NVL(TP.CNTR_TPSZ_TARE_WGT,0)) CNTR_GRS_WGT," ).append("\n"); 
		query.append("               QT.SLAN_CD," ).append("\n"); 
		query.append("               QT.SKD_DIR_CD," ).append("\n"); 
		query.append("               QT.POL_CD," ).append("\n"); 
		query.append("               QT.PRCT_FLG," ).append("\n"); 
		query.append("               QT.STWG_CD," ).append("\n"); 
		query.append("               QT.STS" ).append("\n"); 
		query.append("          FROM ( " ).append("\n"); 
		query.append("                WITH COPY_T AS ( " ).append("\n"); 
		query.append("                     SELECT ROWNUM NO" ).append("\n"); 
		query.append("                       FROM BKG_BOOKING" ).append("\n"); 
		query.append("                      WHERE ROWNUM<=1000 " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("                       BKG_NO," ).append("\n"); 
		query.append("                       CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CNTR_NO END CNTR_NO," ).append("\n"); 
		query.append("                       POD," ).append("\n"); 
		query.append("                       POD_YD_CD," ).append("\n"); 
		query.append("                       POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                       POL_YD_CD," ).append("\n"); 
		query.append("                       POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                       MLB," ).append("\n"); 
		query.append("                       TP," ).append("\n"); 
		query.append("                       FM," ).append("\n"); 
		query.append("                       NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CDG END,DG) DG," ).append("\n"); 
		query.append("                       NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CRF END,RF) RF ," ).append("\n"); 
		query.append("                       NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CAK END,AK) AK ," ).append("\n"); 
		query.append("                       NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CBB END,BB) BB," ).append("\n"); 
		query.append("                       CNTR_GRS_WGT," ).append("\n"); 
		query.append("                       SLAN_CD ," ).append("\n"); 
		query.append("                       SKD_DIR_CD ," ).append("\n"); 
		query.append("                       POL_CD," ).append("\n"); 
		query.append("                       PRCT_FLG," ).append("\n"); 
		query.append("                       STWG_CD," ).append("\n"); 
		query.append("                       STS" ).append("\n"); 
		query.append("                  FROM ( " ).append("\n"); 
		query.append("                        SELECT BKG_NO," ).append("\n"); 
		query.append("                               POD," ).append("\n"); 
		query.append("                               POD_YD_CD," ).append("\n"); 
		query.append("                               POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                               POL_YD_CD," ).append("\n"); 
		query.append("                               POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                               MLB," ).append("\n"); 
		query.append("                               TP," ).append("\n"); 
		query.append("                               FM," ).append("\n"); 
		query.append("                               DG," ).append("\n"); 
		query.append("                               RF," ).append("\n"); 
		query.append("                               AK," ).append("\n"); 
		query.append("                               BB," ).append("\n"); 
		query.append("                               DECODE(@[ac_cntr_flg],'C',AC_CNTR_QTY,OP_CNTR_QTY) CNTR_QTY," ).append("\n"); 
		query.append("                               SLAN_CD," ).append("\n"); 
		query.append("                               SKD_DIR_CD," ).append("\n"); 
		query.append("                               POL_CD," ).append("\n"); 
		query.append("                               PRCT_FLG," ).append("\n"); 
		query.append("                               STWG_CD," ).append("\n"); 
		query.append("                               CNTR_NO," ).append("\n"); 
		query.append("                               CDG," ).append("\n"); 
		query.append("                               CRF," ).append("\n"); 
		query.append("                               CAK," ).append("\n"); 
		query.append("                               CBB," ).append("\n"); 
		query.append("                               STS," ).append("\n"); 
		query.append("                               ROW_NUMBER() OVER (PARTITION BY BKG_NO, TP ORDER BY CNTR_NO) RN," ).append("\n"); 
		query.append("                               COUNT(CNTR_NO) OVER (PARTITION BY BKG_NO, TP ) CNT," ).append("\n"); 
		query.append("                               (CASE WHEN @[ac_cntr_flg] = 'C' THEN " ).append("\n"); 
		query.append("                                        ACT_WGT*(TP_CNR_QTY/TOT_TP_AC_QTY)/(DECODE(SUBSTR(TP,2,1),2,TP_CNR_QTY,TP_CNR_QTY/2))" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        ACT_WGT*(TP_OP_QTY/TOT_TP_OP_QTY)/(DECODE(SUBSTR(TP,2,1),2,TP_OP_QTY,TP_OP_QTY/2))" ).append("\n"); 
		query.append("                               END) AS CNTR_GRS_WGT ," ).append("\n"); 
		query.append("                               RK" ).append("\n"); 
		query.append("                          FROM ( " ).append("\n"); 
		query.append("                                SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("                                       QTY.BKG_NO       BKG_NO," ).append("\n"); 
		query.append("                                       VVD.POD_CD       POD," ).append("\n"); 
		query.append("                                       VVD.POD_YD_CD    POD_YD_CD," ).append("\n"); 
		query.append("                                       VVD.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                       VVD.POL_YD_CD," ).append("\n"); 
		query.append("                                       VVD.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                       BKG.BLCK_STWG_CD MLB," ).append("\n"); 
		query.append("                                       QTY.CNTR_TPSZ_CD TP," ).append("\n"); 
		query.append("                                       DECODE(NVL(BKG.BKG_CGO_TP_CD,' '),'F','F','E') FM," ).append("\n"); 
		query.append("                                       BKG.DCGO_FLG     DG," ).append("\n"); 
		query.append("                                       BKG.RC_FLG       RF," ).append("\n"); 
		query.append("                                       BKG.AWK_CGO_FLG  AK," ).append("\n"); 
		query.append("                                       BKG.BB_CGO_FLG   BB," ).append("\n"); 
		query.append("                                       DOC.ACT_WGT," ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("                                       (SELECT SUM(BQ.OP_CNTR_QTY*DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),2,1,2))  " ).append("\n"); 
		query.append("                                          FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                                         WHERE BQ.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("                                           AND BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                       ) AS TOT_TP_OP_QTY,                                           " ).append("\n"); 
		query.append("                                       (SELECT SUM(BQ.OP_CNTR_QTY*DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),2,1,2))" ).append("\n"); 
		query.append("                                          FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                                         WHERE BQ.BKG_NO       = BKG.BKG_NO" ).append("\n"); 
		query.append("                                           AND BQ.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                           AND BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                       ) AS TP_OP_QTY,                                           " ).append("\n"); 
		query.append("                                       SUM(DISTINCT(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,QTY.ACT_CNTR_QTY,QTY.ACT_CNTR_QTY*2))) OVER (PARTITION BY BKG.BKG_NO, QTY.CNTR_TPSZ_CD) AS TP_AC_QTY, " ).append("\n"); 
		query.append("                                       SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,1,2)) OVER (PARTITION BY QTY.BKG_NO) AS TOT_TP_AC_QTY," ).append("\n"); 
		query.append("                                       SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,1,2)) OVER (PARTITION BY QTY.BKG_NO, QTY.CNTR_TPSZ_CD) AS TP_CNR_QTY," ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("                                       (SELECT COUNT(*)" ).append("\n"); 
		query.append("                                          FROM BKG_CONTAINER C" ).append("\n"); 
		query.append("                                         WHERE C.BKG_NO       = QTY.BKG_NO" ).append("\n"); 
		query.append("                                           AND C.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                       ) AS AC_CNTR_QTY,                                           " ).append("\n"); 
		query.append("                                       QTY.OP_CNTR_QTY AS OP_CNTR_QTY, " ).append("\n"); 
		query.append("                                       VVD.SLAN_CD      SLAN_CD," ).append("\n"); 
		query.append("                                       VVD.SKD_DIR_CD   SKD_DIR_CD," ).append("\n"); 
		query.append("                                       VVD.POL_CD       POL_CD," ).append("\n"); 
		query.append("                                       BKG.PRCT_FLG     PRCT_FLG," ).append("\n"); 
		query.append("                                       BKG.STWG_CD      STWG_CD," ).append("\n"); 
		query.append("                                       CNTR.CNTR_NO     CNTR_NO," ).append("\n"); 
		query.append("                                       CNTR.DCGO_FLG    CDG," ).append("\n"); 
		query.append("                                       CNTR.RC_FLG      CRF," ).append("\n"); 
		query.append("                                       CNTR.AWK_CGO_FLG CAK," ).append("\n"); 
		query.append("                                       CNTR.BB_CGO_FLG  CBB," ).append("\n"); 
		query.append("                                       BKG.BKG_STS_CD   STS," ).append("\n"); 
		query.append("                                       CASE WHEN LENGTH(CNTR_NO) = 11 THEN RANK() OVER(PARTITION BY CNTR_NO ORDER BY BKG.BKG_NO,BKG_CRE_TP_CD DESC) " ).append("\n"); 
		query.append("                                            ELSE 1" ).append("\n"); 
		query.append("                                       END RK" ).append("\n"); 
		query.append("                                  FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("                                       BKG_BOOKING   BKG, " ).append("\n"); 
		query.append("                                       BKG_BL_DOC    DOC, " ).append("\n"); 
		query.append("                                       BKG_QUANTITY  QTY, " ).append("\n"); 
		query.append("                                       BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                                 WHERE VVD.VSL_CD                          = @[vsl_cd]" ).append("\n"); 
		query.append("                                   AND VVD.SKD_VOY_NO                      = @[skd_voy_no]" ).append("\n"); 
		query.append("                                   AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                   AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                                   AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("                                   #if(${bk_st} == 'F')" ).append("\n"); 
		query.append("                                   AND BKG.BKG_STS_CD  LIKE 'F'||'%'            --:BKG_STS(CONFIRM : 'F', ALL : '')" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   AND BKG.BKG_STS_CD  <> 'X'" ).append("\n"); 
		query.append("                                   AND BKG.BKG_NO       = DOC.BKG_NO" ).append("\n"); 
		query.append("                                   AND BKG.BKG_NO       = QTY.BKG_NO" ).append("\n"); 
		query.append("                                   AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                   AND QTY.BKG_NO       = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("                                   AND QTY.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD(+) " ).append("\n"); 
		query.append("                               ) " ).append("\n"); 
		query.append("                       )      QTY, " ).append("\n"); 
		query.append("                       COPY_T C" ).append("\n"); 
		query.append("                 WHERE " ).append("\n"); 
		query.append("                  1=1" ).append("\n"); 
		query.append("                  AND QTY.RK = 1" ).append("\n"); 
		query.append("                  AND DECODE(QTY.RN,1,CNTR_QTY - DECODE(QTY.CNT,0,0,QTY.CNT-1)) >= C.NO(+) " ).append("\n"); 
		query.append("#if (${ac_cntr_flg} == 'C')" ).append("\n"); 
		query.append("                   AND CNTR_QTY >= RN                  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("               )              QT, " ).append("\n"); 
		query.append("               MDM_CNTR_TP_SZ TP" ).append("\n"); 
		query.append("         WHERE QT.TP = TP.CNTR_TPSZ_CD(+) " ).append("\n"); 
		query.append("       )       QT, " ).append("\n"); 
		query.append("       WGT_GRP WP" ).append("\n"); 
		query.append(" WHERE QT.SLAN_CD         = WP.SLAN_CD(+)" ).append("\n"); 
		query.append("   AND QT.SKD_DIR_CD      = WP.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND QT.POL_CD          = WP.POL_CD(+)" ).append("\n"); 
		query.append("   AND DECODE(SUBSTR(QT.TP,2,1),'2','2','4') = WP.CNTR_SZ_CD(+)" ).append("\n"); 
		query.append("   AND QT.FM              = WP.FULL_MTY_CD(+)" ).append("\n"); 
		query.append("   AND QT.CNTR_GRS_WGT/1000 > WP.FROM_LMT_WGT(+) " ).append("\n"); 
		query.append("   AND QT.CNTR_GRS_WGT/1000 <= NVL(WP.TO_LMT_WGT(+),9999999999)" ).append("\n"); 
		query.append(" ORDER BY " ).append("\n"); 
		query.append("       POD_CD, " ).append("\n"); 
		query.append("       POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       MLB_CD, " ).append("\n"); 
		query.append("       BKG_NO, " ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("       CNTR_WGT_GRP_CD," ).append("\n"); 
		query.append("       FULL_MTY_CD, " ).append("\n"); 
		query.append("       DECODE(DCGO_FLG,'Y','1',RC_FLG,'Y','2',AWK_CGO_FLG,'Y','3',BB_CGO_FLG,'Y','4')" ).append("\n"); 

	}
}