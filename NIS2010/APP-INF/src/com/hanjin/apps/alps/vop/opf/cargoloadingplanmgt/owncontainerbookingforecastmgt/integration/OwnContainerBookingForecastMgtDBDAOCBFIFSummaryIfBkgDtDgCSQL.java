/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgCSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDg
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgCSQL(){
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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_SPCL_SMRY ( VSL_CD                            " ).append("\n"); 
		query.append("                                        , SKD_VOY_NO                        " ).append("\n"); 
		query.append("                                        , SKD_DIR_CD                        " ).append("\n"); 
		query.append("                                        , YD_CD                             " ).append("\n"); 
		query.append("                                        , POL_CLPT_IND_SEQ                  " ).append("\n"); 
		query.append("                                        , CRR_CD                            " ).append("\n"); 
		query.append("                                        , POD_CD                            " ).append("\n"); 
		query.append("                                        , BLCK_STWG_CD                      " ).append("\n"); 
		query.append("                                        , CBF_SPCL_SMRY_SEQ                 " ).append("\n"); 
		query.append("                                        , CNTR_TPSZ_CD                      " ).append("\n"); 
		query.append("                                        , DCGO_FLG                          " ).append("\n"); 
		query.append("                                        , RC_FLG                            " ).append("\n"); 
		query.append("                                        , AWK_CGO_FLG                                                        " ).append("\n"); 
		query.append("                                        , IMDG_UN_NO                        " ).append("\n"); 
		query.append("                                        , IMDG_CLSS_CD                      " ).append("\n"); 
		query.append("                                        , MRN_POLUT_FLG                     " ).append("\n"); 
		query.append("                                        , CNTR_QTY                          " ).append("\n"); 
		query.append("                                        , STWG_CD                   " ).append("\n"); 
		query.append("                                        , IMDG_LMT_QTY_FLG " ).append("\n"); 
		query.append("                                        , CRE_USR_ID       " ).append("\n"); 
		query.append("                                        , CRE_DT           " ).append("\n"); 
		query.append("                                        , UPD_USR_ID       " ).append("\n"); 
		query.append("                                        , UPD_DT           " ).append("\n"); 
		query.append("                                        , BKG_NO           " ).append("\n"); 
		query.append("                                        , DG_CNTR_SEQ" ).append("\n"); 
		query.append("                                        , PRCT_FLG " ).append("\n"); 
		query.append("                                        , FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , BKG_REV_MCGO_FLG" ).append("\n"); 
		query.append("                                        , IMDG_SUBS_RSK_LBL_CD )" ).append("\n"); 
		query.append(" WITH NO_SPLIT AS (" ).append("\n"); 
		query.append("     SELECT *" ).append("\n"); 
		query.append("     FROM ( SELECT D.BKG_NO, D.CNTR_NO, D.CNTR_TPSZ_CD, D.IMDG_UN_NO, D.IMDG_CLSS_CD, D.IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                   D.MRN_POLUT_FLG,  D.CARGO_TYPE, D.STWG_CD, D.DG_CNTR_SEQ, D.POD_CD, D.MLB, D.IMDG_LMT_QTY_FLG, D.PRCT_FLG," ).append("\n"); 
		query.append("                   D.MTY_FLG, D.FM_BKG_NO, D.CNTR_VOL_QTY,D.SEQ," ).append("\n"); 
		query.append("                   CASE WHEN D.CNTR_NO IS NOT NULL THEN   " ).append("\n"); 
		query.append("                             COUNT(1) OVER(PARTITION BY D.CNTR_NO ) " ).append("\n"); 
		query.append("                        ELSE " ).append("\n"); 
		query.append("                             COUNT(1) OVER(PARTITION BY D.BKG_NO, D.DG_CNTR_SEQ ) " ).append("\n"); 
		query.append("                        END AS SCNT" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("       SELECT DISTINCT A.BKG_NO, A.CNTR_NO, A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD, IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                       CASE WHEN (SELECT DISTINCT DECODE(MRN_POLUT_FLG,'Y','Y','N')  " ).append("\n"); 
		query.append("                             FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                            WHERE BKG_NO        = A.BKG_NO" ).append("\n"); 
		query.append("                              AND MRN_POLUT_FLG = 'Y'" ).append("\n"); 
		query.append("                              AND DG_CNTR_SEQ   = A.DG_CNTR_SEQ" ).append("\n"); 
		query.append("                              AND NVL(SPCL_CGO_APRO_CD,'X') <> 'C' ) = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                             WHEN (  SELECT DISTINCT DECODE(MRN_POLUT_FLG,'Y','Y','N')" ).append("\n"); 
		query.append("                                       FROM BKG_DG_CGO A1, BKG_BOOKING B1,  BKG_VVD C1" ).append("\n"); 
		query.append("                                      WHERE A1.BKG_NO           = B1.BKG_NO " ).append("\n"); 
		query.append("                                        AND C1.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                                        AND C1.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                                        AND C1.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                        AND C1.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                                        AND C1.POL_YD_CD        =  @[pol_cd]" ).append("\n"); 
		query.append("                                        AND A1.BKG_NO           =  C1.BKG_NO" ).append("\n"); 
		query.append("                                        AND A1.CNTR_TPSZ_CD     NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                        AND A1.MRN_POLUT_FLG = 'Y'" ).append("\n"); 
		query.append("                                        AND B1.BKG_STS_CD        <> 'X'  " ).append("\n"); 
		query.append("                                        AND A1.CNTR_NO =  A.CNTR_NO" ).append("\n"); 
		query.append("                                        #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("				                        AND B1.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("                                        AND NVL(A.SPCL_CGO_APRO_CD,'X') <> 'N'" ).append("\n"); 
		query.append("				                        #end     " ).append("\n"); 
		query.append("                                        AND NVL(A1.SPCL_CGO_APRO_CD,'X') <> 'C' ) = 'Y'  THEN  'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                             END AS MRN_POLUT_FLG," ).append("\n"); 
		query.append("                     CASE WHEN (SELECT NVL(COUNT(1),0) " ).append("\n"); 
		query.append("                                      FROM BKG_AWK_CGO " ).append("\n"); 
		query.append("                                     WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                       AND CNTR_NO = A.CNTR_NO ) <> 0 THEN 'A'" ).append("\n"); 
		query.append("                          WHEN (  SELECT NVL(COUNT(1),0)" ).append("\n"); 
		query.append("                                    FROM BKG_RF_CGO" ).append("\n"); 
		query.append("                                   WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                     AND CNTR_NO = A.CNTR_NO ) <> 0 THEN 'R' " ).append("\n"); 
		query.append("                          ELSE NULL" ).append("\n"); 
		query.append("                          END AS CARGO_TYPE," ).append("\n"); 
		query.append("                     NVL(B.STWG_CD,' ') STWG_CD, DG_CNTR_SEQ," ).append("\n"); 
		query.append("                     C.POD_CD," ).append("\n"); 
		query.append("                     OPF_BLCK_STWG_CD(C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD, C.POL_YD_CD, C.POL_CLPT_IND_SEQ, B.BKG_NO) AS MLB, " ).append("\n"); 
		query.append("                     CASE WHEN( SELECT DISTINCT DECODE(IMDG_LMT_QTY_FLG,'N','N','Y')  " ).append("\n"); 
		query.append("                                FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                               WHERE BKG_NO            = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND IMDG_LMT_QTY_FLG  = 'N' " ).append("\n"); 
		query.append("                                 AND DG_CNTR_SEQ       = A.DG_CNTR_SEQ " ).append("\n"); 
		query.append("                                 AND NVL(SPCL_CGO_APRO_CD,'X') <> 'C'  )  = 'N' THEN 'N'" ).append("\n"); 
		query.append("                          WHEN (SELECT DISTINCT DECODE(IMDG_LMT_QTY_FLG,'N','N','Y')" ).append("\n"); 
		query.append("                                       FROM BKG_DG_CGO A1, BKG_BOOKING B1,  BKG_VVD C1" ).append("\n"); 
		query.append("                                      WHERE A1.BKG_NO           = B1.BKG_NO " ).append("\n"); 
		query.append("                                        AND C1.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                                        AND C1.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                                        AND C1.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                        AND C1.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                                        AND C1.POL_YD_CD        =  @[pol_cd]" ).append("\n"); 
		query.append("                                        AND A1.BKG_NO           =  C1.BKG_NO" ).append("\n"); 
		query.append("                                        AND A1.CNTR_TPSZ_CD     NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                        AND A1.IMDG_LMT_QTY_FLG = 'N' " ).append("\n"); 
		query.append("                                        AND B1.BKG_STS_CD        <> 'X'  " ).append("\n"); 
		query.append("                                        AND A1.CNTR_NO =  A.CNTR_NO" ).append("\n"); 
		query.append("                                         #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("				                        AND B1.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("                                        AND NVL(A.SPCL_CGO_APRO_CD,'X') <> 'N'" ).append("\n"); 
		query.append("				                        #end " ).append("\n"); 
		query.append("                                        AND NVL(A1.SPCL_CGO_APRO_CD,'X') <> 'C' ) ='N'  THEN  'N'     " ).append("\n"); 
		query.append("                            ELSE 'Y' " ).append("\n"); 
		query.append("                            END  AS IMDG_LMT_QTY_FLG  , " ).append("\n"); 
		query.append("                     B.PRCT_FLG, DECODE(B.BKG_CGO_TP_CD,'R','Y') MTY_FLG," ).append("\n"); 
		query.append("                     DECODE(A.CNTR_VOL_QTY ,1,NULL,B.BKG_NO) FM_BKG_NO," ).append("\n"); 
		query.append("                     A.CNTR_VOL_QTY," ).append("\n"); 
		query.append("                       CASE WHEN A.CNTR_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("                              RANK() OVER(PARTITION BY A.CNTR_NO ORDER BY A.BKG_NO, A.CNTR_NO,A.IMDG_UN_NO, A.IMDG_CLSS_CD, A.MRN_POLUT_FLG, A.IMDG_LMT_QTY_FLG, A.IMDG_SUBS_RSK_LBL_CD1, B.PRCT_FLG,B.STWG_CD, DECODE(B.BKG_CGO_TP_CD,'R','Y','N') )  --SEQ " ).append("\n"); 
		query.append("                            ELSE   " ).append("\n"); 
		query.append("                              RANK() OVER(PARTITION BY A.BKG_NO, A.DG_CNTR_SEQ ORDER BY A.BKG_NO, A.DG_CNTR_SEQ,A.IMDG_UN_NO, A.IMDG_CLSS_CD, A.MRN_POLUT_FLG, A.IMDG_LMT_QTY_FLG, A.IMDG_SUBS_RSK_LBL_CD1, B.PRCT_FLG,B.STWG_CD, DECODE(B.BKG_CGO_TP_CD,'R','Y','N') )  --SEQ " ).append("\n"); 
		query.append("                            END AS SEQ  " ).append("\n"); 
		query.append("                 FROM BKG_DG_CGO A, BKG_BOOKING B,  BKG_VVD C" ).append("\n"); 
		query.append("                WHERE A.BKG_NO           = B.BKG_NO " ).append("\n"); 
		query.append("                  AND C.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND C.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND C.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND C.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                  AND C.POL_YD_CD        =  @[pol_cd]" ).append("\n"); 
		query.append("                  AND A.BKG_NO           =  C.BKG_NO" ).append("\n"); 
		query.append("                  AND A.CNTR_TPSZ_CD     NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                  AND B.BKG_STS_CD        <> 'X' " ).append("\n"); 
		query.append("                  #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("				   AND B.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("                   AND NVL(A.SPCL_CGO_APRO_CD,'X') <> 'N'" ).append("\n"); 
		query.append("				  #end                  " ).append("\n"); 
		query.append("                   AND NVL(A.SPCL_CGO_APRO_CD,'X') <> 'C'   ) D" ).append("\n"); 
		query.append("                  ) X --SPLIT없이 CO-LOAD인 경우 DCNT <> 1 AND SEQ  다수 CAIU8405516" ).append("\n"); 
		query.append("          WHERE ( X.SCNT = 1 OR ( X.SCNT <> 1 AND X.SEQ = 1 ))  AND X.FM_BKG_NO IS NULL ) , " ).append("\n"); 
		query.append("     SPLIT_BKG AS (" ).append("\n"); 
		query.append("       SELECT DISTINCT  DECODE(DCNT,1,NULL, FM_BKG_NO) FM_BKG_NO, CNTR_TPSZ_CD,CNTR_NO,IMDG_UN_NO, IMDG_CLSS_CD, MRN_POLUT_FLG, IMDG_LMT_QTY_FLG, IMDG_SUBS_RSK_LBL_CD1, " ).append("\n"); 
		query.append("              PRCT_FLG,MTY_FLG,CARGO_TYPE,POD_CD, MLB, DG_CNTR_SEQ,STWG_CD, DCNT, SEQ" ).append("\n"); 
		query.append("          FROM (  " ).append("\n"); 
		query.append("           SELECT D.CNTR_NO, D.CNTR_TPSZ_CD, D.IMDG_UN_NO, D.IMDG_CLSS_CD, D.IMDG_SUBS_RSK_LBL_CD1, D.MRN_POLUT_FLG, D.CARGO_TYPE," ).append("\n"); 
		query.append("                  D.STWG_CD,  " ).append("\n"); 
		query.append("                  NVL(( SELECT MIN(DG_CNTR_SEQ)" ).append("\n"); 
		query.append("                          FROM BKG_DG_CGO WHERE BKG_NO =  ( SELECT MIN(X.BKG_NO) " ).append("\n"); 
		query.append("                                                              FROM BKG_BOOKING X, BKG_DG_CGO Y" ).append("\n"); 
		query.append("                                                             WHERE ( X.FM_BKG_NO = D.FM_BKG_NO OR X.BKG_NO = D.FM_BKG_NO )" ).append("\n"); 
		query.append("                                                               AND   X.BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("                                                               AND   Y.CNTR_NO = D.CNTR_NO )" ).append("\n"); 
		query.append("                                            AND CNTR_NO = D.CNTR_NO ),1)  AS DG_CNTR_SEQ, " ).append("\n"); 
		query.append("                  D.POD_CD, D.MLB, D.IMDG_LMT_QTY_FLG, D.PRCT_FLG,  D.MTY_FLG," ).append("\n"); 
		query.append("                  NVL(( SELECT MIN(X.BKG_NO) FROM BKG_BOOKING X, BKG_DG_CGO Y" ).append("\n"); 
		query.append("                            WHERE (X.FM_BKG_NO = D.FM_BKG_NO OR X.BKG_NO = D.FM_BKG_NO )" ).append("\n"); 
		query.append("                              AND X.BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("                              AND Y.CNTR_NO = D.CNTR_NO ),D.FM_BKG_NO) AS FM_BKG_NO, D.SEQ," ).append("\n"); 
		query.append("                  COUNT(1) OVER(PARTITION BY FM_BKG_NO, NVL(D.CNTR_NO,ROWNUM)) DCNT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT A.CNTR_NO, A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD, IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                        CASE WHEN (SELECT DISTINCT DECODE(MRN_POLUT_FLG,'Y','Y','N')  " ).append("\n"); 
		query.append("                             FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                            WHERE BKG_NO        = A.BKG_NO" ).append("\n"); 
		query.append("                              AND MRN_POLUT_FLG = 'Y'" ).append("\n"); 
		query.append("                              AND DG_CNTR_SEQ   = A.DG_CNTR_SEQ " ).append("\n"); 
		query.append("                              AND NVL(SPCL_CGO_APRO_CD,'X') <> 'C'  ) = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                             WHEN (  SELECT DISTINCT DECODE(MRN_POLUT_FLG,'Y','Y','N')" ).append("\n"); 
		query.append("                                       FROM BKG_DG_CGO A1, BKG_BOOKING B1,  BKG_VVD C1" ).append("\n"); 
		query.append("                                      WHERE A1.BKG_NO           = B1.BKG_NO " ).append("\n"); 
		query.append("                                        AND C1.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                                        AND C1.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                                        AND C1.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                        AND C1.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                                        AND C1.POL_YD_CD        =  @[pol_cd]" ).append("\n"); 
		query.append("                                        AND A1.BKG_NO           =  C1.BKG_NO" ).append("\n"); 
		query.append("                                        AND A1.CNTR_TPSZ_CD     NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                        AND A1.MRN_POLUT_FLG = 'Y'" ).append("\n"); 
		query.append("                                        AND B1.BKG_STS_CD        <> 'X'  " ).append("\n"); 
		query.append("                                        AND A1.CNTR_NO =  A.CNTR_NO" ).append("\n"); 
		query.append("                                        #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("				                        AND B1.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("                                        AND NVL(A1.SPCL_CGO_APRO_CD,'X') <> 'N'" ).append("\n"); 
		query.append("				                        #end     " ).append("\n"); 
		query.append("                                        AND NVL(A1.SPCL_CGO_APRO_CD,'X') <> 'C' ) = 'Y'  THEN  'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                           END AS MRN_POLUT_FLG, " ).append("\n"); 
		query.append("                            CASE WHEN (SELECT NVL(COUNT(1),0) " ).append("\n"); 
		query.append("                                      FROM BKG_AWK_CGO " ).append("\n"); 
		query.append("                                     WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                       AND CNTR_NO = A.CNTR_NO ) <> 0 THEN 'A'" ).append("\n"); 
		query.append("                                 WHEN ( SELECT NVL(COUNT(1),0)" ).append("\n"); 
		query.append("                                         FROM BKG_RF_CGO" ).append("\n"); 
		query.append("                                        WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                          AND CNTR_NO = A.CNTR_NO ) <> 0 THEN 'R' " ).append("\n"); 
		query.append("                                 ELSE NULL" ).append("\n"); 
		query.append("                                 END AS CARGO_TYPE," ).append("\n"); 
		query.append("                           NVL(B.STWG_CD,' ')  STWG_CD, C.POD_CD," ).append("\n"); 
		query.append("                           OPF_BLCK_STWG_CD(C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD, C.POL_YD_CD, C.POL_CLPT_IND_SEQ, B.BKG_NO) AS MLB, " ).append("\n"); 
		query.append("                           CASE WHEN( SELECT DISTINCT DECODE(IMDG_LMT_QTY_FLG,'N','N','Y')  " ).append("\n"); 
		query.append("                                        FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                                       WHERE BKG_NO            = A.BKG_NO" ).append("\n"); 
		query.append("                                         AND IMDG_LMT_QTY_FLG  = 'N' " ).append("\n"); 
		query.append("                                         AND DG_CNTR_SEQ       = A.DG_CNTR_SEQ" ).append("\n"); 
		query.append("                                         AND NVL(SPCL_CGO_APRO_CD,'X') <> 'C'  )  = 'N' THEN 'N'" ).append("\n"); 
		query.append("                                WHEN (SELECT DISTINCT DECODE(IMDG_LMT_QTY_FLG,'N','N','Y')" ).append("\n"); 
		query.append("                                       FROM BKG_DG_CGO A1, BKG_BOOKING B1,  BKG_VVD C1" ).append("\n"); 
		query.append("                                      WHERE A1.BKG_NO           = B1.BKG_NO " ).append("\n"); 
		query.append("                                        AND C1.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                                        AND C1.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                                        AND C1.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                        AND C1.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                                        AND C1.POL_YD_CD        =  @[pol_cd]" ).append("\n"); 
		query.append("                                        AND A1.BKG_NO           =  C1.BKG_NO" ).append("\n"); 
		query.append("                                        AND A1.CNTR_TPSZ_CD     NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                        AND A1.IMDG_LMT_QTY_FLG = 'N' " ).append("\n"); 
		query.append("                                        AND B1.BKG_STS_CD        <> 'X'  " ).append("\n"); 
		query.append("                                        AND A1.CNTR_NO =  A.CNTR_NO" ).append("\n"); 
		query.append("                                         #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("				                        AND B1.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("                                        AND NVL(A1.SPCL_CGO_APRO_CD,'X') <> 'N'" ).append("\n"); 
		query.append("				                        #end " ).append("\n"); 
		query.append("                                        AND NVL(A1.SPCL_CGO_APRO_CD,'X') <> 'C' ) ='N'  THEN  'N'     " ).append("\n"); 
		query.append("                               ELSE 'Y' " ).append("\n"); 
		query.append("                               END  AS IMDG_LMT_QTY_FLG, B.PRCT_FLG, DECODE(B.BKG_CGO_TP_CD,'R','Y') MTY_FLG," ).append("\n"); 
		query.append("                        DECODE(A.CNTR_VOL_QTY ,1,NULL, NVL(B.FM_BKG_NO,B.BKG_NO)) FM_BKG_NO," ).append("\n"); 
		query.append("                        RANK() OVER(PARTITION BY A.CNTR_NO ORDER BY A.CNTR_NO,A.IMDG_UN_NO, A.IMDG_CLSS_CD, A.MRN_POLUT_FLG, A.IMDG_LMT_QTY_FLG, A.IMDG_SUBS_RSK_LBL_CD1, B.PRCT_FLG,B.STWG_CD, DECODE(B.BKG_CGO_TP_CD,'R','Y','N') ) SEQ " ).append("\n"); 
		query.append("                   FROM BKG_DG_CGO A, BKG_BOOKING B,  BKG_VVD C" ).append("\n"); 
		query.append("                  WHERE A.BKG_NO           = B.BKG_NO " ).append("\n"); 
		query.append("                    AND C.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                    AND C.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND C.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    AND C.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                    AND C.POL_YD_CD        = @[pol_cd]" ).append("\n"); 
		query.append("                    AND A.BKG_NO           = C.BKG_NO" ).append("\n"); 
		query.append("                    AND A.CNTR_TPSZ_CD     NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                    AND B.BKG_STS_CD        <> 'X' " ).append("\n"); 
		query.append("	                #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("					AND B.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("                    AND NVL(A.SPCL_CGO_APRO_CD,'X') <> 'N' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("                    AND NVL(A.SPCL_CGO_APRO_CD,'X') <> 'C' ) D" ).append("\n"); 
		query.append("		     ) X" ).append("\n"); 
		query.append("         WHERE X.FM_BKG_NO IS NOT NULL  ) " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT @[vsl_cd] ,@[skd_voy_no] , @[skd_dir_cd] ,  @[pol_cd] , @[pol_clpt_ind_seq], 'SML', BB.POD_CD, SUBSTR(BB.MLB,3,5), BB.CBF_SPCL_SMRY_SEQ+ROWNUM," ).append("\n"); 
		query.append("       BB.CNTR_TPSZ_CD, 'Y', DECODE(BB.CARGO_TYPE,'R','Y',NULL), DECODE(BB.CARGO_TYPE,'A','Y',NULL), " ).append("\n"); 
		query.append("       BB.IMDG_UN_NO, BB.IMDG_CLSS_CD, BB.MRN_POLUT_FLG, BB.CNTR_QTY, BB.STWG_CD ,   BB.IMDG_LMT_QTY_FLG, @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE, @[upd_usr_id] , SYSDATE , BB.BKG_NO,BB.DG_CNTR_SEQ, BB.PRCT_FLG," ).append("\n"); 
		query.append("       BB.OVR_FWRD_LEN, BB.OVR_BKWD_LEN,BB.OVR_HGT,BB.OVR_LF_LEN, BB.OVR_RT_LEN, BB.MTY_FLG, BB.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("FROM (     " ).append("\n"); 
		query.append("  SELECT AA.POD_CD, AA.MLB, AA.CNTR_TPSZ_CD, AA.IMDG_UN_NO, AA.IMDG_CLSS_CD, AA.MRN_POLUT_FLG, AA.CNTR_QTY, AA.BKG_NO,CARGO_TYPE, STWG_CD,IMDG_LMT_QTY_FLG,DG_CNTR_SEQ," ).append("\n"); 
		query.append("        AA.PRCT_FLG,  ( SELECT NVL(MAX(CBF_SPCL_SMRY_SEQ),0)" ).append("\n"); 
		query.append("                    FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                    WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    AND YD_CD        = @[pol_cd]" ).append("\n"); 
		query.append("                    AND POL_CLPT_IND_SEQ =   @[pol_clpt_ind_seq] ) AS CBF_SPCL_SMRY_SEQ  ," ).append("\n"); 
		query.append("         AA.OVR_FWRD_LEN, AA.OVR_BKWD_LEN,AA.OVR_HGT,AA.OVR_LF_LEN, AA.OVR_RT_LEN, AA.MTY_FLG,AA.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(" FROM ( " ).append("\n"); 
		query.append("   SELECT X.MLB, X.POD_CD, X.CNTR_TPSZ_CD, X.IMDG_UN_NO, X.IMDG_CLSS_CD, X.IMDG_SUBS_RSK_LBL_CD1, X.MRN_POLUT_FLG, X.IMDG_LMT_QTY_FLG, X.PRCT_FLG, " ).append("\n"); 
		query.append("          X.STWG_CD,X.CARGO_TYPE,X.OVR_FWRD_LEN, X.OVR_BKWD_LEN,X.OVR_HGT,X.OVR_LF_LEN, X.OVR_RT_LEN , X.MTY_FLG,  X.BKG_NO,  " ).append("\n"); 
		query.append("          CASE WHEN X.BKG_NO IS NOT NULL THEN X.DG_CNTR_SEQ " ).append("\n"); 
		query.append("               ELSE NULL" ).append("\n"); 
		query.append("          END DG_CNTR_SEQ," ).append("\n"); 
		query.append("          COUNT(1) CNTR_QTY" ).append("\n"); 
		query.append("     FROM (  SELECT NULL BKG_NO, NULL CNTR_NO, CNTR_TPSZ_CD, IMDG_UN_NO, IMDG_CLSS_CD,IMDG_SUBS_RSK_LBL_CD1, MRN_POLUT_FLG, CARGO_TYPE, STWG_CD, DG_CNTR_SEQ, " ).append("\n"); 
		query.append("                    POD_CD, CNTR_VOL_QTY, MLB,IMDG_LMT_QTY_FLG,PRCT_FLG,NULL FM_BKG_NO, MTY_FLG," ).append("\n"); 
		query.append("                    NULL OVR_FWRD_LEN, NULL OVR_BKWD_LEN, NULL OVR_HGT, NULL OVR_LF_LEN, NULL OVR_RT_LEN" ).append("\n"); 
		query.append("              FROM NO_SPLIT" ).append("\n"); 
		query.append("             WHERE FM_BKG_NO IS NULL -- SPLIT 안된거, AWK CARGO가 아닌거, " ).append("\n"); 
		query.append("               AND NVL(CARGO_TYPE,'X') <> 'A'" ).append("\n"); 
		query.append("               AND SCNT = 1" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("             SELECT NULL BKG_NO, NULL CNTR_NO, A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD,A.IMDG_SUBS_RSK_LBL_CD1, A.MRN_POLUT_FLG, A.CARGO_TYPE, A.STWG_CD, A.DG_CNTR_SEQ, " ).append("\n"); 
		query.append("                    A.POD_CD, A.CNTR_VOL_QTY, A.MLB,A.IMDG_LMT_QTY_FLG,A.PRCT_FLG,NULL FM_BKG_NO, MTY_FLG," ).append("\n"); 
		query.append("                    B.OVR_FWRD_LEN, B.OVR_BKWD_LEN,B.OVR_HGT,B.OVR_LF_LEN, B.OVR_RT_LEN " ).append("\n"); 
		query.append("               FROM NO_SPLIT A, BKG_AWK_CGO B" ).append("\n"); 
		query.append("              WHERE A.FM_BKG_NO IS NULL -- SPLIT 안된거, AWK CARGO 인거" ).append("\n"); 
		query.append("                AND NVL(A.CARGO_TYPE,'X') = 'A'" ).append("\n"); 
		query.append("                AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                AND SCNT     = 1 " ).append("\n"); 
		query.append("                AND NVL(A.CNTR_NO,'') = NVL(B.CNTR_NO,'')" ).append("\n"); 
		query.append("                AND A.CNTR_TPSZ_CD    = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT BKG_NO, CNTR_NO, CNTR_TPSZ_CD, IMDG_UN_NO, IMDG_CLSS_CD,IMDG_SUBS_RSK_LBL_CD1, MRN_POLUT_FLG, CARGO_TYPE, STWG_CD, DG_CNTR_SEQ, " ).append("\n"); 
		query.append("                    POD_CD, CNTR_VOL_QTY, MLB,IMDG_LMT_QTY_FLG,PRCT_FLG,NULL FM_BKG_NO, MTY_FLG," ).append("\n"); 
		query.append("                    NULL OVR_FWRD_LEN, NULL OVR_BKWD_LEN, NULL OVR_HGT, NULL OVR_LF_LEN, NULL OVR_RT_LEN" ).append("\n"); 
		query.append("               FROM NO_SPLIT" ).append("\n"); 
		query.append("              WHERE FM_BKG_NO IS NULL -- SPLIT 안된거, AWK CARGO가 아닌거, " ).append("\n"); 
		query.append("                AND NVL(CARGO_TYPE,'X') <> 'A'" ).append("\n"); 
		query.append("                AND SCNT <> 1" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("            SELECT A.BKG_NO, A.CNTR_NO, A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD,A.IMDG_SUBS_RSK_LBL_CD1, A.MRN_POLUT_FLG, A.CARGO_TYPE, A.STWG_CD, A.DG_CNTR_SEQ," ).append("\n"); 
		query.append("                   A.POD_CD, A.CNTR_VOL_QTY,A.MLB,A.IMDG_LMT_QTY_FLG,A.PRCT_FLG,NULL FM_BKG_NO, MTY_FLG," ).append("\n"); 
		query.append("                   B.OVR_FWRD_LEN, B.OVR_BKWD_LEN,B.OVR_HGT,B.OVR_LF_LEN, B.OVR_RT_LEN " ).append("\n"); 
		query.append("              FROM NO_SPLIT A, BKG_AWK_CGO B" ).append("\n"); 
		query.append("             WHERE A.FM_BKG_NO IS NULL -- SPLIT 안된거, AWK CARGO 인거" ).append("\n"); 
		query.append("               AND NVL(A.CARGO_TYPE,'X') = 'A'" ).append("\n"); 
		query.append("               AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("               AND SCNT <> 1 " ).append("\n"); 
		query.append("               AND NVL(A.CNTR_NO,'') = NVL(B.CNTR_NO,'')" ).append("\n"); 
		query.append("               AND A.CNTR_TPSZ_CD    = B.CNTR_TPSZ_CD ) X" ).append("\n"); 
		query.append("      GROUP BY X.MLB, X.POD_CD, X.CNTR_TPSZ_CD, X.IMDG_UN_NO, X.IMDG_CLSS_CD, X.IMDG_SUBS_RSK_LBL_CD1, X.MRN_POLUT_FLG, X.IMDG_LMT_QTY_FLG, X.PRCT_FLG, X.STWG_CD,X.CARGO_TYPE," ).append("\n"); 
		query.append("               X.OVR_FWRD_LEN, X.OVR_BKWD_LEN,X.OVR_HGT,X.OVR_LF_LEN, X.OVR_RT_LEN , X.MTY_FLG,X.BKG_NO,X.CNTR_NO  ," ).append("\n"); 
		query.append("               CASE WHEN X.BKG_NO IS NOT NULL THEN X.DG_CNTR_SEQ " ).append("\n"); 
		query.append("                    ELSE NULL" ).append("\n"); 
		query.append("               END   " ).append("\n"); 
		query.append("      UNION ALL  " ).append("\n"); 
		query.append("    SELECT  YY.MLB, YY.POD_CD, YY.CNTR_TPSZ_CD, YY.IMDG_UN_NO, YY.IMDG_CLSS_CD, YY.IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("            NVL((SELECT DISTINCT DECODE(MRN_POLUT_FLG,'Y','Y','N')   " ).append("\n"); 
		query.append("                   FROM SPLIT_BKG " ).append("\n"); 
		query.append("                  WHERE MLB          = YY.MLB " ).append("\n"); 
		query.append("                    AND POD_CD       = YY.POD_CD " ).append("\n"); 
		query.append("                    AND CNTR_TPSZ_CD = YY.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                    AND IMDG_UN_NO   = YY.IMDG_UN_NO " ).append("\n"); 
		query.append("                    AND IMDG_CLSS_CD = YY.IMDG_CLSS_CD " ).append("\n"); 
		query.append("                    AND NVL(IMDG_SUBS_RSK_LBL_CD1,'X') = NVL(YY.IMDG_SUBS_RSK_LBL_CD1,'X') " ).append("\n"); 
		query.append("                    AND MRN_POLUT_FLG           = 'Y'" ).append("\n"); 
		query.append("                    AND NVL(PRCT_FLG,'X')       = NVL(YY.PRCT_FLG,'X') " ).append("\n"); 
		query.append("                    AND NVL(STWG_CD,'X')        = NVL(YY.STWG_CD,'X') " ).append("\n"); 
		query.append("                    AND NVL(CARGO_TYPE,'X')     = NVL(YY.CARGO_TYPE,'X') " ).append("\n"); 
		query.append("                    AND NVL(OVR_FWRD_LEN,0)     = NVL(YY.OVR_FWRD_LEN,0) " ).append("\n"); 
		query.append("                    AND NVL(OVR_BKWD_LEN,0)     = NVL(YY.OVR_BKWD_LEN,0) " ).append("\n"); 
		query.append("                    AND NVL(OVR_HGT,0)          = NVL(YY.OVR_HGT,0) " ).append("\n"); 
		query.append("                    AND NVL(OVR_LF_LEN,0)       = NVL(YY.OVR_LF_LEN,0) " ).append("\n"); 
		query.append("                    AND NVL(OVR_RT_LEN,0)       = NVL(YY.OVR_RT_LEN,0) " ).append("\n"); 
		query.append("                    AND NVL(MTY_FLG,'X')        = NVL(YY.MTY_FLG,'X') " ).append("\n"); 
		query.append("                    AND NVL(FM_BKG_NO,'X')      = NVL(YY.FM_BKG_NO,'X') ),'N' ) AS MRN_POLUT_FLG," ).append("\n"); 
		query.append("            NVL((SELECT  DISTINCT DECODE(IMDG_LMT_QTY_FLG,'N','N','Y')    " ).append("\n"); 
		query.append("                   FROM SPLIT_BKG " ).append("\n"); 
		query.append("                  WHERE MLB          = YY.MLB " ).append("\n"); 
		query.append("                    AND POD_CD       = YY.POD_CD " ).append("\n"); 
		query.append("                    AND CNTR_TPSZ_CD = YY.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                    AND IMDG_UN_NO   = YY.IMDG_UN_NO " ).append("\n"); 
		query.append("                    AND IMDG_CLSS_CD = YY.IMDG_CLSS_CD " ).append("\n"); 
		query.append("                    AND NVL(IMDG_SUBS_RSK_LBL_CD1,'X') = NVL(YY.IMDG_SUBS_RSK_LBL_CD1,'X') " ).append("\n"); 
		query.append("                    AND IMDG_LMT_QTY_FLG = 'N'" ).append("\n"); 
		query.append("                    AND NVL(PRCT_FLG,'X')       = NVL(YY.PRCT_FLG,'X') " ).append("\n"); 
		query.append("                    AND NVL(STWG_CD,'X')        = NVL(YY.STWG_CD,'X') " ).append("\n"); 
		query.append("                    AND NVL(CARGO_TYPE,'X')     = NVL(YY.CARGO_TYPE,'X') " ).append("\n"); 
		query.append("                    AND NVL(OVR_FWRD_LEN,0)     = NVL(YY.OVR_FWRD_LEN,0) " ).append("\n"); 
		query.append("                    AND NVL(OVR_BKWD_LEN,0)     = NVL(YY.OVR_BKWD_LEN,0) " ).append("\n"); 
		query.append("                    AND NVL(OVR_HGT,0)          = NVL(YY.OVR_HGT,0) " ).append("\n"); 
		query.append("                    AND NVL(OVR_LF_LEN,0)       = NVL(YY.OVR_LF_LEN,0) " ).append("\n"); 
		query.append("                    AND NVL(OVR_RT_LEN,0)       = NVL(YY.OVR_RT_LEN,0) " ).append("\n"); 
		query.append("                    AND NVL(MTY_FLG,'X')        = NVL(YY.MTY_FLG,'X') " ).append("\n"); 
		query.append("                    AND NVL(FM_BKG_NO,'X')      = NVL(YY.FM_BKG_NO,'X') ),'N' ) AS IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("            YY.PRCT_FLG,YY.STWG_CD,YY.CARGO_TYPE," ).append("\n"); 
		query.append("            YY.OVR_FWRD_LEN, YY.OVR_BKWD_LEN,YY.OVR_HGT,YY.OVR_LF_LEN, YY.OVR_RT_LEN , YY.MTY_FLG, YY.FM_BKG_NO ,  YY.DG_CNTR_SEQ, SUM(CNTR_QTY)" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("     SELECT Z.MLB, Z.POD_CD, Z.CNTR_TPSZ_CD, Z.IMDG_UN_NO, Z.IMDG_CLSS_CD, Z.IMDG_SUBS_RSK_LBL_CD1, Z.MRN_POLUT_FLG, Z.IMDG_LMT_QTY_FLG, Z.PRCT_FLG,Z.STWG_CD,Z.CARGO_TYPE," ).append("\n"); 
		query.append("            Z.OVR_FWRD_LEN, Z.OVR_BKWD_LEN,Z.OVR_HGT,Z.OVR_LF_LEN, Z.OVR_RT_LEN , Z.MTY_FLG, Z.FM_BKG_NO ,  DG_CNTR_SEQ , 1 CNTR_QTY     " ).append("\n"); 
		query.append("      FROM (    SELECT FM_BKG_NO, CNTR_NO, CNTR_TPSZ_CD,  IMDG_UN_NO, IMDG_CLSS_CD,  IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                       CARGO_TYPE, STWG_CD  ," ).append("\n"); 
		query.append("                      CASE WHEN FM_BKG_NO IS NOT NULL THEN DG_CNTR_SEQ " ).append("\n"); 
		query.append("                           ELSE NULL" ).append("\n"); 
		query.append("                           END DG_CNTR_SEQ ,POD_CD, NULL CNTR_VOL_QTY,MLB," ).append("\n"); 
		query.append("                       MRN_POLUT_FLG,    " ).append("\n"); 
		query.append("                       IMDG_LMT_QTY_FLG, " ).append("\n"); 
		query.append("                       PRCT_FLG, MTY_FLG," ).append("\n"); 
		query.append("                       NULL OVR_FWRD_LEN, NULL OVR_BKWD_LEN, NULL OVR_HGT, NULL OVR_LF_LEN, NULL OVR_RT_LEN,DCNT, 'A1' CHK " ).append("\n"); 
		query.append("                  FROM SPLIT_BKG X" ).append("\n"); 
		query.append("                 WHERE SEQ = 1" ).append("\n"); 
		query.append("                   AND NVL(CARGO_TYPE,'X') <> 'A'" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT X.FM_BKG_NO, X.CNTR_NO, X.CNTR_TPSZ_CD,  IMDG_UN_NO, IMDG_CLSS_CD,  IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                        CARGO_TYPE, STWG_CD  ," ).append("\n"); 
		query.append("                          CASE WHEN FM_BKG_NO IS NOT NULL THEN DG_CNTR_SEQ " ).append("\n"); 
		query.append("                           ELSE NULL" ).append("\n"); 
		query.append("                           END DG_CNTR_SEQ ,POD_CD, NULL CNTR_VOL_QTY,MLB," ).append("\n"); 
		query.append("                           MRN_POLUT_FLG,    " ).append("\n"); 
		query.append("                           IMDG_LMT_QTY_FLG, " ).append("\n"); 
		query.append("                           PRCT_FLG, MTY_FLG," ).append("\n"); 
		query.append("                           Y.OVR_FWRD_LEN, Y.OVR_BKWD_LEN,Y.OVR_HGT,Y.OVR_LF_LEN, Y.OVR_RT_LEN , DCNT,'B1' CHK" ).append("\n"); 
		query.append("                   FROM SPLIT_BKG X, BKG_AWK_CGO Y" ).append("\n"); 
		query.append("                  WHERE SEQ = 1" ).append("\n"); 
		query.append("                    AND NVL(X.CARGO_TYPE,'X') = 'A'" ).append("\n"); 
		query.append("                    AND ( X.FM_BKG_NO = Y.BKG_NO OR  Y.BKG_NO IN ( SELECT BKG_NO FROM BKG_BOOKING WHERE FM_BKG_NO = X.FM_BKG_NO AND SPLIT_FLG ='Y'))" ).append("\n"); 
		query.append("                    AND NVL(X.CNTR_NO,'') = NVL(Y.CNTR_NO,'')" ).append("\n"); 
		query.append("                    AND X.CNTR_TPSZ_CD    = Y.CNTR_TPSZ_CD   ) Z ) YY" ).append("\n"); 
		query.append("                   GROUP BY  " ).append("\n"); 
		query.append("                    YY.MLB, YY.POD_CD, YY.CNTR_TPSZ_CD, YY.IMDG_UN_NO, YY.IMDG_CLSS_CD, YY.IMDG_SUBS_RSK_LBL_CD1, YY.MRN_POLUT_FLG, YY.IMDG_LMT_QTY_FLG, YY.PRCT_FLG,YY.STWG_CD,YY.CARGO_TYPE," ).append("\n"); 
		query.append("                    YY.OVR_FWRD_LEN, YY.OVR_BKWD_LEN,YY.OVR_HGT,YY.OVR_LF_LEN, YY.OVR_RT_LEN , YY.MTY_FLG, YY.FM_BKG_NO ,  YY.DG_CNTR_SEQ  ) AA ) BB" ).append("\n"); 

	}
}