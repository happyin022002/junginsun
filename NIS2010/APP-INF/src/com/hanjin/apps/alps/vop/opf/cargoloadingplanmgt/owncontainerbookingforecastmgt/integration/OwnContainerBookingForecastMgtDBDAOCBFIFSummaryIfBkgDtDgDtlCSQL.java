/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgDtlCSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgDtl
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgDtlCSQL").append("\n"); 
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
		query.append("--HJGO0013W 때문에 길어짐" ).append("\n"); 
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_DG_DTL ( VSL_CD," ).append("\n"); 
		query.append("                                          SKD_VOY_NO," ).append("\n"); 
		query.append("                                          SKD_DIR_CD," ).append("\n"); 
		query.append("                                          YD_CD," ).append("\n"); 
		query.append("                                          POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                          CRR_CD," ).append("\n"); 
		query.append("                                          POD_CD," ).append("\n"); 
		query.append("                                          BLCK_STWG_CD," ).append("\n"); 
		query.append("                                          CBF_SMRY_SEQ," ).append("\n"); 
		query.append("                                          CBF_SMRY_DCGO_SEQ," ).append("\n"); 
		query.append("                                          CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                          IMDG_UN_NO," ).append("\n"); 
		query.append("                                          IMDG_CLSS_CD," ).append("\n"); 
		query.append("                                          MRN_POLUT_FLG," ).append("\n"); 
		query.append("                                          IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("                                          IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("                                          CRE_USR_ID," ).append("\n"); 
		query.append("                                          CRE_DT," ).append("\n"); 
		query.append("                                          UPD_USR_ID," ).append("\n"); 
		query.append("                                          UPD_DT )" ).append("\n"); 
		query.append(" SELECT " ).append("\n"); 
		query.append("        VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , YD_CD" ).append("\n"); 
		query.append("        , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , CRR_CD" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , BLCK_STWG_CD" ).append("\n"); 
		query.append("        , CBF_SPCL_SMRY_SEQ" ).append("\n"); 
		query.append("        , CBF_SMRY_DCGO_SEQ + ROWNUM" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD " ).append("\n"); 
		query.append("        , IMDG_UN_NO" ).append("\n"); 
		query.append("        , IMDG_CLSS_CD" ).append("\n"); 
		query.append("        , MRN_POLUT_FLG" ).append("\n"); 
		query.append("        , IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("        , IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE        " ).append("\n"); 
		query.append("FROM    ( " ).append("\n"); 
		query.append(" WITH DG_BKG AS (  " ).append("\n"); 
		query.append("     SELECT DISTINCT C.CNTR_NO, B.BKG_NO, D.CBF_SPCL_SMRY_SEQ, D.DG_CNTR_SEQ, D.POL_CLPT_IND_SEQ , D.YD_CD," ).append("\n"); 
		query.append("                     D.CRR_CD,  D.POD_CD, D.BLCK_STWG_CD, D.CNTR_TPSZ_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("       FROM BKG_VVD A, BKG_BOOKING B, BKG_DG_CGO C, OPF_CGO_BKG_FCAST_SPCL_SMRY D" ).append("\n"); 
		query.append("      WHERE A.VSL_CD     = D.VSL_CD" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND D.YD_CD      = A.POL_YD_CD" ).append("\n"); 
		query.append("        AND A.POL_CLPT_IND_SEQ  = D.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND A.POL_YD_CD  = @[pol_cd]" ).append("\n"); 
		query.append("        AND A.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("        AND D.CRR_CD           ='SML'" ).append("\n"); 
		query.append("        AND D.DCGO_FLG         ='Y'" ).append("\n"); 
		query.append("        AND A.BKG_NO     = B.BKG_NO" ).append("\n"); 
		query.append("        AND B.BKG_NO     = C.BKG_NO " ).append("\n"); 
		query.append("        AND B.BKG_NO     = D.BKG_NO)," ).append("\n"); 
		query.append("    SPLIT_BKG AS (" ).append("\n"); 
		query.append("       SELECT B.FM_BKG_NO,B.BKG_NO, B.BKG_CRE_TP_CD ,B.SPLIT_FLG, A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD , A.CBF_SPCL_SMRY_SEQ," ).append("\n"); 
		query.append("               A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BLCK_STWG_CD, A.POD_CD, A.CRR_CD," ).append("\n"); 
		query.append("               A.DG_CNTR_SEQ, A.POL_CLPT_IND_SEQ , A.YD_CD" ).append("\n"); 
		query.append("         FROM OPF_CGO_BKG_FCAST_SPCL_SMRY A, BKG_BOOKING B" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          AND A.VSL_CD     =  @[vsl_cd]" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD =  @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND A.YD_CD  =      @[pol_cd]" ).append("\n"); 
		query.append("          AND A.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("          AND A.CRR_CD           ='SML'" ).append("\n"); 
		query.append("          AND A.DCGO_FLG         ='Y' " ).append("\n"); 
		query.append("          AND B.SPLIT_FLG        ='Y'" ).append("\n"); 
		query.append("          AND NOT EXISTS ( SELECT * FROM BKG_DG_CGO WHERE BKG_NO = A.BKG_NO ) )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT DISTINCT Z.VSL_CD, Z.SKD_VOY_NO, Z.SKD_DIR_CD, Z.YD_CD, Z.POL_CLPT_IND_SEQ, Z.CRR_CD," ).append("\n"); 
		query.append("                         Z.POD_CD,Z.BLCK_STWG_CD, Z.CBF_SPCL_SMRY_SEQ,  " ).append("\n"); 
		query.append("                          ( SELECT NVL(MAX(CBF_SMRY_DCGO_SEQ),0) " ).append("\n"); 
		query.append("                             FROM  OPF_CGO_BKG_FCAST_DG_DTL" ).append("\n"); 
		query.append("                            WHERE  VSL_CD      =  @[vsl_cd]" ).append("\n"); 
		query.append("                              AND  SKD_VOY_NO  =  @[skd_voy_no]" ).append("\n"); 
		query.append("                              AND  SKD_DIR_CD  =  @[skd_dir_cd]" ).append("\n"); 
		query.append("                              AND  YD_CD       =  @[pol_cd]" ).append("\n"); 
		query.append("                              AND  POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq] ) AS CBF_SMRY_DCGO_SEQ," ).append("\n"); 
		query.append("                            Z.CNTR_TPSZ_CD ,  Z.IMDG_UN_NO,Z.IMDG_CLSS_CD," ).append("\n"); 
		query.append("                            Z.MRN_POLUT_FLG, Z.IMDG_LMT_QTY_FLG, Z.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(" FROM ( " ).append("\n"); 
		query.append("SELECT DISTINCT X.BKG_NO,X.CNTR_NO, X.CBF_SPCL_SMRY_SEQ, X.DG_CNTR_SEQ, X.POL_CLPT_IND_SEQ ,X.YD_CD," ).append("\n"); 
		query.append("                         X.CRR_CD, X.POD_CD, X.BLCK_STWG_CD,X.CNTR_TPSZ_CD, X.IMDG_UN_NO, X.IMDG_CLSS_CD," ).append("\n"); 
		query.append("                         X.MRN_POLUT_FLG,X.IMDG_LMT_QTY_FLG, X.IMDG_SUBS_RSK_LBL_CD1 , X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("         SELECT  DISTINCT B.BKG_NO, C.CNTR_NO, D.CBF_SPCL_SMRY_SEQ, D.DG_CNTR_SEQ, D.POL_CLPT_IND_SEQ ,D.YD_CD," ).append("\n"); 
		query.append("                         D.CRR_CD, D.POD_CD, D.BLCK_STWG_CD, D.CNTR_TPSZ_CD, C.IMDG_UN_NO, C.IMDG_CLSS_CD," ).append("\n"); 
		query.append("                         C.MRN_POLUT_FLG,C.IMDG_LMT_QTY_FLG, C.IMDG_SUBS_RSK_LBL_CD1 , D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD  " ).append("\n"); 
		query.append("                   FROM  BKG_VVD A,BKG_BOOKING B, BKG_DG_CGO C, DG_BKG D" ).append("\n"); 
		query.append("                  WHERE A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    AND A.POL_YD_CD        =  @[pol_cd]" ).append("\n"); 
		query.append("                    AND A.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                    AND A.VSL_CD     = D.VSL_CD" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND A.POL_YD_CD  = D.YD_CD" ).append("\n"); 
		query.append("                    AND A.POL_CLPT_IND_SEQ = D.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    AND A.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("                    AND B.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("                    AND D.CNTR_NO    = C.CNTR_NO " ).append("\n"); 
		query.append("                    AND D.CNTR_NO IS NOT NULL " ).append("\n"); 
		query.append("                    AND C.CNTR_NO IS NOT NULL " ).append("\n"); 
		query.append("                    AND D.DG_CNTR_SEQ = C.DG_CNTR_SEQ" ).append("\n"); 
		query.append("              ) X, BKG_DG_CGO Y" ).append("\n"); 
		query.append("                 WHERE  X.BKG_NO           = Y.BKG_NO" ).append("\n"); 
		query.append("                   AND  X.CNTR_NO          = Y.CNTR_NO " ).append("\n"); 
		query.append("                   AND  X.DG_CNTR_SEQ      = Y.DG_CNTR_SEQ  " ).append("\n"); 
		query.append("      UNION " ).append("\n"); 
		query.append("       SELECT DISTINCT X.BKG_NO,X.CNTR_NO, X.CBF_SPCL_SMRY_SEQ, X.DG_CNTR_SEQ, X.POL_CLPT_IND_SEQ ,X.YD_CD," ).append("\n"); 
		query.append("                         X.CRR_CD, X.POD_CD, X.BLCK_STWG_CD,X.CNTR_TPSZ_CD, X.IMDG_UN_NO, X.IMDG_CLSS_CD," ).append("\n"); 
		query.append("                         X.MRN_POLUT_FLG,X.IMDG_LMT_QTY_FLG, X.IMDG_SUBS_RSK_LBL_CD1 , X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD" ).append("\n"); 
		query.append("        FROM (   SELECT  DISTINCT B.BKG_NO, C.CNTR_NO, D.CBF_SPCL_SMRY_SEQ, D.DG_CNTR_SEQ, D.POL_CLPT_IND_SEQ ,D.YD_CD," ).append("\n"); 
		query.append("                         D.CRR_CD, D.POD_CD, D.BLCK_STWG_CD, D.CNTR_TPSZ_CD, C.IMDG_UN_NO, C.IMDG_CLSS_CD," ).append("\n"); 
		query.append("                         C.MRN_POLUT_FLG,C.IMDG_LMT_QTY_FLG, C.IMDG_SUBS_RSK_LBL_CD1 , D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD  " ).append("\n"); 
		query.append("                   FROM  BKG_VVD A,BKG_BOOKING B, BKG_DG_CGO C, DG_BKG D" ).append("\n"); 
		query.append("                  WHERE A.VSL_CD     = @[vsl_cd]       " ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = @[skd_voy_no]   " ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD = @[skd_dir_cd]   " ).append("\n"); 
		query.append("                    AND A.POL_YD_CD        =  @[pol_cd]" ).append("\n"); 
		query.append("                    AND A.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                    AND A.VSL_CD     = D.VSL_CD" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND A.POL_YD_CD  = D.YD_CD" ).append("\n"); 
		query.append("                    AND A.POL_CLPT_IND_SEQ = D.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    AND A.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("                    AND B.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("                    AND B.BKG_NO     = D.BKG_NO" ).append("\n"); 
		query.append("                    AND D.CNTR_NO IS  NULL " ).append("\n"); 
		query.append("                    AND C.CNTR_NO IS  NULL " ).append("\n"); 
		query.append("                    AND C.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    AND D.DG_CNTR_SEQ  = C.DG_CNTR_SEQ" ).append("\n"); 
		query.append("              ) X, BKG_DG_CGO Y" ).append("\n"); 
		query.append("         WHERE  X.BKG_NO           = Y.BKG_NO" ).append("\n"); 
		query.append("           AND  X.CNTR_TPSZ_CD     = Y.CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("           AND  X.DG_CNTR_SEQ      = Y.DG_CNTR_SEQ" ).append("\n"); 
		query.append(" UNION " ).append("\n"); 
		query.append("      SELECT  DISTINCT XX.BKG_NO, XX.CNTR_NO, XX.CBF_SPCL_SMRY_SEQ, XX.DG_CNTR_SEQ, XX.POL_CLPT_IND_SEQ ,XX.YD_CD," ).append("\n"); 
		query.append("                         XX.CRR_CD, XX.POD_CD, XX.BLCK_STWG_CD, XX.CNTR_TPSZ_CD, XX.IMDG_UN_NO, XX.IMDG_CLSS_CD," ).append("\n"); 
		query.append("                         XX.MRN_POLUT_FLG,XX.IMDG_LMT_QTY_FLG, XX.IMDG_SUBS_RSK_LBL_CD1 , XX.VSL_CD, XX.SKD_VOY_NO,XX.SKD_DIR_CD  " ).append("\n"); 
		query.append("        FROM (   SELECT BB.BKG_NO, BB.CNTR_NO, BB.CNTR_TPSZ_CD, BB.IMDG_UN_NO, BB.IMDG_CLSS_CD, BB.IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                        BB.IMDG_LMT_QTY_FLG, BB.IMDG_EXPT_QTY_FLG, BB.MRN_POLUT_FLG," ).append("\n"); 
		query.append("                        AA.CBF_SPCL_SMRY_SEQ,AA.VSL_CD, AA.SKD_VOY_NO, AA.SKD_DIR_CD, AA.BLCK_STWG_CD, AA.POD_CD, AA.CRR_CD," ).append("\n"); 
		query.append("                        AA.DG_CNTR_SEQ, AA.POL_CLPT_IND_SEQ , AA.YD_CD" ).append("\n"); 
		query.append("                 FROM (   SELECT Y.BKG_NO, X.CNTR_TPSZ_CD , X.CBF_SPCL_SMRY_SEQ ,X.IMDG_UN_NO, X.IMDG_CLSS_CD ,X.VSL_CD, X.SKD_VOY_NO, " ).append("\n"); 
		query.append("                                 X.SKD_DIR_CD, X.BLCK_STWG_CD, X.POD_CD, X.CRR_CD,X.DG_CNTR_SEQ, X.POL_CLPT_IND_SEQ , X.YD_CD" ).append("\n"); 
		query.append("                            FROM SPLIT_BKG X, BKG_BOOKING Y" ).append("\n"); 
		query.append("                           WHERE ( X.BKG_NO = Y.FM_BKG_NO OR X.BKG_NO = Y.BKG_NO)" ).append("\n"); 
		query.append("                       ) AA, BKG_DG_CGO BB" ).append("\n"); 
		query.append("       WHERE AA.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("         AND AA.CNTR_TPSZ_CD = BB.CNTR_TPSZ_CD ) XX, " ).append("\n"); 
		query.append("         (  SELECT BB.BKG_NO, BB.CNTR_NO, BB.CNTR_TPSZ_CD, BB.IMDG_UN_NO, BB.IMDG_CLSS_CD, BB.IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                   BB.IMDG_LMT_QTY_FLG, BB.IMDG_EXPT_QTY_FLG, AA.CBF_SPCL_SMRY_SEQ" ).append("\n"); 
		query.append("             FROM (   SELECT Y.BKG_NO, X.CNTR_TPSZ_CD , X.CBF_SPCL_SMRY_SEQ ,X.IMDG_UN_NO, X.IMDG_CLSS_CD  " ).append("\n"); 
		query.append("                        FROM SPLIT_BKG X, BKG_BOOKING Y" ).append("\n"); 
		query.append("                       WHERE ( X.BKG_NO = Y.FM_BKG_NO OR X.BKG_NO = Y.BKG_NO) ) AA, BKG_DG_CGO BB" ).append("\n"); 
		query.append("            WHERE AA.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("              AND AA.CNTR_TPSZ_CD = BB.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("              AND AA.IMDG_UN_NO   = BB.IMDG_UN_NO" ).append("\n"); 
		query.append("              AND AA.IMDG_CLSS_CD = BB.IMDG_CLSS_CD ) YY" ).append("\n"); 
		query.append("    WHERE XX.CNTR_NO = YY.CNTR_NO" ).append("\n"); 
		query.append(" ) Z )" ).append("\n"); 

	}
}