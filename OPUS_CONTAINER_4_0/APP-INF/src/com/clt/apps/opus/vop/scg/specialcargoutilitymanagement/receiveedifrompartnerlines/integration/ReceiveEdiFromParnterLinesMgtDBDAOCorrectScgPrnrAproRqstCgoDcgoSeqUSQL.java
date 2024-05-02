/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOCorrectScgPrnrAproRqstCgoDcgoSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOCorrectScgPrnrAproRqstCgoDcgoSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DCGO_SEQ 일괄생성 및 보정
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOCorrectScgPrnrAproRqstCgoDcgoSeqUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOCorrectScgPrnrAproRqstCgoDcgoSeqUSQL").append("\n"); 
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
		query.append("MERGE INTO  SCG_PRNR_APRO_RQST_CGO  XX" ).append("\n"); 
		query.append("USING       (" ).append("\n"); 
		query.append("            --=========================================================" ).append("\n"); 
		query.append("            --=========================================================" ).append("\n"); 
		query.append("            SELECT   X.CRR_CD" ).append("\n"); 
		query.append("                  ,  X.BKG_REF_NO" ).append("\n"); 
		query.append("                  ,  X.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                  ,  X.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                  ,  X.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                  ,  X.CGO_OPR_CD" ).append("\n"); 
		query.append("                  ,  X.VSL_CD" ).append("\n"); 
		query.append("                  ,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,  X.POL_CD" ).append("\n"); 
		query.append("                  ,  X.POD_CD" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("                  ,  X.CNTR_REF_NO" ).append("\n"); 
		query.append("                  ,  X.DCGO_REF_NO" ).append("\n"); 
		query.append("                  ,  X.DCGO_SEQ" ).append("\n"); 
		query.append("                  ,  X.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("                  ,  X.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  ,  X.DCGO_EXIST_YN" ).append("\n"); 
		query.append("				  ,	 X.PRE_DCGO_SEQ" ).append("\n"); 
		query.append("                  ,  X.PRE_MAX_DCGO_SEQ" ).append("\n"); 
		query.append("                  ,  CASE WHEN X.DCGO_EXIST_YN = 'Y' THEN X.PRE_DCGO_SEQ" ).append("\n"); 
		query.append("                          WHEN X.DCGO_EXIST_YN = 'N' THEN X.PRE_MAX_DCGO_SEQ + ROWNUM" ).append("\n"); 
		query.append("                     END  AS NEW_DCGO_SEQ" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                  ,  ROWNUM" ).append("\n"); 
		query.append("            FROM     (" ).append("\n"); 
		query.append("                      --===============================================================================================" ).append("\n"); 
		query.append("                      SELECT   XX.*" ).append("\n"); 
		query.append("							,  YY.PRE_DCGO_SEQ" ).append("\n"); 
		query.append("                            ,  CASE --:2015-11-09:--WHEN XX.CNTR_REF_NO = YY.CNTR_REF_NO AND XX.DCGO_REF_NO = YY.DCGO_REF_NO THEN 'Y' " ).append("\n"); 
		query.append("                                    WHEN XX.DCGO_REF_NO = YY.DCGO_REF_NO THEN 'Y' " ).append("\n"); 
		query.append("                                    WHEN YY.CNTR_REF_NO IS NULL          THEN 'N'" ).append("\n"); 
		query.append("                               END       AS DCGO_EXIST_YN " ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("                            ,  (SELECT  MAX(T2.DCGO_SEQ)" ).append("\n"); 
		query.append("                                FROM    SCG_PRNR_APRO_RQST     T1" ).append("\n"); 
		query.append("                                      , SCG_PRNR_APRO_RQST_CGO T2" ).append("\n"); 
		query.append("                                WHERE   T1.CRR_CD              = T2.CRR_CD" ).append("\n"); 
		query.append("                                AND     T1.BKG_REF_NO          = T2.BKG_REF_NO" ).append("\n"); 
		query.append("                                AND     T1.SPCL_CGO_RQST_SEQ   = T2.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                AND     T1.PRNR_CGO_RQST_SEQ   = T2.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                AND     T1.CRR_CD              = XX.CRR_CD" ).append("\n"); 
		query.append("                                AND     T1.BKG_REF_NO          = XX.BKG_REF_NO                    " ).append("\n"); 
		query.append("                                AND     T1.LST_RQST_DAT_FLG    = 'N'" ).append("\n"); 
		query.append("                                AND     T2.CGO_OPR_CD          = XX.CGO_OPR_CD" ).append("\n"); 
		query.append("                                AND     T1.VSL_CD              = XX.VSL_CD" ).append("\n"); 
		query.append("                                AND     T1.SKD_VOY_NO          = XX.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND     T1.SKD_DIR_CD          = XX.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND     T1.POL_CD              = XX.POL_CD" ).append("\n"); 
		query.append("                                AND     T1.POD_CD              = XX.POD_CD" ).append("\n"); 
		query.append("                                AND     T1.SPCL_CGO_RQST_SEQ   = (SELECT   MAX(T1.SPCL_CGO_RQST_SEQ)     " ).append("\n"); 
		query.append("                                                                    FROM     SCG_PRNR_APRO_RQST      T11" ).append("\n"); 
		query.append("                                                                          ,  SCG_PRNR_APRO_RQST_CGO  T21" ).append("\n"); 
		query.append("                                                                    WHERE    T11.CRR_CD               = T21.CRR_CD" ).append("\n"); 
		query.append("                                                                    AND      T11.BKG_REF_NO           = T21.BKG_REF_NO" ).append("\n"); 
		query.append("                                                                    AND      T11.SPCL_CGO_RQST_SEQ    = T21.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                    AND      T11.PRNR_CGO_RQST_SEQ    = T21.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                    AND      T21.SPCL_CGO_CATE_CD     = T2.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                                                                    AND      T11.CRR_CD               = T1.CRR_CD" ).append("\n"); 
		query.append("                                                                    AND      T11.BKG_REF_NO           = T1.BKG_REF_NO" ).append("\n"); 
		query.append("                                                                    AND      T21.CGO_OPR_CD           = T2.CGO_OPR_CD " ).append("\n"); 
		query.append("                                                                    AND      T11.VSL_CD               = T1.VSL_CD" ).append("\n"); 
		query.append("                                                                    AND      T11.SKD_VOY_NO           = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                    AND      T11.SKD_DIR_CD           = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                    AND      T11.POL_CD               = T1.POL_CD" ).append("\n"); 
		query.append("                                                                    AND      T11.POD_CD               = T1.POD_CD" ).append("\n"); 
		query.append("                                                                    AND      T11.LST_RQST_DAT_FLG     = T1.LST_RQST_DAT_FLG" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                                )       AS PRE_MAX_DCGO_SEQ                " ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                      FROM     (" ).append("\n"); 
		query.append("                               --------------- <CURRENT DG DATA> -------------------------------" ).append("\n"); 
		query.append("                                SELECT   X.CRR_CD" ).append("\n"); 
		query.append("                                      ,  X.BKG_REF_NO" ).append("\n"); 
		query.append("                                      ,  X.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                      ,  X.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                      ,  Y.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                                      ,  Y.CGO_OPR_CD" ).append("\n"); 
		query.append("                                      ,  X.VSL_CD" ).append("\n"); 
		query.append("                                      ,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,  X.POL_CD" ).append("\n"); 
		query.append("                                      ,  X.POD_CD" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("                                      ,  Y.CNTR_REF_NO" ).append("\n"); 
		query.append("                                      ,  Y.DCGO_REF_NO" ).append("\n"); 
		query.append("                                      ,  Y.DCGO_SEQ	" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("                                      ,  Y.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("                                      ,  Y.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                FROM     SCG_PRNR_APRO_RQST      X" ).append("\n"); 
		query.append("                                      ,  SCG_PRNR_APRO_RQST_CGO  Y" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      X.CRR_CD                = Y.CRR_CD" ).append("\n"); 
		query.append("                                AND      X.BKG_REF_NO            = Y.BKG_REF_NO" ).append("\n"); 
		query.append("                                AND      X.SPCL_CGO_RQST_SEQ     = Y.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                AND      X.PRNR_CGO_RQST_SEQ     = Y.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                AND      Y.SPCL_CGO_CATE_CD      = 'DG'" ).append("\n"); 
		query.append("                                AND      X.LST_RQST_DAT_FLG      = 'Y'" ).append("\n"); 
		query.append("                                AND      X.CRR_CD                = @[crr_cd]" ).append("\n"); 
		query.append("                                AND      X.BKG_REF_NO            = @[bkg_ref_no]" ).append("\n"); 
		query.append("                                AND      Y.CGO_OPR_CD            = @[cgo_opr_cd]" ).append("\n"); 
		query.append("                                AND      X.VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("                                AND      X.SKD_VOY_NO            = @[skd_voy_no]" ).append("\n"); 
		query.append("                                AND      X.SKD_DIR_CD            = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                AND      X.POL_CD                = @[pol_cd]" ).append("\n"); 
		query.append("                                AND      X.POD_CD                = @[pod_cd]" ).append("\n"); 
		query.append("                               --------------- <CURRENT DG DATA> --------------------------------" ).append("\n"); 
		query.append("                               ) XX" ).append("\n"); 
		query.append("                            ,  (" ).append("\n"); 
		query.append("                               --------------- <PREVIOUS DG DATA> -------------------------------" ).append("\n"); 
		query.append("                                SELECT   X.CRR_CD" ).append("\n"); 
		query.append("                                      ,  X.BKG_REF_NO" ).append("\n"); 
		query.append("                                      ,  X.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                      ,  X.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                      ,  Y.SPCL_CGO_CATE_CD                " ).append("\n"); 
		query.append("                                      ,  Y.CGO_OPR_CD" ).append("\n"); 
		query.append("                                      ,  X.VSL_CD" ).append("\n"); 
		query.append("                                      ,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,  X.POL_CD" ).append("\n"); 
		query.append("                                      ,  X.POD_CD" ).append("\n"); 
		query.append("                                                      " ).append("\n"); 
		query.append("                                      ,  Y.CNTR_REF_NO" ).append("\n"); 
		query.append("                                      ,  Y.DCGO_REF_NO" ).append("\n"); 
		query.append("                                      ,  Y.DCGO_SEQ         	 AS PRE_DCGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                      ,  Y.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("                                      ,  Y.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                FROM     SCG_PRNR_APRO_RQST      X" ).append("\n"); 
		query.append("                                      ,  SCG_PRNR_APRO_RQST_CGO  Y" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      X.CRR_CD                = Y.CRR_CD" ).append("\n"); 
		query.append("                                AND      X.BKG_REF_NO            = Y.BKG_REF_NO" ).append("\n"); 
		query.append("                                AND      X.SPCL_CGO_RQST_SEQ     = Y.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                AND      X.PRNR_CGO_RQST_SEQ     = Y.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                AND      Y.SPCL_CGO_CATE_CD      = 'DG'" ).append("\n"); 
		query.append("                                AND      X.LST_RQST_DAT_FLG      = 'N'" ).append("\n"); 
		query.append("                                AND      X.CRR_CD                = @[crr_cd]" ).append("\n"); 
		query.append("                                AND      X.BKG_REF_NO            = @[bkg_ref_no]" ).append("\n"); 
		query.append("                                AND      Y.CGO_OPR_CD            = @[cgo_opr_cd]" ).append("\n"); 
		query.append("                                AND      X.VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("                                AND      X.SKD_VOY_NO            = @[skd_voy_no]" ).append("\n"); 
		query.append("                                AND      X.SKD_DIR_CD            = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                AND      X.POL_CD                = @[pol_cd]" ).append("\n"); 
		query.append("                                AND      X.POD_CD                = @[pod_cd]" ).append("\n"); 
		query.append("                                AND      X.SPCL_CGO_RQST_SEQ     = (SELECT   MAX(T1.SPCL_CGO_RQST_SEQ)     " ).append("\n"); 
		query.append("                                                                    FROM     SCG_PRNR_APRO_RQST      T1" ).append("\n"); 
		query.append("                                                                          ,  SCG_PRNR_APRO_RQST_CGO  T2" ).append("\n"); 
		query.append("                                                                    WHERE    T1.CRR_CD               = T2.CRR_CD" ).append("\n"); 
		query.append("                                                                    AND      T1.BKG_REF_NO           = T2.BKG_REF_NO" ).append("\n"); 
		query.append("                                                                    AND      T1.SPCL_CGO_RQST_SEQ    = T2.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                    AND      T1.PRNR_CGO_RQST_SEQ    = T2.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                    AND      T2.SPCL_CGO_CATE_CD     = Y.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                                                                    AND      T1.CRR_CD               = X.CRR_CD" ).append("\n"); 
		query.append("                                                                    AND      T1.BKG_REF_NO           = X.BKG_REF_NO" ).append("\n"); 
		query.append("                                                                    AND      T2.CGO_OPR_CD           = Y.CGO_OPR_CD " ).append("\n"); 
		query.append("                                                                    AND      T1.VSL_CD               = X.VSL_CD" ).append("\n"); 
		query.append("                                                                    AND      T1.SKD_VOY_NO           = X.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                    AND      T1.SKD_DIR_CD           = X.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                    AND      T1.POL_CD               = X.POL_CD" ).append("\n"); 
		query.append("                                                                    AND      T1.POD_CD               = X.POD_CD" ).append("\n"); 
		query.append("                                                                    AND      T1.LST_RQST_DAT_FLG     = X.LST_RQST_DAT_FLG" ).append("\n"); 
		query.append("																	" ).append("\n"); 
		query.append("																	/* ADDING 2015-11-26 */" ).append("\n"); 
		query.append("																	AND      T2.AUTH_STS_CD          IN ('Y','N')" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                               --------------- <PREVIOUS DG DATA> -------------------------------" ).append("\n"); 
		query.append("                               ) YY" ).append("\n"); 
		query.append("                      WHERE    XX.CRR_CD                         = YY.CRR_CD           (+)" ).append("\n"); 
		query.append("                      AND      XX.BKG_REF_NO                     = YY.BKG_REF_NO       (+)" ).append("\n"); 
		query.append("                      AND      XX.CGO_OPR_CD                     = YY.CGO_OPR_CD       (+)" ).append("\n"); 
		query.append("                      AND      XX.SPCL_CGO_CATE_CD               = YY.SPCL_CGO_CATE_CD (+)" ).append("\n"); 
		query.append("                      AND      XX.VSL_CD                         = YY.VSL_CD           (+)" ).append("\n"); 
		query.append("                      AND      XX.SKD_VOY_NO                     = YY.SKD_VOY_NO       (+)" ).append("\n"); 
		query.append("                      AND      XX.SKD_DIR_CD                     = YY.SKD_DIR_CD       (+)" ).append("\n"); 
		query.append("                      AND      XX.POL_CD                         = YY.POL_CD           (+)" ).append("\n"); 
		query.append("                      AND      XX.POD_CD                         = YY.POD_CD           (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      --:2015-11-09:--AND      XX.CNTR_REF_NO                    = YY.CNTR_REF_NO      (+)" ).append("\n"); 
		query.append("                      AND      XX.DCGO_REF_NO                    = YY.DCGO_REF_NO      (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      AND      XX.SPCL_CNTR_SEQ                  = YY.SPCL_CNTR_SEQ    (+)" ).append("\n"); 
		query.append("                      AND      XX.SPCL_CGO_SEQ                   = YY.SPCL_CGO_SEQ     (+)" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      ORDER BY CASE --:2015-11-09:--WHEN XX.CNTR_REF_NO = YY.CNTR_REF_NO AND XX.DCGO_REF_NO = YY.DCGO_REF_NO THEN 'Y' " ).append("\n"); 
		query.append("                                    WHEN XX.DCGO_REF_NO = YY.DCGO_REF_NO THEN 'Y' " ).append("\n"); 
		query.append("                                    WHEN YY.CNTR_REF_NO IS NULL          THEN 'N'" ).append("\n"); 
		query.append("                               END  ASC" ).append("\n"); 
		query.append("                      --===============================================================================================" ).append("\n"); 
		query.append("                      ) X" ).append("\n"); 
		query.append("            --=========================================================" ).append("\n"); 
		query.append("            --=========================================================" ).append("\n"); 
		query.append("            ) YY" ).append("\n"); 
		query.append("ON          (" ).append("\n"); 
		query.append("            XX.CRR_CD               = YY.CRR_CD" ).append("\n"); 
		query.append("   AND      XX.BKG_REF_NO           = YY.BKG_REF_NO" ).append("\n"); 
		query.append("   AND      XX.SPCL_CGO_RQST_SEQ    = YY.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("   AND      XX.PRNR_CGO_RQST_SEQ    = YY.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("   AND      XX.SPCL_CNTR_SEQ        = YY.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("   AND      XX.SPCL_CGO_SEQ         = YY.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("            )      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("   UPDATE   SET " ).append("\n"); 
		query.append("            XX.DCGO_SEQ             = YY.NEW_DCGO_SEQ" ).append("\n"); 

	}
}