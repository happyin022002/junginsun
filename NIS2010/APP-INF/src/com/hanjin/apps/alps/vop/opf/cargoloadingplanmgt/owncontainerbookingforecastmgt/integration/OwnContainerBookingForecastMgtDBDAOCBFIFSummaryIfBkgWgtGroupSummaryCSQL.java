/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgWgtGroupSummaryCSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgWgtGroupSummaryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CBF의 WEIGHT GROUP SUMMARY 데이터를 입력하기 위함.
	  * CHK - N : BKG의 QTY만큼 C'NTR 수량이 입력되지 않은 경우, BKG의 QTY = CNTR입력된 QTY 일치하지만 CNTR WGT가 0 이거나 NULL 인 경우
	  * CHKG - Y : BKG의 QTY만큼 C'NTR 수량이 입력 일치하고 CNTR WGT가 들어오는 경우
	  *      -- SPLIT CNTR일지라도 BKG의 수량은 정수일때 있음. DLC600244305 ,
	  * SEL660808100,SEL660808101
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgWgtGroupSummaryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgWgtGroupSummaryCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_WGT_GRP_SMRY ( VSL_CD ," ).append("\n"); 
		query.append("                                             SKD_VOY_NO ," ).append("\n"); 
		query.append("                                             SKD_DIR_CD," ).append("\n"); 
		query.append("                                             YD_CD," ).append("\n"); 
		query.append("                                             POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                             CRR_CD," ).append("\n"); 
		query.append("                                             POD_CD," ).append("\n"); 
		query.append("                                             BLCK_STWG_CD," ).append("\n"); 
		query.append("                                             CNTR_SZ_CD," ).append("\n"); 
		query.append("                                             FULL_MTY_CD," ).append("\n"); 
		query.append("                                             CNTR_WGT_GRP_CD," ).append("\n"); 
		query.append("                                             CNTR_QTY," ).append("\n"); 
		query.append("                                             CNTR_GRS_WGT," ).append("\n"); 
		query.append("                                             WGT_UT_CD," ).append("\n"); 
		query.append("                                             CRE_USR_ID," ).append("\n"); 
		query.append("                                             CRE_DT," ).append("\n"); 
		query.append("                                             UPD_USR_ID," ).append("\n"); 
		query.append("                                             UPD_DT )" ).append("\n"); 
		query.append("                                             " ).append("\n"); 
		query.append("WITH  " ).append("\n"); 
		query.append("  COPY_T AS (" ).append("\n"); 
		query.append("    SELECT ROWNUM AS RN" ).append("\n"); 
		query.append("      FROM MDM_YARD" ).append("\n"); 
		query.append("     WHERE ROWNUM <1000 ) ," ).append("\n"); 
		query.append("  V_INF AS ( " ).append("\n"); 
		query.append("    SELECT XX.BKG_NO, XX.TTLQTY, XX.MLB, XX.POD_CD,  " ).append("\n"); 
		query.append("           CASE WHEN CNT >  YY.OP_CNTR_QTY THEN CNT " ).append("\n"); 
		query.append("                ELSE YY.OP_CNTR_QTY " ).append("\n"); 
		query.append("           END AS QTY, BKG_CGO_TP_CD , CHK," ).append("\n"); 
		query.append("           DECODE(XX.RD_CGO_FLG,'Y',DECODE(SUBSTR(YY.CNTR_TPSZ_CD,1,1),'R',SUBSTR(YY.EQ_SUBST_CNTR_TPSZ_CD,1,1)||SUBSTR(YY.CNTR_TPSZ_CD,2,1),YY.CNTR_TPSZ_CD),YY.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      FROM (  SELECT DISTINCT X.BKG_NO, TTLQTY , MLB, POD_CD, BKG_CRE_TP_CD, BKG_CGO_TP_CD,RD_CGO_FLG,CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                     CASE WHEN ( X.QTY  <>  X.CNT OR X.CNTR_WGT = 0 OR X.CNTR_WGT IS NULL OR CNTR_NO IS NULL) THEN 'N'" ).append("\n"); 
		query.append("                          WHEN ( X.QTY  =  X.CNT AND X.CNTR_WGT <> 0 AND X.CNTR_WGT IS NOT NULL AND CNTR_NO IS NOT NULL) THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'Y'" ).append("\n"); 
		query.append("                          END AS CHK, CNT " ).append("\n"); 
		query.append("                FROM (  SELECT  MOD(QTY.OP_CNTR_QTY,1) DIVQTY, BKG.BKG_CRE_TP_CD, BKG.BKG_NO ,  " ).append("\n"); 
		query.append("                                QTY.OP_CNTR_QTY QTY , " ).append("\n"); 
		query.append("                                OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO) AS MLB , " ).append("\n"); 
		query.append("                                VVD.POD_CD  , BKG.RD_CGO_FLG," ).append("\n"); 
		query.append("                                BKG.BKG_CGO_TP_CD, " ).append("\n"); 
		query.append("                                (SELECT SUM(OP_CNTR_QTY) FROM BKG_QUANTITY WHERE BKG_NO = BKG.BKG_NO) AS TTLQTY,QTY.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("                                BCN.CNTR_NO ," ).append("\n"); 
		query.append("                                CASE WHEN BCN.CNTR_NO IS NULL THEN 0 " ).append("\n"); 
		query.append("                                     ELSE COUNT(1) OVER(PARTITION BY BCN.BKG_NO, BCN.CNTR_TPSZ_CD  ) " ).append("\n"); 
		query.append("                                END AS CNT, " ).append("\n"); 
		query.append("                                BCN.CNTR_WGT" ).append("\n"); 
		query.append("                           FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("                                BKG_BOOKING   BKG," ).append("\n"); 
		query.append("                                BKG_QUANTITY  QTY," ).append("\n"); 
		query.append("                                BKG_CONTAINER BCN" ).append("\n"); 
		query.append("                          WHERE VVD.VSL_CD                          = @[vsl_cd]" ).append("\n"); 
		query.append("                            AND VVD.SKD_VOY_NO                      = @[skd_voy_no]" ).append("\n"); 
		query.append("                            AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("                            AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]           " ).append("\n"); 
		query.append("                            AND VVD.BKG_NO                          = BKG.BKG_NO " ).append("\n"); 
		query.append("                            #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("                            AND BKG.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            AND BKG.BKG_STS_CD                      <> 'X'" ).append("\n"); 
		query.append("                            AND BKG.BKG_NO                          = QTY.BKG_NO   " ).append("\n"); 
		query.append("                            AND QTY.CNTR_TPSZ_CD                    NOT LIKE 'Q%' " ).append("\n"); 
		query.append("                            AND MOD(QTY.OP_CNTR_QTY,1)              = 0 " ).append("\n"); 
		query.append("                            AND BKG.BKG_CGO_TP_CD                   <> 'P'" ).append("\n"); 
		query.append("                            AND QTY.BKG_NO                          = BCN.BKG_NO(+)" ).append("\n"); 
		query.append("                            AND QTY.CNTR_TPSZ_CD                   = BCN.CNTR_TPSZ_CD(+) ) X  ) XX, BKG_QUANTITY YY" ).append("\n"); 
		query.append("     WHERE XX.BKG_NO        = YY.BKG_NO" ).append("\n"); 
		query.append("       AND YY.CNTR_TPSZ_CD  NOT LIKE 'Q%'  " ).append("\n"); 
		query.append("       AND XX.CNTR_TPSZ_CD  = YY.CNTR_TPSZ_CD   )" ).append("\n"); 
		query.append("                                                      " ).append("\n"); 
		query.append("SELECT @[vsl_cd],          @[skd_voy_no],    @[skd_dir_cd],       @[pol_cd],         @[pol_clpt_ind_seq]," ).append("\n"); 
		query.append("       'SML',              XX.POD_CD,        SUBSTR(XX.MLB,3,3) , " ).append("\n"); 
		query.append("        CASE WHEN ZZ.CNTR_SZ_CD = '2' THEN ZZ.CNTR_SZ_CD" ).append("\n"); 
		query.append("             WHEN ZZ.CNTR_SZ_CD = '4' THEN ZZ.CNTR_SZ_CD" ).append("\n"); 
		query.append("             WHEN XX.CNTR_TPSZ_CD IN ('R8','R9') OR ZZ.CNTR_SZ_CD = '5' THEN '5'" ).append("\n"); 
		query.append("             WHEN XX.CNTR_TPSZ_CD NOT IN('R8','R9') AND ZZ.CNTR_SZ_CD IN ('6','7','8','9','W','X') THEN '6'" ).append("\n"); 
		query.append("        END,   'F', " ).append("\n"); 
		query.append("        YY.CNTR_WGT_GRP_CD, COUNT(1) AS QTY,  ROUND(SUM(WGT)/COUNT(1),2),            'KGS',             @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE,            @[upd_usr_id],    SYSDATE" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("    SELECT  X.*, Y.CNTR_SZ_CD," ).append("\n"); 
		query.append("            CASE WHEN  X.WGT_UT_CD = 'LBS' THEN " ).append("\n"); 
		query.append("                       NVL(CNTR_WGT* 0.453592 ,BL_WGT* 0.453592 + Y.CNTR_TPSZ_TARE_WGT ) " ).append("\n"); 
		query.append("                 ELSE  NVL(CNTR_WGT,BL_WGT+Y.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("            END AS WGT     " ).append("\n"); 
		query.append("     FROM (  " ).append("\n"); 
		query.append("            SELECT CNTR_TPSZ_CD, MLB, POD_CD, NVL(CNTR_NO,ROWNUM) AS CNTR_NO, BKG_CGO_TP_CD, SUM(BL_WGT) AS BL_WGT, SUM(CNTR_WGT) AS CNTR_WGT, WGT_UT_CD" ).append("\n"); 
		query.append("              FROM ( " ).append("\n"); 
		query.append("                     SELECT AA.* ," ).append("\n"); 
		query.append("                            ROUND((SELECT ACT_WGT FROM BKG_BL_DOC WHERE BKG_NO = AA.BKG_NO)/ AA.TTLQTY ) AS BL_WGT, " ).append("\n"); 
		query.append("                           (SELECT WGT_UT_CD FROM BKG_BL_DOC WHERE BKG_NO = AA.BKG_NO) AS WGT_UT_CD" ).append("\n"); 
		query.append("                       FROM (  " ).append("\n"); 
		query.append("                            SELECT X.BKG_NO, X.CNTR_TPSZ_CD, X.QTY, X.MLB, X.POD_CD, X.SEQ, " ).append("\n"); 
		query.append("                                   ROUND(Y.CNTR_WGT) AS CNTR_WGT, Y.CNTR_NO, Y.NSEQ, X.TTLQTY,X.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                              FROM  (  SELECT B.* , ROW_NUMBER() OVER(PARTITION BY B.BKG_NO, B.CNTR_TPSZ_CD ORDER BY B.BKG_NO, B.CNTR_TPSZ_CD) AS SEQ" ).append("\n"); 
		query.append("                                         FROM COPY_T A, V_INF B" ).append("\n"); 
		query.append("                                        WHERE A.RN <= B.QTY " ).append("\n"); 
		query.append("                                          AND B.CHK ='N') X,   " ).append("\n"); 
		query.append("                                   (  SELECT NVL(B.VGM_WGT,B.CNTR_WGT+C.CNTR_TPSZ_TARE_WGT) AS CNTR_WGT, A.BKG_NO, A.CNTR_TPSZ_CD, B.CNTR_NO," ).append("\n"); 
		query.append("                                             ROW_NUMBER() OVER(PARTITION BY A.BKG_NO, A.CNTR_TPSZ_CD ORDER BY A.BKG_NO, A.CNTR_TPSZ_CD) AS NSEQ" ).append("\n"); 
		query.append("                                        FROM V_INF A, BKG_CONTAINER B, MDM_CNTR_TP_SZ C" ).append("\n"); 
		query.append("                                       WHERE A.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("                                         AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                         AND A.CHK          = 'N'" ).append("\n"); 
		query.append("			                             AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD )  Y " ).append("\n"); 
		query.append("                            WHERE X.BKG_NO       = Y.BKG_NO(+)" ).append("\n"); 
		query.append("                              AND X.CNTR_TPSZ_CD = Y.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("                              AND X.SEQ          = Y.NSEQ(+) ) AA " ).append("\n"); 
		query.append("                      UNION " ).append("\n"); 
		query.append("                      SELECT BB.* , " ).append("\n"); 
		query.append("                             ROUND((SELECT ACT_WGT FROM BKG_BL_DOC WHERE BKG_NO = BB.BKG_NO)/ BB.TTLQTY  ), " ).append("\n"); 
		query.append("                            (SELECT WGT_UT_CD FROM BKG_BL_DOC WHERE BKG_NO = BB.BKG_NO) AS WGT_UT_CD" ).append("\n"); 
		query.append("                       FROM ( " ).append("\n"); 
		query.append("                            SELECT X.BKG_NO, X.CNTR_TPSZ_CD, X.QTY, X.MLB, X.POD_CD, X.SEQ,  " ).append("\n"); 
		query.append("                                   ROUND(Y.CNTR_WGT), Y.CNTR_NO, Y.NSEQ, X.TTLQTY,X.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                              FROM (  SELECT B.* , ROW_NUMBER() OVER(PARTITION BY B.BKG_NO, B.CNTR_TPSZ_CD ORDER BY B.BKG_NO, B.CNTR_TPSZ_CD) AS SEQ" ).append("\n"); 
		query.append("                                        FROM COPY_T A, V_INF B" ).append("\n"); 
		query.append("                                       WHERE A.RN <= B.QTY " ).append("\n"); 
		query.append("                                         AND B.CHK ='Y') X," ).append("\n"); 
		query.append("                                   (  SELECT NVL(B.VGM_WGT,B.CNTR_WGT+C.CNTR_TPSZ_TARE_WGT) AS CNTR_WGT, A.BKG_NO, A.CNTR_TPSZ_CD, B.CNTR_NO," ).append("\n"); 
		query.append("                                             ROW_NUMBER() OVER(PARTITION BY A.BKG_NO, A.CNTR_TPSZ_CD ORDER BY A.BKG_NO, A.CNTR_TPSZ_CD) AS NSEQ" ).append("\n"); 
		query.append("                                        FROM V_INF A, BKG_CONTAINER B, MDM_CNTR_TP_SZ C" ).append("\n"); 
		query.append("                                       WHERE A.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("                                         AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("			                             AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                         AND A.CHK          = 'N')  Y " ).append("\n"); 
		query.append("                             WHERE X.BKG_NO       = Y.BKG_NO(+)" ).append("\n"); 
		query.append("                               AND X.CNTR_TPSZ_CD = Y.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("                               AND X.SEQ          = Y.NSEQ(+) ) BB " ).append("\n"); 
		query.append("                       UNION " ).append("\n"); 
		query.append("                       SELECT MIN(BCT.BKG_NO)," ).append("\n"); 
		query.append("                              DECODE(BKG.RD_CGO_FLG,'Y',DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,1,1),'R',SUBSTR(QTY.EQ_SUBST_CNTR_TPSZ_CD,1,1)||SUBSTR(QTY.CNTR_TPSZ_CD,2,1),QTY.CNTR_TPSZ_CD),QTY.CNTR_TPSZ_CD) CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("                              1 QTY,   OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO) AS MLB , " ).append("\n"); 
		query.append("                              VVD.POD_CD, 1 SEQ,  SUM(BCT.CNTR_WGT), BCT.CNTR_NO,  1 NSEQ, 1 TTLQTY,  BKG.BKG_CGO_TP_CD, SUM(NVL(BCT.VGM_WGT,BCT.CNTR_WGT+MCT.CNTR_TPSZ_TARE_WGT))," ).append("\n"); 
		query.append("                              CASE WHEN BCT.VGM_WGT IS NOT NULL THEN " ).append("\n"); 
		query.append("                                        NVL(BCT.VGM_WGT_UT_CD,'KGS')" ).append("\n"); 
		query.append("                                   ELSE NVL(BCT.WGT_UT_CD,'KGS')" ).append("\n"); 
		query.append("                                   END AS WGT_UT_CD" ).append("\n"); 
		query.append("                        FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("                             BKG_BOOKING   BKG," ).append("\n"); 
		query.append("                             BKG_QUANTITY  QTY," ).append("\n"); 
		query.append("                             BKG_CONTAINER BCT," ).append("\n"); 
		query.append("		                     MDM_CNTR_TP_SZ MCT" ).append("\n"); 
		query.append("                       WHERE VVD.VSL_CD                          = @[vsl_cd]    " ).append("\n"); 
		query.append("                         AND VVD.SKD_VOY_NO                      = @[skd_voy_no]    " ).append("\n"); 
		query.append("                         AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]   " ).append("\n"); 
		query.append("                         AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]           " ).append("\n"); 
		query.append("                         AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("                         AND BKG.BKG_STS_CD                      <> 'X'" ).append("\n"); 
		query.append("                         #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("                         AND BKG.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         AND BKG.BKG_NO                          = QTY.BKG_NO  " ).append("\n"); 
		query.append("                         AND BKG.BKG_CGO_TP_CD                   <> 'P'" ).append("\n"); 
		query.append("                         AND QTY.CNTR_TPSZ_CD                    NOT LIKE 'Q%' " ).append("\n"); 
		query.append("                         AND MOD(QTY.OP_CNTR_QTY,1)              <> 0   " ).append("\n"); 
		query.append("                         AND BKG.BKG_NO                          = BCT.BKG_NO" ).append("\n"); 
		query.append("                         AND QTY.CNTR_TPSZ_CD                    = BCT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		                 AND MCT.CNTR_TPSZ_CD                    = BCT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       GROUP BY  BKG.BKG_CGO_TP_CD, BCT.CNTR_NO, " ).append("\n"); 
		query.append("                                 DECODE(BKG.RD_CGO_FLG,'Y',DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,1,1),'R',SUBSTR(QTY.EQ_SUBST_CNTR_TPSZ_CD,1,1)||SUBSTR(QTY.CNTR_TPSZ_CD,2,1),QTY.CNTR_TPSZ_CD),QTY.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                 OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO), VVD.POD_CD,    " ).append("\n"); 
		query.append("                                 CASE WHEN BCT.VGM_WGT IS NOT NULL THEN " ).append("\n"); 
		query.append("                                           NVL(BCT.VGM_WGT_UT_CD,'KGS')" ).append("\n"); 
		query.append("                                      ELSE NVL(BCT.WGT_UT_CD,'KGS')" ).append("\n"); 
		query.append("                                 END     )" ).append("\n"); 
		query.append("              GROUP BY CNTR_TPSZ_CD, MLB, POD_CD,  NVL(CNTR_NO,ROWNUM), BKG_CGO_TP_CD, WGT_UT_CD) X, MDM_CNTR_TP_SZ Y" ).append("\n"); 
		query.append("           WHERE X.CNTR_TPSZ_CD  = Y.CNTR_TPSZ_CD ) XX, OPF_CGO_BKG_FCAST_WGT_GRP YY , MDM_CNTR_TP_SZ ZZ" ).append("\n"); 
		query.append("  WHERE YY.SLAN_CD     = ( SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("                             FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("                            WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                              AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                              AND SKD_DIR_CD = @[skd_dir_cd] )" ).append("\n"); 
		query.append("    AND YY.SKD_DIR_CD  = @[skd_dir_cd]   " ).append("\n"); 
		query.append("    AND YY.POL_CD      = substr(@[yd_cd],1,5)" ).append("\n"); 
		query.append("    AND YY.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("    AND YY.CNTR_SZ_CD  = DECODE( SUBSTR(XX.CNTR_TPSZ_CD,2,1),2,2,4) " ).append("\n"); 
		query.append("    AND DECODE(XX.WGT,0,1,XX.WGT/1000)       > YY.FM_LMT_WGT " ).append("\n"); 
		query.append("    AND XX.WGT/1000       <= NVL(YY.TO_LMT_WGT,9999999999  )" ).append("\n"); 
		query.append("    AND XX.CNTR_TPSZ_CD   = ZZ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" GROUP BY CASE WHEN ZZ.CNTR_SZ_CD = '2' THEN ZZ.CNTR_SZ_CD" ).append("\n"); 
		query.append("               WHEN ZZ.CNTR_SZ_CD = '4' THEN ZZ.CNTR_SZ_CD" ).append("\n"); 
		query.append("               WHEN XX.CNTR_TPSZ_CD IN ('R8','R9') OR ZZ.CNTR_SZ_CD = '5' THEN '5'" ).append("\n"); 
		query.append("               WHEN XX.CNTR_TPSZ_CD NOT IN('R8','R9') AND ZZ.CNTR_SZ_CD IN ('6','7','8','9','W','X') THEN '6'" ).append("\n"); 
		query.append("          END , XX.MLB, XX.POD_CD, YY.CNTR_WGT_GRP_CD" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("   SELECT  @[vsl_cd],  @[skd_voy_no],    @[skd_dir_cd],    @[pol_cd],         @[pol_clpt_ind_seq]," ).append("\n"); 
		query.append("           'SML',     X.POD_CD, X.MLB,   " ).append("\n"); 
		query.append("           CASE WHEN Y.CNTR_SZ_CD = '2' THEN Y.CNTR_SZ_CD" ).append("\n"); 
		query.append("                WHEN Y.CNTR_SZ_CD = '4' THEN Y.CNTR_SZ_CD" ).append("\n"); 
		query.append("                WHEN X.CNTR_TPSZ_CD IN ('R8','R9') OR Y.CNTR_SZ_CD = '5' THEN '5'" ).append("\n"); 
		query.append("                WHEN X.CNTR_TPSZ_CD NOT IN('R8','R9') AND Y.CNTR_SZ_CD IN ('6','7','8','9','W','X') THEN '6'" ).append("\n"); 
		query.append("            END AS CNTR_SZ_CD, 'E','E',SUM(QTY), SUM(TTL_WGT)," ).append("\n"); 
		query.append("           'KGS',      @[cre_usr_id],    SYSDATE,          @[upd_usr_id],     SYSDATE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("   SELECT  VVD.POD_CD,       SUBSTR(OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO),3,3) AS MLB ," ).append("\n"); 
		query.append("           DECODE(BKG.RD_CGO_FLG,'Y',DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,1,1),'R',SUBSTR(QTY.EQ_SUBST_CNTR_TPSZ_CD,1,1)||SUBSTR(QTY.CNTR_TPSZ_CD,2,1),QTY.CNTR_TPSZ_CD),QTY.CNTR_TPSZ_CD) CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("           SUM(QTY.OP_CNTR_QTY) AS QTY,         SUM(QTY.OP_CNTR_QTY*CTS.CNTR_TPSZ_TARE_WGT) AS TTL_WGT" ).append("\n"); 
		query.append("     FROM BKG_VVD        VVD, " ).append("\n"); 
		query.append("          BKG_BOOKING    BKG," ).append("\n"); 
		query.append("          BKG_QUANTITY   QTY," ).append("\n"); 
		query.append("          MDM_CNTR_TP_SZ CTS" ).append("\n"); 
		query.append("    WHERE VVD.VSL_CD                             = @[vsl_cd]" ).append("\n"); 
		query.append("         AND VVD.SKD_VOY_NO                      = @[skd_voy_no]" ).append("\n"); 
		query.append("         AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("         AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]          " ).append("\n"); 
		query.append("         AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("         #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("         AND BKG.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         AND BKG.BKG_STS_CD                      <> 'X'" ).append("\n"); 
		query.append("         AND BKG.BKG_NO                          = QTY.BKG_NO  " ).append("\n"); 
		query.append("         AND BKG.BKG_CGO_TP_CD                   = 'P'" ).append("\n"); 
		query.append("         AND QTY.CNTR_TPSZ_CD                    NOT LIKE 'Q%'" ).append("\n"); 
		query.append("         AND CTS.CNTR_TPSZ_CD                    = QTY.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("   GROUP BY  DECODE(BKG.RD_CGO_FLG,'Y',DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,1,1),'R',SUBSTR(QTY.EQ_SUBST_CNTR_TPSZ_CD,1,1)||SUBSTR(QTY.CNTR_TPSZ_CD,2,1),QTY.CNTR_TPSZ_CD),QTY.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("             OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO), VVD.POD_CD	) X, MDM_CNTR_TP_SZ Y" ).append("\n"); 
		query.append(" WHERE X.CNTR_TPSZ_CD  = Y.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("GROUP BY X.POD_CD, X.MLB,   " ).append("\n"); 
		query.append("         CASE WHEN Y.CNTR_SZ_CD = '2' THEN Y.CNTR_SZ_CD" ).append("\n"); 
		query.append("              WHEN Y.CNTR_SZ_CD = '4' THEN Y.CNTR_SZ_CD" ).append("\n"); 
		query.append("              WHEN X.CNTR_TPSZ_CD IN ('R8','R9') OR Y.CNTR_SZ_CD = '5' THEN '5'" ).append("\n"); 
		query.append("              WHEN X.CNTR_TPSZ_CD NOT IN('R8','R9') AND Y.CNTR_SZ_CD IN ('6','7','8','9','W','X') THEN '6'" ).append("\n"); 
		query.append("         END" ).append("\n"); 

	}
}